package testcases.E2Etestcasesuite.surveychecklistmodule;

import java.io.IOException;
import java.util.Hashtable;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.SkipException;
import org.testng.annotations.Test;

import com.relevantcodes.extentreports.LogStatus;

import base.Helper;
import base.TestBase;
import utilities.TestUtil;

public class RR3900SurveyChecklistThreeTest extends TestBase {

	@Test(dataProviderClass = TestUtil.class, dataProvider = "dp")
	public void rR3900SurveyChecklistThreeTest(Hashtable<String, String> data)
			throws IOException, InterruptedException {

		execution(data, "rR3900SurveyChecklistThreeTest");

		// CREATE THE CHECKLIST IN PROPERTY AND SELECT THE USER TO APPROVE INSTANCES
		// PERMISSION

		System.out.println("CREATE THE CHECKLIST IN PROPERTY AND SELECT THE USER TO APPROVE INSTANCES PERMISSION");
		test.log(LogStatus.INFO,
				"CREATE THE CHECKLIST IN PROPERTY AND SELECT THE USER TO APPROVE INSTANCES PERMISSION");
		Reporter.log("CREATE THE CHECKLIST IN PROPERTY AND SELECT THE USER TO APPROVE INSTANCES PERMISSION");
		log.info("CREATE THE CHECKLIST IN PROPERTY AND SELECT THE USER TO APPROVE INSTANCES PERMISSION");

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
			ngDriver.waitForAngularRequestsToFinish();

			// Select the level of the questionnaire
			click("questionnaire_level_propertybtn_CSS");
			System.out.println("The level of the questionnire is selected.");
			ngDriver.waitForAngularRequestsToFinish();

			// enter the group title
			type("questionnaire_grouptitletxt_CSS", data.get("group_title"));
			System.out.println("The data entered in the Group Title field.");
			ngDriver.waitForAngularRequestsToFinish();

			// enter the questionnaire title
			type("questionnaire_languagetitle_CSS", data.get("questionnaire_checklist_title"));
			System.out.println("Entered the questionnaire title in the english language.");
			ngDriver.waitForAngularRequestsToFinish();

			// select the model
			select("questionnaire_modeldd_CSS", data.get("model"));
			System.out.println("The data entered in the Questionnaire Title field.");
			ngDriver.waitForAngularRequestsToFinish();

//			// select the document/report type
//			select("questionnaire_docreportdd_CSS", data.get("document_reporttype"));
//			System.out.println("The data entered in the document/report type field.");
//			ngDriver.waitForAngularRequestsToFinish();
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

			// click on the User to Approve Instance field
			click("questionnaire_checklist_usertoapproveinstance1_CSS");
			System.out.println("Clicked on the User to Approve Instance field.");
			ngDriver.waitForAngularRequestsToFinish();

			// enter the user name in the search field
			type("questionnaire_checklist_usertoapproveinstance2_CSS", data.get("checklist_search_3"));
			System.out.println("Entered the user name in the search field.");
			ngDriver.waitForAngularRequestsToFinish();

			// click on the user name from the searched result
			click("questionnaire_checklist_usertoapproveinstance3_XPATH");
			System.out.println("Clicked on the user name from the searched result.");
			ngDriver.waitForAngularRequestsToFinish();

			// click on the User to Approve Instance field
			click("questionnaire_checklist_usertoapproveinstance1_CSS");
			System.out.println("Clicked on the User to Approve Instance field.");
			ngDriver.waitForAngularRequestsToFinish();

			// scroll down to the save button
			js.executeScript("window.scrollBy(0,document.body.scrollHeight)");

			// click on the save button
			click("questionnaire_savebtn_BTNTEXT");
			System.out.println("Clicked on the save button");
			ngDriver.waitForAngularRequestsToFinish();
			System.out.println("Navigate to the list of questionnaire screen.");

			// enter newly created questionnaire in the filter field
			clear("ssc_company2_questionnairelist_filtertxt_CSS");
			ngDriver.waitForAngularRequestsToFinish();
			type("ssc_company2_questionnairelist_filtertxt_CSS", data.get("questionnaire_checklist_title"));
			System.out.println("Entered newly created questionnaire in the filter field.");
			ngDriver.waitForAngularRequestsToFinish();

			// verify newly created questionnaire for checklist
			switchVerification("questionnaire_record11_XPATH", "Questionnaire Property Checklist Access Three Title",
					"The Questionnaire Property Checklist User Access Title record is not displayed in the questionnaire list.");

			// CONFIGRATION OF QUESTION

			System.out.println("***************** CONFIGRATION OF QUESTION *****************");
			test.log(LogStatus.INFO, "***************** CONFIGRATION OF QUESTION *****************");
			Reporter.log("***************** CONFIGRATION OF QUESTION *****************");
			log.info("***************** CONFIGRATION OF QUESTION *****************");

			// click on the created questionnaire
			click("questionnaire_record11_XPATH");
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
			switchVerification("questionnaire_record11_XPATH", "Questionnaire Property Checklist Access Three Title",
					"The Questionnaire Property Checklist User Access Title record is not displayed in the questionnaire list.");

		} catch (Throwable t) {
			verificationFailed();
		}

