package testcases.E2Etestcasesuite.customformmodule;

import java.io.IOException;
import java.util.Hashtable;

import org.apache.commons.lang3.RandomStringUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import base.Helper;
import base.TestBase;
import utilities.TestUtil;

public class RR6340CustomForm13Test extends TestBase {

	@Test(dataProviderClass = TestUtil.class, dataProvider = "dp")
	public void rR6340CustomForm13Test(Hashtable<String, String> data) throws IOException, InterruptedException {

		execution(data, "rR6340CustomForm13Test");

		// VALIDATE THE SECURITY PERMISSION OF INDIVIDUAL FIELDS OF THE GENERAL TAB AND
		// PAGES TAB/S FOR CUSTOM FORM - MULTIPLE TYPE.
		title("VALIDATE THE SECURITY PERMISSION OF INDIVIDUAL FIELDS OF THE GENERAL TAB AND PAGES TAB/S - MULTIPLE TYPE.");
		
		Helper helper = new Helper();

		// refresh the page
		driver.navigate().refresh();
		Thread.sleep(5000);
		driver.navigate().refresh();

		String fieldName1 = RandomStringUtils.randomAlphabetic(8); // Normal Field 1
		String fieldName2 = RandomStringUtils.randomAlphabetic(8); // Normal Field 2
		String pageName1 = RandomStringUtils.randomAlphabetic(8); // Page Name 1
		String pageFieldName1 = RandomStringUtils.randomAlphabetic(8); // Page Name 1 - Field 1
		String pageFieldName2 = RandomStringUtils.randomAlphabetic(8); // Page Name 1 - Field 2
		String field1Detail = RandomStringUtils.randomAlphabetic(8);
		String field2Detail = RandomStringUtils.randomNumeric(3);
		String pageField1Detail = RandomStringUtils.randomAlphabetic(8);
		String pageField2Detail = RandomStringUtils.randomNumeric(3);

		WebDriverWait wait = new WebDriverWait(driver, 45);

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

			// wait for the element
			Thread.sleep(5000);

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

			// wait for the element
			explicitWaitClickable("closetoastmsg_CSS");

			// click on the toaster close button
			click("closetoastmsg_CSS");

			// wait for the element
			Thread.sleep(5000);

			// validate the newly created field
			try {
				String field1 = "//span[text()='" + fieldName1 + "']";
				wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(field1)));

				String field1_actual = (driver.findElement(By.xpath(field1)).getText()).trim();

