package PageObjects;

import org.openqa.selenium.By;
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

    public void enterTotalYrOfExperience(String experience){
        driver.findElement(totalYrOfExperiencePath).sendKeys(Keys.chord(Keys.CONTROL,"a", Keys.DELETE));;
        driver.findElement(totalYrOfExperiencePath).sendKeys(experience);
    }

    public void enterPreviousCompany(String previousCompany){
        driver.findElement(previousCompanyPath).sendKeys(Keys.chord(Keys.CONTROL,"a", Keys.DELETE));;
        driver.findElement(previousCompanyPath).sendKeys(previousCompany);
    }

    public void enterUanNum(String uanNum){
        driver.findElement(uanNumPath).sendKeys(Keys.chord(Keys.CONTROL,"a", Keys.DELETE));;
        driver.findElement(uanNumPath).sendKeys(uanNum);
    }

    public void enterJoinDate(String joinDate){
        driver.findElement(joinDatePath).sendKeys(Keys.chord(Keys.CONTROL,"a", Keys.DELETE));;
        driver.findElement(joinDatePath).sendKeys(joinDate);
    }

    public void enterExitDate(String exitDate){
        driver.findElement(exitDatePath).sendKeys(Keys.chord(Keys.CONTROL,"a", Keys.DELETE));;
        driver.findElement(exitDatePath).sendKeys(exitDate);
    }

    public void clickNextButton(){
        driver.findElement(nextBtnPath).click();
    }
}
