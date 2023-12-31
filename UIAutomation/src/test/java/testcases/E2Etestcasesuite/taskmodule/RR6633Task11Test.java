package testcases.E2Etestcasesuite.taskmodule;

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

public class RR6633Task11Test extends TestBase {

	@Test(dataProviderClass = TestUtil.class, dataProvider = "dp")
	public void rR6633Task11Test(Hashtable<String, String> data) throws IOException, InterruptedException {

		execution(data, "rR6633Task11Test");

		// VALIDATE THE �JUMP TO CUSTOM FORM� OPTION IN THE TASK, WITHOUT ASSOCIATING
		// THE CUSTOM FORM WITH THE TASK. (VALIDATE WITH SINGLE AND MULTIPLE TYPE CUSTOM
		// FORM)
		title("VALIDATE THE �JUMP TO CUSTOM FORM� OPTION IN THE TASK, WITHOUT ASSOCIATING THE CUSTOM FORM WITH THE TASK. (VALIDATE WITH SINGLE AND MULTIPLE TYPE CUSTOM FORM)");

		// refresh the page
		driver.navigate().refresh();
		Thread.sleep(5000);
		driver.navigate().refresh();

		// CREATE NEW CUSTOM FORMS FOR SINGLE RECORD TYPE
		title("CREATE NEW CUSTOM FORMS FOR SINGLE RECORD TYPE");

		String name_s = RandomStringUtils.randomAlphabetic(8); // Custom Form Name
		String fieldName1_s = RandomStringUtils.randomAlphabetic(8); // Normal Field 1
		String fieldName2_s = RandomStringUtils.randomAlphabetic(8); // Normal Field 2
		String fieldDetail1_s = RandomStringUtils.randomAlphabetic(8); // Normal Field Detail 1
		String fieldDetail2_s = RandomStringUtils.randomNumeric(3); // Normal Field Detail 2
		String pageName1_s = RandomStringUtils.randomAlphabetic(8); // Page Name 1
		String pageFieldName1_s = RandomStringUtils.randomAlphabetic(8); // Page Name 1 - Field 1
		String pageFieldName2_s = RandomStringUtils.randomAlphabetic(8); // Page Name 1 - Field 2
		String pageFieldDetail1_s = RandomStringUtils.randomAlphabetic(8); // Page Name 2 - Field Details 1
		String pageFieldDetail2_s = RandomStringUtils.randomNumeric(3); // Page Name 2 - Field Details 2

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
			type("customform_nametxt_XPATH", name_s);

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
				String Validation0 = "//td[text()='" + name_s + "']";
				String Validation0_actual = (driver.findElement(By.xpath(Validation0)).getText()).trim();

				if (Validation0_actual.equals(name_s)) {

					successMessage("The Report Name detail is displayed correctly.");

				} else {
					verificationFailedMessage("The Report Name detail is displayed correctly.");
				}

			} catch (Throwable t) {
				verificationFailedMessage("The Report Name detail is displayed correctly.");
			}

			// click on the newly created custom record record
			String nameTitle = "//td[text()='" + name_s + "']";
			driver.findElement(By.xpath(nameTitle)).click();
			consoleMessage("Clicked on the newly created custom record record.");

			// click on the add field button
			click("customform_addfieldbtn_XPATH");

			// enter field name
			type("customform_addfield_nametxt_XPATH", fieldName1_s);

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
				String field1 = "//span[text()='" + fieldName1_s + "']";
				String field1_actual = (driver.findElement(By.xpath(field1)).getText()).trim();

