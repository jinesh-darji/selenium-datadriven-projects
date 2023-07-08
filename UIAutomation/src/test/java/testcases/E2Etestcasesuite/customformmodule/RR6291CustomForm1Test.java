package testcases.E2Etestcasesuite.customformmodule;

import java.io.IOException;
import java.time.LocalDate;
import java.util.Hashtable;

import org.apache.commons.lang3.RandomStringUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;

import base.TestBase;
import utilities.TestUtil;

public class RR6291CustomForm1Test extends TestBase {

	@Test(dataProviderClass = TestUtil.class, dataProvider = "dp")
	public void rR6291CustomForm1Test(Hashtable<String, String> data) throws IOException, InterruptedException {

		execution(data, "rR6291CustomForm1Test");

		// ADD THE NEW FIELDS AND PAGES IN THE CUSTOM RECORDS AND VALIDATE THEM IN THE
		// PROPERTY SUMMARY DASHBOARD - SINGLE TYPE.
		title("ADD THE NEW FIELDS AND PAGES IN THE CUSTOM RECORDS AND VALIDATE THEM IN THE PROPERTY SUMMARY DASHBOARD - SINGLE TYPE.");

		// refresh the page
		driver.navigate().refresh();
		Thread.sleep(5000);
		driver.navigate().refresh();

		String fieldName1 = RandomStringUtils.randomAlphabetic(8); // Normal Field 1
		String fieldName2 = RandomStringUtils.randomAlphabetic(8); // Normal Field 2
		String updateFieldName1 = RandomStringUtils.randomAlphabetic(8); // Updated Normal Field 1
		String updateFieldName2 = RandomStringUtils.randomAlphabetic(8); // Updated Normal Field 2
		String pageName1 = RandomStringUtils.randomAlphabetic(8); // Page Name 1
		String pageName2 = RandomStringUtils.randomAlphabetic(8); // Page Name 2
		String updatePageName1 = RandomStringUtils.randomAlphabetic(8); // Updated Page Name 1
		String updatePageName2 = RandomStringUtils.randomAlphabetic(8); // Updated Page Name 2
		String pageFieldName1 = RandomStringUtils.randomAlphabetic(8); // Page Name 1 - Field 1
		String pageFieldName2 = RandomStringUtils.randomAlphabetic(8); // Page Name 1 - Field 2
		String pageFieldName3 = RandomStringUtils.randomAlphabetic(8); // Page Name 2 - Field 1
		String pageFieldName4 = RandomStringUtils.randomAlphabetic(8); // Page Name 2 - Field 2
		String updatePageFieldName1 = RandomStringUtils.randomAlphabetic(8); // Update Page Name 1 - Field 1
		String updatePageFieldName2 = RandomStringUtils.randomAlphabetic(8); // Update Page Name 1 - Field 2
		String updatePageFieldName3 = RandomStringUtils.randomAlphabetic(8); // Update Page Name 2 - Field 1
		String updatePageFieldName4 = RandomStringUtils.randomAlphabetic(8); // Update Page Name 2 - Field 2

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
			type("customform_nametxt_XPATH", data.get("name"));

			// select the single report type from the drop down
			select("customform_recordtypedd_XPATH", data.get("type_1"));

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
				String Validation0 = "//td[text()='" + data.get("name") + "']";
				String Validation0_actual = (driver.findElement(By.xpath(Validation0)).getText()).trim();

				if (Validation0_actual.equals(data.get("name"))) {

					successMessage("The Report Name detail is displayed correctly.");

				} else {
					verificationFailedMessage("The Report Name detail is not displayed.");
				}

			} catch (Throwable t) {
				verificationFailedMessage("The Report Name detail is not displayed.");
			}

			// ADD GENERAL FIELDS IN THE CUSTOM FORMS
			title("ADD GENERAL FIELDS IN THE CUSTOM FORMS");

			// click on the newly created custom record record
			String nameTitle = "//td[text()='" + data.get("name") + "']";
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

			// click on the add button
			click("customform_addfield_addbtn_XPATH");

			// wait for the element
			explicitWaitClickable("closetoastmsg_CSS");

			// click on the toaster close button
			click("closetoastmsg_CSS");

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

			// ADD NEW PAGES IN THE CUSTOM FORMS
			title("ADD NEW PAGES IN THE CUSTOM FORMS");

			// click on the add new page icon
			click("customform_portfoliodashboard_addnewpagebtn_XPATH");

			// enter the first page name in the page name field
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

			// enter the second page name in the page name field
			type("customform_portfoliodashboard_pagenametxt_XPATH", pageName2);

			// click on the add button
			click("customform_portfoliodashboard_pagename_addbtn_XPATH");

			// validate the newly added page
			try {
				String page2 = "//span[contains(text(),'" + pageName2 + "')]";
				String page2_actual = (driver.findElement(By.xpath(page2)).getText()).trim();

				if (page2_actual.equals(pageName2)) {
					successMessage("The newly created page is displayed successfully.");
				} else {
					verificationFailedMessage("The newly created page is not displayed.");
				}
			} catch (Throwable t) {
				verificationFailedMessage("The newly created page is not displayed.");
			}

			// ADD FIELDS IN THE PAGE ONE IN THE CUSTOM FORMS
			title("ADD FIELDS IN THE PAGE ONE IN THE CUSTOM FORMS");

			// click on the first page name tab
			String page1 = "//span[contains(text(),'" + pageName1 + "')]";
			driver.findElement(By.xpath(page1)).click();
			consoleMessage("Clicked on the first page name tab.");

			// click on the add field button
			click("customform_addfieldbtn_XPATH");

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

			// wait for the element
			Thread.sleep(5000);

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

			// enter field name
			type("customform_addfield_nametxt_XPATH", pageFieldName2);

			// select the option from the type dropdown
			select("customform_addfield_typedd_XPATH", data.get("fieldtype_2"));

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

			// wait for the element
			Thread.sleep(5000);

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

			// ADD FIELDS IN THE PAGE TWO IN THE CUSTOM FORMS
			title("ADD FIELDS IN THE PAGE TWO IN THE CUSTOM FORMS");

			// click on the second page name tab
			String page2 = "//span[contains(text(),'" + pageName2 + "')]";
			driver.findElement(By.xpath(page2)).click();
			consoleMessage("Clicked on the second page name tab.");

			// click on the add field button
			click("customform_addfieldbtn_XPATH");

			// enter field name
			type("customform_addfield_nametxt_XPATH", pageFieldName3);

			// select the option from the type dropdown
			select("customform_addfield_typedd_XPATH", data.get("fieldtype_1"));

			// click on the add button
			click("customform_addfield_addbtn_XPATH");

			// wait for the element
			explicitWaitClickable("closetoastmsg_CSS");

			// click on the toaster close button
			click("closetoastmsg_CSS");

			// click on the second page name tab
			String page22 = "//span[contains(text(),'" + pageName2 + "')]";
			driver.findElement(By.xpath(page22)).click();
			consoleMessage("Clicked on the second page name tab.");

