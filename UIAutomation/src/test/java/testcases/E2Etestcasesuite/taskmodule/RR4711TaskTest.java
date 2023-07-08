package testcases.E2Etestcasesuite.taskmodule;

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

public class RR4711TaskTest extends TestBase {

	@Test(dataProviderClass = TestUtil.class, dataProvider = "dp")
	public void rR4711TaskTest(Hashtable<String, String> data) throws IOException, InterruptedException {

		execution(data, "rR4711TaskTest");

		// CRUD OPERATION OF THE TASK OF THE OHS INCIDENTS.
		title("CRUD OPERATION OF THE TASK OF THE OHS INCIDENTS.");

		// NOTE: 1. NEED RECOMMENDATAION CREATED FOR CREATE THE NEW TASK. THE
		// RECOMMENDATAION IS CREATED FROM THE TASK TYPE DASHBOARD.

		Helper helper = new Helper();

		// refresh the page
		driver.navigate().refresh();
		Thread.sleep(5000);
		driver.navigate().refresh();

		// CREATE NEW INCIDENT REPORT
		title("CREATE NEW INCIDENT REPORT");

		try {
			// click on the OHS icon from the property list page
			click("ohsicon_CSS");

			// click on the burger menu
			click("menubtn_CSS");

			// wait for 10 seconds
			Thread.sleep(10000);

			// click on the incident reports
			click("questionnaire_option_ohstab_incidentreports_XPATH");

			// ADD RECORD - INCIDENT REPORT
			title("ADD RECORD - INCIDENT REPORT");

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
			type("ohs_incident_shortdescriptiontxt_CSS", data.get("short_description"));

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
			explicitWait("ohs_incident_nextbtn_CSS");

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

			consoleMessage("Navigate to the Emergency Services Tab.");

			// click on the next button
			click("ohs_incident_nextbtn_CSS");

			// synchronization
			explicitWait("ohs_incident_nextbtn_CSS");

			consoleMessage("Navigate to the Property Damage Tab.");

			// click on the next button
			click("ohs_incident_nextbtn_CSS");

			// synchronization
			explicitWait("ohs_incident_nextbtn_CSS");

			consoleMessage("Navigate to the Insurance Tab.");

			// click on the next button
			click("ohs_incident_nextbtn_CSS");

			// synchronization
			explicitWait("ohs_incident_updaterecordbtn_CSS");

			consoleMessage("Navigate to the Attachments Tab.");

			// click on the update record button
			click("ohs_incident_updaterecordbtn_CSS");

			// wait for 3 seconds
			Thread.sleep(3000);

			// enter the newly created incident report in the search field
			type("ohs_incident_searchtxt_CSS", data.get("short_description"));

			// verification of the incident report is added or not
			switchVerification("ohs_incident_addedincidentreport_XPATH",
					"Short Description for Testing Purpose CRUD OHS",
					"The Short Description for Testing Purpose CRUD OHS is not displayed successfully.");

		} catch (Throwable t) {
			verificationFailed();
		}

		// ADD THE TASK IN THE NEWLY CREATED INCIDENT REPORT
		title("ADD THE TASK IN THE NEWLY CREATED INCIDENT REPORT");

		try {
			// click on the added incident report
			click("ohs_incident_addedincidentreport_XPATH");

			// click on the task tab
			click("ohs_incident_tasktab_CSS");

			// click on the add task button
			click("ohs_incident_tasktab_addbtn_CSS");

			// scroll down the screen
			scrollByPixel(400);

			// enter the data in the task title field
			type("task_addtask_titletxt_CSS", data.get("task_title"));

			// enter the data in the task location field
			type("task_addtask_locationtxt_CSS", data.get("task_location"));

			// click on the assign to field
			click("task_assigntotxt_CSS");

			// click on the none button
			click("task_tasktag_nonebtn_CSS");

			// enter the user name in the search field
			type("workflowsecurity_editortask_taskdetails_searchtasktagtxt_CSS", data.get("search_user"));

			// click on the searched result
			click("questionnaire_createtask_selectusertxt_XPATH");

			// click on the assign to field
			click("task_assigntotxt_CSS");

			// synchronization
			explicitWait("task_addtask_purchaseordertab_XPATH");

			// click on the purchase order/warranty tab
			click("task_addtask_purchaseordertab_XPATH");

			// scroll down the screen
			scrollByPixel(500);

			// click on the warranty checkbox
			click("questionnaire_purchaseordertab_warrantycheckbox_CSS");

			// click on the po required
			click("questionnaire_purchaseordertab_porequired_CSS");

			// click on the po approved
			click("questionnaire_purchaseordertab_poapproved_CSS");

			// synchronization
			explicitWait("questionnaire_purchaseordertab_ponumber_CSS");

			// enter the data in the po number field
			type("questionnaire_purchaseordertab_ponumber_CSS", data.get("task_ponumber"));

			// click on the approved to proceed
			click("questionnaire_purchaseordertab_approvedtoproceed_CSS");

			// synchronization
			explicitWait("questionnaire_purchaseordertab_estimaterequired_CSS");

			// click on the estimate required
			click("questionnaire_purchaseordertab_estimaterequired_CSS");

			// enter the estimated amount in the field
			type("questionnaire_purchaseordertab_estimateamount_CSS", "1122");

			// click on the save button
			click("ohs_incident_tasktab_addtaskbtn_CSS");

			// enter the newly created task into the search field
			type("ohs_incident_tasktab_searchtasktxt_CSS", data.get("task_title"));

			// verify newly created task is displayed or not
			switchVerification("ohs_incident_tasktab_addedtask_XPATH", "Test Task Incident Module Title Record",
					"The Test Task Incident Module Title Record is not displayed.");

		} catch (Throwable t) {
			verificationFailed();
		}

		// click on the home icon from the top of the screen
		click("questionnaire_homeburgermenubtn_hide_CSS");

		// synchronization
		explicitWait("propertylist_title_XPATH");

		// verify the property list
		switchVerification("propertylist_title_XPATH", "Property List", "The property list is not displayed.");

		// VERIFY NEWLY CREATED TASK DISPLAY IN THE TASK MODULE AND UPDATE THE NEWLT
		// CREATED TASK IN TASK MODULE
		title("VERIFY NEWLY CREATED TASK DISPLAY IN THE TASK MODULE AND UPDATE THE NEWLT CREATED TASK IN TASK MODULE");

		try {
			// synchronization
			explicitWait("taskicon_CSS");

			// click on the task icon
			click("taskicon_CSS");

			// click on the clear button
			click("task_createdtask_clearbtn_XPATH");

			// enter the data in the search field
			type("task_filter_CSS", data.get("task_title"));

			// click on the search button
			click("task_createdtask_searchbtn_XPATH");

			// verify newly created task is displayed or not
			switchVerification("ohs_incident_tasktab_addedtask1_XPATH", "Test Task Incident Module Title Record",
					"The Test Task Incident Module Title Record is not displayed.");

			// click on the newly created task
			click("ohs_incident_tasktab_addedtask1_XPATH");

			// scroll down the screen
			scrollByPixel(200);

			// update the title of the task
			type("task_addtask_titletxt_CSS", data.get("update_task_title"));

			// click on the update button
			click("survey_task_updatebtn_CSS");

			// scroll up the screen
			scrollByPixel(-500);

			// click on the clear button
			click("task_createdtask_clearbtn_XPATH");

			// enter the data in the search field
			type("task_filter_CSS", data.get("update_task_title"));

			// click on the search button
			click("task_createdtask_searchbtn_XPATH");

			// verify newly created task is displayed or not
			switchVerification("ohs_incident_tasktab_updatedtask1_XPATH",
					"Update Test Task Incident Module Title Record",
					"The Update Test Task Incident Module Title Record is not displayed.");

		} catch (Throwable t) {
			verificationFailed();
		}

		// click on the home icon from the top of the screen
		click("questionnaire_homeburgermenubtn_hide_CSS");

		// synchronization
		explicitWait("propertylist_title_XPATH");

		// verify the property list
		switchVerification("propertylist_title_XPATH", "Property List", "The property list is not displayed.");

		// DELETE THE NEWLY CREATED TASK AND INCIDENT REPORT
		title("DELETE THE NEWLY CREATED TASK AND INCIDENT REPORT");

		try {

			// click on the OHS icon from the property list page
			click("ohsicon_CSS");

			// wait for element
			explicitWaitClickable("menubtn_CSS");

			// click on the burger menu
			click("menubtn_CSS");

			// wait for element
			explicitWaitClickable("questionnaire_option_ohstab_incidentreports_XPATH");

			// click on the incident reports
			click("questionnaire_option_ohstab_incidentreports_XPATH");

			// synchronization
			explicitWait("ohs_incident_searchtxt_CSS");

			// enter the newly created incident report in the search field
			type("ohs_incident_searchtxt_CSS", data.get("short_description"));

			// verification of the incident report is added or not
			switchVerification("ohs_incident_addedincidentreport_XPATH",
					"Short Description for Testing Purpose CRUD OHS",
					"The Short Description for Testing Purpose CRUD OHS is not displayed successfully.");

			// click on the added incident report
			click("ohs_incident_addedincidentreport_XPATH");

			// click on the task tab
			click("ohs_incident_tasktab_CSS");

			// enter the updated task into the search field
			type("ohs_incident_tasktab_searchtasktxt_CSS", data.get("update_task_title"));

			// verify updated task is displayed or not
			switchVerification("ohs_incident_tasktab_updatedtask_XPATH",
					"Update Test Task Incident Module Title Record",
					"Update The Test Task Incident Module Title Record is not displayed.");

			// click on the newly created task
			click("ohs_incident_tasktab_updatedtask_XPATH");

			// wait for element
			explicitWaitClickable("ohs_task_deletebtn_XPATH");

			// click on the delete button
			click("ohs_task_deletebtn_XPATH");

			// wait for element
			explicitWaitClickable("ohs_task_confirmationdeletebtn_XPATH");

			// click on the delete button of confirmation popup model
			click("ohs_task_confirmationdeletebtn_XPATH");

			// click on the incident summary tab
			click("ohs_incident_incidentsummarytab_CSS");

			// wait for element
			explicitWaitClickable("ohs_incident_deletebtn_CSS");

			// click on the delete button for delete the incident report
			click("ohs_incident_deletebtn_CSS");

			// wait for element
			explicitWaitClickable("ohs_incident_confirmdeletebtn_CSS");

			// click on the delete button of confirmation model for delete the incident
			// report
			click("ohs_incident_confirmdeletebtn_CSS");

			// enter the newly created incident report in the search field
			type("ohs_incident_searchtxt_CSS", data.get("short_description"));

			helper.deleteVerification("ohs_incident_addedincidentreport_XPATH",
					"Short Description for Testing Purpose CRUD OHS");

		} catch (Throwable t) {
			verificationFailed();
		}

		// click on the home icon from the top of the screen
		click("questionnaire_homeburgermenubtn_hide_CSS");

		// synchronization
		explicitWait("propertylist_title_XPATH");

		// verify the property list
		switchVerification("propertylist_title_XPATH", "Property List", "The property list is not displayed.");

		// VERIFY TASK IS DELETED IN THE TASK MODULE OR NOT
		title("VERIFY TASK IS DELETED IN THE TASK MODULE OR NOT");

		try {

			// synchronization
			explicitWait("taskicon_CSS");

			// click on the task icon
			click("taskicon_CSS");

			// click on the clear button
			click("task_createdtask_clearbtn_XPATH");

			// enter the data in the search field
			type("task_filter_CSS", data.get("update_task_title"));

			// click on the search button
			click("task_createdtask_searchbtn_XPATH");

			helper.deleteVerification("ohs_incident_tasktab_updatedtask1_XPATH",
					"Update Test Task Incident Module Title Record");

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