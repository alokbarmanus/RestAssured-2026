package deserialization.pojo.object.person.partOfJson;

import io.restassured.RestAssured;
import io.restassured.response.Response;

public class ConvertAPartOfJsonObjectResponseToPojo {

	public static void main(String[] args) {
		
		Response response = RestAssured
		.given()
		.log()
		.all()
		.when()
		.log()
		.all()
		.get("https://mocki.io/v1/65e016f7-cb5b-46bf-8836-52bcd7397f80");
		
		Address responseAddressAsMap = response.jsonPath().getObject("address", Address.class);
		
		System.out.println(responseAddressAsMap.getHouseNo());
		System.out.println(responseAddressAsMap.getStreetName());
		System.out.println(responseAddressAsMap.getCity());
		System.out.println(responseAddressAsMap.getState());
		System.out.println(responseAddressAsMap.getCountry());
	}
}
