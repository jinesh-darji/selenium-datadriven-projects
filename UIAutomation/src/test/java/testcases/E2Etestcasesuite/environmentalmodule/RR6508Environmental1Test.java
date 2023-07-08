package testcases.E2Etestcasesuite.environmentalmodule;

import java.io.IOException;
import java.time.LocalDate;
import java.util.Hashtable;
import java.util.List;

import org.apache.commons.lang3.RandomStringUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;

import base.TestBase;
import utilities.TestUtil;

public class RR6508Environmental1Test extends TestBase {

	@Test(dataProviderClass = TestUtil.class, dataProvider = "dp")
	public void rR6508Environmental1Test(Hashtable<String, String> data) throws InterruptedException, IOException {

		execution(data, "rR6508Environmental1Test");

		// VERIFY THE NEWLY ADDED FIELD TO THE ENVIRONMENTAL REPORT IS AVAILABLE FOR
		// FURTHER CONFIGURATION FOR EACH TYPE.
		title("VERIFY THE NEWLY ADDED FIELD TO THE ENVIRONMENTAL REPORT IS AVAILABLE FOR FURTHER CONFIGURATION FOR EACH TYPE.");

		// refresh the page
		driver.navigate().refresh();
		Thread.sleep(5000);
		driver.navigate().refresh();

		String labelField = RandomStringUtils.randomAlphabetic(8);
		String nameField = RandomStringUtils.randomAlphabetic(8);
		String title1 = RandomStringUtils.randomAlphabetic(8);

		// ADD THE NEW FIELD IN THE ENVIRONEMNTAL REPORT FROM ENVIRONMENTAL FORM AND
		// VALIDATE ON THE INDIVIDUAL ENVIRONMENTAL REPORT
		title("ADD THE NEW FIELD IN THE ENVIRONEMNTAL REPORT FROM ENVIRONMENTAL FORM AND VALIDATE ON THE INDIVIDUAL ENVIRONMENTAL REPORT");

		try {

			// Wait for the element
			Thread.sleep(5000);

			// click on the settings icon from the top of the screen
			click("questionnaire_settingicon_CSS");

			// wait for the element
			explicitWaitClickable("questionnaire_administrationoption_XPATH");

			// click on the Administration option from the side menu
			click("questionnaire_administrationoption_XPATH");

			// click on the Environment tab
			click("questionnaire_environmenttab_XPATH");

			// click on the Environmental Forms option
			click("administration_environmental_environmentalforms_XPATH");

			// validate environmental form title
			switchVerification("administration_environmental_environmentalformstitle_XPATH", "Environmental Forms",
					"The Environmental Forms title is not displayed.");

			// scroll down till environmental report option
			scrollTillElement("administration_environmental_environmentalforms_envireportsoption_XPATH");
			scrollByPixel(-200);

			// click on the environmental report option
			click("administration_environmental_environmentalforms_envireportsoption_XPATH");

			// scroll down till the end
			scrollBottom();

			// click on the add button
			click("administration_environmental_environmentalreport_addbtn_XPATH");

			// click on the enable checkbox
			click("administration_environmental_environmentalreport_enableckbx_XPATH");

			// click on the required checkbox
			click("administration_environmental_environmentalreport_requiredckbx_XPATH");

			// enter the details in the label field
			type("administration_environmental_environmentalreport_labeltxt_XPATH", labelField);

			// enter the details in the name field
			type("administration_environmental_environmentalreport_sectiontxt_XPATH", nameField);

			// select the option from the dropdown
			select("administration_environmental_environmentalreport_fieldtypedd_XPATH", "DROPBOX");

			// click on the choose button
			click("administration_environmental_environmentalreport_chooseddbtn_XPATH");

			// click on the dropdown options
			click("administration_environmental_environmentalreport_ddoption_XPATH");

			// click on the same button
			click("administration_environmental_environmentalforms_envireportsoption_savebtn_XPATH");

			// scroll down to bottom
			scrollBottom();

			// validate the newly created field is displayed or not
			String fieldLabel = "//span[text()='" + labelField + " (" + nameField + ")']";
			boolean fieldLabel_actual = driver.findElement(By.xpath(fieldLabel)).isDisplayed();

			if (fieldLabel_actual == true) {

				successMessage("The newly created environmental report field is displayed successfully.");

			} else {

				verificationFailedMessage("The newly created environmental report field is not displayed.");
			}

			// scroll to the top
			scrollTop();

			// click on the Administration tab
			click("administration_XPATH");

			// click on the Environment tab
			click("questionnaire_environmenttab_XPATH");

			// click on the Environmental Reports option
			click("administration_environmental_environmentalreports_XPATH");

			// scroll down till Phase II ESA
			scrollTillElement("administration_environmental_environmentalreport_phaseIIesaoption_XPATH");
			scrollByPixel(-200);

			// click on the Phase II ESA
			click("administration_environmental_environmentalreport_phaseIIesaoption_XPATH");

			// scroll till bottom
			scrollBottom();

			// wait for the element
			Thread.sleep(3000);

			// click on the edit button of the newly created field
			String editButton = "//span[text()='" + labelField
					+ "']//following-sibling::button[@class='btn btn-default btn-sm pull-right']";
			driver.findElement(By.xpath(editButton)).click();
			consoleMessage("Clicked on the edit button of the date option.");

			// validate the name of the newly added field
			try {
				String fieldName = "//span[text()='" + labelField
						+ "']//following-sibling::div//input[@ng-model='item.section']";
				String fieldName_actual = driver.findElement(By.xpath(fieldName)).getAttribute("value");

				if (fieldName_actual.equals(nameField)) {
					successMessage("The newly created field name is displayed in the environmental report.");
				} else {
					verificationFailedMessage(
							"The newly created field name is not displayed in the environmental report.");
				}

			} catch (Throwable t) {
				verificationFailedMessage("The newly created field name is not displayed in the environmental report.");
			}

			// validate the label of the newly added field
			try {
				String fieldLabel1 = "//span[text()='" + labelField
						+ "']//following-sibling::div//input[@ng-model='item.label']";
				String fieldLabel1_actual = driver.findElement(By.xpath(fieldLabel1)).getAttribute("value");

				if (fieldLabel1_actual.equals(labelField)) {
					successMessage("The newly created field label is displayed in the environmental report.");
				} else {
					verificationFailedMessage(
							"The newly created field label is not displayed in the environmental report.");
				}

			} catch (Throwable t) {
				verificationFailedMessage(
						"The newly created field label is not displayed in the environmental report.");
			}

			// validate the enabled checkbox of the newly added field
			try {
				String enabledckbx = "//span[text()='" + labelField
						+ "']//following-sibling::div[@class='col-md-12 in']//input[@ng-model='item.enabled']";
				boolean enabledckbx_actual = driver.findElement(By.xpath(enabledckbx)).isSelected();

				if (enabledckbx_actual == true) {
					successMessage(
							"The enabled checkbox is displayed selected for the newly created field in the environmental report.");
				} else {
					verificationFailedMessage(
							"The enabled checkbox is not displayed selected for the newly created field in the environmental report.");
				}

			} catch (Throwable t) {
				verificationFailedMessage(
						"The enabled checkbox is not displayed selected for the newly created field in the environmental report.");
			}

			// validate the required checkbox of the newly added field
			try {
				String requiredckbx = "//span[text()='" + labelField
						+ "']//following-sibling::div[@class='col-md-12 in']//input[@ng-model='item.required']";
				boolean requiredckbx_actual = driver.findElement(By.xpath(requiredckbx)).isSelected();

				if (requiredckbx_actual == true) {
					successMessage(
							"The required checkbox is displayed selected for the newly created field in the environmental report.");
				} else {
					verificationFailedMessage(
							"The required checkbox is not displayed selected for the newly created field in the environmental report.");
				}

			} catch (Throwable t) {
				verificationFailedMessage(
						"The required checkbox is not displayed selected for the newly created field in the environmental report.");
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

		// VALIDATE THE NEWLY ADDED FIELD IN THE ENVIRONMENTAL REPORT AND CREATE NEW
		// RECORD OF THE ENVIRONMENTAL REPORT
		title("VALIDATE THE NEWLY ADDED FIELD IN THE ENVIRONMENTAL REPORT AND CREATE NEW RECORD OF THE ENVIRONMENTAL REPORT");

		try {
			// click on the environmental icon from the property list page
			click("environmentalicon_CSS");

			// click on the burger menu
			click("menubtn_CSS");

			// wait for the element
			explicitWaitClickable("envreportoption_XPATH");

			// click on the Environmental Reports option
			click("envreportoption_XPATH");

			// click on the Add report button
			click("envreportaddbtn_CSS");

			// select the checklist from the type dropdown
			select("envreporttypedd_CSS", data.get("type"));

			// scroll down to bottom
			scrollBottom();

			// validate the red color asterisk sign is displayed or not in newly added field
			try {
				String requiredIcon = "//label[contains(text(),'" + labelField
						+ "')]//span[@class='required-field ng-scope']";
				boolean requiredIcon_actual = driver.findElement(By.xpath(requiredIcon)).isDisplayed();

				if (requiredIcon_actual == true) {
					successMessage("The red color asterisk sign is displayed successfully.");
				} else {
					verificationFailedMessage("The red color asterisk sign is not displayed.");
				}

			} catch (Throwable t) {
				verificationFailedMessage("The red color asterisk sign is not displayed.");
			}

			// validate the newly added field is displayed or not
			try {
				String dropdownField = "//select[@id='select-" + labelField + "']";
				boolean dropdownField_actual = driver.findElement(By.xpath(dropdownField)).isDisplayed();

				if (dropdownField_actual == true) {
					successMessage("The dropdown field is displayed successfully.");
				} else {
					verificationFailedMessage("The dropdown field is not displayed.");
				}

			} catch (Throwable t) {
				verificationFailedMessage("The dropdown field is not displayed.");
			}

			// scroll down to top
			scrollTop();

			// enter the title
			type("envreporttitletxt_CSS", title1);

			// enter the company
			type("envreportcompanytxt_CSS", data.get("company"));

			// enter the author
			type("envreportauthortxt_CSS", data.get("author"));

			// scroll down the screen
			scrollBottom();

			// enter the description
			type("envreportdescriptiontxt_CSS", data.get("description"));

			// add the details in the label update field
			type("envreport_labelupdatetxt_XPATH", data.get("label_update"));

			// select the option from the newly added field
			String dropdownField = "//select[@id='select-" + labelField + "']";
			WebElement dropdown = driver.findElement(By.xpath(dropdownField));
			Select select = new Select(dropdown);
			select.selectByVisibleText("Yes");
			consoleMessage("Selected the option from the newly added field.");

			// click on the Add report button
			click("envreportsavebtn_CSS");

			// wait for the element
			explicitWaitClickable("closetoastmsg_CSS");

			// click on the toaster close button
			click("closetoastmsg_CSS");

			// enter the newly created environmental report in the search field
			type("task_listofchecklist_filterfield_CSS", title1);

			// verification of the environmental report is added or not
			try {
				String record = "//span[text()='" + title1 + "']";
				String record_actual = (driver.findElement(By.xpath(record)).getText()).trim();

				if (record_actual.equals(title1)) {

					successMessage("The environmental report is verified successfully.");

				} else {
					verificationFailedMessage("The environmental report is not verified.");
				}
			} catch (Throwable t) {
				verificationFailed();
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

		// DELETE THE FIELD FROM THE ENVIRONMENTAL REPORT, WHEN ENVIRONMENTAL
		// REPORT RECORDS ARE CREATED WITH THE RESPECTIVE FIELD
		title("DELETE THE FIELD FROM THE ENVIRONMENTAL REPORT, WHEN ENVIRONMENTAL REPORT RECORDS ARE CREATED WITH THE RESPECTIVE FIELD");

		try {

			// Wait for the element
			Thread.sleep(5000);

			// click on the settings icon from the top of the screen
			click("questionnaire_settingicon_CSS");

			// wait for the element
			explicitWaitClickable("questionnaire_administrationoption_XPATH");

			// click on the Administration option from the side menu
			click("questionnaire_administrationoption_XPATH");

			// click on the Environment tab
			click("questionnaire_environmenttab_XPATH");

			// click on the Environmental Forms option
			click("administration_environmental_environmentalforms_XPATH");

			// validate environmental form title
			switchVerification("administration_environmental_environmentalformstitle_XPATH", "Environmental Forms",
					"The Environmental Forms title is not displayed.");

			// scroll down till environmental report option
			scrollTillElement("administration_environmental_environmentalforms_envireportsoption_XPATH");
			scrollByPixel(-200);

			// click on the environmental report option
			click("administration_environmental_environmentalforms_envireportsoption_XPATH");

			// scroll down till the end
			scrollBottom();

			// wait for the element
			Thread.sleep(3000);

			// click on the newly created field
			String fieldLabel = "//span[text()='" + labelField + " (" + nameField
					+ ")']//parent::div[@class='col-md-6']//following-sibling::div[@class='col-md-2 pull-right']//button[@ng-click='setSectionToDelete(section)']";
			driver.findElement(By.xpath(fieldLabel)).click();
			consoleMessage("Clicked on the newly created field.");

			// wait for the element
			explicitWaitClickable("administration_environmental_environmentalreport_deletebtn_XPATH");

			// click on the delete button of the confirmation popup
			click("administration_environmental_environmentalreport_deletebtn_XPATH");

			// scroll down to bottom
			scrollBottom();

			// validate the newly created field is displayed or not
			try {
				String fieldLabelUpdate = "//span[text()='" + labelField + " (" + nameField + ")']";
				boolean fieldLabelUpdate_actual = driver.findElement(By.xpath(fieldLabelUpdate)).isDisplayed();

				if (fieldLabelUpdate_actual == true) {

					successMessage(
							"The updated environmental report field is not deleted, Because environmental report records are created.");

				} else {

					verificationFailedMessage("The updated environmental report field is deleted.");
				}

			} catch (Throwable t) {

				verificationFailedMessage("The updated environmental report field is deleted.");

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

		// DELETE ALL THE PREVIOUSLY CREATED ENVIRONMENTAL REPORTS
		title("DELETE ALL THE PREVIOUSLY CREATED ENVIRONMENTAL REPORTS");

		try {
			// click on the environmental icon from the property list page
			click("environmentalicon_CSS");

			// click on the burger menu
			click("menubtn_CSS");

			// wait for the element
			explicitWaitClickable("envreportoption_XPATH");

			// click on the Environmental Reports option
			click("envreportoption_XPATH");

			// wait for the element
			Thread.sleep(5000);

			try {
				List<WebElement> reportList = driver
						.findElements(By.xpath(OR.getProperty("envreports_totalrecords_XPATH")));
				int reportCount = reportList.size();

				for (int i = 1; i <= reportCount; i++) {

					// wait for the element
					Thread.sleep(5000);

					// click on the first record
					String firstReport = "//table[@id='environmentalDocumentListTable']//tbody//tr[1]//td[@class='ng-scope'][1]";
					driver.findElement(By.xpath(firstReport)).click();
					consoleMessage("Clicked on the first record.");

					// wait for the element
					explicitWaitClickable("envreportdeletebtn_CSS");

					// click on the delete button
					click("envreportdeletebtn_CSS");

					// wait for the element
					explicitWaitClickable("envreportmodeldeletebtn_CSS");

					// click on the delete button of the confirmation model
					click("envreportmodeldeletebtn_CSS");

					// wait for the element
					explicitWaitClickable("closetoastmsg_CSS");

					// click on the toaster close button
					click("closetoastmsg_CSS");

				}

			} catch (Throwable t) {
				successMessage("All the environmental reports are deleted successfully.");
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

		// DELETE THE UPDATED FIELD FROM THE ENVIRONMENTAL REPORT AND VALIDATE ON THE
		// INDIVIDUAL ENVIRONMENTAL REPORT
		title("DELETE THE UPDATED FIELD FROM THE ENVIRONMENTAL REPORT AND VALIDATE ON THE INDIVIDUAL ENVIRONMENTAL REPORT");

		try {

			// Wait for the element
			Thread.sleep(5000);

			// click on the settings icon from the top of the screen
			click("questionnaire_settingicon_CSS");

			// wait for the element
			explicitWaitClickable("questionnaire_administrationoption_XPATH");

			// click on the Administration option from the side menu
			click("questionnaire_administrationoption_XPATH");

			// click on the Environment tab
			click("questionnaire_environmenttab_XPATH");

			// click on the Environmental Forms option
			click("administration_environmental_environmentalforms_XPATH");

			// validate environmental form title
			switchVerification("administration_environmental_environmentalformstitle_XPATH", "Environmental Forms",
					"The Environmental Forms title is not displayed.");

			// scroll down till environmental report option
			scrollTillElement("administration_environmental_environmentalforms_envireportsoption_XPATH");
			scrollByPixel(-200);

			// click on the environmental report option
			click("administration_environmental_environmentalforms_envireportsoption_XPATH");

			// scroll down till the end
			scrollBottom();

			// wait for the element
			Thread.sleep(3000);

			// click on the updated field
			String fieldLabel = "//span[text()='" + labelField + " (" + nameField
					+ ")']//parent::div[@class='col-md-6']//following-sibling::div[@class='col-md-2 pull-right']//button[@ng-click='setSectionToDelete(section)']";
			driver.findElement(By.xpath(fieldLabel)).click();
			consoleMessage("Clicked on the updated field.");

			// wait for the element
			explicitWaitClickable("administration_environmental_environmentalreport_deletebtn_XPATH");

			// click on the delete button of the confirmation popup
			click("administration_environmental_environmentalreport_deletebtn_XPATH");

			// scroll down to bottom
			scrollBottom();

			// validate the newly created field is displayed or not
			try {
				String fieldLabelUpdate = "//span[text()='" + labelField + " (" + nameField + ")']";
				boolean fieldLabelUpdate_actual = driver.findElement(By.xpath(fieldLabelUpdate)).isDisplayed();

				if (fieldLabelUpdate_actual == true) {

					verificationFailedMessage("The updated environmental report field is not deleted.");

				} else {

					successMessage("The updated environmental report field is deleted successfully.");

				}
			} catch (Throwable t) {
				successMessage("The updated environmental report field is deleted successfully.");
			}

			// scroll to the top
			scrollTop();

			// click on the Administration tab
			click("administration_XPATH");

			// click on the Environment tab
			click("questionnaire_environmenttab_XPATH");

			// click on the Environmental Reports option
			click("administration_environmental_environmentalreports_XPATH");

			// scroll down till Phase II ESA
			scrollTillElement("administration_environmental_environmentalreport_phaseIIesaoption_XPATH");
			scrollByPixel(-200);

			// click on the Phase II ESA
			click("administration_environmental_environmentalreport_phaseIIesaoption_XPATH");

			// scroll till bottom
			scrollBottom();

			// validate the deleted field in the environmental report
			try {
				String deletedRecord = "//span[text()='" + labelField + "']";
				boolean deletedRecord_actual = driver.findElement(By.xpath(deletedRecord)).isDisplayed();

				if (deletedRecord_actual == true) {
					verificationFailedMessage("The updated field is displayed in the environmental report.");
				} else {
					successMessage("The updated field is not displayed in the environmental report as expected.");
				}

			} catch (Throwable t) {
				successMessage("The updated field is not displayed in the environmental report as expected.");
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
