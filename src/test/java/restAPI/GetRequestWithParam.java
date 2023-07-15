package restAPI;

import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class GetRequestWithParam {
	@Test
	public void test1() {
		
		RestAssured.baseURI="http://localhost:3000/employees";
		RequestSpecification request = RestAssured.given();
		Response response = request.get("/1");
		String responseBody = response.getBody().asString();
		
		System.out.println("Response body is :"+responseBody);
		System.out.println("Response code is :"+response.statusCode());
		System.out.println("Response header is :"+response.getHeader("Content-Type"));
		System.out.println("Response code is :"+response.getHeaders().asList());
		
		Assert.assertEquals(response.getStatusCode(), 200);
		Assert.assertTrue(responseBody.contains("Pankaj"));
		
		JsonPath json = response.jsonPath();
		Assert.assertEquals(json.get("name"), "Pankaj");
	}

}
