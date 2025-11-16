package TestCases;

import TestBase.BaseClass;
import org.testng.Assert;
import org.testng.annotations.Test;
import pageObjects.HomePage;
import pageObjects.RegistrationPage;

public class TC_001_AccountRegistrationTest extends BaseClass {

    @Test(groups = {"Regression","Master"})
    public void verify_account_registration() throws InterruptedException {

        logger.info("Starting verify_account_registration");
        try {
            HomePage hp = new HomePage(driver);
            hp.clickAccount();
            logger.info("Clicked on MyAccount");
            hp.clickRegister();
            logger.info("Clicked on Register");


            RegistrationPage repage = new RegistrationPage(driver);
            logger.info("Providing customer details");
            repage.SetFirstName(RandomString().toUpperCase());
            repage.SetLastName(RandomString().toUpperCase());
            repage.SetEmail(RandomString() + "@gmail.com");
            repage.SetTelephone(RandomNumber());

            String pass = AlphaNumeric();

            repage.SetPassword(pass);
            repage.ComfirmPass(pass);
            repage.ClickPrivacy();
            repage.ClickContinue();

            String comfmsg = repage.GetComfirmationMessage();
            Assert.assertEquals(comfmsg, "Your Account Has Been Created!");
        } catch (Exception e) {
            logger.error("Test failed");
            logger.debug("Debug logs");
            Assert.fail();
        }
    }
}
