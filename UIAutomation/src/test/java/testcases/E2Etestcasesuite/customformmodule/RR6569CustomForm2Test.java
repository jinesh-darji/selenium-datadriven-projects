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

public class RR6569CustomForm2Test extends TestBase {

	@Test(dataProviderClass = TestUtil.class, dataProvider = "dp")
	public void rR6569CustomForm2Test(Hashtable<String, String> data) throws IOException, InterruptedException {

		execution(data, "rR6569CustomForm2Test");

		// VERIFY THE LOCKDOWN PREVIOUS PERIOD FEATURE WITH MULTIPLE TYPES OF CUSTOM
		// FORMS MULTIPLE TIMES.
		title("VERIFY THE LOCKDOWN PREVIOUS PERIOD FEATURE WITH MULTIPLE TYPES OF CUSTOM FORMS MULTIPLE TIMES.");

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
		String field1Detail = null;
		String field2Detail = null;
		String pageField1Detail = null;
		String pageField2Detail = null;
		List<String> field1Detail_list = new ArrayList<String>();
		List<String> field2Detail_list = new ArrayList<String>();
		List<String> pageField1Detail_list = new ArrayList<String>();
		List<String> pageField2Detail_list = new ArrayList<String>();

		Random random = new Random();
		int count = random.nextInt(5 - 3) + 3;

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

		// VALIDATE THE EDIT FUNCTIONALITY WITH TODAY'S EFFECTIVE DATE FOR THE LOCK DOWN
		// PRERIOD WITH TODAY, PAST, AND FUTURE DATES ON PORTFOLIO DASHBOARD
		title("VALIDATE THE EDIT FUNCTIONALITY WITH TODAY'S EFFECTIVE DATE FOR THE LOCK DOWN PRERIOD WITH TODAY, PAST, AND FUTURE DATES ON PORTFOLIO DASHBOARD");

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
		// PRERIOD WITH TODAY, PAST, AND FUTURE DATES ON PROPERTY SUMMARY DASHBOARD
		title("VALIDATE THE EDIT FUNCTIONALITY WITH TODAY'S EFFECTIVE DATE FOR THE LOCK DOWN PRERIOD WITH TODAY, PAST, AND FUTURE DATES ON PROPERTY SUMMARY DASHBOARD");

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
			String first_record = "//span[text()='" + field1Detail_list.get(0) + "']";
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
		// PRERIOD WITH TODAY, PAST, AND FUTURE DATES ON PORTFOLIO DASHBOARD
		title("VALIDATE THE EDIT FUNCTIONALITY WITH PAST EFFECTIVE DATE FOR THE LOCK DOWN PRERIOD WITH TODAY, PAST, AND FUTURE DATES ON PORTFOLIO DASHBOARD");

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

			// validate the property list is displayed or not
			try {
				boolean property = driver
						.findElement(By.xpath(
								OR.getProperty("customform_portfoliodashboard_multiplecustomform_property1name_XPATH")))
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
		// PRERIOD WITH TODAY, PAST, AND FUTURE DATES ON PORTFOLIO DASHBOARD
		title("VALIDATE THE EDIT FUNCTIONALITY WITH FUTURE EFFECTIVE DATE FOR THE LOCK DOWN PRERIOD WITH TODAY, PAST, AND FUTURE DATES ON PORTFOLIO DASHBOARD");

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
			String first_record = "//span[text()='" + field1Detail_list.get(0) + "']";
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
