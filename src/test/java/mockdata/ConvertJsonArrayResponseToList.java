package mockdata;

import java.util.List;
import java.util.Map;

import io.restassured.RestAssured;
import io.restassured.common.mapper.TypeRef;

public class ConvertJsonArrayResponseToList {

	public static void main(String[] args) {
		
		List<Map<String, Object>> allUsers = RestAssured
		.get("https://mocki.io/v1/f980b775-e566-4f27-8307-5f0dc2da5668")
		.as(new TypeRef<List<Map<String, Object>>>(){});
		
		System.out.println(allUsers.size());
		Map<String, Object> users1 = allUsers.get(0);
		System.out.println(users1.get("first_name"));
		
		Map<String, Object> users2 = allUsers.get(1);
		System.out.println(users2.get("first_name"));
	}

}
