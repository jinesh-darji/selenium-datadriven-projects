package testcases.E2Etestcasesuite.ohsmodule;

import java.io.IOException;
import java.util.Hashtable;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.testng.Reporter;
import org.testng.SkipException;
import org.testng.annotations.Test;

import com.relevantcodes.extentreports.LogStatus;

import base.Helper;
import base.TestBase;
import utilities.TestUtil;

public class RR5066OHSTest extends TestBase {

	@Test(dataProviderClass = TestUtil.class, dataProvider = "dp")
	public void rR5066OHSTest(Hashtable<String, String> data) throws IOException, InterruptedException {

		execution(data, "rR5066OHSTest");

		// MOVE FEATURE ON INCIDENT LIST SCREEN

		System.out.println("MOVE FEATURE ON INCIDENT LIST SCREEN.");
		test.log(LogStatus.INFO, "MOVE FEATURE ON INCIDENT LIST SCREEN.");
		Reporter.log("MOVE FEATURE ON INCIDENT LIST SCREEN.");
		log.info("MOVE FEATURE ON INCIDENT LIST SCREEN.");

		Helper helper = new Helper();

		// refresh the page
		driver.navigate().refresh();
		Thread.sleep(5000);
		driver.navigate().refresh();

		// ADD THE NEWLY INCIDENT REPORT

		System.out.println("********** ADD THE NEWLY INCIDENT REPORT **********");
		test.log(LogStatus.INFO, "********** ADD THE NEWLY INCIDENT REPORT **********");
		Reporter.log("********** ADD THE NEWLY INCIDENT REPORT **********");
		log.info("********** ADD THE NEWLY INCIDENT REPORT **********");

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

			// click on the add event type button
			click("ohs_incident_addeventtypebtn_CSS");
			System.out.println("Clicked on the add event type button.");
			ngDriver.waitForAngularRequestsToFinish();

			// click on the event type dropdown
			select("ohs_incident_eventtypedd_CSS", data.get("event_type"));
			System.out.println("Clicked on the event type dropdown.");
			ngDriver.waitForAngularRequestsToFinish();

			// click on the add button of the add event type record model
			click("ohs_incident_eventty_addbtn_CSS");
			System.out.println("Clicked on the add button of the add event type record model.");
			ngDriver.waitForAngularRequestsToFinish();

		} catch (Throwable t) {
			verificationFailed();
		}

		try {

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
			JavascriptExecutor js = (JavascriptExecutor) driver;
			js.executeScript("window.scrollBy(0,400)");

			// Enter the data in the Actions Taken field
			type("ohs_incident_actionstakentxt_CSS", data.get("actions_taken"));
			ngDriver.waitForAngularRequestsToFinish();
			System.out.println("Entered the data in the Actions Taken field.");

		} catch (Throwable t) {
			verificationFailed();
		}

