package base;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;

import java.util.concurrent.TimeUnit;

public class CommonAPI {
public static WebDriver driver;
    /**
     * @param browser  the browser you want to execute your test case
     * @param platform in the operating system you want to execute your test case
     * @param url      the website url you want to launch
     * @return WebDriver Object
     */
    public static WebDriver setDriver(String browser, String platform, String url) {
        ChromeOptions chromeoptions = new ChromeOptions();
        chromeoptions.addArguments("....Disable-infobars");
        if (platform.equalsIgnoreCase("windows") && browser.equalsIgnoreCase("chrome")) {
            System.setProperty("webdriver.chrome.driver", "../Generic/src/main/resources/chromedriver.exe");
            driver = new ChromeDriver(chromeoptions);
        } else if (platform.equalsIgnoreCase("mac") && browser.equalsIgnoreCase("chrome")) {
            System.setProperty("webdriver.chrome.driver", "../Generic/src/main/resources/chromedriver");
            driver = new ChromeDriver(chromeoptions);
        } else if (platform.equalsIgnoreCase("windows") && browser.equalsIgnoreCase("firefox")) {
            System.setProperty("webdriver.gecko.driver", "../Generic/src/main/resources/geckodriver.exe");
            driver = new FirefoxDriver();
        } else if (platform.equalsIgnoreCase("mac") && browser.equalsIgnoreCase("firefox")) {
            System.setProperty("webdriver.gecko.driver", "../Generic/src/main/resources/geckodriver");
            driver = new FirefoxDriver();
        }
        driver.get(url);
        driver.manage().timeouts().pageLoadTimeout(5, TimeUnit.SECONDS);
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);//TO get rid of "NoSuchElementException" due to synchronization issue
        driver.manage().window().maximize();
        return driver;
    }
    @Parameters({"platform", "url", "browser", "browserVersion"})
    @BeforeMethod
    public static WebDriver getDriver(String platform, String url, String browser,
                                      String browserVersion) {
        driver = setDriver(browser, platform, url);
        driver.get(url);
        return driver;
    }
    @AfterMethod
    public void cleanUp() {
        driver.close();
        driver.quit();
    }
}
