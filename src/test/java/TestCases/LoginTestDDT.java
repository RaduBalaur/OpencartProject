package TestCases;

import TestBase.BaseClass;
import Utilities.DataProviders;
import org.testng.Assert;
import org.testng.annotations.Test;
import pageObjects.HomePage;
import pageObjects.LoginPage;
import pageObjects.MyAccountPage;

public class LoginTestDDT extends BaseClass {

    @Test(dataProvider = "LoginData",dataProviderClass = DataProviders.class,groups = "DataDriven")
    public void Verify_LoginDDT(String email, String pass, String exp)
    {
        logger.info("Starting TC_003_LoginTestDDT");
        try{
        HomePage hp = new HomePage(driver);
        hp.clickAccount();
        logger.info("Clicked On My Account");
        hp.ClickLogin();
        logger.info("Clicked On Login");

        LoginPage lp = new LoginPage(driver);
        lp.EnterEmail(email);
        logger.info("Entered Email");
        lp.EnterPassword(pass);
        logger.info("Entered Password");
        lp.clickLogin();
        logger.info("Logged In");

        MyAccountPage macc = new MyAccountPage(driver);
        boolean targetpage = macc.DoesMyAccountExist();
        logger.info("Validating Login Credentials Based On The Login Data From Excel");

        if (exp.equalsIgnoreCase("Valid"))
        {
            if (targetpage==true)
            {
                macc.ClickLogout();
                Assert.assertTrue(true);
            }
            else
            {
                Assert.assertTrue(false);
            }
            if (exp.equalsIgnoreCase("Invalid"))
            {
                if (targetpage==true)
                {
                    macc.ClickLogout();
                    Assert.assertTrue(false);
                }
                else
                {
                    Assert.assertTrue(true);
                }
            }
        }
    }
        catch (Exception e)
        {
            Assert.fail();
        }
        logger.info("Finished TC_003_LoginTestDDT");
}}
