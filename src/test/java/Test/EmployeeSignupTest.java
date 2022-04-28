package Test;

import PageObjects.EmployeeSignupPage;
import PageObjects.HomePage;
import PageObjects.Loginpage;
import PreRequisites.BaseClass;
import org.testng.Assert;
import org.testng.annotations.Test;


public class EmployeeSignupTest extends BaseClass {

    HomePage home;
    Loginpage login;
    EmployeeSignupPage signup;

    @Test(priority = 1)
    // Test case to validate register new employee credentials
    public void validateEmployeeSignup()
    {
        OpenDriver(properties.getProperty("url"));
        home = new HomePage(driver);
        home.clickLogin();

        login = new Loginpage(driver);
        login.clickSignUp();
        signup = new EmployeeSignupPage(driver);
        signup.enterUsername(properties.getProperty("signup_emp_new_username"));
        signup.enterMailId(properties.getProperty("signup_emp_new_mailId"));
        signup.enterPassword1(properties.getProperty("signup_emp_password1"));
        signup.enterPassword2(properties.getProperty("signup_emp_password2"));
        signup.selectOrganization(properties.getProperty("signup_emp_organization"));
        signup.clickSignUp();

        // validate successful registration alert

        try {
            // accept alert
            driver.switchTo().alert().accept();
        }
        catch (Exception e)
        {
            System.out.println("validateEmployeeSignup unsuccessful as alert not shown");
        }
    }

    @Test(priority = 2)
    // Test case to validate error message by sign up employee by registered credentials
    public void InvalidateSignupByUsername()
    {
        try {
            // click login if page redirected to login page
            login = new Loginpage(driver);
            login.clickSignUp();
        }
        catch (Exception e)
        {
            System.out.println("signup button element not found as signup unsuccessful");
        }
        ClearField();
        SignUp_Cred(properties.getProperty("signup_emp_exist_username"),properties.getProperty("signup_emp_exist_mailId"),properties.getProperty("signup_emp_password1"),properties.getProperty("signup_emp_password2"),properties.getProperty("signup_emp_organization"));
        Assert.assertEquals(signup.errorMessage(),properties.getProperty("userErrorMessage"));

    }

    @Test(priority = 3)
    // Test case to validate error message by signup with empty password
    public void InvalidateSignupByPassword()
    {
        ClearField();
        SignUp_Cred(properties.getProperty("signup_emp_new_username"),properties.getProperty("signup_emp_new_mailId"),"","",properties.getProperty("signup_emp_organization"));
        Assert.assertEquals(signup.errorMessage(),properties.getProperty("PasswordErrorMessage"));

    }
    public void ClearField(){
        signup = new EmployeeSignupPage(driver);
        signup.clearUsername();
        signup.clearMailId();
        signup.clearPassword1();
        signup.clearPassword2();
    }
    public void SignUp_Cred(String Username, String Mail, String password, String ConfirmPassword, String Organization){
        signup.enterUsername(Username);
        signup.enterMailId(Mail);
        signup.enterPassword1(password);
        signup.enterPassword2(ConfirmPassword);
        signup.selectOrganization(Organization);
        signup.clickSignUp();
    }
}
