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

public class RR5813OHSTest extends TestBase {

	@Test(dataProviderClass = TestUtil.class, dataProvider = "dp")
	public void rR5813OHSTest(Hashtable<String, String> data) throws IOException, InterruptedException {

		execution(data, "rR5813OHSTest");

		// refresh the page
		driver.navigate().refresh();
		Thread.sleep(5000);
		driver.navigate().refresh();

		// VERIFY THE JUMP TO ICON OF THE INSURANCE TAB OF THE INCIDENT REPORT
		title("VERIFY THE JUMP TO ICON OF THE INSURANCE TAB OF THE INCIDENT REPORT");

		Helper helper = new Helper();

		// CREATE NEW INCIDENT REPORT
		title("CREATE NEW INCIDENT REPORT");

		try {

			// click on the OHS icon from the property list page
			click("ohsicon_CSS");

			// wait for the element
			explicitWaitClickable("menubtn_CSS");

			// click on the burger menu
			click("menubtn_CSS");

			// wait for the element
			explicitWaitClickable("questionnaire_option_ohstab_incidentreports_XPATH");

			// click on the incident reports
			click("questionnaire_option_ohstab_incidentreports_XPATH");

			// ADD DETAILS IN THE INCIDENT REPORT TAB
			title("ADD DETAILS IN THE INCIDENT REPORT TAB");

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

			// ADD DETAILS IN THE DETAILS, CAUSES TAB
			title("ADD DETAILS IN THE DETAILS, CAUSES TAB");

			// Enter the data in the description incident field
			type("ohs_incident_descriptionincidenttxt_CSS", data.get("describe_incident"));

			// Enter the data in the Incident Cause field
			type("ohs_incident_incidentcausetxt_CSS", data.get("incident_cause"));

			// scroll down the screen
			scrollByPixel(400);

			// Enter the data in the Actions Taken field
			type("ohs_incident_actionstakentxt_CSS", data.get("actions_taken"));

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

			// ADD DETAILS IN THE INSURANCE TAB
			title("ADD DETAILS IN THE INSURANCE TAB");

			// wait for the element
			Thread.sleep(5000);

			// click on the add button
			click("ohs_incident_insurancetab_addbtn_CSS");

			// enter data in the company name field
			type("ohs_incident_insurance_companynametxt_CSS", data.get("company_name"));

			// enter data in the Claim Number field
			type("ohs_incident_insurance_claimnumbertxt_CSS", data.get("claim_number"));

			// scroll down the screen
			scrollByPixel(600);

			// select data from the Status drop down
			select("ohs_incident_insurance_statusdd_CSS", data.get("insurance_status"));

			// select data from the type drop down
			select("ohs_incident_insurance_typedd_CSS", data.get("insurance_type"));

			// click on the notification date field
			click("ohs_incident_insurance_notificationdate_CSS");

			// click on the today button
			click("ohs_incident_insurance_notificationdate_todayduedatebtn_XPATH");

			// enter data in the Policy Number field
			type("ohs_incident_insurance_policynumbertxt_CSS", data.get("insurance_policy_number"));

			// enter data in the loss description field
			type("ohs_incident_insurance_lossdescription_CSS", data.get("short_description"));

			// click on the save button
			click("ohs_incident_insurancetab_savebtn_CSS");

			// verify added insurance details are displayed or not
			switchVerification("ohs_incident_addedinsurancejumpto_XPATH", "Add Company Name Jump To Test",
					"The Add Company Name Jump To Test is not displayed.");

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
			switchVerification("ohs_incident_addedincidentreport_jumpto_XPATH", "Describe Incident Text Jump To",
					"The Describe Incident Text Jump To is not displayed successfully.");

		} catch (Throwable t) {
			verificationFailed();
		}

		// click on the home icon from the top of the screen
		click("questionnaire_homeburgermenubtn_hide_CSS");

		// wait for the element
		explicitWait("propertylist_title_XPATH");

		// verify the property list
		switchVerification("propertylist_title_XPATH", "Property List", "The property list is not displayed.");

		// VERIFY INSURANCE CLAIM ASSOCIATION OF THE RISK MANAGEMENT MODULE AFTER JUMP
		// FROM INSURANCE TAB OF THE INCIDENT REPORT
		title("VERIFY INSURANCE CLAIM ASSOCIATION OF THE RISK MANAGEMENT MODULE AFTER JUMP FROM INSURANCE TAB OF THE INCIDENT REPORT");

		try {

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

			// click on the clear button
			click("ohs_incidentreport_clearbtn_XPATH");

			// enter incident report in the search field
			type("ohs_incidentreport_searchtxt_XPATH", data.get("describe_incident"));

			// click on the search button
			click("ohs_incidentreport_searchbtn_XPATH");

			// click on the added incident report
			click("ohs_incident_addedincidentreport_jumpto_XPATH");

			// click on the insurance tab
			click("ohs_incident_insurancetab_CSS");

			// wait for the element
			Thread.sleep(7000);

			// click on the jump to button of the newly created insurance
			String createdInsurance = "//td[text()='" + data.get("company_name")
					+ "']//following-sibling::td[@ng-click='jumpToInsuranceClaim(insurance.insuranceClaim)']";
			driver.findElement(By.xpath(createdInsurance)).click();
			consoleMessage("Clicked on the jump to button of the newly created insurance.");

			// verify the title of the insurance details screen
			switchVerification("ohs_insurance_title1_XPATH", "Insurance Claim Form",
					"The Insurance Claim Form title of the screen is not displayed.");

			// click on the incident return icon
			click("ohs_insurance_returntoincidenticon_XPATH");

			// wait for the element
			Thread.sleep(5000);

			// verify incident title
			switchVerification("ohs_insurance_incidenttitle_XPATH", "Incident Report",
					"The Incident Report title is not displayed.");

		} catch (Throwable t) {
			verificationFailed();
		}

		// click on the home icon from the top of the screen
		click("questionnaire_homeburgermenubtn_hide_CSS");

		// wait for the element
		explicitWait("propertylist_title_XPATH");

		// verify the property list
		switchVerification("propertylist_title_XPATH", "Property List", "The property list is not displayed.");

		// DELETE THE INCIDENT REPORT AND INSURANCE
		title("DELETE THE INCIDENT REPORT AND INSURANCE");

		try {
			// click on the OHS icon from the property list page
			click("ohsicon_CSS");

			// wait for the element
			explicitWaitClickable("menubtn_CSS");

			// click on the burger menu
			click("menubtn_CSS");

			// wait for the element
			explicitWaitClickable("questionnaire_option_ohstab_incidentreports_XPATH");

			// click on the incident reports
			click("questionnaire_option_ohstab_incidentreports_XPATH");

			// click on the clear button
			click("ohs_incidentreport_clearbtn_XPATH");

			// enter incident report in the search field
			type("ohs_incidentreport_searchtxt_XPATH", data.get("describe_incident"));

			// click on the search button
			click("ohs_incidentreport_searchbtn_XPATH");

			// click on the added incident report
			click("ohs_incident_addedincidentreport_jumpto_XPATH");

			// click on the insurance tab
			click("ohs_incident_insurancetab_CSS");

			// click on the delete button of the added property damage
			click("ohs_incident_insurancedeletebtn_CSS");

			// verify details are deleted or not
			helper.deleteVerification("ohs_insurance_companyname_XPATH", "Add Insurance Company Name Test");

			// click on the incident summary
			click("ohs_incident_incidentsummarytab_CSS");

			// click on the update button
			click("ohs_incident_updatebtn_XPATH");

			// wait for the element
			explicitWaitClickable("closetoastmsg_CSS");

			// click on the toaster close button
			click("closetoastmsg_CSS");

			// click on the cancel button
			click("ohs_incident_cancelbtn_XPATH");

			// click on the added incident report
			click("ohs_incident_addedincidentreport_jumpto_XPATH");

			// wait for the element
			explicitWaitClickable("ohs_incident_deletebtn_CSS");

			// click on the delete button
			click("ohs_incident_deletebtn_CSS");

			// wait for the element
			explicitWaitClickable("ohs_incident_confirmdeletebtn_CSS");

			// click on the delete button of confirmation popup
			click("ohs_incident_confirmdeletebtn_CSS");

			// verify details are deleted or not
			helper.deleteVerification("ohs_incident_addedincidentreport_jumpto_XPATH",
					"Describe Incident Text Jump To");

		} catch (Throwable t) {
			verificationFailed();
		}

		// click on the home icon from the top of the screen
		click("questionnaire_homeburgermenubtn_hide_CSS");

		// synchronization
		explicitWait("propertylist_title_XPATH");

		// verify the property list
		switchVerification("propertylist_title_XPATH", "Property List", "The property list is not displayed.");

	}
}
