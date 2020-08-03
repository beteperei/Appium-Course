import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.remote.MobileCapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.net.MalformedURLException;
import java.net.URL;

public class BaseChrome {
    public static AndroidDriver<AndroidElement> Capabilities(String device) throws MalformedURLException {

        String serverURL = "http://127.0.0.1:4723/wd/hub";

        DesiredCapabilities cap = new DesiredCapabilities();
        if(device.equals("emulator")){
            cap.setCapability(MobileCapabilityType.DEVICE_NAME , "Android9");
        } else if(device.equals("real")){
            cap.setCapability(MobileCapabilityType.DEVICE_NAME , "Android device");
        }

        cap.setCapability(MobileCapabilityType.BROWSER_NAME,"Chrome");
        cap.setCapability("chromedriverExecutable",
                "D:\\chromedriver_win32\\chromedriver.exe" );
        AndroidDriver<AndroidElement> driver = new AndroidDriver(new URL(serverURL), cap);
        return driver;
    }




}
