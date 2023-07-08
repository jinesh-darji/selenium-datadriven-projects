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
		title("ADD THE DETAILS IN ALL THE TABS AND CREATE THE TASK");

		Helper helper = new Helper();

		// refresh the page
		driver.navigate().refresh();
		explicitWait("questionnaire_settingicon_CSS");
		driver.navigate().refresh();

		// ADD NEW QUESTIONNIRE
		title("ADD NEW QUESTIONNIRE");

		try {
			// synchronization
			explicitWait("questionnaire_settingicon_CSS");

			// click on the settings icon from the top of the screen
			click("questionnaire_settingicon_CSS");

			// synchronization
			explicitWait("questionnaire_administrationoption_XPATH");

			// click on the Administration option from the side menu
			click("questionnaire_administrationoption_XPATH");

			// click on the Questionnaires tab
			click("questionnaire_questionnairestab_XPATH");

			// click on the Questionnaires option
			click("questionnaire_questionnairesoption_XPATH");

			helper.createSurveyQuestionnaire(data);

			// enter the newly created questionnaire in the search field
			type("ssc_company2_questionnairelist_filtertxt_CSS", data.get("questionnaire_title"));

			// verification of the created questionnaire
			switchVerification("questionnaire_createdrecord_detailedtask_XPATH",
					"Test Questionnaire Detailed Task Title", "The newly questionnaire is not created.");

			// ADD NEW QUESTIONNIRE FOR CHECKLIST
			title("ADD NEW QUESTIONNIRE FOR CHECKLIST");

			helper.createChecklistQuestionnaire(data);

			// enter newly created questionnaire in the filter field
			type("ssc_company2_questionnairelist_filtertxt_CSS", data.get("questionnaire_checklist_title"));

			// verify newly created questionnaire for checklist
			switchVerification("questionnaire_createdrecord_detailedtask_checklist_XPATH",
					"Test Questionnaire Detailed Task Checklist Title",
					"The Test Questionnaire Detailed Task Checklist Title record is not displayed in the questionnaire list.");

		} catch (Throwable t) {
			verificationFailed();
		}

		// click on the home menu burger button
		click("questionnaire_homeburgermenubtn_CSS");

		// wait for the element
		explicitWait("propertylist_title_XPATH");

		// verify the property list
		switchVerification("propertylist_title_XPATH", "Property List", "The property list is not displayed.");

		// CREATE THE TASK WITH VALID DETAILS AND SURVEY
		title("CREATE THE TASK WITH VALID DETAILS AND SURVEY");

		try {

			// click on the task icon
			click("taskicon_CSS");

			// click on the add task button
			click("task_addtaskbtn_CSS");

			// enter the data in the task title field
			type("task_addtask_titletxt_CSS", data.get("task_title"));

			// enter the data in the task location field
			type("task_addtask_locationtxt_CSS", data.get("task_location"));

			// click on the assign to field
			click("task_assigntotxt_CSS");

			// click on the none button
			click("task_tasktag_nonebtn_CSS");

			// enter the user name in the search field
			type("workflowsecurity_editortask_taskdetails_searchtasktagtxt_CSS", data.get("search_user"));

			// click on the searched result
			click("questionnaire_createtask_selectusertxt_XPATH");

			// click on the assign to field
			click("task_assigntotxt_CSS");

			// scroll down the screen
			scrollByPixel(1200);

			// synchronization
			explicitWait("task_addtask_moduledd_CSS");

			// select the environmental option from the module dropdown
			select("task_addtask_moduledd_CSS", data.get("task_module"));

			// scroll down the screen
			scrollByPixel(-1200);

			// synchronization
			explicitWait("task_addtask_purchaseordertab_XPATH");

			// ADD DETAILS IN THE PURCHASE ORDER/WARRANTY TAB
			title("ADD DETAILS IN THE PURCHASE ORDER/WARRANTY TAB");

			// click on the purchase order/warranty tab
			click("task_addtask_purchaseordertab_XPATH");

			// click on the warranty checkbox
			click("questionnaire_purchaseordertab_warrantycheckbox_CSS");

			// click on the po required
			click("questionnaire_purchaseordertab_porequired_CSS");

			// scroll down the screen
			scrollByPixel(400);

			// click on the po approved
			click("questionnaire_purchaseordertab_poapproved_CSS");

			// enter the data in the po number field
			type("questionnaire_purchaseordertab_ponumber_CSS", data.get("task_ponumber"));

			// scroll down the screen
			scrollByPixel(500);

			// click on the approved to proceed
			click("questionnaire_purchaseordertab_approvedtoproceed_CSS");

			// click on the estimate required
			click("questionnaire_purchaseordertab_estimaterequired_CSS");

			// enter the estimated amount in the field
			type("questionnaire_purchaseordertab_estimateamount_CSS", "1122");

			// ADD DETAILS IN THE SURVEY/CHECKLIST TAB
			title("ADD DETAILS IN THE SURVEY/CHECKLIST TAB");

			// click on the survey/checklist tab
			click("survey_task_surveychecklisttab_XPATH");

			// click on the survey radio button of the type
			click("survey_task_surveychecklisttab_surveytype_CSS");

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
						successMessage(" The " + data.get("questionnaire_title") + " is displayed in the dropdown.");
					}
				} catch (Throwable t) {
					verificationFailedMessage("An error is occured while fetching the checklist.");
				}
			}

			// click on the save button
			click("survey_task_savebtn_CSS");

			// click on the clear button
			click("task_createdtask_clearbtn_XPATH");

			// enter the created task in the search field
			type("task_filter_CSS", data.get("task_title"));

			// click on the search button
			click("task_createdtask_searchbtn_XPATH");

			// verify newly created task is displayed or not
			switchVerification("task_createdtask_detailedtab_XPATH", "Test All Tab Task Title",
					"The Test All Tab Task Title is not displayed.");

		} catch (Throwable t) {
			verificationFailed();
		}

		// UPDATE THE TASK
		title("UPDATE THE TASK");

		try {

			// click on the newly created task
			click("task_createdtask_detailedtab_XPATH");

			// update the title of the task
			type("task_addtask_titletxt_CSS", data.get("update_task_title"));

			// click on the update button
			click("survey_task_updatebtn_CSS");

			// wait for the element
			explicitWaitClickable("closetoastmsg_CSS");

			// click on the toaster close button
			click("closetoastmsg_CSS");

			// click on the clear button
			click("task_createdtask_clearbtn_XPATH");

			// enter the data in the search field
			type("task_filter_CSS", data.get("update_task_title"));

			// click on the search button
			click("task_createdtask_searchbtn_XPATH");

			// verify newly created task is displayed or not
			switchVerification("task_updatedtask_detailedtab_XPATH", "Update All Tab Test Task Title",
					"The Update All Tab Test Task Title is not displayed.");

		} catch (Throwable t) {
			verificationFailed();
		}

		// DELETE THE TASK
		title("DELETE THE TASK");

		try {

			// click on the newly created task
			click("task_updatedtask_detailedtab_XPATH");

			// click on the delete button
			click("task_deletedtaskbtn_CSS");

			// synchronization
			explicitWait("task_deletedtaskbtn_confirmaiton_CSS");

			// click on the delete button of the confirmation popup
			click("task_deletedtaskbtn_confirmaiton_CSS");

			// click on the clear button
			click("task_createdtask_clearbtn_XPATH");

			// enter the data in the search field
			type("task_filter_CSS", data.get("update_task_title"));

			// click on the search button
			click("task_createdtask_searchbtn_XPATH");

			// verify the questionnaire deleted or not
			helper.deleteVerification("task_updatedtask_detailedtab_XPATH", "Update All Tab Test Task Title");

		} catch (Throwable t) {
			verificationFailed();
		}

		// click on the home icon from the top of the screen
		click("questionnaire_homeburgermenubtn_hide_CSS");

		// synchronization
		explicitWait("propertylist_title_XPATH");

		// verify the property list
		switchVerification("propertylist_title_XPATH", "Property List", "The property list is not displayed.");

		// CREATE THE TASK WITH VALID DETAILS AND CHECKLIST
		title("CREATE THE TASK WITH VALID DETAILS AND CHECKLIST");

		try {

			// click on the task icon
			click("taskicon_CSS");

			// click on the add task button
			click("task_addtaskbtn_CSS");

			// enter the data in the task title field
			type("task_addtask_titletxt_CSS", data.get("task_title"));

			// enter the data in the task location field
			type("task_addtask_locationtxt_CSS", data.get("task_location"));

			// click on the assign to field
			click("task_assigntotxt_CSS");

			// click on the none button
			click("task_tasktag_nonebtn_CSS");

			// enter the user name in the search field
			type("workflowsecurity_editortask_taskdetails_searchtasktagtxt_CSS", data.get("search_user"));

			// click on the searched result
			click("questionnaire_createtask_selectusertxt_XPATH");

			// click on the assign to field
			click("task_assigntotxt_CSS");

			// scroll down the screen
			scrollByPixel(1200);

			// synchronization
			explicitWait("task_addtask_moduledd_CSS");

			// select the environmental option from the module dropdown
			select("task_addtask_moduledd_CSS", data.get("task_module"));

			// scroll down the screen
			scrollByPixel(-1200);

			// ADD DETAILS IN THE SURVEY/CHECKLIST TAB
			title("ADD DETAILS IN THE SURVEY/CHECKLIST TAB");

			// click on the survey/checklist tab
			click("survey_task_surveychecklisttab_XPATH");

			// click on the checklist radio button of the type
			click("survey_task_surveychecklisttab_checklisttype_CSS");

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
						successMessage(
								" The " + data.get("questionnaire_checklist_title") + " is displayed in the dropdown.");
					}
				} catch (Throwable t) {
					verificationFailedMessage("An error is occured while fetching the checklist.");
				}
			}

			// scroll down the screen
			scrollByPixel(400);

			// enter the data in the title field
			type("survey_task_surveychecklisttab_checklisttype_titletxt_CSS",
					data.get("questionnaire_checklist_title"));

			// click on the save button
			click("survey_task_savebtn_CSS");

			// click on the clear button
			click("task_createdtask_clearbtn_XPATH");

			// enter the created task in the search field
			type("task_filter_CSS", data.get("task_title"));

			// click on the search button
			click("task_createdtask_searchbtn_XPATH");

			// verify newly created task is displayed or not
			switchVerification("task_createdtask_detailedtab_XPATH", "Test All Tab Task Title",
					"The Test All Tab Task Title is not displayed.");

		} catch (Throwable t) {
			verificationFailed();
		}

		// DELETE THE TASK
		title("DELETE THE TASK");

		try {
			// click on the newly created task
			click("task_createdtask_detailedtab_XPATH");

			// click on the delete button
			click("task_deletedtaskbtn_CSS");

			// synchronization
			explicitWait("task_deletedtaskbtn_confirmaiton_CSS");

			// click on the delete button of the confirmation popup
			click("task_deletedtaskbtn_confirmaiton_CSS");

			// enter newly created questionnaire in the filter field
			// click on the clear button
			click("task_createdtask_clearbtn_XPATH");

			// enter the data in the search field
			type("task_filter_CSS", data.get("task_title"));

			// click on the search button
			click("task_createdtask_searchbtn_XPATH");

			// verify the questionnaire deleted or not
			helper.deleteVerification("task_createdtask_detailedtab_XPATH", "All Tab Test Task Title");

		} catch (Throwable t) {
			verificationFailed();
		}

		// click on the home icon from the top of the screen
		click("questionnaire_homeburgermenubtn_hide_CSS");

		// synchronization
		explicitWait("propertylist_title_XPATH");

		// verify the property list
		switchVerification("propertylist_title_XPATH", "Property List", "The property list is not displayed.");

		// DELETE THE QUESTIONNAIRE WHICH ARE CREATED ON PROPERTY LEVELS
		title("DELETE THE QUESTIONNAIRE WHICH ARE CREATED ON PROPERTY LEVELS");

		try {
			// synchronization
			explicitWait("questionnaire_settingicon_CSS");

			// click on the settings icon from the top of the screen
			click("questionnaire_settingicon_CSS");

			// synchronization
			explicitWait("questionnaire_administrationoption_XPATH");

			// click on the Administration option from the side menu
			click("questionnaire_administrationoption_XPATH");

			// click on the Questionnaires tab
			click("questionnaire_questionnairestab_XPATH");

			// click on the Questionnaires option
			click("questionnaire_questionnairesoption_XPATH");

			// enter newly created questionnaire in the filter field
			type("ssc_company2_questionnairelist_filtertxt_CSS", data.get("questionnaire_title"));

			// click on the created questionnaire
			click("questionnaire_createdrecord_detailedtask_XPATH");

			// scroll till the delete button
			scrollTillElement("questionnaire_deletebtn_CSS");

			// wait for the element
			explicitWaitClickable("questionnaire_deletebtn_CSS");

			// click on the delete button
			click("questionnaire_deletebtn_CSS");

			// wait for the element
			explicitWaitClickable("questionnaire_modeldeletebtn_CSS");

			// click on the delete button of the confirmation popup
			click("questionnaire_modeldeletebtn_CSS");

			// enter newly created questionnaire in the filter field
			type("ssc_company2_questionnairelist_filtertxt_CSS", data.get("questionnaire_title"));

			// verify questionnaire is deleted or not
			helper.deleteVerification("questionnaire_createdrecord_detailedtask_XPATH",
					"Test Questionnaire Detailed Task Title");

			// enter newly created questionnaire in the filter field
			type("ssc_company2_questionnairelist_filtertxt_CSS", data.get("questionnaire_checklist_title"));

			// click on the created questionnaire
			click("questionnaire_createdrecord_detailedtask_checklist_XPATH");

			// scroll till the delete button
			scrollTillElement("questionnaire_deletebtn_CSS");

			// click on the delete button
			click("questionnaire_deletebtn_CSS");

			// click on the delete button of the confirmation popup
			click("questionnaire_modeldeletebtn_CSS");

			// enter newly created questionnaire in the filter field
			type("ssc_company2_questionnairelist_filtertxt_CSS", data.get("questionnaire_checklist_title"));

			// verify questionnaire is deleted or not
			helper.deleteVerification("questionnaire_createdrecord_detailedtask_checklist_XPATH",
					"Test Questionnaire Detailed Task Checklist Title");

		} catch (Throwable t) {
			verificationFailed();

		}

		// click on the home icon from the top of the screen
		click("questionnaire_homeburgermenubtn_CSS");

		// synchronization
		explicitWait("propertylist_title_XPATH");

		// verify the property list
		switchVerification("propertylist_title_XPATH", "Property List", "The property list is not displayed.");

	}
}