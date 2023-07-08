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

		System.out.println("CRUD OPERATION OF THE TASK OF THE INSURANCE CLAIM OF THE RISK MANAGEMENT.");
		test.log(LogStatus.INFO, "CRUD OPERATION OF THE TASK OF THE INSURANCE CLAIM OF THE RISK MANAGEMENT.");
		Reporter.log("CRUD OPERATION OF THE TASK OF THE INSURANCE CLAIM OF THE RISK MANAGEMENT.");
		log.info("CRUD OPERATION OF THE TASK OF THE INSURANCE CLAIM OF THE RISK MANAGEMENT.");

		Helper helper = new Helper();

		// refresh the page
		driver.navigate().refresh();
		Thread.sleep(5000);
		driver.navigate().refresh();

		System.out.println("Navigate to the Home Screen i.e. Property List Screen.");

		// CREATE NEW RECORD IN THE INSURANCE CLAIM MODULE

		System.out.println("***************** CREATE NEW RECORD IN THE INSURANCE CLAIM MODULE *****************");
		test.log(LogStatus.INFO, "***************** CREATE NEW RECORD IN THE INSURANCE CLAIM MODULE *****************");
		Reporter.log("***************** CREATE NEW RECORD IN THE INSURANCE CLAIM MODULE *****************");
		log.info("***************** CREATE NEW RECORD IN THE INSURANCE CLAIM MODULE *****************");

		try {

			// click on the risk management icon from the property list page
			click("riskmanagementicon_CSS");
			System.out.println("Clicked on the risk management icon of the Property.");
			ngDriver.waitForAngularRequestsToFinish();
			System.out.println("Navigate to the risk management screen of the perticular property.");

			// wait for element
			explicitWaitClickable("menubtn_CSS");

			// click on the burger menu
			click("menubtn_CSS");
			System.out.println("Clicked on the burger menu button successfully!!!");
			ngDriver.waitForAngularRequestsToFinish();

			// wait for element
			explicitWaitClickable("riskmanagement_insuranceclaimoption_XPATH");

			// click on the insurance claim
			click("riskmanagement_insuranceclaimoption_XPATH");
			System.out.println("Clicked on the insurance claim option.");
			ngDriver.waitForAngularRequestsToFinish();

			// click on the add button
			click("riskmanagement_addinsuranceclaim_CSS");
			System.out.println("Clicked on the Add button.");
			ngDriver.waitForAngularRequestsToFinish();
			System.out.println("Navigate to the Add Insurance Claim Screen");

			// enter the details in the incident
			type("riskmanagement_insuranceclaim_incidenttxt_CSS", data.get("incident"));
			ngDriver.waitForAngularRequestsToFinish();
			System.out.println("Entered the details in the incident.");

			// select the claim status
			select("riskmanagement_insuranceclaim_claimstatusdd_CSS", data.get("claim_status"));
			ngDriver.waitForAngularRequestsToFinish();
			System.out.println("Selected the claim status.");

			// select the claim type
			select("riskmanagement_insuranceclaim_claimtypedd_CSS", data.get("claim_type"));
			ngDriver.waitForAngularRequestsToFinish();
			System.out.println("Selected the claim type.");

			// scroll down the screen
			JavascriptExecutor js = (JavascriptExecutor) driver;
			js.executeScript("window.scrollBy(0,400)");

			// enter the loss summary statement
			type("riskmanagement_insuranceclaim_losssummarystatementtxt_CSS", data.get("loss_summary_statement"));
			ngDriver.waitForAngularRequestsToFinish();
			System.out.println("Entered the loss summary statement.");

			// click on the save button
			click("riskmanagement_insuranceclaim_saveinsuranceclaim_CSS");
			ngDriver.waitForAngularRequestsToFinish();
			System.out.println("Clicked on the save button.");

			// enter incident into the search field
			type("riskmanagement_insuranceclaim_searchtxt_CSS", data.get("incident"));
			ngDriver.waitForAngularRequestsToFinish();
			System.out.println("Entered incident into the search field.");

			// verify newly created insurance claim is displayed or not
			switchVerification("riskmanagement_addedinsuranceclaim_XPATH", "AutoIncident123456",
					"The AutoIncident123456 is not displayed.");

		} catch (Throwable t) {
			verificationFailed();
		}

		// ADD THE TASK UNDER NEWLY CREATED INSURANCE CLAIM

		System.out.println("***************** ADD THE TASK UNDER NEWLY CREATED INSURANCE CLAIM *****************");
		test.log(LogStatus.INFO,
				"***************** ADD THE TASK UNDER NEWLY CREATED INSURANCE CLAIM *****************");
		Reporter.log("***************** ADD THE TASK UNDER NEWLY CREATED INSURANCE CLAIM *****************");
		log.info("***************** ADD THE TASK UNDER NEWLY CREATED INSURANCE CLAIM *****************");

		try {
			// click on the newly created insurance claim
			click("riskmanagement_addedinsuranceclaim_XPATH");
			ngDriver.waitForAngularRequestsToFinish();
			System.out.println("Clicked on the newly created insurance claim.");

			// click on the task tab
			click("riskmanagement_insuranceclaim_tasktab_CSS");
			ngDriver.waitForAngularRequestsToFinish();
			System.out.println("Clicked on the task tab.");

			// click on the new task button
			click("checklist_newtaskbtn_CSS");
			System.out.println("Clicked on the new task button.");
			ngDriver.waitForAngularRequestsToFinish();

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

			// click on the save button
			click("riskmanagement_insuranceclaim_savetaskbtn_CSS");
			ngDriver.waitForAngularRequestsToFinish();
			System.out.println("Clicked on the save button.");

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
		System.out.println("Clicked on the home icon from the top of the screen.");
		ngDriver.waitForAngularRequestsToFinish();

		// synchronization
		explicitWait("propertylist_title_XPATH");

		// verify the property list
		switchVerification("propertylist_title_XPATH", "Property List", "The property list is not displayed.");

		// UPDATE THE TASK FROM THE TASK MODULE

		System.out.println("***************** UPDATE THE TASK FROM THE TASK MODULE *****************");
		test.log(LogStatus.INFO, "***************** UPDATE THE TASK FROM THE TASK MODULE *****************");
		Reporter.log("***************** UPDATE THE TASK FROM THE TASK MODULE *****************");
		log.info("***************** UPDATE THE TASK FROM THE TASK MODULE *****************");

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
			switchVerification("riskmanagement_addedtask1_XPATH", "Test Task Insurance Claim Title Record",
					"The Test Task Insurance Claim Title Record is not displayed.");

			// click on the newly created task
			click("riskmanagement_addedtask1_XPATH");
			System.out.println("Click on the newly created task.");
			ngDriver.waitForAngularRequestsToFinish();

			// update the title of the task
			clear("task_addtask_titletxt_CSS");
			type("task_addtask_titletxt_CSS", data.get("update_task_title"));
			System.out.println("Entered the updated data in the task title.");
			ngDriver.waitForAngularRequestsToFinish();

			// click on the update button
			click("riskmanagement_updatetask_BTNTEXT");
			ngDriver.waitForAngularRequestsToFinish();
			System.out.println("Clicked on the update button.");

			// scroll up the screen
			JavascriptExecutor js = (JavascriptExecutor) driver;
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
			switchVerification("riskmanagement_updatedtask1_XPATH", "Update Test Task Insurance Claim Title Record",
					"The Update Test Task Insurance Claim Title Record Record is not displayed.");

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

		// DELETE THE NEWLY CREATED TASK

		System.out.println("***************** DELETE THE NEWLY CREATED TASK *****************");
		test.log(LogStatus.INFO, "***************** DELETE THE NEWLY CREATED TASK *****************");
		Reporter.log("***************** DELETE THE NEWLY CREATED TASK *****************");
		log.info("***************** DELETE THE NEWLY CREATED TASK *****************");

		try {
			// click on the risk management icon from the property list page
			click("riskmanagementicon_CSS");
			System.out.println("Clicked on the risk management icon of the Property.");
			ngDriver.waitForAngularRequestsToFinish();
			System.out.println("Navigate to the risk management screen of the perticular property.");

			// wait for element
			explicitWaitClickable("menubtn_CSS");

			// click on the burger menu
			click("menubtn_CSS");
			System.out.println("Clicked on the burger menu button successfully!!!");
			ngDriver.waitForAngularRequestsToFinish();

			// wait for element
			explicitWaitClickable("riskmanagement_insuranceclaimoption_XPATH");

			// click on the insurance claim
			click("riskmanagement_insuranceclaimoption_XPATH");
			System.out.println("Clicked on the insurance claim option.");
			ngDriver.waitForAngularRequestsToFinish();

			// synchronization
			explicitWait("riskmanagement_insuranceclaim_searchtxt_CSS");

			// enter the newly created insurance claim in the search field
			clear("riskmanagement_insuranceclaim_searchtxt_CSS");
			type("riskmanagement_insuranceclaim_searchtxt_CSS", data.get("incident"));
			System.out.println("Entered the newly created environmental record in the search field.");
			ngDriver.waitForAngularRequestsToFinish();

			// verification of the insurance claim is added or not
			switchVerification("riskmanagement_addedinsuranceclaim_XPATH", "AutoIncident123456",
					"insurance claim is not displayed successfully.");

			// click on the newly insurance claim
			click("riskmanagement_addedinsuranceclaim_XPATH");
			ngDriver.waitForAngularRequestsToFinish();
			System.out.println("Clicked on the newly created insurance claim.");

			// wait for element
			explicitWaitClickable("riskmanagement_insurance_deletebtn_XPATH");

			// click on the delete button
			click("riskmanagement_insurance_deletebtn_XPATH");
			System.out.println("Clicked on the Delete Button.");
			ngDriver.waitForAngularRequestsToFinish();
			System.out.println("The confirmation pop up model is displayed.");

			// wait for element
			explicitWaitClickable("riskmanagement_insurance_confirmationdeletebtn_XPATH");

			// click on the delete button of the confirmation model
			click("riskmanagement_insurance_confirmationdeletebtn_XPATH");
			System.out.println("Clicked on the Delete Button of the confirmation popup model.");
			ngDriver.waitForAngularRequestsToFinish();

			// enter the insurance claim in the search field
			clear("riskmanagement_insuranceclaim_searchtxt_CSS");
			type("riskmanagement_insuranceclaim_searchtxt_CSS", data.get("incident"));
			System.out.println("Entered the insurance claim in the search field.");
			ngDriver.waitForAngularRequestsToFinish();

			helper.deleteVerification("riskmanagement_addedinsuranceclaim_XPATH", "AutoIncident123456");

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

			// verify the questionnaire deleted or not
			helper.deleteVerification("riskmanagement_updatedtask_XPATH",
					"Update Test Task Insurance Claim Title Record");

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
