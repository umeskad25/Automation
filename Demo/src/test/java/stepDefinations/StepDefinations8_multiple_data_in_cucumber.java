package stepDefinations;

import static org.hamcrest.CoreMatchers.equalTo;

import org.junit.Assert;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.RestAssured;
import io.restassured.response.Response;

public class StepDefinations8_multiple_data_in_cucumber {

	Response r;
	@Given("Latest Foreign Exchange rates API given")
	public void latest_Foreign_Exchange_rates_API_given() {
		System.out.println("Scanario 8 to validate future date scanaario");
		System.out.println("API Launch");
	}

	@When("posted with multiple {string} information")
	public void posted_with_multiple_information(String string) {
	  RestAssured.given().when().get("https://api.ratesapi.io/api/"+string).then().body("date",equalTo(string));
	  System.out.println(string);
	  r = RestAssured.get("https://api.ratesapi.io/api/"+string);
	}

	@Then("validate Response")
	public void validate_Response() {
		Assert.assertEquals(200, r.getStatusCode());
	}
}
