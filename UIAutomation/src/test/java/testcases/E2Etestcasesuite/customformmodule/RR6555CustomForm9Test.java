package testcases.E2Etestcasesuite.customformmodule;

import java.io.IOException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Hashtable;
import java.util.List;
import java.util.Random;

import org.apache.commons.lang3.RandomStringUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import base.TestBase;
import utilities.TestUtil;

public class RR6555CustomForm9Test extends TestBase {

	@Test(dataProviderClass = TestUtil.class, dataProvider = "dp")
	public void rR6555CustomForm9Test(Hashtable<String, String> data) throws IOException, InterruptedException {

		execution(data, "rR6555CustomForm9Test");

		// VERIFY THE RISK SCORE OF THE ENVIRONMENTAL RECORD AND MULTIPLE TYPE CUSTOM
		// FORMS WITH MULTIPLE DETAILS ON THE PROPERTY SUMMARY DASHBOARD AND PORTFOLIO
		// DASHBOARD WITH MULTIPLE ENVIRONMENTS RECORDS OF THE SINGLE PROPERTY.
		title("VERIFY THE RISK SCORE OF THE ENVIRONMENTAL RECORD AND MULTIPLE TYPE CUSTOM FORMS WITH MULTIPLE DETAILS ON THE PROPERTY SUMMARY DASHBOARD AND PORTFOLIO DASHBOARD WITH MULTIPLE ENVIRONMENTS RECORDS OF THE SINGLE PROPERTY.");

		// refresh the page
		driver.navigate().refresh();
		Thread.sleep(5000);
		driver.navigate().refresh();

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

		// CREATE RANDOM NUMBERS OF NEW RECORD OF THE ENVIRONMENTAL RECORD WITH THE RISK
		// SCORE
		title("CREATE RANDOM NUMBERS OF NEW RECORD OF THE ENVIRONMENTAL RECORD WITH THE RISK SCORE");

		Random random = new Random();
		int env_count = random.nextInt(5 - 3) + 3;
		String env_score = RandomStringUtils.randomNumeric(2);
		List<String> location_description_list = new ArrayList<String>();
		int env_totalScore = 0;

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

			for (int i = 0; i < env_count; i++) {

				// click on the add button
				click("envreports_asbestosmaterials_addbtn_CSS");

				// select the material
				select("envreports_asbestosmaterials_materialdd_CSS", data.get("material"));

				// enter the detailed description
				type("envreports_asbestosmaterials_detaileddescriptiontxt_CSS", data.get("detailed_description"));

				// enter the detailed location
				String location_description = RandomStringUtils.randomAlphabetic(8);
				type("envreports_asbestosmaterials_detailedlocationtxt_CSS", location_description);

				// collect all the location description
				location_description_list.add(location_description);

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
				env_score = RandomStringUtils.randomNumeric(2);
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

				int env_score_int = Integer.parseInt(env_score);
				env_totalScore = env_totalScore + env_score_int;

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

		// CREATE NEW CUSTOM FORMS FOR MULTIPLE RECORD TYPE
		title("CREATE NEW CUSTOM FORMS FOR MULTIPLE RECORD TYPE");

		String name = RandomStringUtils.randomAlphabetic(8);
		String fieldName1 = RandomStringUtils.randomAlphabetic(8);
		String fieldName2 = RandomStringUtils.randomAlphabetic(8);
		String pageName1 = RandomStringUtils.randomAlphabetic(8);
		String pageFieldName1 = RandomStringUtils.randomAlphabetic(8);
		String pageFieldName2 = RandomStringUtils.randomAlphabetic(8);
		String customform_score = null;
		String customform_updatescore = null;
		String fieldDetail1 = null;
		String fieldDetail2 = null;
		String pageFieldDetail1 = null;
		String pageFieldDetail2 = null;
		List<String> customform_score_list = new ArrayList<String>();
		List<String> customform_updatescore_list = new ArrayList<String>();
		List<String> fieldDetail1_list = new ArrayList<String>();
		List<String> fieldDetail2_list = new ArrayList<String>();
		List<String> pageFieldDetail1_list = new ArrayList<String>();
		List<String> pageFieldDetail2_list = new ArrayList<String>();
		String[] todayDate = LocalDate.now().toString().split("-");

		int customform_count = random.nextInt(5 - 3) + 3;
		int customform_totalScore = 0;
		int customform_totalUpdateScore = 0;

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
			select("customform_recordtypedd_XPATH", data.get("type_2"));

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
					verificationFailedMessage("The Report Name detail is not displayed.");
				}

			} catch (Throwable t) {
				verificationFailedMessage("The Report Name detail is not displayed.");
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

			// wait for the element
			Thread.sleep(5000);

			// click on the add button
			click("customform_addfield_addbtn_XPATH");

			// scroll down the screen
			scrollBottom();

			// wait for the element
			Thread.sleep(5000);

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

			// wait for the element
			Thread.sleep(5000);

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

			// wait for the element
			Thread.sleep(5000);

			// click on the add button
			click("customform_addfield_addbtn_XPATH");

			// wait for the element
			explicitWaitClickable("closetoastmsg_CSS");

			// click on the toaster close button
			click("closetoastmsg_CSS");

			// wait for the element
			Thread.sleep(5000);

			// scrolldown to bottom
			scrollBottom();

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

			// ADD NEW PAGES IN THE CUSTOM FORM
			title("ADD NEW PAGES IN THE CUSTOM FORM");

			// click on the add new page icon
			click("customform_portfoliodashboard_addnewpagebtn_XPATH");

			// enter the first page name name in the page name field
			type("customform_portfoliodashboard_pagenametxt_XPATH", pageName1);

			// wait for the element
			Thread.sleep(5000);

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

			// wait for the element
			Thread.sleep(5000);

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

			// wait for the element
			Thread.sleep(5000);

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

			// wait for the element
			Thread.sleep(5000);

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

			// wait for the element
			Thread.sleep(5000);

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

		// ADD THE DETAILS IN THE FIELDS ON RANDOMLY FROM THE PROPERTY SUMMARY DASHBOARD
		// OF PROPERTY ONE
		title("ADD THE DETAILS IN THE FIELDS ON RANDOMLY FROM THE PROPERTY SUMMARY DASHBOARD OF PROPERTY ONE");

		try {

			// enter the property name in the search field
			type("ohs_incidentreport_searchtxt_XPATH", data.get("property_1"));

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

			// wait for the element
			Thread.sleep(5000);

			consoleMessage("The details in fields will entered " + customform_count + " times.");

			// enter details in the fields on random number
			for (int i = 0; i < customform_count; i++) {

				// click on the add button
				click("customform_portfoliodashboard_addbtn_XPATH");

				// wait for the element
				Thread.sleep(5000);

				// scroll to bottom
				scrollBottom();

				// enter the details in the first field
				fieldDetail1 = RandomStringUtils.randomAlphabetic(8);
				String firstField = "//input[@id='" + fieldName1 + "TEXT']";
				driver.findElement(By.xpath(firstField)).sendKeys(fieldDetail1);
				consoleMessage("Entered the details in the first field.");

				// collect the random details of the first field
				fieldDetail1_list.add(fieldDetail1);
				consoleMessage("New count of data of the field 1 : " + fieldDetail1_list.size());

				// enter the details in the second field
				fieldDetail2 = RandomStringUtils.randomNumeric(3);
				String secondField = "//input[@id='" + fieldName2 + "NUMBER']";
				driver.findElement(By.xpath(secondField)).sendKeys(fieldDetail2);
				consoleMessage("Entered the details in the second field.");

				// collect the random details of the second field
				fieldDetail2_list.add(fieldDetail2);
				consoleMessage("New count of data of the field 2 : " + fieldDetail2_list.size());

				// click on the page one tab
				String page1 = "//span[text()='" + pageName1 + "']";
				driver.findElement(By.xpath(page1)).click();
				consoleMessage("Clicked on the page one tab.");

				// enter the details in the first field
				pageFieldDetail1 = RandomStringUtils.randomAlphabetic(8);
				String pageFirstField = "//input[@id='" + pageFieldName1 + "TEXT']";
				driver.findElement(By.xpath(pageFirstField)).sendKeys(pageFieldDetail1);
				consoleMessage("Entered the details in the first field.");

				// collect the random details of the first field
				pageFieldDetail1_list.add(pageFieldDetail1);
				consoleMessage("New count of data of the field 1 of page one : " + pageFieldDetail1_list.size());

				// enter the details in the second field
				pageFieldDetail2 = RandomStringUtils.randomNumeric(3);
				String pageSecondField = "//input[@id='" + pageFieldName2 + "NUMBER']";
				driver.findElement(By.xpath(pageSecondField)).sendKeys(pageFieldDetail2);
				consoleMessage("Entered the details in the second field.");

				// collect the random details of the second field
				pageFieldDetail2_list.add(pageFieldDetail2);
				consoleMessage("New count of data of the field 2 of page one : " + pageFieldDetail2_list.size());

				// click on the save button
				click("customform_portfoliodashboard_fields_savebtn_XPATH");

				// scrolldown to bottom
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

				// validate the details of the first field of page one
				try {
					String thirdField1 = "//span[contains(text(),'" + pageFieldDetail1 + "')]";
					String thirdField1_actual = (driver.findElement(By.xpath(thirdField1)).getText()).trim();

					if (thirdField1_actual.equals(pageFieldDetail1)) {
						successMessage("The details of the first field of page one is displayed successfully.");
					} else {
						verificationFailedMessage("The details of the first field of page one is not displayed.");
					}
				} catch (Throwable t) {
					verificationFailedMessage("The details of the first field of page one is not displayed.");
				}

				// validate the details of the second field of page one
				try {
					String fourthField2 = "//span[contains(text(),'" + pageFieldDetail2 + "')]";
					String fourthField2_actual = (driver.findElement(By.xpath(fourthField2)).getText()).trim();

					if (fourthField2_actual.equals(pageFieldDetail2)) {
						successMessage("The details of the second field of page one is displayed successfully.");
					} else {
						verificationFailedMessage("The details of the second field of page one is not displayed.");
					}
				} catch (Throwable t) {
					verificationFailedMessage("The details of the second field of page one is not displayed.");
				}

				// click on the newly created details of the custom form
				String record = "//span[text()='" + fieldDetail1 + "']";
				driver.findElement(By.xpath(record)).click();
				consoleMessage("Clicked on the newly created details of the custom form.");

				// ADD THE DETAILS IN THE FIELDS OF THE RISK SCORING TAB
				title("ADD THE DETAILS IN THE FIELDS OF THE RISK SCORING TAB");

				// click on the action
				click("customform_portfoliodashboard_actionicon_XPATH");

				// click on the risk score option
				click("customform_portfoliodashboard_riskscoreoption_XPATH");

				// select on the risk category option
				select("customform_riskcategorydd_XPATH", data.get("score_category"));

				// enter the score in the score field
				customform_score = RandomStringUtils.randomNumeric(2);
				type("customform_scoretxt_XPATH", customform_score);

				// collect the random details of the risk score
				customform_score_list.add(customform_score);
				consoleMessage("New count of data of the risk score : " + customform_score_list.size());

				// select the option from the status dropdown
				select("customform_statusdd_XPATH", data.get("risk_status"));

				// enter the text in description field
				type("customform_descriptiontxt_XPATH", data.get("details"));

				// click on the update button
				click("customform_portfoliodashboard_riskscoringupdatebtn_XPATH");

				// click on the action
				click("customform_portfoliodashboard_actionicon_XPATH");

				// click on the form details option
				click("customform_portfoliodashboard_formdetailsoption_XPATH");

				// click on the record list button
				click("customform_propertysummary_recordlistbtn_XPATH");

				int customform_score_int = Integer.parseInt(customform_score);
				customform_totalScore = customform_totalScore + customform_score_int;

			}

			consoleMessage("End of for loop and The total number of count is " + pageFieldDetail1_list.size());

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

			// validate the risk score of the property
			try {
				String Score = "//td[text()='" + name + "']//following-sibling::td[@class='ng-binding']";
				String riskScore = (driver.findElement(By.xpath(Score)).getText()).trim();
				int riskScore_actual = Integer.parseInt(riskScore);

				if (riskScore_actual == customform_totalScore) {
					successMessage("The risk score of the property is displayed correctly.");
				} else {
					verificationFailedMessage("The risk score of the property is not displayed correctly.");
				}
			} catch (Throwable t) {
				verificationFailedMessage("The risk score of the property is not displayed correctly.");
			}

			// validate the risk score of the environmental records of the property
			try {
				String Score2 = "//td[text()='Asbestos Materials']//following-sibling::td[@class='ng-binding']";
				String riskScore = (driver.findElement(By.xpath(Score2)).getText()).trim();
				int riskScore_actual = Integer.parseInt(riskScore);

				if (riskScore_actual == env_totalScore) {
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

				if (riskScore_actual == customform_totalScore) {
					successMessage("The risk score of the property is displayed correctly.");
				} else {
					verificationFailedMessage("The risk score of the property is not displayed correctly.");
				}
			} catch (Throwable t) {
				verificationFailedMessage("The risk score of the property is not displayed correctly.");
			}

			// validate the risk score of the environmental records of the property
			try {
				String Score2 = "//td[text()='Asbestos Materials']//following-sibling::td[@class='ng-binding']";
				String riskScore = (driver.findElement(By.xpath(Score2)).getText()).trim();
				int riskScore_actual = Integer.parseInt(riskScore);

				if (riskScore_actual == env_totalScore) {
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

		// UPDATE THE RANDOM NUMBERS OF NEW RECORD OF THE ENVIRONMENTAL RECORD WITH THE
		// RISK SCORE
		title("UPDATE THE RANDOM NUMBERS OF NEW RECORD OF THE ENVIRONMENTAL RECORD WITH THE RISK SCORE");

		int env_totalUpdateScore = 0;

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

			for (int i = 0; i < location_description_list.size(); i++) {

				// click on the environmental record of property one
				String envrecord1 = "//span[text()='" + location_description_list.get(i) + "']";
				driver.findElement(By.xpath(envrecord1)).click();
				consoleMessage("Clicked on the newly created environmental record.");

				// click on the risk scoring tab
				click("envreports_asbestosmaterials_riskscoringtab_XPATH");

				// select on the risk category option
				select("envreports_asbestosmaterials_riskcategorydd_XPATH", data.get("score_category_update"));

				// enter the score in the score field
				String env_updatescore = RandomStringUtils.randomNumeric(2);
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

				int env_updatescore_int = Integer.parseInt(env_updatescore);
				env_totalUpdateScore = env_totalUpdateScore + env_updatescore_int;

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

		// UPDATE THE RISK SCORE DETAILS OF THE RANDOMLY CREATED CUSTOM FORM FROM THE
		// PORTFOLIO SUMMARY DASHBOARD FOR PROPERTY ONE
		title("UPDATE THE DETAILS OF THE FIELDS AND PAGES RANDOMLY FROM THE PORTFOLIO SUMMARY DASHBOARD FOR PROPERTY ONE");

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

			// scroll down to bottom
			scrollBottom();

			consoleMessage("While Update, The details in fields will entered " + customform_count + " times.");

			for (int k = 1; k <= customform_count; k++) {

				// wait for the element
				Thread.sleep(3000);

				// click on the property one
				String ele1 = "(//td[text()='[DND] AAAA Risk Test Prop 01'])[" + k + "]";
				driver.findElement(By.xpath(ele1)).click();
				consoleMessage("click on the property one i.e. " + k);

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
				customform_updatescore = RandomStringUtils.randomNumeric(2);
				type("customform_scoretxt_XPATH", customform_updatescore);

				// collect the random details of the risk score
				customform_updatescore_list.add(customform_updatescore);
				consoleMessage("New count of data of the risk score : " + customform_updatescore_list.size());

				// select the option from the status dropdown
				select("customform_statusdd_XPATH", data.get("risk_status_update"));

				// enter the text in description field
				type("customform_descriptiontxt_XPATH", data.get("details"));

				// click on the update button
				click("customform_portfoliodashboard_riskscoringupdatebtn_XPATH");

				int customform_updatescore_int = Integer.parseInt(customform_updatescore);
				customform_totalUpdateScore = customform_totalUpdateScore + customform_updatescore_int;

				if (customform_count > k) {

					// click on the back button
					click("customform_propertydashboard_backbtn_XPATH");
				}
			}

			consoleMessage("While Update, End of for loop and The total number of count is "
					+ customform_updatescore_list.size());

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

			// validate the updated risk score of the property
			try {
				String Score = "//td[text()='" + name + "']//following-sibling::td[@class='ng-binding']";
				String riskScore = (driver.findElement(By.xpath(Score)).getText()).trim();
				int riskScore_actual = Integer.parseInt(riskScore);

				if (riskScore_actual == customform_totalUpdateScore) {
					successMessage("The updated risk score of the property is displayed correctly.");
				} else {
					verificationFailedMessage("The updated risk score of the property is not displayed correctly.");
				}
			} catch (Throwable t) {
				verificationFailedMessage("The updated risk score of the property is not displayed correctly.");
			}

			// validate the updated risk score of the environmental records of the property
			try {
				String Score2 = "//td[text()='Asbestos Materials']//following-sibling::td[@class='ng-binding']";
				String riskScore = (driver.findElement(By.xpath(Score2)).getText()).trim();
				int riskScore_actual = Integer.parseInt(riskScore);

				if (riskScore_actual == env_totalUpdateScore) {
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

			// click on the graph of the risk card
			click("customform_portfoliodashboard_riskscoringcard_graph_XPATH");

			// select the current year in the year dropdown
			select("customform_portfoliodashboard_riskscoringcard_yeardd_XPATH", todayDate[0]);

			// select the current year in the month dropdown
			String month = todayDate[1].replaceFirst("^0+(?!$)", "");
			select("customform_portfoliodashboard_riskscoringcard_monthdd_XPATH", month);

			// scroll down to bottom
			scrollBottom();

			// validate the updated risk score of the property
			try {
				String Score = "//td[text()='" + name + "']//following-sibling::td[@class='ng-binding']";
				String riskScore = (driver.findElement(By.xpath(Score)).getText()).trim();
				int riskScore_actual = Integer.parseInt(riskScore);

				if (riskScore_actual == customform_totalUpdateScore) {
					successMessage("The updated risk score of the property is displayed correctly.");
				} else {
					verificationFailedMessage("The updated risk score of the property is not displayed correctly.");
				}
			} catch (Throwable t) {
				verificationFailedMessage("The updated risk score of the property is not displayed correctly.");
			}

			// validate the updated risk score of the environmental records of the property
			try {
				String Score2 = "//td[text()='Asbestos Materials']//following-sibling::td[@class='ng-binding']";
				String riskScore = (driver.findElement(By.xpath(Score2)).getText()).trim();
				int riskScore_actual = Integer.parseInt(riskScore);

				if (riskScore_actual == env_totalUpdateScore) {
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
