package Test;

import PageObjects.HomePage;
import PageObjects.Loginpage;

import PreRequisites.BaseClass;
import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.time.Duration;


public class LoginTest extends BaseClass {

    // string values to compare and assert

    String err = "Enter correct username and password !!";
    String employeeDashboard = "Employee Dashboard";
    String adminDashboard = "Admin Dashboard";
    String organizationDashboard = "Company Dashboard";

    HomePage home;
    Loginpage login;

    @Test(priority = 1)
    // Test to validate successful employee login
    public void validateEmployeeLogin()
    {
        OpenDriver(properties.getProperty("url"));
        home = new HomePage(driver);
        home.clickLogin();

        login = new Loginpage(driver);
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        login.enterUsername(properties.getProperty("login_emp_username"));
        login.enterPassword(properties.getProperty("login_password"));
        login.selectRole(role[0]);
        login.clickLogin();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        Assert.assertEquals(employeeDashboard,driver.findElement(login.dashboard).getAttribute("textContent"));

        driver.findElement(By.xpath("//button[@class='btn login']")).click();
    }

    @Test(priority = 2)
    // Test to validate successful admin login
    public void validateAdminLogin() {
        home = new HomePage(driver);
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        home.clickLogin();

        login = new Loginpage(driver);
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        login.enterUsername(properties.getProperty("login_admin_username"));
        login.enterPassword(properties.getProperty("login_password"));
        login.selectRole(role[1]);
        login.clickLogin();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        Assert.assertEquals(adminDashboard,driver.findElement(login.dashboard).getAttribute("textContent"));

        driver.findElement(By.xpath("//button[@class='btn login']")).click();
    }

    @Test(priority = 3)
    // Test to validate successful organization login
    public void validateOrganizationLogin() throws Exception{
        home = new HomePage(driver);
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        home.clickLogin();

        login = new Loginpage(driver);
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        login.enterUsername(properties.getProperty("login_org_username"));
        login.enterPassword(properties.getProperty("login_password"));
        login.selectRole(role[2]);
        login.clickLogin();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        Assert.assertEquals(organizationDashboard,driver.findElement(login.dashboard).getAttribute("textContent"));

        driver.findElement(By.xpath("//button[@class='btn login']")).click();
    }

    @Test(priority = 4)
    // Test to validate unsuccessful employee login
    public void inValidateEmployeeLogin() {
        home = new HomePage(driver);
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        home.clickLogin();

        login = new Loginpage(driver);
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        login.enterUsername(properties.getProperty("inValid_user_name"));
        login.enterPassword(properties.getProperty("login_password"));
        login.selectRole(role[0]);
        login.clickLogin();
        Assert.assertEquals(err,driver.findElement(login.errorMessage).getAttribute("textContent"));

    }

    @Test(priority = 5)
    // Test to validate unsuccessful admin login
    public void inValidateAdminLogin() throws Exception{

        login = new Loginpage(driver);
        login.clearUsername();
        login.clearPassword();
        login.enterUsername(properties.getProperty("inValid_user_name"));
        login.enterPassword(properties.getProperty("login_password"));
        login.selectRole(role[1]);
        login.clickLogin();
        Assert.assertEquals(err,driver.findElement(login.errorMessage).getAttribute("textContent"));

    }
    @Test(priority = 6)
    // Test to validate unsuccessful organization login
    public void inValidateOrganizationLogin() throws Exception{

        login = new Loginpage(driver);
        login.clearUsername();
        login.clearPassword();
        login.enterUsername(properties.getProperty("inValid_user_name"));
        login.enterPassword(properties.getProperty("login_password"));
        login.selectRole(role[2]);
        login.clickLogin();
        Assert.assertEquals(err,driver.findElement(login.errorMessage).getAttribute("textContent"));

    }

    @Test(priority = 7)
    // Test to verify error message by login as admin using employee credentials
    public void AdminLogin() throws Exception
    {
        login = new Loginpage(driver);
        login.clearUsername();
        login.clearPassword();
        login.enterUsername(properties.getProperty("login_emp_username"));
        login.enterPassword(properties.getProperty("login_password"));
        login.selectRole(role[1]);
        login.clickLogin();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        Assert.assertEquals(err,driver.findElement(login.errorMessage).getAttribute("textContent"));

    }

    @Test(priority = 8)
    // Test to validate employee login by select remember me option and visit same url again
    public void LoginWithRemember() throws Exception
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
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        Assert.assertEquals(err,driver.findElement(login.errorMessage).getAttribute("textContent"));

    }

}
