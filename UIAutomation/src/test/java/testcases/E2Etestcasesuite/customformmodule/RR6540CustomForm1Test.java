package testcases.E2Etestcasesuite.customformmodule;

import java.io.IOException;
import java.util.Hashtable;

import org.apache.commons.lang3.RandomStringUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;

import base.TestBase;
import utilities.TestUtil;

public class RR6540CustomForm1Test extends TestBase {

	@Test(dataProviderClass = TestUtil.class, dataProvider = "dp")
	public void rR6540CustomForm1Test(Hashtable<String, String> data) throws IOException, InterruptedException {

		execution(data, "rR6540CustomForm1Test");

		// VALIDATE THE DEPENDENCY CONDITION OF THE FIELDS OF THE CUSTOM FORM ON THE
		// PORTFOLIO DASHBOARD AND PROPERTY SUMMARY DASHBOARD WITH THE DROPDOWN AND
		// CHECKBOX TYPES - SINGLE TYPE
		title("VALIDATE THE DEPENDENCY CONDITION OF THE FIELDS OF THE CUSTOM FORM ON THE PORTFOLIO DASHBOARD AND PROPERTY SUMMARY DASHBOARD WITH THE DROPDOWN AND CHECKBOX TYPES - SINGLE TYPE");

		// refresh the page
		driver.navigate().refresh();
		Thread.sleep(5000);
		driver.navigate().refresh();

		String name = RandomStringUtils.randomAlphabetic(8); // Custom Form Name
		String fieldName1 = RandomStringUtils.randomAlphabetic(8); // Normal Field 1
		String fieldName2 = RandomStringUtils.randomAlphabetic(8); // Normal Field 2
		String fieldName3 = RandomStringUtils.randomAlphabetic(8); // Normal Field 3
		String fieldName4 = RandomStringUtils.randomAlphabetic(8); // Normal Field 4
		String fieldDetail1 = RandomStringUtils.randomAlphabetic(8); // Field Detail 1
		String fieldDetail4 = RandomStringUtils.randomAlphabetic(8); // Field Detail 4
		String updateFieldDetail1 = RandomStringUtils.randomAlphabetic(8); // Update Field Detail 1
		String updateFieldDetail4 = RandomStringUtils.randomAlphabetic(8); // Update Field Detail 4
		String pageName1 = RandomStringUtils.randomAlphabetic(8); // Page Name 1
		String pageFieldName1 = RandomStringUtils.randomAlphabetic(8); // Page Name 1 - Field 1
		String pageFieldName2 = RandomStringUtils.randomAlphabetic(8); // Page Name 1 - Field 2
		String pageFieldName3 = RandomStringUtils.randomAlphabetic(8); // Page Name 1 - Field 3
		String pageFieldName4 = RandomStringUtils.randomAlphabetic(8); // Page Name 1 - Field 4
		String pageFieldDetail1 = RandomStringUtils.randomAlphabetic(8); // Page Name 1 - Field Detail 1
		String pageFieldDetail4 = RandomStringUtils.randomAlphabetic(8); // Page Name 1 - Field Detail 4
		String updatePageFieldDetail1 = RandomStringUtils.randomAlphabetic(8); // Page Name 1 - Update Field Detail 1
		String updatePageFieldDetail4 = RandomStringUtils.randomAlphabetic(8); // Page Name 1 - Update Field Detail 4

		// CREATE NEW CUSTOM FORMS FOR SINGLE RECORD TYPE AND ADD THE FIELD CONDITION
		title("CREATE NEW CUSTOM FORMS FOR SINGLE RECORD TYPE AND ADD THE FIELD CONDITION");

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

			// wait for the element
			Thread.sleep(5000);

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

			// wait for the element
			Thread.sleep(5000);

			// enter field name
			type("customform_addfield_nametxt_XPATH", fieldName2);

			// select the option from the type dropdown
			select("customform_addfield_typedd_XPATH", data.get("fieldtype_2"));

			// wait for the element
			Thread.sleep(3000);

			// click on the dropdown field
			click("customform_addfield_dropdowndd_XPATH");

			// click on the clear button
			click("customform_addfield_dropdowndd_clearbtn_XPATH");

			// enter the claim syatus in the search field
			type("customform_addfield_dropdowndd_searchtxt_XPATH", data.get("dd_option"));

			// click on the searched result
			click("customform_addfield_dropdowndd_searchedresultclaimstatus_XPATH");

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

			// click on the add field button
			click("customform_addfieldbtn_XPATH");

			// wait for the element
			Thread.sleep(5000);

			// enter field name
			type("customform_addfield_nametxt_XPATH", fieldName3);

			// select the option from the type dropdown
			select("customform_addfield_typedd_XPATH", data.get("fieldtype_3"));

			// click on the display on list checkbox
			click("customform_addfield_displayonlistckbx_XPATH");

			// click on the visible based on condition checkbox
			click("customform_visibleconditionckbx_XPATH");

			// click on the add condition icon
			click("customform_addconditionicon_XPATH");

			// select the respective option from the drop down
			select("customform_addconditionicon_firstfield1_XPATH", fieldName2);

			// wait for the element
			Thread.sleep(5000);

			// click on the third field of the first condition
			click("customform_addconditionicon_firstfield3_XPATH");

			// click on the none button
			click("customform_addconditionicon_firstfield3_nonebtn_XPATH");

			// enter the respective claim status in the search field
			type("customform_addconditionicon_firstfield3_searchtxt_XPATH", "Claim");

			// click on the searched result
			click("customform_addconditionicon_firstfield3_searchedresult1_XPATH");

			// enter the respective claim status in the search field
			type("customform_addconditionicon_firstfield3_searchtxt_XPATH", "Incident");

			// click on the searched result
			click("customform_addconditionicon_firstfield3_searchedresult2_XPATH");

			// click on the third field of the first condition
			click("customform_addconditionicon_firstfield3_XPATH");

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
				String field3 = "//span[text()='" + fieldName3 + "']";
				String field3_actual = (driver.findElement(By.xpath(field3)).getText()).trim();

				if (field3_actual.equals(fieldName3)) {
					successMessage("The newly created field is displayed successfully.");
				} else {
					verificationFailedMessage("The newly created field is not displayed.");
				}
			} catch (Throwable t) {
				verificationFailedMessage("The newly created field is not displayed.");
			}

			// click on the add field button
			click("customform_addfieldbtn_XPATH");

			// wait for the element
			Thread.sleep(5000);

			// enter field name
			type("customform_addfield_nametxt_XPATH", fieldName4);

			// select the option from the type dropdown
			select("customform_addfield_typedd_XPATH", data.get("fieldtype_1"));

			// click on the display on list checkbox
			click("customform_addfield_displayonlistckbx_XPATH");

			// click on the visible based on condition checkbox
			click("customform_visibleconditionckbx_XPATH");

			// click on the add condition icon
			click("customform_addconditionicon_XPATH");

			// select the respective option from the drop down
			select("customform_addconditionicon_secondfield1_XPATH", fieldName2);

			// wait for the element
			Thread.sleep(5000);

			// click on the third field of the first condition
			click("customform_addconditionicon_secondfield3_XPATH");

			// click on the none button
			click("customform_addconditionicon_firstfield3_nonebtn_XPATH");

			// enter the respective claim status in the search field
			type("customform_addconditionicon_firstfield3_searchtxt_XPATH", "Claim");

			// click on the searched result
			click("customform_addconditionicon_firstfield3_searchedresult1_XPATH");

			// click on the third field of the third condition
			click("customform_addconditionicon_secondfield3_XPATH");

			// click on the add condition icon
			click("customform_addconditionicon1_XPATH");

			// select the respective option from the drop down
			select("customform_addconditionicon_thirdfield1_XPATH", fieldName3);

			// wait for the element
			Thread.sleep(5000);

			// click on the third field of the fourth condition
			click("customform_addconditionicon_thirdfield3_XPATH");

			// enter the respective claim status in the search field
			type("customform_addconditionicon_firstfield3_searchtxt_XPATH", "Yes");

			// click on the searched result
			click("customform_addconditionicon_firstfield3_searchedresult4_XPATH");

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
				String field4 = "//span[text()='" + fieldName4 + "']";
				String field4_actual = (driver.findElement(By.xpath(field4)).getText()).trim();

