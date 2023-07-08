package testcases.E2Etestcasesuite.surveychecklistmodule;

import java.io.IOException;
import java.util.Hashtable;
import java.util.List;

import org.apache.commons.collections4.bag.SynchronizedSortedBag;
import org.apache.commons.lang3.RandomStringUtils;
import org.apache.poi.util.SystemOutLogger;
import org.apache.xmlbeans.impl.xb.xsdschema.NamedGroup;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.Reporter;
import org.testng.SkipException;
import org.testng.annotations.Test;

import com.mysql.cj.jdbc.NonRegisteringDriver;
import com.paulhammant.ngwebdriver.ByAngularBinding.NgFindByBuilder;
import com.paulhammant.ngwebdriver.NgWebDriver;
import com.relevantcodes.extentreports.LogStatus;

import base.Helper;
import base.TestBase;
import utilities.TestUtil;

public class RR5306SurveyChecklist3Test extends TestBase {

	@Test(dataProviderClass = TestUtil.class, dataProvider = "dp")
	public void rR5306SurveyChecklist3Test(Hashtable<String, String> data) throws IOException, InterruptedException {

		execution(data, "rR5306SurveyChecklist3Test");

		// COPY THE QUESTIONNAIRE WITH AN ANSWER, WHERE ANSWERS ARE ADDED WHILE
		// PERFORMING THE SURVEY.

		title("COPY THE QUESTIONNAIRE WITH AN ANSWER, WHERE ANSWERS ARE ADDED WHILE PERFORMING THE SURVEY.");

		Helper helper = new Helper();

		// refresh the page
		driver.navigate().refresh();
		Thread.sleep(5000);
		driver.navigate().refresh();

		// CREATE THE NEW QUESTIONNAIRE
		title("CREATE THE NEW QUESTIONNAIRE");

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

			// ADD NEW QUESTIONNIRE
			title("ADD NEW QUESTIONNIRE");

			helper.createSurveyQuestionnaire(data);

			// enter the newly created questionnaire in the search field
			type("ssc_company2_questionnairelist_filtertxt_CSS", data.get("questionnaire_title"));

			// verification of the created questionnaire
			switchVerification("questionnaire_createdrecordcopy_3_XPATH", "Test Questionnaire Copy Three Title",
					"The Test Questionnaire Copy Three Title is not displayed.");

			// CONFIGRATION OF QUESTION
			title("CONFIGRATION OF QUESTION");

			// click on the created questionnaire
			click("questionnaire_createdrecordcopy_3_XPATH");

			helper.configureQuestions(data);

			// enter newly created questionnaire in the filter field
			type("ssc_company2_questionnairelist_filtertxt_CSS", data.get("questionnaire_title"));

			// verify newly created questionnaire for survey
			switchVerification("questionnaire_createdrecordcopy_3_XPATH", "Test Questionnaire Copy Three Title",
					"The Test Questionnaire Copy Three Title record is not displayed in the questionnaire list.");

		} catch (Throwable t) {
			verificationFailed();
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
			switchVerification("questionnaire_questiontitle_XPATH", "Test Category Title One",
					"The Test Category Title One is not displayed.");

			// click on the yes checkbox of question 1
			click("survey_yesanswerbtn_1_CSS");

			// enter the data in the text field
			type("survey_option_q1o1_CSS", data.get("description"));

			// click on the question title
			click("questionnaire_questiontitle_XPATH");

		} catch (Throwable t) {
			verificationFailed();
		}

		// click on the home menu burger button
		click("questionnaire_homeburgermenubtn_hide_CSS");

		// wait for the element
		explicitWait("propertylist_title_XPATH");

		// verify the property list
		switchVerification("propertylist_title_XPATH", "Property List", "The property list is not displayed.");

		// refresh the screen
		driver.navigate().refresh();
		Thread.sleep(3000);
		driver.navigate().refresh();

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
			type("ssc_company2_questionnairelist_filtertxt_CSS", data.get("questionnaire_title"));

			// verify newly created questionnaire for survey
			switchVerification("questionnaire_createdrecordcopy_3_XPATH", "Test Questionnaire Copy Three Title",
					"The Test Questionnaire Copy Three Title record is not displayed in the questionnaire list.");

			// click on the copy icon
			click("questionnaire_createdrecordcopy_copyicon_CSS");

