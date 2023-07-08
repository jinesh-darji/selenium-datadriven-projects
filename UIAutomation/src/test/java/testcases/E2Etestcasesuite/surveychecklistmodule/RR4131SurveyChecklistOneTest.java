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

public class RR4131SurveyChecklistOneTest extends TestBase {

	@Test(dataProviderClass = TestUtil.class, dataProvider = "dp")
	public void rR4131SurveyChecklistOneTest(Hashtable<String, String> data) throws IOException, InterruptedException {

		execution(data, "rR4131SurveyChecklistOneTest");

		// VERIFICATION OF THE JUMP TO SURVEY/CHECKLIST BUTTON WITH SURVEY.

		System.out.println("VERIFICATION OF THE JUMP TO SURVEY/CHECKLIST BUTTON WITH SURVEY.");
		test.log(LogStatus.INFO, "VERIFICATION OF THE JUMP TO SURVEY/CHECKLIST BUTTON WITH SURVEY.");
		Reporter.log("VERIFICATION OF THE JUMP TO SURVEY/CHECKLIST BUTTON WITH SURVEY.");
		log.info("VERIFICATION OF THE JUMP TO SURVEY/CHECKLIST BUTTON WITH SURVEY.");

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
			switchVerification("questionnaire_createdrecordauto_jumpsurvey_XPATH",
					"Test Auto Questionnaire One Jump Survey Title", "The newly questionnaire is not created.");

			// CONFIGRATION OF QUESTION

			System.out.println("***************** CONFIGRATION OF QUESTION *****************");
			test.log(LogStatus.INFO, "***************** CONFIGRATION OF QUESTION *****************");
			Reporter.log("***************** CONFIGRATION OF QUESTION *****************");
			log.info("***************** CONFIGRATION OF QUESTION *****************");

			// click on the created questionnaire
			click("questionnaire_createdrecordauto_jumpsurvey_XPATH");
			System.out.println("Clicked on the newly created questionnaire.");
			ngDriver.waitForAngularRequestsToFinish();

			helper.configureQuestions(data);

			// enter newly created questionnaire in the filter field
			clear("ssc_company2_questionnairelist_filtertxt_CSS");
			ngDriver.waitForAngularRequestsToFinish();
			type("ssc_company2_questionnairelist_filtertxt_CSS", data.get("questionnaire_title"));
			System.out.println("Entered newly created questionnaire in the filter field.");
			ngDriver.waitForAngularRequestsToFinish();

			// verify newly created questionnaire for survey
			switchVerification("questionnaire_createdrecordauto_jumpsurvey_XPATH",
					"Test Auto Questionnaire One Jump Survey Title",
					"The Test Auto Questionnaire One Jump Survey Title record is not displayed in the questionnaire list.");

		} catch (Throwable t) {
			verificationFailed();
		}

		// click on the home menu burger button
		click("questionnaire_homeburgermenubtn_CSS");
		System.out.println("Click on the home burger menu icon.");
		ngDriver.waitForAngularRequestsToFinish();

		// wait for the element
		explicitWait("propertylist_title_XPATH");

		// verify the property list
		switchVerification("propertylist_title_XPATH", "Property List", "The property list is not displayed.");

		// CREATE THE TASK WITH VALID DETAILS

		System.out.println("***************** CREATE THE TASK WITH VALID DETAILS *****************");
		test.log(LogStatus.INFO, "***************** CREATE THE TASK WITH VALID DETAILS *****************");
		Reporter.log("***************** CREATE THE TASK WITH VALID DETAILS *****************");
		log.info("***************** CREATE THE TASK WITH VALID DETAILS *****************");

