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

public class RR3893SurveyChecklistOneTest extends TestBase {

	@Test(dataProviderClass = TestUtil.class, dataProvider = "dp")
	public void rR3893SurveyChecklistOneTest(Hashtable<String, String> data) throws IOException, InterruptedException {

		execution(data, "rR3893SurveyChecklistOneTest");

		// MULTIPLE LANGUAGE SUPPORT QUESTIONNAIRE FOR SURVEY
		title("MULTIPLE LANGUAGE SUPPORT QUESTIONNAIRE FOR SURVEY.");

		Helper helper = new Helper();

		// refresh the page
		driver.navigate().refresh();
		Thread.sleep(5000);
		driver.navigate().refresh();

		System.out.println("Navigate to the Home Screen i.e. Property List Screen.");

		// ADD NEW QUESTIONNIRE
		title("ADD NEW QUESTIONNIRE");

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

			// Select the type of the questionnaire
			click("questionnaire_type_propertybtn_CSS");

			// Select the level of the questionnaire
			click("questionnaire_level_propertybtn_CSS");

			// enter the group title
			type("questionnaire_grouptitletxt_CSS", data.get("group_title"));

			// click on the language button
			click("questionnaire_createtask_languagebtn_CSS");

			// enter the questionnaire title in the English language
			type("questionnaire_createtask_languagebtn_english_CSS", data.get("questionnaire_title"));

			// enter the questionnaire title in the French language
			type("questionnaire_createtask_languagebtn_french_CSS", data.get("questionnaire_title_french"));

//		// enter the questionnaire title in the Spanish language
//		type("questionnaire_createtask_languagebtn_spanish_CSS", data.get("questionnaire_title_spanish"));
//		System.out.println("Entered the questionnaire title in the Spanish language.");
//		ngDriver.waitForAngularRequestsToFinish();
//
//		// enter the questionnaire title in the Chinese language
//		type("questionnaire_createtask_languagebtn_chinese_CSS", data.get("questionnaire_title_chinese"));
//		System.out.println("Entered the questionnaire title in the Chinese language.");
//		ngDriver.waitForAngularRequestsToFinish();

			// click on the save button questionnaire title
			click("questionnaire_createtask_languagebtn_savebtn_CSS");

			// select the model
			select("questionnaire_modeldd_CSS", data.get("model"));

//			// select the document/report type
//			select("questionnaire_docreportdd_CSS", data.get("document_reporttype"));
//			System.out.println("The data entered in the document/report type field.");
//			ngDriver.waitForAngularRequestsToFinish();
//
//			// select the default task tag
//			select("questionnaire_defaulttasktagdd_CSS", data.get("default_task_tag"));
//			System.out.println("The data entered in the default task tag field.");
//			ngDriver.waitForAngularRequestsToFinish();

			// select the frequency
			select("questionnaire_frequencydd_CSS", data.get("frequency"));

			// enter the year
			type("questionnaire_yeartxt_CSS", "2020");

			// select the month
			select("questionnaire_monthtxt_CSS", data.get("month"));

			// enter the description
			type("questionnaire_descriptiontxt_CSS", data.get("description"));

			// click on the save button
			click("questionnaire_savebtn_BTNTEXT");

			// enter the newly created questionnaire in the search field
			type("ssc_company2_questionnairelist_filtertxt_CSS", data.get("questionnaire_title"));

			// verification of the created questionnaire
			verifyTrue("questionnaire_createdrecordauto_multiplelanguage_XPATH",
					"The newly questionnaire is not created.");

			// ADD CATEGORY 1 INTO THE QUESTIONNAIRE
			title("ADD CATEGORY 1 INTO THE QUESTIONNAIRE");

			// click on the created questionnaire
			click("questionnaire_createdrecordauto_multiplelanguage_XPATH");

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

			// click on the save button for save all categories
			click("questionnaire_category_savebtn_CSS");

			// wait for the element
			explicitWaitClickable("closetoastmsg_CSS");

			// click on the toaster close button
			click("closetoastmsg_CSS");

			// verify newly created category is displayed or not
			verifyTrue("questionnaire_newcategory_1_english_XPATH",
					"The newly created category is not displayed in the category list.");

			// select the French language from the language dropdown
			select("questionnaire_newcategory_languagedd_CSS", data.get("category_language_french"));

			// click on the edit button of category one
			click("questionnaire_category_editbtn_CSS");

			// enter the French title
			type("questionnaire_newcategory_titletxt_CSS", data.get("category_title_french"));

			// click on the save button
			click("questionnaire_newcategory_multiplelanguage_savebtn_CSS");

			// verify newly added category title is displayed or not
			verifyTrue("questionnaire_newcategory_1_french_XPATH",
					"The newly added category title is displayed in the category list.");

//		// select the Spanish language from the language dropdown
//		select("questionnaire_newcategory_languagedd_CSS", data.get("category_language_spanish"));
//
//		// click on the edit button of category one
//		click("questionnaire_category_editbtn_CSS");
//
//		// enter the spanish title
//		type("questionnaire_newcategory_titletxt_CSS", data.get("category_title_spanish"));
//
//		// click on the save button
//		click("questionnaire_newcategory_multiplelanguage_savebtn_CSS");
//
//		// verify newly added category title is displayed or not
//		verifyTrue("questionnaire_newcategory_1_spanish_XPATH",
//				"The newly added category title is displayed in the category list.");
//
//		// select the chinese language from the language dropdown
//		select("questionnaire_newcategory_languagedd_CSS", data.get("category_language_chinese"));
//
//		// click on the edit button of category one
//		click("questionnaire_category_editbtn_CSS");
//
//		// enter the chinese title
//		type("questionnaire_newcategory_titletxt_CSS", data.get("category_title_chinese"));
//
//		// click on the save button
//		click("questionnaire_newcategory_multiplelanguage_savebtn_CSS");
//
//		// verify newly added category title is displayed or not
//		verifyTrue("questionnaire_newcategory_1_chinese_XPATH",
//				"The newly added category title is displayed in the category list.");

			// ADD QUESTIONS INTO THE CATEGORY

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
			verifyTrue("questionnaire_newquestion_english_1_XPATH", "The question is not created.");

			// select the French language from the language dropdown
			select("questionnaire_newcategory_languagedd_CSS", data.get("question_language_french"));

			// click on the edit question 1 button
			click("questionnaire_question_1_editbtn_CSS");

			// enter French title in the question
			type("questionnaire_newcategory_titletxt_CSS", data.get("question_title_french"));

			// click on the save button
			click("questionnaire_saveallquestionbtn_CSS");

			// verify question one created or not
			verifyTrue("questionnaire_newquestion_french_1_XPATH", "The question is not created.");

//		// select the Spanish language from the language dropdown
//		select("questionnaire_newcategory_languagedd_CSS", data.get("question_language_spanish"));
//
//		// click on the edit question 1 button
//		click("questionnaire_question_1_editbtn_CSS");
//
//		// enter Spanish title in the question
//		type("questionnaire_newcategory_titletxt_CSS", data.get("question_title_spanish"));
//
//		// click on the save button
//		click("questionnaire_saveallquestionbtn_CSS");
//
//		// verify question one created or not
//		verifyTrue("questionnaire_newquestion_spanish_1_XPATH", "The question is not created.");
//
//		// select the Chinese language from the language dropdown
//		select("questionnaire_newcategory_languagedd_CSS", data.get("question_language_chinese"));
//
//		// click on the edit question 1 button
//		click("questionnaire_question_1_editbtn_CSS");
//
//		// enter Spanish title in the question
//		type("questionnaire_newcategory_titletxt_CSS", data.get("question_title_chinese"));
//
//		// click on the save button
//		click("questionnaire_saveallquestionbtn_CSS");
//
//		// verify question one created or not
//		verifyTrue("questionnaire_newquestion_chinese_1_XPATH", "The question is not created.");

			// click on the save button for save all question
			click("questionnaire_saveallquestionbtn_CSS");

			// wait for the element
			explicitWaitClickable("closetoastmsg_CSS");

			// click on the toaster close button
			click("closetoastmsg_CSS");

			// click on the edit question 1 button
			click("questionnaire_question_1_editbtn_CSS");

			// scroll down the page by 1000 pixel vertical
			scrollByPixel(1000);

			// click on the option button of the question
			click("questionnaire_question_1_optionbtn_CSS");

			// ADD OPTION ONE IN THE QUESTION
			title("ADD OPTION ONE IN THE QUESTION");

			// wait for the element
			explicitWaitClickable("questionnaire_question_1_savealloptionbtn_CSS");

			// click on the save button for all options
			click("questionnaire_question_1_savealloptionbtn_CSS");

			// select the English language from the language dropdown
			select("questionnaire_newoption_languagedd_CSS", data.get("option_language"));

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

			// select the French language from the language dropdown
			select("questionnaire_newoption_languagedd_CSS", data.get("option_language_french"));

			// click on the edit button
			click("questionnaire_question_1_editbtn_CSS");

			// enter data in title of the option of the question 1
			type("questionnaire_newcategory_titletxt_CSS", data.get("title_option_1_question_1_french"));

			// click on the save button for all options
			click("questionnaire_question_1_savealloptionbtn_CSS");

//		// select the Spanish language from the language dropdown
//		select("questionnaire_newoption_languagedd_CSS", data.get("option_language_spanish"));
//
//		// click on the edit button
//		click("questionnaire_question_1_editbtn_CSS");
//
//		// enter data in title of the option of the question 1
//		type("questionnaire_newcategory_titletxt_CSS", data.get("title_option_1_question_1_spanish"));
//
//		// click on the save button for all options
//		click("questionnaire_question_1_savealloptionbtn_CSS");
//		
//		// select the Chinese language from the language dropdown
//		select("questionnaire_newoption_languagedd_CSS", data.get("option_language_chinese"));
//
//		// click on the edit button
//		click("questionnaire_question_1_editbtn_CSS");
//
//		// enter data in title of the option of the question 1
//		type("questionnaire_newcategory_titletxt_CSS", data.get("title_option_1_question_1_chinese"));
//
//		// click on the save button for all options
//		click("questionnaire_question_1_savealloptionbtn_CSS");

			// click on the back to questions button
			click("questionnaire_question_1_option_backtoquestionsbtn_CSS");

			// click on the save button for save all question
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
			type("ssc_company2_questionnairelist_filtertxt_CSS", data.get("questionnaire_title"));

			// verify newly created questionnaire for checklist
			switchVerification("questionnaire_createdrecordauto_multiplelanguage_XPATH",
					"Multiple Language Test English",
					"The Multiple Language Test English record is not displayed in the questionnaire list.");

		} catch (Throwable t) {
			verificationFailed();
		}

