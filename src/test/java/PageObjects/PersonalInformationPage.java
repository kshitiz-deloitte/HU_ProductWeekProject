package PageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.List;
import java.util.Properties;

public class PersonalInformationPage {
    static By firstName = By.xpath("//input[@name='firstName']");
    static By lastName = By.xpath("//input[@name='lastName']");
    static By genderList = By.xpath("//div[@aria-labelledby='demo-radio-buttons-group-label']");
    static By datePicker = By.xpath("//*[@id='dob']");

    public static void main(String[] args) throws IOException, InterruptedException {
        Properties prop = new Properties();
        prop.load(new FileInputStream("src/main/resources/data.properties"));
        System.out.println(prop.getProperty("login_admin_username"));

        System.setProperty(prop.getProperty("browser_type"), prop.getProperty("driver_path"));
        WebDriver driver = new ChromeDriver();
        driver.get("https://kycportal-urtjok3rza-wl.a.run.app/sign-in");
        WebElement userElement = driver.findElement(By.xpath("//input[@name='username']"));
        userElement.sendKeys(prop.getProperty("login_emp_username"));
        WebElement passElement = driver.findElement(By.xpath("//input[@name='password']"));
        passElement.sendKeys(prop.getProperty("login_password"));
        Select select = new Select(driver.findElement(By.id("user_type")));

        select.selectByVisibleText("Employee");

        WebElement loginButton = driver.findElement(By.xpath("//button[@class='button-one']"));
        loginButton.click();

        new WebDriverWait(driver, 20).until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.xpath("//*[@id=\"root\"]/div/div[2]/div[2]/div[1]/div/div[2]/div/div/div/div[7]/button")));

        WebElement editButton = driver.findElement(By.xpath("//*[@id=\"root\"]/div/div[2]/div[2]/div[1]/div/div[2]/div/div/div/div[7]/button"));
        editButton.click();

        WebElement firstNameE = driver.findElement(firstName);
        firstNameE.sendKeys("Test");
        WebElement lastNameE = driver.findElement(lastName);
        firstNameE.sendKeys("Test");


        Thread.sleep(3000);
        driver.close();
    }
}
