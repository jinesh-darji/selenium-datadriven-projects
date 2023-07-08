package testcases.smokesuite;

import java.io.IOException;
import java.util.Hashtable;
import java.util.List;
import java.util.Random;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.testng.Reporter;
import org.testng.SkipException;
import org.testng.annotations.Test;

import com.relevantcodes.extentreports.LogStatus;

import base.Helper;
import base.TestBase;
import utilities.TestUtil;

public class RR5753ClientIssue7Test extends TestBase {

	@Test(dataProviderClass = TestUtil.class, dataProvider = "dp")
	public void rR5753ClientIssue7Test(Hashtable<String, String> data) throws IOException, InterruptedException {

		if (!(TestUtil.isTestRunnable("rR5753ClientIssue7Test", excel))) {

			throw new SkipException(
					"Skipping the test " + "rR5753ClientIssue7Test".toUpperCase() + "as the Run mode is NO");
		}

		if (!data.get("runmode").equals("Y")) {

			throw new SkipException("Skipping the test case as the Run Mode for data set is NO");
		}

		Helper helper = new Helper();

		// refresh the page
		driver.navigate().refresh();
		Thread.sleep(5000);
		driver.navigate().refresh();

		// INCIDENTS WITH INJURED EMPLOYEES NOT APPEARING IN THE HR DASHBOARD

		System.out.println(
				"******************** INCIDENTS WITH INJURED EMPLOYEES NOT APPEARING IN THE HR DASHBOARD ********************");
		test.log(LogStatus.INFO,
				"******************** INCIDENTS WITH INJURED EMPLOYEES NOT APPEARING IN THE HR DASHBOARD ********************");
		Reporter.log(
				"******************** INCIDENTS WITH INJURED EMPLOYEES NOT APPEARING IN THE HR DASHBOARD ********************");
		log.info(
				"******************** INCIDENTS WITH INJURED EMPLOYEES NOT APPEARING IN THE HR DASHBOARD ********************");

		// LOGIN WITH PROPERTY MANAGER USER

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

		// CREATE INCIDENT REPORT WITH INJURY DETAILS

		System.out.println("******************** CREATE INCIDENT REPORT WITH INJURY DETAILS ********************");
		test.log(LogStatus.INFO,
				"******************** CREATE INCIDENT REPORT WITH INJURY DETAILS ********************");
		Reporter.log("******************** CREATE INCIDENT REPORT WITH INJURY DETAILS ********************");
		log.info("******************** CREATE INCIDENT REPORT WITH INJURY DETAILS ********************");

		try {

			// enter the property name in the search field
			type("envreports_propertylist_filtertxt_CSS", data.get("property_2"));
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
			log.info("********** ADD DETAILS IN THE DETAILS, CAUSES TAB **********");

			// click on the add button
			click("ohs_incident_addbtn_CSS");
			System.out.println("Clicked on the Add button.");
			ngDriver.waitForAngularRequestsToFinish();
			System.out.println("Navigate to the Add incident report Screen");

			// wait for the element
			Thread.sleep(7000);

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

			// wait for the element
			Thread.sleep(7000);

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
				js.executeScript("window.scrollBy(0,600)");

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
				js.executeScript("window.scrollBy(0,-600)");

				// click on the nature of injury tab
				click("ohs_incident_natureofinjurytab_CSS");
				ngDriver.waitForAngularRequestsToFinish();
				System.out.println("Clicked on the nature of injury tab.");

				// wait for the element
				Thread.sleep(7000);

				// click on the abdomen checkbox
				click("ohs_incident_abdomenckbx_CSS");
				ngDriver.waitForAngularRequestsToFinish();
				System.out.println("Clicked on the abdomen checkbox.");

				// click on the left hand checkbox
				click("ohs_incident_lefthandckbx_CSS");
				ngDriver.waitForAngularRequestsToFinish();
				System.out.println("Clicked on the left hand checkbox.");

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

				// wait for the element
				Thread.sleep(7000);

				try {

					// wait for the element
					explicitWaitClickable("ohs_incident_causeofinjury_animaloption_XPATH");

					// click on the first option of the causes of injury
					click("ohs_incident_causeofinjury_animaloption_XPATH");
					ngDriver.waitForAngularRequestsToFinish();
					System.out.println("Clicked on the first option of the causes of injury.");

					// scroll down the screen
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

			// click on the next button
			click("ohs_incident_nextbtn_CSS");
			System.out.println("Clicked on the next button.");
			ngDriver.waitForAngularRequestsToFinish();

			explicitWait("ohs_incident_nextbtn_CSS");
			System.out.println("Navigate to the emergency services Tab.");
			test.log(LogStatus.INFO, "Navigate to the emergency services Tab.");
			Reporter.log("Navigate to the emergency services Tab.");
			log.info("Navigate to the emergency services Tab.");

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

			// wait for the element
			Thread.sleep(7000);

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
			switchVerification("ohs_incident_addedincidentreport_clientissue7_XPATH",
					"Clientissue7 Describe Incident Text Testing Purpose",
					"The Clientissue7 Describe Incident Text Testing Purpose is not displayed successfully.");

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
			// wait for the 5 seconds
			Thread.sleep(5000);

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

			// LOGIN WITH HR USER

			System.out.println("******************** LOGIN WITH HR USER ********************");
			test.log(LogStatus.INFO, "******************** LOGIN WITH HR USER ********************");
			Reporter.log("******************** LOGIN WITH HR USER ********************");
			log.info("******************** LOGIN WITH HR USER ********************");

			// Enter the username
			type("usernametxt_CSS", data.get("username_2"));
			ngDriver.waitForAngularRequestsToFinish();
			System.out.println("Entered the username.");

			// Enter the password
			type("passwordtxt_CSS", data.get("password_2"));
			ngDriver.waitForAngularRequestsToFinish();
			System.out.println("Entered the password.");

			// Clicking on the "Sign In" button
			click("signinbtn_BTNTEXT");
			ngDriver.waitForAngularRequestsToFinish();
			System.out.println("Clicked on the sign in button.");

			// wait for the element
			explicitWait("hrincident_dashboard_title_XPATH");

			// verify the property list
			switchVerification("hrincident_dashboard_title_XPATH", "HR Incidents", "The HR Incidentsis not displayed.");

			// wait for the element
			explicitWaitClickable("questionnaire_settingicon_CSS");

			// click on the settings icon from the top of the screen
			click("questionnaire_settingicon_CSS");
			System.out.println("Clicked on the settings icon.");
			ngDriver.waitForAngularRequestsToFinish();

			// wait for the element
			Thread.sleep(5000);

			// click on the Switch System Company option from the side menu
			click("ssc_sidemenubtn_CSS");
			System.out.println("Clicked on the Switch System Company option from the side menu.");
			ngDriver.waitForAngularRequestsToFinish();

			// click on the switch system company dropdown
			click("ssc_systemcompanydd_CSS");
			System.out.println("Clicked on the switch system company.");
			ngDriver.waitForAngularRequestsToFinish();

			// select the system company from the system company dropdown
			select("ssc_systemcompanydd_CSS", data.get("system_company_1"));
			System.out.println("The system company is selected successfully.");
			ngDriver.waitForAngularRequestsToFinish();

			// click on system company dropdown
			click("ssc_systemcompanydd_CSS");
			System.out.println("Clicked on the system company dropdown.");
			ngDriver.waitForAngularRequestsToFinish();

			// click on the select button
			click("ssc_selectbtn_BTNTEXT");
			System.out.println("Clicked on the select button.");
			ngDriver.waitForAngularRequestsToFinish();

			// wait for the element
			explicitWait("hrincident_dashboard_title_XPATH");

			// verify the property list
			switchVerification("hrincident_dashboard_title_XPATH", "HR Incidents", "The HR Incidentsis not displayed.");

			// VERIFY NEWLY CREATED INCIDENT REPORT IN HR USER

			System.out.println(
					"******************** VERIFY NEWLY CREATED INCIDENT REPORT IN HR USER ********************");
			test.log(LogStatus.INFO,
					"******************** VERIFY NEWLY CREATED INCIDENT REPORT IN HR USER ********************");
			Reporter.log("******************** VERIFY NEWLY CREATED INCIDENT REPORT IN HR USER ********************");
			log.info("******************** VERIFY NEWLY CREATED INCIDENT REPORT IN HR USER ********************");

			// scroll down the screen
			JavascriptExecutor js = (JavascriptExecutor) driver;
			js.executeScript("window.scrollBy(0,400)");

			// wait for the 5 seconds
			Thread.sleep(5000);

			// verify newly created incident report in HR Incident Dashboard
			switchVerification("hrincident_createdincident_XPATH", "Abdomen, Left Hand",
					"The Abdomen, Left Hand is not displayed.");

			// wait for the 5 seconds
			Thread.sleep(5000);

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

			// LOGIN WITH ADMIN USER

			System.out.println("******************** LOGIN WITH ADMIN USER ********************");
			test.log(LogStatus.INFO, "******************** LOGIN WITH ADMIN USER ********************");
			Reporter.log("******************** LOGIN WITH ADMIN USER ********************");
			log.info("******************** LOGIN WITH ADMIN USER ********************");

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
			helper.questionnaireNotDisplayLogout(data);
		}

		// DELETE THE NEWLY ADDED INCIDENT REPORT

		System.out.println("********** DELETE THE NEWLY ADDED INCIDENT REPORT **********");
		test.log(LogStatus.INFO, "********** DELETE THE NEWLY ADDED INCIDENT REPORT **********");
		Reporter.log("********** DELETE THE NEWLY ADDED INCIDENT REPORT **********");
		log.info("********** DELETE THE NEWLY ADDED INCIDENT REPORT **********");

		try {
			// enter the property name in the search field
			type("envreports_propertylist_filtertxt_CSS", data.get("property_2"));
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

			// click on the added incident report
			click("ohs_incident_addedincidentreport_clientissue7_XPATH");
			System.out.println("Clicked on the incident record for add the task.");
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
			type("ohs_incident_searchtxt_CSS", data.get("describe_incident"));
			System.out.println("Entered the newly created incident report in the search field.");
			ngDriver.waitForAngularRequestsToFinish();

			// click on the search button
			click("ohs_incident_search_searchbtn_CSS");
			ngDriver.waitForAngularRequestsToFinish();
			System.out.println("Clicked on the search button.");

			// verify details are deleted or not
			deleteVerification("ohs_incident_addedincidentreport_clientissue7_XPATH",
					"Clientissue7 Describe Incident Text Testing Purpose");

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

		// CREATE INCIDENT REPORT WITHOUT INJURY DETAILS

		System.out.println("******************** CREATE INCIDENT REPORT WITHOUT INJURY DETAILS ********************");
		test.log(LogStatus.INFO,
				"******************** CREATE INCIDENT REPORT WITHOUT INJURY DETAILS ********************");
		Reporter.log("******************** CREATE INCIDENT REPORT WITHOUT INJURY DETAILS ********************");
		log.info("******************** CREATE INCIDENT REPORT WITHOUT INJURY DETAILS ********************");

		try {

			// enter the property name in the search field
			type("envreports_propertylist_filtertxt_CSS", data.get("property_2"));
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
			log.info("********** ADD DETAILS IN THE DETAILS, CAUSES TAB **********");

			// click on the add button
			click("ohs_incident_addbtn_CSS");
			System.out.println("Clicked on the Add button.");
			ngDriver.waitForAngularRequestsToFinish();
			System.out.println("Navigate to the Add incident report Screen");

			// wait for the element
			Thread.sleep(7000);

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
			type("ohs_incident_shortdescriptiontxt_CSS", data.get("describe_incident1"));
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

			// click on the next button
			click("ohs_incident_nextbtn_CSS");
			System.out.println("Clicked on the next button.");
			ngDriver.waitForAngularRequestsToFinish();

			// synchronization
			explicitWait("ohs_incident_nextbtn_CSS");
			System.out.println("Navigate to the Persons Involved Tab.");
			test.log(LogStatus.INFO, "Navigate to the Persons Involved Tab.");
			Reporter.log("Navigate to the Persons Involved Tab.");
			log.info("Navigate to the Persons Involved Tab.");

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

			// click on the next button
			click("ohs_incident_nextbtn_CSS");
			System.out.println("Clicked on the next button.");
			ngDriver.waitForAngularRequestsToFinish();

			explicitWait("ohs_incident_nextbtn_CSS");
			System.out.println("Navigate to the emergency services Tab.");
			test.log(LogStatus.INFO, "Navigate to the emergency services Tab.");
			Reporter.log("Navigate to the emergency services Tab.");
			log.info("Navigate to the emergency services Tab.");

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

			// wait for the element
			Thread.sleep(7000);

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
			type("ohs_incident_searchtxt_CSS", data.get("describe_incident1"));
			System.out.println("Entered the newly created incident report in the search field.");
			ngDriver.waitForAngularRequestsToFinish();

			// click on the search button
			click("ohs_incident_search_searchbtn_CSS");
			ngDriver.waitForAngularRequestsToFinish();
			System.out.println("Clicked on the search button.");

			// verification of the incident report is added or not
			switchVerification("ohs_incident_addedincidentreport_clientissue71_XPATH",
					"Clientissue7 One Describe Incident Text Testing Purpose",
					"The Clientissue7 One Describe Incident Text Testing Purpose is not displayed successfully.");

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
			// wait for the 5 seconds
			Thread.sleep(5000);

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

			// LOGIN WITH HR USER

			System.out.println("******************** LOGIN WITH HR USER ********************");
			test.log(LogStatus.INFO, "******************** LOGIN WITH HR USER ********************");
			Reporter.log("******************** LOGIN WITH HR USER ********************");
			log.info("******************** LOGIN WITH HR USER ********************");

			// Enter the username
			type("usernametxt_CSS", data.get("username_2"));
			ngDriver.waitForAngularRequestsToFinish();
			System.out.println("Entered the username.");

			// Enter the password
			type("passwordtxt_CSS", data.get("password_2"));
			ngDriver.waitForAngularRequestsToFinish();
			System.out.println("Entered the password.");

			// Clicking on the "Sign In" button
			click("signinbtn_BTNTEXT");
			ngDriver.waitForAngularRequestsToFinish();
			System.out.println("Clicked on the sign in button.");

			// wait for the element
			explicitWait("hrincident_dashboard_title_XPATH");

			// verify the property list
			switchVerification("hrincident_dashboard_title_XPATH", "HR Incidents", "The HR Incidentsis not displayed.");

			// wait for the element
			explicitWaitClickable("questionnaire_settingicon_CSS");

			// click on the settings icon from the top of the screen
			click("questionnaire_settingicon_CSS");
			System.out.println("Clicked on the settings icon.");
			ngDriver.waitForAngularRequestsToFinish();

			// wait for the element
			Thread.sleep(5000);

			// click on the Switch System Company option from the side menu
			click("ssc_sidemenubtn_CSS");
			System.out.println("Clicked on the Switch System Company option from the side menu.");
			ngDriver.waitForAngularRequestsToFinish();

			// click on the switch system company dropdown
			click("ssc_systemcompanydd_CSS");
			System.out.println("Clicked on the switch system company.");
			ngDriver.waitForAngularRequestsToFinish();

			// select the system company from the system company dropdown
			select("ssc_systemcompanydd_CSS", data.get("system_company_1"));
			System.out.println("The system company is selected successfully.");
			ngDriver.waitForAngularRequestsToFinish();

			// click on system company dropdown
			click("ssc_systemcompanydd_CSS");
			System.out.println("Clicked on the system company dropdown.");
			ngDriver.waitForAngularRequestsToFinish();

			// click on the select button
			click("ssc_selectbtn_BTNTEXT");
			System.out.println("Clicked on the select button.");
			ngDriver.waitForAngularRequestsToFinish();

			// wait for the element
			explicitWait("hrincident_dashboard_title_XPATH");

			// verify the property list
			switchVerification("hrincident_dashboard_title_XPATH", "HR Incidents", "The HR Incidentsis not displayed.");

			// VERIFY NEWLY CREATED INCIDENT REPORT IN HR USER

			System.out.println(
					"******************** VERIFY NEWLY CREATED INCIDENT REPORT IN HR USER ********************");
			test.log(LogStatus.INFO,
					"******************** VERIFY NEWLY CREATED INCIDENT REPORT IN HR USER ********************");
			Reporter.log("******************** VERIFY NEWLY CREATED INCIDENT REPORT IN HR USER ********************");
			log.info("******************** VERIFY NEWLY CREATED INCIDENT REPORT IN HR USER ********************");

			// scroll down the screen
			JavascriptExecutor js = (JavascriptExecutor) driver;
			js.executeScript("window.scrollBy(0,400)");

			// wait for the 5 seconds
			Thread.sleep(5000);

			// verify newly created incident report in HR Incident Dashboard
			deleteVerification("hrincident_createdincident_XPATH", "Abdomen, Left Hand");

			// wait for the 5 seconds
			Thread.sleep(5000);

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

			// LOGIN WITH ADMIN USER

			System.out.println("******************** LOGIN WITH ADMIN USER ********************");
			test.log(LogStatus.INFO, "******************** LOGIN WITH ADMIN USER ********************");
			Reporter.log("******************** LOGIN WITH ADMIN USER ********************");
			log.info("******************** LOGIN WITH ADMIN USER ********************");

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
			helper.questionnaireNotDisplayLogout(data);
		}

		// DELETE THE NEWLY ADDED INCIDENT REPORT

		System.out.println("********** DELETE THE NEWLY ADDED INCIDENT REPORT **********");
		test.log(LogStatus.INFO, "********** DELETE THE NEWLY ADDED INCIDENT REPORT **********");
		Reporter.log("********** DELETE THE NEWLY ADDED INCIDENT REPORT **********");
		log.info("********** DELETE THE NEWLY ADDED INCIDENT REPORT **********");

		try {
			// enter the property name in the search field
			type("envreports_propertylist_filtertxt_CSS", data.get("property_2"));
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

			// click on the clear button
			click("ohs_incident_search_clearbtn_XPATH");
			ngDriver.waitForAngularRequestsToFinish();
			System.out.println("Clicked on the clear button.");

			// enter the newly created incident report in the search field
			type("ohs_incident_searchtxt_CSS", data.get("describe_incident1"));
			System.out.println("Entered the newly created incident report in the search field.");
			ngDriver.waitForAngularRequestsToFinish();

			// click on the search button
			click("ohs_incident_search_searchbtn_CSS");
			ngDriver.waitForAngularRequestsToFinish();
			System.out.println("Clicked on the search button.");

			// click on the added incident report
			click("ohs_incident_addedincidentreport_clientissue71_XPATH");
			System.out.println("Clicked on the incident record for add the task.");
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
			type("ohs_incident_searchtxt_CSS", data.get("describe_incident1"));
			System.out.println("Entered the newly created incident report in the search field.");
			ngDriver.waitForAngularRequestsToFinish();

			// click on the search button
			click("ohs_incident_search_searchbtn_CSS");
			ngDriver.waitForAngularRequestsToFinish();
			System.out.println("Clicked on the search button.");

			// verify details are deleted or not
			deleteVerification("ohs_incident_addedincidentreport_clientissue71_XPATH",
					"Clientissue7 One Describe Incident Text Testing Purpose");

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
