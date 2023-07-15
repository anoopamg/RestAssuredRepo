package restAPI;

import java.util.List;

import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class GetNamesOfAllEmployees {
	
	@Test
	public void getNames() {
		
		RestAssured.baseURI="http://localhost:3000/employees";
		RequestSpecification request = RestAssured.given();
		Response response = request.get();
		
		JsonPath json = response.jsonPath();
		List<String> names = json.get("name");
		
		System.out.println("Name of employees are :");
		for(String name: names)
		{
			System.out.println(name +"\n");
		}
	}

}