		// click on the Home Icon from the top of the screen
		click("questionnaire_homeburgermenubtn_CSS");
		System.out.println("Clicked on the Home Icon from the top of the screen.");
		ngDriver.waitForAngularRequestsToFinish();

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

			// click on the checklist/inspection option from side menu
			click("checklist_sidemenu_XPATH");
			System.out.println("Clicked on the checklist/inspection option from side menu");
			ngDriver.waitForAngularRequestsToFinish();
			System.out.println("Navigate to the checklist/inspection screen");

			// select the property level from the dropdown
			select("survey_leveldropdown_CSS", data.get("property_leveldropdown"));
			System.out.println("Selected the property level from the dropdown.");
			ngDriver.waitForAngularRequestsToFinish();

			// CREATE THE CHECKLIST FIRST TIME

			System.out.println("***************** CREATE THE CHECKLIST FIRST TIME *****************");
			test.log(LogStatus.INFO, "***************** CREATE THE CHECKLIST FIRST TIME *****************");
			Reporter.log("***************** CREATE THE CHECKLIST FIRST TIME *****************");
			log.info("***************** CREATE THE CHECKLIST FIRST TIME *****************");

			// click on the new checklist button
			click("checklist_newchecklistbtn_CSS");
			System.out.println("Clicked on the new checklist button.");
			ngDriver.waitForAngularRequestsToFinish();

			// wait for the element
			explicitWait("checklist_addchecklist_checklisttypedd_CSS");

			// select the questionnaire option from the checklist type dropdown
			select("checklist_addchecklist_checklisttypedd_CSS", data.get("questionnaire_checklist_title"));
			System.out.println("The created questionaaire is selected from the checklist type dropdown.");
			ngDriver.waitForAngularRequestsToFinish();

			// enter data in the checklist title field
			type("checklist_addchecklist_titletxt_CSS", data.get("checklist_property_title"));
			System.out.println("Entered the data in the checklist title field.");
			ngDriver.waitForAngularRequestsToFinish();

			// click on the save button
			click("checklist_addchecklist_savebtn_CSS");
			System.out.println("Clicked on the save button.");
			ngDriver.waitForAngularRequestsToFinish();

			// verify questionnaire is selected correctly or not
			switchVerification("questionnaire_questiontitle_XPATH", "Test Category Title One",
					"The Test Category Title One is not displayed.");

			// click on the back button of the checklist preview mode
			click("checklist_backbtn_CSS");
			System.out.println("Clicked on the back button of the checklist preview mode.");
			ngDriver.waitForAngularRequestsToFinish();

