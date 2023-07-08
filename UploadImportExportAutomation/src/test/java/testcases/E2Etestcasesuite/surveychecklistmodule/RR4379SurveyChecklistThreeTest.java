package testcases.E2Etestcasesuite.surveychecklistmodule;

import java.io.IOException;
import java.util.Hashtable;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.testng.Reporter;
import org.testng.SkipException;
import org.testng.annotations.Test;

import com.relevantcodes.extentreports.LogStatus;

import base.Helper;
import base.TestBase;
import utilities.TestUtil;

public class RR4379SurveyChecklistThreeTest extends TestBase {

	@Test(dataProviderClass = TestUtil.class, dataProvider = "dp")
	public void rR4379SurveyChecklistThreeTest(Hashtable<String, String> data)
			throws InterruptedException, IOException {

		execution(data, "rR4379SurveyChecklistThreeTest");

		// SURVEY WORKFLOW NOTIFICATION SHOULD FILTER COMPLETED SURVEY WHEN SENDING TO
		// "EDITORS - INCOMPLETE QUESTIONNAIRES" - Users with completed survey should
		// not be selected as default in Incomplete questionnaire option.

		System.out.println(
				"SURVEY WORKFLOW NOTIFICATION SHOULD FILTER COMPLETED SURVEY WHEN SENDING TO \"EDITORS - INCOMPLETE QUESTIONNAIRES\" - Users with completed survey should not be selected as default in Incomplete questionnaire option.");
		test.log(LogStatus.INFO,
				"SURVEY WORKFLOW NOTIFICATION SHOULD FILTER COMPLETED SURVEY WHEN SENDING TO \"EDITORS - INCOMPLETE QUESTIONNAIRES\" - Users with completed survey should not be selected as default in Incomplete questionnaire option.");
		Reporter.log(
				"SURVEY WORKFLOW NOTIFICATION SHOULD FILTER COMPLETED SURVEY WHEN SENDING TO \"EDITORS - INCOMPLETE QUESTIONNAIRES\" - Users with completed survey should not be selected as default in Incomplete questionnaire option.");
		log.info(
				"SURVEY WORKFLOW NOTIFICATION SHOULD FILTER COMPLETED SURVEY WHEN SENDING TO \"EDITORS - INCOMPLETE QUESTIONNAIRES\" - Users with completed survey should not be selected as default in Incomplete questionnaire option.");

		Helper helper = new Helper();

		// refresh the page
		driver.navigate().refresh();
		Thread.sleep(5000);
		driver.navigate().refresh();

		System.out.println("Navigate to the Home Screen i.e. Property List Screen.");

		// SWITCH THE SYSTEM COMPANY TO [DND]COMPANY 1

		try {
			// wait for the element
			explicitWaitClickable("questionnaire_settingicon_CSS");

			// click on the settings icon from the top of the screen
			click("questionnaire_settingicon_CSS");
			System.out.println("Clicked on the settings icon.");
			ngDriver.waitForAngularRequestsToFinish();

			// wait for the element
			Thread.sleep(5000);

			// click on the Switch System Company option from the side menu
			click("ssc_sidemenubtn_CSS");
			System.out.println("Clicked on the Switch System Company option from the side menu.");
			ngDriver.waitForAngularRequestsToFinish();

			// click on the switch system company dropdown
			click("ssc_systemcompanydd_CSS");
			System.out.println("Clicked on the switch system company.");
			ngDriver.waitForAngularRequestsToFinish();

			// select the company 2 from the system company dropdown
			select("ssc_systemcompanydd_CSS", data.get("system_company_1"));
			System.out.println("The company 1 is selected successfully.");
			ngDriver.waitForAngularRequestsToFinish();

			// click on system company dropdown
			click("ssc_systemcompanydd_CSS");
			System.out.println("Clicked on the system company dropdown.");
			ngDriver.waitForAngularRequestsToFinish();

			// click on the select button
			click("ssc_selectbtn_BTNTEXT");
			System.out.println("Clicked on the select button.");
			ngDriver.waitForAngularRequestsToFinish();

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

			// ADD NEW QUESTIONNIRE

			// click on the new questionnaire
			click("questionnaire_newquestionnairebtn_CSS");
			System.out.println("Click on the New Questionnire button");
			ngDriver.waitForAngularRequestsToFinish();
			System.out.println("Navigate to the add questionnire details screen.");

			// Select the type of the questionnaire
			click("questionnaire_type_propertybtn_CSS");
			System.out.println("The type of the questionnire is selected.");

			// Select the level of the questionnaire
			click("questionnaire_level_propertybtn_CSS");
			System.out.println("The level of the questionnire is selected.");

			// enter the group title
			type("questionnaire_grouptitletxt_CSS", data.get("group_title"));
			System.out.println("The data entered in the Group Title field.");

			// enter the questionnaire title
			type("questionnaire_questionnairetitletxt_CSS", data.get("questionnaire_title"));
			System.out.println("The data entered in the Questionnaire Title field.");

			// select the model
			select("questionnaire_modeldd_CSS", data.get("model"));
			System.out.println("The data entered in the Questionnaire Title field.");
			ngDriver.waitForAngularRequestsToFinish();

			// select the document/report type
			select("questionnaire_docreportdd_CSS", data.get("document_reporttype"));
			System.out.println("The data entered in the document/report type field.");
			ngDriver.waitForAngularRequestsToFinish();

			// select the default task tag
			select("questionnaire_defaulttasktagdd_CSS", data.get("default_task_tag"));
			System.out.println("The data entered in the default task tag field.");
			ngDriver.waitForAngularRequestsToFinish();

			// select the frequency
			select("questionnaire_frequencydd_CSS", data.get("frequency"));
			System.out.println("The data entered in the frequency field.");
			ngDriver.waitForAngularRequestsToFinish();

			// enter the year
			type("questionnaire_yeartxt_CSS", "2020");
			System.out.println("The data entered in the year field.");
			ngDriver.waitForAngularRequestsToFinish();

			// select the month
			select("questionnaire_monthtxt_CSS", data.get("month"));
			System.out.println("The data entered in the month field.");
			ngDriver.waitForAngularRequestsToFinish();

			// enter the description
			type("questionnaire_descriptiontxt_CSS", data.get("description"));
			System.out.println("The data entered in the description field.");

			// click on the save button
			click("questionnaire_savebtn_BTNTEXT");
			System.out.println("Clicked on the save button");
			ngDriver.waitForAngularRequestsToFinish();
			System.out.println("Navigate to the list of questionnaire screen.");

			// enter newly created questionnaire in the filter field
			type("ssc_company2_questionnairelist_filtertxt_CSS", data.get("questionnaire_title"));
			System.out.println("Entered newly created questionnaire in the filter field.");
			ngDriver.waitForAngularRequestsToFinish();

			// verification of the created questionnaire
			switchVerification("workflowsecurity_filteredsurveynotification_createdrecord_2_XPATH",
					"Test Filtered Survey Notification Workflow Three Security",
					"The Test Filtered Survey Notification Workflow Three Security is not displayed.");

		} catch (Throwable t) {

			verificationFailed();
		}

		// ADD CATEGORY 1 INTO THE QUESTIONNAIRE

		try {
			// click on the created questionnaire
			click("workflowsecurity_filteredsurveynotification_createdrecord_2_XPATH");
			System.out.println("Clicked on the newly created questionnaire.");
			ngDriver.waitForAngularRequestsToFinish();

			// scroll the screen towards more button
			WebElement element6 = driver
					.findElement(By.cssSelector(OR.getProperty("questionnaire_type_propertybtn_CSS")));
			JavascriptExecutor js = (JavascriptExecutor) driver;
			js.executeScript("arguments[0].scrollIntoView();", element6);
			System.out.println("Scrolled down the screen.");

			// click on the more button
			click("questionnaire_morebtn_CSS");
			System.out.println("Clicked on the more button.");

			// click on the configure questions option
			click("questionnaire_configurebtn_CSS");
			System.out.println("Clicked on the configure questions option.");
			ngDriver.waitForAngularRequestsToFinish();

			// click on the new category button
			click("questionnaire_newcategorybtn_BTNTEXT");
			System.out.println("Click on the new category button.");
			ngDriver.waitForAngularRequestsToFinish();

			// select the language
			select("questionnaire_newcategory_languagedd_XPATH", data.get("category_language"));
			System.out.println("The language is selected from the language dropdown.");
			ngDriver.waitForAngularRequestsToFinish();

			// enter the title
			type("questionnaire_newcategory_titletxt_MODEL", data.get("category_title_1"));
			System.out.println("The title entered in the title field.");
			ngDriver.waitForAngularRequestsToFinish();

			// click on the save button
			click("questionnaire_newcategory_savebtn_CSS");
			System.out.println("Click on the save button.");
			ngDriver.waitForAngularRequestsToFinish();

			// verify newly created category is displayed or not
			verifyTrue("questionnaire_newcategory_1_XPATH",
					"The newly created category is not displayed in the category list.");
			System.out.println("The newly created category is displayed successfully.");
			test.log(LogStatus.INFO, "The newly created category is displayed successfully.");

			// click on the save category button
			click("questionnaire_category_savebtn_CSS");
			System.out.println("Clicked on the save button.");
			ngDriver.waitForAngularRequestsToFinish();

			// ADD QUESTIONS INTO THE CATEGORY

			// click on the edit button of category one
			click("questionnaire_category_editbtn_CSS");
			System.out.println("Clicked on the edit button of category one");
			ngDriver.waitForAngularRequestsToFinish();

			// click on the edit question button
			click("questionnaire_category_editquestionbtn_BTNTEXT");
			System.out.println("Clicked on the edit question button.");
			ngDriver.waitForAngularRequestsToFinish();

			// click on the new question button
			click("questionnaire_newquestionbtn_CSS");
			System.out.println("Clicked on the new question button.");
			ngDriver.waitForAngularRequestsToFinish();

			// select the English language from the language dropdown
			select("questionnaire_newquestion_languagedd_CSS", data.get("question_language"));
			System.out.println("The English option is selected from the language dropdown.");
			ngDriver.waitForAngularRequestsToFinish();

			// enter the label
			type("questionnaire_newquestion_labeltxt_CSS", data.get("question_label_1"));
			System.out.println("The data entered in the label field.");
			ngDriver.waitForAngularRequestsToFinish();

			// enter the title
			type("questionnaire_newquestion_titletxt_CSS", data.get("question_title_1"));
			System.out.println("The data entered in the title field.");
			ngDriver.waitForAngularRequestsToFinish();

			// click on the save button
			click("questionnaire_newquestion_savebtn_CSS");
			System.out.println("Click on the save button.");
			ngDriver.waitForAngularRequestsToFinish();

			// verify question one created or not
			verifyTrue("questionnaire_newquestion_1_XPATH", "The question is not created.");
			System.out.println("The new question created successfully.");

			// click on the save button of the questions
			click("questionnaire_saveallquestionbtn_CSS");
			System.out.println("Clicked on the save button to save the question.");
			ngDriver.waitForAngularRequestsToFinish();

			// click on the edit question 1 button
			click("questionnaire_question_1_editbtn_CSS");
			System.out.println("Clicked on the edit button of the question 1.");
			ngDriver.waitForAngularRequestsToFinish();

			// scroll down the screen
			WebElement element1 = driver.findElement(
					By.cssSelector(OR.getProperty("questionnaire_question_1_commentandinstructiontxt_CSS")));
			js.executeScript("arguments[0].scrollIntoView();", element1);
			System.out.println("Scrolled down the screen.");

			// enter the data in the Comments and Instructions field
			type("questionnaire_question_1_commentandinstructiontxt_CSS", data.get("comment_instruction_1"));
			System.out.println("The data entered in the Comments and Instructions field.");

			// click on the option button
			click("questionnaire_question_1_optionbtn_CSS");
			System.out.println("Clicked on the option button.");
			ngDriver.waitForAngularRequestsToFinish();

			// ADD OPTION ONE IN THE QUESTION

			// click on the save button for all options
			click("questionnaire_question_1_savealloptionbtn_CSS");
			System.out.println("Clicked on the save button for save the option list.");
			ngDriver.waitForAngularRequestsToFinish();

			// click on the new option button
			click("questionnaire_question_1_newoptionbtn_CSS");
			System.out.println("Clicked on the option button");
			ngDriver.waitForAngularRequestsToFinish();

			// enter data in title of the option of the question 1
			type("questionnaire_question_1_newoption_1_titletext_CSS", data.get("title_option_1_question_1"));
			System.out.println("The title is entered successfully for create new option 1 of the question 1");

			// select data in type of the option of the question 1
			type("questionnaire_question_1_newoption_1_typetext_CSS", data.get("type_option_1_question_1"));
			System.out.println("The type is entered successfully for create new option 1 of the question 1");
			ngDriver.waitForAngularRequestsToFinish();

			// enter data in extra of the option of the question 1
			type("questionnaire_question_1_newoption_1_extratext_CSS", data.get("extra_option_1_question_1"));
			System.out.println("The extra is entered successfully for create new option 1 of the question 1");

			// click on the save button
			click("questionnaire_question_1_newoption_1_savebtn_CSS");
			System.out.println("Clicked on the save button");
			ngDriver.waitForAngularRequestsToFinish();

			// click on the save button for all options
			click("questionnaire_question_1_savealloptionbtn_CSS");
			System.out.println("Clicked on the save button for save the option list.");
			ngDriver.waitForAngularRequestsToFinish();

			// click on the back to questions button
			click("questionnaire_question_1_option_backtoquestionsbtn_CSS");
			System.out.println("Clicked on the back to questions button.");
			ngDriver.waitForAngularRequestsToFinish();

			// click on the save button for save all question
			click("questionnaire_saveallquestionbtn_CSS");
			System.out.println("Clicked on the save button for save all questions.");
			ngDriver.waitForAngularRequestsToFinish();

			// click on the back to category button
			click("questionnaire_question_1_backtocategorybtn_CSS");
			System.out.println("Clicked on the back to categories button.");
			ngDriver.waitForAngularRequestsToFinish();

			// click on the save button for save all categories
			click("questionnaire_category_savebtn_CSS");
			System.out.println("Clicked on the save button for save all questions.");
			ngDriver.waitForAngularRequestsToFinish();

			// click on the back to questionnaire button
			click("questionnaire_category_backtoquestionnairesbtn_CSS");
			System.out.println("Clicked on the back to questionnaires button.");
			ngDriver.waitForAngularRequestsToFinish();

			// enter newly created questionnaire in the filter field
			clear("ssc_company2_questionnairelist_filtertxt_CSS");
			ngDriver.waitForAngularRequestsToFinish();
			type("ssc_company2_questionnairelist_filtertxt_CSS", data.get("questionnaire_title"));
			System.out.println("Entered newly created questionnaire in the filter field.");
			ngDriver.waitForAngularRequestsToFinish();

			// verification of the created questionnaire
			switchVerification("workflowsecurity_filteredsurveynotification_createdrecord_2_XPATH",
					"Test Filtered Survey Notification Workflow Three Security",
					"The Test Filtered Survey Notification Workflow Three Security is not displayed.");

		} catch (Throwable t) {
			verificationFailed();
		}

		// ADD THE USER IN WORKFLOW AND SECURITY FOR PROPERTY - 1

		try {
			// click on the home menu burger button
			click("questionnaire_homeburgermenubtn_CSS");
			System.out.println("Click on the home burger menu icon.");
			ngDriver.waitForAngularRequestsToFinish();
			System.out.println("Navigate to the Home Screen i.e. Property List Screen.");

			// wait for the element
			explicitWait("envreports_propertylist_filtertxt_CSS");

			// enter property name in the search field
			clear("envreports_propertylist_filtertxt_CSS");
			System.out.println("Cleard the property search field.");
			ngDriver.waitForAngularRequestsToFinish();
			type("envreports_propertylist_filtertxt_CSS", data.get("property_1"));
			System.out.println("Entered the property name in the search name.");
			ngDriver.waitForAngularRequestsToFinish();

			// wait for the element
			explicitWaitClickable("environmentalicon_CSS");

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

			// click on the no button of the first question of the first category
			click("survey_noanswerbtn_1_CSS");
			System.out.println("Clicked on the no button of the first question of the first category.");
			ngDriver.waitForAngularRequestsToFinish();

			// wait for the element
			explicitWaitClickable("workflowsecurity_workflowsecuritybtn_CSS");

			// click on the workflow and security button
			click("workflowsecurity_workflowsecuritybtn_CSS");
			System.out.println("Clicked on the workflow and security button.");
			ngDriver.waitForAngularRequestsToFinish();

			// click on the select user field of the editor tasks section
			click("workflowsecurity_allowtoedit_editortasks_CSS");
			System.out.println("Clicked on the select user field of the editor tasks section.");
			ngDriver.waitForAngularRequestsToFinish();

			// click on the none button
			click("workflowsecurity_sendnotification_nonebtn_CSS");
			System.out.println("Clicked on the none button.");
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

			// click on the save button
			click("workflowsecurity_editortask_savebtn_CSS");
			System.out.println("Clicked on the save button.");
			ngDriver.waitForAngularRequestsToFinish();

			// verify the newly created record

			switchVerification("workflowsecurity_sendnotification_firsttableuser_XPATH", "Jinesh",
					"The user is not selected.");

			// ADD THE USER IN WORKFLOW AND SECURITY FOR PROPERTY - 2

			// click on the home menu burger button
			click("questionnaire_homeburgermenubtn_hide_CSS");
			System.out.println("Click on the home burger menu icon.");
			ngDriver.waitForAngularRequestsToFinish();
			System.out.println("Navigate to the Home Screen i.e. Property List Screen.");

			// wait for the element
			explicitWait("envreports_propertylist_filtertxt_CSS");

			// enter property name in the search field
			clear("envreports_propertylist_filtertxt_CSS");
			System.out.println("Cleard the property search field.");
			ngDriver.waitForAngularRequestsToFinish();
			type("envreports_propertylist_filtertxt_CSS", data.get("property_2"));
			System.out.println("Entered the property name in the search name.");
			ngDriver.waitForAngularRequestsToFinish();

			// wait for the element
			explicitWaitClickable("environmentalicon_CSS");

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

			// click on the no button of the first question of the first category
			click("survey_noanswerbtn_1_CSS");
			System.out.println("Clicked on the no button of the first question of the first category.");
			ngDriver.waitForAngularRequestsToFinish();

			// wait for the element
			explicitWaitClickable("workflowsecurity_workflowsecuritybtn_CSS");

			// click on the workflow and security button
			click("workflowsecurity_workflowsecuritybtn_CSS");
			System.out.println("Clicked on the workflow and security button.");
			ngDriver.waitForAngularRequestsToFinish();

			// click on the select user field of the editor tasks section
			click("workflowsecurity_allowtoedit_editortasks_CSS");
			System.out.println("Clicked on the select user field of the editor tasks section.");
			ngDriver.waitForAngularRequestsToFinish();

			// click on the none button
			click("workflowsecurity_sendnotification_nonebtn_CSS");
			System.out.println("Clicked on the none button.");
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

			// click on the save button
			click("workflowsecurity_editortask_savebtn_CSS");
			System.out.println("Clicked on the save button.");
			ngDriver.waitForAngularRequestsToFinish();

			// verify the newly created record

			switchVerification("workflowsecurity_sendnotification_firsttableuser_XPATH", "Jinesh",
					"The user is not selected.");

			// ADD THE USER IN WORKFLOW AND SECURITY FOR PROPERTY - 3

			// click on the home menu burger button
			click("questionnaire_homeburgermenubtn_hide_CSS");
			System.out.println("Click on the home burger menu icon.");
			ngDriver.waitForAngularRequestsToFinish();
			System.out.println("Navigate to the Home Screen i.e. Property List Screen.");

			// wait for the element
			explicitWait("envreports_propertylist_filtertxt_CSS");

			// enter property name in the search field
			clear("envreports_propertylist_filtertxt_CSS");
			System.out.println("Cleard the property search field.");
			ngDriver.waitForAngularRequestsToFinish();
			type("envreports_propertylist_filtertxt_CSS", data.get("property_3"));
			System.out.println("Entered the property name in the search name.");
			ngDriver.waitForAngularRequestsToFinish();

			// wait for the element
			explicitWaitClickable("environmentalicon_CSS");

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

			// click on the no button of the first question of the first category
			click("survey_noanswerbtn_1_CSS");
			System.out.println("Clicked on the no button of the first question of the first category.");
			ngDriver.waitForAngularRequestsToFinish();

			// wait for the element
			explicitWaitClickable("workflowsecurity_workflowsecuritybtn_CSS");

			// click on the workflow and security button
			click("workflowsecurity_workflowsecuritybtn_CSS");
			System.out.println("Clicked on the workflow and security button.");
			ngDriver.waitForAngularRequestsToFinish();

			// click on the select user field of the editor tasks section
			click("workflowsecurity_allowtoedit_editortasks_CSS");
			System.out.println("Clicked on the select user field of the editor tasks section.");
			ngDriver.waitForAngularRequestsToFinish();

			// click on the none button
			click("workflowsecurity_sendnotification_nonebtn_CSS");
			System.out.println("Clicked on the none button.");
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

			// click on the save button
			click("workflowsecurity_editortask_savebtn_CSS");
			System.out.println("Clicked on the save button.");
			ngDriver.waitForAngularRequestsToFinish();

			// verify the newly created record

			switchVerification("workflowsecurity_sendnotification_firsttableuser_XPATH", "Jinesh",
					"The user is not selected.");

		} catch (Throwable t) {
			verificationFailed();
		}

		// VERIFY THE SEND WORKFLOW NOTIFICATION FUNCTIONALITY

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
			click("workflowsecurity_filteredsurveynotification_createdrecord_2_XPATH");
			System.out.println("Clicked on the newly created questionnaire on the property level.");
			ngDriver.waitForAngularRequestsToFinish();

			// click on the more button
			click("questionnaire_morebtn_CSS");
			System.out.println("Clicked on the more button.");
			ngDriver.waitForAngularRequestsToFinish();

			// click on the send workflow notification
			click("questionnaire_sendworkflownotificationbtn_CSS");
			System.out.println("Clicked on the send workflow notification.");
			ngDriver.waitForAngularRequestsToFinish();

			// wait for the element
			explicitWait("workflowsecurity_sendnotification_optiontxt_CSS");

			// select the editors - incompleted questionnaire option
			select("workflowsecurity_sendnotification_optiontxt_CSS", data.get("option_2"));
			System.out.println("Selected the editors - incompleted questionnaire option.");
			ngDriver.waitForAngularRequestsToFinish();

			// select the English language
			select("questionnaire_newoption_languagedd_CSS", data.get("question_language"));
			System.out.println("Selected the english language.");
			ngDriver.waitForAngularRequestsToFinish();

			// verify auto filtered user is displayed or not

			try {
				String str1 = driver
						.findElement(By.xpath(OR.getProperty("workflowsecurity_sendnotification_recipienttxt_XPATH")))
						.getText();
				ngDriver.waitForAngularRequestsToFinish();
				if (str1.equals("Jinesh")) {

					TestUtil.captureScreenshot();

					// ReportNG
					Reporter.log("<br>"
							+ "The filtered users are not displayed in the receipient field even all questionnaire are cpmpleted : "
							+ "<br>");
					Reporter.log("<a target=\"_blank\" href=" + TestUtil.screenshotName + "><img src="
							+ TestUtil.screenshotName + " height=200 width=200></img></a>");
					Reporter.log("<br>");
					Reporter.log("<br>");

					// Extent Report
					test.log(LogStatus.FAIL,
							" The filtered users are not displayed in the receipient field even all questionnaire are cpmpleted : ");
					test.log(LogStatus.FAIL, test.addScreenCapture(TestUtil.screenshotName));

					System.out.println(
							"The filtered users are not displayed in the receipient field even all questionnaire are cpmpleted.");
					log.info(
							"The filtered users are not displayed in the receipient field even all questionnaire are cpmpleted.");

				} else {
					System.out.println(
							"The filtered users are displayed in the receipient field even all questionnaire are cpmpleted.");
					test.log(LogStatus.INFO,
							"The filtered users are displayed in the receipient field even all questionnaire are cpmpleted.");
					Reporter.log(
							"The filtered users are displayed in the receipient field even all questionnaire are cpmpleted.");
					log.info(
							"The filtered users are displayed in the receipient field even all questionnaire are cpmpleted.");
				}
			} catch (Throwable t) {

				System.out.println(
						"The filtered users are displayed in the receipient field even all questionnaire are cpmpleted.");
				test.log(LogStatus.INFO,
						"The filtered users are displayed in the receipient field even all questionnaire are cpmpleted.");
				Reporter.log(
						"The filtered users are displayed in the receipient field even all questionnaire are cpmpleted.");
				log.info(
						"The filtered users are displayed in the receipient field even all questionnaire are cpmpleted.");
			}

			// wait for the element
			explicitWaitClickable("workflowsecurity_sendnotification_cancelbtn_CSS");

			// click on the close button
			click("workflowsecurity_sendnotification_cancelbtn_CSS");
			System.out.println("Clicked on the close button.");
			ngDriver.waitForAngularRequestsToFinish();

		} catch (Throwable t) {
			verificationFailed();
		}

