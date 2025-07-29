package StepDefinitions;

import Pages.EmployeeSearchPage;
import Utils.CommonMethods;
import Utils.ConfigReader;
import io.cucumber.java.en.When;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;

public class EmployeeSearch extends CommonMethods {

    @When("user enters valid Employee ID in the textbox")
    public void user_enters_valid_employee_id_in_the_textbox() {
        employeeSearch.empid.sendKeys(ConfigReader.getPropertyValue("empid"));
    }

    @When("click on Search button")
    public void click_on_search_button() {
        employeeSearch.searchBtn.click();
    }

    @When("user see employee information displayed")
    public void user_see_employee_information_displayed() {
        System.out.println("Employee is displayed");
    }

    @When("user select Employment status dropdown")
    public void user_select_employment_status_dropdown() {

      /*  WebDriverWait wait=new WebDriverWait(driver, Duration.ofSeconds(10)) {*/
           // WebElement employmentStatus=driver.findElement(By.cssSelector("div.oxd-select-text-input"));
            selectCustomDropdown(employeeSearch.employmentStatus,"Full-time Permanent");

    }

}
