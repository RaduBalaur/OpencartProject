package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class ProductsPage extends BasePage {

    public ProductsPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(className="img-responsive")
    WebElement selected_product;
    @FindBy(linkText = "iMac")
    WebElement product_link;

    public boolean DoesMyProductExist() {
        try {
            return selected_product.isDisplayed();
        }
         catch (Exception e) {
            return false;
        }
    }
    public void ClickProduct()
    {
        product_link.click();
    }
}