		try {

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

			try {
				// click on the add button
				click("ohs_incident_personsinvolved_addbtn_CSS");
				ngDriver.waitForAngularRequestsToFinish();
				System.out.println("Clicked on the add button");

				// select an employee option from the type dropdown
				select("ohs_incident_typedd_CSS", data.get("person_type"));
				ngDriver.waitForAngularRequestsToFinish();
				System.out.println("Selected an employee option from the type dropdown.");

				// enter data in the Insurance Company Name field
				type("ohs_incident_insurancecompanynametxt_CSS", data.get("insurance_company_name"));
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
				JavascriptExecutor js = (JavascriptExecutor) driver;
				js.executeScript("window.scrollBy(0,600)");

//					// select the reported option from the injury status dropdown
//					select("ohs_incident_injurystatusdd_CSS", data.get("injury_status"));
//					ngDriver.waitForAngularRequestsToFinish();
//					System.out.println("Selected the reported option from the injury status dropdown.");

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

			} catch (Throwable t) {
				verificationFailed();

			}

			// ADD DETAILS IN THE NATURE OF INJURY TAB

			System.out.println("********** ADD DETAILS IN THE NATURE OF INJURY TAB **********");
			test.log(LogStatus.INFO, "********** ADD DETAILS IN THE NATURE OF INJURY TAB **********");
			Reporter.log("********** ADD DETAILS IN THE NATURE OF INJURY TAB **********");
			log.info("********** ADD DETAILS IN THE NATURE OF INJURY TAB **********");

			try {
				// scroll up the screen
				JavascriptExecutor js = (JavascriptExecutor) driver;
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

			} catch (Throwable t) {
				verificationFailed();

			}

			// ADD DETAILS IN THE CAUSE OF INJURY TAB

			System.out.println("********** ADD DETAILS IN THE CAUSE OF INJURY TAB **********");
			test.log(LogStatus.INFO, "********** ADD DETAILS IN THE CAUSE OF INJURY TAB **********");
			Reporter.log("********** ADD DETAILS IN THE CAUSE OF INJURY TAB **********");
			log.info("********** ADD DETAILS IN THE CAUSE OF INJURY TAB **********");

			try {
				// click on the causes of injury tab
				click("ohs_incident_causeofinjurytab_CSS");
				ngDriver.waitForAngularRequestsToFinish();
				System.out.println("Clicked on the causes of injury tab.");

				try {

					// wait for the element
					explicitWaitClickable("ohs_incident_causeofinjury_animaloption_XPATH");

					// click on the first option of the causes of injury
					click("ohs_incident_causeofinjury_animaloption_XPATH");
					ngDriver.waitForAngularRequestsToFinish();
					System.out.println("Clicked on the first option of the causes of injury.");

					// scroll down the screen
					JavascriptExecutor js = (JavascriptExecutor) driver;
					js.executeScript("window.scrollBy(0,400)");

					// click on the save button
					click("ohs_incident_causesofinjurytab_savebtn_CSS");
					ngDriver.waitForAngularRequestsToFinish();
					System.out.println("Clicked on the save button.");

					// verify added person involved details are displayed or not
					switchVerification("ohs_incident_addedpersoninvolved1_XPATH", "Employee",
							"The Employee is not displayed.");

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

					// click on the cancel button
					click("ohs_incident_causesofinjurytab_cancelbtn_XPATH");
					ngDriver.waitForAngularRequestsToFinish();
					System.out.println("Clicked on the cancel button.");

				}

			} catch (Throwable t) {
				verificationFailed();
			}

		} catch (Throwable t) {
			verificationFailed();
		}

		try {

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
			JavascriptExecutor js = (JavascriptExecutor) driver;
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

		} catch (Throwable t) {

			verificationFailed();

			// click on the cancel button
			click("ohs_incident_updatebrn_XPATH");
			ngDriver.waitForAngularRequestsToFinish();
			System.out.println("Clicked on the cancel button.");

		}

		try {

			// click on the next button
			click("ohs_incident_nextbtn_CSS");
			System.out.println("Clicked on the next button.");
			ngDriver.waitForAngularRequestsToFinish();

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

			// wait for the element
			Thread.sleep(10000);

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

		} catch (Throwable t) {
			verificationFailed();

			// click on the cancel button
			click("ohs_incident_updatebrn_XPATH");
			ngDriver.waitForAngularRequestsToFinish();
			System.out.println("Clicked on the cancel button.");

		}

		try {

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

			// click on the add button
			click("ohs_incident_propertydamagetab_addbtn_CSS");
			ngDriver.waitForAngularRequestsToFinish();
			System.out.println("Clicked on the add button.");

			// enter data in the nature of damage field
			type("ohs_incident_natureofdamagetxt_CSS", data.get("nature_of_damage"));
			ngDriver.waitForAngularRequestsToFinish();
			System.out.println("Entered data in the nature of damage field.");

			// scroll down the screen
			JavascriptExecutor js = (JavascriptExecutor) driver;
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
			switchVerification("ohs_incident_addedpropertydamage_movefeature_XPATH", "Move Add Nature Of Damage Test",
					"The Move Add Nature Of Damage Test is not displayed.");

		} catch (Throwable t) {
			verificationFailed();

			// click on the cancel button
			click("ohs_incident_propertydamage_cancelbtn_XPATH");
			ngDriver.waitForAngularRequestsToFinish();
			System.out.println("Clicked on the cancel button.");

		}