			// enter the newly created instance name in the filter field
			clear("checklist_filtertxt_CSS");
			type("checklist_filtertxt_CSS", data.get("checklist_property_title"));
			System.out.println("Entered the newly created instance name in the filter field.");
			ngDriver.waitForAngularRequestsToFinish();

			// click on the filtered instant
			click("questionnaire_record11_XPATH");
			System.out.println("Clicked on the filtered instant.");
			ngDriver.waitForAngularRequestsToFinish();

			// click on the yes checkbox
			click("checklist_category_1_question_1_yesbtn_CSS");
			System.out.println("Clicked on the yes checkbox.");
			ngDriver.waitForAngularRequestsToFinish();

			// enter value in the text field
			clear("checklist_category_1_question_1_option_1_textfield_CSS");
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

			// verify 100% survey complete or not
			switchVerification("survey_imported_questionnaire_100_XPATH", "100% complete",
					"The 100% complete is not completed yet.");

			// click on the exit button
			click("checklist_questionnaire_exitbtn_CSS");
			System.out.println("Clicked on the exit button.");
			ngDriver.waitForAngularRequestsToFinish();

			// enter the newly created instance name in the filter field
			clear("checklist_filtertxt_CSS");
			type("checklist_filtertxt_CSS", data.get("checklist_property_title"));
			System.out.println("Entered the newly created instance name in the filter field.");
			ngDriver.waitForAngularRequestsToFinish();

			// click on the action icon
			click("checklist_actionicon_CSS");
			System.out.println("Clicked on the action icon.");
			ngDriver.waitForAngularRequestsToFinish();

			// verify approved option is displayed or not

