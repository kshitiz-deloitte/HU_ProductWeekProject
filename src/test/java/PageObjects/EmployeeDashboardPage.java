package PageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;


public class EmployeeDashboardPage {

    WebDriver driver;

    //Defining Locators
    static By aadhar = By.xpath("//*[@id=\"Aadhaar\"]");
    static By pan = By.xpath("//*[@id=\"Pan\"]");
    static By marksheet = By.xpath("//*[@id=\"Marksheet\"]");
    static By emplogo = By.xpath("//*[@id=\"root\"]/div/div[1]/div[1]/a/img");
    static By uploadbtn1 = By.xpath("//*[@id=\"root\"]/div/div[2]/div[3]/div[1]/div/div[2]/button");
    static By uploadbtn2 = By.xpath("//*[@id=\"root\"]/div/div[2]/div[3]/div[2]/div/div[2]/button");
    static By uploadbtn3 = By.xpath("//*[@id=\"root\"]/div/div[2]/div[3]/div[3]/div/div[2]/button");
    static By logout1 = By.xpath("//*[@id=\"root\"]/div/div[1]/div[3]/button");
    static By update = By.xpath("//*[@id=\"root\"]/div/div[2]/div[1]/button[1]");
    static By home = By.xpath("//*[@id=\"root\"]/div/div[2]/div[1]/button[2]");
    static By txt = By.xpath("//*[@id=\"root\"]/div/div[1]/div[2]/p");

    //Driver Inialtize using Parameterized Constructor
    public EmployeeDashboardPage(WebDriver driver) {
        this.driver=driver;
    }

    //Valid Aadhar Upload
    public void uploadAadhar(String path) {
        WebElement chooseFile = driver.findElement(aadhar);
        chooseFile.sendKeys(path);
        driver.findElement(uploadbtn1).click();

    }

    //Valid Pan Upload
    public void uploadPan(String path){
        WebElement chooseFile = driver.findElement(pan);
        chooseFile.sendKeys(path);
        driver.findElement(uploadbtn2).click();
    }

    //Valid Marksheet Upload
    public void uploadMarksheet(String path){
        WebElement chooseFile = driver.findElement(marksheet);
        chooseFile.sendKeys(path);
        driver.findElement(uploadbtn3).click();
    }

    //Adding Invalid Files more than 2mb
    public void errorMsg(String path) throws InterruptedException {
        //AadharUpload
        System.out.println(path);
        WebElement chooseFile = driver.findElement(aadhar);
        chooseFile.sendKeys(path);
        driver.findElement(uploadbtn1).click();
        new WebDriverWait(driver, 40).until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.xpath("//p[@class='red']")));
        WebElement errorMsg = driver.findElement(By.xpath("//p[@class='red']"));
        System.out.println(errorMsg.getText());
        Thread.sleep(2000);

        //PanUpload
        chooseFile = driver.findElement(pan);
        chooseFile.sendKeys(path);
        driver.findElement(uploadbtn2).click();
        new WebDriverWait(driver, 40).until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.xpath("//p[@class='red']")));
        errorMsg = driver.findElement(By.xpath("//p[@class='red']"));
        System.out.println(errorMsg.getText());
        Thread.sleep(2000);

        //MarksheetUpload
        chooseFile = driver.findElement(marksheet);
        chooseFile.sendKeys(path);
        driver.findElement(uploadbtn3).click();
        new WebDriverWait(driver, 40).until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.xpath("//p[@class='red']")));
        errorMsg = driver.findElement(By.xpath("//p[@class='red']"));
        System.out.println(errorMsg.getText());
        Thread.sleep(2000);

    }

    //Validating Logo and Text
    public void verifyLogoAndText(){
        Boolean result = driver.findElement(txt).isDisplayed();
        System.out.println(result);
        WebElement img = driver.findElement(emplogo);
        Boolean ImagePresent = (Boolean) ((JavascriptExecutor)driver) .executeScript("return arguments[0].complete && typeof arguments[0].naturalWidth != \"undefined\" && arguments[0].naturalWidth > 0", img);

        if (!ImagePresent) {
            System.out.println("Logo not present");
        } else {
            System.out.println("Logo present");
        }

    }

    //Logout
    public void logout(){
        driver.findElement(logout1).click();
    }

    //Quicklinks-Update
    public void verifyQuicklinksU() throws InterruptedException {
        WebElement element = driver.findElement(update);
        JavascriptExecutor executor = (JavascriptExecutor)driver;
        executor.executeScript("arguments[0].click();", element);
        Thread.sleep(2000);
        driver.navigate().back();
        Thread.sleep(2000);
    }

    //Quicklinks-Home
    public void verifyQuicklinksH() throws InterruptedException {
        WebElement element = driver.findElement(home);
        JavascriptExecutor executor = (JavascriptExecutor)driver;
        executor.executeScript("arguments[0].click();", element);
    }



}
