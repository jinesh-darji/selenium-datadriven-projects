package testcases.smokesuite;

import java.io.IOException;
import java.time.LocalDate;
import java.util.Date;
import java.util.Hashtable;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.testng.Reporter;
import org.testng.SkipException;
import org.testng.annotations.Test;

import com.relevantcodes.extentreports.LogStatus;

import base.TestBase;
import utilities.TestUtil;

public class RR5553Capreit5Test extends TestBase {

	@Test(dataProviderClass = TestUtil.class, dataProvider = "dp")
	public void rR5553Capreit5Test(Hashtable<String, String> data) throws IOException, InterruptedException {

		if (!(TestUtil.isTestRunnable("rR5553Capreit5Test", excel))) {

			throw new SkipException(
					"Skipping the test " + "rR5553Capreit5Test".toUpperCase() + "as the Run mode is NO");
		}

		if (!data.get("runmode").equals("Y")) {

			throw new SkipException("Skipping the test case as the Run Mode for data set is NO");
		}

		// refresh the page
		driver.navigate().refresh();
		Thread.sleep(5000);
		driver.navigate().refresh();

		// UPDATE THE INCIDENT REPORT FROM THE EHS DASHBOARD

		System.out.println("UPDATE THE INCIDENT REPORT FROM THE EHS DASHBOARD");
		test.log(LogStatus.INFO, "UPDATE THE INCIDENT REPORT FROM THE EHS DASHBOARD");
		Reporter.log("UPDATE THE INCIDENT REPORT FROM THE EHS DASHBOARD");
		log.info("UPDATE THE INCIDENT REPORT FROM THE EHS DASHBOARD");

		// LOGIN WITH ADMIN USER

		System.out.println("******************** LOGIN WITH ADMIN USER ********************");
		test.log(LogStatus.INFO, "******************** LOGIN WITH ADMIN USER ********************");
		Reporter.log("******************** LOGIN WITH ADMIN USER ********************");
		log.info("******************** LOGIN WITH ADMIN USER ********************");

		try {
			// wait for the element
			explicitWaitClickable("signinbtn_BTNTEXT");

			// Enter the username
			type("usernametxt_CSS", data.get("username_1"));
			ngDriver.waitForAngularRequestsToFinish();
			System.out.println("Entered the username.");

			// Enter the password
			type("passwordtxt_CSS", data.get("password_1"));
			ngDriver.waitForAngularRequestsToFinish();
			System.out.println("Entered the password.");

			// Clicking on the "Sign In" button
			click("signinbtn_BTNTEXT");
			ngDriver.waitForAngularRequestsToFinish();
			System.out.println("Clicked on the sign in button.");

			// wait for the element
			explicitWait("propertylist_title_XPATH");

			// verify the property list
			switchVerification("propertylist_title_XPATH", "Property List", "The property list is not displayed.");

			// UPDATE THE SYSTEM COMPANY
			updateCompany(data);

		} catch (Throwable t) {
			verificationFailed();
		}

		// CREATE NEW INCIDENT REPORT

		System.out.println("******************** CREATE NEW INCIDENT REPORT ********************");
		test.log(LogStatus.INFO, "******************** CREATE NEW INCIDENT REPORT ********************");
		Reporter.log("******************** CREATE NEW INCIDENT REPORT ********************");
		log.info("******************** CREATE NEW INCIDENT REPORT ********************");

		try {

			// enter the property name in the search field
			type("envreports_propertylist_filtertxt_CSS", data.get("property_1"));
			ngDriver.waitForAngularRequestsToFinish();
			System.out.println("Entered the property name in the search field.");

			// click on the OHS icon from the property list page
			click("ohsicon_CSS");
			System.out.println("Clicked on the OHS icon of the Property.");
			ngDriver.waitForAngularRequestsToFinish();
			System.out.println("Navigate to the OHS screen of the perticular property.");

			// wait for the element
			Thread.sleep(5000);

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

			// ADD DETAILS IN THE INCIDENT REPORT TAB

			System.out.println("********** ADD DETAILS IN THE INCIDENT REPORT TAB **********");
			test.log(LogStatus.INFO, "********** ADD DETAILS IN THE INCIDENT REPORT TAB **********");
			Reporter.log("********** ADD DETAILS IN THE INCIDENT REPORT TAB **********");
			log.info("********** ADD DETAILS IN THE INCIDENT REPORT TAB **********");

			// click on the add button
			click("ohs_incident_addbtn_CSS");
			System.out.println("Clicked on the Add button.");
			ngDriver.waitForAngularRequestsToFinish();
			System.out.println("Navigate to the Add incident report Screen");

			// enter the incident time - hours
			clear("ohs_incident_hourstxt_CSS");
			type("ohs_incident_hourstxt_CSS", "11");
			System.out.println("Entered the hours in the incident time.");
			ngDriver.waitForAngularRequestsToFinish();

			// enter the incident time - minute
			clear("ohs_incident_minutestxt_CSS");
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
					switchVerification("ohs_incident_addedpersoninvolved_XPATH", "Employee",
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
			switchVerification("ohs_incident_addedwitness_XPATH", "Witness", "The Witness is not displayed.");

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
			switchVerification("ohs_incident_addedpropertydamage_XPATH", "Add Nature Of Damage Test",
					"The Add Nature Of Damage Test is not displayed.");

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
			switchVerification("ohs_incident_addedinsurance_XPATH", "ADDCLAIMNUMBERTEST",
					"The ADDCLAIMNUMBERTEST is not displayed.");

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
			switchVerification("ohs_incident_addedincidentreport_capreit5_XPATH",
					"Capreit5 Describe Incident Text Testing Purpose",
					"The Capreit5 Describe Incident Text Testing Purpose is not displayed successfully.");

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

		// UPDATE THE DETAILS OF THE NEWLY ADDED INCIDENT REPORT FROM THE EHS DASHBOARD

		System.out.println(
				"********** UPDATE THE DETAILS OF THE NEWLY ADDED INCIDENT REPORT FROM THE EHS DASHBOARD **********");
		test.log(LogStatus.INFO,
				"********** UPDATE THE DETAILS OF THE NEWLY ADDED INCIDENT REPORT FROM THE EHS DASHBOARD **********");
		Reporter.log(
				"********** UPDATE THE DETAILS OF THE NEWLY ADDED INCIDENT REPORT FROM THE EHS DASHBOARD **********");
		log.info("********** UPDATE THE DETAILS OF THE NEWLY ADDED INCIDENT REPORT FROM THE EHS DASHBOARD **********");

		try {

			// wait for the element
			Thread.sleep(5000);

			// click on the side menu
			click("menubtn_CSS");
			ngDriver.waitForAngularRequestsToFinish();
			System.out.println("Clicked on the side menu.");

			// wait for the element
			Thread.sleep(5000);

			// click on the ohs option
			click("sidemenu_occupationalhealthandsafety_CSS");
			ngDriver.waitForAngularRequestsToFinish();
			System.out.println("Clicked on the ohs option.");

			// select the ehs dashboard option from the dashboard dropdown
			select("dashboard_CSS", data.get("ehs_dashboard"));
			ngDriver.waitForAngularRequestsToFinish();
			System.out.println("Selected the ehs dashboard option from the dashboard dropdown.");

			// wait for the element
			Thread.sleep(3000);

			// select the event type
			select("ohs_ehsdashboard_filter_eventtypedd_XPATH", data.get("event_type"));
			ngDriver.waitForAngularRequestsToFinish();
			System.out.println("Selected the event type.");

			// wait for the element
			Thread.sleep(3000);

			// click on the newly created incident report
			LocalDate Date = LocalDate.now();
			String todayDate = Date.toString();
			String incidentReport = "//td[text()='" + todayDate + "']";
			driver.findElement(By.xpath(incidentReport)).click();
			ngDriver.waitForAngularRequestsToFinish();
			System.out.println("Clicked on the newly created incident report.");

			// scroll down the screen
			JavascriptExecutor js = (JavascriptExecutor) driver;
			js.executeScript("window.scrollBy(0,400)");

			// wait for the element
			Thread.sleep(7000);

			// enter the incident time - hours
			clear("ohs_incident_hourstxt_CSS");
			System.out.println("Cleared the hours field of incident time.");
			ngDriver.waitForAngularRequestsToFinish();
			type("ohs_incident_hourstxt_CSS", "12");
			System.out.println("Updated the hours in the incident time.");
			ngDriver.waitForAngularRequestsToFinish();

			// update the incident time - minute
			clear("ohs_incident_minutestxt_CSS");
			System.out.println("Cleared the minute field of incident time.");
			ngDriver.waitForAngularRequestsToFinish();
			type("ohs_incident_minutestxt_CSS", "00");
			System.out.println("Updated the minute in the incident time.");
			ngDriver.waitForAngularRequestsToFinish();

			// scroll down the screen
			js.executeScript("window.scrollBy(0,500)");

			// Update the short description
			clear("ohs_incident_shortdescriptiontxt_CSS");
			ngDriver.waitForAngularRequestsToFinish();
			System.out.println("Clear the search field.");
			type("ohs_incident_shortdescriptiontxt_CSS", data.get("update_describe_incident"));
			System.out.println("Updated the short description");
			ngDriver.waitForAngularRequestsToFinish();

			// wait for the element
			explicitWaitClickable("ohs_incident_deleteeventbtn_CSS");

			// delete the previously added event type
			click("ohs_incident_deleteeventbtn_CSS");
			ngDriver.waitForAngularRequestsToFinish();
			System.out.println("Deleted the previously added event type.");

			// wait for the element
			explicitWaitClickable("ohs_incident_confirmation_deleteeventbtn_CSS");

			// click on the delete button of confirmation message
			click("ohs_incident_confirmation_deleteeventbtn_CSS");
			ngDriver.waitForAngularRequestsToFinish();
			System.out.println("Clicked on the delete button of confirmation message.");

			// click on the add event type button
			click("ohs_incident_addeventtypebtn_CSS");
			System.out.println("Clicked on the add event type button.");
			ngDriver.waitForAngularRequestsToFinish();

			// wait for the element
			Thread.sleep(3000);

			// click on the event type dropdown
			select("ohs_incident_eventtypedd_CSS", data.get("update_event_type"));
			System.out.println("Clicked on the event type dropdown.");
			ngDriver.waitForAngularRequestsToFinish();

			// click on the add button of the add event type record model
			click("ohs_incident_eventty_addbtn_CSS");
			System.out.println("Clicked on the add button of the add event type record model.");
			ngDriver.waitForAngularRequestsToFinish();

			// scroll up the screen
			js.executeScript("window.scrollBy(0,-600)");

			// click on the detail cause tab
			click("ohs_incident_detailcausetab_CSS");
			ngDriver.waitForAngularRequestsToFinish();
			System.out.println("Click on the detail cause tab.");

			// wait for the element
			Thread.sleep(5000);

			// click on the close button
			click("ohs_incident_updatedetails_closebtn_XPATH");
			ngDriver.waitForAngularRequestsToFinish();
			System.out.println("Clicked on the close button.");

			// click on the update button
			click("ohs_incident_updatebtn_XPATH");
			ngDriver.waitForAngularRequestsToFinish();
			System.out.println("Clicked on the update button.");

			// wait for the element
			explicitWaitClickable("closetoastmsg_CSS");

			// click on the toaster close button
			click("closetoastmsg_CSS");
			ngDriver.waitForAngularRequestsToFinish();
			System.out.println("Clicked on the toaster close button.");

		} catch (Throwable t) {

			verificationFailed();

		}

		// UPDATE DETAILS IN THE DETAILS, CAUSES TAB

		System.out.println("********** UPDATE DETAILS IN THE DETAILS, CAUSES TAB **********");
		test.log(LogStatus.INFO, "********** UPDATE DETAILS IN THE DETAILS, CAUSES TAB **********");
		Reporter.log("********** UPDATE DETAILS IN THE DETAILS, CAUSES TAB **********");
		log.info("********** UPDATE DETAILS IN THE DETAILS, CAUSES TAB **********");

		try {
			// click on the detail cause tab
			click("ohs_incident_detailcausetab_CSS");
			ngDriver.waitForAngularRequestsToFinish();
			System.out.println("Click on the detail cause tab.");

			// wait for the element
			Thread.sleep(7000);

			// Update the data in the description incident field
			clear("ohs_incident_descriptionincidenttxt_CSS");
			ngDriver.waitForAngularRequestsToFinish();
			System.out.println("Clear the search field.");
			type("ohs_incident_descriptionincidenttxt_CSS", data.get("update_describe_incident"));
			ngDriver.waitForAngularRequestsToFinish();
			System.out.println("Updated the data in the description incident field.");

			// Update the data in the Incident Cause field
			clear("ohs_incident_incidentcausetxt_CSS");
			ngDriver.waitForAngularRequestsToFinish();
			System.out.println("Clear the search field.");
			type("ohs_incident_incidentcausetxt_CSS", data.get("update_incident_cause"));
			ngDriver.waitForAngularRequestsToFinish();
			System.out.println("Updated the data in the Incident Cause field.");

			// scroll down the screen
			JavascriptExecutor js = (JavascriptExecutor) driver;
			js.executeScript("window.scrollBy(0,400)");

			// Update the data in the Actions Taken field
			clear("ohs_incident_actionstakentxt_CSS");
			ngDriver.waitForAngularRequestsToFinish();
			System.out.println("Clear the search field.");
			type("ohs_incident_actionstakentxt_CSS", data.get("update_actions_taken"));
			ngDriver.waitForAngularRequestsToFinish();
			System.out.println("Updated the data in the Actions Taken field.");

			// scroll up the screen
			js.executeScript("window.scrollBy(0,-600)");

			// click on the person involved tab
			click("ohs_incident_personsinvolvedtab_CSS");
			ngDriver.waitForAngularRequestsToFinish();
			System.out.println("Clicked on the person involved tab.");

			// wait for the element
			explicitWaitClickable("ohs_incident_updatedetails_closebtn_XPATH");

			// click on the close button
			click("ohs_incident_updatedetails_closebtn_XPATH");
			ngDriver.waitForAngularRequestsToFinish();
			System.out.println("Clicked on the close button.");

			// click on the update details button
			click("ohs_incident_updatedetailsbtn_XPATH");
			ngDriver.waitForAngularRequestsToFinish();
			System.out.println("Clicked on the update button.");

		} catch (Throwable t) {

			verificationFailed();

		}

		// UPDATE DETAILS IN THE PERSONS INVOLVED TAB

		System.out.println("********** UPDATE DETAILS IN THE PERSONS INVOLVED TAB **********");
		test.log(LogStatus.INFO, "********** UPDATE DETAILS IN THE PERSONS INVOLVED TAB **********");
		Reporter.log("********** UPDATE DETAILS IN THE PERSONS INVOLVED TAB **********");
		log.info("********** UPDATE DETAILS IN THE PERSONS INVOLVED TAB **********");

		try {
			// click on the person involved tab
			click("ohs_incident_personsinvolvedtab_CSS");
			ngDriver.waitForAngularRequestsToFinish();
			System.out.println("Clicked on the person involved tab.");

			// wait for the element
			Thread.sleep(7000);

			// click on the added person involved
			click("ohs_incident_addedpersoninvolved1_XPATH");
			ngDriver.waitForAngularRequestsToFinish();
			System.out.println("Clicked on the added person involved.");

			try {

				// update data in the Insurance Company Name field
				clear("ohs_incident_insurancecompanynametxt_CSS");
				type("ohs_incident_insurancecompanynametxt_CSS", data.get("update_insurance_company_name"));
				ngDriver.waitForAngularRequestsToFinish();
				System.out.println("Updated data in the Insurance Company Name field.");

				// update data in the Insurance Policy Number field
				clear("ohs_incident_insurancepolicynumbertxt_CSS");
				type("ohs_incident_insurancepolicynumbertxt_CSS", data.get("update_insurance_policy_number"));
				ngDriver.waitForAngularRequestsToFinish();
				System.out.println("Updated data in the Insurance Policy Number field.");

				// scroll down the screen
				JavascriptExecutor js = (JavascriptExecutor) driver;
				js.executeScript("window.scrollBy(0,600)");

				// update data in the job title
				clear("ohs_incident_personjobtitletxt_CSS");
				type("ohs_incident_personjobtitletxt_CSS", data.get("update_job_title"));
				ngDriver.waitForAngularRequestsToFinish();
				System.out.println("Updated the data in the job title");

				// updated data in the manager name field
				clear("ohs_incident_managernametxt_CSS");
				type("ohs_incident_managernametxt_CSS", data.get("update_manager_name"));
				ngDriver.waitForAngularRequestsToFinish();
				System.out.println("Updated data in the manager name field.");

				// update data in the manager email field
				clear("ohs_incident_manageremailtxt_CSS");
				type("ohs_incident_manageremailtxt_CSS", data.get("update_manager_email"));
				ngDriver.waitForAngularRequestsToFinish();
				System.out.println("Updated data in the manager email field.");

				// scroll up the screen
				js.executeScript("window.scrollBy(0,-600)");

				// UPDATE DETAILS IN THE NATURE OF INJURY TAB

				System.out.println("********** UPDATE DETAILS IN THE NATURE OF INJURY TAB **********");
				test.log(LogStatus.INFO, "********** UPDATE DETAILS IN THE NATURE OF INJURY TAB **********");
				Reporter.log("********** UPDATE DETAILS IN THE NATURE OF INJURY TAB **********");
				log.info("********** UPDATE DETAILS IN THE NATURE OF INJURY TAB **********");

				// click on the nature of injury tab
				click("ohs_incident_natureofinjurytab_CSS");
				ngDriver.waitForAngularRequestsToFinish();
				System.out.println("Clicked on the nature of injury tab.");

				// wait for the element
				Thread.sleep(7000);

				// click on the abdomen checkbox
				click("ohs_incident_chestckbx_CSS");
				ngDriver.waitForAngularRequestsToFinish();
				System.out.println("Clicked on the abdomen checkbox.");

				// UPDATE DETAILS IN THE CAUSE OF INJURY TAB

				System.out.println("********** UPDATE DETAILS IN THE CAUSE OF INJURY TAB **********");
				test.log(LogStatus.INFO, "********** UPDATE DETAILS IN THE CAUSE OF INJURY TAB **********");
				Reporter.log("********** UPDATE DETAILS IN THE CAUSE OF INJURY TAB **********");
				log.info("********** UPDATE DETAILS IN THE CAUSE OF INJURY TAB **********");

				// click on the causes of injury tab
				click("ohs_incident_causeofinjurytab_CSS");
				ngDriver.waitForAngularRequestsToFinish();
				System.out.println("Clicked on the causes of injury tab.");

				// wait for the element
				Thread.sleep(7000);

				try {

					// click on the second option of the causes of injury
					click("ohs_incident_causeofinjury_motionoption_XPATH");
					ngDriver.waitForAngularRequestsToFinish();
					System.out.println("Clicked on the second option of the causes of injury.");

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

				// click on the save button
				click("ohs_incident_causesofinjurytab_savebtn_CSS");
				ngDriver.waitForAngularRequestsToFinish();
				System.out.println("Clicked on the save button.");

				// scroll up the screen
				js.executeScript("window.scrollBy(0,-400)");

			} catch (Throwable t) {

				verificationFailed();

				// click on the persons involved tab
				click("ohs_incident_personsinvolvedtab_CSS");
				ngDriver.waitForAngularRequestsToFinish();
				System.out.println("Clicked on the persons involved tab.");

				// click on the cancel button
				click("ohs_incident_updatebrn_XPATH");
				ngDriver.waitForAngularRequestsToFinish();
				System.out.println("Clicked on the cancel button.");

				// scroll up the screen
				JavascriptExecutor js = (JavascriptExecutor) driver;
				js.executeScript("window.scrollBy(0,-400)");

			}

		} catch (Throwable t) {

			verificationFailed();

		}

		// UPDATE DETAILS IN THE WITNESSES TAB

		System.out.println("********** UPDATE DETAILS IN THE WITNESSES TAB **********");
		test.log(LogStatus.INFO, "********** UPDATE DETAILS IN THE WITNESSES TAB **********");
		Reporter.log("********** UPDATE DETAILS IN THE WITNESSES TAB **********");
		log.info("********** UPDATE DETAILS IN THE WITNESSES TAB **********");

		try {

			// click on the witnesses tab
			click("ohs_incident_witnessestab_CSS");
			ngDriver.waitForAngularRequestsToFinish();
			System.out.println("Clicked on the witnesses tab.");

			// wait for the element
			Thread.sleep(7000);

			// click on the added witness
			click("ohs_incident_addedwitness_XPATH");
			ngDriver.waitForAngularRequestsToFinish();
			System.out.println("Clicked on the added witness.");

			try {

				// scroll down the screen
				JavascriptExecutor js = (JavascriptExecutor) driver;
				js.executeScript("window.scrollBy(0,600)");

				// update data in the address one field
				clear("ohs_incident_addressone_CSS");
				type("ohs_incident_addressone_CSS", data.get("address_1"));
				ngDriver.waitForAngularRequestsToFinish();
				System.out.println("Entered data in the address one field.");

				// update data in the address two field
				clear("ohs_incident_addresstwo_CSS");
				type("ohs_incident_addresstwo_CSS", data.get("address_2"));
				ngDriver.waitForAngularRequestsToFinish();
				System.out.println("Entered data in the address two field.");

				// click on the save button
				click("ohs_incident_witnessestab_savebtn_CSS");
				ngDriver.waitForAngularRequestsToFinish();
				System.out.println("Clicked on the save button.");

				// scroll up the screen
				js.executeScript("window.scrollBy(0,-600)");

			} catch (Throwable t) {

				verificationFailed();

				// click on the cancel button
				click("ohs_incident_updatebrn_XPATH");
				ngDriver.waitForAngularRequestsToFinish();
				System.out.println("Clicked on the cancel button.");

			}
		} catch (Throwable t) {

			verificationFailed();

		}

		// UPDATE DETAILS IN THE EMERGENCY SERVICES TAB

		System.out.println("********** UPDATE DETAILS IN THE EMERGENCY SERVICES TAB **********");
		test.log(LogStatus.INFO, "********** UPDATE DETAILS IN THE EMERGENCY SERVICES TAB **********");
		Reporter.log("********** UPDATE DETAILS IN THE EMERGENCY SERVICES TAB **********");
		log.info("********** UPDATE DETAILS IN THE EMERGENCY SERVICES TAB **********");

		try {
			// click on the emergency services tab
			click("ohs_incident_emergencyservicestab_CSS");
			ngDriver.waitForAngularRequestsToFinish();
			System.out.println("Clicked on the emergency services.");

			// wait for the element
			Thread.sleep(7000);

			// click on the added emergency services
			click("ohs_incident_addedemergencyservices_XPATH");
			ngDriver.waitForAngularRequestsToFinish();
			System.out.println("Clicked on the added emergency services.");

			try {
				// select the data from the type dropdown
				select("ohs_incident_contacttypedd_CSS", data.get("update_contacttype"));
				ngDriver.waitForAngularRequestsToFinish();
				System.out.println("Selected the data from the type dropdown.");

				// enter data in the report number field
				clear("ohs_incident_emergencyservicestab_reportnametxt_CSS");
				ngDriver.waitForAngularRequestsToFinish();
				System.out.println("Clear the search field.");
				type("ohs_incident_emergencyservicestab_reportnametxt_CSS", data.get("report_number"));
				ngDriver.waitForAngularRequestsToFinish();
				System.out.println("Entered data in the report number field.");

				// update data in the description field
				clear("ohs_incident_descriptiontxt_CSS");
				ngDriver.waitForAngularRequestsToFinish();
				System.out.println("Clear the search field.");
				type("ohs_incident_descriptiontxt_CSS", data.get("update_short_description"));
				ngDriver.waitForAngularRequestsToFinish();
				System.out.println("Updated data in the description field.");

				// click on the save button
				click("ohs_incident_emergencyservicestab_savebtn_CSS");
				ngDriver.waitForAngularRequestsToFinish();
				System.out.println("Clicked on the save button.");

				// scroll up the screen
				JavascriptExecutor js = (JavascriptExecutor) driver;
				js.executeScript("window.scrollBy(0,-600)");

			} catch (Throwable t) {

				verificationFailed();

				// click on the cancel button
				click("ohs_incident_updatebrn_XPATH");
				ngDriver.waitForAngularRequestsToFinish();
				System.out.println("Clicked on the cancel button.");

			}

		} catch (Throwable t) {

			verificationFailed();

		}

		// UPDATE DETAILS IN THE PROPERTY DAMAGE TAB

		System.out.println("********** UPDATE DETAILS IN THE PROPERTY DAMAGE TAB **********");
		test.log(LogStatus.INFO, "********** UPDATE DETAILS IN THE PROPERTY DAMAGE TAB **********");
		Reporter.log("********** UPDATE DETAILS IN THE PROPERTY DAMAGE TAB **********");
		log.info("********** UPDATE DETAILS IN THE PROPERTY DAMAGE TAB **********");

		try {
			// click on the property damage tab
			click("ohs_incident_propertydamagetab_CSS");
			ngDriver.waitForAngularRequestsToFinish();
			System.out.println("Clicked on the property damage tab.");

			// wait for the element
			Thread.sleep(7000);

			// click on the added property damage
			click("ohs_incident_addedpropertydamage_XPATH");
			ngDriver.waitForAngularRequestsToFinish();
			System.out.println("Clicked on the added property damage.");

			try {
				// update data in the nature of damage field
				clear("ohs_incident_natureofdamagetxt_CSS");
				ngDriver.waitForAngularRequestsToFinish();
				System.out.println("Cleared the field.");
				type("ohs_incident_natureofdamagetxt_CSS", data.get("update_nature_of_damage"));
				ngDriver.waitForAngularRequestsToFinish();
				System.out.println("Updated data in the nature of damage field.");

				// scroll down the screen
				JavascriptExecutor js = (JavascriptExecutor) driver;
				js.executeScript("window.scrollBy(0,400)");

				// select data from the Estimated Cost of Repairs field
				select("ohs_incident_estimatedcostofrepairsdd_CSS", data.get("update_estimated_cost_of_repairs"));
				ngDriver.waitForAngularRequestsToFinish();
				System.out.println("Selected data from the Estimated Cost of Repairs.");

				// update data in the Insurance Company Name field
				clear("ohs_incident_propertydamagetab_insurancecompanynametxt_CSS");
				ngDriver.waitForAngularRequestsToFinish();
				System.out.println("Clear the search field.");
				type("ohs_incident_propertydamagetab_insurancecompanynametxt_CSS",
						data.get("update_insurance_company_name_2"));
				ngDriver.waitForAngularRequestsToFinish();
				System.out.println("Updated data in the Insurance Company Name field.");

				// update data in the Insurance Policy Number field
				clear("ohs_incident_propertydamagetab_insurancepolicynumbertxt_CSS");
				ngDriver.waitForAngularRequestsToFinish();
				System.out.println("Clear the search field.");
				type("ohs_incident_propertydamagetab_insurancepolicynumbertxt_CSS",
						data.get("update_insurance_policy_number2"));
				ngDriver.waitForAngularRequestsToFinish();
				System.out.println("Updated data in the Insurance Policy Number field.");

				// click on the save button
				click("ohs_incident_propertydamagetab_savebtn_CSS");
				ngDriver.waitForAngularRequestsToFinish();
				System.out.println("Clicked on the save button.");

				// scroll up the screen
				js.executeScript("window.scrollBy(0,-600)");

			} catch (Throwable t) {
				verificationFailed();

				// click on the cancel button
				click("ohs_incident_propertydamagetab_cancelbtn_XPATH");
				ngDriver.waitForAngularRequestsToFinish();
				System.out.println("Clicked on the cancel button.");

			}

		} catch (Throwable t) {
			verificationFailed();
		}

		// UPDATE DETAILS IN THE INSURANCE TAB

		System.out.println("********** UPDATE DETAILS IN THE INSURANCE TAB **********");
		test.log(LogStatus.INFO, "********** UPDATE DETAILS IN THE INSURANCE TAB **********");
		Reporter.log("********** UPDATE DETAILS IN THE INSURANCE TAB **********");
		log.info("********** UPDATE DETAILS IN THE INSURANCE TAB **********");

		try {
			// click on the insurance tab
			click("ohs_incident_insurancetab_CSS");
			ngDriver.waitForAngularRequestsToFinish();
			System.out.println("Clicked on the insurance tab.");

			// wait for the element
			Thread.sleep(7000);

			// click on the added insurance
			click("ohs_incident_addedinsurance_XPATH");
			ngDriver.waitForAngularRequestsToFinish();
			System.out.println("Clicked on the added insurance.");

			try {
				// update data in the company name field
				clear("ohs_incident_insurance_companynametxt_CSS");
				ngDriver.waitForAngularRequestsToFinish();
				System.out.println("Clear the search field.");
				type("ohs_incident_insurance_companynametxt_CSS", data.get("update_company_name"));
				ngDriver.waitForAngularRequestsToFinish();
				System.out.println("Updated data in the company name field.");

				// update data in the Claim Number field
				clear("ohs_incident_insurance_claimnumbertxt_CSS");
				ngDriver.waitForAngularRequestsToFinish();
				System.out.println("Clear the search field.");
				type("ohs_incident_insurance_claimnumbertxt_CSS", data.get("update_claim_number"));
				ngDriver.waitForAngularRequestsToFinish();
				System.out.println("Updated data in the Claim Number field.");

				// scroll down the screen
				JavascriptExecutor js = (JavascriptExecutor) driver;
				js.executeScript("window.scrollBy(0,600)");

				// select data from the Status drop down
				select("ohs_incident_insurance_statusdd_CSS", data.get("update_insurance_status"));
				ngDriver.waitForAngularRequestsToFinish();
				System.out.println("Selected data in the Status drop down.");

				// select data from the type drop down
				select("ohs_incident_insurance_typedd_CSS", data.get("update_insurance_type"));
				ngDriver.waitForAngularRequestsToFinish();
				System.out.println("Selected data in the type drop down.");

				// click on the notification date field
				click("ohs_incident_insurance_notificationdate_CSS");
				ngDriver.waitForAngularRequestsToFinish();
				System.out.println("Clicked on the notification date field.");

				// click on the today button
				click("ohs_incident_insurance_notificationdate_todayduedatebtn_XPATH");
				ngDriver.waitForAngularRequestsToFinish();
				System.out.println("Clicked on the today button.");

				// update data in the Policy Number field
				clear("ohs_incident_insurance_policynumbertxt_CSS");
				ngDriver.waitForAngularRequestsToFinish();
				System.out.println("Clear the search field.");
				type("ohs_incident_insurance_policynumbertxt_CSS", data.get("update_insurance_policy_number"));
				ngDriver.waitForAngularRequestsToFinish();
				System.out.println("Updated data in the Policy Number field.");

				// update data in the loss description field
				clear("ohs_incident_insurance_lossdescription_CSS");
				ngDriver.waitForAngularRequestsToFinish();
				System.out.println("Clear the search field.");
				type("ohs_incident_insurance_lossdescription_CSS", data.get("update_short_description"));
				ngDriver.waitForAngularRequestsToFinish();
				System.out.println("Updated data in the loss description field.");

				// click on the save button
				click("ohs_incident_insurancetab_savebtn_CSS");
				ngDriver.waitForAngularRequestsToFinish();
				System.out.println("Clicked on the save button.");

				// scroll up the screen
				js.executeScript("window.scrollBy(0,-600)");

			} catch (Throwable t) {
				verificationFailed();

				// click on the cancel button
				click("ohs_incident_insurancetab_cancelbtn_XPATH");
				ngDriver.waitForAngularRequestsToFinish();
				System.out.println("Clicked on the cancel button.");

			}

		} catch (Throwable t) {
			verificationFailed();
		}

		// UPDATE DETAILS IN THE ATTACHMENTS TAB

		System.out.println("********** UPDATE DETAILS IN THE ATTACHMENTS TAB **********");
		test.log(LogStatus.INFO, "********** UPDATE DETAILS IN THE ATTACHMENTS TAB **********");
		Reporter.log("********** UPDATE DETAILS IN THE ATTACHMENTS TAB **********");
		log.info("********** UPDATE DETAILS IN THE ATTACHMENTS TAB **********");

		try {

			// click on the attachments tab
			click("ohs_incident_attachmentstab_CSS");
			ngDriver.waitForAngularRequestsToFinish();
			System.out.println("Clicked on the attachments tab.");

		} catch (Throwable t) {

			verificationFailed();

		}

		// ADD DETAILS IN THE NOTES AND COMMNETS TAB

		System.out.println("********** ADD DETAILS IN THE NOTES AND COMMNETS TAB **********");
		test.log(LogStatus.INFO, "********** ADD DETAILS IN THE NOTES AND COMMNETS TAB **********");
		Reporter.log("********** ADD DETAILS IN THE NOTES AND COMMNETS TAB **********");
		log.info("********** ADD DETAILS IN THE NOTES AND COMMNETS TAB **********");

		try {

			// click on the notes and comments tab
			click("ohs_incident_notescommentstab_CSS");
			ngDriver.waitForAngularRequestsToFinish();
			System.out.println("Clicked on the notes and comments tab.");

			// wait for the element
			Thread.sleep(7000);

			// click on the add comment button
			click("task_addcommentbtn_CSS");
			ngDriver.waitForAngularRequestsToFinish();
			System.out.println("Clicked on the add comment button.");

			// enter the comment
			clear("propertyproject_mu_commenttxt_CSS");
			ngDriver.waitForAngularRequestsToFinish();
			System.out.println("Clear the search field.");
			type("propertyproject_mu_commenttxt_CSS", data.get("short_description"));
			ngDriver.waitForAngularRequestsToFinish();
			System.out.println("Entered the comment.");

			// click on the add button
			click("task_comment_addcommentbtn_CSS");
			ngDriver.waitForAngularRequestsToFinish();
			System.out.println("Clicked on the add button.");

			// scroll down the screen
			JavascriptExecutor js = (JavascriptExecutor) driver;
			js.executeScript("window.scrollBy(0,400)");

			// verify added comment is displayed or not
			switchVerification("task_comment_addedcomment_XPATH", "Short Description for Testing Purpose",
					"The Short Description for Testing Purpose is nto displayed.");

			// click on the incident summary
			click("ohs_incident_incidentsummarytab_CSS");
			ngDriver.waitForAngularRequestsToFinish();
			System.out.println("Clicked on the incident summary.");

			// click on the update button
			click("ohs_incident_updatebtn_XPATH");
			ngDriver.waitForAngularRequestsToFinish();
			System.out.println("Clicked on the update button.");

			// wait for the element
			explicitWaitClickable("closetoastmsg_CSS");

			// click on the toaster close button
			click("closetoastmsg_CSS");
			ngDriver.waitForAngularRequestsToFinish();
			System.out.println("Clicked on the toaster close button.");

			// click on the cancel button
			click("ohs_incident_cancelbtn1_XPATH");
			ngDriver.waitForAngularRequestsToFinish();
			System.out.println("Clicked on the cancel button.");

		} catch (Throwable t) {
			verificationFailed();

			// click on the cancel button
			click("ohs_incident_personalinvolvedtab_cancelbrn_XPATH");
			ngDriver.waitForAngularRequestsToFinish();
			System.out.println("Clicked on the cancel button.");

		}

		try {

			// wait for the element
			explicitWaitClickable("ohs_incident_search_clearbtn_XPATH");

			// click on the clear button
			click("ohs_incident_search_clearbtn_XPATH");
			ngDriver.waitForAngularRequestsToFinish();
			System.out.println("Clicked on the clear button.");

			// enter the newly created incident report in the search field
			type("ohs_incident_searchtxt_CSS", data.get("update_describe_incident"));
			System.out.println("Entered the newly created incident report in the search field.");
			ngDriver.waitForAngularRequestsToFinish();

			// click on the search button
			click("ohs_incident_search_searchbtn_CSS");
			ngDriver.waitForAngularRequestsToFinish();
			System.out.println("Clicked on the search button.");

			// verification of the incident report is added or not
			switchVerification("ohs_incident_updatedincidentreport_capreit5_XPATH",
					"Update Capreit5 Describe Incident Text Testing Purpose",
					"The Update Capreit5 Describe Incident Text Testing Purpose is not displayed successfully.");

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

			// enter the property name in the search field
			type("envreports_propertylist_filtertxt_CSS", data.get("property_1"));
			ngDriver.waitForAngularRequestsToFinish();
			System.out.println("Entered the property name in the search field.");

			// click on the OHS icon from the property list page
			click("ohsicon_CSS");
			System.out.println("Clicked on the OHS icon of the Property.");
			ngDriver.waitForAngularRequestsToFinish();
			System.out.println("Navigate to the OHS screen of the perticular property.");

			// wait for the element
			Thread.sleep(5000);

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
			type("ohs_incident_searchtxt_CSS", data.get("update_describe_incident"));
			System.out.println("Entered the newly created incident report in the search field.");
			ngDriver.waitForAngularRequestsToFinish();

			// click on the search button
			click("ohs_incident_search_searchbtn_CSS");
			ngDriver.waitForAngularRequestsToFinish();
			System.out.println("Clicked on the search button.");

			// click on the updated incident report
			click("ohs_incident_updatedincidentreport_capreit5_XPATH");
			System.out.println("Clicked on the updated incident report.");
			ngDriver.waitForAngularRequestsToFinish();
			System.out.println("Naviagte to the Update Incident record Screen.");

			// wait for the element
			explicitWaitClickable("ohs_incident_deletebtn_CSS");

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
			type("ohs_incident_searchtxt_CSS", data.get("update_describe_incident"));
			System.out.println("Entered the newly created incident report in the search field.");
			ngDriver.waitForAngularRequestsToFinish();

			// click on the search button
			click("ohs_incident_search_searchbtn_CSS");
			ngDriver.waitForAngularRequestsToFinish();
			System.out.println("Clicked on the search button.");

			// verify details are deleted or not
			deleteVerification("ohs_incident_updatedincidentreport_capreit5_XPATH",
					"Update Capreit5 Describe Incident Text Testing Purpose");

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
			explicitWaitClickable("questionnaire_settingicon_CSS");

			// click on the settings icon from the top of the screen
			click("questionnaire_settingicon_CSS");
			System.out.println("Clicked on the settings icon.");
			ngDriver.waitForAngularRequestsToFinish();

			// wait for the element
			explicitWaitClickable("sidemenu_logout_CSS");

			// click on the logout option from the side menu
			click("sidemenu_logout_CSS");
			System.out.println("Clicked on the logout option from the side menu.");
			ngDriver.waitForAngularRequestsToFinish();

			// wait for the element
			explicitWaitClickable("signinbtn_BTNTEXT");

		} catch (Throwable t) {
			verificationFailed();
		}

	}
}
