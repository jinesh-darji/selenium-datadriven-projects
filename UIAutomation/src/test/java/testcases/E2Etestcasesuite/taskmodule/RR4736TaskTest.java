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

public class RR4736TaskTest extends TestBase {

	@Test(dataProviderClass = TestUtil.class, dataProvider = "dp")
	public void rR4736TaskTest(Hashtable<String, String> data) throws IOException, InterruptedException {

		execution(data, "rR4736TaskTest");

		// CRUD OPERATION OF THE TASK OF THE INSURANCE CLAIM OF THE RISK MANAGEMENT.
		title("CRUD OPERATION OF THE TASK OF THE INSURANCE CLAIM OF THE RISK MANAGEMENT.");

		Helper helper = new Helper();

		// refresh the page
		driver.navigate().refresh();
		Thread.sleep(5000);
		driver.navigate().refresh();

		// CREATE NEW RECORD IN THE INSURANCE CLAIM MODULE
		title("CREATE NEW RECORD IN THE INSURANCE CLAIM MODULE");

		try {

			// click on the risk management icon from the property list page
			click("riskmanagementicon_CSS");

			// wait for element
			explicitWaitClickable("menubtn_CSS");

			// click on the burger menu
			click("menubtn_CSS");

			// wait for element
			explicitWaitClickable("riskmanagement_insuranceclaimoption_XPATH");

			// click on the insurance claim
			click("riskmanagement_insuranceclaimoption_XPATH");

			// click on the add button
			click("riskmanagement_addinsuranceclaim_CSS");

			// enter the details in the incident
			type("riskmanagement_insuranceclaim_incidenttxt_CSS", data.get("incident"));

			// select the claim status
			select("riskmanagement_insuranceclaim_claimstatusdd_CSS", data.get("claim_status"));

			// select the claim type
			select("riskmanagement_insuranceclaim_claimtypedd_CSS", data.get("claim_type"));

			// scroll down the screen
			scrollByPixel(400);

			// enter the loss summary statement
			type("riskmanagement_insuranceclaim_losssummarystatementtxt_CSS", data.get("loss_summary_statement"));

			// click on the save button
			click("riskmanagement_insuranceclaim_saveinsuranceclaim_CSS");

			// enter incident into the search field
			type("riskmanagement_insuranceclaim_searchtxt_CSS", data.get("incident"));

			// verify newly created insurance claim is displayed or not
			switchVerification("riskmanagement_addedinsuranceclaim_XPATH", "AutoIncident123456",
					"The AutoIncident123456 is not displayed.");

		} catch (Throwable t) {
			verificationFailed();
		}

		// ADD THE TASK UNDER NEWLY CREATED INSURANCE CLAIM
		title("ADD THE TASK UNDER NEWLY CREATED INSURANCE CLAIM");

		try {
			// click on the newly created insurance claim
			click("riskmanagement_addedinsuranceclaim_XPATH");

			// click on the task tab
			click("riskmanagement_insuranceclaim_tasktab_CSS");

			// click on the new task button
			click("checklist_newtaskbtn_CSS");

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

			// click on the save button
			click("riskmanagement_insuranceclaim_savetaskbtn_CSS");

			// synchronization
			explicitWait("riskmanagement_addedtask_XPATH");

			// verify task is created or not
			switchVerification("riskmanagement_addedtask_XPATH", "Test Task Insurance Claim Title Record",
					"The Test Task Insurance Claim Title Record is not displayed.");

		} catch (Throwable t) {
			verificationFailed();
		}

		// click on the home icon from the top of the screen
		click("questionnaire_homeburgermenubtn_hide_CSS");

		// synchronization
		explicitWait("propertylist_title_XPATH");

		// verify the property list
		switchVerification("propertylist_title_XPATH", "Property List", "The property list is not displayed.");

		// UPDATE THE TASK FROM THE TASK MODULE
		title("UPDATE THE TASK FROM THE TASK MODULE");

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
			switchVerification("riskmanagement_addedtask1_XPATH", "Test Task Insurance Claim Title Record",
					"The Test Task Insurance Claim Title Record is not displayed.");

			// click on the newly created task
			click("riskmanagement_addedtask1_XPATH");

			// update the title of the task
			type("task_addtask_titletxt_CSS", data.get("update_task_title"));

			// click on the update button
			click("riskmanagement_updatetask_BTNTEXT");

			// scroll up the screen
			scrollByPixel(-500);

			// click on the clear button
			click("task_createdtask_clearbtn_XPATH");

			// enter the data in the search field
			type("task_filter_CSS", data.get("update_task_title"));

			// click on the search button
			click("task_createdtask_searchbtn_XPATH");

			// verify newly created task is displayed or not
			switchVerification("riskmanagement_updatedtask1_XPATH", "Update Test Task Insurance Claim Title Record",
					"The Update Test Task Insurance Claim Title Record Record is not displayed.");

		} catch (Throwable t) {
			verificationFailed();
		}

		// click on the home icon from the top of the screen
		click("questionnaire_homeburgermenubtn_hide_CSS");

		// synchronization
		explicitWait("propertylist_title_XPATH");

		// verify the property list
		switchVerification("propertylist_title_XPATH", "Property List", "The property list is not displayed.");

		// DELETE THE NEWLY CREATED TASK
		title("DELETE THE NEWLY CREATED TASK");

		try {
			// click on the risk management icon from the property list page
			click("riskmanagementicon_CSS");

			// wait for element
			explicitWaitClickable("menubtn_CSS");

			// click on the burger menu
			click("menubtn_CSS");

			// wait for element
			explicitWaitClickable("riskmanagement_insuranceclaimoption_XPATH");

			// click on the insurance claim
			click("riskmanagement_insuranceclaimoption_XPATH");

			// synchronization
			explicitWait("riskmanagement_insuranceclaim_searchtxt_CSS");

			// enter the newly created insurance claim in the search field
			type("riskmanagement_insuranceclaim_searchtxt_CSS", data.get("incident"));

			// verification of the insurance claim is added or not
			switchVerification("riskmanagement_addedinsuranceclaim_XPATH", "AutoIncident123456",
					"insurance claim is not displayed successfully.");

			// click on the newly insurance claim
			click("riskmanagement_addedinsuranceclaim_XPATH");

			// wait for element
			explicitWaitClickable("riskmanagement_insurance_deletebtn_XPATH");

			// click on the delete button
			click("riskmanagement_insurance_deletebtn_XPATH");

			// wait for element
			explicitWaitClickable("riskmanagement_insurance_confirmationdeletebtn_XPATH");

			// click on the delete button of the confirmation model
			click("riskmanagement_insurance_confirmationdeletebtn_XPATH");

			// enter the insurance claim in the search field
			type("riskmanagement_insuranceclaim_searchtxt_CSS", data.get("incident"));

			helper.deleteVerification("riskmanagement_addedinsuranceclaim_XPATH", "AutoIncident123456");

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

			// verify the questionnaire deleted or not
			helper.deleteVerification("riskmanagement_updatedtask_XPATH",
					"Update Test Task Insurance Claim Title Record");

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