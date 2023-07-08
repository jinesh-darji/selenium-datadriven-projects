package testcases.E2Etestcasesuite.surveychecklistmodule;

import java.io.IOException;
import java.util.Hashtable;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.SkipException;
import org.testng.annotations.Test;

import com.relevantcodes.extentreports.LogStatus;

import base.Helper;
import base.TestBase;
import utilities.TestUtil;

public class RR3957SurveyChecklistTest extends TestBase {

	@Test(dataProviderClass = TestUtil.class, dataProvider = "dp")
	public void rR3957SurveyChecklistTest(Hashtable<String, String> data) throws IOException, InterruptedException {

		execution(data, "rR3957SurveyChecklistTest");

		// TEST SURVEY/CHECKLIST WORKFLOW SECURITY
		title("TEST SURVEY/CHECKLIST WORKFLOW SECURITY");

		Helper helper = new Helper();

		// refresh the page
		driver.navigate().refresh();
		Thread.sleep(5000);
		driver.navigate().refresh();

		// CREATE THE SURVEY IN THE PROPERTY LEVELS
		title("CREATE THE SURVEY IN THE PROPERTY LEVELS");

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

			helper.createSurveyQuestionnaire(data);

			// enter newly created questionnaire in the filter field
			type("ssc_company2_questionnairelist_filtertxt_CSS", data.get("questionnaire_title"));

			// verification of the created questionnaire
			switchVerification("workflowsecurity_workflowsecurity_createdrecord_1_XPATH",
					"Test Questionnaire Workflow Security",
					"The Test Questionnaire Workflow Security is not displayed.");

			// CONFIGRATION OF QUESTION
			title("CONFIGRATION OF QUESTION");

			// click on the created questionnaire
			click("workflowsecurity_workflowsecurity_createdrecord_1_XPATH");

			helper.configureQuestions(data);

			// enter newly created questionnaire in the filter field
			type("ssc_company2_questionnairelist_filtertxt_CSS", data.get("questionnaire_title"));

			// verify newly created questionnaire for checklist
			switchVerification("workflowsecurity_workflowsecurity_createdrecord_1_XPATH",
					"Test Questionnaire Workflow Security",
					"The Test Questionnaire Workflow Security record is not displayed in the questionnaire list.");

		} catch (Throwable t) {
			verificationFailed();
		}

		// click on the home menu burger button
		click("questionnaire_homeburgermenubtn_CSS");

		// wait for the element
		explicitWait("propertylist_title_XPATH");

		// verify the property list
		switchVerification("propertylist_title_XPATH", "Property List", "The property list is not displayed.");

		// VERIFY WORKFLOW AND SECURITY OF QUESTION IN SURVEY MODULE
		title("VERIFY WORKFLOW AND SECURITY OF QUESTION IN SURVEY MODULE");

		try {
			// click on the environmental icon from the property list page
			click("environmentalicon_CSS");

			// wait for the element
			Thread.sleep(5000);

			// click on the burger menu
			click("menubtn_CSS");

			// wait for the element
			Thread.sleep(5000);

			// click on the survey option from side menu
			click("surveyoption_XPATH");

			// select the respective questionnaire from the dropdown
			select("survey_questionnairedd_CSS", data.get("questionnaire_title"));

			// verify questionnaire is selected correctly or not
			switchVerification("questionnaire_questiontitle_XPATH", "Test Category Title One",
					"The Test Category Title One is not displayed.");

			// click on the workflow and security button
			click("workflowsecurity_workflowsecuritybtn_CSS");

			// click on the select user field of the editor tasks section
			click("workflowsecurity_allowtoedit_editortasks_CSS");

			// Enter data in the find user field
			type("questionnaire_createtask_findusertxt_CSS", data.get("task_find_user"));

			// select the user name from the user list
			click("workflowsecurity_editortask_selectusertxt_XPATH");

			// click on the assign to field
			click("workflowsecurity_allowtoedit_editortasks_CSS");

			// click on the due date field of editor tasks section
			click("workflowsecurity_editortask_duedate_CSS");

			// click on the today's button
			click("workflowsecurity_editortask_duedate_todaybtn_BTNTEXT");

			// scroll till the priority field
			scrollTillElement("workflowsecurity_allowtoapprove_editortasks_CSS");

			// click on the select user field of the approve tasks section
			click("workflowsecurity_allowtoapprove_editortasks_CSS");

			// Enter data in the find user field
			type("questionnaire_createtask_findusertxt_CSS", data.get("task_find_user"));

			// select the user name from the user list
			click("workflowsecurity_editortask_selectusertxt_XPATH");

			// click on the assign to field
			click("workflowsecurity_allowtoapprove_editortasks_CSS");

			// click on the due date field of editor tasks section
			click("workflowsecurity_allowtoapprove_duedate_CSS");

			// click on the today's button
			click("workflowsecurity_editortask_duedate_todaybtn_BTNTEXT");

			// click on the save button
			click("workflowsecurity_editortask_savebtn_CSS");

			// wait for the element
			explicitWaitClickable("closetoastmsg_CSS");

			// click on the toaster close button
			click("closetoastmsg_CSS");

			// verify the newly created record
			switchVerification("workflowsecurity_editortask_record_XPATH", "Jinesh", "The task is not created.");
			switchVerification("workflowsecurity_approvaltask_record_XPATH", "Jinesh", "The task is not created.");

			// VERIFY REPECTIVE TASK IS DISPLAYED OR NOT
			title("VERIFY REPECTIVE TASK IS DISPLAYED OR NOT");

			// wait for the element
			explicitWaitClickable("workflowsecurity_editortask_record_XPATH");

			// click on the editor task record
			click("workflowsecurity_editortask_record_XPATH");

			// wait for the element
			explicitWait("workflowsecurity_editortask_titlefield_CSS");

			// get the data from the title field
			try {
				String str1 = driver
						.findElement(By.cssSelector(OR.getProperty("workflowsecurity_editortask_titlefield_CSS")))
						.getAttribute("value");

				if (str1.equals("Complete questionnaire Test Questionnaire Workflow Security")) {
					successMessage("The editor task is created successfully.");
				} else {
					verificationFailedMessage("The editor task is not created.");
				}
			} catch (Throwable t) {
				verificationFailed();

			}

			// wait for the element
			explicitWaitClickable("workflowsecurity_editortask_backbtn_CSS");

			// click on the back button
			click("workflowsecurity_editortask_backbtn_CSS");

			// scrolldown the screen
			scrollByPixel(200);

			// wait for the element
			explicitWaitClickable("workflowsecurity_approvaltask_record_XPATH");

			// click on the approval task record
			click("workflowsecurity_approvaltask_record_XPATH");

			// wait for the element
			explicitWait("workflowsecurity_editortask_titlefield_CSS");

			// get the data from the title field
			try {
				String str2 = driver
						.findElement(By.cssSelector(OR.getProperty("workflowsecurity_editortask_titlefield_CSS")))
						.getAttribute("value");

				if (str2.equals("Approve/Lock questionnaire Test Questionnaire Workflow Security")) {
					successMessage("The approval task is created successfully.");
				} else {
					verificationFailedMessage("The approval task is not created");
				}
			} catch (Throwable t) {
				verificationFailed();
			}

		} catch (Throwable t) {
			verificationFailed();
		}

