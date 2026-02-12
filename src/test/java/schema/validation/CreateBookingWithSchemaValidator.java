package schema.validation;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.module.jsv.JsonSchemaValidator;

public class CreateBookingWithSchemaValidator {

	public static void main(String[] args) {
		RestAssured
				.given()
				.log()
				.all()
				.baseUri("https://restful-booker.herokuapp.com/")
				.basePath("booking")
				.body("{\r\n"
						+ "  \"bookingid\": 1,\r\n"
						+ "  \"booking\": {\r\n"
						+ "    \"firstname\": \"Jim\",\r\n"
						+ "    \"lastname\": \"Brown\",\r\n"
						+ "    \"totalprice\": 111,\r\n"
						+ "    \"depositpaid\": true,\r\n"
						+ "    \"bookingdates\": {\r\n"
						+ "      \"checkin\": \"2018-01-01\",\r\n"
						+ "      \"checkout\": \"2019-01-01\"\r\n"
						+ "    }\r\n"
						+ "  },\r\n"
						+ "  \"additionalneeds\": \"Breakfast\"\r\n"
						+ "}")
				.contentType(ContentType.JSON)
				.post()
				.then()
				.log()
				.all()
				.body(JsonSchemaValidator.matchesJsonSchemaInClasspath("CreateBookingResponseSchema.json"));
	}

}
