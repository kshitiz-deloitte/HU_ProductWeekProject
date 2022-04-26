package PageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;


public class AdminDashboardPage {
    WebDriver driver;

    //Arrow.Verify and filter button xpaths
    public static By arrowButton = By.xpath("//select[@id=\"filter\"]");
    static By fileterButton = By.xpath("//button[@class=\"btn btn-primary button-six button-color-blue\"]");

    //Searching company Name and Search button xpaths
    static By searchcompanyName = By.xpath("//input[@class=\"form-control\"]");
    static By searchButton = By.xpath("//button[@class=\"btn btn-primary button-color-blue\"]");

    //Downloading buttons xpaths
    static By adharDownloadButton = By.xpath("//*/div/div[2]/div/div[2]/div[1]/ol/li[1]/a");
    static By pandownloadButton = By.xpath("//*/div/div[2]/div/div[2]/div[1]/ol/li[2]/a");
    static By highestEducationDegreeDownloadButton = By.xpath("//*/div/div[2]/div/div[2]/div[1]/ol/li[3]/a");

    //Reject,Accept and instruction xpaths
    static By rejectButton = By.xpath("//button[@class=\"button-reject\"]");
    static By acceptButton = By.xpath("//button[@class=\"button-accept\"]");

    //Instruction xpaths
    static By instruction_personalInformation = By.xpath("m(//input[@id=\"personalInformation\"])[1]");
    static By instruction_educationalInformation = By.xpath("(//input[@id=\"personalInformation\"])[2]");
    static By instruction_contactInformation = By.xpath("/(//input[@id=\"personalInformation\"])[3]");
    static By instruction_bankDetails = By.xpath("(//input[@id=\"personalInformation\"])[4]");
    static By instruction_employementHistory = By.xpath("(//input[@id=\"personalInformation\"])[5]");

    //Input Message xpaths
    static By messageInput = By.xpath("//input[@id=\"outlined-basic\"]");

    //recently added
    static By filt = By.xpath("//*[@id=\"filter\"]");
    static By compname = By.xpath("//*[@id=\"filter\"]/option[4]");
    static By companyName = By.xpath("//*[@id=\"root\"]/div/div[2]/div[2]/div/div/table/tbody/tr[1]/td[3]");
    static By verifybtn = By.xpath("//button[@class=\"button-four\"]");
    static By lstno1 = By.xpath("//*[@id=\"root\"]/div/div[2]/div[2]/div/div/table/tfoot/div/div/p[2]");
    static By kyc = By.xpath("//*[@id=\\\"root\\\"]/div/div[2]/div[2]/div/div/table/tbody/tr[\" + Integer.toString(row) + \"]/td[4]/p");
    static By verify;
    static By fields = By.xpath("//*[@id=\"root\"]/div/div[2]/div/div[1]/div[1]/div/div[2]/div/div/div/div[3]/p[2]");
    static By rowpgarr = By.xpath("//button[@title=\"Next page\"]");
    static By lstno2 = By.xpath("//*[@id=\"root\"]/div/div[2]/div[2]/div/div/table/tfoot/div/div/p[2]");
    static By searchCompName;
    static By rowsperpage = By.xpath("//*[@id=\"root\"]/div/div[2]/div[2]/div/div/table/tfoot/div/div/p[2]");
    //static By beforekycstatus = By.xpath("//*[@id=\"root\"]/div/div[2]/div[2]/div/div/table/tbody/tr[" + Integer.toString() + "]/td[4]/p");

    //Getting the roes per page as a string
    public String listNumber()
    {
        return driver.findElement(rowsperpage).getText();
    }

    //Before taking the action for reject/Accept the request it will return the kys status of the employee
    public String beforeAcionKYC(int row){
        return driver.findElement(By.xpath("//*[@id=\"root\"]/div/div[2]/div[2]/div/div/table/tbody/tr[" + Integer.toString(row) + "]/td[4]/p")).getText();
    }

    //After taking the action for reject/Accept the request it will return the kys status of the employee
    public String afterActionKYC(int row){
        return driver.findElement(By.xpath("//*[@id=\"root\"]/div/div[2]/div[2]/div/div/table/tbody/tr[" + Integer.toString(row) + "]/td[4]/p")).getText();
    }

    //Clicking on the filter button
    public int filter(){
        new WebDriverWait(driver, Duration.ofSeconds(10)).until(ExpectedConditions.visibilityOfElementLocated(filt));
        List<WebElement> arrow = driver.findElements(filt);
        System.out.println(arrow.size());
        return arrow.size();
    }

    //Getting the string value of company name
    public void comp(){
        driver.findElement(compname).click();
    }

    // Getting the Searched Company name
    public String search(){
        return driver.findElement(companyName).getText();
    }

    // Clicking on verify button
    public void verifyBtnWorking(){ driver.findElement(verifybtn).click(); }

    // Getting the number of pages
    public void listNumber1() {
        String listno = driver.findElement(lstno1).getText();
    }

    //Getting the kys status
    public String kycstat(){
        return driver.findElement(kyc).getText();
    }

    //Clicking on verify button when the kyc status is pending
    public void verifyy(int row){
        verify = By.id("//*[@id=\"root\"]/div/div[2]/div[2]/div/div/table/tbody/tr["+row+"]/td[5]/button");
        verify.findElement(driver).click();
    }

    //Employee details string value
    public String field(){ return driver.findElement(fields).getText(); }
    public void rowperPageArrow(){ driver.findElement(rowpgarr).click(); }

    // Getting the number of pages after reject/accepting the kys status
    public String listNumber2(){ return driver.findElement(lstno2).getText();
    }

    //Webdriver opening
    public AdminDashboardPage(WebDriver driver){
        this.driver = driver;
    }

    // Clicking on Reject button
    public void clickRejectButton(){
        driver.findElement(rejectButton).click();
    }

    // Clicking on Accept button
    public void clickAcceptButton(){
        driver.findElement(acceptButton).click();
    }

    //Clicking on Message and writing
    public void clickMessageInput(){
        driver.findElement(messageInput).click();
    }

    //clicking on Arrow Mark
    public void clickArrowMark(){
        driver.findElement(arrowButton).click();
    }

    //Clicking on filter option
    public void clickFilterButton(){
        driver.findElement(fileterButton).click();
    }

    //Clicking on Search button with company name
    public void clickSearchCompany(String property){
        driver.findElement(searchcompanyName).click();
    }
    //Clicking on search button
    public void clickSearchButton(){
        driver.findElement(searchButton).click();
    }
    //clicking on Download button of aadhar card
    public void clickAadarDownloadButton(){
        driver.findElement(adharDownloadButton).click();
    }

    //Clicking on pan card
    public void clickPanDownloadButton(){
        driver.findElement(pandownloadButton).click();
    }

    //Clicking on Instructions
    public void clickHighestEducationDegreeDownloadButton(){driver.findElement(highestEducationDegreeDownloadButton).click();}
    public void clickInstructionPersonalInfo(){driver.findElement(instruction_personalInformation).click();}
    public void clickInstructionContactInfo(){driver.findElement(instruction_contactInformation).click();}
    public void clickInstructionEducationalInfo(){driver.findElement(instruction_educationalInformation).click();}
    public void clickInstructionBankDetails(){driver.findElement(instruction_bankDetails).click();}
    public void clickInstructionEmployementHistory(){driver.findElement(instruction_employementHistory).click();}
}
