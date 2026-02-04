package tests.main;

import java.util.HashMap;
import java.util.Map;

import io.restassured.RestAssured;

public class GetMultipleParametersMap {

	public static void main(String[] args) {
		//https://restful-booker.herokuapp.com/booking/:id
		
		Map<String, Object> pathParameters = new HashMap<String, Object>();
		pathParameters.put("basePath", "booking");
		pathParameters.put("bookingId", "2");
		
		RestAssured.given()
						.log()
						.all()
						.baseUri("https://restful-booker.herokuapp.com/")
						.basePath("{basePath}/{bookingId}")
						.pathParams(pathParameters)
					.when()
						.get()
					.then()
					.log()
					.all()
					.assertThat()
					.statusCode(200);
						
	}
}
