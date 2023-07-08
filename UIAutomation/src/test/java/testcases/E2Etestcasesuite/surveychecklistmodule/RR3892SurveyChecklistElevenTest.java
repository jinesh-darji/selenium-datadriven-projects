package testcases.E2Etestcasesuite.surveychecklistmodule;

import java.io.IOException;
import java.util.Hashtable;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.SkipException;
import org.testng.annotations.Test;

import com.relevantcodes.extentreports.LogStatus;

import base.Helper;
import base.TestBase;
import utilities.TestUtil;

public class RR3892SurveyChecklistElevenTest extends TestBase {

	@Test(dataProviderClass = TestUtil.class, dataProvider = "dp")
	public void rR3892SurveyChecklistElevenTest(Hashtable<String, String> data)
			throws IOException, InterruptedException {

		execution(data, "rR3892SurveyChecklistElevenTest");

		// AS A PROPERTY MANAGER: TASKS ASSOCIATED WITH THE DEPENDENT QUESTION SHOULD BE
		// DELETED WHEN ITS PARENT QUESTION IS SWITCHED - The "Pending" task consider as
		// a Inactive task so it should Deleted successfully.
		title("AS A PROPERTY MANAGER: TASKS ASSOCIATED WITH THE DEPENDENT QUESTION SHOULD BE DELETED WHEN ITS PARENT QUESTION IS SWITCHED - The \\\"Pending\\\" task consider as a Inactive task so it should Deleted successfully.");

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
			verifyTrue("questionnaire_createdrecordauto_11_XPATH", "The newly questionnaire is not created.");

			// CONFIGRATION OF QUESTION
			title("CONFIGRATION OF QUESTION");

			// click on the created questionnaire
			click("questionnaire_createdrecordauto_11_XPATH");

			helper.configureQuestionAutoTaskDependancy(data);

			// enter newly created questionnaire in the filter field
			type("ssc_company2_questionnairelist_filtertxt_CSS", data.get("questionnaire_title"));

			// verify newly created questionnaire for survey
			switchVerification("questionnaire_createdrecordauto_11_XPATH", "Test Auto Questionnaire Eleven Title",
					"The Test Auto Questionnaire Eleven Title record is not displayed in the questionnaire list.");

		} catch (Throwable t) {
			verificationFailedMessage("The newly created questionnaire is not displayed.");

		}

		// click on the Home button
		click("questionnaire_homeburgermenubtn_CSS");

		// wait for the element
		explicitWait("propertylist_title_XPATH");

		// verify the property list
		switchVerification("propertylist_title_XPATH", "Property List", "The property list is not displayed.");

		// LOGIN WITH SITE MANAGER USER AND VERIFY QUESTONNAIRE IN SURVEY MODULE
		title("LOGIN WITH SITE MANAGER USER AND VERIFY QUESTONNAIRE IN SURVEY MODULE");

		try {
			// wait for the element
			Thread.sleep(5000);

			// click on the settings icon from the top of the screen
			click("questionnaire_settingicon_userupdate_CSS");

			// wait for the element
			explicitWaitClickable("sidemenu_logout_CSS");

			// click on the logout option from the side menu
			click("sidemenu_logout_CSS");

			// login with valid credentials\
			helper.loginAndUpdateSystemCompany(data, "username", "password", "system_company_1");

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

				// select the respective questionnaire from the dropdown
				select("survey_questionnairedd_CSS", data.get("questionnaire_title"));

				// verify questionnaire is selected correctly or not
				switchVerification("questionnaire_questiontitle_XPATH", "Test Category Title One",
						"The Test Category Title One is not displayed.");

				// click on the yes checkbox of question 1
				click("survey_yesanswerbtn_1_CSS");

				// click on the no checkbox of question 2
				click("survey_noanswerbtn_2_CSS");

				// click on the category 1 question 1 label
				click("checklist_category_1_question_1_XPATH");

			} catch (Throwable t) {
				verificationFailedMessage("The newly created questionnaire is not displayed.");

			}