				if (field1_actual.equals(fieldName1)) {
					successMessage("The newly created field is displayed successfully.");
				} else {
					verificationFailedMessage("The newly created field is not displayed.");
				}
			} catch (Throwable t) {
				verificationFailedMessage("The newly created field is not displayed.");
			}

			// scroll down the screen
			scrollBottom();

			// click on the lock button
			String field17 = "//span[text()='" + fieldName1
					+ "']//following-sibling::span//button[@ng-click='getFieldSecurityData(item.id)']";
			driver.findElement(By.xpath(field17)).click();
			consoleMessage("Clicked on the lock button.");

			// click on the user field
			click("customform_addfield_lockbtn_usertxt_XPATH");

			// click on the none button
			click("customform_securitytab_nonebtn_XPATH");

			// enter the user name in the search field
			type("customform_addfield_dropdowndd_searchtxt_XPATH", data.get("user1"));

			// click on the searched result
			click("customform_securitytab_searchedresult1_XPATH");

			// click on the user field
			click("customform_addfield_lockbtn_usertxt_XPATH");

			// wait for the element
			Thread.sleep(5000);

			// click on the save button
			click("customform_addfield_lockbtn_savebtn_XPATH");

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

			// scroll down the screen
			scrollBottom();

			// wait for the element
			Thread.sleep(5000);

			// validate the newly created field
			try {
				String field2 = "//span[text()='" + fieldName2 + "']";
				wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(field2)));
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

			// wait for the element
			Thread.sleep(5000);

			// click on the add button
			click("customform_portfoliodashboard_pagename_addbtn_XPATH");

			// validate the newly added page
			try {

				String page1 = "//span[contains(text(),'" + pageName1 + "')]";
				wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(page1)));

				String page1_actual = (driver.findElement(By.xpath(page1)).getText()).trim();

				if (page1_actual.equals(pageName1)) {
					successMessage("The newly created page is displayed successfully.");
				} else {
					verificationFailedMessage("The newly created page is not displayed.");
				}
			} catch (Throwable t) {
				verificationFailedMessage("The newly created page is not displayed.");
			}

			// wait for the element
			Thread.sleep(5000);

			// click on the update button
			click("customform_updatebtn_XPATH");

			// wait for the element
			explicitWaitClickable("closetoastmsg_CSS");

			// click on the toaster close button
			click("closetoastmsg_CSS");

			// ADD FIELDS IN THE PAGE ONE
			title("ADD FIELDS IN THE PAGE ONE");

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

			// wait for the element
			Thread.sleep(5000);

			// validate the newly created field
			try {
				String field1 = "//span[text()='" + pageFieldName1 + "']";

				wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(field1)));
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

			// wait for the element
			Thread.sleep(5000);

			// scroll down the screen
			scrollBottom();

			// validate the newly created field
			try {
				String field2 = "//span[text()='" + pageFieldName2 + "']";

				wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(field2)));
				String field2_actual = (driver.findElement(By.xpath(field2)).getText()).trim();

				if (field2_actual.equals(pageFieldName2)) {
					successMessage("The newly created field is displayed successfully.");
				} else {
					verificationFailedMessage("The newly created field is not displayed.");
				}
			} catch (Throwable t) {
				verificationFailedMessage("The newly created field is not displayed.");
			}

			// click on the lock button
			String field19 = "//span[text()='" + pageFieldName2
					+ "']//following-sibling::span//button[@ng-click='getFieldSecurityData(item.id)']";
			driver.findElement(By.xpath(field19)).click();
			consoleMessage("Clicked on the lock button.");

			// click on the user field
			click("customform_addfield_lockbtn_usertxt_XPATH");

			// click on the none button
			click("customform_securitytab_nonebtn_XPATH");

			// enter the user name in the search field
			type("customform_addfield_dropdowndd_searchtxt_XPATH", data.get("user1"));

			// click on the searched result
			click("customform_securitytab_searchedresult1_XPATH");

			// click on the user field
			click("customform_addfield_lockbtn_usertxt_XPATH");

			// wait for the element
			Thread.sleep(5000);

			// click on the save button
			click("customform_addfield_lockbtn_savebtn_XPATH");

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
			field1Detail = RandomStringUtils.randomAlphabetic(8);
			String firstField = "//input[@id='" + fieldName1 + "TEXT']";
			driver.findElement(By.xpath(firstField)).sendKeys(field1Detail);
			consoleMessage("Entered the details in the first field.");

			// enter the details in the second field
			field2Detail = RandomStringUtils.randomNumeric(3);
			String secondField = "//input[@id='" + fieldName2 + "NUMBER']";
			driver.findElement(By.xpath(secondField)).sendKeys(field2Detail);
			consoleMessage("Entered the details in the second field.");

			// click on the page one tab
			String page1 = "//span[text()='" + pageName1 + "']";
			driver.findElement(By.xpath(page1)).click();
			consoleMessage("Clicked on the page one tab.");

			// enter the details in the first field
			pageField1Detail = RandomStringUtils.randomAlphabetic(8);
			String pageFirstField = "//input[@id='" + pageFieldName1 + "TEXT']";
			driver.findElement(By.xpath(pageFirstField)).sendKeys(pageField1Detail);
			consoleMessage("Entered the details in the first field.");

			// enter the details in the second field
			pageField2Detail = RandomStringUtils.randomNumeric(3);
			String pageSecondField = "//input[@id='" + pageFieldName2 + "NUMBER']";
			driver.findElement(By.xpath(pageSecondField)).sendKeys(pageField2Detail);
			consoleMessage("Entered the details in the second field.");

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

		} catch (Throwable t) {
			verificationFailed();
		}

		// click on the home icon from the top of the screen
		click("questionnaire_homeburgermenubtn_hide_CSS");

		// wait for the element
		explicitWait("propertylist_title_XPATH");

		// verify the property list
		switchVerification("propertylist_title_XPATH", "Property List", "The property list is not displayed.");

		// VALIDATE THE FIELDS AS PER THE PERMISSION OF THE CUSTOM REPORT IN THE
		// PROPERTY SUMMARY DASHBOARD AND PORTFOLIO DASHBOARD - ADMIN USER
		title("VALIDATE THE FIELDS AS PER THE PERMISSION OF THE CUSTOM REPORT IN THE PROPERTY SUMMARY DASHBOARD - ADMIN USER");

		try {

			// VALIDATE ON PROPERTY SUMMARY DASHBOARD SCREEN
			title("VALIDATE ON PROPERTY SUMMARY DASHBOARD SCREEN");

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

					// click on the newly created custom form
					String customFormName = "//td[text()='" + data.get("name") + "']";
					driver.findElement(By.xpath(customFormName)).click();
					consoleMessage("Clicked on the newly created custom form.");

					// scroll down the screen
					scrollBottom();

					// validate the input fields are displayed in general tab
					try {
						// click on the newly created record
						String record = "//span[text()='" + field1Detail + "']";
						driver.findElement(By.xpath(record)).click();
						consoleMessage("Clicked on the newly created record.");

						// scroll down the screen
						scrollBottom();

						boolean editbtn1 = driver
								.findElement(
										By.xpath(OR.getProperty("customform_portfoliodashboard_editfieldbtn_XPATH")))
								.isDisplayed();

						if (editbtn1 == true) {

							successMessage("The edit button is displayed as expected.");

							// click on the edit field button
							click("customform_portfoliodashboard_editfieldbtn_XPATH");

							// validate first input field of the general tab is displayed as per the
							// permission
							try {
								String Field1 = "//input[@id='" + fieldName1 + "TEXT']";
								boolean Field1_actual = driver.findElement(By.xpath(Field1)).isDisplayed();

								if (Field1_actual == true) {

									verificationFailedMessage("The first input field is displayed without permission.");

								} else {
									successMessage("The first input field is not displayed as expected.");
								}
							} catch (Throwable t) {
								successMessage("The first input field is not displayed as expected.");
							}

							// validate second input field of the general tab is displayed as per the
							// permission
							try {
								String Field2 = "//input[@id='" + fieldName2 + "NUMBER']";
								boolean Field2_actual = driver.findElement(By.xpath(Field2)).isDisplayed();

								if (Field2_actual == true) {

									successMessage("The second input field is displayed as expected.");

								} else {
									verificationFailedMessage("The second input field is not displayed.");
								}
							} catch (Throwable t) {
								verificationFailedMessage("The second input field is not displayed.");
							}

							// click on the field save button
							click("customform_portfoliodashboard_fields_savebtn_XPATH");

						} else {
							verificationFailedMessage("The edit button is not displayed.");
						}
					} catch (Throwable t) {
						verificationFailedMessage("The edit button is not displayed.");
					}

					// click on the first page name tab
					String pageTab1 = "//span[text()='" + pageName1 + "']";
					driver.findElement(By.xpath(pageTab1)).click();
					consoleMessage("Clicked on the first page name tab.");

					// scroll down the screen
					scrollBottom();

					// validate the input fields are displayed in one page tab
					try {
						boolean editbtn1 = driver
								.findElement(
										By.xpath(OR.getProperty("customform_portfoliodashboard_editfieldbtn_XPATH")))
								.isDisplayed();

						if (editbtn1 == true) {

							successMessage("The edit button is displayed as expected.");

							// click on the edit field button
							click("customform_portfoliodashboard_editfieldbtn_XPATH");

							// validate first input field of the one page tab is displayed as per the
							// permission
							try {
								String Field1 = "//input[@id='" + pageFieldName1 + "TEXT']";
								boolean Field1_actual = driver.findElement(By.xpath(Field1)).isDisplayed();

								if (Field1_actual == true) {

									successMessage("The first input field is displayed as expected.");

								} else {
									verificationFailedMessage("The first input field is not displayed.");
								}
							} catch (Throwable t) {
								verificationFailedMessage("The first input field is not displayed.");
							}

							// validate second input field of the two page tab is displayed as per the
							// permission
							try {
								String Field2 = "//input[@id='" + pageFieldName2 + "NUMBER']";
								boolean Field2_actual = driver.findElement(By.xpath(Field2)).isDisplayed();

								if (Field2_actual == true) {

									verificationFailedMessage(
											"The second input field is displayed without permission.");

								} else {
									successMessage("The second input field is not displayed as expected.");
								}
							} catch (Throwable t) {
								successMessage("The second input field is not displayed as expected.");
							}

							// click on the field save button
							click("customform_portfoliodashboard_fields_savebtn_XPATH");

						} else {
							verificationFailedMessage("The edit button is not displayed.");
						}
					} catch (Throwable t) {
						verificationFailedMessage("The edit button is not displayed.");
					}

				} else {
					verificationFailedMessage("The newly created custom form is not displayed.");
				}

			} catch (Throwable t) {
				verificationFailedMessage("The newly created custom form is not displayed.");
			}

			// click on the home icon from the top of the screen
			click("questionnaire_homeburgermenubtn_hide_CSS");

			// wait for the element
			explicitWait("propertylist_title_XPATH");

			// verify the property list
			switchVerification("propertylist_title_XPATH", "Property List", "The property list is not displayed.");

			// VALIDATE ON PORTFOLIO SUMMARY DASHBOARD
			consoleMessage("VALIDATE ON PORTFOLIO SUMMARY DASHBOARD");

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

			// validate the delete button is displayed in the newly created custom form from
			// the portfolio dashboard screen
			try {
				String customForm1 = "//td[text()='" + data.get("name") + "']";
				String customForm1_actual = (driver.findElement(By.xpath(customForm1)).getText()).trim();

				if (customForm1_actual.equals(data.get("name"))) {

					// click on the newly created custom form
					String customFormName = "//td[text()='" + data.get("name") + "']";
					driver.findElement(By.xpath(customFormName)).click();
					consoleMessage("Clicked on the newly created custom form.");

					// click on the property one
					click("customform_portfoliodashboard_propertyname_XPATH");

					// scroll down the screen
					scrollBottom();

					// validate the input fields are displayed in one page tab
					try {
						boolean editbtn1 = driver
								.findElement(
										By.xpath(OR.getProperty("customform_portfoliodashboard_editfieldbtn_XPATH")))
								.isDisplayed();

						if (editbtn1 == true) {

							successMessage("The edit button is displayed as expected.");

							// click on the edit field button
							click("customform_portfoliodashboard_editfieldbtn_XPATH");

							// validate first input field of the one page tab is displayed as per the
							// permission
							try {
								String Field1 = "//input[@id='" + fieldName1 + "TEXT']";
								boolean Field1_actual = driver.findElement(By.xpath(Field1)).isDisplayed();

								if (Field1_actual == true) {

									verificationFailedMessage("The first input field is displayed.");

								} else {
									successMessage("The first input field is not displayed as expected.");
								}
							} catch (Throwable t) {
								successMessage("The first input field is not displayed as expected.");
							}

							// validate second input field of the one page tab is displayed as per the
							// permission
							try {
								String Field2 = "//input[@id='" + fieldName2 + "NUMBER']";
								boolean Field2_actual = driver.findElement(By.xpath(Field2)).isDisplayed();

								if (Field2_actual == true) {

									successMessage("The second input field is displayed as expected.");

								} else {
									verificationFailedMessage("The second input field is not displayed.");
								}
							} catch (Throwable t) {
								verificationFailedMessage("The second input field is not displayed.");
							}

							// click on the field save button
							click("customform_portfoliodashboard_fields_savebtn_XPATH");

						} else {
							verificationFailedMessage("The edit button is not displayed.");
						}
					} catch (Throwable t) {
						verificationFailedMessage("The edit button is not displayed.");
					}

					// click on the first page name tab
					String pageTab1 = "//span[text()='" + pageName1 + "']";
					driver.findElement(By.xpath(pageTab1)).click();
					consoleMessage("Clicked on the first page name tab.");

					// scroll down the screen
					scrollBottom();

					try {
						boolean editbtn1 = driver
								.findElement(
										By.xpath(OR.getProperty("customform_portfoliodashboard_editfieldbtn_XPATH")))
								.isDisplayed();

						if (editbtn1 == true) {

							successMessage("The edit button is displayed as expected.");

							// click on the edit field button
							click("customform_portfoliodashboard_editfieldbtn_XPATH");

							// validate first input field of the one page tab is displayed as per the
							// permission
							try {
								String Field1 = "//input[@id='" + pageFieldName1 + "TEXT']";
								boolean Field1_actual = driver.findElement(By.xpath(Field1)).isDisplayed();

								if (Field1_actual == true) {

									successMessage("The first input field is displayed as expected.");

								} else {
									verificationFailedMessage("The first input field is not displayed.");
								}
							} catch (Throwable t) {
								verificationFailedMessage("The first input field is not displayed.");
							}

							// validate second input field of the two page tab is displayed as per the
							// permission
							try {
								String Field2 = "//input[@id='" + pageFieldName2 + "NUMBER']";
								boolean Field2_actual = driver.findElement(By.xpath(Field2)).isDisplayed();

								if (Field2_actual == true) {

									verificationFailedMessage(
											"The second input field is displayed without permission.");

								} else {
									successMessage("The second input field is not displayed as expected.");
								}
							} catch (Throwable t) {
								successMessage("The second input field is not displayed as expected.");
							}

							// click on the field save button
							click("customform_portfoliodashboard_fields_savebtn_XPATH");

						} else {
							verificationFailedMessage("The edit button is not displayed.");
						}
					} catch (Throwable t) {
						verificationFailedMessage("The edit button is not displayed.");
					}

				} else {
					verificationFailedMessage("The newly created custom form is not displayed");
				}

			} catch (Throwable t) {
				verificationFailedMessage("The newly created custom form is not displayed");
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

		// LOGOUT THE SESSION FROM THE ADMIN USER AND LOGIN TO PROPERTY MANAGER -
		// JINESH
		title("LOGOUT THE SESSION FROM THE ADMIN USER AND LOGIN TO PROPERTY MANAGER - JINESH");

		try {
			// wait for the element
			Thread.sleep(5000);

			// click on the settings icon from the top of the screen
			click("questionnaire_settingicon_userupdate_CSS");

			// wait for the element
			explicitWaitClickable("sidemenu_logout_CSS");

			// click on the logout option from the side menu
			click("sidemenu_logout_CSS");

			// login with valid credentials
			helper.loginAndUpdateSystemCompany(data, "username", "password", "system_company_1");

			// VALIDATE THE FIELDS AS PER THE PERMISSION OF THE CUSTOM REPORT IN THE
			// PROPERTY SUMMARY DASHBOARD - PROPERTY MANAGER USER - JINESH
			title("VALIDATE THE FIELDS AS PER THE PERMISSION OF THE CUSTOM REPORT IN THE PROPERTY SUMMARY DASHBOARD - PROPERTY MANAGER USER - JINESH");

			try {

				// VALIDATE ON PROPERTY SUMMARY DASHBOARD SCREEN
				title("VALIDATE ON PROPERTY SUMMARY DASHBOARD SCREEN");

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

						// click on the newly created custom form
						String customFormName = "//td[text()='" + data.get("name") + "']";
						driver.findElement(By.xpath(customFormName)).click();
						consoleMessage("Clicked on the newly created custom form.");

						// click on the newly created record
						String record = "//span[text()='" + field1Detail + "']";
						driver.findElement(By.xpath(record)).click();
						consoleMessage("Clicked on the newly created record.");

						// scroll down the screen
						scrollBottom();

						// validate the input fields are displayed in general tab
						try {
							boolean editbtn1 = driver
									.findElement(By
											.xpath(OR.getProperty("customform_portfoliodashboard_editfieldbtn_XPATH")))
									.isDisplayed();

							if (editbtn1 == true) {

								successMessage("The edit button is displayed as expected.");

								// click on the edit field button
								click("customform_portfoliodashboard_editfieldbtn_XPATH");

								// validate first input field of the general tab is displayed as per the
								// permission
								try {
									String Field1 = "//input[@id='" + fieldName1 + "TEXT']";
									boolean Field1_actual = driver.findElement(By.xpath(Field1)).isDisplayed();

									if (Field1_actual == true) {

										successMessage("The first input field is displayed as expected.");

									} else {
										verificationFailedMessage("The first input field is not displayed.");
									}
								} catch (Throwable t) {
									verificationFailedMessage("The first input field is not displayed.");
								}

								// validate second input field of the general tab is displayed as per the
								// permission
								try {
									String Field2 = "//input[@id='" + fieldName2 + "NUMBER']";
									boolean Field2_actual = driver.findElement(By.xpath(Field2)).isDisplayed();

									if (Field2_actual == true) {

										successMessage("The second input field is displayed as expected.");

									} else {
										verificationFailedMessage("The second input field is not displayed.");
									}
								} catch (Throwable t) {
									verificationFailedMessage("The second input field is not displayed.");
								}

								// click on the field save button
								click("customform_portfoliodashboard_fields_savebtn_XPATH");

							} else {
								verificationFailedMessage("The edit button is not displayed.");
							}
						} catch (Throwable t) {
							verificationFailedMessage("The edit button is not displayed.");
						}

						// click on the first page name tab
						String pageTab1 = "//span[text()='" + pageName1 + "']";
						driver.findElement(By.xpath(pageTab1)).click();
						consoleMessage("Clicked on the first page name tab.");

						// scroll down the screen
						scrollBottom();

						// validate the input fields are displayed in one page tab
						try {
							boolean editbtn1 = driver
									.findElement(By
											.xpath(OR.getProperty("customform_portfoliodashboard_editfieldbtn_XPATH")))
									.isDisplayed();

							if (editbtn1 == true) {

								successMessage("The edit button is displayed as expected.");

								// click on the edit field button
								click("customform_portfoliodashboard_editfieldbtn_XPATH");

								// validate first input field of the one page tab is displayed as per the
								// permission
								try {
									String Field1 = "//input[@id='" + pageFieldName1 + "TEXT']";
									boolean Field1_actual = driver.findElement(By.xpath(Field1)).isDisplayed();

									if (Field1_actual == true) {

										successMessage("The first input field is displayed as expected.");

									} else {
										verificationFailedMessage("The first input field is not displayed.");
									}
								} catch (Throwable t) {
									verificationFailedMessage("The first input field is not displayed.");
								}

								// validate second input field of the one page tab is displayed as per the
								// permission
								try {
									String Field2 = "//input[@id='" + pageFieldName2 + "NUMBER']";
									boolean Field2_actual = driver.findElement(By.xpath(Field2)).isDisplayed();

									if (Field2_actual == true) {

										successMessage("The second input field is displayed as expected.");

									} else {
										verificationFailedMessage("The second input field is not displayed.");
									}
								} catch (Throwable t) {
									verificationFailedMessage("The second input field is not displayed.");
								}

								// click on the field save button
								click("customform_portfoliodashboard_fields_savebtn_XPATH");

							} else {
								verificationFailedMessage("The edit button is not displayed.");
							}
						} catch (Throwable t) {
							verificationFailedMessage("The edit button is not displayed.");
						}

					} else {
						verificationFailedMessage("The newly created custom form is not displayed.");
					}

				} catch (Throwable t) {
					verificationFailedMessage("The newly created custom form is not displayed.");
				}

				// click on the home icon from the top of the screen
				click("questionnaire_homeburgermenubtn_hide_CSS");

				// wait for the element
				explicitWait("propertylist_title_XPATH");

				// verify the property list
				switchVerification("propertylist_title_XPATH", "Property List", "The property list is not displayed.");

				// VALIDATE ON PORTFOLIO SUMMARY DASHBOARD
				consoleMessage("VALIDATE ON PORTFOLIO SUMMARY DASHBOARD");

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

				// validate the delete button is displayed in the newly created custom form from
				// the portfolio dashboard screen
				try {
					String customForm1 = "//td[text()='" + data.get("name") + "']";
					String customForm1_actual = (driver.findElement(By.xpath(customForm1)).getText()).trim();

					if (customForm1_actual.equals(data.get("name"))) {

						// click on the newly created custom form
						String customFormName = "//td[text()='" + data.get("name") + "']";
						driver.findElement(By.xpath(customFormName)).click();
						consoleMessage("Clicked on the newly created custom form.");

						// click on the property one
						click("customform_portfoliodashboard_propertyname_XPATH");

						// scroll down the screen
						scrollBottom();

						// validate the input fields are displayed in one page tab
						try {
							boolean editbtn1 = driver
									.findElement(By
											.xpath(OR.getProperty("customform_portfoliodashboard_editfieldbtn_XPATH")))
									.isDisplayed();

							if (editbtn1 == true) {

								successMessage("The edit button is displayed as expected.");

								// click on the edit field button
								click("customform_portfoliodashboard_editfieldbtn_XPATH");

								// validate first input field of the one page tab is displayed as per the
								// permission
								try {
									String Field1 = "//input[@id='" + fieldName1 + "TEXT']";
									boolean Field1_actual = driver.findElement(By.xpath(Field1)).isDisplayed();

									if (Field1_actual == true) {

										successMessage("The first input field is displayed as expected.");

									} else {
										verificationFailedMessage("The first input field is not displayed.");
									}
								} catch (Throwable t) {
									verificationFailedMessage("The first input field is not displayed.");
								}

								// validate second input field of the one page tab is displayed as per the
								// permission
								try {
									String Field2 = "//input[@id='" + fieldName2 + "NUMBER']";
									boolean Field2_actual = driver.findElement(By.xpath(Field2)).isDisplayed();

									if (Field2_actual == true) {

										successMessage("The second input field is displayed as expected.");

									} else {
										verificationFailedMessage("The second input field is not displayed.");
									}
								} catch (Throwable t) {
									verificationFailedMessage("The second input field is not displayed.");
								}

								// click on the field save button
								click("customform_portfoliodashboard_fields_savebtn_XPATH");

							} else {
								verificationFailedMessage("The edit button is not displayed.");
							}
						} catch (Throwable t) {
							verificationFailedMessage("The edit button is not displayed.");
						}

						// click on the first page name tab
						String pageTab1 = "//span[text()='" + pageName1 + "']";
						driver.findElement(By.xpath(pageTab1)).click();
						consoleMessage("Clicked on the first page name tab.");

						// scroll down the screen
						scrollBottom();

						// validate the input fields are displayed in one page tab
						try {
							boolean editbtn1 = driver
									.findElement(By
											.xpath(OR.getProperty("customform_portfoliodashboard_editfieldbtn_XPATH")))
									.isDisplayed();

							if (editbtn1 == true) {

								successMessage("The edit button is displayed as expected.");

								// click on the edit field button
								click("customform_portfoliodashboard_editfieldbtn_XPATH");

								// validate first input field of the one page tab is displayed as per the
								// permission
								try {
									String Field1 = "//input[@id='" + pageFieldName1 + "TEXT']";
									boolean Field1_actual = driver.findElement(By.xpath(Field1)).isDisplayed();

									if (Field1_actual == true) {

										successMessage("The first input field is displayed as expected.");

									} else {
										verificationFailedMessage("The first input field is not displayed.");
									}
								} catch (Throwable t) {
									verificationFailedMessage("The first input field is not displayed.");
								}

								// validate second input field of the one page tab is displayed as per the
								// permission
								try {
									String Field2 = "//input[@id='" + pageFieldName2 + "NUMBER']";
									boolean Field2_actual = driver.findElement(By.xpath(Field2)).isDisplayed();

									if (Field2_actual == true) {

										successMessage("The second input field is displayed as expected.");

									} else {
										verificationFailedMessage("The second input field is not displayed.");
									}
								} catch (Throwable t) {
									verificationFailedMessage("The second input field is not displayed.");
								}

								// click on the field save button
								click("customform_portfoliodashboard_fields_savebtn_XPATH");

							} else {
								verificationFailedMessage("The edit button is not displayed.");
							}
						} catch (Throwable t) {
							verificationFailedMessage("The edit button is not displayed.");
						}

					} else {
						verificationFailedMessage("The newly created custom form is not displayed");
					}

				} catch (Throwable t) {
					verificationFailedMessage("The newly created custom form is not displayed");
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

			// LOGOUT THE SESSION FROM THE PROPERTY MANAGER - JINESH USER AND LOGIN TO ADMIN
			// USER
			title("LOGOUT THE SESSION FROM THE PROPERTY MANAGER - JINESH USER AND LOGIN TO ADMIN USER");

			// wait for the element
			Thread.sleep(5000);

			// click on the settings icon from the top of the screen
			click("questionnaire_settingicon_CSS");

			// wait for the element
			Thread.sleep(5000);

			// click on the logout option from the side menu
			click("sidemenu_logout_CSS");

			// login with valid credentials
			helper.loginAndUpdateSystemCompany(data, "username_1", "password_1", "system_company_1");

		} catch (Throwable t) {
			helper.questionnaireNotDisplayLogout(data);
		}

		// UPDATE THE FIELD SECURITY PERMISSION OF THE CUSTOMER FORM FOR THE CONTRACTOR
		title("UPDATE THE FIELD SECURITY PERMISSION OF THE CUSTOMER FORM FOR THE CONTRACTOR");

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

			// click on the newly created custom record record
			String nameTitle = "//td[text()='" + data.get("name") + "']";
			driver.findElement(By.xpath(nameTitle)).click();
			consoleMessage("Clicked on the newly created custom record record.");

			// scroll down the screen
			scrollBottom();

			// click on the lock button
			String field11 = "//span[text()='" + fieldName1
					+ "']//following-sibling::span//button[@ng-click='getFieldSecurityData(item.id)']";
			driver.findElement(By.xpath(field11)).click();
			consoleMessage("Clicked on the lock button.");

			// click on the user field
			click("customform_addfield_lockbtn_usertxt_XPATH");

			// click on the none button
			click("customform_securitytab_nonebtn_XPATH");

			// click on the user field
			click("customform_addfield_lockbtn_usertxt_XPATH");

			// click on the save button
			click("customform_addfield_lockbtn_savebtn_XPATH");

			// wait for the element
			Thread.sleep(5000);

			// scroll down the screen
			scrollBottom();

			// click on the lock button
			String field12 = "//span[text()='" + fieldName2
					+ "']//following-sibling::span//button[@ng-click='getFieldSecurityData(item.id)']";
			driver.findElement(By.xpath(field12)).click();
			consoleMessage("Clicked on the lock button.");

			// click on the role field
			click("customform_addfield_lockbtn_roletxt_XPATH");

			// click on the none button
			click("customform_securitytab_nonebtn_XPATH");

			// enter the user role in the search field
			type("customform_addfield_dropdowndd_searchtxt_XPATH", data.get("role1"));

			// click on the searched result
			click("customform_securitytab_searchedresult2_XPATH");

			// click on the role field
			click("customform_addfield_lockbtn_roletxt_XPATH");

			// click on the save button
			click("customform_addfield_lockbtn_savebtn_XPATH");

			// click on the first page name tab
			String page1 = "//span[contains(text(),'" + pageName1 + "')]";
			driver.findElement(By.xpath(page1)).click();
			consoleMessage("Clicked on the first page name tab.");

			// scroll down the screen
			scrollBottom();

			// click on the lock button
			String field13 = "//span[text()='" + pageFieldName1
					+ "']//following-sibling::span//button[@ng-click='getFieldSecurityData(item.id)']";
			driver.findElement(By.xpath(field13)).click();
			consoleMessage("Clicked on the lock button.");

			// click on the role field
			click("customform_addfield_lockbtn_roletxt_XPATH");

			// click on the none button
			click("customform_securitytab_nonebtn_XPATH");

			// enter the user role in the search field
			type("customform_addfield_dropdowndd_searchtxt_XPATH", data.get("role1"));

			// click on the searched result
			click("customform_securitytab_searchedresult2_XPATH");

			// click on the role field
			click("customform_addfield_lockbtn_roletxt_XPATH");

			// click on the save button
			click("customform_addfield_lockbtn_savebtn_XPATH");

			// wait for the element
			Thread.sleep(5000);

			// scroll down the screen
			scrollBottom();

			// click on the lock button
			String field14 = "//span[text()='" + pageFieldName2
					+ "']//following-sibling::span//button[@ng-click='getFieldSecurityData(item.id)']";
			driver.findElement(By.xpath(field14)).click();
			consoleMessage("Clicked on the lock button.");

			// click on the user field
			click("customform_addfield_lockbtn_usertxt_XPATH");

			// click on the none button
			click("customform_securitytab_nonebtn_XPATH");

			// click on the user field
			click("customform_addfield_lockbtn_usertxt_XPATH");

			// click on the save button
			click("customform_addfield_lockbtn_savebtn_XPATH");

		} catch (Throwable t) {
			verificationFailed();
		}

		// click on the home icon from the top of the screen
		click("questionnaire_homeburgermenubtn_CSS");

		// wait for the element
		explicitWait("propertylist_title_XPATH");

		// verify the property list
		switchVerification("propertylist_title_XPATH", "Property List", "The property list is not displayed.");

		// VALIDATE THE FIELDS AS PER THE PERMISSION OF THE CUSTOM REPORT IN THE
		// PROPERTY SUMMARY DASHBOARD AND PORTFOLIO DASHBOARD - ADMIN USER
		title("VALIDATE THE FIELDS AS PER THE PERMISSION OF THE CUSTOM REPORT IN THE PROPERTY SUMMARY DASHBOARD AND PORTFOLIO DASHBOARD - ADMIN USER");

		try {

			// VALIDATE ON PROPERTY SUMMARY DASHBOARD SCREEN
			title("VALIDATE ON PROPERTY SUMMARY DASHBOARD SCREEN");

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

					// click on the newly created custom form
					String customFormName = "//td[text()='" + data.get("name") + "']";
					driver.findElement(By.xpath(customFormName)).click();
					consoleMessage("Clicked on the newly created custom form.");

					// click on the newly created record
					String record = "//span[text()='" + field1Detail + "']";
					driver.findElement(By.xpath(record)).click();
					consoleMessage("Clicked on the newly created record.");

					// scroll down the screen
					scrollBottom();

					// validate the input fields are displayed in general tab
					try {
						boolean editbtn1 = driver
								.findElement(
										By.xpath(OR.getProperty("customform_portfoliodashboard_editfieldbtn_XPATH")))
								.isDisplayed();

						if (editbtn1 == true) {

							successMessage("The edit button is displayed as expected.");

							// click on the edit field button
							click("customform_portfoliodashboard_editfieldbtn_XPATH");

							// validate first input field of the general tab is displayed as per the
							// permission
							try {
								String Field1 = "//input[@id='" + fieldName1 + "TEXT']";
								boolean Field1_actual = driver.findElement(By.xpath(Field1)).isDisplayed();

								if (Field1_actual == true) {

									successMessage("The first input field is displayed as expected.");

								} else {
									verificationFailedMessage("The first input field is not displayed.");
								}
							} catch (Throwable t) {
								verificationFailedMessage("The first input field is not displayed.");
							}

							// validate second input field of the general tab is displayed as per the
							// permission
							try {
								String Field2 = "//input[@id='" + fieldName2 + "NUMBER']";
								boolean Field2_actual = driver.findElement(By.xpath(Field2)).isDisplayed();

								if (Field2_actual == true) {

									verificationFailedMessage("The second input field is displayed.");

								} else {
									successMessage("The second input field is not displayed as expected.");
								}
							} catch (Throwable t) {
								successMessage("The second input field is not displayed as expected.");
							}

							// click on the field save button
							click("customform_portfoliodashboard_fields_savebtn_XPATH");

						} else {
							verificationFailedMessage("The edit button is not displayed.");
						}
					} catch (Throwable t) {
						verificationFailedMessage("The edit button is not displayed.");
					}

					// click on the first page name tab
					String pageTab1 = "//span[text()='" + pageName1 + "']";
					driver.findElement(By.xpath(pageTab1)).click();
					consoleMessage("Clicked on the first page name tab.");

					// scroll down the screen
					scrollBottom();

					// validate the input fields are displayed in one page tab
					try {
						boolean editbtn1 = driver
								.findElement(
										By.xpath(OR.getProperty("customform_portfoliodashboard_editfieldbtn_XPATH")))
								.isDisplayed();

						if (editbtn1 == true) {

							successMessage("The edit button is displayed as expected.");

							// click on the edit field button
							click("customform_portfoliodashboard_editfieldbtn_XPATH");

							// validate first input field of the one page tab is displayed as per the
							// permission
							try {
								String Field1 = "//input[@id='" + pageFieldName1 + "TEXT']";
								boolean Field1_actual = driver.findElement(By.xpath(Field1)).isDisplayed();

								if (Field1_actual == true) {

									verificationFailedMessage("The first input field is displayed.");

								} else {
									successMessage("The first input field is not displayed as expected.");
								}
							} catch (Throwable t) {
								successMessage("The first input field is not displayed as expected.");
							}

							// validate second input field of the one page tab is displayed as per the
							// permission
							try {
								String Field2 = "//input[@id='" + pageFieldName2 + "NUMBER']";
								boolean Field2_actual = driver.findElement(By.xpath(Field2)).isDisplayed();

								if (Field2_actual == true) {

									successMessage("The second input field is displayed as expected.");

								} else {
									verificationFailedMessage("The second input field is not displayed.");
								}
							} catch (Throwable t) {
								verificationFailedMessage("The second input field is not displayed.");
							}

							// click on the field save button
							click("customform_portfoliodashboard_fields_savebtn_XPATH");

						} else {
							verificationFailedMessage("The edit button is not displayed.");
						}
					} catch (Throwable t) {
						verificationFailedMessage("The edit button is not displayed.");
					}

				} else {
					verificationFailedMessage("The newly created custom form is not displayed.");
				}

			} catch (Throwable t) {
				verificationFailedMessage("The newly created custom form is not displayed.");
			}

			// click on the home icon from the top of the screen
			click("questionnaire_homeburgermenubtn_hide_CSS");

			// wait for the element
			explicitWait("propertylist_title_XPATH");

			// verify the property list
			switchVerification("propertylist_title_XPATH", "Property List", "The property list is not displayed.");

			// VALIDATE ON PORTFOLIO SUMMARY DASHBOARD
			consoleMessage("VALIDATE ON PORTFOLIO SUMMARY DASHBOARD");

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

			// validate the delete button is displayed in the newly created custom form from
			// the portfolio dashboard screen
			try {
				String customForm1 = "//td[text()='" + data.get("name") + "']";
				String customForm1_actual = (driver.findElement(By.xpath(customForm1)).getText()).trim();

				if (customForm1_actual.equals(data.get("name"))) {

					// click on the newly created custom form
					String customFormName = "//td[text()='" + data.get("name") + "']";
					driver.findElement(By.xpath(customFormName)).click();
					consoleMessage("Clicked on the newly created custom form.");

					// click on the property one
					click("customform_portfoliodashboard_propertyname_XPATH");

					// scroll down the screen
					scrollBottom();

					// validate the input fields are displayed in one page tab
					try {
						boolean editbtn1 = driver
								.findElement(
										By.xpath(OR.getProperty("customform_portfoliodashboard_editfieldbtn_XPATH")))
								.isDisplayed();

						if (editbtn1 == true) {

							successMessage("The edit button is displayed as expected.");

							// click on the edit field button
							click("customform_portfoliodashboard_editfieldbtn_XPATH");

							// validate first input field of the one page tab is displayed as per the
							// permission
							try {
								String Field1 = "//input[@id='" + fieldName1 + "TEXT']";
								boolean Field1_actual = driver.findElement(By.xpath(Field1)).isDisplayed();

								if (Field1_actual == true) {

									successMessage("The first input field is displayed as expected.");

								} else {
									verificationFailedMessage("The first input field is not displayed.");
								}
							} catch (Throwable t) {
								verificationFailedMessage("The first input field is not displayed.");
							}

							// validate second input field of the one page tab is displayed as per the
							// permission
							try {
								String Field2 = "//input[@id='" + fieldName2 + "NUMBER']";
								boolean Field2_actual = driver.findElement(By.xpath(Field2)).isDisplayed();

								if (Field2_actual == true) {

									verificationFailedMessage("The second input field is displayed.");

								} else {
									successMessage("The second input field is not displayed as expected.");
								}
							} catch (Throwable t) {
								successMessage("The second input field is not displayed as expected.");
							}

							// click on the field save button
							click("customform_portfoliodashboard_fields_savebtn_XPATH");

						} else {
							verificationFailedMessage("The edit button is not displayed.");
						}
					} catch (Throwable t) {
						verificationFailedMessage("The edit button is not displayed.");
					}

					// click on the first page name tab
					String pageTab1 = "//span[text()='" + pageName1 + "']";
					driver.findElement(By.xpath(pageTab1)).click();
					consoleMessage("Clicked on the first page name tab.");

					// scroll down the screen
					scrollBottom();

					// validate the input fields are displayed in one page tab
					try {
						boolean editbtn1 = driver
								.findElement(
										By.xpath(OR.getProperty("customform_portfoliodashboard_editfieldbtn_XPATH")))
								.isDisplayed();

						if (editbtn1 == true) {

							successMessage("The edit button is displayed as expected.");

							// click on the edit field button
							click("customform_portfoliodashboard_editfieldbtn_XPATH");

							// validate first input field of the one page tab is displayed as per the
							// permission
							try {
								String Field1 = "//input[@id='" + pageFieldName1 + "TEXT']";
								boolean Field1_actual = driver.findElement(By.xpath(Field1)).isDisplayed();

								if (Field1_actual == true) {

									verificationFailedMessage("The first input field is displayed.");

								} else {
									successMessage("The first input field is not displayed as expected.");
								}
							} catch (Throwable t) {
								successMessage("The first input field is not displayed as expected.");
							}

							// validate second input field of the one page tab is displayed as per the
							// permission
							try {
								String Field2 = "//input[@id='" + pageFieldName2 + "NUMBER']";
								boolean Field2_actual = driver.findElement(By.xpath(Field2)).isDisplayed();

								if (Field2_actual == true) {

									successMessage("The second input field is displayed as expected.");

								} else {
									verificationFailedMessage("The second input field is not displayed.");
								}
							} catch (Throwable t) {
								verificationFailedMessage("The second input field is not displayed.");
							}

							// click on the field save button
							click("customform_portfoliodashboard_fields_savebtn_XPATH");

						} else {
							verificationFailedMessage("The edit button is not displayed.");
						}
					} catch (Throwable t) {
						verificationFailedMessage("The edit button is not displayed.");
					}

				} else {
					verificationFailedMessage("The newly created custom form is not displayed");
				}

			} catch (Throwable t) {
				verificationFailedMessage("The newly created custom form is not displayed");
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

		// LOGOUT THE SESSION FROM THE ADMIN USER AND LOGIN TO PROPERTY MANAGER -
		// JINESH
		title("LOGOUT THE SESSION FROM THE ADMIN USER AND LOGIN TO PROPERTY MANAGER - JINESH");

		try {
			// wait for the element
			Thread.sleep(5000);

			// click on the settings icon from the top of the screen
			click("questionnaire_settingicon_userupdate_CSS");

			// wait for the element
			explicitWaitClickable("sidemenu_logout_CSS");

			// click on the logout option from the side menu
			click("sidemenu_logout_CSS");

			// login with valid credentials
			helper.loginAndUpdateSystemCompany(data, "username", "password", "system_company_1");

			// VALIDATE THE FIELDS AS PER THE PERMISSION OF THE CUSTOM REPORT IN THE
			// PROPERTY SUMMARY DASHBOARD AND PORTFOLIO SUMMARY DASHBOARD - PROPERTY MANAGER
			// USER - JINESH
			title("VALIDATE THE FIELDS AS PER THE PERMISSION OF THE CUSTOM REPORT IN THE PROPERTY SUMMARY DASHBOARD AND PORTFOLIO SUMMARY DASHBOARD - PROPERTY MANAGER USER - JINESH");

			try {

				// VALIDATE ON PROPERTY SUMMARY DASHBOARD SCREEN
				title("VALIDATE ON PROPERTY SUMMARY DASHBOARD SCREEN");

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

						// click on the newly created custom form
						String customFormName = "//td[text()='" + data.get("name") + "']";
						driver.findElement(By.xpath(customFormName)).click();
						consoleMessage("Clicked on the newly created custom form.");

						// click on the newly created record
						String record = "//span[text()='" + field1Detail + "']";
						driver.findElement(By.xpath(record)).click();
						consoleMessage("Clicked on the newly created record.");

						// scroll down the screen
						scrollBottom();

						// validate the input fields are displayed in general tab
						try {
							boolean editbtn1 = driver
									.findElement(By
											.xpath(OR.getProperty("customform_portfoliodashboard_editfieldbtn_XPATH")))
									.isDisplayed();

							if (editbtn1 == true) {

								successMessage("The edit button is displayed as expected.");

								// click on the edit field button
								click("customform_portfoliodashboard_editfieldbtn_XPATH");

								// validate first input field of the general tab is displayed as per the
								// permission
								try {
									String Field1 = "//input[@id='" + fieldName1 + "TEXT']";
									boolean Field1_actual = driver.findElement(By.xpath(Field1)).isDisplayed();

									if (Field1_actual == true) {

										successMessage("The first input field is displayed as expected.");

									} else {
										verificationFailedMessage("The first input field is not displayed.");
									}
								} catch (Throwable t) {
									verificationFailedMessage("The first input field is not displayed.");
								}

								// validate second input field of the general tab is displayed as per the
								// permission
								try {
									String Field2 = "//input[@id='" + fieldName2 + "NUMBER']";
									boolean Field2_actual = driver.findElement(By.xpath(Field2)).isDisplayed();

									if (Field2_actual == true) {

										verificationFailedMessage("The second input field is displayed.");

									} else {
										successMessage("The second input field is not displayed as expected.");
									}
								} catch (Throwable t) {
									successMessage("The second input field is not displayed as expected.");
								}

								// click on the field save button
								click("customform_portfoliodashboard_fields_savebtn_XPATH");

							} else {
								verificationFailedMessage("The edit button is not displayed.");
							}
						} catch (Throwable t) {
							verificationFailedMessage("The edit button is not displayed.");
						}

						// click on the first page name tab
						String pageTab1 = "//span[text()='" + pageName1 + "']";
						driver.findElement(By.xpath(pageTab1)).click();
						consoleMessage("Clicked on the first page name tab.");

						// scroll down the screen
						scrollBottom();

						// validate the input fields are displayed in one page tab
						try {
							boolean editbtn1 = driver
									.findElement(By
											.xpath(OR.getProperty("customform_portfoliodashboard_editfieldbtn_XPATH")))
									.isDisplayed();

							if (editbtn1 == true) {

								successMessage("The edit button is displayed as expected.");

								// click on the edit field button
								click("customform_portfoliodashboard_editfieldbtn_XPATH");

								// validate first input field of the one page tab is displayed as per the
								// permission
								try {
									String Field1 = "//input[@id='" + pageFieldName1 + "TEXT']";
									boolean Field1_actual = driver.findElement(By.xpath(Field1)).isDisplayed();

									if (Field1_actual == true) {

										verificationFailedMessage("The first input field is displayed.");

									} else {
										successMessage("The first input field is not displayed as expected.");
									}
								} catch (Throwable t) {
									successMessage("The first input field is not displayed as expected.");
								}

								// validate second input field of the one page tab is displayed as per the
								// permission
								try {
									String Field2 = "//input[@id='" + pageFieldName2 + "NUMBER']";
									boolean Field2_actual = driver.findElement(By.xpath(Field2)).isDisplayed();

									if (Field2_actual == true) {

										successMessage("The second input field is displayed as expected.");

									} else {
										verificationFailedMessage("The second input field is not displayed.");
									}
								} catch (Throwable t) {
									verificationFailedMessage("The second input field is not displayed.");
								}

								// click on the field save button
								click("customform_portfoliodashboard_fields_savebtn_XPATH");

							} else {
								verificationFailedMessage("The edit button is not displayed.");
							}
						} catch (Throwable t) {
							verificationFailedMessage("The edit button is not displayed.");
						}

					} else {
						verificationFailedMessage("The newly created custom form is not displayed.");
					}

				} catch (Throwable t) {
					verificationFailedMessage("The newly created custom form is not displayed.");
				}

				// click on the home icon from the top of the screen
				click("questionnaire_homeburgermenubtn_hide_CSS");

				// wait for the element
				explicitWait("propertylist_title_XPATH");

				// verify the property list
				switchVerification("propertylist_title_XPATH", "Property List", "The property list is not displayed.");

				// VALIDATE ON PORTFOLIO SUMMARY DASHBOARD
				consoleMessage("VALIDATE ON PORTFOLIO SUMMARY DASHBOARD");

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

				// validate the delete button is displayed in the newly created custom form from
				// the portfolio dashboard screen
				try {
					String customForm1 = "//td[text()='" + data.get("name") + "']";
					String customForm1_actual = (driver.findElement(By.xpath(customForm1)).getText()).trim();

					if (customForm1_actual.equals(data.get("name"))) {

						// click on the newly created custom form
						String customFormName = "//td[text()='" + data.get("name") + "']";
						driver.findElement(By.xpath(customFormName)).click();
						consoleMessage("Clicked on the newly created custom form.");

						// click on the property one
						click("customform_portfoliodashboard_propertyname_XPATH");

						// scroll down the screen
						scrollBottom();

						// validate the input fields are displayed in one page tab
						try {
							boolean editbtn1 = driver
									.findElement(By
											.xpath(OR.getProperty("customform_portfoliodashboard_editfieldbtn_XPATH")))
									.isDisplayed();

							if (editbtn1 == true) {

								successMessage("The edit button is displayed as expected.");

								// click on the edit field button
								click("customform_portfoliodashboard_editfieldbtn_XPATH");

								// validate first input field of the one page tab is displayed as per the
								// permission
								try {
									String Field1 = "//input[@id='" + fieldName1 + "TEXT']";
									boolean Field1_actual = driver.findElement(By.xpath(Field1)).isDisplayed();

									if (Field1_actual == true) {

										successMessage("The first input field is displayed as expected.");

									} else {
										verificationFailedMessage("The first input field is not displayed.");
									}
								} catch (Throwable t) {
									verificationFailedMessage("The first input field is not displayed.");
								}

								// validate second input field of the one page tab is displayed as per the
								// permission
								try {
									String Field2 = "//input[@id='" + fieldName2 + "NUMBER']";
									boolean Field2_actual = driver.findElement(By.xpath(Field2)).isDisplayed();

									if (Field2_actual == true) {

										verificationFailedMessage("The second input field is displayed.");

									} else {
										successMessage("The second input field is not displayed as expected.");
									}
								} catch (Throwable t) {
									successMessage("The second input field is not displayed as expected.");
								}

								// click on the field save button
								click("customform_portfoliodashboard_fields_savebtn_XPATH");

							} else {
								verificationFailedMessage("The edit button is not displayed.");
							}
						} catch (Throwable t) {
							verificationFailedMessage("The edit button is not displayed.");
						}

						// click on the first page name tab
						String pageTab1 = "//span[text()='" + pageName1 + "']";
						driver.findElement(By.xpath(pageTab1)).click();
						consoleMessage("Clicked on the first page name tab.");

						// scroll down the screen
						scrollBottom();

						// validate the input fields are displayed in one page tab
						try {
							boolean editbtn1 = driver
									.findElement(By
											.xpath(OR.getProperty("customform_portfoliodashboard_editfieldbtn_XPATH")))
									.isDisplayed();

							if (editbtn1 == true) {

								successMessage("The edit button is displayed as expected.");

								// click on the edit field button
								click("customform_portfoliodashboard_editfieldbtn_XPATH");

								// validate first input field of the one page tab is displayed as per the
								// permission
								try {
									String Field1 = "//input[@id='" + pageFieldName1 + "TEXT']";
									boolean Field1_actual = driver.findElement(By.xpath(Field1)).isDisplayed();

									if (Field1_actual == true) {

										verificationFailedMessage("The first input field is displayed.");

									} else {
										successMessage("The first input field is not displayed as expected.");
									}
								} catch (Throwable t) {
									successMessage("The first input field is not displayed as expected.");
								}

								// validate second input field of the one page tab is displayed as per the
								// permission
								try {
									String Field2 = "//input[@id='" + pageFieldName2 + "NUMBER']";
									boolean Field2_actual = driver.findElement(By.xpath(Field2)).isDisplayed();

									if (Field2_actual == true) {

										successMessage("The second input field is displayed as expected.");

									} else {
										verificationFailedMessage("The second input field is not displayed.");
									}
								} catch (Throwable t) {
									verificationFailedMessage("The second input field is not displayed.");
								}

								// click on the field save button
								click("customform_portfoliodashboard_fields_savebtn_XPATH");

							} else {
								verificationFailedMessage("The edit button is not displayed.");
							}
						} catch (Throwable t) {
							verificationFailedMessage("The edit button is not displayed.");
						}

					} else {
						verificationFailedMessage("The newly created custom form is not displayed");
					}

				} catch (Throwable t) {
					verificationFailedMessage("The newly created custom form is not displayed");
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

			// LOGOUT THE SESSION FROM THE PROPERTY MANAGER - JINESH USER AND LOGIN TO ADMIN
			// USER
			title("LOGOUT THE SESSION FROM THE PROPERTY MANAGER - JINESH USER AND LOGIN TO ADMIN USER");

			// wait for the element
			Thread.sleep(5000);

			// click on the settings icon from the top of the screen
			click("questionnaire_settingicon_CSS");

			// wait for the element
			Thread.sleep(5000);

			// click on the logout option from the side menu
			click("sidemenu_logout_CSS");

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

			// wait for the element
			explicitWaitClickable("sidemenu_logout_CSS");

			// click on the logout option from the side menu
			click("sidemenu_logout_CSS");

			// login with valid credentials
			helper.loginAndUpdateSystemCompany(data, "username_2", "password_2", "system_company_1");

			// VALIDATE THE FIELDS AS PER THE PERMISSION OF THE CUSTOM REPORT IN THE
			// PROPERTY SUMMARY DASHBOARD AND PORTFOLIO SUMMARY DASHBOARD - CONTRACTOR USER
			// - JINESH CONTRACTOR
			title("VALIDATE THE FIELDS AS PER THE PERMISSION OF THE CUSTOM REPORT IN THE PROPERTY SUMMARY DASHBOARD AND PORTFOLIO SUMMARY DASHBOARD - CONTRACTOR USER - JINESH CONTRACTOR");

			try {

				// VALIDATE ON PROPERTY SUMMARY DASHBOARD SCREEN
				title("VALIDATE ON PROPERTY SUMMARY DASHBOARD SCREEN");

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

						// click on the newly created custom form
						String customFormName = "//td[text()='" + data.get("name") + "']";
						driver.findElement(By.xpath(customFormName)).click();
						consoleMessage("Clicked on the newly created custom form.");

						// click on the newly created record
						String record = "//span[text()='" + field1Detail + "']";
						driver.findElement(By.xpath(record)).click();
						consoleMessage("Clicked on the newly created record.");

						// scroll down the screen
						scrollBottom();

						// validate the input fields are displayed in general tab
						try {
							boolean editbtn1 = driver
									.findElement(By
											.xpath(OR.getProperty("customform_portfoliodashboard_editfieldbtn_XPATH")))
									.isDisplayed();

							if (editbtn1 == true) {

								successMessage("The edit button is displayed as expected.");

								// click on the edit field button
								click("customform_portfoliodashboard_editfieldbtn_XPATH");

								// validate first input field of the general tab is displayed as per the
								// permission
								try {
									String Field1 = "//input[@id='" + fieldName1 + "TEXT']";
									boolean Field1_actual = driver.findElement(By.xpath(Field1)).isDisplayed();

									if (Field1_actual == true) {

										successMessage("The first input field is displayed as expected.");

									} else {
										verificationFailedMessage("The first input field is not displayed.");
									}
								} catch (Throwable t) {
									verificationFailedMessage("The first input field is not displayed.");
								}

								// validate second input field of the general tab is displayed as per the
								// permission
								try {
									String Field2 = "//input[@id='" + fieldName2 + "NUMBER']";
									boolean Field2_actual = driver.findElement(By.xpath(Field2)).isDisplayed();

									if (Field2_actual == true) {
										successMessage("The second input field is displayed as expected.");

									} else {
										verificationFailedMessage("The second input field is not displayed.");
									}
								} catch (Throwable t) {
									verificationFailedMessage("The second input field is not displayed.");
								}

								// click on the field save button
								click("customform_portfoliodashboard_fields_savebtn_XPATH");

							} else {
								verificationFailedMessage("The edit button is not displayed.");
							}
						} catch (Throwable t) {
							verificationFailedMessage("The edit button is not displayed.");
						}

						// click on the first page name tab
						String pageTab1 = "//span[text()='" + pageName1 + "']";
						driver.findElement(By.xpath(pageTab1)).click();
						consoleMessage("Clicked on the first page name tab.");

						// scroll down the screen
						scrollBottom();

						// validate the input fields are displayed in one page tab
						try {
							boolean editbtn1 = driver
									.findElement(By
											.xpath(OR.getProperty("customform_portfoliodashboard_editfieldbtn_XPATH")))
									.isDisplayed();

							if (editbtn1 == true) {

								successMessage("The edit button is displayed as expected.");

								// click on the edit field button
								click("customform_portfoliodashboard_editfieldbtn_XPATH");

								// validate first input field of the one page tab is displayed as per the
								// permission
								try {
									String Field1 = "//input[@id='" + pageFieldName1 + "TEXT']";
									boolean Field1_actual = driver.findElement(By.xpath(Field1)).isDisplayed();

									if (Field1_actual == true) {

										successMessage("The first input field is displayed as expected.");

									} else {
										verificationFailedMessage("The first input field is not displayed.");
									}
								} catch (Throwable t) {
									verificationFailedMessage("The first input field is not displayed.");
								}

								// validate second input field is displayed as per the
								// permission
								try {
									String Field2 = "//input[@id='" + pageFieldName2 + "NUMBER']";
									boolean Field2_actual = driver.findElement(By.xpath(Field2)).isDisplayed();

									if (Field2_actual == true) {

										successMessage("The second input field is displayed as expected.");

									} else {
										verificationFailedMessage("The second input field is not displayed.");
									}
								} catch (Throwable t) {
									verificationFailedMessage("The second input field is not displayed.");
								}

								// click on the field save button
								click("customform_portfoliodashboard_fields_savebtn_XPATH");

							} else {
								verificationFailedMessage("The edit button is not displayed.");
							}
						} catch (Throwable t) {
							verificationFailedMessage("The edit button is not displayed.");
						}

					} else {
						verificationFailedMessage("The newly created custom form is not displayed.");
					}

				} catch (Throwable t) {
					verificationFailedMessage("The newly created custom form is not displayed.");
				}

				// click on the home icon from the top of the screen
				click("questionnaire_homeburgermenubtn_hide_CSS");

				// wait for the element
				explicitWait("propertylist_title_XPATH");

				// verify the property list
				switchVerification("propertylist_title_XPATH", "Property List", "The property list is not displayed.");

				// VALIDATE ON PORTFOLIO SUMMARY DASHBOARD
				consoleMessage("VALIDATE ON PORTFOLIO SUMMARY DASHBOARD");

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

				// validate the delete button is displayed in the newly created custom form from
				// the portfolio dashboard screen
				try {
					String customForm1 = "//td[text()='" + data.get("name") + "']";
					String customForm1_actual = (driver.findElement(By.xpath(customForm1)).getText()).trim();

					if (customForm1_actual.equals(data.get("name"))) {

						// click on the newly created custom form
						String customFormName = "//td[text()='" + data.get("name") + "']";
						driver.findElement(By.xpath(customFormName)).click();
						consoleMessage("Clicked on the newly created custom form.");

						// click on the property one
						click("customform_portfoliodashboard_propertyname_XPATH");

						// scroll down the screen
						scrollBottom();

						// validate the input fields are displayed in one page tab
						try {
							boolean editbtn1 = driver
									.findElement(By
											.xpath(OR.getProperty("customform_portfoliodashboard_editfieldbtn_XPATH")))
									.isDisplayed();

							if (editbtn1 == true) {

								successMessage("The edit button is displayed as expected.");

								// click on the edit field button
								click("customform_portfoliodashboard_editfieldbtn_XPATH");

								// validate first input field of the one page tab is displayed as per the
								// permission
								try {
									String Field1 = "//input[@id='" + fieldName1 + "TEXT']";
									boolean Field1_actual = driver.findElement(By.xpath(Field1)).isDisplayed();

									if (Field1_actual == true) {

										successMessage("The first input field is displayed as expected.");

									} else {
										verificationFailedMessage("The first input field is not displayed.");
									}
								} catch (Throwable t) {
									verificationFailedMessage("The first input field is not displayed.");
								}

								// validate second input field of the one page tab is displayed as per the
								// permission
								try {
									String Field2 = "//input[@id='" + fieldName2 + "NUMBER']";
									boolean Field2_actual = driver.findElement(By.xpath(Field2)).isDisplayed();

									if (Field2_actual == true) {

										successMessage("The second input field is displayed as expected.");

									} else {
										verificationFailedMessage("The second input field is not displayed.");
									}
								} catch (Throwable t) {
									verificationFailedMessage("The second input field is not displayed.");
								}

								// click on the field save button
								click("customform_portfoliodashboard_fields_savebtn_XPATH");

							} else {
								verificationFailedMessage("The edit button is not displayed.");
							}
						} catch (Throwable t) {
							verificationFailedMessage("The edit button is not displayed.");
						}

						// click on the first page name tab
						String pageTab1 = "//span[text()='" + pageName1 + "']";
						driver.findElement(By.xpath(pageTab1)).click();
						consoleMessage("Clicked on the first page name tab.");

						// scroll down the screen
						scrollBottom();

						// validate the input fields are displayed in one page tab
						try {
							boolean editbtn1 = driver
									.findElement(By
											.xpath(OR.getProperty("customform_portfoliodashboard_editfieldbtn_XPATH")))
									.isDisplayed();

							if (editbtn1 == true) {

								successMessage("The edit button is displayed as expected.");

								// click on the edit field button
								click("customform_portfoliodashboard_editfieldbtn_XPATH");

								// validate first input field of the one page tab is displayed as per the
								// permission
								try {
									String Field1 = "//input[@id='" + pageFieldName1 + "TEXT']";
									boolean Field1_actual = driver.findElement(By.xpath(Field1)).isDisplayed();

									if (Field1_actual == true) {

										successMessage("The first input field is displayed as expected.");

									} else {
										verificationFailedMessage("The first input field is not displayed.");
									}
								} catch (Throwable t) {
									verificationFailedMessage("The first input field is not displayed.");
								}

								// validate second input field of the one page tab is displayed as per the
								// permission
								try {
									String Field2 = "//input[@id='" + pageFieldName2 + "NUMBER']";
									boolean Field2_actual = driver.findElement(By.xpath(Field2)).isDisplayed();

									if (Field2_actual == true) {

										successMessage("The second input field is displayed as expected.");

									} else {
										verificationFailedMessage("The second input field is not displayed.");
									}
								} catch (Throwable t) {
									verificationFailedMessage("The second input field is not displayed.");
								}

								// click on the field save button
								click("customform_portfoliodashboard_fields_savebtn_XPATH");

							} else {
								verificationFailedMessage("The edit button is not displayed.");
							}
						} catch (Throwable t) {
							verificationFailedMessage("The edit button is not displayed.");
						}

					} else {
						verificationFailedMessage("The newly created custom form is not displayed");
					}

				} catch (Throwable t) {
					verificationFailedMessage("The newly created custom form is not displayed");
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

			// LOGOUT THE SESSION FROM THE CONTRACTOR - JINESH CONTRACTOR USER AND LOGIN TO
			// ADMIN USER
			title("LOGOUT THE SESSION FROM THE CONTRACTOR - JINESH CONTRACTOR USER AND LOGIN TO ADMIN USER");

			// wait for the element
			Thread.sleep(5000);

			// click on the settings icon from the top of the screen
			click("questionnaire_settingicon_CSS");

			// wait for the element
			Thread.sleep(5000);

			// click on the logout option from the side menu
			click("sidemenu_logout_CSS");

			// login with valid credentials
			helper.loginAndUpdateSystemCompany(data, "username_1", "password_1", "system_company_1");

		} catch (Throwable t) {
			helper.questionnaireNotDisplayLogout(data);
		}

		// UPDATE THE FIELD SECURITY PERMISSION OF THE CUSTOMER FORM FOR THE JINESH
		// (PROPERTY MANAGER) AND CONTRACTOR
		title("UPDATE THE FIELD SECURITY PERMISSION OF THE CUSTOMER FORM FOR THE JINESH (PROPERTY MANAGER) AND CONTRACTOR");

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

			// click on the newly created custom record record
			String nameTitle = "//td[text()='" + data.get("name") + "']";
			driver.findElement(By.xpath(nameTitle)).click();
			consoleMessage("Clicked on the newly created custom record record.");

			// wait for the element
			Thread.sleep(5000);

			// scroll down the screen
			scrollBottom();

			// click on the lock button
			String field12 = "//span[text()='" + fieldName2
					+ "']//following-sibling::span//button[@ng-click='getFieldSecurityData(item.id)']";
			driver.findElement(By.xpath(field12)).click();
			consoleMessage("Clicked on the lock button.");

			// click on the user field
			click("customform_addfield_lockbtn_usertxt_XPATH");

			// click on the none button
			click("customform_securitytab_nonebtn_XPATH");

			// enter the user name in the search field
			type("customform_addfield_dropdowndd_searchtxt_XPATH", data.get("user1"));

			// click on the searched result
			click("customform_securitytab_searchedresult1_XPATH");

			// click on the user field
			click("customform_addfield_lockbtn_usertxt_XPATH");

			// click on the role field
			click("customform_addfield_lockbtn_roletxt_XPATH");

			// click on the none button
			click("customform_securitytab_nonebtn_XPATH");

			// enter the user role in the search field
			type("customform_addfield_dropdowndd_searchtxt_XPATH", data.get("role1"));

			// click on the searched result
			click("customform_securitytab_searchedresult2_XPATH");

			// click on the role field
			click("customform_addfield_lockbtn_roletxt_XPATH");

			// click on the save button
			click("customform_addfield_lockbtn_savebtn_XPATH");

			// click on the first page name tab
			String page1 = "//span[contains(text(),'" + pageName1 + "')]";
			driver.findElement(By.xpath(page1)).click();
			consoleMessage("Clicked on the first page name tab.");

			// wait for the element
			Thread.sleep(5000);

			// scroll down the screen
			scrollBottom();

			// click on the lock button
			String field14 = "//span[text()='" + pageFieldName1
					+ "']//following-sibling::span//button[@ng-click='getFieldSecurityData(item.id)']";
			driver.findElement(By.xpath(field14)).click();
			consoleMessage("Clicked on the lock button.");

			// click on the user field
			click("customform_addfield_lockbtn_usertxt_XPATH");

			// click on the none button
			click("customform_securitytab_nonebtn_XPATH");

			// enter the user name in the search field
			type("customform_addfield_dropdowndd_searchtxt_XPATH", data.get("user1"));

			// click on the searched result
			click("customform_securitytab_searchedresult1_XPATH");

			// click on the user field
			click("customform_addfield_lockbtn_usertxt_XPATH");

			// click on the role field
			click("customform_addfield_lockbtn_roletxt_XPATH");

			// click on the none button
			click("customform_securitytab_nonebtn_XPATH");

			// enter the user role in the search field
			type("customform_addfield_dropdowndd_searchtxt_XPATH", data.get("role1"));

			// click on the searched result
			click("customform_securitytab_searchedresult2_XPATH");

			// click on the role field
			click("customform_addfield_lockbtn_roletxt_XPATH");

			// click on the save button
			click("customform_addfield_lockbtn_savebtn_XPATH");

			// wait for the element
			Thread.sleep(5000);

		} catch (Throwable t) {
			verificationFailed();
		}

		// click on the home icon from the top of the screen
		click("questionnaire_homeburgermenubtn_CSS");

		// wait for the element
		explicitWait("propertylist_title_XPATH");

		// verify the property list
		switchVerification("propertylist_title_XPATH", "Property List", "The property list is not displayed.");

		// VALIDATE THE FIELDS AS PER THE PERMISSION OF THE CUSTOM REPORT IN THE
		// PROPERTY SUMMARY DASHBOARD AND PORTFOLIO SUMMARY DASHBORD - ADMIN USER
		title("VALIDATE THE FIELDS AS PER THE PERMISSION OF THE CUSTOM REPORT IN THE PROPERTY SUMMARY DASHBOARD AND PORTFOLIO SUMMARY DASHBORD - ADMIN USER");

		try {

			// VALIDATE ON PROPERTY SUMMARY DASHBOARD SCREEN
			title("VALIDATE ON PROPERTY SUMMARY DASHBOARD SCREEN");

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

					// click on the newly created custom form
					String customFormName = "//td[text()='" + data.get("name") + "']";
					driver.findElement(By.xpath(customFormName)).click();
					consoleMessage("Clicked on the newly created custom form.");

					// click on the newly created record
					String record = "//span[text()='" + field1Detail + "']";
					driver.findElement(By.xpath(record)).click();
					consoleMessage("Clicked on the newly created record.");

					// scroll down the screen
					scrollBottom();

					// validate the input fields are displayed in general tab
					try {
						boolean editbtn1 = driver
								.findElement(
										By.xpath(OR.getProperty("customform_portfoliodashboard_editfieldbtn_XPATH")))
								.isDisplayed();

						if (editbtn1 == true) {

							successMessage("The edit button is displayed as expected.");

							// click on the edit field button
							click("customform_portfoliodashboard_editfieldbtn_XPATH");

							// validate first input field of the general tab is displayed as per the
							// permission
							try {
								String Field1 = "//input[@id='" + fieldName1 + "TEXT']";
								boolean Field1_actual = driver.findElement(By.xpath(Field1)).isDisplayed();

								if (Field1_actual == true) {

									successMessage("The first input field is displayed as expected.");

								} else {
									verificationFailedMessage("The first input field is not displayed.");
								}
							} catch (Throwable t) {
								verificationFailedMessage("The first input field is not displayed.");
							}

							// validate second input field of the general tab is displayed as per the
							// permission
							try {
								String Field2 = "//input[@id='" + fieldName2 + "NUMBER']";
								boolean Field2_actual = driver.findElement(By.xpath(Field2)).isDisplayed();

								if (Field2_actual == true) {

									verificationFailedMessage("The second input field is displayed.");

								} else {
									successMessage("The second input field is not displayed as expected.");
								}
							} catch (Throwable t) {
								successMessage("The second input field is not displayed as expected.");
							}

							// click on the field save button
							click("customform_portfoliodashboard_fields_savebtn_XPATH");

						} else {
							verificationFailedMessage("The edit button is not displayed.");
						}
					} catch (Throwable t) {
						verificationFailedMessage("The edit button is not displayed.");
					}

					// click on the first page name tab
					String pageTab1 = "//span[text()='" + pageName1 + "']";
					driver.findElement(By.xpath(pageTab1)).click();
					consoleMessage("Clicked on the first page name tab.");

					// scroll down the screen
					scrollBottom();

					// validate the input fields are displayed in one page tab
					try {
						boolean editbtn1 = driver
								.findElement(
										By.xpath(OR.getProperty("customform_portfoliodashboard_editfieldbtn_XPATH")))
								.isDisplayed();

						if (editbtn1 == true) {

							successMessage("The edit button is displayed as expected.");

							// click on the edit field button
							click("customform_portfoliodashboard_editfieldbtn_XPATH");

							// validate first input field of the one page tab is displayed as per the
							// permission
							try {
								String Field1 = "//input[@id='" + pageFieldName1 + "TEXT']";
								boolean Field1_actual = driver.findElement(By.xpath(Field1)).isDisplayed();

								if (Field1_actual == true) {

									verificationFailedMessage("The first input field is displayed.");

								} else {
									successMessage("The first input field is not displayed as expected.");
								}
							} catch (Throwable t) {
								successMessage("The first input field is not displayed as expected.");
							}

							// validate second input field of the one page tab is displayed as per the
							// permission
							try {
								String Field2 = "//input[@id='" + pageFieldName2 + "NUMBER']";
								boolean Field2_actual = driver.findElement(By.xpath(Field2)).isDisplayed();

								if (Field2_actual == true) {

									successMessage("The second input field is displayed as expected.");

								} else {
									verificationFailedMessage("The second input field is not displayed.");
								}
							} catch (Throwable t) {
								verificationFailedMessage("The second input field is not displayed.");
							}

							// click on the field save button
							click("customform_portfoliodashboard_fields_savebtn_XPATH");

						} else {
							verificationFailedMessage("The edit button is not displayed.");
						}
					} catch (Throwable t) {
						verificationFailedMessage("The edit button is not displayed.");
					}

				} else {
					verificationFailedMessage("The newly created custom form is not displayed.");
				}

			} catch (Throwable t) {
				verificationFailedMessage("The newly created custom form is not displayed.");
			}

			// click on the home icon from the top of the screen
			click("questionnaire_homeburgermenubtn_hide_CSS");

			// wait for the element
			explicitWait("propertylist_title_XPATH");

			// verify the property list
			switchVerification("propertylist_title_XPATH", "Property List", "The property list is not displayed.");

			// VALIDATE ON PORTFOLIO SUMMARY DASHBOARD
			consoleMessage("VALIDATE ON PORTFOLIO SUMMARY DASHBOARD");

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

			// validate the delete button is displayed in the newly created custom form from
			// the portfolio dashboard screen
			try {
				String customForm1 = "//td[text()='" + data.get("name") + "']";
				String customForm1_actual = (driver.findElement(By.xpath(customForm1)).getText()).trim();

				if (customForm1_actual.equals(data.get("name"))) {

					// click on the newly created custom form
					String customFormName = "//td[text()='" + data.get("name") + "']";
					driver.findElement(By.xpath(customFormName)).click();
					consoleMessage("Clicked on the newly created custom form.");

					// click on the property one
					click("customform_portfoliodashboard_propertyname_XPATH");

					// scroll down the screen
					scrollBottom();

					// validate the input fields are displayed in one page tab
					try {
						boolean editbtn1 = driver
								.findElement(
										By.xpath(OR.getProperty("customform_portfoliodashboard_editfieldbtn_XPATH")))
								.isDisplayed();

						if (editbtn1 == true) {

							successMessage("The edit button is displayed as expected.");

							// click on the edit field button
							click("customform_portfoliodashboard_editfieldbtn_XPATH");

							// validate first input field of the one page tab is displayed as per the
							// permission
							try {
								String Field1 = "//input[@id='" + fieldName1 + "TEXT']";
								boolean Field1_actual = driver.findElement(By.xpath(Field1)).isDisplayed();

								if (Field1_actual == true) {

									successMessage("The first input field is displayed as expected.");

								} else {
									verificationFailedMessage("The first input field is not displayed.");
								}
							} catch (Throwable t) {
								verificationFailedMessage("The first input field is not displayed.");
							}

							// validate second input field of the one page tab is displayed as per the
							// permission
							try {
								String Field2 = "//input[@id='" + fieldName2 + "NUMBER']";
								boolean Field2_actual = driver.findElement(By.xpath(Field2)).isDisplayed();

								if (Field2_actual == true) {

									verificationFailedMessage("The second input field is displayed.");

								} else {
									successMessage("The second input field is not displayed as expected.");
								}
							} catch (Throwable t) {
								successMessage("The second input field is not displayed as expected.");
							}

							// click on the field save button
							click("customform_portfoliodashboard_fields_savebtn_XPATH");

						} else {
							verificationFailedMessage("The edit button is not displayed.");
						}
					} catch (Throwable t) {
						verificationFailedMessage("The edit button is not displayed.");
					}

					// click on the first page name tab
					String pageTab1 = "//span[text()='" + pageName1 + "']";
					driver.findElement(By.xpath(pageTab1)).click();
					consoleMessage("Clicked on the first page name tab.");

					// scroll down the screen
					scrollBottom();

					// validate the input fields are displayed in one page tab
					try {
						boolean editbtn1 = driver
								.findElement(
										By.xpath(OR.getProperty("customform_portfoliodashboard_editfieldbtn_XPATH")))
								.isDisplayed();

						if (editbtn1 == true) {

							successMessage("The edit button is displayed as expected.");

							// click on the edit field button
							click("customform_portfoliodashboard_editfieldbtn_XPATH");

							// validate first input field of the one page tab is displayed as per the
							// permission
							try {
								String Field1 = "//input[@id='" + pageFieldName1 + "TEXT']";
								boolean Field1_actual = driver.findElement(By.xpath(Field1)).isDisplayed();

								if (Field1_actual == true) {

									verificationFailedMessage("The first input field is displayed.");

								} else {
									successMessage("The first input field is not displayed as expected.");
								}
							} catch (Throwable t) {
								successMessage("The first input field is not displayed as expected.");
							}

							// validate second input field of the one page tab is displayed as per the
							// permission
							try {
								String Field2 = "//input[@id='" + pageFieldName2 + "NUMBER']";
								boolean Field2_actual = driver.findElement(By.xpath(Field2)).isDisplayed();

								if (Field2_actual == true) {

									successMessage("The second input field is displayed as expected.");

								} else {
									verificationFailedMessage("The second input field is not displayed.");
								}
							} catch (Throwable t) {
								verificationFailedMessage("The second input field is not displayed.");
							}

							// click on the field save button
							click("customform_portfoliodashboard_fields_savebtn_XPATH");

						} else {
							verificationFailedMessage("The edit button is not displayed.");
						}
					} catch (Throwable t) {
						verificationFailedMessage("The edit button is not displayed.");
					}

				} else {
					verificationFailedMessage("The newly created custom form is not displayed");
				}

			} catch (Throwable t) {
				verificationFailedMessage("The newly created custom form is not displayed");
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

		// LOGOUT THE SESSION FROM THE ADMIN USER AND LOGIN TO PROPERTY MANAGER -
		// JINESH
		title("LOGOUT THE SESSION FROM THE ADMIN USER AND LOGIN TO PROPERTY MANAGER - JINESH");

		try {
			// wait for the element
			Thread.sleep(5000);

			// click on the settings icon from the top of the screen
			click("questionnaire_settingicon_userupdate_CSS");

			// wait for the element
			explicitWaitClickable("sidemenu_logout_CSS");

			// click on the logout option from the side menu
			click("sidemenu_logout_CSS");

			// login with valid credentials
			helper.loginAndUpdateSystemCompany(data, "username", "password", "system_company_1");

			// VALIDATE THE FIELDS AS PER THE PERMISSION OF THE CUSTOM REPORT IN THE
			// PROPERTY SUMMARY DASHBOARD - PROPERTY MANAGER USER - JINESH
			title("VALIDATE THE FIELDS AS PER THE PERMISSION OF THE CUSTOM REPORT IN THE PROPERTY SUMMARY DASHBOARD - PROPERTY MANAGER USER - JINESH");

			try {

				// VALIDATE ON PROPERTY SUMMARY DASHBOARD SCREEN
				title("VALIDATE ON PROPERTY SUMMARY DASHBOARD SCREEN");

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

						// click on the newly created custom form
						String customFormName = "//td[text()='" + data.get("name") + "']";
						driver.findElement(By.xpath(customFormName)).click();
						consoleMessage("Clicked on the newly created custom form.");

						// click on the newly created record
						String record = "//span[text()='" + field1Detail + "']";
						driver.findElement(By.xpath(record)).click();
						consoleMessage("Clicked on the newly created record.");

						// scroll down the screen
						scrollBottom();

						// validate the input fields are displayed in general tab
						try {
							boolean editbtn1 = driver
									.findElement(By
											.xpath(OR.getProperty("customform_portfoliodashboard_editfieldbtn_XPATH")))
									.isDisplayed();

							if (editbtn1 == true) {

								successMessage("The edit button is displayed as expected.");

								// click on the edit field button
								click("customform_portfoliodashboard_editfieldbtn_XPATH");

								// validate first input field of the general tab is displayed as per the
								// permission
								try {
									String Field1 = "//input[@id='" + fieldName1 + "TEXT']";
									boolean Field1_actual = driver.findElement(By.xpath(Field1)).isDisplayed();

									if (Field1_actual == true) {

										successMessage("The first input field is displayed as expected.");

									} else {
										verificationFailedMessage("The first input field is not displayed.");
									}
								} catch (Throwable t) {
									verificationFailedMessage("The first input field is not displayed.");
								}

								// validate second input field of the general tab is displayed as per the
								// permission
								try {
									String Field2 = "//input[@id='" + fieldName2 + "NUMBER']";
									boolean Field2_actual = driver.findElement(By.xpath(Field2)).isDisplayed();

									if (Field2_actual == true) {
										successMessage("The second input field is displayed as expected.");

									} else {
										verificationFailedMessage("The second input field is not displayed.");
									}
								} catch (Throwable t) {
									verificationFailedMessage("The second input field is not displayed.");
								}

								// click on the field save button
								click("customform_portfoliodashboard_fields_savebtn_XPATH");

							} else {
								verificationFailedMessage("The edit button is not displayed.");
							}
						} catch (Throwable t) {
							verificationFailedMessage("The edit button is not displayed.");
						}

						// click on the first page name tab
						String pageTab1 = "//span[text()='" + pageName1 + "']";
						driver.findElement(By.xpath(pageTab1)).click();
						consoleMessage("Clicked on the first page name tab.");

						// scroll down the screen
						scrollBottom();

						// validate the input fields are displayed in one page tab
						try {
							boolean editbtn1 = driver
									.findElement(By
											.xpath(OR.getProperty("customform_portfoliodashboard_editfieldbtn_XPATH")))
									.isDisplayed();

							if (editbtn1 == true) {

								successMessage("The edit button is displayed as expected.");

								// click on the edit field button
								click("customform_portfoliodashboard_editfieldbtn_XPATH");

								// validate first input field of the one page tab is displayed as per the
								// permission
								try {
									String Field1 = "//input[@id='" + pageFieldName1 + "TEXT']";
									boolean Field1_actual = driver.findElement(By.xpath(Field1)).isDisplayed();

									if (Field1_actual == true) {

										successMessage("The first input field is displayed as expected.");

									} else {
										verificationFailedMessage("The first input field is not displayed.");
									}
								} catch (Throwable t) {
									verificationFailedMessage("The first input field is not displayed.");
								}

								// validate second input field is displayed as per the
								// permission
								try {
									String Field2 = "//input[@id='" + pageFieldName2 + "NUMBER']";
									boolean Field2_actual = driver.findElement(By.xpath(Field2)).isDisplayed();

									if (Field2_actual == true) {

										successMessage("The second input field is displayed as expected.");

									} else {
										verificationFailedMessage("The second input field is not displayed.");
									}
								} catch (Throwable t) {
									verificationFailedMessage("The second input field is not displayed.");
								}

								// click on the field save button
								click("customform_portfoliodashboard_fields_savebtn_XPATH");

							} else {
								verificationFailedMessage("The edit button is not displayed.");
							}
						} catch (Throwable t) {
							verificationFailedMessage("The edit button is not displayed.");
						}

					} else {
						verificationFailedMessage("The newly created custom form is not displayed.");
					}

				} catch (Throwable t) {
					verificationFailedMessage("The newly created custom form is not displayed.");
				}

				// click on the home icon from the top of the screen
				click("questionnaire_homeburgermenubtn_hide_CSS");

				// wait for the element
				explicitWait("propertylist_title_XPATH");

				// verify the property list
				switchVerification("propertylist_title_XPATH", "Property List", "The property list is not displayed.");

				// VALIDATE ON PORTFOLIO SUMMARY DASHBOARD
				consoleMessage("VALIDATE ON PORTFOLIO SUMMARY DASHBOARD");

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

				// validate the delete button is displayed in the newly created custom form from
				// the portfolio dashboard screen
				try {
					String customForm1 = "//td[text()='" + data.get("name") + "']";
					String customForm1_actual = (driver.findElement(By.xpath(customForm1)).getText()).trim();

					if (customForm1_actual.equals(data.get("name"))) {

						// click on the newly created custom form
						String customFormName = "//td[text()='" + data.get("name") + "']";
						driver.findElement(By.xpath(customFormName)).click();
						consoleMessage("Clicked on the newly created custom form.");

						// click on the property one
						click("customform_portfoliodashboard_propertyname_XPATH");

						// scroll down the screen
						scrollBottom();

						// validate the input fields are displayed in one page tab
						try {
							boolean editbtn1 = driver
									.findElement(By
											.xpath(OR.getProperty("customform_portfoliodashboard_editfieldbtn_XPATH")))
									.isDisplayed();

							if (editbtn1 == true) {

								successMessage("The edit button is displayed as expected.");

								// click on the edit field button
								click("customform_portfoliodashboard_editfieldbtn_XPATH");

								// validate first input field of the one page tab is displayed as per the
								// permission
								try {
									String Field1 = "//input[@id='" + fieldName1 + "TEXT']";
									boolean Field1_actual = driver.findElement(By.xpath(Field1)).isDisplayed();

									if (Field1_actual == true) {

										successMessage("The first input field is displayed as expected.");

									} else {
										verificationFailedMessage("The first input field is not displayed.");
									}
								} catch (Throwable t) {
									verificationFailedMessage("The first input field is not displayed.");
								}

								// validate second input field of the one page tab is displayed as per the
								// permission
								try {
									String Field2 = "//input[@id='" + fieldName2 + "NUMBER']";
									boolean Field2_actual = driver.findElement(By.xpath(Field2)).isDisplayed();

									if (Field2_actual == true) {

										successMessage("The second input field is displayed as expected.");

									} else {
										verificationFailedMessage("The second input field is not displayed.");
									}
								} catch (Throwable t) {
									verificationFailedMessage("The second input field is not displayed.");
								}

								// click on the field save button
								click("customform_portfoliodashboard_fields_savebtn_XPATH");

							} else {
								verificationFailedMessage("The edit button is not displayed.");
							}
						} catch (Throwable t) {
							verificationFailedMessage("The edit button is not displayed.");
						}

						// click on the first page name tab
						String pageTab1 = "//span[text()='" + pageName1 + "']";
						driver.findElement(By.xpath(pageTab1)).click();
						consoleMessage("Clicked on the first page name tab.");

						// scroll down the screen
						scrollBottom();

						// validate the input fields are displayed in one page tab
						try {
							boolean editbtn1 = driver
									.findElement(By
											.xpath(OR.getProperty("customform_portfoliodashboard_editfieldbtn_XPATH")))
									.isDisplayed();

							if (editbtn1 == true) {

								successMessage("The edit button is displayed as expected.");

								// click on the edit field button
								click("customform_portfoliodashboard_editfieldbtn_XPATH");

								// validate first input field of the one page tab is displayed as per the
								// permission
								try {
									String Field1 = "//input[@id='" + pageFieldName1 + "TEXT']";
									boolean Field1_actual = driver.findElement(By.xpath(Field1)).isDisplayed();

									if (Field1_actual == true) {

										successMessage("The first input field is displayed as expected.");

									} else {
										verificationFailedMessage("The first input field is not displayed.");
									}
								} catch (Throwable t) {
									verificationFailedMessage("The first input field is not displayed.");
								}

								// validate second input field of the one page tab is displayed as per the
								// permission
								try {
									String Field2 = "//input[@id='" + pageFieldName2 + "NUMBER']";
									boolean Field2_actual = driver.findElement(By.xpath(Field2)).isDisplayed();

									if (Field2_actual == true) {

										successMessage("The second input field is displayed as expected.");

									} else {
										verificationFailedMessage("The second input field is not displayed.");
									}
								} catch (Throwable t) {
									verificationFailedMessage("The second input field is not displayed.");
								}

								// click on the field save button
								click("customform_portfoliodashboard_fields_savebtn_XPATH");

							} else {
								verificationFailedMessage("The edit button is not displayed.");
							}
						} catch (Throwable t) {
							verificationFailedMessage("The edit button is not displayed.");
						}

					} else {
						verificationFailedMessage("The newly created custom form is not displayed");
					}

				} catch (Throwable t) {
					verificationFailedMessage("The newly created custom form is not displayed");
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

			// LOGOUT THE SESSION FROM THE PROPERTY MANAGER - JINESH USER AND LOGIN TO ADMIN
			// USER
			title("LOGOUT THE SESSION FROM THE PROPERTY MANAGER - JINESH USER AND LOGIN TO ADMIN USER");

			// wait for the element
			Thread.sleep(5000);

			// click on the settings icon from the top of the screen
			click("questionnaire_settingicon_CSS");

			// wait for the element
			Thread.sleep(5000);

			// click on the logout option from the side menu
			click("sidemenu_logout_CSS");

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

			// wait for the element
			explicitWaitClickable("sidemenu_logout_CSS");

			// click on the logout option from the side menu
			click("sidemenu_logout_CSS");

			// login with valid credentials
			helper.loginAndUpdateSystemCompany(data, "username_2", "password_2", "system_company_1");

			// VALIDATE THE FIELDS AS PER THE PERMISSION OF THE CUSTOM REPORT IN THE
			// PROPERTY SUMMARY DASHBOARD - CONTRACTOR USER - JINESH CONTRACTOR
			title("VALIDATE THE FIELDS AS PER THE PERMISSION OF THE CUSTOM REPORT IN THE PROPERTY SUMMARY DASHBOARD - CONTRACTOR USER - JINESH CONTRACTOR");

			try {

				// VALIDATE ON PROPERTY SUMMARY DASHBOARD SCREEN
				title("VALIDATE ON PROPERTY SUMMARY DASHBOARD SCREEN");

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

						// click on the newly created custom form
						String customFormName = "//td[text()='" + data.get("name") + "']";
						driver.findElement(By.xpath(customFormName)).click();
						consoleMessage("Clicked on the newly created custom form.");

						// click on the newly created record
						String record = "//span[text()='" + field1Detail + "']";
						driver.findElement(By.xpath(record)).click();
						consoleMessage("Clicked on the newly created record.");

						// scroll down the screen
						scrollBottom();

						// validate the input fields are displayed in general tab
						try {
							boolean editbtn1 = driver
									.findElement(By
											.xpath(OR.getProperty("customform_portfoliodashboard_editfieldbtn_XPATH")))
									.isDisplayed();

							if (editbtn1 == true) {

								successMessage("The edit button is displayed as expected.");

								// click on the edit field button
								click("customform_portfoliodashboard_editfieldbtn_XPATH");

								// validate first input field of the general tab is displayed as per the
								// permission
								try {
									String Field1 = "//input[@id='" + fieldName1 + "TEXT']";
									boolean Field1_actual = driver.findElement(By.xpath(Field1)).isDisplayed();

									if (Field1_actual == true) {

										successMessage("The first input field is displayed as expected.");

									} else {
										verificationFailedMessage("The first input field is not displayed.");
									}
								} catch (Throwable t) {
									verificationFailedMessage("The first input field is not displayed.");
								}

								// validate second input field of the general tab is displayed as per the
								// permission
								try {
									String Field2 = "//input[@id='" + fieldName2 + "NUMBER']";
									boolean Field2_actual = driver.findElement(By.xpath(Field2)).isDisplayed();

									if (Field2_actual == true) {
										successMessage("The second input field is displayed as expected.");

									} else {
										verificationFailedMessage("The second input field is not displayed.");
									}
								} catch (Throwable t) {
									verificationFailedMessage("The second input field is not displayed.");
								}

								// click on the field save button
								click("customform_portfoliodashboard_fields_savebtn_XPATH");

							} else {
								verificationFailedMessage("The edit button is not displayed.");
							}
						} catch (Throwable t) {
							verificationFailedMessage("The edit button is not displayed.");
						}

						// click on the first page name tab
						String pageTab1 = "//span[text()='" + pageName1 + "']";
						driver.findElement(By.xpath(pageTab1)).click();
						consoleMessage("Clicked on the first page name tab.");

						// scroll down the screen
						scrollBottom();

						// validate the input fields are displayed in one page tab
						try {
							boolean editbtn1 = driver
									.findElement(By
											.xpath(OR.getProperty("customform_portfoliodashboard_editfieldbtn_XPATH")))
									.isDisplayed();

							if (editbtn1 == true) {

								successMessage("The edit button is displayed as expected.");

								// click on the edit field button
								click("customform_portfoliodashboard_editfieldbtn_XPATH");

								// validate first input field of the one page tab is displayed as per the
								// permission
								try {
									String Field1 = "//input[@id='" + pageFieldName1 + "TEXT']";
									boolean Field1_actual = driver.findElement(By.xpath(Field1)).isDisplayed();

									if (Field1_actual == true) {

										successMessage("The first input field is displayed as expected.");

									} else {
										verificationFailedMessage("The first input field is not displayed.");
									}
								} catch (Throwable t) {
									verificationFailedMessage("The first input field is not displayed.");
								}

								// validate second input field is displayed as per the
								// permission
								try {
									String Field2 = "//input[@id='" + pageFieldName2 + "NUMBER']";
									boolean Field2_actual = driver.findElement(By.xpath(Field2)).isDisplayed();

									if (Field2_actual == true) {

										successMessage("The second input field is displayed as expected.");

									} else {
										verificationFailedMessage("The second input field is not displayed.");
									}
								} catch (Throwable t) {
									verificationFailedMessage("The second input field is not displayed.");
								}

								// click on the field save button
								click("customform_portfoliodashboard_fields_savebtn_XPATH");

							} else {
								verificationFailedMessage("The edit button is not displayed.");
							}
						} catch (Throwable t) {
							verificationFailedMessage("The edit button is not displayed.");
						}

					} else {
						verificationFailedMessage("The newly created custom form is not displayed.");
					}

				} catch (Throwable t) {
					verificationFailedMessage("The newly created custom form is not displayed.");
				}

				// click on the home icon from the top of the screen
				click("questionnaire_homeburgermenubtn_hide_CSS");

				// wait for the element
				explicitWait("propertylist_title_XPATH");

				// verify the property list
				switchVerification("propertylist_title_XPATH", "Property List", "The property list is not displayed.");

				// VALIDATE ON PORTFOLIO SUMMARY DASHBOARD
				consoleMessage("VALIDATE ON PORTFOLIO SUMMARY DASHBOARD");

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

				// validate the delete button is displayed in the newly created custom form from
				// the portfolio dashboard screen
				try {
					String customForm1 = "//td[text()='" + data.get("name") + "']";
					String customForm1_actual = (driver.findElement(By.xpath(customForm1)).getText()).trim();

					if (customForm1_actual.equals(data.get("name"))) {

						// click on the newly created custom form
						String customFormName = "//td[text()='" + data.get("name") + "']";
						driver.findElement(By.xpath(customFormName)).click();
						consoleMessage("Clicked on the newly created custom form.");

						// click on the property one
						click("customform_portfoliodashboard_propertyname_XPATH");

						// scroll down the screen
						scrollBottom();

						// validate the input fields are displayed in one page tab
						try {
							boolean editbtn1 = driver
									.findElement(By
											.xpath(OR.getProperty("customform_portfoliodashboard_editfieldbtn_XPATH")))
									.isDisplayed();

							if (editbtn1 == true) {

								successMessage("The edit button is displayed as expected.");

								// click on the edit field button
								click("customform_portfoliodashboard_editfieldbtn_XPATH");

								// validate first input field of the one page tab is displayed as per the
								// permission
								try {
									String Field1 = "//input[@id='" + fieldName1 + "TEXT']";
									boolean Field1_actual = driver.findElement(By.xpath(Field1)).isDisplayed();

									if (Field1_actual == true) {

										successMessage("The first input field is displayed as expected.");

									} else {
										verificationFailedMessage("The first input field is not displayed.");
									}
								} catch (Throwable t) {
									verificationFailedMessage("The first input field is not displayed.");
								}

								// validate second input field of the one page tab is displayed as per the
								// permission
								try {
									String Field2 = "//input[@id='" + fieldName2 + "NUMBER']";
									boolean Field2_actual = driver.findElement(By.xpath(Field2)).isDisplayed();

									if (Field2_actual == true) {

										successMessage("The second input field is displayed as expected.");

									} else {
										verificationFailedMessage("The second input field is not displayed.");
									}
								} catch (Throwable t) {
									verificationFailedMessage("The second input field is not displayed.");
								}

								// click on the field save button
								click("customform_portfoliodashboard_fields_savebtn_XPATH");

							} else {
								verificationFailedMessage("The edit button is not displayed.");
							}
						} catch (Throwable t) {
							verificationFailedMessage("The edit button is not displayed.");
						}

						// click on the first page name tab
						String pageTab1 = "//span[text()='" + pageName1 + "']";
						driver.findElement(By.xpath(pageTab1)).click();
						consoleMessage("Clicked on the first page name tab.");

						// scroll down the screen
						scrollBottom();

						// validate the input fields are displayed in one page tab
						try {
							boolean editbtn1 = driver
									.findElement(By
											.xpath(OR.getProperty("customform_portfoliodashboard_editfieldbtn_XPATH")))
									.isDisplayed();

							if (editbtn1 == true) {

								successMessage("The edit button is displayed as expected.");

								// click on the edit field button
								click("customform_portfoliodashboard_editfieldbtn_XPATH");

								// validate first input field of the one page tab is displayed as per the
								// permission
								try {
									String Field1 = "//input[@id='" + pageFieldName1 + "TEXT']";
									boolean Field1_actual = driver.findElement(By.xpath(Field1)).isDisplayed();

									if (Field1_actual == true) {

										successMessage("The first input field is displayed as expected.");

									} else {
										verificationFailedMessage("The first input field is not displayed.");
									}
								} catch (Throwable t) {
									verificationFailedMessage("The first input field is not displayed.");
								}

								// validate second input field of the one page tab is displayed as per the
								// permission
								try {
									String Field2 = "//input[@id='" + pageFieldName2 + "NUMBER']";
									boolean Field2_actual = driver.findElement(By.xpath(Field2)).isDisplayed();

									if (Field2_actual == true) {

										successMessage("The second input field is displayed as expected.");

									} else {
										verificationFailedMessage("The second input field is not displayed.");
									}
								} catch (Throwable t) {
									verificationFailedMessage("The second input field is not displayed.");
								}

								// click on the field save button
								click("customform_portfoliodashboard_fields_savebtn_XPATH");

							} else {
								verificationFailedMessage("The edit button is not displayed.");
							}
						} catch (Throwable t) {
							verificationFailedMessage("The edit button is not displayed.");
						}

					} else {
						verificationFailedMessage("The newly created custom form is not displayed");
					}

				} catch (Throwable t) {
					verificationFailedMessage("The newly created custom form is not displayed");
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

			// LOGOUT THE SESSION FROM THE CONTRACTOR - JINESH CONTRACTOR USER AND LOGIN TO
			// ADMIN USER
			title("LOGOUT THE SESSION FROM THE CONTRACTOR - JINESH CONTRACTOR USER AND LOGIN TO ADMIN USER");

			// wait for the element
			Thread.sleep(5000);

			// click on the settings icon from the top of the screen
			click("questionnaire_settingicon_CSS");

			// wait for the element
			Thread.sleep(5000);

			// click on the logout option from the side menu
			click("sidemenu_logout_CSS");

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

			// wait for the element
			explicitWaitClickable("sidemenu_logout_CSS");

			// click on the logout option from the side menu
			click("sidemenu_logout_CSS");

			// login with valid credentials
			helper.loginAndUpdateSystemCompany(data, "username_3", "password_3", "system_company_1");

			// VALIDATE THE FIELDS AS PER THE PERMISSION OF THE CUSTOM REPORT IN THE
			// PROPERTY SUMMARY DASHBOARD - HR USER - JINESH HR
			title("VALIDATE THE FIELDS AS PER THE PERMISSION OF THE CUSTOM REPORT IN THE PROPERTY SUMMARY DASHBOARD - HR USER - JINESH HR");

			try {

				// VALIDATE ON PROPERTY SUMMARY DASHBOARD SCREEN
				title("VALIDATE ON PROPERTY SUMMARY DASHBOARD SCREEN");

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

						// click on the newly created custom form
						String customFormName = "//td[text()='" + data.get("name") + "']";
						driver.findElement(By.xpath(customFormName)).click();
						consoleMessage("Clicked on the newly created custom form.");

						// click on the newly created record
						String record = "//span[text()='" + field1Detail + "']";
						driver.findElement(By.xpath(record)).click();
						consoleMessage("Clicked on the newly created record.");

						// scroll down the screen
						scrollBottom();

						// validate the input fields are displayed in general tab
						try {
							boolean editbtn1 = driver
									.findElement(By
											.xpath(OR.getProperty("customform_portfoliodashboard_editfieldbtn_XPATH")))
									.isDisplayed();

							if (editbtn1 == true) {

								successMessage("The edit button is displayed as expected.");

								// click on the edit field button
								click("customform_portfoliodashboard_editfieldbtn_XPATH");

								// validate first input field of the general tab is displayed as per the
								// permission
								try {
									String Field1 = "//input[@id='" + fieldName1 + "TEXT']";
									boolean Field1_actual = driver.findElement(By.xpath(Field1)).isDisplayed();

									if (Field1_actual == true) {

										successMessage("The first input field is displayed as expected.");

									} else {
										verificationFailedMessage("The first input field is not displayed.");
									}
								} catch (Throwable t) {
									verificationFailedMessage("The first input field is not displayed.");
								}

								// validate second input field of the general tab is displayed as per the
								// permission
								try {
									String Field2 = "//input[@id='" + fieldName2 + "NUMBER']";
									boolean Field2_actual = driver.findElement(By.xpath(Field2)).isDisplayed();

									if (Field2_actual == true) {

										verificationFailedMessage("The second input field is displayed.");

									} else {
										successMessage("The second input field is not displayed as expected.");
									}
								} catch (Throwable t) {
									successMessage("The second input field is not displayed as expected.");
								}

								// click on the field save button
								click("customform_portfoliodashboard_fields_savebtn_XPATH");

							} else {
								verificationFailedMessage("The edit button is not displayed.");
							}
						} catch (Throwable t) {
							verificationFailedMessage("The edit button is not displayed.");
						}

						// click on the first page name tab
						String pageTab1 = "//span[text()='" + pageName1 + "']";
						driver.findElement(By.xpath(pageTab1)).click();
						consoleMessage("Clicked on the first page name tab.");

						// scroll down the screen
						scrollBottom();

						// validate the input fields are displayed in one page tab
						try {
							boolean editbtn1 = driver
									.findElement(By
											.xpath(OR.getProperty("customform_portfoliodashboard_editfieldbtn_XPATH")))
									.isDisplayed();

							if (editbtn1 == true) {

								successMessage("The edit button is displayed as expected.");

								// click on the edit field button
								click("customform_portfoliodashboard_editfieldbtn_XPATH");

								// validate first input field of the one page tab is displayed as per the
								// permission
								try {
									String Field1 = "//input[@id='" + pageFieldName1 + "TEXT']";
									boolean Field1_actual = driver.findElement(By.xpath(Field1)).isDisplayed();

									if (Field1_actual == true) {

										verificationFailedMessage("The first input field is displayed.");

									} else {
										successMessage("The first input field is not displayed as expected.");
									}
								} catch (Throwable t) {
									successMessage("The first input field is not displayed as expected.");
								}

								// validate second input field of the one page tab is displayed as per the
								// permission
								try {
									String Field2 = "//input[@id='" + pageFieldName2 + "NUMBER']";
									boolean Field2_actual = driver.findElement(By.xpath(Field2)).isDisplayed();

									if (Field2_actual == true) {

										successMessage("The second input field is displayed as expected.");

									} else {
										verificationFailedMessage("The second input field is not displayed.");
									}
								} catch (Throwable t) {
									verificationFailedMessage("The second input field is not displayed.");
								}

								// click on the field save button
								click("customform_portfoliodashboard_fields_savebtn_XPATH");

							} else {
								verificationFailedMessage("The edit button is not displayed.");
							}
						} catch (Throwable t) {
							verificationFailedMessage("The edit button is not displayed.");
						}

					} else {
						verificationFailedMessage("The newly created custom form is not displayed.");
					}

				} catch (Throwable t) {
					verificationFailedMessage("The newly created custom form is not displayed.");
				}

				// click on the home icon from the top of the screen
				click("questionnaire_homeburgermenubtn_hide_CSS");

				// wait for the element
				explicitWait("propertylist_title_XPATH");

				// verify the property list
				switchVerification("propertylist_title_XPATH", "Property List", "The property list is not displayed.");

				// VALIDATE ON PORTFOLIO SUMMARY DASHBOARD
				consoleMessage("VALIDATE ON PORTFOLIO SUMMARY DASHBOARD");

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

				// validate the delete button is displayed in the newly created custom form from
				// the portfolio dashboard screen
				try {
					String customForm1 = "//td[text()='" + data.get("name") + "']";
					String customForm1_actual = (driver.findElement(By.xpath(customForm1)).getText()).trim();

					if (customForm1_actual.equals(data.get("name"))) {

						// click on the newly created custom form
						String customFormName = "//td[text()='" + data.get("name") + "']";
						driver.findElement(By.xpath(customFormName)).click();
						consoleMessage("Clicked on the newly created custom form.");

						// click on the property one
						click("customform_portfoliodashboard_propertyname_XPATH");

						// scroll down the screen
						scrollBottom();

						// validate the input fields are displayed in one page tab
						try {
							boolean editbtn1 = driver
									.findElement(By
											.xpath(OR.getProperty("customform_portfoliodashboard_editfieldbtn_XPATH")))
									.isDisplayed();

							if (editbtn1 == true) {

								successMessage("The edit button is displayed as expected.");

								// click on the edit field button
								click("customform_portfoliodashboard_editfieldbtn_XPATH");

								// validate first input field of the one page tab is displayed as per the
								// permission
								try {
									String Field1 = "//input[@id='" + fieldName1 + "TEXT']";
									boolean Field1_actual = driver.findElement(By.xpath(Field1)).isDisplayed();

									if (Field1_actual == true) {

										successMessage("The first input field is displayed as expected.");

									} else {
										verificationFailedMessage("The first input field is not displayed.");
									}
								} catch (Throwable t) {
									verificationFailedMessage("The first input field is not displayed.");
								}

								// validate second input field of the one page tab is displayed as per the
								// permission
								try {
									String Field2 = "//input[@id='" + fieldName2 + "NUMBER']";
									boolean Field2_actual = driver.findElement(By.xpath(Field2)).isDisplayed();

									if (Field2_actual == true) {

										verificationFailedMessage("The second input field is displayed.");

									} else {
										successMessage("The second input field is not displayed as expected.");
									}
								} catch (Throwable t) {
									successMessage("The second input field is not displayed as expected.");
								}

								// click on the field save button
								click("customform_portfoliodashboard_fields_savebtn_XPATH");

							} else {
								verificationFailedMessage("The edit button is not displayed.");
							}
						} catch (Throwable t) {
							verificationFailedMessage("The edit button is not displayed.");
						}

						// click on the first page name tab
						String pageTab1 = "//span[text()='" + pageName1 + "']";
						driver.findElement(By.xpath(pageTab1)).click();
						consoleMessage("Clicked on the first page name tab.");

						// scroll down the screen
						scrollBottom();

						// validate the input fields are displayed in one page tab
						try {
							boolean editbtn1 = driver
									.findElement(By
											.xpath(OR.getProperty("customform_portfoliodashboard_editfieldbtn_XPATH")))
									.isDisplayed();

							if (editbtn1 == true) {

								successMessage("The edit button is displayed as expected.");

								// click on the edit field button
								click("customform_portfoliodashboard_editfieldbtn_XPATH");

								// validate first input field of the one page tab is displayed as per the
								// permission
								try {
									String Field1 = "//input[@id='" + pageFieldName1 + "TEXT']";
									boolean Field1_actual = driver.findElement(By.xpath(Field1)).isDisplayed();

									if (Field1_actual == true) {

										verificationFailedMessage("The first input field is displayed.");

									} else {
										successMessage("The first input field is not displayed as expected.");
									}
								} catch (Throwable t) {
									successMessage("The first input field is not displayed as expected.");
								}

								// validate second input field of the one page tab is displayed as per the
								// permission
								try {
									String Field2 = "//input[@id='" + pageFieldName2 + "NUMBER']";
									boolean Field2_actual = driver.findElement(By.xpath(Field2)).isDisplayed();

									if (Field2_actual == true) {

										successMessage("The second input field is displayed as expected.");

									} else {
										verificationFailedMessage("The second input field is not displayed.");
									}
								} catch (Throwable t) {
									verificationFailedMessage("The second input field is not displayed.");
								}

								// click on the field save button
								click("customform_portfoliodashboard_fields_savebtn_XPATH");

							} else {
								verificationFailedMessage("The edit button is not displayed.");
							}
						} catch (Throwable t) {
							verificationFailedMessage("The edit button is not displayed.");
						}

					} else {
						verificationFailedMessage("The newly created custom form is not displayed");
					}

				} catch (Throwable t) {
					verificationFailedMessage("The newly created custom form is not displayed");
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

			// LOGOUT THE SESSION FROM THE HR USER - JINESH HR AND LOGIN TO
			// ADMIN USER
			title("LOGOUT THE SESSION FROM THE HR USER - JINESH HR AND LOGIN TO ADMIN USER");

			// wait for the element
			Thread.sleep(5000);

			// click on the settings icon from the top of the screen
			click("questionnaire_settingicon_CSS");

			// wait for the element
			Thread.sleep(5000);

			// click on the logout option from the side menu
			click("sidemenu_logout_CSS");

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
