package Test;

import PageObjects.EmployeeDashboardPage;
import PageObjects.HomePage;
import PageObjects.Loginpage;
import PreRequisites.BaseClass;
import org.testng.Assert;
import org.testng.annotations.Test;

public class EmployeeDashboardTest extends BaseClass{
    HomePage homePage;
    Loginpage loginPage;
    EmployeeDashboardPage employeeDashboardPage;
    String userDir = System.getProperty("user.dir");

    //Login into Employee Dashboard with valid credentials
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

    //Validating Kyc Portal logo and Employee Dashboard Text is visible or not
    @Test(priority = 2)
    public void validatingLT() throws InterruptedException {
        employeeDashboardPage = new EmployeeDashboardPage(driver);
        Thread.sleep(2000);
        employeeDashboardPage.verifyLogoAndText();
        Thread.sleep(2000);
    }

    //Validating Update Link under Quicklinks
    @Test(priority = 3)
    public void validatingQLUpdate() throws InterruptedException {
        Thread.sleep(2000);
        employeeDashboardPage.verifyQuicklinksU();
        Thread.sleep(2000);
    }

    //Negative Test Case - Validating Home Link under Quicklinks and checking whether user has been logged out or not
    @Test(priority = 4)
    public void validatingQLH() throws InterruptedException {
        Thread.sleep(2000);
        employeeDashboardPage.verifyQuicklinksH();
        String btnTxt = homePage.getButtonText();
        driver.navigate().back();
        Assert.assertEquals(btnTxt, "Logout");
    }

    //Validating By uploading Aadhar Pan and Marksheet
    @Test(priority = 5)
    public void validatingUploadAPM() throws InterruptedException {
        Thread.sleep(2000);
        employeeDashboardPage.uploadAadhar(userDir+"\\"+properties.getProperty("aadharimg"));
        Thread.sleep(2000);
        employeeDashboardPage.uploadPan(userDir+"\\"+properties.getProperty("panimg"));
        Thread.sleep(2000);
        employeeDashboardPage.uploadMarksheet(userDir+"\\"+properties.getProperty("marksheetimg"));
    }

    //Validating the error message By uploading files more than 2mb
    @Test(priority = 6)
    public void validatingErrorMsgUploadAPM() throws InterruptedException {
        Thread.sleep(2000);
        employeeDashboardPage.errorMsg(userDir+"\\"+properties.getProperty("video"));
        Thread.sleep(2000);
    }

    //logging out
    @Test(priority = 7)
    public void validatingLogout() throws InterruptedException {
        Thread.sleep(2000);
        employeeDashboardPage.logout();
        Thread.sleep(2000);
    }

}
