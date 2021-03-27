package utilities;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public final class WaitFactory {


    public WaitFactory() {

    }

    public void waitTillElementVisible(WebDriver driver, String waitTime, By by) {
        WebDriverWait webDriverWait = new WebDriverWait(driver, Integer.parseInt(waitTime));
        webDriverWait.until(ExpectedConditions.visibilityOfElementLocated(by));
    }




    public void waitTillPageLoad(WebDriver driver) {
        JavascriptExecutor jsexecuter = (JavascriptExecutor) driver;
        for (int i = 0; i < 50; i++) {
            String readyState = jsexecuter.executeScript("return document.readyState").toString();
            if(readyState.equalsIgnoreCase("complete")){
                break;
            }
            else{
                try{
                    Thread.sleep(200);
                }
                catch (InterruptedException interruptedException){
                    System.out.println("exception occured " + interruptedException);
                }
            }
        }
    }


//    public void waitTillElement(WebDriver driver, String waitTime, By by){
//        WebDriverWait webDriverWait = new WebDriverWait(driver,Integer.parseInt(waitTime));
//    }

}
