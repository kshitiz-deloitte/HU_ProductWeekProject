package PageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;


public class EmployeeDashboardPage {

    WebDriver driver;


    static By aadhar = By.xpath("//*[@id=\"Aadhaar\"]");
    static By pan = By.xpath("//*[@id=\"Pan\"]");
    static By marksheet = By.xpath("//*[@id=\"Marksheet\"]");
    static By emplogo = By.xpath("//*[@id=\"root\"]/div/div[1]/div[1]/a/img");
    static By uploadbtn1 = By.xpath("//*[@id=\"root\"]/div/div[2]/div[3]/div[1]/div/div[2]/button");
    static By uploadbtn2 = By.xpath("//*[@id=\"root\"]/div/div[2]/div[3]/div[2]/div/div[2]/button");
    static By uploadbtn3 = By.xpath("//*[@id=\"root\"]/div/div[2]/div[3]/div[3]/div/div[2]/button");
    static By logout1 = By.xpath("//*[@id=\"root\"]/div/div[1]/div[3]/button");

    public EmployeeDashboardPage(WebDriver driver) {
        this.driver=driver;
    }

    public void uploadAadhar() {
        WebElement chooseFile = driver.findElement(aadhar);
        chooseFile.sendKeys("C:\\Users\\mvsuhas\\Downloads\\Aadhaar-Image.jpg");
        driver.findElement(uploadbtn1).click();

    }

    public void uploadPan(){
        WebElement chooseFile = driver.findElement(pan);
        chooseFile.sendKeys("C:\\Users\\mvsuhas\\Downloads\\Pan.jpg");
        driver.findElement(uploadbtn2).click();
    }

    public void uploadMarksheet(){
        WebElement chooseFile = driver.findElement(marksheet);
        chooseFile.sendKeys("C:\\Users\\mvsuhas\\Downloads\\Marksheet.jpg");
        driver.findElement(uploadbtn3).click();
    }

    public void errorMsg() throws InterruptedException {
        //Aadhar
        WebElement chooseFile = driver.findElement(aadhar);
        chooseFile.sendKeys("C:\\Users\\mvsuhas\\Downloads\\01_Cypress_Intro_Setup.mp4");
        driver.findElement(uploadbtn1).click();

        new WebDriverWait(driver, 40).until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.xpath("//p[@class='red']")));
        WebElement errorMsg = driver.findElement(By.xpath("//p[@class='red']"));
        System.out.println(errorMsg.getText());

        Thread.sleep(2000);

        chooseFile = driver.findElement(pan);
        chooseFile.sendKeys("C:\\Users\\mvsuhas\\Downloads\\01_Cypress_Intro_Setup.mp4");
        driver.findElement(uploadbtn2).click();

        new WebDriverWait(driver, 40).until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.xpath("//p[@class='red']")));
        errorMsg = driver.findElement(By.xpath("//p[@class='red']"));
        System.out.println(errorMsg.getText());

        chooseFile = driver.findElement(marksheet);
        chooseFile.sendKeys("C:\\Users\\mvsuhas\\Downloads\\01_Cypress_Intro_Setup.mp4");
        driver.findElement(uploadbtn3).click();

        new WebDriverWait(driver, 40).until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.xpath("//p[@class='red']")));
        errorMsg = driver.findElement(By.xpath("//p[@class='red']"));
        System.out.println(errorMsg.getText());

    }

    //Verifying Logo
    public void verifyLogoAndText(){
        Boolean result = driver.findElement(By.xpath("//*[@id=\"root\"]/div/div[1]/div[2]/p")).isDisplayed();
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

    //quicklinks
    public void verifyQuicklinksU() throws InterruptedException {
        WebElement element = driver.findElement(By.xpath("//*[@id=\"root\"]/div/div[2]/div[1]/button[1]"));
        JavascriptExecutor executor = (JavascriptExecutor)driver;
        executor.executeScript("arguments[0].click();", element);
        Thread.sleep(2000);
        driver.navigate().back();
        Thread.sleep(2000);
    }

    public void verifyQuicklinksH() throws InterruptedException {
        WebElement element = driver.findElement(By.xpath("//*[@id=\"root\"]/div/div[2]/div[1]/button[2]"));
        JavascriptExecutor executor = (JavascriptExecutor)driver;
        executor.executeScript("arguments[0].click();", element);
    }

}
