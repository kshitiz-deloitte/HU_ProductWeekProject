package Test;

import PageObjects.HomePage;
import PageObjects.OrganizationRegistrationPage;
import PreRequisites.BaseClass;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.NoAlertPresentException;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

// tests for Organization Registration Page
public class OrganizationRegistrationTest extends BaseClass {

    // declaring variable
    OrganizationRegistrationPage organizationRegistrationPage = null;
    WebElement button;

    // check url is opening or not
    @Test(priority = 1)
    public void checkUrlIsOpeningOrNot() {
        // open url
        OpenDriver(properties.getProperty("url"));
    }

    // check user is registering or not
    @Test(priority = 2)
    public void checkRegistration() throws Exception {
        HomePage home = new HomePage(driver);
        Thread.sleep(2000);
        // opening registration page
        organizationRegistrationPage = new OrganizationRegistrationPage(driver);
        button = home.organizationRegistrationButton();
        JavascriptExecutor executor = (JavascriptExecutor) driver;
        executor.executeScript("arguments[0].click();", button);
        Thread.sleep(2000);
        // setting data into registration form
        setOrganizationRegistrationDetails();
        // click registration button
        organizationRegistrationPage.pressRegister();
        // handling alert
        try {
            driver.switchTo().alert();
        } catch (NoAlertPresentException e) {
            // not pop up not registered
            Assert.fail("Not Registered Successfully");
        }
    }

    @Test(priority = 3)
    public void checkRegistrationFailedSuggestion() throws Exception {
        // refreshing web page
        driver.navigate().refresh();
        Thread.sleep(2000);
        // setting data into registration form
        setOrganizationRegistrationDetails();
        // click registration button
        organizationRegistrationPage.pressRegister();
        // handling alert
        try {
            driver.switchTo().alert();
        } catch (NoAlertPresentException e) {
            // No error alert pop uo
            Assert.fail("Not showing Error Alert");
        }
    }

    @Test(priority = 4)
    public void checkPasswordToggle() throws Exception {
        Thread.sleep(2000);
        // checking password toggle is working or not
        Assert.assertTrue(organizationRegistrationPage.password().isEnabled(), "Password toggle is not enabled");
        // clicking password visibility toggle
        organizationRegistrationPage.clickPasswordToggle();
    }

    // setting data from propertieserty file into registration page form
    public void setOrganizationRegistrationDetails() {
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