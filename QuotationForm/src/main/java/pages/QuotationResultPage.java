package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.testng.Assert;

public class QuotationResultPage{
    @FindBy(css="#quote-results")
    WebElement yourQuotation;
    @FindBy(xpath = "//span[@class='summaryPremium']")
    WebElement yourPremium;

    public void getYourQuotation(){
        Assert.assertEquals(yourQuotation.isDisplayed(),true, "Quotation is not displayed");
    }
    public void getYourPremium(){
        System.out.println("Your summary premium is:"+" "+yourPremium.getText());
    }

}
