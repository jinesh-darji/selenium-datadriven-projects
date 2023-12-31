package testcases.E2Etestcasesuite.customformmodule;

import java.io.File;
import java.io.IOException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Hashtable;
import java.util.List;
import java.util.Random;

import org.apache.commons.lang3.RandomStringUtils;
import org.openqa.selenium.By;
import org.testng.annotations.Test;

import base.TestBase;
import utilities.ExcelReader;
import utilities.TestUtil;

public class RR6555CustomForm10Test extends TestBase {

	@Test(dataProviderClass = TestUtil.class, dataProvider = "dp")
	public void rR6555CustomForm10Test(Hashtable<String, String> data) throws IOException, InterruptedException {

		execution(data, "rR6555CustomForm10Test");

		// VERIFY THE IMPORT/EXPORT FEATURE OF THE RISK SCORE OF THE RANDOMLY CREATED
		// MULTIPLE TYPE'S CUSTOM FORMS ON THE PROPERTY SUMMARY DASHBOARD WITH A SINGLE
		// PROPERTY.
		title("VERIFY THE IMPORT/EXPORT FEATURE OF THE RISK SCORE OF THE RANDOMLY CREATED MULTIPLE TYPE'S CUSTOM FORMS ON THE PROPERTY SUMMARY DASHBOARD WITH A SINGLE PROPERTY.");

		// refresh the page
		driver.navigate().refresh();
		Thread.sleep(5000);
		driver.navigate().refresh();

		String name = RandomStringUtils.randomAlphabetic(8);
		String fieldName1 = RandomStringUtils.randomAlphabetic(8);
		String fieldName2 = RandomStringUtils.randomAlphabetic(8);
		String pageName1 = RandomStringUtils.randomAlphabetic(8);
		String pageFieldName1 = RandomStringUtils.randomAlphabetic(8);
		String pageFieldName2 = RandomStringUtils.randomAlphabetic(8);
		String score = null;
		String field1Detail = null;
		String field2Detail = null;
		String pageField1Detail = null;
		String pageField2Detail = null;
		List<String> score_list = new ArrayList<String>();
		List<String> updatescore_list = new ArrayList<String>();
		List<String> field1Detail_list = new ArrayList<String>();
		List<String> field2Detail_list = new ArrayList<String>();
		List<String> pageField1Detail_list = new ArrayList<String>();
		List<String> pageField2Detail_list = new ArrayList<String>();
		String[] todayDate = LocalDate.now().toString().split("-");

		Random random = new Random();
		int count = random.nextInt(5 - 3) + 3;
		int totalScore = 0;
		int totalUpdateScore = 0;

		// CREATE NEW CUSTOM FORMS FOR MULTIPLE RECORD TYPE
		title("CREATE NEW CUSTOM FORMS FOR MULTIPLE RECORD TYPE");

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
		title("ADD THE DETAILS IN THE FIELDS ON RANDOMLY FROM THE PROPERTY SUMMARY DASHBOARD");

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

			// wait for the element
			Thread.sleep(5000);

			consoleMessage("The details in fields will entered " + count + " times.");

			// enter details in the fields on random number
			for (int i = 0; i < count; i++) {

				// click on the add button
				click("customform_portfoliodashboard_addbtn_XPATH");

				// wait for the element
				Thread.sleep(5000);

				// scroll to bottom
				scrollBottom();

				// enter the details in the first field
				field1Detail = RandomStringUtils.randomAlphabetic(8);
				String firstField = "//input[@id='" + fieldName1 + "TEXT']";
				driver.findElement(By.xpath(firstField)).sendKeys(field1Detail);
				consoleMessage("Entered the details in the first field.");

				// collect the random details of the first field
				field1Detail_list.add(field1Detail);
				consoleMessage("New count of data of the field 1 : " + field1Detail_list.size());

				// enter the details in the second field
				field2Detail = RandomStringUtils.randomNumeric(3);
				String secondField = "//input[@id='" + fieldName2 + "NUMBER']";
				driver.findElement(By.xpath(secondField)).sendKeys(field2Detail);
				consoleMessage("Entered the details in the second field.");

				// collect the random details of the second field
				field2Detail_list.add(field2Detail);
				consoleMessage("New count of data of the field 2 : " + field2Detail_list.size());

				// click on the page one tab
				String page1 = "//span[text()='" + pageName1 + "']";
				driver.findElement(By.xpath(page1)).click();
				consoleMessage("Clicked on the page one tab.");

				// enter the details in the first field
				pageField1Detail = RandomStringUtils.randomAlphabetic(8);
				String pageFirstField = "//input[@id='" + pageFieldName1 + "TEXT']";
				driver.findElement(By.xpath(pageFirstField)).sendKeys(pageField1Detail);
				consoleMessage("Entered the details in the first field.");

				// collect the random details of the first field
				pageField1Detail_list.add(pageField1Detail);
				consoleMessage("New count of data of the field 1 of page one : " + pageField1Detail_list.size());

				// enter the details in the second field
				pageField2Detail = RandomStringUtils.randomNumeric(3);
				String pageSecondField = "//input[@id='" + pageFieldName2 + "NUMBER']";
				driver.findElement(By.xpath(pageSecondField)).sendKeys(pageField2Detail);
				consoleMessage("Entered the details in the second field.");

				// collect the random details of the second field
				pageField2Detail_list.add(pageField2Detail);
				consoleMessage("New count of data of the field 2 of page one : " + pageField2Detail_list.size());

				// click on the save button
				click("customform_portfoliodashboard_fields_savebtn_XPATH");

				// scrolldown to bottom
				scrollBottom();

				// wait for the element
				Thread.sleep(5000);

				// validate the details of the first field
				try {
					String firstField1 = "//span[contains(text(),'" + field1Detail + "')]";
					String firstField1_actual = (driver.findElement(By.xpath(firstField1)).getText()).trim();

					if (firstField1_actual.equals(field1Detail)) {
						successMessage("The details of the first field is displayed successfully.");
					} else {
						verificationFailedMessage("The details of the first field is not displayed.");
					}
				} catch (Throwable t) {
					verificationFailedMessage("The details of the first field is not displayed.");
				}

				// validate the details of the second field
				try {
					String secondField1 = "//span[contains(text(),'" + field2Detail + "')]";
					String secondField1_actual = (driver.findElement(By.xpath(secondField1)).getText()).trim();

					if (secondField1_actual.equals(field2Detail)) {
						successMessage("The details of the second field is displayed successfully.");
					} else {
						verificationFailedMessage("The details of the second field is not displayed.");
					}
				} catch (Throwable t) {
					verificationFailedMessage("The details of the second field is not displayed.");
				}

				// validate the details of the first field of page one
				try {
					String thirdField1 = "//span[contains(text(),'" + pageField1Detail + "')]";
					String thirdField1_actual = (driver.findElement(By.xpath(thirdField1)).getText()).trim();

					if (thirdField1_actual.equals(pageField1Detail)) {
						successMessage("The details of the first field of page one is displayed successfully.");
					} else {
						verificationFailedMessage("The details of the first field of page one is not displayed.");
					}
				} catch (Throwable t) {
					verificationFailedMessage("The details of the first field of page one is not displayed.");
				}

				// validate the details of the second field of page one
				try {
					String fourthField2 = "//span[contains(text(),'" + pageField2Detail + "')]";
					String fourthField2_actual = (driver.findElement(By.xpath(fourthField2)).getText()).trim();

					if (fourthField2_actual.equals(pageField2Detail)) {
						successMessage("The details of the second field of page one is displayed successfully.");
					} else {
						verificationFailedMessage("The details of the second field of page one is not displayed.");
					}
				} catch (Throwable t) {
					verificationFailedMessage("The details of the second field of page one is not displayed.");
				}

				// click on the newly created details of the custom form
				String record = "//span[text()='" + field1Detail + "']";
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
				score = RandomStringUtils.randomNumeric(2);
				type("customform_scoretxt_XPATH", score);

				// collect the random details of the risk score
				score_list.add(score);
				consoleMessage("New count of data of the risk score : " + score_list.size());

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

				int score_int = Integer.parseInt(score);
				totalScore = totalScore + score_int;

			}

			consoleMessage("End of for loop and The total number of count is " + pageField1Detail_list.size());

		} catch (Throwable t) {
			verificationFailed();
		}

