package com.soap.webservice;

import org.json.JSONObject;

/**
 * 
 * @author shohrab.uddin
 * URL to access this web service will be:
 * http://localhost:8080/soap_webservice/services/SOAPWebService?wsdl
 */

public class SOAPWebService {
	JSONObject jObj = new JSONObject();
/**
 * Unlike REST in SOAP web service there is no concept of POST, GET, PUT methods. However, each method in SOAP 
 * web service is considered as an operation and it is accessed by it's name from a client.
 * @param data: String
 * @return Json String
 */
	public String postMethod(String name, String age, String address){ 
		String retrunJsonString = Utility.constuctJsonPostData(name, age, address);
		
		return retrunJsonString;
	}

	public String getMethod(){	
		System.out.println("hello");
    	return Utility.constuctJsonGetData();
	}
}
