import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.testng.Assert;

import java.net.MalformedURLException;

public class Browse  extends BaseChrome {

    public static void main(String[] args) throws MalformedURLException {
        AndroidDriver<AndroidElement> driver = Capabilities("real");
        /*driver.get("https://fb.com");
        driver.findElementByXPath("//*[@id=\'m_login_email\']").sendKeys("username");
        driver.findElementByXPath("//*[@id=\'m_login_password\']").sendKeys("12345");
        driver.findElementByXPath("//button[@name='login']").click();*/

        driver.get("https://cricbuzz.com");
        driver.findElementByXPath("//a[@href='#menu']").click();
        driver.findElementByCssSelector("a[title='Cricbuzz Home']").click();
        System.out.println(driver.getCurrentUrl());
        JavascriptExecutor jse = (JavascriptExecutor) driver;
            jse.executeScript("window.scrollBy(0,600)","");
            Assert.assertTrue(driver.findElement(By.xpath("//h4[text()='Top Stories']")).getAttribute("class").contains("header"));


    }

}
