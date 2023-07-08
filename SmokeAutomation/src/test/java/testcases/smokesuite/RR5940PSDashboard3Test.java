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

		if (!(TestUtil.isTestRunnable("rR5940PSDashboard3Test", excel))) {

			throw new SkipException(
					"Skipping the test " + "rR5940PSDashboard3Test".toUpperCase() + "as the Run mode is NO");
		}

		if (!data.get("runmode").equals("Y")) {

			throw new SkipException("Skipping the test case as the Run Mode for data set is NO");
		}

		// refresh the page
		driver.navigate().refresh();
		Thread.sleep(5000);
		driver.navigate().refresh();

		// VERIFY THE COUNTS AND DETAILS OF THE ENVIRONMENTAL REPORT CARDS OF THE
		// PORTFOLIO SUMMARY DASHBOARD

		System.out.println(
				"******************** VERIFY THE COUNTS AND DETAILS OF THE ENVIRONMENTAL REPORT CARDS OF THE PORTFOLIO SUMMARY DASHBOARD ********************");
		test.log(LogStatus.INFO,
				"******************** VERIFY THE COUNTS AND DETAILS OF THE ENVIRONMENTAL REPORT CARDS OF THE PORTFOLIO SUMMARY DASHBOARD ********************");
		Reporter.log(
				"******************** VERIFY THE COUNTS AND DETAILS OF THE ENVIRONMENTAL REPORT CARDS OF THE PORTFOLIO SUMMARY DASHBOARD ********************");
		log.info(
				"******************** VERIFY THE COUNTS AND DETAILS OF THE ENVIRONMENTAL REPORT CARDS OF THE PORTFOLIO SUMMARY DASHBOARD ********************");

		// LOGIN WITH ADMIN USER

		System.out.println("******************** LOGIN WITH ADMIN USER ********************");
		test.log(LogStatus.INFO, "******************** LOGIN WITH ADMIN USER ********************");
		Reporter.log("******************** LOGIN WITH ADMIN USER ********************");
		log.info("******************** LOGIN WITH ADMIN USER ********************");

		try {
			// wait for the element
			explicitWaitClickable("signinbtn_BTNTEXT");

			// Enter the username
			type("usernametxt_CSS", data.get("username_1"));
			ngDriver.waitForAngularRequestsToFinish();
			System.out.println("Entered the username.");

			// Enter the password
			type("passwordtxt_CSS", data.get("password_1"));
			ngDriver.waitForAngularRequestsToFinish();
			System.out.println("Entered the password.");

			// Clicking on the "Sign In" button
			click("signinbtn_BTNTEXT");
			ngDriver.waitForAngularRequestsToFinish();
			System.out.println("Clicked on the sign in button.");

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

		System.out.println(
				"******************** VERIFY THE CERTIFICATE OF APPROVAL REPORT CONFIGURATION ********************");
		test.log(LogStatus.INFO,
				"******************** VERIFY THE CERTIFICATE OF APPROVAL REPORT CONFIGURATION ********************");
		Reporter.log(
				"******************** VERIFY THE CERTIFICATE OF APPROVAL REPORT CONFIGURATION ********************");
		log.info("******************** VERIFY THE CERTIFICATE OF APPROVAL REPORT CONFIGURATION ********************");

		try {
			// wait for the element
			explicitWaitClickable("questionnaire_settingicon_CSS");

			// click on the settings icon from the top of the screen
			click("questionnaire_settingicon_CSS");
			System.out.println("Clicked on the settings icon.");
			ngDriver.waitForAngularRequestsToFinish();

			// wait for the element
			explicitWaitClickable("questionnaire_administrationoption_XPATH");

			// click on the administration option from the side menu
			click("questionnaire_administrationoption_XPATH");
			System.out.println("Clicked on the administration option from the side menu.");
			ngDriver.waitForAngularRequestsToFinish();

			// click on the environmental tab
			click("questionnaire_environmentaltab_XPATH");
			ngDriver.waitForAngularRequestsToFinish();
			System.out.println("Clicked on the environmental tab.");

			// click on the environmental reports option
			click("questionnaire_environmentalreportsoption_XPATH");
			ngDriver.waitForAngularRequestsToFinish();
			System.out.println("Clicked on the environmental reports option.");

			// scroll down to the screen
			WebElement dropdown = driver.findElement(
					By.xpath(OR.getProperty("environmental_reportlist_certificationofapproval_dropdown_XPATH")));
			JavascriptExecutor js = (JavascriptExecutor) driver;
			js.executeScript("arguments[0].scrollIntoView(true);", dropdown);
			js.executeScript("window.scrollBy(0,-400)");

			// click on the drop down of the Certificate of Approval report
			click("environmental_reportlist_certificationofapproval_dropdown_XPATH");
			ngDriver.waitForAngularRequestsToFinish();
			System.out.println("Clicked on the drop down of the Certificate of Approval report.");

			// click on the other options option
			click("environmental_reportlist_certificationofapproval_dropdown_otheroption_XPATH");
			ngDriver.waitForAngularRequestsToFinish();
			System.out.println("Clicked on the other options option.");

			// enter the data in the report frequency field
			clear("environmental_reportlist_environmentalactionreporttext_reportfrequencytxt_CSS");
			type("environmental_reportlist_environmentalactionreporttext_reportfrequencytxt_CSS", "5");
			ngDriver.waitForAngularRequestsToFinish();
			System.out.println("Entered the data in the report frequency field.");

			// select the year option from the report period drop down
			select("environmental_reportlist_environmentalactionreporttext_reportPerioddd_CSS", "Year");
			ngDriver.waitForAngularRequestsToFinish();
			System.out.println("Selected the year option from the report period drop down.");

			// click on the save button
			click("environmental_reportlist_environmentalactionreporttext_savebtn_XPATH");
			ngDriver.waitForAngularRequestsToFinish();
			System.out.println("Clicked on the save button.");

			// wait for the element
			explicitWaitClickable("closetoastmsg_CSS");

			// click on the toaster close button
			click("closetoastmsg_CSS");
			ngDriver.waitForAngularRequestsToFinish();
			System.out.println("Clicked on the toaster close button.");

		} catch (Throwable t) {
			verificationFailed();
		}

		// click on the home icon from the top of the screen
		click("questionnaire_homeburgermenubtn_CSS");
		System.out.println("Clicked on the home icon from the top of the screen.");
		ngDriver.waitForAngularRequestsToFinish();

		// synchronization
		explicitWait("propertylist_title_XPATH");

		// verify the property list
		switchVerification("propertylist_title_XPATH", "Property List", "The property list is not displayed.");

		// RUN THE BATCH PROCESS FOR THE ENVIRONMENTAL REPORTS - SUPER ADMIN USER

		System.out.println(
				"******************** RUN THE BATCH PROCESS FOR THE ENVIRONMENTAL REPORTS - SUPER ADMIN USER ********************");
		test.log(LogStatus.INFO,
				"******************** RUN THE BATCH PROCESS FOR THE ENVIRONMENTAL REPORTS - SUPER ADMIN USER ********************");
		Reporter.log(
				"******************** RUN THE BATCH PROCESS FOR THE ENVIRONMENTAL REPORTS - SUPER ADMIN USER ********************");
		log.info(
				"******************** RUN THE BATCH PROCESS FOR THE ENVIRONMENTAL REPORTS - SUPER ADMIN USER ********************");

		try {
			// wait for the 5 seconds
			Thread.sleep(5000);

			// click on the settings icon from the top of the screen
			click("questionnaire_settingicon_CSS");
			System.out.println("Clicked on the settings icon.");
			ngDriver.waitForAngularRequestsToFinish();

			// wait for the 5 seconds
			Thread.sleep(5000);

			// click on the administration option from the side menu
			click("questionnaire_administrationoption_XPATH");
			System.out.println("Clicked on the administration option from the side menu.");
			ngDriver.waitForAngularRequestsToFinish();

			// click on the system tab
			click("questionnaire_systemtab_XPATH");
			ngDriver.waitForAngularRequestsToFinish();
			System.out.println("Clicked on the system tab.");

			// click on the batch process option
			click("questionnaire_batchprocessoption_XPATH");
			ngDriver.waitForAngularRequestsToFinish();
			System.out.println("Clicked on the batch process option.");

			// enter batch process name in the search field
			clear("ssc_company2_securitysettings_filtertxt_CSS");
			ngDriver.waitForAngularRequestsToFinish();
			System.out.println("Cleared the search field.");
			type("ssc_company2_securitysettings_filtertxt_CSS", data.get("batch_process"));
			ngDriver.waitForAngularRequestsToFinish();
			System.out.println("Entered batch process name in the search field.");

			// click on the play button of searched batch process
			click("batchprocess_environmentalreport_playbtn_XPATH");
			ngDriver.waitForAngularRequestsToFinish();
			System.out.println("Clicked on the play button of searched batch process.");

			// click on the run button
			click("batchprocess_environmentalreport_runbtn_XPATH");
			ngDriver.waitForAngularRequestsToFinish();
			System.out.println("Clicked on the run button.");

			// wait for the element
			explicitWaitClickable("closetoastmsg_CSS");

			// click on the toaster close button
			click("closetoastmsg_CSS");
			ngDriver.waitForAngularRequestsToFinish();
			System.out.println("Clicked on the toaster close button.");

		} catch (Throwable t) {
			verificationFailed();
		}

		// click on the home icon from the top of the screen
		click("questionnaire_homeburgermenubtn_CSS");
		System.out.println("Clicked on the home icon from the top of the screen.");
		ngDriver.waitForAngularRequestsToFinish();

		// synchronization
		explicitWait("propertylist_title_XPATH");

		// verify the property list
		switchVerification("propertylist_title_XPATH", "Property List", "The property list is not displayed.");

		// VERIFY COUNT OF THE CERTIFICATE OF APPROVAL CARD OF THE PORTFOLIO SUMMARY
		// DASHBOARD SCREEN BEFORE ADDED THE ENVIRONMENTAL REPORTS

		System.out.println(
				"******************** VERIFY COUNT OF THE CERTIFICATE OF APPROVAL CARD OF THE PORTFOLIO SUMMARY DASHBOARD SCREEN BEFORE ADDED THE ENVIRONMENTAL REPORTS ********************");
		test.log(LogStatus.INFO,
				"******************** VERIFY COUNT OF THE CERTIFICATE OF APPROVAL CARD OF THE PORTFOLIO SUMMARY DASHBOARD SCREEN BEFORE ADDED THE ENVIRONMENTAL REPORTS ********************");
		Reporter.log(
				"******************** VERIFY COUNT OF THE CERTIFICATE OF APPROVAL CARD OF THE PORTFOLIO SUMMARY DASHBOARD SCREEN BEFORE ADDED THE ENVIRONMENTAL REPORTS ********************");
		log.info(
				"******************** VERIFY COUNT OF THE CERTIFICATE OF APPROVAL CARD OF THE PORTFOLIO SUMMARY DASHBOARD SCREEN BEFORE ADDED THE ENVIRONMENTAL REPORTS ********************");

		try {

			// wait for the element
			Thread.sleep(5000);

			// click on the side menu button
			click("menubtn_CSS");
			ngDriver.waitForAngularRequestsToFinish();
			System.out.println("Clicked on the side menu button.");

			// wait for the element
			Thread.sleep(5000);

			// click on the portfolio summary option
			click("sidemenu_portfoliosummary_XPATH");
			ngDriver.waitForAngularRequestsToFinish();
			System.out.println("Clicked on the portfolio summary option.");

			// verify property count
			switchVerification("portfoliosummary_toppropertycount_XPATH", "4",
					"The property count is not displayed correctly.");

			// scroll down the screen
			JavascriptExecutor js = (JavascriptExecutor) driver;
			WebElement label1 = driver
					.findElement(By.xpath(OR.getProperty("portfoliosummary_certificateofapprovallabel_XPATH")));
			js.executeScript("arguments[0].scrollIntoView(true);", label1);

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
		System.out.println("Clicked on the home icon from the top of the screen.");
		ngDriver.waitForAngularRequestsToFinish();

		// synchronization
		explicitWait("propertylist_title_XPATH");

		// verify the property list
		switchVerification("propertylist_title_XPATH", "Property List", "The property list is not displayed.");

		// CREATE ENVIRONMENTAL REPORT WITH THE CERTIFICATE OF APPROVAL

		System.out.println(
				"******************** CREATE ENVIRONMENTAL REPORT WITH THE CERTIFICATE OF APPROVAL ********************");
		test.log(LogStatus.INFO,
				"******************** CREATE ENVIRONMENTAL REPORT WITH THE CERTIFICATE OF APPROVAL ********************");
		Reporter.log(
				"******************** CREATE ENVIRONMENTAL REPORT WITH THE CERTIFICATE OF APPROVAL ********************");
		log.info(
				"******************** CREATE ENVIRONMENTAL REPORT WITH THE CERTIFICATE OF APPROVAL ********************");

		try {

			// enter the property name in the search field
			type("envreports_propertylist_filtertxt_CSS", data.get("property_4"));
			ngDriver.waitForAngularRequestsToFinish();
			System.out.println("Entered the property name in the search field.");

			// click on the environmental icon
			click("environmentalicon_CSS");
			System.out.println("Clicked on the environmental icon.");
			ngDriver.waitForAngularRequestsToFinish();

			// wait for the element
			explicitWaitClickable("ssc_leftsidemenubtn_CSS");

			// click on the side menu
			click("ssc_leftsidemenubtn_CSS");
			ngDriver.waitForAngularRequestsToFinish();
			System.out.println("Clicked on the side menu.");

			// wait for the element
			explicitWaitClickable("envreportoption_XPATH");

			// click on the environmental report
			click("envreportoption_XPATH");
			ngDriver.waitForAngularRequestsToFinish();
			System.out.println("Clicked on the environmental report.");

			// click on the add button
			click("envreportaddbtn_CSS");
			ngDriver.waitForAngularRequestsToFinish();
			System.out.println("Clicked on the add button.");

			// select the checklist from the type dropdown
			select("envreporttypedd_CSS", data.get("type"));
			ngDriver.waitForAngularRequestsToFinish();
			System.out.println("The option is selected from the Type dropdown.");

			// enter the title
			type("envreporttitletxt_CSS", data.get("title"));
			ngDriver.waitForAngularRequestsToFinish();
			System.out.println("The data entered in the Title field.");

			// scroll down the screen
			JavascriptExecutor js = (JavascriptExecutor) driver;
			js.executeScript("window.scrollBy(0,400)");

			// click on the date field
			click("envreportdatetxt_CSS");
			ngDriver.waitForAngularRequestsToFinish();
			System.out.println("Clicked on the date field.");

			// click on the today button
			click("envreporttodaydate_BTNTEXT");
			ngDriver.waitForAngularRequestsToFinish();
			System.out.println("Today's date selected in the Date Field.");

			// click on the save report button
			click("envreportsavebtn_CSS");
			ngDriver.waitForAngularRequestsToFinish();
			System.out.println("Clicked on the save Button.");

			// wait for the element
			explicitWaitClickable("closetoastmsg_CSS");

			// click on the toaster close button
			click("closetoastmsg_CSS");
			ngDriver.waitForAngularRequestsToFinish();
			System.out.println("Clicked on the toaster close button.");

			// wait for the element
			Thread.sleep(5000);

			// enter the newly created environmental report in the search field
			clear("task_listofchecklist_filterfield_CSS");
			type("task_listofchecklist_filterfield_CSS", data.get("title"));
			ngDriver.waitForAngularRequestsToFinish();
			System.out.println("Entered the newly created environmental report in the search field.");

			// verify the newly created environmental report is displayed or not
			switchVerification("environmental_searchedreport_psd1_XPATH", "Test Environmental Report PSD 1",
					"The Test Environmental Report PSD 1 is not displayed.");

		} catch (Throwable t) {
			verificationFailed();
		}

		// click on the home icon from the top of the screen
		click("questionnaire_homeburgermenubtn_hide_CSS");
		System.out.println("Clicked on the home icon from the top of the screen.");
		ngDriver.waitForAngularRequestsToFinish();

		// synchronization
		explicitWait("propertylist_title_XPATH");

		// verify the property list
		switchVerification("propertylist_title_XPATH", "Property List", "The property list is not displayed.");

		// VERIFY COUNT AND DETAILS OF THE CERTIFICATE OF APPROVAL CARD OF THE PORTFOLIO
		// SUMMARY DASHBOARD SCREEN AFTER ADDED THE ENVIRONMENTAL REPORTS

		System.out.println(
				"******************** VERIFY COUNT AND DETAILS OF THE CERTIFICATE OF APPROVAL CARD OF THE PORTFOLIO SUMMARY DASHBOARD SCREEN AFTER ADDED THE ENVIRONMENTAL REPORTS ********************");
		test.log(LogStatus.INFO,
				"******************** VERIFY COUNT AND DETAILS OF THE CERTIFICATE OF APPROVAL CARD OF THE PORTFOLIO SUMMARY DASHBOARD SCREEN AFTER ADDED THE ENVIRONMENTAL REPORTS ********************");
		Reporter.log(
				"******************** VERIFY COUNT AND DETAILS OF THE CERTIFICATE OF APPROVAL CARD OF THE PORTFOLIO SUMMARY DASHBOARD SCREEN AFTER ADDED THE ENVIRONMENTAL REPORTS ********************");
		log.info(
				"******************** VERIFY COUNT AND DETAILS OF THE CERTIFICATE OF APPROVAL CARD OF THE PORTFOLIO SUMMARY DASHBOARD SCREEN AFTER ADDED THE ENVIRONMENTAL REPORTS ********************");

		try {

			// wait for the element
			Thread.sleep(5000);

			// click on the side menu button
			click("menubtn_CSS");
			ngDriver.waitForAngularRequestsToFinish();
			System.out.println("Clicked on the side menu button.");

			// wait for the element
			Thread.sleep(5000);

			// click on the portfolio summary option
			click("sidemenu_portfoliosummary_XPATH");
			ngDriver.waitForAngularRequestsToFinish();
			System.out.println("Clicked on the portfolio summary option.");

			// verify property count
			switchVerification("portfoliosummary_toppropertycount_XPATH", "4",
					"The property count is not displayed correctly.");

			// scroll down the screen
			JavascriptExecutor js = (JavascriptExecutor) driver;
			WebElement label1 = driver
					.findElement(By.xpath(OR.getProperty("portfoliosummary_certificateofapprovallabel_XPATH")));
			js.executeScript("arguments[0].scrollIntoView(true);", label1);

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
			ngDriver.waitForAngularRequestsToFinish();
			System.out.println("Clicked on the percentage of the Certificate of Approval.");

			// verify the title of the environmental report
			switchVerification("portfoliosummary_certificateofapproval_listtitle_XPATH", "Certificate of Approval",
					"The Certificate of Approval is not displayed.");

			// enter the property name in the search field
			clear("portfoliosummary_certificateofapproval_searchtxt_XPATH");
			type("portfoliosummary_certificateofapproval_searchtxt_XPATH", data.get("property_4"));
			ngDriver.waitForAngularRequestsToFinish();
			System.out.println("Entered the property name in the search field.");

			// verify the report date
			try {
				LocalDate currentDate1 = LocalDate.now();
				String finalCurrentDate1 = currentDate1.toString();
				String reportDate1 = "//td[text()='" + data.get("property_4") + "']//following-sibling::td[1]";
				String finalReportDate1 = (driver.findElement(By.xpath(reportDate1)).getText()).trim();

				if (finalCurrentDate1.equals(finalReportDate1)) {

					System.out.println("The reported date is displayed correctly.");
					test.log(LogStatus.INFO, "The reported date is displayed correctly.");
					Reporter.log("The reported date is displayed correctly.");
					log.info("The reported date is displayed correctly.");

				} else {
					verificationFailed();

					System.out.println("The reported date is not displayed correctly.");
					test.log(LogStatus.INFO, "The reported date is not displayed correctly.");
					Reporter.log("The reported date is not displayed correctly.");
					log.info("The reported date is not displayed correctly.");

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

					System.out.println("The next assessment date is displayed correctly.");
					test.log(LogStatus.INFO, "The next assessment date is displayed correctly.");
					Reporter.log("The next assessment date is displayed correctly.");
					log.info("The next assessment date is displayed correctly.");

				} else {
					verificationFailed();

					System.out.println("The next assessment date is not displayed correctly.");
					test.log(LogStatus.INFO, "The next assessment date is not displayed correctly.");
					Reporter.log("The next assessment date is not displayed correctly.");
					log.info("The next assessment date is not displayed correctly.");

				}

			} catch (Throwable t) {
				verificationFailed();
			}

			// click on the respective searched record
			click("portfoliosummary_certificateofapproval_seachedproperty_XPATH");
			ngDriver.waitForAngularRequestsToFinish();
			System.out.println("Clicked on the respective searched record.");

			// enter the task name in the search field
			type("sidemenu_reports_searchtxt_XPATH", data.get("title"));
			ngDriver.waitForAngularRequestsToFinish();
			System.out.println("Entered the task name in the search field.");

			// click on the respective searched environmental report
			click("portfoliosummary_certificateofapproval_seachedenvreport_XPATH");
			ngDriver.waitForAngularRequestsToFinish();
			System.out.println("Clicked on the respective searched environmental report.");

			// verify the reported date
			try {
				LocalDate currentDate11 = LocalDate.now();
				String finalCurrentDate11 = currentDate11.toString();
				String actualReportedDate11 = (driver
						.findElement(By.xpath(OR.getProperty("enviromentalreport_reporteddate_XPATH")))
						.getAttribute("value")).trim();

				if (finalCurrentDate11.equals(actualReportedDate11)) {

					System.out.println("The reported date is displayed correctly.");
					test.log(LogStatus.INFO, "The reported date is displayed correctly.");
					Reporter.log("The reported date is displayed correctly.");
					log.info("The reported date is displayed correctly.");

				} else {
					verificationFailed();

					System.out.println("The reported date is not displayed correctly.");
					test.log(LogStatus.INFO, "The reported date is not displayed correctly.");
					Reporter.log("The reported date is not displayed correctly.");
					log.info("The reported date is not displayed correctly.");

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

					System.out.println("The next assessment date is displayed correctly.");
					test.log(LogStatus.INFO, "The next assessment date is displayed correctly.");
					Reporter.log("The next assessment date is displayed correctly.");
					log.info("The next assessment date is displayed correctly.");

				} else {
					verificationFailed();

					System.out.println("The next assessment date is not displayed correctly.");
					test.log(LogStatus.INFO, "The next assessment date is not displayed correctly.");
					Reporter.log("The next assessment date is not displayed correctly.");
					log.info("The next assessment date is not displayed correctly.");

				}

			} catch (Throwable t) {
				verificationFailed();
			}

		} catch (Throwable t) {
			verificationFailed();
		}

		// click on the home icon from the top of the screen
		click("questionnaire_homeburgermenubtn_hide_CSS");
		System.out.println("Clicked on the home icon from the top of the screen.");
		ngDriver.waitForAngularRequestsToFinish();

		// synchronization
		explicitWait("propertylist_title_XPATH");

		// verify the property list
		switchVerification("propertylist_title_XPATH", "Property List", "The property list is not displayed.");

		// UPDATE THE CERTIFICATE OF APPROVAL REPORT CONFIGURATION

		System.out.println(
				"******************** UPDATE THE CERTIFICATE OF APPROVAL REPORT CONFIGURATION ********************");
		test.log(LogStatus.INFO,
				"******************** UPDATE THE CERTIFICATE OF APPROVAL REPORT CONFIGURATION ********************");
		Reporter.log(
				"******************** UPDATE THE CERTIFICATE OF APPROVAL REPORT CONFIGURATION ********************");
		log.info("******************** UPDATE THE CERTIFICATE OF APPROVAL REPORT CONFIGURATION ********************");

		try {
			// wait for the element
			explicitWaitClickable("questionnaire_settingicon_CSS");

			// click on the settings icon from the top of the screen
			click("questionnaire_settingicon_CSS");
			System.out.println("Clicked on the settings icon.");
			ngDriver.waitForAngularRequestsToFinish();

			// wait for the element
			explicitWaitClickable("questionnaire_administrationoption_XPATH");

			// click on the administration option from the side menu
			click("questionnaire_administrationoption_XPATH");
			System.out.println("Clicked on the administration option from the side menu.");
			ngDriver.waitForAngularRequestsToFinish();

			// click on the environmental tab
			click("questionnaire_environmentaltab_XPATH");
			ngDriver.waitForAngularRequestsToFinish();
			System.out.println("Clicked on the environmental tab.");

			// click on the environmental reports option
			click("questionnaire_environmentalreportsoption_XPATH");
			ngDriver.waitForAngularRequestsToFinish();
			System.out.println("Clicked on the environmental reports option.");

			// scroll down to the screen
			WebElement dropdown = driver.findElement(
					By.xpath(OR.getProperty("environmental_reportlist_certificationofapproval_dropdown_XPATH")));
			JavascriptExecutor js = (JavascriptExecutor) driver;
			js.executeScript("arguments[0].scrollIntoView(true);", dropdown);
			js.executeScript("window.scrollBy(0,-400)");

			// click on the drop down of the Certificate of Approval report
			click("environmental_reportlist_certificationofapproval_dropdown_XPATH");
			ngDriver.waitForAngularRequestsToFinish();
			System.out.println("Clicked on the drop down of the Certificate of Approval report.");

			// click on the other options option
			click("environmental_reportlist_certificationofapproval_dropdown_otheroption_XPATH");
			ngDriver.waitForAngularRequestsToFinish();
			System.out.println("Clicked on the other options option.");

			// enter the data in the report frequency field
			clear("environmental_reportlist_environmentalactionreporttext_reportfrequencytxt_CSS");
			type("environmental_reportlist_environmentalactionreporttext_reportfrequencytxt_CSS", "3");
			ngDriver.waitForAngularRequestsToFinish();
			System.out.println("Entered the data in the report frequency field.");

			// select the year option from the report period drop down
			select("environmental_reportlist_environmentalactionreporttext_reportPerioddd_CSS", "Year");
			ngDriver.waitForAngularRequestsToFinish();
			System.out.println("Selected the year option from the report period drop down.");

			// click on the save button
			click("environmental_reportlist_environmentalactionreporttext_savebtn_XPATH");
			ngDriver.waitForAngularRequestsToFinish();
			System.out.println("Clicked on the save button.");

		} catch (Throwable t) {
			verificationFailed();
		}

		// click on the home icon from the top of the screen
		click("questionnaire_homeburgermenubtn_CSS");
		System.out.println("Clicked on the home icon from the top of the screen.");
		ngDriver.waitForAngularRequestsToFinish();

		// synchronization
		explicitWait("propertylist_title_XPATH");

		// verify the property list
		switchVerification("propertylist_title_XPATH", "Property List", "The property list is not displayed.");

		// RUN THE BATCH PROCESS FOR THE ENVIRONMENTAL REPORTS - SUPER ADMIN USER

		System.out.println(
				"******************** RUN THE BATCH PROCESS FOR THE ENVIRONMENTAL REPORTS - SUPER ADMIN USER ********************");
		test.log(LogStatus.INFO,
				"******************** RUN THE BATCH PROCESS FOR THE ENVIRONMENTAL REPORTS - SUPER ADMIN USER ********************");
		Reporter.log(
				"******************** RUN THE BATCH PROCESS FOR THE ENVIRONMENTAL REPORTS - SUPER ADMIN USER ********************");
		log.info(
				"******************** RUN THE BATCH PROCESS FOR THE ENVIRONMENTAL REPORTS - SUPER ADMIN USER ********************");

		try {
			// wait for the 5 seconds
			Thread.sleep(5000);

			// click on the settings icon from the top of the screen
			click("questionnaire_settingicon_CSS");
			System.out.println("Clicked on the settings icon.");
			ngDriver.waitForAngularRequestsToFinish();

			// wait for the 5 seconds
			Thread.sleep(5000);

			// click on the administration option from the side menu
			click("questionnaire_administrationoption_XPATH");
			System.out.println("Clicked on the administration option from the side menu.");
			ngDriver.waitForAngularRequestsToFinish();

			// click on the system tab
			click("questionnaire_systemtab_XPATH");
			ngDriver.waitForAngularRequestsToFinish();
			System.out.println("Clicked on the system tab.");

			// click on the batch process option
			click("questionnaire_batchprocessoption_XPATH");
			ngDriver.waitForAngularRequestsToFinish();
			System.out.println("Clicked on the batch process option.");

			// enter batch process name in the search field
			clear("ssc_company2_securitysettings_filtertxt_CSS");
			type("ssc_company2_securitysettings_filtertxt_CSS", data.get("batch_process"));
			ngDriver.waitForAngularRequestsToFinish();
			System.out.println("Entered batch process name in the search field.");

			// click on the play button of searched batch process
			click("batchprocess_environmentalreport_playbtn_XPATH");
			ngDriver.waitForAngularRequestsToFinish();
			System.out.println("Clicked on the play button of searched batch process.");

			// click on the run button
			click("batchprocess_environmentalreport_runbtn_XPATH");
			ngDriver.waitForAngularRequestsToFinish();
			System.out.println("Clicked on the run button.");

			// wait for the element
			explicitWaitClickable("closetoastmsg_CSS");

			// click on the toaster close button
			click("closetoastmsg_CSS");
			ngDriver.waitForAngularRequestsToFinish();
			System.out.println("Clicked on the toaster close button.");

		} catch (Throwable t) {
			verificationFailed();
		}

		// click on the home icon from the top of the screen
		click("questionnaire_homeburgermenubtn_CSS");
		System.out.println("Clicked on the home icon from the top of the screen.");
		ngDriver.waitForAngularRequestsToFinish();

		// synchronization
		explicitWait("propertylist_title_XPATH");

		// verify the property list
		switchVerification("propertylist_title_XPATH", "Property List", "The property list is not displayed.");

		// VERIFY COUNT AND DETAILS OF THE CERTIFICATE OF APPROVAL CARD OF THE PORTFOLIO
		// SUMMARY DASHBOARD SCREEN AFTER UPDATED THE CERTIFICATE OF APPROVAL
		// CONFIGURATION

		System.out.println(
				"******************** VERIFY COUNT AND DETAILS OF THE CERTIFICATE OF APPROVAL CARD OF THE PORTFOLIO SUMMARY DASHBOARD SCREEN AFTER UPDATED THE CERTIFICATE OF APPROVAL CONFIGURATION ********************");
		test.log(LogStatus.INFO,
				"******************** VERIFY COUNT AND DETAILS OF THE CERTIFICATE OF APPROVAL CARD OF THE PORTFOLIO SUMMARY DASHBOARD SCREEN AFTER UPDATED THE CERTIFICATE OF APPROVAL CONFIGURATION ********************");
		Reporter.log(
				"******************** VERIFY COUNT AND DETAILS OF THE CERTIFICATE OF APPROVAL CARD OF THE PORTFOLIO SUMMARY DASHBOARD SCREEN AFTER UPDATED THE CERTIFICATE OF APPROVAL CONFIGURATION ********************");
		log.info(
				"******************** VERIFY COUNT AND DETAILS OF THE CERTIFICATE OF APPROVAL CARD OF THE PORTFOLIO SUMMARY DASHBOARD SCREEN AFTER UPDATED THE CERTIFICATE OF APPROVAL CONFIGURATION ********************");

		try {

			// wait for the element
			Thread.sleep(5000);

			// click on the side menu button
			click("menubtn_CSS");
			ngDriver.waitForAngularRequestsToFinish();
			System.out.println("Clicked on the side menu button.");

			// wait for the element
			Thread.sleep(5000);

			// click on the portfolio summary option
			click("sidemenu_portfoliosummary_XPATH");
			ngDriver.waitForAngularRequestsToFinish();
			System.out.println("Clicked on the portfolio summary option.");

			// verify property count
			switchVerification("portfoliosummary_toppropertycount_XPATH", "4",
					"The property count is not displayed correctly.");

			// scroll down the screen
			JavascriptExecutor js = (JavascriptExecutor) driver;
			WebElement label1 = driver
					.findElement(By.xpath(OR.getProperty("portfoliosummary_certificateofapprovallabel_XPATH")));
			js.executeScript("arguments[0].scrollIntoView(true);", label1);

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
			ngDriver.waitForAngularRequestsToFinish();
			System.out.println("Clicked on the percentage of the Certificate of Approval.");

			// verify the title of the environmental report
			switchVerification("portfoliosummary_certificateofapproval_listtitle_XPATH", "Certificate of Approval",
					"The Certificate of Approval is not displayed.");

			// enter the property name in the search field
			type("portfoliosummary_certificateofapproval_searchtxt_XPATH", data.get("property_4"));
			ngDriver.waitForAngularRequestsToFinish();
			System.out.println("Entered the property name in the search field.");

			// verify the report date
			try {
				LocalDate currentDate1 = LocalDate.now();
				String finalCurrentDate1 = currentDate1.toString();
				String reportDate1 = "//td[text()='" + data.get("property_4") + "']//following-sibling::td[1]";
				String finalReportDate1 = (driver.findElement(By.xpath(reportDate1)).getText()).trim();

				if (finalCurrentDate1.equals(finalReportDate1)) {

					System.out.println("The reported date is displayed correctly.");
					test.log(LogStatus.INFO, "The reported date is displayed correctly.");
					Reporter.log("The reported date is displayed correctly.");
					log.info("The reported date is displayed correctly.");

				} else {
					verificationFailed();

					System.out.println("The reported date is not displayed correctly.");
					test.log(LogStatus.INFO, "The reported date is not displayed correctly.");
					Reporter.log("The reported date is not displayed correctly.");
					log.info("The reported date is not displayed correctly.");

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

					System.out.println("The next assessment date is displayed correctly.");
					test.log(LogStatus.INFO, "The next assessment date is displayed correctly.");
					Reporter.log("The next assessment date is displayed correctly.");
					log.info("The next assessment date is displayed correctly.");

				} else {
					verificationFailed();

					System.out.println("The next assessment date is not displayed correctly.");
					test.log(LogStatus.INFO, "The next assessment date is not displayed correctly.");
					Reporter.log("The next assessment date is not displayed correctly.");
					log.info("The next assessment date is not displayed correctly.");

				}

			} catch (Throwable t) {
				verificationFailed();
			}

			// click on the respective searched record
			click("portfoliosummary_certificateofapproval_seachedproperty_XPATH");
			ngDriver.waitForAngularRequestsToFinish();
			System.out.println("Clicked on the respective searched record.");

			// enter the task name in the search field
			type("sidemenu_reports_searchtxt_XPATH", data.get("title"));
			ngDriver.waitForAngularRequestsToFinish();
			System.out.println("Entered the task name in the search field.");

			// click on the respective searched environmental report
			click("portfoliosummary_certificateofapproval_seachedenvreport_XPATH");
			ngDriver.waitForAngularRequestsToFinish();
			System.out.println("Clicked on the respective searched environmental report.");

			// verify the reported date
			try {
				LocalDate currentDate11 = LocalDate.now();
				String finalCurrentDate11 = currentDate11.toString();
				String actualReportedDate11 = (driver
						.findElement(By.xpath(OR.getProperty("enviromentalreport_reporteddate_XPATH")))
						.getAttribute("value")).trim();

				if (finalCurrentDate11.equals(actualReportedDate11)) {

					System.out.println("The reported date is displayed correctly.");
					test.log(LogStatus.INFO, "The reported date is displayed correctly.");
					Reporter.log("The reported date is displayed correctly.");
					log.info("The reported date is displayed correctly.");

				} else {
					verificationFailed();

					System.out.println("The reported date is not displayed correctly.");
					test.log(LogStatus.INFO, "The reported date is not displayed correctly.");
					Reporter.log("The reported date is not displayed correctly.");
					log.info("The reported date is not displayed correctly.");

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

					System.out.println("The next assessment date is displayed correctly.");
					test.log(LogStatus.INFO, "The next assessment date is displayed correctly.");
					Reporter.log("The next assessment date is displayed correctly.");
					log.info("The next assessment date is displayed correctly.");

				} else {
					verificationFailed();

					System.out.println("The next assessment date is not displayed correctly.");
					test.log(LogStatus.INFO, "The next assessment date is not displayed correctly.");
					Reporter.log("The next assessment date is not displayed correctly.");
					log.info("The next assessment date is not displayed correctly.");

				}

			} catch (Throwable t) {
				verificationFailed();
			}

		} catch (Throwable t) {
			verificationFailed();
		}

		// click on the home icon from the top of the screen
		click("questionnaire_homeburgermenubtn_hide_CSS");
		System.out.println("Clicked on the home icon from the top of the screen.");
		ngDriver.waitForAngularRequestsToFinish();

		// synchronization
		explicitWait("propertylist_title_XPATH");

		// verify the property list
		switchVerification("propertylist_title_XPATH", "Property List", "The property list is not displayed.");

		// UPDATE THE REPORT DATE TO THE PAST DATE OF THE ENVIRONMENTAL REPORT

		System.out.println(
				"******************** UPDATE THE REPORT DATE TO THE PAST DATE OF THE ENVIRONMENTAL REPORT ********************");
		test.log(LogStatus.INFO,
				"******************** UPDATE THE REPORT DATE TO THE PAST DATE OF THE ENVIRONMENTAL REPORT ********************");
		Reporter.log(
				"******************** UPDATE THE REPORT DATE TO THE PAST DATE OF THE ENVIRONMENTAL REPORT ********************");
		log.info(
				"******************** UPDATE THE REPORT DATE TO THE PAST DATE OF THE ENVIRONMENTAL REPORT ********************");

		try {

			// enter the property name in the search field
			type("envreports_propertylist_filtertxt_CSS", data.get("property_4"));
			ngDriver.waitForAngularRequestsToFinish();
			System.out.println("Entered the property name in the search field.");

			// click on the environmental icon
			click("environmentalicon_CSS");
			System.out.println("Clicked on the environmental icon.");
			ngDriver.waitForAngularRequestsToFinish();

			// wait for the element
			explicitWaitClickable("ssc_leftsidemenubtn_CSS");

			// click on the side menu
			click("ssc_leftsidemenubtn_CSS");
			ngDriver.waitForAngularRequestsToFinish();
			System.out.println("Clicked on the side menu.");

			// wait for the element
			explicitWaitClickable("envreportoption_XPATH");

			// click on the environmental report
			click("envreportoption_XPATH");
			ngDriver.waitForAngularRequestsToFinish();
			System.out.println("Clicked on the environmental report.");

			// enter the newly created environmental report in the search field
			clear("task_listofchecklist_filterfield_CSS");
			type("task_listofchecklist_filterfield_CSS", data.get("title"));
			ngDriver.waitForAngularRequestsToFinish();
			System.out.println("Entered the newly created environmental report in the search field.");

			// verify the newly created environmental report is displayed or not
			switchVerification("environmental_searchedreport_psd1_XPATH", "Test Environmental Report PSD 1",
					"The Test Environmental Report PSD 1 is not displayed.");

			// click on newly searched environmental report
			click("environmental_searchedreport_psd1_XPATH");
			ngDriver.waitForAngularRequestsToFinish();
			System.out.println("Clicked on newly searched environmental report.");

			// update the reported date to the past date
			LocalDate pasttDate1 = LocalDate.now().minusMonths(6);
			String finalPastDate1 = pasttDate1.toString();
			clear("envreportdatetxt_CSS");
			type("envreportdatetxt_CSS", finalPastDate1);
			ngDriver.waitForAngularRequestsToFinish();
			System.out.println("envreportdatetxt_CSS");

			// click on the update button
			click("envreportupdatebtn_CSS");
			ngDriver.waitForAngularRequestsToFinish();
			System.out.println("Clicked on the update button.");

			// wait for the element
			explicitWaitClickable("closetoastmsg_CSS");

			// click on the toaster close button
			click("closetoastmsg_CSS");
			ngDriver.waitForAngularRequestsToFinish();
			System.out.println("Clicked on the toaster close button.");

		} catch (Throwable t) {
			verificationFailed();
		}

		// click on the home icon from the top of the screen
		click("questionnaire_homeburgermenubtn_hide_CSS");
		System.out.println("Clicked on the home icon from the top of the screen.");
		ngDriver.waitForAngularRequestsToFinish();

		// synchronization
		explicitWait("propertylist_title_XPATH");

		// verify the property list
		switchVerification("propertylist_title_XPATH", "Property List", "The property list is not displayed.");

		// VERIFY COUNT AND DETAILS OF THE CERTIFICATE OF APPROVAL CARD OF THE PORTFOLIO
		// SUMMARY DASHBOARD SCREEN AFTER UPDATE THE REPORT DATE TO THE PAST DATE OF THE
		// ENVIRONMENTAL REPORT

		System.out.println(
				"******************** VERIFY COUNT AND DETAILS OF THE CERTIFICATE OF APPROVAL CARD OF THE PORTFOLIO SUMMARY DASHBOARD SCREEN AFTER UPDATE THE REPORT DATE TO THE PAST DATE OF THE ENVIRONMENTAL REPORT ********************");
		test.log(LogStatus.INFO,
				"******************** VERIFY COUNT AND DETAILS OF THE CERTIFICATE OF APPROVAL CARD OF THE PORTFOLIO SUMMARY DASHBOARD SCREEN AFTER UPDATE THE REPORT DATE TO THE PAST DATE OF THE ENVIRONMENTAL REPORT ********************");
		Reporter.log(
				"******************** VERIFY COUNT AND DETAILS OF THE CERTIFICATE OF APPROVAL CARD OF THE PORTFOLIO SUMMARY DASHBOARD SCREEN AFTER UPDATE THE REPORT DATE TO THE PAST DATE OF THE ENVIRONMENTAL REPORT ********************");
		log.info(
				"******************** VERIFY COUNT AND DETAILS OF THE CERTIFICATE OF APPROVAL CARD OF THE PORTFOLIO SUMMARY DASHBOARD SCREEN AFTER UPDATE THE REPORT DATE TO THE PAST DATE OF THE ENVIRONMENTAL REPORT ********************");

		try {

			// wait for the element
			Thread.sleep(5000);

			// click on the side menu button
			click("menubtn_CSS");
			ngDriver.waitForAngularRequestsToFinish();
			System.out.println("Clicked on the side menu button.");

			// wait for the element
			Thread.sleep(5000);

			// click on the portfolio summary option
			click("sidemenu_portfoliosummary_XPATH");
			ngDriver.waitForAngularRequestsToFinish();
			System.out.println("Clicked on the portfolio summary option.");

			// verify property count
			switchVerification("portfoliosummary_toppropertycount_XPATH", "4",
					"The property count is not displayed correctly.");

			// scroll down the screen
			JavascriptExecutor js = (JavascriptExecutor) driver;
			WebElement label1 = driver
					.findElement(By.xpath(OR.getProperty("portfoliosummary_certificateofapprovallabel_XPATH")));
			js.executeScript("arguments[0].scrollIntoView(true);", label1);

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
			ngDriver.waitForAngularRequestsToFinish();
			System.out.println("Clicked on the percentage of the Certificate of Approval.");

			// verify the title of the environmental report
			switchVerification("portfoliosummary_certificateofapproval_listtitle_XPATH", "Certificate of Approval",
					"The Certificate of Approval is not displayed.");

			// enter the property name in the search field
			clear("portfoliosummary_certificateofapproval_searchtxt_XPATH");
			type("portfoliosummary_certificateofapproval_searchtxt_XPATH", data.get("property_4"));
			ngDriver.waitForAngularRequestsToFinish();
			System.out.println("Entered the property name in the search field.");

			// verify the report date
			try {
				LocalDate pastDate11 = LocalDate.now().minusMonths(6);
				String finalPastDate11 = pastDate11.toString();
				String reportDate11 = "//td[text()='" + data.get("property_4") + "']//following-sibling::td[1]";
				String finalReportDate11 = (driver.findElement(By.xpath(reportDate11)).getText()).trim();

				if (finalPastDate11.equals(finalReportDate11)) {

					System.out.println("The reported date is displayed correctly.");
					test.log(LogStatus.INFO, "The reported date is displayed correctly.");
					Reporter.log("The reported date is displayed correctly.");
					log.info("The reported date is displayed correctly.");

				} else {
					verificationFailed();

					System.out.println("The reported date is not displayed correctly.");
					test.log(LogStatus.INFO, "The reported date is not displayed correctly.");
					Reporter.log("The reported date is not displayed correctly.");
					log.info("The reported date is not displayed correctly.");

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

					System.out.println("The next assessment date is displayed correctly.");
					test.log(LogStatus.INFO, "The next assessment date is displayed correctly.");
					Reporter.log("The next assessment date is displayed correctly.");
					log.info("The next assessment date is displayed correctly.");

				} else {
					verificationFailed();

					System.out.println("The next assessment date is not displayed correctly.");
					test.log(LogStatus.INFO, "The next assessment date is not displayed correctly.");
					Reporter.log("The next assessment date is not displayed correctly.");
					log.info("The next assessment date is not displayed correctly.");

				}

			} catch (Throwable t) {
				verificationFailed();
			}

			// click on the respective searched record
			click("portfoliosummary_certificateofapproval_seachedproperty_XPATH");
			ngDriver.waitForAngularRequestsToFinish();
			System.out.println("Clicked on the respective searched record.");

			// enter the task name in the search field
			type("sidemenu_reports_searchtxt_XPATH", data.get("title"));
			ngDriver.waitForAngularRequestsToFinish();
			System.out.println("Entered the task name in the search field.");

			// click on the respective searched environmental report
			click("portfoliosummary_certificateofapproval_seachedenvreport_XPATH");
			ngDriver.waitForAngularRequestsToFinish();
			System.out.println("Clicked on the respective searched environmental report.");

			// verify the reported date
			try {
				LocalDate pastDate111 = LocalDate.now().minusMonths(6);
				String finalPastDate111 = pastDate111.toString();
				String actualReportedDate111 = (driver
						.findElement(By.xpath(OR.getProperty("enviromentalreport_reporteddate_XPATH")))
						.getAttribute("value")).trim();

				if (finalPastDate111.equals(actualReportedDate111)) {

					System.out.println("The reported date is displayed correctly.");
					test.log(LogStatus.INFO, "The reported date is displayed correctly.");
					Reporter.log("The reported date is displayed correctly.");
					log.info("The reported date is displayed correctly.");

				} else {
					verificationFailed();

					System.out.println("The reported date is not displayed correctly.");
					test.log(LogStatus.INFO, "The reported date is not displayed correctly.");
					Reporter.log("The reported date is not displayed correctly.");
					log.info("The reported date is not displayed correctly.");

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

					System.out.println("The next assessment date is displayed correctly.");
					test.log(LogStatus.INFO, "The next assessment date is displayed correctly.");
					Reporter.log("The next assessment date is displayed correctly.");
					log.info("The next assessment date is displayed correctly.");

				} else {
					verificationFailed();

					System.out.println("The next assessment date is not displayed correctly.");
					test.log(LogStatus.INFO, "The next assessment date is not displayed correctly.");
					Reporter.log("The next assessment date is not displayed correctly.");
					log.info("The next assessment date is not displayed correctly.");

				}

			} catch (Throwable t) {
				verificationFailed();
			}

		} catch (Throwable t) {
			verificationFailed();
		}

		// click on the home icon from the top of the screen
		click("questionnaire_homeburgermenubtn_hide_CSS");
		System.out.println("Clicked on the home icon from the top of the screen.");
		ngDriver.waitForAngularRequestsToFinish();

		// synchronization
		explicitWait("propertylist_title_XPATH");

		// verify the property list
		switchVerification("propertylist_title_XPATH", "Property List", "The property list is not displayed.");

		// EXCLUDE THE CERTIFICATE OF APPROVAL ENVIRONMENTAL TYPE

		System.out
				.println("***************** EXCLUDE THE CERTIFICATE OF APPROVAL ENVIRONMENTAL TYPE *****************");
		test.log(LogStatus.INFO,
				"***************** EXCLUDE THE CERTIFICATE OF APPROVAL ENVIRONMENTAL TYPE *****************");
		Reporter.log("***************** EXCLUDE THE CERTIFICATE OF APPROVAL ENVIRONMENTAL TYPE *****************");
		log.info("***************** EXCLUDE THE CERTIFICATE OF APPROVAL ENVIRONMENTAL TYPE *****************");

		try {

			// wait for the element
			Thread.sleep(5000);

			// click on the side menu button
			click("menubtn_CSS");
			ngDriver.waitForAngularRequestsToFinish();
			System.out.println("Clicked on the side menu button.");

			// wait for the element
			Thread.sleep(5000);

			// click on the portfolio summary option
			click("sidemenu_portfoliosummary_XPATH");
			ngDriver.waitForAngularRequestsToFinish();
			System.out.println("Clicked on the portfolio summary option.");

			// verify property count
			switchVerification("portfoliosummary_toppropertycount_XPATH", "4",
					"The property count is not displayed correctly.");

			// scroll down the screen
			JavascriptExecutor js = (JavascriptExecutor) driver;
			WebElement label1 = driver
					.findElement(By.xpath(OR.getProperty("portfoliosummary_certificateofapprovallabel_XPATH")));
			js.executeScript("arguments[0].scrollIntoView(true);", label1);

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
			ngDriver.waitForAngularRequestsToFinish();
			System.out.println("Clicked on the percentage of the Certificate of Approval.");

			// verify the title of the environmental report
			switchVerification("portfoliosummary_certificateofapproval_listtitle_XPATH", "Certificate of Approval",
					"The Certificate of Approval is not displayed.");

			// enter the property name in the search field
			clear("portfoliosummary_certificateofapproval_searchtxt_XPATH");
			type("portfoliosummary_certificateofapproval_searchtxt_XPATH", data.get("property_4"));
			ngDriver.waitForAngularRequestsToFinish();
			System.out.println("Entered the property name in the search field.");

			// click on the action icon of the respective searched record
			click("portfoliosummary_certificateofapproval_seachedproperty_actionicon_XPATH");
			ngDriver.waitForAngularRequestsToFinish();
			System.out.println("Clicked on the respective searched record.");

			// click on the assessment schedule option
			click("portfoliosummary_certificateofapproval_seachedproperty_option1_XPATH");
			ngDriver.waitForAngularRequestsToFinish();
			System.out.println("Clicked on the assessment schedule option.");

			// validate and select the not required checkbox

			try {
				boolean notRequiredCkbx = driver
						.findElement(
								By.xpath(OR.getProperty("portfoliosummary_certificateofapproval_notrequired_XPATH")))
						.isSelected();

				if (notRequiredCkbx == false) {

					// click on the not required checkbox
					click("portfoliosummary_certificateofapproval_notrequired_XPATH");
					ngDriver.waitForAngularRequestsToFinish();
					System.out.println("Clicked on the not required checkbox.");

					System.out.println("The not required checkbox is displayed selected.");
					test.log(LogStatus.INFO, "The not required checkbox is displayed selected.");
					Reporter.log("The not required checkbox is displayed selected.");
					log.info("The not required checkbox is displayed selected.");

				} else {
					System.out.println("The not required checkbox is displayed selected.");
					test.log(LogStatus.INFO, "The not required checkbox is displayed selected.");
					Reporter.log("The not required checkbox is displayed selected.");
					log.info("The not required checkbox is displayed selected.");
				}

			} catch (Throwable t) {
				verificationFailed();
			}

			// click on the save button
			click("portfoliosummary_certificateofapproval_notrequired_savebtn_XPATH");
			ngDriver.waitForAngularRequestsToFinish();
			System.out.println("Clicked on the save button.");

			// enter the property name in the search field
			clear("portfoliosummary_certificateofapproval_searchtxt_XPATH");
			type("portfoliosummary_certificateofapproval_searchtxt_XPATH", data.get("property_4"));
			ngDriver.waitForAngularRequestsToFinish();
			System.out.println("Entered the property name in the search field.");

			// verify respective property is displayed or not
			deleteVerification("portfoliosummary_certificateofapproval_seachedproperty_XPATH",
					"SmartCentres Brockville");

		} catch (Throwable t) {
			verificationFailed();
		}

		// click on the home icon from the top of the screen
		click("questionnaire_homeburgermenubtn_hide_CSS");
		System.out.println("Clicked on the home icon from the top of the screen.");
		ngDriver.waitForAngularRequestsToFinish();

		// synchronization
		explicitWait("propertylist_title_XPATH");

		// verify the property list
		switchVerification("propertylist_title_XPATH", "Property List", "The property list is not displayed.");

		// VERIFY COUNT AND DETAILS OF THE CERTIFICATE OF APPROVAL CARD OF THE PORTFOLIO
		// SUMMARY DASHBOARD SCREEN AFTER EXCLUDE THE ENVIRONMENTAL REPORTS

		System.out.println(
				"******************** VERIFY COUNT AND DETAILS OF THE CERTIFICATE OF APPROVAL CARD OF THE PORTFOLIO SUMMARY DASHBOARD SCREEN AFTER EXCLUDE THE ENVIRONMENTAL REPORTS ********************");
		test.log(LogStatus.INFO,
				"******************** VERIFY COUNT AND DETAILS OF THE CERTIFICATE OF APPROVAL CARD OF THE PORTFOLIO SUMMARY DASHBOARD SCREEN AFTER EXCLUDE THE ENVIRONMENTAL REPORTS ********************");
		Reporter.log(
				"******************** VERIFY COUNT AND DETAILS OF THE CERTIFICATE OF APPROVAL CARD OF THE PORTFOLIO SUMMARY DASHBOARD SCREEN AFTER EXCLUDE THE ENVIRONMENTAL REPORTS ********************");
		log.info(
				"******************** VERIFY COUNT AND DETAILS OF THE CERTIFICATE OF APPROVAL CARD OF THE PORTFOLIO SUMMARY DASHBOARD SCREEN AFTER EXCLUDE THE ENVIRONMENTAL REPORTS ********************");

		try {

			// wait for the element
			Thread.sleep(5000);

			// click on the side menu button
			click("menubtn_CSS");
			ngDriver.waitForAngularRequestsToFinish();
			System.out.println("Clicked on the side menu button.");

			// wait for the element
			Thread.sleep(5000);

			// click on the portfolio summary option
			click("sidemenu_portfoliosummary_XPATH");
			ngDriver.waitForAngularRequestsToFinish();
			System.out.println("Clicked on the portfolio summary option.");

			// verify property count
			switchVerification("portfoliosummary_toppropertycount_XPATH", "4",
					"The property count is not displayed correctly.");

			// scroll down the screen
			JavascriptExecutor js = (JavascriptExecutor) driver;
			WebElement label1 = driver
					.findElement(By.xpath(OR.getProperty("portfoliosummary_certificateofapprovallabel_XPATH")));
			js.executeScript("arguments[0].scrollIntoView(true);", label1);

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
			ngDriver.waitForAngularRequestsToFinish();
			System.out.println("Clicked on the percentage of the Certificate of Approval.");

			// verify the title of the environmental report
			switchVerification("portfoliosummary_certificateofapproval_listtitle_XPATH", "Certificate of Approval",
					"The Certificate of Approval is not displayed.");

			// enter the property name in the search field
			clear("portfoliosummary_certificateofapproval_searchtxt_XPATH");
			type("portfoliosummary_certificateofapproval_searchtxt_XPATH", data.get("property_4"));
			ngDriver.waitForAngularRequestsToFinish();
			System.out.println("Entered the property name in the search field.");

			// verify respective property is displayed or not
			deleteVerification("portfoliosummary_certificateofapproval_seachedproperty_XPATH",
					"SmartCentres Brockville");

		} catch (Throwable t) {
			verificationFailed();
		}

		// click on the home icon from the top of the screen
		click("questionnaire_homeburgermenubtn_hide_CSS");
		System.out.println("Clicked on the home icon from the top of the screen.");
		ngDriver.waitForAngularRequestsToFinish();

		// synchronization
		explicitWait("propertylist_title_XPATH");

		// verify the property list
		switchVerification("propertylist_title_XPATH", "Property List", "The property list is not displayed.");

		// REMOVE EXCLUDE OF THE CERTIFICATE OF APPROVAL ENVIRONMENTAL TYPE

		System.out.println(
				"***************** REMOVE EXCLUDE OF THE CERTIFICATE OF APPROVAL ENVIRONMENTAL TYPE *****************");
		test.log(LogStatus.INFO,
				"***************** REMOVE EXCLUDE OF THE CERTIFICATE OF APPROVAL ENVIRONMENTAL TYPE *****************");
		Reporter.log(
				"***************** REMOVE EXCLUDE OF THE CERTIFICATE OF APPROVAL ENVIRONMENTAL TYPE *****************");
		log.info(
				"***************** REMOVE EXCLUDE OF THE CERTIFICATE OF APPROVAL ENVIRONMENTAL TYPE *****************");

		try {

			// wait for the element
			Thread.sleep(5000);

			// click on the side menu button
			click("menubtn_CSS");
			ngDriver.waitForAngularRequestsToFinish();
			System.out.println("Clicked on the side menu button.");

			// wait for the element
			Thread.sleep(5000);

			// click on the portfolio summary option
			click("sidemenu_portfoliosummary_XPATH");
			ngDriver.waitForAngularRequestsToFinish();
			System.out.println("Clicked on the portfolio summary option.");

			// verify property count
			switchVerification("portfoliosummary_toppropertycount_XPATH", "4",
					"The property count is not displayed correctly.");

			// scroll down the screen
			JavascriptExecutor js = (JavascriptExecutor) driver;
			WebElement label1 = driver
					.findElement(By.xpath(OR.getProperty("portfoliosummary_certificateofapprovallabel_XPATH")));
			js.executeScript("arguments[0].scrollIntoView(true);", label1);

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
			ngDriver.waitForAngularRequestsToFinish();
			System.out.println("Clicked on the percentage of the Certificate of Approval.");

			// enter the property name in the search field
			clear("portfoliosummary_certificateofapproval_searchtxt_XPATH");
			type("portfoliosummary_certificateofapproval_searchtxt_XPATH", data.get("property_4"));
			ngDriver.waitForAngularRequestsToFinish();
			System.out.println("Entered the property name in the search field.");

			// click on the action icon of the respective searched record
			click("portfoliosummary_certificateofapproval_seachedproperty_actionicon_XPATH");
			ngDriver.waitForAngularRequestsToFinish();
			System.out.println("Clicked on the respective searched record.");

			// click on the assessment schedule option
			click("portfoliosummary_certificateofapproval_seachedproperty_option1_XPATH");
			ngDriver.waitForAngularRequestsToFinish();
			System.out.println("Clicked on the assessment schedule option.");

			// validate and select the not required checkbox

			try {
				boolean notRequiredCkbx = driver
						.findElement(
								By.xpath(OR.getProperty("portfoliosummary_certificateofapproval_notrequired_XPATH")))
						.isSelected();

				if (notRequiredCkbx == true) {

					// click on the not required checkbox
					click("portfoliosummary_certificateofapproval_notrequired_XPATH");
					ngDriver.waitForAngularRequestsToFinish();
					System.out.println("Clicked on the not required checkbox.");

					System.out.println("The not required checkbox is not displayed selected.");
					test.log(LogStatus.INFO, "The not required checkbox is not displayed selected.");
					Reporter.log("The not required checkbox is not displayed selected.");
					log.info("The not required checkbox is not displayed selected.");

				} else {
					System.out.println("The not required checkbox is not displayed selected.");
					test.log(LogStatus.INFO, "The not required checkbox is not displayed selected.");
					Reporter.log("The not required checkbox is not displayed selected.");
					log.info("The not required checkbox is not displayed selected.");
				}

			} catch (Throwable t) {
				verificationFailed();
			}

			// click on the save button
			click("portfoliosummary_certificateofapproval_notrequired_savebtn_XPATH");
			ngDriver.waitForAngularRequestsToFinish();
			System.out.println("Clicked on the save button.");

			// enter the property name in the search field
			clear("portfoliosummary_certificateofapproval_searchtxt_XPATH");
			type("portfoliosummary_certificateofapproval_searchtxt_XPATH", data.get("property_4"));
			ngDriver.waitForAngularRequestsToFinish();
			System.out.println("Entered the property name in the search field.");

			// verify respective property is displayed or not
			deleteVerification("portfoliosummary_certificateofapproval_seachedproperty_XPATH",
					"SmartCentres Brockville");

		} catch (Throwable t) {
			verificationFailed();
		}

		// click on the home icon from the top of the screen
		click("questionnaire_homeburgermenubtn_hide_CSS");
		System.out.println("Clicked on the home icon from the top of the screen.");
		ngDriver.waitForAngularRequestsToFinish();

		// synchronization
		explicitWait("propertylist_title_XPATH");

		// verify the property list
		switchVerification("propertylist_title_XPATH", "Property List", "The property list is not displayed.");

		// VERIFY COUNT AND DETAILS OF THE CERTIFICATE OF APPROVAL CARD OF THE PORTFOLIO
		// SUMMARY DASHBOARD SCREEN AFTER REMOVE EXCLUDE THE ENVIRONMENTAL REPORTS

		System.out.println(
				"******************** VERIFY COUNT AND DETAILS OF THE CERTIFICATE OF APPROVAL CARD OF THE PORTFOLIO SUMMARY DASHBOARD SCREEN AFTER REMOVE EXCLUDE THE ENVIRONMENTAL REPORTS ********************");
		test.log(LogStatus.INFO,
				"******************** VERIFY COUNT AND DETAILS OF THE CERTIFICATE OF APPROVAL CARD OF THE PORTFOLIO SUMMARY DASHBOARD SCREEN AFTER REMOVE EXCLUDE THE ENVIRONMENTAL REPORTS ********************");
		Reporter.log(
				"******************** VERIFY COUNT AND DETAILS OF THE CERTIFICATE OF APPROVAL CARD OF THE PORTFOLIO SUMMARY DASHBOARD SCREEN AFTER REMOVE EXCLUDE THE ENVIRONMENTAL REPORTS ********************");
		log.info(
				"******************** VERIFY COUNT AND DETAILS OF THE CERTIFICATE OF APPROVAL CARD OF THE PORTFOLIO SUMMARY DASHBOARD SCREEN AFTER REMOVE EXCLUDE THE ENVIRONMENTAL REPORTS ********************");

		try {

			// wait for the element
			Thread.sleep(5000);

			// click on the side menu button
			click("menubtn_CSS");
			ngDriver.waitForAngularRequestsToFinish();
			System.out.println("Clicked on the side menu button.");

			// wait for the element
			Thread.sleep(5000);

			// click on the portfolio summary option
			click("sidemenu_portfoliosummary_XPATH");
			ngDriver.waitForAngularRequestsToFinish();
			System.out.println("Clicked on the portfolio summary option.");

			// verify property count
			switchVerification("portfoliosummary_toppropertycount_XPATH", "4",
					"The property count is not displayed correctly.");

			// scroll down the screen
			JavascriptExecutor js = (JavascriptExecutor) driver;
			WebElement label1 = driver
					.findElement(By.xpath(OR.getProperty("portfoliosummary_certificateofapprovallabel_XPATH")));
			js.executeScript("arguments[0].scrollIntoView(true);", label1);

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
			ngDriver.waitForAngularRequestsToFinish();
			System.out.println("Clicked on the percentage of the Certificate of Approval.");

			// verify the title of the environmental report
			switchVerification("portfoliosummary_certificateofapproval_listtitle_XPATH", "Certificate of Approval",
					"The Certificate of Approval is not displayed.");

			// enter the property name in the search field
			clear("portfoliosummary_certificateofapproval_searchtxt_XPATH");
			type("portfoliosummary_certificateofapproval_searchtxt_XPATH", data.get("property_4"));
			ngDriver.waitForAngularRequestsToFinish();
			System.out.println("Entered the property name in the search field.");

			// verify respective property is displayed or not
			switchVerification("portfoliosummary_certificateofapproval_seachedproperty_XPATH",
					"SmartCentres Brockville", "The SmartCentres Brockville is not displayed.");

		} catch (Throwable t) {
			verificationFailed();
		}

		// click on the home icon from the top of the screen
		click("questionnaire_homeburgermenubtn_hide_CSS");
		System.out.println("Clicked on the home icon from the top of the screen.");
		ngDriver.waitForAngularRequestsToFinish();

		// synchronization
		explicitWait("propertylist_title_XPATH");

		// verify the property list
		switchVerification("propertylist_title_XPATH", "Property List", "The property list is not displayed.");

		// ADD TASK IN THE ENVIRONMENTAL REPORT WITHOUT DUE DATE

		System.out.println("***************** ADD TASK IN THE ENVIRONMENTAL REPORT WITHOUT DUE DATE *****************");
		test.log(LogStatus.INFO,
				"***************** ADD TASK IN THE ENVIRONMENTAL REPORT WITHOUT DUE DATE *****************");
		Reporter.log("***************** ADD TASK IN THE ENVIRONMENTAL REPORT WITHOUT DUE DATE *****************");
		log.info("***************** ADD TASK IN THE ENVIRONMENTAL REPORT WITHOUT DUE DATE *****************");

		try {

			// enter the property name in the search field
			type("envreports_propertylist_filtertxt_CSS", data.get("property_4"));
			ngDriver.waitForAngularRequestsToFinish();
			System.out.println("Entered the property name in the search field.");

			// click on the environmental icon
			click("environmentalicon_CSS");
			System.out.println("Clicked on the environmental icon.");
			ngDriver.waitForAngularRequestsToFinish();

			// wait for the element
			explicitWaitClickable("ssc_leftsidemenubtn_CSS");

			// click on the side menu
			click("ssc_leftsidemenubtn_CSS");
			ngDriver.waitForAngularRequestsToFinish();
			System.out.println("Clicked on the side menu.");

			// wait for the element
			explicitWaitClickable("envreportoption_XPATH");

			// click on the environmental report
			click("envreportoption_XPATH");
			ngDriver.waitForAngularRequestsToFinish();
			System.out.println("Clicked on the environmental report.");

			// click on the newly created environmental report
			click("environmental_searchedreport_psd1_XPATH");
			ngDriver.waitForAngularRequestsToFinish();
			System.out.println("Clicked on the newly created environmental report.");

			// click on the task tab
			click("envreportaddedrecord_tasktab_XPATH");
			ngDriver.waitForAngularRequestsToFinish();
			System.out.println("Clicked on the task tab.");

			// click on the new task button
			click("envreportaddedrecord_tasktab_newtaskbtn_XPATH");
			ngDriver.waitForAngularRequestsToFinish();
			System.out.println("Clicked on the new task button.");

			// enter the task title
			type("riskmanagement_insuranceclaim_task_titletxt_XPATH", data.get("task_title"));
			ngDriver.waitForAngularRequestsToFinish();
			System.out.println("Entered the task title.");

			// click on the save report button
			click("environmental_task_submitbtn_XPATH");
			ngDriver.waitForAngularRequestsToFinish();
			System.out.println("Clicked on the save Button.");

			// wait for the element
			Thread.sleep(5000);

			// verify newly created task is displayed or not
			switchVerification("environmental_task_createdtask_psd1_XPATH", "Task Environmental Report PSD 1",
					"The Task Environmental Report PSD 1 is not displayed.");

			// click on the update button of the environmental report
			click("envreportupdatebtn_CSS");
			ngDriver.waitForAngularRequestsToFinish();
			System.out.println("Clicked on the update button of the environmental report");

			// wait for the element
			explicitWaitClickable("closetoastmsg_CSS");

			// click on the toaster close button
			click("closetoastmsg_CSS");
			ngDriver.waitForAngularRequestsToFinish();
			System.out.println("Clicked on the toaster close button.");

			// enter the newly created environmental report in the search field
			clear("task_listofchecklist_filterfield_CSS");
			type("task_listofchecklist_filterfield_CSS", data.get("title"));
			ngDriver.waitForAngularRequestsToFinish();
			System.out.println("Entered the newly created environmental report in the search field.");

			// verify the newly created environmental report is displayed or not
			switchVerification("environmental_searchedreport_psd1_XPATH", "Test Environmental Report PSD 1",
					"The Test Environmental Report PSD 1 is not displayed.");

		} catch (Throwable t) {
			verificationFailed();
		}

		// click on the home icon from the top of the screen
		click("questionnaire_homeburgermenubtn_hide_CSS");
		System.out.println("Clicked on the home icon from the top of the screen.");
		ngDriver.waitForAngularRequestsToFinish();

		// synchronization
		explicitWait("propertylist_title_XPATH");

		// verify the property list
		switchVerification("propertylist_title_XPATH", "Property List", "The property list is not displayed.");

		// VERIFY COUNT AND DETAILS OF THE CERTIFICATE OF APPROVAL CARD OF THE PORTFOLIO
		// SUMMARY DASHBOARD SCREEN AFTER ADDED THE TASK IN THE ENVIRONMENTAL REPORTS
		// WITH FUTURE DUE DATE

		System.out.println(
				"******************** VERIFY COUNT AND DETAILS OF THE CERTIFICATE OF APPROVAL CARD OF THE PORTFOLIO SUMMARY DASHBOARD SCREEN AFTER ADDED THE TASK IN THE ENVIRONMENTAL REPORTS WITHOUT DUE DATE ********************");
		test.log(LogStatus.INFO,
				"******************** VERIFY COUNT AND DETAILS OF THE CERTIFICATE OF APPROVAL CARD OF THE PORTFOLIO SUMMARY DASHBOARD SCREEN AFTER ADDED THE TASK IN THE ENVIRONMENTAL REPORTS WITHOUT DUE DATE ********************");
		Reporter.log(
				"******************** VERIFY COUNT AND DETAILS OF THE CERTIFICATE OF APPROVAL CARD OF THE PORTFOLIO SUMMARY DASHBOARD SCREEN AFTER ADDED THE TASK IN THE ENVIRONMENTAL REPORTS WITHOUT DUE DATE ********************");
		log.info(
				"******************** VERIFY COUNT AND DETAILS OF THE CERTIFICATE OF APPROVAL CARD OF THE PORTFOLIO SUMMARY DASHBOARD SCREEN AFTER ADDED THE TASK IN THE ENVIRONMENTAL REPORTS WITHOUT DUE DATE ********************");

		try {

			// wait for the element
			Thread.sleep(5000);

			// click on the side menu button
			click("menubtn_CSS");
			ngDriver.waitForAngularRequestsToFinish();
			System.out.println("Clicked on the side menu button.");

			// wait for the element
			Thread.sleep(5000);

			// click on the portfolio summary option
			click("sidemenu_portfoliosummary_XPATH");
			ngDriver.waitForAngularRequestsToFinish();
			System.out.println("Clicked on the portfolio summary option.");

			// verify property count
			switchVerification("portfoliosummary_toppropertycount_XPATH", "4",
					"The property count is not displayed correctly.");

			// scroll down the screen
			JavascriptExecutor js = (JavascriptExecutor) driver;
			WebElement label1 = driver
					.findElement(By.xpath(OR.getProperty("portfoliosummary_certificateofapprovallabel_XPATH")));
			js.executeScript("arguments[0].scrollIntoView(true);", label1);

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
		System.out.println("Clicked on the home icon from the top of the screen.");
		ngDriver.waitForAngularRequestsToFinish();

		// synchronization
		explicitWait("propertylist_title_XPATH");

		// verify the property list
		switchVerification("propertylist_title_XPATH", "Property List", "The property list is not displayed.");

		// UPDATE THE TASK OF THE ENVIRONMENTAL REPORT WITH TODAY DUE DATE

		System.out.println(
				"***************** UPDATE THE TASK OF THE ENVIRONMENTAL REPORT WITH TODAY DUE DATE *****************");
		test.log(LogStatus.INFO,
				"***************** UPDATE THE TASK OF THE ENVIRONMENTAL REPORT WITH TODAY DUE DATE *****************");
		Reporter.log(
				"***************** UPDATE THE TASK OF THE ENVIRONMENTAL REPORT WITH TODAY DUE DATE *****************");
		log.info("***************** UPDATE THE TASK OF THE ENVIRONMENTAL REPORT WITH TODAY DUE DATE *****************");

		try {

			// enter the property name in the search field
			type("envreports_propertylist_filtertxt_CSS", data.get("property_4"));
			ngDriver.waitForAngularRequestsToFinish();
			System.out.println("Entered the property name in the search field.");

			// click on the environmental icon
			click("environmentalicon_CSS");
			System.out.println("Clicked on the environmental icon.");
			ngDriver.waitForAngularRequestsToFinish();

			// wait for the element
			explicitWaitClickable("ssc_leftsidemenubtn_CSS");

			// click on the side menu
			click("ssc_leftsidemenubtn_CSS");
			ngDriver.waitForAngularRequestsToFinish();
			System.out.println("Clicked on the side menu.");

			// wait for the element
			explicitWaitClickable("envreportoption_XPATH");

			// click on the environmental report
			click("envreportoption_XPATH");
			ngDriver.waitForAngularRequestsToFinish();
			System.out.println("Clicked on the environmental report.");

			// click on the newly created environmental report
			click("environmental_searchedreport_psd1_XPATH");
			ngDriver.waitForAngularRequestsToFinish();
			System.out.println("Clicked on the newly created environmental report.");

			// click on the task tab
			click("envreportaddedrecord_tasktab_XPATH");
			ngDriver.waitForAngularRequestsToFinish();
			System.out.println("Clicked on the task tab.");

			// click on the newly created task
			click("environmental_task_createdtask_psd1_XPATH");
			ngDriver.waitForAngularRequestsToFinish();
			System.out.println("Clicked on the newly created task.");

			// click on the due date field
			click("envreportaddedrecord_duedate1_XPATH");
			ngDriver.waitForAngularRequestsToFinish();
			System.out.println("Clicked on the due date field.");

			// scroll down the screen
			JavascriptExecutor js = (JavascriptExecutor) driver;
			js.executeScript("window.scrollBy(0,200)");

			// click on the today button
			click("envreporttodaydate_BTNTEXT");
			ngDriver.waitForAngularRequestsToFinish();
			System.out.println("Today's date selected in the Date Field.");

			// click on the update task button
			click("environmental_task_submitbtn_XPATH");
			ngDriver.waitForAngularRequestsToFinish();
			System.out.println("Clicked on the save Button.");

			// wait for the element
			Thread.sleep(5000);

			// verify newly created task is displayed or not
			switchVerification("environmental_task_createdtask_psd1_XPATH", "Task Environmental Report PSD 1",
					"The Task Environmental Report PSD 1 is not displayed.");

			// click on the update button of the environmental report
			click("envreportupdatebtn_CSS");
			ngDriver.waitForAngularRequestsToFinish();
			System.out.println("Clicked on the update button of the environmental report");

//			// wait for the element
//			explicitWaitClickable("closetoastmsg_CSS");
//
//			// click on the toaster close button
//			click("closetoastmsg_CSS");
//			ngDriver.waitForAngularRequestsToFinish();
//			System.out.println("Clicked on the toaster close button.");

			// enter the newly created environmental report in the search field
			clear("task_listofchecklist_filterfield_CSS");
			type("task_listofchecklist_filterfield_CSS", data.get("title"));
			ngDriver.waitForAngularRequestsToFinish();
			System.out.println("Entered the newly created environmental report in the search field.");

			// verify the newly created environmental report is displayed or not
			switchVerification("environmental_searchedreport_psd1_XPATH", "Test Environmental Report PSD 1",
					"The Test Environmental Report PSD 1 is not displayed.");

		} catch (Throwable t) {
			verificationFailed();
		}

		// click on the home icon from the top of the screen
		click("questionnaire_homeburgermenubtn_hide_CSS");
		System.out.println("Clicked on the home icon from the top of the screen.");
		ngDriver.waitForAngularRequestsToFinish();

		// synchronization
		explicitWait("propertylist_title_XPATH");

		// verify the property list
		switchVerification("propertylist_title_XPATH", "Property List", "The property list is not displayed.");

		// VERIFY COUNT AND DETAILS OF THE CERTIFICATE OF APPROVAL CARD OF THE PORTFOLIO
		// SUMMARY DASHBOARD SCREEN AFTER UPDATE THE TASK IN THE ENVIRONMENTAL REPORTS
		// WITH PAST DUE DATE

		System.out.println(
				"******************** VERIFY COUNT AND DETAILS OF THE CERTIFICATE OF APPROVAL CARD OF THE PORTFOLIO SUMMARY DASHBOARD SCREEN AFTER UPDATE THE TASK IN THE ENVIRONMENTAL REPORTS WITH TODAY'S DUE DATE ********************");
		test.log(LogStatus.INFO,
				"******************** VERIFY COUNT AND DETAILS OF THE CERTIFICATE OF APPROVAL CARD OF THE PORTFOLIO SUMMARY DASHBOARD SCREEN AFTER UPDATE THE TASK IN THE ENVIRONMENTAL REPORTS WITH TODAY'S DUE DATE ********************");
		Reporter.log(
				"******************** VERIFY COUNT AND DETAILS OF THE CERTIFICATE OF APPROVAL CARD OF THE PORTFOLIO SUMMARY DASHBOARD SCREEN AFTER UPDATE THE TASK IN THE ENVIRONMENTAL REPORTS WITH TODAY'S DUE DATE ********************");
		log.info(
				"******************** VERIFY COUNT AND DETAILS OF THE CERTIFICATE OF APPROVAL CARD OF THE PORTFOLIO SUMMARY DASHBOARD SCREEN AFTER UPDATE THE TASK IN THE ENVIRONMENTAL REPORTS WITH TODAY'S DUE DATE ********************");

		try {

			// wait for the element
			Thread.sleep(5000);

			// click on the side menu button
			click("menubtn_CSS");
			ngDriver.waitForAngularRequestsToFinish();
			System.out.println("Clicked on the side menu button.");

			// wait for the element
			Thread.sleep(5000);

			// click on the portfolio summary option
			click("sidemenu_portfoliosummary_XPATH");
			ngDriver.waitForAngularRequestsToFinish();
			System.out.println("Clicked on the portfolio summary option.");

			// verify property count
			switchVerification("portfoliosummary_toppropertycount_XPATH", "4",
					"The property count is not displayed correctly.");

			// scroll down the screen
			JavascriptExecutor js = (JavascriptExecutor) driver;
			WebElement label1 = driver
					.findElement(By.xpath(OR.getProperty("portfoliosummary_certificateofapprovallabel_XPATH")));
			js.executeScript("arguments[0].scrollIntoView(true);", label1);

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
		System.out.println("Clicked on the home icon from the top of the screen.");
		ngDriver.waitForAngularRequestsToFinish();

		// synchronization
		explicitWait("propertylist_title_XPATH");

		// verify the property list
		switchVerification("propertylist_title_XPATH", "Property List", "The property list is not displayed.");

		// APPROVE THE TASK OF THE ENVIRONMENTAL REPORT

		System.out.println("***************** APPROVE THE TASK OF THE ENVIRONMENTAL REPORT *****************");
		test.log(LogStatus.INFO, "***************** APPROVE THE TASK OF THE ENVIRONMENTAL REPORT *****************");
		Reporter.log("***************** APPROVE THE TASK OF THE ENVIRONMENTAL REPORT *****************");
		log.info("***************** APPROVE THE TASK OF THE ENVIRONMENTAL REPORT *****************");

		try {

			// enter the property name in the search field
			type("envreports_propertylist_filtertxt_CSS", data.get("property_4"));
			ngDriver.waitForAngularRequestsToFinish();
			System.out.println("Entered the property name in the search field.");

			// click on the environmental icon
			click("environmentalicon_CSS");
			System.out.println("Clicked on the environmental icon.");
			ngDriver.waitForAngularRequestsToFinish();

			// wait for the element
			explicitWaitClickable("ssc_leftsidemenubtn_CSS");

			// click on the side menu
			click("ssc_leftsidemenubtn_CSS");
			ngDriver.waitForAngularRequestsToFinish();
			System.out.println("Clicked on the side menu.");

			// wait for the element
			explicitWaitClickable("envreportoption_XPATH");

			// click on the environmental report
			click("envreportoption_XPATH");
			ngDriver.waitForAngularRequestsToFinish();
			System.out.println("Clicked on the environmental report.");

			// click on the newly created environmental report
			click("environmental_searchedreport_psd1_XPATH");
			ngDriver.waitForAngularRequestsToFinish();
			System.out.println("Clicked on the newly created environmental report.");

			// click on the task tab
			click("envreportaddedrecord_tasktab_XPATH");
			ngDriver.waitForAngularRequestsToFinish();
			System.out.println("Clicked on the task tab.");

			// click on the newly created task
			click("environmental_task_createdtask_psd1_XPATH");
			ngDriver.waitForAngularRequestsToFinish();
			System.out.println("Clicked on the newly created task.");

			// click on the start button
			click("environmental_task_startbtn_XPATH");
			ngDriver.waitForAngularRequestsToFinish();
			System.out.println("Clicked on the start button.");

			// wait for the element
			explicitWaitClickable("closetoastmsg_CSS");

			// click on the toaster close button
			click("closetoastmsg_CSS");
			ngDriver.waitForAngularRequestsToFinish();
			System.out.println("Clicked on the toaster close button.");

			// click on the approve button
			click("environmental_task_approvebtn_XPATH");
			ngDriver.waitForAngularRequestsToFinish();
			System.out.println("Clicked on the approve button.");

			// wait for the element
			explicitWaitClickable("closetoastmsg_CSS");

			// click on the toaster close button
			click("closetoastmsg_CSS");
			ngDriver.waitForAngularRequestsToFinish();
			System.out.println("Clicked on the toaster close button.");

			// click on the update task button
			click("environmental_task_submitbtn_XPATH");
			ngDriver.waitForAngularRequestsToFinish();
			System.out.println("Clicked on the save Button.");

			// wait for the element
			Thread.sleep(5000);

			// verify newly created task is displayed or not
			switchVerification("environmental_task_createdtask_psd1_XPATH", "Task Environmental Report PSD 1",
					"The Task Environmental Report PSD 1 is not displayed.");

			// click on the update button of the environmental report
			click("envreportupdatebtn_CSS");
			ngDriver.waitForAngularRequestsToFinish();
			System.out.println("Clicked on the update button of the environmental report");

			// wait for the element
			explicitWaitClickable("closetoastmsg_CSS");

			// click on the toaster close button
			click("closetoastmsg_CSS");
			ngDriver.waitForAngularRequestsToFinish();
			System.out.println("Clicked on the toaster close button.");

			// enter the newly created environmental report in the search field
			clear("task_listofchecklist_filterfield_CSS");
			type("task_listofchecklist_filterfield_CSS", data.get("title"));
			ngDriver.waitForAngularRequestsToFinish();
			System.out.println("Entered the newly created environmental report in the search field.");

			// verify the newly created environmental report is displayed or not
			switchVerification("environmental_searchedreport_psd1_XPATH", "Test Environmental Report PSD 1",
					"The Test Environmental Report PSD 1 is not displayed.");

		} catch (Throwable t) {
			verificationFailed();
		}

		// click on the home icon from the top of the screen
		click("questionnaire_homeburgermenubtn_hide_CSS");
		System.out.println("Clicked on the home icon from the top of the screen.");
		ngDriver.waitForAngularRequestsToFinish();

		// synchronization
		explicitWait("propertylist_title_XPATH");

		// verify the property list
		switchVerification("propertylist_title_XPATH", "Property List", "The property list is not displayed.");

		// VERIFY COUNT AND DETAILS OF THE CERTIFICATE OF APPROVAL CARD OF THE PORTFOLIO
		// SUMMARY DASHBOARD SCREEN AFTER APPROVE THE TASK OF THE ENVIRONMENTAL REPORT

		System.out.println(
				"******************** VERIFY COUNT AND DETAILS OF THE CERTIFICATE OF APPROVAL CARD OF THE PORTFOLIO SUMMARY DASHBOARD SCREEN AFTER APPROVE THE TASK OF THE ENVIRONMENTAL REPORT ********************");
		test.log(LogStatus.INFO,
				"******************** VERIFY COUNT AND DETAILS OF THE CERTIFICATE OF APPROVAL CARD OF THE PORTFOLIO SUMMARY DASHBOARD SCREEN AFTER APPROVE THE TASK OF THE ENVIRONMENTAL REPORT ********************");
		Reporter.log(
				"******************** VERIFY COUNT AND DETAILS OF THE CERTIFICATE OF APPROVAL CARD OF THE PORTFOLIO SUMMARY DASHBOARD SCREEN AFTER APPROVE THE TASK OF THE ENVIRONMENTAL REPORT ********************");
		log.info(
				"******************** VERIFY COUNT AND DETAILS OF THE CERTIFICATE OF APPROVAL CARD OF THE PORTFOLIO SUMMARY DASHBOARD SCREEN AFTER APPROVE THE TASK OF THE ENVIRONMENTAL REPORT ********************");

		try {

			// wait for the element
			Thread.sleep(5000);

			// click on the side menu button
			click("menubtn_CSS");
			ngDriver.waitForAngularRequestsToFinish();
			System.out.println("Clicked on the side menu button.");

			// wait for the element
			Thread.sleep(5000);

			// click on the portfolio summary option
			click("sidemenu_portfoliosummary_XPATH");
			ngDriver.waitForAngularRequestsToFinish();
			System.out.println("Clicked on the portfolio summary option.");

			// verify property count
			switchVerification("portfoliosummary_toppropertycount_XPATH", "4",
					"The property count is not displayed correctly.");

			// scroll down the screen
			JavascriptExecutor js = (JavascriptExecutor) driver;
			WebElement label1 = driver
					.findElement(By.xpath(OR.getProperty("portfoliosummary_certificateofapprovallabel_XPATH")));
			js.executeScript("arguments[0].scrollIntoView(true);", label1);

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
		System.out.println("Clicked on the home icon from the top of the screen.");
		ngDriver.waitForAngularRequestsToFinish();

		// synchronization
		explicitWait("propertylist_title_XPATH");

		// verify the property list
		switchVerification("propertylist_title_XPATH", "Property List", "The property list is not displayed.");

		// DELETE THE NEWLY CREATED ENVIRONMENTAL REPORT

		System.out.println("***************** DELETE THE NEWLY CREATED ENVIRONMENTAL REPORT *****************");
		test.log(LogStatus.INFO, "***************** DELETE THE NEWLY CREATED ENVIRONMENTAL REPORT *****************");
		Reporter.log("***************** DELETE THE NEWLY CREATED ENVIRONMENTAL REPORT *****************");
		log.info("***************** DELETE THE NEWLY CREATED ENVIRONMENTAL REPORT *****************");

		try {

			// enter the property name in the search field
			type("envreports_propertylist_filtertxt_CSS", data.get("property_4"));
			ngDriver.waitForAngularRequestsToFinish();
			System.out.println("Entered the property name in the search field.");

			// click on the environmental icon
			click("environmentalicon_CSS");
			System.out.println("Clicked on the environmental icon.");
			ngDriver.waitForAngularRequestsToFinish();

			// wait for the element
			explicitWaitClickable("ssc_leftsidemenubtn_CSS");

			// click on the side menu
			click("ssc_leftsidemenubtn_CSS");
			ngDriver.waitForAngularRequestsToFinish();
			System.out.println("Clicked on the side menu.");

			// wait for the element
			explicitWaitClickable("envreportoption_XPATH");

			// click on the environmental report
			click("envreportoption_XPATH");
			ngDriver.waitForAngularRequestsToFinish();
			System.out.println("Clicked on the environmental report.");

			// enter environmental report in the search field
			clear("task_listofchecklist_filterfield_CSS");
			type("task_listofchecklist_filterfield_CSS", data.get("title"));
			ngDriver.waitForAngularRequestsToFinish();
			System.out.println("Entered environmental report in the search field.");

			// click on the environmental report
			click("environmental_searchedreport_psd1_XPATH");
			ngDriver.waitForAngularRequestsToFinish();
			System.out.println("Clicked on the environmental report.");

			// wait for the element
			explicitWaitClickable("envreportdeletebtn_CSS");

			// click on the delete button
			click("envreportdeletebtn_CSS");
			System.out.println("Clicked on the Delete Button.");
			ngDriver.waitForAngularRequestsToFinish();
			System.out.println("The confirmation pop up model is displayed.");

			// wait for the element
			explicitWaitClickable("envreportmodeldeletebtn_CSS");

			// click on the delete button of the confirmation model
			click("envreportmodeldeletebtn_CSS");
			System.out.println("Clicked on the Delete Button of the confirmation popup model.");
			ngDriver.waitForAngularRequestsToFinish();

			// wait for the element
			explicitWaitClickable("closetoastmsg_CSS");

			// click on the toaster close button
			click("closetoastmsg_CSS");
			ngDriver.waitForAngularRequestsToFinish();
			System.out.println("Clicked on the toaster close button.");

			// enter the newly created environmental report in the search field
			clear("task_listofchecklist_filterfield_CSS");
			type("task_listofchecklist_filterfield_CSS", data.get("title"));
			System.out.println("Entered the newly updated environmental report in the search field.");
			ngDriver.waitForAngularRequestsToFinish();

			// verification of the environmental report is deleted or not
			deleteVerification("environmental_searchedreport_psd1_XPATH", "Test Environmental Report PSD 1");

		} catch (Throwable t) {
			verificationFailed();
		}

		// click on the home icon from the top of the screen
		click("questionnaire_homeburgermenubtn_hide_CSS");
		System.out.println("Clicked on the home icon from the top of the screen.");
		ngDriver.waitForAngularRequestsToFinish();

		// wait for the element
		explicitWait("propertylist_title_XPATH");

		// verify the property list
		switchVerification("propertylist_title_XPATH", "Property List", "The property list is not displayed.");

		// DELETE THE NEWLY CREATED TASK FROM THE TASK MODULE

		System.out.println("***************** DELETE THE NEWLY CREATED TASK FROM THE TASK MODULE *****************");
		test.log(LogStatus.INFO,
				"***************** DELETE THE NEWLY CREATED TASK FROM THE TASK MODULE *****************");
		Reporter.log("***************** DELETE THE NEWLY CREATED TASK FROM THE TASK MODULE *****************");
		log.info("***************** DELETE THE NEWLY CREATED TASK FROM THE TASK MODULE *****************");

		try {
			// enter the property name in the search field
			clear("envreports_propertylist_filtertxt_CSS");
			type("envreports_propertylist_filtertxt_CSS", data.get("property_4"));
			ngDriver.waitForAngularRequestsToFinish();
			System.out.println("Entered the property name in the search field.");

			// click on the task icon
			click("taskicon_CSS");
			System.out.println("Clicked on the task icon.");
			ngDriver.waitForAngularRequestsToFinish();

			// click on the clear button
			click("task_createdtask_clearbtn_XPATH");
			ngDriver.waitForAngularRequestsToFinish();
			System.out.println("Selected the newly created task.");

			// type the newly created task in the search field
			type("task_filter_CSS", data.get("task_title"));
			ngDriver.waitForAngularRequestsToFinish();
			System.out.println("Selected the newly created task.");

			// click on the search button
			click("task_createdtask_searchbtn_XPATH");
			ngDriver.waitForAngularRequestsToFinish();
			System.out.println("Clicked on the search button.");

			// verify newly created task is displayed or not
			switchVerification("environmental_task_createdtask1_psd1_XPATH", "Task Environmental Report PSD 1",
					"The Task Environmental Report PSD 1 is not displayed.");

			// click on the searched task
			click("environmental_task_createdtask1_psd1_XPATH");
			ngDriver.waitForAngularRequestsToFinish();
			System.out.println("Clicked on the searched task.");

			// click on the start button
			click("environmental_task_startbtn_XPATH");
			ngDriver.waitForAngularRequestsToFinish();
			System.out.println("Clicked on the start button.");

			// wait for the element
			explicitWaitClickable("closetoastmsg_CSS");

			// click on the toaster close button
			click("closetoastmsg_CSS");
			ngDriver.waitForAngularRequestsToFinish();
			System.out.println("Clicked on the toaster close button.");

			// click on the update task button
			click("environmental_task_submitbtn_XPATH");
			ngDriver.waitForAngularRequestsToFinish();
			System.out.println("Clicked on the save Button.");

			// wait for the element
			Thread.sleep(5000);

			// click on the clear button
			click("task_createdtask_clearbtn_XPATH");
			ngDriver.waitForAngularRequestsToFinish();
			System.out.println("Selected the newly created task.");

			// type the newly created task in the search field
			type("task_filter_CSS", data.get("task_title"));
			ngDriver.waitForAngularRequestsToFinish();
			System.out.println("Selected the newly created task.");

			// click on the search button
			click("task_createdtask_searchbtn_XPATH");
			ngDriver.waitForAngularRequestsToFinish();
			System.out.println("Clicked on the search button.");

			// verify newly created task is displayed or not
			switchVerification("environmental_task_createdtask1_psd1_XPATH", "Task Environmental Report PSD 1",
					"The Task Environmental Report PSD 1 is not displayed.");

			// click on the action icon of the searched task
			String actionicon1 = "//p[text()='" + data.get("task_title")
					+ "']//parent::td[@ng-click='editTaskFromLandingPage(task)']//following-sibling::td[@class='text-center pointer']//i[@data-toggle='dropdown']";
			driver.findElement(By.xpath(actionicon1)).click();
			ngDriver.waitForAngularRequestsToFinish();
			System.out.println("Clicked on the action icon of the searched task.");

			// click on the delete task option
			String deleteTaskOption = "//p[text()='" + data.get("task_title")
					+ "']//parent::td[@ng-click='editTaskFromLandingPage(task)']//following-sibling::td[@class='text-center pointer']//div[@class='dropdown open']//li[@ng-click='deleteSelectedTask(task.id, false);']";
			driver.findElement(By.xpath(deleteTaskOption)).click();
			ngDriver.waitForAngularRequestsToFinish();
			System.out.println("Clicked on the delete task option.");

			// wait for the element
			explicitWaitClickable("closetoastmsg_CSS");

			// click on the toaster close button
			click("closetoastmsg_CSS");
			ngDriver.waitForAngularRequestsToFinish();
			System.out.println("Clicked on the toaster close button.");

			// click on the clear button
			click("task_createdtask_clearbtn_XPATH");
			ngDriver.waitForAngularRequestsToFinish();
			System.out.println("Selected the newly created task.");

			// type the newly created task in the search field
			type("task_filter_CSS", data.get("task_title"));
			ngDriver.waitForAngularRequestsToFinish();
			System.out.println("Selected the newly created task.");

			// click on the search button
			click("task_createdtask_searchbtn_XPATH");
			ngDriver.waitForAngularRequestsToFinish();
			System.out.println("Clicked on the search button.");

			// verify newly created task is displayed or not
			deleteVerification("environmental_task_createdtask1_psd1_XPATH", "Task Environmental Report PSD 1");

		} catch (Throwable t) {
			verificationFailed();
		}

		// click on the home icon from the top of the screen
		click("questionnaire_homeburgermenubtn_hide_CSS");
		System.out.println("Clicked on the home icon from the top of the screen.");
		ngDriver.waitForAngularRequestsToFinish();

		// wait for the element
		explicitWait("propertylist_title_XPATH");

		// verify the property list
		switchVerification("propertylist_title_XPATH", "Property List", "The property list is not displayed.");

		// RESET THE CERTIFICATE OF APPROVAL REPORT CONFIGURATION

		System.out.println(
				"******************** RESET THE CERTIFICATE OF APPROVAL REPORT CONFIGURATION ********************");
		test.log(LogStatus.INFO,
				"******************** RESET THE CERTIFICATE OF APPROVAL REPORT CONFIGURATION ********************");
		Reporter.log(
				"******************** RESET THE CERTIFICATE OF APPROVAL REPORT CONFIGURATION ********************");
		log.info("******************** RESET THE CERTIFICATE OF APPROVAL REPORT CONFIGURATION ********************");

		try {
			// wait for the element
			explicitWaitClickable("questionnaire_settingicon_CSS");

			// click on the settings icon from the top of the screen
			click("questionnaire_settingicon_CSS");
			System.out.println("Clicked on the settings icon.");
			ngDriver.waitForAngularRequestsToFinish();

			// wait for the element
			explicitWaitClickable("questionnaire_administrationoption_XPATH");

			// click on the administration option from the side menu
			click("questionnaire_administrationoption_XPATH");
			System.out.println("Clicked on the administration option from the side menu.");
			ngDriver.waitForAngularRequestsToFinish();

			// click on the environmental tab
			click("questionnaire_environmentaltab_XPATH");
			ngDriver.waitForAngularRequestsToFinish();
			System.out.println("Clicked on the environmental tab.");

			// click on the environmental reports option
			click("questionnaire_environmentalreportsoption_XPATH");
			ngDriver.waitForAngularRequestsToFinish();
			System.out.println("Clicked on the environmental reports option.");

			// scroll down to the screen
			WebElement dropdown = driver.findElement(
					By.xpath(OR.getProperty("environmental_reportlist_certificationofapproval_dropdown_XPATH")));
			JavascriptExecutor js = (JavascriptExecutor) driver;
			js.executeScript("arguments[0].scrollIntoView(true);", dropdown);
			js.executeScript("window.scrollBy(0,-400)");

			// click on the drop down of the Certificate of Approval report
			click("environmental_reportlist_certificationofapproval_dropdown_XPATH");
			ngDriver.waitForAngularRequestsToFinish();
			System.out.println("Clicked on the drop down of the Certificate of Approval report.");

			// click on the other options option
			click("environmental_reportlist_certificationofapproval_dropdown_otheroption_XPATH");
			ngDriver.waitForAngularRequestsToFinish();
			System.out.println("Clicked on the other options option.");

			// enter the data in the report frequency field
			clear("environmental_reportlist_environmentalactionreporttext_reportfrequencytxt_CSS");
			type("environmental_reportlist_environmentalactionreporttext_reportfrequencytxt_CSS", "5");
			ngDriver.waitForAngularRequestsToFinish();
			System.out.println("Entered the data in the report frequency field.");

			// select the year option from the report period drop down
			select("environmental_reportlist_environmentalactionreporttext_reportPerioddd_CSS", "Year");
			ngDriver.waitForAngularRequestsToFinish();
			System.out.println("Selected the year option from the report period drop down.");

			// click on the save button
			click("environmental_reportlist_environmentalactionreporttext_savebtn_XPATH");
			ngDriver.waitForAngularRequestsToFinish();
			System.out.println("Clicked on the save button.");

			// wait for the element
			explicitWaitClickable("closetoastmsg_CSS");

			// click on the toaster close button
			click("closetoastmsg_CSS");
			ngDriver.waitForAngularRequestsToFinish();
			System.out.println("Clicked on the toaster close button.");

		} catch (Throwable t) {
			verificationFailed();
		}

		// click on the home icon from the top of the screen
		click("questionnaire_homeburgermenubtn_CSS");
		System.out.println("Clicked on the home icon from the top of the screen.");
		ngDriver.waitForAngularRequestsToFinish();

		// synchronization
		explicitWait("propertylist_title_XPATH");

		// verify the property list
		switchVerification("propertylist_title_XPATH", "Property List", "The property list is not displayed.");

		// RUN THE BATCH PROCESS FOR THE ENVIRONMENTAL REPORTS - SUPER ADMIN USER

		System.out.println(
				"******************** RUN THE BATCH PROCESS FOR THE ENVIRONMENTAL REPORTS - SUPER ADMIN USER ********************");
		test.log(LogStatus.INFO,
				"******************** RUN THE BATCH PROCESS FOR THE ENVIRONMENTAL REPORTS - SUPER ADMIN USER ********************");
		Reporter.log(
				"******************** RUN THE BATCH PROCESS FOR THE ENVIRONMENTAL REPORTS - SUPER ADMIN USER ********************");
		log.info(
				"******************** RUN THE BATCH PROCESS FOR THE ENVIRONMENTAL REPORTS - SUPER ADMIN USER ********************");

		try {
			// wait for the 5 seconds
			Thread.sleep(5000);

			// click on the settings icon from the top of the screen
			click("questionnaire_settingicon_CSS");
			System.out.println("Clicked on the settings icon.");
			ngDriver.waitForAngularRequestsToFinish();

			// wait for the 5 seconds
			Thread.sleep(5000);

			// click on the administration option from the side menu
			click("questionnaire_administrationoption_XPATH");
			System.out.println("Clicked on the administration option from the side menu.");
			ngDriver.waitForAngularRequestsToFinish();

			// click on the system tab
			click("questionnaire_systemtab_XPATH");
			ngDriver.waitForAngularRequestsToFinish();
			System.out.println("Clicked on the system tab.");

			// click on the batch process option
			click("questionnaire_batchprocessoption_XPATH");
			ngDriver.waitForAngularRequestsToFinish();
			System.out.println("Clicked on the batch process option.");

			// enter batch process name in the search field
			clear("ssc_company2_securitysettings_filtertxt_CSS");
			ngDriver.waitForAngularRequestsToFinish();
			System.out.println("Cleared the search field.");
			type("ssc_company2_securitysettings_filtertxt_CSS", data.get("batch_process"));
			ngDriver.waitForAngularRequestsToFinish();
			System.out.println("Entered batch process name in the search field.");

			// click on the play button of searched batch process
			click("batchprocess_environmentalreport_playbtn_XPATH");
			ngDriver.waitForAngularRequestsToFinish();
			System.out.println("Clicked on the play button of searched batch process.");

			// click on the run button
			click("batchprocess_environmentalreport_runbtn_XPATH");
			ngDriver.waitForAngularRequestsToFinish();
			System.out.println("Clicked on the run button.");

			// wait for the element
			explicitWaitClickable("closetoastmsg_CSS");

			// click on the toaster close button
			click("closetoastmsg_CSS");
			ngDriver.waitForAngularRequestsToFinish();
			System.out.println("Clicked on the toaster close button.");

		} catch (Throwable t) {
			verificationFailed();
		}

		// click on the home icon from the top of the screen
		click("questionnaire_homeburgermenubtn_CSS");
		System.out.println("Clicked on the home icon from the top of the screen.");
		ngDriver.waitForAngularRequestsToFinish();

		// synchronization
		explicitWait("propertylist_title_XPATH");

		// verify the property list
		switchVerification("propertylist_title_XPATH", "Property List", "The property list is not displayed.");

		try {
			// wait for the element
			explicitWaitClickable("questionnaire_settingicon_CSS");

			// click on the settings icon from the top of the screen
			click("questionnaire_settingicon_CSS");
			System.out.println("Clicked on the settings icon.");
			ngDriver.waitForAngularRequestsToFinish();

			// wait for the element
			explicitWaitClickable("sidemenu_logout_CSS");

			// click on the logout option from the side menu
			click("sidemenu_logout_CSS");
			System.out.println("Clicked on the logout option from the side menu.");
			ngDriver.waitForAngularRequestsToFinish();

			// wait for the element
			explicitWaitClickable("signinbtn_BTNTEXT");

		} catch (Throwable t) {
			verificationFailed();
		}

	}
}
