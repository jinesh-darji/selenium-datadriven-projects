package testcases.E2Etestcasesuite.ohsmodule;

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

public class RR5272OHSSevenTest extends TestBase {

	@Test(dataProviderClass = TestUtil.class, dataProvider = "dp")
	public void rR5272OHSSevenTest(Hashtable<String, String> data) throws IOException, InterruptedException {

		execution(data, "rR5272OHSSevenTest");

		// ALERT NOTIFICATION - ALERT TYPE: DELETE AND TIME OF DAY: ALL DAY
		title("ALERT NOTIFICATION - ALERT TYPE: DELETE AND TIME OF DAY: ALL DAY");

		Helper helper = new Helper();

		// refresh the page
		driver.navigate().refresh();
		Thread.sleep(5000);
		driver.navigate().refresh();

		try {
			// wait for the element
			explicitWaitClickable("questionnaire_settingicon_CSS");

			// click on the settings icon from the top of the screen
			click("questionnaire_settingicon_CSS");

			// wait for the element
			explicitWaitClickable("questionnaire_administrationoption_XPATH");

			// click on the Administration option from the side menu
			click("questionnaire_administrationoption_XPATH");

			// click on the system tab
			click("questionnaire_systemtab_XPATH");

			// click on the notifications option
			click("questionnaire_notificationsoption_XPATH");

			// click on the delete button of the newly created Mortgage Undertakings
			List<WebElement> links = driver
					.findElements(By.xpath(OR.getProperty("ohs_alertnotification_alertscount_XPATH")));
			int count = links.size();
			consoleMessage("Number of links are:" + count);

			for (int i = 1; i <= count; i++) {

				// click on alert randomly
				List<WebElement> links1 = driver
						.findElements(By.xpath(OR.getProperty("ohs_alertnotification_alertscount_XPATH")));
				int count1 = links1.size();
				consoleMessage("Remaining repair links after deleted the repair link: " + count1);

				Random r = new Random();
				links1.get(r.nextInt(count1)).click();

				// scroll down the screen
				scrollByPixel(700);

				// wait for the element
				explicitWaitClickable("ohs_incident_alertnotification_deletebtn_CSS");

				// click on the delete button
				click("ohs_incident_alertnotification_deletebtn_CSS");

				// wait for the element
				explicitWaitClickable("ohs_incident_alertnotification_confirmdeletebtn_CSS");

				// click on the delete button of confirmation message
				click("ohs_incident_alertnotification_confirmdeletebtn_CSS");

			}

		} catch (Throwable t) {
			verificationFailed();
		}

		// ADD NEW ALERT NOTIFICATION - ALERT TYPE: DELETE AND TIME OF DAY: ALL DAY
		title("ADD NEW ALERT NOTIFICATION - ALERT TYPE: DELETE AND TIME OF DAY: ALL DAY");

		try {

			// wait for the element
			explicitWaitClickable("ohs_incident_alertnotification_addbtn_CSS");

			// click on the add button
			click("ohs_incident_alertnotification_addbtn_CSS");

			// click on the ohs module
			click("ohs_incident_alertnotification_ohsmodule_CSS");

			// select the incident option from the record type
			select("ohs_incident_alertnotification_recordtypedd_CSS", data.get("record_type"));

			// select add record option from the alert type
			select("ohs_incident_alertnotification_alerttypedd_CSS", data.get("alert_type"));

			// scroll down the screen
			scrollByPixel(500);

			// select active option from the alert status
			select("ohs_incident_alertnotification_alertstatusdd_CSS", data.get("alert_status"));

			// select All Day option from the time of day
			select("ohs_incident_alertnotification_timeofdaydd_CSS", data.get("time_of_day"));

			// scroll down the screen
			scrollByPixel(500);

			// click on the add a condition button
			click("ohs_incident_alertnotification_addaconditionbtn_CSS");

			// select event type of incident option
			select("ohs_incident_alertnotification_fieldcondition1_CSS", data.get("field_condition_1"));

			// select is equal to option
			select("ohs_incident_alertnotification_fieldcondition2_CSS", data.get("field_condition_2"));

			// enter the field name
			type("ohs_incident_alertnotification_fieldcondition3_CSS", data.get("field_condition_3"));

			// scroll down the screen
			scrollByPixel(500);

			// click on the user field
			click("ohs_incident_alertnotification_usernotificationtxt_CSS");

			// click on the none button
			click("ohs_incident_alertnotification_nonebtn_CSS");

			// enter username on the search field
			type("ohs_incident_alertnotification_searchtxt_CSS", data.get("username"));

			// click on the searched user
			click("ohs_incident_alertnotification_searcheduser_XPATH");

			// click on the user field
			click("ohs_incident_alertnotification_usernotificationtxt_CSS");

			// click on the save button
			click("ohs_incident_alertnotification_savebtn_CSS");

		} catch (Throwable t) {
			verificationFailed();
		}

		// click on the home icon from the top of the screen
		click("questionnaire_homeburgermenubtn_CSS");

		// synchronization
		explicitWait("propertylist_title_XPATH");

		// verify the property list
		switchVerification("propertylist_title_XPATH", "Property List", "The property list is not displayed.");

		// CREATE NEW INCIDENT REPORT
		title("CREATE NEW INCIDENT REPORT");

		try {

			// click on the OHS icon from the property list page
			click("ohsicon_CSS");

			// click on the burger menu
			click("menubtn_CSS");

			// wait for the element
			explicitWaitClickable("questionnaire_option_ohstab_incidentreports_XPATH");

			// click on the incident reports
			click("questionnaire_option_ohstab_incidentreports_XPATH");

			// ADD DETAILS IN THE INCIDENT REPORT TAB
			title("ADD DETAILS IN THE INCIDENT REPORT TAB");

			// wait for the element
			explicitWaitClickable("ohs_incident_addbtn_CSS");

			// click on the add button
			click("ohs_incident_addbtn_CSS");

			// wait for the element
			Thread.sleep(5000);

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
			consoleMessage("Navigate to the Details, Cause Tab.");

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

			// synchronization
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
			switchVerification("ohs_incident_alertnotification_addedincidentreport7_XPATH",
					"Describe Incident Text Alert Notification Seven",
					"The Describe Incident Text Alert Notification Seven is not displayed successfully.");

		} catch (Throwable t) {
			verificationFailed();
		}

		// DELETE THE NEWLY CREATED REPORT
		title("DELETE THE NEWLY CREATED REPORT");

		try {
			// click on the newly created incident report
			click("ohs_incident_alertnotification_addedincidentreport7_XPATH");

			// wait for the element
			explicitWaitClickable("ohs_incident_deletebtn_CSS");

			// click on the delete button
			click("ohs_incident_deletebtn_CSS");

			// wait for the element
			explicitWaitClickable("ohs_incident_confirmdeletebtn_CSS");

			// click on the delete button of confirmation popup
			click("ohs_incident_confirmdeletebtn_CSS");

			// verify details are deleted or not
			helper.deleteVerification("ohs_incident_alertnotification_addedincidentreport7_XPATH",
					"Update Describe Incident Text Alert Notification Seven");

		} catch (Throwable t) {
			verificationFailed();
		}

		// click on the home icon from the top of the screen
		click("questionnaire_homeburgermenubtn_hide_CSS");

		// synchronization
		explicitWait("propertylist_title_XPATH");

		// verify the property list
		switchVerification("propertylist_title_XPATH", "Property List", "The property list is not displayed.");

		// DELETE THE NEWLY CREATED ALERT NOTIFICATION
		title("DELETE THE NEWLY CREATED ALERT NOTIFICATION");

		try {
			// wait for the element
			explicitWaitClickable("questionnaire_settingicon_CSS");

			// click on the settings icon from the top of the screen
			click("questionnaire_settingicon_CSS");

			// wait for the element
			explicitWaitClickable("questionnaire_administrationoption_XPATH");

			// click on the Administration option from the side menu
			click("questionnaire_administrationoption_XPATH");

			// click on the system tab
			click("questionnaire_systemtab_XPATH");

			// click on the notifications option
			click("questionnaire_notificationsoption_XPATH");

			// click on the delete button of the newly created Mortgage Undertakings
			List<WebElement> links = driver
					.findElements(By.xpath(OR.getProperty("ohs_alertnotification_alertscount_XPATH")));
			int count = links.size();
			consoleMessage("Number of links are:" + count);

			for (int i = 1; i <= count; i++) {

				// click on alert randomly
				List<WebElement> links1 = driver
						.findElements(By.xpath(OR.getProperty("ohs_alertnotification_alertscount_XPATH")));
				int count1 = links1.size();
				consoleMessage("Remaining repair links after deleted the repair link: " + count1);

				Random r = new Random();
				links1.get(r.nextInt(count1)).click();

				// scroll down the screen

				scrollByPixel(700);

				// wait for the element
				explicitWaitClickable("ohs_incident_alertnotification_deletebtn_CSS");

				// click on the delete button
				click("ohs_incident_alertnotification_deletebtn_CSS");

				// wait for the element
				explicitWaitClickable("ohs_incident_alertnotification_confirmdeletebtn_CSS");

				// click on the delete button of confirmation message
				click("ohs_incident_alertnotification_confirmdeletebtn_CSS");

			}

		} catch (Throwable t) {
			verificationFailed();
		}

		// click on the home icon from the top of the screen
		click("questionnaire_homeburgermenubtn_CSS");

		// synchronization
		explicitWait("propertylist_title_XPATH");

		// verify the property list
		switchVerification("propertylist_title_XPATH", "Property List", "The property list is not displayed.");

	}
}