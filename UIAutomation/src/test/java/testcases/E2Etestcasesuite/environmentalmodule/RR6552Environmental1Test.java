package testcases.E2Etestcasesuite.environmentalmodule;

import java.io.IOException;
import java.text.DecimalFormat;
import java.time.LocalDate;
import java.util.Hashtable;
import java.util.List;

import org.apache.commons.lang3.RandomStringUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import base.TestBase;
import utilities.TestUtil;

public class RR6552Environmental1Test extends TestBase {

	@Test(dataProviderClass = TestUtil.class, dataProvider = "dp")
	public void rR6552Environmental1Test(Hashtable<String, String> data) throws InterruptedException, IOException {

		execution(data, "rR6552Environmental1Test");

		// VERIFY THE RISK SCORE OF THE ENVIRONMENTAL RECORD ON THE PROPERTY SUMMARY
		// DASHBOARD AND PORTFOLIO DASHBOARD WITH SINGLE PROPERTY.
		title("VERIFY THE RISK SCORE OF THE ENVIRONMENTAL RECORD ON THE PROPERTY SUMMARY DASHBOARD AND PORTFOLIO DASHBOARD WITH SINGLE PROPERTY.");

		// refresh the page
		driver.navigate().refresh();
		Thread.sleep(5000);
		driver.navigate().refresh();

		String[] todayDate = LocalDate.now().toString().split("-");

		// DELETE ALL THE PREVIOUSLY ADDED ENVIRONMENTAL RECORDS FROM THE PROPERTY ONE
		title("DELETE ALL THE PREVIOUSLY ADDED ENVIRONMENTAL RECORDS FROM THE PROPERTY ONE");

		try {

			// enter the property name in the search field
			type("ohs_incidentreport_searchtxt_XPATH", data.get("property_1"));

			// wait for the element
			explicitWaitClickable("environmentalicon_CSS");

			// click on the environmental icon from the property list page
			click("environmentalicon_CSS");

			// wait for the element
			Thread.sleep(5000);

			// click on the burger menu
			click("menubtn_CSS");

			// wait for the element
			Thread.sleep(5000);

			// click on the environmental records
			click("envrecords_XPATH");

			// wait for the element
			Thread.sleep(5000);

			// click on the Primary Hazardous Substance
			click("envrecords_primaryhazardoussubstance_XPATH");

			// wait for the element
			Thread.sleep(5000);

			// click on the asbestos materials
			click("envreports_asbestosmaterials_XPATH");

			// delete all the environmental records
			try {
				List<WebElement> list = driver
						.findElements(By.xpath(OR.getProperty("envreports_asbestosmaterials_recordlist_XPATH")));
				int list_count = list.size();

				for (int i = 1; i <= list_count; i++) {

					// click on the first record of the environmental record
					String firstRecird = "//table[@id='environmentalDocumentListTable']//tbody//tr[1]//td[@id='asbestosMaterial']";
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

		// CREATE NEW RECORD OF THE ENVIRONMENTAL RECORD WITH THE RISK SCORE
		title("CREATE NEW RECORD OF THE ENVIRONMENTAL RECORD WITH THE RISK SCORE");

		String location_description = RandomStringUtils.randomAlphabetic(8);
		String score_random = RandomStringUtils.randomNumeric(2);
		int score_int = Integer.parseInt(score_random);
		DecimalFormat df = new DecimalFormat("#.00");
		String score = df.format(score_int);

		try {

			// enter the property name in the search field
			type("ohs_incidentreport_searchtxt_XPATH", data.get("property_1"));

			// wait for the element
			explicitWaitClickable("environmentalicon_CSS");

			// click on the environmental icon from the property list page
			click("environmentalicon_CSS");

			// wait for the element
			Thread.sleep(5000);

			// click on the burger menu
			click("menubtn_CSS");

			// wait for the element
			Thread.sleep(5000);

			// click on the environmental records
			click("envrecords_XPATH");

			// wait for the element
			Thread.sleep(5000);

			// click on the Primary Hazardous Substance
			click("envrecords_primaryhazardoussubstance_XPATH");

			// wait for the element
			Thread.sleep(5000);

			// click on the asbestos materials
			click("envreports_asbestosmaterials_XPATH");

			// click on the add button
			click("envreports_asbestosmaterials_addbtn_CSS");

			// select the material
			select("envreports_asbestosmaterials_materialdd_CSS", data.get("material"));

			// enter the detailed description
			type("envreports_asbestosmaterials_detaileddescriptiontxt_CSS", data.get("detailed_description"));

			// enter the detailed location
			type("envreports_asbestosmaterials_detailedlocationtxt_CSS", location_description);

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
			type("envreports_asbestosmaterials_scoretxt_XPATH", score);

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
			type("task_listofchecklist_filterfield_CSS", location_description);

			// verify added details of the Asbestos Materials record is correct or not
			try {
				String envrecord = "//span[text()='" + location_description + "']";
				String envrecord_actual = (driver.findElement(By.xpath(envrecord)).getText()).trim();

				if (envrecord_actual.equals(location_description)) {
					successMessage("The newly created environmental record is displayed successfully.");
				} else {
					verificationFailedMessage("The newly created environmental record is not displayed.");
				}
			} catch (Throwable t) {
				verificationFailedMessage("The newly created environmental record is not displayed.");
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

			// click on the graph of the risk card
			click("customform_portfoliodashboard_riskscoringcard_graph_XPATH");

			// select the current year in the year dropdown
			select("customform_portfoliodashboard_riskscoringcard_yeardd_XPATH", todayDate[0]);

			// select the current year in the month dropdown
			String month = todayDate[1].replaceFirst("^0+(?!$)", "");
			select("customform_portfoliodashboard_riskscoringcard_monthdd_XPATH", month);

			// scroll down to bottom
			scrollBottom();

			// click on the property 1 name
			click("customform_portfoliodashboard_propertyname_XPATH");

			// scroll down to bottom
			scrollBottom();

			// validate the risk score of the environmental records of the property
			try {
				String Score2 = "//td[text()='Asbestos Materials']//following-sibling::td[@class='ng-binding']";
				String riskScore = (driver.findElement(By.xpath(Score2)).getText()).trim();

				if (riskScore.equals(score)) {
					successMessage(
							"The risk score of the environmental records of the property is displayed correctly.");
				} else {
					verificationFailedMessage(
							"The risk score of the environmental records of the property is not displayed correctly.");
				}
			} catch (Throwable t) {
				verificationFailedMessage(
						"The risk score of the environmental records of the property is not displayed correctly.");
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

			// click on the graph of the risk card
			click("customform_portfoliodashboard_riskscoringcard_graph_XPATH");

			// select the current year in the year dropdown
			select("customform_portfoliodashboard_riskscoringcard_yeardd_XPATH", todayDate[0]);

			// select the current year in the month dropdown
			String month = todayDate[1].replaceFirst("^0+(?!$)", "");
			select("customform_portfoliodashboard_riskscoringcard_monthdd_XPATH", month);

			// scroll down to bottom
			scrollBottom();

			// validate the risk score of the environmental records of the property
			try {
				String Score2 = "//td[text()='Asbestos Materials']//following-sibling::td[@class='ng-binding']";
				String riskScore = (driver.findElement(By.xpath(Score2)).getText()).trim();

				if (riskScore.equals(score)) {
					successMessage(
							"The risk score of the environmental records of the property is displayed correctly.");
				} else {
					verificationFailedMessage(
							"The risk score of the environmental records of the property is not displayed correctly.");
				}
			} catch (Throwable t) {
				verificationFailedMessage(
						"The risk score of the environmental records of the property is not displayed correctly.");
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

		// UPDATE THE RISK SCORE OF THE ENVIRONMENTAL RECORD
		title("UPDATE THE RISK SCORE OF THE ENVIRONMENTAL RECORD");

		String updatescore_random = RandomStringUtils.randomNumeric(2);
		int updatescore_int = Integer.parseInt(updatescore_random);
		String updatescore = df.format(updatescore_int);

		try {

			// enter the property name in the search field
			type("ohs_incidentreport_searchtxt_XPATH", data.get("property_1"));

			// wait for the element
			explicitWaitClickable("environmentalicon_CSS");

			// click on the environmental icon from the property list page
			click("environmentalicon_CSS");

			// wait for the element
			Thread.sleep(5000);

			// click on the burger menu
			click("menubtn_CSS");

			// wait for the element
			Thread.sleep(5000);

			// click on the environmental records
			click("envrecords_XPATH");

			// wait for the element
			Thread.sleep(5000);

			// click on the Primary Hazardous Substance
			click("envrecords_primaryhazardoussubstance_XPATH");

			// wait for the element
			Thread.sleep(5000);

			// click on the asbestos materials
			click("envreports_asbestosmaterials_XPATH");

			// click on the newly created environmental record
			String envrecord = "//span[text()='" + location_description + "']";
			driver.findElement(By.xpath(envrecord)).click();
			consoleMessage("Clicked on the newly created environmental record.");

			// click on the risk scoring tab
			click("envreports_asbestosmaterials_riskscoringtab_XPATH");

			// select on the risk category option
			select("envreports_asbestosmaterials_riskcategorydd_XPATH", data.get("score_category_update"));

			// enter the score in the score field
			type("envreports_asbestosmaterials_scoretxt_XPATH", updatescore);

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

			// click on the graph of the risk card
			click("customform_portfoliodashboard_riskscoringcard_graph_XPATH");

			// select the current year in the year dropdown
			select("customform_portfoliodashboard_riskscoringcard_yeardd_XPATH", todayDate[0]);

			// select the current year in the month dropdown
			String month = todayDate[1].replaceFirst("^0+(?!$)", "");
			select("customform_portfoliodashboard_riskscoringcard_monthdd_XPATH", month);

			// scroll down to bottom
			scrollBottom();

			// click on the property 1 name
			click("customform_portfoliodashboard_propertyname_XPATH");

			// scroll down to bottom
			scrollBottom();

			// validate the risk score of the environmental records of the property
			try {
				String Score2 = "//td[text()='Asbestos Materials']//following-sibling::td[@class='ng-binding']";
				String riskScore = (driver.findElement(By.xpath(Score2)).getText()).trim();

				if (riskScore.equals(updatescore)) {
					successMessage(
							"The risk score of the environmental records of the property is displayed correctly.");
				} else {
					verificationFailedMessage(
							"The risk score of the environmental records of the property is not displayed correctly.");
				}
			} catch (Throwable t) {
				verificationFailedMessage(
						"The risk score of the environmental records of the property is not displayed correctly.");
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

			// click on the graph of the risk card
			click("customform_portfoliodashboard_riskscoringcard_graph_XPATH");

			// select the current year in the year dropdown
			select("customform_portfoliodashboard_riskscoringcard_yeardd_XPATH", todayDate[0]);

			// select the current year in the month dropdown
			String month = todayDate[1].replaceFirst("^0+(?!$)", "");
			select("customform_portfoliodashboard_riskscoringcard_monthdd_XPATH", month);

			// scroll down to bottom
			scrollBottom();

			// validate the risk score of the environmental records of the property
			try {
				String Score2 = "//td[text()='Asbestos Materials']//following-sibling::td[@class='ng-binding']";
				String riskScore = (driver.findElement(By.xpath(Score2)).getText()).trim();

				if (riskScore.equals(updatescore)) {
					successMessage(
							"The risk score of the environmental records of the property is displayed correctly.");
				} else {
					verificationFailedMessage(
							"The risk score of the environmental records of the property is not displayed correctly.");
				}
			} catch (Throwable t) {
				verificationFailedMessage(
						"The risk score of the environmental records of the property is not displayed correctly.");
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

		// DELETE THE ENVIRONMENTAL RECORD
		title("DELETE THE ENVIRONMENTAL RECORD");

		try {

			// enter the property name in the search field
			type("ohs_incidentreport_searchtxt_XPATH", data.get("property_1"));

			// wait for the element
			explicitWaitClickable("environmentalicon_CSS");

			// click on the environmental icon from the property list page
			click("environmentalicon_CSS");

			// wait for the element
			Thread.sleep(5000);

			// click on the burger menu
			click("menubtn_CSS");

			// wait for the element
			Thread.sleep(5000);

			// click on the environmental records
			click("envrecords_XPATH");

			// wait for the element
			Thread.sleep(5000);

			// click on the Primary Hazardous Substance
			click("envrecords_primaryhazardoussubstance_XPATH");

			// wait for the element
			Thread.sleep(5000);

			// click on the asbestos materials
			click("envreports_asbestosmaterials_XPATH");

			// click on the newly created environmental record
			String envrecord = "//span[text()='" + location_description + "']";
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
			type("task_listofchecklist_filterfield_CSS", location_description);

			// verify added details of the Asbestos Materials record is deleted or not
			try {
				envrecord = "//span[text()='" + location_description + "']";
				String envrecord_actual = (driver.findElement(By.xpath(envrecord)).getText()).trim();

				if (envrecord_actual.equals(location_description)) {
					verificationFailedMessage("The newly created environmental record is deleted successfully.");

				} else {
					successMessage("The newly created environmental record is not deleted.");
				}
			} catch (Throwable t) {
				successMessage("The newly created environmental record is deleted.");
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

			// click on the graph of the risk card
			click("customform_portfoliodashboard_riskscoringcard_graph_XPATH");

			// select the current year in the year dropdown
			select("customform_portfoliodashboard_riskscoringcard_yeardd_XPATH", todayDate[0]);

			// select the current year in the month dropdown
			String month = todayDate[1].replaceFirst("^0+(?!$)", "");
			select("customform_portfoliodashboard_riskscoringcard_monthdd_XPATH", month);

			// scroll down to bottom
			scrollBottom();

			// validate the deleted risk score of the property
			try {

				boolean propertyName = driver
						.findElement(By.xpath(OR.getProperty("customform_portfoliodashboard_propertyname_XPATH")))
						.isDisplayed();

				if (propertyName == true) {

					// click on the property 1 name
					click("customform_portfoliodashboard_propertyname_XPATH");

					// scroll down to bottom
					scrollBottom();

					// validate the risk score of the property
					try {
						String Score = "//td[text()='Asbestos Materials']";
						boolean riskScore = driver.findElement(By.xpath(Score)).isDisplayed();

						if (riskScore == true) {
							verificationFailedMessage(
									"The risk score of the environmental record of the property is displayed.");
						} else {
							successMessage(
									"The risk score of the environmental record of the property is not displayed as expected.");
						}
					} catch (Throwable t) {
						successMessage(
								"The risk score of the environmental record of the property is not displayed as expected.");
					}

				}
			} catch (Throwable t) {
				successMessage("The deleted risk score of the property is not displayed as expected.");
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

			// click on the graph of the risk card
			click("customform_portfoliodashboard_riskscoringcard_graph_XPATH");

			// select the current year in the year dropdown
			select("customform_portfoliodashboard_riskscoringcard_yeardd_XPATH", todayDate[0]);

			// select the current year in the month dropdown
			String month = todayDate[1].replaceFirst("^0+(?!$)", "");
			select("customform_portfoliodashboard_riskscoringcard_monthdd_XPATH", month);

			// scroll down to bottom
			scrollBottom();

			// validate the risk score of the property
			try {
				String Score = "//td[text()='Asbestos Materials']";
				boolean riskScore = driver.findElement(By.xpath(Score)).isDisplayed();

				if (riskScore == true) {
					verificationFailedMessage(
							"The risk score of the environmental record of the property is displayed.");
				} else {
					successMessage(
							"The risk score of the environmental record of the property is not displayed as expected.");
				}
			} catch (Throwable t) {
				successMessage(
						"The risk score of the environmental record of the property is not displayed as expected.");
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
