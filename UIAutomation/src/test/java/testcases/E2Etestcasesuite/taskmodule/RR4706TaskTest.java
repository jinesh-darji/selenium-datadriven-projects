package testcases.E2Etestcasesuite.taskmodule;

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

public class RR4706TaskTest extends TestBase {

	@Test(dataProviderClass = TestUtil.class, dataProvider = "dp")
	public void rR4706TaskTest(Hashtable<String, String> data) throws IOException, InterruptedException {

		execution(data, "rR4706TaskTest");

		// CRUD OPERATION OF THE TASK OF THE ENVIRONMENTAL RECORD.

		System.out.println("CRUD OPERATION OF THE TASK OF THE ENVIRONMENTAL RECORD.");
		test.log(LogStatus.INFO, "CRUD OPERATION OF THE TASK OF THE ENVIRONMENTAL RECORD.");
		Reporter.log("CRUD OPERATION OF THE TASK OF THE ENVIRONMENTAL RECORD.");
		log.info("CRUD OPERATION OF THE TASK OF THE ENVIRONMENTAL RECORD.");

		Helper helper = new Helper();

		// refresh the page
		driver.navigate().refresh();
		Thread.sleep(5000);
		driver.navigate().refresh();

		System.out.println("Navigate to the Home Screen i.e. Property List Screen.");

		// CREATE ENVIRONMENTAL RECORDS - ASBESTOS MATERIALS

		System.out.println("***************** CREATE ENVIRONMENTAL RECORDS - ASBESTOS MATERIALS *****************");
		test.log(LogStatus.INFO,
				"***************** CREATE ENVIRONMENTAL RECORDS - ASBESTOS MATERIALS *****************");
		Reporter.log("***************** CREATE ENVIRONMENTAL RECORDS - ASBESTOS MATERIALS *****************");
		log.info("***************** CREATE ENVIRONMENTAL RECORDS - ASBESTOS MATERIALS *****************");

		try {

			// click on the environmental icon from the property list page
			click("environmentalicon_CSS");
			System.out.println("Clicked on the environmental icon of the Property.");
			ngDriver.waitForAngularRequestsToFinish();
			System.out.println("Navigate to the environmental screen of the perticular property.");

			// click on the burger menu
			click("menubtn_CSS");
			System.out.println("Clicked on the burger menu button successfully!!!");
			ngDriver.waitForAngularRequestsToFinish();

			// wait for the element
			explicitWaitClickable("envreportoption_XPATH");

			// click on the environmental records
			click("envrecords_XPATH");
			System.out.println("Clicked on the Environmental Records option.");
			ngDriver.waitForAngularRequestsToFinish();

			// click on the Primary Hazardous Substance
			click("envrecords_primaryhazardoussubstance_XPATH");
			System.out.println("Clicked on the Primary Hazardous Substance option");
			ngDriver.waitForAngularRequestsToFinish();

			// click on the asbestos materials
			click("envreports_asbestosmaterials_XPATH");
			System.out.println("Clicked on the Asbestos Materials option.");
			ngDriver.waitForAngularRequestsToFinish();
			System.out.println("Navigate to the Asbestos Meteria Records Screen.");

			// click on the add button
			click("envreports_asbestosmaterials_addbtn_BTNTEXT");
			System.out.println("Clicked on the Add button.");
			ngDriver.waitForAngularRequestsToFinish();
			System.out.println("Navigate to the Add Asbestos Material Screen");

			// select the material
			select("envreports_asbestosmaterials_materialdd_CSS", data.get("material"));
			ngDriver.waitForAngularRequestsToFinish();
			System.out.println("The option is selected from the Material dropdown.");

			// enter the detailed description
			type("envreports_asbestosmaterials_detaileddescriptiontxt_CSS", data.get("detailed_description"));
			System.out.println("The data is entered in the Detailed Description field.");
			ngDriver.waitForAngularRequestsToFinish();

//		// enter the detailed description code
//		type("envreports_asbestosmaterials_detaileddescriptioncodetxt_CSS", data.get("detailed_description_code"));
//		System.out.println("The data is entered in the Detailed Description Code field.");
//		ngDriver.waitForAngularRequestsToFinish();

			// enter the detailed location
			type("envreports_asbestosmaterials_detailedlocationtxt_CSS", data.get("detailed_location"));
			System.out.println("The data is entered in the Detailed location field.");
			ngDriver.waitForAngularRequestsToFinish();

//		// select the material analyzed
//		select("envreports_asbestosmaterials_materialanalyzeddd_CSS", data.get("material_analyzed"));
//		ngDriver.waitForAngularRequestsToFinish();
//		System.out.println("The option is selected from the Material Analyzed dropdown.");

			// scroll down the screen
			JavascriptExecutor js = (JavascriptExecutor) driver;
			js.executeScript("window.scrollBy(0,400)");

			// select the estimated risk
			select("envreports_asbestosmaterials_estimatedriskdd_CSS", data.get("estimated_risk"));
			ngDriver.waitForAngularRequestsToFinish();
			System.out.println("The option is selected from the Estimated Risk dropdown.");

//		// select the tested date
//		click("envreports_asbestosmaterials_datetested_CSS");
//		System.out.println("Clicked on the Date Tested field.");
//		ngDriver.waitForAngularRequestsToFinish();
//		
//		// click on the today button
//		click("envreports_asbestosmaterials_datetested_todaybtn_XPATH");
//		System.out.println("Clicked on the today button.");
//		ngDriver.waitForAngularRequestsToFinish();
//
//		// enter the data in the result(%ACM) field
//		type("envreports_asbestosmaterials_resulttxt_CSS", "90");
//		System.out.println("Entered data in the result(%ACM) field.");

			// select the is material asbestos containing
			select("envreports_asbestosmaterials_ismaterialasbestoscontainingdd_CSS",
					data.get("is_material_asbestos_containing"));
			ngDriver.waitForAngularRequestsToFinish();
			System.out.println("The option is selected from the Material Analyzed dropdown.");

			// select the asbestos type
			select("envreports_asbestosmaterials_asbestostypedd_CSS", data.get("asbestos_type"));
			ngDriver.waitForAngularRequestsToFinish();
			System.out.println("The option is selected from the Asbestos Type dropdown.");

			// select the condition
			select("envreports_asbestosmaterials_conditiondd_CSS", data.get("condition"));
			ngDriver.waitForAngularRequestsToFinish();
			System.out.println("The option is selected from the Condition dropdown.");

			// select the status
			select("envreports_asbestosmaterials_statusdd_CSS", data.get("status"));
			ngDriver.waitForAngularRequestsToFinish();
			System.out.println("The option is selected from the Status dropdown.");

			// scroll till bottom of the page
			js.executeScript("window.scrollBy(0,1000)");

			// enter the details
			type("envreports_asbestosmaterials_detailstxt_CSS", data.get("details"));
			System.out.println("The data is entered in the Details field");
			ngDriver.waitForAngularRequestsToFinish();

//		// select the remediation status
//		select("envreports_asbestosmaterials_remediationstatusdd_CSS", data.get("remediation_status"));
//		ngDriver.waitForAngularRequestsToFinish();
//		System.out.println("The option is selected from the remediation status dropdown.");
//
//		// select remediation completed date
//		click("envreports_asbestosmaterials_remediationcompleteddate_CSS");
//		ngDriver.waitForAngularRequestsToFinish();
//		click("envreports_asbestosmaterials_todaybtn_BTNTEXT");
//		ngDriver.waitForAngularRequestsToFinish();
//		System.out.println("Today's date selected in the Remediation Completed Date Field.");

			// click on the save button
			click("envreports_asbestosmaterials_savebtn_BTNTEXT");
			ngDriver.waitForAngularRequestsToFinish();
			System.out.println("The save button clicked successfully");

			// enter the newly created environmental record in the search field
			clear("task_listofchecklist_filterfield_CSS");
			System.out.println("Cleared the search field.");
			ngDriver.waitForAngularRequestsToFinish();
			type("task_listofchecklist_filterfield_CSS", data.get("detailed_location"));
			System.out.println("Entered the newly created environmental record in the search field.");
			ngDriver.waitForAngularRequestsToFinish();

			// verification of the environmental record is added or not
			switchVerification("envrecordaddedrecord_crudtask_XPATH",
					"Test Detailed Location CRUD Environmental Record",
					"The Test Detailed Location CRUD Environmental Record is not displayed successfully.");

		} catch (Throwable t) {

			verificationFailed();
		}

		// ADD THE TASK IN THE NEWLY CREATED ENVIRONMENTAL RECORDS

		System.out
				.println("***************** ADD THE TASK IN THE NEWLY CREATED ENVIRONMENTAL RECORDS *****************");
		test.log(LogStatus.INFO,
				"***************** ADD THE TASK IN THE NEWLY CREATED ENVIRONMENTAL RECORDS *****************");
		Reporter.log("***************** ADD THE TASK IN THE NEWLY CREATED ENVIRONMENTAL RECORDS *****************");
		log.info("***************** ADD THE TASK IN THE NEWLY CREATED ENVIRONMENTAL RECORDS *****************");

		try {

			// click on the added environmental record
			click("envrecordaddedrecord_crudtask_XPATH");
			System.out.println("Clicked on the created record for add the task.");
			ngDriver.waitForAngularRequestsToFinish();
			System.out.println("Naviagte to the Update Environmental record Screen.");

			// click on the task tab
			click("envreportaddedrecord_tasktab_XPATH");
			System.out.println("Clicked on the task tag.");
			ngDriver.waitForAngularRequestsToFinish();

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
			click("survey_task_savebtn_CSS");
			System.out.println("Clicked on the save button.");
			ngDriver.waitForAngularRequestsToFinish();

			// wait for the element
			explicitWaitClickable("closetoastmsg_CSS");

			// click on the toaster close button
			click("closetoastmsg_CSS");
			ngDriver.waitForAngularRequestsToFinish();
			System.out.println("Clicked on the toaster close button.");

			// verify newly created task is displayed or not
			switchVerification("envrecordaddedrecord_tasktab_addtask_XPATH",
					"Test Task Environment Module Title Record",
					"The Test Task Environment Module Title Record is not displayed.");

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

		// VERIFY NEWLY CREATED TASK UNDER ENVIRONMENTAL RECORD

		System.out.println("***************** VERIFY NEWLY CREATED TASK UNDER ENVIRONMENTAL RECORD *****************");
		test.log(LogStatus.INFO,
				"***************** VERIFY NEWLY CREATED TASK UNDER ENVIRONMENTAL RECORD *****************");
		Reporter.log("***************** VERIFY NEWLY CREATED TASK UNDER ENVIRONMENTAL RECORD *****************");
		log.info("***************** VERIFY NEWLY CREATED TASK UNDER ENVIRONMENTAL RECORD *****************");

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
			switchVerification("envrecordaddedrecord_tasktab_addtask1_XPATH",
					"Test Task Environment Module Title Record",
					"The Test Task Environment Module Title Record is not displayed.");

		} catch (Throwable t) {
			verificationFailed();
		}

		// UPDATE THE NEWLT CREATED TASK IN TASK MODULE

		System.out.println("***************** UPDATE THE NEWLT CREATED TASK IN TASK MODULE *****************");
		test.log(LogStatus.INFO, "***************** UPDATE THE NEWLT CREATED TASK IN TASK MODULE *****************");
		Reporter.log("***************** UPDATE THE NEWLT CREATED TASK IN TASK MODULE *****************");
		log.info("***************** UPDATE THE NEWLT CREATED TASK IN TASK MODULE *****************");

		try {
			// click on the newly created task
			click("envrecordaddedrecord_tasktab_addtask1_XPATH");
			System.out.println("Click on the newly created task.");
			ngDriver.waitForAngularRequestsToFinish();

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
			switchVerification("envrecordaddedrecord_tasktab_updatedtask1_XPATH",
					"Update Test Task Environment Module Title Record",
					"The Update Test Task Environment Module Title Record is not displayed.");

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

		// DELETE THE NEWLY CREATED TASK - ENVIRONMENTAL REPORT

		System.out.println("***************** DELETE THE NEWLY CREATED TASK - ENVIRONMENTAL REPORT *****************");
		test.log(LogStatus.INFO,
				"***************** DELETE THE NEWLY CREATED TASK - ENVIRONMENTAL REPORT *****************");
		Reporter.log("***************** DELETE THE NEWLY CREATED TASK - ENVIRONMENTAL REPORT *****************");
		log.info("***************** DELETE THE NEWLY CREATED TASK - ENVIRONMENTAL REPORT *****************");

		try {

			// click on the environmental icon from the property list page
			click("environmentalicon_CSS");
			System.out.println("Clicked on the environmental icon of the Property.");
			ngDriver.waitForAngularRequestsToFinish();
			System.out.println("Navigate to the environmental screen of the perticular property.");

			// wait for element
			explicitWaitClickable("menubtn_CSS");

			// click on the burger menu
			click("menubtn_CSS");
			System.out.println("Clicked on the burger menu button successfully!!!");
			ngDriver.waitForAngularRequestsToFinish();

			// wait for element
			explicitWaitClickable("envrecords_XPATH");

			// click on the environmental records
			click("envrecords_XPATH");
			System.out.println("Clicked on the Environmental Records option.");
			ngDriver.waitForAngularRequestsToFinish();

			// wait for element
			explicitWaitClickable("envrecords_primaryhazardoussubstance_XPATH");

			// click on the Primary Hazardous Substance
			click("envrecords_primaryhazardoussubstance_XPATH");
			System.out.println("Clicked on the Primary Hazardous Substance option");
			ngDriver.waitForAngularRequestsToFinish();

			// wait for element
			explicitWaitClickable("envreports_asbestosmaterials_XPATH");

			// click on the asbestos materials
			click("envreports_asbestosmaterials_XPATH");
			System.out.println("Clicked on the Asbestos Materials option.");
			ngDriver.waitForAngularRequestsToFinish();
			System.out.println("Navigate to the Asbestos Meteria Records Screen.");

			// enter the newly created environmental record in the search field
			clear("task_listofchecklist_filterfield_CSS");
			type("task_listofchecklist_filterfield_CSS", data.get("detailed_location"));
			System.out.println("Entered the newly created environmental record in the search field.");
			ngDriver.waitForAngularRequestsToFinish();

			// verification of the environmental record is added or not
			switchVerification("envrecordaddedrecord_crudtask_XPATH",
					"Test Detailed Location CRUD Environmental Record",
					"The Test Detailed Location CRUD Environmental Record is not displayed successfully.");

			// click on the environmental record
			click("envrecordaddedrecord_crudtask_XPATH");
			System.out.println("Clicked on the environmental record.");
			ngDriver.waitForAngularRequestsToFinish();

			// click on the task tab
			click("envreportaddedrecord_tasktab_XPATH");
			System.out.println("Clicked on the task tag.");
			ngDriver.waitForAngularRequestsToFinish();

			// verify updated task is displayed or not
			switchVerification("envrecordaddedrecord_tasktab_updatedtask_XPATH",
					"Update Test Task Environment Module Title Record",
					"The Update Test Task Environment Module Title Record is not displayed.");

			// click on the action icon
			String action1 = "//td[text()='" + data.get("update_task_title")
					+ "']//following-sibling::td[@class='text-center pointer']//div[@class='dropdown']//i[@data-toggle='dropdown']";
			driver.findElement(By.xpath(action1)).click();
			ngDriver.waitForAngularRequestsToFinish();
			System.out.println("Clicked on the action icon.");

			// click on the delete option
			String deleteOption1 = "//td[text()='" + data.get("update_task_title")
					+ "']//following-sibling::td[@class='text-center pointer']//div[@class='dropdown open']//li[@ng-click='deleteSelectedTask(task.id, true);']";
			driver.findElement(By.xpath(deleteOption1)).click();
			ngDriver.waitForAngularRequestsToFinish();
			System.out.println("Clicked on the delete option.");

			// wait for the element
			explicitWaitClickable("closetoastmsg_CSS");

			// click on the toaster close button
			click("closetoastmsg_CSS");
			ngDriver.waitForAngularRequestsToFinish();
			System.out.println("Clicked on the toaster close button.");

			// verify the questionnaire deleted or not
			helper.deleteVerification("envrecordaddedrecord_tasktab_updatedtask_XPATH",
					"Update Test Task Environment Module Title Record");

		} catch (Throwable t) {
			verificationFailed();
		}

		// DELETE THE ENVIRONMENTAL REPORT

		System.out.println("***************** DELETE THE ENVIRONMENTAL REPORT *****************");
		test.log(LogStatus.INFO, "***************** DELETE THE ENVIRONMENTAL REPORT *****************");
		Reporter.log("***************** DELETE THE ENVIRONMENTAL REPORT *****************");
		log.info("***************** DELETE THE ENVIRONMENTAL REPORT *****************");

		try {

			// wait for element
			explicitWaitClickable("envreportdeletebtn_CSS");

			// click on the delete button
			click("envreportdeletebtn_CSS");
			System.out.println("Clicked on the Delete Button.");
			ngDriver.waitForAngularRequestsToFinish();

			// wait for the element
			explicitWaitClickable("envreportmodeldeletebtn_CSS");

			// click on the delete button of the confirmation model
			click("envreportmodeldeletebtn_CSS");
			System.out.println("Clicked on the Delete Button of the confirmation popup model.");
			ngDriver.waitForAngularRequestsToFinish();

			// enter the environmental record in the search field
			clear("task_listofchecklist_filterfield_CSS");
			type("task_listofchecklist_filterfield_CSS", data.get("detailed_location"));
			System.out.println("Entered the environmental record in the search field.");
			ngDriver.waitForAngularRequestsToFinish();

			helper.deleteVerification("envrecordaddedrecord_crudtask_XPATH",
					"Test Detailed Location CRUD Environmental Record");

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

			helper.deleteVerification("envrecordaddedrecord_tasktab_updatedtask_XPATH",
					"Update Test Task Environment Module Title Record");

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
