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

		System.out.println("QUESTIONNAIRE EXPORT/IMPORT TO A DIFFERENT SYSTEM COMPANY.");
		test.log(LogStatus.INFO, "QUESTIONNAIRE EXPORT/IMPORT TO A DIFFERENT SYSTEM COMPANY.");
		Reporter.log("QUESTIONNAIRE EXPORT/IMPORT TO A DIFFERENT SYSTEM COMPANY.");
		log.info("QUESTIONNAIRE EXPORT/IMPORT TO A DIFFERENT SYSTEM COMPANY.");

		Helper helper = new Helper();

		// refresh the page
		driver.navigate().refresh();
		Thread.sleep(5000);
		driver.navigate().refresh();

		System.out.println("Navigate to the Home Screen i.e. Property List Screen.");

		// SWITCH THE SYSTEM COMPANY TO [DND]COMPANY 1

		try {
			// wait for the element
			explicitWaitClickable("questionnaire_settingicon_CSS");

			// click on the settings icon from the top of the screen
			click("questionnaire_settingicon_CSS");
			System.out.println("Clicked on the settings icon.");
			ngDriver.waitForAngularRequestsToFinish();

			// wait for the element
			Thread.sleep(5000);

			// click on the Switch System Company option from the side menu
			click("ssc_sidemenubtn_CSS");
			System.out.println("Clicked on the Switch System Company option from the side menu.");
			ngDriver.waitForAngularRequestsToFinish();

			// click on the switch system company dropdown
			click("ssc_systemcompanydd_CSS");
			System.out.println("Clicked on the switch system company.");
			ngDriver.waitForAngularRequestsToFinish();

			// select the company 2 from the system company dropdown
			select("ssc_systemcompanydd_CSS", data.get("system_company_1"));
			System.out.println("The company 1 is selected successfully.");
			ngDriver.waitForAngularRequestsToFinish();

			// click on system company dropdown
			click("ssc_systemcompanydd_CSS");
			System.out.println("Clicked on the system company dropdown.");
			ngDriver.waitForAngularRequestsToFinish();

			// click on the select button
			click("ssc_selectbtn_BTNTEXT");
			System.out.println("Clicked on the select button.");
			ngDriver.waitForAngularRequestsToFinish();

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

			// ADD NEW QUESTIONNIRE

			helper.createSurveyQuestionnaire(data);

			// enter the newly created questionnaire in the search field
			type("ssc_company2_questionnairelist_filtertxt_CSS", data.get("questionnaire_title"));
			System.out.println("Entered the newly created questionnaire in the search field.");
			ngDriver.waitForAngularRequestsToFinish();

			try {
				// verification of the created questionnaire
				verifyTrue("questionnaire_createdrecordauto_importexport_XPATH",
						"The newly questionnaire is not created.");
				System.out.println("The new questionnaire is created successfully.");
				test.log(LogStatus.INFO, "The new questionnaire is created successfully.");

				// CONFIGRATION OF QUESTION

				// click on the created questionnaire
				click("questionnaire_createdrecordauto_importexport_XPATH");
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
				switchVerification("questionnaire_createdrecordauto_importexport_XPATH",
						"Test Import Export Questionnaire",
						"The Test Import Export Questionnaire record is not displayed in the questionnaire list.");

			} catch (Throwable t) {
				verificationFailed();
			}

			// SWITCH THE SYSTEM COMPANY TO THE REFINED DATA TEST

			// wait for the element
			explicitWaitClickable("questionnaire_settingicon_CSS");

			// click on the settings icon from the top of the screen
			click("questionnaire_settingicon_CSS");
			System.out.println("Clicked on the settings icon.");
			ngDriver.waitForAngularRequestsToFinish();

			// wait for the element
			Thread.sleep(5000);

			// click on the Switch System Company option from the side menu
			click("ssc_sidemenubtn_CSS");
			System.out.println("Clicked on the Switch System Company option from the side menu.");
			ngDriver.waitForAngularRequestsToFinish();

			// click on the switch system company dropdown
			click("ssc_systemcompanydd_CSS");
			System.out.println("Clicked on the switch system company.");
			ngDriver.waitForAngularRequestsToFinish();

			// select the company 1 from the system company dropdown
			select("ssc_systemcompanydd_CSS", data.get("system_company"));
			System.out.println("The Refined Data Test is selected successfully.");
			ngDriver.waitForAngularRequestsToFinish();

			// click on system company dropdown
			click("ssc_systemcompanydd_CSS");
			System.out.println("Clicked on the system company dropdown.");
			ngDriver.waitForAngularRequestsToFinish();

			// click on the select button
			click("ssc_selectbtn_BTNTEXT");
			System.out.println("Clicked on the select button.");
			ngDriver.waitForAngularRequestsToFinish();

		} catch (Throwable t) {
			helper.switchSystemCompany(data);
		}

		// click on the home icon from the top of the screen
		click("questionnaire_homeburgermenubtn_hide_CSS");
		System.out.println("Clicked on the home icon from the top of the screen.");
		ngDriver.waitForAngularRequestsToFinish();

		// wait for the element
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

			// wait for the element
			explicitWait("questionnaire_importbtn_XPATH");

			// ********************* AUTOMAIT CONCEPT **********************

			// click on the import questionnaire button

