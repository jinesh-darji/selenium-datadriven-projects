package testcases.E2Etestcasesuite.taskmodule;

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

public class RR4274TaskTest extends TestBase {

	@Test(dataProviderClass = TestUtil.class, dataProvider = "dp")
	public void rR4274TaskTest(Hashtable<String, String> data) throws IOException, InterruptedException {

		execution(data, "rR4274TaskTest");

		// ADD THE DETAILS IN ALL THE TABS AND CREATE THE TASK

		System.out.println("ADD THE DETAILS IN ALL THE TABS AND CREATE THE TASK.");
		test.log(LogStatus.INFO, "ADD THE DETAILS IN ALL THE TABS AND CREATE THE TASK.");
		Reporter.log("ADD THE DETAILS IN ALL THE TABS AND CREATE THE TASK.");
		log.info("ADD THE DETAILS IN ALL THE TABS AND CREATE THE TASK.");

		Helper helper = new Helper();

		// refresh the page
		driver.navigate().refresh();
		explicitWait("questionnaire_settingicon_CSS");
		driver.navigate().refresh();

		System.out.println("Navigate to the Home Screen i.e. Property List Screen.");

		// ADD NEW QUESTIONNIRE

		System.out.println("***************** ADD NEW QUESTIONNIRE FOR SURVEY *****************");
		test.log(LogStatus.INFO, "***************** ADD NEW QUESTIONNIRE FOR SURVEY *****************");
		Reporter.log("***************** ADD NEW QUESTIONNIRE FOR SURVEY *****************");
		log.info("***************** ADD NEW QUESTIONNIRE FOR SURVEY *****************");

		try {
			// synchronization
			explicitWait("questionnaire_settingicon_CSS");

			// click on the settings icon from the top of the screen
			click("questionnaire_settingicon_CSS");
			System.out.println("Clicked on the settings icon.");
			ngDriver.waitForAngularRequestsToFinish();

			// synchronization
			explicitWait("questionnaire_administrationoption_XPATH");

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
			switchVerification("questionnaire_createdrecord_detailedtask_XPATH",
					"Test Questionnaire Detailed Task Title", "The newly questionnaire is not created.");

			// ADD NEW QUESTIONNIRE FOR CHECKLIST

			System.out.println("***************** ADD NEW QUESTIONNIRE FOR CHECKLIST *****************");
			test.log(LogStatus.INFO, "***************** ADD NEW QUESTIONNIRE FOR CHECKLIST *****************");
			Reporter.log("***************** ADD NEW QUESTIONNIRE FOR CHECKLIST *****************");
			log.info("***************** ADD NEW QUESTIONNIRE FOR CHECKLIST *****************");

			helper.createChecklistQuestionnaire(data);

			// enter newly created questionnaire in the filter field
			clear("ssc_company2_questionnairelist_filtertxt_CSS");
			ngDriver.waitForAngularRequestsToFinish();
			type("ssc_company2_questionnairelist_filtertxt_CSS", data.get("questionnaire_checklist_title"));
			System.out.println("Entered newly created questionnaire in the filter field.");
			ngDriver.waitForAngularRequestsToFinish();

			// verify newly created questionnaire for checklist
			switchVerification("questionnaire_createdrecord_detailedtask_checklist_XPATH",
					"Test Questionnaire Detailed Task Checklist Title",
					"The Test Questionnaire Detailed Task Checklist Title record is not displayed in the questionnaire list.");

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

		// CREATE THE TASK WITH VALID DETAILS AND SURVEY

		System.out.println("***************** CREATE THE TASK WITH VALID DETAILS AND SURVEY *****************");
		test.log(LogStatus.INFO, "***************** CREATE THE TASK WITH VALID DETAILS AND SURVEY *****************");
		Reporter.log("***************** CREATE THE TASK WITH VALID DETAILS AND SURVEY *****************");
		log.info("***************** CREATE THE TASK WITH VALID DETAILS AND SURVEY *****************");

		try {

			// click on the task icon
			click("taskicon_CSS");
			System.out.println("Clicked on the task icon.");
			ngDriver.waitForAngularRequestsToFinish();

			// click on the add task button
			click("task_addtaskbtn_CSS");
			System.out.println("Clicked on the add task button.");
			ngDriver.waitForAngularRequestsToFinish();

			// enter the data in the task title field
			type("task_addtask_titletxt_CSS", data.get("task_title"));
			System.out.println("Entered the data in the task title field.");
			ngDriver.waitForAngularRequestsToFinish();

			// enter the data in the task location field
			type("task_addtask_locationtxt_CSS", data.get("task_location"));
			System.out.println("Entered the data in the task location field.");
			ngDriver.waitForAngularRequestsToFinish();

			// click on the assign to field
			click("task_assigntotxt_CSS");
			System.out.println("Clicked on the assign to field.");
			ngDriver.waitForAngularRequestsToFinish();

			// click on the none button
			click("task_tasktag_nonebtn_CSS");
			System.out.println("Clicked on the none button.");
			ngDriver.waitForAngularRequestsToFinish();

			// enter the user name in the search field
			type("workflowsecurity_editortask_taskdetails_searchtasktagtxt_CSS", data.get("search_user"));
			System.out.println("Entered the user name in the search field.");
			ngDriver.waitForAngularRequestsToFinish();

			// click on the searched result
			click("questionnaire_createtask_selectusertxt_XPATH");
			System.out.println("Clicked on the searched result.");
			ngDriver.waitForAngularRequestsToFinish();

			// click on the assign to field
			click("task_assigntotxt_CSS");
			System.out.println("Clicked on the assign to field.");
			ngDriver.waitForAngularRequestsToFinish();

			// scroll down the screen
			JavascriptExecutor js = (JavascriptExecutor) driver;
			js.executeScript("window.scrollBy(0,1200)");

			// synchronization
			explicitWait("task_addtask_moduledd_CSS");

			// select the environmental option from the module dropdown
			select("task_addtask_moduledd_CSS", data.get("task_module"));
			System.out.println("Selected the environmental option from the module dropdown.");
			ngDriver.waitForAngularRequestsToFinish();

			// scroll down the screen
			js.executeScript("window.scrollBy(0,-1200)");

			// synchronization
			explicitWait("task_addtask_purchaseordertab_XPATH");

			// ADD DETAILS IN THE PURCHASE ORDER/WARRANTY TAB

			// click on the purchase order/warranty tab
			click("task_addtask_purchaseordertab_XPATH");
			System.out.println("Clicked on the purchase order/warranty tab.");
			ngDriver.waitForAngularRequestsToFinish();

			// click on the warranty checkbox
			click("questionnaire_purchaseordertab_warrantycheckbox_CSS");
			System.out.println("Clicked on the warranty checkbox.");
			ngDriver.waitForAngularRequestsToFinish();

			// click on the po required
			click("questionnaire_purchaseordertab_porequired_CSS");
			System.out.println("Clicked on the po required checkbox.");
			ngDriver.waitForAngularRequestsToFinish();

			// scroll down the screen
			js.executeScript("window.scrollBy(0,400)");

			// click on the po approved
			click("questionnaire_purchaseordertab_poapproved_CSS");
			System.out.println("Clicked on the po approved.");
			ngDriver.waitForAngularRequestsToFinish();

			// enter the data in the po number field
			type("questionnaire_purchaseordertab_ponumber_CSS", data.get("task_ponumber"));
			System.out.println("Entered the data in the po number field.");
			ngDriver.waitForAngularRequestsToFinish();

			// scroll down the screen
			js.executeScript("window.scrollBy(0,500)");

			// click on the approved to proceed
			click("questionnaire_purchaseordertab_approvedtoproceed_CSS");
			System.out.println("Clicked on the approved to proceed.");
			ngDriver.waitForAngularRequestsToFinish();

			// click on the estimate required
			click("questionnaire_purchaseordertab_estimaterequired_CSS");
			System.out.println("Clicked on the estimate required.");
			ngDriver.waitForAngularRequestsToFinish();

			// enter the estimated amount in the field
			type("questionnaire_purchaseordertab_estimateamount_CSS", "1122");
			System.out.println("Enter the estimated amount in the field.");
			ngDriver.waitForAngularRequestsToFinish();

			// ADD DETAILS IN THE SURVEY/CHECKLIST TAB

			// click on the survey/checklist tab
			click("survey_task_surveychecklisttab_XPATH");
			System.out.println("Clicked on the survey/checklist tab.");
			ngDriver.waitForAngularRequestsToFinish();

			// click on the survey radio button of the type
			click("survey_task_surveychecklisttab_surveytype_CSS");
			System.out.println("Clicked on the survey radio button of the type.");
			ngDriver.waitForAngularRequestsToFinish();

			// synchronization
			explicitWait("survey_task_surveychecklisttab_surveytype_questionnaire_CSS");

			// collect all options of the dropdown
			Select dropdown = new Select(driver.findElement(
					By.cssSelector(OR.getProperty("survey_task_surveychecklisttab_surveytype_questionnaire_CSS"))));

			// Get all options
			List<WebElement> dd = dropdown.getOptions();

			// Loop to print one by one
			for (int j = 0; j < dd.size(); j++) {
				String checklist = dd.get(j).getText();
				try {
					if (checklist.equals("Test Questionnaire Detailed Task Title")) {

						// synchronization
						explicitWait("survey_task_surveychecklisttab_surveytype_questionnaire_CSS");

						select("survey_task_surveychecklisttab_surveytype_questionnaire_CSS",
								data.get("questionnaire_title"));
						System.out
								.println(" The " + data.get("questionnaire_title") + " is displayed in the dropdown.");
						test.log(LogStatus.INFO,
								" The " + data.get("questionnaire_title") + " is displayed in the dropdown.");
						Reporter.log(" The " + data.get("questionnaire_title") + " is displayed in the dropdown.");
						log.info(" The " + data.get("questionnaire_title") + " is displayed in the dropdown.");
					}
				} catch (Throwable t) {
					System.out.println("An error is occured while fetching the checklist.");
					log.info("An error is occured while fetching the checklist.");
					TestUtil.captureScreenshot();

					// ReportNG
					Reporter.log("<br>" + " An error is occured while fetching the checklist." + "<br>");
					Reporter.log("<a target=\"_blank\" href=" + TestUtil.screenshotName + "><img src="
							+ TestUtil.screenshotName + " height=200 width=200></img></a>");
					Reporter.log("<br>");
					Reporter.log("<br>");

					// Extent Report
					test.log(LogStatus.FAIL, " An error is occured while fetching the checklist.");
					test.log(LogStatus.FAIL, test.addScreenCapture(TestUtil.screenshotName));
				}
			}

			// click on the save button
			click("survey_task_savebtn_CSS");
			System.out.println("Clicked on the save button.");
			ngDriver.waitForAngularRequestsToFinish();

			// click on the clear button
			click("task_createdtask_clearbtn_XPATH");
			System.out.println("Clicked on the clear button.");
			ngDriver.waitForAngularRequestsToFinish();

			// enter the created task in the search field
			type("task_filter_CSS", data.get("task_title"));
			System.out.println("Entered the created task in the search field.");
			ngDriver.waitForAngularRequestsToFinish();

			// click on the search button
			click("task_createdtask_searchbtn_XPATH");
			System.out.println("Clicked on the search button.");
			ngDriver.waitForAngularRequestsToFinish();

			// verify newly created task is displayed or not
			switchVerification("task_createdtask_detailedtab_XPATH", "Test All Tab Task Title",
					"The Test All Tab Task Title is not displayed.");

		} catch (Throwable t) {
			verificationFailed();
		}

		// UPDATE THE TASK

		System.out.println("***************** UPDATE THE TASK *****************");
		test.log(LogStatus.INFO, "***************** UPDATE THE TASK *****************");
		Reporter.log("***************** UPDATE THE TASK *****************");
		log.info("***************** UPDATE THE TASK *****************");

		try {

			// click on the newly created task
			click("task_createdtask_detailedtab_XPATH");
			System.out.println("Click on the newly created task.");
			ngDriver.waitForAngularRequestsToFinish();

			// update the title of the task
			clear("task_addtask_titletxt_CSS");
			type("task_addtask_titletxt_CSS", data.get("update_task_title"));
			System.out.println("Entered the updated data in the task title.");
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

			// click on the clear button
			click("task_createdtask_clearbtn_XPATH");
			ngDriver.waitForAngularRequestsToFinish();
			System.out.println("Clicked on the clear button.");

			// enter the data in the search field
			type("task_filter_CSS", data.get("update_task_title"));
			System.out.println("Entered the updated task in the search field.");
			ngDriver.waitForAngularRequestsToFinish();

			// click on the search button
			click("task_createdtask_searchbtn_XPATH");
			ngDriver.waitForAngularRequestsToFinish();
			System.out.println("Clicked on the search button.");

			// verify newly created task is displayed or not
			switchVerification("task_updatedtask_detailedtab_XPATH", "Update All Tab Test Task Title",
					"The Update All Tab Test Task Title is not displayed.");

		} catch (Throwable t) {

			verificationFailed();
		}

		// DELETE THE TASK

		System.out.println("***************** DELETE THE TASK *****************");
		test.log(LogStatus.INFO, "***************** DELETE THE TASK *****************");
		Reporter.log("***************** DELETE THE TASK *****************");
		log.info("***************** DELETE THE TASK *****************");

		try {

			// click on the newly created task
			click("task_updatedtask_detailedtab_XPATH");
			System.out.println("Click on the updated task.");
			ngDriver.waitForAngularRequestsToFinish();

			// click on the delete button
			click("task_deletedtaskbtn_CSS");
			System.out.println("Clicked on the delete button.");
			ngDriver.waitForAngularRequestsToFinish();

			// synchronization
			explicitWait("task_deletedtaskbtn_confirmaiton_CSS");

			// click on the delete button of the confirmation popup
			click("task_deletedtaskbtn_confirmaiton_CSS");
			System.out.println("Clicked on the delete button of the confirmation popup.");
			ngDriver.waitForAngularRequestsToFinish();

			// click on the clear button
			click("task_createdtask_clearbtn_XPATH");
			ngDriver.waitForAngularRequestsToFinish();
			System.out.println("Clicked on the clear button.");

			// enter the data in the search field
			type("task_filter_CSS", data.get("update_task_title"));
			System.out.println("Entered the updated data in the search field.");
			ngDriver.waitForAngularRequestsToFinish();

			// click on the search button
			click("task_createdtask_searchbtn_XPATH");
			ngDriver.waitForAngularRequestsToFinish();
			System.out.println("Clicked on the search button.");

			// verify the questionnaire deleted or not

			helper.deleteVerification("task_updatedtask_detailedtab_XPATH", "Update All Tab Test Task Title");

		} catch (Throwable t) {
			verificationFailed();
		}

		// click on the home icon from the top of the screen
		click("questionnaire_homeburgermenubtn_hide_CSS");
		System.out.println("Clicked on the home icon from the top of the screen.");
		ngDriver.waitForAngularRequestsToFinish();

		// synchronization
		explicitWait("propertylist_title_XPATH");

		// verify the property list
		switchVerification("propertylist_title_XPATH", "Property List", "The property list is not displayed.");

		// CREATE THE TASK WITH VALID DETAILS AND CHECKLIST

		System.out.println("***************** CREATE THE TASK WITH VALID DETAILS AND CHECKLIST *****************");
		test.log(LogStatus.INFO,
				"***************** CREATE THE TASK WITH VALID DETAILS AND CHECKLIST *****************");
		Reporter.log("***************** CREATE THE TASK WITH VALID DETAILS AND CHECKLIST *****************");
		log.info("***************** CREATE THE TASK WITH VALID DETAILS AND CHECKLIST *****************");

		try {

			// click on the task icon
			click("taskicon_CSS");
			System.out.println("Clicked on the task icon.");
			ngDriver.waitForAngularRequestsToFinish();

			// click on the add task button
			click("task_addtaskbtn_CSS");
			System.out.println("Clicked on the add task button.");
			ngDriver.waitForAngularRequestsToFinish();

			// enter the data in the task title field
			type("task_addtask_titletxt_CSS", data.get("task_title"));
			System.out.println("Entered the data in the task title field.");
			ngDriver.waitForAngularRequestsToFinish();

			// enter the data in the task location field
			type("task_addtask_locationtxt_CSS", data.get("task_location"));
			System.out.println("Entered the data in the task location field.");
			ngDriver.waitForAngularRequestsToFinish();

			// click on the assign to field
			click("task_assigntotxt_CSS");
			System.out.println("Clicked on the assign to field.");
			ngDriver.waitForAngularRequestsToFinish();

			// click on the none button
			click("task_tasktag_nonebtn_CSS");
			System.out.println("Clicked on the none button.");
			ngDriver.waitForAngularRequestsToFinish();

			// enter the user name in the search field
			type("workflowsecurity_editortask_taskdetails_searchtasktagtxt_CSS", data.get("search_user"));
			System.out.println("Entered the user name in the search field.");
			ngDriver.waitForAngularRequestsToFinish();

			// click on the searched result
			click("questionnaire_createtask_selectusertxt_XPATH");
			System.out.println("Clicked on the searched result.");
			ngDriver.waitForAngularRequestsToFinish();

			// click on the assign to field
			click("task_assigntotxt_CSS");
			System.out.println("Clicked on the assign to field.");
			ngDriver.waitForAngularRequestsToFinish();

			// scroll down the screen
			JavascriptExecutor js = (JavascriptExecutor) driver;
			js.executeScript("window.scrollBy(0,1200)");

			// synchronization
			explicitWait("task_addtask_moduledd_CSS");

			// select the environmental option from the module dropdown
			select("task_addtask_moduledd_CSS", data.get("task_module"));
			System.out.println("Selected the environmental option from the module dropdown.");
			ngDriver.waitForAngularRequestsToFinish();

			// scroll down the screen
			js.executeScript("window.scrollBy(0,-1200)");

			// ADD DETAILS IN THE SURVEY/CHECKLIST TAB

			// click on the survey/checklist tab
			click("survey_task_surveychecklisttab_XPATH");
			System.out.println("Clicked on the survey/checklist tab.");
			ngDriver.waitForAngularRequestsToFinish();

			// click on the checklist radio button of the type
			click("survey_task_surveychecklisttab_checklisttype_CSS");
			System.out.println("Clicked on the checklist radio button of the type.");
			ngDriver.waitForAngularRequestsToFinish();

			// synchronization
			explicitWait("survey_task_surveychecklisttab_surveytype_questionnaire_CSS");

			// collect all options of the dropdown
			Select dropdown1 = new Select(driver.findElement(
					By.cssSelector(OR.getProperty("survey_task_surveychecklisttab_surveytype_questionnaire_CSS"))));

			// Get all options
			List<WebElement> dd1 = dropdown1.getOptions();

			// Loop to print one by one
			for (int j = 0; j < dd1.size(); j++) {
				String checklist1 = dd1.get(j).getText();
				try {
					if (checklist1.equals("Test Questionnaire Detailed Task Checklist Title")) {

						select("survey_task_surveychecklisttab_surveytype_questionnaire_CSS",
								data.get("questionnaire_checklist_title"));
						System.out.println(
								" The " + data.get("questionnaire_checklist_title") + " is displayed in the dropdown.");
						test.log(LogStatus.INFO,
								" The " + data.get("questionnaire_checklist_title") + " is displayed in the dropdown.");
						Reporter.log(
								" The " + data.get("questionnaire_checklist_title") + " is displayed in the dropdown.");
						log.info(
								" The " + data.get("questionnaire_checklist_title") + " is displayed in the dropdown.");
					}
				} catch (Throwable t) {
					System.out.println("An error is occured while fetching the checklist.");
					log.info("An error is occured while fetching the checklist.");
					TestUtil.captureScreenshot();

					// ReportNG
					Reporter.log("<br>" + " An error is occured while fetching the checklist." + "<br>");
					Reporter.log("<a target=\"_blank\" href=" + TestUtil.screenshotName + "><img src="
							+ TestUtil.screenshotName + " height=200 width=200></img></a>");
					Reporter.log("<br>");
					Reporter.log("<br>");

					// Extent Report
					test.log(LogStatus.FAIL, " An error is occured while fetching the checklist.");
					test.log(LogStatus.FAIL, test.addScreenCapture(TestUtil.screenshotName));
				}
			}

			// scroll down the screen
			js.executeScript("window.scrollBy(0,400)");

			// enter the data in the title field
			type("survey_task_surveychecklisttab_checklisttype_titletxt_CSS",
					data.get("questionnaire_checklist_title"));
			System.out.println("Entered the data in the title field.");
			ngDriver.waitForAngularRequestsToFinish();

			// click on the save button
			click("survey_task_savebtn_CSS");
			System.out.println("Clicked on the save button.");
			ngDriver.waitForAngularRequestsToFinish();

			// click on the clear button
			click("task_createdtask_clearbtn_XPATH");
			System.out.println("Clicked on the clear button.");
			ngDriver.waitForAngularRequestsToFinish();

			// enter the created task in the search field
			type("task_filter_CSS", data.get("task_title"));
			System.out.println("Entered the created task in the search field.");
			ngDriver.waitForAngularRequestsToFinish();

			// click on the search button
			click("task_createdtask_searchbtn_XPATH");
			System.out.println("Clicked on the search button.");
			ngDriver.waitForAngularRequestsToFinish();

			// verify newly created task is displayed or not
			switchVerification("task_createdtask_detailedtab_XPATH", "Test All Tab Task Title",
					"The Test All Tab Task Title is not displayed.");

		} catch (Throwable t) {
			verificationFailed();
		}

		// DELETE THE TASK

		System.out.println("***************** DELETE THE TASK *****************");
		test.log(LogStatus.INFO, "***************** DELETE THE TASK *****************");
		Reporter.log("***************** DELETE THE TASK *****************");
		log.info("***************** DELETE THE TASK *****************");

		try {

			// click on the newly created task
			click("task_createdtask_detailedtab_XPATH");
			System.out.println("Click on the updated task.");
			ngDriver.waitForAngularRequestsToFinish();

			// click on the delete button
			click("task_deletedtaskbtn_CSS");
			System.out.println("Clicked on the delete button.");
			ngDriver.waitForAngularRequestsToFinish();

			// synchronization
			explicitWait("task_deletedtaskbtn_confirmaiton_CSS");

			// click on the delete button of the confirmation popup
			click("task_deletedtaskbtn_confirmaiton_CSS");
			System.out.println("Clicked on the delete button of the confirmation popup.");
			ngDriver.waitForAngularRequestsToFinish();

			// enter newly created questionnaire in the filter field
			// click on the clear button
			click("task_createdtask_clearbtn_XPATH");
			ngDriver.waitForAngularRequestsToFinish();
			System.out.println("Clicked on the clear button.");

			// enter the data in the search field
			type("task_filter_CSS", data.get("task_title"));
			System.out.println("Entered the updated data in the search field.");
			ngDriver.waitForAngularRequestsToFinish();

			// click on the search button
			click("task_createdtask_searchbtn_XPATH");
			ngDriver.waitForAngularRequestsToFinish();
			System.out.println("Clicked on the search button.");

			// verify the questionnaire deleted or not

			helper.deleteVerification("task_createdtask_detailedtab_XPATH", "All Tab Test Task Title");

		} catch (Throwable t) {
			verificationFailed();
		}

		// click on the home icon from the top of the screen
		click("questionnaire_homeburgermenubtn_hide_CSS");
		System.out.println("Clicked on the home icon from the top of the screen.");
		ngDriver.waitForAngularRequestsToFinish();

		// synchronization
		explicitWait("propertylist_title_XPATH");

		// verify the property list
		switchVerification("propertylist_title_XPATH", "Property List", "The property list is not displayed.");

		// DELETE THE QUESTIONNAIRE WHICH ARE CREATED ON PROPERTY LEVELS

		System.out.println(
				"***************** DELETE THE QUESTIONNAIRE WHICH ARE CREATED ON PROPERTY LEVELS *****************");
		test.log(LogStatus.INFO,
				"***************** DELETE THE QUESTIONNAIRE WHICH ARE CREATED ON PROPERTY LEVELS *****************");
		Reporter.log(
				"***************** DELETE THE QUESTIONNAIRE WHICH ARE CREATED ON PROPERTY LEVELS *****************");
		log.info("***************** DELETE THE QUESTIONNAIRE WHICH ARE CREATED ON PROPERTY LEVELS *****************");

		try {
			// synchronization
			explicitWait("questionnaire_settingicon_CSS");

			// click on the settings icon from the top of the screen
			click("questionnaire_settingicon_CSS");
			System.out.println("Clicked on the settings icon.");
			ngDriver.waitForAngularRequestsToFinish();

			// synchronization
			explicitWait("questionnaire_administrationoption_XPATH");

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
			type("ssc_company2_questionnairelist_filtertxt_CSS", data.get("questionnaire_title"));
			System.out.println("Entered newly created questionnaire in the filter field.");
			ngDriver.waitForAngularRequestsToFinish();

			// click on the created questionnaire
			click("questionnaire_createdrecord_detailedtask_XPATH");
			System.out.println("Clicked on the newly created questionnaire.");
			ngDriver.waitForAngularRequestsToFinish();

			// scroll till the delete button
			WebElement element5 = driver.findElement(By.cssSelector(OR.getProperty("questionnaire_deletebtn_CSS")));
			JavascriptExecutor js = (JavascriptExecutor) driver;
			js.executeScript("arguments[0].scrollIntoView();", element5);

			// wait for the element
			explicitWaitClickable("questionnaire_deletebtn_CSS");

			// click on the delete button
			click("questionnaire_deletebtn_CSS");
			System.out.println("Clicked on the delete button.");
			ngDriver.waitForAngularRequestsToFinish();

			// wait for the element
			explicitWaitClickable("questionnaire_modeldeletebtn_CSS");

			// click on the delete button of the confirmation popup
			click("questionnaire_modeldeletebtn_CSS");
			System.out.println("Clicked on the delete button of the confirmation popup.");
			ngDriver.waitForAngularRequestsToFinish();

			// enter newly created questionnaire in the filter field
			clear("ssc_company2_questionnairelist_filtertxt_CSS");
			type("ssc_company2_questionnairelist_filtertxt_CSS", data.get("questionnaire_title"));
			System.out.println("Entered newly created questionnaire in the filter field.");
			ngDriver.waitForAngularRequestsToFinish();

			// verify questionnaire is deleted or not

			helper.deleteVerification("questionnaire_createdrecord_detailedtask_XPATH",
					"Test Questionnaire Detailed Task Title");

			// enter newly created questionnaire in the filter field
			clear("ssc_company2_questionnairelist_filtertxt_CSS");
			type("ssc_company2_questionnairelist_filtertxt_CSS", data.get("questionnaire_checklist_title"));
			System.out.println("Entered newly created questionnaire in the filter field.");
			ngDriver.waitForAngularRequestsToFinish();

			// click on the created questionnaire
			click("questionnaire_createdrecord_detailedtask_checklist_XPATH");
			System.out.println("Clicked on the newly created questionnaire.");
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

			// enter newly created questionnaire in the filter field
			clear("ssc_company2_questionnairelist_filtertxt_CSS");
			type("ssc_company2_questionnairelist_filtertxt_CSS", data.get("questionnaire_checklist_title"));
			System.out.println("Entered newly created questionnaire in the filter field.");
			ngDriver.waitForAngularRequestsToFinish();

			// verify questionnaire is deleted or not

			helper.deleteVerification("questionnaire_createdrecord_detailedtask_checklist_XPATH",
					"Test Questionnaire Detailed Task Checklist Title");

		} catch (Throwable t) {
			verificationFailed();

		}

		// click on the home icon from the top of the screen
		click("questionnaire_homeburgermenubtn_CSS");
		System.out.println("Clicked on the home icon from the top of the screen.");
		ngDriver.waitForAngularRequestsToFinish();

		// synchronization
		explicitWait("propertylist_title_XPATH");

		// verify the property list
		switchVerification("propertylist_title_XPATH", "Property List", "The property list is not displayed.");

	}
}
