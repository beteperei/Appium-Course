import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.remote.MobileCapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;

public class Base_generalstore {
    public static AndroidDriver<AndroidElement> Capabilities() throws MalformedURLException {
        File f =new File("src");
        File fs = new File(f,"General-Store.apk");
        String serverURL = "http://127.0.0.1:4723/wd/hub";

        DesiredCapabilities cap = new DesiredCapabilities();
        cap.setCapability(MobileCapabilityType.DEVICE_NAME , "Android device");
        cap.setCapability(MobileCapabilityType.AUTOMATION_NAME,"uiautomator2");
        cap.setCapability(MobileCapabilityType.APP, fs.getAbsolutePath());

        AndroidDriver<AndroidElement> driver = new AndroidDriver(new URL(serverURL), cap);
        return driver;
    }
}