				if (field4_actual.equals(fieldName4)) {
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

			// wait for the element
			Thread.sleep(5000);

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
			page1 = "//span[contains(text(),'" + pageName1 + "')]";
			driver.findElement(By.xpath(page1)).click();
			consoleMessage("Clicked on the first page name tab.");

			// validate the newly created field
			try {
				String page1field1 = "//span[text()='" + pageFieldName1 + "']";
				String page1field1_actual = (driver.findElement(By.xpath(page1field1)).getText()).trim();

				if (page1field1_actual.equals(pageFieldName1)) {
					successMessage("The newly created field is displayed successfully.");
				} else {
					verificationFailedMessage("The newly created field is not displayed.");
				}
			} catch (Throwable t) {
				verificationFailedMessage("The newly created field is not displayed.");
			}

			// click on the add field button
			click("customform_addfieldbtn_XPATH");

			// wait for the element
			Thread.sleep(5000);

			// enter field name
			type("customform_addfield_nametxt_XPATH", pageFieldName2);

			// select the option from the type dropdown
			select("customform_addfield_typedd_XPATH", data.get("fieldtype_2"));

			// wait for the element
			Thread.sleep(3000);

			// click on the dropdown field
			click("customform_addfield_dropdowndd_XPATH");

			// click on the clear button
			click("customform_addfield_dropdowndd_clearbtn_XPATH");

			// enter the claim syatus in the search field
			type("customform_addfield_dropdowndd_searchtxt_XPATH", data.get("dd_option_2"));

			// click on the searched result
			click("customform_addfield_dropdowndd_searchedresultclaimtype_XPATH");

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

			// scrolldown to bottom
			scrollBottom();

			// click on the first page name tab
			page1 = "//span[contains(text(),'" + pageName1 + "')]";
			driver.findElement(By.xpath(page1)).click();
			consoleMessage("Clicked on the first page name tab.");

			// validate the newly created field
			try {
				String page1field2 = "//span[text()='" + pageFieldName2 + "']";
				String page1field2_actual = (driver.findElement(By.xpath(page1field2)).getText()).trim();

				if (page1field2_actual.equals(pageFieldName2)) {
					successMessage("The newly created field is displayed successfully.");
				} else {
					verificationFailedMessage("The newly created field is not displayed.");
				}
			} catch (Throwable t) {
				verificationFailedMessage("The newly created field is not displayed.");
			}

			// click on the add field button
			click("customform_addfieldbtn_XPATH");

			// wait for the element
			Thread.sleep(5000);

			// enter field name
			type("customform_addfield_nametxt_XPATH", pageFieldName3);

			// select the option from the type dropdown
			select("customform_addfield_typedd_XPATH", data.get("fieldtype_3"));

			// click on the display on list checkbox
			click("customform_addfield_displayonlistckbx_XPATH");

			// click on the visible based on condition checkbox
			click("customform_visibleconditionckbx_XPATH");

			// click on the add condition icon
			click("customform_addconditionicon_XPATH");

			// select the respective option from the drop down
			select("customform_addconditionicon_firstfield1_XPATH", pageFieldName2);

			// wait for the element
			Thread.sleep(5000);

			// click on the third field of the first condition
			click("customform_addconditionicon_firstfield3_XPATH");

			// click on the none button
			click("customform_addconditionicon_firstfield3_nonebtn_XPATH");

			// enter the respective claim status in the search field
			type("customform_addconditionicon_firstfield3_searchtxt_XPATH", "Fire");

			// click on the searched result
			click("customform_addconditionicon_firstfield3_searchedresult21_XPATH");

			// enter the respective claim status in the search field
			type("customform_addconditionicon_firstfield3_searchtxt_XPATH", "Theft");

			// click on the searched result
			click("customform_addconditionicon_firstfield3_searchedresult22_XPATH");

			// click on the third field of the first condition
			click("customform_addconditionicon_firstfield3_XPATH");

			// wait for the element
			Thread.sleep(5000);

			// click on the add button
			click("customform_addfield_addbtn_XPATH");

			// scroll down the screen
			scrollBottom();

			// wait for the element
			Thread.sleep(5000);

			// click on the first page name tab
			page1 = "//span[contains(text(),'" + pageName1 + "')]";
			driver.findElement(By.xpath(page1)).click();
			consoleMessage("Clicked on the first page name tab.");

			// validate the newly created field
			try {
				String page1field3 = "//span[text()='" + pageFieldName3 + "']";
				String page1field3_actual = (driver.findElement(By.xpath(page1field3)).getText()).trim();

				if (page1field3_actual.equals(pageFieldName3)) {
					successMessage("The newly created field is displayed successfully.");
				} else {
					verificationFailedMessage("The newly created field is not displayed.");
				}
			} catch (Throwable t) {
				verificationFailedMessage("The newly created field is not displayed.");
			}

			// click on the add field button
			click("customform_addfieldbtn_XPATH");

			// wait for the element
			Thread.sleep(5000);

			// enter field name
			type("customform_addfield_nametxt_XPATH", pageFieldName4);

			// select the option from the type dropdown
			select("customform_addfield_typedd_XPATH", data.get("fieldtype_1"));

			// click on the display on list checkbox
			click("customform_addfield_displayonlistckbx_XPATH");

			// click on the visible based on condition checkbox
			click("customform_visibleconditionckbx_XPATH");

			// click on the add condition icon
			click("customform_addconditionicon_XPATH");

			// select the respective option from the drop down
			select("customform_addconditionicon_secondfield1_XPATH", pageFieldName2);

			// wait for the element
			Thread.sleep(5000);

			// click on the third field of the first condition
			click("customform_addconditionicon_secondfield3_XPATH");

			// click on the none button
			click("customform_addconditionicon_firstfield3_nonebtn_XPATH");

			// enter the respective claim status in the search field
			type("customform_addconditionicon_firstfield3_searchtxt_XPATH", "Flood");

			// click on the searched result
			click("customform_addconditionicon_firstfield3_searchedresult23_XPATH");

			// click on the third field of the third condition
			click("customform_addconditionicon_secondfield3_XPATH");

			// click on the add condition icon
			click("customform_addconditionicon1_XPATH");

			// select the respective option from the drop down
			select("customform_addconditionicon_thirdfield1_XPATH", pageFieldName3);

			// wait for the element
			Thread.sleep(5000);

			// click on the third field of the fourth condition
			click("customform_addconditionicon_thirdfield3_XPATH");

			// enter the respective claim status in the search field
			type("customform_addconditionicon_firstfield3_searchtxt_XPATH", "No");

			// click on the searched result
			click("customform_addconditionicon_firstfield3_searchedresult24_XPATH");

			// wait for the element
			Thread.sleep(5000);

			// click on the add button
			click("customform_addfield_addbtn_XPATH");

			// scroll down the screen
			scrollBottom();

			// wait for the element
			Thread.sleep(5000);

			// click on the first page name tab
			page1 = "//span[contains(text(),'" + pageName1 + "')]";
			driver.findElement(By.xpath(page1)).click();
			consoleMessage("Clicked on the first page name tab.");

			// validate the newly created field
			try {
				String page1field4 = "//span[text()='" + pageFieldName4 + "']";
				String page1field4_actual = (driver.findElement(By.xpath(page1field4)).getText()).trim();

				if (page1field4_actual.equals(pageFieldName4)) {
					successMessage("The newly created field is displayed successfully.");
				} else {
					verificationFailedMessage("The newly created field is not displayed.");
				}
			} catch (Throwable t) {
				verificationFailedMessage("The newly created field is not displayed.");
			}

			// wait for the element
			Thread.sleep(3000);

			// click on the update button
			click("customform_updatebtn_XPATH");

			// wait for the element
			explicitWaitClickable("closetoastmsg_CSS");

			// click on the toaster close button
			click("closetoastmsg_CSS");

			// scroll down the bottom
			scrollBottom();

			// click on the detail tab
			String detailTab = "//span[contains(text(),'Details')]";
			driver.findElement(By.xpath(detailTab)).click();
			consoleMessage("Clicked on the detail tab.");

			// click on the edit button of field 3
			click("customform_addconditionicon_editicon_field3_XPATH");

			// wait for the element
			Thread.sleep(3000);

			// scroll down the bottom
			scrollBottom();

			// validate the field details condition 1
			try {
				boolean field1 = driver
						.findElement(By
								.xpath(OR.getProperty("customform_addconditionicon_firstfield3_validateresult1_XPATH")))
						.isDisplayed();
				if (field1 == true) {
					successMessage("The respective option of the field 1 is displayed successfully.");
				} else {
					verificationFailedMessage("The respective options of the field 1 is not displayed.");
				}
			} catch (Throwable t) {
				verificationFailedMessage("The respective options of the field 1 is not displayed.");
			}

			// validate the field details condition 2
			try {
				boolean field2 = driver
						.findElement(By
								.xpath(OR.getProperty("customform_addconditionicon_firstfield3_validateresult2_XPATH")))
						.isDisplayed();
				if (field2 == true) {
					successMessage("The respective option of the field 2 is displayed successfully.");
				} else {
					verificationFailedMessage("The respective options of the field 2 is not displayed.");
				}
			} catch (Throwable t) {
				verificationFailedMessage("The respective options of the field 2 is not displayed.");
			}

			// click on the edit button of field 3
			click("customform_addconditionicon_editicon_field3_XPATH");

			// click on the edit button of field 4
			click("customform_addconditionicon_editicon_field4_XPATH");

			// wait for the element
			Thread.sleep(3000);

			// scroll down the bottom
			scrollBottom();

			// validate the field details condition 3
			try {
				boolean field3 = driver
						.findElement(By.xpath(
								OR.getProperty("customform_addconditionicon_firstfield3_validateresult11_XPATH")))
						.isDisplayed();
				if (field3 == true) {
					successMessage("The respective option of the field 1 is displayed successfully.");
				} else {
					verificationFailedMessage("The respective options of the field 1 is not displayed.");
				}
			} catch (Throwable t) {
				verificationFailedMessage("The respective options of the field 1 is not displayed.");
			}

			// validate the field details condition 4
			try {
				boolean field4 = driver
						.findElement(By
								.xpath(OR.getProperty("customform_addconditionicon_firstfield3_validateresult4_XPATH")))
						.isDisplayed();
				if (field4 == true) {
					successMessage("The respective option of the field 4 is displayed successfully.");
				} else {
					verificationFailedMessage("The respective options of the field 4 is not displayed.");
				}
			} catch (Throwable t) {
				verificationFailedMessage("The respective options of the field 4 is not displayed.");
			}

			// scroll up to top
			scrollTop();

			// click on the first page name tab
			page1 = "//span[contains(text(),'" + pageName1 + "')]";
			driver.findElement(By.xpath(page1)).click();
			consoleMessage("Clicked on the first page name tab.");

			// scroll down to bottom
			scrollBottom();

			// click on the edit button of field 3
			click("customform_addconditionicon_editicon_field3_XPATH");

			// wait for the element
			Thread.sleep(3000);

			// scroll down the bottom
			scrollBottom();

			// validate the field details condition 1 of page 1
			try {
				boolean page1field1 = driver
						.findElement(By.xpath(
								OR.getProperty("customform_addconditionicon_firstfield3_validateresult21_XPATH")))
						.isDisplayed();
				if (page1field1 == true) {
					successMessage("The respective option of the field 1 of page 1 is displayed successfully.");
				} else {
					verificationFailedMessage("The respective options of the field 1 of page 1 is not displayed.");
				}
			} catch (Throwable t) {
				verificationFailedMessage("The respective options of the field 1 of page 1 is not displayed.");
			}

			// validate the field details condition 2 of page 1
			try {
				boolean page1field2 = driver
						.findElement(By.xpath(
								OR.getProperty("customform_addconditionicon_firstfield3_validateresult22_XPATH")))
						.isDisplayed();
				if (page1field2 == true) {
					successMessage("The respective option of the field 2 of page 1 is displayed successfully.");
				} else {
					verificationFailedMessage("The respective options of the field 2 of page 1 is not displayed.");
				}
			} catch (Throwable t) {
				verificationFailedMessage("The respective options of the field 2 of page 1 is not displayed.");
			}

			// click on the edit button of field 3
			click("customform_addconditionicon_editicon_field3_XPATH");

			// click on the edit button of field 4
			click("customform_addconditionicon_editicon_field4_XPATH");

			// wait for the element
			Thread.sleep(3000);

			// scroll down the bottom
			scrollBottom();

			// validate the field details condition 3 of page 1
			try {
				boolean page1field3 = driver
						.findElement(By.xpath(
								OR.getProperty("customform_addconditionicon_firstfield3_validateresult23_XPATH")))
						.isDisplayed();
				if (page1field3 == true) {
					successMessage("The respective option of the field 3 of page 1 is displayed successfully.");
				} else {
					verificationFailedMessage("The respective options of the field 3 of page 1 is not displayed.");
				}
			} catch (Throwable t) {
				verificationFailedMessage("The respective options of the field 3 of page 1 is not displayed.");
			}

			// validate the field details condition 4 of page 1
			try {
				boolean page1field4 = driver
						.findElement(By.xpath(
								OR.getProperty("customform_addconditionicon_firstfield3_validateresult24_XPATH")))
						.isDisplayed();
				if (page1field4 == true) {
					successMessage("The respective option of the field 4 of page 1 is displayed successfully.");
				} else {
					verificationFailedMessage("The respective options of the field 4 of page 1 is not displayed.");
				}
			} catch (Throwable t) {
				verificationFailedMessage("The respective options of the field 4 of page 1 is not displayed.");
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

			// validate the third field label
			try {
				String fieldLabel3 = "//label[contains(text(),'" + fieldName3 + "')]";
				String fieldLabel3_actual = (driver.findElement(By.xpath(fieldLabel3)).getText()).trim();

				if (fieldLabel3_actual.equals(fieldName3 + ":")) {
					verificationFailedMessage("The third field label is displayed.");
				} else {
					successMessage("The third field label is not displayed as expected.");
				}
			} catch (Throwable t) {
				successMessage("The third field label is not displayed as expected.");
			}

			// validate the forth field label
			try {
				String fieldLabel4 = "//label[contains(text(),'" + fieldName4 + "')]";
				String fieldLabel4_actual = (driver.findElement(By.xpath(fieldLabel4)).getText()).trim();

				if (fieldLabel4_actual.equals(fieldName4 + ":")) {
					verificationFailedMessage("The forth field label is displayed.");
				} else {
					successMessage("The forth field label is not displayed as expected.");
				}
			} catch (Throwable t) {
				successMessage("The forth field label is not displayed as expected.");
			}

			// click on the first page name tab
			String pageTab1 = "//span[text()='" + pageName1 + "']";
			driver.findElement(By.xpath(pageTab1)).click();
			consoleMessage("Clicked on the first page name tab.");

			// scroll to bottom
			scrollBottom();

			// validate the first field of page one label
			try {
				String fieldLabel3 = "//label[contains(text(),'" + pageFieldName1 + "')]";
				String fieldLabel3_actual = (driver.findElement(By.xpath(fieldLabel3)).getText()).trim();

				if (fieldLabel3_actual.equals(pageFieldName1 + ":")) {
					successMessage("The first field of page one label is displayed successfully.");
				} else {
					verificationFailedMessage("The first field of page one label is not displayed.");
				}
			} catch (Throwable t) {
				verificationFailedMessage("The first field of page one label is not displayed.");
			}

			// validate the second field of page one label
			try {
				String fieldLabel4 = "//label[contains(text(),'" + pageFieldName2 + "')]";
				String fieldLabel4_actual = (driver.findElement(By.xpath(fieldLabel4)).getText()).trim();

				if (fieldLabel4_actual.equals(pageFieldName2 + ":")) {
					successMessage("The second field of page one label is displayed successfully.");
				} else {
					verificationFailedMessage("The second field of page one label is not displayed.");
				}
			} catch (Throwable t) {
				verificationFailedMessage("The second field of page one label is not displayed.");
			}

			// validate the third field of page one label
			try {
				String fieldLabel5 = "//label[contains(text(),'" + pageFieldName3 + "')]";
				String fieldLabel5_actual = (driver.findElement(By.xpath(fieldLabel5)).getText()).trim();

				if (fieldLabel5_actual.equals(pageFieldName3 + ":")) {
					verificationFailedMessage("The third field of page one label is displayed.");
				} else {
					successMessage("The third field of page one label is not displayed as expected.");
				}
			} catch (Throwable t) {
				successMessage("The third field of page one label is not displayed as expected.");
			}

			// validate the fourth field of page one label
			try {
				String fieldLabel6 = "//label[contains(text(),'" + pageFieldName4 + "')]";
				String fieldLabel6_actual = (driver.findElement(By.xpath(fieldLabel6)).getText()).trim();

				if (fieldLabel6_actual.equals(pageFieldName4 + ":")) {
					verificationFailedMessage("The fourth field of page one label is displayed.");

				} else {
					successMessage("The fourth field of page one label is not displayed as expected.");
				}
			} catch (Throwable t) {
				successMessage("The fourth field of page one label is not displayed as expected.");
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

		// VALIDATE THE FIELDS AND PAGES OF THE CUSTOM REPORT IN THE PORTFOLIO DASHBOARD
		title("VALIDATE THE FIELDS AND PAGES OF THE CUSTOM REPORT IN THE PORTFOLIO DASHBOARD");

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

			// validate the field 1
			try {
				String field11 = "//th[text()='" + fieldName1 + "']";
				String field11_actual = (driver.findElement(By.xpath(field11)).getText()).trim();

				if (field11_actual.equals(fieldName1)) {

					successMessage("The field 1 is not displayed as expected.");

				} else {
					verificationFailedMessage("The field 1 is displayed without access.");
				}
			} catch (Throwable t) {
				verificationFailedMessage("The field 1 is displayed without access.");
			}

			// validate the field 2
			try {
				String field22 = "//th[text()='" + fieldName2 + "']";
				String field22_actual = (driver.findElement(By.xpath(field22)).getText()).trim();

				if (field22_actual.equals(fieldName2)) {
					successMessage("The field 2 is not displayed as expected.");

				} else {
					verificationFailedMessage("The field 2 is displayed without access.");
				}
			} catch (Throwable t) {
				verificationFailedMessage("The field 2 is displayed without access.");
			}

			// validate the field 3
			try {
				String field33 = "//th[text()='" + fieldName3 + "']";
				String field33_actual = (driver.findElement(By.xpath(field33)).getText()).trim();

				if (field33_actual.equals(fieldName3)) {
					successMessage("The field 3 is not displayed as expected.");

				} else {
					verificationFailedMessage("The field 3 is displayed without access.");
				}
			} catch (Throwable t) {
				verificationFailedMessage("The field 3 is displayed without access.");
			}

			// validate the field 4
			try {
				String field44 = "//th[text()='" + fieldName4 + "']";
				String field44_actual = (driver.findElement(By.xpath(field44)).getText()).trim();

				if (field44_actual.equals(fieldName4)) {
					successMessage("The field 4 is not displayed as expected.");

				} else {
					verificationFailedMessage("The field 4 is displayed without access.");
				}
			} catch (Throwable t) {
				verificationFailedMessage("The field 4 is displayed without access.");
			}

			// validate the field 1 of page 1
			try {
				String field33 = "//th[text()='" + pageFieldName1 + "']";
				String field33_actual = (driver.findElement(By.xpath(field33)).getText()).trim();

				if (field33_actual.equals(pageFieldName1)) {

					successMessage("The field 1 of page 1 is displayed successfully.");

				} else {
					verificationFailedMessage("The field 1 of page 1 is not displayed.");
				}
			} catch (Throwable t) {
				verificationFailedMessage("The field 1 of page 1 is not displayed.");
			}

			// validate the field 2 of page 1
			try {
				String field44 = "//th[text()='" + pageFieldName2 + "']";
				String field44_actual = (driver.findElement(By.xpath(field44)).getText()).trim();

				if (field44_actual.equals(pageFieldName2)) {

					successMessage("The field 2 of page 1 is displayed successfully.");

				} else {
					verificationFailedMessage("The field 2 of page 1 is not displayed.");
				}
			} catch (Throwable t) {
				verificationFailedMessage("The field 2 of page 1 is not displayed.");
			}

			// validate the field 3 of page 1
			try {
				String field55 = "//th[text()='" + pageFieldName3 + "']";
				String field55_actual = (driver.findElement(By.xpath(field55)).getText()).trim();

				if (field55_actual.equals(pageFieldName3)) {
					successMessage("The field 3 of page 1 is displayed successfully.");

				} else {
					verificationFailedMessage("The field 3 of page 1 is not displayed.");
				}
			} catch (Throwable t) {
				verificationFailedMessage("The field 3 of page 1 is not displayed.");
			}

			// validate the field 4 of page 1
			try {
				String field66 = "//th[text()='" + pageFieldName4 + "']";
				String field66_actual = (driver.findElement(By.xpath(field66)).getText()).trim();

				if (field66_actual.equals(pageFieldName4)) {

					successMessage("The field 4 of page 1 is displayed successfully.");

				} else {
					verificationFailedMessage("The field 4 of page 1 is not displayed.");
				}
			} catch (Throwable t) {
				verificationFailedMessage("The field 4 of page 1 is not displayed.");
			}

			// click on the property one
			click("customform_portfoliodashboard_propertyname_XPATH");

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

			// validate the third field label
			try {
				String fieldLabel3 = "//label[contains(text(),'" + fieldName3 + "')]";
				String fieldLabel3_actual = (driver.findElement(By.xpath(fieldLabel3)).getText()).trim();

				if (fieldLabel3_actual.equals(fieldName3 + ":")) {
					verificationFailedMessage("The third field label is displayed.");
				} else {
					successMessage("The third field label is not displayed as expected.");
				}
			} catch (Throwable t) {
				successMessage("The third field label is not displayed as expected.");
			}

			// validate the fourth field label
			try {
				String fieldLabel4 = "//label[contains(text(),'" + fieldName4 + "')]";
				String fieldLabel4_actual = (driver.findElement(By.xpath(fieldLabel4)).getText()).trim();

				if (fieldLabel4_actual.equals(fieldName4 + ":")) {
					verificationFailedMessage("The fourth field label is displayed.");
				} else {
					successMessage("The fourth field label is not displayed as expected.");
				}
			} catch (Throwable t) {
				successMessage("The fourth field label is not displayed as expected.");
			}

			// click on the first page name tab
			String pageTab1 = "//span[text()='" + pageName1 + "']";
			driver.findElement(By.xpath(pageTab1)).click();
			consoleMessage("Clicked on the first page name tab.");

			// scroll to bottom
			scrollBottom();

			// validate the first field of page one label
			try {
				String pageFieldLabel1 = "//label[contains(text(),'" + pageFieldName1 + "')]";
				String pageFieldLabel1_actual = (driver.findElement(By.xpath(pageFieldLabel1)).getText()).trim();

				if (pageFieldLabel1_actual.equals(pageFieldName1 + ":")) {
					successMessage("The first field of page one label is displayed successfully.");
				} else {
					verificationFailedMessage("The first field of page one label is not displayed.");
				}
			} catch (Throwable t) {
				verificationFailedMessage("The first field of page one label is not displayed.");
			}

			// validate the second field of page one label
			try {
				String pageFieldLabel2 = "//label[contains(text(),'" + pageFieldName2 + "')]";
				String pageFieldLabel2_actual = (driver.findElement(By.xpath(pageFieldLabel2)).getText()).trim();

				if (pageFieldLabel2_actual.equals(pageFieldName2 + ":")) {
					successMessage("The second field of page one label is displayed successfully.");
				} else {
					verificationFailedMessage("The second field of page one label is not displayed.");
				}
			} catch (Throwable t) {
				verificationFailedMessage("The second field of page one label is not displayed.");
			}

			// validate the third field of page one label
			try {
				String pageFieldLabel3 = "//label[contains(text(),'" + pageFieldName3 + "')]";
				String pageFieldLabel3_actual = (driver.findElement(By.xpath(pageFieldLabel3)).getText()).trim();

				if (pageFieldLabel3_actual.equals(pageFieldName3 + ":")) {
					verificationFailedMessage("The third field of page one label is displayed.");
				} else {
					successMessage("The third field of page one label is not displayed as expected.");
				}
			} catch (Throwable t) {
				successMessage("The third field of page one label is not displayed as expected.");
			}

			// validate the fourth field of page one label
			try {
				String pageFieldLabel4 = "//label[contains(text(),'" + pageFieldName4 + "')]";
				String pageFieldLabel4_actual = (driver.findElement(By.xpath(pageFieldLabel4)).getText()).trim();

				if (pageFieldLabel4_actual.equals(pageFieldName4 + ":")) {
					verificationFailedMessage("The fourth field of page one label is displayed.");
				} else {
					successMessage("The fourth field of page one label is not displayed as expected.");
				}
			} catch (Throwable t) {
				successMessage("The fourth field of page one label is not displayed as expected.");
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

		// ADD THE DETAILS IN THE FIELDS AND PAGES FROM THE PROPERTY SUMMARY DASHBOARD
		// SCREEN
		title("ADD THE DETAILS IN THE FIELDS AND PAGES FROM THE PROPERTY SUMMARY SCREEN");

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

			// ADD THE DETAILS IN THE FIELDS OF THE DETAILS TAB
			title("ADD THE DETAILS IN THE FIELDS OF THE DETAILS TAB");

			// scroll down to bottom
			scrollBottom();

			// click on the edit field button
			click("customform_portfoliodashboard_editfieldbtn_XPATH");

			// validate the field 1 is displayed or not
			try {
				String firstField = "//input[@id='" + fieldName1 + "TEXT']";
				boolean field1 = driver.findElement(By.xpath(firstField)).isDisplayed();

				if (field1 == true) {
					successMessage("The field 1 is displayed successfully.");
				} else {
					verificationFailedMessage("The field 1 is not displayed.");
				}
			} catch (Throwable t) {
				verificationFailedMessage("The field 1 is not displayed.");
			}

			// validate the field 2 is displayed or not
			try {
				String secondField = "//select[@id='" + fieldName2 + "DROPBOX']";
				boolean field2 = driver.findElement(By.xpath(secondField)).isDisplayed();

				if (field2 == true) {
					successMessage("The field 2 is displayed successfully.");
				} else {
					verificationFailedMessage("The field 2 is not displayed.");
				}
			} catch (Throwable t) {
				verificationFailedMessage("The field 2 is not displayed.");
			}

			// validate the field 3 is displayed or not
			try {
				String thirdField = "//input[@id='" + fieldName3 + "CHECKBOX']";
				boolean field3 = driver.findElement(By.xpath(thirdField)).isDisplayed();

				if (field3 == true) {
					verificationFailedMessage("The field 3 is displayed.");
				} else {
					successMessage("The field 3 is not displayed as expected.");
				}
			} catch (Throwable t) {
				successMessage("The field 3 is not displayed as expected.");
			}

			// validate the field 4 is displayed or not
			try {
				String fourthField = "//input[@id='" + fieldName4 + "TEXT']";
				boolean field4 = driver.findElement(By.xpath(fourthField)).isDisplayed();

				if (field4 == true) {
					verificationFailedMessage("The field 4 is displayed.");
				} else {
					successMessage("The field 4 is not displayed as expected.");
				}
			} catch (Throwable t) {
				successMessage("The field 4 is not displayed as expected.");
			}

			// click on the first page name tab
			String pageTab1 = "//span[text()='" + pageName1 + "']";
			driver.findElement(By.xpath(pageTab1)).click();
			consoleMessage("Clicked on the first page name tab.");

			// validate the field 1 of page 1 is displayed or not
			try {
				String pageFirstField = "//input[@id='" + pageFieldName1 + "TEXT']";
				boolean pageField1 = driver.findElement(By.xpath(pageFirstField)).isDisplayed();

				if (pageField1 == true) {
					successMessage("The field 1 of page 1 is displayed successfully.");
				} else {
					verificationFailedMessage("The field 1 of page 1 is not displayed.");
				}
			} catch (Throwable t) {
				verificationFailedMessage("The field 1 of page 1 is not displayed.");
			}

			// validate the field 2 of page 1 is displayed or not
			try {
				String pageSecondField = "//select[@id='" + pageFieldName2 + "DROPBOX']";
				boolean pageField2 = driver.findElement(By.xpath(pageSecondField)).isDisplayed();

				if (pageField2 == true) {
					successMessage("The field 2 of page 1 is displayed successfully.");
				} else {
					verificationFailedMessage("The field 2 of page 1 is not displayed.");
				}
			} catch (Throwable t) {
				verificationFailedMessage("The field 2 of page 1 is not displayed.");
			}

			// validate the field 3 of page 1 is displayed or not
			try {
				String pageThirdField = "//input[@id='" + pageFieldName3 + "CHECKBOX']";
				boolean pageField3 = driver.findElement(By.xpath(pageThirdField)).isDisplayed();

				if (pageField3 == true) {
					verificationFailedMessage("The field 3 of page 1 is displayed.");
				} else {
					successMessage("The field 3 of page 1 is not displayed as expected.");
				}
			} catch (Throwable t) {
				successMessage("The field 3 of page 1 is not displayed as expected.");
			}

			// validate the field 4 of page 1 is displayed or not
			try {
				String pageFourthField = "//input[@id='" + pageFieldName4 + "TEXT']";
				boolean pageField4 = driver.findElement(By.xpath(pageFourthField)).isDisplayed();

				if (pageField4 == true) {
					verificationFailedMessage("The field 4 of page 1 is displayed.");
				} else {
					successMessage("The field 4 of page 1 is not displayed as expected.");
				}
			} catch (Throwable t) {
				successMessage("The field 4 of page 1 is not displayed as expected.");
			}

			// click on the detail tab
			String detailTab = "//span[contains(text(),'Details')]";
			driver.findElement(By.xpath(detailTab)).click();
			consoleMessage("Clicked on the detail tab.");

			// scroll down to bottom
			scrollBottom();

			// enter the details in the first field
			String firstField = "//input[@id='" + fieldName1 + "TEXT']";
			driver.findElement(By.xpath(firstField)).sendKeys(fieldDetail1);
			consoleMessage("Entered the details in the first field.");

			// enter the details in the second field
			String secondField = "//select[@id='" + fieldName2 + "DROPBOX']";
			WebElement dropdown = driver.findElement(By.xpath(secondField));
			Select select = new Select(dropdown);
			select.selectByVisibleText(data.get("field1_dd1"));
			consoleMessage("Select the details in the second field.");

			// validate the field 3 is displayed or not
			try {
				String thirdField = "//input[@id='" + fieldName3 + "CHECKBOX']";
				boolean field3 = driver.findElement(By.xpath(thirdField)).isDisplayed();

				if (field3 == true) {
					successMessage("The field 3 is displayed as expected.");
				} else {
					verificationFailedMessage("The field 3 is not displayed.");
				}
			} catch (Throwable t) {
				verificationFailedMessage("The field 3 is not displayed.");
			}

			// validate the field 4 is displayed or not
			try {
				String fourthField = "//input[@id='" + fieldName4 + "TEXT']";
				boolean field4 = driver.findElement(By.xpath(fourthField)).isDisplayed();

				if (field4 == true) {
					verificationFailedMessage("The field 4 is displayed.");
				} else {
					successMessage("The field 4 is not displayed as expected.");
				}
			} catch (Throwable t) {
				successMessage("The field 4 is not displayed as expected.");
			}

			// enter the details in the second field
			String secondField2 = "//select[@id='" + fieldName2 + "DROPBOX']";
			WebElement dropdown2 = driver.findElement(By.xpath(secondField2));
			Select select2 = new Select(dropdown2);
			select2.selectByVisibleText(data.get("field2_dd1"));
			consoleMessage("Select the details in the second field.");

			// validate the field 3 is displayed or not
			try {
				String thirdField = "//input[@id='" + fieldName3 + "CHECKBOX']";
				boolean field3 = driver.findElement(By.xpath(thirdField)).isDisplayed();

				if (field3 == true) {
					successMessage("The field 3 is displayed as expected.");
				} else {
					verificationFailedMessage("The field 3 is not displayed.");
				}
			} catch (Throwable t) {
				verificationFailedMessage("The field 3 is not displayed.");
			}

			// validate the field 4 is displayed or not
			try {
				String fourthField = "//input[@id='" + fieldName4 + "TEXT']";
				boolean field4 = driver.findElement(By.xpath(fourthField)).isDisplayed();

				if (field4 == true) {
					verificationFailedMessage("The field 4 is displayed.");
				} else {
					successMessage("The field 4 is not displayed as expected.");
				}
			} catch (Throwable t) {
				successMessage("The field 4 is not displayed as expected.");
			}

			// enter the details in the second field
			String secondField1 = "//select[@id='" + fieldName2 + "DROPBOX']";
			WebElement dropdown1 = driver.findElement(By.xpath(secondField1));
			Select select1 = new Select(dropdown1);
			select1.selectByVisibleText(data.get("field3_dd1"));
			consoleMessage("Select the details in the second field.");

			// validate the field 3 is displayed or not
			try {
				String thirdField = "//input[@id='" + fieldName3 + "CHECKBOX']";
				boolean field3 = driver.findElement(By.xpath(thirdField)).isDisplayed();

				if (field3 == true) {
					verificationFailedMessage("The field 3 is displayed.");
				} else {
					successMessage("The field 3 is not displayed as expected.");
				}
			} catch (Throwable t) {
				successMessage("The field 3 is not displayed as expected.");
			}

			// validate the field 4 is displayed or not
			try {
				String fourthField = "//input[@id='" + fieldName4 + "TEXT']";
				boolean field4 = driver.findElement(By.xpath(fourthField)).isDisplayed();

				if (field4 == true) {
					verificationFailedMessage("The field 4 is displayed.");
				} else {
					successMessage("The field 4 is not displayed as expected.");
				}
			} catch (Throwable t) {
				successMessage("The field 4 is not displayed as expected.");
			}

			// enter the details in the second field
			String secondField4 = "//select[@id='" + fieldName2 + "DROPBOX']";
			WebElement dropdown4 = driver.findElement(By.xpath(secondField4));
			Select select4 = new Select(dropdown4);
			select4.selectByVisibleText(data.get("field4_dd1"));
			consoleMessage("Select the details in the second field.");

			// validate the field 4 is displayed or not
			try {
				String thirdField = "//input[@id='" + fieldName3 + "CHECKBOX']";
				boolean field3 = driver.findElement(By.xpath(thirdField)).isDisplayed();

				if (field3 == true) {
					verificationFailedMessage("The field 4 is displayed.");
				} else {
					successMessage("The field 4 is not displayed as expected.");
				}
			} catch (Throwable t) {
				successMessage("The field 4 is not displayed as expected.");
			}

			// validate the field 4 is displayed or not
			try {
				String fourthField = "//input[@id='" + fieldName4 + "TEXT']";
				boolean field4 = driver.findElement(By.xpath(fourthField)).isDisplayed();

				if (field4 == true) {
					verificationFailedMessage("The field 4 is displayed.");
				} else {
					successMessage("The field 4 is not displayed as expected.");
				}
			} catch (Throwable t) {
				successMessage("The field 4 is not displayed as expected.");
			}

			// enter the details in the second field
			String secondField3 = "//select[@id='" + fieldName2 + "DROPBOX']";
			WebElement dropdown3 = driver.findElement(By.xpath(secondField3));
			Select select3 = new Select(dropdown3);
			select3.selectByVisibleText(data.get("field1_dd1"));
			consoleMessage("Select the details in the second field.");

			// click on the checkbox of the field 3
			String thirdField = "//input[@id='" + fieldName3 + "CHECKBOX']";
			driver.findElement(By.xpath(thirdField)).click();
			consoleMessage("Clicked on the checkbox of the field 3.");

			// validate the field 4 is displayed or not
			try {
				String fourthField = "//input[@id='" + fieldName4 + "TEXT']";
				boolean field4 = driver.findElement(By.xpath(fourthField)).isDisplayed();

				if (field4 == true) {
					successMessage("The field 4 is displayed as expected.");
				} else {
					verificationFailedMessage("The field 4 is not displayed.");
				}
			} catch (Throwable t) {
				verificationFailedMessage("The field 4 is not displayed.");
			}

			// click on the checkbox of the field 3
			String thirdField2 = "//input[@id='" + fieldName3 + "CHECKBOX']";
			driver.findElement(By.xpath(thirdField2)).click();
			consoleMessage("Clicked on the checkbox of the field 3.");

			// validate the field 4 is displayed or not
			try {
				String fourthField = "//input[@id='" + fieldName4 + "TEXT']";
				boolean field4 = driver.findElement(By.xpath(fourthField)).isDisplayed();

				if (field4 == true) {
					verificationFailedMessage("The field 4 is displayed.");

				} else {
					successMessage("The field 4 is not displayed as expected.");
				}
			} catch (Throwable t) {
				successMessage("The field 4 is not displayed as expected.");
			}

			// click on the checkbox of the field 3
			String thirdField3 = "//input[@id='" + fieldName3 + "CHECKBOX']";
			driver.findElement(By.xpath(thirdField3)).click();
			consoleMessage("Clicked on the checkbox of the field 3.");

			// enter the details in the fourth field
			String fourthField = "//input[@id='" + fieldName4 + "TEXT']";
			driver.findElement(By.xpath(fourthField)).sendKeys(fieldDetail4);
			consoleMessage("Entered the details in the fourth field.");

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
				String firstField2 = "//span[contains(text(),'" + data.get("field1_dd1") + "')]";
				String firstField2_actual = (driver.findElement(By.xpath(firstField2)).getText()).trim();

				if (firstField2_actual.equals(data.get("field1_dd1"))) {
					successMessage("The details of the second field is displayed successfully.");
				} else {
					verificationFailedMessage("The details of the second field is not displayed.");
				}
			} catch (Throwable t) {
				verificationFailedMessage("The details of the second field is not displayed.");
			}

			// validate the details of the third field
			try {
				String firstField3 = "//span[contains(text(),'" + data.get("field5_dd1") + "')]";
				String firstField3_actual = (driver.findElement(By.xpath(firstField3)).getText()).trim();

				if (firstField3_actual.equals(data.get("field5_dd1"))) {
					successMessage("The details of the third field is displayed successfully.");
				} else {
					verificationFailedMessage("The details of the third field is not displayed.");
				}
			} catch (Throwable t) {
				verificationFailedMessage("The details of the third field is not displayed.");
			}

			// validate the details of the fourth field
			try {
				String firstField4 = "//span[contains(text(),'" + fieldDetail4 + "')]";
				String firstField4_actual = (driver.findElement(By.xpath(firstField4)).getText()).trim();

				if (firstField4_actual.equals(fieldDetail4)) {
					successMessage("The details of the fourth field is displayed successfully.");
				} else {
					verificationFailedMessage("The details of the fourth field is not displayed.");
				}
			} catch (Throwable t) {
				verificationFailedMessage("The details of the fourth field is not displayed.");
			}

			// click on the first page name tab
			pageTab1 = "//span[text()='" + pageName1 + "']";
			driver.findElement(By.xpath(pageTab1)).click();
			consoleMessage("Clicked on the first page name tab.");

			// ADD THE DETAILS IN THE FIELDS OF THE FIRST PAGE TAB
			title("ADD THE DETAILS IN THE FIELDS OF THE FIRST PAGE TAB");

			// scroll down to bottom
			scrollBottom();

			// click on the edit field button
			click("customform_portfoliodashboard_editfieldbtn_XPATH");

			// enter the details in the first field of page 1
			String pageFirstField = "//input[@id='" + pageFieldName1 + "TEXT']";
			driver.findElement(By.xpath(pageFirstField)).sendKeys(pageFieldDetail1);
			consoleMessage("Entered the details in the first field of page 1.");

			// enter the details in the second field of page 1
			String pageSecondField = "//select[@id='" + pageFieldName2 + "DROPBOX']";
			WebElement pageDropdown = driver.findElement(By.xpath(pageSecondField));
			Select pageSelect = new Select(pageDropdown);
			pageSelect.selectByVisibleText(data.get("field1_dd2"));
			consoleMessage("Select the details in the second field of page 1.");

			// validate the field 3 of page 1 is displayed or not
			try {
				String pageThirdField = "//input[@id='" + pageFieldName3 + "CHECKBOX']";
				boolean pageField3 = driver.findElement(By.xpath(pageThirdField)).isDisplayed();

				if (pageField3 == true) {
					successMessage("The field 3 of page 1 is displayed as expected.");
				} else {
					verificationFailedMessage("The field 3 of page 1 is not displayed.");
				}
			} catch (Throwable t) {
				verificationFailedMessage("The field 3 of page 1 is not displayed.");
			}

			// validate the field 4 of page 1 is displayed or not
			try {
				String pageFourthField = "//input[@id='" + pageFieldName4 + "TEXT']";
				boolean pageField4 = driver.findElement(By.xpath(pageFourthField)).isDisplayed();

				if (pageField4 == true) {
					verificationFailedMessage("The field 4 of page 1 is displayed.");
				} else {
					successMessage("The field 4 of page 1 is not displayed as expected.");
				}
			} catch (Throwable t) {
				successMessage("The field 4 of page 1 is not displayed as expected.");
			}

			// enter the details in the second field of page 1
			String pageSecondField2 = "//select[@id='" + pageFieldName2 + "DROPBOX']";
			WebElement pageDropdown2 = driver.findElement(By.xpath(pageSecondField2));
			Select pageSelect2 = new Select(pageDropdown2);
			pageSelect2.selectByVisibleText(data.get("field2_dd2"));
			consoleMessage("Select the details in the second field of page 1.");

			// validate the field 3 of page 1 is displayed or not
			try {
				String pagethirdField = "//input[@id='" + pageFieldName3 + "CHECKBOX']";
				boolean pagefield3 = driver.findElement(By.xpath(pagethirdField)).isDisplayed();

				if (pagefield3 == true) {
					successMessage("The field 3 of page 1 is displayed as expected.");
				} else {
					verificationFailedMessage("The field 3 of page 1 is not displayed.");
				}
			} catch (Throwable t) {
				verificationFailedMessage("The field 3 of page 1 is not displayed.");
			}

			// validate the field 4 of page 1 is displayed or not
			try {
				String pagefourthField = "//input[@id='" + pageFieldName4 + "TEXT']";
				boolean pagefield4 = driver.findElement(By.xpath(pagefourthField)).isDisplayed();

				if (pagefield4 == true) {
					verificationFailedMessage("The field 4 of page 1 is displayed.");
				} else {
					successMessage("The field 4 of page 1 is not displayed as expected.");
				}
			} catch (Throwable t) {
				successMessage("The field 4 of page 1 is not displayed as expected.");
			}

			// enter the details in the second field of page 1
			String pagesecondField1 = "//select[@id='" + pageFieldName2 + "DROPBOX']";
			WebElement pagedropdown1 = driver.findElement(By.xpath(pagesecondField1));
			Select pageselect1 = new Select(pagedropdown1);
			pageselect1.selectByVisibleText(data.get("field3_dd2"));
			consoleMessage("Select the details in the second field of page 1.");

			// validate the field 3 of page 1 is displayed or not
			try {
				String pagethirdField = "//input[@id='" + pageFieldName3 + "CHECKBOX']";
				boolean pagefield3 = driver.findElement(By.xpath(pagethirdField)).isDisplayed();

				if (pagefield3 == true) {
					verificationFailedMessage("The field 3 of page 1 is displayed.");
				} else {
					successMessage("The field 3 of page 1 is not displayed as expected.");
				}
			} catch (Throwable t) {
				successMessage("The field 3 of page 1 is not displayed as expected.");
			}

			// validate the field 4 of page 1 is displayed or not
			try {
				String pagefourthField = "//input[@id='" + pageFieldName4 + "TEXT']";
				boolean pagefield4 = driver.findElement(By.xpath(pagefourthField)).isDisplayed();

				if (pagefield4 == true) {
					successMessage("The field 4 of page 1 is displayed as expected.");
				} else {
					verificationFailedMessage("The field 4 of page 1 is not displayed.");
				}
			} catch (Throwable t) {
				verificationFailedMessage("The field 4 of page 1 is not displayed.");
			}

			// enter the details in the second field of page 1
			String pagesecondField4 = "//select[@id='" + pageFieldName2 + "DROPBOX']";
			WebElement pagedropdown4 = driver.findElement(By.xpath(pagesecondField4));
			Select pageselect4 = new Select(pagedropdown4);
			pageselect4.selectByVisibleText(data.get("field4_dd2"));
			consoleMessage("Select the details in the second field of page 1.");

			// validate the field 4 of page 1 is displayed or not
			try {
				String pagethirdField = "//input[@id='" + pageFieldName3 + "CHECKBOX']";
				boolean pagefield3 = driver.findElement(By.xpath(pagethirdField)).isDisplayed();

				if (pagefield3 == true) {
					verificationFailedMessage("The field 4 of page 1 is displayed.");
				} else {
					successMessage("The field 4 of page 1 is not displayed as expected.");
				}
			} catch (Throwable t) {
				successMessage("The field 4 of page 1 is not displayed as expected.");
			}

			// validate the field 4 of page 1 is displayed or not
			try {
				String pagefourthField = "//input[@id='" + pageFieldName4 + "TEXT']";
				boolean pagefield4 = driver.findElement(By.xpath(pagefourthField)).isDisplayed();

				if (pagefield4 == true) {
					verificationFailedMessage("The field 4 of page 1 is displayed.");
				} else {
					successMessage("The field 4 of page 1 is not displayed as expected.");
				}
			} catch (Throwable t) {
				successMessage("The field 4 of page 1 is not displayed as expected.");
			}

			// enter the details in the second field of page 1
			String pagesecondField3 = "//select[@id='" + pageFieldName2 + "DROPBOX']";
			WebElement pagedropdown3 = driver.findElement(By.xpath(pagesecondField3));
			Select pageselect3 = new Select(pagedropdown3);
			pageselect3.selectByVisibleText(data.get("field3_dd2"));
			consoleMessage("Select the details in the second field of page 1.");

			// validate the field 3 of page 1 is displayed or not
			try {
				String pagethirdField = "//input[@id='" + pageFieldName3 + "CHECKBOX']";
				boolean pagefield3 = driver.findElement(By.xpath(pagethirdField)).isDisplayed();

				if (pagefield3 == true) {
					verificationFailedMessage("The field 4 of page 1 is displayed.");
				} else {
					successMessage("The field 4 of page 1 is not displayed as expected.");
				}
			} catch (Throwable t) {
				successMessage("The field 4 of page 1 is not displayed as expected.");
			}

			// validate the field 4 of page 1 is displayed or not
			try {
				String pagefourthField = "//input[@id='" + pageFieldName4 + "TEXT']";
				boolean pagefield4 = driver.findElement(By.xpath(pagefourthField)).isDisplayed();

				if (pagefield4 == true) {
					successMessage("The field 4 of page 1 is displayed as expected.");

				} else {
					verificationFailedMessage("The field 4 of page 1 is not displayed.");
				}
			} catch (Throwable t) {
				verificationFailedMessage("The field 4 of page 1 is not displayed.");
			}

			// enter the details in the second field of page 1
			String pagesecondField5 = "//select[@id='" + pageFieldName2 + "DROPBOX']";
			WebElement pagedropdown5 = driver.findElement(By.xpath(pagesecondField5));
			Select pageselect5 = new Select(pagedropdown5);
			pageselect5.selectByVisibleText(data.get("field1_dd2"));
			consoleMessage("Select the details in the second field of page 1.");

			// click on the checkbox of the field 3 of page 1
			String pagethirdField2 = "//input[@id='" + pageFieldName3 + "CHECKBOX']";
			driver.findElement(By.xpath(pagethirdField2)).click();
			consoleMessage("Clicked on the checkbox of the field 3 of page 1.");

			// validate the field 4 of page 1 is displayed or not
			try {
				String pagefourthField = "//input[@id='" + pageFieldName4 + "TEXT']";
				boolean pagefield4 = driver.findElement(By.xpath(pagefourthField)).isDisplayed();

				if (pagefield4 == true) {
					verificationFailedMessage("The field 4 of page 1 is displayed.");

				} else {
					successMessage("The field 4 of page 1 is not displayed as expected.");
				}
			} catch (Throwable t) {
				successMessage("The field 4 of page 1 is not displayed as expected.");
			}

			// click on the checkbox of the field 3 of page 1
			String pagethirdField3 = "//input[@id='" + pageFieldName3 + "CHECKBOX']";
			driver.findElement(By.xpath(pagethirdField3)).click();
			consoleMessage("Clicked on the checkbox of the field 3 of page 1.");

			// validate the field 4 of page 1 is displayed or not
			try {
				String pagefourthField = "//input[@id='" + pageFieldName4 + "TEXT']";
				boolean pagefield4 = driver.findElement(By.xpath(pagefourthField)).isDisplayed();

				if (pagefield4 == true) {
					verificationFailedMessage("The field 4 of page 1 is displayed.");

				} else {
					successMessage("The field 4 of page 1 is not displayed as expected.");
				}
			} catch (Throwable t) {
				successMessage("The field 4 of page 1 is not displayed as expected.");
			}

			// enter the details in the second field of page 1
			String pagesecondField6 = "//select[@id='" + pageFieldName2 + "DROPBOX']";
			WebElement pagedropdown6 = driver.findElement(By.xpath(pagesecondField6));
			Select pageselect6 = new Select(pagedropdown6);
			pageselect6.selectByVisibleText(data.get("field3_dd2"));
			consoleMessage("Select the details in the second field of page 1.");

			// enter the details in the fourth field of page 1
			String pagefourthField = "//input[@id='" + pageFieldName4 + "TEXT']";
			driver.findElement(By.xpath(pagefourthField)).sendKeys(pageFieldDetail4);
			consoleMessage("Entered the details in the fourth field of page 1.");

			// click on the save button
			click("customform_portfoliodashboard_fields_savebtn_XPATH");

			// scroll to bottom
			scrollBottom();

			// wait for the element
			Thread.sleep(5000);

			// validate the details of the first field of page 1
			try {
				String pagefirstField1 = "//span[contains(text(),'" + pageFieldDetail1 + "')]";
				String pagefirstField1_actual = (driver.findElement(By.xpath(pagefirstField1)).getText()).trim();

				if (pagefirstField1_actual.equals(pageFieldDetail1)) {
					successMessage("The details of the first field of page 1 is displayed successfully.");
				} else {
					verificationFailedMessage("The details of the first field of page 1 is not displayed.");
				}
			} catch (Throwable t) {
				verificationFailedMessage("The details of the first field of page 1 is not displayed.");
			}

			// validate the details of the second field of page 1
			try {
				String pagefirstField2 = "//span[contains(text(),'" + data.get("field3_dd2") + "')]";
				String pagefirstField2_actual = (driver.findElement(By.xpath(pagefirstField2)).getText()).trim();

				if (pagefirstField2_actual.equals(data.get("field3_dd2"))) {
					successMessage("The details of the second field of page 1 is displayed successfully.");
				} else {
					verificationFailedMessage("The details of the second field of page 1 is not displayed.");
				}
			} catch (Throwable t) {
				verificationFailedMessage("The details of the second field of page 1 is not displayed.");
			}

			// validate the details of the third field of page 1
			try {
				String pagefirstField3 = "//span[contains(text(),'" + data.get("field5_dd2") + "')]";
				String pagefirstField3_actual = (driver.findElement(By.xpath(pagefirstField3)).getText()).trim();

				if (pagefirstField3_actual.equals(data.get("field5_dd2"))) {
					verificationFailedMessage("The details of the third field of page 1 is displayed.");

				} else {
					successMessage("The details of the third field of page 1 is not displayed as expected.");
				}
			} catch (Throwable t) {
				successMessage("The details of the third field of page 1 is not displayed as expected.");
			}

			// validate the details of the fourth field of page 1
			try {
				String pagefirstField4 = "//span[contains(text(),'" + pageFieldDetail4 + "')]";
				String pagefirstField4_actual = (driver.findElement(By.xpath(pagefirstField4)).getText()).trim();

				if (pagefirstField4_actual.equals(pageFieldDetail4)) {
					successMessage("The details of the fourth field of page 1 is displayed successfully.");
				} else {
					verificationFailedMessage("The details of the fourth field of page 1 is not displayed.");
				}
			} catch (Throwable t) {
				verificationFailedMessage("The details of the fourth field of page 1 is not displayed.");
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

		// VALIDATE THE ADDED DETAILS OF THE FIELDS AND PAGES OF THE CUSTOM REPORT IN
		// THE PORTFOLIO DASHBOARD
		title("VALIDATE THE ADDED DETAILS OF THE FIELDS AND PAGES OF THE CUSTOM REPORT IN THE PORTFOLIO DASHBOARD");

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

			// validate the field 1
			try {
				String field11 = "//span[text()='" + fieldDetail1 + "']";
				String field11_actual = (driver.findElement(By.xpath(field11)).getText()).trim();

				if (field11_actual.equals(fieldDetail1)) {

					successMessage("The field 1 is not displayed as expected.");

				} else {
					verificationFailedMessage("The field 1 is displayed without access.");
				}
			} catch (Throwable t) {
				verificationFailedMessage("The field 1 is displayed without access.");
			}

			// validate the field 2
			try {
				String field22 = "//span[text()='" + data.get("field1_dd1") + "']";
				String field22_actual = (driver.findElement(By.xpath(field22)).getText()).trim();

				if (field22_actual.equals(data.get("field1_dd1"))) {
					successMessage("The field 2 is not displayed as expected.");

				} else {
					verificationFailedMessage("The field 2 is displayed without access.");
				}
			} catch (Throwable t) {
				verificationFailedMessage("The field 2 is displayed without access.");
			}

			// validate the field 3
			try {
				String field33 = "//span[text()='" + data.get("field5_dd1") + "']";
				String field33_actual = (driver.findElement(By.xpath(field33)).getText()).trim();

				if (field33_actual.equals(data.get("field5_dd1"))) {
					successMessage("The field 3 is not displayed as expected.");

				} else {
					verificationFailedMessage("The field 3 is displayed without access.");
				}
			} catch (Throwable t) {
				verificationFailedMessage("The field 3 is displayed without access.");
			}

			// validate the field 4
			try {
				String field44 = "//span[text()='" + fieldDetail4 + "']";
				String field44_actual = (driver.findElement(By.xpath(field44)).getText()).trim();

				if (field44_actual.equals(fieldDetail4)) {
					successMessage("The field 4 is not displayed as expected.");

				} else {
					verificationFailedMessage("The field 4 is displayed without access.");
				}
			} catch (Throwable t) {
				verificationFailedMessage("The field 4 is displayed without access.");
			}

			// validate the field 1 of page 1
			try {
				String field33 = "//span[text()='" + pageFieldDetail1 + "']";
				String field33_actual = (driver.findElement(By.xpath(field33)).getText()).trim();

				if (field33_actual.equals(pageFieldDetail1)) {

					successMessage("The field 1 of page 1 is displayed successfully.");

				} else {
					verificationFailedMessage("The field 1 of page 1 is not displayed.");
				}
			} catch (Throwable t) {
				verificationFailedMessage("The field 1 of page 1 is not displayed.");
			}

			// validate the field 2 of page 1
			try {
				String field44 = "//span[text()='" + data.get("field3_dd2") + "']";
				String field44_actual = (driver.findElement(By.xpath(field44)).getText()).trim();

				if (field44_actual.equals(data.get("field3_dd2"))) {

					successMessage("The field 2 of page 1 is displayed successfully.");

				} else {
					verificationFailedMessage("The field 2 of page 1 is not displayed.");
				}
			} catch (Throwable t) {
				verificationFailedMessage("The field 2 of page 1 is not displayed.");
			}

			// validate the field 3 of page 1
			try {
				String field55 = "//span[text()='" + data.get("field5_dd2") + "']";
				String field55_actual = (driver.findElement(By.xpath(field55)).getText()).trim();

				if (field55_actual.equals(data.get("field5_dd2"))) {
					successMessage("The field 3 of page 1 is displayed successfully.");

				} else {
					verificationFailedMessage("The field 3 of page 1 is not displayed.");
				}
			} catch (Throwable t) {
				verificationFailedMessage("The field 3 of page 1 is not displayed.");
			}

			// validate the field 4 of page 1
			try {
				String field66 = "//span[text()='" + pageFieldDetail4 + "']";
				String field66_actual = (driver.findElement(By.xpath(field66)).getText()).trim();

				if (field66_actual.equals(pageFieldDetail4)) {

					successMessage("The field 4 of page 1 is displayed successfully.");

				} else {
					verificationFailedMessage("The field 4 of page 1 is not displayed.");
				}
			} catch (Throwable t) {
				verificationFailedMessage("The field 4 of page 1 is not displayed.");
			}

			// click on the property one
			click("customform_portfoliodashboard_propertyname_XPATH");

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

			// validate the field 1
			try {
				String field11 = "//label[contains(text(),'" + fieldName1 + "')]//following-sibling::div//span[text()='"
						+ fieldDetail1 + "']";
				String field11_actual = (driver.findElement(By.xpath(field11)).getText()).trim();

				if (field11_actual.equals(fieldDetail1)) {

					successMessage("The field 1 is not displayed as expected.");

				} else {
					verificationFailedMessage("The field 1 is displayed without access.");
				}
			} catch (Throwable t) {
				verificationFailedMessage("The field 1 is displayed without access.");
			}

			// validate the field 2
			try {
				String field22 = "//label[contains(text(),'" + fieldName2 + "')]//following-sibling::div//span[text()='"
						+ data.get("field1_dd1") + "']";
				String field22_actual = (driver.findElement(By.xpath(field22)).getText()).trim();

				if (field22_actual.equals(data.get("field1_dd1"))) {
					successMessage("The field 2 is not displayed as expected.");

				} else {
					verificationFailedMessage("The field 2 is displayed without access.");
				}
			} catch (Throwable t) {
				verificationFailedMessage("The field 2 is displayed without access.");
			}

			// validate the field 3
			try {
				String field33 = "//label[contains(text(),'" + fieldName3 + "')]//following-sibling::div//span[text()='"
						+ data.get("field5_dd1") + "']";
				String field33_actual = (driver.findElement(By.xpath(field33)).getText()).trim();

				if (field33_actual.equals(data.get("field5_dd1"))) {
					successMessage("The field 3 is not displayed as expected.");

				} else {
					verificationFailedMessage("The field 3 is displayed without access.");
				}
			} catch (Throwable t) {
				verificationFailedMessage("The field 3 is displayed without access.");
			}

			// validate the field 4
			try {
				String field44 = "//label[contains(text(),'" + fieldName4 + "')]//following-sibling::div//span[text()='"
						+ fieldDetail4 + "']";
				String field44_actual = (driver.findElement(By.xpath(field44)).getText()).trim();

				if (field44_actual.equals(fieldDetail4)) {
					successMessage("The field 4 is not displayed as expected.");

				} else {
					verificationFailedMessage("The field 4 is displayed without access.");
				}
			} catch (Throwable t) {
				verificationFailedMessage("The field 4 is displayed without access.");
			}

			// click on the first page name tab
			String pageTab1 = "//span[text()='" + pageName1 + "']";
			driver.findElement(By.xpath(pageTab1)).click();
			consoleMessage("Clicked on the first page name tab.");

			// scroll to bottom
			scrollBottom();

			// validate the field 1 of page 1
			try {
				String field33 = "//label[contains(text(),'" + pageFieldName1
						+ "')]//following-sibling::div//span[text()='" + pageFieldDetail1 + "']";
				String field33_actual = (driver.findElement(By.xpath(field33)).getText()).trim();

				if (field33_actual.equals(pageFieldDetail1)) {

					successMessage("The field 1 of page 1 is displayed successfully.");

				} else {
					verificationFailedMessage("The field 1 of page 1 is not displayed.");
				}
			} catch (Throwable t) {
				verificationFailedMessage("The field 1 of page 1 is not displayed.");
			}

			// validate the field 2 of page 1
			try {
				String field44 = "//label[contains(text(),'" + pageFieldName2
						+ "')]//following-sibling::div//span[text()='" + data.get("field3_dd2") + "']";
				String field44_actual = (driver.findElement(By.xpath(field44)).getText()).trim();

				if (field44_actual.equals(data.get("field3_dd2"))) {
					successMessage("The field 2 of page 1 is displayed successfully.");
				} else {
					verificationFailedMessage("The field 2 of page 1 is not displayed.");
				}
			} catch (Throwable t) {
				verificationFailedMessage("The field 2 of page 1 is not displayed.");
			}

			// validate the field 3 of page 1
			try {
				String field55 = "//label[contains(text(),'" + pageFieldName3
						+ "')]//following-sibling::div//span[text()='" + data.get("field5_dd2") + "']";
				String field55_actual = (driver.findElement(By.xpath(field55)).getText()).trim();

				if (field55_actual.equals(data.get("field5_dd2"))) {
					verificationFailedMessage("The field 3 of page 1 is displayed.");
				} else {
					successMessage("The field 3 of page 1 is not displayed as expected.");
				}
			} catch (Throwable t) {
				successMessage("The field 3 of page 1 is not displayed as expected.");
			}

			// validate the field 4 of page 1
			try {
				String field66 = "//label[contains(text(),'" + pageFieldName4
						+ "')]//following-sibling::div//span[text()='" + pageFieldDetail4 + "']";
				String field66_actual = (driver.findElement(By.xpath(field66)).getText()).trim();

				if (field66_actual.equals(pageFieldDetail4)) {

					successMessage("The field 4 of page 1 is displayed successfully.");

				} else {
					verificationFailedMessage("The field 4 of page 1 is not displayed.");
				}
			} catch (Throwable t) {
				verificationFailedMessage("The field 4 of page 1 is not displayed.");
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

		// UPDATE THE DETAILS IN THE FIELDS AND PAGES FROM THE PORTFOLIO SUMMARY
		// DASHBOARD SCREEN
		title("UPDATE THE DETAILS IN THE FIELDS AND PAGES FROM THE PORTFOLIO SUMMARY SCREEN");

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

			// click on the property
			click("propertylist_propertyname_XPATH");

			// ADD THE DETAILS IN THE FIELDS OF THE DETAILS TAB
			title("ADD THE DETAILS IN THE FIELDS OF THE DETAILS TAB");

			// scroll down to bottom
			scrollBottom();

			// click on the edit field button
			click("customform_portfoliodashboard_editfieldbtn_XPATH");

			// enter the details in the first field
			String firstField = "//input[@id='" + fieldName1 + "TEXT']";
			driver.findElement(By.xpath(firstField)).clear();
			driver.findElement(By.xpath(firstField)).sendKeys(updateFieldDetail1);
			consoleMessage("Entered the details in the first field.");

			// enter the details in the second field
			String secondField = "//select[@id='" + fieldName2 + "DROPBOX']";
			WebElement dropdown = driver.findElement(By.xpath(secondField));
			Select select = new Select(dropdown);
			select.selectByVisibleText(data.get("field1_dd1"));
			consoleMessage("Select the details in the second field.");

			// validate the field 3 is displayed or not
			try {
				String thirdField = "//input[@id='" + fieldName3 + "CHECKBOX']";
				boolean field3 = driver.findElement(By.xpath(thirdField)).isDisplayed();

				if (field3 == true) {
					successMessage("The field 3 is displayed as expected.");
				} else {
					verificationFailedMessage("The field 3 is not displayed.");
				}
			} catch (Throwable t) {
				verificationFailedMessage("The field 3 is not displayed.");
			}

			// validate the field 4 is displayed or not
			try {
				String fourthField = "//input[@id='" + fieldName4 + "TEXT']";
				boolean field4 = driver.findElement(By.xpath(fourthField)).isDisplayed();

				if (field4 == true) {
					successMessage("The field 4 is displayed as expected.");
				} else {
					verificationFailedMessage("The field 4 is not displayed.");
				}
			} catch (Throwable t) {
				verificationFailedMessage("The field 4 is not displayed.");
			}

			// enter the details in the second field
			String secondField2 = "//select[@id='" + fieldName2 + "DROPBOX']";
			WebElement dropdown2 = driver.findElement(By.xpath(secondField2));
			Select select2 = new Select(dropdown2);
			select2.selectByVisibleText(data.get("field2_dd1"));
			consoleMessage("Select the details in the second field.");

			// validate the field 3 is displayed or not
			try {
				String thirdField = "//input[@id='" + fieldName3 + "CHECKBOX']";
				boolean field3 = driver.findElement(By.xpath(thirdField)).isDisplayed();

				if (field3 == true) {
					successMessage("The field 3 is displayed as expected.");
				} else {
					verificationFailedMessage("The field 3 is not displayed.");
				}
			} catch (Throwable t) {
				verificationFailedMessage("The field 3 is not displayed.");
			}

			// validate the field 4 is displayed or not
			try {
				String fourthField = "//input[@id='" + fieldName4 + "TEXT']";
				boolean field4 = driver.findElement(By.xpath(fourthField)).isDisplayed();

				if (field4 == true) {
					verificationFailedMessage("The field 4 is displayed.");
				} else {
					successMessage("The field 4 is not displayed as expected.");
				}
			} catch (Throwable t) {
				successMessage("The field 4 is not displayed as expected.");
			}

			// enter the details in the second field
			String secondField1 = "//select[@id='" + fieldName2 + "DROPBOX']";
			WebElement dropdown1 = driver.findElement(By.xpath(secondField1));
			Select select1 = new Select(dropdown1);
			select1.selectByVisibleText(data.get("field3_dd1"));
			consoleMessage("Select the details in the second field.");

			// validate the field 3 is displayed or not
			try {
				String thirdField = "//input[@id='" + fieldName3 + "CHECKBOX']";
				boolean field3 = driver.findElement(By.xpath(thirdField)).isDisplayed();

				if (field3 == true) {
					verificationFailedMessage("The field 3 is displayed.");
				} else {
					successMessage("The field 3 is not displayed as expected.");
				}
			} catch (Throwable t) {
				successMessage("The field 3 is not displayed as expected.");
			}

			// validate the field 4 is displayed or not
			try {
				String fourthField = "//input[@id='" + fieldName4 + "TEXT']";
				boolean field4 = driver.findElement(By.xpath(fourthField)).isDisplayed();

				if (field4 == true) {
					verificationFailedMessage("The field 4 is displayed.");
				} else {
					successMessage("The field 4 is not displayed as expected.");
				}
			} catch (Throwable t) {
				successMessage("The field 4 is not displayed as expected.");
			}

			// enter the details in the second field
			String secondField4 = "//select[@id='" + fieldName2 + "DROPBOX']";
			WebElement dropdown4 = driver.findElement(By.xpath(secondField4));
			Select select4 = new Select(dropdown4);
			select4.selectByVisibleText(data.get("field4_dd1"));
			consoleMessage("Select the details in the second field.");

			// validate the field 4 is displayed or not
			try {
				String thirdField = "//input[@id='" + fieldName3 + "CHECKBOX']";
				boolean field3 = driver.findElement(By.xpath(thirdField)).isDisplayed();

				if (field3 == true) {
					verificationFailedMessage("The field 3 is displayed.");
				} else {
					successMessage("The field 3 is not displayed as expected.");
				}
			} catch (Throwable t) {
				successMessage("The field 3 is not displayed as expected.");
			}

			// validate the field 4 is displayed or not
			try {
				String fourthField = "//input[@id='" + fieldName4 + "TEXT']";
				boolean field4 = driver.findElement(By.xpath(fourthField)).isDisplayed();

				if (field4 == true) {
					verificationFailedMessage("The field 4 is displayed.");
				} else {
					successMessage("The field 4 is not displayed as expected.");
				}
			} catch (Throwable t) {
				successMessage("The field 4 is not displayed as expected.");
			}

			// enter the details in the second field
			String secondField3 = "//select[@id='" + fieldName2 + "DROPBOX']";
			WebElement dropdown3 = driver.findElement(By.xpath(secondField3));
			Select select3 = new Select(dropdown3);
			select3.selectByVisibleText(data.get("field1_dd1"));
			consoleMessage("Select the details in the second field.");

			// click on the checkbox of the field 3
			String thirdField = "//input[@id='" + fieldName3 + "CHECKBOX']";
			driver.findElement(By.xpath(thirdField)).click();
			consoleMessage("Clicked on the checkbox of the field 3.");

			// validate the field 4 is displayed or not
			try {
				String fourthField = "//input[@id='" + fieldName4 + "TEXT']";
				boolean field4 = driver.findElement(By.xpath(fourthField)).isDisplayed();

				if (field4 == true) {
					verificationFailedMessage("The field 4 is displayed.");

				} else {
					successMessage("The field 4 is not displayed as expected.");
				}
			} catch (Throwable t) {
				successMessage("The field 4 is not displayed as expected.");
			}

			// click on the checkbox of the field 3
			String thirdField2 = "//input[@id='" + fieldName3 + "CHECKBOX']";
			driver.findElement(By.xpath(thirdField2)).click();
			consoleMessage("Clicked on the checkbox of the field 3.");

			// validate the field 4 is displayed or not
			try {
				String fourthField = "//input[@id='" + fieldName4 + "TEXT']";
				boolean field4 = driver.findElement(By.xpath(fourthField)).isDisplayed();

				if (field4 == true) {
					successMessage("The field 4 is displayed as expected.");
				} else {
					verificationFailedMessage("The field 4 is not displayed.");
				}
			} catch (Throwable t) {
				verificationFailedMessage("The field 4 is not displayed.");
			}

			// enter the details in the fourth field
			String fourthField = "//input[@id='" + fieldName4 + "TEXT']";
			driver.findElement(By.xpath(fourthField)).clear();
			driver.findElement(By.xpath(fourthField)).sendKeys(updateFieldDetail4);
			consoleMessage("Entered the details in the fourth field.");

			// click on the save button
			click("customform_portfoliodashboard_fields_savebtn_XPATH");

			// scroll to bottom
			scrollBottom();

			// wait for the element
			Thread.sleep(5000);

			// validate the details of the first field
			try {
				String updateFirstField1 = "//span[contains(text(),'" + updateFieldDetail1 + "')]";
				String updateFirstField1_actual = (driver.findElement(By.xpath(updateFirstField1)).getText()).trim();

				if (updateFirstField1_actual.equals(updateFieldDetail1)) {
					successMessage("The details of the first field is displayed successfully.");
				} else {
					verificationFailedMessage("The details of the first field is not displayed.");
				}
			} catch (Throwable t) {
				verificationFailedMessage("The details of the first field is not displayed.");
			}

			// validate the details of the second field
			try {
				String firstField2 = "//span[contains(text(),'" + data.get("field1_dd1") + "')]";
				String firstField2_actual = (driver.findElement(By.xpath(firstField2)).getText()).trim();

				if (firstField2_actual.equals(data.get("field1_dd1"))) {
					successMessage("The details of the second field is displayed successfully.");
				} else {
					verificationFailedMessage("The details of the second field is not displayed.");
				}
			} catch (Throwable t) {
				verificationFailedMessage("The details of the second field is not displayed.");
			}

			// validate the details of the third field
			try {
				String firstField3 = "//span[contains(text(),'" + data.get("field5_dd1") + "')]";
				String firstField3_actual = (driver.findElement(By.xpath(firstField3)).getText()).trim();

				if (firstField3_actual.equals(data.get("field5_dd1"))) {
					successMessage("The details of the third field is displayed successfully.");
				} else {
					verificationFailedMessage("The details of the third field is not displayed.");
				}
			} catch (Throwable t) {
				verificationFailedMessage("The details of the third field is not displayed.");
			}

			// validate the details of the fourth field
			try {
				String updateFirstField4 = "//span[contains(text(),'" + updateFieldDetail4 + "')]";
				String updateFirstField4_actual = (driver.findElement(By.xpath(updateFirstField4)).getText()).trim();

				if (updateFirstField4_actual.equals(updateFieldDetail4)) {
					successMessage("The details of the fourth field is displayed successfully.");
				} else {
					verificationFailedMessage("The details of the fourth field is not displayed.");
				}
			} catch (Throwable t) {
				verificationFailedMessage("The details of the fourth field is not displayed.");
			}

			// click on the first page name tab
			String pageTab1 = "//span[text()='" + pageName1 + "']";
			driver.findElement(By.xpath(pageTab1)).click();
			consoleMessage("Clicked on the first page name tab.");

			// ADD THE DETAILS IN THE FIELDS OF THE FIRST PAGE TAB
			title("ADD THE DETAILS IN THE FIELDS OF THE FIRST PAGE TAB");

			// scroll down to bottom
			scrollBottom();

			// click on the edit field button
			click("customform_portfoliodashboard_editfieldbtn_XPATH");

			// enter the details in the first field of page 1
			String updatePageFirstField = "//input[@id='" + pageFieldName1 + "TEXT']";
			driver.findElement(By.xpath(updatePageFirstField)).clear();
			driver.findElement(By.xpath(updatePageFirstField)).sendKeys(updatePageFieldDetail1);
			consoleMessage("Entered the details in the first field of page 1.");

			// enter the details in the second field of page 1
			String pageSecondField = "//select[@id='" + pageFieldName2 + "DROPBOX']";
			WebElement pageDropdown = driver.findElement(By.xpath(pageSecondField));
			Select pageSelect = new Select(pageDropdown);
			pageSelect.selectByVisibleText(data.get("field1_dd2"));
			consoleMessage("Select the details in the second field of page 1.");

			// validate the field 3 of page 1 is displayed or not
			try {
				String pageThirdField = "//input[@id='" + pageFieldName3 + "CHECKBOX']";
				boolean pageField3 = driver.findElement(By.xpath(pageThirdField)).isDisplayed();

				if (pageField3 == true) {
					successMessage("The field 3 of page 1 is displayed as expected.");
				} else {
					verificationFailedMessage("The field 3 of page 1 is not displayed.");
				}
			} catch (Throwable t) {
				verificationFailedMessage("The field 3 of page 1 is not displayed.");
			}

			// validate the field 4 of page 1 is displayed or not
			try {
				String pageFourthField = "//input[@id='" + pageFieldName4 + "TEXT']";
				boolean pageField4 = driver.findElement(By.xpath(pageFourthField)).isDisplayed();

				if (pageField4 == true) {
					verificationFailedMessage("The field 4 of page 1 is displayed.");

				} else {
					successMessage("The field 4 of page 1 is not displayed as expected.");
				}
			} catch (Throwable t) {
				successMessage("The field 4 of page 1 is not displayed as expected.");
			}

			// enter the details in the second field of page 1
			String pageSecondField2 = "//select[@id='" + pageFieldName2 + "DROPBOX']";
			WebElement pageDropdown2 = driver.findElement(By.xpath(pageSecondField2));
			Select pageSelect2 = new Select(pageDropdown2);
			pageSelect2.selectByVisibleText(data.get("field2_dd2"));
			consoleMessage("Select the details in the second field of page 1.");

			// validate the field 3 of page 1 is displayed or not
			try {
				String pagethirdField = "//input[@id='" + pageFieldName3 + "CHECKBOX']";
				boolean pagefield3 = driver.findElement(By.xpath(pagethirdField)).isDisplayed();

				if (pagefield3 == true) {
					successMessage("The field 3 of page 1 is displayed as expected.");
				} else {
					verificationFailedMessage("The field 3 of page 1 is not displayed.");
				}
			} catch (Throwable t) {
				verificationFailedMessage("The field 3 of page 1 is not displayed.");
			}

			// validate the field 4 of page 1 is displayed or not
			try {
				String pagefourthField = "//input[@id='" + pageFieldName4 + "TEXT']";
				boolean pagefield4 = driver.findElement(By.xpath(pagefourthField)).isDisplayed();

				if (pagefield4 == true) {
					verificationFailedMessage("The field 4 of page 1 is displayed.");

				} else {
					successMessage("The field 4 of page 1 is not displayed as expected.");
				}
			} catch (Throwable t) {
				successMessage("The field 4 of page 1 is not displayed as expected.");
			}

			// enter the details in the second field of page 1
			String pagesecondField1 = "//select[@id='" + pageFieldName2 + "DROPBOX']";
			WebElement pagedropdown1 = driver.findElement(By.xpath(pagesecondField1));
			Select pageselect1 = new Select(pagedropdown1);
			pageselect1.selectByVisibleText(data.get("field3_dd2"));
			consoleMessage("Select the details in the second field of page 1.");

			// validate the field 3 of page 1 is displayed or not
			try {
				String pagethirdField = "//input[@id='" + pageFieldName3 + "CHECKBOX']";
				boolean pagefield3 = driver.findElement(By.xpath(pagethirdField)).isDisplayed();

				if (pagefield3 == true) {
					verificationFailedMessage("The field 3 of page 1 is displayed.");
				} else {
					successMessage("The field 3 of page 1 is not displayed as expected.");
				}
			} catch (Throwable t) {
				successMessage("The field 3 of page 1 is not displayed as expected.");
			}

			// validate the field 4 of page 1 is displayed or not
			try {
				String pagefourthField = "//input[@id='" + pageFieldName4 + "TEXT']";
				boolean pagefield4 = driver.findElement(By.xpath(pagefourthField)).isDisplayed();

				if (pagefield4 == true) {
					successMessage("The field 4 of page 1 is displayed as expected.");
				} else {
					verificationFailedMessage("The field 4 of page 1 is not displayed.");
				}
			} catch (Throwable t) {
				verificationFailedMessage("The field 4 of page 1 is not displayed.");
			}

			// enter the details in the second field of page 1
			String pagesecondField4 = "//select[@id='" + pageFieldName2 + "DROPBOX']";
			WebElement pagedropdown4 = driver.findElement(By.xpath(pagesecondField4));
			Select pageselect4 = new Select(pagedropdown4);
			pageselect4.selectByVisibleText(data.get("field4_dd2"));
			consoleMessage("Select the details in the second field of page 1.");

			// validate the field 3 of page 1 is displayed or not
			try {
				String pagethirdField = "//input[@id='" + pageFieldName3 + "CHECKBOX']";
				boolean pagefield3 = driver.findElement(By.xpath(pagethirdField)).isDisplayed();

				if (pagefield3 == true) {
					verificationFailedMessage("The field 3 of page 1 is displayed.");
				} else {
					successMessage("The field 3 of page 1 is not displayed as expected.");
				}
			} catch (Throwable t) {
				successMessage("The field 3 of page 1 is not displayed as expected.");
			}

			// validate the field 4 of page 1 is displayed or not
			try {
				String pagefourthField = "//input[@id='" + pageFieldName4 + "TEXT']";
				boolean pagefield4 = driver.findElement(By.xpath(pagefourthField)).isDisplayed();

				if (pagefield4 == true) {
					verificationFailedMessage("The field 4 of page 1 is displayed.");

				} else {
					successMessage("The field 4 of page 1 is not displayed as expected.");
				}
			} catch (Throwable t) {
				successMessage("The field 4 of page 1 is not displayed as expected.");
			}

			// enter the details in the second field of page 1
			String pagesecondField3 = "//select[@id='" + pageFieldName2 + "DROPBOX']";
			WebElement pagedropdown3 = driver.findElement(By.xpath(pagesecondField3));
			Select pageselect3 = new Select(pagedropdown3);
			pageselect3.selectByVisibleText(data.get("field1_dd2"));
			consoleMessage("Select the details in the second field of page 1.");

			// click on the checkbox of the field 3 of page 1
			String pagethirdField = "//input[@id='" + pageFieldName3 + "CHECKBOX']";
			driver.findElement(By.xpath(pagethirdField)).click();
			consoleMessage("Clicked on the checkbox of the field 3 of page 1.");

			// validate the field 4 of page 1 is displayed or not
			try {
				String pagefourthField = "//input[@id='" + pageFieldName4 + "TEXT']";
				boolean pagefield4 = driver.findElement(By.xpath(pagefourthField)).isDisplayed();

				if (pagefield4 == true) {
					verificationFailedMessage("The field 4 of page 1 is displayed.");
				} else {
					successMessage("The field 4 of page 1 is not displayed as expected.");
				}
			} catch (Throwable t) {
				successMessage("The field 4 of page 1 is not displayed as expected.");
			}

			// click on the checkbox of the field 3 of page 1
			String pagethirdField2 = "//input[@id='" + pageFieldName3 + "CHECKBOX']";
			driver.findElement(By.xpath(pagethirdField2)).click();
			consoleMessage("Clicked on the checkbox of the field 3 of page 1.");

			// validate the field 4 of page 1 is displayed or not
			try {
				String pagefourthField = "//input[@id='" + pageFieldName4 + "TEXT']";
				boolean pagefield4 = driver.findElement(By.xpath(pagefourthField)).isDisplayed();

				if (pagefield4 == true) {
					verificationFailedMessage("The field 4 of page 1 is displayed.");

				} else {
					successMessage("The field 4 of page 1 is not displayed as expected.");
				}
			} catch (Throwable t) {
				successMessage("The field 4 of page 1 is not displayed as expected.");
			}

			// enter the details in the second field of page 1
			String pagesecondField5 = "//select[@id='" + pageFieldName2 + "DROPBOX']";
			WebElement pagedropdown5 = driver.findElement(By.xpath(pagesecondField5));
			Select pageselect5 = new Select(pagedropdown5);
			pageselect5.selectByVisibleText(data.get("field3_dd2"));
			consoleMessage("Select the details in the second field of page 1.");

			// enter the details in the fourth field of page 1
			String updatePagefourthField = "//input[@id='" + pageFieldName4 + "TEXT']";
			driver.findElement(By.xpath(updatePagefourthField)).clear();
			driver.findElement(By.xpath(updatePagefourthField)).sendKeys(updatePageFieldDetail4);
			consoleMessage("Entered the details in the fourth field of page 1.");

			// click on the save button
			click("customform_portfoliodashboard_fields_savebtn_XPATH");

			// scroll to bottom
			scrollBottom();

			// wait for the element
			Thread.sleep(5000);

			// validate the details of the first field of page 1
			try {
				String updatePagefirstField1 = "//span[contains(text(),'" + updatePageFieldDetail1 + "')]";
				String updatePagefirstField1_actual = (driver.findElement(By.xpath(updatePagefirstField1)).getText())
						.trim();

				if (updatePagefirstField1_actual.equals(updatePageFieldDetail1)) {
					successMessage("The details of the first field of page 1 is displayed successfully.");
				} else {
					verificationFailedMessage("The details of the first field of page 1 is not displayed.");
				}
			} catch (Throwable t) {
				verificationFailedMessage("The details of the first field of page 1 is not displayed.");
			}

			// validate the details of the second field of page 1
			try {
				String pagefirstField2 = "//span[contains(text(),'" + data.get("field3_dd2") + "')]";
				String pagefirstField2_actual = (driver.findElement(By.xpath(pagefirstField2)).getText()).trim();

				if (pagefirstField2_actual.equals(data.get("field3_dd2"))) {
					successMessage("The details of the second field of page 1 is displayed successfully.");
				} else {
					verificationFailedMessage("The details of the second field of page 1 is not displayed.");
				}
			} catch (Throwable t) {
				verificationFailedMessage("The details of the second field of page 1 is not displayed.");
			}

			// validate the details of the third field of page 1
			try {
				String pagefirstField3 = "//span[contains(text(),'" + data.get("field5_dd2") + "')]";
				String pagefirstField3_actual = (driver.findElement(By.xpath(pagefirstField3)).getText()).trim();

				if (pagefirstField3_actual.equals(data.get("field5_dd2"))) {
					verificationFailedMessage("The details of the third field of page 1 is displayed.");

				} else {
					successMessage("The details of the third field of page 1 is not displayed as expected.");
				}
			} catch (Throwable t) {
				successMessage("The details of the third field of page 1 is not displayed as expected.");
			}

			// validate the details of the fourth field of page 1
			try {
				String updatePagefirstField4 = "//span[contains(text(),'" + updatePageFieldDetail4 + "')]";
				String updatePagefirstField4_actual = (driver.findElement(By.xpath(updatePagefirstField4)).getText())
						.trim();

				if (updatePagefirstField4_actual.equals(updatePageFieldDetail4)) {
					successMessage("The details of the fourth field of page 1 is displayed successfully.");
				} else {
					verificationFailedMessage("The details of the fourth field of page 1 is not displayed.");
				}
			} catch (Throwable t) {
				verificationFailedMessage("The details of the fourth field of page 1 is not displayed.");
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

		// VALIDATE THE UPDATED DETAILS OF THE FIELDS AND PAGES OF THE CUSTOM REPORT IN
		// THE PROPERYT SUMMARY DASHBOARD
		title("VALIDATE THE UPDATED DETAILS OF THE FIELDS AND PAGES OF THE CUSTOM REPORT IN THE PROPERYT SUMMARY DASHBOARD");

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

			// validate the field 1
			try {
				String updateField11 = "//label[contains(text(),'" + fieldName1
						+ "')]//following-sibling::div//span[text()='" + updateFieldDetail1 + "']";
				String updateField11_actual = (driver.findElement(By.xpath(updateField11)).getText()).trim();

				if (updateField11_actual.equals(updateFieldDetail1)) {

					successMessage("The field 1 is displayed as expected.");

				} else {
					verificationFailedMessage("The field 1 is displayed without access.");
				}
			} catch (Throwable t) {
				verificationFailedMessage("The field 1 is displayed without access.");
			}

			// validate the field 2
			try {
				String field22 = "//label[contains(text(),'" + fieldName2 + "')]//following-sibling::div//span[text()='"
						+ data.get("field1_dd1") + "']";
				String field22_actual = (driver.findElement(By.xpath(field22)).getText()).trim();

				if (field22_actual.equals(data.get("field1_dd1"))) {
					successMessage("The field 2 is displayed as expected.");

				} else {
					verificationFailedMessage("The field 2 is displayed without access.");
				}
			} catch (Throwable t) {
				verificationFailedMessage("The field 2 is displayed without access.");
			}

			// validate the field 3
			try {
				String field33 = "//label[contains(text(),'" + fieldName3 + "')]//following-sibling::div//span[text()='"
						+ data.get("field5_dd1") + "']";
				String field33_actual = (driver.findElement(By.xpath(field33)).getText()).trim();

				if (field33_actual.equals(data.get("field5_dd1"))) {
					successMessage("The field 3 is displayed as expected.");

				} else {
					verificationFailedMessage("The field 3 is displayed without access.");
				}
			} catch (Throwable t) {
				verificationFailedMessage("The field 3 is displayed without access.");
			}

			// validate the field 4
			try {
				String updateField44 = "//label[contains(text(),'" + fieldName4
						+ "')]//following-sibling::div//span[text()='" + updateFieldDetail4 + "']";
				String updateField44_actual = (driver.findElement(By.xpath(updateField44)).getText()).trim();

				if (updateField44_actual.equals(updateFieldDetail4)) {
					successMessage("The field 4 is displayed as expected.");
				} else {
					verificationFailedMessage("The field 4 is displayed without access.");
				}
			} catch (Throwable t) {
				verificationFailedMessage("The field 4 is displayed without access.");
			}

			// click on the first page name tab
			String pageTab1 = "//span[text()='" + pageName1 + "']";
			driver.findElement(By.xpath(pageTab1)).click();
			consoleMessage("Clicked on the first page name tab.");

			// scroll to bottom
			scrollBottom();

			// validate the field 1 of page 1
			try {
				String updateField33 = "//label[contains(text(),'" + pageFieldName1
						+ "')]//following-sibling::div//span[text()='" + updatePageFieldDetail1 + "']";
				String updateField33_actual = (driver.findElement(By.xpath(updateField33)).getText()).trim();

				if (updateField33_actual.equals(updatePageFieldDetail1)) {

					successMessage("The field 1 of page 1 is displayed successfully.");

				} else {
					verificationFailedMessage("The field 1 of page 1 is not displayed.");
				}
			} catch (Throwable t) {
				verificationFailedMessage("The field 1 of page 1 is not displayed.");
			}

			// validate the field 2 of page 1
			try {
				String field44 = "//label[contains(text(),'" + pageFieldName2
						+ "')]//following-sibling::div//span[text()='" + data.get("field3_dd2") + "']";
				String field44_actual = (driver.findElement(By.xpath(field44)).getText()).trim();

				if (field44_actual.equals(data.get("field3_dd2"))) {

					successMessage("The field 2 of page 1 is displayed successfully.");

				} else {
					verificationFailedMessage("The field 2 of page 1 is not displayed.");
				}
			} catch (Throwable t) {
				verificationFailedMessage("The field 2 of page 1 is not displayed.");
			}

			// validate the field 3 of page 1
			try {
				String field55 = "//label[contains(text(),'" + pageFieldName3
						+ "')]//following-sibling::div//span[text()='" + data.get("field5_dd2") + "']";
				String field55_actual = (driver.findElement(By.xpath(field55)).getText()).trim();

				if (field55_actual.equals(data.get("field5_dd2"))) {
					verificationFailedMessage("The field 3 of page 1 is displayed.");

				} else {
					successMessage("The field 3 of page 1 is not displayed as expected.");
				}
			} catch (Throwable t) {
				successMessage("The field 3 of page 1 is not displayed as expected.");
			}

			// validate the field 4 of page 1
			try {
				String updateField66 = "//label[contains(text(),'" + pageFieldName4
						+ "')]//following-sibling::div//span[text()='" + updatePageFieldDetail4 + "']";
				String updateField66_actual = (driver.findElement(By.xpath(updateField66)).getText()).trim();

				if (updateField66_actual.equals(updatePageFieldDetail4)) {

					successMessage("The field 4 of page 1 is displayed successfully.");

				} else {
					verificationFailedMessage("The field 4 of page 1 is not displayed.");
				}
			} catch (Throwable t) {
				verificationFailedMessage("The field 4 of page 1 is not displayed.");
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
			String deleteIcon = "//td[text()='" + name
					+ "']//following-sibling::td[@class='pointer']//i[@data-target='#deleteCustomFormModal']";
			driver.findElement(By.xpath(deleteIcon)).click();
			consoleMessage("click on the delete button of the newly created custom form.");

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
