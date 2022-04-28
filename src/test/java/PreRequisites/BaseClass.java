package PreRequisites;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeTest;

import java.io.FileInputStream;
import java.time.Duration;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Properties;

//initialize used classes and driver
public class BaseClass {

    public static WebDriver driver;
    public static Properties properties;
    public static String[] role;
    public static ArrayList<String> employeeDetails;

    // load property file for data
    @BeforeTest
    public void init() throws Exception
    {
        properties = new Properties();
        properties.load(new FileInputStream("src/test/resources/data.properties"));
        role = properties.getProperty("login_user_roles").split(",");
        employeeDetails = new ArrayList<>();
        employeeDetails.addAll(Arrays.asList((properties.getProperty("emp_details").split(","))));
        System.out.println(employeeDetails);
    }

    // open url into chrome driver
    public void OpenDriver(String url){
        System.setProperty(properties.getProperty("browser_type"), properties.getProperty("driver_path")); // setting driver location
        driver=new ChromeDriver(); // creating driver object
        driver.get(url);  // launch using link
        driver.manage().window().maximize(); // maximize window
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
    }
    // close the driver
    @AfterClass
    public void closeDriver(){
        driver.close();
    }
}
