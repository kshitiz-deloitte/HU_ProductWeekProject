package Test;

import PageObjects.EmployeeDashboardPage;
import PageObjects.HomePage;
import PageObjects.Loginpage;
import PreRequisites.BaseClass;
import org.testng.annotations.Test;

public class EmployeeDashboardTest extends BaseClass{
    HomePage homePage;
    Loginpage loginPage;
    EmployeeDashboardPage employeeDashboardPage;

    @Test(priority = 1)
    public void initialize() throws InterruptedException {
        Thread.sleep(2000);
        OpenDriver(properties.getProperty("url"));
        homePage = new HomePage(driver);
        loginPage = new Loginpage(driver);
        homePage.clickLogin();
        loginPage.enterUsername(properties.getProperty("login_emp_username"));
        loginPage.enterPassword(properties.getProperty("login_password"));
        loginPage.selectRole(role[0]);
        Thread.sleep(2000);
        loginPage.clickLogin();
    }
    @Test(priority = 2)
    public void validatingL() throws InterruptedException {
        employeeDashboardPage = new EmployeeDashboardPage(driver);
        Thread.sleep(2000);
        employeeDashboardPage.verifyLogo();
        Thread.sleep(2000);
    }

    @Test(priority = 3)
    public void validatingUploadAPM() throws InterruptedException {
        Thread.sleep(2000);
        employeeDashboardPage.uploadAadhar();
        Thread.sleep(2000);
        employeeDashboardPage.uploadPan();
        Thread.sleep(2000);
        employeeDashboardPage.uploadMarksheet();
    }

    @Test(priority = 4)
    public void validatingErrorMsgUploadAPM() throws InterruptedException {
        Thread.sleep(2000);
        employeeDashboardPage.errorMsg();
        Thread.sleep(2000);
    }

}
