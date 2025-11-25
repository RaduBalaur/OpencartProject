package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class ProductDisplayPage extends BasePage {

    public ProductDisplayPage(WebDriver driver)
    {
        super(driver);
    }

    @FindBy(xpath="//button[@id='button-cart']")
    WebElement AddToCart_btn;
    @FindBy(xpath="//div[@class='alert alert-success alert-dismissible']")
    WebElement success_msg;
    @FindBy(xpath="//a[normalize-space()='shopping cart']")
    WebElement ShoppingCart_link;

    public void ClickAddToCart()
    {
        AddToCart_btn.click();
    }

    public boolean DoesSuccessMessageExist()
    {
        try
        {
            return(success_msg.isDisplayed());
        }
        catch (Exception e)
        {
            return false;
        }
    }

    public void ClickOnShoppingCart()
    {
        ShoppingCart_link.click();
    }
}
