package testcases.E2Etestcasesuite.customformmodule;

import java.io.IOException;
import java.time.LocalDate;
import java.util.Hashtable;

import org.apache.commons.lang3.RandomStringUtils;
import org.openqa.selenium.By;
import org.testng.annotations.Test;

import base.TestBase;
import utilities.TestUtil;

public class RR6569CustomForm5Test extends TestBase {

	@Test(dataProviderClass = TestUtil.class, dataProvider = "dp")
	public void rR6569CustomForm5Test(Hashtable<String, String> data) throws IOException, InterruptedException {

		execution(data, "rR6569CustomForm5Test");

		// VERIFY THE LOCKDOWN PREVIOUS PERIOD FEATURE WITH MULTIPLE PROPERTIES AND
		// SINGLE CUSTOM FORM AND DIFFERENT DATES.
		title("VERIFY THE LOCKDOWN PREVIOUS PERIOD FEATURE WITH MULTIPLE PROPERTIES AND SINGLE CUSTOM FORM AND DIFFERENT DATES.");

		// refresh the page
		driver.navigate().refresh();
		Thread.sleep(5000);
		driver.navigate().refresh();

		String name = RandomStringUtils.randomAlphabetic(8); // Custom Form Name
		String fieldName1 = RandomStringUtils.randomAlphabetic(8); // Normal Field 1
		String fieldName2 = RandomStringUtils.randomAlphabetic(8); // Normal Field 2
		String fieldDetail11 = RandomStringUtils.randomAlphabetic(8); // Field Detail 1 of property one
		String fieldDetail12 = RandomStringUtils.randomNumeric(3); // Field Detail 2 of property one
		String pageName1 = RandomStringUtils.randomAlphabetic(8); // Page Name 1
		String pageFieldName1 = RandomStringUtils.randomAlphabetic(8); // Page Name 1 - Field 1
		String pageFieldName2 = RandomStringUtils.randomAlphabetic(8); // Page Name 1 - Field 2
		String pageFieldDetail11 = RandomStringUtils.randomAlphabetic(8); // Page Name 1 - Field Detail 1 of property
																			// one
		String pageFieldDetail12 = RandomStringUtils.randomNumeric(3); // Page Name 1 - Field Detail 2 of property one

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

			// enter the first page name name in the page name field
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

			// click on the update button
			click("customform_updatebtn_XPATH");

			// wait for the element
			explicitWaitClickable("closetoastmsg_CSS");

			// click on the toaster close button
			click("closetoastmsg_CSS");

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

			// click on the property one
			click("customform_portfoliodashboard_propertyname_XPATH");

			// ADD THE DETAILS IN THE FIELDS OF THE DETAILS TAB
			title("ADD THE DETAILS IN THE FIELDS OF THE DETAILS TAB");

			// scroll down to bottom
			scrollBottom();

			// click on the edit field button
			click("customform_portfoliodashboard_editfieldbtn_XPATH");

			// enter the details in the first field
			String firstField = "//input[@id='" + fieldName1 + "TEXT']";
			driver.findElement(By.xpath(firstField)).sendKeys(fieldDetail11);
			consoleMessage("Entered the details in the first field.");

			// enter the details in the second field
			String secondField = "//input[@id='" + fieldName2 + "NUMBER']";
			driver.findElement(By.xpath(secondField)).sendKeys(fieldDetail12);
			consoleMessage("Entered the details in the second field.");

			// click on the save button
			click("customform_portfoliodashboard_fields_savebtn_XPATH");

			// scroll to bottom
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

			// click on the first page name tab
			String pageTab1 = "//span[text()='" + pageName1 + "']";
			driver.findElement(By.xpath(pageTab1)).click();
			consoleMessage("Clicked on the first page name tab.");

			// ADD THE DETAILS IN THE FIELDS OF THE FIRST PAGE TAB
			title("ADD THE DETAILS IN THE FIELDS OF THE FIRST PAGE TAB");

			// scroll to bottom
			scrollBottom();

			// click on the edit field button
			click("customform_portfoliodashboard_editfieldbtn_XPATH");

			// enter the details in the first field
			String firstPageField = "//input[@id='" + pageFieldName1 + "TEXT']";
			driver.findElement(By.xpath(firstPageField)).sendKeys(pageFieldDetail11);
			consoleMessage("Entered the details in the first field.");

			// enter the details in the second field
			String secondPageField = "//input[@id='" + pageFieldName2 + "NUMBER']";
			driver.findElement(By.xpath(secondPageField)).sendKeys(pageFieldDetail12);
			consoleMessage("Entered the details in the second field.");

			// click on the save button
			click("customform_portfoliodashboard_fields_savebtn_XPATH");

			// scroll to bottom
			scrollBottom();

			// wait for the element
			Thread.sleep(5000);

			// validate the details of the first field of the first page
			try {
				String firstField1 = "//span[contains(text(),'" + pageFieldDetail11 + "')]";
				String firstField1_actual = (driver.findElement(By.xpath(firstField1)).getText()).trim();

				if (firstField1_actual.equals(pageFieldDetail11)) {
					successMessage("The details of the first field of the first page is displayed successfully.");
				} else {
					verificationFailedMessage("The details of the first field of the first page is not displayed.");
				}
			} catch (Throwable t) {
				verificationFailedMessage("The details of the first field of the first page is not displayed.");
			}

			// validate the details of the second field of the first page
			try {
				String secondField1 = "//span[contains(text(),'" + pageFieldDetail12 + "')]";
				String secondField1_actual = (driver.findElement(By.xpath(secondField1)).getText()).trim();

				if (secondField1_actual.equals(pageFieldDetail12)) {
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

		// VALIDATE THE EDIT FUNCTIONALITY WITH TODAY'S EFFECTIVE DATE FOR THE LOCK DOWN
		// PRERIOD WITH DIFFERENT DATES ON PORTFOLIO DASHBOARD - PROPERTY ONE
		title("VALIDATE THE EDIT FUNCTIONALITY WITH TODAY'S EFFECTIVE DATE FOR THE LOCK DOWN PRERIOD WITH DIFFERENT DATES ON PORTFOLIO DASHBOARD - PROPERTY ONE");

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

			// click on the action icon
			click("customform_portfoliodashboard_actionicon_XPATH");

			// click on the lock period option
			click("customform_portfoliodashboard_lockperiodoption_XPATH");

			// click on the property one
			click("customform_portfoliodashboard_propertyname_XPATH");

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
		// PRERIOD WITH DIFFERENT DATES ON PROPERTY SUMMARY DASHBOARD - PROPERTY ONE
		title("VALIDATE THE EDIT FUNCTIONALITY WITH TODAY'S EFFECTIVE DATE FOR THE LOCK DOWN PRERIOD WITH DIFFERENT DATES ON PROPERTY SUMMARY DASHBOARD - PROPERTY ONE");

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
		// PRERIOD WITH DIFFERENT DATES ON PORTFOLIO DASHBOARD - PROPERTY TWO
		title("VALIDATE THE EDIT FUNCTIONALITY WITH PAST EFFECTIVE DATE FOR THE LOCK DOWN PRERIOD WITH DIFFERENT DATES ON PORTFOLIO DASHBOARD - PROPERTY TWO");

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

			// click on the action icon
			click("customform_portfoliodashboard_actionicon_XPATH");

			// click on the lock period option
			click("customform_portfoliodashboard_lockperiodoption_XPATH");

			// click on the property one
			click("customform_portfoliodashboard_propertyname2_XPATH");

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
		// PRERIOD WITH DIFFERENT DATES ON PROPERTY SUMMARY DASHBOARD - PROPERTY TWO
		title("VALIDATE THE EDIT FUNCTIONALITY WITH PAST EFFECTIVE DATE FOR THE LOCK DOWN PRERIOD WITH DIFFERENT DATES ON PROPERTY SUMMARY DASHBOARD - PROPERTY TWO");

		try {

			// wait for the element
			Thread.sleep(5000);

			// click on the property
			click("propertysummary_property2_XPATH");

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

		// VALIDATE THE EDIT FUNCTIONALITY WITH FUTURE EFFECTIVE DATE FOR THE LOCK DOWN
		// PRERIOD WITH DIFFERENT DATES ON PORTFOLIO DASHBOARD
		title("VALIDATE THE EDIT FUNCTIONALITY WITH FUTURE EFFECTIVE DATE FOR THE LOCK DOWN PRERIOD WITH DIFFERENT DATES ON PORTFOLIO DASHBOARD");

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

			// wait for the element
			Thread.sleep(3000);

			// click on the action icon
			click("customform_portfoliodashboard_actionicon_XPATH");

			// click on the lock period option
			click("customform_portfoliodashboard_lockperiodoption_XPATH");

			// click on the property three
			click("customform_portfoliodashboard_propertyname3_XPATH");

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

	}
}
