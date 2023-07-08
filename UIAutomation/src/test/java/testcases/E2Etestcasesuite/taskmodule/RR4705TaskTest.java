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
		title("CRUD OPERATION OF THE TASK OF THE ENVIRONMENTAL REPORT");

		Helper helper = new Helper();

		// refresh the page
		driver.navigate().refresh();
		Thread.sleep(5000);
		driver.navigate().refresh();

		// CREATE ENVIRONMENTAL REPORTS
		title("CREATE ENVIRONMENTAL REPORTS");

		try {
			// click on the environmental icon from the property list page
			click("environmentalicon_CSS");

			// click on the burger menu
			click("menubtn_CSS");

			// wait for the element
			explicitWaitClickable("envreportoption_XPATH");

			// click on the Environmental Reports option
			click("envreportoption_XPATH");

			// click on the Add report button
			click("envreportaddbtn_CSS");

			// select the checklist from the type dropdown
			select("envreporttypedd_CSS", data.get("type"));

			// enter the title
			type("envreporttitletxt_CSS", data.get("title"));

			// click on the date field
			click("envreportdatetxt_CSS");

			click("envreporttodaydate_BTNTEXT");

			// enter the company
			type("envreportcompanytxt_CSS", data.get("company"));

			// enter the author
			type("envreportauthortxt_CSS", data.get("author"));

			// enter the description
			type("envreportdescriptiontxt_CSS", data.get("description"));

			// click on the save button
			click("envreportsavebtn_BTNTEXT");

			// wait for the element
			explicitWaitClickable("closetoastmsg_CSS");

			// click on the toaster close button
			click("closetoastmsg_CSS");

			// enter the newly created environmental report in the search field
			type("task_listofchecklist_filterfield_CSS", data.get("title"));

			// verification of the environmental report is added or not
			switchVerification("envreportaddedrecord_crudtask_XPATH", "Test Title CRUD Environment Report",
					"The Test Task Environment Module Title is not displayed successfully.");

		} catch (Throwable t) {
			verificationFailed();
		}

		// ADD THE TASK IN THE NEWLY CREATED ENVIRONMENTAL REPORTS
		title("ADD THE TASK IN THE NEWLY CREATED ENVIRONMENTAL REPORTS");

		try {
			// click on the added environmental record
			click("envreportaddedrecord_crudtask_XPATH");

			// click on the task tab
			click("envreportaddedrecord_tasktab_XPATH");

			// click on the new task button
			click("envreportaddedrecord_tasktab_newtaskbtn_XPATH");

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
			click("survey_task_savebtn_CSS");

			// verify newly created task is displayed or not
			switchVerification("envreportaddedrecord_tasktab_addtask_XPATH", "Test Task Environment Module Title",
					"The Test Task Environment Module Title is not displayed.");

		} catch (Throwable t) {
			verificationFailed();
		}

		// click on the home icon from the top of the screen
		click("questionnaire_homeburgermenubtn_hide_CSS");

		// synchronization
		explicitWait("propertylist_title_XPATH");

		// verify the property list
		switchVerification("propertylist_title_XPATH", "Property List", "The property list is not displayed.");

		// VERIFY NEWLY CREATED TASK UNDER ENVIRONMENTAL REPORT
		title("VERIFY NEWLY CREATED TASK UNDER ENVIRONMENTAL REPORT");

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
			switchVerification("envreportaddedrecord_tasktab_addtask1_XPATH", "Test Task Environment Module Title",
					"The Test Task Environment Module Title is not displayed.");

		} catch (Throwable t) {
			verificationFailed();
		}

		// UPDATE THE NEWLT CREATED TASK IN TASK MODULE
		title("UPDATE THE NEWLT CREATED TASK IN TASK MODULE");

		try {
			// click on the newly created task
			click("envreportaddedrecord_tasktab_addtask1_XPATH");

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
			switchVerification("envreportaddedrecord_tasktab_updatedtask1_XPATH",
					"Update Test Task Environment Module Title",
					"The Update Test Task Environment Module Title is not displayed.");

		} catch (Throwable t) {
			verificationFailed();
		}

		// click on the home icon from the top of the screen
		click("questionnaire_homeburgermenubtn_hide_CSS");

		// synchronization
		explicitWait("propertylist_title_XPATH");

		// verify the property list
		switchVerification("propertylist_title_XPATH", "Property List", "The property list is not displayed.");

		// DELETE THE NEWLY CREATED TASK - ENVIRONMENTAL REPORT
		title("DELETE THE NEWLY CREATED TASK - ENVIRONMENTAL REPORT");

		try {
			// click on the environmental icon from the property list page
			click("environmentalicon_CSS");

			// wait for element
			explicitWaitClickable("menubtn_CSS");

			// click on the burger menu
			click("menubtn_CSS");

			// wait for element
			explicitWaitClickable("envreportoption_XPATH");

			// click on the Environmental Reports option
			click("envreportoption_XPATH");

			// enter the newly created environmental report in the search field
			type("task_listofchecklist_filterfield_CSS", data.get("title"));

			// verification of the environmental report is added or not
			switchVerification("envreportaddedrecord_crudtask_XPATH", "Test Title CRUD Environment Report",
					"The Test Title CRUD Environment Report is not displayed successfully.");

			// click on the environmental report
			click("envreportaddedrecord_crudtask_XPATH");

			// click on the task tab
			click("envreportaddedrecord_tasktab_XPATH");

			// verify updated task is displayed or not
			switchVerification("envreportaddedrecord_tasktab_updatedtask_XPATH",
					"Update Test Task Environment Module Title",
					"The Update Test Task Environment Module Title is not displayed.");

			// click on the action icon
			String action1 = "//td[text()='" + data.get("update_task_title")
					+ "']//following-sibling::td[@class='text-center pointer']//div[@class='dropdown']//i[@data-toggle='dropdown']";
			driver.findElement(By.xpath(action1)).click();

			// click on the delete option
			String deleteOption1 = "//td[text()='" + data.get("update_task_title")
					+ "']//following-sibling::td[@class='text-center pointer']//div[@class='dropdown open']//li[@ng-click='deleteSelectedTask(task.id, true);']";
			driver.findElement(By.xpath(deleteOption1)).click();

			// wait for the element
			explicitWaitClickable("closetoastmsg_CSS");

			// click on the toaster close button
			click("closetoastmsg_CSS");

			// verify the questionnaire deleted or not
			helper.deleteVerification("envreportaddedrecord_tasktab_updatedtask_XPATH",
					"Update Test Task Environment Module Title");

		} catch (Throwable t) {
			verificationFailed();
		}

		// DELETE THE ENVIRONMENTAL REPORT
		title("DELETE THE ENVIRONMENTAL REPORT");

		try {

			// wait for element
			explicitWaitClickable("envreportdeletebtn_CSS");

			// click on the delete button
			click("envreportdeletebtn_CSS");

			// wait for element
			explicitWaitClickable("envreportmodeldeletebtn_CSS");

			// click on the delete button of the confirmation model
			click("envreportmodeldeletebtn_CSS");

			// enter the environmental report in the search field
			type("task_listofchecklist_filterfield_CSS", data.get("title"));

			helper.deleteVerification("envreportaddedrecord_crudtask_XPATH", "Test Title CRUD Environment Report");

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

			helper.deleteVerification("envreportaddedrecord_tasktab_updatedtask1_XPATH",
					"Update Test Task Environment Module Title");

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