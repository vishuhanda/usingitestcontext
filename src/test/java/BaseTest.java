import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.ITestContext;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class BaseTest {


    @BeforeSuite
    public void BeforeSuite(ITestContext iTestContext) {
        try {
            Properties properties = new Properties();
            properties.load(new FileInputStream(new File(System.getProperty("user.dir") + "/config.properties")));

            iTestContext.setAttribute("properties", properties);
        } catch (FileNotFoundException ex) {
            System.out.println("File not found exception occured " + ex);
        } catch (IOException ex) {
            System.out.println("IO exception occured while reading properties file " + ex);
        }

    }

    @BeforeMethod
    public void BeforeMethod(ITestContext iTestContext) {
        System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir") + "/Drivers/chromedriverV89.exe");
        iTestContext.setAttribute("driver",new ChromeDriver());
        WebDriver driver = (WebDriver) iTestContext.getAttribute("driver");
        driver.manage().window().maximize();
    }


    @AfterMethod
    public void AfterMethod(ITestContext iTestContext) {
        WebDriver driver = (WebDriver) iTestContext.getAttribute("driver");
        driver.quit();
        iTestContext.removeAttribute("driver");
    }

    @AfterSuite
    public void AfterSuite(ITestContext iTestContext) {
        iTestContext.removeAttribute("properties");
    }


}
