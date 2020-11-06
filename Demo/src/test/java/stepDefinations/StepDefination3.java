package stepDefinations;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import org.junit.Assert;

import static org.hamcrest.CoreMatchers.equalTo;
public class StepDefination3 {

	Response r;
	
	@Given("Rates API for latest foreign exchange")
	public void rates_API_for_latest_foreign_exchange() {
	    System.out.println("Scanario 3 to validate response code");
		System.out.println("API Launch");
	}

	@When("posted with correct Information for latest api")
	public void posted_with_correct_Information_for_latest_api() {
		r = RestAssured.given().get("https://api.ratesapi.io/api/latest");
	}

	@Then("validate the response for latest")
	public void validate_the_response_for_latest() {
	   //minimum 2 assertions

		   Assert.assertEquals(200, r.getStatusCode());
		   Assert.assertEquals( "application/json",r.getContentType());
		   Assert.assertEquals( "HTTP/1.1 200 OK",r.getStatusLine());
			RestAssured.given().get("https://api.ratesapi.io/api/latest").then().body("base", equalTo("EUR"));
		
			
	}

}
