package testcases.E2Etestcasesuite.taskmodule;

import java.io.IOException;
import java.util.Hashtable;

import org.apache.commons.lang3.RandomStringUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.testng.Reporter;
import org.testng.annotations.Test;

import com.relevantcodes.extentreports.LogStatus;

import base.Helper;
import base.TestBase;
import utilities.TestUtil;

public class RR6633Task12Test extends TestBase {

	@Test(dataProviderClass = TestUtil.class, dataProvider = "dp")
	public void rR6633Task12Test(Hashtable<String, String> data) throws IOException, InterruptedException {

		execution(data, "rR6633Task12Test");

		// VALIDATE THE TASK ASSOCIATE FEATURE WITH THE TASK TAG. (ON THE SURVEY AND
		// INSPECTION)
		title("VALIDATE THE TASK ASSOCIATE FEATURE WITH THE TASK TAG. (ON THE SURVEY AND INSPECTION)");

		Helper helper = new Helper();

		// refresh the page
		driver.navigate().refresh();
		Thread.sleep(5000);
		driver.navigate().refresh();

		// ADD NEW TASK TYPE
		title("ADD NEW TASK TYPE");

		String taskType = RandomStringUtils.randomAlphabetic(8);

		try {

			// wait for the element
			Thread.sleep(5000);

			// click on the side menu button
			click("menubtn_CSS");

			// wait for the element
			Thread.sleep(5000);

			// click on the task option
			click("sidemenu_task_CSS");

			// synchronization
			explicitWaitClickable("task_permission_tasktype_dashboarddd_CSS");

			// select the task type from the dashboard drop down
			select("task_permission_tasktype_dashboarddd_CSS", "Task Type");

			// wait for the element
			explicitWaitClickable("task_permission_tasktype_addbtn_CSS");

			// click on the add button
			click("task_permission_tasktype_addbtn_CSS");

			// enter the task type
			type("task_permission_tasktype_tasktypetxt_CSS", taskType);

			// scroll down the screen
			scrollByPixel(500);

			// click on the assign to field
			click("task_permission_tasktype_assigntotxt_CSS");

			// click on the none button
			click("task_tasktag_nonebtn_CSS");

			// enter the user name in the search field
			type("task_tasktag_searchtxt_CSS", data.get("search_user"));

			// click on the searched user
			click("task_permission_task_selectusertxt_XPATH");

			// click on the assign to field
			click("task_permission_tasktype_assigntotxt_CSS");

			// select the value from the recurrence type drop down
			select("task_permission_tasktype_recurrencetypedd_CSS", "Not Applicable");

			// select the value from the module drop down
			select("task_permission_tasktype_moduledd_CSS", data.get("model"));

			// wait for the element
			Thread.sleep(3000);

			// click on the save button
			click("task_permission_tasktype_savebtn_CSS");

			// enter the newly created task type
			type("users_filtertxt_CSS", taskType);

			// verify newly created task type is displayed or not
			try {
				String Task_Type = "//td[contains(text(),'" + taskType + "')]";
				boolean Task_Type_actual = driver.findElement(By.xpath(Task_Type)).isDisplayed();

				if (Task_Type_actual == true) {
					successMessage("The newly created task type is displayed successfully.");
				} else {
					verificationFailedMessage("The newly created task type is not displayed.");
				}
			} catch (Throwable t) {
				verificationFailedMessage("The newly created task type is not displayed.");
			}

		} catch (Throwable t) {
			verificationFailed();
		}

		// click on the home icon
		click("questionnaire_homeburgermenubtn_hide_CSS");

		// synchronization
		explicitWait("propertylist_title_XPATH");

		// verify the property list
		switchVerification("propertylist_title_XPATH", "Property List", "The property list is not displayed.");

		// CREATE THE SURVEY IN THE PROPERTY LEVELS
		title("CREATE THE SURVEY IN THE PROPERTY LEVELS");

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

			helper.createSurveyQuestionnaireRandomTitle(data, questionnaireTitle1);

			// enter the newly created questionnaire in the search field
			type("ssc_company2_questionnairelist_filtertxt_CSS", questionnaireTitle1);

			// verification of the created questionnaire
			try {
				String questionnaire = "//td[text()='" + questionnaireTitle1 + "']";
				String questionnaire_actual = (driver.findElement(By.xpath(questionnaire)).getText()).trim();

				if (questionnaire_actual.equals(questionnaireTitle1)) {

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
			String questionnaire = "//td[text()='" + questionnaireTitle1 + "']";
			driver.findElement(By.xpath(questionnaire)).click();
			consoleMessage("Clicked on the created questionnaire.");

			helper.configureQuestions(data);

			// enter newly created questionnaire in the filter field
			type("ssc_company2_questionnairelist_filtertxt_CSS", questionnaireTitle1);

			// verification of the created questionnaire
			try {
				questionnaire = "//td[text()='" + questionnaireTitle1 + "']";
				String questionnaire_actual = (driver.findElement(By.xpath(questionnaire)).getText()).trim();

				if (questionnaire_actual.equals(questionnaireTitle1)) {

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

		// CREATE THE INSPECTION IN THE PROPERTY LEVELS
		title("CREATE THE INSPECTION IN THE PROPERTY LEVELS");

		String questionnaireTitle2 = RandomStringUtils.randomAlphabetic(8);

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
			type("questionnaire_languagetitle_CSS", questionnaireTitle2);

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
			type("ssc_company2_questionnairelist_filtertxt_CSS", questionnaireTitle2);

			// verification of the created questionnaire
			try {
				String questionnaire = "//td[text()='" + questionnaireTitle2 + "']";
				String questionnaire_actual = (driver.findElement(By.xpath(questionnaire)).getText()).trim();

				if (questionnaire_actual.equals(questionnaireTitle2)) {

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
			String questionnaire = "//td[text()='" + questionnaireTitle2 + "']";
			driver.findElement(By.xpath(questionnaire)).click();
			consoleMessage("Clicked on the created questionnaire.");

			helper.configureQuestions(data);

			// enter newly created questionnaire in the filter field
			type("ssc_company2_questionnairelist_filtertxt_CSS", questionnaireTitle2);

			// verification of the created questionnaire
			try {
				questionnaire = "//td[text()='" + questionnaireTitle2 + "']";
				String questionnaire_actual = (driver.findElement(By.xpath(questionnaire)).getText()).trim();

				if (questionnaire_actual.equals(questionnaireTitle2)) {

					successMessage("The newly created questionnaire of property level is verified successfully.");

				} else {
					verificationFailedMessage("The newly created questionnaire of property level is not verified.");
				}
			} catch (Throwable t) {
				verificationFailedMessage("The newly created questionnaire of property level is not verified.");
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

		// CREATED A NEW INSPECTION AT PROPERTY LEVEL
		title("CREATED A NEW INSPECTION AT PROPERTY LEVEL");

		String inspectionTitle = RandomStringUtils.randomAlphabetic(8);

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
			select("checklist_addchecklist_checklisttypedd_CSS", questionnaireTitle2);

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

		} catch (Throwable t) {
			verificationFailed();
		}

		// click on the Home button
		click("questionnaire_homeburgermenubtn_hide_CSS");

		// wait for the element
		explicitWait("propertylist_title_XPATH");

		// verify the property list
		switchVerification("propertylist_title_XPATH", "Property List", "The property list is not displayed.");

		// CREATE NEW CUSTOM FORMS FOR SINGLE RECORD TYPE
		title("CREATE NEW CUSTOM FORMS FOR SINGLE RECORD TYPE");

		String name = RandomStringUtils.randomAlphabetic(8); // Custom Form Name
		String fieldName1 = RandomStringUtils.randomAlphabetic(8); // Normal Field 1
		String fieldName2 = RandomStringUtils.randomAlphabetic(8); // Normal Field 2
		String fieldDetail1 = RandomStringUtils.randomAlphabetic(8); // Normal Field Detail 1
		String fieldDetail2 = RandomStringUtils.randomNumeric(3); // Normal Field Detail 2
		String pageName1 = RandomStringUtils.randomAlphabetic(8); // Page Name 1
		String pageFieldName1 = RandomStringUtils.randomAlphabetic(8); // Page Name 1 - Field 1
		String pageFieldName2 = RandomStringUtils.randomAlphabetic(8); // Page Name 1 - Field 2
		String pageFieldDetail1 = RandomStringUtils.randomAlphabetic(8); // Page Name 2 - Field Details 1
		String pageFieldDetail2 = RandomStringUtils.randomNumeric(3); // Page Name 2 - Field Details 2

		try {

			// Wait for the element
			Thread.sleep(5000);

			// click on the settings icon from the top of the screen
			click("questionnaire_settingicon_CSS");

			// wait for the element
			explicitWaitClickable("questionnaire_administrationoption_XPATH");

			// click on the Administration option from the side menu
			click("questionnaire_administrationoption_XPATH");

			// click on the system tab
			click("questionnaire_systemtab_XPATH");

			// click on the custom form option
			click("customform_option_XPATH");

			// click on the add button
			click("customform_addbtn_XPATH");

			// enter name of the form in the name field
			type("customform_nametxt_XPATH", name);

			// select the single report type from the drop down
			select("customform_recordtypedd_XPATH", data.get("type_1"));

			// click on the date sensitive checkbox
			click("customform_datesensitiveckbx_XPATH");

			// click on the Is Verification Workflow Enabled? checkbox
			click("customform_verificationckbx_XPATH");

			// click on the save button
			click("customform_savebtn_XPATH");

			// wait for the element
			Thread.sleep(5000);

			// validate the Report Name details of the newly created report
			try {
				String Validation0 = "//td[text()='" + name + "']";
				String Validation0_actual = (driver.findElement(By.xpath(Validation0)).getText()).trim();

				if (Validation0_actual.equals(name)) {

					successMessage("The Report Name detail is displayed correctly.");

				} else {
					verificationFailedMessage("The Report Name detail is displayed correctly.");
				}

			} catch (Throwable t) {
				verificationFailedMessage("The Report Name detail is displayed correctly.");
			}

			// click on the newly created custom record record
			String nameTitle = "//td[text()='" + name + "']";
			driver.findElement(By.xpath(nameTitle)).click();
			consoleMessage("Clicked on the newly created custom record record.");

			// click on the add field button
			click("customform_addfieldbtn_XPATH");

			// enter field name
			type("customform_addfield_nametxt_XPATH", fieldName1);

			// select the option from the type dropdown
			select("customform_addfield_typedd_XPATH", data.get("fieldtype_1"));

			// click on the display on list checkbox
			click("customform_addfield_displayonlistckbx_XPATH");

			// click on the unique identifier checkbox
			click("customform_addfield_uniqueidentifierckbx_XPATH");

			// click on the add button
			click("customform_addfield_addbtn_XPATH");

			// wait for the element
			explicitWaitClickable("closetoastmsg_CSS");

			// click on the toaster close button
			click("closetoastmsg_CSS");

			// validate the newly created field
			try {
				String field1 = "//span[text()='" + fieldName1 + "']";
				String field1_actual = (driver.findElement(By.xpath(field1)).getText()).trim();

				if (field1_actual.equals(fieldName1)) {
					successMessage("The newly created field is displayed successfully.");
				} else {
					verificationFailedMessage("The newly created field is not displayed.");
				}
			} catch (Throwable t) {
				verificationFailedMessage("The newly created field is not displayed.");
			}

			// click on the add field button
			click("customform_addfieldbtn_XPATH");

			// enter field name
			type("customform_addfield_nametxt_XPATH", fieldName2);

			// select the option from the type dropdown
			select("customform_addfield_typedd_XPATH", data.get("fieldtype_2"));

			// click on the display on list checkbox
			click("customform_addfield_displayonlistckbx_XPATH");

			// click on the unique identifier checkbox
			click("customform_addfield_uniqueidentifierckbx_XPATH");

			// click on the add button
			click("customform_addfield_addbtn_XPATH");

			// wait for the element
			explicitWaitClickable("closetoastmsg_CSS");

			// click on the toaster close button
			click("closetoastmsg_CSS");

			// validate the newly created field
			try {
				String field2 = "//span[text()='" + fieldName2 + "']";
				String field2_actual = (driver.findElement(By.xpath(field2)).getText()).trim();

				if (field2_actual.equals(fieldName2)) {
					successMessage("The newly created field is displayed successfully.");
				} else {
					verificationFailedMessage("The newly created field is not displayed.");
				}
			} catch (Throwable t) {
				verificationFailedMessage("The newly created field is not displayed.");
			}

			// click on the add new page icon
			click("customform_portfoliodashboard_addnewpagebtn_XPATH");

			// enter the first page name name in the page name field
			type("customform_portfoliodashboard_pagenametxt_XPATH", pageName1);

			// click on the add button
			click("customform_portfoliodashboard_pagename_addbtn_XPATH");

			// validate the newly added page
			try {
				String page1 = "//span[contains(text(),'" + pageName1 + "')]";
				String page1_actual = (driver.findElement(By.xpath(page1)).getText()).trim();

				if (page1_actual.equals(pageName1)) {
					successMessage("The newly created page is displayed successfully.");
				} else {
					verificationFailedMessage("The newly created page is not displayed.");
				}
			} catch (Throwable t) {
				verificationFailedMessage("The newly created page is not displayed.");
			}

			// click on the update button
			click("customform_updatebtn_XPATH");

			// wait for the element
			explicitWaitClickable("closetoastmsg_CSS");

			// click on the toaster close button
			click("closetoastmsg_CSS");

			// ADD FIELDS IN THE FIRST PAGE
			title("ADD FIELDS IN THE FIRST PAGE");

			// Wait for the element
			Thread.sleep(5000);

			// click on the first page name tab
			String page1 = "//span[contains(text(),'" + pageName1 + "')]";
			driver.findElement(By.xpath(page1)).click();
			consoleMessage("Clicked on the first page name tab.");

			// click on the add field button
			click("customform_addfieldbtn_XPATH");

			// scroll to bottom
			scrollBottom();

			// enter field name
			type("customform_addfield_nametxt_XPATH", pageFieldName1);

			// select the option from the type dropdown
			select("customform_addfield_typedd_XPATH", data.get("fieldtype_1"));

			// click on the display on list checkbox
			click("customform_addfield_displayonlistckbx_XPATH");

			// click on the unique identifier checkbox
			click("customform_addfield_uniqueidentifierckbx_XPATH");

			// click on the add button
			click("customform_addfield_addbtn_XPATH");

			// wait for the element
			explicitWaitClickable("closetoastmsg_CSS");

			// click on the toaster close button
			click("closetoastmsg_CSS");

			// click on the first page name tab
			String page11 = "//span[contains(text(),'" + pageName1 + "')]";
			driver.findElement(By.xpath(page11)).click();
			consoleMessage("Clicked on the first page name tab.");

			// scroll to bottom
			scrollBottom();

			// validate the newly created field
			try {
				String field1 = "//span[text()='" + pageFieldName1 + "']";
				String field1_actual = (driver.findElement(By.xpath(field1)).getText()).trim();

				if (field1_actual.equals(pageFieldName1)) {
					successMessage("The newly created field is displayed successfully.");
				} else {
					verificationFailedMessage("The newly created field is not displayed.");
				}
			} catch (Throwable t) {
				verificationFailedMessage("The newly created field is not displayed.");
			}

			// click on the add field button
			click("customform_addfieldbtn_XPATH");

			// scroll to bottom
			scrollBottom();

			// enter field name
			type("customform_addfield_nametxt_XPATH", pageFieldName2);

			// select the option from the type dropdown
			select("customform_addfield_typedd_XPATH", data.get("fieldtype_2"));

			// click on the display on list checkbox
			click("customform_addfield_displayonlistckbx_XPATH");

			// click on the unique identifier checkbox
			click("customform_addfield_uniqueidentifierckbx_XPATH");

			// click on the add button
			click("customform_addfield_addbtn_XPATH");

			// wait for the element
			explicitWaitClickable("closetoastmsg_CSS");

			// click on the toaster close button
			click("closetoastmsg_CSS");

			// click on the first page name tab
			String page111 = "//span[contains(text(),'" + pageName1 + "')]";
			driver.findElement(By.xpath(page111)).click();
			consoleMessage("Clicked on the first page name tab.");

			// scroll to bottom
			scrollBottom();

			// validate the newly created field
			try {
				String field2 = "//span[text()='" + pageFieldName2 + "']";
				String field2_actual = (driver.findElement(By.xpath(field2)).getText()).trim();

				if (field2_actual.equals(pageFieldName2)) {
					successMessage("The newly created field is displayed successfully.");
				} else {
					verificationFailedMessage("The newly created field is not displayed.");
				}
			} catch (Throwable t) {
				verificationFailedMessage("The newly created field is not displayed.");
			}

			// click on the update button
			click("customform_updatebtn_XPATH");

			// wait for the element
			explicitWaitClickable("closetoastmsg_CSS");

			// click on the toaster close button
			click("closetoastmsg_CSS");

		} catch (Throwable t) {
			verificationFailed();
		}

		// click on the home icon from the top of the screen
		click("questionnaire_homeburgermenubtn_CSS");

		// wait for the element
		explicitWait("propertylist_title_XPATH");

		// verify the property list
		switchVerification("propertylist_title_XPATH", "Property List", "The property list is not displayed.");

		// ADD THE DETAILS IN THE FIELDS OF NEWLY ADDED PAGES
		title("ADD THE DETAILS IN THE FIELDS OF NEWLY ADDED PAGES");

		try {

			// wait for the element
			Thread.sleep(5000);

			// click on the side menu
			click("menubtn_CSS");

			// wait for the element
			Thread.sleep(5000);

			// click on the portfolio dashboard from side menu
			click("sidemenu_portfoliosummary_XPATH");

			// scrolldown till Property Information section
			scrollTillElement("customform_portfoliodashboard_propertyinformationtitle_XPATH");

			// validate the newly created custom form in the portfolio dashboard screen
			try {
				String customForm1 = "//td[text()='" + name + "']";
				String customForm1_actual = (driver.findElement(By.xpath(customForm1)).getText()).trim();

				if (customForm1_actual.equals(name)) {
					successMessage("The newly created custom form is displayed successfully.");

				} else {
					verificationFailedMessage("The newly created custom form is not displayed.");
				}

			} catch (Throwable t) {
				verificationFailedMessage("The newly created custom form is not displayed.");
			}

			// click on the custom form
			String customForm1 = "//td[text()='" + name + "']";
			driver.findElement(By.xpath(customForm1)).click();
			consoleMessage("Clicked on the custom form.");

			// click on the property one
			click("customform_portfoliodashboard_propertyname_XPATH");

			// ADD THE DETAILS IN THE FIELDS OF THE DETAILS TAB
			title("ADD THE DETAILS IN THE FIELDS OF THE DETAILS TAB");

			// scroll down to bottom
			scrollBottom();

			// click on the edit field button
			click("customform_portfoliodashboard_editfieldbtn_XPATH");

			// enter the details in the first field
			String firstField = "//input[@id='" + fieldName1 + "TEXT']";
			driver.findElement(By.xpath(firstField)).sendKeys(fieldDetail1);
			consoleMessage("Entered the details in the first field.");

			// enter the details in the second field
			String secondField = "//input[@id='" + fieldName2 + "NUMBER']";
			driver.findElement(By.xpath(secondField)).sendKeys(fieldDetail2);
			consoleMessage("Entered the details in the second field.");

			// click on the save button
			click("customform_portfoliodashboard_fields_savebtn_XPATH");

			// scroll to bottom
			scrollBottom();

			// wait for the element
			Thread.sleep(5000);

			// click on the details tab
			String details = "//span[text()='Details']";
			driver.findElement(By.xpath(details)).click();
			consoleMessage("Clicked on the details tab.");

			// validate the details of the first field
			try {
				String firstField1 = "//span[contains(text(),'" + fieldDetail1 + "')]";
				String firstField1_actual = (driver.findElement(By.xpath(firstField1)).getText()).trim();

				if (firstField1_actual.equals(fieldDetail1)) {
					successMessage("The details of the first field is displayed successfully.");
				} else {
					verificationFailedMessage("The details of the first field is not displayed.");
				}
			} catch (Throwable t) {
				verificationFailedMessage("The details of the first field is not displayed.");
			}

			// validate the details of the second field
			try {
				String secondField1 = "//span[contains(text(),'" + fieldDetail2 + "')]";
				String secondField1_actual = (driver.findElement(By.xpath(secondField1)).getText()).trim();

				if (secondField1_actual.equals(fieldDetail2)) {
					successMessage("The details of the second field is displayed successfully.");
				} else {
					verificationFailedMessage("The details of the second field is not displayed.");
				}
			} catch (Throwable t) {
				verificationFailedMessage("The details of the second field is not displayed.");
			}

			// click on the first page name tab
			String pageTab1 = "//span[text()='" + pageName1 + "']";
			driver.findElement(By.xpath(pageTab1)).click();
			consoleMessage("Clicked on the first page name tab.");

			// ADD THE DETAILS IN THE FIELDS OF THE FIRST PAGE TAB
			title("ADD THE DETAILS IN THE FIELDS OF THE FIRST PAGE TAB");

			// scroll to bottom
			scrollBottom();

			// click on the edit field button
			click("customform_portfoliodashboard_editfieldbtn_XPATH");

			// enter the details in the first field
			String firstPageField = "//input[@id='" + pageFieldName1 + "TEXT']";
			driver.findElement(By.xpath(firstPageField)).sendKeys(pageFieldDetail1);
			consoleMessage("Entered the details in the first field.");

			// enter the details in the second field
			String secondPageField = "//input[@id='" + pageFieldName2 + "NUMBER']";
			driver.findElement(By.xpath(secondPageField)).sendKeys(pageFieldDetail2);
			consoleMessage("Entered the details in the second field.");

			// click on the save button
			click("customform_portfoliodashboard_fields_savebtn_XPATH");

			// scroll to bottom
			scrollBottom();

			// wait for the element
			Thread.sleep(5000);

			// validate the details of the first field of the first page
			try {
				String firstField1 = "//span[contains(text(),'" + pageFieldDetail1 + "')]";
				String firstField1_actual = (driver.findElement(By.xpath(firstField1)).getText()).trim();

				if (firstField1_actual.equals(pageFieldDetail1)) {
					successMessage("The details of the first field of the first page is displayed successfully.");
				} else {
					verificationFailedMessage("The details of the first field of the first page is not displayed.");
				}
			} catch (Throwable t) {
				verificationFailedMessage("The details of the first field of the first page is not displayed.");
			}

			// validate the details of the second field of the first page
			try {
				String secondField1 = "//span[contains(text(),'" + pageFieldDetail2 + "')]";
				String secondField1_actual = (driver.findElement(By.xpath(secondField1)).getText()).trim();

				if (secondField1_actual.equals(pageFieldDetail2)) {
					successMessage("The details of the second field of the first page is displayed successfully.");
				} else {
					verificationFailedMessage("The details of the second field of the first page is not displayed.");
				}
			} catch (Throwable t) {
				verificationFailedMessage("The details of the second field is of the first page not displayed.");
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

		// CREATE THE NEW TASK WITH TASK TYPE AND ASSOCIATE THE NEWLY CREATED SURVEY
		// WITH THE TASK AT PROPERTY LEVEL
		title("CREATE THE NEW TASK WITH TASK TYPE AND ASSOCIATE THE NEWLY CREATED SURVEY WITH THE TASK AT PROPERTY LEVEL");

		String taskTitle1 = RandomStringUtils.randomAlphabetic(8);

		try {
			// wait for the element
			Thread.sleep(3000);

			// click on the task icon of the respective property
			click("taskicon_CSS");

			// click on the add task button
			click("task_addtaskbtn_CSS");

			// click on the task type field
			click("task_taskassociationtab_tasktypetxt_XPATH");

			// click on the clear button
			click("task_taskassociationtab_tasktype_clearbtn_XPATH");

			// enter the task type in the search field
			type("task_taskassociationtab_tasktype_searchtxt_XPATH", taskType);

			// click on the searched result
			String expected = "(//span[text()='" + taskType + "'])[2]";
			driver.findElement(By.xpath(expected)).click();
			consoleMessage("Clicked on the searched result.");

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

		// CREATE THE NEW TASK WITH TASK TYPE AND ASSOCIATE THE NEWLY CREATED
		// INSPECTION WITH THE TASK AT PROPERTY LEVEL
		title("CREATE THE NEW TASK WITH TASK TYPE AND ASSOCIATE THE NEWLY CREATED INSPECTION WITH THE TASK AT PROPERTY LEVEL");

		String taskTitle2 = RandomStringUtils.randomAlphabetic(8);

		try {
			// wait for the element
			Thread.sleep(3000);

			// click on the task icon of the respective property
			click("taskicon_CSS");

			// click on the add task button
			click("task_addtaskbtn_CSS");

			// click on the task type field
			click("task_taskassociationtab_tasktypetxt_XPATH");

			// click on the clear button
			click("task_taskassociationtab_tasktype_clearbtn_XPATH");

			// enter the task type in the search field
			type("task_taskassociationtab_tasktype_searchtxt_XPATH", taskType);

			// click on the searched result
			String expected = "(//span[text()='" + taskType + "'])[2]";
			driver.findElement(By.xpath(expected)).click();
			consoleMessage("Clicked on the searched result.");

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
			select("survey_task_questionnairedd_CSS", questionnaireTitle2);

			// click on the save button
			click("survey_task_savebtn_XPATH");

			// scroll up the screen
			scrollTop();

			// click on the clear button
			click("task_createdtask_clearbtn_XPATH");

			// enter the data in the search field
			type("task_filter_CSS", taskTitle2);

			// click on the search button
			click("task_createdtask_searchbtn_XPATH");

			// verify newly created task is displayed or not
			try {
				String task = "//p[contains(text(),'" + taskTitle2 + "')]";
				String task_actual = (driver.findElement(By.xpath(task)).getText()).trim();

				if (task_actual.equals(taskTitle2)) {
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
			String task = "//p[contains(text(),'" + taskTitle2 + "')]";
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
				String selectedQuestionnaire = "//option[@label='" + questionnaireTitle2
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

			// validate correct inspection is launched or not
			try {
				String inspection3 = "//li[text()='" + inspectionTitle + "']";
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

		// CREATE THE NEW TASK WITH TASK TYPE AND ASSOCIATE THE NEWLY CREATED SINGLE
		// TYPE CUSTOM FORM WITH THE TASK
		title("CREATE THE NEW TASK WITH TASK TYPE AND ASSOCIATE THE NEWLY CREATED SINGLE TYPE CUSTOM FORM WITH THE TASK");

		String taskTitle3 = RandomStringUtils.randomAlphabetic(8);

		try {
			// wait for the element
			Thread.sleep(3000);

			// click on the task icon of the respective property
			click("taskicon_CSS");

			// click on the add task button
			click("task_addtaskbtn_CSS");

			// click on the task type field
			click("task_taskassociationtab_tasktypetxt_XPATH");

			// click on the clear button
			click("task_taskassociationtab_tasktype_clearbtn_XPATH");

			// enter the task type in the search field
			type("task_taskassociationtab_tasktype_searchtxt_XPATH", taskType);

			// click on the searched result
			String expected = "(//span[text()='" + taskType + "'])[2]";
			driver.findElement(By.xpath(expected)).click();
			consoleMessage("Clicked on the searched result.");

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

			// click on the custom form button
			click("task_taskassociationtab_customformbtn_XPATH");

			// select the newly created custom form from the dropdown
			select("survey_task_questionnairedd_CSS", name);

			// click on the save button
			click("survey_task_savebtn_XPATH");

			// scroll up the screen
			scrollTop();

			// click on the clear button
			click("task_createdtask_clearbtn_XPATH");

			// enter the data in the search field
			type("task_filter_CSS", taskTitle3);

			// click on the search button
			click("task_createdtask_searchbtn_XPATH");

			// verify newly created task is displayed or not
			try {
				String task = "//p[contains(text(),'" + taskTitle3 + "')]";
				String task_actual = (driver.findElement(By.xpath(task)).getText()).trim();

				if (task_actual.equals(taskTitle3)) {
					successMessage("The newly created task is verified successfully.");
				} else {
					verificationFailedMessage("The newly created task is not verified.");
				}
			} catch (Throwable t) {
				verificationFailedMessage("The newly created task is not verified.");
			}

			// VERIFY JUMP SURVEY/INSPECTION/CUSTOM FORM BUTTON SHOULD LAUNCH ASSOCIATED
			// CORPORATE LEVEL CUSTOM FORM
			title("VERIFY JUMP SURVEY/INSPECTION/CUSTOM FORM BUTTON SHOULD LAUNCH ASSOCIATED CORPORATE LEVEL CUSTOM FORM");

			// click on the newly created task
			String task = "//p[contains(text(),'" + taskTitle3 + "')]";
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

			// validate the dropdown of custom form
			try {
				boolean dropdown = driver
						.findElement(By.xpath(OR.getProperty("task_taskassociationtab_questionnerdd_disabled_XPATH")))
						.isEnabled();

				if (dropdown == false) {
					successMessage("The dropdown of custom form disabled as expected.");
				} else {
					verificationFailedMessage("The dropdown of custom form is not displayed disabled.");
				}
			} catch (Throwable t) {
				verificationFailedMessage("The dropdown of custom form is not displayed disabled.");
			}

			// validate the selected custom form is displayed or not
			try {
				String selectedQuestionnaire = "//option[@label='" + name + "' and @selected='selected']";
				boolean dropdown = driver.findElement(By.xpath(selectedQuestionnaire)).isDisplayed();

				if (dropdown == true) {
					successMessage("The selected option in the custom form dropdown is displayed as expected.");
				} else {
					verificationFailedMessage("The selected option in the custom form dropdown is not displayed.");
				}
			} catch (Throwable t) {
				verificationFailedMessage("The selected option in the custom form dropdown is not displayed.");
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

			// wait for the element
			Thread.sleep(10000);

			// scroll up to top
			scrollTop();

			// validate the custom form as a title
			try {
				String customName = "//h4[contains(text(),'" + name + "')]";
				String customName_actual = (driver.findElement(By.xpath(customName)).getText()).trim();

				if (customName_actual.equals(name)) {
					successMessage("The custom form name is displayed correctly.");
				} else {
					verificationFailedMessage("The custom form is not displayed.");
				}
			} catch (Throwable t) {
				verificationFailedMessage("The custom form is not displayed.");
			}

			// click on the details tab
			String details = "//span[text()='Details']";
			driver.findElement(By.xpath(details)).click();
			consoleMessage("Clicked on the details tab.");

			// scroll down to bottom
			scrollBottom();

			// validate the first field label
			try {
				String fieldLabel1 = "//label[contains(text(),'" + fieldName1 + "')]";
				String fieldLabel1_actual = (driver.findElement(By.xpath(fieldLabel1)).getText()).trim();

				if (fieldLabel1_actual.equals(fieldName1 + ":")) {
					successMessage("The first field label is displayed successfully.");
				} else {
					verificationFailedMessage("The first field label is not displayed.");
				}
			} catch (Throwable t) {
				verificationFailedMessage("The first field label is not displayed.");
			}

			// validate the second field label
			try {
				String fieldLabel2 = "//label[contains(text(),'" + fieldName2 + "')]";
				String fieldLabel2_actual = (driver.findElement(By.xpath(fieldLabel2)).getText()).trim();

				if (fieldLabel2_actual.equals(fieldName2 + ":")) {
					successMessage("The second field label is displayed successfully.");
				} else {
					verificationFailedMessage("The second field label is not displayed.");
				}
			} catch (Throwable t) {
				verificationFailedMessage("The second field label is not displayed.");
			}

			// click on the first page name tab
			String pageTab1 = "//span[text()='" + pageName1 + "']";
			driver.findElement(By.xpath(pageTab1)).click();
			consoleMessage("Clicked on the first page name tab.");

			// scroll to bottom
			scrollBottom();

			// validate the third field label
			try {
				String fieldLabel3 = "//label[contains(text(),'" + pageFieldName1 + "')]";
				String fieldLabel3_actual = (driver.findElement(By.xpath(fieldLabel3)).getText()).trim();

				if (fieldLabel3_actual.equals(pageFieldName1 + ":")) {
					successMessage("The third field label is displayed successfully.");
				} else {
					verificationFailedMessage("The third field label is not displayed.");
				}
			} catch (Throwable t) {
				verificationFailedMessage("The third field label is not displayed.");
			}

			// validate the forth field label
			try {
				String fieldLabel4 = "//label[contains(text(),'" + pageFieldName2 + "')]";
				String fieldLabel4_actual = (driver.findElement(By.xpath(fieldLabel4)).getText()).trim();

				if (fieldLabel4_actual.equals(pageFieldName2 + ":")) {
					successMessage("The forth field label is displayed successfully.");
				} else {
					verificationFailedMessage("The forth field label is not displayed.");
				}
			} catch (Throwable t) {
				verificationFailedMessage("The forth field label is not displayed.");
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

		// DELETE THE NEWLY CREATED TASKS FROM THE PROPERTY LEVEL
		title("DELETE THE NEWLY CREATED TASKS FROM THE PROPERTY LEVEL");

		try {
			// click on the task icon of the respective property
			click("taskicon_CSS");

			String[] taskTitle = { taskTitle1, taskTitle2, taskTitle3 };

			for (int i = 0; i < taskTitle.length; i++) {

				// click on the clear button
				click("task_createdtask_clearbtn_XPATH");

				// enter the data in the search field
				type("task_filter_CSS", taskTitle[i]);

				// click on the search button
				click("task_createdtask_searchbtn_XPATH");

				// verify newly created task is displayed or not
				try {
					String task = "//p[contains(text(),'" + taskTitle[i] + "')]";
					String task_actual = (driver.findElement(By.xpath(task)).getText()).trim();

					if (task_actual.equals(taskTitle[i])) {

						successMessage("The newly created task is verified successfully.");

					} else {
						verificationFailedMessage("The newly created task is not verified.");
					}
				} catch (Throwable t) {
					verificationFailedMessage("The newly created task is not verified.");
				}

				// click on the action icon
				String actionIcon = "//p[text()='" + taskTitle[i]
						+ "']//parent::td//following-sibling::td[@class='text-center pointer']//i[@data-toggle='dropdown']";
				driver.findElement(By.xpath(actionIcon)).click();
				consoleMessage("Clicked on the action icon.");

				// click on the delete option
				String deleteOption = "//p[text()='" + taskTitle[i]
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
				type("task_filter_CSS", taskTitle[i]);

				// click on the search button
				click("task_createdtask_searchbtn_XPATH");

				// validate the deleted task
				try {
					String task = "//p[contains(text(),'" + taskTitle[i] + "')]";
					String task_actual = (driver.findElement(By.xpath(task)).getText()).trim();

					if (task_actual.equals(taskTitle[i])) {
						verificationFailedMessage("The newly created task is not deleted.");
					} else {
						successMessage("The newly created task is deleted successfully.");
					}
				} catch (Throwable t) {
					successMessage("The newly created task is deleted successfully.");
				}

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

		// DELETE THE NEWLY CREATED SUNGLE TYPE AND MULTIPLE TYPE CUSTOMER FORM
		title("DELETE THE NEWLY CREATED SUNGLE TYPE AND MULTIPLE TYPE CUSTOMER FORM");

		try {

			// Wait for the element
			Thread.sleep(5000);

			// click on the settings icon from the top of the screen
			click("questionnaire_settingicon_CSS");

			// wait for the element
			explicitWaitClickable("questionnaire_administrationoption_XPATH");

			// click on the Administration option from the side menu
			click("questionnaire_administrationoption_XPATH");

			// click on the system tab
			click("questionnaire_systemtab_XPATH");

			// click on the custom form option
			click("customform_option_XPATH");

			// wait for the element
			Thread.sleep(5000);

			// click on the delete button of the newly created custom form
			String deleteIcon = "//td[text()='" + name
					+ "']//following-sibling::td[@class='pointer']//i[@data-target='#deleteCustomFormModal']";
			driver.findElement(By.xpath(deleteIcon)).click();
			consoleMessage("click on the delete button of the newly created custom form.");

			// wait for the element
			Thread.sleep(5000);

			// click on the delete button
			click("customform_deletebtn_XPATH");

			// wait for the element
			Thread.sleep(3000);

			// validate the deleted custom form
			try {
				String customform = "//td[text()='" + name + "']";
				String customform_actual = (driver.findElement(By.xpath(customform)).getText()).trim();

				if (customform_actual.equals(name)) {
					verificationFailedMessage("The deleted custom form is displayed.");
				} else {
					successMessage("The deleted custom form is not displayed as expected.");
				}
			} catch (Throwable t) {
				successMessage("The deleted custom form is not displayed as expected.");
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
			type("ssc_company2_questionnairelist_filtertxt_CSS", questionnaireTitle1);

			// click on the created questionnaire
			String questionnaire = "//td[text()='" + questionnaireTitle1 + "']";
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

			// enter newly created questionnaire in the filter field
			type("ssc_company2_questionnairelist_filtertxt_CSS", questionnaireTitle2);

			// click on the created questionnaire
			String questionnaire1 = "//td[text()='" + questionnaireTitle2 + "']";
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
			type("ssc_company2_questionnairelist_filtertxt_CSS", questionnaireTitle2);

			// validate the deleted questionnaire
			try {
				questionnaire = "//td[text()='" + questionnaireTitle2 + "']";
				String questionnaire_actual = (driver.findElement(By.xpath(questionnaire)).getText()).trim();

				if (questionnaire_actual.equals(questionnaireTitle2)) {
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
