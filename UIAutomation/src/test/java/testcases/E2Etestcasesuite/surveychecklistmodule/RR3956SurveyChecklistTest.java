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
		title(" CANNOT CREATE CHECKLIST INSTANTS FOR INJURY CAUSES");

		Helper helper = new Helper();

		// refresh the page
		driver.navigate().refresh();
		Thread.sleep(5000);
		driver.navigate().refresh();

		// ADD NEW QUESTIONNIRE FOR CHECKLIST
		title("ADD NEW QUESTIONNIRE FOR CHECKLIST");

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
			type("ssc_company2_questionnairelist_filtertxt_CSS", data.get("questionnaire_title_injurycauses"));

			// verify newly created questionnaire for checklist
			switchVerification("checklist_injurycauses_XPATH", "Injury Causes",
					"The Injury Causes record is not displayed in the questionnaire list.");

		} catch (Throwable t) {
			verificationFailed();
		}

		// click on the home menu burger button
		click("questionnaire_homeburgermenubtn_CSS");

		// wait for the element
		explicitWait("propertylist_title_XPATH");

		// verify the property list
		switchVerification("propertylist_title_XPATH", "Property List", "The property list is not displayed.");

		// VERIFY INJURY CAUSES QUESTIONNAIRE IS DISPLAYED OR NOT
		title("VERIFY INJURY CAUSES QUESTIONNAIRE IS DISPLAYED OR NOT");

		try {

			// click on the OHS icon from the property list page
			click("ohsicon_CSS");

			// wait for the element
			Thread.sleep(5000);

			// click on the burger menu
			click("menubtn_CSS");

			// wait for the element
			Thread.sleep(5000);

			// click on the inspection/checklist option from side menu
			click("checklist_sidemenu_XPATH");

			try {

				boolean checklistbtn = driver
						.findElement(By.cssSelector(OR.getProperty("checklist_newchecklistbtn_CSS"))).isDisplayed();

				if (checklistbtn == true) {

					// click on the new checklist button
					click("checklist_newchecklistbtn_CSS");

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
								verificationFailedMessage("The Injury Causes is displayed in the dropdown.");
							} else {
								successMessage("The Injury Causes is displayed in the dropdown.");
							}
						} catch (Throwable t) {
							successMessage("The Injury Causes is not displayed in the dropdown as expected.");
						}
					}

					// click on the close button of the add checklist popup
					click("checklist_addchecklist_dltbtn_XPATH");

				} else {
					successMessage(
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

		// wait for the element
		explicitWait("propertylist_title_XPATH");

		// verify the property list
		switchVerification("propertylist_title_XPATH", "Property List", "The property list is not displayed.");
	}
}
