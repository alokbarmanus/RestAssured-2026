package deserialization.pojo.array.person;

import java.util.List;

import io.restassured.RestAssured;
import io.restassured.response.Response;

public class ConvertComplexJsonObjectInnerArrayResponseToPojo {

	public static void main(String[] args) {
		Response response = RestAssured
				.given()
				.log()
				.all()
				.get("https://mocki.io/v1/92391b2e-423d-4167-b2e2-190019cfb14b");
		Person personResponseAsObject = response.as(Person.class);
		
		System.out.println(personResponseAsObject.getId());
		System.out.println(personResponseAsObject.getFirst_name());
		System.out.println(personResponseAsObject.getLast_name());
		System.out.println(personResponseAsObject.getProfession());
		//System.out.println(personResponseAsObject.getAddress());
		
		List<Address> addressLists = personResponseAsObject.getAddress();
		System.out.println(addressLists.get(0).getHouseNo());
		System.out.println(addressLists.get(0).getStreetName());
		System.out.println(addressLists.get(0).getCity());
		System.out.println(addressLists.get(0).getState());
		System.out.println(addressLists.get(0).getCountry());
		
		System.out.println(addressLists.get(1).getHouseNo());
		System.out.println(addressLists.get(1).getStreetName());
		System.out.println(addressLists.get(1).getCity());
		System.out.println(addressLists.get(1).getState());
		System.out.println(addressLists.get(1).getCountry());
	}
}
