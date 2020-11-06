package stepDefinations;

import org.junit.Assert;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.RestAssured;
import io.restassured.response.Response;


public class StepDefination2 {

	Response r;
	
	
	
	
@Given("Rates API for foreign exchange")
public void rates_API_for_foreign_exchange() {
	System.out.println("Scanario 2 to validate response code");
	System.out.println("API Launch");
}

@When("posted with correct Information for api")
public void posted_with_correct_Information_for_api() {
	r = RestAssured.given().get("https://api.ratesapi.io/api/latest");
	
}

@Then("validate the response and log on console")
public void validate_the_response_and_log_on_console() {
   RestAssured.given().when().get("https://api.ratesapi.io/api/latest").then().log().all();
   Assert.assertEquals(200, r.getStatusCode());
  
  
}

	

}
