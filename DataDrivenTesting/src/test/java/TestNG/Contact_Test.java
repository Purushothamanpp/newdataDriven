package TestNG;

import org.testng.annotations.Test;

public class Contact_Test {

	@Test
	public void CreateContactTest() {
		System.out.println("execute createContact with -->HDFC");
	}
	
	
	@Test(dependsOnMethods="CreateContactTest")
	public void modifyContactTest() {
		
		System.out.println("execut modifyContactTest--->HDFC=>ICICI");
	}
	
	@Test(dependsOnMethods="modifyContactTest")
	public void deleteContactTest() 
	{ 
		
		System.out.println("execute deleteContactTest-->ICICI");
	}
	
	
	
}
