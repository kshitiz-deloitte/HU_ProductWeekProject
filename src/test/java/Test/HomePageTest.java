package Test;

import PageObjects.HomePage;
import PreRequisites.BaseClass;
import org.testng.Assert;
import org.testng.annotations.Test;

public class HomePageTest extends BaseClass{


    @Test
    // Test to validate buttons functions in home page
    public void validateHomeButtons()
    {
        OpenDriver(properties.getProperty("url"));
        HomePage home = new HomePage(driver);

        // check home button functions by click the button and check respective url
        home.clickHome();
        Assert.assertEquals(driver.getCurrentUrl(),properties.getProperty("homeUrl"));


        // check what we do button functions by click the button and check respective url
        home.clickWhatWeDo();
        Assert.assertEquals(driver.getCurrentUrl(),properties.getProperty("whatWeDoUrl"));


        // check about us button functions by click the button and check respective url
        home.clickAboutUs();
        Assert.assertEquals(driver.getCurrentUrl(),properties.getProperty("aboutUsUrl"));


        // check industries button functions by click the button and check respective url
        home.clickIndustries();
        Assert.assertEquals(driver.getCurrentUrl(),properties.getProperty("industriesUrl"));


        //check the function of home button on the bottom of the page
        // by click the button and check respective url
        home.clickHomeBottom();
        Assert.assertEquals(driver.getCurrentUrl(),properties.getProperty("homeUrl"));


        //check the function of home button on the bottom of the page
        // by click the button and check respective url
        home.clickOurClient();
        Assert.assertEquals(driver.getCurrentUrl(),properties.getProperty("industriesUrl"));


        //check the function of home button on the bottom of the page
        // by click the button and check respective url
        home.clickAboutUsBottom();
        Assert.assertEquals(driver.getCurrentUrl(),properties.getProperty("aboutUsUrl"));

    }
}
