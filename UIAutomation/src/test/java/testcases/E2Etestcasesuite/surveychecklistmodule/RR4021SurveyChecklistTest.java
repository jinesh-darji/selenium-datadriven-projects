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

		System.out.println("TASKS/SURVEY ASSOCIATION - JUMP SHOULD LAUNCH SURVEY/CHECKLIST IN CLASSIC");
		test.log(LogStatus.INFO, "TASKS/SURVEY ASSOCIATION - JUMP SHOULD LAUNCH SURVEY/CHECKLIST IN CLASSIC");
		Reporter.log("TASKS/SURVEY ASSOCIATION - JUMP SHOULD LAUNCH SURVEY/CHECKLIST IN CLASSIC");
		log.info("TASKS/SURVEY ASSOCIATION - JUMP SHOULD LAUNCH SURVEY/CHECKLIST IN CLASSIC");

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

			// enter the newly created questionnaire in the search field
			type("ssc_company2_questionnairelist_filtertxt_CSS", data.get("questionnaire_title"));
			System.out.println("Entered the newly created questionnaire in the search field.");
			ngDriver.waitForAngularRequestsToFinish();

			// verification of the created questionnaire
			verifyTrue("questionnaire_createdrecordauto_jumpsurveychecklist_XPATH",
					"The newly questionnaire is not created.");
			System.out.println("The new questionnaire is created successfully.");
			test.log(LogStatus.INFO, "The new questionnaire is created successfully.");

			// CONFIGRATION OF QUESTION

			System.out.println("***************** CONFIGRATION OF QUESTION *****************");
			test.log(LogStatus.INFO, "***************** CONFIGRATION OF QUESTION *****************");
			Reporter.log("***************** CONFIGRATION OF QUESTION *****************");
			log.info("***************** CONFIGRATION OF QUESTION *****************");

			// click on the created questionnaire
			click("questionnaire_createdrecordauto_jumpsurveychecklist_XPATH");
			System.out.println("Clicked on the newly created questionnaire.");
			ngDriver.waitForAngularRequestsToFinish();

			helper.configureQuestionAutoTaskDependancy(data);

			// enter newly created questionnaire in the filter field
			clear("ssc_company2_questionnairelist_filtertxt_CSS");
			ngDriver.waitForAngularRequestsToFinish();
			type("ssc_company2_questionnairelist_filtertxt_CSS", data.get("questionnaire_title"));
			System.out.println("Entered newly created questionnaire in the filter field.");
			ngDriver.waitForAngularRequestsToFinish();

			// verify newly created questionnaire for survey
			switchVerification("questionnaire_createdrecordauto_jumpsurveychecklist_XPATH",
					"Test Auto Questionnaire Jump Survey/Checklist Title",
					"The Test Auto Questionnaire Jump Survey/Checklist Title record is not displayed in the questionnaire list.");

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

		// VERIFY QUESTONNAIRE IN SURVEY MODULE

		System.out.println("***************** VERIFY QUESTONNAIRE IN SURVEY MODULE *****************");
		test.log(LogStatus.INFO, "***************** VERIFY QUESTONNAIRE IN SURVEY MODULE *****************");
		Reporter.log("***************** VERIFY QUESTONNAIRE IN SURVEY MODULE *****************");
		log.info("***************** VERIFY QUESTONNAIRE IN SURVEY MODULE *****************");

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

			// select the respective questionnaire from the dropdown
			select("survey_questionnairedd_CSS", data.get("questionnaire_title"));
			System.out.println("The questionnaire selected successfully.");
			ngDriver.waitForAngularRequestsToFinish();

			// verify questionnaire is selected correctly or not
			switchVerification("questionnaire_questiontitle_XPATH", "Test Category Title One",
					"The Test Category Title One is not displayed.");
			System.out.println("The added question is displayed successfully.");
			test.log(LogStatus.INFO, "The added question is displayed successfully.");

			// click on the YES checkbox of question 1
			click("survey_yesanswerbtn_1_CSS");
			System.out.println("Clicked on the yes checkbox.");
			ngDriver.waitForAngularRequestsToFinish();

			// click on the NO checkbox of question 2
			click("survey_noanswerbtn_2_CSS");
			System.out.println("Clicked on the no checkbox.");
			ngDriver.waitForAngularRequestsToFinish();

		} catch (Throwable t) {
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

		// VERIFY AUTO GENERATED TASK IS DISPLAYED OR NOT

		System.out.println("***************** VERIFY AUTO GENERATED TASK IS DISPLAYED OR NOT *****************");
		test.log(LogStatus.INFO, "***************** VERIFY AUTO GENERATED TASK IS DISPLAYED OR NOT *****************");
		Reporter.log("***************** VERIFY AUTO GENERATED TASK IS DISPLAYED OR NOT *****************");
		log.info("***************** VERIFY AUTO GENERATED TASK IS DISPLAYED OR NOT *****************");

		try {
			// click on the task icon of the respective property
			click("taskicon_CSS");
			System.out.println("Clicked on the task icon of the respective property.");
			ngDriver.waitForAngularRequestsToFinish();

			// click on the clear button
			click("task_createdtask_clearbtn_XPATH");
			ngDriver.waitForAngularRequestsToFinish();
			System.out.println("Clicked on the clear button.");

			// enter the data in the search field
			type("task_filter_CSS", data.get("task_title"));
			System.out.println("Entered the data in the search field.");
			ngDriver.waitForAngularRequestsToFinish();

			// click on the search button
			click("task_createdtask_searchbtn_XPATH");
			ngDriver.waitForAngularRequestsToFinish();
			System.out.println("Clicked on the search button.");

			// verify the auto generated task is displayed or not
			switchVerification("task_createdtask_jumpsurveychecklist_XPATH", "Test Task Jump Survey/Checklist Title",
					"The Test Task Jump Survey/Checklist Title is not displayed.");

			// VERIFY JUMP SURVEY/CHECKLIST BUTTON SHOULD LAUNCH SURVEY/CHECKLIST IN CLASSIC
			// MODE

			System.out.println(
					"***************** VERIFY JUMP SURVEY/CHECKLIST BUTTON SHOULD LAUNCH SURVEY/CHECKLIST IN CLASSIC MODE *****************");
			test.log(LogStatus.INFO,
					"***************** VERIFY JUMP SURVEY/CHECKLIST BUTTON SHOULD LAUNCH SURVEY/CHECKLIST IN CLASSIC MODE *****************");
			Reporter.log(
					"***************** VERIFY JUMP SURVEY/CHECKLIST BUTTON SHOULD LAUNCH SURVEY/CHECKLIST IN CLASSIC MODE *****************");
			log.info(
					"***************** VERIFY JUMP SURVEY/CHECKLIST BUTTON SHOULD LAUNCH SURVEY/CHECKLIST IN CLASSIC MODE *****************");

			// click on the auto generated task
			click("task_createdtask_jumpsurveychecklist_XPATH");
			System.out.println("Clicked on the auto generated task.");
			ngDriver.waitForAngularRequestsToFinish();

			// wait for the element
			Thread.sleep(5000);

			// click on the survey/checklist tab
			driver.findElement(By.xpath("//a[text()='Survey/Inspection']")).click();
			System.out.println("Clicked on the survey/checklist tab.");
			ngDriver.waitForAngularRequestsToFinish();

			// scroll down the screen
			JavascriptExecutor js = (JavascriptExecutor) driver;
			js.executeScript("window.scrollBy(0,600)");

			// click on the survey button
			click("survey_task_surveybtn_CSS");
			System.out.println("Clicked on the survey button.");
			ngDriver.waitForAngularRequestsToFinish();

			// select the newly created questionnaire from the dropdown
			select("survey_task_questionnairedd_CSS", data.get("questionnaire_title"));
			System.out.println("Selected the newly created questionnaire from the dropdown.");
			ngDriver.waitForAngularRequestsToFinish();

			// click on the update button
			click("survey_task_updatebtn_CSS");
			System.out.println("Clicked on the update button.");
			ngDriver.waitForAngularRequestsToFinish();

			// wait for the element
			explicitWaitClickable("closetoastmsg_CSS");

			// click on the toaster close button
			click("closetoastmsg_CSS");
			ngDriver.waitForAngularRequestsToFinish();
			System.out.println("Clicked on the toaster close button.");

			// wait for the element
			Thread.sleep(5000);
			
			// click on the clear button
			click("task_createdtask_clearbtn_XPATH");
			ngDriver.waitForAngularRequestsToFinish();
			System.out.println("Clicked on the clear button.");

			// enter the data in the search field
			type("task_filter_CSS", data.get("task_title"));
			System.out.println("Entered the data in the search field.");
			ngDriver.waitForAngularRequestsToFinish();

			// click on the search button
			click("task_createdtask_searchbtn_XPATH");
			ngDriver.waitForAngularRequestsToFinish();
			System.out.println("Clicked on the search button.");

			// verify the auto generated task is displayed or not
			switchVerification("task_createdtask_jumpsurveychecklist_XPATH", "Test Task Jump Survey/Checklist Title",
					"The Test Task Jump Survey/Checklist Title is not displayed.");

			// click on the auto generated task
			click("task_createdtask_jumpsurveychecklist_XPATH");
			System.out.println("Clicked on the auto generated task.");
			ngDriver.waitForAngularRequestsToFinish();

			// click on the survey/checklist tab
			driver.findElement(By.xpath("//a[text()='Survey/Inspection']")).click();
			System.out.println("Clicked on the survey/checklist tab.");
			ngDriver.waitForAngularRequestsToFinish();

			// scroll down the screen
			js.executeScript("window.scrollBy(0,600)");

			// click on the jump to survey/checklist button
			click("survey_task_jumptosurveychecklistbtn_CSS");
			System.out.println("Clicked on the jump to survey/checklist button.");
			ngDriver.waitForAngularRequestsToFinish();

			// verify switch to wizard mode button is displayed or not
			verifyTrue("survey_task_wizardicon3_CSS", "The switch to wizard mode button is not displayed.");

		} catch (Throwable t) {
			verificationFailed();
		}

		// click on the home icon from the top of the screen
		click("questionnaire_homeburgermenubtn_hide_CSS");
		System.out.println("Clicked on the home icon from the top of the screen.");
		ngDriver.waitForAngularRequestsToFinish();

		// wait for the element
		explicitWait("propertylist_title_XPATH");

		// verify the property list
		switchVerification("propertylist_title_XPATH", "Property List", "The property list is not displayed.");

		// DELETE THE AUTO GENERATED TASK

		System.out.println("***************** DELETE THE AUTO GENERATED TASK *****************");
		test.log(LogStatus.INFO, "***************** DELETE THE AUTO GENERATED TASK *****************");
		Reporter.log("***************** DELETE THE AUTO GENERATED TASK *****************");
		log.info("***************** DELETE THE AUTO GENERATED TASK *****************");

		try {
			// click on the task icon of the respective property
			click("taskicon_CSS");
			System.out.println("Clicked on the task icon of the respective property.");
			ngDriver.waitForAngularRequestsToFinish();

			// click on the clear button
			click("task_createdtask_clearbtn_XPATH");
			ngDriver.waitForAngularRequestsToFinish();
			System.out.println("Clicked on the clear button.");

			// enter the data in the search field
			type("task_filter_CSS", data.get("task_title"));
			System.out.println("Entered the data in the search field.");
			ngDriver.waitForAngularRequestsToFinish();

			// click on the search button
			click("task_createdtask_searchbtn_XPATH");
			ngDriver.waitForAngularRequestsToFinish();
			System.out.println("Clicked on the search button.");

			// verify the auto generated task is displayed or not
			switchVerification("task_createdtask_jumpsurveychecklist_XPATH", "Test Task Jump Survey/Checklist Title",
					"The Test Task Jump Survey/Checklist Title is not displayed.");

			// click on the action icon
			String actionIcon = "//p[text()='" + data.get("task_title")
					+ "']//parent::td//following-sibling::td[@class='text-center pointer']//i[@data-toggle='dropdown']";
			driver.findElement(By.xpath(actionIcon)).click();
			ngDriver.waitForAngularRequestsToFinish();
			System.out.println("Clicked on the action icon.");

			// click on the delete option
			String deleteOption = "//p[text()='" + data.get("task_title")
					+ "']//parent::td//following-sibling::td[@class='text-center pointer']//div[@class='dropdown open']//li[@ng-click='deleteSelectedTask(task.id, false);']";
			driver.findElement(By.xpath(deleteOption)).click();
			ngDriver.waitForAngularRequestsToFinish();
			System.out.println("Clicked on the action icon.");

			// wait for the element
			explicitWaitClickable("closetoastmsg_CSS");

			// click on the toaster close button
			click("closetoastmsg_CSS");
			ngDriver.waitForAngularRequestsToFinish();
			System.out.println("Clicked on the toaster close button.");

		} catch (Throwable t) {
			verificationFailed();
		}

		// click on the home icon from the top of the screen
		click("questionnaire_homeburgermenubtn_hide_CSS");
		System.out.println("Clicked on the home icon from the top of the screen.");
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
			click("questionnaire_createdrecordauto_jumpsurveychecklist_XPATH");
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
