package testcases.E2Etestcasesuite.surveychecklistmodule;

import java.io.IOException;
import java.util.Hashtable;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.Reporter;
import org.testng.SkipException;
import org.testng.annotations.Test;

import com.relevantcodes.extentreports.LogStatus;

import base.Helper;
import base.TestBase;
import utilities.TestUtil;

public class RR5306SurveyChecklist6Test extends TestBase {

	@Test(dataProviderClass = TestUtil.class, dataProvider = "dp")
	public void rR5306SurveyChecklist6Test(Hashtable<String, String> data) throws IOException, InterruptedException {

		execution(data, "rR5306SurveyChecklist6Test");

		// COPY THE QUESTIONNAIRE WITHOUT AN ANSWER, WHERE ANSWERS ARE NOT ADDED WHILE
		// PERFORMING THE INSPECTION / CHECKLIST.
		title("COPY THE QUESTIONNAIRE WITHOUT AN ANSWER, WHERE ANSWERS ARE NOT ADDED WHILE PERFORMING THE INSPECTION / CHECKLIST.");

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
			switchVerification("questionnaire_createdrecordcopy_6_XPATH", "Test Questionnaire Copy Six Title",
					"The Test Questionnaire Copy Six Title record is not displayed in the questionnaire list.");

			// CONFIGRATION OF QUESTION
			title("CONFIGRATION OF QUESTION");

			// click on the created questionnaire
			click("questionnaire_createdrecordcopy_6_XPATH");

			helper.configureQuestions(data);

			// enter newly created questionnaire in the filter field
			type("ssc_company2_questionnairelist_filtertxt_CSS", data.get("questionnaire_checklist_title"));

			// verify newly created questionnaire for checklist
			switchVerification("questionnaire_createdrecordcopy_6_XPATH", "Test Questionnaire Copy Six Title",
					"The Test Questionnaire Copy Six Title record is not displayed in the questionnaire list.");

		} catch (Throwable t) {
			verificationFailed();
		}

		// click on the home menu burger button
		click("questionnaire_homeburgermenubtn_CSS");

		// wait for the element
		explicitWait("propertylist_title_XPATH");

		// verify the property list
		switchVerification("propertylist_title_XPATH", "Property List", "The property list is not displayed.");

		// MAKE A COPY OF THE NEWLY CREATED QUESTIONNAIRE
		title("MAKE A COPY OF THE NEWLY CREATED QUESTIONNAIRE");

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
			switchVerification("questionnaire_createdrecordcopy_6_XPATH", "Test Questionnaire Copy Six Title",
					"The Test Questionnaire Copy Six Title record is not displayed in the questionnaire list.");

			// click on the copy icon
			click("questionnaire_createdrecordcopy_copyicon_CSS");

			// click on the copy button
			click("questionnaire_createdrecordcopy_copybtn_XPATH");

			// enter newly created questionnaire in the filter field
			type("ssc_company2_questionnairelist_filtertxt_CSS", data.get("questionnaire_checklist_title"));

			// verify copied questionnaire is displayed or not
			switchVerification("questionnaire_copiedrecord_XPATH", "2021",
					"The copied questionnaire is not displayed.");

		} catch (Throwable t) {
			verificationFailed();
		}

		// click on the home menu burger button
		click("questionnaire_homeburgermenubtn_CSS");

		// wait for the element
		explicitWait("propertylist_title_XPATH");

		// verify the property list
		switchVerification("propertylist_title_XPATH", "Property List", "The property list is not displayed.");

		// VERIFY THE CHECKLIST IN THE PROPERTY LEVEL
		title("VERIFY THE CHECKLIST IN THE PROPERTY LEVEL");

		try {

			// click on the environmental icon from the property list page
			click("environmentalicon_CSS");

			// wait for the element
			Thread.sleep(5000);

			// click on the burger menu
			click("menubtn_CSS");

			// wait for the element
			Thread.sleep(5000);

			// click on the checklist/inspection option from side menu
			click("checklist_sidemenu_XPATH");

			// click on the new checklist button
			click("checklist_newchecklistbtn_CSS");

			// wait for the element
			explicitWait("checklist_addchecklist_checklisttypedd_CSS");

			// verify the questionnaires count displayed correct or not
			WebElement drop_down = driver
					.findElement(By.cssSelector(OR.getProperty("checklist_addchecklist_checklisttypedd_CSS")));
			Select se = new Select(drop_down);
			List<WebElement> options = se.getOptions();

			int optionsize = options.size();
			System.out.println("Count of the options : " + optionsize);
			int count = 0;

			for (int i = 0; i < optionsize; i++) {

				WebElement singleOption = options.get(i);
				String stringOption = singleOption.getText();

				if (stringOption.equals(data.get("questionnaire_checklist_title"))) {
					count = count + 1;
				}
			}

			if (count == 2) {
				successMessage("The questionnaire count is displayed correctly.");
			} else {
				verificationFailedMessage("The questionnaire count is not displayed correctly.");
			}

			// click on the close button
			click("questionnaire_checklist_closebtn_CSS");

		} catch (Throwable t) {
			verificationFailed();
		}

		// click on the Home Icon from the top of the screen
		click("questionnaire_homeburgermenubtn_hide_CSS");

		// wait for the element
		explicitWait("propertylist_title_XPATH");

		// verify the property list
		switchVerification("propertylist_title_XPATH", "Property List", "The property list is not displayed.");

		// DELETE THE NEW QUESTIONNAIRE
		title("DELETE THE NEW QUESTIONNAIRE");

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

			// verify copied questionnaire is displayed or not
			switchVerification("questionnaire_copiedrecord_XPATH", "2021",
					"The copied questionnaire is not displayed.");

			// click on the newly created questionnaire on the property level
			click("questionnaire_copiedrecord_XPATH");

			// scroll till the delete button
			scrollTillElement("questionnaire_deletebtn_CSS");

			// click on the delete button
			click("questionnaire_deletebtn_CSS");

			// wait for the element
			Thread.sleep(5000);

			// click on the delete button of the confirmation popup
			driver.findElement(By.xpath("//button[@ng-click='deleteQuestionnaire()']")).click();

			// wait for the search field
			explicitWait("ssc_company2_questionnairelist_filtertxt_CSS");

			// enter newly created questionnaire in the filter field
			type("ssc_company2_questionnairelist_filtertxt_CSS", data.get("questionnaire_checklist_title"));

			// verify newly created questionnaire for survey
			switchVerification("questionnaire_createdrecordcopy_6_XPATH", "Test Questionnaire Copy Six Title",
					"The Test Questionnaire Copy Six Title record is not displayed in the questionnaire list.");

			// click on the newly created questionnaire on the property level
			click("questionnaire_createdrecordcopy_6_XPATH");

			// scroll till the delete button
			scrollTillElement("questionnaire_deletebtn_CSS");

			// click on the delete button
			click("questionnaire_deletebtn_CSS");

			// wait for the element
			Thread.sleep(5000);

			// click on the delete button of the confirmation popup
			click("questionnaire_modeldeletebtn_CSS");

			// enter newly created questionnaire in the filter field
			type("ssc_company2_questionnairelist_filtertxt_CSS", data.get("questionnaire_checklist_title"));

			// verified deleted questionnaire is displayed or not
			helper.deleteVerification("questionnaire_copiedrecord_XPATH", "2021");
			helper.deleteVerification("questionnaire_createdrecordcopy_6_XPATH", "Test Questionnaire Copy Six Title");

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