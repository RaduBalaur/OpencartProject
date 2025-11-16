package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class HomePage extends BasePage{


    public HomePage(WebDriver driver)
    {
        super(driver);
    }
    @FindBy(xpath="//span[normalize-space()='My Account']")
    WebElement clickMyAccount;

    @FindBy(xpath="//a[normalize-space()='Register']")
    WebElement linkRegister;
    @FindBy(linkText = "Login")
    WebElement login;

    public void clickAccount()
    {
        clickMyAccount.click();
    }
    public void clickRegister()
    {
        linkRegister.click();
    }
    public void ClickLogin()
    {
        login.click();
    }
}
