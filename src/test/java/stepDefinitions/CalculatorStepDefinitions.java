package stepDefinitions;

import static org.junit.Assert.assertEquals;  // Menggunakan JUnit 4 Assert

import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import io.cucumber.java.en.Then;

public class CalculatorStepDefinitions {

    private int num1, num2, result;

    // Step for "Given I have two numbers X and Y"
    @Given("I have two numbers {int} and {int}")
    public void i_have_two_numbers_and(int number1, int number2) {
        num1 = number1;
        num2 = number2;
    }

    // Step for "When I add them"
    @When("I add them")
    public void i_add_them() {
        result = num1 + num2;
    }

    // Step for "When I subtract them"
    @When("I subtract them")
    public void i_subtract_them() {
        result = num1 - num2;
    }

    // Step for "When I multiply them"
    @When("I multiply them")
    public void i_multiply_them() {
        result = num1 * num2;
    }

    // Step for "When I divide them"
    @When("I divide them")
    public void i_divide_them() {
        if (num2 != 0) {
            result = num1 / num2;
        } else {
            result = Integer.MAX_VALUE;  // To handle division by zero
        }
    }

    // Step for "Then the result should be X"
    @Then("the result should be {int}")
    public void the_result_should_be(int expectedResult) {
        assertEquals(expectedResult, result);
    }

    // Step for "Then the result should be 'undefined'" (for division by zero)
    @Then("the result should be {string}")
    public void the_result_should_be_string(String expectedResult) {
        if (result == Integer.MAX_VALUE) {
            assertEquals("undefined", expectedResult);
        }
    }
}
