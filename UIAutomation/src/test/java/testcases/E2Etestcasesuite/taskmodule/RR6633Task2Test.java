package testcases.E2Etestcasesuite.taskmodule;

import java.io.IOException;
import java.util.Hashtable;

import org.apache.commons.lang3.RandomStringUtils;
import org.openqa.selenium.By;
import org.testng.annotations.Test;

import base.Helper;
import base.TestBase;
import utilities.TestUtil;

public class RR6633Task2Test extends TestBase {

	@Test(dataProviderClass = TestUtil.class, dataProvider = "dp")
	public void rR6633Task2Test(Hashtable<String, String> data) throws IOException, InterruptedException {

		execution(data, "rR6633Task2Test");

		// VALIDATE THE �JUMP SURVEY/INSPECTION/CUSTOM FORM� BUTTON AND JUMP TO THE
		// ASSOCIATED INSPECTION (PROPERTY AND BUILDING LEVEL) WHILE ADDING AND UPDATING
		// THE TASK, BY ASSOCIATING THE INSPECTION WITH THE TASK.
		title("VALIDATE THE �JUMP SURVEY/INSPECTION/CUSTOM FORM� BUTTON AND JUMP TO THE ASSOCIATED INSPECTION (PROPERTY AND BUILDING LEVEL) WHILE ADDING AND UPDATING THE TASK, BY ASSOCIATING THE INSPECTION WITH THE TASK.");

		Helper helper = new Helper();

		// refresh the page
		driver.navigate().refresh();
		Thread.sleep(5000);
		driver.navigate().refresh();

		// CREATE THE INSPECTION IN THE PROPERTY LEVELS AND BUILDING LEVEL
		title("CREATE THE INSPECTION IN THE PROPERTY LEVELS AND BUILDING LEVEL");

		String questionnaireTitle = RandomStringUtils.randomAlphabetic(8);
		String questionnaireTitle1 = RandomStringUtils.randomAlphabetic(8);

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

			// click on the new questionnaire
			click("questionnaire_newquestionnairebtn_CSS");

			// Select the Inspection / Checklist of the questionnaire
			click("questionnaire_type_inspectionbtn_CSS");

			// Select the level of the questionnaire
			click("questionnaire_level_propertybtn_CSS");

			// enter the group title
			type("questionnaire_grouptitletxt_CSS", data.get("group_title"));

			// enter the questionnaire title
			type("questionnaire_languagetitle_CSS", questionnaireTitle);

			// select the model
			select("questionnaire_modeldd_CSS", data.get("model"));

			// enter frequency interval
			type("questionnaire_frequencyintervaltxt_CSS", "1");

			// enter the description
			type("questionnaire_descriptiontxt_CSS", data.get("description"));

			// select the classic option from the default view drop down
			select("questionnaire_checklist_defaultview_CSS", data.get("default_view"));

			// scroll down the screen
			scrollByPixel(500);

			// click on the warranty checkbox
			click("questionnaire_warrantybtn_CSS");

			// click on the save button
			click("questionnaire_savebtn_BTNTEXT");

			// enter newly created questionnaire in the filter field
			type("ssc_company2_questionnairelist_filtertxt_CSS", questionnaireTitle);

			// verification of the created questionnaire
			try {
				String questionnaire = "//td[text()='" + questionnaireTitle + "']";
				String questionnaire_actual = (driver.findElement(By.xpath(questionnaire)).getText()).trim();

				if (questionnaire_actual.equals(questionnaireTitle)) {

					successMessage("The newly created questionnaire of property level is verified successfully.");

				} else {
					verificationFailedMessage("The newly created questionnaire of property level is not verified.");
				}
			} catch (Throwable t) {
				verificationFailedMessage("The newly created questionnaire of property level is not verified.");
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

					successMessage("The newly created questionnaire of property level is verified successfully.");

				} else {
					verificationFailedMessage("The newly created questionnaire of property level is not verified.");
				}
			} catch (Throwable t) {
				verificationFailedMessage("The newly created questionnaire of property level is not verified.");
			}

			// click on the new questionnaire
			click("questionnaire_newquestionnairebtn_CSS");

			// Select the Inspection / Checklist of the questionnaire
			click("questionnaire_type_inspectionbtn_CSS");

			/// Select the level of the questionnaire
			click("questionnaire_level_buildingbtn_CSS");

			// enter the group title
			type("questionnaire_grouptitletxt_CSS", data.get("group_title"));

			// enter the questionnaire title
			type("questionnaire_languagetitle_CSS", questionnaireTitle1);

			// select the model
			select("questionnaire_modeldd_CSS", data.get("model"));

			// enter frequency interval
			type("questionnaire_frequencyintervaltxt_CSS", "1");

			// enter the description
			type("questionnaire_descriptiontxt_CSS", data.get("description"));

			// select the classic option from the default view drop down
			select("questionnaire_checklist_defaultview_CSS", data.get("default_view"));

			// scroll down the screen
			scrollByPixel(500);

			// click on the warranty checkbox
			click("questionnaire_warrantybtn_CSS");

