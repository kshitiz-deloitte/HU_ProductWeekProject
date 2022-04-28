package PageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;

public class ContactInformationPage {
    WebDriver driver;
    static By houseNumPath = By.xpath("//input[@id=\"houseNo\"]");
    static By areaPath = By.xpath("//input[@id=\"area\"]");
    static By cityPath = By.xpath("//input[@id=\"city\"]");
    static By statePath = By.xpath("//input[@id=\"state\"]");
    static By pinCodePath = By.xpath("//input[@id=\"pinCode\"]");
    static By countryPath = By.xpath("//input[@id=\"country\"]");
    static By contactNumPath = By.xpath("//input[@id=\"contactNo\"]");
    static By nextBtnPath = By.xpath("//span[contains(text(),'Next')]//parent::button");

    public ContactInformationPage(WebDriver driver)
    {
        this.driver=driver;
    }

    // Enter House Number in Contact Information Page
    public void enterHouseNumber(String houseNum){

        driver.findElement(houseNumPath).sendKeys(Keys.chord(Keys.CONTROL,"a", Keys.DELETE));
        driver.findElement(houseNumPath).sendKeys(houseNum);
    }
    // Enter Area Name in Contact Information Page
    public void enterArea(String area){
        driver.findElement(areaPath).sendKeys(Keys.chord(Keys.CONTROL,"a", Keys.DELETE));
        driver.findElement(areaPath).sendKeys(area);
    }
    // Enter City Name in Contact Information Page
    public void enterCity(String city){
        driver.findElement(cityPath).sendKeys(Keys.chord(Keys.CONTROL,"a", Keys.DELETE));
        driver.findElement(cityPath).sendKeys(city);
    }
    // Enter State Name in Contact Information Page
    public void enterState (String state){
        driver.findElement(statePath).sendKeys(Keys.chord(Keys.CONTROL,"a", Keys.DELETE));
        driver.findElement(statePath).sendKeys(state);
    }
    // Enter Pin Code in Contact Information Page
    public void enterPinCode(String pinCode){
        driver.findElement(pinCodePath).sendKeys(Keys.chord(Keys.CONTROL,"a", Keys.DELETE));
        driver.findElement(pinCodePath).sendKeys(pinCode);
    }
    // Enter Country Name in Contact Information Page
    public void enterCountry(String country){
        driver.findElement(countryPath).sendKeys(Keys.chord(Keys.CONTROL,"a", Keys.DELETE));
        driver.findElement(countryPath).sendKeys(country);
    }
    // Enter Contact Number in Contact Information Page
    public void enterContactNumber(String contactNumber){
        driver.findElement(contactNumPath).sendKeys(Keys.chord(Keys.CONTROL,"a", Keys.DELETE));
        driver.findElement(contactNumPath).sendKeys(contactNumber);
    }
    // Click Next Button in Contact Information Page
    public void clickNextButton(){
        JavascriptExecutor executor = (JavascriptExecutor)driver;
        executor.executeScript("arguments[0].click();", driver.findElement(nextBtnPath));
    }
}
