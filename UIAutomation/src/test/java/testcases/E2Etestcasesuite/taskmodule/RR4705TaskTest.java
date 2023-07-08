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

public class RR4705TaskTest extends TestBase {

	@Test(dataProviderClass = TestUtil.class, dataProvider = "dp")
	public void rR4705TaskTest(Hashtable<String, String> data) throws IOException, InterruptedException {

		execution(data, "rR4705TaskTest");

		// CRUD OPERATION OF THE TASK OF THE ENVIRONMENTAL REPORT

		System.out.println("CRUD OPERATION OF THE TASK OF THE ENVIRONMENTAL REPORT");
		test.log(LogStatus.INFO, "CRUD OPERATION OF THE TASK OF THE ENVIRONMENTAL REPORT");
		Reporter.log("CRUD OPERATION OF THE TASK OF THE ENVIRONMENTAL REPORT");
		log.info("CRUD OPERATION OF THE TASK OF THE ENVIRONMENTAL REPORT");

		Helper helper = new Helper();

		// refresh the page
		driver.navigate().refresh();
		Thread.sleep(5000);
		driver.navigate().refresh();

		System.out.println("Navigate to the Home Screen i.e. Property List Screen.");

		// CREATE ENVIRONMENTAL REPORTS

		System.out.println("***************** CREATE ENVIRONMENTAL REPORTS *****************");
		test.log(LogStatus.INFO, "***************** CREATE ENVIRONMENTAL REPORTS *****************");
		Reporter.log("***************** CREATE ENVIRONMENTAL REPORTS *****************");
		log.info("***************** CREATE ENVIRONMENTAL REPORTS *****************");

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

			// click on the Environmental Reports option
			click("envreportoption_XPATH");
			System.out.println("Clicked on the Environmental Reports option.");
			ngDriver.waitForAngularRequestsToFinish();
			System.out.println("Navigate to the Environmental Report Screen.");

			// click on the Add report button
			click("envreportaddbtn_CSS");
			System.out.println("Clicked on the Add report button");
			ngDriver.waitForAngularRequestsToFinish();
			System.out.println("Navigate to the Add Environmental Report Screen.");

			// select the checklist from the type dropdown
			select("envreporttypedd_CSS", data.get("type"));
			System.out.println("The option is selected from the Type dropdown.");
			ngDriver.waitForAngularRequestsToFinish();

			// enter the title
			type("envreporttitletxt_CSS", data.get("title"));
			System.out.println("The data entered in the Title field.");

			// click on the date field
			click("envreportdatetxt_CSS");
			ngDriver.waitForAngularRequestsToFinish();
			click("envreporttodaydate_BTNTEXT");
			System.out.println("Today's date selected in the Date Field.");

			// enter the company
			type("envreportcompanytxt_CSS", data.get("company"));
			System.out.println("The data entered in the Company field.");

			// enter the author
			type("envreportauthortxt_CSS", data.get("author"));
			System.out.println("The data entered in the Author field.");

			// enter the description
			type("envreportdescriptiontxt_CSS", data.get("description"));
			System.out.println("The data entered in the Description field.");

			// click on the save button
			click("envreportsavebtn_BTNTEXT");
			System.out.println("Clicked on the Save Button.");
			ngDriver.waitForAngularRequestsToFinish();
			System.out.println("Navigate to the Add Report Screen.");

			// wait for the element
			explicitWaitClickable("closetoastmsg_CSS");

			// click on the toaster close button
			click("closetoastmsg_CSS");
			ngDriver.waitForAngularRequestsToFinish();
			System.out.println("Clicked on the toaster close button.");

			// enter the newly created environmental report in the search field
			clear("task_listofchecklist_filterfield_CSS");
			type("task_listofchecklist_filterfield_CSS", data.get("title"));
			System.out.println("Entered the newly created environmental report in the search field.");
			ngDriver.waitForAngularRequestsToFinish();

			// verification of the environmental report is added or not
			switchVerification("envreportaddedrecord_crudtask_XPATH", "Test Title CRUD Environment Report",
					"The Test Task Environment Module Title is not displayed successfully.");

		} catch (Throwable t) {

			verificationFailed();
		}

		// ADD THE TASK IN THE NEWLY CREATED ENVIRONMENTAL REPORTS

		System.out
				.println("***************** ADD THE TASK IN THE NEWLY CREATED ENVIRONMENTAL REPORTS *****************");
		test.log(LogStatus.INFO,
				"***************** ADD THE TASK IN THE NEWLY CREATED ENVIRONMENTAL REPORTS *****************");
		Reporter.log("***************** ADD THE TASK IN THE NEWLY CREATED ENVIRONMENTAL REPORTS *****************");
		log.info("***************** ADD THE TASK IN THE NEWLY CREATED ENVIRONMENTAL REPORTS *****************");

