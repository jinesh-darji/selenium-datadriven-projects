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

		System.out.println(
				"A PDF REPORT SHOULD NOT BE GENERATED IF DOCUMENT/REPORT IS NOT CONFIGURED // MAKE SURE THE PERCENTAGE OF COMPLETNESS IS CORRECT.");
		test.log(LogStatus.INFO,
				"A PDF REPORT SHOULD NOT BE GENERATED IF DOCUMENT/REPORT IS NOT CONFIGURED // MAKE SURE THE PERCENTAGE OF COMPLETNESS IS CORRECT.");
		Reporter.log(
				"A PDF REPORT SHOULD NOT BE GENERATED IF DOCUMENT/REPORT IS NOT CONFIGURED // MAKE SURE THE PERCENTAGE OF COMPLETNESS IS CORRECT.");
		log.info(
				"A PDF REPORT SHOULD NOT BE GENERATED IF DOCUMENT/REPORT IS NOT CONFIGURED // MAKE SURE THE PERCENTAGE OF COMPLETNESS IS CORRECT.");

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

			// click on the new questionnaire
			click("questionnaire_newquestionnairebtn_CSS");
			System.out.println("Click on the New Questionnire button");
			ngDriver.waitForAngularRequestsToFinish();
			System.out.println("Navigate to the add questionnire details screen.");

			// Select the Inspection / Checklist of the questionnaire
			click("questionnaire_type_inspectionbtn_CSS");
			System.out.println("The type of the questionnire is selected.");

			// Select the level of the questionnaire
			click("questionnaire_level_propertybtn_CSS");
			System.out.println("The level of the questionnire is selected.");

			// enter the group title
			type("questionnaire_grouptitletxt_CSS", data.get("group_title"));
			System.out.println("The data entered in the Group Title field.");

			// enter the questionnaire title
			type("questionnaire_questionnairetitletxt_CSS", data.get("questionnaire_title"));
			System.out.println("The data entered in the Questionnaire Title field.");

			// select the model
			select("questionnaire_modeldd_CSS", data.get("model"));
			System.out.println("The data entered in the Questionnaire Title field.");
			ngDriver.waitForAngularRequestsToFinish();