		// click on the home option from the side menu
		click("questionnaire_homeburgermenubtn_hide_CSS");

		// wait for the element
		explicitWait("propertylist_title_XPATH");

		// verify the property list
		switchVerification("propertylist_title_XPATH", "Property List", "The property list is not displayed.");

		// DELETE THE ADDED QUESTIONNAIRE
		title("DELETE THE ADDED QUESTIONNAIRE");

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

			// enter newly created questionnaire on property level in the filter field
			type("ssc_company2_questionnairelist_filtertxt_CSS", data.get("questionnaire_title"));

			// click on the newly created questionnaire on the property level
			click("workflowsecurity_workflowsecurity_createdrecord_1_XPATH");

			// scroll till the delete button
			scrollTillElement("questionnaire_deletebtn_CSS");

			// click on the delete button
			click("questionnaire_deletebtn_CSS");

			// wait for the element
			explicitWaitClickable("questionnaire_modeldeletebtn_CSS");

			// click on the delete button of the confirmation popup
			click("questionnaire_modeldeletebtn_CSS");

			// enter newly created questionnaire in the filter field
			type("ssc_company2_questionnairelist_filtertxt_CSS", data.get("questionnaire_title"));

			helper.deleteVerification("workflowsecurity_workflowsecurity_createdrecord_1_XPATH",
					"Test Questionnaire Workflow Security");

		} catch (Throwable t) {
			verificationFailed();
		}

		// click on the home icon from the top of the screen
		click("questionnaire_homeburgermenubtn_CSS");

		// wait for the element
		explicitWait("propertylist_title_XPATH");

		// verify the property list
		switchVerification("propertylist_title_XPATH", "Property List", "The property list is not displayed.");

		// DELETE TASKS WHICH ARE CREATED DUE TO THE WORKFLOW SECURITY
		title("DELETE TASKS WHICH ARE CREATED DUE TO THE WORKFLOW SECURITY");

		try {
			// click on the task icon
			click("taskicon_CSS");

			// click on the clear button
			click("task_createdtask_clearbtn_XPATH");

			// enter the data in the search field
			type("task_filter_CSS", data.get("task_title_1"));

			// click on the search button
			click("task_createdtask_searchbtn_XPATH");

			// click on the Complete questionnaire Test Questionnaire Workflow Security task
			click("task_workflowtask_task1_XPATH");

			// click on the delete button of the task
			click("task_deletedtaskbtn_CSS");

			// click on the delete button of the confirmation model
			click("task_deletedtaskbtn_confirmaiton_CSS");

			// click on the clear button
			click("task_createdtask_clearbtn_XPATH");

			// enter the data in the search field
			type("task_filter_CSS", data.get("task_title_2"));

			// click on the search button
			click("task_createdtask_searchbtn_XPATH");

			// click on the Approve/Lock questionnaire Test Questionnaire Workflow Security
			// task
			click("task_workflowtask_task2_XPATH");

			// wait for the element
			explicitWaitClickable("task_deletedtaskbtn_CSS");

			// click on the delete button of the task
			click("task_deletedtaskbtn_CSS");

			// wait for the element
			explicitWaitClickable("task_deletedtaskbtn_confirmaiton_CSS");

			// click on the delete button of the confirmation model
			click("task_deletedtaskbtn_confirmaiton_CSS");

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