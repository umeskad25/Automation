package stepDefinations;

import org.junit.Assert;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.RestAssured;
import io.restassured.response.Response;

public class StepDefinations6 {

	Response r;
	@Given("API for foreign exchange for future date")
	public void api_for_foreign_exchange_for_future_date() {
		 System.out.println("Scanario 6 to validate future date scanaario");
			System.out.println("API Launch");
	}

	@When("posted with future date information")
	public void posted_with_future_date_information() {
		RestAssured.when().get("https://api.ratesapi.io/api/2010-01-12").then().log().all();
		r = RestAssured.given().get("https://api.ratesapi.io/api/2010-01-12");
	}

	@Then("validate positive response received")
	public void validate_positive_response_received() {
		 Assert.assertEquals(200, r.getStatusCode());
	}



	
}
