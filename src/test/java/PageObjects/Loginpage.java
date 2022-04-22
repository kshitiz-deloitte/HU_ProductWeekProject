package PageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

public class Loginpage {
    WebDriver driver;

    static By userName = By.xpath("//input[@placeholder='Login']");
    static By userPassword = By.xpath("//input[@placeholder='Password']");
    static By userRole = By.xpath("//select[@name='user_type']");
    static By login = By.xpath("//button[@class='button-one']");
    static By rememberMe = By.xpath("//input[@type='checkbox']");
    static By signUp = By.xpath("//button[@class='text-button']");


    // constructor to initialize driver
    public Loginpage(WebDriver driver)
    {
        this.driver=driver;
    }

    // method to select remember me option
    public void selectRememberMe()
    {
        driver.findElement(rememberMe).click();
    }

    // method to enter username
    public void enterUsername(String user) {
        driver.findElement(userName).sendKeys(user);
    }

    // method to enter password
    public void enterPassword(String pass) {
        driver.findElement(userPassword).sendKeys(pass);
    }

    // method to select role
    public void selectRole(String role) {
        WebElement webDropdown = driver.findElement(userRole);
        Select dropdown = new Select(webDropdown);
        dropdown.selectByValue(role);
    }

    // method to click login button
    public void clickLogin()
    {
        driver.findElement(login).click();
    }

    // method to click signup button
    public void clickSignUp()
    {
        driver.findElement(signUp).click();
    }
}

