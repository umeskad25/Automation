package stepDefinations;

import static org.hamcrest.CoreMatchers.equalTo;

import org.junit.Assert;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.RestAssured;
import io.restassured.response.Response;

public class StepDefinations7 {

	Response r;
	
	@Given("foreign exchange for negative scanario future date API")
	public void foreign_exchange_for_negative_scanario_future_date_API() {
		 System.out.println("Scanario 7 to validate future date scanaario");
			System.out.println("API Launch");
	}

	@When("posted with future year date information")
	public void posted_with_future_year_date_information() {
		 r = RestAssured.when().get("https://api.ratesapi.io/api/2022-01-12");  
	}

	@Then("validate future positive response received")
	public void validate_future_positive_response_received() {
		 Assert.assertEquals(200, r.getStatusCode());
		   Assert.assertEquals( "application/json",r.getContentType());
		RestAssured.given().when().get("https://api.ratesapi.io/api/2022-01-12").then().body("date", equalTo("2020-11-06"));
		// update above line everyday to passs this test or you can use LocalDate from java 
	
	}



}
