package mockdata;

import java.util.List;
import java.util.Map;

import io.restassured.RestAssured;
import io.restassured.response.Response;

public class HandlingDynamicResponseUsingInstanceOf {

	public static void main(String[] args) {
		Response response = RestAssured
		//.get("https://mocki.io/v1/fd5f13e9-0fb8-4bdf-8de9-e6f10e098057");//List End point
		.get("https://mocki.io/v1/63265cfd-f27e-4766-8653-a68b94c350a2");//Object End point
		
		Object responseAsObject = response.as(Object.class);
		
		if(responseAsObject instanceof List) {
			List<Object> responseAsList = (List<Object>) responseAsObject;
			System.out.println(responseAsList.size());
		}
		else if(responseAsObject instanceof Map) {
			Map<String, Object> responseAsMap = (Map<String, Object>) responseAsObject;
			System.out.println(((Map<String, Object>) responseAsObject).keySet());
			System.out.println(responseAsMap.get("id"));
		}
	}

}
