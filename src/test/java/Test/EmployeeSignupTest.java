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

    @Test
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
        Assert.assertEquals(driver.switchTo().alert().getText(),successMessage);
    }

    @Test
    public void InvalidateSignupByUsername() throws Exception
    {
        HomePage home = new HomePage(driver);
        home.clickLogin();

        Loginpage login = new Loginpage(driver);
        login.clickSignUp();

        EmployeeSignupPage signup = new EmployeeSignupPage(driver);
        signup.enterUsername(prop.getProperty("signup_emp_exist_username"));
        signup.enterMailId(prop.getProperty("signup_emp_exist_mailId"));
        signup.enterPassword1(prop.getProperty("signup_emp_password1"));
        signup.enterPassword2(prop.getProperty("signup_emp_password2"));
        signup.selectOrganization(prop.getProperty("signup_emp_organization"));
        signup.clickSignUp();
        Assert.assertEquals(driver.findElement(signup.errorMessage).getAttribute("textContent"),userErrorMessage);
    }

    @Test
    public void InvalidateSignupByPassword() throws Exception
    {
        HomePage home = new HomePage(driver);
        home.clickLogin();

        Loginpage login = new Loginpage(driver);
        login.clickSignUp();

        EmployeeSignupPage signup = new EmployeeSignupPage(driver);
        signup.enterUsername(prop.getProperty("signup_emp_new_username"));
        signup.enterMailId(prop.getProperty("signup_emp_new_mailId"));
        signup.enterPassword1("");
        signup.enterPassword2("");
        signup.selectOrganization(prop.getProperty("signup_emp_organization"));
        signup.clickSignUp();
        Assert.assertEquals(driver.findElement(signup.errorMessage).getAttribute("textContent"),PasswordErrorMessage);
    }
}
