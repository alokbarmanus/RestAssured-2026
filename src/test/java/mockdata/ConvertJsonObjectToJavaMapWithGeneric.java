package mockdata;

import java.util.Map;

import io.restassured.RestAssured;
import io.restassured.common.mapper.TypeRef;

public class ConvertJsonObjectToJavaMapWithGeneric {

	public static void main(String[] args) {
		
		Map<String, Object> jsonResponseAsMap = RestAssured
		.get("https://mocki.io/v1/76a42333-cabf-4e7a-9ffc-8ba664150511")
		.as(new TypeRef<Map<String, Object>>() {});
		
		int id = (int) jsonResponseAsMap.get("id");
		String firstName = (String) jsonResponseAsMap.get("first_name");
		String lastName = (String) jsonResponseAsMap.get("last_name");
		boolean isMarried = (boolean) jsonResponseAsMap.get("married");
		
		System.out.println(id);
		System.out.println(firstName);
		System.out.println(lastName);
		System.out.println(isMarried);
		
		//jsonResponseAsMap.keySet().forEach(k -> System.out.println(k));
	}

}
