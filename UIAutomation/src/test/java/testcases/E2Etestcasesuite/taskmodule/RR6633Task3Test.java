package testcases.E2Etestcasesuite.taskmodule;

import java.io.IOException;
import java.util.Hashtable;

import org.apache.commons.lang3.RandomStringUtils;
import org.openqa.selenium.By;
import org.testng.annotations.Test;

import base.Helper;
import base.TestBase;
import utilities.TestUtil;

public class RR6633Task3Test extends TestBase {

	@Test(dataProviderClass = TestUtil.class, dataProvider = "dp")
	public void rR6633Task3Test(Hashtable<String, String> data) throws IOException, InterruptedException {

		execution(data, "rR6633Task3Test");

		// VALIDATE THE “JUMP SURVEY/INSPECTION/CUSTOM FORM“ BUTTON AND JUMP TO THE
		// ASSOCIATED SURVEY WHILE ADDING AND UPDATING THE AUTO-GENERATED TASK, BY
		// ASSOCIATING THE SURVEY WITH THE TASK.
		title("VALIDATE THE “JUMP SURVEY/INSPECTION/CUSTOM FORM“ BUTTON AND JUMP TO THE ASSOCIATED SURVEY WHILE ADDING AND UPDATING THE AUTO-GENERATED TASK, BY ASSOCIATING THE SURVEY WITH THE TASK.");

		Helper helper = new Helper();

		// refresh the page
		driver.navigate().refresh();
		Thread.sleep(5000);
		driver.navigate().refresh();

		// CREATE THE SURVEY IN THE PROPERTY LEVEL
		title("CREATE THE SURVEY IN THE PROPERTY LEVEL");

		String questionnaireTitle = RandomStringUtils.randomAlphabetic(8);
		String taskTitle = RandomStringUtils.randomAlphabetic(8);

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

			// scroll till the more button
			scrollTillElement("questionnaire_type_propertybtn_CSS");

			// click on the more button
			click("questionnaire_morebtn_CSS");

			// click on the configure questions option
			click("questionnaire_configurebtn_CSS");

			// ADD CATEGORY 1 INTO THE QUESTIONNAIRE
			title("ADD CATEGORY 1 INTO THE QUESTIONNAIRE");

			// click on the new category button
			click("questionnaire_newcategorybtn_BTNTEXT");

			// select the language
			select("questionnaire_newcategory_languagedd_XPATH", data.get("category_language"));

			// enter the title
			type("questionnaire_newcategory_titletxt_MODEL", data.get("category_title_1"));

			// click on the save button
			click("questionnaire_newcategory_savebtn_CSS");

			// verify newly created category is displayed or not
			switchVerification("questionnaire_newcategory_1_XPATH", "Test Category Title One",
					"The Test Category Title One is not displayed.");

			// ADD CATEGORY 2 INTO THE QUESTIONNAIRE
			title("ADD CATEGORY 2 INTO THE QUESTIONNAIRE");

			// click on the new category button
			click("questionnaire_newcategorybtn_BTNTEXT");

			// select the language
			select("questionnaire_newcategory_languagedd_XPATH", data.get("category_language"));

			// enter the title
			type("questionnaire_newcategory_titletxt_MODEL", data.get("category_title_2"));

			// click on the save button
			click("questionnaire_newcategory_savebtn_CSS");

			// verify newly created category is displayed or not
			switchVerification("questionnaire_newcategory_2_XPATH", "Test Category Title Two Two",
					"The Test Category Title Two Two is not displayed.");

			// ADD QUESTION 1 INTO THE CATEGORY 1
			title("ADD QUESTION 1 INTO THE CATEGORY 1");

			// click on the save button for save all categories
			click("questionnaire_category_savebtn_CSS");

			// wait for the element
			explicitWaitClickable("closetoastmsg_CSS");

			// click on the toaster close button
			click("closetoastmsg_CSS");

			// click on the edit button of category one
			click("questionnaire_category_editbtn_CSS");

			// click on the edit question button
			click("questionnaire_category_editquestionbtn_BTNTEXT");

			// click on the new question button
			click("questionnaire_newquestionbtn_CSS");

			// select the English language from the language dropdown
			select("questionnaire_newquestion_languagedd_CSS", data.get("question_language"));

			// enter the label
			type("questionnaire_newquestion_labeltxt_CSS", data.get("question_label_1"));

			// enter the title
			type("questionnaire_newquestion_titletxt_CSS", data.get("question_title_1"));

			// click on the save button
			click("questionnaire_newquestion_savebtn_CSS");

			// verify question one created or not
			switchVerification("questionnaire_newquestion_1_XPATH", "Test Question Title One",
					"The Test Question Title One is not displayed.");

			// click on the new question button
			click("questionnaire_newquestionbtn_CSS");

			// select the English language from the language dropdown
			select("questionnaire_newquestion_languagedd_CSS", data.get("question_language"));

			// enter the label
			type("questionnaire_newquestion_labeltxt_CSS", data.get("question_label_2"));

			// enter the title
			type("questionnaire_newquestion_titletxt_CSS", data.get("question_title_2"));

			// click on the save button
			click("questionnaire_newquestion_savebtn_CSS");

			// verify question one created or not
			switchVerification("questionnaire_newquestion_2_XPATH", "Test Question Title Two Two",
					"The Test Question Title Two Two is not displayed.");

			// click on the save button of the questions
			click("questionnaire_saveallquestionbtn_CSS");

			// click on the edit question 1 button
			click("questionnaire_question_1_editbtn_CSS");

			// CREATE THE AUTO GENERATE TASK
			title("CREATE THE AUTO GENERATE TASK");

			// wait for the element
			Thread.sleep(3000);

			// click on the task icon of the no option
			click("questionnaire_question_1_notaskicon_CSS");

			// wait for the element
			Thread.sleep(3000);

			// click on the non-compliant checkbox
			click("questionnaire_createtask_noncompliantbtn_CSS");

			// click on the create a task checkbox
			click("questionnaire_createtask_createataskbtn_CSS");

			// enter data in the task title field
			type("questionnaire_createtask_tasktitletxt_CSS", taskTitle);

			// click on the assign to field
			click("questionnaire_createtask_assigntotxt_CSS");

			// scroll till the find user field
			scrollByPixel(400);

			// Enter data in the find user field
			type("questionnaire_createtask_findusertxt_CSS", data.get("search_user"));

			// select the user name from the user list
			click("questionnaire_createtask_selectusertxt_XPATH");

			// click on the assign to field
			click("questionnaire_createtask_assigntotxt_CSS");

			// click on the allow task edit checkbox
			click("questionnaire_createtask_allowtaskeditbtn_CSS");

			// click on the task tag field
			click("questionnaire_createtask_tasktagtxt_CSS");

			// Enter tag name in the search field
			type("questionnaire_createtask_findtasktagtxt_CSS", data.get("task_tag"));

			// click on the searched tag
			click("questionnaire_createtask_selecttasktagtxt_XPATH");

			// click on the task tag field
			click("questionnaire_createtask_tasktagtxt_CSS");

			// click on the save button
			click("questionnaire_createtask_savebtn_CSS");

			// click on the save button for save all questions
			click("questionnaire_saveallquestionbtn_CSS");

			// wait for the element
			explicitWaitClickable("closetoastmsg_CSS");

			// click on the toaster close button
			click("closetoastmsg_CSS");

			// click on the back to category button
			click("questionnaire_question_1_backtocategorybtn_CSS");

			// click on the save button for save all categories
			click("questionnaire_category_savebtn_CSS");

			// wait for the element
			explicitWaitClickable("closetoastmsg_CSS");

			// click on the toaster close button
			click("closetoastmsg_CSS");

			// click on the back to questionnaire button
			click("questionnaire_category_backtoquestionnairesbtn_CSS");

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

		// VERIFY QUESTONNAIRE IN SURVEY MODULE AT PROPERTY LEVEL AND GENERATE THE AUTO
		// TASK
		title("VERIFY QUESTONNAIRE IN SURVEY MODULE AT PROPERTY LEVEL AND GENERATE THE AUTO TASK");

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

			// click on the no checkbox
			click("survey_noanswerbtn_1_CSS");

			// click on the yes checkbox
			click("survey_yesanswerbtn_2_CSS");

			// click on the category 1 question 1 label
			click("checklist_category_1_question_1_XPATH");

		} catch (Throwable t) {
			verificationFailed();
		}

