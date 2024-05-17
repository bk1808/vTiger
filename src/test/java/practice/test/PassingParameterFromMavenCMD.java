package practice.test;

import org.testng.annotations.Test;

public class PassingParameterFromMavenCMD {

	@Test
	
	public void createContactTest() {
		String browser=System.getProperty("browser");
		String url=System.getProperty("url");
		String username=System.getProperty("username");
		String password=System.getProperty("password");
		System.out.println(browser);
		System.out.println(url);
		System.out.println(username);
		System.out.println(password);
		System.out.println("execute create contact");
		
	}
	
	@Test
	public void modifyContactTest() {
		
		System.out.println("execute modify contact");
	}
	
	@Test
	public void createOrgTest() {
		
		
	}
	
	@Test
	public void modifyOrgTest() {
		
		
	}
	
	
}
