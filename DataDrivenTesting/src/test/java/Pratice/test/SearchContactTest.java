package Pratice.test;

import org.testng.annotations.Test;

import com.comcast.crm.basetest.BaseClass;
import com.comcast.crm.objectrepositoryUtility.Loginpage;

/**
 * test class gor contact module
 * @author purushothaman
 *   
 * 
 */
public class SearchContactTest extends BaseClass{

	@Test
	public void SearchcontactTest() {
		/*step1 :login to app*/
		
		Loginpage  lp=new Loginpage(driver);
		lp.loginToapp("url","username","password");
		
		
	}
	
}
