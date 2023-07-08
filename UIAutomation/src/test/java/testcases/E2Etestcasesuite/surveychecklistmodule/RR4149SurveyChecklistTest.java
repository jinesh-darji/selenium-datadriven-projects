package testcases.E2Etestcasesuite.surveychecklistmodule;

import java.io.IOException;
import java.util.Hashtable;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.SkipException;
import org.testng.annotations.Test;

import com.relevantcodes.extentreports.LogStatus;

import base.Helper;
import base.TestBase;
import utilities.TestUtil;

public class RR4149SurveyChecklistTest extends TestBase {

	@Test(dataProviderClass = TestUtil.class, dataProvider = "dp")
	public void rR4149SurveyChecklistTest(Hashtable<String, String> data) throws IOException, InterruptedException {

		execution(data, "rR4149SurveyChecklistTest");

		// INSPECTIONS/CHECKLIST DASHBOARD - LIST OF CHECKLISTS DISPLAYED.
		title("INSPECTIONS/CHECKLIST DASHBOARD - LIST OF CHECKLISTS DISPLAYED.");

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
			type("questionnaire_languagetitle_CSS", data.get("questionnaire_checklist_title"));

			// select the model
			select("questionnaire_modeldd_CSS", data.get("model"));

			// select the frequency
			select("questionnaire_frequencydd_CSS", data.get("frequency"));

			// enter frequency interval
			type("questionnaire_frequencyintervaltxt_CSS", "1");

			// select the month
			select("questionnaire_monthtxt_CSS", data.get("month"));

			// enter the description
			type("questionnaire_descriptiontxt_CSS", data.get("description"));

			// select the classic option from the default view drop down
			select("questionnaire_checklist_defaultview_CSS", data.get("default_view"));

			// scroll down the screen
			scrollByPixel(400);

			// click on the User to Access Instance field
			click("questionnaire_checklist_usertoaccessinstance1_CSS");

			// enter the user name in the search field
			type("questionnaire_checklist_usertoaccessinstance2_CSS", data.get("checklist_search_1"));

			// click on the user name from the searched result
			click("questionnaire_checklist_usertoaccessinstance_dashboard_XPATH");

			// click on the User to Access Instance field
			click("questionnaire_checklist_usertoaccessinstance1_CSS");

			// scroll down to the save button
			scrollBottom();

			// click on the save button
			click("questionnaire_savebtn_BTNTEXT");

			// enter newly created questionnaire in the filter field
			type("ssc_company2_questionnairelist_filtertxt_CSS", data.get("questionnaire_checklist_title"));

			// verify newly created questionnaire for checklist
			switchVerification("questionnaire_record_checklistdashboard_XPATH",
					"Test Questionnaire Checklist Dashboard Title",
					"The Test Questionnaire Checklist Dashboard Title record is not displayed in the questionnaire list.");

			// CONFIGRATION OF QUESTION
			title("CONFIGRATION OF QUESTION");

			// click on the created questionnaire
			click("questionnaire_record_checklistdashboard_XPATH");

			helper.configureQuestions(data);

			// enter newly created questionnaire in the filter field
			type("ssc_company2_questionnairelist_filtertxt_CSS", data.get("questionnaire_checklist_title"));

			// verify newly created questionnaire for checklist
			switchVerification("questionnaire_record_checklistdashboard_XPATH",
					"Test Questionnaire Checklist Dashboard Title",
					"The Test Questionnaire Checklist Dashboard Title record is not displayed in the questionnaire list.");

		} catch (Throwable t) {
			verificationFailed();
		}

		// click on the Home Icon from the top of the screen
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

			// click on the burger menu
			click("menubtn_CSS");

			// wait for the element
			explicitWaitClickable("surveyoption_XPATH");

			// click on the checklist/inspection option from side menu
			click("checklist_sidemenu_XPATH");

			// select the property level from the dropdown
			select("survey_leveldropdown_CSS", data.get("property_leveldropdown"));

			// click on the new checklist button
			click("checklist_newchecklistbtn_CSS");

			// wait for the element
			explicitWait("checklist_addchecklist_checklisttypedd_CSS");

			// collect all options of the dropdown
			Select dropdown1 = new Select(
					driver.findElement(By.cssSelector(OR.getProperty("checklist_addchecklist_checklisttypedd_CSS"))));

			// Get all options
			List<WebElement> dd1 = dropdown1.getOptions();

			// Loop to print one by one
			for (int j = 0; j < dd1.size(); j++) {
				String checklist1 = dd1.get(j).getText();
				try {
					if (checklist1.equals("Test Questionnaire Checklist Dashboard Title")) {
						successMessage("The checklists are verified successfully.");
					}
				} catch (Throwable t) {
					verificationFailed();
				}
			}

			// select the questionnaire option from the checklist type dropdown
			select("checklist_addchecklist_checklisttypedd_CSS", data.get("questionnaire_checklist_title"));

			// enter data in the checklist title field
			type("checklist_addchecklist_titletxt_CSS", data.get("checklist_property_title"));

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

		// OPEN THE INSPECTION/CHECKLIST DASHBOARD
		title("OPEN THE INSPECTION/CHECKLIST DASHBOARD");

