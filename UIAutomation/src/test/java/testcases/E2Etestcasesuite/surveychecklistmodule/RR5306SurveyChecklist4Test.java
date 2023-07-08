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

public class RR5306SurveyChecklist4Test extends TestBase {

	@Test(dataProviderClass = TestUtil.class, dataProvider = "dp")
	public void rR5306SurveyChecklist4Test(Hashtable<String, String> data) throws IOException, InterruptedException {

		execution(data, "rR5306SurveyChecklist4Test");

		// COPY THE QUESTIONNAIRE WITH AN ANSWER, WHERE THE ORIGINAL QUESTIONNAIRE WAS
		// APPROVED WHILE PERFORMING THE SURVEY.

		System.out.println(
				"COPY THE QUESTIONNAIRE WITH AN ANSWER, WHERE THE ORIGINAL QUESTIONNAIRE WAS APPROVED WHILE PERFORMING THE SURVEY.");
		test.log(LogStatus.INFO,
				"COPY THE QUESTIONNAIRE WITH AN ANSWER, WHERE THE ORIGINAL QUESTIONNAIRE WAS APPROVED WHILE PERFORMING THE SURVEY.");
		Reporter.log(
				"COPY THE QUESTIONNAIRE WITH AN ANSWER, WHERE THE ORIGINAL QUESTIONNAIRE WAS APPROVED WHILE PERFORMING THE SURVEY.");
		log.info(
				"COPY THE QUESTIONNAIRE WITH AN ANSWER, WHERE THE ORIGINAL QUESTIONNAIRE WAS APPROVED WHILE PERFORMING THE SURVEY.");

		Helper helper = new Helper();

		// refresh the page
		driver.navigate().refresh();
		Thread.sleep(5000);
		driver.navigate().refresh();

		System.out.println("Navigate to the Home Screen i.e. Property List Screen.");

		// CREATE THE NEW QUESTIONNAIRE

		System.out.println("******************** CREATE THE NEW QUESTIONNAIRE ********************");
		test.log(LogStatus.INFO, "******************** CREATE THE NEW QUESTIONNAIRE ********************");
		Reporter.log("******************** CREATE THE NEW QUESTIONNAIRE ********************");
		log.info("******************** CREATE THE NEW QUESTIONNAIRE ********************");

		try {
			// wait for the element
			Thread.sleep(5000);

			// click on the settings icon from the top of the screen
			click("questionnaire_settingicon_CSS");
			System.out.println("Clicked on the settings icon.");
			ngDriver.waitForAngularRequestsToFinish();

			// wait for the element
			Thread.sleep(5000);

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

			// ADD NEW QUESTIONNIRE

			helper.createSurveyQuestionnaire(data);

			// enter the newly created questionnaire in the search field
			type("ssc_company2_questionnairelist_filtertxt_CSS", data.get("questionnaire_title"));
			System.out.println("Entered the newly created questionnaire in the search field.");
			ngDriver.waitForAngularRequestsToFinish();

			// verification of the created questionnaire
			switchVerification("questionnaire_createdrecordcopy_4_XPATH", "Test Questionnaire Copy Four Title",
					"The Test Questionnaire Copy Four Title is not displayed.");

			// CONFIGRATION OF QUESTION

			// click on the created questionnaire
			click("questionnaire_createdrecordcopy_4_XPATH");
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
			switchVerification("questionnaire_createdrecordcopy_4_XPATH", "Test Questionnaire Copy Four Title",
					"The Test Questionnaire Copy Four Title record is not displayed in the questionnaire list.");

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

		// VERIFY QUESTONNAIRES IN SURVEY MODULE

		System.out.println("******************** VERIFY QUESTONNAIRES IN SURVEY MODULE ********************");
		test.log(LogStatus.INFO, "******************** VERIFY QUESTONNAIRES IN SURVEY MODULE ********************");
		Reporter.log("******************** VERIFY QUESTONNAIRES IN SURVEY MODULE ********************");
		log.info("******************** VERIFY QUESTONNAIRES IN SURVEY MODULE ********************");

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

			// click on the survey option from side menu
			click("surveyoption_XPATH");
			System.out.println("Clicked on the survey option from side menu");
			ngDriver.waitForAngularRequestsToFinish();
			System.out.println("Navigate to the survey screen");

			// select the respective questionnaire from the dropdown
			select("survey_questionnairedd_CSS", data.get("questionnaire_title"));
			System.out.println("The questionnaire selected successfully.");
			ngDriver.waitForAngularRequestsToFinish();

			// verify questionnaire is selected correctly or not
			switchVerification("questionnaire_questiontitle_XPATH", "Test Category Title One",
					"The Test Category Title One is not displayed.");

			// click on the yes checkbox of question 1
			click("survey_yesanswerbtn_1_CSS");
			System.out.println("Clicked on the yes checkbox.");
			ngDriver.waitForAngularRequestsToFinish();

			// enter the data in the text field
			type("survey_option_q1o1_CSS", data.get("description"));
			ngDriver.waitForAngularRequestsToFinish();
			System.out.println("Entered the data in the text field.");

			// click on the question title
			click("questionnaire_questiontitle_XPATH");
			ngDriver.waitForAngularRequestsToFinish();
			System.out.println("Clicked on the question title.");

			// click on the yes checkbox of question 2
			click("survey_yesanswerbtn_2_CSS");
			System.out.println("Clicked on the yes checkbox of question 2.");
			ngDriver.waitForAngularRequestsToFinish();

			// scroll dwon the screen
			JavascriptExecutor js = (JavascriptExecutor) driver;
			js.executeScript("window.scrollBy(0,500)");

			// click on the submit button
			click("questionnaire_submitbtn_XPATH");
			ngDriver.waitForAngularRequestsToFinish();
			System.out.println("Clicked on the submit button.");

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

		// refresh the screen
		driver.navigate().refresh();
		Thread.sleep(3000);
		driver.navigate().refresh();

		// MAKE A COPY OF THE NEWLY CREATED QUESTIONNAIRE

		System.out.println("******************** MAKE A COPY OF THE NEWLY CREATED QUESTIONNAIRE ********************");
		test.log(LogStatus.INFO,
				"******************** MAKE A COPY OF THE NEWLY CREATED QUESTIONNAIRE ********************");
		Reporter.log("******************** MAKE A COPY OF THE NEWLY CREATED QUESTIONNAIRE ********************");
		log.info("******************** MAKE A COPY OF THE NEWLY CREATED QUESTIONNAIRE ********************");

		try {
			// wait for the element
			Thread.sleep(5000);

			// click on the settings icon from the top of the screen
			click("questionnaire_settingicon_CSS");
			System.out.println("Clicked on the settings icon.");
			ngDriver.waitForAngularRequestsToFinish();

			// wait for the element
			Thread.sleep(5000);

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

			// verify newly created questionnaire for survey
			switchVerification("questionnaire_createdrecordcopy_4_XPATH", "Test Questionnaire Copy Four Title",
					"The Test Questionnaire Copy Four Title record is not displayed in the questionnaire list.");

			// click on the copy icon
			click("questionnaire_createdrecordcopy_copyicon_CSS");
			ngDriver.waitForAngularRequestsToFinish();
			System.out.println("Clicked on the copy icon.");

			// click on the copy answer checkbox
			click("questionnaire_copyanswerckbx_CSS");
			ngDriver.waitForAngularRequestsToFinish();
			System.out.println("Clicked on the copy answer checkbox.");

			// click on the copy button
			click("questionnaire_createdrecordcopy_copybtn_XPATH");
			ngDriver.waitForAngularRequestsToFinish();
			System.out.println("Clicked on the copy button.");

			// enter newly created questionnaire in the filter field
			clear("ssc_company2_questionnairelist_filtertxt_CSS");
			ngDriver.waitForAngularRequestsToFinish();
			type("ssc_company2_questionnairelist_filtertxt_CSS", data.get("questionnaire_title"));
			System.out.println("Entered newly created questionnaire in the filter field.");
			ngDriver.waitForAngularRequestsToFinish();

			// verify copied questionnaire is displayed or not
			switchVerification("questionnaire_copiedrecord_XPATH", "2021",
					"The copied questionnaire is not displayed.");

			// click on the copied questionnaire
			click("questionnaire_copiedrecord_XPATH");
			ngDriver.waitForAngularRequestsToFinish();
			System.out.println("click on the copied questionnaire");

			// update the questionnaire title
			clear("questionnaire_questionnairetitletxt_CSS");
			ngDriver.waitForAngularRequestsToFinish();
			System.out.println("Cleared the questionnaire title field.");
			type("questionnaire_questionnairetitletxt_CSS", data.get("copied_questionnaire_title"));
			System.out.println("The data entered in the Questionnaire Title field.");

			// scroll down the screen
			JavascriptExecutor js = (JavascriptExecutor) driver;
			js.executeScript("window.scrollBy(0,500)");

			// click on the save button
			click("questionnaire_savebtn_BTNTEXT");
			System.out.println("Clicked on the save button");
			ngDriver.waitForAngularRequestsToFinish();
			System.out.println("Navigate to the list of questionnaire screen.");

			// enter newly created questionnaire in the filter field
			clear("ssc_company2_questionnairelist_filtertxt_CSS");
			ngDriver.waitForAngularRequestsToFinish();
			type("ssc_company2_questionnairelist_filtertxt_CSS", data.get("copied_questionnaire_title"));
			System.out.println("Entered newly created questionnaire in the filter field.");
			ngDriver.waitForAngularRequestsToFinish();

			// verify copied questionnaire is displayed or not
			switchVerification("questionnaire_copiedrecord4_XPATH", "Test Copied Questionnaire Copy Four Title",
					"The copied questionnaire is not displayed.");

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

		// VERIFY QUESTONNAIRES IN SURVEY MODULE

		System.out.println("******************** VERIFY QUESTONNAIRES IN SURVEY MODULE ********************");
		test.log(LogStatus.INFO, "******************** VERIFY QUESTONNAIRES IN SURVEY MODULE ********************");
		Reporter.log("******************** VERIFY QUESTONNAIRES IN SURVEY MODULE ********************");
		log.info("******************** VERIFY QUESTONNAIRES IN SURVEY MODULE ********************");

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

			// click on the survey option from side menu
			click("surveyoption_XPATH");
			System.out.println("Clicked on the survey option from side menu");
			ngDriver.waitForAngularRequestsToFinish();
			System.out.println("Navigate to the survey screen");

			// verify the questionnaires count displayed correct or not
			WebElement drop_down = driver.findElement(By.cssSelector(OR.getProperty("survey_questionnairedd_CSS")));
			Select se = new Select(drop_down);
			List<WebElement> options = se.getOptions();

			int optionsize = options.size();
			System.out.println("Count of the options : " + optionsize);
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
						ngDriver.waitForAngularRequestsToFinish();
						System.out.println("Selected the questionnaire from the dropdown.");

						boolean ans1 = driver
								.findElement(By.cssSelector(OR.getProperty("survey_selectedyesanswer_CSS")))
								.isDisplayed();

						System.out.println("////////////////////" + ans1);

						if (ans1 == true) {
							System.out.println("The question one is displayed selected.");
							test.log(LogStatus.INFO, "The question one is displayed selected.");
							Reporter.log("The question one is displayed selected.");
							log.info("The question one is displayed selected.");

						} else {
							TestUtil.captureScreenshot();

							// ReportNG
							Reporter.log("<br>" + "The question one is not displayed selected. : " + "<br>");
							Reporter.log("<a target=\"_blank\" href=" + TestUtil.screenshotName + "><img src="
									+ TestUtil.screenshotName + " height=200 width=200></img></a>");
							Reporter.log("<br>");
							Reporter.log("<br>");

							// Extent Report
							test.log(LogStatus.FAIL, " The question one is not displayed selected. : ");
							test.log(LogStatus.FAIL, test.addScreenCapture(TestUtil.screenshotName));

							System.out.println("The question one is not displayed selected.");
							log.info("The question one is not displayed selected.");
						}

						String opt1 = driver.findElement(By.cssSelector(OR.getProperty("survey_option_q1o1_CSS")))
								.getAttribute("value");

						System.out.println("////////////////////////" + opt1);

						if (opt1.equals(data.get("description"))) {
							System.out.println("The text of the option one is displayed.");
							test.log(LogStatus.INFO, "The text of the option one is displayed.");
							Reporter.log("The text of the option one is displayed.");
							log.info("The text of the option one is displayed.");
						} else {
							TestUtil.captureScreenshot();

							// ReportNG
							Reporter.log("<br>" + "The text of the option one is not displayed. : " + "<br>");
							Reporter.log("<a target=\"_blank\" href=" + TestUtil.screenshotName + "><img src="
									+ TestUtil.screenshotName + " height=200 width=200></img></a>");
							Reporter.log("<br>");
							Reporter.log("<br>");

							// Extent Report
							test.log(LogStatus.FAIL, " The text of the option one is not displayed. : ");
							test.log(LogStatus.FAIL, test.addScreenCapture(TestUtil.screenshotName));

							System.out.println("The text of the option one is not displayed.");
							log.info("The text of the option one is not displayed.");
						}
					} else if (stringOption.equals(data.get("copied_questionnaire_title"))) {

						// wait for 3 seconds
						Thread.sleep(3000);

						// select the questionnaire from the dropdown
						select("survey_questionnairedd_CSS", stringOption);
						ngDriver.waitForAngularRequestsToFinish();
						System.out.println("Selected the questionnaire from the dropdown.");

						boolean ans2 = driver
								.findElement(By.cssSelector(OR.getProperty("survey_selectedyesanswer_CSS")))
								.isDisplayed();

						System.out.println("////////////////////" + ans2);

						if (ans2 == true) {
							System.out.println("The question one is displayed selected.");
							test.log(LogStatus.INFO, "The question one is displayed selected.");
							Reporter.log("The question one is displayed selected.");
							log.info("The question one is displayed selected.");

						} else {
							TestUtil.captureScreenshot();

							// ReportNG
							Reporter.log("<br>" + "The question one is not displayed selected. : " + "<br>");
							Reporter.log("<a target=\"_blank\" href=" + TestUtil.screenshotName + "><img src="
									+ TestUtil.screenshotName + " height=200 width=200></img></a>");
							Reporter.log("<br>");
							Reporter.log("<br>");

							// Extent Report
							test.log(LogStatus.FAIL, " The question one is not displayed selected. : ");
							test.log(LogStatus.FAIL, test.addScreenCapture(TestUtil.screenshotName));

							System.out.println("The question one is not displayed selected.");
							log.info("The question one is not displayed selected.");
						}

						String opt2 = driver.findElement(By.cssSelector(OR.getProperty("survey_option_q1o1_CSS")))
								.getAttribute("value");

						System.out.println("////////////////////////" + opt2);

						if (opt2.equals(data.get("description"))) {
							System.out.println("The text of the option one is displayed.");
							test.log(LogStatus.INFO, "The text of the option one is displayed.");
							Reporter.log("The text of the option one is displayed.");
							log.info("The text of the option one is displayed.");
						} else {
							TestUtil.captureScreenshot();

							// ReportNG
							Reporter.log("<br>" + "The text of the option one is not displayed. : " + "<br>");
							Reporter.log("<a target=\"_blank\" href=" + TestUtil.screenshotName + "><img src="
									+ TestUtil.screenshotName + " height=200 width=200></img></a>");
							Reporter.log("<br>");
							Reporter.log("<br>");

							// Extent Report
							test.log(LogStatus.FAIL, " The text of the option one is not displayed. : ");
							test.log(LogStatus.FAIL, test.addScreenCapture(TestUtil.screenshotName));

							System.out.println("The text of the option one is not displayed.");
							log.info("The text of the option one is not displayed.");
						}

						try {
							// verify submit button is displayed or not
							boolean submitbtn = driver
									.findElement(By.xpath(OR.getProperty("questionnaire_submitbtn_XPATH")))
									.isDisplayed();

							if (submitbtn == true) {
								System.out.println("The submit button is displayed as expected.");
								test.log(LogStatus.INFO, "The submit button is displayed as expected.");
								Reporter.log("The submit button is displayed as expected.");
								log.info("The submit button is displayed as expected.");
							} else {
								verificationFailed();
							}
						} catch (Throwable t) {
							TestUtil.captureScreenshot();

							// ReportNG
							Reporter.log("<br>" + "The submit button is not displayed. : " + "<br>");
							Reporter.log("<a target=\"_blank\" href=" + TestUtil.screenshotName + "><img src="
									+ TestUtil.screenshotName + " height=200 width=200></img></a>");
							Reporter.log("<br>");
							Reporter.log("<br>");

							// Extent Report
							test.log(LogStatus.FAIL, " The submit button is not displayed. : ");
							test.log(LogStatus.FAIL, test.addScreenCapture(TestUtil.screenshotName));

							System.out.println("The submit button is not displayed.");
							log.info("The submit button is not displayed.");
						}
					}
				}
			}

