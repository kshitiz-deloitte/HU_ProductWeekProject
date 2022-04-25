package PageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class EmployeeDashboardPage {

    WebDriver driver;


    static By aadhar1 = By.xpath("//*[@id=\"Aadhaar\"]");
    static By pan1 = By.xpath("//*[@id=\"Pan\"]");
    static By marksheet1 = By.xpath("//*[@id=\"Marksheet\"]");
    static By emplogo= By.xpath("//*[@id=\"root\"]/div/div[1]/div[1]/a/img");
    static By uploadbtn1 = By.xpath("//*[@id=\"root\"]/div/div[2]/div[3]/div[1]/div/div[2]/button");
    static By uploadbtn2 = By.xpath("//*[@id=\"root\"]/div/div[2]/div[3]/div[2]/div/div[2]/button");
    static By uploadbtn3 = By.xpath("//*[@id=\"root\"]/div/div[2]/div[3]/div[3]/div/div[2]/button");

    public EmployeeDashboardPage(WebDriver driver) {
        this.driver=driver;
    }

    public void uploadAadhar() {
        WebElement chooseFile = driver.findElement(aadhar1);
        chooseFile.sendKeys("C:\\Users\\mvsuhas\\Downloads\\Aadhaar-Image.jpg");
        driver.findElement(uploadbtn1).click();

    }

    public void uploadPan(){
        WebElement chooseFile = driver.findElement(pan1);
        chooseFile.sendKeys("C:\\Users\\mvsuhas\\Downloads\\Pan.jpg");
        driver.findElement(uploadbtn2).click();
    }

    public void uploadMarksheet(){
        WebElement chooseFile = driver.findElement(marksheet1);
        chooseFile.sendKeys("C:\\Users\\mvsuhas\\Downloads\\Marksheet.jpg");
        driver.findElement(uploadbtn3).click();
    }

    public void errorMsg() throws InterruptedException {
        WebElement chooseFile = driver.findElement(aadhar1);
        chooseFile.sendKeys("C:\\Users\\mvsuhas\\Downloads\\01_Cypress_Intro_Setup.mp4");
        driver.findElement(uploadbtn1).click();

        Thread.sleep(2000);

        chooseFile = driver.findElement(pan1);
        chooseFile.sendKeys("C:\\Users\\mvsuhas\\Downloads\\01_Cypress_Intro_Setup.mp4");
        driver.findElement(uploadbtn2).click();

        Thread.sleep(4000);

        chooseFile = driver.findElement(marksheet1);
        chooseFile.sendKeys("C:\\Users\\mvsuhas\\Downloads\\01_Cypress_Intro_Setup.mp4");
        driver.findElement(uploadbtn3).click();

        new WebDriverWait(driver, 40).until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.xpath("//p[@class='red']")));
        WebElement errorMsg = driver.findElement(By.xpath("//p[@class='red']"));
        System.out.println(errorMsg.getText());

    }

    //Verifying Logo
    public void verifyLogo(){
        WebElement img = driver.findElement(emplogo);
        Boolean ImagePresent = (Boolean) ((JavascriptExecutor)driver) .executeScript("return arguments[0].complete && typeof arguments[0].naturalWidth != \"undefined\" && arguments[0].naturalWidth > 0", img);

        if (!ImagePresent) {
            System.out.println("Logo not present");
        } else {
            System.out.println("Logo present");
        }
    }


}
