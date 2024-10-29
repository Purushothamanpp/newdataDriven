package Property;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties; 

public class Firstpro {

	public static void main(String[] args) throws IOException {
		
		// Step 1: get the java representation object of the physical file \
		
		FileInputStream  fis=new FileInputStream("./configAppData/commondata.properties");
		//Step2:using properties class ,load all the keys
		
		Properties pobj=new Properties();
		pobj.load(fis);
		
		
		//step3:get the value based on key]
		
		System.out.println(pobj.getProperty("url"));
		
		
		
		
		
	}

}
