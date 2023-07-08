package testcases.E2Etestcasesuite.customformmodule;

import java.io.File;
import java.io.IOException;
import java.time.LocalDate;
import java.util.Hashtable;

import org.apache.commons.lang3.RandomStringUtils;
import org.openqa.selenium.By;
import org.testng.annotations.Test;

import base.TestBase;
import utilities.ExcelReader;
import utilities.TestUtil;

public class RR6539CustomForm2Test extends TestBase {

	@Test(dataProviderClass = TestUtil.class, dataProvider = "dp")
	public void rR6539CustomForm2Test(Hashtable<String, String> data) throws IOException, InterruptedException {

		execution(data, "rR6539CustomForm2Test");

		// PERFORM EXPORT AND IMPORT FUNCTIONALITY OF CUSTOM FORMS WITH CHECKBOX TYPE AT
		// PORTFOLIO SUMMARY DASHBOARD AND PROPERTY SUMMARY DASHBOARD - MULTIPLE TYPE

		title("PERFORM EXPORT AND IMPORT FUNCTIONALITY OF CUSTOM FORMS WITH CHECKBOX TYPE AT PORTFOLIO SUMMARY DASHBOARD AND PROPERTY SUMMARY DASHBOARD - MULTIPLE TYPE");

		// refresh the page
		driver.navigate().refresh();
		Thread.sleep(5000);
		driver.navigate().refresh();

		String name = RandomStringUtils.randomAlphabetic(8); // Name of the custom form
		String fieldName1 = RandomStringUtils.randomAlphabetic(8); // Normal Field 1
		String fieldName2 = RandomStringUtils.randomAlphabetic(8); // Normal Field 2
		String fieldDetail2 = RandomStringUtils.randomAlphabetic(8); // Normal Field Detail 2
		String pageName1 = RandomStringUtils.randomAlphabetic(8); // Page Name 1
		String pageFieldName1 = RandomStringUtils.randomAlphabetic(8); // Page Name 1 - Field 1
		String pageFieldName2 = RandomStringUtils.randomAlphabetic(8); // Page Name 1 - Field 2

		// variables of the normal field two for the 3 properties
		String property1_Field2 = RandomStringUtils.randomAlphabetic(3);
		String property2_Field2 = RandomStringUtils.randomAlphabetic(3);
		String property3_Field2 = RandomStringUtils.randomAlphabetic(3);
		String property4_Field2 = RandomStringUtils.randomAlphabetic(8);

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

			// ADD FIELDS IN THE PAGES
			title("ADD FIELDS IN THE PAGES");

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
			consoleMessage("click on the first page name tab");

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
			String page111 = "//span[contains(text(),'" + pageName1 + "')]";
			driver.findElement(By.xpath(page111)).click();
			consoleMessage("Clicked on the first page name tab.");

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

		// ADD THE DETAILS IN THE FIELDS AND PAGES FROM THE PROPERTY SUMMARY DASHBOARD
		title("ADD THE DETAILS IN THE FIELDS AND PAGES FROM THE PROPERTY SUMMARY DASHBOARD");

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

			// click on the add button
			click("customform_portfoliodashboard_addbtn_XPATH");

			// wait for the element
			Thread.sleep(5000);

			// scroll to bottom
			scrollBottom();

			// click on the checkbox of the first field
			String firstField = "//input[@id='" + fieldName1 + "CHECKBOX']";
			driver.findElement(By.xpath(firstField)).click();
			consoleMessage("Clicked on the checkbox of the first field.");

			// enter the details in the second field
			String secondField = "//input[@id='" + fieldName2 + "TEXT']";
			driver.findElement(By.xpath(secondField)).sendKeys(fieldDetail2);
			consoleMessage("Entered the details in the second field.");

			// wait for the element
			Thread.sleep(5000);

			// click on the first page name tab
			String pageTab1 = "//span[text()='" + pageName1 + "']";
			driver.findElement(By.xpath(pageTab1)).click();
			consoleMessage("Clicked on the first page name tab.");

			// ADD THE DETAILS IN THE FIELDS OF THE FIRST PAGE TAB
			title("ADD THE DETAILS IN THE FIELDS OF THE FIRST PAGE TAB");

			// enter the details in the second field
			String secondPageField = "//input[@id='" + pageFieldName2 + "CHECKBOX']";
			driver.findElement(By.xpath(secondPageField)).click();
			consoleMessage("Entered the details in the second field.");

			// click on the save button
			click("customform_portfoliodashboard_fields_savebtn_XPATH");

			// scroll to bottom
			scrollBottom();

			// wait for the element
			Thread.sleep(5000);

			// validate the details of the first field
			try {
				String firstField1 = "//table[@id='propertyTabRecordsTable']//tbody//tr[1]//td[1]//span[contains(text(),'Yes')]";
				String firstField1_actual = (driver.findElement(By.xpath(firstField1)).getText()).trim();

				if (firstField1_actual.equals("Yes")) {
					successMessage("The details of the first field is displayed successfully.");
				} else {
					verificationFailedMessage("The details of the first field is not displayed.");
				}
			} catch (Throwable t) {
				verificationFailedMessage("The details of the first field is not displayed.");
			}

			// validate the details of the second field
			try {
				String secondField1 = "//span[contains(text(),'" + fieldDetail2 + "')]";
				String secondField1_actual = (driver.findElement(By.xpath(secondField1)).getText()).trim();

				if (secondField1_actual.equals(fieldDetail2)) {
					successMessage("The details of the second field is displayed successfully.");
				} else {
					verificationFailedMessage("The details of the second field is not displayed.");
				}
			} catch (Throwable t) {
				verificationFailedMessage("The details of the second field is not displayed.");
			}

			// validate the details of the first field of page one
			try {
				String thirdField1 = "//table[@id='propertyTabRecordsTable']//tbody//tr[1]//td[3]//span[contains(text(),'No')]";
				String thirdField1_actual = (driver.findElement(By.xpath(thirdField1)).getText()).trim();

				if (thirdField1_actual.equals("No")) {
					successMessage("The details of the first field of page one is displayed successfully.");
				} else {
					verificationFailedMessage("The details of the first field of page one is not displayed.");
				}
			} catch (Throwable t) {
				verificationFailedMessage("The details of the first field of page one is not displayed.");
			}

			// validate the details of the second field of page one
			try {
				String fourthField2 = "//table[@id='propertyTabRecordsTable']//tbody//tr[1]//td[4]//span[contains(text(),'Yes')]";
				String fourthField2_actual = (driver.findElement(By.xpath(fourthField2)).getText()).trim();

				if (fourthField2_actual.equals("Yes")) {
					successMessage("The details of the second field of page one is displayed successfully.");
				} else {
					verificationFailedMessage("The details of the second field of page one is not displayed.");
				}
			} catch (Throwable t) {
				verificationFailedMessage("The details of the second field of page one is not displayed.");
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

		// VALIDATE ADDED DETAILS OF THE FIELDS DISPLAYED IN THE PORTFOLIO SUMMARY
		// DASHBOARD
		title("VALIDATE ADDED DETAILS OF THE FIELDS DISPLAYED IN THE PORTFOLIO SUMMARY DASHBOARD");

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
				String field11 = "//table[@class='table table-striped']//tbody//tr[1]//td[text()='[DND] AAAA Risk Test Prop 01']//following-sibling::td[@ng-click='viewPropertyTab(property)'][1]//span[text()='Yes']";
				String field11_actual = (driver.findElement(By.xpath(field11)).getText()).trim();

				if (field11_actual.equals("Yes")) {
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
						+ fieldDetail2 + "']";
				String field22_actual = (driver.findElement(By.xpath(field22)).getText()).trim();

				if (field22_actual.equals(fieldDetail2)) {
					successMessage("The respective field is displayed successfully.");
				} else {
					verificationFailedMessage("The repsective field is not displayed.");
				}
			} catch (Throwable t) {
				verificationFailedMessage("The repsective field is not displayed.");
			}

			// validate the field 1 of page one
			try {
				String field11 = "//table[@class='table table-striped']//tbody//tr[1]//td[text()='[DND] AAAA Risk Test Prop 01']//following-sibling::td[@ng-click='viewPropertyTab(property)'][3]//span[text()='No']";
				String field11_actual = (driver.findElement(By.xpath(field11)).getText()).trim();

				if (field11_actual.equals("No")) {
					successMessage("The respective field of page one is displayed successfully.");
				} else {
					verificationFailedMessage("The repsective field of page one is not displayed.");
				}
			} catch (Throwable t) {
				verificationFailedMessage("The repsective field of page one is not displayed.");
			}

			// validate the field 2 of page one
			try {
				String field22 = "//table[@class='table table-striped']//tbody//tr[1]//td[text()='[DND] AAAA Risk Test Prop 01']//following-sibling::td[@ng-click='viewPropertyTab(property)'][4]//span[text()='Yes']";
				String field22_actual = (driver.findElement(By.xpath(field22)).getText()).trim();

				if (field22_actual.equals("Yes")) {
					successMessage("The respective field of page one is displayed successfully.");
				} else {
					verificationFailedMessage("The repsective field of page one is not displayed.");
				}
			} catch (Throwable t) {
				verificationFailedMessage("The repsective field of page one is not displayed.");
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

		// PERFORM THE EXPORT AND IMPORT FUNCTIONALITY OF THE CUSTOM FORMS - MULTI TYPE
		// FROM THE PORTFOLIO SUMMARY DASHBOARD
		title("PERFORM THE EXPORT AND IMPORT FUNCTIONALITY OF THE CUSTOM FORMS - MULTI TYPE FROM THE PORTFOLIO SUMMARY DASHBOARD");

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

			// click on the action icon
			click("customform_portfoliodashboard_actionicon_XPATH");

			// click on the export option
			click("customform_portfoliodashboard_actionicon_exportoption_XPATH");

			// wait for the element
			Thread.sleep(15000);

			// fetch the record from the download file
			File downloaded = getLastModified("C:\\Users\\Jinesh\\Downloads");
			String path_string = downloaded.toString();
			System.out.println(path_string);

			ExcelReader file = new ExcelReader(path_string);

			// verify the detail of the field 1
			try {
				String record1 = file.getCellData("Sheet0", fieldName1, 2);

				if (record1.equals("Yes")) {
					successMessage("The details of the field 1 is displayed correctly.");
				} else {
					verificationFailedMessage("The details of the field 1 is not displayed correctly.");
				}
			} catch (Throwable t) {
				verificationFailedMessage("The details of the field 1 is not displayed correctly.");
			}

			// verify the detail of the field 2
			try {
				String record1 = file.getCellData("Sheet0", fieldName2, 2);

				if (record1.equals(fieldDetail2)) {
					successMessage("The details of the field 2 is displayed correctly.");
				} else {
					verificationFailedMessage("The details of the field 2 is not displayed correctly.");
				}
			} catch (Throwable t) {
				verificationFailedMessage("The details of the field 2 is not displayed correctly.");
			}

			// verify the detail of the field 1 of page 1
			try {
				String record1 = file.getCellData("Sheet0", pageFieldName1, 2);

				if (record1.equals("Yes")) {
					successMessage("The details of the field 1 of page 1 is displayed correctly.");
				} else {
					verificationFailedMessage("The details of the field 1 of page 1 is not displayed correctly.");
				}
			} catch (Throwable t) {
				verificationFailedMessage("The details of the field 1 of page 1 is not displayed correctly.");
			}

			// verify the detail of the field 2 of page 1
			try {
				String record1 = file.getCellData("Sheet0", pageFieldName2, 2);

				if (record1.equals(fieldDetail2)) {
					successMessage("The details of the field 2 of page 1 is displayed correctly.");
				} else {
					verificationFailedMessage("The details of the field 2 of page 1 is not displayed correctly.");
				}
			} catch (Throwable t) {
				verificationFailedMessage("The details of the field 2 of page 1 is not displayed correctly.");
			}

			// add the details of the first normal fields
			file.setCellData("Sheet0", fieldName1, 2, "No");

			// add the details of the second normal fields
			file.setCellData("Sheet0", fieldName2, 2, property1_Field2);

			// add the details of the first fields of the page one
			file.setCellData("Sheet0", pageFieldName1, 2, "Yes");

			// wait for the element
			Thread.sleep(5000);

			// click on the action icon
			click("customform_portfoliodashboard_actionicon_XPATH");

			// wait for the element
			Thread.sleep(5000);

			// click on the import option
			click("customform_portfoliodashboard_actionicon_importoption_XPATH");

			// import the file
			uploadFile(path_string);

			// wait for the element
			Thread.sleep(10000);

			// VALIDATE IMPORTED DETAILS IN THE ALL THE FIELDS FOR ALL THE PROPERTIES
			title("VALIDATE IMPORTED DETAILS IN THE ALL THE FIELDS FOR ALL THE PROPERTIES");

			// validate the field 1
			try {
				String field11 = "//table[@class='table table-striped']//tbody//tr[1]//td[text()='[DND] AAAA Risk Test Prop 01']//following-sibling::td[@ng-click='viewPropertyTab(property)'][1]//span[text()='No']";
				String field11_actual = (driver.findElement(By.xpath(field11)).getText()).trim();

				if (field11_actual.equals("Yes")) {
					successMessage("The field 1 is displayed successfully.");
				} else {
					verificationFailedMessage("The field 1 is not displayed.");
				}
			} catch (Throwable t) {
				verificationFailedMessage("The field 1 is not displayed.");
			}

			// validate the field 2
			try {
				String field22 = "//td[text()='[DND] AAAA Risk Test Prop 01']//following-sibling::td[@ng-click='viewPropertyTab(property)']//span[text()='"
						+ property1_Field2 + "']";
				String field22_actual = (driver.findElement(By.xpath(field22)).getText()).trim();

				if (field22_actual.equals(property1_Field2)) {
					successMessage("The field 2 is displayed successfully.");
				} else {
					verificationFailedMessage("The field 2 is not displayed.");
				}
			} catch (Throwable t) {
				verificationFailedMessage("The field 2 is not displayed.");
			}

			// validate the field 1 of page one
			try {
				String field11 = "//table[@class='table table-striped']//tbody//tr[1]//td[text()='[DND] AAAA Risk Test Prop 01']//following-sibling::td[@ng-click='viewPropertyTab(property)'][3]//span[text()='Yes']";
				String field11_actual = (driver.findElement(By.xpath(field11)).getText()).trim();

				if (field11_actual.equals("Yes")) {
					successMessage("The field 1 of page one is displayed successfully.");
				} else {
					verificationFailedMessage("The field 1 of page one is not displayed.");
				}
			} catch (Throwable t) {
				verificationFailedMessage("The field 1 of page one is not displayed.");
			}

			// validate the field 2 of page one
			try {
				String field22 = "//table[@class='table table-striped']//tbody//tr[1]//td[text()='[DND] AAAA Risk Test Prop 01']//following-sibling::td[@ng-click='viewPropertyTab(property)'][4]//span[text()='Yes']";
				String field22_actual = (driver.findElement(By.xpath(field22)).getText()).trim();

				if (field22_actual.equals("Yes")) {
					successMessage("The field 2 of page one is displayed successfully.");
				} else {
					verificationFailedMessage("The field 2 of page one is not displayed.");
				}
			} catch (Throwable t) {
				verificationFailedMessage("The field 2 of page one is not displayed.");
			}

			// VALIDATE THE FIELDS DETAIL AT PROPERTY LEVEL - PROPERTY ONE
			title("VALIDATE THE FIELDS DETAIL AT PROPERTY LEVEL - PROPERTY ONE");

			// click on the property one
			click("customform_portfoliodashboard_propertyname_XPATH");

			// validate the details of the first field
			try {
				String p1Field1 = "//label[contains(text(),'" + fieldName1 + ":"
						+ "')]//following-sibling::div//span[contains(text(),'" + "No" + "')]";
				String p1Field1_actual = (driver.findElement(By.xpath(p1Field1)).getText()).trim();

				if (p1Field1_actual.equals("No")) {
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
			consoleMessage("Clicked on the first page name tab.");

			// validate the details of the first field of the first page
			try {
				String p1Page1Field1 = "//label[contains(text(),'" + pageFieldName1 + ":"
						+ "')]//following-sibling::div//span[contains(text(),'" + "Yes" + "')]";
				String p1Page1Field1_actual = (driver.findElement(By.xpath(p1Page1Field1)).getText()).trim();

				if (p1Page1Field1_actual.equals("Yes")) {
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
						+ "')]//following-sibling::div//span[contains(text(),'" + "Yes" + "')]";
				String p1Page1Field2_actual = (driver.findElement(By.xpath(p1Page1Field2)).getText()).trim();

				if (p1Page1Field2_actual.equals("Yes")) {
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

		// PERFORM THE EXPORT AND IMPORT FUNCTIONALITY OF THE CUSTOM FORMS - MULTI TYPE
		// FROM THE PORTFOLIO SUMMARY DASHBOARD - ON PROPERTY LEVEL
		title("PERFORM THE EXPORT AND IMPORT FUNCTIONALITY OF THE CUSTOM FORMS - MULTI TYPE FROM THE PORTFOLIO SUMMARY DASHBOARD - ON PROPERTY LEVEL");

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

			// click on the action icon
			click("customform_portfoliodashboard_actionicon_XPATH");

			// click on the export option
			click("customform_portfoliodashboard_actionicon_exportoption_XPATH");

			// type the todays date on the extract date field
			LocalDate today = LocalDate.now();
			String today_string = today.toString();
			type("customform_propertydashboard_extractdatetxt_XPATH", today_string);

			// click on the export excel button
			click("customform_propertydashboard_exportexcelbtn_XPATH");

			// wait for the element
			Thread.sleep(5000);

			// fetch the record from the download file

			// wait for the element
			Thread.sleep(15000);

			File downloaded = getLastModified("C:\\Users\\Jinesh\\Downloads");
			String path_string = downloaded.toString();
			System.out.println(path_string);

			ExcelReader file = new ExcelReader(path_string);

			// verify the detail of the field 1
			try {
				String record1 = file.getCellData("Sheet0", fieldName1, 2);

				if (record1.equals("No")) {
					successMessage("The details of the field 1 is displayed correctly.");
				} else {
					verificationFailedMessage("The details of the field 1 is not displayed correctly.");
				}
			} catch (Throwable t) {
				verificationFailedMessage("The details of the field 1 is not displayed correctly.");
			}

			// verify the detail of the field 2
			try {
				String record1 = file.getCellData("Sheet0", fieldName2, 2);

				if (record1.equals(property1_Field2)) {
					successMessage("The details of the field 2 is displayed correctly.");
				} else {
					verificationFailedMessage("The details of the field 2 is not displayed correctly.");
				}
			} catch (Throwable t) {
				verificationFailedMessage("The details of the field 2 is not displayed correctly.");
			}

			// verify the detail of the field 1 of page 1
			try {
				String record1 = file.getCellData("Sheet0", pageFieldName1, 2);

				if (record1.equals("Yes")) {
					successMessage("The details of the field 1 of page 1 is displayed correctly.");
				} else {
					verificationFailedMessage("The details of the field 1 of page 1 is not displayed correctly.");
				}
			} catch (Throwable t) {
				verificationFailedMessage("The details of the field 1 of page 1 is not displayed correctly.");
			}

			// verify the detail of the field 2 of page 1
			try {
				String record1 = file.getCellData("Sheet0", pageFieldName2, 2);

				if (record1.equals("Yes")) {
					successMessage("The details of the field 2 of page 1 is displayed correctly.");
				} else {
					verificationFailedMessage("The details of the field 2 of page 1 is not displayed correctly.");
				}
			} catch (Throwable t) {
				verificationFailedMessage("The details of the field 2 of page 1 is not displayed correctly.");
			}

			// add the details of the first normal fields
			file.setCellData("Sheet0", fieldName1, 2, "Yes");

			// add the details of the second normal fields
			file.setCellData("Sheet0", fieldName2, 2, property2_Field2);

			// add the details of the first fields of the page one
			file.setCellData("Sheet0", pageFieldName1, 2, "Yes");

			// add the details of the second fields of the page one
			file.setCellData("Sheet0", pageFieldName2, 2, "Yes");

			// wait for the element
			Thread.sleep(5000);

			// click on the action icon
			click("customform_portfoliodashboard_actionicon_XPATH");

			// wait for the element
			Thread.sleep(5000);

			// click on the import option
			click("customform_portfoliodashboard_actionicon_importoption_XPATH");

			// import the file
			uploadFile(path_string);

			// wait for the element
			Thread.sleep(10000);

			// type the todays date on the extract date field
			today_string = today.toString();
			type("customform_propertydashboard_extractdatetxt_XPATH", today_string);

			// click on the import excel button
			click("customform_propertydashboard_importbtn_XPATH");

			// VALIDATE IMPORTED DETAILS IN THE ALL THE FIELDS FOR PROPERTY ONE
			title("VALIDATE IMPORTED DETAILS IN THE ALL THE FIELDS FOR PROPERTY ONE");

			// validate the details of the first field
			try {
				String p1Field1 = "//label[contains(text(),'" + fieldName1 + ":"
						+ "')]//following-sibling::div//span[contains(text(),'" + "Yes" + "')]";
				String p1Field1_actual = (driver.findElement(By.xpath(p1Field1)).getText()).trim();

				if (p1Field1_actual.equals("Yes")) {
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
						+ "')]//following-sibling::div//span[contains(text(),'" + property2_Field2 + "')]";
				String p1Field2_actual = (driver.findElement(By.xpath(p1Field2)).getText()).trim();

				if (p1Field2_actual.equals(property2_Field2)) {
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

			// validate the details of the first field of the first page
			try {
				String p1Page1Field1 = "//label[contains(text(),'" + pageFieldName1 + ":"
						+ "')]//following-sibling::div//span[contains(text(),'" + "Yes" + "')]";
				String p1Page1Field1_actual = (driver.findElement(By.xpath(p1Page1Field1)).getText()).trim();

				if (p1Page1Field1_actual.equals("Yes")) {
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
						+ "')]//following-sibling::div//span[contains(text(),'" + "Yes" + "')]";
				String p1Page1Field2_actual = (driver.findElement(By.xpath(p1Page1Field2)).getText()).trim();

				if (p1Page1Field2_actual.equals("Yes")) {
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

		// PERFORM THE EXPORT AND IMPORT FUNCTIONALITY OF THE CUSTOM FORMS - MULTI TYPE
		// FROM THE PROPERTY SUMMARY DASHBOARD

		title("PERFORM THE EXPORT AND IMPORT FUNCTIONALITY OF THE CUSTOM FORMS - MULTI TYPE FROM THE PROPERTY SUMMARY DASHBOARD");

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

			// click on the action icon
			click("customform_portfoliodashboard_actionicon_XPATH");

			// click on the export option
			click("customform_portfoliodashboard_actionicon_exportoption_XPATH");

			// type the todays date on the extract date field
			LocalDate today = LocalDate.now();
			String today_string = today.toString();
			type("customform_propertydashboard_extractdatetxt_XPATH", today_string);

			// click on the export excel button
			click("customform_propertydashboard_exportexcelbtn_XPATH");

			// wait for the element
			Thread.sleep(5000);

			// fetch the record from the download file

			// wait for the element
			Thread.sleep(15000);

			File downloaded = getLastModified("C:\\Users\\Jinesh\\Downloads");
			String path_string = downloaded.toString();
			System.out.println(path_string);

			ExcelReader file = new ExcelReader(path_string);

			// verify the detail of the field 1
			try {
				String record1 = file.getCellData("Sheet0", fieldName1, 2);

				if (record1.equals("Yes")) {
					successMessage("The details of the field 1 is displayed correctly.");
				} else {
					verificationFailedMessage("The details of the field 1 is not displayed correctly.");
				}
			} catch (Throwable t) {
				verificationFailedMessage("The details of the field 1 is not displayed correctly.");
			}

			// verify the detail of the field 2
			try {
				String record1 = file.getCellData("Sheet0", fieldName2, 2);

				if (record1.equals(property2_Field2)) {
					successMessage("The details of the field 2 is displayed correctly.");
				} else {
					verificationFailedMessage("The details of the field 2 is not displayed correctly.");
				}
			} catch (Throwable t) {
				verificationFailedMessage("The details of the field 2 is not displayed correctly.");
			}

			// verify the detail of the field 1 of page 1
			try {
				String record1 = file.getCellData("Sheet0", pageFieldName1, 2);

				if (record1.equals("Yes")) {
					successMessage("The details of the field 1 of page 1 is displayed correctly.");
				} else {
					verificationFailedMessage("The details of the field 1 of page 1 is not displayed correctly.");
				}
			} catch (Throwable t) {
				verificationFailedMessage("The details of the field 1 of page 1 is not displayed correctly.");
			}

			// verify the detail of the field 2 of page 1
			try {
				String record1 = file.getCellData("Sheet0", pageFieldName2, 2);

				if (record1.equals("Yes")) {
					successMessage("The details of the field 2 of page 1 is displayed correctly.");
				} else {
					verificationFailedMessage("The details of the field 2 of page 1 is not displayed correctly.");
				}
			} catch (Throwable t) {
				verificationFailedMessage("The details of the field 2 of page 1 is not displayed correctly.");
			}

			// add the details of the first normal fields
			file.setCellData("Sheet0", fieldName1, 2, "No");

			// add the details of the second normal fields
			file.setCellData("Sheet0", fieldName2, 2, property3_Field2);

			// add the details of the first fields of the page one
			file.setCellData("Sheet0", pageFieldName1, 2, "No");

			// add the details of the second fields of the page one
			file.setCellData("Sheet0", pageFieldName2, 2, "No");

			// wait for the element
			Thread.sleep(5000);

			// click on the action icon
			click("customform_portfoliodashboard_actionicon_XPATH");

			// wait for the element
			Thread.sleep(5000);

			// click on the import option
			click("customform_portfoliodashboard_actionicon_importoption_XPATH");

			// import the file
			uploadFile(path_string);

			// wait for the element
			Thread.sleep(10000);

			// type the todays date on the extract date field
			today_string = today.toString();
			type("customform_propertydashboard_extractdatetxt_XPATH", today_string);

			// click on the import excel button
			click("customform_propertydashboard_importbtn_XPATH");

			// VALIDATE IMPORTED DETAILS IN THE ALL THE FIELDS
			title("VALIDATE IMPORTED DETAILS IN THE ALL THE FIELDS");

			// validate the details of the first field
			try {
				String firstField1 = "//table[@id='propertyTabRecordsTable']//tbody//tr[1]//td[1]//span[contains(text(),'No')]";
				String firstField1_actual = (driver.findElement(By.xpath(firstField1)).getText()).trim();

				if (firstField1_actual.equals("No")) {
					successMessage("The details of the first field is displayed successfully.");
				} else {
					verificationFailedMessage("The details of the first field is not displayed.");
				}
			} catch (Throwable t) {
				verificationFailedMessage("The details of the first field is not displayed.");
			}

			// validate the details of the second field
			try {
				String secondField1 = "//span[contains(text(),'" + property3_Field2 + "')]";
				String secondField1_actual = (driver.findElement(By.xpath(secondField1)).getText()).trim();

				if (secondField1_actual.equals(property3_Field2)) {
					successMessage("The details of the second field is displayed successfully.");
				} else {
					verificationFailedMessage("The details of the second field is not displayed.");
				}
			} catch (Throwable t) {
				verificationFailedMessage("The details of the second field is not displayed.");
			}

			// validate the details of the first field of page one
			try {
				String thirdField1 = "//table[@id='propertyTabRecordsTable']//tbody//tr[1]//td[3]//span[contains(text(),'No')]";
				String thirdField1_actual = (driver.findElement(By.xpath(thirdField1)).getText()).trim();

				if (thirdField1_actual.equals("No")) {
					successMessage("The details of the first field of page one is displayed successfully.");
				} else {
					verificationFailedMessage("The details of the first field of page one is not displayed.");
				}
			} catch (Throwable t) {
				verificationFailedMessage("The details of the first field of page one is not displayed.");
			}

			// validate the details of the second field of page one
			try {
				String fourthField2 = "//table[@id='propertyTabRecordsTable']//tbody//tr[1]//td[4]//span[contains(text(),'No')]";
				String fourthField2_actual = (driver.findElement(By.xpath(fourthField2)).getText()).trim();

				if (fourthField2_actual.equals("No")) {
					successMessage("The details of the second field of page one is displayed successfully.");
				} else {
					verificationFailedMessage("The details of the second field of page one is not displayed.");
				}
			} catch (Throwable t) {
				verificationFailedMessage("The details of the second field of page one is not displayed.");
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

		// PERFORM THE EXPORT AND IMPORT FUNCTIONALITY OF THE CUSTOM FORMS - MULTI TYPE
		// FROM THE PROPERTY SUMMARY DASHBOARD - DETAIL SCREEN
		title("PERFORM THE EXPORT AND IMPORT FUNCTIONALITY OF THE CUSTOM FORMS - MULTI TYPE FROM THE PROPERTY SUMMARY DASHBOARD - DETAIL SCREEN");

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

			// click on the record detail
			String firstField = "//table[@id='propertyTabRecordsTable']//tbody//tr[1]//td[1]//span[contains(text(),'Yes')]";
			driver.findElement(By.xpath(firstField)).click();
			consoleMessage("Clicked on the record detail");

			// wait for the element
			Thread.sleep(5000);

			// click on the action icon
			click("customform_portfoliodashboard_actionicon_XPATH");

			// click on the export option
			click("customform_portfoliodashboard_actionicon_exportoption_XPATH");

			// type the todays date on the extract date field
			LocalDate today = LocalDate.now();
			String today_string = today.toString();
			type("customform_propertydashboard_extractdatetxt_XPATH", today_string);

			// click on the export excel button
			click("customform_propertydashboard_exportexcelbtn_XPATH");

			// wait for the element
			Thread.sleep(5000);

			// fetch the record from the download file

			// wait for the element
			Thread.sleep(15000);

			File downloaded = getLastModified("C:\\Users\\Jinesh\\Downloads");
			String path_string = downloaded.toString();
			System.out.println(path_string);

			ExcelReader file = new ExcelReader(path_string);

			// verify the detail of the field 1
			try {
				String record1 = file.getCellData("Sheet0", fieldName1, 2);

				if (record1.equals("No")) {
					successMessage("The details of the field 1 is displayed correctly.");
				} else {
					verificationFailedMessage("The details of the field 1 is not displayed correctly.");
				}
			} catch (Throwable t) {
				verificationFailedMessage("The details of the field 1 is not displayed correctly.");
			}

			// verify the detail of the field 2
			try {
				String record1 = file.getCellData("Sheet0", fieldName2, 2);

				if (record1.equals(property3_Field2)) {
					successMessage("The details of the field 2 is displayed correctly.");
				} else {
					verificationFailedMessage("The details of the field 2 is not displayed correctly.");
				}
			} catch (Throwable t) {
				verificationFailedMessage("The details of the field 2 is not displayed correctly.");
			}

			// verify the detail of the field 1 of page 1
			try {
				String record1 = file.getCellData("Sheet0", pageFieldName1, 2);

				if (record1.equals("No")) {
					successMessage("The details of the field 1 of page 1 is displayed correctly.");
				} else {
					verificationFailedMessage("The details of the field 1 of page 1 is not displayed correctly.");
				}
			} catch (Throwable t) {
				verificationFailedMessage("The details of the field 1 of page 1 is not displayed correctly.");
			}

			// verify the detail of the field 2 of page 1
			try {
				String record1 = file.getCellData("Sheet0", pageFieldName2, 2);

				if (record1.equals("No")) {
					successMessage("The details of the field 2 of page 1 is displayed correctly.");
				} else {
					verificationFailedMessage("The details of the field 2 of page 1 is not displayed correctly.");
				}
			} catch (Throwable t) {
				verificationFailedMessage("The details of the field 2 of page 1 is not displayed correctly.");
			}

			// add the details of the first normal fields
			file.setCellData("Sheet0", fieldName1, 2, "Yes");

			// add the details of the second normal fields
			file.setCellData("Sheet0", fieldName2, 2, property4_Field2);

			// add the details of the first fields of the page one
			file.setCellData("Sheet0", pageFieldName1, 2, "Yes");

			// add the details of the second fields of the page one
			file.setCellData("Sheet0", pageFieldName2, 2, "Yes");

			// wait for the element
			Thread.sleep(5000);

			// click on the action icon
			click("customform_portfoliodashboard_actionicon_XPATH");

			// wait for the element
			Thread.sleep(5000);

			// click on the import option
			click("customform_portfoliodashboard_actionicon_importoption_XPATH");

			// import the file
			uploadFile(path_string);

			// wait for the element
			Thread.sleep(10000);

			// type the todays date on the extract date field
			today_string = today.toString();
			type("customform_propertydashboard_extractdatetxt_XPATH", today_string);

			// click on the import excel button
			click("customform_propertydashboard_importbtn_XPATH");

			// VALIDATE IMPORTED DETAILS IN THE ALL THE FIELDS
			title("VALIDATE IMPORTED DETAILS IN THE ALL THE FIELDS");

			// validate the details of the first field
			try {
				String firstField1 = "//table[@id='propertyTabRecordsTable']//tbody//tr[1]//td[1]//span[contains(text(),'Yes')]";
				String firstField1_actual = (driver.findElement(By.xpath(firstField1)).getText()).trim();

				if (firstField1_actual.equals("Yes")) {
					successMessage("The details of the first field is displayed successfully.");
				} else {
					verificationFailedMessage("The details of the first field is not displayed.");
				}
			} catch (Throwable t) {
				verificationFailedMessage("The details of the first field is not displayed.");
			}

			// validate the details of the second field
			try {
				String secondField1 = "//span[contains(text(),'" + property4_Field2 + "')]";
				String secondField1_actual = (driver.findElement(By.xpath(secondField1)).getText()).trim();

				if (secondField1_actual.equals(property4_Field2)) {
					successMessage("The details of the second field is displayed successfully.");
				} else {
					verificationFailedMessage("The details of the second field is not displayed.");
				}
			} catch (Throwable t) {
				verificationFailedMessage("The details of the second field is not displayed.");
			}

			// validate the details of the first field of page one
			try {
				String thirdField1 = "//table[@id='propertyTabRecordsTable']//tbody//tr[1]//td[3]//span[contains(text(),'Yes')]";
				String thirdField1_actual = (driver.findElement(By.xpath(thirdField1)).getText()).trim();

				if (thirdField1_actual.equals("Yes")) {
					successMessage("The details of the first field of page one is displayed successfully.");
				} else {
					verificationFailedMessage("The details of the first field of page one is not displayed.");
				}
			} catch (Throwable t) {
				verificationFailedMessage("The details of the first field of page one is not displayed.");
			}

			// validate the details of the second field of page one
			try {
				String fourthField2 = "//table[@id='propertyTabRecordsTable']//tbody//tr[1]//td[4]//span[contains(text(),'Yes')]";
				String fourthField2_actual = (driver.findElement(By.xpath(fourthField2)).getText()).trim();

				if (fourthField2_actual.equals("Yes")) {
					successMessage("The details of the second field of page one is displayed successfully.");
				} else {
					verificationFailedMessage("The details of the second field of page one is not displayed.");
				}
			} catch (Throwable t) {
				verificationFailedMessage("The details of the second field of page one is not displayed.");
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
			consoleMessage("Clicked on the delete button of the newly created custom form.");

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
