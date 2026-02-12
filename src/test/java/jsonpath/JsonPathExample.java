package jsonpath;

import org.testng.annotations.Test;

import io.restassured.path.json.JsonPath;

public class JsonPathExample {

	@Test
	public void jesonPathTest() {
		String json = "{\r\n"
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
				+ "}";
		
		JsonPath jsonPath = new JsonPath(json);
		int bookingId = jsonPath.get("bookingid");
		System.out.println(bookingId);
		String additionalneeds = jsonPath.get("additionalneeds");
		System.out.println(additionalneeds);
		String firstname = jsonPath.get("booking.firstname");
		System.out.println(firstname);
		String checkin = jsonPath.get("booking.bookingdates.checkin");
		System.out.println(checkin);
	}
}
