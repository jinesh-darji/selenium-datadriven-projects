package testcases.E2Etestcasesuite.environmentalmodule;

import java.io.IOException;
import java.util.Hashtable;
import java.util.List;

import org.apache.commons.lang3.RandomStringUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import base.TestBase;
import utilities.TestUtil;

public class RR6552Environmental2Test extends TestBase {

	@Test(dataProviderClass = TestUtil.class, dataProvider = "dp")
	public void rR6552Environmental2Test(Hashtable<String, String> data) throws InterruptedException, IOException {

		execution(data, "rR6552Environmental2Test");

		// VERIFY THE RISK SCORE OF THE ENVIRONMENTAL RECORD ON THE PROPERTY SUMMARY
		// DASHBOARD AND PORTFOLIO DASHBOARD WITH MULTIPLE PROPERTY.
		title("VERIFY THE RISK SCORE OF THE ENVIRONMENTAL RECORD ON THE PROPERTY SUMMARY DASHBOARD AND PORTFOLIO DASHBOARD WITH MULTIPLE PROPERTY.");

		// refresh the page
		driver.navigate().refresh();
		Thread.sleep(5000);
		driver.navigate().refresh();

		// DELETE ALL THE PREVIOUSLY ADDED ENVIRONMENTAL RECORDS FROM THE PROPERTY ONE
		title("DELETE ALL THE PREVIOUSLY ADDED ENVIRONMENTAL RECORDS FROM THE PROPERTY ONE");

		try {

			// enter the property name in the search field
			type("ohs_incidentreport_searchtxt_XPATH", data.get("property_1"));

			// wait for the element
			explicitWaitClickable("environmentalicon_CSS");

			// click on the environmental icon from the property list page
			click("environmentalicon_CSS");

			// click on the burger menu
			click("menubtn_CSS");

			// wait for the element
			explicitWaitClickable("envrecords_XPATH");

			// click on the environmental records
			click("envrecords_XPATH");

			// click on the Primary Hazardous Substance
			click("envrecords_primaryhazardoussubstance_XPATH");

			// click on the asbestos materials
			click("envreports_asbestosmaterials_XPATH");

			// delete all the environmental records
			try {
				List<WebElement> list = driver
						.findElements(By.xpath(OR.getProperty("envreports_asbestosmaterials_recordlist_XPATH")));
				int list_count = list.size();

				for (int i = 1; i <= list_count; i++) {

					// click on the first record of the environmental record
					String firstRecird = "//table[@id='environmentalDocumentListTable']//tbody//tr[" + i
							+ "]//td[@id='asbestosMaterial']";
					driver.findElement(By.xpath(firstRecird)).click();
					consoleMessage("Clicked on the first record of the environmental record.");

					// wait for the element
					explicitWaitClickable("envreports_asbestosmaterials_deletebtn_CSS");

					// click on the delete button
					click("envreports_asbestosmaterials_deletebtn_CSS");

					// wait for the element
					explicitWaitClickable("envreports_asbestosmaterials_modeldeletebtn_CSS");

					// click on the delete button of the confirmation model
					click("envreports_asbestosmaterials_modeldeletebtn_CSS");

					// wait for the element
					explicitWaitClickable("closetoastmsg_CSS");

					// click on the toaster close button
					click("closetoastmsg_CSS");

				}
			} catch (Throwable t) {
				successMessage("All the environmental records are deleted successfully.");
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

		// DELETE ALL THE PREVIOUSLY ADDED ENVIRONMENTAL RECORDS FROM THE PROPERTY TWO
		title("DELETE ALL THE PREVIOUSLY ADDED ENVIRONMENTAL RECORDS FROM THE PROPERTY TWO");

		try {

			// enter the property name in the search field
			type("ohs_incidentreport_searchtxt_XPATH", data.get("property_2"));

			// wait for the element
			explicitWaitClickable("environmentalicon_CSS");

			// click on the environmental icon from the property list page
			click("environmentalicon_CSS");

			// click on the burger menu
			click("menubtn_CSS");

			// wait for the element
			explicitWaitClickable("envrecords_XPATH");

			// click on the environmental records
			click("envrecords_XPATH");

			// click on the Primary Hazardous Substance
			click("envrecords_primaryhazardoussubstance_XPATH");

			// click on the asbestos materials
			click("envreports_asbestosmaterials_XPATH");

			// delete all the environmental records
			try {
				List<WebElement> list = driver
						.findElements(By.xpath(OR.getProperty("envreports_asbestosmaterials_recordlist_XPATH")));
				int list_count = list.size();

				for (int i = 1; i <= list_count; i++) {

					// click on the first record of the environmental record
					String firstRecird = "//table[@id='environmentalDocumentListTable']//tbody//tr[" + i
							+ "]//td[@id='asbestosMaterial']";
					driver.findElement(By.xpath(firstRecird)).click();
					consoleMessage("Clicked on the first record of the environmental record.");

					// wait for the element
					explicitWaitClickable("envreports_asbestosmaterials_deletebtn_CSS");

					// click on the delete button
					click("envreports_asbestosmaterials_deletebtn_CSS");

					// wait for the element
					explicitWaitClickable("envreports_asbestosmaterials_modeldeletebtn_CSS");

					// click on the delete button of the confirmation model
					click("envreports_asbestosmaterials_modeldeletebtn_CSS");

					// wait for the element
					explicitWaitClickable("closetoastmsg_CSS");

					// click on the toaster close button
					click("closetoastmsg_CSS");

				}
			} catch (Throwable t) {
				successMessage("All the environmental records are deleted successfully.");
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

		// DELETE ALL THE PREVIOUSLY ADDED ENVIRONMENTAL RECORDS FROM THE PROPERTY THREE
		title("DELETE ALL THE PREVIOUSLY ADDED ENVIRONMENTAL RECORDS FROM THE PROPERTY THREE");

		try {

			// enter the property name in the search field
			type("ohs_incidentreport_searchtxt_XPATH", data.get("property_3"));

			// wait for the element
			explicitWaitClickable("environmentalicon_CSS");

			// click on the environmental icon from the property list page
			click("environmentalicon_CSS");

			// click on the burger menu
			click("menubtn_CSS");

			// wait for the element
			explicitWaitClickable("envrecords_XPATH");

			// click on the environmental records
			click("envrecords_XPATH");

			// click on the Primary Hazardous Substance
			click("envrecords_primaryhazardoussubstance_XPATH");

			// click on the asbestos materials
			click("envreports_asbestosmaterials_XPATH");

			// delete all the environmental records
			try {
				List<WebElement> list = driver
						.findElements(By.xpath(OR.getProperty("envreports_asbestosmaterials_recordlist_XPATH")));
				int list_count = list.size();

				for (int i = 1; i <= list_count; i++) {

					// click on the first record of the environmental record
					String firstRecird = "//table[@id='environmentalDocumentListTable']//tbody//tr[" + i
							+ "]//td[@id='asbestosMaterial']";
					driver.findElement(By.xpath(firstRecird)).click();
					consoleMessage("Clicked on the first record of the environmental record.");

					// wait for the element
					explicitWaitClickable("envreports_asbestosmaterials_deletebtn_CSS");

					// click on the delete button
					click("envreports_asbestosmaterials_deletebtn_CSS");

					// wait for the element
					explicitWaitClickable("envreports_asbestosmaterials_modeldeletebtn_CSS");

					// click on the delete button of the confirmation model
					click("envreports_asbestosmaterials_modeldeletebtn_CSS");

					// wait for the element
					explicitWaitClickable("closetoastmsg_CSS");

					// click on the toaster close button
					click("closetoastmsg_CSS");

				}
			} catch (Throwable t) {
				successMessage("All the environmental records are deleted successfully.");
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

		// CREATE NEW RECORD OF THE ENVIRONMENTAL RECORD WITH THE RISK SCORE IN PROPERTY
		// ONE
		title("CREATE NEW RECORD OF THE ENVIRONMENTAL RECORD WITH THE RISK SCORE IN PROPERTY ONE");

		String location_description1 = RandomStringUtils.randomAlphabetic(8);
		String score1 = RandomStringUtils.randomNumeric(2);

		try {

			// enter the property name in the search field
			type("ohs_incidentreport_searchtxt_XPATH", data.get("property_1"));

			// wait for the element
			explicitWaitClickable("environmentalicon_CSS");

			// click on the environmental icon from the property list page
			click("environmentalicon_CSS");

			// click on the burger menu
			click("menubtn_CSS");

			// wait for the element
			explicitWaitClickable("envrecords_XPATH");

			// click on the environmental records
			click("envrecords_XPATH");

			// click on the Primary Hazardous Substance
			click("envrecords_primaryhazardoussubstance_XPATH");

			// click on the asbestos materials
			click("envreports_asbestosmaterials_XPATH");

			// click on the add button
			click("envreports_asbestosmaterials_addbtn_CSS");

			// select the material
			select("envreports_asbestosmaterials_materialdd_CSS", data.get("material"));

			// enter the detailed description
			type("envreports_asbestosmaterials_detaileddescriptiontxt_CSS", data.get("detailed_description"));

			// enter the detailed location
			type("envreports_asbestosmaterials_detailedlocationtxt_CSS", location_description1);

			// scroll down the screen
			scrollByPixel(400);

			// select the estimated risk
			select("envreports_asbestosmaterials_estimatedriskdd_CSS", data.get("estimated_risk"));

			// select the is material asbestos containing
			select("envreports_asbestosmaterials_ismaterialasbestoscontainingdd_CSS",
					data.get("is_material_asbestos_containing"));

			// select the asbestos type
			select("envreports_asbestosmaterials_asbestostypedd_CSS", data.get("asbestos_type"));

			// select the condition
			select("envreports_asbestosmaterials_conditiondd_CSS", data.get("condition"));

			// select the status
			select("envreports_asbestosmaterials_statusdd_CSS", data.get("status"));

			// scroll till bottom of the page
			scrollByPixel(1000);

			// enter the details
			type("envreports_asbestosmaterials_detailstxt_CSS", data.get("details"));

			// scroll up the screen
			scrollTop();

			// click on the risk scoring tab
			click("envreports_asbestosmaterials_riskscoringtab_XPATH");

			// select on the risk category option
			select("envreports_asbestosmaterials_riskcategorydd_XPATH", data.get("score_category"));

			// enter the score in the score field
			type("envreports_asbestosmaterials_scoretxt_XPATH", score1);

			// select the option from the status dropdown
			select("envreports_asbestosmaterials_statusdd_XPATH", data.get("risk_status"));

			// enter the text in description field
			type("envreports_asbestosmaterials_descriptiontxt_XPATH", data.get("details"));

			// click on the save button
			click("envreports_asbestosmaterials_savebtn_CSS");

			// wait for the element
			explicitWaitClickable("closetoastmsg_CSS");

			// click on the toaster close button
			click("closetoastmsg_CSS");

			// enter the newly created environmental record in the search field
			type("task_listofchecklist_filterfield_CSS", location_description1);

			// verify added details of the Asbestos Materials record is correct or not in
			// property one
			try {
				String envrecord1 = "//span[text()='" + location_description1 + "']";
				String envrecord1_actual = (driver.findElement(By.xpath(envrecord1)).getText()).trim();

				if (envrecord1_actual.equals(location_description1)) {
					successMessage("The newly created environmental record in property one is displayed successfully.");
				} else {
					verificationFailedMessage(
							"The newly created environmental record in property one is not displayed.");
				}
			} catch (Throwable t) {
				verificationFailedMessage("The newly created environmental record in property one is not displayed.");
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

		// CREATE NEW RECORD OF THE ENVIRONMENTAL RECORD WITH THE RISK SCORE IN PROPERTY
		// TWO
		title("CREATE NEW RECORD OF THE ENVIRONMENTAL RECORD WITH THE RISK SCORE IN PROPERTY TWO");

		String location_description2 = RandomStringUtils.randomAlphabetic(8);
		String score2 = RandomStringUtils.randomNumeric(2);

		try {

			// enter the property name in the search field
			type("ohs_incidentreport_searchtxt_XPATH", data.get("property_2"));

			// wait for the element
			explicitWaitClickable("environmentalicon_CSS");

			// click on the environmental icon from the property list page
			click("environmentalicon_CSS");

			// click on the burger menu
			click("menubtn_CSS");

			// wait for the element
			explicitWaitClickable("envrecords_XPATH");

			// click on the environmental records
			click("envrecords_XPATH");

			// click on the Primary Hazardous Substance
			click("envrecords_primaryhazardoussubstance_XPATH");

			// click on the asbestos materials
			click("envreports_asbestosmaterials_XPATH");

			// click on the add button
			click("envreports_asbestosmaterials_addbtn_CSS");

			// select the material
			select("envreports_asbestosmaterials_materialdd_CSS", data.get("material"));

			// enter the detailed description
			type("envreports_asbestosmaterials_detaileddescriptiontxt_CSS", data.get("detailed_description"));

			// enter the detailed location
			type("envreports_asbestosmaterials_detailedlocationtxt_CSS", location_description2);

			// scroll down the screen
			scrollByPixel(400);

			// select the estimated risk
			select("envreports_asbestosmaterials_estimatedriskdd_CSS", data.get("estimated_risk"));

			// select the is material asbestos containing
			select("envreports_asbestosmaterials_ismaterialasbestoscontainingdd_CSS",
					data.get("is_material_asbestos_containing"));

			// select the asbestos type
			select("envreports_asbestosmaterials_asbestostypedd_CSS", data.get("asbestos_type"));

			// select the condition
			select("envreports_asbestosmaterials_conditiondd_CSS", data.get("condition"));

			// select the status
			select("envreports_asbestosmaterials_statusdd_CSS", data.get("status"));

			// scroll till bottom of the page
			scrollByPixel(1000);

			// enter the details
			type("envreports_asbestosmaterials_detailstxt_CSS", data.get("details"));

			// scroll up the screen
			scrollTop();

			// click on the risk scoring tab
			click("envreports_asbestosmaterials_riskscoringtab_XPATH");

			// select on the risk category option
			select("envreports_asbestosmaterials_riskcategorydd_XPATH", data.get("score_category"));

			// enter the score in the score field
			type("envreports_asbestosmaterials_scoretxt_XPATH", score2);

			// select the option from the status dropdown
			select("envreports_asbestosmaterials_statusdd_XPATH", data.get("risk_status"));

			// enter the text in description field
			type("envreports_asbestosmaterials_descriptiontxt_XPATH", data.get("details"));

			// click on the save button
			click("envreports_asbestosmaterials_savebtn_CSS");

			// wait for the element
			explicitWaitClickable("closetoastmsg_CSS");

			// click on the toaster close button
			click("closetoastmsg_CSS");

			// enter the newly created environmental record in the search field
			type("task_listofchecklist_filterfield_CSS", location_description2);

			// verify added details of the Asbestos Materials record is correct or not in
			// property two
			try {
				String envrecord2 = "//span[text()='" + location_description2 + "']";
				String envrecord2_actual = (driver.findElement(By.xpath(envrecord2)).getText()).trim();

				if (envrecord2_actual.equals(location_description2)) {
					successMessage("The newly created environmental record in property two is displayed successfully.");
				} else {
					verificationFailedMessage(
							"The newly created environmental record in property two is not displayed.");
				}
			} catch (Throwable t) {
				verificationFailedMessage("The newly created environmental record in property two is not displayed.");
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

		// CREATE NEW RECORD OF THE ENVIRONMENTAL RECORD WITH THE RISK SCORE IN PROPERTY
		// THREE
		title("CREATE NEW RECORD OF THE ENVIRONMENTAL RECORD WITH THE RISK SCORE IN PROPERTY THREE");

		String location_description3 = RandomStringUtils.randomAlphabetic(8);
		String score3 = RandomStringUtils.randomNumeric(2);

		try {

			// enter the property name in the search field
			type("ohs_incidentreport_searchtxt_XPATH", data.get("property_3"));

			// wait for the element
			explicitWaitClickable("environmentalicon_CSS");

			// click on the environmental icon from the property list page
			click("environmentalicon_CSS");

			// click on the burger menu
			click("menubtn_CSS");

			// wait for the element
			explicitWaitClickable("envrecords_XPATH");

			// click on the environmental records
			click("envrecords_XPATH");

			// click on the Primary Hazardous Substance
			click("envrecords_primaryhazardoussubstance_XPATH");

			// click on the asbestos materials
			click("envreports_asbestosmaterials_XPATH");

			// click on the add button
			click("envreports_asbestosmaterials_addbtn_CSS");

			// select the material
			select("envreports_asbestosmaterials_materialdd_CSS", data.get("material"));

			// enter the detailed description
			type("envreports_asbestosmaterials_detaileddescriptiontxt_CSS", data.get("detailed_description"));

			// enter the detailed location
			type("envreports_asbestosmaterials_detailedlocationtxt_CSS", location_description3);

			// scroll down the screen
			scrollByPixel(400);

			// select the estimated risk
			select("envreports_asbestosmaterials_estimatedriskdd_CSS", data.get("estimated_risk"));

			// select the is material asbestos containing
			select("envreports_asbestosmaterials_ismaterialasbestoscontainingdd_CSS",
					data.get("is_material_asbestos_containing"));

			// select the asbestos type
			select("envreports_asbestosmaterials_asbestostypedd_CSS", data.get("asbestos_type"));

			// select the condition
			select("envreports_asbestosmaterials_conditiondd_CSS", data.get("condition"));

			// select the status
			select("envreports_asbestosmaterials_statusdd_CSS", data.get("status"));

			// scroll till bottom of the page
			scrollByPixel(1000);

			// enter the details
			type("envreports_asbestosmaterials_detailstxt_CSS", data.get("details"));

			// scroll up the screen
			scrollTop();

			// click on the risk scoring tab
			click("envreports_asbestosmaterials_riskscoringtab_XPATH");

			// select on the risk category option
			select("envreports_asbestosmaterials_riskcategorydd_XPATH", data.get("score_category"));

			// enter the score in the score field
			type("envreports_asbestosmaterials_scoretxt_XPATH", score3);

			// select the option from the status dropdown
			select("envreports_asbestosmaterials_statusdd_XPATH", data.get("risk_status"));

			// enter the text in description field
			type("envreports_asbestosmaterials_descriptiontxt_XPATH", data.get("details"));

			// click on the save button
			click("envreports_asbestosmaterials_savebtn_CSS");

			// wait for the element
			explicitWaitClickable("closetoastmsg_CSS");

			// click on the toaster close button
			click("closetoastmsg_CSS");

			// enter the newly created environmental record in the search field
			type("task_listofchecklist_filterfield_CSS", location_description3);

			// verify added details of the Asbestos Materials record is correct or not in
			// property three
			try {
				String envrecord3 = "//span[text()='" + location_description3 + "']";
				String envrecord3_actual = (driver.findElement(By.xpath(envrecord3)).getText()).trim();

				if (envrecord3_actual.equals(location_description3)) {
					successMessage(
							"The newly created environmental record in property three is displayed successfully.");
				} else {
					verificationFailedMessage(
							"The newly created environmental record in property three is not displayed.");
				}
			} catch (Throwable t) {
				verificationFailedMessage("The newly created environmental record in property three is not displayed.");
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
				float score1_float = Float.parseFloat(score1);
				float score2_float = Float.parseFloat(score2);
				float score3_float = Float.parseFloat(score3);
				float score_float1 = score1_float + score2_float + score3_float;
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
				int score_expected = Integer.parseInt(score1);

				if (avgScore_actual == score_expected) {
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
				float score2_float = Float.parseFloat(score2);
				float score3_float = Float.parseFloat(score3);
				float score_float1 = score2_float + score3_float;
				float score_float2 = score_float1 / 3f;
				int score_expected = Math.round(score_float2);

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

		// UPDATE THE RISK SCORE OF THE ENVIRONMENTAL RECORD IN PROPERTY ONE
		title("UPDATE THE RISK SCORE OF THE ENVIRONMENTAL RECORD IN PROPERTY ONE");

		String updatescore1 = RandomStringUtils.randomNumeric(2);

		try {

			// enter the property name in the search field
			type("ohs_incidentreport_searchtxt_XPATH", data.get("property_1"));

			// wait for the element
			explicitWaitClickable("environmentalicon_CSS");

			// click on the environmental icon from the property list page
			click("environmentalicon_CSS");

			// click on the burger menu
			click("menubtn_CSS");

			// wait for the element
			explicitWaitClickable("envrecords_XPATH");

			// click on the environmental records
			click("envrecords_XPATH");

			// click on the Primary Hazardous Substance
			click("envrecords_primaryhazardoussubstance_XPATH");

			// click on the asbestos materials
			click("envreports_asbestosmaterials_XPATH");

			// click on the newly created environmental record
			String envrecord1 = "//span[text()='" + location_description1 + "']";
			driver.findElement(By.xpath(envrecord1)).click();
			consoleMessage("Clicked on the newly created environmental record.");

			// click on the risk scoring tab
			click("envreports_asbestosmaterials_riskscoringtab_XPATH");

			// select on the risk category option
			select("envreports_asbestosmaterials_riskcategorydd_XPATH", data.get("score_category_update"));

			// enter the score in the score field
			type("envreports_asbestosmaterials_scoretxt_XPATH", updatescore1);

			// select the option from the status dropdown
			select("envreports_asbestosmaterials_statusdd_XPATH", data.get("risk_status_update"));

			// enter the text in description field
			type("envreports_asbestosmaterials_descriptiontxt_XPATH", data.get("details"));

			// click on the update button
			click("envreports_asbestosmaterials_updatebtn_CSS");

			// wait for the element
			explicitWaitClickable("closetoastmsg_CSS");

			// click on the toaster close button
			click("closetoastmsg_CSS");

			// enter the newly created environmental record in the search field
			type("task_listofchecklist_filterfield_CSS", location_description1);

			// verify added details of the Asbestos Materials record is correct or not in
			// property one
			try {
				envrecord1 = "//span[text()='" + location_description1 + "']";
				String envrecord1_actual = (driver.findElement(By.xpath(envrecord1)).getText()).trim();

				if (envrecord1_actual.equals(location_description1)) {
					successMessage("The newly created environmental record in property one is displayed successfully.");
				} else {
					verificationFailedMessage(
							"The newly created environmental record in property one is not displayed.");
				}
			} catch (Throwable t) {
				verificationFailedMessage("The newly created environmental record in property one is not displayed.");
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

		// UPDATE THE RISK SCORE OF THE ENVIRONMENTAL RECORD IN PROPERTY TWO
		title("UPDATE THE RISK SCORE OF THE ENVIRONMENTAL RECORD IN PROPERTY TWO");

		String updatescore2 = RandomStringUtils.randomNumeric(2);

		try {

			// enter the property name in the search field
			type("ohs_incidentreport_searchtxt_XPATH", data.get("property_2"));

			// wait for the element
			explicitWaitClickable("environmentalicon_CSS");

			// click on the environmental icon from the property list page
			click("environmentalicon_CSS");

			// click on the burger menu
			click("menubtn_CSS");

			// wait for the element
			explicitWaitClickable("envrecords_XPATH");

			// click on the environmental records
			click("envrecords_XPATH");

			// click on the Primary Hazardous Substance
			click("envrecords_primaryhazardoussubstance_XPATH");

			// click on the asbestos materials
			click("envreports_asbestosmaterials_XPATH");

			// click on the newly created environmental record
			String envrecord1 = "//span[text()='" + location_description2 + "']";
			driver.findElement(By.xpath(envrecord1)).click();
			consoleMessage("Clicked on the newly created environmental record.");

			// click on the risk scoring tab
			click("envreports_asbestosmaterials_riskscoringtab_XPATH");

			// select on the risk category option
			select("envreports_asbestosmaterials_riskcategorydd_XPATH", data.get("score_category_update"));

			// enter the score in the score field
			type("envreports_asbestosmaterials_scoretxt_XPATH", updatescore2);

			// select the option from the status dropdown
			select("envreports_asbestosmaterials_statusdd_XPATH", data.get("risk_status_update"));

			// enter the text in description field
			type("envreports_asbestosmaterials_descriptiontxt_XPATH", data.get("details"));

			// click on the update button
			click("envreports_asbestosmaterials_updatebtn_CSS");

			// wait for the element
			explicitWaitClickable("closetoastmsg_CSS");

			// click on the toaster close button
			click("closetoastmsg_CSS");

		} catch (Throwable t) {
			verificationFailed();
		}

		// click on the home icon from the top of the screen
		click("questionnaire_homeburgermenubtn_hide_CSS");

		// wait for the element
		explicitWait("propertylist_title_XPATH");

		// verify the property list
		switchVerification("propertylist_title_XPATH", "Property List", "The property list is not displayed.");

		// UPDATE THE RISK SCORE OF THE ENVIRONMENTAL RECORD IN PROPERTY THREE
		title("UPDATE THE RISK SCORE OF THE ENVIRONMENTAL RECORD IN PROPERTY THREE");

		String updatescore3 = RandomStringUtils.randomNumeric(2);

		try {

			// enter the property name in the search field
			type("ohs_incidentreport_searchtxt_XPATH", data.get("property_3"));

			// wait for the element
			explicitWaitClickable("environmentalicon_CSS");

			// click on the environmental icon from the property list page
			click("environmentalicon_CSS");

			// click on the burger menu
			click("menubtn_CSS");

			// wait for the element
			explicitWaitClickable("envrecords_XPATH");

			// click on the environmental records
			click("envrecords_XPATH");

			// click on the Primary Hazardous Substance
			click("envrecords_primaryhazardoussubstance_XPATH");

			// click on the asbestos materials
			click("envreports_asbestosmaterials_XPATH");

			// click on the newly created environmental record
			String envrecord1 = "//span[text()='" + location_description3 + "']";
			driver.findElement(By.xpath(envrecord1)).click();
			consoleMessage("Clicked on the newly created environmental record.");

			// click on the risk scoring tab
			click("envreports_asbestosmaterials_riskscoringtab_XPATH");

			// select on the risk category option
			select("envreports_asbestosmaterials_riskcategorydd_XPATH", data.get("score_category_update"));

			// enter the score in the score field
			type("envreports_asbestosmaterials_scoretxt_XPATH", updatescore3);

			// select the option from the status dropdown
			select("envreports_asbestosmaterials_statusdd_XPATH", data.get("risk_status_update"));

			// enter the text in description field
			type("envreports_asbestosmaterials_descriptiontxt_XPATH", data.get("details"));

			// click on the update button
			click("envreports_asbestosmaterials_updatebtn_CSS");

			// wait for the element
			explicitWaitClickable("closetoastmsg_CSS");

			// click on the toaster close button
			click("closetoastmsg_CSS");

			// enter the newly created environmental record in the search field
			type("task_listofchecklist_filterfield_CSS", location_description3);

			// verify added details of the Asbestos Materials record is correct or not in
			// property three
			try {
				envrecord1 = "//span[text()='" + location_description3 + "']";
				String envrecord1_actual = (driver.findElement(By.xpath(envrecord1)).getText()).trim();

				if (envrecord1_actual.equals(location_description3)) {
					successMessage(
							"The newly created environmental record in property three is displayed successfully.");
				} else {
					verificationFailedMessage(
							"The newly created environmental record in property three is not displayed.");
				}
			} catch (Throwable t) {
				verificationFailedMessage("The newly created environmental record in property three is not displayed.");
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
				float updatescore1_float = Float.parseFloat(updatescore1);
				float updatescore2_float = Float.parseFloat(updatescore2);
				float updatescore3_float = Float.parseFloat(updatescore3);
				float updatescore_float1 = updatescore1_float + updatescore2_float + updatescore3_float;
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
				int updatescore_expected = Integer.parseInt(updatescore1);

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
				float updatescore2_float = Float.parseFloat(updatescore2);
				float updatescore3_float = Float.parseFloat(updatescore3);
				float updatescore_float1 = updatescore2_float + updatescore3_float;
				float updatescore_float2 = updatescore_float1 / 3f;
				double updatescore_expected = Math.round(updatescore_float2);

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

		// DELETE THE ENVIRONMENTAL RECORD FROM PROPERTY ONE
		title("DELETE THE ENVIRONMENTAL RECORD FROM PROPERTY ONE");

		try {

			// enter the property name in the search field
			type("ohs_incidentreport_searchtxt_XPATH", data.get("property_1"));

			// wait for the element
			explicitWaitClickable("environmentalicon_CSS");

			// click on the environmental icon from the property list page
			click("environmentalicon_CSS");

			// click on the burger menu
			click("menubtn_CSS");

			// wait for the element
			explicitWaitClickable("envrecords_XPATH");

			// click on the environmental records
			click("envrecords_XPATH");

			// click on the Primary Hazardous Substance
			click("envrecords_primaryhazardoussubstance_XPATH");

			// click on the asbestos materials
			click("envreports_asbestosmaterials_XPATH");

			// click on the newly created environmental record
			String envrecord = "//span[text()='" + location_description1 + "']";
			driver.findElement(By.xpath(envrecord)).click();
			consoleMessage("Clicked on the newly created environmental record.");

			// wait for the element
			explicitWaitClickable("envreports_asbestosmaterials_deletebtn_CSS");

			// click on the delete button
			click("envreports_asbestosmaterials_deletebtn_CSS");

			// wait for the element
			explicitWaitClickable("envreports_asbestosmaterials_modeldeletebtn_CSS");

			// click on the delete button of the confirmation model
			click("envreports_asbestosmaterials_modeldeletebtn_CSS");

			// wait for the element
			explicitWaitClickable("closetoastmsg_CSS");

			// click on the toaster close button
			click("closetoastmsg_CSS");

			// enter the newly created environmental record in the search field
			type("task_listofchecklist_filterfield_CSS", location_description1);

			// verify added details of the Asbestos Materials record is deleted or not
			try {
				envrecord = "//span[text()='" + location_description1 + "']";
				String envrecord_actual = (driver.findElement(By.xpath(envrecord)).getText()).trim();

				if (envrecord_actual.equals(location_description1)) {
					verificationFailedMessage(
							"The newly created environmental record of the property one is deleted successfully.");

				} else {
					successMessage("The newly created environmental record of the property one is not deleted.");
				}
			} catch (Throwable t) {
				successMessage("The newly created environmental record of the property one is deleted.");
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

		// DELETE THE ENVIRONMENTAL RECORD FROM PROPERTY TWO
		title("DELETE THE ENVIRONMENTAL RECORD FROM PROPERTY TWO");

		try {

			// enter the property name in the search field
			type("ohs_incidentreport_searchtxt_XPATH", data.get("property_2"));

			// wait for the element
			explicitWaitClickable("environmentalicon_CSS");

			// click on the environmental icon from the property list page
			click("environmentalicon_CSS");

			// click on the burger menu
			click("menubtn_CSS");

			// wait for the element
			explicitWaitClickable("envrecords_XPATH");

			// click on the environmental records
			click("envrecords_XPATH");

			// click on the Primary Hazardous Substance
			click("envrecords_primaryhazardoussubstance_XPATH");

			// click on the asbestos materials
			click("envreports_asbestosmaterials_XPATH");

			// click on the newly created environmental record
			String envrecord = "//span[text()='" + location_description2 + "']";
			driver.findElement(By.xpath(envrecord)).click();
			consoleMessage("Clicked on the newly created environmental record.");

			// wait for the element
			explicitWaitClickable("envreports_asbestosmaterials_deletebtn_CSS");

			// click on the delete button
			click("envreports_asbestosmaterials_deletebtn_CSS");

			// wait for the element
			explicitWaitClickable("envreports_asbestosmaterials_modeldeletebtn_CSS");

			// click on the delete button of the confirmation model
			click("envreports_asbestosmaterials_modeldeletebtn_CSS");

			// wait for the element
			explicitWaitClickable("closetoastmsg_CSS");

			// click on the toaster close button
			click("closetoastmsg_CSS");

			// enter the newly created environmental record in the search field
			type("task_listofchecklist_filterfield_CSS", location_description2);

			// verify added details of the Asbestos Materials record is deleted or not
			try {
				envrecord = "//span[text()='" + location_description2 + "']";
				String envrecord_actual = (driver.findElement(By.xpath(envrecord)).getText()).trim();

				if (envrecord_actual.equals(location_description2)) {
					verificationFailedMessage(
							"The newly created environmental record of the property two is deleted successfully.");

				} else {
					successMessage("The newly created environmental record of the property two is not deleted.");
				}
			} catch (Throwable t) {
				successMessage("The newly created environmental record of the property two is deleted.");
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

		// DELETE THE ENVIRONMENTAL RECORD FROM PROPERTY THREE
		title("DELETE THE ENVIRONMENTAL RECORD FROM PROPERTY THREE");

		try {

			// enter the property name in the search field
			type("ohs_incidentreport_searchtxt_XPATH", data.get("property_3"));

			// wait for the element
			explicitWaitClickable("environmentalicon_CSS");

			// click on the environmental icon from the property list page
			click("environmentalicon_CSS");

			// click on the burger menu
			click("menubtn_CSS");

			// wait for the element
			explicitWaitClickable("envrecords_XPATH");

			// click on the environmental records
			click("envrecords_XPATH");

			// click on the Primary Hazardous Substance
			click("envrecords_primaryhazardoussubstance_XPATH");

			// click on the asbestos materials
			click("envreports_asbestosmaterials_XPATH");

			// click on the newly created environmental record
			String envrecord = "//span[text()='" + location_description3 + "']";
			driver.findElement(By.xpath(envrecord)).click();
			consoleMessage("Clicked on the newly created environmental record.");

			// wait for the element
			explicitWaitClickable("envreports_asbestosmaterials_deletebtn_CSS");

			// click on the delete button
			click("envreports_asbestosmaterials_deletebtn_CSS");

			// wait for the element
			explicitWaitClickable("envreports_asbestosmaterials_modeldeletebtn_CSS");

			// click on the delete button of the confirmation model
			click("envreports_asbestosmaterials_modeldeletebtn_CSS");

			// wait for the element
			explicitWaitClickable("closetoastmsg_CSS");

			// click on the toaster close button
			click("closetoastmsg_CSS");

			// enter the newly created environmental record in the search field
			type("task_listofchecklist_filterfield_CSS", location_description3);

			// verify added details of the Asbestos Materials record is deleted or not
			try {
				envrecord = "//span[text()='" + location_description3 + "']";
				String envrecord_actual = (driver.findElement(By.xpath(envrecord)).getText()).trim();

				if (envrecord_actual.equals(location_description3)) {
					verificationFailedMessage(
							"The newly created environmental record of the property three is deleted successfully.");

				} else {
					successMessage("The newly created environmental record of the property three is not deleted.");
				}
			} catch (Throwable t) {
				successMessage("The newly created environmental record of the property three is deleted.");
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
