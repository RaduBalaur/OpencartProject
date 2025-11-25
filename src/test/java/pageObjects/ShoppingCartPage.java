package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class ShoppingCartPage extends BasePage{

    public ShoppingCartPage(WebDriver driver)
    {
        super(driver);
    }

    @FindBy(xpath="(//img[@title='iMac'])[2]")
    WebElement ProductInCart;

    public boolean IsMyProductInCart()
    {
        try
        {
            return(ProductInCart.isDisplayed());
        }
        catch (Exception e)
        {
            return false;
        }
    }
}
