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

		if (!(TestUtil.isTestRunnable("rR5595Morguard8Test", excel))) {

			throw new SkipException(
					"Skipping the test " + "rR5595Morguard8Test".toUpperCase() + "as the Run mode is NO");
		}

		if (!data.get("runmode").equals("Y")) {

			throw new SkipException("Skipping the test case as the Run Mode for data set is NO");
		}

		Helper helper = new Helper();

		// refresh the page
		driver.navigate().refresh();
		Thread.sleep(5000);
		driver.navigate().refresh();

		// LOGIN WITH ADMIN USER

		System.out.println("******************** LOGIN WITH ADMIN USER ********************");
		test.log(LogStatus.INFO, "******************** LOGIN WITH ADMIN USER ********************");
		Reporter.log("******************** LOGIN WITH ADMIN USER ********************");
		log.info("******************** LOGIN WITH ADMIN USER ********************");

		try {
			// wait for the element
			explicitWaitClickable("signinbtn_BTNTEXT");

			// Enter the username
			type("usernametxt_CSS", data.get("username_1"));
			ngDriver.waitForAngularRequestsToFinish();
			System.out.println("Entered the username.");

			// Enter the password
			type("passwordtxt_CSS", data.get("password_1"));
			ngDriver.waitForAngularRequestsToFinish();
			System.out.println("Entered the password.");

			// Clicking on the "Sign In" button
			click("signinbtn_BTNTEXT");
			ngDriver.waitForAngularRequestsToFinish();
			System.out.println("Clicked on the sign in button.");

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

		System.out.println("******************** VERIFY THE QUESTIONNAIRE IS DISPLAYED LOCKED ********************");
		test.log(LogStatus.INFO,
				"******************** VERIFY THE QUESTIONNAIRE IS DISPLAYED LOCKED ********************");
		Reporter.log("******************** VERIFY THE QUESTIONNAIRE IS DISPLAYED LOCKED ********************");
		log.info("******************** VERIFY THE QUESTIONNAIRE IS DISPLAYED LOCKED ********************");

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
					ngDriver.waitForAngularRequestsToFinish();
					System.out.println("Clicked on the unlock icon.");

					System.out.println("THE QUESTIONNAIRE IS DISPLAYED LOCK AS EXPECTED.");
					test.log(LogStatus.INFO, "THE QUESTIONNAIRE IS DISPLAYED LOCK AS EXPECTED.");
					Reporter.log("THE QUESTIONNAIRE IS DISPLAYED LOCK AS EXPECTED.");
					log.info("THE QUESTIONNAIRE IS DISPLAYED LOCK AS EXPECTED.");
				} else {

					System.out.println("THE QUESTIONNAIRE IS DISPLAYED LOCK AS EXPECTED.");
					test.log(LogStatus.INFO, "THE QUESTIONNAIRE IS DISPLAYED LOCK AS EXPECTED.");
					Reporter.log("THE QUESTIONNAIRE IS DISPLAYED LOCK AS EXPECTED.");
					log.info("THE QUESTIONNAIRE IS DISPLAYED LOCK AS EXPECTED.");

				}
			} catch (Throwable t) {

				System.out.println("THE QUESTIONNAIRE IS DISPLAYED LOCK AS EXPECTED.");
				test.log(LogStatus.INFO, "THE QUESTIONNAIRE IS DISPLAYED LOCK AS EXPECTED.");
				Reporter.log("THE QUESTIONNAIRE IS DISPLAYED LOCK AS EXPECTED.");
				log.info("THE QUESTIONNAIRE IS DISPLAYED LOCK AS EXPECTED.");
			}

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

		// VERIFY LOCKED QUESTIONNAIRE IS DISPLAYED IN THE ALERT AND NOTIFICATION
		// SECTION

		System.out.println(
				"******************** VERIFY LOCKED QUESTIONNAIRE IS DISPLAYED IN THE ALERT AND NOTIFICATION SECTION ********************");
		test.log(LogStatus.INFO,
				"******************** VERIFY LOCKED QUESTIONNAIRE IS DISPLAYED IN THE ALERT AND NOTIFICATION SECTION ********************");
		Reporter.log(
				"******************** VERIFY LOCKED QUESTIONNAIRE IS DISPLAYED IN THE ALERT AND NOTIFICATION SECTION ********************");
		log.info(
				"******************** VERIFY LOCKED QUESTIONNAIRE IS DISPLAYED IN THE ALERT AND NOTIFICATION SECTION ********************");

		try {
			// enter the property name in the search field
			clear("envreports_propertylist_filtertxt_CSS");
			type("envreports_propertylist_filtertxt_CSS", data.get("property_2"));
			ngDriver.waitForAngularRequestsToFinish();
			System.out.println("Entered the property name in the search field.");

			// click on the environmental icon from the property list page
			click("environmentalicon_CSS");
			System.out.println("Clicked on the environmental icon of the Property.");
			ngDriver.waitForAngularRequestsToFinish();
			System.out.println("Navigate to the environmental screen of the perticular property.");

			try {
				// verify locked questionnaire is displayed or not
				boolean lockedquestionnaire = driver
						.findElement(By
								.xpath(OR.getProperty("environmentalsummary_alertandnotification_activesurvey_XPATH")))
						.isDisplayed();

				if (lockedquestionnaire == true) {
					System.out.println(
							"THE LOCKED QUESTIONNAIRE IS NOT DISPLAYED IN THE ALERT AND NOTIFICATION SECTION AS EXPECTED.");
					test.log(LogStatus.INFO,
							"THE LOCKED QUESTIONNAIRE IS NOT DISPLAYED IN THE ALERT AND NOTIFICATION SECTION AS EXPECTED.");
					Reporter.log(
							"THE LOCKED QUESTIONNAIRE IS NOT DISPLAYED IN THE ALERT AND NOTIFICATION SECTION AS EXPECTED.");
					log.info(
							"THE LOCKED QUESTIONNAIRE IS NOT DISPLAYED IN THE ALERT AND NOTIFICATION SECTION AS EXPECTED.");
				} else {

					verificationFailed();

					System.out.println("THE LOCKED QUESTIONNAIRE IS DISPLAYED IN THE ALERT AND NOTIFICATION SECTION.");
					test.log(LogStatus.INFO,
							"THE LOCKED QUESTIONNAIRE IS DISPLAYED IN THE ALERT AND NOTIFICATION SECTION.");
					Reporter.log("THE LOCKED QUESTIONNAIRE IS DISPLAYED IN THE ALERT AND NOTIFICATION SECTION.");
					log.info("THE LOCKED QUESTIONNAIRE IS DISPLAYED IN THE ALERT AND NOTIFICATION SECTION.");

				}

			} catch (Throwable t) {
				verificationFailed();

				System.out.println("THE LOCKED QUESTIONNAIRE IS DISPLAYED IN THE ALERT AND NOTIFICATION SECTION.");
				test.log(LogStatus.INFO,
						"THE LOCKED QUESTIONNAIRE IS DISPLAYED IN THE ALERT AND NOTIFICATION SECTION.");
				Reporter.log("THE LOCKED QUESTIONNAIRE IS DISPLAYED IN THE ALERT AND NOTIFICATION SECTION.");
				log.info("THE LOCKED QUESTIONNAIRE IS DISPLAYED IN THE ALERT AND NOTIFICATION SECTION.");
			}

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

		// VERIFY THE QUESTIONNAIRE IS DISPLAYED UNLOCKED

		System.out.println("******************** VERIFY THE QUESTIONNAIRE IS DISPLAYED UNLOCKED ********************");
		test.log(LogStatus.INFO,
				"******************** VERIFY THE QUESTIONNAIRE IS DISPLAYED UNLOCKED ********************");
		Reporter.log("******************** VERIFY THE QUESTIONNAIRE IS DISPLAYED UNLOCKED ********************");
		log.info("******************** VERIFY THE QUESTIONNAIRE IS DISPLAYED UNLOCKED ********************");

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

			// verify newly created questionnaire for survey
			switchVerification("questionnaire_activesurvey_XPATH", "MORGUARD - Climate Change Questionnaire",
					"The MORGUARD - Climate Change Questionnaire record is not displayed in the questionnaire list.");

			try {
				// make questionnaire unlocked
				boolean unlockicon = driver
						.findElement(By.xpath(OR.getProperty("questionnaire_activesurvey_unlockicon_XPATH")))
						.isDisplayed();

				if (unlockicon == true) {

					System.out.println("THE QUESTIONNAIRE IS DISPLAYED UNLOCK AS EXPECTED.");
					test.log(LogStatus.INFO, "THE QUESTIONNAIRE IS DISPLAYED UNLOCK AS EXPECTED.");
					Reporter.log("THE QUESTIONNAIRE IS DISPLAYED UNLOCK AS EXPECTED.");
					log.info("THE QUESTIONNAIRE IS DISPLAYED UNLOCK AS EXPECTED.");
				} else {

					// click on the lock icon
					click("questionnaire_activesurvey_lockicon_XPATH");
					ngDriver.waitForAngularRequestsToFinish();
					System.out.println("Clicked on the unlock icon.");

					System.out.println("THE QUESTIONNAIRE IS DISPLAYED UNLOCK AS EXPECTED.");
					test.log(LogStatus.INFO, "THE QUESTIONNAIRE IS DISPLAYED UNLOCK AS EXPECTED.");
					Reporter.log("THE QUESTIONNAIRE IS DISPLAYED UNLOCK AS EXPECTED.");
					log.info("THE QUESTIONNAIRE IS DISPLAYED UNLOCK AS EXPECTED.");

				}
			} catch (Throwable t) {

				// click on the lock icon
				click("questionnaire_activesurvey_lockicon_XPATH");
				ngDriver.waitForAngularRequestsToFinish();
				System.out.println("Clicked on the unlock icon.");

				System.out.println("THE QUESTIONNAIRE IS DISPLAYED UNLOCK AS EXPECTED.");
				test.log(LogStatus.INFO, "THE QUESTIONNAIRE IS DISPLAYED UNLOCK AS EXPECTED.");
				Reporter.log("THE QUESTIONNAIRE IS DISPLAYED UNLOCK AS EXPECTED.");
				log.info("THE QUESTIONNAIRE IS DISPLAYED UNLOCK AS EXPECTED.");
			}

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

		// VERIFY UNLOCKED QUESTIONNAIRE IS DISPLAYED IN THE ALERT AND NOTIFICATION
		// SECTION

		System.out.println(
				"******************** VERIFY UNLOCKED QUESTIONNAIRE IS DISPLAYED IN THE ALERT AND NOTIFICATION SECTION ********************");
		test.log(LogStatus.INFO,
				"******************** VERIFY UNLOCKED QUESTIONNAIRE IS DISPLAYED IN THE ALERT AND NOTIFICATION SECTION ********************");
		Reporter.log(
				"******************** VERIFY UNLOCKED QUESTIONNAIRE IS DISPLAYED IN THE ALERT AND NOTIFICATION SECTION ********************");
		log.info(
				"******************** VERIFY UNLOCKED QUESTIONNAIRE IS DISPLAYED IN THE ALERT AND NOTIFICATION SECTION ********************");

		try {
			// enter the property name in the search field
			clear("envreports_propertylist_filtertxt_CSS");
			type("envreports_propertylist_filtertxt_CSS", data.get("property_2"));
			ngDriver.waitForAngularRequestsToFinish();
			System.out.println("Entered the property name in the search field.");

			// click on the environmental icon from the property list page
			click("environmentalicon_CSS");
			System.out.println("Clicked on the environmental icon of the Property.");
			ngDriver.waitForAngularRequestsToFinish();
			System.out.println("Navigate to the environmental screen of the perticular property.");

			try {
				// verify unlocked questionnaire is displayed or not
				boolean unlockedquestionnaire = driver
						.findElement(By
								.xpath(OR.getProperty("environmentalsummary_alertandnotification_activesurvey_XPATH")))
						.isDisplayed();

				if (unlockedquestionnaire == true) {
					System.out.println(
							"THE LOCKED QUESTIONNAIRE IS NOT DISPLAYED IN THE ALERT AND NOTIFICATION SECTION AS EXPECTED.");
					test.log(LogStatus.INFO,
							"THE LOCKED QUESTIONNAIRE IS NOT DISPLAYED IN THE ALERT AND NOTIFICATION SECTION AS EXPECTED.");
					Reporter.log(
							"THE LOCKED QUESTIONNAIRE IS NOT DISPLAYED IN THE ALERT AND NOTIFICATION SECTION AS EXPECTED.");
					log.info(
							"THE LOCKED QUESTIONNAIRE IS NOT DISPLAYED IN THE ALERT AND NOTIFICATION SECTION AS EXPECTED.");
				} else {

					verificationFailed();

					System.out.println("THE LOCKED QUESTIONNAIRE IS DISPLAYED IN THE ALERT AND NOTIFICATION SECTION.");
					test.log(LogStatus.INFO,
							"THE LOCKED QUESTIONNAIRE IS DISPLAYED IN THE ALERT AND NOTIFICATION SECTION.");
					Reporter.log("THE LOCKED QUESTIONNAIRE IS DISPLAYED IN THE ALERT AND NOTIFICATION SECTION.");
					log.info("THE LOCKED QUESTIONNAIRE IS DISPLAYED IN THE ALERT AND NOTIFICATION SECTION.");

				}

			} catch (Throwable t) {
				verificationFailed();

				System.out.println("THE LOCKED QUESTIONNAIRE IS DISPLAYED IN THE ALERT AND NOTIFICATION SECTION.");
				test.log(LogStatus.INFO,
						"THE LOCKED QUESTIONNAIRE IS DISPLAYED IN THE ALERT AND NOTIFICATION SECTION.");
				Reporter.log("THE LOCKED QUESTIONNAIRE IS DISPLAYED IN THE ALERT AND NOTIFICATION SECTION.");
				log.info("THE LOCKED QUESTIONNAIRE IS DISPLAYED IN THE ALERT AND NOTIFICATION SECTION.");
			}

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

		// COPY THE QUESTIONNAIRE WITHOUT AN ANSWER, WHERE ANSWERS ARE NOT ADDED WHILE
		// PERFORMING THE SURVEY.

		System.out.println(
				"******************** COPY THE QUESTIONNAIRE WITHOUT AN ANSWER, WHERE ANSWERS ARE NOT ADDED WHILE PERFORMING THE SURVEY. ********************");
		test.log(LogStatus.INFO,
				"******************** COPY THE QUESTIONNAIRE WITHOUT AN ANSWER, WHERE ANSWERS ARE NOT ADDED WHILE PERFORMING THE SURVEY. ********************");
		Reporter.log(
				"******************** COPY THE QUESTIONNAIRE WITHOUT AN ANSWER, WHERE ANSWERS ARE NOT ADDED WHILE PERFORMING THE SURVEY. ********************");
		log.info(
				"******************** COPY THE QUESTIONNAIRE WITHOUT AN ANSWER, WHERE ANSWERS ARE NOT ADDED WHILE PERFORMING THE SURVEY. ********************");

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
			type("ssc_company2_questionnairelist_filtertxt_CSS", data.get("questionnaire_title_copy"));
			System.out.println("Entered newly created questionnaire in the filter field.");
			ngDriver.waitForAngularRequestsToFinish();

			// verify newly created questionnaire for survey
			switchVerification("questionnaire_activesurvey_copy_XPATH",
					"Morguard - 2021 Summer - Environmental Compliance Audit",
					"The Morguard - 2021 Summer - Environmental Compliance Audit record is not displayed in the questionnaire list.");

			// click on the copy icon
			click("questionnaire_createdrecordcopy_copyicon_CSS");
			ngDriver.waitForAngularRequestsToFinish();
			System.out.println("Clicked on the copy icon.");

			// click on the copy button
			click("questionnaire_createdrecordcopy_copybtn_XPATH");
			ngDriver.waitForAngularRequestsToFinish();
			System.out.println("Clicked on the copy button.");

			// enter newly created questionnaire in the filter field
			clear("ssc_company2_questionnairelist_filtertxt_CSS");
			ngDriver.waitForAngularRequestsToFinish();
			type("ssc_company2_questionnairelist_filtertxt_CSS", data.get("questionnaire_title_copy"));
			System.out.println("Entered newly created questionnaire in the filter field.");
			ngDriver.waitForAngularRequestsToFinish();

			// verify copied questionnaire is displayed or not
			switchVerification("questionnaire_activesurvey_copiedrecord_XPATH", "November",
					"The copied questionnaire is not displayed.");

		} catch (Throwable t) {
			questionnaireNotDisplay();
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

			// enter the property name in the search field
			clear("envreports_propertylist_filtertxt_CSS");
			type("envreports_propertylist_filtertxt_CSS", data.get("property_2"));
			ngDriver.waitForAngularRequestsToFinish();
			System.out.println("Entered the property name in the search field.");

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

				if (stringOption.equals(data.get("questionnaire_title_copy"))) {
					count = count + 1;

				}
			}

			if (count == 2) {
				System.out.println("THE QUESTIONNAIRE COUNT IS DISPLAYED CORRECTLY.");
				test.log(LogStatus.INFO, "THE QUESTIONNAIRE COUNT IS DISPLAYED CORRECTLY.");
				Reporter.log("THE QUESTIONNAIRE COUNT IS DISPLAYED CORRECTLY.");
				log.info("THE QUESTIONNAIRE COUNT IS DISPLAYED CORRECTLY.");

			} else {

				verificationFailed();

				System.out.println("THE COPIED QUESTIONNAIRE IS NOT DISPLAYED IN THE PROPERTY LEVEL.");
				test.log(LogStatus.INFO, "THE COPIED QUESTIONNAIRE IS NOT DISPLAYED IN THE PROPERTY LEVEL.");
				Reporter.log("THE COPIED QUESTIONNAIRE IS NOT DISPLAYED IN THE PROPERTY LEVEL.");
				log.info("THE COPIED QUESTIONNAIRE IS NOT DISPLAYED IN THE PROPERTY LEVEL.");

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

		// DELETE THE COPIED QUESTIONNAIRE

		System.out.println("******************** DELETE THE COPIED QUESTIONNAIRE ********************");
		test.log(LogStatus.INFO, "******************** DELETE THE COPIED QUESTIONNAIRE ********************");
		Reporter.log("******************** DELETE THE COPIED QUESTIONNAIRE ********************");
		log.info("******************** DELETE THE COPIED QUESTIONNAIRE ********************");

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
			type("ssc_company2_questionnairelist_filtertxt_CSS", data.get("questionnaire_title_copy"));
			System.out.println("Entered newly created questionnaire in the filter field.");
			ngDriver.waitForAngularRequestsToFinish();

			// verify copied questionnaire is displayed or not
			switchVerification("questionnaire_activesurvey_copiedrecord_XPATH", "November",
					"The copied questionnaire is not displayed.");

			// click on the newly created questionnaire on the property level
			click("questionnaire_activesurvey_copiedrecord_XPATH");
			System.out.println("Clicked on the newly created questionnaire on the property level.");
			ngDriver.waitForAngularRequestsToFinish();

			// scroll till the delete button
			WebElement element5 = driver.findElement(By.cssSelector(OR.getProperty("questionnaire_deletebtn_CSS")));
			JavascriptExecutor js = (JavascriptExecutor) driver;
			js.executeScript("arguments[0].scrollIntoView();", element5);

			// click on the delete button
			click("questionnaire_deletebtn_CSS");
			System.out.println("Clicked on the delete button.");
			ngDriver.waitForAngularRequestsToFinish();

			// wait for the delete button
			explicitWaitClickable("questionnaire_modeldeletebtn_CSS");

			// click on the delete button of the confirmation popup
			click("questionnaire_modeldeletebtn_CSS");
			System.out.println("Clicked on the delete button of the confirmation popup.");
			ngDriver.waitForAngularRequestsToFinish();

			// wait for the search field
			explicitWait("ssc_company2_questionnairelist_filtertxt_CSS");

			// enter newly created questionnaire in the filter field
			clear("ssc_company2_questionnairelist_filtertxt_CSS");
			type("ssc_company2_questionnairelist_filtertxt_CSS", data.get("questionnaire_title_copy"));
			System.out.println("Entered newly created questionnaire in the filter field.");
			ngDriver.waitForAngularRequestsToFinish();

			// verify copied questionnaire is displayed or not
			deleteVerification("questionnaire_activesurvey_copiedrecord_XPATH", "November");

		} catch (Throwable t) {
			questionnaireNotDisplay();
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

		// THE SURVEY SHOULD BE COMPLETED WITH 100% IN PERCENTAGE BAR AND ABLE TO
		// APPROVE THE SURVEY

		System.out.println(
				"******************** THE SURVEY SHOULD BE COMPLETED WITH 100% IN PERCENTAGE BAR AND ABLE TO APPROVE THE SURVEY ********************");
		test.log(LogStatus.INFO,
				"******************** THE SURVEY SHOULD BE COMPLETED WITH 100% IN PERCENTAGE BAR AND ABLE TO APPROVE THE SURVEY ********************");
		Reporter.log(
				"******************** THE SURVEY SHOULD BE COMPLETED WITH 100% IN PERCENTAGE BAR AND ABLE TO APPROVE THE SURVEY ********************");
		log.info(
				"******************** THE SURVEY SHOULD BE COMPLETED WITH 100% IN PERCENTAGE BAR AND ABLE TO APPROVE THE SURVEY ********************");

		// VERIFY THE QUESTIONNAIRE IS DISPLAYED UNLOCKED

		System.out.println("******************** VERIFY THE QUESTIONNAIRE IS DISPLAYED UNLOCKED ********************");
		test.log(LogStatus.INFO,
				"******************** VERIFY THE QUESTIONNAIRE IS DISPLAYED UNLOCKED ********************");
		Reporter.log("******************** VERIFY THE QUESTIONNAIRE IS DISPLAYED UNLOCKED ********************");
		log.info("******************** VERIFY THE QUESTIONNAIRE IS DISPLAYED UNLOCKED ********************");

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

			// verify newly created questionnaire for survey
			switchVerification("questionnaire_activesurvey_XPATH", "MORGUARD - Climate Change Questionnaire",
					"The MORGUARD - Climate Change Questionnaire record is not displayed in the questionnaire list.");

			try {
				// make questionnaire unlocked
				boolean unlockicon = driver
						.findElement(By.xpath(OR.getProperty("questionnaire_activesurvey_unlockicon_XPATH")))
						.isDisplayed();

				if (unlockicon == true) {

					System.out.println("THE QUESTIONNAIRE IS DISPLAYED UNLOCK AS EXPECTED.");
					test.log(LogStatus.INFO, "THE QUESTIONNAIRE IS DISPLAYED UNLOCK AS EXPECTED.");
					Reporter.log("THE QUESTIONNAIRE IS DISPLAYED UNLOCK AS EXPECTED.");
					log.info("THE QUESTIONNAIRE IS DISPLAYED UNLOCK AS EXPECTED.");
				} else {

					// click on the lock icon
					click("questionnaire_activesurvey_lockicon_XPATH");
					ngDriver.waitForAngularRequestsToFinish();
					System.out.println("Clicked on the unlock icon.");

					System.out.println("THE QUESTIONNAIRE IS DISPLAYED UNLOCK AS EXPECTED.");
					test.log(LogStatus.INFO, "THE QUESTIONNAIRE IS DISPLAYED UNLOCK AS EXPECTED.");
					Reporter.log("THE QUESTIONNAIRE IS DISPLAYED UNLOCK AS EXPECTED.");
					log.info("THE QUESTIONNAIRE IS DISPLAYED UNLOCK AS EXPECTED.");

				}
			} catch (Throwable t) {

				// click on the lock icon
				click("questionnaire_activesurvey_lockicon_XPATH");
				ngDriver.waitForAngularRequestsToFinish();
				System.out.println("Clicked on the unlock icon.");

				System.out.println("THE QUESTIONNAIRE IS DISPLAYED UNLOCK AS EXPECTED.");
				test.log(LogStatus.INFO, "THE QUESTIONNAIRE IS DISPLAYED UNLOCK AS EXPECTED.");
				Reporter.log("THE QUESTIONNAIRE IS DISPLAYED UNLOCK AS EXPECTED.");
				log.info("THE QUESTIONNAIRE IS DISPLAYED UNLOCK AS EXPECTED.");
			}

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

		// GIVE ALL THE ANSWERS AND SUBMIT THE SURVEY

		System.out.println("******************** GIVE ALL THE ANSWERS AND SUBMIT THE SURVEY ********************");
		test.log(LogStatus.INFO,
				"******************** GIVE ALL THE ANSWERS AND SUBMIT THE SURVEY ********************");
		Reporter.log("******************** GIVE ALL THE ANSWERS AND SUBMIT THE SURVEY ********************");
		log.info("******************** GIVE ALL THE ANSWERS AND SUBMIT THE SURVEY ********************");

		try {

			// enter the property name in the search field
			clear("envreports_propertylist_filtertxt_CSS");
			type("envreports_propertylist_filtertxt_CSS", data.get("property_2"));
			ngDriver.waitForAngularRequestsToFinish();
			System.out.println("Entered the property name in the search field.");

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
			WebElement ele14 = driver.findElement(By.xpath(OR.getProperty("survey_submitbtn_morguard_XPATH")));
			JavascriptExecutor js = (JavascriptExecutor) driver;
			js.executeScript("arguments[0].scrollIntoView(true);", ele14);

			// click on the submit button
			click("survey_submitbtn_morguard_XPATH");
			ngDriver.waitForAngularRequestsToFinish();
			System.out.println("Clicked on the submit button.");

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
		System.out.println("Clicked on the home icon from the top of the screen.");
		ngDriver.waitForAngularRequestsToFinish();

		// synchronization
		explicitWait("propertylist_title_XPATH");

		// verify the property list
		switchVerification("propertylist_title_XPATH", "Property List", "The property list is not displayed.");

		// UNSELECT ALL THE ANSWERS AND VERIFY SUBMIT BUTTON

		System.out
				.println("******************** UNSELECT ALL THE ANSWERS AND VERIFY SUBMIT BUTTON ********************");
		test.log(LogStatus.INFO,
				"******************** UNSELECT ALL THE ANSWERS AND VERIFY SUBMIT BUTTON ********************");
		Reporter.log("******************** UNSELECT ALL THE ANSWERS AND VERIFY SUBMIT BUTTON ********************");
		log.info("******************** UNSELECT ALL THE ANSWERS AND VERIFY SUBMIT BUTTON ********************");

		try {

			// enter the property name in the search field
			clear("envreports_propertylist_filtertxt_CSS");
			type("envreports_propertylist_filtertxt_CSS", data.get("property_2"));
			ngDriver.waitForAngularRequestsToFinish();
			System.out.println("Entered the property name in the search field.");

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
			switchVerification("questionnaire_questiontitle_morguard_XPATH",
					"Flood resilience plans and procedures (recommended for all buildings)",
					"The Flood resilience plans and procedures (recommended for all buildings) is not displayed.");

			// click on the reopen button
			click("survey_reopenbtn_morguard_XPATH");
			ngDriver.waitForAngularRequestsToFinish();
			System.out.println("Clicked on the reopen button.");

			// click on the reopen button of the confirmation popup
			click("survey_confirmationreopenbtn_morguard_XPATH");
			ngDriver.waitForAngularRequestsToFinish();
			System.out.println("Clicked on the reopen button of the confirmation popup.");

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
			JavascriptExecutor js = (JavascriptExecutor) driver;
			js.executeScript("window.scrollBy(0,400)");

			// verify the submit button is displayed or not

			try {
				boolean submitbtn = driver.findElement(By.xpath(OR.getProperty("survey_submitbtn_morguard_XPATH")))
						.isDisplayed();

				if (submitbtn == true) {

					verificationFailed();

					System.out.println("THE SUBMIT BUTTON IS DISPLAYED.");
					test.log(LogStatus.INFO, "THE SUBMIT BUTTON IS DISPLAYED.");
					Reporter.log("THE SUBMIT BUTTON IS DISPLAYED.");
					log.info("THE SUBMIT BUTTON IS DISPLAYED.");
				} else {

					System.out.println("THE SUBMIT BUTTON IS NOT DISPLAYED AS EXPECTED.");
					test.log(LogStatus.INFO, "THE SUBMIT BUTTON IS NOT DISPLAYED AS EXPECTED.");
					Reporter.log("THE SUBMIT BUTTON IS NOT DISPLAYED AS EXPECTED.");
					log.info("THE SUBMIT BUTTON IS NOT DISPLAYED AS EXPECTED.");

				}
			} catch (Throwable t) {
				System.out.println("THE SUBMIT BUTTON IS NOT DISPLAYED AS EXPECTED.");
				test.log(LogStatus.INFO, "THE SUBMIT BUTTON IS NOT DISPLAYED AS EXPECTED.");
				Reporter.log("THE SUBMIT BUTTON IS NOT DISPLAYED AS EXPECTED.");
				log.info("THE SUBMIT BUTTON IS NOT DISPLAYED AS EXPECTED.");
			}

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

		try {
			// wait for the element
			explicitWaitClickable("questionnaire_settingicon_CSS");

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

			// wait for the element
			explicitWaitClickable("signinbtn_BTNTEXT");

		} catch (Throwable t) {
			verificationFailed();
		}

	}
}
