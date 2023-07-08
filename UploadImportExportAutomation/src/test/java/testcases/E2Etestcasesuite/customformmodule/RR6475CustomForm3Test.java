package testcases.E2Etestcasesuite.customformmodule;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Hashtable;
import java.util.List;
import java.util.Random;

import org.apache.commons.lang3.RandomStringUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.testng.Assert;
import org.testng.annotations.Test;

import base.TestBase;
import utilities.TestUtil;

public class RR6475CustomForm3Test extends TestBase {

	@Test(dataProviderClass = TestUtil.class, dataProvider = "dp")
	public void rR6475CustomForm3Test(Hashtable<String, String> data) throws IOException, InterruptedException {

		execution(data, "rR6475CustomForm3Test");

		// VALIDATE THE PDF REPORT OF THE RAMDOM NUMBER OF DETAILS OF THE CUSTOM RECORDS
		// IN THE PORTFOLIO DASHBOARD AND PROPERTY SUMMARY DASHBOARD - CORPORATE LEVEL
		title("VALIDATE THE PDF REPORT OF THE RAMDOM NUMBER OF DETAILS OF THE CUSTOM RECORDS IN THE PORTFOLIO DASHBOARD AND PROPERTY SUMMARY DASHBOARD - CORPORATE LEVEL");

		// refresh the page
		driver.navigate().refresh();
		Thread.sleep(5000);
		driver.navigate().refresh();

		System.out.println("Navigate to the Home Screen i.e. Property List Screen.");

		String name = RandomStringUtils.randomAlphabetic(8); // Name of the custom form
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

		// VALIDATE THE DOWNLOADED PDF FILE OF THE DETAILS LISTING SCREEN OF THE CUSTOM
		// FORM - PORTFOLIO SUMMARY DASHBOARD
		title("VALIDATE THE DOWNLOADED PDF FILE OF THE DETAILS LISTING SCREEN OF THE CUSTOM FORM - PORTFOLIO SUMMARY DASHBOARD");

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

			// click on the pdf report option
			click("customform_portfoliodashboard_actionicon_pdfreportoption_XPATH");

			// ********** ADD THE LATEST FILE FETCH CODE **********

			// wait for the element
			Thread.sleep(15000);

			File downloaded = getLastModified("C:\\Users\\Jinesh\\Downloads");
			String path_string = downloaded.toString();
			System.out.println(path_string);
			String final_path = "file:///" + path_string;

			try {
				JavascriptExecutor js = (JavascriptExecutor) driver;
				js.executeScript("window.open('about:blank','_blank');");

				ArrayList<String> tabs2 = new ArrayList<String>(driver.getWindowHandles());
				driver.switchTo().window(tabs2.get(2));

				driver.get(final_path);

				String pdfContent = readPdfContent(final_path);
				Thread.sleep(10000);

				int pageCount = fetchPageCount();

				if (pageCount == count) {
					successMessage("The count of the pages are displayed correctly.");
				} else {
					verificationFailedMessage("The count of the pages are not displayed correctly.");
				}

				Assert.assertTrue(pdfContent.contains(name));
				consoleMessage(name);

				for (int j = 0; j < count; j++) {
					Assert.assertTrue(pdfContent.contains(fieldName1 + ": " + field1Detail_list.get(j)));
					consoleMessage(fieldName1 + ": " + field1Detail_list.get(j));
					Assert.assertTrue(pdfContent.contains(fieldName2 + ": " + field2Detail_list.get(j)));
					consoleMessage(fieldName2 + ": " + field2Detail_list.get(j));
					Assert.assertTrue(pdfContent.contains(pageFieldName1 + ": " + pageField1Detail_list.get(j)));
					consoleMessage(pageFieldName1 + ": " + pageField1Detail_list.get(j));
					Assert.assertTrue(pdfContent.contains(pageFieldName2 + ": " + pageField2Detail_list.get(j)));
					consoleMessage(pageFieldName2 + ": " + pageField2Detail_list.get(j));

				}

				driver.close();

				driver.switchTo().window(tabs2.get(0));

			} catch (IOException e) {
				e.printStackTrace();
				ArrayList<String> tabs2 = new ArrayList<String>(driver.getWindowHandles());
				driver.switchTo().window(tabs2.get(0));
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

		// VALIDATE THE DOWNLOADED PDF FILE OF THE DETAILS SCREEN OF THE CUSTOM
		// FORM - PORTFOLIO SUMMARY DASHBOARD
		title("VALIDATE THE DOWNLOADED PDF FILE OF THE DETAILS LISTING SCREEN OF THE CUSTOM FORM - PORTFOLIO SUMMARY DASHBOARD");

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

			// click on the record
			String firstField11 = "//span[contains(text(),'" + field1Detail_list.get(1) + "')]";
			driver.findElement(By.xpath(firstField11)).click();
			consoleMessage("Clicked on the record.");

			// click on the action icon
			click("customform_portfoliodashboard_actionicon_XPATH");

			// click on the pdf report option
			click("customform_portfoliodashboard_propertylistactionicon_pdfreportoption_XPATH");

			// ********** ADD THE LATEST FILE FETCH CODE **********

			// wait for the element
			Thread.sleep(15000);

			File downloaded = getLastModified("C:\\Users\\Jinesh\\Downloads");
			String path_string = downloaded.toString();
			System.out.println(path_string);
			String final_path = "file:///" + path_string;

			try {
				JavascriptExecutor js = (JavascriptExecutor) driver;
				js.executeScript("window.open('about:blank','_blank');");

				ArrayList<String> tabs2 = new ArrayList<String>(driver.getWindowHandles());
				driver.switchTo().window(tabs2.get(2));

				driver.get(final_path);

				String pdfContent = readPdfContent(final_path);
				Thread.sleep(10000);

				int pageCount = fetchPageCount();

				if (pageCount == count) {
					successMessage("The count of the pages are displayed correctly.");
				} else {
					verificationFailedMessage("The count of the pages are not displayed correctly.");
				}

				Assert.assertTrue(pdfContent.contains(name));
				consoleMessage(name);

				for (int j = 0; j < count; j++) {
					Assert.assertTrue(pdfContent.contains(fieldName1 + ": " + field1Detail_list.get(j)));
					consoleMessage(fieldName1 + ": " + field1Detail_list.get(j));
					Assert.assertTrue(pdfContent.contains(fieldName2 + ": " + field2Detail_list.get(j)));
					consoleMessage(fieldName2 + ": " + field2Detail_list.get(j));
					Assert.assertTrue(pdfContent.contains(pageFieldName1 + ": " + pageField1Detail_list.get(j)));
					consoleMessage(pageFieldName1 + ": " + pageField1Detail_list.get(j));
					Assert.assertTrue(pdfContent.contains(pageFieldName2 + ": " + pageField2Detail_list.get(j)));
					consoleMessage(pageFieldName2 + ": " + pageField2Detail_list.get(j));

				}

				driver.close();

				driver.switchTo().window(tabs2.get(0));

			} catch (IOException e) {
				e.printStackTrace();
				ArrayList<String> tabs2 = new ArrayList<String>(driver.getWindowHandles());
				driver.switchTo().window(tabs2.get(0));
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

		// VALIDATE THE DOWNLOADED PDF FILE OF THE DETAILS LISTING SCREEN OF THE CUSTOM
		// FORM - PROPERTY SUMMARY DASHBOARD
		title("VALIDATE THE DOWNLOADED PDF FILE OF THE DETAILS LISTING SCREEN OF THE CUSTOM FORM - PROPERTY SUMMARY DASHBOARD");

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

			// click on the action icon
			click("customform_portfoliodashboard_actionicon_XPATH");

			// click on the pdf report option
			click("customform_portfoliodashboard_propertylistactionicon_pdfreportoption_XPATH");

			// ********** ADD THE LATEST FILE FETCH CODE **********

			// wait for the element
			Thread.sleep(15000);

			File downloaded = getLastModified("C:\\Users\\Jinesh\\Downloads");
			String path_string = downloaded.toString();
			System.out.println(path_string);
			String final_path = "file:///" + path_string;

			try {
				JavascriptExecutor js = (JavascriptExecutor) driver;
				js.executeScript("window.open('about:blank','_blank');");

				ArrayList<String> tabs2 = new ArrayList<String>(driver.getWindowHandles());
				driver.switchTo().window(tabs2.get(2));

				driver.get(final_path);

				String pdfContent = readPdfContent(final_path);
				Thread.sleep(10000);

				int pageCount = fetchPageCount();

				if (pageCount == count) {
					successMessage("The count of the pages are displayed correctly.");
				} else {
					verificationFailedMessage("The count of the pages are not displayed correctly.");
				}

				Assert.assertTrue(pdfContent.contains(name));
				consoleMessage(name);

				for (int j = 0; j < count; j++) {
					Assert.assertTrue(pdfContent.contains(fieldName1 + ": " + field1Detail_list.get(j)));
					consoleMessage(fieldName1 + ": " + field1Detail_list.get(j));
					Assert.assertTrue(pdfContent.contains(fieldName2 + ": " + field2Detail_list.get(j)));
					consoleMessage(fieldName2 + ": " + field2Detail_list.get(j));
					Assert.assertTrue(pdfContent.contains(pageFieldName1 + ": " + pageField1Detail_list.get(j)));
					consoleMessage(pageFieldName1 + ": " + pageField1Detail_list.get(j));
					Assert.assertTrue(pdfContent.contains(pageFieldName2 + ": " + pageField2Detail_list.get(j)));
					consoleMessage(pageFieldName2 + ": " + pageField2Detail_list.get(j));

				}

				driver.close();

				driver.switchTo().window(tabs2.get(0));

			} catch (IOException e) {
				e.printStackTrace();
				ArrayList<String> tabs2 = new ArrayList<String>(driver.getWindowHandles());
				driver.switchTo().window(tabs2.get(0));
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

		// VALIDATE THE DOWNLOADED PDF FILE OF THE DETAILS SCREEN OF THE CUSTOM
		// FORM - PROPERTY SUMMARY DASHBOARD
		title("VALIDATE THE DOWNLOADED PDF FILE OF THE DETAILS SCREEN OF THE CUSTOM FORM - PROPERTY SUMMARY DASHBOARD");

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

			// click on the record
			String firstField11 = "//span[contains(text(),'" + field1Detail_list.get(1) + "')]";
			driver.findElement(By.xpath(firstField11)).click();
			consoleMessage("Clicked on the record.");

			// click on the action icon
			click("customform_portfoliodashboard_actionicon_XPATH");

			// click on the pdf report option
			click("customform_portfoliodashboard_propertylistactionicon_pdfreportoption_XPATH");

			// ********** ADD THE LATEST FILE FETCH CODE **********

			// wait for the element
			Thread.sleep(15000);

			File downloaded = getLastModified("C:\\Users\\Jinesh\\Downloads");
			String path_string = downloaded.toString();
			System.out.println(path_string);
			String final_path = "file:///" + path_string;

			try {
				JavascriptExecutor js = (JavascriptExecutor) driver;
				js.executeScript("window.open('about:blank','_blank');");

				ArrayList<String> tabs2 = new ArrayList<String>(driver.getWindowHandles());
				driver.switchTo().window(tabs2.get(2));

				driver.get(final_path);

				String pdfContent = readPdfContent(final_path);
				Thread.sleep(10000);

				int pageCount = fetchPageCount();

				if (pageCount == count) {
					successMessage("The count of the pages are displayed correctly.");
				} else {
					verificationFailedMessage("The count of the pages are not displayed correctly.");
				}

				Assert.assertTrue(pdfContent.contains(name));
				consoleMessage(name);

				for (int j = 0; j < count; j++) {
					Assert.assertTrue(pdfContent.contains(fieldName1 + ": " + field1Detail_list.get(j)));
					consoleMessage(fieldName1 + ": " + field1Detail_list.get(j));
					Assert.assertTrue(pdfContent.contains(fieldName2 + ": " + field2Detail_list.get(j)));
					consoleMessage(fieldName2 + ": " + field2Detail_list.get(j));
					Assert.assertTrue(pdfContent.contains(pageFieldName1 + ": " + pageField1Detail_list.get(j)));
					consoleMessage(pageFieldName1 + ": " + pageField1Detail_list.get(j));
					Assert.assertTrue(pdfContent.contains(pageFieldName2 + ": " + pageField2Detail_list.get(j)));
					consoleMessage(pageFieldName2 + ": " + pageField2Detail_list.get(j));

				}

				driver.close();

				driver.switchTo().window(tabs2.get(0));

			} catch (IOException e) {
				e.printStackTrace();
				ArrayList<String> tabs2 = new ArrayList<String>(driver.getWindowHandles());
				driver.switchTo().window(tabs2.get(0));
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

		// DELETE THE CUSTOMER FORM
		title("DELETE THE CUSTOMER FORM");

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
