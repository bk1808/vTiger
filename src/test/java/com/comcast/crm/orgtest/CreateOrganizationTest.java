package com.comcast.crm.orgtest;

import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.junit.Assert;
import org.testng.Reporter;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.aventstack.extentreports.Status;
import com.comcast.crm.generic.basetest.BaseClass;
import com.comcast.crm.generic.webdriverutility.UtilityClassObject;
import com.comcast.crm.objectrepositoryutility.CreateNewOrganizationPage;
import com.comcast.crm.objectrepositoryutility.HomePage;
import com.comcast.crm.objectrepositoryutility.OrganizationInfoPage;
import com.comcast.crm.objectrepositoryutility.OrganizationsPage;

/*@Listeners (com.comcast.crm.generic.listenerutility.ListenerImplementationClass.class)*/
/**
 * This class has test script related to create an organization. Which has 4 different
 * test cases for different scenarios
 *  18-May-2024
 */

public class CreateOrganizationTest extends BaseClass {

	/** 
	 * This method can be executed to create organization i.e., mandatory text field
	 * @throws IOException
	 * @throws InterruptedException
	 */
	
	/* Test-Case: 1 */
	@Test(groups = "smoke test")
	public void createOrganizationTest() throws IOException, InterruptedException {
		/*
		 * create object of FileUtility for reading the data from commondata.properties
		 * and fetch the details create the random number using Random Class of
		 * Java.util package create an object of ExcelUtility class to read the data
		 * from excel file
		 */

		/*
		 * step-1: login to application lp.getUsernameEdt().sendKeys(un);
		 * lp.getPasswordEdt().sendKeys(pwd); lp.getLoginBtn().click();
		 */

		/* step-2: navigate to organization module */
		UtilityClassObject.gettest().log(Status.INFO, "navigate to organization page");

		String orgName = eLib.getDataFromExcel("org", 1, 2) + jLib.getRandomNumber(); // use 2 in place of column

		HomePage hp = new HomePage(driver);
		hp.getOrgLink().click();

		/* step-3: click on create organization button */
		UtilityClassObject.gettest().log(Status.INFO, "navigate to create organization page");
		OrganizationsPage onp = new OrganizationsPage(driver);
		onp.getCreateNewOrgBtn().click();

		/* step-4: enter all the details and create new organization */
		UtilityClassObject.gettest().log(Status.INFO, "create organization");
		CreateNewOrganizationPage cnop = new CreateNewOrganizationPage(driver);
		cnop.createOrg(orgName);

		UtilityClassObject.gettest().log(Status.INFO, orgName + "new organization created");
		/* verify organization name */
		UtilityClassObject.gettest().log(Status.PASS, "organization name text field is verified");
		OrganizationInfoPage oip = new OrganizationInfoPage(driver);
		String actOrgName = oip.getHeaderMsg().getText();

		boolean status = actOrgName.contains(orgName);
		Assert.assertTrue(status);

		/*
		 * if(actOrgName.contains(orgName)) {
		 * System.out.println(orgName+" is verified==PASS"); } else {
		 * System.out.println(orgName+" is not verified==FAIL"); }
		 */

	}

	/* Test-Case: 2 */
	@Test(groups = "regression test")
	public void createOrganizationWithIndustry() throws EncryptedDocumentException, IOException {

		String orgName = eLib.getDataFromExcel("org", 1, 2) + jLib.getRandomNumber();
		String industry = eLib.getDataFromExcel("org", 4, 3);
		String type = eLib.getDataFromExcel("org", 4, 4);

		/* step-2: navigate to organization module */
		UtilityClassObject.gettest().log(Status.INFO, "navigate to organization page");
		HomePage hp = new HomePage(driver);
		hp.getOrgLink().click();

		/* step-3: click on create organization button */
		UtilityClassObject.gettest().log(Status.INFO, "navigate to create organization page");
		OrganizationsPage cnp = new OrganizationsPage(driver);
		cnp.getCreateNewOrgBtn().click();

		/* step-4: enter all the details and create new organization */
		UtilityClassObject.gettest().log(Status.INFO, orgName + "create organization page with industry and type");
		CreateNewOrganizationPage cnop = new CreateNewOrganizationPage(driver);
		cnop.createOrg(orgName, industry, type, wLib);

		/* verify the drop-down industry and type info */

		OrganizationInfoPage oip = new OrganizationInfoPage(driver);
		String actIndustry = oip.getIndustry().getText();
		String actType = oip.getType().getText();

		SoftAssert soft = new SoftAssert();
		boolean industryDropDown = actIndustry.equals(industry);
		soft.assertTrue(industryDropDown);
		UtilityClassObject.gettest().log(Status.PASS, "industry drop down field is verified");

		/*
		 * if(actIndustry.equals(industry)) {
		 * System.out.println(industry+" is verified==PASS"); } else {
		 * System.out.println(industry+" is not verified==FAIL"); }
		 */

		boolean typeDropDown = actType.equals(type);
		soft.assertTrue(typeDropDown);
		UtilityClassObject.gettest().log(Status.PASS, "industry type drop down field is verified");

		/*
		 * if(actType.equals(type)) { System.out.println(type+" is verified==PASS"); }
		 * else { System.out.println(type+" is not verified==FAIL"); }
		 */
		soft.assertAll();
	}

