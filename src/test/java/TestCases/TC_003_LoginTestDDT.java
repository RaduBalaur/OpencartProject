package TestCases;

import TestBase.BaseClass;
import Utilities.DataProviders;
import org.testng.Assert;
import org.testng.annotations.Test;
import pageObjects.HomePage;
import pageObjects.LoginPage;
import pageObjects.MyAccountPage;

public class TC_003_LoginTestDDT extends BaseClass {

    @Test(dataProvider = "LoginData",dataProviderClass = DataProviders.class,groups = "DataDriven")
    public void Verify_LoginDDT(String email, String pass, String exp)
    {
        logger.info("Starting TC_003_LoginTestDDT");
        try{
        HomePage hp = new HomePage(driver);
        hp.clickAccount();
        hp.ClickLogin();

        LoginPage lp = new LoginPage(driver);
        lp.EnterEmail(email);
        lp.EnterPassword(pass);
        lp.clickLogin();

        MyAccountPage macc = new MyAccountPage(driver);
        boolean targetpage = macc.DoesMyAccountExist();

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
