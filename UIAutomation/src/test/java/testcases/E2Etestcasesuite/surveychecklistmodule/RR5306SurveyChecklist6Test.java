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

		System.out.println(
				"COPY THE QUESTIONNAIRE WITHOUT AN ANSWER, WHERE ANSWERS ARE NOT ADDED WHILE PERFORMING THE INSPECTION / CHECKLIST.");
		test.log(LogStatus.INFO,
				"COPY THE QUESTIONNAIRE WITHOUT AN ANSWER, WHERE ANSWERS ARE NOT ADDED WHILE PERFORMING THE INSPECTION / CHECKLIST.");
		Reporter.log(
				"COPY THE QUESTIONNAIRE WITHOUT AN ANSWER, WHERE ANSWERS ARE NOT ADDED WHILE PERFORMING THE INSPECTION / CHECKLIST.");
		log.info(
				"COPY THE QUESTIONNAIRE WITHOUT AN ANSWER, WHERE ANSWERS ARE NOT ADDED WHILE PERFORMING THE INSPECTION / CHECKLIST.");

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
			js.executeScript("window.scrollBy(0,document.body.scrollHeight)");

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
			switchVerification("questionnaire_createdrecordcopy_6_XPATH", "Test Questionnaire Copy Six Title",
					"The Test Questionnaire Copy Six Title record is not displayed in the questionnaire list.");

			// CONFIGRATION OF QUESTION

			// click on the created questionnaire
			click("questionnaire_createdrecordcopy_6_XPATH");
			System.out.println("Clicked on the newly created questionnaire for checklist.");
			ngDriver.waitForAngularRequestsToFinish();

			helper.configureQuestions(data);

			// enter newly created questionnaire in the filter field
			clear("ssc_company2_questionnairelist_filtertxt_CSS");
			type("ssc_company2_questionnairelist_filtertxt_CSS", data.get("questionnaire_checklist_title"));
			System.out.println("Entered newly created questionnaire in the filter field.");
			ngDriver.waitForAngularRequestsToFinish();

			// verify newly created questionnaire for checklist
			switchVerification("questionnaire_createdrecordcopy_6_XPATH", "Test Questionnaire Copy Six Title",
					"The Test Questionnaire Copy Six Title record is not displayed in the questionnaire list.");

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
			type("ssc_company2_questionnairelist_filtertxt_CSS", data.get("questionnaire_checklist_title"));
			System.out.println("Entered newly created questionnaire in the filter field.");
			ngDriver.waitForAngularRequestsToFinish();

			// verify newly created questionnaire for checklist
			switchVerification("questionnaire_createdrecordcopy_6_XPATH", "Test Questionnaire Copy Six Title",
					"The Test Questionnaire Copy Six Title record is not displayed in the questionnaire list.");

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
			type("ssc_company2_questionnairelist_filtertxt_CSS", data.get("questionnaire_checklist_title"));
			System.out.println("Entered newly created questionnaire in the filter field.");
			ngDriver.waitForAngularRequestsToFinish();

			// verify copied questionnaire is displayed or not
			switchVerification("questionnaire_copiedrecord_XPATH", "2021",
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

		// VERIFY THE CHECKLIST IN THE PROPERTY LEVEL
		System.out.println("******************** VERIFY THE CHECKLIST IN THE PROPERTY LEVEL ********************");
		test.log(LogStatus.INFO,
				"******************** VERIFY THE CHECKLIST IN THE PROPERTY LEVEL ********************");
		Reporter.log("******************** VERIFY THE CHECKLIST IN THE PROPERTY LEVEL ********************");
		log.info("******************** VERIFY THE CHECKLIST IN THE PROPERTY LEVEL ********************");

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

			// click on the checklist/inspection option from side menu
			click("checklist_sidemenu_XPATH");
			System.out.println("Clicked on the checklist/inspection option from side menu");
			ngDriver.waitForAngularRequestsToFinish();
			System.out.println("Navigate to the checklist/inspection screen");

			// click on the new checklist button
			click("checklist_newchecklistbtn_CSS");
			System.out.println("Clicked on the new checklist button.");
			ngDriver.waitForAngularRequestsToFinish();

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

			// click on the close button
			click("questionnaire_checklist_closebtn_CSS");
			ngDriver.waitForAngularRequestsToFinish();
			System.out.println("Clicked on the close button.");

		} catch (Throwable t) {
			verificationFailed();
		}

		// click on the Home Icon from the top of the screen
		click("questionnaire_homeburgermenubtn_hide_CSS");
		System.out.println("Clicked on the Home Icon from the top of the screen.");
		ngDriver.waitForAngularRequestsToFinish();

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
			type("ssc_company2_questionnairelist_filtertxt_CSS", data.get("questionnaire_checklist_title"));
			System.out.println("Entered newly created questionnaire in the filter field.");
			ngDriver.waitForAngularRequestsToFinish();

			// verify copied questionnaire is displayed or not
			switchVerification("questionnaire_copiedrecord_XPATH", "2021",
					"The copied questionnaire is not displayed.");

			// click on the newly created questionnaire on the property level
			click("questionnaire_copiedrecord_XPATH");
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

			// wait for the element
			Thread.sleep(5000);

			// click on the delete button of the confirmation popup
			driver.findElement(By.xpath("//button[@ng-click='deleteQuestionnaire()']")).click();
			System.out.println("Clicked on the delete button of the confirmation popup.");
			ngDriver.waitForAngularRequestsToFinish();

			// wait for the search field
			explicitWait("ssc_company2_questionnairelist_filtertxt_CSS");

			// enter newly created questionnaire in the filter field
			clear("ssc_company2_questionnairelist_filtertxt_CSS");
			ngDriver.waitForAngularRequestsToFinish();
			type("ssc_company2_questionnairelist_filtertxt_CSS", data.get("questionnaire_checklist_title"));
			System.out.println("Entered newly created questionnaire in the filter field.");
			ngDriver.waitForAngularRequestsToFinish();

			// verify newly created questionnaire for survey
			switchVerification("questionnaire_createdrecordcopy_6_XPATH", "Test Questionnaire Copy Six Title",
					"The Test Questionnaire Copy Six Title record is not displayed in the questionnaire list.");

			// click on the newly created questionnaire on the property level
			click("questionnaire_createdrecordcopy_6_XPATH");
			System.out.println("Clicked on the newly created questionnaire on the property level.");
			ngDriver.waitForAngularRequestsToFinish();

			// scroll till the delete button
			WebElement element6 = driver.findElement(By.cssSelector(OR.getProperty("questionnaire_deletebtn_CSS")));
			js.executeScript("arguments[0].scrollIntoView();", element6);

			// click on the delete button
			click("questionnaire_deletebtn_CSS");
			System.out.println("Clicked on the delete button.");
			ngDriver.waitForAngularRequestsToFinish();

			// wait for the element
			Thread.sleep(5000);

			// click on the delete button of the confirmation popup
			click("questionnaire_modeldeletebtn_CSS");
			System.out.println("Clicked on the delete button of the confirmation popup.");
			ngDriver.waitForAngularRequestsToFinish();

			// enter newly created questionnaire in the filter field
			clear("ssc_company2_questionnairelist_filtertxt_CSS");
			ngDriver.waitForAngularRequestsToFinish();
			type("ssc_company2_questionnairelist_filtertxt_CSS", data.get("questionnaire_checklist_title"));
			System.out.println("Entered newly created questionnaire in the filter field.");
			ngDriver.waitForAngularRequestsToFinish();

			// verified deleted questionnaire is displayed or not
			helper.deleteVerification("questionnaire_copiedrecord_XPATH", "2021");

			helper.deleteVerification("questionnaire_createdrecordcopy_6_XPATH", "Test Questionnaire Copy Six Title");

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