			if (count == 2) {
				System.out.println("The questionnaire count is displayed correctly.");
				test.log(LogStatus.INFO, "The questionnaire count is displayed correctly.");
				Reporter.log("The questionnaire count is displayed correctly.");
				log.info("The questionnaire count is displayed correctly.");

			} else {
				TestUtil.captureScreenshot();

				// ReportNG
				Reporter.log("<br>" + "The questionnaire count is not displayed correctly. : " + "<br>");
				Reporter.log("<a target=\"_blank\" href=" + TestUtil.screenshotName + "><img src="
						+ TestUtil.screenshotName + " height=200 width=200></img></a>");
				Reporter.log("<br>");
				Reporter.log("<br>");

				// Extent Report
				test.log(LogStatus.FAIL, " The questionnaire count is not displayed correctly. : ");
				test.log(LogStatus.FAIL, test.addScreenCapture(TestUtil.screenshotName));

				System.out.println("The questionnaire count is not displayed correctly.");
				log.info("The questionnaire count is not displayed correctly.");
			}

		} catch (Throwable t) {
			verificationFailed();
		}

		// click on the Home button
		click("questionnaire_homeburgermenubtn_hide_CSS");
		System.out.println("Clicked on the home button.");
		ngDriver.waitForAngularRequestsToFinish();
		System.out.println("Navigate to the Home Screen i.e. property listing screen.");

		// wait for the element
		explicitWait("propertylist_title_XPATH");

		// verify the property list
		switchVerification("propertylist_title_XPATH", "Property List", "The property list is not displayed.");

		// DELETE THE NEW QUESTIONNAIRE

		System.out.println("******************** DELETE THE NEW QUESTIONNAIRE ********************");
		test.log(LogStatus.INFO, "******************** DELETE THE NEW QUESTIONNAIRE ********************");
		Reporter.log("******************** DELETE THE NEW QUESTIONNAIRE ********************");
		log.info("******************** DELETE THE NEW QUESTIONNAIRE ********************");

		try {
			// wait for the element
			Thread.sleep(5000);

			// click on the settings icon from the top of the screen
			click("questionnaire_settingicon_CSS");
			System.out.println("Clicked on the settings icon.");
			ngDriver.waitForAngularRequestsToFinish();

			// wait for the element
			Thread.sleep(5000);

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
			type("ssc_company2_questionnairelist_filtertxt_CSS", data.get("copied_questionnaire_title"));
			System.out.println("Entered newly created questionnaire in the filter field.");
			ngDriver.waitForAngularRequestsToFinish();

			// click on the copied questionnaire on the property level
			click("questionnaire_copiedrecord4_XPATH");
			System.out.println("Clicked on the copied questionnaire on the property level.");
			ngDriver.waitForAngularRequestsToFinish();

			// enter the random string in the questionnaire title field: clear, generate
			// string, enter

			String s = RandomStringUtils.randomAlphabetic(8);

			// enter the group title
			clear("questionnaire_grouptitletxt_CSS");
			System.out.println("Cleared the random string in the Group Title field.");
			type("questionnaire_grouptitletxt_CSS", s);
			ngDriver.waitForAngularRequestsToFinish();
			System.out.println("The data entered in the Group Title field.");

			// enter the questionnaire title
			clear("questionnaire_questionnairetitletxt_CSS");
			System.out.println("Cleared the random string in the questionnaire title field.");
			type("questionnaire_questionnairetitletxt_CSS", s);
			ngDriver.waitForAngularRequestsToFinish();
			System.out.println("Entered the random text in the questionnaire title field.");

			// scroll down the screen
			JavascriptExecutor js = (JavascriptExecutor) driver;
			js.executeScript("window.scrollBy(0,400)");

			// click on the save button
			click("questionnaire_savebtn_BTNTEXT");
			System.out.println("Clicked on the save button.");
			ngDriver.waitForAngularRequestsToFinish();

			// scroll up the screen
			js.executeScript("window.scrollBy(0,-400)");

			// wait for the search field
			explicitWait("ssc_company2_questionnairelist_filtertxt_CSS");

			// enter newly created questionnaire in the filter field
			clear("ssc_company2_questionnairelist_filtertxt_CSS");
			ngDriver.waitForAngularRequestsToFinish();
			type("ssc_company2_questionnairelist_filtertxt_CSS", data.get("questionnaire_title"));
			System.out.println("Entered newly created questionnaire in the filter field.");
			ngDriver.waitForAngularRequestsToFinish();

			// verify newly created questionnaire for survey
			switchVerification("questionnaire_createdrecordcopy_4_XPATH", "Test Questionnaire Copy Four Title",
					"The Test Questionnaire Copy Four Title record is not displayed in the questionnaire list.");

			// click on the newly created questionnaire on the property level
			click("questionnaire_createdrecordcopy_4_XPATH");
			System.out.println("Clicked on the newly created questionnaire on the property level.");
			ngDriver.waitForAngularRequestsToFinish();

			// UPDATE THE QUESTIONNAIRE TITLE WITH RANDOM TEXT

			System.out.println("***************** UPDATE THE QUESTIONNAIRE TITLE WITH RANDOM TEXT *****************");
			test.log(LogStatus.INFO,
					"***************** UPDATE THE QUESTIONNAIRE TITLE WITH RANDOM TEXT *****************");
			Reporter.log("***************** UPDATE THE QUESTIONNAIRE TITLE WITH RANDOM TEXT *****************");
			log.info("***************** UPDATE THE QUESTIONNAIRE TITLE WITH RANDOM TEXT *****************");

			String s1 = RandomStringUtils.randomAlphabetic(8);

			// enter the group title
			clear("questionnaire_grouptitletxt_CSS");
			System.out.println("Cleared the random string in the Group Title field.");
			type("questionnaire_grouptitletxt_CSS", s1);
			ngDriver.waitForAngularRequestsToFinish();
			System.out.println("The data entered in the Group Title field.");

			// enter the questionnaire title
			clear("questionnaire_questionnairetitletxt_CSS");
			System.out.println("Cleared the random string in the questionnaire title field.");
			type("questionnaire_questionnairetitletxt_CSS", s1);
			ngDriver.waitForAngularRequestsToFinish();
			System.out.println("Entered the random text in the questionnaire title field.");

			// scroll down the screen
			js.executeScript("window.scrollBy(0,400)");

			// click on the save button
			click("questionnaire_savebtn_BTNTEXT");
			System.out.println("Clicked on the save button.");
			ngDriver.waitForAngularRequestsToFinish();

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

	}
}
