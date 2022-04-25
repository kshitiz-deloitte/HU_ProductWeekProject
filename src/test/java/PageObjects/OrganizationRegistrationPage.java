package PageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

//contains page objects of organization registration Page
public class OrganizationRegistrationPage {

    WebDriver driver;

    //declaring xpaths of different elements of page
    static By companyName = By.xpath("//input[@name='companyName']");
    static By companyPan = By.xpath("//input[@name='companyPan']");
    static By companyGst = By.xpath("//input[@name='companyGst']");
    static By industry = By.xpath("//input[@name='industry']");
    static By contactEmail = By.xpath("//input[@name='email']");
    static By password = By.xpath("//input[@name='password']");
    static By contactNumber = By.xpath("//input[@name='phone']");
    static By address = By.xpath("//input[@name='address']");
    static By register = By.xpath("//button[text()='Register']");
    static By passwordToggle = By.xpath("//*[@id='root']/div/div/form/div/div[2]/span");

    // constructor to initialize driver
    public OrganizationRegistrationPage(WebDriver driver){
        this.driver=driver;
    }

    // setting company name to company name element on registration page
    public void setCompanyName(String companyName) {
        driver.findElement(OrganizationRegistrationPage.companyName).sendKeys(companyName);
    }
    // setting company Pan to company Pan element on registration page
    public void setCompanyPan(String companyPan){
        driver.findElement(OrganizationRegistrationPage.companyPan).sendKeys(companyPan);
    }
    // setting company Gst to company Gst element on registration page
    public void setCompanyGst(String companyGst){
        driver.findElement(OrganizationRegistrationPage.companyGst).sendKeys(companyGst);
    }
    // setting industry to industry element on registration page
    public void setIndustry(String industry){
        driver.findElement(OrganizationRegistrationPage.industry).sendKeys(industry);
    }
    // setting contact email to contact email element on registration page
    public void setContactEmail(String contactEmail){
        driver.findElement(OrganizationRegistrationPage.contactEmail).sendKeys(contactEmail);
    }
    // setting password to password element on registration page
    public void setPassword(String password){
        driver.findElement(OrganizationRegistrationPage.password).sendKeys(password);
    }
    // setting contact number to contact number element on registration page
    public void setContactNumber(String contactNumber){
        driver.findElement(OrganizationRegistrationPage.contactNumber).sendKeys(contactNumber);
    }
    // setting address to address element on registration page
    public void setAddress(String address){
        driver.findElement(OrganizationRegistrationPage.address).sendKeys(address);
    }
    // clicking register button
    public void pressRegister(){
        driver.findElement(OrganizationRegistrationPage.register).click();
    }
    // clearing company name input element on registration page
    public void clearCompanyName() {
        driver.findElement(OrganizationRegistrationPage.companyName).clear();
    }
    // clearing company Pan input element on registration page
    public void clearCompanyPan(){
        driver.findElement(OrganizationRegistrationPage.companyPan).clear();
    }
    // clicking password toggle button
    public void clickPasswordToggle(){
        driver.findElement(passwordToggle).click();
    }
    // return password as webElement
    public WebElement password(){
        return driver.findElement(passwordToggle);
    }
}