		try {
			// click on the added environmental record
			click("envreportaddedrecord_crudtask_XPATH");
			System.out.println("Clicked on the created record for add the task.");
			ngDriver.waitForAngularRequestsToFinish();
			System.out.println("Naviagte to the Update Environmental Report Screen.");

			// click on the task tab
			click("envreportaddedrecord_tasktab_XPATH");
			System.out.println("Clicked on the task tag.");
			ngDriver.waitForAngularRequestsToFinish();

			// click on the new task button
			click("envreportaddedrecord_tasktab_newtaskbtn_XPATH");
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

			// verify newly created task is displayed or not
			switchVerification("envreportaddedrecord_tasktab_addtask_XPATH", "Test Task Environment Module Title",
					"The Test Task Environment Module Title is not displayed.");

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

		// VERIFY NEWLY CREATED TASK UNDER ENVIRONMENTAL REPORT

		System.out.println("***************** VERIFY NEWLY CREATED TASK UNDER ENVIRONMENTAL REPORT *****************");
		test.log(LogStatus.INFO,
				"***************** VERIFY NEWLY CREATED TASK UNDER ENVIRONMENTAL REPORT *****************");
		Reporter.log("***************** VERIFY NEWLY CREATED TASK UNDER ENVIRONMENTAL REPORT *****************");
		log.info("***************** VERIFY NEWLY CREATED TASK UNDER ENVIRONMENTAL REPORT *****************");

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
			switchVerification("envreportaddedrecord_tasktab_addtask1_XPATH", "Test Task Environment Module Title",
					"The Test Task Environment Module Title is not displayed.");

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
			click("envreportaddedrecord_tasktab_addtask1_XPATH");
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
			switchVerification("envreportaddedrecord_tasktab_updatedtask1_XPATH",
					"Update Test Task Environment Module Title",
					"The Update Test Task Environment Module Title is not displayed.");

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
			explicitWaitClickable("envreportoption_XPATH");

			// click on the Environmental Reports option
			click("envreportoption_XPATH");
			System.out.println("Clicked on the Environmental Reports option.");
			ngDriver.waitForAngularRequestsToFinish();
			System.out.println("Navigate to the Environmental Report Screen.");

			// enter the newly created environmental report in the search field
			clear("task_listofchecklist_filterfield_CSS");
			type("task_listofchecklist_filterfield_CSS", data.get("title"));
			System.out.println("Entered the newly created environmental report in the search field.");
			ngDriver.waitForAngularRequestsToFinish();

			// verification of the environmental report is added or not
			switchVerification("envreportaddedrecord_crudtask_XPATH", "Test Title CRUD Environment Report",
					"The Test Title CRUD Environment Report is not displayed successfully.");

			// click on the environmental report
			click("envreportaddedrecord_crudtask_XPATH");
			System.out.println("Clicked on the environmental report.");
			ngDriver.waitForAngularRequestsToFinish();

			// click on the task tab
			click("envreportaddedrecord_tasktab_XPATH");
			System.out.println("Clicked on the task tag.");
			ngDriver.waitForAngularRequestsToFinish();

			// verify updated task is displayed or not
			switchVerification("envreportaddedrecord_tasktab_updatedtask_XPATH",
					"Update Test Task Environment Module Title",
					"The Update Test Task Environment Module Title is not displayed.");

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

			helper.deleteVerification("envreportaddedrecord_tasktab_updatedtask_XPATH",
					"Update Test Task Environment Module Title");

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

			// wait for element
			explicitWaitClickable("envreportmodeldeletebtn_CSS");

			// click on the delete button of the confirmation model
			click("envreportmodeldeletebtn_CSS");
			System.out.println("Clicked on the Delete Button of the confirmation popup model.");
			ngDriver.waitForAngularRequestsToFinish();

			// enter the environmental report in the search field
			clear("task_listofchecklist_filterfield_CSS");
			type("task_listofchecklist_filterfield_CSS", data.get("title"));
			System.out.println("Entered the environmental report in the search field.");
			ngDriver.waitForAngularRequestsToFinish();

			helper.deleteVerification("envreportaddedrecord_crudtask_XPATH", "Test Title CRUD Environment Report");

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

			helper.deleteVerification("envreportaddedrecord_tasktab_updatedtask1_XPATH",
					"Update Test Task Environment Module Title");

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
