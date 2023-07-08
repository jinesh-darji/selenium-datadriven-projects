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

public class RR6555CustomForm5Test extends TestBase {

	@Test(dataProviderClass = TestUtil.class, dataProvider = "dp")
	public void rR6555CustomForm5Test(Hashtable<String, String> data) throws IOException, InterruptedException {

		execution(data, "rR6555CustomForm5Test");

		// VERIFY THE RISK SCORE OF THE SINGLE AND MULTIPLE TYPES' CUSTOM FORMS ON THE
		// PROPERTY SUMMARY DASHBOARD AND PORTFOLIO DASHBOARD WITH MULTIPLE CUSTOM FORMS
		// OF THE SAME PROPERTY.
		title("VERIFY THE RISK SCORE OF THE SINGLE AND MULTIPLE TYPES' CUSTOM FORMS ON THE PROPERTY SUMMARY DASHBOARD AND PORTFOLIO DASHBOARD WITH MULTIPLE CUSTOM FORMS OF THE SAME PROPERTY.");

		// refresh the page
		driver.navigate().refresh();
		Thread.sleep(5000);
		driver.navigate().refresh();

		String sname = RandomStringUtils.randomAlphabetic(8); // Single Custom Form Name
		String sfieldName1 = RandomStringUtils.randomAlphabetic(8); // Single Normal Field 1
		String sfieldName2 = RandomStringUtils.randomAlphabetic(8); // Single Normal Field 2
		String sfieldDetail1 = RandomStringUtils.randomAlphabetic(8); // Single Field Detail 1
		String sfieldDetail2 = RandomStringUtils.randomNumeric(3); // Single Field Detail 2
		String spageName1 = RandomStringUtils.randomAlphabetic(8); // Single Page Name 1
		String spageFieldName1 = RandomStringUtils.randomAlphabetic(8); // Single Page Name 1 - Field 1
		String spageFieldName2 = RandomStringUtils.randomAlphabetic(8); // Single Page Name 1 - Field 2
		String spageFieldDetail1 = RandomStringUtils.randomAlphabetic(8); // Single Page Name 1 - Field Detail 1
		String spageFieldDetail2 = RandomStringUtils.randomNumeric(3); // Single Page Name 1 - Field Detail 2
		String sscore = RandomStringUtils.randomNumeric(2);
		String supdatescore = RandomStringUtils.randomNumeric(2);
		String mname = RandomStringUtils.randomAlphabetic(8);
		String mfieldName1 = RandomStringUtils.randomAlphabetic(8);
		String mfieldName2 = RandomStringUtils.randomAlphabetic(8);
		String mpageName1 = RandomStringUtils.randomAlphabetic(8);
		String mpageFieldName1 = RandomStringUtils.randomAlphabetic(8);
		String mpageFieldName2 = RandomStringUtils.randomAlphabetic(8);
		String mscore = null;
		String mupdatescore = null;
		String mfield1Detail = null;
		String mfield2Detail = null;
		String mpageField1Detail = null;
		String mpageField2Detail = null;
		List<String> mscore_list = new ArrayList<String>();
		List<String> mupdatescore_list = new ArrayList<String>();
		List<String> mfield1Detail_list = new ArrayList<String>();
		List<String> mfield2Detail_list = new ArrayList<String>();
		List<String> mpageField1Detail_list = new ArrayList<String>();
		List<String> mpageField2Detail_list = new ArrayList<String>();

		Random random = new Random();
		int mcount = random.nextInt(5 - 3) + 3;
		int mtotalScore = 0;
		int mtotalUpdateScore = 0;

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
			type("customform_nametxt_XPATH", sname);

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
				String Validation0 = "//td[text()='" + sname + "']";
				String Validation0_actual = (driver.findElement(By.xpath(Validation0)).getText()).trim();

				if (Validation0_actual.equals(sname)) {

					successMessage("The Report Name detail is displayed correctly.");

				} else {
					verificationFailedMessage("The Report Name detail is displayed correctly.");
				}

			} catch (Throwable t) {
				verificationFailedMessage("The Report Name detail is displayed correctly.");
			}

			// click on the newly created custom record record
			String nameTitle = "//td[text()='" + sname + "']";
			driver.findElement(By.xpath(nameTitle)).click();
			consoleMessage("Clicked on the newly created custom record record.");

