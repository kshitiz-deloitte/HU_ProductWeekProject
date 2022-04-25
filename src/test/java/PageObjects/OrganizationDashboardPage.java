package PageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import java.util.List;

//contains page objects of organization dashboard Page
public class OrganizationDashboardPage {

    WebDriver driver;
    //declaring xpaths of different elements of page
    static By searchInput = By.xpath("//input[@placeholder='Search by Username']");
    static By searchButton = By.xpath("//button[text()='Search']");
    static By paginationButton = By.xpath("//*[@id='root']/div/div[2]/div[2]/div/div/table/tfoot/div/div/div[2]");
    static By pagination5 = By.xpath("//*[@id='menu-']/div[3]/ul/li[1]");
    static By pagination10 = By.xpath("//*[@id='menu-']/div[3]/ul/li[2]");
    static By pagination15 = By.xpath("//*[@id='menu-']/div[3]/ul/li[3]");
    static By numberOfUsers = By.xpath("//*[@id='root']/div/div[2]/div[2]/div/div/table/tbody/tr");

    // set search input element on Dashboard page
    public void setSearchInput(String input){
        driver.findElement(searchInput).sendKeys(input);
    }
    // click search button element on Dashboard page
    public void clickSearch(){
        driver.findElement(searchButton).click();
    }

    // set pagination as per the option
    public void setPagination(int option){
        driver.findElement(paginationButton).click();
        if(option==5){
            // pagination 5
            driver.findElement(pagination5).click();
        }
        else if(option==10){
            // pagination 10
            driver.findElement(pagination10).click();
        }
        else if(option==15){
            // pagination 15
            driver.findElement(pagination15).click();
        }
    }
    // return number of users available as per page
    public int numberOfUsersPerPage(){
        List<WebElement> users = driver.findElements(numberOfUsers);
        return users.size();
    }
    // constructor to initialize driver
    public OrganizationDashboardPage(WebDriver driver){
        this.driver=driver;
    }
    // clearing search input element on Dashboard page
    public void clearSearchInput() {
        driver.findElement(searchInput).clear();
    }

}
