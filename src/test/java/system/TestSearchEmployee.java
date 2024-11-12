package system;

import base.Base;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;
import pages.EmployeePage;
import pages.HomePage;

public class TestSearchEmployee extends Base {
    @Test
    public void validSearchEmployee() throws InterruptedException {
        HomePage homePage = new HomePage();
        EmployeePage employeePage = new EmployeePage();
        wait.until(ExpectedConditions.presenceOfElementLocated(By.name("username")));
        homePage.doLogin("Admin", "admin123");
//      homePage.clickOnLogin();
        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//span[text()='PIM']")));
        employeePage.setClickPIM();
        //label[text()='Employee Name']
        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//label[text()='Employee Name']")));
        employeePage.employeeName("Amelia Brown");

//        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//button[@type='submit']")));
//        homePage.clickSearchButton();
    }
}
