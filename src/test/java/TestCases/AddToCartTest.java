package TestCases;

import TestBase.BaseClass;
import org.testng.Assert;
import org.testng.annotations.Test;
import pageObjects.*;

public class AddToCartTest extends BaseClass {

    @Test(groups = "Master")
    public void verify_AddToCart() {
        logger.info("Started Add To Cart Test");
        try {
            HomePage hp = new HomePage(driver);
            hp.clickAccount();
            logger.info("Clicked on my account");
            hp.ClickLogin();
            logger.info("Clicked Login");

            LoginPage lp = new LoginPage(driver);
            lp.EnterEmail(p.getProperty("email"));
            logger.info("Entered login");
            lp.EnterPassword(p.getProperty("password"));
            logger.info("Entered Password");
            lp.clickLogin();
            logger.info("Logged In");

            MyAccountPage macc = new MyAccountPage(driver);
            macc.SearchForProduct(p.getProperty("product"));
            logger.info("Entered Product Name");
            macc.ClickOnSearch();
            logger.info("Clicked On Search");

            ProductsPage prd = new ProductsPage(driver);
            prd.ClickProduct();
            logger.info("Clicked On Product");

            ProductDisplayPage pdp = new ProductDisplayPage(driver);
            pdp.ClickAddToCart();
            logger.info("Clicked On Add To Cart");
            pdp.DoesSuccessMessageExist();
            logger.info("Validating If Success Message Is Displayed");
            pdp.ClickOnShoppingCart();
            logger.info("Clicked On Shopping Cart");

            ShoppingCartPage shop = new ShoppingCartPage(driver);
            shop.IsMyProductInCart();
            logger.info("Validating If Product Is Displayed In Shopping Cart");
        } catch (Exception e) {
            Assert.fail();
        }
        logger.info("Finished Add To Cart Test");
    }
}
