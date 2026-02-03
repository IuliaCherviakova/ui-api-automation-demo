package Utils;

import StepDefinitions.PageInitializer;
import io.cucumber.core.backend.StepDefinition;
import org.apache.commons.io.FileUtils;
import org.apache.log4j.xml.DOMConfigurator;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.Date;
import java.util.List;

public class CommonMethods extends PageInitializer {

    public static WebDriver driver;

    public static void  openBrowserAndLaunchApplication(){
        ConfigReader.readProperties();

      String browserType=ConfigReader.getPropertyValue("browserType");

       switch(browserType){
         case "Chrome":
             driver=new ChromeDriver();
             break;

         case "Firefox":
             driver=new FirefoxDriver();
             break;

         case "IE":
               driver=new InternetExplorerDriver();
           break;
         default:
            driver=new EdgeDriver();
                break;
       }

        driver.manage().window().maximize();
        driver.get(ConfigReader.getPropertyValue("url"));
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(Constants.WAIT_TIME));
        initializePageObjects();

        //to configure the File and pattern of it
        DOMConfigurator.configure("log4j.xml");
        Log.startTestCase("This is the begining of my test case");
        Log.info("My test case is executing");
        Log.warning("My test case might have some issues");
    }

    public static void closeBrowser(){

        Log.info("This test case is about to be completed");
        Log.endTestCase("This test case is finished");
        driver.close();
    }
    public static void sendText(WebElement element,String text){
        element.clear();
        element.sendKeys(text);
    }

    public static void doClick(WebElement element){
        element.click();
    }
    public static Select clickOnDropdown(WebElement element){
        Select select=new Select(element);
        return select;
    }

    public static void selectByValue(WebElement element, String value){
        clickOnDropdown(element).selectByValue(value);
    }

    public static void selectByVisibleText(WebElement element,String text){
        clickOnDropdown(element).selectByVisibleText(text);
    }

    public static void selectByIndex(WebElement element, int index){
        clickOnDropdown(element).selectByIndex(index);
    }

    public static void selectByOption(WebElement element, String text){
       List<WebElement> options=clickOnDropdown(element).getOptions();
       for(WebElement option:options){
           String ddlOptionText=option.getText();
           if(ddlOptionText.equalsIgnoreCase(text)){
               option.click();
           }
       }
    }

    public static void selectCustomDropdown(WebElement dropdownElement, String optionText) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

        // Step 1: Click the dropdown
        dropdownElement.click();

        // Step 2: Wait for options to appear
        List<WebElement> options = wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.xpath("//div[@role='option']//span")));

        // Step 3: Loop and click matching option
        for (WebElement option : options) {
            if (option.getText().equalsIgnoreCase(optionText)) {
                option.click();
                break;
            }
        }
    }
    //===========================SCREENSHOT======================================
    public static byte[] takeScreenshot(String imageName) {
        TakesScreenshot ts=(TakesScreenshot) driver;
        byte[] picBytes=ts.getScreenshotAs(OutputType.BYTES);//takes a screenshot and stores it as byte array
        File sourcePath=ts.getScreenshotAs(OutputType.FILE);//captures the screenshoty and stores it as a file in sourceFile variable
        try {
            FileUtils.copyFile(sourcePath,new File(Constants.SCREENSHOT_FILEPATH + imageName + getTimeStamp("yyyy-MM-dd-HH-mm-ss") + ".png"));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return picBytes;
    }
    public static  String getTimeStamp(String pattern){
        Date date=new Date();
        SimpleDateFormat sdf=new SimpleDateFormat(pattern);
        return sdf.format(date);
    }
}
//    new File(Constants.SCREENSHOT_FILEPATH + imageName + getTimeStamp("yyyy-MM-dd-HH-mm-ss") + ".png")
