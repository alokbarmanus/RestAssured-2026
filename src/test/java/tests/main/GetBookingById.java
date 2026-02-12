package tests.main;

import java.io.File;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.response.ValidatableResponse;
import io.restassured.specification.RequestSpecification;

public class GetBookingById {

	public static void main(String[] args) {
		RequestSpecification restARequestSpecification = RestAssured.given();
		restARequestSpecification.baseUri("https://restful-booker.herokuapp.com/");
		restARequestSpecification.basePath("booking/{id}");
		restARequestSpecification.pathParam("id", 478);
		restARequestSpecification.when().log().all();
		Response response = restARequestSpecification.get();
		ValidatableResponse validatableResponse = response.then().log().all();
		validatableResponse.statusCode(200);
		
		RestAssured.given().baseUri("https://restful-booker.herokuapp.com/").when().get("booking/{id}").then().statusCode(200);
	RestAssured.given()
				.auth().basic("username", "password")
				.get("https://restful-booker.herokuapp.com/booking/1")
				.then()
				.statusCode(200);
	String updatedBody = "{\"name\":\"Alok Updated\"}";
	RestAssured.given().body(updatedBody)
	.put("/update")
	.then().statusCode(200);
	
	RestAssured.given().multiPart("file", new File("path/to/file")).post("/upload");
	
	assert response.path("key").equals("expectedValue");
	
	}
}
