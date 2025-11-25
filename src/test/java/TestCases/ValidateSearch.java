package TestCases;

import TestBase.BaseClass;
import org.testng.Assert;
import org.testng.annotations.Test;
import pageObjects.HomePage;
import pageObjects.LoginPage;
import pageObjects.MyAccountPage;
import pageObjects.ProductsPage;

public class ValidateSearch extends BaseClass {

    @Test(groups = "Master")
    public void verify_search() {
        logger.info("Starting Validate Search Test");
        try {
            HomePage hp = new HomePage(driver);
            hp.clickAccount();
            logger.info("Clicked On My Account");
            hp.ClickLogin();
            logger.info("Clicked On Login");

            LoginPage lp = new LoginPage(driver);
            lp.EnterEmail(p.getProperty("email"));
            logger.info("Entered Email");
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
            boolean targetproduct = prd.DoesMyProductExist();
            logger.info("Validating If Product Is Displayed");
            Assert.assertTrue(targetproduct);
        }
        catch (Exception e) {
            Assert.fail();
        }
        logger.info("Finished Validate Search Test");
    }
}
