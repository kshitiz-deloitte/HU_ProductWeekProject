package PageObjects;

import org.openqa.selenium.By;
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

    public EducationalInformationPage(WebDriver driver)
    {
        this.driver=driver;
    }

    public void enterHighestEducationDegree(String highestEducationDegree) {
        // Enter The Highest Education Degree in Educational Information Page
        driver.findElement(highestEducationDegreePath).sendKeys(Keys.chord(Keys.CONTROL,"a", Keys.DELETE));;
        driver.findElement(highestEducationDegreePath).sendKeys(highestEducationDegree);
    }

    public void enterCollegeName(String collegeName){
        // Enter College Name in Educational Information Page
        driver.findElement(collegeNamePath).sendKeys(Keys.chord(Keys.CONTROL,"a", Keys.DELETE));;
        driver.findElement(collegeNamePath).sendKeys(collegeName);
    }

    public void enterUniversityName(String universityName){
        // Enter University Name in Educational Information Page
        driver.findElement(universityPath).sendKeys(Keys.chord(Keys.CONTROL,"a", Keys.DELETE));;
        driver.findElement(universityPath).sendKeys(universityName);
    }

    public void enterCPI(String CPI){
        // Enter CPI in Educational Information Page
        driver.findElement(cpiPath).sendKeys(Keys.chord(Keys.CONTROL,"a", Keys.DELETE));;
        driver.findElement(cpiPath).sendKeys(CPI);
    }

    public void enterYearOfPassing(String yearOfPassing){
        // Enter Year Of Passing in Educational Information Page
        driver.findElement(yearOfPassingPath).sendKeys(Keys.chord(Keys.CONTROL,"a", Keys.DELETE));;
        driver.findElement(yearOfPassingPath).sendKeys(yearOfPassing);
    }
    public void clickNextButton(){
        // Click Next Button in Educational Information Page
        driver.findElement(nextBtnPath).click();
    }

}
