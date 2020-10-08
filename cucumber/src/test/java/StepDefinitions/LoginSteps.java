package StepDefinitions;

import org.testng.Assert;
import org.testng.annotations.Test;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.RestAssured;
import io.restassured.http.Header;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;

public class LoginSteps {

	Response response;
	int statusCode;
	String responseBody;
	
	//Scenario - 1
	@Given("^Rates API for Latest Foreign Exchange rates$")
    public void Rates_API_for_Latest_Foreign_Exchange_rates() throws Exception {
		Header h =  new Header("Accept","Application/json");
		response = RestAssured.given().header(h).get("https://api.ratesapi.io/api/latest");
       
    }

 

    @When("^The API is available$")
    public void The_API_is_available() throws Exception {
    	statusCode= response.getStatusCode();
    	System.out.println("when");
    }

 

    @Then("^validate the status$")
    public void validate_the_status() throws Exception {
    	Assert.assertEquals(statusCode, 200);
      System.out.println(statusCode);
    }
    
  //Scenario - 2

//	@When("^The Response is available$")
//	public void The_Response_is_available() throws Exception {
//	responseBody = response.getBody().asString();
//	}
//
//	@Then("^validate the response body$")
//	public void validate_the_response_body() throws Exception {
//	  JsonPath j = response.jsonPath();
//	  Assert.assertEquals(j.get("base"), "EUR");
//		Assert.assertNotNull(responseBody);
//	 
//	}
//	
//	//Scenario - 3
//	@Given("^Rates API for Latest Foreign Exchange API$")
//    public void Rates_API_for_Latest_Foreign_Exchange_API() throws Exception {
//		Header h =  new Header("Accept","Application/json");
//		response = RestAssured.given().header(h).get("https://api.ratesapi.io/api");
//       
//    }
//
// 
//
//    @When("^The Response of API is ready$")
//    public void The_Response_of_API_is_ready() throws Exception {
//    	statusCode= response.getStatusCode();
//    	System.out.println(statusCode);
//    }
//
// 
//
//    @Then("^validate the incorrect API response$")
//    public void validate_the_incorrect_API_response() throws Exception {
//    	JsonPath j = response.jsonPath();
//    	Assert.assertEquals(j.get("error"), "time data 'api' does not match format '%Y-%m-%d'");
//    }
//    
//  //Scenario - 4
//  	@Given("^Rates API for Latest Foreign Exchange AP$")
//      public void Rates_API_for_Latest_Foreign_Exchange_AP() throws Exception {
//  		Header h =  new Header("Accept","Application/json");
//  		response = RestAssured.given().header(h).get("https://api.ratesapi.io/api");
//         
//      }
//
//   
//
//      @When("^The Response of API is read$")
//      public void The_Response_of_API_is_read() throws Exception {
//      	statusCode= response.getStatusCode();
//      	System.out.println(statusCode);
//      }
//
//   
//
//      @Then("^validate the incorrect API respons$")
//      public void validate_the_incorrect_API_respons() throws Exception {
//      	JsonPath j = response.jsonPath();
//      	Assert.assertEquals(j.get("error"), "time data 'api' does not match format '%Y-%m-%d'");
//      }
	
    
}
