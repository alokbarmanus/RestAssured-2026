package tests.main;

import java.util.concurrent.TimeUnit;

import org.hamcrest.Matchers;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;

public class ResponseTimeMethods {

	public static void main(String[] args) {
		//Build Request
		Response response = RestAssured.given()
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
						.post();
		
		//Validate response
		long responseTimeInMiliSec = response.time();
		System.out.println(responseTimeInMiliSec);
		long responseTimeInSec = response.timeIn(TimeUnit.SECONDS);
		System.out.println(responseTimeInSec);
		
		long responseTimeInMiliSec2 = response.getTime();
		System.out.println(responseTimeInMiliSec2);
		long responseTimeInSec2 = response.getTimeIn(TimeUnit.SECONDS);
		System.out.println(responseTimeInSec2);
		
		response.then().time(Matchers.lessThan(5000L));
		response.then().time(Matchers.greaterThan(2000L));
		response.then().time(Matchers.both(Matchers.greaterThan(2000L)).and(Matchers.lessThan(5000L)));
		response.then().time(Matchers.lessThan(2L), TimeUnit.SECONDS);
	}

}
