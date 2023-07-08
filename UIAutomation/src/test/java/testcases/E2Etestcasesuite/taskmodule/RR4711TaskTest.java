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

		// NOTE: 1. NEED RECOMMENDATAION CREATED FOR CREATE THE NEW TASK. THE
		// RECOMMENDATAION IS CREATED FROM THE TASK TYPE DASHBOARD.

		System.out.println("CRUD OPERATION OF THE TASK OF THE OHS INCIDENTS.");
		test.log(LogStatus.INFO, "CRUD OPERATION OF THE TASK OF THE OHS INCIDENTS.");
		Reporter.log("CRUD OPERATION OF THE TASK OF THE OHS INCIDENTS.");
		log.info("CRUD OPERATION OF THE TASK OF THE OHS INCIDENTS.");

		Helper helper = new Helper();

		// refresh the page
		driver.navigate().refresh();
		Thread.sleep(5000);
		driver.navigate().refresh();

		System.out.println("Navigate to the Home Screen i.e. Property List Screen.");

		// CREATE NEW INCIDENT REPORT

		System.out.println("***************** CREATE NEW INCIDENT REPORT *****************");
		test.log(LogStatus.INFO, "***************** CREATE NEW INCIDENT REPORT *****************");
		Reporter.log("***************** CREATE NEW INCIDENT REPORT *****************");
		log.info("***************** CREATE NEW INCIDENT REPORT *****************");

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

			// wait for 10 seconds
			Thread.sleep(10000);

			// click on the incident reports
			click("questionnaire_option_ohstab_incidentreports_XPATH");
			System.out.println("Clicked on the incident reports option.");
			ngDriver.waitForAngularRequestsToFinish();

			// ADD RECORD - INCIDENT REPORT

			// click on the add button
			click("ohs_incident_addbtn_CSS");
			System.out.println("Clicked on the Add button.");
			ngDriver.waitForAngularRequestsToFinish();
			System.out.println("Navigate to the Add incident report Screen");

			// wait for the element
			Thread.sleep(10000);

			// enter the incident time - hours
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
			type("ohs_incident_shortdescriptiontxt_CSS", data.get("short_description"));
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

			// synchronization
			explicitWait("ohs_incident_nextbtn_CSS");
			System.out.println("Navigate to the Emergency Services Tab.");
			test.log(LogStatus.INFO, "Navigate to the Emergency Services Tab.");
			Reporter.log("Navigate to the Emergency Services Tab.");
			log.info("Navigate to the Emergency Services Tab.");

			// click on the next button
			click("ohs_incident_nextbtn_CSS");
			System.out.println("Clicked on the next button.");
			ngDriver.waitForAngularRequestsToFinish();

			// synchronization
			explicitWait("ohs_incident_nextbtn_CSS");
			System.out.println("Navigate to the Property Damage Tab.");
			test.log(LogStatus.INFO, "Navigate to the Property Damage Tab.");
			Reporter.log("Navigate to the Property Damage Tab.");
			log.info("Navigate to the Property Damage Tab.");

			// click on the next button
			click("ohs_incident_nextbtn_CSS");
			System.out.println("Clicked on the next button.");
			ngDriver.waitForAngularRequestsToFinish();

			// synchronization
			explicitWait("ohs_incident_nextbtn_CSS");
			System.out.println("Navigate to the Insurance Tab.");
			test.log(LogStatus.INFO, "Navigate to the Insurance Tab.");
			Reporter.log("Navigate to the Insurance Tab.");
			log.info("Navigate to the Insurance Tab.");

			// click on the next button
			click("ohs_incident_nextbtn_CSS");
			System.out.println("Clicked on the next button.");
			ngDriver.waitForAngularRequestsToFinish();

			// synchronization
			explicitWait("ohs_incident_updaterecordbtn_CSS");
			System.out.println("Navigate to the Attachments Tab.");
			test.log(LogStatus.INFO, "Navigate to the Attachments Tab.");
			Reporter.log("Navigate to the Attachments Tab.");
			log.info("Navigate to the Attachments Tab.");

			// click on the update record button
			click("ohs_incident_updaterecordbtn_CSS");
			ngDriver.waitForAngularRequestsToFinish();
			System.out.println("The update record button clicked successfully");

			// wait for 3 seconds
			Thread.sleep(3000);

			// enter the newly created incident report in the search field
			clear("ohs_incident_searchtxt_CSS");
			System.out.println("Cleared the search field.");
			ngDriver.waitForAngularRequestsToFinish();
			type("ohs_incident_searchtxt_CSS", data.get("short_description"));
			System.out.println("Entered the newly created incident report in the search field.");
			ngDriver.waitForAngularRequestsToFinish();

			// verification of the incident report is added or not
			switchVerification("ohs_incident_addedincidentreport_XPATH",
					"Short Description for Testing Purpose CRUD OHS",
					"The Short Description for Testing Purpose CRUD OHS is not displayed successfully.");

		} catch (Throwable t) {
			verificationFailed();
		}

		// ADD THE TASK IN THE NEWLY CREATED INCIDENT REPORT

		System.out.println("***************** ADD THE TASK IN THE NEWLY CREATED INCIDENT REPORT *****************");
		test.log(LogStatus.INFO,
				"***************** ADD THE TASK IN THE NEWLY CREATED INCIDENT REPORT *****************");
		Reporter.log("***************** ADD THE TASK IN THE NEWLY CREATED INCIDENT REPORT *****************");
		log.info("***************** ADD THE TASK IN THE NEWLY CREATED INCIDENT REPORT *****************");

		try {
			// click on the added incident report
			click("ohs_incident_addedincidentreport_XPATH");
			System.out.println("Clicked on the incident record for add the task.");
			ngDriver.waitForAngularRequestsToFinish();
			System.out.println("Naviagte to the Update Incident record Screen.");

			// click on the task tab
			click("ohs_incident_tasktab_CSS");
			System.out.println("Clicked on the task tag.");
			ngDriver.waitForAngularRequestsToFinish();

			// click on the add task button
			click("ohs_incident_tasktab_addbtn_CSS");
			System.out.println("Clicked on the add task button.");
			ngDriver.waitForAngularRequestsToFinish();

			// scroll down the screen
			JavascriptExecutor js = (JavascriptExecutor) driver;
			js.executeScript("window.scrollBy(0,400)");

			// enter the data in the task title field
			type("task_addtask_titletxt_CSS", data.get("task_title"));
			System.out.println("Entered the data in the task title field.");
			ngDriver.waitForAngularRequestsToFinish();

			// enter the data in the task location field
			type("task_addtask_locationtxt_CSS", data.get("task_location"));
			System.out.println("Entered the data in the task location field.");
			ngDriver.waitForAngularRequestsToFinish();

			// click on the assign to field
			click("task_assigntotxt_CSS");
			System.out.println("Clicked on the assign to field.");
			ngDriver.waitForAngularRequestsToFinish();

			// click on the none button
			click("task_tasktag_nonebtn_CSS");
			System.out.println("Clicked on the none button.");
			ngDriver.waitForAngularRequestsToFinish();

			// enter the user name in the search field
			type("workflowsecurity_editortask_taskdetails_searchtasktagtxt_CSS", data.get("search_user"));
			System.out.println("Entered the user name in the search field.");
			ngDriver.waitForAngularRequestsToFinish();

			// click on the searched result
			click("questionnaire_createtask_selectusertxt_XPATH");
			System.out.println("Clicked on the searched result.");
			ngDriver.waitForAngularRequestsToFinish();

			// click on the assign to field
			click("task_assigntotxt_CSS");
			System.out.println("Clicked on the assign to field.");
			ngDriver.waitForAngularRequestsToFinish();

			// synchronization
			explicitWait("task_addtask_purchaseordertab_XPATH");

			// click on the purchase order/warranty tab
			click("task_addtask_purchaseordertab_XPATH");
			System.out.println("Clicked on the purchase order/warranty tab.");
			ngDriver.waitForAngularRequestsToFinish();

			// scroll down the screen
			js.executeScript("window.scrollBy(0,500)");

			// click on the warranty checkbox
			click("questionnaire_purchaseordertab_warrantycheckbox_CSS");
			System.out.println("Clicked on the warranty checkbox.");
			ngDriver.waitForAngularRequestsToFinish();

			// click on the po required
			click("questionnaire_purchaseordertab_porequired_CSS");
			System.out.println("Clicked on the po required checkbox.");
			ngDriver.waitForAngularRequestsToFinish();

			// click on the po approved
			click("questionnaire_purchaseordertab_poapproved_CSS");
			System.out.println("Clicked on the po approved.");
			ngDriver.waitForAngularRequestsToFinish();

			// synchronization
			explicitWait("questionnaire_purchaseordertab_ponumber_CSS");

			// enter the data in the po number field
			type("questionnaire_purchaseordertab_ponumber_CSS", data.get("task_ponumber"));
			System.out.println("Entered the data in the po number field.");
			ngDriver.waitForAngularRequestsToFinish();

			// click on the approved to proceed
			click("questionnaire_purchaseordertab_approvedtoproceed_CSS");
			System.out.println("Clicked on the approved to proceed.");
			ngDriver.waitForAngularRequestsToFinish();

			// synchronization
			explicitWait("questionnaire_purchaseordertab_estimaterequired_CSS");

			// click on the estimate required
			click("questionnaire_purchaseordertab_estimaterequired_CSS");
			System.out.println("Clicked on the estimate required.");
			ngDriver.waitForAngularRequestsToFinish();

			// enter the estimated amount in the field
			type("questionnaire_purchaseordertab_estimateamount_CSS", "1122");
			System.out.println("Enter the estimated amount in the field.");
			ngDriver.waitForAngularRequestsToFinish();

			// click on the save button
			click("ohs_incident_tasktab_addtaskbtn_CSS");
			System.out.println("Clicked on the save button.");
			ngDriver.waitForAngularRequestsToFinish();

			// enter the newly created task into the search field
			type("ohs_incident_tasktab_searchtasktxt_CSS", data.get("task_title"));
			System.out.println("Entered the newly created task into the search field.");
			ngDriver.waitForAngularRequestsToFinish();

			// verify newly created task is displayed or not
			switchVerification("ohs_incident_tasktab_addedtask_XPATH", "Test Task Incident Module Title Record",
					"The Test Task Incident Module Title Record is not displayed.");

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

		// VERIFY NEWLY CREATED TASK DISPLAY IN THE TASK MODULE AND UPDATE THE NEWLT
		// CREATED TASK IN TASK MODULE

		System.out.println(
				"***************** VERIFY NEWLY CREATED TASK DISPLAY IN THE TASK MODULE AND UPDATE THE NEWLT CREATED TASK IN TASK MODULE *****************");
		test.log(LogStatus.INFO,
				"***************** VERIFY NEWLY CREATED TASK DISPLAY IN THE TASK MODULE AND UPDATE THE NEWLT CREATED TASK IN TASK MODULE *****************");
		Reporter.log(
				"***************** VERIFY NEWLY CREATED TASK DISPLAY IN THE TASK MODULE AND UPDATE THE NEWLT CREATED TASK IN TASK MODULE *****************");
		log.info(
				"***************** VERIFY NEWLY CREATED TASK DISPLAY IN THE TASK MODULE AND UPDATE THE NEWLT CREATED TASK IN TASK MODULE *****************");

		try {
			// synchronization
			explicitWait("taskicon_CSS");

			// click on the task icon
			click("taskicon_CSS");
			System.out.println("Clicked on the task icon.");
			ngDriver.waitForAngularRequestsToFinish();

			// click on the clear button
			click("task_createdtask_clearbtn_XPATH");
			ngDriver.waitForAngularRequestsToFinish();
			System.out.println("Clicked on the clear button.");

			// enter the data in the search field
			type("task_filter_CSS", data.get("task_title"));
			System.out.println("Entered the data in the search field.");
			ngDriver.waitForAngularRequestsToFinish();

			// click on the search button
			click("task_createdtask_searchbtn_XPATH");
			ngDriver.waitForAngularRequestsToFinish();
			System.out.println("Clicked on the search button.");

			// verify newly created task is displayed or not
			switchVerification("ohs_incident_tasktab_addedtask1_XPATH", "Test Task Incident Module Title Record",
					"The Test Task Incident Module Title Record is not displayed.");

			// click on the newly created task
			click("ohs_incident_tasktab_addedtask1_XPATH");
			System.out.println("Click on the newly created task.");
			ngDriver.waitForAngularRequestsToFinish();

			// scroll down the screen
			JavascriptExecutor js = (JavascriptExecutor) driver;
			js.executeScript("window.scrollBy(0,200)");

			// update the title of the task
			clear("task_addtask_titletxt_CSS");
			type("task_addtask_titletxt_CSS", data.get("update_task_title"));
			System.out.println("Entered the updated data in the task title.");
			ngDriver.waitForAngularRequestsToFinish();

			// click on the update button
			click("survey_task_updatebtn_CSS");
			System.out.println("Clicked on the update button.");
			ngDriver.waitForAngularRequestsToFinish();

			// scroll up the screen
			js.executeScript("window.scrollBy(0,-500)");

			// click on the clear button
			click("task_createdtask_clearbtn_XPATH");
			ngDriver.waitForAngularRequestsToFinish();
			System.out.println("Clicked on the clear button.");

			// enter the data in the search field
			type("task_filter_CSS", data.get("update_task_title"));
			System.out.println("Entered the data in the search field.");
			ngDriver.waitForAngularRequestsToFinish();

			// click on the search button
			click("task_createdtask_searchbtn_XPATH");
			ngDriver.waitForAngularRequestsToFinish();
			System.out.println("Clicked on the search button.");

			// verify newly created task is displayed or not
			switchVerification("ohs_incident_tasktab_updatedtask1_XPATH",
					"Update Test Task Incident Module Title Record",
					"The Update Test Task Incident Module Title Record is not displayed.");

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

		// DELETE THE NEWLY CREATED TASK AND INCIDENT REPORT

		System.out.println("***************** DELETE THE NEWLY CREATED TASK AND INCIDENT REPORT *****************");
		test.log(LogStatus.INFO,
				"***************** DELETE THE NEWLY CREATED TASK AND INCIDENT REPORT *****************");
		Reporter.log("***************** DELETE THE NEWLY CREATED TASK AND INCIDENT REPORT *****************");
		log.info("***************** DELETE THE NEWLY CREATED TASK AND INCIDENT REPORT *****************");

		try {

			// click on the OHS icon from the property list page
			click("ohsicon_CSS");
			System.out.println("Clicked on the OHS icon of the Property.");
			ngDriver.waitForAngularRequestsToFinish();
			System.out.println("Navigate to the OHS screen of the perticular property.");

			// wait for element
			explicitWaitClickable("menubtn_CSS");

			// click on the burger menu
			click("menubtn_CSS");
			System.out.println("Clicked on the burger menu button successfully!!!");
			ngDriver.waitForAngularRequestsToFinish();

			// wait for element
			explicitWaitClickable("questionnaire_option_ohstab_incidentreports_XPATH");

			// click on the incident reports
			click("questionnaire_option_ohstab_incidentreports_XPATH");
			System.out.println("Clicked on the incident reports option.");
			ngDriver.waitForAngularRequestsToFinish();

			// synchronization
			explicitWait("ohs_incident_searchtxt_CSS");

			// enter the newly created incident report in the search field
			clear("ohs_incident_searchtxt_CSS");
			type("ohs_incident_searchtxt_CSS", data.get("short_description"));
			System.out.println("Entered the newly created incident report in the search field.");
			ngDriver.waitForAngularRequestsToFinish();

			// verification of the incident report is added or not
			switchVerification("ohs_incident_addedincidentreport_XPATH",
					"Short Description for Testing Purpose CRUD OHS",
					"The Short Description for Testing Purpose CRUD OHS is not displayed successfully.");

			// click on the added incident report
			click("ohs_incident_addedincidentreport_XPATH");
			System.out.println("Clicked on the incident record for add the task.");
			ngDriver.waitForAngularRequestsToFinish();
			System.out.println("Naviagte to the Update Incident record Screen.");

			// click on the task tab
			click("ohs_incident_tasktab_CSS");
			System.out.println("Clicked on the task tag.");
			ngDriver.waitForAngularRequestsToFinish();

			// enter the updated task into the search field
			type("ohs_incident_tasktab_searchtasktxt_CSS", data.get("update_task_title"));
			System.out.println("Entered the newly created task into the search field.");
			ngDriver.waitForAngularRequestsToFinish();

			// verify updated task is displayed or not
			switchVerification("ohs_incident_tasktab_updatedtask_XPATH",
					"Update Test Task Incident Module Title Record",
					"Update The Test Task Incident Module Title Record is not displayed.");

			// click on the newly created task
			click("ohs_incident_tasktab_updatedtask_XPATH");
			ngDriver.waitForAngularRequestsToFinish();
			System.out.println("Clicked on the newly created task.");

			// wait for element
			explicitWaitClickable("ohs_task_deletebtn_XPATH");

			// click on the delete button
			click("ohs_task_deletebtn_XPATH");
			ngDriver.waitForAngularRequestsToFinish();
			System.out.println("Clicked on the delete button.");

			// wait for element
			explicitWaitClickable("ohs_task_confirmationdeletebtn_XPATH");

			// click on the delete button of confirmation popup model
			click("ohs_task_confirmationdeletebtn_XPATH");
			ngDriver.waitForAngularRequestsToFinish();
			System.out.println("Clicked on the delete button of confirmation popup model.");

			// click on the incident summary tab
			click("ohs_incident_incidentsummarytab_CSS");
			ngDriver.waitForAngularRequestsToFinish();
			System.out.println("Clicked on the incident summary tab");

			// wait for element
			explicitWaitClickable("ohs_incident_deletebtn_CSS");

			// click on the delete button for delete the incident report
			click("ohs_incident_deletebtn_CSS");
			System.out.println("Clicked on the delete button for delete the incident report.");
			ngDriver.waitForAngularRequestsToFinish();

			// wait for element
			explicitWaitClickable("ohs_incident_confirmdeletebtn_CSS");

			// click on the delete button of confirmation model for delete the incident
			// report
			click("ohs_incident_confirmdeletebtn_CSS");
			ngDriver.waitForAngularRequestsToFinish();
			System.out.println("Clicked on the delete button of confirmation model for delete the incident report.");

			// enter the newly created incident report in the search field
			clear("ohs_incident_searchtxt_CSS");
			type("ohs_incident_searchtxt_CSS", data.get("short_description"));
			System.out.println("Entered the newly created incident report in the search field.");
			ngDriver.waitForAngularRequestsToFinish();

			helper.deleteVerification("ohs_incident_addedincidentreport_XPATH",
					"Short Description for Testing Purpose CRUD OHS");

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

		// VERIFY TASK IS DELETED IN THE TASK MODULE OR NOT

		System.out.println("***************** VERIFY TASK IS DELETED IN THE TASK MODULE OR NOT *****************");
		test.log(LogStatus.INFO,
				"***************** VERIFY TASK IS DELETED IN THE TASK MODULE OR NOT *****************");
		Reporter.log("***************** VERIFY TASK IS DELETED IN THE TASK MODULE OR NOT *****************");
		log.info("***************** VERIFY TASK IS DELETED IN THE TASK MODULE OR NOT *****************");

		try {

			// synchronization
			explicitWait("taskicon_CSS");

			// click on the task icon
			click("taskicon_CSS");
			System.out.println("Clicked on the task icon.");
			ngDriver.waitForAngularRequestsToFinish();

			// click on the clear button
			click("task_createdtask_clearbtn_XPATH");
			ngDriver.waitForAngularRequestsToFinish();
			System.out.println("Clicked on the clear button.");

			// enter the data in the search field
			type("task_filter_CSS", data.get("update_task_title"));
			System.out.println("Entered the data in the search field.");
			ngDriver.waitForAngularRequestsToFinish();

			// click on the search button
			click("task_createdtask_searchbtn_XPATH");
			ngDriver.waitForAngularRequestsToFinish();
			System.out.println("Clicked on the search button.");

			helper.deleteVerification("ohs_incident_tasktab_updatedtask1_XPATH",
					"Update Test Task Incident Module Title Record");

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

	}
}
