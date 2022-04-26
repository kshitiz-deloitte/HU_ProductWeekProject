package PageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

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
    static By search = By.xpath("//*[@id=\\\"root\\\"]/div/div[2]/div[2]/div/div/table/tbody/tr[1]/td[3]");
    static By verifybtn = By.xpath("//button[@class=\"button-four\"]");
    static By lstno1 = By.xpath("//*[@id=\"root\"]/div/div[2]/div[2]/div/div/table/tfoot/div/div/p[2]");
    static By kyc = By.xpath("//*[@id=\\\"root\\\"]/div/div[2]/div[2]/div/div/table/tbody/tr[\" + Integer.toString(row) + \"]/td[4]/p");
    static By verify = By.xpath("//*[@id=\\\"root\\\"]/div/div[2]/div[2]/div/div/table/tbody/tr[\" + Integer.toString(row) + \"]/td[5]/button");
    static By fields = By.xpath("//*[@id=\"root\"]/div/div[2]/div/div[1]/div[1]/div/div[2]/div/div/div/div[3]/p[2]");
    static By rowpgarr = By.xpath("//button[@title=\"Next page\"]");
    static By lstno2 = By.xpath("//*[@id=\"root\"]/div/div[2]/div[2]/div/div/table/tfoot/div/div/p[2]");
    //static By beforekycstatus = By.xpath("//*[@id=\"root\"]/div/div[2]/div[2]/div/div/table/tbody/tr[" + Integer.toString() + "]/td[4]/p");



    public AdminDashboardPage(WebDriver driver){
        this.driver = driver;
    }

    public void clickRejectButton(){
        driver.findElement(rejectButton).click();
    }
    public void clickAcceptButton(){
        driver.findElement(acceptButton).click();
    }
    public void clickMessageInput(){
        driver.findElement(messageInput).click();
    }

    public void clickArrowMark(){
        driver.findElement(arrowButton).click();
    }
    public void clickFilterButton(){
        driver.findElement(fileterButton).click();
    }
    public void clickSearchCompany(String property){
        driver.findElement(searchcompanyName).click();
    }
    public void clickSearchButton(){
        driver.findElement(searchButton).click();
    }
    public void clickAadarDownloadButton(){
        driver.findElement(adharDownloadButton).click();
    }
    public void clickPanDownloadButton(){
        driver.findElement(pandownloadButton).click();
    }
    public void clickHighestEducationDegreeDownloadButton(){
        driver.findElement(highestEducationDegreeDownloadButton).click();
    }
    public void clickInstructionPersonalInfo(){
        driver.findElement(instruction_personalInformation).click();
    }
    public void clickInstructionContactInfo(){
        driver.findElement(instruction_contactInformation).click();
    }
    public void clickInstructionEducationalInfo(){
        driver.findElement(instruction_educationalInformation).click();
    }
    public void clickInstructionBankDetails(){
        driver.findElement(instruction_bankDetails).click();
    }
    public void clickInstructionEmployementHistory(){
        driver.findElement(instruction_employementHistory).click();
    }

    //recently added functions
    public void filter(){ driver.findElement(filt).click(); }

    public void comp(){ driver.findElement(compname).click(); }

    public void search(){ driver.findElement(search).getText(); }

    public void verifyBtnWorking(){ driver.findElement(verifybtn).click(); }

    public void listNumber1(){ String listno = driver.findElement(lstno1).getText(); }

    public void kycstat(){ driver.findElement(kyc).getText(); }

    public void verify(){ driver.findElement(verify).click(); }

    public void field(){ driver.findElement(fields).getText(); }

    public void rowperPageArrow(){ driver.findElement(rowpgarr).click(); }

    public void  listNumber2(){ driver.findElement(lstno2).getText(); }

}
