package testcases.smokesuite;

import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.Date;
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

public class RR5192SmartCenter3Test extends TestBase {

	@Test(dataProviderClass = TestUtil.class, dataProvider = "dp")
	public void rR5192SmartCenter3Test(Hashtable<String, String> data) throws IOException, InterruptedException {

		execution(data, "rR5192SmartCenter3Test");

		Helper helper = new Helper();

		// PERFORM THE TEST CASES OF THE SMART CENTERS - PROPERTY MANAGER USER
		title("PERFORM THE TEST CASES OF THE SMART CENTERS - PROPERTY MANAGER USER");

		// refresh the page
		driver.navigate().refresh();
		Thread.sleep(5000);
		driver.navigate().refresh();

		try {
			// LOGIN WITH PROPERTY MANAGER USER
			title("LOGIN WITH PROPERTY MANAGER USER");

			// wait for the element
			explicitWaitClickable("signinbtn_BTNTEXT");

			// Enter the username
			type("usernametxt_CSS", data.get("username"));

			// Enter the password
			type("passwordtxt_CSS", data.get("password"));

			// Clicking on the "Sign In" button
			click("signinbtn_BTNTEXT");

			// wait for the element
			explicitWait("propertylist_title_XPATH");

			// verify the property list
			switchVerification("propertylist_title_XPATH", "Property List", "The property list is not displayed.");

			// UPDATE THE SYSTEM COMPANY
			updateCompany(data);

			// ADD THE TASK
			title("ADD THE TASK");

			try {

				// enter the property name in the search field
				type("envreports_propertylist_filtertxt_CSS", data.get("property_1"));

				// click on the task icon
				click("taskicon_CSS");

				// click on the add task button
				click("task_addtaskbtn_CSS");

				// enter the data in the task title field
				type("task_addtask_titletxt_CSS", data.get("task_title"));

				// enter the data in the task location field

				type("task_addtask_locationtxt_CSS", data.get("task_location"));

				// scroll down the screen
				scrollByPixel(600);

				// SELECT THE DUE DATE

				// click on the due date field
				click("task_duedatetxt_CSS");

				// wait for the element
				explicitWaitClickable("task_tasktag_newduedatetxt_todaybtn_XPATH");

				// click on the today button
				click("task_tasktag_newduedatetxt_todaybtn_XPATH");

				// scroll down the screen
				scrollByPixel(600);

				// SELECT RECURRENT DATE

				// select the month option from the recurrent drop down
				select("task_reccurentdd_CSS", data.get("recurrent_type"));

				// enter the data in the recurrent interval field

				type("task_reccurentintervaltxt_CSS", "1");

				// wait for the element
				explicitWait("task_addtask_moduledd_CSS");

				// select the application option from the module dropdown
				select("task_addtask_moduledd_CSS", data.get("task_module"));

				// scroll down the screen
				scrollByPixel(400);

				// click on the task tag field
				click("task_tasktag_field_CSS");

				// click on the none button
				click("task_tasktag_nonebtn_CSS");

				// enter the task tag name in the search field

				type("task_tasktag_searchtxt_CSS", data.get("search_4"));

				// click on the searched result
				click("task_tasktag_searchedresult7_XPATH");

				// click on the task tag field
				click("task_tasktag_field_CSS");

				// click on the save button
				click("survey_task_savebtn_CSS");

				// scroll up the screen
				scrollByPixel(-400);

				// click on the clear button
				click("task_createdtask_clearbtn_XPATH");

				// enter the data in the search field
				type("task_filter_CSS", data.get("task_title"));

				// click on the search button
				click("task_createdtask_searchbtn_XPATH");

				// verify newly created task is displayed or not
				switchVerification("task_addedtask_smoke3_XPATH", "Smoke Test Three Task Title",
						"The Smoke Test Three Task Title is not displayed.");

			} catch (Throwable t) {
				verificationFailed();
			}

			// click on the home icon from the top of the screen
			click("questionnaire_homeburgermenubtn_hide_CSS");

			// wait for the element
			explicitWait("propertylist_title_XPATH");

			// verify the property list
			switchVerification("propertylist_title_XPATH", "Property List", "The property list is not displayed.");

			// CLOSE THE TASK AND VERIFY UPDATED DUE DATE IS DISPLAYED OR NOT
			title("CLOSE THE TASK AND VERIFY UPDATED DUE DATE IS DISPLAYED OR NOT");

			try {

				// enter the property name in the search field
				type("envreports_propertylist_filtertxt_CSS", data.get("property_1"));

				// click on the task icon
				click("taskicon_CSS");

				// click on the clear button
				click("task_createdtask_clearbtn_XPATH");

				// enter the data in the search field
				type("task_filter_CSS", data.get("task_title"));

				// click on the search button
				click("task_createdtask_searchbtn_XPATH");

				// verify newly created task is displayed or not
				switchVerification("task_addedtask_smoke3_XPATH", "Smoke Test Three Task Title",
						"The Smoke Test Three Task Title is not displayed.");

				// click on the newly created task
				click("task_addedtask_smoke3_XPATH");

				// click on the close button
				click("task_closebtn_CSS");

				// click on the yes button of confirmation popup model
				click("task_closebtn_yesbtn_CSS");

				// scroll up the screen

				scrollByPixel(-400);

				// verify the close status is displayed or not
				switchVerification("task_closedstatus_XPATH", "Closed", "The Closed status is not displayed.");

				// click on the back button
				click("task_backbtn_CSS");

				// select the close option from the status drop down
				select("survey_task_closefilter_CSS", data.get("task_closed_status"));

				// click on the clear button
				click("task_createdtask_clearbtn_XPATH");

				// type the newly created task in the search field
				type("task_filter_CSS", data.get("task_title"));

				// click on the search button
				click("task_createdtask_searchbtn_XPATH");

				switchVerification("task_addedtask_smoke3_XPATH", "Smoke Test Three Task Title",
						"The Smoke Test Three Task Title is not displayed.");

				// VERIFY THE DUE DATE IS DISPLAYED CORRECT OR NOT ON CLOSED TASK LIST
				title("VERIFY THE DUE DATE IS DISPLAYED CORRECT OR NOT ON CLOSED TASK LIST");

				try {
					LocalDate currentDate = LocalDate.now();
					String expectedCurrentDate = currentDate.toString();
					String currentDateXpath = "//td[text()='" + currentDate + "']";
					String finalCurrentDate = driver.findElement(By.xpath(currentDateXpath)).getText();

					if (expectedCurrentDate.equals(finalCurrentDate)) {
						successMessage("THE DUE DATE IS DISPLAYED CORRECTLY ON CLOSED TASK LIST AS EXPECTED.");
					} else {
						verificationFailedMessage("The due date is displayed incorrect on closed task list.");
					}

				} catch (Throwable t) {
					verificationFailedMessage("The due date is displayed incorrect on closed task list.");
				}

				// select the close option from the status drop down
				select("survey_task_closefilter_CSS", data.get("task_active_status"));

				// click on the clear button
				click("task_createdtask_clearbtn_XPATH");

				// type the newly created task in the search field
				type("task_filter_CSS", data.get("task_title"));

				// click on the search button
				click("task_createdtask_searchbtn_XPATH");

				switchVerification("task_addedtask_smoke3_XPATH", "Smoke Test Three Task Title",
						"The Smoke Test Three Task Title is not displayed.");

				// VERIFY THE DUE DATE IS DISPLAYED CORRECT OR NOT ON ACTIVE TASK LIST
				title("VERIFY THE DUE DATE IS DISPLAYED CORRECT OR NOT ON ACTIVE TASK LIST");

				try {
					LocalDate futureDate = LocalDate.now().plusMonths(1);
					String expectedFutureDate = futureDate.toString();
					String futureDateXpath = "//td[text()='" + futureDate + "']";
					String finalFutureDate = driver.findElement(By.xpath(futureDateXpath)).getText();

					if (expectedFutureDate.equals(finalFutureDate)) {
						successMessage("THE DUE DATE IS DISPLAYED CORRECTLY ON ACTIVE TASK LIST AS EXPECTED.");

					} else {
						verificationFailedMessage("The due date is displayed incorrect on active task list.");
					}

				} catch (Throwable t) {
					verificationFailedMessage("The due date is displayed incorrect on active task list.");
				}

			} catch (Throwable t) {
				verificationFailed();
			}

			// click on the home icon from the top of the screen
			click("questionnaire_homeburgermenubtn_hide_CSS");

			// wait for the element
			explicitWait("propertylist_title_XPATH");

			// verify the property list
			switchVerification("propertylist_title_XPATH", "Property List", "The property list is not displayed.");

			// UPDATE THE DUE DATE OF THE TASK
			title("UPDATE THE DUE DATE OF THE TASK");

			try {

				// enter the property name in the search field
				type("envreports_propertylist_filtertxt_CSS", data.get("property_1"));

				// click on the task icon
				click("taskicon_CSS");

				// select the active option from the status drop down
				select("survey_task_closefilter_CSS", data.get("task_active_status"));

				// click on the clear button
				click("task_createdtask_clearbtn_XPATH");

				// enter the data in the search field
				type("task_filter_CSS", data.get("task_title"));

				// click on the search button
				click("task_createdtask_searchbtn_XPATH");

				// verify newly created task is displayed or not
				switchVerification("task_addedtask_smoke3_XPATH", "Smoke Test Three Task Title",
						"The Smoke Test Three Task Title is not displayed.");

				// click on the newly created task
				click("task_addedtask_smoke3_XPATH");

				// click on the change due date button
				click("task_tasktag_changeduedatebtn_CSS");

				// enter date which is 2 days before current date
				LocalDate pastDate = LocalDate.now().minusDays(2);
				String finalPastDate = pastDate.toString();
				type("task_tasktag_changeduedate_newduedate_XPATH", finalPastDate);

				// click on the new due date label
				click("task_tasktag_changeduedate_newduedatelbl_XPATH");

				// enter data in the reason for change field
				type("task_updateduedate_reasonforchangetxt_CSS", data.get("reason_for_change"));

				// click on the apply button
				click("task_updateduedate_applybtn_CSS");

				// scroll up the screen

				scrollByPixel(-500);

				// enter the data in the task title field

				type("task_addtask_titletxt_CSS", data.get("task_title_updated"));

				// click on the update button
				click("survey_task_updatebtn_CSS");

				// wait for the element
				explicitWaitClickable("closetoastmsg_CSS");

				// click on the toaster close button
				click("closetoastmsg_CSS");

				// click on the back button
				click("task_backbtn_CSS");

				// click on the clear button
				click("task_createdtask_clearbtn_XPATH");

				// type the newly created task in the search field
				type("task_filter_CSS", data.get("task_title_updated"));

				// click on the search button
				click("task_createdtask_searchbtn_XPATH");

				switchVerification("task_addedtask_smoke333_XPATH", "Smoke Test Three Task Title After Due Date Update",
						"The Smoke Test Three Task Title After Due Date Update is not displayed.");

			} catch (Throwable t) {
				verificationFailed();
			}

			// click on the home icon from the top of the screen
			click("questionnaire_homeburgermenubtn_hide_CSS");

			// wait for the element
			explicitWait("propertylist_title_XPATH");

			// verify the property list
			switchVerification("propertylist_title_XPATH", "Property List", "The property list is not displayed.");

			// CLOSE THE TASK AFTER UPDATE THE DUE DATE AND VERIFY UPDATED DUE DATE IS
			// DISPLAYED OR NOT
			title("CLOSE THE TASK AFTER UPDATE THE DUE DATE AND VERIFY UPDATED DUE DATE IS DISPLAYED OR NOT");

			try {

				// enter the property name in the search field
				type("envreports_propertylist_filtertxt_CSS", data.get("property_1"));

				// click on the task icon
				click("taskicon_CSS");

				// click on the clear button
				click("task_createdtask_clearbtn_XPATH");

				// enter the data in the search field
				type("task_filter_CSS", data.get("task_title"));

				// click on the search button
				click("task_createdtask_searchbtn_XPATH");

				// verify newly created task is displayed or not
				switchVerification("task_addedtask_smoke333_XPATH", "Smoke Test Three Task Title After Due Date Update",
						"The Smoke Test Three Task Title After Due Date Update is not displayed.");

				// click on the newly created task
				click("task_addedtask_smoke333_XPATH");

				// click on the close button
				click("task_closebtn_CSS");

				// click on the yes button of confirmation popup model
				click("task_closebtn_yesbtn_CSS");

				// scroll up the screen

				scrollByPixel(-400);

				// verify the close status is displayed or not
				switchVerification("task_closedstatus_XPATH", "Closed", "The Closed status is not displayed.");

				// click on the back button
				click("task_backbtn_CSS");

				// select the close option from the status drop down
				select("survey_task_closefilter_CSS", data.get("task_closed_status"));

				// click on the clear button
				click("task_createdtask_clearbtn_XPATH");

				// type the newly created task in the search field
				type("task_filter_CSS", data.get("task_title_updated"));

				// click on the search button
				click("task_createdtask_searchbtn_XPATH");

				switchVerification("task_addedtask_smoke333_XPATH", "Smoke Test Three Task Title After Due Date Update",
						"The Smoke Test Three Task Title After Due Date Update is not displayed.");

				// VERIFY THE DUE DATE IS DISPLAYED CORRECT OR NOT ON THE CLOSED TASK LIST
				title("VERIFY THE DUE DATE IS DISPLAYED CORRECT OR NOT ON THE CLOSED TASK LIST");

				try {
					LocalDate updatedDueDate = LocalDate.now().minusDays(2);
					String expectedUpdatedDueDate = updatedDueDate.toString();
					String updatedDueDateXpath = "//td[text()='" + updatedDueDate + "']";
					String finalUpdateDueDate = driver.findElement(By.xpath(updatedDueDateXpath)).getText();

					if (expectedUpdatedDueDate.equals(finalUpdateDueDate)) {
						successMessage(
								"THE DUE DATE IS DISPLAYED CORRECTLY AFTER UPDATED THE DUE DATE ON CLOSED TASK LIST AS EXPECTED.");
					} else {
						verificationFailedMessage(
								"The due date is displayed incorrect after updated the due date on closed task list.");
					}

				} catch (Throwable t) {
					verificationFailedMessage(
							"The due date is displayed incorrect after updated the due date on closed task list.");
				}

				// select the active option from the status drop down
				select("survey_task_closefilter_CSS", data.get("task_active_status"));

				// click on the clear button
				click("task_createdtask_clearbtn_XPATH");

				// type the newly created task in the search field
				type("task_filter_CSS", data.get("task_title"));

				// click on the search button
				click("task_createdtask_searchbtn_XPATH");

				switchVerification("task_addedtask_smoke333_XPATH", "Smoke Test Three Task Title After Due Date Update",
						"The Smoke Test Three Task Title After Due Date Update is not displayed.");

				// VERIFY THE DUE DATE IS DISPLAYED CORRECT OR NOT ON THE ACTIVE TASK LIST
				title("VERIFY THE DUE DATE IS DISPLAYED CORRECT OR NOT ON THE ACTIVE TASK LIST");

				try {
					LocalDate updatedFutureDate = LocalDate.now().plusMonths(2);
					String expectedUpdatedFutureDate = updatedFutureDate.toString();
					String updatedFutureDateXpath = "//td[text()='" + updatedFutureDate + "']";
					String finalUpdatedFutureDate = driver.findElement(By.xpath(updatedFutureDateXpath)).getText();

					if (expectedUpdatedFutureDate.equals(finalUpdatedFutureDate)) {
						successMessage(
								"THE DUE DATE IS DISPLAYED CORRECTLY AFTER UPDATED THE DUE DATE ON ACTIVE TASK LIST AS EXPECTED.");
					} else {
						verificationFailedMessage(
								"The due date is displayed incorrect after updated the due date on active task list.");
					}

				} catch (Throwable t) {
					verificationFailedMessage(
							"The due date is displayed incorrect after updated the due date on active task list.");
				}

			} catch (Throwable t) {
				verificationFailed();
			}

			// click on the home icon from the top of the screen
			click("questionnaire_homeburgermenubtn_hide_CSS");

			// wait for the element
			explicitWait("propertylist_title_XPATH");

			// verify the property list
			switchVerification("propertylist_title_XPATH", "Property List", "The property list is not displayed.");

			// DELETE THE NEWLY CREATED SECOND TASK FROM THE ACTIVE TASK LIST
			title("DELETE THE NEWLY CREATED SECOND TASK FROM THE ACTIVE TASK LIST");

			try {
				// enter the property name in the search field
				type("envreports_propertylist_filtertxt_CSS", data.get("property_1"));

				// click on the task icon
				click("taskicon_CSS");

				// select the active option from the status drop down
				select("survey_task_closefilter_CSS", data.get("task_active_status"));

				// click on the clear button
				click("task_createdtask_clearbtn_XPATH");

				// type the newly created task in the search field
				type("task_filter_CSS", data.get("task_title_updated"));

				// click on the search button
				click("task_createdtask_searchbtn_XPATH");

				// click on the action icon of the newly created task
				click("task_addedtask_smoke3_actionicon_XPATH");

				// click on the delete button
				click("task_addedtask_smoke3_actionicon_deleteoption_XPATH");

				// wait for the element
				explicitWaitClickable("closetoastmsg_CSS");

				// click on the toaster close button
				click("closetoastmsg_CSS");

				// scroll up the screen

				scrollByPixel(-500);

				// click on the clear button
				click("task_createdtask_clearbtn_XPATH");

				// enter the data in the search field
				type("task_filter_CSS", data.get("task_title_updated"));

				// click on the search button
				click("task_createdtask_searchbtn_XPATH");

				// verify the questionnaire deleted or not

				deleteVerification("task_addedtask_smoke333_XPATH",
						"Smoke Test Three Task Title After Due Date Update");

				// DELETE THE NEWLY CREATED TASKS FROM THE ACTIVE TASK LIST
				title("DELETE THE NEWLY CREATED TASKS FROM THE ACTIVE TASK LIST");

				// select the close option from the status drop down
				select("survey_task_closefilter_CSS", data.get("task_closed_status"));

				// click on the clear button
				click("task_createdtask_clearbtn_XPATH");

				// type the newly created task in the search field
				type("task_filter_CSS", data.get("task_title_updated"));

				// click on the search button
				click("task_createdtask_searchbtn_XPATH");

				// click on the action button of the newly created task
				click("task_addedtask_smoke3_actionicon_XPATH");

				// click on the reopen button
				click("task_addedtask_smoke3_actionicon_reopenoption_XPATH");

				// wait for the element
				explicitWaitClickable("closetoastmsg_CSS");

				// click on the toaster close button
				click("closetoastmsg_CSS");

				// select the active option from the status drop down
				select("survey_task_closefilter_CSS", data.get("task_active_status"));

				// click on the clear button
				click("task_createdtask_clearbtn_XPATH");

				// type the newly created task in the search field
				type("task_filter_CSS", data.get("task_title_updated"));

				// click on the search button
				click("task_createdtask_searchbtn_XPATH");

				// click on the action button of the newly created task
				click("task_addedtask_smoke3_actionicon_XPATH");

				// click on the reopen button
				click("task_addedtask_smoke3_actionicon_deleteoption_XPATH");

				// wait for the element
				explicitWaitClickable("closetoastmsg_CSS");

				// click on the toaster close button
				click("closetoastmsg_CSS");

				// select the close option from the status drop down
				select("survey_task_closefilter_CSS", data.get("task_closed_status"));

				// click on the clear button
				click("task_createdtask_clearbtn_XPATH");

				// enter the data in the search field
				type("task_filter_CSS", data.get("task_title"));

				// click on the action button of the newly created task
				click("task_addedtask_smoke3_actionicon1_XPATH");

				// click on the reopen button
				click("task_addedtask_smoke3_actionicon_reopenoption1_XPATH");

				// wait for the element
				explicitWaitClickable("closetoastmsg_CSS");

				// click on the toaster close button
				click("closetoastmsg_CSS");

				// select the active option from the status drop down
				select("survey_task_closefilter_CSS", data.get("task_active_status"));

				// click on the clear button
				click("task_createdtask_clearbtn_XPATH");

				// enter the data in the search field
				type("task_filter_CSS", data.get("task_title"));

				// click on the action button of the newly created task
				click("task_addedtask_smoke3_actionicon1_XPATH");

				// click on the reopen button
				click("task_addedtask_smoke3_actionicon_deleteoption1_XPATH");

				// wait for the element
				explicitWaitClickable("closetoastmsg_CSS");

				// click on the toaster close button
				click("closetoastmsg_CSS");

			} catch (Throwable t) {
				verificationFailed();
			}

			// click on the home icon from the top of the screen
			click("questionnaire_homeburgermenubtn_hide_CSS");

			// synchronization
			explicitWait("propertylist_title_XPATH");

			// verify the property list
			switchVerification("propertylist_title_XPATH", "Property List", "The property list is not displayed.");

			// wait for the element
			explicitWaitClickable("questionnaire_settingicon_CSS");

			// click on the settings icon from the top of the screen
			click("questionnaire_settingicon_CSS");

			// wait for the element
			explicitWaitClickable("sidemenu_logout_CSS");

			// click on the logout option from the side menu
			click("sidemenu_logout_CSS");

			// wait for the element
			explicitWaitClickable("signinbtn_BTNTEXT");

			// LOGIN IN ADMIN USER
			title("LOGIN IN ADMIN USER");

			// Enter the username
			type("username_MODEL", data.get("username_1"));

			// Enter the password
			type("password_MODEL", data.get("password_1"));

			// Clicking on the "Sign In" button
			click("signinbtn_BTNTEXT");

			// wait for the element
			explicitWait("propertylist_title_XPATH");

			// verify the property list
			switchVerification("propertylist_title_XPATH", "Property List", "The property list is not displayed.");

		} catch (Throwable t) {
			helper.questionnaireNotDisplayLogout(data);
		}

		// click on the home icon from the top of the screen
		click("questionnaire_homeburgermenubtn_hide_CSS");

		// synchronization
		explicitWait("propertylist_title_XPATH");

		// verify the property list
		switchVerification("propertylist_title_XPATH", "Property List", "The property list is not displayed.");

		try {
			// wait for the element
			explicitWaitClickable("questionnaire_settingicon_CSS");

			// click on the settings icon from the top of the screen
			click("questionnaire_settingicon_CSS");

			// wait for the element
			explicitWaitClickable("sidemenu_logout_CSS");

			// click on the logout option from the side menu
			click("sidemenu_logout_CSS");

			// wait for the element
			explicitWaitClickable("signinbtn_BTNTEXT");

		} catch (Throwable t) {
			verificationFailed();
		}
	}
}