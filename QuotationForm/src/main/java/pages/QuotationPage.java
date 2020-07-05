package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;

public class QuotationPage{
    @FindBy(xpath = "//input[@id='zip']")
    WebElement zipcode;
    @FindBy(xpath = "//select[@id='gender']")
    WebElement gender;
    @FindBy(xpath = "//select[@id='month']")
    WebElement month;
    @FindBy(css = "#day")
    WebElement day;
    @FindBy(css = "#year")
    WebElement year;
    @FindBy(id = "isMemberYes")
    WebElement isAMember;
    @FindBy(id = "isMemberNo")
    WebElement notAMember;
    @FindBy(id = "contact_email")
    WebElement email;
    @FindBy(xpath = "//select[@id='feet']")
    WebElement heightFeetValue;
    @FindBy(css = "#inches")
    WebElement heightInchValue;
    @FindBy(id="weight")
    WebElement weight;
    @FindBy(xpath = "//select[@id='nicotineUse']")
    WebElement nicotineUse;
    @FindBy(xpath = "//select[@id='rateYourHealth']")
    WebElement rateYourHealth;
    @FindBy (xpath = "//select[@id='coverageAmount']")
    WebElement coverageAmount;
    @FindBy (css = "#termLength")
    WebElement termLength;
    @FindBy(id = "seeQuote")
    WebElement seeYourQuote;

    public  void setZipcode(String zip){
        zipcode.click();
        zipcode.sendKeys(zip);
    }
    public void setGender(Integer genderValue){
        Select select = new Select(gender);
        select.selectByIndex(genderValue);
          }
    public void setDOB(String birthMonth, String birthDate, String birthYear){
        Select mm = new Select(month);
        mm.selectByVisibleText(birthMonth);
        Select dd = new Select(day);
        dd.selectByVisibleText(birthDate);
        Select yy = new Select(year);
        yy.selectByVisibleText(birthYear);
    }
    public void selectMembership(){
        isAMember.click();
        notAMember.click();
    }
    public void setEmail(String emailId) {
        email.click();
        email.sendKeys(emailId);
    }
    public void setHeight(String feetValue, String inchValue){
        Select ft = new Select(heightFeetValue);
       ft.selectByVisibleText(feetValue);
       Select inch = new Select(heightInchValue);
       inch.selectByVisibleText(inchValue);
    }
    public void setWeight(String bodyWeight){
        weight.click();
        weight.sendKeys(bodyWeight);
    }
    public void certifyNicotineUseHistory(String nicotineHistory){
       Select nicotine = new Select(nicotineUse);
       nicotine.selectByVisibleText(nicotineHistory);
    }
    public void rateYourself(String selfRating){
        Select healthCondition= new Select(rateYourHealth);
        healthCondition.selectByVisibleText(selfRating);
    }
    public void setCoverageAmount(String dollarAmount){
        Select amount = new Select(coverageAmount);
        amount.selectByValue(dollarAmount);
    }
    public void setTermLength(int yearsCount){
        Select term = new Select(termLength);
        term.selectByIndex(yearsCount);
    }
    public void validateSeeYourQuoteButton(){
        seeYourQuote.click();
    }

}
