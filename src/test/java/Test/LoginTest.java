package Test;

import PageObjects.HomePage;
import PageObjects.Loginpage;

import PreRequisites.BaseClass;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
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

        login = new Loginpage(driver);
        login.enterUsername(properties.getProperty("login_emp_username"));
        login.enterPassword(properties.getProperty("login_password"));
        login.selectRole(role[0]);
        login.clickLogin();
        new WebDriverWait(driver, Duration.ofSeconds(10)).until(ExpectedConditions.elementToBeClickable(login.dashboard));
        String dashboard = login.loginDashboard();
        Assert.assertEquals(properties.getProperty("employeeDashboard"),dashboard);

        login.logout();
    }

    @Test(priority = 2)
    // Test to validate successful admin login
    public void validateAdminLogin()  {
        home = new HomePage(driver);
        home.clickLogin();

        login = new Loginpage(driver);
        login.enterUsername(properties.getProperty("login_admin_username"));
        login.enterPassword(properties.getProperty("login_password"));
        login.selectRole(role[1]);
        login.clickLogin();
        new WebDriverWait(driver, Duration.ofSeconds(10)).until(ExpectedConditions.elementToBeClickable(login.dashboard));
        String dashboard = login.loginDashboard();
        Assert.assertEquals(properties.getProperty("adminDashboard"),dashboard);

        login.logout();
    }

    @Test(priority = 3)
    // Test to validate successful organization login
    public void validateOrganizationLogin(){
        home = new HomePage(driver);
        home.clickLogin();

        login = new Loginpage(driver);
        login.enterUsername(properties.getProperty("login_org_username"));
        login.enterPassword(properties.getProperty("login_password"));
        login.selectRole(role[2]);
        login.clickLogin();
        new WebDriverWait(driver, Duration.ofSeconds(10)).until(ExpectedConditions.elementToBeClickable(login.dashboard));
        String dashboard = login.loginDashboard();
        Assert.assertEquals(properties.getProperty("organizationDashboard"),dashboard);

        login.logout();
    }

    @Test(priority = 4)
    // Test to validate unsuccessful employee login
    public void inValidateEmployeeLogin() {
        home = new HomePage(driver);
        home.clickLogin();

        login = new Loginpage(driver);
        login.enterUsername(properties.getProperty("inValid_user_name"));
        login.enterPassword(properties.getProperty("login_password"));
        login.selectRole(role[0]);
        login.clickLogin();
        String errorMessage = login.errorMessage();
        Assert.assertEquals(properties.getProperty("error"),errorMessage);
    }

    @Test(priority = 5)
    // Test to validate unsuccessful admin login
    public void inValidateAdminLogin() {

        login = new Loginpage(driver);
        login.clearUsername();
        login.clearPassword();
        login.enterUsername(properties.getProperty("inValid_user_name"));
        login.enterPassword(properties.getProperty("login_password"));
        login.selectRole(role[1]);
        login.clickLogin();
        String errorMessage = login.errorMessage();
        Assert.assertEquals(properties.getProperty("error"),errorMessage);
    }

    @Test(priority = 6)
    // Test to validate unsuccessful organization login
    public void inValidateOrganizationLogin(){

        login = new Loginpage(driver);
        login.clearUsername();
        login.clearPassword();
        login.enterUsername(properties.getProperty("inValid_user_name"));
        login.enterPassword(properties.getProperty("login_password"));
        login.selectRole(role[2]);
        login.clickLogin();
        String errorMessage = login.errorMessage();
        Assert.assertEquals(properties.getProperty("error"),errorMessage);
    }

    @Test(priority = 7)
    // Test to verify  error message by login as admin using employee credentials
    public void AdminLoginUsingEmployeeDetails()
    {
        login = new Loginpage(driver);
        login.clearUsername();
        login.clearPassword();
        login.enterUsername(properties.getProperty("login_emp_username"));
        login.enterPassword(properties.getProperty("login_password"));
        login.selectRole(role[1]);
        login.clickLogin();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        String errorMessage = login.errorMessage();
        Assert.assertEquals(properties.getProperty("error"),errorMessage);
    }

    @Test(priority = 8)
    // Test to validate employee login by select remember me option and visit same url again
    public void LoginWithRemember()
    {
        login = new Loginpage(driver);
        login.clearUsername();
        login.clearPassword();
        login.enterUsername(properties.getProperty("login_emp_username"));
        login.enterPassword(properties.getProperty("login_password"));
        login.selectRole(role[0]);
        login.selectRememberMe();
        login.clickLogin();

        driver.get(properties.getProperty("url"));
        String dashboard = "";
        try{
            dashboard = login.loginDashboard();
        }catch (Exception e){
            Assert.assertEquals(properties.getProperty("employeeDashboard"),dashboard);
        }
    }

    @AfterTest
    public void closeDriver(){
        System.out.println("Close Driver");
        driver.quit();
    }
}