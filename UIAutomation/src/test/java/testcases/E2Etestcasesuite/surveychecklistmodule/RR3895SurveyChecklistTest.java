package testcases.E2Etestcasesuite.surveychecklistmodule;

import java.io.IOException;
import java.util.Hashtable;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.testng.Reporter;
import org.testng.SkipException;
import org.testng.annotations.Test;

import com.relevantcodes.extentreports.LogStatus;

import base.Helper;
import base.TestBase;
import utilities.TestUtil;

public class RR3895SurveyChecklistTest extends TestBase {

	@Test(dataProviderClass = TestUtil.class, dataProvider = "dp")
	public void rR3895SurveyChecklistTest(Hashtable<String, String> data) throws IOException, InterruptedException {

		execution(data, "rR3895SurveyChecklistTest");

		// 1. QUESTION DEPENDENCIES IN CHECKLIST/SURVEY
		// 2. ALL QUESTION OPTIONS
		title("1. QUESTION DEPENDENCIES IN CHECKLIST/SURVEY and 2. ALL QUESTION OPTIONS");

		Helper helper = new Helper();

		// refresh the page
		driver.navigate().refresh();
		Thread.sleep(5000);
		driver.navigate().refresh();

		// ADD NEW QUESTIONNIRE
		title("ADD NEW QUESTIONNIRE");

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

			// enter the newly created questionnaire in the search field
			type("ssc_company2_questionnairelist_filtertxt_CSS", data.get("questionnaire_title"));

			// verification of the created questionnaire
			verifyTrue("questionnaire_createdrecordoptdep_1_XPATH", "The newly questionnaire is not created.");

			// ADD CATEGORY 1 INTO THE QUESTIONNAIRE
			title("ADD CATEGORY 1 INTO THE QUESTIONNAIRE");

			// click on the created questionnaire
			click("questionnaire_createdrecordoptdep_1_XPATH");

			// scroll till the more button
			scrollTillElement("questionnaire_type_propertybtn_CSS");

			// click on the more button
			click("questionnaire_morebtn_CSS");

			// click on the configure questions option
			click("questionnaire_configurebtn_CSS");

			// click on the new category button
			click("questionnaire_newcategorybtn_BTNTEXT");

			// select the language
			select("questionnaire_newcategory_languagedd_XPATH", data.get("category_language"));

			// enter the title
			type("questionnaire_newcategory_titletxt_MODEL", data.get("category_title_1"));

			// click on the save button
			click("questionnaire_newcategory_savebtn_CSS");

			// verify newly created category is displayed or not
			verifyTrue("questionnaire_newcategory_1_XPATH",
					"The newly created category is not displayed in the category list.");

			// ADD QUESTIONS INTO THE CATEGORY
			title("ADD QUESTIONS INTO THE CATEGORY");

			// click on the save button for save all categories
			click("questionnaire_category_savebtn_CSS");

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
					"The Test Question Title One questiona is not displayed.");

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
					"The Test Question Title Two Two questiona is not displayed.");

			// click on the save button of the questions
			click("questionnaire_saveallquestionbtn_CSS");

			// click on the edit question 1 button
			click("questionnaire_question_1_editbtn_CSS");

			// scroll till the Comments and Instructions field
			scrollTillElement("questionnaire_question_1_commentandinstructiontxt_CSS");

			// enter the data in the Comments and Instructions field
			type("questionnaire_question_1_commentandinstructiontxt_CSS", data.get("comment_instruction_1"));

			// click on the option button
			click("questionnaire_question_1_optionbtn_CSS");

			// ADD OPTIONS IN THE QUESTION
			title("ADD OPTIONS IN THE QUESTION");

			// click on the save button for all options
			click("questionnaire_question_1_savealloptionbtn_CSS");

