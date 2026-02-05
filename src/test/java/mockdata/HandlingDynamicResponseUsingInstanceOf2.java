package mockdata;

import java.util.List;
import java.util.Map;

import io.restassured.RestAssured;
import io.restassured.common.mapper.TypeRef;
import io.restassured.response.Response;

public class HandlingDynamicResponseUsingInstanceOf2 {

	public static void main(String[] args) {
		Response response = RestAssured
		//.get("https://mocki.io/v1/fd5f13e9-0fb8-4bdf-8de9-e6f10e098057");//List End point
		.get("https://mocki.io/v1/63265cfd-f27e-4766-8653-a68b94c350a2");//Object End point
		/*
		 * .get("https://mocki.io/v1/76a42333-cabf-4e7a-9ffc-8ba664150511") .
		 * as(new TypeRef<Map<String, Object>>() {});
		 */
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
