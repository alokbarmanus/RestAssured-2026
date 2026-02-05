package serialization.pojo.object.person;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import serialization.pojo.array.person.Address;

public class CreateComplexJsonObjectForPayload {

	public static void main(String[] args) {
		Person person = new Person();
		person.setId(1);
		person.setFirst_name("Alok");
		person.setLast_name("Barman");
		person.setProfession("Software Engineer");
		
		Address address = new Address();
		address.setHouseNo(3);
		address.setStreetName("Marshall Street");
		address.setCity("Irvington");
		address.setState("Irvington");
		address.setCountry("USA");
		
		person.setAddress(address);
		
		
		RestAssured.given()
				//.baseUri("").basePath("")
				.log().all().body(person).contentType(ContentType.JSON).when().post();
		
		
	}

}
