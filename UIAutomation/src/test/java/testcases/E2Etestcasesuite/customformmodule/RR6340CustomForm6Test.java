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

public class RR6340CustomForm6Test extends TestBase {

	@Test(dataProviderClass = TestUtil.class, dataProvider = "dp")
	public void rR6340CustomForm6Test(Hashtable<String, String> data) throws IOException, InterruptedException {

		execution(data, "rR6340CustomForm6Test");

		// ADD THE RAMDOM NUMBER OF DETAILS IN THE FIELDS AND PAGES OF THE CUSTOM
		// RECORDS OF THE SAME PROPERTY AND VALIDATE IN THE PORTFOLIO DASHBOARD AND
		// PROPERTY SUMMARY DASHBOARD - MULTIPLE TYPE

		title("ADD THE RAMDOM NUMBER OF DETAILS IN THE FIELDS AND PAGES OF THE CUSTOM RECORDS OF THE SAME PROPERTY AND VALIDATE IN THE PORTFOLIO DASHBOARD AND PROPERTY SUMMARY DASHBOARD - MULTIPLE TYPE");

		// refresh the page
		driver.navigate().refresh();
		Thread.sleep(5000);
		driver.navigate().refresh();

		System.out.println("Navigate to the Home Screen i.e. Property List Screen.");

		String fieldName1 = RandomStringUtils.randomAlphabetic(8);
		String fieldName2 = RandomStringUtils.randomAlphabetic(8);
		String pageName1 = RandomStringUtils.randomAlphabetic(8);
		String pageFieldName1 = RandomStringUtils.randomAlphabetic(8);
		String pageFieldName2 = RandomStringUtils.randomAlphabetic(8);
		String field1Detail = null;
		String field2Detail = null;
		String pageField1Detail = null;
		String pageField2Detail = null;
		String updateField1Detail = null;
		String updateField2Detail = null;
		String updateField1Detail2 = null;
		String updateField2Detail2 = null;
		String pageUpdateField1Detail = null;
		String pageUpdateField2Detail = null;
		String pageUpdateField1Detail2 = null;
		String pageUpdateField2Detail2 = null;
		List<String> field1Detail_list = new ArrayList<String>();
		List<String> field2Detail_list = new ArrayList<String>();
		List<String> pageField1Detail_list = new ArrayList<String>();
		List<String> pageField2Detail_list = new ArrayList<String>();
		List<String> updateField1Detail_list = new ArrayList<String>();
		List<String> updateField2Detail_list = new ArrayList<String>();
		List<String> updateField1Detail2_list = new ArrayList<String>();
		List<String> updateField2Detail2_list = new ArrayList<String>();
		List<String> pageUpdateField1Detail_list = new ArrayList<String>();
		List<String> pageUpdateField2Detail_list = new ArrayList<String>();
		List<String> pageUpdateField1Detail2_list = new ArrayList<String>();
		List<String> pageUpdateField2Detail2_list = new ArrayList<String>();

		Random random = new Random();
		int count = random.nextInt(5 - 3) + 3;
		int count2 = 0;

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
			type("customform_nametxt_XPATH", data.get("name"));

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

		// VALIDATE ADDED DETAILS OF THE FIELDS AND PAGES DISPLAYED IN THE PORTFOLIO
		// SUMMARY DASHBOARD
		title("VALIDATE ADDED DETAILS OF THE FIELDS AND PAGES DISPLAYED IN THE PORTFOLIO SUMMARY DASHBOARD");

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

			int count1 = field1Detail_list.size();
			for (int j = 0; j < count1; j++) {

				// validate the field 1
				try {
					String field11 = "//td[text()='[DND] AAAA Risk Test Prop 01']//following-sibling::td[@ng-click='viewPropertyTab(property)']//span[text()='"
							+ field1Detail_list.get(j) + "']";
					String field11_actual = (driver.findElement(By.xpath(field11)).getText()).trim();

					if (field11_actual.equals(field1Detail_list.get(j))) {
						successMessage("The respective field is displayed successfully.");
					} else {
						verificationFailedMessage("The repsective field is not displayed.");
					}
				} catch (Throwable t) {
					verificationFailedMessage("The repsective field is not displayed.");
				}

				// validate the field 2
				try {
					String field22 = "//td[text()='[DND] AAAA Risk Test Prop 01']//following-sibling::td[@ng-click='viewPropertyTab(property)']//span[text()='"
							+ field2Detail_list.get(j) + "']";
					String field22_actual = (driver.findElement(By.xpath(field22)).getText()).trim();

					if (field22_actual.equals(field2Detail_list.get(j))) {
						successMessage("The respective field is displayed successfully.");
					} else {
						verificationFailedMessage("The repsective field is not displayed.");
					}
				} catch (Throwable t) {
					verificationFailedMessage("The repsective field is not displayed.");
				}

				// validate the field 1 of page one
				try {
					String field11 = "//td[text()='[DND] AAAA Risk Test Prop 01']//following-sibling::td[@ng-click='viewPropertyTab(property)']//span[text()='"
							+ pageField1Detail_list.get(j) + "']";
					String field11_actual = (driver.findElement(By.xpath(field11)).getText()).trim();

					if (field11_actual.equals(pageField1Detail_list.get(j))) {
						successMessage("The respective field of page one is displayed successfully.");
					} else {
						verificationFailedMessage("The repsective field of page one is not displayed.");
					}
				} catch (Throwable t) {
					verificationFailedMessage("The repsective field of page one is not displayed.");
				}

				// validate the field 2 of page one
				try {
					String field22 = "//td[text()='[DND] AAAA Risk Test Prop 01']//following-sibling::td[@ng-click='viewPropertyTab(property)']//span[text()='"
							+ pageField2Detail_list.get(j) + "']";
					String field22_actual = (driver.findElement(By.xpath(field22)).getText()).trim();

					if (field22_actual.equals(pageField2Detail_list.get(j))) {
						successMessage("The respective field of page one is displayed successfully.");
					} else {
						verificationFailedMessage("The repsective field of page one is not displayed.");
					}
				} catch (Throwable t) {
					verificationFailedMessage("The repsective field of page one is not displayed.");
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

		// UPDATE THE DETAILS OF THE FIELDS AND PAGES RANDOMLY FROM THE PORTFOLIO
		// SUMMARY DASHBOARD
		title("UPDATE THE DETAILS OF THE FIELDS AND PAGES RANDOMLY FROM THE PORTFOLIO SUMMARY DASHBOARD");

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

			consoleMessage("While Update, The details in fields will entered " + count + " times.");

			for (int k = 0; k < count; k++) {

				// wait for the element
				Thread.sleep(3000);

				// click on the property one
				String ele1 = "(//td[text()='[DND] AAAA Risk Test Prop 01'])[" + (k + 1) + "]";
				driver.findElement(By.xpath(ele1)).click();
				consoleMessage("click on the property one i.e. " + (k + 1));

				// scrolldown to bottom
				scrollBottom();

				// click on the edit field button
				click("customform_portfoliodashboard_editfieldbtn_XPATH");

				// enter the details in the first field
				updateField1Detail = RandomStringUtils.randomAlphabetic(8);
				String firstField2 = "//input[@id='" + fieldName1 + "TEXT']";
				driver.findElement(By.xpath(firstField2)).clear();
				driver.findElement(By.xpath(firstField2)).sendKeys(updateField1Detail);
				consoleMessage("Entered the details in the first field.");

				// collect the random details of the first field
				updateField1Detail_list.add(updateField1Detail);
				consoleMessage("New count of data of the field 1 : " + updateField1Detail_list.size());

				// enter the details in the second field
				updateField2Detail = RandomStringUtils.randomNumeric(3);
				String secondField2 = "//input[@id='" + fieldName2 + "NUMBER']";
				driver.findElement(By.xpath(secondField2)).clear();
				driver.findElement(By.xpath(secondField2)).sendKeys(updateField2Detail);
				consoleMessage("Entered the details in the second field.");

				// collect the random details of the second field
				updateField2Detail_list.add(updateField2Detail);
				consoleMessage("New count of data of the field 2 : " + updateField2Detail_list.size());

				// click on the page one tab
				String page1 = "//span[text()='" + pageName1 + "']";
				driver.findElement(By.xpath(page1)).click();
				consoleMessage("Clicked on the page one tab.");

				// enter the details in the first field of page one
				pageUpdateField1Detail = RandomStringUtils.randomAlphabetic(8);
				String pageFirstField2 = "//input[@id='" + pageFieldName1 + "TEXT']";
				driver.findElement(By.xpath(pageFirstField2)).clear();
				driver.findElement(By.xpath(pageFirstField2)).sendKeys(pageUpdateField1Detail);
				consoleMessage("Entered the details in the first field.");

				// collect the random details of the first field of page one
				pageUpdateField1Detail_list.add(pageUpdateField1Detail);
				consoleMessage("New count of data of the field 1 : " + pageUpdateField1Detail_list.size());

				// enter the details in the second field of page one
				pageUpdateField2Detail = RandomStringUtils.randomNumeric(3);
				String pageSecondField2 = "//input[@id='" + pageFieldName2 + "NUMBER']";
				driver.findElement(By.xpath(pageSecondField2)).clear();
				driver.findElement(By.xpath(pageSecondField2)).sendKeys(pageUpdateField2Detail);
				consoleMessage("Entered the details in the second field.");

				// collect the random details of the second field of page one
				pageUpdateField2Detail_list.add(pageUpdateField2Detail);
				consoleMessage("New count of data of the field 2 : " + pageUpdateField2Detail_list.size());

				// click on the save button
				click("customform_portfoliodashboard_fields_savebtn_XPATH");

				// scrolldown to bottom
				scrollBottom();

				// click on the details tab
				String tab1 = "//span[text()='Details']";
				driver.findElement(By.xpath(tab1)).click();
				consoleMessage("Clicked on the details tab.");

				// wait for the element
				Thread.sleep(5000);

				// validate the details of the first field
				try {
					String firstField11 = "//span[contains(text(),'" + updateField1Detail + "')]";
					String firstField11_actual = (driver.findElement(By.xpath(firstField11)).getText()).trim();

					if (firstField11_actual.equals(updateField1Detail)) {
						successMessage("The details of the first field is displayed successfully.");
					} else {
						verificationFailedMessage("The details of the first field is not displayed.");
					}
				} catch (Throwable t) {
					verificationFailedMessage("The details of the first field is not displayed.");
				}

				// validate the details of the second field
				try {
					String secondField11 = "//span[contains(text(),'" + updateField2Detail + "')]";
					String secondField11_actual = (driver.findElement(By.xpath(secondField11)).getText()).trim();

					if (secondField11_actual.equals(updateField2Detail)) {
						successMessage("The details of the second field is displayed successfully.");
					} else {
						verificationFailedMessage("The details of the second field is not displayed.");
					}
				} catch (Throwable t) {
					verificationFailedMessage("The details of the second field is not displayed.");
				}

				// click on the first page tab
				String tab2 = "//span[text()='" + pageName1 + "']";
				driver.findElement(By.xpath(tab2)).click();
				consoleMessage("Clicked on the first page tab.");

				// wait for the element
				Thread.sleep(5000);

				// validate the details of the first field of page one
				try {
					String firstField11 = "//span[contains(text(),'" + pageUpdateField1Detail + "')]";
					String firstField11_actual = (driver.findElement(By.xpath(firstField11)).getText()).trim();

					if (firstField11_actual.equals(pageUpdateField1Detail)) {
						successMessage("The details of the first field of page one is displayed successfully.");
					} else {
						verificationFailedMessage("The details of the first field of page one is not displayed.");
					}
				} catch (Throwable t) {
					verificationFailedMessage("The details of the first field of page one is not displayed.");
				}

				// validate the details of the second field of page one
				try {
					String secondField11 = "//span[contains(text(),'" + pageUpdateField2Detail + "')]";
					String secondField11_actual = (driver.findElement(By.xpath(secondField11)).getText()).trim();

					if (secondField11_actual.equals(pageUpdateField2Detail)) {
						successMessage("The details of the second field of page one is displayed successfully.");
					} else {
						verificationFailedMessage("The details of the second field of page one is not displayed.");
					}
				} catch (Throwable t) {
					verificationFailedMessage("The details of the second field of page one is not displayed.");
				}

				count2 = count2 + k;

				if (!(count == count2)) {

					// click on the back button
					click("customform_propertydashboard_backbtn_XPATH");
				}
			}

			consoleMessage(
					"While Update, End of for loop and The total number of count is " + updateField1Detail_list.size());

		} catch (Throwable t) {
			verificationFailed();
		}

		// click on the home icon from the top of the screen
		click("questionnaire_homeburgermenubtn_hide_CSS");

		// wait for the element
		explicitWait("propertylist_title_XPATH");

		// verify the property list
		switchVerification("propertylist_title_XPATH", "Property List", "The property list is not displayed.");

		// VALIDATE THE UPDATED FIELDS AND PAGES DETAIL FROM THE PROPERTY SUMMARY
		// DASHBOARD
		title("VALIDATE THE UPDATED FIELDS AND PAGES DETAIL FROM THE PROPERTY SUMMARY DASHBOARD");

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

			// wait for the element
			Thread.sleep(5000);

			// scrolldown to bottom
			scrollBottom();

			for (int m = 0; m < count; m++) {

				// validate the details of the first field
				try {
					consoleMessage(updateField1Detail_list.get(m));
					String updateFirstField1 = "//span[contains(text(),'" + updateField1Detail_list.get(m) + "')]";
					String updateFirstField1_actual = (driver.findElement(By.xpath(updateFirstField1)).getText())
							.trim();

					if (updateFirstField1_actual.equals(updateField1Detail_list.get(m))) {
						successMessage("The details of the first field is displayed successfully.");
					} else {
						verificationFailedMessage("The details of the first field is not displayed.");
					}
				} catch (Throwable t) {
					verificationFailedMessage("The details of the first field is not displayed.");
				}

				// validate the details of the second field
				try {
					consoleMessage(updateField2Detail_list.get(m));
					String updateSecondField1 = "//span[contains(text(),'" + updateField2Detail_list.get(m) + "')]";
					String updateSecondField1_actual = (driver.findElement(By.xpath(updateSecondField1)).getText())
							.trim();

					if (updateSecondField1_actual.equals(updateField2Detail_list.get(m))) {
						successMessage("The details of the second field is displayed successfully.");
					} else {
						verificationFailedMessage("The details of the second field is not displayed.");
					}
				} catch (Throwable t) {
					verificationFailedMessage("The details of the second field is not displayed.");
				}

				// validate the details of the first field of page one
				try {
					consoleMessage(pageUpdateField1Detail_list.get(m));
					String updateFirstField1 = "//span[contains(text(),'" + pageUpdateField1Detail_list.get(m) + "')]";
					String updateFirstField1_actual = (driver.findElement(By.xpath(updateFirstField1)).getText())
							.trim();

					if (updateFirstField1_actual.equals(pageUpdateField1Detail_list.get(m))) {
						successMessage("The details of the first field of page one is displayed successfully.");
					} else {
						verificationFailedMessage("The details of the first field of page one is not displayed.");
					}
				} catch (Throwable t) {
					verificationFailedMessage("The details of the first field of page one is not displayed.");
				}

				// validate the details of the second field of page one
				try {
					consoleMessage(pageUpdateField2Detail_list.get(m));
					String updateSecondField1 = "//span[contains(text(),'" + pageUpdateField2Detail_list.get(m) + "')]";
					String updateSecondField1_actual = (driver.findElement(By.xpath(updateSecondField1)).getText())
							.trim();

					if (updateSecondField1_actual.equals(pageUpdateField2Detail_list.get(m))) {
						successMessage("The details of the second field of page one is displayed successfully.");
					} else {
						verificationFailedMessage("The details of the second field of page one is not displayed.");
					}
				} catch (Throwable t) {
					verificationFailedMessage("The details of the second field of page one is not displayed.");
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

		// UPDATE THE FIELDS AND PAGES DETAIL FROM THE PROPERTY SUMMARY DASHBOARD
		title("UPDATE THE FIELDS AND PAGES DETAIL FROM THE PROPERTY SUMMARY DASHBOARD");

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

			// wait for the element
			Thread.sleep(5000);

			// scrolldown to bottom
			scrollBottom();

			consoleMessage("While Update, The details in fields will entered " + count + " times.");

			for (int n = 0; n < count; n++) {

				// wait for the element
				Thread.sleep(3000);

				// click on the record
				String ele1 = "//table[@id='propertyTabRecordsTable']//tbody//tr[" + (n + 1) + "]//td[1]";
				driver.findElement(By.xpath(ele1)).click();
				consoleMessage("click on the record i.e. " + (n + 1));

				// scrolldown to bottom
				scrollBottom();

				// click on the edit field button
				click("customform_portfoliodashboard_editfieldbtn_XPATH");

				// enter the details in the first field
				updateField1Detail2 = RandomStringUtils.randomAlphabetic(8);
				String firstField22 = "//input[@id='" + fieldName1 + "TEXT']";
				driver.findElement(By.xpath(firstField22)).clear();
				driver.findElement(By.xpath(firstField22)).sendKeys(updateField1Detail2);
				consoleMessage("Entered the details in the first field.");

				// collect the random details of the first field
				updateField1Detail2_list.add(updateField1Detail2);
				consoleMessage("New count of data of the field 1 : " + updateField1Detail2_list.size());

				// enter the details in the second field
				updateField2Detail2 = RandomStringUtils.randomNumeric(3);
				String secondField22 = "//input[@id='" + fieldName2 + "NUMBER']";
				driver.findElement(By.xpath(secondField22)).clear();
				driver.findElement(By.xpath(secondField22)).sendKeys(updateField2Detail2);
				consoleMessage("Entered the details in the second field.");

				// collect the random details of the second field
				updateField2Detail2_list.add(updateField2Detail2);
				consoleMessage("New count of data of the field 2 : " + updateField2Detail2_list.size());

				// click on the page one tab
				String page1 = "//span[text()='" + pageName1 + "']";
				driver.findElement(By.xpath(page1)).click();
				consoleMessage("Clicked on the page one tab.");

				// enter the details in the first field of page one
				pageUpdateField1Detail2 = RandomStringUtils.randomAlphabetic(8);
				String pageFirstField22 = "//input[@id='" + pageFieldName1 + "TEXT']";
				driver.findElement(By.xpath(pageFirstField22)).clear();
				driver.findElement(By.xpath(pageFirstField22)).sendKeys(pageUpdateField1Detail2);
				consoleMessage("Entered the details in the first field.");

				// collect the random details of the first field of page one
				pageUpdateField1Detail2_list.add(pageUpdateField1Detail2);
				consoleMessage("New count of data of the field 1 : " + pageUpdateField1Detail2_list.size());

				// enter the details in the second field of page one
				pageUpdateField2Detail2 = RandomStringUtils.randomNumeric(3);
				String pageSecondField22 = "//input[@id='" + pageFieldName2 + "NUMBER']";
				driver.findElement(By.xpath(pageSecondField22)).clear();
				driver.findElement(By.xpath(pageSecondField22)).sendKeys(pageUpdateField2Detail2);
				consoleMessage("Entered the details in the second field.");

				// collect the random details of the second field of page one
				pageUpdateField2Detail2_list.add(pageUpdateField2Detail2);
				consoleMessage("New count of data of the field 2 : " + pageUpdateField2Detail2_list.size());

				// click on the save button
				click("customform_portfoliodashboard_fields_savebtn_XPATH");

				// wait for the element
				Thread.sleep(5000);

				// click on the record list button
				click("customform_propertydashboard_recordlistbtn_XPATH");

				// wait for the element
				Thread.sleep(5000);

				// scrolldown to bottom
				scrollBottom();

				// validate the details of the first field
				try {
					String firstField112 = "//span[contains(text(),'" + updateField1Detail2 + "')]";
					String firstField112_actual = (driver.findElement(By.xpath(firstField112)).getText()).trim();

					if (firstField112_actual.equals(updateField1Detail2)) {
						successMessage("The details of the first field is displayed successfully.");
					} else {
						verificationFailedMessage("The details of the first field is not displayed.");
					}
				} catch (Throwable t) {
					verificationFailedMessage("The details of the first field is not displayed.");
				}

				// validate the details of the second field
				try {
					String secondField112 = "//span[contains(text(),'" + updateField2Detail2 + "')]";
					String secondField112_actual = (driver.findElement(By.xpath(secondField112)).getText()).trim();

					if (secondField112_actual.equals(updateField2Detail2)) {
						successMessage("The details of the second field is displayed successfully.");
					} else {
						verificationFailedMessage("The details of the second field is not displayed.");
					}
				} catch (Throwable t) {
					verificationFailedMessage("The details of the second field is not displayed.");
				}

				// validate the details of the first field of page one
				try {
					String firstField112 = "//span[contains(text(),'" + pageUpdateField1Detail2 + "')]";
					String firstField112_actual = (driver.findElement(By.xpath(firstField112)).getText()).trim();

					if (firstField112_actual.equals(pageUpdateField1Detail2)) {
						successMessage("The details of the first field of page one is displayed successfully.");
					} else {
						verificationFailedMessage("The details of the first field of page one is not displayed.");
					}
				} catch (Throwable t) {
					verificationFailedMessage("The details of the first field of page one is not displayed.");
				}

				// validate the details of the second field of page one
				try {
					String secondField112 = "//span[contains(text(),'" + pageUpdateField2Detail2 + "')]";
					String secondField112_actual = (driver.findElement(By.xpath(secondField112)).getText()).trim();

					if (secondField112_actual.equals(pageUpdateField2Detail2)) {
						successMessage("The details of the second field of page one is displayed successfully.");
					} else {
						verificationFailedMessage("The details of the second field of page one is not displayed.");
					}
				} catch (Throwable t) {
					verificationFailedMessage("The details of the second field of page one is not displayed.");
				}

			}

			consoleMessage(
					"While Update, End of for loop and The total number of count is " + updateField1Detail_list.size());
		} catch (Throwable t) {
			verificationFailed();
		}

		// click on the home icon from the top of the screen
		click("questionnaire_homeburgermenubtn_hide_CSS");

		// wait for the element
		explicitWait("propertylist_title_XPATH");

		// verify the property list
		switchVerification("propertylist_title_XPATH", "Property List", "The property list is not displayed.");

		// VALIDATE UPDATED DETAILS OF THE FIELDS AND PAGES DISPLAYED IN THE PORTFOLIO
		// SUMMARY DASHBOARD
		title("VALIDATE UPDATED DETAILS OF THE FIELDS AND PAGES DISPLAYED IN THE PORTFOLIO SUMMARY DASHBOARD");

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

			int count1 = field1Detail_list.size();
			for (int j = 0; j < count1; j++) {

				// validate the field 1
				try {
					String field11 = "//td[text()='[DND] AAAA Risk Test Prop 01']//following-sibling::td[@ng-click='viewPropertyTab(property)']//span[text()='"
							+ updateField1Detail2_list.get(j) + "']";
					String field11_actual = (driver.findElement(By.xpath(field11)).getText()).trim();

					if (field11_actual.equals(updateField1Detail2_list.get(j))) {
						successMessage("The respective field is displayed successfully.");
					} else {
						verificationFailedMessage("The repsective field is not displayed.");
					}
				} catch (Throwable t) {
					verificationFailedMessage("The repsective field is not displayed.");
				}

				// validate the field 2
				try {
					String field22 = "//td[text()='[DND] AAAA Risk Test Prop 01']//following-sibling::td[@ng-click='viewPropertyTab(property)']//span[text()='"
							+ updateField2Detail2_list.get(j) + "']";
					String field22_actual = (driver.findElement(By.xpath(field22)).getText()).trim();

					if (field22_actual.equals(updateField2Detail2_list.get(j))) {
						successMessage("The respective field is displayed successfully.");
					} else {
						verificationFailedMessage("The repsective field is not displayed.");
					}
				} catch (Throwable t) {
					verificationFailedMessage("The repsective field is not displayed.");
				}

				// validate the field 1 of page one
				try {
					String field11 = "//td[text()='[DND] AAAA Risk Test Prop 01']//following-sibling::td[@ng-click='viewPropertyTab(property)']//span[text()='"
							+ pageUpdateField1Detail2_list.get(j) + "']";
					String field11_actual = (driver.findElement(By.xpath(field11)).getText()).trim();

					if (field11_actual.equals(pageUpdateField1Detail2_list.get(j))) {
						successMessage("The respective field of page one is displayed successfully.");
					} else {
						verificationFailedMessage("The repsective field of page one is not displayed.");
					}
				} catch (Throwable t) {
					verificationFailedMessage("The repsective field of page one is not displayed.");
				}

				// validate the field 2 of page one
				try {
					String field22 = "//td[text()='[DND] AAAA Risk Test Prop 01']//following-sibling::td[@ng-click='viewPropertyTab(property)']//span[text()='"
							+ pageUpdateField2Detail2_list.get(j) + "']";
					String field22_actual = (driver.findElement(By.xpath(field22)).getText()).trim();

					if (field22_actual.equals(pageUpdateField2Detail2_list.get(j))) {
						successMessage("The respective field of page one is displayed successfully.");
					} else {
						verificationFailedMessage("The repsective field of page one is not displayed.");
					}
				} catch (Throwable t) {
					verificationFailedMessage("The repsective field of page one is not displayed.");
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

		// DELETE THE UPDATED CUSTOMER FORM
		title("DELETE THE UPDATED CUSTOMER FORM");

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
			String deleteIcon = "//td[text()='" + data.get("name")
					+ "']//following-sibling::td[@class='pointer']//i[@data-target='#deleteCustomFormModal']";
			driver.findElement(By.xpath(deleteIcon)).click();
			consoleMessage("Clicked on the delete button of the updated custom form.");

			// wait for the element
			Thread.sleep(5000);

			// click on the delete button
			click("customform_deletebtn_XPATH");

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

		// wait for the element
		explicitWait("propertylist_title_XPATH");

		// verify the property list
		switchVerification("propertylist_title_XPATH", "Property List", "The property list is not displayed.");

	}
}