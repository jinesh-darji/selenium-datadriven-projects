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

public class RR3888SurveyChecklistTest extends TestBase {

	@Test(dataProviderClass = TestUtil.class, dataProvider = "dp")
	public void rR3888SurveyChecklistTest(Hashtable<String, String> data) throws IOException, InterruptedException {

		execution(data, "rR3888SurveyChecklistTest");

		// CREATE THE SURVEY IN PROPERTY AND BUILDING LEVELS AND VERIFY IN THE SURVEY
		// MODULE

		title("CREATE THE SURVEY IN PROPERTY AND BUILDING LEVELS AND VERIFY IN THE SURVEY MODULE");

		Helper helper = new Helper();

		// refresh the page
		driver.navigate().refresh();
		Thread.sleep(5000);
		driver.navigate().refresh();

		System.out.println("Navigate to the Home Screen i.e. Property List Screen.");

		// CREATE THE SURVEY IN THE PROPERTY LEVELS
		title("CREATE THE SURVEY IN THE PROPERTY LEVELS");

		try {

			// Wait for the element
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

			// enter the questionnaire title
			type("questionnaire_languagetitle_CSS", data.get("questionnaire_title"));

			// select the model
			select("questionnaire_modeldd_CSS", data.get("model"));

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

			// enter newly created questionnaire in the filter field
			type("ssc_company2_questionnairelist_filtertxt_CSS", data.get("record1_filter_1"));

			// verify newly created questionnaire for survey
			switchVerification("questionnaire_record1_XPATH", "Test Questionnaire Property Title",
					"The Test Questionnaire Property Title record is not displayed in the questionnaire list.");

			// CONFIGRATION OF QUESTION
			title("CONFIGRATION OF QUESTION");

			// click on the created questionnaire
			click("questionnaire_record1_XPATH");

			helper.configureQuestions(data);

			// enter newly created questionnaire in the filter field
			type("ssc_company2_questionnairelist_filtertxt_CSS", data.get("record1_filter_1"));

			// verify newly created questionnaire for survey
			switchVerification("questionnaire_record1_XPATH", "Test Questionnaire Property Title",
					"The Test Questionnaire Title record is not displayed in the questionnaire list.");

		} catch (Throwable t) {
			verificationFailed();
		}

		// click on the home icon
		click("questionnaire_homeburgermenubtn_CSS");

		// wait for the element
		explicitWait("propertylist_title_XPATH");

		// verify the property list
		switchVerification("propertylist_title_XPATH", "Property List", "The property list is not displayed.");

		// CREATE THE SURVEY IN THE BUILDING LEVELS
		title("CREATE THE SURVEY IN THE BUILDING LEVELS");

		try {

			// wait for the element
			Thread.sleep(7000);

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
			click("questionnaire_level_buildingbtn_CSS");

			// enter the group title
			type("questionnaire_grouptitletxt_CSS", data.get("group_title"));

			// enter the questionnaire title
			type("questionnaire_languagetitle_CSS", data.get("questionnaire_building_title"));

			// select the model
			select("questionnaire_modeldd_CSS", data.get("model"));

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

			// enter newly created questionnaire in the filter field
			type("ssc_company2_questionnairelist_filtertxt_CSS", data.get("questionnaire_building_title"));

			// verify newly created questionnaire for survey
			switchVerification("questionnaire_building_record1_XPATH", "Test Questionnaire Building Title",
					"The Test Questionnaire Building Title record is not displayed in the questionnaire list.");

			// CONFIGRATION OF QUESTION
			title("CONFIGRATION OF QUESTION");

			// click on the created questionnaire
			click("questionnaire_building_record1_XPATH");

			helper.configureQuestions(data);

			// wait for the element
			explicitWait("ssc_company2_questionnairelist_filtertxt_CSS");

			// enter newly created questionnaire in the filter field
			type("ssc_company2_questionnairelist_filtertxt_CSS", data.get("questionnaire_building_title"));

			// verify newly created questionnaire for survey
			switchVerification("questionnaire_building_record1_XPATH", "Test Questionnaire Building Title",
					"The Test Questionnaire Building Title record is not displayed in the questionnaire list.");

		} catch (Throwable t) {

			verificationFailedMessage("The newly created questionnaire is not displayed.");

		}

		// click on the home menu burger button
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
			explicitWaitClickable("menubtn_CSS");

			// click on the burger menu
			click("menubtn_CSS");

			// wait for the element
			Thread.sleep(5000);

			// click on the survey option from side menu
			click("surveyoption_XPATH");

			// select the property level from the dropdown
			select("survey_leveldropdown_CSS", data.get("property_leveldropdown"));

			// select the respective questionnaire from the dropdown
			select("survey_questionnairedd_CSS", data.get("survey_questionnaire_dd"));

			// verify questionnaire is selected correctly or not
			switchVerification("questionnaire_questiontitle_XPATH", "Test Category Title One",
					"The Test Category Title One is not displayed.");

			// select the building level from the dropdown
			select("survey_builtingleveldropdown_CSS", data.get("building_leveldropdown"));

			// select the respective questionnaire from the dropdown
			select("survey_questionnairedd_CSS", data.get("questionnaire_building_title"));

			// verify questionnaire is selected correctly or not
			switchVerification("questionnaire_questiontitle_building_XPATH", "Test Category Title Two Two",
					"The Test Category Title Two Two is not displayed.");

		} catch (Throwable t) {

			verificationFailedMessage("The newly created questionnaire is not displayed.");

		}

