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
	
	public void deleteContactTest() {
		
		System.out.println("execute delete contact");
	}
	
	@Test
	public void createOrgTest() {
		System.out.println("execute create orgnization");
		
	}
	
	@Test
	public void modifyOrgTest() {
		System.out.println("execute modify orgnization");
		
	}
	
	@Test
	public void deleteOrgTest() {
		
		System.out.println("execute delete contact");
	}
	
	
}
