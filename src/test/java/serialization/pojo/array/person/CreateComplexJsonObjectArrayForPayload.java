package serialization.pojo.array.person;

import java.util.ArrayList;
import java.util.List;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;

public class CreateComplexJsonObjectArrayForPayload {

	public static void main(String[] args) {
		
		Person person = new Person();
		person.setId(1);
		person.setFirst_name("Alok");
		person.setLast_name("Barman");
		person.setProfession("Software Engineer");
		
		Address address1 = new Address();
		address1.setHouseNo(3);
		address1.setStreetName("Marshall Street");
		address1.setCity("Irvington");
		address1.setState("Irvington");
		address1.setCountry("USA");
		
		Address address2 = new Address();
		address2.setHouseNo(6723);
		address2.setStreetName("47th Avenue");
		address2.setCity("Woodside");
		address2.setState("NY");
		address2.setCountry("USA");
		
		List<Address> allAddresses = new ArrayList<>();
		allAddresses.add(address1);
		allAddresses.add(address2);
		
		person.setAddress(allAddresses);
		
		RestAssured.given()
				//.baseUri("").basePath("")
				.log().all().body(person).contentType(ContentType.JSON).when().post();
		
	}

}
