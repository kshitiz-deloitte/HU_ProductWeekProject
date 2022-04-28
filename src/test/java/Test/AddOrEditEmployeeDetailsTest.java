package Test;

import PageObjects.*;
import PreRequisites.BaseClass;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.ArrayList;

public class AddOrEditEmployeeDetailsTest extends BaseClass {
    HomePage homePage;
    Loginpage loginPage;
    PersonalInformationPage personalInformationPage;
    EducationalInformationPage educationalInformationPage;
    ContactInformationPage contactInformationPage;
    BankDetailsPage bankDetailsPage;
    EmployeeHistoryPage employeeHistoryPage;
    FinalStepPage finalStepPage;
    EmployeeDashboardPage employeeDashboardPage;

    // Enter Employee Personal Details
    @Test(priority = 1)
    public void enterEmployeePersonalDetails() throws InterruptedException {
        OpenDriver(properties.getProperty("url"));
        homePage= new HomePage(driver);
        loginPage=new Loginpage(driver);
        personalInformationPage = new PersonalInformationPage(driver);
        employeeDashboardPage = new EmployeeDashboardPage(driver);
        homePage.clickLogin();
        loginPage.enterUsername(properties.getProperty("login_emp_username"));
        loginPage.enterPassword(properties.getProperty("login_password"));
        loginPage.selectRole(role[0]);
        loginPage.clickLogin();
        personalInformationPage.clickEditDetailsButton();
        personalInformationPage.enterFirstName(employeeDetails.get(0));
        personalInformationPage.enterLastName(employeeDetails.get(1));
        personalInformationPage.selectGender(employeeDetails.get(2));
        personalInformationPage.enterDateOfBirth(properties.getProperty("date_of_birth"));
        personalInformationPage.enterBloodGroup(employeeDetails.get(4));
        personalInformationPage.enterCitizenship(employeeDetails.get(5));
        personalInformationPage.clickNextButton();
    }
    // Enter Employee Educational Details
    @Test(priority = 2)
    public void enterEmployeeEducationalDetails(){
        educationalInformationPage = new EducationalInformationPage(driver);
        educationalInformationPage.enterHighestEducationDegree(employeeDetails.get(6));
        educationalInformationPage.enterCollegeName(employeeDetails.get(7));
        educationalInformationPage.enterUniversityName(employeeDetails.get(8));
        educationalInformationPage.enterCPI(employeeDetails.get(9));
        educationalInformationPage.enterYearOfPassing(properties.getProperty("date_of_passing"));
        educationalInformationPage.clickNextButton();
    }
    // Enter Contact Details Of the Employee
    @Test(priority = 3)
    public void enterContactDetails(){
        contactInformationPage = new ContactInformationPage(driver);
        contactInformationPage.enterHouseNumber(employeeDetails.get(11));
        contactInformationPage.enterArea(employeeDetails.get(12));
        contactInformationPage.enterCity(employeeDetails.get(13));
        contactInformationPage.enterState(employeeDetails.get(14));
        contactInformationPage.enterPinCode(employeeDetails.get(15));
        contactInformationPage.enterCountry(employeeDetails.get(16));
        contactInformationPage.enterContactNumber(employeeDetails.get(17));
        contactInformationPage.clickNextButton();
    }
    // Enter the Bank Details of Employee
    @Test(priority = 4)
    public void enterBankDetails(){
        bankDetailsPage = new BankDetailsPage(driver);
        bankDetailsPage.enterBankName(employeeDetails.get(18));
        bankDetailsPage.enterAccountNum(employeeDetails.get(19));
        bankDetailsPage.enterIfscCode(employeeDetails.get(20));
        bankDetailsPage.clickNextButton();
    }
    // Enter the Employment History of the Employee
    @Test(priority = 5)
    public void enterEmploymentHistory(){
        employeeHistoryPage = new EmployeeHistoryPage(driver);
        employeeHistoryPage.enterTotalYrOfExperience(employeeDetails.get(21));
        employeeHistoryPage.enterPreviousCompany(employeeDetails.get(22));
        employeeHistoryPage.enterUanNum(employeeDetails.get(23));
        employeeHistoryPage.enterJoinDate(properties.getProperty("join_date"));
        employeeHistoryPage.enterExitDate(properties.getProperty("exit_date"));
        employeeHistoryPage.clickNextButton();
    }
    // Validate the Data that is provided by the user with the data that is displayed in the Employee Dashboard
    @Test(priority = 6)
    public void validateEmployeeDetailsInEmployeeDashboard() throws InterruptedException {
        finalStepPage = new FinalStepPage(driver);
        employeeDashboardPage = new EmployeeDashboardPage(driver);
        finalStepPage.clickFinishButton();
        ArrayList<String> empDetails = employeeDashboardPage.getEmployeeDetails();
        for(int count=0; count<empDetails.size();count++){
            Assert.assertEquals(employeeDetails.get(count).toLowerCase(), empDetails.get(count).toLowerCase());
        }
    }
}
