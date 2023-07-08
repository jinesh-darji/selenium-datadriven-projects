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

public class RR5255OHSOneTest extends TestBase {

	@Test(dataProviderClass = TestUtil.class, dataProvider = "dp")
	public void rR5255OHSOneTest(Hashtable<String, String> data) throws IOException, InterruptedException {

		execution(data, "rR5255OHSOneTest");

		// SECURITY SETTING CONTROLS TO MAKE SURE THE ACCESS TO INSURANCE DATA IN
		// INCIDENT REPORT CAN BE ONLY PERFORMED BY THE USER/ROLE WITH ACCESS TO IT.

		System.out.println(
				"SECURITY SETTING CONTROLS TO MAKE SURE THE ACCESS TO INSURANCE DATA IN INCIDENT REPORT CAN BE ONLY PERFORMED BY THE USER/ROLE WITH ACCESS TO IT.");
		test.log(LogStatus.INFO,
				"SECURITY SETTING CONTROLS TO MAKE SURE THE ACCESS TO INSURANCE DATA IN INCIDENT REPORT CAN BE ONLY PERFORMED BY THE USER/ROLE WITH ACCESS TO IT.");
		Reporter.log(
				"SECURITY SETTING CONTROLS TO MAKE SURE THE ACCESS TO INSURANCE DATA IN INCIDENT REPORT CAN BE ONLY PERFORMED BY THE USER/ROLE WITH ACCESS TO IT.");
		log.info(
				"SECURITY SETTING CONTROLS TO MAKE SURE THE ACCESS TO INSURANCE DATA IN INCIDENT REPORT CAN BE ONLY PERFORMED BY THE USER/ROLE WITH ACCESS TO IT.");

		Helper helper = new Helper();

		// refresh the page
		driver.navigate().refresh();
		Thread.sleep(5000);
		driver.navigate().refresh();

		System.out.println("Navigate to the Home Screen i.e. Property List Screen.");

		String insuranceNumber = null;

		// APPLY THE ACCESS TO INSURANCE DATA IN INCIDENT REPORT PERMISSION

		System.out.println("********** APPLY THE ACCESS TO INSURANCE DATA IN INCIDENT REPORT PERMISSION **********");
		test.log(LogStatus.INFO,
				"********** APPLY THE ACCESS TO INSURANCE DATA IN INCIDENT REPORT PERMISSION **********");
		Reporter.log("********** APPLY THE ACCESS TO INSURANCE DATA IN INCIDENT REPORT PERMISSION **********");
		log.info("********** APPLY THE ACCESS TO INSURANCE DATA IN INCIDENT REPORT PERMISSION **********");

		try {
			// wait for the element
			explicitWaitClickable("questionnaire_settingicon_CSS");

			// click on the settings icon from the top of the screen
			click("questionnaire_settingicon_CSS");
			System.out.println("Clicked on the settings icon.");
			ngDriver.waitForAngularRequestsToFinish();

			// wait for the element
			explicitWaitClickable("questionnaire_administrationoption_XPATH");

			// click on the Administration option from the side menu
			click("questionnaire_administrationoption_XPATH");
			System.out.println("Clicked on the Administration option from the side menu.");
			ngDriver.waitForAngularRequestsToFinish();

			// click on the security tab
			click("questionnaire_securitytab_XPATH");
			System.out.println("Clicked on the security tab.");
			ngDriver.waitForAngularRequestsToFinish();

			// click on the security settings option
			click("questionnaire_securotysettingsoption_XPATH");
			System.out.println("Clicked on the security settings option.");
			ngDriver.waitForAngularRequestsToFinish();

			// APPLY THE ACCESS TO INSURANCE DATA IN INCIDENT REPORT PERMISSION
			helper.addPermissionOneUsersRole(data, "ohs_security_setting_1", "ohs_securitysettings1_XPATH");

			// APPLY THE ACCESS TO OHS INCIDENT REPORTS
			helper.addPermissionTwoUsersRole(data, "ohs_security_setting_2", "ohs_securitysettings2_XPATH");

		} catch (Throwable t) {
			verificationFailed();
		}

		// click on the home icon
		click("questionnaire_homeburgermenubtn_CSS");
		ngDriver.waitForAngularRequestsToFinish();
		System.out.println("Clicked on the home icon.");

		// wait for the element
		explicitWait("propertylist_title_XPATH");

		// verify the property list
		switchVerification("propertylist_title_XPATH", "Property List", "The property list is not displayed.");

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
			switchVerification("ohs_incident_addedinsurance_XPATH", "Add Company Name Test",
					"The Add Company Name Test is not displayed.");

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
			switchVerification("ohs_incident_addedincidentreport4_XPATH",
					"Describe Incident Text SS One Testing Purpose",
					"The Describe Incident Text SS One Testing Purpose is not displayed successfully.");

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

			// wait for 5 seconds
			Thread.sleep(5000);

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

			// VERIFY THE INSURANCE TAB IS ACCESS IN JINESH USER OR NOT

			System.out.println(
					"**************** VERIFY THE INSURANCE TAB IS ACCESS IN JINESH USER OR NOT ****************");
			test.log(LogStatus.INFO,
					"**************** VERIFY THE INSURANCE TAB IS ACCESS IN JINESH USER OR NOT ****************");
			Reporter.log("**************** VERIFY THE INSURANCE TAB IS ACCESS IN JINESH USER OR NOT ****************");
			log.info("**************** VERIFY THE INSURANCE TAB IS ACCESS IN JINESH USER OR NOT ****************");

			System.out.println("**************** LOGIN IN JINESH USER ****************");
			test.log(LogStatus.INFO, "**************** LOGIN IN JINESH USER ****************");
			Reporter.log("**************** LOGIN IN JINESH USER ****************");
			log.info("**************** LOGIN IN JINESH USER ****************");

			helper.loginAndUpdateSystemCompany(data, "username", "password", "system_company_1");

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
				switchVerification("ohs_incident_addedincidentreport4_XPATH",
						"Describe Incident Text SS One Testing Purpose",
						"The Describe Incident Text SS One Testing Purpose is not displayed successfully.");

				// click on the incident report
				click("ohs_incident_addedincidentreport4_XPATH");
				ngDriver.waitForAngularRequestsToFinish();
				System.out.println("Clicked on the incident report.");

				try {
					boolean ss1 = driver.findElement(By.cssSelector(OR.getProperty("ohs_incident_ss_insurancetab_CSS")))
							.isDisplayed();

					if (ss1 == true) {

						System.out.println("The insurance tab is displayed as expected.");
						test.log(LogStatus.INFO, "The insurance tab is displayed as expected.");
						Reporter.log("The insurance tab is displayed as expected.");
						log.info("The insurance tab is displayed as expected.");

					} else {
						TestUtil.captureScreenshot();

						// ReportNG
						Reporter.log("<br>" + " The insurance tab is not displayed : " + "<br>");
						Reporter.log("<a target=\"_blank\" href=" + TestUtil.screenshotName + "><img src="
								+ TestUtil.screenshotName + " height=200 width=200></img></a>");
						Reporter.log("<br>");
						Reporter.log("<br>");

						// Extent Report
						test.log(LogStatus.FAIL, " The insurance tab is not displayed : ");
						test.log(LogStatus.FAIL, test.addScreenCapture(TestUtil.screenshotName));

						System.out.println("The insurance tab is not displayed.");
						log.info("The insurance tab is not displayed.");
					}

				} catch (Throwable t) {
					TestUtil.captureScreenshot();

					// ReportNG
					Reporter.log("<br>" + " The insurance tab is not displayed : " + "<br>");
					Reporter.log("<a target=\"_blank\" href=" + TestUtil.screenshotName + "><img src="
							+ TestUtil.screenshotName + " height=200 width=200></img></a>");
					Reporter.log("<br>");
					Reporter.log("<br>");

					// Extent Report
					test.log(LogStatus.FAIL, " The insurance tab is not displayed : ");
					test.log(LogStatus.FAIL, test.addScreenCapture(TestUtil.screenshotName));

					System.out.println("The insurance tab is not displayed.");
					log.info("The insurance tab is not displayed.");
				}

			} catch (Throwable t) {

				verificationFailed();
			}

