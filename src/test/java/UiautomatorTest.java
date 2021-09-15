import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;

import java.net.MalformedURLException;
import java.util.concurrent.TimeUnit;

public class UiautomatorTest extends Base {
    public static void main(String[] args) throws MalformedURLException {
        AndroidDriver<AndroidElement> driver = Capabilities("emulator");
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        //driver.findElementByAndroidUIAutomator("(attribute('value')");

        driver.findElementByAndroidUIAutomator("text(\"Views\")").click();
        driver.findElementByAndroidUIAutomator("text(\"Animation\")").click();

        //Validate clickable feature for all options
        System.out.println(driver.findElementsByAndroidUIAutomator("new UiSelector().clickable(true)").size());

    }
}
