package tests.payloads;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

import io.restassured.RestAssured;

public class CreateComplexPayloadUsingMapList {

	public static void main(String[] args) {
		List<Map<String, Object>> finalListPayload = new ArrayList<Map<String, Object>>();
		
		Map<String, Object> firstJsonObject = new LinkedHashMap<String, Object>();
		firstJsonObject.put("id", 1);
		firstJsonObject.put("first_name", "Alok");
		firstJsonObject.put("last_name", "Barman");
		firstJsonObject.put("email", "testing@outlook.com");
		firstJsonObject.put("gender", "Male");
		
//		List<String> mobileList = new ArrayList<String>();
//		mobileList.add("1231231234");
//		mobileList.add("1234567890");
		List<String> mobileList = Arrays.asList("1231231234", "1234567890");
		firstJsonObject.put("mobile", mobileList);
		
		Map<String, Object> skillSets1 = new HashMap<String, Object>();
		skillSets1.put("name", "Testing");
		skillSets1.put("proficiency", "Medium");
		
		firstJsonObject.put("skills", skillSets1);
		System.out.println("===================Second Payload============================");
		
		Map<String, Object> secondJsonObject = new LinkedHashMap<String, Object>();
		secondJsonObject.put("id", 2);
		secondJsonObject.put("first_name", "Cloe");
		secondJsonObject.put("last_name", "Stuart");
		secondJsonObject.put("email", "alok.barman@outlook.com");
		secondJsonObject.put("gender", "Female");
		
		
		List<Map<String, Object>> skillList = new LinkedList<Map<String, Object>>();
		
		Map<String, Object> skillSets2Map1 = new LinkedHashMap<String, Object>();
		skillSets2Map1.put("name", "Testing");
		skillSets2Map1.put("proficiency", "Medium");
		skillList.add(skillSets2Map1);
		
		Map<String, Object> skillSets2Map2 = new LinkedHashMap<String, Object>();
		skillSets2Map2.put("name", "Java");
		skillSets2Map2.put("proficiency", "Medium");
		
		List<String> certificationList = Arrays.asList("OCJP 11", "OCJP 12");
		skillSets2Map2.put("certifications", certificationList);
		
		skillList.add(skillSets2Map2);
		//Added in second object
		secondJsonObject.put("skills", skillList);
		//Add in final payload
		finalListPayload.add(firstJsonObject);
		finalListPayload.add(secondJsonObject);
		
		RestAssured.given().log().all().body(finalListPayload).when().get();
	}

}