				if (field1_actual.equals(fieldName1_s)) {
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
			type("customform_addfield_nametxt_XPATH", fieldName2_s);

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
				String field2 = "//span[text()='" + fieldName2_s + "']";
				String field2_actual = (driver.findElement(By.xpath(field2)).getText()).trim();

				if (field2_actual.equals(fieldName2_s)) {
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
			type("customform_portfoliodashboard_pagenametxt_XPATH", pageName1_s);

			// click on the add button
			click("customform_portfoliodashboard_pagename_addbtn_XPATH");

			// validate the newly added page
			try {
				String page1 = "//span[contains(text(),'" + pageName1_s + "')]";
				String page1_actual = (driver.findElement(By.xpath(page1)).getText()).trim();

				if (page1_actual.equals(pageName1_s)) {
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

			// Wait for the element
			Thread.sleep(5000);

			// click on the first page name tab
			String page1 = "//span[contains(text(),'" + pageName1_s + "')]";
			driver.findElement(By.xpath(page1)).click();
			consoleMessage("Clicked on the first page name tab.");

			// click on the add field button
			click("customform_addfieldbtn_XPATH");

			// scroll to bottom
			scrollBottom();

			// enter field name
			type("customform_addfield_nametxt_XPATH", pageFieldName1_s);

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
			String page11 = "//span[contains(text(),'" + pageName1_s + "')]";
			driver.findElement(By.xpath(page11)).click();
			consoleMessage("Clicked on the first page name tab.");

			// scroll to bottom
			scrollBottom();

			// validate the newly created field
			try {
				String field1 = "//span[text()='" + pageFieldName1_s + "']";
				String field1_actual = (driver.findElement(By.xpath(field1)).getText()).trim();

				if (field1_actual.equals(pageFieldName1_s)) {
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
			type("customform_addfield_nametxt_XPATH", pageFieldName2_s);

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
			String page111 = "//span[contains(text(),'" + pageName1_s + "')]";
			driver.findElement(By.xpath(page111)).click();
			consoleMessage("Clicked on the first page name tab.");

			// scroll to bottom
			scrollBottom();

			// validate the newly created field
			try {
				String field2 = "//span[text()='" + pageFieldName2_s + "']";
				String field2_actual = (driver.findElement(By.xpath(field2)).getText()).trim();

				if (field2_actual.equals(pageFieldName2_s)) {
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

		// ADD THE DETAILS IN THE FIELDS OF NEWLY ADDED PAGES
		title("ADD THE DETAILS IN THE FIELDS OF NEWLY ADDED PAGES");

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
				String customForm1 = "//td[text()='" + name_s + "']";
				String customForm1_actual = (driver.findElement(By.xpath(customForm1)).getText()).trim();

				if (customForm1_actual.equals(name_s)) {
					successMessage("The newly created custom form is displayed successfully.");

				} else {
					verificationFailedMessage("The newly created custom form is not displayed.");
				}

			} catch (Throwable t) {
				verificationFailedMessage("The newly created custom form is not displayed.");
			}

			// click on the custom form
			String customForm1 = "//td[text()='" + name_s + "']";
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
			String firstField = "//input[@id='" + fieldName1_s + "TEXT']";
			driver.findElement(By.xpath(firstField)).sendKeys(fieldDetail1_s);
			consoleMessage("Entered the details in the first field.");

			// enter the details in the second field
			String secondField = "//input[@id='" + fieldName2_s + "NUMBER']";
			driver.findElement(By.xpath(secondField)).sendKeys(fieldDetail2_s);
			consoleMessage("Entered the details in the second field.");

			// click on the save button
			click("customform_portfoliodashboard_fields_savebtn_XPATH");

			// scroll to bottom
			scrollBottom();

			// wait for the element
			Thread.sleep(5000);

			// validate the details of the first field
			try {
				String firstField1 = "//span[contains(text(),'" + fieldDetail1_s + "')]";
				String firstField1_actual = (driver.findElement(By.xpath(firstField1)).getText()).trim();

				if (firstField1_actual.equals(fieldDetail1_s)) {
					successMessage("The details of the first field is displayed successfully.");
				} else {
					verificationFailedMessage("The details of the first field is not displayed.");
				}
			} catch (Throwable t) {
				verificationFailedMessage("The details of the first field is not displayed.");
			}

			// validate the details of the second field
			try {
				String secondField1 = "//span[contains(text(),'" + fieldDetail2_s + "')]";
				String secondField1_actual = (driver.findElement(By.xpath(secondField1)).getText()).trim();

				if (secondField1_actual.equals(fieldDetail2_s)) {
					successMessage("The details of the second field is displayed successfully.");
				} else {
					verificationFailedMessage("The details of the second field is not displayed.");
				}
			} catch (Throwable t) {
				verificationFailedMessage("The details of the second field is not displayed.");
			}

			// click on the first page name tab
			String pageTab1 = "//span[text()='" + pageName1_s + "']";
			driver.findElement(By.xpath(pageTab1)).click();
			consoleMessage("Clicked on the first page name tab.");

			// ADD THE DETAILS IN THE FIELDS OF THE FIRST PAGE TAB
			title("ADD THE DETAILS IN THE FIELDS OF THE FIRST PAGE TAB");

			// scroll to bottom
			scrollBottom();

			// click on the edit field button
			click("customform_portfoliodashboard_editfieldbtn_XPATH");

			// enter the details in the first field
			String firstPageField = "//input[@id='" + pageFieldName1_s + "TEXT']";
			driver.findElement(By.xpath(firstPageField)).sendKeys(pageFieldDetail1_s);
			consoleMessage("Entered the details in the first field.");

			// enter the details in the second field
			String secondPageField = "//input[@id='" + pageFieldName2_s + "NUMBER']";
			driver.findElement(By.xpath(secondPageField)).sendKeys(pageFieldDetail2_s);
			consoleMessage("Entered the details in the second field.");

			// click on the save button
			click("customform_portfoliodashboard_fields_savebtn_XPATH");

			// scroll to bottom
			scrollBottom();

			// wait for the element
			Thread.sleep(5000);

			// validate the details of the first field of the first page
			try {
				String firstField1 = "//span[contains(text(),'" + pageFieldDetail1_s + "')]";
				String firstField1_actual = (driver.findElement(By.xpath(firstField1)).getText()).trim();

				if (firstField1_actual.equals(pageFieldDetail1_s)) {
					successMessage("The details of the first field of the first page is displayed successfully.");
				} else {
					verificationFailedMessage("The details of the first field of the first page is not displayed.");
				}
			} catch (Throwable t) {
				verificationFailedMessage("The details of the first field of the first page is not displayed.");
			}

			// validate the details of the second field of the first page
			try {
				String secondField1 = "//span[contains(text(),'" + pageFieldDetail2_s + "')]";
				String secondField1_actual = (driver.findElement(By.xpath(secondField1)).getText()).trim();

				if (secondField1_actual.equals(pageFieldDetail2_s)) {
					successMessage("The details of the second field of the first page is displayed successfully.");
				} else {
					verificationFailedMessage("The details of the second field of the first page is not displayed.");
				}
			} catch (Throwable t) {
				verificationFailedMessage("The details of the second field is of the first page not displayed.");
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

		String name_m = RandomStringUtils.randomAlphabetic(8);
		String fieldName1_m = RandomStringUtils.randomAlphabetic(8);
		String fieldName2_m = RandomStringUtils.randomAlphabetic(8);
		String pageName1_m = RandomStringUtils.randomAlphabetic(8);
		String pageFieldName1_m = RandomStringUtils.randomAlphabetic(8);
		String pageFieldName2_m = RandomStringUtils.randomAlphabetic(8);
		String field1Detail_m = null;
		String field2Detail_m = null;
		String pageField1Detail_m = null;
		String pageField2Detail_m = null;
		List<String> field1Detail_list_m = new ArrayList<String>();
		List<String> field2Detail_list_m = new ArrayList<String>();
		List<String> pageField1Detail_list_m = new ArrayList<String>();
		List<String> pageField2Detail_list_m = new ArrayList<String>();

		Random random_m = new Random();
		int count_m = random_m.nextInt(5 - 3) + 3;

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
			type("customform_nametxt_XPATH", name_m);

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
				String Validation0 = "//td[text()='" + name_m + "']";
				String Validation0_actual = (driver.findElement(By.xpath(Validation0)).getText()).trim();

				if (Validation0_actual.equals(name_m)) {

					successMessage("The Report Name detail is displayed correctly.");

				} else {
					verificationFailedMessage("The Report Name detail is not displayed.");
				}

			} catch (Throwable t) {
				verificationFailedMessage("The Report Name detail is not displayed.");
			}

			// click on the newly created custom record record
			String nameTitle = "//td[text()='" + name_m + "']";
			driver.findElement(By.xpath(nameTitle)).click();
			consoleMessage("Clicked on the newly created custom record record.");

			// click on the add field button
			click("customform_addfieldbtn_XPATH");

			// enter field name
			type("customform_addfield_nametxt_XPATH", fieldName1_m);

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
				String field1 = "//span[text()='" + fieldName1_m + "']";
				String field1_actual = (driver.findElement(By.xpath(field1)).getText()).trim();

				if (field1_actual.equals(fieldName1_m)) {
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
			type("customform_addfield_nametxt_XPATH", fieldName2_m);

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
				String field2 = "//span[text()='" + fieldName2_m + "']";
				String field2_actual = (driver.findElement(By.xpath(field2)).getText()).trim();

				if (field2_actual.equals(fieldName2_m)) {
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
			type("customform_portfoliodashboard_pagenametxt_XPATH", pageName1_m);

			// wait for the element
			Thread.sleep(5000);

			// click on the add button
			click("customform_portfoliodashboard_pagename_addbtn_XPATH");

			// validate the newly added page
			try {
				String page1 = "//span[contains(text(),'" + pageName1_m + "')]";
				String page1_actual = (driver.findElement(By.xpath(page1)).getText()).trim();

				if (page1_actual.equals(pageName1_m)) {
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
			String page1 = "//span[contains(text(),'" + pageName1_m + "')]";
			driver.findElement(By.xpath(page1)).click();
			consoleMessage("Clicked on the first page name tab.");

			// click on the add field button
			click("customform_addfieldbtn_XPATH");

			// scroll to bottom
			scrollBottom();

			// enter field name
			type("customform_addfield_nametxt_XPATH", pageFieldName1_m);

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
			String page11 = "//span[contains(text(),'" + pageName1_m + "')]";
			driver.findElement(By.xpath(page11)).click();
			consoleMessage("Clicked on the first page name tab.");

			// scroll to bottom
			scrollBottom();

			// validate the newly created field
			try {
				String field1 = "//span[text()='" + pageFieldName1_m + "']";
				String field1_actual = (driver.findElement(By.xpath(field1)).getText()).trim();

				if (field1_actual.equals(pageFieldName1_m)) {
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
			type("customform_addfield_nametxt_XPATH", pageFieldName2_m);

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
			String page111 = "//span[contains(text(),'" + pageName1_m + "')]";
			driver.findElement(By.xpath(page111)).click();
			consoleMessage("Clicked on the first page name tab.");

			// scroll to bottom
			scrollBottom();

			// validate the newly created field
			try {
				String field2 = "//span[text()='" + pageFieldName2_m + "']";
				String field2_actual = (driver.findElement(By.xpath(field2)).getText()).trim();

				if (field2_actual.equals(pageFieldName2_m)) {
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
				String customForm1 = "//td[text()='" + name_m + "']";
				String customForm1_actual = (driver.findElement(By.xpath(customForm1)).getText()).trim();

				if (customForm1_actual.equals(name_m)) {
					successMessage("The newly created custom form is displayed successfully.");

				} else {
					verificationFailedMessage("The newly created custom form is not displayed.");
				}

			} catch (Throwable t) {
				verificationFailedMessage("The newly created custom form is not displayed.");
			}

			// click on the custom form
			String customForm1 = "//td[text()='" + name_m + "']";
			driver.findElement(By.xpath(customForm1)).click();
			consoleMessage("Clicked on the custom form.");

			// wait for the element
			Thread.sleep(5000);

			consoleMessage("The details in fields will entered " + count_m + " times.");

			// enter details in the fields on random number
			for (int i = 0; i < count_m; i++) {

				// click on the add button
				click("customform_portfoliodashboard_addbtn_XPATH");

				// wait for the element
				Thread.sleep(5000);

				// scroll to bottom
				scrollBottom();

				// enter the details in the first field
				field1Detail_m = RandomStringUtils.randomAlphabetic(8);
				String firstField = "//input[@id='" + fieldName1_m + "TEXT']";
				driver.findElement(By.xpath(firstField)).sendKeys(field1Detail_m);
				consoleMessage("Entered the details in the first field.");

				// collect the random details of the first field
				field1Detail_list_m.add(field1Detail_m);
				consoleMessage("New count of data of the field 1 : " + field1Detail_list_m.size());

				// enter the details in the second field
				field2Detail_m = RandomStringUtils.randomNumeric(3);
				String secondField = "//input[@id='" + fieldName2_m + "NUMBER']";
				driver.findElement(By.xpath(secondField)).sendKeys(field2Detail_m);
				consoleMessage("Entered the details in the second field.");

				// collect the random details of the second field
				field2Detail_list_m.add(field2Detail_m);
				consoleMessage("New count of data of the field 2 : " + field2Detail_list_m.size());

				// click on the page one tab
				String page1 = "//span[text()='" + pageName1_m + "']";
				driver.findElement(By.xpath(page1)).click();
				consoleMessage("Clicked on the page one tab.");

				// enter the details in the first field
				pageField1Detail_m = RandomStringUtils.randomAlphabetic(8);
				String pageFirstField = "//input[@id='" + pageFieldName1_m + "TEXT']";
				driver.findElement(By.xpath(pageFirstField)).sendKeys(pageField1Detail_m);
				consoleMessage("Entered the details in the first field.");

				// collect the random details of the first field
				pageField1Detail_list_m.add(pageField1Detail_m);
				consoleMessage("New count of data of the field 1 of page one : " + pageField1Detail_list_m.size());

				// enter the details in the second field
				pageField2Detail_m = RandomStringUtils.randomNumeric(3);
				String pageSecondField = "//input[@id='" + pageFieldName2_m + "NUMBER']";
				driver.findElement(By.xpath(pageSecondField)).sendKeys(pageField2Detail_m);
				consoleMessage("Entered the details in the second field.");

				// collect the random details of the second field
				pageField2Detail_list_m.add(pageField2Detail_m);
				consoleMessage("New count of data of the field 2 of page one : " + pageField2Detail_list_m.size());

				// click on the save button
				click("customform_portfoliodashboard_fields_savebtn_XPATH");

				// scrolldown to bottom
				scrollBottom();

				// wait for the element
				Thread.sleep(5000);

				// validate the details of the first field
				try {
					String firstField1 = "//span[contains(text(),'" + field1Detail_m + "')]";
					String firstField1_actual = (driver.findElement(By.xpath(firstField1)).getText()).trim();

					if (firstField1_actual.equals(field1Detail_m)) {
						successMessage("The details of the first field is displayed successfully.");
					} else {
						verificationFailedMessage("The details of the first field is not displayed.");
					}
				} catch (Throwable t) {
					verificationFailedMessage("The details of the first field is not displayed.");
				}

				// validate the details of the second field
				try {
					String secondField1 = "//span[contains(text(),'" + field2Detail_m + "')]";
					String secondField1_actual = (driver.findElement(By.xpath(secondField1)).getText()).trim();

					if (secondField1_actual.equals(field2Detail_m)) {
						successMessage("The details of the second field is displayed successfully.");
					} else {
						verificationFailedMessage("The details of the second field is not displayed.");
					}
				} catch (Throwable t) {
					verificationFailedMessage("The details of the second field is not displayed.");
				}

				// validate the details of the first field of page one
				try {
					String thirdField1 = "//span[contains(text(),'" + pageField1Detail_m + "')]";
					String thirdField1_actual = (driver.findElement(By.xpath(thirdField1)).getText()).trim();

					if (thirdField1_actual.equals(pageField1Detail_m)) {
						successMessage("The details of the first field of page one is displayed successfully.");
					} else {
						verificationFailedMessage("The details of the first field of page one is not displayed.");
					}
				} catch (Throwable t) {
					verificationFailedMessage("The details of the first field of page one is not displayed.");
				}

				// validate the details of the second field of page one
				try {
					String fourthField2 = "//span[contains(text(),'" + pageField2Detail_m + "')]";
					String fourthField2_actual = (driver.findElement(By.xpath(fourthField2)).getText()).trim();

					if (fourthField2_actual.equals(pageField2Detail_m)) {
						successMessage("The details of the second field of page one is displayed successfully.");
					} else {
						verificationFailedMessage("The details of the second field of page one is not displayed.");
					}
				} catch (Throwable t) {
					verificationFailedMessage("The details of the second field of page one is not displayed.");
				}

			}

			consoleMessage("End of for loop and The total number of count is " + pageField1Detail_list_m.size());

		} catch (Throwable t) {
			verificationFailed();
		}

		// click on the home icon from the top of the screen
		click("questionnaire_homeburgermenubtn_hide_CSS");

		// wait for the element
		explicitWait("propertylist_title_XPATH");

		// verify the property list
		switchVerification("propertylist_title_XPATH", "Property List", "The property list is not displayed.");

		// CREATE THE NEW TASK UNDER THE SINGLE TYPE CUSTOM FORM FROM PROPERTY SUMMARY
		// DASHBOARD
		title("CREATE THE NEW TASK UNDER THE SINGLE TYPE CUSTOM FORM FROM PROPERTY SUMMARY DASHBOARD");

		String taskTitle1 = RandomStringUtils.randomAlphabetic(8);

		try {
			// wait for the element
			Thread.sleep(3000);

			// click on the property
			click("propertysummary_property1_XPATH");

			// scrolldown till Property Information section
			scrollTillElement("customform_portfoliodashboard_propertyinformationtitle_XPATH");

			// validate the newly created custom form in the property summary dashboard
			// screen
			try {
				String customForm1 = "//td[text()='" + name_s + "']";
				String customForm1_actual = (driver.findElement(By.xpath(customForm1)).getText()).trim();

				if (customForm1_actual.equals(name_s)) {
					successMessage("The newly created custom form is displayed successfully.");

				} else {
					verificationFailedMessage("The newly created custom form is not displayed.");
				}

			} catch (Throwable t) {
				verificationFailedMessage("The newly created custom form is not displayed.");
			}

			// click on the custom form
			String customForm1 = "//td[text()='" + name_s + "']";
			driver.findElement(By.xpath(customForm1)).click();
			consoleMessage("Clicked on the custom form.");

			// scroll to bottom
			scrollBottom();

			// click on the action icon
			click("customform_propertydashboard_actionicon_XPATH");

			// click on the task option
			click("customform_propertydashboard_taskoption_XPATH");

			// scroll down to bottom
			scrollBottom();

			// click on the add task button
			click("customform_propertydashboard_newtaskbtn_XPATH");

			// enter the data in the task title field
			type("task_addtask_titletxt_CSS", taskTitle1);

			// enter the data in the task location field
			type("task_addtask_locationtxt_CSS", data.get("task_location"));

			// scroll down to bottom
			scrollBottom();

			// click on the assign to field
			click("task_assigntotxt_CSS");

			// click on the none button
			click("task_tasktag_nonebtn_CSS");

			// enter the user name in the search field
			type("workflowsecurity_editortask_taskdetails_searchtasktagtxt_CSS", data.get("search_user"));

			// click on the searched result
			click("questionnaire_createtask_selectusertxt_XPATH");

			// click on the assign to field
			click("task_assigntotxt_CSS");

			// click on the save button
			click("customform_propertydashboard_savebtn_XPATH");

			// validate the newly created task in the custom form in the property summary
			// dashboard screen
			try {
				String task1 = "//td[text()='" + taskTitle1 + "']";
				String task1_actual = (driver.findElement(By.xpath(task1)).getText()).trim();

				if (task1_actual.equals(taskTitle1)) {
					successMessage("The newly created task in the custom form is displayed successfully.");

				} else {
					verificationFailedMessage("The newly created task in the custom form is not displayed.");
				}

			} catch (Throwable t) {
				verificationFailedMessage("The newly created task in the custom form is not displayed.");
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

		// VALIDATE THE NEWLY CREATED TASK UNDER SINGLE TYPE CUSTOM FORM AND "JUMP TO
		// CUSTOM FORM" BUTTON IN THE TASK MODULE (PROPERTY SUMMARY DASHBOARD)
		title("VALIDATE THE NEWLY CREATED TASK UNDER SINGLE TYPE CUSTOM FORM AND \"JUMP TO CUSTOM FORM\" BUTTON IN THE TASK MODULE (PROPERTY SUMMARY DASHBOARD)");

		try {

			// wait for the element
			Thread.sleep(3000);

			// click on the task icon of the respective property
			click("taskicon_CSS");

			// click on the clear button
			click("task_createdtask_clearbtn_XPATH");

			// enter the data in the search field
			type("task_filter_CSS", taskTitle1);

			// click on the search button
			click("task_createdtask_searchbtn_XPATH");

			// verify newly created task is displayed or not
			try {
				String task = "//p[contains(text(),'" + taskTitle1 + "')]";
				String task_actual = (driver.findElement(By.xpath(task)).getText()).trim();

				if (task_actual.equals(taskTitle1)) {
					successMessage("The newly created task is verified successfully.");
				} else {
					verificationFailedMessage("The newly created task is not verified.");
				}
			} catch (Throwable t) {
				verificationFailedMessage("The newly created task is not verified.");
			}

			// click on the action icon
			String actionIcon = "//p[text()='" + taskTitle1
					+ "']//parent::td//following-sibling::td[@class='text-center pointer']//i[@data-toggle='dropdown']";
			driver.findElement(By.xpath(actionIcon)).click();
			consoleMessage("Clicked on the action icon.");

			// click on the jump to custom form option
			String jumptoOption = "//p[text()='" + taskTitle1
					+ "']//parent::td//following-sibling::td[@class='text-center pointer']//div[@class='dropdown open']//li[@ng-show='isDefined(task.customFormName)']";
			driver.findElement(By.xpath(jumptoOption)).click();
			consoleMessage("Clicked on the jump to custom form option.");

			// wait for the element
			Thread.sleep(10000);

			// scroll up to top
			scrollTop();

			// validate the custom form as a title
			try {
				String customName = "//h4[contains(text(),'" + name_s + "')]";
				String customName_actual = (driver.findElement(By.xpath(customName)).getText()).trim();

				if (customName_actual.equals(name_s)) {
					successMessage("The custom form name is displayed correctly.");
				} else {
					verificationFailedMessage("The custom form is not displayed.");
				}
			} catch (Throwable t) {
				verificationFailedMessage("The custom form is not displayed.");
			}

			// click on the details tab
			String details = "//span[text()='Details']";
			driver.findElement(By.xpath(details)).click();
			consoleMessage("Clicked on the details tab.");

			// scroll down to bottom
			scrollBottom();

			// validate the first field label
			try {
				String fieldLabel1 = "//label[contains(text(),'" + fieldName1_s + "')]";
				String fieldLabel1_actual = (driver.findElement(By.xpath(fieldLabel1)).getText()).trim();

				if (fieldLabel1_actual.equals(fieldName1_s + ":")) {
					successMessage("The first field label is displayed successfully.");
				} else {
					verificationFailedMessage("The first field label is not displayed.");
				}
			} catch (Throwable t) {
				verificationFailedMessage("The first field label is not displayed.");
			}

			// validate the second field label
			try {
				String fieldLabel2 = "//label[contains(text(),'" + fieldName2_s + "')]";
				String fieldLabel2_actual = (driver.findElement(By.xpath(fieldLabel2)).getText()).trim();

				if (fieldLabel2_actual.equals(fieldName2_s + ":")) {
					successMessage("The second field label is displayed successfully.");
				} else {
					verificationFailedMessage("The second field label is not displayed.");
				}
			} catch (Throwable t) {
				verificationFailedMessage("The second field label is not displayed.");
			}

			// click on the first page name tab
			String pageTab1 = "//span[text()='" + pageName1_s + "']";
			driver.findElement(By.xpath(pageTab1)).click();
			consoleMessage("Clicked on the first page name tab.");

			// scroll to bottom
			scrollBottom();

			// validate the third field label
			try {
				String fieldLabel3 = "//label[contains(text(),'" + pageFieldName1_s + "')]";
				String fieldLabel3_actual = (driver.findElement(By.xpath(fieldLabel3)).getText()).trim();

				if (fieldLabel3_actual.equals(pageFieldName1_s + ":")) {
					successMessage("The third field label is displayed successfully.");
				} else {
					verificationFailedMessage("The third field label is not displayed.");
				}
			} catch (Throwable t) {
				verificationFailedMessage("The third field label is not displayed.");
			}

			// validate the forth field label
			try {
				String fieldLabel4 = "//label[contains(text(),'" + pageFieldName2_s + "')]";
				String fieldLabel4_actual = (driver.findElement(By.xpath(fieldLabel4)).getText()).trim();

				if (fieldLabel4_actual.equals(pageFieldName2_s + ":")) {
					successMessage("The forth field label is displayed successfully.");
				} else {
					verificationFailedMessage("The forth field label is not displayed.");
				}
			} catch (Throwable t) {
				verificationFailedMessage("The forth field label is not displayed.");
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

		// CREATE THE NEW TASK UNDER THE MULTIPLE TYPE CUSTOM FORM FROM PROPERTY SUMMARY
		// DASHBOARD
		title("CREATE THE NEW TASK UNDER THE MULTIPLE TYPE CUSTOM FORM FROM PROPERTY SUMMARY DASHBOARD");

		String taskTitle2 = RandomStringUtils.randomAlphabetic(8);

		try {
			// wait for the element
			Thread.sleep(3000);

			// click on the property
			click("propertysummary_property1_XPATH");

			// scrolldown till Property Information section
			scrollTillElement("customform_portfoliodashboard_propertyinformationtitle_XPATH");

			// validate the newly created custom form in the property summary dashboard
			// screen
			try {
				String customForm1 = "//td[text()='" + name_m + "']";
				String customForm1_actual = (driver.findElement(By.xpath(customForm1)).getText()).trim();

				if (customForm1_actual.equals(name_m)) {
					successMessage("The newly created custom form is displayed successfully.");

				} else {
					verificationFailedMessage("The newly created custom form is not displayed.");
				}

			} catch (Throwable t) {
				verificationFailedMessage("The newly created custom form is not displayed.");
			}

			// click on the custom form
			String customForm1 = "//td[text()='" + name_m + "']";
			driver.findElement(By.xpath(customForm1)).click();
			consoleMessage("Clicked on the custom form.");

			// scroll to bottom
			scrollBottom();

			// click on the custom form details
			String customForm_m = "//span[text()='" + field1Detail_list_m.get(0) + "']";
			driver.findElement(By.xpath(customForm_m)).click();
			consoleMessage("Clicked on the custom form details.");

			// click on the action icon
			click("customform_propertydashboard_actionicon_XPATH");

			// click on the task option
			click("customform_propertydashboard_taskoption_XPATH");

			// scroll down to bottom
			scrollBottom();

			// click on the add task button
			click("customform_propertydashboard_newtaskbtn_XPATH");

			// enter the data in the task title field
			type("task_addtask_titletxt_CSS", taskTitle2);

			// enter the data in the task location field
			type("task_addtask_locationtxt_CSS", data.get("task_location"));

			// scroll down to bottom
			scrollBottom();

			// click on the assign to field
			click("task_assigntotxt_CSS");

			// click on the none button
			click("task_tasktag_nonebtn_CSS");

			// enter the user name in the search field
			type("workflowsecurity_editortask_taskdetails_searchtasktagtxt_CSS", data.get("search_user"));

			// click on the searched result
			click("questionnaire_createtask_selectusertxt_XPATH");

			// click on the assign to field
			click("task_assigntotxt_CSS");

			// click on the save button
			click("customform_propertydashboard_savebtn_XPATH");

			// validate the newly created task in the custom form in the property summary
			// dashboard screen
			try {
				String task1 = "//td[text()='" + taskTitle2 + "']";
				String task1_actual = (driver.findElement(By.xpath(task1)).getText()).trim();

				if (task1_actual.equals(taskTitle2)) {
					successMessage("The newly created task in the custom form is displayed successfully.");

				} else {
					verificationFailedMessage("The newly created task in the custom form is not displayed.");
				}

			} catch (Throwable t) {
				verificationFailedMessage("The newly created task in the custom form is not displayed.");
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

		// VALIDATE THE NEWLY CREATED TASK UNDER MULTIPLE TYPE CUSTOM FORM AND "JUMP TO
		// CUSTOM FORM" BUTTON IN THE TASK MODULE (PROPERTY SUMMARY DASHBOARD)
		title("VALIDATE THE NEWLY CREATED TASK UNDER MULTIPLE TYPE CUSTOM FORM AND \"JUMP TO CUSTOM FORM\" BUTTON IN THE TASK MODULE (PROPERTY SUMMARY DASHBOARD)");

		try {

			// wait for the element
			Thread.sleep(3000);

			// click on the task icon of the respective property
			click("taskicon_CSS");

			// click on the clear button
			click("task_createdtask_clearbtn_XPATH");

			// enter the data in the search field
			type("task_filter_CSS", taskTitle2);

			// click on the search button
			click("task_createdtask_searchbtn_XPATH");

			// verify newly created task is displayed or not
			try {
				String task = "//p[contains(text(),'" + taskTitle2 + "')]";
				String task_actual = (driver.findElement(By.xpath(task)).getText()).trim();

				if (task_actual.equals(taskTitle2)) {
					successMessage("The newly created task is verified successfully.");
				} else {
					verificationFailedMessage("The newly created task is not verified.");
				}
			} catch (Throwable t) {
				verificationFailedMessage("The newly created task is not verified.");
			}

			// click on the action icon
			String actionIcon = "//p[text()='" + taskTitle2
					+ "']//parent::td//following-sibling::td[@class='text-center pointer']//i[@data-toggle='dropdown']";
			driver.findElement(By.xpath(actionIcon)).click();
			consoleMessage("Clicked on the action icon.");

			// click on the jump to custom form option
			String jumptoOption = "//p[text()='" + taskTitle2
					+ "']//parent::td//following-sibling::td[@class='text-center pointer']//div[@class='dropdown open']//li[@ng-show='isDefined(task.customFormName)']";
			driver.findElement(By.xpath(jumptoOption)).click();
			consoleMessage("Clicked on the jump to custom form option.");

			// wait for the element
			Thread.sleep(10000);

			// scroll up to top
			scrollTop();

			// validate the custom form as a title
			try {
				String customName = "//h4[contains(text(),'" + name_m + "')]";
				String customName_actual = (driver.findElement(By.xpath(customName)).getText()).trim();

				if (customName_actual.equals(name_m)) {
					successMessage("The custom form name is displayed correctly.");
				} else {
					verificationFailedMessage("The custom form is not displayed.");
				}
			} catch (Throwable t) {
				verificationFailedMessage("The custom form is not displayed.");
			}

			// click on the details tab
			String details = "//span[text()='Details']";
			driver.findElement(By.xpath(details)).click();
			consoleMessage("Clicked on the details tab.");

			// scroll down to bottom
			scrollBottom();

			// validate the first field label
			try {
				String fieldLabel1 = "//label[contains(text(),'" + fieldName1_m + "')]";
				String fieldLabel1_actual = (driver.findElement(By.xpath(fieldLabel1)).getText()).trim();

				if (fieldLabel1_actual.equals(fieldName1_m + ":")) {
					successMessage("The first field label is displayed successfully.");
				} else {
					verificationFailedMessage("The first field label is not displayed.");
				}
			} catch (Throwable t) {
				verificationFailedMessage("The first field label is not displayed.");
			}

			// validate the second field label
			try {
				String fieldLabel2 = "//label[contains(text(),'" + fieldName2_m + "')]";
				String fieldLabel2_actual = (driver.findElement(By.xpath(fieldLabel2)).getText()).trim();

				if (fieldLabel2_actual.equals(fieldName2_m + ":")) {
					successMessage("The second field label is displayed successfully.");
				} else {
					verificationFailedMessage("The second field label is not displayed.");
				}
			} catch (Throwable t) {
				verificationFailedMessage("The second field label is not displayed.");
			}

			// click on the first page name tab
			String pageTab1 = "//span[text()='" + pageName1_m + "']";
			driver.findElement(By.xpath(pageTab1)).click();
			consoleMessage("Clicked on the first page name tab.");

			// scroll to bottom
			scrollBottom();

			// validate the third field label
			try {
				String fieldLabel3 = "//label[contains(text(),'" + pageFieldName1_m + "')]";
				String fieldLabel3_actual = (driver.findElement(By.xpath(fieldLabel3)).getText()).trim();

				if (fieldLabel3_actual.equals(pageFieldName1_m + ":")) {
					successMessage("The third field label is displayed successfully.");
				} else {
					verificationFailedMessage("The third field label is not displayed.");
				}
			} catch (Throwable t) {
				verificationFailedMessage("The third field label is not displayed.");
			}

			// validate the forth field label
			try {
				String fieldLabel4 = "//label[contains(text(),'" + pageFieldName2_m + "')]";
				String fieldLabel4_actual = (driver.findElement(By.xpath(fieldLabel4)).getText()).trim();

				if (fieldLabel4_actual.equals(pageFieldName2_m + ":")) {
					successMessage("The forth field label is displayed successfully.");
				} else {
					verificationFailedMessage("The forth field label is not displayed.");
				}
			} catch (Throwable t) {
				verificationFailedMessage("The forth field label is not displayed.");
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

		// CREATE THE NEW TASK UNDER THE SINGLE TYPE CUSTOM FORM FROM PORTFOLIO SUMMARY
		// DASHBOARD
		title("CREATE THE NEW TASK UNDER THE SINGLE TYPE CUSTOM FORM FROM PORTFOLIO SUMMARY DASHBOARD");

		String taskTitle3 = RandomStringUtils.randomAlphabetic(8);

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

			// validate the newly created custom form in the property summary dashboard
			// screen
			try {
				String customForm1 = "//td[text()='" + name_s + "']";
				String customForm1_actual = (driver.findElement(By.xpath(customForm1)).getText()).trim();

				if (customForm1_actual.equals(name_s)) {
					successMessage("The newly created custom form is displayed successfully.");

				} else {
					verificationFailedMessage("The newly created custom form is not displayed.");
				}

			} catch (Throwable t) {
				verificationFailedMessage("The newly created custom form is not displayed.");
			}

			// click on the custom form
			String customForm1 = "//td[text()='" + name_s + "']";
			driver.findElement(By.xpath(customForm1)).click();
			consoleMessage("Clicked on the custom form.");

			// scroll to bottom
			scrollBottom();

			// click on the property one
			click("customform_portfoliodashboard_propertyname_XPATH");

			// scroll to bottom
			scrollBottom();

			// click on the action icon
			click("customform_propertydashboard_actionicon_XPATH");

			// click on the task option
			click("customform_propertydashboard_taskoption_XPATH");

			// scroll down to bottom
			scrollBottom();

			// click on the add task button
			click("customform_propertydashboard_newtaskbtn_XPATH");

			// enter the data in the task title field
			type("task_addtask_titletxt_CSS", taskTitle3);

			// enter the data in the task location field
			type("task_addtask_locationtxt_CSS", data.get("task_location"));

			// scroll down to bottom
			scrollBottom();

			// click on the assign to field
			click("task_assigntotxt_CSS");

			// click on the none button
			click("task_tasktag_nonebtn_CSS");

			// enter the user name in the search field
			type("workflowsecurity_editortask_taskdetails_searchtasktagtxt_CSS", data.get("search_user"));

			// click on the searched result
			click("questionnaire_createtask_selectusertxt_XPATH");

			// click on the assign to field
			click("task_assigntotxt_CSS");

			// click on the save button
			click("customform_propertydashboard_savebtn_XPATH");

			// validate the newly created task in the custom form in the property summary
			// dashboard screen
			try {
				String task1 = "//td[text()='" + taskTitle3 + "']";
				String task1_actual = (driver.findElement(By.xpath(task1)).getText()).trim();

				if (task1_actual.equals(taskTitle3)) {
					successMessage("The newly created task in the custom form is displayed successfully.");

				} else {
					verificationFailedMessage("The newly created task in the custom form is not displayed.");
				}

			} catch (Throwable t) {
				verificationFailedMessage("The newly created task in the custom form is not displayed.");
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

		// VALIDATE THE NEWLY CREATED TASK UNDER SINGLE TYPE CUSTOM FORM AND "JUMP TO
		// CUSTOM FORM" BUTTON IN THE TASK MODULE (PORTFOLIO SUMMARY DASHBOARD)
		title("VALIDATE THE NEWLY CREATED TASK UNDER SINGLE TYPE CUSTOM FORM AND \"JUMP TO CUSTOM FORM\" BUTTON IN THE TASK MODULE (PORTFOLIO SUMMARY DASHBOARD)");

		try {

			// wait for the element
			Thread.sleep(3000);

			// click on the task icon of the respective property
			click("taskicon_CSS");

			// click on the clear button
			click("task_createdtask_clearbtn_XPATH");

			// enter the data in the search field
			type("task_filter_CSS", taskTitle3);

			// click on the search button
			click("task_createdtask_searchbtn_XPATH");

			// verify newly created task is displayed or not
			try {
				String task = "//p[contains(text(),'" + taskTitle3 + "')]";
				String task_actual = (driver.findElement(By.xpath(task)).getText()).trim();

				if (task_actual.equals(taskTitle3)) {
					successMessage("The newly created task is verified successfully.");
				} else {
					verificationFailedMessage("The newly created task is not verified.");
				}
			} catch (Throwable t) {
				verificationFailedMessage("The newly created task is not verified.");
			}

			// click on the action icon
			String actionIcon = "//p[text()='" + taskTitle3
					+ "']//parent::td//following-sibling::td[@class='text-center pointer']//i[@data-toggle='dropdown']";
			driver.findElement(By.xpath(actionIcon)).click();
			consoleMessage("Clicked on the action icon.");

			// click on the jump to custom form option
			String jumptoOption = "//p[text()='" + taskTitle3
					+ "']//parent::td//following-sibling::td[@class='text-center pointer']//div[@class='dropdown open']//li[@ng-show='isDefined(task.customFormName)']";
			driver.findElement(By.xpath(jumptoOption)).click();
			consoleMessage("Clicked on the jump to custom form option.");

			// wait for the element
			Thread.sleep(10000);

			// scroll up to top
			scrollTop();

			// validate the custom form as a title
			try {
				String customName = "//h4[contains(text(),'" + name_s + "')]";
				String customName_actual = (driver.findElement(By.xpath(customName)).getText()).trim();

				if (customName_actual.equals(name_s)) {
					successMessage("The custom form name is displayed correctly.");
				} else {
					verificationFailedMessage("The custom form is not displayed.");
				}
			} catch (Throwable t) {
				verificationFailedMessage("The custom form is not displayed.");
			}

			// click on the details tab
			String details = "//span[text()='Details']";
			driver.findElement(By.xpath(details)).click();
			consoleMessage("Clicked on the details tab.");

			// scroll down to bottom
			scrollBottom();

			// validate the first field label
			try {
				String fieldLabel1 = "//label[contains(text(),'" + fieldName1_s + "')]";
				String fieldLabel1_actual = (driver.findElement(By.xpath(fieldLabel1)).getText()).trim();

				if (fieldLabel1_actual.equals(fieldName1_s + ":")) {
					successMessage("The first field label is displayed successfully.");
				} else {
					verificationFailedMessage("The first field label is not displayed.");
				}
			} catch (Throwable t) {
				verificationFailedMessage("The first field label is not displayed.");
			}

			// validate the second field label
			try {
				String fieldLabel2 = "//label[contains(text(),'" + fieldName2_s + "')]";
				String fieldLabel2_actual = (driver.findElement(By.xpath(fieldLabel2)).getText()).trim();

				if (fieldLabel2_actual.equals(fieldName2_s + ":")) {
					successMessage("The second field label is displayed successfully.");
				} else {
					verificationFailedMessage("The second field label is not displayed.");
				}
			} catch (Throwable t) {
				verificationFailedMessage("The second field label is not displayed.");
			}

			// click on the first page name tab
			String pageTab1 = "//span[text()='" + pageName1_s + "']";
			driver.findElement(By.xpath(pageTab1)).click();
			consoleMessage("Clicked on the first page name tab.");

			// scroll to bottom
			scrollBottom();

			// validate the third field label
			try {
				String fieldLabel3 = "//label[contains(text(),'" + pageFieldName1_s + "')]";
				String fieldLabel3_actual = (driver.findElement(By.xpath(fieldLabel3)).getText()).trim();

				if (fieldLabel3_actual.equals(pageFieldName1_s + ":")) {
					successMessage("The third field label is displayed successfully.");
				} else {
					verificationFailedMessage("The third field label is not displayed.");
				}
			} catch (Throwable t) {
				verificationFailedMessage("The third field label is not displayed.");
			}

			// validate the forth field label
			try {
				String fieldLabel4 = "//label[contains(text(),'" + pageFieldName2_s + "')]";
				String fieldLabel4_actual = (driver.findElement(By.xpath(fieldLabel4)).getText()).trim();

				if (fieldLabel4_actual.equals(pageFieldName2_s + ":")) {
					successMessage("The forth field label is displayed successfully.");
				} else {
					verificationFailedMessage("The forth field label is not displayed.");
				}
			} catch (Throwable t) {
				verificationFailedMessage("The forth field label is not displayed.");
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

		// CREATE THE NEW TASK UNDER THE MULTIPLE TYPE CUSTOM FORM FROM PORTFOLIO
		// SUMMARY DASHBOARD
		title("CREATE THE NEW TASK UNDER THE MULTIPLE TYPE CUSTOM FORM FROM PORTFOLIO SUMMARY DASHBOARD");

		String taskTitle4 = RandomStringUtils.randomAlphabetic(8);

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

			// validate the newly created custom form in the property summary dashboard
			// screen
			try {
				String customForm1 = "//td[text()='" + name_m + "']";
				String customForm1_actual = (driver.findElement(By.xpath(customForm1)).getText()).trim();

				if (customForm1_actual.equals(name_m)) {
					successMessage("The newly created custom form is displayed successfully.");

				} else {
					verificationFailedMessage("The newly created custom form is not displayed.");
				}

			} catch (Throwable t) {
				verificationFailedMessage("The newly created custom form is not displayed.");
			}

			// click on the custom form
			String customForm1 = "//td[text()='" + name_m + "']";
			driver.findElement(By.xpath(customForm1)).click();
			consoleMessage("Clicked on the custom form.");

			// scroll to bottom
			scrollBottom();

			// click on the custom form details
			String customForm_m = "//span[text()='" + field1Detail_list_m.get(0) + "']";
			driver.findElement(By.xpath(customForm_m)).click();
			consoleMessage("Clicked on the custom form details.");

			// click on the action icon
			click("customform_propertydashboard_actionicon_XPATH");

			// click on the task option
			click("customform_propertydashboard_taskoption_XPATH");

			// scroll down to bottom
			scrollBottom();

			// click on the add task button
			click("customform_propertydashboard_newtaskbtn_XPATH");

			// enter the data in the task title field
			type("task_addtask_titletxt_CSS", taskTitle4);

			// enter the data in the task location field
			type("task_addtask_locationtxt_CSS", data.get("task_location"));

			// scroll down to bottom
			scrollBottom();

			// click on the assign to field
			click("task_assigntotxt_CSS");

			// click on the none button
			click("task_tasktag_nonebtn_CSS");

			// enter the user name in the search field
			type("workflowsecurity_editortask_taskdetails_searchtasktagtxt_CSS", data.get("search_user"));

			// click on the searched result
			click("questionnaire_createtask_selectusertxt_XPATH");

			// click on the assign to field
			click("task_assigntotxt_CSS");

			// click on the save button
			click("customform_propertydashboard_savebtn_XPATH");

			// validate the newly created task in the custom form in the property summary
			// dashboard screen
			try {
				String task1 = "//td[text()='" + taskTitle4 + "']";
				String task1_actual = (driver.findElement(By.xpath(task1)).getText()).trim();

				if (task1_actual.equals(taskTitle4)) {
					successMessage("The newly created task in the custom form is displayed successfully.");

				} else {
					verificationFailedMessage("The newly created task in the custom form is not displayed.");
				}

			} catch (Throwable t) {
				verificationFailedMessage("The newly created task in the custom form is not displayed.");
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

		// VALIDATE THE NEWLY CREATED TASK UNDER MULTIPLE TYPE CUSTOM FORM AND "JUMP TO
		// CUSTOM FORM" BUTTON IN THE TASK MODULE (PORTFOLIO SUMMARY DASHBOARD)
		title("VALIDATE THE NEWLY CREATED TASK UNDER MULTIPLE TYPE CUSTOM FORM AND \"JUMP TO CUSTOM FORM\" BUTTON IN THE TASK MODULE (PORTFOLIO SUMMARY DASHBOARD)");

		try {

			// wait for the element
			Thread.sleep(3000);

			// click on the task icon of the respective property
			click("taskicon_CSS");

			// click on the clear button
			click("task_createdtask_clearbtn_XPATH");

			// enter the data in the search field
			type("task_filter_CSS", taskTitle4);

			// click on the search button
			click("task_createdtask_searchbtn_XPATH");

			// verify newly created task is displayed or not
			try {
				String task = "//p[contains(text(),'" + taskTitle4 + "')]";
				String task_actual = (driver.findElement(By.xpath(task)).getText()).trim();

				if (task_actual.equals(taskTitle4)) {
					successMessage("The newly created task is verified successfully.");
				} else {
					verificationFailedMessage("The newly created task is not verified.");
				}
			} catch (Throwable t) {
				verificationFailedMessage("The newly created task is not verified.");
			}

			// click on the action icon
			String actionIcon = "//p[text()='" + taskTitle4
					+ "']//parent::td//following-sibling::td[@class='text-center pointer']//i[@data-toggle='dropdown']";
			driver.findElement(By.xpath(actionIcon)).click();
			consoleMessage("Clicked on the action icon.");

			// click on the jump to custom form option
			String jumptoOption = "//p[text()='" + taskTitle4
					+ "']//parent::td//following-sibling::td[@class='text-center pointer']//div[@class='dropdown open']//li[@ng-show='isDefined(task.customFormName)']";
			driver.findElement(By.xpath(jumptoOption)).click();
			consoleMessage("Clicked on the jump to custom form option.");

			// wait for the element
			Thread.sleep(10000);

			// scroll up to top
			scrollTop();

			// validate the custom form as a title
			try {
				String customName = "//h4[contains(text(),'" + name_m + "')]";
				String customName_actual = (driver.findElement(By.xpath(customName)).getText()).trim();

				if (customName_actual.equals(name_m)) {
					successMessage("The custom form name is displayed correctly.");
				} else {
					verificationFailedMessage("The custom form is not displayed.");
				}
			} catch (Throwable t) {
				verificationFailedMessage("The custom form is not displayed.");
			}

			// click on the details tab
			String details = "//span[text()='Details']";
			driver.findElement(By.xpath(details)).click();
			consoleMessage("Clicked on the details tab.");

			// scroll down to bottom
			scrollBottom();

			// validate the first field label
			try {
				String fieldLabel1 = "//label[contains(text(),'" + fieldName1_m + "')]";
				String fieldLabel1_actual = (driver.findElement(By.xpath(fieldLabel1)).getText()).trim();

				if (fieldLabel1_actual.equals(fieldName1_m + ":")) {
					successMessage("The first field label is displayed successfully.");
				} else {
					verificationFailedMessage("The first field label is not displayed.");
				}
			} catch (Throwable t) {
				verificationFailedMessage("The first field label is not displayed.");
			}

			// validate the second field label
			try {
				String fieldLabel2 = "//label[contains(text(),'" + fieldName2_m + "')]";
				String fieldLabel2_actual = (driver.findElement(By.xpath(fieldLabel2)).getText()).trim();

				if (fieldLabel2_actual.equals(fieldName2_m + ":")) {
					successMessage("The second field label is displayed successfully.");
				} else {
					verificationFailedMessage("The second field label is not displayed.");
				}
			} catch (Throwable t) {
				verificationFailedMessage("The second field label is not displayed.");
			}

			// click on the first page name tab
			String pageTab1 = "//span[text()='" + pageName1_m + "']";
			driver.findElement(By.xpath(pageTab1)).click();
			consoleMessage("Clicked on the first page name tab.");

			// scroll to bottom
			scrollBottom();

			// validate the third field label
			try {
				String fieldLabel3 = "//label[contains(text(),'" + pageFieldName1_m + "')]";
				String fieldLabel3_actual = (driver.findElement(By.xpath(fieldLabel3)).getText()).trim();

				if (fieldLabel3_actual.equals(pageFieldName1_m + ":")) {
					successMessage("The third field label is displayed successfully.");
				} else {
					verificationFailedMessage("The third field label is not displayed.");
				}
			} catch (Throwable t) {
				verificationFailedMessage("The third field label is not displayed.");
			}

			// validate the forth field label
			try {
				String fieldLabel4 = "//label[contains(text(),'" + pageFieldName2_m + "')]";
				String fieldLabel4_actual = (driver.findElement(By.xpath(fieldLabel4)).getText()).trim();

				if (fieldLabel4_actual.equals(pageFieldName2_m + ":")) {
					successMessage("The forth field label is displayed successfully.");
				} else {
					verificationFailedMessage("The forth field label is not displayed.");
				}
			} catch (Throwable t) {
				verificationFailedMessage("The forth field label is not displayed.");
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

		// DELETE THE NEWLY CREATED TASKS FROM THE PROPERTY LEVEL
		title("DELETE THE NEWLY CREATED TASKS FROM THE PROPERTY LEVEL");

		try {
			// click on the task icon of the respective property
			click("taskicon_CSS");

			String[] taskTitle = { taskTitle1, taskTitle2, taskTitle3, taskTitle4 };

			for (int i = 0; i < taskTitle.length; i++) {

				// click on the clear button
				click("task_createdtask_clearbtn_XPATH");

				// enter the data in the search field
				type("task_filter_CSS", taskTitle[i]);

				// click on the search button
				click("task_createdtask_searchbtn_XPATH");

				// verify newly created task is displayed or not
				try {
					String task = "//p[contains(text(),'" + taskTitle[i] + "')]";
					String task_actual = (driver.findElement(By.xpath(task)).getText()).trim();

					if (task_actual.equals(taskTitle[i])) {

						successMessage("The newly created task is verified successfully.");

					} else {
						verificationFailedMessage("The newly created task is not verified.");
					}
				} catch (Throwable t) {
					verificationFailedMessage("The newly created task is not verified.");
				}

				// click on the action icon
				String actionIcon = "//p[text()='" + taskTitle[i]
						+ "']//parent::td//following-sibling::td[@class='text-center pointer']//i[@data-toggle='dropdown']";
				driver.findElement(By.xpath(actionIcon)).click();
				consoleMessage("Clicked on the action icon.");

				// click on the delete option
				String deleteOption = "//p[text()='" + taskTitle[i]
						+ "']//parent::td//following-sibling::td[@class='text-center pointer']//div[@class='dropdown open']//li[@ng-click='deleteSelectedTask(task.id, false);']";
				driver.findElement(By.xpath(deleteOption)).click();
				consoleMessage("Clicked on the delete option.");

				// wait for the element
				explicitWaitClickable("closetoastmsg_CSS");

				// click on the toaster close button
				click("closetoastmsg_CSS");

				// click on the clear button
				click("task_createdtask_clearbtn_XPATH");

				// enter the data in the search field
				type("task_filter_CSS", taskTitle[i]);

				// click on the search button
				click("task_createdtask_searchbtn_XPATH");

				// validate the deleted task
				try {
					String task = "//p[contains(text(),'" + taskTitle[i] + "')]";
					String task_actual = (driver.findElement(By.xpath(task)).getText()).trim();

					if (task_actual.equals(taskTitle[i])) {
						verificationFailedMessage("The newly created task is not deleted.");
					} else {
						successMessage("The newly created task is deleted successfully.");
					}
				} catch (Throwable t) {
					successMessage("The newly created task is deleted successfully.");
				}

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

		// DELETE THE NEWLY CREATED SUNGLE TYPE AND MULTIPLE TYPE CUSTOMER FORM
		title("DELETE THE NEWLY CREATED SUNGLE TYPE AND MULTIPLE TYPE CUSTOMER FORM");

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
			String deleteIcon = "//td[text()='" + name_s
					+ "']//following-sibling::td[@class='pointer']//i[@data-target='#deleteCustomFormModal']";
			driver.findElement(By.xpath(deleteIcon)).click();
			consoleMessage("click on the delete button of the newly created custom form.");

			// wait for the element
			Thread.sleep(5000);

			// click on the delete button
			click("customform_deletebtn_XPATH");

			// wait for the element
			Thread.sleep(3000);

			// validate the deleted custom form
			try {
				String customform = "//td[text()='" + name_s + "']";
				String customform_actual = (driver.findElement(By.xpath(customform)).getText()).trim();

				if (customform_actual.equals(name_s)) {
					verificationFailedMessage("The deleted custom form is displayed.");
				} else {
					successMessage("The deleted custom form is not displayed as expected.");
				}
			} catch (Throwable t) {
				successMessage("The deleted custom form is not displayed as expected.");
			}

			// wait for the element
			Thread.sleep(5000);

			// click on the delete button of the newly created custom form
			String deleteIcon_m = "//td[text()='" + name_m
					+ "']//following-sibling::td[@class='pointer']//i[@data-target='#deleteCustomFormModal']";
			driver.findElement(By.xpath(deleteIcon_m)).click();
			consoleMessage("click on the delete button of the newly created custom form.");

			// wait for the element
			Thread.sleep(5000);

			// click on the delete button
			click("customform_deletebtn_XPATH");

			// wait for the element
			Thread.sleep(3000);

			// validate the deleted custom form
			try {
				String customform = "//td[text()='" + name_m + "']";
				String customform_actual = (driver.findElement(By.xpath(customform)).getText()).trim();

				if (customform_actual.equals(name_m)) {
					verificationFailedMessage("The deleted custom form is displayed.");
				} else {
					successMessage("The deleted custom form is not displayed as expected.");
				}
			} catch (Throwable t) {
				successMessage("The deleted custom form is not displayed as expected.");
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
