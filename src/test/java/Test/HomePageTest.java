package Test;

import PageObjects.HomePage;
import PreRequisites.BaseClass;
import org.testng.Assert;
import org.testng.annotations.Test;

public class HomePageTest extends BaseClass {

    // url to validate buttons

    static String homeUrl = "https://kycportal-urtjok3rza-wl.a.run.app/#top-home";
    static String whatWeDoUrl = "https://kycportal-urtjok3rza-wl.a.run.app/#whatWeDo";
    static String aboutUsUrl = "https://kycportal-urtjok3rza-wl.a.run.app/#aboutUs";
    static String industriesUrl = "https://kycportal-urtjok3rza-wl.a.run.app/#clients";


    @Test

    // Test to validate buttons functions in home page
    public void validateHomeButtons() throws Exception
    {
        HomePage home = new HomePage(driver);

        // check home button functions by click the button and check respective url
        home.clickHome();
        try {
            Assert.assertEquals(driver.getCurrentUrl(),homeUrl);
        }
        catch (Exception e)
        {
            System.out.println("problem in home button function");
        }

        // check what we do button functions by click the button and check respective url
        home.clickWhatWeDo();
        try {
            Assert.assertEquals(driver.getCurrentUrl(),whatWeDoUrl);
        }
        catch (Exception e)
        {
            System.out.println("problem in what we do button function");
        }

        // check about us button functions by click the button and check respective url
        home.clickAboutUs();
        try {
            Assert.assertEquals(driver.getCurrentUrl(),aboutUsUrl);
        }
        catch (Exception e)
        {
            System.out.println("problem in about us button function");
        }

        // check industries button functions by click the button and check respective url
        home.clickIndustries();
        try {
            Assert.assertEquals(driver.getCurrentUrl(),industriesUrl);
        }
        catch (Exception e)
        {
            System.out.println("problem in industries button function");
        }

        //check the function of home button on the bottom of the page
        // by click the button and check respective url
        home.clickHomeBottom();
        try {
            Assert.assertEquals(driver.getCurrentUrl(),homeUrl);
        }
        catch (Exception e)
        {
            System.out.println("problem in home button function which is bottom of the page");
        }

        //check the function of home button on the bottom of the page
        // by click the button and check respective url
        home.clickOurClient();
        try {
            Assert.assertEquals(driver.getCurrentUrl(),industriesUrl);
        }
        catch (Exception e)
        {
            System.out.println("problem in our clients button function which is bottom of the page");
        }

        //check the function of home button on the bottom of the page
        // by click the button and check respective url
        home.clickAboutUsBottom();
        try {
            Assert.assertEquals(driver.getCurrentUrl(),aboutUsUrl);
        }
        catch (Exception e)
        {
            System.out.println("problem in about us button function which is bottom of the page");
        }
    }
}
