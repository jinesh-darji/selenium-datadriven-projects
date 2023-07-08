package testcases.E2Etestcasesuite.surveychecklistmodule;

import java.io.IOException;
import java.util.Hashtable;

import org.openqa.selenium.By;
import org.testng.Reporter;
import org.testng.SkipException;
import org.testng.annotations.Test;

import com.relevantcodes.extentreports.LogStatus;

import base.Helper;
import base.TestBase;
import utilities.TestUtil;

public class RR3948SurveyChecklistTest extends TestBase {

	@Test(dataProviderClass = TestUtil.class, dataProvider = "dp")
	public void rR3948SurveyChecklistTest(Hashtable<String, String> data) throws IOException, InterruptedException {

		execution(data, "rR3948SurveyChecklistTest");

		// WIZARD MODE TO ANSWER SURVEY/CHECKLIST

		System.out.println("WIZARD MODE TO ANSWER SURVEY/CHECKLIST");
		test.log(LogStatus.INFO, "WIZARD MODE TO ANSWER SURVEY/CHECKLIST");
		Reporter.log("WIZARD MODE TO ANSWER SURVEY/CHECKLIST");
		log.info("WIZARD MODE TO ANSWER SURVEY/CHECKLIST");

		Helper helper = new Helper();

		// refresh the page
		driver.navigate().refresh();
		Thread.sleep(5000);
		driver.navigate().refresh();

		System.out.println("Navigate to the Home Screen i.e. Property List Screen.");

		// ADD NEW QUESTIONNIRE FOR CHECKLIST

		System.out.println("***************** ADD NEW QUESTIONNIRE FOR CHECKLIST *****************");
		test.log(LogStatus.INFO, "***************** ADD NEW QUESTIONNIRE FOR CHECKLIST *****************");
		Reporter.log("***************** ADD NEW QUESTIONNIRE FOR CHECKLIST *****************");
		log.info("***************** ADD NEW QUESTIONNIRE FOR CHECKLIST *****************");

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

			helper.createChecklistQuestionnaire(data);

			// enter newly created questionnaire in the filter field
			clear("ssc_company2_questionnairelist_filtertxt_CSS");
			ngDriver.waitForAngularRequestsToFinish();
			type("ssc_company2_questionnairelist_filtertxt_CSS", data.get("questionnaire_checklist_title"));
			System.out.println("Entered newly created questionnaire in the filter field.");
			ngDriver.waitForAngularRequestsToFinish();

			// verify newly created questionnaire for checklist
			switchVerification("checklist_wizardchecklist_1_XPATH", "Test Questionnaire Wizard Title",
					"The Test Questionnaire Wizard Title record is not displayed in the questionnaire list.");

			// CONFIGRATION OF QUESTION

			System.out.println("***************** CONFIGRATION OF QUESTION *****************");
			test.log(LogStatus.INFO, "***************** CONFIGRATION OF QUESTION *****************");
			Reporter.log("***************** CONFIGRATION OF QUESTION *****************");
			log.info("***************** CONFIGRATION OF QUESTION *****************");

			// click on the created questionnaire
			click("checklist_wizardchecklist_1_XPATH");
			System.out.println("Clicked on the newly created questionnaire for checklist.");
			ngDriver.waitForAngularRequestsToFinish();

			helper.configureQuestions(data);

			// enter newly created questionnaire in the filter field
			clear("ssc_company2_questionnairelist_filtertxt_CSS");
			ngDriver.waitForAngularRequestsToFinish();
			type("ssc_company2_questionnairelist_filtertxt_CSS", data.get("questionnaire_checklist_title"));
			System.out.println("Entered newly created questionnaire in the filter field.");
			ngDriver.waitForAngularRequestsToFinish();

			// verify newly created questionnaire for checklist
			switchVerification("checklist_wizardchecklist_1_XPATH", "Test Questionnaire Wizard Title",
					"The Test Questionnaire Wizard Title record is not displayed in the questionnaire list.");

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

		// VERIFY THE CHECKLIST IN THE PROPERTY LEVEL

		System.out.println("***************** VERIFY THE CHECKLIST IN THE PROPERTY LEVEL *****************");
		test.log(LogStatus.INFO, "***************** VERIFY THE CHECKLIST IN THE PROPERTY LEVEL *****************");
		Reporter.log("***************** VERIFY THE CHECKLIST IN THE PROPERTY LEVEL *****************");
		log.info("***************** VERIFY THE CHECKLIST IN THE PROPERTY LEVEL *****************");

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

			// click on the inspection/checklist option from side menu
			click("checklist_sidemenu_XPATH");
			System.out.println("Clicked on the inspection/checklist option from side menu");
			ngDriver.waitForAngularRequestsToFinish();
			System.out.println("Navigate to the inspection/checklist screen");

			// CREATE CHECKLIST

			System.out.println("***************** CREATE CHECKLIST *****************");
			test.log(LogStatus.INFO, "***************** CREATE CHECKLIST *****************");
			Reporter.log("***************** CREATE CHECKLIST *****************");
			log.info("***************** CREATE CHECKLIST *****************");

			// click on the new checklist button
			click("checklist_newchecklistbtn_CSS");
			System.out.println("Clicked on the new checklist button.");
			ngDriver.waitForAngularRequestsToFinish();

			// wait for the element
			explicitWait("checklist_addchecklist_checklisttypedd_CSS");

			// select the questionnaire option from the checklist type dropdown
			select("checklist_addchecklist_checklisttypedd_CSS", data.get("checklist_type"));
			System.out.println("The created questionaaire is selected from the checklist type dropdown.");
			ngDriver.waitForAngularRequestsToFinish();

			// enter data in the checklist title field
			type("checklist_addchecklist_titletxt_CSS", data.get("checklist_title"));
			System.out.println("Entered the data in the checklist title field.");
			ngDriver.waitForAngularRequestsToFinish();

			// click on the save button
			click("checklist_addchecklist_savebtn_CSS");
			System.out.println("Clicked on the save button.");
			ngDriver.waitForAngularRequestsToFinish();

			// wait for the element
			Thread.sleep(5000);

			// click on the switch to wizard mode button
			click("survey_task_wizardicon_XPATH");
			System.out.println("Clicked on the switch to wizard mode button.");
			ngDriver.waitForAngularRequestsToFinish();

			// wait for the element
			explicitWaitClickable("checklist_wizard_yesoption_CSS");

			// click on the yes checkbox
			click("checklist_wizard_yesoption_CSS");
			System.out.println("Clicked on the yes checkbox.");
			ngDriver.waitForAngularRequestsToFinish();

			// enter value in the text field
			type("survey_textfield_CSS", data.get("checklist_textfield_question"));
			System.out.println("Entered the data in the text field.");
			ngDriver.waitForAngularRequestsToFinish();

			// click on the next button
			driver.findElement(By.xpath(
					"//div[@class='container footer']//button[@ng-click='nextCategory()' and @class='btn btn-sm btn-primary ng-binding pull-right']"))
					.click();
			System.out.println("Clicked on the next button.");
			ngDriver.waitForAngularRequestsToFinish();

			// click on the yes checkbox
			click("checklist_wizard_yesoption_CSS");
			System.out.println("Clicked on the yes checkbox.");
			ngDriver.waitForAngularRequestsToFinish();

			// click on the Previous button
			driver.findElement(By.xpath(
					"//div[@class='container footer']//button[@ng-click='previousCategory()' and @class='btn btn-sm btn-primary ng-binding']"))
					.click();
			System.out.println("Clicked on the Previous button.");
			ngDriver.waitForAngularRequestsToFinish();

			// click on the next button
			driver.findElement(By.xpath(
					"//div[@class='container footer']//button[@ng-click='nextCategory()' and @class='btn btn-sm btn-primary ng-binding pull-right']"))
					.click();
			System.out.println("Clicked on the next button.");
			ngDriver.waitForAngularRequestsToFinish();

			// wait for the element
			explicitWaitClickable("checklist_questionnaire_exitbtn_CSS");

			// click on the exit button
			click("checklist_questionnaire_exitbtn_CSS");
			System.out.println("Clicked on the exit button.");
			ngDriver.waitForAngularRequestsToFinish();

		} catch (Throwable t) {
			verificationFailed();
		}

