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

public class RR5192SmartCenter2Test extends TestBase {

	@Test(dataProviderClass = TestUtil.class, dataProvider = "dp")
	public void rR5192SmartCenter2Test(Hashtable<String, String> data) throws IOException, InterruptedException {

		execution(data, "rR5192SmartCenter2Test");

		Helper helper = new Helper();

		// PERFORM THE TEST CASES OF THE SMART CENTERS - CONTRACTOR USER
		title("PERFORM THE TEST CASES OF THE SMART CENTERS - CONTRACTOR USER");

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

			try {

				// ADD THE TASK
				title("ADD THE TASK");

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

				// click on the assign to field
				click("task_assigntotxt_CSS");

				// enter contractor name in the search field
				type("task_tasktag_searchtxt_CSS", data.get("search_role2"));

				// click on the searched role name
				click("task_permission_securitysettings_seachedrole_XPATH");

				// click on the assign to field
				click("task_assigntotxt_CSS");

				// scroll down the screen
				scrollByPixel(500);

				// SELECT THE DUE DATE

				// click on the due date field
				click("task_duedatetxt_CSS");

				// wait for the element
				explicitWaitClickable("task_tasktag_newduedatetxt_todaybtn_XPATH");

				// click on the today button
				click("task_tasktag_newduedatetxt_todaybtn_XPATH");

				// scroll down the screen
				scrollByPixel(500);

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

				// wait for the element
				explicitWaitClickable("closetoastmsg_CSS");

				// click on the toaster close button
				click("closetoastmsg_CSS");

				// scroll up the screen
				scrollByPixel(-400);

				// click on the clear button
				click("task_createdtask_clearbtn_XPATH");

				// enter the data in the search field
				type("task_filter_CSS", data.get("task_title"));

				// click on the search button
				click("task_createdtask_searchbtn_XPATH");

				// verify newly created task is displayed or not
				switchVerification("task_addedtask_smoke22_XPATH", "Smoke Test Two Task Title",
						"The Smoke Test Two Task Title is not displayed.");

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

			// LOGIN IN WITH CONTRACTOR USER
			title("LOGIN IN WITH CONTRACTOR USER");

			// Enter the username
			type("username_MODEL", data.get("username_2"));

			// Enter the password
			type("password_MODEL", data.get("password_2"));

			// Clicking on the "Sign In" button
			click("signinbtn_BTNTEXT");

			// wait for the element
			explicitWait("propertylist_title_XPATH");

			// verify the property list
			switchVerification("propertylist_title_XPATH", "Property List", "The property list is not displayed.");

			// UPDATE THE SYSTEM COMPANY
			updateCompany(data);

			try {

				// UPDATE THE STATUS OF THE TASK - In Progress
				title("UPDATE THE STATUS OF THE TASK - In Progress");

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
				switchVerification("task_addedtask_smoke22_XPATH", "Smoke Test Two Task Title",
						"The Smoke Test Two Task Title is not displayed.");

				// click on the newly created task
				click("task_addedtask_smoke22_XPATH");

				// click on the start button
				click("propertyproject_mu_repair_startbtn_CSS");

				// wait for the element
				explicitWaitClickable("closetoastmsg_CSS");

				// click on the toaster close button
				click("closetoastmsg_CSS");

				// scroll up the screen
				scrollByPixel(-400);

				// verify the in-progress status is displayed or not
				switchVerification("task_inprogress_statuslbl_XPATH", "In Progress",
						"The In Progress status is not displayed.");

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
				type("task_filter_CSS", data.get("task_title"));

				// click on the search button
				click("task_createdtask_searchbtn_XPATH");

				// verify the status of the newly created task
				switchVerification("task_inprogress_filtered_XPATH", "In Progress",
						"The In Progress status of the task is not displayed");

			} catch (Throwable t) {
				verificationFailed();
			}

			// click on the home icon from the top of the screen
			click("questionnaire_homeburgermenubtn_hide_CSS");

			// wait for the element
			explicitWait("propertylist_title_XPATH");

			// verify the property list
			switchVerification("propertylist_title_XPATH", "Property List", "The property list is not displayed.");

			// UPDATE THE STATUS OF THE TASK - Pending
			title("UPDATE THE STATUS OF THE TASK - Pending");

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
				switchVerification("task_addedtask_smoke22_XPATH", "Smoke Test Two Task Title",
						"The Smoke Test Two Task Title is not displayed.");

				// click on the newly created task
				click("task_addedtask_smoke22_XPATH");

				// click on the pending button
				click("task_pendingbtn_CSS");

				// verify the pending status is displayed or not
				switchVerification("task_pendingstatus_XPATH", "Pending", "The Pending status is not displayed.");

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
				type("task_filter_CSS", data.get("task_title"));

				// click on the search button
				click("task_createdtask_searchbtn_XPATH");

				// verify the status of the newly created task
				switchVerification("task_pending_filtered_XPATH", "Pending",
						"The Pending status of the task is not displayed");

			} catch (Throwable t) {

				verificationFailed();
			}

			// click on the home icon from the top of the screen
			click("questionnaire_homeburgermenubtn_hide_CSS");

			// wait for the element
			explicitWait("propertylist_title_XPATH");

			// verify the property list
			switchVerification("propertylist_title_XPATH", "Property List", "The property list is not displayed.");

			// ADD THE COMMENT IN THE TASK
			title("ADD THE COMMENT IN THE TASK");

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
				switchVerification("task_addedtask_smoke22_XPATH", "Smoke Test Two Task Title",
						"The Smoke Test Two Task Title is not displayed.");

				// click on the newly created task
				click("task_addedtask_smoke22_XPATH");

				// click on the comment tab
				click("propertyproject_mu_addedrepair_taskcommenttab_CSS");

				// scroll down the screen
				scrollByPixel(1000);

				// click on the add comment button
				click("task_addcommentbtn_CSS");

				// enter the text in the comment field
				type("task_addtask_commentstab_commenttxt_CSS", data.get("comment1"));

				// click on the add button for save the entered comment
				click("task_comment_addcommentbtn_CSS");

				// wait for the element
				explicitWait("task_addtask_commentstab_savedcomment_XPATH");

				// verify the saved comment is displayed or not
				switchVerification("task_addtask_commentstab_savedcomment_XPATH", "Testing Purpose Comment One",
						"The Testing Purpose Comment One is not displayed.");

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
				type("task_filter_CSS", data.get("task_title"));

				// click on the search button
				click("task_createdtask_searchbtn_XPATH");

				// verify newly created task is displayed or not
				switchVerification("task_addedtask_smoke22_XPATH", "Smoke Test Two Task Title",
						"The Smoke Test Two Task Title is not displayed.");

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
				switchVerification("task_addedtask_smoke22_XPATH", "Smoke Test Two Task Title",
						"The Smoke Test Two Task Title is not displayed.");

				// click on the newly created task
				click("task_addedtask_smoke22_XPATH");

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

				switchVerification("task_addedtask_smoke22_XPATH", "Smoke Test Two Task Title",
						"The Smoke Test Two Task Title is not displayed.");

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

				switchVerification("task_addedtask_smoke22_XPATH", "Smoke Test Two Task Title",
						"The Smoke Test Two Task Title is not displayed.");

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

			// DELETE THE NEWLY CREATED TASK FROM THE CLOSE TASK LIST
			title("DELETE THE NEWLY CREATED TASK FROM THE CLOSE TASK LIST");

			// wait for the element
			explicitWaitClickable("questionnaire_settingicon_CSS");

			// click on the settings icon from the top of the screen
			click("questionnaire_settingicon_CSS");

			// wait for the element
			explicitWaitClickable("sidemenu_logout_CSS");

			// click on the logout option from the side menu
			click("sidemenu_logout_CSS");

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

			// DELETE THE NEWLY CREATED TASK FROM THE ACTIVE TASK LIST
			title("DELETE THE NEWLY CREATED TASK FROM THE ACTIVE TASK LIST");
			try {

				// enter the property name in the search field
				type("envreports_propertylist_filtertxt_CSS", data.get("property_1"));

				// click on the task icon
				click("taskicon_CSS");

				// click on the clear button
				click("task_createdtask_clearbtn_XPATH");

				// type the newly created task in the search field
				type("task_filter_CSS", data.get("task_title"));

				// click on the search button
				click("task_createdtask_searchbtn_XPATH");

				// click on the newly created task
				click("task_addedtask_smoke22_XPATH");

				// click on the delete button
				click("task_deletedtaskbtn_CSS");

				// synchronization
				explicitWait("task_deletedtaskbtn_confirmaiton_CSS");

				// click on the delete button of the confirmation popup
				click("task_deletedtaskbtn_confirmaiton_CSS");

				// wait for the element
				explicitWaitClickable("closetoastmsg_CSS");

				// click on the toaster close button
				click("closetoastmsg_CSS");

				// scroll up the screen

				scrollByPixel(-500);

				// click on the clear button
				click("task_createdtask_clearbtn_XPATH");

				// enter the data in the search field
				type("task_filter_CSS", data.get("task_title"));

				// click on the search button
				click("task_createdtask_searchbtn_XPATH");

				// verify the questionnaire deleted or not

				deleteVerification("task_addedtask_smoke22_XPATH", "Smoke Test Two Task Title");

			} catch (Throwable t) {

				verificationFailed();

			}

			// click on the home icon from the top of the screen
			click("questionnaire_homeburgermenubtn_hide_CSS");

			// wait for the element
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

			// LOGIN IN WITH CONTRACTOR USER
			title("LOGIN IN WITH CONTRACTOR USER");

			// Enter the username
			type("username_MODEL", data.get("username_2"));

			// Enter the password
			type("password_MODEL", data.get("password_2"));

			// Clicking on the "Sign In" button
			click("signinbtn_BTNTEXT");

			// wait for the element
			explicitWait("propertylist_title_XPATH");

			// verify the property list
			switchVerification("propertylist_title_XPATH", "Property List", "The property list is not displayed.");

			// UPDATE THE SYSTEM COMPANY
			updateCompany(data);

			// REOPEN THE NEWLY CREATED FIRST TASK FROM THE CLOSED TASK LIST
			title("REOPEN THE NEWLY CREATED FIRST TASK FROM THE CLOSED TASK LIST");

			try {

				// enter the property name in the search field
				type("envreports_propertylist_filtertxt_CSS", data.get("property_1"));

				// click on the task icon
				click("taskicon_CSS");

				// select the close option from the status drop down
				select("survey_task_closefilter_CSS", data.get("task_closed_status"));

				// click on the clear button
				click("task_createdtask_clearbtn_XPATH");

				// type the newly created task in the search field
				type("task_filter_CSS", data.get("task_title"));

				// click on the search button
				click("task_createdtask_searchbtn_XPATH");

				LocalDate updatedDueDate = LocalDate.now();
				String updatedDueDateXpath = "//td[text()='" + updatedDueDate + "']";
				driver.findElement(By.xpath(updatedDueDateXpath)).click();

				// click on the reopen button
				click("survey_reopenbtn_CSS");

				// wait for the element
				explicitWaitClickable("closetoastmsg_CSS");

				// click on the toaster close button
				click("closetoastmsg_CSS");

				// scroll down the screen

				scrollByPixel(400);

				// wait for the element
				explicitWait("task_reopenedstatus_XPATH");

				// verify the Reopened status is displayed or not
				switchVerification("task_reopenedstatus_XPATH", "Reopened", "The Reopened status is not displayed.");

				// click on the update button
				click("survey_task_updatebtn_CSS");

				// wait for the element
				explicitWaitClickable("closetoastmsg_CSS");

				// click on the toaster close button
				click("closetoastmsg_CSS");

				// click on the back button
				click("task_backbtn_CSS");

				// select the active option from the status drop down
				select("survey_task_closefilter_CSS", data.get("task_active_status"));

				// click on the clear button
				click("task_createdtask_clearbtn_XPATH");

				// type the newly created task in the search field
				type("task_filter_CSS", data.get("task_title"));

				// click on the search button
				click("task_createdtask_searchbtn_XPATH");

				switchVerification("task_addedtask_smoke22_XPATH", "Smoke Test Two Task Title",
						"The Smoke Test Two Task Title is not displayed.");

			} catch (Throwable t) {

				verificationFailed();

			}

			// click on the home icon from the top of the screen
			click("questionnaire_homeburgermenubtn_hide_CSS");

			// wait for the element
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

			// DELETE THE NEWLY CREATED SECOND TASK FROM THE ACTIVE TASK LIST
			title("DELETE THE NEWLY CREATED SECOND TASK FROM THE ACTIVE TASK LIST");

			try {
				// enter the property name in the search field
				type("envreports_propertylist_filtertxt_CSS", data.get("property_1"));

				// click on the task icon
				click("taskicon_CSS");

				// click on the clear button
				click("task_createdtask_clearbtn_XPATH");

				// type the newly created task in the search field
				type("task_filter_CSS", data.get("task_title"));

				// click on the search button
				click("task_createdtask_searchbtn_XPATH");

				// click on the newly created task
				click("task_addedtask_smoke22_XPATH");

				// click on the delete button
				click("task_deletedtaskbtn_CSS");

				// synchronization
				explicitWait("task_deletedtaskbtn_confirmaiton_CSS");

				// click on the delete button of the confirmation popup
				click("task_deletedtaskbtn_confirmaiton_CSS");

				// wait for the element
				explicitWaitClickable("closetoastmsg_CSS");

				// click on the toaster close button
				click("closetoastmsg_CSS");

				// scroll up the screen

				scrollByPixel(-500);

				// click on the clear button
				click("task_createdtask_clearbtn_XPATH");

				// enter the data in the search field
				type("task_filter_CSS", data.get("task_title"));

				// click on the search button
				click("task_createdtask_searchbtn_XPATH");

				// verify the questionnaire deleted or not

				deleteVerification("task_addedtask_smoke22_XPATH", "Smoke Test Two Task Title");

			} catch (Throwable t) {

				verificationFailed();

			}

			// click on the home icon from the top of the screen
			click("questionnaire_homeburgermenubtn_hide_CSS");

			// wait for the element
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

		// UPDATE THE SYSTEM COMPANY
		updateCompany(data);

		// wait for the element
		Thread.sleep(10000);

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