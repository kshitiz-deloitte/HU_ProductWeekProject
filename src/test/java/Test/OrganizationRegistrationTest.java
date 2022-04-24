package Test;

import PageObjects.OrganizationRegistrationPage;
import PreRequisites.BaseClass;
import org.openqa.selenium.NoAlertPresentException;
import org.testng.Assert;
import org.testng.annotations.Test;
public class OrganizationRegistrationTest extends BaseClass {

    OrganizationRegistrationPage organizationRegistrationPage=null;

    @Test(priority = 1)
    public void checkUrlIsOpeningOrNot(){
        OpenDriver(properties.getProperty("url"));
        driver.close();
    }
    @Test(priority = 2)
    public void checkRegistrationFailedSuggestion() throws Exception {
        OpenDriver(properties.getProperty("organization_registration_url"));
        organizationRegistrationPage= new OrganizationRegistrationPage(driver);
        Thread.sleep(2000);
        setOrganizationRegistrationDetails();
        organizationRegistrationPage.pressRegister();
        try {
            driver.switchTo().alert();
        }
        catch (NoAlertPresentException e){
            Assert.fail("Not Showing Any Error Message");
        }
    }
    @Test(priority = 3)
    public void checkPasswordToggle() throws Exception {
        Thread.sleep(2000);
        organizationRegistrationPage.clickPasswordToggle();
        Assert.assertTrue(organizationRegistrationPage.password().isEnabled(),"Password toggle is not enabled");
    }


    public void setOrganizationRegistrationDetails(){
        organizationRegistrationPage.setCompanyName(properties.getProperty("company_name"));
        organizationRegistrationPage.setCompanyPan(properties.getProperty("company_pan"));
        organizationRegistrationPage.setCompanyGst(properties.getProperty("company_gst"));
        organizationRegistrationPage.setIndustry(properties.getProperty("industry"));
        organizationRegistrationPage.setContactEmail(properties.getProperty("contact_email"));
        organizationRegistrationPage.setPassword(properties.getProperty("password"));
        organizationRegistrationPage.setContactNumber(properties.getProperty("contact_number"));
        organizationRegistrationPage.setAddress(properties.getProperty("address"));
    }
}
