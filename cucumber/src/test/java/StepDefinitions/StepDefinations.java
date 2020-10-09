package StepDefinitions;

import org.junit.Assert;


import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import io.restassured.RestAssured;
import io.restassured.http.Header;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import static org.hamcrest.Matchers.*;

public class StepDefinations {
	Response response;
	int statusCode;
	String responseBody;
	
	//Scenario - 1
@Given("^Rates API for Latest Foreign Exchange rates$")
public void rates_API_for_Latest_Foreign_Exchange_rates() throws Throwable {
	Header h =  new Header("Accept","Application/json");
	response = RestAssured.given().header(h).get("https://api.ratesapi.io/api/latest");
}

@When("^The API is available$")
public void the_API_is_available() throws Throwable {
	statusCode= response.getStatusCode();
}

@Then("^validate the status$")
public void validate_the_status() throws Throwable {
	Assert.assertEquals(statusCode, 200);
    System.out.println("Status code verified : " +statusCode);
}

//Scenario - 2
@When("^The Response is available$")
public void the_Response_is_available() throws Throwable {
	responseBody = response.getBody().asString();
}

@Then("^validate the response body$")
public void validate_the_response_body() throws Throwable {
	if(responseBody.contains("EUR")) {
		System.out.println("Response body is verified");
	}
}


//Scenario - 3
@Given("^Rates API for Latest Foreign Exchange API$")
public void rates_API_for_Latest_Foreign_Exchange_API() throws Throwable {
	Header h1 =  new Header("Accept","Application/json");
	response = RestAssured.given().header(h1).get("https://api.ratesapi.io/api");
}

@When("^The Response of API is ready$")
public void the_Response_of_API_is_ready() throws Throwable {
	statusCode= response.getStatusCode();
	System.out.println("Response status code: "+statusCode);
}

@Then("^validate the incorrect API response$")
public void validate_the_incorrect_API_response() throws Throwable {
	if(response.asString().contains("time data 'api' does not match format '%Y-%m-%d'")) {
		System.out.println("Incorrect /incomplete url verified");
	}
	
}




}