			// click on the Home button
			click("questionnaire_homeburgermenubtn_hide_CSS");

			// wait for the element
			explicitWait("propertylist_title_XPATH");

			// verify the property list
			switchVerification("propertylist_title_XPATH", "Property List", "The property list is not displayed.");

			// VERIFY AUTO GENERATED TASK IS DISPLAYED OR NOT
			title("VERIFY AUTO GENERATED TASK IS DISPLAYED OR NOT");

			try {

				// click on the task icon of the respective property
				click("taskicon_CSS");

				// click on the clear button
				click("task_createdtask_clearbtn_XPATH");

				// enter the data in the search field
				type("task_filter_CSS", data.get("task_title"));

				// click on the search button
				click("task_createdtask_searchbtn_XPATH");

				// verify the auto generated task is displayed or not
				switchVerification("task_createdtask_11_XPATH", "Test Task Eleven Title",
						"The Test Task Eleven Title is not displayed.");

			} catch (Throwable t) {
				verificationFailed();
			}

			// click on the Home button
			click("questionnaire_homeburgermenubtn_hide_CSS");

			// wait for the element
			explicitWait("propertylist_title_XPATH");

			// verify the property list
			switchVerification("propertylist_title_XPATH", "Property List", "The property list is not displayed.");

			// UPDATE THE ANSWER OF THE SURVEY AND MAKE SURE TASK IS DELETED OR NOT
			title("UPDATE THE ANSWER OF THE SURVEY AND MAKE SURE TASK IS DELETED OR NOT");

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

				// select the respective questionnaire from the dropdown
				select("survey_questionnairedd_CSS", data.get("questionnaire_title"));

				// verify questionnaire is selected correctly or not
				switchVerification("questionnaire_questiontitle_XPATH", "Test Category Title One",
						"The Test Category Title One is not displayed.");

				// click on the No checkbox
				click("survey_noanswerbtn_1_CSS");

				// click on the category 1 question 1 label
				click("checklist_category_1_question_1_XPATH");

				// wait for the element
				explicitWait("survey_imported_questionnaire_100_XPATH");

				// verify 100% survey complete or not
				switchVerification("survey_imported_questionnaire_100_XPATH", "100% complete",
						"The 100% complete is not completed yet.");

			} catch (Throwable t) {

				verificationFailedMessage("The newly created questionnaire is not displayed.");

			}

			// click on the Home button
			click("questionnaire_homeburgermenubtn_hide_CSS");

			// wait for the element
			explicitWait("propertylist_title_XPATH");

			// verify the property list
			switchVerification("propertylist_title_XPATH", "Property List", "The property list is not displayed.");

			// VERIFY AUTO GENERATED TASK IS DISPLAYED OR NOT
			title("VERIFY AUTO GENERATED TASK IS DISPLAYED OR NOT");

			try {
				// click on the task icon of the respective property
				click("taskicon_CSS");

				// click on the clear button
				click("task_createdtask_clearbtn_XPATH");

				// enter the data in the search field
				type("task_filter_CSS", data.get("task_title"));

				// click on the search button
				click("task_createdtask_searchbtn_XPATH");

				// verify the pending task is displayed or not
				try {
					String str1 = driver.findElement(By.xpath(OR.getProperty("task_pending_filtered_XPATH"))).getText();
					if (str1.equals("Pending")) {

						verificationFailedMessage("The Pending task is displayed.");

					} else {

						successMessage("The Pending task is not displayed as expected.");

					}
				} catch (Throwable t) {

					successMessage("The Pending task is not displayed as expected.");

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

		// UPDATE THE QUESTIONNAIRE TITLE WITH RANDOM TEXT
		title("UPDATE THE QUESTIONNAIRE TITLE WITH RANDOM TEXT");

		try {

			// wait for the element
			Thread.sleep(5000);

			// click on the settings icon from the top of the screen
			click("questionnaire_settingicon_userupdate_CSS");

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
			click("questionnaire_createdrecordauto_11_XPATH");

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