			// click on the home icon from the top of the screen
			click("questionnaire_homeburgermenubtn_hide_CSS");
			System.out.println("Clicked on the home icon from the top of the screen.");
			ngDriver.waitForAngularRequestsToFinish();

			// wait for the element
			explicitWait("propertylist_title_XPATH");

			// verify the property list
			switchVerification("propertylist_title_XPATH", "Property List", "The property list is not displayed.");

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

			// VERIFY THE ADD, EDIT AND DELETE ACCESS IN THE CONTRACTOR ROLE

			System.out.println(
					"**************** VERIFY THE INSURANCE TAB IS ACCESS IN THE CONTRACTOR ROLE ****************");
			test.log(LogStatus.INFO,
					"**************** VERIFY THE INSURANCE TAB IS ACCESS IN THE CONTRACTOR ROLE ****************");
			Reporter.log("**************** VERIFY THE INSURANCE TAB IS ACCESS IN THE CONTRACTOR ROLE ****************");
			log.info("**************** VERIFY THE INSURANCE TAB IS ACCESS IN THE CONTRACTOR ROLE ****************");

			System.out.println("**************** LOGIN IN JINESH CONTRACTOR USER ****************");
			test.log(LogStatus.INFO, "**************** LOGIN IN JINESH CONTRACTOR USER ****************");
			Reporter.log("**************** LOGIN IN JINESH CONTRACTOR USER ****************");
			log.info("**************** LOGIN IN JINESH CONTRACTOR USER ****************");

