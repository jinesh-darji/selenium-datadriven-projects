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

		System.out.println(
				"COPY THE QUESTIONNAIRE WITHOUT AN ANSWER, WHERE THE ORIGINAL QUESTIONNAIRE (INSPECTION / CHECKLIST) WAS LOCKED FROM THE ADMINISTRATION.");
		test.log(LogStatus.INFO,
				"COPY THE QUESTIONNAIRE WITHOUT AN ANSWER, WHERE THE ORIGINAL QUESTIONNAIRE (INSPECTION / CHECKLIST) WAS LOCKED FROM THE ADMINISTRATION.");
		Reporter.log(
				"COPY THE QUESTIONNAIRE WITHOUT AN ANSWER, WHERE THE ORIGINAL QUESTIONNAIRE (INSPECTION / CHECKLIST) WAS LOCKED FROM THE ADMINISTRATION.");
		log.info(
				"COPY THE QUESTIONNAIRE WITHOUT AN ANSWER, WHERE THE ORIGINAL QUESTIONNAIRE (INSPECTION / CHECKLIST) WAS LOCKED FROM THE ADMINISTRATION.");

		Helper helper = new Helper();

		// refresh the page
		driver.navigate().refresh();
		Thread.sleep(5000);
		driver.navigate().refresh();

		System.out.println("Navigate to the Home Screen i.e. Property List Screen.");

		// ADD NEW QUESTIONNIRE FOR CHECKLIST

		System.out.println("***************** ADD NEW QUESTIONNIRE FOR CHECKLIST *****************");
		test.log(LogStatus.INFO, "***************** ADD NEW QUESTIONNIRE FOR CHECKLIST *****************");
		Reporter.log("***************** ADD NEW QUESTIONNIRE FOR CHECKLIST *****************");
		log.info("***************** ADD NEW QUESTIONNIRE FOR CHECKLIST *****************");

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

			// ADD NEW QUESTIONNIRE FOR CHECKLIST

			// click on the new questionnaire
			click("questionnaire_newquestionnairebtn_CSS");
			System.out.println("Click on the New Questionnire button");
			ngDriver.waitForAngularRequestsToFinish();
			System.out.println("Navigate to the add questionnire details screen.");

			// Select the Inspection / Checklist of the questionnaire
			click("questionnaire_type_inspectionbtn_CSS");
			System.out.println("The type of the questionnire is selected.");

			// Select the level of the questionnaire
			click("questionnaire_level_propertybtn_CSS");
			System.out.println("The level of the questionnire is selected.");

			// enter the group title
			type("questionnaire_grouptitletxt_CSS", data.get("group_title"));
			System.out.println("The data entered in the Group Title field.");

			// enter the questionnaire title
			type("questionnaire_languagetitle_CSS", data.get("questionnaire_checklist_title"));
			System.out.println("Entered the questionnaire title in the english language.");
			ngDriver.waitForAngularRequestsToFinish();

			// select the model
			select("questionnaire_modeldd_CSS", data.get("model"));
			System.out.println("The data entered in the Questionnaire Title field.");
			ngDriver.waitForAngularRequestsToFinish();

			// select the frequency
			select("questionnaire_frequencydd_CSS", data.get("frequency"));
			System.out.println("The data entered in the frequency field.");
			ngDriver.waitForAngularRequestsToFinish();

			// enter frequency interval
			type("questionnaire_frequencyintervaltxt_CSS", "1");
			ngDriver.waitForAngularRequestsToFinish();
			System.out.println("Entered frequency interval.");

			// enter the year
			type("questionnaire_yeartxt_CSS", "2020");
			System.out.println("The data entered in the year field.");
			ngDriver.waitForAngularRequestsToFinish();

			// select the month
			select("questionnaire_monthtxt_CSS", data.get("month"));
			System.out.println("The data entered in the month field.");
			ngDriver.waitForAngularRequestsToFinish();

			// enter the description
			type("questionnaire_descriptiontxt_CSS", data.get("description"));
			System.out.println("The data entered in the description field.");

			// select the classic option from the default view drop down
			select("questionnaire_checklist_defaultview_CSS", data.get("default_view"));
			System.out.println("Selected the classic option from the default view drop down.");
			ngDriver.waitForAngularRequestsToFinish();

			// scroll down the screen
			JavascriptExecutor js = (JavascriptExecutor) driver;
			js.executeScript("window.scrollBy(0,500)");

			// scroll down to the save button
			js.executeScript("window.scrollBy(0,document.body.scrollHeight)", "");

			// click on the save button
			click("questionnaire_savebtn_BTNTEXT");
			System.out.println("Clicked on the save button");
			ngDriver.waitForAngularRequestsToFinish();
			System.out.println("Navigate to the list of questionnaire screen.");

			// enter newly created questionnaire in the filter field
			clear("ssc_company2_questionnairelist_filtertxt_CSS");
			ngDriver.waitForAngularRequestsToFinish();
			type("ssc_company2_questionnairelist_filtertxt_CSS", data.get("questionnaire_checklist_title"));
			System.out.println("Entered newly created questionnaire in the filter field.");
			ngDriver.waitForAngularRequestsToFinish();

			// verify newly created questionnaire for checklist
			switchVerification("questionnaire_createdrecordcopy_10_XPATH", "Test Questionnaire Copy Ten Title",
					"The Test Questionnaire Copy Ten Title record is not displayed in the questionnaire list.");

			// CONFIGRATION OF QUESTION

			// click on the created questionnaire
			click("questionnaire_createdrecordcopy_10_XPATH");
			System.out.println("Clicked on the newly created questionnaire for checklist.");
			ngDriver.waitForAngularRequestsToFinish();

			helper.configureQuestions(data);

			// enter newly created questionnaire in the filter field
			clear("ssc_company2_questionnairelist_filtertxt_CSS");
			ngDriver.waitForAngularRequestsToFinish();
			type("ssc_company2_questionnairelist_filtertxt_CSS", data.get("questionnaire_checklist_title"));
			System.out.println("Entered newly created questionnaire in the filter field.");
			ngDriver.waitForAngularRequestsToFinish();

			// verify newly created questionnaire for checklist
			switchVerification("questionnaire_createdrecordcopy_10_XPATH", "Test Questionnaire Copy Ten Title",
					"The Test Questionnaire Copy Ten Title record is not displayed in the questionnaire list.");

		} catch (Throwable t) {
			verificationFailed();
		}

		// click on the Home Icon from the top of the screen
		click("questionnaire_homeburgermenubtn_CSS");
		System.out.println("Clicked on the Home Icon from the top of the screen.");
		ngDriver.waitForAngularRequestsToFinish();

		// wait for the element
		explicitWait("propertylist_title_XPATH");

		// verify the property list
		switchVerification("propertylist_title_XPATH", "Property List", "The property list is not displayed.");

		// LOCK THE QUESTIONNAIRE AND MAKE A COPY OF THE NEWLY CREATED QUESTIONNAIRE

		System.out.println(
				"******************** LOCK THE QUESTIONNAIRE AND MAKE A COPY OF THE NEWLY CREATED QUESTIONNAIRE ********************");
		test.log(LogStatus.INFO,
				"******************** LOCK THE QUESTIONNAIRE AND MAKE A COPY OF THE NEWLY CREATED QUESTIONNAIRE ********************");
		Reporter.log(
				"******************** LOCK THE QUESTIONNAIRE AND MAKE A COPY OF THE NEWLY CREATED QUESTIONNAIRE ********************");
		log.info(
				"******************** LOCK THE QUESTIONNAIRE AND MAKE A COPY OF THE NEWLY CREATED QUESTIONNAIRE ********************");

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
			type("ssc_company2_questionnairelist_filtertxt_CSS", data.get("questionnaire_checklist_title"));
			System.out.println("Entered newly created questionnaire in the filter field.");
			ngDriver.waitForAngularRequestsToFinish();

			// verify newly created questionnaire for checklist
			switchVerification("questionnaire_createdrecordcopy_10_XPATH", "Test Questionnaire Copy Ten Title",
					"The Test Questionnaire Copy Ten Title record is not displayed in the questionnaire list.");

			// click on the unlock icon
			click("questionnaire_createtask_unlockicon_CSS");
			ngDriver.waitForAngularRequestsToFinish();
			System.out.println("Clicked on the unlock icon.");

			// click on the lock button
			click("questionnaire_createtask_lockbtn_XPATH");
			ngDriver.waitForAngularRequestsToFinish();
			System.out.println("Clicked on the lock button.");

			// wait for the element
			explicitWaitClickable("closetoastmsg_CSS");

			// click on the toaster close button
			click("closetoastmsg_CSS");
			ngDriver.waitForAngularRequestsToFinish();
			System.out.println("Clicked on the toaster close button.");

			// wait for the element
			Thread.sleep(5000);

			try {

				// click on the lock icon
				click("questionnaire_createtask_lockicon_CSS");
				ngDriver.waitForAngularRequestsToFinish();
				System.out.println("questionnaire_createtask_lockicon_CSS");

				// wait for the element
				Thread.sleep(5000);

				boolean unlock = driver
						.findElement(By.xpath(OR.getProperty("questionnaire_createtask_unlockbtn_XPATH")))
						.isDisplayed();

				System.out.println("/////////////////////////////" + unlock);

				if (unlock == true) {
					System.out.println("The questionnaire is locked successfully.");
					test.log(LogStatus.INFO, "The questionnaire is locked successfully.");
					Reporter.log("The questionnaire is locked successfully.");
					log.info("The questionnaire is locked successfully.");
				} else {
					TestUtil.captureScreenshot();

					// ReportNG
					Reporter.log("<br>" + " The questionnaire is not locked. : " + "<br>");
					Reporter.log("<a target=\"_blank\" href=" + TestUtil.screenshotName + "><img src="
							+ TestUtil.screenshotName + " height=200 width=200></img></a>");
					Reporter.log("<br>");
					Reporter.log("<br>");

					// Extent Report
					test.log(LogStatus.FAIL, " The questionnaire is not locked. : ");
					test.log(LogStatus.FAIL, test.addScreenCapture(TestUtil.screenshotName));

					System.out.println("The questionnaire is not locked.");
					log.info("The questionnaire is not locked.");
				}

				// click on the cancel button
				click("questionnaire_createtask_copyquestion_cancelbtn_XPATH");
				ngDriver.waitForAngularRequestsToFinish();
				System.out.println("Clicked on the cancel button.");

			} catch (Throwable t) {
				verificationFailed();

				// click on the cancel button
				click("questionnaire_createtask_copyquestion_cancelbtn_XPATH");
				ngDriver.waitForAngularRequestsToFinish();
				System.out.println("Clicked on the cancel button.");
			}

			// click on the copy icon
			click("questionnaire_createdrecordcopy_copyicon_CSS");
			ngDriver.waitForAngularRequestsToFinish();
			System.out.println("Clicked on the copy icon.");

			// click on the copy button
			click("questionnaire_createdrecordcopy_copybtn_XPATH");
			ngDriver.waitForAngularRequestsToFinish();
			System.out.println("Clicked on the copy button.");

			// wait for the element
			explicitWaitClickable("closetoastmsg_CSS");

			// click on the toaster close button
			click("closetoastmsg_CSS");
			ngDriver.waitForAngularRequestsToFinish();
			System.out.println("Clicked on the toaster close button.");

			// enter newly created questionnaire in the filter field
			clear("ssc_company2_questionnairelist_filtertxt_CSS");
			ngDriver.waitForAngularRequestsToFinish();
			type("ssc_company2_questionnairelist_filtertxt_CSS", data.get("questionnaire_checklist_title"));
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
			type("questionnaire_questionnairetitletxt_CSS", data.get("copied_questionnaire_checklist_title"));
			System.out.println("The data entered in the Questionnaire Title field.");

			// scroll down the screen
			JavascriptExecutor js = (JavascriptExecutor) driver;
			js.executeScript("window.scrollBy(0,1000)");

			// click on the save button
			click("questionnaire_savebtn_BTNTEXT");
			System.out.println("Clicked on the save button");
			ngDriver.waitForAngularRequestsToFinish();
			System.out.println("Navigate to the list of questionnaire screen.");

			// enter newly created questionnaire in the filter field
			clear("ssc_company2_questionnairelist_filtertxt_CSS");
			ngDriver.waitForAngularRequestsToFinish();
			type("ssc_company2_questionnairelist_filtertxt_CSS", data.get("copied_questionnaire_checklist_title"));
			System.out.println("Entered newly created questionnaire in the filter field.");
			ngDriver.waitForAngularRequestsToFinish();

			// verify copied questionnaire is displayed or not
			switchVerification("questionnaire_copiedrecord10_XPATH", "Test Copied Questionnaire Copy Ten Title",
					"The copied questionnaire is not displayed.");

			// wait for 3 seconds
			Thread.sleep(3000);

			// VERIFY COPIED QUESTIONNAIRE IS DISPLAYED LOCKED OR NOT

			System.out.println(
					"***************** VERIFY COPIED QUESTIONNAIRE IS DISPLAYED LOCKED OR NOT *****************");
			test.log(LogStatus.INFO,
					"***************** VERIFY COPIED QUESTIONNAIRE IS DISPLAYED LOCKED OR NOT *****************");
			Reporter.log("***************** VERIFY COPIED QUESTIONNAIRE IS DISPLAYED LOCKED OR NOT *****************");
			log.info("***************** VERIFY COPIED QUESTIONNAIRE IS DISPLAYED LOCKED OR NOT *****************");

			try {

				// click on the lock icon
				click("questionnaire_createtask_lockicon_CSS");
				ngDriver.waitForAngularRequestsToFinish();
				System.out.println("questionnaire_createtask_lockicon_CSS");

				// wait for the element
				Thread.sleep(5000);

				boolean unlock = driver
						.findElement(By.xpath(OR.getProperty("questionnaire_createtask_unlockbtn_XPATH")))
						.isDisplayed();

				System.out.println("/////////////////////////////" + unlock);

				if (unlock == true) {
					System.out.println("The questionnaire is locked successfully.");
					test.log(LogStatus.INFO, "The questionnaire is locked successfully.");
					Reporter.log("The questionnaire is locked successfully.");
					log.info("The questionnaire is locked successfully.");
				} else {
					TestUtil.captureScreenshot();

					// ReportNG
					Reporter.log("<br>" + " The questionnaire is not locked. : " + "<br>");
					Reporter.log("<a target=\"_blank\" href=" + TestUtil.screenshotName + "><img src="
							+ TestUtil.screenshotName + " height=200 width=200></img></a>");
					Reporter.log("<br>");
					Reporter.log("<br>");

					// Extent Report
					test.log(LogStatus.FAIL, " The questionnaire is not locked. : ");
					test.log(LogStatus.FAIL, test.addScreenCapture(TestUtil.screenshotName));

					System.out.println("The questionnaire is not locked.");
					log.info("The questionnaire is not locked.");
				}

				// click on the cancel button
				click("questionnaire_createtask_copyquestion_cancelbtn_XPATH");
				ngDriver.waitForAngularRequestsToFinish();
				System.out.println("Clicked on the cancel button.");

			} catch (Throwable t) {
				verificationFailed();

				// click on the cancel button
				click("questionnaire_createtask_copyquestion_cancelbtn_XPATH");
				ngDriver.waitForAngularRequestsToFinish();
				System.out.println("Clicked on the cancel button.");
			}

		} catch (Throwable t) {
			verificationFailed();
		}

		// DELETE THE COPIED QUESTIONNAIRE

		System.out.println("******************** DELETE THE COPIED QUESTIONNAIRE ********************");
		test.log(LogStatus.INFO, "******************** DELETE THE COPIED QUESTIONNAIRE ********************");
		Reporter.log("******************** DELETE THE COPIED QUESTIONNAIRE ********************");
		log.info("******************** DELETE THE COPIED QUESTIONNAIRE ********************");

		try {

			// click on the copied questionnaire on the property level
			click("questionnaire_copiedrecord10_XPATH");
			System.out.println("Clicked on the copied questionnaire on the property level.");
			ngDriver.waitForAngularRequestsToFinish();

			// scroll till the delete button
			WebElement element6 = driver.findElement(By.cssSelector(OR.getProperty("questionnaire_deletebtn_CSS")));
			JavascriptExecutor js = (JavascriptExecutor) driver;
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
			ngDriver.waitForAngularRequestsToFinish();
			type("ssc_company2_questionnairelist_filtertxt_CSS", data.get("copied_questionnaire_checklist_title"));
			System.out.println("Entered newly created questionnaire in the filter field.");
			ngDriver.waitForAngularRequestsToFinish();

			// verified deleted questionnaire is displayed or not
			helper.deleteVerification("questionnaire_copiedrecord10_XPATH", "Test Copied Questionnaire Copy Ten Title");

		} catch (Throwable t) {

			verificationFailed();
		}

		// UNLOCK THE QUESTIONNAIRE AND MAKE A COPY OF THE NEWLY CREATED QUESTIONNAIRE

		System.out.println(
				"******************** UNLOCK THE QUESTIONNAIRE AND MAKE A COPY OF THE NEWLY CREATED QUESTIONNAIRE ********************");
		test.log(LogStatus.INFO,
				"******************** UNLOCK THE QUESTIONNAIRE AND MAKE A COPY OF THE NEWLY CREATED QUESTIONNAIRE ********************");
		Reporter.log(
				"******************** UNLOCK THE QUESTIONNAIRE AND MAKE A COPY OF THE NEWLY CREATED QUESTIONNAIRE ********************");
		log.info(
				"******************** UNLOCK THE QUESTIONNAIRE AND MAKE A COPY OF THE NEWLY CREATED QUESTIONNAIRE ********************");

		try {

			// enter newly created questionnaire in the filter field
			clear("ssc_company2_questionnairelist_filtertxt_CSS");
			type("ssc_company2_questionnairelist_filtertxt_CSS", data.get("questionnaire_checklist_title"));
			System.out.println("Entered newly created questionnaire in the filter field.");
			ngDriver.waitForAngularRequestsToFinish();

			// click on the lock icon
			click("questionnaire_createtask_lockicon_CSS");
			ngDriver.waitForAngularRequestsToFinish();
			System.out.println("Clicked on the lock icon.");

			// click on the unlock button
			click("questionnaire_createtask_unlockbtn_XPATH");
			ngDriver.waitForAngularRequestsToFinish();
			System.out.println("Clicked on the unlock button.");

			// wait for the element
			explicitWaitClickable("closetoastmsg_CSS");

			// click on the toaster close button
			click("closetoastmsg_CSS");
			ngDriver.waitForAngularRequestsToFinish();
			System.out.println("Clicked on the toaster close button.");

			// wait for the element
			Thread.sleep(5000);

			try {

				// click on the unlock icon
				click("questionnaire_createtask_unlockicon_CSS");
				ngDriver.waitForAngularRequestsToFinish();
				System.out.println("Clicked on the unlock icon");

				// wait for the element
				Thread.sleep(5000);

				boolean lock = driver.findElement(By.xpath(OR.getProperty("questionnaire_createtask_lockbtn_XPATH")))
						.isDisplayed();

				System.out.println("/////////////////////////////" + lock);

				if (lock == true) {
					System.out.println("The questionnaire is locked successfully.");
					test.log(LogStatus.INFO, "The questionnaire is locked successfully.");
					Reporter.log("The questionnaire is locked successfully.");
					log.info("The questionnaire is locked successfully.");
				} else {
					TestUtil.captureScreenshot();

					// ReportNG
					Reporter.log("<br>" + " The questionnaire is not locked. : " + "<br>");
					Reporter.log("<a target=\"_blank\" href=" + TestUtil.screenshotName + "><img src="
							+ TestUtil.screenshotName + " height=200 width=200></img></a>");
					Reporter.log("<br>");
					Reporter.log("<br>");

					// Extent Report
					test.log(LogStatus.FAIL, " The questionnaire is not locked. : ");
					test.log(LogStatus.FAIL, test.addScreenCapture(TestUtil.screenshotName));

					System.out.println("The questionnaire is not locked.");
					log.info("The questionnaire is not locked.");
				}

				// click on the cancel button
				click("questionnaire_createtask_copyquestion_cancelbtn_XPATH");
				ngDriver.waitForAngularRequestsToFinish();
				System.out.println("Clicked on the cancel button.");

			} catch (Throwable t) {
				verificationFailed();
			}

			// click on the copy icon
			click("questionnaire_createdrecordcopy_copyicon_CSS");
			ngDriver.waitForAngularRequestsToFinish();
			System.out.println("Clicked on the copy icon.");

			// click on the copy button
			click("questionnaire_createdrecordcopy_copybtn_XPATH");
			ngDriver.waitForAngularRequestsToFinish();
			System.out.println("Clicked on the copy button.");

			// wait for the element
			explicitWaitClickable("closetoastmsg_CSS");

			// click on the toaster close button
			click("closetoastmsg_CSS");
			ngDriver.waitForAngularRequestsToFinish();
			System.out.println("Clicked on the toaster close button.");

			// enter newly created questionnaire in the filter field
			clear("ssc_company2_questionnairelist_filtertxt_CSS");
			ngDriver.waitForAngularRequestsToFinish();
			type("ssc_company2_questionnairelist_filtertxt_CSS", data.get("questionnaire_checklist_title"));
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
			type("questionnaire_questionnairetitletxt_CSS", data.get("copied_questionnaire_checklist_title"));
			System.out.println("The data entered in the Questionnaire Title field.");

			// scroll down the screen
			JavascriptExecutor js = (JavascriptExecutor) driver;
			js.executeScript("window.scrollBy(0,1000)");

			// click on the save button
			click("questionnaire_savebtn_BTNTEXT");
			System.out.println("Clicked on the save button");
			ngDriver.waitForAngularRequestsToFinish();
			System.out.println("Navigate to the list of questionnaire screen.");

			// enter newly created questionnaire in the filter field
			clear("ssc_company2_questionnairelist_filtertxt_CSS");
			ngDriver.waitForAngularRequestsToFinish();
			type("ssc_company2_questionnairelist_filtertxt_CSS", data.get("copied_questionnaire_checklist_title"));
			System.out.println("Entered newly created questionnaire in the filter field.");
			ngDriver.waitForAngularRequestsToFinish();

			// verify copied questionnaire is displayed or not
			switchVerification("questionnaire_copiedrecord10_XPATH", "Test Copied Questionnaire Copy Ten Title",
					"The copied questionnaire is not displayed.");

			// wait for 3 seconds
			Thread.sleep(3000);

			// verify copied questionnaire is displayed locked or not
			try {

				// click on the unlock icon
				click("questionnaire_createtask_unlockicon_CSS");
				ngDriver.waitForAngularRequestsToFinish();
				System.out.println("Clicked on the unlock icon");

				// wait for the element
				Thread.sleep(5000);

				boolean lock = driver.findElement(By.xpath(OR.getProperty("questionnaire_createtask_lockbtn_XPATH")))
						.isDisplayed();

				System.out.println("/////////////////////////////" + lock);

				if (lock == true) {
					System.out.println("The questionnaire is locked successfully.");
					test.log(LogStatus.INFO, "The questionnaire is locked successfully.");
					Reporter.log("The questionnaire is locked successfully.");
					log.info("The questionnaire is locked successfully.");
				} else {
					TestUtil.captureScreenshot();

					// ReportNG
					Reporter.log("<br>" + " The questionnaire is not locked. : " + "<br>");
					Reporter.log("<a target=\"_blank\" href=" + TestUtil.screenshotName + "><img src="
							+ TestUtil.screenshotName + " height=200 width=200></img></a>");
					Reporter.log("<br>");
					Reporter.log("<br>");

					// Extent Report
					test.log(LogStatus.FAIL, " The questionnaire is not locked. : ");
					test.log(LogStatus.FAIL, test.addScreenCapture(TestUtil.screenshotName));

					System.out.println("The questionnaire is not locked.");
					log.info("The questionnaire is not locked.");
				}

				// click on the cancel button
				click("questionnaire_createtask_copyquestion_cancelbtn_XPATH");
				ngDriver.waitForAngularRequestsToFinish();
				System.out.println("Clicked on the cancel button.");

			} catch (Throwable t) {
				verificationFailed();
			}

		} catch (Throwable t) {
			verificationFailed();
		}

		// DELETE THE QUESTIONNAIRES

		System.out.println("******************** DELETE THE QUESTIONNAIRES ********************");
		test.log(LogStatus.INFO, "******************** DELETE THE QUESTIONNAIRES ********************");
		Reporter.log("******************** DELETE THE QUESTIONNAIRES ********************");
		log.info("******************** DELETE THE QUESTIONNAIRES ********************");

		try {

			// click on the copied questionnaire on the property level
			click("questionnaire_copiedrecord10_XPATH");
			System.out.println("Clicked on the copied questionnaire on the property level.");
			ngDriver.waitForAngularRequestsToFinish();

			// scroll till the delete button
			WebElement element6 = driver.findElement(By.cssSelector(OR.getProperty("questionnaire_deletebtn_CSS")));
			JavascriptExecutor js = (JavascriptExecutor) driver;
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
			ngDriver.waitForAngularRequestsToFinish();
			type("ssc_company2_questionnairelist_filtertxt_CSS", data.get("copied_questionnaire_checklist_title"));
			System.out.println("Entered newly created questionnaire in the filter field.");
			ngDriver.waitForAngularRequestsToFinish();

			// verified deleted questionnaire is displayed or not
			helper.deleteVerification("questionnaire_copiedrecord10_XPATH", "Test Copied Questionnaire Copy Ten Title");

			// scroll up the screen
			js.executeScript("window.scrollBy(0,-400)");

			// wait for the search field
			explicitWait("ssc_company2_questionnairelist_filtertxt_CSS");

			// enter newly created questionnaire in the filter field
			clear("ssc_company2_questionnairelist_filtertxt_CSS");
			ngDriver.waitForAngularRequestsToFinish();
			type("ssc_company2_questionnairelist_filtertxt_CSS", data.get("questionnaire_checklist_title"));
			System.out.println("Entered newly created questionnaire in the filter field.");
			ngDriver.waitForAngularRequestsToFinish();

			// verify newly created questionnaire for survey
			switchVerification("questionnaire_createdrecordcopy_10_XPATH", "Test Questionnaire Copy Ten Title",
					"The Test Questionnaire Copy Ten Title record is not displayed in the questionnaire list.");

			// click on the newly created questionnaire on the property level
			click("questionnaire_createdrecordcopy_10_XPATH");
			System.out.println("Clicked on the newly created questionnaire on the property level.");
			ngDriver.waitForAngularRequestsToFinish();

			// scroll till the delete button
			WebElement element = driver.findElement(By.cssSelector(OR.getProperty("questionnaire_deletebtn_CSS")));
			js.executeScript("arguments[0].scrollIntoView();", element);

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
			ngDriver.waitForAngularRequestsToFinish();
			type("ssc_company2_questionnairelist_filtertxt_CSS", data.get("copied_questionnaire_checklist_title"));
			System.out.println("Entered newly created questionnaire in the filter field.");
			ngDriver.waitForAngularRequestsToFinish();

			// verified deleted questionnaire is displayed or not
			helper.deleteVerification("questionnaire_copiedrecord10_XPATH", "Test Copied Questionnaire Copy Ten Title");

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
