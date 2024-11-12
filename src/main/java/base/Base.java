package base;

import io.github.bonigarcia.wdm.WebDriverManager;

import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import org.openqa.selenium.support.ui.WebDriverWait;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;


public class Base {
    public static WebDriver driver;
    public static JavascriptExecutor javascriptExecutor;
    public static WebDriverWait wait;
    @Parameters({"browser", "url"})
    @BeforeMethod(alwaysRun = true)
    public void setUp(@Optional("chrome") String browser, @Optional("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login") String url) {
        if (browser.equals("chrome")) {
            WebDriverManager.chromedriver().setup();
            driver = new ChromeDriver();
        } else if (browser.equals("firefox")) {
            WebDriverManager.firefoxdriver().setup();
            driver = new FirefoxDriver();

        }
        driver.get(url);
        driver.manage().window().maximize();
        wait = new WebDriverWait(driver,30);

    }
//        @AfterMethod(alwaysRun = true)
//    public void cleanUp(ITestResult testResult) throws IOException {
//        if (ITestResult.FAILURE==testResult.getStatus()){
//            takeScreenShot(testResult.getName());
//        }
//        driver.close();
//        driver.quit();
//    }
//    //selenium api or common Api
    public void clickOnElement(WebElement element){
        element.click();
    }
    public void enterText(WebElement element, String text) {
        element.sendKeys(text);
    }
//    public String getInnerTextFromElement(WebElement element){
//        return element.getText().trim();//trim() to delete spaces at the beginning and the end
//    }
////    public void hoverOverOnElement(WebElement element){
//        Actions actions= new Actions(driver);
//        actions.moveToElement(element);
//    }
//    public void selectFromDropDownByVisibleText(WebElement element, String text){
//        Select select= new Select(element);
//        select.selectByVisibleText(text);
//    }
    // how to take screenshot
    // convert driver to takeScreenshot interface
    // call the method getScreenshot
//    public void takeScreenShot(String testName) throws IOException {
//        TakesScreenshot takesScreenshot= (TakesScreenshot) driver; // down casting from the driver to TakesScreenshot
////        // where we have to save the picture
//        File source=takesScreenshot.getScreenshotAs(OutputType.FILE);
////        //C:\Users\aksil amina\Desktop\final selenium\learn-selenium\Screen_shot\First_Screen_Shot.png
////        //C:\Users\aksil amina\Desktop\final selenium\orange_framwork\orange_version1
//        String path = System.getProperty("user.dir") + File.separator + "screen_shot1" + File.separator + testName+".png";
//        FileUtils.copyFile(source,new File(path));
//        try {
//            FileUtils.copyFile(source,new File(path));
//        }catch (IOException exception){
//            System.out.println(exception.getMessage());
//        }

  //  }
}


