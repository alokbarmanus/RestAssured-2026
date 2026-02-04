package tests.main;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;

public class PartialUpdateBooking {

	public static void main(String[] args) {
		//https://restful-booker.herokuapp.com/booking/:id
		RestAssured.given()
						.baseUri("https://restful-booker.herokuapp.com/")
						.basePath("booking/1108")
						.header("Content-Type", "application/json")
						.header("Authorization", "Basic YWRtaW46cGFzc3dvcmQxMjM=")
						.contentType(ContentType.JSON)
						.body("{\r\n"
								+ "    \"firstname\" : \"Alok123\",\r\n"
								+ "    \"lastname\" : \"Barman456\"\r\n"
								+ "}")
					.when()
						.log()
						.all()
						.patch()
					.then()
						.log()
						.all()
						.assertThat()
						.statusCode(200);
						
	}
}
