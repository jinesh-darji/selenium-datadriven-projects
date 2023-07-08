package testcases.E2Etestcasesuite.environmentalmodule;

import java.io.IOException;
import java.time.LocalDate;
import java.util.Hashtable;
import java.util.List;

import org.apache.commons.lang3.RandomStringUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import base.TestBase;
import utilities.TestUtil;

public class RR6501Environmental2Test extends TestBase {

	@Test(dataProviderClass = TestUtil.class, dataProvider = "dp")
	public void rR6501Environmental2Test(Hashtable<String, String> data) throws InterruptedException, IOException {

		execution(data, "rR6501Environmental2Test");

		// VALIDATE THE ENVIRONMENTAL REPORTS DATE RELATED LOGIC
		title("VALIDATE THE ENVIRONMENTAL REPORTS DATE RELATED LOGIC");

		// refresh the page
		driver.navigate().refresh();
		Thread.sleep(5000);
		driver.navigate().refresh();

		// KEEP ENVIRONMENTAL REPORT DATE FIELD OPTIONAL IN THE ENVIRONMENTAL FORMS AND
		// REQUIRED IN THE ENVIRONMENTAL REPORT SCREENS
		title("KEEP ENVIRONMENTAL REPORT DATE FIELD OPTIONAL IN THE ENVIRONMENTAL FORMS AND AND REQUIRED IN THE ENVIRONMENTAL REPORT SCREENS");

		String title1 = RandomStringUtils.randomAlphabetic(8);
		LocalDate today = LocalDate.now();
		String today_string = today.toString();
		LocalDate afterOneY = LocalDate.now().plusYears(1);
		String afterOneY_string = afterOneY.toString();

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

			// scroll down till date field
			scrollTillElement("administration_environmental_environmentalforms_envireportsoption_dateediticon_XPATH");
			scrollByPixel(-200);

			// click on the edit icon of the date option
			click("administration_environmental_environmentalforms_envireportsoption_dateediticon_XPATH");

			// validate the required checkbox is displayed selected or not
			try {
				boolean required = driver.findElement(By.xpath(OR.getProperty(
						"administration_environmental_environmentalforms_envireportsoption_requiredckbx_XPATH")))
						.isSelected();
				if (required == true) {

					consoleMessage("The required checkbox is selected.");

					// click on the required checkbox
					click("administration_environmental_environmentalforms_envireportsoption_requiredckbx_XPATH");

					successMessage("The required checkbox is not selected.");

					// click on the save button
					click("administration_environmental_environmentalforms_envireportsoption_savebtn_XPATH");

				} else {
					successMessage("The required checkbox is not selected.");
				}

			} catch (Throwable t) {
				verificationFailed();
			}

			// click on the Administration tab
			click("administration_XPATH");

			// click on the Environment tab
			click("questionnaire_environmenttab_XPATH");

			// click on the Environmental Reports option
			click("administration_environmental_environmentalreports_XPATH");

			// scroll down till asbestos survey
			scrollTillElement("administration_environmental_environmentalreport_phaseIIesaoption_XPATH");
			scrollByPixel(-200);

			// click on the Phase II ESA
			click("administration_environmental_environmentalreport_phaseIIesaoption_XPATH");

			// scroll till date option
			scrollTillElement("administration_environmental_environmentalreport_dateediticon_XPATH");
			scrollByPixel(-200);

			// click on the edit button of the date option
			click("administration_environmental_environmentalreport_dateediticon_XPATH");

			// validate the required checkbox is displayed selected or not
			try {
				boolean required = driver
						.findElement(By.xpath(OR.getProperty(
								"administration_environmental_environmentalreport_daterequiredckbx_XPATH")))
						.isSelected();
				if (required == true) {
					successMessage("The required checkbox is selected successfully.");

				} else {
					consoleMessage("The required checkbox is not selected.");

					// click on the required checkbox
					click("administration_environmental_environmentalreport_daterequiredckbx_XPATH");

					successMessage("The required checkbox is selected successfully.");

					// scroll toll bottom
					scrollBottom();

					// click on the save button
					click("administration_environmental_environmentalreport_savebtn_XPATH");
				}

			} catch (Throwable t) {
				verificationFailed();
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

			try {
				List<WebElement> reportList = driver
						.findElements(By.xpath(OR.getProperty("envreports_totalrecords_XPATH")));
				int reportCount = reportList.size();

				for (int i = 1; i <= reportCount; i++) {

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

		// VALIDATE THE DATE FIELD IN THE ENVIRONMENTAL REPORT AND CREATE NEW RECORD OF
		// THE ENVIRONMENTAL REPORT
		title("VALIDATE THE DATE FIELD IN THE ENVIRONMENTAL REPORT AND CREATE NEW RECORD OF THE ENVIRONMENTAL REPORT");

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

			// select the environmental report from the type dropdown
			select("envreporttypedd_CSS", data.get("type_1"));

			// validate the red color asterisk sign is displayed or not in date field
			try {
				boolean requiredIcon = driver
						.findElement(By.xpath(OR.getProperty("environmentalreport_datetxt_requiredicon_XPATH")))
						.isDisplayed();

				if (requiredIcon == true) {
					verificationFailedMessage("The red color asterisk sign is displayed.");

				} else {
					successMessage("The red color asterisk sign is not displayed as expected.");
				}

			} catch (Throwable t) {
				successMessage("The red color asterisk sign is not displayed as expected.");
			}

			// validate the current date is displayed or not in date field
			try {
				String date_actual = driver.findElement(By.cssSelector(OR.getProperty("envreportdatetxt_CSS")))
						.getAttribute("value");

				if (date_actual.equals(today_string)) {
					verificationFailedMessage("The current date is displayed default.");

				} else {
					successMessage("The current date is not displayed default as expected.");
				}

			} catch (Throwable t) {
				successMessage("The current date is not displayed default as expected.");
			}

			// select the environmental report from the type dropdown
			select("envreporttypedd_CSS", data.get("type"));

			// validate the red color asterisk sign is displayed or not in date field
			try {
				boolean requiredIcon = driver
						.findElement(By.xpath(OR.getProperty("environmentalreport_datetxt_requiredicon_XPATH")))
						.isDisplayed();

				if (requiredIcon == true) {
					successMessage("The red color asterisk sign is displayed successfully.");
				} else {
					verificationFailedMessage("The red color asterisk sign is not displayed.");
				}

			} catch (Throwable t) {
				verificationFailedMessage("The red color asterisk sign is not displayed.");
			}

			// validate the current date is displayed or not in date field
			try {
				String date_actual = driver.findElement(By.cssSelector(OR.getProperty("envreportdatetxt_CSS")))
						.getAttribute("value");

				if (date_actual.equals(today_string)) {
					successMessage("The current date is displayed default successfully.");
				} else {
					verificationFailedMessage("The current date is not displayed default.");
				}

			} catch (Throwable t) {
				verificationFailedMessage("The current date is not displayed default.");
			}

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

			// VALIDATE THE DATE FIELDS AFTER CREATED THE RECORD OF THE ENVIRONMENTAL REPORT
			title("VALIDATE THE DATE FIELDS AFTER CREATED THE RECORD OF THE ENVIRONMENTAL REPORT");

			// click on the newly created environmental report
			String record = "//span[text()='" + title1 + "']";
			driver.findElement(By.xpath(record)).click();
			consoleMessage("Clicked on the newly created environmental report.");

			// validate the red color asterisk sign is displayed or not in date field
			try {
				boolean requiredIcon = driver
						.findElement(By.xpath(OR.getProperty("environmentalreport_datetxt_requiredicon_XPATH")))
						.isDisplayed();

				if (requiredIcon == true) {
					successMessage("The red color asterisk sign is displayed successfully.");
				} else {
					verificationFailedMessage("The red color asterisk sign is not displayed.");
				}

			} catch (Throwable t) {
				verificationFailedMessage("The red color asterisk sign is not displayed.");
			}

			// validate the current date is displayed or not in date field
			try {
				String date_actual = driver.findElement(By.cssSelector(OR.getProperty("envreportdatetxt_CSS")))
						.getAttribute("value");

				if (date_actual.equals(today_string)) {
					successMessage("The current date is displayed default successfully.");
				} else {
					verificationFailedMessage("The current date is not displayed default.");
				}

			} catch (Throwable t) {
				verificationFailedMessage("The current date is not displayed default.");
			}

			// validate the Next Assessment date is displayed or not in date field
			try {
				String afterOneY_actual = driver
						.findElement(By.xpath(OR.getProperty("environmentalreport_nextassessmentdatetxt_XPATH")))
						.getAttribute("value");

				if (afterOneY_actual.equals(afterOneY_string)) {
					successMessage("The Next Assessment Date is displayed default successfully.");
				} else {
					verificationFailedMessage("The Next Assessment Date is not displayed default.");
				}

			} catch (Throwable t) {
				verificationFailedMessage("The Next Assessment Date is not displayed default.");
			}

			// click on the update record button
			click("envreportupdatebtn_CSS");

			// enter the newly created environmental report in the search field
			type("task_listofchecklist_filterfield_CSS", title1);

			// verification of the environmental report is added or not
			try {
				String record1 = "//span[text()='" + title1 + "']";
				String record1_actual = (driver.findElement(By.xpath(record1)).getText()).trim();

				if (record1_actual.equals(title1)) {

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

		// VALIDATE THE DETAILS OF THE NEWLY CREATED ENVIRONMENTAL REPORT ON PORTFOLIO
		// SUMMARY DASHBOARD
		title("VALIDATE THE DETAILS OF THE NEWLY CREATED ENVIRONMENTAL REPORT ON PORTFOLIO SUMMARY DASHBOARD");

		try {

			// wait for the element
			Thread.sleep(5000);

			// click on the side menu
			click("menubtn_CSS");

			// wait for the element
			Thread.sleep(5000);

			// click on the portfolio dashboard from side menu
			click("sidemenu_portfoliosummary_XPATH");

			// scroll down
			scrollTillElement("portfoliodashboard_phaseIIesacard_XPATH");

			// click on the progress text
			click("portfoliodashboard_phaseIIesacard_progresstext_XPATH");

			// validate the green circle dot for the respective environmental report
			try {
				boolean greendot = driver
						.findElement(By.xpath(OR.getProperty("portfoliodashboard_phaseIIesacard_greencircledot_XPATH")))
						.isDisplayed();

				if (greendot == true) {
					successMessage(
							"The green dot is displayed successfully for the newly created environmental report.");

				} else {
					verificationFailedMessage(
							"The green dot is not displayed for the newly created environmental report.");
				}
			} catch (Throwable t) {
				verificationFailedMessage("The green dot is not displayed for the newly created environmental report.");
			}

			// validate the report date of the newly created environmental report
			try {
				String reportDate_actual = (driver
						.findElement(By.xpath(OR.getProperty("portfoliodashboard_phaseIIesacard_reportdate_XPATH")))
						.getText()).trim();

				if (reportDate_actual.equals(today_string)) {
					successMessage("The report date of the newly created environmental report is displayed correct.");

				} else {
					verificationFailedMessage(
							"The report date of the newly created environmental report is displayed not correct.");
				}
			} catch (Throwable t) {
				verificationFailedMessage(
						"The report date of the newly created environmental report is displayed not correct.");
			}

			// validate the Next Assessment date of the newly created environmental report
			try {
				String reportDate_actual = (driver
						.findElement(By.xpath(OR.getProperty("portfoliodashboard_phaseIIesacard_nextassessment_XPATH")))
						.getText()).trim();

				if (reportDate_actual.equals(afterOneY_string)) {
					successMessage(
							"The Next Assessment date of the newly created environmental report is displayed correct.");

				} else {
					verificationFailedMessage(
							"The Next Assessment date of the newly created environmental report is displayed not correct.");
				}
			} catch (Throwable t) {
				verificationFailedMessage(
						"The Next Assessment date of the newly created environmental report is displayed not correct.");
			}

			// click on the newly created environmental report
			click("customform_portfoliodashboard_propertyname_XPATH");

			try {

				String record = "//span[text()='" + title1 + "']";
				boolean record_actual = driver.findElement(By.xpath(record)).isDisplayed();

				if (record_actual == true) {

					// click on the newly created environmental report
					String record3 = "//span[text()='" + title1 + "']";
					driver.findElement(By.xpath(record3)).click();
					consoleMessage("Clicked on the newly created environmental report.");

				} else {
					successMessage("The environemntal record screen is displayed successfully.");
				}

			} catch (Throwable t) {
				successMessage("The environemntal record screen is displayed successfully.");
			}

			// validate the red color asterisk sign is displayed or not in date field
			try {
				boolean requiredIcon = driver
						.findElement(By.xpath(OR.getProperty("environmentalreport_datetxt_requiredicon_XPATH")))
						.isDisplayed();

				if (requiredIcon == true) {
					successMessage("The red color asterisk sign is displayed successfully.");
				} else {
					verificationFailedMessage("The red color asterisk sign is not displayed.");
				}

			} catch (Throwable t) {
				verificationFailedMessage("The red color asterisk sign is not displayed.");
			}

			// validate the current date is displayed or not in date field
			try {
				String date_actual = driver.findElement(By.cssSelector(OR.getProperty("envreportdatetxt_CSS")))
						.getAttribute("value");

				if (date_actual.equals(today_string)) {
					successMessage("The current date is displayed default successfully.");
				} else {
					verificationFailedMessage("The current date is not displayed default.");
				}

			} catch (Throwable t) {
				verificationFailedMessage("The current date is not displayed default.");
			}

			// validate the Next Assessment date is displayed or not in date field
			try {
				String afterOneY_actual = driver
						.findElement(By.xpath(OR.getProperty("environmentalreport_nextassessmentdatetxt_XPATH")))
						.getAttribute("value");

				if (afterOneY_actual.equals(afterOneY_string)) {
					successMessage("The Next Assessment Date is displayed default successfully.");
				} else {
					verificationFailedMessage("The Next Assessment Date is not displayed default.");
				}

			} catch (Throwable t) {
				verificationFailedMessage("The Next Assessment Date is not displayed default.");
			}

			// click on the update record button
			click("envreportupdatebtn_CSS");

			// enter the newly created environmental report in the search field
			type("task_listofchecklist_filterfield_CSS", title1);

			// verification of the environmental report is added or not
			try {
				String record1 = "//span[text()='" + title1 + "']";
				String record1_actual = (driver.findElement(By.xpath(record1)).getText()).trim();

				if (record1_actual.equals(title1)) {

					successMessage("The environmental report is verified successfully.");

				} else {
					verificationFailedMessage("The environmental report is not verified.");
				}
			} catch (Throwable t) {
				verificationFailedMessage("The environmental report is not verified.");
			}

			// click on the back to dashboard screen
			click("portfoliodashboard_phaseIIesacard_backtodashboard_XPATH");

			// validate the asbestos survey title
			switchVerification("portfoliodashboard_phaseIIesacard_title_XPATH", "Phase II ESA",
					"The Phase II ESA environmental report is not displayed.");

			// click on the back button
			click("portfoliodashboard_phaseIIesacard_backbtn_XPATH");

			// verification of the portfolio title is displayed or not
			switchVerification("portfoliodashboard_title_XPATH", "Portfolio Summary",
					"The Portfolio Summary title is not displayed.");

		} catch (Throwable t) {
			verificationFailed();
		}

		// click on the home icon from the top of the screen
		click("questionnaire_homeburgermenubtn_hide_CSS");

		// wait for the element
		explicitWait("propertylist_title_XPATH");

		// verify the property list
		switchVerification("propertylist_title_XPATH", "Property List", "The property list is not displayed.");

		// VALIDATE THE DETAILS OF THE NEWLY CREATED ENVIRONMENTAL REPORT ON PROPERTY
		// SUMMARY DASHBOARD
		title("VALIDATE THE DETAILS OF THE NEWLY CREATED ENVIRONMENTAL REPORT ON PROPERTY SUMMARY DASHBOARD");

		try {

			// wait for the element
			Thread.sleep(5000);

			// click on the property
			click("propertysummary_property1_XPATH");

			// scroll down
			scrollTillElement("propertydashboard_recentdocumentcard_XPATH");

			// get the all environmental report from recent document list
			try {
				List<WebElement> reportList = driver
						.findElements(By.xpath(OR.getProperty("propertydashboard_recentdocumentcard_records_XPATH")));
				int reportCount = reportList.size();

				for (int i = 1; i < reportCount; i++) {
					String environmentalRecord = "//h4[text()='Recent Documents']//following-sibling::div//table[@class='table table-striped table-hover']//tbody//tr["
							+ i + "]//td//p[@class='ng-binding']";

					String environmentalTitle = (driver.findElement(By.xpath(environmentalRecord)).getText()).trim();

					if (environmentalTitle.equals(title1)) {

						successMessage("The respective environmental report is displayed successfully.");

						// validate the green circle dot for the respective environmental report
						try {

							String greendot = "//p[text()='" + environmentalTitle
									+ "']//parent::td//preceding-sibling::td[@class='ng-scope']//span[@style='background-color:#86A851']";
							boolean greendot_actual = driver.findElement(By.xpath(greendot)).isDisplayed();

							if (greendot_actual == true) {
								successMessage(
										"The green dot is displayed successfully for the newly created environmental report.");

							} else {
								verificationFailedMessage(
										"The green dot is not displayed for the newly created environmental report.");
							}
						} catch (Throwable t) {
							verificationFailedMessage(
									"The green dot is not displayed for the newly created environmental report.");
						}

						// validate the report date of the newly created environmental report
						try {
							String reportDate = "//p[text()='" + environmentalTitle
									+ "']//parent::td//following-sibling::td[@class='ng-binding ng-scope']";
							String reportDate_actual = (driver.findElement(By.xpath(reportDate)).getText()).trim();

							if (reportDate_actual.equals(today_string)) {
								successMessage(
										"The report date of the newly created environmental report is displayed correct.");

							} else {
								verificationFailedMessage(
										"The report date of the newly created environmental report is displayed not correct.");
							}
						} catch (Throwable t) {
							verificationFailedMessage(
									"The report date of the newly created environmental report is displayed not correct.");
						}

						// click on the environmental report
						String record = "//p[text()='" + environmentalTitle + "']";
						driver.findElement(By.xpath(record)).click();
						consoleMessage("Clicked on the environmental report.");

						// validate the red color asterisk sign is displayed or not in date field
						try {
							boolean requiredIcon = driver
									.findElement(
											By.xpath(OR.getProperty("environmentalreport_datetxt_requiredicon_XPATH")))
									.isDisplayed();

							if (requiredIcon == true) {
								successMessage("The red color asterisk sign is displayed successfully.");
							} else {
								verificationFailedMessage("The red color asterisk sign is not displayed.");
							}

						} catch (Throwable t) {
							verificationFailedMessage("The red color asterisk sign is not displayed.");
						}

						// validate the current date is displayed or not in date field
						try {
							String date_actual = driver
									.findElement(By.cssSelector(OR.getProperty("envreportdatetxt_CSS")))
									.getAttribute("value");

							if (date_actual.equals(today_string)) {
								successMessage("The current date is displayed default successfully.");
							} else {
								verificationFailedMessage("The current date is not displayed default.");
							}

						} catch (Throwable t) {
							verificationFailedMessage("The current date is not displayed default.");
						}

						// validate the Next Assessment date is displayed or not in date field
						try {
							String afterOneY_actual = driver
									.findElement(
											By.xpath(OR.getProperty("environmentalreport_nextassessmentdatetxt_XPATH")))
									.getAttribute("value");

							if (afterOneY_actual.equals(afterOneY_string)) {
								successMessage("The Next Assessment Date is displayed default successfully.");
							} else {
								verificationFailedMessage("The Next Assessment Date is not displayed default.");
							}

						} catch (Throwable t) {
							verificationFailedMessage("The Next Assessment Date is not displayed default.");
						}

						// click on the update record button
						click("envreportupdatebtn_CSS");

						// enter the newly created environmental report in the search field
						type("task_listofchecklist_filterfield_CSS", title1);

						// verification of the environmental report is added or not
						try {
							String record1 = "//span[text()='" + title1 + "']";
							String record1_actual = (driver.findElement(By.xpath(record1)).getText()).trim();

							if (record1_actual.equals(title1)) {

								successMessage("The environmental report is verified successfully.");

							} else {
								verificationFailedMessage("The environmental report is not verified.");
							}
						} catch (Throwable t) {
							verificationFailedMessage("The environmental report is not verified.");
						}

						// click on the back to dashboard screen
						click("portfoliodashboard_phaseIIesacard_backtodashboard_XPATH");

						// verification of the portfolio title is displayed or not
						switchVerification("navigation_header_propertyname1_XPATH", "[DND] AAAA Risk Test Prop 01 - 01",
								"The [DND] AAAA Risk Test Prop 01 - 01 property is not displayed");

						break;
					}
				}

			} catch (Throwable t) {
				verificationFailedMessage("The respective survey is not displayed to admin user.");
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

		// DELETE THE NEWLY CREATED RECORD OF THE ENVIRONMENTAL REPORT
		title("DELETE THE NEWLY CREATED RECORD OF THE ENVIRONMENTAL REPORT");

		try {
			// click on the environmental icon from the property list page
			click("environmentalicon_CSS");

			// click on the burger menu
			click("menubtn_CSS");

			// wait for the element
			explicitWaitClickable("envreportoption_XPATH");

			// click on the Environmental Reports option
			click("envreportoption_XPATH");

			// click on the newly created environmental report
			String record = "//span[text()='" + title1 + "']";
			driver.findElement(By.xpath(record)).click();
			consoleMessage("Clicked on the newly created environmental report.");

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

			// enter the newly created environmental report in the search field
			type("task_listofchecklist_filterfield_CSS", title1);

			// verification of the environmental report is deleted or not
			try {
				String record2 = "//span[text()='" + title1 + "']";
				String record2_actual = (driver.findElement(By.xpath(record2)).getText()).trim();

				if (record2_actual.equals(title1)) {

					verificationFailedMessage("The environmental report is not deleted.");

				} else {
					successMessage("The environmental report is deleted successfully.");
				}
			} catch (Throwable t) {
				successMessage("The environmental report is deleted successfully.");
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

		// RESET THE SETTING OF THE ENVIRONMENTAL REPORT DATE FIELD OPTIONAL IN THE
		// ENVIRONMENTAL FORMS AND REQUIRED IN THE ENVIRONMENTAL REPORT SCREENS
		title("RESET THE SETTING OF THE ENVIRONMENTAL REPORT DATE FIELD OPTIONAL IN THE ENVIRONMENTAL FORMS AND AND REQUIRED IN THE ENVIRONMENTAL REPORT SCREENS");

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

			// scroll down till date field
			scrollTillElement("administration_environmental_environmentalforms_envireportsoption_dateediticon_XPATH");
			scrollByPixel(-200);

			// click on the edit icon of the date option
			click("administration_environmental_environmentalforms_envireportsoption_dateediticon_XPATH");

			// validate the required checkbox is displayed selected or not
			try {
				boolean required = driver.findElement(By.xpath(OR.getProperty(
						"administration_environmental_environmentalforms_envireportsoption_requiredckbx_XPATH")))
						.isSelected();
				if (required == true) {

					successMessage("The required checkbox is selected successfully.");

				} else {

					consoleMessage("The required checkbox is not selected.");

					// click on the required checkbox
					click("administration_environmental_environmentalforms_envireportsoption_requiredckbx_XPATH");

					successMessage("The required checkbox is selected successfully.");

					// click on the save button
					click("administration_environmental_environmentalforms_envireportsoption_savebtn_XPATH");

				}

			} catch (Throwable t) {
				verificationFailed();
			}

			// click on the Administration tab
			click("administration_XPATH");

			// click on the Environment tab
			click("questionnaire_environmenttab_XPATH");

			// click on the Environmental Reports option
			click("administration_environmental_environmentalreports_XPATH");

			// scroll down till asbestos survey
			scrollTillElement("administration_environmental_environmentalreport_phaseIIesaoption_XPATH");
			scrollByPixel(-200);

			// click on the Phase II ESA
			click("administration_environmental_environmentalreport_phaseIIesaoption_XPATH");

			// scroll till date option
			scrollTillElement("administration_environmental_environmentalreport_dateediticon_XPATH");
			scrollByPixel(-200);

			// click on the edit button of the date option
			click("administration_environmental_environmentalreport_dateediticon_XPATH");

			// validate the required checkbox is displayed selected or not
			try {
				boolean required = driver
						.findElement(By.xpath(OR.getProperty(
								"administration_environmental_environmentalreport_daterequiredckbx_XPATH")))
						.isSelected();
				if (required == true) {

					successMessage("The required checkbox is selected successfully.");

				} else {

					consoleMessage("The required checkbox is not selected.");

					// click on the required checkbox
					click("administration_environmental_environmentalreport_daterequiredckbx_XPATH");

					successMessage("The required checkbox is selected successfully.");

					// scroll toll bottom
					scrollBottom();

					// click on the save button
					click("administration_environmental_environmentalreport_savebtn_XPATH");

				}

			} catch (Throwable t) {
				verificationFailed();
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