			try {
				boolean str2 = driver.findElement(By.xpath(OR.getProperty("checklist_approveoption_XPATH")))
						.isDisplayed();

				if (str2 == true) {

					successMessage("The submit option is displayed as per the expected result.");

				} else {
					verificationFailedMessage("The submit option is not displayed.");
				}
			} catch (Throwable t) {

				verificationFailedMessage("The submit option is not displayed.");

			}

		} catch (Throwable t) {
			verificationFailed();
		}

		// LOGIN WITH SITE MANAGER USER AND VERIFY QUESTONNAIRE IN INSPECTION MODULE

		System.out.println(
				"***************** LOGIN WITH SITE MANAGER USER AND VERIFY QUESTONNAIRE IN INSPECTION MODULE *****************");
		test.log(LogStatus.INFO,
				"***************** LOGIN WITH SITE MANAGER USER AND VERIFY QUESTONNAIRE IN INSPECTION MODULE *****************");
		Reporter.log(
				"***************** LOGIN WITH SITE MANAGER USER AND VERIFY QUESTONNAIRE IN INSPECTION MODULE *****************");
		log.info(
				"***************** LOGIN WITH SITE MANAGER USER AND VERIFY QUESTONNAIRE IN INSPECTION MODULE *****************");

		try {
			// wait for the element
			explicitWaitClickable("questionnaire_settingicon_CSS");

			// click on the settings icon from the top of the screen
			click("questionnaire_settingicon_CSS");
			System.out.println("Clicked on the settings icon.");
			ngDriver.waitForAngularRequestsToFinish();

			// wait for the element
			explicitWaitClickable("sidemenu_logout_CSS");

			// click on the logout option from the side menu
			click("sidemenu_logout_CSS");
			System.out.println("Clicked on the logout option from the side menu.");
			ngDriver.waitForAngularRequestsToFinish();

			// login with valid credentials

			helper.loginAndUpdateSystemCompany(data, "username", "password", "system_company_1");

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

				// enter the newly created instance name in the filter field
				clear("checklist_filtertxt_CSS");
				System.out.println("Clear the data from the filter field.");
				ngDriver.waitForAngularRequestsToFinish();
				type("checklist_filtertxt_CSS", data.get("checklist_property_title"));
				System.out.println("Entered the newly created instance name in the filter field.");
				ngDriver.waitForAngularRequestsToFinish();

				// click on the action icon
				click("checklist_actionicon_CSS");
				System.out.println("Clicked on the action icon.");
				ngDriver.waitForAngularRequestsToFinish();

				// wait for the element
				explicitWait("checklist_approveoption_XPATH");

				// verify approved option is displayed or not

				try {
					String str4 = driver.findElement(By.xpath(OR.getProperty("checklist_approveoption_XPATH")))
							.getText();
					System.out.println(str4);
					if (str4.equals(" Submit")) {
						Assert.assertTrue(isElementPresent(By.xpath(OR.getProperty("checklist_approveoption_XPATH"))),
								"The approve option is not displayed");

						System.out.println(
								"The verification of the approve option is displayed as per the expected result.");
						test.log(LogStatus.INFO,
								"The verification of the approve option is displayed as per the expected result.");
						Reporter.log("The verification of the approve option is displayed as per the expected result.");
						log.info("The verification of the approve option is displayed as per the expected result.");

					}
				} catch (Throwable t) {

					verificationFailed();

				}

				// click on the approve option
				click("checklist_approveoption_CSS");
				System.out.println("Clicked on the approve option.");
				ngDriver.waitForAngularRequestsToFinish();

				// click on the approve button of the confirmation popup model.
				click("checklist_approvebtn_CSS");
				System.out.println("Clicked on the approve button of the confirmation popup model.");
				ngDriver.waitForAngularRequestsToFinish();

				// wait for the element
				explicitWaitClickable("closetoastmsg_CSS");

				// click on the toaster close button
				click("closetoastmsg_CSS");
				ngDriver.waitForAngularRequestsToFinish();
				System.out.println("Clicked on the toaster close button.");

				// select the approved status from the status dropdown
				select("checklist_statusdd_CSS", data.get("status_dd"));
				System.out.println("Selected the approved status from the status dropdown.");
				ngDriver.waitForAngularRequestsToFinish();

				// Enter the approved intent in the filter field
				clear("checklist_filtertxt_CSS");
				type("checklist_filtertxt_CSS", data.get("checklist_property_title"));
				System.out.println("Entered the approved intent in the filter field.");
				ngDriver.waitForAngularRequestsToFinish();

				// verify the approved instant is displayed or not
				switchVerification("ckecklist_approved_instant_XPATH",
						"Questionnaire Property Checklist Access Three Title",
						"The Questionnaire Property Checklist Access Three Title is not displayed");

				// clear the data from the filter field.
				clear("checklist_filtertxt_CSS");
				System.out.println("Clear the data from the filter field.");
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

			// wait for the element
			explicitWaitClickable("questionnaire_settingicon_CSS");

			// click on the settings icon from the top of the screen
			click("questionnaire_settingicon_CSS");
			System.out.println("Clicked on the settings icon.");
			ngDriver.waitForAngularRequestsToFinish();

			// wait for the element
			explicitWaitClickable("sidemenu_logout_CSS");

			// click on the logout option from the side menu
			click("sidemenu_logout_CSS");
			System.out.println("Clicked on the logout option from the side menu.");
			ngDriver.waitForAngularRequestsToFinish();

			// login with valid credentials

			helper.loginAndUpdateSystemCompany(data, "username_1", "password_1", "system_company_1");

		} catch (Throwable t) {
			helper.questionnaireNotDisplayLogout(data);
		}

		// UPDATE THE QUESTIONNAIRE TITLE WITH RANDOM TEXT

		System.out.println("***************** UPDATE THE QUESTIONNAIRE TITLE WITH RANDOM TEXT *****************");
		test.log(LogStatus.INFO, "***************** UPDATE THE QUESTIONNAIRE TITLE WITH RANDOM TEXT *****************");
		Reporter.log("***************** UPDATE THE QUESTIONNAIRE TITLE WITH RANDOM TEXT *****************");
		log.info("***************** UPDATE THE QUESTIONNAIRE TITLE WITH RANDOM TEXT *****************");

		try {
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
			click("questionnaire_record11_XPATH");
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
