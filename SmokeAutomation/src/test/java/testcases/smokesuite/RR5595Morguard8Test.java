package testcases.smokesuite;

import java.io.IOException;
import java.util.Hashtable;
import java.util.List;
import java.util.Random;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.Reporter;
import org.testng.SkipException;
import org.testng.annotations.Test;

import com.google.inject.Key;
import com.mysql.cj.jdbc.NonRegisteringDriver;
import com.paulhammant.ngwebdriver.ByAngularBinding.NgFindByBuilder;
import com.relevantcodes.extentreports.LogStatus;

import base.Helper;
import base.TestBase;
import utilities.TestUtil;

public class RR5595Morguard8Test extends TestBase {

	@Test(dataProviderClass = TestUtil.class, dataProvider = "dp")
	public void rR5595Morguard8Test(Hashtable<String, String> data) throws IOException, InterruptedException {

		execution(data, "rR5595Morguard8Test");

		Helper helper = new Helper();

		// refresh the page
		driver.navigate().refresh();
		Thread.sleep(5000);
		driver.navigate().refresh();

		// LOGIN WITH ADMIN USER
		title("LOGIN WITH ADMIN USER");

		try {
			// wait for the element
			explicitWaitClickable("signinbtn_BTNTEXT");

			// Enter the username
			type("usernametxt_CSS", data.get("username_1"));

			// Enter the password
			type("passwordtxt_CSS", data.get("password_1"));

			// Clicking on the "Sign In" button
			click("signinbtn_BTNTEXT");

			// wait for the element
			explicitWait("propertylist_title_XPATH");

			// verify the property list
			switchVerification("propertylist_title_XPATH", "Property List", "The property list is not displayed.");

			// UPDATE THE SYSTEM COMPANY
			updateCompany(data);

		} catch (Throwable t) {
			verificationFailed();
		}

		// VERIFY THE QUESTIONNAIRE IS DISPLAYED LOCKED
		title("VERIFY THE QUESTIONNAIRE IS DISPLAYED LOCKED");

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

			// verify newly created questionnaire for survey
			switchVerification("questionnaire_activesurvey_XPATH", "MORGUARD - Climate Change Questionnaire",
					"The MORGUARD - Climate Change Questionnaire record is not displayed in the questionnaire list.");

			try {
				// make questionnaire locked
				boolean lockicon = driver
						.findElement(By.xpath(OR.getProperty("questionnaire_activesurvey_lockicon_XPATH")))
						.isDisplayed();

				if (lockicon == true) {

					// click on the unlock icon
					click("questionnaire_activesurvey_unlockicon_XPATH");

					successMessage("THE QUESTIONNAIRE IS DISPLAYED LOCK AS EXPECTED.");
				} else {
					successMessage("THE QUESTIONNAIRE IS DISPLAYED LOCK AS EXPECTED.");
				}
			} catch (Throwable t) {
				successMessage("THE QUESTIONNAIRE IS DISPLAYED LOCK AS EXPECTED.");
			}

		} catch (Throwable t) {
			verificationFailed();
		}

		// click on the home icon from the top of the screen
		click("questionnaire_homeburgermenubtn_CSS");

		// synchronization
		explicitWait("propertylist_title_XPATH");

		// verify the property list
		switchVerification("propertylist_title_XPATH", "Property List", "The property list is not displayed.");

		// VERIFY LOCKED QUESTIONNAIRE IS DISPLAYED IN THE ALERT AND NOTIFICATION
		// SECTION
		title("VERIFY LOCKED QUESTIONNAIRE IS DISPLAYED IN THE ALERT AND NOTIFICATION SECTION");

		try {
			// enter the property name in the search field

			type("envreports_propertylist_filtertxt_CSS", data.get("property_2"));

			// click on the environmental icon from the property list page
			click("environmentalicon_CSS");

			try {
				// verify locked questionnaire is displayed or not
				boolean lockedquestionnaire = driver
						.findElement(By
								.xpath(OR.getProperty("environmentalsummary_alertandnotification_activesurvey_XPATH")))
						.isDisplayed();

				if (lockedquestionnaire == true) {
					successMessage(
							"THE LOCKED QUESTIONNAIRE IS NOT DISPLAYED IN THE ALERT AND NOTIFICATION SECTION AS EXPECTED.");
				} else {

					verificationFailedMessage(
							"THE LOCKED QUESTIONNAIRE IS DISPLAYED IN THE ALERT AND NOTIFICATION SECTION.");
				}

			} catch (Throwable t) {
				verificationFailedMessage(
						"THE LOCKED QUESTIONNAIRE IS DISPLAYED IN THE ALERT AND NOTIFICATION SECTION.");
			}

		} catch (Throwable t) {
			verificationFailed();
		}

