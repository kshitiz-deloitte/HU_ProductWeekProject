package PageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

public class EmployeeSignupPage {
    WebDriver driver;

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
    public void enterUsername(String user)
    {
        // enter username
        driver.findElement(username).sendKeys(user);
    }

    public void enterMailId(String mail)
    {
        // enter mail id
        driver.findElement(mailId).sendKeys(mail);
    }

    public void enterPassword1(String pass1)
    {
        // enter password1
        driver.findElement(password1).sendKeys(pass1);
    }

    public void enterPassword2(String pass2)
    {
        // enter password2
        driver.findElement(password2).sendKeys(pass2);
    }

    public void selectOrganization(String organize)
    {
        // select organisation
        WebElement webDropdown = driver.findElement(organization);
        Select dropdown = new Select(webDropdown);
        dropdown.selectByValue(organize);
    }

    public void clickSignUp()
    {
        // click signup button
        driver.findElement(signUp).click();
    }
}
