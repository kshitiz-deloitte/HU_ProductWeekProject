package PageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
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
    static By nextBtnPath = By.xpath("//span[contains(text(),'Next')]//following-sibling::span");

    public PersonalInformationPage(WebDriver driver)
    {
        this.driver=driver;
    }

    public void clickEditDetailsButton() {
        new WebDriverWait(driver, 20).until(ExpectedConditions.visibilityOfAllElementsLocatedBy(editDetailsButton));
        driver.findElement(editDetailsButton).click();
    }

    public void enterFirstName(String firstName) {
        // Enter First name in Personal Page
        driver.findElement(firstNamePath).sendKeys(Keys.chord(Keys.CONTROL,"a", Keys.DELETE));;
        driver.findElement(firstNamePath).sendKeys(firstName);
    }
    public void enterLastName(String lastName) {
        // Enter Last name in Personal Page
        driver.findElement(lastNamePath).sendKeys(Keys.chord(Keys.CONTROL,"a", Keys.DELETE));;
        driver.findElement(lastNamePath).sendKeys(lastName);
    }
    public void selectGender(String gender) {
        // Selects Gender in Personal Page
        for (WebElement i: driver.findElements(genderListPath)){
            // TODO: Replace the hard coding with the properties file
            if (i.getText().compareTo(gender) == 0)
                i.click();
        }
    }
    public void enterDateOfBirth(String dateOfBirth) {
        // Enter Date of Birth in Personal Page
        driver.findElement(datePickerPath).sendKeys(Keys.chord(Keys.CONTROL,"a", Keys.DELETE));;
        driver.findElement(datePickerPath).sendKeys(dateOfBirth);
    }
    public void enterBloodGroup(String bloodGroup) {
        // Enter Blood Group in Personal Page
        driver.findElement(bloodGroupPath).sendKeys(Keys.chord(Keys.CONTROL,"a", Keys.DELETE));;
        driver.findElement(bloodGroupPath).sendKeys(bloodGroup);
    }
    public void enterCitizenship(String citizenship) {
        // Enter Citizenship in Personal Page
        driver.findElement(citizenshipPath).sendKeys(Keys.chord(Keys.CONTROL,"a", Keys.DELETE));;
        driver.findElement(citizenshipPath).sendKeys(citizenship);
    }
    public void clickNextButton(){
        driver.findElement(nextBtnPath).click();
    }
}
