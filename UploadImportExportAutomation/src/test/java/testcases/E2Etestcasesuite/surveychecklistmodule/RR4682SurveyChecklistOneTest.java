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

public class RR4682SurveyChecklistOneTest extends TestBase {

	@Test(dataProviderClass = TestUtil.class, dataProvider = "dp")
	public void rR4682SurveyChecklistOneTest(Hashtable<String, String> data) throws InterruptedException, IOException {

		execution(data, "rR4682SurveyChecklistOneTest");

		// QUESTIONNAIRE EXPORT/IMPORT TO A DIFFERENT SYSTEM COMPANY.
		title("QUESTIONNAIRE EXPORT/IMPORT TO A DIFFERENT SYSTEM COMPANY.");

		Helper helper = new Helper();

		// refresh the page
		driver.navigate().refresh();
		Thread.sleep(5000);
		driver.navigate().refresh();

		// SWITCH THE SYSTEM COMPANY TO [DND]COMPANY 1
		title("SWITCH THE SYSTEM COMPANY TO [DND]COMPANY 1");

		try {
			// wait for the element
			explicitWaitClickable("questionnaire_settingicon_CSS");

			// click on the settings icon from the top of the screen
			click("questionnaire_settingicon_CSS");

			// wait for the element
			Thread.sleep(5000);

			// click on the Switch System Company option from the side menu
			click("ssc_sidemenubtn_CSS");

			// click on the switch system company dropdown
			click("ssc_systemcompanydd_CSS");

			// select the company 2 from the system company dropdown
			select("ssc_systemcompanydd_CSS", data.get("system_company_1"));

			// click on system company dropdown
			click("ssc_systemcompanydd_CSS");

			// click on the select button
			click("ssc_selectbtn_BTNTEXT");

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

			// ADD NEW QUESTIONNIRE
			title("ADD NEW QUESTIONNIRE");

			helper.createSurveyQuestionnaire(data);

			// enter the newly created questionnaire in the search field
			type("ssc_company2_questionnairelist_filtertxt_CSS", data.get("questionnaire_title"));

			try {
				// verification of the created questionnaire
				verifyTrue("questionnaire_createdrecordauto_importexport_XPATH",
						"The newly questionnaire is not created.");

				test.log(LogStatus.INFO, "The new questionnaire is created successfully.");

				// CONFIGRATION OF QUESTION
				title("CONFIGRATION OF QUESTION");

				// click on the created questionnaire
				click("questionnaire_createdrecordauto_importexport_XPATH");

				helper.configureQuestions(data);

				// enter newly created questionnaire in the filter field
				type("ssc_company2_questionnairelist_filtertxt_CSS", data.get("questionnaire_title"));

				// verify newly created questionnaire for survey
				switchVerification("questionnaire_createdrecordauto_importexport_XPATH",
						"Test Import Export Questionnaire",
						"The Test Import Export Questionnaire record is not displayed in the questionnaire list.");

			} catch (Throwable t) {
				verificationFailed();
			}

			// SWITCH THE SYSTEM COMPANY TO THE REFINED DATA TEST
			title("SWITCH THE SYSTEM COMPANY TO THE REFINED DATA TEST");

			// wait for the element
			explicitWaitClickable("questionnaire_settingicon_CSS");

			// click on the settings icon from the top of the screen
			click("questionnaire_settingicon_CSS");

			// wait for the element
			Thread.sleep(5000);

			// click on the Switch System Company option from the side menu
			click("ssc_sidemenubtn_CSS");

			// click on the switch system company dropdown
			click("ssc_systemcompanydd_CSS");

			// select the company 1 from the system company dropdown
			select("ssc_systemcompanydd_CSS", data.get("system_company"));

			// click on system company dropdown
			click("ssc_systemcompanydd_CSS");

			// click on the select button
			click("ssc_selectbtn_BTNTEXT");

		} catch (Throwable t) {
			helper.switchSystemCompany(data);
		}

		// click on the home icon from the top of the screen
		click("questionnaire_homeburgermenubtn_hide_CSS");

		// wait for the element
		explicitWait("propertylist_title_XPATH");

		// verify the property list
		switchVerification("propertylist_title_XPATH", "Property List", "The property list is not displayed.");

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

			// wait for the element
			explicitWait("questionnaire_importbtn_XPATH");

			// click on the import questionnaire button
			click("questionnaire_importbtn_XPATH");

			// upload the document using robot class methods
			uploadFile(System.getProperty("user.dir") + "\\src\\test\\resources\\logs\\sample.pdf");

			// wait for the element
			explicitWait("ssc_company2_questionnairelist_filtertxt_CSS");

			// enter the newly imported questionnaire in the search field
			type("ssc_company2_questionnairelist_filtertxt_CSS", data.get("questionnaire_title"));

			// verify newly imported questionnaire for survey
			switchVerification("questionnaire_createdrecordauto_importexport_XPATH", "Test Import Export Questionnaire",
					"The Test Import Export Questionnaire record is not displayed in the questionnaire list.");

		} catch (Throwable t) {
			verificationFailed();
		}

		// DELETE THE IMPORTED QUESTIONNAIRE
		title("DELETE THE IMPORTED QUESTIONNAIRE");

