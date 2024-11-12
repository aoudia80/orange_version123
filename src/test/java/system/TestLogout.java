package system;

import base.Base;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.AccountPage;
import pages.HomePage;

public class TestLogout extends Base {


    @Test
    public void testValidLogout() {
        String expectedUrl = "https://opensource-demo.orangehrmlive.com/web/index.php/auth/login";
        HomePage homePage = new HomePage();
        wait.until(ExpectedConditions.presenceOfElementLocated(By.name("username")));
        homePage.doLogin("Admin", "admin123");
        AccountPage accountPage = new AccountPage();
        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//p[@class='oxd-userdropdown-name']")));
        accountPage.clickOnDropdown();
        homePage.selectLogOut();
//

//        homePage.enterUsername("Admin");
//        homePage.enterPassword("admin123");

//
//
//        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//p[@class='oxd-userdropdown-name']")));
//        accountPage.clickOnDropdown();
//        homePage.selectLogOut();
        String actualUrl = driver.getCurrentUrl();
//        //Assertion
        Assert.assertEquals(expectedUrl, actualUrl);
    }

}
