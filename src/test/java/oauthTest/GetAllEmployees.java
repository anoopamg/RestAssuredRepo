package oauthTest;

import org.testng.annotations.Test;

import io.restassured.RestAssured;

public class GetAllEmployees {
	
	String accessToken = GetToken.getAccessToken();
	
	@Test
	public void getAllEmployeesTest() {
	
		RestAssured.given()
					.baseUri("http://localhost:8088")
					.auth()
					.oauth2(accessToken)
					.when()
					.get("/employees")
					.then()
					.log().body()
					.statusCode(200);
	}

}
