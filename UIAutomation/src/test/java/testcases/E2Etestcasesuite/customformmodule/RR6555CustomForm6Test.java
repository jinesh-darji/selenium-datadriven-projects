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

public class RR6555CustomForm6Test extends TestBase {

	@Test(dataProviderClass = TestUtil.class, dataProvider = "dp")
	public void rR6555CustomForm6Test(Hashtable<String, String> data) throws IOException, InterruptedException {

		execution(data, "rR6555CustomForm6Test");

		// VERIFY THE RISK SCORE OF THE RANDOMLY CREATED MULTIPLE TYPE'S CUSTOM FORMS ON
		// THE PORTFOLIO DASHBOARD AND PROPERTY SUMMARY DASHBOARD WITH MULTIPLE CUSTOM
		// FORMS OF THE SAME PROPERTY.
		title("VERIFY THE RISK SCORE OF THE RANDOMLY CREATED MULTIPLE TYPE'S CUSTOM FORMS ON THE PORTFOLIO DASHBOARD AND PROPERTY SUMMARY DASHBOARD WITH MULTIPLE CUSTOM FORMS OF THE SAME PROPERTY.");

		// refresh the page
		driver.navigate().refresh();
		Thread.sleep(5000);
		driver.navigate().refresh();

		String name = null;
		List<String> name_list = new ArrayList<String>();
		String fieldName1 = null;
		String fieldName2 = null;
		String pageName1 = null;
		String pageFieldName1 = null;
		String pageFieldName2 = null;
		List<String> fieldName1_list = new ArrayList<String>();
		List<String> fieldName2_list = new ArrayList<String>();
		List<String> pageName1_list = new ArrayList<String>();
		List<String> pageFieldName1_list = new ArrayList<String>();
		List<String> pageFieldName2_list = new ArrayList<String>();
		String score = null;
		String updatescore = null;
		String field1Detail = null;
		String field2Detail = null;
		String pageField1Detail = null;
		String pageField2Detail = null;
		List<String> score_list = new ArrayList<String>();
		List<String> updatescore_list = new ArrayList<String>();

		Random random = new Random();
		int count = random.nextInt(5 - 3) + 3;
		int totalScore = 0;
		int superTotalScore = 0;
		int totalUpdateScore = 0;
		int superTotalUpdateScore = 0;

		// CREATE NEW CUSTOM FORMS FOR MULTIPLE RECORD TYPE WITH RANDOM NUMBER OF TIMES
		title("CREATE NEW CUSTOM FORMS FOR MULTIPLE RECORD TYPE WITH RANDOM NUMBER OF TIMES");

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

			for (int i = 0; i < count; i++) {

				// click on the add button
				click("customform_addbtn_XPATH");

				// enter name of the form in the name field
				name = RandomStringUtils.randomAlphabetic(8);
				type("customform_nametxt_XPATH", name);

				// collect the custom form name in the list
				name_list.add(name);

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
				fieldName1 = RandomStringUtils.randomAlphabetic(8);
				type("customform_addfield_nametxt_XPATH", fieldName1);

				// collect the first field name
				fieldName1_list.add(fieldName1);

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
				fieldName2 = RandomStringUtils.randomAlphabetic(8);
				type("customform_addfield_nametxt_XPATH", fieldName2);

				// collect the second field name
				fieldName2_list.add(fieldName2);

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
				pageName1 = RandomStringUtils.randomAlphabetic(8);
				type("customform_portfoliodashboard_pagenametxt_XPATH", pageName1);

				// collect the page name
				pageName1_list.add(pageName1);

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
				pageFieldName1 = RandomStringUtils.randomAlphabetic(8);
				type("customform_addfield_nametxt_XPATH", pageFieldName1);

				// collect the first field name of page one
				pageFieldName1_list.add(pageFieldName1);

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
				pageFieldName2 = RandomStringUtils.randomAlphabetic(8);
				type("customform_addfield_nametxt_XPATH", pageFieldName2);

				// collect the second field name of page one
				pageFieldName2_list.add(pageFieldName2);

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

				// click on the cancel button
				click("customform_cancelbtn_XPATH");

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

		// ADD THE DETAILS IN THE FIELDS ON RANDOMLY FROM THE PROPERTY SUMMARY DASHBOARD
		// FOR ALL THE CUSTOM FORM
		title("ADD THE DETAILS IN THE FIELDS ON RANDOMLY FROM THE PROPERTY SUMMARY DASHBOARD FOR ALL THE CUSTOM FORM");

		try {

			for (int j = 0; j < name_list.size(); j++) {

				// wait for the element
				Thread.sleep(5000);

				// click on the property
				click("propertysummary_property1_XPATH");

				// scrolldown till Property Information section
				scrollTillElement("customform_portfoliodashboard_propertyinformationtitle_XPATH");

				// validate the newly created custom form in the property summary dashboard
				// screen
				try {

					String customForm1 = "//td[text()='" + name_list.get(j) + "']";
					String customForm1_actual = (driver.findElement(By.xpath(customForm1)).getText()).trim();

					if (customForm1_actual.equals(name_list.get(j))) {
						successMessage("The newly created custom form is displayed successfully.");

					} else {
						verificationFailedMessage("The newly created custom form is not displayed.");
					}

				} catch (Throwable t) {
					verificationFailedMessage("The newly created custom form is not displayed.");
				}

				// click on the custom form
				String customForm1 = "//td[text()='" + name_list.get(j) + "']";
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
					String firstField = "//input[@id='" + fieldName1_list.get(j) + "TEXT']";
					driver.findElement(By.xpath(firstField)).sendKeys(field1Detail);
					consoleMessage("Entered the details in the first field.");

					// enter the details in the second field
					field2Detail = RandomStringUtils.randomNumeric(3);
					String secondField = "//input[@id='" + fieldName2_list.get(j) + "NUMBER']";
					driver.findElement(By.xpath(secondField)).sendKeys(field2Detail);
					consoleMessage("Entered the details in the second field.");

					// click on the page one tab
					String page1 = "//span[text()='" + pageName1_list.get(j) + "']";
					driver.findElement(By.xpath(page1)).click();
					consoleMessage("Clicked on the page one tab.");

					// enter the details in the first field
					pageField1Detail = RandomStringUtils.randomAlphabetic(8);
					String pageFirstField = "//input[@id='" + pageFieldName1_list.get(j) + "TEXT']";
					driver.findElement(By.xpath(pageFirstField)).sendKeys(pageField1Detail);
					consoleMessage("Entered the details in the first field.");

					// enter the details in the second field
					pageField2Detail = RandomStringUtils.randomNumeric(3);
					String pageSecondField = "//input[@id='" + pageFieldName2_list.get(j) + "NUMBER']";
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

					// click on the newly created details of the custom form
					String record = "//span[text()='" + field1Detail + "']";
					driver.findElement(By.xpath(record)).click();
					consoleMessage("Clicked on the newly created details of the custom form.");

					// ADD THE DETAILS IN THE FIELDS OF THE RISK SCORING TAB
					title("ADD THE DETAILS IN THE FIELDS OF THE RISK SCORING TAB");

					// click on the risk scoring tab
					click("customform_portfoliodashboard_riskscoringtab_XPATH");

					// select on the risk category option
					select("customform_riskcategorydd_XPATH", data.get("score_category"));

					// enter the score in the score field
					score = RandomStringUtils.randomNumeric(2);
					type("customform_scoretxt_XPATH", score);

					// collect the random details of the risk score
					score_list.add(score);

					// select the option from the status dropdown
					select("customform_statusdd_XPATH", data.get("risk_status"));

					// enter the text in description field
					type("customform_descriptiontxt_XPATH", data.get("details"));

					// click on the update button
					click("customform_portfoliodashboard_riskscoringupdatebtn_XPATH");

					// click on the details tab
					click("customform_propertysummary_detailstab_XPATH");

					// click on the record list button
					click("customform_propertysummary_recordlistbtn_XPATH");

					int score_int = Integer.parseInt(score);
					totalScore = totalScore + score_int;

					if (count == (i + 1)) {

						// click on the home icon from the top of the screen
						click("questionnaire_homeburgermenubtn_hide_CSS");

						// wait for the element
						explicitWait("propertylist_title_XPATH");

						// verify the property list
						switchVerification("propertylist_title_XPATH", "Property List",
								"The property list is not displayed.");

					}

				}

				// add the all the multiple custom form with multiple details
				superTotalScore = superTotalScore + totalScore;

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

		// VALIDATE THE RISK SCORING CARD IN THE PORTFOLIO DASHBOARD SCREEN
		title("VALIDATE THE RISK SCORING CARD IN THE PORTFOLIO DASHBOARD SCREEN");

		try {

			// wait for the element
			Thread.sleep(5000);

			// click on the side menu
			click("menubtn_CSS");

			// wait for the element
			Thread.sleep(5000);

			// click on the portfolio dashboard from side menu
			click("sidemenu_portfoliosummary_XPATH");

			// scrolldown till risk scoring card
			scrollTillElement("customform_portfoliodashboard_riskscoringcard_XPATH");

			// validate the average risk score of the all the properties
			try {
				String avgScore = (driver
						.findElement(By.xpath(
								OR.getProperty("customform_portfoliodashboard_riskscoringcard_averagescore_XPATH")))
						.getText()).trim();
				int avgScore_actual = Integer.parseInt(avgScore);
				String score_string = Integer.toString(superTotalScore);
				float score_float1 = Float.parseFloat(score_string);
				float score_float2 = score_float1 / 4f;
				int score_expected = Math.round(score_float2);

				if (avgScore_actual == score_expected) {
					successMessage("The average risk score of the all the properties is displayed correctly.");
				} else {
					verificationFailedMessage(
							"The average risk score of the all the properties is not displayed correctly.");
				}
			} catch (Throwable t) {
				verificationFailedMessage(
						"The average risk score of the all the properties is not displayed correctly.");
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

		// VALIDATE THE RISK SCORING CARD IN THE PROPERTY SUMMARY DASHBOARD SCREEN
		title("VALIDATE THE RISK SCORING CARD IN THE PROPERTY SUMMARY DASHBOARD SCREEN");

		try {

			// wait for the element
			Thread.sleep(5000);

			// click on the property
			click("propertysummary_property1_XPATH");

			// scrolldown till risk scoring card
			scrollTillElement("customform_portfoliodashboard_riskscoringcard_XPATH");

			// validate the risk score of the property
			try {
				String Score = (driver
						.findElement(By.xpath(
								OR.getProperty("customform_propertydashboard_riskscoringcard_averagescore1_XPATH")))
						.getText()).trim();
				int avgScore_actual = Integer.parseInt(Score);

				if (avgScore_actual == superTotalScore) {
					successMessage("The risk score for the property is displayed correctly.");
				} else {
					verificationFailedMessage("The risk score for the property is not displayed correctly.");
				}
			} catch (Throwable t) {
				verificationFailedMessage("The risk score for the property is not displayed correctly.");
			}

			// validate the average risk score of the other properties
			try {
				String Score = (driver
						.findElement(By.xpath(
								OR.getProperty("customform_propertydashboard_riskscoringcard_averagescore2_XPATH")))
						.getText()).trim();
				int avgScore_actual = Integer.parseInt(Score);
				int score_expected = 0;

				if (avgScore_actual == score_expected) {
					successMessage("The average risk score of the other properties is displayed correctly.");
				} else {
					verificationFailedMessage(
							"The average risk score of the other properties is not displayed correctly.");
				}
			} catch (Throwable t) {
				verificationFailedMessage("The average risk score of the other properties is not displayed correctly.");
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

		// UPDATE THE RISK SCORE DETAILS OF THE RANDOMLY CREATED CUSTOM FORM FROM THE
		// PORTFOLIO SUMMARY DASHBOARD FOR MULTIPLE CUSTOM FORM DETAILS
		title("UPDATE THE RISK SCORE DETAILS OF THE RANDOMLY CREATED CUSTOM FORM FROM THE PORTFOLIO SUMMARY DASHBOARD FOR MULTIPLE CUSTOM FORM DETAILS");

		try {

			for (int k = 0; k < name_list.size(); k++) {

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
					String customForm1 = "//td[text()='" + name_list.get(k) + "']";
					String customForm1_actual = (driver.findElement(By.xpath(customForm1)).getText()).trim();

					if (customForm1_actual.equals(name_list.get(k))) {
						successMessage("The newly created custom form is displayed successfully.");

					} else {
						verificationFailedMessage("The newly created custom form is not displayed.");
					}

				} catch (Throwable t) {
					verificationFailedMessage("The newly created custom form is not displayed.");
				}

				// click on the custom form
				String customForm1 = "//td[text()='" + name_list.get(k) + "']";
				driver.findElement(By.xpath(customForm1)).click();
				consoleMessage("Clicked on the custom form.");

				// scroll down to bottom
				scrollBottom();

				consoleMessage("While Update, The details in fields will entered " + count + " times.");

				for (int l = 1; l <= count; l++) {

					// wait for the element
					Thread.sleep(3000);

					// click on the property one
					String ele1 = "(//td[text()='[DND] AAAA Risk Test Prop 01'])[" + l + "]";
					driver.findElement(By.xpath(ele1)).click();
					consoleMessage("click on the property one i.e. " + k);

					// UPDATE THE DETAILS OF THE RISK SCORING TAB
					title("UPDATE THE DETAILS OF THE RISK SCORING TAB");

					// click on the risk scoring tab
					click("customform_portfoliodashboard_riskscoringtab_XPATH");

					// scroll to bottom
					scrollBottom();

					// select on the risk category option
					select("customform_riskcategorydd_XPATH", data.get("score_category_update"));

					// enter the score in the score field
					updatescore = RandomStringUtils.randomNumeric(2);
					type("customform_scoretxt_XPATH", updatescore);

					// collect the random details of the risk score
					updatescore_list.add(updatescore);
					consoleMessage("New count of data of the risk score : " + updatescore_list.size());

					// select the option from the status dropdown
					select("customform_statusdd_XPATH", data.get("risk_status_update"));

					// enter the text in description field
					type("customform_descriptiontxt_XPATH", data.get("details"));

					// click on the update button
					click("customform_portfoliodashboard_riskscoringupdatebtn_XPATH");

					int updatescore_int = Integer.parseInt(updatescore);
					totalUpdateScore = totalUpdateScore + updatescore_int;

					if (count > l) {

						// click on the back button
						click("customform_propertydashboard_backbtn_XPATH");
					}

					if (count == l) {

						// click on the home icon from the top of the screen
						click("questionnaire_homeburgermenubtn_hide_CSS");

						// wait for the element
						explicitWait("propertylist_title_XPATH");

						// verify the property list
						switchVerification("propertylist_title_XPATH", "Property List",
								"The property list is not displayed.");

					}

				}

				// add the all the multiple custom form with multiple updated details
				superTotalUpdateScore = superTotalUpdateScore + totalUpdateScore;

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

		// VALIDATE THE UPDATED RISK SCORING CARD IN THE PORTFOLIO DASHBOARD SCREEN
		title("VALIDATE THE UPDATED RISK SCORING CARD IN THE PORTFOLIO DASHBOARD SCREEN");

		try {

			// wait for the element
			Thread.sleep(5000);

			// click on the side menu
			click("menubtn_CSS");

			// wait for the element
			Thread.sleep(5000);

			// click on the portfolio dashboard from side menu
			click("sidemenu_portfoliosummary_XPATH");

			// scrolldown till risk scoring card
			scrollTillElement("customform_portfoliodashboard_riskscoringcard_XPATH");

			// validate the average risk score of the all the properties
			try {
				String avgScore = (driver
						.findElement(By.xpath(
								OR.getProperty("customform_portfoliodashboard_riskscoringcard_averagescore_XPATH")))
						.getText()).trim();
				int avgScore_actual = Integer.parseInt(avgScore);
				String updatescore_string = Integer.toString(superTotalUpdateScore);
				float updatescore_float1 = Float.parseFloat(updatescore_string);
				float updatescore_float2 = updatescore_float1 / 4f;
				int updatescore_expected = Math.round(updatescore_float2);

				if (avgScore_actual == updatescore_expected) {
					successMessage("The updated average risk score of the all the properties is displayed correctly.");
				} else {
					verificationFailedMessage(
							"The updated average risk score of the all the properties is not displayed correctly.");
				}
			} catch (Throwable t) {
				verificationFailedMessage(
						"The updated average risk score of the all the properties is not displayed correctly.");
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

		// VALIDATE THE UPDATED RISK SCORING CARD IN THE PROPERTY SUMMARY DASHBOARD
		// SCREEN
		title("VALIDATE THE UPDATED RISK SCORING CARD IN THE PROPERTY SUMMARY DASHBOARD SCREEN");

		try {

			// wait for the element
			Thread.sleep(5000);

			// click on the property
			click("propertysummary_property1_XPATH");

			// scrolldown till risk scoring card
			scrollTillElement("customform_portfoliodashboard_riskscoringcard_XPATH");

			// validate the risk score of the property
			try {
				String updateScore = (driver
						.findElement(By.xpath(
								OR.getProperty("customform_propertydashboard_riskscoringcard_averagescore1_XPATH")))
						.getText()).trim();
				int avgScore_actual = Integer.parseInt(updateScore);

				if (avgScore_actual == superTotalUpdateScore) {
					successMessage("The updated risk score for the property is displayed correctly.");
				} else {
					verificationFailedMessage("The updated risk score for the property is not displayed correctly.");
				}
			} catch (Throwable t) {
				verificationFailedMessage("The updated risk score for the property is not displayed correctly.");
			}

			// validate the average risk score of the other properties
			try {
				String updateScore = (driver
						.findElement(By.xpath(
								OR.getProperty("customform_propertydashboard_riskscoringcard_averagescore2_XPATH")))
						.getText()).trim();
				int avgScore_actual = Integer.parseInt(updateScore);
				int updatescore_expected = 0;

				if (avgScore_actual == updatescore_expected) {
					successMessage("The updated average risk score of the other properties is displayed correctly.");
				} else {
					verificationFailedMessage(
							"The updated average risk score of the other properties is not displayed correctly.");
				}
			} catch (Throwable t) {
				verificationFailedMessage(
						"The updated average risk score of the other properties is not displayed correctly.");
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

		// DELETE ALL THE RANDOMLY CREATED CUSTOMER FORMS
		title("DELETE ALL THE RANDOMLY CREATED CUSTOMER FORMS");

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

			for (int m = 0; m < name_list.size(); m++) {

				// wait for the element
				Thread.sleep(5000);

				// click on the delete button of the updated custom form
				String deleteIcon = "//td[text()='" + name_list.get(m)
						+ "']//following-sibling::td[@class='pointer']//i[@data-target='#deleteCustomFormModal']";
				driver.findElement(By.xpath(deleteIcon)).click();
				consoleMessage("Clicked on the delete button of the updated custom form.");

				// wait for the element
				Thread.sleep(5000);

				// click on the delete button
				click("customform_deletebtn_XPATH");

				// validate the respective record is deleted or not
				try {
					String deletedRecord = "//td[text()='" + name_list.get(m) + "']";
					boolean deletedRecord_actual = driver.findElement(By.xpath(deletedRecord)).isDisplayed();

					if (deletedRecord_actual == true) {
						verificationFailedMessage("The deleted record of the custom form is displayed.");
					} else {
						successMessage("The deleted record of the custom form is not displayed as expected.");
					}

				} catch (Throwable t) {
					successMessage("The deleted record of the custom form is not displayed as expected.");
				}

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

		// VALIDATE THE RISK SCORING CARD IN THE PORTFOLIO DASHBOARD SCREEN AFTER
		// DELETED ALL THE RECORDS
		title("VALIDATE THE UPDATED RISK SCORING CARD IN THE PORTFOLIO DASHBOARD SCREEN AFTER DELETED ALL THE RECORDS");

		try {

			// wait for the element
			Thread.sleep(5000);

			// click on the side menu
			click("menubtn_CSS");

			// wait for the element
			Thread.sleep(5000);

			// click on the portfolio dashboard from side menu
			click("sidemenu_portfoliosummary_XPATH");

			// scrolldown till risk scoring card
			scrollTillElement("customform_portfoliodashboard_riskscoringcard_XPATH");

			// validate the average risk score of the all the properties
			try {
				String avgScore = (driver
						.findElement(By.xpath(
								OR.getProperty("customform_portfoliodashboard_riskscoringcard_averagescore_XPATH")))
						.getText()).trim();
				int avgScore_actual = Integer.parseInt(avgScore);
				int updatescore_expected = 0;

				if (avgScore_actual == updatescore_expected) {
					successMessage("The updated average risk score of the all the properties is displayed correctly.");
				} else {
					verificationFailedMessage(
							"The updated average risk score of the all the properties is not displayed correctly.");
				}
			} catch (Throwable t) {
				verificationFailedMessage(
						"The updated average risk score of the all the properties is not displayed correctly.");
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

		// VALIDATE THE UPDATED RISK SCORING CARD IN THE PROPERTY SUMMARY DASHBOARD
		// SCREEN AFTER DELETED ALL THE RECORDS
		title("VALIDATE THE UPDATED RISK SCORING CARD IN THE PROPERTY SUMMARY DASHBOARD SCREEN AFTER DELETED ALL THE RECORDS");

		try {

			// wait for the element
			Thread.sleep(5000);

			// click on the property
			click("propertysummary_property1_XPATH");

			// scrolldown till risk scoring card
			scrollTillElement("customform_portfoliodashboard_riskscoringcard_XPATH");

			// validate the risk score of the property
			try {
				String updateScore = (driver
						.findElement(By.xpath(
								OR.getProperty("customform_propertydashboard_riskscoringcard_averagescore1_XPATH")))
						.getText()).trim();
				int avgScore_actual = Integer.parseInt(updateScore);
				int updatescore_expected = 0;

				if (avgScore_actual == updatescore_expected) {
					successMessage("The updated risk score for the property is displayed correctly.");
				} else {
					verificationFailedMessage("The updated risk score for the property is not displayed correctly.");
				}
			} catch (Throwable t) {
				verificationFailedMessage("The updated risk score for the property is not displayed correctly.");
			}

			// validate the average risk score of the other properties
			try {
				String updateScore = (driver
						.findElement(By.xpath(
								OR.getProperty("customform_propertydashboard_riskscoringcard_averagescore2_XPATH")))
						.getText()).trim();
				int avgScore_actual = Integer.parseInt(updateScore);
				int updatescore_expected = 0;

				if (avgScore_actual == updatescore_expected) {
					successMessage("The updated average risk score of the other properties is displayed correctly.");
				} else {
					verificationFailedMessage(
							"The updated average risk score of the other properties is not displayed correctly.");
				}
			} catch (Throwable t) {
				verificationFailedMessage(
						"The updated average risk score of the other properties is not displayed correctly.");
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

	}
}
