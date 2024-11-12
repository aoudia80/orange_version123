package system;

import base.Base;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.EmployeePage;
import pages.HomePage;

public class TestAddEmployee  extends Base {
    String RequiredMSG;
    @Test(priority = 0)
    public void addEmployee() throws InterruptedException {
        HomePage homePage = new HomePage();
        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//button[@type='submit']")));
        EmployeePage employerPage = new EmployeePage();
        wait.until(ExpectedConditions.presenceOfElementLocated(By.name("username")));
        homePage.doLogin("Admin", "admin123");
        String lastName = "test";
        String firstName = "peter";
        String employeeName = firstName + " " + lastName;
        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//span[text()='PIM']")));
        employerPage.setClickPIM();
        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//button[@class='oxd-button oxd-button--medium oxd-button--secondary']")));
        employerPage.setClickAdd();
        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//input[@name='firstName']")));
        employerPage.enterName(firstName);

        employerPage.enterMiddleName(lastName);
        // enter last name
        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//input[@name='lastName']")));
        employerPage.enterLastname("LastNameTest");

        employerPage.setClickSave();


        Assert.assertEquals(employeeName, "peter test");


    }

    @Test
    public void addEmployeeWithoutFirstName() {
        HomePage homePage = new HomePage();
        // String firstName = "peter";
        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//button[@type='submit']")));
        String lastName = "test";
        EmployeePage employerPage = new EmployeePage();
        wait.until(ExpectedConditions.presenceOfElementLocated(By.name("username")));
        homePage.doLogin("Admin", "admin123");

        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//span[text()='PIM']")));
        employerPage.setClickPIM();

        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//button[@class='oxd-button oxd-button--medium oxd-button--secondary']")));
        employerPage.setClickAdd();

        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//input[@name='firstName']")));
        //employerPage.enterName(firstName);
        employerPage.enterMiddleName(lastName);
        employerPage.enterLastname("LastNameTest");

        employerPage.setClickSave();
        //span[text()='Required']
        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(" //span[text()='Required']")));
        Assert.assertTrue(employerPage.isRequiredMSG());


    }

}