		try {
			// select the Inspections/Checklists option from the dashboard dropdown
			select("ssc_environmental_dashboarddd_CSS", data.get("inspection_checklist_dd"));

			// filter created checklist
			type("envreports_propertylist_filtertxt_CSS", data.get("questionnaire_checklist_title"));

			// verify newly created questionnaire for checklist
			switchVerification("questionnaire_record_checklistdashboard_XPATH",
					"Test Questionnaire Checklist Dashboard Title",
					"The Test Questionnaire Checklist Dashboard Title record is not displayed in the questionnaire list.");

			// verify the Open Inspections count of super user account
			switchVerification("checklist_openinspections_CSS", "1",
					"The Open Inspections count is displayed incorrect");

			// verify the Open Tasks count of super user account
			switchVerification("checklist_opentasks_CSS", "0", "The Open Tasks count is displayed incorrect");

		} catch (Throwable t) {
			verificationFailed();
		}

		// LOGOUT FROM ADMIN USER AND LOGIN WITH CONTRACTOR USER
		title("LOGOUT FROM ADMIN USER AND LOGIN WITH CONTRACTOR USER");

		try {
			// wait for the element
			explicitWaitClickable("questionnaire_settingicon_CSS");

			// click on the settings icon from the top of the screen
			click("questionnaire_settingicon_CSS");

			// wait for the element
			explicitWaitClickable("sidemenu_logout_CSS");

			// click on the logout option from the side menu
			click("sidemenu_logout_CSS");

			helper.loginAndUpdateSystemCompany(data, "username", "password", "system_company_1");

			// VERIFY THE INSPECTION/CHECKLIST DASHBOARD COUNT
			title("VERIFY THE INSPECTION/CHECKLIST DASHBOARD COUNT");

			// select the Inspections/Checklists option from the dashboard dropdown
			select("ssc_environmental_dashboarddd_CSS", data.get("inspection_checklist_dd"));

			// filter created checklist
			type("envreports_propertylist_filtertxt_CSS", data.get("questionnaire_checklist_title"));

			try {
				String str1 = driver.findElement(By.xpath("//td[@id='questionnaire-name-0']")).getText();

				if (str1.equals("Test Questionnaire Checklist Dashboard Title")) {
					verificationFailedMessage("The respective questionnaire is displayed without access.");
				}
			} catch (Throwable t) {
				successMessage("The " + data.get("questionnaire_checklist_title") + " is not displayed as expected.");
			}

			// LOGOUT FROM CONTRACTOR USER AND LOGIN WITH ADMIN USER
			title("LOGOUT FROM CONTRACTOR USER AND LOGIN WITH ADMIN USER");

			// wait for the element
			Thread.sleep(5000);

			// click on the settings icon from the top of the screen
			click("questionnaire_settingicon_userupdate_CSS");

			// wait for the element
			explicitWaitClickable("sidemenu_logout_CSS");

			// click on the logout option from the side menu
			click("sidemenu_logout_CSS");

			// login with valid credentials
			helper.loginAndUpdateSystemCompany(data, "username_1", "password_1", "system_company_1");

		} catch (Throwable t) {
			helper.questionnaireNotDisplayLogout(data);
		}

		// DELETE THE NEWLY CREATED INSTANCE
		title("DELETE THE NEWLY CREATED INSTANCE");

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

			// enter the newly created instance name in the filter field
			type("checklist_filtertxt_CSS", data.get("checklist_property_title"));

			// click on the action icon
			click("checklist_actionicon_CSS");

			// click on the delete option
			click("checklist_deleteoption_CSS");

			// wait for the element
			explicitWaitClickable("checklist_deletebtn_CSS");

			// click on the delete button of the confirmation popup model.
			click("checklist_deletebtn_CSS");

			// clear the data from the filter field.
			type("checklist_filtertxt_CSS", data.get("checklist_property_title"));

			try {
				String str2 = driver.findElement(By.xpath("//td[@id='questionnaire-name-0']")).getText();

				if (str2.equals("Test Questionnaire Checklist Dashboard Title")) {

					verificationFailedMessage("The respective questionnaire is is displayed without access.");
				}
			} catch (Throwable t) {
				successMessage("The " + data.get("questionnaire_checklist_title")
						+ " is not displayed as per the expected result.");
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
			type("ssc_company2_questionnairelist_filtertxt_CSS", data.get("questionnaire_checklist_title"));

			// verify newly created questionnaire for checklist
			switchVerification("questionnaire_record_checklistdashboard_XPATH",
					"Test Questionnaire Checklist Dashboard Title",
					"The Test Questionnaire Checklist Dashboard Title record is not displayed in the questionnaire list.");

			// click on the created questionnaire
			click("questionnaire_record_checklistdashboard_XPATH");

			// scroll till the delete button
			scrollTillElement("questionnaire_warrantybtn_CSS");

			// click on the delete button
			click("questionnaire_deletebtn_CSS");

			// click on the delete button of the confirmation popup
			click("questionnaire_modeldeletebtn_CSS");

			// enter newly created questionnaire in the filter field
			type("ssc_company2_questionnairelist_filtertxt_CSS", data.get("questionnaire_checklist_title"));

			helper.deleteVerification("questionnaire_record_checklistdashboard_XPATH",
					"Test Questionnaire Checklist Dashboard Title");

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