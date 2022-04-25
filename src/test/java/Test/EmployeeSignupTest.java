package Test;

import PageObjects.EmployeeSignupPage;
import PageObjects.HomePage;
import PageObjects.Loginpage;
import PreRequisites.BaseClass;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.time.Duration;


public class EmployeeSignupTest extends BaseClass {

    HomePage home;
    Loginpage login;
    EmployeeSignupPage signup;

    @Test(priority = 1)
    public void validateEmployeeSignup() throws Exception
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

        new WebDriverWait(driver, 5).until(ExpectedConditions.alertIsPresent());

        Assert.assertEquals(driver.switchTo().alert().getText(),properties.getProperty("successMessage"));

        try {
            driver.switchTo().alert().accept();
        }
        catch (Exception e)
        {
            System.out.println("validateEmployeeSignup unsuccessful as alert not shown");
        }
    }

    @Test(priority = 2)
    public void InvalidateSignupByUsername() throws Exception
    {
        try {
            login = new Loginpage(driver);
            login.clickSignUp();
        }
        catch (Exception e)
        {
            System.out.println("signup button element not found as signup unsuccessful");
        }


        signup = new EmployeeSignupPage(driver);
        signup.clearUsername();
        signup.clearMailId();
        signup.clearPassword1();
        signup.clearPassword2();
        signup.enterUsername(properties.getProperty("signup_emp_exist_username"));
        signup.enterMailId(properties.getProperty("signup_emp_exist_mailId"));
        signup.enterPassword1(properties.getProperty("signup_emp_password1"));
        signup.enterPassword2(properties.getProperty("signup_emp_password2"));
        signup.selectOrganization(properties.getProperty("signup_emp_organization"));
        signup.clickSignUp();
        Assert.assertEquals(signup.errorMessage(),properties.getProperty("userErrorMessage"));

    }

    @Test(priority = 3)
    public void InvalidateSignupByPassword()
    {
        signup = new EmployeeSignupPage(driver);
        signup.clearUsername();
        signup.clearMailId();
        signup.clearPassword1();
        signup.clearPassword2();
        signup.enterUsername(properties.getProperty("signup_emp_new_username"));
        signup.enterMailId(properties.getProperty("signup_emp_new_mailId"));
        signup.enterPassword1("");
        signup.enterPassword2("");
        signup.selectOrganization(properties.getProperty("signup_emp_organization"));
        signup.clickSignUp();
        Assert.assertEquals(signup.errorMessage(),properties.getProperty("PasswordErrorMessage"));

    }
}
