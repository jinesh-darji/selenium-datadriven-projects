package testcases.E2Etestcasesuite.customformmodule;

import java.io.IOException;
import java.time.LocalDate;
import java.util.Hashtable;

import org.apache.commons.lang3.RandomStringUtils;
import org.openqa.selenium.By;
import org.testng.annotations.Test;

import base.Helper;
import base.TestBase;
import utilities.TestUtil;

public class RR6555CustomForm10Test extends TestBase {

	@Test(dataProviderClass = TestUtil.class, dataProvider = "dp")
	public void rR6555CustomForm10Test(Hashtable<String, String> data) throws IOException, InterruptedException {

		execution(data, "rR6555CustomForm10Test");

		// VALIDATE THE �VIEW RISK SCORING� SECURITY SETTING FOR THE SINGLE TYPE
		// CUSTOM FORM.
		title("VALIDATE THE �VIEW RISK SCORING� SECURITY SETTING FOR THE SINGLE TYPE CUSTOM FORM.");

		// refresh the page
		driver.navigate().refresh();
		Thread.sleep(5000);
		driver.navigate().refresh();

		Helper helper = new Helper();

		String name = RandomStringUtils.randomAlphabetic(8); // Custom Form Name
		String fieldName1 = RandomStringUtils.randomAlphabetic(8); // Normal Field 1
		String fieldName2 = RandomStringUtils.randomAlphabetic(8); // Normal Field 2
		String fieldDetail1 = RandomStringUtils.randomAlphabetic(8); // Field Detail 1
		String fieldDetail2 = RandomStringUtils.randomNumeric(3); // Field Detail 2
		String pageName1 = RandomStringUtils.randomAlphabetic(8); // Page Name 1
		String pageFieldName1 = RandomStringUtils.randomAlphabetic(8); // Page Name 1 - Field 1
		String pageFieldName2 = RandomStringUtils.randomAlphabetic(8); // Page Name 1 - Field 2
		String pageFieldDetail1 = RandomStringUtils.randomAlphabetic(8); // Page Name 1 - Field Detail 1
		String pageFieldDetail2 = RandomStringUtils.randomNumeric(3); // Page Name 1 - Field Detail 2
		String score = RandomStringUtils.randomNumeric(2);
		String[] todayDate = LocalDate.now().toString().split("-");

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

		// CREATE NEW CUSTOM FORMS FOR SINGLE RECORD TYPE
		title("CREATE NEW CUSTOM FORMS FOR SINGLE RECORD TYPE");

		try {

			// Wait for the element
			Thread.sleep(5000);

			// click on the settings icon from the top of the screen
			click("questionnaire_settingicon_CSS");

			// wait for the element
			explicitWaitClickable("questionnaire_administrationoption_XPATH");

			// click on the Administration option from the side menu
			click("questionnaire_administrationoption_XPATH");

			// click on the system tab
			click("questionnaire_systemtab_XPATH");

			// click on the custom form option
			click("customform_option_XPATH");

			// click on the add button
			click("customform_addbtn_XPATH");

			// enter name of the form in the name field
			type("customform_nametxt_XPATH", name);

			// select the single report type from the drop down
			select("customform_recordtypedd_XPATH", data.get("type_1"));

			// click on the date sensitive checkbox
			click("customform_datesensitiveckbx_XPATH");

			// click on the Is Verification Workflow Enabled? checkbox
			click("customform_verificationckbx_XPATH");

			// click on the risk score checkbox
			click("customform_riskscoreckbx_XPATH");

			// click on the save button
			click("customform_savebtn_XPATH");

			// wait for the element
			Thread.sleep(5000);

			// validate the Report Name details of the newly created report
			try {
				String Validation0 = "//td[text()='" + name + "']";
				String Validation0_actual = (driver.findElement(By.xpath(Validation0)).getText()).trim();

				if (Validation0_actual.equals(name)) {

					successMessage("The Report Name detail is displayed correctly.");

				} else {
					verificationFailedMessage("The Report Name detail is displayed correctly.");
				}

			} catch (Throwable t) {
				verificationFailedMessage("The Report Name detail is displayed correctly.");
			}

			// click on the newly created custom record record
			String nameTitle = "//td[text()='" + name + "']";
			driver.findElement(By.xpath(nameTitle)).click();
			consoleMessage("Clicked on the newly created custom record record.");

			// click on the add field button
			click("customform_addfieldbtn_XPATH");

			// enter field name
			type("customform_addfield_nametxt_XPATH", fieldName1);

			// select the option from the type dropdown
			select("customform_addfield_typedd_XPATH", data.get("fieldtype_1"));

			// click on the display on list checkbox
			click("customform_addfield_displayonlistckbx_XPATH");

			// click on the unique identifier checkbox
			click("customform_addfield_uniqueidentifierckbx_XPATH");

			// click on the add button
			click("customform_addfield_addbtn_XPATH");

			// wait for the element
			explicitWaitClickable("closetoastmsg_CSS");

			// click on the toaster close button
			click("closetoastmsg_CSS");

			// validate the newly created field
			try {
				String field1 = "//span[text()='" + fieldName1 + "']";
				String field1_actual = (driver.findElement(By.xpath(field1)).getText()).trim();

				if (field1_actual.equals(fieldName1)) {
					successMessage("The newly created field is displayed successfully.");
				} else {
					verificationFailedMessage("The newly created field is not displayed.");
				}
			} catch (Throwable t) {
				verificationFailedMessage("The newly created field is not displayed.");
			}

			// click on the add field button
			click("customform_addfieldbtn_XPATH");

			// enter field name
			type("customform_addfield_nametxt_XPATH", fieldName2);

			// select the option from the type dropdown
			select("customform_addfield_typedd_XPATH", data.get("fieldtype_2"));

			// click on the display on list checkbox
			click("customform_addfield_displayonlistckbx_XPATH");

			// click on the unique identifier checkbox
			click("customform_addfield_uniqueidentifierckbx_XPATH");

			// click on the add button
			click("customform_addfield_addbtn_XPATH");

			// wait for the element
			explicitWaitClickable("closetoastmsg_CSS");

			// click on the toaster close button
			click("closetoastmsg_CSS");

			// validate the newly created field
			try {
				String field2 = "//span[text()='" + fieldName2 + "']";
				String field2_actual = (driver.findElement(By.xpath(field2)).getText()).trim();

				if (field2_actual.equals(fieldName2)) {
					successMessage("The newly created field is displayed successfully.");
				} else {
					verificationFailedMessage("The newly created field is not displayed.");
				}
			} catch (Throwable t) {
				verificationFailedMessage("The newly created field is not displayed.");
			}

			// click on the add new page icon
			click("customform_portfoliodashboard_addnewpagebtn_XPATH");

			// enter the first page name name in the page name field
			type("customform_portfoliodashboard_pagenametxt_XPATH", pageName1);

			// click on the add button
			click("customform_portfoliodashboard_pagename_addbtn_XPATH");

			// validate the newly added page
			try {
				String page1 = "//span[contains(text(),'" + pageName1 + "')]";
				String page1_actual = (driver.findElement(By.xpath(page1)).getText()).trim();

				if (page1_actual.equals(pageName1)) {
					successMessage("The newly created page is displayed successfully.");
				} else {
					verificationFailedMessage("The newly created page is not displayed.");
				}
			} catch (Throwable t) {
				verificationFailedMessage("The newly created page is not displayed.");
			}

			// click on the update button
			click("customform_updatebtn_XPATH");

			// wait for the element
			explicitWaitClickable("closetoastmsg_CSS");

			// click on the toaster close button
			click("closetoastmsg_CSS");

			// ADD FIELDS IN THE FIRST PAGE
			title("ADD FIELDS IN THE FIRST PAGE");

			// click on the first page name tab
			String page1 = "//span[contains(text(),'" + pageName1 + "')]";
			driver.findElement(By.xpath(page1)).click();
			consoleMessage("Clicked on the first page name tab.");

			// click on the add field button
			click("customform_addfieldbtn_XPATH");

			// scroll to bottom
			scrollBottom();

			// enter field name
			type("customform_addfield_nametxt_XPATH", pageFieldName1);

			// select the option from the type dropdown
			select("customform_addfield_typedd_XPATH", data.get("fieldtype_1"));

			// click on the display on list checkbox
			click("customform_addfield_displayonlistckbx_XPATH");

			// click on the unique identifier checkbox
			click("customform_addfield_uniqueidentifierckbx_XPATH");

			// click on the add button
			click("customform_addfield_addbtn_XPATH");

			// wait for the element
			explicitWaitClickable("closetoastmsg_CSS");

			// click on the toaster close button
			click("closetoastmsg_CSS");

			// click on the first page name tab
			String page11 = "//span[contains(text(),'" + pageName1 + "')]";
			driver.findElement(By.xpath(page11)).click();
			consoleMessage("Clicked on the first page name tab.");

			// scroll to bottom
			scrollBottom();

			// validate the newly created field
			try {
				String field1 = "//span[text()='" + pageFieldName1 + "']";
				String field1_actual = (driver.findElement(By.xpath(field1)).getText()).trim();

				if (field1_actual.equals(pageFieldName1)) {
					successMessage("The newly created field is displayed successfully.");
				} else {
					verificationFailedMessage("The newly created field is not displayed.");
				}
			} catch (Throwable t) {
				verificationFailedMessage("The newly created field is not displayed.");
			}

			// click on the add field button
			click("customform_addfieldbtn_XPATH");

			// scroll to bottom
			scrollBottom();

			// enter field name
			type("customform_addfield_nametxt_XPATH", pageFieldName2);

			// select the option from the type dropdown
			select("customform_addfield_typedd_XPATH", data.get("fieldtype_2"));

			// click on the display on list checkbox
			click("customform_addfield_displayonlistckbx_XPATH");

			// click on the unique identifier checkbox
			click("customform_addfield_uniqueidentifierckbx_XPATH");

			// click on the add button
			click("customform_addfield_addbtn_XPATH");

			// wait for the element
			explicitWaitClickable("closetoastmsg_CSS");

			// click on the toaster close button
			click("closetoastmsg_CSS");

			// click on the first page name tab
			String page111 = "//span[contains(text(),'" + pageName1 + "')]";
			driver.findElement(By.xpath(page111)).click();
			consoleMessage("Clicked on the first page name tab.");

			// scroll to bottom
			scrollBottom();

			// validate the newly created field
			try {
				String field2 = "//span[text()='" + pageFieldName2 + "']";
				String field2_actual = (driver.findElement(By.xpath(field2)).getText()).trim();

				if (field2_actual.equals(pageFieldName2)) {
					successMessage("The newly created field is displayed successfully.");
				} else {
					verificationFailedMessage("The newly created field is not displayed.");
				}
			} catch (Throwable t) {
				verificationFailedMessage("The newly created field is not displayed.");
			}

			// click on the update button
			click("customform_updatebtn_XPATH");

			// wait for the element
			explicitWaitClickable("closetoastmsg_CSS");

			// click on the toaster close button
			click("closetoastmsg_CSS");

		} catch (Throwable t) {
			verificationFailed();
		}

		// click on the home icon from the top of the screen
		click("questionnaire_homeburgermenubtn_CSS");

		// wait for the element
		explicitWait("propertylist_title_XPATH");

		// verify the property list
		switchVerification("prope	rtylist_title_XPATH", "Property List", "The property list is not displayed.");

		// ADD THE DETAILS IN THE CUSTOM FORM WITH THE RISK SCORE FROM THE PORTFOLIO
		// DASHBOARD
		title("ADD THE DETAILS IN THE CUSTOM FORM WITH THE RISK SCORE FROM THE PORTFOLIO DASHBOARD");

		try {

			// wait for the element
			Thread.sleep(5000);

			// click on the side menu
			click("menubtn_CSS");

			// wait for the element
			Thread.sleep(5000);

			// click on the portfolio dashboard from side menu
			click("sidemenu_portfoliosummary_XPATH");

			// scrolldown till Property Information section
			scrollTillElement("customform_portfoliodashboard_propertyinformationtitle_XPATH");

			// validate the newly created custom form in the portfolio dashboard screen
			try {
				String customForm1 = "//td[text()='" + name + "']";
				String customForm1_actual = (driver.findElement(By.xpath(customForm1)).getText()).trim();

				if (customForm1_actual.equals(name)) {
					successMessage("The newly created custom form is displayed successfully.");

				} else {
					verificationFailedMessage("The newly created custom form is not displayed.");
				}

			} catch (Throwable t) {
				verificationFailedMessage("The newly created custom form is not displayed.");
			}

			// click on the custom form
			String customForm1 = "//td[text()='" + name + "']";
			driver.findElement(By.xpath(customForm1)).click();
			consoleMessage("Clicked on the custom form.");

			// click on the property one
			click("customform_portfoliodashboard_propertyname_XPATH");

			// ADD THE DETAILS IN THE FIELDS OF THE DETAILS TAB
			title("ADD THE DETAILS IN THE FIELDS OF THE DETAILS TAB");

			// scroll down to bottom
			scrollBottom();

			// click on the edit field button
			click("customform_portfoliodashboard_editfieldbtn_XPATH");

			// enter the details in the first field
			String firstField = "//input[@id='" + fieldName1 + "TEXT']";
			driver.findElement(By.xpath(firstField)).sendKeys(fieldDetail1);
			consoleMessage("Entered the details in the first field.");

			// enter the details in the second field
			String secondField = "//input[@id='" + fieldName2 + "NUMBER']";
			driver.findElement(By.xpath(secondField)).sendKeys(fieldDetail2);
			consoleMessage("Entered the details in the second field.");

			// click on the save button
			click("customform_portfoliodashboard_fields_savebtn_XPATH");

			// scroll to bottom
			scrollBottom();

			// wait for the element
			Thread.sleep(5000);

			// validate the details of the first field
			try {
				String firstField1 = "//span[contains(text(),'" + fieldDetail1 + "')]";
				String firstField1_actual = (driver.findElement(By.xpath(firstField1)).getText()).trim();

				if (firstField1_actual.equals(fieldDetail1)) {
					successMessage("The details of the first field is displayed successfully.");
				} else {
					verificationFailedMessage("The details of the first field is not displayed.");
				}
			} catch (Throwable t) {
				verificationFailedMessage("The details of the first field is not displayed.");
			}

			// validate the details of the second field
			try {
				String secondField1 = "//span[contains(text(),'" + fieldDetail2 + "')]";
				String secondField1_actual = (driver.findElement(By.xpath(secondField1)).getText()).trim();

				if (secondField1_actual.equals(fieldDetail2)) {
					successMessage("The details of the second field is displayed successfully.");
				} else {
					verificationFailedMessage("The details of the second field is not displayed.");
				}
			} catch (Throwable t) {
				verificationFailedMessage("The details of the second field is not displayed.");
			}

			// click on the first page name tab
			String pageTab1 = "//span[text()='" + pageName1 + "']";
			driver.findElement(By.xpath(pageTab1)).click();
			consoleMessage("Clicked on the first page name tab.");

			// ADD THE DETAILS IN THE FIELDS OF THE FIRST PAGE TAB
			title("ADD THE DETAILS IN THE FIELDS OF THE FIRST PAGE TAB");

			// scroll to bottom
			scrollBottom();

			// click on the edit field button
			click("customform_portfoliodashboard_editfieldbtn_XPATH");

			// enter the details in the first field
			String firstPageField = "//input[@id='" + pageFieldName1 + "TEXT']";
			driver.findElement(By.xpath(firstPageField)).sendKeys(pageFieldDetail1);
			consoleMessage("Entered the details in the first field.");

			// enter the details in the second field
			String secondPageField = "//input[@id='" + pageFieldName2 + "NUMBER']";
			driver.findElement(By.xpath(secondPageField)).sendKeys(pageFieldDetail2);
			consoleMessage("Entered the details in the second field.");

			// click on the save button
			click("customform_portfoliodashboard_fields_savebtn_XPATH");

			// scroll to bottom
			scrollBottom();

			// wait for the element
			Thread.sleep(5000);

			// validate the details of the first field of the first page
			try {
				String firstField1 = "//span[contains(text(),'" + pageFieldDetail1 + "')]";
				String firstField1_actual = (driver.findElement(By.xpath(firstField1)).getText()).trim();

				if (firstField1_actual.equals(pageFieldDetail1)) {
					successMessage("The details of the first field of the first page is displayed successfully.");
				} else {
					verificationFailedMessage("The details of the first field of the first page is not displayed.");
				}
			} catch (Throwable t) {
				verificationFailedMessage("The details of the first field of the first page is not displayed.");
			}

			// validate the details of the second field of the first page
			try {
				String secondField1 = "//span[contains(text(),'" + pageFieldDetail2 + "')]";
				String secondField1_actual = (driver.findElement(By.xpath(secondField1)).getText()).trim();

				if (secondField1_actual.equals(pageFieldDetail2)) {
					successMessage("The details of the second field of the first page is displayed successfully.");
				} else {
					verificationFailedMessage("The details of the second field of the first page is not displayed.");
				}
			} catch (Throwable t) {
				verificationFailedMessage("The details of the second field is of the first page not displayed.");
			}

			// ADD THE DETAILS IN THE FIELDS OF THE RISK SCORING TAB
			title("ADD THE DETAILS IN THE FIELDS OF THE RISK SCORING TAB");

			// click on the action
			click("customform_portfoliodashboard_actionicon_XPATH");

			// click on the risk score option
			click("customform_portfoliodashboard_riskscoreoption_XPATH");

			// select on the risk category option
			select("customform_riskcategorydd_XPATH", data.get("score_category"));

			// enter the score in the score field
			type("customform_scoretxt_XPATH", score);

			// select the option from the status dropdown
			select("customform_statusdd_XPATH", data.get("risk_status"));

			// enter the text in description field
			type("customform_descriptiontxt_XPATH", data.get("details"));

			// click on the update button
			click("customform_portfoliodashboard_riskscoringupdatebtn_XPATH");

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

				// validate the risk score of the property
				try {
					String Score = "//td[text()='" + name + "']//following-sibling::td[@class='ng-binding']";
					String riskScore = (driver.findElement(By.xpath(Score)).getText()).trim();
					int riskScore_actual = Integer.parseInt(riskScore);
					int score_expected = Integer.parseInt(score);

					if (riskScore_actual == score_expected) {
						successMessage("The risk score of the property is displayed correctly.");
					} else {
						verificationFailedMessage("The risk score of the property is not displayed correctly.");
					}
				} catch (Throwable t) {
					verificationFailedMessage("The risk score of the property is not displayed correctly.");
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
				
				// validate the risk score of the property
				try {
					String Score = "//td[text()='" + name + "']//following-sibling::td[@class='ng-binding']";
					String riskScore = (driver.findElement(By.xpath(Score)).getText()).trim();
					int riskScore_actual = Integer.parseInt(riskScore);
					int score_expected = Integer.parseInt(score);

					if (riskScore_actual == score_expected) {
						successMessage("The risk score of the property is displayed correctly.");
					} else {
						verificationFailedMessage("The risk score of the property is not displayed correctly.");
					}
				} catch (Throwable t) {
					verificationFailedMessage("The risk score of the property is not displayed correctly.");
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

				// validate the risk score of the property
				try {
					String Score = "//td[text()='" + name + "']//following-sibling::td[@class='ng-binding']";
					String riskScore = (driver.findElement(By.xpath(Score)).getText()).trim();
					int riskScore_actual = Integer.parseInt(riskScore);
					int score_expected = Integer.parseInt(score);

					if (riskScore_actual == score_expected) {
						successMessage("The risk score of the property is displayed correctly.");
					} else {
						verificationFailedMessage("The risk score of the property is not displayed correctly.");
					}
				} catch (Throwable t) {
					verificationFailedMessage("The risk score of the property is not displayed correctly.");
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
				
				// validate the risk score of the property
				try {
					String Score = "//td[text()='" + name + "']//following-sibling::td[@class='ng-binding']";
					String riskScore = (driver.findElement(By.xpath(Score)).getText()).trim();
					int riskScore_actual = Integer.parseInt(riskScore);
					int score_expected = Integer.parseInt(score);

					if (riskScore_actual == score_expected) {
						successMessage("The risk score of the property is displayed correctly.");
					} else {
						verificationFailedMessage("The risk score of the property is not displayed correctly.");
					}
				} catch (Throwable t) {
					verificationFailedMessage("The risk score of the property is not displayed correctly.");
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

		// DELETE THE CUSTOMER FORM
		title("DELETE THE CUSTOMER FORM");

		try {

			// Wait for the element
			Thread.sleep(5000);

			// click on the settings icon from the top of the screen
			click("questionnaire_settingicon_CSS");

			// wait for the element
			explicitWaitClickable("questionnaire_administrationoption_XPATH");

			// click on the Administration option from the side menu
			click("questionnaire_administrationoption_XPATH");

			// click on the system tab
			click("questionnaire_systemtab_XPATH");

			// click on the custom form option
			click("customform_option_XPATH");

			// wait for the element
			Thread.sleep(5000);

			// click on the delete button of the custom form
			String deleteIcon = "//td[text()='" + name
					+ "']//following-sibling::td[@class='pointer']//i[@data-target='#deleteCustomFormModal']";
			driver.findElement(By.xpath(deleteIcon)).click();
			consoleMessage("Clicked on the delete button of the updated custom form.");

			// wait for the element
			Thread.sleep(5000);

			// click on the delete button
			click("customform_deletebtn_XPATH");

			// validate the respective record is deleted or not
			try {
				String deletedRecord = "//td[text()='" + name + "']";
				boolean deletedRecord_actual = driver.findElement(By.xpath(deletedRecord)).isDisplayed();

				if (deletedRecord_actual == true) {
					verificationFailedMessage("The deleted record of the custom form is displayed.");
				} else {
					successMessage("The deleted record of the custom form is not displayed as expected.");
				}

			} catch (Throwable t) {
				successMessage("The deleted record of the custom form is not displayed as expected.");
			}

		} catch (Throwable t) {
			verificationFailed();
		}

		// click on the home icon from the top of the screen
		click("questionnaire_homeburgermenubtn_CSS");

		// wait for the element
		explicitWait("propertylist_title_XPATH");

		// verify the property list
		switchVerification("propertylist_title_XPATH", "Property List", "The property list is not displayed.");

	}
}
