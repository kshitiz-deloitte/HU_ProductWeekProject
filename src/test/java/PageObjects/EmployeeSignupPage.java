package PageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

public class EmployeeSignupPage {
    WebDriver driver;

    // x paths for element in the page

    By username = By.xpath("//input[@placeholder='Enter a username']");
    By mailId = By.xpath("//input[@placeholder='Enter your organisation mail id']");
    By password1 = By.xpath("//input[@placeholder='Enter your password']");
    By password2 = By.xpath("//input[@placeholder='Confirm your password']");
    By organization = By.xpath("//select[@name='company']");
    By signUp = By.xpath("//button[@class='button-one margin-top-1vh']");

    public static By errorMessage = By.xpath("//p[@class='red']");

    // constructor to initialize driver
    public EmployeeSignupPage(WebDriver driver)
    {
        this.driver=driver;
    }

    // method to enter username
    public void enterUsername(String user)
    {
        driver.findElement(username).sendKeys(user);
    }

    // method to enter mail id
    public void enterMailId(String mail)
    {
        driver.findElement(mailId).sendKeys(mail);
    }

    // method to enter password
    public void enterPassword1(String pass1)
    {
        driver.findElement(password1).sendKeys(pass1);
    }

    // method to enter conform password
    public void enterPassword2(String pass2)
    {
        driver.findElement(password2).sendKeys(pass2);
    }

    // method to select organisation
    public void selectOrganization(String organize)
    {
        WebElement webDropdown = driver.findElement(organization);
        Select dropdown = new Select(webDropdown);
        dropdown.selectByValue(organize);
    }

    // method to click signup button
    public void clickSignUp()
    {
        driver.findElement(signUp).click();
    }

    // method to clear text inside username text field
    public void clearUsername()
    {
        WebElement element = driver.findElement(username);
        while(!element.getAttribute("value").equals("")){
            element.sendKeys(Keys.BACK_SPACE);
        }
    }

    // method to clear text inside mail id text field
    public void clearMailId()
    {
        WebElement element = driver.findElement(mailId);
        while(!element.getAttribute("value").equals("")){
            element.sendKeys(Keys.BACK_SPACE);
        }
    }

    // method to clear text inside password text field
    public void clearPassword1()
    {
        WebElement element = driver.findElement(password1);
        while(!element.getAttribute("value").equals("")){
            element.sendKeys(Keys.BACK_SPACE);
        }
    }

    // method to clear text inside conform password text field
    public void clearPassword2()
    {
        WebElement element = driver.findElement(password2);
        while(!element.getAttribute("value").equals("")){
            element.sendKeys(Keys.BACK_SPACE);
        }
    }
}
