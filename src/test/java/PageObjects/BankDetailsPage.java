package PageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;

public class BankDetailsPage {
    WebDriver driver;
    static By bankNamePath = By.xpath("//*[@id=\"bankName\"]");
    static By accountNumPath = By.xpath("//*[@id=\"accountNo\"]");
    static By ifscCodePath = By.xpath("//*[@id=\"ifcs\"]");
    static By nextBtnPath = By.xpath("//span[contains(text(),'Next')]//parent::button");

    public BankDetailsPage(WebDriver driver)
    {
        this.driver=driver;
    }

    public void enterBankName(String bankName){
        driver.findElement(bankNamePath).sendKeys(Keys.chord(Keys.CONTROL,"a", Keys.DELETE));;
        driver.findElement(bankNamePath).sendKeys(bankName);
    }

    public void enterAccountNum(String accountNum){
        driver.findElement(accountNumPath).sendKeys(Keys.chord(Keys.CONTROL,"a", Keys.DELETE));;
        driver.findElement(accountNumPath).sendKeys(accountNum);
    }

    public void enterIfscCode(String ifscCode){
        driver.findElement(ifscCodePath).sendKeys(Keys.chord(Keys.CONTROL,"a", Keys.DELETE));;
        driver.findElement(ifscCodePath).sendKeys(ifscCode);
    }

    public void clickNextButton(){
        JavascriptExecutor executor = (JavascriptExecutor)driver;
        executor.executeScript("arguments[0].click();", driver.findElement(nextBtnPath));
    }
}