			// click on the add field button
			click("customform_addfieldbtn_XPATH");

			// enter field name
			type("customform_addfield_nametxt_XPATH", sfieldName1);

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
				String field1 = "//span[text()='" + sfieldName1 + "']";
				String field1_actual = (driver.findElement(By.xpath(field1)).getText()).trim();

				if (field1_actual.equals(sfieldName1)) {
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
			type("customform_addfield_nametxt_XPATH", sfieldName2);

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
				String field2 = "//span[text()='" + sfieldName2 + "']";
				String field2_actual = (driver.findElement(By.xpath(field2)).getText()).trim();

				if (field2_actual.equals(sfieldName2)) {
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
			type("customform_portfoliodashboard_pagenametxt_XPATH", spageName1);

			// click on the add button
			click("customform_portfoliodashboard_pagename_addbtn_XPATH");

			// validate the newly added page
			try {
				String page1 = "//span[contains(text(),'" + spageName1 + "')]";
				String page1_actual = (driver.findElement(By.xpath(page1)).getText()).trim();

				if (page1_actual.equals(spageName1)) {
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
			String page1 = "//span[contains(text(),'" + spageName1 + "')]";
			driver.findElement(By.xpath(page1)).click();
			consoleMessage("Clicked on the first page name tab.");

			// click on the add field button
			click("customform_addfieldbtn_XPATH");

			// scroll to bottom
			scrollBottom();

			// enter field name
			type("customform_addfield_nametxt_XPATH", spageFieldName1);

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
			String page11 = "//span[contains(text(),'" + spageName1 + "')]";
			driver.findElement(By.xpath(page11)).click();
			consoleMessage("Clicked on the first page name tab.");

			// scroll to bottom
			scrollBottom();

			// validate the newly created field
			try {
				String field1 = "//span[text()='" + spageFieldName1 + "']";
				String field1_actual = (driver.findElement(By.xpath(field1)).getText()).trim();

				if (field1_actual.equals(spageFieldName1)) {
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
			type("customform_addfield_nametxt_XPATH", spageFieldName2);

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
			String page111 = "//span[contains(text(),'" + spageName1 + "')]";
			driver.findElement(By.xpath(page111)).click();
			consoleMessage("Clicked on the first page name tab.");

			// scroll to bottom
			scrollBottom();

			// validate the newly created field
			try {
				String field2 = "//span[text()='" + spageFieldName2 + "']";
				String field2_actual = (driver.findElement(By.xpath(field2)).getText()).trim();

				if (field2_actual.equals(spageFieldName2)) {
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
			type("customform_nametxt_XPATH", mname);

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
				String Validation0 = "//td[text()='" + mname + "']";
				String Validation0_actual = (driver.findElement(By.xpath(Validation0)).getText()).trim();

				if (Validation0_actual.equals(mname)) {

					successMessage("The Report Name detail is displayed correctly.");

				} else {
					verificationFailedMessage("The Report Name detail is not displayed.");
				}

			} catch (Throwable t) {
				verificationFailedMessage("The Report Name detail is not displayed.");
			}

			// click on the newly created custom record record
			String nameTitle = "//td[text()='" + mname + "']";
			driver.findElement(By.xpath(nameTitle)).click();
			consoleMessage("Clicked on the newly created custom record record.");

			// click on the add field button
			click("customform_addfieldbtn_XPATH");

			// enter field name
			type("customform_addfield_nametxt_XPATH", mfieldName1);

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
				String field1 = "//span[text()='" + mfieldName1 + "']";
				String field1_actual = (driver.findElement(By.xpath(field1)).getText()).trim();

				if (field1_actual.equals(mfieldName1)) {
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
			type("customform_addfield_nametxt_XPATH", mfieldName2);

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
				String field2 = "//span[text()='" + mfieldName2 + "']";
				String field2_actual = (driver.findElement(By.xpath(field2)).getText()).trim();

				if (field2_actual.equals(mfieldName2)) {
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
			type("customform_portfoliodashboard_pagenametxt_XPATH", mpageName1);

			// wait for the element
			Thread.sleep(5000);

			// click on the add button
			click("customform_portfoliodashboard_pagename_addbtn_XPATH");

			// validate the newly added page
			try {
				String page1 = "//span[contains(text(),'" + mpageName1 + "')]";
				String page1_actual = (driver.findElement(By.xpath(page1)).getText()).trim();

				if (page1_actual.equals(mpageName1)) {
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
			String page1 = "//span[contains(text(),'" + mpageName1 + "')]";
			driver.findElement(By.xpath(page1)).click();
			consoleMessage("Clicked on the first page name tab.");

			// click on the add field button
			click("customform_addfieldbtn_XPATH");

			// scroll to bottom
			scrollBottom();

			// enter field name
			type("customform_addfield_nametxt_XPATH", mpageFieldName1);

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
			String page11 = "//span[contains(text(),'" + mpageName1 + "')]";
			driver.findElement(By.xpath(page11)).click();
			consoleMessage("Clicked on the first page name tab.");

			// scroll to bottom
			scrollBottom();

			// validate the newly created field
			try {
				String field1 = "//span[text()='" + mpageFieldName1 + "']";
				String field1_actual = (driver.findElement(By.xpath(field1)).getText()).trim();

				if (field1_actual.equals(mpageFieldName1)) {
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
			type("customform_addfield_nametxt_XPATH", mpageFieldName2);

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
			String page111 = "//span[contains(text(),'" + mpageName1 + "')]";
			driver.findElement(By.xpath(page111)).click();
			consoleMessage("Clicked on the first page name tab.");

			// scroll to bottom
			scrollBottom();

			// validate the newly created field
			try {
				String field2 = "//span[text()='" + mpageFieldName2 + "']";
				String field2_actual = (driver.findElement(By.xpath(field2)).getText()).trim();

				if (field2_actual.equals(mpageFieldName2)) {
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

		// ADD THE DETAILS IN THE SINGLE TYPE CUSTOM FORM WITH THE RISK SCORE FROM THE
		// PORTFOLIO DASHBOARD
		title("ADD THE DETAILS IN THE SINGLE TYPE CUSTOM FORM WITH THE RISK SCORE FROM THE PORTFOLIO DASHBOARD");

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
				String customForm1 = "//td[text()='" + sname + "']";
				String customForm1_actual = (driver.findElement(By.xpath(customForm1)).getText()).trim();

				if (customForm1_actual.equals(sname)) {
					successMessage("The newly created custom form is displayed successfully.");

				} else {
					verificationFailedMessage("The newly created custom form is not displayed.");
				}

			} catch (Throwable t) {
				verificationFailedMessage("The newly created custom form is not displayed.");
			}

			// click on the custom form
			String customForm1 = "//td[text()='" + sname + "']";
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
			String firstField = "//input[@id='" + sfieldName1 + "TEXT']";
			driver.findElement(By.xpath(firstField)).sendKeys(sfieldDetail1);
			consoleMessage("Entered the details in the first field.");

			// enter the details in the second field
			String secondField = "//input[@id='" + sfieldName2 + "NUMBER']";
			driver.findElement(By.xpath(secondField)).sendKeys(sfieldDetail2);
			consoleMessage("Entered the details in the second field.");

			// click on the save button
			click("customform_portfoliodashboard_fields_savebtn_XPATH");

			// scroll to bottom
			scrollBottom();

			// wait for the element
			Thread.sleep(5000);

			// validate the details of the first field
			try {
				String firstField1 = "//span[contains(text(),'" + sfieldDetail1 + "')]";
				String firstField1_actual = (driver.findElement(By.xpath(firstField1)).getText()).trim();

				if (firstField1_actual.equals(sfieldDetail1)) {
					successMessage("The details of the first field is displayed successfully.");
				} else {
					verificationFailedMessage("The details of the first field is not displayed.");
				}
			} catch (Throwable t) {
				verificationFailedMessage("The details of the first field is not displayed.");
			}

			// validate the details of the second field
			try {
				String secondField1 = "//span[contains(text(),'" + sfieldDetail2 + "')]";
				String secondField1_actual = (driver.findElement(By.xpath(secondField1)).getText()).trim();

				if (secondField1_actual.equals(sfieldDetail2)) {
					successMessage("The details of the second field is displayed successfully.");
				} else {
					verificationFailedMessage("The details of the second field is not displayed.");
				}
			} catch (Throwable t) {
				verificationFailedMessage("The details of the second field is not displayed.");
			}

			// click on the first page name tab
			String pageTab1 = "//span[text()='" + spageName1 + "']";
			driver.findElement(By.xpath(pageTab1)).click();
			consoleMessage("Clicked on the first page name tab.");

			// ADD THE DETAILS IN THE FIELDS OF THE FIRST PAGE TAB
			title("ADD THE DETAILS IN THE FIELDS OF THE FIRST PAGE TAB");

			// scroll to bottom
			scrollBottom();

			// click on the edit field button
			click("customform_portfoliodashboard_editfieldbtn_XPATH");

			// enter the details in the first field
			String firstPageField = "//input[@id='" + spageFieldName1 + "TEXT']";
			driver.findElement(By.xpath(firstPageField)).sendKeys(spageFieldDetail1);
			consoleMessage("Entered the details in the first field.");

			// enter the details in the second field
			String secondPageField = "//input[@id='" + spageFieldName2 + "NUMBER']";
			driver.findElement(By.xpath(secondPageField)).sendKeys(spageFieldDetail2);
			consoleMessage("Entered the details in the second field.");

			// click on the save button
			click("customform_portfoliodashboard_fields_savebtn_XPATH");

			// scroll to bottom
			scrollBottom();

			// wait for the element
			Thread.sleep(5000);

			// validate the details of the first field of the first page
			try {
				String firstField1 = "//span[contains(text(),'" + spageFieldDetail1 + "')]";
				String firstField1_actual = (driver.findElement(By.xpath(firstField1)).getText()).trim();

				if (firstField1_actual.equals(spageFieldDetail1)) {
					successMessage("The details of the first field of the first page is displayed successfully.");
				} else {
					verificationFailedMessage("The details of the first field of the first page is not displayed.");
				}
			} catch (Throwable t) {
				verificationFailedMessage("The details of the first field of the first page is not displayed.");
			}

			// validate the details of the second field of the first page
			try {
				String secondField1 = "//span[contains(text(),'" + spageFieldDetail2 + "')]";
				String secondField1_actual = (driver.findElement(By.xpath(secondField1)).getText()).trim();

				if (secondField1_actual.equals(spageFieldDetail2)) {
					successMessage("The details of the second field of the first page is displayed successfully.");
				} else {
					verificationFailedMessage("The details of the second field of the first page is not displayed.");
				}
			} catch (Throwable t) {
				verificationFailedMessage("The details of the second field is of the first page not displayed.");
			}

			// ADD THE DETAILS IN THE FIELDS OF THE RISK SCORING TAB
			title("ADD THE DETAILS IN THE FIELDS OF THE RISK SCORING TAB");

			// click on the risk scoring tab
			click("customform_portfoliodashboard_riskscoringtab_XPATH");

			// select on the risk category option
			select("customform_riskcategorydd_XPATH", data.get("score_category"));

			// enter the score in the score field
			type("customform_scoretxt_XPATH", sscore);

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

		// ADD THE DETAILS IN THE MULTIPLE TYPE CUSTOM FORM RANDOMLY WITH THE RISK SCORE FROM THE PROPERTY SUMMARY DASHBOARD
		title("ADD THE DETAILS IN THE MULTIPLE TYPE CUSTOM FORM RANDOMLY WITH THE RISK SCORE FROM THE PROPERTY SUMMARY DASHBOARD");

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
				String customForm1 = "//td[text()='" + mname + "']";
				String customForm1_actual = (driver.findElement(By.xpath(customForm1)).getText()).trim();

				if (customForm1_actual.equals(mname)) {
					successMessage("The newly created custom form is displayed successfully.");

				} else {
					verificationFailedMessage("The newly created custom form is not displayed.");
				}

			} catch (Throwable t) {
				verificationFailedMessage("The newly created custom form is not displayed.");
			}

			// click on the custom form
			String customForm1 = "//td[text()='" + mname + "']";
			driver.findElement(By.xpath(customForm1)).click();
			consoleMessage("Clicked on the custom form.");

			// wait for the element
			Thread.sleep(5000);

			consoleMessage("The details in fields will entered " + mcount + " times.");

			// enter details in the fields on random number
			for (int i = 0; i < mcount; i++) {

				// click on the add button
				click("customform_portfoliodashboard_addbtn_XPATH");

				// wait for the element
				Thread.sleep(5000);

				// scroll to bottom
				scrollBottom();

				// enter the details in the first field
				mfield1Detail = RandomStringUtils.randomAlphabetic(8);
				String firstField = "//input[@id='" + mfieldName1 + "TEXT']";
				driver.findElement(By.xpath(firstField)).sendKeys(mfield1Detail);
				consoleMessage("Entered the details in the first field.");

				// collect the random details of the first field
				mfield1Detail_list.add(mfield1Detail);
				consoleMessage("New count of data of the field 1 : " + mfield1Detail_list.size());

				// enter the details in the second field
				mfield2Detail = RandomStringUtils.randomNumeric(3);
				String secondField = "//input[@id='" + mfieldName2 + "NUMBER']";
				driver.findElement(By.xpath(secondField)).sendKeys(mfield2Detail);
				consoleMessage("Entered the details in the second field.");

				// collect the random details of the second field
				mfield2Detail_list.add(mfield2Detail);
				consoleMessage("New count of data of the field 2 : " + mfield2Detail_list.size());

				// click on the page one tab
				String page1 = "//span[text()='" + mpageName1 + "']";
				driver.findElement(By.xpath(page1)).click();
				consoleMessage("Clicked on the page one tab.");

				// enter the details in the first field
				mpageField1Detail = RandomStringUtils.randomAlphabetic(8);
				String pageFirstField = "//input[@id='" + mpageFieldName1 + "TEXT']";
				driver.findElement(By.xpath(pageFirstField)).sendKeys(mpageField1Detail);
				consoleMessage("Entered the details in the first field.");

				// collect the random details of the first field
				mpageField1Detail_list.add(mpageField1Detail);
				consoleMessage("New count of data of the field 1 of page one : " + mpageField1Detail_list.size());

				// enter the details in the second field
				mpageField2Detail = RandomStringUtils.randomNumeric(3);
				String pageSecondField = "//input[@id='" + mpageFieldName2 + "NUMBER']";
				driver.findElement(By.xpath(pageSecondField)).sendKeys(mpageField2Detail);
				consoleMessage("Entered the details in the second field.");

				// collect the random details of the second field
				mpageField2Detail_list.add(mpageField2Detail);
				consoleMessage("New count of data of the field 2 of page one : " + mpageField2Detail_list.size());

				// click on the save button
				click("customform_portfoliodashboard_fields_savebtn_XPATH");

				// scrolldown to bottom
				scrollBottom();

				// wait for the element
				Thread.sleep(5000);

				// validate the details of the first field
				try {
					String firstField1 = "//span[contains(text(),'" + mfield1Detail + "')]";
					String firstField1_actual = (driver.findElement(By.xpath(firstField1)).getText()).trim();

					if (firstField1_actual.equals(mfield1Detail)) {
						successMessage("The details of the first field is displayed successfully.");
					} else {
						verificationFailedMessage("The details of the first field is not displayed.");
					}
				} catch (Throwable t) {
					verificationFailedMessage("The details of the first field is not displayed.");
				}

				// validate the details of the second field
				try {
					String secondField1 = "//span[contains(text(),'" + mfield2Detail + "')]";
					String secondField1_actual = (driver.findElement(By.xpath(secondField1)).getText()).trim();

					if (secondField1_actual.equals(mfield2Detail)) {
						successMessage("The details of the second field is displayed successfully.");
					} else {
						verificationFailedMessage("The details of the second field is not displayed.");
					}
				} catch (Throwable t) {
					verificationFailedMessage("The details of the second field is not displayed.");
				}

				// validate the details of the first field of page one
				try {
					String thirdField1 = "//span[contains(text(),'" + mpageField1Detail + "')]";
					String thirdField1_actual = (driver.findElement(By.xpath(thirdField1)).getText()).trim();

					if (thirdField1_actual.equals(mpageField1Detail)) {
						successMessage("The details of the first field of page one is displayed successfully.");
					} else {
						verificationFailedMessage("The details of the first field of page one is not displayed.");
					}
				} catch (Throwable t) {
					verificationFailedMessage("The details of the first field of page one is not displayed.");
				}

				// validate the details of the second field of page one
				try {
					String fourthField2 = "//span[contains(text(),'" + mpageField2Detail + "')]";
					String fourthField2_actual = (driver.findElement(By.xpath(fourthField2)).getText()).trim();

					if (fourthField2_actual.equals(mpageField2Detail)) {
						successMessage("The details of the second field of page one is displayed successfully.");
					} else {
						verificationFailedMessage("The details of the second field of page one is not displayed.");
					}
				} catch (Throwable t) {
					verificationFailedMessage("The details of the second field of page one is not displayed.");
				}

				// click on the newly created details of the custom form
				String record = "//span[text()='" + mfield1Detail + "']";
				driver.findElement(By.xpath(record)).click();
				consoleMessage("Clicked on the newly created details of the custom form.");

				// ADD THE DETAILS IN THE FIELDS OF THE RISK SCORING TAB
				title("ADD THE DETAILS IN THE FIELDS OF THE RISK SCORING TAB");

				// click on the risk scoring tab
				click("customform_portfoliodashboard_riskscoringtab_XPATH");

				// select on the risk category option
				select("customform_riskcategorydd_XPATH", data.get("score_category"));

				// enter the score in the score field
				mscore = RandomStringUtils.randomNumeric(2);
				type("customform_scoretxt_XPATH", mscore);

				// collect the random details of the risk score
				mscore_list.add(mscore);
				consoleMessage("New count of data of the risk score : " + mscore_list.size());

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
				
				int score_int = Integer.parseInt(mscore);
				mtotalScore = mtotalScore + score_int;

			}

			consoleMessage("End of for loop and The total number of count is " + mpageField1Detail_list.size());

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
				float sscore_float1 = Float.parseFloat(sscore);
				String mscore_string = Integer.toString(mtotalScore);
				float mscore_float1 = Float.parseFloat(mscore_string);
				float score_float1 = sscore_float1 + mscore_float1;
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
				int sscore_expected = Integer.parseInt(sscore);
				int score_expected = sscore_expected + mtotalScore;

				if (avgScore_actual == score_expected) {
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
				int score_expected = 0;

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

		// UPDATE THE RISK SCORING DETAILS OF THE SINGLE TYPE CUSTOM FORM FROM THE
		// PROPERTY SUMMARY DASHBOARD
		title("UPDATE THE RISK SCORING DETAILS OF THE SINGLE TYPE CUSTOM FORM FROM THE PROPERTY SUMMARY DASHBOARD");

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
				String customForm1 = "//td[text()='" + sname + "']";
				String customForm1_actual = (driver.findElement(By.xpath(customForm1)).getText()).trim();

				if (customForm1_actual.equals(sname)) {
					successMessage("The newly created custom form is displayed successfully.");

				} else {
					verificationFailedMessage("The newly created custom form is not displayed.");
				}

			} catch (Throwable t) {
				verificationFailedMessage("The newly created custom form is not displayed.");
			}

			// click on the custom form
			String customForm1 = "//td[text()='" + sname + "']";
			driver.findElement(By.xpath(customForm1)).click();
			consoleMessage("Clicked on the custom form.");

			// scroll to bottom
			scrollBottom();

			// validate the custom form as a title
			try {
				String customName = "//h4[contains(text(),'" + sname + "')]";
				String customName_actual = (driver.findElement(By.xpath(customName)).getText()).trim();

				if (customName_actual.equals(sname)) {
					successMessage("The custom form name is displayed correctly.");
				} else {
					verificationFailedMessage("The custom form is not displayed.");
				}
			} catch (Throwable t) {
				verificationFailedMessage("The custom form is not displayed.");
			}

			// UPDATE THE DETAILS OF THE RISK SCORING TAB
			title("UPDATE THE DETAILS OF THE RISK SCORING TAB");

			// click on the risk scoring tab
			click("customform_portfoliodashboard_riskscoringtab_XPATH");

			// scroll to bottom
			scrollBottom();

			// select on the risk category option
			select("customform_riskcategorydd_XPATH", data.get("score_category_update"));

			// enter the score in the score field
			type("customform_scoretxt_XPATH", supdatescore);

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

		// UPDATE THE RISK SCORE DETAILS OF THE RANDOMLY CREATED MULTIPLE TYPE CUSTOM
		// FORM FROM THE PORTFOLIO SUMMARY DASHBOARD
		title("UPDATE THE RISK SCORE DETAILS OF THE RANDOMLY CREATED MULTIPLE TYPE CUSTOM FORM FROM THE PORTFOLIO SUMMARY DASHBOARD");

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
				String customForm1 = "//td[text()='" + mname + "']";
				String customForm1_actual = (driver.findElement(By.xpath(customForm1)).getText()).trim();

				if (customForm1_actual.equals(mname)) {
					successMessage("The newly created custom form is displayed successfully.");

				} else {
					verificationFailedMessage("The newly created custom form is not displayed.");
				}

			} catch (Throwable t) {
				verificationFailedMessage("The newly created custom form is not displayed.");
			}

			// click on the custom form
			String customForm1 = "//td[text()='" + mname + "']";
			driver.findElement(By.xpath(customForm1)).click();
			consoleMessage("Clicked on the custom form.");

			// scroll down to bottom
			scrollBottom();

			consoleMessage("While Update, The details in fields will entered " + mcount + " times.");

			for (int k = 1; k <= mcount; k++) {

				// wait for the element
				Thread.sleep(3000);

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
				mupdatescore = RandomStringUtils.randomNumeric(2);
				type("customform_scoretxt_XPATH", mupdatescore);

				// collect the random details of the risk score
				mupdatescore_list.add(mupdatescore);
				consoleMessage("New count of data of the risk score : " + mupdatescore_list.size());

				// select the option from the status dropdown
				select("customform_statusdd_XPATH", data.get("risk_status_update"));

				// enter the text in description field
				type("customform_descriptiontxt_XPATH", data.get("details"));

				// click on the update button
				click("customform_portfoliodashboard_riskscoringupdatebtn_XPATH");

				int mupdatescore_int = Integer.parseInt(mupdatescore);
				mtotalUpdateScore = mtotalUpdateScore + mupdatescore_int;

				if (mcount > k) {

					// click on the back button
					click("customform_propertydashboard_backbtn_XPATH");
				}
			}

			consoleMessage(
					"While Update, End of for loop and The total number of count is " + mupdatescore_list.size());

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
				float supdatescore_float1 = Float.parseFloat(supdatescore);
				String mupdatescore_string = Integer.toString(mtotalUpdateScore);
				float mupdatescore_float1 = Float.parseFloat(mupdatescore_string);
				float updatescore_float1 = supdatescore_float1 + mupdatescore_float1;
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
				int supdatescore_int = Integer.parseInt(supdatescore);
				int updatescore_expected = supdatescore_int + mtotalUpdateScore;

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

			// click on the delete button of the single type custom form
			String sdeleteIcon = "//td[text()='" + sname
					+ "']//following-sibling::td[@class='pointer']//i[@data-target='#deleteCustomFormModal']";
			driver.findElement(By.xpath(sdeleteIcon)).click();
			consoleMessage("Clicked on the delete button of the updated custom form.");

			// wait for the element
			Thread.sleep(5000);

			// click on the delete button
			click("customform_deletebtn_XPATH");

			// validate the respective record is deleted or not
			try {
				String sdeletedRecord = "//td[text()='" + sname + "']";
				boolean sdeletedRecord_actual = driver.findElement(By.xpath(sdeletedRecord)).isDisplayed();

				if (sdeletedRecord_actual == true) {
					verificationFailedMessage("The deleted record of the custom form is displayed.");
				} else {
					successMessage("The deleted record of the custom form is not displayed as expected.");
				}

			} catch (Throwable t) {
				successMessage("The deleted record of the custom form is not displayed as expected.");
			}

			// click on the delete button of the multiple type custom form
			String mdeleteIcon = "//td[text()='" + mname
					+ "']//following-sibling::td[@class='pointer']//i[@data-target='#deleteCustomFormModal']";
			driver.findElement(By.xpath(mdeleteIcon)).click();
			consoleMessage("Clicked on the delete button of the updated custom form.");

			// wait for the element
			Thread.sleep(5000);

			// click on the delete button
			click("customform_deletebtn_XPATH");

			// validate the respective record is deleted or not
			try {
				String mdeletedRecord = "//td[text()='" + mname + "']";
				boolean mdeletedRecord_actual = driver.findElement(By.xpath(mdeletedRecord)).isDisplayed();

				if (mdeletedRecord_actual == true) {
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