//		// click on the new option button
//		click("questionnaire_question_1_newoptionbtn_CSS");
//
//		// enter data in title of the option of the question 1
//		type("questionnaire_question_1_newoption_1_titletext_CSS", data.get("title_attachmentoption"));
//
//		// select attachment option in the type field of the question 1
//		select("questionnaire_question_1_newoption_1_typetext_CSS", data.get("type_attachmentoption"));
//
//		// enter data in extra of the option of the question 1
//		type("questionnaire_question_1_newoption_1_extratext_CSS", data.get("extra_option"));
//
//		// click on the save button
//		click("questionnaire_question_1_newoption_1_savebtn_CSS");
//
//		// click on the save button for all options
//		click("questionnaire_question_1_savealloptionbtn_CSS");
//
//		// click on the new option button
//		click("questionnaire_question_1_newoptionbtn_CSS");
//
//		// enter data in title of the option of the question 1
//		type("questionnaire_question_1_newoption_1_titletext_CSS", data.get("title_certificationpickeroption"));
//
//		// select certification picker option in the type field of the question 1
//		select("questionnaire_question_1_newoption_1_typetext_CSS", data.get("type_certificationpickeroption"));
//		System.out.println(
//				"The certification picker option selected successfully for create new option of the question 1");
//
//		// enter data in extra of the option of the question 1
//		type("questionnaire_question_1_newoption_1_extratext_CSS", data.get("extra_option"));
//		
//		// click on the choose button
//		click("questionnaire_option_choosebtn_CSS");
//
//		// click on the category on the Available scoring categories popup
//		click("questionnaire_option_category_XPATH");
//
//		// click on the save button
//		click("questionnaire_question_1_newoption_1_savebtn_CSS");
//
//		// click on the save button for all options
//		click("questionnaire_question_1_savealloptionbtn_CSS");

			// click on the new option button
			click("questionnaire_question_1_newoptionbtn_CSS");

			// enter data in title of the option of the question 1
			type("questionnaire_question_1_newoption_1_titletext_CSS", data.get("title_checklistoption"));

			// select checklist option in the type field of the question 1
			select("questionnaire_question_1_newoption_1_typetext_CSS", data.get("type_checklistoption"));

			// enter data in extra of the option of the question 1
			type("questionnaire_question_1_newoption_1_extratext_CSS", data.get("extra_option"));

			// click on the save button
			click("questionnaire_question_1_newoption_1_savebtn_CSS");

			// click on the save button for all options
			click("questionnaire_question_1_savealloptionbtn_CSS");

			// click on the new option button
			click("questionnaire_question_1_newoptionbtn_CSS");

			// enter data in title of the option of the question 1
			type("questionnaire_question_1_newoption_1_titletext_CSS", data.get("title_commentboxoption"));

			// select comment box option in the type field of the question 1
			select("questionnaire_question_1_newoption_1_typetext_CSS", data.get("type_commentboxoption"));

			// enter data in extra of the option of the question 1
			type("questionnaire_question_1_newoption_1_extratext_CSS", data.get("extra_option"));

			// click on the save button
			click("questionnaire_question_1_newoption_1_savebtn_CSS");

			// click on the save button for all options
			click("questionnaire_question_1_savealloptionbtn_CSS");

			// click on the new option button
			click("questionnaire_question_1_newoptionbtn_CSS");

			// enter data in title of the option of the question 1
			type("questionnaire_question_1_newoption_1_titletext_CSS", data.get("title_datepicketoption"));

			// select date picket option in the type field of the question 1
			select("questionnaire_question_1_newoption_1_typetext_CSS", data.get("type_datepicketoption"));

			// enter data in extra of the option of the question 1
			type("questionnaire_question_1_newoption_1_extratext_CSS", data.get("extra_option"));

			// click on the save button
			click("questionnaire_question_1_newoption_1_savebtn_CSS");

			// click on the save button for all options
			click("questionnaire_question_1_savealloptionbtn_CSS");

			// click on the new option button
			click("questionnaire_question_1_newoptionbtn_CSS");

			// enter data in title of the option of the question 1
			type("questionnaire_question_1_newoption_1_titletext_CSS", data.get("title_dollaramountoption"));

			// select dollar amount option in the type field of the question 1
			select("questionnaire_question_1_newoption_1_typetext_CSS", data.get("type_dollaramountoption"));

			// enter data in extra of the option of the question 1
			type("questionnaire_question_1_newoption_1_extratext_CSS", data.get("extra_option"));

			// click on the save button
			click("questionnaire_question_1_newoption_1_savebtn_CSS");

			// click on the save button for all options
			click("questionnaire_question_1_savealloptionbtn_CSS");

