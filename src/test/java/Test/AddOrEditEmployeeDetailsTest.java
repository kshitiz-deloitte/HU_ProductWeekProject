package Test;

import PageObjects.HomePage;
import PageObjects.Loginpage;
import PageObjects.PersonalInformationPage;
import PreRequisites.BaseClass;
import org.testng.annotations.Test;

public class AddOrEditEmployeeDetailsTest extends BaseClass {
    HomePage homePage;
    Loginpage loginPage;
    PersonalInformationPage personalInformationPage;
    @Test(priority = 1)
    public void enterEmployeePersonalDetails() throws InterruptedException {
        OpenDriver(properties.getProperty("url"));
        homePage= new HomePage(driver);
        loginPage=new Loginpage(driver);
        personalInformationPage = new PersonalInformationPage(driver);
        homePage.clickLogin();
        loginPage.enterUsername(properties.getProperty("login_emp_username"));
        loginPage.enterPassword(properties.getProperty("login_password"));
        loginPage.selectRole(role[0]);
        loginPage.clickLogin();
        personalInformationPage.clickEditDetailsButton();
        personalInformationPage.enterFirstName(properties.getProperty("first_name"));
        personalInformationPage.enterLastName(properties.getProperty("last_name"));
        personalInformationPage.selectGender(properties.getProperty("gender"));
        personalInformationPage.enterDateOfBirth(properties.getProperty("date_of_birth"));
        personalInformationPage.enterBloodGroup(properties.getProperty("blood_group"));
        personalInformationPage.enterCitizenship(properties.getProperty("citizenship"));
        Thread.sleep(2000);
        personalInformationPage.clickNextButton();

    }
}
