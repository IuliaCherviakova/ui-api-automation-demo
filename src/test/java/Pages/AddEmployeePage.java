package Pages;

import Utils.CommonMethods;
import Utils.ConfigReader;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import Pages.AddEmployeePage;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class AddEmployeePage extends CommonMethods {
    public AddEmployeePage() {
        PageFactory.initElements(driver, this);
    }
    @FindBy(css = "button.oxd-main-menu-button")
    public WebElement toggleButton;

    @FindBy(xpath ="//span[text()='PIM']")
    public WebElement pimMenu;

    @FindBy(xpath ="//div[@class='orangehrm-header-container']//button[normalize-space()='Add']")
    public WebElement addButton;

    @FindBy(name = "firstName")
    public WebElement firstname;

    @FindBy(name ="middleName" )
            public WebElement middleName;

    @FindBy(name ="lastName")
        public WebElement lastName;

    @FindBy(xpath ="//button[@type='submit']")
     public WebElement submitBtn;
}


