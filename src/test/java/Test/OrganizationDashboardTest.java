package Test;

import PageObjects.HomePage;
import PageObjects.Loginpage;
import PageObjects.OrganizationDashboardPage;
import PreRequisites.BaseClass;
import org.testng.Assert;
import org.testng.annotations.Test;


// tests for organization Dashboard
public class OrganizationDashboardTest extends BaseClass {

    // variable declaration
    HomePage homePage;
    Loginpage loginpage;
    OrganizationDashboardPage organizationDashboardPage;

    // check url is opening or not
    @Test(priority = 1)
    public void checkUrlIsOpeningOrNot(){
        // open url
        OpenDriver(properties.getProperty("url"));
    }

    @Test(priority = 2)
    public void checkOrganizationDashboardIsOpeningOrNot() throws InterruptedException {
        Initializer();
        // login into the Organization Dashboard
        homePage.clickLogin();
        loginpage.enterUsername(properties.getProperty("signin_company_name"));
        loginpage.enterPassword(properties.getProperty("signin_password"));
        loginpage.selectRole(role[2]);
        loginpage.clickLogin();
        Thread.sleep(2000);
        // setting pagination 5
        organizationDashboardPage.setPagination(5);
        // validating pagination
        Assert.assertEquals(organizationDashboardPage.numberOfUsersPerPage(), 5, "Pagination not worked");
    }
    // checking searching user is working or not
    @Test(priority = 3)
    public void checkSearchingUser() throws InterruptedException {
        Thread.sleep(2000);
        // Input search name
        organizationDashboardPage.setSearchInput(properties.getProperty("search_key"));
        // click search
        organizationDashboardPage.clickSearch();
        // validating search result
        Assert.assertEquals(organizationDashboardPage.numberOfUsersPerPage(), 1, "Search is Not Working Fine");

    }
    // checking searching with change case name
    @Test(priority = 4)
    public void checkSearchingUserWithChangeCase() throws InterruptedException {
        Thread.sleep(2000);
        organizationDashboardPage.clearSearchInput();
        // input search key
        organizationDashboardPage.setSearchInput(properties.getProperty("search_key_change_case"));
        // click search
        organizationDashboardPage.clickSearch();
        // validating search result
        Assert.assertEquals(organizationDashboardPage.numberOfUsersPerPage(), 1, "Search is Not Working Fine");
    }
    // Initialize class variables
    public void Initializer(){
        homePage= new HomePage(driver);
        loginpage=new Loginpage(driver);
        organizationDashboardPage=new OrganizationDashboardPage(driver);
    }

}
