package testcases.E2Etestcasesuite.taskmodule;

import java.io.IOException;
import java.util.Hashtable;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.testng.Reporter;
import org.testng.SkipException;
import org.testng.annotations.Test;

import com.relevantcodes.extentreports.LogStatus;

import base.Helper;
import base.TestBase;
import utilities.TestUtil;

public class RR4740TaskTest extends TestBase {

	@Test(dataProviderClass = TestUtil.class, dataProvider = "dp")
	public void rR4740TaskTest(Hashtable<String, String> data) throws IOException, InterruptedException {

		execution(data, "rR4740TaskTest");

		// NAVIGATION TO TASK MODULE FROM PROPERTY LIST AND PROPERTY SUMMARY SCREEN AND
		// BROWSER BACK BUTTON MUST OPEN THE RESPECTIVE PREVIOUS PAGE.
		title("NAVIGATION TO TASK MODULE FROM PROPERTY LIST AND PROPERTY SUMMARY SCREEN AND BROWSER BACK BUTTON MUST OPEN THE RESPECTIVE PREVIOUS PAGE.");

		Helper helper = new Helper();

		// refresh the page
		driver.navigate().refresh();
		Thread.sleep(5000);
		driver.navigate().refresh();

		// ADD THE NEW TASK
		title("ADD THE NEW TASK");

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

			// wait for the element
			explicitWaitClickable("questionnaire_purchaseordertab_porequired_CSS");

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
			switchVerification("task_navigationtask11_XPATH", "Test Task Navigation One Title",
					"The Test Task Navigation One Title is not displayed.");

		} catch (Throwable t) {
			verificationFailed();
		}

		// click on the home icon from the top of the screen
		click("questionnaire_homeburgermenubtn_hide_CSS");

		// synchronization
		explicitWait("propertylist_title_XPATH");

		// verify the property list
		switchVerification("propertylist_title_XPATH", "Property List", "The property list is not displayed.");

		// VERIFY NAVIGATION FROM THE TASK DETAILS SCREEN TO THE TASK LISTING SCREEN
		// THROUGH THE APPLICATION BACK BUTTOM - VIA TASK MODULE
		title("VERIFY NAVIGATION FROM THE TASK DETAILS SCREEN TO THE TASK LISTING SCREEN THROUGH THE APPLICATION BACK BUTTOM - VIA TASK MODULE");

		try {
			// click on the task icon
			click("taskicon_CSS");

			// click on the clear button
			click("task_createdtask_clearbtn_XPATH");

			// enter the data in the search field
			type("task_filter_CSS", data.get("task_title"));

			// click on the search button
			click("task_createdtask_searchbtn_XPATH");

			// verify newly created task is displayed or not
			switchVerification("task_navigationtask11_XPATH", "Test Task Navigation One Title",
					"The Test Task Navigation One Title is not displayed.");

			// click on the newly created task
			click("task_navigationtask11_XPATH");

			// wait for 3 seconds
			Thread.sleep(3000);

			// verify task details screen is displayed or not
			switchVerification("task_navigation_titletxt_XPATH", "Task Details", "The Task Details is not displayed.");

			// click on the application's back button of the application
			click("task_navigation_appbackbtn_CSS");

			// wait for 3 seconds
			Thread.sleep(3000);

			// verify newly created task is displayed or not
			switchVerification("task_navigationtask11_XPATH", "Test Task Navigation One Title",
					"The Test Task Navigation One Title is not displayed.");

		} catch (Throwable t) {
			verificationFailed();

		}

		// click on the home icon from the top of the screen
		click("questionnaire_homeburgermenubtn_hide_CSS");

		// synchronization
		explicitWait("propertylist_title_XPATH");

		// verify the property list
		switchVerification("propertylist_title_XPATH", "Property List", "The property list is not displayed.");

		// VERIFY NAVIGATION FROM THE TASK DETAILS SCREEN TO THE TASK LISTING SCREEN
		// THROUGH THE BROWSER BACK BUTTOM - VIA TASK MODULE
		title("VERIFY NAVIGATION FROM THE TASK DETAILS SCREEN TO THE TASK LISTING SCREEN THROUGH THE BROWSER BACK BUTTOM - VIA TASK MODULE");

