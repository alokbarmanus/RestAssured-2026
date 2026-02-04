package mockdata;

import io.restassured.RestAssured;

public class MockyDemo {

	public static void main(String[] args) {
		//https://mocki.io/fake-json-api
		RestAssured
				.given()
				.log()
				.all()
				.when()
				.get("https://mocki.io/v1/76a42333-cabf-4e7a-9ffc-8ba664150511")
				.then()
				.log()
				.all();
	}
}
