package testcases.E2Etestcasesuite.customformmodule;

import java.io.IOException;
import java.util.Hashtable;

import org.apache.commons.lang3.RandomStringUtils;
import org.openqa.selenium.By;
import org.testng.annotations.Test;

import base.TestBase;
import utilities.TestUtil;

public class RR6462CustomForm2Test extends TestBase {

	@Test(dataProviderClass = TestUtil.class, dataProvider = "dp")
	public void rR6462CustomForm2Test(Hashtable<String, String> data) throws IOException, InterruptedException {

		execution(data, "rR6462CustomForm2Test");

		// ADD THE NEW FIELDS AND NEW PAGES IN THE CUSTOM RECORDS AND VALIDATE IN THE
		// PORTFOLIO DASHBOARD AND PROPERTY SUMMARY DASHBOARD - CORPORATE LEVEL

		title("ADD THE NEW FIELDS AND NEW PAGES IN THE CUSTOM RECORDS AND VALIDATE IN THE PORTFOLIO DASHBOARD AND PROPERTY SUMMARY DASHBOARD - CORPORATE LEVEL");

		// refresh the page
		driver.navigate().refresh();
		Thread.sleep(5000);
		driver.navigate().refresh();

		System.out.println("Navigate to the Home Screen i.e. Property List Screen.");

		String name = RandomStringUtils.randomAlphabetic(8); // Custom Form Name
		String fieldName1 = RandomStringUtils.randomAlphabetic(8); // Field Name 1
		String fieldName2 = RandomStringUtils.randomAlphabetic(8); // Field Name 2
		String fieldDetail1 = RandomStringUtils.randomAlphabetic(8); // Field Name 1
		String pageName1 = RandomStringUtils.randomAlphabetic(8); // Page Name 1
		String pageName2 = RandomStringUtils.randomAlphabetic(8); // Page Name 2
		String pageFieldName1 = RandomStringUtils.randomAlphabetic(8); // Page Name 1 - Field 1
		String pageFieldName2 = RandomStringUtils.randomAlphabetic(8); // Page Name 1 - Field 2
		String pageFieldName3 = RandomStringUtils.randomAlphabetic(8); // Page Name 2 - Field 1
		String pageFieldName4 = RandomStringUtils.randomAlphabetic(8); // Page Name 2 - Field 2
		String pageFieldDetail1 = RandomStringUtils.randomAlphabetic(8); // Page Name 1 - Field 1
		String pageFieldDetail3 = RandomStringUtils.randomAlphabetic(8); // Page Name 2 - Field 1

		// CREATE NEW CUSTOM FORMS FOR CORPORATE LEVEL
		title("CREATE NEW CUSTOM FORMS FOR CORPORATE LEVEL");

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
				String Validation0 = "//td[text()='" + name + "']";
				String Validation0_actual = (driver.findElement(By.xpath(Validation0)).getText()).trim();

				if (Validation0_actual.equals(name)) {

					successMessage("The Name of the custom form is displayed correctly.");

				} else {
					verificationFailedMessage("The Name of the custom form is displayed correctly.");
				}

			} catch (Throwable t) {
				verificationFailedMessage("The Name of the custom form is displayed correctly.");
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

			// enter the second page name name in the page name field
			type("customform_portfoliodashboard_pagenametxt_XPATH", pageName2);

			// click on the add button
			click("customform_portfoliodashboard_pagename_addbtn_XPATH");

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

			// click on the second page name tab
			String page2 = "//span[contains(text(),'" + pageName2 + "')]";
			driver.findElement(By.xpath(page2)).click();
			consoleMessage("Clicked on the second page name tab.");

			// click on the add field button
			click("customform_addfieldbtn_XPATH");

			// scroll to bottom
			scrollBottom();

			// enter field name
			type("customform_addfield_nametxt_XPATH", pageFieldName3);

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

			// click on the second page name tab
			String page22 = "//span[contains(text(),'" + pageName2 + "')]";
			driver.findElement(By.xpath(page22)).click();
			consoleMessage("Clicked on the second page name tab.");

			// scroll to bottom
			scrollBottom();

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

			// scroll to bottom
			scrollBottom();

			// enter field name
			type("customform_addfield_nametxt_XPATH", pageFieldName4);

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

			// click on the second page name tab
			String page222 = "//span[contains(text(),'" + pageName2 + "')]";
			driver.findElement(By.xpath(page222)).click();
			consoleMessage("Clicked on the second page name tab.");

			// scroll to bottom
			scrollBottom();

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

		// VALIDATE THE NEWLY CREATED FIELDS AND PAGES OF THE CUSTOM REPORT IN THE
		// PORTFOLIO DASHBOARD
		title("VALIDATE THE NEWLY CREATED FIELDS AND PAGES OF THE CUSTOM REPORT IN THE PORTFOLIO DASHBOARD");

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

			// wait for the element
			Thread.sleep(10000);

			// click on the custom form
			String customForm1 = "//td[text()='" + name + "']";
			driver.findElement(By.xpath(customForm1)).click();
			consoleMessage("Clicked on the custom form.");

			// validate the property list is displayed or not
			try {
				String propertylbl = "//b[contains(text(),'Property Name')]";
				String propertylbl_actual = (driver.findElement(By.xpath(propertylbl)).getText()).trim();

				if (propertylbl_actual.equals("Property Name")) {
					verificationFailedMessage("The property list is displayed");

				} else {
					successMessage("The property list is not displayed as expected.");
				}
			} catch (Throwable t) {
				successMessage("The property list is not displayed as expected.");
			}

			// validate the field 1
			try {
				String field11 = "//th[text()='" + fieldName1 + "']";
				String field11_actual = (driver.findElement(By.xpath(field11)).getText()).trim();

				if (field11_actual.equals(fieldName1)) {
					successMessage("The respective field is displayed successfully.");
				} else {
					verificationFailedMessage("The repsective field is not displayed.");
				}
			} catch (Throwable t) {
				verificationFailedMessage("The repsective field is not displayed.");
			}

			// validate the field 2
			try {
				String field22 = "//th[text()='" + fieldName2 + "']";
				String field22_actual = (driver.findElement(By.xpath(field22)).getText()).trim();

				if (field22_actual.equals(fieldName2)) {
					successMessage("The respective field is displayed successfully.");
				} else {
					verificationFailedMessage("The repsective field is not displayed.");
				}
			} catch (Throwable t) {
				verificationFailedMessage("The repsective field is not displayed.");
			}

			// validate the field 1 of page 1
			try {
				String field33 = "//th[text()='" + pageFieldName1 + "']";
				String field33_actual = (driver.findElement(By.xpath(field33)).getText()).trim();

				if (field33_actual.equals(pageFieldName1)) {

					successMessage("The respective field is displayed successfully.");

				} else {
					verificationFailedMessage("The repsective field is not displayed.");
				}
			} catch (Throwable t) {
				verificationFailedMessage("The repsective field is not displayed.");
			}

			// validate the field 2 of page 1
			try {
				String field44 = "//th[text()='" + pageFieldName2 + "']";
				String field44_actual = (driver.findElement(By.xpath(field44)).getText()).trim();

				if (field44_actual.equals(pageFieldName2)) {

					successMessage("The respective field is displayed successfully.");

				} else {
					verificationFailedMessage("The repsective field is not displayed.");
				}
			} catch (Throwable t) {
				verificationFailedMessage("The repsective field is not displayed.");
			}

			// validate the field 1 of page 2
			try {
				String field55 = "//th[text()='" + pageFieldName3 + "']";
				String field55_actual = (driver.findElement(By.xpath(field55)).getText()).trim();

				if (field55_actual.equals(pageFieldName3)) {

					successMessage("The respective field is displayed successfully.");

				} else {
					verificationFailedMessage("The repsective field is not displayed.");
				}
			} catch (Throwable t) {
				verificationFailedMessage("The repsective field is not displayed.");
			}

			// validate the field 2 of page 2
			try {
				String field66 = "//th[text()='" + pageFieldName4 + "']";
				String field66_actual = (driver.findElement(By.xpath(field66)).getText()).trim();

				if (field66_actual.equals(pageFieldName4)) {

					successMessage("The respective field is displayed successfully.");

				} else {
					verificationFailedMessage("The repsective field is not displayed.");
				}
			} catch (Throwable t) {
				verificationFailedMessage("The repsective field is not displayed.");
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

			// wait for the element
			Thread.sleep(10000);

			// click on the custom form
			String customForm1 = "//td[text()='" + name + "']";
			driver.findElement(By.xpath(customForm1)).click();
			consoleMessage("Clicked on the custom form.");

			// validate the property name is displayed or not
			switchVerificationFailed("customform_property1_title_XPATH", "[DND] AAAA Risk Test Prop 01 - 01",
					"The [DND] AAAA Risk Test Prop 01 - 01 is not displayed.");

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
				String fieldLabel1 = "//b[contains(text(),'" + fieldName1 + "')]";
				String fieldLabel1_actual = (driver.findElement(By.xpath(fieldLabel1)).getText()).trim();

				if (fieldLabel1_actual.equals(fieldName1)) {
					successMessage("The first field label is displayed successfully.");
				} else {
					verificationFailedMessage("The first field label is not displayed.");
				}
			} catch (Throwable t) {
				verificationFailedMessage("The first field label is not displayed.");
			}

			// validate the second field label
			try {
				String fieldLabel2 = "//b[contains(text(),'" + fieldName2 + "')]";
				String fieldLabel2_actual = (driver.findElement(By.xpath(fieldLabel2)).getText()).trim();

				if (fieldLabel2_actual.equals(fieldName2)) {
					successMessage("The second field label is displayed successfully.");
				} else {
					verificationFailedMessage("The second field label is not displayed.");
				}
			} catch (Throwable t) {
				verificationFailedMessage("The second field label is not displayed.");
			}

			// validate the first field label of page one
			try {
				String fieldLabel3 = "//b[contains(text(),'" + pageFieldName1 + "')]";
				String fieldLabel3_actual = (driver.findElement(By.xpath(fieldLabel3)).getText()).trim();

				if (fieldLabel3_actual.equals(pageFieldName1)) {
					successMessage("The first field label of page one is displayed successfully.");
				} else {
					verificationFailedMessage("The first field label of page one is not displayed.");
				}
			} catch (Throwable t) {
				verificationFailedMessage("The first field label of page one is not displayed.");
			}

			// validate the second field label of page one
			try {
				String fieldLabel4 = "//b[contains(text(),'" + pageFieldName2 + "')]";
				String fieldLabel4_actual = (driver.findElement(By.xpath(fieldLabel4)).getText()).trim();

				if (fieldLabel4_actual.equals(pageFieldName2)) {
					successMessage("The second field label of page one is displayed successfully.");
				} else {
					verificationFailedMessage("The second field label of page one is not displayed.");
				}
			} catch (Throwable t) {
				verificationFailedMessage("The second field label of page one is not displayed.");
			}

			// validate the first field label of page two
			try {
				String fieldLabel5 = "//b[contains(text(),'" + pageFieldName3 + "')]";
				String fieldLabel5_actual = (driver.findElement(By.xpath(fieldLabel5)).getText()).trim();

				if (fieldLabel5_actual.equals(pageFieldName3)) {
					successMessage("The first field label of page two is displayed successfully.");
				} else {
					verificationFailedMessage("The first field label of page two is not displayed.");
				}
			} catch (Throwable t) {
				verificationFailedMessage("The first field label of page two is not displayed.");
			}

			// validate the second field label of page one
			try {
				String fieldLabel6 = "//b[contains(text(),'" + pageFieldName4 + "')]";
				String fieldLabel6_actual = (driver.findElement(By.xpath(fieldLabel6)).getText()).trim();

				if (fieldLabel6_actual.equals(pageFieldName4)) {
					successMessage("The second field label of page two is displayed successfully.");
				} else {
					verificationFailedMessage("The second field label of page two is not displayed.");
				}
			} catch (Throwable t) {
				verificationFailedMessage("The second field label of page two is not displayed.");
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

			// wait for the element
			Thread.sleep(10000);

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

			// enter the details in the first field
			String firstField = "//input[@id='" + fieldName1 + "TEXT']";
			driver.findElement(By.xpath(firstField)).sendKeys(data.get("first_field"));
			consoleMessage("Entered the details in the first field.");

			// enter the details in the second field
			String secondField = "//input[@id='" + fieldName2 + "NUMBER']";
			driver.findElement(By.xpath(secondField)).sendKeys("123");
			consoleMessage("Entered the details in the second field.");

			// wait for the element
			Thread.sleep(5000);

			// ADD THE DETAILS IN THE FIELDS OF THE FIRST PAGE TAB
			title("ADD THE DETAILS IN THE FIELDS OF THE FIRST PAGE TAB");

			// click on the first page name tab
			String pageTab1 = "//span[text()='" + pageName1 + "']";
			driver.findElement(By.xpath(pageTab1)).click();
			consoleMessage("Clicked on the first page name tab.");

			// enter the details in the first field
			String firstPageField = "//input[@id='" + pageFieldName1 + "TEXT']";
			driver.findElement(By.xpath(firstPageField)).sendKeys(data.get("first_page_field1"));
			consoleMessage("Entered the details in the first field.");

			// enter the details in the second field
			String secondPageField = "//input[@id='" + pageFieldName2 + "NUMBER']";
			driver.findElement(By.xpath(secondPageField)).sendKeys("456");
			consoleMessage("Entered the details in the second field.");

			// wait for the element
			Thread.sleep(5000);

			// ADD THE DETAILS IN THE FIELDS OF THE SECOND PAGE TAB
			title("ADD THE DETAILS IN THE FIELDS OF THE SECOND PAGE TAB");

			// click on the second page name tab
			String pageTab2 = "//span[text()='" + pageName2 + "']";
			driver.findElement(By.xpath(pageTab2)).click();
			consoleMessage("Clicked on the second page name tab.");

			// enter the details in the first field
			String thirdPageField = "//input[@id='" + pageFieldName3 + "TEXT']";
			driver.findElement(By.xpath(thirdPageField)).sendKeys(data.get("second_page_field1"));
			consoleMessage("Entered the details in the first field.");

			// enter the details in the second field
			String fourthPageField = "//input[@id='" + pageFieldName4 + "NUMBER']";
			driver.findElement(By.xpath(fourthPageField)).sendKeys("789");
			consoleMessage("Entered the details in the second field.");

			// click on the save button
			click("customform_portfoliodashboard_fields_savebtn_XPATH");

			// scroll to bottom
			scrollBottom();

			// wait for the element
			Thread.sleep(5000);

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

			// wait for the element
			Thread.sleep(10000);

			// click on the custom form
			String customForm1 = "//td[text()='" + name + "']";
			driver.findElement(By.xpath(customForm1)).click();
			consoleMessage("Clicked on the custom form.");

			// validate the property list is displayed or not
			try {
				String propertylbl = "//b[contains(text(),'Property Name')]";
				String propertylbl_actual = (driver.findElement(By.xpath(propertylbl)).getText()).trim();

				if (propertylbl_actual.equals("Property Name")) {
					verificationFailedMessage("The property list is displayed");

				} else {
					successMessage("The property list is not displayed as expected.");
				}
			} catch (Throwable t) {
				successMessage("The property list is not displayed as expected.");
			}

			// validate the field 1
			try {
				String field11 = "//th[text()='" + fieldName1 + "']";
				String field11_actual = (driver.findElement(By.xpath(field11)).getText()).trim();

				if (field11_actual.equals(fieldName1)) {
					successMessage("The respective field 1 is displayed successfully.");
				} else {
					verificationFailedMessage("The repsective field 1 is not displayed.");
				}
			} catch (Throwable t) {
				verificationFailedMessage("The repsective field 1 is not displayed.");
			}

			// validate the field 2
			try {
				String field22 = "//th[text()='" + fieldName2 + "']";
				String field22_actual = (driver.findElement(By.xpath(field22)).getText()).trim();

				if (field22_actual.equals(fieldName2)) {
					successMessage("The respective field 2 is displayed successfully.");
				} else {
					verificationFailedMessage("The repsective field 2 is not displayed.");
				}
			} catch (Throwable t) {
				verificationFailedMessage("The repsective field 2 is not displayed.");
			}

			// validate the field 1 of page 1
			try {
				String field33 = "//th[text()='" + pageFieldName1 + "']";
				String field33_actual = (driver.findElement(By.xpath(field33)).getText()).trim();

				if (field33_actual.equals(pageFieldName1)) {

					successMessage("The respective field 1 of page 1 is displayed successfully.");
				} else {
					verificationFailedMessage("The repsective field 1 of page 1 is not displayed.");
				}
			} catch (Throwable t) {
				verificationFailedMessage("The repsective field 1 of page 1 is not displayed.");
			}

			// validate the field 2 of page 1
			try {
				String field44 = "//th[text()='" + pageFieldName2 + "']";
				String field44_actual = (driver.findElement(By.xpath(field44)).getText()).trim();

				if (field44_actual.equals(pageFieldName2)) {

					successMessage("The respective field 2 of page 1 is displayed successfully.");
				} else {
					verificationFailedMessage("The repsective field 2 of page 1 is not displayed.");
				}
			} catch (Throwable t) {
				verificationFailedMessage("The repsective field 2 of page 1 is not displayed.");
			}

			// validate the field 1 of page 2
			try {
				String field55 = "//th[text()='" + pageFieldName3 + "']";
				String field55_actual = (driver.findElement(By.xpath(field55)).getText()).trim();

				if (field55_actual.equals(pageFieldName3)) {

					successMessage("The respective field 1 of page 2 is displayed successfully.");
				} else {
					verificationFailedMessage("The repsective field 1 of page 2 is not displayed.");
				}
			} catch (Throwable t) {
				verificationFailedMessage("The repsective field 1 of page 2 is not displayed.");
			}

			// validate the field 2 of page 2
			try {
				String field66 = "//th[text()='" + pageFieldName4 + "']";
				String field66_actual = (driver.findElement(By.xpath(field66)).getText()).trim();

				if (field66_actual.equals(pageFieldName4)) {

					successMessage("The respective field 2 of page 2 is displayed successfully.");
				} else {
					verificationFailedMessage("The repsective field 2 of page 2 is not displayed.");
				}
			} catch (Throwable t) {
				verificationFailedMessage("The repsective field 2 of page 2 is not displayed.");
			}

			// validate the details of the field 1
			try {
				String field11 = "//span[text()='" + data.get("first_field") + "']";
				String field11_actual = (driver.findElement(By.xpath(field11)).getText()).trim();

				if (field11_actual.equals(data.get("first_field"))) {
					successMessage("The respective field details 1 is displayed successfully.");
				} else {
					verificationFailedMessage("The repsective field 1 details is not displayed.");
				}
			} catch (Throwable t) {
				verificationFailedMessage("The repsective field 1 details is not displayed.");
			}

			// validate the details of the field 2
			try {
				String field22 = "//span[text()='" + "123" + "']";
				String field22_actual = (driver.findElement(By.xpath(field22)).getText()).trim();

				if (field22_actual.equals("123")) {
					successMessage("The respective field 2 details is displayed successfully.");
				} else {
					verificationFailedMessage("The repsective field 2 details is not displayed.");
				}
			} catch (Throwable t) {
				verificationFailedMessage("The repsective field 2 details is not displayed.");
			}

			// validate the details of the field 1 of page 1
			try {
				String field33 = "//span[text()='" + data.get("first_page_field1") + "']";
				String field33_actual = (driver.findElement(By.xpath(field33)).getText()).trim();

				if (field33_actual.equals(data.get("first_page_field1"))) {

					successMessage("The respective field 1 of page 1 details is displayed successfully.");
				} else {
					verificationFailedMessage("The repsective field 1 of page 1 details is not displayed.");
				}
			} catch (Throwable t) {
				verificationFailedMessage("The repsective field 1 of page 1 details is not displayed.");
			}

			// validate the details of the field 2 of page 1
			try {
				String field44 = "//span[text()='" + "456" + "']";
				String field44_actual = (driver.findElement(By.xpath(field44)).getText()).trim();

				if (field44_actual.equals("456")) {

					successMessage("The respective field 2 of page 1 details is displayed successfully.");
				} else {
					verificationFailedMessage("The repsective field 2 of page 1 details is not displayed.");
				}
			} catch (Throwable t) {
				verificationFailedMessage("The repsective field 2 of page 1 details is not displayed.");
			}

			// validate the details of the field 1 of page 2
			try {
				String field55 = "//span[text()='" + data.get("second_page_field1") + "']";
				String field55_actual = (driver.findElement(By.xpath(field55)).getText()).trim();

				if (field55_actual.equals(data.get("second_page_field1"))) {

					successMessage("The respective field 1 of page 2 details is displayed successfully.");
				} else {
					verificationFailedMessage("The repsective field 1 of page 2 details is not displayed.");
				}
			} catch (Throwable t) {
				verificationFailedMessage("The repsective field 1 of page 2 details is not displayed.");
			}

			// validate the details of the field 2 of page 2
			try {
				String field66 = "//span[text()='" + "789" + "']";
				String field66_actual = (driver.findElement(By.xpath(field66)).getText()).trim();

				if (field66_actual.equals("789")) {

					successMessage("The respective field 2 of page 2 details is displayed successfully.");
				} else {
					verificationFailedMessage("The repsective field 2 of page 2 details is not displayed.");
				}
			} catch (Throwable t) {
				verificationFailedMessage("The repsective field 2 of page 2 details is not displayed.");
			}

			// wait for the element
			Thread.sleep(10000);

			// click on the custom form detail
			String fieldDetail = "//span[text()='" + data.get("first_field") + "']";
			driver.findElement(By.xpath(fieldDetail)).click();
			consoleMessage("Clicked on the custom form detail.");

			// validate the property name is displayed or not
			switchVerificationFailed("customform_property1_title_XPATH", "[DND] AAAA Risk Test Prop 01 - 01",
					"The [DND] AAAA Risk Test Prop 01 - 01 is not displayed.");

			// scrolldown to bottom
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
			String page1 = "//span[contains(text(),'" + pageName1 + "')]";
			driver.findElement(By.xpath(page1)).click();
			consoleMessage("Clicked on the first page name tab.");

			// scroll down to bottom
			scrollBottom();

			// validate the first field label of page one
			try {
				String pageFieldLabel1 = "//label[contains(text(),'" + pageFieldName1 + "')]";
				String pageFieldLabel1_actual = (driver.findElement(By.xpath(pageFieldLabel1)).getText()).trim();

				if (pageFieldLabel1_actual.equals(pageFieldName1 + ":")) {
					successMessage("The first field label of page one is displayed successfully.");
				} else {
					verificationFailedMessage("The first field label of page one is not displayed.");
				}
			} catch (Throwable t) {
				verificationFailedMessage("The first field label of page one is not displayed.");
			}

			// validate the second field label of page one
			try {
				String pageFieldLabel2 = "//label[contains(text(),'" + pageFieldName2 + "')]";
				String pageFieldLabel2_actual = (driver.findElement(By.xpath(pageFieldLabel2)).getText()).trim();

				if (pageFieldLabel2_actual.equals(pageFieldName2 + ":")) {
					successMessage("The second field label of page one is displayed successfully.");
				} else {
					verificationFailedMessage("The second field label of page one is not displayed.");
				}
			} catch (Throwable t) {
				verificationFailedMessage("The second field label of page one is not displayed.");
			}

			// validate the details of the first field of page one
			try {
				String pageFirstField1 = "//span[contains(text(),'" + data.get("first_page_field1") + "')]";
				String pageFirstField1_actual = (driver.findElement(By.xpath(pageFirstField1)).getText()).trim();

				if (pageFirstField1_actual.equals(data.get("first_page_field1"))) {
					successMessage("The details of the first field of page one is displayed successfully.");
				} else {
					verificationFailedMessage("The details of the first field of page one is not displayed.");
				}
			} catch (Throwable t) {
				verificationFailedMessage("The details of the first field of page one is not displayed.");
			}

			// validate the details of the second field of page one
			try {
				String pageSecondField1 = "//span[contains(text(),'" + "456" + "')]";
				String pageSecondField1_actual = (driver.findElement(By.xpath(pageSecondField1)).getText()).trim();

				if (pageSecondField1_actual.equals("456")) {
					successMessage("The details of the second field of page one is displayed successfully.");
				} else {
					verificationFailedMessage("The details of the second field of page one is not displayed.");
				}
			} catch (Throwable t) {
				verificationFailedMessage("The details of the second field of page one is not displayed.");
			}

			// click on the second page name tab
			String page2 = "//span[contains(text(),'" + pageName2 + "')]";
			driver.findElement(By.xpath(page2)).click();
			consoleMessage("Clicked on the second page name tab.");

			// scroll down to bottom
			scrollBottom();

			// validate the first field label of page second
			try {
				String pageFieldLabel3 = "//label[contains(text(),'" + pageFieldName3 + "')]";
				String pageFieldLabel3_actual = (driver.findElement(By.xpath(pageFieldLabel3)).getText()).trim();

				if (pageFieldLabel3_actual.equals(pageFieldName3 + ":")) {
					successMessage("The first field label of page second is displayed successfully.");
				} else {
					verificationFailedMessage("The first field label of page second is not displayed.");
				}
			} catch (Throwable t) {
				verificationFailedMessage("The first field label of page second is not displayed.");
			}

			// validate the second field label of page second
			try {
				String pageFieldLabel4 = "//label[contains(text(),'" + pageFieldName4 + "')]";
				String pageFieldLabel4_actual = (driver.findElement(By.xpath(pageFieldLabel4)).getText()).trim();

				if (pageFieldLabel4_actual.equals(pageFieldName4 + ":")) {
					successMessage("The second field label of page second is displayed successfully.");
				} else {
					verificationFailedMessage("The second field label of page second is not displayed.");
				}
			} catch (Throwable t) {
				verificationFailedMessage("The second field label of page second is not displayed.");
			}

			// validate the details of the first field of page second
			try {
				String pageFirstField3 = "//span[contains(text(),'" + data.get("second_page_field1") + "')]";
				String pageFirstField3_actual = (driver.findElement(By.xpath(pageFirstField3)).getText()).trim();

				if (pageFirstField3_actual.equals(data.get("second_page_field1"))) {
					successMessage("The details of the first field of page second is displayed successfully.");
				} else {
					verificationFailedMessage("The details of the first field of page second is not displayed.");
				}
			} catch (Throwable t) {
				verificationFailedMessage("The details of the first field of page second is not displayed.");
			}

			// validate the details of the second field of page second
			try {
				String pageSecondField4 = "//span[contains(text(),'" + "789" + "')]";
				String pageSecondField4_actual = (driver.findElement(By.xpath(pageSecondField4)).getText()).trim();

				if (pageSecondField4_actual.equals("789")) {
					successMessage("The details of the second field of page one is displayed successfully.");
				} else {
					verificationFailedMessage("The details of the second field of page second is not displayed.");
				}
			} catch (Throwable t) {
				verificationFailedMessage("The details of the second field of page second is not displayed.");
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

		// ADD THE DETAILS IN THE FIELDS AND PAGES FROM THE PORTFOLIO SUMMARY DASHBOARD
		title("ADD THE DETAILS IN THE FIELDS AND PAGES FROM THE PORTFOLIO SUMMARY DASHBOARD");

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

			// wait for the element
			Thread.sleep(10000);

			// click on the custom form
			String customForm1 = "//td[text()='" + name + "']";
			driver.findElement(By.xpath(customForm1)).click();
			consoleMessage("Clicked on the custom form.");

			// wait for the element
			Thread.sleep(5000);

			// click on the add button
			click("customform_portfoliodashboard_addbtn1_XPATH");

			// wait for the element
			Thread.sleep(5000);

			// scroll to bottom
			scrollBottom();

			// enter the details in the first field
			String firstField = "//input[@id='" + fieldName1 + "TEXT']";
			driver.findElement(By.xpath(firstField)).sendKeys(fieldDetail1);
			consoleMessage("Entered the details in the first field.");

			// enter the details in the second field
			String secondField = "//input[@id='" + fieldName2 + "NUMBER']";
			driver.findElement(By.xpath(secondField)).sendKeys("111");
			consoleMessage("Entered the details in the second field.");

			// wait for the element
			Thread.sleep(5000);

			// ADD THE DETAILS IN THE FIELDS OF THE FIRST PAGE TAB
			title("ADD THE DETAILS IN THE FIELDS OF THE FIRST PAGE TAB");

			// click on the first page name tab
			String pageTab1 = "//span[text()='" + pageName1 + "']";
			driver.findElement(By.xpath(pageTab1)).click();
			consoleMessage("Clicked on the first page name tab.");

			// enter the details in the first field
			String firstPageField = "//input[@id='" + pageFieldName1 + "TEXT']";
			driver.findElement(By.xpath(firstPageField)).sendKeys(pageFieldDetail1);
			consoleMessage("Entered the details in the first field.");

			// enter the details in the second field
			String secondPageField = "//input[@id='" + pageFieldName2 + "NUMBER']";
			driver.findElement(By.xpath(secondPageField)).sendKeys("222");
			consoleMessage("Entered the details in the second field.");

			// wait for the element
			Thread.sleep(5000);

			// ADD THE DETAILS IN THE FIELDS OF THE SECOND PAGE TAB
			title("ADD THE DETAILS IN THE FIELDS OF THE SECOND PAGE TAB");

			// click on the second page name tab
			String pageTab2 = "//span[text()='" + pageName2 + "']";
			driver.findElement(By.xpath(pageTab2)).click();
			consoleMessage("Clicked on the second page name tab.");

			// enter the details in the first field
			String thirdPageField = "//input[@id='" + pageFieldName3 + "TEXT']";
			driver.findElement(By.xpath(thirdPageField)).sendKeys(pageFieldDetail3);
			consoleMessage("Entered the details in the first field.");

			// enter the details in the second field
			String fourthPageField = "//input[@id='" + pageFieldName4 + "NUMBER']";
			driver.findElement(By.xpath(fourthPageField)).sendKeys("333");
			consoleMessage("Entered the details in the second field.");

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
				String secondField1 = "//span[contains(text(),'" + "111" + "')]";
				String secondField1_actual = (driver.findElement(By.xpath(secondField1)).getText()).trim();

				if (secondField1_actual.equals("111")) {
					successMessage("The details of the second field is displayed successfully.");
				} else {
					verificationFailedMessage("The details of the second field is not displayed.");
				}
			} catch (Throwable t) {
				verificationFailedMessage("The details of the second field is not displayed.");
			}

			// validate the details of the first field of the first page
			try {
				String firstField1 = "//span[contains(text(),'" + pageFieldDetail1 + "')]";
				String firstField1_actual = (driver.findElement(By.xpath(firstField1)).getText()).trim();

				if (firstField1_actual.equals(pageFieldDetail1)) {
					successMessage("The details of the first field of the first page is displayed successfully.");
				} else {
					verificationFailedMessage("The details of the first field of the first page is not displayed.");
				}
			} catch (Throwable t) {
				verificationFailedMessage("The details of the first field of the first page is not displayed.");
			}

			// validate the details of the second field of the first page
			try {
				String secondField1 = "//span[contains(text(),'" + "222" + "')]";
				String secondField1_actual = (driver.findElement(By.xpath(secondField1)).getText()).trim();

				if (secondField1_actual.equals("222")) {
					successMessage("The details of the second field of the first page is displayed successfully.");
				} else {
					verificationFailedMessage("The details of the second field of the first page is not displayed.");
				}
			} catch (Throwable t) {
				verificationFailedMessage("The details of the second field is of the first page not displayed.");
			}

			// validate the details of the first field of the second page
			try {
				String firstField1 = "//span[contains(text(),'" + pageFieldDetail3 + "')]";
				String firstField1_actual = (driver.findElement(By.xpath(firstField1)).getText()).trim();

				if (firstField1_actual.equals(pageFieldDetail3)) {
					successMessage("The details of the first field of the second page is displayed successfully.");
				} else {
					verificationFailedMessage("The details of the first field of the second page is not displayed.");
				}
			} catch (Throwable t) {
				verificationFailedMessage("The details of the first field of the second page is not displayed.");
			}

			// validate the details of the second field of the second page
			try {
				String secondField1 = "//span[contains(text(),'" + "333" + "')]";
				String secondField1_actual = (driver.findElement(By.xpath(secondField1)).getText()).trim();

				if (secondField1_actual.equals("333")) {
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

		// wait for the element
		explicitWait("propertylist_title_XPATH");

		// verify the property list
		switchVerification("propertylist_title_XPATH", "Property List", "The property list is not displayed.");

		// VALIDATE ADDED DETAILS OF THE FIELDS DISPLAYED IN THE PROPERTY SUMMARY
		// DASHBOARD
		title("VALIDATE ADDED DETAILS OF THE FIELDS DISPLAYED IN THE PROPERTY SUMMARY DASHBOARD");

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

			// wait for the element
			Thread.sleep(10000);

			// click on the custom form
			String customForm1 = "//td[text()='" + name + "']";
			driver.findElement(By.xpath(customForm1)).click();
			consoleMessage("Clicked on the custom form.");

			// wait for the element
			Thread.sleep(5000);

			// validate the property name is displayed or not
			switchVerificationFailed("customform_property1_title_XPATH", "[DND] AAAA Risk Test Prop 01 - 01",
					"The [DND] AAAA Risk Test Prop 01 - 01 is not displayed.");

			// validate the field 1
			try {
				String field11 = "//b[text()='" + fieldName1 + "']";
				String field11_actual = (driver.findElement(By.xpath(field11)).getText()).trim();

				if (field11_actual.equals(fieldName1)) {
					successMessage("The respective field 1 is displayed successfully.");
				} else {
					verificationFailedMessage("The repsective field 1 is not displayed.");
				}
			} catch (Throwable t) {
				verificationFailedMessage("The repsective field 1 is not displayed.");
			}

			// validate the field 2
			try {
				String field22 = "//b[text()='" + fieldName2 + "']";
				String field22_actual = (driver.findElement(By.xpath(field22)).getText()).trim();

				if (field22_actual.equals(fieldName2)) {
					successMessage("The respective field 2 is displayed successfully.");
				} else {
					verificationFailedMessage("The repsective field 2 is not displayed.");
				}
			} catch (Throwable t) {
				verificationFailedMessage("The repsective field 2 is not displayed.");
			}

			// validate the field 1 of page 1
			try {
				String field33 = "//b[text()='" + pageFieldName1 + "']";
				String field33_actual = (driver.findElement(By.xpath(field33)).getText()).trim();

				if (field33_actual.equals(pageFieldName1)) {

					successMessage("The respective field 1 of page 1 is displayed successfully.");
				} else {
					verificationFailedMessage("The repsective field 1 of page 1 is not displayed.");
				}
			} catch (Throwable t) {
				verificationFailedMessage("The repsective field 1 of page 1 is not displayed.");
			}

			// validate the field 2 of page 1
			try {
				String field44 = "//b[text()='" + pageFieldName2 + "']";
				String field44_actual = (driver.findElement(By.xpath(field44)).getText()).trim();

				if (field44_actual.equals(pageFieldName2)) {

					successMessage("The respective field 2 of page 1 is displayed successfully.");
				} else {
					verificationFailedMessage("The repsective field 2 of page 1 is not displayed.");
				}
			} catch (Throwable t) {
				verificationFailedMessage("The repsective field 2 of page 1 is not displayed.");
			}

			// validate the field 1 of page 2
			try {
				String field55 = "//b[text()='" + pageFieldName3 + "']";
				String field55_actual = (driver.findElement(By.xpath(field55)).getText()).trim();

				if (field55_actual.equals(pageFieldName3)) {

					successMessage("The respective field 1 of page 2 is displayed successfully.");
				} else {
					verificationFailedMessage("The repsective field 1 of page 2 is not displayed.");
				}
			} catch (Throwable t) {
				verificationFailedMessage("The repsective field 1 of page 2 is not displayed.");
			}

			// validate the field 2 of page 2
			try {
				String field66 = "//b[text()='" + pageFieldName4 + "']";
				String field66_actual = (driver.findElement(By.xpath(field66)).getText()).trim();

				if (field66_actual.equals(pageFieldName4)) {

					successMessage("The respective field 2 of page 2 is displayed successfully.");
				} else {
					verificationFailedMessage("The repsective field 2 of page 2 is not displayed.");
				}
			} catch (Throwable t) {
				verificationFailedMessage("The repsective field 2 of page 2 is not displayed.");
			}

			// validate the details of the field 1
			try {
				String field11 = "//span[text()='" + fieldDetail1 + "']";
				String field11_actual = (driver.findElement(By.xpath(field11)).getText()).trim();

				if (field11_actual.equals(fieldDetail1)) {
					successMessage("The respective field 1 details is displayed successfully.");
				} else {
					verificationFailedMessage("The repsective field 1 details is not displayed.");
				}
			} catch (Throwable t) {
				verificationFailedMessage("The repsective field 1 details is not displayed.");
			}

			// validate the details of the field 2
			try {
				String field22 = "//span[text()='" + "111" + "']";
				String field22_actual = (driver.findElement(By.xpath(field22)).getText()).trim();

				if (field22_actual.equals("111")) {
					successMessage("The respective field 2 details is displayed successfully.");
				} else {
					verificationFailedMessage("The repsective field 2 details is not displayed.");
				}
			} catch (Throwable t) {
				verificationFailedMessage("The repsective field 2 details is not displayed.");
			}

			// validate the details of the field 1 of page 1
			try {
				String field33 = "//span[text()='" + pageFieldDetail1 + "']";
				String field33_actual = (driver.findElement(By.xpath(field33)).getText()).trim();

				if (field33_actual.equals(pageFieldName1)) {

					successMessage("The respective field 1 of page 1 details is displayed successfully.");
				} else {
					verificationFailedMessage("The repsective field 1 of page 1 details is not displayed.");
				}
			} catch (Throwable t) {
				verificationFailedMessage("The repsective field 1 of page 1 details is not displayed.");
			}

			// validate the details of the field 2 of page 1
			try {
				String field44 = "//span[text()='" + "222" + "']";
				String field44_actual = (driver.findElement(By.xpath(field44)).getText()).trim();

				if (field44_actual.equals("222")) {

					successMessage("The respective field 2 of page 1 details is displayed successfully.");
				} else {
					verificationFailedMessage("The repsective field 2 of page 1 details is not displayed.");
				}
			} catch (Throwable t) {
				verificationFailedMessage("The repsective field 2 of page 1 details is not displayed.");
			}

			// validate the details of the field 1 of page 2
			try {
				String field55 = "//span[text()='" + pageFieldDetail3 + "']";
				String field55_actual = (driver.findElement(By.xpath(field55)).getText()).trim();

				if (field55_actual.equals(pageFieldName3)) {

					successMessage("The respective field 1 of page 2 details is displayed successfully.");
				} else {
					verificationFailedMessage("The repsective field 1 of page 2 details is not displayed.");
				}
			} catch (Throwable t) {
				verificationFailedMessage("The repsective field 1 of page 2 details is not displayed.");
			}

			// validate the details of the field 2 of page 2
			try {
				String field66 = "//span[text()='" + "333" + "']";
				String field66_actual = (driver.findElement(By.xpath(field66)).getText()).trim();

				if (field66_actual.equals("333")) {

					successMessage("The respective field 2 of page 2 details is displayed successfully.");
				} else {
					verificationFailedMessage("The repsective field 2 of page 2 details is not displayed.");
				}
			} catch (Throwable t) {
				verificationFailedMessage("The repsective field 2 of page 2 details is not displayed.");
			}

			// wait for the element
			Thread.sleep(10000);

			// click on the custom form detail
			String fieldDetail = "//span[text()='" + fieldDetail1 + "']";
			driver.findElement(By.xpath(fieldDetail)).click();
			consoleMessage("Clicked on the custom form detail.");

			// validate the property name is displayed or not
			switchVerificationFailed("customform_property1_title_XPATH", "[DND] AAAA Risk Test Prop 01 - 01",
					"The [DND] AAAA Risk Test Prop 01 - 01 is not displayed.");

			// scrolldown to bottom
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
				String secondField1 = "//span[contains(text(),'" + "111" + "')]";
				String secondField1_actual = (driver.findElement(By.xpath(secondField1)).getText()).trim();

				if (secondField1_actual.equals("111")) {
					successMessage("The details of the second field is displayed successfully.");
				} else {
					verificationFailedMessage("The details of the second field is not displayed.");
				}
			} catch (Throwable t) {
				verificationFailedMessage("The details of the second field is not displayed.");
			}

			// click on the first page name tab
			String page1 = "//span[contains(text(),'" + pageName1 + "')]";
			driver.findElement(By.xpath(page1)).click();
			consoleMessage("Clicked on the first page name tab.");

			// scroll down to bottom
			scrollBottom();

			// validate the first field label of page one
			try {
				String pageFieldLabel1 = "//label[contains(text(),'" + pageFieldName1 + "')]";
				String pageFieldLabel1_actual = (driver.findElement(By.xpath(pageFieldLabel1)).getText()).trim();

				if (pageFieldLabel1_actual.equals(pageFieldName1 + ":")) {
					successMessage("The first field label of page one is displayed successfully.");
				} else {
					verificationFailedMessage("The first field label of page one is not displayed.");
				}
			} catch (Throwable t) {
				verificationFailedMessage("The first field label of page one is not displayed.");
			}

			// validate the second field label of page one
			try {
				String pageFieldLabel2 = "//label[contains(text(),'" + pageFieldName2 + "')]";
				String pageFieldLabel2_actual = (driver.findElement(By.xpath(pageFieldLabel2)).getText()).trim();

				if (pageFieldLabel2_actual.equals(pageFieldName2 + ":")) {
					successMessage("The second field label of page one is displayed successfully.");
				} else {
					verificationFailedMessage("The second field label of page one is not displayed.");
				}
			} catch (Throwable t) {
				verificationFailedMessage("The second field label of page one is not displayed.");
			}

			// validate the details of the first field of page one
			try {
				String pageFirstField1 = "//span[contains(text(),'" + pageFieldDetail1 + "')]";
				String pageFirstField1_actual = (driver.findElement(By.xpath(pageFirstField1)).getText()).trim();

				if (pageFirstField1_actual.equals(pageFieldDetail1)) {
					successMessage("The details of the first field of page one is displayed successfully.");
				} else {
					verificationFailedMessage("The details of the first field of page one is not displayed.");
				}
			} catch (Throwable t) {
				verificationFailedMessage("The details of the first field of page one is not displayed.");
			}

			// validate the details of the second field of page one
			try {
				String pageSecondField1 = "//span[contains(text(),'" + "222" + "')]";
				String pageSecondField1_actual = (driver.findElement(By.xpath(pageSecondField1)).getText()).trim();

				if (pageSecondField1_actual.equals("222")) {
					successMessage("The details of the second field of page one is displayed successfully.");
				} else {
					verificationFailedMessage("The details of the second field of page one is not displayed.");
				}
			} catch (Throwable t) {
				verificationFailedMessage("The details of the second field of page one is not displayed.");
			}

			// click on the second page name tab
			String page2 = "//span[contains(text(),'" + pageName2 + "')]";
			driver.findElement(By.xpath(page2)).click();
			consoleMessage("Clicked on the second page name tab.");

			// scroll down to bottom
			scrollBottom();

			// validate the first field label of page second
			try {
				String pageFieldLabel3 = "//label[contains(text(),'" + pageFieldName3 + "')]";
				String pageFieldLabel3_actual = (driver.findElement(By.xpath(pageFieldLabel3)).getText()).trim();

				if (pageFieldLabel3_actual.equals(pageFieldName3 + ":")) {
					successMessage("The first field label of page second is displayed successfully.");
				} else {
					verificationFailedMessage("The first field label of page second is not displayed.");
				}
			} catch (Throwable t) {
				verificationFailedMessage("The first field label of page second is not displayed.");
			}

			// validate the second field label of page second
			try {
				String pageFieldLabel4 = "//label[contains(text(),'" + pageFieldName4 + "')]";
				String pageFieldLabel4_actual = (driver.findElement(By.xpath(pageFieldLabel4)).getText()).trim();

				if (pageFieldLabel4_actual.equals(pageFieldName4 + ":")) {
					successMessage("The second field label of page second is displayed successfully.");
				} else {
					verificationFailedMessage("The second field label of page second is not displayed.");
				}
			} catch (Throwable t) {
				verificationFailedMessage("The second field label of page second is not displayed.");
			}

			// validate the details of the first field of page second
			try {
				String pageFirstField3 = "//span[contains(text(),'" + pageFieldDetail3 + "')]";
				String pageFirstField3_actual = (driver.findElement(By.xpath(pageFirstField3)).getText()).trim();

				if (pageFirstField3_actual.equals(pageFieldDetail3)) {
					successMessage("The details of the first field of page second is displayed successfully.");
				} else {
					verificationFailedMessage("The details of the first field of page second is not displayed.");
				}
			} catch (Throwable t) {
				verificationFailedMessage("The details of the first field of page second is not displayed.");
			}

			// validate the details of the second field of page second
			try {
				String pageSecondField4 = "//span[contains(text(),'" + "333" + "')]";
				String pageSecondField4_actual = (driver.findElement(By.xpath(pageSecondField4)).getText()).trim();

				if (pageSecondField4_actual.equals("333")) {
					successMessage("The details of the second field of page one is displayed successfully.");
				} else {
					verificationFailedMessage("The details of the second field of page second is not displayed.");
				}
			} catch (Throwable t) {
				verificationFailedMessage("The details of the second field of page second is not displayed.");
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
