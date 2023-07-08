package testcases.E2Etestcasesuite.surveychecklistmodule;

import java.io.IOException;
import java.util.Hashtable;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.testng.Reporter;
import org.testng.SkipException;
import org.testng.annotations.Test;

import com.relevantcodes.extentreports.LogStatus;

import base.Helper;
import base.TestBase;
import utilities.TestUtil;

public class RR3899SurveyChecklistTest extends TestBase {

	@Test(dataProviderClass = TestUtil.class, dataProvider = "dp")
	public void rR3899SurveyChecklistTest(Hashtable<String, String> data) throws IOException, InterruptedException {

		execution(data, "rR3899SurveyChecklistTest");

		// CREATE THE SURVEY AND CHECKLIST ON BUILDING LEVEL (IN WHICH BUILDING IS NOT
		// AVAILABLE IN RESPECTIVE PROPERTY) AND VERIFY THE BUILDING LEVEL SURVEY IN THE
		// PROPERTY LEVEL

		System.out.println(
				"CREATE THE SURVEY AND CHECKLIST ON BUILDING LEVEL (IN WHICH BUILDING IS NOT AVAILABLE IN RESPECTIVE PROPERTY) AND VERIFY THE BUILDING LEVEL SURVEY IN THE PROPERTY LEVEL");
		test.log(LogStatus.INFO,
				"CREATE THE SURVEY AND CHECKLIST ON BUILDING LEVEL (IN WHICH BUILDING IS NOT AVAILABLE IN RESPECTIVE PROPERTY) AND VERIFY THE BUILDING LEVEL SURVEY IN THE PROPERTY LEVEL");
		Reporter.log(
				"CREATE THE SURVEY AND CHECKLIST ON BUILDING LEVEL (IN WHICH BUILDING IS NOT AVAILABLE IN RESPECTIVE PROPERTY) AND VERIFY THE BUILDING LEVEL SURVEY IN THE PROPERTY LEVEL");
		log.info(
				"CREATE THE SURVEY AND CHECKLIST ON BUILDING LEVEL (IN WHICH BUILDING IS NOT AVAILABLE IN RESPECTIVE PROPERTY) AND VERIFY THE BUILDING LEVEL SURVEY IN THE PROPERTY LEVEL");

		Helper helper = new Helper();
		
		// refresh the page
		driver.navigate().refresh();
		Thread.sleep(5000);
		driver.navigate().refresh();

		System.out.println("Navigate to the Home Screen i.e. Property List Screen.");

		// ADD NEW QUESTIONNIRE AT BUILDING LEVEL

		System.out.println("***************** ADD NEW QUESTIONNIRE AT BUILDING LEVEL *****************");
		test.log(LogStatus.INFO, "***************** ADD NEW QUESTIONNIRE AT BUILDING LEVEL *****************");
		Reporter.log("***************** ADD NEW QUESTIONNIRE AT BUILDING LEVEL *****************");
		log.info("***************** ADD NEW QUESTIONNIRE AT BUILDING LEVEL *****************");

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

			// Select the type of the questionnaire
			click("questionnaire_type_propertybtn_CSS");
			System.out.println("The type of the questionnire is selected.");

			// Select the level of the questionnaire
			click("questionnaire_level_buildingbtn_CSS");
			System.out.println("The level of the questionnire is selected.");

			// enter the group title
			type("questionnaire_grouptitletxt_CSS", data.get("group_title"));
			System.out.println("The data entered in the Group Title field.");

			// enter the questionnaire title
			type("questionnaire_languagetitle_CSS", data.get("questionnaire_building_title"));
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

			// enter the year
			type("questionnaire_yeartxt_CSS", "2020");
			System.out.println("The data entered in the year field.");
			ngDriver.waitForAngularRequestsToFinish();

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

			// click on the save button
			click("questionnaire_savebtn_BTNTEXT");
			System.out.println("Clicked on the save button");
			ngDriver.waitForAngularRequestsToFinish();
			System.out.println("Navigate to the list of questionnaire screen.");

			// enter newly created questionnaire in the filter field
			type("ssc_company2_questionnairelist_filtertxt_CSS", data.get("questionnaire_building_title"));
			System.out.println("Entered newly created questionnaire in the filter field.");
			ngDriver.waitForAngularRequestsToFinish();

			// verify newly created questionnaire for survey
			switchVerification("questionnaire_buildingonly_record1_XPATH", "Test Questionnaire Building Only Title",
					"The Test Questionnaire Building Title record is not displayed in the questionnaire list.");

			// CONFIGRATION OF QUESTION

			System.out.println("***************** CONFIGRATION OF QUESTION *****************");
			test.log(LogStatus.INFO, "***************** CONFIGRATION OF QUESTION *****************");
			Reporter.log("***************** CONFIGRATION OF QUESTION *****************");
			log.info("***************** CONFIGRATION OF QUESTION *****************");

			// click on the created questionnaire
			click("questionnaire_buildingonly_record1_XPATH");
			System.out.println("Clicked on the newly created questionnaire.");
			ngDriver.waitForAngularRequestsToFinish();

			helper.configureQuestions(data);

			// wait for the element
			explicitWait("ssc_company2_questionnairelist_filtertxt_CSS");

			// enter newly created questionnaire in the filter field
			clear("ssc_company2_questionnairelist_filtertxt_CSS");
			ngDriver.waitForAngularRequestsToFinish();
			type("ssc_company2_questionnairelist_filtertxt_CSS", data.get("questionnaire_building_title"));
			System.out.println("Entered newly created questionnaire in the filter field.");
			ngDriver.waitForAngularRequestsToFinish();

			// verify newly created questionnaire for survey
			switchVerification("questionnaire_buildingonly_record1_XPATH", "Test Questionnaire Building Only Title",
					"The Test Questionnaire Building Only Title record is not displayed in the questionnaire list.");

		} catch (Throwable t) {
			System.out.println("The newly created questionnaire is not displayed.");
			test.log(LogStatus.INFO, "The newly created questionnaire is not displayed.");
			Reporter.log("The newly created questionnaire is not displayed.");
			log.info("The newly created questionnaire is not displayed.");

			verificationFailed();
		}

