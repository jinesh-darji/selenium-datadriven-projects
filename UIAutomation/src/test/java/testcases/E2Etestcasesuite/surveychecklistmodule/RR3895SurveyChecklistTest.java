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

		System.out.println("1. QUESTION DEPENDENCIES IN CHECKLIST/SURVEY and 2. ALL QUESTION OPTIONS");
		test.log(LogStatus.INFO, "1. QUESTION DEPENDENCIES IN CHECKLIST/SURVEY and 2. ALL QUESTION OPTIONS");
		Reporter.log("1. QUESTION DEPENDENCIES IN CHECKLIST/SURVEY and 2. ALL QUESTION OPTIONS");
		log.info("1. QUESTION DEPENDENCIES IN CHECKLIST/SURVEY and 2. ALL QUESTION OPTIONS");

		Helper helper = new Helper();

		// refresh the page
		driver.navigate().refresh();
		Thread.sleep(5000);
		driver.navigate().refresh();

		System.out.println("Navigate to the Home Screen i.e. Property List Screen.");

		// ADD NEW QUESTIONNIRE

		System.out.println("***************** ADD NEW QUESTIONNIRE *****************");
		test.log(LogStatus.INFO, "***************** ADD NEW QUESTIONNIRE *****************");
		Reporter.log("***************** ADD NEW QUESTIONNIRE *****************");
		log.info("***************** ADD NEW QUESTIONNIRE *****************");

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

			// enter the newly created questionnaire in the search field
			type("ssc_company2_questionnairelist_filtertxt_CSS", data.get("questionnaire_title"));
			System.out.println("Entered the newly created questionnaire in the search field.");
			ngDriver.waitForAngularRequestsToFinish();

			// verification of the created questionnaire
			verifyTrue("questionnaire_createdrecordoptdep_1_XPATH", "The newly questionnaire is not created.");
			System.out.println("The new questionnaire is created successfully.");
			test.log(LogStatus.INFO, "The new questionnaire is created successfully.");

			// ADD CATEGORY 1 INTO THE QUESTIONNAIRE

			System.out.println("***************** ADD CATEGORY 1 INTO THE QUESTIONNAIRE *****************");
			test.log(LogStatus.INFO, "***************** ADD CATEGORY 1 INTO THE QUESTIONNAIRE *****************");
			Reporter.log("***************** ADD CATEGORY 1 INTO THE QUESTIONNAIRE *****************");
			log.info("***************** ADD CATEGORY 1 INTO THE QUESTIONNAIRE *****************");

			// click on the created questionnaire
			click("questionnaire_createdrecordoptdep_1_XPATH");
			System.out.println("Clicked on the newly created questionnaire.");
			ngDriver.waitForAngularRequestsToFinish();

			// scroll till the more button
			WebElement element1 = driver
					.findElement(By.cssSelector(OR.getProperty("questionnaire_type_propertybtn_CSS")));
			JavascriptExecutor js = (JavascriptExecutor) driver;
			js.executeScript("arguments[0].scrollIntoView();", element1);

			// click on the more button
			click("questionnaire_morebtn_CSS");
			System.out.println("Clicked on the more button.");
			ngDriver.waitForAngularRequestsToFinish();

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
			switchVerification("questionnaire_newquestion_1_XPATH", "Test Question Title One",
					"The Test Question Title One questiona is not displayed.");

			// click on the new question button
			click("questionnaire_newquestionbtn_CSS");
			System.out.println("Clicked on the new question button.");
			ngDriver.waitForAngularRequestsToFinish();

			// select the English language from the language dropdown
			select("questionnaire_newquestion_languagedd_CSS", data.get("question_language"));
			System.out.println("The English option is selected from the language dropdown.");
			ngDriver.waitForAngularRequestsToFinish();

			// enter the label
			type("questionnaire_newquestion_labeltxt_CSS", data.get("question_label_2"));
			System.out.println("The data entered in the label field.");
			ngDriver.waitForAngularRequestsToFinish();

			// enter the title
			type("questionnaire_newquestion_titletxt_CSS", data.get("question_title_2"));
			System.out.println("The data entered in the title field.");
			ngDriver.waitForAngularRequestsToFinish();

			// click on the save button
			click("questionnaire_newquestion_savebtn_CSS");
			System.out.println("Click on the save button.");
			ngDriver.waitForAngularRequestsToFinish();

			// verify question one created or not
			switchVerification("questionnaire_newquestion_2_XPATH", "Test Question Title Two Two",
					"The Test Question Title Two Two questiona is not displayed.");

			// click on the save button of the questions
			click("questionnaire_saveallquestionbtn_CSS");
			System.out.println("Clicked on the save button to save the question.");
			ngDriver.waitForAngularRequestsToFinish();

			// click on the edit question 1 button
			click("questionnaire_question_1_editbtn_CSS");
			System.out.println("Clicked on the edit button of the question 1.");
			ngDriver.waitForAngularRequestsToFinish();

			// scroll till the Comments and Instructions field
			WebElement element3 = driver.findElement(
					By.cssSelector(OR.getProperty("questionnaire_question_1_commentandinstructiontxt_CSS")));
			js.executeScript("arguments[0].scrollIntoView();", element3);

			// enter the data in the Comments and Instructions field
			type("questionnaire_question_1_commentandinstructiontxt_CSS", data.get("comment_instruction_1"));
			System.out.println("The data entered in the Comments and Instructions field.");

			// click on the option button
			click("questionnaire_question_1_optionbtn_CSS");
			System.out.println("Clicked on the option button.");
			ngDriver.waitForAngularRequestsToFinish();

			// ADD OPTIONS IN THE QUESTION

			// click on the save button for all options
			click("questionnaire_question_1_savealloptionbtn_CSS");
			System.out.println("Clicked on the save button for save the option list.");
			ngDriver.waitForAngularRequestsToFinish();