		// click on the home icon
		click("questionnaire_homeburgermenubtn_CSS");

		// wait for the element
		explicitWait("propertylist_title_XPATH");

		// verify the property list
		switchVerification("propertylist_title_XPATH", "Property List", "The property list is not displayed.");

		// UPDATE THE LANGUAGE OF THE RESPECTIVE USER
		title("UPDATE THE LANGUAGE OF THE RESPECTIVE USER");

		try {

			// wait for the element
			Thread.sleep(5000);

			// click on the settings icon from the top of the screen
			click("questionnaire_settingicon_CSS");

			// wait for the element
			explicitWaitClickable("questionnaire_administrationoption_XPATH");

			// click on the Administration option from the side menu
			click("questionnaire_administrationoption_XPATH");

			// click on the Security tab
			click("administration_securitytxt_XPATH");

			// click on the user option
			click("administration_userstxt_XPATH");

			// enter the data in the filter
			type("users_filtertxt_CSS", data.get("username"));

			// click on the filtered result
			click("users_username_XPATH");

			// select the french language as a preferred language
			select("users_preferedlanguagedd_CSS", data.get("category_language_french"));

			// this will scroll down the page by 700 pixel vertical
			scrollByPixel(700);

			// wait for the element
			explicitWaitClickable("users_savedetailsbtn_CSS");

			// click on the save button
			click("users_savedetailsbtn_CSS");

			// wait for the element
			explicitWaitClickable("closetoastmsg_CSS");

			// click on the toaster close button
			click("closetoastmsg_CSS");

		} catch (Throwable t) {
			verificationFailed();
		}

