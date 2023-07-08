package testcases.E2Etestcasesuite.surveychecklistmodule;

import java.io.IOException;
import java.time.LocalDate;
import java.util.Hashtable;

import org.apache.commons.lang3.RandomStringUtils;
import org.openqa.selenium.By;
import org.testng.annotations.Test;

import base.Helper;
import base.TestBase;
import utilities.TestUtil;

public class RR6571SurveyChecklist1Test extends TestBase {

	@Test(dataProviderClass = TestUtil.class, dataProvider = "dp")
	public void rR6571SurveyChecklist1Test(Hashtable<String, String> data) throws IOException, InterruptedException {

		execution(data, "rR6571SurveyChecklist1Test");

		// VALIDATE THE COMPLIANCE SECTION FOR THE SURVEYS AT THE PROPERTY AND BUILDING
		// LEVEL WITH A SINGLE PROPERTY.
		title("VALIDATE THE COMPLIANCE SECTION FOR THE SURVEYS AT THE PROPERTY AND BUILDING LEVEL WITH A SINGLE PROPERTY.");

		Helper helper = new Helper();

		// refresh the page
		driver.navigate().refresh();
		Thread.sleep(5000);
		driver.navigate().refresh();

		// CREATE THE SURVEY IN THE PROPERTY LEVELS
		title("CREATE THE SURVEY IN THE PROPERTY LEVELS");

		String questionnaire_property = RandomStringUtils.randomAlphabetic(8);
		LocalDate today = LocalDate.now();
		String today_string = today.toString();

		try {

			// Wait for the element
			Thread.sleep(5000);

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

			// click on the new questionnaire
			click("questionnaire_newquestionnairebtn_CSS");

			// Select the type of the questionnaire
			click("questionnaire_type_propertybtn_CSS");

			// Select the level of the questionnaire
			click("questionnaire_level_propertybtn_CSS");

			// enter the group title
			type("questionnaire_grouptitletxt_CSS", data.get("group_title"));

			// enter the questionnaire title
			type("questionnaire_languagetitle_CSS", questionnaire_property);

			// select the model
			select("questionnaire_modeldd_CSS", data.get("model"));

			// select the frequency
			select("questionnaire_frequencydd_CSS", data.get("frequency"));

			// enter the year
			String[] today_arr = today_string.split("-");
			type("questionnaire_yeartxt_CSS", today_arr[0]);

			// select the month
			select("questionnaire_monthtxt_CSS", data.get("month"));

			// enter the description
			type("questionnaire_descriptiontxt_CSS", data.get("description"));

			// click on the save button
			click("questionnaire_savebtn_BTNTEXT");

			// enter newly created questionnaire in the filter field
			type("ssc_company2_questionnairelist_filtertxt_CSS", questionnaire_property);

			// verify newly created questionnaire for survey
			try {
				String questionnaire = "//td[contains(text(),'" + questionnaire_property + "')]";
				String str2 = (driver.findElement(By.xpath(questionnaire)).getText()).trim();

				if (str2.equals(questionnaire_property)) {

					successMessage("The questionnaire title is verified successfully.");

				} else {
					verificationFailedMessage("The questionnaire title is not displayed.");
				}
			} catch (Throwable t) {
				verificationFailedMessage("The questionnaire title is not displayed.");
			}

			// CONFIGRATION OF QUESTION
			title("CONFIGRATION OF QUESTION");

			// click on the created questionnaire
			String questionnaire1 = "//td[contains(text(),'" + questionnaire_property + "')]";
			driver.findElement(By.xpath(questionnaire1)).click();
			consoleMessage("Clicked on the created questionnaire.");

			helper.configureQuestions(data);

			// enter newly created questionnaire in the filter field
			type("ssc_company2_questionnairelist_filtertxt_CSS", questionnaire_property);

			// verify newly created questionnaire for survey
			try {
				String questionnaire = "//td[contains(text(),'" + questionnaire_property + "')]";
				String str2 = (driver.findElement(By.xpath(questionnaire)).getText()).trim();

				if (str2.equals(questionnaire_property)) {

					successMessage("The questionnaire title is verified successfully.");

				} else {
					verificationFailedMessage("The questionnaire title is not displayed.");
				}
			} catch (Throwable t) {
				verificationFailedMessage("The questionnaire title is not displayed.");
			}

		} catch (Throwable t) {
			verificationFailed();
		}

		// click on the home icon
		click("questionnaire_homeburgermenubtn_CSS");

		// wait for the element
		explicitWait("propertylist_title_XPATH");

		// verify the property list
		switchVerification("propertylist_title_XPATH", "Property List", "The property list is not displayed.");

		// CREATE THE SURVEY IN THE BUILDING LEVELS
		title("CREATE THE SURVEY IN THE BUILDING LEVELS");

		String questionnaire_building = RandomStringUtils.randomAlphabetic(8);

		try {

			// wait for the element
			Thread.sleep(5000);

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

			// click on the new questionnaire
			click("questionnaire_newquestionnairebtn_CSS");

			// Select the type of the questionnaire
			click("questionnaire_type_propertybtn_CSS");

			// Select the level of the questionnaire
			click("questionnaire_level_buildingbtn_CSS");

			// enter the group title
			type("questionnaire_grouptitletxt_CSS", data.get("group_title"));

			// enter the questionnaire title
			type("questionnaire_languagetitle_CSS", questionnaire_building);

			// select the model
			select("questionnaire_modeldd_CSS", data.get("model"));

			// select the frequency
			select("questionnaire_frequencydd_CSS", data.get("frequency"));

			// enter the year
			String[] today_arr = today_string.split("-");
			type("questionnaire_yeartxt_CSS", today_arr[0]);

			// select the month
			select("questionnaire_monthtxt_CSS", data.get("month"));

			// enter the description
			type("questionnaire_descriptiontxt_CSS", data.get("description"));

			// click on the save button
			click("questionnaire_savebtn_BTNTEXT");

			// enter newly created questionnaire in the filter field
			type("ssc_company2_questionnairelist_filtertxt_CSS", questionnaire_building);

			// verify newly created questionnaire for survey
			try {
				String questionnaire = "//td[contains(text(),'" + questionnaire_building + "')]";
				String str2 = (driver.findElement(By.xpath(questionnaire)).getText()).trim();

				if (str2.equals(questionnaire_building)) {

					successMessage("The questionnaire title is verified successfully.");

				} else {
					verificationFailedMessage("The questionnaire title is not displayed.");
				}
			} catch (Throwable t) {
				verificationFailedMessage("The questionnaire title is not displayed.");
			}

			// CONFIGRATION OF QUESTION
			title("CONFIGRATION OF QUESTION");

			// click on the created questionnaire
			click("questionnaire_building_record1_XPATH");

			helper.configureQuestions(data);

			// wait for the element
			explicitWait("ssc_company2_questionnairelist_filtertxt_CSS");

			// enter newly created questionnaire in the filter field
			type("ssc_company2_questionnairelist_filtertxt_CSS", questionnaire_building);

			// verify newly created questionnaire for survey
			try {
				String questionnaire = "//td[contains(text(),'" + questionnaire_building + "')]";
				String str2 = (driver.findElement(By.xpath(questionnaire)).getText()).trim();

				if (str2.equals(questionnaire_building)) {

					successMessage("The questionnaire title is verified successfully.");

				} else {
					verificationFailedMessage("The questionnaire title is not displayed.");
				}
			} catch (Throwable t) {
				verificationFailedMessage("The questionnaire title is not displayed.");
			}

		} catch (Throwable t) {
			verificationFailed();
		}

		// click on the home menu burger button
		click("questionnaire_homeburgermenubtn_CSS");

		// wait for the element
		explicitWait("propertylist_title_XPATH");

		// verify the property list
		switchVerification("propertylist_title_XPATH", "Property List", "The property list is not displayed.");

		// VALIDATE THE COMPLIANCE CARD BEFORE THE CREATING THE SURVEY ON THE PORTFOLIO
		// DASHBOARD
		title("VALIDATE THE COMPLIANCE CARD BEFORE THE CREATING THE SURVEY ON THE PORTFOLIO DASHBOARD");

		try {

			// wait for the element
			Thread.sleep(5000);

			// click on the side menu
			click("menubtn_CSS");

			// wait for the element
			Thread.sleep(5000);

			// click on the portfolio summary option
			click("sidemenu_portfoliosummary_XPATH");

			// scroll till the compliance card
			scrollTillElement("portfoliodashboard_compliancecard_XPATH");

			// click on the graph of the compliance card
			click("portfoliodashboard_compliancecard_graph_XPATH");

			// wait for the element
			Thread.sleep(3000);

			// select the current year in the year dropdown
			String[] date = today_string.split("-");
			select("portfoliodashboard_compliancecard_filteryeardd_XPATH", date[0]);

			// wait for the element
			Thread.sleep(3000);

			// select the current year in the month dropdown
			select("portfoliodashboard_compliancecard_filtermonthdd_XPATH", date[1]);

			// wait for the element
			Thread.sleep(3000);

			// validate the percentage of property 1
			try {

				String percentage1 = (driver
						.findElement(By
								.xpath(OR.getProperty("portfoliodashboard_compliancecard_percentage_property1_XPATH")))
						.getText()).trim();

				if (percentage1.equals("0") || percentage1.equals("")) {
					successMessage("The percentage of the property 1 is not displayed as expected");
				} else {
					verificationFailedMessage("The percentage of the property 1 is displayed incorrect.");
				}

			} catch (Throwable t) {
				verificationFailedMessage("The percentage of the property 1 is displayed incorrect.");
			}

			// validate the percentage of property 2
			try {

				String percentage2 = (driver
						.findElement(By
								.xpath(OR.getProperty("portfoliodashboard_compliancecard_percentage_property2_XPATH")))
						.getText()).trim();

				if (percentage2.equals("0") || percentage2.equals("")) {
					successMessage("The percentage of the property 2 is not displayed as expected");
				} else {
					verificationFailedMessage("The percentage of the property 2 is displayed incorrect.");
				}

			} catch (Throwable t) {
				verificationFailedMessage("The percentage of the property 2 is displayed incorrect.");
			}

			// validate the percentage of property 3
			try {

				String percentage3 = (driver
						.findElement(By
								.xpath(OR.getProperty("portfoliodashboard_compliancecard_percentage_property3_XPATH")))
						.getText()).trim();

				if (percentage3.equals("0") || percentage3.equals("")) {
					successMessage("The percentage of the property 3 is not displayed as expected");
				} else {
					verificationFailedMessage("The percentage of the property 3 is displayed incorrect.");
				}

			} catch (Throwable t) {
				verificationFailedMessage("The percentage of the property 3 is displayed incorrect.");
			}

			// validate the percentage of property 4
			try {

				String percentage4 = (driver
						.findElement(By
								.xpath(OR.getProperty("portfoliodashboard_compliancecard_percentage_property4_XPATH")))
						.getText()).trim();

				if (percentage4.equals("0") || percentage4.equals("")) {
					successMessage("The percentage of the property 4 is not displayed as expected");
				} else {
					verificationFailedMessage("The percentage of the property 4 is displayed incorrect.");
				}

			} catch (Throwable t) {
				verificationFailedMessage("The percentage of the property 4 is displayed incorrect.");
			}

		} catch (Throwable t) {
			verificationFailed();
		}

		// click on the home menu burger button
		click("questionnaire_homeburgermenubtn_CSS");

		// wait for the element
		explicitWait("propertylist_title_XPATH");

		// verify the property list
		switchVerification("propertylist_title_XPATH", "Property List", "The property list is not displayed.");

		// VALIDATE THE COMPLIANCE CARD BEFORE THE CREATING THE SURVEY ON THE PROPERTY
		// SUMMARY DASHBOARD
		title("VALIDATE THE COMPLIANCE CARD BEFORE THE CREATING THE SURVEY ON THE PROPERTY SUMMARY DASHBOARD");

		try {

			// wait for the element
			Thread.sleep(5000);

			// click on the property
			click("propertysummary_property1_XPATH");

			// scroll till the compliance card
			scrollTillElement("portfoliodashboard_compliancecard_XPATH");

			// wait for the element
			Thread.sleep(3000);

			// click on the operation label
			click("propertydashboard_compliancecard_operationlbl_XPATH");

			// select the all option in the type dropdiwn
			select("propertydashboard_compliancecard_typedd_XPATH", "All");

			// select the current year in the year dropdown
			String[] date = today_string.split("-");
			select("portfoliodashboard_compliancecard_filteryeardd_XPATH", date[0]);

			// wait for the element
			Thread.sleep(3000);

			// select the current year in the month dropdown
			select("portfoliodashboard_compliancecard_filtermonthdd_XPATH", date[1]);

			// wait for the element
			Thread.sleep(3000);

			// validate the percentage of property 1
			switchVerificationFailed("portfoliodashboard_compliancecard_percentage_property1_XPATH", "0",
					"The percentage of property 1 is not displayed correctly.");

		} catch (Throwable t) {
			verificationFailed();
		}

	}
}