		// click on the Home button
		click("questionnaire_homeburgermenubtn_hide_CSS");

		// wait for the element
		explicitWait("propertylist_title_XPATH");

		// verify the property list
		switchVerification("propertylist_title_XPATH", "Property List", "The property list is not displayed.");

		// ASSOCIATE THE AUTO GENERATED TASK WITH THE SURVEY AT PROPERTY LEVEL
		title("ASSOCIATE THE AUTO GENERATED TASK WITH THE SURVEY AT PROPERTY LEVEL");

		try {
			// wait for the element
			Thread.sleep(3000);

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

			// click on the auto generated task
			String task = "//p[contains(text(),'" + taskTitle + "')]";
			driver.findElement(By.xpath(task)).click();
			consoleMessage("Clicked on the auto generated task.");

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

			// click on the survey button
			click("survey_task_surveybtn_CSS");

			// select the newly created questionnaire from the dropdown
			select("survey_task_questionnairedd_CSS", questionnaireTitle);

			// click on the update button
			click("survey_task_updatebtn_CSS");

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
				task = "//p[contains(text(),'" + taskTitle + "')]";
				String task_actual = (driver.findElement(By.xpath(task)).getText()).trim();

				if (task_actual.equals(taskTitle)) {
					successMessage("The newly created task is verified successfully.");
				} else {
					verificationFailedMessage("The newly created task is not verified.");
				}
			} catch (Throwable t) {
				verificationFailedMessage("The newly created task is not verified.");
			}

