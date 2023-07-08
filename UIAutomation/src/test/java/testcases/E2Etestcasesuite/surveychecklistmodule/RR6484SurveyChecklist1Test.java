package testcases.E2Etestcasesuite.surveychecklistmodule;

import java.io.IOException;
import java.util.Hashtable;
import java.util.List;

import org.apache.commons.lang3.RandomStringUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import base.Helper;
import base.TestBase;
import utilities.TestUtil;

public class RR6484SurveyChecklist1Test extends TestBase {

	@Test(dataProviderClass = TestUtil.class, dataProvider = "dp")
	public void rR6484SurveyChecklist1Test(Hashtable<String, String> data) throws IOException, InterruptedException {

		execution(data, "rR6484SurveyChecklist1Test");

		// VERIFY THE USER WITHOUT MODULE ACCESS CAN ABLE TO SEE SURVEYS IN THE PROPERTY
		// SUMMARY DASHBOARD, PORTFOLIO DASHBOARD, AND SURVEY DASHBOARD.
		title("VERIFY THE USER WITHOUT MODULE ACCESS CAN ABLE TO SEE SURVEYS IN THE PROPERTY SUMMARY DASHBOARD, PORTFOLIO DASHBOARD, AND SURVEY DASHBOARD.");

		Helper helper = new Helper();

		// refresh the page
		driver.navigate().refresh();
		Thread.sleep(5000);
		driver.navigate().refresh();

		// CREATE THE SURVEY IN THE PROPERTY LEVELS
		title("CREATE THE SURVEY IN THE PROPERTY LEVELS");

		String questionnaireTitle = RandomStringUtils.randomAlphabetic(8);

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
			type("questionnaire_languagetitle_CSS", questionnaireTitle);

			// select the model
			select("questionnaire_modeldd_CSS", data.get("module"));

			// select the frequency
			select("questionnaire_frequencydd_CSS", data.get("frequency"));

			// enter the year
			type("questionnaire_yeartxt_CSS", "2020");

			// select the month
			select("questionnaire_monthtxt_CSS", data.get("month"));

			// enter the description
			type("questionnaire_descriptiontxt_CSS", data.get("description"));

			// click on the save button
			click("questionnaire_savebtn_BTNTEXT");

			// enter newly created questionnaire in the filter field
			type("ssc_company2_questionnairelist_filtertxt_CSS", questionnaireTitle);

			// verify newly created questionnaire for checklist
			try {
				String str2 = "//td[contains(text(),'" + questionnaireTitle + "')]";
				String str2_actual = (driver.findElement(By.xpath(str2)).getText()).trim();

				if (str2_actual.equals(questionnaireTitle)) {

					successMessage("The newly created inspection is verified successfully.");

				} else {
					verificationFailedMessage("The newly created inspection is not verified.");
				}

			} catch (Throwable t) {
				verificationFailedMessage("The newly created inspection is not verified.");
			}

			// CONFIGRATION OF QUESTION
			title("CONFIGRATION OF QUESTION");

			// click on the created questionnaire
			String str2 = "//td[contains(text(),'" + questionnaireTitle + "')]";
			driver.findElement(By.xpath(str2)).click();
			consoleMessage("Clicked on the newly created questionnaire for survey.");

			helper.configureQuestions(data);

			// enter newly created questionnaire in the filter field
			type("ssc_company2_questionnairelist_filtertxt_CSS", questionnaireTitle);

			// verify newly created questionnaire for checklist
			try {
				String str22 = "//td[contains(text(),'" + questionnaireTitle + "')]";
				String str22_actual = (driver.findElement(By.xpath(str22)).getText()).trim();

				if (str22_actual.equals(questionnaireTitle)) {

					successMessage("The newly created inspection is verified successfully.");

				} else {
					verificationFailedMessage("The newly created inspection is not verified.");
				}

			} catch (Throwable t) {
				verificationFailedMessage("The newly created inspection is not verified.");
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

		// VERIFY THE SURVEY IN THE PROPERTY LEVEL
		title("VERIFY THE SURVEY IN THE PROPERTY LEVEL");

		try {

			// click on the ohs icon from the property list page
			click("ohsicon_CSS");

			// wait for the element
			explicitWaitClickable("menubtn_CSS");

			// click on the burger menu
			click("menubtn_CSS");

			// wait for the element
			Thread.sleep(5000);

			// click on the survey option from side menu
			click("surveyoption_XPATH");

			// select the respective questionnaire from the dropdown
			select("survey_questionnairedd_CSS", questionnaireTitle);

			// verify questionnaire is selected correctly or not
			switchVerification("questionnaire_questiontitle_XPATH", "Test Category Title One",
					"The Test Category Title One is not displayed.");

		} catch (Throwable t) {

			verificationFailedMessage("The newly created questionnaire is not displayed.");
		}

		// click on the home option from the side menu
		click("questionnaire_homeburgermenubtn_hide_CSS");

		// wait for the element
		explicitWait("propertylist_title_XPATH");

		// verify the property list
		switchVerification("propertylist_title_XPATH", "Property List", "The property list is not displayed.");

		// VALIDATE THE NEWLY CREATED SURVEY ON PROPERTY SUMMARY DASHBOARD - ADMIN USER
		title("VALIDATE THE NEWLY CREATED SURVEY ON PROPERTY SUMMARY DASHBOARD - ADMIN USER");

		try {

			// click on the property name from the property list
			click("propertylist_propertyname_XPATH");

			// scroll down
			scrollTillElement("ohs_propertydashboard_surveycard_XPATH");

			// get the all surveys from survey list
			try {
				List<WebElement> SurveyList = driver
						.findElements(By.xpath(OR.getProperty("ohs_propertydashboard_surveycard_surveylist_XPATH")));
				int surveyCount = SurveyList.size();

				for (int i = 1; i < surveyCount; i++) {
					String surveyRecord = "//h4[text()='Surveys']//following-sibling::div[@class='fixed-height-records-list']//table//tbody//tr["
							+ i + "]//td[@class='ng-binding']";

					String surveyTitle = (driver.findElement(By.xpath(surveyRecord)).getText()).trim();

					if (surveyTitle.equals(questionnaireTitle)) {

						successMessage(
								"The respective survey is displayed to admin user as per the access premission.");
						break;
					}
				}

			} catch (Throwable t) {
				verificationFailedMessage("The respective survey is not displayed to admin user.");
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

		// VALIDATE THE NEWLY CREATED SURVEY ON PORTFOLIO SUMMARY DASHBOARD - ADMIN USER
		title("VALIDATE THE NEWLY CREATED SURVEY ON PORTFOLIO SUMMARY DASHBOARD - ADMIN USER");

		try {

			// wait for the element
			Thread.sleep(5000);

			// click on the side menu
			click("menubtn_CSS");

			// wait for the element
			Thread.sleep(5000);

			// click on the portfolio dashboard from side menu
			click("sidemenu_portfoliosummary_XPATH");

			// scroll down
			scrollTillElement("ohs_propertydashboard_surveycard_XPATH");

			// get the all surveys from survey list
			try {
				List<WebElement> SurveyList = driver
						.findElements(By.xpath(OR.getProperty("ohs_portfoliodashboard_surveycard_surveylist_XPATH")));
				int surveyCount = SurveyList.size();

				for (int i = 1; i < surveyCount; i++) {

					String surveyRecord = "//h4[text()='Surveys']//following-sibling::div[@class='fixed-height-records-list pointer']//table//tbody//tr["
							+ i + "]//td[@class='ng-binding']";

					String surveyTitle = (driver.findElement(By.xpath(surveyRecord)).getText()).trim();

					if (surveyTitle.equals(questionnaireTitle)) {
						successMessage(
								"The respective survey is displayed to admin user as per the access premission.");
						break;
					}
				}

			} catch (Throwable t) {
				verificationFailedMessage("The respective survey is not displayed to admin user.");
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

		// VALIDATE THE NEWLY CREATED SURVEY ON SURVEY DASHBOARD - ADMIN USER
		title("VALIDATE THE NEWLY CREATED SURVEY ON SURVEY DASHBOARD - ADMIN USER");

		try {

			// wait for the element
			Thread.sleep(5000);

			// click on the side menu
			click("menubtn_CSS");

			// wait for the element
			Thread.sleep(5000);

			// click on the survey dashboard from side menu
			click("sidemenu_survey_XPATH");

			// enter the questionnaire title in the search field
			type("surveydashboard_searchtxt_XPATH", questionnaireTitle);

			// get the all surveys from survey list
			try {

				String surveyTitle = "//td[text()='" + questionnaireTitle + "']";
				String surveyTitle_actual = (driver.findElement(By.xpath(surveyTitle)).getText()).trim();

				if (surveyTitle_actual.equals(questionnaireTitle)) {
					successMessage("The respective survey is displayed to admin user as per the access premission.");
				}

			} catch (Throwable t) {
				verificationFailedMessage("The respective survey is not displayed to admin user.");
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

		// LOGIN WITH CONSULTANT USER AND VERIFY THE NEWLY CREATED SURVEY IN PROPERTY
		// SUMMARY DASHBOARD, PORTFOLIO SUMMARY DASHBOARD, AND SURVEY DASHBOARD
		title("LOGIN WITH CONSULTANT USER AND VERIFY THE NEWLY CREATED SURVEY IN PROPERTY SUMMARY DASHBOARD, PORTFOLIO SUMMARY DASHBOARD, AND SURVEY DASHBOARD");

		try {
			// wait for the element
			Thread.sleep(5000);

			// click on the settings icon from the top of the screen
			click("questionnaire_settingicon_userupdate_CSS");

			// wait for the element
			explicitWaitClickable("sidemenu_logout_CSS");

			// click on the logout option from the side menu
			click("sidemenu_logout_CSS");

			// login with valid credentials
			helper.loginAndUpdateSystemCompany(data, "username", "password", "system_company_1");

			// VALIDATE THE NEWLY CREATED SURVEY ON PROPERTY SUMMARY DASHBOARD - CONSULTANT
			// USER
			title("VALIDATE THE NEWLY CREATED SURVEY ON PROPERTY SUMMARY DASHBOARD - CONSULTANT USER");

			try {

				// click on the property name from the property list
				click("propertylist_propertyname_XPATH");

				// scroll down
				scrollTillElement("ohs_propertydashboard_surveycard_XPATH");

				// get the all surveys from survey list
				try {
					List<WebElement> SurveyList = driver.findElements(
							By.xpath(OR.getProperty("ohs_propertydashboard_surveycard_surveylist_XPATH")));
					int surveyCount = SurveyList.size();

					for (int i = 1; i < surveyCount; i++) {
						String surveyRecord = "//h4[text()='Surveys']//following-sibling::div[@class='fixed-height-records-list']//table//tbody//tr["
								+ i + "]//td[@class='ng-binding']";

						String surveyTitle = (driver.findElement(By.xpath(surveyRecord)).getText()).trim();

						if (surveyTitle.equals(questionnaireTitle)) {
							verificationFailedMessage(
									"The respective survey is displayed to cunsultant user without access premission.");
							break;
						}
					}
				} catch (Throwable t) {
					successMessage("The respective survey is not displayed to consultant user.");
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

			// VALIDATE THE NEWLY CREATED SURVEY ON PORTFOLIO SUMMARY DASHBOARD - CONSULTANT
			// USER
			title("VALIDATE THE NEWLY CREATED SURVEY ON PORTFOLIO SUMMARY DASHBOARD - CONSULTANT USER");

			try {

				// wait for the element
				Thread.sleep(5000);

				// click on the side menu
				click("menubtn_CSS");

				// wait for the element
				Thread.sleep(5000);

				// click on the portfolio dashboard from side menu
				click("sidemenu_portfoliosummary_XPATH");

				// scroll down
				scrollTillElement("ohs_propertydashboard_surveycard_XPATH");

				// get the all surveys from survey list
				try {
					List<WebElement> SurveyList = driver.findElements(
							By.xpath(OR.getProperty("ohs_portfoliodashboard_surveycard_surveylist_XPATH")));
					int surveyCount = SurveyList.size();

					for (int i = 1; i < surveyCount; i++) {
						String surveyRecord = "//h4[text()='Surveys']//following-sibling::div[@class='fixed-height-records-list pointer']//table//tbody//tr["
								+ i + "]//td[@class='ng-binding']";

						String surveyTitle = (driver.findElement(By.xpath(surveyRecord)).getText()).trim();

						if (surveyTitle.equals(questionnaireTitle)) {
							verificationFailedMessage(
									"The respective survey is displayed to cunsultant user without access premission.");
							break;
						}
					}

				} catch (Throwable t) {
					successMessage("The respective survey is not displayed to cunsultant user.");
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

			// VALIDATE THE NEWLY CREATED SURVEY ON SURVEY DASHBOARD - CONSULTANT USER
			title("VALIDATE THE NEWLY CREATED SURVEY ON SURVEY DASHBOARD - CONSULTANT USER");

			try {

				// wait for the element
				Thread.sleep(5000);

				// click on the side menu
				click("menubtn_CSS");

				// wait for the element
				Thread.sleep(5000);

				// click on the survey dashboard from side menu
				click("sidemenu_survey_XPATH");

				// enter the questionnaire title in the search field
				type("surveydashboard_searchtxt_XPATH", questionnaireTitle);

				// get the all surveys from survey list
				try {

					String surveyTitle = "//td[text()='" + questionnaireTitle + "']";
					String surveyTitle_actual = (driver.findElement(By.xpath(surveyTitle)).getText()).trim();

					if (surveyTitle_actual.equals(questionnaireTitle)) {
						verificationFailedMessage(
								"The respective survey is displayed to cunsultant user without access premission.");
					}

				} catch (Throwable t) {
					successMessage("The respective survey is not displayed to cunsultant user.");
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

			// wait for the element
			Thread.sleep(5000);

			// click on the settings icon from the top of the screen
			click("questionnaire_settingicon_CSS");

			// wait for the element
			explicitWaitClickable("sidemenu_logout_CSS");

			// click on the logout option from the side menu
			click("sidemenu_logout_CSS");

			// login with valid credentials
			helper.loginAndUpdateSystemCompany(data, "username_1", "password_1", "system_company_1");

		} catch (Throwable t) {

			helper.questionnaireNotDisplayLogout(data);
		}

		// LOGIN WITH PROPERTY MANAGER USER AND VERIFY THE NEWLY CREATED SURVEY IN
		// PROPERTY SUMMARY DASHBOARD, PORTFOLIO SUMMARY DASHBOARD, AND SURVEY DASHBOARD
		title("LOGIN WITH PROPERTY MANAGER USER AND VERIFY THE NEWLY CREATED SURVEY IN PROPERTY SUMMARY DASHBOARD, PORTFOLIO SUMMARY DASHBOARD, AND SURVEY DASHBOARD");

		try {
			// wait for the element
			Thread.sleep(5000);

			// click on the settings icon from the top of the screen
			click("questionnaire_settingicon_userupdate_CSS");

			// wait for the element
			explicitWaitClickable("sidemenu_logout_CSS");

			// click on the logout option from the side menu
			click("sidemenu_logout_CSS");

			// login with valid credentials
			helper.loginAndUpdateSystemCompany(data, "username_2", "password", "system_company_1");

			// VALIDATE THE NEWLY CREATED SURVEY ON PROPERTY SUMMARY DASHBOARD - PROPERTY
			// MANAGER USER
			title("VALIDATE THE NEWLY CREATED SURVEY ON PROPERTY SUMMARY DASHBOARD - PROPERTY MANAGER USER");

			try {

				// click on the property name from the property list
				click("propertylist_propertyname_XPATH");

				// scroll down
				scrollTillElement("ohs_propertydashboard_surveycard_XPATH");

				// get the all surveys from survey list
				try {
					List<WebElement> SurveyList = driver.findElements(
							By.xpath(OR.getProperty("ohs_propertydashboard_surveycard_surveylist_XPATH")));
					int surveyCount = SurveyList.size();

					for (int i = 1; i < surveyCount; i++) {
						String surveyRecord = "//h4[text()='Surveys']//following-sibling::div[@class='fixed-height-records-list']//table//tbody//tr["
								+ i + "]//td[@class='ng-binding']";

						String surveyTitle = (driver.findElement(By.xpath(surveyRecord)).getText()).trim();

						if (surveyTitle.equals(questionnaireTitle)) {
							successMessage(
									"The respective survey is displayed to property manager user as per the access premission.");
							break;
						}
					}

				} catch (Throwable t) {
					verificationFailedMessage("The respective survey is not displayed to property manager user.");
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

			// VALIDATE THE NEWLY CREATED SURVEY ON PORTFOLIO SUMMARY DASHBOARD - PROPERTY
			// MANAGER USER
			title("VALIDATE THE NEWLY CREATED SURVEY ON PORTFOLIO SUMMARY DASHBOARD - PROPERTY MANAGER USER");

			try {

				// wait for the element
				Thread.sleep(5000);

				// click on the side menu
				click("menubtn_CSS");

				// wait for the element
				Thread.sleep(5000);

				// click on the portfolio dashboard from side menu
				click("sidemenu_portfoliosummary_XPATH");

				// scroll down
				scrollTillElement("ohs_propertydashboard_surveycard_XPATH");

				// get the all surveys from survey list
				try {
					List<WebElement> SurveyList = driver.findElements(
							By.xpath(OR.getProperty("ohs_portfoliodashboard_surveycard_surveylist_XPATH")));
					int surveyCount = SurveyList.size();

					for (int i = 1; i < surveyCount; i++) {
						String surveyRecord = "//h4[text()='Surveys']//following-sibling::div[@class='fixed-height-records-list pointer']//table//tbody//tr["
								+ i + "]//td[@class='ng-binding']";

						String surveyTitle = (driver.findElement(By.xpath(surveyRecord)).getText()).trim();

						if (surveyTitle.equals(questionnaireTitle)) {
							successMessage(
									"The respective survey is displayed to property manager user as per the access premission.");
							break;
						}
					}

				} catch (Throwable t) {
					verificationFailedMessage("The respective survey is not displayed to property manager user.");
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

			// VALIDATE THE NEWLY CREATED SURVEY ON SURVEY DASHBOARD - PROPERTY MANAGER USER
			title("VALIDATE THE NEWLY CREATED SURVEY ON SURVEY DASHBOARD - PROPERTY MANAGER USER");

			try {

				// wait for the element
				Thread.sleep(5000);

				// click on the side menu
				click("menubtn_CSS");

				// wait for the element
				Thread.sleep(5000);

				// click on the survey dashboard from side menu
				click("sidemenu_survey_XPATH");

				// enter the questionnaire title in the search field
				type("surveydashboard_searchtxt_XPATH", questionnaireTitle);

				// get the all surveys from survey list
				try {

					String surveyTitle = "//td[text()='" + questionnaireTitle + "']";
					String surveyTitle_actual = (driver.findElement(By.xpath(surveyTitle)).getText()).trim();

					if (surveyTitle_actual.equals(questionnaireTitle)) {
						successMessage(
								"The respective survey is displayed to property manager user as per the access premission.");
					}

				} catch (Throwable t) {
					verificationFailedMessage("The respective survey is not displayed to property manager user.");
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

			// wait for the element
			Thread.sleep(5000);

			// click on the settings icon from the top of the screen
			click("questionnaire_settingicon_CSS");

			// wait for the element
			explicitWaitClickable("sidemenu_logout_CSS");

			// click on the logout option from the side menu
			click("sidemenu_logout_CSS");

			// login with valid credentials
			helper.loginAndUpdateSystemCompany(data, "username_1", "password_1", "system_company_1");

		} catch (Throwable t) {

			helper.questionnaireNotDisplayLogout(data);
		}

		// DELETE THE ADDED QUESTIONNAIRE
		title("DELETE THE ADDED QUESTIONNAIRE");

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

			// enter newly created questionnaire in the filter field
			type("ssc_company2_questionnairelist_filtertxt_CSS", questionnaireTitle);

			// click on the created questionnaire
			String str2 = "//td[contains(text(),'" + questionnaireTitle + "')]";
			driver.findElement(By.xpath(str2)).click();
			consoleMessage("Clicked on the newly created questionnaire for survey.");

			// scroll till the delete button
			scrollTillElement("questionnaire_deletebtn_CSS");

			// wait for the element
			explicitWaitClickable("questionnaire_deletebtn_CSS");

			// click on the delete button
			click("questionnaire_deletebtn_CSS");

			// wait for the element
			explicitWaitClickable("questionnaire_modeldeletebtn_CSS");

			// click on the delete button of the confirmation popup
			click("questionnaire_modeldeletebtn_CSS");

			// enter newly created questionnaire in the filter field
			type("ssc_company2_questionnairelist_filtertxt_CSS", questionnaireTitle);

			// verify newly created questionnaire for checklist
			try {
				String delete = "//td[contains(text(),'" + questionnaireTitle + "')]";
				String delete_actual = (driver.findElement(By.xpath(delete)).getText()).trim();

				if (delete_actual.equals(questionnaireTitle)) {
					verificationFailedMessage("The newly created inspection is not deleted.");

				} else {
					successMessage("The newly created inspection is deleted successfully.");
				}

			} catch (Throwable t) {
				successMessage("The newly created inspection is deleted successfully.");
			}

		} catch (Throwable t) {

			verificationFailedMessage("The newly created questionnaire is not displayed.");
		}

		// click on the home icon from the top of the screen
		click("questionnaire_homeburgermenubtn_CSS");

		// wait for the element
		explicitWait("propertylist_title_XPATH");

		// verify the property list
		switchVerification("propertylist_title_XPATH", "Property List", "The property list is not displayed.");

	}
}
