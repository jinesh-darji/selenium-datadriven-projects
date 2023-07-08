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

		System.out.println("CRUD OPRATIONS OF THE TASK - ENVIRONMENTAL MODULE.");
		test.log(LogStatus.INFO, "CRUD OPRATIONS OF THE TASK - ENVIRONMENTAL MODULE.");
		Reporter.log("CRUD OPRATIONS OF THE TASK - ENVIRONMENTAL MODULE.");
		log.info("CRUD OPRATIONS OF THE TASK - ENVIRONMENTAL MODULE.");

		Helper helper = new Helper();

		// refresh the page
		driver.navigate().refresh();
		explicitWait("taskicon_CSS");
		driver.navigate().refresh();

		System.out.println("Navigate to the Home Screen i.e. Property List Screen.");

		// ADD THE TASK

		System.out.println("***************** ADD THE TASK *****************");
		test.log(LogStatus.INFO, "***************** ADD THE TASK *****************");
		Reporter.log("***************** ADD THE TASK *****************");
		log.info("***************** ADD THE TASK *****************");

		try {
			// click on the task icon
			click("taskicon_CSS");
			System.out.println("Clicked on the task icon.");
			ngDriver.waitForAngularRequestsToFinish();

			// click on the add task button
			click("task_addtaskbtn_CSS");
			System.out.println("Clicked on the add task button.");
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

			// scroll down the screen
			JavascriptExecutor js = (JavascriptExecutor) driver;
			js.executeScript("window.scrollBy(0,1200)");

			// synchronization
			explicitWait("task_addtask_moduledd_CSS");

			// select the environmental option from the module dropdown
			select("task_addtask_moduledd_CSS", data.get("task_module"));
			System.out.println("Selected the environmental option from the module dropdown.");
			ngDriver.waitForAngularRequestsToFinish();

			// scroll down the screen
			js.executeScript("window.scrollBy(0,-1200)");

			// synchronization
			explicitWait("task_addtask_purchaseordertab_XPATH");

			// click on the purchase order/warranty tab
			click("task_addtask_purchaseordertab_XPATH");
			System.out.println("Clicked on the purchase order/warranty tab.");
			ngDriver.waitForAngularRequestsToFinish();

			// click on the warranty checkbox
			click("questionnaire_purchaseordertab_warrantycheckbox_CSS");
			System.out.println("Clicked on the warranty checkbox.");
			ngDriver.waitForAngularRequestsToFinish();

			// click on the po required
			click("questionnaire_purchaseordertab_porequired_CSS");
			System.out.println("Clicked on the po required checkbox.");
			ngDriver.waitForAngularRequestsToFinish();

			// scroll down the screen
			js.executeScript("window.scrollBy(0,400)");

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

			// scroll down the screen
			js.executeScript("window.scrollBy(0,400)");

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
			click("survey_task_savebtn_CSS");
			System.out.println("Clicked on the save button.");
			ngDriver.waitForAngularRequestsToFinish();

			// scroll up the screen
			js.executeScript("window.scrollBy(0,-500)");

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
			switchVerification("task_createdtask_environmental_XPATH", "Test Task Environmental Module Title",
					"The Test Task Environmental Module Title is not displayed.");

		} catch (Throwable t) {
			verificationFailed();
		}

		// UPDATE THE TASK

		System.out.println("***************** UPDATE THE TASK *****************");
		test.log(LogStatus.INFO, "***************** UPDATE THE TASK *****************");
		Reporter.log("***************** UPDATE THE TASK *****************");
		log.info("***************** UPDATE THE TASK *****************");

		try {

			// click on the newly created task
			click("task_createdtask_environmental_XPATH");
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

			// wait for the element
			explicitWaitClickable("closetoastmsg_CSS");

			// click on the toaster close button
			click("closetoastmsg_CSS");
			ngDriver.waitForAngularRequestsToFinish();
			System.out.println("Clicked on the toaster close button.");

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
			switchVerification("task_updatedtask_environmental_XPATH", "Update Test Task Environmental Module Title",
					"The Update Test Task Environmental Module Title is not displayed.");

		} catch (Throwable t) {
			verificationFailed();
		}

		// DELETE THE TASK

		System.out.println("***************** DELETE THE TASK *****************");
		test.log(LogStatus.INFO, "***************** DELETE THE TASK *****************");
		Reporter.log("***************** DELETE THE TASK *****************");
		log.info("***************** DELETE THE TASK *****************");

		try {
			// click on the newly created task
			click("task_updatedtask_environmental_XPATH");
			System.out.println("Click on the updated task.");
			ngDriver.waitForAngularRequestsToFinish();

			// click on the delete button
			click("task_deletedtaskbtn_CSS");
			System.out.println("Clicked on the delete button.");
			ngDriver.waitForAngularRequestsToFinish();

			// synchronization
			explicitWait("task_deletedtaskbtn_confirmaiton_CSS");

			// click on the delete button of the confirmation popup
			click("task_deletedtaskbtn_confirmaiton_CSS");
			System.out.println("Clicked on the delete button of the confirmation popup.");
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

			// verify the questionnaire deleted or not

			helper.deleteVerification("task_updatedtask_environmental_XPATH",
					"Update Test Task Environmental Module Title");

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