		try {

			// click on the task icon of the respective property
			click("taskicon_CSS");
			System.out.println("Clicked on the task icon of the respective property.");
			ngDriver.waitForAngularRequestsToFinish();

			// click on the add task button
			click("task_addtaskbtn_CSS");
			System.out.println("Clicked on the add task button.");
			ngDriver.waitForAngularRequestsToFinish();

			// enter the data in the title field
			type("task_addtask_titletxt_CSS", data.get("task_title"));
			System.out.println("Entered the data in the title field.");
			ngDriver.waitForAngularRequestsToFinish();

			// enter the details in the location field
			type("task_locationtxt_CSS", data.get("task_location"));
			ngDriver.waitForAngularRequestsToFinish();
			System.out.println("Entered the details in the location field.");

			// click on the assign to field
			click("task_assigntotxt_CSS");
			System.out.println("Click on the assign to field.");
			ngDriver.waitForAngularRequestsToFinish();

			// Enter data in the find user field
			type("questionnaire_createtask_findusertxt_CSS", data.get("task_find_user"));
			System.out.println("The data entered in the find user field.");
			ngDriver.waitForAngularRequestsToFinish();

			// select the user name from the user list
			click("questionnaire_createtask_selectusertxt_XPATH");
			System.out.println("The user name is selected from the list of users");
			ngDriver.waitForAngularRequestsToFinish();

			// click on the assign to field
			click("task_assigntotxt_CSS");
			System.out.println("Click on the assign to field.");
			ngDriver.waitForAngularRequestsToFinish();

			// scroll down till task template
			JavascriptExecutor js = (JavascriptExecutor) driver;
			js.executeScript("window.scrollBy(0,500)");

			// select the priority
			select("task_addtask_prioritydd_CSS", data.get("priority"));
			System.out.println("Priority is selected.");
			ngDriver.waitForAngularRequestsToFinish();

			// scroll down till task template
			js.executeScript("window.scrollBy(0,500)");

			// select the module
			select("task_addtask_moduledd_CSS", data.get("module"));
			System.out.println("Module is selected.");
			ngDriver.waitForAngularRequestsToFinish();

			// scroll down till task template
			js.executeScript("window.scrollBy(0,-600)");

			// click on the survey/checklist tab
			driver.findElement(By.xpath("//a[text()='Survey/Inspection']")).click();
			System.out.println("Clicked on the survey/checklist tab.");
			ngDriver.waitForAngularRequestsToFinish();

			// scroll down till task template
			js.executeScript("window.scrollBy(0,300)");

			// click on the survey radio button of the type
			click("survey_task_surveychecklisttab_surveytype_CSS");
			System.out.println("Clicked on the survey radio button of the type.");
			ngDriver.waitForAngularRequestsToFinish();

			// wait for the element
			explicitWait("survey_task_surveychecklisttab_surveytype_questionnaire_CSS");

			// select the questionnaire from the dropdown
			select("survey_task_surveychecklisttab_surveytype_questionnaire_CSS", data.get("questionnaire_title"));
			System.out.println("Selected the questionnaire from the dropdown.");
			ngDriver.waitForAngularRequestsToFinish();

			// wait for the element
			explicitWaitClickable("survey_task_savebtn_CSS");

			// click on the save button
			click("survey_task_savebtn_CSS");
			System.out.println("Clicked on the save button.");
			ngDriver.waitForAngularRequestsToFinish();

			// wait for the element
			explicitWaitClickable("closetoastmsg_CSS");

			// click on the toaster close button
			click("closetoastmsg_CSS");
			ngDriver.waitForAngularRequestsToFinish();
			System.out.println("Clicked on the toaster close button.");

		} catch (Throwable t) {
			verificationFailed();
		}

		// click on the home menu burger button
		click("questionnaire_homeburgermenubtn_hide_CSS");
		System.out.println("Click on the home burger menu icon.");
		ngDriver.waitForAngularRequestsToFinish();
		System.out.println("Navigate to the Home Screen i.e. Property List Screen.");

		// wait for the element
		explicitWait("propertylist_title_XPATH");

		// verify the property list
		switchVerification("propertylist_title_XPATH", "Property List", "The property list is not displayed.");

		// UPDATE THE PERMISSION FOR THE PROPERTY MANAGER

		System.out.println("***************** UPDATE THE PERMISSION FOR THE PROPERTY MANAGER *****************");
		test.log(LogStatus.INFO, "***************** UPDATE THE PERMISSION FOR THE PROPERTY MANAGER *****************");
		Reporter.log("***************** UPDATE THE PERMISSION FOR THE PROPERTY MANAGER *****************");
		log.info("***************** UPDATE THE PERMISSION FOR THE PROPERTY MANAGER *****************");

