package serialization.deserialization;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import io.restassured.RestAssured;

public class SerializationExample {

	public static void main(String[] args) {
		// Convert Java Object (POJO) into JSON object for Payload is called Serialization
		// POJO class EmployeePojo
		EmployeePojo employeePojo = new EmployeePojo();
		employeePojo.setId(1);
		employeePojo.setFirst_name("Alok");
		employeePojo.setLast_name("Barman");
		employeePojo.setMarried(true);
		
		ObjectMapper objectMapper = new ObjectMapper();
		try {
			String jsonString = objectMapper.writerWithDefaultPrettyPrinter().writeValueAsString(employeePojo);
			System.out.println(jsonString);
		} catch (JsonProcessingException e) {
			e.printStackTrace();
		}
		//RestAssured convert itself
		RestAssured.given().log().all().body(employeePojo).get();
	}

}
