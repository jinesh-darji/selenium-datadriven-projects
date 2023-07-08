package testcases.E2Etestcasesuite.taskmodule;

import java.io.IOException;
import java.util.Hashtable;

import org.apache.commons.lang3.RandomStringUtils;
import org.openqa.selenium.By;
import org.testng.annotations.Test;

import base.Helper;
import base.TestBase;
import utilities.TestUtil;

public class RR6633Task1Test extends TestBase {

	@Test(dataProviderClass = TestUtil.class, dataProvider = "dp")
	public void rR6633Task1Test(Hashtable<String, String> data) throws IOException, InterruptedException {

		execution(data, "rR6633Task1Test");

		// VALIDATE THE �JUMP SURVEY/INSPECTION/CUSTOM FORM� BUTTON AND JUMP TO THE
		// ASSOCIATED SURVEY (PROPERTY AND BUILDING LEVEL) WHILE ADDING AND UPDATING THE
		// TASK, BY ASSOCIATING THE SURVEY WITH THE TASK.
		title("VALIDATE THE �JUMP SURVEY/INSPECTION/CUSTOM FORM� BUTTON AND JUMP TO THE ASSOCIATED SURVEY (PROPERTY AND BUILDING LEVEL) WHILE ADDING AND UPDATING THE TASK, BY ASSOCIATING THE SURVEY WITH THE TASK.");

		Helper helper = new Helper();

		// refresh the page
		driver.navigate().refresh();
		Thread.sleep(5000);
		driver.navigate().refresh();

		// CREATE THE SURVEY IN THE PROPERTY LEVELS AND BUILDING LEVEL
		title("CREATE THE SURVEY IN THE PROPERTY LEVELS AND BUILDING LEVEL");

		String questionnaireTitle = RandomStringUtils.randomAlphabetic(8);
		String questionnaireTitle1 = RandomStringUtils.randomAlphabetic(8);

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

			// click on the new questionnaire
			click("questionnaire_newquestionnairebtn_CSS");

			// Select the type of the questionnaire
			click("questionnaire_type_propertybtn_CSS");

			// Select the level of the questionnaire
			click("questionnaire_level_buildingbtn_CSS");

			// enter the group title
			type("questionnaire_grouptitletxt_CSS", data.get("group_title"));

			// enter the questionnaire title
			type("questionnaire_questionnairetitletxt_CSS", questionnaireTitle1);

			// select the model
			select("questionnaire_modeldd_CSS", data.get("model"));

			// select the frequency
			select("questionnaire_frequencydd_CSS", data.get("frequency"));

			// enter the year
			String[] today_arr = today().split("-");
			String year = today_arr[0];
			type("questionnaire_yeartxt_CSS", year);

			// select the month
			select("questionnaire_monthtxt_CSS", data.get("month"));

			// enter the description
			type("questionnaire_descriptiontxt_CSS", data.get("description"));

			// click on the save button
			click("questionnaire_savebtn_BTNTEXT");

			// enter the newly created questionnaire in the search field
			type("ssc_company2_questionnairelist_filtertxt_CSS", questionnaireTitle1);

			// verification of the created questionnaire
			try {
				String questionnaire_b = "//td[text()='" + questionnaireTitle1 + "']";
				String questionnaire_b_actual = (driver.findElement(By.xpath(questionnaire_b)).getText()).trim();

				if (questionnaire_b_actual.equals(questionnaireTitle1)) {
					successMessage("The newly created questionnaire on building level is verified successfully.");
				} else {
					verificationFailedMessage("The newly created questionnaire on building level is not verified.");
				}
			} catch (Throwable t) {
				verificationFailedMessage("The newly created questionnaire on building level is not verified.");
			}

			// CONFIGRATION OF QUESTION
			title("CONFIGRATION OF QUESTION");

			// click on the created questionnaire
			String questionnaire_b = "//td[text()='" + questionnaireTitle1 + "']";
			driver.findElement(By.xpath(questionnaire_b)).click();
			consoleMessage("Clicked on the created questionnaire.");

			helper.configureQuestions(data);

			// enter newly created questionnaire in the filter field
			type("ssc_company2_questionnairelist_filtertxt_CSS", questionnaireTitle1);

			// verification of the created questionnaire
			try {
				questionnaire_b = "//td[text()='" + questionnaireTitle1 + "']";
				String questionnaire_b_actual = (driver.findElement(By.xpath(questionnaire_b)).getText()).trim();

				if (questionnaire_b_actual.equals(questionnaireTitle1)) {

					successMessage("The newly created questionnaire on building level is verified successfully.");

				} else {
					verificationFailedMessage("The newly created questionnaire on building level is not verified.");
				}
			} catch (Throwable t) {
				verificationFailedMessage("The newly created questionnaire on building level is not verified.");
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

		// VERIFY QUESTONNAIRE IN SURVEY MODULE AT PROPERTY LEVEL AND BUILDING LEVEL
		title("VERIFY QUESTONNAIRE IN SURVEY MODULE AT PROPERTY LEVEL AND BUILDING LEVEL");

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

			// select the building
			select("envreports_movereports_propertydd_CSS", data.get("building_name"));

			// wait for the element
			Thread.sleep(3000);

			// select the respective questionnaire from the dropdown
			select("survey_questionnairedd_CSS", questionnaireTitle1);

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

		// CREATE THE NEW TASK WITHOUT TASK TYPE AND ASSOCIATE THE NEWLY CREATED SURVEY
		// WITH THE TASK AT PROPERTY LEVEL
		title("CREATE THE NEW TASK WITHOUT TASK TYPE AND ASSOCIATE THE NEWLY CREATED SURVEY WITH THE TASK AT PROPERTY LEVEL");

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

			// click on the survey button
			click("survey_task_surveybtn_CSS");

			// select the newly created questionnaire from the dropdown
			select("survey_task_questionnairedd_CSS", questionnaireTitle);

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

			// VERIFY JUMP SURVEY/INSPECTION/CUSTOM FORM BUTTON SHOULD LAUNCH ASSOCIATED
			// SURVEY
			title("VERIFY JUMP SURVEY/INSPECTION/CUSTOM FORM BUTTON SHOULD LAUNCH ASSOCIATED SURVEY");

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

				if (dropdown == false) {
					successMessage("The dropdown of survey disabled as expected.");
				} else {
					verificationFailedMessage("The dropdown of survey is not displayed disabled.");
				}
			} catch (Throwable t) {
				verificationFailedMessage("The dropdown of survey is not displayed disabled.");
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

		// CREATE THE NEW TASK WITHOUT TASK TYPE AND ASSOCIATE THE NEWLY CREATED SURVEY
		// WITH THE TASK AT BUILDING LEVEL
		title("CREATE THE NEW TASK WITHOUT TASK TYPE AND ASSOCIATE THE NEWLY CREATED SURVEY WITH THE TASK AT BUILDING LEVEL");

		String taskTitle1 = RandomStringUtils.randomAlphabetic(8);

		try {
			// wait for the element
			Thread.sleep(3000);

			// click on the task icon of the respective property
			click("taskicon_CSS");

			// select the building
			select("task_addedtask_propertybuildingdd_CSS", data.get("building_name"));

			// wait for the element
			Thread.sleep(3000);

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

			// click on the survey button
			click("survey_task_surveybtn_CSS");

			// select the newly created questionnaire from the dropdown
			select("survey_task_questionnairedd_CSS", questionnaireTitle1);

			// click on the save button
			click("survey_task_savebtn_XPATH");

			// scroll up the screen
			scrollTop();

			// click on the clear button
			click("task_createdtask_clearbtn_XPATH");

			// enter the data in the search field
			type("task_filter_CSS", taskTitle1);

			// click on the search button
			click("task_createdtask_searchbtn_XPATH");

			// verify newly created task is displayed or not
			try {
				String task = "//p[contains(text(),'" + taskTitle1 + "')]";
				String task_actual = (driver.findElement(By.xpath(task)).getText()).trim();

				if (task_actual.equals(taskTitle1)) {
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
			String task = "//p[contains(text(),'" + taskTitle1 + "')]";
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

				if (dropdown == false) {
					successMessage("The dropdown of survey disabled as expected.");
				} else {
					verificationFailedMessage("The dropdown of survey is not displayed disabled.");
				}
			} catch (Throwable t) {
				verificationFailedMessage("The dropdown of survey is not displayed disabled.");
			}

			// validate the selected survey is displayed or not
			try {
				String selectedQuestionnaire = "//option[@label='" + questionnaireTitle1
						+ "' and @selected='selected']";
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

			// validate correct building is displayed or not
			try {
				String building = "//option[@label='" + data.get("building_name") + "' and @selected='selected']";
				boolean building_actual = driver.findElement(By.xpath(building)).isDisplayed();

				if (building_actual == true) {
					successMessage("The correct building is displayed successfully.");
				} else {
					verificationFailedMessage("The correct building is not displayed.");
				}
			} catch (Throwable t) {
				verificationFailedMessage("The correct building is not displayed.");
			}

			// validate correct survey is launched or not
			try {
				String survey = "//select[@ng-model='commonQuestionnaireVars.selectedQuestionnaire']//option[@label='"
						+ questionnaireTitle1 + "' and @selected='selected']";
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

		// DELETE THE NEWLY CREATED TASK FROM THE PROPERTY LEVEL AND BUILDING LEVEL
		title("DELETE THE NEWLY CREATED TASK FROM THE PROPERTY LEVEL AND BUILDING LEVEL");

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

			// select the building
			select("task_addedtask_propertybuildingdd_CSS", data.get("building_name"));

			// wait for the element
			Thread.sleep(3000);

			// click on the clear button
			click("task_createdtask_clearbtn_XPATH");

			// enter the data in the search field
			type("task_filter_CSS", taskTitle1);

			// click on the search button
			click("task_createdtask_searchbtn_XPATH");

			// verify newly created task is displayed or not
			try {
				String task = "//p[contains(text(),'" + taskTitle1 + "')]";
				String task_actual = (driver.findElement(By.xpath(task)).getText()).trim();

				if (task_actual.equals(taskTitle1)) {

					successMessage("The newly created task is verified successfully.");

				} else {
					verificationFailedMessage("The newly created task is not verified.");
				}
			} catch (Throwable t) {
				verificationFailedMessage("The newly created task is not verified.");
			}

			// click on the action icon
			String actionIcon_b = "//p[text()='" + taskTitle1
					+ "']//parent::td//following-sibling::td[@class='text-center pointer']//i[@data-toggle='dropdown']";
			driver.findElement(By.xpath(actionIcon_b)).click();
			consoleMessage("Clicked on the action icon.");

			// click on the delete option
			String deleteOption_b = "//p[text()='" + taskTitle1
					+ "']//parent::td//following-sibling::td[@class='text-center pointer']//div[@class='dropdown open']//li[@ng-click='deleteSelectedTask(task.id, false);']";
			driver.findElement(By.xpath(deleteOption_b)).click();
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
				String task = "//p[contains(text(),'" + taskTitle1 + "')]";
				String task_actual = (driver.findElement(By.xpath(task)).getText()).trim();

				if (task_actual.equals(taskTitle1)) {
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

			// enter newly created questionnaire in the filter field
			type("ssc_company2_questionnairelist_filtertxt_CSS", questionnaireTitle1);

			// click on the created questionnaire
			String questionnaire1 = "//td[text()='" + questionnaireTitle1 + "']";
			driver.findElement(By.xpath(questionnaire1)).click();
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
			type("ssc_company2_questionnairelist_filtertxt_CSS", questionnaireTitle1);

			// validate the deleted questionnaire
			try {
				questionnaire = "//td[text()='" + questionnaireTitle1 + "']";
				String questionnaire_actual = (driver.findElement(By.xpath(questionnaire)).getText()).trim();

				if (questionnaire_actual.equals(questionnaireTitle1)) {
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
