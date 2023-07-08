package testcases.smokesuite;

import java.io.IOException;
import java.time.LocalDate;
import java.util.Hashtable;
import java.util.List;
import java.util.Random;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.Reporter;
import org.testng.SkipException;
import org.testng.annotations.Test;

import com.google.inject.Key;
import com.relevantcodes.extentreports.LogStatus;

import base.TestBase;
import utilities.TestUtil;

public class RR5940PSDashboard3Test extends TestBase {

	@Test(dataProviderClass = TestUtil.class, dataProvider = "dp")
	public void rR5940PSDashboard3Test(Hashtable<String, String> data) throws IOException, InterruptedException {

		execution(data, "rR5940PSDashboard3Test");

		// refresh the page
		driver.navigate().refresh();
		Thread.sleep(5000);
		driver.navigate().refresh();

		// VERIFY THE COUNTS AND DETAILS OF THE ENVIRONMENTAL REPORT CARDS OF THE
		// PORTFOLIO SUMMARY DASHBOARD
		title("VERIFY THE COUNTS AND DETAILS OF THE ENVIRONMENTAL REPORT CARDS OF THE PORTFOLIO SUMMARY DASHBOARD");

		// LOGIN WITH ADMIN USER
		title("LOGIN WITH ADMIN USER");

		try {
			// wait for the element
			explicitWaitClickable("signinbtn_BTNTEXT");

			// Enter the username
			type("usernametxt_CSS", data.get("username_1"));

			// Enter the password
			type("passwordtxt_CSS", data.get("password_1"));

			// Clicking on the "Sign In" button
			click("signinbtn_BTNTEXT");

			// wait for the element
			explicitWait("propertylist_title_XPATH");

			// verify the property list
			switchVerification("propertylist_title_XPATH", "Property List", "The property list is not displayed.");

			// UPDATE THE SYSTEM COMPANY
			updateCompany(data);

		} catch (Throwable t) {
			verificationFailed();
		}

		// VERIFY THE CERTIFICATE OF APPROVAL REPORT CONFIGURATION
		title("VERIFY THE CERTIFICATE OF APPROVAL REPORT CONFIGURATION");

		try {
			// wait for the element
			explicitWaitClickable("questionnaire_settingicon_CSS");

			// click on the settings icon from the top of the screen
			click("questionnaire_settingicon_CSS");

			// wait for the element
			explicitWaitClickable("questionnaire_administrationoption_XPATH");

			// click on the administration option from the side menu
			click("questionnaire_administrationoption_XPATH");

			// click on the environmental tab
			click("questionnaire_environmentaltab_XPATH");

			// click on the environmental reports option
			click("questionnaire_environmentalreportsoption_XPATH");

			// scroll down to the screen
			scrollTillElement("environmental_reportlist_certificationofapproval_dropdown_XPATH");
			scrollByPixel(-400);

			// click on the drop down of the Certificate of Approval report
			click("environmental_reportlist_certificationofapproval_dropdown_XPATH");

			// click on the other options option
			click("environmental_reportlist_certificationofapproval_dropdown_otheroption_XPATH");

			// enter the data in the report frequency field

			type("environmental_reportlist_environmentalactionreporttext_reportfrequencytxt_CSS", "5");

			// select the year option from the report period drop down
			select("environmental_reportlist_environmentalactionreporttext_reportPerioddd_CSS", "Year");

			// click on the save button
			click("environmental_reportlist_environmentalactionreporttext_savebtn_XPATH");

			// wait for the element
			explicitWaitClickable("closetoastmsg_CSS");

			// click on the toaster close button
			click("closetoastmsg_CSS");

		} catch (Throwable t) {
			verificationFailed();
		}

		// click on the home icon from the top of the screen
		click("questionnaire_homeburgermenubtn_CSS");

		// synchronization
		explicitWait("propertylist_title_XPATH");

		// verify the property list
		switchVerification("propertylist_title_XPATH", "Property List", "The property list is not displayed.");

		// RUN THE BATCH PROCESS FOR THE ENVIRONMENTAL REPORTS - SUPER ADMIN USER
		title("RUN THE BATCH PROCESS FOR THE ENVIRONMENTAL REPORTS - SUPER ADMIN USER");

		try {
			// wait for the 5 seconds
			Thread.sleep(5000);

			// click on the settings icon from the top of the screen
			click("questionnaire_settingicon_CSS");

			// wait for the 5 seconds
			Thread.sleep(5000);

			// click on the administration option from the side menu
			click("questionnaire_administrationoption_XPATH");

			// click on the system tab
			click("questionnaire_systemtab_XPATH");

			// click on the batch process option
			click("questionnaire_batchprocessoption_XPATH");

			// enter batch process name in the search field

			type("ssc_company2_securitysettings_filtertxt_CSS", data.get("batch_process"));

			// click on the play button of searched batch process
			click("batchprocess_environmentalreport_playbtn_XPATH");

			// click on the run button
			click("batchprocess_environmentalreport_runbtn_XPATH");

			// wait for the element
			explicitWaitClickable("closetoastmsg_CSS");

			// click on the toaster close button
			click("closetoastmsg_CSS");

		} catch (Throwable t) {
			verificationFailed();
		}

		// click on the home icon from the top of the screen
		click("questionnaire_homeburgermenubtn_CSS");

		// synchronization
		explicitWait("propertylist_title_XPATH");

		// verify the property list
		switchVerification("propertylist_title_XPATH", "Property List", "The property list is not displayed.");

		// VERIFY COUNT OF THE CERTIFICATE OF APPROVAL CARD OF THE PORTFOLIO SUMMARY
		// DASHBOARD SCREEN BEFORE ADDED THE ENVIRONMENTAL REPORTS
		title("VERIFY COUNT OF THE CERTIFICATE OF APPROVAL CARD OF THE PORTFOLIO SUMMARY DASHBOARD SCREEN BEFORE ADDED THE ENVIRONMENTAL REPORTS");

		try {

			// wait for the element
			Thread.sleep(5000);

			// click on the side menu button
			click("menubtn_CSS");

			// wait for the element
			Thread.sleep(5000);

			// click on the portfolio summary option
			click("sidemenu_portfoliosummary_XPATH");

			// verify property count
			switchVerification("portfoliosummary_toppropertycount_XPATH", "4",
					"The property count is not displayed correctly.");

			// scroll down the screen
			scrollTillElement("portfoliosummary_certificateofapprovallabel_XPATH");

			// wait for the element
			Thread.sleep(5000);

			// verify percentage of the Certificate of Approval
			switchVerification("portfoliosummary_certificateofapproval_count1_XPATH", "0%",
					"The percentage of the Certificate of Approval is displayed incorrect.");

			// verify count of the Expired/Not Available of the Certificate of Approval card
			switchVerification("portfoliosummary_certificateofapproval_count2_XPATH", "4",
					"verify count of the Expired/Not Available of the Certificate of Approval card.");

			// verify count of the Excluded/Not Applicable of the Certificate of Approval
			// card
			switchVerification("portfoliosummary_certificateofapproval_count3_XPATH", "0",
					"verify count of the Excluded/Not Applicable of the Certificate of Approval card.");

			// verify count of the Overdue Tasks of the Certificate of Approval card
			switchVerification("portfoliosummary_certificateofapproval_count4_XPATH", "0",
					"verify count of the Overdue Tasks of the Certificate of Approval card.");

		} catch (Throwable t) {
			verificationFailed();
		}

		// click on the home icon from the top of the screen
		click("questionnaire_homeburgermenubtn_hide_CSS");

		// synchronization
		explicitWait("propertylist_title_XPATH");

		// verify the property list
		switchVerification("propertylist_title_XPATH", "Property List", "The property list is not displayed.");

		// CREATE ENVIRONMENTAL REPORT WITH THE CERTIFICATE OF APPROVAL
		title("CREATE ENVIRONMENTAL REPORT WITH THE CERTIFICATE OF APPROVAL");

		try {

			// enter the property name in the search field
			type("envreports_propertylist_filtertxt_CSS", data.get("property_4"));

			// click on the environmental icon
			click("environmentalicon_CSS");

			// wait for the element
			explicitWaitClickable("ssc_leftsidemenubtn_CSS");

			// click on the side menu
			click("ssc_leftsidemenubtn_CSS");

			// wait for the element
			explicitWaitClickable("envreportoption_XPATH");

			// click on the environmental report
			click("envreportoption_XPATH");

			// click on the add button
			click("envreportaddbtn_CSS");

			// select the checklist from the type dropdown
			select("envreporttypedd_CSS", data.get("type"));

			// enter the title
			type("envreporttitletxt_CSS", data.get("title"));

			// scroll down the screen

			scrollByPixel(400);

			// click on the date field
			click("envreportdatetxt_CSS");

			// click on the today button
			click("envreporttodaydate_BTNTEXT");

			// click on the save report button
			click("envreportsavebtn_CSS");

			// wait for the element
			explicitWaitClickable("closetoastmsg_CSS");

			// click on the toaster close button
			click("closetoastmsg_CSS");

			// wait for the element
			Thread.sleep(5000);

			// enter the newly created environmental report in the search field

			type("task_listofchecklist_filterfield_CSS", data.get("title"));

			// verify the newly created environmental report is displayed or not
			switchVerification("environmental_searchedreport_psd1_XPATH", "Test Environmental Report PSD 1",
					"The Test Environmental Report PSD 1 is not displayed.");

		} catch (Throwable t) {
			verificationFailed();
		}

		// click on the home icon from the top of the screen
		click("questionnaire_homeburgermenubtn_hide_CSS");

		// synchronization
		explicitWait("propertylist_title_XPATH");

		// verify the property list
		switchVerification("propertylist_title_XPATH", "Property List", "The property list is not displayed.");

		// VERIFY COUNT AND DETAILS OF THE CERTIFICATE OF APPROVAL CARD OF THE PORTFOLIO
		// SUMMARY DASHBOARD SCREEN AFTER ADDED THE ENVIRONMENTAL REPORTS
		title("VERIFY COUNT AND DETAILS OF THE CERTIFICATE OF APPROVAL CARD OF THE PORTFOLIO SUMMARY DASHBOARD SCREEN AFTER ADDED THE ENVIRONMENTAL REPORTS");

		try {

			// wait for the element
			Thread.sleep(5000);

			// click on the side menu button
			click("menubtn_CSS");

			// wait for the element
			Thread.sleep(5000);

			// click on the portfolio summary option
			click("sidemenu_portfoliosummary_XPATH");

			// verify property count
			switchVerification("portfoliosummary_toppropertycount_XPATH", "4",
					"The property count is not displayed correctly.");

			// scroll down the screen
			scrollTillElement("portfoliosummary_certificateofapprovallabel_XPATH");

			// wait for the element
			Thread.sleep(5000);

			// verify percentage of the Certificate of Approval
			switchVerification("portfoliosummary_certificateofapproval_count1_XPATH", "25%",
					"The percentage of the Certificate of Approval is displayed incorrect.");

			// verify count of the Expired/Not Available of the Certificate of Approval card
			switchVerification("portfoliosummary_certificateofapproval_count2_XPATH", "3",
					"verify count of the Expired/Not Available of the Certificate of Approval card.");

			// verify count of the Excluded/Not Applicable of the Certificate of Approval
			// card
			switchVerification("portfoliosummary_certificateofapproval_count3_XPATH", "0",
					"verify count of the Excluded/Not Applicable of the Certificate of Approval card.");

			// verify count of the Overdue Tasks of the Certificate of Approval card
			switchVerification("portfoliosummary_certificateofapproval_count4_XPATH", "0",
					"verify count of the Overdue Tasks of the Certificate of Approval card.");

			// click on the percentage of the Certificate of Approval
			click("portfoliosummary_certificateofapproval_count1_XPATH");

			// verify the title of the environmental report
			switchVerification("portfoliosummary_certificateofapproval_listtitle_XPATH", "Certificate of Approval",
					"The Certificate of Approval is not displayed.");

			// enter the property name in the search field

			type("portfoliosummary_certificateofapproval_searchtxt_XPATH", data.get("property_4"));

			// verify the report date
			try {
				LocalDate currentDate1 = LocalDate.now();
				String finalCurrentDate1 = currentDate1.toString();
				String reportDate1 = "//td[text()='" + data.get("property_4") + "']//following-sibling::td[1]";
				String finalReportDate1 = (driver.findElement(By.xpath(reportDate1)).getText()).trim();

				if (finalCurrentDate1.equals(finalReportDate1)) {
					successMessage("The reported date is displayed correctly.");

				} else {
					verificationFailedMessage("The reported date is not displayed correctly.");
				}

			} catch (Throwable t) {
				verificationFailed();
			}

			// verify the next assessment date
			try {
				LocalDate futureDate1 = LocalDate.now().plusYears(5);
				String finalFutureDate1 = futureDate1.toString();
				String nextAssessmentDate1 = "//td[text()='" + data.get("property_4") + "']//following-sibling::td[2]";
				String finalNextAssessmentDate1 = (driver.findElement(By.xpath(nextAssessmentDate1)).getText()).trim();

				if (finalFutureDate1.equals(finalNextAssessmentDate1)) {
					successMessage("The next assessment date is displayed correctly.");

				} else {
					verificationFailedMessage("The next assessment date is not displayed correctly.");
				}

			} catch (Throwable t) {
				verificationFailed();
			}

			// click on the respective searched record
			click("portfoliosummary_certificateofapproval_seachedproperty_XPATH");

			// enter the task name in the search field
			type("sidemenu_reports_searchtxt_XPATH", data.get("title"));

			// click on the respective searched environmental report
			click("portfoliosummary_certificateofapproval_seachedenvreport_XPATH");

			// verify the reported date
			try {
				LocalDate currentDate11 = LocalDate.now();
				String finalCurrentDate11 = currentDate11.toString();
				String actualReportedDate11 = (driver
						.findElement(By.xpath(OR.getProperty("enviromentalreport_reporteddate_XPATH")))
						.getAttribute("value")).trim();

				if (finalCurrentDate11.equals(actualReportedDate11)) {
					successMessage("The reported date is displayed correctly.");
				} else {
					verificationFailedMessage("The reported date is not displayed correctly.");
				}

			} catch (Throwable t) {
				verificationFailed();
			}

			// verify the next assessment date
			try {
				LocalDate futureDate11 = LocalDate.now().plusYears(5);
				String finalFutureDate11 = futureDate11.toString();
				String actualNextAssessmentDate11 = (driver
						.findElement(By.xpath(OR.getProperty("enviromentalreport_nextassessmentdate_XPATH")))
						.getAttribute("value")).trim();

				if (finalFutureDate11.equals(actualNextAssessmentDate11)) {
					successMessage("The next assessment date is displayed correctly.");
				} else {
					verificationFailedMessage("The next assessment date is not displayed correctly.");
				}

			} catch (Throwable t) {
				verificationFailed();
			}

		} catch (Throwable t) {
			verificationFailed();
		}

		// click on the home icon from the top of the screen
		click("questionnaire_homeburgermenubtn_hide_CSS");

		// synchronization
		explicitWait("propertylist_title_XPATH");

		// verify the property list
		switchVerification("propertylist_title_XPATH", "Property List", "The property list is not displayed.");

		// UPDATE THE CERTIFICATE OF APPROVAL REPORT CONFIGURATION
		title("UPDATE THE CERTIFICATE OF APPROVAL REPORT CONFIGURATION");

		try {
			// wait for the element
			explicitWaitClickable("questionnaire_settingicon_CSS");

			// click on the settings icon from the top of the screen
			click("questionnaire_settingicon_CSS");

			// wait for the element
			explicitWaitClickable("questionnaire_administrationoption_XPATH");

			// click on the administration option from the side menu
			click("questionnaire_administrationoption_XPATH");

			// click on the environmental tab
			click("questionnaire_environmentaltab_XPATH");

			// click on the environmental reports option
			click("questionnaire_environmentalreportsoption_XPATH");

			// scroll down to the screen
			scrollTillElement("environmental_reportlist_certificationofapproval_dropdown_XPATH");
			scrollByPixel(-400);

			// click on the drop down of the Certificate of Approval report
			click("environmental_reportlist_certificationofapproval_dropdown_XPATH");

			// click on the other options option
			click("environmental_reportlist_certificationofapproval_dropdown_otheroption_XPATH");

			// enter the data in the report frequency field

			type("environmental_reportlist_environmentalactionreporttext_reportfrequencytxt_CSS", "3");

			// select the year option from the report period drop down
			select("environmental_reportlist_environmentalactionreporttext_reportPerioddd_CSS", "Year");

			// click on the save button
			click("environmental_reportlist_environmentalactionreporttext_savebtn_XPATH");

		} catch (Throwable t) {
			verificationFailed();
		}

		// click on the home icon from the top of the screen
		click("questionnaire_homeburgermenubtn_CSS");

		// synchronization
		explicitWait("propertylist_title_XPATH");

		// verify the property list
		switchVerification("propertylist_title_XPATH", "Property List", "The property list is not displayed.");

		// RUN THE BATCH PROCESS FOR THE ENVIRONMENTAL REPORTS - SUPER ADMIN USER
		title("RUN THE BATCH PROCESS FOR THE ENVIRONMENTAL REPORTS - SUPER ADMIN USER");

		try {
			// wait for the 5 seconds
			Thread.sleep(5000);

			// click on the settings icon from the top of the screen
			click("questionnaire_settingicon_CSS");

			// wait for the 5 seconds
			Thread.sleep(5000);

			// click on the administration option from the side menu
			click("questionnaire_administrationoption_XPATH");

			// click on the system tab
			click("questionnaire_systemtab_XPATH");

			// click on the batch process option
			click("questionnaire_batchprocessoption_XPATH");

			// enter batch process name in the search field

			type("ssc_company2_securitysettings_filtertxt_CSS", data.get("batch_process"));

			// click on the play button of searched batch process
			click("batchprocess_environmentalreport_playbtn_XPATH");

			// click on the run button
			click("batchprocess_environmentalreport_runbtn_XPATH");

			// wait for the element
			explicitWaitClickable("closetoastmsg_CSS");

			// click on the toaster close button
			click("closetoastmsg_CSS");

		} catch (Throwable t) {
			verificationFailed();
		}

		// click on the home icon from the top of the screen
		click("questionnaire_homeburgermenubtn_CSS");

		// synchronization
		explicitWait("propertylist_title_XPATH");

		// verify the property list
		switchVerification("propertylist_title_XPATH", "Property List", "The property list is not displayed.");

		// VERIFY COUNT AND DETAILS OF THE CERTIFICATE OF APPROVAL CARD OF THE PORTFOLIO
		// SUMMARY DASHBOARD SCREEN AFTER UPDATED THE CERTIFICATE OF APPROVAL
		// CONFIGURATION
		title("VERIFY COUNT AND DETAILS OF THE CERTIFICATE OF APPROVAL CARD OF THE PORTFOLIO SUMMARY DASHBOARD SCREEN AFTER UPDATED THE CERTIFICATE OF APPROVAL CONFIGURATION");

		try {

			// wait for the element
			Thread.sleep(5000);

			// click on the side menu button
			click("menubtn_CSS");

			// wait for the element
			Thread.sleep(5000);

			// click on the portfolio summary option
			click("sidemenu_portfoliosummary_XPATH");

			// verify property count
			switchVerification("portfoliosummary_toppropertycount_XPATH", "4",
					"The property count is not displayed correctly.");

			// scroll down the screen

			scrollTillElement("portfoliosummary_certificateofapprovallabel_XPATH");

			// wait for the element
			Thread.sleep(5000);

			// verify percentage of the Certificate of Approval
			switchVerification("portfoliosummary_certificateofapproval_count1_XPATH", "25%",
					"The percentage of the Certificate of Approval is displayed incorrect.");

			// verify count of the Expired/Not Available of the Certificate of Approval card
			switchVerification("portfoliosummary_certificateofapproval_count2_XPATH", "3",
					"verify count of the Expired/Not Available of the Certificate of Approval card.");

			// verify count of the Excluded/Not Applicable of the Certificate of Approval
			// card
			switchVerification("portfoliosummary_certificateofapproval_count3_XPATH", "0",
					"verify count of the Excluded/Not Applicable of the Certificate of Approval card.");

			// verify count of the Overdue Tasks of the Certificate of Approval card
			switchVerification("portfoliosummary_certificateofapproval_count4_XPATH", "0",
					"verify count of the Overdue Tasks of the Certificate of Approval card.");

			// click on the percentage of the Certificate of Approval
			click("portfoliosummary_certificateofapproval_count1_XPATH");

			// verify the title of the environmental report
			switchVerification("portfoliosummary_certificateofapproval_listtitle_XPATH", "Certificate of Approval",
					"The Certificate of Approval is not displayed.");

			// enter the property name in the search field
			type("portfoliosummary_certificateofapproval_searchtxt_XPATH", data.get("property_4"));

			// verify the report date
			try {
				LocalDate currentDate1 = LocalDate.now();
				String finalCurrentDate1 = currentDate1.toString();
				String reportDate1 = "//td[text()='" + data.get("property_4") + "']//following-sibling::td[1]";
				String finalReportDate1 = (driver.findElement(By.xpath(reportDate1)).getText()).trim();

				if (finalCurrentDate1.equals(finalReportDate1)) {
					successMessage("The reported date is displayed correctly.");

				} else {
					verificationFailedMessage("The reported date is not displayed correctly.");
				}

			} catch (Throwable t) {
				verificationFailed();
			}

			// verify the next assessment date
			try {
				LocalDate futureDate1 = LocalDate.now().plusYears(3);
				String finalFutureDate1 = futureDate1.toString();
				String nextAssessmentDate1 = "//td[text()='" + data.get("property_4") + "']//following-sibling::td[2]";
				String finalNextAssessmentDate1 = (driver.findElement(By.xpath(nextAssessmentDate1)).getText()).trim();

				if (finalFutureDate1.equals(finalNextAssessmentDate1)) {
					successMessage("The next assessment date is displayed correctly.");

				} else {
					verificationFailedMessage("The next assessment date is not displayed correctly.");
				}

			} catch (Throwable t) {
				verificationFailed();
			}

			// click on the respective searched record
			click("portfoliosummary_certificateofapproval_seachedproperty_XPATH");

			// enter the task name in the search field
			type("sidemenu_reports_searchtxt_XPATH", data.get("title"));

			// click on the respective searched environmental report
			click("portfoliosummary_certificateofapproval_seachedenvreport_XPATH");

			// verify the reported date
			try {
				LocalDate currentDate11 = LocalDate.now();
				String finalCurrentDate11 = currentDate11.toString();
				String actualReportedDate11 = (driver
						.findElement(By.xpath(OR.getProperty("enviromentalreport_reporteddate_XPATH")))
						.getAttribute("value")).trim();

				if (finalCurrentDate11.equals(actualReportedDate11)) {
					successMessage("The reported date is displayed correctly.");

				} else {
					verificationFailedMessage("The reported date is not displayed correctly.");
				}

			} catch (Throwable t) {
				verificationFailed();
			}

			// verify the next assessment date
			try {
				LocalDate futureDate11 = LocalDate.now().plusYears(3);
				String finalFutureDate11 = futureDate11.toString();
				String actualNextAssessmentDate11 = (driver
						.findElement(By.xpath(OR.getProperty("enviromentalreport_nextassessmentdate_XPATH")))
						.getAttribute("value")).trim();

				if (finalFutureDate11.equals(actualNextAssessmentDate11)) {
					successMessage("The next assessment date is displayed correctly.");

				} else {
					verificationFailedMessage("The next assessment date is not displayed correctly.");
				}

			} catch (Throwable t) {
				verificationFailed();
			}

		} catch (Throwable t) {
			verificationFailed();
		}

		// click on the home icon from the top of the screen
		click("questionnaire_homeburgermenubtn_hide_CSS");

		// synchronization
		explicitWait("propertylist_title_XPATH");

		// verify the property list
		switchVerification("propertylist_title_XPATH", "Property List", "The property list is not displayed.");

		// UPDATE THE REPORT DATE TO THE PAST DATE OF THE ENVIRONMENTAL REPORT
		title("UPDATE THE REPORT DATE TO THE PAST DATE OF THE ENVIRONMENTAL REPORT");

		try {

			// enter the property name in the search field
			type("envreports_propertylist_filtertxt_CSS", data.get("property_4"));

			// click on the environmental icon
			click("environmentalicon_CSS");

			// wait for the element
			explicitWaitClickable("ssc_leftsidemenubtn_CSS");

			// click on the side menu
			click("ssc_leftsidemenubtn_CSS");

			// wait for the element
			explicitWaitClickable("envreportoption_XPATH");

			// click on the environmental report
			click("envreportoption_XPATH");

			// enter the newly created environmental report in the search field

			type("task_listofchecklist_filterfield_CSS", data.get("title"));

			// verify the newly created environmental report is displayed or not
			switchVerification("environmental_searchedreport_psd1_XPATH", "Test Environmental Report PSD 1",
					"The Test Environmental Report PSD 1 is not displayed.");

			// click on newly searched environmental report
			click("environmental_searchedreport_psd1_XPATH");

			// update the reported date to the past date
			LocalDate pasttDate1 = LocalDate.now().minusMonths(6);
			String finalPastDate1 = pasttDate1.toString();

			type("envreportdatetxt_CSS", finalPastDate1);

			// click on the update button
			click("envreportupdatebtn_CSS");

			// wait for the element
			explicitWaitClickable("closetoastmsg_CSS");

			// click on the toaster close button
			click("closetoastmsg_CSS");

		} catch (Throwable t) {
			verificationFailed();
		}

		// click on the home icon from the top of the screen
		click("questionnaire_homeburgermenubtn_hide_CSS");

		// synchronization
		explicitWait("propertylist_title_XPATH");

		// verify the property list
		switchVerification("propertylist_title_XPATH", "Property List", "The property list is not displayed.");

		// VERIFY COUNT AND DETAILS OF THE CERTIFICATE OF APPROVAL CARD OF THE PORTFOLIO
		// SUMMARY DASHBOARD SCREEN AFTER UPDATE THE REPORT DATE TO THE PAST DATE OF THE
		// ENVIRONMENTAL REPORT
		title("VERIFY COUNT AND DETAILS OF THE CERTIFICATE OF APPROVAL CARD OF THE PORTFOLIO SUMMARY DASHBOARD SCREEN AFTER UPDATE THE REPORT DATE TO THE PAST DATE OF THE ENVIRONMENTAL REPORT");

		try {

			// wait for the element
			Thread.sleep(5000);

			// click on the side menu button
			click("menubtn_CSS");

			// wait for the element
			Thread.sleep(5000);

			// click on the portfolio summary option
			click("sidemenu_portfoliosummary_XPATH");

			// verify property count
			switchVerification("portfoliosummary_toppropertycount_XPATH", "4",
					"The property count is not displayed correctly.");

			// scroll down the screen
			scrollTillElement("portfoliosummary_certificateofapprovallabel_XPATH");

			// wait for the element
			Thread.sleep(5000);

			// verify percentage of the Certificate of Approval
			switchVerification("portfoliosummary_certificateofapproval_count1_XPATH", "25%",
					"The percentage of the Certificate of Approval is displayed incorrect.");

			// verify count of the Expired/Not Available of the Certificate of Approval card
			switchVerification("portfoliosummary_certificateofapproval_count2_XPATH", "3",
					"verify count of the Expired/Not Available of the Certificate of Approval card.");

			// verify count of the Excluded/Not Applicable of the Certificate of Approval
			// card
			switchVerification("portfoliosummary_certificateofapproval_count3_XPATH", "0",
					"verify count of the Excluded/Not Applicable of the Certificate of Approval card.");

			// verify count of the Overdue Tasks of the Certificate of Approval card
			switchVerification("portfoliosummary_certificateofapproval_count4_XPATH", "0",
					"verify count of the Overdue Tasks of the Certificate of Approval card.");

			// click on the percentage of the Certificate of Approval
			click("portfoliosummary_certificateofapproval_count1_XPATH");

			// verify the title of the environmental report
			switchVerification("portfoliosummary_certificateofapproval_listtitle_XPATH", "Certificate of Approval",
					"The Certificate of Approval is not displayed.");

			// enter the property name in the search field

			type("portfoliosummary_certificateofapproval_searchtxt_XPATH", data.get("property_4"));

			// verify the report date
			try {
				LocalDate pastDate11 = LocalDate.now().minusMonths(6);
				String finalPastDate11 = pastDate11.toString();
				String reportDate11 = "//td[text()='" + data.get("property_4") + "']//following-sibling::td[1]";
				String finalReportDate11 = (driver.findElement(By.xpath(reportDate11)).getText()).trim();

				if (finalPastDate11.equals(finalReportDate11)) {
					successMessage("The reported date is displayed correctly.");

				} else {
					verificationFailedMessage("The reported date is not displayed correctly.");
				}

			} catch (Throwable t) {
				verificationFailed();
			}

			// verify the next assessment date
			try {
				LocalDate futureDate1 = LocalDate.now().plusYears(3);
				String finalFutureDate1 = futureDate1.toString();
				String nextAssessmentDate1 = "//td[text()='" + data.get("property_4") + "']//following-sibling::td[2]";
				String finalNextAssessmentDate1 = (driver.findElement(By.xpath(nextAssessmentDate1)).getText()).trim();

				if (finalFutureDate1.equals(finalNextAssessmentDate1)) {
					successMessage("The next assessment date is displayed correctly.");

				} else {
					verificationFailedMessage("The next assessment date is not displayed correctly.");
				}

			} catch (Throwable t) {
				verificationFailed();
			}

			// click on the respective searched record
			click("portfoliosummary_certificateofapproval_seachedproperty_XPATH");

			// enter the task name in the search field
			type("sidemenu_reports_searchtxt_XPATH", data.get("title"));

			// click on the respective searched environmental report
			click("portfoliosummary_certificateofapproval_seachedenvreport_XPATH");

			// verify the reported date
			try {
				LocalDate pastDate111 = LocalDate.now().minusMonths(6);
				String finalPastDate111 = pastDate111.toString();
				String actualReportedDate111 = (driver
						.findElement(By.xpath(OR.getProperty("enviromentalreport_reporteddate_XPATH")))
						.getAttribute("value")).trim();

				if (finalPastDate111.equals(actualReportedDate111)) {
					successMessage("The reported date is displayed correctly.");
				} else {
					verificationFailedMessage("The reported date is not displayed correctly.");
				}

			} catch (Throwable t) {
				verificationFailed();
			}

			// verify the next assessment date
			try {
				LocalDate futureDate11 = LocalDate.now().plusYears(3);
				String finalFutureDate11 = futureDate11.toString();
				String actualNextAssessmentDate11 = (driver
						.findElement(By.xpath(OR.getProperty("enviromentalreport_nextassessmentdate_XPATH")))
						.getAttribute("value")).trim();

				if (finalFutureDate11.equals(actualNextAssessmentDate11)) {
					successMessage("The next assessment date is displayed correctly.");

				} else {
					verificationFailedMessage("The next assessment date is not displayed correctly.");
				}

			} catch (Throwable t) {
				verificationFailed();
			}

		} catch (Throwable t) {
			verificationFailed();
		}

		// click on the home icon from the top of the screen
		click("questionnaire_homeburgermenubtn_hide_CSS");

		// synchronization
		explicitWait("propertylist_title_XPATH");

		// verify the property list
		switchVerification("propertylist_title_XPATH", "Property List", "The property list is not displayed.");

		// EXCLUDE THE CERTIFICATE OF APPROVAL ENVIRONMENTAL TYPE
		title("EXCLUDE THE CERTIFICATE OF APPROVAL ENVIRONMENTAL TYPE");

		try {

			// wait for the element
			Thread.sleep(5000);

			// click on the side menu button
			click("menubtn_CSS");

			// wait for the element
			Thread.sleep(5000);

			// click on the portfolio summary option
			click("sidemenu_portfoliosummary_XPATH");

			// verify property count
			switchVerification("portfoliosummary_toppropertycount_XPATH", "4",
					"The property count is not displayed correctly.");

			// scroll down the screen
			scrollTillElement("portfoliosummary_certificateofapprovallabel_XPATH");

			// wait for the element
			Thread.sleep(5000);

			// verify percentage of the Certificate of Approval
			switchVerification("portfoliosummary_certificateofapproval_count1_XPATH", "25%",
					"The percentage of the Certificate of Approval is displayed incorrect.");

			// verify count of the Expired/Not Available of the Certificate of Approval card
			switchVerification("portfoliosummary_certificateofapproval_count2_XPATH", "3",
					"verify count of the Expired/Not Available of the Certificate of Approval card.");

			// verify count of the Excluded/Not Applicable of the Certificate of Approval
			// card
			switchVerification("portfoliosummary_certificateofapproval_count3_XPATH", "0",
					"verify count of the Excluded/Not Applicable of the Certificate of Approval card.");

			// verify count of the Overdue Tasks of the Certificate of Approval card
			switchVerification("portfoliosummary_certificateofapproval_count4_XPATH", "0",
					"verify count of the Overdue Tasks of the Certificate of Approval card.");

			// click on the percentage of the Certificate of Approval
			click("portfoliosummary_certificateofapproval_count1_XPATH");

			// verify the title of the environmental report
			switchVerification("portfoliosummary_certificateofapproval_listtitle_XPATH", "Certificate of Approval",
					"The Certificate of Approval is not displayed.");

			// enter the property name in the search field

			type("portfoliosummary_certificateofapproval_searchtxt_XPATH", data.get("property_4"));

			// click on the action icon of the respective searched record
			click("portfoliosummary_certificateofapproval_seachedproperty_actionicon_XPATH");

			// click on the assessment schedule option
			click("portfoliosummary_certificateofapproval_seachedproperty_option1_XPATH");

			// validate and select the not required checkbox

			try {
				boolean notRequiredCkbx = driver
						.findElement(
								By.xpath(OR.getProperty("portfoliosummary_certificateofapproval_notrequired_XPATH")))
						.isSelected();

				if (notRequiredCkbx == false) {

					// click on the not required checkbox
					click("portfoliosummary_certificateofapproval_notrequired_XPATH");

					successMessage("The not required checkbox is displayed selected.");

				} else {

					successMessage("The not required checkbox is displayed selected.");
				}

			} catch (Throwable t) {
				verificationFailed();
			}

			// click on the save button
			click("portfoliosummary_certificateofapproval_notrequired_savebtn_XPATH");

			// enter the property name in the search field

			type("portfoliosummary_certificateofapproval_searchtxt_XPATH", data.get("property_4"));

			// verify respective property is displayed or not
			deleteVerification("portfoliosummary_certificateofapproval_seachedproperty_XPATH",
					"SmartCentres Brockville");

		} catch (Throwable t) {
			verificationFailed();
		}

		// click on the home icon from the top of the screen
		click("questionnaire_homeburgermenubtn_hide_CSS");

		// synchronization
		explicitWait("propertylist_title_XPATH");

		// verify the property list
		switchVerification("propertylist_title_XPATH", "Property List", "The property list is not displayed.");

		// VERIFY COUNT AND DETAILS OF THE CERTIFICATE OF APPROVAL CARD OF THE PORTFOLIO
		// SUMMARY DASHBOARD SCREEN AFTER EXCLUDE THE ENVIRONMENTAL REPORTS
		title("VERIFY COUNT AND DETAILS OF THE CERTIFICATE OF APPROVAL CARD OF THE PORTFOLIO SUMMARY DASHBOARD SCREEN AFTER EXCLUDE THE ENVIRONMENTAL REPORTS");

		try {

			// wait for the element
			Thread.sleep(5000);

			// click on the side menu button
			click("menubtn_CSS");

			// wait for the element
			Thread.sleep(5000);

			// click on the portfolio summary option
			click("sidemenu_portfoliosummary_XPATH");

			// verify property count
			switchVerification("portfoliosummary_toppropertycount_XPATH", "4",
					"The property count is not displayed correctly.");

			// scroll down the screen
			scrollTillElement("portfoliosummary_certificateofapprovallabel_XPATH");

			// wait for the element
			Thread.sleep(5000);

			// verify percentage of the Certificate of Approval
			switchVerification("portfoliosummary_certificateofapproval_count1_XPATH", "0%",
					"The percentage of the Certificate of Approval is displayed incorrect.");

			// verify count of the Expired/Not Available of the Certificate of Approval card
			switchVerification("portfoliosummary_certificateofapproval_count2_XPATH", "3",
					"verify count of the Expired/Not Available of the Certificate of Approval card.");

			// verify count of the Excluded/Not Applicable of the Certificate of Approval
			// card
			switchVerification("portfoliosummary_certificateofapproval_count3_XPATH", "1",
					"verify count of the Excluded/Not Applicable of the Certificate of Approval card.");

			// verify count of the Overdue Tasks of the Certificate of Approval card
			switchVerification("portfoliosummary_certificateofapproval_count4_XPATH", "0",
					"verify count of the Overdue Tasks of the Certificate of Approval card.");

			// click on the percentage of the Certificate of Approval
			click("portfoliosummary_certificateofapproval_count1_XPATH");

			// verify the title of the environmental report
			switchVerification("portfoliosummary_certificateofapproval_listtitle_XPATH", "Certificate of Approval",
					"The Certificate of Approval is not displayed.");

			// enter the property name in the search field

			type("portfoliosummary_certificateofapproval_searchtxt_XPATH", data.get("property_4"));

			// verify respective property is displayed or not
			deleteVerification("portfoliosummary_certificateofapproval_seachedproperty_XPATH",
					"SmartCentres Brockville");

		} catch (Throwable t) {
			verificationFailed();
		}

		// click on the home icon from the top of the screen
		click("questionnaire_homeburgermenubtn_hide_CSS");

		// synchronization
		explicitWait("propertylist_title_XPATH");

		// verify the property list
		switchVerification("propertylist_title_XPATH", "Property List", "The property list is not displayed.");

		// REMOVE EXCLUDE OF THE CERTIFICATE OF APPROVAL ENVIRONMENTAL TYPE
		title("REMOVE EXCLUDE OF THE CERTIFICATE OF APPROVAL ENVIRONMENTAL TYPE");

		try {

			// wait for the element
			Thread.sleep(5000);

			// click on the side menu button
			click("menubtn_CSS");

			// wait for the element
			Thread.sleep(5000);

			// click on the portfolio summary option
			click("sidemenu_portfoliosummary_XPATH");

			// verify property count
			switchVerification("portfoliosummary_toppropertycount_XPATH", "4",
					"The property count is not displayed correctly.");

			// scroll down the screen
			scrollTillElement("portfoliosummary_certificateofapprovallabel_XPATH");

			// wait for the element
			Thread.sleep(5000);

			// verify percentage of the Certificate of Approval
			switchVerification("portfoliosummary_certificateofapproval_count1_XPATH", "0%",
					"The percentage of the Certificate of Approval is displayed incorrect.");

			// verify count of the Expired/Not Available of the Certificate of Approval card
			switchVerification("portfoliosummary_certificateofapproval_count2_XPATH", "3",
					"verify count of the Expired/Not Available of the Certificate of Approval card.");

			// verify count of the Excluded/Not Applicable of the Certificate of Approval
			// card
			switchVerification("portfoliosummary_certificateofapproval_count3_XPATH", "1",
					"verify count of the Excluded/Not Applicable of the Certificate of Approval card.");

			// verify count of the Overdue Tasks of the Certificate of Approval card
			switchVerification("portfoliosummary_certificateofapproval_count4_XPATH", "0",
					"verify count of the Overdue Tasks of the Certificate of Approval card.");

			// click on the percentage of the Certificate of Approval
			click("portfoliosummary_certificateofapproval_count3_XPATH");

			// enter the property name in the search field

			type("portfoliosummary_certificateofapproval_searchtxt_XPATH", data.get("property_4"));

			// click on the action icon of the respective searched record
			click("portfoliosummary_certificateofapproval_seachedproperty_actionicon_XPATH");

			// click on the assessment schedule option
			click("portfoliosummary_certificateofapproval_seachedproperty_option1_XPATH");

			// validate and select the not required checkbox

			try {
				boolean notRequiredCkbx = driver
						.findElement(
								By.xpath(OR.getProperty("portfoliosummary_certificateofapproval_notrequired_XPATH")))
						.isSelected();

				if (notRequiredCkbx == true) {

					// click on the not required checkbox
					click("portfoliosummary_certificateofapproval_notrequired_XPATH");

					successMessage("The not required checkbox is not displayed selected.");

				} else {

					successMessage("The not required checkbox is not displayed selected.");
				}

			} catch (Throwable t) {
				verificationFailed();
			}

			// click on the save button
			click("portfoliosummary_certificateofapproval_notrequired_savebtn_XPATH");

			// enter the property name in the search field

			type("portfoliosummary_certificateofapproval_searchtxt_XPATH", data.get("property_4"));

			// verify respective property is displayed or not
			deleteVerification("portfoliosummary_certificateofapproval_seachedproperty_XPATH",
					"SmartCentres Brockville");

		} catch (Throwable t) {
			verificationFailed();
		}

		// click on the home icon from the top of the screen
		click("questionnaire_homeburgermenubtn_hide_CSS");

		// synchronization
		explicitWait("propertylist_title_XPATH");

		// verify the property list
		switchVerification("propertylist_title_XPATH", "Property List", "The property list is not displayed.");

		// VERIFY COUNT AND DETAILS OF THE CERTIFICATE OF APPROVAL CARD OF THE PORTFOLIO
		// SUMMARY DASHBOARD SCREEN AFTER REMOVE EXCLUDE THE ENVIRONMENTAL REPORTS
		title("VERIFY COUNT AND DETAILS OF THE CERTIFICATE OF APPROVAL CARD OF THE PORTFOLIO SUMMARY DASHBOARD SCREEN AFTER REMOVE EXCLUDE THE ENVIRONMENTAL REPORTS");

		try {

			// wait for the element
			Thread.sleep(5000);

			// click on the side menu button
			click("menubtn_CSS");

			// wait for the element
			Thread.sleep(5000);

			// click on the portfolio summary option
			click("sidemenu_portfoliosummary_XPATH");

			// verify property count
			switchVerification("portfoliosummary_toppropertycount_XPATH", "4",
					"The property count is not displayed correctly.");

			// scroll down the screen
			scrollTillElement("portfoliosummary_certificateofapprovallabel_XPATH");

			// wait for the element
			Thread.sleep(5000);

			// verify percentage of the Certificate of Approval
			switchVerification("portfoliosummary_certificateofapproval_count1_XPATH", "25%",
					"The percentage of the Certificate of Approval is displayed incorrect.");

			// verify count of the Expired/Not Available of the Certificate of Approval card
			switchVerification("portfoliosummary_certificateofapproval_count2_XPATH", "3",
					"verify count of the Expired/Not Available of the Certificate of Approval card.");

			// verify count of the Excluded/Not Applicable of the Certificate of Approval
			// card
			switchVerification("portfoliosummary_certificateofapproval_count3_XPATH", "0",
					"verify count of the Excluded/Not Applicable of the Certificate of Approval card.");

			// verify count of the Overdue Tasks of the Certificate of Approval card
			switchVerification("portfoliosummary_certificateofapproval_count4_XPATH", "0",
					"verify count of the Overdue Tasks of the Certificate of Approval card.");

			// click on the percentage of the Certificate of Approval
			click("portfoliosummary_certificateofapproval_count1_XPATH");

			// verify the title of the environmental report
			switchVerification("portfoliosummary_certificateofapproval_listtitle_XPATH", "Certificate of Approval",
					"The Certificate of Approval is not displayed.");

			// enter the property name in the search field

			type("portfoliosummary_certificateofapproval_searchtxt_XPATH", data.get("property_4"));

			// verify respective property is displayed or not
			switchVerification("portfoliosummary_certificateofapproval_seachedproperty_XPATH",
					"SmartCentres Brockville", "The SmartCentres Brockville is not displayed.");

		} catch (Throwable t) {
			verificationFailed();
		}

		// click on the home icon from the top of the screen
		click("questionnaire_homeburgermenubtn_hide_CSS");

		// synchronization
		explicitWait("propertylist_title_XPATH");

		// verify the property list
		switchVerification("propertylist_title_XPATH", "Property List", "The property list is not displayed.");

		// ADD TASK IN THE ENVIRONMENTAL REPORT WITHOUT DUE DATE
		title("ADD TASK IN THE ENVIRONMENTAL REPORT WITHOUT DUE DATE");

		try {

			// enter the property name in the search field
			type("envreports_propertylist_filtertxt_CSS", data.get("property_4"));

			// click on the environmental icon
			click("environmentalicon_CSS");

			// wait for the element
			explicitWaitClickable("ssc_leftsidemenubtn_CSS");

			// click on the side menu
			click("ssc_leftsidemenubtn_CSS");

			// wait for the element
			explicitWaitClickable("envreportoption_XPATH");

			// click on the environmental report
			click("envreportoption_XPATH");

			// click on the newly created environmental report
			click("environmental_searchedreport_psd1_XPATH");

			// click on the task tab
			click("envreportaddedrecord_tasktab_XPATH");

			// click on the new task button
			click("envreportaddedrecord_tasktab_newtaskbtn_XPATH");

			// enter the task title
			type("riskmanagement_insuranceclaim_task_titletxt_XPATH", data.get("task_title"));

			// click on the save report button
			click("environmental_task_submitbtn_XPATH");

			// wait for the element
			Thread.sleep(5000);

			// verify newly created task is displayed or not
			switchVerification("environmental_task_createdtask_psd1_XPATH", "Task Environmental Report PSD 1",
					"The Task Environmental Report PSD 1 is not displayed.");

			// click on the update button of the environmental report
			click("envreportupdatebtn_CSS");

			// wait for the element
			explicitWaitClickable("closetoastmsg_CSS");

			// click on the toaster close button
			click("closetoastmsg_CSS");

			// enter the newly created environmental report in the search field

			type("task_listofchecklist_filterfield_CSS", data.get("title"));

			// verify the newly created environmental report is displayed or not
			switchVerification("environmental_searchedreport_psd1_XPATH", "Test Environmental Report PSD 1",
					"The Test Environmental Report PSD 1 is not displayed.");

		} catch (Throwable t) {
			verificationFailed();
		}

		// click on the home icon from the top of the screen
		click("questionnaire_homeburgermenubtn_hide_CSS");

		// synchronization
		explicitWait("propertylist_title_XPATH");

		// verify the property list
		switchVerification("propertylist_title_XPATH", "Property List", "The property list is not displayed.");

		// VERIFY COUNT AND DETAILS OF THE CERTIFICATE OF APPROVAL CARD OF THE PORTFOLIO
		// SUMMARY DASHBOARD SCREEN AFTER ADDED THE TASK IN THE ENVIRONMENTAL REPORTS
		// WITH FUTURE DUE DATE
		title("VERIFY COUNT AND DETAILS OF THE CERTIFICATE OF APPROVAL CARD OF THE PORTFOLIO SUMMARY DASHBOARD SCREEN AFTER ADDED THE TASK IN THE ENVIRONMENTAL REPORTS WITHOUT DUE DATE");

		try {

			// wait for the element
			Thread.sleep(5000);

			// click on the side menu button
			click("menubtn_CSS");

			// wait for the element
			Thread.sleep(5000);

			// click on the portfolio summary option
			click("sidemenu_portfoliosummary_XPATH");

			// verify property count
			switchVerification("portfoliosummary_toppropertycount_XPATH", "4",
					"The property count is not displayed correctly.");

			// scroll down the screen
			scrollTillElement("portfoliosummary_certificateofapprovallabel_XPATH");

			// wait for the element
			Thread.sleep(5000);

			// verify percentage of the Certificate of Approval
			switchVerification("portfoliosummary_certificateofapproval_count1_XPATH", "25%",
					"The percentage of the Certificate of Approval is displayed incorrect.");

			// verify count of the Expired/Not Available of the Certificate of Approval card
			switchVerification("portfoliosummary_certificateofapproval_count2_XPATH", "3",
					"verify count of the Expired/Not Available of the Certificate of Approval card.");

			// verify count of the Excluded/Not Applicable of the Certificate of Approval
			// card
			switchVerification("portfoliosummary_certificateofapproval_count3_XPATH", "0",
					"verify count of the Excluded/Not Applicable of the Certificate of Approval card.");

			// verify count of the Overdue Tasks of the Certificate of Approval card
			switchVerification("portfoliosummary_certificateofapproval_count4_XPATH", "0",
					"verify count of the Overdue Tasks of the Certificate of Approval card.");

		} catch (Throwable t) {
			verificationFailed();
		}

		// click on the home icon from the top of the screen
		click("questionnaire_homeburgermenubtn_hide_CSS");

		// synchronization
		explicitWait("propertylist_title_XPATH");

		// verify the property list
		switchVerification("propertylist_title_XPATH", "Property List", "The property list is not displayed.");

		// UPDATE THE TASK OF THE ENVIRONMENTAL REPORT WITH TODAY DUE DATE
		title("UPDATE THE TASK OF THE ENVIRONMENTAL REPORT WITH TODAY DUE DATE");

		try {

			// enter the property name in the search field
			type("envreports_propertylist_filtertxt_CSS", data.get("property_4"));

			// click on the environmental icon
			click("environmentalicon_CSS");

			// wait for the element
			explicitWaitClickable("ssc_leftsidemenubtn_CSS");

			// click on the side menu
			click("ssc_leftsidemenubtn_CSS");

			// wait for the element
			explicitWaitClickable("envreportoption_XPATH");

			// click on the environmental report
			click("envreportoption_XPATH");

			// click on the newly created environmental report
			click("environmental_searchedreport_psd1_XPATH");

			// click on the task tab
			click("envreportaddedrecord_tasktab_XPATH");

			// click on the newly created task
			click("environmental_task_createdtask_psd1_XPATH");

			// click on the due date field
			click("envreportaddedrecord_duedate1_XPATH");

			// scroll down the screen

			scrollByPixel(200);

			// click on the today button
			click("envreporttodaydate_BTNTEXT");

			// click on the update task button
			click("environmental_task_submitbtn_XPATH");

			// wait for the element
			Thread.sleep(5000);

			// verify newly created task is displayed or not
			switchVerification("environmental_task_createdtask_psd1_XPATH", "Task Environmental Report PSD 1",
					"The Task Environmental Report PSD 1 is not displayed.");

			// click on the update button of the environmental report
			click("envreportupdatebtn_CSS");

			// enter the newly created environmental report in the search field
			type("task_listofchecklist_filterfield_CSS", data.get("title"));

			// verify the newly created environmental report is displayed or not
			switchVerification("environmental_searchedreport_psd1_XPATH", "Test Environmental Report PSD 1",
					"The Test Environmental Report PSD 1 is not displayed.");

		} catch (Throwable t) {
			verificationFailed();
		}

		// click on the home icon from the top of the screen
		click("questionnaire_homeburgermenubtn_hide_CSS");

		// synchronization
		explicitWait("propertylist_title_XPATH");

		// verify the property list
		switchVerification("propertylist_title_XPATH", "Property List", "The property list is not displayed.");

		// VERIFY COUNT AND DETAILS OF THE CERTIFICATE OF APPROVAL CARD OF THE PORTFOLIO
		// SUMMARY DASHBOARD SCREEN AFTER UPDATE THE TASK IN THE ENVIRONMENTAL REPORTS
		// WITH PAST DUE DATE
		title("VERIFY COUNT AND DETAILS OF THE CERTIFICATE OF APPROVAL CARD OF THE PORTFOLIO SUMMARY DASHBOARD SCREEN AFTER UPDATE THE TASK IN THE ENVIRONMENTAL REPORTS WITH TODAY'S DUE DATE");

		try {

			// wait for the element
			Thread.sleep(5000);

			// click on the side menu button
			click("menubtn_CSS");

			// wait for the element
			Thread.sleep(5000);

			// click on the portfolio summary option
			click("sidemenu_portfoliosummary_XPATH");

			// verify property count
			switchVerification("portfoliosummary_toppropertycount_XPATH", "4",
					"The property count is not displayed correctly.");

			// scroll down the screen
			scrollTillElement("portfoliosummary_certificateofapprovallabel_XPATH");

			// wait for the element
			Thread.sleep(5000);

			// verify percentage of the Certificate of Approval
			switchVerification("portfoliosummary_certificateofapproval_count1_XPATH", "25%",
					"The percentage of the Certificate of Approval is displayed incorrect.");

			// verify count of the Expired/Not Available of the Certificate of Approval card
			switchVerification("portfoliosummary_certificateofapproval_count2_XPATH", "3",
					"verify count of the Expired/Not Available of the Certificate of Approval card.");

			// verify count of the Excluded/Not Applicable of the Certificate of Approval
			// card
			switchVerification("portfoliosummary_certificateofapproval_count3_XPATH", "0",
					"verify count of the Excluded/Not Applicable of the Certificate of Approval card.");

			// verify count of the Overdue Tasks of the Certificate of Approval card
			switchVerification("portfoliosummary_certificateofapproval_count4_XPATH", "1",
					"verify count of the Overdue Tasks of the Certificate of Approval card.");

		} catch (Throwable t) {
			verificationFailed();
		}

		// click on the home icon from the top of the screen
		click("questionnaire_homeburgermenubtn_hide_CSS");

		// synchronization
		explicitWait("propertylist_title_XPATH");

		// verify the property list
		switchVerification("propertylist_title_XPATH", "Property List", "The property list is not displayed.");

		// APPROVE THE TASK OF THE ENVIRONMENTAL REPORT
		title("APPROVE THE TASK OF THE ENVIRONMENTAL REPORT");

		try {

			// enter the property name in the search field
			type("envreports_propertylist_filtertxt_CSS", data.get("property_4"));

			// click on the environmental icon
			click("environmentalicon_CSS");

			// wait for the element
			explicitWaitClickable("ssc_leftsidemenubtn_CSS");

			// click on the side menu
			click("ssc_leftsidemenubtn_CSS");

			// wait for the element
			explicitWaitClickable("envreportoption_XPATH");

			// click on the environmental report
			click("envreportoption_XPATH");

			// click on the newly created environmental report
			click("environmental_searchedreport_psd1_XPATH");

			// click on the task tab
			click("envreportaddedrecord_tasktab_XPATH");

			// click on the newly created task
			click("environmental_task_createdtask_psd1_XPATH");

			// click on the start button
			click("environmental_task_startbtn_XPATH");

			// wait for the element
			explicitWaitClickable("closetoastmsg_CSS");

			// click on the toaster close button
			click("closetoastmsg_CSS");

			// click on the approve button
			click("environmental_task_approvebtn_XPATH");

			// wait for the element
			explicitWaitClickable("closetoastmsg_CSS");

			// click on the toaster close button
			click("closetoastmsg_CSS");

			// click on the update task button
			click("environmental_task_submitbtn_XPATH");

			// wait for the element
			Thread.sleep(5000);

			// verify newly created task is displayed or not
			switchVerification("environmental_task_createdtask_psd1_XPATH", "Task Environmental Report PSD 1",
					"The Task Environmental Report PSD 1 is not displayed.");

			// click on the update button of the environmental report
			click("envreportupdatebtn_CSS");

			// wait for the element
			explicitWaitClickable("closetoastmsg_CSS");

			// click on the toaster close button
			click("closetoastmsg_CSS");

			// enter the newly created environmental report in the search field

			type("task_listofchecklist_filterfield_CSS", data.get("title"));

			// verify the newly created environmental report is displayed or not
			switchVerification("environmental_searchedreport_psd1_XPATH", "Test Environmental Report PSD 1",
					"The Test Environmental Report PSD 1 is not displayed.");

		} catch (Throwable t) {
			verificationFailed();
		}

		// click on the home icon from the top of the screen
		click("questionnaire_homeburgermenubtn_hide_CSS");

		// synchronization
		explicitWait("propertylist_title_XPATH");

		// verify the property list
		switchVerification("propertylist_title_XPATH", "Property List", "The property list is not displayed.");

		// VERIFY COUNT AND DETAILS OF THE CERTIFICATE OF APPROVAL CARD OF THE PORTFOLIO
		// SUMMARY DASHBOARD SCREEN AFTER APPROVE THE TASK OF THE ENVIRONMENTAL REPORT
		title("VERIFY COUNT AND DETAILS OF THE CERTIFICATE OF APPROVAL CARD OF THE PORTFOLIO SUMMARY DASHBOARD SCREEN AFTER APPROVE THE TASK OF THE ENVIRONMENTAL REPORT");

		try {

			// wait for the element
			Thread.sleep(5000);

			// click on the side menu button
			click("menubtn_CSS");

			// wait for the element
			Thread.sleep(5000);

			// click on the portfolio summary option
			click("sidemenu_portfoliosummary_XPATH");

			// verify property count
			switchVerification("portfoliosummary_toppropertycount_XPATH", "4",
					"The property count is not displayed correctly.");

			// scroll down the screen
			scrollTillElement("portfoliosummary_certificateofapprovallabel_XPATH");

			// wait for the element
			Thread.sleep(5000);

			// verify percentage of the Certificate of Approval
			switchVerification("portfoliosummary_certificateofapproval_count1_XPATH", "25%",
					"The percentage of the Certificate of Approval is displayed incorrect.");

			// verify count of the Expired/Not Available of the Certificate of Approval card
			switchVerification("portfoliosummary_certificateofapproval_count2_XPATH", "3",
					"verify count of the Expired/Not Available of the Certificate of Approval card.");

			// verify count of the Excluded/Not Applicable of the Certificate of Approval
			// card
			switchVerification("portfoliosummary_certificateofapproval_count3_XPATH", "0",
					"verify count of the Excluded/Not Applicable of the Certificate of Approval card.");

			// verify count of the Overdue Tasks of the Certificate of Approval card
			switchVerification("portfoliosummary_certificateofapproval_count4_XPATH", "0",
					"verify count of the Overdue Tasks of the Certificate of Approval card.");

		} catch (Throwable t) {
			verificationFailed();
		}

		// click on the home icon from the top of the screen
		click("questionnaire_homeburgermenubtn_hide_CSS");

		// synchronization
		explicitWait("propertylist_title_XPATH");

		// verify the property list
		switchVerification("propertylist_title_XPATH", "Property List", "The property list is not displayed.");

		// DELETE THE NEWLY CREATED ENVIRONMENTAL REPORT
		title("DELETE THE NEWLY CREATED ENVIRONMENTAL REPORT");

		try {

			// enter the property name in the search field
			type("envreports_propertylist_filtertxt_CSS", data.get("property_4"));

			// click on the environmental icon
			click("environmentalicon_CSS");

			// wait for the element
			explicitWaitClickable("ssc_leftsidemenubtn_CSS");

			// click on the side menu
			click("ssc_leftsidemenubtn_CSS");

			// wait for the element
			explicitWaitClickable("envreportoption_XPATH");

			// click on the environmental report
			click("envreportoption_XPATH");

			// enter environmental report in the search field

			type("task_listofchecklist_filterfield_CSS", data.get("title"));

			// click on the environmental report
			click("environmental_searchedreport_psd1_XPATH");

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

			type("task_listofchecklist_filterfield_CSS", data.get("title"));

			// verification of the environmental report is deleted or not
			deleteVerification("environmental_searchedreport_psd1_XPATH", "Test Environmental Report PSD 1");

		} catch (Throwable t) {
			verificationFailed();
		}

		// click on the home icon from the top of the screen
		click("questionnaire_homeburgermenubtn_hide_CSS");

		// wait for the element
		explicitWait("propertylist_title_XPATH");

		// verify the property list
		switchVerification("propertylist_title_XPATH", "Property List", "The property list is not displayed.");

		// DELETE THE NEWLY CREATED TASK FROM THE TASK MODULE
		title("DELETE THE NEWLY CREATED TASK FROM THE TASK MODULE");

		try {
			// enter the property name in the search field

			type("envreports_propertylist_filtertxt_CSS", data.get("property_4"));

			// click on the task icon
			click("taskicon_CSS");

			// click on the clear button
			click("task_createdtask_clearbtn_XPATH");

			// type the newly created task in the search field
			type("task_filter_CSS", data.get("task_title"));

			// click on the search button
			click("task_createdtask_searchbtn_XPATH");

			// verify newly created task is displayed or not
			switchVerification("environmental_task_createdtask1_psd1_XPATH", "Task Environmental Report PSD 1",
					"The Task Environmental Report PSD 1 is not displayed.");

			// click on the searched task
			click("environmental_task_createdtask1_psd1_XPATH");

			// click on the start button
			click("environmental_task_startbtn_XPATH");

			// wait for the element
			explicitWaitClickable("closetoastmsg_CSS");

			// click on the toaster close button
			click("closetoastmsg_CSS");

			// click on the update task button
			click("environmental_task_submitbtn_XPATH");

			// wait for the element
			Thread.sleep(5000);

			// click on the clear button
			click("task_createdtask_clearbtn_XPATH");

			// type the newly created task in the search field
			type("task_filter_CSS", data.get("task_title"));

			// click on the search button
			click("task_createdtask_searchbtn_XPATH");

			// verify newly created task is displayed or not
			switchVerification("environmental_task_createdtask1_psd1_XPATH", "Task Environmental Report PSD 1",
					"The Task Environmental Report PSD 1 is not displayed.");

			// click on the action icon of the searched task
			String actionicon1 = "//p[text()='" + data.get("task_title")
					+ "']//parent::td[@ng-click='editTaskFromLandingPage(task)']//following-sibling::td[@class='text-center pointer']//i[@data-toggle='dropdown']";
			driver.findElement(By.xpath(actionicon1)).click();

			// click on the delete task option
			String deleteTaskOption = "//p[text()='" + data.get("task_title")
					+ "']//parent::td[@ng-click='editTaskFromLandingPage(task)']//following-sibling::td[@class='text-center pointer']//div[@class='dropdown open']//li[@ng-click='deleteSelectedTask(task.id, false);']";
			driver.findElement(By.xpath(deleteTaskOption)).click();

			// wait for the element
			explicitWaitClickable("closetoastmsg_CSS");

			// click on the toaster close button
			click("closetoastmsg_CSS");

			// click on the clear button
			click("task_createdtask_clearbtn_XPATH");

			// type the newly created task in the search field
			type("task_filter_CSS", data.get("task_title"));

			// click on the search button
			click("task_createdtask_searchbtn_XPATH");

			// verify newly created task is displayed or not
			deleteVerification("environmental_task_createdtask1_psd1_XPATH", "Task Environmental Report PSD 1");

		} catch (Throwable t) {
			verificationFailed();
		}

		// click on the home icon from the top of the screen
		click("questionnaire_homeburgermenubtn_hide_CSS");

		// wait for the element
		explicitWait("propertylist_title_XPATH");

		// verify the property list
		switchVerification("propertylist_title_XPATH", "Property List", "The property list is not displayed.");

		// RESET THE CERTIFICATE OF APPROVAL REPORT CONFIGURATION
		title("RESET THE CERTIFICATE OF APPROVAL REPORT CONFIGURATION");

		try {
			// wait for the element
			explicitWaitClickable("questionnaire_settingicon_CSS");

			// click on the settings icon from the top of the screen
			click("questionnaire_settingicon_CSS");

			// wait for the element
			explicitWaitClickable("questionnaire_administrationoption_XPATH");

			// click on the administration option from the side menu
			click("questionnaire_administrationoption_XPATH");

			// click on the environmental tab
			click("questionnaire_environmentaltab_XPATH");

			// click on the environmental reports option
			click("questionnaire_environmentalreportsoption_XPATH");

			// scroll down to the screen
			scrollTillElement("environmental_reportlist_certificationofapproval_dropdown_XPATH");
			scrollByPixel(-400);

			// click on the drop down of the Certificate of Approval report
			click("environmental_reportlist_certificationofapproval_dropdown_XPATH");

			// click on the other options option
			click("environmental_reportlist_certificationofapproval_dropdown_otheroption_XPATH");

			// enter the data in the report frequency field

			type("environmental_reportlist_environmentalactionreporttext_reportfrequencytxt_CSS", "5");

			// select the year option from the report period drop down
			select("environmental_reportlist_environmentalactionreporttext_reportPerioddd_CSS", "Year");

			// click on the save button
			click("environmental_reportlist_environmentalactionreporttext_savebtn_XPATH");

			// wait for the element
			explicitWaitClickable("closetoastmsg_CSS");

			// click on the toaster close button
			click("closetoastmsg_CSS");

		} catch (Throwable t) {
			verificationFailed();
		}

		// click on the home icon from the top of the screen
		click("questionnaire_homeburgermenubtn_CSS");

		// synchronization
		explicitWait("propertylist_title_XPATH");

		// verify the property list
		switchVerification("propertylist_title_XPATH", "Property List", "The property list is not displayed.");

		// RUN THE BATCH PROCESS FOR THE ENVIRONMENTAL REPORTS - SUPER ADMIN USER
		title("RUN THE BATCH PROCESS FOR THE ENVIRONMENTAL REPORTS - SUPER ADMIN USER");

		try {
			// wait for the 5 seconds
			Thread.sleep(5000);

			// click on the settings icon from the top of the screen
			click("questionnaire_settingicon_CSS");

			// wait for the 5 seconds
			Thread.sleep(5000);

			// click on the administration option from the side menu
			click("questionnaire_administrationoption_XPATH");

			// click on the system tab
			click("questionnaire_systemtab_XPATH");

			// click on the batch process option
			click("questionnaire_batchprocessoption_XPATH");

			// enter batch process name in the search field

			type("ssc_company2_securitysettings_filtertxt_CSS", data.get("batch_process"));

			// click on the play button of searched batch process
			click("batchprocess_environmentalreport_playbtn_XPATH");

			// click on the run button
			click("batchprocess_environmentalreport_runbtn_XPATH");

			// wait for the element
			explicitWaitClickable("closetoastmsg_CSS");

			// click on the toaster close button
			click("closetoastmsg_CSS");

		} catch (Throwable t) {
			verificationFailed();
		}

		// click on the home icon from the top of the screen
		click("questionnaire_homeburgermenubtn_CSS");

		// synchronization
		explicitWait("propertylist_title_XPATH");

		// verify the property list
		switchVerification("propertylist_title_XPATH", "Property List", "The property list is not displayed.");

		try {
			// wait for the element
			explicitWaitClickable("questionnaire_settingicon_CSS");

			// click on the settings icon from the top of the screen
			click("questionnaire_settingicon_CSS");

			// wait for the element
			explicitWaitClickable("sidemenu_logout_CSS");

			// click on the logout option from the side menu
			click("sidemenu_logout_CSS");

			// wait for the element
			explicitWaitClickable("signinbtn_BTNTEXT");

		} catch (Throwable t) {
			verificationFailed();
		}

	}
}