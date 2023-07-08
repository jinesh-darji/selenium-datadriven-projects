package testcases.E2Etestcasesuite.surveychecklistmodule;

import java.io.IOException;
import java.util.Hashtable;
import java.util.List;

import org.apache.commons.lang3.RandomStringUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.Reporter;
import org.testng.SkipException;
import org.testng.annotations.Test;

import com.relevantcodes.extentreports.LogStatus;

import base.Helper;
import base.TestBase;
import utilities.TestUtil;

public class RR3894SurveyChecklistTest extends TestBase {

	@Test(dataProviderClass = TestUtil.class, dataProvider = "dp")
	public void rR3894SurveyChecklistTest(Hashtable<String, String> data) throws IOException, InterruptedException {

		execution(data, "rR3894SurveyChecklistTest");

		// LOCK/UNLOCK SURVEY/CHECKLIST IN ADMINISTRATION AND IMPACT TO THOSE IN
		// PROPERTIES

		System.out.println("LOCK/UNLOCK SURVEY/CHECKLIST IN ADMINISTRATION AND IMPACT TO THOSE IN PROPERTIES");
		test.log(LogStatus.INFO, "LOCK/UNLOCK SURVEY/CHECKLIST IN ADMINISTRATION AND IMPACT TO THOSE IN PROPERTIES");
		Reporter.log("LOCK/UNLOCK SURVEY/CHECKLIST IN ADMINISTRATION AND IMPACT TO THOSE IN PROPERTIES");
		log.info("LOCK/UNLOCK SURVEY/CHECKLIST IN ADMINISTRATION AND IMPACT TO THOSE IN PROPERTIES");

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
			verifyTrue("questionnaire_createdrecordauto_lock_XPATH", "The newly questionnaire is not created.");
			System.out.println("The new questionnaire is created successfully.");
			test.log(LogStatus.INFO, "The new questionnaire is created successfully.");

			// CONFIGRATION OF QUESTION

			System.out.println("***************** CONFIGRATION OF QUESTION *****************");
			test.log(LogStatus.INFO, "***************** CONFIGRATION OF QUESTION *****************");
			Reporter.log("***************** CONFIGRATION OF QUESTION *****************");
			log.info("***************** CONFIGRATION OF QUESTION *****************");

			// click on the created questionnaire
			click("questionnaire_createdrecordauto_lock_XPATH");
			System.out.println("Clicked on the newly created questionnaire.");
			ngDriver.waitForAngularRequestsToFinish();

			helper.configureQuestionsAutoTask(data);

			// enter newly created questionnaire in the filter field
			clear("ssc_company2_questionnairelist_filtertxt_CSS");
			ngDriver.waitForAngularRequestsToFinish();
			type("ssc_company2_questionnairelist_filtertxt_CSS", data.get("questionnaire_title"));
			System.out.println("Entered newly created questionnaire in the filter field.");
			ngDriver.waitForAngularRequestsToFinish();

			// verify newly created questionnaire for survey
			switchVerification("questionnaire_createdrecordauto_lock_XPATH", "Test Auto Questionnaire Lock Title",
					"The Test Auto Questionnaire Lock Title record is not displayed in the questionnaire list.");

		} catch (Throwable t) {
			System.out.println("The newly created questionnaire is not displayed.");
			test.log(LogStatus.INFO, "The newly created questionnaire is not displayed.");
			Reporter.log("The newly created questionnaire is not displayed.");
			log.info("The newly created questionnaire is not displayed.");

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

			// click on the no checkbox of question 1
			click("survey_noanswerbtn_1_CSS");
			System.out.println("Clicked on the NO checkbox.");
			ngDriver.waitForAngularRequestsToFinish();

			// click on the no checkbox of question 2
			click("survey_noanswerbtn_2_CSS");
			System.out.println("Clicked on the NO checkbox.");
			ngDriver.waitForAngularRequestsToFinish();

			// click on the category 1 question 1 label
			click("checklist_category_1_question_1_XPATH");
			System.out.println("Clicked on the category 1 question 1 label.");
			ngDriver.waitForAngularRequestsToFinish();

//		// click on the submit button
//		click("survey_modelapprovebtn_CSS");
//		ngDriver.waitForAngularRequestsToFinish();
//		System.out.println("Clicked on the submit button.");

			// verify the approve icon is displayed or not
			verifyTrue("survey_modelapprovebtn_CSS", "The survey is not locked successfully.");

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
			switchVerification("task_createdtask_lock_XPATH", "Test Task Lock Title",
					"The Test Task Lock Title is not displayed.");

			// UPDATE THE TASK NAME

			// click on the newly created task
			click("task_createdtask_lock_XPATH");
			System.out.println("Clicked on the newly created task.");
			ngDriver.waitForAngularRequestsToFinish();

			// generate the random text and enter data in the task title
			String s2 = RandomStringUtils.randomAlphabetic(8);

			clear("workflowsecurity_editortask_taskdetails_titletxt_CSS");
			System.out.println("Cleared the text from the task title field.");
			ngDriver.waitForAngularRequestsToFinish();
			type("workflowsecurity_editortask_taskdetails_titletxt_CSS", s2);
			System.out.println("The data entered in the task title field.");

			// click on the update button
			click("workflowsecurity_editortask_taskdetails_updatebtn_BTNTEXT");
			System.out.println("Clicked on the update button.");
			ngDriver.waitForAngularRequestsToFinish();

			// wait for the element
			explicitWaitClickable("closetoastmsg_CSS");

			// click on the toaster close button
			click("closetoastmsg_CSS");
			ngDriver.waitForAngularRequestsToFinish();
			System.out.println("Clicked on the toaster close button.");

		} catch (Throwable t) {
			System.out.println("The auto generated task is not displayed.");
			test.log(LogStatus.INFO, "The auto generated task is not displayed.");
			Reporter.log("The auto generated task is not displayed.");
			log.info("The auto generated task is not displayed.");

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

		// LOCK THE NEWLY CREATED QUESTIONNAIRE

		System.out.println("***************** LOCK THE NEWLY CREATED QUESTIONNAIRE *****************");
		test.log(LogStatus.INFO, "***************** LOCK THE NEWLY CREATED QUESTIONNAIRE *****************");
		Reporter.log("***************** LOCK THE NEWLY CREATED QUESTIONNAIRE *****************");
		log.info("***************** LOCK THE NEWLY CREATED QUESTIONNAIRE *****************");

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

			// click on the unlock icon of the newly created questionnaire
			click("task_unlockbtn_CSS");
			System.out.println("Click on the unlock icon of the newly created questionnaire.");
			ngDriver.waitForAngularRequestsToFinish();

			// click on the lock button of the confirmation popup
			click("task_modellockbtn_XPATH");
			System.out.println("Click on the lock button of the confirmation popup.");
			ngDriver.waitForAngularRequestsToFinish();

			// wait for the element
			explicitWaitClickable("task_lockbtn_CSS");

			// verify the lock icon is displayed or not
			verifyTrue("task_lockbtn_CSS", "The questionnaire is not locked successfully.");

		} catch (Throwable t) {
			System.out.println("The newly created questionnaire is not displayed.");
			test.log(LogStatus.INFO, "The newly created questionnaire is not displayed.");
			Reporter.log("The newly created questionnaire is not displayed.");
			log.info("The newly created questionnaire is not displayed.");

			verificationFailed();
		}

