package TestNG;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class CreateContact_DP_Test {

	@Test(dataProvider = "getData")
	public void CreateContactTest(String firstname, String lastname) {

		System.out.println("FirstName :" + firstname + "LastName:" + lastname);

	}

	@DataProvider
	public Object[][] getData() {

		Object[][] objArr = new Object[4][2];
		objArr[0][0] = "deepak";
		objArr[0][1] = "hr";

		objArr[1][0] = "sam";
		objArr[1][1] = "sh";

		objArr[2][0] = "Jhon";
		objArr[2][1] = "smith";

		objArr[3][0] = "purushoth";
		objArr[3][1] = "aravind";

		return objArr; 
	}

}
