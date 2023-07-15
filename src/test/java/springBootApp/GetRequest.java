package springBootApp;


import java.util.List;

import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class GetRequest {
	
	@Test
	public void getEmployees() {
		RestAssured.baseURI="http://localhost:8088/employees";
		RequestSpecification request = RestAssured.given();
		Response response = request.get();
		
		JsonPath json = response.jsonPath();
		List<String> names = json.get("firstName");
		
		System.out.println("Name of employees are :");
		for(String name: names)
		{
			System.out.println(name +"\n");
		}
		
	}

}
