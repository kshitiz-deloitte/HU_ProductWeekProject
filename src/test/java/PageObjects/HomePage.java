package PageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class HomePage {
    WebDriver driver;

    static By home = By.xpath("(//a[@href='#top-home'])[1]");
    static By whatWeDo = By.xpath("//a[@href='#whatWeDo']");
    static By aboutUs = By.xpath("(//a[@href='#aboutUs'])[1]");
    static By industries = By.xpath("(//a[@href='#clients'])[1]");
    static By login = By.xpath("//button[@class='btn login']");


    // constructor to initialize driver
    public HomePage(WebDriver driver)
    {
        this.driver=driver;
    }

    public void clickHome()
    {
        // click home button
        driver.findElement(home).click();
    }

    public void clickWhatWeDo()
    {
        // click what we do button
        driver.findElement(whatWeDo).click();
    }

    public void clickAboutUs()
    {
        // click about us button
        driver.findElement(aboutUs).click();
    }

    public void clickIndustries()
    {
        // click Industries button
        driver.findElement(industries).click();
    }

    public void clickLogin()
    {
        // click Industries button
        driver.findElement(login).click();
    }
}
