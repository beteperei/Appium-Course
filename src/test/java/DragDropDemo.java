import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.touch.LongPressOptions;
import org.openqa.selenium.WebElement;

import java.awt.event.MouseAdapter;
import java.net.MalformedURLException;
import java.util.concurrent.TimeUnit;

import static io.appium.java_client.touch.offset.ElementOption.element;

public class DragDropDemo extends Base {
    public static void main(String[] args) throws MalformedURLException {
        AndroidDriver<AndroidElement> driver = Capabilities("real");
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

        driver.findElementByAndroidUIAutomator("text(\"Views\")").click();
        driver.findElementByXPath("//android.widget.TextView[@text='Drag and Drop']").click();

        TouchAction t = new TouchAction(driver);
        WebElement source = driver.findElementsByClassName("android.view.View").get(0);
        WebElement destination = driver.findElementsByClassName("android.view.View").get(2);
        //t.longPress(LongPressOptions.longPressOptions().withElement(element(source))).moveTo(element(destination)).release().perform()
        t.longPress(element(source)).moveTo(element(destination)).release().perform();

    }
}
