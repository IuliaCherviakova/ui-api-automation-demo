package Pages;

import Utils.CommonMethods;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class LoginPage extends CommonMethods {
    //Page Factory Model

    public LoginPage() {
        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath = "//input[@name='username']")
    public WebElement loginTxtBox;

    @FindBy(xpath = "//input[@name='password']")
    public WebElement password;

    @FindBy(xpath ="//button[@class='oxd-button oxd-button--medium oxd-button--main orangehrm-login-button']" )
    public WebElement loginBtn;

    @FindBy(xpath = "//p[@class='oxd-userdropdown-name']")
    public WebElement userAcct;

    @FindBy(xpath ="//input[@name='username']" )
    public WebElement usernameTextBox;

    @FindBy(xpath ="//input[@name='password']" )
    public WebElement passwordTextBox;

    @FindBy(xpath = "//span[contains(@class,'oxd-userdropdown-tab')]")
    public WebElement userDropDown;

    @FindBy(xpath ="//a[contains(@href,'logout')]" )
    public WebElement logOut;

}
