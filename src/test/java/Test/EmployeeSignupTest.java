package Test;

import PageObjects.EmployeeSignupPage;
import PageObjects.HomePage;
import PageObjects.Loginpage;
import PreRequisites.BaseClass;
import org.testng.Assert;
import org.testng.annotations.Test;


public class EmployeeSignupTest extends BaseClass {

    String successMessage = "Sign-Up successfull";
    String userErrorMessage = "Username and Mail Id should be unique !!";
    String PasswordErrorMessage = "Password should be more than five digits !!";

    @Test(priority = 1)
    public void validateEmployeeSignup() throws Exception
    {
        HomePage home = new HomePage(driver);
        home.clickLogin();

        Loginpage login = new Loginpage(driver);
        login.clickSignUp();

        EmployeeSignupPage signup = new EmployeeSignupPage(driver);
        signup.enterUsername(prop.getProperty("signup_emp_new_username"));
        signup.enterMailId(prop.getProperty("signup_emp_new_mailId"));
        signup.enterPassword1(prop.getProperty("signup_emp_password1"));
        signup.enterPassword2(prop.getProperty("signup_emp_password2"));
        signup.selectOrganization(prop.getProperty("signup_emp_organization"));
        signup.clickSignUp();
        Thread.sleep(3000);
        try {
            Assert.assertEquals(driver.switchTo().alert().getText(),successMessage);
            driver.switchTo().alert().accept();
        }
        catch (Exception e)
        {
            System.out.println("validateEmployeeSignup unsuccessful");
        }
    }

    @Test(priority = 2)
    public void InvalidateSignupByUsername() throws Exception
    {
        Thread.sleep(3000);
        try {
            Loginpage login = new Loginpage(driver);
            login.clickSignUp();
        }
        catch (Exception e)
        {
            System.out.println("signup button element not found as signup unsuccessful");
        }


        EmployeeSignupPage signup = new EmployeeSignupPage(driver);
        signup.clearUsername();
        signup.clearMailId();
        signup.clearPassword1();
        signup.clearPassword2();
        signup.enterUsername(prop.getProperty("signup_emp_exist_username"));
        signup.enterMailId(prop.getProperty("signup_emp_exist_mailId"));
        signup.enterPassword1(prop.getProperty("signup_emp_password1"));
        signup.enterPassword2(prop.getProperty("signup_emp_password2"));
        signup.selectOrganization(prop.getProperty("signup_emp_organization"));
        signup.clickSignUp();
        try {
            Assert.assertEquals(driver.findElement(signup.errorMessage).getAttribute("textContent"),userErrorMessage);
        }
        catch (Exception e)
        {
            System.out.println("InvalidateSignupByUsername unsuccessful");
        }
    }

    @Test(priority = 3)
    public void InvalidateSignupByPassword()
    {
        EmployeeSignupPage signup = new EmployeeSignupPage(driver);
        signup.clearUsername();
        signup.clearMailId();
        signup.clearPassword1();
        signup.clearPassword2();
        signup.enterUsername(prop.getProperty("signup_emp_new_username"));
        signup.enterMailId(prop.getProperty("signup_emp_new_mailId"));
        signup.enterPassword1("");
        signup.enterPassword2("");
        signup.selectOrganization(prop.getProperty("signup_emp_organization"));
        signup.clickSignUp();
        try {
            Assert.assertEquals(driver.findElement(signup.errorMessage).getAttribute("textContent"),PasswordErrorMessage);
        }
        catch (Exception e)
        {
            System.out.println("InvalidateSignupByPassword unsuccessful");
        }
    }
}
