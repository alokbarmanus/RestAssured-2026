package lombok;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import io.restassured.RestAssured;
import io.restassured.response.Response;

public class DeserializationExampleUsingGetterSetterAnnotation {

	public static void main(String[] args) {
//		String response = "{\r\n"
//				+ "  \"id\": 1,\r\n"
//				+ "  \"first_name\": \"Alok\",\r\n"
//				+ "  \"last_name\": \"Barman\",\r\n"
//				+ "  \"married\": true\r\n"
//				+ "}";
		ObjectMapper objectMapper = new ObjectMapper();
		Response response = RestAssured.given().log().all().when().get();
		
		
		// 1st process
		String jsonResponse = response.getBody().asString();
		try {
			EmployeePojoUsingGetterSetterAnnotation object =objectMapper.readValue(jsonResponse, EmployeePojoUsingGetterSetterAnnotation.class);
			System.out.println(object.getId());
			System.out.println(object.getFirst_name());
			System.out.println(object.getLast_name());
			System.out.println(object.isMarried());
		} catch (JsonProcessingException e) {
			
			e.printStackTrace();
		}
		
		// 2nd process
		EmployeePojoUsingGetterSetterAnnotation obj =response.as(EmployeePojoUsingGetterSetterAnnotation.class);
		System.out.println(obj.getId());
		System.out.println(obj.getFirst_name());
		System.out.println(obj.getLast_name());
		System.out.println(obj.isMarried());
	}
}
