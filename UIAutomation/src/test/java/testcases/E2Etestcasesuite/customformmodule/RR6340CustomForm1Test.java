package testcases.E2Etestcasesuite.customformmodule;

import java.io.IOException;
import java.util.Hashtable;

import org.openqa.selenium.By;
import org.testng.annotations.Test;

import base.TestBase;
import utilities.TestUtil;

public class RR6340CustomForm1Test extends TestBase {

	@Test(dataProviderClass = TestUtil.class, dataProvider = "dp")
	public void rR6340CustomForm1Test(Hashtable<String, String> data) throws IOException, InterruptedException {

		execution(data, "rR6340CustomForm1Test");

		// PERFORMED CRUD OPERATION OF THE CUSTOM FORMS FOR MULTIPLE RECORD TYPE.
		title("PERFORMED CRUD OPERATION OF THE CUSTOM FORMS FOR MULTIPLE RECORD TYPE.");

		// refresh the page
		driver.navigate().refresh();
		Thread.sleep(5000);
		driver.navigate().refresh();

		System.out.println("Navigate to the Home Screen i.e. Property List Screen.");

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
					verificationFailedMessage("The Report Name detail is displayed correctly.");
				}

			} catch (Throwable t) {
				verificationFailedMessage("The Report Name detail is displayed correctly.");
			}

			// validate the Date Sensitive details of the newly created report
			try {
				String Validation1 = "//td[text()='" + data.get("name") + "']//following-sibling::td[text()='True'][1]";
				String Validation1_actual = (driver.findElement(By.xpath(Validation1)).getText()).trim();

				if (Validation1_actual.equals("True")) {

					successMessage("The Date Sensitive detail is displayed correctly.");

				} else {
					verificationFailedMessage("The Date Sensitive detail is displayed correctly.");
				}

			} catch (Throwable t) {
				verificationFailedMessage("The Date Sensitive detail is displayed correctly.");
			}

			// validate the Verification Workflow Enabled details of the newly created
			// report
			try {
				String Validation2 = "//td[text()='" + data.get("name") + "']//following-sibling::td[text()='True'][2]";
				String Validation2_actual = (driver.findElement(By.xpath(Validation2)).getText()).trim();

				if (Validation2_actual.equals("True")) {

					successMessage("The Verification Workflow Enabled detail is displayed correctly.");

				} else {
					verificationFailedMessage("The Verification Workflow Enabled detail is displayed correctly.");
				}

			} catch (Throwable t) {
				verificationFailedMessage("The Verification Workflow Enabled detail is displayed correctly.");
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

		// UPDATE THE NEWLY CREATED CUSTOM FORM
		title("UPDATE THE NEWLY CREATED CUSTOM FORM");

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

			// click on the newly created custom form
			String newCustomFormRecord = "//td[text()='" + data.get("name") + "']";
			driver.findElement(By.xpath(newCustomFormRecord)).click();
			consoleMessage("Clicked on the newly created custom form.");

			// enter name of the form in the name field
			type("customform_nametxt_XPATH", data.get("name_update"));

			// click on the date sensitive checkbox
			click("customform_datesensitiveckbx_XPATH");

			// click on the Is Verification Workflow Enabled? checkbox
			click("customform_verificationckbx_XPATH");

			// click on the update button
			click("customform_updatebtn_XPATH");

			// wait for the element
			Thread.sleep(5000);

			// click on the cancel button
			click("customform_cancelbtn_XPATH");

			// wait for the element
			Thread.sleep(5000);

			// validate the Report Name details of the newly created report
			try {
				String Validation00 = "//td[text()='" + data.get("name_update") + "']";
				String Validation00_actual = (driver.findElement(By.xpath(Validation00)).getText()).trim();

				if (Validation00_actual.equals(data.get("name_update"))) {

					successMessage("The Report Name detail is displayed correctly.");

				} else {
					verificationFailedMessage("The Report Name detail is not displayed.");
				}

			} catch (Throwable t) {
				verificationFailedMessage("The Report Name detail is not displayed.");
			}

			// validate the Date Sensitive details of the newly created report
			try {
				String Validation1 = "//td[text()='" + data.get("name_update")
						+ "']//following-sibling::td[text()='False'][1]";
				String Validation1_actual = (driver.findElement(By.xpath(Validation1)).getText()).trim();

				if (Validation1_actual.equals("False")) {

					successMessage("The Date Sensitive detail is displayed correctly.");

				} else {
					verificationFailedMessage("The Date Sensitive detail is not displayed.");
				}

			} catch (Throwable t) {
				verificationFailedMessage("The Date Sensitive detail is not displayed.");
			}

			// validate the Verification Workflow Enabled details of the newly created
			// report
			try {
				String Validation2 = "//td[text()='" + data.get("name_update")
						+ "']//following-sibling::td[text()='False'][2]";
				String Validation2_actual = (driver.findElement(By.xpath(Validation2)).getText()).trim();

				if (Validation2_actual.equals("False")) {

					successMessage("The Verification Workflow Enabled detail is displayed correctly.");

				} else {
					verificationFailedMessage("The Verification Workflow Enabled detail is not displayed.");
				}

			} catch (Throwable t) {
				verificationFailedMessage("The Verification Workflow Enabled detail is not displayed.");
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

		// DELETE THE UPDATE CUSTOMER FORM
		title("DELETE THE UPDATE CUSTOMER FORM");

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
			String deleteIcon = "//td[text()='" + data.get("name_update")
					+ "']//following-sibling::td[@class='pointer']//i[@data-target='#deleteCustomFormModal']";
			driver.findElement(By.xpath(deleteIcon)).click();
			consoleMessage("Clicked on the delete button of the newly created custom form.");

			// wait for the element
			Thread.sleep(5000);

			// click on the delete button
			click("customform_deletebtn_XPATH");

			// validate the deleted name
			try {
				String deletedRecord = "//td[text()='" + data.get("name_update") + "']";
				String deleted_record = (driver.findElement(By.xpath(OR.getProperty(deletedRecord))).getText()).trim();

				if (deleted_record.equals(data.get("name_update"))) {
					verificationFailedMessage("The  " + data.get("name_update") + " is not deleted.");
				}
			} catch (Throwable t) {
				successMessage("The " + data.get("name_update") + " is deleted successfully.");
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
