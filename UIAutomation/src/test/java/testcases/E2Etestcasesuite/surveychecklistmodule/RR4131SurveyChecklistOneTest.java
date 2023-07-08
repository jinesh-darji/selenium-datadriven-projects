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

public class RR4131SurveyChecklistOneTest extends TestBase {

	@Test(dataProviderClass = TestUtil.class, dataProvider = "dp")
	public void rR4131SurveyChecklistOneTest(Hashtable<String, String> data) throws IOException, InterruptedException {

		execution(data, "rR4131SurveyChecklistOneTest");

		// VERIFICATION OF THE JUMP TO SURVEY/CHECKLIST BUTTON WITH SURVEY.
		title("VERIFICATION OF THE JUMP TO SURVEY/CHECKLIST BUTTON WITH SURVEY.");

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

			// enter the newly created questionnaire in the search field
			type("ssc_company2_questionnairelist_filtertxt_CSS", data.get("questionnaire_title"));

			// verification of the created questionnaire
			switchVerification("questionnaire_createdrecordauto_jumpsurvey_XPATH",
					"Test Auto Questionnaire One Jump Survey Title", "The newly questionnaire is not created.");

			// CONFIGRATION OF QUESTION
			title("CONFIGRATION OF QUESTION");

			// click on the created questionnaire
			click("questionnaire_createdrecordauto_jumpsurvey_XPATH");

			helper.configureQuestions(data);

			// enter newly created questionnaire in the filter field
			type("ssc_company2_questionnairelist_filtertxt_CSS", data.get("questionnaire_title"));

			// verify newly created questionnaire for survey
			switchVerification("questionnaire_createdrecordauto_jumpsurvey_XPATH",
					"Test Auto Questionnaire One Jump Survey Title",
					"The Test Auto Questionnaire One Jump Survey Title record is not displayed in the questionnaire list.");

		} catch (Throwable t) {
			verificationFailed();
		}

		// click on the home menu burger button
		click("questionnaire_homeburgermenubtn_CSS");

		// wait for the element
		explicitWait("propertylist_title_XPATH");

		// verify the property list
		switchVerification("propertylist_title_XPATH", "Property List", "The property list is not displayed.");

		// CREATE THE TASK WITH VALID DETAILS
		title("CREATE THE TASK WITH VALID DETAILS");

		try {

			// click on the task icon of the respective property
			click("taskicon_CSS");

			// click on the add task button
			click("task_addtaskbtn_CSS");

			// enter the data in the title field
			type("task_addtask_titletxt_CSS", data.get("task_title"));

			// enter the details in the location field
			type("task_locationtxt_CSS", data.get("task_location"));

			// click on the assign to field
			click("task_assigntotxt_CSS");

			// Enter data in the find user field
			type("questionnaire_createtask_findusertxt_CSS", data.get("task_find_user"));

			// select the user name from the user list
			click("questionnaire_createtask_selectusertxt_XPATH");

			// click on the assign to field
			click("task_assigntotxt_CSS");

			// scroll down till task template
			scrollByPixel(500);

			// select the priority
			select("task_addtask_prioritydd_CSS", data.get("priority"));

			// scroll down till task template
			scrollByPixel(500);

			// select the module
			select("task_addtask_moduledd_CSS", data.get("module"));

			// scroll down till task template
			scrollByPixel(-600);

			// click on the survey/checklist tab
			driver.findElement(By.xpath("//a[text()='Survey/Inspection']")).click();

			// scroll down till task template
			scrollByPixel(300);

			// click on the survey radio button of the type
			click("survey_task_surveychecklisttab_surveytype_CSS");

			// wait for the element
			explicitWait("survey_task_surveychecklisttab_surveytype_questionnaire_CSS");

			// select the questionnaire from the dropdown
			select("survey_task_surveychecklisttab_surveytype_questionnaire_CSS", data.get("questionnaire_title"));

			// wait for the element
			explicitWaitClickable("survey_task_savebtn_CSS");

			// click on the save button
			click("survey_task_savebtn_CSS");

			// wait for the element
			explicitWaitClickable("closetoastmsg_CSS");

			// click on the toaster close button
			click("closetoastmsg_CSS");

		} catch (Throwable t) {
			verificationFailed();
		}

		// click on the home menu burger button
		click("questionnaire_homeburgermenubtn_hide_CSS");

		// wait for the element
		explicitWait("propertylist_title_XPATH");

		// verify the property list
		switchVerification("propertylist_title_XPATH", "Property List", "The property list is not displayed.");

		// UPDATE THE PERMISSION FOR THE PROPERTY MANAGER
		title("UPDATE THE PERMISSION FOR THE PROPERTY MANAGER");

