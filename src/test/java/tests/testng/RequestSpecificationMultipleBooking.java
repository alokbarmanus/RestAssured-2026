package tests.testng;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.specification.RequestSpecification;

public class RequestSpecificationMultipleBooking {
	
	RequestSpecification requestSpecification;
	
	@BeforeMethod
	public void setupRequestSpecification() {
		requestSpecification = RestAssured.given()
												.log()
												.all()
												.baseUri("https://restful-booker.herokuapp.com/")
												.contentType(ContentType.JSON);
	}
	
	@Test
	public void createBooking() {
		//Build Request
		RestAssured.given()
						.spec(requestSpecification)
						.basePath("booking")
						.body("{\r\n"
								+ "    \"firstname\" : \"Alok\",\r\n"
								+ "    \"lastname\" : \"Barman\",\r\n"
								+ "    \"totalprice\" : 111,\r\n"
								+ "    \"depositpaid\" : true,\r\n"
								+ "    \"bookingdates\" : {\r\n"
								+ "        \"checkin\" : \"2024-01-01\",\r\n"
								+ "        \"checkout\" : \"2024-01-01\"\r\n"
								+ "    },\r\n"
								+ "    \"additionalneeds\" : \"Breakfast\"\r\n"
								+ "}")
		//Send request
					.when()
						.post()
		//Validate response
					.then()
						.log()
						.all()
						.assertThat()
						.statusCode(200);
	}
	@Test
	public void updateBooking() {
		RestAssured.given()
			.spec(requestSpecification)
			.basePath("booking/1")
			.header("Content-Type", "application/json")
			.header("Authorization", "Basic YWRtaW46cGFzc3dvcmQxMjM=")
			.body("{\r\n"
					+ "    \"firstname\": \"Alok1\",\r\n"
					+ "    \"lastname\": \"Barman\",\r\n"
					+ "    \"totalprice\": 222,\r\n"
					+ "    \"depositpaid\": true,\r\n"
					+ "    \"bookingdates\": {\r\n"
					+ "        \"checkin\": \"2026-01-01\",\r\n"
					+ "        \"checkout\": \"2026-01-26\"\r\n"
					+ "    },\r\n"
					+ "    \"additionalneeds\": \"Dinner\"\r\n"
					+ "}")
		.when()
			.put()
		.then()
			.log()
			.all()
			.assertThat()
			.statusCode(200);
	}
}
