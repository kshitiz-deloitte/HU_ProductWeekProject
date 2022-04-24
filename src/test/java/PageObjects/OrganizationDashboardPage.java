package PageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import java.util.List;

public class OrganizationDashboardPage {

    WebDriver driver;

    static By searchInput = By.xpath("//input[@placeholder='Search by Username']");
    static By searchButton = By.xpath("//button[text()='Search']");
    static By paginationButton = By.xpath("//*[@id='root']/div/div[2]/div[2]/div/div/table/tfoot/div/div/div[2]");
    static By pagination5 = By.xpath("//*[@id='menu-']/div[3]/ul/li[1]");
    static By pagination10 = By.xpath("//*[@id='menu-']/div[3]/ul/li[2]");
    static By pagination15 = By.xpath("//*[@id='menu-']/div[3]/ul/li[3]");
    static By numberOfUsers = By.xpath("//*[@id='root']/div/div[2]/div[2]/div/div/table/tbody/tr");

    public void setSearchInput(String input){
        driver.findElement(searchInput).sendKeys(input);
    }
    public void clickSearch(){
        driver.findElement(searchButton).click();
    }
    public void setPagination(int option){
        driver.findElement(paginationButton).click();
        if(option==5){
            driver.findElement(pagination5).click();
        }
        else if(option==10){
            driver.findElement(pagination10).click();
        }
        else if(option==15){
            driver.findElement(pagination15).click();
        }
    }
    public int numberOfUsersPerPage(){
        List<WebElement> users = driver.findElements(numberOfUsers);
        return users.size();
    }
    public OrganizationDashboardPage(WebDriver driver){
        this.driver=driver;
    }

    public void clearSearchInput() {
        driver.findElement(searchInput).clear();
    }

}