		try {
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
			JavascriptExecutor js = (JavascriptExecutor) driver;
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
			switchVerification("ohs_incident_addedinsurance_movefeature_XPATH", "Move Add Company Name Test",
					"The Move Add Company Name Test is not displayed.");

		} catch (Throwable t) {
			verificationFailed();

			// click on the cancel button
			click("ohs_incident_insurancetab_cancelbtn_XPATH");
			ngDriver.waitForAngularRequestsToFinish();
			System.out.println("Clicked on the cancel button.");

		}

		try {

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

			// ADD DETAILS IN THE ATTACHMENTS TAB

			System.out.println("********** ADD DETAILS IN THE ATTACHMENTS TAB **********");
			test.log(LogStatus.INFO, "********** ADD DETAILS IN THE ATTACHMENTS TAB **********");
			Reporter.log("********** ADD DETAILS IN THE ATTACHMENTS TAB **********");
			log.info("********** ADD DETAILS IN THE ATTACHMENTS TAB **********");

			// click on the update record button
			click("ohs_incident_updaterecordbtn_CSS");
			ngDriver.waitForAngularRequestsToFinish();
			System.out.println("The update record button clicked successfully");

		} catch (Throwable t) {
			verificationFailed();
		}

		try {
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
			switchVerification("ohs_incident_addedincidentreport1_movefeature_XPATH",
					"Move Describe Incident Text Testing Purpose",
					"The Move Describe Incident Text Testing Purpose is not displayed successfully.");

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

		// MOVE THE INCIDENT REPORT FROM PROPERTY ONE TO PROPERTY TWO

		System.out.println("********** MOVE THE INCIDENT REPORT FROM PROPERTY ONE TO PROPERTY TWO **********");
		test.log(LogStatus.INFO, "********** MOVE THE INCIDENT REPORT FROM PROPERTY ONE TO PROPERTY TWO **********");
		Reporter.log("********** MOVE THE INCIDENT REPORT FROM PROPERTY ONE TO PROPERTY TWO **********");
		log.info("********** MOVE THE INCIDENT REPORT FROM PROPERTY ONE TO PROPERTY TWO **********");

		try {
			// enter the property one name in the search field
			clear("envreports_propertylist_filtertxt_CSS");
			type("envreports_propertylist_filtertxt_CSS", data.get("property_1"));
			ngDriver.waitForAngularRequestsToFinish();
			System.out.println("Entered the property one name in the search field.");

			// click on the OHS icon from the property list page
			click("ohsicon_CSS");
			System.out.println("Clicked on the OHS icon of the Property.");
			ngDriver.waitForAngularRequestsToFinish();
			System.out.println("Navigate to the OHS screen of the perticular property.");

			// wait for the element
			explicitWaitClickable("menubtn_CSS");

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

			// click on the checkbox of the incident report
			String incidentCheckbox = "//td[text()='" + data.get("describe_incident")
					+ "']//preceding-sibling::td//input[@ng-click='selectRecordToMove(record)']";
			driver.findElement(By.xpath(incidentCheckbox)).click();
			ngDriver.waitForAngularRequestsToFinish();
			System.out.println("Clicked on the checkbox of the incident report.");

			// click on the move button
			click("ohs_incident_movebtn_CSS");
			ngDriver.waitForAngularRequestsToFinish();
			System.out.println("Clicked on the move button.");

			// wait for the element
			Thread.sleep(3000);

			// click on the property dropdown field
			click("ohs_incident_movefeature_propertydd_CSS");
			ngDriver.waitForAngularRequestsToFinish();
			System.out.println("Clicked on the property dropdown field.");

			// enter the property name in the search field
			type("ohs_incident_movefeature_searchtxt_CSS", data.get("property_2"));
			ngDriver.waitForAngularRequestsToFinish();
			System.out.println("Entered the property name in the search field.");

			// click on the searched result
			click("ohs_incident_movefeature_seachedresult_XPATH");
			ngDriver.waitForAngularRequestsToFinish();
			System.out.println("Clicked on the searched result.");

			// click on the ok button
			click("ohs_incident_movefeature_okbtn_CSS");
			ngDriver.waitForAngularRequestsToFinish();
			System.out.println("Clicked on the ok button.");

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

			// verify moved incident report is moved or not

			try {
				String incidentreport = driver
						.findElement(By.xpath("ohs_incident_addedincidentreport1_movefeature_XPATH")).getText();
				if (incidentreport.equals("Move Describe Incident Text Testing Purpose")) {

					TestUtil.captureScreenshot();

					// ReportNG
					Reporter.log(
							"<br>" + " Moved Incident Report is displayed after the moved into the another property : "
									+ "<br>");
					Reporter.log("<a target=\"_blank\" href=" + TestUtil.screenshotName + "><img src="
							+ TestUtil.screenshotName + " height=200 width=200></img></a>");
					Reporter.log("<br>");
					Reporter.log("<br>");

					// Extent Report
					test.log(LogStatus.FAIL,
							" Moved Incident Report is displayed after the moved into the another property : ");
					test.log(LogStatus.FAIL, test.addScreenCapture(TestUtil.screenshotName));

					System.out.println("Moved Incident Report is displayed after the moved into the another property.");
					log.info("Moved Incident Report is displayed after the moved into the another property.");

				}

			} catch (Throwable t) {

				System.out.println("The incident report is moved successfully.");
				test.log(LogStatus.INFO, "The incident report is moved successfully.");
				Reporter.log("The incident report is moved successfully.");
				log.info("The incident report is moved successfully.");

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

		// VERIFY MOVED INCIDENT REPORT DISPLAYED IN THE PROPERTY TWO

		System.out.println("********** VERIFY MOVED INCIDENT REPORT DISPLAYED IN THE PROPERTY TWO **********");
		test.log(LogStatus.INFO, "********** VERIFY MOVED INCIDENT REPORT DISPLAYED IN THE PROPERTY TWO **********");
		Reporter.log("********** VERIFY MOVED INCIDENT REPORT DISPLAYED IN THE PROPERTY TWO **********");
		log.info("********** VERIFY MOVED INCIDENT REPORT DISPLAYED IN THE PROPERTY TWO **********");

		try {
			// enter the property one name in the search field
			clear("envreports_propertylist_filtertxt_CSS");
			type("envreports_propertylist_filtertxt_CSS", data.get("property_2"));
			ngDriver.waitForAngularRequestsToFinish();
			System.out.println("Entered the property one name in the search field.");

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

			// verify moved incident report is moved or not

			switchVerification("ohs_incident_addedincidentreport1_movefeature_XPATH",
					"Move Describe Incident Text Testing Purpose",
					"The Move Describe Incident Text Testing Purpose is not displayed");

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

		// DELETE THE DETAILS OF THE UPDATED INCIDENT REPORT

		System.out.println("********** DELETE THE DETAILS OF THE UPDATED INCIDENT REPORT **********");
		test.log(LogStatus.INFO, "********** DELETE THE DETAILS OF THE UPDATED INCIDENT REPORT **********");
		Reporter.log("********** DELETE THE DETAILS OF THE UPDATED INCIDENT REPORT **********");
		log.info("********** DELETE THE DETAILS OF THE UPDATED INCIDENT REPORT **********");

		try {

			// enter the property two name in the search field
			clear("envreports_propertylist_filtertxt_CSS");
			type("envreports_propertylist_filtertxt_CSS", data.get("property_2"));
			ngDriver.waitForAngularRequestsToFinish();
			System.out.println("Entered the property one name in the search field.");

			// click on the OHS icon from the property list page
			click("ohsicon_CSS");
			System.out.println("Clicked on the OHS icon of the Property.");
			ngDriver.waitForAngularRequestsToFinish();
			System.out.println("Navigate to the OHS screen of the perticular property.");

			// wait for the element
			explicitWaitClickable("menubtn_CSS");

			// click on the burger menu
			click("menubtn_CSS");
			System.out.println("Clicked on the burger menu button successfully!!!");
			ngDriver.waitForAngularRequestsToFinish();

			// wait for the element
			Thread.sleep(5000);

			// click on the incident reports
			click("questionnaire_option_ohstab_incidentreports_XPATH");
			System.out.println("Clicked on the incident reports option.");
			ngDriver.waitForAngularRequestsToFinish();

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

			// click on the newly added incident report
			click("ohs_incident_addedincidentreport1_movefeature_XPATH");
			System.out.println("Clicked on the newly added incident report.");
			ngDriver.waitForAngularRequestsToFinish();
			System.out.println("Naviagte to the newly added Incident record Screen.");

			// DELETE DETAILS IN THE PERSONS INVOLVED TAB

			System.out.println("********** DELETE DETAILS IN THE PERSONS INVOLVED TAB **********");
			test.log(LogStatus.INFO, "********** DELETE DETAILS IN THE PERSONS INVOLVED TAB **********");
			Reporter.log("********** DELETE DETAILS IN THE PERSONS INVOLVED TAB **********");
			log.info("********** DELETE DETAILS IN THE PERSONS INVOLVED TAB **********");

			// click on the person involved tab
			click("ohs_incident_personsinvolvedtab_CSS");
			ngDriver.waitForAngularRequestsToFinish();
			System.out.println("Clicked on the person involved tab.");

			// click on the delete button of the added person involved
			click("ohs_incident_deletebtn1_CSS");
			ngDriver.waitForAngularRequestsToFinish();
			System.out.println("Clicked on the delete button of the added person involved.");

			// verify details are deleted or not
			helper.deleteVerification("ohs_incident_addedpersoninvolved1_XPATH", "Employee");

			// DELETE DETAILS IN THE WITNESSES TAB

			System.out.println("********** DELETE DETAILS IN THE WITNESSES TAB **********");
			test.log(LogStatus.INFO, "********** DELETE DETAILS IN THE WITNESSES TAB **********");
			Reporter.log("********** DELETE DETAILS IN THE WITNESSES TAB **********");
			log.info("********** DELETE DETAILS IN THE WITNESSES TAB **********");

			// click on the witnesses tab
			click("ohs_incident_witnessestab_CSS");
			ngDriver.waitForAngularRequestsToFinish();
			System.out.println("Clicked on the witnesses tab.");

			// wait for the element
			explicitWaitClickable("ohs_incident_witnessdeletebtn_CSS");

			// click on the delete button of the added witnesses
			click("ohs_incident_witnessdeletebtn_CSS");
			ngDriver.waitForAngularRequestsToFinish();
			System.out.println("Clicked on the delete button of the added witnesses.");

			// verify details are deleted or not
			helper.deleteVerification("ohs_incident_addedwitness1_XPATH", "Witness");

			// DELETE DETAILS IN THE EMERGENCY SERVICES TAB

			System.out.println("********** DELETE DETAILS IN THE EMERGENCY SERVICES TAB **********");
			test.log(LogStatus.INFO, "********** DELETE DETAILS IN THE EMERGENCY SERVICES TAB **********");
			Reporter.log("********** DELETE DETAILS IN THE EMERGENCY SERVICES TAB **********");
			log.info("********** DELETE DETAILS IN THE EMERGENCY SERVICES TAB **********");

			// click on the emergency services tab
			click("ohs_incident_emergencyservicestab_CSS");
			ngDriver.waitForAngularRequestsToFinish();
			System.out.println("Clicked on the emergency services.");

			// click on the delete button of the added emergency services
			click("ohs_incident_witnessdeletebtn_CSS");
			ngDriver.waitForAngularRequestsToFinish();
			System.out.println("Clicked on the delete button of the added emergency services.");

			// verify details are deleted or not
			helper.deleteVerification("ohs_incident_updatedemergencyservices_XPATH", "Fire");

			// DELETE DETAILS IN THE PROPERTY DAMAGE TAB

			System.out.println("********** DELETE DETAILS IN THE PROPERTY DAMAGE TAB **********");
			test.log(LogStatus.INFO, "********** DELETE DETAILS IN THE PROPERTY DAMAGE TAB **********");
			Reporter.log("********** DELETE DETAILS IN THE PROPERTY DAMAGE TAB **********");
			log.info("********** DELETE DETAILS IN THE PROPERTY DAMAGE TAB **********");

			// click on the property damage tab
			click("ohs_incident_propertydamagetab_CSS");
			ngDriver.waitForAngularRequestsToFinish();
			System.out.println("Clicked on the property damage tab.");

			// click on the delete button of the added property damage
			click("ohs_incident_propertydamagedeletebtn_CSS");
			ngDriver.waitForAngularRequestsToFinish();
			System.out.println("Clicked on the delete button of the added property damage.");

			// verify details are deleted or not
			helper.deleteVerification("ohs_incident_addedpropertydamage_movefeature_XPATH",
					"Move Add Nature Of Damage Test");

			// DELETE DETAILS IN THE INSURANCE TAB

			System.out.println("********** DELETE DETAILS IN THE INSURANCE TAB **********");
			test.log(LogStatus.INFO, "********** DELETE DETAILS IN THE INSURANCE TAB **********");
			Reporter.log("********** DELETE DETAILS IN THE INSURANCE TAB **********");
			log.info("********** DELETE DETAILS IN THE INSURANCE TAB **********");

			// click on the insurance tab
			click("ohs_incident_insurancetab_CSS");
			ngDriver.waitForAngularRequestsToFinish();
			System.out.println("Clicked on the insurance tab.");

			// click on the delete button of the added property damage
			click("ohs_incident_insurancedeletebtn_CSS");
			ngDriver.waitForAngularRequestsToFinish();
			System.out.println("Clicked on the delete button of the added property damage.");

			// verify details are deleted or not
			helper.deleteVerification("ohs_incident_addedinsurance_movefeature_XPATH", "Move Add Company Name Test");

			// scroll up the screen
			JavascriptExecutor js = (JavascriptExecutor) driver;
			js.executeScript("window.scrollTo(0,0)");

			// click on the incident summary tab
			click("ohs_incident_incidentsummarytab_CSS");
			ngDriver.waitForAngularRequestsToFinish();
			System.out.println("Clicked on the incident summary tab.");

			// click on the update button
			click("ohs_incident_updatebtn_CSS");
			ngDriver.waitForAngularRequestsToFinish();
			System.out.println("Clicked on the update button.");

			// click on the cancel button
			click("ohs_incident_cancelbtn_CSS");
			ngDriver.waitForAngularRequestsToFinish();
			System.out.println("Clicked on the cancel button.");

			// DELETE DETAILS IN THE INCIDENT REPORT

			System.out.println("********** DELETE DETAILS IN THE INCIDENT REPORT **********");
			test.log(LogStatus.INFO, "********** DELETE DETAILS IN THE INCIDENT REPORT **********");
			Reporter.log("********** DELETE DETAILS IN THE INCIDENT REPORT **********");
			log.info("********** DELETE DETAILS IN THE INCIDENT REPORT **********");

			// click on the newly created incident report
			click("ohs_incident_addedincidentreport1_movefeature_XPATH");
			System.out.println("Clicked on the newly created incident report.");
			ngDriver.waitForAngularRequestsToFinish();
			System.out.println("Naviagte to the newly created Incident record Screen.");

			// click on the delete button
			click("ohs_incident_deletebtn_CSS");
			ngDriver.waitForAngularRequestsToFinish();
			System.out.println("Clicked on the delete button.");

			// click on the delete button of confirmation popup
			click("ohs_incident_confirmdeletebtn_CSS");
			ngDriver.waitForAngularRequestsToFinish();
			System.out.println("Clicked on the delete button of confirmation popup.");

			// verify details are deleted or not
			helper.deleteVerification("ohs_incident_addedincidentreport1_movefeature_XPATH",
					"Move Describe Incident Text Testing Purpose");

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
