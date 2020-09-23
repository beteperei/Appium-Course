import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.touch.LongPressOptions;
import io.appium.java_client.touch.TapOptions;
import io.appium.java_client.touch.offset.ElementOption;
import org.junit.Assert;
import org.openqa.selenium.WebElement;

import java.net.MalformedURLException;
import java.time.Duration;
import java.util.concurrent.TimeUnit;

public class GeneralStore_TestCase04 extends Base_generalstore {

    public static void main(String[] args) throws MalformedURLException, InterruptedException {
        AndroidDriver<AndroidElement> driver = Capabilities();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

        driver.findElementById("com.androidsample.generalstore:id/nameField").sendKeys("Bertha");
        driver.hideKeyboard();
        driver.findElementById("com.androidsample.generalstore:id/radioFemale").click();
        driver.findElementById("com.androidsample.generalstore:id/spinnerCountry").click();
        driver.findElementByAndroidUIAutomator("new UiScrollable(new UiSelector()).scrollIntoView(text(\"Argentina\"));");
        driver.findElementByXPath("//android.widget.TextView[@text='Argentina']").click();
        driver.findElementById("com.androidsample.generalstore:id/btnLetsShop").click();

        driver.findElementsByXPath("//*[@text='ADD TO CART']").get(1).click();
        driver.findElementsByXPath("//*[@text='ADD TO CART']").get(0).click();

        driver.findElementById("com.androidsample.generalstore:id/appbar_btn_cart").click();
        Thread.sleep(4000);


        String priceTxt1 = driver.findElementsById("com.androidsample.generalstore:id/productPrice").get(0).getText();
        String priceTxt2 = driver.findElementsById("com.androidsample.generalstore:id/productPrice").get(1).getText();

        double price1 = getAmount(priceTxt1);
        double price2 = getAmount(priceTxt2);

        String sumOfProductsTxt = getSumTxt(price1,price2);

        String total = driver.findElementById("com.androidsample.generalstore:id/totalAmountLbl").getText();

        Assert.assertEquals(sumOfProductsTxt,total);

        System.out.println(sumOfProductsTxt);
        System.out.println(total);

        //Mobile Gestures
        WebElement checkbox = driver.findElementByClassName("android.widget.CheckBox");
        TouchAction t = new TouchAction(driver);
        t.tap(TapOptions.tapOptions().withElement(ElementOption.element(checkbox))).perform();

        WebElement tc= driver.findElementByXPath("//*[@text='Please read our terms of conditions']");
        t.longPress(LongPressOptions.longPressOptions().withElement(ElementOption.element(tc)).withDuration(Duration.ofSeconds(2))).release().perform();

        driver.findElementById("android:id/button1").click();
        driver.findElementById("com.androidsample.generalstore:id/btnProceed").click();

    }

    public static double getAmount(String value){
        value = value.substring(1);
        double amountToValue = Double.parseDouble(value);
        return amountToValue;
    }

    public static String getSumTxt(double price1, double price2){
        double sumoOfProducts = price1 + price2;
        String sumOfProductsTxt = "$ " + sumoOfProducts;
        return sumOfProductsTxt;
    }

}

