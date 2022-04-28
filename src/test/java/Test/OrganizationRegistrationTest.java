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
        setOrganizationRegistrationDetails(properties.getProperty("company_name"),properties.getProperty("company_pan"),properties.getProperty("company_gst"),properties.getProperty("industry")
                ,properties.getProperty("contact_email"),properties.getProperty("password"),properties.getProperty("contact_number"),properties.getProperty("address"));        // click registration button
        organizationRegistrationPage.pressRegister();
        Thread.sleep(2000);
        // handling alert
        try {
            driver.switchTo().alert().accept();
        } catch (NoAlertPresentException e) {
            // not pop up not registered
            Assert.fail("Not Registered Unsuccessfully");
        }
    }
    // check with already registered user
    @Test(priority = 3)
    public void checkRegistrationWithExistingData() throws Exception {
        Thread.sleep(2000);
        // Navigate back
        driver.navigate().back();
        // opening registration page
        organizationRegistrationPage = new OrganizationRegistrationPage(driver);
        Thread.sleep(2000);
        // setting data into registration form
        setOrganizationRegistrationDetails(properties.getProperty("company_name"),properties.getProperty("company_pan"),properties.getProperty("company_gst"),properties.getProperty("industry")
        ,properties.getProperty("contact_email"),properties.getProperty("password"),properties.getProperty("contact_number"),properties.getProperty("address"));
        // click registration button
        organizationRegistrationPage.pressRegister();
        Thread.sleep(2000);
        // handling alert
        try {
            driver.switchTo().alert();
        } catch (NoAlertPresentException e) {
            // not pop up not registered
            System.out.println("Not Registered Successfully");
        }
    }


    @Test(priority = 4)
    public void checkRegistrationFailedSuggestion() throws Exception {
        Thread.sleep(2000);
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
    // checking registration with Invalid Data Format
    @Test(priority = 5)
    public void checkRegistrationWithInvalidFormatData() throws Exception {
        Thread.sleep(2000);
        // refresh window
        driver.navigate().refresh();
        // opening registration page
        organizationRegistrationPage = new OrganizationRegistrationPage(driver);
        Thread.sleep(2000);
        // setting data into registration form
        setOrganizationRegistrationDetails(properties.getProperty("Invalid_company_name"), properties.getProperty("Invalid_company_pan"), properties.getProperty("Invalid_company_gst"), properties.getProperty("Invalid_industry")
                , properties.getProperty("Invalid_contact_email"), properties.getProperty("Invalid_password"), properties.getProperty("Invalid_contact_number"), properties.getProperty("Invalid_address"));
        // click registration button
        organizationRegistrationPage.pressRegister();
        Thread.sleep(2000);
        // handling alert
        try {
            driver.switchTo().alert().accept();
            Assert.fail("Invalid User Registered");
        } catch (NoAlertPresentException e) {
            // not pop up not registered
            System.out.println("Registered Successfully");
        }
    }
    // checking Password visibility toggle button
    @Test(priority = 6)
    public void checkPasswordToggle() throws Exception {
        Thread.sleep(2000);
        // checking password toggle is working or not
        Assert.assertTrue(organizationRegistrationPage.password().isEnabled(), "Password toggle is not enabled");
        // clicking password visibility toggle
        organizationRegistrationPage.clickPasswordToggle();
    }

    // setting data from properties file into registration page form
    public void setOrganizationRegistrationDetails(String  Name, String Pan, String Gst, String Industry, String Email, String Password, String Phone, String Address) {
        organizationRegistrationPage.setCompanyName(Name);
        organizationRegistrationPage.setCompanyPan(Pan);
        organizationRegistrationPage.setCompanyGst(Gst);
        organizationRegistrationPage.setIndustry(Industry);
        organizationRegistrationPage.setContactEmail(Email);
        organizationRegistrationPage.setPassword(Password);
        organizationRegistrationPage.setContactNumber(Phone);
        organizationRegistrationPage.setAddress(Address);
    }

}