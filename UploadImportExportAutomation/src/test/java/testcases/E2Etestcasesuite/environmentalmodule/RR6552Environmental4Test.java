package testcases.E2Etestcasesuite.environmentalmodule;

import java.io.File;
import java.io.IOException;
import java.time.LocalDate;
import java.util.Hashtable;
import java.util.List;

import org.apache.commons.lang3.RandomStringUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import base.TestBase;
import utilities.ExcelReader;
import utilities.TestUtil;

public class RR6552Environmental4Test extends TestBase {

	@Test(dataProviderClass = TestUtil.class, dataProvider = "dp")
	public void rR6552Environmental4Test(Hashtable<String, String> data) throws InterruptedException, IOException {

		execution(data, "rR6552Environmental4Test");

		// VERIFY THE IMPORT/EXPORT FEATURE FOR THE RISK SCORE OF THE ENVIRONMENTAL
		// RECORD ON THE PROPERTY SUMMARY DASHBOARD WITH A SINGLE PROPERTY.
		title("VERIFY THE IMPORT/EXPORT FEATURE FOR THE RISK SCORE OF THE ENVIRONMENTAL RECORD ON THE PROPERTY SUMMARY DASHBOARD WITH A SINGLE PROPERTY.");

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

		// CREATE NEW RECORD OF THE ENVIRONMENTAL RECORD WITH THE RISK SCORE
		title("CREATE NEW RECORD OF THE ENVIRONMENTAL RECORD WITH THE RISK SCORE");

		String location_description = RandomStringUtils.randomAlphabetic(8);
		String score = RandomStringUtils.randomNumeric(2);
		String updatescore = RandomStringUtils.randomNumeric(2);

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

		// PERFORM THE IMPORT/EXPORT FEATURE FOR THE NEW ADDED RISK SCORING CARD IN THE
		// PROPERTY SUMMARY DASHBOARD SCREEN
		title("PERFORM THE IMPORT/EXPORT FEATURE FOR THE NEW ADDED RISK SCORING CARD IN THE PROPERTY SUMMARY DASHBOARD SCREEN");

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

			// click on the action icon
			click("envrecord_propertydashboard_riskscoringcard_actionicon_XPATH");

			// click on the export option
			click("envrecord_propertydashboard_riskscoringcard_actionicon_exportoption_XPATH");

			// wait for the element
			Thread.sleep(15000);

			// fetch the record from the download file
			File downloaded = getLastModified(config.getProperty("downloadFilePath"));
			String path_string = downloaded.toString();
			System.out.println(path_string);

			ExcelReader file = new ExcelReader(path_string);

			// verify the detail of the risk category
			try {
				String riskcategory = file.getCellData("Risk Scores", "Risk Category", 2);

				if (riskcategory.equals(data.get("score_category"))) {
					successMessage("The details of the risk category is displayed correctly.");
				} else {
					verificationFailedMessage("The details of the risk category is not displayed correctly.");
				}
			} catch (Throwable t) {
				verificationFailedMessage("The details of the risk category is not displayed correctly.");
			}

			// verify the detail of the risk status
			try {
				String riskstatus = file.getCellData("Risk Scores", "Risk Status", 2);

				if (riskstatus.equals(data.get("risk_status"))) {
					successMessage("The details of the risk status is displayed correctly.");
				} else {
					verificationFailedMessage("The details of the risk status is not displayed correctly.");
				}
			} catch (Throwable t) {
				verificationFailedMessage("The details of the risk status is not displayed correctly.");
			}

			// verify the detail of the risk score
			try {
				String riskscore = file.getCellData("Risk Scores", "Risk Score", 2);

				if (riskscore.equals(score)) {
					successMessage("The details of the risk score is displayed correctly.");
				} else {
					verificationFailedMessage("The details of the risk score is not displayed correctly.");
				}
			} catch (Throwable t) {
				verificationFailedMessage("The details of the risk score is not displayed correctly.");
			}

			// verify the detail of the risk details
			try {
				String riskdetails = file.getCellData("Risk Scores", "Risk Description", 2);

				if (riskdetails.equals(data.get("details"))) {
					successMessage("The details of the risk details is displayed correctly.");
				} else {
					verificationFailedMessage("The details of the risk details is not displayed correctly.");
				}
			} catch (Throwable t) {
				verificationFailedMessage("The details of the risk details is not displayed correctly.");
			}

//			// add the details of the risk category
//			file.setCellData("Risk Scores", "Risk Category", 2, data.get("score_category_update"));
//
//			// add the details of the risk status
//			file.setCellData("Risk Scores", "Risk Status", 2, data.get("risk_status_update"));
//
//			// add the details of the risk score
//			file.setCellData("Risk Scores", "Risk Status", 2, updatescore);
//
//			// wait for the element
//			Thread.sleep(5000);
//
//			// click on the action icon
//			click("envrecord_propertydashboard_riskscoringcard_actionicon_XPATH");
//
//			// wait for the element
//			Thread.sleep(5000);
//
//			// click on the import option
//			click("envrecord_propertydashboard_riskscoringcard_actionicon_importoption_XPATH");
//
//			// import the file
//			uploadFile(path_string);
//
//			// wait for the element
//			Thread.sleep(10000);
//
//			// validate the imported risk score of the property
//			try {
//				String Score = (driver
//						.findElement(By.xpath(
//								OR.getProperty("customform_propertydashboard_riskscoringcard_averagescore1_XPATH")))
//						.getText()).trim();
//				int avgScore_actual = Integer.parseInt(Score);
//				int score_expected = Integer.parseInt(updatescore);
//
//				if (avgScore_actual == score_expected) {
//					successMessage("The risk score for the property is displayed correctly.");
//				} else {
//					verificationFailedMessage("The risk score for the property is not displayed correctly.");
//				}
//			} catch (Throwable t) {
//				verificationFailedMessage("The risk score for the property is not displayed correctly.");
//			}
//
//			// validate the imported average risk score of the other properties
//			try {
//				String Score = (driver
//						.findElement(By.xpath(
//								OR.getProperty("customform_propertydashboard_riskscoringcard_averagescore2_XPATH")))
//						.getText()).trim();
//				int avgScore_actual = Integer.parseInt(Score);
//				int score_expected = 0;
//
//				if (avgScore_actual == score_expected) {
//					successMessage("The average risk score of the other properties is displayed correctly.");
//				} else {
//					verificationFailedMessage(
//							"The average risk score of the other properties is not displayed correctly.");
//				}
//			} catch (Throwable t) {
//				verificationFailedMessage("The average risk score of the other properties is not displayed correctly.");
//			}

		} catch (Throwable t) {
			verificationFailed();
		}

