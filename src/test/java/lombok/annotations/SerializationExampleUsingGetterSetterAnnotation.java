package lombok.annotations;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;

public class SerializationExampleUsingGetterSetterAnnotation {

	public static void main(String[] args) {
		EmployeePojoUsingGetterSetterAnnotation employeePojoUsingGetterSetterAnnotation = new EmployeePojoUsingGetterSetterAnnotation();
		employeePojoUsingGetterSetterAnnotation.setId(2);
		employeePojoUsingGetterSetterAnnotation.setFirst_name("Alok1");
		employeePojoUsingGetterSetterAnnotation.setLast_name("Barman");
		employeePojoUsingGetterSetterAnnotation.setMarried(true);
		
		ObjectMapper objectMapper = new ObjectMapper();
		try {
			String jsonString = objectMapper.writerWithDefaultPrettyPrinter().writeValueAsString(employeePojoUsingGetterSetterAnnotation);
			System.out.println(jsonString);
		} catch (JsonProcessingException e) {
			e.printStackTrace();
		}
		
		RestAssured.given().log().all().body(employeePojoUsingGetterSetterAnnotation).contentType(ContentType.JSON).when().post();
	}
}
