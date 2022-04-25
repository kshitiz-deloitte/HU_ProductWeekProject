package PageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class HomePage {
    WebDriver driver;

    // x paths for element in the page

    static By home = By.xpath("(//a[@href='#top-home'])[1]");
    static By whatWeDo = By.xpath("//a[@href='#whatWeDo']");
    static By aboutUs = By.xpath("(//a[@href='#aboutUs'])[1]");
    static By industries = By.xpath("(//a[@href='#clients'])[1]");
    static By login = By.xpath("//button[@class='btn login']");
    static By homeBottom = By.xpath("(//a[@href='#top-home'])[2]");
    static By ourClients = By.xpath("(//a[@href='#clients'])[2]");
    static By aboutUsBottom = By.xpath("(//a[@href='#aboutUs'])[2]");
    static By organizationRegistration = By.xpath("//*[@id='top-home']/div[1]/div/button");


    // constructor to initialize driver
    public HomePage(WebDriver driver)
    {
        this.driver=driver;
    }

    // method to click home button
    public void clickHome()
    {
        driver.findElement(home).click();
    }

    // method to click what we do button
    public void clickWhatWeDo()
    {
        driver.findElement(whatWeDo).click();
    }

    // method to click about us button
    public void clickAboutUs()
    {
        driver.findElement(aboutUs).click();
    }

    // method to click Industries button
    public void clickIndustries()
    {
        driver.findElement(industries).click();
    }

    // method to click login button
    public void clickLogin()
    {
        driver.findElement(login).click();
    }

    // method to click home button on the bottom of the page
    public void clickHomeBottom()
    {
        WebElement element = driver.findElement(homeBottom);
        JavascriptExecutor executor = (JavascriptExecutor)driver;
        executor.executeScript("arguments[0].click();", element);
    }

    // method to click our clients button on the bottom of the page
    public void clickOurClient()
    {
        WebElement element = driver.findElement(ourClients);
        JavascriptExecutor executor = (JavascriptExecutor)driver;
        executor.executeScript("arguments[0].click();", element);
    }

    // method to click about us button on the bottom of the page
    public void clickAboutUsBottom() {
        WebElement element = driver.findElement(aboutUsBottom);
        JavascriptExecutor executor = (JavascriptExecutor) driver;
        executor.executeScript("arguments[0].click();", element);
    }

    public WebElement organizationRegistrationButton(){
        return driver.findElement(organizationRegistration);
    }

    public String getButtonText(){
        return driver.findElement(login).getText();
    }
}