		// click on the home icon from the top of the screen
		click("questionnaire_homeburgermenubtn_hide_CSS");

		// wait for the element
		explicitWait("propertylist_title_XPATH");

		// verify the property list
		switchVerification("propertylist_title_XPATH", "Property List", "The property list is not displayed.");

//		// VALIDATE THE IMPORTED RISK SCORING CARD IN THE PORTFOLIO DASHBOARD SCREEN
//		title("VALIDATE THE IMPORTED RISK SCORING CARD IN THE PORTFOLIO DASHBOARD SCREEN");
//
//		try {
//
//			// wait for the element
//			Thread.sleep(5000);
//
//			// click on the side menu
//			click("menubtn_CSS");
//
//			// wait for the element
//			Thread.sleep(5000);
//
//			// click on the portfolio dashboard from side menu
//			click("sidemenu_portfoliosummary_XPATH");
//
//			// scrolldown till risk scoring card
//			scrollTillElement("customform_portfoliodashboard_riskscoringcard_XPATH");
//
//			// validate the imported average risk score of the all the properties
//			try {
//				String avgScore = (driver
//						.findElement(By.xpath(
//								OR.getProperty("customform_portfoliodashboard_riskscoringcard_averagescore_XPATH")))
//						.getText()).trim();
//				int avgScore_actual = Integer.parseInt(avgScore);
//				float score_float1 = Float.parseFloat(updatescore);
//				float score_float2 = score_float1 / 4f;
//				int score_expected = Math.round(score_float2);
//
//				if (avgScore_actual == score_expected) {
//					successMessage("The imported average risk score of the all the properties is displayed correctly.");
//				} else {
//					verificationFailedMessage(
//							"The imported average risk score of the all the properties is not displayed correctly.");
//				}
//			} catch (Throwable t) {
//				verificationFailedMessage(
//						"The imported average risk score of the all the properties is not displayed correctly.");
//			}
//
//		} catch (Throwable t) {
//			verificationFailed();
//		}
//
//		// click on the home icon from the top of the screen
//		click("questionnaire_homeburgermenubtn_hide_CSS");
//
//		// wait for the element
//		explicitWait("propertylist_title_XPATH");
//
//		// verify the property list
//		switchVerification("propertylist_title_XPATH", "Property List", "The property list is not displayed.");
//
//		// VALIDATE THE IMPORTED THE RISK SCORE IN THE ENVIRONMENTAL RECORD
//		title("VALIDATE THE IMPORTED THE RISK SCORE IN THE ENVIRONMENTAL RECORD");
//
//		try {
//
//			// enter the property name in the search field
//			type("ohs_incidentreport_searchtxt_XPATH", data.get("property_1"));
//
//			// wait for the element
//			explicitWaitClickable("environmentalicon_CSS");
//
//			// click on the environmental icon from the property list page
//			click("environmentalicon_CSS");
//
//			// click on the burger menu
//			click("menubtn_CSS");
//
//			// wait for the element
//			explicitWaitClickable("envrecords_XPATH");
//
//			// click on the environmental records
//			click("envrecords_XPATH");
//
//			// click on the Primary Hazardous Substance
//			click("envrecords_primaryhazardoussubstance_XPATH");
//
//			// click on the asbestos materials
//			click("envreports_asbestosmaterials_XPATH");
//
//			// click on the newly created environmental record
//			String envrecord = "//span[text()='" + location_description + "']";
//			driver.findElement(By.xpath(envrecord)).click();
//			consoleMessage("Clicked on the newly created environmental record.");
//
//			// click on the risk scoring tab
//			click("envreports_asbestosmaterials_riskscoringtab_XPATH");
//
//			// validate the imported score
//			try {
//				String importedScore = driver
//						.findElement(By.xpath(OR.getProperty("envreports_asbestosmaterials_scoretxt_XPATH")))
//						.getAttribute("value");
//
//				if (importedScore.equals(updatescore)) {
//					successMessage("The imported score of the environmental record is displayed successfully.");
//				} else {
//					verificationFailedMessage("The imported score of the environmental record is not displayed.");
//				}
//			} catch (Throwable t) {
//				verificationFailedMessage("The imported score of the environmental record is not displayed.");
//			}
//
//			// click on the update button
//			click("envreports_asbestosmaterials_updatebtn_CSS");
//
//			// wait for the element
//			explicitWaitClickable("closetoastmsg_CSS");
//
//			// click on the toaster close button
//			click("closetoastmsg_CSS");
//
//			// enter the newly created environmental record in the search field
//			type("task_listofchecklist_filterfield_CSS", location_description);
//
//			// verify added details of the Asbestos Materials record is correct or not
//			try {
//				envrecord = "//span[text()='" + location_description + "']";
//				String envrecord_actual = (driver.findElement(By.xpath(envrecord)).getText()).trim();
//
//				if (envrecord_actual.equals(location_description)) {
//					successMessage("The newly created environmental record is displayed successfully.");
//				} else {
//					verificationFailedMessage("The newly created environmental record is not displayed.");
//				}
//			} catch (Throwable t) {
//				verificationFailedMessage("The newly created environmental record is not displayed.");
//			}
//
//		} catch (Throwable t) {
//			verificationFailed();
//		}
//
//		// click on the home icon from the top of the screen
//		click("questionnaire_homeburgermenubtn_hide_CSS");
//
//		// wait for the element
//		explicitWait("propertylist_title_XPATH");
//
//		// verify the property list
//		switchVerification("propertylist_title_XPATH", "Property List", "The property list is not displayed.");

		// DELETE THE ENVIRONMENTAL RECORD
		title("DELETE THE ENVIRONMENTAL RECORD");

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
