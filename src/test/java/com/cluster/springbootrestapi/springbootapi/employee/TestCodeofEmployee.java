package com.cluster.springbootrestapi.springbootapi.employee;

import org.junit.Assert;
import org.junit.Test;

import static io.restassured.RestAssured.get;
import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.hasItems;
import static org.junit.Assert.assertEquals;

import org.json.simple.JSONObject;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class TestCodeofEmployee {
	
	
	
		@Test
		public void get_test() {
		Response response =RestAssured.get("http://localhost:8585/api/employees");
		
		System.out.println(response.asString());
		
		JSONObject json=new JSONObject();
		
		json.put("id", hasItems(1));

		/*response.then().body("id", hasItems(1));
		response.then().body("name", hasItems("Pankaj"));
		response.then().body("dob", hasItems("01-02-1992"));*/
		
		int code=response.getStatusCode();
		System.out.println("Status code is:" +code);
		Assert.assertEquals(code, 200);
		
		}
	
		
	//	@Test
		public void post_test()
		{
			RequestSpecification request= RestAssured.given();
			
			request.header("Content-Type", "application/json");
			
			JSONObject json=new JSONObject();
			
		
			
			json.put("id", "11");
			json.put("name","meerasp");
			json.put("dob", "01-02-1992");
			
		
			request.body(json.toJSONString());
			
			Response response=request.post("http://localhost:8585/api/employees");
			
			int code= response.getStatusCode();
			Assert.assertEquals(code, 200);
			
			
			
		}
		
	//	@Test
		public void delete_test()
		{
			RequestSpecification request= RestAssured.given();
	
			Response response=request.delete("http://localhost:8585/api/employees/8");
			
			int code= response.getStatusCode();
			Assert.assertEquals(code, 200);
			
			
		}
		
	//	@Test
		public void put_test()
		{
			RequestSpecification request= RestAssured.given();
			
			request.header("Content-Type", "application/json");
			
			JSONObject json=new JSONObject();
			json.put("id", "10");
			json.put("name", "meeradevi");
			json.put("dob", "22-01-2019");
			
			request.body(json.toJSONString());
			
			Response response=request.put("http://localhost:8585/api/employees/2");
			
			int code= response.getStatusCode();
			Assert.assertEquals(code, 200);
			
			
			
		}
		
}