		try {

			// click on the task icon
			click("taskicon_CSS");

			// click on the clear button
			click("task_createdtask_clearbtn_XPATH");

			// enter the data in the search field
			type("task_filter_CSS", data.get("task_title"));

			// click on the search button
			click("task_createdtask_searchbtn_XPATH");

			// verify newly created task is displayed or not
			switchVerification("task_navigationtask11_XPATH", "Test Task Navigation One Title",
					"The Test Task Navigation One Title is not displayed.");

			// click on the newly created task
			click("task_navigationtask11_XPATH");

			// wait for 3 seconds
			Thread.sleep(3000);

			// verify task details screen is displayed or not
			switchVerification("task_navigation_titletxt_XPATH", "Task Details", "The Task Details is not displayed.");

			// click on the browser back button
			driver.navigate().back();

			// wait for 3 seconds
			Thread.sleep(3000);

			// verify newly created task is displayed or not
			switchVerification("task_navigationtask11_XPATH", "Test Task Navigation One Title",
					"The Test Task Navigation One Title is not displayed.");

		} catch (Throwable t) {
			verificationFailed();

		}

		// click on the home icon from the top of the screen
		click("questionnaire_homeburgermenubtn_hide_CSS");

		// synchronization
		explicitWait("propertylist_title_XPATH");

		// verify the property list
		switchVerification("propertylist_title_XPATH", "Property List", "The property list is not displayed.");

		// VERIFY NAVIGATION FROM THE TASK DETAILS SCREEN TO THE TASK LISTING SCREEN
		// THROUGH THE APPLICATION BACK BUTTON - VIA PROPERTY SUMMARY SCREEN > TASK
		// MODULE
		title("VERIFY NAVIGATION FROM THE TASK DETAILS SCREEN TO THE TASK LISTING SCREEN THROUGH THE APPLICATION BACK BUTTON - VIA PROPERTY SUMMARY SCREEN > TASK MODULE");

		try {
			// click on the first property
			click("task_navigation_property1_CSS");

			// wait for 3 seconds
			Thread.sleep(3000);

			// click on the task icon of the property summary screen
			click("task_navigation_propertydetailstskicon_CSS");

			// click on the clear button
			click("task_createdtask_clearbtn_XPATH");

			// enter the data in the search field
			type("task_filter_CSS", data.get("task_title"));

			// click on the search button
			click("task_createdtask_searchbtn_XPATH");

			// verify newly created task is displayed or not
			switchVerification("task_navigationtask11_XPATH", "Test Task Navigation One Title",
					"The Test Task Navigation One Title is not displayed.");

		} catch (Throwable t) {
			verificationFailed();
		}

		// click on the home icon from the top of the screen
		click("questionnaire_homeburgermenubtn_hide_CSS");

		// synchronization
		explicitWait("propertylist_title_XPATH");

		// verify the property list
		switchVerification("propertylist_title_XPATH", "Property List", "The property list is not displayed.");

		// VERIFY APPLICATION BACK BUTTOM FROM TASK DETAILS SCREEN
		title("VERIFY APPLICATION BACK BUTTOM FROM TASK DETAILS SCREEN");

		try {

			// click on the task icon
			click("taskicon_CSS");

			// click on the clear button
			click("task_createdtask_clearbtn_XPATH");

			// enter the data in the search field
			type("task_filter_CSS", data.get("task_title"));

			// click on the search button
			click("task_createdtask_searchbtn_XPATH");

			// verify newly created task is displayed or not
			switchVerification("task_navigationtask11_XPATH", "Test Task Navigation One Title",
					"The Test Task Navigation One Title is not displayed.");

			// click on the newly created task
			click("task_navigationtask11_XPATH");

			// wait for 3 seconds
			Thread.sleep(3000);

			// verify task details screen is displayed or not
			switchVerification("task_navigation_titletxt_XPATH", "Task Details", "The Task Details is not displayed.");

			// click on the back button of the application
			click("task_navigation_appbackbtn_CSS");

			// wait for 3 seconds
			Thread.sleep(3000);

			// verify newly created task is displayed or not
			switchVerification("task_navigationtask11_XPATH", "Test Task Navigation One Title",
					"The Test Task Navigation One Title is not displayed.");

		} catch (Throwable t) {
			verificationFailed();
		}

