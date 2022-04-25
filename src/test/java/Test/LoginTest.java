package Test;

import PreRequisites.BaseClass;
import PageObjects.HomePage;
import PageObjects.Loginpage;

import org.testng.annotations.Test;


public class LoginTest extends BaseClass {

    @Test
    public void login()
    {
        HomePage home = new HomePage(driver);
        home.clickLogin();

        Loginpage login = new Loginpage(driver);
        login.enterUsername(properties.getProperty("login_org_username"));
        login.enterPassword(properties.getProperty("login_password"));
        login.selectRole(role[2]);
        login.clickLogin();
    }

}