		try {
			// wait for the element
			explicitWaitClickable("questionnaire_settingicon_userupdate_CSS");

			// click on the settings icon from the top of the screen
			click("questionnaire_settingicon_userupdate_CSS");
			System.out.println("Clicked on the settings icon.");
			ngDriver.waitForAngularRequestsToFinish();

			// wait for the element
			explicitWaitClickable("questionnaire_administrationoption_XPATH");

			// click on the Administration option from the side menu
			click("questionnaire_administrationoption_XPATH");
			System.out.println("Clicked on the Administration option from the side menu.");
			ngDriver.waitForAngularRequestsToFinish();

			// click on the Security tab
			click("administration_securitytxt_XPATH");
			System.out.println("Clicked on the Questionnaires tab.");
			ngDriver.waitForAngularRequestsToFinish();

			// click on the Security Settings option
			click("questionnaire_securotysettingsoption_XPATH");
			System.out.println("Clicked on the Questionnaires option.");
			ngDriver.waitForAngularRequestsToFinish();

			// enter the permission name in the search field
			clear("questionnaire_securotysettingsoption_jumptosecuritychecklisttxt_CSS");
			type("questionnaire_securotysettingsoption_jumptosecuritychecklisttxt_CSS", data.get("search_permission"));
			System.out.println("Entered the permission name in the search field.");
			ngDriver.waitForAngularRequestsToFinish();

			// click on the searched permission
			click("questionnaire_securotysettingsoption_jumptosecuritychecklistpermission_CSS");
			System.out.println("Clicked on the searched permission.");

			// click on the system role field
			click("questionnaire_jumptosecuritychecklistpermission_systemrole_CSS");
			System.out.println("Clicked on the system role field.");
			ngDriver.waitForAngularRequestsToFinish();

			// click on the none button
			click("questionnaire_jumptosecuritychecklistpermission_systemrole_nonebtn_CSS");
			System.out.println("Clicked on the none button.");
			ngDriver.waitForAngularRequestsToFinish();

			// enter the role name in the search field
			type("task_filter_findtask_CSS", data.get("role_search"));
			System.out.println("Entered the role name in the search field.");
			ngDriver.waitForAngularRequestsToFinish();

			// click on the searched result
			click("questionnaire_checklist_roletoaccessinstance3_XPATH");
			System.out.println("Clicked on the searched result.");
			ngDriver.waitForAngularRequestsToFinish();

			// click on the system role field
			click("questionnaire_jumptosecuritychecklistpermission_systemrole_CSS");
			System.out.println("Clicked on the system role field.");
			ngDriver.waitForAngularRequestsToFinish();

			// click on the save button
			click("securitysettings_accesssurveychecklist_CSS");
			System.out.println("Clicked on the save button.");
			ngDriver.waitForAngularRequestsToFinish();

			// wait for the element
			explicitWaitClickable("closetoastmsg_CSS");

			// click on the toaster close button
			click("closetoastmsg_CSS");
			ngDriver.waitForAngularRequestsToFinish();
			System.out.println("Clicked on the toaster close button.");

		} catch (Throwable t) {
			verificationFailed();
		}

		// LOGOUT FROM ADMIN USER AND LOGIN WITH PROPERTY MANAGER USER

		System.out.println(
				"***************** LOGOUT FROM ADMIN USER AND LOGIN WITH PROPERTY MANAGER USER *****************");
		test.log(LogStatus.INFO,
				"***************** LOGOUT FROM ADMIN USER AND LOGIN WITH PROPERTY MANAGER USER *****************");
		Reporter.log("***************** LOGOUT FROM ADMIN USER AND LOGIN WITH PROPERTY MANAGER USER *****************");
		log.info("***************** LOGOUT FROM ADMIN USER AND LOGIN WITH PROPERTY MANAGER USER *****************");