		// click on the home icon
		click("questionnaire_homeburgermenubtn_CSS");
		System.out.println("Clicked on the home icon.");
		ngDriver.waitForAngularRequestsToFinish();

		// wait for the element
		explicitWait("propertylist_title_XPATH");

		// verify the property list
		switchVerification("propertylist_title_XPATH", "Property List", "The property list is not displayed.");

		// VERIFY IN THE PROPERTY LEVEL IF THE SURVEY IS DISPLAYED LOCKED OR NOT

		System.out.println(
				"***************** VERIFY IN THE PROPERTY LEVEL IF THE SURVEY IS DISPLAYED LOCKED OR NOT *****************");
		test.log(LogStatus.INFO,
				"***************** VERIFY IN THE PROPERTY LEVEL IF THE SURVEY IS DISPLAYED LOCKED OR NOT *****************");
		Reporter.log(
				"***************** VERIFY IN THE PROPERTY LEVEL IF THE SURVEY IS DISPLAYED LOCKED OR NOT *****************");
		log.info(
				"***************** VERIFY IN THE PROPERTY LEVEL IF THE SURVEY IS DISPLAYED LOCKED OR NOT *****************");

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

			// wait for the element
			explicitWait("survey_questionnairedd_CSS");

			// VERIFY THE LOCKED QUESTIONNAIRE IS DISPLAYED OR NOT IN THE QUESITONNAIRE
			// DROPDOWN LIST

			// collect all options of the dropdown
			Select dropdown = new Select(
					driver.findElement(By.cssSelector(OR.getProperty("survey_questionnairedd_CSS"))));

			// Get all options
			List<WebElement> dd = dropdown.getOptions();

			// Loop to print one by one
			for (int j = 0; j < dd.size(); j++) {
				String checklist = dd.get(j).getText();
				try {
					if (checklist.equals("Test Auto Questionnaire Lock Title")) {
						TestUtil.captureScreenshot();

						// ReportNG
						Reporter.log("<br>" + " The " + data.get("questionnaire_title")
								+ " is displayed in the dropdown." + "<br>");
						Reporter.log("<a target=\"_blank\" href=" + TestUtil.screenshotName + "><img src="
								+ TestUtil.screenshotName + " height=200 width=200></img></a>");
						Reporter.log("<br>");
						Reporter.log("<br>");

						// Extent Report
						test.log(LogStatus.FAIL,
								" The " + data.get("questionnaire_title") + " is displayed in the dropdown.");
						test.log(LogStatus.FAIL, test.addScreenCapture(TestUtil.screenshotName));

					}

				} catch (Throwable t) {
					test.log(LogStatus.INFO, "The locked questionnaire is not displayed in the questionnaire list.");
					Reporter.log("The locked questionnaire is not displayed in the questionnaire list.");
					System.out.println("The locked questionnaire is not displayed in the questionnaire list.");
					log.info("The locked questionnaire is not displayed in the questionnaire list.");
				}
			}

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
			click("questionnaire_createdrecordauto_lock_XPATH");
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
