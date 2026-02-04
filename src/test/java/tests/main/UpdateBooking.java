package tests.main;

import io.restassured.RestAssured;

public class UpdateBooking {

	public static void main(String[] args) {
		
		RestAssured.given()
						.baseUri("https://restful-booker.herokuapp.com/")
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
						.log()
						.all()
						.put()
					.then()
						.log()
						.all()
						.assertThat()
						.statusCode(200);
						
	}
}