		try {
			// wait for the element
			explicitWaitClickable("questionnaire_settingicon_userupdate_CSS");

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

			helper.loginAndUpdateSystemCompany(data, "username", "password", "system_company_1");

			// VERIFY JUMP TO SURVEY/CHECKLIST BUTTON IS WORKING CORRECTLY OR NOT

			System.out.println(
					"***************** VERIFY JUMP TO SURVEY/CHECKLIST BUTTON IS WORKING CORRECTLY OR NOT *****************");
			test.log(LogStatus.INFO,
					"***************** VERIFY JUMP TO SURVEY/CHECKLIST BUTTON IS WORKING CORRECTLY OR NOT *****************");
			Reporter.log(
					"***************** VERIFY JUMP TO SURVEY/CHECKLIST BUTTON IS WORKING CORRECTLY OR NOT *****************");
			log.info(
					"***************** VERIFY JUMP TO SURVEY/CHECKLIST BUTTON IS WORKING CORRECTLY OR NOT *****************");

			try {

				// click on the task icon of the respective property
				click("taskicon_CSS");
				System.out.println("Clicked on the task icon of the respective property.");
				ngDriver.waitForAngularRequestsToFinish();

				// click on the clear button
				click("task_createdtask_clearbtn_XPATH");
				System.out.println("Clicked on the clear button.");
				ngDriver.waitForAngularRequestsToFinish();

				// enter the data in the search field
				type("survey_task_searchfield_CSS", data.get("task_title"));
				System.out.println("Entered the data in the search field.");
				ngDriver.waitForAngularRequestsToFinish();

				// click on the search button
				click("task_createdtask_searchbtn_XPATH");
				System.out.println("Clicked on the search button.");
				ngDriver.waitForAngularRequestsToFinish();

				// verify the task is displayed or not
				switchVerification("task_createdtask_jumpsurvey_XPATH", "Test Task One Jump Survey Title",
						"The Test Task One Jump Survey Title is not displayed.");

				// click on the searched task
				click("task_createdtask_jumpsurvey_XPATH");
				System.out.println("Clicked on the searched task.");
				ngDriver.waitForAngularRequestsToFinish();

				// wait for the element
				Thread.sleep(5000);

				// click on the survey/checklist tab
				driver.findElement(By.xpath("//a[text()='Survey/Inspection']")).click();
				System.out.println("Clicked on the survey/checklist tab.");
				ngDriver.waitForAngularRequestsToFinish();

				// scroll down the screen
				JavascriptExecutor js = (JavascriptExecutor) driver;
				js.executeScript("window.scrollBy(0,200)");

				// wait for the 5 seconds
				Thread.sleep(5000);

				// click on the jump to survey/checklist button
				click("task_createdtask_jumptosurveychecklistbtn_CSS");
				System.out.println("Clicked on the jump to survey/checklist button.");
				ngDriver.waitForAngularRequestsToFinish();

				// wait for the element
				Thread.sleep(10000);

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

			// wait for the element
			explicitWait("propertylist_title_XPATH");

			// verify the property list
			switchVerification("propertylist_title_XPATH", "Property List", "The property list is not displayed.");

			// VERIFY THE INPROGRESS TASK IS DISPLAYED OR NOT

			System.out.println("***************** VERIFY THE INPROGRESS TASK IS DISPLAYED OR NOT *****************");
			test.log(LogStatus.INFO,
					"***************** VERIFY THE INPROGRESS TASK IS DISPLAYED OR NOT *****************");
			Reporter.log("***************** VERIFY THE INPROGRESS TASK IS DISPLAYED OR NOT *****************");
			log.info("***************** VERIFY THE INPROGRESS TASK IS DISPLAYED OR NOT *****************");

			try {
				// click on the task icon of the respective property
				click("taskicon_CSS");
				System.out.println("Clicked on the task icon of the respective property.");
				ngDriver.waitForAngularRequestsToFinish();

				// click on the clear button
				click("task_createdtask_clearbtn_XPATH");
				System.out.println("Clicked on the clear button.");
				ngDriver.waitForAngularRequestsToFinish();

				// enter the data in the search field
				type("survey_task_searchfield_CSS", data.get("task_title"));
				System.out.println("Entered the data in the search field.");
				ngDriver.waitForAngularRequestsToFinish();

				// click on the search button
				click("task_createdtask_searchbtn_XPATH");
				System.out.println("Clicked on the search button.");
				ngDriver.waitForAngularRequestsToFinish();

				String str1 = driver.findElement(By.xpath(OR.getProperty("task_inprogress_filtered_XPATH"))).getText();
				ngDriver.waitForAngularRequestsToFinish();

				if (str1.equals("In Progress")) {
					Assert.assertTrue(isElementPresent(By.xpath(OR.getProperty("task_inprogress_filtered_XPATH"))),
							"The inprogress task is not displayed.");

					System.out.println("The inprogress task is verified successfully.");
					test.log(LogStatus.INFO, "The inprogress task is verified successfully.");
					Reporter.log("The inprogress task is verified successfully.");
					log.info("The inprogress task is verified successfully.");
				} else {
					verificationFailed();
				}
			} catch (Throwable t) {
				verificationFailed();
			}

			// click on the Home button
			click("questionnaire_homeburgermenubtn_hide_CSS");
			System.out.println("Clicked on the home button.");
			ngDriver.waitForAngularRequestsToFinish();

			// wait for the element
			explicitWait("propertylist_title_XPATH");

			// verify the property list
			switchVerification("propertylist_title_XPATH", "Property List", "The property list is not displayed.");

			// LOGOUT FROM PROPERTY MANAGER USER AND LOGIN WITH ADMIN USER

			System.out.println(
					"***************** LOGOUT FROM PROPERTY MANAGER USER AND LOGIN WITH ADMIN USER *****************");
			test.log(LogStatus.INFO,
					"***************** LOGOUT FROM PROPERTY MANAGER USER AND LOGIN WITH ADMIN USER *****************");
			Reporter.log(
					"***************** LOGOUT FROM PROPERTY MANAGER USER AND LOGIN WITH ADMIN USER *****************");
			log.info("***************** LOGOUT FROM PROPERTY MANAGER USER AND LOGIN WITH ADMIN USER *****************");

			// wait for the element
			Thread.sleep(5000);

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
			click("questionnaire_createdrecordauto_jumpsurvey_XPATH");
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
