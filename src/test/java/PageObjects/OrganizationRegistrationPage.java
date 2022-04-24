/**
 Kritik Bansal
 23-April-2022
 */
package PageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class OrganizationRegistrationPage {

    WebDriver driver;

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

    public void setCompanyName(String companyName) {
        driver.findElement(OrganizationRegistrationPage.companyName).sendKeys(companyName);
    }
    public void setCompanyPan(String companyPan){
        driver.findElement(OrganizationRegistrationPage.companyPan).sendKeys(companyPan);
    }
    public void setCompanyGst(String companyGst){
        driver.findElement(OrganizationRegistrationPage.companyGst).sendKeys(companyGst);
    }
    public void setIndustry(String industry){
        driver.findElement(OrganizationRegistrationPage.industry).sendKeys(industry);
    }
    public void setContactEmail(String contactEmail){
        driver.findElement(OrganizationRegistrationPage.contactEmail).sendKeys(contactEmail);
    }
    public void setPassword(String password){
        driver.findElement(OrganizationRegistrationPage.password).sendKeys(password);
    }
    public void setContactNumber(String contactNumber){
        driver.findElement(OrganizationRegistrationPage.contactNumber).sendKeys(contactNumber);
    }
    public void setAddress(String address){
        driver.findElement(OrganizationRegistrationPage.address).sendKeys(address);
    }
    public void pressRegister(){
        driver.findElement(OrganizationRegistrationPage.register).click();
    }
    public void clearCompanyName() {
        driver.findElement(OrganizationRegistrationPage.companyName).clear();
    }
    public void clearCompanyPan(){
        driver.findElement(OrganizationRegistrationPage.companyPan).clear();
    }
    public String getPassword(){
        return driver.findElement(password).getText();
    }
    public void clickPasswordToggle(){
        driver.findElement(passwordToggle).click();
    }
    public WebElement password(){
        return driver.findElement(passwordToggle);
    }
}
