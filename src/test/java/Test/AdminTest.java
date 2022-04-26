package Test;

import PageObjects.AdminDashboardPage;
import PageObjects.HomePage;
import PreRequisites.BaseClass;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import PageObjects.Loginpage;
import java.util.List;

public class AdminTest extends BaseClass {
    @BeforeTest
    public void loginToAdmin() {
        OpenDriver(properties.getProperty("url"));
        HomePage home = new HomePage(driver);
        home.clickLogin();
        Loginpage login = new Loginpage(driver);
        login.enterUsername(properties.getProperty("login_admin_username"));
        login.enterPassword(properties.getProperty("login_password"));
        login.selectRole(role[1]);
        login.clickLogin();
    }

    // TC001-Positive Test Case-(Whether the arrow mark is working fine or not)
    @Test(priority = 1)
    public void arrowMarkVerification() throws InterruptedException {
        List<WebElement> arrow = driver.findElements(By.xpath("//*[@id=\"filter\"]"));
        int listNumberofArrow = arrow.size();
        if(listNumberofArrow==0) throw new AssertionError("Arrow mark is not showing up the list of Company's Name.");
    }

    // TC002-Positive Test Case-(Choosen company name will shows up or not)
    @Test(priority = 2)
    public void companyNameSearch() throws InterruptedException {
        String compName = "Amazon";
        AdminDashboardPage adminDash = new AdminDashboardPage(driver);
        WebElement compname = driver.findElement(By.xpath("//*[@id=\"filter\"]/option[4]"));
        compname.click();
        Thread.sleep(1000);
        adminDash.clickFilterButton();
        Thread.sleep(3000);
        String searchCompName = driver.findElement(By.xpath("//*[@id=\"root\"]/div/div[2]/div[2]/div/div/table/tbody/tr[1]/td[3]")).getText();
        Assert.assertEquals(searchCompName,compName);
    }

    // TC003-Positive Test Case(Verifying whether the verify button working fine or not)
    @Test(priority = 3)
    public void verifyButton() throws InterruptedException {
        WebElement verifyButtonWorking = driver.findElement(By.xpath("//button[@class=\"button-four\"]"));
        verifyButtonWorking.click();
        Thread.sleep(3000);
        String expectedURL = "https://kycportal-urtjok3rza-wl.a.run.app/admin/employeDetails";
        String actualURL = driver.getCurrentUrl();
        System.out.println("actuaal is:"+actualURL);
        System.out.println("expected is:"+expectedURL);
        Assert.assertEquals(expectedURL, actualURL);
    }

    // TC004-Negative Test Case(Candidate's Details are not available when the requested to Admin but when the Admin either Reject or Accept the request the Details will be shown in website)
    @Test(priority = 4)
    public void candidatesDetails() throws InterruptedException {
        AdminDashboardPage adminDash = new AdminDashboardPage(driver);
        String listNumber = driver.findElement(By.xpath("//*[@id=\"root\"]/div/div[2]/div[2]/div/div/table/tfoot/div/div/p[2]")).getText();
        String lstNum = listNumber.substring(listNumber.length() - 2);
        int NumberOfRegisteredEmployee = Integer.parseInt(lstNum);
        // System.out.println(NumberOfRegisteredEmployee);
        String kycStatus = null;
        for (int rowsPerPage = 1; rowsPerPage <= (NumberOfRegisteredEmployee / 10); rowsPerPage++) {
            for (int row = 1; row <= 10; row++) {
                kycStatus = driver.findElement(By.xpath("//*[@id=\"root\"]/div/div[2]/div[2]/div/div/table/tbody/tr[" + Integer.toString(row) + "]/td[4]/p")).getText();
                // System.out.println(beforeActionKycStatus);
                if (kycStatus == "Pending") {
                    WebElement verify = driver.findElement(By.xpath("//*[@id=\"root\"]/div/div[2]/div[2]/div/div/table/tbody/tr[" + Integer.toString(row) + "]/td[5]/button"));
                    verify.click();
                    String fields = driver.findElement(By.xpath("//*[@id=\"root\"]/div/div[2]/div/div[1]/div[1]/div/div[2]/div/div/div/div[3]/p[2]")).getText();
                    if (fields == null) throw new AssertionError("The Candidate's Details are not Showing UP.");
                }
            }
            Thread.sleep(3000);
            WebElement rowsPerPageArrow = driver.findElement(By.xpath("//button[@title=\"Next page\"]"));  //finding xpth difficult
            rowsPerPageArrow.click(); // not clicking
        }
    }

    // TC005-Negative Test Case(Without reading the instruction Admin can either reject or accept the request)
    @Test(priority = 5)
    public void acceptORrejectWithoutReadingInstruction() throws InterruptedException {
        AdminDashboardPage adminDash = new AdminDashboardPage(driver);
        Thread.sleep(3000);
        String listNumber = driver.findElement(By.xpath("//*[@id=\"root\"]/div/div[2]/div[2]/div/div/table/tfoot/div/div/p[2]")).getText();
        String lstNum = listNumber.substring(listNumber.length() - 2);
        System.out.println(listNumber);
        int NumberOfRegisteredEmployee = Integer.parseInt(lstNum);
        System.out.println(NumberOfRegisteredEmployee);
        String afterActionKycStatus = null;
        String beforeActionKycStatus = null;
        for (int rowsPerPage = 1; rowsPerPage <= (NumberOfRegisteredEmployee / 10); rowsPerPage++) {
            for (int row = 1; row <= 10; row++) {
                beforeActionKycStatus = driver.findElement(By.xpath("//*[@id=\"root\"]/div/div[2]/div[2]/div/div/table/tbody/tr[" + Integer.toString(row) + "]/td[4]/p")).getText();
                // System.out.println(beforeActionKycStatus);
                if (beforeActionKycStatus == "Pending") {
                    WebElement verify = driver.findElement(By.xpath("//*[@id=\"root\"]/div/div[2]/div[2]/div/div/table/tbody/tr[" + Integer.toString(row) + "]/td[5]/button"));
                    verify.click();
                    Thread.sleep(3000);
                    adminDash.clickAcceptButton();
                    Thread.sleep(3000);
                    afterActionKycStatus = driver.findElement(By.xpath("//*[@id=\"root\"]/div/div[2]/div[2]/div/div/table/tbody/tr[" + Integer.toString(row) + "]/td[4]/p")).getText();
                    break;
                }
            }
            Thread.sleep(3000);
            WebElement rowsPerPageArrow = driver.findElement(By.xpath("//button[@aria-label=\"Next page\"]")); //finding xpth difficult
            rowsPerPageArrow.click(); // not clicking
        }
        Assert.assertEquals(beforeActionKycStatus, afterActionKycStatus);
    }

}
