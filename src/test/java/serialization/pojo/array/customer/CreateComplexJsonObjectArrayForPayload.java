package serialization.pojo.array.customer;

import java.util.ArrayList;
import java.util.List;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;

public class CreateComplexJsonObjectArrayForPayload {

	public static void main(String[] args) {
		
		Customer customer1 = new Customer();
		customer1.setAccountNo(319848869);
		customer1.setBalance(1111.11);
		customer1.setFirst_name("Alok");
		customer1.setLast_name("Barman");
		customer1.setEmail("test@abc.com");
		
		Customer customer2 = new Customer();
		customer2.setAccountNo(889968900);
		customer2.setBalance(2222.22);
		customer2.setFirst_name("Nrityam");
		customer2.setLast_name("Barman");
		customer2.setEmail("test1@abc.com");
		
		List<Object> customerObjectList = new ArrayList<Object>();
		customerObjectList.add(customer1);
		customerObjectList.add(customer2);
		
		RestAssured.given()
				//.baseUri("").basePath("")
				.log().all().body(customerObjectList).contentType(ContentType.JSON).when().post();
		
	}

}
