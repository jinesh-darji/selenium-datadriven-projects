package testcases.E2Etestcasesuite.surveychecklistmodule;

import java.io.IOException;
import java.util.Hashtable;
import java.util.List;

import org.apache.commons.lang3.RandomStringUtils;
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

public class RR5306SurveyChecklist10Test extends TestBase {

	@Test(dataProviderClass = TestUtil.class, dataProvider = "dp")
	public void rR5306SurveyChecklist10Test(Hashtable<String, String> data) throws IOException, InterruptedException {

		execution(data, "rR5306SurveyChecklist10Test");

		// COPY THE QUESTIONNAIRE WITHOUT AN ANSWER, WHERE THE ORIGINAL QUESTIONNAIRE
		// (INSPECTION / CHECKLIST) WAS LOCKED FROM THE ADMINISTRATION.
		title("COPY THE QUESTIONNAIRE WITHOUT AN ANSWER, WHERE THE ORIGINAL QUESTIONNAIRE (INSPECTION / CHECKLIST) WAS LOCKED FROM THE ADMINISTRATION.");

		Helper helper = new Helper();

		// refresh the page
		driver.navigate().refresh();
		Thread.sleep(5000);
		driver.navigate().refresh();

		// ADD NEW QUESTIONNIRE FOR CHECKLIST
		title("ADD NEW QUESTIONNIRE FOR CHECKLIST");

		try {

			// wait for the element
			Thread.sleep(5000);

			// click on the settings icon from the top of the screen
			click("questionnaire_settingicon_CSS");

			// wait for the element
			Thread.sleep(5000);

			// click on the Administration option from the side menu
			click("questionnaire_administrationoption_XPATH");

			// click on the Questionnaires tab
			click("questionnaire_questionnairestab_XPATH");

			// click on the Questionnaires option
			click("questionnaire_questionnairesoption_XPATH");

			// ADD NEW QUESTIONNIRE FOR CHECKLIST
			title("ADD NEW QUESTIONNIRE FOR CHECKLIST");

			// click on the new questionnaire
			click("questionnaire_newquestionnairebtn_CSS");

			// Select the Inspection / Checklist of the questionnaire
			click("questionnaire_type_inspectionbtn_CSS");

			// Select the level of the questionnaire
			click("questionnaire_level_propertybtn_CSS");

			// enter the group title
			type("questionnaire_grouptitletxt_CSS", data.get("group_title"));

			// enter the questionnaire title
			type("questionnaire_languagetitle_CSS", data.get("questionnaire_checklist_title"));

			// select the model
			select("questionnaire_modeldd_CSS", data.get("model"));

			// select the frequency
			select("questionnaire_frequencydd_CSS", data.get("frequency"));

			// enter frequency interval
			type("questionnaire_frequencyintervaltxt_CSS", "1");

			// enter the year
			type("questionnaire_yeartxt_CSS", "2020");

			// select the month
			select("questionnaire_monthtxt_CSS", data.get("month"));

			// enter the description
			type("questionnaire_descriptiontxt_CSS", data.get("description"));

			// select the classic option from the default view drop down
			select("questionnaire_checklist_defaultview_CSS", data.get("default_view"));

			// scroll down the screen
			scrollByPixel(500);

			// scroll down to the save button
			scrollBottom();

			// click on the save button
			click("questionnaire_savebtn_BTNTEXT");

			// enter newly created questionnaire in the filter field
			type("ssc_company2_questionnairelist_filtertxt_CSS", data.get("questionnaire_checklist_title"));

			// verify newly created questionnaire for checklist
			switchVerification("questionnaire_createdrecordcopy_10_XPATH", "Test Questionnaire Copy Ten Title",
					"The Test Questionnaire Copy Ten Title record is not displayed in the questionnaire list.");

			// CONFIGRATION OF QUESTION
			title("CONFIGRATION OF QUESTION");

			// click on the created questionnaire
			click("questionnaire_createdrecordcopy_10_XPATH");

			helper.configureQuestions(data);

			// enter newly created questionnaire in the filter field
			type("ssc_company2_questionnairelist_filtertxt_CSS", data.get("questionnaire_checklist_title"));

			// verify newly created questionnaire for checklist
			switchVerification("questionnaire_createdrecordcopy_10_XPATH", "Test Questionnaire Copy Ten Title",
					"The Test Questionnaire Copy Ten Title record is not displayed in the questionnaire list.");

		} catch (Throwable t) {
			verificationFailed();
		}

		// click on the Home Icon from the top of the screen
		click("questionnaire_homeburgermenubtn_CSS");

		// wait for the element
		explicitWait("propertylist_title_XPATH");

		// verify the property list
		switchVerification("propertylist_title_XPATH", "Property List", "The property list is not displayed.");

		// LOCK THE QUESTIONNAIRE AND MAKE A COPY OF THE NEWLY CREATED QUESTIONNAIRE
		title("LOCK THE QUESTIONNAIRE AND MAKE A COPY OF THE NEWLY CREATED QUESTIONNAIRE");

		try {

			// wait for the element
			Thread.sleep(5000);

			// click on the settings icon from the top of the screen
			click("questionnaire_settingicon_CSS");

			// wait for the element
			Thread.sleep(5000);

			// click on the Administration option from the side menu
			click("questionnaire_administrationoption_XPATH");

			// click on the Questionnaires tab
			click("questionnaire_questionnairestab_XPATH");

			// click on the Questionnaires option
			click("questionnaire_questionnairesoption_XPATH");

			// enter newly created questionnaire in the filter field
			type("ssc_company2_questionnairelist_filtertxt_CSS", data.get("questionnaire_checklist_title"));

			// verify newly created questionnaire for checklist
			switchVerification("questionnaire_createdrecordcopy_10_XPATH", "Test Questionnaire Copy Ten Title",
					"The Test Questionnaire Copy Ten Title record is not displayed in the questionnaire list.");

			// click on the unlock icon
			click("questionnaire_createtask_unlockicon_CSS");

			// click on the lock button
			click("questionnaire_createtask_lockbtn_XPATH");

			// wait for the element
			explicitWaitClickable("closetoastmsg_CSS");

			// click on the toaster close button
			click("closetoastmsg_CSS");

			// wait for the element
			Thread.sleep(5000);

			try {

				// click on the lock icon
				click("questionnaire_createtask_lockicon_CSS");

				// wait for the element
				Thread.sleep(5000);

				boolean unlock = driver
						.findElement(By.xpath(OR.getProperty("questionnaire_createtask_unlockbtn_XPATH")))
						.isDisplayed();

				if (unlock == true) {
					successMessage("The questionnaire is locked successfully.");
				} else {
					verificationFailedMessage("The questionnaire is not locked.");
				}

				// click on the cancel button
				click("questionnaire_createtask_copyquestion_cancelbtn_XPATH");

			} catch (Throwable t) {
				verificationFailed();

				// click on the cancel button
				click("questionnaire_createtask_copyquestion_cancelbtn_XPATH");

			}

			// click on the copy icon
			click("questionnaire_createdrecordcopy_copyicon_CSS");

			// click on the copy button
			click("questionnaire_createdrecordcopy_copybtn_XPATH");

			// wait for the element
			explicitWaitClickable("closetoastmsg_CSS");

			// click on the toaster close button
			click("closetoastmsg_CSS");

			// enter newly created questionnaire in the filter field
			type("ssc_company2_questionnairelist_filtertxt_CSS", data.get("questionnaire_checklist_title"));

			// verify copied questionnaire is displayed or not
			switchVerification("questionnaire_copiedrecord_XPATH", "2021",
					"The copied questionnaire is not displayed.");

			// click on the copied questionnaire
			click("questionnaire_copiedrecord_XPATH");

			// update the questionnaire title
			type("questionnaire_questionnairetitletxt_CSS", data.get("copied_questionnaire_checklist_title"));

			// scroll down the screen
			scrollBottom();

			// click on the save button
			click("questionnaire_savebtn_BTNTEXT");

			// enter newly created questionnaire in the filter field
			type("ssc_company2_questionnairelist_filtertxt_CSS", data.get("copied_questionnaire_checklist_title"));

			// verify copied questionnaire is displayed or not
			switchVerification("questionnaire_copiedrecord10_XPATH", "Test Copied Questionnaire Copy Ten Title",
					"The copied questionnaire is not displayed.");

			// wait for 3 seconds
			Thread.sleep(3000);

			// VERIFY COPIED QUESTIONNAIRE IS DISPLAYED LOCKED OR NOT
			title("VERIFY COPIED QUESTIONNAIRE IS DISPLAYED LOCKED OR NOT");

			try {

				// click on the lock icon
				click("questionnaire_createtask_lockicon_CSS");

				// wait for the element
				Thread.sleep(5000);

				boolean unlock = driver
						.findElement(By.xpath(OR.getProperty("questionnaire_createtask_unlockbtn_XPATH")))
						.isDisplayed();

				if (unlock == true) {
					successMessage("The questionnaire is locked successfully.");
				} else {
					verificationFailedMessage("The questionnaire is not locked.");
				}

				// click on the cancel button
				click("questionnaire_createtask_copyquestion_cancelbtn_XPATH");

			} catch (Throwable t) {
				verificationFailed();

				// click on the cancel button
				click("questionnaire_createtask_copyquestion_cancelbtn_XPATH");
			}

		} catch (Throwable t) {
			verificationFailed();
		}

		// DELETE THE COPIED QUESTIONNAIRE
		title("DELETE THE COPIED QUESTIONNAIRE");

		try {

			// click on the copied questionnaire on the property level
			click("questionnaire_copiedrecord10_XPATH");

			// scroll till the delete button
			scrollTillElement("questionnaire_deletebtn_CSS");

			// click on the delete button
			click("questionnaire_deletebtn_CSS");

			// click on the delete button of the confirmation popup
			click("questionnaire_modeldeletebtn_CSS");

			// enter newly created questionnaire in the filter field
			type("ssc_company2_questionnairelist_filtertxt_CSS", data.get("copied_questionnaire_checklist_title"));

			// verified deleted questionnaire is displayed or not
			helper.deleteVerification("questionnaire_copiedrecord10_XPATH", "Test Copied Questionnaire Copy Ten Title");

		} catch (Throwable t) {
			verificationFailed();
		}

		// UNLOCK THE QUESTIONNAIRE AND MAKE A COPY OF THE NEWLY CREATED QUESTIONNAIRE
		title("UNLOCK THE QUESTIONNAIRE AND MAKE A COPY OF THE NEWLY CREATED QUESTIONNAIRE");

		try {

			// enter newly created questionnaire in the filter field
			type("ssc_company2_questionnairelist_filtertxt_CSS", data.get("questionnaire_checklist_title"));

			// click on the lock icon
			click("questionnaire_createtask_lockicon_CSS");

			// click on the unlock button
			click("questionnaire_createtask_unlockbtn_XPATH");

			// wait for the element
			explicitWaitClickable("closetoastmsg_CSS");

			// click on the toaster close button
			click("closetoastmsg_CSS");

			// wait for the element
			Thread.sleep(5000);

			try {

				// click on the unlock icon
				click("questionnaire_createtask_unlockicon_CSS");

				// wait for the element
				Thread.sleep(5000);

				boolean lock = driver.findElement(By.xpath(OR.getProperty("questionnaire_createtask_lockbtn_XPATH")))
						.isDisplayed();

				if (lock == true) {
					successMessage("The questionnaire is locked successfully.");
				} else {
					verificationFailedMessage("The questionnaire is not locked.");
				}

				// click on the cancel button
				click("questionnaire_createtask_copyquestion_cancelbtn_XPATH");

			} catch (Throwable t) {
				verificationFailed();
			}

			// click on the copy icon
			click("questionnaire_createdrecordcopy_copyicon_CSS");

			// click on the copy button
			click("questionnaire_createdrecordcopy_copybtn_XPATH");

			// wait for the element
			explicitWaitClickable("closetoastmsg_CSS");

			// click on the toaster close button
			click("closetoastmsg_CSS");

			// enter newly created questionnaire in the filter field
			type("ssc_company2_questionnairelist_filtertxt_CSS", data.get("questionnaire_checklist_title"));

			// verify copied questionnaire is displayed or not
			switchVerification("questionnaire_copiedrecord_XPATH", "2021",
					"The copied questionnaire is not displayed.");

			// click on the copied questionnaire
			click("questionnaire_copiedrecord_XPATH");

			// update the questionnaire title
			type("questionnaire_questionnairetitletxt_CSS", data.get("copied_questionnaire_checklist_title"));

			// scroll down the screen
			scrollBottom();

			// click on the save button
			click("questionnaire_savebtn_BTNTEXT");

			// enter newly created questionnaire in the filter field
			type("ssc_company2_questionnairelist_filtertxt_CSS", data.get("copied_questionnaire_checklist_title"));

			// verify copied questionnaire is displayed or not
			switchVerification("questionnaire_copiedrecord10_XPATH", "Test Copied Questionnaire Copy Ten Title",
					"The copied questionnaire is not displayed.");

			// wait for 3 seconds
			Thread.sleep(3000);

			// verify copied questionnaire is displayed locked or not
			try {

				// click on the unlock icon
				click("questionnaire_createtask_unlockicon_CSS");

				// wait for the element
				Thread.sleep(5000);

				boolean lock = driver.findElement(By.xpath(OR.getProperty("questionnaire_createtask_lockbtn_XPATH")))
						.isDisplayed();

				if (lock == true) {
					successMessage("The questionnaire is locked successfully.");
				} else {
					verificationFailedMessage("The questionnaire is not locked.");
				}

				// click on the cancel button
				click("questionnaire_createtask_copyquestion_cancelbtn_XPATH");

			} catch (Throwable t) {
				verificationFailed();
			}

		} catch (Throwable t) {
			verificationFailed();
		}

		// DELETE THE QUESTIONNAIRES
		title("DELETE THE QUESTIONNAIRES");

		try {

			// click on the copied questionnaire on the property level
			click("questionnaire_copiedrecord10_XPATH");

			// scroll till the delete button
			scrollTillElement("questionnaire_deletebtn_CSS");

			// click on the delete button
			click("questionnaire_deletebtn_CSS");

			// click on the delete button of the confirmation popup
			click("questionnaire_modeldeletebtn_CSS");

			// enter newly created questionnaire in the filter field
			type("ssc_company2_questionnairelist_filtertxt_CSS", data.get("copied_questionnaire_checklist_title"));

			// verified deleted questionnaire is displayed or not
			helper.deleteVerification("questionnaire_copiedrecord10_XPATH", "Test Copied Questionnaire Copy Ten Title");

			// scroll up the screen
			scrollByPixel(-400);

			// wait for the search field
			explicitWait("ssc_company2_questionnairelist_filtertxt_CSS");

			// enter newly created questionnaire in the filter field
			type("ssc_company2_questionnairelist_filtertxt_CSS", data.get("questionnaire_checklist_title"));

			// verify newly created questionnaire for survey
			switchVerification("questionnaire_createdrecordcopy_10_XPATH", "Test Questionnaire Copy Ten Title",
					"The Test Questionnaire Copy Ten Title record is not displayed in the questionnaire list.");

			// click on the newly created questionnaire on the property level
			click("questionnaire_createdrecordcopy_10_XPATH");

			// scroll till the delete button
			scrollTillElement("questionnaire_deletebtn_CSS");

			// click on the delete button
			click("questionnaire_deletebtn_CSS");

			// click on the delete button of the confirmation popup
			click("questionnaire_modeldeletebtn_CSS");

			// enter newly created questionnaire in the filter field
			type("ssc_company2_questionnairelist_filtertxt_CSS", data.get("copied_questionnaire_checklist_title"));

			// verified deleted questionnaire is displayed or not
			helper.deleteVerification("questionnaire_copiedrecord10_XPATH", "Test Copied Questionnaire Copy Ten Title");

		} catch (Throwable t) {
			verificationFailed();
		}

		// click on the home menu burger button
		click("questionnaire_homeburgermenubtn_CSS");

		// wait for the element
		explicitWait("propertylist_title_XPATH");

		// verify the property list
		switchVerification("propertylist_title_XPATH", "Property List", "The property list is not displayed.");
	}
}