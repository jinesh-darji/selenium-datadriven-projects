package testcases.E2Etestcasesuite.ohsmodule;

import java.io.IOException;
import java.util.Hashtable;

import org.openqa.selenium.JavascriptExecutor;
import org.testng.Reporter;
import org.testng.SkipException;
import org.testng.annotations.Test;

import com.relevantcodes.extentreports.LogStatus;

import base.Helper;
import base.TestBase;
import utilities.TestUtil;

public class RR5298OHSTwoTest extends TestBase {

	@Test(dataProviderClass = TestUtil.class, dataProvider = "dp")
	public void rR5298OHSTwoTest(Hashtable<String, String> data) throws IOException, InterruptedException {

		execution(data, "rR5298OHSTwoTest");

		// ALERT NOTIFICATION - ALERT TYPE: ADD AND TIME OF DAY: PM (Administration >
		// OHS)
		title("ALERT NOTIFICATION - ALERT TYPE: ADD AND TIME OF DAY: PM (Administration > OHS)");

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

			// click on the ohs tab
			click("questionnaire_ohstab_XPATH");

			// click on the Incident Event Types option
			click("questionnaire_incidenteventtypeoption_XPATH");

			// type event type in the search field
			type("ohs_incident_alertnotification_incidenteventype_searchtxt_CSS", data.get("event_type"));

			// click on the searched event type
			click("ohs_incident_alertnotification_incidenteventype_searchedresult_XPATH");

			// click on the add notification button
			click("ohs_incident_alertnotification_incidenteventype_addnotificationbtn_CSS");

			// type details in the description field
			type("ohs_incident_alertnotification_incidenteventype_descriptiontxt_CSS", data.get("short_description"));

			// scroll down the screen
			scrollByPixel(500);

			// select All Day option from the time of day
			select("ohs_incident_alertnotification_timeofdaydd_CSS", data.get("time_of_day"));

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

			// verify newly added incident email notification is set or not
			switchVerification("ohs_incident_alertnotification_incidenteventype_addedrecord2_XPATH",
					"Short Description SS OHS Two for Testing Purpose",
					"The Short Description SS OHS Two for Testing Purpose is not displayed.");

			// click on the update button
			click("ohs_incident_alertnotification_updatebtn_CSS");

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
			type("ohs_incident_hourstxt_CSS", "12");

			// enter the incident time - minute
			type("ohs_incident_minutestxt_CSS", "00");

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
			switchVerification("ohs_incident_alertnotification_addedincidentreportohs2_XPATH",
					"Describe Incident Text Alert Notification OHS Two",
					"The Describe Incident Text Alert Notification OHS Two is not displayed successfully.");

		} catch (Throwable t) {
			verificationFailed();
		}

		// DELETE THE NEWLY CREATED INCIDENT REPORT
		title("DELETE THE NEWLY CREATED INCIDENT REPORT");

		try {
			// click on the newly created incident report
			click("ohs_incident_alertnotification_addedincidentreportohs2_XPATH");

			// wait for the element
			explicitWaitClickable("ohs_incident_deletebtn_CSS");

			// click on the delete button
			click("ohs_incident_deletebtn_CSS");

			// wait for the element
			explicitWaitClickable("ohs_incident_confirmdeletebtn_CSS");

			// click on the delete button of confirmation popup
			click("ohs_incident_confirmdeletebtn_CSS");

			// verify details are deleted or not
			helper.deleteVerification("ohs_incident_alertnotification_addedincidentreportohs2_XPATH",
					"Describe Incident Text Alert Notification OHS Two");

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

			// click on the ohs tab
			click("questionnaire_ohstab_XPATH");

			// click on the Incident Event Types option
			click("questionnaire_incidenteventtypeoption_XPATH");

			// type event type in the search field
			type("ohs_incident_alertnotification_incidenteventype_searchtxt_CSS", data.get("event_type"));

			// click on the searched event type
			click("ohs_incident_alertnotification_incidenteventype_searchedresult_XPATH");

			// click on newly added incident email notification
			click("ohs_incident_alertnotification_incidenteventype_addedrecord2_XPATH");

			// scrolldown the screen
			scrollByPixel(600);

			// click on the delete button
			click("ohs_incident_alertnotification_deletebtn_CSS");

			// click on the delete button of confirmation
			click("ohs_incident_alertnotification_confirmdeletebtn_CSS");

			// validate deleted incident alert notification is displayed or not
			helper.deleteVerification("ohs_incident_alertnotification_incidenteventype_addedrecord2_XPATH",
					"Short Description SS OHS Two for Testing Purpose");

			// click on the update button
			click("ohs_incident_alertnotification_updatebtn_CSS");

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