//		// click on the new option button
//		click("questionnaire_question_1_newoptionbtn_CSS");
//
//		// enter data in title of the option of the question 1
//		type("questionnaire_question_1_newoption_1_titletext_CSS", data.get("title_dropboxoption"));
//
//		// select drop box option in the type field of the question 1
//		select("questionnaire_question_1_newoption_1_typetext_CSS", data.get("type_dropboxoption"));
//
//		// enter data in extra of the option of the question 1
//		type("questionnaire_question_1_newoption_1_extratext_CSS", data.get("extra_option"));
//
//		// click on the choose button
//		click("questionnaire_option_chooseDropboxbtn_CSS");
//
//		// click on the category on the Available dropboxes popup
//		click("questionnaire_option_category_chooseDropbox_XPATH");
//
//		// click on the save button
//		click("questionnaire_question_1_newoption_1_savebtn_CSS");
//
//		// click on the save button for all options
//		click("questionnaire_question_1_savealloptionbtn_CSS");		 

			// click on the new option button
			click("questionnaire_question_1_newoptionbtn_CSS");

			// enter data in title of the option of the question 1
			type("questionnaire_question_1_newoption_1_titletext_CSS", data.get("title_headingoption"));

			// select heading option in the type field of the question 1
			select("questionnaire_question_1_newoption_1_typetext_CSS", data.get("type_headingoption"));

			// enter data in extra of the option of the question 1
			type("questionnaire_question_1_newoption_1_extratext_CSS", data.get("extra_option"));

			// click on the save button
			click("questionnaire_question_1_newoption_1_savebtn_CSS");

			// click on the save button for all options
			click("questionnaire_question_1_savealloptionbtn_CSS");

			// click on the new option button
			click("questionnaire_question_1_newoptionbtn_CSS");

			// enter data in title of the option of the question 1
			type("questionnaire_question_1_newoption_1_titletext_CSS", data.get("title_inputboxoption"));

			// select input box option in the type field of the question 1
			select("questionnaire_question_1_newoption_1_typetext_CSS", data.get("type_inputboxoption"));

			// enter data in extra of the option of the question 1
			type("questionnaire_question_1_newoption_1_extratext_CSS", data.get("extra_option"));

			// click on the save button
			click("questionnaire_question_1_newoption_1_savebtn_CSS");

			// click on the save button for all options
			click("questionnaire_question_1_savealloptionbtn_CSS");

			// click on the new option button
			click("questionnaire_question_1_newoptionbtn_CSS");

			// enter data in title of the option of the question 1
			type("questionnaire_question_1_newoption_1_titletext_CSS", data.get("title_instructionsforuseroption"));

			// select instructions for user option in the type field of the question 1
			select("questionnaire_question_1_newoption_1_typetext_CSS", data.get("type_instructionsforuseroption"));
			System.out.println(
					"The instructions for user option selcted successfully for create new option of the question 1");

			// enter data in extra of the option of the question 1
			type("questionnaire_question_1_newoption_1_extratext_CSS", data.get("extra_option"));

			// click on the save button
			click("questionnaire_question_1_newoption_1_savebtn_CSS");

			// click on the save button for all options
			click("questionnaire_question_1_savealloptionbtn_CSS");

			// click on the new option button
			click("questionnaire_question_1_newoptionbtn_CSS");

			// enter data in title of the option of the question 1
			type("questionnaire_question_1_newoption_1_titletext_CSS", data.get("title_numericvalueoption"));

			// select numeric value option in the type field of the question 1
			select("questionnaire_question_1_newoption_1_typetext_CSS", data.get("type_numericvalueoption"));

			// enter data in extra of the option of the question 1
			type("questionnaire_question_1_newoption_1_extratext_CSS", data.get("extra_option"));

			// click on the save button
			click("questionnaire_question_1_newoption_1_savebtn_CSS");

			// click on the save button for all options
			click("questionnaire_question_1_savealloptionbtn_CSS");

			// click on the new option button
			click("questionnaire_question_1_newoptionbtn_CSS");

			// enter data in title of the option of the question 1
			type("questionnaire_question_1_newoption_1_titletext_CSS", data.get("title_optionlistoption"));

			// select option list option in the type field of the question 1
			select("questionnaire_question_1_newoption_1_typetext_CSS", data.get("type_optionlistoption"));

			// enter data in extra of the option of the question 1
			type("questionnaire_question_1_newoption_1_extratext_CSS", data.get("extra_option"));

			// click on the save button
			click("questionnaire_question_1_newoption_1_savebtn_CSS");

			// click on the save button for all options
			click("questionnaire_question_1_savealloptionbtn_CSS");

			// click on the new option button
			click("questionnaire_question_1_newoptionbtn_CSS");

			// enter data in title of the option of the question 1
			type("questionnaire_question_1_newoption_1_titletext_CSS", data.get("title_percentageamountoption"));

			// select percentage amount option in the type field of the question 1
			select("questionnaire_question_1_newoption_1_typetext_CSS", data.get("type_percentageamountoption"));
			System.out.println(
					"The percentage amount option selcted successfully for create new option of the question 1");

			// enter data in extra of the option of the question 1
			type("questionnaire_question_1_newoption_1_extratext_CSS", data.get("extra_option"));

			// click on the save button
			click("questionnaire_question_1_newoption_1_savebtn_CSS");

			// click on the save button for all options
			click("questionnaire_question_1_savealloptionbtn_CSS");

			// click on the new option button
			click("questionnaire_question_1_newoptionbtn_CSS");

			// enter data in title of the option of the question 1
			type("questionnaire_question_1_newoption_1_titletext_CSS", data.get("title_quarterlydateoption"));

			// select quarterly date option in the type field of the question 1
			select("questionnaire_question_1_newoption_1_typetext_CSS", data.get("type_quarterlydateoption"));

			// enter data in extra of the option of the question 1
			type("questionnaire_question_1_newoption_1_extratext_CSS", data.get("extra_option"));

			// click on the save button
			click("questionnaire_question_1_newoption_1_savebtn_CSS");

			// click on the save button for all options
			click("questionnaire_question_1_savealloptionbtn_CSS");

