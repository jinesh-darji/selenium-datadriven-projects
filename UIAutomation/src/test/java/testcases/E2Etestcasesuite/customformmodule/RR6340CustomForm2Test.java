package testcases.E2Etestcasesuite.customformmodule;

import java.io.IOException;
import java.time.LocalDate;
import java.util.Hashtable;

import org.apache.commons.lang3.RandomStringUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;

import base.TestBase;
import utilities.TestUtil;

public class RR6340CustomForm2Test extends TestBase {

	@Test(dataProviderClass = TestUtil.class, dataProvider = "dp")
	public void rR6340CustomForm2Test(Hashtable<String, String> data) throws IOException, InterruptedException {

		execution(data, "rR6340CustomForm2Test");

		// ADD THE NEW FIELDS IN THE CUSTOM RECORDS AND VALIDATE IN THE PORTFOLIO
		// DASHBOARD AND PROPERTY SUMMARY DASHBOARD - MULTIPLE TYPE
		title("ADD THE NEW FIELDS IN THE CUSTOM RECORDS AND VALIDATE IN THE PORTFOLIO DASHBOARD AND PROPERTY SUMMARY DASHBOARD - MULTIPLE TYPE");

		// refresh the page
		driver.navigate().refresh();
		Thread.sleep(5000);
		driver.navigate().refresh();

		String fieldName1 = RandomStringUtils.randomAlphabetic(8);
		String fieldName2 = RandomStringUtils.randomAlphabetic(8);
		String fieldName3 = RandomStringUtils.randomAlphabetic(8);
		String fieldName4 = RandomStringUtils.randomAlphabetic(8);

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

			// click on the add button
			click("customform_addfield_addbtn_XPATH");

			// wait for the element
			explicitWaitClickable("closetoastmsg_CSS");

			// click on the toaster close button
			click("closetoastmsg_CSS");

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

			// wait for the element
			Thread.sleep(5000);

			// click on the add field button
			click("customform_addfieldbtn_XPATH");

			// enter field name
			type("customform_addfield_nametxt_XPATH", fieldName3);

			// select the option from the type dropdown
			select("customform_addfield_typedd_XPATH", data.get("fieldtype_3"));

			// click on the unique identifier checkbox
			click("customform_addfield_uniqueidentifierckbx_XPATH");

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

			// wait for the element
			Thread.sleep(5000);

			// click on the add field button
			click("customform_addfieldbtn_XPATH");

			// enter field name
			type("customform_addfield_nametxt_XPATH", fieldName4);

			// select the option from the type dropdown
			select("customform_addfield_typedd_XPATH", data.get("fieldtype_4"));

			// wait for the element
			Thread.sleep(3000);

			// click on the dropdown field
			click("customform_addfield_dropdowndd_XPATH");

			// click on the clear button
			click("customform_addfield_dropdowndd_clearbtn_XPATH");

			// enter the Asbestos Material in the search field
			type("customform_addfield_dropdowndd_searchtxt_XPATH", data.get("dd_option"));

			// click on the searched result
			click("customform_addfield_dropdowndd_searchedresult_XPATH");

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

		// VALIDATE THE NEWLY CREATED CUSTOM REPORT AND FIELDS IN THE PORTFOLIO
		// DASHBOARD
		title("VALIDATE THE NEWLY CREATED CUSTOM REPORT AND FIELDS IN THE PORTFOLIO DASHBOARD");

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

			// validate the field 3
			try {
				String field33 = "//th[text()='" + fieldName3 + "']";
				String field33_actual = (driver.findElement(By.xpath(field33)).getText()).trim();

				if (field33_actual.equals(fieldName3)) {

					verificationFailedMessage("The repsective field is displayed without access.");

				} else {
					successMessage("The respective field is not displayed as expected.");
				}
			} catch (Throwable t) {
				successMessage("The respective field is not displayed as expected.");
			}

			// validate the field 4
			try {
				String field44 = "//th[text()='" + fieldName4 + "']";
				String field44_actual = (driver.findElement(By.xpath(field44)).getText()).trim();

				if (field44_actual.equals(fieldName4)) {

					verificationFailedMessage("The repsective field is displayed without access.");

				} else {
					successMessage("The respective field is not displayed as expected.");
				}
			} catch (Throwable t) {
				successMessage("The respective field is not displayed as expected.");
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

		// VALIDATE THE NEWLY CREATED CUSTOM REPORT AND FIELDS IN THE PROPERTY SUMMARY
		// DASHBOARD
		title("VALIDATE THE NEWLY CREATED CUSTOM REPORT AND FIELDS IN THE PROPERTY SUMMARY DASHBOARD");

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

			// scroll to bottom
			scrollBottom();

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

			// validate the third field label
			try {
				String fieldLabel3 = "//b[contains(text(),'" + fieldName3 + "')]";
				String fieldLabel3_actual = (driver.findElement(By.xpath(fieldLabel3)).getText()).trim();

				if (fieldLabel3_actual.equals(fieldName3)) {
					verificationFailedMessage("The third field label is displayed without permission.");
				} else {
					successMessage("The third field label is not displayed as expected.");
				}
			} catch (Throwable t) {
				successMessage("The third field label is not displayed as expected.");
			}

			// validate the fourth field label
			try {
				String fieldLabel4 = "//b[contains(text(),'" + fieldName4 + "')]";
				String fieldLabel4_actual = (driver.findElement(By.xpath(fieldLabel4)).getText()).trim();

				if (fieldLabel4_actual.equals(fieldName4)) {
					verificationFailedMessage("The fourth field label is displayed without permission.");
				} else {
					successMessage("The fourth field label is not displayed as expected.");
				}
			} catch (Throwable t) {
				successMessage("The fourth field label is not displayed as expected.");
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

		// ADD THE DETAILS IN THE FIELDS FROM THE PROPERTY SUMMARY DASHBOARD
		title("ADD THE DETAILS IN THE FIELDS FROM THE PROPERTY SUMMARY DASHBOARD");

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

			// enter the details in the third field
			String thirdField = "//input[@id='" + fieldName3 + "DATE']";
			driver.findElement(By.xpath(thirdField)).click();
			consoleMessage("Entered the details in the third field.");

			// click on the today button
			click("customform_portfoliodashboard_todaybtn_XPATH");

			// enter the details in the third field
			String fourthField = "//select[@id='" + fieldName4 + "DROPBOX']";
			WebElement dropdown = driver.findElement(By.xpath(fourthField));
			Select select = new Select(dropdown);
			select.selectByVisibleText(data.get("fourth_field"));
			consoleMessage("Select the details in the fourth field.");

			// click on the save button
			click("customform_portfoliodashboard_fields_savebtn_XPATH");

			// scrolldown to bottom
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

			// validate the details of the third field
			try {
				LocalDate today = LocalDate.now();
				String today_string = today.toString();

				String thirdField1 = "//span[contains(text(),'" + today_string + "')]";
				String thirdField1_actual = (driver.findElement(By.xpath(thirdField1)).getText()).trim();

				if (thirdField1_actual.equals(today_string)) {
					verificationFailedMessage("The details of the third field is displayed without permission.");
				} else {
					successMessage("The details of the third field is not displayed as expected.");
				}
			} catch (Throwable t) {
				successMessage("The details of the third field is not displayed as expected.");
			}

			// validate the details of the fourth field
			try {
				String fourthField1 = "//span[contains(text(),'" + data.get("fourth_field") + "')]";
				String fourthField1_actual = (driver.findElement(By.xpath(fourthField1)).getText()).trim();

				if (fourthField1_actual.equals(data.get("fourth_field"))) {
					verificationFailedMessage("The details of the fourth field is displayed without permission.");
				} else {
					successMessage("The details of the fourth field is not displayed as expected.");
				}
			} catch (Throwable t) {
				successMessage("The details of the fourth field is not displayed as expected.");
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

			// validate the field 3
			try {
				String field33 = "//th[text()='" + fieldName3 + "']";
				String field33_actual = (driver.findElement(By.xpath(field33)).getText()).trim();

				if (field33_actual.equals(fieldName3)) {

					verificationFailedMessage("The repsective field is displayed without access.");

				} else {
					successMessage("The respective field is not displayed as expected.");
				}
			} catch (Throwable t) {
				successMessage("The respective field is not displayed as expected.");
			}

			// validate the field 4
			try {
				String field44 = "//th[text()='" + fieldName4 + "']";
				String field44_actual = (driver.findElement(By.xpath(field44)).getText()).trim();

				if (field44_actual.equals(fieldName4)) {

					verificationFailedMessage("The repsective field is displayed without access.");

				} else {
					successMessage("The respective field is not displayed as expected.");
				}
			} catch (Throwable t) {
				successMessage("The respective field is not displayed as expected.");
			}

			// click on the property one
			click("customform_portfoliodashboard_propertyname_XPATH");

			// scrolldown to bottom
			scrollBottom();

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

			// validate the third field label
			try {
				String fieldLabel3 = "//label[contains(text(),'" + fieldName3 + "')]";
				String fieldLabel3_actual = (driver.findElement(By.xpath(fieldLabel3)).getText()).trim();

				if (fieldLabel3_actual.equals(fieldName3 + ":")) {
					successMessage("The third field label is displayed successfully.");
				} else {
					verificationFailedMessage("The third field label is not displayed.");
				}
			} catch (Throwable t) {
				verificationFailedMessage("The third field label is not displayed.");
			}

			// validate the forth field label
			try {
				String fieldLabel4 = "//label[contains(text(),'" + fieldName4 + "')]";
				String fieldLabel4_actual = (driver.findElement(By.xpath(fieldLabel4)).getText()).trim();

				if (fieldLabel4_actual.equals(fieldName4 + ":")) {
					successMessage("The forth field label is displayed successfully.");
				} else {
					verificationFailedMessage("The forth field label is not displayed.");
				}
			} catch (Throwable t) {
				verificationFailedMessage("The forth field label is not displayed.");
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

			// validate the details of the third field
			try {
				LocalDate today = LocalDate.now();
				String today_string = today.toString();

				String thirdField1 = "//span[contains(text(),'" + today_string + "')]";
				String thirdField1_actual = (driver.findElement(By.xpath(thirdField1)).getText()).trim();

				if (thirdField1_actual.equals(today_string)) {
					successMessage("The details of the third field is displayed successfully.");
				} else {
					verificationFailedMessage("The details of the third field is not displayed.");
				}
			} catch (Throwable t) {
				verificationFailedMessage("The details of the third field is not displayed.");
			}

			// validate the details of the fourth field
			try {
				String fourthField1 = "//span[contains(text(),'" + data.get("fourth_field") + "')]";
				String fourthField1_actual = (driver.findElement(By.xpath(fourthField1)).getText()).trim();

				if (fourthField1_actual.equals(data.get("fourth_field"))) {
					successMessage("The details of the fourth field is displayed successfully.");
				} else {
					verificationFailedMessage("The details of the fourth field is not displayed.");
				}
			} catch (Throwable t) {
				verificationFailedMessage("The details of the fourth field is not displayed.");
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

		// UPDATE THE DETAILS OF THE FIELDS FROM THE PORTFOLIO SUMMARY DASHBOARD
		title("UPDATE THE DETAILS OF THE FIELDS FROM THE PORTFOLIO SUMMARY DASHBOARD");

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

			// click on the property one
			click("customform_portfoliodashboard_propertyname_XPATH");

			// scrolldown to bottom
			scrollBottom();

			// click on the edit field button
			click("customform_portfoliodashboard_editfieldbtn_XPATH");

			// enter the details in the first field
			String firstField2 = "//input[@id='" + fieldName1 + "TEXT']";
			driver.findElement(By.xpath(firstField2)).clear();
			driver.findElement(By.xpath(firstField2)).sendKeys(data.get("update_first_field"));
			consoleMessage("Entered the details in the first field.");

			// enter the details in the second field
			String secondField2 = "//input[@id='" + fieldName2 + "NUMBER']";
			driver.findElement(By.xpath(secondField2)).clear();
			driver.findElement(By.xpath(secondField2)).sendKeys("456");
			consoleMessage("Entered the details in the second field.");

			// enter the details in the third field
			String thirdField2 = "//input[@id='" + fieldName3 + "DATE']";
			driver.findElement(By.xpath(thirdField2)).click();
			consoleMessage("Entered the details in the third field.");

			// click on the clear button
			click("customform_portfoliodashboard_clearbtn_XPATH");

			// enter the details in the third field
			String fourthField2 = "//select[@id='" + fieldName4 + "DROPBOX']";
			WebElement dropdown2 = driver.findElement(By.xpath(fourthField2));
			Select select2 = new Select(dropdown2);
			select2.selectByVisibleText(data.get("update_fourth_field"));
			consoleMessage("Selected the details in the fourth field.");

			// click on the save button
			click("customform_portfoliodashboard_fields_savebtn_XPATH");

			// scrolldown to bottom
			scrollBottom();

			// wait for the element
			Thread.sleep(5000);

			// validate the details of the first field
			try {
				String firstField11 = "//span[contains(text(),'" + data.get("update_first_field") + "')]";
				String firstField11_actual = (driver.findElement(By.xpath(firstField11)).getText()).trim();

				if (firstField11_actual.equals(data.get("update_first_field"))) {
					successMessage("The details of the first field is displayed successfully.");
				} else {
					verificationFailedMessage("The details of the first field is not displayed.");
				}
			} catch (Throwable t) {
				verificationFailedMessage("The details of the first field is not displayed.");
			}

			// validate the details of the second field
			try {
				String secondField11 = "//span[contains(text(),'" + "456" + "')]";
				String secondField11_actual = (driver.findElement(By.xpath(secondField11)).getText()).trim();

				if (secondField11_actual.equals("456")) {
					successMessage("The details of the second field is displayed successfully.");
				} else {
					verificationFailedMessage("The details of the second field is not displayed.");
				}
			} catch (Throwable t) {
				verificationFailedMessage("The details of the second field is not displayed.");
			}

			// validate the details of the third field
			try {
				LocalDate today = LocalDate.now();
				String today_string = today.toString();

				String thirdField11 = "//span[contains(text(),'" + today_string + "')]";
				String thirdField11_actual = (driver.findElement(By.xpath(thirdField11)).getText()).trim();

				if (thirdField11_actual.equals(today_string)) {

					verificationFailedMessage(
							"The details of the third field is displayed, However date is cleared from the date field.");

				} else {

					successMessage("The details of the third field is not displayed as expected.");

				}
			} catch (Throwable t) {
				successMessage("The details of the third field is not displayed as expected.");
			}

			// validate the details of the fourth field
			try {
				String fourthField11 = "//span[contains(text(),'" + data.get("update_fourth_field") + "')]";
				String fourthField11_actual = (driver.findElement(By.xpath(fourthField11)).getText()).trim();

				if (fourthField11_actual.equals(data.get("update_fourth_field"))) {
					successMessage("The details of the fourth field is displayed successfully.");
				} else {
					verificationFailedMessage("The details of the fourth field is not displayed.");
				}
			} catch (Throwable t) {
				verificationFailedMessage("The details of the fourth field is not displayed.");
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

		// VALIDATE THE UPDATED FIELDS DETAIL FROM THE PROPERTY SUMMARY DASHBOARD
		title("VALIDATE THE UPDATED FIELDS DETAIL FROM THE PROPERTY SUMMARY DASHBOARD");

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

			// scrolldown to bottom
			scrollBottom();

			// wait for the element
			Thread.sleep(5000);

			// validate the details of the first field
			try {
				String updateFirstField1 = "//span[contains(text(),'" + data.get("update_first_field") + "')]";
				String updateFirstField1_actual = (driver.findElement(By.xpath(updateFirstField1)).getText()).trim();

				if (updateFirstField1_actual.equals(data.get("update_first_field"))) {
					successMessage("The details of the first field is displayed successfully.");
				} else {
					verificationFailedMessage("The details of the first field is not displayed.");
				}
			} catch (Throwable t) {
				verificationFailedMessage("The details of the first field is not displayed.");
			}

			// validate the details of the second field
			try {
				String updateSecondField1 = "//span[contains(text(),'" + "456" + "')]";
				String updateSecondField1_actual = (driver.findElement(By.xpath(updateSecondField1)).getText()).trim();

				if (updateSecondField1_actual.equals("456")) {
					successMessage("The details of the second field is displayed successfully.");
				} else {
					verificationFailedMessage("The details of the second field is not displayed.");
				}
			} catch (Throwable t) {
				verificationFailedMessage("The details of the second field is not displayed.");
			}

			// validate the details of the third field
			try {
				LocalDate today = LocalDate.now();
				String today_string = today.toString();

				String updateThirdField1 = "//span[contains(text(),'" + today_string + "')]";
				String updateThirdField1_actual = (driver.findElement(By.xpath(updateThirdField1)).getText()).trim();

				if (updateThirdField1_actual.equals(today_string)) {
					verificationFailedMessage("The details of the third field is displayed without permission.");
				} else {
					successMessage("The details of the third field is not displayed as expected.");
				}
			} catch (Throwable t) {
				successMessage("The details of the third field is not displayed as expected.");
			}

			// validate the details of the fourth field
			try {
				String updateFourthField1 = "//span[contains(text(),'" + data.get("update_fourth_field") + "')]";
				String updateFourthField1_actual = (driver.findElement(By.xpath(updateFourthField1)).getText()).trim();

				if (updateFourthField1_actual.equals(data.get("update_fourth_field"))) {
					verificationFailedMessage("The details of the fourth field is displayed without permission.");
				} else {
					successMessage("The details of the fourth field is not displayed as expected.");
				}
			} catch (Throwable t) {
				successMessage("The details of the fourth field is not displayed as expected.");
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
