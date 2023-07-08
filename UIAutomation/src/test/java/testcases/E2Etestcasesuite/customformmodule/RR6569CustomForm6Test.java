package testcases.E2Etestcasesuite.customformmodule;

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
import utilities.TestUtil;

public class RR6569CustomForm6Test extends TestBase {

	@Test(dataProviderClass = TestUtil.class, dataProvider = "dp")
	public void rR6569CustomForm6Test(Hashtable<String, String> data) throws IOException, InterruptedException {

		execution(data, "rR6569CustomForm6Test");

		// VERIFY THE LOCKDOWN PREVIOUS PERIOD FEATURE WITH MULTIPLE PROPERTIES AND
		// MULTIPLE CUSTOM FORMS AND DIFFERENT DATES.
		title("VERIFY THE LOCKDOWN PREVIOUS PERIOD FEATURE WITH MULTIPLE PROPERTIES AND MULTIPLE CUSTOM FORMS AND DIFFERENT DATES.");

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
			click("propertysummary_property2_XPATH");

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
			click("propertysummary_property3_XPATH");

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

		// VALIDATE THE EDIT FUNCTIONALITY WITH TODAY'S EFFECTIVE DATE FOR THE LOCK DOWN
		// PRERIOD WITH TODAY, PAST, AND FUTURE DATES ON PORTFOLIO DASHBOARD - PROPERTY
		// ONE
		title("VALIDATE THE EDIT FUNCTIONALITY WITH TODAY'S EFFECTIVE DATE FOR THE LOCK DOWN PRERIOD WITH TODAY, PAST, AND FUTURE DATES ON PORTFOLIO DASHBOARD - PROPERTY ONE");

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

			// enter today's date in effective date field
			LocalDate today = LocalDate.now();
			String today_string = today.toString();
			type("customform_portfoliodashboard_effectivedatetxt_XPATH", today_string);

			// wait for the element
			Thread.sleep(3000);

			// click on the clear button
			click("portfoliodashboard_customform_clearbtn_XPATH");

			// enter the property one name
			type("portfoliodashboard_customform_searchtxt_XPATH", data.get("property_1"));

			// click on the search button
			click("portfoliodashboard_customform_searchbtn_XPATH");

			// click on the action icon
			click("customform_portfoliodashboard_actionicon_XPATH");

			// click on the lock period option
			click("customform_portfoliodashboard_lockperiodoption_XPATH");

			// click on the property one
			click("customform_portfoliodashboard_multiplecustomform_property1name_XPATH");

			// click on the date field
			click("customform_portfoliodashboard_datetxt_XPATH");

			// click on the today button
			click("customform_portfoliodashboard_datetxt_todaybtn_XPATH");

			// wait for the element
			Thread.sleep(3000);

			// scroll down to bottom
			scrollBottom();

			// validate the edit button is displayed or not
			try {
				boolean editbtn1 = driver
						.findElement(By.xpath(OR.getProperty("customform_portfoliodashboard_editfieldbtn_XPATH")))
						.isDisplayed();

				if (editbtn1 == true) {
					successMessage("The edit button is displayed as expected for today's date.");
				} else {
					verificationFailedMessage("The edit button is not displayed for today's date.");
				}
			} catch (Throwable t) {
				verificationFailedMessage("The edit button is not displayed for today's date.");
			}

			// scroll up to top
			scrollTop();

			// click on the date field
			click("customform_portfoliodashboard_datetxt_XPATH");

			// click on the past date
			LocalDate pastdate1 = LocalDate.now().minusDays(1);
			String pastdate1_string = pastdate1.toString();
			String[] pastdate1_date = pastdate1_string.split("-");
			String pastdate1_expected = pastdate1_date[2];
			consoleMessage("pastdate1_expected ::::::::::" + pastdate1_expected);
			String pastdate1_xpath = "// span[@class='ng-binding' and text()='" + pastdate1_expected + "']";
			driver.findElement(By.xpath(pastdate1_xpath)).click();
			consoleMessage("click on the past date.");

			// wait for the element
			Thread.sleep(3000);

			// scroll down to bottom
			scrollBottom();

			// validate the edit button is displayed or not
			try {
				boolean editbtn1 = driver
						.findElement(By.xpath(OR.getProperty("customform_portfoliodashboard_editfieldbtn_XPATH")))
						.isDisplayed();

				if (editbtn1 == true) {
					verificationFailedMessage("The edit button is displayed for past date.");

				} else {
					successMessage("The edit button is not displayed as expected for past date.");
				}
			} catch (Throwable t) {
				successMessage("The edit button is not displayed as expected for past date.");
			}

			// scroll up to top
			scrollTop();

			// click on the date field
			click("customform_portfoliodashboard_datetxt_XPATH");

			// click on the future date
			LocalDate futuredate1 = LocalDate.now().plusDays(1);
			String futuredate1_string = futuredate1.toString();
			String[] futuredate1_date = futuredate1_string.split("-");
			String futuredate1_expected = futuredate1_date[2];
			consoleMessage("futuredate1_expected ::::::::::" + futuredate1_expected);
			String futuredate1_xpath = "// span[@class='ng-binding' and text()='" + futuredate1_expected + "']";
			driver.findElement(By.xpath(futuredate1_xpath)).click();
			consoleMessage("click on the future date.");

			// wait for the element
			Thread.sleep(3000);

			// scroll down to bottom
			scrollBottom();

			// validate the edit button is displayed or not
			try {
				boolean editbtn1 = driver
						.findElement(By.xpath(OR.getProperty("customform_portfoliodashboard_editfieldbtn_XPATH")))
						.isDisplayed();

				if (editbtn1 == true) {
					successMessage("The edit button is displayed as expected for future date.");
				} else {
					verificationFailedMessage("The edit button is not displayed for future date.");
				}
			} catch (Throwable t) {
				verificationFailedMessage("The edit button is not displayed for future date.");
			}

			// scroll up to top
			scrollTop();

			// click on the date field
			click("customform_portfoliodashboard_datetxt_XPATH");

			// click on the previous buttom
			click("customform_portfoliodashboard_datetxt_previousbtn_XPATH");

			// click on the 01 date
			click("customform_portfoliodashboard_datetxt_active01date_XPATH");

			// wait for the element
			Thread.sleep(3000);

			// scroll down to bottom
			scrollBottom();

			// validate the edit button is displayed or not
			try {
				boolean editbtn1 = driver
						.findElement(By.xpath(OR.getProperty("customform_portfoliodashboard_editfieldbtn_XPATH")))
						.isDisplayed();

				if (editbtn1 == true) {
					verificationFailedMessage("The edit button is displayed for past date.");

				} else {
					successMessage("The edit button is not displayed as expected for past date.");
				}
			} catch (Throwable t) {
				successMessage("The edit button is not displayed as expected for past date.");
			}

			// scroll up to top
			scrollTop();

			// click on the date field
			click("customform_portfoliodashboard_datetxt_XPATH");

			// click on the next button
			click("customform_portfoliodashboard_datetxt_nextbtn_XPATH");

			// wait for element
			Thread.sleep(2000);

			// click on the next button
			click("customform_portfoliodashboard_datetxt_nextbtn_XPATH");

			// click on the 28 date
			click("customform_portfoliodashboard_datetxt_active28date_XPATH");

			// wait for the element
			Thread.sleep(3000);

			// scroll down to bottom
			scrollBottom();

			// validate the edit button is displayed or not
			try {
				boolean editbtn1 = driver
						.findElement(By.xpath(OR.getProperty("customform_portfoliodashboard_editfieldbtn_XPATH")))
						.isDisplayed();

				if (editbtn1 == true) {
					successMessage("The edit button is displayed as expected for future date.");
				} else {
					verificationFailedMessage("The edit button is not displayed for future date.");
				}
			} catch (Throwable t) {
				verificationFailedMessage("The edit button is not displayed for future date.");
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

		// VALIDATE THE EDIT FUNCTIONALITY WITH TODAY'S EFFECTIVE DATE FOR THE LOCK DOWN
		// PRERIOD WITH TODAY, PAST, AND FUTURE DATES ON PROPERTY SUMMARY DASHBOARD -
		// PROPERTY ONE
		title("VALIDATE THE EDIT FUNCTIONALITY WITH TODAY'S EFFECTIVE DATE FOR THE LOCK DOWN PRERIOD WITH TODAY, PAST, AND FUTURE DATES ON PROPERTY SUMMARY DASHBOARD - PROPERTY ONE");

		try {

			// wait for the element
			Thread.sleep(5000);

			// click on the property
			click("propertysummary_property1_XPATH");

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

			// click on the first record of the multiple type custom form
			String first_record = "//span[text()='" + fieldDetail11_list.get(0) + "']";
			driver.findElement(By.xpath(first_record)).click();
			consoleMessage("Clicked on the first record of the multiple type custom form.");

			// click on the date field
			click("customform_portfoliodashboard_datetxt_XPATH");

			// click on the today button
			click("customform_portfoliodashboard_datetxt_todaybtn_XPATH");

			// wait for the element
			Thread.sleep(3000);

			// scroll down to bottom
			scrollBottom();

			// validate the edit button is displayed or not
			try {
				boolean editbtn1 = driver
						.findElement(By.xpath(OR.getProperty("customform_portfoliodashboard_editfieldbtn_XPATH")))
						.isDisplayed();

				if (editbtn1 == true) {
					successMessage("The edit button is displayed as expected for today's date.");
				} else {
					verificationFailedMessage("The edit button is not displayed for today's date.");
				}
			} catch (Throwable t) {
				verificationFailedMessage("The edit button is not displayed for today's date.");
			}

			// scroll up to top
			scrollTop();

			// click on the date field
			click("customform_portfoliodashboard_datetxt_XPATH");

			// click on the past date
			LocalDate pastdate1 = LocalDate.now().minusDays(1);
			String pastdate1_string = pastdate1.toString();
			String[] pastdate1_date = pastdate1_string.split("-");
			String pastdate1_expected = pastdate1_date[2];
			consoleMessage("pastdate1_expected ::::::::::" + pastdate1_expected);
			String pastdate1_xpath = "// span[@class='ng-binding' and text()='" + pastdate1_expected + "']";
			driver.findElement(By.xpath(pastdate1_xpath)).click();
			consoleMessage("click on the past date.");

			// wait for the element
			Thread.sleep(3000);

			// scroll down to bottom
			scrollBottom();

			// validate the edit button is displayed or not
			try {
				boolean editbtn1 = driver
						.findElement(By.xpath(OR.getProperty("customform_portfoliodashboard_editfieldbtn_XPATH")))
						.isDisplayed();

				if (editbtn1 == true) {
					verificationFailedMessage("The edit button is displayed for past date.");

				} else {
					successMessage("The edit button is not displayed as expected for past date.");
				}
			} catch (Throwable t) {
				successMessage("The edit button is not displayed as expected for past date.");
			}

			// scroll up to top
			scrollTop();

			// click on the date field
			click("customform_portfoliodashboard_datetxt_XPATH");

			// click on the future date
			LocalDate futuredate1 = LocalDate.now().plusDays(1);
			String futuredate1_string = futuredate1.toString();
			String[] futuredate1_date = futuredate1_string.split("-");
			String futuredate1_expected = futuredate1_date[2];
			consoleMessage("futuredate1_expected ::::::::::" + futuredate1_expected);
			String futuredate1_xpath = "// span[@class='ng-binding' and text()='" + futuredate1_expected + "']";
			driver.findElement(By.xpath(futuredate1_xpath)).click();
			consoleMessage("click on the future date.");

			// wait for the element
			Thread.sleep(3000);

			// scroll down to bottom
			scrollBottom();

			// validate the edit button is displayed or not
			try {
				boolean editbtn1 = driver
						.findElement(By.xpath(OR.getProperty("customform_portfoliodashboard_editfieldbtn_XPATH")))
						.isDisplayed();

				if (editbtn1 == true) {
					successMessage("The edit button is displayed as expected for future date.");
				} else {
					verificationFailedMessage("The edit button is not displayed for future date.");
				}
			} catch (Throwable t) {
				verificationFailedMessage("The edit button is not displayed for future date.");
			}

			// scroll up to top
			scrollTop();

			// click on the date field
			click("customform_portfoliodashboard_datetxt_XPATH");

			// click on the previous buttom
			click("customform_portfoliodashboard_datetxt_previousbtn_XPATH");

			// click on the 01 date
			click("customform_portfoliodashboard_datetxt_active01date_XPATH");

			// wait for the element
			Thread.sleep(3000);

			// scroll down to bottom
			scrollBottom();

			// validate the edit button is displayed or not
			try {
				boolean editbtn1 = driver
						.findElement(By.xpath(OR.getProperty("customform_portfoliodashboard_editfieldbtn_XPATH")))
						.isDisplayed();

				if (editbtn1 == true) {
					verificationFailedMessage("The edit button is displayed for past date.");

				} else {
					successMessage("The edit button is not displayed as expected for past date.");
				}
			} catch (Throwable t) {
				successMessage("The edit button is not displayed as expected for past date.");
			}

			// scroll up to top
			scrollTop();

			// click on the date field
			click("customform_portfoliodashboard_datetxt_XPATH");

			// click on the next button
			click("customform_portfoliodashboard_datetxt_nextbtn_XPATH");

			// wait for the element
			Thread.sleep(2000);

			// click on the next button
			click("customform_portfoliodashboard_datetxt_nextbtn_XPATH");

			// click on the 28 date
			click("customform_portfoliodashboard_datetxt_active28date_XPATH");

			// wait for the element
			Thread.sleep(3000);

			// scroll down to bottom
			scrollBottom();

			// validate the edit button is displayed or not
			try {
				boolean editbtn1 = driver
						.findElement(By.xpath(OR.getProperty("customform_portfoliodashboard_editfieldbtn_XPATH")))
						.isDisplayed();

				if (editbtn1 == true) {
					successMessage("The edit button is displayed as expected for future date.");
				} else {
					verificationFailedMessage("The edit button is not displayed for future date.");
				}
			} catch (Throwable t) {
				verificationFailedMessage("The edit button is not displayed for future date.");
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

		// VALIDATE THE EDIT FUNCTIONALITY WITH PAST EFFECTIVE DATE FOR THE LOCK DOWN
		// PRERIOD WITH TODAY, PAST, AND FUTURE DATES ON PORTFOLIO DASHBOARD - PROPERTY
		// TWO
		title("VALIDATE THE EDIT FUNCTIONALITY WITH PAST EFFECTIVE DATE FOR THE LOCK DOWN PRERIOD WITH TODAY, PAST, AND FUTURE DATES ON PORTFOLIO DASHBOARD - PROPERTY TWO");

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

			// enter past date in effective date field
			LocalDate past = LocalDate.now().minusWeeks(1);
			String past_string = past.toString();
			type("customform_portfoliodashboard_effectivedatetxt_XPATH", past_string);

			// wait for the element
			Thread.sleep(3000);

			// click on the clear button
			click("portfoliodashboard_customform_clearbtn_XPATH");

			// enter the property one name
			type("portfoliodashboard_customform_searchtxt_XPATH", data.get("property_2"));

			// click on the search button
			click("portfoliodashboard_customform_searchbtn_XPATH");

			// validate the property list is displayed or not
			try {
				boolean property = driver
						.findElement(By.xpath(
								OR.getProperty("customform_portfoliodashboard_multiplecustomform_property2name_XPATH")))
						.isDisplayed();

				if (property == true) {

					verificationFailedMessage("The properties are displayed without access.");

				} else {
					successMessage("The properties are displayed as expected.");
				}

			} catch (Throwable t) {
				successMessage("The properties are displayed as expected.");
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

		// VALIDATE THE EDIT FUNCTIONALITY WITH FUTURE EFFECTIVE DATE FOR THE LOCK DOWN
		// PRERIOD WITH TODAY, PAST, AND FUTURE DATES ON PORTFOLIO DASHBOARD - PROPERTY
		// THREE
		title("VALIDATE THE EDIT FUNCTIONALITY WITH FUTURE EFFECTIVE DATE FOR THE LOCK DOWN PRERIOD WITH TODAY, PAST, AND FUTURE DATES ON PORTFOLIO DASHBOARD - PROPERTY THREE");

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

			// enter future date in effective date field
			LocalDate future = LocalDate.now().plusWeeks(1);
			String future_string = future.toString();
			type("customform_portfoliodashboard_effectivedatetxt_XPATH", future_string);

			// click on the action icon
			click("customform_portfoliodashboard_actionicon_XPATH");

			// click on the lock period option
			click("customform_portfoliodashboard_lockperiodoption_XPATH");

			// wait for the element
			Thread.sleep(3000);

			// click on the clear button
			click("portfoliodashboard_customform_clearbtn_XPATH");

			// enter the property one name
			type("portfoliodashboard_customform_searchtxt_XPATH", data.get("property_3"));

			// click on the search button
			click("portfoliodashboard_customform_searchbtn_XPATH");

			// click on the property three
			click("customform_portfoliodashboard_multiplecustomform_property3name_XPATH");

			// click on the date field
			click("customform_portfoliodashboard_datetxt_XPATH");

			// click on the today button
			click("customform_portfoliodashboard_datetxt_todaybtn_XPATH");

			// wait for the element
			Thread.sleep(3000);

			// scroll down to bottom
			scrollBottom();

			// validate the edit button is displayed or not
			try {
				boolean editbtn1 = driver
						.findElement(By.xpath(OR.getProperty("customform_portfoliodashboard_editfieldbtn_XPATH")))
						.isDisplayed();

				if (editbtn1 == true) {
					verificationFailedMessage("The edit button is displayed for today's date.");

				} else {
					successMessage("The edit button is not displayed as expected for today's date.");
				}
			} catch (Throwable t) {
				successMessage("The edit button is not displayed as expected for today's date.");
			}

			// scroll up to top
			scrollTop();

			// click on the date field
			click("customform_portfoliodashboard_datetxt_XPATH");

			// click on the past date
			LocalDate pastdate1 = LocalDate.now().minusDays(1);
			String pastdate1_string = pastdate1.toString();
			String[] pastdate1_date = pastdate1_string.split("-");
			String pastdate1_expected = pastdate1_date[2];
			consoleMessage("pastdate1_expected ::::::::::" + pastdate1_expected);
			String pastdate1_xpath = "// span[@class='ng-binding' and text()='" + pastdate1_expected + "']";
			driver.findElement(By.xpath(pastdate1_xpath)).click();
			consoleMessage("click on the past date.");

			// wait for the element
			Thread.sleep(3000);

			// scroll down to bottom
			scrollBottom();

			// validate the edit button is displayed or not
			try {
				boolean editbtn1 = driver
						.findElement(By.xpath(OR.getProperty("customform_portfoliodashboard_editfieldbtn_XPATH")))
						.isDisplayed();

				if (editbtn1 == true) {
					verificationFailedMessage("The edit button is displayed for past date.");

				} else {
					successMessage("The edit button is not displayed as expected for past date.");
				}
			} catch (Throwable t) {
				successMessage("The edit button is not displayed as expected for past date.");
			}

			// scroll up to top
			scrollTop();

			// click on the date field
			click("customform_portfoliodashboard_datetxt_XPATH");

			// click on the future date
			LocalDate futuredate1 = LocalDate.now().plusDays(1);
			String futuredate1_string = futuredate1.toString();
			String[] futuredate1_date = futuredate1_string.split("-");
			String futuredate1_expected = futuredate1_date[2];
			consoleMessage("futuredate1_expected ::::::::::" + futuredate1_expected);
			String futuredate1_xpath = "// span[@class='ng-binding' and text()='" + futuredate1_expected + "']";
			driver.findElement(By.xpath(futuredate1_xpath)).click();
			consoleMessage("click on the future date.");

			// wait for the element
			Thread.sleep(3000);

			// scroll down to bottom
			scrollBottom();

			// validate the edit button is displayed or not
			try {
				boolean editbtn1 = driver
						.findElement(By.xpath(OR.getProperty("customform_portfoliodashboard_editfieldbtn_XPATH")))
						.isDisplayed();

				if (editbtn1 == true) {
					verificationFailedMessage("The edit button is displayed for future date.");

				} else {
					successMessage("The edit button is not displayed as expected for future date.");
				}
			} catch (Throwable t) {
				successMessage("The edit button is not displayed as expected for future date.");
			}

			// scroll up to top
			scrollTop();

			// click on the date field
			click("customform_portfoliodashboard_datetxt_XPATH");

			// click on the previous buttom
			click("customform_portfoliodashboard_datetxt_previousbtn_XPATH");

			// click on the 01 date
			click("customform_portfoliodashboard_datetxt_active01date_XPATH");

			// wait for the element
			Thread.sleep(3000);

			// scroll down to bottom
			scrollBottom();

			// validate the edit button is displayed or not
			try {
				boolean editbtn1 = driver
						.findElement(By.xpath(OR.getProperty("customform_portfoliodashboard_editfieldbtn_XPATH")))
						.isDisplayed();

				if (editbtn1 == true) {
					verificationFailedMessage("The edit button is displayed for past date.");

				} else {
					successMessage("The edit button is not displayed as expected for past date.");
				}
			} catch (Throwable t) {
				successMessage("The edit button is not displayed as expected for past date.");
			}

			// scroll up to top
			scrollTop();

			// click on the date field
			click("customform_portfoliodashboard_datetxt_XPATH");

			// click on the next button
			click("customform_portfoliodashboard_datetxt_nextbtn_XPATH");

			// wait for the element
			Thread.sleep(2000);

			// click on the next button
			click("customform_portfoliodashboard_datetxt_nextbtn_XPATH");

			// click on the 28 date
			click("customform_portfoliodashboard_datetxt_active28date_XPATH");

			// wait for the element
			Thread.sleep(3000);

			// scroll down to bottom
			scrollBottom();

			// validate the edit button is displayed or not
			try {
				boolean editbtn1 = driver
						.findElement(By.xpath(OR.getProperty("customform_portfoliodashboard_editfieldbtn_XPATH")))
						.isDisplayed();

				if (editbtn1 == true) {
					successMessage("The edit button is displayed as expected for future date.");
				} else {
					verificationFailedMessage("The edit button is not displayed for future date.");
				}
			} catch (Throwable t) {
				verificationFailedMessage("The edit button is not displayed for future date.");
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

		// VALIDATE THE EDIT FUNCTIONALITY WITH FUTURE EFFECTIVE DATE FOR THE LOCK DOWN
		// PRERIOD WITH TODAY, PAST, AND FUTURE DATES ON PROPERTY SUMMARY DASHBOARD
		title("VALIDATE THE EDIT FUNCTIONALITY WITH FUTURE EFFECTIVE DATE FOR THE LOCK DOWN PRERIOD WITH TODAY, PAST, AND FUTURE DATES ON PROPERTY SUMMARY DASHBOARD");

		try {

			// wait for the element
			Thread.sleep(5000);

			// click on the property
			click("propertysummary_property3_XPATH");

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

			// click on the first record of the multiple type custom form
			String first_record = "//span[text()='" + fieldDetail31_list.get(0) + "']";
			driver.findElement(By.xpath(first_record)).click();
			consoleMessage("Clicked on the first record of the multiple type custom form.");

			// click on the date field
			click("customform_portfoliodashboard_datetxt_XPATH");

			// click on the today button
			click("customform_portfoliodashboard_datetxt_todaybtn_XPATH");

			// wait for the element
			Thread.sleep(3000);

			// scroll down to bottom
			scrollBottom();

			// validate the edit button is displayed or not
			try {
				boolean editbtn1 = driver
						.findElement(By.xpath(OR.getProperty("customform_portfoliodashboard_editfieldbtn_XPATH")))
						.isDisplayed();

				if (editbtn1 == true) {
					verificationFailedMessage("The edit button is displayed for today's date.");

				} else {
					successMessage("The edit button is not displayed as expected for today's date.");
				}
			} catch (Throwable t) {
				successMessage("The edit button is not displayed as expected for today's date.");
			}

			// scroll up to top
			scrollTop();

			// click on the date field
			click("customform_portfoliodashboard_datetxt_XPATH");

			// click on the past date
			LocalDate pastdate1 = LocalDate.now().minusDays(1);
			String pastdate1_string = pastdate1.toString();
			String[] pastdate1_date = pastdate1_string.split("-");
			String pastdate1_expected = pastdate1_date[2];
			consoleMessage("pastdate1_expected ::::::::::" + pastdate1_expected);
			String pastdate1_xpath = "// span[@class='ng-binding' and text()='" + pastdate1_expected + "']";
			driver.findElement(By.xpath(pastdate1_xpath)).click();
			consoleMessage("click on the past date.");

			// wait for the element
			Thread.sleep(3000);

			// scroll down to bottom
			scrollBottom();

			// validate the edit button is displayed or not
			try {
				boolean editbtn1 = driver
						.findElement(By.xpath(OR.getProperty("customform_portfoliodashboard_editfieldbtn_XPATH")))
						.isDisplayed();

				if (editbtn1 == true) {
					verificationFailedMessage("The edit button is displayed for past date.");

				} else {
					successMessage("The edit button is not displayed as expected for past date.");
				}
			} catch (Throwable t) {
				successMessage("The edit button is not displayed as expected for past date.");
			}

			// scroll up to top
			scrollTop();

			// click on the date field
			click("customform_portfoliodashboard_datetxt_XPATH");

			// click on the future date
			LocalDate futuredate1 = LocalDate.now().plusDays(1);
			String futuredate1_string = futuredate1.toString();
			String[] futuredate1_date = futuredate1_string.split("-");
			String futuredate1_expected = futuredate1_date[2];
			consoleMessage("futuredate1_expected ::::::::::" + futuredate1_expected);
			String futuredate1_xpath = "// span[@class='ng-binding' and text()='" + futuredate1_expected + "']";
			driver.findElement(By.xpath(futuredate1_xpath)).click();
			consoleMessage("click on the future date.");

			// wait for the element
			Thread.sleep(3000);

			// scroll down to bottom
			scrollBottom();

			// validate the edit button is displayed or not
			try {
				boolean editbtn1 = driver
						.findElement(By.xpath(OR.getProperty("customform_portfoliodashboard_editfieldbtn_XPATH")))
						.isDisplayed();

				if (editbtn1 == true) {
					verificationFailedMessage("The edit button is displayed for future date.");

				} else {
					successMessage("The edit button is not displayed as expected for future date.");
				}
			} catch (Throwable t) {
				successMessage("The edit button is not displayed as expected for future date.");
			}

			// scroll up to top
			scrollTop();

			// click on the date field
			click("customform_portfoliodashboard_datetxt_XPATH");

			// click on the previous buttom
			click("customform_portfoliodashboard_datetxt_previousbtn_XPATH");

			// click on the 01 date
			click("customform_portfoliodashboard_datetxt_active01date_XPATH");

			// wait for the element
			Thread.sleep(3000);

			// scroll down to bottom
			scrollBottom();

			// validate the edit button is displayed or not
			try {
				boolean editbtn1 = driver
						.findElement(By.xpath(OR.getProperty("customform_portfoliodashboard_editfieldbtn_XPATH")))
						.isDisplayed();

				if (editbtn1 == true) {
					verificationFailedMessage("The edit button is displayed for past date.");

				} else {
					successMessage("The edit button is not displayed as expected for past date.");
				}
			} catch (Throwable t) {
				successMessage("The edit button is not displayed as expected for past date.");
			}

			// scroll up to top
			scrollTop();

			// click on the date field
			click("customform_portfoliodashboard_datetxt_XPATH");

			// click on the next button
			click("customform_portfoliodashboard_datetxt_nextbtn_XPATH");

			// wait for the element
			Thread.sleep(2000);

			// click on the next button
			click("customform_portfoliodashboard_datetxt_nextbtn_XPATH");

			// click on the 28 date
			click("customform_portfoliodashboard_datetxt_active28date_XPATH");

			// wait for the element
			Thread.sleep(3000);

			// scroll down to bottom
			scrollBottom();

			// validate the edit button is displayed or not
			try {
				boolean editbtn1 = driver
						.findElement(By.xpath(OR.getProperty("customform_portfoliodashboard_editfieldbtn_XPATH")))
						.isDisplayed();

				if (editbtn1 == true) {
					successMessage("The edit button is displayed as expected for future date.");
				} else {
					verificationFailedMessage("The edit button is not displayed for future date.");
				}
			} catch (Throwable t) {
				verificationFailedMessage("The edit button is not displayed for future date.");
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

	}
}
