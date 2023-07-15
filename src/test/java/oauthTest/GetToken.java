package oauthTest;

import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;

public class GetToken {

	public static String getAccessToken() {
	//public static void main(String[] args) {
		Response response = RestAssured.given()
							.baseUri("http://localhost:8088")
							.auth()
							.basic("rest-assured","password")
							.contentType("application/x-www-form-urlencoded")
							.formParam("grant_type", "password")
							.formParam("username","onlyfullstack")
							.formParam("password","secret")
							.when()
							.post("/oauth/token");
		
		JsonPath jpath = response.jsonPath();
		String token = jpath.get("access_token");
		System.out.println("Access token created is " +token);
		return token;
	}
}