		// NAVIGATE TO THE HOME SCREEN

		// click on the home option from the side menu
		click("questionnaire_homeburgermenubtn_CSS");
		System.out.println("Clicked on the home option from the side menu");
		ngDriver.waitForAngularRequestsToFinish();

		// wait for the element
		explicitWait("propertylist_title_XPATH");

		// verify the property list
		switchVerification("propertylist_title_XPATH", "Property List", "The property list is not displayed.");

		// UPDATE THE QUESTIONNAIRE TITLE WITH RANDOM TEXT

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

			// enter newly created questionnaire in the filter field
			clear("ssc_company2_questionnairelist_filtertxt_CSS");
			ngDriver.waitForAngularRequestsToFinish();
			type("ssc_company2_questionnairelist_filtertxt_CSS", data.get("questionnaire_title"));
			System.out.println("Entered newly created questionnaire in the filter field.");
			ngDriver.waitForAngularRequestsToFinish();

			// click on the created questionnaire
			click("workflowsecurity_filteredsurveynotification_createdrecord_2_XPATH");
			System.out.println("Clicked on the newly created questionnaire.");
			ngDriver.waitForAngularRequestsToFinish();

			// Update the questionnaire with the random text and navigate to the home screen

			helper.randomText();

			// SWITCH THE SYSTEM COMPANY TO THE REFINED DATA TEST

