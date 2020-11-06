package stepDefinations;

import static org.hamcrest.CoreMatchers.equalTo;

import org.junit.Assert;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.RestAssured;
import io.restassured.response.Response;

public class StepDefinations5 {

	Response r;
	
	@Given("foreign exchange negative scanario API launch")
	public void foreign_exchange_negative_scanario_API_launch() {
		System.out.println("Scanario 5 to validate negative scanaario");
		System.out.println("API Launch");
	}

	@When("posted with incorrect or incomplete API")
	public void posted_with_incorrect_or_incomplete_API() {
		r = RestAssured.when().get("https://api.ratesapi.io/api/lates");
	}

	@Then("validate response for negative response API")
	public void validate_response_for_negative_response_API() {
		Assert.assertEquals( "HTTP/1.1 400 Bad Request",r.getStatusLine());
		Assert.assertEquals(400, r.getStatusCode()); 
		RestAssured.given().when().get("https://api.ratesapi.io/api/lates").then().body("error", equalTo("time data 'lates' does not match format '%Y-%m-%d'"));
	}


}