		// click on the home option from the side menu
		click("questionnaire_homeburgermenubtn_hide_CSS");

		// wait for the element
		explicitWait("propertylist_title_XPATH");

		// verify the property list
		switchVerification("propertylist_title_XPATH", "Property List", "The property list is not displayed.");

		// DELETE THE ADDED QUESTIONNAIRE - PROPERTY
		title("DELETE THE ADDED QUESTIONNAIRE - PROPERTY");

		try {
			// Wait for the element
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

			// enter newly created questionnaire in the filter field
			type("ssc_company2_questionnairelist_filtertxt_CSS", data.get("questionnaire_title"));

			// click on the created questionnaire
			click("questionnaire_record1_XPATH");

			helper.deleteSurveyQuestionnaire(data);

			// enter newly created questionnaire in the filter field
			type("ssc_company2_questionnairelist_filtertxt_CSS", data.get("questionnaire_title"));

			// verify newly created questionnaire for checklist
			switchVerification("questionnaire_record1_XPATH", "Test Questionnaire Property Title",
					"The Test Questionnaire Property Title record is not displayed in the questionnaire list.");

			// click on the created questionnaire
			click("questionnaire_record1_XPATH");

			// scroll till the delete button
			scrollTillElement("questionnaire_deletebtn_CSS");

			// wait for the element
			explicitWaitClickable("questionnaire_deletebtn_CSS");

			// click on the delete button
			click("questionnaire_deletebtn_CSS");

			// wait for the element
			explicitWaitClickable("questionnaire_modeldeletebtn_CSS");

			// click on the delete button of the confirmation popup
			click("questionnaire_modeldeletebtn_CSS");

			// enter newly created questionnaire in the filter field
			type("ssc_company2_questionnairelist_filtertxt_CSS", data.get("questionnaire_title"));

			helper.deleteVerification("questionnaire_record1_XPATH", "Test Questionnaire Property Title");

		} catch (Throwable t) {

			verificationFailedMessage("The newly created questionnaire is not displayed.");

		}

		// click on the home icon from the top of the screen
		click("questionnaire_homeburgermenubtn_CSS");

		// wait for the element
		explicitWait("propertylist_title_XPATH");

		// verify the property list
		switchVerification("propertylist_title_XPATH", "Property List", "The property list is not displayed.");

		// DELETE THE ADDED QUESTIONNAIRE - BUILDING
		title("DELETE THE ADDED QUESTIONNAIRE - BUILDING");

		try {
			// Wait for the element
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

			// enter newly created questionnaire in the filter field
			type("ssc_company2_questionnairelist_filtertxt_CSS", data.get("questionnaire_building_title"));

			// click on the created questionnaire
			click("questionnaire_building_record1_XPATH");

			helper.deleteSurveyQuestionnaire(data);

			// enter newly created questionnaire in the filter field
			type("ssc_company2_questionnairelist_filtertxt_CSS", data.get("questionnaire_building_title"));

			// verify newly created questionnaire for checklist
			switchVerification("questionnaire_building_record1_XPATH", "Test Questionnaire Building Title",
					"The Test Questionnaire Property Title record is not displayed in the questionnaire list.");

			// click on the created questionnaire
			click("questionnaire_building_record1_XPATH");

			// scroll till the delete button
			scrollTillElement("questionnaire_deletebtn_CSS");

			// wait for the element
			explicitWaitClickable("questionnaire_deletebtn_CSS");

			// click on the delete button
			click("questionnaire_deletebtn_CSS");

			// wait for the element
			explicitWaitClickable("questionnaire_modeldeletebtn_CSS");

			// click on the delete button of the confirmation popup
			click("questionnaire_modeldeletebtn_CSS");

			// enter newly created questionnaire in the filter field
			type("ssc_company2_questionnairelist_filtertxt_CSS", data.get("questionnaire_building_title"));

			helper.deleteVerification("questionnaire_building_record1_XPATH", "Test Questionnaire Building Title");

		} catch (Throwable t) {

			verificationFailedMessage("The newly created questionnaire is not displayed.");
		}

		// click on the home icon from the top of the screen
		click("questionnaire_homeburgermenubtn_CSS");

		// wait for the element
		explicitWait("propertylist_title_XPATH");

		// verify the property list
		switchVerification("propertylist_title_XPATH", "Property List", "The property list is not displayed.");

	}
}