			// wait for the element
			Thread.sleep(5000);

			// scroll to bottom
			scrollBottom();

			// validate the newly created field
			try {
				String field1 = "//span[text()='" + pageFieldName3 + "']";
				String field1_actual = (driver.findElement(By.xpath(field1)).getText()).trim();

				if (field1_actual.equals(pageFieldName3)) {
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
			type("customform_addfield_nametxt_XPATH", pageFieldName4);

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

			// click on the second page name tab
			String page222 = "//span[contains(text(),'" + pageName2 + "')]";
			driver.findElement(By.xpath(page222)).click();
			consoleMessage("Clicked on the second page name tab.");

			// wait for the element
			Thread.sleep(5000);

			// scroll to bottom
			scrollBottom();

			// validate the newly created field
			try {
				String field2 = "//span[text()='" + pageFieldName4 + "']";
				String field2_actual = (driver.findElement(By.xpath(field2)).getText()).trim();

				if (field2_actual.equals(pageFieldName4)) {
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

		// VALIDATE THE NEWLY CREATED FIELDS AND PAGES OF THE CUSTOM REPORT IN THE
		// PROPERTY SUMMARY DASHBOARD
		title("VALIDATE THE NEWLY CREATED FIELDS AND PAGES OF THE CUSTOM REPORT IN THE PROPERTY SUMMARY DASHBOARD");

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
				String customForm1 = "//td[text()='" + data.get("name") + "']";
				String customForm1_actual = (driver.findElement(By.xpath(customForm1)).getText()).trim();

				if (customForm1_actual.equals(data.get("name"))) {
					successMessage("The newly created custom form is displayed successfully.");

				} else {
					verificationFailedMessage("The newly created custom form is not displayed.");
				}

			} catch (Throwable t) {
				verificationFailedMessage("The newly created custom form is not displayed.");
			}

			// click on the custom form
			String customForm1 = "//td[text()='" + data.get("name") + "']";
			driver.findElement(By.xpath(customForm1)).click();
			consoleMessage("Clicked on the custom form.");

			// scroll to bottom
			scrollBottom();

			// validate the custom form as a title
			try {
				String customName = "//h4[contains(text(),'" + data.get("name") + "')]";
				String customName_actual = (driver.findElement(By.xpath(customName)).getText()).trim();

				if (customName_actual.equals(data.get("name"))) {
					successMessage("The custom form name is displayed correctly.");
				} else {
					verificationFailedMessage("The custom form is not displayed.");
				}
			} catch (Throwable t) {
				verificationFailedMessage("The custom form is not displayed.");
			}

			// validate the first field label
			try {
				String fieldLabel1 = "//label[contains(text(),'" + fieldName1 + "')]";
				String fieldLabel1_actual = (driver.findElement(By.xpath(fieldLabel1)).getText()).trim();

				if (fieldLabel1_actual.equals(fieldName1 + ":")) {
					successMessage("The first field label is displayed successfully.");
				} else {
					verificationFailedMessage("The first field label is not displayed.");
				}
			} catch (Throwable t) {
				verificationFailedMessage("The first field label is not displayed.");
			}

			// validate the second field label
			try {
				String fieldLabel2 = "//label[contains(text(),'" + fieldName2 + "')]";
				String fieldLabel2_actual = (driver.findElement(By.xpath(fieldLabel2)).getText()).trim();

				if (fieldLabel2_actual.equals(fieldName2 + ":")) {
					successMessage("The second field label is displayed successfully.");
				} else {
					verificationFailedMessage("The second field label is not displayed.");
				}
			} catch (Throwable t) {
				verificationFailedMessage("The second field label is not displayed.");
			}

			// click on the first page name tab
			String pageTab1 = "//span[text()='" + pageName1 + "']";
			driver.findElement(By.xpath(pageTab1)).click();
			consoleMessage("Clicked on the first page name tab.");

			// scroll to bottom
			scrollBottom();

			// validate the third field label
			try {
				String fieldLabel3 = "//label[contains(text(),'" + pageFieldName1 + "')]";
				String fieldLabel3_actual = (driver.findElement(By.xpath(fieldLabel3)).getText()).trim();

				if (fieldLabel3_actual.equals(pageFieldName1 + ":")) {
					successMessage("The third field label is displayed successfully.");
				} else {
					verificationFailedMessage("The third field label is not displayed.");
				}
			} catch (Throwable t) {
				verificationFailedMessage("The third field label is not displayed.");
			}

			// validate the forth field label
			try {
				String fieldLabel4 = "//label[contains(text(),'" + pageFieldName2 + "')]";
				String fieldLabel4_actual = (driver.findElement(By.xpath(fieldLabel4)).getText()).trim();

				if (fieldLabel4_actual.equals(pageFieldName2 + ":")) {
					successMessage("The forth field label is displayed successfully.");
				} else {
					verificationFailedMessage("The forth field label is not displayed.");
				}
			} catch (Throwable t) {
				verificationFailedMessage("The forth field label is not displayed.");
			}

			// click on the second page name tab
			String pageTab2 = "//span[text()='" + pageName2 + "']";
			driver.findElement(By.xpath(pageTab2)).click();
			consoleMessage("Clicked on the second page name tab.");

			// scroll to bottom
			scrollBottom();

			// validate the fifth field label
			try {
				String fieldLabel5 = "//label[contains(text(),'" + pageFieldName3 + "')]";
				String fieldLabel5_actual = (driver.findElement(By.xpath(fieldLabel5)).getText()).trim();

				if (fieldLabel5_actual.equals(pageFieldName3 + ":")) {
					successMessage("The fifth field label is displayed successfully.");
				} else {
					verificationFailedMessage("The fifth field label is not displayed.");
				}
			} catch (Throwable t) {
				verificationFailedMessage("The fifth field label is not displayed.");
			}

			// validate the sixth field label
			try {
				String fieldLabel6 = "//label[contains(text(),'" + pageFieldName4 + "')]";
				String fieldLabel6_actual = (driver.findElement(By.xpath(fieldLabel6)).getText()).trim();

				if (fieldLabel6_actual.equals(pageFieldName4 + ":")) {
					successMessage("The sixth field label is displayed successfully.");
				} else {
					verificationFailedMessage("The sixth field label is not displayed.");
				}
			} catch (Throwable t) {
				verificationFailedMessage("The sixth field label is not displayed.");
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

		// ADD THE DETAILS IN THE GENERAL FIELDS AND PAGE'S FIELDS
		title("ADD THE DETAILS IN THE GENERAL FIELDS AND PAGE'S FIELDS");

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
				String customForm1 = "//td[text()='" + data.get("name") + "']";
				String customForm1_actual = (driver.findElement(By.xpath(customForm1)).getText()).trim();

				if (customForm1_actual.equals(data.get("name"))) {
					successMessage("The newly created custom form is displayed successfully.");

				} else {
					verificationFailedMessage("The newly created custom form is not displayed.");
				}

			} catch (Throwable t) {
				verificationFailedMessage("The newly created custom form is not displayed.");
			}

			// click on the custom form
			String customForm1 = "//td[text()='" + data.get("name") + "']";
			driver.findElement(By.xpath(customForm1)).click();
			consoleMessage("Clicked on the custom form.");

			// scroll down to bottom
			scrollTillElement("customform_portfoliodashboard_editfieldbtn_XPATH");

			// click on the edit field button
			click("customform_portfoliodashboard_editfieldbtn_XPATH");

			// enter the details in the first field
			String firstField = "//input[@id='" + fieldName1 + "TEXT']";
			driver.findElement(By.xpath(firstField)).sendKeys(data.get("first_field"));
			consoleMessage("enter the details in the field.");

			// enter the details in the second field
			String secondField = "//input[@id='" + fieldName2 + "NUMBER']";
			driver.findElement(By.xpath(secondField)).sendKeys("123");
			consoleMessage("enter the details in the field.");

			// scroll down to bottom
			scrollBottom();

			// click on the save button
			click("customform_portfoliodashboard_fields_savebtn_XPATH");

			// scrolldown to bottom
			scrollBottom();

			// wait for the element
			Thread.sleep(5000);

			// validate the details of the first field
			try {
				String firstField1 = "//span[contains(text(),'" + data.get("first_field") + "')]";
				String firstField1_actual = (driver.findElement(By.xpath(firstField1)).getText()).trim();

				if (firstField1_actual.equals(data.get("first_field"))) {
					successMessage("The details of the first field is displayed successfully.");
				} else {
					verificationFailedMessage("The details of the first field is not displayed.");
				}
			} catch (Throwable t) {
				verificationFailedMessage("The details of the first field is not displayed.");
			}

			// validate the details of the second field
			try {
				String secondField1 = "//span[contains(text(),'" + "123" + "')]";
				String secondField1_actual = (driver.findElement(By.xpath(secondField1)).getText()).trim();

				if (secondField1_actual.equals("123")) {
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

			// scroll down to bottom
			scrollTillElement("customform_portfoliodashboard_editfieldbtn_XPATH");

			// click on the edit field button
			click("customform_portfoliodashboard_editfieldbtn_XPATH");

			// enter the details in the first field
			String firstPageField = "//input[@id='" + pageFieldName1 + "TEXT']";
			driver.findElement(By.xpath(firstPageField)).sendKeys(data.get("first_page_field1"));
			consoleMessage("enter the details in the field.");

			// enter the details in the second field
			String secondPageField = "//input[@id='" + pageFieldName2 + "NUMBER']";
			driver.findElement(By.xpath(secondPageField)).sendKeys("456");
			consoleMessage("enter the details in the field.");

			// scroll down to bottom
			scrollBottom();

			// click on the save button
			click("customform_portfoliodashboard_fields_savebtn_XPATH");

			// scroll to bottom
			scrollBottom();

			// wait for the element
			Thread.sleep(5000);

			// validate the details of the first field of the first page
			try {
				String firstField1 = "//span[contains(text(),'" + data.get("first_page_field1") + "')]";
				String firstField1_actual = (driver.findElement(By.xpath(firstField1)).getText()).trim();

				if (firstField1_actual.equals(data.get("first_page_field1"))) {
					successMessage("The details of the first field of the first page is displayed successfully.");
				} else {
					verificationFailedMessage("The details of the first field of the first page is not displayed.");
				}
			} catch (Throwable t) {
				verificationFailedMessage("The details of the first field of the first page is not displayed.");
			}

			// validate the details of the second field of the first page
			try {
				String secondField1 = "//span[contains(text(),'" + "456" + "')]";
				String secondField1_actual = (driver.findElement(By.xpath(secondField1)).getText()).trim();

				if (secondField1_actual.equals("456")) {
					successMessage("The details of the second field of the first page is displayed successfully.");
				} else {
					verificationFailedMessage("The details of the second field of the first page is not displayed.");
				}
			} catch (Throwable t) {
				verificationFailedMessage("The details of the second field is of the first page not displayed.");
			}

			// click on the second page name tab
			String pageTab2 = "//span[text()='" + pageName2 + "']";
			driver.findElement(By.xpath(pageTab2)).click();
			consoleMessage("Clicked on the second page name tab.");

			// ADD THE DETAILS IN THE FIELDS OF THE SECOND PAGE TAB
			title("ADD THE DETAILS IN THE FIELDS OF THE SECOND PAGE TAB");

			// scroll down to bottom
			scrollTillElement("customform_portfoliodashboard_editfieldbtn_XPATH");

			// click on the edit field button
			click("customform_portfoliodashboard_editfieldbtn_XPATH");

			// enter the details in the first field
			String thirdPageField = "//input[@id='" + pageFieldName3 + "TEXT']";
			driver.findElement(By.xpath(thirdPageField)).sendKeys(data.get("second_page_field1"));
			consoleMessage("enter the details in the field.");

			// enter the details in the second field
			String fourthPageField = "//input[@id='" + pageFieldName4 + "NUMBER']";
			driver.findElement(By.xpath(fourthPageField)).sendKeys("789");
			consoleMessage("enter the details in the field.");

			// scroll down to bottom
			scrollBottom();

			// click on the save button
			click("customform_portfoliodashboard_fields_savebtn_XPATH");

			// scroll to bottom
			scrollBottom();

			// wait for the element
			Thread.sleep(5000);

			// validate the details of the first field of the second page
			try {
				String firstField1 = "//span[contains(text(),'" + data.get("second_page_field1") + "')]";
				String firstField1_actual = (driver.findElement(By.xpath(firstField1)).getText()).trim();

				if (firstField1_actual.equals(data.get("second_page_field1"))) {
					successMessage("The details of the first field of the second page is displayed successfully.");
				} else {
					verificationFailedMessage("The details of the first field of the second page is not displayed.");
				}
			} catch (Throwable t) {
				verificationFailedMessage("The details of the first field of the second page is not displayed.");
			}

			// validate the details of the second field of the second page
			try {
				String secondField1 = "//span[contains(text(),'" + "789" + "')]";
				String secondField1_actual = (driver.findElement(By.xpath(secondField1)).getText()).trim();

				if (secondField1_actual.equals("789")) {
					successMessage("The details of the second field of the second page is displayed successfully.");
				} else {
					verificationFailedMessage("The details of the second field of the second page is not displayed.");
				}
			} catch (Throwable t) {
				verificationFailedMessage("The details of the second field is of the second page not displayed.");
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

		// UPDATE THE NEWLY CREATED GENERAL FIELDS AND PAGE'S FIELDS OF THE CUSTOM FORMS
		// FOR SINGLE RECORD TYPE
		title("UPDATE THE NEWLY CREATED GENERAL FIELDS AND PAGE'S FIELDS OF THE CUSTOM FORMS FOR SINGLE RECORD TYPE");

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

			// UPDATE THE GENERAL FIELDS IN THE CUSTOM FORMS
			title("UPDATE THE GENERAL FIELDS IN THE CUSTOM FORMS");

			// click on the newly created custom record record
			String nameTitle = "//td[text()='" + data.get("name") + "']";
			driver.findElement(By.xpath(nameTitle)).click();
			consoleMessage("Clicked on the newly created custom record record.");

			// scroll down the screen
			scrollBottom();

			// wait for the element
			Thread.sleep(3000);

			// click on the edit icon of the first field
			String editField1 = "//span[text()='" + fieldName1
					+ "']//following-sibling::span[@class='pull-right']//button[@data-parent='#collapseParent']";
			driver.findElement(By.xpath(editField1)).click();
			consoleMessage("Clicked on the edit icon of the first field.");

			// scroll to bottom of the screen
			scrollBottom();

			// enter field name
			String name1 = "//strong[contains(text(),'1.')]//following-sibling::div[@id='collapse0']//input[@ng-model='item.name']";
			driver.findElement(By.xpath(name1)).clear();
			driver.findElement(By.xpath(name1)).sendKeys(updateFieldName1);
			consoleMessage("Entered field name.");

			// select the option from the type dropdown
			String type1 = "//strong[contains(text(),'1.')]//following-sibling::div[@id='collapse0']//select[@ng-model='item.dataType']";
			WebElement type1_dd = driver.findElement(By.xpath(type1));
			Select dd1 = new Select(type1_dd);
			dd1.selectByVisibleText(data.get("fieldtype_2"));
			consoleMessage("Selected the option from the type dropdown.");

			// scroll down the screen
			scrollByPixel(400);

			// click on the display on list checkbox
			String visibilityckbx1 = "//strong[contains(text(),'1.')]//following-sibling::div[@id='collapse0']//input[@ng-model='item.visibleOnList']";
			driver.findElement(By.xpath(visibilityckbx1)).click();
			consoleMessage("Clicked on the display on list checkbox.");

			// click on the unique identifier checkbox
			String uniqueckbx1 = "//strong[contains(text(),'1.')]//following-sibling::div[@id='collapse0']//input[@ng-model='item.isUniqueId']";
			driver.findElement(By.xpath(uniqueckbx1)).click();
			consoleMessage("Clicked on the unique identifier checkbox.");

			// click on the update button
			click("customform_updatebtn_XPATH");

			// wait for the element
			explicitWaitClickable("closetoastmsg_CSS");

			// click on the toaster close button
			click("closetoastmsg_CSS");

			// validate the updated field
			try {
				String field1 = "//span[text()='" + updateFieldName1 + "']";
				String field1_actual = (driver.findElement(By.xpath(field1)).getText()).trim();

				if (field1_actual.equals(updateFieldName1)) {
					successMessage("The updated field is displayed successfully.");
				} else {
					verificationFailedMessage("The updated field is not displayed.");
				}
			} catch (Throwable t) {
				verificationFailedMessage("The updated field is not displayed.");
			}

			// scroll down the screen
			scrollBottom();

			// wait for the element
			Thread.sleep(3000);

			// click on the edit icon of the second field
			String editField2 = "//span[text()='" + fieldName2
					+ "']//following-sibling::span[@class='pull-right']//button[@data-parent='#collapseParent']";
			driver.findElement(By.xpath(editField2)).click();
			consoleMessage("Clicked on the edit icon of the second field.");

			// scroll down the screen
			scrollBottom();

			// enter field name
			String name2 = "//strong[contains(text(),'2.')]//following-sibling::div[@id='collapse1']//input[@ng-model='item.name']";
			driver.findElement(By.xpath(name2)).clear();
			driver.findElement(By.xpath(name2)).sendKeys(updateFieldName2);
			consoleMessage("Entered field name.");

			// select the option from the type date
			String type2 = "//strong[contains(text(),'2.')]//following-sibling::div[@id='collapse1']//select[@ng-model='item.dataType']";
			WebElement type2_dd = driver.findElement(By.xpath(type2));
			Select dd2 = new Select(type2_dd);
			dd2.selectByVisibleText(data.get("fieldtype_3"));
			consoleMessage("Selected the option from the type date.");

			// scroll down the screen
			scrollByPixel(400);

			// click on the display on list checkbox
			String visibilityckbx2 = "//strong[contains(text(),'2.')]//following-sibling::div[@id='collapse1']//input[@ng-model='item.visibleOnList']";
			driver.findElement(By.xpath(visibilityckbx2)).click();
			consoleMessage("Clicked on the display on list checkbox.");

			// click on the unique identifier checkbox
			String uniqueckbx2 = "//strong[contains(text(),'2.')]//following-sibling::div[@id='collapse1']//input[@ng-model='item.isUniqueId']";
			driver.findElement(By.xpath(uniqueckbx2)).click();
			consoleMessage("Clicked on the unique identifier checkbox.");

			// click on the update button
			click("customform_updatebtn_XPATH");

			// wait for the element
			explicitWaitClickable("closetoastmsg_CSS");

			// click on the toaster close button
			click("closetoastmsg_CSS");

			// validate the updated field
			try {
				String field2 = "//span[text()='" + updateFieldName2 + "']";
				String field2_actual = (driver.findElement(By.xpath(field2)).getText()).trim();

				if (field2_actual.equals(updateFieldName2)) {
					successMessage("The updated field is displayed successfully.");
				} else {
					verificationFailedMessage("The updated field is not displayed.");
				}
			} catch (Throwable t) {
				verificationFailedMessage("The updated field is not displayed.");
			}

			// click on the first page name tab
			String page1 = "//span[contains(text(),'" + pageName1 + "')]";
			driver.findElement(By.xpath(page1)).click();
			consoleMessage("Clicked on the first page name tab.");

			// scroll down the screen
			scrollBottom();

			// wait for the element
			Thread.sleep(3000);

			// click on the edit icon of the first field of page one
			String editPage1Field1 = "//span[text()='" + pageFieldName1
					+ "']//following-sibling::span[@class='pull-right']//button[@data-parent='#collapseParent']";
			driver.findElement(By.xpath(editPage1Field1)).click();
			consoleMessage("Clicked on the edit icon of the first field of page one.");

			// scroll to bottom of the screen
			scrollBottom();

			// enter field name
			String name3 = "//strong[contains(text(),'1.')]//following-sibling::div[@id='collapse0']//input[@ng-model='item.name']";
			driver.findElement(By.xpath(name3)).clear();
			driver.findElement(By.xpath(name3)).sendKeys(updatePageFieldName1);
			consoleMessage("Entered field name.");

			// select the option from the type dropdown
			String type3 = "//strong[contains(text(),'1.')]//following-sibling::div[@id='collapse0']//select[@ng-model='item.dataType']";
			WebElement type3_dd = driver.findElement(By.xpath(type3));
			Select dd3 = new Select(type3_dd);
			dd3.selectByVisibleText(data.get("fieldtype_2"));
			consoleMessage("Selected the option from the type dropdown.");

			// scroll down the screen
			scrollByPixel(400);

			// click on the display on list checkbox
			String visibilityckbx3 = "//strong[contains(text(),'1.')]//following-sibling::div[@id='collapse0']//input[@ng-model='item.visibleOnList']";
			driver.findElement(By.xpath(visibilityckbx3)).click();
			consoleMessage("Clicked on the display on list checkbox.");

			// click on the unique identifier checkbox
			String uniqueckbx3 = "//strong[contains(text(),'1.')]//following-sibling::div[@id='collapse0']//input[@ng-model='item.isUniqueId']";
			driver.findElement(By.xpath(uniqueckbx3)).click();
			consoleMessage("Clicked on the unique identifier checkbox.");

			// click on the update button
			click("customform_updatebtn_XPATH");

			// wait for the element
			explicitWaitClickable("closetoastmsg_CSS");

			// click on the toaster close button
			click("closetoastmsg_CSS");

			// validate the updated field
			try {
				String page1Field1 = "//span[text()='" + updatePageFieldName1 + "']";
				String page1Field1_actual = (driver.findElement(By.xpath(page1Field1)).getText()).trim();

				if (page1Field1_actual.equals(updatePageFieldName1)) {
					successMessage("The updated field is displayed successfully.");
				} else {
					verificationFailedMessage("The updated field is not displayed.");
				}
			} catch (Throwable t) {
				verificationFailedMessage("The updated field is not displayed.");
			}

			// scroll down the screen
			scrollBottom();

			// wait for the element
			Thread.sleep(3000);

			// click on the edit icon of the second field of page one
			String editPage1Field2 = "//span[text()='" + pageFieldName2
					+ "']//following-sibling::span[@class='pull-right']//button[@data-parent='#collapseParent']";
			driver.findElement(By.xpath(editPage1Field2)).click();
			consoleMessage("Clicked on the edit icon of the second field of page one.");

			// scroll down the screen
			scrollBottom();

			// enter field name
			String name4 = "//strong[contains(text(),'2.')]//following-sibling::div[@id='collapse1']//input[@ng-model='item.name']";
			driver.findElement(By.xpath(name4)).clear();
			driver.findElement(By.xpath(name4)).sendKeys(updatePageFieldName2);
			consoleMessage("Entered field name.");

			// select the option from the type dropdown
			String type4 = "//strong[contains(text(),'2.')]//following-sibling::div[@id='collapse1']//select[@ng-model='item.dataType']";
			WebElement type4_dd = driver.findElement(By.xpath(type4));
			Select dd4 = new Select(type4_dd);
			dd4.selectByVisibleText(data.get("fieldtype_3"));
			consoleMessage("Selected the option from the type dropdown.");

			// scroll down the screen
			scrollByPixel(400);

			// click on the display on list checkbox
			String visibilityckbx4 = "//strong[contains(text(),'2.')]//following-sibling::div[@id='collapse1']//input[@ng-model='item.visibleOnList']";
			driver.findElement(By.xpath(visibilityckbx4)).click();
			consoleMessage("Clicked on the display on list checkbox.");

			// click on the unique identifier checkbox
			String uniqueckbx4 = "//strong[contains(text(),'2.')]//following-sibling::div[@id='collapse1']//input[@ng-model='item.isUniqueId']";
			driver.findElement(By.xpath(uniqueckbx4)).click();
			consoleMessage("Clicked on the unique identifier checkbox.");

			// click on the update button
			click("customform_updatebtn_XPATH");

			// wait for the element
			explicitWaitClickable("closetoastmsg_CSS");

			// click on the toaster close button
			click("closetoastmsg_CSS");

			// validate the updated field
			try {
				String page1field2 = "//span[text()='" + updatePageFieldName2 + "']";
				String page1field2_actual = (driver.findElement(By.xpath(page1field2)).getText()).trim();

				if (page1field2_actual.equals(updatePageFieldName2)) {
					successMessage("The updated field is displayed successfully.");
				} else {
					verificationFailedMessage("The updated field is not displayed.");
				}
			} catch (Throwable t) {
				verificationFailedMessage("The updated field is not displayed.");
			}

			// click on the update button
			click("customform_updatebtn_XPATH");

			// wait for the element
			explicitWaitClickable("closetoastmsg_CSS");

			// click on the toaster close button
			click("closetoastmsg_CSS");

			// click on the second page name tab
			String page2 = "//span[contains(text(),'" + pageName2 + "')]";
			driver.findElement(By.xpath(page2)).click();
			consoleMessage("Clicked on the second page name tab.");

			// scroll down the screen
			scrollBottom();

			// wait for the element
			Thread.sleep(3000);

			// click on the edit icon of the first field of page two
			String editPage2Field1 = "//span[text()='" + pageFieldName3
					+ "']//following-sibling::span[@class='pull-right']//button[@data-parent='#collapseParent']";
			driver.findElement(By.xpath(editPage2Field1)).click();
			consoleMessage("Clicked on the edit icon of the first field of page two.");

			// scroll to bottom of the screen
			scrollBottom();

			// enter field name
			String name5 = "//strong[contains(text(),'1.')]//following-sibling::div[@id='collapse0']//input[@ng-model='item.name']";
			driver.findElement(By.xpath(name5)).clear();
			driver.findElement(By.xpath(name5)).sendKeys(updatePageFieldName3);
			consoleMessage("Entered field name.");

			// select the option from the type dropdown
			String type5 = "//strong[contains(text(),'1.')]//following-sibling::div[@id='collapse0']//select[@ng-model='item.dataType']";
			WebElement type5_dd = driver.findElement(By.xpath(type5));
			Select dd5 = new Select(type5_dd);
			dd5.selectByVisibleText(data.get("fieldtype_2"));
			consoleMessage("Selected the option from the type dropdown.");

			// scroll down the screen
			scrollByPixel(400);

			// click on the display on list checkbox
			String visibilityckbx5 = "//strong[contains(text(),'1.')]//following-sibling::div[@id='collapse0']//input[@ng-model='item.visibleOnList']";
			driver.findElement(By.xpath(visibilityckbx5)).click();
			consoleMessage("Clicked on the display on list checkbox.");

			// click on the unique identifier checkbox
			String uniqueckbx5 = "//strong[contains(text(),'1.')]//following-sibling::div[@id='collapse0']//input[@ng-model='item.isUniqueId']";
			driver.findElement(By.xpath(uniqueckbx5)).click();
			consoleMessage("Clicked on the unique identifier checkbox.");

			// click on the update button
			click("customform_updatebtn_XPATH");

			// wait for the element
			explicitWaitClickable("closetoastmsg_CSS");

			// click on the toaster close button
			click("closetoastmsg_CSS");

			// validate the updated field
			try {
				String page2Field1 = "//span[text()='" + updatePageFieldName3 + "']";
				String page2Field1_actual = (driver.findElement(By.xpath(page2Field1)).getText()).trim();

				if (page2Field1_actual.equals(updatePageFieldName3)) {
					successMessage("The updated field is displayed successfully.");
				} else {
					verificationFailedMessage("The updated field is not displayed.");
				}
			} catch (Throwable t) {
				verificationFailedMessage("The updated field is not displayed.");
			}

			// scroll down the screen
			scrollBottom();

			// wait for the element
			Thread.sleep(3000);

			// click on the edit icon of the second field of page two
			String editPage2Field2 = "//span[text()='" + pageFieldName4
					+ "']//following-sibling::span[@class='pull-right']//button[@data-parent='#collapseParent']";
			driver.findElement(By.xpath(editPage2Field2)).click();
			consoleMessage("Clicked on the edit icon of the second field of page two.");

			// scroll to bottom of the screen
			scrollBottom();

			// enter field name
			String name6 = "//strong[contains(text(),'2.')]//following-sibling::div[@id='collapse1']//input[@ng-model='item.name']";
			driver.findElement(By.xpath(name6)).clear();
			driver.findElement(By.xpath(name6)).sendKeys(updatePageFieldName2);
			consoleMessage("Entered field name.");

			// select the option from the type dropdown
			String type6 = "//strong[contains(text(),'2.')]//following-sibling::div[@id='collapse1']//select[@ng-model='item.dataType']";
			WebElement type6_dd = driver.findElement(By.xpath(type6));
			Select dd6 = new Select(type6_dd);
			dd6.selectByVisibleText(data.get("fieldtype_3"));
			consoleMessage("Selected the option from the type dropdown.");

			// scroll down the screen
			scrollByPixel(400);

			// click on the display on list checkbox
			String visibilityckbx6 = "//strong[contains(text(),'2.')]//following-sibling::div[@id='collapse1']//input[@ng-model='item.visibleOnList']";
			driver.findElement(By.xpath(visibilityckbx6)).click();
			consoleMessage("Clicked on the display on list checkbox.");

			// click on the unique identifier checkbox
			String uniqueckbx6 = "//strong[contains(text(),'2.')]//following-sibling::div[@id='collapse1']//input[@ng-model='item.isUniqueId']";
			driver.findElement(By.xpath(uniqueckbx6)).click();
			consoleMessage("Clicked on the unique identifier checkbox.");

			// click on the update button
			click("customform_updatebtn_XPATH");

			// wait for the element
			explicitWaitClickable("closetoastmsg_CSS");

			// click on the toaster close button
			click("closetoastmsg_CSS");

			// validate the updated field
			try {
				String page2field2 = "//span[text()='" + updatePageFieldName4 + "']";
				String page2field2_actual = (driver.findElement(By.xpath(page2field2)).getText()).trim();

				if (page2field2_actual.equals(updatePageFieldName4)) {
					successMessage("The updated field is displayed successfully.");
				} else {
					verificationFailedMessage("The updated field is not displayed.");
				}
			} catch (Throwable t) {
				verificationFailedMessage("The updated field is not displayed.");
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

		// VALIDATE THE UPDATED FIELDS AND PAGES OF THE CUSTOM REPORT IN THE
		// PROPERTY SUMMARY DASHBOARD
		title("VALIDATE THE UPDATED FIELDS AND PAGES OF THE CUSTOM REPORT IN THE PROPERTY SUMMARY DASHBOARD");

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
				String customForm1 = "//td[text()='" + data.get("name") + "']";
				String customForm1_actual = (driver.findElement(By.xpath(customForm1)).getText()).trim();

				if (customForm1_actual.equals(data.get("name"))) {
					successMessage("The newly created custom form is displayed successfully.");

				} else {
					verificationFailedMessage("The newly created custom form is not displayed.");
				}

			} catch (Throwable t) {
				verificationFailedMessage("The newly created custom form is not displayed.");
			}

			// click on the custom form
			String customForm1 = "//td[text()='" + data.get("name") + "']";
			driver.findElement(By.xpath(customForm1)).click();
			consoleMessage("Clicked on the custom form.");

			// scroll to bottom
			scrollBottom();

			// validate the custom form as a title
			try {
				String customName = "//h4[contains(text(),'" + data.get("name") + "')]";
				String customName_actual = (driver.findElement(By.xpath(customName)).getText()).trim();

				if (customName_actual.equals(data.get("name"))) {
					successMessage("The custom form name is displayed correctly.");
				} else {
					verificationFailedMessage("The custom form is not displayed.");
				}
			} catch (Throwable t) {
				verificationFailedMessage("The custom form is not displayed.");
			}

			// validate the first field label
			try {
				String fieldLabel1 = "//label[contains(text(),'" + updateFieldName1 + "')]";
				String fieldLabel1_actual = (driver.findElement(By.xpath(fieldLabel1)).getText()).trim();

				if (fieldLabel1_actual.equals(updateFieldName1 + ":")) {
					successMessage("The first field label is displayed successfully.");
				} else {
					verificationFailedMessage("The first field label is not displayed.");
				}
			} catch (Throwable t) {
				verificationFailedMessage("The first field label is not displayed.");
			}

			// validate the second field label
			try {
				String fieldLabel2 = "//label[contains(text(),'" + updateFieldName2 + "')]";
				String fieldLabel2_actual = (driver.findElement(By.xpath(fieldLabel2)).getText()).trim();

				if (fieldLabel2_actual.equals(updateFieldName2 + ":")) {
					successMessage("The second field label is displayed successfully.");
				} else {
					verificationFailedMessage("The second field label is not displayed.");
				}
			} catch (Throwable t) {
				verificationFailedMessage("The second field label is not displayed.");
			}

			// click on the first page name tab
			String pageTab1 = "//span[text()='" + pageName1 + "']";
			driver.findElement(By.xpath(pageTab1)).click();
			consoleMessage("Clicked on the first page name tab.");

			// scroll to bottom
			scrollBottom();

			// validate the third field label
			try {
				String fieldLabel3 = "//label[contains(text(),'" + updatePageFieldName1 + "')]";
				String fieldLabel3_actual = (driver.findElement(By.xpath(fieldLabel3)).getText()).trim();

				if (fieldLabel3_actual.equals(updatePageFieldName1 + ":")) {
					successMessage("The third field label is displayed successfully.");
				} else {
					verificationFailedMessage("The third field label is not displayed.");
				}
			} catch (Throwable t) {
				verificationFailedMessage("The third field label is not displayed.");
			}

			// validate the forth field label
			try {
				String fieldLabel4 = "//label[contains(text(),'" + updatePageFieldName2 + "')]";
				String fieldLabel4_actual = (driver.findElement(By.xpath(fieldLabel4)).getText()).trim();

				if (fieldLabel4_actual.equals(updatePageFieldName2 + ":")) {
					successMessage("The forth field label is displayed successfully.");
				} else {
					verificationFailedMessage("The forth field label is not displayed.");
				}
			} catch (Throwable t) {
				verificationFailedMessage("The forth field label is not displayed.");
			}

			// click on the second page name tab
			String pageTab2 = "//span[text()='" + pageName2 + "']";
			driver.findElement(By.xpath(pageTab2)).click();
			consoleMessage("Clicked on the second page name tab.");

			// scroll to bottom
			scrollBottom();

			// validate the fifth field label
			try {
				String fieldLabel5 = "//label[contains(text(),'" + updatePageFieldName3 + "')]";
				String fieldLabel5_actual = (driver.findElement(By.xpath(fieldLabel5)).getText()).trim();

				if (fieldLabel5_actual.equals(updatePageFieldName3 + ":")) {
					successMessage("The fifth field label is displayed successfully.");
				} else {
					verificationFailedMessage("The fifth field label is not displayed.");
				}
			} catch (Throwable t) {
				verificationFailedMessage("The fifth field label is not displayed.");
			}

			// validate the sixth field label
			try {
				String fieldLabel6 = "//label[contains(text(),'" + updatePageFieldName4 + "')]";
				String fieldLabel6_actual = (driver.findElement(By.xpath(fieldLabel6)).getText()).trim();

				if (fieldLabel6_actual.equals(updatePageFieldName4 + ":")) {
					successMessage("The sixth field label is displayed successfully.");
				} else {
					verificationFailedMessage("The sixth field label is not displayed.");
				}
			} catch (Throwable t) {
				verificationFailedMessage("The sixth field label is not displayed.");
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

		// ADD THE DETAILS IN THE UPDATED GENERAL FIELDS AND PAGE'S FIELDS
		title("ADD THE DETAILS IN THE UPDATED GENERAL FIELDS AND PAGE'S FIELDS");

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
				String customForm1 = "//td[text()='" + data.get("name") + "']";
				String customForm1_actual = (driver.findElement(By.xpath(customForm1)).getText()).trim();

				if (customForm1_actual.equals(data.get("name"))) {
					successMessage("The newly created custom form is displayed successfully.");

				} else {
					verificationFailedMessage("The newly created custom form is not displayed.");
				}

			} catch (Throwable t) {
				verificationFailedMessage("The newly created custom form is not displayed.");
			}

			// click on the custom form
			String customForm1 = "//td[text()='" + data.get("name") + "']";
			driver.findElement(By.xpath(customForm1)).click();
			consoleMessage("Clicked on the custom form.");

			// scroll down to bottom
			scrollTillElement("customform_portfoliodashboard_editfieldbtn_XPATH");

			// click on the edit field button
			click("customform_portfoliodashboard_editfieldbtn_XPATH");

			// enter the details in the first field
			String firstField = "//input[@id='" + updateFieldName1 + "NUMBER']";
			driver.findElement(By.xpath(firstField)).sendKeys("111");
			consoleMessage("enter the details in the field.");

			// enter the details in the second field
			String secondField = "//input[@id='" + updateFieldName2 + "DATE']";
			driver.findElement(By.xpath(secondField)).click();
			consoleMessage("enter the details in the field.");

			// click on the today button
			click("customform_portfoliodashboard_todaybtn_XPATH");

			// scroll down to bottom
			scrollBottom();

			// click on the save button
			click("customform_portfoliodashboard_fields_savebtn_XPATH");

			// scrolldown to bottom
			scrollBottom();

			// wait for the element
			Thread.sleep(5000);

			// validate the details of the first field
			try {
				String firstField1 = "//span[contains(text(),'" + "111" + "')]";
				String firstField1_actual = (driver.findElement(By.xpath(firstField1)).getText()).trim();

				if (firstField1_actual.equals("111")) {
					successMessage("The details of the first field is displayed successfully.");
				} else {
					verificationFailedMessage("The details of the first field is not displayed.");
				}
			} catch (Throwable t) {
				verificationFailedMessage("The details of the first field is not displayed.");
			}

			// validate the details of the second field
			try {
				LocalDate today = LocalDate.now();
				String today_string = today.toString();

				String secondField1 = "//span[contains(text(),'" + today_string + "')]";
				String secondField1_actual = (driver.findElement(By.xpath(secondField1)).getText()).trim();

				if (secondField1_actual.equals(today_string)) {
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

			// scroll down to bottom
			scrollTillElement("customform_portfoliodashboard_editfieldbtn_XPATH");

			// click on the edit field button
			click("customform_portfoliodashboard_editfieldbtn_XPATH");

			// enter the details in the first field
			String firstPage1Field = "//input[@id='" + updatePageFieldName1 + "NUMBER']";
			driver.findElement(By.xpath(firstPage1Field)).sendKeys("222");
			consoleMessage("enter the details in the field.");

			// enter the details in the second field
			String secondPage1Field = "//input[@id='" + updatePageFieldName2 + "DATE']";
			driver.findElement(By.xpath(secondPage1Field)).click();
			consoleMessage("enter the details in the field.");

			// click on the today button
			click("customform_portfoliodashboard_todaybtn_XPATH");

			// scroll down to bottom
			scrollBottom();

			// click on the save button
			click("customform_portfoliodashboard_fields_savebtn_XPATH");

			// scroll to bottom
			scrollBottom();

			// wait for the element
			Thread.sleep(5000);

			// validate the details of the first field of the first page
			try {
				String firstPageField1 = "//span[contains(text(),'" + "222" + "')]";
				String firstPageField1_actual = (driver.findElement(By.xpath(firstPageField1)).getText()).trim();

				if (firstPageField1_actual.equals("222")) {
					successMessage("The details of the first field of the first page is displayed successfully.");
				} else {
					verificationFailedMessage("The details of the first field of the first page is not displayed.");
				}
			} catch (Throwable t) {
				verificationFailedMessage("The details of the first field of the first page is not displayed.");
			}

			// validate the details of the second field of the first page
			try {
				LocalDate today = LocalDate.now();
				String today_string = today.toString();

				String secondPageField1 = "//span[contains(text(),'" + today_string + "')]";
				String secondPageField1_actual = (driver.findElement(By.xpath(secondPageField1)).getText()).trim();

				if (secondPageField1_actual.equals(today_string)) {
					successMessage("The details of the second field of the first page is displayed successfully.");
				} else {
					verificationFailedMessage("The details of the second field of the first page is not displayed.");
				}
			} catch (Throwable t) {
				verificationFailedMessage("The details of the second field is of the first page not displayed.");
			}

			// click on the second page name tab
			String pageTab2 = "//span[text()='" + pageName2 + "']";
			driver.findElement(By.xpath(pageTab2)).click();
			consoleMessage("Clicked on the second page name tab.");

			// ADD THE DETAILS IN THE FIELDS OF THE SECOND PAGE TAB
			title("ADD THE DETAILS IN THE FIELDS OF THE SECOND PAGE TAB");

			// scroll down to bottom
			scrollTillElement("customform_portfoliodashboard_editfieldbtn_XPATH");

			// click on the edit field button
			click("customform_portfoliodashboard_editfieldbtn_XPATH");

			// enter the details in the first field
			String firstPage2Field = "//input[@id='" + updatePageFieldName3 + "NUMBER']";
			driver.findElement(By.xpath(firstPage2Field)).sendKeys("333");
			consoleMessage("enter the details in the field.");

			// enter the details in the second field
			String secondPage2Field = "//input[@id='" + updatePageFieldName3 + "DATE']";
			driver.findElement(By.xpath(secondPage2Field)).click();
			consoleMessage("enter the details in the field.");

			// click on the today button
			click("customform_portfoliodashboard_todaybtn_XPATH");

			// scroll down to bottom
			scrollBottom();

			// click on the save button
			click("customform_portfoliodashboard_fields_savebtn_XPATH");

			// scroll to bottom
			scrollBottom();

			// wait for the element
			Thread.sleep(5000);

			// validate the details of the first field of the second page
			try {
				String firstPage2Field1 = "//span[contains(text(),'" + "333" + "')]";
				String firstPage2Field1_actual = (driver.findElement(By.xpath(firstPage2Field1)).getText()).trim();

				if (firstPage2Field1_actual.equals("333")) {
					successMessage("The details of the first field of the second page is displayed successfully.");
				} else {
					verificationFailedMessage("The details of the first field of the second page is not displayed.");
				}
			} catch (Throwable t) {
				verificationFailedMessage("The details of the first field of the second page is not displayed.");
			}

			// validate the details of the second field of the second page
			try {
				LocalDate today = LocalDate.now();
				String today_string = today.toString();

				String secondPage2Field1 = "//span[contains(text(),'" + today_string + "')]";
				String secondPage2Field1_actual = (driver.findElement(By.xpath(secondPage2Field1)).getText()).trim();

				if (secondPage2Field1_actual.equals(today_string)) {
					successMessage("The details of the second field of the second page is displayed successfully.");
				} else {
					verificationFailedMessage("The details of the second field of the second page is not displayed.");
				}
			} catch (Throwable t) {
				verificationFailedMessage("The details of the second field is of the second page not displayed.");
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

		// DELETE THE UPDATED PAGES
		title("DELETE THE UPDATED PAGES");

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

			// click on the newly created custom record
			String nameTitle = "//td[text()='" + data.get("name") + "']";
			driver.findElement(By.xpath(nameTitle)).click();
			consoleMessage("Clicked on the newly created custom record.");

			// click on the delete icon of the first page
			String editIcon1 = "//span[contains(text(),'" + pageName1
					+ "')]//a[@ng-click='deleteSelectedTabPage(tabPage)']";
			driver.findElement(By.xpath(editIcon1)).click();
			consoleMessage("Clicked on the delete icon of the first page.");

			// wait for the element
			Thread.sleep(3000);

			// click on the delete icon of the second page
			String editIcon2 = "//span[contains(text(),'" + pageName2
					+ "')]//a[@ng-click='deleteSelectedTabPage(tabPage)']";
			driver.findElement(By.xpath(editIcon2)).click();
			consoleMessage("Clicked on the delete icon of the second page.");

			// click on the update button
			click("customform_updatebtn_XPATH");

		} catch (Throwable t) {
			verificationFailed();
		}

		// click on the home icon from the top of the screen
		click("questionnaire_homeburgermenubtn_CSS");

		// wait for the element
		explicitWait("propertylist_title_XPATH");

		// verify the property list
		switchVerification("propertylist_title_XPATH", "Property List", "The property list is not displayed.");

		// VALIDATE THE DELETED PAGE NAME IS REFLECTED ON PORTFOLIO SUMMARY DASHBOARD
		// SCREEN
		title("VALIDATE THE DELETED PAGE NAME IS REFLECTED ON PORTFOLIO SUMMARY DASHBOARD SCREEN");

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
				String customForm1 = "//td[text()='" + data.get("name") + "']";
				String customForm1_actual = (driver.findElement(By.xpath(customForm1)).getText()).trim();

				if (customForm1_actual.equals(data.get("name"))) {
					successMessage("The newly created custom form is displayed successfully.");
				} else {
					verificationFailedMessage("The newly created custom form is not displayed.");
				}
			} catch (Throwable t) {
				verificationFailedMessage("The newly created custom form is not displayed.");
			}

			// click on the custom form
			String customForm1 = "//td[text()='" + data.get("name") + "']";
			driver.findElement(By.xpath(customForm1)).click();
			consoleMessage("Clicked on the custom form.");

			// scroll down to bottom
			scrollBottom();

			// validate the custom form as a title
			try {
				String customName = "//h4[contains(text(),'" + data.get("name") + "')]";
				String customName_actual = (driver.findElement(By.xpath(customName)).getText()).trim();

				if (customName_actual.equals(data.get("name"))) {
					successMessage("The custom form name is displayed correctly.");
				} else {
					verificationFailedMessage("The custom form is not displayed.");
				}
			} catch (Throwable t) {
				verificationFailedMessage("The custom form is not displayed.");
			}

			// validate the first updated page name
			try {
				String updatePageTab1 = "//span[text()='" + updatePageName1 + "']";
				String updatePageTab1_actual = (driver.findElement(By.xpath(updatePageTab1)).getText()).trim();

				if (updatePageTab1_actual.equals(updatePageName1)) {
					verificationFailedMessage("The first deleted page name is displayed.");
				} else {
					successMessage("The first deleted page name is not displayed.");
				}
			} catch (Throwable t) {
				successMessage("The first deleted page name is not displayed.");
			}

			// validate the second updated page name
			try {
				String updatePageTab2 = "//span[text()='" + updatePageName2 + "']";
				String updatePageTab2_actual = (driver.findElement(By.xpath(updatePageTab2)).getText()).trim();

				if (updatePageTab2_actual.equals(updatePageName2)) {
					verificationFailedMessage("The second deleted page name is displayed.");
				} else {
					successMessage("The second deleted page name is not displayed.");
				}
			} catch (Throwable t) {
				successMessage("The second deleted page name is not displayed.");
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

		// DELETE THE NEWLY CREATED CUSTOMER FORM
		title("DELETE THE NEWLY CREATED CUSTOMER FORM");

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

			// click on the delete button of the newly created custom form
			String deleteIcon = "//td[text()='" + data.get("name")
					+ "']//following-sibling::td[@class='pointer']//i[@data-target='#deleteCustomFormModal']";
			driver.findElement(By.xpath(deleteIcon)).click();
			consoleMessage("Clicked on the delete button of the newly created custom form.");

			// wait for the element
			Thread.sleep(5000);

			// click on the delete button
			click("customform_deletebtn_XPATH");

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
