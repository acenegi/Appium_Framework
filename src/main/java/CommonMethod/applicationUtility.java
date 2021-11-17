package CommonMethod;

import BaseLibrary.BaseClass;
import io.appium.java_client.MobileBy;
import io.appium.java_client.MobileElement;
import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.touch.TapOptions;
import org.openqa.selenium.WebElement;
import static io.appium.java_client.touch.LongPressOptions.longPressOptions;
import static io.appium.java_client.touch.WaitOptions.waitOptions;
import static io.appium.java_client.touch.offset.ElementOption.element;
import static java.time.Duration.ofSeconds;
import static io.appium.java_client.touch.TapOptions.tapOptions;
import static java.time.Duration.ofMillis;
import static java.time.Duration.ofSeconds;

public class applicationUtility extends BaseClass {

   static  TouchAction action = new TouchAction(driver);

    public static void Swipe_oneToSecond_element(WebElement first, WebElement second, int sec){

        //long press //on element// 2 sec// move to another element and you release

        action.longPress(longPressOptions()
                .withElement(element(first))
                .withDuration(ofSeconds(sec)))
                .moveTo(element(second))
                .release().perform();

    }

    //Tap element to for milliseconds

    public static void tapBy_element(WebElement element,int milli_Second){

                action.tap(tapOptions().withElement(element(element)))
                .waitAction(waitOptions(ofMillis(milli_Second))).perform();

    }

    //Press by element for seconds

    public static void pressBy_element(WebElement element, long seconds){

              action.press(element(element))
                .waitAction(waitOptions(ofSeconds(seconds)))
                .release()
                .perform();

    }

    public static WebElement scrollToAnElementByText(AndroidDriver driver, String text) {
        return driver.findElement(MobileBy.AndroidUIAutomator(
                "new UiScrollable(new UiSelector())" + ".scrollIntoView(new UiSelector().text(\"" + text + "\"));"));
    }





}