//		// click on the new option button
//		click("questionnaire_question_1_newoptionbtn_CSS");
//
//		// enter data in title of the option of the question 1
//		type("questionnaire_question_1_newoption_1_titletext_CSS", data.get("title_likertscaleoption"));
//
//		// select likert scale option in the type field of the question 1
//		select("questionnaire_question_1_newoption_1_typetext_CSS", data.get("type_likertscaleoption"));
//
//		// enter data in extra of the option of the question 1
//		type("questionnaire_question_1_newoption_1_extratext_CSS", data.get("extra_option"));
//
//		// click on the save button
//		click("questionnaire_question_1_newoption_1_savebtn_CSS");
//
//		// click on the save button for all options
//		click("questionnaire_question_1_savealloptionbtn_CSS");	 

			// click on the back to questions button
			click("questionnaire_question_1_option_backtoquestionsbtn_CSS");

			// click on the save button for save all question
			click("questionnaire_saveallquestionbtn_CSS");

			// ADD THE DEPENDANCY IN THE QUESTION

			// click on the edit button of the question 2
			click("questionnaire_question_2_editbtn_CSS");

			// scroll till the comment field
			scrollTillElement("questionnaire_question_1_commentandinstructiontxt_CSS");

			// click on the dependency button of the question 2
			click("questionnaire_question_2_dependencybtn_CSS");

			// click on the add icon of the depends on question
			click("questionnaire_question_dependancies_addbtn1_CSS");

			// enter the data in the filter field of the dependency
			type("questionnaire_question_dependancies_filter_CSS", data.get("question_title_1"));

			// click on the filtered result
			click("questionnaire_question_dependancies_filteredresult_CSS");

			// select the yes option from the dropdown
			select("questionnaire_yesselect_CSS", data.get("dependency_dd"));

			// click on the save button
			click("questionnaire_question_dependancies_savebtn_CSS");

			// click on the back to questions button
			click("questionnaire_question_1_option_backtoquestionsbtn_CSS");

			// click on the save button for save all question
			click("questionnaire_saveallquestionbtn_CSS");

			// click on the back to category button
			click("questionnaire_question_1_backtocategorybtn_CSS");

			// click on the save button for save all categories
			click("questionnaire_category_savebtn_CSS");

			// click on the back to questionnaire button
			click("questionnaire_category_backtoquestionnairesbtn_CSS");

			// enter newly created questionnaire in the filter field

			type("ssc_company2_questionnairelist_filtertxt_CSS", data.get("questionnaire_title"));

			// verify newly created questionnaire for survey
			switchVerification("questionnaire_createdrecordoptdep_1_XPATH", "Test Opt Dep Questionnaire Title",
					"The Test Opt Dep Questionnaire Title record is not displayed in the questionnaire list.");

		} catch (Throwable t) {

			verificationFailed();
		}

		// click on the home icon from the top left corner
		click("questionnaire_homeburgermenubtn_CSS");

		// wait for the element
		explicitWait("propertylist_title_XPATH");

		// verify the property list
		switchVerification("propertylist_title_XPATH", "Property List", "The property list is not displayed.");

		// VERIFY THE NEWLY CREATED QUESTIONNAIRE IN THE SURVEY
		title("VERIFY THE NEWLY CREATED QUESTIONNAIRE IN THE SURVEY");

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

			// select the property level from the dropdown
			select("survey_leveldropdown_CSS", data.get("property_leveldropdown"));

			// select the respective questionnaire from the dropdown
			select("survey_questionnairedd_CSS", data.get("questionnaire_title"));

			// verify questionnaire is selected correctly or not
			switchVerification("questionnaire_questiontitle_XPATH", "Test Category Title One",
					"The Test Category Title One is not displayed.");

			// click on the yes button of the question 1
			click("survey_yesanswerbtn_1_CSS");

			// answer the option 1
			click("survey_option_0_CSS");

			// click on the TAB Key of the keyboard
			WebElement webElement = driver.findElement(By.cssSelector(OR.getProperty("survey_option_0_CSS")));
			webElement.sendKeys(Keys.TAB);

			Thread.sleep(5000);

			// answer the option 2
			type("survey_option_1_CSS", data.get("title_commentboxoption"));

			// click on the TAB Key of the keyboard
			webElement = driver.findElement(By.cssSelector(OR.getProperty("survey_option_1_CSS")));
			webElement.sendKeys(Keys.TAB);

			// answer the option 3
			click("survey_option_2_CSS");

			// click on the today button
			click("survey_imported_category_1_question_1_todaybtn_XPATH");

			// click on the TAB Key of the keyboard
			webElement = driver.findElement(By.cssSelector(OR.getProperty("survey_option_2_CSS")));
			webElement.sendKeys(Keys.TAB);

			// answer the option 4
			type("survey_option_3_CSS", "40");

			// click on the TAB Key of the keyboard
			webElement = driver.findElement(By.cssSelector(OR.getProperty("survey_option_3_CSS")));
			webElement.sendKeys(Keys.TAB);

			// verify the heading title
			switchVerification("survey_option_4_XPATH", "Test Heading Option",
					"The Test Heading Option is not displayed.");

			// answer the option 6
			type("survey_option_5_CSS", data.get("title_inputboxoption"));

			// click on the TAB Key of the keyboard
			webElement = driver.findElement(By.cssSelector(OR.getProperty("survey_option_5_CSS")));
			webElement.sendKeys(Keys.TAB);

			// verify the Instructions for User title
			switchVerification("survey_option_6_XPATH", "Test Instructions for User Option",
					"The Test Instructions for User Option is not displayed.");

			// answer the option 8
			type("survey_option_7_CSS", "80");

			// click on the TAB Key of the keyboard
			webElement = driver.findElement(By.cssSelector(OR.getProperty("survey_option_7_CSS")));
			webElement.sendKeys(Keys.TAB);

			// scroll down the screen
			scrollByPixel(500);

			// answer the option 9
			click("survey_option_8_CSS");

			// click on the TAB Key of the keyboard
			webElement = driver.findElement(By.cssSelector(OR.getProperty("survey_option_8_CSS")));
			webElement.sendKeys(Keys.TAB);

			// answer the option 10
			type("survey_option_9_CSS", "90");

			// click on the TAB Key of the keyboard
			webElement = driver.findElement(By.cssSelector(OR.getProperty("survey_option_9_CSS")));
			webElement.sendKeys(Keys.TAB);

			// answer the option 11
			type("survey_option_10_CSS", "2020-Q4");

			// scroll down till bottom
			scrollTillElement("survey_yesanswerbtn_2_CSS");

			// click on the yes button of the question 2
			click("survey_yesanswerbtn_2_CSS");

			// click on the category 1 question 1 label
			click("checklist_category_1_question_1_XPATH");

			// verify 100% survey complete or not
			switchVerification("survey_imported_questionnaire_100_XPATH", "100% complete",
					"The 100% complete is not completed yet.");

		} catch (Throwable t) {
			verificationFailed();
		}

		// click on the Home button
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
			type("ssc_company2_questionnairelist_filtertxt_CSS", data.get("questionnaire_title"));

			// click on the created questionnaire
			click("questionnaire_createdrecordoptdep_1_XPATH");

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
