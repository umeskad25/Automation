package stepDefinations;

import static org.hamcrest.CoreMatchers.equalTo;

import org.junit.Assert;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.RestAssured;
import io.restassured.http.Header;
import io.restassured.response.Response;

public class StepDefinations4 {

	
 Response r;
@Given("API for foreign exchange negative scanario")
public void api_for_foreign_exchange_negative_scanario() {
	  System.out.println("Scanario 4 to validate negative scanaario");
			System.out.println("API Launch");
}

@When("posted with incorrect API")
public void posted_with_incorrect_API() {
 r = RestAssured.when().get("https://api.ratesapi.io/api/lates");
   }

@Then("validate response for negative response")
public void validate_response_for_negative_response() {
	 Assert.assertEquals(400, r.getStatusCode());
	 RestAssured.when().get("https://api.ratesapi.io/api/lates").then().log().all();
	
}
}
