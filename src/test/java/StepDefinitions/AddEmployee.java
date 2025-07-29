package StepDefinitions;

import Pages.AddEmployeePage;
import Utils.CommonMethods;
import Utils.ConfigReader;
import io.cucumber.core.options.Constants;
import io.cucumber.java.en.When;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class AddEmployee extends CommonMethods {

    AddEmployeePage addEmployee=new AddEmployeePage();

    @When("user click on PIM option")
    public void user_click_on_pim_option() throws InterruptedException {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        if (driver.findElements(By.xpath("//span[text()='PIM']")).isEmpty()) {
            wait.until(ExpectedConditions.elementToBeClickable(addEmployee.toggleButton)).click();
            Thread.sleep(500);
        }
         wait.until(ExpectedConditions.elementToBeClickable(addEmployee.pimMenu)).click();
    }

    @When("user clicks on add employee butten")
    public void user_clicks_on_add_employee_butten() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
       wait.until(ExpectedConditions.elementToBeClickable(addEmployee.addButton));
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", addEmployee.addButton);
        addEmployee.addButton.click();
    }

    @When("user enters first name and middlename and lastname")
    public void user_enters_first_name_and_middlename_and_lastname() {
       addEmployee.firstname.sendKeys(ConfigReader.getPropertyValue("firstname"));
       addEmployee.middleName.sendKeys(ConfigReader.getPropertyValue("middlename"));
      addEmployee.lastName.sendKeys(ConfigReader.getPropertyValue("lastname"));
    }

    @When("user clicks on save button")
    public void user_clicks_on_save_button() {
          addEmployee.submitBtn.click();
    }

}