//		// select the document/report type
//		select("questionnaire_docreportdd_CSS", data.get("document_reporttype"));
//		System.out.println("The data entered in the document/report type field.");
//		ngDriver.waitForAngularRequestsToFinish();
//
//			// select the default task tag
//			select("questionnaire_defaulttasktagdd_CSS", data.get("default_task_tag"));
//			System.out.println("The data entered in the default task tag field.");
//			ngDriver.waitForAngularRequestsToFinish();

			// enter frequency interval
			type("questionnaire_frequencyintervaltxt_CSS", "1");
			ngDriver.waitForAngularRequestsToFinish();
			System.out.println("Entered frequency interval.");

			// enter the description
			type("questionnaire_descriptiontxt_CSS", data.get("description"));
			System.out.println("The data entered in the description field.");

			// select the classic option from the default view drop down
			select("questionnaire_checklist_defaultview_CSS", data.get("default_view"));
			System.out.println("Selected the classic option from the default view drop down.");
			ngDriver.waitForAngularRequestsToFinish();

			// scroll down the screen
			JavascriptExecutor js = (JavascriptExecutor) driver;
			js.executeScript("window.scrollBy(0,500)");

			// click on the warranty checkbox
			click("questionnaire_warrantybtn_CSS");
			System.out.println("Clicked on the warranty checkbox.");
			ngDriver.waitForAngularRequestsToFinish();

			// click on the save button
			click("questionnaire_savebtn_BTNTEXT");
			System.out.println("Clicked on the save button");
			ngDriver.waitForAngularRequestsToFinish();
			System.out.println("Navigate to the list of questionnaire screen.");

			// enter newly created questionnaire in the filter field
			clear("ssc_company2_questionnairelist_filtertxt_CSS");
			ngDriver.waitForAngularRequestsToFinish();
			type("ssc_company2_questionnairelist_filtertxt_CSS", data.get("questionnaire_title"));
			System.out.println("Entered newly created questionnaire in the filter field.");
			ngDriver.waitForAngularRequestsToFinish();

			// verify newly created questionnaire for checklist
			switchVerification("checklist_pdfreportchecklist_1_XPATH", "Test Questionnaire PDF Report Title",
					"The Test Questionnaire PDF Report Title record is not displayed in the questionnaire list.");

			// CONFIGRATION OF QUESTION

			System.out.println("***************** CONFIGRATION OF QUESTION *****************");
			test.log(LogStatus.INFO, "***************** CONFIGRATION OF QUESTION *****************");
			Reporter.log("***************** CONFIGRATION OF QUESTION *****************");
			log.info("***************** CONFIGRATION OF QUESTION *****************");

			// click on the created questionnaire
			click("checklist_pdfreportchecklist_1_XPATH");
			System.out.println("Clicked on the newly created questionnaire for checklist.");
			ngDriver.waitForAngularRequestsToFinish();

			helper.configureQuestions(data);

			// enter newly created questionnaire in the filter field
			clear("ssc_company2_questionnairelist_filtertxt_CSS");
			ngDriver.waitForAngularRequestsToFinish();
			type("ssc_company2_questionnairelist_filtertxt_CSS", data.get("questionnaire_title"));
			System.out.println("Entered newly created questionnaire in the filter field.");
			ngDriver.waitForAngularRequestsToFinish();

			// verify newly created questionnaire for checklist
			switchVerification("checklist_pdfreportchecklist_1_XPATH", "Test Questionnaire PDF Report Title",
					"The Test Questionnaire PDF Report Title record is not displayed in the questionnaire list.");

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

			// click on the yes checkbox
			click("checklist_category_1_question_1_yesbtn_CSS");
			System.out.println("Clicked on the yes checkbox.");
			ngDriver.waitForAngularRequestsToFinish();

			// enter value in the text field
			type("checklist_category_1_question_1_option_1_textfield_CSS", data.get("checklist_textfield_question"));
			System.out.println("Entered the data in the text field.");
			ngDriver.waitForAngularRequestsToFinish();

			// click on the no checkbox of the question 2 of category 1
			click("survey_noanswerbtn_2_CSS");
			System.out.println("Clicked on the no checkbox of the question 2 of category 1.");
			ngDriver.waitForAngularRequestsToFinish();

			// click on the category 1 question 1 label
			click("checklist_category_1_question_1_XPATH");
			System.out.println("Clicked on the category 1 question 1 label.");
			ngDriver.waitForAngularRequestsToFinish();

			// wait for element
			explicitWaitClickable("survey_imported_questionnaire_100_XPATH");

			// verify 100% survey complete or not
			switchVerification("survey_imported_questionnaire_100_XPATH", "100% complete",
					"The survey is not complited yet.");

			// click on the exit button
			click("checklist_questionnaire_exitbtn_CSS");
			System.out.println("Clicked on the exit button.");
			ngDriver.waitForAngularRequestsToFinish();

			// APPROVE CHECKLIST

			System.out.println("***************** APPROVE CHECKLIST *****************");
			test.log(LogStatus.INFO, "***************** APPROVE CHECKLIST *****************");
			Reporter.log("***************** APPROVE CHECKLIST *****************");
			log.info("***************** APPROVE CHECKLIST *****************");

			// enter the newly created instance name in the filter field
			clear("checklist_filtertxt_CSS");
			System.out.println("Clear the data from the filter field.");
			ngDriver.waitForAngularRequestsToFinish();
			type("checklist_filtertxt_CSS", data.get("checklist_title"));
			System.out.println("Entered the newly created instance name in the filter field.");
			ngDriver.waitForAngularRequestsToFinish();

			// click on the action icon of the checklist
			click("checklist_actionicon_CSS");
			System.out.println("Clicked on the action icon of the checklist.");
			ngDriver.waitForAngularRequestsToFinish();

			// click on the approve option from the action options list
			click("checklist_approveoption_CSS");
			System.out.println("Clicked on the approve option from the action options list.");
			ngDriver.waitForAngularRequestsToFinish();

			// click on the approve button of the confirmation pop up
			click("checklist_modelaprovebtn_CSS");
			System.out.println("Clicked on the approve button of the confirmation pop up.");
			ngDriver.waitForAngularRequestsToFinish();

			// select the approve option from the status dropdown
			select("checklist_statusdd_CSS", data.get("checklist_approved"));
			System.out.println("Selected the approve option from the status dropdown.");
			ngDriver.waitForAngularRequestsToFinish();

			// enter the newly created instance name in the filter field
			clear("checklist_filtertxt_CSS");
			System.out.println("Clear the data from the filter field.");
			ngDriver.waitForAngularRequestsToFinish();
			type("checklist_filtertxt_CSS", data.get("checklist_title"));
			System.out.println("Entered the newly created instance name in the filter field.");
			ngDriver.waitForAngularRequestsToFinish();

			// verify the checklist is approved or not
			switchVerification("checklist_approved_pdfreportinstant_XPATH", "Test Checklist PDF Report Title",
					"The Test Checklist PDF Report Title is not displayed.");

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

		// VERIFY DOCUMENTS/REPORTS GENERATED OR NOT

		System.out.println("***************** VERIFY DOCUMENTS/REPORTS GENERATED OR NOT *****************");
		test.log(LogStatus.INFO, "***************** VERIFY DOCUMENTS/REPORTS GENERATED OR NOT *****************");
		Reporter.log("***************** VERIFY DOCUMENTS/REPORTS GENERATED OR NOT *****************");
		log.info("***************** VERIFY DOCUMENTS/REPORTS GENERATED OR NOT *****************");

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

			// click on the Environmental Reports option
			click("envreportoption_XPATH");
			System.out.println("Clicked on the Environmental Reports option.");
			ngDriver.waitForAngularRequestsToFinish();
			System.out.println("Navigate to the Environmental Report Screen.");

			// enter the data in the filter field
			clear("checklist_filtertxt_CSS");
			System.out.println("Cleared the data of the filter field.");
			ngDriver.waitForAngularRequestsToFinish();
			type("checklist_filtertxt_CSS", data.get("questionnaire_title"));
			System.out.println("Entered the data in the filter field.");
			ngDriver.waitForAngularRequestsToFinish();

			// verify the environmental report is generated or not
			try {
				String str1 = driver.findElement(By.xpath(OR.getProperty("checklist_filteredpdfreport_XPATH")))
						.getText();
				ngDriver.waitForAngularRequestsToFinish();
				if (str1.equals("(December-2020) Test Questionnaire PDF Report Title")) {

					Assert.assertTrue(isElementPresent(By.xpath(OR.getProperty("checklist_filteredpdfreport_XPATH"))),
							"The environmental PDF report is not displayed successfully. ");

					TestUtil.captureScreenshot();

					// ReportNG
					Reporter.log("<br>" + "The environmental PDF report is displayed successfully. " + "<br>");
					Reporter.log("<a target=\"_blank\" href=" + TestUtil.screenshotName + "><img src="
							+ TestUtil.screenshotName + " height=200 width=200></img></a>");
					Reporter.log("<br>");
					Reporter.log("<br>");

					// Extent Report
					test.log(LogStatus.FAIL, " The environmental PDF report is displayed successfully. ");
					test.log(LogStatus.FAIL, test.addScreenCapture(TestUtil.screenshotName));

					System.out.println("The environmental PDF report is displayed successfully.");
					log.info("The environmental PDF report is displayed successfully.");

				}
			} catch (Throwable t) {

				System.out.println("The environmental PDF report is not displayed successfully.");
				log.info("The environmental PDF report is not displayed successfully.");
				test.log(LogStatus.INFO, "The environmental PDF report is not displayed successfully.");
				Reporter.log("The environmental PDF report is not displayed successfully.");

			}

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
			type("ssc_company2_questionnairelist_filtertxt_CSS", data.get("questionnaire_title"));
			System.out.println("Entered newly created questionnaire in the filter field.");
			ngDriver.waitForAngularRequestsToFinish();

			// click on the created questionnaire
			click("checklist_pdfreportchecklist_1_XPATH");
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
