package testcases.E2Etestcasesuite.taskmodule;

import java.io.IOException;
import java.util.Hashtable;

import org.apache.commons.lang3.RandomStringUtils;
import org.openqa.selenium.By;
import org.testng.annotations.Test;

import base.Helper;
import base.TestBase;
import utilities.TestUtil;

public class RR6633Task10Test extends TestBase {

	@Test(dataProviderClass = TestUtil.class, dataProvider = "dp")
	public void rR6633Task10Test(Hashtable<String, String> data) throws IOException, InterruptedException {

		execution(data, "rR6633Task10Test");

		// VALIDATE THE “JUMP SURVEY/INSPECTION/CUSTOM FORM“ BUTTON WHILE ADDING AND
		// UPDATING THE TASK, WITHOUT ASSOCIATING THE SURVEY/INSPECTION/CUSTOM FORM WITH
		// THE TASK.
		title("VALIDATE THE “JUMP SURVEY/INSPECTION/CUSTOM FORM“ BUTTON WHILE ADDING AND UPDATING THE TASK, WITHOUT ASSOCIATING THE SURVEY/INSPECTION/CUSTOM FORM WITH THE TASK.");

		Helper helper = new Helper();

		// refresh the page
		driver.navigate().refresh();
		Thread.sleep(5000);
		driver.navigate().refresh();

		// CREATE THE SURVEY IN THE PROPERTY LEVELS
		title("CREATE THE SURVEY IN THE PROPERTY LEVELS");

		String questionnaireTitle = RandomStringUtils.randomAlphabetic(8);

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

			helper.createSurveyQuestionnaireRandomTitle(data, questionnaireTitle);

			// enter the newly created questionnaire in the search field
			type("ssc_company2_questionnairelist_filtertxt_CSS", questionnaireTitle);

			// verification of the created questionnaire
			try {
				String questionnaire = "//td[text()='" + questionnaireTitle + "']";
				String questionnaire_actual = (driver.findElement(By.xpath(questionnaire)).getText()).trim();

				if (questionnaire_actual.equals(questionnaireTitle)) {

					successMessage("The newly created questionnaire is verified successfully.");

				} else {
					verificationFailedMessage("The newly created questionnaire is not verified.");
				}
			} catch (Throwable t) {
				verificationFailedMessage("The newly created questionnaire is not verified.");
			}

			// CONFIGRATION OF QUESTION
			title("CONFIGRATION OF QUESTION");

			// click on the created questionnaire
			String questionnaire = "//td[text()='" + questionnaireTitle + "']";
			driver.findElement(By.xpath(questionnaire)).click();
			consoleMessage("Clicked on the created questionnaire.");

			helper.configureQuestions(data);

			// enter newly created questionnaire in the filter field
			type("ssc_company2_questionnairelist_filtertxt_CSS", questionnaireTitle);

			// verification of the created questionnaire
			try {
				questionnaire = "//td[text()='" + questionnaireTitle + "']";
				String questionnaire_actual = (driver.findElement(By.xpath(questionnaire)).getText()).trim();

				if (questionnaire_actual.equals(questionnaireTitle)) {

					successMessage("The newly created questionnaire is verified successfully.");

				} else {
					verificationFailedMessage("The newly created questionnaire is not verified.");
				}
			} catch (Throwable t) {
				verificationFailedMessage("The newly created questionnaire is not verified.");
			}

		} catch (Throwable t) {
			verificationFailed();
		}

		// click on the home menu burger button
		click("questionnaire_homeburgermenubtn_CSS");

		// wait for the element
		explicitWait("propertylist_title_XPATH");

		// verify the property list
		switchVerification("propertylist_title_XPATH", "Property List", "The property list is not displayed.");

		// VERIFY QUESTONNAIRE IN SURVEY MODULE AT PROPERTY LEVEL
		title("VERIFY QUESTONNAIRE IN SURVEY MODULE AT PROPERTY LEVEL");

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
			select("survey_questionnairedd_CSS", questionnaireTitle);

