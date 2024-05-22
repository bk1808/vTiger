package com.comcast.crm.contacttest;

import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.comcast.crm.generic.basetest.BaseClass;
import com.comcast.crm.objectrepositoryutility.ContactsInfoPage;
import com.comcast.crm.objectrepositoryutility.ContactsPage;
import com.comcast.crm.objectrepositoryutility.CreateNewContactsPage;
import com.comcast.crm.objectrepositoryutility.CreateNewOrganizationPage;
import com.comcast.crm.objectrepositoryutility.HomePage;
import com.comcast.crm.objectrepositoryutility.OrganizationChildPopupPage;
import com.comcast.crm.objectrepositoryutility.OrganizationInfoPage;
import com.comcast.crm.objectrepositoryutility.OrganizationsPage;

/**
 * This class represents the script for different test cases 
 * 
 * @author Praveen 10-May-2024
 */

public class CreateContactWithMandatoryField extends BaseClass {

	/* Test-Case: 1 */
	@Test(groups = { "smoke test", "regression test" })
	public void createContactTest() throws IOException {
		/*
		 * TODO Converting manual test case into test script for regression testing to
		 * check whether the contact is created with mandatory fields or not Expted
		 * result: Contacts should be create and displayed in contact details page along
		 * with mandatory fileds
		 */

		/* create the random number using Random Class of Java.util package
		read test script data from the excel file, as we shouldn't hardcode */

		String lastName = eLib.getDataFromExcel("contact", 1, 3) + jLib.getRandomNumber();

		/* step-2: navigate to contacts module */
		HomePage hp = new HomePage(driver);
		hp.getContactLink().click();

		/* step-3: click on create contacts button */

		ContactsPage cnp = new ContactsPage(driver);
		cnp.getCreateNewContPage().click();

		/* step-4: enter all the details and create new organization */
		CreateNewContactsPage cncp = new CreateNewContactsPage(driver);
		cncp.getLastNameEdt().sendKeys(lastName);

		/* step-5: save the contact */

		cncp.getSaveBtn().click();

		/* verify the header and the contact info with last name mandatory field */
		ContactsInfoPage cip = new ContactsInfoPage(driver);
		String actualLastName = cip.getActualLastName().getText();
		String actualContact = cip.getHeaderContact().getText();

		/* To verify the header using Hard Assert */

		boolean status = actualContact.contains(lastName);
		Assert.assertTrue(status);
		Reporter.log("last name in header is verified==PASS", true);

		/* To verify the last name mandatory text field using Hard Assert */

		Assert.assertEquals(actualLastName, lastName);
		Reporter.log("last name in mandatory text field is verified==PASS", true);

		/*
		 * if (actualContact.contains(lastName)) { System.out.println(lastName +
		 * " is created in header==PASS"); } else { System.out.println(lastName +
		 * " is not created in header==FAIL"); }
		 * 
		 * if (actualLastName.equals(lastName)) { System.out.println(lastName +
		 * " is created==PASS"); } else { System.out.println(lastName +
		 * " is not created==FAIL"); }
		 */

	}

