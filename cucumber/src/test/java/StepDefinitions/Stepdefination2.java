package StepDefinitions;

import org.junit.Assert;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import io.restassured.RestAssured;
import io.restassured.response.Response;

public class Stepdefination2 {
	 Response r;
	@Given("Rates API for specific date")
	public void rates_API_for_specific_date() {
		 System.out.println("rates API launch for Specific date ");
	}

	@When("The API is Ready")
	public void the_API_is_Ready() {
		 r= RestAssured.get("https://api.ratesapi.io/api/2010-01-12");
	}

	@Then("validate the status Response")
	public void validate_the_status_Response() {
		  System.out.println("Sucess status code"+ r.getStatusCode());
	        Assert.assertEquals(200,r.getStatusCode());
	}

	@Then("validate the status body Response")
	public void validate_the_status_body_Response() {
		if(r.asString().contains("2010-01-12")) {
		  System.out.println("response body for specific date verified ");
		}
	}

	@Given("Rates API for future date")
	public void rates_API_for_future_date() {
	    System.out.println("Rates API for future date ");
	}

	@When("^response ready for future date$")
	public void response_ready_for_future_date() throws Throwable {
		  r=RestAssured.given().get("https://api.ratesapi.io/api/2020-12-16");
	}

	@Then("validate the status response for future date")
	public void validate_the_status_response_for_future_date() {
	    if(r.asString().contains("2020-10-16")) {
	    	System.out.println("Response verified for future date");
	    }
	}
	

}