		// click on the home icon from the top of the screen
		click("questionnaire_homeburgermenubtn_hide_CSS");

		// synchronization
		explicitWait("propertylist_title_XPATH");

		// verify the property list
		switchVerification("propertylist_title_XPATH", "Property List", "The property list is not displayed.");

		// VERIFY NAVIGATION FROM THE TASK DETAILS SCREEN TO THE TASK LISTING SCREEN
		// THROUGH THE BROWSER BACK BUTTON - VIA PROPERTY SUMMARY SCREEN > TASK MODULE
		title("VERIFY NAVIGATION FROM THE TASK DETAILS SCREEN TO THE TASK LISTING SCREEN THROUGH THE BROWSER BACK BUTTON - VIA PROPERTY SUMMARY SCREEN > TASK MODULE");

		try {

			// click on the task icon
			click("taskicon_CSS");

			// click on the clear button
			click("task_createdtask_clearbtn_XPATH");

			// enter the data in the search field
			type("task_filter_CSS", data.get("task_title"));

			// click on the search button
			click("task_createdtask_searchbtn_XPATH");

			// verify newly created task is displayed or not
			switchVerification("task_navigationtask11_XPATH", "Test Task Navigation One Title",
					"The Test Task Navigation One Title is not displayed.");

			// click on the newly created task
			click("task_navigationtask11_XPATH");

			// wait for 3 seconds
			Thread.sleep(3000);

			// verify task details screen is displayed or not
			switchVerification("task_navigation_titletxt_XPATH", "Task Details", "The Task Details is not displayed.");

			// click on the browser back button
			driver.navigate().back();
			consoleMessage("Clicked on the browser back button.");

			// wait for 3 seconds
			Thread.sleep(3000);

			// verify newly created task is displayed or not
			switchVerification("task_navigationtask11_XPATH", "Test Task Navigation One Title",
					"The Test Task Navigation One Title is not displayed.");

		} catch (Throwable t) {
			verificationFailed();

		}

		// click on the home icon from the top of the screen
		click("questionnaire_homeburgermenubtn_hide_CSS");

		// synchronization
		explicitWait("propertylist_title_XPATH");

		// verify the property list
		switchVerification("propertylist_title_XPATH", "Property List", "The property list is not displayed.");

		// VERIFY NAVIGATION FROM THE TASK LISTING SCREEN TO THE PROPERTY SUMMARY SCREEN
		// THROUGH THE BACK TO DASHBOARD BUTTON - VIA TASKS SECTION OF PROPERTY SUMMARY
		// SCREEN
		title("VERIFY NAVIGATION FROM THE TASK LISTING SCREEN TO THE PROPERTY SUMMARY SCREEN THROUGH THE BACK TO DASHBOARD BUTTON - VIA TASKS SECTION OF PROPERTY SUMMARY SCREEN");

		try {
			// click on the first property
			click("task_navigation_property1_CSS");

			// wait for 3 seconds
			Thread.sleep(3000);

			// scroll till task section
			scrollTillElement("task_navigation_tasklbl_XPATH");

			// click on the active task count
			click("task_navigation_activetasklink_XPATH");

			// click on the clear button
			click("task_createdtask_clearbtn_XPATH");

			// enter the data in the search field
			type("task_filter_CSS", data.get("task_title"));

			// click on the search button
			click("task_createdtask_searchbtn_XPATH");

			// verify newly created task is displayed or not
			switchVerification("task_navigationtask11_XPATH", "Test Task Navigation One Title",
					"The Test Task Navigation One Title is not displayed.");

			// click on the back to dashboard screen
			click("task_navigation_backtodashboardbtn_CSS");

			// wait for the element
			explicitWait("task_navigation_tasklbl_XPATH");

			// scroll till task section
			scrollTillElement("task_navigation_tasklbl_XPATH");

			// verify task section is displayed or not
			switchVerification("task_navigation_tasklbl_XPATH", "Tasks", "The tasks section is not displayed.");

		} catch (Throwable t) {
			verificationFailed();
		}

