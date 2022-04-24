package Test;

import PageObjects.HomePage;
import PageObjects.Loginpage;

import PreRequisites.BaseClass;
import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;


public class LoginTest extends BaseClass {

    // string values to compare and assert

    String err = "Enter correct username and password !!";
    String employeeDashboard = "Employee Dashboard";
    String adminDashboard = "Admin Dashboard";
    String organizationDashboard = "Company Dashboard";


    @Test(priority = 1)
    // Test to validate successful employee login
    public void validateEmployeeLogin()
    {
        HomePage home = new HomePage(driver);
        home.clickLogin();

        Loginpage login = new Loginpage(driver);
        login.enterUsername(prop.getProperty("login_emp_username"));
        login.enterPassword(prop.getProperty("login_password"));
        login.selectRole(role[0]);
        login.clickLogin();
        try {
            Assert.assertEquals(employeeDashboard,driver.findElement(login.dashboard).getAttribute("textContent"));
        }
        catch (Exception e)
        {
            System.out.println("unsuccessful validateEmployeeLogin");
        }
        driver.findElement(By.xpath("//button[@class='btn login']")).click();
    }

    @Test(priority = 2)
    // Test to validate successful admin login
    public void validateAdminLogin() {
        HomePage home = new HomePage(driver);
        home.clickLogin();

        Loginpage login = new Loginpage(driver);
        login.enterUsername(prop.getProperty("login_admin_username"));
        login.enterPassword(prop.getProperty("login_password"));
        login.selectRole(role[1]);
        login.clickLogin();
        try {
            Assert.assertEquals(adminDashboard,driver.findElement(login.dashboard).getAttribute("textContent"));
        }
        catch (Exception e)
        {
            System.out.println("unsuccessful validateAdminLogin");
        }
        driver.findElement(By.xpath("//button[@class='btn login']")).click();
    }

    @Test(priority = 3)
    // Test to validate successful organization login
    public void validateOrganizationLogin() {
        HomePage home = new HomePage(driver);
        home.clickLogin();

        Loginpage login = new Loginpage(driver);
        login.enterUsername(prop.getProperty("login_org_username"));
        login.enterPassword(prop.getProperty("login_password"));
        login.selectRole(role[2]);
        login.clickLogin();
        try {
            Assert.assertEquals(organizationDashboard,driver.findElement(login.dashboard).getAttribute("textContent"));
        }
        catch (Exception e)
        {
            System.out.println("unsuccessful validateOrganizationLogin");
        }
        driver.findElement(By.xpath("//button[@class='btn login']")).click();
    }

    @Test(priority = 4)
    // Test to validate unsuccessful employee login
    public void inValidateEmployeeLogin() {
        HomePage home = new HomePage(driver);
        home.clickLogin();

        Loginpage login = new Loginpage(driver);
        login.enterUsername(prop.getProperty("inValid_user_name"));
        login.enterPassword(prop.getProperty("login_password"));
        login.selectRole(role[0]);
        login.clickLogin();
        try {
            Assert.assertEquals(err,driver.findElement(login.errorMessage).getAttribute("textContent"));
        }
        catch (Exception e)
        {
            System.out.println("unsuccessful inValidateEmployeeLogin");
        }
    }

    @Test(priority = 5)
    // Test to validate unsuccessful admin login
    public void inValidateAdminLogin() throws Exception{

        Loginpage login = new Loginpage(driver);
        login.clearUsername();
        login.clearPassword();
        login.enterUsername(prop.getProperty("inValid_user_name"));
        login.enterPassword(prop.getProperty("login_password"));
        login.selectRole(role[1]);
        login.clickLogin();
        try {
            Assert.assertEquals(err,driver.findElement(login.errorMessage).getAttribute("textContent"));
        }
        catch (Exception e)
        {
            System.out.println("unsuccessful inValidateAdminLogin");
        }
    }
    @Test(priority = 6)
    // Test to validate unsuccessful organization login
    public void inValidateOrganizationLogin() throws Exception{

        Loginpage login = new Loginpage(driver);
        login.clearUsername();
        login.clearPassword();
        login.enterUsername(prop.getProperty("inValid_user_name"));
        login.enterPassword(prop.getProperty("login_password"));
        login.selectRole(role[2]);
        login.clickLogin();
        try {
            Assert.assertEquals(err,driver.findElement(login.errorMessage).getAttribute("textContent"));
        }
        catch (Exception e)
        {
            System.out.println("unsuccessful inValidateOrganizationLogin");
        }
    }

    @Test(priority = 7)
    // Test to verify error message by login as admin using employee credentials
    public void AdminLogin() throws Exception
    {
        Loginpage login = new Loginpage(driver);
        login.clearUsername();
        login.clearPassword();
        login.enterUsername(prop.getProperty("login_emp_username"));
        login.enterPassword(prop.getProperty("login_password"));
        login.selectRole(role[1]);
        login.clickLogin();
        try {
            Assert.assertEquals(err,driver.findElement(login.errorMessage).getAttribute("textContent"));
        }
        catch (Exception e)
        {
            System.out.println("unsuccessful AdminLogin with employee credentials");
        }
    }

    @Test(priority = 8)
    // Test to validate employee login by select remember me option and visit same url again
    public void LoginWithRemember() throws Exception
    {
        Loginpage login = new Loginpage(driver);
        login.clearUsername();
        login.clearPassword();
        login.enterUsername(prop.getProperty("login_emp_username"));
        login.enterPassword(prop.getProperty("login_password"));
        login.selectRole(role[0]);
        login.selectRememberMe();
        login.clickLogin();

        driver.get(prop.getProperty("url"));
        try {
            Assert.assertEquals(err,driver.findElement(login.errorMessage).getAttribute("textContent"));
        }
        catch (Exception e)
        {
            System.out.println("unsuccessful LoginWithRemember");
        }
    }

}
