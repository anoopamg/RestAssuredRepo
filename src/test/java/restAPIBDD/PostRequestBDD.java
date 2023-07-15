package restAPIBDD;

import org.hamcrest.Matchers;
import org.json.JSONObject;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;

public class PostRequestBDD {

	@Test
	public void addEmployeeTest() {

		JSONObject jobj = new JSONObject();
		jobj.put("name", "Twinkle");
		jobj.put("salary", "17000");

		RestAssured.given().baseUri("http://localhost:3000/employees")
							.contentType(ContentType.JSON)
							.accept(ContentType.JSON).body(jobj.toString())
							.when().post("/create")
							.then()
							.log().all()
							.statusCode(201)
							.body("name", Matchers.equalTo("Twinkle"));

	}

}
