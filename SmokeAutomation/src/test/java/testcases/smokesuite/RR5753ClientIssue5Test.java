package testcases.smokesuite;

import java.io.IOException;
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

public class RR5753ClientIssue5Test extends TestBase {

	@Test(dataProviderClass = TestUtil.class, dataProvider = "dp")
	public void rR5753ClientIssue5Test(Hashtable<String, String> data) throws IOException, InterruptedException {

		if (!(TestUtil.isTestRunnable("rR5753ClientIssue5Test", excel))) {

			throw new SkipException(
					"Skipping the test " + "rR5753ClientIssue5Test".toUpperCase() + "as the Run mode is NO");
		}

		if (!data.get("runmode").equals("Y")) {

			throw new SkipException("Skipping the test case as the Run Mode for data set is NO");
		}

		// refresh the page
		driver.navigate().refresh();
		Thread.sleep(5000);
		driver.navigate().refresh();

		// INCIDENT REPORTS - UPDATE/DELETE BUTTONS DISAPPEAR IF WE MOVE TO
		// HISTORY/OWNERS SCREENS - RR-4511

		System.out.println(
				"******************** INCIDENT REPORTS - UPDATE/DELETE BUTTONS DISAPPEAR IF WE MOVE TO HISTORY/OWNERS SCREENS - RR-4511 ********************");
		test.log(LogStatus.INFO,
				"******************** INCIDENT REPORTS - UPDATE/DELETE BUTTONS DISAPPEAR IF WE MOVE TO HISTORY/OWNERS SCREENS - RR-4511 ********************");
		Reporter.log(
				"******************** INCIDENT REPORTS - UPDATE/DELETE BUTTONS DISAPPEAR IF WE MOVE TO HISTORY/OWNERS SCREENS - RR-4511 ********************");
		log.info(
				"******************** INCIDENT REPORTS - UPDATE/DELETE BUTTONS DISAPPEAR IF WE MOVE TO HISTORY/OWNERS SCREENS - RR-4511 ********************");

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

		// CREATE NEW OHS INCIDENTS

		System.out.println("******************** CREATE NEW OHS INCIDENTS ********************");
		test.log(LogStatus.INFO, "******************** CREATE NEW OHS INCIDENTS ********************");
		Reporter.log("******************** CREATE NEW OHS INCIDENTS ********************");
		log.info("******************** CREATE NEW OHS INCIDENTS ********************");

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
			log.info("********** ADD DETAILS IN THE DETAILS, CAUSES TAB **********");

			// click on the add button
			click("ohs_incident_addbtn_CSS");
			System.out.println("Clicked on the Add button.");
			ngDriver.waitForAngularRequestsToFinish();
			System.out.println("Navigate to the Add incident report Screen");

			// wait for the element
			Thread.sleep(10000);

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
			switchVerification("ohs_incident_addedincidentreport_clientissue5_XPATH",
					"Clientissue5 Describe Incident Text Testing Purpose",
					"The Clientissue5 Describe Incident Text Testing Purpose is not displayed successfully.");

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

		// VERIFY UPDATE AND DELETE BUTTON IS DISPLAYED OR NOT AFTER SWITCH FROM THE
		// HISTORY TAB

		System.out.println(
				"******************** VERIFY UPDATE AND DELETE BUTTON IS DISPLAYED OR NOT AFTER SWITCH FROM THE HISTORY TAB ********************");
		test.log(LogStatus.INFO,
				"******************** VERIFY UPDATE AND DELETE BUTTON IS DISPLAYED OR NOT AFTER SWITCH FROM THE HISTORY TAB ********************");
		Reporter.log(
				"******************** VERIFY UPDATE AND DELETE BUTTON IS DISPLAYED OR NOT AFTER SWITCH FROM THE HISTORY TAB ********************");
		log.info(
				"******************** VERIFY UPDATE AND DELETE BUTTON IS DISPLAYED OR NOT AFTER SWITCH FROM THE HISTORY TAB ********************");
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
			ngDriver.waitForAngularRequestsToFinish();
			System.out.println("Clicked on the burger menu button successfully!!!");

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

			// click on the newly created incident report
			click("ohs_incident_addedincidentreport_clientissue5_XPATH");
			ngDriver.waitForAngularRequestsToFinish();
			System.out.println("Clicked on the newly created incident report.");

			// wait for the element
			Thread.sleep(5000);

			// verify update button is displayed or not
			try {

				boolean updatebtn = driver.findElement(By.xpath(OR.getProperty("ohs_incident_updatebtn_XPATH")))
						.isDisplayed();

				if (updatebtn == true) {
					System.out.println("THE UPDATE BUTTON IS DISPLAYED SUCCESSFULLY.");
					test.log(LogStatus.INFO, "THE UPDATE BUTTON IS DISPLAYED SUCCESSFULLY.");
					Reporter.log("THE UPDATE BUTTON IS DISPLAYED SUCCESSFULLY.");
					log.info("THE UPDATE BUTTON IS DISPLAYED SUCCESSFULLY.");
				} else {

					verificationFailed();

					System.out.println("THE UPDATE BUTTON IS NOT DISPLAYED.");
					test.log(LogStatus.INFO, "THE UPDATE BUTTON IS NOT DISPLAYED.");
					Reporter.log("THE UPDATE BUTTON IS NOT DISPLAYED.");
					log.info("THE UPDATE BUTTON IS NOT DISPLAYED.");

				}
			} catch (Throwable t) {
				verificationFailed();

				System.out.println("THE UPDATE BUTTON IS NOT DISPLAYED.");
				test.log(LogStatus.INFO, "THE UPDATE BUTTON IS NOT DISPLAYED.");
				Reporter.log("THE UPDATE BUTTON IS NOT DISPLAYED.");
				log.info("THE UPDATE BUTTON IS NOT DISPLAYED.");
			}

			// verify delete button is displayed or not
			try {

				boolean deletebtn = driver.findElement(By.cssSelector(OR.getProperty("ohs_incident_deletebtn_CSS")))
						.isDisplayed();

				if (deletebtn == true) {
					System.out.println("THE DELETE BUTTON IS DISPLAYED SUCCESSFULLY.");
					test.log(LogStatus.INFO, "THE DELETE BUTTON IS DISPLAYED SUCCESSFULLY.");
					Reporter.log("THE DELETE BUTTON IS DISPLAYED SUCCESSFULLY.");
					log.info("THE DELETE BUTTON IS DISPLAYED SUCCESSFULLY.");
				} else {

					verificationFailed();

					System.out.println("THE DELETE BUTTON IS NOT DISPLAYED.");
					test.log(LogStatus.INFO, "THE DELETE BUTTON IS NOT DISPLAYED.");
					Reporter.log("THE DELETE BUTTON IS NOT DISPLAYED.");
					log.info("THE DELETE BUTTON IS NOT DISPLAYED.");

				}
			} catch (Throwable t) {
				verificationFailed();

				System.out.println("THE DELETE BUTTON IS NOT DISPLAYED.");
				test.log(LogStatus.INFO, "THE DELETE BUTTON IS NOT DISPLAYED.");
				Reporter.log("THE DELETE BUTTON IS NOT DISPLAYED.");
				log.info("THE DELETE BUTTON IS NOT DISPLAYED.");
			}

			// click on the history icon
			click("ohs_incident_historyicon_XPATH");
			ngDriver.waitForAngularRequestsToFinish();
			System.out.println("Clicked on the history icon.");

			// wait for the element
			Thread.sleep(5000);

			// verify update button is displayed or not
			try {

				boolean updatebtn = driver.findElement(By.xpath(OR.getProperty("ohs_incident_updatebtn_XPATH")))
						.isDisplayed();

				if (updatebtn == true) {

					verificationFailed();

					System.out.println("THE UPDATE BUTTON IS DISPLAYED.");
					test.log(LogStatus.INFO, "THE UPDATE BUTTON IS DISPLAYED.");
					Reporter.log("THE UPDATE BUTTON IS DISPLAYED.");
					log.info("THE UPDATE BUTTON IS DISPLAYED.");

				} else {

					System.out.println("THE UPDATE BUTTON IS NOT DISPLAYED AS EXPECTED.");
					test.log(LogStatus.INFO, "THE UPDATE BUTTON IS NOT DISPLAYED AS EXPECTED.");
					Reporter.log("THE UPDATE BUTTON IS NOT DISPLAYED AS EXPECTED.");
					log.info("THE UPDATE BUTTON IS NOT DISPLAYED AS EXPECTED.");

				}
			} catch (Throwable t) {
				System.out.println("THE UPDATE BUTTON IS NOT DISPLAYED AS EXPECTED.");
				test.log(LogStatus.INFO, "THE UPDATE BUTTON IS NOT DISPLAYED AS EXPECTED.");
				Reporter.log("THE UPDATE BUTTON IS NOT DISPLAYED AS EXPECTED.");
				log.info("THE UPDATE BUTTON IS NOT DISPLAYED AS EXPECTED.");
			}

			// verify delete button is displayed or not
			try {

				boolean deletebtn = driver.findElement(By.cssSelector(OR.getProperty("ohs_incident_deletebtn_CSS")))
						.isDisplayed();

				if (deletebtn == true) {

					verificationFailed();

					System.out.println("THE DELETE BUTTON IS DISPLAYED.");
					test.log(LogStatus.INFO, "THE DELETE BUTTON IS DISPLAYED.");
					Reporter.log("THE DELETE BUTTON IS DISPLAYED.");
					log.info("THE DELETE BUTTON IS DISPLAYED.");

				} else {

					System.out.println("THE DELETE BUTTON IS NOT DISPLAYED AS EXPECTED.");
					test.log(LogStatus.INFO, "THE DELETE BUTTON IS NOT DISPLAYED AS EXPECTED.");
					Reporter.log("THE DELETE BUTTON IS NOT DISPLAYED AS EXPECTED.");
					log.info("THE DELETE BUTTON IS NOT DISPLAYED AS EXPECTED.");

				}
			} catch (Throwable t) {
				System.out.println("THE DELETE BUTTON IS NOT DISPLAYED AS EXPECTED.");
				test.log(LogStatus.INFO, "THE DELETE BUTTON IS NOT DISPLAYED AS EXPECTED.");
				Reporter.log("THE DELETE BUTTON IS NOT DISPLAYED AS EXPECTED.");
				log.info("THE DELETE BUTTON IS NOT DISPLAYED AS EXPECTED.");
			}

			// verify history record screen is displayed or not
			switchVerification("ohs_incident_historyrecords_recordauditlogtitle_XPATH", "Record Audit Log",
					"The Record Audit Log screen is not displayed.");

			// click on the summary icon
			click("ohs_incident_summaryicon_XPATH");
			ngDriver.waitForAngularRequestsToFinish();
			System.out.println("Clicked on the summary icon.");

			// wait for the element
			Thread.sleep(5000);

			// verify update button is displayed or not
			try {

				boolean updatebtn = driver.findElement(By.xpath(OR.getProperty("ohs_incident_updatebtn_XPATH")))
						.isDisplayed();

				if (updatebtn == true) {
					System.out.println("THE UPDATE BUTTON IS DISPLAYED SUCCESSFULLY.");
					test.log(LogStatus.INFO, "THE UPDATE BUTTON IS DISPLAYED SUCCESSFULLY.");
					Reporter.log("THE UPDATE BUTTON IS DISPLAYED SUCCESSFULLY.");
					log.info("THE UPDATE BUTTON IS DISPLAYED SUCCESSFULLY.");
				} else {

					verificationFailed();

					System.out.println("THE UPDATE BUTTON IS NOT DISPLAYED.");
					test.log(LogStatus.INFO, "THE UPDATE BUTTON IS NOT DISPLAYED.");
					Reporter.log("THE UPDATE BUTTON IS NOT DISPLAYED.");
					log.info("THE UPDATE BUTTON IS NOT DISPLAYED.");

				}
			} catch (Throwable t) {
				verificationFailed();

				System.out.println("THE UPDATE BUTTON IS NOT DISPLAYED.");
				test.log(LogStatus.INFO, "THE UPDATE BUTTON IS NOT DISPLAYED.");
				Reporter.log("THE UPDATE BUTTON IS NOT DISPLAYED.");
				log.info("THE UPDATE BUTTON IS NOT DISPLAYED.");
			}

			// verify delete button is displayed or not
			try {

				boolean deletebtn = driver.findElement(By.cssSelector(OR.getProperty("ohs_incident_deletebtn_CSS")))
						.isDisplayed();

				if (deletebtn == true) {
					System.out.println("THE DELETE BUTTON IS DISPLAYED SUCCESSFULLY.");
					test.log(LogStatus.INFO, "THE DELETE BUTTON IS DISPLAYED SUCCESSFULLY.");
					Reporter.log("THE DELETE BUTTON IS DISPLAYED SUCCESSFULLY.");
					log.info("THE DELETE BUTTON IS DISPLAYED SUCCESSFULLY.");
				} else {

					verificationFailed();

					System.out.println("THE DELETE BUTTON IS NOT DISPLAYED.");
					test.log(LogStatus.INFO, "THE DELETE BUTTON IS NOT DISPLAYED.");
					Reporter.log("THE DELETE BUTTON IS NOT DISPLAYED.");
					log.info("THE DELETE BUTTON IS NOT DISPLAYED.");

				}
			} catch (Throwable t) {
				verificationFailed();

				System.out.println("THE DELETE BUTTON IS NOT DISPLAYED.");
				test.log(LogStatus.INFO, "THE DELETE BUTTON IS NOT DISPLAYED.");
				Reporter.log("THE DELETE BUTTON IS NOT DISPLAYED.");
				log.info("THE DELETE BUTTON IS NOT DISPLAYED.");
			}

			// AGAIN REVERIFY UPDATE AND DELETE BUTTON WHEN SWITCH FROM THE HISTORY RECORD
			// SCREEN

			System.out.println(
					"******************** AGAIN REVERIFY UPDATE AND DELETE BUTTON WHEN SWITCH FROM THE HISTORY RECORD SCREEN ********************");
			test.log(LogStatus.INFO,
					"******************** AGAIN REVERIFY UPDATE AND DELETE BUTTON WHEN SWITCH FROM THE HISTORY RECORD SCREEN ********************");
			Reporter.log(
					"******************** AGAIN REVERIFY UPDATE AND DELETE BUTTON WHEN SWITCH FROM THE HISTORY RECORD SCREEN ********************");
			log.info(
					"******************** AGAIN REVERIFY UPDATE AND DELETE BUTTON WHEN SWITCH FROM THE HISTORY RECORD SCREEN ********************");

			// click on the history icon
			click("ohs_incident_historyicon_XPATH");
			ngDriver.waitForAngularRequestsToFinish();
			System.out.println("Clicked on the history icon.");

			// wait for the element
			Thread.sleep(5000);

			// verify update button is displayed or not
			try {

				boolean updatebtn = driver.findElement(By.xpath(OR.getProperty("ohs_incident_updatebtn_XPATH")))
						.isDisplayed();

				if (updatebtn == true) {

					verificationFailed();

					System.out.println("THE UPDATE BUTTON IS DISPLAYED.");
					test.log(LogStatus.INFO, "THE UPDATE BUTTON IS DISPLAYED.");
					Reporter.log("THE UPDATE BUTTON IS DISPLAYED.");
					log.info("THE UPDATE BUTTON IS DISPLAYED.");

				} else {

					System.out.println("THE UPDATE BUTTON IS NOT DISPLAYED AS EXPECTED.");
					test.log(LogStatus.INFO, "THE UPDATE BUTTON IS NOT DISPLAYED AS EXPECTED.");
					Reporter.log("THE UPDATE BUTTON IS NOT DISPLAYED AS EXPECTED.");
					log.info("THE UPDATE BUTTON IS NOT DISPLAYED AS EXPECTED.");

				}
			} catch (Throwable t) {
				System.out.println("THE UPDATE BUTTON IS NOT DISPLAYED AS EXPECTED.");
				test.log(LogStatus.INFO, "THE UPDATE BUTTON IS NOT DISPLAYED AS EXPECTED.");
				Reporter.log("THE UPDATE BUTTON IS NOT DISPLAYED AS EXPECTED.");
				log.info("THE UPDATE BUTTON IS NOT DISPLAYED AS EXPECTED.");
			}

			// verify delete button is displayed or not
			try {

				boolean deletebtn = driver.findElement(By.cssSelector(OR.getProperty("ohs_incident_deletebtn_CSS")))
						.isDisplayed();

				if (deletebtn == true) {

					verificationFailed();

					System.out.println("THE DELETE BUTTON IS DISPLAYED.");
					test.log(LogStatus.INFO, "THE DELETE BUTTON IS DISPLAYED.");
					Reporter.log("THE DELETE BUTTON IS DISPLAYED.");
					log.info("THE DELETE BUTTON IS DISPLAYED.");

				} else {

					System.out.println("THE DELETE BUTTON IS NOT DISPLAYED AS EXPECTED.");
					test.log(LogStatus.INFO, "THE DELETE BUTTON IS NOT DISPLAYED AS EXPECTED.");
					Reporter.log("THE DELETE BUTTON IS NOT DISPLAYED AS EXPECTED.");
					log.info("THE DELETE BUTTON IS NOT DISPLAYED AS EXPECTED.");

				}
			} catch (Throwable t) {
				System.out.println("THE DELETE BUTTON IS NOT DISPLAYED AS EXPECTED.");
				test.log(LogStatus.INFO, "THE DELETE BUTTON IS NOT DISPLAYED AS EXPECTED.");
				Reporter.log("THE DELETE BUTTON IS NOT DISPLAYED AS EXPECTED.");
				log.info("THE DELETE BUTTON IS NOT DISPLAYED AS EXPECTED.");
			}

			// verify history record screen is displayed or not
			switchVerification("ohs_incident_historyrecords_recordauditlogtitle_XPATH", "Record Audit Log",
					"The Record Audit Log screen is not displayed.");

			// click on the summary icon
			click("ohs_incident_summaryicon_XPATH");
			ngDriver.waitForAngularRequestsToFinish();
			System.out.println("Clicked on the summary icon.");

			// wait for the element
			Thread.sleep(5000);

			// verify update button is displayed or not
			try {

				boolean updatebtn = driver.findElement(By.xpath(OR.getProperty("ohs_incident_updatebtn_XPATH")))
						.isDisplayed();

				if (updatebtn == true) {
					System.out.println("THE UPDATE BUTTON IS DISPLAYED SUCCESSFULLY.");
					test.log(LogStatus.INFO, "THE UPDATE BUTTON IS DISPLAYED SUCCESSFULLY.");
					Reporter.log("THE UPDATE BUTTON IS DISPLAYED SUCCESSFULLY.");
					log.info("THE UPDATE BUTTON IS DISPLAYED SUCCESSFULLY.");
				} else {

					verificationFailed();

					System.out.println("THE UPDATE BUTTON IS NOT DISPLAYED.");
					test.log(LogStatus.INFO, "THE UPDATE BUTTON IS NOT DISPLAYED.");
					Reporter.log("THE UPDATE BUTTON IS NOT DISPLAYED.");
					log.info("THE UPDATE BUTTON IS NOT DISPLAYED.");

				}
			} catch (Throwable t) {
				verificationFailed();

				System.out.println("THE UPDATE BUTTON IS NOT DISPLAYED.");
				test.log(LogStatus.INFO, "THE UPDATE BUTTON IS NOT DISPLAYED.");
				Reporter.log("THE UPDATE BUTTON IS NOT DISPLAYED.");
				log.info("THE UPDATE BUTTON IS NOT DISPLAYED.");
			}

			// verify delete button is displayed or not
			try {

				boolean deletebtn = driver.findElement(By.cssSelector(OR.getProperty("ohs_incident_deletebtn_CSS")))
						.isDisplayed();

				if (deletebtn == true) {
					System.out.println("THE DELETE BUTTON IS DISPLAYED SUCCESSFULLY.");
					test.log(LogStatus.INFO, "THE DELETE BUTTON IS DISPLAYED SUCCESSFULLY.");
					Reporter.log("THE DELETE BUTTON IS DISPLAYED SUCCESSFULLY.");
					log.info("THE DELETE BUTTON IS DISPLAYED SUCCESSFULLY.");
				} else {

					verificationFailed();

					System.out.println("THE DELETE BUTTON IS NOT DISPLAYED.");
					test.log(LogStatus.INFO, "THE DELETE BUTTON IS NOT DISPLAYED.");
					Reporter.log("THE DELETE BUTTON IS NOT DISPLAYED.");
					log.info("THE DELETE BUTTON IS NOT DISPLAYED.");

				}
			} catch (Throwable t) {
				verificationFailed();

				System.out.println("THE DELETE BUTTON IS NOT DISPLAYED.");
				test.log(LogStatus.INFO, "THE DELETE BUTTON IS NOT DISPLAYED.");
				Reporter.log("THE DELETE BUTTON IS NOT DISPLAYED.");
				log.info("THE DELETE BUTTON IS NOT DISPLAYED.");
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

		// DELETE THE NEWLY CREATED INCIDENT REPORT

		System.out.println("********** DELETE THE NEWLY CREATED INCIDENT REPORT **********");
		test.log(LogStatus.INFO, "********** DELETE THE NEWLY CREATED INCIDENT REPORT **********");
		Reporter.log("********** DELETE THE NEWLY CREATED INCIDENT REPORT **********");
		log.info("********** DELETE THE NEWLY CREATED INCIDENT REPORT **********");

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
			type("ohs_incident_searchtxt_CSS", data.get("describe_incident"));
			System.out.println("Entered the newly created incident report in the search field.");
			ngDriver.waitForAngularRequestsToFinish();

			// click on the search button
			click("ohs_incident_search_searchbtn_CSS");
			ngDriver.waitForAngularRequestsToFinish();
			System.out.println("Clicked on the search button.");

			// click on the incident report
			click("ohs_incident_addedincidentreport_clientissue5_XPATH");
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
			explicitWaitClickable("closetoastmsg_CSS");

			// click on the toaster close button
			click("closetoastmsg_CSS");
			ngDriver.waitForAngularRequestsToFinish();
			System.out.println("Clicked on the toaster close button.");

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
			deleteVerification("ohs_incident_addedincidentreport_clientissue5_XPATH",
					"Clientissue5 Describe Incident Text Testing Purpose");

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
