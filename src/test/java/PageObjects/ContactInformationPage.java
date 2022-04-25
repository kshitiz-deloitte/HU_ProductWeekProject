package PageObjects;

import org.openqa.selenium.By;
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

    // Enter College Name in Educational Information Page
    public void enterHouseNumber(String houseNum){

        driver.findElement(houseNumPath).sendKeys(Keys.chord(Keys.CONTROL,"a", Keys.DELETE));;
        driver.findElement(houseNumPath).sendKeys(houseNum);
    }

    public void enterArea(String area){
        driver.findElement(areaPath).sendKeys(Keys.chord(Keys.CONTROL,"a", Keys.DELETE));;
        driver.findElement(areaPath).sendKeys(area);
    }

    public void enterCity(String city){
        driver.findElement(cityPath).sendKeys(Keys.chord(Keys.CONTROL,"a", Keys.DELETE));;
        driver.findElement(cityPath).sendKeys(city);
    }

    public void enterState (String state){
        driver.findElement(statePath).sendKeys(Keys.chord(Keys.CONTROL,"a", Keys.DELETE));;
        driver.findElement(statePath).sendKeys(state);
    }

    public void enterPinCode(String pinCode){
        driver.findElement(pinCodePath).sendKeys(Keys.chord(Keys.CONTROL,"a", Keys.DELETE));;
        driver.findElement(pinCodePath).sendKeys(pinCode);
    }

    public void enterCountry(String country){
        driver.findElement(countryPath).sendKeys(Keys.chord(Keys.CONTROL,"a", Keys.DELETE));;
        driver.findElement(countryPath).sendKeys(country);
    }

    public void enterContactNumber(String contactNumber){
        driver.findElement(contactNumPath).sendKeys(Keys.chord(Keys.CONTROL,"a", Keys.DELETE));;
        driver.findElement(contactNumPath).sendKeys(contactNumber);
    }

    public void clickNextButton(){
        driver.findElement(nextBtnPath).click();
    }
}
