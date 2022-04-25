package Test;

import PageObjects.EmployeeDashboardPage;
import PageObjects.HomePage;
import PageObjects.Loginpage;
import PreRequisites.BaseClass;
import org.testng.Assert;
import org.testng.annotations.Test;

public class EmployeeDashboardTest extends BaseClass {
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
    public void validatingLT() throws InterruptedException {
        employeeDashboardPage = new EmployeeDashboardPage(driver);
        Thread.sleep(2000);
        employeeDashboardPage.verifyLogoAndText();
        Thread.sleep(2000);
    }

    @Test(priority = 3)
    public void validatingQLUpdate() throws InterruptedException {
        Thread.sleep(2000);
        employeeDashboardPage.verifyQuicklinksU();
        Thread.sleep(2000);
    }

    @Test(priority = 4)
    public void validatingQLH() throws InterruptedException {
        Thread.sleep(2000);
        employeeDashboardPage.verifyQuicklinksH();
        String btnTxt = homePage.getButtonText();
        driver.navigate().back();
        Assert.assertEquals(btnTxt, "Logout");
    }

    @Test(priority = 5)
    public void validatingUploadAPM() throws InterruptedException {
        Thread.sleep(2000);
        employeeDashboardPage.uploadAadhar();
        Thread.sleep(2000);
        employeeDashboardPage.uploadPan();
        Thread.sleep(2000);
        employeeDashboardPage.uploadMarksheet();
    }

    @Test(priority = 6)
    public void validatingErrorMsgUploadAPM() throws InterruptedException {
        Thread.sleep(2000);
        employeeDashboardPage.errorMsg();
        Thread.sleep(2000);
    }

    @Test(priority = 7)
    public void validatingLogout() throws InterruptedException {
        Thread.sleep(2000);
        employeeDashboardPage.logout();
        Thread.sleep(2000);
    }

}
