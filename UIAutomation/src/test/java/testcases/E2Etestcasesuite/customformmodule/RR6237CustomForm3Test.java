package testcases.E2Etestcasesuite.customformmodule;

import java.io.IOException;
import java.util.Hashtable;

import org.apache.commons.lang3.RandomStringUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;

import base.TestBase;
import utilities.TestUtil;

public class RR6237CustomForm3Test extends TestBase {

	@Test(dataProviderClass = TestUtil.class, dataProvider = "dp")
	public void rR6237CustomForm3Test(Hashtable<String, String> data) throws IOException, InterruptedException {

		execution(data, "rR6237CustomForm3Test");

		// PERFORM THE ACTIONS (EDIT AND DELETE) ON THE NEWLY CREATED FIELDS OF THE
		// CUSTOM RECORDS AND VALIDATE IN THE PORTFOLIO DASHBOARD - SINGLE TYPE
		title("PERFORM THE ACTIONS (EDIT AND DELETE) ON THE NEWLY CREATED FIELDS IN THE CUSTOM RECORDS AND VALIDATE IN THE PORTFOLIO DASHBOARD - SINGLE TYPE");

		// refresh the page
		driver.navigate().refresh();
		Thread.sleep(5000);
		driver.navigate().refresh();

		System.out.println("Navigate to the Home Screen i.e. Property List Screen.");

		String fieldName1 = RandomStringUtils.randomAlphabetic(8);
		String fieldName2 = RandomStringUtils.randomAlphabetic(8);
		String fieldName3 = RandomStringUtils.randomAlphabetic(8);
		String fieldName4 = RandomStringUtils.randomAlphabetic(8);
		String updateFieldName1 = RandomStringUtils.randomAlphabetic(8);
		String updateFieldName2 = RandomStringUtils.randomAlphabetic(8);
		String updateFieldName3 = RandomStringUtils.randomAlphabetic(8);
		String updateFieldName4 = RandomStringUtils.randomAlphabetic(8);

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
			type("customform_nametxt_XPATH", data.get("name"));

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
			consoleMessage("Clicked on the newly created custom record.");

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

			// click on the add field button
			click("customform_addfieldbtn_XPATH");

			// enter field name
			type("customform_addfield_nametxt_XPATH", fieldName4);

			// select the option from the type dropdown
			select("customform_addfield_typedd_XPATH", data.get("fieldtype_4"));

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

		// UPDATE THE FIELDS DETAIL BY CLICKING ON THE EDIT ICON
		title("UPDATE THE FIELDS DETAIL BY CLICKING ON THE EDIT ICON");

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

			// click on the newly created custom form
			String customForm = "//td[text()='" + data.get("name") + "']";
			driver.findElement(By.xpath(customForm)).click();
			consoleMessage("Clicked on the newly created custom form.");

			// scroll down the screen
			scrollBottom();

			// wait for the element
			Thread.sleep(7000);

			// click on the edit icon of the first field
			String editField1 = "//span[text()='" + fieldName1
					+ "']//following-sibling::span[@class='pull-right']//button[@data-parent='#collapseParent']";
			driver.findElement(By.xpath(editField1)).click();
			consoleMessage("Clicked on the edit icon of the first field.");

			// scroll to bottom of the screen
			scrollBottom();

			// enter field name
			String name1 = "//strong[contains(text(),'1.')]//following-sibling::div[@id='collapse0']//input[@ng-model='item.name']";
			driver.findElement(By.xpath(name1)).clear();
			driver.findElement(By.xpath(name1)).sendKeys(updateFieldName1);
			consoleMessage("Entered field name.");

			// select the option from the type dropdown
			String type1 = "//strong[contains(text(),'1.')]//following-sibling::div[@id='collapse0']//select[@ng-model='item.dataType']";
			WebElement type1_dd = driver.findElement(By.xpath(type1));
			Select dd1 = new Select(type1_dd);
			dd1.selectByVisibleText(data.get("fieldtype_2"));
			consoleMessage("Selected the option from the type dropdown.");

			// click on the display on list checkbox
			String visibilityckbx1 = "//strong[contains(text(),'1.')]//following-sibling::div[@id='collapse0']//input[@ng-model='item.visibleOnList']";
			driver.findElement(By.xpath(visibilityckbx1)).click();
			consoleMessage("Clicked on the display on list checkbox.");

			// click on the unique identifier checkbox
			String uniqueckbx1 = "//strong[contains(text(),'1.')]//following-sibling::div[@id='collapse0']//input[@ng-model='item.isUniqueId']";
			driver.findElement(By.xpath(uniqueckbx1)).click();
			consoleMessage("Clicked on the unique identifier checkbox.");

			// click on the update button
			click("customform_updatebtn_XPATH");

			// wait for the element
			explicitWaitClickable("closetoastmsg_CSS");

			// click on the toaster close button
			click("closetoastmsg_CSS");

			// validate the updated field
			try {
				String field1 = "//span[text()='" + updateFieldName1 + "']";
				String field1_actual = (driver.findElement(By.xpath(field1)).getText()).trim();

				if (field1_actual.equals(updateFieldName1)) {
					successMessage("The updated field is displayed successfully.");
				} else {
					verificationFailedMessage("The updated field is not displayed.");
				}
			} catch (Throwable t) {
				verificationFailedMessage("The updated field is not displayed.");
			}

			// wait for the element
			Thread.sleep(5000);

			// scroll to bottom of the screen
			scrollBottom();

			// click on the edit icon of the second field
			String editField2 = "//span[text()='" + fieldName2
					+ "']//following-sibling::span[@class='pull-right']//button[@data-parent='#collapseParent']";
			driver.findElement(By.xpath(editField2)).click();
			consoleMessage("Clicked on the edit icon of the second field.");

			// scroll to bottom of the screen
			scrollBottom();

			// enter field name
			String name2 = "//strong[contains(text(),'2.')]//following-sibling::div[@id='collapse1']//input[@ng-model='item.name']";
			driver.findElement(By.xpath(name2)).clear();
			driver.findElement(By.xpath(name2)).sendKeys(updateFieldName2);
			consoleMessage("Entered field name.");

			// select the option from the type dropdown
			String type2 = "//strong[contains(text(),'2.')]//following-sibling::div[@id='collapse1']//select[@ng-model='item.dataType']";
			WebElement type2_dd = driver.findElement(By.xpath(type2));
			Select dd2 = new Select(type2_dd);
			dd2.selectByVisibleText(data.get("fieldtype_3"));
			consoleMessage("Selected the option from the type dropdown.");

			// click on the unique identifier checkbox
			String uniqueckbx2 = "//strong[contains(text(),'2.')]//following-sibling::div[@id='collapse1']//input[@ng-model='item.isUniqueId']";
			driver.findElement(By.xpath(uniqueckbx2)).click();
			consoleMessage("Clicked on the unique identifier checkbox.");

			// click on the update button
			click("customform_updatebtn_XPATH");

			// wait for the element
			explicitWaitClickable("closetoastmsg_CSS");

			// click on the toaster close button
			click("closetoastmsg_CSS");

			// validate the updated field
			try {
				String field2 = "//span[text()='" + updateFieldName2 + "']";
				String field2_actual = (driver.findElement(By.xpath(field2)).getText()).trim();

				if (field2_actual.equals(updateFieldName2)) {
					successMessage("The updated field is displayed successfully.");
				} else {
					verificationFailedMessage("The updated field is not displayed.");
				}
			} catch (Throwable t) {
				verificationFailedMessage("The updated field is not displayed.");
			}

			// scroll to bottom of the screen
			scrollBottom();

			// wait for the element
			Thread.sleep(5000);

			// click on the edit icon of the third field
			String editField3 = "//span[text()='" + fieldName3
					+ "']//following-sibling::span[@class='pull-right']//button[@data-parent='#collapseParent']";
			driver.findElement(By.xpath(editField3)).click();
			consoleMessage("Clicked on the edit icon of the third field.");

			// scroll to bottom of the screen
			scrollBottom();

			// enter field name
			String name3 = "//strong[contains(text(),'3.')]//following-sibling::div[@id='collapse2']//input[@ng-model='item.name']";
			driver.findElement(By.xpath(name3)).clear();
			driver.findElement(By.xpath(name3)).sendKeys(updateFieldName3);
			consoleMessage("Entered field name.");

			// select the option from the type dropdown
			String type3 = "//strong[contains(text(),'3.')]//following-sibling::div[@id='collapse2']//select[@ng-model='item.dataType']";
			WebElement type3_dd = driver.findElement(By.xpath(type3));
			Select dd3 = new Select(type3_dd);
			dd3.selectByVisibleText(data.get("fieldtype_4"));
			consoleMessage("Selected the option from the type dropdown.");

			// click on the dropdown field
			click("customform_addfield_dropdowndd_XPATH");

			// click on the clear button
			click("customform_addfield_dropdowndd_clearbtn_XPATH");

			// enter the Application Module in the search field
			type("customform_addfield_dropdowndd_searchtxt_XPATH", data.get("update_dd_option"));

			// click on the searched result
			click("customform_addfield_dropdowndd_searchedresult1_XPATH");

			// scroll to bottom of the screen
			scrollBottom();

			// click on the display on list checkbox
			String visibilityckbx3 = "//strong[contains(text(),'3.')]//following-sibling::div[@id='collapse2']//input[@ng-model='item.visibleOnList']";
			driver.findElement(By.xpath(visibilityckbx3)).click();
			consoleMessage("Clicked on the display on list checkbox.");

			// click on the update button
			click("customform_updatebtn_XPATH");

			// wait for the element
			explicitWaitClickable("closetoastmsg_CSS");

			// click on the toaster close button
			click("closetoastmsg_CSS");

			// scroll to bottom of the screen
			scrollBottom();

			// validate the updated field
			try {
				String field3 = "//span[text()='" + updateFieldName3 + "']";
				String field3_actual = (driver.findElement(By.xpath(field3)).getText()).trim();

				if (field3_actual.equals(updateFieldName3)) {
					successMessage("The updated field is displayed successfully.");
				} else {
					verificationFailedMessage("The updated field is not displayed.");
				}
			} catch (Throwable t) {
				verificationFailedMessage("The updated field is not displayed.");
			}

			// wait for the element
			Thread.sleep(5000);

			// scroll to bottom of the screen
			scrollBottom();

			// click on the edit icon of the fourth field
			String editField4 = "//span[text()='" + fieldName4
					+ "']//following-sibling::span[@class='pull-right']//button[@data-parent='#collapseParent']";
			driver.findElement(By.xpath(editField4)).click();
			consoleMessage("Clicked on the edit icon of the fourth field.");

			// scroll to bottom of the screen
			scrollBottom();

			// enter field name
			String name4 = "//strong[contains(text(),'4.')]//following-sibling::div[@id='collapse3']//input[@ng-model='item.name']";
			driver.findElement(By.xpath(name4)).clear();
			driver.findElement(By.xpath(name4)).sendKeys(updateFieldName4);
			consoleMessage("Entered field name.");

			// select the option from the type dropdown
			String type4 = "//strong[contains(text(),'4.')]//following-sibling::div[@id='collapse3']//select[@ng-model='item.dataType']";
			WebElement type4_dd = driver.findElement(By.xpath(type4));
			Select dd4 = new Select(type4_dd);
			dd4.selectByVisibleText(data.get("fieldtype_1"));
			consoleMessage("Selected the option from the type dropdown.");

			// scroll to bottom of the screen
			scrollBottom();

			// click on the display on list checkbox
			String visibilityckbx4 = "//strong[contains(text(),'4.')]//following-sibling::div[@id='collapse3']//input[@ng-model='item.visibleOnList']";
			driver.findElement(By.xpath(visibilityckbx4)).click();
			consoleMessage("Clicked on the display on list checkbox.");

			// click on the unique identifier checkbox
			String uniqueckbx4 = "//strong[contains(text(),'4.')]//following-sibling::div[@id='collapse3']//input[@ng-model='item.isUniqueId']";
			driver.findElement(By.xpath(uniqueckbx4)).click();
			consoleMessage("Clicked on the unique identifier checkbox.");

			// click on the update button
			click("customform_updatebtn_XPATH");

			// wait for the element
			explicitWaitClickable("closetoastmsg_CSS");

			// click on the toaster close button
			click("closetoastmsg_CSS");

			// scroll to bottom of the screen
			scrollBottom();

			// validate the updated field
			try {
				String field4 = "//span[text()='" + updateFieldName4 + "']";
				String field4_actual = (driver.findElement(By.xpath(field4)).getText()).trim();

				if (field4_actual.equals(updateFieldName4)) {
					successMessage("The updated field is displayed successfully.");
				} else {
					verificationFailedMessage("The updated field is not displayed.");
				}
			} catch (Throwable t) {
				verificationFailedMessage("The updated field is not displayed.");
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

		// VALIDATE THE UPDATE CUSTOM REPORT AND FIELDS IN THE PORTFOLIO DASHBOARD
		title("VALIDATE THE UPDATE CUSTOM REPORT AND FIELDS IN THE PORTFOLIO DASHBOARD");

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
				String field11 = "//th[text()='" + updateFieldName1 + "']";
				String field11_actual = (driver.findElement(By.xpath(field11)).getText()).trim();

				if (field11_actual.equals(updateFieldName1)) {
					verificationFailedMessage("The repsective field is displayed without access.");
				} else {
					successMessage("The respective field is not displayed as expected.");
				}
			} catch (Throwable t) {
				successMessage("The respective field is not displayed as expected.");
			}

			// validate the field 2
			try {
				String field22 = "//th[text()='" + updateFieldName2 + "']";
				String field22_actual = (driver.findElement(By.xpath(field22)).getText()).trim();

				if (field22_actual.equals(updateFieldName2)) {
					successMessage("The respective field is displayed successfully.");

				} else {
					verificationFailedMessage("The repsective field is not displayed.");
				}
			} catch (Throwable t) {
				verificationFailedMessage("The repsective field is not displayed.");
			}

			// validate the field 3
			try {
				String field33 = "//th[text()='" + updateFieldName3 + "']";
				String field33_actual = (driver.findElement(By.xpath(field33)).getText()).trim();

				if (field33_actual.equals(updateFieldName3)) {

					successMessage("The respective field is displayed successfully.");

				} else {
					verificationFailedMessage("The repsective field is not displayed.");
				}
			} catch (Throwable t) {
				verificationFailedMessage("The repsective field is not displayed.");
			}

			// validate the field 4
			try {
				String field44 = "//th[text()='" + updateFieldName4 + "']";
				String field44_actual = (driver.findElement(By.xpath(field44)).getText()).trim();

				if (field44_actual.equals(updateFieldName4)) {

					successMessage("The respective field is displayed successfully.");

				} else {
					verificationFailedMessage("The repsective field is not displayed.");
				}
			} catch (Throwable t) {
				verificationFailedMessage("The repsective field is not displayed.");
			}

			// click on the property one
			click("customform_portfoliodashboard_propertyname_XPATH");

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
				String fieldLabel1 = "//label[contains(text(),'" + updateFieldName1 + "')]";
				String fieldLabel1_actual = (driver.findElement(By.xpath(fieldLabel1)).getText()).trim();

				if (fieldLabel1_actual.equals(updateFieldName1 + ":")) {
					successMessage("The first field label is displayed successfully.");
				} else {
					verificationFailedMessage("The first field label is not displayed.");
				}
			} catch (Throwable t) {
				verificationFailedMessage("The first field label is not displayed.");
			}

