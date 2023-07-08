package testcases.E2Etestcasesuite.customformmodule;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Hashtable;
import java.util.List;
import java.util.Random;

import org.apache.commons.lang3.RandomStringUtils;
import org.openqa.selenium.By;
import org.testng.annotations.Test;

import base.TestBase;
import utilities.TestUtil;

public class RR6555CustomForm4Test extends TestBase {

	@Test(dataProviderClass = TestUtil.class, dataProvider = "dp")
	public void rR6555CustomForm4Test(Hashtable<String, String> data) throws IOException, InterruptedException {

		execution(data, "rR6555CustomForm4Test");

		// VERIFY THE RISK SCORE OF THE RANDOMLY CREATED MULTIPLE TYPE'S CUSTOM FORMS ON
		// THE PORTFOLIO DASHBOARD AND PROPERTY SUMMARY DASHBOARD WITH MULTIPLE
		// PROPERTIES.
		title("VERIFY THE RISK SCORE OF THE RANDOMLY CREATED MULTIPLE TYPE'S CUSTOM FORMS ON THE PORTFOLIO DASHBOARD AND PROPERTY SUMMARY DASHBOARD WITH MULTIPLE PROPERTIES.");

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
		String score1 = null;
		String score2 = null;
		String score3 = null;
		String updatescore1 = null;
		String updatescore3 = null;
		String fieldDetail11 = null;
		String fieldDetail12 = null;
		String fieldDetail21 = null;
		String fieldDetail22 = null;
		String fieldDetail31 = null;
		String fieldDetail32 = null;
		String pageFieldDetail11 = null;
		String pageFieldDetail12 = null;
		String pageFieldDetail21 = null;
		String pageFieldDetail22 = null;
		String pageFieldDetail31 = null;
		String pageFieldDetail32 = null;
		List<String> score1_list = new ArrayList<String>();
		List<String> score2_list = new ArrayList<String>();
		List<String> score3_list = new ArrayList<String>();
		List<String> updatescore1_list = new ArrayList<String>();
		List<String> updatescore3_list = new ArrayList<String>();
		List<String> fieldDetail11_list = new ArrayList<String>();
		List<String> fieldDetail12_list = new ArrayList<String>();
		List<String> fieldDetail21_list = new ArrayList<String>();
		List<String> fieldDetail22_list = new ArrayList<String>();
		List<String> fieldDetail31_list = new ArrayList<String>();
		List<String> fieldDetail32_list = new ArrayList<String>();
		List<String> pageFieldDetail11_list = new ArrayList<String>();
		List<String> pageFieldDetail12_list = new ArrayList<String>();
		List<String> pageFieldDetail21_list = new ArrayList<String>();
		List<String> pageFieldDetail22_list = new ArrayList<String>();
		List<String> pageFieldDetail31_list = new ArrayList<String>();
		List<String> pageFieldDetail32_list = new ArrayList<String>();

		Random random = new Random();
		int count1 = random.nextInt(5 - 3) + 3;
		int count2 = random.nextInt(5 - 3) + 3;
		int count3 = random.nextInt(5 - 3) + 3;
		int totalScore1 = 0;
		int totalScore2 = 0;
		int totalScore3 = 0;
		int totalUpdateScore1 = 0;
		int totalUpdateScore3 = 0;

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

			consoleMessage("The details in fields will entered " + count1 + " times.");

			// enter details in the fields on random number
			for (int i = 0; i < count1; i++) {

				// click on the add button
				click("customform_portfoliodashboard_addbtn_XPATH");

				// wait for the element
				Thread.sleep(5000);

				// scroll to bottom
				scrollBottom();

				// enter the details in the first field
				fieldDetail11 = RandomStringUtils.randomAlphabetic(8);
				String firstField = "//input[@id='" + fieldName1 + "TEXT']";
				driver.findElement(By.xpath(firstField)).sendKeys(fieldDetail11);
				consoleMessage("Entered the details in the first field.");

				// collect the random details of the first field
				fieldDetail11_list.add(fieldDetail11);
				consoleMessage("New count of data of the field 1 : " + fieldDetail11_list.size());

				// enter the details in the second field
				fieldDetail12 = RandomStringUtils.randomNumeric(3);
				String secondField = "//input[@id='" + fieldName2 + "NUMBER']";
				driver.findElement(By.xpath(secondField)).sendKeys(fieldDetail12);
				consoleMessage("Entered the details in the second field.");

				// collect the random details of the second field
				fieldDetail12_list.add(fieldDetail12);
				consoleMessage("New count of data of the field 2 : " + fieldDetail12_list.size());

				// click on the page one tab
				String page1 = "//span[text()='" + pageName1 + "']";
				driver.findElement(By.xpath(page1)).click();
				consoleMessage("Clicked on the page one tab.");

				// enter the details in the first field
				pageFieldDetail11 = RandomStringUtils.randomAlphabetic(8);
				String pageFirstField = "//input[@id='" + pageFieldName1 + "TEXT']";
				driver.findElement(By.xpath(pageFirstField)).sendKeys(pageFieldDetail11);
				consoleMessage("Entered the details in the first field.");

				// collect the random details of the first field
				pageFieldDetail11_list.add(pageFieldDetail11);
				consoleMessage("New count of data of the field 1 of page one : " + pageFieldDetail11_list.size());

				// enter the details in the second field
				pageFieldDetail12 = RandomStringUtils.randomNumeric(3);
				String pageSecondField = "//input[@id='" + pageFieldName2 + "NUMBER']";
				driver.findElement(By.xpath(pageSecondField)).sendKeys(pageFieldDetail12);
				consoleMessage("Entered the details in the second field.");

				// collect the random details of the second field
				pageFieldDetail12_list.add(pageFieldDetail12);
				consoleMessage("New count of data of the field 2 of page one : " + pageFieldDetail12_list.size());

				// click on the save button
				click("customform_portfoliodashboard_fields_savebtn_XPATH");

				// scrolldown to bottom
				scrollBottom();

				// wait for the element
				Thread.sleep(5000);

				// validate the details of the first field
				try {
					String firstField1 = "//span[contains(text(),'" + fieldDetail11 + "')]";
					String firstField1_actual = (driver.findElement(By.xpath(firstField1)).getText()).trim();

					if (firstField1_actual.equals(fieldDetail11)) {
						successMessage("The details of the first field is displayed successfully.");
					} else {
						verificationFailedMessage("The details of the first field is not displayed.");
					}
				} catch (Throwable t) {
					verificationFailedMessage("The details of the first field is not displayed.");
				}

				// validate the details of the second field
				try {
					String secondField1 = "//span[contains(text(),'" + fieldDetail12 + "')]";
					String secondField1_actual = (driver.findElement(By.xpath(secondField1)).getText()).trim();

					if (secondField1_actual.equals(fieldDetail12)) {
						successMessage("The details of the second field is displayed successfully.");
					} else {
						verificationFailedMessage("The details of the second field is not displayed.");
					}
				} catch (Throwable t) {
					verificationFailedMessage("The details of the second field is not displayed.");
				}

				// validate the details of the first field of page one
				try {
					String thirdField1 = "//span[contains(text(),'" + pageFieldDetail11 + "')]";
					String thirdField1_actual = (driver.findElement(By.xpath(thirdField1)).getText()).trim();

					if (thirdField1_actual.equals(pageFieldDetail11)) {
						successMessage("The details of the first field of page one is displayed successfully.");
					} else {
						verificationFailedMessage("The details of the first field of page one is not displayed.");
					}
				} catch (Throwable t) {
					verificationFailedMessage("The details of the first field of page one is not displayed.");
				}

				// validate the details of the second field of page one
				try {
					String fourthField2 = "//span[contains(text(),'" + pageFieldDetail12 + "')]";
					String fourthField2_actual = (driver.findElement(By.xpath(fourthField2)).getText()).trim();

					if (fourthField2_actual.equals(pageFieldDetail12)) {
						successMessage("The details of the second field of page one is displayed successfully.");
					} else {
						verificationFailedMessage("The details of the second field of page one is not displayed.");
					}
				} catch (Throwable t) {
					verificationFailedMessage("The details of the second field of page one is not displayed.");
				}

				// click on the newly created details of the custom form
				String record = "//span[text()='" + fieldDetail11 + "']";
				driver.findElement(By.xpath(record)).click();
				consoleMessage("Clicked on the newly created details of the custom form.");

				// ADD THE DETAILS IN THE FIELDS OF THE RISK SCORING TAB
				title("ADD THE DETAILS IN THE FIELDS OF THE RISK SCORING TAB");

				// click on the risk scoring tab
				click("customform_portfoliodashboard_riskscoringtab_XPATH");

				// select on the risk category option
				select("customform_riskcategorydd_XPATH", data.get("score_category"));

				// enter the score in the score field
				score1 = RandomStringUtils.randomNumeric(2);
				type("customform_scoretxt_XPATH", score1);

				// collect the random details of the risk score
				score1_list.add(score1);
				consoleMessage("New count of data of the risk score : " + score1_list.size());

				// select the option from the status dropdown
				select("customform_statusdd_XPATH", data.get("risk_status"));

				// enter the text in description field
				type("customform_descriptiontxt_XPATH", data.get("details"));

				// click on the update button
				click("customform_portfoliodashboard_riskscoringupdatebtn_XPATH");

				// click on the details tab
				click("customform_propertysummary_detailstab_XPATH");
				
				// click on the record list button
				click("customform_propertysummary_recordlistbtn_XPATH");
				
				int score1_int = Integer.parseInt(score1);
				totalScore1 = totalScore1 + score1_int;

			}

			consoleMessage("End of for loop and The total number of count is " + pageFieldDetail11_list.size());

		} catch (Throwable t) {
			verificationFailed();
		}

