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

public class RR3935SurveyChecklistTest extends TestBase {

	@Test(dataProviderClass = TestUtil.class, dataProvider = "dp")
	public void rR3935SurveyChecklistTest(Hashtable<String, String> data) throws IOException, InterruptedException {

		execution(data, "rR3935SurveyChecklistTest");

		// HIDDEN CATEGORIES AND QUESTIONS SHOULD NOT DISPLAY WHEN ANSWING
		// SURVEY/CHECKLIST
		title("HIDDEN CATEGORIES AND QUESTIONS SHOULD NOT DISPLAY WHEN ANSWING SURVEY/CHECKLIST.");

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

			// verify newly created questionnaire for survey
			switchVerification("questionnaire_hiddenrecord_XPATH", "Test Questionnaire Property Hidden Title",
					"The Test Questionnaire Property Hidden Title record is not displayed in the questionnaire list.");

			// ADD CATEGORY 1 INTO THE QUESTIONNAIRE
			title("ADD CATEGORY 1 INTO THE QUESTIONNAIRE");

			// click on the created questionnaire
			click("questionnaire_hiddenrecord_XPATH");

			// scroll the screen to the more button
			scrollTillElement("questionnaire_type_propertybtn_CSS");

			// click on the more button
			click("questionnaire_morebtn_CSS");

			// click on the configure questions option
			click("questionnaire_configurebtn_CSS");

			// CREATE 2 NEW CATEGORIES
			title("CREATE 2 NEW CATEGORIES");

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

			// click on the new category button
			click("questionnaire_newcategorybtn_BTNTEXT");

			// select the language
			select("questionnaire_newcategory_languagedd_XPATH", data.get("category_language"));

			// enter the title
			type("questionnaire_newcategory_titletxt_MODEL", data.get("category_title_2"));

			// click on the save button
			click("questionnaire_newcategory_savebtn_CSS");

			// verify newly created category is displayed or not
			verifyTrue("questionnaire_newcategory_2_XPATH",
					"The newly created category is not displayed in the category list.");

			// click on the save button for save all categories
			click("questionnaire_category_savebtn_CSS");

			// LOCK THE CATEGORY 2
			title("LOCK THE CATEGORY 2");

			// Enter the category 2 in the filter field
			type("questionnaire_categoryfilter_CSS", data.get("category_title_2"));

			// click on the lock icon of the category 2
			click("questionnaire_category_lockicon_CSS");

			// ADD QUESTIONS INTO THE CATEGORY
			title("ADD QUESTIONS INTO THE CATEGORY");

			// click on the save button for save all categories
			click("questionnaire_category_savebtn_CSS");

			// click on the edit button of category one
			click("questionnaire_category_editbtn_CSS");

			// click on the edit question button
			click("questionnaire_category_editquestionbtn_BTNTEXT");

			// CREATE NEWLY QUESTIONS
			title("CREATE NEWLY QUESTIONS");

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
			verifyTrue("questionnaire_newquestion_1_XPATH", "The question is not created.");

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
			verifyTrue("questionnaire_newquestion_2_XPATH", "The question is not created.");

			// click on the save button of the questions
			click("questionnaire_saveallquestionbtn_CSS");

			// LOCK THE QUESTION 2
			title("LOCK THE QUESTION 2");

			// Enter the question 2 in the filter field
			type("questionnaire_categoryfilter_CSS", data.get("question_title_2"));

			// click on the lock icon of the question 2
			click("questionnaire_question_lockicon_CSS");

			// click on the edit question 1 button
			click("questionnaire_question_1_editbtn_CSS");

			// scroll down the screen
			scrollTillElement("questionnaire_question_1_commentandinstructiontxt_CSS");

			// enter the data in the Comments and Instructions field
			type("questionnaire_question_1_commentandinstructiontxt_CSS", data.get("comment_instruction_1"));

			// click on the option button
			click("questionnaire_question_1_optionbtn_CSS");

			// ADD OPTION ONE IN THE QUESTION
			title("ADD OPTION ONE IN THE QUESTION");

			// click on the save button for all options
			click("questionnaire_question_1_savealloptionbtn_CSS");

			// click on the new option button
			click("questionnaire_question_1_newoptionbtn_CSS");

			// enter data in title of the option of the question 1
			type("questionnaire_question_1_newoption_1_titletext_CSS", data.get("title_option_1_question_1"));

			// select data in type of the option of the question 1
			select("questionnaire_question_1_newoption_1_typetext_CSS", data.get("type_option_1_question_1"));

			// enter data in extra of the option of the question 1
			type("questionnaire_question_1_newoption_1_extratext_CSS", data.get("extra_option_1_question_1"));

			// click on the save button
			click("questionnaire_question_1_newoption_1_savebtn_CSS");

			// click on the save button for all options
			click("questionnaire_question_1_savealloptionbtn_CSS");

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

			// verify newly created questionnaire for checklist
			switchVerification("questionnaire_hiddenrecord_XPATH", "Test Questionnaire Property Hidden Title",
					"The Test Questionnaire Property Hidden Title record is not displayed in the questionnaire list.");

		} catch (Throwable t) {
			verificationFailed();
		}

		// click on the Home Icon from the top of the screen
		click("questionnaire_homeburgermenubtn_CSS");

		// wait for the element
		explicitWait("propertylist_title_XPATH");

		// verify the property list
		switchVerification("propertylist_title_XPATH", "Property List", "The property list is not displayed.");

		// VERIFY THE SURVEY IN THE PROPERTY LEVEL
		title("VERIFY THE SURVEY IN THE PROPERTY LEVEL");

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

			// VERIFY THE HIDDEN CATEGORY AND QUESTION IS DISPLAYED OR NOT
			try {
				String str1 = driver.findElement(By.xpath(OR.getProperty("questionnaire_hiddenrecord_question_XPATH")))
						.getText();

				if (str1.equals("Test Question Title Two Two")) {
					verificationFailedMessage("The question is not hidden successfully.");
				}
			} catch (Throwable t) {
				successMessage("The question is hidden successfully.");
			}

			try {
				String str1 = driver.findElement(By.xpath(OR.getProperty("questionnaire_hiddenrecord_category_XPATH")))
						.getText();

				if (str1.equals("Test Category Title Two Two")) {
					verificationFailedMessage("The Category is not hidden successfully.");
				}
			} catch (Throwable t) {
				successMessage("The Category is hidden successfully.");
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

			// enter newly created questionnaire in the filter field
			type("ssc_company2_questionnairelist_filtertxt_CSS", data.get("questionnaire_title"));

			// click on the created questionnaire
			click("questionnaire_hiddenrecord_XPATH");

			// wait for the element
			Thread.sleep(5000);

			// scroll till the delete button
			scrollTillElement("questionnaire_deletebtn_CSS");

			// click on the delete button
			click("questionnaire_deletebtn_CSS");

			// wait for the element
			Thread.sleep(5000);

			// click on the delete button of the confirmation popup
			click("questionnaire_modeldeletebtn_CSS");

			// enter newly created questionnaire in the filter field
			type("ssc_company2_questionnairelist_filtertxt_CSS", data.get("questionnaire_title"));

			helper.deleteVerification("questionnaire_hiddenrecord_XPATH", "Test Questionnaire Property Hidden Title");

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