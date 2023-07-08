package testcases.E2Etestcasesuite.surveychecklistmodule;

import java.io.IOException;
import java.util.Hashtable;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.SkipException;
import org.testng.annotations.Test;

import com.relevantcodes.extentreports.LogStatus;

import base.Helper;
import base.TestBase;
import utilities.TestUtil;

public class RR3943SurveyChecklistTest extends TestBase {

	@Test(dataProviderClass = TestUtil.class, dataProvider = "dp")
	public void rR3943SurveyChecklistTest(Hashtable<String, String> data) throws IOException, InterruptedException {

		execution(data, "rR3943SurveyChecklistTest");

		// 1. A PDF REPORT SHOULD NOT BE GENERATED IF DOCUMENT/REPORT IS NOT CONFIGURED
		// 2. MAKE SURE THE PERCENTAGE OF COMPLETNESS IS CORRECT
		title("A PDF REPORT SHOULD NOT BE GENERATED IF DOCUMENT/REPORT IS NOT CONFIGURED // MAKE SURE THE PERCENTAGE OF COMPLETNESS IS CORRECT.");

		Helper helper = new Helper();

		// refresh the page
		driver.navigate().refresh();
		Thread.sleep(5000);
		driver.navigate().refresh();

		// ADD NEW QUESTIONNIRE FOR CHECKLIST
		title("ADD NEW QUESTIONNIRE FOR CHECKLIST");

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

			// Select the Inspection / Checklist of the questionnaire
			click("questionnaire_type_inspectionbtn_CSS");

			// Select the level of the questionnaire
			click("questionnaire_level_propertybtn_CSS");

			// enter the group title
			type("questionnaire_grouptitletxt_CSS", data.get("group_title"));

			// enter the questionnaire title
			type("questionnaire_questionnairetitletxt_CSS", data.get("questionnaire_title"));

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
			type("ssc_company2_questionnairelist_filtertxt_CSS", data.get("questionnaire_title"));

			// verify newly created questionnaire for checklist
			switchVerification("checklist_pdfreportchecklist_1_XPATH", "Test Questionnaire PDF Report Title",
					"The Test Questionnaire PDF Report Title record is not displayed in the questionnaire list.");

			// CONFIGRATION OF QUESTION
			title("CONFIGRATION OF QUESTION");

			// click on the created questionnaire
			click("checklist_pdfreportchecklist_1_XPATH");

			helper.configureQuestions(data);

			// enter newly created questionnaire in the filter field
			type("ssc_company2_questionnairelist_filtertxt_CSS", data.get("questionnaire_title"));

			// verify newly created questionnaire for checklist
			switchVerification("checklist_pdfreportchecklist_1_XPATH", "Test Questionnaire PDF Report Title",
					"The Test Questionnaire PDF Report Title record is not displayed in the questionnaire list.");

		} catch (Throwable t) {
			verificationFailed();
		}

		// click on the home menu burger button
		click("questionnaire_homeburgermenubtn_CSS");

		// wait for the element
		explicitWait("propertylist_title_XPATH");

		// verify the property list
		switchVerification("propertylist_title_XPATH", "Property List", "The property list is not displayed.");

		// VERIFY THE CHECKLIST IN THE PROPERTY LEVEL
		title("VERIFY THE CHECKLIST IN THE PROPERTY LEVEL");

		try {
			// click on the environmental icon from the property list page
			click("environmentalicon_CSS");

			// wait for the element
			Thread.sleep(5000);

			// click on the burger menu
			click("menubtn_CSS");

			// wait for the element
			Thread.sleep(5000);

			// click on the inspection/checklist option from side menu
			click("checklist_sidemenu_XPATH");

			// click on the new checklist button
			click("checklist_newchecklistbtn_CSS");

			// wait for the element
			explicitWait("checklist_addchecklist_checklisttypedd_CSS");

			// select the questionnaire option from the checklist type dropdown
			select("checklist_addchecklist_checklisttypedd_CSS", data.get("checklist_type"));

			// enter data in the checklist title field
			type("checklist_addchecklist_titletxt_CSS", data.get("checklist_title"));

			// click on the save button
			click("checklist_addchecklist_savebtn_CSS");

			// click on the yes checkbox
			click("checklist_category_1_question_1_yesbtn_CSS");

			// enter value in the text field
			type("checklist_category_1_question_1_option_1_textfield_CSS", data.get("checklist_textfield_question"));

			// click on the no checkbox of the question 2 of category 1
			click("survey_noanswerbtn_2_CSS");

			// click on the category 1 question 1 label
			click("checklist_category_1_question_1_XPATH");

			// wait for element
			explicitWaitClickable("survey_imported_questionnaire_100_XPATH");

			// verify 100% survey complete or not
			switchVerification("survey_imported_questionnaire_100_XPATH", "100% complete",
					"The survey is not complited yet.");

			// click on the exit button
			click("checklist_questionnaire_exitbtn_CSS");

			// APPROVE CHECKLIST
			title("APPROVE CHECKLIST");

			// enter the newly created instance name in the filter field
			type("checklist_filtertxt_CSS", data.get("checklist_title"));

			// click on the action icon of the checklist
			click("checklist_actionicon_CSS");

			// click on the approve option from the action options list
			click("checklist_approveoption_CSS");

			// click on the approve button of the confirmation pop up
			click("checklist_modelaprovebtn_CSS");

			// select the approve option from the status dropdown
			select("checklist_statusdd_CSS", data.get("checklist_approved"));

			// enter the newly created instance name in the filter field
			type("checklist_filtertxt_CSS", data.get("checklist_title"));

			// verify the checklist is approved or not
			switchVerification("checklist_approved_pdfreportinstant_XPATH", "Test Checklist PDF Report Title",
					"The Test Checklist PDF Report Title is not displayed.");

		} catch (Throwable t) {
			verificationFailed();
		}

		// click on the home option from the side menu
		click("questionnaire_homeburgermenubtn_hide_CSS");

		// wait for the element
		explicitWait("propertylist_title_XPATH");

		// verify the property list
		switchVerification("propertylist_title_XPATH", "Property List", "The property list is not displayed.");

		// VERIFY DOCUMENTS/REPORTS GENERATED OR NOT
		title("VERIFY DOCUMENTS/REPORTS GENERATED OR NOT");

		try {
			// click on the environmental icon from the property list page
			click("environmentalicon_CSS");

			// wait for the element
			Thread.sleep(5000);

			// click on the burger menu
			click("menubtn_CSS");

			// wait for the element
			Thread.sleep(5000);

			// click on the Environmental Reports option
			click("envreportoption_XPATH");

			// enter the data in the filter field
			type("checklist_filtertxt_CSS", data.get("questionnaire_title"));

			// verify the environmental report is generated or not
			try {
				String str1 = driver.findElement(By.xpath(OR.getProperty("checklist_filteredpdfreport_XPATH")))
						.getText();

				if (str1.equals("(December-2020) Test Questionnaire PDF Report Title")) {
					verificationFailedMessage("The environmental PDF report is displayed");
				}
			} catch (Throwable t) {
				successMessage("The environmental PDF report is not displayed successfully.");
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
			click("checklist_pdfreportchecklist_1_XPATH");

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