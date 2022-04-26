package PageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;

public class FinalStepPage {
    WebDriver driver;
    static By finishBtnPath = By.xpath("//span[contains(text(),'Finish')]//parent::button");
    public FinalStepPage(WebDriver driver)
    {
        this.driver=driver;
    }

    public void clickFinishButton(){
        JavascriptExecutor executor = (JavascriptExecutor)driver;
        executor.executeScript("arguments[0].click();", driver.findElement(finishBtnPath));
    }
}
