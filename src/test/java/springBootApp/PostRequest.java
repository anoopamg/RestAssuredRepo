package springBootApp;

import java.util.HashMap;

import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class PostRequest {

	@Test
	public void createEmployee() {
		HashMap<String,Object> requestBody = new HashMap<String,Object>();
		requestBody.put("firstName", "Laya");
		requestBody.put("lastName","Thomas");
		requestBody.put("salary","18000");
		requestBody.put("email","laya.thomas@abc.com");
		
		RestAssured.baseURI = "http://localhost:8088/employees";
		RequestSpecification request = RestAssured.given();
		Response response = request.contentType(ContentType.JSON)
								   .accept(ContentType.JSON)
								   .body(requestBody)
								   .post();

		System.out.println("Response code is :" + response.statusCode());
		System.out.println("Response header is :" + response.getHeader("Content-Type"));
		System.out.println("Response code is :" + response.getHeaders().asList());
		System.out.println("All employees :"+response.getBody().asString());

		Assert.assertEquals(response.getStatusCode(), 201);
	}
}
