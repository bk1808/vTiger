package practice;


import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class CreateContactConfigMethodTest {

//	1
	@BeforeSuite
	public void beforeSuiteTest()	{
		System.out.println("execute before suite method");
	}
//	2
	@BeforeClass
	public void beforeClassTest()	{
		System.out.println("execute before class method");
	}
//	3
	@BeforeTest
	public void beforeTestMethod()	{
		System.out.println("execute before test method");
	}
//	4
	@BeforeMethod
	public void beforeMethodTest()	{
		System.out.println("execute before Method test");
	}
//	5
	@Test
	public void createContactTest() {
		System.out.println("execute create contact test method");
	}
//	6
	@AfterMethod
	public void afterMethodTest() {
		System.out.println("execute after method test");
	}
//	7
	@AfterTest
	public void afterTestMethod() {
		System.out.println("execute after test method");
	}
//	8
	@AfterClass
	public void afterClassTest() {
		System.out.println("execute after class method");
	}
//	9
	@AfterSuite
	public void afterSuiteTest() {
		System.out.println("execute after suite method");
	}
	
	
	
	
	
	
	
	
	
	
	
	
}
