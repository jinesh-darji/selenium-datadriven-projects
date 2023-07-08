package testcases.E2Etestcasesuite.environmentalmodule;

import java.io.IOException;
import java.text.DecimalFormat;
import java.time.LocalDate;
import java.util.Hashtable;
import java.util.List;

import org.apache.commons.lang3.RandomStringUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import base.Helper;
import base.TestBase;
import utilities.TestUtil;

public class RR6552Environmental4Test extends TestBase {

	@Test(dataProviderClass = TestUtil.class, dataProvider = "dp")
	public void rR6552Environmental4Test(Hashtable<String, String> data) throws IOException, InterruptedException {

		execution(data, "rR6552Environmental4Test");

		String[] todayDate = LocalDate.now().toString().split("-");

		// VALIDATE THE �VIEW RISK SCORING� SECURITY SETTING FOR THE ENVIRONMENTAL
		// RECORD
		title("VALIDATE THE �VIEW RISK SCORING� SECURITY SETTING FOR THE ENVIRONMENTAL RECORD.");

		// refresh the page
		driver.navigate().refresh();
		Thread.sleep(5000);
		driver.navigate().refresh();

		Helper helper = new Helper();

		// SET THE VIEW RISK SCORE SECURITY PERMISSION IN ADMINISTRATION
		title("SET THE VIEW RISK SCORE SECURITY PERMISSION IN ADMINISTRATION.");

		try {

			// wait for the element
			explicitWaitClickable("questionnaire_settingicon_CSS");

			// click on the settings icon from the top of the screen
			click("questionnaire_settingicon_CSS");

			// wait for the element
			explicitWaitClickable("questionnaire_administrationoption_XPATH");

			// click on the Administration option from the side menu
			click("questionnaire_administrationoption_XPATH");

			// click on the security tab
			click("questionnaire_securitytab_XPATH");

			// click on the security settings option
			click("questionnaire_securotysettingsoption_XPATH");

			// APPLY THE VIEW RISK SCORE PERMISSION
			helper.addPermissionOneUsersRole(data, "security_settings",
					"customform_securitysetting_viewriskscore_XPATH");

			// LOGOUT FROM THE ADMIN USER AND AGAIN LOGIN WITH THE SAME ADMIN USER
			title("LOGOUT FROM THE ADMIN USER AND AGAIN LOGIN WITH THE SAME ADMIN USER");

			// wait for the element
			explicitWaitClickable("questionnaire_settingicon_CSS");

			// click on the settings icon from the top of the screen
			click("questionnaire_settingicon_CSS");

			// wait for the element
			explicitWaitClickable("sidemenu_logout_CSS");

			// click on the logout option from the side menu
			click("sidemenu_logout_CSS");

			// LOGIN ON ADMIN USER
			title("LOGIN ON ADMIN USER");

			helper.loginAndUpdateSystemCompany(data, "username_1", "password_1", "system_company_1");

		} catch (Throwable t) {
			verificationFailed();
		}

		// click on the home icon
		click("questionnaire_homeburgermenubtn_CSS");

		// wait for the element
		explicitWait("propertylist_title_XPATH");

		// verify the property list
		switchVerification("propertylist_title_XPATH", "Property List", "The property list is not displayed.");

		// DELETE ALL THE PREVIOUSLY ADDED ENVIRONMENTAL RECORDS FROM THE PROPERTY ONE
		title("DELETE ALL THE PREVIOUSLY ADDED ENVIRONMENTAL RECORDS FROM THE PROPERTY ONE");

		try {

			// enter the property name in the search field
			type("ohs_incidentreport_searchtxt_XPATH", data.get("property_1"));

			// wait for the element
			explicitWaitClickable("environmentalicon_CSS");

			// click on the environmental icon from the property list page
			click("environmentalicon_CSS");

			// wait for the element
			Thread.sleep(5000);

			// click on the burger menu
			click("menubtn_CSS");

			// wait for the element
			Thread.sleep(5000);

			// click on the environmental records
			click("envrecords_XPATH");

			// wait for the element
			Thread.sleep(5000);

			// click on the Primary Hazardous Substance
			click("envrecords_primaryhazardoussubstance_XPATH");

			// wait for the element
			Thread.sleep(5000);

			// click on the asbestos materials
			click("envreports_asbestosmaterials_XPATH");

			// delete all the environmental records
			try {
				List<WebElement> list = driver
						.findElements(By.xpath(OR.getProperty("envreports_asbestosmaterials_recordlist_XPATH")));
				int list_count = list.size();

				for (int i = 1; i <= list_count; i++) {

					// click on the first record of the environmental record
					String firstRecird = "//table[@id='environmentalDocumentListTable']//tbody//tr[1]//td[@id='asbestosMaterial']";
					driver.findElement(By.xpath(firstRecird)).click();
					consoleMessage("Clicked on the first record of the environmental record.");

					// wait for the element
					explicitWaitClickable("envreports_asbestosmaterials_deletebtn_CSS");

					// click on the delete button
					click("envreports_asbestosmaterials_deletebtn_CSS");

					// wait for the element
					explicitWaitClickable("envreports_asbestosmaterials_modeldeletebtn_CSS");

					// click on the delete button of the confirmation model
					click("envreports_asbestosmaterials_modeldeletebtn_CSS");

					// wait for the element
					explicitWaitClickable("closetoastmsg_CSS");

					// click on the toaster close button
					click("closetoastmsg_CSS");

				}
			} catch (Throwable t) {
				successMessage("All the environmental records are deleted successfully.");
			}

		} catch (Throwable t) {
			verificationFailed();
		}

		// click on the home icon from the top of the screen
		click("questionnaire_homeburgermenubtn_hide_CSS");

		// wait for the element
		explicitWait("propertylist_title_XPATH");

		// verify the property list
		switchVerification("propertylist_title_XPATH", "Property List", "The property list is not displayed.");

		// CREATE NEW RECORD OF THE ENVIRONMENTAL RECORD WITH THE RISK SCORE
		title("CREATE NEW RECORD OF THE ENVIRONMENTAL RECORD WITH THE RISK SCORE");

		String location_description = RandomStringUtils.randomAlphabetic(8);
		String score_random = RandomStringUtils.randomNumeric(2);
		int score_int = Integer.parseInt(score_random);
		DecimalFormat df = new DecimalFormat("#.00");
		String score = df.format(score_int);

		try {

			// enter the property name in the search field
			type("ohs_incidentreport_searchtxt_XPATH", data.get("property_1"));

			// wait for the element
			explicitWaitClickable("environmentalicon_CSS");

			// click on the environmental icon from the property list page
			click("environmentalicon_CSS");

			// wait for the element
			Thread.sleep(5000);

			// click on the burger menu
			click("menubtn_CSS");

			// wait for the element
			Thread.sleep(5000);

			// click on the environmental records
			click("envrecords_XPATH");

			// wait for the element
			Thread.sleep(5000);

			// click on the Primary Hazardous Substance
			click("envrecords_primaryhazardoussubstance_XPATH");

			// wait for the element
			Thread.sleep(5000);

			// click on the asbestos materials
			click("envreports_asbestosmaterials_XPATH");

			// click on the add button
			click("envreports_asbestosmaterials_addbtn_CSS");

			// select the material
			select("envreports_asbestosmaterials_materialdd_CSS", data.get("material"));

			// enter the detailed description
			type("envreports_asbestosmaterials_detaileddescriptiontxt_CSS", data.get("detailed_description"));

			// enter the detailed location
			type("envreports_asbestosmaterials_detailedlocationtxt_CSS", location_description);

			// scroll down the screen
			scrollByPixel(400);

			// select the estimated risk
			select("envreports_asbestosmaterials_estimatedriskdd_CSS", data.get("estimated_risk"));

			// select the is material asbestos containing
			select("envreports_asbestosmaterials_ismaterialasbestoscontainingdd_CSS",
					data.get("is_material_asbestos_containing"));

			// select the asbestos type
			select("envreports_asbestosmaterials_asbestostypedd_CSS", data.get("asbestos_type"));

			// select the condition
			select("envreports_asbestosmaterials_conditiondd_CSS", data.get("condition"));

			// select the status
			select("envreports_asbestosmaterials_statusdd_CSS", data.get("status"));

			// scroll till bottom of the page
			scrollByPixel(1000);

			// enter the details
			type("envreports_asbestosmaterials_detailstxt_CSS", data.get("details"));

			// scroll up the screen
			scrollTop();

			// click on the risk scoring tab
			click("envreports_asbestosmaterials_riskscoringtab_XPATH");

			// select on the risk category option
			select("envreports_asbestosmaterials_riskcategorydd_XPATH", data.get("score_category"));

			// enter the score in the score field
			type("envreports_asbestosmaterials_scoretxt_XPATH", score);

			// select the option from the status dropdown
			select("envreports_asbestosmaterials_statusdd_XPATH", data.get("risk_status"));

			// enter the text in description field
			type("envreports_asbestosmaterials_descriptiontxt_XPATH", data.get("details"));

			// click on the save button
			click("envreports_asbestosmaterials_savebtn_CSS");

			// wait for the element
			explicitWaitClickable("closetoastmsg_CSS");

			// click on the toaster close button
			click("closetoastmsg_CSS");

			// enter the newly created environmental record in the search field
			type("task_listofchecklist_filterfield_CSS", location_description);

			// verify added details of the Asbestos Materials record is correct or not
			try {
				String envrecord = "//span[text()='" + location_description + "']";
				String envrecord_actual = (driver.findElement(By.xpath(envrecord)).getText()).trim();

				if (envrecord_actual.equals(location_description)) {
					successMessage("The newly created environmental record is displayed successfully.");
				} else {
					verificationFailedMessage("The newly created environmental record is not displayed.");
				}
			} catch (Throwable t) {
				verificationFailedMessage("The newly created environmental record is not displayed.");
			}

		} catch (Throwable t) {
			verificationFailed();
		}

		// click on the home icon from the top of the screen
		click("questionnaire_homeburgermenubtn_hide_CSS");

		// wait for the element
		explicitWait("propertylist_title_XPATH");

		// verify the property list
		switchVerification("propertylist_title_XPATH", "Property List", "The property list is not displayed.");

		// VALIDATE THE RISK CARD IN THE PORTFOLIO DASHBOARD SCREEN FOR ADMIN USER
		title("VALIDATE THE RISK CARD IN THE PORTFOLIO DASHBOARD SCREEN FOR ADMIN USER");

		try {

			// wait for the element
			Thread.sleep(5000);

			// click on the side menu
			click("menubtn_CSS");

			// wait for the element
			Thread.sleep(5000);

			// click on the portfolio dashboard from side menu
			click("sidemenu_portfoliosummary_XPATH");

			// scroll down the screen
			scrollByPixel(400);

			// validate the risk card
			try {
				boolean riskCard = driver
						.findElement(By.xpath(OR.getProperty("customform_portfoliodashboard_riskscoringcard_XPATH")))
						.isDisplayed();

				if (riskCard == true) {
					verificationFailedMessage(
							"The risk card is displayed in the portfolio dashboard without the view permission in the admin user.");
				} else {
					successMessage(
							"The risk card is not displayed in the portfolio dashboard as expected in the admin user.");
				}
			} catch (Throwable t) {
				successMessage(
						"The risk card is not displayed in the portfolio dashboard as expected in the admin user.");
			}

		} catch (Throwable t) {
			verificationFailed();
		}

		// click on the home icon from the top of the screen
		click("questionnaire_homeburgermenubtn_hide_CSS");

		// wait for the element
		explicitWait("propertylist_title_XPATH");

		// verify the property list
		switchVerification("propertylist_title_XPATH", "Property List", "The property list is not displayed.");

		// VALIDATE THE RISK SCORING CARD IN THE PROPERTY SUMMARY DASHBOARD SCREEN FOR
		// ADMIN USER
		title("VALIDATE THE RISK SCORING CARD IN THE PROPERTY SUMMARY DASHBOARD SCREEN FOR ADMIN USER");

		try {

			// wait for the element
			Thread.sleep(5000);

			// click on the property
			click("propertysummary_property1_XPATH");

			// scroll down the screen
			scrollByPixel(400);

			// validate the risk card
			try {
				boolean riskCard = driver
						.findElement(By.xpath(OR.getProperty("customform_portfoliodashboard_riskscoringcard_XPATH")))
						.isDisplayed();

				if (riskCard == true) {
					verificationFailedMessage(
							"The risk card is displayed in the property dashboard without the view permission in the admin user.");
				} else {
					successMessage(
							"The risk card is not displayed in the property dashboard as expected in the admin user.");
				}
			} catch (Throwable t) {
				successMessage(
						"The risk card is not displayed in the property dashboard as expected in the admin user.");
			}

		} catch (Throwable t) {
			verificationFailed();
		}

		// click on the home icon from the top of the screen
		click("questionnaire_homeburgermenubtn_hide_CSS");

		// wait for the element
		explicitWait("propertylist_title_XPATH");

		// verify the property list
		switchVerification("propertylist_title_XPATH", "Property List", "The property list is not displayed.");

		// LOGOUT FROM THE ADMIN USER AND LOGIN IN THE PROPERTY MANAGER USER
		title("LOGOUT FROM THE ADMIN USER AND LOGIN IN THE PROPERTY MANAGER USER");

		try {
			// wait for the element
			explicitWaitClickable("questionnaire_settingicon_CSS");

			// click on the settings icon from the top of the screen
			click("questionnaire_settingicon_CSS");

			// wait for the element
			explicitWaitClickable("sidemenu_logout_CSS");

			// click on the logout option from the side menu
			click("sidemenu_logout_CSS");

			// LOGIN IN JINESH USER
			title("LOGIN IN JINESH USER");

			helper.loginAndUpdateSystemCompany(data, "username", "password", "system_company_1");

			// VALIDATE THE RISK CARD IN THE PORTFOLIO DASHBOARD SCREEN - PROPERTY MANAGER -
			// JINESH
			title("VALIDATE THE RISK CARD IN THE PORTFOLIO DASHBOARD SCREEN - PROPERTY MANAGER - JINESH");

			try {

				// wait for the element
				Thread.sleep(5000);

				// click on the side menu
				click("menubtn_CSS");

				// wait for the element
				Thread.sleep(5000);

				// click on the portfolio dashboard from side menu
				click("sidemenu_portfoliosummary_XPATH");

				// scrolldown till risk scoring card
				scrollTillElement("customform_portfoliodashboard_riskscoringcard_XPATH");

				// click on the graph of the risk card
				click("customform_portfoliodashboard_riskscoringcard_graph_XPATH");

				// select the current year in the year dropdown
				select("customform_portfoliodashboard_riskscoringcard_yeardd_XPATH", todayDate[0]);

				// select the current year in the year dropdown
				select("customform_portfoliodashboard_riskscoringcard_yeardd_XPATH", todayDate[1]);

				// click on the property 1 name
				click("customform_portfoliodashboard_propertyname_XPATH");

				// scroll down to bottom
				scrollBottom();

				// validate the risk score of the environmental records of the property
				try {
					String Score2 = "//td[text()='Asbestos Materials']//following-sibling::td[@class='ng-binding']";
					String riskScore = (driver.findElement(By.xpath(Score2)).getText()).trim();

					if (riskScore.equals(score)) {
						successMessage(
								"The risk score of the environmental records of the property is displayed correctly.");
					} else {
						verificationFailedMessage(
								"The risk score of the environmental records of the property is not displayed correctly.");
					}
				} catch (Throwable t) {
					verificationFailedMessage(
							"The risk score of the environmental records of the property is not displayed correctly.");
				}

			} catch (Throwable t) {
				verificationFailed();
			}

			// click on the home icon from the top of the screen
			click("questionnaire_homeburgermenubtn_hide_CSS");

			// wait for the element
			explicitWait("propertylist_title_XPATH");

			// verify the property list
			switchVerification("propertylist_title_XPATH", "Property List", "The property list is not displayed.");

			// VALIDATE THE RISK SCORING CARD IN THE PROPERTY SUMMARY DASHBOARD SCREEN -
			// PROPERTY MANAGER - JINESH
			title("VALIDATE THE RISK SCORING CARD IN THE PROPERTY SUMMARY DASHBOARD SCREEN - PROPERTY MANAGER - JINESH");

			try {

				// wait for the element
				Thread.sleep(5000);

				// click on the property
				click("propertysummary_property1_XPATH");

				// scrolldown till risk scoring card
				scrollTillElement("customform_portfoliodashboard_riskscoringcard_XPATH");

				// click on the graph of the risk card
				click("customform_portfoliodashboard_riskscoringcard_graph_XPATH");

				// select the current year in the year dropdown
				select("customform_portfoliodashboard_riskscoringcard_yeardd_XPATH", todayDate[0]);

				// select the current year in the month dropdown
				String month = todayDate[1].replaceFirst("^0+(?!$)", "");
				select("customform_portfoliodashboard_riskscoringcard_monthdd_XPATH", month);

				// scroll down to bottom
				scrollBottom();

				// validate the risk score of the environmental records of the property
				try {
					String Score2 = "//td[text()='Asbestos Materials']//following-sibling::td[@class='ng-binding']";
					String riskScore = (driver.findElement(By.xpath(Score2)).getText()).trim();

					if (riskScore.equals(score)) {
						successMessage(
								"The risk score of the environmental records of the property is displayed correctly.");
					} else {
						verificationFailedMessage(
								"The risk score of the environmental records of the property is not displayed correctly.");
					}
				} catch (Throwable t) {
					verificationFailedMessage(
							"The risk score of the environmental records of the property is not displayed correctly.");
				}

			} catch (Throwable t) {
				verificationFailed();
			}

			// click on the home icon from the top of the screen
			click("questionnaire_homeburgermenubtn_hide_CSS");

			// wait for the element
			explicitWait("propertylist_title_XPATH");

			// verify the property list
			switchVerification("propertylist_title_XPATH", "Property List", "The property list is not displayed.");

			// LOGOUT FROM THE PROPERTY MANAGER USER AND LOGIN IN THE CONTRACTOR USER
			title("LOGOUT FROM THE PROPERTY MANAGER USER AND LOGIN IN THE CONTRACTOR USER");

			// wait for the element
			explicitWaitClickable("questionnaire_settingicon_CSS");

			// click on the settings icon from the top of the screen
			click("questionnaire_settingicon_CSS");

			// wait for the element
			explicitWaitClickable("sidemenu_logout_CSS");

			// click on the logout option from the side menu
			click("sidemenu_logout_CSS");

			// LOGIN IN CONTRACTOR USER
			title("LOGIN IN CONTRACTOR USER");

			helper.loginAndUpdateSystemCompany(data, "username_2", "password_2", "system_company_1");

			// VALIDATE THE RISK CARD IN THE PORTFOLIO DASHBOARD SCREEN - CONTRACTOR -
			// JINESH CONTRACTOR
			title("VALIDATE THE RISK CARD IN THE PORTFOLIO DASHBOARD SCREEN - CONTRACTOR - JINESH CONTRACTOR");

			try {

				// wait for the element
				Thread.sleep(5000);

				// click on the side menu
				click("menubtn_CSS");

				// wait for the element
				Thread.sleep(5000);

				// click on the portfolio dashboard from side menu
				click("sidemenu_portfoliosummary_XPATH");

				// scrolldown till risk scoring card
				scrollTillElement("customform_portfoliodashboard_riskscoringcard_XPATH");

				// click on the graph of the risk card
				click("customform_portfoliodashboard_riskscoringcard_graph_XPATH");

				// select the current year in the year dropdown
				select("customform_portfoliodashboard_riskscoringcard_yeardd_XPATH", todayDate[0]);

				// select the current year in the year dropdown
				select("customform_portfoliodashboard_riskscoringcard_yeardd_XPATH", todayDate[1]);

				// click on the property 1 name
				click("customform_portfoliodashboard_propertyname_XPATH");

				// scroll down to bottom
				scrollBottom();

				// validate the risk score of the environmental records of the property
				try {
					String Score2 = "//td[text()='Asbestos Materials']//following-sibling::td[@class='ng-binding']";
					String riskScore = (driver.findElement(By.xpath(Score2)).getText()).trim();
					int riskScore_actual = Integer.parseInt(riskScore);
					int env_score_int = Integer.parseInt(score);

					if (riskScore_actual == env_score_int) {
						successMessage(
								"The risk score of the environmental records of the property is displayed correctly.");
					} else {
						verificationFailedMessage(
								"The risk score of the environmental records of the property is not displayed correctly.");
					}
				} catch (Throwable t) {
					verificationFailedMessage(
							"The risk score of the environmental records of the property is not displayed correctly.");
				}

			} catch (Throwable t) {
				verificationFailed();
			}

			// click on the home icon from the top of the screen
			click("questionnaire_homeburgermenubtn_hide_CSS");

			// wait for the element
			explicitWait("propertylist_title_XPATH");

			// verify the property list
			switchVerification("propertylist_title_XPATH", "Property List", "The property list is not displayed.");

			// VALIDATE THE RISK SCORING CARD IN THE PROPERTY SUMMARY DASHBOARD SCREEN -
			// CONTRACTOR - JINESH CONTRACTOR
			title("VALIDATE THE RISK SCORING CARD IN THE PROPERTY SUMMARY DASHBOARD SCREEN - CONTRACTOR - JINESH CONTRACTOR");

			try {

				// wait for the element
				Thread.sleep(5000);

				// click on the property
				click("propertysummary_property1_XPATH");

				// scrolldown till risk scoring card
				scrollTillElement("customform_portfoliodashboard_riskscoringcard_XPATH");

				// click on the graph of the risk card
				click("customform_portfoliodashboard_riskscoringcard_graph_XPATH");

				// select the current year in the year dropdown
				select("customform_portfoliodashboard_riskscoringcard_yeardd_XPATH", todayDate[0]);

				// select the current year in the month dropdown
				String month = todayDate[1].replaceFirst("^0+(?!$)", "");
				select("customform_portfoliodashboard_riskscoringcard_monthdd_XPATH", month);

				// scroll down to bottom
				scrollBottom();

				// validate the risk score of the environmental records of the property
				try {
					String Score2 = "//td[text()='Asbestos Materials']//following-sibling::td[@class='ng-binding']";
					String riskScore = (driver.findElement(By.xpath(Score2)).getText()).trim();

					if (riskScore.equals(score)) {
						successMessage(
								"The risk score of the environmental records of the property is displayed correctly.");
					} else {
						verificationFailedMessage(
								"The risk score of the environmental records of the property is not displayed correctly.");
					}
				} catch (Throwable t) {
					verificationFailedMessage(
							"The risk score of the environmental records of the property is not displayed correctly.");
				}

			} catch (Throwable t) {
				verificationFailed();
			}

			// click on the home icon from the top of the screen
			click("questionnaire_homeburgermenubtn_hide_CSS");

			// wait for the element
			explicitWait("propertylist_title_XPATH");

			// verify the property list
			switchVerification("propertylist_title_XPATH", "Property List", "The property list is not displayed.");

			// LOGOUT FROM THE CONTRACTOR USER AND LOGIN IN THE HR USER
			title("LOGOUT FROM THE CONTRACTOR USER AND LOGIN IN THE HR USER");

			// wait for the element
			explicitWaitClickable("questionnaire_settingicon_CSS");

			// click on the settings icon from the top of the screen
			click("questionnaire_settingicon_CSS");

			// wait for the element
			explicitWaitClickable("sidemenu_logout_CSS");

			// click on the logout option from the side menu
			click("sidemenu_logout_CSS");

			// LOGIN IN HR USER
			title("LOGIN IN HR USER");

			helper.loginAndUpdateSystemCompany(data, "username_3", "password_3", "system_company_1");

			// VALIDATE THE RISK CARD IN THE PORTFOLIO DASHBOARD SCREEN - HR - JINESH HR
			title("VALIDATE THE RISK CARD IN THE PORTFOLIO DASHBOARD SCREEN - HR - JINESH HR");

			try {

				// wait for the element
				Thread.sleep(5000);

				// click on the side menu
				click("menubtn_CSS");

				// wait for the element
				Thread.sleep(5000);

				// click on the portfolio dashboard from side menu
				click("sidemenu_portfoliosummary_XPATH");

				// scroll down the screen
				scrollByPixel(400);

				// validate the risk card
				try {
					boolean riskCard = driver
							.findElement(
									By.xpath(OR.getProperty("customform_portfoliodashboard_riskscoringcard_XPATH")))
							.isDisplayed();

					if (riskCard == true) {
						verificationFailedMessage(
								"The risk card is displayed in the portfolio dashboard without the view permission in the admin user.");
					} else {
						successMessage(
								"The risk card is not displayed in the portfolio dashboard as expected in the admin user.");
					}
				} catch (Throwable t) {
					successMessage(
							"The risk card is not displayed in the portfolio dashboard as expected in the admin user.");
				}

			} catch (Throwable t) {
				verificationFailed();
			}

			// click on the home icon from the top of the screen
			click("questionnaire_homeburgermenubtn_hide_CSS");

			// wait for the element
			explicitWait("propertylist_title_XPATH");

			// verify the property list
			switchVerification("propertylist_title_XPATH", "Property List", "The property list is not displayed.");

			// VALIDATE THE RISK SCORING CARD IN THE PROPERTY SUMMARY DASHBOARD SCREEN - HR
			// - JINESH HR
			title("VALIDATE THE RISK SCORING CARD IN THE PROPERTY SUMMARY DASHBOARD SCREEN - HR - JINESH HR");

			try {

				// wait for the element
				Thread.sleep(5000);

				// click on the property
				click("propertysummary_property1_XPATH");

				// scroll down the screen
				scrollByPixel(400);

				// validate the risk card
				try {
					boolean riskCard = driver
							.findElement(
									By.xpath(OR.getProperty("customform_portfoliodashboard_riskscoringcard_XPATH")))
							.isDisplayed();

					if (riskCard == true) {
						verificationFailedMessage(
								"The risk card is displayed in the property dashboard without the view permission in the admin user.");
					} else {
						successMessage(
								"The risk card is not displayed in the property dashboard as expected in the admin user.");
					}
				} catch (Throwable t) {
					successMessage(
							"The risk card is not displayed in the property dashboard as expected in the admin user.");
				}

			} catch (Throwable t) {
				verificationFailed();
			}

			// click on the home icon from the top of the screen
			click("questionnaire_homeburgermenubtn_hide_CSS");

			// wait for the element
			explicitWait("propertylist_title_XPATH");

			// verify the property list
			switchVerification("propertylist_title_XPATH", "Property List", "The property list is not displayed.");

			// LOGOUT FROM THE HR USER AND LOGIN IN THE ADMIN USER
			title("LOGOUT FROM THE HR USER AND LOGIN IN THE ADMIN USER");

			// wait for the element
			explicitWaitClickable("questionnaire_settingicon_CSS");

			// click on the settings icon from the top of the screen
			click("questionnaire_settingicon_CSS");

			// wait for the element
			explicitWaitClickable("sidemenu_logout_CSS");

			// click on the logout option from the side menu
			click("sidemenu_logout_CSS");

			// LOGIN ON ADMIN USER
			title("LOGIN ON ADMIN USER");

			helper.loginAndUpdateSystemCompany(data, "username_1", "password_1", "system_company_1");

		} catch (Throwable t) {
			helper.questionnaireNotDisplayLogout(data);
		}

		// RESET THE SYSTEM SETTING PERMISSION FOR VIEW RISK SCORE
		title("RESET THE SYSTEM SETTING PERMISSION FOR VIEW RISK SCORE");

		try {
			// wait for the element
			explicitWaitClickable("questionnaire_settingicon_CSS");

			// click on the settings icon from the top of the screen
			click("questionnaire_settingicon_CSS");

			// wait for the element
			explicitWaitClickable("questionnaire_administrationoption_XPATH");

			// click on the Administration option from the side menu
			click("questionnaire_administrationoption_XPATH");

			// click on the security tab
			click("questionnaire_securitytab_XPATH");

			// click on the security settings option
			click("questionnaire_securotysettingsoption_XPATH");

			// enter security setting name in the search field
			type("propertyproject_le_filtertxt_CSS", data.get("security_settings"));

			// click on the searched result
			click("customform_securitysetting_viewriskscore_XPATH");

			// click on the select role field
			click("propertyproject_securitysettings1_selectroles_CSS");

			// click on the none button
			click("propertyproject_securitysettings1_nonebtn_CSS");

			// click on the select role field
			click("propertyproject_securitysettings1_selectroles_CSS");

			// click on the select user field
			click("propertyproject_securitysettings1_selectusers_CSS");

			// click on the none button
			click("propertyproject_securitysettings1_nonebtn_CSS");

			// enter the name of the user in search field
			type("propertyproject_securitysettings1_searchtxt_CSS", data.get("username_1"));

			// click on the searched result
			click("propertyproject_securitysettings1_adminsearcheduser_XPATH");

			// click on the select user field
			click("propertyproject_securitysettings1_selectusers_CSS");

			// click on the save button
			click("propertyproject_securitysettings1_savebtn_CSS");

			// wait for the element
			explicitWaitClickable("closetoastmsg_CSS");

			// click on the toaster close button
			click("closetoastmsg_CSS");

			// LOGOUT FROM THE ADMIN USER AND AGAIN LOGIN WITH THE SAME ADMIN USER
			title("LOGOUT FROM THE ADMIN USER AND AGAIN LOGIN WITH THE SAME ADMIN USER");

			// wait for the element
			explicitWaitClickable("questionnaire_settingicon_CSS");

			// click on the settings icon from the top of the screen
			click("questionnaire_settingicon_CSS");

			// wait for the element
			explicitWaitClickable("sidemenu_logout_CSS");

			// click on the logout option from the side menu
			click("sidemenu_logout_CSS");

			// LOGIN ON ADMIN USER
			title("LOGIN ON ADMIN USER");

			helper.loginAndUpdateSystemCompany(data, "username_1", "password_1", "system_company_1");

		} catch (Throwable t) {
			verificationFailed();
		}

		// DELETE THE ENVIRONMENTAL RECORD
		title("DELETE THE ENVIRONMENTAL RECORD");

		try {

			// enter the property name in the search field
			type("ohs_incidentreport_searchtxt_XPATH", data.get("property_1"));

			// wait for the element
			explicitWaitClickable("environmentalicon_CSS");

			// click on the environmental icon from the property list page
			click("environmentalicon_CSS");

			// wait for the element
			Thread.sleep(5000);

			// click on the burger menu
			click("menubtn_CSS");

			// wait for the element
			Thread.sleep(5000);

			// click on the environmental records
			click("envrecords_XPATH");

			// wait for the element
			Thread.sleep(5000);

			// click on the Primary Hazardous Substance
			click("envrecords_primaryhazardoussubstance_XPATH");

			// wait for the element
			Thread.sleep(5000);

			// click on the asbestos materials
			click("envreports_asbestosmaterials_XPATH");

			// click on the newly created environmental record
			String envrecord = "//span[text()='" + location_description + "']";
			driver.findElement(By.xpath(envrecord)).click();
			consoleMessage("Clicked on the newly created environmental record.");

			// wait for the element
			explicitWaitClickable("envreports_asbestosmaterials_deletebtn_CSS");

			// click on the delete button
			click("envreports_asbestosmaterials_deletebtn_CSS");

			// wait for the element
			explicitWaitClickable("envreports_asbestosmaterials_modeldeletebtn_CSS");

			// click on the delete button of the confirmation model
			click("envreports_asbestosmaterials_modeldeletebtn_CSS");

			// wait for the element
			explicitWaitClickable("closetoastmsg_CSS");

			// click on the toaster close button
			click("closetoastmsg_CSS");

			// enter the newly created environmental record in the search field
			type("task_listofchecklist_filterfield_CSS", location_description);

			// verify added details of the Asbestos Materials record is deleted or not
			try {
				envrecord = "//span[text()='" + location_description + "']";
				String envrecord_actual = (driver.findElement(By.xpath(envrecord)).getText()).trim();

				if (envrecord_actual.equals(location_description)) {
					verificationFailedMessage("The newly created environmental record is deleted successfully.");

				} else {
					successMessage("The newly created environmental record is not deleted.");
				}
			} catch (Throwable t) {
				successMessage("The newly created environmental record is deleted.");
			}

		} catch (Throwable t) {
			verificationFailed();
		}

		// click on the home icon from the top of the screen
		click("questionnaire_homeburgermenubtn_hide_CSS");

		// wait for the element
		explicitWait("propertylist_title_XPATH");

		// verify the property list
		switchVerification("propertylist_title_XPATH", "Property List", "The property list is not displayed.");

	}
}
