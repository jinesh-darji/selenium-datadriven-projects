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

public class RR6633Task8Test extends TestBase {

	@Test(dataProviderClass = TestUtil.class, dataProvider = "dp")
	public void rR6633Task8Test(Hashtable<String, String> data) throws IOException, InterruptedException {

		execution(data, "rR6633Task8Test");

		// VALIDATE THE “JUMP TO CUSTOM FORM“ OPTION WHEN THE TASK WAS CREATED UNDER THE
		// MULTIPLE TYPE CUSTOM FORM AND VALIDATE THE NAVIGATION OF THE “JUMP
		// SURVEY/INSPECTION/CUSTOM FORM“ BUTTON AFTER ASSOCIATING THE CORPORATE LEVEL
		// CUSTOM FORM WITH THE SAME TASK.
		title("VALIDATE THE “JUMP TO CUSTOM FORM“ OPTION WHEN THE TASK WAS CREATED UNDER THE MULTIPLE TYPE CUSTOM FORM AND VALIDATE THE NAVIGATION OF THE “JUMP SURVEY/INSPECTION/CUSTOM FORM“ BUTTON AFTER ASSOCIATING THE CORPORATE LEVEL CUSTOM FORM WITH THE SAME TASK.");

		// refresh the page
		driver.navigate().refresh();
		Thread.sleep(5000);
		driver.navigate().refresh();

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

		// CREATE NEW CUSTOM FORMS FOR CORPORATE LEVEL
		title("CREATE NEW CUSTOM FORMS FOR CORPORATE LEVEL");

		String name_c = RandomStringUtils.randomAlphabetic(8);
		String fieldName1_c = RandomStringUtils.randomAlphabetic(8);
		String fieldName2_c = RandomStringUtils.randomAlphabetic(8);
		String pageName1_c = RandomStringUtils.randomAlphabetic(8);
		String pageFieldName1_c = RandomStringUtils.randomAlphabetic(8);
		String pageFieldName2_c = RandomStringUtils.randomAlphabetic(8);
		String field1Detail_c = null;
		String field2Detail_c = null;
		String pageField1Detail_c = null;
		String pageField2Detail_c = null;
		List<String> field1Detail_list_c = new ArrayList<String>();
		List<String> field2Detail_list_c = new ArrayList<String>();
		List<String> pageField1Detail_list_c = new ArrayList<String>();
		List<String> pageField2Detail_list_c = new ArrayList<String>();

		Random random_c = new Random();
		int count_c = random_c.nextInt(5 - 3) + 3;

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
			type("customform_nametxt_XPATH", name_c);

			// click on the date sensitive checkbox
			click("customform_datesensitiveckbx_XPATH");

			// click on the Is Verification Workflow Enabled? checkbox
			click("customform_verificationckbx_XPATH");

			// click on the Is Corporate Form? checkbox
			click("customform_corporateformckbx_XPATH");

			// click on the save button
			click("customform_savebtn_XPATH");

			// wait for the element
			Thread.sleep(5000);

			// validate the name of the newly created custom form
			try {
				String Validation0 = "//td[text()='" + name_c + "']";
				String Validation0_actual = (driver.findElement(By.xpath(Validation0)).getText()).trim();

				if (Validation0_actual.equals(name_c)) {

					successMessage("The Name of the custom form is displayed correctly.");

				} else {
					verificationFailedMessage("The Name of the custom form is displayed correctly.");
				}

			} catch (Throwable t) {
				verificationFailedMessage("The Name of the custom form is displayed correctly.");
			}

			// click on the newly created custom record record
			String nameTitle = "//td[text()='" + name_c + "']";
			driver.findElement(By.xpath(nameTitle)).click();
			consoleMessage("Clicked on the newly created custom record record.");

			// click on the add field button
			click("customform_addfieldbtn_XPATH");

			// enter field name
			type("customform_addfield_nametxt_XPATH", fieldName1_c);

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
				String field1 = "//span[text()='" + fieldName1_c + "']";
				String field1_actual = (driver.findElement(By.xpath(field1)).getText()).trim();

				if (field1_actual.equals(fieldName1_c)) {
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
			type("customform_addfield_nametxt_XPATH", fieldName2_c);

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
				String field2 = "//span[text()='" + fieldName2_c + "']";
				String field2_actual = (driver.findElement(By.xpath(field2)).getText()).trim();

				if (field2_actual.equals(fieldName2_c)) {
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
			type("customform_portfoliodashboard_pagenametxt_XPATH", pageName1_c);

			// wait for the element
			Thread.sleep(5000);

			// click on the add button
			click("customform_portfoliodashboard_pagename_addbtn_XPATH");

			// validate the newly added page
			try {
				String page1 = "//span[contains(text(),'" + pageName1_c + "')]";
				String page1_actual = (driver.findElement(By.xpath(page1)).getText()).trim();

				if (page1_actual.equals(pageName1_c)) {
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
			String page1 = "//span[contains(text(),'" + pageName1_c + "')]";
			driver.findElement(By.xpath(page1)).click();
			consoleMessage("Clicked on the first page name tab.");

			// click on the add field button
			click("customform_addfieldbtn_XPATH");

			// scroll to bottom
			scrollBottom();

			// enter field name
			type("customform_addfield_nametxt_XPATH", pageFieldName1_c);

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
			String page11 = "//span[contains(text(),'" + pageName1_c + "')]";
			driver.findElement(By.xpath(page11)).click();
			consoleMessage("Clicked on the first page name tab.");

			// scroll to bottom
			scrollBottom();

			// validate the newly created field
			try {
				String field1 = "//span[text()='" + pageFieldName1_c + "']";
				String field1_actual = (driver.findElement(By.xpath(field1)).getText()).trim();

				if (field1_actual.equals(pageFieldName1_c)) {
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
			type("customform_addfield_nametxt_XPATH", pageFieldName2_c);

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
			String page111 = "//span[contains(text(),'" + pageName1_c + "')]";
			driver.findElement(By.xpath(page111)).click();
			consoleMessage("Clicked on the first page name tab.");

			// scroll to bottom
			scrollBottom();

			// validate the newly created field
			try {
				String field2 = "//span[text()='" + pageFieldName2_c + "']";
				String field2_actual = (driver.findElement(By.xpath(field2)).getText()).trim();

				if (field2_actual.equals(pageFieldName2_c)) {
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
				String customForm1 = "//td[text()='" + name_c + "']";
				String customForm1_actual = (driver.findElement(By.xpath(customForm1)).getText()).trim();

				if (customForm1_actual.equals(name_c)) {
					successMessage("The newly created custom form is displayed successfully.");

				} else {
					verificationFailedMessage("The newly created custom form is not displayed.");
				}

			} catch (Throwable t) {
				verificationFailedMessage("The newly created custom form is not displayed.");
			}

			// click on the custom form
			String customForm1 = "//td[text()='" + name_c + "']";
			driver.findElement(By.xpath(customForm1)).click();
			consoleMessage("Clicked on the custom form.");

			// wait for the element
			Thread.sleep(5000);

			consoleMessage("The details in fields will entered " + count_c + " times.");

			// enter details in the fields on random number
			for (int i = 0; i < count_c; i++) {

				// click on the add button
				click("customform_portfoliodashboard_addbtn_XPATH");

				// wait for the element
				Thread.sleep(5000);

				// scroll to bottom
				scrollBottom();

				// enter the details in the first field
				field1Detail_c = RandomStringUtils.randomAlphabetic(8);
				String firstField = "//input[@id='" + fieldName1_c + "TEXT']";
				driver.findElement(By.xpath(firstField)).sendKeys(field1Detail_c);
				consoleMessage("Entered the details in the first field.");

				// collect the random details of the first field
				field1Detail_list_c.add(field1Detail_c);
				consoleMessage("New count of data of the field 1 : " + field1Detail_list_c.size());

				// enter the details in the second field
				field2Detail_c = RandomStringUtils.randomNumeric(3);
				String secondField = "//input[@id='" + fieldName2_c + "NUMBER']";
				driver.findElement(By.xpath(secondField)).sendKeys(field2Detail_c);
				consoleMessage("Entered the details in the second field.");

				// collect the random details of the second field
				field2Detail_list_c.add(field2Detail_c);
				consoleMessage("New count of data of the field 2 : " + field2Detail_list_c.size());

				// click on the page one tab
				String page1 = "//span[text()='" + pageName1_c + "']";
				driver.findElement(By.xpath(page1)).click();
				consoleMessage("Clicked on the page one tab.");

				// enter the details in the first field
				pageField1Detail_c = RandomStringUtils.randomAlphabetic(8);
				String pageFirstField = "//input[@id='" + pageFieldName1_c + "TEXT']";
				driver.findElement(By.xpath(pageFirstField)).sendKeys(pageField1Detail_c);
				consoleMessage("Entered the details in the first field.");

				// collect the random details of the first field
				pageField1Detail_list_c.add(pageField1Detail_c);
				consoleMessage("New count of data of the field 1 of page one : " + pageField1Detail_list_c.size());

				// enter the details in the second field
				pageField2Detail_c = RandomStringUtils.randomNumeric(3);
				String pageSecondField = "//input[@id='" + pageFieldName2_c + "NUMBER']";
				driver.findElement(By.xpath(pageSecondField)).sendKeys(pageField2Detail_c);
				consoleMessage("Entered the details in the second field.");

				// collect the random details of the second field
				pageField2Detail_list_c.add(pageField2Detail_c);
				consoleMessage("New count of data of the field 2 of page one : " + pageField2Detail_list_c.size());

				// click on the save button
				click("customform_portfoliodashboard_fields_savebtn_XPATH");

				// scrolldown to bottom
				scrollBottom();

				// wait for the element
				Thread.sleep(5000);

				// validate the details of the first field
				try {
					String firstField1 = "//span[contains(text(),'" + field1Detail_c + "')]";
					String firstField1_actual = (driver.findElement(By.xpath(firstField1)).getText()).trim();

					if (firstField1_actual.equals(field1Detail_c)) {
						successMessage("The details of the first field is displayed successfully.");
					} else {
						verificationFailedMessage("The details of the first field is not displayed.");
					}
				} catch (Throwable t) {
					verificationFailedMessage("The details of the first field is not displayed.");
				}

				// validate the details of the second field
				try {
					String secondField1 = "//span[contains(text(),'" + field2Detail_c + "')]";
					String secondField1_actual = (driver.findElement(By.xpath(secondField1)).getText()).trim();

					if (secondField1_actual.equals(field2Detail_c)) {
						successMessage("The details of the second field is displayed successfully.");
					} else {
						verificationFailedMessage("The details of the second field is not displayed.");
					}
				} catch (Throwable t) {
					verificationFailedMessage("The details of the second field is not displayed.");
				}

				// validate the details of the first field of page one
				try {
					String thirdField1 = "//span[contains(text(),'" + pageField1Detail_c + "')]";
					String thirdField1_actual = (driver.findElement(By.xpath(thirdField1)).getText()).trim();

					if (thirdField1_actual.equals(pageField1Detail_c)) {
						successMessage("The details of the first field of page one is displayed successfully.");
					} else {
						verificationFailedMessage("The details of the first field of page one is not displayed.");
					}
				} catch (Throwable t) {
					verificationFailedMessage("The details of the first field of page one is not displayed.");
				}

				// validate the details of the second field of page one
				try {
					String fourthField2 = "//span[contains(text(),'" + pageField2Detail_c + "')]";
					String fourthField2_actual = (driver.findElement(By.xpath(fourthField2)).getText()).trim();

					if (fourthField2_actual.equals(pageField2Detail_c)) {
						successMessage("The details of the second field of page one is displayed successfully.");
					} else {
						verificationFailedMessage("The details of the second field of page one is not displayed.");
					}
				} catch (Throwable t) {
					verificationFailedMessage("The details of the second field of page one is not displayed.");
				}

			}

			consoleMessage("End of for loop and The total number of count is " + pageField1Detail_list_c.size());

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
		// DASHBOARD AND ASSOCIATE THE SAME TASK WITH THE NEWLY CREATED CORPORATE LEVEL
		// CUSTOM FORM
		title("CREATE THE NEW TASK UNDER THE MULTIPLE TYPE CUSTOM FORM FROM PROPERTY SUMMARY DASHBOARD AND ASSOCIATE THE SAME TASK WITH THE NEWLY CREATED CORPORATE LEVEL CUSTOM FORM");

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

		// VALIDATE THE NEWLY CREATED TASK UNDER MULTIPLE TYPE CUSTOM FOR IN THE TASK
		// MODULE AND ASSOCIATE THE SAME TASK WITH THE NEWLY CREATED CORPORATE LEVEL
		// CUSTOM FORM (PROPERTY SUMMARY DASHBOARD)
		title("VALIDATE THE NEWLY CREATED TASK UNDER MULTIPLE TYPE CUSTOM FOR IN THE TASK MODULE AND ASSOCIATE THE SAME TASK WITH THE NEWLY CREATED CORPORATE LEVEL CUSTOM FORM (PROPERTY SUMMARY DASHBOARD)");

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

			// click on the task
			String task = "//p[contains(text(),'" + taskTitle1 + "')]";
			driver.findElement(By.xpath(task)).click();
			consoleMessage("Clicked on the task");

			// click on the task association tab
			click("task_taskassociationtab_XPATH");

			// scroll down the screen
			scrollBottom();

			// validate the jump to survey/inspection/custom form button
			try {
				boolean jumpbtn = driver.findElement(By.xpath(OR.getProperty("task_taskassociationtab_jumpbtn_XPATH")))
						.isDisplayed();

				if (jumpbtn == true) {
					verificationFailedMessage("The jump to survey/inspection/custom form button is displayed.");

				} else {
					successMessage("The jump to survey/inspection/custom form button is not displayed as expected.");
				}
			} catch (Throwable t) {
				successMessage("The jump to survey/inspection/custom form button is not displayed as expected.");
			}

			// click on the custom form button
			click("task_taskassociationtab_customformbtn_XPATH");

			// select the newly created custom form from the dropdown
			select("survey_task_questionnairedd_CSS", name_c);

			// click on the save button
			click("survey_task_savebtn_XPATH");

			// scroll up the screen
			scrollTop();

			// click on the clear button
			click("task_createdtask_clearbtn_XPATH");

			// enter the data in the search field
			type("task_filter_CSS", taskTitle1);

			// click on the search button
			click("task_createdtask_searchbtn_XPATH");

			// verify newly created task is displayed or not
			try {
				task = "//p[contains(text(),'" + taskTitle1 + "')]";
				String task_actual = (driver.findElement(By.xpath(task)).getText()).trim();

				if (task_actual.equals(taskTitle1)) {
					successMessage("The newly created task is verified successfully.");
				} else {
					verificationFailedMessage("The newly created task is not verified.");
				}
			} catch (Throwable t) {
				verificationFailedMessage("The newly created task is not verified.");
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

		// VALIDATE THE JUMP SURVEY/INSPECTION/CUSTOM FORM BUTTON IS LAUNCHED ASSOCIATED
		// CORPORATE LEVEL CUSTOM FORM OF THE TASK AND VALIDATE THE JUMP TO MULTIPLE
		// TYPE CUSTOM FORM OPTION OF THE SAME TASK (PROPERTY SUMMARY DASHBOARD)
		title("VALIDATE THE JUMP SURVEY/INSPECTION/CUSTOM FORM BUTTON IS LAUNCHED ASSOCIATED CORPORATE LEVEL CUSTOM FORM OF THE TASK AND VALIDATE THE JUMP TO MULTIPLE TYPE CUSTOM FORM OPTION OF THE SAME TASK (PROPERTY SUMMARY DASHBOARD)");

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

			// click on the newly created task
			String task = "//p[contains(text(),'" + taskTitle1 + "')]";
			driver.findElement(By.xpath(task)).click();
			consoleMessage("click on the newly created task.");

			// wait for the element
			Thread.sleep(3000);

			// click on the task association tab
			click("task_taskassociationtab_XPATH");

			// scroll down the screen
			scrollBottom();

			// validate the survey radio button
			try {
				boolean surveybtn = driver.findElement(By.xpath(OR.getProperty("survey_task_surveybtn_disabled_XPATH")))
						.isEnabled();

				if (surveybtn == false) {
					successMessage("The radio button of survey is displayed disabled as expected.");
				} else {
					verificationFailedMessage("The radio button of survey is not displayed disabled.");
				}
			} catch (Throwable t) {
				verificationFailedMessage("The radio button of survey is not displayed disabled.");
			}

			// validate the inspection radio button
			try {
				boolean inspectionbtn = driver
						.findElement(By.xpath(OR.getProperty("task_taskassociationtab_inspectionbtn_disabled_XPATH")))
						.isEnabled();

				if (inspectionbtn == false) {
					successMessage("The radio button of inspection is displayed disabled as expected.");
				} else {
					verificationFailedMessage("The radio button of inspection is not displayed disabled.");
				}
			} catch (Throwable t) {
				verificationFailedMessage("The radio button of inspection is not displayed disabled.");
			}

			// validate the custom form radio button
			try {
				boolean customformbtn = driver
						.findElement(By.xpath(OR.getProperty("task_taskassociationtab_customformbtn_disabled_XPATH")))
						.isEnabled();

				if (customformbtn == false) {
					successMessage("The radio button of custom form is displayed disabled as expected.");
				} else {
					verificationFailedMessage("The radio button of custom form is not displayed disabled.");
				}
			} catch (Throwable t) {
				verificationFailedMessage("The radio button of custom form is not displayed disabled.");
			}

			// validate the dropdown of custom form
			try {
				boolean dropdown = driver
						.findElement(By.xpath(OR.getProperty("task_taskassociationtab_questionnerdd_disabled_XPATH")))
						.isEnabled();

				if (dropdown == false) {
					successMessage("The dropdown of custom form disabled as expected.");
				} else {
					verificationFailedMessage("The dropdown of custom form is not displayed disabled.");
				}
			} catch (Throwable t) {
				verificationFailedMessage("The dropdown of custom form is not displayed disabled.");
			}

			// validate the selected custom form is displayed or not
			try {
				String selectedQuestionnaire = "//option[@label='" + name_c + "' and @selected='selected']";
				boolean dropdown = driver.findElement(By.xpath(selectedQuestionnaire)).isDisplayed();

				if (dropdown == true) {
					successMessage("The selected option in the custom form dropdown is displayed as expected.");
				} else {
					verificationFailedMessage("The selected option in the custom form dropdown is not displayed.");
				}
			} catch (Throwable t) {
				verificationFailedMessage("The selected option in the custom form dropdown is not displayed.");
			}

			// validate the jump to survey/inspection/custom form button
			try {
				boolean jumpbtn = driver.findElement(By.xpath(OR.getProperty("task_taskassociationtab_jumpbtn_XPATH")))
						.isDisplayed();

				if (jumpbtn == true) {
					successMessage("The jump to survey/inspection/custom form button is displayed as expected.");
				} else {
					verificationFailedMessage("The jump to survey/inspection/custom form button is not displayed.");
				}
			} catch (Throwable t) {
				verificationFailedMessage("The jump to survey/inspection/custom form button is not displayed.");
			}

			// click on the jump to survey/inspection/custom form button
			click("task_taskassociationtab_jumpbtn_XPATH");

			// wait for the element
			Thread.sleep(10000);

			// scroll up to top
			scrollTop();

			// validate the custom form as a title
			try {
				String customName = "//h4[contains(text(),'" + name_c + "')]";
				String customName_actual = (driver.findElement(By.xpath(customName)).getText()).trim();

				if (customName_actual.equals(name_c)) {
					successMessage("The custom form name is displayed correctly.");
				} else {
					verificationFailedMessage("The custom form is not displayed.");
				}
			} catch (Throwable t) {
				verificationFailedMessage("The custom form is not displayed.");
			}

			for (int m = 0; m < count_c; m++) {

				// validate the details of the first field
				try {
					consoleMessage(field1Detail_list_c.get(m));
					String firstField1 = "//span[contains(text(),'" + field1Detail_list_c.get(m) + "')]";
					String firstField1_actual = (driver.findElement(By.xpath(firstField1)).getText()).trim();

					if (firstField1_actual.equals(field1Detail_list_c.get(m))) {
						successMessage("The details of the first field is displayed successfully.");
					} else {
						verificationFailedMessage("The details of the first field is not displayed.");
					}
				} catch (Throwable t) {
					verificationFailedMessage("The details of the first field is not displayed.");
				}

				// validate the details of the second field
				try {
					consoleMessage(field2Detail_list_c.get(m));
					String secondField1 = "//span[contains(text(),'" + field2Detail_list_c.get(m) + "')]";
					String secondField1_actual = (driver.findElement(By.xpath(secondField1)).getText()).trim();

					if (secondField1_actual.equals(field2Detail_list_c.get(m))) {
						successMessage("The details of the second field is displayed successfully.");
					} else {
						verificationFailedMessage("The details of the second field is not displayed.");
					}
				} catch (Throwable t) {
					verificationFailedMessage("The details of the second field is not displayed.");
				}

				// validate the details of the first field of page one
				try {
					consoleMessage(pageField1Detail_list_c.get(m));
					String firstField1 = "//span[contains(text(),'" + pageField1Detail_list_c.get(m) + "')]";
					String firstField1_actual = (driver.findElement(By.xpath(firstField1)).getText()).trim();

					if (firstField1_actual.equals(pageField1Detail_list_c.get(m))) {
						successMessage("The details of the first field of page one is displayed successfully.");
					} else {
						verificationFailedMessage("The details of the first field of page one is not displayed.");
					}
				} catch (Throwable t) {
					verificationFailedMessage("The details of the first field of page one is not displayed.");
				}

				// validate the details of the second field of page one
				try {
					consoleMessage(pageField2Detail_list_c.get(m));
					String secondField1 = "//span[contains(text(),'" + pageField2Detail_list_c.get(m) + "')]";
					String secondField1_actual = (driver.findElement(By.xpath(secondField1)).getText()).trim();

					if (secondField1_actual.equals(pageField2Detail_list_c.get(m))) {
						successMessage("The details of the second field of page one is displayed successfully.");
					} else {
						verificationFailedMessage("The details of the second field of page one is not displayed.");
					}
				} catch (Throwable t) {
					verificationFailedMessage("The details of the second field of page one is not displayed.");
				}

			}

			// wait for the element
			Thread.sleep(3000);

			// click on the back button
			click("customform_propertydashboard_backbtn_XPATH");

			// wait for the element
			Thread.sleep(3000);

			// scroll upto top
			scrollTop();

			// click on the clear button
			click("task_createdtask_clearbtn_XPATH");

			// enter the data in the search field
			type("task_filter_CSS", taskTitle1);

			// click on the search button
			click("task_createdtask_searchbtn_XPATH");

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

		// CREATE THE NEW TASK UNDER THE MULTIPLE TYPE CUSTOM FORM FROM PORTFOLIO
		// SUMMARY
		// DASHBOARD AND ASSOCIATE THE SAME TASK WITH THE NEWLY CREATED CORPORATE LEVEL
		// CUSTOM FORM
		title("CREATE THE NEW TASK UNDER THE MULTIPLE TYPE CUSTOM FORM FROM PORTFOLIO SUMMARY DASHBOARD AND ASSOCIATE THE SAME TASK WITH THE NEWLY CREATED CORPORATE LEVEL CUSTOM FORM");

		String taskTitle2 = RandomStringUtils.randomAlphabetic(8);

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

			// click on the property one
			click("customform_portfoliodashboard_multiplecustomform_property1name_XPATH");

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

		// VALIDATE THE NEWLY CREATED TASK UNDER MULTIPLE TYPE CUSTOM FOR IN THE TASK
		// MODULE AND ASSOCIATE THE SAME TASK WITH THE NEWLY CREATED CORPORATE LEVEL
		// CUSTOM FORM (PORTFOLIO SUMMARY DASHBOARD)
		title("VALIDATE THE NEWLY CREATED TASK UNDER MULTIPLE TYPE CUSTOM FOR IN THE TASK MODULE AND ASSOCIATE THE SAME TASK WITH THE NEWLY CREATED CORPORATE LEVEL CUSTOM FORM (PORTFOLIO SUMMARY DASHBOARD)");

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

			// click on the task
			String task = "//p[contains(text(),'" + taskTitle2 + "')]";
			driver.findElement(By.xpath(task)).click();
			consoleMessage("Clicked on the task");

			// click on the task association tab
			click("task_taskassociationtab_XPATH");

			// scroll down the screen
			scrollBottom();

			// validate the jump to survey/inspection/custom form button
			try {
				boolean jumpbtn = driver.findElement(By.xpath(OR.getProperty("task_taskassociationtab_jumpbtn_XPATH")))
						.isDisplayed();

				if (jumpbtn == true) {
					verificationFailedMessage("The jump to survey/inspection/custom form button is displayed.");

				} else {
					successMessage("The jump to survey/inspection/custom form button is not displayed as expected.");
				}
			} catch (Throwable t) {
				successMessage("The jump to survey/inspection/custom form button is not displayed as expected.");
			}

			// click on the custom form button
			click("task_taskassociationtab_customformbtn_XPATH");

			// select the newly created custom form from the dropdown
			select("survey_task_questionnairedd_CSS", name_c);

			// click on the save button
			click("survey_task_savebtn_XPATH");

			// scroll up the screen
			scrollTop();

			// click on the clear button
			click("task_createdtask_clearbtn_XPATH");

			// enter the data in the search field
			type("task_filter_CSS", taskTitle2);

			// click on the search button
			click("task_createdtask_searchbtn_XPATH");

			// verify newly created task is displayed or not
			try {
				task = "//p[contains(text(),'" + taskTitle2 + "')]";
				String task_actual = (driver.findElement(By.xpath(task)).getText()).trim();

				if (task_actual.equals(taskTitle2)) {
					successMessage("The newly created task is verified successfully.");
				} else {
					verificationFailedMessage("The newly created task is not verified.");
				}
			} catch (Throwable t) {
				verificationFailedMessage("The newly created task is not verified.");
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

		// VALIDATE THE JUMP SURVEY/INSPECTION/CUSTOM FORM BUTTON IS LAUNCHED ASSOCIATED
		// CORPORATE LEVEL CUSTOM FORM OF THE TASK AND VALIDATE THE JUMP TO MULTIPLE
		// TYPE CUSTOM FORM OPTION OF THE SAME TASK (PORTFOLIO SUMMARY DASHBOARD)
		title("VALIDATE THE JUMP SURVEY/INSPECTION/CUSTOM FORM BUTTON IS LAUNCHED ASSOCIATED CORPORATE LEVEL CUSTOM FORM OF THE TASK AND VALIDATE THE JUMP TO MULTIPLE TYPE CUSTOM FORM OPTION OF THE SAME TASK (PORTFOLIO SUMMARY DASHBOARD)");

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

			// click on the newly created task
			String task = "//p[contains(text(),'" + taskTitle2 + "')]";
			driver.findElement(By.xpath(task)).click();
			consoleMessage("click on the newly created task.");

			// wait for the element
			Thread.sleep(3000);

			// click on the task association tab
			click("task_taskassociationtab_XPATH");

			// scroll down the screen
			scrollBottom();

			// validate the survey radio button
			try {
				boolean surveybtn = driver.findElement(By.xpath(OR.getProperty("survey_task_surveybtn_disabled_XPATH")))
						.isEnabled();

				if (surveybtn == false) {
					successMessage("The radio button of survey is displayed disabled as expected.");
				} else {
					verificationFailedMessage("The radio button of survey is not displayed disabled.");
				}
			} catch (Throwable t) {
				verificationFailedMessage("The radio button of survey is not displayed disabled.");
			}

			// validate the inspection radio button
			try {
				boolean inspectionbtn = driver
						.findElement(By.xpath(OR.getProperty("task_taskassociationtab_inspectionbtn_disabled_XPATH")))
						.isEnabled();

				if (inspectionbtn == false) {
					successMessage("The radio button of inspection is displayed disabled as expected.");
				} else {
					verificationFailedMessage("The radio button of inspection is not displayed disabled.");
				}
			} catch (Throwable t) {
				verificationFailedMessage("The radio button of inspection is not displayed disabled.");
			}

			// validate the custom form radio button
			try {
				boolean customformbtn = driver
						.findElement(By.xpath(OR.getProperty("task_taskassociationtab_customformbtn_disabled_XPATH")))
						.isEnabled();

				if (customformbtn == false) {
					successMessage("The radio button of custom form is displayed disabled as expected.");
				} else {
					verificationFailedMessage("The radio button of custom form is not displayed disabled.");
				}
			} catch (Throwable t) {
				verificationFailedMessage("The radio button of custom form is not displayed disabled.");
			}

			// validate the dropdown of custom form
			try {
				boolean dropdown = driver
						.findElement(By.xpath(OR.getProperty("task_taskassociationtab_questionnerdd_disabled_XPATH")))
						.isEnabled();

				if (dropdown == false) {
					successMessage("The dropdown of custom form disabled as expected.");
				} else {
					verificationFailedMessage("The dropdown of custom form is not displayed disabled.");
				}
			} catch (Throwable t) {
				verificationFailedMessage("The dropdown of custom form is not displayed disabled.");
			}

			// validate the selected custom form is displayed or not
			try {
				String selectedQuestionnaire = "//option[@label='" + name_c + "' and @selected='selected']";
				boolean dropdown = driver.findElement(By.xpath(selectedQuestionnaire)).isDisplayed();

				if (dropdown == true) {
					successMessage("The selected option in the custom form dropdown is displayed as expected.");
				} else {
					verificationFailedMessage("The selected option in the custom form dropdown is not displayed.");
				}
			} catch (Throwable t) {
				verificationFailedMessage("The selected option in the custom form dropdown is not displayed.");
			}

			// validate the jump to survey/inspection/custom form button
			try {
				boolean jumpbtn = driver.findElement(By.xpath(OR.getProperty("task_taskassociationtab_jumpbtn_XPATH")))
						.isDisplayed();

				if (jumpbtn == true) {
					successMessage("The jump to survey/inspection/custom form button is displayed as expected.");
				} else {
					verificationFailedMessage("The jump to survey/inspection/custom form button is not displayed.");
				}
			} catch (Throwable t) {
				verificationFailedMessage("The jump to survey/inspection/custom form button is not displayed.");
			}

			// click on the jump to survey/inspection/custom form button
			click("task_taskassociationtab_jumpbtn_XPATH");

			// wait for the element
			Thread.sleep(10000);

			// scroll up to top
			scrollTop();

			// validate the custom form as a title
			try {
				String customName = "//h4[contains(text(),'" + name_c + "')]";
				String customName_actual = (driver.findElement(By.xpath(customName)).getText()).trim();

				if (customName_actual.equals(name_c)) {
					successMessage("The custom form name is displayed correctly.");
				} else {
					verificationFailedMessage("The custom form is not displayed.");
				}
			} catch (Throwable t) {
				verificationFailedMessage("The custom form is not displayed.");
			}

			for (int m = 0; m < count_c; m++) {

				// validate the details of the first field
				try {
					consoleMessage(field1Detail_list_c.get(m));
					String firstField1 = "//span[contains(text(),'" + field1Detail_list_c.get(m) + "')]";
					String firstField1_actual = (driver.findElement(By.xpath(firstField1)).getText()).trim();

					if (firstField1_actual.equals(field1Detail_list_c.get(m))) {
						successMessage("The details of the first field is displayed successfully.");
					} else {
						verificationFailedMessage("The details of the first field is not displayed.");
					}
				} catch (Throwable t) {
					verificationFailedMessage("The details of the first field is not displayed.");
				}

				// validate the details of the second field
				try {
					consoleMessage(field2Detail_list_c.get(m));
					String secondField1 = "//span[contains(text(),'" + field2Detail_list_c.get(m) + "')]";
					String secondField1_actual = (driver.findElement(By.xpath(secondField1)).getText()).trim();

					if (secondField1_actual.equals(field2Detail_list_c.get(m))) {
						successMessage("The details of the second field is displayed successfully.");
					} else {
						verificationFailedMessage("The details of the second field is not displayed.");
					}
				} catch (Throwable t) {
					verificationFailedMessage("The details of the second field is not displayed.");
				}

				// validate the details of the first field of page one
				try {
					consoleMessage(pageField1Detail_list_c.get(m));
					String firstField1 = "//span[contains(text(),'" + pageField1Detail_list_c.get(m) + "')]";
					String firstField1_actual = (driver.findElement(By.xpath(firstField1)).getText()).trim();

					if (firstField1_actual.equals(pageField1Detail_list_c.get(m))) {
						successMessage("The details of the first field of page one is displayed successfully.");
					} else {
						verificationFailedMessage("The details of the first field of page one is not displayed.");
					}
				} catch (Throwable t) {
					verificationFailedMessage("The details of the first field of page one is not displayed.");
				}

				// validate the details of the second field of page one
				try {
					consoleMessage(pageField2Detail_list_c.get(m));
					String secondField1 = "//span[contains(text(),'" + pageField2Detail_list_c.get(m) + "')]";
					String secondField1_actual = (driver.findElement(By.xpath(secondField1)).getText()).trim();

					if (secondField1_actual.equals(pageField2Detail_list_c.get(m))) {
						successMessage("The details of the second field of page one is displayed successfully.");
					} else {
						verificationFailedMessage("The details of the second field of page one is not displayed.");
					}
				} catch (Throwable t) {
					verificationFailedMessage("The details of the second field of page one is not displayed.");
				}

			}

			// wait for the element
			Thread.sleep(3000);

			// click on the back button
			click("customform_propertydashboard_backbtn_XPATH");

			// wait for the element
			Thread.sleep(3000);

			// scroll upto top
			scrollTop();

			// click on the clear button
			click("task_createdtask_clearbtn_XPATH");

			// enter the data in the search field
			type("task_filter_CSS", taskTitle1);

			// click on the search button
			click("task_createdtask_searchbtn_XPATH");

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

			// click on the delete option
			String deleteOption = "//p[text()='" + taskTitle1
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
			type("task_filter_CSS", taskTitle1);

			// click on the search button
			click("task_createdtask_searchbtn_XPATH");

			// validate the deleted task
			try {
				String task = "//p[contains(text(),'" + taskTitle1 + "')]";
				String task_actual = (driver.findElement(By.xpath(task)).getText()).trim();

				if (task_actual.equals(taskTitle1)) {
					verificationFailedMessage("The newly created task is not deleted.");
				} else {
					successMessage("The newly created task is deleted successfully.");
				}
			} catch (Throwable t) {
				successMessage("The newly created task is deleted successfully.");
			}

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
			String actionIcon2 = "//p[text()='" + taskTitle2
					+ "']//parent::td//following-sibling::td[@class='text-center pointer']//i[@data-toggle='dropdown']";
			driver.findElement(By.xpath(actionIcon2)).click();
			consoleMessage("Clicked on the action icon.");

			// click on the delete option
			String deleteOption2 = "//p[text()='" + taskTitle2
					+ "']//parent::td//following-sibling::td[@class='text-center pointer']//div[@class='dropdown open']//li[@ng-click='deleteSelectedTask(task.id, false);']";
			driver.findElement(By.xpath(deleteOption2)).click();
			consoleMessage("Clicked on the delete option.");

			// wait for the element
			explicitWaitClickable("closetoastmsg_CSS");

			// click on the toaster close button
			click("closetoastmsg_CSS");

			// click on the clear button
			click("task_createdtask_clearbtn_XPATH");

			// enter the data in the search field
			type("task_filter_CSS", taskTitle2);

			// click on the search button
			click("task_createdtask_searchbtn_XPATH");

			// validate the deleted task
			try {
				String task = "//p[contains(text(),'" + taskTitle2 + "')]";
				String task_actual = (driver.findElement(By.xpath(task)).getText()).trim();

				if (task_actual.equals(taskTitle2)) {
					verificationFailedMessage("The newly created task is not deleted.");
				} else {
					successMessage("The newly created task is deleted successfully.");
				}
			} catch (Throwable t) {
				successMessage("The newly created task is deleted successfully.");
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
			String deleteIcon = "//td[text()='" + name_m
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

			// wait for the element
			Thread.sleep(5000);

			// click on the delete button of the newly created custom form
			String deleteIcon_c = "//td[text()='" + name_c
					+ "']//following-sibling::td[@class='pointer']//i[@data-target='#deleteCustomFormModal']";
			driver.findElement(By.xpath(deleteIcon_c)).click();
			consoleMessage("click on the delete button of the newly created custom form.");

			// wait for the element
			Thread.sleep(5000);

			// click on the delete button
			click("customform_deletebtn_XPATH");

			// wait for the element
			Thread.sleep(3000);

			// validate the deleted custom form
			try {
				String customform = "//td[text()='" + name_c + "']";
				String customform_actual = (driver.findElement(By.xpath(customform)).getText()).trim();

				if (customform_actual.equals(name_c)) {
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
