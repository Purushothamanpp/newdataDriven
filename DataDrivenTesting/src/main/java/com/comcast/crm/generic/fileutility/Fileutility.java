package com.comcast.crm.generic.fileutility;

import java.io.FileInputStream;
import java.util.Properties;

public class Fileutility {
	
	
	public String getDataFromPropertiesFile(String Key) throws Throwable {
		
		FileInputStream fis=new FileInputStream("./configAppData/Script.properties") ;
		Properties pobj=new Properties();
		pobj.load(fis);
		String data=pobj.getProperty(Key);
		return data;
		
		
	}

}
