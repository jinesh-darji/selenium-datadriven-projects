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

		execution(data, "rR5753ClientIssue5Test");

		// refresh the page
		driver.navigate().refresh();
		Thread.sleep(5000);
		driver.navigate().refresh();

		// INCIDENT REPORTS - UPDATE/DELETE BUTTONS DISAPPEAR IF WE MOVE TO
		// HISTORY/OWNERS SCREENS - RR-4511
		title("INCIDENT REPORTS - UPDATE/DELETE BUTTONS DISAPPEAR IF WE MOVE TO HISTORY/OWNERS SCREENS - RR-4511");

		// LOGIN WITH ADMIN USER
		title("LOGIN WITH ADMIN USER");

		try {
			// wait for the element
			explicitWaitClickable("signinbtn_BTNTEXT");

			// Enter the username
			type("usernametxt_CSS", data.get("username_1"));

			// Enter the password
			type("passwordtxt_CSS", data.get("password_1"));

			// Clicking on the "Sign In" button
			click("signinbtn_BTNTEXT");

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
		title("CREATE NEW OHS INCIDENTS");

		try {

			// enter the property name in the search field
			type("envreports_propertylist_filtertxt_CSS", data.get("property_1"));

			// click on the OHS icon from the property list page
			click("ohsicon_CSS");

			// wait for the element
			Thread.sleep(5000);

			// click on the burger menu
			click("menubtn_CSS");

			// wait for the element
			Thread.sleep(5000);

			// click on the incident reports
			click("questionnaire_option_ohstab_incidentreports_XPATH");

			// ADD DETAILS IN THE INCIDENT REPORT TAB
			title("ADD DETAILS IN THE INCIDENT REPORT TAB");

			// click on the add button
			click("ohs_incident_addbtn_CSS");

			// wait for the element
			Thread.sleep(10000);

			// enter the incident time - hours

			type("ohs_incident_hourstxt_CSS", "11");

			// enter the incident time - minute

			type("ohs_incident_minutestxt_CSS", "20");

			// scroll down the screen

			scrollByPixel(500);

			// enter the short description
			type("ohs_incident_shortdescriptiontxt_CSS", data.get("describe_incident"));

			// click on the add event type button
			click("ohs_incident_addeventtypebtn_CSS");

			// click on the event type dropdown
			select("ohs_incident_eventtypedd_CSS", data.get("event_type"));

			// click on the add button of the add event type record model
			click("ohs_incident_eventty_addbtn_CSS");

			// click on the next button
			click("ohs_incident_nextbtn_CSS");

			// synchronization
			explicitWait("ohs_incident_nextbtn_CSS");

			consoleMessage("Navigate to the Details, Cause Tab..");

			// click on the next button
			click("ohs_incident_nextbtn_CSS");

			// synchronization
			explicitWait("ohs_incident_personsinvolved_addbtn_CSS");

			consoleMessage("Navigate to the Persons Involved Tab.");

			// click on the next button
			click("ohs_incident_nextbtn_CSS");

			// synchronization
			explicitWait("ohs_incident_nextbtn_CSS");

			consoleMessage("Navigate to the Witnesses Tab.");

			// click on the next button
			click("ohs_incident_nextbtn_CSS");

			explicitWait("ohs_incident_nextbtn_CSS");

			consoleMessage("Navigate to the emergency services Tab.");

			// click on the next button
			click("ohs_incident_nextbtn_CSS");

			// synchronization
			explicitWait("ohs_incident_nextbtn_CSS");

			consoleMessage("Navigate to the property damage Tab.");

			// click on the next button
			click("ohs_incident_nextbtn_CSS");

			// synchronization
			explicitWait("ohs_incident_nextbtn_CSS");

			consoleMessage("Navigate to the insurance Tab.");

			// click on the next button
			click("ohs_incident_nextbtn_CSS");

			// synchronization
			explicitWait("ohs_incident_updaterecordbtn_CSS");

			consoleMessage("Navigate to the attachments Tab.");

			// click on the update record button
			click("ohs_incident_updaterecordbtn_CSS");

			// wait for the element
			explicitWaitClickable("ohs_incident_search_clearbtn_XPATH");

			// click on the clear button
			click("ohs_incident_search_clearbtn_XPATH");

			// enter the newly created incident report in the search field
			type("ohs_incident_searchtxt_CSS", data.get("describe_incident"));

			// click on the search button
			click("ohs_incident_search_searchbtn_CSS");

			// verification of the incident report is added or not
			switchVerification("ohs_incident_addedincidentreport_clientissue5_XPATH",
					"Clientissue5 Describe Incident Text Testing Purpose",
					"The Clientissue5 Describe Incident Text Testing Purpose is not displayed successfully.");

		} catch (Throwable t) {
			verificationFailed();
		}

		// click on the home icon from the top of the screen
		click("questionnaire_homeburgermenubtn_hide_CSS");

		// synchronization
		explicitWait("propertylist_title_XPATH");

		// verify the property list
		switchVerification("propertylist_title_XPATH", "Property List", "The property list is not displayed.");

		// VERIFY UPDATE AND DELETE BUTTON IS DISPLAYED OR NOT AFTER SWITCH FROM THE
		// HISTORY TAB
		title("VERIFY UPDATE AND DELETE BUTTON IS DISPLAYED OR NOT AFTER SWITCH FROM THE HISTORY TAB");
		try {

			// enter the property name in the search field
			type("envreports_propertylist_filtertxt_CSS", data.get("property_1"));

			// click on the OHS icon from the property list page
			click("ohsicon_CSS");

			// wait for the element
			Thread.sleep(5000);

			// click on the burger menu
			click("menubtn_CSS");

			// wait for the element
			Thread.sleep(5000);

			// click on the incident reports
			click("questionnaire_option_ohstab_incidentreports_XPATH");

			// wait for the element
			explicitWaitClickable("ohs_incident_search_clearbtn_XPATH");

			// click on the clear button
			click("ohs_incident_search_clearbtn_XPATH");

			// enter the newly created incident report in the search field
			type("ohs_incident_searchtxt_CSS", data.get("describe_incident"));

			// click on the search button
			click("ohs_incident_search_searchbtn_CSS");

			// click on the newly created incident report
			click("ohs_incident_addedincidentreport_clientissue5_XPATH");

			// wait for the element
			Thread.sleep(5000);

			// verify update button is displayed or not
			try {

				boolean updatebtn = driver.findElement(By.xpath(OR.getProperty("ohs_incident_updatebtn_XPATH")))
						.isDisplayed();

				if (updatebtn == true) {
					successMessage("THE UPDATE BUTTON IS DISPLAYED SUCCESSFULLY.");
				} else {

					verificationFailedMessage("THE UPDATE BUTTON IS NOT DISPLAYED.");
				}
			} catch (Throwable t) {
				verificationFailedMessage("THE UPDATE BUTTON IS NOT DISPLAYED.");
			}

			// verify delete button is displayed or not
			try {

				boolean deletebtn = driver.findElement(By.cssSelector(OR.getProperty("ohs_incident_deletebtn_CSS")))
						.isDisplayed();

				if (deletebtn == true) {
					successMessage("THE DELETE BUTTON IS DISPLAYED SUCCESSFULLY.");
				} else {

					verificationFailedMessage("THE DELETE BUTTON IS NOT DISPLAYED.");
				}
			} catch (Throwable t) {
				verificationFailedMessage("THE DELETE BUTTON IS NOT DISPLAYED.");
			}

			// click on the history icon
			click("ohs_incident_historyicon_XPATH");

			// wait for the element
			Thread.sleep(5000);

			// verify update button is displayed or not
			try {

				boolean updatebtn = driver.findElement(By.xpath(OR.getProperty("ohs_incident_updatebtn_XPATH")))
						.isDisplayed();

				if (updatebtn == true) {

					verificationFailedMessage("THE UPDATE BUTTON IS DISPLAYED.");
				} else {
					successMessage("THE UPDATE BUTTON IS NOT DISPLAYED AS EXPECTED.");
				}
			} catch (Throwable t) {
				successMessage("THE UPDATE BUTTON IS NOT DISPLAYED AS EXPECTED.");
			}

			// verify delete button is displayed or not
			try {

				boolean deletebtn = driver.findElement(By.cssSelector(OR.getProperty("ohs_incident_deletebtn_CSS")))
						.isDisplayed();

				if (deletebtn == true) {

					verificationFailedMessage("THE DELETE BUTTON IS DISPLAYED.");
				} else {
					successMessage("THE DELETE BUTTON IS NOT DISPLAYED AS EXPECTED.");
				}
			} catch (Throwable t) {
				successMessage("THE DELETE BUTTON IS NOT DISPLAYED AS EXPECTED.");
			}

			// verify history record screen is displayed or not
			switchVerification("ohs_incident_historyrecords_recordauditlogtitle_XPATH", "Record Audit Log",
					"The Record Audit Log screen is not displayed.");

			// click on the summary icon
			click("ohs_incident_summaryicon_XPATH");

			// wait for the element
			Thread.sleep(5000);

			// verify update button is displayed or not
			try {

				boolean updatebtn = driver.findElement(By.xpath(OR.getProperty("ohs_incident_updatebtn_XPATH")))
						.isDisplayed();

				if (updatebtn == true) {
					successMessage("THE UPDATE BUTTON IS DISPLAYED SUCCESSFULLY.");
				} else {

					verificationFailedMessage("THE UPDATE BUTTON IS NOT DISPLAYED.");
				}
			} catch (Throwable t) {
				verificationFailedMessage("THE UPDATE BUTTON IS NOT DISPLAYED.");
			}

			// verify delete button is displayed or not
			try {

				boolean deletebtn = driver.findElement(By.cssSelector(OR.getProperty("ohs_incident_deletebtn_CSS")))
						.isDisplayed();

				if (deletebtn == true) {
					successMessage("THE DELETE BUTTON IS DISPLAYED SUCCESSFULLY.");
				} else {

					verificationFailedMessage("THE DELETE BUTTON IS NOT DISPLAYED.");
				}
			} catch (Throwable t) {
				verificationFailedMessage("THE DELETE BUTTON IS NOT DISPLAYED.");
			}

			// AGAIN REVERIFY UPDATE AND DELETE BUTTON WHEN SWITCH FROM THE HISTORY RECORD
			// SCREEN
			title("AGAIN REVERIFY UPDATE AND DELETE BUTTON WHEN SWITCH FROM THE HISTORY RECORD SCREEN");

			// click on the history icon
			click("ohs_incident_historyicon_XPATH");

			// wait for the element
			Thread.sleep(5000);

			// verify update button is displayed or not
			try {

				boolean updatebtn = driver.findElement(By.xpath(OR.getProperty("ohs_incident_updatebtn_XPATH")))
						.isDisplayed();

				if (updatebtn == true) {

					verificationFailedMessage("THE UPDATE BUTTON IS DISPLAYED.");
				} else {
					successMessage("THE UPDATE BUTTON IS NOT DISPLAYED AS EXPECTED.");
				}
			} catch (Throwable t) {
				successMessage("THE UPDATE BUTTON IS NOT DISPLAYED AS EXPECTED.");
			}

			// verify delete button is displayed or not
			try {

				boolean deletebtn = driver.findElement(By.cssSelector(OR.getProperty("ohs_incident_deletebtn_CSS")))
						.isDisplayed();

				if (deletebtn == true) {

					verificationFailedMessage("THE DELETE BUTTON IS DISPLAYED.");
				} else {
					successMessage("THE DELETE BUTTON IS NOT DISPLAYED AS EXPECTED.");
				}
			} catch (Throwable t) {
				successMessage("THE DELETE BUTTON IS NOT DISPLAYED AS EXPECTED.");
			}

			// verify history record screen is displayed or not
			switchVerification("ohs_incident_historyrecords_recordauditlogtitle_XPATH", "Record Audit Log",
					"The Record Audit Log screen is not displayed.");

			// click on the summary icon
			click("ohs_incident_summaryicon_XPATH");

			// wait for the element
			Thread.sleep(5000);

			// verify update button is displayed or not
			try {

				boolean updatebtn = driver.findElement(By.xpath(OR.getProperty("ohs_incident_updatebtn_XPATH")))
						.isDisplayed();

				if (updatebtn == true) {
					successMessage("THE UPDATE BUTTON IS DISPLAYED SUCCESSFULLY.");
				} else {

					verificationFailedMessage("THE UPDATE BUTTON IS NOT DISPLAYED.");
				}
			} catch (Throwable t) {
				verificationFailedMessage("THE UPDATE BUTTON IS NOT DISPLAYED.");
			}

			// verify delete button is displayed or not
			try {

				boolean deletebtn = driver.findElement(By.cssSelector(OR.getProperty("ohs_incident_deletebtn_CSS")))
						.isDisplayed();

				if (deletebtn == true) {
					successMessage("THE DELETE BUTTON IS DISPLAYED SUCCESSFULLY.");
				} else {

					verificationFailedMessage("THE DELETE BUTTON IS NOT DISPLAYED.");
				}
			} catch (Throwable t) {
				verificationFailedMessage("THE DELETE BUTTON IS NOT DISPLAYED.");
			}

		} catch (Throwable t) {
			verificationFailed();
		}

		// click on the home icon from the top of the screen
		click("questionnaire_homeburgermenubtn_hide_CSS");

		// synchronization
		explicitWait("propertylist_title_XPATH");

		// verify the property list
		switchVerification("propertylist_title_XPATH", "Property List", "The property list is not displayed.");

		// DELETE THE NEWLY CREATED INCIDENT REPORT
		title("DELETE THE NEWLY CREATED INCIDENT REPORT");

		try {

			// enter the property name in the search field
			type("envreports_propertylist_filtertxt_CSS", data.get("property_1"));

			// click on the OHS icon from the property list page
			click("ohsicon_CSS");

			// wait for the element
			Thread.sleep(5000);

			// click on the burger menu
			click("menubtn_CSS");

			// wait for the element
			Thread.sleep(5000);

			// click on the incident reports
			click("questionnaire_option_ohstab_incidentreports_XPATH");

			// wait for the element
			explicitWaitClickable("ohs_incident_search_clearbtn_XPATH");

			// click on the clear button
			click("ohs_incident_search_clearbtn_XPATH");

			// enter the newly created incident report in the search field
			type("ohs_incident_searchtxt_CSS", data.get("describe_incident"));

			// click on the search button
			click("ohs_incident_search_searchbtn_CSS");

			// click on the incident report
			click("ohs_incident_addedincidentreport_clientissue5_XPATH");

			// wait for the element
			explicitWaitClickable("ohs_incident_deletebtn_CSS");

			// click on the delete button
			click("ohs_incident_deletebtn_CSS");

			// wait for the element
			explicitWaitClickable("ohs_incident_confirmdeletebtn_CSS");

			// click on the delete button of confirmation popup
			click("ohs_incident_confirmdeletebtn_CSS");

			// wait for the element
			explicitWaitClickable("closetoastmsg_CSS");

			// click on the toaster close button
			click("closetoastmsg_CSS");

			// wait for the element
			explicitWaitClickable("ohs_incident_search_clearbtn_XPATH");

			// click on the clear button
			click("ohs_incident_search_clearbtn_XPATH");

			// enter the newly created incident report in the search field
			type("ohs_incident_searchtxt_CSS", data.get("describe_incident"));

			// click on the search button
			click("ohs_incident_search_searchbtn_CSS");

			// verify details are deleted or not
			deleteVerification("ohs_incident_addedincidentreport_clientissue5_XPATH",
					"Clientissue5 Describe Incident Text Testing Purpose");

		} catch (Throwable t) {
			verificationFailed();
		}

		// click on the home icon from the top of the screen
		click("questionnaire_homeburgermenubtn_hide_CSS");

		// synchronization
		explicitWait("propertylist_title_XPATH");

		// verify the property list
		switchVerification("propertylist_title_XPATH", "Property List", "The property list is not displayed.");

		try {
			// wait for the element
			explicitWaitClickable("questionnaire_settingicon_CSS");

			// click on the settings icon from the top of the screen
			click("questionnaire_settingicon_CSS");

			// wait for the element
			explicitWaitClickable("sidemenu_logout_CSS");

			// click on the logout option from the side menu
			click("sidemenu_logout_CSS");

			// wait for the element
			explicitWaitClickable("signinbtn_BTNTEXT");

		} catch (Throwable t) {
			verificationFailed();
		}

	}
}