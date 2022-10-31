package dz.bououza.acceptance;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.quarkiverse.cucumber.CucumberQuarkusTest;
import org.eclipse.microprofile.rest.client.inject.RestClient;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class calculatorAcceptanceTest extends CucumberQuarkusTest {

    @RestClient
    CalculatorResource resource;

    private String a;
    private String b;
    private String result;
    @Given("^I have two numbers: (.*) and (.*)$")
    public void i_have_two_numbers(String a,String b) throws Throwable{
        this.a=a;
        this.b=b;
    }

    @When("^the calculator sums them$")
    public void the_calculator_sums_them()throws Throwable{
        result = resource.sum(Integer.parseInt(a),Integer.parseInt(b));
    }

    @Then("^I receive (.*) as a result$")
    public void i_receive_as_a_result(String expectedResult){
        assertEquals(expectedResult,result);
    }
}
