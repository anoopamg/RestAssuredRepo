package restAPI;


import org.json.JSONObject;
import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class PostRequestWithJSONObject {
	@Test
	public void createEmployeeUsingJSONObj() {

		JSONObject jobj = new JSONObject();
		jobj.put("name", "Tina");
		jobj.put("salary","7000");
		
		RestAssured.baseURI = "http://localhost:3000/employees";
		RequestSpecification request = RestAssured.given();
		Response response = request.contentType(ContentType.JSON)
								   .accept(ContentType.JSON)
								   .body(jobj.toString())
								   .post("/create");

		System.out.println("Response body is :"+response.getBody().asString());
		System.out.println("Response code is :" + response.statusCode());
		System.out.println("Response header is :" + response.getHeader("Content-Type"));
		System.out.println("Response code is :" + response.getHeaders().asList());

		Assert.assertEquals(response.getStatusCode(), 201);
	}

}
