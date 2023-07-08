package testcases.E2Etestcasesuite.ohsmodule;

import java.io.IOException;
import java.time.LocalDate;
import java.util.Hashtable;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.testng.Reporter;
import org.testng.SkipException;
import org.testng.annotations.Test;

import com.relevantcodes.extentreports.LogStatus;

import base.Helper;
import base.TestBase;
import utilities.TestUtil;

public class RR5241OHSTest extends TestBase {

	@Test(dataProviderClass = TestUtil.class, dataProvider = "dp")
	public void rR5241OHSTest(Hashtable<String, String> data) throws IOException, InterruptedException {

		execution(data, "rR5241OHSTest");

		// VERIFY THE INCIDENT REPORT IN THE EHS INCIDANCE, HR INCIDANCE, INSURANCE
		// INCIDANCE DASHBOARDS.

		System.out.println(
				"VERIFY THE INCIDENT REPORT IN THE EHS INCIDANCE, HR INCIDANCE, INSURANCE INCIDANCE DASHBOARDS.");
		test.log(LogStatus.INFO,
				"VERIFY THE INCIDENT REPORT IN THE EHS INCIDANCE, HR INCIDANCE, INSURANCE INCIDANCE DASHBOARDS.");
		Reporter.log("VERIFY THE INCIDENT REPORT IN THE EHS INCIDANCE, HR INCIDANCE, INSURANCE INCIDANCE DASHBOARDS.");
		log.info("VERIFY THE INCIDENT REPORT IN THE EHS INCIDANCE, HR INCIDANCE, INSURANCE INCIDANCE DASHBOARDS.");

		Helper helper = new Helper();

		// refresh the page
		driver.navigate().refresh();
		Thread.sleep(5000);
		driver.navigate().refresh();

		System.out.println("Navigate to the Home Screen i.e. Property List Screen.");

		String insuranceNumber = null;

		try {

			// wait for the element
			explicitWaitClickable("ohsicon_CSS");

			// click on the OHS icon from the property list page
			click("ohsicon_CSS");
			System.out.println("Clicked on the OHS icon of the Property.");
			ngDriver.waitForAngularRequestsToFinish();
			System.out.println("Navigate to the OHS screen of the perticular property.");

			// click on the burger menu
			click("menubtn_CSS");
			System.out.println("Clicked on the burger menu button successfully!!!");
			ngDriver.waitForAngularRequestsToFinish();

			// wait for the element
			explicitWaitClickable("questionnaire_option_ohstab_incidentreports_XPATH");

			// click on the incident reports
			click("questionnaire_option_ohstab_incidentreports_XPATH");
			System.out.println("Clicked on the incident reports option.");
			ngDriver.waitForAngularRequestsToFinish();

			// ADD DETAILS IN THE INCIDENT REPORT TAB

			System.out.println("********** ADD DETAILS IN THE INCIDENT REPORT TAB **********");
			test.log(LogStatus.INFO, "********** ADD DETAILS IN THE INCIDENT REPORT TAB **********");
			Reporter.log("********** ADD DETAILS IN THE INCIDENT REPORT TAB **********");
			log.info("********** ADD DETAILS IN THE DETAILS, CAUSES TAB **********");

			// click on the add button
			click("ohs_incident_addbtn_CSS");
			System.out.println("Clicked on the Add button.");
			ngDriver.waitForAngularRequestsToFinish();
			System.out.println("Navigate to the Add incident report Screen");

			// wait for the element
			Thread.sleep(5000);

			// enter the incident time - hours
			clear("ohs_incident_hourstxt_CSS");
			System.out.println("Cleared the hours field of incident time.");
			ngDriver.waitForAngularRequestsToFinish();
			type("ohs_incident_hourstxt_CSS", "11");
			System.out.println("Entered the hours in the incident time.");
			ngDriver.waitForAngularRequestsToFinish();

			// enter the incident time - minute
			clear("ohs_incident_minutestxt_CSS");
			System.out.println("Cleared the minute field of incident time.");
			ngDriver.waitForAngularRequestsToFinish();
			type("ohs_incident_minutestxt_CSS", "20");
			System.out.println("Entered the minute in the incident time.");
			ngDriver.waitForAngularRequestsToFinish();

			// scroll down the screen
			JavascriptExecutor js = (JavascriptExecutor) driver;
			js.executeScript("window.scrollBy(0,500)");

			// enter the short description
			type("ohs_incident_shortdescriptiontxt_CSS", data.get("describe_incident"));
			System.out.println("Entered the short description");
			ngDriver.waitForAngularRequestsToFinish();

			// wait for the element
			explicitWaitClickable("ohs_incident_addeventtypebtn_CSS");

			// click on the add event type button
			click("ohs_incident_addeventtypebtn_CSS");
			System.out.println("Clicked on the add event type button.");
			ngDriver.waitForAngularRequestsToFinish();

			// wait for the element
			explicitWaitClickable("ohs_incident_eventtypedd_CSS");

			// click on the event type dropdown
			select("ohs_incident_eventtypedd_CSS", data.get("event_type"));
			System.out.println("Clicked on the event type dropdown.");
			ngDriver.waitForAngularRequestsToFinish();

			// click on the add button of the add event type record model
			click("ohs_incident_eventty_addbtn_CSS");
			System.out.println("Clicked on the add button of the add event type record model.");
			ngDriver.waitForAngularRequestsToFinish();

			// scroll up the screen
			js.executeScript("window.scrollBy(0,-700)");

			// fetch the insurance number
			insuranceNumber = (driver.findElement(By.xpath(OR.getProperty("ohs_incident_insurancenumber_XPATH")))
					.getText()).trim();

			System.out.println("**********" + insuranceNumber + "**********");
			test.log(LogStatus.INFO, "**********" + insuranceNumber + "**********");
			Reporter.log("**********" + insuranceNumber + "**********");
			log.info("**********" + insuranceNumber + "**********");

			// click on the next button
			click("ohs_incident_nextbtn_CSS");
			System.out.println("Clicked on the next button.");
			ngDriver.waitForAngularRequestsToFinish();

			// synchronization
			explicitWait("ohs_incident_nextbtn_CSS");
			System.out.println("Navigate to the Details, Cause Tab.");
			test.log(LogStatus.INFO, "Navigate to the Details, Cause Tab..");
			Reporter.log("Navigate to the Details, Cause Tab..");
			log.info("Navigate to the Details, Cause Tab..");

			// ADD DETAILS IN THE DETAILS, CAUSES TAB

			System.out.println("********** ADD DETAILS IN THE DETAILS, CAUSES TAB **********");
			test.log(LogStatus.INFO, "********** ADD DETAILS IN THE DETAILS, CAUSES TAB **********");
			Reporter.log("********** ADD DETAILS IN THE DETAILS, CAUSES TAB **********");
			log.info("********** ADD DETAILS IN THE DETAILS, CAUSES TAB **********");

			// Enter the data in the description incident field
			type("ohs_incident_descriptionincidenttxt_CSS", data.get("describe_incident"));
			ngDriver.waitForAngularRequestsToFinish();
			System.out.println("Entered the data in the description incident field.");

			// Enter the data in the Incident Cause field
			type("ohs_incident_incidentcausetxt_CSS", data.get("incident_cause"));
			ngDriver.waitForAngularRequestsToFinish();
			System.out.println("Entered the data in the Incident Cause field.");

			// scroll down the screen
			js.executeScript("window.scrollBy(0,400)");

			// Enter the data in the Actions Taken field
			type("ohs_incident_actionstakentxt_CSS", data.get("actions_taken"));
			ngDriver.waitForAngularRequestsToFinish();
			System.out.println("Entered the data in the Actions Taken field.");

			// click on the next button
			click("ohs_incident_nextbtn_CSS");
			System.out.println("Clicked on the next button.");
			ngDriver.waitForAngularRequestsToFinish();

			// synchronization
			explicitWait("ohs_incident_personsinvolved_addbtn_CSS");
			System.out.println("Navigate to the Persons Involved Tab.");
			test.log(LogStatus.INFO, "Navigate to the Persons Involved Tab.");
			Reporter.log("Navigate to the Persons Involved Tab.");
			log.info("Navigate to the Persons Involved Tab.");

			// ADD DETAILS IN THE PERSONS INVOLVED TAB

			System.out.println("********** ADD DETAILS IN THE PERSONS INVOLVED TAB **********");
			test.log(LogStatus.INFO, "********** ADD DETAILS IN THE PERSONS INVOLVED TAB **********");
			Reporter.log("********** ADD DETAILS IN THE PERSONS INVOLVED TAB **********");
			log.info("********** ADD DETAILS IN THE PERSONS INVOLVED TAB **********");

			// click on the add button
			click("ohs_incident_personsinvolved_addbtn_CSS");
			ngDriver.waitForAngularRequestsToFinish();
			System.out.println("Clicked on the add button");

			// select an employee option from the type dropdown
			select("ohs_incident_typedd_CSS", data.get("person_type"));
			ngDriver.waitForAngularRequestsToFinish();
			System.out.println("Selected an employee option from the type dropdown.");

			// enter data in the Insurance Company Name field
			type("ohs_incident_insurancecompanynametxt_CSS", data.get("insurance_policy_number"));
			ngDriver.waitForAngularRequestsToFinish();
			System.out.println("Entered data in the Insurance Company Name field.");

			// enter data in the Insurance Policy Number field
			type("ohs_incident_insurancepolicynumbertxt_CSS", data.get("insurance_policy_number"));
			ngDriver.waitForAngularRequestsToFinish();
			System.out.println("Entered data in the Insurance Policy Number field.");

			// click on the Is this person injured? checkbox
			click("ohs_incident_personinjuredckbx_CSS");
			ngDriver.waitForAngularRequestsToFinish();
			System.out.println("Clicked on the Is this person injured? checkbox.");

			// scroll down the screen
			js.executeScript("window.scrollBy(0,600)");

//			// select the reported option from the injury status dropdown
//			select("ohs_incident_injurystatusdd_CSS", data.get("injury_status"));
//			ngDriver.waitForAngularRequestsToFinish();
//			System.out.println("Selected the reported option from the injury status dropdown.");

			// enter data in the first name field
			type("ohs_incident_personfirstnametxt_CSS", data.get("person_first_name"));
			ngDriver.waitForAngularRequestsToFinish();
			System.out.println("Entered data in the first name field.");

			// enter data in the last name field
			type("ohs_incident_personlastnametxt_CSS", data.get("person_last_name"));
			ngDriver.waitForAngularRequestsToFinish();
			System.out.println("Entered data in the last name field.");

			// enter data in the job title
			type("ohs_incident_personjobtitletxt_CSS", data.get("job_title"));
			ngDriver.waitForAngularRequestsToFinish();
			System.out.println("enter data in the job title");

			// enter data in the email field
			type("ohs_incident_personemailtxt_CSS", data.get("person_email"));
			ngDriver.waitForAngularRequestsToFinish();
			System.out.println("Entered data in the email field.");

			// enter data in the phone number field
			type("ohs_incident_personphonenumbertxt_CSS", "9876543210");
			ngDriver.waitForAngularRequestsToFinish();
			System.out.println("Entered data in the phone number field.");

			// enter data in the manager name field
			type("ohs_incident_managernametxt_CSS", data.get("manager_name"));
			ngDriver.waitForAngularRequestsToFinish();
			System.out.println("Entered data in the manager name field.");

			// enter data in the manager email field
			type("ohs_incident_manageremailtxt_CSS", data.get("manager_email"));
			ngDriver.waitForAngularRequestsToFinish();
			System.out.println("Entered data in the manager email field.");

			// ADD DETAILS IN THE NATURE OF INJURY TAB

			System.out.println("********** ADD DETAILS IN THE NATURE OF INJURY TAB **********");
			test.log(LogStatus.INFO, "********** ADD DETAILS IN THE NATURE OF INJURY TAB **********");
			Reporter.log("********** ADD DETAILS IN THE NATURE OF INJURY TAB **********");
			log.info("********** ADD DETAILS IN THE NATURE OF INJURY TAB **********");

			// scroll up the screen
			js.executeScript("window.scrollBy(0,-600)");

			// click on the nature of injury tab
			click("ohs_incident_natureofinjurytab_CSS");
			ngDriver.waitForAngularRequestsToFinish();
			System.out.println("Clicked on the nature of injury tab.");

			// click on the abdomen checkbox
			click("ohs_incident_abdomenckbx_CSS");
			ngDriver.waitForAngularRequestsToFinish();
			System.out.println("Clicked on the abdomen checkbox.");

			// click on the left hand checkbox
			click("ohs_incident_lefthandckbx_CSS");
			ngDriver.waitForAngularRequestsToFinish();
			System.out.println("Clicked on the left hand checkbox.");

			// click on the psychological checkbox
			click("ohs_incident_psychologicalckbx_CSS");
			ngDriver.waitForAngularRequestsToFinish();
			System.out.println("Clicked on the psychological checkbox.");

			// click on the right shoulder checkbox
			click("ohs_incident_rightshoulderckbx_CSS");
			ngDriver.waitForAngularRequestsToFinish();
			System.out.println("Clicked on the right shoulder checkbox.");

			// ADD DETAILS IN THE CAUSE OF INJURY TAB

			System.out.println("********** ADD DETAILS IN THE CAUSE OF INJURY TAB **********");
			test.log(LogStatus.INFO, "********** ADD DETAILS IN THE CAUSE OF INJURY TAB **********");
			Reporter.log("********** ADD DETAILS IN THE CAUSE OF INJURY TAB **********");
			log.info("********** ADD DETAILS IN THE CAUSE OF INJURY TAB **********");

			// click on the causes of injury tab
			click("ohs_incident_causeofinjurytab_CSS");
			ngDriver.waitForAngularRequestsToFinish();
			System.out.println("Clicked on the causes of injury tab.");

			try {

//				// wait for the element
//				explicitWaitClickable("questionnaire_checklist_switchtowizard_CSS");
//
//				// click on the switch to wizard mode
//				click("questionnaire_checklist_switchtowizard_CSS");
//				ngDriver.waitForAngularRequestsToFinish();
//				System.out.println("Clicked on the switch to wizard mode.");

				// wait for the element
				explicitWaitClickable("ohs_incident_causeofinjury_animaloption_XPATH");

				// click on the first option of the causes of injury
				click("ohs_incident_causeofinjury_animaloption_XPATH");
				ngDriver.waitForAngularRequestsToFinish();
				System.out.println("Clicked on the first option of the causes of injury.");

			} catch (Throwable t) {

				TestUtil.captureScreenshot();

				// ReportNG
				Reporter.log("<br>" + "The checklists are not displayed in classic mode. : " + "<br>");
				Reporter.log("<a target=\"_blank\" href=" + TestUtil.screenshotName + "><img src="
						+ TestUtil.screenshotName + " height=200 width=200></img></a>");
				Reporter.log("<br>");
				Reporter.log("<br>");

				// Extent Report
				test.log(LogStatus.FAIL, " The checklists are not displayed in classic mode. : ");
				test.log(LogStatus.FAIL, test.addScreenCapture(TestUtil.screenshotName));

				System.out.println("The checklists are not displayed in classic mode.");
				log.info("The checklists are not displayed in classic mode.");

			}

//			// ADD DETAILS IN THE HR TAB
//
//			System.out.println("********** ADD DETAILS IN THE HR TAB **********");
//			test.log(LogStatus.INFO, "********** ADD DETAILS IN THE HR TAB **********");
//			Reporter.log("********** ADD DETAILS IN THE HR TAB **********");
//			log.info("********** ADD DETAILS IN THE HR TAB **********");
//
//			// click on the HR tab
//			click("ohs_incident_hrtab_CSS");
//			ngDriver.waitForAngularRequestsToFinish();
//			System.out.println("Clicked on the HR Tab.");
//
//			// select open option from the employee injury status
//			select("ohs_incident_hrtab_employeeinjurystatusdd_CSS", data.get("employee_injury_status"));
//			ngDriver.waitForAngularRequestsToFinish();
//			System.out.println("Selected open option from the employee injury status");

			// scroll down the screen
			js.executeScript("window.scrollBy(0,400)");

			// click on the save button
			click("ohs_incident_causesofinjurytab_savebtn_CSS");
			ngDriver.waitForAngularRequestsToFinish();
			System.out.println("Clicked on the save button.");

			// verify added person involved details are displayed or not
			switchVerification("ohs_incident_addedpersoninvolved1_XPATH", "Employee", "The Employee is not displayed.");

			// click on the next button
			click("ohs_incident_nextbtn_CSS");
			System.out.println("Clicked on the next button.");
			ngDriver.waitForAngularRequestsToFinish();

			// synchronization
			explicitWait("ohs_incident_nextbtn_CSS");
			System.out.println("Navigate to the Witnesses Tab.");
			test.log(LogStatus.INFO, "Navigate to the Witnesses Tab.");
			Reporter.log("Navigate to the Witnesses Tab.");
			log.info("Navigate to the Witnesses Tab.");

			// ADD DETAILS IN THE WITNESSES TAB

			System.out.println("********** ADD DETAILS IN THE WITNESSES TAB **********");
			test.log(LogStatus.INFO, "********** ADD DETAILS IN THE WITNESSES TAB **********");
			Reporter.log("********** ADD DETAILS IN THE WITNESSES TAB **********");
			log.info("********** ADD DETAILS IN THE WITNESSES TAB **********");

//			// click on the witnesses tab
//			click("ohs_incident_witnessestab_CSS");
//			ngDriver.waitForAngularRequestsToFinish();
//			System.out.println("Clicked on the witnesses tab.");

			// click on the add button
			click("ohs_incident_witnessestab_addbtn_CSS");
			ngDriver.waitForAngularRequestsToFinish();
			System.out.println("Clicked on the add button.");

			// enter data in the first name field
			type("ohs_incident_personfirstnametxt_CSS", data.get("witness_first_name"));
			ngDriver.waitForAngularRequestsToFinish();
			System.out.println("Entered data in the first name field.");

			// enter data in the last name field
			type("ohs_incident_personlastnametxt_CSS", data.get("witness_last_name"));
			ngDriver.waitForAngularRequestsToFinish();
			System.out.println("Entered data in the last name field.");

			// enter data in the phone number field
			type("ohs_incident_personphonenumbertxt_CSS", "9988776655");
			ngDriver.waitForAngularRequestsToFinish();
			System.out.println("Entered data in the phone number field.");

			// scroll down the screen
			js.executeScript("window.scrollBy(0,600)");

			// enter data in the address one field
			type("ohs_incident_addressone_CSS", data.get("address_1"));
			ngDriver.waitForAngularRequestsToFinish();
			System.out.println("Entered data in the address one field.");

			// enter data in the address two field
			type("ohs_incident_addresstwo_CSS", data.get("address_2"));
			ngDriver.waitForAngularRequestsToFinish();
			System.out.println("Entered data in the address two field.");

			// enter data in the city field
			type("ohs_incident_citytxt_CSS", data.get("city"));
			ngDriver.waitForAngularRequestsToFinish();
			System.out.println("Entered data in the city field.");

			// enter data in the province field
			type("ohs_incident_provincetxt_CSS", data.get("province"));
			ngDriver.waitForAngularRequestsToFinish();
			System.out.println("Entered data in the province field.");

			// enter data in the country field
			type("ohs_incident_countrytxt_CSS", data.get("country"));
			ngDriver.waitForAngularRequestsToFinish();
			System.out.println("Entered data in the country field.");

			// enter data in the postal code field
			type("ohs_incident_postalcodetxt_CSS", "968574");
			ngDriver.waitForAngularRequestsToFinish();
			System.out.println("Entered data in the country field.");

			// enter data in the description field
			type("ohs_incident_descriptiontxt_CSS", data.get("short_description"));
			ngDriver.waitForAngularRequestsToFinish();
			System.out.println("Entered data in the description field.");

			// click on the save button
			click("ohs_incident_witnessestab_savebtn_CSS");
			ngDriver.waitForAngularRequestsToFinish();
			System.out.println("Clicked on the save button.");

			// scroll down the screen
			js.executeScript("window.scrollBy(0,-600)");

			// verify added witness details are displayed or not
			switchVerification("ohs_incident_addedwitness1_XPATH", "Witness", "The Witness is not displayed.");

			// click on the next button
			click("ohs_incident_nextbtn_CSS");
			System.out.println("Clicked on the next button.");
			ngDriver.waitForAngularRequestsToFinish();

			// synchronization
			explicitWait("ohs_incident_nextbtn_CSS");
			System.out.println("Navigate to the emergency services Tab.");
			test.log(LogStatus.INFO, "Navigate to the emergency services Tab.");
			Reporter.log("Navigate to the emergency services Tab.");
			log.info("Navigate to the emergency services Tab.");

			// ADD DETAILS IN THE EMERGENCY SERVICES TAB

			System.out.println("********** ADD DETAILS IN THE EMERGENCY SERVICES TAB **********");
			test.log(LogStatus.INFO, "********** ADD DETAILS IN THE EMERGENCY SERVICES TAB **********");
			Reporter.log("********** ADD DETAILS IN THE EMERGENCY SERVICES TAB **********");
			log.info("********** ADD DETAILS IN THE EMERGENCY SERVICES TAB **********");

//			// click on the emergency services tab
//			click("ohs_incident_emergencyservicestab_CSS");
//			ngDriver.waitForAngularRequestsToFinish();
//			System.out.println("Clicked on the emergency services.");

			// click on the add button
			click("ohs_incident_emergencyservicestab_addbtn_CSS");
			ngDriver.waitForAngularRequestsToFinish();
			System.out.println("Clicked on the add button.");

			// select the data from the type dropdown
			select("ohs_incident_contacttypedd_CSS", data.get("contacttype"));
			ngDriver.waitForAngularRequestsToFinish();
			System.out.println("Selected the data from the type dropdown.");

			// enter data in the description field
			type("ohs_incident_descriptiontxt_CSS", data.get("short_description"));
			ngDriver.waitForAngularRequestsToFinish();
			System.out.println("Entered data in the description field.");

			// click on the save button
			click("ohs_incident_emergencyservicestab_savebtn_CSS");
			ngDriver.waitForAngularRequestsToFinish();
			System.out.println("Clicked on the save button.");

			// verify added emergency services details are displayed or not
			switchVerification("ohs_incident_addedemergencyservices_XPATH", "Ambulance",
					"The Ambulance is not displayed.");

			// click on the next button
			click("ohs_incident_nextbtn_CSS");
			System.out.println("Clicked on the next button.");
			ngDriver.waitForAngularRequestsToFinish();

			// synchronization
			explicitWait("ohs_incident_nextbtn_CSS");
			System.out.println("Navigate to the property damage Tab.");
			test.log(LogStatus.INFO, "Navigate to the property damage Tab.");
			Reporter.log("Navigate to the property damage Tab.");
			log.info("Navigate to the property damage Tab.");

			// ADD DETAILS IN THE PROPERTY DAMAGE TAB

			System.out.println("********** ADD DETAILS IN THE PROPERTY DAMAGE TAB **********");
			test.log(LogStatus.INFO, "********** ADD DETAILS IN THE PROPERTY DAMAGE TAB **********");
			Reporter.log("********** ADD DETAILS IN THE PROPERTY DAMAGE TAB **********");
			log.info("********** ADD DETAILS IN THE PROPERTY DAMAGE TAB **********");

//			// click on the property damage tab
//			click("ohs_incident_propertydamagetab_CSS");
//			ngDriver.waitForAngularRequestsToFinish();
//			System.out.println("Clicked on the property damage tab.");

			// click on the add button
			click("ohs_incident_propertydamagetab_addbtn_CSS");
			ngDriver.waitForAngularRequestsToFinish();
			System.out.println("Clicked on the add button.");

			// enter data in the nature of damage field
			type("ohs_incident_natureofdamagetxt_CSS", data.get("nature_of_damage"));
			ngDriver.waitForAngularRequestsToFinish();
			System.out.println("Entered data in the nature of damage field.");

			// scroll down the screen
			js.executeScript("window.scrollBy(0,400)");

			// select data from the Estimated Cost of Repairs field
			select("ohs_incident_estimatedcostofrepairsdd_CSS", data.get("estimated_cost_of_repairs"));
			ngDriver.waitForAngularRequestsToFinish();
			System.out.println("Selected data from the Estimated Cost of Repairs.");

			// enter data in the Insurance Company Name field
			type("ohs_incident_propertydamagetab_insurancecompanynametxt_CSS", data.get("insurance_company_name_2"));
			ngDriver.waitForAngularRequestsToFinish();
			System.out.println("Entered data in the Insurance Company Name field.");

			// enter data in the Insurance Policy Number field
			type("ohs_incident_propertydamagetab_insurancepolicynumbertxt_CSS", data.get("insurance_policy_number2"));
			ngDriver.waitForAngularRequestsToFinish();
			System.out.println("Entered data in the Insurance Policy Number field.");

			// click on the save button
			click("ohs_incident_propertydamagetab_savebtn_CSS");
			ngDriver.waitForAngularRequestsToFinish();
			System.out.println("Clicked on the save button.");

			// verify added property damage details are displayed or not
			switchVerification("ohs_incident_addedpropertydamage_XPATH", "Add Nature Of Damage Test",
					"The Add Nature Of Damage Test is not displayed.");

			// click on the next button
			click("ohs_incident_nextbtn_CSS");
			System.out.println("Clicked on the next button.");
			ngDriver.waitForAngularRequestsToFinish();

			// synchronization
			explicitWait("ohs_incident_nextbtn_CSS");
			System.out.println("Navigate to the insurance Tab.");
			test.log(LogStatus.INFO, "Navigate to the insurance Tab.");
			Reporter.log("Navigate to the insurance Tab.");
			log.info("Navigate to the insurance Tab.");

			// ADD DETAILS IN THE INSURANCE TAB

			System.out.println("********** ADD DETAILS IN THE INSURANCE TAB **********");
			test.log(LogStatus.INFO, "********** ADD DETAILS IN THE INSURANCE TAB **********");
			Reporter.log("********** ADD DETAILS IN THE INSURANCE TAB **********");
			log.info("********** ADD DETAILS IN THE INSURANCE TAB **********");

//			// click on the insurance tab
//			click("ohs_incident_insurancetab_CSS");
//			ngDriver.waitForAngularRequestsToFinish();
//			System.out.println("Clicked on the insurance tab.");

			// click on the add button
			click("ohs_incident_insurancetab_addbtn_CSS");
			ngDriver.waitForAngularRequestsToFinish();
			System.out.println("Clicked on the add button.");

			// enter data in the company name field
			type("ohs_incident_insurance_companynametxt_CSS", data.get("company_name"));
			ngDriver.waitForAngularRequestsToFinish();
			System.out.println("Entered data in the company name field.");

			// enter data in the Claim Number field
			type("ohs_incident_insurance_claimnumbertxt_CSS", data.get("claim_number"));
			ngDriver.waitForAngularRequestsToFinish();
			System.out.println("Entered data in the Claim Number field.");

			// scroll down the screen
			js.executeScript("window.scrollBy(0,600)");

			// select data from the Status drop down
			select("ohs_incident_insurance_statusdd_CSS", data.get("insurance_status"));
			ngDriver.waitForAngularRequestsToFinish();
			System.out.println("Entered data in the Status drop down.");

			// select data from the type drop down
			select("ohs_incident_insurance_typedd_CSS", data.get("insurance_type"));
			ngDriver.waitForAngularRequestsToFinish();
			System.out.println("Entered data in the type drop down.");

			// click on the notification date field
			click("ohs_incident_insurance_notificationdate_CSS");
			ngDriver.waitForAngularRequestsToFinish();
			System.out.println("Clicked on the notification date field.");

			// click on the today button
			click("ohs_incident_insurance_notificationdate_todayduedatebtn_XPATH");
			ngDriver.waitForAngularRequestsToFinish();
			System.out.println("Clicked on the today button.");

			// enter data in the Policy Number field
			type("ohs_incident_insurance_policynumbertxt_CSS", data.get("insurance_policy_number"));
			ngDriver.waitForAngularRequestsToFinish();
			System.out.println("Entered data in the Policy Number field.");

			// enter data in the loss description field
			type("ohs_incident_insurance_lossdescription_CSS", data.get("short_description"));
			ngDriver.waitForAngularRequestsToFinish();
			System.out.println("Entered data in the loss description field.");

			// click on the save button
			click("ohs_incident_insurancetab_savebtn_CSS");
			ngDriver.waitForAngularRequestsToFinish();
			System.out.println("Clicked on the save button.");

			// verify added insurance details are displayed or not
			switchVerification("ohs_incident_addedinsurance_XPATH", "Add Company Name Test",
					"The Add Company Name Test is not displayed.");

			// ADD DETAILS IN THE ATTACHMENTS TAB

			System.out.println("********** ADD DETAILS IN THE ATTACHMENTS TAB **********");
			test.log(LogStatus.INFO, "********** ADD DETAILS IN THE ATTACHMENTS TAB **********");
			Reporter.log("********** ADD DETAILS IN THE ATTACHMENTS TAB **********");
			log.info("********** ADD DETAILS IN THE ATTACHMENTS TAB **********");

			// click on the next button
			click("ohs_incident_nextbtn_CSS");
			System.out.println("Clicked on the next button.");
			ngDriver.waitForAngularRequestsToFinish();

			// synchronization
			explicitWait("ohs_incident_updaterecordbtn_CSS");
			System.out.println("Navigate to the attachments Tab.");
			test.log(LogStatus.INFO, "Navigate to the attachments Tab.");
			Reporter.log("Navigate to the attachments Tab.");
			log.info("Navigate to the attachments Tab.");

			// click on the update record button
			click("ohs_incident_updaterecordbtn_CSS");
			ngDriver.waitForAngularRequestsToFinish();
			System.out.println("The update record button clicked successfully");

			// wait for the element
			explicitWaitClickable("ohs_incident_search_clearbtn_XPATH");

			// click on the clear button
			click("ohs_incident_search_clearbtn_XPATH");
			ngDriver.waitForAngularRequestsToFinish();
			System.out.println("Clicked on the clear button.");

			// enter the newly created incident report in the search field
			type("ohs_incident_searchtxt_CSS", data.get("describe_incident"));
			System.out.println("Entered the newly created incident report in the search field.");
			ngDriver.waitForAngularRequestsToFinish();

			// click on the search button
			click("ohs_incident_search_searchbtn_CSS");
			ngDriver.waitForAngularRequestsToFinish();
			System.out.println("Clicked on the search button.");

			// verification of the incident report is added or not
			switchVerification("ohs_incident_addedincidentreport2_XPATH",
					"Describe Incident Text Dashboard Testing Purpose",
					"The Describe Incident Text Dashboard Testing Purpose is not displayed successfully.");
		} catch (Throwable t) {

			verificationFailed();
		}

		// click on the home icon from the top of the screen
		click("questionnaire_homeburgermenubtn_hide_CSS");
		System.out.println("Clicked on the home icon from the top of the screen.");
		ngDriver.waitForAngularRequestsToFinish();

		// synchronization
		explicitWait("propertylist_title_XPATH");

		// verify the property list
		switchVerification("propertylist_title_XPATH", "Property List", "The property list is not displayed.");

		try {

			// wait for the element
			explicitWaitClickable("menubtn_CSS");

			// click on the side menu icon
			click("menubtn_CSS");
			ngDriver.waitForAngularRequestsToFinish();
			System.out.println("Clicked on the side menu icon.");

			// wait for the element
			explicitWaitClickable("sidemenu_occupationalhealthandsafety_CSS");

			// click on the OHS option from side menu
			click("sidemenu_occupationalhealthandsafety_CSS");
			ngDriver.waitForAngularRequestsToFinish();
			System.out.println("Clicked on the OHS option from side menu.");

			// VERIFY NEWLY CREATED INCIDENT REPORT ON EHS INCIDENT DASHBOARD

			System.out.println("********** VERIFY NEWLY CREATED INCIDENT REPORT ON EHS INCIDENT DASHBOARD **********");
			test.log(LogStatus.INFO,
					"********** VERIFY NEWLY CREATED INCIDENT REPORT ON EHS INCIDENT DASHBOARD **********");
			Reporter.log("********** VERIFY NEWLY CREATED INCIDENT REPORT ON EHS INCIDENT DASHBOARD **********");
			log.info("********** VERIFY NEWLY CREATED INCIDENT REPORT ON EHS INCIDENT DASHBOARD **********");

			try {

				// wait for the element
				explicitWait("dashboard_CSS");

				// select the EHS Incident from the dashboard screen
				select("dashboard_CSS", data.get("ehs_incidents"));
				ngDriver.waitForAngularRequestsToFinish();
				System.out.println("Selected the EHS Incident from the dashboard screen.");

				// wait for the element
				Thread.sleep(5000);

				LocalDate currentDate = LocalDate.now();
				String currentDateText = currentDate.toString();

				String incidentReport = "//tr[@ng-click='editReport(report)']//td[text()='" + insuranceNumber
						+ "']//following-sibling::td[text()='" + currentDateText + "']";

				System.out.println("incidentReport::::::::::::::::::::" + incidentReport);

				boolean str = driver.findElement(By.xpath(incidentReport)).isDisplayed();
				if (str == true) {
					System.out.println("The newly created incident report is verified successfully.");
					test.log(LogStatus.INFO, "The newly created incident report is verified successfully.");
					Reporter.log("The newly created incident report is verified successfully.");
					log.info("The newly created incident report is verified successfully.");
				} else {
					TestUtil.captureScreenshot();

					// ReportNG
					Reporter.log("<br>" + "Verification failure : " + "<br>");
					Reporter.log("<a target=\"_blank\" href=" + TestUtil.screenshotName + "><img src="
							+ TestUtil.screenshotName + " height=200 width=200></img></a>");
					Reporter.log("<br>");
					Reporter.log("<br>");

					// Extent Report
					test.log(LogStatus.FAIL, " Verification failed with exception : ");
					test.log(LogStatus.FAIL, test.addScreenCapture(TestUtil.screenshotName));

					System.out.println("The newly created incident report is not verified.");
					log.info("The newly created incident report is not verified.");
				}

			} catch (Throwable t) {
				TestUtil.captureScreenshot();

				// ReportNG
				Reporter.log("<br>" + "Verification failure : " + "<br>");
				Reporter.log("<a target=\"_blank\" href=" + TestUtil.screenshotName + "><img src="
						+ TestUtil.screenshotName + " height=200 width=200></img></a>");
				Reporter.log("<br>");
				Reporter.log("<br>");

				// Extent Report
				test.log(LogStatus.FAIL, " Verification failed with exception : ");
				test.log(LogStatus.FAIL, test.addScreenCapture(TestUtil.screenshotName));

				System.out.println("The newly created incident report is not verified.");
				log.info("The newly created incident report is not verified.");
			}

			// VERIFY NEWLY CREATED INCIDENT REPORT ON HR INCIDENT DASHBOARD

			System.out.println("********** VERIFY NEWLY CREATED INCIDENT REPORT ON HR INCIDENT DASHBOARD **********");
			test.log(LogStatus.INFO,
					"********** VERIFY NEWLY CREATED INCIDENT REPORT ON HR INCIDENT DASHBOARD **********");
			Reporter.log("********** VERIFY NEWLY CREATED INCIDENT REPORT ON HR INCIDENT DASHBOARD **********");
			log.info("********** VERIFY NEWLY CREATED INCIDENT REPORT ON HR INCIDENT DASHBOARD **********");

			try {
				// select the HR Incident from the dashboard screen
				select("dashboard_CSS", data.get("hr_incidents"));
				ngDriver.waitForAngularRequestsToFinish();
				System.out.println("Selected the HR Incident from the dashboard screen.");

				// wait for the element
				Thread.sleep(5000);

				LocalDate currentDate = LocalDate.now();
				String currentDateText = currentDate.toString();

				String incidentReport1 = "//tr[@ng-click='editReport(report)']//td[text()='" + insuranceNumber
						+ "']//following-sibling::td[text()='" + currentDateText + "']";

				System.out.println("incidentReport1::::::::::::::::::::" + incidentReport1);

				boolean str2 = driver.findElement(By.xpath(incidentReport1)).isDisplayed();
				if (str2 == true) {

					System.out.println("The newly created incident report is verified successfully.");
					test.log(LogStatus.INFO, "The newly created incident report is verified successfully.");
					Reporter.log("The newly created incident report is verified successfully.");
					log.info("The newly created incident report is verified successfully.");
				} else {
					TestUtil.captureScreenshot();

					// ReportNG
					Reporter.log("<br>" + "Verification failure : " + "<br>");
					Reporter.log("<a target=\"_blank\" href=" + TestUtil.screenshotName + "><img src="
							+ TestUtil.screenshotName + " height=200 width=200></img></a>");
					Reporter.log("<br>");
					Reporter.log("<br>");

					// Extent Report
					test.log(LogStatus.FAIL, " Verification failed with exception : ");
					test.log(LogStatus.FAIL, test.addScreenCapture(TestUtil.screenshotName));

					System.out.println("The newly created incident report is not verified.");
					log.info("The newly created incident report is not verified.");
				}

			} catch (Throwable t) {
				TestUtil.captureScreenshot();

				// ReportNG
				Reporter.log("<br>" + "Verification failure : " + "<br>");
				Reporter.log("<a target=\"_blank\" href=" + TestUtil.screenshotName + "><img src="
						+ TestUtil.screenshotName + " height=200 width=200></img></a>");
				Reporter.log("<br>");
				Reporter.log("<br>");

				// Extent Report
				test.log(LogStatus.FAIL, " Verification failed with exception : ");
				test.log(LogStatus.FAIL, test.addScreenCapture(TestUtil.screenshotName));

				System.out.println("The newly created incident report is not verified.");
				log.info("The newly created incident report is not verified.");
			}

			// VERIFY NEWLY CREATED INCIDENT REPORT ON INSURANCE INCIDENT DASHBOARD

			System.out.println(
					"********** VERIFY NEWLY CREATED INCIDENT REPORT ON INSURANCE INCIDENT DASHBOARD **********");
			test.log(LogStatus.INFO,
					"********** VERIFY NEWLY CREATED INCIDENT REPORT ON INSURANCE INCIDENT DASHBOARD **********");
			Reporter.log("********** VERIFY NEWLY CREATED INCIDENT REPORT ON INSURANCE INCIDENT DASHBOARD **********");
			log.info("********** VERIFY NEWLY CREATED INCIDENT REPORT ON INSURANCE INCIDENT DASHBOARD **********");

			try {
				// wait for the element
				explicitWait("dashboard_CSS");

				// select the Insurance Incident from the dashboard screen
				select("dashboard_CSS", data.get("insurance_incidents"));
				ngDriver.waitForAngularRequestsToFinish();
				System.out.println("Selected the Insurance Incident from the dashboard screen.");

				// wait for the element
				Thread.sleep(5000);

				LocalDate currentDate = LocalDate.now();
				String currentDateText = currentDate.toString();

				String incidentReport2 = "//tr[@ng-click='editReport(report)']//td[text()='" + insuranceNumber
						+ "']//following-sibling::td[text()='" + currentDateText + "']";

				System.out.println("incidentReport2::::::::::::::::::::" + incidentReport2);

				boolean str3 = driver.findElement(By.xpath(incidentReport2)).isDisplayed();
				if (str3 == true) {

					System.out.println("The newly created incident report is verified successfully.");
					test.log(LogStatus.INFO, "The newly created incident report is verified successfully.");
					Reporter.log("The newly created incident report is verified successfully.");
					log.info("The newly created incident report is verified successfully.");
				} else {
					TestUtil.captureScreenshot();

					// ReportNG
					Reporter.log("<br>" + "Verification failure : " + "<br>");
					Reporter.log("<a target=\"_blank\" href=" + TestUtil.screenshotName + "><img src="
							+ TestUtil.screenshotName + " height=200 width=200></img></a>");
					Reporter.log("<br>");
					Reporter.log("<br>");

					// Extent Report
					test.log(LogStatus.FAIL, " Verification failed with exception : ");
					test.log(LogStatus.FAIL, test.addScreenCapture(TestUtil.screenshotName));

					System.out.println("The newly created incident report is not verified.");
					log.info("The newly created incident report is not verified.");
				}

			} catch (Throwable t) {
				TestUtil.captureScreenshot();

				// ReportNG
				Reporter.log("<br>" + "Verification failure : " + "<br>");
				Reporter.log("<a target=\"_blank\" href=" + TestUtil.screenshotName + "><img src="
						+ TestUtil.screenshotName + " height=200 width=200></img></a>");
				Reporter.log("<br>");
				Reporter.log("<br>");

				// Extent Report
				test.log(LogStatus.FAIL, " Verification failed with exception : ");
				test.log(LogStatus.FAIL, test.addScreenCapture(TestUtil.screenshotName));

				System.out.println("The newly created incident report is not verified.");
				log.info("The newly created incident report is not verified.");
			}

		} catch (Throwable t) {
			verificationFailed();
		}

		// click on the home icon from the top of the screen
		click("questionnaire_homeburgermenubtn_hide_CSS");
		System.out.println("Clicked on the home icon from the top of the screen.");
		ngDriver.waitForAngularRequestsToFinish();

		// synchronization
		explicitWait("propertylist_title_XPATH");

		// verify the property list
		switchVerification("propertylist_title_XPATH", "Property List", "The property list is not displayed.");

		// DELETE DETAILS IN THE INCIDENT REPORT

		System.out.println("********** DELETE DETAILS IN THE INCIDENT REPORT **********");
		test.log(LogStatus.INFO, "********** DELETE DETAILS IN THE INCIDENT REPORT **********");
		Reporter.log("********** DELETE DETAILS IN THE INCIDENT REPORT **********");
		log.info("********** DELETE DETAILS IN THE INCIDENT REPORT **********");

		try {
			// click on the OHS icon from the property list page
			click("ohsicon_CSS");
			System.out.println("Clicked on the OHS icon of the Property.");
			ngDriver.waitForAngularRequestsToFinish();
			System.out.println("Navigate to the OHS screen of the perticular property.");

			// click on the burger menu
			click("menubtn_CSS");
			System.out.println("Clicked on the burger menu button successfully!!!");
			ngDriver.waitForAngularRequestsToFinish();

			// wait for the element
			explicitWaitClickable("questionnaire_option_ohstab_incidentreports_XPATH");

			// click on the incident reports
			click("questionnaire_option_ohstab_incidentreports_XPATH");
			System.out.println("Clicked on the incident reports option.");
			ngDriver.waitForAngularRequestsToFinish();

			// click on the newly created incident report
			click("ohs_incident_addedincidentreport2_XPATH");
			System.out.println("Clicked on the newly created incident report.");
			ngDriver.waitForAngularRequestsToFinish();
			System.out.println("Naviagte to the Update Incident record Screen.");

			// wait for the element
			Thread.sleep(5000);

			// click on the delete button
			click("ohs_incident_deletebtn_CSS");
			ngDriver.waitForAngularRequestsToFinish();
			System.out.println("Clicked on the delete button.");

			// wait for the element
			explicitWaitClickable("ohs_incident_confirmdeletebtn_CSS");

			// click on the delete button of confirmation popup
			click("ohs_incident_confirmdeletebtn_CSS");
			ngDriver.waitForAngularRequestsToFinish();
			System.out.println("Clicked on the delete button of confirmation popup.");

			// wait for the element
			explicitWaitClickable("ohs_incident_search_clearbtn_XPATH");

			// click on the clear button
			click("ohs_incident_search_clearbtn_XPATH");
			ngDriver.waitForAngularRequestsToFinish();
			System.out.println("Clicked on the clear button.");

			// enter the newly created incident report in the search field
			type("ohs_incident_searchtxt_CSS", data.get("describe_incident"));
			System.out.println("Entered the newly created incident report in the search field.");
			ngDriver.waitForAngularRequestsToFinish();

			// click on the search button
			click("ohs_incident_search_searchbtn_CSS");
			ngDriver.waitForAngularRequestsToFinish();
			System.out.println("Clicked on the search button.");

			// verify details are deleted or not
			helper.deleteVerification("ohs_incident_addedincidentreport2_XPATH",
					"Describe Incident Text Dashboard Testing Purpose");

		} catch (Throwable t) {
			verificationFailed();
		}

		// click on the home icon from the top of the screen
		click("questionnaire_homeburgermenubtn_hide_CSS");
		System.out.println("Clicked on the home icon from the top of the screen.");
		ngDriver.waitForAngularRequestsToFinish();

		// synchronization
		explicitWait("propertylist_title_XPATH");

		// verify the property list
		switchVerification("propertylist_title_XPATH", "Property List", "The property list is not displayed.");

		// VERIFY DELETED INCIDENT REPORT ON EHS INCIDENT DASHBOARD

		title("VERIFY DELETED INCIDENT REPORT ON EHS INCIDENT DASHBOARD");

		try {

			// wait for the element
			Thread.sleep(5000);

			// click on the side menu icon
			click("menubtn_CSS");
			ngDriver.waitForAngularRequestsToFinish();
			System.out.println("Clicked on the side menu icon.");

			// wait for the element
			Thread.sleep(5000);

			// click on the OHS option from side menu
			click("sidemenu_occupationalhealthandsafety_CSS");
			ngDriver.waitForAngularRequestsToFinish();
			System.out.println("Clicked on the OHS option from side menu.");

			// wait for the element
			explicitWait("dashboard_CSS");

			// select the EHS Incident from the dashboard screen
			select("dashboard_CSS", data.get("ehs_incidents"));
			ngDriver.waitForAngularRequestsToFinish();
			System.out.println("Selected the EHS Incident from the dashboard screen.");

			// wait for the element
			Thread.sleep(5000);

			// filter the respective incident report
			type("ohs_incident_dashboardfilter_XPATH", insuranceNumber);
			ngDriver.waitForAngularRequestsToFinish();
			System.out.println("Filtered the respective incident report.");

			// hit the enter key
			driver.findElement(By.xpath(OR.getProperty("ohs_incident_dashboardfilter_XPATH"))).sendKeys(Keys.ENTER);
			ngDriver.waitForAngularRequestsToFinish();
			System.out.println("Hitted the enter key.");

			// wait for the element
			Thread.sleep(5000);

			LocalDate currentDate = LocalDate.now();
			String currentDateText = currentDate.toString();

			String incidentReport = "//tr[@ng-click='editReport(report)']//td[text()='" + insuranceNumber
					+ "']//following-sibling::td[text()='" + currentDateText + "']";

			try {

				boolean str11 = driver.findElement(By.xpath(incidentReport)).isDisplayed();
				if (str11 == true) {

					verificationFailedMessage("The newly created incident report is displayed after delete.");

				} else {

					successMessage("The newly created incident report is deleted successfully.");

				}

			} catch (Throwable t) {

				successMessage("The newly created incident report is deleted successfully.");

			}

			// VERIFY DELETED INCIDENT REPORT ON HR INCIDENT DASHBOARD

			title("VERIFY DELETED INCIDENT REPORT ON HR INCIDENT DASHBOARD");

			// select the HR Incident from the dashboard screen
			select("dashboard_CSS", data.get("hr_incidents"));
			ngDriver.waitForAngularRequestsToFinish();
			System.out.println("Selected the HR Incident from the dashboard screen.");

			// wait for the element
			Thread.sleep(5000);

			// filter the respective incident report
			type("ohs_incident_dashboardfilter_XPATH", insuranceNumber);
			ngDriver.waitForAngularRequestsToFinish();
			System.out.println("Filtered the respective incident report.");

			// hit the enter key
			driver.findElement(By.xpath(OR.getProperty("ohs_incident_dashboardfilter_XPATH"))).sendKeys(Keys.ENTER);
			ngDriver.waitForAngularRequestsToFinish();
			System.out.println("Hitted the enter key.");

			// wait for the element
			Thread.sleep(5000);

			LocalDate currentDate1 = LocalDate.now();
			String currentDateText1 = currentDate1.toString();

			String incidentReport1 = "//tr[@ng-click='editReport(report)']//td[text()='" + insuranceNumber
					+ "']//following-sibling::td[text()='" + currentDateText1 + "']";

			try {

				boolean str22 = driver.findElement(By.xpath(incidentReport1)).isDisplayed();

				if (str22 == true) {

					verificationFailedMessage("The newly created incident report is displayed after delete.");

				} else {

					successMessage("The newly created incident report is deleted successfully.");

				}

			} catch (Throwable t) {

				successMessage("The newly created incident report is deleted successfully.");

			}

			// VERIFY DELETED INCIDENT REPORT ON INSURANCE INCIDENT DASHBOARD

			title("VERIFY DELETED INCIDENT REPORT ON INSURANCE INCIDENT DASHBOARD");

			// wait for the element
			explicitWait("dashboard_CSS");

			// select the Insurance Incident from the dashboard screen
			select("dashboard_CSS", data.get("insurance_incidents"));
			ngDriver.waitForAngularRequestsToFinish();
			System.out.println("Selected the Insurance Incident from the dashboard screen.");

			// wait for the element
			Thread.sleep(5000);

			// filter the respective incident report
			type("ohs_incident_dashboardfilter_XPATH", insuranceNumber);
			ngDriver.waitForAngularRequestsToFinish();
			System.out.println("Filtered the respective incident report.");

			// hit the enter key
			driver.findElement(By.xpath(OR.getProperty("ohs_incident_dashboardfilter_XPATH"))).sendKeys(Keys.ENTER);
			ngDriver.waitForAngularRequestsToFinish();
			System.out.println("Hitted the enter key.");

			// wait for the element
			Thread.sleep(5000);

			LocalDate currentDate2 = LocalDate.now();
			String currentDateText2 = currentDate2.toString();

			String incidentReport2 = "//tr[@ng-click='editReport(report)']//td[text()='" + insuranceNumber
					+ "']//following-sibling::td[text()='" + currentDateText2 + "']";

			try {

				boolean str33 = driver.findElement(By.xpath(incidentReport2)).isDisplayed();

				if (str33 == true) {

					verificationFailedMessage("The newly created incident report is displayed after delete.");

				} else {

					successMessage("The newly created incident report is deleted successfully.");

				}

			} catch (Throwable t) {

				successMessage("The newly created incident report is deleted successfully.");

			}

		} catch (Throwable t) {
			verificationFailed();
		}

		// click on the home icon from the top of the screen
		click("questionnaire_homeburgermenubtn_hide_CSS");
		System.out.println("Clicked on the home icon from the top of the screen.");
		ngDriver.waitForAngularRequestsToFinish();

		// synchronization
		explicitWait("propertylist_title_XPATH");

		// verify the property list
		switchVerification("propertylist_title_XPATH", "Property List", "The property list is not displayed.");

	}
}
