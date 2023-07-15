package restAPIWithXML;

import org.testng.annotations.Test;
import io.restassured.RestAssured;
import io.restassured.internal.path.xml.NodeChildrenImpl;
import io.restassured.response.Response;

public class XMLTest {
	
	@Test
	public void xmlTest() {
		RestAssured.given().baseUri("https://chercher.tech/sample/api/books.xml")
		.when()
		.get()
		.then()
		.log().all()
		.statusCode(200);
	}
	
	@Test
	public void xmlTest1() {
		Response response = RestAssured.given().baseUri("https://chercher.tech/sample/api/books.xml")
		.when()
		.get();
		NodeChildrenImpl books = response.then().extract().path("bookstore.book.title");
		
		System.out.println("All books are : "+books.toString());
		System.out.println("First book : "+books.get(0).toString());
		System.out.println("Second book : "+books.get(1).toString());
		
	}

}
