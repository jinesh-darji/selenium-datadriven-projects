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

		System.out.println("INSPECTIONS/CHECKLIST DASHBOARD - LIST OF CHECKLISTS DISPLAYED.");
		test.log(LogStatus.INFO, "INSPECTIONS/CHECKLIST DASHBOARD - LIST OF CHECKLISTS DISPLAYED.");
		Reporter.log("INSPECTIONS/CHECKLIST DASHBOARD - LIST OF CHECKLISTS DISPLAYED.");
		log.info("INSPECTIONS/CHECKLIST DASHBOARD - LIST OF CHECKLISTS DISPLAYED.");

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

			// select the frequency
			select("questionnaire_frequencydd_CSS", data.get("frequency"));
			System.out.println("The data entered in the frequency field.");
			ngDriver.waitForAngularRequestsToFinish();

			// enter frequency interval
			type("questionnaire_frequencyintervaltxt_CSS", "1");
			ngDriver.waitForAngularRequestsToFinish();
			System.out.println("Entered frequency interval.");

//		// enter the year
//		type("questionnaire_yeartxt_CSS", "2020");
//		System.out.println("The data entered in the year field.");
//		ngDriver.waitForAngularRequestsToFinish();

			// select the month
			select("questionnaire_monthtxt_CSS", data.get("month"));
			System.out.println("The data entered in the month field.");
			ngDriver.waitForAngularRequestsToFinish();

			// enter the description
			type("questionnaire_descriptiontxt_CSS", data.get("description"));
			System.out.println("The data entered in the description field.");

			// select the classic option from the default view drop down
			select("questionnaire_checklist_defaultview_CSS", data.get("default_view"));
			System.out.println("Selected the classic option from the default view drop down.");
			ngDriver.waitForAngularRequestsToFinish();

			// scroll down the screen
			JavascriptExecutor js = (JavascriptExecutor) driver;
			js.executeScript("window.scrollBy(0,400)");

			// click on the User to Access Instance field
			click("questionnaire_checklist_usertoaccessinstance1_CSS");
			System.out.println("Clicked on the User to Access Instance field.");
			ngDriver.waitForAngularRequestsToFinish();

			// enter the user name in the search field
			type("questionnaire_checklist_usertoaccessinstance2_CSS", data.get("checklist_search_1"));
			System.out.println("Entered the user name in the search field.");
			ngDriver.waitForAngularRequestsToFinish();

			// click on the user name from the searched result
			click("questionnaire_checklist_usertoaccessinstance_dashboard_XPATH");
			System.out.println("Clicked on the user name from the searched result.");
			ngDriver.waitForAngularRequestsToFinish();

			// click on the User to Access Instance field
			click("questionnaire_checklist_usertoaccessinstance1_CSS");
			System.out.println("Clicked on the User to Access Instance field.");
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
			switchVerification("questionnaire_record_checklistdashboard_XPATH",
					"Test Questionnaire Checklist Dashboard Title",
					"The Test Questionnaire Checklist Dashboard Title record is not displayed in the questionnaire list.");

			// CONFIGRATION OF QUESTION

			System.out.println("***************** CONFIGRATION OF QUESTION *****************");
			test.log(LogStatus.INFO, "***************** CONFIGRATION OF QUESTION *****************");
			Reporter.log("***************** CONFIGRATION OF QUESTION *****************");
			log.info("***************** CONFIGRATION OF QUESTION *****************");

			// click on the created questionnaire
			click("questionnaire_record_checklistdashboard_XPATH");
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
			switchVerification("questionnaire_record_checklistdashboard_XPATH",
					"Test Questionnaire Checklist Dashboard Title",
					"The Test Questionnaire Checklist Dashboard Title record is not displayed in the questionnaire list.");

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

			// click on the burger menu
			click("menubtn_CSS");
			System.out.println("Clicked on the burger menu button successfully!!!");
			ngDriver.waitForAngularRequestsToFinish();

			// wait for the element
			explicitWaitClickable("surveyoption_XPATH");

			// click on the checklist/inspection option from side menu
			click("checklist_sidemenu_XPATH");
			System.out.println("Clicked on the checklist/inspection option from side menu");
			ngDriver.waitForAngularRequestsToFinish();
			System.out.println("Navigate to the checklist/inspection screen");

			// select the property level from the dropdown
			select("survey_leveldropdown_CSS", data.get("property_leveldropdown"));
			System.out.println("Selected the property level from the dropdown.");
			ngDriver.waitForAngularRequestsToFinish();

			// click on the new checklist button
			click("checklist_newchecklistbtn_CSS");
			System.out.println("Clicked on the new checklist button.");
			ngDriver.waitForAngularRequestsToFinish();

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

						test.log(LogStatus.INFO, "The checklists are verified successfully.");
						Reporter.log("The checklists are verified successfully.");
						System.out.println("The checklists are verified successfully.");
						log.info("The checklists are verified successfully.");

					}
				} catch (Throwable t) {
					verificationFailed();
				}
			}

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

		// OPEN THE INSPECTION/CHECKLIST DASHBOARD

		System.out.println("***************** OPEN THE INSPECTION/CHECKLIST DASHBOARD *****************");
		test.log(LogStatus.INFO, "***************** OPEN THE INSPECTION/CHECKLIST DASHBOARD *****************");
		Reporter.log("***************** OPEN THE INSPECTION/CHECKLIST DASHBOARD *****************");
		log.info("***************** OPEN THE INSPECTION/CHECKLIST DASHBOARD *****************");

		try {
			// select the Inspections/Checklists option from the dashboard dropdown
			select("ssc_environmental_dashboarddd_CSS", data.get("inspection_checklist_dd"));
			System.out.println("The Inspections/Checklists option is selected from the dashboard drop down.");
			ngDriver.waitForAngularRequestsToFinish();

			// filter created checklist
			clear("envreports_propertylist_filtertxt_CSS");
			type("envreports_propertylist_filtertxt_CSS", data.get("questionnaire_checklist_title"));
			System.out.println("Entered newly created questionnaire in the filter field.");
			ngDriver.waitForAngularRequestsToFinish();

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

		System.out.println("***************** LOGOUT FROM ADMIN USER AND LOGIN WITH CONTRACTOR USER *****************");
		test.log(LogStatus.INFO,
				"***************** LOGOUT FROM ADMIN USER AND LOGIN WITH CONTRACTOR USER *****************");
		Reporter.log("***************** LOGOUT FROM ADMIN USER AND LOGIN WITH CONTRACTOR USER *****************");
		log.info("***************** LOGOUT FROM ADMIN USER AND LOGIN WITH CONTRACTOR USER *****************");

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

			helper.loginAndUpdateSystemCompany(data, "username", "password", "system_company_1");

			// VERIFY THE INSPECTION/CHECKLIST DASHBOARD COUNT

			System.out.println("***************** VERIFY THE INSPECTION/CHECKLIST DASHBOARD COUNT *****************");
			test.log(LogStatus.INFO,
					"***************** VERIFY THE INSPECTION/CHECKLIST DASHBOARD COUNT *****************");
			Reporter.log("***************** VERIFY THE INSPECTION/CHECKLIST DASHBOARD COUNT *****************");
			log.info("***************** VERIFY THE INSPECTION/CHECKLIST DASHBOARD COUNT *****************");

			// select the Inspections/Checklists option from the dashboard dropdown
			select("ssc_environmental_dashboarddd_CSS", data.get("inspection_checklist_dd"));
			System.out.println("The Inspections/Checklists option is selected from the dashboard drop down.");
			ngDriver.waitForAngularRequestsToFinish();

			// filter created checklist
			clear("envreports_propertylist_filtertxt_CSS");
			type("envreports_propertylist_filtertxt_CSS", data.get("questionnaire_checklist_title"));
			System.out.println("Entered newly created questionnaire in the filter field.");
			ngDriver.waitForAngularRequestsToFinish();

			try {
				String str1 = driver.findElement(By.xpath("//td[@id='questionnaire-name-0']")).getText();

				if (str1.equals("Test Questionnaire Checklist Dashboard Title")) {
					Assert.assertTrue(
							isElementPresent(By.xpath(OR.getProperty("questionnaire_record_checklistdashboard_XPATH"))),
							"The Test Questionnaire Checklist Dashboard Title is not verified.");

					verificationFailed();

					System.out.println("The " + data.get("questionnaire_checklist_title") + " is displayed.");
					test.log(LogStatus.INFO, "The " + data.get("questionnaire_checklist_title") + " is displayed.");
					Reporter.log("The " + data.get("questionnaire_checklist_title") + " is displayed.");
					log.info("The " + data.get("questionnaire_checklist_title") + " is displayed.");

				}
			} catch (Throwable t) {

				System.out
						.println("The " + data.get("questionnaire_checklist_title") + " is not displayed as expected.");
				test.log(LogStatus.INFO,
						"The " + data.get("questionnaire_checklist_title") + " is not displayed as expected.");
				Reporter.log("The " + data.get("questionnaire_checklist_title") + " is not displayed as expected.");
				log.info("The " + data.get("questionnaire_checklist_title") + " is not displayed as expected.");

			}

			// LOGOUT FROM CONTRACTOR USER AND LOGIN WITH ADMIN USER

			System.out.println(
					"***************** LOGOUT FROM CONTRACTOR USER AND LOGIN WITH ADMIN USER *****************");
			test.log(LogStatus.INFO,
					"***************** LOGOUT FROM CONTRACTOR USER AND LOGIN WITH ADMIN USER *****************");
			Reporter.log("***************** LOGOUT FROM CONTRACTOR USER AND LOGIN WITH ADMIN USER *****************");
			log.info("***************** LOGOUT FROM CONTRACTOR USER AND LOGIN WITH ADMIN USER *****************");

			// wait for the element
			Thread.sleep(5000);

			// click on the settings icon from the top of the screen
			click("questionnaire_settingicon_userupdate_CSS");
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

		// DELETE THE NEWLY CREATED INSTANCE

		System.out.println("***************** DELETE THE NEWLY CREATED INSTANCE *****************");
		test.log(LogStatus.INFO, "***************** DELETE THE NEWLY CREATED INSTANCE *****************");
		Reporter.log("***************** DELETE THE NEWLY CREATED INSTANCE *****************");
		log.info("***************** DELETE THE NEWLY CREATED INSTANCE *****************");

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
			type("checklist_filtertxt_CSS", data.get("checklist_property_title"));
			System.out.println("Entered the newly created instance name in the filter field.");
			ngDriver.waitForAngularRequestsToFinish();

			// click on the action icon
			click("checklist_actionicon_CSS");
			System.out.println("Clicked on the action icon.");
			ngDriver.waitForAngularRequestsToFinish();

			// click on the delete option
			click("checklist_deleteoption_CSS");
			System.out.println("Clicked on the delete option.");
			ngDriver.waitForAngularRequestsToFinish();

			// wait for the element
			explicitWaitClickable("checklist_deletebtn_CSS");

			// click on the delete button of the confirmation popup model.
			click("checklist_deletebtn_CSS");
			System.out.println("Clicked on the delete button of the confirmation popup model.");
			ngDriver.waitForAngularRequestsToFinish();

			// clear the data from the filter field.
			clear("checklist_filtertxt_CSS");
			type("checklist_filtertxt_CSS", data.get("checklist_property_title"));
			System.out.println("Entered the newly created instance name in the filter field.");
			ngDriver.waitForAngularRequestsToFinish();

			try {
				String str2 = driver.findElement(By.xpath("//td[@id='questionnaire-name-0']")).getText();

				if (str2.equals("Test Questionnaire Checklist Dashboard Title")) {

					verificationFailed();

					System.out.println("The " + data.get("questionnaire_checklist_title") + " is displayed.");
					test.log(LogStatus.INFO, "The " + data.get("questionnaire_checklist_title") + " is displayed.");
					Reporter.log("The " + data.get("questionnaire_checklist_title") + " is displayed.");
					log.info("The " + data.get("questionnaire_checklist_title") + " is displayed.");
				}
			} catch (Throwable t) {

				System.out.println("The " + data.get("questionnaire_checklist_title")
						+ " is not displayed as per the expected result.");
				test.log(LogStatus.INFO, "The " + data.get("questionnaire_checklist_title")
						+ " is not displayed as per the expected result.");
				Reporter.log("The " + data.get("questionnaire_checklist_title")
						+ " is not displayed as per the expected result.");
				log.info("The " + data.get("questionnaire_checklist_title")
						+ " is not displayed as per the expected result.");

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

		// DELETE THE ADDED QUESTIONNAIRE

		System.out.println("***************** DELETE THE ADDED QUESTIONNAIRE *****************");
		test.log(LogStatus.INFO, "***************** DELETE THE ADDED QUESTIONNAIRE *****************");
		Reporter.log("***************** DELETE THE ADDED QUESTIONNAIRE *****************");
		log.info("***************** DELETE THE ADDED QUESTIONNAIRE *****************");

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

			// verify newly created questionnaire for checklist
			switchVerification("questionnaire_record_checklistdashboard_XPATH",
					"Test Questionnaire Checklist Dashboard Title",
					"The Test Questionnaire Checklist Dashboard Title record is not displayed in the questionnaire list.");

			// click on the created questionnaire
			click("questionnaire_record_checklistdashboard_XPATH");
			System.out.println("Clicked on the newly created questionnaire.");
			ngDriver.waitForAngularRequestsToFinish();

			// scroll till the delete button
			WebElement element5 = driver.findElement(By.cssSelector(OR.getProperty("questionnaire_warrantybtn_CSS")));
			JavascriptExecutor js = (JavascriptExecutor) driver;

			js.executeScript("arguments[0].scrollIntoView();", element5);

			// click on the delete button
			click("questionnaire_deletebtn_CSS");
			System.out.println("Clicked on the delete button.");
			ngDriver.waitForAngularRequestsToFinish();

			// click on the delete button of the confirmation popup
			click("questionnaire_modeldeletebtn_CSS");
			System.out.println("Clicked on the delete button of the confirmation popup.");
			ngDriver.waitForAngularRequestsToFinish();

			// enter newly created questionnaire in the filter field
			clear("ssc_company2_questionnairelist_filtertxt_CSS");
			type("ssc_company2_questionnairelist_filtertxt_CSS", data.get("questionnaire_checklist_title"));
			System.out.println("Entered newly created questionnaire in the filter field.");
			ngDriver.waitForAngularRequestsToFinish();

			helper.deleteVerification("questionnaire_record_checklistdashboard_XPATH",
					"Test Questionnaire Checklist Dashboard Title");

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
