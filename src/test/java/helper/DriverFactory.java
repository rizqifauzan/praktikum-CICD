package helper;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.ios.IOSDriver;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.net.MalformedURLException;
import java.net.URL;

public class DriverFactory {

    private static AppiumDriver driver;

    /**
     * Inisialisasi driver berdasarkan platform (Android / iOS)
     * @param platformName nama platform: "Android" atau "iOS"
     */
    public static AppiumDriver initializeDriver(String platformName) throws MalformedURLException {
        DesiredCapabilities caps = new DesiredCapabilities();

        if (platformName.equalsIgnoreCase("Android")) {
            caps.setCapability("platformName", "Android");
            caps.setCapability("automationName", "UiAutomator2");
            caps.setCapability("deviceName", "RRCW603WLDR");
            caps.setCapability("appium:appPackage", "com.socialnmobile.dictapps.notepad.color.note");
            caps.setCapability("appium:appActivity", "com.socialnmobile.colornote.activity.Main");
            caps.setCapability("appium:noreset", true);
            caps.setCapability("appium:autoGrantPermissions", true);


            driver = new AndroidDriver(new URL("http://127.0.0.1:4723/"), caps);

        } else if (platformName.equalsIgnoreCase("iOS")) {
            caps.setCapability("platformName", "iOS");
            caps.setCapability("automationName", "XCUITest");
            caps.setCapability("deviceName", "iPhone 15 Pro");
            caps.setCapability("platformVersion", "17.0");
            caps.setCapability("bundleId", "com.example.myiosapp");
            caps.setCapability("noReset", true);
            caps.setCapability("autoAcceptAlerts", true);

            driver = new IOSDriver(new URL("http://127.0.0.1:4723/"), caps);

        } else {
            throw new IllegalArgumentException("Platform not supported: " + platformName);
        }

        return driver;
    }

    /**
     * Mengembalikan instance driver aktif
     */
    public static AppiumDriver getDriver() throws MalformedURLException {
        if (driver == null) {
            initializeDriver("Android"); // Atau "iOS" sesuai kebutuhan
            throw new IllegalStateException("Driver belum diinisialisasi. Panggil initializeDriver() terlebih dahulu.");
        }
        return driver;
    }

    /**
     * Menutup driver
     */
    public static void quitDriver() {
        if (driver != null) {
            driver.quit();
            driver = null;
        }
    }
}