			// click on the save button
			click("questionnaire_savebtn_BTNTEXT");

			// enter newly created questionnaire in the filter field
			type("ssc_company2_questionnairelist_filtertxt_CSS", questionnaireTitle1);

			// verification of the created questionnaire
			try {
				String questionnaire_b = "//td[text()='" + questionnaireTitle1 + "']";
				String questionnaire_b_actual = (driver.findElement(By.xpath(questionnaire_b)).getText()).trim();

				if (questionnaire_b_actual.equals(questionnaireTitle1)) {

					successMessage("The newly created questionnaire for building level is verified successfully.");

				} else {
					verificationFailedMessage("The newly created questionnaire for building level is not verified.");
				}
			} catch (Throwable t) {
				verificationFailedMessage("The newly created questionnaire for building level is not verified.");
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

		// CREATED A NEW INSPECTION AT PROPERTY LEVEL AND BUILDING LEVEL
		title("CREATED A NEW INSPECTION AT PROPERTY LEVEL AND BUILDING LEVEL");

		String inspectionTitle = RandomStringUtils.randomAlphabetic(8);
		String inspectionTitle1 = RandomStringUtils.randomAlphabetic(8);

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

			// click on the new checklist button
			click("checklist_newchecklistbtn_CSS");

			// wait for the element
			explicitWait("checklist_addchecklist_checklisttypedd_CSS");

			// select the questionnaire option from the checklist type dropdown
			select("checklist_addchecklist_checklisttypedd_CSS", questionnaireTitle);

			// enter data in the checklist title field
			type("checklist_addchecklist_titletxt_CSS", inspectionTitle);

			// click on the save button
			click("checklist_addchecklist_savebtn_CSS");

			// verify questionnaire is selected correctly or not
			switchVerification("questionnaire_questiontitle_XPATH", "Test Category Title One",
					"The Test Category Title One is not displayed.");

			// click on the back button
			click("questionnaire_checklist_backbtn_CSS");

			// enter the newly created inspection in the search field
			type("sustainability_searchtxt_XPATH", inspectionTitle);

			// verification of the created questionnaire
			try {
				String inspection = "//td[text()='" + inspectionTitle + "']";
				String inspection_actual = (driver.findElement(By.xpath(inspection)).getText()).trim();

				if (inspection_actual.equals(inspectionTitle)) {
					successMessage("The newly created inspection at property level is verified successfully.");
				} else {
					verificationFailedMessage("The newly created inspection at property level is not verified.");
				}
			} catch (Throwable t) {
				verificationFailedMessage("The newly created inspection at property level is not verified.");
			}

			// select the building
			select("envreports_movereports_propertydd_CSS", data.get("building_name"));

			// wait for the element
			Thread.sleep(3000);

			// click on the new checklist button
			click("checklist_newchecklistbtn_CSS");

			// wait for the element
			explicitWait("checklist_addchecklist_checklisttypedd_CSS");

			// select the questionnaire option from the checklist type dropdown
			select("checklist_addchecklist_checklisttypedd_CSS", questionnaireTitle1);

			// enter data in the checklist title field
			type("checklist_addchecklist_titletxt_CSS", inspectionTitle1);

			// click on the save button
			click("checklist_addchecklist_savebtn_CSS");

			// verify questionnaire is selected correctly or not
			switchVerification("questionnaire_questiontitle_XPATH", "Test Category Title One",
					"The Test Category Title One is not displayed.");

			// click on the back button
			click("questionnaire_checklist_backbtn_CSS");

			// enter the newly created inspection in the search field
			type("sustainability_searchtxt_XPATH", inspectionTitle1);

			// verification of the created questionnaire
			try {
				String inspection1 = "//td[text()='" + inspectionTitle1 + "']";
				String inspection1_actual = (driver.findElement(By.xpath(inspection1)).getText()).trim();

				if (inspection1_actual.equals(inspectionTitle1)) {
					successMessage("The newly created inspection at building level is verified successfully.");
				} else {
					verificationFailedMessage("The newly created inspection at building level is not verified.");
				}
			} catch (Throwable t) {
				verificationFailedMessage("The newly created inspection at building level is not verified.");
			}

		} catch (Throwable t) {
			verificationFailed();
		}

		// click on the Home button
		click("questionnaire_homeburgermenubtn_hide_CSS");

		// wait for the element
		explicitWait("propertylist_title_XPATH");

		// verify the property list
		switchVerification("propertylist_title_XPATH", "Property List", "The property list is not displayed.");

		// CREATE THE NEW TASK WITHOUT TASK TYPE AND ASSOCIATE THE NEWLY CREATED
		// INSPECTION WITH THE TASK AT PROPERTY LEVEL
		title("CREATE THE NEW TASK WITHOUT TASK TYPE AND ASSOCIATE THE NEWLY CREATED INSPECTION WITH THE TASK AT PROPERTY LEVEL");

		String taskTitle = RandomStringUtils.randomAlphabetic(8);
		String inspectionTitle_task = RandomStringUtils.randomAlphabetic(8);

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

			// click on the inspection button
			click("survey_task_surveychecklisttab_checklisttype_CSS");