//		// click on the new option button
//		click("questionnaire_question_1_newoptionbtn_CSS");
//		System.out.println("Clicked on the option button");
//		ngDriver.waitForAngularRequestsToFinish();
//
//		// enter data in title of the option of the question 1
//		type("questionnaire_question_1_newoption_1_titletext_CSS", data.get("title_attachmentoption"));
//		System.out.println("The title is entered successfully for create new option of the question 1");
//
//		// select attachment option in the type field of the question 1
//		select("questionnaire_question_1_newoption_1_typetext_CSS", data.get("type_attachmentoption"));
//		System.out.println("The attachment option selcted successfully for create new option of the question 1");
//		ngDriver.waitForAngularRequestsToFinish();
//
//		// enter data in extra of the option of the question 1
//		type("questionnaire_question_1_newoption_1_extratext_CSS", data.get("extra_option"));
//		System.out.println("The extra is entered successfully for create new option of the question 1");
//
//		// click on the save button
//		click("questionnaire_question_1_newoption_1_savebtn_CSS");
//		System.out.println("Clicked on the save button");
//		ngDriver.waitForAngularRequestsToFinish();
//
//		// click on the save button for all options
//		click("questionnaire_question_1_savealloptionbtn_CSS");
//		System.out.println("Clicked on the save button for save the option list.");
//		ngDriver.waitForAngularRequestsToFinish();
//
//		// click on the new option button
//		click("questionnaire_question_1_newoptionbtn_CSS");
//		System.out.println("Clicked on the option button");
//		ngDriver.waitForAngularRequestsToFinish();
//
//		// enter data in title of the option of the question 1
//		type("questionnaire_question_1_newoption_1_titletext_CSS", data.get("title_certificationpickeroption"));
//		System.out.println("The title is entered successfully for create new option of the question 1");
//
//		// select certification picker option in the type field of the question 1
//		select("questionnaire_question_1_newoption_1_typetext_CSS", data.get("type_certificationpickeroption"));
//		System.out.println(
//				"The certification picker option selected successfully for create new option of the question 1");
//		ngDriver.waitForAngularRequestsToFinish();
//
//		// enter data in extra of the option of the question 1
//		type("questionnaire_question_1_newoption_1_extratext_CSS", data.get("extra_option"));
//		System.out.println("The extra is entered successfully for create new option of the question 1");
//		ngDriver.waitForAngularRequestsToFinish();
//		
//		// click on the choose button
//		click("questionnaire_option_choosebtn_CSS");
//		System.out.println("Clicked on the choose button.");
//		ngDriver.waitForAngularRequestsToFinish();
//
//		// click on the category on the Available scoring categories popup
//		click("questionnaire_option_category_XPATH");
//		System.out.println("Clicked on the category on the Available scoring categories popup.");
//		ngDriver.waitForAngularRequestsToFinish();
//
//		// click on the save button
//		click("questionnaire_question_1_newoption_1_savebtn_CSS");
//		System.out.println("Clicked on the save button");
//		ngDriver.waitForAngularRequestsToFinish();
//
//		// click on the save button for all options
//		click("questionnaire_question_1_savealloptionbtn_CSS");
//		System.out.println("Clicked on the save button for save the option list.");
//		ngDriver.waitForAngularRequestsToFinish();

			// click on the new option button
			click("questionnaire_question_1_newoptionbtn_CSS");
			System.out.println("Clicked on the option button");
			ngDriver.waitForAngularRequestsToFinish();

			// enter data in title of the option of the question 1
			type("questionnaire_question_1_newoption_1_titletext_CSS", data.get("title_checklistoption"));
			System.out.println("The title is entered successfully for create new option of the question 1");

			// select checklist option in the type field of the question 1
			select("questionnaire_question_1_newoption_1_typetext_CSS", data.get("type_checklistoption"));
			System.out.println("The checklist option selcted successfully for create new option of the question 1");
			ngDriver.waitForAngularRequestsToFinish();

			// enter data in extra of the option of the question 1
			type("questionnaire_question_1_newoption_1_extratext_CSS", data.get("extra_option"));
			System.out.println("The extra is entered successfully for create new option of the question 1");

			// click on the save button
			click("questionnaire_question_1_newoption_1_savebtn_CSS");
			System.out.println("Clicked on the save button");
			ngDriver.waitForAngularRequestsToFinish();

			// click on the save button for all options
			click("questionnaire_question_1_savealloptionbtn_CSS");
			System.out.println("Clicked on the save button for save the option list.");
			ngDriver.waitForAngularRequestsToFinish();

			// click on the new option button
			click("questionnaire_question_1_newoptionbtn_CSS");
			System.out.println("Clicked on the option button");
			ngDriver.waitForAngularRequestsToFinish();

			// enter data in title of the option of the question 1
			type("questionnaire_question_1_newoption_1_titletext_CSS", data.get("title_commentboxoption"));
			System.out.println("The title is entered successfully for create new option of the question 1");

			// select comment box option in the type field of the question 1
			select("questionnaire_question_1_newoption_1_typetext_CSS", data.get("type_commentboxoption"));
			System.out.println("The comment box option selcted successfully for create new option of the question 1");
			ngDriver.waitForAngularRequestsToFinish();

			// enter data in extra of the option of the question 1
			type("questionnaire_question_1_newoption_1_extratext_CSS", data.get("extra_option"));
			System.out.println("The extra is entered successfully for create new option of the question 1");

			// click on the save button
			click("questionnaire_question_1_newoption_1_savebtn_CSS");
			System.out.println("Clicked on the save button");
			ngDriver.waitForAngularRequestsToFinish();

			// click on the save button for all options
			click("questionnaire_question_1_savealloptionbtn_CSS");
			System.out.println("Clicked on the save button for save the option list.");
			ngDriver.waitForAngularRequestsToFinish();

			// click on the new option button
			click("questionnaire_question_1_newoptionbtn_CSS");
			System.out.println("Clicked on the option button");
			ngDriver.waitForAngularRequestsToFinish();

			// enter data in title of the option of the question 1
			type("questionnaire_question_1_newoption_1_titletext_CSS", data.get("title_datepicketoption"));
			System.out.println("The title is entered successfully for create new option of the question 1");

			// select date picket option in the type field of the question 1
			select("questionnaire_question_1_newoption_1_typetext_CSS", data.get("type_datepicketoption"));
			System.out.println("The date picket option selcted successfully for create new option of the question 1");
			ngDriver.waitForAngularRequestsToFinish();

			// enter data in extra of the option of the question 1
			type("questionnaire_question_1_newoption_1_extratext_CSS", data.get("extra_option"));
			System.out.println("The extra is entered successfully for create new option of the question 1");

			// click on the save button
			click("questionnaire_question_1_newoption_1_savebtn_CSS");
			System.out.println("Clicked on the save button");
			ngDriver.waitForAngularRequestsToFinish();

			// click on the save button for all options
			click("questionnaire_question_1_savealloptionbtn_CSS");
			System.out.println("Clicked on the save button for save the option list.");
			ngDriver.waitForAngularRequestsToFinish();

			// click on the new option button
			click("questionnaire_question_1_newoptionbtn_CSS");
			System.out.println("Clicked on the option button");
			ngDriver.waitForAngularRequestsToFinish();

			// enter data in title of the option of the question 1
			type("questionnaire_question_1_newoption_1_titletext_CSS", data.get("title_dollaramountoption"));
			System.out.println("The title is entered successfully for create new option of the question 1");

			// select dollar amount option in the type field of the question 1
			select("questionnaire_question_1_newoption_1_typetext_CSS", data.get("type_dollaramountoption"));
			System.out.println("The dollar amount option selcted successfully for create new option of the question 1");
			ngDriver.waitForAngularRequestsToFinish();

			// enter data in extra of the option of the question 1
			type("questionnaire_question_1_newoption_1_extratext_CSS", data.get("extra_option"));
			System.out.println("The extra is entered successfully for create new option of the question 1");

			// click on the save button
			click("questionnaire_question_1_newoption_1_savebtn_CSS");
			System.out.println("Clicked on the save button");
			ngDriver.waitForAngularRequestsToFinish();

			// click on the save button for all options
			click("questionnaire_question_1_savealloptionbtn_CSS");
			System.out.println("Clicked on the save button for save the option list.");
			ngDriver.waitForAngularRequestsToFinish();

