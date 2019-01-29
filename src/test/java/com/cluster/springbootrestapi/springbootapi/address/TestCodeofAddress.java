package com.cluster.springbootrestapi.springbootapi.address;

import static org.hamcrest.Matchers.hasItems;

import org.json.simple.JSONObject;
import org.junit.Assert;
import org.junit.Test;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class TestCodeofAddress {
	
//	@Test
	public void get_testaddress() {
	Response response =RestAssured.get("http://localhost:8585/api/employees/address");
	
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

	
	@Test
	public void post_testaddress()
	{
		RequestSpecification request= RestAssured.given();
		
		request.header("Content-Type", "application/json");
		
		JSONObject json=new JSONObject();
		
		json.put("id", "21");
		json.put("addressLineOne", "Bangalore");
		json.put("addressLineTwo","peenya");
		json.put("pincode", "560058");
		
		request.body(json.toJSONString());
		
		Response response=request.post("http://localhost:8585/api/employees/address");
		
		int code= response.getStatusCode();
		Assert.assertEquals(code, 200);
		
		
		
	}
	
//	@Test
	public void delete_test()
	{
		RequestSpecification request= RestAssured.given();

		Response response=request.delete("http://localhost:8585/api/address/1");
		
		int code= response.getStatusCode();
		Assert.assertEquals(code, 200);
		
		
	}
	
//	@Test
	public void put_testaddress()
	{
		RequestSpecification request= RestAssured.given();
		
		request.header("Content-Type", "application/json");
		
		JSONObject json=new JSONObject();
		
		json.put("id", "22");
		json.put("addressLineOne", "Bidar");
		json.put("addressLineTwo","Bombalgi");
		json.put("pincode", "585227");
		
		
		request.body(json.toJSONString());
		
		Response response=request.put("http://localhost:8585/api/employees/address/1");
		
		int code= response.getStatusCode();
		Assert.assertEquals(code, 200);
		
		
		
	}

}
