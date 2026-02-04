package mockdata;

import java.util.Map;

import io.restassured.RestAssured;

public class ConvertNestedJsonObjectToJavaMap {

	public static void main(String[] args) {
		
		@SuppressWarnings("rawtypes")
		Map jsonResponseAsMap = RestAssured
		.get("https://mocki.io/v1/011f4c2e-cffb-4004-84ee-e429068305dc")
		.as(Map.class);
		
		@SuppressWarnings("unchecked")
		Map<String, String> skillsMap = (Map<String, String>) jsonResponseAsMap.get("skills");
		
		System.out.println(skillsMap.get("name"));
		System.out.println(skillsMap.get("proficiency"));
	}

}
