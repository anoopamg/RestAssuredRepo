package restAPI;

import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class PutRequest {
	
	@Test
	public void updateRequest() {
		RestAssured.baseURI = "http://localhost:3000/employees";
		RequestSpecification request = RestAssured.given();
		Response response = request.contentType(ContentType.JSON)
								   .accept(ContentType.JSON)
								   .body("{\r\n"
								   		+ "    \"name\": \"Joe\",\r\n"
								   		+ "    \"salary\": \"5000\"\r\n"
								   		+ "}")
								   .put("/5");

		System.out.println("Response body is :"+response.getBody().asString());
		System.out.println("Response code is :" + response.statusCode());
		System.out.println("Response header is :" + response.getHeader("Content-Type"));
		System.out.println("Response code is :" + response.getHeaders().asList());

		Assert.assertEquals(response.getStatusCode(), 200);

	}

}