		// click on the home icon
		click("questionnaire_homeburgermenubtn_CSS");

		// wait for the element
		explicitWait("propertylist_title_XPATH");

		// verify the property list
		switchVerification("propertylist_title_XPATH", "Property List", "The property list is not displayed.");

		// LOGIN WITH SITE MANAGER USER AND VERIFY QUESTONNAIRE IN SURVEY MODULE
		title("LOGIN WITH SITE MANAGER USER AND VERIFY QUESTONNAIRE IN SURVEY MODULE");

		try {
			// wait for the element
			explicitWaitClickable("questionnaire_settingicon_userupdate_CSS");

			// click on the settings icon from the top of the screen
			click("questionnaire_settingicon_userupdate_CSS");

			// wait for the element
			explicitWaitClickable("sidemenu_logout_CSS");

			// click on the logout option from the side menu
			click("sidemenu_logout_CSS");

			// wait for the element
			explicitWaitClickable("signinbtn_BTNTEXT");

			// Enter the username
			type("username_MODEL", data.get("username"));

			// Enter the password
			type("password_MODEL", data.get("password"));

			// Clicking on the "Sign In" button
			click("signinbtn_BTNTEXT");

			try {

				// wait for the element
				Thread.sleep(5000);

				// click on the settings icon from the top of the screen
				click("questionnaire_settingicon_CSS");

				// wait for the element
				Thread.sleep(5000);

				// click on the Switch System Company option from the side menu
				click("ssc_sidemenubtn_CSS");

				// click on the switch system company dropdown
				click("ssc_systemcompanydd_CSS");

				// select the system company from the system company dropdown
				select("ssc_systemcompanydd_CSS", data.get("system_company_1"));

				// click on system company dropdown
				click("ssc_systemcompanydd_CSS");

				// click on the select button
				click("ssc_selectbtn_BTNTEXT");

			} catch (Throwable t) {
				verificationFailed();
			}

			// VERIFY THE SURVEY IN THE PROPERTY LEVEL
			title("VERIFY THE SURVEY IN THE PROPERTY LEVEL");

			try {
				// click on the environmental icon from the property list page
				click("environmentalicon_CSS");

				// wait for the element
				explicitWaitClickable("menubtn_CSS");

				// click on the burger menu
				click("menubtn_CSS");

				// wait for the element
				Thread.sleep(5000);

				// click on the survey option from side menu
				click("surveyoption_french_XPATH");

				// select the respective questionnaire from the dropdown
				select("survey_questionnairedd_CSS", data.get("questionnaire_title_french"));

				// verify category is selected correctly or not
				switchVerification("questionnaire_categorytitle_frenchlanguage_XPATH",
						"Multiple Language Category One French",
						"The Multiple Language Category One French is not displayed.");

				// verify question is selected correctly or not
				switchVerification("questionnaire_questiontitle_frenchlanguage_XPATH",
						"Multiple Language Question One French",
						"The Multiple Language Question One French is not displayed.");

				// click on the no checkbox of question 1
				click("survey_noanswerbtn_1_CSS");

				// click on the yes checkbox of question 1
				click("survey_yesanswerbtn_1_CSS");

				// wait for the element
				explicitWait("questionnaire_optiontitle_frenchlanguage_XPATH");

				// verify option is selected correctly or not
				switchVerification("questionnaire_optiontitle_frenchlanguage_XPATH",
						"Multiple Language Option One French",
						"The Multiple Language Option One French is not displayed.");

				// click on the no checkbox of question 1
				click("survey_noanswerbtn_1_CSS");

			} catch (Throwable t) {
				verificationFailed();
			}

			// click on the Home button
			click("questionnaire_homeburgermenubtn_hide_CSS");

			// LOGIN IN THE ADMIN USER
			title("LOGIN IN THE ADMIN USER");

			// wait for the element
			explicitWaitClickable("questionnaire_settingicon_userupdate_CSS");

			// click on the settings icon from the top of the screen
			click("questionnaire_settingicon_userupdate_CSS");

			// wait for the element
			explicitWaitClickable("sidemenu_logout_CSS");

			// click on the logout option from the side menu
			click("sidemenu_logout_CSS");

			// login with valid credentials
			helper.loginAndUpdateSystemCompany(data, "username_1", "password_1", "system_company_1");

//		// VERIFICATION IN SPANISH LANGUAGE
//		title("VERIFICATION IN SPANISH LANGUAGE");
//			
//		// wait for the element
//			Thread.sleep(5000);
//
//		
//		// click on the settings icon from the top of the screen
//		click("questionnaire_settingicon_CSS");
//
//		// wait for the element 
//			explicitWaitClickable("questionnaire_administrationoption_XPATH");
//
//		// click on the Administration option from the side menu
//		click("questionnaire_administrationoption_XPATH");
//
//		// click on the Security tab
//		click("administration_securitytxt_XPATH");
//
//		// click on the user option
//		click("administration_userstxt_XPATH");
//
//		// enter the data in the filter
//		type("users_filtertxt_CSS", data.get("username"));
//
//		// click on the filtered result
//		click("users_username_XPATH");
//
//		// select the spanish language as a preferred language
//		select("users_preferedlanguagedd_CSS", data.get("category_language_spanish"));
//
//		// this  will scroll down the page by 700 pixel vertical		
//        js.executeScript("window.scrollBy(0,700)");
//		
//		// wait for the element
//			explicitWaitClickable("users_savedetailsbtn_CSS");
//
//
//        // click on the save button
//        click("users_savedetailsbtn_CSS");
//		
//		// wait for the element
//			explicitWaitClickable("questionnaire_settingicon_userupdate_CSS");
//
//
//		// click on the settings icon from the top of the screen
//		click("questionnaire_settingicon_userupdate_CSS");
//
//		// wait for the element
//			explicitWaitClickable("sidemenu_logout_CSS");
//
//
//		// click on the logout option from the side menu
//		click("sidemenu_logout_CSS");
//
//		// login with valid credentials//
//		loginAndUpdateSystemCompany(data, "username", "password", "system_company_1");
//
//		// click on the environmental icon from the property list page
//		click("environmentalicon_CSS");
//
//		// click on the burger menu
//		click("menubtn_CSS");
//
//		// wait for the element
//			explicitWaitClickable("surveyoption_XPATH");
//
//		// click on the survey option from side menu
//		click("surveyoption_XPATH");
//
//		// select the respective questionnaire from the dropdown
//		select("survey_questionnairedd_CSS", data.get("questionnaire_title_spanish"));
//
//		// verify category is selected correctly or not
//		switchVerification("questionnaire_categorytitle_spanishlanguage_XPATH", "Multiple Language Category One Spanish",
//				"The Multiple Language Category One Spanish is not displayed.");
//
//		// verify question is selected correctly or not
//		switchVerification("questionnaire_questiontitle_spanishlanguage_XPATH", "Multiple Language Question One Spanish",
//				"The Multiple Language Question One Spanish is not displayed.");
//
//		// click on the no checkbox of question 1
//		click("survey_noanswerbtn_1_CSS");
//		
//		// click on the yes checkbox of question 1
//		click("survey_yesanswerbtn_1_CSS");
//
//		// wait for the element
//			explicitWait("questionnaire_optiontitle_spanishlanguage_XPATH");
//
//		// verify option is selected correctly or not
//		switchVerification("questionnaire_optiontitle_spanishlanguage_XPATH", "Multiple Language Option One Spanish",
//				"The Multiple Language Option One Spanish is not displayed.");
//
//		// click on the no checkbox of question 1
//		click("survey_noanswerbtn_1_CSS");
//		
//		// wait for the element
//			Thread.sleep(5000);
//		
//		// click on the settings icon from the top of the screen
//		click("questionnaire_settingicon_userupdate_CSS");
//
//		// wait for the element
//		explicitWaitClickable("sidemenu_logout_CSS");
//
//
//		// click on the logout option from the side menu
//		click("sidemenu_logout_CSS");
//
//		// login with valid credentials//
//		loginAndUpdateSystemCompany(data, "username_1", "password_1", "system_company_1");
//		
//		// VERIFICATION IN CHINESE LANGUAGE
//		
//		// wait for the element
//			Thread.sleep(5000);
//
//		
//		// click on the settings icon from the top of the screen
//		click("questionnaire_settingicon_CSS");
//
//		// wait for the element 
//			explicitWaitClickable("questionnaire_administrationoption_XPATH");
//
//
//		// click on the Administration option from the side menu
//		click("questionnaire_administrationoption_XPATH");
//
//		// click on the Security tab
//		click("administration_securitytxt_XPATH");
//		System.out.println("Clicked on the Security tab.");
//		ngDriver.waitForAngularRequestsToFinish();
//
//		// click on the user option
//		click("administration_userstxt_XPATH");
//		System.out.println("Clicked on the user option.");
//		ngDriver.waitForAngularRequestsToFinish();
//
//		// enter the data in the filter
//		type("users_filtertxt_CSS", data.get("username"));
//		System.out.println("Entered the data in the filter.");
//		ngDriver.waitForAngularRequestsToFinish();
//
//		// click on the filtered result
//		click("users_username_XPATH");
//		System.out.println("Clicked on the filtered result.");
//		ngDriver.waitForAngularRequestsToFinish();
//
//		// select the chinese language as a preferred language
//		select("users_preferedlanguagedd_CSS", data.get("category_language_chinese"));
//		System.out.println("Selected the chinese language as a preferred language.");
//		ngDriver.waitForAngularRequestsToFinish();
//
//		// this  will scroll down the page by 700 pixel vertical		
//        js.executeScript("window.scrollBy(0,700)");
//		
//		// wait for the element
//			explicitWaitClickable("users_savedetailsbtn_CSS");
//
//		
//        // click on the save button
//        click("users_savedetailsbtn_CSS");
//        System.out.println("Clicked on the save button.");
//        ngDriver.waitForAngularRequestsToFinish();
//		
//		// wait for the element
//			explicitWaitClickable("questionnaire_settingicon_userupdate_CSS");
//
//
//		// click on the settings icon from the top of the screen
//		click("questionnaire_settingicon_userupdate_CSS");
//		System.out.println("Clicked on the settings icon.");
//		ngDriver.waitForAngularRequestsToFinish();
//
//		// wait for the element
//		explicitWaitClickable("sidemenu_logout_CSS");
//
//
//		// click on the logout option from the side menu
//		click("sidemenu_logout_CSS");
//		System.out.println("Clicked on the logout option from the side menu.");
//		ngDriver.waitForAngularRequestsToFinish();
//
//		// login with valid credentials
//
//			loginAndUpdateSystemCompany(data, "username", "password", "system_company_1");
//
//		// click on the environmental icon from the property list page
//		click("environmentalicon_CSS");
//		System.out.println("Clicked on the environmental icon of the Property.");
//		ngDriver.waitForAngularRequestsToFinish();
//		System.out.println("Navigate to the environmental screen of the perticular property.");
//
//		// click on the burger menu
//		click("menubtn_CSS");
//		System.out.println("Clicked on the burger menu button successfully!!!");
//		ngDriver.waitForAngularRequestsToFinish();
//
//			// wait for the element
//			explicitWaitClickable("surveyoption_XPATH");
//
//
//		// click on the survey option from side menu
//		click("surveyoption_XPATH");
//		System.out.println("Clicked on the survey option from side menu");
//		ngDriver.waitForAngularRequestsToFinish();
//		System.out.println("Navigate to the survey screen");
//
//		// select the respective questionnaire from the dropdown
//		select("survey_questionnairedd_CSS", data.get("questionnaire_title_chinese"));
//		System.out.println("The questionnaire selected successfully.");
//		ngDriver.waitForAngularRequestsToFinish();
//
//		// verify category is selected correctly or not
//		switchVerification("questionnaire_categorytitle_chineselanguage_XPATH", "Multiple Language Category One Chinese",
//				"The Multiple Language Category One chinese is not displayed.");
//
//		// verify question is selected correctly or not
//		switchVerification("questionnaire_questiontitle_chineselanguage_XPATH", "Multiple Language Question One Chinese",
//				"The Multiple Language Question One chinese is not displayed.");
//
//		// click on the no checkbox of question 1
//		click("survey_noanswerbtn_1_CSS");
//		System.out.println("Clicked on the no checkbox.");
//		ngDriver.waitForAngularRequestsToFinish();
//		
//		// click on the yes checkbox of question 1
//		click("survey_yesanswerbtn_1_CSS");
//		System.out.println("Clicked on the yes checkbox.");
//		ngDriver.waitForAngularRequestsToFinish();
//
//			// wait for the element
//			explicitWait("questionnaire_optiontitle_chineselanguage_XPATH");
//
//
//		// verify option is selected correctly or not
//		switchVerification("questionnaire_optiontitle_chineselanguage_XPATH", "Multiple Language Option One Chinese",
//				"The Multiple Language Option One chinese is not displayed.");
//
//		// click on the no checkbox of question 1
//		click("survey_noanswerbtn_1_CSS");
//		System.out.println("Clicked on the no checkbox.");
//		ngDriver.waitForAngularRequestsToFinish();
//		
//			// wait for the element
//			explicitWaitClickable("questionnaire_settingicon_userupdate_CSS");
//		
//		
//		// click on the settings icon from the top of the screen
//		click("questionnaire_settingicon_userupdate_CSS");
//		System.out.println("Clicked on the settings icon.");
//		ngDriver.waitForAngularRequestsToFinish();
//
//		// wait for the element
//			explicitWaitClickable("sidemenu_logout_CSS");
//
//
//		// click on the logout option from the side menu
//		click("sidemenu_logout_CSS");
//		System.out.println("Clicked on the logout option from the side menu.");
//		ngDriver.waitForAngularRequestsToFinish();
//
//		// login with valid credentials
//
//			loginAndUpdateSystemCompany(data, "username_1", "password_1", "system_company_1");
//

		} catch (Throwable t) {
			helper.questionnaireNotDisplayLogout(data);
		}

