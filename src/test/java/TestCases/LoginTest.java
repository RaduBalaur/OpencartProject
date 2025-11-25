package TestCases;

import TestBase.BaseClass;
import org.testng.Assert;
import org.testng.annotations.Test;
import pageObjects.HomePage;
import pageObjects.LoginPage;
import pageObjects.MyAccountPage;

public class LoginTest extends BaseClass {

    @Test(groups = {"Sanity","Master"})
    public void verify_login()
    {
        logger.info("Starting Login Test");
        try {
            HomePage hp = new HomePage(driver);
            hp.clickAccount();
            logger.info("Clicked on MyAccount");
            hp.ClickLogin();
            logger.info("Clicked Login");

            LoginPage lp = new LoginPage(driver);
            lp.EnterEmail(p.getProperty("email"));
            logger.info("Entering Email");
            lp.EnterPassword(p.getProperty("password"));
            logger.info("Entering Password");
            lp.clickLogin();
            logger.info("Clicked On Login");

            MyAccountPage macc = new MyAccountPage(driver);
            boolean targetpage = macc.DoesMyAccountExist();
            Assert.assertTrue(targetpage);
            logger.info("Validating If Login Was Successful");
        }
        catch (Exception e)
        {
            Assert.fail();
        }
        logger.info("Finished Login Test");

    }
}
