package testcases.E2Etestcasesuite.surveychecklistmodule;

import java.io.IOException;
import java.util.Hashtable;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.SkipException;
import org.testng.annotations.Test;

import com.relevantcodes.extentreports.LogStatus;

import base.Helper;
import base.TestBase;
import utilities.TestUtil;

public class RR3892SurveyChecklistFiveTest extends TestBase {

	@Test(dataProviderClass = TestUtil.class, dataProvider = "dp")
	public void rR3892SurveyChecklistFiveTest(Hashtable<String, String> data) throws IOException, InterruptedException {

		execution(data, "rR3892SurveyChecklistFiveTest");

		// THE ANSWER OF THE OPTION SHOULD ALSO BE DELETED ON THE ANSWER SWITCH
		title("THE ANSWER OF THE OPTION SHOULD ALSO BE DELETED ON THE ANSWER SWITCH");

		Helper helper = new Helper();

		// refresh the page
		driver.navigate().refresh();
		Thread.sleep(5000);
		driver.navigate().refresh();

		// ADD NEW QUESTIONNIRE
		title("ADD NEW QUESTIONNIRE");

		try {

			// wait for the element
			explicitWaitClickable("questionnaire_settingicon_CSS");

			// click on the settings icon from the top of the screen
			click("questionnaire_settingicon_CSS");

			// wait for the element
			explicitWaitClickable("questionnaire_administrationoption_XPATH");

			// click on the Administration option from the side menu
			click("questionnaire_administrationoption_XPATH");

			// wait for the element
			explicitWaitClickable("questionnaire_questionnairestab_XPATH");

			// click on the Questionnaires tab
			click("questionnaire_questionnairestab_XPATH");

			// click on the Questionnaires option
			click("questionnaire_questionnairesoption_XPATH");

			helper.createSurveyQuestionnaire(data);

			// enter the newly created questionnaire in the search field
			type("ssc_company2_questionnairelist_filtertxt_CSS", data.get("questionnaire_title"));

			// verification of the created questionnaire
			verifyTrue("questionnaire_createdrecordauto_5_XPATH", "The newly questionnaire is not created.");

			// CONFIGRATION OF QUESTION
			title("CONFIGRATION OF QUESTION");

			// click on the created questionnaire
			click("questionnaire_createdrecordauto_5_XPATH");

			helper.configureQuestions(data);

			// enter newly created questionnaire in the filter field
			type("ssc_company2_questionnairelist_filtertxt_CSS", data.get("questionnaire_title"));

			// verify newly created questionnaire for checklist
			switchVerification("questionnaire_createdrecordauto_5_XPATH", "Test Auto Questionnaire Five Title",
					"The Test Auto Questionnaire Five Title record is not displayed in the questionnaire list.");

		} catch (Throwable t) {
			verificationFailedMessage("The newly created questionnaire is not displayed.");

		}

		// click on the Home Icon from the top of the screen
		click("questionnaire_homeburgermenubtn_CSS");

		// wait for the element
		explicitWait("propertylist_title_XPATH");

		// verify the property list
		switchVerification("propertylist_title_XPATH", "Property List", "The property list is not displayed.");

		// VERIFY THE SURVEY IN THE PROPERTY LEVEL
		title("VERIFY THE SURVEY IN THE PROPERTY LEVEL");

		try {
			// click on the environmental icon from the property list page
			click("environmentalicon_CSS");

			// wait till the burger toggle button is not visible - Explicit wait
			explicitWait("menubtn_CSS");

			// click on the burger menu
			click("menubtn_CSS");

			// wait for the element
			Thread.sleep(5000);

			// click on the survey option from side menu
			click("surveyoption_XPATH");

			// select the respective questionnaire from the dropdown
			select("survey_questionnairedd_CSS", data.get("questionnaire_title"));

			// verify questionnaire is selected correctly or not
			switchVerification("questionnaire_questiontitle_XPATH", "Test Category Title One",
					"The Test Category Title One is not displayed.");

			// click on the yes checkbox
			click("survey_yesanswerbtn_1_CSS");

			// enter value in the text field
			type("survey_textfield_CSS", data.get("textfield_question"));

			// click on the NO checkbox
			click("survey_noanswerbtn_1_CSS");

			// wait for the element
			explicitWaitClickable("survey_yesanswerbtn_1_CSS");

			// click on the yes checkbox
			click("survey_yesanswerbtn_1_CSS");

			// verify the data of the option is deleted or not
			try {
				String str1 = driver.findElement(By.cssSelector(OR.getProperty("survey_textfield_CSS")))
						.getAttribute("value");

				if (str1.equals("Test Option")) {

					verificationFailedMessage("The data is not deleted from the option field successfully.");

				} else {

					successMessage("The data is deleted from the option field successfully.");
				}

			} catch (Throwable t) {
				verificationFailed();
			}

		} catch (Throwable t) {

			verificationFailedMessage("The newly created questionnaire is not displayed.");

		}

		// click on the Home Icon from the top of the screen
		click("questionnaire_homeburgermenubtn_hide_CSS");

		// wait for the element
		explicitWait("propertylist_title_XPATH");

		// verify the property list
		switchVerification("propertylist_title_XPATH", "Property List", "The property list is not displayed.");

		// DELETE THE ADDED QUESTIONNAIRE
		title("DELETE THE ADDED QUESTIONNAIRE");

		try {

			// wait for the element
			explicitWaitClickable("questionnaire_settingicon_CSS");

			// click on the settings icon from the top of the screen
			click("questionnaire_settingicon_CSS");

			// wait for the element
			explicitWaitClickable("questionnaire_administrationoption_XPATH");

			// click on the Administration option from the side menu
			click("questionnaire_administrationoption_XPATH");

			// click on the Questionnaires tab
			click("questionnaire_questionnairestab_XPATH");

			// click on the Questionnaires option
			click("questionnaire_questionnairesoption_XPATH");

			// enter newly created questionnaire in the filter field
			type("ssc_company2_questionnairelist_filtertxt_CSS", data.get("questionnaire_title"));

			// click on the created questionnaire
			click("questionnaire_createdrecordauto_5_XPATH");

			helper.deleteSurveyQuestionnaire(data);

			// enter newly created questionnaire in the filter field
			type("ssc_company2_questionnairelist_filtertxt_CSS", data.get("questionnaire_title"));

			// verify newly created questionnaire for checklist
			switchVerification("questionnaire_createdrecordauto_5_XPATH", "Test Auto Questionnaire Five Title",
					"The Test Auto Questionnaire Five Title record is not displayed in the questionnaire list.");

			// click on the created questionnaire
			click("questionnaire_createdrecordauto_5_XPATH");

			// scroll till the delete button
			scrollTillElement("questionnaire_deletebtn_CSS");

			// click on the delete button
			click("questionnaire_deletebtn_CSS");

			// click on the delete button of the confirmation popup
			click("questionnaire_modeldeletebtn_CSS");

			// enter newly created questionnaire in the filter field
			type("ssc_company2_questionnairelist_filtertxt_CSS", data.get("questionnaire_title"));

			helper.deleteVerification("questionnaire_createdrecordauto_5_XPATH", "Test Auto Questionnaire Five Title");

		} catch (Throwable t) {
			verificationFailed();
		}

		// click on the home icon from the top of the screen
		click("questionnaire_homeburgermenubtn_CSS");

		// wait for the element
		explicitWait("propertylist_title_XPATH");

		// verify the property list
		switchVerification("propertylist_title_XPATH", "Property List", "The property list is not displayed.");

	}
}
