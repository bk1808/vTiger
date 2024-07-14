package practice;

import java.io.IOException;

import org.testng.annotations.Test;

import com.comcast.crm.generic.basetest.BaseClass;
import com.comcast.crm.generic.fileutility.FileUtility;
import com.comcast.crm.objectrepositoryutility.pomutility.LoginPage;

/**
 * Description: Test class for contact module
 * 
 * @author Praveen
 */
public class SearchContactTest extends BaseClass {

	/**
	 * [Manual T,Cs] Scenario: login() ==> navigate to contact ==>create contact
	 * @throws IOException 
	 * @throws InterruptedException 
	 */
	
	@Test
	public void searchContactTest() throws IOException {
		
		/*step-1: login to application		
		LoginPage lp = new LoginPage(driver);
		FileUtility fLib = new FileUtility();
		String url = fLib.getDataFromPropertiesFile("url");
		String username = fLib.getDataFromPropertiesFile("username");
		String password = fLib.getDataFromPropertiesFile("password");
		lp.loginToApp(url, username, password);*/
		System.out.println("testing the class file");
	}
	
}
