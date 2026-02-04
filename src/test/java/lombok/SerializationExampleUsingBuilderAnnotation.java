package lombok;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;

public class SerializationExampleUsingBuilderAnnotation {

	public static void main(String[] args) {
		EmployeePojoUsingBuilderAnnotation employeePojoUsingBuilderAnnotation = 
				EmployeePojoUsingBuilderAnnotation.builder()
						.id(3)
						.first_name("Alok")
						.last_name("Barman")
						.married(true)
						.build();
		
		ObjectMapper objectMapper = new ObjectMapper();
		try {
			String jsonString = objectMapper.writerWithDefaultPrettyPrinter().writeValueAsString(employeePojoUsingBuilderAnnotation);
			System.out.println(jsonString);
		} catch (JsonProcessingException e) {
			e.printStackTrace();
		}
		//To edit it or for reusable this code.
		EmployeePojoUsingBuilderAnnotation employeePojoUsingBuilderAnnotationUpdated = 
				employeePojoUsingBuilderAnnotation.toBuilder()
						.first_name("Kumar")
						.build();
		try {
			String jsonString2 = objectMapper.writerWithDefaultPrettyPrinter().writeValueAsString(employeePojoUsingBuilderAnnotationUpdated);
			System.out.println(jsonString2);
		} catch (JsonProcessingException e) {
			e.printStackTrace();
		}
		
		
		RestAssured.given().log().all().body(employeePojoUsingBuilderAnnotation).contentType(ContentType.JSON).when().post();
	}
}
