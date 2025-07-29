package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import static Utils.CommonMethods.driver;

public class EmployeeSearchPage {

    public EmployeeSearchPage() {
        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath ="(//input[@class='oxd-input oxd-input--active'])[2]" )
    public WebElement empid;

    @FindBy(xpath ="//button[normalize-space()='Search']")
          public WebElement searchBtn;

    @FindBy(css="div.oxd-select-text-input")
    public WebElement employmentStatus;
}
