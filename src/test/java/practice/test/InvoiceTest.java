package practice.test;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.comcast.crm.generic.basetest.BaseClass;

public class InvoiceTest extends BaseClass {

	@Test
	public void createInvoice() {
		
		System.out.println("execute create invoice test");
		String actTitle = driver.getTitle();
		Assert.assertEquals(actTitle, "Login");//provided intentional expectedTitle to fail the test case and take screenshot
		System.out.println(actTitle);
		System.out.println("step-1");
		System.out.println("step-2");
		System.out.println("step-3");
		System.out.println("step-4");
	}
	
	
	@Test
	public void createInvoiceWithContact() {
		System.out.println("execute create invoice with contact test");
		System.out.println("step-1");
		System.out.println("step-2");
		System.out.println("step-3");
		System.out.println("step-4");
	}
	
}