		// click on the home icon from the top of the screen
		click("questionnaire_homeburgermenubtn_hide_CSS");

		// wait for the element
		explicitWait("propertylist_title_XPATH");

		// verify the property list
		switchVerification("propertylist_title_XPATH", "Property List", "The property list is not displayed.");

		// PERFORM THE IMPORT/EXPORT FEATURE FOR THE NEW ADDED RISK SCORING CARD IN THE
		// PROPERTY SUMMARY DASHBOARD SCREEN
		title("PERFORM THE IMPORT/EXPORT FEATURE FOR THE NEW ADDED RISK SCORING CARD IN THE PROPERTY SUMMARY DASHBOARD SCREEN");

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

			// click on the action icon
			click("envrecord_propertydashboard_riskscoringcard_actionicon_XPATH");

			// click on the export option
			click("envrecord_propertydashboard_riskscoringcard_actionicon_exportoption_XPATH");

			// wait for the element
			Thread.sleep(15000);

			// fetch the record from the download file
			File downloaded = getLastModified(config.getProperty("downloadFilePath"));
			String path_string = downloaded.toString();
			consoleMessage(path_string);

			ExcelReader file = new ExcelReader(path_string);

			for (int j = count + 1; j > 1; j--) {

				// verify the detail of the risk category
				try {
					String riskcategory = file.getCellData("Risk Scores", "Risk Category", j);

					if (riskcategory.equals(data.get("score_category"))) {
						successMessage("The details of the risk category is displayed correctly.");
					} else {
						verificationFailedMessage("The details of the risk category is not displayed correctly.");
					}
				} catch (Throwable t) {
					verificationFailedMessage("The details of the risk category is not displayed correctly.");
				}

				// verify the detail of the risk status
				try {
					String riskstatus = file.getCellData("Risk Scores", "Risk Status", j);

					if (riskstatus.equals(data.get("risk_status"))) {
						successMessage("The details of the risk status is displayed correctly.");
					} else {
						verificationFailedMessage("The details of the risk status is not displayed correctly.");
					}
				} catch (Throwable t) {
					verificationFailedMessage("The details of the risk status is not displayed correctly.");
				}

				// verify the detail of the risk score
				try {
					String riskscore = file.getCellData("Risk Scores", "Risk Score", j);

					if (riskscore.equals(score_list.get(score_list.size() - 1))) {
						successMessage("The details of the risk score is displayed correctly.");
					} else {
						verificationFailedMessage("The details of the risk score is not displayed correctly.");
					}
				} catch (Throwable t) {
					verificationFailedMessage("The details of the risk score is not displayed correctly.");
				}

				// verify the detail of the risk details
				try {
					String riskdetails = file.getCellData("Risk Scores", "Risk Description", j);

					if (riskdetails.equals(data.get("details"))) {
						successMessage("The details of the risk details is displayed correctly.");
					} else {
						verificationFailedMessage("The details of the risk details is not displayed correctly.");
					}
				} catch (Throwable t) {
					verificationFailedMessage("The details of the risk details is not displayed correctly.");
				}

				// add the details of the risk category
				file.setCellData("Risk Scores", "Risk Category", j, data.get("score_category_update"));

				// add the details of the risk status
				file.setCellData("Risk Scores", "Risk Status", j, data.get("risk_status_update"));

				// add the details of the risk score
				String updatescore = RandomStringUtils.randomNumeric(2);
				file.setCellData("Risk Scores", "Risk Status", j, updatescore);

				// collect all the scores
				updatescore_list.add(updatescore);

				int updatescore_int = Integer.parseInt(updatescore);
				totalUpdateScore = totalUpdateScore + updatescore_int;

				// wait for the element
				Thread.sleep(5000);

			}

//			// click on the action icon
//			click("envrecord_propertydashboard_riskscoringcard_actionicon_XPATH");
//
//			// wait for the element
//			Thread.sleep(5000);
//
//			// click on the import option
//			click("envrecord_propertydashboard_riskscoringcard_actionicon_importoption_XPATH");
//
//			// import the file
//			uploadFile(path_string);
//
//			// wait for the element
//			Thread.sleep(10000);
//
//			// click on the action icon
//			click("envrecord_propertydashboard_riskscoringcard_actionicon_XPATH");
//
//			// wait for the element
//			Thread.sleep(5000);
//
//			// click on the import option
//			click("envrecord_propertydashboard_riskscoringcard_actionicon_importoption_XPATH");
//
//			// import the file
//			uploadFile(path_string);
//
//			// wait for the element
//			Thread.sleep(10000);
//
//			// validate the imported risk score of the property
//			try {
//				String Score = (driver
//						.findElement(By.xpath(
//								OR.getProperty("customform_propertydashboard_riskscoringcard_averagescore1_XPATH")))
//						.getText()).trim();
//				int avgScore_actual = Integer.parseInt(Score);
//
//				if (avgScore_actual == totalUpdateScore) {
//					successMessage("The risk score for the property is displayed correctly.");
//				} else {
//					verificationFailedMessage("The risk score for the property is not displayed correctly.");
//				}
//			} catch (Throwable t) {
//				verificationFailedMessage("The risk score for the property is not displayed correctly.");
//			}
//
//			// validate the imported average risk score of the other properties
//			try {
//				String Score = (driver
//						.findElement(By.xpath(
//								OR.getProperty("customform_propertydashboard_riskscoringcard_averagescore2_XPATH")))
//						.getText()).trim();
//				int avgScore_actual = Integer.parseInt(Score);
//				int score_expected = 0;
//
//				if (avgScore_actual == score_expected) {
//					successMessage("The average risk score of the other properties is displayed correctly.");
//				} else {
//					verificationFailedMessage(
//							"The average risk score of the other properties is not displayed correctly.");
//				}
//			} catch (Throwable t) {
//				verificationFailedMessage("The average risk score of the other properties is not displayed correctly.");
//			}

		} catch (Throwable t) {
			verificationFailed();
		}

		// click on the home icon from the top of the screen
		click("questionnaire_homeburgermenubtn_hide_CSS");

		// wait for the element
		explicitWait("propertylist_title_XPATH");

		// verify the property list
		switchVerification("propertylist_title_XPATH", "Property List", "The property list is not displayed.");

