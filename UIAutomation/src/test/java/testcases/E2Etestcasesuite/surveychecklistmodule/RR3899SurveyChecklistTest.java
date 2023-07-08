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

public class RR3899SurveyChecklistTest extends TestBase {

	@Test(dataProviderClass = TestUtil.class, dataProvider = "dp")
	public void rR3899SurveyChecklistTest(Hashtable<String, String> data) throws IOException, InterruptedException {

		execution(data, "rR3899SurveyChecklistTest");

		// CREATE THE SURVEY AND CHECKLIST ON BUILDING LEVEL (IN WHICH BUILDING IS NOT
		// AVAILABLE IN RESPECTIVE PROPERTY) AND VERIFY THE BUILDING LEVEL SURVEY IN THE
		// PROPERTY LEVEL
		title("CREATE THE SURVEY AND CHECKLIST ON BUILDING LEVEL (IN WHICH BUILDING IS NOT AVAILABLE IN RESPECTIVE PROPERTY) AND VERIFY THE BUILDING LEVEL SURVEY IN THE PROPERTY LEVEL");

		Helper helper = new Helper();

		// refresh the page
		driver.navigate().refresh();
		Thread.sleep(5000);
		driver.navigate().refresh();

		// ADD NEW QUESTIONNIRE AT BUILDING LEVEL
		title("ADD NEW QUESTIONNIRE AT BUILDING LEVEL");

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

			// enter frequency interval
			type("questionnaire_frequencyintervaltxt_CSS", "1");

			// enter the year
			type("questionnaire_yeartxt_CSS", "2020");

			// select the month
			select("questionnaire_monthtxt_CSS", data.get("month"));

			// enter the description
			type("questionnaire_descriptiontxt_CSS", data.get("description"));

			// select the classic option from the default view drop down
			select("questionnaire_checklist_defaultview_CSS", data.get("default_view"));

			// click on the save button
			click("questionnaire_savebtn_BTNTEXT");

			// enter newly created questionnaire in the filter field
			type("ssc_company2_questionnairelist_filtertxt_CSS", data.get("questionnaire_building_title"));

			// verify newly created questionnaire for survey
			switchVerification("questionnaire_buildingonly_record1_XPATH", "Test Questionnaire Building Only Title",
					"The Test Questionnaire Building Title record is not displayed in the questionnaire list.");

			// CONFIGRATION OF QUESTION
			title("CONFIGRATION OF QUESTION");

			// click on the created questionnaire
			click("questionnaire_buildingonly_record1_XPATH");

			helper.configureQuestions(data);

			// wait for the element
			explicitWait("ssc_company2_questionnairelist_filtertxt_CSS");

			// enter newly created questionnaire in the filter field
			type("ssc_company2_questionnairelist_filtertxt_CSS", data.get("questionnaire_building_title"));

			// verify newly created questionnaire for survey
			switchVerification("questionnaire_buildingonly_record1_XPATH", "Test Questionnaire Building Only Title",
					"The Test Questionnaire Building Only Title record is not displayed in the questionnaire list.");

		} catch (Throwable t) {
			verificationFailed();
		}

		// CREATE THE CHECKLIST IN THE BUILDING LEVELS
		title("CREATE THE CHECKLIST IN THE BUILDING LEVELS");

		try {
			// click on the new questionnaire
			click("questionnaire_newquestionnairebtn_CSS");

			// Select the Inspection / Checklist of the questionnaire
			click("questionnaire_type_inspectionbtn_CSS");

			// Select the level of the questionnaire
			click("questionnaire_level_buildingbtn_CSS");

			// enter the group title
			type("questionnaire_grouptitletxt_CSS", data.get("group_title"));

			// enter the questionnaire title
			type("questionnaire_languagetitle_CSS", data.get("questionnaire_building_checklist_title"));

			// select the model
			select("questionnaire_modeldd_CSS", data.get("model"));

			// scroll down the screen
			scrollByPixel(600);

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
			type("ssc_company2_questionnairelist_filtertxt_CSS", data.get("questionnaire_building_checklist_title"));

			// verify newly created questionnaire for checklist
			switchVerification("questionnaire_record4_XPATH", "Test Questionnaire Building Checklist Only Title",
					"The Test Questionnaire Property Checklist Only Title record is not displayed in the questionnaire list.");

			// CONFIGRATION OF QUESTION
			title("CONFIGRATION OF QUESTION");

			// click on the created questionnaire
			click("questionnaire_record4_XPATH");

			helper.configureQuestions(data);

			// enter newly created questionnaire in the filter field
			type("ssc_company2_questionnairelist_filtertxt_CSS", data.get("questionnaire_building_checklist_title"));

			// verify newly created questionnaire for checklist
			switchVerification("questionnaire_record4_XPATH", "Test Questionnaire Building Checklist Only Title",
					"The Test Checklist Questionnaire Only Title record is not displayed in the questionnaire list.");

		} catch (Throwable t) {
			verificationFailed();
		}