		try {
			// click on the imported questionnaire
			click("questionnaire_createdrecordauto_importexport_XPATH");

			// scrolldown the screen
			scrollByPixel(300);

			// click on the delete button
			click("questionnaire_deletebtn_CSS");

			// click on the delete button of the confirmation popup
			click("questionnaire_modeldeletebtn_CSS");

			// enter the newly imported questionnaire in the search field
			type("ssc_company2_questionnairelist_filtertxt_CSS", data.get("questionnaire_title"));

			// verify the questionnaire deleted or not
			try {
				String str3 = driver
						.findElement(By.xpath(OR.getProperty("questionnaire_createdrecordauto_importexport_XPATH")))
						.getText();

				if (str3.equals("Test Import Export Questionnaire")) {

					verificationFailedMessage("The task is not deleted successfully.");

				}
			} catch (Throwable t) {
				successMessage("The questionnaire is deleted successfully.");
			}

		} catch (Throwable t) {
			verificationFailed();
		}

		// click on the home icon from the top of the screen
		click("questionnaire_homeburgermenubtn_CSS");

		// wait for the element
		explicitWait("propertylist_title_XPATH");

		// verify the property list
		switchVerification("propertylist_title_XPATH", "Property List", "The property list is not displayed.");

		// SWITCH THE SYSTEM COMPANY TO [DND]COMPANY 1
		title("SWITCH THE SYSTEM COMPANY TO [DND]COMPANY 1");

		try {
			// wait for the element
			explicitWaitClickable("questionnaire_settingicon_CSS");

			// click on the settings icon from the top of the screen
			click("questionnaire_settingicon_CSS");

			// wait for the element
			Thread.sleep(5000);

			// click on the Switch System Company option from the side menu
			click("ssc_sidemenubtn_CSS");

			// click on the switch system company dropdown
			click("ssc_systemcompanydd_CSS");

			// select the company 2 from the system company dropdown
			select("ssc_systemcompanydd_CSS", data.get("system_company_1"));

			// click on system company dropdown
			click("ssc_systemcompanydd_CSS");

			// click on the select button
			click("ssc_selectbtn_BTNTEXT");

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

			// enter the newly imported questionnaire in the search field
			type("ssc_company2_questionnairelist_filtertxt_CSS", data.get("questionnaire_title"));

			// verify newly imported questionnaire for survey
			switchVerification("questionnaire_createdrecordauto_importexport_XPATH", "Test Import Export Questionnaire",
					"The Test Import Export Questionnaire record is not displayed in the questionnaire list.");

			// DELETE THE CREATED QUESTIONNAIRE
			title("DELETE THE CREATED QUESTIONNAIRE");

			// click on the created questionnaire
			click("questionnaire_createdrecordauto_importexport_XPATH");

			// scrolldown the screen
			scrollByPixel(300);

			// click on the delete button
			click("questionnaire_deletebtn_CSS");

			// click on the delete button of the confirmation popup
			click("questionnaire_modeldeletebtn_CSS");

			// enter the newly created questionnaire in the search field
			type("ssc_company2_questionnairelist_filtertxt_CSS", data.get("questionnaire_title"));

			// verify the questionnaire deleted or not
			try {
				String str3 = driver
						.findElement(By.xpath(OR.getProperty("questionnaire_createdrecordauto_importexport_XPATH")))
						.getText();

				if (str3.equals("Test Import Export Questionnaire")) {
					verificationFailedMessage("The task is not deleted successfully.");
				}
			} catch (Throwable t) {
				successMessage("The questionnaire is deleted successfully.");
			}

			// click on the home icon from the top of the screen
			click("questionnaire_homeburgermenubtn_CSS");

			// wait for the element
			explicitWait("propertylist_title_XPATH");

			// verify the property list
			switchVerification("propertylist_title_XPATH", "Property List", "The property list is not displayed.");

			// SWITCH THE SYSTEM COMPANY TO THE REFINED DATA TEST
			title("SWITCH THE SYSTEM COMPANY TO THE REFINED DATA TEST");

			// wait for the element
			explicitWaitClickable("questionnaire_settingicon_CSS");

			// click on the settings icon from the top of the screen
			click("questionnaire_settingicon_CSS");

			// wait for the element
			Thread.sleep(5000);

			// click on the Switch System Company option from the side menu
			click("ssc_sidemenubtn_CSS");

			// click on the switch system company dropdown
			click("ssc_systemcompanydd_CSS");

			// select the company 1 from the system company dropdown
			select("ssc_systemcompanydd_CSS", data.get("system_company"));

			// click on system company dropdown
			click("ssc_systemcompanydd_CSS");

			// click on the select button
			click("ssc_selectbtn_BTNTEXT");

		} catch (Throwable t) {
			helper.switchSystemCompany(data);
		}

		// click on the home icon from the top of the screen
		click("questionnaire_homeburgermenubtn_hide_CSS");

		// wait for the element
		explicitWait("propertylist_title_XPATH");

		// verify the property list
		switchVerification("propertylist_title_XPATH", "Property List", "The property list is not displayed.");

	}

}