			// verify questionnaire is selected correctly or not
			switchVerification("questionnaire_questiontitle_XPATH", "Test Category Title One",
					"The Test Category Title One is not displayed.");

		} catch (Throwable t) {
			verificationFailed();
		}

		// click on the Home button
		click("questionnaire_homeburgermenubtn_hide_CSS");

		// wait for the element
		explicitWait("propertylist_title_XPATH");

		// verify the property list
		switchVerification("propertylist_title_XPATH", "Property List", "The property list is not displayed.");

		// VALIDATE THE “JUMP SURVEY/INSPECTION/CUSTOM FORM“ BUTTON WITHOUT ASSOCIATION
		// WHILE ADDING THE TASKS
		title("VALIDATE THE “JUMP SURVEY/INSPECTION/CUSTOM FORM“ BUTTON WITHOUT ASSOCIATION WHILE ADDING THE TASKS");

		String taskTitle = RandomStringUtils.randomAlphabetic(8);

		try {
			// wait for the element
			Thread.sleep(3000);

			// click on the task icon of the respective property
			click("taskicon_CSS");

			// click on the add task button
			click("task_addtaskbtn_CSS");

			// enter the data in the task title field
			type("task_addtask_titletxt_CSS", taskTitle);

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

			// select the environmental option from the module dropdown
			select("task_addtask_moduledd_CSS", data.get("model"));

			// scroll down the screen
			scrollTop();

			// click on the task association tab
			click("task_taskassociationtab_XPATH");

			// scroll down the screen
			scrollBottom();

			// validate the jump to survey/inspection/custom form button
			try {
				boolean jumpbtn = driver.findElement(By.xpath(OR.getProperty("task_taskassociationtab_jumpbtn_XPATH")))
						.isDisplayed();

				if (jumpbtn == true) {
					verificationFailedMessage("The jump to survey/inspection/custom form button is displayed.");

				} else {
					successMessage("The jump to survey/inspection/custom form button is not displayed as expected.");
				}
			} catch (Throwable t) {
				successMessage("The jump to survey/inspection/custom form button is not displayed as expected.");
			}

			// click on the save button
			click("survey_task_savebtn_XPATH");

			// scroll up the screen
			scrollTop();

			// click on the clear button
			click("task_createdtask_clearbtn_XPATH");

			// enter the data in the search field
			type("task_filter_CSS", taskTitle);

			// click on the search button
			click("task_createdtask_searchbtn_XPATH");

			// verify newly created task is displayed or not
			try {
				String task = "//p[contains(text(),'" + taskTitle + "')]";
				String task_actual = (driver.findElement(By.xpath(task)).getText()).trim();

				if (task_actual.equals(taskTitle)) {
					successMessage("The newly created task is verified successfully.");
				} else {
					verificationFailedMessage("The newly created task is not verified.");
				}
			} catch (Throwable t) {
				verificationFailedMessage("The newly created task is not verified.");
			}

			// VALIDATE THE “JUMP SURVEY/INSPECTION/CUSTOM FORM“ BUTTON WITHOUT ASSOCIATION
			// WHILE UPDATING THE TASKS
			title("VALIDATE THE “JUMP SURVEY/INSPECTION/CUSTOM FORM“ BUTTON WITHOUT ASSOCIATION WHILE UPDATING THE TASKS");

			// click on the newly created task
			String task = "//p[contains(text(),'" + taskTitle + "')]";
			driver.findElement(By.xpath(task)).click();
			consoleMessage("click on the newly created task.");

			// wait for the element
			Thread.sleep(3000);

			// click on the task association tab
			click("task_taskassociationtab_XPATH");

			// scroll down the screen
			scrollBottom();

			// validate the survey radio button
			try {
				boolean surveybtn = driver.findElement(By.xpath(OR.getProperty("survey_task_surveybtn_XPATH")))
						.isEnabled();

				if (surveybtn == true) {
					successMessage("The radio button of survey is displayed enabled as expected.");
				} else {
					verificationFailedMessage("The radio button of survey is not displayed enabled.");
				}
			} catch (Throwable t) {
				verificationFailedMessage("The radio button of survey is not displayed enabled.");
			}

			// validate the inspection radio button
			try {
				boolean inspectionbtn = driver
						.findElement(By.xpath(OR.getProperty("task_taskassociationtab_inspectionbtn_XPATH")))
						.isEnabled();

				if (inspectionbtn == true) {
					successMessage("The radio button of inspection is displayed enabled as expected.");
				} else {
					verificationFailedMessage("The radio button of inspection is not displayed enabled.");
				}
			} catch (Throwable t) {
				verificationFailedMessage("The radio button of inspection is not displayed enabled.");
			}

			// validate the custom form radio button
			try {
				boolean customformbtn = driver
						.findElement(By.xpath(OR.getProperty("task_taskassociationtab_customformbtn_XPATH")))
						.isEnabled();

				if (customformbtn == true) {
					successMessage("The radio button of custom form is displayed enabled as expected.");
				} else {
					verificationFailedMessage("The radio button of custom form is not displayed enabled.");
				}
			} catch (Throwable t) {
				verificationFailedMessage("The radio button of custom form is not displayed enabled.");
			}

			// validate the dropdown
			try {
				boolean dropdown = driver
						.findElement(By.xpath(OR.getProperty("task_taskassociationtab_questionnerdd_XPATH")))
						.isEnabled();

				if (dropdown == true) {
					successMessage("The dropdown enabled as expected.");
				} else {
					verificationFailedMessage("The dropdown is not displayed enabled.");
				}
			} catch (Throwable t) {
				verificationFailedMessage("The dropdown is not displayed enabled.");
			}

			// validate the jump to survey/inspection/custom form button
			try {
				boolean jumpbtn = driver.findElement(By.xpath(OR.getProperty("task_taskassociationtab_jumpbtn_XPATH")))
						.isDisplayed();

				if (jumpbtn == true) {
					verificationFailedMessage("The jump to survey/inspection/custom form button is displayed.");

				} else {
					successMessage("The jump to survey/inspection/custom form button is not displayed as expected.");
				}
			} catch (Throwable t) {
				successMessage("The jump to survey/inspection/custom form button is not displayed as expected.");
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

		// DELETE THE NEWLY CREATED TASK FROM THE PROPERTY LEVEL
		title("DELETE THE NEWLY CREATED TASK FROM THE PROPERTY LEVEL");

		try {
			// click on the task icon of the respective property
			click("taskicon_CSS");

			// click on the clear button
			click("task_createdtask_clearbtn_XPATH");

			// enter the data in the search field
			type("task_filter_CSS", taskTitle);

			// click on the search button
			click("task_createdtask_searchbtn_XPATH");

			// verify newly created task is displayed or not
			try {
				String task = "//p[contains(text(),'" + taskTitle + "')]";
				String task_actual = (driver.findElement(By.xpath(task)).getText()).trim();

				if (task_actual.equals(taskTitle)) {

					successMessage("The newly created task is verified successfully.");

				} else {
					verificationFailedMessage("The newly created task is not verified.");
				}
			} catch (Throwable t) {
				verificationFailedMessage("The newly created task is not verified.");
			}

			// click on the action icon
			String actionIcon = "//p[text()='" + taskTitle
					+ "']//parent::td//following-sibling::td[@class='text-center pointer']//i[@data-toggle='dropdown']";
			driver.findElement(By.xpath(actionIcon)).click();
			consoleMessage("Clicked on the action icon.");

			// click on the delete option
			String deleteOption = "//p[text()='" + taskTitle
					+ "']//parent::td//following-sibling::td[@class='text-center pointer']//div[@class='dropdown open']//li[@ng-click='deleteSelectedTask(task.id, false);']";
			driver.findElement(By.xpath(deleteOption)).click();
			consoleMessage("Clicked on the delete option.");

			// wait for the element
			explicitWaitClickable("closetoastmsg_CSS");

			// click on the toaster close button
			click("closetoastmsg_CSS");

			// click on the clear button
			click("task_createdtask_clearbtn_XPATH");

			// enter the data in the search field
			type("task_filter_CSS", taskTitle);

			// click on the search button
			click("task_createdtask_searchbtn_XPATH");

			// validate the deleted task
			try {
				String task = "//p[contains(text(),'" + taskTitle + "')]";
				String task_actual = (driver.findElement(By.xpath(task)).getText()).trim();

				if (task_actual.equals(taskTitle)) {
					verificationFailedMessage("The newly created task is not deleted.");
				} else {
					successMessage("The newly created task is deleted successfully.");
				}
			} catch (Throwable t) {
				successMessage("The newly created task is deleted successfully.");
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

		// DELETE THE NEWLY CREATED QUESTIONNAIRES
		title("DELETE THE NEWLY CREATED QUESTIONNAIRE");

		try {
			// wait for the element
			explicitWaitClickable("questionnaire_settingicon_CSS");

			// click on the settings icon from the top of the screen
			click("questionnaire_settingicon_CSS");

			// wait for the element
			Thread.sleep(5000);

			// click on the Administration option from the side menu
			click("questionnaire_administrationoption_XPATH");

			// click on the Questionnaires tab
			click("questionnaire_questionnairestab_XPATH");

			// click on the Questionnaires option
			click("questionnaire_questionnairesoption_XPATH");

			// enter newly created questionnaire in the filter field
			type("ssc_company2_questionnairelist_filtertxt_CSS", questionnaireTitle);

			// click on the created questionnaire
			String questionnaire = "//td[text()='" + questionnaireTitle + "']";
			driver.findElement(By.xpath(questionnaire)).click();
			consoleMessage("Clicked on the created questionnaire.");

			// scroll down to bottom
			scrollBottom();

			// click on the delete button
			click("questionnaire_deletebtn_CSS");

			// click on the delete button of the confirmation model
			click("questionnaire_modeldeletebtn_CSS");

			// wait for the element
			explicitWaitClickable("closetoastmsg_CSS");

			// click on the toaster close button
			click("closetoastmsg_CSS");

			// enter newly created questionnaire in the filter field
			type("ssc_company2_questionnairelist_filtertxt_CSS", questionnaireTitle);

			// validate the deleted questionnaire
			try {
				questionnaire = "//td[text()='" + questionnaireTitle + "']";
				String questionnaire_actual = (driver.findElement(By.xpath(questionnaire)).getText()).trim();

				if (questionnaire_actual.equals(questionnaireTitle)) {
					verificationFailedMessage("The newly created questionnaire is not deleted.");
				} else {
					successMessage("The newly created questionnaire is deleted successfully.");
				}
			} catch (Throwable t) {
				successMessage("The newly created questionnaire is deleted successfully.");
			}

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