		try {
			// wait for the element
			explicitWaitClickable("questionnaire_settingicon_userupdate_CSS");

			// click on the settings icon from the top of the screen
			click("questionnaire_settingicon_userupdate_CSS");

			// wait for the element
			explicitWaitClickable("questionnaire_administrationoption_XPATH");

			// click on the Administration option from the side menu
			click("questionnaire_administrationoption_XPATH");

			// click on the Security tab
			click("administration_securitytxt_XPATH");

			// click on the Security Settings option
			click("questionnaire_securotysettingsoption_XPATH");

			// enter the permission name in the search field
			type("questionnaire_securotysettingsoption_jumptosecuritychecklisttxt_CSS", data.get("search_permission"));

			// click on the searched permission
			click("questionnaire_securotysettingsoption_jumptosecuritychecklistpermission_CSS");

			// click on the system role field
			click("questionnaire_jumptosecuritychecklistpermission_systemrole_CSS");

			// click on the none button
			click("questionnaire_jumptosecuritychecklistpermission_systemrole_nonebtn_CSS");

			// enter the role name in the search field
			type("task_filter_findtask_CSS", data.get("role_search"));

			// click on the searched result
			click("questionnaire_checklist_roletoaccessinstance3_XPATH");

			// click on the system role field
			click("questionnaire_jumptosecuritychecklistpermission_systemrole_CSS");

			// click on the save button
			click("securitysettings_accesssurveychecklist_CSS");

			// wait for the element
			explicitWaitClickable("closetoastmsg_CSS");

			// click on the toaster close button
			click("closetoastmsg_CSS");

		} catch (Throwable t) {
			verificationFailed();
		}

		// LOGOUT FROM ADMIN USER AND LOGIN WITH PROPERTY MANAGER USER
		title("LOGOUT FROM ADMIN USER AND LOGIN WITH PROPERTY MANAGER USER");

		try {
			// wait for the element
			explicitWaitClickable("questionnaire_settingicon_userupdate_CSS");

			// click on the settings icon from the top of the screen
			click("questionnaire_settingicon_userupdate_CSS");

			// wait for the element
			explicitWaitClickable("sidemenu_logout_CSS");

			// click on the logout option from the side menu
			click("sidemenu_logout_CSS");

			helper.loginAndUpdateSystemCompany(data, "username", "password", "system_company_1");

			// VERIFY JUMP TO SURVEY/CHECKLIST BUTTON IS WORKING CORRECTLY OR NOT
			title("VERIFY JUMP TO SURVEY/CHECKLIST BUTTON IS WORKING CORRECTLY OR NOT");

			try {

				// click on the task icon of the respective property
				click("taskicon_CSS");

				// click on the clear button
				click("task_createdtask_clearbtn_XPATH");

				// enter the data in the search field
				type("survey_task_searchfield_CSS", data.get("task_title"));

				// click on the search button
				click("task_createdtask_searchbtn_XPATH");

				// verify the task is displayed or not
				switchVerification("task_createdtask_jumpsurvey_XPATH", "Test Task One Jump Survey Title",
						"The Test Task One Jump Survey Title is not displayed.");

				// click on the searched task
				click("task_createdtask_jumpsurvey_XPATH");

				// wait for the element
				Thread.sleep(5000);

				// click on the survey/checklist tab
				driver.findElement(By.xpath("//a[text()='Survey/Inspection']")).click();

				// scroll down the screen
				scrollByPixel(200);

				// wait for the 5 seconds
				Thread.sleep(5000);

				// click on the jump to survey/checklist button
				click("task_createdtask_jumptosurveychecklistbtn_CSS");

				// wait for the element
				Thread.sleep(10000);

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

			// VERIFY THE INPROGRESS TASK IS DISPLAYED OR NOT
			title("VERIFY THE INPROGRESS TASK IS DISPLAYED OR NOT");

			try {
				// click on the task icon of the respective property
				click("taskicon_CSS");

				// click on the clear button
				click("task_createdtask_clearbtn_XPATH");

				// enter the data in the search field
				type("survey_task_searchfield_CSS", data.get("task_title"));

				// click on the search button
				click("task_createdtask_searchbtn_XPATH");

				String str1 = driver.findElement(By.xpath(OR.getProperty("task_inprogress_filtered_XPATH"))).getText();

				if (str1.equals("In Progress")) {
					successMessage("The inprogress task is verified successfully.");
				} else {
					verificationFailed();
				}
			} catch (Throwable t) {
				verificationFailed();
			}

			// click on the Home button
			click("questionnaire_homeburgermenubtn_hide_CSS");

			// wait for the element
			explicitWait("propertylist_title_XPATH");

			// verify the property list
			switchVerification("propertylist_title_XPATH", "Property List", "The property list is not displayed.");

			// LOGOUT FROM PROPERTY MANAGER USER AND LOGIN WITH ADMIN USER
			title("LOGOUT FROM PROPERTY MANAGER USER AND LOGIN WITH ADMIN USER");

			// wait for the element
			Thread.sleep(5000);

			// click on the settings icon from the top of the screen
			click("questionnaire_settingicon_CSS");

			// wait for the element
			explicitWaitClickable("sidemenu_logout_CSS");

			// click on the logout option from the side menu
			click("sidemenu_logout_CSS");

			// login with valid credentials
			helper.loginAndUpdateSystemCompany(data, "username_1", "password_1", "system_company_1");

		} catch (Throwable t) {
			helper.questionnaireNotDisplayLogout(data);
		}

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
			click("questionnaire_createdrecordauto_jumpsurvey_XPATH");

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