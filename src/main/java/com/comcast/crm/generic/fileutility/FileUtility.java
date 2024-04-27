package com.comcast.crm.generic.fileutility;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class FileUtility {
// get the requirement from the TE's, pass the key of properties file and return the data back to calling function
	public String getDataFromPropertiesFile(String key) throws IOException
	{
		FileInputStream fis=new FileInputStream("./configAppData/commondata.properties");
		
		Properties p=new Properties();
		
		p.load(fis);
		
		String data=p.getProperty(key);
		
		return data;
	}
}
