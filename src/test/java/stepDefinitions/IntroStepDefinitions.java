package stepDefinitions;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import pages.IntroPage;

import java.net.MalformedURLException;

public class IntroStepDefinitions {

    // Step for "Given I have two numbers X and Y"
    @When("I skip the intro")
    public void skipIntro() throws MalformedURLException {
        IntroPage introPage = new IntroPage();
        introPage.skip();
    }
}
