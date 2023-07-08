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

public class RR3932SurveyChecklistTwoTest extends TestBase {

	@Test(dataProviderClass = TestUtil.class, dataProvider = "dp")
	public void rR3932SurveyChecklistTwoTest(Hashtable<String, String> data) throws IOException, InterruptedException {

		execution(data, "rR3932SurveyChecklistTwoTest");

		// CREATE THE CHECKLIST IN PROPERTY AND SELECT THE MULTIPLE ACTIVE INSTANT PER
		// SITE PERMISSION

		System.out
				.println("CREATE THE CHECKLIST IN PROPERTY AND SELECT THE MULTIPLE ACTIVE INSTANT PER SITE PERMISSION");
		test.log(LogStatus.INFO,
				"CREATE THE CHECKLIST IN PROPERTY AND SELECT THE MULTIPLE ACTIVE INSTANT PER SITE PERMISSION");
		Reporter.log("CREATE THE CHECKLIST IN PROPERTY AND SELECT THE MULTIPLE ACTIVE INSTANT PER SITE PERMISSION");
		log.info("CREATE THE CHECKLIST IN PROPERTY AND SELECT THE MULTIPLE ACTIVE INSTANT PER SITE PERMISSION");

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

			// click on the Multiple Active Instances Per Site checklist
			click("questionnaire_activeinstancebtn_CSS");
			System.out.println("Clicked on the Multiple Active Instances Per Site checklist.");
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
			type("ssc_company2_questionnairelist_filtertxt_CSS", data.get("questionnaire_checklist_title"));
			System.out.println("Entered newly created questionnaire in the filter field.");
			ngDriver.waitForAngularRequestsToFinish();

			// verify newly created questionnaire for checklist
			switchVerification("questionnaire_record15_XPATH",
					"Questionnaire Property Checklist Multiple Active Instant Title",
					"The Questionnaire Property Checklist Multiple Active Instant Title record is not displayed in the questionnaire list.");

			// CONFIGRATION OF QUESTION

			System.out.println("***************** CONFIGRATION OF QUESTION *****************");
			test.log(LogStatus.INFO, "***************** CONFIGRATION OF QUESTION *****************");
			Reporter.log("***************** CONFIGRATION OF QUESTION *****************");
			log.info("***************** CONFIGRATION OF QUESTION *****************");

			// click on the created questionnaire
			click("questionnaire_record15_XPATH");
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
			switchVerification("questionnaire_record15_XPATH",
					"Questionnaire Property Checklist Multiple Active Instant Title",
					"The Questionnaire Property Checklist Multiple Active Instant Title record is not displayed in the questionnaire list.");

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

			// wait for the element
			explicitWait("questionnaire_questiontitle_XPATH");

			// verify questionnaire is selected correctly or not
			switchVerification("questionnaire_questiontitle_XPATH", "Test Category Title One",
					"The Test Category Title One is not displayed.");

			// click on the back button of the checklist preview mode
			click("checklist_backbtn_CSS");
			System.out.println("Clicked on the back button of the checklist preview mode.");
			ngDriver.waitForAngularRequestsToFinish();

			// CREATE THE CHECKLIST SECOND TIME

			System.out.println("***************** CREATE THE CHECKLIST SECOND TIME *****************");
			test.log(LogStatus.INFO, "***************** CREATE THE CHECKLIST SECOND TIME *****************");
			Reporter.log("***************** CREATE THE CHECKLIST SECOND TIME *****************");
			log.info("***************** CREATE THE CHECKLIST SECOND TIME *****************");

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

			// wait for the element
			Thread.sleep(5000);

			// verify the instance already created text is displayed or not
			String str3 = driver.findElement(By.xpath(
					"//div[@class='text-center text-danger modal-error' and text()='This inspection only allows single active instance but an active instance already exists']"))
					.getText();

			if (str3.equals(
					"This inspection only allows single active instance but an active instance already exists")) {

				System.out.println(
						"The This inspection only allows single active instance but an active instance already exists text is verified successfully.");
				test.log(LogStatus.INFO,
						"The This inspection only allows single active instance but an active instance already exists text is verified successfully.");
				Reporter.log(
						"The This inspection only allows single active instance but an active instance already exists is verified successfully.");
				log.info(
						"The This inspection only allows single active instance but an active instance already exists text is verified successfully.");
			} else {
				verificationFailed();
			}

			// click on the close button for close the add checklist popup model
			click("checklist_addchecklist_cancelbtn_XPATH");
			System.out.println("Clicked on the close button for close the add checklist popup model.");
			ngDriver.waitForAngularRequestsToFinish();

			// enter the newly created instance name in the filter field
			clear("checklist_filtertxt_CSS");
			type("checklist_filtertxt_CSS", data.get("checklist_property_title"));
			System.out.println("Entered the newly created instance name in the filter field.");
			ngDriver.waitForAngularRequestsToFinish();

			// click on the filtered instant
			click("questionnaire_record15_XPATH");
			System.out.println("Clicked on the filtered instant.");
			ngDriver.waitForAngularRequestsToFinish();

			// click on the yes checkbox
			click("checklist_category_1_question_1_yesbtn_CSS");
			System.out.println("Clicked on the yes checkbox.");
			ngDriver.waitForAngularRequestsToFinish();

			// enter value in the text field
			type("checklist_category_1_question_1_option_1_textfield_CSS", data.get("checklist_textfield_question"));
			System.out.println("Entered the data in the text field.");
			ngDriver.waitForAngularRequestsToFinish();

			// click on the no checkbox
			click("survey_noanswerbtn_2_CSS");
			System.out.println("Clicked on the no checkbox.");
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
			System.out.println("Clear the data from the filter field.");
			ngDriver.waitForAngularRequestsToFinish();
			type("checklist_filtertxt_CSS", data.get("checklist_property_title"));
			System.out.println("Entered the newly created instance name in the filter field.");
			ngDriver.waitForAngularRequestsToFinish();

			// click on the action icon
			click("checklist_actionicon_CSS");
			System.out.println("Clicked on the action icon.");
			ngDriver.waitForAngularRequestsToFinish();

			// click on the approve option
			click("checklist_approveoption_CSS");
			System.out.println("Clicked on the approve option.");
			ngDriver.waitForAngularRequestsToFinish();

			// click on the approve button of the confirmation popup model.
			click("checklist_approvebtn_CSS");
			System.out.println("Clicked on the approve button of the confirmation popup model.");
			ngDriver.waitForAngularRequestsToFinish();

			// clear the data from the filter field.
			clear("checklist_filtertxt_CSS");
			System.out.println("Clear the data from the filter field.");
			ngDriver.waitForAngularRequestsToFinish();

			// CREATE THE CHECKLIST THIRD TIME

			System.out.println("***************** CREATE THE CHECKLIST THIRD TIME *****************");
			test.log(LogStatus.INFO, "***************** CREATE THE CHECKLIST THIRD TIME *****************");
			Reporter.log("***************** CREATE THE CHECKLIST THIRD TIME *****************");
			log.info("***************** CREATE THE CHECKLIST THIRD TIME *****************");

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

			// wait for the element
			explicitWait("questionnaire_questiontitle_XPATH");

			// verify questionnaire is selected correctly or not
			switchVerification("questionnaire_questiontitle_XPATH", "Test Category Title One",
					"The Test Category Title One is not displayed.");

			// click on the back button of the checklist preview mode
			click("checklist_backbtn_CSS");
			System.out.println("Clicked on the back button of the checklist preview mode.");
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

			// select the property level from the dropdown
			select("survey_leveldropdown_CSS", data.get("property_leveldropdown"));
			System.out.println("Selected the property level from the dropdown.");
			ngDriver.waitForAngularRequestsToFinish();

			// click on the newly created inspection
			String inspection = "//td[text()='" + data.get("questionnaire_checklist_title")
					+ "']//following-sibling::td[@class='text-center pointer']//i[@id='action']";
			driver.findElement(By.xpath(inspection)).click();
			ngDriver.waitForAngularRequestsToFinish();
			System.out.println("Clicked on the newly created inspection.");

			// wait for the element
			Thread.sleep(5000);

			// click on the delete option
			String deleteOption = "//td[text()='" + data.get("questionnaire_checklist_title")
					+ "']//following-sibling::td[@class='text-center pointer']//div[@class='dropdown open']//li[@id='delete']";
			driver.findElement(By.xpath(deleteOption)).click();
			ngDriver.waitForAngularRequestsToFinish();
			System.out.println("Clicked on the delete button.");

			// wait for the element
			Thread.sleep(5000);

			// click on the delete button
			driver.findElement(By.xpath("//button[@ng-click='deleteChecklist()']")).click();
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

		// DELETE THE APPROVED INSPECTION

		System.out.println("***************** DELETE THE APPROVED INSPECTION *****************");
		test.log(LogStatus.INFO, "***************** DELETE THE APPROVED INSPECTION *****************");
		Reporter.log("***************** DELETE THE APPROVED INSPECTION *****************");
		log.info("***************** DELETE THE APPROVED INSPECTION *****************");

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

			// select the approve status from the status dropdown
			select("checklist_statusdd_CSS", data.get("instance_status"));
			ngDriver.waitForAngularRequestsToFinish();
			System.out.println("select the approve status from the status dropdown.");

			// click on the newly created inspection
			String inspection = "//td[text()='" + data.get("questionnaire_checklist_title")
					+ "']//following-sibling::td[@class='text-center pointer']//i[@id='action']";
			driver.findElement(By.xpath(inspection)).click();
			ngDriver.waitForAngularRequestsToFinish();
			System.out.println("Clicked on the newly created inspection.");

			// wait for the element
			Thread.sleep(5000);

			// click on the reopen option
			String deleteOption = "//td[text()='" + data.get("questionnaire_checklist_title")
					+ "']//following-sibling::td[@class='text-center pointer']//div[@class='dropdown open']//li[@id='reopen']";
			driver.findElement(By.xpath(deleteOption)).click();
			ngDriver.waitForAngularRequestsToFinish();
			System.out.println("Clicked on the reopen button.");

			// wait for the element
			Thread.sleep(5000);

			// click on the reopen button
			driver.findElement(By.xpath("//button[@ng-click='unlockChecklistInstance()']")).click();
			ngDriver.waitForAngularRequestsToFinish();
			System.out.println("Clicked on the reopen button.");

			// select the open status from the status dropdown
			select("checklist_statusdd_CSS", data.get("instance_status1"));
			ngDriver.waitForAngularRequestsToFinish();
			System.out.println("select the open status from the status dropdown.");

			// click on the newly created inspection
			String inspection1 = "//td[text()='" + data.get("questionnaire_checklist_title")
					+ "']//following-sibling::td[@class='text-center pointer']//i[@id='action']";
			driver.findElement(By.xpath(inspection1)).click();
			ngDriver.waitForAngularRequestsToFinish();
			System.out.println("Clicked on the newly created inspection.");

			// wait for the element
			Thread.sleep(5000);

			// click on the delete option
			String deleteOption1 = "//td[text()='" + data.get("questionnaire_checklist_title")
					+ "']//following-sibling::td[@class='text-center pointer']//div[@class='dropdown open']//li[@id='delete']";
			driver.findElement(By.xpath(deleteOption1)).click();
			ngDriver.waitForAngularRequestsToFinish();
			System.out.println("Clicked on the delete button.");

			// wait for the element
			Thread.sleep(5000);

			// click on the delete button
			driver.findElement(By.xpath("//button[@ng-click='deleteChecklist()']")).click();
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
			type("ssc_company2_questionnairelist_filtertxt_CSS", data.get("questionnaire_checklist_title"));
			System.out.println("Entered newly created questionnaire in the filter field.");
			ngDriver.waitForAngularRequestsToFinish();

			// click on the created questionnaire
			click("questionnaire_record15_XPATH");
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
