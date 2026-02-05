package deserialization.pojo.object.person;

import io.restassured.RestAssured;
import io.restassured.response.Response;

public class ConvertComplexJsonObjectResponseToPojo {

	public static void main(String[] args) {
		Response response = RestAssured
		.given()
		.log()
		.all()
		.when()
		.log()
		.all()
		.get("https://mocki.io/v1/65e016f7-cb5b-46bf-8836-52bcd7397f80");
		
		Person responseAsMap = response.as(Person.class);
		
		System.out.println(responseAsMap.getId());
		System.out.println(responseAsMap.getFirst_name());
		System.out.println(responseAsMap.getLast_name());
		System.out.println(responseAsMap.getProfession());
		System.out.println(responseAsMap.getAddress());
		Address address = (Address) responseAsMap.getAddress();
		System.out.println(address.getHouseNo());
		System.out.println(address.getStreetName());
		System.out.println(address.getCity());
		System.out.println(address.getState());
		System.out.println(address.getCountry());
	}
}
