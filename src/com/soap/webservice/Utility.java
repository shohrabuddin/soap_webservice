package com.soap.webservice;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/**
 * 
 * @author shohrab.uddin
 *
 */

abstract public class Utility {
	
	public static String constuctJsonPostData(String name, String age, String address){ //jsonData is the input from client

		
		
		
		//JSON object for creating JSON data as output
		JSONObject jsonOutput = new JSONObject(); 
		try {

						//adding values to jsonOutput object
			jsonOutput.put("user_name", name);
			jsonOutput.put("user_age", age);
			jsonOutput.put("user_address", address);
			
		} catch (JSONException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return jsonOutput.toString();
		
	}
	
	
	public static String constuctJsonGetData(){ 
		
		//JSON object for creating JSON data as output
		JSONObject jsonOutput = new JSONObject();
		//JSON object for creating user's phone numbers
		JSONObject jsonPhoneBookObj = new JSONObject();
		//JSON array that hold user's phone numbers
		JSONArray jsonPhoneBookArray = new JSONArray();
		
		try {	
			//adding values to jsonOutput object
			jsonOutput.put("user_name", "Shohrab");
			jsonOutput.put("user_age", "30");
			jsonOutput.put("user_address", "Stuttgart, Germany");
			
			//Constructing JSON array for user phone numbers
			jsonPhoneBookObj.put("mobile", "015210532185");
			jsonPhoneBookObj.put("landphone", "07554125");
			jsonPhoneBookArray.put(jsonPhoneBookObj);
			// End of constructing JSON array for user phone numbers
			
			//add phone numbers to the jsonOutput Object
			jsonOutput.put("phone_numbers", jsonPhoneBookArray);
			
		} catch (JSONException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return jsonOutput.toString();
		
	}
	

}
