package PageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;

public class EducationalInformationPage {
    WebDriver driver;
    static By highestEducationDegreePath = By.xpath("//input[@id='highestEducationDegree']");
    static By collegeNamePath = By.xpath("//input[@id='=college']");
    static By universityPath = By.xpath("//*[@id=\"university\"]");
    static By cpiPath = By.xpath("//*[@id=\"cpi\"]");
    static By yearOfPassingPath = By.xpath("//*[@id=\"yearOfPassing\"]");
    static By nextBtnPath = By.xpath("//span[contains(text(),'Next')]//parent::button");

    // Constructor For the Class to initialize the driver
    public EducationalInformationPage(WebDriver driver)
    {
        this.driver=driver;
    }

    // Enter The Highest Education Degree in Educational Information Page
    public void enterHighestEducationDegree(String highestEducationDegree) {
        driver.findElement(highestEducationDegreePath).sendKeys(Keys.chord(Keys.CONTROL,"a", Keys.DELETE));
        driver.findElement(highestEducationDegreePath).sendKeys(highestEducationDegree);
    }
    // Enter College Name in Educational Information Page
    public void enterCollegeName(String collegeName){
        driver.findElement(collegeNamePath).sendKeys(Keys.chord(Keys.CONTROL,"a", Keys.DELETE));
        driver.findElement(collegeNamePath).sendKeys(collegeName);
    }
    // Enter University Name in Educational Information Page
    public void enterUniversityName(String universityName){
        driver.findElement(universityPath).sendKeys(Keys.chord(Keys.CONTROL,"a", Keys.DELETE));
        driver.findElement(universityPath).sendKeys(universityName);
    }
    // Enter CPI in Educational Information Page
    public void enterCPI(String CPI){
        driver.findElement(cpiPath).sendKeys(Keys.chord(Keys.CONTROL,"a", Keys.DELETE));
        driver.findElement(cpiPath).sendKeys(CPI);
    }
    // Enter Year Of Passing in Educational Information Page
    public void enterYearOfPassing(String yearOfPassing){
        driver.findElement(yearOfPassingPath).sendKeys(Keys.chord(Keys.CONTROL,"a", Keys.DELETE));
        driver.findElement(yearOfPassingPath).sendKeys(yearOfPassing);
    }
    // Click Next Button in Educational Information Page
    public void clickNextButton(){
        JavascriptExecutor executor = (JavascriptExecutor)driver;
        executor.executeScript("arguments[0].click();", driver.findElement(nextBtnPath));
    }

}