//		// VALIDATE THE IMPORTED RISK SCORING CARD IN THE PORTFOLIO DASHBOARD SCREEN
//		title("VALIDATE THE IMPORTED RISK SCORING CARD IN THE PORTFOLIO DASHBOARD SCREEN");
//
//		try {
//
//			// wait for the element
//			Thread.sleep(5000);
//
//			// click on the side menu
//			click("menubtn_CSS");
//
//			// wait for the element
//			Thread.sleep(5000);
//
//			// click on the portfolio dashboard from side menu
//			click("sidemenu_portfoliosummary_XPATH");
//
//			// scrolldown till risk scoring card
//			scrollTillElement("customform_portfoliodashboard_riskscoringcard_XPATH");
//
//			// validate the imported average risk score of the all the properties
//			try {
//				String avgScore = (driver
//						.findElement(By.xpath(
//								OR.getProperty("customform_portfoliodashboard_riskscoringcard_averagescore_XPATH")))
//						.getText()).trim();
//				int avgScore_actual = Integer.parseInt(avgScore);
//				String updatescore_string = Integer.toString(totalUpdateScore);
//				float updatescore_float = Float.parseFloat(updatescore_string);
//				float score_float2 = updatescore_float / 4f;
//				int score_expected = Math.round(score_float2);
//
//				if (avgScore_actual == score_expected) {
//					successMessage("The imported average risk score of the all the properties is displayed correctly.");
//				} else {
//					verificationFailedMessage(
//							"The imported average risk score of the all the properties is not displayed correctly.");
//				}
//			} catch (Throwable t) {
//				verificationFailedMessage(
//						"The imported average risk score of the all the properties is not displayed correctly.");
//			}
//
//		} catch (Throwable t) {
//			verificationFailed();
//		}
//
//		// click on the home icon from the top of the screen
//		click("questionnaire_homeburgermenubtn_hide_CSS");
//
//		// wait for the element
//		explicitWait("propertylist_title_XPATH");
//
//		// verify the property list
//		switchVerification("propertylist_title_XPATH", "Property List", "The property list is not displayed.");
//
//		// VALIDATE THE DETAILS OF THE RISK SCORE OF THE INDIVIDUAL RECORD OF THE CUSTOM
//		// FORM
//		title("VALIDATE THE DETAILS OF THE RISK SCORE OF THE INDIVIDUAL RECORD OF THE CUSTOM FORM");
//
//		try {
//
//			// wait for the element
//			Thread.sleep(5000);
//
//			// click on the property
//			click("propertysummary_property1_XPATH");
//
//			// scrolldown till Property Information section
//			scrollTillElement("customform_portfoliodashboard_propertyinformationtitle_XPATH");
//
//			// validate the newly created custom form in the property summary dashboard
//			// screen
//			try {
//				String customForm1 = "//td[text()='" + name + "']";
//				String customForm1_actual = (driver.findElement(By.xpath(customForm1)).getText()).trim();
//
//				if (customForm1_actual.equals(name)) {
//					successMessage("The newly created custom form is displayed successfully.");
//
//				} else {
//					verificationFailedMessage("The newly created custom form is not displayed.");
//				}
//
//			} catch (Throwable t) {
//				verificationFailedMessage("The newly created custom form is not displayed.");
//			}
//
//			// click on the custom form
//			String customForm1 = "//td[text()='" + name + "']";
//			driver.findElement(By.xpath(customForm1)).click();
//			consoleMessage("Clicked on the custom form.");
//
//			// wait for the element
//			Thread.sleep(5000);
//
//			consoleMessage("The details in fields will entered " + count + " times.");
//
//			// enter details in the fields on random number
//			for (int i = 0; i < count; i++) {
//
//				// click on the newly created details of the custom form
//				String record = "//span[text()='" + field1Detail_list.get(i) + "']";
//				driver.findElement(By.xpath(record)).click();
//				consoleMessage("Clicked on the newly created details of the custom form.");
//
//				// click on the risk scoring tab
//				click("customform_portfoliodashboard_riskscoringtab_XPATH");
//
//				// validate the imported score
//				try {
//					String importedScore = driver.findElement(By.xpath(OR.getProperty("customform_scoretxt_XPATH")))
//							.getAttribute("value");
//
//					if (importedScore.equals(updatescore_list.get(i))) {
//						successMessage("The imported score of the environmental record is displayed successfully.");
//					} else {
//						verificationFailedMessage("The imported score of the environmental record is not displayed.");
//					}
//				} catch (Throwable t) {
//					verificationFailedMessage("The imported score of the environmental record is not displayed.");
//				}
//
//				// click on the update button
//				click("customform_portfoliodashboard_riskscoringupdatebtn_XPATH");
//
//				int score_int = Integer.parseInt(score);
//				totalScore = totalScore + score_int;
//
//				if (count > i) {
//
//					// click on the back button
//					click("customform_propertydashboard_backbtn_XPATH");
//				}
//
//			}
//
//			consoleMessage("End of for loop and The total number of count is " + pageField1Detail_list.size());
//
//		} catch (Throwable t) {
//			verificationFailed();
//		}
//
//		// click on the home icon from the top of the screen
//		click("questionnaire_homeburgermenubtn_hide_CSS");
//
//		// wait for the element
//		explicitWait("propertylist_title_XPATH");
//
//		// verify the property list
//		switchVerification("propertylist_title_XPATH", "Property List", "The property list is not displayed.");

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

			// click on the delete button of the updated custom form
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
							verificationFailedMessage("The risk score of the property is displayed.");
						} else {
							successMessage("The risk score of the property is not displayed as expected.");
						}
					} catch (Throwable t) {
						successMessage("The risk score of the property is not displayed as expected.");
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
					verificationFailedMessage("The risk score of the property is displayed.");

				} else {
					successMessage("The risk score of the property is not displayed as expected.");
				}
			} catch (Throwable t) {
				successMessage("The risk score of the property is not displayed as expected.");
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
