package TestNG;

import org.testng.annotations.Test;

public class OrderTest {

	@Test(invocationCount=10)
	public void CreateOrderTest() {
		System.out.println("Execute CreateOrderTest==>123");
	}

	@Test (enabled=false)
	public void bliingAnOrderTest() {
		System.out.println("Execute billingAnOrderTest==>123");
	}
	
	
}
