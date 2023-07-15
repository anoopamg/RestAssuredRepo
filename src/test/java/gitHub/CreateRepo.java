package gitHub;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class CreateRepo {
	@Test
	public void addRepoTest() throws IOException {
		byte[] dataFile = Files.readAllBytes(Paths.get("gitHubRepoData.json"));
		
		String gitHubToken = "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";
		
		RestAssured.baseURI = "https://api.github.com/user/repos";
		RequestSpecification request = RestAssured.given();
		Response response = request.auth().oauth2(gitHubToken)
				.contentType(ContentType.JSON)
				.accept(ContentType.JSON)
				.body(dataFile).post();

		System.out.println("Response body is :" + response.getBody().asString());
		System.out.println("Response code is :" + response.statusCode());
		System.out.println("Response header is :" + response.getHeader("Content-Type"));
		System.out.println("Response code is :" + response.getHeaders().asList());

		Assert.assertEquals(response.getStatusCode(), 201);
	}

}
