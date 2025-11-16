package TestBase;

import org.apache.commons.lang3.RandomStringUtils;
import org.apache.logging.log4j.LogManager;


import org.apache.logging.log4j.Logger;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.Platform;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.net.URL;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.Date;
import java.util.Properties;

public class BaseClass {
  public static WebDriver driver;
  public Logger logger;
  public Properties p;

    public String RandomString()
    {
        String generatedString= RandomStringUtils.randomAlphabetic(5);
        return generatedString;
    }

    public String RandomNumber()
    {
        String generatedNumber= RandomStringUtils.randomNumeric(10);
        return generatedNumber;
    }

    public String AlphaNumeric()
    {
        String generatedString= RandomStringUtils.randomAlphabetic(3);
        String generatedNumber= RandomStringUtils.randomNumeric(3);
        return(generatedString+"@"+generatedNumber);
    }

    @BeforeClass(groups = {"Sanity","Regression","Master"})
    @Parameters({"os","browser"})
   public void setup(String os, String br) throws IOException {

        FileReader file= new FileReader("./src//test//resources//config.properties");
        p= new Properties();
        p.load(file);

        logger= LogManager.getLogger(this.getClass());

        if (p.getProperty("execution_env").equalsIgnoreCase("remote"))
        {
            DesiredCapabilities caps= new DesiredCapabilities();
            if (os.equalsIgnoreCase("windows"))
            {
                caps.setPlatform(Platform.WIN11);
            } else if (os.equalsIgnoreCase("mac"))
            {
                caps.setPlatform(Platform.MAC);
            } else if (os.equalsIgnoreCase("linux")) {
                caps.setPlatform(Platform.LINUX);

            } else
            {
                System.out.println("Invalid os"); return;
            }
            switch (br.toLowerCase())
            {
                case "chrome":caps.setBrowserName("chrome"); break;
                case "firefox":caps.setBrowserName("firefox");break;
                case "edge":caps.setBrowserName("edge");break;
                default:
                    System.out.println("Invalid browser"); return;
            }
            driver= new RemoteWebDriver(new URL(" http://192.168.1.128:4444"),caps);
        }
        if (p.getProperty("execution_env").equalsIgnoreCase("local"))
        {
            switch(br.toLowerCase())
            {
                case "chrome": driver= new ChromeDriver(); break;
                case "edge": driver= new EdgeDriver(); break;
                case "firefox": driver= new FirefoxDriver(); break;
                default:
                    System.out.println("Invalid browser"); return;
            }

        }
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.get(p.getProperty("URL"));

    }

    @AfterClass(groups = {"Sanity","Regression","Master"})
    public void TearDown()
    {
        driver.quit();
    }
    public String captureScreen(String tname) throws IOException {

        String timeStamp = new SimpleDateFormat("yyyyMMddhhmmss").format(new Date());

        TakesScreenshot takesScreenshot = (TakesScreenshot) driver;
        File sourceFile = takesScreenshot.getScreenshotAs(OutputType.FILE);

        String targetFilePath=System.getProperty("user.dir")+"\\screenshots\\" + tname + "_" + timeStamp + ".png";
        File targetFile=new File(targetFilePath);

        sourceFile.renameTo(targetFile);

        return targetFilePath;

    }


}
