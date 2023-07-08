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

public class RR3933SurveyChecklistOneTest extends TestBase {

	@Test(dataProviderClass = TestUtil.class, dataProvider = "dp")
	public void rR3933SurveyChecklistOneTest(Hashtable<String, String> data) throws IOException, InterruptedException {

		execution(data, "rR3933SurveyChecklistOneTest");

		// VERIFY THE JUMP TO OPTION WITH THE ENVIRONMENTAL REPORT

		System.out.println("VERIFY THE JUMP TO OPTION WITH THE ENVIRONMENTAL REPORT");
		test.log(LogStatus.INFO, "VERIFY THE JUMP TO OPTION WITH THE ENVIRONMENTAL REPORT");
		Reporter.log("VERIFY THE JUMP TO OPTION WITH THE ENVIRONMENTAL REPORT");
		log.info("VERIFY THE JUMP TO OPTION WITH THE ENVIRONMENTAL REPORT");

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
			clear("ssc_company2_questionnairelist_filtertxt_CSS");
			System.out.println("Cleared the filter field.");
			ngDriver.waitForAngularRequestsToFinish();
			type("ssc_company2_questionnairelist_filtertxt_CSS", data.get("questionnaire_title"));
			System.out.println("Entered newly created questionnaire in the filter field.");
			ngDriver.waitForAngularRequestsToFinish();

			// verify newly created questionnaire for survey
			switchVerification("questionnaire_jumprecord1_XPATH", "Test Questionnaire Jump One Title",
					"The Test Questionnaire Jump One Title record is not displayed in the questionnaire list.");

			// ADD CATEGORY 1 INTO THE QUESTIONNAIRE

			// click on the created questionnaire
			click("questionnaire_jumprecord1_XPATH");
			System.out.println("Clicked on the newly created questionnaire.");
			ngDriver.waitForAngularRequestsToFinish();

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

			// ADD QUESTIONS INTO THE CATEGORY

			// click on the save button for save all categories
			click("questionnaire_category_savebtn_CSS");
			System.out.println("Clicked on the save button for save all questions.");
			ngDriver.waitForAngularRequestsToFinish();

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

			// scroll till the Comments and Instructions field
			WebElement element1 = driver.findElement(
					By.cssSelector(OR.getProperty("questionnaire_question_1_commentandinstructiontxt_CSS")));
			JavascriptExecutor js = (JavascriptExecutor) driver;
			js.executeScript("arguments[0].scrollIntoView();", element1);

			// enter the data in the Comments and Instructions field
			type("questionnaire_question_1_commentandinstructiontxt_CSS", data.get("comment_instruction_1"));
			System.out.println("The data entered in the Comments and Instructions field.");
			ngDriver.waitForAngularRequestsToFinish();

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
			select("questionnaire_question_1_newoption_1_typetext_CSS", data.get("type_option_1_question_1"));
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

			// click on the edit button of the newly created option
			click("questionnaire_optioneditbtn_CSS");
			System.out.println("Clicked on the edit button of the newly created option.");
			ngDriver.waitForAngularRequestsToFinish();

			// click on the edit jump settings button
			click("questionnaire_editjumpsettingbtn_CSS");
			System.out.println("Clicked on the edit jump settings button.");
			ngDriver.waitForAngularRequestsToFinish();

			// click on the environmental reports option
			click("questionnaire_option_environmentalreports_XPATH");
			System.out.println("Clicked on the environmental reports option.");
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
			type("ssc_company2_questionnairelist_filtertxt_CSS", data.get("questionnaire_title"));
			System.out.println("Entered newly created questionnaire in the filter field.");
			ngDriver.waitForAngularRequestsToFinish();

			// verify newly created questionnaire for survey
			switchVerification("questionnaire_jumprecord1_XPATH", "Test Questionnaire Jump One Title",
					"The Test Questionnaire Jump One Title record is not displayed in the questionnaire list.");

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

		// VERIFY THE SURVEY IN THE PROPERTY LEVEL

		System.out.println("***************** VERIFY THE SURVEY IN THE PROPERTY LEVEL *****************");
		test.log(LogStatus.INFO, "***************** VERIFY THE SURVEY IN THE PROPERTY LEVEL *****************");
		Reporter.log("***************** VERIFY THE SURVEY IN THE PROPERTY LEVEL *****************");
		log.info("***************** VERIFY THE SURVEY IN THE PROPERTY LEVEL *****************");

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

			// select the property level from the dropdown
			select("survey_leveldropdown_CSS", data.get("property_leveldropdown"));
			System.out.println("Selected the property level from the dropdown.");
			ngDriver.waitForAngularRequestsToFinish();

			// wait for the element
			explicitWait("survey_questionnairedd_CSS");

			// select the respective questionnaire from the dropdown
			select("survey_questionnairedd_CSS", data.get("questionnaire_title"));
			System.out.println("The questionnaire selected successfully.");
			ngDriver.waitForAngularRequestsToFinish();

			// verify questionnaire is selected correctly or not
			switchVerification("questionnaire_questiontitle_XPATH", "Test Category Title One",
					"The Test Category Title One is not displayed.");

			// click on the yes button of the question 1
			click("survey_yesanswerbtn_CSS");
			System.out.println("Clicked on the yes button of the question 1.");
			ngDriver.waitForAngularRequestsToFinish();

			// wait for the element
			explicitWaitClickable("questionnaire_jumpoptionlink1_XPATH");

			// click on the jump option link
			click("questionnaire_jumpoptionlink1_XPATH");
			System.out.println("Clicked on the jump option link.");
			ngDriver.waitForAngularRequestsToFinish();

			// verify the environmental reports title
			switchVerification("questionnaire_jumpoption1_navigate_XPATH", "Environmental Reports",
					"The Environmental Reports is not displayed.");

		} catch (Throwable t) {
			verificationFailed();
		}

		// click on the home option
		click("questionnaire_homeburgermenubtn_hide_CSS");
		System.out.println("Clicked on the home option.");
		ngDriver.waitForAngularRequestsToFinish();

		// wait for the element
		explicitWait("propertylist_title_XPATH");

		// verify the property list
		switchVerification("propertylist_title_XPATH", "Property List", "The property list is not displayed.");

		// UPDATE THE QUESTIONNAIRE TITLE WITH RANDOM TEXT

		System.out.println("***************** UPDATE THE QUESTIONNAIRE TITLE WITH RANDOM TEXT *****************");
		test.log(LogStatus.INFO, "***************** UPDATE THE QUESTIONNAIRE TITLE WITH RANDOM TEXT *****************");
		Reporter.log("***************** UPDATE THE QUESTIONNAIRE TITLE WITH RANDOM TEXT *****************");
		log.info("***************** UPDATE THE QUESTIONNAIRE TITLE WITH RANDOM TEXT *****************");

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
			click("questionnaire_jumprecord1_XPATH");
			System.out.println("Clicked on the newly created questionnaire.");
			ngDriver.waitForAngularRequestsToFinish();

			// Update the questionnaire with the random text and navigate to the home screen
			helper.randomText();

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

	}
}
