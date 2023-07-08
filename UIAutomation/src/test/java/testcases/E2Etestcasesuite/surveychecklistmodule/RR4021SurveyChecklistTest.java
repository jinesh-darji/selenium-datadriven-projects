package testcases.E2Etestcasesuite.surveychecklistmodule;

import java.io.IOException;
import java.util.Hashtable;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.testng.Reporter;
import org.testng.SkipException;
import org.testng.annotations.Test;

import com.relevantcodes.extentreports.LogStatus;

import base.Helper;
import base.TestBase;
import utilities.TestUtil;

public class RR4021SurveyChecklistTest extends TestBase {

	@Test(dataProviderClass = TestUtil.class, dataProvider = "dp")
	public void rR4021SurveyChecklistTest(Hashtable<String, String> data) throws IOException, InterruptedException {

		execution(data, "rR4021SurveyChecklistTest");

		// TASKS/SURVEY ASSOCIATION - JUMP SHOULD LAUNCH SURVEY/CHECKLIST IN CLASSIC
		title("TASKS/SURVEY ASSOCIATION - JUMP SHOULD LAUNCH SURVEY/CHECKLIST IN CLASSIC");

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
			verifyTrue("questionnaire_createdrecordauto_jumpsurveychecklist_XPATH",
					"The newly questionnaire is not created.");

			// CONFIGRATION OF QUESTION
			title("CONFIGRATION OF QUESTION");

			// click on the created questionnaire
			click("questionnaire_createdrecordauto_jumpsurveychecklist_XPATH");

			helper.configureQuestionAutoTaskDependancy(data);

			// enter newly created questionnaire in the filter field
			type("ssc_company2_questionnairelist_filtertxt_CSS", data.get("questionnaire_title"));

			// verify newly created questionnaire for survey
			switchVerification("questionnaire_createdrecordauto_jumpsurveychecklist_XPATH",
					"Test Auto Questionnaire Jump Survey/Checklist Title",
					"The Test Auto Questionnaire Jump Survey/Checklist Title record is not displayed in the questionnaire list.");

		} catch (Throwable t) {
			verificationFailed();
		}

		// click on the home menu burger button
		click("questionnaire_homeburgermenubtn_CSS");

		// wait for the element
		explicitWait("propertylist_title_XPATH");

		// verify the property list
		switchVerification("propertylist_title_XPATH", "Property List", "The property list is not displayed.");

		// VERIFY QUESTONNAIRE IN SURVEY MODULE
		title("VERIFY QUESTONNAIRE IN SURVEY MODULE");

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

			// click on the YES checkbox of question 1
			click("survey_yesanswerbtn_1_CSS");

			// click on the NO checkbox of question 2
			click("survey_noanswerbtn_2_CSS");

		} catch (Throwable t) {
			verificationFailed();
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
			switchVerification("task_createdtask_jumpsurveychecklist_XPATH", "Test Task Jump Survey/Checklist Title",
					"The Test Task Jump Survey/Checklist Title is not displayed.");

			// VERIFY JUMP SURVEY/CHECKLIST BUTTON SHOULD LAUNCH SURVEY/CHECKLIST IN CLASSIC
			// MODE
			title("VERIFY JUMP SURVEY/CHECKLIST BUTTON SHOULD LAUNCH SURVEY/CHECKLIST IN CLASSIC MODE");

			// click on the auto generated task
			click("task_createdtask_jumpsurveychecklist_XPATH");

			// wait for the element
			Thread.sleep(5000);

			// click on the survey/checklist tab
			driver.findElement(By.xpath("//a[text()='Survey/Inspection']")).click();

			// scroll down the screen
			scrollByPixel(600);

			// click on the survey button
			click("survey_task_surveybtn_CSS");

			// select the newly created questionnaire from the dropdown
			select("survey_task_questionnairedd_CSS", data.get("questionnaire_title"));

			// click on the update button
			click("survey_task_updatebtn_CSS");

			// wait for the element
			explicitWaitClickable("closetoastmsg_CSS");

			// click on the toaster close button
			click("closetoastmsg_CSS");

			// wait for the element
			Thread.sleep(5000);

			// click on the clear button
			click("task_createdtask_clearbtn_XPATH");

			// enter the data in the search field
			type("task_filter_CSS", data.get("task_title"));

			// click on the search button
			click("task_createdtask_searchbtn_XPATH");

			// verify the auto generated task is displayed or not
			switchVerification("task_createdtask_jumpsurveychecklist_XPATH", "Test Task Jump Survey/Checklist Title",
					"The Test Task Jump Survey/Checklist Title is not displayed.");

			// click on the auto generated task
			click("task_createdtask_jumpsurveychecklist_XPATH");

			// click on the survey/checklist tab
			driver.findElement(By.xpath("//a[text()='Survey/Inspection']")).click();

			// scroll down the screen
			scrollByPixel(600);

			// click on the jump to survey/checklist button
			click("survey_task_jumptosurveychecklistbtn_CSS");

			// verify switch to wizard mode button is displayed or not
			verifyTrue("survey_task_wizardicon3_CSS", "The switch to wizard mode button is not displayed.");

		} catch (Throwable t) {
			verificationFailed();
		}

		// click on the home icon from the top of the screen
		click("questionnaire_homeburgermenubtn_hide_CSS");

		// wait for the element
		explicitWait("propertylist_title_XPATH");

		// verify the property list
		switchVerification("propertylist_title_XPATH", "Property List", "The property list is not displayed.");

		// DELETE THE AUTO GENERATED TASK
		title("DELETE THE AUTO GENERATED TASK");

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
			switchVerification("task_createdtask_jumpsurveychecklist_XPATH", "Test Task Jump Survey/Checklist Title",
					"The Test Task Jump Survey/Checklist Title is not displayed.");

			// click on the action icon
			String actionIcon = "//p[text()='" + data.get("task_title")
					+ "']//parent::td//following-sibling::td[@class='text-center pointer']//i[@data-toggle='dropdown']";
			driver.findElement(By.xpath(actionIcon)).click();

			// click on the delete option
			String deleteOption = "//p[text()='" + data.get("task_title")
					+ "']//parent::td//following-sibling::td[@class='text-center pointer']//div[@class='dropdown open']//li[@ng-click='deleteSelectedTask(task.id, false);']";
			driver.findElement(By.xpath(deleteOption)).click();

			// wait for the element
			explicitWaitClickable("closetoastmsg_CSS");

			// click on the toaster close button
			click("closetoastmsg_CSS");

		} catch (Throwable t) {
			verificationFailed();
		}

		// click on the home icon from the top of the screen
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
			click("questionnaire_createdrecordauto_jumpsurveychecklist_XPATH");

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