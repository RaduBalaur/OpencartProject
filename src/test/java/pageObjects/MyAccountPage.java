package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class MyAccountPage extends BasePage {

    public MyAccountPage(WebDriver driver)
    {
        super(driver);
    }

    @FindBy(xpath="//h2[normalize-space()='My Account']")
    WebElement msgMyAccount;
    @FindBy(xpath="//a[@class='list-group-item'][normalize-space()='Logout']")
    WebElement btn_logout;
    @FindBy(xpath="//input[@placeholder='Search']")
    WebElement search_input;
    @FindBy(xpath="//button[@class='btn btn-default btn-lg']")
    WebElement search_btn;


    public boolean DoesMyAccountExist()
    {
        try
        {
            return(msgMyAccount.isDisplayed());
        }
        catch(Exception e)
        {
            return false;
        }
    }
    public void ClickLogout()
    {
        btn_logout.click();
    }
    public void SearchForProduct(String product)
    {
        search_input.sendKeys(product);
    }
    public void ClickOnSearch()
    {
        search_btn.click();
    }
}
