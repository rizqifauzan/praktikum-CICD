package pages;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.openqa.selenium.support.PageFactory;

import java.net.MalformedURLException;
import java.time.Duration;

public class BasePage {

    protected AppiumDriver driver;

    // No-arg constructor to allow subclasses to compile without injecting a driver immediately

    // Preferred constructor: inject the Appium driver and initialize page elements
    BasePage() throws MalformedURLException {
        if(driver == null) {
            driver = helper.DriverFactory.initializeDriver("Android");
        }
        PageFactory.initElements(new AppiumFieldDecorator(driver, Duration.ofSeconds(5)), this);
    }

    protected AppiumDriver getDriver() {
        return driver;
    }
}