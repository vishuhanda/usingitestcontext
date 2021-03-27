import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.ITestContext;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import pageobjects.login.LoginPage;

import java.util.ArrayList;
import java.util.List;

public class LoginTest extends BaseTest {


    @Test()
    public void checkTest(ITestContext iTestContext) {
        LoginPage loginPage = new LoginPage();
        loginPage.openLoginPage(iTestContext);
        loginPage.getCurrentUrl(iTestContext);
        Assert.assertEquals(loginPage.getCurrentUrl(iTestContext), "https://mibenefits-uat.ebms.com/auth/login");
    }


    @Test()
    public void checkLanguageOnLoginPage(ITestContext iTestContext) {

        LoginPage loginPage = new LoginPage();
        loginPage.openLoginPage(iTestContext);
        List<WebElement> loginlanguages = loginPage.getLanguages(iTestContext);

        List<String> actualLoginLanguages = new ArrayList<>();
        actualLoginLanguages.add("English");
        actualLoginLanguages.add("Español");

        System.out.println(loginlanguages.get(0).getText());
        System.out.println(loginlanguages.get(1).getText());

        SoftAssert softAssert = new SoftAssert();
        softAssert.assertEquals(loginlanguages.get(0).getText(), "English");
        softAssert.assertEquals(loginlanguages.get(1).getText(), "Español");
        softAssert.assertAll();
    }


    @Test()
    public void checkAdminLogin(ITestContext iTestContext) {
        LoginPage loginPage = new LoginPage();
        loginPage.openLoginPage(iTestContext);
        String checkDashboardUrl = loginPage.checkLogin(iTestContext);
        Assert.assertEquals(checkDashboardUrl,"https://mibenefits-uat.ebms.com/administrator/dashboard");
    }


}
