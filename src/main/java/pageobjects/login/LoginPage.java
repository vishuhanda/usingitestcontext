package pageobjects.login;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.ITestContext;
import utilities.WaitFactory;

import java.util.List;
import java.util.Properties;

public final class LoginPage {


    By loginLanguageElement = By.xpath("//div[@class='login__section--multi-lingual']/li/div[1]");
    By getLanguagesElements = By.xpath("//div[@class='dropdown dropdown--header tooltip__action pre-animation dropdown--multi-lingual']/div/div/ul/li");

    By usernameElement = By.xpath("//input[@id='username']");
    By passwordElement = By.xpath("//input[@id='password']");

    By signInButton = By.xpath("//button[@class='login__button--sign-in']");


//    public final ITestContext iTestContext;

    public LoginPage(
//            ITestContext iTestContext
    ) {
//        this.iTestContext = iTestContext;
    }


    public void openLoginPage(ITestContext iTestContext) {
        WebDriver driver = (WebDriver) iTestContext.getAttribute("driver");
        driver.get("https://mibenefits-uat.ebms.com/auth/login");
    }

    public String getCurrentUrl(ITestContext iTestContext) {
        WebDriver driver = (WebDriver) iTestContext.getAttribute("driver");
        System.out.println(driver.getCurrentUrl());
        return driver.getCurrentUrl();
    }

    public List<WebElement> getLanguages(ITestContext iTestContext) {
        WebDriver driver = (WebDriver) iTestContext.getAttribute("driver");
        WaitFactory waitFactory = new WaitFactory();
        waitFactory.waitTillPageLoad(driver);
        waitFactory.waitTillElementVisible(driver, "20", loginLanguageElement);
        driver.findElement(loginLanguageElement).click();
        waitFactory.waitTillElementVisible(driver, "20", getLanguagesElements);
        List<WebElement> multilingualLanguages = driver.findElements(getLanguagesElements);
        return multilingualLanguages;
    }

    public String checkLogin(ITestContext iTestContext) {
        WebDriver driver = (WebDriver) iTestContext.getAttribute("driver");
        Properties properties = (Properties) iTestContext.getAttribute("properties");
        WaitFactory waitFactory = new WaitFactory();
        waitFactory.waitTillPageLoad(driver);
        driver.findElement(usernameElement).sendKeys(properties.getProperty("username"));
        driver.findElement(passwordElement).sendKeys(properties.getProperty("password"));
        driver.findElement(signInButton).click();
        return driver.getCurrentUrl();


    }


}
