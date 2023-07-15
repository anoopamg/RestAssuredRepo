package restAPI;

import java.util.HashMap;

import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class PostRequestWithMap {
	@Test
	public void createEmployeeUsingMap() {

		HashMap<String,Object> requestBody = new HashMap<String,Object>();
		requestBody.put("name", "Mike");
		requestBody.put("salary","8000");
		
		RestAssured.baseURI = "http://localhost:3000/employees";
		RequestSpecification request = RestAssured.given();
		Response response = request.contentType(ContentType.JSON)
								   .accept(ContentType.JSON)
								   .body(requestBody)
								   .post("/create");

		System.out.println("Response code is :" + response.statusCode());
		System.out.println("Response header is :" + response.getHeader("Content-Type"));
		System.out.println("Response code is :" + response.getHeaders().asList());

		Assert.assertEquals(response.getStatusCode(), 201);
	}

}