		// click on the home icon from the top of the screen
		click("questionnaire_homeburgermenubtn_hide_CSS");

		// wait for the element
		explicitWait("propertylist_title_XPATH");

		// verify the property list
		switchVerification("propertylist_title_XPATH", "Property List", "The property list is not displayed.");

		// ADD THE DETAILS IN THE FIELDS ON RANDOMLY FROM THE PROPERTY SUMMARY DASHBOARD
		// OF PROPERTY TWO
		title("ADD THE DETAILS IN THE FIELDS ON RANDOMLY FROM THE PROPERTY SUMMARY DASHBOARD OF PROPERTY TWO");

		try {

			// enter the property name in the search field
			type("ohs_incidentreport_searchtxt_XPATH", data.get("property_2"));

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

			consoleMessage("The details in fields will entered " + count2 + " times.");

			// enter details in the fields on random number
			for (int i = 0; i < count2; i++) {

				// click on the add button
				click("customform_portfoliodashboard_addbtn_XPATH");

				// wait for the element
				Thread.sleep(5000);

				// scroll to bottom
				scrollBottom();

				// enter the details in the first field
				fieldDetail21 = RandomStringUtils.randomAlphabetic(8);
				String firstField = "//input[@id='" + fieldName1 + "TEXT']";
				driver.findElement(By.xpath(firstField)).sendKeys(fieldDetail21);
				consoleMessage("Entered the details in the first field.");

				// collect the random details of the first field
				fieldDetail21_list.add(fieldDetail21);
				consoleMessage("New count of data of the field 1 : " + fieldDetail21_list.size());

				// enter the details in the second field
				fieldDetail22 = RandomStringUtils.randomNumeric(3);
				String secondField = "//input[@id='" + fieldName2 + "NUMBER']";
				driver.findElement(By.xpath(secondField)).sendKeys(fieldDetail22);
				consoleMessage("Entered the details in the second field.");

				// collect the random details of the second field
				fieldDetail22_list.add(fieldDetail22);
				consoleMessage("New count of data of the field 2 : " + fieldDetail22_list.size());

				// click on the page one tab
				String page1 = "//span[text()='" + pageName1 + "']";
				driver.findElement(By.xpath(page1)).click();
				consoleMessage("Clicked on the page one tab.");

				// enter the details in the first field
				pageFieldDetail21 = RandomStringUtils.randomAlphabetic(8);
				String pageFirstField = "//input[@id='" + pageFieldName1 + "TEXT']";
				driver.findElement(By.xpath(pageFirstField)).sendKeys(pageFieldDetail21);
				consoleMessage("Entered the details in the first field.");

				// collect the random details of the first field
				pageFieldDetail21_list.add(pageFieldDetail21);
				consoleMessage("New count of data of the field 1 of page one : " + pageFieldDetail21_list.size());

				// enter the details in the second field
				pageFieldDetail22 = RandomStringUtils.randomNumeric(3);
				String pageSecondField = "//input[@id='" + pageFieldName2 + "NUMBER']";
				driver.findElement(By.xpath(pageSecondField)).sendKeys(pageFieldDetail22);
				consoleMessage("Entered the details in the second field.");

				// collect the random details of the second field
				pageFieldDetail22_list.add(pageFieldDetail22);
				consoleMessage("New count of data of the field 2 of page one : " + pageFieldDetail22_list.size());

				// click on the save button
				click("customform_portfoliodashboard_fields_savebtn_XPATH");

				// scrolldown to bottom
				scrollBottom();

				// wait for the element
				Thread.sleep(5000);

				// validate the details of the first field
				try {
					String firstField1 = "//span[contains(text(),'" + fieldDetail21 + "')]";
					String firstField1_actual = (driver.findElement(By.xpath(firstField1)).getText()).trim();

					if (firstField1_actual.equals(fieldDetail21)) {
						successMessage("The details of the first field is displayed successfully.");
					} else {
						verificationFailedMessage("The details of the first field is not displayed.");
					}
				} catch (Throwable t) {
					verificationFailedMessage("The details of the first field is not displayed.");
				}

				// validate the details of the second field
				try {
					String secondField1 = "//span[contains(text(),'" + fieldDetail22 + "')]";
					String secondField1_actual = (driver.findElement(By.xpath(secondField1)).getText()).trim();

					if (secondField1_actual.equals(fieldDetail22)) {
						successMessage("The details of the second field is displayed successfully.");
					} else {
						verificationFailedMessage("The details of the second field is not displayed.");
					}
				} catch (Throwable t) {
					verificationFailedMessage("The details of the second field is not displayed.");
				}

				// validate the details of the first field of page one
				try {
					String thirdField1 = "//span[contains(text(),'" + pageFieldDetail21 + "')]";
					String thirdField1_actual = (driver.findElement(By.xpath(thirdField1)).getText()).trim();

					if (thirdField1_actual.equals(pageFieldDetail21)) {
						successMessage("The details of the first field of page one is displayed successfully.");
					} else {
						verificationFailedMessage("The details of the first field of page one is not displayed.");
					}
				} catch (Throwable t) {
					verificationFailedMessage("The details of the first field of page one is not displayed.");
				}

				// validate the details of the second field of page one
				try {
					String fourthField2 = "//span[contains(text(),'" + pageFieldDetail22 + "')]";
					String fourthField2_actual = (driver.findElement(By.xpath(fourthField2)).getText()).trim();

					if (fourthField2_actual.equals(pageFieldDetail22)) {
						successMessage("The details of the second field of page one is displayed successfully.");
					} else {
						verificationFailedMessage("The details of the second field of page one is not displayed.");
					}
				} catch (Throwable t) {
					verificationFailedMessage("The details of the second field of page one is not displayed.");
				}

				// click on the newly created details of the custom form
				String record = "//span[text()='" + fieldDetail21 + "']";
				driver.findElement(By.xpath(record)).click();
				consoleMessage("Clicked on the newly created details of the custom form.");

				// ADD THE DETAILS IN THE FIELDS OF THE RISK SCORING TAB
				title("ADD THE DETAILS IN THE FIELDS OF THE RISK SCORING TAB");

				// click on the risk scoring tab
				click("customform_portfoliodashboard_riskscoringtab_XPATH");

				// select on the risk category option
				select("customform_riskcategorydd_XPATH", data.get("score_category"));

				// enter the score in the score field
				score2 = RandomStringUtils.randomNumeric(2);
				type("customform_scoretxt_XPATH", score2);

				// collect the random details of the risk score
				score2_list.add(score2);
				consoleMessage("New count of data of the risk score : " + score2_list.size());

				// select the option from the status dropdown
				select("customform_statusdd_XPATH", data.get("risk_status"));

				// enter the text in description field
				type("customform_descriptiontxt_XPATH", data.get("details"));

				// click on the update button
				click("customform_portfoliodashboard_riskscoringupdatebtn_XPATH");

				// click on the details tab
				click("customform_propertysummary_detailstab_XPATH");
				
				// click on the record list button
				click("customform_propertysummary_recordlistbtn_XPATH");

				int score2_int = Integer.parseInt(score2);
				totalScore2 = totalScore2 + score2_int;
				
			}

			consoleMessage("End of for loop and The total number of count is " + pageFieldDetail21_list.size());

		} catch (Throwable t) {
			verificationFailed();
		}

