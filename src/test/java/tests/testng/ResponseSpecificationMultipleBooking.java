package tests.testng;

import org.hamcrest.Matchers;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;

public class ResponseSpecificationMultipleBooking {
	
	RequestSpecification requestSpecification;
	ResponseSpecification responseSpecification;
	
	@BeforeClass
	public void setupRequestSpecification() {
		requestSpecification = RestAssured.given()
												.log()
												.all()
												.baseUri("https://restful-booker.herokuapp.com/")
												.contentType(ContentType.JSON);
		responseSpecification = RestAssured.expect()
												.statusCode(200)
												.contentType(ContentType.JSON)
												.time(Matchers.lessThan(5000L));
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
						.spec(responseSpecification);
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
			.spec(responseSpecification);
	}
}
