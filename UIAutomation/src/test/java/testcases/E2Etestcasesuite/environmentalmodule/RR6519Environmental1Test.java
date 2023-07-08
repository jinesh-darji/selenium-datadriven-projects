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

public class RR6519Environmental1Test extends TestBase {

	@Test(dataProviderClass = TestUtil.class, dataProvider = "dp")
	public void rR6519Environmental1Test(Hashtable<String, String> data) throws InterruptedException, IOException {

		execution(data, "rR6519Environmental1Test");

		// VERIFY THE ENVIRONMENTAL REPORT PERCENTAGE IN THE PROPERTY SUMMARY DASHBOARD
		// FOR THE INACTIVE PROPERTIES.
		title("VERIFY THE ENVIRONMENTAL REPORT PERCENTAGE IN THE PROPERTY SUMMARY DASHBOARD FOR THE INACTIVE PROPERTIES.");

		// refresh the page
		driver.navigate().refresh();
		Thread.sleep(5000);
		driver.navigate().refresh();

		// MAKE PROPERTY ACTIVE
		title("MAKE PROPERTY ACTIVE");

		try {

			// enter the property name in the search field
			type("propertylist_searchtxt_XPATH", data.get("property_3"));

			// click on the environmental icon from the property list page
			click("environmentalicon_CSS");

			// click on the burger menu
			click("menubtn_CSS");

			// wait for the element
			Thread.sleep(5000);

			// click on the property details from side menu
			click("navigation_sidemenu_propertydetailslbl_XPATH");

			// wait for the element
			explicitWaitClickable("navigation_propertydetails_actionicon_XPATH");

			// click on the action icon
			click("navigation_propertydetails_actionicon_XPATH");

			// click on the property details option
			click("navigation_propertydetails_propertydetailsoption_XPATH");

			// click on the edit button of property details
			click("navigation_propertydetails_editbtn_XPATH");

			// select the inactive status for the property
			select("propertydetails_activedd_XPATH", "Active");

			// scroll down till button
			scrollBottom();

			// click on the save button
			click("propertydetails_savebutton_XPATH");

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

		// DELETE ALL THE PREVIOUSLY CREATED ENVIRONMENTAL REPORTS
		title("DELETE ALL THE PREVIOUSLY CREATED ENVIRONMENTAL REPORTS");

		try {

			// enter the property name in the search field
			type("propertylist_searchtxt_XPATH", data.get("property_3"));

			// click on the environmental icon from the property list page
			click("environmentalicon_CSS");

			// wait for the element
			explicitWaitClickable("menubtn_CSS");

			// click on the burger menu
			click("menubtn_CSS");

			// wait for the element
			Thread.sleep(5000);

			// click on the Environmental Reports option
			click("envreportoption_XPATH");

			try {
				List<WebElement> reportList = driver
						.findElements(By.xpath(OR.getProperty("envreports_totalrecords_XPATH")));
				int reportCount = reportList.size();

				for (int i = 1; i < reportCount; i++) {

					// wait for the element
					Thread.sleep(3000);

					// click on the first record
					String firstReport = "//table[@id='environmentalDocumentListTable']//tbody//tr[" + i
							+ "]//td[@class='ng-scope'][1]";
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

		// CREATE NEW RECORD OF THE ENVIRONMENTAL REPORT
		title("CREATE NEW RECORD OF THE ENVIRONMENTAL REPORT");

		String title1 = RandomStringUtils.randomAlphabetic(8);
		LocalDate today = LocalDate.now();
		String today_string = today.toString();
		LocalDate afterOneY = LocalDate.now().plusYears(1);
		String afterOneY_string = afterOneY.toString();

		try {

			// enter the property name in the search field
			type("propertylist_searchtxt_XPATH", data.get("property_3"));

			// click on the environmental icon from the property list page
			click("environmentalicon_CSS");

			// wait for the element
			explicitWaitClickable("menubtn_CSS");

			// click on the burger menu
			click("menubtn_CSS");

			// wait for the element
			Thread.sleep(5000);

			// click on the Environmental Reports option
			click("envreportoption_XPATH");

			// click on the Add report button
			click("envreportaddbtn_CSS");

			// select the checklist from the type dropdown
			select("envreporttypedd_CSS", data.get("type"));

			// enter the title
			type("envreporttitletxt_CSS", title1);

			// click on the date field
			click("envreportdatetxt_CSS");

			// click on the today button
			click("envreporttodaydate_BTNTEXT");

			// enter the company
			type("envreportcompanytxt_CSS", data.get("company"));

			// enter the author
			type("envreportauthortxt_CSS", data.get("author"));

			// scroll down the screen
			scrollByPixel(400);

			// enter the description
			type("envreportdescriptiontxt_CSS", data.get("description"));

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
				verificationFailedMessage("The environmental report is not verified.");
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

		// VALIDATE THE ENVIRONMENTAL REPORT OF THE ACTIVE PROPERTY ON THE PORTFOLIO
		// SUMMARY DASHBOARD
		title("VALIDATE THE ENVIRONMENTAL REPORT OF THE ACTIVE PROPERTY ON THE PORTFOLIO SUMMARY DASHBOARD");

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
			scrollTillElement("portfoliodashboard_asbestossurveycard_XPATH");

			// click on the progress text
			click("portfoliodashboard_asbestossurveycard_progresstext_XPATH");

			// validate the green circle dot for the respective environmental report
			try {
				boolean greendot = driver
						.findElement(
								By.xpath(OR.getProperty("portfoliodashboard_asbestossurveycard_greencircledot3_XPATH")))
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
						.findElement(
								By.xpath(OR.getProperty("portfoliodashboard_asbestossurveycard_reportdate3_XPATH")))
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
				String afterOneYDate_actual = (driver
						.findElement(
								By.xpath(OR.getProperty("portfoliodashboard_asbestossurveycard_nextassessment_XPATH")))
						.getText()).trim();

				if (afterOneYDate_actual.equals(afterOneY_string)) {
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

		} catch (Throwable t) {
			verificationFailed();
		}

		// click on the home icon from the top of the screen
		click("questionnaire_homeburgermenubtn_hide_CSS");

		// wait for the element
		explicitWait("propertylist_title_XPATH");

		// verify the property list
		switchVerification("propertylist_title_XPATH", "Property List", "The property list is not displayed.");

		// VALIDATE THE ENVIRONMENTAL REPORT OF THE ACTIVE PROPERTY ON THE PROPERTY
		// SUMMARY DASHBOARD
		title("VALIDATE THE ENVIRONMENTAL REPORT OF THE ACTIVE PROPERTY ON THE PROPERTY SUMMARY DASHBOARD");

		try {

			// wait for the element
			Thread.sleep(5000);

			// click on the property
			click("propertysummary_property3_XPATH");

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
					}
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

		// MAKE PROPERTY INACTIVE
		title("MAKE PROPERTY INACTIVE");

		try {

			// enter the property name in the search field
			type("propertylist_searchtxt_XPATH", data.get("property_3"));

			// click on the environmental icon from the property list page
			click("environmentalicon_CSS");

			// click on the burger menu
			click("menubtn_CSS");

			// wait for the element
			Thread.sleep(5000);

			// click on the property details from side menu
			click("navigation_sidemenu_propertydetailslbl_XPATH");

			// wait for the element
			explicitWaitClickable("navigation_propertydetails_actionicon_XPATH");

			// click on the action icon
			click("navigation_propertydetails_actionicon_XPATH");

			// click on the property details option
			click("navigation_propertydetails_propertydetailsoption_XPATH");

			// click on the edit button of property details
			click("navigation_propertydetails_editbtn_XPATH");

			// select the inactive status for the property
			select("propertydetails_activedd_XPATH", "Inactive");

			// scroll down till button
			scrollBottom();

			// click on the save button
			click("propertydetails_savebutton_XPATH");

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

		// VALIDATE THE ENVIRONMENTAL REPORT OF THE INACTIVE PROPERTY ON THE PORTFOLIO
		// SUMMARY DASHBOARD
		title("VALIDATE THE ENVIRONMENTAL REPORT OF THE INACTIVE PROPERTY ON THE PORTFOLIO SUMMARY DASHBOARD");

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
			scrollTillElement("portfoliodashboard_asbestossurveycard_XPATH");

			// click on the progress text
			click("portfoliodashboard_asbestossurveycard_progresstext_XPATH");

			// validate the green circle dot for the respective environmental report
			try {
				boolean greendot = driver
						.findElement(
								By.xpath(OR.getProperty("portfoliodashboard_asbestossurveycard_greencircledot3_XPATH")))
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
						.findElement(
								By.xpath(OR.getProperty("portfoliodashboard_asbestossurveycard_reportdate3_XPATH")))
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
				String afterOneYDate_actual = (driver
						.findElement(
								By.xpath(OR.getProperty("portfoliodashboard_asbestossurveycard_nextassessment_XPATH")))
						.getText()).trim();

				if (afterOneYDate_actual.equals(afterOneY_string)) {
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

		} catch (Throwable t) {
			verificationFailed();
		}

		// click on the home icon from the top of the screen
		click("questionnaire_homeburgermenubtn_hide_CSS");

		// wait for the element
		explicitWait("propertylist_title_XPATH");

		// verify the property list
		switchVerification("propertylist_title_XPATH", "Property List", "The property list is not displayed.");

		// VALIDATE THE ENVIRONMENTAL REPORT OF THE INACTIVE PROPERTY ON THE PROPERTY
		// SUMMARY DASHBOARD
		title("VALIDATE THE ENVIRONMENTAL REPORT OF THE INACTIVE PROPERTY ON THE PROPERTY SUMMARY DASHBOARD");

		try {

			// wait for the element
			Thread.sleep(5000);

			// click on the property
			click("propertysummary_property3_XPATH");

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
					}
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

		// MAKE PROPERTY ACTIVE
		title("MAKE PROPERTY ACTIVE");

		try {

			// enter the property name in the search field
			type("propertylist_searchtxt_XPATH", data.get("property_3"));

			// click on the environmental icon from the property list page
			click("environmentalicon_CSS");

			// click on the burger menu
			click("menubtn_CSS");

			// wait for the element
			Thread.sleep(5000);

			// click on the property details from side menu
			click("navigation_sidemenu_propertydetailslbl_XPATH");

			// wait for the element
			explicitWaitClickable("navigation_propertydetails_actionicon_XPATH");

			// click on the action icon
			click("navigation_propertydetails_actionicon_XPATH");

			// click on the property details option
			click("navigation_propertydetails_propertydetailsoption_XPATH");

			// click on the edit button of property details
			click("navigation_propertydetails_editbtn_XPATH");

			// select the inactive status for the property
			select("propertydetails_activedd_XPATH", "Active");

			// scroll down till button
			scrollBottom();

			// click on the save button
			click("propertydetails_savebutton_XPATH");

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

		// DELETE ALL THE PREVIOUSLY CREATED ENVIRONMENTAL REPORTS
		title("DELETE ALL THE PREVIOUSLY CREATED ENVIRONMENTAL REPORTS");

		try {
			// click on the environmental icon from the property list page
			click("environmentalicon_CSS");

			// wait for the element
			explicitWaitClickable("menubtn_CSS");

			// click on the burger menu
			click("menubtn_CSS");

			// wait for the element
			Thread.sleep(5000);

			// click on the Environmental Reports option
			click("envreportoption_XPATH");

			try {
				List<WebElement> reportList = driver
						.findElements(By.xpath(OR.getProperty("envreports_totalrecords_XPATH")));
				int reportCount = reportList.size();

				for (int i = 1; i < reportCount; i++) {

					// click on the first record
					String firstReport = "//table[@id='environmentalDocumentListTable']//tbody//tr[" + i
							+ "]//td[@class='ng-scope'][1]";
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

	}
}
