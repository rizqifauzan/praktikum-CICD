// java
package pages;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import org.openqa.selenium.WebElement;

import java.net.MalformedURLException;

public class IntroPage extends BasePage {

    @AndroidFindBy(id = "com.socialnmobile.dictapps.notepad.color.note:id/step1_next")
    private WebElement nextButton;

    @AndroidFindBy(id = "com.socialnmobile.dictapps.notepad.color.note:id/btn_start_skip")
    private WebElement doneButton;

    public IntroPage() throws MalformedURLException {
        super();
    }

    public void skip() {
        nextButton.click();
        doneButton.click();
    }
}
