package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class RegistrationPage extends BasePage{


    public RegistrationPage(WebDriver driver)
    {
        super(driver);
    }
    @FindBy(xpath="//input[@id='input-firstname']")
    WebElement txt_frname;
    @FindBy(xpath="//input[@id='input-lastname']")
    WebElement txt_lname;
    @FindBy(xpath="//input[@id='input-email']")
    WebElement txt_email;
    @FindBy(xpath="//input[@id='input-telephone']")
    WebElement txt_tel;
    @FindBy(xpath="//input[@id='input-password']")
    WebElement txt_password;
    @FindBy(xpath="//input[@id='input-confirm']")
    WebElement txt_comfpass;
    @FindBy(xpath="//input[@name='agree']")
    WebElement btn_privacy;
    @FindBy(xpath="//input[@value='Continue']")
    WebElement btn_continue;
    @FindBy(xpath="//h1[normalize-space()='Your Account Has Been Created!']")
    WebElement txt_comfmsg;

    public void SetFirstName(String frname)
    {
        txt_frname.sendKeys(frname);
    }
    public void SetLastName(String lname)
    {
        txt_lname.sendKeys(lname);
    }
    public void SetEmail(String email)
    {
        txt_email.sendKeys(email);
    }
    public void SetTelephone(String tel)
    {
        txt_tel.sendKeys(tel);
    }
    public void SetPassword(String pass)
    {
        txt_password.sendKeys(pass);
    }
    public void ComfirmPass(String comfpass)
    {
        txt_comfpass.sendKeys(comfpass);
    }
    public void ClickPrivacy()
    {
        btn_privacy.click();
    }
    public void ClickContinue()
    {
        btn_continue.click();
    }
    public String GetComfirmationMessage(){
        try{
            return(txt_comfmsg.getText());
        } catch (Exception e){
            return(e.getMessage());
        }
    }
}
