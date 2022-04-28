package Test;

import PageObjects.HomePage;
import PageObjects.Loginpage;

import PreRequisites.BaseClass;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;
import java.time.Duration;


public class LoginTest extends BaseClass {

    HomePage home;
    Loginpage login;

    @Test(priority = 1)
    // Test to validate successful employee login
    public void validateEmployeeLogin() {
        OpenDriver(properties.getProperty("url"));
        home = new HomePage(driver);
        home.clickLogin();

        LoginUser(properties.getProperty("login_emp_username"),properties.getProperty("login_password"),role[0]);
        new WebDriverWait(driver, Duration.ofSeconds(10)).until(ExpectedConditions.elementToBeClickable(Loginpage.dashboard));
        String dashboard = login.loginDashboard();
        Assert.assertEquals(properties.getProperty("employeeDashboard"),dashboard);
        login.logout();
    }

    @Test(priority = 2)
    // Test to validate successful admin login
    public void validateAdminLogin()  {
        home = new HomePage(driver);
        home.clickLogin();
        LoginUser(properties.getProperty("login_admin_username"),properties.getProperty("login_password"),role[1]);
        new WebDriverWait(driver, Duration.ofSeconds(10)).until(ExpectedConditions.elementToBeClickable(Loginpage.dashboard));
        String dashboard = login.loginDashboard();
        Assert.assertEquals(properties.getProperty("adminDashboard"),dashboard);

        login.logout();
    }

    @Test(priority = 3)
    // Test to validate successful organization login
    public void validateOrganizationLogin(){
        home = new HomePage(driver);
        home.clickLogin();
        LoginUser(properties.getProperty("login_org_username"),properties.getProperty("login_password"),role[2]);
        new WebDriverWait(driver, Duration.ofSeconds(10)).until(ExpectedConditions.elementToBeClickable(Loginpage.dashboard));
        String dashboard = login.loginDashboard();
        Assert.assertEquals(properties.getProperty("organizationDashboard"),dashboard);

        login.logout();
    }

    @Test(priority = 4)
    // Test to validate unsuccessful employee login
    public void inValidateEmployeeLogin() {
        home = new HomePage(driver);
        home.clickLogin();
        LoginUser(properties.getProperty("inValid_user_name"),properties.getProperty("login_password"),role[0]);
        String errorMessage = login.errorMessage();
        Assert.assertEquals(properties.getProperty("error"),errorMessage);
    }

    @Test(priority = 5)
    // Test to validate unsuccessful admin login
    public void inValidateAdminLogin() {
        login.clearUsername();
        login.clearPassword();
        LoginUser(properties.getProperty("inValid_user_name"),properties.getProperty("login_password"),role[1]);
        String errorMessage = login.errorMessage();
        Assert.assertEquals(properties.getProperty("error"),errorMessage);
    }

    @Test(priority = 6)
    // Test to validate unsuccessful organization login
    public void inValidateOrganizationLogin(){
        login.clearUsername();
        login.clearPassword();
        LoginUser(properties.getProperty("inValid_user_name"),properties.getProperty("login_password"),role[2]);
        String errorMessage = login.errorMessage();
        Assert.assertEquals(properties.getProperty("error"),errorMessage);
    }

    @Test(priority = 7)
    // Test to verify  error message by login as admin using employee credentials
    public void AdminLoginUsingEmployeeDetails()
    {
        login.clearUsername();
        login.clearPassword();
        LoginUser(properties.getProperty("login_emp_username"),properties.getProperty("login_password"),role[1]);
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        String errorMessage="";
        try{
            errorMessage = login.errorMessage();
        }catch (Exception e){
            Assert.assertEquals(properties.getProperty("error"),errorMessage);
        }
    }

    public void LoginUser(String Username, String Password, String Role){
        login = new Loginpage(driver);
        login.enterUsername(Username);
        login.enterPassword(Password);
        login.selectRole(Role);
        login.clickLogin();
    }
}