package testcases.E2Etestcasesuite.taskmodule;

import java.io.File;
import java.io.IOException;
import java.util.Hashtable;
import java.util.List;
import java.util.Random;

import org.apache.commons.lang3.RandomStringUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.SkipException;
import org.testng.annotations.Test;

import com.relevantcodes.extentreports.LogStatus;

import base.TestBase;
import utilities.ExcelReader;
import utilities.TestUtil;

public class RR6073Task1Test extends TestBase {

	@Test(dataProviderClass = TestUtil.class, dataProvider = "dp")
	public void rR6073Task1Test(Hashtable<String, String> data) throws IOException, InterruptedException {

		execution(data, "rR6073Task1Test");

		// VALIDATE THE FILTERED RECORDS IN APPLICATION AND FILTERED EXPORTED RECORDS OF
		// THE MY TASK SCREEN
		title("VALIDATE THE FILTERED RECORDS IN APPLICATION AND FILTERED EXPORTED RECORDS OF THE MY TASK SCREEN.");

		// refresh the page
		driver.navigate().refresh();
		explicitWait("taskicon_CSS");
		driver.navigate().refresh();

		// DELETE ALL THE PREVIOUSLY CREATED TASKS FROM MY TASK LIST
		title("DELETE ALL THE PREVIOUSLY CREATED TASKS FROM MY TASK LIST");

		try {

			// wait for the element
			Thread.sleep(5000);

			// click on the side menu
			click("menubtn_CSS");

			// wait for the element
			Thread.sleep(5000);

			// click on the my task option
			click("mytask_sidemenu_XPATH");

			// delete all the previously created tasks
			try {
				String pages = (driver
						.findElement(By.xpath(
								"//i[@ng-click='previousPageData()']//following-sibling::strong[@class='ng-binding']"))
						.getText()).trim();
				String[] arrOfStr = pages.split(" ");
				String pageno = arrOfStr[3];
				int pagecount = Integer.parseInt(pageno);

				for (int i = 0; i < pagecount; i++) {

					List<WebElement> roles = driver.findElements(By.xpath("//table[@id='tasksTable']//tbody//tr"));
					int rolesnum = roles.size();

					for (int j = 0; j < rolesnum; j++) {

						// wait for the element
						Thread.sleep(3000);

						// click on the action icon of the first record
						click("mytask_firstactionicon_XPATH");

						// wait for the element
						Thread.sleep(3000);

						// click on the delete option
						click("mytask_firstactionicon_deleteoption_XPATH");

						// wait for the element
						explicitWaitClickable("closetoastmsg_CSS");

						// click on the toaster close button
						click("closetoastmsg_CSS");

					}

					// click on the next button
					click("task_permission_roles_nextbtn_CSS");

				}
			} catch (Throwable t) {

				successMessage("Successfully deleted all the tasks.");

			}

		} catch (Throwable t) {
			verificationFailed();
		}

		// click on the home icon from the top of the screen
		click("questionnaire_homeburgermenubtn_hide_CSS");

		// synchronization
		explicitWait("propertylist_title_XPATH");

		// verify the property list
		switchVerification("propertylist_title_XPATH", "Property List", "The property list is not displayed.");

		// ADD RANDOM NUMBER OF THE TASK - WITH THE PREVENTATIVE MAINTENANCE TASK TAG
		title("ADD RANDOM NUMBER OF THE TASK - WITH THE PREVENTATIVE MAINTENANCE TASK TAG");

		Random random1 = new Random();
		int random11 = random1.nextInt(6 - 3) + 3;
		String taskTitle1 = RandomStringUtils.randomAlphabetic(8);

		try {

			// enter the property name in the search field
			type("envreports_propertylist_filtertxt_CSS", data.get("property_1"));

			// click on the task icon
			click("taskicon_CSS");

			for (int i = 0; i < random11; i++) {

				// click on the add task button
				click("task_addtaskbtn_CSS");

				// enter the data in the task title field
				type("task_addtask_titletxt_CSS", taskTitle1);

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
				scrollBottom();

				// synchronization
				explicitWait("task_addtask_moduledd_CSS");

				// select the environmental option from the module dropdown
				select("task_addtask_moduledd_CSS", data.get("task_module"));

				// click on the task tag button
				click("mytask_task_tasktagbtn_XPATH");

				// click on the none button
				click("task_tasktag_nonebtn_CSS");

				// type the task tag in the search field
				type("task_tasktag_searchtxt_CSS", data.get("tasktag_1"));

				// click on the searched result
				click("mytask_task_tasktagbtn_searchedresult1_XPATH");

				// click on the task tag button
				click("mytask_task_tasktagbtn_XPATH");

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
				type("task_filter_CSS", taskTitle1);

				// click on the search button
				click("task_createdtask_searchbtn_XPATH");

				try {
					String task1 = "//p[contains(text(),'" + taskTitle1 + "')]";

					boolean task11 = driver.findElement(By.xpath(task1)).isDisplayed();

					if (task11 == true) {

						successMessage("The respective task is displayed successfully.");

					} else {
						verificationFailedMessage("The task in not displayed.");
					}

				} catch (Throwable t) {
					verificationFailedMessage("The task in not displayed.");
				}
			}
		} catch (Throwable t) {
			verificationFailed();
		}

		// click on the home icon from the top of the screen
		click("questionnaire_homeburgermenubtn_hide_CSS");

		// synchronization
		explicitWait("propertylist_title_XPATH");

		// verify the property list
		switchVerification("propertylist_title_XPATH", "Property List", "The property list is not displayed.");

		// ADD RANDOM NUMBER OF THE TASK - WITH THE AUTOMATION TAG TASK TAG
		title("ADD RANDOM NUMBER OF THE TASK - WITH THE AUTOMATION TAG TASK TAG");

		Random random2 = new Random();
		int random22 = random2.nextInt(6 - 3) + 3;
		String taskTitle2 = RandomStringUtils.randomAlphabetic(8);

		try {

			// enter the property name in the search field
			type("envreports_propertylist_filtertxt_CSS", data.get("property_1"));

			// click on the task icon
			click("taskicon_CSS");

			for (int i = 0; i < random22; i++) {

				// click on the add task button
				click("task_addtaskbtn_CSS");

				// enter the data in the task title field
				type("task_addtask_titletxt_CSS", taskTitle2);

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
				scrollBottom();

				// synchronization
				explicitWait("task_addtask_moduledd_CSS");

				// select the environmental option from the module dropdown
				select("task_addtask_moduledd_CSS", data.get("task_module"));

				// click on the task tag button
				click("mytask_task_tasktagbtn_XPATH");

				// click on the none button
				click("task_tasktag_nonebtn_CSS");

				// type the task tag in the search field
				type("task_tasktag_searchtxt_CSS", data.get("tasktag_2"));

				// click on the searched result
				click("mytask_task_tasktagbtn_searchedresult2_XPATH");

				// click on the task tag button
				click("mytask_task_tasktagbtn_XPATH");

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
				type("task_filter_CSS", taskTitle2);

				// click on the search button
				click("task_createdtask_searchbtn_XPATH");

				try {
					String task2 = "//p[contains(text(),'" + taskTitle2 + "')]";

					boolean task22 = driver.findElement(By.xpath(task2)).isDisplayed();

					if (task22 == true) {

						successMessage("The respective task is displayed successfully.");

					} else {
						verificationFailedMessage("The task in not displayed.");
					}

				} catch (Throwable t) {
					verificationFailedMessage("The task in not displayed.");
				}
			}
		} catch (Throwable t) {
			verificationFailed();
		}

		// click on the home icon from the top of the screen
		click("questionnaire_homeburgermenubtn_hide_CSS");

		// synchronization
		explicitWait("propertylist_title_XPATH");

		// verify the property list
		switchVerification("propertylist_title_XPATH", "Property List", "The property list is not displayed.");

		// ADD RANDOM NUMBER OF THE TASK - WITH THE Corrective Action TASK TAG
		title("ADD RANDOM NUMBER OF THE TASK - WITH THE Corrective Action TASK TAG");

		Random random3 = new Random();
		int random33 = random3.nextInt(6 - 3) + 3;
		String taskTitle3 = RandomStringUtils.randomAlphabetic(8);

		try {

			// enter the property name in the search field
			type("envreports_propertylist_filtertxt_CSS", data.get("property_1"));

			// click on the task icon
			click("taskicon_CSS");

			for (int i = 0; i < random33; i++) {

				// click on the add task button
				click("task_addtaskbtn_CSS");

				// enter the data in the task title field
				type("task_addtask_titletxt_CSS", taskTitle3);

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
				scrollBottom();

				// synchronization
				explicitWait("task_addtask_moduledd_CSS");

				// select the environmental option from the module dropdown
				select("task_addtask_moduledd_CSS", data.get("task_module"));

				// click on the task tag button
				click("mytask_task_tasktagbtn_XPATH");

				// click on the none button
				click("task_tasktag_nonebtn_CSS");

				// type the task tag in the search field
				type("task_tasktag_searchtxt_CSS", data.get("tasktag_3"));

				// click on the searched result
				click("mytask_task_tasktagbtn_searchedresult3_XPATH");

				// click on the task tag button
				click("mytask_task_tasktagbtn_XPATH");

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
				type("task_filter_CSS", taskTitle3);

				// click on the search button
				click("task_createdtask_searchbtn_XPATH");

				try {
					String task3 = "//p[contains(text(),'" + taskTitle3 + "')]";

					boolean task33 = driver.findElement(By.xpath(task3)).isDisplayed();

					if (task33 == true) {

						successMessage("The respective task is displayed successfully.");

					} else {
						verificationFailedMessage("The task in not displayed.");
					}

				} catch (Throwable t) {
					verificationFailedMessage("The task in not displayed.");
				}
			}
		} catch (Throwable t) {
			verificationFailed();
		}

		// click on the home icon from the top of the screen
		click("questionnaire_homeburgermenubtn_hide_CSS");

		// synchronization
		explicitWait("propertylist_title_XPATH");

		// verify the property list
		switchVerification("propertylist_title_XPATH", "Property List", "The property list is not displayed.");

		// ADD RANDOM NUMBER OF THE TASK - WITH THE Preventative Maintenance TASK TAG
		title("ADD RANDOM NUMBER OF THE TASK - WITH THE Preventative Maintenance TASK TAG");

		Random random4 = new Random();
		int random44 = random4.nextInt(6 - 3) + 3;
		String taskTitle4 = RandomStringUtils.randomAlphabetic(8);

		try {

			// enter the property name in the search field
			type("envreports_propertylist_filtertxt_CSS", data.get("property_1"));

			// click on the task icon
			click("taskicon_CSS");

			for (int i = 0; i < random44; i++) {

				// click on the add task button
				click("task_addtaskbtn_CSS");

				// enter the data in the task title field
				type("task_addtask_titletxt_CSS", taskTitle4);

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
				scrollBottom();

				// synchronization
				explicitWait("task_addtask_moduledd_CSS");

				// select the environmental option from the module dropdown
				select("task_addtask_moduledd_CSS", data.get("task_module"));

				// click on the task tag button
				click("mytask_task_tasktagbtn_XPATH");

				// click on the none button
				click("task_tasktag_nonebtn_CSS");

				// type the task tag in the search field
				type("task_tasktag_searchtxt_CSS", data.get("tasktag_4"));

				// click on the searched result
				click("mytask_task_tasktagbtn_searchedresult4_XPATH");

				// click on the task tag button
				click("mytask_task_tasktagbtn_XPATH");

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
				type("task_filter_CSS", taskTitle4);

				// click on the search button
				click("task_createdtask_searchbtn_XPATH");

				try {
					String task4 = "//p[contains(text(),'" + taskTitle4 + "')]";

					boolean task44 = driver.findElement(By.xpath(task4)).isDisplayed();

					if (task44 == true) {

						successMessage("The respective task is displayed successfully.");

					} else {
						verificationFailedMessage("The task in not displayed.");
					}

				} catch (Throwable t) {
					verificationFailedMessage("The task in not displayed.");
				}
			}
		} catch (Throwable t) {
			verificationFailed();
		}

		// click on the home icon from the top of the screen
		click("questionnaire_homeburgermenubtn_hide_CSS");

		// synchronization
		explicitWait("propertylist_title_XPATH");

		// verify the property list
		switchVerification("propertylist_title_XPATH", "Property List", "The property list is not displayed.");

		// VALIDATE THE TASK RECORDS IN THE MY TASK LIST AND EXPORTED FILE WITH FILTERED
		// RESULT
		title("VALIDATE THE TASK RECORDS IN THE MY TASK LIST AND EXPORTED FILE WITH FILTERED RESULT");

		try {

			// wait for the element
			Thread.sleep(5000);

			// click on the side menu
			click("menubtn_CSS");

			// wait for the element
			Thread.sleep(5000);

			// click on the my task option
			click("mytask_sidemenu_XPATH");

			// wait for the element
			Thread.sleep(5000);

			// click on the tags field
			click("mytask_filters_tags_XPATH");

			// click on the none button
			click("task_tasktag_nonebtn_CSS");

			// enter the task tag in the search field
			type("task_tasklist_tagfilter_tagtxt_searchtxt_XPATH", data.get("tasktag_3"));

			// click on the searched result
			click("mytask_task_tasktagbtn_searchedresult3_XPATH");

			// wait for the element
			Thread.sleep(5000);

			// click on the tags field
			click("mytask_filters_tags_XPATH");

			// validate the count of the record after applied the filter
			try {
				List<WebElement> taskList = driver.findElements(By.xpath("//table[@id='tasksTable']//tbody//tr"));
				int taskList_count = taskList.size();

				if (taskList_count == random33) {

					successMessage("The count of the records is displayed correct.");

				} else {

					verificationFailedMessage("The count of the records is not displayed correctly.");

				}
			} catch (Throwable t) {
				verificationFailed();
			}

			// click on the export button
			click("mytask_exportbtn_XPATH");

			// click on the export button of the confirmation popup
			click("mytask_exportbtn_confirmation_XPATH");

			// fetch the record from the download file
			File downloaded = getLastModified(config.getProperty("downloadFilePath"));
			String path_string = downloaded.toString();
			consoleMessage(path_string);

			ExcelReader file = new ExcelReader(path_string);

			// validate the count of the row is displayed correctly or not
			try {
				int actualRowCount = file.getRowCount("Sheet0");
				if ((actualRowCount - 1) == random33) {

					successMessage("The task count is displayed correctly.");

				} else {
					verificationFailedMessage("The task count is not displayed correctly.");
				}
			} catch (Throwable t) {
				verificationFailedMessage("The task count is not displayed correctly.");
			}

		} catch (Throwable t) {
			verificationFailed();
		}

		// click on the home icon from the top of the screen
		click("questionnaire_homeburgermenubtn_hide_CSS");

		// synchronization
		explicitWait("propertylist_title_XPATH");

		// verify the property list
		switchVerification("propertylist_title_XPATH", "Property List", "The property list is not displayed.");

		// VALIDATE THE TASK RECORDS IN THE MY TASK LIST AND EXPORTED FILE WITHOUT
		// FILTERED RESULT
		title("VALIDATE THE TASK RECORDS IN THE MY TASK LIST AND EXPORTED FILE WITHOUT FILTERED RESULT");

		try {

			// wait for the element
			Thread.sleep(5000);

			// click on the side menu
			click("menubtn_CSS");

			// wait for the element
			Thread.sleep(5000);

			// click on the my task option
			click("mytask_sidemenu_XPATH");

			// wait for the element
			Thread.sleep(5000);

			// click on the tags field
			click("mytask_filters_tags_XPATH");

			// click on the none button
			click("task_tasktag_nonebtn_CSS");

			// wait for the element
			Thread.sleep(5000);

			// click on the tags field
			click("mytask_filters_tags_XPATH");

			// click on the export button
			click("mytask_exportbtn_XPATH");

			// click on the export button of the confirmation popup
			click("mytask_exportbtn_confirmation_XPATH");

			// fetch the record from the download file
			File downloaded = getLastModified(config.getProperty("downloadFilePath"));
			String path_string = downloaded.toString();
			consoleMessage(path_string);

			ExcelReader file = new ExcelReader(path_string);

			// validate the count of the row is displayed correctly or not
			try {

				int expectedRowCount = random11 + random22 + random33 + random44;
				int actualRowCount = file.getRowCount("Sheet0");
				if ((actualRowCount - 1) == expectedRowCount) {

					successMessage("The total task count is displayed correctly.");

				} else {
					verificationFailedMessage("The total task count is not displayed correctly.");
				}
			} catch (Throwable t) {
				verificationFailedMessage("The total task count is not displayed correctly.");
			}

		} catch (Throwable t) {
			verificationFailed();
		}

		// click on the home icon from the top of the screen
		click("questionnaire_homeburgermenubtn_hide_CSS");

		// synchronization
		explicitWait("propertylist_title_XPATH");

		// verify the property list
		switchVerification("propertylist_title_XPATH", "Property List", "The property list is not displayed.");

		// DELETE ALL THE PREVIOUSLY CREATED TASKS FROM MY TASK LIST
		title("DELETE ALL THE PREVIOUSLY CREATED TASKS FROM MY TASK LIST");

		try {

			// wait for the element
			Thread.sleep(5000);

			// click on the side menu
			click("menubtn_CSS");

			// wait for the element
			Thread.sleep(5000);

			// click on the my task option
			click("mytask_sidemenu_XPATH");

			// delete all the previously created tasks
			try {
				String pages = (driver
						.findElement(By.xpath(
								"//i[@ng-click='previousPageData()']//following-sibling::strong[@class='ng-binding']"))
						.getText()).trim();
				String[] arrOfStr = pages.split(" ");
				String pageno = arrOfStr[3];
				int pagecount = Integer.parseInt(pageno);

				for (int i = 0; i < pagecount; i++) {

					List<WebElement> roles = driver.findElements(By.xpath("//table[@id='tasksTable']//tbody//tr"));
					int rolesnum = roles.size();

					for (int j = 0; j < rolesnum; j++) {

						// wait for the element
						Thread.sleep(3000);

						// click on the action icon of the first record
						click("mytask_firstactionicon_XPATH");

						// wait for the element
						Thread.sleep(3000);

						// click on the delete option
						click("mytask_firstactionicon_deleteoption_XPATH");

						// wait for the element
						explicitWaitClickable("closetoastmsg_CSS");

						// click on the toaster close button
						click("closetoastmsg_CSS");

					}

					// click on the next button
					click("task_permission_roles_nextbtn_CSS");

				}
			} catch (Throwable t) {

				successMessage("Successfully deleted all the tasks.");

			}

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
