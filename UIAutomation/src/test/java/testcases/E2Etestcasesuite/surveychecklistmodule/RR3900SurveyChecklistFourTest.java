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

public class RR3900SurveyChecklistFourTest extends TestBase {

	@Test(dataProviderClass = TestUtil.class, dataProvider = "dp")
	public void rR3900SurveyChecklistFourTest(Hashtable<String, String> data) throws IOException, InterruptedException {

		execution(data, "rR3900SurveyChecklistFourTest");

		// CREATE THE CHECKLIST IN PROPERTY AND SELECT THE USER TO DELETE INSTANCES
		// PERMISSION

		System.out.println("CREATE THE CHECKLIST IN PROPERTY AND SELECT THE USER TO DELETE INSTANCES PERMISSION");
		test.log(LogStatus.INFO, "CREATE THE CHECKLIST IN PROPERTY AND SELECT THE USER TO DELETE INSTANCES PERMISSION");
		Reporter.log("CREATE THE CHECKLIST IN PROPERTY AND SELECT THE USER TO DELETE INSTANCES PERMISSION");
		log.info("CREATE THE CHECKLIST IN PROPERTY AND SELECT THE USER TO DELETE INSTANCES PERMISSION");

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
			ngDriver.waitForAngularRequestsToFinish();

			// select the classic option from the default view drop down
			select("questionnaire_checklist_defaultview_CSS", data.get("default_view"));
			System.out.println("Selected the classic option from the default view drop down.");
			ngDriver.waitForAngularRequestsToFinish();

			// scroll down the screen
			JavascriptExecutor js = (JavascriptExecutor) driver;
			js.executeScript("window.scrollBy(0,500)");

			// click on the User to Delete Instance field
			click("questionnaire_checklist_usertodeleteinstance1_CSS");
			System.out.println("Clicked on the User to Delete Instance field.");
			ngDriver.waitForAngularRequestsToFinish();

			// enter the user name in the search field
			type("questionnaire_checklist_usertodeleteinstance2_CSS", data.get("checklist_search_4"));
			System.out.println("Entered the user name in the search field.");
			ngDriver.waitForAngularRequestsToFinish();

			// click on the user name from the searched result
			click("questionnaire_checklist_usertodeleteinstance3_XPATH");
			System.out.println("Clicked on the user name from the searched result.");
			ngDriver.waitForAngularRequestsToFinish();

			// click on the User to Delete Instance field
			click("questionnaire_checklist_usertodeleteinstance1_CSS");
			System.out.println("Clicked on the User to Delete Instance field.");
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
			switchVerification("questionnaire_record12_XPATH", "Questionnaire Property Checklist Access Four Title",
					"The Questionnaire Property Checklist User Access Title record is not displayed in the questionnaire list.");

			// CONFIGRATION OF QUESTION

			System.out.println("***************** CONFIGRATION OF QUESTION *****************");
			test.log(LogStatus.INFO, "***************** CONFIGRATION OF QUESTION *****************");
			Reporter.log("***************** CONFIGRATION OF QUESTION *****************");
			log.info("***************** CONFIGRATION OF QUESTION *****************");

			// click on the created questionnaire
			click("questionnaire_record12_XPATH");
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
			switchVerification("questionnaire_record12_XPATH", "Questionnaire Property Checklist Access Four Title",
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
			System.out.println("Clear the data from the filter field.");
			ngDriver.waitForAngularRequestsToFinish();
			type("checklist_filtertxt_CSS", data.get("checklist_property_title"));
			System.out.println("Entered the newly created instance name in the filter field.");
			ngDriver.waitForAngularRequestsToFinish();

			// click on the action icon
			click("checklist_actionicon_CSS");
			System.out.println("Clicked on the action icon.");
			ngDriver.waitForAngularRequestsToFinish();

			// verify approved option is displayed or not

			try {
				String str2 = driver.findElement(By.cssSelector(OR.getProperty("checklist_deleteoption_CSS")))
						.getText();
				System.out.println(str2);
				String finalStr2 = str2.trim();

				if (finalStr2.equals("Delete")) {

					successMessage("The delete option is displayed as per the expected result.");

				} else {
					verificationFailedMessage("The delete option is not displayed.");
				}
			} catch (Throwable t) {

				verificationFailedMessage("The delete option is not displayed.");

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

				// verify delete option is displayed or not

				try {
					String str4 = driver.findElement(By.cssSelector(OR.getProperty("checklist_deleteoption_CSS")))
							.getText();
					System.out.println(str4);
					if (str4.equals(" Delete")) {
						Assert.assertTrue(
								isElementPresent(By.cssSelector(OR.getProperty("checklist_deleteoption_CSS"))),
								"The delete option is not displayed");

						System.out.println(
								"The verification of the delete option is displayed as per the expected result.");
						test.log(LogStatus.INFO,
								"The verification of the delete option is displayed as per the expected result.");
						Reporter.log("The verification of the delete option is displayed as per the expected result.");
						log.info("The verification of the delete option is displayed as per the expected result.");

					}
				} catch (Throwable t) {

					verificationFailed();

				}

				// click on the delete option
				click("checklist_deleteoption_CSS");
				System.out.println("Clicked on the delete option.");
				ngDriver.waitForAngularRequestsToFinish();

				// click on the delete button of the confirmation popup model.
				click("checklist_deletebtn_CSS");
				System.out.println("Clicked on the delete button of the confirmation popup model.");
				ngDriver.waitForAngularRequestsToFinish();

				// clear the data from the filter field.
				clear("checklist_filtertxt_CSS");
				System.out.println("Clear the data from the filter field.");
				ngDriver.waitForAngularRequestsToFinish();
				type("checklist_filtertxt_CSS", data.get("checklist_property_title"));
				System.out.println("Entered the newly created instance name in the filter field.");
				ngDriver.waitForAngularRequestsToFinish();

				try {
					String str1 = driver.findElement(By.xpath(OR.getProperty("questionnaire_record12_XPATH")))
							.getText();
					ngDriver.waitForAngularRequestsToFinish();

					if (str1.equals("Questionnaire Property Checklist Access Four Title")) {
						Assert.assertTrue(isElementPresent(By.xpath(OR.getProperty("questionnaire_record12_XPATH"))),
								"The Questionnaire Property Checklist Access Four Title is not verified.");

						TestUtil.captureScreenshot();

						// ReportNG
						Reporter.log("<br>" + "Verification failure : " + "<br>");
						Reporter.log("<a target=\"_blank\" href=" + TestUtil.screenshotName + "><img src="
								+ TestUtil.screenshotName + " height=200 width=200></img></a>");
						Reporter.log("<br>");
						Reporter.log("<br>");

						// Extent Report
						test.log(LogStatus.FAIL, " Verification failed with exception : ");
						test.log(LogStatus.FAIL, test.addScreenCapture(TestUtil.screenshotName));

						System.out.println(
								"The " + data.get("questionnaire_checklist_title") + " is not deleted successfully.");
						test.log(LogStatus.INFO,
								"The " + data.get("questionnaire_checklist_title") + " is not deleted successfully.");
						Reporter.log(
								"The " + data.get("questionnaire_checklist_title") + " is not deleted successfully.");
						log.info("The " + data.get("questionnaire_checklist_title") + " is not deleted successfully.");
					}
				} catch (Throwable t) {

					System.out
							.println("The " + data.get("questionnaire_checklist_title") + " is deleted successfully.");
					test.log(LogStatus.INFO,
							"The " + data.get("questionnaire_checklist_title") + " is deleted successfully.");
					Reporter.log("The " + data.get("questionnaire_checklist_title") + " is deleted successfully.");
					log.info("The " + data.get("questionnaire_checklist_title") + " is deleted successfully.");

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
			switchVerification("questionnaire_record12_XPATH", "Questionnaire Property Checklist Access Four Title",
					"The Questionnaire Property Checklist User Access Title record is not displayed in the questionnaire list.");

			// click on the created questionnaire
			click("questionnaire_record12_XPATH");
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
			ngDriver.waitForAngularRequestsToFinish();
			type("ssc_company2_questionnairelist_filtertxt_CSS", data.get("questionnaire_checklist_title"));
			System.out.println("Entered newly created questionnaire in the filter field.");
			ngDriver.waitForAngularRequestsToFinish();

			try {
				String str3 = driver.findElement(By.xpath(OR.getProperty("questionnaire_record12_XPATH"))).getText();
				ngDriver.waitForAngularRequestsToFinish();
				if (str3.equals("Questionnaire Property Checklist Access Four Title")) {

					Assert.assertTrue(isElementPresent(By.xpath(OR.getProperty("questionnaire_record12_XPATH"))),
							"The Questionnaire Property Checklist Access Four Title is not displayed.");

					TestUtil.captureScreenshot();

					// ReportNG
					Reporter.log("<br>" + "Verification failure : " + "<br>");
					Reporter.log("<a target=\"_blank\" href=" + TestUtil.screenshotName + "><img src="
							+ TestUtil.screenshotName + " height=200 width=200></img></a>");
					Reporter.log("<br>");
					Reporter.log("<br>");

					// Extent Report
					test.log(LogStatus.FAIL, " Verification failed with exception : ");
					test.log(LogStatus.FAIL, test.addScreenCapture(TestUtil.screenshotName));

					System.out.println("The questionnaire is not deleted successfully.");
					log.info("The questionnaire is not deleted successfully.");

				}
			} catch (Throwable t) {
				System.out.println("The questionnaire is deleted successfully.");
				test.log(LogStatus.INFO, "The questionnaire is deleted successfully.");
				Reporter.log("The questionnaire is deleted successfully.");
				log.info("The questionnaire is deleted successfully.");
			}
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
