package tests.main;

import io.restassured.RestAssured;

public class GetBookingByIdChaining {

	public static void main(String[] args) {
		
		RestAssured.given()
						.baseUri("https://restful-booker.herokuapp.com/")
						.basePath("booking/{id}")
						.pathParam("id", 1)
					.when()
						.log()
						.all()
						.get()
					.then()
						.log()
						.all()
						.statusCode(200);
	}
}