			// VERIFY JUMP SURVEY/INSPECTION/CUSTOM FORM BUTTON SHOULD LAUNCH ASSOCIATED
			// SURVEY
			title("VERIFY JUMP SURVEY/INSPECTION/CUSTOM FORM BUTTON SHOULD LAUNCH ASSOCIATED SURVEY");

			// click on the newly created task
			task = "//p[contains(text(),'" + taskTitle + "')]";
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
				boolean surveybtn = driver.findElement(By.xpath(OR.getProperty("survey_task_surveybtn_disabled_XPATH")))
						.isEnabled();

				if (surveybtn == false) {
					successMessage("The radio button of survey is displayed disabled as expected.");
				} else {
					verificationFailedMessage("The radio button of survey is not displayed disabled.");
				}
			} catch (Throwable t) {
				verificationFailedMessage("The radio button of survey is not displayed disabled.");
			}

			// validate the inspection radio button
			try {
				boolean inspectionbtn = driver
						.findElement(By.xpath(OR.getProperty("task_taskassociationtab_inspectionbtn_disabled_XPATH")))
						.isEnabled();

				if (inspectionbtn == false) {
					successMessage("The radio button of inspection is displayed disabled as expected.");
				} else {
					verificationFailedMessage("The radio button of inspection is not displayed disabled.");
				}
			} catch (Throwable t) {
				verificationFailedMessage("The radio button of inspection is not displayed disabled.");
			}

			// validate the custom form radio button
			try {
				boolean customformbtn = driver
						.findElement(By.xpath(OR.getProperty("task_taskassociationtab_customformbtn_disabled_XPATH")))
						.isEnabled();

				if (customformbtn == false) {
					successMessage("The radio button of custom form is displayed disabled as expected.");
				} else {
					verificationFailedMessage("The radio button of custom form is not displayed disabled.");
				}
			} catch (Throwable t) {
				verificationFailedMessage("The radio button of custom form is not displayed disabled.");
			}

			// validate the dropdown of survey
			try {
				boolean dropdown = driver
						.findElement(By.xpath(OR.getProperty("task_taskassociationtab_questionnerdd_disabled_XPATH")))
						.isEnabled();

				if (dropdown == true) {
					verificationFailedMessage("The dropdown of survey is not displayed disabled.");
				} else {
					successMessage("The dropdown of survey is displayed disabled as expected.");
				}
			} catch (Throwable t) {
				successMessage("The dropdown of survey is displayed disabled as expected.");
			}

			// validate the selected survey is displayed or not
			try {
				String selectedQuestionnaire = "//option[@label='" + questionnaireTitle + "' and @selected='selected']";
				boolean dropdown = driver.findElement(By.xpath(selectedQuestionnaire)).isDisplayed();

				if (dropdown == true) {
					successMessage("The selected option in the survey dropdown is displayed as expected.");
				} else {
					verificationFailedMessage("The selected option in the survey dropdown is not displayed.");
				}
			} catch (Throwable t) {
				verificationFailedMessage("The selected option in the survey dropdown is not displayed.");
			}

			// validate the jump to survey/inspection/custom form button
			try {
				boolean jumpbtn = driver.findElement(By.xpath(OR.getProperty("task_taskassociationtab_jumpbtn_XPATH")))
						.isDisplayed();

				if (jumpbtn == true) {
					successMessage("The jump to survey/inspection/custom form button is displayed as expected.");
				} else {
					verificationFailedMessage("The jump to survey/inspection/custom form button is not displayed.");
				}
			} catch (Throwable t) {
				verificationFailedMessage("The jump to survey/inspection/custom form button is not displayed.");
			}

			// click on the jump to survey/inspection/custom form button
			click("task_taskassociationtab_jumpbtn_XPATH");

			// scroll up to top
			scrollTop();

			// validate correct survey is launched or not
			try {
				String survey = "//select[@ng-model='commonQuestionnaireVars.selectedQuestionnaire']//option[@label='"
						+ questionnaireTitle + "' and @selected='selected']";
				boolean survey_actual = driver.findElement(By.xpath(survey)).isDisplayed();

				if (survey_actual == true) {
					successMessage("The correct survey is launched successfully.");
				} else {
					verificationFailedMessage("The correct survey is not launched.");
				}
			} catch (Throwable t) {
				verificationFailedMessage("The correct survey is not launched.");
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

		// DELETE THE AUTO GENERATED TASK FROM THE PROPERTY LEVEL
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

		// UPDATE THE QUESTIONNAIRE TITLE WITH RANDOM TEXT
		title("UPDATE THE QUESTIONNAIRE TITLE WITH RANDOM TEXT");

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

			// enter newly created questionnaire in the filter field
			type("ssc_company2_questionnairelist_filtertxt_CSS", questionnaireTitle);

			// click on the created questionnaire
			String questionnaire = "//td[text()='" + questionnaireTitle + "']";
			driver.findElement(By.xpath(questionnaire)).click();
			consoleMessage("Clicked on the created questionnaire.");

			// Update the questionnaire with the random text and navigate to the home screen
			helper.randomText();

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
