package tests.main;

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
	}
}
