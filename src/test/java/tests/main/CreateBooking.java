package tests.main;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.response.ValidatableResponse;
import io.restassured.specification.RequestSpecification;

public class CreateBooking {

	public static void main(String[] args) {
		//Build Request
		RequestSpecification requestSpecification = RestAssured.given();
		requestSpecification.baseUri("https://restful-booker.herokuapp.com/");
		requestSpecification.basePath("booking");
		requestSpecification.body("{\r\n"
				+ "    \"firstname\" : \"Alok1\",\r\n"
				+ "    \"lastname\" : \"Barman\",\r\n"
				+ "    \"totalprice\" : 111,\r\n"
				+ "    \"depositpaid\" : true,\r\n"
				+ "    \"bookingdates\" : {\r\n"
				+ "        \"checkin\" : \"2024-01-01\",\r\n"
				+ "        \"checkout\" : \"2024-01-01\"\r\n"
				+ "    },\r\n"
				+ "    \"additionalneeds\" : \"Breakfast\"\r\n"
				+ "}");
		requestSpecification.contentType(ContentType.JSON);
		//Send request
		System.out.println("=============== when started====================");
		requestSpecification.when();
		requestSpecification.log().all();
		Response response = requestSpecification.post();
		
		//Validate response
		System.out.println("=============== Then started====================");
		ValidatableResponse validatableResponse = response.then().log().all();
		validatableResponse.statusCode(200);
	}
}
