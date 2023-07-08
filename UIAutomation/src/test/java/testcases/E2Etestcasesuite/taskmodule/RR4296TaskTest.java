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

public class RR4296TaskTest extends TestBase {

	@Test(dataProviderClass = TestUtil.class, dataProvider = "dp")
	public void rR4296TaskTest(Hashtable<String, String> data) throws IOException, InterruptedException {

		execution(data, "rR4296TaskTest");

		// TASK ASSIGN TO THE ROLE AND USER
		title("TASK ASSIGN TO THE ROLE AND USER");

		Helper helper = new Helper();

		// refresh the page
		driver.navigate().refresh();
		Thread.sleep(5000);
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
			click("workflowsecurity_sendnotification_nonebtn_CSS");

			// enter the contractor role in the search field
			type("workflowsecurity_editortask_taskdetails_searchtasktagtxt_CSS", data.get("role"));

			// click on the role from the list
			click("task_selectrolelist_XPATH");

			// enter the username in the search field
			type("workflowsecurity_editortask_taskdetails_searchtasktagtxt_CSS", data.get("user_2"));

			// click on the username from the list
			click("task_selectuserlist_XPATH");

			// click on the assign to field
			click("task_assigntotxt_CSS");

			// scroll down the screen
			scrollByPixel(1200);

			// wait for 3 seconds
			Thread.sleep(3000);

			// select the environmental option from the module dropdown
			select("task_addtask_moduledd_CSS", data.get("task_module"));

			// click on the save button
			click("survey_task_savebtn_CSS");

			// wait for the element
			explicitWaitClickable("closetoastmsg_CSS");

			// click on the toaster close button
			click("closetoastmsg_CSS");

			// scroll up the screen
			scrollTop();

			// click on the clear button
			click("task_createdtask_clearbtn_XPATH");

			// enter the data in the search field
			type("task_filter_CSS", data.get("task_title"));

			// click on the search button
			click("task_createdtask_searchbtn_XPATH");

			// verify newly created task is displayed or not
			switchVerification("task_createdtask_roleuser_XPATH", "Test Role User Task Title",
					"The Test Role User Task Title is not displayed.");

		} catch (Throwable t) {
			verificationFailed();
		}

		// LOGOUT FROM ADMIN USER AND LOGIN WITH CONTRACTOR AND VERIFY TASK IS DISPLAYED
		// OR NOT
		title("LOGOUT FROM ADMIN USER AND LOGIN WITH CONTRACTOR AND VERIFY TASK IS DISPLAYED OR NOT");

		try {

			// wait for the element
			explicitWaitClickable("questionnaire_settingicon_CSS");

			// click on the settings icon from the top of the screen
			click("questionnaire_settingicon_CSS");

			// wait for 3 seconds
			explicitWaitClickable("sidemenu_logout_CSS");

			// click on the logout option from the side menu
			click("sidemenu_logout_CSS");

			helper.loginAndUpdateSystemCompany(data, "username", "password", "system_company_1");

			// click on the task icon
			click("taskicon_CSS");

			// click on the clear button
			click("task_createdtask_clearbtn_XPATH");

			// enter the data in the search field
			type("task_filter_CSS", data.get("task_title"));

			// click on the search button
			click("task_createdtask_searchbtn_XPATH");

			// verify newly created task is displayed or not
			try {
				String str1 = driver.findElement(By.xpath(OR.getProperty("task_createdtask_roleuser_XPATH"))).getText();

				if (str1.equals("Test Role User Task Title")) {
					successMessage("The Test Role User Task Title task is verified successfully.");
				} else {
					verificationFailedMessage("The Test Role User Task Title task is not verified successfully");
				}
			} catch (Throwable t) {
				verificationFailedMessage("The Test Role User Task Title task is not verified successfully");
			}

			// LOGOUT FROM CONTRACTOR USER AND LOGIN WITH JINESHQA USER AND VERIFY TASK IS
			// DISPLAYED OR NOT
			title("LOGOUT FROM CONTRACTOR USER AND LOGIN WITH JINESHQA USER AND VERIFY TASK IS DISPLAYED OR NOT");

			// wait for the element
			explicitWaitClickable("questionnaire_settingicon_CSS");

			// click on the settings icon from the top of the screen
			click("questionnaire_settingicon_CSS");

			// wait for the element
			explicitWaitClickable("sidemenu_logout_CSS");

			// click on the logout option from the side menu
			click("sidemenu_logout_CSS");

			helper.loginAndUpdateSystemCompany(data, "username_2", "password_2", "system_company_1");

			// click on the task icon
			click("taskicon_CSS");

			// click on the clear button
			click("task_createdtask_clearbtn_XPATH");

			// enter the data in the search field
			type("task_filter_CSS", data.get("task_title"));

			// click on the search button
			click("task_createdtask_searchbtn_XPATH");

			// verify newly created task is displayed or not
			try {
				String str2 = driver.findElement(By.xpath(OR.getProperty("task_createdtask_roleuser_XPATH"))).getText();

				if (str2.equals("Test Role User Task Title")) {
					successMessage("The Test Role User Task Title task is verified successfully.");
				} else {
					verificationFailedMessage("The Test Role User Task Title task is not verified successfully.");
				}
			} catch (Throwable t) {
				verificationFailedMessage("The Test Role User Task Title task is not verified successfully.");
			}

			// LOGOUT FROM JINESHQA USER AND LOGIN WITH ADMIN USER
			title("LOGOUT FROM JINESHQA USER AND LOGIN WITH ADMIN USER");

			// wait for element
			explicitWaitClickable("questionnaire_settingicon_CSS");

			// click on the settings icon from the top of the screen
			click("questionnaire_settingicon_CSS");

			// wait for element
			explicitWaitClickable("sidemenu_logout_CSS");

			// click on the logout option from the side menu
			click("sidemenu_logout_CSS");

			helper.loginAndUpdateSystemCompany(data, "username_1", "password_1", "system_company_1");

		} catch (Throwable t) {
			helper.questionnaireNotDisplayLogout(data);
		}

		// DELETE THE CREATED TASK
		title("DELETE THE CREATED TASK");

		try {
			// click on the task icon
			click("taskicon_CSS");

			// click on the clear button
			click("task_createdtask_clearbtn_XPATH");

			// enter the data in the search field
			type("task_filter_CSS", data.get("task_title"));

			// click on the search button
			click("task_createdtask_searchbtn_XPATH");

			// click on the newly created task
			click("task_createdtask_roleuser_XPATH");

			// wait for the element
			explicitWaitClickable("task_deletedtaskbtn_CSS");

			// click on the delete button
			click("task_deletedtaskbtn_CSS");

			// wait for the element
			explicitWaitClickable("task_deletedtaskbtn_confirmaiton_CSS");

			// click on the delete button of the confirmation popup
			click("task_deletedtaskbtn_confirmaiton_CSS");

			// click on the clear button
			click("task_createdtask_clearbtn_XPATH");

			// enter the data in the search field
			type("task_filter_CSS", data.get("task_title"));

			// click on the search button
			click("task_createdtask_searchbtn_XPATH");

			// verify the questionnaire deleted or not
			helper.deleteVerification("task_createdtask_roleuser_XPATH", "Test Role User Task Title");

		} catch (Throwable t) {
			verificationFailed();
		}

		// click on the home icon from the top of the screen
		click("questionnaire_homeburgermenubtn_hide_CSS");

		// wait for the element
		explicitWait("propertylist_title_XPATH");

		// verify the property list
		switchVerification("propertylist_title_XPATH", "Property List", "The property list is not displayed.");

	}
}