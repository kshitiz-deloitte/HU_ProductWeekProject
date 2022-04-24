package Test;

import PageObjects.HomePage;
import PageObjects.Loginpage;
import PageObjects.OrganizationDashboardPage;
import PreRequisites.BaseClass;
import org.testng.Assert;
import org.testng.annotations.Test;

public class OrganizationDashboardTest extends BaseClass {
    HomePage homePage;
    Loginpage loginpage;
    OrganizationDashboardPage organizationDashboardPage;


    @Test(priority = 1)
    public void checkUrlIsOpeningOrNot(){
        OpenDriver(properties.getProperty("url"));
        homePage= new HomePage(driver);
        loginpage=new Loginpage(driver);
        organizationDashboardPage=new OrganizationDashboardPage(driver);
    }

    @Test(priority = 2)
    public void checkOrganizationDashboardIsOpeningOrNot() throws InterruptedException {
        homePage.clickLogin();
        loginpage.enterUsername(properties.getProperty("signin_company_name"));
        loginpage.enterPassword(properties.getProperty("signin_password"));
        loginpage.selectRole(role[2]);
        loginpage.clickLogin();
        Thread.sleep(2000);
        organizationDashboardPage.setPagination(5);
        Assert.assertEquals(organizationDashboardPage.numberOfUsersPerPage(),5,"Pagination not worked");
    }
    @Test(priority = 3)
    public void checkSearchingUserIsWorkingOrNot() throws InterruptedException {
        Thread.sleep(2000);
        organizationDashboardPage.setSearchInput(properties.getProperty("search_key"));
        organizationDashboardPage.clickSearch();
        Assert.assertEquals(organizationDashboardPage.numberOfUsersPerPage(), 1, "Search is Not Working Fine");

    }
    @Test(priority = 4)
    public void checkSearchingUserWithChangeCaseIsWorkingOrNot() throws InterruptedException {
        Thread.sleep(2000);
        organizationDashboardPage.clearSearchInput();
        organizationDashboardPage.setSearchInput(properties.getProperty("search_key_change_case"));
        organizationDashboardPage.clickSearch();
        Assert.assertEquals(organizationDashboardPage.numberOfUsersPerPage(), 1, "Search is Not Working Fine");
    }
}