			// validate the second field label
			try {
				String fieldLabel2 = "//label[contains(text(),'" + updateFieldName2 + "')]";
				String fieldLabel2_actual = (driver.findElement(By.xpath(fieldLabel2)).getText()).trim();

				if (fieldLabel2_actual.equals(updateFieldName2 + ":")) {
					successMessage("The second field label is displayed successfully.");
				} else {
					verificationFailedMessage("The second field label is not displayed.");
				}
			} catch (Throwable t) {
				verificationFailedMessage("The second field label is not displayed.");
			}

			// validate the third field label
			try {
				String fieldLabel3 = "//label[contains(text(),'" + updateFieldName3 + "')]";
				String fieldLabel3_actual = (driver.findElement(By.xpath(fieldLabel3)).getText()).trim();

				if (fieldLabel3_actual.equals(updateFieldName3 + ":")) {
					successMessage("The third field label is displayed successfully.");
				} else {
					verificationFailedMessage("The third field label is not displayed.");
				}
			} catch (Throwable t) {
				verificationFailedMessage("The third field label is not displayed.");
			}

			// validate the forth field label
			try {
				String fieldLabel4 = "//label[contains(text(),'" + updateFieldName4 + "')]";
				String fieldLabel4_actual = (driver.findElement(By.xpath(fieldLabel4)).getText()).trim();

				if (fieldLabel4_actual.equals(updateFieldName4 + ":")) {
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

		// DELETE THE UPDATED FIELD OF THE CUSTOM FORMS
		title("DELETE THE UPDATED FIELD OF THE CUSTOM FORMS");

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

			// click on the newly created custom record record
			String nameTitle = "//td[text()='" + data.get("name") + "']";
			driver.findElement(By.xpath(nameTitle)).click();
			consoleMessage("Clicked on the newly created custom record.");

			// scroll to bottom of the screen
			scrollBottom();

			// wait for the element
			Thread.sleep(2000);

			// click on the delete icon of the first field
			String deleteField1 = "//span[text()='" + updateFieldName1
					+ "']//following-sibling::span[@class='pull-right']//button[@ng-click='currentTabPageFields.splice(itemIndex, 1)']";
			driver.findElement(By.xpath(deleteField1)).click();
			consoleMessage("Clicked on the delete icon of the first field.");

			// scroll to bottom of the screen
			scrollBottom();

			// wait for the element
			Thread.sleep(2000);

			// click on the delete icon of the second field
			String deleteField2 = "//span[text()='" + updateFieldName2
					+ "']//following-sibling::span[@class='pull-right']//button[@ng-click='currentTabPageFields.splice(itemIndex, 1)']";
			driver.findElement(By.xpath(deleteField2)).click();
			consoleMessage("Clicked on the delete icon of the second field.");

			// scroll to bottom of the screen
			scrollBottom();

			// wait for the element
			Thread.sleep(2000);

			// click on the delete icon of the third field
			String deleteField3 = "//span[text()='" + updateFieldName3
					+ "']//following-sibling::span[@class='pull-right']//button[@ng-click='currentTabPageFields.splice(itemIndex, 1)']";
			driver.findElement(By.xpath(deleteField3)).click();
			consoleMessage("Clicked on the delete icon of the third field.");

			// scroll to bottom of the screen
			scrollBottom();

			// wait for the element
			Thread.sleep(2000);

			// click on the delete icon of the fourth field
			String deleteField4 = "//span[text()='" + updateFieldName4
					+ "']//following-sibling::span[@class='pull-right']//button[@ng-click='currentTabPageFields.splice(itemIndex, 1)']";
			driver.findElement(By.xpath(deleteField4)).click();
			consoleMessage("Clicked on the delete icon of the fourth field.");

			// scroll to bottom of the screen
			scrollBottom();

			// wait for the element
			Thread.sleep(2000);

			// click on the update button
			click("customform_updatebtn_XPATH");

			// wait for the element
			explicitWaitClickable("closetoastmsg_CSS");

			// click on the toaster close button
			click("closetoastmsg_CSS");

			// validate the first field deleted successfully or not
			try {
				String deleteField11 = "//span[text()='" + updateFieldName1 + "']";
				String deleteField11_actual = (driver.findElement(By.xpath(deleteField11)).getText()).trim();

				if (deleteField11_actual.equals(updateFieldName1)) {

					verificationFailedMessage("The deleted field is displayed.");

				} else {
					successMessage("The deleted field is not displayed as expected.");
				}

			} catch (Throwable t) {
				successMessage("The deleted field is not displayed as expected.");
			}

			// validate the second field deleted successfully or not
			try {
				String deleteField22 = "//span[text()='" + updateFieldName2 + "']";
				String deleteField22_actual = (driver.findElement(By.xpath(deleteField22)).getText()).trim();

				if (deleteField22_actual.equals(updateFieldName2)) {

					verificationFailedMessage("The deleted field is displayed.");

				} else {
					successMessage("The deleted field is not displayed as expected.");
				}

			} catch (Throwable t) {
				successMessage("The deleted field is not displayed as expected.");
			}

			// validate the third field deleted successfully or not
			try {
				String deleteField33 = "//span[text()='" + updateFieldName3 + "']";
				String deleteField33_actual = (driver.findElement(By.xpath(deleteField33)).getText()).trim();

				if (deleteField33_actual.equals(updateFieldName3)) {

					verificationFailedMessage("The deleted field is displayed.");

				} else {
					successMessage("The deleted field is not displayed as expected.");
				}

			} catch (Throwable t) {
				successMessage("The deleted field is not displayed as expected.");
			}

			// validate the fourth field deleted successfully or not
			try {
				String deleteField44 = "//span[text()='" + updateFieldName4 + "']";
				String deleteField44_actual = (driver.findElement(By.xpath(deleteField44)).getText()).trim();

				if (deleteField44_actual.equals(updateFieldName4)) {

					verificationFailedMessage("The deleted field is displayed.");

				} else {
					successMessage("The deleted field is not displayed as expected.");
				}

			} catch (Throwable t) {
				successMessage("The deleted field is not displayed as expected.");
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
			String deleteIcon = "//td[text()='" + data.get("name")
					+ "']//following-sibling::td[@class='pointer']//i[@data-target='#deleteCustomFormModal']";
			driver.findElement(By.xpath(deleteIcon)).click();
			consoleMessage("Clicked on the delete button of the newly created custom form.");

			// wait for the element
			Thread.sleep(5000);

			// click on the delete button
			click("customform_deletebtn_XPATH");

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

	}
}
