package tests.main;

import io.restassured.RestAssured;

public class GetMultipleParameters {

	public static void main(String[] args) {
		//https://restful-booker.herokuapp.com/booking/:id
		RestAssured.given()
						.log()
						.all()
						.baseUri("https://restful-booker.herokuapp.com/")
						.basePath("{basePath}/{bookingId}")
						.pathParam("basePath", "booking")
						.pathParam("bookingId", "2")
					.when()
						.get()
					.then()
					.log()
					.all()
					.assertThat()
					.statusCode(200);
						
	}
}
