package restAPIBDD;

import java.util.List;

import org.hamcrest.Matchers;
import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;

public class GetRequestBDD {
	
	@Test
	public void getAllEmployeesTest() {
	
		RestAssured.given()
					.baseUri("http://localhost:3000/employees")
					.when()
					.get()
					.then()
					.log().body()
					.statusCode(200);
	}
	
	@Test
	public void getSingleEmployeeTest() {
		RestAssured.given()
					.baseUri("http://localhost:3000/employees")
					.when()
					.get("/9")
					.then()
					.log().all()
					.statusCode(200)
					.body("name",Matchers.equalTo("John"));
					
	}
	
	@Test
	public void getSingleEmployeeTest2() {
		Response response = RestAssured.given()
							.baseUri("http://localhost:3000/employees")
							.when()
							.get("/1");
		
		Assert.assertEquals(response.statusCode(),200);
					
	}
	@Test
	public void getSingleEmployeeTest3() {
		Response response = RestAssured.given()
							.baseUri("http://localhost:3000/employees")
							.when()
							.get();
		
		Assert.assertEquals(response.statusCode(),200);
						
		JsonPath json = response.jsonPath();
		List<String> names = json.get("name");
		List<Integer> empIds = json.get("id");
		
		for(int i = 0;i<empIds.size();i++) {
			if(names.get(i).contains("Mike"))
			{
				System.out.println("Emp Id of "+names.get(i)+" is :"+empIds.get(i));
			}
		}
	}
}