//			WebElement chooseFile = driver.findElement(By.xpath(OR.getProperty("questionnaire_importbtn_XPATH")));
//			chooseFile.click();
//			Runtime.getRuntime()
//					.exec(System.getProperty("user.dir") + "\\src\\test\\resources\\logs\\QuestionnaireImport.exe");
//
//			System.out.println("Clicked on the import questionnaire button.");

			// **************************************************************

			// wait for the element
			explicitWait("ssc_company2_questionnairelist_filtertxt_CSS");

			// enter the newly imported questionnaire in the search field
			type("ssc_company2_questionnairelist_filtertxt_CSS", data.get("questionnaire_title"));
			System.out.println("Entered the newly created questionnaire in the search field.");
			ngDriver.waitForAngularRequestsToFinish();

			// verify newly imported questionnaire for survey
			switchVerification("questionnaire_createdrecordauto_importexport_XPATH", "Test Import Export Questionnaire",
					"The Test Import Export Questionnaire record is not displayed in the questionnaire list.");

		} catch (Throwable t) {
			verificationFailed();
		}

		// DELETE THE IMPORTED QUESTIONNAIRE

		try {
			// click on the imported questionnaire
			click("questionnaire_createdrecordauto_importexport_XPATH");
			System.out.println("Clicked on the imported questionnaire.");
			ngDriver.waitForAngularRequestsToFinish();

			// scrolldown the screen
			JavascriptExecutor js = (JavascriptExecutor) driver;
			js.executeScript("window.scrollBy(0,300)");

			// click on the delete button
			click("questionnaire_deletebtn_CSS");
			ngDriver.waitForAngularRequestsToFinish();
			System.out.println("Click on the delete button.");

			// click on the delete button of the confirmation popup
			click("questionnaire_modeldeletebtn_CSS");
			ngDriver.waitForAngularRequestsToFinish();
			System.out.println("Clicked on the delete button of the confirmation popup.");

			// enter the newly imported questionnaire in the search field
			clear("ssc_company2_questionnairelist_filtertxt_CSS");
			ngDriver.waitForAngularRequestsToFinish();
			System.out.println("Cleared the search field.");
			type("ssc_company2_questionnairelist_filtertxt_CSS", data.get("questionnaire_title"));
			System.out.println("Entered the newly created questionnaire in the search field.");
			ngDriver.waitForAngularRequestsToFinish();

			// verify the questionnaire deleted or not
			try {
				String str3 = driver
						.findElement(By.xpath(OR.getProperty("questionnaire_createdrecordauto_importexport_XPATH")))
						.getText();
				ngDriver.waitForAngularRequestsToFinish();
				if (str3.equals("Test Import Export Questionnaire")) {

					Assert.assertTrue(
							isElementPresent(
									By.xpath(OR.getProperty("questionnaire_createdrecordauto_importexport_XPATH"))),
							"The Test Import Export Questionnaire is not displayed.");

					TestUtil.captureScreenshot();

					// ReportNG
					Reporter.log("<br>" + "Verification failure : " + "<br>");
					Reporter.log("<a target=\"_blank\" href=" + TestUtil.screenshotName + "><img src="
							+ TestUtil.screenshotName + " height=200 width=200></img></a>");
					Reporter.log("<br>");
					Reporter.log("<br>");

					// Extent Report
					test.log(LogStatus.FAIL, " Verification failed with exception : ");
					test.log(LogStatus.FAIL, test.addScreenCapture(TestUtil.screenshotName));

					System.out.println("The task is not deleted successfully.");
					log.info("The task is not deleted successfully.");

				}
			} catch (Throwable t) {
				System.out.println("The questionnaire is deleted successfully.");
				test.log(LogStatus.INFO, "The questionnaire is deleted successfully.");
				Reporter.log("The questionnaire is deleted successfully.");
				log.info("The questionnaire is deleted successfully.");
			}

		} catch (Throwable t) {
			verificationFailed();
		}

		// click on the home icon from the top of the screen
		click("questionnaire_homeburgermenubtn_CSS");
		System.out.println("Clicked on the home icon from the top of the screen.");
		ngDriver.waitForAngularRequestsToFinish();

		// wait for the element
		explicitWait("propertylist_title_XPATH");

		// verify the property list
		switchVerification("propertylist_title_XPATH", "Property List", "The property list is not displayed.");

		// SWITCH THE SYSTEM COMPANY TO [DND]COMPANY 1

		try {
			// wait for the element
			explicitWaitClickable("questionnaire_settingicon_CSS");

			// click on the settings icon from the top of the screen
			click("questionnaire_settingicon_CSS");
			System.out.println("Clicked on the settings icon.");
			ngDriver.waitForAngularRequestsToFinish();

			// wait for the element
			Thread.sleep(5000);

			// click on the Switch System Company option from the side menu
			click("ssc_sidemenubtn_CSS");
			System.out.println("Clicked on the Switch System Company option from the side menu.");
			ngDriver.waitForAngularRequestsToFinish();

			// click on the switch system company dropdown
			click("ssc_systemcompanydd_CSS");
			System.out.println("Clicked on the switch system company.");
			ngDriver.waitForAngularRequestsToFinish();

			// select the company 2 from the system company dropdown
			select("ssc_systemcompanydd_CSS", data.get("system_company_1"));
			System.out.println("The company 1 is selected successfully.");
			ngDriver.waitForAngularRequestsToFinish();

			// click on system company dropdown
			click("ssc_systemcompanydd_CSS");
			System.out.println("Clicked on the system company dropdown.");
			ngDriver.waitForAngularRequestsToFinish();

			// click on the select button
			click("ssc_selectbtn_BTNTEXT");
			System.out.println("Clicked on the select button.");
			ngDriver.waitForAngularRequestsToFinish();

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

			// enter the newly imported questionnaire in the search field
			type("ssc_company2_questionnairelist_filtertxt_CSS", data.get("questionnaire_title"));
			System.out.println("Entered the newly created questionnaire in the search field.");
			ngDriver.waitForAngularRequestsToFinish();

			// verify newly imported questionnaire for survey
			switchVerification("questionnaire_createdrecordauto_importexport_XPATH", "Test Import Export Questionnaire",
					"The Test Import Export Questionnaire record is not displayed in the questionnaire list.");

			// DELETE THE CREATED QUESTIONNAIRE

			// click on the created questionnaire
			click("questionnaire_createdrecordauto_importexport_XPATH");
			System.out.println("Clicked on the imported questionnaire.");
			ngDriver.waitForAngularRequestsToFinish();

			// scrolldown the screen
			JavascriptExecutor js = (JavascriptExecutor) driver;
			js.executeScript("window.scrollBy(0,300)");

			// click on the delete button
			click("questionnaire_deletebtn_CSS");
			ngDriver.waitForAngularRequestsToFinish();
			System.out.println("Click on the delete button.");

			// click on the delete button of the confirmation popup
			click("questionnaire_modeldeletebtn_CSS");
			ngDriver.waitForAngularRequestsToFinish();
			System.out.println("Clicked on the delete button of the confirmation popup.");

			// enter the newly created questionnaire in the search field
			clear("ssc_company2_questionnairelist_filtertxt_CSS");
			ngDriver.waitForAngularRequestsToFinish();
			System.out.println("Cleared the search field.");
			type("ssc_company2_questionnairelist_filtertxt_CSS", data.get("questionnaire_title"));
			System.out.println("Entered the newly created questionnaire in the search field.");
			ngDriver.waitForAngularRequestsToFinish();

			// verify the questionnaire deleted or not
			try {
				String str3 = driver
						.findElement(By.xpath(OR.getProperty("questionnaire_createdrecordauto_importexport_XPATH")))
						.getText();
				ngDriver.waitForAngularRequestsToFinish();
				if (str3.equals("Test Import Export Questionnaire")) {

					Assert.assertTrue(
							isElementPresent(
									By.xpath(OR.getProperty("questionnaire_createdrecordauto_importexport_XPATH"))),
							"The Test Import Export Questionnaire is not displayed.");

					TestUtil.captureScreenshot();

					// ReportNG
					Reporter.log("<br>" + "Verification failure : " + "<br>");
					Reporter.log("<a target=\"_blank\" href=" + TestUtil.screenshotName + "><img src="
							+ TestUtil.screenshotName + " height=200 width=200></img></a>");
					Reporter.log("<br>");
					Reporter.log("<br>");

					// Extent Report
					test.log(LogStatus.FAIL, " Verification failed with exception : ");
					test.log(LogStatus.FAIL, test.addScreenCapture(TestUtil.screenshotName));

					System.out.println("The task is not deleted successfully.");
					log.info("The task is not deleted successfully.");

				}
			} catch (Throwable t) {
				System.out.println("The questionnaire is deleted successfully.");
				test.log(LogStatus.INFO, "The questionnaire is deleted successfully.");
				Reporter.log("The questionnaire is deleted successfully.");
				log.info("The questionnaire is deleted successfully.");
			}

			// click on the home icon from the top of the screen
			click("questionnaire_homeburgermenubtn_CSS");
			System.out.println("Clicked on the home icon from the top of the screen.");
			ngDriver.waitForAngularRequestsToFinish();

			// wait for the element
			explicitWait("propertylist_title_XPATH");

			// verify the property list
			switchVerification("propertylist_title_XPATH", "Property List", "The property list is not displayed.");

			// SWITCH THE SYSTEM COMPANY TO THE REFINED DATA TEST

			// wait for the element
			explicitWaitClickable("questionnaire_settingicon_CSS");

			// click on the settings icon from the top of the screen
			click("questionnaire_settingicon_CSS");
			System.out.println("Clicked on the settings icon.");
			ngDriver.waitForAngularRequestsToFinish();

			// wait for the element
			Thread.sleep(5000);

			// click on the Switch System Company option from the side menu
			click("ssc_sidemenubtn_CSS");
			System.out.println("Clicked on the Switch System Company option from the side menu.");
			ngDriver.waitForAngularRequestsToFinish();

			// click on the switch system company dropdown
			click("ssc_systemcompanydd_CSS");
			System.out.println("Clicked on the switch system company.");
			ngDriver.waitForAngularRequestsToFinish();

			// select the company 1 from the system company dropdown
			select("ssc_systemcompanydd_CSS", data.get("system_company"));
			System.out.println("The Refined Data Test is selected successfully.");
			ngDriver.waitForAngularRequestsToFinish();

			// click on system company dropdown
			click("ssc_systemcompanydd_CSS");
			System.out.println("Clicked on the system company dropdown.");
			ngDriver.waitForAngularRequestsToFinish();

			// click on the select button
			click("ssc_selectbtn_BTNTEXT");
			System.out.println("Clicked on the select button.");
			ngDriver.waitForAngularRequestsToFinish();

		} catch (Throwable t) {
			helper.switchSystemCompany(data);
		}

		// click on the home icon from the top of the screen
		click("questionnaire_homeburgermenubtn_hide_CSS");
		System.out.println("Clicked on the home icon from the top of the screen.");
		ngDriver.waitForAngularRequestsToFinish();

		// wait for the element
		explicitWait("propertylist_title_XPATH");

		// verify the property list
		switchVerification("propertylist_title_XPATH", "Property List", "The property list is not displayed.");

	}

}
