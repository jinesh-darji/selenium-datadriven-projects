package testcases.E2Etestcasesuite.surveychecklistmodule;

import java.io.IOException;
import java.util.Hashtable;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.Reporter;
import org.testng.SkipException;
import org.testng.annotations.Test;

import com.relevantcodes.extentreports.LogStatus;

import base.Helper;
import base.TestBase;
import utilities.TestUtil;

public class RR3956SurveyChecklistTest extends TestBase {

	@Test(dataProviderClass = TestUtil.class, dataProvider = "dp")
	public void rR3956SurveyChecklistTest(Hashtable<String, String> data) throws IOException, InterruptedException {

		execution(data, "rR3956SurveyChecklistTest");

		// CANNOT CREATE CHECKLIST INSTANTS FOR INJURY CAUSES

		System.out.println("CANNOT CREATE CHECKLIST INSTANTS FOR INJURY CAUSES");
		test.log(LogStatus.INFO, "CANNOT CREATE CHECKLIST INSTANTS FOR INJURY CAUSES");
		Reporter.log("CANNOT CREATE CHECKLIST INSTANTS FOR INJURY CAUSES");
		log.info("CANNOT CREATE CHECKLIST INSTANTS FOR INJURY CAUSES");

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

			// enter newly created questionnaire in the filter field
			clear("ssc_company2_questionnairelist_filtertxt_CSS");
			ngDriver.waitForAngularRequestsToFinish();
			type("ssc_company2_questionnairelist_filtertxt_CSS", data.get("questionnaire_title_injurycauses"));
			System.out.println("The Injury Causes questionnaire in the filter field.");
			ngDriver.waitForAngularRequestsToFinish();

			// verify newly created questionnaire for checklist
			switchVerification("checklist_injurycauses_XPATH", "Injury Causes",
					"The Injury Causes record is not displayed in the questionnaire list.");

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

		// VERIFY INJURY CAUSES QUESTIONNAIRE IS DISPLAYED OR NOT

		System.out
				.println("***************** VERIFY INJURY CAUSES QUESTIONNAIRE IS DISPLAYED OR NOT *****************");
		test.log(LogStatus.INFO,
				"***************** VERIFY INJURY CAUSES QUESTIONNAIRE IS DISPLAYED OR NOT *****************");
		Reporter.log("***************** VERIFY INJURY CAUSES QUESTIONNAIRE IS DISPLAYED OR NOT *****************");
		log.info("***************** VERIFY INJURY CAUSES QUESTIONNAIRE IS DISPLAYED OR NOT *****************");

		try {

			// click on the OHS icon from the property list page
			click("ohsicon_CSS");
			System.out.println("Clicked on the OHS icon of the Property.");
			ngDriver.waitForAngularRequestsToFinish();
			System.out.println("Navigate to the OHS screen of the perticular property.");

			// wait for the element
			Thread.sleep(5000);

			// click on the burger menu
			click("menubtn_CSS");
			System.out.println("Clicked on the burger menu button successfully!!!");
			ngDriver.waitForAngularRequestsToFinish();

			// wait for the element
			Thread.sleep(5000);

			// click on the inspection/checklist option from side menu
			click("checklist_sidemenu_XPATH");
			System.out.println("Clicked on the inspection/checklist option from side menu");
			ngDriver.waitForAngularRequestsToFinish();
			System.out.println("Navigate to the inspection/checklist screen");

			try {

				boolean checklistbtn = driver
						.findElement(By.cssSelector(OR.getProperty("checklist_newchecklistbtn_CSS"))).isDisplayed();

				if (checklistbtn == true) {

					// click on the new checklist button
					click("checklist_newchecklistbtn_CSS");
					System.out.println("Clicked on the new checklist button.");
					ngDriver.waitForAngularRequestsToFinish();

					// wait for the element
					explicitWaitClickable("checklist_addchecklist_checklisttypedd_CSS");

					// collect all options of the dropdown
					Select dropdown = new Select(driver
							.findElement(By.cssSelector(OR.getProperty("checklist_addchecklist_checklisttypedd_CSS"))));

					// Get all options
					List<WebElement> dd = dropdown.getOptions();

					// Loop to print one by one
					for (int j = 0; j < dd.size(); j++) {
						String checklist = dd.get(j).getText();
						try {
							if (checklist.equals("Injury Causes")) {
								TestUtil.captureScreenshot();

								// ReportNG
								Reporter.log("<br>" + " The Injury Causes is displayed in the dropdown." + "<br>");
								Reporter.log("<a target=\"_blank\" href=" + TestUtil.screenshotName + "><img src="
										+ TestUtil.screenshotName + " height=200 width=200></img></a>");
								Reporter.log("<br>");
								Reporter.log("<br>");

								// Extent Report
								test.log(LogStatus.FAIL, " The Injury Causes is displayed in the dropdown.");
								test.log(LogStatus.FAIL, test.addScreenCapture(TestUtil.screenshotName));

								System.out.println("The Injury Causes is displayed in the dropdown.");
								log.info("The Injury Causes is displayed in the dropdown.");
							} else {
								test.log(LogStatus.INFO, "The Injury Causes is displayed in the dropdown.");
								Reporter.log("The Injury Causes is displayed in the dropdown.");
								System.out.println("The Injury Causes is displayed in the dropdown.");
								log.info("The Injury Causes is displayed in the dropdown.");

							}
						} catch (Throwable t) {
							test.log(LogStatus.INFO, "The Injury Causes is not displayed in the dropdown as expected.");
							Reporter.log("The Injury Causes is not displayed in the dropdown as expected.");
							System.out.println("The Injury Causes is not displayed in the dropdown as expected.");
							log.info("The Injury Causes is not displayed in the dropdown as expected.");
						}
					}

					// click on the close button of the add checklist popup
					click("checklist_addchecklist_dltbtn_XPATH");
					System.out.println("Clicked on the close button of the add checklist popup.");
					ngDriver.waitForAngularRequestsToFinish();

				} else {

					System.out.println(
							"The New Checklist button is not display, Due to the no checklist available for the OHS module.");
					test.log(LogStatus.INFO,
							"The New Checklist button is not display, Due to the no checklist available for the OHS module.");
					Reporter.log(
							"The New Checklist button is not display, Due to the no checklist available for the OHS module.");
					log.info(
							"The New Checklist button is not display, Due to the no checklist available for the OHS module.");

				}

			} catch (Throwable t) {

				verificationFailed();

			}

		} catch (Throwable t) {
			verificationFailed();
		}

		// click on the home option from the side menu
		click("questionnaire_homeburgermenubtn_hide_CSS");
		System.out.println("Clicked on the home option from the side menu");
		ngDriver.waitForAngularRequestsToFinish();

		// wait for the element
		explicitWait("propertylist_title_XPATH");

		// verify the property list
		switchVerification("propertylist_title_XPATH", "Property List", "The property list is not displayed.");

	}

}
