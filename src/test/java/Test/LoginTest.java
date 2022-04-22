package Test;

import PreRequisites.BaseClass;
import PageObjects.HomePage;
import PageObjects.Loginpage;

import org.testng.Assert;
import org.testng.annotations.Test;


public class LoginTest extends BaseClass {


    String error = "Enter correct username and password !!";
    String employeeDashboard = "Employee Dashboard";
    String adminDashboard = "Admin Dashboard";
    String organizationDashboard = "Company Dashboard";

    @Test
    public void validateEmployeeLogin() throws Exception
    {
        HomePage home = new HomePage(driver);
        home.clickLogin();

        Loginpage login = new Loginpage(driver);
        login.enterUsername(prop.getProperty("login_emp_username"));
        login.enterPassword(prop.getProperty("login_password"));
        login.selectRole(role[0]);
        login.clickLogin();
        Assert.assertEquals(employeeDashboard,driver.findElement(login.dashboard).getAttribute("textContent"));
    }

    @Test
    public void validateAdminLogin()
    {
        HomePage home = new HomePage(driver);
        home.clickLogin();

        Loginpage login = new Loginpage(driver);
        login.enterUsername(prop.getProperty("login_admin_username"));
        login.enterPassword(prop.getProperty("login_password"));
        login.selectRole(role[1]);
        login.clickLogin();
        Assert.assertEquals(adminDashboard,driver.findElement(login.dashboard).getAttribute("textContent"));
    }

    @Test
    public void validateOrganizationLogin()
    {
        HomePage home = new HomePage(driver);
        home.clickLogin();

        Loginpage login = new Loginpage(driver);
        login.enterUsername(prop.getProperty("login_org_username"));
        login.enterPassword(prop.getProperty("login_password"));
        login.selectRole(role[2]);
        login.clickLogin();
        Assert.assertEquals(organizationDashboard,driver.findElement(login.dashboard).getAttribute("textContent"));
    }

    @Test
    public void inValidateEmployeeLogin()
    {
        HomePage home = new HomePage(driver);
        home.clickLogin();

        Loginpage login = new Loginpage(driver);
        login.enterUsername(prop.getProperty("inValid_user_name"));
        login.enterPassword(prop.getProperty("login_password"));
        login.selectRole(role[0]);
        login.clickLogin();
        Assert.assertEquals(error,driver.findElement(login.errorMessage).getAttribute("textContent"));
    }

    @Test
    public void inValidateAdminLogin()
    {
        HomePage home = new HomePage(driver);
        home.clickLogin();

        Loginpage login = new Loginpage(driver);
        login.enterUsername(prop.getProperty("inValid_user_name"));
        login.enterPassword(prop.getProperty("login_password"));
        login.selectRole(role[1]);
        login.clickLogin();
        Assert.assertEquals(error,driver.findElement(login.errorMessage).getAttribute("textContent"));
    }
    @Test
    public void inValidateOrganizationLogin()
    {
        HomePage home = new HomePage(driver);
        home.clickLogin();

        Loginpage login = new Loginpage(driver);
        login.enterUsername(prop.getProperty("inValid_user_name"));
        login.enterPassword(prop.getProperty("login_password"));
        login.selectRole(role[2]);
        login.clickLogin();
        Assert.assertEquals(error,driver.findElement(login.errorMessage).getAttribute("textContent"));
    }

    @Test
    public void LoginWithRemember()
    {
        HomePage home = new HomePage(driver);
        home.clickLogin();

        Loginpage login = new Loginpage(driver);
        login.enterUsername(prop.getProperty("login_emp_username"));
        login.enterPassword(prop.getProperty("login_password"));
        login.selectRole(role[0]);
        login.selectRememberMe();
        login.clickLogin();

        driver.get("https://kycportal-urtjok3rza-wl.a.run.app/employ/dashboard");
        Assert.assertEquals(error,driver.findElement(login.errorMessage).getAttribute("textContent"));
    }

    @Test
    // verify error message by login as admin using employee credentials
    public void AdminLogin()
    {
        HomePage home = new HomePage(driver);
        home.clickLogin();

        Loginpage login = new Loginpage(driver);
        login.enterUsername(prop.getProperty("login_emp_username"));
        login.enterPassword(prop.getProperty("login_password"));
        login.selectRole(role[1]);
        login.clickLogin();
        Assert.assertEquals(error,driver.findElement(login.errorMessage).getAttribute("textContent"));
    }

}
