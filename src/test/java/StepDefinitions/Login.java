package StepDefinitions;

import Pages.LoginPage;
import Utils.CommonMethods;
import Utils.ConfigReader;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import io.cucumber.java.en.Then;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.sql.Driver;
import java.time.Duration;
import java.util.List;
import java.util.Map;
import java.util.concurrent.TimeUnit;

public class Login extends CommonMethods {

        @Given("open the browser and launch HRM application")
        public void open_the_browser_and_launch_hrm_application() {
            openBrowserAndLaunchApplication();
        }

        @When("user enters valid login and valid password")
        public void user_enters_valid_login_and_valid_password() {
            sendText(login.loginTxtBox, ConfigReader.getPropertyValue("username"));
            login.password.sendKeys(ConfigReader.getPropertyValue("password"));
        }

        @When("click on login button")
        public void click_on_login_button() {
           doClick(login.loginBtn);
        }

        @Then("user is logged in successfully")
        public void user_is_logged_in_sucessfully() {
            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
            wait.until(ExpectedConditions.visibilityOf(login.userAcct));
            Boolean userLoggedIn=login.userAcct.isDisplayed();
           if(userLoggedIn){
               System.out.println("User is logged in successfully");
           }
        }

    @When("user enters valid {string} and valid {string}")
    public void user_enters_valid_and_valid(String string, String string2) {
            sendText(login.loginTxtBox,string);
            sendText(login.password,string2);
    }

    @When("user enters username and password and verifies login")
    public void user_enters_username_and_password_and_verifies_login(DataTable dataTable) {
        List<Map<String, String>> userCredentials=dataTable.asMaps();
        for(Map<String,String> userCreds:userCredentials){
            String username=userCreds.get("login");
            String passwordValue=userCreds.get("password");

            sendText (login.loginTxtBox,username);
            sendText(login.password ,passwordValue);

            doClick(login.loginBtn);
            doClick(login.userDropDown);
            doClick(login.logOut);
            System.out.println("Set of data works successfully");
        }
    }

    @Then("Close the browser")
    public void close_the_browser() {

    }
}


