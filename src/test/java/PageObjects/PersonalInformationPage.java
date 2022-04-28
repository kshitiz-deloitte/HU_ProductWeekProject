package PageObjects;

import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class PersonalInformationPage {
    WebDriver driver;

    static By editDetailsButton = By.xpath("(//span[contains(text(),'Edit Details')])[1]//parent::button");
    static By firstNamePath = By.xpath("//input[@name='firstName']");
    static By lastNamePath = By.xpath("//input[@name='lastName']");
    static By genderListPath = By.xpath("//div[@aria-labelledby='demo-radio-buttons-group-label']//child::label");
    static By datePickerPath = By.xpath("//input[@id='dob']");
    static By bloodGroupPath = By.xpath("//input[@name='bloodGroup']");
    static By citizenshipPath = By.xpath("//input[@id='citizenship']");
    static By nextBtnPath = By.xpath("//span[contains(text(),'Next')]//parent::button");

    public PersonalInformationPage(WebDriver driver)
    {
        this.driver=driver;
    }

    // Clicks Edit Details in Personal Page
    public void clickEditDetailsButton() {
        new WebDriverWait(driver, 20).until(ExpectedConditions.visibilityOfAllElementsLocatedBy(editDetailsButton));
        driver.findElement(editDetailsButton).click();
    }
    // Enter First name in Personal Page
    public void enterFirstName(String firstName) {
        driver.findElement(firstNamePath).sendKeys(Keys.chord(Keys.CONTROL,"a", Keys.DELETE));
        driver.findElement(firstNamePath).sendKeys(firstName);
    }
    // Enter Last name in Personal Page
    public void enterLastName(String lastName) {
        driver.findElement(lastNamePath).sendKeys(Keys.chord(Keys.CONTROL,"a", Keys.DELETE));
        driver.findElement(lastNamePath).sendKeys(lastName);
    }
    // Selects Gender in Personal Page
    public void selectGender(String gender) {
        for (WebElement i: driver.findElements(genderListPath)){
            if (i.getText().compareTo(gender) == 0)
                i.click();
        }
    }
    // Enter Date of Birth in Personal Page
    public void enterDateOfBirth(String dateOfBirth) {
        driver.findElement(datePickerPath).sendKeys(Keys.chord(Keys.CONTROL,"a", Keys.DELETE));
        driver.findElement(datePickerPath).sendKeys(dateOfBirth);
    }
    // Enter Blood Group in Personal Page
    public void enterBloodGroup(String bloodGroup) {
        driver.findElement(bloodGroupPath).sendKeys(Keys.chord(Keys.CONTROL,"a", Keys.DELETE));
        driver.findElement(bloodGroupPath).sendKeys(bloodGroup);
    }
    // Enter Citizenship in Personal Page
    public void enterCitizenship(String citizenship) {
        driver.findElement(citizenshipPath).sendKeys(Keys.chord(Keys.CONTROL,"a", Keys.DELETE));
        driver.findElement(citizenshipPath).sendKeys(citizenship);
    }
    //Click Next Button in Personal Page
    public void clickNextButton(){
        JavascriptExecutor executor = (JavascriptExecutor)driver;
        executor.executeScript("arguments[0].click();", driver.findElement(nextBtnPath));
    }
}