//		// click on the new option button
//		click("questionnaire_question_1_newoptionbtn_CSS");
//		System.out.println("Clicked on the option button");
//		ngDriver.waitForAngularRequestsToFinish();
//
//		// enter data in title of the option of the question 1
//		type("questionnaire_question_1_newoption_1_titletext_CSS", data.get("title_dropboxoption"));
//		System.out.println("The title is entered successfully for create new option of the question 1");
//
//		// select drop box option in the type field of the question 1
//		select("questionnaire_question_1_newoption_1_typetext_CSS", data.get("type_dropboxoption"));
//		System.out.println("The drop box option selcted successfully for create new option of the question 1");
//		ngDriver.waitForAngularRequestsToFinish();
//
//		// enter data in extra of the option of the question 1
//		type("questionnaire_question_1_newoption_1_extratext_CSS", data.get("extra_option"));
//		System.out.println("The extra is entered successfully for create new option of the question 1");
//
//		// click on the choose button
//		click("questionnaire_option_chooseDropboxbtn_CSS");
//		System.out.println("Clicked on the choose button.");
//		ngDriver.waitForAngularRequestsToFinish();
//
//		// click on the category on the Available dropboxes popup
//		click("questionnaire_option_category_chooseDropbox_XPATH");
//		System.out.println("Clicked on the category on the Available dropboxes popup.");
//		ngDriver.waitForAngularRequestsToFinish();
//
//		// click on the save button
//		click("questionnaire_question_1_newoption_1_savebtn_CSS");
//		System.out.println("Clicked on the save button");
//		ngDriver.waitForAngularRequestsToFinish();
//
//		// click on the save button for all options
//		click("questionnaire_question_1_savealloptionbtn_CSS");
//		System.out.println("Clicked on the save button for save the option list.");
//		ngDriver.waitForAngularRequestsToFinish();

			// click on the new option button
			click("questionnaire_question_1_newoptionbtn_CSS");
			System.out.println("Clicked on the option button");
			ngDriver.waitForAngularRequestsToFinish();

			// enter data in title of the option of the question 1
			type("questionnaire_question_1_newoption_1_titletext_CSS", data.get("title_headingoption"));
			System.out.println("The title is entered successfully for create new option of the question 1");

			// select heading option in the type field of the question 1
			select("questionnaire_question_1_newoption_1_typetext_CSS", data.get("type_headingoption"));
			System.out.println("The heading option selcted successfully for create new option of the question 1");
			ngDriver.waitForAngularRequestsToFinish();

			// enter data in extra of the option of the question 1
			type("questionnaire_question_1_newoption_1_extratext_CSS", data.get("extra_option"));
			System.out.println("The extra is entered successfully for create new option of the question 1");

			// click on the save button
			click("questionnaire_question_1_newoption_1_savebtn_CSS");
			System.out.println("Clicked on the save button");
			ngDriver.waitForAngularRequestsToFinish();

			// click on the save button for all options
			click("questionnaire_question_1_savealloptionbtn_CSS");
			System.out.println("Clicked on the save button for save the option list.");
			ngDriver.waitForAngularRequestsToFinish();

			// click on the new option button
			click("questionnaire_question_1_newoptionbtn_CSS");
			System.out.println("Clicked on the option button");
			ngDriver.waitForAngularRequestsToFinish();

			// enter data in title of the option of the question 1
			type("questionnaire_question_1_newoption_1_titletext_CSS", data.get("title_inputboxoption"));
			System.out.println("The title is entered successfully for create new option of the question 1");

			// select input box option in the type field of the question 1
			select("questionnaire_question_1_newoption_1_typetext_CSS", data.get("type_inputboxoption"));
			System.out.println("The input box option selcted successfully for create new option of the question 1");
			ngDriver.waitForAngularRequestsToFinish();

			// enter data in extra of the option of the question 1
			type("questionnaire_question_1_newoption_1_extratext_CSS", data.get("extra_option"));
			System.out.println("The extra is entered successfully for create new option of the question 1");

			// click on the save button
			click("questionnaire_question_1_newoption_1_savebtn_CSS");
			System.out.println("Clicked on the save button");
			ngDriver.waitForAngularRequestsToFinish();

			// click on the save button for all options
			click("questionnaire_question_1_savealloptionbtn_CSS");
			System.out.println("Clicked on the save button for save the option list.");
			ngDriver.waitForAngularRequestsToFinish();

			// click on the new option button
			click("questionnaire_question_1_newoptionbtn_CSS");
			System.out.println("Clicked on the option button");
			ngDriver.waitForAngularRequestsToFinish();

			// enter data in title of the option of the question 1
			type("questionnaire_question_1_newoption_1_titletext_CSS", data.get("title_instructionsforuseroption"));
			System.out.println("The title is entered successfully for create new option of the question 1");

			// select instructions for user option in the type field of the question 1
			select("questionnaire_question_1_newoption_1_typetext_CSS", data.get("type_instructionsforuseroption"));
			System.out.println(
					"The instructions for user option selcted successfully for create new option of the question 1");
			ngDriver.waitForAngularRequestsToFinish();

			// enter data in extra of the option of the question 1
			type("questionnaire_question_1_newoption_1_extratext_CSS", data.get("extra_option"));
			System.out.println("The extra is entered successfully for create new option of the question 1");

			// click on the save button
			click("questionnaire_question_1_newoption_1_savebtn_CSS");
			System.out.println("Clicked on the save button");
			ngDriver.waitForAngularRequestsToFinish();

			// click on the save button for all options
			click("questionnaire_question_1_savealloptionbtn_CSS");
			System.out.println("Clicked on the save button for save the option list.");
			ngDriver.waitForAngularRequestsToFinish();

			// click on the new option button
			click("questionnaire_question_1_newoptionbtn_CSS");
			System.out.println("Clicked on the option button");
			ngDriver.waitForAngularRequestsToFinish();

			// enter data in title of the option of the question 1
			type("questionnaire_question_1_newoption_1_titletext_CSS", data.get("title_numericvalueoption"));
			System.out.println("The title is entered successfully for create new option of the question 1");

			// select numeric value option in the type field of the question 1
			select("questionnaire_question_1_newoption_1_typetext_CSS", data.get("type_numericvalueoption"));
			System.out.println("The numeric value option selcted successfully for create new option of the question 1");
			ngDriver.waitForAngularRequestsToFinish();

			// enter data in extra of the option of the question 1
			type("questionnaire_question_1_newoption_1_extratext_CSS", data.get("extra_option"));
			System.out.println("The extra is entered successfully for create new option of the question 1");

			// click on the save button
			click("questionnaire_question_1_newoption_1_savebtn_CSS");
			System.out.println("Clicked on the save button");
			ngDriver.waitForAngularRequestsToFinish();

			// click on the save button for all options
			click("questionnaire_question_1_savealloptionbtn_CSS");
			System.out.println("Clicked on the save button for save the option list.");
			ngDriver.waitForAngularRequestsToFinish();

			// click on the new option button
			click("questionnaire_question_1_newoptionbtn_CSS");
			System.out.println("Clicked on the option button");
			ngDriver.waitForAngularRequestsToFinish();

			// enter data in title of the option of the question 1
			type("questionnaire_question_1_newoption_1_titletext_CSS", data.get("title_optionlistoption"));
			System.out.println("The title is entered successfully for create new option of the question 1");

			// select option list option in the type field of the question 1
			select("questionnaire_question_1_newoption_1_typetext_CSS", data.get("type_optionlistoption"));
			System.out.println("The optionlist option selcted successfully for create new option of the question 1");
			ngDriver.waitForAngularRequestsToFinish();

			// enter data in extra of the option of the question 1
			type("questionnaire_question_1_newoption_1_extratext_CSS", data.get("extra_option"));
			System.out.println("The extra is entered successfully for create new option of the question 1");

			// click on the save button
			click("questionnaire_question_1_newoption_1_savebtn_CSS");
			System.out.println("Clicked on the save button");
			ngDriver.waitForAngularRequestsToFinish();

			// click on the save button for all options
			click("questionnaire_question_1_savealloptionbtn_CSS");
			System.out.println("Clicked on the save button for save the option list.");
			ngDriver.waitForAngularRequestsToFinish();

			// click on the new option button
			click("questionnaire_question_1_newoptionbtn_CSS");
			System.out.println("Clicked on the option button");
			ngDriver.waitForAngularRequestsToFinish();

			// enter data in title of the option of the question 1
			type("questionnaire_question_1_newoption_1_titletext_CSS", data.get("title_percentageamountoption"));
			System.out.println("The title is entered successfully for create new option of the question 1");

			// select percentage amount option in the type field of the question 1
			select("questionnaire_question_1_newoption_1_typetext_CSS", data.get("type_percentageamountoption"));
			System.out.println(
					"The percentage amount option selcted successfully for create new option of the question 1");
			ngDriver.waitForAngularRequestsToFinish();

			// enter data in extra of the option of the question 1
			type("questionnaire_question_1_newoption_1_extratext_CSS", data.get("extra_option"));
			System.out.println("The extra is entered successfully for create new option of the question 1");

			// click on the save button
			click("questionnaire_question_1_newoption_1_savebtn_CSS");
			System.out.println("Clicked on the save button");
			ngDriver.waitForAngularRequestsToFinish();

			// click on the save button for all options
			click("questionnaire_question_1_savealloptionbtn_CSS");
			System.out.println("Clicked on the save button for save the option list.");
			ngDriver.waitForAngularRequestsToFinish();

			// click on the new option button
			click("questionnaire_question_1_newoptionbtn_CSS");
			System.out.println("Clicked on the option button");
			ngDriver.waitForAngularRequestsToFinish();

			// enter data in title of the option of the question 1
			type("questionnaire_question_1_newoption_1_titletext_CSS", data.get("title_quarterlydateoption"));
			System.out.println("The title is entered successfully for create new option of the question 1");

			// select quarterly date option in the type field of the question 1
			select("questionnaire_question_1_newoption_1_typetext_CSS", data.get("type_quarterlydateoption"));
			System.out.println("The quarterlydate option selcted successfully for create new option of the question 1");
			ngDriver.waitForAngularRequestsToFinish();

			// enter data in extra of the option of the question 1
			type("questionnaire_question_1_newoption_1_extratext_CSS", data.get("extra_option"));
			System.out.println("The extra is entered successfully for create new option of the question 1");

			// click on the save button
			click("questionnaire_question_1_newoption_1_savebtn_CSS");
			System.out.println("Clicked on the save button");
			ngDriver.waitForAngularRequestsToFinish();

			// click on the save button for all options
			click("questionnaire_question_1_savealloptionbtn_CSS");
			System.out.println("Clicked on the save button for save the option list.");
			ngDriver.waitForAngularRequestsToFinish();