		// click on the home option from the side menu
		click("questionnaire_homeburgermenubtn_hide_CSS");
		System.out.println("Clicked on the home option from the side menu");
		ngDriver.waitForAngularRequestsToFinish();

		// wait for the element
		explicitWait("propertylist_title_XPATH");

		// verify the property list
		switchVerification("propertylist_title_XPATH", "Property List", "The property list is not displayed.");

		// DELETE THE NEWLY CREATED INSPECTION

		System.out.println("***************** DELETE THE NEWLY CREATED INSPECTION *****************");
		test.log(LogStatus.INFO, "***************** DELETE THE NEWLY CREATED INSPECTION *****************");
		Reporter.log("***************** DELETE THE NEWLY CREATED INSPECTION *****************");
		log.info("***************** DELETE THE NEWLY CREATED INSPECTION *****************");

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

			// click on the checklist/inspection option from side menu
			click("checklist_sidemenu_XPATH");
			System.out.println("Clicked on the checklist/inspection option from side menu");
			ngDriver.waitForAngularRequestsToFinish();
			System.out.println("Navigate to the checklist/inspection screen");

			// wait for the element
			Thread.sleep(5000);

			// click on the newly created inspection
			String inspection = "//td[text()='" + data.get("questionnaire_checklist_title")
					+ "']//following-sibling::td[@class='text-center pointer']//i[@id='action']";
			driver.findElement(By.xpath(inspection)).click();
			ngDriver.waitForAngularRequestsToFinish();
			System.out.println("Clicked on the newly created inspection.");

			// click on the delete option
			String deleteOption = "//td[text()='" + data.get("questionnaire_checklist_title")
					+ "']//following-sibling::td[@class='text-center pointer']//div[@class='dropdown open']//li[@id='delete']";
			driver.findElement(By.xpath(deleteOption)).click();
			ngDriver.waitForAngularRequestsToFinish();
			System.out.println("Clicked on the delete button.");

			// wait for the element
			explicitWaitClickable("checklist_deletebtn_XPATH");

			// click on the delete button
			click("checklist_deletebtn_XPATH");
			ngDriver.waitForAngularRequestsToFinish();
			System.out.println("Clicked on the delete button.");

		} catch (Throwable t) {
			verificationFailed();
		}

		// click on the home option from the side menu
		click("questionnaire_homeburgermenubtn_hide_CSS");
		System.out.println("Clicked on the home option from the side menu");
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
			type("ssc_company2_questionnairelist_filtertxt_CSS", data.get("questionnaire_checklist_title"));
			System.out.println("Entered newly created questionnaire in the filter field.");
			ngDriver.waitForAngularRequestsToFinish();

			// click on the created questionnaire
			click("checklist_wizardchecklist_1_XPATH");
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
