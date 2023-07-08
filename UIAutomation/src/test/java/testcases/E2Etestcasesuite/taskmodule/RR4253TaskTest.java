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

public class RR4253TaskTest extends TestBase {

	@Test(dataProviderClass = TestUtil.class, dataProvider = "dp")
	public void rR4253TaskTest(Hashtable<String, String> data) throws IOException, InterruptedException {

		execution(data, "rR4253TaskTest");

		// CRUD OPRATIONS OF THE TASK - ENVIRONMENTAL MODULE
		title("CRUD OPRATIONS OF THE TASK - ENVIRONMENTAL MODULE");

		Helper helper = new Helper();

		// refresh the page
		driver.navigate().refresh();
		explicitWait("taskicon_CSS");
		driver.navigate().refresh();

		// ADD THE TASK
		title("ADD THE TASK");

		try {
			// click on the task icon
			click("taskicon_CSS");

			// click on the add task button
			click("task_addtaskbtn_CSS");

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

			// scroll down the screen
			scrollByPixel(1200);

			// synchronization
			explicitWait("task_addtask_moduledd_CSS");

			// select the environmental option from the module dropdown
			select("task_addtask_moduledd_CSS", data.get("task_module"));

			// scroll down the screen
			scrollByPixel(-1200);

			// synchronization
			explicitWait("task_addtask_purchaseordertab_XPATH");

			// click on the purchase order/warranty tab
			click("task_addtask_purchaseordertab_XPATH");

			// click on the warranty checkbox
			click("questionnaire_purchaseordertab_warrantycheckbox_CSS");

			// click on the po required
			click("questionnaire_purchaseordertab_porequired_CSS");

			// scroll down the screen
			scrollByPixel(400);

			// click on the po approved
			click("questionnaire_purchaseordertab_poapproved_CSS");

			// synchronization
			explicitWait("questionnaire_purchaseordertab_ponumber_CSS");

			// enter the data in the po number field
			type("questionnaire_purchaseordertab_ponumber_CSS", data.get("task_ponumber"));

			// click on the approved to proceed
			click("questionnaire_purchaseordertab_approvedtoproceed_CSS");

			// scroll down the screen
			scrollByPixel(400);

			// synchronization
			explicitWait("questionnaire_purchaseordertab_estimaterequired_CSS");

			// click on the estimate required
			click("questionnaire_purchaseordertab_estimaterequired_CSS");

			// enter the estimated amount in the field
			type("questionnaire_purchaseordertab_estimateamount_CSS", "1122");

			// click on the save button
			click("survey_task_savebtn_CSS");

			// scroll up the screen
			scrollByPixel(-500);

			// click on the clear button
			click("task_createdtask_clearbtn_XPATH");

			// enter the data in the search field
			type("task_filter_CSS", data.get("task_title"));

			// click on the search button
			click("task_createdtask_searchbtn_XPATH");

			// verify newly created task is displayed or not
			switchVerification("task_createdtask_environmental_XPATH", "Test Task Environmental Module Title",
					"The Test Task Environmental Module Title is not displayed.");

		} catch (Throwable t) {
			verificationFailed();
		}

		// UPDATE THE TASK
		title("UPDATE THE TASK");

		try {

			// click on the newly created task
			click("task_createdtask_environmental_XPATH");

			// update the title of the task
			type("task_addtask_titletxt_CSS", data.get("update_task_title"));

			// click on the update button
			click("survey_task_updatebtn_CSS");

			// wait for the element
			explicitWaitClickable("closetoastmsg_CSS");

			// click on the toaster close button
			click("closetoastmsg_CSS");

			// scroll up the screen
			scrollByPixel(-500);

			// click on the clear button
			click("task_createdtask_clearbtn_XPATH");

			// enter the data in the search field
			type("task_filter_CSS", data.get("update_task_title"));

			// click on the search button
			click("task_createdtask_searchbtn_XPATH");

			// verify newly created task is displayed or not
			switchVerification("task_updatedtask_environmental_XPATH", "Update Test Task Environmental Module Title",
					"The Update Test Task Environmental Module Title is not displayed.");

		} catch (Throwable t) {
			verificationFailed();
		}

		// DELETE THE TASK
		title("DELETE THE TASK");

		try {
			// click on the newly created task
			click("task_updatedtask_environmental_XPATH");

			// click on the delete button
			click("task_deletedtaskbtn_CSS");

			// synchronization
			explicitWait("task_deletedtaskbtn_confirmaiton_CSS");

			// click on the delete button of the confirmation popup
			click("task_deletedtaskbtn_confirmaiton_CSS");

			// scroll up the screen
			scrollByPixel(-500);

			// click on the clear button
			click("task_createdtask_clearbtn_XPATH");

			// enter the data in the search field
			type("task_filter_CSS", data.get("update_task_title"));

			// click on the search button
			click("task_createdtask_searchbtn_XPATH");

			// verify the questionnaire deleted or not
			helper.deleteVerification("task_updatedtask_environmental_XPATH",
					"Update Test Task Environmental Module Title");

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