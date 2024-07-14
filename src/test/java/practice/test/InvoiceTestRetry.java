package practice.test;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.comcast.crm.generic.basetest.BaseClass;

public class InvoiceTestRetry extends BaseClass {

	@Test (retryAnalyzer = com.comcast.crm.generic.listenerutility.RetryListenerImplementation.class)
	public void activateSimCard() {
		System.out.println("execute create invoice test");
		String actTitle = driver.getTitle();
		Assert.assertEquals(actTitle, "Login");
		System.out.println(actTitle);
		System.out.println("step-1");
		System.out.println("step-2");
		System.out.println("step-3");
		System.out.println("step-4");
	}
	
}
//completdjgihgbiuhgbh by tusharaaaaaaaaa