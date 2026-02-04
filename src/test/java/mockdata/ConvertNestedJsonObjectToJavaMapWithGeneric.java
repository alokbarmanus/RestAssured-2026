package mockdata;

import java.util.Map;

import io.restassured.RestAssured;
import io.restassured.common.mapper.TypeRef;

public class ConvertNestedJsonObjectToJavaMapWithGeneric {

	public static void main(String[] args) {
		
		Map<String, Object> jsonResponseAsMap = RestAssured
		.get("https://mocki.io/v1/011f4c2e-cffb-4004-84ee-e429068305dc")
		.as(new TypeRef<Map<String, Object>>() {});
		
		@SuppressWarnings("unchecked")
		Map<String, Object> skillsMap = (Map<String, Object>) jsonResponseAsMap.get("skills");
		
		System.out.println(skillsMap.get("name"));
		System.out.println(skillsMap.get("proficiency"));
	}

}
