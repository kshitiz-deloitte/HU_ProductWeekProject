package Test;

import PageObjects.AdminDashboardPage;
import PageObjects.HomePage;
import PreRequisites.BaseClass;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;
import PageObjects.Loginpage;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;


public class AdminTest extends BaseClass {
    AdminDashboardPage adminDash;

    // TC001-Positive Test Case-(Whether the arrow mark is working fine or not)
    @Test(priority = 1)
    public void arrowMarkVerification(){
        OpenDriver(properties.getProperty("url"));
        HomePage home = new HomePage(driver);
        home.clickLogin();
        Loginpage login = new Loginpage(driver);
        login.enterUsername(properties.getProperty("login_admin_username"));
        login.enterPassword(properties.getProperty("login_password"));
        login.selectRole(role[1]);
        login.clickLogin();
        adminDash = new AdminDashboardPage(driver);
        int kb = adminDash.filter();
        if(kb==0) throw new AssertionError("Arrow mark is not showing up the list of Company's Name.");
    }


    // TC004-Negative Test Case(Candidate's Details are not available when the requested to Admin but when the Admin either Reject or Accept the request the Details will be shown in website)
    @Test(priority = 2)
    public void candidatesDetails() throws InterruptedException {
        adminDash = new AdminDashboardPage(driver);
        Thread.sleep(3000);
        String listNumber = adminDash.listNumber();
        String lstNum = listNumber.substring(listNumber.length() - 2);
        int NumberOfRegisteredEmployee = Integer.parseInt(lstNum);
        String kycStatus;
        for (int rowsPerPage = 1; rowsPerPage <= (NumberOfRegisteredEmployee / 10); rowsPerPage++) {
            for (int row = 1; row <= 10; row++) {
                kycStatus = adminDash.kycstat();
                if (Objects.equals(kycStatus, "Pending")) {
                    adminDash.verifyy(row);
                    String fields = adminDash.field();
                    if (fields == null) throw new AssertionError("The Candidate's Details are not Showing UP.");
                }
            }
            Thread.sleep(3000);
            adminDash.rowperPageArrow();
        }
    }

    // TC005-Negative Test Case(Without reading the instruction Admin can either reject or accept the request)
    @Test(priority = 3)
    public void acceptORrejectWithoutReadingInstruction() throws InterruptedException {
        adminDash = new AdminDashboardPage(driver);
        Thread.sleep(3000);
        String listNumber = adminDash.listNumber2();
        String lstNum = listNumber.substring(listNumber.length() - 2);
        System.out.println(listNumber);
        int NumberOfRegisteredEmployee = Integer.parseInt(lstNum);
        System.out.println(NumberOfRegisteredEmployee);
        String afterActionKycStatus = null;
        String beforeActionKycStatus = null;
        for (int rowsPerPage = 1; rowsPerPage <= (NumberOfRegisteredEmployee / 10); rowsPerPage++) {
            for (int row = 1; row <= 10; row++) {
                beforeActionKycStatus = adminDash.beforeAcionKYC(row);
                if (Objects.equals(beforeActionKycStatus, "Pending")) {
                    adminDash.verifyy(row);
                    Thread.sleep(3000);
                    adminDash.clickAcceptButton();
                    Thread.sleep(3000);
                    afterActionKycStatus = adminDash.afterActionKYC(row);
                    break;
                }
            }
            Thread.sleep(3000);
            WebElement rowsPerPageArrow = driver.findElement(By.xpath("//button[@aria-label=\"Next page\"]")); //finding xpth difficult
            rowsPerPageArrow.click(); // not clicking
        }
        Assert.assertEquals(beforeActionKycStatus, afterActionKycStatus);
    }


    // TC002-Positive Test Case-(Choosen company name will shows up or not)
    @Test(priority = 4)
    public void companyNameSearch() throws InterruptedException {
        adminDash = new AdminDashboardPage(driver);
        driver.navigate().to(properties.getProperty("navigate_url"));
        Thread.sleep(3000);
        String compName = properties.getProperty("compName");
        adminDash.comp();
        adminDash.clickFilterButton();
        Thread.sleep(3000);
        String searchCompName = adminDash.search();
        Assert.assertEquals(searchCompName,compName);
    }

    // TC003-Positive Test Case(Verifying whether the verify button working fine or not)
    @Test(priority = 5)
    public void verifyButton() throws InterruptedException {
        adminDash = new AdminDashboardPage(driver);
        Thread.sleep(3000);
        adminDash.verifyBtnWorking();
        String expectedURL = properties.getProperty("employee_detail_expURL");
        Thread.sleep(3000);
        String actualURL = driver.getCurrentUrl();
        System.out.println("actuaal is:"+actualURL);
        System.out.println("expected is:"+expectedURL);
        Assert.assertEquals(expectedURL, actualURL);
    }
    // TC006-Positive Test Case(Checking whether the files can be downloaded or not)
    @Test(priority = 6)
    public void downloadFileCheck() {
        adminDash = new AdminDashboardPage(driver);
        adminDash.clickAadarDownloadButton();
        List<String> browserTabs = new ArrayList<>(driver.getWindowHandles());
        System.out.println(browserTabs.size());
        if(browserTabs.size()==1) throw new AssertionError("Files are not Downloadable");
    }
}
