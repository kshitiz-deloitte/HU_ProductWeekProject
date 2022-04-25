package PageObjects;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import java.io.File;
import java.io.IOException;

public class AdminDashboardPage {
    WebDriver driver;

    //Arrow.Verify and filter button xpaths
    public static By arrowButton = By.xpath("//*[@id=\"filter\"]");
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
    static By kycStatus;
    static By listNumber;

    //Input Message xpaths
    static By messageInput = By.xpath("//input[@id=\"outlined-basic\"]");

    //For logout Button
    static By logoutButton = By.xpath("//button[@class=\"btn login\"]");

    public AdminDashboardPage(WebDriver driver){
        this.driver = driver;
    }

    public String getKYCStatus(int row){
        kycStatus = By.xpath("//*[@id='root']/div/div[2]/div[2]/div/div/table/tbody/tr["+row+"]/td[4]/p");
        return driver.findElement(kycStatus).getText();
    }
    public String getListNumber(){
        listNumber =  By.xpath("//*[@id=\"root\"]/div/div[2]/div[2]/div/div/table/tfoot/div/div/p[2]");
         return driver.findElement(listNumber).getText();
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
    public void clickInstructionEmployementHistory(){driver.findElement(instruction_employementHistory).click();}
    public void clickLogoutButton(){driver.findElement(logoutButton).click();}
}
