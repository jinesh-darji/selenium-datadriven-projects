package testcases.E2Etestcasesuite.customformmodule;

import java.io.IOException;
import java.util.Hashtable;

import org.apache.commons.lang3.RandomStringUtils;
import org.openqa.selenium.By;
import org.testng.annotations.Test;

import base.Helper;
import base.TestBase;
import utilities.TestUtil;

public class RR6291CustomForm4Test extends TestBase {

	@Test(dataProviderClass = TestUtil.class, dataProvider = "dp")
	public void rR6291CustomForm4Test(Hashtable<String, String> data) throws IOException, InterruptedException {

		execution(data, "rR6291CustomForm4Test");

		// VALIDATE THE 'USER TO VIEW FORM' AND 'ROLE TO VIEW FORM' PERMISSIONS OF THE
		// CUSTOM FORMS

		title("VALIDATE THE 'USER TO VIEW FORM' AND 'ROLE TO VIEW FORM' PERMISSIONS OF THE CUSTOM FORMS");

		Helper helper = new Helper();

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

			// ADD FIELDS IN BOTH THE PAGES

			title("ADD FIELDS IN BOTH THE PAGES");

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

			// ADD THE SECURITY PERMISSION OF THE VIEW CUSTOMER FORM FOR THE JINESH
			// (PROPERTY MANAGER)

			title("ADD THE SECURITY PERMISSION OF THE VIEW CUSTOMER FORM FOR THE JINESH (PROPERTY MANAGER)");

			// click on the security tab
			click("customform_securitytab_XPATH");
			ngDriver.waitForAngularRequestsToFinish();
			System.out.println("Clicked on the security tab.");

			// click on the User to View form field
			click("customform_securitytab_security1_XPATH");
			ngDriver.waitForAngularRequestsToFinish();
			System.out.println("Clicked on the User to View form field.");

			// click on the none button
			click("customform_securitytab_nonebtn_XPATH");
			ngDriver.waitForAngularRequestsToFinish();
			System.out.println("Clicked on the none button.");

			// enter the user name in the search field
			clear("customform_securitytab_searchtxt_XPATH");
			type("customform_securitytab_searchtxt_XPATH", data.get("user1"));
			ngDriver.waitForAngularRequestsToFinish();
			System.out.println("enter the user name in the search field");

			// click on the searched result
			click("customform_securitytab_searchedresult1_XPATH");
			ngDriver.waitForAngularRequestsToFinish();
			System.out.println("Clicked on the searched result.");

			// click on the User to View form field
			click("customform_securitytab_security1_XPATH");
			ngDriver.waitForAngularRequestsToFinish();
			System.out.println("Clicked on the User to View form field.");

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

		// VALIDATE THE FIELDS AND PAGES OF THE CUSTOM REPORT IN THE PROPERTY SUMMARY
		// DASHBOARD
		// - ADMIN USER

		title("VALIDATE THE FIELDS AND PAGES OF THE CUSTOM REPORT IN THE PROPERTY SUMMARY DASHBOARD - ADMIN USER");

		try {

			// wait for the element
			Thread.sleep(5000);

			// click on the property
			click("propertysummary_property1_XPATH");
			ngDriver.waitForAngularRequestsToFinish();
			System.out.println("Clicked on the property.");

			// validate the Property Information section and custom form is displayed or not
			try {

				// scrolldown till Property Information section
				scrollTillElement("customform_portfoliodashboard_propertyinformationtitle_XPATH");

				// validate the newly created custom form in the property summary dashboard
				// screen
				try {
					String customForm1 = "//td[text()='" + data.get("name") + "']";
					String customForm1_actual = (driver.findElement(By.xpath(customForm1)).getText()).trim();

					if (customForm1_actual.equals(data.get("name"))) {

						verificationFailedMessage("The newly created custom form is displayed.");

					} else {
						successMessage("The newly created custom form is not displayed as expected.");
					}

				} catch (Throwable t) {
					successMessage("The newly created custom form is not displayed as expected.");
				}

			} catch (Throwable t) {
				successMessage("The Property Information section is not displayed as expected.");
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

		// LOGOUT THE SESSION FROM THE ADMIN USER AND LOGIN TO PROPERTY MANAGER -
		// JINESH

		title("LOGOUT THE SESSION FROM THE ADMIN USER AND LOGIN TO PROPERTY MANAGER - JINESH");

		try {
			// wait for the element
			Thread.sleep(5000);

			// click on the settings icon from the top of the screen
			click("questionnaire_settingicon_userupdate_CSS");
			System.out.println("Clicked on the settings icon.");
			ngDriver.waitForAngularRequestsToFinish();

			// wait for the element
			explicitWaitClickable("sidemenu_logout_CSS");

			// click on the logout option from the side menu
			click("sidemenu_logout_CSS");
			System.out.println("Clicked on the logout option from the side menu.");
			ngDriver.waitForAngularRequestsToFinish();

			// login with valid credentials

			helper.loginAndUpdateSystemCompany(data, "username", "password", "system_company_1");

			// VALIDATE THE FIELDS AND PAGES OF THE CUSTOM REPORT IN THE PROPERTY SUMMARY
			// DASHBOARD - PROPERTY MANAGER USER - JINESH

			title("VALIDATE THE FIELDS AND PAGES OF THE CUSTOM REPORT IN THE PROPERTY SUMMARY DASHBOARD - PROPERTY MANAGER USER - JINESH");

			try {

				// wait for the element
				Thread.sleep(5000);

				// click on the property
				click("propertysummary_property1_XPATH");
				ngDriver.waitForAngularRequestsToFinish();
				System.out.println("Clicked on the property.");

				// validate the Property Information section and custom form is displayed or not
				try {

					// scrolldown till Property Information section
					scrollTillElement("customform_portfoliodashboard_propertyinformationtitle_XPATH");

					// validate the newly created custom form in the property summary dashboard
					// screen
					try {
						String customForm1 = "//td[text()='" + data.get("name") + "']";
						String customForm1_actual = (driver.findElement(By.xpath(customForm1)).getText()).trim();

						if (customForm1_actual.equals(data.get("name"))) {

							successMessage("The newly created custom form is displayed as expected.");

							// click on the newly created custom form
							String customFormName = "//td[text()='" + data.get("name") + "']";
							driver.findElement(By.xpath(customFormName)).click();
							ngDriver.waitForAngularRequestsToFinish();
							System.out.println("Clicked on the newly created custom form.");

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
								String fieldLabel1_actual = (driver.findElement(By.xpath(fieldLabel1)).getText())
										.trim();

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
								String fieldLabel2_actual = (driver.findElement(By.xpath(fieldLabel2)).getText())
										.trim();

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
								String fieldLabel3_actual = (driver.findElement(By.xpath(fieldLabel3)).getText())
										.trim();

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
								String fieldLabel4_actual = (driver.findElement(By.xpath(fieldLabel4)).getText())
										.trim();

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
								String fieldLabel5_actual = (driver.findElement(By.xpath(fieldLabel5)).getText())
										.trim();

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
								String fieldLabel6_actual = (driver.findElement(By.xpath(fieldLabel6)).getText())
										.trim();

								if (fieldLabel6_actual.equals(pageFieldName4 + ":")) {
									successMessage("The sixth field label is displayed successfully.");
								} else {
									verificationFailedMessage("The sixth field label is not displayed.");
								}
							} catch (Throwable t) {
								verificationFailedMessage("The sixth field label is not displayed.");
							}

						} else {
							verificationFailedMessage("The newly created custom form is not displayed.");
						}

					} catch (Throwable t) {
						verificationFailedMessage("The newly created custom form is not displayed.");
					}

				} catch (Throwable t) {
					verificationFailedMessage("The Property Information section is not displayed.");
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

			// LOGOUT THE SESSION FROM THE PROPERTY MANAGER - JINESH USER AND LOGIN TO ADMIN
			// USER

			title("LOGOUT THE SESSION FROM THE PROPERTY MANAGER - JINESH USER AND LOGIN TO ADMIN USER");

			// wait for the element
			Thread.sleep(5000);

			// click on the settings icon from the top of the screen
			click("questionnaire_settingicon_CSS");
			System.out.println("Clicked on the settings icon.");
			ngDriver.waitForAngularRequestsToFinish();

			// wait for the element
			Thread.sleep(5000);

			// click on the logout option from the side menu
			click("sidemenu_logout_CSS");
			System.out.println("Clicked on the logout option from the side menu.");
			ngDriver.waitForAngularRequestsToFinish();

			// login with valid credentials

			helper.loginAndUpdateSystemCompany(data, "username_1", "password_1", "system_company_1");

		} catch (Throwable t) {
			helper.questionnaireNotDisplayLogout(data);
		}

		// UPDATE THE SECURITY PERMISSION OF THE VIEW CUSTOMER FORM FOR THE CONTRACTOR

		title("UPDATE THE SECURITY PERMISSION OF THE VIEW CUSTOMER FORM FOR THE CONTRACTOR");

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

			// click on the newly created custom record record
			String nameTitle = "//td[text()='" + data.get("name") + "']";
			driver.findElement(By.xpath(nameTitle)).click();
			ngDriver.waitForAngularRequestsToFinish();
			System.out.println("Clicked on the newly created custom record record.");

			// click on the security tab
			click("customform_securitytab_XPATH");
			ngDriver.waitForAngularRequestsToFinish();
			System.out.println("Clicked on the security tab.");

			// click on the User to View form field
			click("customform_securitytab_security1_XPATH");
			ngDriver.waitForAngularRequestsToFinish();
			System.out.println("Clicked on the User to View form field.");

			// click on the none button
			click("customform_securitytab_nonebtn_XPATH");
			ngDriver.waitForAngularRequestsToFinish();
			System.out.println("Clicked on the none button.");

			// click on the User to View form field
			click("customform_securitytab_security1_XPATH");
			ngDriver.waitForAngularRequestsToFinish();
			System.out.println("Clicked on the User to View form field.");

			// click on the Role to View form field
			click("customform_securitytab_security2_XPATH");
			ngDriver.waitForAngularRequestsToFinish();
			System.out.println("Clicked on the Role to View form field.");

			// click on the none button
			click("customform_securitytab_nonebtn_XPATH");
			ngDriver.waitForAngularRequestsToFinish();
			System.out.println("Clicked on the none button.");

			// enter the user name in the search field
			clear("customform_securitytab_searchtxt_XPATH");
			type("customform_securitytab_searchtxt_XPATH", data.get("role1"));
			ngDriver.waitForAngularRequestsToFinish();
			System.out.println("enter the user name in the search field");

			// click on the searched result
			click("customform_securitytab_searchedresult2_XPATH");
			ngDriver.waitForAngularRequestsToFinish();
			System.out.println("Clicked on the searched result.");

			// click on the Role to View form field
			click("customform_securitytab_security2_XPATH");
			ngDriver.waitForAngularRequestsToFinish();
			System.out.println("Clicked on the Role to View form field.");

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

		// VALIDATE THE FIELDS AND PAGES OF THE CUSTOM REPORT IN THE PROPERTY SUMMARY
		// DASHBOARD
		// - ADMIN USER

		title("VALIDATE THE FIELDS AND PAGES OF THE CUSTOM REPORT IN THE PROPERTY SUMMARY DASHBOARD - ADMIN USER");

		try {

			// wait for the element
			Thread.sleep(5000);

			// click on the property
			click("propertysummary_property1_XPATH");
			ngDriver.waitForAngularRequestsToFinish();
			System.out.println("Clicked on the property.");

			// validate the Property Information section and custom form is displayed or not
			try {

				// scrolldown till Property Information section
				scrollTillElement("customform_portfoliodashboard_propertyinformationtitle_XPATH");

				// validate the newly created custom form in the property summary dashboard
				// screen
				try {
					String customForm1 = "//td[text()='" + data.get("name") + "']";
					String customForm1_actual = (driver.findElement(By.xpath(customForm1)).getText()).trim();

					if (customForm1_actual.equals(data.get("name"))) {

						verificationFailedMessage("The newly created custom form is displayed.");

					} else {
						successMessage("The newly created custom form is not displayed as expected.");
					}

				} catch (Throwable t) {
					successMessage("The newly created custom form is not displayed as expected.");
				}

			} catch (Throwable t) {
				successMessage("The Property Information section is not displayed as expected.");
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

		// LOGOUT THE SESSION FROM THE ADMIN USER AND LOGIN TO PROPERTY MANAGER -
		// JINESH

		title("LOGOUT THE SESSION FROM THE ADMIN USER AND LOGIN TO PROPERTY MANAGER - JINESH");

		try {
			// wait for the element
			Thread.sleep(5000);

			// click on the settings icon from the top of the screen
			click("questionnaire_settingicon_userupdate_CSS");
			System.out.println("Clicked on the settings icon.");
			ngDriver.waitForAngularRequestsToFinish();

			// wait for the element
			explicitWaitClickable("sidemenu_logout_CSS");

			// click on the logout option from the side menu
			click("sidemenu_logout_CSS");
			System.out.println("Clicked on the logout option from the side menu.");
			ngDriver.waitForAngularRequestsToFinish();

			// login with valid credentials

			helper.loginAndUpdateSystemCompany(data, "username", "password", "system_company_1");

			// VALIDATE THE FIELDS AND PAGES OF THE CUSTOM REPORT IN THE PROPERTY SUMMARY
			// DASHBOARD
			// - PROPERTY MANAGER USER - JINESH

			title("VALIDATE THE FIELDS AND PAGES OF THE CUSTOM REPORT IN THE PROPERTY SUMMARY DASHBOARD - PROPERTY MANAGER USER - JINESH");

			try {

				// wait for the element
				Thread.sleep(5000);

				// click on the property
				click("propertysummary_property1_XPATH");
				ngDriver.waitForAngularRequestsToFinish();
				System.out.println("Clicked on the property.");

				// validate the Property Information section and custom form is displayed or not
				try {

					// scrolldown till Property Information section
					scrollTillElement("customform_portfoliodashboard_propertyinformationtitle_XPATH");

					// validate the newly created custom form in the property summary dashboard
					// screen
					try {
						String customForm1 = "//td[text()='" + data.get("name") + "']";
						String customForm1_actual = (driver.findElement(By.xpath(customForm1)).getText()).trim();

						if (customForm1_actual.equals(data.get("name"))) {

							verificationFailedMessage("The newly created custom form is displayed.");

						} else {
							successMessage("The newly created custom form is not displayed as expected.");
						}

					} catch (Throwable t) {
						successMessage("The newly created custom form is not displayed as expected.");
					}

				} catch (Throwable t) {
					successMessage("The Property Information section is not displayed as expected.");
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

			// LOGOUT THE SESSION FROM THE PROPERTY MANAGER - JINESH USER AND LOGIN TO ADMIN
			// USER

			title("LOGOUT THE SESSION FROM THE PROPERTY MANAGER - JINESH USER AND LOGIN TO ADMIN USER");

			// wait for the element
			Thread.sleep(5000);

			// click on the settings icon from the top of the screen
			click("questionnaire_settingicon_CSS");
			System.out.println("Clicked on the settings icon.");
			ngDriver.waitForAngularRequestsToFinish();

			// wait for the element
			Thread.sleep(5000);

			// click on the logout option from the side menu
			click("sidemenu_logout_CSS");
			System.out.println("Clicked on the logout option from the side menu.");
			ngDriver.waitForAngularRequestsToFinish();

			// login with valid credentials

			helper.loginAndUpdateSystemCompany(data, "username_1", "password_1", "system_company_1");

		} catch (Throwable t) {
			helper.questionnaireNotDisplayLogout(data);
		}

		// LOGOUT THE SESSION FROM THE ADMIN USER AND LOGIN TO CONTRACTOR -
		// JINESH CONTRACTOR

		title("LOGOUT THE SESSION FROM THE ADMIN USER AND LOGIN TO CONTRACTOR - JINESH CONTRACTOR");

		try {
			// wait for the element
			Thread.sleep(5000);

			// click on the settings icon from the top of the screen
			click("questionnaire_settingicon_userupdate_CSS");
			System.out.println("Clicked on the settings icon.");
			ngDriver.waitForAngularRequestsToFinish();

			// wait for the element
			explicitWaitClickable("sidemenu_logout_CSS");

			// click on the logout option from the side menu
			click("sidemenu_logout_CSS");
			System.out.println("Clicked on the logout option from the side menu.");
			ngDriver.waitForAngularRequestsToFinish();

			// login with valid credentials

			helper.loginAndUpdateSystemCompany(data, "username_2", "password_2", "system_company_1");

			// VALIDATE THE FIELDS AND PAGES OF THE CUSTOM REPORT IN THE PROPERTY SUMMARY
			// DASHBOARD
			// - CONTRACTOR USER - JINESH CONTRACTOR

			title("VALIDATE THE FIELDS AND PAGES OF THE CUSTOM REPORT IN THE PROPERTY SUMMARY DASHBOARD - CONTRACTOR USER - JINESH CONTRACTOR");

			try {

				// wait for the element
				Thread.sleep(5000);

				// click on the property
				click("propertysummary_property1_XPATH");
				ngDriver.waitForAngularRequestsToFinish();
				System.out.println("Clicked on the property.");

				// validate the Property Information section and custom form is displayed or not
				try {

					// scrolldown till Property Information section
					scrollTillElement("customform_portfoliodashboard_propertyinformationtitle_XPATH");

					// validate the newly created custom form in the property summary dashboard
					// screen
					try {
						String customForm1 = "//td[text()='" + data.get("name") + "']";
						String customForm1_actual = (driver.findElement(By.xpath(customForm1)).getText()).trim();

						if (customForm1_actual.equals(data.get("name"))) {

							successMessage("The newly created custom form is displayed as expected.");

							// click on the newly created custom form
							String customFormName = "//td[text()='" + data.get("name") + "']";
							driver.findElement(By.xpath(customFormName)).click();
							ngDriver.waitForAngularRequestsToFinish();
							System.out.println("Clicked on the newly created custom form.");

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
								String fieldLabel1_actual = (driver.findElement(By.xpath(fieldLabel1)).getText())
										.trim();

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
								String fieldLabel2_actual = (driver.findElement(By.xpath(fieldLabel2)).getText())
										.trim();

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
								String fieldLabel3_actual = (driver.findElement(By.xpath(fieldLabel3)).getText())
										.trim();

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
								String fieldLabel4_actual = (driver.findElement(By.xpath(fieldLabel4)).getText())
										.trim();

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
								String fieldLabel5_actual = (driver.findElement(By.xpath(fieldLabel5)).getText())
										.trim();

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
								String fieldLabel6_actual = (driver.findElement(By.xpath(fieldLabel6)).getText())
										.trim();

								if (fieldLabel6_actual.equals(pageFieldName4 + ":")) {
									successMessage("The sixth field label is displayed successfully.");
								} else {
									verificationFailedMessage("The sixth field label is not displayed.");
								}
							} catch (Throwable t) {
								verificationFailedMessage("The sixth field label is not displayed.");
							}

						} else {
							verificationFailedMessage("The newly created custom form is not displayed.");
						}

					} catch (Throwable t) {
						verificationFailedMessage("The newly created custom form is not displayed.");
					}

				} catch (Throwable t) {
					verificationFailedMessage("The Property Information section is not displayed.");
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

			// LOGOUT THE SESSION FROM THE CONTRACTOR - JINESH CONTRACTOR USER AND LOGIN TO
			// ADMIN USER

			title("LOGOUT THE SESSION FROM THE CONTRACTOR - JINESH CONTRACTOR USER AND LOGIN TO ADMIN USER");

			// wait for the element
			Thread.sleep(5000);

			// click on the settings icon from the top of the screen
			click("questionnaire_settingicon_CSS");
			System.out.println("Clicked on the settings icon.");
			ngDriver.waitForAngularRequestsToFinish();

			// wait for the element
			Thread.sleep(5000);

			// click on the logout option from the side menu
			click("sidemenu_logout_CSS");
			System.out.println("Clicked on the logout option from the side menu.");
			ngDriver.waitForAngularRequestsToFinish();

			// login with valid credentials

			helper.loginAndUpdateSystemCompany(data, "username_1", "password_1", "system_company_1");

		} catch (Throwable t) {
			helper.questionnaireNotDisplayLogout(data);
		}

		// UPDATE THE SECURITY PERMISSION OF THE VIEW CUSTOMER FORM FOR THE JINESH
		// (PROPERTY MANAGER) AND CONTRACTOR

		title("UPDATE THE SECURITY PERMISSION OF THE VIEW CUSTOMER FORM FOR THE JINESH (PROPERTY MANAGER) AND CONTRACTOR");

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

			// click on the newly created custom record record
			String nameTitle = "//td[text()='" + data.get("name") + "']";
			driver.findElement(By.xpath(nameTitle)).click();
			ngDriver.waitForAngularRequestsToFinish();
			System.out.println("Clicked on the newly created custom record record.");

			// click on the security tab
			click("customform_securitytab_XPATH");
			ngDriver.waitForAngularRequestsToFinish();
			System.out.println("Clicked on the security tab.");

			// click on the User to View form field
			click("customform_securitytab_security1_XPATH");
			ngDriver.waitForAngularRequestsToFinish();
			System.out.println("Clicked on the User to View form field.");

			// click on the none button
			click("customform_securitytab_nonebtn_XPATH");
			ngDriver.waitForAngularRequestsToFinish();
			System.out.println("Clicked on the none button.");

			// enter the user name in the search field
			clear("customform_securitytab_searchtxt_XPATH");
			type("customform_securitytab_searchtxt_XPATH", data.get("user1"));
			ngDriver.waitForAngularRequestsToFinish();
			System.out.println("enter the user name in the search field");

			// click on the searched result
			click("customform_securitytab_searchedresult1_XPATH");
			ngDriver.waitForAngularRequestsToFinish();
			System.out.println("Clicked on the searched result.");

			// click on the User to View form field
			click("customform_securitytab_security1_XPATH");
			ngDriver.waitForAngularRequestsToFinish();
			System.out.println("Clicked on the User to View form field.");

			// click on the Role to View form field
			click("customform_securitytab_security2_XPATH");
			ngDriver.waitForAngularRequestsToFinish();
			System.out.println("Clicked on the Role to View form field.");

			// click on the none button
			click("customform_securitytab_nonebtn_XPATH");
			ngDriver.waitForAngularRequestsToFinish();
			System.out.println("Clicked on the none button.");

			// enter the user name in the search field
			clear("customform_securitytab_searchtxt_XPATH");
			type("customform_securitytab_searchtxt_XPATH", data.get("role1"));
			ngDriver.waitForAngularRequestsToFinish();
			System.out.println("enter the user name in the search field");

			// click on the searched result
			click("customform_securitytab_searchedresult2_XPATH");
			ngDriver.waitForAngularRequestsToFinish();
			System.out.println("Clicked on the searched result.");

			// click on the Role to View form field
			click("customform_securitytab_security2_XPATH");
			ngDriver.waitForAngularRequestsToFinish();
			System.out.println("Clicked on the Role to View form field.");

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

		// VALIDATE THE FIELDS AND PAGES OF THE CUSTOM REPORT IN THE PROPERTY SUMMARY
		// DASHBOARD
		// - ADMIN USER

		title("VALIDATE THE FIELDS AND PAGES OF THE CUSTOM REPORT IN THE PROPERTY SUMMARY DASHBOARD - ADMIN USER");

		try {

			// wait for the element
			Thread.sleep(5000);

			// click on the property
			click("propertysummary_property1_XPATH");
			ngDriver.waitForAngularRequestsToFinish();
			System.out.println("Clicked on the property.");

			// validate the Property Information section and custom form is displayed or not
			try {

				// scrolldown till Property Information section
				scrollTillElement("customform_portfoliodashboard_propertyinformationtitle_XPATH");

				// validate the newly created custom form in the property summary dashboard
				// screen
				try {
					String customForm1 = "//td[text()='" + data.get("name") + "']";
					String customForm1_actual = (driver.findElement(By.xpath(customForm1)).getText()).trim();

					if (customForm1_actual.equals(data.get("name"))) {

						verificationFailedMessage("The newly created custom form is displayed.");

					} else {
						successMessage("The newly created custom form is not displayed as expected.");
					}

				} catch (Throwable t) {
					successMessage("The newly created custom form is not displayed as expected.");
				}

			} catch (Throwable t) {
				successMessage("The Property Information section is not displayed as expected.");
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

		// LOGOUT THE SESSION FROM THE ADMIN USER AND LOGIN TO PROPERTY MANAGER -
		// JINESH

		title("LOGOUT THE SESSION FROM THE ADMIN USER AND LOGIN TO PROPERTY MANAGER - JINESH");

		try {
			// wait for the element
			Thread.sleep(5000);

			// click on the settings icon from the top of the screen
			click("questionnaire_settingicon_userupdate_CSS");
			System.out.println("Clicked on the settings icon.");
			ngDriver.waitForAngularRequestsToFinish();

			// wait for the element
			explicitWaitClickable("sidemenu_logout_CSS");

			// click on the logout option from the side menu
			click("sidemenu_logout_CSS");
			System.out.println("Clicked on the logout option from the side menu.");
			ngDriver.waitForAngularRequestsToFinish();

			// login with valid credentials

			helper.loginAndUpdateSystemCompany(data, "username", "password", "system_company_1");

			// VALIDATE THE FIELDS AND PAGES OF THE CUSTOM REPORT IN THE PROPERTY SUMMARY
			// DASHBOARD
			// - PROPERTY MANAGER USER - JINESH

			title("VALIDATE THE FIELDS AND PAGES OF THE CUSTOM REPORT IN THE PROPERTY SUMMARY DASHBOARD - PROPERTY MANAGER USER - JINESH");

			try {

				// wait for the element
				Thread.sleep(5000);

				// click on the property
				click("propertysummary_property1_XPATH");
				ngDriver.waitForAngularRequestsToFinish();
				System.out.println("Clicked on the property.");

				// validate the Property Information section and custom form is displayed or not

				try {

					// scrolldown till Property Information section
					scrollTillElement("customform_portfoliodashboard_propertyinformationtitle_XPATH");

					// validate the newly created custom form in the property summary dashboard
					// screen
					try {
						String customForm1 = "//td[text()='" + data.get("name") + "']";
						String customForm1_actual = (driver.findElement(By.xpath(customForm1)).getText()).trim();

						if (customForm1_actual.equals(data.get("name"))) {

							successMessage("The newly created custom form is displayed as expected.");

							// click on the newly created custom form
							String customFormName = "//td[text()='" + data.get("name") + "']";
							driver.findElement(By.xpath(customFormName)).click();
							ngDriver.waitForAngularRequestsToFinish();
							System.out.println("Clicked on the newly created custom form.");

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
								String fieldLabel1_actual = (driver.findElement(By.xpath(fieldLabel1)).getText())
										.trim();

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
								String fieldLabel2_actual = (driver.findElement(By.xpath(fieldLabel2)).getText())
										.trim();

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
								String fieldLabel3_actual = (driver.findElement(By.xpath(fieldLabel3)).getText())
										.trim();

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
								String fieldLabel4_actual = (driver.findElement(By.xpath(fieldLabel4)).getText())
										.trim();

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
								String fieldLabel5_actual = (driver.findElement(By.xpath(fieldLabel5)).getText())
										.trim();

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
								String fieldLabel6_actual = (driver.findElement(By.xpath(fieldLabel6)).getText())
										.trim();

								if (fieldLabel6_actual.equals(pageFieldName4 + ":")) {
									successMessage("The sixth field label is displayed successfully.");
								} else {
									verificationFailedMessage("The sixth field label is not displayed.");
								}
							} catch (Throwable t) {
								verificationFailedMessage("The sixth field label is not displayed.");
							}

						} else {
							verificationFailedMessage("The newly created custom form is not displayed.");
						}

					} catch (Throwable t) {
						verificationFailedMessage("The newly created custom form is not displayed.");
					}

				} catch (Throwable t) {
					verificationFailedMessage("The Property Information section is not displayed.");
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

			// LOGOUT THE SESSION FROM THE PROPERTY MANAGER - JINESH USER AND LOGIN TO ADMIN
			// USER

			title("LOGOUT THE SESSION FROM THE PROPERTY MANAGER - JINESH USER AND LOGIN TO ADMIN USER");

			// wait for the element
			Thread.sleep(5000);

			// click on the settings icon from the top of the screen
			click("questionnaire_settingicon_CSS");
			System.out.println("Clicked on the settings icon.");
			ngDriver.waitForAngularRequestsToFinish();

			// wait for the element
			Thread.sleep(5000);

			// click on the logout option from the side menu
			click("sidemenu_logout_CSS");
			System.out.println("Clicked on the logout option from the side menu.");
			ngDriver.waitForAngularRequestsToFinish();

			// login with valid credentials

			helper.loginAndUpdateSystemCompany(data, "username_1", "password_1", "system_company_1");

		} catch (Throwable t) {
			helper.questionnaireNotDisplayLogout(data);
		}

		// LOGOUT THE SESSION FROM THE ADMIN USER AND LOGIN TO CONTRACTOR -
		// JINESH CONTRACTOR

		title("LOGOUT THE SESSION FROM THE ADMIN USER AND LOGIN TO CONTRACTOR - JINESH CONTRACTOR");

		try {
			// wait for the element
			Thread.sleep(5000);

			// click on the settings icon from the top of the screen
			click("questionnaire_settingicon_userupdate_CSS");
			System.out.println("Clicked on the settings icon.");
			ngDriver.waitForAngularRequestsToFinish();

			// wait for the element
			explicitWaitClickable("sidemenu_logout_CSS");

			// click on the logout option from the side menu
			click("sidemenu_logout_CSS");
			System.out.println("Clicked on the logout option from the side menu.");
			ngDriver.waitForAngularRequestsToFinish();

			// login with valid credentials

			helper.loginAndUpdateSystemCompany(data, "username_2", "password_2", "system_company_1");

			// VALIDATE THE FIELDS AND PAGES OF THE CUSTOM REPORT IN THE PROPERTY SUMMARY
			// DASHBOARD
			// - CONTRACTOR USER - JINESH CONTRACTOR

			title("VALIDATE THE FIELDS AND PAGES OF THE CUSTOM REPORT IN THE PROPERTY SUMMARY DASHBOARD - CONTRACTOR USER - JINESH CONTRACTOR");

			try {

				// wait for the element
				Thread.sleep(5000);

				// click on the property
				click("propertysummary_property1_XPATH");
				ngDriver.waitForAngularRequestsToFinish();
				System.out.println("Clicked on the property.");

				// validate the Property Information section and custom form is displayed or not
				try {

					// scrolldown till Property Information section
					scrollTillElement("customform_portfoliodashboard_propertyinformationtitle_XPATH");

					// validate the newly created custom form in the property summary dashboard
					// screen
					try {
						String customForm1 = "//td[text()='" + data.get("name") + "']";
						String customForm1_actual = (driver.findElement(By.xpath(customForm1)).getText()).trim();

						if (customForm1_actual.equals(data.get("name"))) {

							successMessage("The newly created custom form is displayed as expected.");

							// click on the newly created custom form
							String customFormName = "//td[text()='" + data.get("name") + "']";
							driver.findElement(By.xpath(customFormName)).click();
							ngDriver.waitForAngularRequestsToFinish();
							System.out.println("Clicked on the newly created custom form.");

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
								String fieldLabel1_actual = (driver.findElement(By.xpath(fieldLabel1)).getText())
										.trim();

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
								String fieldLabel2_actual = (driver.findElement(By.xpath(fieldLabel2)).getText())
										.trim();

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
								String fieldLabel3_actual = (driver.findElement(By.xpath(fieldLabel3)).getText())
										.trim();

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
								String fieldLabel4_actual = (driver.findElement(By.xpath(fieldLabel4)).getText())
										.trim();

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
								String fieldLabel5_actual = (driver.findElement(By.xpath(fieldLabel5)).getText())
										.trim();

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
								String fieldLabel6_actual = (driver.findElement(By.xpath(fieldLabel6)).getText())
										.trim();

								if (fieldLabel6_actual.equals(pageFieldName4 + ":")) {
									successMessage("The sixth field label is displayed successfully.");
								} else {
									verificationFailedMessage("The sixth field label is not displayed.");
								}
							} catch (Throwable t) {
								verificationFailedMessage("The sixth field label is not displayed.");
							}

						} else {
							verificationFailedMessage("The newly created custom form is not displayed.");
						}

					} catch (Throwable t) {
						verificationFailedMessage("The newly created custom form is not displayed.");
					}

				} catch (Throwable t) {
					verificationFailedMessage("The Property Information section is not displayed.");
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

			// LOGOUT THE SESSION FROM THE CONTRACTOR - JINESH CONTRACTOR USER AND LOGIN TO
			// ADMIN USER

			title("LOGOUT THE SESSION FROM THE CONTRACTOR - JINESH CONTRACTOR USER AND LOGIN TO ADMIN USER");

			// wait for the element
			Thread.sleep(5000);

			// click on the settings icon from the top of the screen
			click("questionnaire_settingicon_CSS");
			System.out.println("Clicked on the settings icon.");
			ngDriver.waitForAngularRequestsToFinish();

			// wait for the element
			Thread.sleep(5000);

			// click on the logout option from the side menu
			click("sidemenu_logout_CSS");
			System.out.println("Clicked on the logout option from the side menu.");
			ngDriver.waitForAngularRequestsToFinish();

			// login with valid credentials

			helper.loginAndUpdateSystemCompany(data, "username_1", "password_1", "system_company_1");

		} catch (Throwable t) {
			helper.questionnaireNotDisplayLogout(data);
		}

		// LOGOUT THE SESSION FROM THE ADMIN USER AND LOGIN TO HR - JINESH HR

		title("LOGOUT THE SESSION FROM THE ADMIN USER AND LOGIN TO HR - JINESH HR");

		try {
			// wait for the element
			Thread.sleep(5000);

			// click on the settings icon from the top of the screen
			click("questionnaire_settingicon_userupdate_CSS");
			System.out.println("Clicked on the settings icon.");
			ngDriver.waitForAngularRequestsToFinish();

			// wait for the element
			explicitWaitClickable("sidemenu_logout_CSS");

			// click on the logout option from the side menu
			click("sidemenu_logout_CSS");
			System.out.println("Clicked on the logout option from the side menu.");
			ngDriver.waitForAngularRequestsToFinish();

			// login with valid credentials

			helper.loginAndUpdateSystemCompany(data, "username_3", "password_3", "system_company_1");

			// VALIDATE THE FIELDS AND PAGES OF THE CUSTOM REPORT IN THE PROPERTY SUMMARY
			// DASHBOARD
			// - HR USER - JINESH HR

			title("VALIDATE THE FIELDS AND PAGES OF THE CUSTOM REPORT IN THE PROPERTY SUMMARY DASHBOARD - HR USER - JINESH HR");

			try {

				// wait for the element
				Thread.sleep(5000);
				// click on the property
				click("propertysummary_property1_XPATH");
				ngDriver.waitForAngularRequestsToFinish();
				System.out.println("Clicked on the property.");

				// validate the Property Information section and custom form is displayed or not
				try {

					// scrolldown till Property Information section
					scrollTillElement("customform_portfoliodashboard_propertyinformationtitle_XPATH");

					// validate the newly created custom form in the property summary dashboard
					// screen
					try {
						String customForm1 = "//td[text()='" + data.get("name") + "']";
						String customForm1_actual = (driver.findElement(By.xpath(customForm1)).getText()).trim();

						if (customForm1_actual.equals(data.get("name"))) {

							verificationFailedMessage("The newly created custom form is displayed.");

						} else {
							successMessage("The newly created custom form is not displayed as expected.");
						}

					} catch (Throwable t) {
						successMessage("The newly created custom form is not displayed as expected.");
					}

				} catch (Throwable t) {
					successMessage("The Property Information section is not displayed as expected.");
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

			// LOGOUT THE SESSION FROM THE HR USER - JINESH HR AND LOGIN TO
			// ADMIN USER

			title("LOGOUT THE SESSION FROM THE HR USER - JINESH HR AND LOGIN TO ADMIN USER");

			// wait for the element
			Thread.sleep(5000);

			// click on the settings icon from the top of the screen
			click("questionnaire_settingicon_CSS");
			System.out.println("Clicked on the settings icon.");
			ngDriver.waitForAngularRequestsToFinish();

			// wait for the element
			Thread.sleep(5000);

			// click on the logout option from the side menu
			click("sidemenu_logout_CSS");
			System.out.println("Clicked on the logout option from the side menu.");
			ngDriver.waitForAngularRequestsToFinish();

			// login with valid credentials

			helper.loginAndUpdateSystemCompany(data, "username_1", "password_1", "system_company_1");

		} catch (Throwable t) {
			helper.questionnaireNotDisplayLogout(data);
		}

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
