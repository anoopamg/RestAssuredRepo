package restAPI;

import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class PostRequest {
	@Test
	public void createEmployee() {

		RestAssured.baseURI = "http://localhost:3000/employees";
		RequestSpecification request = RestAssured.given();
		Response response = request.contentType(ContentType.JSON)
				.accept(ContentType.JSON)
				.body("{\r\n"
						+ "    \"name\": \"Tom\",\r\n"
						+ "    \"salary\": \"12000\"\r\n"
						+ "}")
				.post("/create");
		
		System.out.println("Response code is :"+response.statusCode());
		System.out.println("Response header is :"+response.getHeader("Content-Type"));
		System.out.println("Response code is :"+response.getHeaders().asList());
		
		Assert.assertEquals(response.getStatusCode(), 201);
	}

}
