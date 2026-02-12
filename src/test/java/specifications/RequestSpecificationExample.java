package specifications;

import java.util.HashMap;
import java.util.Map;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.specification.RequestSpecification;

public class RequestSpecificationExample {
	
	RequestSpecification requestSpecification;
	
	@BeforeClass
	public void setupRequestSpecification() {
		requestSpecification = RestAssured.given();
		requestSpecification
						.log()
						.all()
						.baseUri("https://restful-booker.herokuapp.com/")
						.contentType(ContentType.JSON);
	}
	
	@Test
	public void createBooking() {
		Map<String, Object> map = new HashMap<>();
		map.put("name", "Alok");
		map.put("Age", 30);
		
		RestAssured
		.given()
		.basePath("booking")
		.spec(requestSpecification)
		.body(map)
		.when()
		.post()
		.then()
		.log()
		.all()
		.statusCode(200);
	}
	
	@Test
	public void UpdateBooking() {
		Map<String, Object> map = new HashMap<>();
		map.put("name", "Alok Barman");
		map.put("Age", 30);
		
		RestAssured
				.given()
				.basePath("booking/1")
				.header("Content-Type", "application/json")
				.header("Authorization", "Basic abcdefghijklmnopqrstuvwxyz")
				.body(map)
				.when()
				.put()
				.then()
				.log()
				.all()
				.statusCode(200);
	}

}