		// click on the home icon from the top of the screen
		click("questionnaire_homeburgermenubtn_hide_CSS");

		// wait for the element
		explicitWait("propertylist_title_XPATH");

		// verify the property list
		switchVerification("propertylist_title_XPATH", "Property List", "The property list is not displayed.");

		// ADD THE DETAILS IN THE FIELDS ON RANDOMLY FROM THE PROPERTY SUMMARY DASHBOARD
		// OF PROPERTY THREE
		title("ADD THE DETAILS IN THE FIELDS ON RANDOMLY FROM THE PROPERTY SUMMARY DASHBOARD OF PROPERTY THREE");

		try {

			// enter the property name in the search field
			type("ohs_incidentreport_searchtxt_XPATH", data.get("property_3"));

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

			consoleMessage("The details in fields will entered " + count3 + " times.");

			// enter details in the fields on random number
			for (int i = 0; i < count3; i++) {

				// click on the add button
				click("customform_portfoliodashboard_addbtn_XPATH");

				// wait for the element
				Thread.sleep(5000);

				// scroll to bottom
				scrollBottom();

				// enter the details in the first field
				fieldDetail31 = RandomStringUtils.randomAlphabetic(8);
				String firstField = "//input[@id='" + fieldName1 + "TEXT']";
				driver.findElement(By.xpath(firstField)).sendKeys(fieldDetail31);
				consoleMessage("Entered the details in the first field.");

				// collect the random details of the first field
				fieldDetail31_list.add(fieldDetail31);
				consoleMessage("New count of data of the field 1 : " + fieldDetail31_list.size());

				// enter the details in the second field
				fieldDetail32 = RandomStringUtils.randomNumeric(3);
				String secondField = "//input[@id='" + fieldName2 + "NUMBER']";
				driver.findElement(By.xpath(secondField)).sendKeys(fieldDetail32);
				consoleMessage("Entered the details in the second field.");

				// collect the random details of the second field
				fieldDetail32_list.add(fieldDetail32);
				consoleMessage("New count of data of the field 2 : " + fieldDetail32_list.size());

				// click on the page one tab
				String page1 = "//span[text()='" + pageName1 + "']";
				driver.findElement(By.xpath(page1)).click();
				consoleMessage("Clicked on the page one tab.");

				// enter the details in the first field
				pageFieldDetail31 = RandomStringUtils.randomAlphabetic(8);
				String pageFirstField = "//input[@id='" + pageFieldName1 + "TEXT']";
				driver.findElement(By.xpath(pageFirstField)).sendKeys(pageFieldDetail31);
				consoleMessage("Entered the details in the first field.");

				// collect the random details of the first field
				pageFieldDetail31_list.add(pageFieldDetail31);
				consoleMessage("New count of data of the field 1 of page one : " + pageFieldDetail31_list.size());

				// enter the details in the second field
				pageFieldDetail32 = RandomStringUtils.randomNumeric(3);
				String pageSecondField = "//input[@id='" + pageFieldName2 + "NUMBER']";
				driver.findElement(By.xpath(pageSecondField)).sendKeys(pageFieldDetail32);
				consoleMessage("Entered the details in the second field.");

				// collect the random details of the second field
				pageFieldDetail32_list.add(pageFieldDetail32);
				consoleMessage("New count of data of the field 2 of page one : " + pageFieldDetail32_list.size());

				// click on the save button
				click("customform_portfoliodashboard_fields_savebtn_XPATH");

				// scrolldown to bottom
				scrollBottom();

				// wait for the element
				Thread.sleep(5000);

				// validate the details of the first field
				try {
					String firstField1 = "//span[contains(text(),'" + fieldDetail31 + "')]";
					String firstField1_actual = (driver.findElement(By.xpath(firstField1)).getText()).trim();

					if (firstField1_actual.equals(fieldDetail31)) {
						successMessage("The details of the first field is displayed successfully.");
					} else {
						verificationFailedMessage("The details of the first field is not displayed.");
					}
				} catch (Throwable t) {
					verificationFailedMessage("The details of the first field is not displayed.");
				}

				// validate the details of the second field
				try {
					String secondField1 = "//span[contains(text(),'" + fieldDetail32 + "')]";
					String secondField1_actual = (driver.findElement(By.xpath(secondField1)).getText()).trim();

					if (secondField1_actual.equals(fieldDetail32)) {
						successMessage("The details of the second field is displayed successfully.");
					} else {
						verificationFailedMessage("The details of the second field is not displayed.");
					}
				} catch (Throwable t) {
					verificationFailedMessage("The details of the second field is not displayed.");
				}

				// validate the details of the first field of page one
				try {
					String thirdField1 = "//span[contains(text(),'" + pageFieldDetail31 + "')]";
					String thirdField1_actual = (driver.findElement(By.xpath(thirdField1)).getText()).trim();

					if (thirdField1_actual.equals(pageFieldDetail31)) {
						successMessage("The details of the first field of page one is displayed successfully.");
					} else {
						verificationFailedMessage("The details of the first field of page one is not displayed.");
					}
				} catch (Throwable t) {
					verificationFailedMessage("The details of the first field of page one is not displayed.");
				}

				// validate the details of the second field of page one
				try {
					String fourthField2 = "//span[contains(text(),'" + pageFieldDetail32 + "')]";
					String fourthField2_actual = (driver.findElement(By.xpath(fourthField2)).getText()).trim();

					if (fourthField2_actual.equals(pageFieldDetail32)) {
						successMessage("The details of the second field of page one is displayed successfully.");
					} else {
						verificationFailedMessage("The details of the second field of page one is not displayed.");
					}
				} catch (Throwable t) {
					verificationFailedMessage("The details of the second field of page one is not displayed.");
				}

				// click on the newly created details of the custom form
				String record = "//span[text()='" + fieldDetail31 + "']";
				driver.findElement(By.xpath(record)).click();
				consoleMessage("Clicked on the newly created details of the custom form.");

				// ADD THE DETAILS IN THE FIELDS OF THE RISK SCORING TAB
				title("ADD THE DETAILS IN THE FIELDS OF THE RISK SCORING TAB");

				// click on the risk scoring tab
				click("customform_portfoliodashboard_riskscoringtab_XPATH");

				// select on the risk category option
				select("customform_riskcategorydd_XPATH", data.get("score_category"));

				// enter the score in the score field
				score3 = RandomStringUtils.randomNumeric(2);
				type("customform_scoretxt_XPATH", score3);

				// collect the random details of the risk score
				score3_list.add(score3);
				consoleMessage("New count of data of the risk score : " + score3_list.size());

				// select the option from the status dropdown
				select("customform_statusdd_XPATH", data.get("risk_status"));

				// enter the text in description field
				type("customform_descriptiontxt_XPATH", data.get("details"));

				// click on the update button
				click("customform_portfoliodashboard_riskscoringupdatebtn_XPATH");

				// click on the details tab
				click("customform_propertysummary_detailstab_XPATH");
				
				// click on the record list button
				click("customform_propertysummary_recordlistbtn_XPATH");
				
				int score3_int = Integer.parseInt(score3);
				totalScore3 = totalScore3 + score3_int;

			}

			consoleMessage("End of for loop and The total number of count is " + pageFieldDetail31_list.size());

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

			// validate the average risk score of the all the properties
			try {
				String avgScore = (driver
						.findElement(By.xpath(
								OR.getProperty("customform_portfoliodashboard_riskscoringcard_averagescore_XPATH")))
						.getText()).trim();
				int avgScore_actual = Integer.parseInt(avgScore);
				int totalScore = totalScore1 + totalScore2 + totalScore3;
				String score_string = Integer.toString(totalScore);
				float score_float1 = Float.parseFloat(score_string);
				float score_float2 = score_float1 / 4f;
				int score_expected = Math.round(score_float2);

				if (avgScore_actual == score_expected) {
					successMessage("The average risk score of the all the properties is displayed correctly.");
				} else {
					verificationFailedMessage(
							"The average risk score of the all the properties is not displayed correctly.");
				}
			} catch (Throwable t) {
				verificationFailedMessage(
						"The average risk score of the all the properties is not displayed correctly.");
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

			// validate the risk score of the property
			try {
				String Score = (driver
						.findElement(By.xpath(
								OR.getProperty("customform_propertydashboard_riskscoringcard_averagescore1_XPATH")))
						.getText()).trim();
				int avgScore_actual = Integer.parseInt(Score);

				if (avgScore_actual == totalScore1) {
					successMessage("The risk score for the property is displayed correctly.");
				} else {
					verificationFailedMessage("The risk score for the property is not displayed correctly.");
				}
			} catch (Throwable t) {
				verificationFailedMessage("The risk score for the property is not displayed correctly.");
			}

			// validate the average risk score of the other properties
			try {
				String Score = (driver
						.findElement(By.xpath(
								OR.getProperty("customform_propertydashboard_riskscoringcard_averagescore2_XPATH")))
						.getText()).trim();
				int avgScore_actual = Integer.parseInt(Score);
				String score2_string = Integer.toString(totalScore2);
				float score2_float = Float.parseFloat(score2_string);
				String score3_string = Integer.toString(totalScore3);
				float score3_float = Float.parseFloat(score3_string);
				float score_float1 = score2_float + score3_float;
				float score_float2 = score_float1 / 3f;
				int score_expected = Math.round(score_float2);

				if (avgScore_actual == score_expected) {
					successMessage("The average risk score of the other properties is displayed correctly.");
				} else {
					verificationFailedMessage(
							"The average risk score of the other properties is not displayed correctly.");
				}
			} catch (Throwable t) {
				verificationFailedMessage("The average risk score of the other properties is not displayed correctly.");
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

			consoleMessage("While Update, The details in fields will entered " + count1 + " times.");

			for (int k = 1; k <= count1; k++) {

				// wait for the element
				Thread.sleep(3000);

				// click on the clear button
				click("portfoliodashboard_customform_clearbtn_XPATH");
				
				// enter respective property name
				type("portfoliodashboard_customform_searchtxt_XPATH", data.get("property_1"));
				
				// click on the search button
				click("portfoliodashboard_customform_searchbtn_XPATH");
				
				// click on the property one
				String ele1 = "(//td[text()='[DND] AAAA Risk Test Prop 01'])[" + k + "]";
				driver.findElement(By.xpath(ele1)).click();
				consoleMessage("click on the property one i.e. " + k);

				// UPDATE THE DETAILS OF THE RISK SCORING TAB
				title("UPDATE THE DETAILS OF THE RISK SCORING TAB");

				// click on the risk scoring tab
				click("customform_portfoliodashboard_riskscoringtab_XPATH");

				// scroll to bottom
				scrollBottom();

				// select on the risk category option
				select("customform_riskcategorydd_XPATH", data.get("score_category_update"));

				// enter the score in the score field
				updatescore1 = RandomStringUtils.randomNumeric(2);
				type("customform_scoretxt_XPATH", updatescore1);

				// collect the random details of the risk score
				updatescore1_list.add(updatescore1);
				consoleMessage("New count of data of the risk score : " + updatescore1_list.size());

				// select the option from the status dropdown
				select("customform_statusdd_XPATH", data.get("risk_status_update"));

				// enter the text in description field
				type("customform_descriptiontxt_XPATH", data.get("details"));

				// click on the update button
				click("customform_portfoliodashboard_riskscoringupdatebtn_XPATH");

				int updatescore1_int = Integer.parseInt(updatescore1);
				totalUpdateScore1 = totalUpdateScore1 + updatescore1_int;

				if (count1 > k) {

					// click on the back button
					click("customform_propertydashboard_backbtn_XPATH");
				}
			}

			consoleMessage(
					"While Update, End of for loop and The total number of count is " + updatescore1_list.size());

		} catch (Throwable t) {
			verificationFailed();
		}

		// click on the home icon from the top of the screen
		click("questionnaire_homeburgermenubtn_hide_CSS");

		// wait for the element
		explicitWait("propertylist_title_XPATH");

		// verify the property list
		switchVerification("propertylist_title_XPATH", "Property List", "The property list is not displayed.");

		// NOT UPDATED PROPERTY TWO DETAILS PURPOSELY

		// UPDATE THE RISK SCORE DETAILS OF THE RANDOMLY CREATED CUSTOM FORM FROM THE
		// PORTFOLIO SUMMARY DASHBOARD FOR PROPERTY THREE
		title("UPDATE THE DETAILS OF THE FIELDS AND PAGES RANDOMLY FROM THE PORTFOLIO SUMMARY DASHBOARD FOR PROPERTY THREE");

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

			consoleMessage("While Update, The details in fields will entered " + count3 + " times.");

			for (int l = 1; l <= count3; l++) {

				// wait for the element
				Thread.sleep(3000);

				// click on the clear button
				click("portfoliodashboard_customform_clearbtn_XPATH");
				
				// enter respective property name
				type("portfoliodashboard_customform_searchtxt_XPATH", data.get("property_3"));
				
				// click on the search button
				click("portfoliodashboard_customform_searchbtn_XPATH");
				
				// click on the property three
				String ele1 = "(//td[text()='[DND] AAAA Risk Test Prop 03'])[" + l + "]";
				driver.findElement(By.xpath(ele1)).click();
				consoleMessage("click on the property three i.e. " + l);

				// UPDATE THE DETAILS OF THE RISK SCORING TAB
				title("UPDATE THE DETAILS OF THE RISK SCORING TAB");

				// click on the risk scoring tab
				click("customform_portfoliodashboard_riskscoringtab_XPATH");

				// scroll to bottom
				scrollBottom();

				// select on the risk category option
				select("customform_riskcategorydd_XPATH", data.get("score_category_update"));

				// enter the score in the score field
				updatescore3 = RandomStringUtils.randomNumeric(2);
				type("customform_scoretxt_XPATH", updatescore3);

				// collect the random details of the risk score
				updatescore3_list.add(updatescore3);
				consoleMessage("New count of data of the risk score : " + updatescore3_list.size());

				// select the option from the status dropdown
				select("customform_statusdd_XPATH", data.get("risk_status_update"));

				// enter the text in description field
				type("customform_descriptiontxt_XPATH", data.get("details"));

				// click on the update button
				click("customform_portfoliodashboard_riskscoringupdatebtn_XPATH");

				int updatescore3_int = Integer.parseInt(updatescore3);
				totalUpdateScore3 = totalUpdateScore3 + updatescore3_int;

				if (count3 > l) {

					// click on the back button
					click("customform_propertydashboard_backbtn_XPATH");
				}
			}

			consoleMessage(
					"While Update, End of for loop and The total number of count is " + updatescore3_list.size());

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

			// validate the average risk score of the all the properties
			try {
				String avgScore = (driver
						.findElement(By.xpath(
								OR.getProperty("customform_portfoliodashboard_riskscoringcard_averagescore_XPATH")))
						.getText()).trim();
				int avgScore_actual = Integer.parseInt(avgScore);
				int totalUpdateScore = totalUpdateScore1 + totalScore2 + totalUpdateScore3;
				String totalUpdateScore_string = Integer.toString(totalUpdateScore);
				float updatescore_float1 = Float.parseFloat(totalUpdateScore_string);
				float updatescore_float2 = updatescore_float1 / 4f;
				int updatescore_expected = Math.round(updatescore_float2);

				if (avgScore_actual == updatescore_expected) {
					successMessage("The updated average risk score of the all the properties is displayed correctly.");
				} else {
					verificationFailedMessage(
							"The updated average risk score of the all the properties is not displayed correctly.");
				}
			} catch (Throwable t) {
				verificationFailedMessage(
						"The updated average risk score of the all the properties is not displayed correctly.");
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

			// validate the risk score of the property
			try {
				String updateScore = (driver
						.findElement(By.xpath(
								OR.getProperty("customform_propertydashboard_riskscoringcard_averagescore1_XPATH")))
						.getText()).trim();
				int avgScore_actual = Integer.parseInt(updateScore);

				if (avgScore_actual == totalUpdateScore1) {
					successMessage("The updated risk score for the property is displayed correctly.");
				} else {
					verificationFailedMessage("The updated risk score for the property is not displayed correctly.");
				}
			} catch (Throwable t) {
				verificationFailedMessage("The updated risk score for the property is not displayed correctly.");
			}

			// validate the average risk score of the other properties
			try {
				String updateScore = (driver
						.findElement(By.xpath(
								OR.getProperty("customform_propertydashboard_riskscoringcard_averagescore2_XPATH")))
						.getText()).trim();
				int avgScore_actual = Integer.parseInt(updateScore);
				String score2_string = Integer.toString(totalScore2);
				float score2_float = Float.parseFloat(score2_string);
				String updatescore3_string = Integer.toString(totalUpdateScore3);
				float updatescore3_float = Float.parseFloat(updatescore3_string);
				float updatescore_float1 = score2_float + updatescore3_float;
				float updatescore_float2 = updatescore_float1 / 3f;
				int updatescore_expected = Math.round(updatescore_float2);

				if (avgScore_actual == updatescore_expected) {
					successMessage("The updated average risk score of the other properties is displayed correctly.");
				} else {
					verificationFailedMessage(
							"The updated average risk score of the other properties is not displayed correctly.");
				}
			} catch (Throwable t) {
				verificationFailedMessage(
						"The updated average risk score of the other properties is not displayed correctly.");
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

			// validate the average risk score of the all the properties
			try {
				String avgScore = (driver
						.findElement(By.xpath(
								OR.getProperty("customform_portfoliodashboard_riskscoringcard_averagescore_XPATH")))
						.getText()).trim();
				int avgScore_actual = Integer.parseInt(avgScore);
				int updatescore_expected = 0;

				if (avgScore_actual == updatescore_expected) {
					successMessage("The updated average risk score of the all the properties is displayed correctly.");
				} else {
					verificationFailedMessage(
							"The updated average risk score of the all the properties is not displayed correctly.");
				}
			} catch (Throwable t) {
				verificationFailedMessage(
						"The updated average risk score of the all the properties is not displayed correctly.");
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

			// validate the risk score of the property
			try {
				String updateScore = (driver
						.findElement(By.xpath(
								OR.getProperty("customform_propertydashboard_riskscoringcard_averagescore1_XPATH")))
						.getText()).trim();
				int avgScore_actual = Integer.parseInt(updateScore);
				int updatescore_expected = 0;

				if (avgScore_actual == updatescore_expected) {
					successMessage("The updated risk score for the property is displayed correctly.");
				} else {
					verificationFailedMessage("The updated risk score for the property is not displayed correctly.");
				}
			} catch (Throwable t) {
				verificationFailedMessage("The updated risk score for the property is not displayed correctly.");
			}

			// validate the average risk score of the other properties
			try {
				String updateScore = (driver
						.findElement(By.xpath(
								OR.getProperty("customform_propertydashboard_riskscoringcard_averagescore2_XPATH")))
						.getText()).trim();
				int avgScore_actual = Integer.parseInt(updateScore);
				int updatescore_expected = 0;

				if (avgScore_actual == updatescore_expected) {
					successMessage("The updated average risk score of the other properties is displayed correctly.");
				} else {
					verificationFailedMessage(
							"The updated average risk score of the other properties is not displayed correctly.");
				}
			} catch (Throwable t) {
				verificationFailedMessage(
						"The updated average risk score of the other properties is not displayed correctly.");
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
