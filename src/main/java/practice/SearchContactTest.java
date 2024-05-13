package practice;

import org.testng.annotations.Test;

import com.comcast.crm.generic.basetest.BaseClass;
import com.comcast.crm.objectrepositoryutility.LoginPage;

/**
 * Description: Test class for contact module
 * 
 * @author Praveen
 */
public class SearchContactTest extends BaseClass {

	/**
	 * [Manual T,Cs] Scenario: login() ==> navigate to contact ==>create contact
	 */
	
	@Test
	public void searchContactTest() {
		
		/*step-1: login to application*/		
		LoginPage lp = new LoginPage(driver);
		lp.loginToApp("url", "username", "password");
	}
	
}
