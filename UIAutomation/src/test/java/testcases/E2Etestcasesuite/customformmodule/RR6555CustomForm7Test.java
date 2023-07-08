package testcases.E2Etestcasesuite.customformmodule;

import java.io.IOException;
import java.time.LocalDate;
import java.util.Hashtable;
import java.util.List;

import org.apache.commons.lang3.RandomStringUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import base.TestBase;
import utilities.TestUtil;

public class RR6555CustomForm7Test extends TestBase {

	@Test(dataProviderClass = TestUtil.class, dataProvider = "dp")
	public void rR6555CustomForm7Test(Hashtable<String, String> data) throws IOException, InterruptedException {

		execution(data, "rR6555CustomForm7Test");

		// VERIFY THE RISK SCORE OF THE ENVIRONMENTAL RECORD AND SINGLE-TYPE CUSTOM FORM
		// ON THE PROPERTY SUMMARY DASHBOARD AND PORTFOLIO DASHBOARD WITH A SINGLE
		// PROPERTY.
		title("VERIFY THE RISK SCORE OF THE ENVIRONMENTAL RECORD AND SINGLE-TYPE CUSTOM FORM ON THE PROPERTY SUMMARY DASHBOARD AND PORTFOLIO DASHBOARD WITH A SINGLE PROPERTY.");

		// refresh the page
		driver.navigate().refresh();
		Thread.sleep(5000);
		driver.navigate().refresh();

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
		String env_score = RandomStringUtils.randomNumeric(2);
		String env_updatescore = RandomStringUtils.randomNumeric(2);
		String custform_score = RandomStringUtils.randomNumeric(2);
		String custform_updatescore = RandomStringUtils.randomNumeric(2);
		String location_description = RandomStringUtils.randomAlphabetic(8);
		String[] todayDate = LocalDate.now().toString().split("-");

		// DELETE ALL THE PREVIOUSLY ADDED ENVIRONMENTAL RECORDS FROM THE PROPERTY ONE
		title("DELETE ALL THE PREVIOUSLY ADDED ENVIRONMENTAL RECORDS FROM THE PROPERTY ONE");

		try {

			// enter the property name in the search field
			type("ohs_incidentreport_searchtxt_XPATH", data.get("property_1"));

			// wait for the element
			explicitWaitClickable("environmentalicon_CSS");

			// click on the environmental icon from the property list page
			click("environmentalicon_CSS");

			// click on the burger menu
			click("menubtn_CSS");

			// wait for the element
			explicitWaitClickable("envrecords_XPATH");

			// click on the environmental records
			click("envrecords_XPATH");

			// click on the Primary Hazardous Substance
			click("envrecords_primaryhazardoussubstance_XPATH");

			// click on the asbestos materials
			click("envreports_asbestosmaterials_XPATH");

			// delete all the environmental records
			try {
				List<WebElement> list = driver
						.findElements(By.xpath(OR.getProperty("envreports_asbestosmaterials_recordlist_XPATH")));
				int list_count = list.size();

				for (int i = 1; i <= list_count; i++) {

					// click on the first record of the environmental record
					String firstRecird = "//table[@id='environmentalDocumentListTable']//tbody//tr[" + i
							+ "]//td[@id='asbestosMaterial']";
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

		try {

			// enter the property name in the search field
			type("ohs_incidentreport_searchtxt_XPATH", data.get("property_1"));

			// wait for the element
			explicitWaitClickable("environmentalicon_CSS");

			// click on the environmental icon from the property list page
			click("environmentalicon_CSS");

			// click on the burger menu
			click("menubtn_CSS");

			// wait for the element
			explicitWaitClickable("envrecords_XPATH");

			// click on the environmental records
			click("envrecords_XPATH");

			// click on the Primary Hazardous Substance
			click("envrecords_primaryhazardoussubstance_XPATH");

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
			type("envreports_asbestosmaterials_scoretxt_XPATH", env_score);

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
		switchVerification("propertylist_title_XPATH", "Property List", "The property list is not displayed.");

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
			type("customform_scoretxt_XPATH", custform_score);

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

		// VALIDATE THE RISK SCORING CARD IN THE PORTFOLIO DASHBOARD SCREEN
		title("VALIDATE THE RISK SCORING CARD IN THE PORTFOLIO DASHBOARD SCREEN");

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

			// select the current year in the month dropdown
			String month = todayDate[1].replaceFirst("^0+(?!$)", "");
			select("customform_portfoliodashboard_riskscoringcard_monthdd_XPATH", month);

			// scroll down to bottom
			scrollBottom();

			// click on the property 1 name
			click("customform_portfoliodashboard_propertyname_XPATH");

			// validate the risk score of the single type custom form of the property
			try {
				String Score1 = "//td[text()='" + name + "']//following-sibling::td[@class='ng-binding']";
				String riskScore = (driver.findElement(By.xpath(Score1)).getText()).trim();
				int riskScore_actual = Integer.parseInt(riskScore);
				int score_expected = Integer.parseInt(custform_score);

				if (riskScore_actual == score_expected) {
					successMessage(
							"The risk score of the single type custom form of the property is displayed correctly.");
				} else {
					verificationFailedMessage(
							"The risk score of the single type custom form of the property is not displayed correctly.");
				}
			} catch (Throwable t) {
				verificationFailedMessage(
						"The risk score of the single type custom form of the property is not displayed correctly.");
			}

			// validate the risk score of the environmental records of the property
			try {
				String Score2 = "//td[text()='Asbestos Materials']//following-sibling::td[@class='ng-binding']";
				String riskScore = (driver.findElement(By.xpath(Score2)).getText()).trim();
				int riskScore_actual = Integer.parseInt(riskScore);
				int env_score_int = Integer.parseInt(env_score);

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

		// VALIDATE THE RISK SCORING CARD IN THE PROPERTY SUMMARY DASHBOARD SCREEN
		title("VALIDATE THE RISK SCORING CARD IN THE PROPERTY SUMMARY DASHBOARD SCREEN");

		try {

			// wait for the element
			Thread.sleep(5000);

			// click on the property
			click("propertysummary_property1_XPATH");

			// scrolldown till risk scoring card
			scrollTillElement("customform_portfoliodashboard_riskscoringcard_XPATH");

			// select the current year in the year dropdown
			select("customform_portfoliodashboard_riskscoringcard_yeardd_XPATH", todayDate[0]);

			// select the current year in the month dropdown
			String month = todayDate[1].replaceFirst("^0+(?!$)", "");
			select("customform_portfoliodashboard_riskscoringcard_monthdd_XPATH", month);

			// scroll down to bottom
			scrollBottom();

			// validate the risk score of the single type custom form of the property
			try {
				String Score1 = "//td[text()='" + name + "']//following-sibling::td[@class='ng-binding']";
				String riskScore = (driver.findElement(By.xpath(Score1)).getText()).trim();
				int riskScore_actual = Integer.parseInt(riskScore);
				int score_expected = Integer.parseInt(custform_score);

				if (riskScore_actual == score_expected) {
					successMessage(
							"The risk score of the single type custom form of the property is displayed correctly.");
				} else {
					verificationFailedMessage(
							"The risk score of the single type custom form of the property is not displayed correctly.");
				}
			} catch (Throwable t) {
				verificationFailedMessage(
						"The risk score of the single type custom form of the property is not displayed correctly.");
			}

			// validate the risk score of the environmental records of the property
			try {
				String Score2 = "//td[text()='Asbestos Materials']//following-sibling::td[@class='ng-binding']";
				String riskScore = (driver.findElement(By.xpath(Score2)).getText()).trim();
				int riskScore_actual = Integer.parseInt(riskScore);
				int env_score_int = Integer.parseInt(env_score);

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

		// UPDATE THE RISK SCORE OF THE ENVIRONMENTAL RECORD
		title("UPDATE THE RISK SCORE OF THE ENVIRONMENTAL RECORD");

		try {

			// enter the property name in the search field
			type("ohs_incidentreport_searchtxt_XPATH", data.get("property_1"));

			// wait for the element
			explicitWaitClickable("environmentalicon_CSS");

			// click on the environmental icon from the property list page
			click("environmentalicon_CSS");

			// click on the burger menu
			click("menubtn_CSS");

			// wait for the element
			explicitWaitClickable("envrecords_XPATH");

			// click on the environmental records
			click("envrecords_XPATH");

			// click on the Primary Hazardous Substance
			click("envrecords_primaryhazardoussubstance_XPATH");

			// click on the asbestos materials
			click("envreports_asbestosmaterials_XPATH");

			// click on the newly created environmental record
			String envrecord = "//span[text()='" + location_description + "']";
			driver.findElement(By.xpath(envrecord)).click();
			consoleMessage("Clicked on the newly created environmental record.");

			// click on the risk scoring tab
			click("envreports_asbestosmaterials_riskscoringtab_XPATH");

			// select on the risk category option
			select("envreports_asbestosmaterials_riskcategorydd_XPATH", data.get("score_category_update"));

			// enter the score in the score field
			type("envreports_asbestosmaterials_scoretxt_XPATH", env_updatescore);

			// select the option from the status dropdown
			select("envreports_asbestosmaterials_statusdd_XPATH", data.get("risk_status_update"));

			// enter the text in description field
			type("envreports_asbestosmaterials_descriptiontxt_XPATH", data.get("details"));

			// click on the update button
			click("envreports_asbestosmaterials_updatebtn_CSS");

			// wait for the element
			explicitWaitClickable("closetoastmsg_CSS");

			// click on the toaster close button
			click("closetoastmsg_CSS");

			// enter the newly created environmental record in the search field
			type("task_listofchecklist_filterfield_CSS", location_description);

			// verify added details of the Asbestos Materials record is correct or not
			try {
				envrecord = "//span[text()='" + location_description + "']";
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

		// UPDATE THE RISK SCORING DETAILS OF THE CUSTOM FORM FROM THE PROPERTY SUMMARY
		// DASHBOARD
		title("UPDATE THE RISK SCORING DETAILS OF THE CUSTOM FORM FROM THE PROPERTY SUMMARY DASHBOARD");

		try {

			// wait for the element
			Thread.sleep(5000);

			// click on the property
			click("propertysummary_property1_XPATH");

			// scrolldown till Property Information section
			scrollTillElement("customform_portfoliodashboard_propertyinformationtitle_XPATH");

			// validate the newly created custom form in the property summary dashboard
			// screen
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

			// scroll to bottom
			scrollBottom();

			// validate the custom form as a title
			try {
				String customName = "//h4[contains(text(),'" + name + "')]";
				String customName_actual = (driver.findElement(By.xpath(customName)).getText()).trim();

				if (customName_actual.equals(name)) {
					successMessage("The custom form name is displayed correctly.");
				} else {
					verificationFailedMessage("The custom form is not displayed.");
				}
			} catch (Throwable t) {
				verificationFailedMessage("The custom form is not displayed.");
			}

			// UPDATE THE DETAILS OF THE RISK SCORING TAB
			title("UPDATE THE DETAILS OF THE RISK SCORING TAB");

			// click on the action
			click("customform_portfoliodashboard_actionicon_XPATH");

			// click on the risk score option
			click("customform_portfoliodashboard_riskscoreoption_XPATH");

			// scroll to bottom
			scrollBottom();

			// select on the risk category option
			select("customform_riskcategorydd_XPATH", data.get("score_category_update"));

			// enter the score in the score field
			type("customform_scoretxt_XPATH", custform_updatescore);

			// select the option from the status dropdown
			select("customform_statusdd_XPATH", data.get("risk_status_update"));

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

		// VALIDATE THE UPDATED RISK SCORING CARD IN THE PORTFOLIO DASHBOARD SCREEN
		title("VALIDATE THE UPDATED RISK SCORING CARD IN THE PORTFOLIO DASHBOARD SCREEN");

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

			// select the current year in the year dropdown
			select("customform_portfoliodashboard_riskscoringcard_yeardd_XPATH", todayDate[0]);

			// select the current year in the month dropdown
			String month = todayDate[1].replaceFirst("^0+(?!$)", "");
			select("customform_portfoliodashboard_riskscoringcard_monthdd_XPATH", month);

			// scroll down to bottom
			scrollBottom();

			// click on the property 1 name
			click("customform_portfoliodashboard_propertyname_XPATH");

			// validate the updated risk score of the single type custom form of the
			// property
			try {
				String Score1 = "//td[text()='" + name + "']//following-sibling::td[@class='ng-binding']";
				String riskScore = (driver.findElement(By.xpath(Score1)).getText()).trim();
				int riskScore_actual = Integer.parseInt(riskScore);
				int score_expected = Integer.parseInt(custform_updatescore);

				if (riskScore_actual == score_expected) {
					successMessage(
							"The updated risk score of the single type custom form of the property is displayed correctly.");
				} else {
					verificationFailedMessage(
							"The updated risk score of the single type custom form of the property is not displayed correctly.");
				}
			} catch (Throwable t) {
				verificationFailedMessage(
						"The updated risk score of the single type custom form of the property is not displayed correctly.");
			}

			// validate the updated risk score of the environmental records of the property
			try {
				String Score2 = "//td[text()='Asbestos Materials']//following-sibling::td[@class='ng-binding']";
				String riskScore = (driver.findElement(By.xpath(Score2)).getText()).trim();
				int riskScore_actual = Integer.parseInt(riskScore);
				int env_score_int = Integer.parseInt(env_updatescore);

				if (riskScore_actual == env_score_int) {
					successMessage(
							"The updated risk score of the environmental records of the property is displayed correctly.");
				} else {
					verificationFailedMessage(
							"The updated risk score of the environmental records of the property is not displayed correctly.");
				}
			} catch (Throwable t) {
				verificationFailedMessage(
						"The updated risk score of the environmental records of the property is not displayed correctly.");
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

		// VALIDATE THE UPDATED RISK SCORING CARD IN THE PROPERTY SUMMARY DASHBOARD
		// SCREEN
		title("VALIDATE THE UPDATED RISK SCORING CARD IN THE PROPERTY SUMMARY DASHBOARD SCREEN");

		try {

			// wait for the element
			Thread.sleep(5000);

			// click on the property
			click("propertysummary_property1_XPATH");

			// scrolldown till risk scoring card
			scrollTillElement("customform_portfoliodashboard_riskscoringcard_XPATH");

			// select the current year in the year dropdown
			select("customform_portfoliodashboard_riskscoringcard_yeardd_XPATH", todayDate[0]);

			// select the current year in the month dropdown
			String month = todayDate[1].replaceFirst("^0+(?!$)", "");
			select("customform_portfoliodashboard_riskscoringcard_monthdd_XPATH", month);

			// scroll down to bottom
			scrollBottom();

			// validate the updated risk score of the single type custom form of the
			// property
			try {
				String Score1 = "//td[text()='" + name + "']//following-sibling::td[@class='ng-binding']";
				String riskScore = (driver.findElement(By.xpath(Score1)).getText()).trim();
				int riskScore_actual = Integer.parseInt(riskScore);
				int score_expected = Integer.parseInt(custform_updatescore);

				if (riskScore_actual == score_expected) {
					successMessage(
							"The updated risk score of the single type custom form of the property is displayed correctly.");
				} else {
					verificationFailedMessage(
							"The updated risk score of the single type custom form of the property is not displayed correctly.");
				}
			} catch (Throwable t) {
				verificationFailedMessage(
						"The updated risk score of the single type custom form of the property is not displayed correctly.");
			}

			// validate the updated risk score of the environmental records of the property
			try {
				String Score2 = "//td[text()='Asbestos Materials']//following-sibling::td[@class='ng-binding']";
				String riskScore = (driver.findElement(By.xpath(Score2)).getText()).trim();
				int riskScore_actual = Integer.parseInt(riskScore);
				int env_score_int = Integer.parseInt(env_updatescore);

				if (riskScore_actual == env_score_int) {
					successMessage(
							"The updated risk score of the environmental records of the property is displayed correctly.");
				} else {
					verificationFailedMessage(
							"The updated risk score of the environmental records of the property is not displayed correctly.");
				}
			} catch (Throwable t) {
				verificationFailedMessage(
						"The updated risk score of the environmental records of the property is not displayed correctly.");
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

		// DELETE THE ENVIRONMENTAL RECORD
		title("DELETE THE ENVIRONMENTAL RECORD");

		try {

			// enter the property name in the search field
			type("ohs_incidentreport_searchtxt_XPATH", data.get("property_1"));

			// wait for the element
			explicitWaitClickable("environmentalicon_CSS");

			// click on the environmental icon from the property list page
			click("environmentalicon_CSS");

			// click on the burger menu
			click("menubtn_CSS");

			// wait for the element
			explicitWaitClickable("envrecords_XPATH");

			// click on the environmental records
			click("envrecords_XPATH");

			// click on the Primary Hazardous Substance
			click("envrecords_primaryhazardoussubstance_XPATH");

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

		// VALIDATE THE RISK SCORING CARD IN THE PORTFOLIO DASHBOARD SCREEN AFTER
		// DELETED ALL THE RECORDS
		title("VALIDATE THE UPDATED RISK SCORING CARD IN THE PORTFOLIO DASHBOARD SCREEN AFTER DELETED ALL THE RECORDS");

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

			// select the current year in the month dropdown
			String month = todayDate[1].replaceFirst("^0+(?!$)", "");
			select("customform_portfoliodashboard_riskscoringcard_monthdd_XPATH", month);

			// scroll down to bottom
			scrollBottom();

			// validate the deleted risk score of the property
			try {

				boolean propertyName = driver
						.findElement(By.xpath(OR.getProperty("customform_portfoliodashboard_propertyname_XPATH")))
						.isDisplayed();

				if (propertyName == true) {

					// click on the property 1 name
					click("customform_portfoliodashboard_propertyname_XPATH");

					// validate the risk score of the property
					try {
						String Score = "//td[text()='" + name + "']";
						boolean riskScore = driver.findElement(By.xpath(Score)).isDisplayed();

						if (riskScore == true) {
							verificationFailedMessage(
									"The risk score of the single type custom form of the property is displayed.");
						} else {
							successMessage(
									"The risk score of the single type custom form of the property is not displayed as expected.");
						}
					} catch (Throwable t) {
						successMessage(
								"The risk score of the single type custom form of the property is not displayed as expected.");
					}

					// validate the risk score of the property
					try {
						String Score = "//td[text()='Asbestos Materials']";
						boolean riskScore = driver.findElement(By.xpath(Score)).isDisplayed();

						if (riskScore == true) {
							verificationFailedMessage(
									"The risk score of the environmental record of the property is displayed.");
						} else {
							successMessage(
									"The risk score of the environmental record of the property is not displayed as expected.");
						}
					} catch (Throwable t) {
						successMessage(
								"The risk score of the environmental record of the property is not displayed as expected.");
					}

				}
			} catch (Throwable t) {
				successMessage("The deleted risk score of the property is not displayed as expected.");
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

		// VALIDATE THE UPDATED RISK SCORING CARD IN THE PROPERTY SUMMARY DASHBOARD
		// SCREEN AFTER DELETED ALL THE RECORDS
		title("VALIDATE THE UPDATED RISK SCORING CARD IN THE PROPERTY SUMMARY DASHBOARD SCREEN AFTER DELETED ALL THE RECORDS");

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
				String Score = "//td[text()='" + name + "']";
				boolean riskScore = driver.findElement(By.xpath(Score)).isDisplayed();

				if (riskScore == true) {
					verificationFailedMessage(
							"The risk score of the single type custom form of the property is displayed.");
				} else {
					successMessage(
							"The risk score of the single type custom form of the property is not displayed as expected.");
				}
			} catch (Throwable t) {
				successMessage(
						"The risk score of the single type custom form of the property is not displayed as expected.");
			}

			// validate the risk score of the property
			try {
				String Score = "//td[text()='Asbestos Materials']";
				boolean riskScore = driver.findElement(By.xpath(Score)).isDisplayed();

				if (riskScore == true) {
					verificationFailedMessage(
							"The risk score of the environmental record of the property is displayed.");
				} else {
					successMessage(
							"The risk score of the environmental record of the property is not displayed as expected.");
				}
			} catch (Throwable t) {
				successMessage(
						"The risk score of the environmental record of the property is not displayed as expected.");
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
