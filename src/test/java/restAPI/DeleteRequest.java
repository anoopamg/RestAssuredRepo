package restAPI;

import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class DeleteRequest {
	
	@Test
	public void deleteRequest() {
		RestAssured.baseURI = "http://localhost:3000/employees";
		RequestSpecification request = RestAssured.given();
		Response response = request.delete("/2");
		
		System.out.println("Response body is :"+response.getBody().asString());
		System.out.println("Response code is :" + response.statusCode());
		System.out.println("Response header is :" + response.getHeader("Content-Type"));
		System.out.println("Response code is :" + response.getHeaders().asList());

		Assert.assertEquals(response.getStatusCode(), 200);
	}

}
