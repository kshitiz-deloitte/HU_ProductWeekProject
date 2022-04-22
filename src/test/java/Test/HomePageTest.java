package Test;

import PageObjects.HomePage;
import PreRequisites.BaseClass;
import org.testng.Assert;
import org.testng.annotations.Test;

public class HomePageTest extends BaseClass {

    static String homeUrl = "https://kycportal-urtjok3rza-wl.a.run.app/#top-home";
    static String whatWeDoUrl = "https://kycportal-urtjok3rza-wl.a.run.app/#whatWeDo";
    static String aboutUsUrl = "https://kycportal-urtjok3rza-wl.a.run.app/#aboutUs";
    static String industriesUrl = "https://kycportal-urtjok3rza-wl.a.run.app/#clients";

    @Test
    public void validateHomeButtons() throws Exception
    {
        HomePage home = new HomePage(driver);

        home.clickHome();
        Assert.assertEquals(driver.getCurrentUrl(),homeUrl);

        home.clickWhatWeDo();
        Assert.assertEquals(driver.getCurrentUrl(),whatWeDoUrl);

        home.clickAboutUs();
        Assert.assertEquals(driver.getCurrentUrl(),aboutUsUrl);

        home.clickIndustries();
        Assert.assertEquals(driver.getCurrentUrl(),industriesUrl);
    }
}
