package testPages;

import base.CommonAPI;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.QuotationPage;
import pages.QuotationResultPage;

public class TestQuotationForm extends CommonAPI {
    QuotationPage qp;
    QuotationResultPage qrp;
    @BeforeMethod
    public void setPage(){
        qp= PageFactory.initElements(driver, QuotationPage.class);
        qrp=PageFactory.initElements(driver, QuotationResultPage.class);
    }
    @Test
    public void validateQuotationForm(){
        qp.setZipcode("48212");
        qp.setGender(1);
        qp.setDOB("April","16","1971");
        qp.selectMembership();
        qp.setEmail("abc@test.com");
        qp.setHeight("5", "8");
        qp.setWeight("172");
        qp.certifyNicotineUseHistory("Never");
        qp.rateYourself("Excellent");
        qp.setCoverageAmount("100,000");
        qp.setTermLength(1);
        qp.validateSeeYourQuoteButton();
        qrp.getYourQuotation();
        qrp.getYourPremium();
    }

}
