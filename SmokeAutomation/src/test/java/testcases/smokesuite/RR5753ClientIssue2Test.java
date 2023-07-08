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

import base.Helper;
import base.TestBase;
import utilities.TestUtil;

public class RR5753ClientIssue2Test extends TestBase {

	@Test(dataProviderClass = TestUtil.class, dataProvider = "dp")
	public void rR5753ClientIssue2Test(Hashtable<String, String> data) throws IOException, InterruptedException {

		if (!(TestUtil.isTestRunnable("rR5753ClientIssue2Test", excel))) {

			throw new SkipException(
					"Skipping the test " + "rR5753ClientIssue2Test".toUpperCase() + "as the Run mode is NO");
		}

		if (!data.get("runmode").equals("Y")) {

			throw new SkipException("Skipping the test case as the Run Mode for data set is NO");
		}

		Helper helper = new Helper();

		// refresh the page
		driver.navigate().refresh();
		Thread.sleep(5000);
		driver.navigate().refresh();

		// MOVE BUTTON SHOULDN'T BE AVAILABLE IN INCIDENT PORTAL REGARDLESS OF
		// PERMISSION - RR-5621

		System.out.println(
				"******************** MOVE BUTTON SHOULDN'T BE AVAILABLE IN INCIDENT PORTAL REGARDLESS OF PERMISSION - RR-5621 ********************");
		test.log(LogStatus.INFO,
				"******************** MOVE BUTTON SHOULDN'T BE AVAILABLE IN INCIDENT PORTAL REGARDLESS OF PERMISSION - RR-5621 ********************");
		Reporter.log(
				"******************** MOVE BUTTON SHOULDN'T BE AVAILABLE IN INCIDENT PORTAL REGARDLESS OF PERMISSION - RR-5621 ********************");
		log.info(
				"******************** MOVE BUTTON SHOULDN'T BE AVAILABLE IN INCIDENT PORTAL REGARDLESS OF PERMISSION - RR-5621 ********************");

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

		// CREATE A NEW INCIDENT REPORT

		System.out.println("******************** CREATE A NEW INCIDENT REPORT ********************");
		test.log(LogStatus.INFO, "******************** CREATE A NEW INCIDENT REPORT ********************");
		Reporter.log("******************** CREATE A NEW INCIDENT REPORT ********************");
		log.info("******************** CREATE A NEW INCIDENT REPORT ********************");

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
			switchVerification("ohs_incident_addedincidentreport_clientissue2_XPATH",
					"Clientissue2 Describe Incident Text Testing Purpose",
					"The Clientissue2 Describe Incident Text Testing Purpose is not displayed successfully.");

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

		// VALIDATE THE MOVE BUTTON IS DISPLAYED IN THE INCIDENT REPORTS WHEN PERMISSION
		// IS GRANTED

		System.out.println(
				"******************** VALIDATE THE MOVE BUTTON IS DISPLAYED IN THE INCIDENT REPORTS WHEN PERMISSION IS GRANTED ********************");
		test.log(LogStatus.INFO,
				"******************** VALIDATE THE MOVE BUTTON IS DISPLAYED IN THE INCIDENT REPORTS WHEN PERMISSION IS GRANTED ********************");
		Reporter.log(
				"******************** VALIDATE THE MOVE BUTTON IS DISPLAYED IN THE INCIDENT REPORTS WHEN PERMISSION IS GRANTED ********************");
		log.info(
				"******************** VALIDATE THE MOVE BUTTON IS DISPLAYED IN THE INCIDENT REPORTS WHEN PERMISSION IS GRANTED ********************");

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

			// enter the newly created incident report in the search field
			clear("ohs_incident_searchtxt_CSS");
			type("ohs_incident_searchtxt_CSS", data.get("describe_incident"));
			System.out.println("Entered the newly created incident report in the search field.");
			ngDriver.waitForAngularRequestsToFinish();

			// verify move button is displayed or not
			try {
				boolean movebtn1 = driver.findElement(By.cssSelector(OR.getProperty("ohs_incident_movebtn_CSS")))
						.isDisplayed();
				if (movebtn1 == true) {
					System.out.println("THE MOVE BUTTON IS DISPLAYED AS EXPECTED.");
					test.log(LogStatus.INFO, "THE MOVE BUTTON IS DISPLAYED AS EXPECTED.");
					Reporter.log("THE MOVE BUTTON IS DISPLAYED AS EXPECTED.");
					log.info("THE MOVE BUTTON IS DISPLAYED AS EXPECTED.");
				} else {

					verificationFailed();

					System.out.println("THE MOVE BUTTON IS NOT DISPLAYED.");
					test.log(LogStatus.INFO, "THE MOVE BUTTON IS NOT DISPLAYED.");
					Reporter.log("THE MOVE BUTTON IS NOT DISPLAYED.");
					log.info("THE MOVE BUTTON IS NOT DISPLAYED.");

				}
			} catch (Throwable t) {
				verificationFailed();

				System.out.println("THE MOVE BUTTON IS NOT DISPLAYED.");
				test.log(LogStatus.INFO, "THE MOVE BUTTON IS NOT DISPLAYED.");
				Reporter.log("THE MOVE BUTTON IS NOT DISPLAYED.");
				log.info("THE MOVE BUTTON IS NOT DISPLAYED.");
			}

			// verify the checkbox for move incident report

			try {
				String moveCheckbox_XPATH = "//td[text()='" + data.get("describe_incident")
						+ "']//preceding-sibling::td//input[@ng-click='selectRecordToMove(record)']";

				boolean moveCheckbox = driver.findElement(By.xpath(moveCheckbox_XPATH)).isDisplayed();

				if (moveCheckbox == true) {

					System.out.println("THE CHECKBOX FOR THE MOVE INCIDENT REPORT IS DISPLAYED SUCCESSFULLY.");
					test.log(LogStatus.INFO, "THE CHECKBOX FOR THE MOVE INCIDENT REPORT IS DISPLAYED SUCCESSFULLY.");
					Reporter.log("THE CHECKBOX FOR THE MOVE INCIDENT REPORT IS DISPLAYED SUCCESSFULLY.");
					log.info("THE CHECKBOX FOR THE MOVE INCIDENT REPORT IS DISPLAYED SUCCESSFULLY.");

				} else {
					verificationFailed();

					System.out.println("THE CHECKBOX FOR THE MOVE INCIDENT REPORT IS NOT DISPLAYED.");
					test.log(LogStatus.INFO, "THE CHECKBOX FOR THE MOVE INCIDENT REPORT IS NOT DISPLAYED.");
					Reporter.log("THE CHECKBOX FOR THE MOVE INCIDENT REPORT IS NOT DISPLAYED.");
					log.info("THE CHECKBOX FOR THE MOVE INCIDENT REPORT IS NOT DISPLAYED.");

				}
			} catch (Throwable t) {
				verificationFailed();

				System.out.println("THE CHECKBOX FOR THE MOVE INCIDENT REPORT IS NOT DISPLAYED.");
				test.log(LogStatus.INFO, "THE CHECKBOX FOR THE MOVE INCIDENT REPORT IS NOT DISPLAYED.");
				Reporter.log("THE CHECKBOX FOR THE MOVE INCIDENT REPORT IS NOT DISPLAYED.");
				log.info("THE CHECKBOX FOR THE MOVE INCIDENT REPORT IS NOT DISPLAYED.");
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

		// UPDATE THE SESURITY SETTINGS OF THE MOVE BUTTON OF INCIDENT REPORT

		System.out.println(
				"******************** UPDATE THE SESURITY SETTINGS OF THE MOVE BUTTON OF INCIDENT REPORT ********************");
		test.log(LogStatus.INFO,
				"******************** UPDATE THE SESURITY SETTINGS OF THE MOVE BUTTON OF INCIDENT REPORT ********************");
		Reporter.log(
				"******************** UPDATE THE SESURITY SETTINGS OF THE MOVE BUTTON OF INCIDENT REPORT ********************");
		log.info(
				"******************** UPDATE THE SESURITY SETTINGS OF THE MOVE BUTTON OF INCIDENT REPORT ********************");

		try {
			// wait for the element
			explicitWaitClickable("questionnaire_settingicon_CSS");

			// click on the settings icon from the top of the screen
			click("questionnaire_settingicon_CSS");
			System.out.println("Clicked on the settings icon.");
			ngDriver.waitForAngularRequestsToFinish();

			// wait for the element
			Thread.sleep(5000);

			// click on the Administration option from the side menu
			click("questionnaire_administrationoption_XPATH");
			ngDriver.waitForAngularRequestsToFinish();
			System.out.println("Clicked on the Administration option from the side menu.");

			// wait for the element
			Thread.sleep(5000);

			// click on the security tab
			click("questionnaire_securitytab_XPATH");
			ngDriver.waitForAngularRequestsToFinish();
			System.out.println("Clicked on the security tab.");

			// click on the security settings option
			click("questionnaire_securotysettingsoption_XPATH");
			ngDriver.waitForAngularRequestsToFinish();
			System.out.println("Clicked on the security settings option.");

			// enter security setting name in the search field
			clear("propertyproject_le_filtertxt_CSS");
			type("propertyproject_le_filtertxt_CSS", data.get("permission_1"));
			ngDriver.waitForAngularRequestsToFinish();
			System.out.println("Entered security setting name in the search field.");

			// click on the searched result
			click("administration_securitysettings_accessincidentreport_XPATH");
			ngDriver.waitForAngularRequestsToFinish();
			System.out.println("Clicked on the searched result.");

			// click on the select role field
			click("propertyproject_securitysettings1_selectroles_CSS");
			ngDriver.waitForAngularRequestsToFinish();
			System.out.println("Clicked on the select role field.");

			// click on the none button
			click("propertyproject_securitysettings1_nonebtn_CSS");
			ngDriver.waitForAngularRequestsToFinish();
			System.out.println("Clicked on the none button.");

			// enter the name of the role in search field
			clear("propertyproject_securitysettings1_searchtxt_CSS");
			type("propertyproject_securitysettings1_searchtxt_CSS", data.get("role_1"));
			ngDriver.waitForAngularRequestsToFinish();
			System.out.println("Entered the name of the role in search field.");

			// click on the searched result
			click("propertyproject_securitysettings1_searchedpm1_XPATH");
			ngDriver.waitForAngularRequestsToFinish();
			System.out.println("Clicked on the searched result.");

			// click on the select role field
			click("propertyproject_securitysettings1_selectroles_CSS");
			ngDriver.waitForAngularRequestsToFinish();
			System.out.println("Clicked on the select role field.");

			// click on the save button
			click("propertyproject_securitysettings1_savebtn_CSS");
			ngDriver.waitForAngularRequestsToFinish();
			System.out.println("Clicked on the save button.");

			// wait for the element
			explicitWaitClickable("closetoastmsg_CSS");

			// click on the toaster close button
			click("closetoastmsg_CSS");
			ngDriver.waitForAngularRequestsToFinish();
			System.out.println("Clicked on the toaster close button.");

			// enter security setting name in the search field
			clear("propertyproject_le_filtertxt_CSS");
			type("propertyproject_le_filtertxt_CSS", data.get("permission_2"));
			ngDriver.waitForAngularRequestsToFinish();
			System.out.println("Entered security setting name in the search field.");

			// click on the searched result
			click("administration_securitysettings_moveincidentreport_XPATH");
			ngDriver.waitForAngularRequestsToFinish();
			System.out.println("Clicked on the searched result.");

			// click on the select role field
			click("propertyproject_securitysettings1_selectroles_CSS");
			ngDriver.waitForAngularRequestsToFinish();
			System.out.println("Clicked on the select role field.");

			// click on the none button
			click("propertyproject_securitysettings1_nonebtn_CSS");
			ngDriver.waitForAngularRequestsToFinish();
			System.out.println("Clicked on the none button.");

			// click on the select role field
			click("propertyproject_securitysettings1_selectroles_CSS");
			ngDriver.waitForAngularRequestsToFinish();
			System.out.println("Clicked on the select role field.");

			// click on the select user field
			click("propertyproject_securitysettings1_selectusers_CSS");
			ngDriver.waitForAngularRequestsToFinish();
			System.out.println("Clicked on the select user field.");

			// click on the none button
			click("propertyproject_securitysettings1_nonebtn_CSS");
			ngDriver.waitForAngularRequestsToFinish();
			System.out.println("Clicked on the none button.");

			// click on the select user field
			click("propertyproject_securitysettings1_selectusers_CSS");
			ngDriver.waitForAngularRequestsToFinish();
			System.out.println("Clicked on the select user field.");

			// click on the save button
			click("propertyproject_securitysettings1_savebtn_CSS");
			ngDriver.waitForAngularRequestsToFinish();
			System.out.println("Clicked on the save button.");

			// wait for the element
			explicitWaitClickable("closetoastmsg_CSS");

			// click on the toaster close button
			click("closetoastmsg_CSS");
			ngDriver.waitForAngularRequestsToFinish();
			System.out.println("Clicked on the toaster close button.");

		} catch (Throwable t) {
			verificationFailed();
		}

		// click on the home icon from the top of the screen
		click("questionnaire_homeburgermenubtn_CSS");
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

			// Enter the username
			type("usernametxt_CSS", data.get("username"));
			ngDriver.waitForAngularRequestsToFinish();
			System.out.println("Entered the username.");

			// Enter the password
			type("passwordtxt_CSS", data.get("password"));
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

			// VALIDATE THE MOVE BUTTON IS DISPLAYED IN THE INCIDENT REPORTS WHEN PERMISSION
			// IS NOT GRANTED

			System.out.println(
					"******************** VALIDATE THE MOVE BUTTON IS DISPLAYED IN THE INCIDENT REPORTS WHEN PERMISSION IS NOT GRANTED ********************");
			test.log(LogStatus.INFO,
					"******************** VALIDATE THE MOVE BUTTON IS DISPLAYED IN THE INCIDENT REPORTS WHEN PERMISSION IS NOT GRANTED ********************");
			Reporter.log(
					"******************** VALIDATE THE MOVE BUTTON IS DISPLAYED IN THE INCIDENT REPORTS WHEN PERMISSION IS NOT GRANTED ********************");
			log.info(
					"******************** VALIDATE THE MOVE BUTTON IS DISPLAYED IN THE INCIDENT REPORTS WHEN PERMISSION IS NOT GRANTED ********************");

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

				// enter the newly created incident report in the search field
				clear("ohs_incident_searchtxt_CSS");
				type("ohs_incident_searchtxt_CSS", data.get("describe_incident"));
				System.out.println("Entered the newly created incident report in the search field.");
				ngDriver.waitForAngularRequestsToFinish();

				// verify move button is displayed or not
				try {
					boolean movebtn1 = driver.findElement(By.xpath(OR.getProperty("ohs_incident_movebtn_CSS")))
							.isDisplayed();
					if (movebtn1 == true) {

						verificationFailed();

						System.out.println("THE MOVE BUTTON IS DISPLAYED WITHOUT PERMISSION.");
						test.log(LogStatus.INFO, "THE MOVE BUTTON IS DISPLAYED WITHOUT PERMISSION.");
						Reporter.log("THE MOVE BUTTON IS DISPLAYED WITHOUT PERMISSION.");
						log.info("THE MOVE BUTTON IS DISPLAYED WITHOUT PERMISSION.");
					} else {

						System.out.println("THE MOVE BUTTON IS NOT DISPLAYED AS EXPECTED.");
						test.log(LogStatus.INFO, "THE MOVE BUTTON IS NOT DISPLAYED AS EXPECTED.");
						Reporter.log("THE MOVE BUTTON IS NOT DISPLAYED AS EXPECTED.");
						log.info("THE MOVE BUTTON IS NOT DISPLAYED AS EXPECTED.");

					}
				} catch (Throwable t) {

					System.out.println("THE MOVE BUTTON IS NOT DISPLAYED AS EXPECTED.");
					test.log(LogStatus.INFO, "THE MOVE BUTTON IS NOT DISPLAYED AS EXPECTED.");
					Reporter.log("THE MOVE BUTTON IS NOT DISPLAYED AS EXPECTED.");
					log.info("THE MOVE BUTTON IS NOT DISPLAYED AS EXPECTED.");

				}

				// verify the checkbox for move incident report

				try {
					String moveCheckbox_XPATH = "//td[text()='" + data.get("describe_incident")
							+ "']//preceding-sibling::td//input[@ng-click='selectRecordToMove(record)']";

					boolean moveCheckbox = driver.findElement(By.xpath(moveCheckbox_XPATH)).isDisplayed();

					if (moveCheckbox == true) {

						verificationFailed();

						System.out.println("THE CHECKBOX FOR THE MOVE INCIDENT REPORT IS DISPLAYED.");
						test.log(LogStatus.INFO, "THE CHECKBOX FOR THE MOVE INCIDENT REPORT IS DISPLAYED.");
						Reporter.log("THE CHECKBOX FOR THE MOVE INCIDENT REPORT IS DISPLAYED.");
						log.info("THE CHECKBOX FOR THE MOVE INCIDENT REPORT IS DISPLAYED.");

					} else {

						System.out.println("THE CHECKBOX FOR THE MOVE INCIDENT REPORT IS NOT DISPLAYED AS EXPECTED.");
						test.log(LogStatus.INFO,
								"THE CHECKBOX FOR THE MOVE INCIDENT REPORT IS NOT DISPLAYED AS EXPECTED.");
						Reporter.log("THE CHECKBOX FOR THE MOVE INCIDENT REPORT IS NOT DISPLAYED AS EXPECTED.");
						log.info("THE CHECKBOX FOR THE MOVE INCIDENT REPORT IS NOT DISPLAYED AS EXPECTED.");

					}
				} catch (Throwable t) {
					System.out.println("THE CHECKBOX FOR THE MOVE INCIDENT REPORT IS NOT DISPLAYED AS EXPECTED.");
					test.log(LogStatus.INFO, "THE CHECKBOX FOR THE MOVE INCIDENT REPORT IS NOT DISPLAYED AS EXPECTED.");
					Reporter.log("THE CHECKBOX FOR THE MOVE INCIDENT REPORT IS NOT DISPLAYED AS EXPECTED.");
					log.info("THE CHECKBOX FOR THE MOVE INCIDENT REPORT IS NOT DISPLAYED AS EXPECTED.");
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

		// RESET THE SESURITY SETTINGS OF THE MOVE BUTTON OF INCIDENT REPORT

		System.out.println(
				"******************** RESET THE SESURITY SETTINGS OF THE MOVE BUTTON OF INCIDENT REPORT ********************");
		test.log(LogStatus.INFO,
				"******************** RESET THE SESURITY SETTINGS OF THE MOVE BUTTON OF INCIDENT REPORT ********************");
		Reporter.log(
				"******************** RESET THE SESURITY SETTINGS OF THE MOVE BUTTON OF INCIDENT REPORT ********************");
		log.info(
				"******************** RESET THE SESURITY SETTINGS OF THE MOVE BUTTON OF INCIDENT REPORT ********************");

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
			ngDriver.waitForAngularRequestsToFinish();
			System.out.println("Clicked on the Administration option from the side menu.");

			// click on the security tab
			click("questionnaire_securitytab_XPATH");
			ngDriver.waitForAngularRequestsToFinish();
			System.out.println("Clicked on the security tab.");

			// click on the security settings option
			click("questionnaire_securotysettingsoption_XPATH");
			ngDriver.waitForAngularRequestsToFinish();
			System.out.println("Clicked on the security settings option.");

			// enter security setting name in the search field
			clear("propertyproject_le_filtertxt_CSS");
			type("propertyproject_le_filtertxt_CSS", data.get("permission_1"));
			ngDriver.waitForAngularRequestsToFinish();
			System.out.println("Entered security setting name in the search field.");

			// click on the searched result
			click("administration_securitysettings_accessincidentreport_XPATH");
			ngDriver.waitForAngularRequestsToFinish();
			System.out.println("Clicked on the searched result.");

			// click on the select role field
			click("propertyproject_securitysettings1_selectroles_CSS");
			ngDriver.waitForAngularRequestsToFinish();
			System.out.println("Clicked on the select role field.");

			// click on the none button
			click("propertyproject_securitysettings1_nonebtn_CSS");
			ngDriver.waitForAngularRequestsToFinish();
			System.out.println("Clicked on the none button.");

			// click on the select role field
			click("propertyproject_securitysettings1_selectroles_CSS");
			ngDriver.waitForAngularRequestsToFinish();
			System.out.println("Clicked on the select role field.");

			// click on the select user field
			click("propertyproject_securitysettings1_selectusers_CSS");
			ngDriver.waitForAngularRequestsToFinish();
			System.out.println("Clicked on the select user field.");

			// click on the none button
			click("propertyproject_securitysettings1_nonebtn_CSS");
			ngDriver.waitForAngularRequestsToFinish();
			System.out.println("Clicked on the none button.");

			// click on the select user field
			click("propertyproject_securitysettings1_selectusers_CSS");
			ngDriver.waitForAngularRequestsToFinish();
			System.out.println("Clicked on the select user field.");

			// click on the save button
			click("propertyproject_securitysettings1_savebtn_CSS");
			ngDriver.waitForAngularRequestsToFinish();
			System.out.println("Clicked on the save button.");

			// wait for the element
			explicitWaitClickable("closetoastmsg_CSS");

			// click on the toaster close button
			click("closetoastmsg_CSS");
			ngDriver.waitForAngularRequestsToFinish();
			System.out.println("Clicked on the toaster close button.");

			// enter security setting name in the search field
			clear("propertyproject_le_filtertxt_CSS");
			type("propertyproject_le_filtertxt_CSS", data.get("permission_2"));
			ngDriver.waitForAngularRequestsToFinish();
			System.out.println("Entered security setting name in the search field.");

			// click on the searched result
			click("administration_securitysettings_moveincidentreport_XPATH");
			ngDriver.waitForAngularRequestsToFinish();
			System.out.println("Clicked on the searched result.");

			// click on the select role field
			click("propertyproject_securitysettings1_selectroles_CSS");
			ngDriver.waitForAngularRequestsToFinish();
			System.out.println("Clicked on the select role field.");

			// click on the none button
			click("propertyproject_securitysettings1_nonebtn_CSS");
			ngDriver.waitForAngularRequestsToFinish();
			System.out.println("Clicked on the none button.");

			// click on the select role field
			click("propertyproject_securitysettings1_selectroles_CSS");
			ngDriver.waitForAngularRequestsToFinish();
			System.out.println("Clicked on the select role field.");

			// click on the select user field
			click("propertyproject_securitysettings1_selectusers_CSS");
			ngDriver.waitForAngularRequestsToFinish();
			System.out.println("Clicked on the select user field.");

			// click on the none button
			click("propertyproject_securitysettings1_nonebtn_CSS");
			ngDriver.waitForAngularRequestsToFinish();
			System.out.println("Clicked on the none button.");

			// click on the select user field
			click("propertyproject_securitysettings1_selectusers_CSS");
			ngDriver.waitForAngularRequestsToFinish();
			System.out.println("Clicked on the select user field.");

			// click on the save button
			click("propertyproject_securitysettings1_savebtn_CSS");
			ngDriver.waitForAngularRequestsToFinish();
			System.out.println("Clicked on the save button.");

			// wait for the element
			explicitWaitClickable("closetoastmsg_CSS");

			// click on the toaster close button
			click("closetoastmsg_CSS");
			ngDriver.waitForAngularRequestsToFinish();
			System.out.println("Clicked on the toaster close button.");

		} catch (Throwable t) {
			verificationFailed();
		}

		// click on the home icon from the top of the screen
		click("questionnaire_homeburgermenubtn_CSS");
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

			// click on the incident report
			click("ohs_incident_addedincidentreport_clientissue2_XPATH");
			System.out.println("Clicked on the incident report.");
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
			clear("ohs_incident_searchtxt_CSS");
			type("ohs_incident_searchtxt_CSS", data.get("describe_incident"));
			System.out.println("Entered the newly created incident report in the search field.");
			ngDriver.waitForAngularRequestsToFinish();

			// click on the search button
			click("ohs_incident_search_searchbtn_CSS");
			ngDriver.waitForAngularRequestsToFinish();
			System.out.println("Clicked on the search button.");

			// verify details are deleted or not
			deleteVerification("ohs_incident_addedincidentreport_clientissue2_XPATH",
					"Clientissue2 Describe Incident Text Testing Purpose");

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
