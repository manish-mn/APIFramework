package stepDefinations;

import java.io.IOException;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import resources.APIResources;
import resources.TestData;
import resources.Utils;

import static io.restassured.RestAssured.*;
import static org.junit.Assert.*;

public class BooksAPI extends Utils
{
	RequestSpecification req;
	Response res;
	TestData data=new TestData();
	@Given("Add book api payload with {string} {string} {string} {string}")
	public void add_book_api_payload_with(String name, String isbn, String aisle, String author) throws IOException
	{
	  req=given().spec(requestSpecBuilder()).body(data.addBookPayload(name,isbn,aisle+(int)Math.random()*10,author));
	}

	@When("The user executes {string} with {string} request")
	public void the_user_executes_with_request(String resource, String method) 
	{
		APIResources endpoint=APIResources.valueOf(resource);
		if(method.equalsIgnoreCase("POST"))
	    res= req.when().post(endpoint.getResource()).then().extract().response();
		
	}

	@Then("the user is returned with status code {int}")
	public void the_user_is_returned_with_status_code(int statusCode) 
	{
		assertEquals(res.getStatusCode(), statusCode);
	}

	@Then("the {string} in response body is {string}")
	public void the_in_response_body_is(String key, String value)
	{
	    String actualValue=(String) getJSONValue(res, key);
	    assertEquals(value, actualValue);
	}
	
	@Given("Delete book api payload")
	public void delete_book_api_payload() throws IOException 
	{
	   add_book_api_payload_with("Fordelete", "fd"+Math.random(), "1", "manish");
	   the_user_executes_with_request("AddBookAPI", "POST");
	   String idForDelete=(String) getJSONValue(res, "ID");
	   req=given().spec(requestSpecBuilder()).body(data.deleteBookPayload(idForDelete));
	}

}
