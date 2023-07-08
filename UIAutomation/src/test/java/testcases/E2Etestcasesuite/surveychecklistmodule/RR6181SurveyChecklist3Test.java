package testcases.E2Etestcasesuite.surveychecklistmodule;

import java.io.IOException;
import java.time.LocalDate;
import java.util.Hashtable;
import java.util.List;

import org.apache.commons.lang3.RandomStringUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.Reporter;
import org.testng.SkipException;
import org.testng.annotations.Test;

import com.relevantcodes.extentreports.LogStatus;

import base.Helper;
import base.TestBase;
import utilities.TestUtil;

public class RR6181SurveyChecklist3Test extends TestBase {

	@Test(dataProviderClass = TestUtil.class, dataProvider = "dp")
	public void rR6181SurveyChecklist3Test(Hashtable<String, String> data) throws IOException, InterruptedException {

		execution(data, "rR6181SurveyChecklist3Test");

		// CREATE THE CHECKLIST IN PROPERTY AND PERFORM THE VARIOUS ACTIONS ON THE NEWLY
		// CREATED TASK WITH ADD TASK OPTION IN THE INSPECTION
		title("CREATE THE CHECKLIST IN PROPERTY AND PERFORM THE VARIOUS ACTIONS ON THE NEWLY CREATED TASK WITH ADD TASK OPTION IN THE INSPECTION.");

		Helper helper = new Helper();

		// refresh the page
		driver.navigate().refresh();
		Thread.sleep(5000);
		driver.navigate().refresh();

		// ADD NEW QUESTIONNIRE FOR INSPECTION
		title("ADD NEW QUESTIONNIRE FOR INSPECTION");

		try {
			// wait for the element
			explicitWaitClickable("questionnaire_settingicon_CSS");

			// click on the settings icon from the top of the screen
			click("questionnaire_settingicon_CSS");

			// wait for the element
			explicitWaitClickable("questionnaire_administrationoption_XPATH");

			// click on the Administration option from the side menu
			click("questionnaire_administrationoption_XPATH");

			// click on the Questionnaires tab
			click("questionnaire_questionnairestab_XPATH");

			// click on the Questionnaires option
			click("questionnaire_questionnairesoption_XPATH");

			// click on the new questionnaire
			click("questionnaire_newquestionnairebtn_CSS");

			// Select the Inspection / Checklist of the questionnaire
			click("questionnaire_type_inspectionbtn_CSS");

			// Select the level of the questionnaire
			click("questionnaire_level_propertybtn_CSS");

			// enter the group title
			type("questionnaire_grouptitletxt_CSS", data.get("group_title"));

			// enter the questionnaire title
			type("questionnaire_languagetitle_CSS", data.get("questionnaire_checklist_title"));

			// select the model
			select("questionnaire_modeldd_CSS", data.get("model"));

			// select the frequency
			select("questionnaire_frequencydd_CSS", data.get("frequency"));

			// enter frequency interval
			type("questionnaire_frequencyintervaltxt_CSS", "1");

			// select the month
			select("questionnaire_monthtxt_CSS", data.get("month"));

			// enter the description
			type("questionnaire_descriptiontxt_CSS", data.get("description"));

			// select the classic option from the default view drop down
			select("questionnaire_checklist_defaultview_CSS", data.get("default_view"));

			// scroll down to the save button
			scrollBottom();

			// click on the save button
			click("questionnaire_savebtn_BTNTEXT");

			// enter newly created questionnaire in the filter field
			type("ssc_company2_questionnairelist_filtertxt_CSS", data.get("questionnaire_checklist_title"));

			// verify newly created questionnaire for checklist
			switchVerification("questionnaire_addtaskoption3_XPATH", "Questionnaire Add Task Option Three Title",
					"The Questionnaire Add Task Option Three Title record is not displayed in the questionnaire list.");

			// CONFIGRATION OF QUESTION
			title("CONFIGRATION OF QUESTION");

			// click on the created questionnaire
			click("questionnaire_addtaskoption3_XPATH");

			helper.configureQuestions(data);

			// enter newly created questionnaire in the filter field
			type("ssc_company2_questionnairelist_filtertxt_CSS", data.get("questionnaire_checklist_title"));

			// verify newly created questionnaire for checklist
			switchVerification("questionnaire_addtaskoption3_XPATH", "Questionnaire Add Task Option Three Title",
					"The Questionnaire Add Task Option Three Title record is not displayed in the questionnaire list.");

		} catch (Throwable t) {
			verificationFailed();
		}

		// click on the Home Icon from the top of the screen
		click("questionnaire_homeburgermenubtn_CSS");

		// wait for the element
		explicitWait("propertylist_title_XPATH");

		// verify the property list
		switchVerification("propertylist_title_XPATH", "Property List", "The property list is not displayed.");

		// CREATE INSPECTION AT PROPERTY LEVEL
		title("CREATE INSPECTION AT PROPERTY LEVEL");

		try {
			// click on the environmental icon from the property list page
			click("environmentalicon_CSS");

			// wait for the element
			explicitWaitClickable("menubtn_CSS");

			// click on the burger menu
			click("menubtn_CSS");

			// wait for the element
			Thread.sleep(5000);

			// click on the checklist/inspection option from side menu
			click("checklist_sidemenu_XPATH");

			// select the property level from the dropdown
			select("survey_leveldropdown_CSS", data.get("property_leveldropdown"));

			// click on the new checklist button
			click("checklist_newchecklistbtn_CSS");

			try {
				// wait for the element
				explicitWait("checklist_addchecklist_checklisttypedd_CSS");

				// collect all options of the dropdown
				Select dropdown = new Select(driver
						.findElement(By.cssSelector(OR.getProperty("checklist_addchecklist_checklisttypedd_CSS"))));

				// Get all options
				List<WebElement> dd = dropdown.getOptions();

				// Loop to print one by one
				for (int j = 0; j < dd.size(); j++) {
					String checklist = dd.get(j).getText();
					try {
						if (checklist.equals(data.get("questionnaire_checklist_title"))) {
							successMessage("The checklist is displayed successfully.");

							// select the questionnaire option from the checklist type dropdown
							select("checklist_addchecklist_checklisttypedd_CSS",
									data.get("questionnaire_checklist_title"));

							// enter data in the checklist title field
							type("checklist_addchecklist_titletxt_CSS", data.get("checklist_property_title"));

							// click on the save button
							click("checklist_addchecklist_savebtn_CSS");

							// verify questionnaire is selected correctly or not
							switchVerification("questionnaire_questiontitle_XPATH", "Test Category Title One",
									"The Test Category Title One is not displayed.");

						}
					} catch (Throwable t) {

						verificationFailedMessage(" The " + data.get("questionnaire_checklist_title")
								+ " is not displayed in the dropdown.");

						// click on the close button of the add checklist popup
						click("checklist_addchecklist_dltbtn_XPATH");

					}
				}
			} catch (Throwable t) {
				verificationFailed();
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

		// VALIDATE THE ADD TASK OPTION AND CREATE THE TASK FOR THE CATEGORY ONE OF THE
		// INSPECTION
		title("VALIDATE THE ADD TASK OPTION AND CREATE THE TASK FOR THE CATEGORY ONE OF THE INSPECTION");

		String randomTaskTitle = RandomStringUtils.randomAlphabetic(8);
		String updateRandomTaskTitle = RandomStringUtils.randomAlphabetic(8);

		try {
			// click on the environmental icon from the property list page
			click("environmentalicon_CSS");

			// wait for the element
			explicitWaitClickable("menubtn_CSS");

			// click on the burger menu
			click("menubtn_CSS");

			// wait for the element
			Thread.sleep(5000);

			// click on the checklist/inspection option from side menu
			click("checklist_sidemenu_XPATH");

			// enter the inspection name in the search field
			type("sustainability_searchtxt_XPATH", data.get("checklist_property_title"));

			// click on the newly searched inspection
			String inspection = "//td[text()='" + data.get("checklist_property_title") + "']";
			driver.findElement(By.xpath(inspection)).click();

			// scroll to the category one
			scrollTillElement("questionnaire_inspection_category1_addtask_actionicon_XPATH");

			// click on the action icon of the category one
			click("questionnaire_inspection_category1_addtask_actionicon_XPATH");

			// click on the add task option
			click("questionnaire_inspection_category1_addtaskoption_XPATH");

			// enter the valid task title
			type("checklist_wizard_tasktitle_XPATH", randomTaskTitle);

			// click on the assign to field
			click("questionnaire_inspection_addtask_assigntotxt_XPATH");

			// click on the none button
			click("checklist_wizard_task_nonebtn_XPATH");

			// enter the user name in the search field
			type("checklist_wizard_task_assignedtosearchtxt_XPATH", data.get("username"));

			// click on the searched user
			click("checklist_wizard_task_assignedtosearchedresult_XPATH");

			// click on the assign to field
			click("questionnaire_inspection_addtask_assigntotxt_XPATH");

			// click on the save button
			click("questionnaire_inspection_addtask_savebtn_XPATH");

			// wait for the element
			explicitWaitClickable("closetoastmsg_CSS");

			// click on the toaster close button
			click("closetoastmsg_CSS");

		} catch (Throwable t) {
			verificationFailed();
		}

		// click on the home icon from the top of the screen
		click("questionnaire_homeburgermenubtn_hide_CSS");

		// wait for the element
		explicitWait("propertylist_title_XPATH");

		// verify the property list
		switchVerification("propertylist_title_XPATH", "Property List", "The property list is not displayed.");

		// PERFORM THE ACTIONS OF THE TASK FROM THE INSPECTION
		title("PERFORM THE ACTIONS OF THE TASK FROM THE INSPECTION");

		try {
			// click on the environmental icon from the property list page
			click("environmentalicon_CSS");

			// wait for the element
			explicitWaitClickable("menubtn_CSS");

			// click on the burger menu
			click("menubtn_CSS");

			// wait for the element
			Thread.sleep(5000);

			// click on the checklist/inspection option from side menu
			click("checklist_sidemenu_XPATH");

			// enter the inspection name in the search field
			type("sustainability_searchtxt_XPATH", data.get("checklist_property_title"));

			// click on the newly searched inspection
			String inspection = "//td[text()='" + data.get("checklist_property_title") + "']";
			driver.findElement(By.xpath(inspection)).click();

			// scroll to the category one
			scrollTillElement("questionnaire_inspection_category1_addtask_actionicon_XPATH");

			// validate the count of the task
			String taskStatement1 = (driver
					.findElement(
							By.xpath(OR.getProperty("questionnaire_inspection_category1_classicview_taskcount_XPATH")))
					.getText()).trim();
			String[] taskStatement1_arr = taskStatement1.split(" ");
			String taskCounts1 = taskStatement1_arr[0];

			if (taskCounts1.equals("1")) {
				successMessage("THE COUNT OF TASKS FOR THE CATEGORY ONE IN THE CLASSIC VIEW IS DISPLAYED CORRECTLY.");
			} else {
				verificationFailedMessage(
						"THE COUNT OF TASKS FOR THE CATEGORY ONE IN THE CLASSIC VIEW IS NOT DISPLAYED CORRECTLY.");
			}

			// UPDATE THE TASK DETAILS WITH THE UPDATE TASK DETAILS OPTION
			title("UPDATE THE TASK DETAILS WITH THE UPDATE TASK DETAILS OPTION");

			// click on the action icon
			click("questionnaire_inspection_tasks_actionicon_XPATH");

			// click on the update task detail option
			click("questionnaire_inspection_tasks_updatetaskdetailsoption_XPATH");

			// update the valid task title
			type("checklist_wizard_tasktitle_XPATH", updateRandomTaskTitle);

			// enter the location
			type("questionnaire_inspection_tasks_locationtxt_XPATH", data.get("location_update"));

			// click on the assign to field
			click("questionnaire_inspection_addtask_assigntotxt_XPATH");

			// click on the none button
			click("checklist_wizard_task_nonebtn_XPATH");

			// enter the user name in the search field
			type("checklist_wizard_task_assignedtosearchtxt_XPATH", data.get("username_update"));

			// click on the searched user
			click("checklist_wizard_task_updatedassignedtosearchedresult_XPATH");

			// click on the assign to field
			click("questionnaire_inspection_addtask_assigntotxt_XPATH");

			// click on the update button
			click("questionnaire_inspection_tasks_updatebtn_XPATH");

			// wait for the element
			explicitWaitClickable("closetoastmsg_CSS");

			// click on the toaster close button
			click("closetoastmsg_CSS");

			// scroll to the category one
			scrollTop();

			try {
				// validate the updated task title
				String updatedTaskTitle_XPATH = "//label[@ng-click='loadSelectedQuestionnaireCategoryTaskDetails(task, false);']";
				String updatedTaskTitle = (driver.findElement(By.xpath(updatedTaskTitle_XPATH)).getText()).trim();
				System.out.println("Added Task Name: " + updatedTaskTitle);

				if (updatedTaskTitle.equals(updateRandomTaskTitle)) {
					successMessage("The updated task title is displayed correctly.");
				} else {
					verificationFailedMessage("The updated task title is not displayed correctly.");
				}

			} catch (Throwable t) {
				verificationFailed();
			}

			try {
				// validate the updated location
				String updatedLocation_XPATH = "//p[text()='" + data.get("location_update") + "']";
				String updatedLocation = (driver.findElement(By.xpath(updatedLocation_XPATH)).getText()).trim();

				if (updatedLocation.equals(data.get("location_update"))) {
					successMessage("The updated location is displayed correctly.");
				} else {
					verificationFailedMessage("The updated location is not displayed correctly.");
				}

			} catch (Throwable t) {
				verificationFailed();
			}

			try {
				// validate the updated assign to
				String updatedAssignTo_XPATH = "//p[text()='" + data.get("username_update") + "']";
				String updatedAssignTo = (driver.findElement(By.xpath(updatedAssignTo_XPATH)).getText()).trim();

				if (updatedAssignTo.equals(data.get("username_update"))) {
					successMessage("The updated assign to is displayed correctly.");
				} else {
					verificationFailedMessage("The updated assign to is not displayed correctly.");
				}

			} catch (Throwable t) {
				verificationFailed();
			}

			try {
				// validate the status
				String updatedStatus_XPATH = "//p[text()='" + data.get("status_pending") + "']";
				String updatedStatus = (driver.findElement(By.xpath(updatedStatus_XPATH)).getText()).trim();

				if (updatedStatus.equals(data.get("status_pending"))) {
					successMessage("The status is displayed correctly.");
				} else {
					verificationFailedMessage("The status is not displayed correctly.");
				}

			} catch (Throwable t) {
				verificationFailed();
			}

			// UPDATE THE DUE DATE WITH THE CHANGE DUE DATE OPTION
			title("UPDATE THE DUE DATE WITH THE CHANGE DUE DATE OPTION");

			// scroll to the category one
			scrollTop();

			// click on the action icon
			click("questionnaire_inspection_tasks_actionicon_XPATH");

			// click on the change due date option
			click("questionnaire_inspection_tasks_changeduedateoption_XPATH");

			// enter future date in the new due date field
			LocalDate futureDate = LocalDate.now().plusDays(10);
			String futureDate_string = futureDate.toString();
			type("questionnaire_inspection_tasks_newduedatetxt_XPATH", futureDate_string);

			// click on the apply button
			click("questionnaire_inspection_tasks_applybtn_XPATH");

			// wait for the element
			explicitWaitClickable("closetoastmsg_CSS");

			// click on the toaster close button
			click("closetoastmsg_CSS");

			// click on the action icon
			click("questionnaire_inspection_tasks_actionicon_XPATH");

			// click on the update task detail option
			click("questionnaire_inspection_tasks_updatetaskdetailsoption_XPATH");

			try {
				// validate the update due date
				String updatedDueDate = (driver
						.findElement(By.xpath(OR.getProperty("questionnaire_inspection_tasks_duedatetxt_XPATH")))
						.getAttribute("value")).trim();

				if (updatedDueDate.equals(futureDate_string)) {

					successMessage("The updated due date is displayed correctly.");

					// click on the back button
					click("questionnaire_inspection_tasks_backbtn_XPATH");

				} else {
					verificationFailedMessage("The updated due date is not displayed correctly.");

					// click on the back button
					click("questionnaire_inspection_tasks_backbtn_XPATH");
				}

			} catch (Throwable t) {
				verificationFailedMessage("The updated due date is not displayed correctly.");

				// click on the back button
				click("questionnaire_inspection_tasks_backbtn_XPATH");
			}

			// UPDATE THE AASIGNEE OF THE TASK WITH THE ASSIGN TASK OPTION
			title("UPDATE THE AASIGNEE OF THE TASK WITH THE ASSIGN TASK OPTION");

			// scroll to the category one
			scrollTop();

			// click on the action icon
			click("questionnaire_inspection_tasks_actionicon_XPATH");

			// click on the assign task option
			click("questionnaire_inspection_tasks_assigntaskoption_XPATH");

			// click on the assign to field
			click("questionnaire_inspection_tasks_assigntask_assigntotxt_XPATH");

			// click on the none button
			click("checklist_wizard_task_nonebtn_XPATH");

			// enter user name in search field
			type("questionnaire_inspection_tasks_assigntask_searchtxt_XPATH", data.get("username_update2"));

			// click on the searched user
			click("questionnaire_inspection_tasks_assigntask_searcheduser_XPATH");

			// click on the assign to field
			click("questionnaire_inspection_tasks_assigntask_assigntotxt_XPATH");

			// click on the update button
			click("questionnaire_inspection_tasks_assigntask_updatebtn_XPATH");

			// wait for the element
			explicitWaitClickable("closetoastmsg_CSS");

			// click on the toaster close button
			click("closetoastmsg_CSS");

			// wait for the element
			Thread.sleep(5000);

			// scroll to the category one
			scrollTop();

			// validate the updated assign to
			try {
				String updatedAssignTo1_XPATH = "//p[text()='" + data.get("username_update2") + "']";
				String updatedAssignTo1 = (driver.findElement(By.xpath(updatedAssignTo1_XPATH)).getText()).trim();

				if (updatedAssignTo1.equals(data.get("username_update2"))) {
					successMessage("The updated assign to is displayed correctly.");
				} else {
					verificationFailedMessage("The updated assign to is not displayed correctly.");
				}

			} catch (Throwable t) {
				verificationFailed();
			}

			// UPDATE THE TASK COMMENT WITH THE TASK COMMENTS OPTION
			title("UPDATE THE TASK COMMENT WITH THE TASK COMMENTS OPTION");

			// scroll to the category one
			scrollTop();

			// click on the action icon
			click("questionnaire_inspection_tasks_actionicon_XPATH");

			// click on the task comments option
			click("questionnaire_inspection_tasks_taskcommentsoption_XPATH");

			// click on the add comment button
			click("questionnaire_inspection_tasks_taskcomments_addcomment_XPATH");

			// enter the text in the comment field
			type("questionnaire_inspection_tasks_taskcomments_commenttxt_XPATH", data.get("task_comment"));

			// click on the add button
			click("questionnaire_inspection_tasks_taskcomments_addbtn_XPATH");

			// verify added task comment is displayed or not
			switchVerification("questionnaire_inspection_tasks_taskcomments_createdtaskcomment_XPATH",
					data.get("task_comment"), "The newly added task comment is not displayed.");

			// click on the back to task button
			click("questionnaire_inspection_tasks_taskcomments_backtotaskbtn_XPATH");

			// SELECT THE SHARE BY EMAIL OPTION
			title("SELECT THE SHARE BY EMAIL OPTION");

			// scroll to the category one
			scrollTop();

			// click on the action icon
			click("questionnaire_inspection_tasks_actionicon_XPATH");

			// click on the share by email option
			click("questionnaire_inspection_tasks_sharebyemailoption_XPATH");

			// wait for the element
			Thread.sleep(5000);

			// click on the recipient field
			click("questionnaire_inspection_tasks_sharebyemail_recipienttxt_XPATH");

			// click on the none button
			click("checklist_wizard_task_nonebtn_XPATH");

			// enter the user name in the search field
			type("questionnaire_inspection_tasks_assigntask_searchtxt_XPATH", data.get("username_update"));

			// click on the searched user name
			click("checklist_wizard_task_updatedassignedtosearchedresult_XPATH");

			// click on the recipient field
			click("questionnaire_inspection_tasks_sharebyemail_recipienttxt_XPATH");

			// click on the send button
			click("questionnaire_inspection_tasks_sharebyemail_sendbtn_XPATH");

			// wait for the element
			explicitWaitClickable("closetoastmsg_CSS");

			// click on the toaster close button
			click("closetoastmsg_CSS");

//			// SELECT THE ATTACHMENTS/PHOTOS OPTION
//			title("SELECT THE ATTACHMENTS/PHOTOS OPTION");
//
//			// scroll to the category one
//			scrollTop();
//
//			// click on the action icon
//			click("questionnaire_inspection_tasks_actionicon_XPATH");
//
//			// click on the share by attachments/photos option
//			click("questionnaire_inspection_tasks_attachmentsoption_XPATH");
//
//			// click on the upload file button
//			click("questionnaire_inspection_tasks_attachments_uploadbtn_XPATH");
//
//			// ************** MISSING CODE - ADD FILE UPLOAD CODE **************
//
//			// wait for the element
//			explicitWaitClickable("closetoastmsg_CSS");
//
//			// click on the toaster close button
//			click("closetoastmsg_CSS");
//
//			// click on the back to task button
//			click("questionnaire_inspection_tasks_attachments_backtotaskbtn_XPATH");			 

			// SELECT THE COMPLETE TASK OPTION
			title("SELECT THE COMPLETE TASK OPTION");

			// scroll to the category one
			scrollTop();

			// click on the action icon
			click("questionnaire_inspection_tasks_actionicon_XPATH");

			// click on the complete task option
			click("questionnaire_inspection_tasks_completetaskoption_XPATH");

			// wait for the element
			explicitWaitClickable("closetoastmsg_CSS");

			// click on the toaster close button
			click("closetoastmsg_CSS");

			// scroll to the category one
			scrollTop();

			// validate the task is displayed or not
			try {

				String updatedTaskTitle1_XPATH = "//label[@ng-click='loadSelectedQuestionnaireCategoryTaskDetails(task, false);']";
				String updatedTaskTitle1 = (driver.findElement(By.xpath(updatedTaskTitle1_XPATH)).getText()).trim();

				if (updatedTaskTitle1.equals(updateRandomTaskTitle)) {
					verificationFailedMessage("The task is displayed even if the task is completed successfully.");
				} else {
					successMessage("The task is not displayed, Because it's completed successfully.");
				}

			} catch (Throwable t) {
				successMessage("The task is not displayed, Because it's completed successfully.");
			}

			// click on the home icon from the top of the screen
			click("questionnaire_homeburgermenubtn_hide_CSS");

			// wait for the element
			explicitWait("propertylist_title_XPATH");

			// verify the property list
			switchVerification("propertylist_title_XPATH", "Property List", "The property list is not displayed.");

			// click on the task icon
			click("taskicon_CSS");

			// select the complete option from the status dropdown
			select("questionnaire_inspection_tasks_statusdd_XPATH", data.get("status_closed"));

			// click on the clear button
			click("task_createdtask_clearbtn_XPATH");

			// enter the data in the search field
			type("task_filter_CSS", updateRandomTaskTitle);

			// click on the search button
			click("task_createdtask_searchbtn_XPATH");

			try {
				// verify newly created task is displayed or not
				String closedStatus = "//p[text()='" + updateRandomTaskTitle
						+ "']//parent::td[@ng-click='editTaskFromLandingPage(task)']//following-sibling::td[text()='Closed']";
				String completedTask = (driver.findElement(By.xpath(closedStatus)).getText()).trim();

				if (completedTask.equals("Closed")) {
					successMessage("The closed task is displayed in the closed task list of task module.");
				} else {
					verificationFailedMessage(
							"The closed task is not displayed in the closed task list of task module.");
				}

			} catch (Throwable t) {
				verificationFailedMessage("The closed task is not displayed in the closed task list of task module.");
			}

			// click on the searched task
			String closedStatus = "//p[text()='" + updateRandomTaskTitle
					+ "']//parent::td[@ng-click='editTaskFromLandingPage(task)']//following-sibling::td[text()='Closed']";
			driver.findElement(By.xpath(closedStatus)).click();

			// click on the reopen button
			click("questionnaire_inspection_tasks_reopenbtn_XPATH");

			// wait for the element
			explicitWaitClickable("closetoastmsg_CSS");

			// click on the toaster close button
			click("closetoastmsg_CSS");

			// click on the home icon from the top of the screen
			click("questionnaire_homeburgermenubtn_hide_CSS");

			// wait for the element
			explicitWait("propertylist_title_XPATH");

			// verify the property list
			switchVerification("propertylist_title_XPATH", "Property List", "The property list is not displayed.");

			// click on the environmental icon from the property list page
			click("environmentalicon_CSS");

			// wait for the element
			explicitWaitClickable("menubtn_CSS");

			// click on the burger menu
			click("menubtn_CSS");

			// wait for the element
			Thread.sleep(5000);

			// click on the checklist/inspection option from side menu
			click("checklist_sidemenu_XPATH");

			// enter the inspection name in the search field
			type("sustainability_searchtxt_XPATH", data.get("checklist_property_title"));

			// click on the newly searched inspection
			String inspection1 = "//td[text()='" + data.get("checklist_property_title") + "']";
			driver.findElement(By.xpath(inspection1)).click();

			// scroll to the category one
			scrollTop();

			try {
				// validate the updated task title
				String updatedTaskTitle_XPATH = "//label[@ng-click='loadSelectedQuestionnaireCategoryTaskDetails(task, false);']";
				String updatedTaskTitle = (driver.findElement(By.xpath(updatedTaskTitle_XPATH)).getText()).trim();

				if (updatedTaskTitle.equals(updateRandomTaskTitle)) {
					successMessage("The updated task title is displayed correctly.");
				} else {
					verificationFailedMessage("The updated task title is not displayed correctly.");
				}

			} catch (Throwable t) {
				verificationFailed();
			}

			// SELECT THE CANCEL TASK OPTION
			title("SELECT THE CANCEL TASK OPTION");

			// scroll to the category one
			scrollTop();

			// click on the action icon
			click("questionnaire_inspection_tasks_actionicon_XPATH");

			// click on the cancel task option
			click("questionnaire_inspection_tasks_canceltaskoption_XPATH");

			// wait for the element
			explicitWaitClickable("closetoastmsg_CSS");

			// click on the toaster close button
			click("closetoastmsg_CSS");

			// scroll to the category one
			scrollTop();

			// validate the task is displayed or not
			try {

				String updatedTaskTitle1_XPATH = "//label[@ng-click='loadSelectedQuestionnaireCategoryTaskDetails(task, false);']";
				String updatedTaskTitle1 = (driver.findElement(By.xpath(updatedTaskTitle1_XPATH)).getText()).trim();

				if (updatedTaskTitle1.equals(updateRandomTaskTitle)) {
					verificationFailedMessage("The task is displayed even if the task is cancelled successfully.");
				} else {
					successMessage("The task is not displayed, Because it's cancelled successfully.");
				}

			} catch (Throwable t) {
				successMessage("The task is not displayed, Because it's cancelled successfully.");
			}

			// click on the home icon from the top of the screen
			click("questionnaire_homeburgermenubtn_hide_CSS");

			// wait for the element
			explicitWait("propertylist_title_XPATH");

			// verify the property list
			switchVerification("propertylist_title_XPATH", "Property List", "The property list is not displayed.");

			// click on the task icon
			click("taskicon_CSS");

			// select the complete option from the status dropdown
			select("questionnaire_inspection_tasks_statusdd_XPATH", data.get("status_closed"));

			// click on the clear button
			click("task_createdtask_clearbtn_XPATH");

			// enter the data in the search field
			type("task_filter_CSS", updateRandomTaskTitle);

			// click on the search button
			click("task_createdtask_searchbtn_XPATH");

			try {
				// verify newly created task is displayed or not
				String closedStatus1 = "//p[text()='" + updateRandomTaskTitle
						+ "']//parent::td[@ng-click='editTaskFromLandingPage(task)']//following-sibling::td[text()='Cancelled']";
				String calcelledTask1 = (driver.findElement(By.xpath(closedStatus1)).getText()).trim();

				if (calcelledTask1.equals("Cancelled")) {
					successMessage("The calcelled task is displayed in the closed task list of task module.");
				} else {
					verificationFailedMessage(
							"The calcelled task is not displayed in the closed task list of task module.");
				}

			} catch (Throwable t) {
				verificationFailedMessage(
						"The calcelled task is not displayed in the closed task list of task module.");
			}

			// click on the searched task
			String calcelledStatus1 = "//p[text()='" + updateRandomTaskTitle
					+ "']//parent::td[@ng-click='editTaskFromLandingPage(task)']//following-sibling::td[text()='Cancelled']";
			driver.findElement(By.xpath(calcelledStatus1)).click();

			// click on the reopen button
			click("questionnaire_inspection_tasks_reopenbtn_XPATH");

			// wait for the element
			explicitWaitClickable("closetoastmsg_CSS");

			// click on the toaster close button
			click("closetoastmsg_CSS");

			// click on the home icon from the top of the screen
			click("questionnaire_homeburgermenubtn_hide_CSS");

			// wait for the element
			explicitWait("propertylist_title_XPATH");

			// verify the property list
			switchVerification("propertylist_title_XPATH", "Property List", "The property list is not displayed.");

			// click on the environmental icon from the property list page
			click("environmentalicon_CSS");

			// wait for the element
			explicitWaitClickable("menubtn_CSS");

			// click on the burger menu
			click("menubtn_CSS");

			// wait for the element
			Thread.sleep(5000);

			// click on the checklist/inspection option from side menu
			click("checklist_sidemenu_XPATH");

			// enter the inspection name in the search field
			type("sustainability_searchtxt_XPATH", data.get("checklist_property_title"));

			// click on the newly searched inspection
			String inspection11 = "//td[text()='" + data.get("checklist_property_title") + "']";
			driver.findElement(By.xpath(inspection11)).click();

			// scroll to the category one
			scrollTop();

			try {
				// validate the updated task title
				String updatedTaskTitle_XPATH = "//label[@ng-click='loadSelectedQuestionnaireCategoryTaskDetails(task, false);']";
				String updatedTaskTitle = (driver.findElement(By.xpath(updatedTaskTitle_XPATH)).getText()).trim();

				if (updatedTaskTitle.equals(updateRandomTaskTitle)) {

					successMessage("The updated task title is displayed correctly.");

				} else {
					verificationFailedMessage("The updated task title is not displayed correctly.");
				}

			} catch (Throwable t) {
				verificationFailed();
			}

			// SELECT THE DELETE TASK OPTION
			title("SELECT THE DELETE TASK OPTION");

			// scroll to the category one
			scrollTop();

			// click on the action icon
			click("questionnaire_inspection_tasks_actionicon_XPATH");

			// click on the delete task option
			click("questionnaire_inspection_tasks_deletetaskoption_XPATH");

			// wait for the element
			explicitWaitClickable("closetoastmsg_CSS");

			// click on the toaster close button
			click("closetoastmsg_CSS");

			// scroll to the category one
			scrollTop();

			// validate the task is displayed or not
			try {

				String updatedTaskTitle2_XPATH = "//label[@ng-click='loadSelectedQuestionnaireCategoryTaskDetails(task, false);']";
				String updatedTaskTitle2 = (driver.findElement(By.xpath(updatedTaskTitle2_XPATH)).getText()).trim();

				if (updatedTaskTitle2.equals(updateRandomTaskTitle)) {

					verificationFailedMessage("The task is displayed even if the task is deleted successfully.");

				} else {

					successMessage("The task is not displayed, Because it's deleted successfully.");

				}

			} catch (Throwable t) {
				successMessage("The task is not displayed, Because it's deleted successfully.");
			}

			// click on the home icon from the top of the screen
			click("questionnaire_homeburgermenubtn_hide_CSS");

			// wait for the element
			explicitWait("propertylist_title_XPATH");

			// verify the property list
			switchVerification("propertylist_title_XPATH", "Property List", "The property list is not displayed.");

			// click on the task icon
			click("taskicon_CSS");

			// select the complete option from the status dropdown
			select("questionnaire_inspection_tasks_statusdd_XPATH", data.get("status_deleted"));

			// click on the clear button
			click("task_createdtask_clearbtn_XPATH");

			// enter the data in the search field
			type("task_filter_CSS", updateRandomTaskTitle);

			// click on the search button
			click("task_createdtask_searchbtn_XPATH");

			try {
				// verify newly created task is displayed or not
				String deletedStatus1 = "//p[text()='" + updateRandomTaskTitle + "']";
				boolean deletedTask1 = driver.findElement(By.xpath(deletedStatus1)).isDisplayed();

				if (deletedTask1 == true) {

					successMessage("The deleted task is displayed in the deleted task list of task module.");

				} else {

					verificationFailedMessage(
							"The deleted task is not displayed in the deleted task list of task module.");

				}

			} catch (Throwable t) {
				verificationFailedMessage("The deleted task is not displayed in the deleted task list of task module.");
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

		// DELETE THE NEWLY CREATED INSPECTION
		title("DELETE THE NEWLY CREATED INSPECTION");

		try {

			// click on the environmental icon from the property list page
			click("environmentalicon_CSS");

			// wait for the element
			Thread.sleep(5000);

			// click on the burger menu
			click("menubtn_CSS");

			// wait for the element
			Thread.sleep(5000);

			// click on the checklist/inspection option from side menu
			click("checklist_sidemenu_XPATH");

			// enter the inspection name in the search field
			type("sustainability_searchtxt_XPATH", data.get("checklist_property_title"));

			// click on the newly created inspection
			String inspection = "//td[text()='" + data.get("checklist_property_title")
					+ "']//following-sibling::td[@class='text-center pointer']//i[@id='action']";
			driver.findElement(By.xpath(inspection)).click();

			// click on the delete option
			String deleteOption = "//td[text()='" + data.get("checklist_property_title")
					+ "']//following-sibling::td[@class='text-center pointer']//div[@class='dropdown open']//li[@id='delete']";
			driver.findElement(By.xpath(deleteOption)).click();

			// wait for the element
			Thread.sleep(5000);

			// click on the delete button
			click("checklist_deletebtn_XPATH");

		} catch (Throwable t) {
			verificationFailed();
		}

		// click on the home option from the side menu
		click("questionnaire_homeburgermenubtn_hide_CSS");

		// wait for the element
		explicitWait("propertylist_title_XPATH");

		// verify the property list
		switchVerification("propertylist_title_XPATH", "Property List", "The property list is not displayed.");

		// DELETE THE NEWLY CREATED QUESTIONNAIRES
		title("DELETE THE NEWLY CREATED QUESTIONNAIRES");

		try {
			// wait for the element
			Thread.sleep(5000);

			// click on the settings icon from the top of the screen
			click("questionnaire_settingicon_CSS");

			// wait for the element
			explicitWaitClickable("questionnaire_administrationoption_XPATH");

			// click on the Administration option from the side menu
			click("questionnaire_administrationoption_XPATH");

			// click on the Questionnaires tab
			click("questionnaire_questionnairestab_XPATH");

			// click on the Questionnaires option
			click("questionnaire_questionnairesoption_XPATH");

			// enter newly created questionnaire in the filter field
			type("ssc_company2_questionnairelist_filtertxt_CSS", data.get("questionnaire_checklist_title"));

			// click on the created questionnaire
			click("questionnaire_addtaskoption3_XPATH");

			// scroll down to bottom of the screen
			scrollBottom();

			// wait for the element
			Thread.sleep(5000);

			// click on the delete button
			click("checklist_wizard_deletebtn_XPATH");

			// wait for the element
			Thread.sleep(5000);

			// click on the delete button of the confirmation popup model
			click("checklist_wizard_confirmationdeletebtn_XPATH");

			// enter newly created questionnaire in the filter field
			type("ssc_company2_questionnairelist_filtertxt_CSS", data.get("questionnaire_checklist_title"));

			// validate whether the questionnaire deleted or not
			helper.deleteVerification("questionnaire_addtaskoption3_XPATH",
					"Questionnaire Add Task Option Three Title");

		} catch (Throwable t) {
			verificationFailed();
		}

		// click on the home icon from the top of the screen
		click("questionnaire_homeburgermenubtn_CSS");

		// wait for the element
		explicitWait("propertylist_title_XPATH");

		// verify the property list
		switchVerification("propertylist_title_XPATH", "Property List", "The property list is not displayed.");
	}
}