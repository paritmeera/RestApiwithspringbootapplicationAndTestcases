package com.cluster.springbootrestapi.springbootapi.phone;

import static org.hamcrest.Matchers.hasItems;

import org.json.simple.JSONObject;
import org.junit.Assert;
import org.junit.Test;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class TestCodeofPhone {

	
//	@Test
	public void get_testPhone() {
	Response response =RestAssured.get("http://localhost:8585/api/employees/phones");
	
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
	public void post_testPhone()
	{
		RequestSpecification request= RestAssured.given();
		
		request.header("Content-Type", "application/json");
		
		JSONObject json=new JSONObject();
		
		json.put("id", "101");
		json.put("phoneType","jioprime");
		json.put("phoneNumber","6360389894");
	
		request.body(json.toJSONString());
		
		Response response=request.post("http://localhost:8585/api/employees/phones");
		
		int code= response.getStatusCode();
		Assert.assertEquals(code, 200);
		
		
		
	}
	
	@Test
	public void delete_testPhone()
	{
		RequestSpecification request= RestAssured.given();

		Response response=request.delete("http://localhost:8585/api/phones/1");
		
		int code= response.getStatusCode();
		Assert.assertEquals(code, 200);
		
		
	}
	
//	@Test
	public void put_testPhone()
	{
		RequestSpecification request= RestAssured.given();
		
		request.header("Content-Type", "application/json");
		
		JSONObject json=new JSONObject();
		
		json.put("id", "13");
		json.put("phoneType","jio12");
		json.put("phoneNumber","7204500125");
		
		
		request.body(json.toJSONString());
		
		Response response=request.put("http://localhost:8585/api/employees/phones/1");
		
		int code= response.getStatusCode();
		Assert.assertEquals(code, 200);
		
		
		
	}
}