			helper.loginAndUpdateSystemCompany(data, "username_2", "password_2", "system_company_1");

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
				switchVerification("ohs_incident_addedincidentreport4_XPATH",
						"Describe Incident Text SS One Testing Purpose",
						"The Describe Incident Text SS One Testing Purpose is not displayed successfully.");

				// click on the incident report
				click("ohs_incident_addedincidentreport4_XPATH");
				ngDriver.waitForAngularRequestsToFinish();
				System.out.println("Clicked on the incident report.");

				try {
					boolean ss2 = driver.findElement(By.cssSelector(OR.getProperty("ohs_incident_ss_insurancetab_CSS")))
							.isDisplayed();

					if (ss2 == true) {

						System.out.println("The insurance tab is displayed as expected.");
						test.log(LogStatus.INFO, "The insurance tab is displayed as expected.");
						Reporter.log("The insurance tab is displayed as expected.");
						log.info("The insurance tab is displayed as expected.");

					} else {
						TestUtil.captureScreenshot();

						// ReportNG
						Reporter.log("<br>" + " The insurance tab is not displayed : " + "<br>");
						Reporter.log("<a target=\"_blank\" href=" + TestUtil.screenshotName + "><img src="
								+ TestUtil.screenshotName + " height=200 width=200></img></a>");
						Reporter.log("<br>");
						Reporter.log("<br>");

						// Extent Report
						test.log(LogStatus.FAIL, " The insurance tab is not displayed : ");
						test.log(LogStatus.FAIL, test.addScreenCapture(TestUtil.screenshotName));

						System.out.println("The insurance tab is not displayed.");
						log.info("The insurance tab is not displayed.");
					}

				} catch (Throwable t) {
					TestUtil.captureScreenshot();

					// ReportNG
					Reporter.log("<br>" + " The insurance tab is not displayed : " + "<br>");
					Reporter.log("<a target=\"_blank\" href=" + TestUtil.screenshotName + "><img src="
							+ TestUtil.screenshotName + " height=200 width=200></img></a>");
					Reporter.log("<br>");
					Reporter.log("<br>");

					// Extent Report
					test.log(LogStatus.FAIL, " The insurance tab is not displayed : ");
					test.log(LogStatus.FAIL, test.addScreenCapture(TestUtil.screenshotName));

					System.out.println("The insurance tab is not displayed.");
					log.info("The insurance tab is not displayed.");
				}

			} catch (Throwable t) {

				verificationFailed();
			}

			// click on the home icon from the top of the screen
			click("questionnaire_homeburgermenubtn_hide_CSS");
			System.out.println("Clicked on the home icon from the top of the screen.");
			ngDriver.waitForAngularRequestsToFinish();

			// wait for the element
			explicitWait("propertylist_title_XPATH");

			// verify the property list
			switchVerification("propertylist_title_XPATH", "Property List", "The property list is not displayed.");

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

			// VERIFY THE ADD, EDIT AND DELETE ACCESS IN THE CONTRACTOR ROLE

			System.out.println(
					"**************** VERIFY THE ADD, EDIT AND DELETE ACCESS IN THE JINESH HR ****************");
			test.log(LogStatus.INFO,
					"**************** VERIFY THE ADD, EDIT AND DELETE ACCESS IN THE JINESH HR ****************");
			Reporter.log("**************** VERIFY THE ADD, EDIT AND DELETE ACCESS IN THE JINESH HR ****************");
			log.info("**************** VERIFY THE ADD, EDIT AND DELETE ACCESS IN THE JINESH HR ****************");

			System.out.println("**************** LOGIN IN JINESH HR USER ****************");
			test.log(LogStatus.INFO, "**************** LOGIN IN JINESH HR USER ****************");
			Reporter.log("**************** LOGIN IN JINESH HR USER ****************");
			log.info("**************** LOGIN IN JINESH HR USER ****************");

			helper.loginAndUpdateSystemCompany(data, "username_3", "password_3", "system_company_1");

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
				switchVerification("ohs_incident_addedincidentreport4_XPATH",
						"Describe Incident Text SS One Testing Purpose",
						"The Describe Incident Text SS One Testing Purpose is not displayed successfully.");

				// click on the incident report
				click("ohs_incident_addedincidentreport4_XPATH");
				ngDriver.waitForAngularRequestsToFinish();
				System.out.println("Clicked on the incident report.");

				try {
					boolean ss3 = driver.findElement(By.cssSelector(OR.getProperty("ohs_incident_ss_insurancetab_CSS")))
							.isDisplayed();

					if (ss3 == true) {

						TestUtil.captureScreenshot();

						// ReportNG
						Reporter.log("<br>" + " The insurance tab is displayed withour permission : " + "<br>");
						Reporter.log("<a target=\"_blank\" href=" + TestUtil.screenshotName + "><img src="
								+ TestUtil.screenshotName + " height=200 width=200></img></a>");
						Reporter.log("<br>");
						Reporter.log("<br>");

						// Extent Report
						test.log(LogStatus.FAIL, " The insurance tab is displayed withour permission : ");
						test.log(LogStatus.FAIL, test.addScreenCapture(TestUtil.screenshotName));

						System.out.println("The insurance tab is displayed withour permission.");
						log.info("The insurance tab is displayed withour permission.");

					} else {

						System.out.println("The insurance tab is not displayed as expected.");
						test.log(LogStatus.INFO, "The insurance tab is not displayed as expected.");
						Reporter.log("The insurance tab is not displayed as expected.");
						log.info("The insurance tab is not displayed as expected.");

					}

				} catch (Throwable t) {

					System.out.println("The insurance tab is not displayed as expected.");
					test.log(LogStatus.INFO, "The insurance tab not is displayed as expected.");
					Reporter.log("The insurance tab is not displayed as expected.");
					log.info("The insurance tab is not displayed as expected.");

				}

			} catch (Throwable t) {

				verificationFailed();
			}

			// click on the home icon from the top of the screen
			click("questionnaire_homeburgermenubtn_hide_CSS");
			System.out.println("Clicked on the home icon from the top of the screen.");
			ngDriver.waitForAngularRequestsToFinish();

			// wait for the element
			explicitWait("propertylist_title_XPATH");

			// verify the property list
			switchVerification("propertylist_title_XPATH", "Property List", "The property list is not displayed.");

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

			// DELETE THE CREATED MORTGAGE UNDERTAKING AND RESET THE GIVEN PERMISSIONS

			System.out.println(
					"**************** DELETE THE CREATED INCIDENT REPORT AND RESET THE GIVEN PERMISSIONS ****************");
			test.log(LogStatus.INFO,
					"**************** DELETE THE CREATED INCIDENT REPORT AND RESET THE GIVEN PERMISSIONS ****************");
			Reporter.log(
					"**************** DELETE THE CREATED INCIDENT REPORT AND RESET THE GIVEN PERMISSIONS ****************");
			log.info(
					"**************** DELETE THE CREATED INCIDENT REPORT AND RESET THE GIVEN PERMISSIONS ****************");

			System.out.println("**************** LOGIN IN AUTOMATION TESTER USER ****************");
			test.log(LogStatus.INFO, "**************** LOGIN IN AUTOMATION TESTER USER ****************");
			Reporter.log("**************** LOGIN IN AUTOMATION TESTER USER ****************");
			log.info("**************** LOGIN IN AUTOMATION TESTER USER ****************");

			helper.loginAndUpdateSystemCompany(data, "username_1", "password_1", "system_company_1");

		} catch (Throwable t) {

			helper.questionnaireNotDisplayLogout(data);
		}

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
			switchVerification("ohs_incident_addedincidentreport4_XPATH",
					"Describe Incident Text SS One Testing Purpose",
					"The Describe Incident Text SS One Testing Purpose is not displayed successfully.");

			// click on the incident report
			click("ohs_incident_addedincidentreport4_XPATH");
			ngDriver.waitForAngularRequestsToFinish();
			System.out.println("Clicked on the incident report.");

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
			helper.deleteVerification("ohs_incident_addedincidentreport4_XPATH",
					"Describe Incident Text SS One Testing Purpose");

		} catch (Throwable t) {
			verificationFailed();
		}

		// click on the home icon from the top of the screen
		click("questionnaire_homeburgermenubtn_hide_CSS");
		System.out.println("Clicked on the home icon from the top of the screen.");
		ngDriver.waitForAngularRequestsToFinish();

		// wait for the element
		explicitWait("propertylist_title_XPATH");

		// verify the property list
		switchVerification("propertylist_title_XPATH", "Property List", "The property list is not displayed.");

		System.out.println("**************** RESET THE APPLIED PERMISSIONS ****************");
		test.log(LogStatus.INFO, "**************** RESET THE APPLIED PERMISSIONS ****************");
		Reporter.log("**************** RESET THE APPLIED PERMISSIONS ****************");
		log.info("**************** RESET THE APPLIED PERMISSIONS ****************");

		try {
			// wait for the element
			explicitWaitClickable("questionnaire_settingicon_CSS");

			// click on the settings icon from the top of the screen
			click("questionnaire_settingicon_CSS");
			System.out.println("Clicked on the settings icon.");
			ngDriver.waitForAngularRequestsToFinish();

			// wait for the element
			explicitWaitClickable("questionnaire_administrationoption_XPATH");

			// click on the Administration option from the side menu
			click("questionnaire_administrationoption_XPATH");
			System.out.println("Clicked on the Administration option from the side menu.");
			ngDriver.waitForAngularRequestsToFinish();

			// click on the security tab
			click("questionnaire_securitytab_XPATH");
			System.out.println("Clicked on the security tab.");
			ngDriver.waitForAngularRequestsToFinish();

			// click on the security settings option
			click("questionnaire_securotysettingsoption_XPATH");
			System.out.println("Clicked on the security settings option.");
			ngDriver.waitForAngularRequestsToFinish();

			// RESET THE ACCESS TO INSURANCE DATA IN INCIDENT REPORT PERMISSION
			helper.resetPermission(data, "ohs_security_setting_1", "ohs_securitysettings1_XPATH");

			// RESET THE ACCESS TO OHS INCIDENT REPORTS PERMISSION
			helper.resetPermission(data, "ohs_security_setting_2", "ohs_securitysettings2_XPATH");

		} catch (Throwable t) {
			verificationFailed();
		}

		// click on the home icon
		click("questionnaire_homeburgermenubtn_CSS");
		ngDriver.waitForAngularRequestsToFinish();
		System.out.println("Clicked on the home icon.");

		// wait for the element
		explicitWait("propertylist_title_XPATH");

		// verify the property list
		switchVerification("propertylist_title_XPATH", "Property List", "The property list is not displayed.");

	}
}
