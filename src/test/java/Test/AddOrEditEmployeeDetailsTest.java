package Test;

import PageObjects.*;
import PreRequisites.BaseClass;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

public class AddOrEditEmployeeDetailsTest extends BaseClass {
    WebDriverWait wait;
    HomePage homePage;
    Loginpage loginPage;
    PersonalInformationPage personalInformationPage;
    EducationalInformationPage educationalInformationPage;
    ContactInformationPage contactInformationPage;
    BankDetailsPage bankDetailsPage;
    EmployeeHistoryPage employeeHistoryPage;
    FinalStepPage finalStepPage;
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
        personalInformationPage.clickNextButton();
    }

    @Test(priority = 2)
    public void enterEmployeeEducationalDetails(){
        educationalInformationPage = new EducationalInformationPage(driver);
        educationalInformationPage.enterHighestEducationDegree(properties.getProperty("highest_education_degree"));
        educationalInformationPage.enterCollegeName(properties.getProperty("college_name"));
        educationalInformationPage.enterUniversityName(properties.getProperty("university"));
        educationalInformationPage.enterCPI(properties.getProperty("cpi"));
        educationalInformationPage.enterYearOfPassing(properties.getProperty("year_of_passing"));
        educationalInformationPage.clickNextButton();
        System.out.println("Test Success");
    }

    @Test(priority = 3)
    public void enterContactDetails(){
        contactInformationPage = new ContactInformationPage(driver);
        contactInformationPage.enterHouseNumber(properties.getProperty("house_number"));
        contactInformationPage.enterArea(properties.getProperty("area"));
        contactInformationPage.enterCity(properties.getProperty("city"));
        contactInformationPage.enterState(properties.getProperty("state"));
        contactInformationPage.enterPinCode(properties.getProperty("pin_code"));
        contactInformationPage.enterCountry(properties.getProperty("country"));
        contactInformationPage.enterContactNumber(properties.getProperty("contact_num"));
        contactInformationPage.clickNextButton();
    }

    @Test(priority = 4)
    public void enterBankDetails(){
        bankDetailsPage = new BankDetailsPage(driver);
        bankDetailsPage.enterBankName(properties.getProperty("bank_name"));
        bankDetailsPage.enterAccountNum(properties.getProperty("account_num"));
        bankDetailsPage.enterIfscCode(properties.getProperty("ifsc_code"));
        bankDetailsPage.clickNextButton();
    }

    @Test(priority = 5)
    public void enterEmploymentHistory(){
        employeeHistoryPage = new EmployeeHistoryPage(driver);
        employeeHistoryPage.enterTotalYrOfExperience(properties.getProperty("total_year_of_experience"));
        employeeHistoryPage.enterPreviousCompany(properties.getProperty("previous_company"));
        employeeHistoryPage.enterUanNum(properties.getProperty("uan_num"));
        employeeHistoryPage.enterJoinDate(properties.getProperty("joining_date"));
        employeeHistoryPage.enterExitDate(properties.getProperty("exit_date"));
        employeeHistoryPage.clickNextButton();
    }

    @Test(priority = 6)
    public void validateEmployeeDetailsInEmployeeDashboard() throws InterruptedException {
        finalStepPage = new FinalStepPage(driver);
        finalStepPage.clickFinishButton();
        Thread.sleep(3000);
    }
}
