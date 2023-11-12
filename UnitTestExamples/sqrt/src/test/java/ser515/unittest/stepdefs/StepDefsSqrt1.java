package ser515.unittest.stepdefs;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import static org.junit.jupiter.api.Assertions.*;
import ser515.unittest.SimpleSquareRootFunction;

public class StepDefsSqrt1 {
    int testInt;
    double result;

    @Given("I have an integer {string}")
    public void i_have_an_integer(String string) {
	// Write code here that turns the phrase above into concrete actions
	testInt = Integer.parseInt(string); 
    }
    
    @When("I compute the square root")
    public void i_compute_the_square_root() {
	result = SimpleSquareRootFunction.makeSqrt(testInt);
    }

    @Then("I should return a positive number")
    public void i_should_return_a_positive_number() {
	assertTrue(result > 0.0);
    }
}