		// click on the home icon from the top of the screen
		click("questionnaire_homeburgermenubtn_hide_CSS");

		// synchronization
		explicitWait("propertylist_title_XPATH");

		// verify the property list
		switchVerification("propertylist_title_XPATH", "Property List", "The property list is not displayed.");

		// VERIFY NAVIGATION FROM THE TASK LISTING SCREEN TO THE PROPERTY SUMMARY SCREEN
		// THROUGH THE BROWSER BACK BUTTON - VIA TASKS SECTION OF PROPERTY SUMMARY
		// SCREEN
		title("VERIFY NAVIGATION FROM THE TASK LISTING SCREEN TO THE PROPERTY SUMMARY SCREEN THROUGH THE BROWSER BACK BUTTON - VIA TASKS SECTION OF PROPERTY SUMMARY SCREEN");

		try {
			// click on the first property
			click("task_navigation_property1_CSS");

			// wait for 3 seconds
			Thread.sleep(3000);

			// scroll till task section
			scrollTillElement("task_navigation_tasklbl_XPATH");

			// click on the active task count
			click("task_navigation_activetasklink_XPATH");

			// click on the clear button
			click("task_createdtask_clearbtn_XPATH");

			// enter the data in the search field
			type("task_filter_CSS", data.get("task_title"));

			// click on the search button
			click("task_createdtask_searchbtn_XPATH");

			// verify newly created task is displayed or not
			switchVerification("task_navigationtask11_XPATH", "Test Task Navigation One Title",
					"The Test Task Navigation One Title is not displayed.");

			// wait for 3 seconds
			Thread.sleep(3000);

			// navigate to the back from the browser back button
			driver.navigate().back();

			// wait for 3 seconds
			Thread.sleep(3000);

			// scroll till task section
			scrollTillElement("task_navigation_tasklbl_XPATH");

			// verify task section is displayed or not
			switchVerification("task_navigation_tasklbl_XPATH", "Tasks", "The tasks section is not displayed.");

		} catch (Throwable t) {

			verificationFailed();

		}

		// click on the home icon from the top of the screen
		click("questionnaire_homeburgermenubtn_hide_CSS");

		// synchronization
		explicitWait("propertylist_title_XPATH");

		// verify the property list
		switchVerification("propertylist_title_XPATH", "Property List", "The property list is not displayed.");

		// VERIFY NAVIGATION FROM THE TASK DETAILS SCREEN TO THE PROPERTY SUMMARY SCREEN
		// THROUGH THE BACK TO DASHBOARD BUTTON - VIA TASKS SECTION OF PROPERTY SUMMARY
		// SCREEN
		title("VERIFY NAVIGATION FROM THE TASK DETAILS SCREEN TO THE PROPERTY SUMMARY SCREEN THROUGH THE BACK TO DASHBOARD BUTTON - VIA TASKS SECTION OF PROPERTY SUMMARY SCREEN");

		try {
			// click on the first property
			click("task_navigation_property1_CSS");

			// wait for 3 seconds
			Thread.sleep(3000);

			// scroll till task section
			scrollTillElement("task_navigation_tasklbl_XPATH");

			// click on the active task count
			click("task_navigation_activetasklink_XPATH");

			// click on the clear button
			click("task_createdtask_clearbtn_XPATH");

			// enter the data in the search field
			type("task_filter_CSS", data.get("task_title"));

			// click on the search button
			click("task_createdtask_searchbtn_XPATH");

			// verify newly created task is displayed or not
			switchVerification("task_navigationtask11_XPATH", "Test Task Navigation One Title",
					"The Test Task Navigation One Title is not displayed.");

			// click on the task to open the task details
			click("task_navigationtask11_XPATH");

			// wait for 3 seconds
			Thread.sleep(3000);

			// verify task details screen is displayed or not
			switchVerification("task_navigation_titletxt_XPATH", "Task Details", "The Task Details is not displayed.");

			// click on the back to dashboard screen
			click("task_navigation_backtodashboardbtn_CSS");

			// wait for the element
			Thread.sleep(5000);

			// scroll till task section
			scrollTillElement("task_navigation_tasklbl_XPATH");

			// verify task section is displayed or not
			switchVerification("task_navigation_tasklbl_XPATH", "Tasks", "The tasks section is not displayed.");

		} catch (Throwable t) {

			verificationFailed();

		}

