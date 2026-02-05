package deserialization.pojo.object.customer;

import java.util.List;
import java.util.Map;

import io.restassured.RestAssured;
import io.restassured.common.mapper.TypeRef;
import io.restassured.response.Response;

public class ConvertComplexJsonObjectResponseToPojo {

	public static void main(String[] args) {
		
		Response response = RestAssured
		.given()
		.log()
		.all()
		.when()
		.log()
		.all()
		//.get("https://mocki.io/v1/d89194aa-d1cf-4b93-8029-93feff0c4752");//Array
		.get("https://mocki.io/v1/89dc4098-f858-490c-b5c2-09ecafe574af");//Object
		
		Object responseAsObject = response.as(Object.class);
		
		List<Map<String, Object>> allUsers;
		Map<String, Object> users1;
		Map<String, Object> users2;
		Map<String, Object> customer;
		
		if(responseAsObject instanceof List) {
			allUsers = response.as(new TypeRef<List<Map<String, Object>>>() {
			});
					System.out.println(allUsers.size());
					users1 = allUsers.get(0);
					System.out.println(users1.get("first_name"));
					
					users2 = allUsers.get(1);
					System.out.println(users2.get("first_name"));
					
					System.out.println(allUsers.get(0).get("accountNo"));
		}
		else if(responseAsObject instanceof Map) {
			customer = response.as(new TypeRef<Map<String, Object>>() {
			});
			System.out.println(customer.get("accountNo"));	
		}
		
	}
}