//		// click on the new option button
//		click("questionnaire_question_1_newoptionbtn_CSS");
//		System.out.println("Clicked on the option button");
//		ngDriver.waitForAngularRequestsToFinish();
//
//		// enter data in title of the option of the question 1
//		type("questionnaire_question_1_newoption_1_titletext_CSS", data.get("title_likertscaleoption"));
//		System.out.println("The title is entered successfully for create new option of the question 1");
//
//		// select likert scale option in the type field of the question 1
//		select("questionnaire_question_1_newoption_1_typetext_CSS", data.get("type_likertscaleoption"));
//		System.out.println("The likert scale option selcted successfully for create new option of the question 1");
//		ngDriver.waitForAngularRequestsToFinish();
//
//		// enter data in extra of the option of the question 1
//		type("questionnaire_question_1_newoption_1_extratext_CSS", data.get("extra_option"));
//		System.out.println("The extra is entered successfully for create new option of the question 1");
//
//		// click on the save button
//		click("questionnaire_question_1_newoption_1_savebtn_CSS");
//		System.out.println("Clicked on the save button");
//		ngDriver.waitForAngularRequestsToFinish();
//
//		// click on the save button for all options
//		click("questionnaire_question_1_savealloptionbtn_CSS");
//		System.out.println("Clicked on the save button for save the option list.");
//		ngDriver.waitForAngularRequestsToFinish();

			// click on the back to questions button
			click("questionnaire_question_1_option_backtoquestionsbtn_CSS");
			System.out.println("Clicked on the back to questions button.");
			ngDriver.waitForAngularRequestsToFinish();

			// click on the save button for save all question
			click("questionnaire_saveallquestionbtn_CSS");
			System.out.println("Clicked on the save button for save all questions.");
			ngDriver.waitForAngularRequestsToFinish();

			// ADD THE DEPENDANCY IN THE QUESTION

			// click on the edit button of the question 2
			click("questionnaire_question_2_editbtn_CSS");
			System.out.println("Clicked on the edit button of the question 2.");
			ngDriver.waitForAngularRequestsToFinish();

			// scroll till the comment field
			WebElement element6 = driver.findElement(
					By.cssSelector(OR.getProperty("questionnaire_question_1_commentandinstructiontxt_CSS")));
			js.executeScript("arguments[0].scrollIntoView();", element6);

			// click on the dependency button of the question 2
			click("questionnaire_question_2_dependencybtn_CSS");
			System.out.println("Clicked on the dependency button of the question 2.");
			ngDriver.waitForAngularRequestsToFinish();

			// click on the add icon of the depends on question
			click("questionnaire_question_dependancies_addbtn1_CSS");
			System.out.println("Clicked on the add icon of the depends on question.");
			ngDriver.waitForAngularRequestsToFinish();

			// enter the data in the filter field of the dependency
			type("questionnaire_question_dependancies_filter_CSS", data.get("question_title_1"));
			System.out.println("Entered the data in the filter field of the dependency.");
			ngDriver.waitForAngularRequestsToFinish();

			// click on the filtered result
			click("questionnaire_question_dependancies_filteredresult_CSS");
			System.out.println("Clicked on the filtered result.");
			ngDriver.waitForAngularRequestsToFinish();

			// select the yes option from the dropdown
			select("questionnaire_yesselect_CSS", data.get("dependency_dd"));
			System.out.println("Selected the yes option from the dropdown.");
			ngDriver.waitForAngularRequestsToFinish();

			// click on the save button
			click("questionnaire_question_dependancies_savebtn_CSS");
			System.out.println("Clicked on the save button.");
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
			switchVerification("questionnaire_createdrecordoptdep_1_XPATH", "Test Opt Dep Questionnaire Title",
					"The Test Opt Dep Questionnaire Title record is not displayed in the questionnaire list.");

		} catch (Throwable t) {

			verificationFailed();
		}

		// click on the home icon from the top left corner
		click("questionnaire_homeburgermenubtn_CSS");
		System.out.println("Clicked on the home icon from the top left corner.");
		ngDriver.waitForAngularRequestsToFinish();

		// wait for the element
		explicitWait("propertylist_title_XPATH");

		// verify the property list
		switchVerification("propertylist_title_XPATH", "Property List", "The property list is not displayed.");

		// VERIFY THE NEWLY CREATED QUESTIONNAIRE IN THE SURVEY

		System.out.println("***************** VERIFY THE NEWLY CREATED QUESTIONNAIRE IN THE SURVEY *****************");
		test.log(LogStatus.INFO,
				"***************** VERIFY THE NEWLY CREATED QUESTIONNAIRE IN THE SURVEY *****************");
		Reporter.log("***************** VERIFY THE NEWLY CREATED QUESTIONNAIRE IN THE SURVEY *****************");
		log.info("***************** VERIFY THE NEWLY CREATED QUESTIONNAIRE IN THE SURVEY *****************");

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

			// select the respective questionnaire from the dropdown
			select("survey_questionnairedd_CSS", data.get("questionnaire_title"));
			System.out.println("The questionnaire selected successfully.");
			ngDriver.waitForAngularRequestsToFinish();

			// verify questionnaire is selected correctly or not
			switchVerification("questionnaire_questiontitle_XPATH", "Test Category Title One",
					"The Test Category Title One is not displayed.");

			// click on the yes button of the question 1
			click("survey_yesanswerbtn_1_CSS");
			System.out.println("Clicked on the yes button of the question 1.");
			ngDriver.waitForAngularRequestsToFinish();

			// answer the option 1
			click("survey_option_0_CSS");
			System.out.println("Clicked on the checkbox of the Check List.");
			ngDriver.waitForAngularRequestsToFinish();

			// click on the TAB Key of the keyboard
			WebElement webElement = driver.findElement(By.cssSelector(OR.getProperty("survey_option_0_CSS")));
			webElement.sendKeys(Keys.TAB);

			Thread.sleep(5000);

			// answer the option 2
			type("survey_option_1_CSS", data.get("title_commentboxoption"));
			System.out.println("Entered in the text area of the Comment Box.");
			ngDriver.waitForAngularRequestsToFinish();

			// click on the TAB Key of the keyboard
			webElement = driver.findElement(By.cssSelector(OR.getProperty("survey_option_1_CSS")));
			webElement.sendKeys(Keys.TAB);

			// answer the option 3
			click("survey_option_2_CSS");
			System.out.println("Select the today's date in the date picker.");
			ngDriver.waitForAngularRequestsToFinish();

			// click on the today button
			click("survey_imported_category_1_question_1_todaybtn_XPATH");
			System.out.println("Clicked on the today button.");

			// click on the TAB Key of the keyboard
			webElement = driver.findElement(By.cssSelector(OR.getProperty("survey_option_2_CSS")));
			webElement.sendKeys(Keys.TAB);

			// answer the option 4
			type("survey_option_3_CSS", "40");
			System.out.println("Enter the Amount in the Dollar Amount.");
			ngDriver.waitForAngularRequestsToFinish();

			// click on the TAB Key of the keyboard
			webElement = driver.findElement(By.cssSelector(OR.getProperty("survey_option_3_CSS")));
			webElement.sendKeys(Keys.TAB);

			// verify the heading title
			switchVerification("survey_option_4_XPATH", "Test Heading Option",
					"The Test Heading Option is not displayed.");

			// answer the option 6
			type("survey_option_5_CSS", data.get("title_inputboxoption"));
			System.out.println("Enter the text in the Input Box.");
			ngDriver.waitForAngularRequestsToFinish();

			// click on the TAB Key of the keyboard
			webElement = driver.findElement(By.cssSelector(OR.getProperty("survey_option_5_CSS")));
			webElement.sendKeys(Keys.TAB);

			// verify the Instructions for User title
			switchVerification("survey_option_6_XPATH", "Test Instructions for User Option",
					"The Test Instructions for User Option is not displayed.");

			// answer the option 8
			type("survey_option_7_CSS", "80");
			System.out.println("Enter the number in the Numerical Value.");
			ngDriver.waitForAngularRequestsToFinish();

			// click on the TAB Key of the keyboard
			webElement = driver.findElement(By.cssSelector(OR.getProperty("survey_option_7_CSS")));
			webElement.sendKeys(Keys.TAB);

			// scroll down the screen
			JavascriptExecutor js = (JavascriptExecutor) driver;
			js.executeScript("window.scrollBy(0,500)");

			// answer the option 9
			click("survey_option_8_CSS");
			System.out.println("Clicked on the checkbox of the Option List.");
			ngDriver.waitForAngularRequestsToFinish();

			// click on the TAB Key of the keyboard
			webElement = driver.findElement(By.cssSelector(OR.getProperty("survey_option_8_CSS")));
			webElement.sendKeys(Keys.TAB);

			// answer the option 10
			type("survey_option_9_CSS", "90");
			System.out.println("Enter the number in the Percentage Amount.");
			ngDriver.waitForAngularRequestsToFinish();

			// click on the TAB Key of the keyboard
			webElement = driver.findElement(By.cssSelector(OR.getProperty("survey_option_9_CSS")));
			webElement.sendKeys(Keys.TAB);

			// answer the option 11
			type("survey_option_10_CSS", "2020-Q4");
			System.out.println("Enter the number in the Percentage Amount.");
			ngDriver.waitForAngularRequestsToFinish();

			// scroll down till bottom
			WebElement element2 = driver.findElement(By.cssSelector(OR.getProperty("survey_yesanswerbtn_2_CSS")));
			js.executeScript("arguments[0].scrollIntoView();", element2);

			// click on the yes button of the question 2
			click("survey_yesanswerbtn_2_CSS");
			System.out.println("Clicked on the yes button of the question 2.");
			ngDriver.waitForAngularRequestsToFinish();

			// click on the category 1 question 1 label
			click("checklist_category_1_question_1_XPATH");
			System.out.println("Clicked on the category 1 question 1 label.");
			ngDriver.waitForAngularRequestsToFinish();

			// verify 100% survey complete or not
			switchVerification("survey_imported_questionnaire_100_XPATH", "100% complete",
					"The 100% complete is not completed yet.");

		} catch (Throwable t) {
			System.out.println("The newly created questionnaire is not displayed.");
			test.log(LogStatus.INFO, "The newly created questionnaire is not displayed.");
			Reporter.log("The newly created questionnaire is not displayed.");
			log.info("The newly created questionnaire is not displayed.");

			verificationFailed();
		}

		// click on the Home button
		click("questionnaire_homeburgermenubtn_hide_CSS");
		System.out.println("Clicked on the home button.");
		ngDriver.waitForAngularRequestsToFinish();
		System.out.println("Navigate to the Home Screen i.e. property listing screen.");

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
			click("questionnaire_createdrecordoptdep_1_XPATH");
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