		// click on the home icon from the top of the screen
		click("questionnaire_homeburgermenubtn_hide_CSS");

		// synchronization
		explicitWait("propertylist_title_XPATH");

		// verify the property list
		switchVerification("propertylist_title_XPATH", "Property List", "The property list is not displayed.");

		// VERIFY THE QUESTIONNAIRE IS DISPLAYED UNLOCKED
		title("VERIFY THE QUESTIONNAIRE IS DISPLAYED UNLOCKED");

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

			// verify newly created questionnaire for survey
			switchVerification("questionnaire_activesurvey_XPATH", "MORGUARD - Climate Change Questionnaire",
					"The MORGUARD - Climate Change Questionnaire record is not displayed in the questionnaire list.");

			try {
				// make questionnaire unlocked
				boolean unlockicon = driver
						.findElement(By.xpath(OR.getProperty("questionnaire_activesurvey_unlockicon_XPATH")))
						.isDisplayed();

				if (unlockicon == true) {
					successMessage("THE QUESTIONNAIRE IS DISPLAYED UNLOCK AS EXPECTED.");
				} else {

					// click on the lock icon
					click("questionnaire_activesurvey_lockicon_XPATH");

					successMessage("THE QUESTIONNAIRE IS DISPLAYED UNLOCK AS EXPECTED.");
				}
			} catch (Throwable t) {

				// click on the lock icon
				click("questionnaire_activesurvey_lockicon_XPATH");

				successMessage("THE QUESTIONNAIRE IS DISPLAYED UNLOCK AS EXPECTED.");
			}

		} catch (Throwable t) {
			verificationFailed();
		}

		// click on the home icon from the top of the screen
		click("questionnaire_homeburgermenubtn_CSS");

		// synchronization
		explicitWait("propertylist_title_XPATH");

		// verify the property list
		switchVerification("propertylist_title_XPATH", "Property List", "The property list is not displayed.");

		// VERIFY UNLOCKED QUESTIONNAIRE IS DISPLAYED IN THE ALERT AND NOTIFICATION
		// SECTION
		title("VERIFY UNLOCKED QUESTIONNAIRE IS DISPLAYED IN THE ALERT AND NOTIFICATION SECTION");

		try {
			// enter the property name in the search field

			type("envreports_propertylist_filtertxt_CSS", data.get("property_2"));

			// click on the environmental icon from the property list page
			click("environmentalicon_CSS");

			try {
				// verify unlocked questionnaire is displayed or not
				boolean unlockedquestionnaire = driver
						.findElement(By
								.xpath(OR.getProperty("environmentalsummary_alertandnotification_activesurvey_XPATH")))
						.isDisplayed();

				if (unlockedquestionnaire == true) {
					successMessage(
							"THE LOCKED QUESTIONNAIRE IS NOT DISPLAYED IN THE ALERT AND NOTIFICATION SECTION AS EXPECTED.");
				} else {
					verificationFailedMessage(
							"THE LOCKED QUESTIONNAIRE IS DISPLAYED IN THE ALERT AND NOTIFICATION SECTION.");
				}

			} catch (Throwable t) {
				verificationFailedMessage(
						"THE LOCKED QUESTIONNAIRE IS DISPLAYED IN THE ALERT AND NOTIFICATION SECTION.");
			}

		} catch (Throwable t) {
			verificationFailed();
		}

		// click on the home icon from the top of the screen
		click("questionnaire_homeburgermenubtn_hide_CSS");

		// synchronization
		explicitWait("propertylist_title_XPATH");

		// verify the property list
		switchVerification("propertylist_title_XPATH", "Property List", "The property list is not displayed.");

		// COPY THE QUESTIONNAIRE WITHOUT AN ANSWER, WHERE ANSWERS ARE NOT ADDED WHILE
		// PERFORMING THE SURVEY.
		title("COPY THE QUESTIONNAIRE WITHOUT AN ANSWER, WHERE ANSWERS ARE NOT ADDED WHILE PERFORMING THE SURVEY.");

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

			type("ssc_company2_questionnairelist_filtertxt_CSS", data.get("questionnaire_title_copy"));

			// verify newly created questionnaire for survey
			switchVerification("questionnaire_activesurvey_copy_XPATH",
					"Morguard - 2021 Summer - Environmental Compliance Audit",
					"The Morguard - 2021 Summer - Environmental Compliance Audit record is not displayed in the questionnaire list.");

			// click on the copy icon
			click("questionnaire_createdrecordcopy_copyicon_CSS");

			// click on the copy button
			click("questionnaire_createdrecordcopy_copybtn_XPATH");

			// enter newly created questionnaire in the filter field

			type("ssc_company2_questionnairelist_filtertxt_CSS", data.get("questionnaire_title_copy"));

			// verify copied questionnaire is displayed or not
			switchVerification("questionnaire_activesurvey_copiedrecord_XPATH", "November",
					"The copied questionnaire is not displayed.");

		} catch (Throwable t) {
			questionnaireNotDisplay();
		}

		// click on the home menu burger button
		click("questionnaire_homeburgermenubtn_CSS");

		// wait for the element
		explicitWait("propertylist_title_XPATH");

		// verify the property list
		switchVerification("propertylist_title_XPATH", "Property List", "The property list is not displayed.");

		// VERIFY QUESTONNAIRES IN SURVEY MODULE
		title("VERIFY QUESTONNAIRES IN SURVEY MODULE");

		try {

			// enter the property name in the search field

			type("envreports_propertylist_filtertxt_CSS", data.get("property_2"));

			// click on the environmental icon from the property list page
			click("environmentalicon_CSS");

			// wait for the element
			Thread.sleep(5000);

			// click on the burger menu
			click("menubtn_CSS");

			// wait for the element
			Thread.sleep(5000);

			// click on the survey option from side menu
			click("surveyoption_XPATH");

			// verify the questionnaires count displayed correct or not
			WebElement drop_down = driver.findElement(By.cssSelector(OR.getProperty("survey_questionnairedd_CSS")));
			Select se = new Select(drop_down);
			List<WebElement> options = se.getOptions();

			int optionsize = options.size();
			consoleMessage("Count of the options : " + optionsize);
			int count = 0;

			for (int i = 0; i < optionsize; i++) {

				WebElement singleOption = options.get(i);
				String stringOption = singleOption.getText();

				if (stringOption.equals(data.get("questionnaire_title_copy"))) {
					count = count + 1;
				}
			}
			if (count == 2) {
				successMessage("THE QUESTIONNAIRE COUNT IS DISPLAYED CORRECTLY.");
			} else {

				verificationFailedMessage("THE COPIED QUESTIONNAIRE IS NOT DISPLAYED IN THE PROPERTY LEVEL.");
			}

		} catch (Throwable t) {
			verificationFailed();
		}

		// click on the Home button
		click("questionnaire_homeburgermenubtn_hide_CSS");

		// wait for the element
		explicitWait("propertylist_title_XPATH");

		// verify the property list
		switchVerification("propertylist_title_XPATH", "Property List", "The property list is not displayed.");

		// DELETE THE COPIED QUESTIONNAIRE
		title("DELETE THE COPIED QUESTIONNAIRE");

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

			type("ssc_company2_questionnairelist_filtertxt_CSS", data.get("questionnaire_title_copy"));

			// verify copied questionnaire is displayed or not
			switchVerification("questionnaire_activesurvey_copiedrecord_XPATH", "November",
					"The copied questionnaire is not displayed.");

			// click on the newly created questionnaire on the property level
			click("questionnaire_activesurvey_copiedrecord_XPATH");

			// scroll till the delete button
			scrollTillElement("questionnaire_deletebtn_CSS");

			// click on the delete button
			click("questionnaire_deletebtn_CSS");

			// wait for the delete button
			explicitWaitClickable("questionnaire_modeldeletebtn_CSS");

			// click on the delete button of the confirmation popup
			click("questionnaire_modeldeletebtn_CSS");

			// wait for the search field
			explicitWait("ssc_company2_questionnairelist_filtertxt_CSS");

			// enter newly created questionnaire in the filter field

			type("ssc_company2_questionnairelist_filtertxt_CSS", data.get("questionnaire_title_copy"));

			// verify copied questionnaire is displayed or not
			deleteVerification("questionnaire_activesurvey_copiedrecord_XPATH", "November");

		} catch (Throwable t) {
			questionnaireNotDisplay();
		}

		// click on the home menu burger button
		click("questionnaire_homeburgermenubtn_CSS");

		// wait for the element
		explicitWait("propertylist_title_XPATH");

		// verify the property list
		switchVerification("propertylist_title_XPATH", "Property List", "The property list is not displayed.");

		// THE SURVEY SHOULD BE COMPLETED WITH 100% IN PERCENTAGE BAR AND ABLE TO
		// APPROVE THE SURVEY
		title("THE SURVEY SHOULD BE COMPLETED WITH 100% IN PERCENTAGE BAR AND ABLE TO APPROVE THE SURVEY");

		// VERIFY THE QUESTIONNAIRE IS DISPLAYED UNLOCKED
		title("VERIFY THE QUESTIONNAIRE IS DISPLAYED UNLOCKED");

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

			// verify newly created questionnaire for survey
			switchVerification("questionnaire_activesurvey_XPATH", "MORGUARD - Climate Change Questionnaire",
					"The MORGUARD - Climate Change Questionnaire record is not displayed in the questionnaire list.");

			try {
				// make questionnaire unlocked
				boolean unlockicon = driver
						.findElement(By.xpath(OR.getProperty("questionnaire_activesurvey_unlockicon_XPATH")))
						.isDisplayed();

				if (unlockicon == true) {
					successMessage("THE QUESTIONNAIRE IS DISPLAYED UNLOCK AS EXPECTED.");
				} else {

					// click on the lock icon
					click("questionnaire_activesurvey_lockicon_XPATH");

					successMessage("THE QUESTIONNAIRE IS DISPLAYED UNLOCK AS EXPECTED.");
				}
			} catch (Throwable t) {

				// click on the lock icon
				click("questionnaire_activesurvey_lockicon_XPATH");

				successMessage("THE QUESTIONNAIRE IS DISPLAYED UNLOCK AS EXPECTED.");
			}

		} catch (Throwable t) {
			verificationFailed();
		}

		// click on the home icon from the top of the screen
		click("questionnaire_homeburgermenubtn_CSS");

		// synchronization
		explicitWait("propertylist_title_XPATH");

		// verify the property list
		switchVerification("propertylist_title_XPATH", "Property List", "The property list is not displayed.");

		// GIVE ALL THE ANSWERS AND SUBMIT THE SURVEY
		title("GIVE ALL THE ANSWERS AND SUBMIT THE SURVEY");

		try {

			// enter the property name in the search field

			type("envreports_propertylist_filtertxt_CSS", data.get("property_2"));

			// click on the environmental icon from the property list page
			click("environmentalicon_CSS");

			// wait for the element
			Thread.sleep(5000);

			// click on the burger menu
			click("menubtn_CSS");

			// wait for the element
			Thread.sleep(5000);

			// click on the survey option from side menu
			click("surveyoption_XPATH");

			// select the respective questionnaire from the dropdown
			select("survey_questionnairedd_CSS", data.get("questionnaire_title"));

			// verify questionnaire is selected correctly or not
			switchVerification("questionnaire_questiontitle_morguard_XPATH",
					"Flood resilience plans and procedures (recommended for all buildings)",
					"The Flood resilience plans and procedures (recommended for all buildings) is not displayed.");

			// click on the n/a checkbox of category 1 question 1
			helper.verifyNACheckedCheckbox("survey_category_1_question_1_morguard_XPATH");

			// click on the n/a checkbox of category 1 question 2
			helper.verifyNACheckedCheckbox("survey_category_1_question_2_morguard_XPATH");

			// click on the n/a checkbox of category 1 question 3
			helper.verifyNACheckedCheckbox("survey_category_1_question_3_morguard_XPATH");

			// scroll down the screen
			helper.scrollDownToNextNACheckbox("survey_category_1_question_4_morguard_XPATH",
					"survey_category_1_question_4_morguard_answered_XPATH");

			// click on the n/a checkbox of category 1 question 4
			helper.verifyNACheckedCheckbox("survey_category_1_question_4_morguard_XPATH");

			// click on the n/a checkbox of category 1 question 5
			helper.verifyNACheckedCheckbox("survey_category_1_question_5_morguard_XPATH");

			// click on the n/a checkbox of category 1 question 6
			helper.verifyNACheckedCheckbox("survey_category_1_question_6_morguard_XPATH");

			// scroll down the screen
			helper.scrollDownToNextNACheckbox("survey_category_1_question_7_morguard_XPATH",
					"survey_category_1_question_7_morguard_answered_XPATH");

			// click on the n/a checkbox of category 1 question 7
			helper.verifyNACheckedCheckbox("survey_category_1_question_7_morguard_XPATH");

			// click on the n/a checkbox of category 1 question 8
			helper.verifyNACheckedCheckbox("survey_category_1_question_8_morguard_XPATH");

			// click on the n/a checkbox of category 1 question 9
			helper.verifyNACheckedCheckbox("survey_category_1_question_9_morguard_XPATH");

			// scroll down the screen
			helper.scrollDownToNextNACheckbox("survey_category_2_question_1_morguard_XPATH",
					"survey_category_2_question_1_morguard_answered_XPATH");

			// click on the n/a checkbox of category 2 question 1
			helper.verifyNACheckedCheckbox("survey_category_2_question_1_morguard_XPATH");

			// click on the n/a checkbox of category 2 question 2
			helper.verifyNACheckedCheckbox("survey_category_2_question_2_morguard_XPATH");

			// click on the n/a checkbox of category 2 question 3
			helper.verifyNACheckedCheckbox("survey_category_2_question_3_morguard_XPATH");

			// scroll down the screen
			helper.scrollDownToNextNACheckbox("survey_category_3_question_1_morguard_XPATH",
					"survey_category_3_question_1_morguard_answered_XPATH");

			// click on the n/a checkbox of category 3 question 1
			helper.verifyNACheckedCheckbox("survey_category_3_question_1_morguard_XPATH");

			// click on the n/a checkbox of category 3 question 2
			helper.verifyNACheckedCheckbox("survey_category_3_question_2_morguard_XPATH");

			// click on the n/a checkbox of category 3 question 3
			helper.verifyNACheckedCheckbox("survey_category_3_question_3_morguard_XPATH");

			// scroll down the screen
			helper.scrollDownToNextNACheckbox("survey_category_3_question_4_morguard_XPATH",
					"survey_category_3_question_4_morguard_answered_XPATH");

			// click on the n/a checkbox of category 3 question 4
			helper.verifyNACheckedCheckbox("survey_category_3_question_4_morguard_XPATH");

			// click on the n/a checkbox of category 3 question 5
			helper.verifyNACheckedCheckbox("survey_category_3_question_5_morguard_XPATH");

			// click on the n/a checkbox of category 3 question 6
			helper.verifyNACheckedCheckbox("survey_category_3_question_6_morguard_XPATH");

			// scroll down the screen
			helper.scrollDownToNextNACheckbox("survey_category_4_question_1_morguard_XPATH",
					"survey_category_4_question_1_morguard_answered_XPATH");

			// click on the n/a checkbox of category 4 question 1
			helper.verifyNACheckedCheckbox("survey_category_4_question_1_morguard_XPATH");

			// click on the n/a checkbox of category 4 question 2
			helper.verifyNACheckedCheckbox("survey_category_4_question_2_morguard_XPATH");

			// click on the n/a checkbox of category 4 question 3
			helper.verifyNACheckedCheckbox("survey_category_4_question_3_morguard_XPATH");

			// scroll down the screen
			helper.scrollDownToNextNACheckbox("survey_category_4_question_4_morguard_XPATH",
					"survey_category_4_question_4_morguard_answered_XPATH");

			// click on the n/a checkbox of category 4 question 4
			helper.verifyNACheckedCheckbox("survey_category_4_question_4_morguard_XPATH");

			// click on the n/a checkbox of category 4 question 5
			helper.verifyNACheckedCheckbox("survey_category_4_question_5_morguard_XPATH");

			// click on the n/a checkbox of category 4 question 6
			helper.verifyNACheckedCheckbox("survey_category_4_question_6_morguard_XPATH");

			// scroll down the screen
			helper.scrollDownToNextNACheckbox("survey_category_4_question_7_morguard_XPATH",
					"survey_category_4_question_7_morguard_answered_XPATH");

			// click on the n/a checkbox of category 4 question 7
			helper.verifyNACheckedCheckbox("survey_category_4_question_7_morguard_XPATH");

			// click on the n/a checkbox of category 4 question 8
			helper.verifyNACheckedCheckbox("survey_category_4_question_8_morguard_XPATH");

			// click on the n/a checkbox of category 4 question 9
			helper.verifyNACheckedCheckbox("survey_category_4_question_9_morguard_XPATH");

			// scroll down the screen
			helper.scrollDownToNextNACheckbox("survey_category_4_question_10_morguard_XPATH",
					"survey_category_4_question_10_morguard_answered_XPATH");

			// click on the n/a checkbox of category 4 question 10
			helper.verifyNACheckedCheckbox("survey_category_4_question_10_morguard_XPATH");

			// click on the n/a checkbox of category 4 question 11
			helper.verifyNACheckedCheckbox("survey_category_4_question_11_morguard_XPATH");

			// click on the n/a checkbox of category 4 question 12
			helper.verifyNACheckedCheckbox("survey_category_4_question_12_morguard_XPATH");

			// scroll down the screen
			helper.scrollDownToNextNACheckbox("survey_category_4_question_13_morguard_XPATH",
					"survey_category_4_question_13_morguard_answered_XPATH");

			// click on the n/a checkbox of category 4 question 13
			helper.verifyNACheckedCheckbox("survey_category_4_question_13_morguard_XPATH");

			// click on the n/a checkbox of category 4 question 14
			helper.verifyNACheckedCheckbox("survey_category_4_question_14_morguard_XPATH");

			// click on the n/a checkbox of category 4 question 15
			helper.verifyNACheckedCheckbox("survey_category_4_question_15_morguard_XPATH");

			// scroll down the screen
			helper.scrollDownToNextNACheckbox("survey_category_5_question_1_morguard_XPATH",
					"survey_category_5_question_1_morguard_answered_XPATH");

			// click on the n/a checkbox of category 5 question 1
			helper.verifyNACheckedCheckbox("survey_category_5_question_1_morguard_XPATH");

			// click on the n/a checkbox of category 5 question 2
			helper.verifyNACheckedCheckbox("survey_category_5_question_2_morguard_XPATH");

			// scroll down the screen
			helper.scrollDownToNextNACheckbox("survey_category_5_question_3_morguard_XPATH",
					"survey_category_5_question_3_morguard_answered_XPATH");

			// click on the n/a checkbox of category 5 question 3
			helper.verifyNACheckedCheckbox("survey_category_5_question_3_morguard_XPATH");

			// scroll down the screen
			helper.scrollDownToNextNACheckbox("survey_category_5_question_3_morguard_XPATH",
					"survey_category_5_question_3_morguard_answered_XPATH");

			// verify the 100% completion of questions
			switchVerification("survey_imported_questionnaire_100_XPATH", "100% complete",
					"The 100% complete is not displayed.");

			// scroll down the screen
			scrollTillElement("survey_submitbtn_morguard_XPATH");

			// click on the submit button
			click("survey_submitbtn_morguard_XPATH");

			// wait for the text
			explicitWait("survey_submittedtext_morguard_XPATH");

			// verify submitted confirmation text
			switchVerification("survey_submittedtext_morguard_XPATH", "The survey has been submitted successfully",
					"The survey has been submitted successfully text is not displayed.");

		} catch (Throwable t) {
			verificationFailed();
		}

		// click on the home icon from the top of the screen
		click("questionnaire_homeburgermenubtn_hide_CSS");

		// synchronization
		explicitWait("propertylist_title_XPATH");

		// verify the property list
		switchVerification("propertylist_title_XPATH", "Property List", "The property list is not displayed.");

		// UNSELECT ALL THE ANSWERS AND VERIFY SUBMIT BUTTON
		title("UNSELECT ALL THE ANSWERS AND VERIFY SUBMIT BUTTON");

		try {

			// enter the property name in the search field

			type("envreports_propertylist_filtertxt_CSS", data.get("property_2"));

			// click on the environmental icon from the property list page
			click("environmentalicon_CSS");

			// wait for the element
			Thread.sleep(5000);

			// click on the burger menu
			click("menubtn_CSS");

			// wait for the element
			Thread.sleep(5000);

			// click on the survey option from side menu
			click("surveyoption_XPATH");

			// select the respective questionnaire from the dropdown
			select("survey_questionnairedd_CSS", data.get("questionnaire_title"));

			// verify questionnaire is selected correctly or not
			switchVerification("questionnaire_questiontitle_morguard_XPATH",
					"Flood resilience plans and procedures (recommended for all buildings)",
					"The Flood resilience plans and procedures (recommended for all buildings) is not displayed.");

			// click on the reopen button
			click("survey_reopenbtn_morguard_XPATH");

			// click on the reopen button of the confirmation popup
			click("survey_confirmationreopenbtn_morguard_XPATH");

			// click on the n/a checkbox of category 1 question 1
			helper.verifyNAUncheckedCheckbox("survey_category_1_question_1_morguard_answered_XPATH");

			// click on the n/a checkbox of category 1 question 2
			helper.verifyNAUncheckedCheckbox("survey_category_1_question_2_morguard_answered_XPATH");

			// click on the n/a checkbox of category 1 question 3
			helper.verifyNAUncheckedCheckbox("survey_category_1_question_3_morguard_answered_XPATH");

			// scroll down the screen
			helper.scrollDownToNextNACheckbox("survey_category_1_question_4_morguard_XPATH",
					"survey_category_1_question_4_morguard_answered_XPATH");

			// click on the n/a checkbox of category 1 question 4
			helper.verifyNAUncheckedCheckbox("survey_category_1_question_4_morguard_answered_XPATH");

			// click on the n/a checkbox of category 1 question 5
			helper.verifyNAUncheckedCheckbox("survey_category_1_question_5_morguard_answered_XPATH");

			// click on the n/a checkbox of category 1 question 6
			helper.verifyNAUncheckedCheckbox("survey_category_1_question_6_morguard_answered_XPATH");

			// scroll down the screen
			helper.scrollDownToNextNACheckbox("survey_category_1_question_7_morguard_XPATH",
					"survey_category_1_question_7_morguard_answered_XPATH");

			// click on the n/a checkbox of category 1 question 7
			helper.verifyNAUncheckedCheckbox("survey_category_1_question_7_morguard_answered_XPATH");

			// click on the n/a checkbox of category 1 question 8
			helper.verifyNAUncheckedCheckbox("survey_category_1_question_8_morguard_answered_XPATH");

			// click on the n/a checkbox of category 1 question 9
			helper.verifyNAUncheckedCheckbox("survey_category_1_question_9_morguard_answered_XPATH");

			// scroll down the screen
			helper.scrollDownToNextNACheckbox("survey_category_2_question_1_morguard_XPATH",
					"survey_category_2_question_1_morguard_answered_XPATH");

			// click on the n/a checkbox of category 2 question 1
			helper.verifyNAUncheckedCheckbox("survey_category_2_question_1_morguard_answered_XPATH");

			// click on the n/a checkbox of category 2 question 2
			helper.verifyNAUncheckedCheckbox("survey_category_2_question_2_morguard_answered_XPATH");

			// click on the n/a checkbox of category 2 question 3
			helper.verifyNAUncheckedCheckbox("survey_category_2_question_3_morguard_answered_XPATH");

			// scroll down the screen
			helper.scrollDownToNextNACheckbox("survey_category_3_question_1_morguard_XPATH",
					"survey_category_3_question_1_morguard_answered_XPATH");

			// click on the n/a checkbox of category 3 question 1
			helper.verifyNAUncheckedCheckbox("survey_category_3_question_1_morguard_answered_XPATH");

			// click on the n/a checkbox of category 3 question 2
			helper.verifyNAUncheckedCheckbox("survey_category_3_question_2_morguard_answered_XPATH");

			// click on the n/a checkbox of category 3 question 3
			helper.verifyNAUncheckedCheckbox("survey_category_3_question_3_morguard_answered_XPATH");

			// scroll down the screen
			helper.scrollDownToNextNACheckbox("survey_category_3_question_4_morguard_XPATH",
					"survey_category_3_question_4_morguard_answered_XPATH");

			// click on the n/a checkbox of category 3 question 4
			helper.verifyNAUncheckedCheckbox("survey_category_3_question_4_morguard_answered_XPATH");

			// click on the n/a checkbox of category 3 question 5
			helper.verifyNAUncheckedCheckbox("survey_category_3_question_5_morguard_answered_XPATH");

			// click on the n/a checkbox of category 3 question 6
			helper.verifyNAUncheckedCheckbox("survey_category_3_question_6_morguard_answered_XPATH");

			// scroll down the screen
			helper.scrollDownToNextNACheckbox("survey_category_4_question_1_morguard_XPATH",
					"survey_category_4_question_1_morguard_answered_XPATH");

			// click on the n/a checkbox of category 4 question 1
			helper.verifyNAUncheckedCheckbox("survey_category_4_question_1_morguard_answered_XPATH");

			// click on the n/a checkbox of category 4 question 2
			helper.verifyNAUncheckedCheckbox("survey_category_4_question_2_morguard_answered_XPATH");

			// click on the n/a checkbox of category 4 question 3
			helper.verifyNAUncheckedCheckbox("survey_category_4_question_3_morguard_answered_XPATH");

			// scroll down the screen
			helper.scrollDownToNextNACheckbox("survey_category_4_question_4_morguard_XPATH",
					"survey_category_4_question_4_morguard_answered_XPATH");

			// click on the n/a checkbox of category 4 question 4
			helper.verifyNAUncheckedCheckbox("survey_category_4_question_4_morguard_answered_XPATH");

			// click on the n/a checkbox of category 4 question 5
			helper.verifyNAUncheckedCheckbox("survey_category_4_question_5_morguard_answered_XPATH");

			// click on the n/a checkbox of category 4 question 6
			helper.verifyNAUncheckedCheckbox("survey_category_4_question_6_morguard_answered_XPATH");

			// scroll down the screen
			helper.scrollDownToNextNACheckbox("survey_category_4_question_7_morguard_XPATH",
					"survey_category_4_question_7_morguard_answered_XPATH");

			// click on the n/a checkbox of category 4 question 7
			helper.verifyNAUncheckedCheckbox("survey_category_4_question_7_morguard_answered_XPATH");

			// click on the n/a checkbox of category 4 question 8
			helper.verifyNAUncheckedCheckbox("survey_category_4_question_8_morguard_answered_XPATH");

			// click on the n/a checkbox of category 4 question 9
			helper.verifyNAUncheckedCheckbox("survey_category_4_question_9_morguard_answered_XPATH");

			// scroll down the screen
			helper.scrollDownToNextNACheckbox("survey_category_4_question_10_morguard_XPATH",
					"survey_category_4_question_10_morguard_answered_XPATH");

			// click on the n/a checkbox of category 4 question 10
			helper.verifyNAUncheckedCheckbox("survey_category_4_question_10_morguard_answered_XPATH");

			// click on the n/a checkbox of category 4 question 11
			helper.verifyNAUncheckedCheckbox("survey_category_4_question_11_morguard_answered_XPATH");

			// click on the n/a checkbox of category 4 question 12
			helper.verifyNAUncheckedCheckbox("survey_category_4_question_12_morguard_answered_XPATH");

			// scroll down the screen
			helper.scrollDownToNextNACheckbox("survey_category_4_question_13_morguard_XPATH",
					"survey_category_4_question_13_morguard_answered_XPATH");

			// click on the n/a checkbox of category 4 question 13
			helper.verifyNAUncheckedCheckbox("survey_category_4_question_13_morguard_answered_XPATH");

			// click on the n/a checkbox of category 4 question 14
			helper.verifyNAUncheckedCheckbox("survey_category_4_question_14_morguard_answered_XPATH");

			// click on the n/a checkbox of category 4 question 15
			helper.verifyNAUncheckedCheckbox("survey_category_4_question_15_morguard_answered_XPATH");

			// scroll down the screen
			helper.scrollDownToNextNACheckbox("survey_category_5_question_1_morguard_XPATH",
					"survey_category_5_question_1_morguard_answered_XPATH");

			// click on the n/a checkbox of category 5 question 1
			helper.verifyNAUncheckedCheckbox("survey_category_5_question_1_morguard_answered_XPATH");

			// click on the n/a checkbox of category 5 question 2
			helper.verifyNAUncheckedCheckbox("survey_category_5_question_2_morguard_answered_XPATH");

			// scroll down the screen
			helper.scrollDownToNextNACheckbox("survey_category_5_question_3_morguard_XPATH",
					"survey_category_5_question_3_morguard_answered_XPATH");

			// click on the n/a checkbox of category 5 question 3
			helper.verifyNAUncheckedCheckbox("survey_category_5_question_3_morguard_answered_XPATH");

			// scroll down the screen
			helper.scrollDownToNextNACheckbox("survey_category_5_question_3_morguard_XPATH",
					"survey_category_5_question_3_morguard_answered_XPATH");

			// verify the 0% completion of questions
			switchVerification("survey_imported_questionnaire_0_XPATH", "0% complete",
					"The 0% complete is not displayed.");

			// scroll down the screen

			scrollByPixel(400);

			// verify the submit button is displayed or not

			try {
				boolean submitbtn = driver.findElement(By.xpath(OR.getProperty("survey_submitbtn_morguard_XPATH")))
						.isDisplayed();

				if (submitbtn == true) {

					verificationFailedMessage("THE SUBMIT BUTTON IS DISPLAYED.");
				} else {
					successMessage("THE SUBMIT BUTTON IS NOT DISPLAYED AS EXPECTED.");
				}
			} catch (Throwable t) {
				successMessage("THE SUBMIT BUTTON IS NOT DISPLAYED AS EXPECTED.");
			}

		} catch (Throwable t) {
			verificationFailed();
		}

		// click on the home icon from the top of the screen
		click("questionnaire_homeburgermenubtn_hide_CSS");

		// synchronization
		explicitWait("propertylist_title_XPATH");

		// verify the property list
		switchVerification("propertylist_title_XPATH", "Property List", "The property list is not displayed.");

		try {
			// wait for the element
			explicitWaitClickable("questionnaire_settingicon_CSS");

			// click on the settings icon from the top of the screen
			click("questionnaire_settingicon_CSS");

			// wait for the element
			explicitWaitClickable("sidemenu_logout_CSS");

			// click on the logout option from the side menu
			click("sidemenu_logout_CSS");

			// wait for the element
			explicitWaitClickable("signinbtn_BTNTEXT");

		} catch (Throwable t) {
			verificationFailed();
		}

	}
}