	/* Test-Case: 3 */
	@Test(groups = "regression test")
	public void createOrganizationWithPhoneNumber() throws EncryptedDocumentException, IOException {

		String orgName = eLib.getDataFromExcel("org", 1, 2) + jLib.getRandomNumber();
		String phoneNum = eLib.getDataFromExcel("org", 7, 3) + jLib.getRandomNumber();

		/* step-2: navigate to organization module */
		UtilityClassObject.gettest().log(Status.INFO, "navigate to organization page");
		HomePage hp = new HomePage(driver);
		
		hp.getOrgLink().click();

		/* step-3: click on create organization button */
		UtilityClassObject.gettest().log(Status.INFO, "navigate to create new organization page");
		OrganizationsPage cnp = new OrganizationsPage(driver);
		cnp.getCreateNewOrgBtn().click();

		/* step-4: enter all the details and create new organization */
		UtilityClassObject.gettest().log(Status.INFO, "create new organization");
		CreateNewOrganizationPage cnop = new CreateNewOrganizationPage(driver);
		cnop.createOrg(orgName, phoneNum);

		/* verify the phone number info */
		String actualPhoneNum = cnop.getActualPhNum().getText();

		SoftAssert soft = new SoftAssert();
		soft.assertEquals(actualPhoneNum, phoneNum);
		UtilityClassObject.gettest().log(Status.PASS, "phone number text field is verified");

		/*
		 * if(actualPhoneNum.equals(phoneNum)) {
		 * System.out.println(phoneNum+" is created==PASS"); } else {
		 * System.out.println(phoneNum+" is not created==FAIL"); }
		 */
		soft.assertAll();

	}

	/* Test-Case: 4 */
	@Test(groups = "regression test")
	public void deleteOrganizationTest() throws EncryptedDocumentException, IOException, InterruptedException {

		String orgName = eLib.getDataFromExcel("org", 10, 2) + jLib.getRandomNumber();
		String orgIn = eLib.getDataFromExcel("org", 10, 3);

		/* step-2: navigate to organization module */
		UtilityClassObject.gettest().log(Status.INFO, "navigate to organization page");
		HomePage hp = new HomePage(driver);
		hp.getOrgLink().click();

		/* step-3: click on create organization button */
		UtilityClassObject.gettest().log(Status.INFO, "navigate to create new organization page");
		OrganizationsPage onp = new OrganizationsPage(driver);
		onp.getCreateNewOrgBtn().click();

		/* step-4: enter all the details and create new organization */
		UtilityClassObject.gettest().log(Status.INFO, "create new organization");
		CreateNewOrganizationPage cnop = new CreateNewOrganizationPage(driver);
		cnop.createOrg(orgName);

		/* verify organization name */
		OrganizationInfoPage oip = new OrganizationInfoPage(driver);
		String actOrgName = oip.getHeaderMsg().getText();

		SoftAssert soft = new SoftAssert();

		boolean organizationName = actOrgName.contains(orgName);
		soft.assertTrue(organizationName);
		UtilityClassObject.gettest().log(Status.PASS, "organization name text field is verified");

		/*
		 * if(actOrgName.contains(orgName)) {
		 * System.out.println(orgName+" is verified==PASS"); } else {
		 * System.out.println(orgName+" is not verified==FAIL"); }
		 */

		/* go back to organizations page and then search for organization */
		UtilityClassObject.gettest().log(Status.INFO, "search for organization");
		hp.getOrgLink().click();
		onp.getSearchOrgName().sendKeys(orgName);

		wLib.select(onp.getSearchDD(), orgIn);
		onp.getSearchNowBtn().click();

		/* In dynamic web table select and delete the organization */
		UtilityClassObject.gettest().log(Status.PASS, "delete the organization");
		onp.dynamicData(orgName);
		wLib.switchToAlertAccept(driver);

		soft.assertAll();
	}

}
