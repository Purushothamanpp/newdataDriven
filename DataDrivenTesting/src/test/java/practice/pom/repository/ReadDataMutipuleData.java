package practice.pom.repository;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class ReadDataMutipuleData {

	@Test(dataProvider="get")
	public void ReadDataMutipuleData1(String location ,String address,String street) {
		System.out.println(location +"location"+ address+"location"+street+"street");
		
		
	}
	
	
	
	
	
	
	
	@DataProvider
	public Object[][] get() {

		Object[][] obj = new Object[3][3];
		obj[0][0] = "purushoth";
		obj[0][1] = "chennai";
		obj[0][2] = "alathur";

		obj[1][0] = "porur";
		obj[1][1] = "poonamallee";
		obj[1][2] = "karachavadi";

		obj[2][0] = "Dheli";
		obj[2][1] = "france";
		obj[2][2] = "china";

		return obj;

	}

}
