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
        OpenDriver(properties.getProperty("url"));
        HomePage home = new HomePage(driver);

        // check home button functions by click the button and check respective url
        home.clickHome();
        Assert.assertEquals(driver.getCurrentUrl(),homeUrl);


        // check what we do button functions by click the button and check respective url
        home.clickWhatWeDo();
        Assert.assertEquals(driver.getCurrentUrl(),whatWeDoUrl);


        // check about us button functions by click the button and check respective url
        home.clickAboutUs();
        Assert.assertEquals(driver.getCurrentUrl(),aboutUsUrl);


        // check industries button functions by click the button and check respective url
        home.clickIndustries();
        Assert.assertEquals(driver.getCurrentUrl(),industriesUrl);


        //check the function of home button on the bottom of the page
        // by click the button and check respective url
        home.clickHomeBottom();
        Assert.assertEquals(driver.getCurrentUrl(),homeUrl);


        //check the function of home button on the bottom of the page
        // by click the button and check respective url
        home.clickOurClient();
        Assert.assertEquals(driver.getCurrentUrl(),industriesUrl);


        //check the function of home button on the bottom of the page
        // by click the button and check respective url
        home.clickAboutUsBottom();
        Assert.assertEquals(driver.getCurrentUrl(),aboutUsUrl);

    }
}