			// scroll down the screen
			scrollBottom();

			// select the newly created questionnaire from the dropdown
			select("survey_task_questionnairedd_CSS", questionnaireTitle);

			// enter the title of the inspection title
			type("task_associatedinspection_titletxt_XPATH", inspectionTitle_task);

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
			// INSPECTION
			title("VERIFY JUMP SURVEY/INSPECTION/CUSTOM FORM BUTTON SHOULD LAUNCH ASSOCIATED INSPECTION");

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

			// validate the dropdown of inspection
			try {
				boolean dropdown = driver
						.findElement(By.xpath(OR.getProperty("task_taskassociationtab_questionnerdd_disabled_XPATH")))
						.isEnabled();

				if (dropdown == false) {
					successMessage("The dropdown of inspection disabled as expected.");
				} else {
					verificationFailedMessage("The dropdown of inspection is not displayed disabled.");
				}
			} catch (Throwable t) {
				verificationFailedMessage("The dropdown of inspection is not displayed disabled.");
			}

			// validate the selected inspection is displayed or not
			try {
				String selectedQuestionnaire = "//option[@label='" + questionnaireTitle + "' and @selected='selected']";
				boolean dropdown = driver.findElement(By.xpath(selectedQuestionnaire)).isDisplayed();

				if (dropdown == true) {
					successMessage("The selected option in the inspection dropdown is displayed as expected.");
				} else {
					verificationFailedMessage("The selected option in the inspection dropdown is not displayed.");
				}
			} catch (Throwable t) {
				verificationFailedMessage("The selected option in the inspection dropdown is not displayed.");
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

			// validate correct inspection is launched or not
			try {
				String inspection3 = "//li[text()='" + inspectionTitle_task + "']";
				consoleMessage("inspection3: " + inspection3);
				boolean inspection3_actual = driver.findElement(By.xpath(inspection3)).isDisplayed();

				if (inspection3_actual == true) {
					successMessage("The correct inspection is launched successfully.");
				} else {
					verificationFailedMessage("The correct inspection is not launched.");
				}
			} catch (Throwable t) {
				verificationFailedMessage("The correct inspection is not launched.");
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

		// CREATE THE NEW TASK WITHOUT TASK TYPE AND ASSOCIATE THE NEWLY CREATED
		// INSPECTION WITH THE TASK AT BUILDING LEVEL
		title("CREATE THE NEW TASK WITHOUT TASK TYPE AND ASSOCIATE THE NEWLY CREATED INSPECTION WITH THE TASK AT BUILDING LEVEL");

		String taskTitle1 = RandomStringUtils.randomAlphabetic(8);
		String inspectionTitle_task1 = RandomStringUtils.randomAlphabetic(8);

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

			// click on the inspection button
			click("survey_task_surveychecklisttab_checklisttype_CSS");

			// scroll down the screen
			scrollBottom();

			// select the newly created questionnaire from the dropdown
			select("survey_task_questionnairedd_CSS", questionnaireTitle1);

			// enter the title of the inspection title
			type("task_associatedinspection_titletxt_XPATH", inspectionTitle_task1);

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
			// INSPECTION
			title("VERIFY JUMP SURVEY/INSPECTION/CUSTOM FORM BUTTON SHOULD LAUNCH ASSOCIATED INSPECTION");

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

			// validate the dropdown of inspection
			try {
				boolean dropdown = driver
						.findElement(By.xpath(OR.getProperty("task_taskassociationtab_questionnerdd_disabled_XPATH")))
						.isEnabled();

				if (dropdown == false) {
					successMessage("The dropdown of inspection disabled as expected.");
				} else {
					verificationFailedMessage("The dropdown of inspection is not displayed disabled.");
				}
			} catch (Throwable t) {
				verificationFailedMessage("The dropdown of inspection is not displayed disabled.");
			}

			// validate the selected inspection is displayed or not
			try {
				String selectedQuestionnaire = "//option[@label='" + questionnaireTitle1
						+ "' and @selected='selected']";
				boolean dropdown = driver.findElement(By.xpath(selectedQuestionnaire)).isDisplayed();

				if (dropdown == true) {
					successMessage("The selected option in the inspection dropdown is displayed as expected.");
				} else {
					verificationFailedMessage("The selected option in the inspection dropdown is not displayed.");
				}
			} catch (Throwable t) {
				verificationFailedMessage("The selected option in the inspection dropdown is not displayed.");
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

			// validate correct inspection is launched or not
			try {
				String inspection4 = "//li[text()='" + inspectionTitle_task1 + "']";
				consoleMessage("inspection4: " + inspection4);
				boolean inspection4_actual = driver.findElement(By.xpath(inspection4)).isDisplayed();

				if (inspection4_actual == true) {
					successMessage("The correct inspection is launched successfully.");
				} else {
					verificationFailedMessage("The inspection survey is not launched.");
				}
			} catch (Throwable t) {
				verificationFailedMessage("The inspection survey is not launched.");
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
		title("DELETE THE NEWLY CREATED QUESTIONNAIRES");

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
