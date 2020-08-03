import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;

import java.net.MalformedURLException;

public class Browse  extends BaseChrome {

    public static void main(String[] args) throws MalformedURLException {
        AndroidDriver<AndroidElement> driver = Capabilities("real");
        driver.get("https://fb.com");
        driver.findElementByXPath("//*[@id=\'m_login_email\']").sendKeys("username");
        driver.findElementByXPath("//*[@id=\'m_login_password\']").sendKeys("12345");
        driver.findElementByXPath("//button[@name='login']").click();

    }

}