		// click on the home icon from the top of the screen
		click("questionnaire_homeburgermenubtn_hide_CSS");

		// synchronization
		explicitWait("propertylist_title_XPATH");

		// verify the property list
		switchVerification("propertylist_title_XPATH", "Property List", "The property list is not displayed.");

		// VERIFY NAVIGATION FROM THE TASK DETAILS SCREEN TO THE TASK LISTING SCREEN
		// THROUGH THE BROWSER BACK BUTTON - VIA TASKS SECTION OF PROPERTY SUMMARY
		// SCREEN
		title("VERIFY NAVIGATION FROM THE TASK DETAILS SCREEN TO THE TASK LISTING SCREEN THROUGH THE BROWSER BACK BUTTON - VIA TASKS SECTION OF PROPERTY SUMMARY SCREEN");

		try {
			// click on the first property
			click("task_navigation_property1_CSS");

			// wait for 3 seconds
			Thread.sleep(3000);

			// scroll till task section
			scrollTillElement("task_navigation_tasklbl_XPATH");

			// click on the active task count
			click("task_navigation_activetasklink_XPATH");

			// click on the clear button
			click("task_createdtask_clearbtn_XPATH");

			// enter the data in the search field
			type("task_filter_CSS", data.get("task_title"));

			// click on the search button
			click("task_createdtask_searchbtn_XPATH");

			// click on the task to open the task details
			click("task_navigationtask11_XPATH");

			// wait for 3 seconds
			Thread.sleep(3000);

			// verify task details screen is displayed or not
			switchVerification("task_navigation_titletxt_XPATH", "Task Details", "The Task Details is not displayed.");

			// navigate to the back from the browser back button
			driver.navigate().back();

			// click on the clear button
			click("task_createdtask_clearbtn_XPATH");

			// enter the data in the search field
			type("task_filter_CSS", data.get("task_title"));

			// click on the search button
			click("task_createdtask_searchbtn_XPATH");

			// verify newly created task is displayed or not
			switchVerification("task_navigationtask11_XPATH", "Test Task Navigation One Title",
					"The Test Task Navigation One Title is not displayed.");

			// navigate to the back from the browser back button
			driver.navigate().back();

			// scroll till task section
			scrollTillElement("task_navigation_tasklbl_XPATH");

			// verify task section is displayed or not
			switchVerification("task_navigation_tasklbl_XPATH", "Tasks", "The tasks section is not displayed.");

		} catch (Throwable t) {

			verificationFailed();

		}

		// click on the home icon from the top of the screen
		click("questionnaire_homeburgermenubtn_hide_CSS");

		// synchronization
		explicitWait("propertylist_title_XPATH");

		// verify the property list
		switchVerification("propertylist_title_XPATH", "Property List", "The property list is not displayed.");

		// DELETE THE TASK
		title("DELETE THE TASK");

		try {
			// click on the task icon
			click("taskicon_CSS");

			// scroll up the screen

			scrollByPixel(-500);

			// click on the clear button
			click("task_createdtask_clearbtn_XPATH");

			// enter the data in the search field
			type("task_filter_CSS", data.get("task_title"));

			// click on the search button
			click("task_createdtask_searchbtn_XPATH");

			// verify newly created task is displayed or not
			switchVerification("task_navigationtask11_XPATH", "Test Task Navigation One Title",
					"The Test Task Navigation One Title is not displayed.");

			// click on the newly created task
			click("task_navigationtask11_XPATH");

			// wait for element
			explicitWaitClickable("task_deletedtaskbtn_CSS");

			// click on the delete button
			click("task_deletedtaskbtn_CSS");

			// wait for element
			explicitWaitClickable("task_deletedtaskbtn_confirmaiton_CSS");

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