			// click on the copy answer checkbox
			click("questionnaire_copyanswerckbx_CSS");

			// click on the copy button
			click("questionnaire_createdrecordcopy_copybtn_XPATH");

			// enter newly created questionnaire in the filter field
			type("ssc_company2_questionnairelist_filtertxt_CSS", data.get("questionnaire_title"));

			// verify copied questionnaire is displayed or not
			switchVerification("questionnaire_copiedrecord_XPATH", "2021",
					"The copied questionnaire is not displayed.");

			// click on the copied questionnaire
			click("questionnaire_copiedrecord_XPATH");

			// update the questionnaire title
			type("questionnaire_questionnairetitletxt_CSS", data.get("copied_questionnaire_title"));

			// scroll down the screen
			scrollByPixel(500);

			// click on the save button
			click("questionnaire_savebtn_BTNTEXT");

			// enter newly created questionnaire in the filter field
			type("ssc_company2_questionnairelist_filtertxt_CSS", data.get("copied_questionnaire_title"));

			// verify copied questionnaire is displayed or not
			switchVerification("questionnaire_copiedrecord3_XPATH", "Test Copied Questionnaire Copy Three Title",
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

		// VERIFY QUESTONNAIRES IN SURVEY MODULE
		title("VERIFY QUESTONNAIRES IN SURVEY MODULE");

		try {

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
			int count = 0;

			for (int i = 0; i < optionsize; i++) {

				WebElement singleOption = options.get(i);
				String stringOption = singleOption.getText();

				if (stringOption.equals(data.get("questionnaire_title"))
						|| stringOption.equals(data.get("copied_questionnaire_title"))) {

					count = count + 1;

					if (stringOption.equals(data.get("questionnaire_title"))) {

						// wait for 3 seconds
						Thread.sleep(3000);

						// select the questionnaire from the dropdown
						select("survey_questionnairedd_CSS", stringOption);

						boolean ans1 = driver
								.findElement(By.cssSelector(OR.getProperty("survey_selectedyesanswer_CSS")))
								.isDisplayed();

						if (ans1 == true) {
							successMessage("The question one is displayed selected.");

						} else {
							verificationFailedMessage("The question one is not displayed selected.");
						}

						String opt1 = driver.findElement(By.cssSelector(OR.getProperty("survey_option_q1o1_CSS")))
								.getAttribute("value");

						if (opt1.equals(data.get("description"))) {
							successMessage("The text of the option one is displayed.");
						} else {

							verificationFailedMessage("The text of the option one is not displayed.");
						}
					} else if (stringOption.equals(data.get("copied_questionnaire_title"))) {

						// wait for 3 seconds
						Thread.sleep(3000);

						// select the questionnaire from the dropdown
						select("survey_questionnairedd_CSS", stringOption);

						boolean ans2 = driver
								.findElement(By.cssSelector(OR.getProperty("survey_selectedyesanswer_CSS")))
								.isDisplayed();

						if (ans2 == true) {
							verificationFailedMessage("The question one is displayed selected.");

						} else {
							successMessage("The question one is not displayed selected.");

						}

						String opt2 = driver.findElement(By.cssSelector(OR.getProperty("survey_option_q1o1_CSS")))
								.getAttribute("value");

						if (opt2.equals(data.get("description"))) {
							verificationFailedMessage("The text of the option one is displayed.");

						} else {
							successMessage("The text of the option one is not displayed as expected.");

						}
					}
				}
			}

			if (count == 2) {

				successMessage("The questionnaire count is displayed correctly.");

			} else {

				verificationFailedMessage("The questionnaire count is not displayed correctly.");
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

		// UPDATE THE QUESTIONNAIRE TITLE WITH RANDOM TEXT
		title("UPDATE THE QUESTIONNAIRE TITLE WITH RANDOM TEXT");

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
			type("ssc_company2_questionnairelist_filtertxt_CSS", data.get("copied_questionnaire_title"));

			// click on the copied questionnaire on the property level
			click("questionnaire_copiedrecord3_XPATH");

			helper.randomText();

			// enter newly created questionnaire in the filter field
			type("ssc_company2_questionnairelist_filtertxt_CSS", data.get("questionnaire_title"));

			// click on the newly created questionnaire on the property level
			click("questionnaire_createdrecordcopy_3_XPATH");

			helper.randomText();

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
