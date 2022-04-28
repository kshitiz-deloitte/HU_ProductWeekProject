package PageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;

public class EmployeeHistoryPage {
    WebDriver driver;
    static By totalYrOfExperiencePath = By.xpath("//*[@id=\"totalYearsOfExperience\"]");
    static By previousCompanyPath = By.xpath("//*[@id=\"previousCompany\"]");
    static By uanNumPath = By.xpath("//*[@id=\"uan\"]");
    static By joinDatePath = By.xpath("//*[@id=\"joiningDate\"]");
    static By exitDatePath = By.xpath("//*[@id=\"exitDate\"]");
    static By nextBtnPath = By.xpath("//span[contains(text(),'Next')]//parent::button");

    public EmployeeHistoryPage(WebDriver driver)
    {
        this.driver=driver;
    }

    // Enter Total Year Of Experience in Employee History Page
    public void enterTotalYrOfExperience(String experience){
        driver.findElement(totalYrOfExperiencePath).sendKeys(Keys.chord(Keys.CONTROL,"a", Keys.DELETE));
        driver.findElement(totalYrOfExperiencePath).sendKeys(experience);
    }
    // Enter Previous Company Name in Employee History Page
    public void enterPreviousCompany(String previousCompany){
        driver.findElement(previousCompanyPath).sendKeys(Keys.chord(Keys.CONTROL,"a", Keys.DELETE));
        driver.findElement(previousCompanyPath).sendKeys(previousCompany);
    }
    // Enter UAN Number in Employee History Page
    public void enterUanNum(String uanNum){
        driver.findElement(uanNumPath).sendKeys(Keys.chord(Keys.CONTROL,"a", Keys.DELETE));
        driver.findElement(uanNumPath).sendKeys(uanNum);
    }
    // Enter Join Date in Employee History Page
    public void enterJoinDate(String joinDate){
        driver.findElement(joinDatePath).sendKeys(Keys.chord(Keys.CONTROL,"a", Keys.DELETE));
        driver.findElement(joinDatePath).sendKeys(joinDate);
    }
    // Enter Exit Date in Employee History Page
    public void enterExitDate(String exitDate){
        driver.findElement(exitDatePath).sendKeys(Keys.chord(Keys.CONTROL,"a", Keys.DELETE));
        driver.findElement(exitDatePath).sendKeys(exitDate);
    }
    // Click Next Button in Employee History Page
    public void clickNextButton(){
        JavascriptExecutor executor = (JavascriptExecutor)driver;
        executor.executeScript("arguments[0].click();", driver.findElement(nextBtnPath));
    }
}
