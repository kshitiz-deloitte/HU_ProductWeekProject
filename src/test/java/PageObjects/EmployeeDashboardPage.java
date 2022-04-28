package PageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.ArrayList;
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
    static By err = By.xpath("//p[@class='red']");

    static By dropdown1 = By.xpath("//*[@id=\"root\"]/div/div[2]/div[2]/div[1]/div/div[1]/div[2]");
    static By dropdown2 = By.xpath("//*[@id=\"root\"]/div/div[2]/div[2]/div[2]/div/div[1]/div[2]");
    static By dropdown3 = By.xpath("//*[@id=\"root\"]/div/div[2]/div[2]/div[3]/div/div[1]/div[2]");
    static By dropdown4 = By.xpath("//*[@id=\"root\"]/div/div[2]/div[2]/div[4]/div/div[1]/div[2]");
    static By dropdown5 = By.xpath("//*[@id=\"root\"]/div/div[2]/div[2]/div[5]/div/div[1]/div[2]");
    static By personalInfoPath = By.xpath("//*[@id=\"root\"]/div/div[2]/div[2]/div[1]/div/div[2]/div/div/div/div/p[2]");
    static By educationInfoPath = By.xpath("//*[@id=\"root\"]/div/div[2]/div[2]/div[2]/div/div[2]/div/div/div/div//child::p[2]");
    static By contactInfoPath = By.xpath("//*[@id=\"root\"]/div/div[2]/div[2]/div[3]/div/div[2]/div/div/div/div/p[2]");
    static By bankDetailsPath = By.xpath("//*[@id=\"root\"]/div/div[2]/div[2]/div[4]/div/div[2]/div/div/div/div/p[2]");
    static By employmentHistoryPath = By.xpath("//*[@id=\"root\"]/div/div[2]/div[2]/div[5]/div/div[2]/div/div/div/div/p[2]");


    List<WebElement> empDetailsElementsList;
    ArrayList<String> empDetailsList;

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
        new WebDriverWait(driver, Duration.ofSeconds(40)).until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.xpath("//p[@class='red']")));
        WebElement errorMsg = driver.findElement(err);
        System.out.println(errorMsg.getText());
        Thread.sleep(2000);

        //PanUpload
        chooseFile = driver.findElement(pan);
        chooseFile.sendKeys(path);
        driver.findElement(uploadbtn2).click();
        new WebDriverWait(driver, Duration.ofSeconds(40)).until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.xpath("//p[@class='red']")));
        errorMsg = driver.findElement(err);
        System.out.println(errorMsg.getText());
        Thread.sleep(2000);

        //MarksheetUpload
        chooseFile = driver.findElement(marksheet);
        chooseFile.sendKeys(path);
        driver.findElement(uploadbtn3).click();
        new WebDriverWait(driver, Duration.ofSeconds(40)).until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.xpath("//p[@class='red']")));
        errorMsg = driver.findElement(err);
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
    public void verifyQuicklinksH() {
        WebElement element = driver.findElement(home);
        JavascriptExecutor executor = (JavascriptExecutor)driver;
        executor.executeScript("arguments[0].click();", element);
    }
    // Add Employee Data in a ArrayList
    public void addEmployeeDataIntoArrayList(By path) throws InterruptedException {
        Thread.sleep(4000);
        empDetailsElementsList = driver.findElements(path);
        for(WebElement element: empDetailsElementsList){
            String detail = element.getText().trim();
            if (!(detail.equals("") && empDetailsList.contains(detail)))
                empDetailsList.add(detail);
        }
    }

    public ArrayList<String> getEmployeeDetails() throws InterruptedException {
        new WebDriverWait(driver, Duration.ofSeconds(10)).until(ExpectedConditions.visibilityOfElementLocated(dropdown2));
        empDetailsList = new ArrayList<>();
        addEmployeeDataIntoArrayList(personalInfoPath);
        driver.findElement(dropdown2).click();
        addEmployeeDataIntoArrayList(educationInfoPath);
        driver.findElement(dropdown3).click();
        addEmployeeDataIntoArrayList(contactInfoPath);
        driver.findElement(dropdown4).click();
        addEmployeeDataIntoArrayList(bankDetailsPath);
        driver.findElement(dropdown5).click();
        addEmployeeDataIntoArrayList(employmentHistoryPath);
        System.out.println(empDetailsList);
        driver.findElement(dropdown1).click();
        return empDetailsList;
    }
}
