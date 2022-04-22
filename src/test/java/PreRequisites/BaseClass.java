package PreRequisites;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeTest;

import java.io.FileInputStream;
import java.time.Duration;
import java.util.Properties;


public class BaseClass {

    public static WebDriver driver;
    public static Properties prop;
    public static String[] role;

    @BeforeTest
    public void init() throws Exception
    {
        prop = new Properties();
        prop.load(new FileInputStream("src/main/resources/data.properties"));
        role = prop.getProperty("login_user_roles").split(",");

        System.setProperty(prop.getProperty("browser_type"), prop.getProperty("driver_path")); // setting driver location
        driver=new ChromeDriver();          // creating driver object
        driver.get(prop.getProperty("url"));  // launch using link
        driver.manage().window().maximize(); // maximize window
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
    }
}
