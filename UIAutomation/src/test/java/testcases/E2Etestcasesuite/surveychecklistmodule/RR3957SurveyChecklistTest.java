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

		System.out.println("TEST SURVEY/CHECKLIST WORKFLOW SECURITY");
		test.log(LogStatus.INFO, "TEST SURVEY/CHECKLIST WORKFLOW SECURITY");
		Reporter.log("TEST SURVEY/CHECKLIST WORKFLOW SECURITY");
		log.info("TEST SURVEY/CHECKLIST WORKFLOW SECURITY");

		Helper helper = new Helper();

		// refresh the page
		driver.navigate().refresh();
		Thread.sleep(5000);
		driver.navigate().refresh();

		System.out.println("Navigate to the Home Screen i.e. Property List Screen.");

		// CREATE THE SURVEY IN THE PROPERTY LEVELS

		System.out.println("***************** CREATE THE SURVEY IN THE PROPERTY LEVELS *****************");
		test.log(LogStatus.INFO, "***************** CREATE THE SURVEY IN THE PROPERTY LEVELS *****************");
		Reporter.log("***************** CREATE THE SURVEY IN THE PROPERTY LEVELS *****************");
		log.info("***************** CREATE THE SURVEY IN THE PROPERTY LEVELS *****************");

		try {
			// wait for the element
			explicitWaitClickable("questionnaire_settingicon_CSS");

			// click on the settings icon from the top of the screen
			click("questionnaire_settingicon_CSS");
			System.out.println("Clicked on the settings icon.");
			ngDriver.waitForAngularRequestsToFinish();

			// wait for the element
			explicitWaitClickable("questionnaire_administrationoption_XPATH");

			// click on the Administration option from the side menu
			click("questionnaire_administrationoption_XPATH");
			System.out.println("Clicked on the Administration option from the side menu.");
			ngDriver.waitForAngularRequestsToFinish();

			// click on the Questionnaires tab
			click("questionnaire_questionnairestab_XPATH");
			System.out.println("Clicked on the Questionnaires tab.");
			ngDriver.waitForAngularRequestsToFinish();

			// click on the Questionnaires option
			click("questionnaire_questionnairesoption_XPATH");
			System.out.println("Clicked on the Questionnaires option.");
			ngDriver.waitForAngularRequestsToFinish();

			helper.createSurveyQuestionnaire(data);

			// enter newly created questionnaire in the filter field
			type("ssc_company2_questionnairelist_filtertxt_CSS", data.get("questionnaire_title"));
			System.out.println("Entered newly created questionnaire in the filter field.");
			ngDriver.waitForAngularRequestsToFinish();

			// verification of the created questionnaire
			switchVerification("workflowsecurity_workflowsecurity_createdrecord_1_XPATH",
					"Test Questionnaire Workflow Security",
					"The Test Questionnaire Workflow Security is not displayed.");

			// CONFIGRATION OF QUESTION

			System.out.println("***************** CONFIGRATION OF QUESTION *****************");
			test.log(LogStatus.INFO, "***************** CONFIGRATION OF QUESTION *****************");
			Reporter.log("***************** CONFIGRATION OF QUESTION *****************");
			log.info("***************** CONFIGRATION OF QUESTION *****************");

			// click on the created questionnaire
			click("workflowsecurity_workflowsecurity_createdrecord_1_XPATH");
			System.out.println("Clicked on the newly created questionnaire.");
			ngDriver.waitForAngularRequestsToFinish();

			helper.configureQuestions(data);

			// enter newly created questionnaire in the filter field
			clear("ssc_company2_questionnairelist_filtertxt_CSS");
			ngDriver.waitForAngularRequestsToFinish();
			type("ssc_company2_questionnairelist_filtertxt_CSS", data.get("questionnaire_title"));
			System.out.println("Entered newly created questionnaire in the filter field.");
			ngDriver.waitForAngularRequestsToFinish();

			// verify newly created questionnaire for checklist
			switchVerification("workflowsecurity_workflowsecurity_createdrecord_1_XPATH",
					"Test Questionnaire Workflow Security",
					"The Test Questionnaire Workflow Security record is not displayed in the questionnaire list.");

		} catch (Throwable t) {
			verificationFailed();
		}

		// click on the home menu burger button
		click("questionnaire_homeburgermenubtn_CSS");
		System.out.println("Click on the home burger menu icon.");
		ngDriver.waitForAngularRequestsToFinish();
		System.out.println("Navigate to the Home Screen i.e. Property List Screen.");

		// wait for the element
		explicitWait("propertylist_title_XPATH");

		// verify the property list
		switchVerification("propertylist_title_XPATH", "Property List", "The property list is not displayed.");

		// VERIFY WORKFLOW AND SECURITY OF QUESTION IN SURVEY MODULE

		System.out.println(
				"***************** VERIFY WORKFLOW AND SECURITY OF QUESTION IN SURVEY MODULE *****************");
		test.log(LogStatus.INFO,
				"***************** VERIFY WORKFLOW AND SECURITY OF QUESTION IN SURVEY MODULE *****************");
		Reporter.log("***************** VERIFY WORKFLOW AND SECURITY OF QUESTION IN SURVEY MODULE *****************");
		log.info("***************** VERIFY WORKFLOW AND SECURITY OF QUESTION IN SURVEY MODULE *****************");

		try {
			// click on the environmental icon from the property list page
			click("environmentalicon_CSS");
			System.out.println("Clicked on the environmental icon of the Property.");
			ngDriver.waitForAngularRequestsToFinish();
			System.out.println("Navigate to the environmental screen of the perticular property.");

			// wait for the element
			Thread.sleep(5000);

			// click on the burger menu
			click("menubtn_CSS");
			System.out.println("Clicked on the burger menu button successfully!!!");
			ngDriver.waitForAngularRequestsToFinish();

			// wait for the element
			Thread.sleep(5000);

			// click on the survey option from side menu
			click("surveyoption_XPATH");
			System.out.println("Clicked on the survey option from side menu");
			ngDriver.waitForAngularRequestsToFinish();
			System.out.println("Navigate to the survey screen");

			// select the respective questionnaire from the dropdown
			select("survey_questionnairedd_CSS", data.get("questionnaire_title"));
			System.out.println("The questionnaire selected successfully.");
			ngDriver.waitForAngularRequestsToFinish();

			// verify questionnaire is selected correctly or not
			switchVerification("questionnaire_questiontitle_XPATH", "Test Category Title One",
					"The Test Category Title One is not displayed.");

			// click on the workflow and security button
			click("workflowsecurity_workflowsecuritybtn_CSS");
			System.out.println("Clicked on the workflow and security button.");
			ngDriver.waitForAngularRequestsToFinish();

			// click on the select user field of the editor tasks section
			click("workflowsecurity_allowtoedit_editortasks_CSS");
			System.out.println("Clicked on the select user field of the editor tasks section.");
			ngDriver.waitForAngularRequestsToFinish();

			// Enter data in the find user field
			type("questionnaire_createtask_findusertxt_CSS", data.get("task_find_user"));
			System.out.println("The data entered in the find user field.");
			ngDriver.waitForAngularRequestsToFinish();

			// select the user name from the user list
			click("workflowsecurity_editortask_selectusertxt_XPATH");
			System.out.println("The user name is selected from the list of users");
			ngDriver.waitForAngularRequestsToFinish();

			// click on the assign to field
			click("workflowsecurity_allowtoedit_editortasks_CSS");
			System.out.println("Click on the assign to field.");
			ngDriver.waitForAngularRequestsToFinish();

			// click on the due date field of editor tasks section
			click("workflowsecurity_editortask_duedate_CSS");
			System.out.println("Clicked on the due date field of editor tasks section.");
			ngDriver.waitForAngularRequestsToFinish();

			// click on the today's button
			click("workflowsecurity_editortask_duedate_todaybtn_BTNTEXT");
			System.out.println("Clicked on the today's button.");
			ngDriver.waitForAngularRequestsToFinish();

			// scroll till the priority field
			WebElement element9 = driver
					.findElement(By.cssSelector(OR.getProperty("workflowsecurity_allowtoapprove_editortasks_CSS")));
			JavascriptExecutor js = (JavascriptExecutor) driver;
			js.executeScript("arguments[0].scrollIntoView();", element9);
			System.out.println("Scrolled down the screen.");

			// click on the select user field of the approve tasks section
			click("workflowsecurity_allowtoapprove_editortasks_CSS");
			System.out.println("Clicked on the select user field of the approve tasks section.");
			ngDriver.waitForAngularRequestsToFinish();

			// Enter data in the find user field
			type("questionnaire_createtask_findusertxt_CSS", data.get("task_find_user"));
			System.out.println("The data entered in the find user field.");
			ngDriver.waitForAngularRequestsToFinish();

			// select the user name from the user list
			click("workflowsecurity_editortask_selectusertxt_XPATH");
			System.out.println("The user name is selected from the list of users");
			ngDriver.waitForAngularRequestsToFinish();

			// click on the assign to field
			click("workflowsecurity_allowtoapprove_editortasks_CSS");
			System.out.println("Click on the assign to field.");
			ngDriver.waitForAngularRequestsToFinish();

			// click on the due date field of editor tasks section
			click("workflowsecurity_allowtoapprove_duedate_CSS");
			System.out.println("Clicked on the due date field of approval tasks section.");
			ngDriver.waitForAngularRequestsToFinish();

			// click on the today's button
			click("workflowsecurity_editortask_duedate_todaybtn_BTNTEXT");
			System.out.println("Clicked on the today's button.");
			ngDriver.waitForAngularRequestsToFinish();

			// click on the save button
			click("workflowsecurity_editortask_savebtn_CSS");
			System.out.println("Clicked on the save button.");
			ngDriver.waitForAngularRequestsToFinish();

			// wait for the element
			explicitWaitClickable("closetoastmsg_CSS");

			// click on the toaster close button
			click("closetoastmsg_CSS");
			ngDriver.waitForAngularRequestsToFinish();
			System.out.println("Clicked on the toaster close button.");

			// verify the newly created record

			switchVerification("workflowsecurity_editortask_record_XPATH", "Jinesh", "The task is not created.");

			switchVerification("workflowsecurity_approvaltask_record_XPATH", "Jinesh", "The task is not created.");

			// VERIFY REPECTIVE TASK IS DISPLAYED OR NOT

			// wait for the element
			explicitWaitClickable("workflowsecurity_editortask_record_XPATH");

			// click on the editor task record
			click("workflowsecurity_editortask_record_XPATH");
			System.out.println("Clicked on the editor task record.");
			ngDriver.waitForAngularRequestsToFinish();

			// wait for the element
			explicitWait("workflowsecurity_editortask_titlefield_CSS");

			// get the data from the title field

			try {
				String str1 = driver
						.findElement(By.cssSelector(OR.getProperty("workflowsecurity_editortask_titlefield_CSS")))
						.getAttribute("value");

				if (str1.equals("Complete questionnaire Test Questionnaire Workflow Security")) {

					Assert.assertTrue(
							isElementPresent(
									By.cssSelector(OR.getProperty("workflowsecurity_editortask_titlefield_CSS"))),
							"The task is not created successdully.");

					System.out.println("The editor task is created successfully.");
					test.log(LogStatus.INFO, "The editor task is created successfully.");
					Reporter.log("The editor task is created successfully.");
					log.info("The editor task is created successfully.");
				} else {
					TestUtil.captureScreenshot();

					// ReportNG
					Reporter.log("<br>" + " The editor task is not created successfully. " + "<br>");
					Reporter.log("<a target=\"_blank\" href=" + TestUtil.screenshotName + "><img src="
							+ TestUtil.screenshotName + " height=200 width=200></img></a>");
					Reporter.log("<br>");
					Reporter.log("<br>");

					// Extent Report
					test.log(LogStatus.FAIL, " The editor task is not created successfully. ");
					test.log(LogStatus.FAIL, test.addScreenCapture(TestUtil.screenshotName));

					System.out.println(" The editor task is not created successfully. ");
					log.info(" The editor task is not created successfully. ");
				}
			} catch (Throwable t) {
				verificationFailed();

			}

			// wait for the element
			explicitWaitClickable("workflowsecurity_editortask_backbtn_CSS");

			// click on the back button
			click("workflowsecurity_editortask_backbtn_CSS");
			System.out.println("Clicked on the back button.");
			ngDriver.waitForAngularRequestsToFinish();

			// scrolldown the screen
			js.executeScript("window.scrollBy(0,200)");

			// wait for the element
			explicitWaitClickable("workflowsecurity_approvaltask_record_XPATH");

			// click on the approval task record
			click("workflowsecurity_approvaltask_record_XPATH");
			System.out.println("Clicked on the approval task record.");
			ngDriver.waitForAngularRequestsToFinish();

			// wait for the element
			explicitWait("workflowsecurity_editortask_titlefield_CSS");

			// get the data from the title field

			try {
				String str2 = driver
						.findElement(By.cssSelector(OR.getProperty("workflowsecurity_editortask_titlefield_CSS")))
						.getAttribute("value");

				if (str2.equals("Approve/Lock questionnaire Test Questionnaire Workflow Security")) {

					Assert.assertTrue(
							isElementPresent(
									By.cssSelector(OR.getProperty("workflowsecurity_editortask_titlefield_CSS"))),
							"The task is not created successdully.");

					System.out.println("The approval task is created successfully.");
					test.log(LogStatus.INFO, "The approval task is created successfully.");
					Reporter.log("The approval task is created successfully.");
					log.info("The approval task is created successfully.");
				} else {
					TestUtil.captureScreenshot();

					// ReportNG
					Reporter.log("<br>" + " The approval task is not created successfully. " + "<br>");
					Reporter.log("<a target=\"_blank\" href=" + TestUtil.screenshotName + "><img src="
							+ TestUtil.screenshotName + " height=200 width=200></img></a>");
					Reporter.log("<br>");
					Reporter.log("<br>");

					// Extent Report
					test.log(LogStatus.FAIL, " The approval task is not created successfully. ");
					test.log(LogStatus.FAIL, test.addScreenCapture(TestUtil.screenshotName));

					System.out.println(" The approval task is not created successfully. ");
					log.info(" The approval task is not created successfully. ");
				}
			} catch (Throwable t) {
				verificationFailed();
			}

		} catch (Throwable t) {

			verificationFailed();
		}

		// click on the home option from the side menu
		click("questionnaire_homeburgermenubtn_hide_CSS");
		System.out.println("Clicked on the home option from the side menu");
		ngDriver.waitForAngularRequestsToFinish();

		// wait for the element
		explicitWait("propertylist_title_XPATH");

		// verify the property list
		switchVerification("propertylist_title_XPATH", "Property List", "The property list is not displayed.");

		// DELETE THE ADDED QUESTIONNAIRE

		System.out.println("***************** DELETE THE ADDED QUESTIONNAIRE *****************");
		test.log(LogStatus.INFO, "***************** DELETE THE ADDED QUESTIONNAIRE *****************");
		Reporter.log("***************** DELETE THE ADDED QUESTIONNAIRE *****************");
		log.info("***************** DELETE THE ADDED QUESTIONNAIRE *****************");

		try {
			// wait for the element
			explicitWaitClickable("questionnaire_settingicon_CSS");

			// click on the settings icon from the top of the screen
			click("questionnaire_settingicon_CSS");
			System.out.println("Clicked on the settings icon.");
			ngDriver.waitForAngularRequestsToFinish();

			// wait for the element
			explicitWaitClickable("questionnaire_administrationoption_XPATH");

			// click on the Administration option from the side menu
			click("questionnaire_administrationoption_XPATH");
			System.out.println("Clicked on the Administration option from the side menu.");
			ngDriver.waitForAngularRequestsToFinish();

			// click on the Questionnaires tab
			click("questionnaire_questionnairestab_XPATH");
			System.out.println("Clicked on the Questionnaires tab.");
			ngDriver.waitForAngularRequestsToFinish();

			// click on the Questionnaires option
			click("questionnaire_questionnairesoption_XPATH");
			System.out.println("Clicked on the Questionnaires option.");
			ngDriver.waitForAngularRequestsToFinish();

			// enter newly created questionnaire on property level in the filter field
			clear("ssc_company2_questionnairelist_filtertxt_CSS");
			ngDriver.waitForAngularRequestsToFinish();
			type("ssc_company2_questionnairelist_filtertxt_CSS", data.get("questionnaire_title"));
			System.out.println("Entered newly created questionnaire on property level in the filter field.");
			ngDriver.waitForAngularRequestsToFinish();

			// click on the newly created questionnaire on the property level
			click("workflowsecurity_workflowsecurity_createdrecord_1_XPATH");
			System.out.println("Clicked on the newly created questionnaire on the property level.");
			ngDriver.waitForAngularRequestsToFinish();

			// scroll till the delete button
			WebElement element5 = driver.findElement(By.cssSelector(OR.getProperty("questionnaire_deletebtn_CSS")));
			JavascriptExecutor js = (JavascriptExecutor) driver;
			js.executeScript("arguments[0].scrollIntoView();", element5);

			// click on the delete button
			click("questionnaire_deletebtn_CSS");
			System.out.println("Clicked on the delete button.");
			ngDriver.waitForAngularRequestsToFinish();

			// wait for the element
			explicitWaitClickable("questionnaire_modeldeletebtn_CSS");

			// click on the delete button of the confirmation popup
			click("questionnaire_modeldeletebtn_CSS");
			System.out.println("Clicked on the delete button of the confirmation popup.");
			ngDriver.waitForAngularRequestsToFinish();

			// enter newly created questionnaire in the filter field
			clear("ssc_company2_questionnairelist_filtertxt_CSS");
			ngDriver.waitForAngularRequestsToFinish();
			type("ssc_company2_questionnairelist_filtertxt_CSS", data.get("questionnaire_title"));
			System.out.println("Entered newly created questionnaire in the filter field.");
			ngDriver.waitForAngularRequestsToFinish();

			helper.deleteVerification("workflowsecurity_workflowsecurity_createdrecord_1_XPATH",
					"Test Questionnaire Workflow Security");

		} catch (Throwable t) {
			verificationFailed();
		}

		// click on the home icon from the top of the screen
		click("questionnaire_homeburgermenubtn_CSS");
		System.out.println("Clicked on the home icon from the top of the screen.");
		ngDriver.waitForAngularRequestsToFinish();

		// wait for the element
		explicitWait("propertylist_title_XPATH");

		// verify the property list
		switchVerification("propertylist_title_XPATH", "Property List", "The property list is not displayed.");

		// DELETE TASKS WHICH ARE CREATED DUE TO THE WORKFLOW SECURITY

		System.out.println(
				"***************** DELETE TASKS WHICH ARE CREATED DUE TO THE WORKFLOW SECURITY *****************");
		test.log(LogStatus.INFO,
				"***************** DELETE TASKS WHICH ARE CREATED DUE TO THE WORKFLOW SECURITY *****************");
		Reporter.log("***************** DELETE TASKS WHICH ARE CREATED DUE TO THE WORKFLOW SECURITY *****************");
		log.info("***************** DELETE TASKS WHICH ARE CREATED DUE TO THE WORKFLOW SECURITY *****************");

		try {
			// click on the task icon
			click("taskicon_CSS");
			ngDriver.waitForAngularRequestsToFinish();
			System.out.println("Clicked on the task icon.");

			// delete first task

			// click on the clear button
			click("task_createdtask_clearbtn_XPATH");
			ngDriver.waitForAngularRequestsToFinish();
			System.out.println("Clicked on the clear button.");

			// enter the data in the search field
			type("task_filter_CSS", data.get("task_title_1"));
			System.out.println("Entered the data in the search field.");
			ngDriver.waitForAngularRequestsToFinish();

			// click on the search button
			click("task_createdtask_searchbtn_XPATH");
			ngDriver.waitForAngularRequestsToFinish();
			System.out.println("Clicked on the search button.");

			// click on the Complete questionnaire Test Questionnaire Workflow Security task
			click("task_workflowtask_task1_XPATH");
			ngDriver.waitForAngularRequestsToFinish();
			System.out.println("Clicked on the Complete questionnaire Test Questionnaire Workflow Security task.");

			// click on the delete button of the task
			click("task_deletedtaskbtn_CSS");
			ngDriver.waitForAngularRequestsToFinish();
			System.out.println("Clicked on the delete button of the task.");

			// click on the delete button of the confirmation model
			click("task_deletedtaskbtn_confirmaiton_CSS");
			ngDriver.waitForAngularRequestsToFinish();
			System.out.println("Clicked on the delete button of the confirmation model.");

			// delete second task

			// click on the clear button
			click("task_createdtask_clearbtn_XPATH");
			ngDriver.waitForAngularRequestsToFinish();
			System.out.println("Clicked on the clear button.");

			// enter the data in the search field
			type("task_filter_CSS", data.get("task_title_2"));
			System.out.println("Entered the data in the search field.");
			ngDriver.waitForAngularRequestsToFinish();

			// click on the search button
			click("task_createdtask_searchbtn_XPATH");
			ngDriver.waitForAngularRequestsToFinish();
			System.out.println("Clicked on the search button.");

			// click on the Approve/Lock questionnaire Test Questionnaire Workflow Security
			// task
			click("task_workflowtask_task2_XPATH");
			ngDriver.waitForAngularRequestsToFinish();
			System.out.println("Clicked on the Approve/Lock questionnaire Test Questionnaire Workflow Security task.");

			// wait for the element
			explicitWaitClickable("task_deletedtaskbtn_CSS");

			// click on the delete button of the task
			click("task_deletedtaskbtn_CSS");
			ngDriver.waitForAngularRequestsToFinish();
			System.out.println("Clicked on the delete button of the task.");

			// wait for the element
			explicitWaitClickable("task_deletedtaskbtn_confirmaiton_CSS");

			// click on the delete button of the confirmation model
			click("task_deletedtaskbtn_confirmaiton_CSS");
			ngDriver.waitForAngularRequestsToFinish();
			System.out.println("Clicked on the delete button of the confirmation model.");

		} catch (Throwable t) {
			verificationFailed();
		}

		// click on the home icon from the top of the screen
		click("questionnaire_homeburgermenubtn_hide_CSS");
		System.out.println("Clicked on the home icon from the top of the screen.");
		ngDriver.waitForAngularRequestsToFinish();

		// wait for the element
		explicitWait("propertylist_title_XPATH");

		// verify the property list
		switchVerification("propertylist_title_XPATH", "Property List", "The property list is not displayed.");

	}
}
