package TestCases;

import TestBase.BaseClass;
import org.testng.Assert;
import org.testng.annotations.Test;
import pageObjects.HomePage;
import pageObjects.LoginPage;
import pageObjects.MyAccountPage;

public class TC_002_LoginTest extends BaseClass {

    @Test(groups = {"Sanity","Master"})
    public void verify_login()
    {
        logger.info("Starting Login Test");
        try {
            HomePage hp = new HomePage(driver);
            hp.clickAccount();
            hp.ClickLogin();

            LoginPage lp = new LoginPage(driver);
            lp.EnterEmail(p.getProperty("email"));
            lp.EnterPassword(p.getProperty("password"));
            lp.clickLogin();

            MyAccountPage macc = new MyAccountPage(driver);
            boolean targetpage = macc.DoesMyAccountExist();
            Assert.assertTrue(targetpage);
        }
        catch (Exception e)
        {
            Assert.fail();
        }
        logger.info("Finished Login Test");

    }
}
