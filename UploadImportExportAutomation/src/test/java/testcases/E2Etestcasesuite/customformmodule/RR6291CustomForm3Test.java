package testcases.E2Etestcasesuite.customformmodule;

import java.io.File;
import java.io.IOException;
import java.util.Hashtable;

import org.apache.commons.lang3.RandomStringUtils;
import org.openqa.selenium.By;
import org.testng.annotations.Test;

import base.TestBase;
import utilities.ExcelReader;
import utilities.TestUtil;

public class RR6291CustomForm3Test extends TestBase {

	@Test(dataProviderClass = TestUtil.class, dataProvider = "dp")
	public void rR6291CustomForm3Test(Hashtable<String, String> data) throws IOException, InterruptedException {

		execution(data, "rR6291CustomForm3Test");

		// PERFORM EXPORT AND IMPORT FUNCTIONALITY OF CUSTOM FORMS AT PROPERTY SUMMARY
		// DASHBOARD - SINGLE TYPE

		title("PERFORM EXPORT AND IMPORT FUNCTIONALITY OF CUSTOM FORMS AT PROPERTY SUMMARY DASHBOARD - SINGLE TYPE");

		// refresh the page
		driver.navigate().refresh();
		Thread.sleep(5000);
		driver.navigate().refresh();

		System.out.println("Navigate to the Home Screen i.e. Property List Screen.");

		String fieldName1 = RandomStringUtils.randomAlphanumeric(8); // Normal Field 1
		String fieldName2 = RandomStringUtils.randomAlphanumeric(8); // Normal Field 2
		String pageName1 = RandomStringUtils.randomAlphanumeric(8); // Page Name 1
		String pageName2 = RandomStringUtils.randomAlphanumeric(8); // Page Name 2
		String pageFieldName1 = RandomStringUtils.randomAlphanumeric(8); // Page Name 1 - Field 1
		String pageFieldName2 = RandomStringUtils.randomAlphanumeric(8); // Page Name 1 - Field 2
		String pageFieldName3 = RandomStringUtils.randomAlphanumeric(8); // Page Name 2 - Field 1
		String pageFieldName4 = RandomStringUtils.randomAlphanumeric(8); // Page Name 2 - Field 2

		// variables of the normal field one for the 3 properties
		String property1_Field1 = RandomStringUtils.randomAlphabetic(8);

		// variables of the normal field two for the 3 properties
		String property1_Field2 = RandomStringUtils.randomNumeric(3);

		// variables of the page one field one for the 3 properties
		String property1_Page1Field1 = RandomStringUtils.randomAlphabetic(8);

		// variables of the page one field two for the 3 properties
		String property1_Page1Field2 = RandomStringUtils.randomNumeric(3);

		// variables of the page two field one for the 3 properties
		String property1_Page2Field1 = RandomStringUtils.randomAlphabetic(8);

		// variables of the page two field two for the 3 properties
		String property1_Page2Field2 = RandomStringUtils.randomNumeric(3);

		// CREATE NEW CUSTOM FORMS FOR SINGLE RECORD TYPE

		title("CREATE NEW CUSTOM FORMS FOR SINGLE RECORD TYPE");

		try {

			// Wait for the element
			Thread.sleep(5000);

			// click on the settings icon from the top of the screen
			click("questionnaire_settingicon_CSS");
			System.out.println("Clicked on the settings icon.");
			ngDriver.waitForAngularRequestsToFinish();

			// wait for the element
			explicitWaitClickable("questionnaire_administrationoption_XPATH");

			// click on the Administration option from the side menu
			click("questionnaire_administrationoption_XPATH");
			System.out.println("Clicked on the Administration option from the side menu.");
			ngDriver.waitForAngularRequestsToFinish();

			// click on the system tab
			click("questionnaire_systemtab_XPATH");
			System.out.println("Clicked on the system tab.");
			ngDriver.waitForAngularRequestsToFinish();

			// click on the custom form option
			click("customform_option_XPATH");
			System.out.println("Clicked on the custom form option.");
			ngDriver.waitForAngularRequestsToFinish();

			// click on the add button
			click("customform_addbtn_XPATH");
			ngDriver.waitForAngularRequestsToFinish();
			System.out.println("Clicked on the add button.");

			// enter name of the form in the name field
			type("customform_nametxt_XPATH", data.get("name"));
			ngDriver.waitForAngularRequestsToFinish();
			System.out.println("Entered name of the form in the name field.");

			// select the single report type from the drop down
			select("customform_recordtypedd_XPATH", data.get("type_1"));
			ngDriver.waitForAngularRequestsToFinish();
			System.out.println("Selected the single report type from the drop down.");

			// click on the date sensitive checkbox
			click("customform_datesensitiveckbx_XPATH");
			ngDriver.waitForAngularRequestsToFinish();
			System.out.println("Clicked on the date sensitive checkbox.");

			// click on the Is Verification Workflow Enabled? checkbox
			click("customform_verificationckbx_XPATH");
			ngDriver.waitForAngularRequestsToFinish();
			System.out.println("Clicked on the Is Verification Workflow Enabled? checkbox.");

			// click on the save button
			click("customform_savebtn_XPATH");
			ngDriver.waitForAngularRequestsToFinish();
			System.out.println("Clicked on the save button.");

			// wait for the element
			Thread.sleep(5000);

			// validate the Report Name details of the newly created report
			try {
				String Validation0 = "//td[text()='" + data.get("name") + "']";
				String Validation0_actual = (driver.findElement(By.xpath(Validation0)).getText()).trim();

				if (Validation0_actual.equals(data.get("name"))) {

					successMessage("The Report Name detail is displayed correctly.");

				} else {
					verificationFailedMessage("The Report Name detail is displayed correctly.");
				}

			} catch (Throwable t) {
				verificationFailedMessage("The Report Name detail is displayed correctly.");
			}

			// click on the newly created custom record record
			String nameTitle = "//td[text()='" + data.get("name") + "']";
			driver.findElement(By.xpath(nameTitle)).click();
			ngDriver.waitForAngularRequestsToFinish();
			System.out.println("Clicked on the newly created custom record record.");

			// click on the add field button
			click("customform_addfieldbtn_XPATH");
			ngDriver.waitForAngularRequestsToFinish();
			System.out.println("Clicked on the add field button.");

			// enter field name
			type("customform_addfield_nametxt_XPATH", fieldName1);
			ngDriver.waitForAngularRequestsToFinish();
			System.out.println("Entered field name.");

			// select the option from the type dropdown
			select("customform_addfield_typedd_XPATH", data.get("fieldtype_1"));
			ngDriver.waitForAngularRequestsToFinish();
			System.out.println("Selected the option from the type dropdown.");

			// click on the display on list checkbox
			click("customform_addfield_displayonlistckbx_XPATH");
			ngDriver.waitForAngularRequestsToFinish();
			System.out.println("Clicked on the display on list checkbox.");

			// click on the unique identifier checkbox
			click("customform_addfield_uniqueidentifierckbx_XPATH");
			ngDriver.waitForAngularRequestsToFinish();
			System.out.println("Clicked on the unique identifier checkbox.");

			// click on the add button
			click("customform_addfield_addbtn_XPATH");
			ngDriver.waitForAngularRequestsToFinish();
			System.out.println("Clicked on the add button.");

			// wait for the element
			explicitWaitClickable("closetoastmsg_CSS");

			// click on the toaster close button
			click("closetoastmsg_CSS");
			ngDriver.waitForAngularRequestsToFinish();
			System.out.println("Clicked on the toaster close button.");

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
			ngDriver.waitForAngularRequestsToFinish();
			System.out.println("Clicked on the add field button.");

			// enter field name
			clear("customform_addfield_nametxt_XPATH");
			type("customform_addfield_nametxt_XPATH", fieldName2);
			ngDriver.waitForAngularRequestsToFinish();
			System.out.println("Entered field name.");

			// select the option from the type dropdown
			select("customform_addfield_typedd_XPATH", data.get("fieldtype_2"));
			ngDriver.waitForAngularRequestsToFinish();
			System.out.println("Selected the option from the type dropdown.");

			// click on the display on list checkbox
			click("customform_addfield_displayonlistckbx_XPATH");
			ngDriver.waitForAngularRequestsToFinish();
			System.out.println("Clicked on the display on list checkbox.");

			// click on the unique identifier checkbox
			click("customform_addfield_uniqueidentifierckbx_XPATH");
			ngDriver.waitForAngularRequestsToFinish();
			System.out.println("Clicked on the unique identifier checkbox.");

			// click on the add button
			click("customform_addfield_addbtn_XPATH");
			ngDriver.waitForAngularRequestsToFinish();
			System.out.println("Clicked on the add button.");

			// wait for the element
			explicitWaitClickable("closetoastmsg_CSS");

			// click on the toaster close button
			click("closetoastmsg_CSS");
			ngDriver.waitForAngularRequestsToFinish();
			System.out.println("Clicked on the toaster close button.");

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
			ngDriver.waitForAngularRequestsToFinish();
			System.out.println("Clicked on the add new page icon.");

			// enter the first page name name in the page name field
			clear("customform_portfoliodashboard_pagenametxt_XPATH");
			type("customform_portfoliodashboard_pagenametxt_XPATH", pageName1);
			ngDriver.waitForAngularRequestsToFinish();
			System.out.println("Entered the first page name name in the page name field.");

			// click on the add button
			click("customform_portfoliodashboard_pagename_addbtn_XPATH");
			ngDriver.waitForAngularRequestsToFinish();
			System.out.println("Clicked on the add button.");

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

			// enter the second page name name in the page name field
			clear("customform_portfoliodashboard_pagenametxt_XPATH");
			type("customform_portfoliodashboard_pagenametxt_XPATH", pageName2);
			ngDriver.waitForAngularRequestsToFinish();
			System.out.println("Entered the second page name name in the page name field.");

			// click on the add button
			click("customform_portfoliodashboard_pagename_addbtn_XPATH");
			ngDriver.waitForAngularRequestsToFinish();
			System.out.println("Clicked on the add button.");

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

			// click on the update button
			click("customform_updatebtn_XPATH");
			ngDriver.waitForAngularRequestsToFinish();
			System.out.println("Clicked on the update button.");

			// wait for the element
			explicitWaitClickable("closetoastmsg_CSS");

			// click on the toaster close button
			click("closetoastmsg_CSS");
			ngDriver.waitForAngularRequestsToFinish();
			System.out.println("Clicked on the toaster close button.");

			// ADD FIELDS IN THE PAGE ONE
			title("ADD FIELDS IN THE PAGE ONE");

			// click on the first page name tab
			String page1 = "//span[contains(text(),'" + pageName1 + "')]";
			driver.findElement(By.xpath(page1)).click();
			ngDriver.waitForAngularRequestsToFinish();
			System.out.println("Clicked on the first page name tab.");

			// click on the add field button
			click("customform_addfieldbtn_XPATH");
			ngDriver.waitForAngularRequestsToFinish();
			System.out.println("Clicked on the add field button.");

			// enter field name
			type("customform_addfield_nametxt_XPATH", pageFieldName1);
			ngDriver.waitForAngularRequestsToFinish();
			System.out.println("Entered field name.");

			// select the option from the type dropdown
			select("customform_addfield_typedd_XPATH", data.get("fieldtype_1"));
			ngDriver.waitForAngularRequestsToFinish();
			System.out.println("Selected the option from the type dropdown.");

			// click on the display on list checkbox
			click("customform_addfield_displayonlistckbx_XPATH");
			ngDriver.waitForAngularRequestsToFinish();
			System.out.println("Clicked on the display on list checkbox.");

			// click on the unique identifier checkbox
			click("customform_addfield_uniqueidentifierckbx_XPATH");
			ngDriver.waitForAngularRequestsToFinish();
			System.out.println("Clicked on the unique identifier checkbox.");

			// click on the add button
			click("customform_addfield_addbtn_XPATH");
			ngDriver.waitForAngularRequestsToFinish();
			System.out.println("Clicked on the add button.");

			// wait for the element
			explicitWaitClickable("closetoastmsg_CSS");

			// click on the toaster close button
			click("closetoastmsg_CSS");
			ngDriver.waitForAngularRequestsToFinish();
			System.out.println("Clicked on the toaster close button.");

			// click on the first page name tab
			String page11 = "//span[contains(text(),'" + pageName1 + "')]";
			driver.findElement(By.xpath(page11)).click();
			ngDriver.waitForAngularRequestsToFinish();
			System.out.println("Clicked on the first page name tab.");

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
			ngDriver.waitForAngularRequestsToFinish();
			System.out.println("Clicked on the add field button.");

			// enter field name
			clear("customform_addfield_nametxt_XPATH");
			type("customform_addfield_nametxt_XPATH", pageFieldName2);
			ngDriver.waitForAngularRequestsToFinish();
			System.out.println("Entered field name.");

			// select the option from the type dropdown
			select("customform_addfield_typedd_XPATH", data.get("fieldtype_2"));
			ngDriver.waitForAngularRequestsToFinish();
			System.out.println("Selected the option from the type dropdown.");

			// click on the display on list checkbox
			click("customform_addfield_displayonlistckbx_XPATH");
			ngDriver.waitForAngularRequestsToFinish();
			System.out.println("Clicked on the display on list checkbox.");

			// click on the unique identifier checkbox
			click("customform_addfield_uniqueidentifierckbx_XPATH");
			ngDriver.waitForAngularRequestsToFinish();
			System.out.println("Clicked on the unique identifier checkbox.");

			// click on the add button
			click("customform_addfield_addbtn_XPATH");
			ngDriver.waitForAngularRequestsToFinish();
			System.out.println("Clicked on the add button.");

			// wait for the element
			explicitWaitClickable("closetoastmsg_CSS");

			// click on the toaster close button
			click("closetoastmsg_CSS");
			ngDriver.waitForAngularRequestsToFinish();
			System.out.println("Clicked on the toaster close button.");

			// click on the first page name tab
			String page111 = "//span[contains(text(),'" + pageName1 + "')]";
			driver.findElement(By.xpath(page111)).click();
			ngDriver.waitForAngularRequestsToFinish();
			System.out.println("Clicked on the first page name tab.");

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

			// click on the second page name tab
			String page2 = "//span[contains(text(),'" + pageName2 + "')]";
			driver.findElement(By.xpath(page2)).click();
			ngDriver.waitForAngularRequestsToFinish();
			System.out.println("Clicked on the second page name tab.");

			// click on the add field button
			click("customform_addfieldbtn_XPATH");
			ngDriver.waitForAngularRequestsToFinish();
			System.out.println("Clicked on the add field button.");

			// enter field name
			type("customform_addfield_nametxt_XPATH", pageFieldName3);
			ngDriver.waitForAngularRequestsToFinish();
			System.out.println("Entered field name.");

			// select the option from the type dropdown
			select("customform_addfield_typedd_XPATH", data.get("fieldtype_1"));
			ngDriver.waitForAngularRequestsToFinish();
			System.out.println("Selected the option from the type dropdown.");

			// click on the display on list checkbox
			click("customform_addfield_displayonlistckbx_XPATH");
			ngDriver.waitForAngularRequestsToFinish();
			System.out.println("Clicked on the display on list checkbox.");

			// click on the unique identifier checkbox
			click("customform_addfield_uniqueidentifierckbx_XPATH");
			ngDriver.waitForAngularRequestsToFinish();
			System.out.println("Clicked on the unique identifier checkbox.");

			// click on the add button
			click("customform_addfield_addbtn_XPATH");
			ngDriver.waitForAngularRequestsToFinish();
			System.out.println("Clicked on the add button.");

			// wait for the element
			explicitWaitClickable("closetoastmsg_CSS");

			// click on the toaster close button
			click("closetoastmsg_CSS");
			ngDriver.waitForAngularRequestsToFinish();
			System.out.println("Clicked on the toaster close button.");

			// click on the second page name tab
			String page22 = "//span[contains(text(),'" + pageName2 + "')]";
			driver.findElement(By.xpath(page22)).click();
			ngDriver.waitForAngularRequestsToFinish();
			System.out.println("Clicked on the second page name tab.");

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
			ngDriver.waitForAngularRequestsToFinish();
			System.out.println("Clicked on the add field button.");

			// enter field name
			clear("customform_addfield_nametxt_XPATH");
			type("customform_addfield_nametxt_XPATH", pageFieldName4);
			ngDriver.waitForAngularRequestsToFinish();
			System.out.println("Entered field name.");

			// select the option from the type dropdown
			select("customform_addfield_typedd_XPATH", data.get("fieldtype_2"));
			ngDriver.waitForAngularRequestsToFinish();
			System.out.println("Selected the option from the type dropdown.");

			// click on the display on list checkbox
			click("customform_addfield_displayonlistckbx_XPATH");
			ngDriver.waitForAngularRequestsToFinish();
			System.out.println("Clicked on the display on list checkbox.");

			// click on the unique identifier checkbox
			click("customform_addfield_uniqueidentifierckbx_XPATH");
			ngDriver.waitForAngularRequestsToFinish();
			System.out.println("Clicked on the unique identifier checkbox.");

			// click on the add button
			click("customform_addfield_addbtn_XPATH");
			ngDriver.waitForAngularRequestsToFinish();
			System.out.println("Clicked on the add button.");

			// wait for the element
			explicitWaitClickable("closetoastmsg_CSS");

			// click on the toaster close button
			click("closetoastmsg_CSS");
			ngDriver.waitForAngularRequestsToFinish();
			System.out.println("Clicked on the toaster close button.");

			// click on the second page name tab
			String page222 = "//span[contains(text(),'" + pageName2 + "')]";
			driver.findElement(By.xpath(page222)).click();
			ngDriver.waitForAngularRequestsToFinish();
			System.out.println("Clicked on the second page name tab.");

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
			ngDriver.waitForAngularRequestsToFinish();
			System.out.println("Clicked on the update button.");

			// wait for the element
			explicitWaitClickable("closetoastmsg_CSS");

			// click on the toaster close button
			click("closetoastmsg_CSS");
			ngDriver.waitForAngularRequestsToFinish();
			System.out.println("Clicked on the toaster close button.");

		} catch (Throwable t) {
			verificationFailed();
		}

		// click on the home icon from the top of the screen
		click("questionnaire_homeburgermenubtn_CSS");
		System.out.println("Clicked on the home icon from the top of the screen.");
		ngDriver.waitForAngularRequestsToFinish();

		// wait for the element
		explicitWait("propertylist_title_XPATH");

		// verify the property list
		switchVerification("propertylist_title_XPATH", "Property List", "The property list is not displayed.");

		// VALIDATE THE FIELDS AND PAGES OF THE CUSTOM REPORT FROM THE PROPERTY SUMMARY
		// DASHBOARD

		title("VALIDATE THE FIELDS AND PAGES OF THE CUSTOM REPORT FROM THE PROPERTY SUMMARY DASHBOARD");

		try {

			// wait for the element
			Thread.sleep(5000);

			// click on the property
			click("propertysummary_property1_XPATH");
			ngDriver.waitForAngularRequestsToFinish();
			System.out.println("Clicked on the property.");

			// scrolldown till Property Information section
			scrollTillElement("customform_portfoliodashboard_propertyinformationtitle_XPATH");

			// validate the newly created custom form in the portfolio dashboard screen
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
			ngDriver.waitForAngularRequestsToFinish();
			System.out.println("Clicked on the custom form.");

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
			ngDriver.waitForAngularRequestsToFinish();
			System.out.println("Clicked on the first page name tab.");

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
			ngDriver.waitForAngularRequestsToFinish();
			System.out.println("Clicked on the second page name tab.");

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
		System.out.println("Clicked on the home icon from the top of the screen.");
		ngDriver.waitForAngularRequestsToFinish();

		// wait for the element
		explicitWait("propertylist_title_XPATH");

		// verify the property list
		switchVerification("propertylist_title_XPATH", "Property List", "The property list is not displayed.");

		// ADD THE DETAILS IN THE FIELDS OF THE PROPERTY ONE OF THE CUSTOM FORMS FROM
		// THE PROPERTY SUMMARY DASHBOARD

		title("ADD THE DETAILS IN THE FIELDS OF THE PROPERTY ONE OF THE CUSTOM FORMS FROM THE PROPERTY SUMMARY DASHBOARD");

		try {

			// wait for the element
			Thread.sleep(5000);

			// click on the property
			click("propertysummary_property1_XPATH");
			ngDriver.waitForAngularRequestsToFinish();
			System.out.println("Clicked on the property.");

			// scrolldown till Property Information section
			scrollTillElement("customform_portfoliodashboard_propertyinformationtitle_XPATH");

			// validate the newly created custom form in the portfolio dashboard screen
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
			ngDriver.waitForAngularRequestsToFinish();
			System.out.println("Clicked on the custom form.");

			// ADD THE DETAILS IN THE FIELDS OF THE DETAILS TAB
			title("ADD THE DETAILS IN THE FIELDS OF THE DETAILS TAB");

			// scroll down the screen
			scrollBottom();

			// click on the edit field button
			click("customform_portfoliodashboard_editfieldbtn_XPATH");
			ngDriver.waitForAngularRequestsToFinish();
			System.out.println("Clicked on the edit field button.");

			// enter the details in the first field
			String firstField = "//input[@id='" + fieldName1 + "TEXT']";
			driver.findElement(By.xpath(firstField)).sendKeys(data.get("first_field"));
			ngDriver.waitForAngularRequestsToFinish();
			System.out.println("Entered the details in the first field.");

			// enter the details in the second field
			String secondField = "//input[@id='" + fieldName2 + "NUMBER']";
			driver.findElement(By.xpath(secondField)).sendKeys("123");
			ngDriver.waitForAngularRequestsToFinish();
			System.out.println("Entered the details in the second field.");

			// scroll down the screen
			scrollBottom();

			// click on the save button
			click("customform_portfoliodashboard_fields_savebtn_XPATH");
			ngDriver.waitForAngularRequestsToFinish();
			System.out.println("Clicked on the save button.");

			// scroll down the screen
			scrollBottom();

			// wait for the element
			Thread.sleep(2000);

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
			ngDriver.waitForAngularRequestsToFinish();
			System.out.println("Clicked on the first page name tab.");

			// ADD THE DETAILS IN THE FIELDS OF THE FIRST PAGE TAB

			title("ADD THE DETAILS IN THE FIELDS OF THE FIRST PAGE TAB");

			// scroll down the screen
			scrollBottom();

			// click on the edit field button
			click("customform_portfoliodashboard_editfieldbtn_XPATH");
			ngDriver.waitForAngularRequestsToFinish();
			System.out.println("Clicked on the edit field button.");

			// enter the details in the first field
			String firstPageField = "//input[@id='" + pageFieldName1 + "TEXT']";
			driver.findElement(By.xpath(firstPageField)).sendKeys(data.get("first_page_field1"));
			ngDriver.waitForAngularRequestsToFinish();
			System.out.println("Entered the details in the first field.");

			// enter the details in the second field
			String secondPageField = "//input[@id='" + pageFieldName2 + "NUMBER']";
			driver.findElement(By.xpath(secondPageField)).sendKeys("456");
			ngDriver.waitForAngularRequestsToFinish();
			System.out.println("Entered the details in the second field.");

			// scroll down the screen
			scrollBottom();

			// click on the save button
			click("customform_portfoliodashboard_fields_savebtn_XPATH");
			ngDriver.waitForAngularRequestsToFinish();
			System.out.println("Clicked on the save button.");

			// scroll down the screen
			scrollBottom();

			// wait for the element
			Thread.sleep(2000);

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
			ngDriver.waitForAngularRequestsToFinish();
			System.out.println("Clicked on the second page name tab.");

			// ADD THE DETAILS IN THE FIELDS OF THE SECOND PAGE TAB

			title("ADD THE DETAILS IN THE FIELDS OF THE SECOND PAGE TAB");

			// scroll down the screen
			scrollBottom();

			// click on the edit field button
			click("customform_portfoliodashboard_editfieldbtn_XPATH");
			ngDriver.waitForAngularRequestsToFinish();
			System.out.println("Clicked on the edit field button.");

			// enter the details in the first field
			String thirdPageField = "//input[@id='" + pageFieldName3 + "TEXT']";
			driver.findElement(By.xpath(thirdPageField)).sendKeys(data.get("second_page_field1"));
			ngDriver.waitForAngularRequestsToFinish();
			System.out.println("Entered the details in the first field.");

			// enter the details in the second field
			String fourthPageField = "//input[@id='" + pageFieldName4 + "NUMBER']";
			driver.findElement(By.xpath(fourthPageField)).sendKeys("789");
			ngDriver.waitForAngularRequestsToFinish();
			System.out.println("Entered the details in the second field.");

			// scroll down the screen
			scrollBottom();

			// click on the save button
			click("customform_portfoliodashboard_fields_savebtn_XPATH");
			ngDriver.waitForAngularRequestsToFinish();
			System.out.println("Clicked on the save button.");

			// scroll down the screen
			scrollBottom();

			// wait for the element
			Thread.sleep(2000);

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
		System.out.println("Clicked on the home icon from the top of the screen.");
		ngDriver.waitForAngularRequestsToFinish();

		// wait for the element
		explicitWait("propertylist_title_XPATH");

		// verify the property list
		switchVerification("propertylist_title_XPATH", "Property List", "The property list is not displayed.");

		// PERFORM THE EXPORT AND IMPORT FUNCTIONALITY OF THE CUSTOM FORMS FROM THE
		// PORTFOLIO SUMMARY DASHBOARD

		title("PERFORM THE EXPORT AND IMPORT FUNCTIONALITY OF THE CUSTOM FORMS FROM THE PORTFOLIO SUMMARY DASHBOARD");

		try {

			// wait for the element
			Thread.sleep(5000);

			// click on the property
			click("propertysummary_property1_XPATH");
			ngDriver.waitForAngularRequestsToFinish();
			System.out.println("Clicked on the property.");

			// scrolldown till Property Information section
			scrollTillElement("customform_portfoliodashboard_propertyinformationtitle_XPATH");

			// validate the newly created custom form in the portfolio dashboard screen
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
			ngDriver.waitForAngularRequestsToFinish();
			System.out.println("Clicked on the custom form.");

			// click on the action icon
			click("customform_portfoliodashboard_actionicon_XPATH");
			ngDriver.waitForAngularRequestsToFinish();
			System.out.println("Clicked on the action icon.");

			// click on the export option
			click("customform_portfoliodashboard_actionicon_exportoption_XPATH");
			ngDriver.waitForAngularRequestsToFinish();
			System.out.println("Clicked on the export option.");

			// wait for the element
			Thread.sleep(5000);

			// fetch the record from the download file

			// wait for the element
			Thread.sleep(15000);

			File downloaded = getLastModified("C:\\Users\\Jinesh\\Downloads");
			String path_string = downloaded.toString();
			System.out.println(path_string);

			ExcelReader file = new ExcelReader(path_string);

			// add the details of the first normal fields
			file.setCellData("Sheet0", fieldName1, 2, property1_Field1);

			// add the details of the second normal fields
			file.setCellData("Sheet0", fieldName2, 2, property1_Field2);

			// add the details of the first fields of the page one
			file.setCellData("Sheet0", pageFieldName1, 2, property1_Page1Field1);

			// add the details of the second fields of the page one
			file.setCellData("Sheet0", pageFieldName2, 2, property1_Page1Field2);

			// add the details of the first fields of the page two
			file.setCellData("Sheet0", pageFieldName3, 2, property1_Page2Field1);

			// add the details of the second fields of the page two
			file.setCellData("Sheet0", pageFieldName4, 2, property1_Page2Field2);

			// wait for the element
			Thread.sleep(5000);

			// click on the action icon
			click("customform_portfoliodashboard_actionicon_XPATH");
			ngDriver.waitForAngularRequestsToFinish();
			System.out.println("Clicked on the action icon.");

			// wait for the element
			Thread.sleep(5000);

			// click on the import option
			click("customform_portfoliodashboard_actionicon_importoption_XPATH");

			// import the file
			uploadFile(path_string);

			// wait for the element
			Thread.sleep(10000);

			// VALIDATE THE FIELDS DETAIL AT PROPERTY LEVEL - PROPERTY ONE

			title("VALIDATE THE FIELDS DETAIL AT PROPERTY LEVEL - PROPERTY ONE");

			// validate the details of the first field
			try {
				String p1Field1 = "//label[contains(text(),'" + fieldName1 + ":"
						+ "')]//following-sibling::div//span[contains(text(),'" + property1_Field1 + "')]";
				String p1Field1_actual = (driver.findElement(By.xpath(p1Field1)).getText()).trim();

				if (p1Field1_actual.equals(property1_Field1)) {
					successMessage("The details of the first field is displayed successfully.");
				} else {
					verificationFailedMessage("The details of the first field is not displayed.");
				}
			} catch (Throwable t) {
				verificationFailedMessage("The details of the first field is not displayed.");
			}

			// validate the details of the second field
			try {
				String p1Field2 = "//label[contains(text(),'" + fieldName2 + ":"
						+ "')]//following-sibling::div//span[contains(text(),'" + property1_Field2 + "')]";
				String p1Field2_actual = (driver.findElement(By.xpath(p1Field2)).getText()).trim();

				if (p1Field2_actual.equals(property1_Field2)) {
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
			ngDriver.waitForAngularRequestsToFinish();
			System.out.println("Clicked on the first page name tab.");

			// validate the details of the first field of the first page
			try {
				String p1Page1Field1 = "//label[contains(text(),'" + pageFieldName1 + ":"
						+ "')]//following-sibling::div//span[contains(text(),'" + property1_Page1Field1 + "')]";
				String p1Page1Field1_actual = (driver.findElement(By.xpath(p1Page1Field1)).getText()).trim();

				if (p1Page1Field1_actual.equals(property1_Page1Field1)) {
					successMessage("The details of the first field of the first page is displayed successfully.");
				} else {
					verificationFailedMessage("The details of the first field of the first page is not displayed.");
				}
			} catch (Throwable t) {
				verificationFailedMessage("The details of the first field of the first page is not displayed.");
			}

			// validate the details of the second field of the first page
			try {
				String p1Page1Field2 = "//label[contains(text(),'" + pageFieldName2 + ":"
						+ "')]//following-sibling::div//span[contains(text(),'" + property1_Page1Field2 + "')]";
				String p1Page1Field2_actual = (driver.findElement(By.xpath(p1Page1Field2)).getText()).trim();

				if (p1Page1Field2_actual.equals(property1_Page1Field2)) {
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
			ngDriver.waitForAngularRequestsToFinish();
			System.out.println("Clicked on the second page name tab.");

			// validate the details of the first field of the second page
			try {
				String p1Page2Field1 = "//label[contains(text(),'" + pageFieldName3 + ":"
						+ "')]//following-sibling::div//span[contains(text(),'" + property1_Page2Field1 + "')]";
				String p1Page2Field1_actual = (driver.findElement(By.xpath(p1Page2Field1)).getText()).trim();

				if (p1Page2Field1_actual.equals(property1_Page2Field1)) {
					successMessage("The details of the first field of the second page is displayed successfully.");
				} else {
					verificationFailedMessage("The details of the first field of the second page is not displayed.");
				}
			} catch (Throwable t) {
				verificationFailedMessage("The details of the first field of the second page is not displayed.");
			}

			// validate the details of the second field of the second page
			try {
				String p1Page2Field2 = "//label[contains(text(),'" + pageFieldName4 + ":"
						+ "')]//following-sibling::div//span[contains(text(),'" + property1_Page2Field2 + "')]";
				String p1Page2Field2_actual = (driver.findElement(By.xpath(p1Page2Field2)).getText()).trim();

				if (p1Page2Field2_actual.equals(property1_Page2Field2)) {
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
		System.out.println("Clicked on the home icon from the top of the screen.");
		ngDriver.waitForAngularRequestsToFinish();

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
			System.out.println("Clicked on the settings icon.");
			ngDriver.waitForAngularRequestsToFinish();

			// wait for the element
			explicitWaitClickable("questionnaire_administrationoption_XPATH");

			// click on the Administration option from the side menu
			click("questionnaire_administrationoption_XPATH");
			System.out.println("Clicked on the Administration option from the side menu.");
			ngDriver.waitForAngularRequestsToFinish();

			// click on the system tab
			click("questionnaire_systemtab_XPATH");
			System.out.println("Clicked on the system tab.");
			ngDriver.waitForAngularRequestsToFinish();

			// click on the custom form option
			click("customform_option_XPATH");
			System.out.println("Clicked on the custom form option.");
			ngDriver.waitForAngularRequestsToFinish();

			// wait for the element
			Thread.sleep(5000);

			// click on the delete button of the newly created custom form
			String deleteIcon = "//td[text()='" + data.get("name")
					+ "']//following-sibling::td[@class='pointer']//i[@data-target='#deleteCustomFormModal']";
			driver.findElement(By.xpath(deleteIcon)).click();
			ngDriver.waitForAngularRequestsToFinish();
			System.out.println("click on the delete button of the newly created custom form.");

			// wait for the element
			Thread.sleep(5000);

			// click on the delete button
			click("customform_deletebtn_XPATH");
			ngDriver.waitForAngularRequestsToFinish();
			System.out.println("Clicked on the delete button.");

			// validate the respective record is deleted or not
			try {
				String deletedRecord = "//td[text()='" + data.get("name") + "']";
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
		System.out.println("Clicked on the home icon from the top of the screen.");
		ngDriver.waitForAngularRequestsToFinish();

		// wait for the element
		explicitWait("propertylist_title_XPATH");

		// verify the property list
		switchVerification("propertylist_title_XPATH", "Property List", "The property list is not displayed.");

	}
}
