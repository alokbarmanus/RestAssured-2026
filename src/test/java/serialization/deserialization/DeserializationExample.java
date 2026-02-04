package serialization.deserialization;

import java.util.Map;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import lombok.EmployeePojoUsingGetterSetterAnnotation;

public class DeserializationExample {

	public static void main(String[] args) {
		// JSON Response (JSON object) convert into Java Object (POJO) is called Serialization
		// POJO class EmployeePojo
		String jsonResponse = "{\r\n"
				+ "  \"id\": 1,\r\n"
				+ "  \"first_name\": \"Alok\",\r\n"
				+ "  \"last_name\": \"Barman\",\r\n"
				+ "  \"married\": true\r\n"
				+ "}";
		
		ObjectMapper objectMapper = new ObjectMapper();
		try {
			EmployeePojo employeePojo = objectMapper.readValue(jsonResponse, EmployeePojo.class);
			System.out.println(employeePojo.getId());
			System.out.println(employeePojo.getFirst_name());
			System.out.println(employeePojo.getLast_name());
			System.out.println(employeePojo.isMarried());
		} catch (JsonProcessingException e) {
			e.printStackTrace();
		}
		
		// Another way to extract value
//		try {
//			Map<String, Object> employeeAsMap = objectMapper.readValue(jsonResponse, Map.class);
//			System.out.println(employeeAsMap.get("id"));
//			System.out.println(employeeAsMap.get("first_name"));
//			System.out.println(employeeAsMap.get("last_name"));
//			System.out.println(employeeAsMap.get("married"));
//		} catch (JsonProcessingException e) {
//			e.printStackTrace();
//		}
		
		
		// Another way to extract value
		try {
			Map<String, Object> employeeAsMap = objectMapper.readValue(jsonResponse, new TypeReference<Map<String, Object>>() {});
			System.out.println(employeeAsMap.get("id"));
			System.out.println(employeeAsMap.get("first_name"));
			System.out.println(employeeAsMap.get("last_name"));
			System.out.println(employeeAsMap.get("married"));
		} catch (JsonProcessingException e) {
			e.printStackTrace();
		}
		
		//=============using RestAssured==================================
		
		Response response = RestAssured.given().log().all().body(jsonResponse).when().get();
		// 1st process
		String jsonResponse1 = response.getBody().asString();
		try {
			EmployeePojoUsingGetterSetterAnnotation object =objectMapper.readValue(jsonResponse1, EmployeePojoUsingGetterSetterAnnotation.class);
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