			// wait for the element
			explicitWaitClickable("questionnaire_settingicon_CSS");

			// click on the settings icon from the top of the screen
			click("questionnaire_settingicon_CSS");
			System.out.println("Clicked on the settings icon.");
			ngDriver.waitForAngularRequestsToFinish();

			// wait for the element
			Thread.sleep(5000);

			// click on the Switch System Company option from the side menu
			click("ssc_sidemenubtn_CSS");
			System.out.println("Clicked on the Switch System Company option from the side menu.");
			ngDriver.waitForAngularRequestsToFinish();

			// click on the switch system company dropdown
			click("ssc_systemcompanydd_CSS");
			System.out.println("Clicked on the switch system company.");
			ngDriver.waitForAngularRequestsToFinish();

			// select the company 1 from the system company dropdown
			select("ssc_systemcompanydd_CSS", data.get("system_company"));
			System.out.println("The Refined Data Test is selected successfully.");
			ngDriver.waitForAngularRequestsToFinish();

			// click on system company dropdown
			click("ssc_systemcompanydd_CSS");
			System.out.println("Clicked on the system company dropdown.");
			ngDriver.waitForAngularRequestsToFinish();

			// click on the select button
			click("ssc_selectbtn_BTNTEXT");
			System.out.println("Clicked on the select button.");
			ngDriver.waitForAngularRequestsToFinish();

		} catch (Throwable t) {
			helper.switchSystemCompany(data);
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