		// CREATE THE CHECKLIST IN THE BUILDING LEVELS

		System.out.println("***************** CREATE THE CHECKLIST IN THE BUILDING LEVELS *****************");
		test.log(LogStatus.INFO, "***************** CREATE THE CHECKLIST IN THE BUILDING LEVELS *****************");
		Reporter.log("***************** CREATE THE CHECKLIST IN THE BUILDING LEVELS *****************");
		log.info("***************** CREATE THE CHECKLIST IN THE BUILDING LEVELS *****************");

		try {
			// click on the new questionnaire
			click("questionnaire_newquestionnairebtn_CSS");
			System.out.println("Click on the New Questionnire button");
			ngDriver.waitForAngularRequestsToFinish();
			System.out.println("Navigate to the add questionnire details screen.");

			// Select the Inspection / Checklist of the questionnaire
			click("questionnaire_type_inspectionbtn_CSS");
			ngDriver.waitForAngularRequestsToFinish();
			System.out.println("The type of the questionnire is selected.");

			// Select the level of the questionnaire
			click("questionnaire_level_buildingbtn_CSS");
			ngDriver.waitForAngularRequestsToFinish();
			System.out.println("The level of the questionnire is selected.");

			// enter the group title
			type("questionnaire_grouptitletxt_CSS", data.get("group_title"));
			ngDriver.waitForAngularRequestsToFinish();
			System.out.println("The data entered in the Group Title field.");

			// enter the questionnaire title
			type("questionnaire_languagetitle_CSS", data.get("questionnaire_building_checklist_title"));
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

			// scroll down the screen
			JavascriptExecutor js = (JavascriptExecutor) driver;
			js.executeScript("window.scrollBy(0,600)");

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
			type("ssc_company2_questionnairelist_filtertxt_CSS", data.get("questionnaire_building_checklist_title"));
			System.out.println("Entered newly created questionnaire in the filter field.");
			ngDriver.waitForAngularRequestsToFinish();

			// verify newly created questionnaire for checklist
			switchVerification("questionnaire_record4_XPATH", "Test Questionnaire Building Checklist Only Title",
					"The Test Questionnaire Property Checklist Only Title record is not displayed in the questionnaire list.");

			// CONFIGRATION OF QUESTION

			System.out.println("***************** CONFIGRATION OF QUESTION *****************");
			test.log(LogStatus.INFO, "***************** CONFIGRATION OF QUESTION *****************");
			Reporter.log("***************** CONFIGRATION OF QUESTION *****************");
			log.info("***************** CONFIGRATION OF QUESTION *****************");

			// click on the created questionnaire
			click("questionnaire_record4_XPATH");
			System.out.println("Clicked on the newly created questionnaire for checklist.");
			ngDriver.waitForAngularRequestsToFinish();

			helper.configureQuestions(data);

			// enter newly created questionnaire in the filter field
			clear("ssc_company2_questionnairelist_filtertxt_CSS");
			ngDriver.waitForAngularRequestsToFinish();
			type("ssc_company2_questionnairelist_filtertxt_CSS", data.get("questionnaire_building_checklist_title"));
			System.out.println("Entered newly created questionnaire in the filter field.");
			ngDriver.waitForAngularRequestsToFinish();

			// verify newly created questionnaire for checklist
			switchVerification("questionnaire_record4_XPATH", "Test Questionnaire Building Checklist Only Title",
					"The Test Checklist Questionnaire Only Title record is not displayed in the questionnaire list.");

		} catch (Throwable t) {
			System.out.println("The newly created questionnaire is not displayed.");
			test.log(LogStatus.INFO, "The newly created questionnaire is not displayed.");
			Reporter.log("The newly created questionnaire is not displayed.");
			log.info("The newly created questionnaire is not displayed.");

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

		// VERIFY THE SURVEY IN THE PROPERTY LEVEL

		System.out.println("***************** VERIFY THE SURVEY IN THE PROPERTY LEVEL *****************");
		test.log(LogStatus.INFO, "***************** VERIFY THE SURVEY IN THE PROPERTY LEVEL *****************");
		Reporter.log("***************** VERIFY THE SURVEY IN THE PROPERTY LEVEL *****************");
		log.info("***************** VERIFY THE SURVEY IN THE PROPERTY LEVEL *****************");

		try {

			// wait for the element
			Thread.sleep(5000);

			// search the correct property to perform the survey and checklist
			clear("ssc_company2_propertylist_filtertxt_CSS");
			type("ssc_company2_propertylist_filtertxt_CSS", data.get("property_only_name"));
			System.out.println("Searched the correct property to perform the survey and checklist.");
			ngDriver.waitForAngularRequestsToFinish();

			// click on the environmental icon from the property list page
			click("property_only_environmentalicon_CSS");
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

			// select the property level from the dropdown
			select("survey_leveldropdown_CSS", data.get("property_leveldropdown"));
			System.out.println("Selected the property level from the dropdown.");
			ngDriver.waitForAngularRequestsToFinish();

			// select the respective questionnaire from the dropdown
			select("survey_questionnairedd_CSS", data.get("questionnaire_building_title"));
			System.out.println("The questionnaire selected successfully.");
			ngDriver.waitForAngularRequestsToFinish();

			// verify questionnaire is selected correctly or not
			switchVerification("questionnaire_questiontitle_XPATH", "Test Category Title One",
					"The Test Category Title One is not displayed.");

			// VERIFY THE CHECKLIST IN THE PROPERTY LEVEL

			// wait for the element
			Thread.sleep(5000);

			// click on the side burger menu from top of the screen
			click("ssc_leftsidemenubtn_CSS");
			System.out.println("Clicked on the side burger menu from top of the screen.");
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

			// click on the new checklist button
			click("checklist_newchecklistbtn_CSS");
			System.out.println("Clicked on the new checklist button.");
			ngDriver.waitForAngularRequestsToFinish();

			// wait for the element
			explicitWait("checklist_addchecklist_checklisttypedd_CSS");

			// select the questionnaire option from the checklist type dropdown
			select("checklist_addchecklist_checklisttypedd_CSS", data.get("questionnaire_building_checklist_title"));
			System.out.println("The created questionaaire is selected from the checklist type dropdown.");
			ngDriver.waitForAngularRequestsToFinish();

			// enter data in the checklist title field
			type("checklist_addchecklist_titletxt_CSS", data.get("checklist_building_title"));
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

		// DELETE THE QUESTIONNAIRES WHICH ARE CREATED ON BUILDING LEVELS

		System.out.println(
				"***************** DELETE THE QUESTIONNAIRES WHICH ARE CREATED ON BUILDING LEVELS *****************");
		test.log(LogStatus.INFO,
				"***************** DELETE THE QUESTIONNAIRES WHICH ARE CREATED ON BUILDING LEVELS *****************");
		Reporter.log(
				"***************** DELETE THE QUESTIONNAIRES WHICH ARE CREATED ON BUILDING LEVELS *****************");
		log.info("***************** DELETE THE QUESTIONNAIRES WHICH ARE CREATED ON BUILDING LEVELS *****************");

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

			// enter newly created questionnaire for the survey in the filter field
			clear("ssc_company2_questionnairelist_filtertxt_CSS");
			ngDriver.waitForAngularRequestsToFinish();
			type("ssc_company2_questionnairelist_filtertxt_CSS", data.get("questionnaire_building_title"));
			System.out.println("Entered newly created questionnaire for the survey in the filter field.");
			ngDriver.waitForAngularRequestsToFinish();

			// click on the newly created questionnaire on the property level
			click("questionnaire_buildingonly_record1_XPATH");
			System.out.println("Clicked on the newly created questionnaire on the building level.");
			ngDriver.waitForAngularRequestsToFinish();

			// scroll till the delete button
			JavascriptExecutor js = (JavascriptExecutor) driver;
			WebElement element5 = driver.findElement(By.cssSelector(OR.getProperty("questionnaire_deletebtn_CSS")));
			js.executeScript("arguments[0].scrollIntoView();", element5);

			// click on the delete button
			click("questionnaire_deletebtn_CSS");
			System.out.println("Clicked on the delete button.");
			ngDriver.waitForAngularRequestsToFinish();

			// click on the delete button of the confirmation popup
			click("questionnaire_modeldeletebtn_CSS");
			System.out.println("Clicked on the delete button of the confirmation popup.");
			ngDriver.waitForAngularRequestsToFinish();

			// verify questionnaire is deleted or not
			switchVerification("questionnaire_questionnaireadminlbl_XPATH", "Questionnaire Administration",
					"The Questionnaire Administration label is not displayed.");

			// enter newly created questionnaire on property level in the filter field
			clear("ssc_company2_questionnairelist_filtertxt_CSS");
			ngDriver.waitForAngularRequestsToFinish();
			type("ssc_company2_questionnairelist_filtertxt_CSS", data.get("questionnaire_building_checklist_title"));
			System.out.println("Entered newly created questionnaire on building level in the filter field.");
			ngDriver.waitForAngularRequestsToFinish();

			// click on the newly created questionnaire on the property level
			click("questionnaire_record4_XPATH");
			System.out.println("Clicked on the newly created questionnaire on the building level.");
			ngDriver.waitForAngularRequestsToFinish();

			// scroll till the delete button
			WebElement element6 = driver.findElement(By.cssSelector(OR.getProperty("questionnaire_deletebtn_CSS")));
			js.executeScript("arguments[0].scrollIntoView();", element6);

			// click on the delete button
			click("questionnaire_deletebtn_CSS");
			System.out.println("Clicked on the delete button.");
			ngDriver.waitForAngularRequestsToFinish();

			// click on the delete button of the confirmation popup
			click("questionnaire_modeldeletebtn_CSS");
			System.out.println("Clicked on the delete button of the confirmation popup.");
			ngDriver.waitForAngularRequestsToFinish();

			// verify questionnaire is deleted or not
			switchVerification("questionnaire_questionnaireadminlbl_XPATH", "Questionnaire Administration",
					"The Questionnaire Administration label is not displayed.");

		} catch (Throwable t) {
			System.out.println("The newly created questionnaire is not displayed.");
			test.log(LogStatus.INFO, "The newly created questionnaire is not displayed.");
			Reporter.log("The newly created questionnaire is not displayed.");
			log.info("The newly created questionnaire is not displayed.");

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