		// SET PREFFERED LANGUAGE AS A ENGLISH
		title("SET PREFFERED LANGUAGE AS A ENGLISH");

		try {

			// wait for the element
			Thread.sleep(5000);

			// click on the settings icon from the top of the screen
			click("questionnaire_settingicon_CSS");

			// wait for the element
			explicitWaitClickable("questionnaire_administrationoption_XPATH");

			// click on the Administration option from the side menu
			click("questionnaire_administrationoption_XPATH");

			// click on the Security tab
			click("administration_securitytxt_XPATH");

			// click on the user option
			click("administration_userstxt_XPATH");

			// enter the data in the filter
			type("users_filtertxt_CSS", data.get("username"));

			// click on the filtered result
			click("users_username_XPATH");

			// select the english language as a preferred language
			select("users_preferedlanguagedd_CSS", data.get("category_language"));

			// this will scroll down the page by 700 pixel vertical
			scrollByPixel(700);

			// wait for the element
			explicitWaitClickable("users_savedetailsbtn_CSS");

			// click on the save button
			click("users_savedetailsbtn_CSS");

		} catch (Throwable t) {
			verificationFailed();
		}

		// UPDATE THE QUESTIONNAIRE TITLE WITH RANDOM TEXT
		title("UPDATE THE QUESTIONNAIRE TITLE WITH RANDOM TEXT");

		try {

			// wait for the element
			explicitWaitClickable("administration_XPATH");

			// click on the Administration option from the top
			click("administration_XPATH");

			// click on the Questionnaires tab
			click("questionnaire_questionnairestab_XPATH");

			// click on the Questionnaires option
			click("questionnaire_questionnairesoption_XPATH");

			// enter newly created questionnaire in the filter field
			type("ssc_company2_questionnairelist_filtertxt_CSS", data.get("questionnaire_title"));

			// click on the created questionnaire
			click("questionnaire_createdrecordauto_multiplelanguage_XPATH");

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