	/* Test-Case: 2 */
	@Test(groups = "regression test")
	public void createContactWithSupport() throws EncryptedDocumentException, IOException, InterruptedException {

		String lastName = eLib.getDataFromExcel("contact", 4, 3) + jLib.getRandomNumber();

		/* step-2: navigate to contacts module */
		HomePage hp = new HomePage(driver);
		hp.getContactLink().click();

		/* step-3: click on create contacts button */

		ContactsPage cnp = new ContactsPage(driver);
		cnp.getCreateNewContPage().click();

		/* step-4: enter all the details and create new organization */
		CreateNewContactsPage cncp = new CreateNewContactsPage(driver);
		cncp.getLastNameEdt().sendKeys(lastName);

		/* capture the system date from java.util package and change it as needed */

		
		String startDate = jLib.getSystemDateYYYYMMDD();
		String endDate = jLib.getrequiredDateYYYYMMDD(30);
		cncp.getSuppStartDate().clear();
		cncp.getSuppStartDate().sendKeys(startDate);

		cncp.getSuppEndDate().clear();/* to add fresh date we need to clear the existing data */
		cncp.getSuppEndDate().sendKeys(endDate);

		/* step-5: save the contact */

		cncp.getSaveBtn().click();

		/* verify the contact info with support start date and support end date */

		String actualStartDate = cncp.getActSuppStartDate().getText();

		/* To verify the non-mandatory text field Start date, using Soft Assert */

		SoftAssert soft = new SoftAssert();

		soft.assertEquals(actualStartDate, startDate);
		Reporter.log("start date text field is verified==PASS", true);

		/*
		 * if (actualStartDate.equals(startDate)) { System.out.println(startDate +
		 * " information is verified==PASS"); } else { System.out.println(startDate +
		 * " information is not verified==FAIL"); }
		 */

		/* To verify the non-mandatory text field End data, using Soft Assert */

		String actualEndDate = cncp.getActSuppEndDate().getText();

		boolean status = actualEndDate.trim().equals(endDate);
		soft.assertTrue(status);
		Reporter.log("end date text field is verified==PASS", true);

		/*
		 * if (actualEndDate.trim().equals(endDate)) { System.out.println(endDate +
		 * " information is verified==PASS"); } else { System.out.println(endDate +
		 * " information is not verified==FAIL"); }
		 */

		soft.assertAll();

	}

	/* Test-Case: 3 */
	@Test(groups = "regression test")
	public void createContactWithOrgTest() throws EncryptedDocumentException, IOException, InterruptedException {

		String orgName = eLib.getDataFromExcel("contact", 7, 2) + jLib.getRandomNumber();
		String lastName = eLib.getDataFromExcel("contact", 7, 3) + jLib.getRandomNumber();
		String orgIn = eLib.getDataFromExcel("org", 10, 3);

		HomePage hp = new HomePage(driver);
		hp.getOrgLink().click();

		/* step-3: click on create organization button */
		OrganizationsPage onp = new OrganizationsPage(driver);
		onp.getCreateNewOrgBtn().click();

		/* step-4: enter all the details and create new organization */

		CreateNewOrganizationPage cnop = new CreateNewOrganizationPage(driver);
		cnop.createOrg(orgName);

		/* step-5: navigate to contact module */

		OrganizationInfoPage oip = new OrganizationInfoPage(driver);
		oip.getContactsLink().click();

		/* step-6: click on create contact button */
		ContactsPage cnp = new ContactsPage(driver);
		cnp.getCreateNewContPage().click();

		/* step-7: enter all the details and create new contact */
		CreateNewContactsPage cncp = new CreateNewContactsPage(driver);
		cncp.getLastNameEdt().sendKeys(lastName);

		/* step-8: click on look-up window, select organization by searching */
		cncp.getClickOnLookup().click();

		/* switch to child window */

		wLib.switchToTabOnUrl(driver, "module=Accounts");

		/*
		 * search for dynamic organization name, select organization name that's created
		 * during the run-time and save
		 */

		OrganizationChildPopupPage opop = new OrganizationChildPopupPage(driver);
		opop.selectSearchDD(orgName, orgIn);

		/* switch to parent window */

		wLib.switchToTabOnUrl(driver, "Contacts&action");
		cncp.getSaveBtn().click();

		/* verify the header message expected result */
		ContactsInfoPage cip = new ContactsInfoPage(driver);
		String headerMessg = cip.getHeaderContact().getText();

		SoftAssert soft = new SoftAssert();
		boolean lastNameStatus = headerMessg.contains(lastName);
		soft.assertTrue(lastNameStatus);
		Reporter.log("last name text field is verified==PASS", true);

		/*
		 * if (headerMessg.contains(lastName)) { System.out.println(lastName +
		 * " is created===PASS"); } else { System.out.println(lastName +
		 * " is not created==FAIL"); }
		 */

		/* verify the header orgName expected result */

		String actualOrgNameinfo = cip.getActualOrgName().getText();

		boolean orgStatus = actualOrgNameinfo.contains(orgName);
		soft.assertTrue(orgStatus);
		Reporter.log("organization name text field is verified==PASS", true);

		/*
		 * if (actualOrgNameinfo.contains(orgName)) { System.out.println(orgName +
		 * " is created===PASS"); } else { System.out.println(orgName +
		 * " is not created===FAIL"); }
		 */

		soft.assertAll();

	}

}