		// click on the home icon from the top of the screen
		click("questionnaire_homeburgermenubtn_CSS");

		// wait for the element
		explicitWait("propertylist_title_XPATH");

		// verify the property list
		switchVerification("propertylist_title_XPATH", "Property List", "The property list is not displayed.");

		// VERIFY THE SURVEY IN THE PROPERTY LEVEL
		title("VERIFY THE SURVEY IN THE PROPERTY LEVEL");

		try {

			// wait for the element
			Thread.sleep(5000);

			// search the correct property to perform the survey and checklist
			type("ssc_company2_propertylist_filtertxt_CSS", data.get("property_only_name"));

			// click on the environmental icon from the property list page
			click("property_only_environmentalicon_CSS");

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
			select("survey_questionnairedd_CSS", data.get("questionnaire_building_title"));

			// verify questionnaire is selected correctly or not
			switchVerification("questionnaire_questiontitle_XPATH", "Test Category Title One",
					"The Test Category Title One is not displayed.");

			// VERIFY THE CHECKLIST IN THE PROPERTY LEVEL
			title("VERIFY THE CHECKLIST IN THE PROPERTY LEVEL");

			// wait for the element
			Thread.sleep(5000);

			// click on the side burger menu from top of the screen
			click("ssc_leftsidemenubtn_CSS");

			// wait for the element
			Thread.sleep(5000);

			// click on the checklist/inspection option from side menu
			click("checklist_sidemenu_XPATH");

			// select the property level from the dropdown
			select("survey_leveldropdown_CSS", data.get("property_leveldropdown"));

			// click on the new checklist button
			click("checklist_newchecklistbtn_CSS");

			// wait for the element
			explicitWait("checklist_addchecklist_checklisttypedd_CSS");

			// select the questionnaire option from the checklist type dropdown
			select("checklist_addchecklist_checklisttypedd_CSS", data.get("questionnaire_building_checklist_title"));

			// enter data in the checklist title field
			type("checklist_addchecklist_titletxt_CSS", data.get("checklist_building_title"));

			// click on the save button
			click("checklist_addchecklist_savebtn_CSS");

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

		// DELETE THE QUESTIONNAIRES WHICH ARE CREATED ON BUILDING LEVELS
		title("DELETE THE QUESTIONNAIRES WHICH ARE CREATED ON BUILDING LEVELS");

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

			// enter newly created questionnaire for the survey in the filter field
			type("ssc_company2_questionnairelist_filtertxt_CSS", data.get("questionnaire_building_title"));

			// click on the newly created questionnaire on the property level
			click("questionnaire_buildingonly_record1_XPATH");

			// scroll till the delete button
			scrollTillElement("questionnaire_deletebtn_CSS");

			// click on the delete button
			click("questionnaire_deletebtn_CSS");

			// click on the delete button of the confirmation popup
			click("questionnaire_modeldeletebtn_CSS");

			// verify questionnaire is deleted or not
			switchVerification("questionnaire_questionnaireadminlbl_XPATH", "Questionnaire Administration",
					"The Questionnaire Administration label is not displayed.");

			// enter newly created questionnaire on property level in the filter field
			type("ssc_company2_questionnairelist_filtertxt_CSS", data.get("questionnaire_building_checklist_title"));

			// click on the newly created questionnaire on the property level
			click("questionnaire_record4_XPATH");

			// scroll till the delete button
			scrollTillElement("questionnaire_deletebtn_CSS");

			// click on the delete button
			click("questionnaire_deletebtn_CSS");

			// click on the delete button of the confirmation popup
			click("questionnaire_modeldeletebtn_CSS");

			// verify questionnaire is deleted or not
			switchVerification("questionnaire_questionnaireadminlbl_XPATH", "Questionnaire Administration",
					"The Questionnaire Administration label is not displayed.");

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