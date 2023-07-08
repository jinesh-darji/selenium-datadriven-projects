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

		System.out.println(
				"NAVIGATION TO TASK MODULE FROM PROPERTY LIST AND PROPERTY SUMMARY SCREEN AND BROWSER BACK BUTTON MUST OPEN THE RESPECTIVE PREVIOUS PAGE.");
		test.log(LogStatus.INFO,
				"NAVIGATION TO TASK MODULE FROM PROPERTY LIST AND PROPERTY SUMMARY SCREEN AND BROWSER BACK BUTTON MUST OPEN THE RESPECTIVE PREVIOUS PAGE.");
		Reporter.log(
				"NAVIGATION TO TASK MODULE FROM PROPERTY LIST AND PROPERTY SUMMARY SCREEN AND BROWSER BACK BUTTON MUST OPEN THE RESPECTIVE PREVIOUS PAGE.");
		log.info(
				"NAVIGATION TO TASK MODULE FROM PROPERTY LIST AND PROPERTY SUMMARY SCREEN AND BROWSER BACK BUTTON MUST OPEN THE RESPECTIVE PREVIOUS PAGE.");

		Helper helper = new Helper();

		// refresh the page
		driver.navigate().refresh();
		Thread.sleep(5000);
		driver.navigate().refresh();

		System.out.println("Navigate to the Home Screen i.e. Property List Screen.");

		// ADD THE NEW TASK

		System.out.println("***************** ADD THE NEW TASK *****************");
		test.log(LogStatus.INFO, "***************** ADD THE NEW TASK *****************");
		Reporter.log("***************** ADD THE NEW TASK *****************");
		log.info("***************** ADD THE NEW TASK *****************");

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

			// wait for the element
			explicitWaitClickable("questionnaire_purchaseordertab_porequired_CSS");

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
			switchVerification("task_navigationtask11_XPATH", "Test Task Navigation One Title",
					"The Test Task Navigation One Title is not displayed.");

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

		// VERIFY NAVIGATION FROM THE TASK DETAILS SCREEN TO THE TASK LISTING SCREEN
		// THROUGH THE APPLICATION BACK BUTTOM - VIA TASK MODULE

		System.out.println(
				"***************** VERIFY NAVIGATION FROM THE TASK DETAILS SCREEN TO THE TASK LISTING SCREEN THROUGH THE APPLICATION BACK BUTTOM - VIA TASK MODULE *****************");
		test.log(LogStatus.INFO,
				"***************** VERIFY NAVIGATION FROM THE TASK DETAILS SCREEN TO THE TASK LISTING SCREEN THROUGH THE APPLICATION BACK BUTTOM - VIA TASK MODULE *****************");
		Reporter.log(
				"***************** VERIFY NAVIGATION FROM THE TASK DETAILS SCREEN TO THE TASK LISTING SCREEN THROUGH THE APPLICATION BACK BUTTOM - VIA TASK MODULE *****************");
		log.info(
				"***************** VERIFY NAVIGATION FROM THE TASK DETAILS SCREEN TO THE TASK LISTING SCREEN THROUGH THE APPLICATION BACK BUTTOM - VIA TASK MODULE *****************");

		try {
			// click on the task icon
			click("taskicon_CSS");
			ngDriver.waitForAngularRequestsToFinish();
			System.out.println("Clicked on the task icon.");

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
			switchVerification("task_navigationtask11_XPATH", "Test Task Navigation One Title",
					"The Test Task Navigation One Title is not displayed.");

			// click on the newly created task
			click("task_navigationtask11_XPATH");
			System.out.println("Click on the newly created task.");
			ngDriver.waitForAngularRequestsToFinish();

			// wait for 3 seconds
			Thread.sleep(3000);

			// verify task details screen is displayed or not
			switchVerification("task_navigation_titletxt_XPATH", "Task Details", "The Task Details is not displayed.");

			// click on the application's back button of the application
			click("task_navigation_appbackbtn_CSS");
			System.out.println("Clicked on the back button of the application.");
			ngDriver.waitForAngularRequestsToFinish();

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
		System.out.println("Clicked on the home icon from the top of the screen.");
		ngDriver.waitForAngularRequestsToFinish();

		// synchronization
		explicitWait("propertylist_title_XPATH");

		// verify the property list
		switchVerification("propertylist_title_XPATH", "Property List", "The property list is not displayed.");

		// VERIFY NAVIGATION FROM THE TASK DETAILS SCREEN TO THE TASK LISTING SCREEN
		// THROUGH THE BROWSER BACK BUTTOM - VIA TASK MODULE

		System.out.println(
				"***************** VERIFY NAVIGATION FROM THE TASK DETAILS SCREEN TO THE TASK LISTING SCREEN THROUGH THE BROWSER BACK BUTTOM - VIA TASK MODULE *****************");
		test.log(LogStatus.INFO,
				"***************** VERIFY NAVIGATION FROM THE TASK DETAILS SCREEN TO THE TASK LISTING SCREEN THROUGH THE BROWSER BACK BUTTOM - VIA TASK MODULE *****************");
		Reporter.log(
				"***************** VERIFY NAVIGATION FROM THE TASK DETAILS SCREEN TO THE TASK LISTING SCREEN THROUGH THE BROWSER BACK BUTTOM - VIA TASK MODULE *****************");
		log.info(
				"***************** VERIFY NAVIGATION FROM THE TASK DETAILS SCREEN TO THE TASK LISTING SCREEN THROUGH THE BROWSER BACK BUTTOM - VIA TASK MODULE *****************");

		try {

			// click on the task icon
			click("taskicon_CSS");
			ngDriver.waitForAngularRequestsToFinish();
			System.out.println("Clicked on the task icon.");

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
			switchVerification("task_navigationtask11_XPATH", "Test Task Navigation One Title",
					"The Test Task Navigation One Title is not displayed.");

			// click on the newly created task
			click("task_navigationtask11_XPATH");
			System.out.println("Click on the newly created task.");
			ngDriver.waitForAngularRequestsToFinish();

			// wait for 3 seconds
			Thread.sleep(3000);

			// verify task details screen is displayed or not
			switchVerification("task_navigation_titletxt_XPATH", "Task Details", "The Task Details is not displayed.");

			// click on the browser back button
			driver.navigate().back();
			ngDriver.waitForAngularRequestsToFinish();
			System.out.println("Clicked on the browser back button.");

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
		System.out.println("Clicked on the home icon from the top of the screen.");
		ngDriver.waitForAngularRequestsToFinish();

		// synchronization
		explicitWait("propertylist_title_XPATH");

		// verify the property list
		switchVerification("propertylist_title_XPATH", "Property List", "The property list is not displayed.");

		// VERIFY NAVIGATION FROM THE TASK DETAILS SCREEN TO THE TASK LISTING SCREEN
		// THROUGH THE APPLICATION BACK BUTTON - VIA PROPERTY SUMMARY SCREEN > TASK
		// MODULE

		System.out.println(
				"***************** VERIFY NAVIGATION FROM THE TASK DETAILS SCREEN TO THE TASK LISTING SCREEN THROUGH THE APPLICATION BACK BUTTON - VIA PROPERTY SUMMARY SCREEN > TASK MODULE *****************");
		test.log(LogStatus.INFO,
				"***************** VERIFY NAVIGATION FROM THE TASK DETAILS SCREEN TO THE TASK LISTING SCREEN THROUGH THE APPLICATION BACK BUTTON - VIA PROPERTY SUMMARY SCREEN > TASK MODULE *****************");
		Reporter.log(
				"***************** VERIFY NAVIGATION FROM THE TASK DETAILS SCREEN TO THE TASK LISTING SCREEN THROUGH THE APPLICATION BACK BUTTON - VIA PROPERTY SUMMARY SCREEN > TASK MODULE *****************");
		log.info(
				"***************** VERIFY NAVIGATION FROM THE TASK DETAILS SCREEN TO THE TASK LISTING SCREEN THROUGH THE APPLICATION BACK BUTTON - VIA PROPERTY SUMMARY SCREEN > TASK MODULE *****************");

		try {
			// click on the first property
			click("task_navigation_property1_CSS");
			ngDriver.waitForAngularRequestsToFinish();
			System.out.println("Clicked on the first property.");

			// wait for 3 seconds
			Thread.sleep(3000);

			// click on the task icon of the property summary screen
			click("task_navigation_propertydetailstskicon_CSS");
			ngDriver.waitForAngularRequestsToFinish();
			System.out.println("Clicked on the task icon of the property summary screen.");

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
			switchVerification("task_navigationtask11_XPATH", "Test Task Navigation One Title",
					"The Test Task Navigation One Title is not displayed.");

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

		// VERIFY APPLICATION BACK BUTTOM FROM TASK DETAILS SCREEN

		System.out
				.println("***************** VERIFY APPLICATION BACK BUTTOM FROM TASK DETAILS SCREEN *****************");
		test.log(LogStatus.INFO,
				"***************** VERIFY APPLICATION BACK BUTTOM FROM TASK DETAILS SCREEN *****************");
		Reporter.log("***************** VERIFY APPLICATION BACK BUTTOM FROM TASK DETAILS SCREEN *****************");
		log.info("***************** VERIFY APPLICATION BACK BUTTOM FROM TASK DETAILS SCREEN *****************");

		try {

			// click on the task icon
			click("taskicon_CSS");
			ngDriver.waitForAngularRequestsToFinish();
			System.out.println("Clicked on the task icon.");

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
			switchVerification("task_navigationtask11_XPATH", "Test Task Navigation One Title",
					"The Test Task Navigation One Title is not displayed.");

			// click on the newly created task
			click("task_navigationtask11_XPATH");
			System.out.println("Click on the newly created task.");
			ngDriver.waitForAngularRequestsToFinish();

			// wait for 3 seconds
			Thread.sleep(3000);

			// verify task details screen is displayed or not
			switchVerification("task_navigation_titletxt_XPATH", "Task Details", "The Task Details is not displayed.");

			// click on the back button of the application
			click("task_navigation_appbackbtn_CSS");
			System.out.println("Clicked on the back button of the application.");
			ngDriver.waitForAngularRequestsToFinish();

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
		System.out.println("Clicked on the home icon from the top of the screen.");
		ngDriver.waitForAngularRequestsToFinish();

		// synchronization
		explicitWait("propertylist_title_XPATH");

		// verify the property list
		switchVerification("propertylist_title_XPATH", "Property List", "The property list is not displayed.");

		// VERIFY NAVIGATION FROM THE TASK DETAILS SCREEN TO THE TASK LISTING SCREEN
		// THROUGH THE BROWSER BACK BUTTON - VIA PROPERTY SUMMARY SCREEN > TASK MODULE

		System.out.println(
				"***************** VERIFY NAVIGATION FROM THE TASK DETAILS SCREEN TO THE TASK LISTING SCREEN THROUGH THE BROWSER BACK BUTTON - VIA PROPERTY SUMMARY SCREEN > TASK MODULE *****************");
		test.log(LogStatus.INFO,
				"***************** VERIFY NAVIGATION FROM THE TASK DETAILS SCREEN TO THE TASK LISTING SCREEN THROUGH THE BROWSER BACK BUTTON - VIA PROPERTY SUMMARY SCREEN > TASK MODULE *****************");
		Reporter.log(
				"***************** VERIFY NAVIGATION FROM THE TASK DETAILS SCREEN TO THE TASK LISTING SCREEN THROUGH THE BROWSER BACK BUTTON - VIA PROPERTY SUMMARY SCREEN > TASK MODULE *****************");
		log.info(
				"***************** VERIFY NAVIGATION FROM THE TASK DETAILS SCREEN TO THE TASK LISTING SCREEN THROUGH THE BROWSER BACK BUTTON - VIA PROPERTY SUMMARY SCREEN > TASK MODULE *****************");

		try {

			// click on the task icon
			click("taskicon_CSS");
			ngDriver.waitForAngularRequestsToFinish();
			System.out.println("Clicked on the task icon.");

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
			switchVerification("task_navigationtask11_XPATH", "Test Task Navigation One Title",
					"The Test Task Navigation One Title is not displayed.");

			// click on the newly created task
			click("task_navigationtask11_XPATH");
			System.out.println("Click on the newly created task.");
			ngDriver.waitForAngularRequestsToFinish();

			// wait for 3 seconds
			Thread.sleep(3000);

			// verify task details screen is displayed or not
			switchVerification("task_navigation_titletxt_XPATH", "Task Details", "The Task Details is not displayed.");

			// click on the browser back button
			driver.navigate().back();
			ngDriver.waitForAngularRequestsToFinish();
			System.out.println("Clicked on the browser back button.");
			test.log(LogStatus.INFO, "Clicked on the browser back button.");

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
		System.out.println("Clicked on the home icon from the top of the screen.");
		ngDriver.waitForAngularRequestsToFinish();

		// synchronization
		explicitWait("propertylist_title_XPATH");

		// verify the property list
		switchVerification("propertylist_title_XPATH", "Property List", "The property list is not displayed.");

		// VERIFY NAVIGATION FROM THE TASK LISTING SCREEN TO THE PROPERTY SUMMARY SCREEN
		// THROUGH THE BACK TO DASHBOARD BUTTON - VIA TASKS SECTION OF PROPERTY SUMMARY
		// SCREEN

		System.out.println(
				"***************** VERIFY NAVIGATION FROM THE TASK LISTING SCREEN TO THE PROPERTY SUMMARY SCREEN THROUGH THE BACK TO DASHBOARD BUTTON - VIA TASKS SECTION OF PROPERTY SUMMARY SCREEN *****************");
		test.log(LogStatus.INFO,
				"***************** VERIFY NAVIGATION FROM THE TASK LISTING SCREEN TO THE PROPERTY SUMMARY SCREEN THROUGH THE BACK TO DASHBOARD BUTTON - VIA TASKS SECTION OF PROPERTY SUMMARY SCREEN *****************");
		Reporter.log(
				"***************** VERIFY NAVIGATION FROM THE TASK LISTING SCREEN TO THE PROPERTY SUMMARY SCREEN THROUGH THE BACK TO DASHBOARD BUTTON - VIA TASKS SECTION OF PROPERTY SUMMARY SCREEN *****************");
		log.info(
				"***************** VERIFY NAVIGATION FROM THE TASK LISTING SCREEN TO THE PROPERTY SUMMARY SCREEN THROUGH THE BACK TO DASHBOARD BUTTON - VIA TASKS SECTION OF PROPERTY SUMMARY SCREEN *****************");

		try {
			// click on the first property
			click("task_navigation_property1_CSS");
			ngDriver.waitForAngularRequestsToFinish();
			System.out.println("Clicked on the first property.");

			// wait for 3 seconds
			Thread.sleep(3000);

			// scroll till task section
			WebElement Element = driver.findElement(By.xpath(OR.getProperty("task_navigation_tasklbl_XPATH")));
			JavascriptExecutor js = (JavascriptExecutor) driver;
			js.executeScript("arguments[0].scrollIntoView();", Element);

			// click on the active task count
			click("task_navigation_activetasklink_XPATH");
			ngDriver.waitForAngularRequestsToFinish();
			System.out.println("Clicked on the active task count.");

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
			switchVerification("task_navigationtask11_XPATH", "Test Task Navigation One Title",
					"The Test Task Navigation One Title is not displayed.");

			// click on the back to dashboard screen
			click("task_navigation_backtodashboardbtn_CSS");
			ngDriver.waitForAngularRequestsToFinish();
			System.out.println("Clicked on the back to dashboard screen.");

			// wait for the element
			explicitWait("task_navigation_tasklbl_XPATH");

			// scroll till task section
			WebElement Element1 = driver.findElement(By.xpath(OR.getProperty("task_navigation_tasklbl_XPATH")));
			js.executeScript("arguments[0].scrollIntoView();", Element1);

			// verify task section is displayed or not
			switchVerification("task_navigation_tasklbl_XPATH", "Tasks", "The tasks section is not displayed.");

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

		// VERIFY NAVIGATION FROM THE TASK LISTING SCREEN TO THE PROPERTY SUMMARY SCREEN
		// THROUGH THE BROWSER BACK BUTTON - VIA TASKS SECTION OF PROPERTY SUMMARY
		// SCREEN

		System.out.println(
				"***************** VERIFY NAVIGATION FROM THE TASK LISTING SCREEN TO THE PROPERTY SUMMARY SCREEN THROUGH THE BROWSER BACK BUTTON - VIA TASKS SECTION OF PROPERTY SUMMARY SCREEN *****************");
		test.log(LogStatus.INFO,
				"***************** VERIFY NAVIGATION FROM THE TASK LISTING SCREEN TO THE PROPERTY SUMMARY SCREEN THROUGH THE BROWSER BACK BUTTON - VIA TASKS SECTION OF PROPERTY SUMMARY SCREEN *****************");
		Reporter.log(
				"***************** VERIFY NAVIGATION FROM THE TASK LISTING SCREEN TO THE PROPERTY SUMMARY SCREEN THROUGH THE BROWSER BACK BUTTON - VIA TASKS SECTION OF PROPERTY SUMMARY SCREEN *****************");
		log.info(
				"***************** VERIFY NAVIGATION FROM THE TASK LISTING SCREEN TO THE PROPERTY SUMMARY SCREEN THROUGH THE BROWSER BACK BUTTON - VIA TASKS SECTION OF PROPERTY SUMMARY SCREEN *****************");

		try {
			// click on the first property
			click("task_navigation_property1_CSS");
			ngDriver.waitForAngularRequestsToFinish();
			System.out.println("Clicked on the first property.");

			// wait for 3 seconds
			Thread.sleep(3000);

			// scroll till task section
			WebElement Element = driver.findElement(By.xpath(OR.getProperty("task_navigation_tasklbl_XPATH")));
			JavascriptExecutor js = (JavascriptExecutor) driver;
			js.executeScript("arguments[0].scrollIntoView();", Element);

			// click on the active task count
			click("task_navigation_activetasklink_XPATH");
			ngDriver.waitForAngularRequestsToFinish();
			System.out.println("Clicked on the active task count.");

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
			switchVerification("task_navigationtask11_XPATH", "Test Task Navigation One Title",
					"The Test Task Navigation One Title is not displayed.");

			// wait for 3 seconds
			Thread.sleep(3000);

			// navigate to the back from the browser back button
			driver.navigate().back();
			ngDriver.waitForAngularRequestsToFinish();
			System.out.println("Navigate to the back from the browser back button.");

			// wait for 3 seconds
			Thread.sleep(3000);

			// scroll till task section
			WebElement Element1 = driver.findElement(By.xpath(OR.getProperty("task_navigation_tasklbl_XPATH")));
			js.executeScript("arguments[0].scrollIntoView();", Element1);

			// verify task section is displayed or not
			switchVerification("task_navigation_tasklbl_XPATH", "Tasks", "The tasks section is not displayed.");

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

		// VERIFY NAVIGATION FROM THE TASK DETAILS SCREEN TO THE PROPERTY SUMMARY SCREEN
		// THROUGH THE BACK TO DASHBOARD BUTTON - VIA TASKS SECTION OF PROPERTY SUMMARY
		// SCREEN

		System.out.println(
				"***************** VERIFY NAVIGATION FROM THE TASK DETAILS SCREEN TO THE PROPERTY SUMMARY SCREEN THROUGH THE BACK TO DASHBOARD BUTTON - VIA TASKS SECTION OF PROPERTY SUMMARY SCREEN *****************");
		test.log(LogStatus.INFO,
				"***************** VERIFY NAVIGATION FROM THE TASK DETAILS SCREEN TO THE PROPERTY SUMMARY SCREEN THROUGH THE BACK TO DASHBOARD BUTTON - VIA TASKS SECTION OF PROPERTY SUMMARY SCREEN *****************");
		Reporter.log(
				"***************** VERIFY NAVIGATION FROM THE TASK DETAILS SCREEN TO THE PROPERTY SUMMARY SCREEN THROUGH THE BACK TO DASHBOARD BUTTON - VIA TASKS SECTION OF PROPERTY SUMMARY SCREEN *****************");
		log.info(
				"***************** VERIFY NAVIGATION FROM THE TASK DETAILS SCREEN TO THE PROPERTY SUMMARY SCREEN THROUGH THE BACK TO DASHBOARD BUTTON - VIA TASKS SECTION OF PROPERTY SUMMARY SCREEN *****************");

		try {
			// click on the first property
			click("task_navigation_property1_CSS");
			ngDriver.waitForAngularRequestsToFinish();
			System.out.println("Clicked on the first property.");

			// wait for 3 seconds
			Thread.sleep(3000);

			// scroll till task section
			WebElement Element = driver.findElement(By.xpath(OR.getProperty("task_navigation_tasklbl_XPATH")));
			JavascriptExecutor js = (JavascriptExecutor) driver;
			js.executeScript("arguments[0].scrollIntoView();", Element);

			// click on the active task count
			click("task_navigation_activetasklink_XPATH");
			ngDriver.waitForAngularRequestsToFinish();
			System.out.println("Clicked on the active task count.");

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
			switchVerification("task_navigationtask11_XPATH", "Test Task Navigation One Title",
					"The Test Task Navigation One Title is not displayed.");

			// click on the task to open the task details
			click("task_navigationtask11_XPATH");
			ngDriver.waitForAngularRequestsToFinish();
			System.out.println("Clicked on the task to open the task details.");

			// wait for 3 seconds
			Thread.sleep(3000);

			// verify task details screen is displayed or not
			switchVerification("task_navigation_titletxt_XPATH", "Task Details", "The Task Details is not displayed.");

			// click on the back to dashboard screen
			click("task_navigation_backtodashboardbtn_CSS");
			ngDriver.waitForAngularRequestsToFinish();
			System.out.println("Clicked on the back to dashboard screen.");

			// wait for the element
			Thread.sleep(5000);

			// scroll till task section
			WebElement Element1 = driver.findElement(By.xpath(OR.getProperty("task_navigation_tasklbl_XPATH")));
			js.executeScript("arguments[0].scrollIntoView();", Element1);

			// verify task section is displayed or not
			switchVerification("task_navigation_tasklbl_XPATH", "Tasks", "The tasks section is not displayed.");

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

		// VERIFY NAVIGATION FROM THE TASK DETAILS SCREEN TO THE TASK LISTING SCREEN
		// THROUGH THE BROWSER BACK BUTTON - VIA TASKS SECTION OF PROPERTY SUMMARY
		// SCREEN

		System.out.println(
				"***************** VERIFY NAVIGATION FROM THE TASK DETAILS SCREEN TO THE TASK LISTING SCREEN THROUGH THE BROWSER BACK BUTTON - VIA TASKS SECTION OF PROPERTY SUMMARY SCREEN *****************");
		test.log(LogStatus.INFO,
				"***************** VERIFY NAVIGATION FROM THE TASK DETAILS SCREEN TO THE TASK LISTING SCREEN THROUGH THE BROWSER BACK BUTTON - VIA TASKS SECTION OF PROPERTY SUMMARY SCREEN *****************");
		Reporter.log(
				"***************** VERIFY NAVIGATION FROM THE TASK DETAILS SCREEN TO THE TASK LISTING SCREEN THROUGH THE BROWSER BACK BUTTON - VIA TASKS SECTION OF PROPERTY SUMMARY SCREEN *****************");
		log.info(
				"***************** VERIFY NAVIGATION FROM THE TASK DETAILS SCREEN TO THE TASK LISTING SCREEN THROUGH THE BROWSER BACK BUTTON - VIA TASKS SECTION OF PROPERTY SUMMARY SCREEN *****************");

		try {
			// click on the first property
			click("task_navigation_property1_CSS");
			ngDriver.waitForAngularRequestsToFinish();
			System.out.println("Clicked on the first property.");

			// wait for 3 seconds
			Thread.sleep(3000);

			// scroll till task section
			WebElement Element = driver.findElement(By.xpath(OR.getProperty("task_navigation_tasklbl_XPATH")));
			JavascriptExecutor js = (JavascriptExecutor) driver;
			js.executeScript("arguments[0].scrollIntoView();", Element);

			// click on the active task count
			click("task_navigation_activetasklink_XPATH");
			ngDriver.waitForAngularRequestsToFinish();
			System.out.println("Clicked on the active task count.");

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

			// click on the task to open the task details
			click("task_navigationtask11_XPATH");
			ngDriver.waitForAngularRequestsToFinish();
			System.out.println("Clicked on the task to open the task details.");

			// wait for 3 seconds
			Thread.sleep(3000);

			// verify task details screen is displayed or not
			switchVerification("task_navigation_titletxt_XPATH", "Task Details", "The Task Details is not displayed.");

			// navigate to the back from the browser back button
			driver.navigate().back();
			ngDriver.waitForAngularRequestsToFinish();
			System.out.println("Navigate to the back from the browser back button.");

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
			switchVerification("task_navigationtask11_XPATH", "Test Task Navigation One Title",
					"The Test Task Navigation One Title is not displayed.");

			// navigate to the back from the browser back button
			driver.navigate().back();
			ngDriver.waitForAngularRequestsToFinish();
			System.out.println("Navigate to the back from the browser back button.");

			// scroll till task section
			WebElement Element1 = driver.findElement(By.xpath(OR.getProperty("task_navigation_tasklbl_XPATH")));
			js.executeScript("arguments[0].scrollIntoView();", Element1);

			// verify task section is displayed or not
			switchVerification("task_navigation_tasklbl_XPATH", "Tasks", "The tasks section is not displayed.");

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

		// DELETE THE TASK

		System.out.println("***************** DELETE THE TASK *****************");
		test.log(LogStatus.INFO, "***************** DELETE THE TASK *****************");
		Reporter.log("***************** DELETE THE TASK *****************");
		log.info("***************** DELETE THE TASK *****************");

		try {
			// click on the task icon
			click("taskicon_CSS");
			System.out.println("Clicked on the task icon.");
			ngDriver.waitForAngularRequestsToFinish();

			// scroll up the screen
			JavascriptExecutor js = (JavascriptExecutor) driver;
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
			switchVerification("task_navigationtask11_XPATH", "Test Task Navigation One Title",
					"The Test Task Navigation One Title is not displayed.");

			// click on the newly created task
			click("task_navigationtask11_XPATH");
			System.out.println("Click on the newly created task.");
			ngDriver.waitForAngularRequestsToFinish();

			// wait for element
			explicitWaitClickable("task_deletedtaskbtn_CSS");

			// click on the delete button
			click("task_deletedtaskbtn_CSS");
			System.out.println("Clicked on the delete button.");
			ngDriver.waitForAngularRequestsToFinish();

			// wait for element
			explicitWaitClickable("task_deletedtaskbtn_confirmaiton_CSS");

			// click on the delete button of the confirmation popup
			click("task_deletedtaskbtn_confirmaiton_CSS");
			System.out.println("Clicked on the delete button of the confirmation popup.");
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
