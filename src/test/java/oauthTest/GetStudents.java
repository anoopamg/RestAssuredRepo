package oauthTest;

import java.util.HashMap;

import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.response.Response;

public class GetStudents {

	String accessToken = GetToken.getAccessToken();

	@Test
	public void getAllEmployeesTest() {

		/*------------------------Get Students using oauth -----------------*/
		Response response = RestAssured.given()
					.baseUri("http://localhost:8088")
					.auth()
					.oauth2(accessToken)
					.when()
					.get("/students");
		
	 	Assert.assertEquals(response.getStatusCode(),200);
	 	String logResponse = response.body().asString();
	 	System.out.println(logResponse);
	 	
	}
	
	@Test
	public void getAllEmployeesTest1() {
	 	/*------------------------Get Students using headers -----------------*/
	 	HashMap<String,Object> headers = new HashMap<String,Object>();
	 	headers.put("Authorization","Bearer"+accessToken);
	 	
		Response response1 = RestAssured.given()
					.baseUri("http://localhost:8088")
					.auth()
					.oauth2(accessToken)
					.when()
					.get("/students");
		
	 	Assert.assertEquals(response1.getStatusCode(),200);
	 	String logResponse1 = response1.body().asString();
	 	System.out.println(logResponse1);
	 }
}
