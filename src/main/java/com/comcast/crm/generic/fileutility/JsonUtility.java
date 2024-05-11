package com.comcast.crm.generic.fileutility;

import java.io.FileReader;
import java.io.IOException;

import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import org.openqa.selenium.WebDriver;

public class JsonUtility {

	public String getDataFromJsonFile(String key) throws IOException, ParseException {

//		step-1 get the java object of the physical file
		FileReader fileR=new FileReader("./cofigAppData/appCommonData.json");
//		parse the .json physical file into actual Java object
		JSONParser parse=new JSONParser();
		Object obj=parse.parse(fileR);
//		convert the java object into map[key-value pair] by downcasting because Object class is supermost class
		JSONObject map=(JSONObject) obj;
		String data=(String) map.get(key);//since map reference has object we need to typecast to String 
	
		return data;  
	}
	
}
