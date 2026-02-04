package tests.main;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;

public class CreateBookingChaining {

	public static void main(String[] args) {
		//Build Request
		RestAssured.given()
						.baseUri("https://restful-booker.herokuapp.com/")
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
						.contentType(ContentType.JSON)
		//Send request
					.when()
						.log()
						.all()
						.post()
		
		//Validate response
					.then()
						.log()
						.all()
						.statusCode(200);
	}
}
