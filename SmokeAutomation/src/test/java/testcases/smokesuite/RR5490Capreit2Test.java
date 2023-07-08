package testcases.smokesuite;

import java.io.IOException;
import java.time.LocalDate;
import java.util.Date;
import java.util.Hashtable;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.SkipException;
import org.testng.annotations.Test;

import com.relevantcodes.extentreports.LogStatus;

import base.TestBase;
import utilities.TestUtil;

public class RR5490Capreit2Test extends TestBase {

	String finalNotAvailableCount1 = null;
	String finalNotApplicableCount1 = null;
	String finalOverDueTaskCount1 = null;
	String finalNotAvailableCount2 = null;
	String finalNotApplicableCount2 = null;
	String finalOverDueTaskCount2 = null;

	@Test(dataProviderClass = TestUtil.class, dataProvider = "dp")
	public void rR5490Capreit2Test(Hashtable<String, String> data) throws IOException, InterruptedException {

		if (!(TestUtil.isTestRunnable("rR5490Capreit2Test", excel))) {

			throw new SkipException(
					"Skipping the test " + "rR5490Capreit2Test".toUpperCase() + "as the Run mode is NO");
		}

		if (!data.get("runmode").equals("Y")) {

			throw new SkipException("Skipping the test case as the Run Mode for data set is NO");
		}

		// refresh the page
		driver.navigate().refresh();
		Thread.sleep(5000);
		driver.navigate().refresh();

		// CAPREIT : TEST SCENARIOS RELATED TO THE ENVIRONMENTAL (TASK AND EXCLUDED
		// PROPERTY) - DOCUMENT MANAGEMENT

		System.out.println(
				"******************** CAPREIT : TEST SCENARIOS RELATED TO THE ENVIRONMENTAL (TASK AND EXCLUDED PROPERTY) - DOCUMENT MANAGEMENT ********************");
		test.log(LogStatus.INFO,
				"******************** CAPREIT : TEST SCENARIOS RELATED TO THE ENVIRONMENTAL (TASK AND EXCLUDED PROPERTY) - DOCUMENT MANAGEMENT ********************");
		Reporter.log(
				"******************** CAPREIT : TEST SCENARIOS RELATED TO THE ENVIRONMENTAL (TASK AND EXCLUDED PROPERTY) - DOCUMENT MANAGEMENT ********************");
		log.info(
				"******************** CAPREIT : TEST SCENARIOS RELATED TO THE ENVIRONMENTAL (TASK AND EXCLUDED PROPERTY) - DOCUMENT MANAGEMENT ********************");

		System.out.println("Navigate to the Home Screen i.e. Property List Screen.");

		// LOGIN WITH ADMIN USER

		System.out.println("******************** LOGIN WITH ADMIN USER ********************");
		test.log(LogStatus.INFO, "******************** LOGIN WITH ADMIN USER ********************");
		Reporter.log("******************** LOGIN WITH ADMIN USER ********************");
		log.info("******************** LOGIN WITH ADMIN USER ********************");

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

		// SET THE ENVIRONMENTAL REPORT FREQUENCY - SUPER ADMIN USER

		System.out.println(
				"******************** SET THE ENVIRONMENTAL REPORT FREQUENCY - SUPER ADMIN USER ********************");
		test.log(LogStatus.INFO,
				"******************** SET THE ENVIRONMENTAL REPORT FREQUENCY - SUPER ADMIN USER ********************");
		Reporter.log(
				"******************** SET THE ENVIRONMENTAL REPORT FREQUENCY - SUPER ADMIN USER ********************");
		log.info("******************** SET THE ENVIRONMENTAL REPORT FREQUENCY - SUPER ADMIN USER ********************");

		try {

			// wait for the 5 seconds
			Thread.sleep(5000);

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
					By.xpath(OR.getProperty("environmental_reportlist_environmentalactionreporttext_dropdown_XPATH")));
			JavascriptExecutor js = (JavascriptExecutor) driver;
			js.executeScript("arguments[0].scrollIntoView(true);", dropdown);
			js.executeScript("window.scrollBy(0,-400)");

			// click on the drop down of the Environmental Action Report report
			click("environmental_reportlist_environmentalactionreporttext_dropdown_XPATH");
			ngDriver.waitForAngularRequestsToFinish();
			System.out.println("Clicked on the drop down of the Environmental Action Report report.");

			// click on the other options option
			click("environmental_reportlist_environmentalactionreporttext_dropdown_otheroption_XPATH");
			ngDriver.waitForAngularRequestsToFinish();
			System.out.println("Clicked on the other options option.");

			// select the level of the environmental report
			select("envreport_leveldd_CSS", data.get("document_reference"));
			ngDriver.waitForAngularRequestsToFinish();
			System.out.println("Selected the level of the environmental report.");

			// enter the data in the report frequency field
			clear("environmental_reportlist_environmentalactionreporttext_reportfrequencytxt_CSS");
			type("environmental_reportlist_environmentalactionreporttext_reportfrequencytxt_CSS", "1");
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
			// wait for the 7 seconds
			Thread.sleep(7000);

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

		// VERIFY ENVIRONMENTAL CARD ON THE PORTFOLIO SUMMARY DASHBOARD SCREEN AFTER
		// SETUP THE CONFIGURATION - SUPER ADMIN USER

		System.out.println(
				"******************** VERIFY ENVIRONMENTAL CARD ON THE PORTFOLIO SUMMARY DASHBOARD SCREEN AFTER SETUP THE CONFIGURATION - SUPER ADMIN USER ********************");
		test.log(LogStatus.INFO,
				"******************** VERIFY ENVIRONMENTAL CARD ON THE PORTFOLIO SUMMARY DASHBOARD SCREEN AFTER SETUP THE CONFIGURATION - SUPER ADMIN USER ********************");
		Reporter.log(
				"******************** VERIFY ENVIRONMENTAL CARD ON THE PORTFOLIO SUMMARY DASHBOARD SCREEN AFTER SETUP THE CONFIGURATION - SUPER ADMIN USER ********************");
		log.info(
				"******************** VERIFY ENVIRONMENTAL CARD ON THE PORTFOLIO SUMMARY DASHBOARD SCREEN AFTER SETUP THE CONFIGURATION - SUPER ADMIN USER ********************");

		try {

			// wait for the element
			Thread.sleep(5000);

			// click on the side menu
			click("menubtn_CSS");
			ngDriver.waitForAngularRequestsToFinish();
			System.out.println("Clicked on the side menu.");

			// wait for the element
			Thread.sleep(5000);

			// click on the portfolio summary option
			click("sidemenu_portfoliosummary_XPATH");
			ngDriver.waitForAngularRequestsToFinish();
			System.out.println("Clicked on the portfolio summary option.");

			try {
				// scroll down the screen
				JavascriptExecutor js = (JavascriptExecutor) driver;
				WebElement environmentalactionreport = driver.findElement(
						By.xpath(OR.getProperty("portfoliodashboard_environmentalactionreportcard_XPATH")));
				js.executeScript("arguments[0].scrollIntoView(true);", environmentalactionreport);

				switchVerification("portfoliodashboard_environmentalactionreportcard_XPATH",
						"Environmental Action Report", "The Environmental Action Report is not displayed.");

				System.out.println("THE ENVIRONMENTAL ACTION REPORT CARD IS DISPLAYED SUCCESSFULLY.");
				test.log(LogStatus.INFO, "THE ENVIRONMENTAL ACTION REPORT CARD IS DISPLAYED SUCCESSFULLY.");
				Reporter.log("THE ENVIRONMENTAL ACTION REPORT CARD IS DISPLAYED SUCCESSFULLY.");
				log.info("THE ENVIRONMENTAL ACTION REPORT CARD IS DISPLAYED SUCCESSFULLY.");

				String notAvailableCount1 = driver
						.findElement(By.cssSelector(OR.getProperty("environmental_notavailablecount_CSS"))).getText();

				finalNotAvailableCount1 = notAvailableCount1.trim();

				String notApplicableCount1 = driver
						.findElement(By.cssSelector(OR.getProperty("environmental_notapplicablecount_CSS"))).getText();

				finalNotApplicableCount1 = notApplicableCount1.trim();

				String overDueTaskCount1 = driver
						.findElement(By.cssSelector(OR.getProperty("environmental_overduetaskcount_CSS"))).getText();

				finalOverDueTaskCount1 = overDueTaskCount1.trim();

			} catch (Throwable t) {

				TestUtil.captureScreenshot();

				// ReportNG
				Reporter.log("<br>"
						+ " The Environmental Action Report environmental card is not displayed even if the setup the configuration : "
						+ "<br>");
				Reporter.log("<a target=\"_blank\" href=" + TestUtil.screenshotName + "><img src="
						+ TestUtil.screenshotName + " height=200 width=200></img></a>");
				Reporter.log("<br>");
				Reporter.log("<br>");

				// Extent Report
				test.log(LogStatus.FAIL,
						" The Environmental Action Report environmental card is not displayed even if the setup the configuration : ");
				test.log(LogStatus.FAIL, test.addScreenCapture(TestUtil.screenshotName));

				System.out.println(
						"The Environmental Action Report environmental card is not displayed even if the setup the configuration.");
				log.info(
						"The Environmental Action Report environmental card is not displayed even if the setup the configuration.");

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

		// VERIFY ENVIRONMENTAL CARD ON THE ASSESSMENTS/INSPECTIONS DASHBOARD OF THE
		// ENVIRONMENTAL MODULE AFTER SETUP THE CONFIGURATION - SUPER ADMIN USER

		System.out.println(
				"******************** VERIFY ENVIRONMENTAL CARD ON THE ASSESSMENTS/INSPECTIONS DASHBOARD OF THE ENVIRONMENTAL MODULE AFTER SETUP THE CONFIGURATION - SUPER ADMIN USER ********************");
		test.log(LogStatus.INFO,
				"******************** VERIFY ENVIRONMENTAL CARD ON THE ASSESSMENTS/INSPECTIONS DASHBOARD OF THE ENVIRONMENTAL MODULE AFTER SETUP THE CONFIGURATION - SUPER ADMIN USER ********************");
		Reporter.log(
				"******************** VERIFY ENVIRONMENTAL CARD ON THE ASSESSMENTS/INSPECTIONS DASHBOARD OF THE ENVIRONMENTAL MODULE AFTER SETUP THE CONFIGURATION - SUPER ADMIN USER ********************");
		log.info(
				"******************** VERIFY ENVIRONMENTAL CARD ON THE ASSESSMENTS/INSPECTIONS DASHBOARD OF THE ENVIRONMENTAL MODULE AFTER SETUP THE CONFIGURATION - SUPER ADMIN USER ********************");

		try {

			// wait for the element
			Thread.sleep(5000);

			// click on the side menu
			click("menubtn_CSS");
			ngDriver.waitForAngularRequestsToFinish();
			System.out.println("Clicked on the side menu.");

			// wait for the element
			Thread.sleep(5000);

			// click on the environmental option
			click("sidemenu_environmental_XPATH");
			ngDriver.waitForAngularRequestsToFinish();
			System.out.println("Clicked on the environmental option.");

			// select the Assessments/Inspections option from the dashbaord drop down
			select("dashboard_CSS", data.get("dashboard_2"));
			ngDriver.waitForAngularRequestsToFinish();
			System.out.println("Selected the Assessments/Inspections option from the dashbaord drop down.");

			// wait for the 3 seconds
			Thread.sleep(3000);

			try {
				// scroll down the screen
				JavascriptExecutor js = (JavascriptExecutor) driver;
				WebElement environmentalactionreport = driver.findElement(
						By.xpath(OR.getProperty("portfoliodashboard_environmentalactionreportcard_XPATH")));
				js.executeScript("arguments[0].scrollIntoView(true);", environmentalactionreport);

				switchVerification("portfoliodashboard_environmentalactionreportcard_XPATH",
						"Environmental Action Report", "The Environmental Action Report is not displayed.");

				System.out.println("THE ENVIRONMENTAL ACTION REPORT CARD IS DISPLAYED SUCCESSFULLY.");
				test.log(LogStatus.INFO, "THE ENVIRONMENTAL ACTION REPORT CARD IS DISPLAYED SUCCESSFULLY.");
				Reporter.log("THE ENVIRONMENTAL ACTION REPORT CARD IS DISPLAYED SUCCESSFULLY.");
				log.info("THE ENVIRONMENTAL ACTION REPORT CARD IS DISPLAYED SUCCESSFULLY.");

				String notAvailableCount2 = driver
						.findElement(By.cssSelector(OR.getProperty("environmental_notavailablecount_CSS"))).getText();

				finalNotAvailableCount2 = notAvailableCount2.trim();

				String notApplicableCount2 = driver
						.findElement(By.cssSelector(OR.getProperty("environmental_notapplicablecount_CSS"))).getText();

				finalNotApplicableCount2 = notApplicableCount2.trim();

				String overDueTaskCount2 = driver
						.findElement(By.cssSelector(OR.getProperty("environmental_overduetaskcount_CSS"))).getText();

				finalOverDueTaskCount2 = overDueTaskCount2.trim();

			} catch (Throwable t) {

				TestUtil.captureScreenshot();

				// ReportNG
				Reporter.log("<br>"
						+ " The Environmental Action Report environmental card is not displayed even if the setup the configuration : "
						+ "<br>");
				Reporter.log("<a target=\"_blank\" href=" + TestUtil.screenshotName + "><img src="
						+ TestUtil.screenshotName + " height=200 width=200></img></a>");
				Reporter.log("<br>");
				Reporter.log("<br>");

				// Extent Report
				test.log(LogStatus.FAIL,
						" The Environmental Action Report environmental card is not displayed even if the setup the configuration : ");
				test.log(LogStatus.FAIL, test.addScreenCapture(TestUtil.screenshotName));

				System.out.println(
						"The Environmental Action Report environmental card is not displayed even if the setup the configuration.");
				log.info(
						"The Environmental Action Report environmental card is not displayed even if the setup the configuration.");

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

		// CREATE ENVIRONMENTAL REPORT - SUPER ADMIN USER

		System.out.println("******************** CREATE ENVIRONMENTAL REPORT - SUPER ADMIN USER ********************");
		test.log(LogStatus.INFO,
				"******************** CREATE ENVIRONMENTAL REPORT - SUPER ADMIN USER ********************");
		Reporter.log("******************** CREATE ENVIRONMENTAL REPORT - SUPER ADMIN USER ********************");
		log.info("******************** CREATE ENVIRONMENTAL REPORT - SUPER ADMIN USER ********************");

		try {

			// enter the property name in the search field
			clear("envreports_propertylist_filtertxt_CSS");
			type("envreports_propertylist_filtertxt_CSS", data.get("property_1"));
			ngDriver.waitForAngularRequestsToFinish();
			System.out.println("Entered the property name in the search field.");

			// click on the environmental icon
			click("environmentalicon_CSS");
			System.out.println("Clicked on the environmental icon.");
			ngDriver.waitForAngularRequestsToFinish();

			// wait for the element
			Thread.sleep(5000);

			// click on the side menu
			click("ssc_leftsidemenubtn_CSS");
			ngDriver.waitForAngularRequestsToFinish();
			System.out.println("Clicked on the side menu.");

			// wait for the element
			Thread.sleep(5000);

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

			// enter unique reference number
			clear("envreportuniquereferencedd_CSS");
			type("envreportuniquereferencedd_CSS", data.get("unique_reference"));
			ngDriver.waitForAngularRequestsToFinish();
			System.out.println("Entered unique reference number.");

			// enter the title
			clear("envreporttitletxt_CSS");
			type("envreporttitletxt_CSS", data.get("title"));
			ngDriver.waitForAngularRequestsToFinish();
			System.out.println("The data entered in the Title field.");

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

			// enter the newly created environmental report in the search field
			clear("task_listofchecklist_filterfield_CSS");
			type("task_listofchecklist_filterfield_CSS", data.get("title"));
			ngDriver.waitForAngularRequestsToFinish();
			System.out.println("Entered the newly created environmental report in the search field.");

			// verify the newly created environmental report is displayed or not
			switchVerification("environmental_searchedreport2_XPATH", "Test Environmental Report Count 2",
					"The Test Environmental Report Count 2 is not displayed.");

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

		// ADD TASK IN THE NEWLY CREATED ENVIRONMENTAL REPORT - SUPER ADMIN USER

		System.out.println(
				"******************** ADD TASK IN THE NEWLY CREATED ENVIRONMENTAL REPORT - SUPER ADMIN USER ********************");
		test.log(LogStatus.INFO,
				"******************** ADD TASK IN THE NEWLY CREATED ENVIRONMENTAL REPORT - SUPER ADMIN USER ********************");
		Reporter.log(
				"******************** ADD TASK IN THE NEWLY CREATED ENVIRONMENTAL REPORT - SUPER ADMIN USER ********************");
		log.info(
				"******************** ADD TASK IN THE NEWLY CREATED ENVIRONMENTAL REPORT - SUPER ADMIN USER ********************");

		try {

			// enter the property name in the search field
			clear("envreports_propertylist_filtertxt_CSS");
			type("envreports_propertylist_filtertxt_CSS", data.get("property_1"));
			ngDriver.waitForAngularRequestsToFinish();
			System.out.println("Entered the property name in the search field.");

			// click on the environmental icon
			click("environmentalicon_CSS");
			System.out.println("Clicked on the environmental icon.");
			ngDriver.waitForAngularRequestsToFinish();

			// wait for the element
			Thread.sleep(5000);

			// click on the side menu
			click("ssc_leftsidemenubtn_CSS");
			ngDriver.waitForAngularRequestsToFinish();
			System.out.println("Clicked on the side menu.");

			// wait for the element
			Thread.sleep(5000);

			// click on the environmental report
			click("envreportoption_XPATH");
			ngDriver.waitForAngularRequestsToFinish();
			System.out.println("Clicked on the environmental report.");

			// enter the newly created environmental report in the search field
			clear("task_listofchecklist_filterfield_CSS");
			type("task_listofchecklist_filterfield_CSS", data.get("title"));
			ngDriver.waitForAngularRequestsToFinish();
			System.out.println("Entered the newly created environmental report in the search field.");

			// click on the newly created environmental report
			click("environmental_searchedreport2_XPATH");
			ngDriver.waitForAngularRequestsToFinish();
			System.out.println("Clicked on the newly created environmental report.");

			// click on the tasks tab
			click("envreportaddedrecord_tasktab_XPATH");
			ngDriver.waitForAngularRequestsToFinish();
			System.out.println("Clicked on the tasks tab.");

			// click on the new task button
			click("envreport_task_newtaskbtn_CSS");
			ngDriver.waitForAngularRequestsToFinish();
			System.out.println("Clicked on the new task button.");

			// enter task title
			clear("environmental_task_titletxt_CSS");
			type("environmental_task_titletxt_CSS", data.get("task_title"));
			ngDriver.waitForAngularRequestsToFinish();
			System.out.println("Entered task title.");

			// scroll down the screen
			JavascriptExecutor js = (JavascriptExecutor) driver;
			js.executeScript("window.scrollBy(0,200)");

			// click on the due date field
			click("environmental_task_duedatetxt_CSS");
			ngDriver.waitForAngularRequestsToFinish();
			System.out.println("Clicked on the due date field.");

			// click on the year button
			click("environmental_task_yearbtn_XPATH");
			ngDriver.waitForAngularRequestsToFinish();
			System.out.println("Clicked on the year button.");

			// click on the previous button
			click("environmental_task_yearbtn_previousbtn_XPATH");
			ngDriver.waitForAngularRequestsToFinish();
			System.out.println("Clicked on the previous button.");

			// click on the previous button
			click("environmental_task_yearbtn_previousbtn_XPATH");
			ngDriver.waitForAngularRequestsToFinish();
			System.out.println("Clicked on the previous button.");

			// click on the December month button
			click("environmental_task_yearbtn_monthbtn_XPATH");
			ngDriver.waitForAngularRequestsToFinish();
			System.out.println("Clicked on the December month button.");

			// click on the 31th day button
			click("environmental_task_yearbtn_daybtn_XPATH");
			ngDriver.waitForAngularRequestsToFinish();
			System.out.println("Clicked on the 31th day button.");

			// click on the save button
			click("environmental_task_savebtn_XPATH");
			ngDriver.waitForAngularRequestsToFinish();
			System.out.println("Clicked on the save button.");

			// wait for the element
			Thread.sleep(5000);

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

			// enter the newly created environmental report in the search field
			clear("task_listofchecklist_filterfield_CSS");
			type("task_listofchecklist_filterfield_CSS", data.get("title"));
			ngDriver.waitForAngularRequestsToFinish();
			System.out.println("Entered the newly created environmental report in the search field.");

			// verify the newly created environmental report is displayed or not
			switchVerification("environmental_searchedreport2_XPATH", "Test Environmental Report Count 2",
					"The Test Environmental Report Count 2 is not displayed.");

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

		// VERIFY ENVIRONMENTAL CARD ON THE PORTFOLIO SUMMARY DASHBOARD SCREEN AFTER
		// CREATING THE NEW ENVIRONMENTAL REPORT AND TASK - SUPER ADMIN USER

		System.out.println(
				"******************** VERIFY ENVIRONMENTAL CARD ON THE PORTFOLIO SUMMARY DASHBOARD SCREEN AFTER CREATING THE NEW ENVIRONMENTAL REPORT AND TASK - SUPER ADMIN USER ********************");
		test.log(LogStatus.INFO,
				"******************** VERIFY ENVIRONMENTAL CARD ON THE PORTFOLIO SUMMARY DASHBOARD SCREEN AFTER CREATING THE NEW ENVIRONMENTAL REPORT AND TASK - SUPER ADMIN USER ********************");
		Reporter.log(
				"******************** VERIFY ENVIRONMENTAL CARD ON THE PORTFOLIO SUMMARY DASHBOARD SCREEN AFTER CREATING THE NEW ENVIRONMENTAL REPORT AND TASK - SUPER ADMIN USER ********************");
		log.info(
				"******************** VERIFY ENVIRONMENTAL CARD ON THE PORTFOLIO SUMMARY DASHBOARD SCREEN AFTER CREATING THE NEW ENVIRONMENTAL REPORT AND TASK - SUPER ADMIN USER ********************");

		try {

			// wait for the element
			Thread.sleep(5000);

			// click on the side menu
			click("menubtn_CSS");
			ngDriver.waitForAngularRequestsToFinish();
			System.out.println("Clicked on the side menu.");

			// wait for the element
			Thread.sleep(5000);

			// click on the portfolio summary option
			click("sidemenu_portfoliosummary_XPATH");
			ngDriver.waitForAngularRequestsToFinish();
			System.out.println("Clicked on the portfolio summary option.");

			try {
				// scroll down the screen
				JavascriptExecutor js = (JavascriptExecutor) driver;
				WebElement environmentalactionreport = driver.findElement(
						By.xpath(OR.getProperty("portfoliodashboard_environmentalactionreportcard_XPATH")));
				js.executeScript("arguments[0].scrollIntoView(true);", environmentalactionreport);

				switchVerification("portfoliodashboard_environmentalactionreportcard_XPATH",
						"Environmental Action Report", "The Environmental Action Report is not displayed.");

				System.out.println("THE ENVIRONMENTAL ACTION REPORT CARD IS DISPLAYED SUCCESSFULLY.");
				test.log(LogStatus.INFO, "THE ENVIRONMENTAL ACTION REPORT CARD IS DISPLAYED SUCCESSFULLY.");
				Reporter.log("THE ENVIRONMENTAL ACTION REPORT CARD IS DISPLAYED SUCCESSFULLY.");
				log.info("THE ENVIRONMENTAL ACTION REPORT CARD IS DISPLAYED SUCCESSFULLY.");

				try {
					String notAvailableCount11 = driver
							.findElement(By.cssSelector(OR.getProperty("environmental_notavailablecount_CSS")))
							.getText();

					String finalNotAvailableCount11 = notAvailableCount11.trim();

					int value1 = Integer.parseInt(finalNotAvailableCount1);
					int value2 = Integer.parseInt(finalNotAvailableCount11);

					if (value1 == ((value2) + 1)) {

						System.out.println(
								"NOT AVAILABLE COUNT OF THE ENVIRONMENTAL ACTION REPORT IS DISPLAYED CORRECT.");
						test.log(LogStatus.INFO,
								"NOT AVAILABLE COUNT OF THE ENVIRONMENTAL ACTION REPORT IS DISPLAYED CORRECT.");
						Reporter.log("NOT AVAILABLE COUNT OF THE ENVIRONMENTAL ACTION REPORT IS DISPLAYED CORRECT.");
						log.info("NOT AVAILABLE COUNT OF THE ENVIRONMENTAL ACTION REPORT IS DISPLAYED CORRECT.");

					} else {
						TestUtil.captureScreenshot();

						// ReportNG
						Reporter.log("<br>"
								+ " NOT AVAILABLE COUNT OF THE ENVIRONMENTAL ACTION REPORT IS NOT DISPLAYED CORRECT. : "
								+ "<br>");
						Reporter.log("<a target=\"_blank\" href=" + TestUtil.screenshotName + "><img src="
								+ TestUtil.screenshotName + " height=200 width=200></img></a>");
						Reporter.log("<br>");
						Reporter.log("<br>");

						// Extent Report
						test.log(LogStatus.FAIL,
								" NOT AVAILABLE COUNT OF THE ENVIRONMENTAL ACTION REPORT IS NOT DISPLAYED CORRECT. : ");
						test.log(LogStatus.FAIL, test.addScreenCapture(TestUtil.screenshotName));

						System.out.println(
								"NOT AVAILABLE COUNT OF THE ENVIRONMENTAL ACTION REPORT IS NOT DISPLAYED CORRECT.");
						log.info("NOT AVAILABLE COUNT OF THE ENVIRONMENTAL ACTION REPORT IS NOT DISPLAYED CORRECT.");

					}
				} catch (Throwable t) {
					verificationFailed();
				}

				try {
					String notApplicableCount11 = driver
							.findElement(By.cssSelector(OR.getProperty("environmental_notapplicablecount_CSS")))
							.getText();

					String finalNotApplicableCount11 = notApplicableCount11.trim();

					int value1_1 = Integer.parseInt(finalNotApplicableCount1);
					int value2_1 = Integer.parseInt(finalNotApplicableCount11);

					if (value1_1 == value2_1) {

						System.out.println(
								"NOT APPLICABLE COUNT OF THE ENVIRONMENTAL ACTION REPORT IS DISPLAYED CORRECT.");
						test.log(LogStatus.INFO,
								"NOT APPLICABLE COUNT OF THE ENVIRONMENTAL ACTION REPORT IS DISPLAYED CORRECT.");
						Reporter.log("NOT APPLICABLE COUNT OF THE ENVIRONMENTAL ACTION REPORT IS DISPLAYED CORRECT.");
						log.info("NOT APPLICABLE COUNT OF THE ENVIRONMENTAL ACTION REPORT IS DISPLAYED CORRECT.");

					} else {
						TestUtil.captureScreenshot();

						// ReportNG
						Reporter.log("<br>"
								+ " NOT APPLICABLE COUNT OF THE ENVIRONMENTAL ACTION REPORT IS NOT DISPLAYED CORRECT. : "
								+ "<br>");
						Reporter.log("<a target=\"_blank\" href=" + TestUtil.screenshotName + "><img src="
								+ TestUtil.screenshotName + " height=200 width=200></img></a>");
						Reporter.log("<br>");
						Reporter.log("<br>");

						// Extent Report
						test.log(LogStatus.FAIL,
								" NOT APPLICABLE COUNT OF THE ENVIRONMENTAL ACTION REPORT IS NOT DISPLAYED CORRECT. : ");
						test.log(LogStatus.FAIL, test.addScreenCapture(TestUtil.screenshotName));

						System.out.println(
								"NOT APPLICABLE COUNT OF THE ENVIRONMENTAL ACTION REPORT IS NOT DISPLAYED CORRECT.");
						log.info("NOT APPLICABLE COUNT OF THE ENVIRONMENTAL ACTION REPORT IS NOT DISPLAYED CORRECT.");

					}
				} catch (Throwable t) {
					verificationFailed();
				}

				try {
					String overDueTaskCount11 = driver
							.findElement(By.cssSelector(OR.getProperty("environmental_overduetaskcount_CSS")))
							.getText();

					String finalOverDueTaskCount11 = overDueTaskCount11.trim();

					int value1_11 = Integer.parseInt(finalOverDueTaskCount1);
					int value2_11 = Integer.parseInt(finalOverDueTaskCount11);

					if (value1_11 == (value2_11 - 1)) {

						System.out
								.println("OVERDUE TASK COUNT OF THE ENVIRONMENTAL ACTION REPORT IS DISPLAYED CORRECT.");
						test.log(LogStatus.INFO,
								"OVERDUE TASK COUNT OF THE ENVIRONMENTAL ACTION REPORT IS DISPLAYED CORRECT.");
						Reporter.log("OVERDUE TASK COUNT OF THE ENVIRONMENTAL ACTION REPORT IS DISPLAYED CORRECT.");
						log.info("OVERDUE TASK COUNT OF THE ENVIRONMENTAL ACTION REPORT IS DISPLAYED CORRECT.");

					} else {
						TestUtil.captureScreenshot();

						// ReportNG
						Reporter.log("<br>"
								+ " OVERDUE TASK COUNT OF THE ENVIRONMENTAL ACTION REPORT IS NOT DISPLAYED CORRECT. : "
								+ "<br>");
						Reporter.log("<a target=\"_blank\" href=" + TestUtil.screenshotName + "><img src="
								+ TestUtil.screenshotName + " height=200 width=200></img></a>");
						Reporter.log("<br>");
						Reporter.log("<br>");

						// Extent Report
						test.log(LogStatus.FAIL,
								" OVERDUE TASK COUNT OF THE ENVIRONMENTAL ACTION REPORT IS NOT DISPLAYED CORRECT. : ");
						test.log(LogStatus.FAIL, test.addScreenCapture(TestUtil.screenshotName));

						System.out.println(
								"OVERDUE TASK COUNT OF THE ENVIRONMENTAL ACTION REPORT IS NOT DISPLAYED CORRECT.");
						log.info("OVERDUE TASK COUNT OF THE ENVIRONMENTAL ACTION REPORT IS NOT DISPLAYED CORRECT.");

					}
				} catch (Throwable t) {
					verificationFailed();
				}

				try {
					// click on the graph of the environmental action report
					click("portfolio_environmentalactionreport_graph_XPATH");
					ngDriver.waitForAngularRequestsToFinish();
					System.out.println("Clicked on the graph of the environmental action report.");

					// enter the property name in the search field
					clear("users_filtertxt_CSS");
					type("users_filtertxt_CSS", data.get("property_1"));
					ngDriver.waitForAngularRequestsToFinish();
					System.out.println("Entered the property name in the search field.");

					boolean greenDot1 = driver
							.findElement(By.xpath(OR.getProperty("portfolio_environmentalactionreport_greendot_XPATH")))
							.isDisplayed();

					if (greenDot1 == true) {
						System.out.println("THE GREEN COLOR DOT INDICATION IS DISPLAYED CORRECTLY.");
						test.log(LogStatus.INFO, "THE GREEN COLOR DOT INDICATION IS DISPLAYED CORRECTLY.");
						Reporter.log("THE GREEN COLOR DOT INDICATION IS DISPLAYED CORRECTLY.");
						log.info("THE GREEN COLOR DOT INDICATION IS DISPLAYED CORRECTLY.");

					} else {
						TestUtil.captureScreenshot();

						// ReportNG
						Reporter.log("<br>" + " THE GREEN COLOR DOT INDICATION IS NOT DISPLAYED. : " + "<br>");
						Reporter.log("<a target=\"_blank\" href=" + TestUtil.screenshotName + "><img src="
								+ TestUtil.screenshotName + " height=200 width=200></img></a>");
						Reporter.log("<br>");
						Reporter.log("<br>");

						// Extent Report
						test.log(LogStatus.FAIL, " THE GREEN COLOR DOT INDICATION IS NOT DISPLAYED : ");
						test.log(LogStatus.FAIL, test.addScreenCapture(TestUtil.screenshotName));

						System.out.println("THE GREEN COLOR DOT INDICATION IS NOT DISPLAYED ");
						log.info("THE GREEN COLOR DOT INDICATION IS NOT DISPLAYED ");

					}

				} catch (Throwable t) {
					verificationFailed();
				}

			} catch (Throwable t) {

				TestUtil.captureScreenshot();

				// ReportNG
				Reporter.log(
						"<br>" + " The Environmental Action Report environmental card is not displayed : " + "<br>");
				Reporter.log("<a target=\"_blank\" href=" + TestUtil.screenshotName + "><img src="
						+ TestUtil.screenshotName + " height=200 width=200></img></a>");
				Reporter.log("<br>");
				Reporter.log("<br>");

				// Extent Report
				test.log(LogStatus.FAIL, " The Environmental Action Report environmental card is not displayed : ");
				test.log(LogStatus.FAIL, test.addScreenCapture(TestUtil.screenshotName));

				System.out.println("The Environmental Action Report environmental card is not displayed ");
				log.info("The Environmental Action Report environmental card is not displayed ");

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

		// VERIFY ENVIRONMENTAL CARD ON THE ASSESSMENTS/INSPECTIONS DASHBOARD OF THE
		// ENVIRONMENTAL MODULE AFTER CREATING THE NEW ENVIRONMENTAL REPORT AND TASK -
		// SUPER ADMIN USER

		System.out.println(
				"******************** VERIFY ENVIRONMENTAL CARD ON THE ASSESSMENTS/INSPECTIONS DASHBOARD OF THE ENVIRONMENTAL MODULE AFTER CREATING THE NEW ENVIRONMENTAL REPORT AND TASK - SUPER ADMIN USER ********************");
		test.log(LogStatus.INFO,
				"******************** VERIFY ENVIRONMENTAL CARD ON THE ASSESSMENTS/INSPECTIONS DASHBOARD OF THE ENVIRONMENTAL MODULE AFTER CREATING THE NEW ENVIRONMENTAL REPORT AND TASK - SUPER ADMIN USER ********************");
		Reporter.log(
				"******************** VERIFY ENVIRONMENTAL CARD ON THE ASSESSMENTS/INSPECTIONS DASHBOARD OF THE ENVIRONMENTAL MODULE AFTER CREATING THE NEW ENVIRONMENTAL REPORT AND TASK - SUPER ADMIN USER ********************");
		log.info(
				"******************** VERIFY ENVIRONMENTAL CARD ON THE ASSESSMENTS/INSPECTIONS DASHBOARD OF THE ENVIRONMENTAL MODULE AFTER CREATING THE NEW ENVIRONMENTAL REPORT AND TASK - SUPER ADMIN USER ********************");

		try {

			// wait for the element
			Thread.sleep(5000);

			// click on the side menu
			click("menubtn_CSS");
			ngDriver.waitForAngularRequestsToFinish();
			System.out.println("Clicked on the side menu.");

			// wait for the element
			Thread.sleep(5000);

			// click on the environmental option
			click("sidemenu_environmental_XPATH");
			ngDriver.waitForAngularRequestsToFinish();
			System.out.println("Clicked on the environmental option.");

			// select the Assessments/Inspections option from the dashbaord drop down
			select("dashboard_CSS", data.get("dashboard_2"));
			ngDriver.waitForAngularRequestsToFinish();
			System.out.println("Selected the Assessments/Inspections option from the dashbaord drop down.");

			// wait for the 3 seconds
			Thread.sleep(3000);

			try {
				// scroll down the screen
				JavascriptExecutor js = (JavascriptExecutor) driver;
				WebElement environmentalactionreport = driver.findElement(
						By.xpath(OR.getProperty("portfoliodashboard_environmentalactionreportcard_XPATH")));
				js.executeScript("arguments[0].scrollIntoView(true);", environmentalactionreport);

				switchVerification("portfoliodashboard_environmentalactionreportcard_XPATH",
						"Environmental Action Report", "The Environmental Action Report is not displayed.");

				System.out.println("THE ENVIRONMENTAL ACTION REPORT CARD IS DISPLAYED SUCCESSFULLY.");
				test.log(LogStatus.INFO, "THE ENVIRONMENTAL ACTION REPORT CARD IS DISPLAYED SUCCESSFULLY.");
				Reporter.log("THE ENVIRONMENTAL ACTION REPORT CARD IS DISPLAYED SUCCESSFULLY.");
				log.info("THE ENVIRONMENTAL ACTION REPORT CARD IS DISPLAYED SUCCESSFULLY.");

				try {
					String notAvailableCount22 = driver
							.findElement(By.cssSelector(OR.getProperty("environmental_notavailablecount_CSS")))
							.getText();

					String finalNotAvailableCount22 = notAvailableCount22.trim();

					int value1_2 = Integer.parseInt(finalNotAvailableCount2);
					int value2_2 = Integer.parseInt(finalNotAvailableCount22);

					if (value1_2 == ((value2_2) + 1)) {

						System.out.println(
								"NOT AVAILABLE COUNT OF THE ENVIRONMENTAL ACTION REPORT IS DISPLAYED CORRECT.");
						test.log(LogStatus.INFO,
								"NOT AVAILABLE COUNT OF THE ENVIRONMENTAL ACTION REPORT IS DISPLAYED CORRECT.");
						Reporter.log("NOT AVAILABLE COUNT OF THE ENVIRONMENTAL ACTION REPORT IS DISPLAYED CORRECT.");
						log.info("NOT AVAILABLE COUNT OF THE ENVIRONMENTAL ACTION REPORT IS DISPLAYED CORRECT.");

					} else {
						TestUtil.captureScreenshot();

						// ReportNG
						Reporter.log("<br>"
								+ " NOT AVAILABLE COUNT OF THE ENVIRONMENTAL ACTION REPORT IS NOT DISPLAYED CORRECT. : "
								+ "<br>");
						Reporter.log("<a target=\"_blank\" href=" + TestUtil.screenshotName + "><img src="
								+ TestUtil.screenshotName + " height=200 width=200></img></a>");
						Reporter.log("<br>");
						Reporter.log("<br>");

						// Extent Report
						test.log(LogStatus.FAIL,
								" NOT AVAILABLE COUNT OF THE ENVIRONMENTAL ACTION REPORT IS NOT DISPLAYED CORRECT. : ");
						test.log(LogStatus.FAIL, test.addScreenCapture(TestUtil.screenshotName));

						System.out.println(
								"NOT AVAILABLE COUNT OF THE ENVIRONMENTAL ACTION REPORT IS NOT DISPLAYED CORRECT.");
						log.info("NOT AVAILABLE COUNT OF THE ENVIRONMENTAL ACTION REPORT IS NOT DISPLAYED CORRECT.");

					}
				} catch (Throwable t) {
					verificationFailed();
				}

				try {
					String notApplicableCount22 = driver
							.findElement(By.cssSelector(OR.getProperty("environmental_notapplicablecount_CSS")))
							.getText();

					String finalNotApplicableCount22 = notApplicableCount22.trim();

					int value1_22 = Integer.parseInt(finalNotApplicableCount2);
					int value2_22 = Integer.parseInt(finalNotApplicableCount22);

					if (value1_22 == value2_22) {

						System.out.println(
								"NOT APPLICABLE COUNT OF THE ENVIRONMENTAL ACTION REPORT IS DISPLAYED CORRECT.");
						test.log(LogStatus.INFO,
								"NOT APPLICABLE COUNT OF THE ENVIRONMENTAL ACTION REPORT IS DISPLAYED CORRECT.");
						Reporter.log("NOT APPLICABLE COUNT OF THE ENVIRONMENTAL ACTION REPORT IS DISPLAYED CORRECT.");
						log.info("NOT APPLICABLE COUNT OF THE ENVIRONMENTAL ACTION REPORT IS DISPLAYED CORRECT.");

					} else {
						TestUtil.captureScreenshot();

						// ReportNG
						Reporter.log("<br>"
								+ " NOT APPLICABLE COUNT OF THE ENVIRONMENTAL ACTION REPORT IS NOT DISPLAYED CORRECT. : "
								+ "<br>");
						Reporter.log("<a target=\"_blank\" href=" + TestUtil.screenshotName + "><img src="
								+ TestUtil.screenshotName + " height=200 width=200></img></a>");
						Reporter.log("<br>");
						Reporter.log("<br>");

						// Extent Report
						test.log(LogStatus.FAIL,
								" NOT APPLICABLE COUNT OF THE ENVIRONMENTAL ACTION REPORT IS NOT DISPLAYED CORRECT. : ");
						test.log(LogStatus.FAIL, test.addScreenCapture(TestUtil.screenshotName));

						System.out.println(
								"NOT APPLICABLE COUNT OF THE ENVIRONMENTAL ACTION REPORT IS NOT DISPLAYED CORRECT.");
						log.info("NOT APPLICABLE COUNT OF THE ENVIRONMENTAL ACTION REPORT IS NOT DISPLAYED CORRECT.");

					}
				} catch (Throwable t) {
					verificationFailed();
				}

				try {
					String overDueTaskCount22 = driver
							.findElement(By.cssSelector(OR.getProperty("environmental_overduetaskcount_CSS")))
							.getText();

					String finalOverDueTaskCount22 = overDueTaskCount22.trim();

					int value1_222 = Integer.parseInt(finalOverDueTaskCount2);
					int value2_222 = Integer.parseInt(finalOverDueTaskCount22);

					if (value1_222 == ((value2_222) - 1)) {

						System.out
								.println("OVERDUE TASK COUNT OF THE ENVIRONMENTAL ACTION REPORT IS DISPLAYED CORRECT.");
						test.log(LogStatus.INFO,
								"OVERDUE TASK COUNT OF THE ENVIRONMENTAL ACTION REPORT IS DISPLAYED CORRECT.");
						Reporter.log("OVERDUE TASK COUNT OF THE ENVIRONMENTAL ACTION REPORT IS DISPLAYED CORRECT.");
						log.info("OVERDUE TASK COUNT OF THE ENVIRONMENTAL ACTION REPORT IS DISPLAYED CORRECT.");

					} else {
						TestUtil.captureScreenshot();

						// ReportNG
						Reporter.log("<br>"
								+ " OVERDUE TASK COUNT OF THE ENVIRONMENTAL ACTION REPORT IS NOT DISPLAYED CORRECT. : "
								+ "<br>");
						Reporter.log("<a target=\"_blank\" href=" + TestUtil.screenshotName + "><img src="
								+ TestUtil.screenshotName + " height=200 width=200></img></a>");
						Reporter.log("<br>");
						Reporter.log("<br>");

						// Extent Report
						test.log(LogStatus.FAIL,
								" OVERDUE TASK COUNT OF THE ENVIRONMENTAL ACTION REPORT IS NOT DISPLAYED CORRECT. : ");
						test.log(LogStatus.FAIL, test.addScreenCapture(TestUtil.screenshotName));

						System.out.println(
								"OVERDUE TASK COUNT OF THE ENVIRONMENTAL ACTION REPORT IS NOT DISPLAYED CORRECT.");
						log.info("OVERDUE TASK COUNT OF THE ENVIRONMENTAL ACTION REPORT IS NOT DISPLAYED CORRECT.");

					}
				} catch (Throwable t) {
					verificationFailed();
				}

				try {
					// click on the graph of the environmental action report
					click("portfolio_environmentalactionreport_graph_XPATH");
					ngDriver.waitForAngularRequestsToFinish();
					System.out.println("Clicked on the graph of the environmental action report.");

					// enter the property name in the search field
					clear("users_filtertxt_CSS");
					type("users_filtertxt_CSS", data.get("property_1"));
					ngDriver.waitForAngularRequestsToFinish();
					System.out.println("Entered the property name in the search field.");

					boolean greenDot2 = driver
							.findElement(By.xpath(OR.getProperty("portfolio_environmentalactionreport_greendot_XPATH")))
							.isDisplayed();

					if (greenDot2 == true) {
						System.out.println("THE GREEN COLOR DOT INDICATION IS DISPLAYED CORRECTLY.");
						test.log(LogStatus.INFO, "THE GREEN COLOR DOT INDICATION IS DISPLAYED CORRECTLY.");
						Reporter.log("THE GREEN COLOR DOT INDICATION IS DISPLAYED CORRECTLY.");
						log.info("THE GREEN COLOR DOT INDICATION IS DISPLAYED CORRECTLY.");

					} else {
						TestUtil.captureScreenshot();

						// ReportNG
						Reporter.log("<br>" + " THE GREEN COLOR DOT INDICATION IS NOT DISPLAYED. : " + "<br>");
						Reporter.log("<a target=\"_blank\" href=" + TestUtil.screenshotName + "><img src="
								+ TestUtil.screenshotName + " height=200 width=200></img></a>");
						Reporter.log("<br>");
						Reporter.log("<br>");

						// Extent Report
						test.log(LogStatus.FAIL, " THE GREEN COLOR DOT INDICATION IS NOT DISPLAYED : ");
						test.log(LogStatus.FAIL, test.addScreenCapture(TestUtil.screenshotName));

						System.out.println("THE GREEN COLOR DOT INDICATION IS NOT DISPLAYED ");
						log.info("THE GREEN COLOR DOT INDICATION IS NOT DISPLAYED ");

					}

				} catch (Throwable t) {
					verificationFailed();
				}

			} catch (Throwable t) {

				TestUtil.captureScreenshot();

				// ReportNG
				Reporter.log(
						"<br>" + " The Environmental Action Report environmental card is not displayed : " + "<br>");
				Reporter.log("<a target=\"_blank\" href=" + TestUtil.screenshotName + "><img src="
						+ TestUtil.screenshotName + " height=200 width=200></img></a>");
				Reporter.log("<br>");
				Reporter.log("<br>");

				// Extent Report
				test.log(LogStatus.FAIL, " The Environmental Action Report environmental card is not displayed : ");
				test.log(LogStatus.FAIL, test.addScreenCapture(TestUtil.screenshotName));

				System.out.println("The Environmental Action Report environmental card is not displayed ");
				log.info("The Environmental Action Report environmental card is not displayed ");

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

		// EXCLUDE THE PROPERTY FOR THE NEWLY CREATED ENVIRONMENTAL REPORT - SUPER ADMIN
		// USER

		System.out.println(
				"******************** EXCLUDE THE PROPERTY FOR THE NEWLY CREATED ENVIRONMENTAL REPORT - SUPER ADMIN USER ********************");
		test.log(LogStatus.INFO,
				"******************** EXCLUDE THE PROPERTY FOR THE NEWLY CREATED ENVIRONMENTAL REPORT - SUPER ADMIN USER ********************");
		Reporter.log(
				"******************** EXCLUDE THE PROPERTY FOR THE NEWLY CREATED ENVIRONMENTAL REPORT - SUPER ADMIN USER ********************");
		log.info(
				"******************** EXCLUDE THE PROPERTY FOR THE NEWLY CREATED ENVIRONMENTAL REPORT - SUPER ADMIN USER ********************");

		try {

			// wait for the element
			Thread.sleep(5000);

			// click on the side menu
			click("menubtn_CSS");
			ngDriver.waitForAngularRequestsToFinish();
			System.out.println("Clicked on the side menu.");

			// wait for the element
			Thread.sleep(5000);

			// click on the portfolio summary option
			click("sidemenu_portfoliosummary_XPATH");
			ngDriver.waitForAngularRequestsToFinish();
			System.out.println("Clicked on the portfolio summary option.");

			try {
				// scroll down the screen
				JavascriptExecutor js = (JavascriptExecutor) driver;
				WebElement environmentalactionreport = driver.findElement(
						By.xpath(OR.getProperty("portfoliodashboard_environmentalactionreportcard_XPATH")));
				js.executeScript("arguments[0].scrollIntoView(true);", environmentalactionreport);

				switchVerification("portfoliodashboard_environmentalactionreportcard_XPATH",
						"Environmental Action Report", "The Environmental Action Report is not displayed.");

				System.out.println("THE ENVIRONMENTAL ACTION REPORT CARD IS DISPLAYED SUCCESSFULLY.");
				test.log(LogStatus.INFO, "THE ENVIRONMENTAL ACTION REPORT CARD IS DISPLAYED SUCCESSFULLY.");
				Reporter.log("THE ENVIRONMENTAL ACTION REPORT CARD IS DISPLAYED SUCCESSFULLY.");
				log.info("THE ENVIRONMENTAL ACTION REPORT CARD IS DISPLAYED SUCCESSFULLY.");

				// click on the graph of the environmental action report
				click("portfolio_environmentalactionreport_graph_XPATH");
				ngDriver.waitForAngularRequestsToFinish();
				System.out.println("Clicked on the graph of the environmental action report.");

				// enter the property name in the search field
				clear("users_filtertxt_CSS");
				type("users_filtertxt_CSS", data.get("property_1"));
				ngDriver.waitForAngularRequestsToFinish();
				System.out.println("Entered the property name in the search field.");

				// click on the drop down button
				click("portfolio_environmental_dropdownlist_CSS");
				ngDriver.waitForAngularRequestsToFinish();
				System.out.println("Clicked on the drop down button.");

				// click on the assessment schedule option
				click("portfolio_environmental_dropdownlist_assesmentschedule_XPATH");
				ngDriver.waitForAngularRequestsToFinish();
				System.out.println("Clicked on the assessment schedule option.");

				// scroll the screen
				WebElement notrequiredchecklist = driver.findElement(
						By.cssSelector(OR.getProperty("portfolio_environmental_dropdownlist_notrequiredckbx_CSS")));
				js.executeScript("arguments[0].scrollIntoView(true);", notrequiredchecklist);

				// click on the non required property checklist
				click("portfolio_environmental_dropdownlist_notrequiredckbx_CSS");
				ngDriver.waitForAngularRequestsToFinish();
				System.out.println("Clicked on the non required property checklist.");

				// click on the save button
				click("portfolio_environmental_dropdownlist_savebtn_CSS");
				ngDriver.waitForAngularRequestsToFinish();
				System.out.println("Clicked on the save button.");

				// enter the property name in the search field
				clear("users_filtertxt_CSS");
				type("users_filtertxt_CSS", data.get("property_1"));
				ngDriver.waitForAngularRequestsToFinish();
				System.out.println("Entered the property name in the search field.");

				// the excluded property is displayed or not

				try {

					String deleteElement = driver
							.findElement(By.xpath(OR.getProperty("portfolio_environmental_searchedproperty1_XPATH")))
							.getText();

					if (deleteElement.equals("CAPREIT - White Frost")) {

						Assert.assertTrue(
								isElementPresent(
										By.xpath(OR.getProperty("portfolio_environmental_searchedproperty1_XPATH"))),
								"The CAPREIT - White Frost is displayed.");

						TestUtil.captureScreenshot();

						// ReportNG
						Reporter.log("<br>" + "The CAPREIT - White Frost is displayed.: " + "<br>");
						Reporter.log("<a target=\"_blank\" href=" + TestUtil.screenshotName + "><img src="
								+ TestUtil.screenshotName + " height=200 width=200></img></a>");
						Reporter.log("<br>");
						Reporter.log("<br>");

						// Extent Report
						test.log(LogStatus.FAIL, " The CAPREIT - White Frost is displayed.: ");
						test.log(LogStatus.FAIL, test.addScreenCapture(TestUtil.screenshotName));

						System.out.println("The CAPREIT - White Frost is displayed.");
						log.info("The CAPREIT - White Frost is displayed.");

					}
				} catch (Throwable t) {
					System.out.println("The CAPREIT - White Frost is deleted successfully.");
					test.log(LogStatus.INFO, "The CAPREIT - White Frost is deleted successfully.");
					Reporter.log("The CAPREIT - White Frost is deleted successfully.");
					log.info("The CAPREIT - White Frost is deleted successfully.");
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

		// VERIFY ENVIRONMENTAL CARD ON THE PORTFOLIO SUMMARY DASHBOARD SCREEN AFTER
		// EXCLUDED THE PROPERTY - SUPER ADMIN USER

		System.out.println(
				"******************** VERIFY ENVIRONMENTAL CARD ON THE PORTFOLIO SUMMARY DASHBOARD SCREEN AFTER EXCLUDED THE PROPERTY - SUPER ADMIN USER ********************");
		test.log(LogStatus.INFO,
				"******************** VERIFY ENVIRONMENTAL CARD ON THE PORTFOLIO SUMMARY DASHBOARD SCREEN AFTER EXCLUDED THE PROPERTY - SUPER ADMIN USER ********************");
		Reporter.log(
				"******************** VERIFY ENVIRONMENTAL CARD ON THE PORTFOLIO SUMMARY DASHBOARD SCREEN AFTER EXCLUDED THE PROPERTY - SUPER ADMIN USER ********************");
		log.info(
				"******************** VERIFY ENVIRONMENTAL CARD ON THE PORTFOLIO SUMMARY DASHBOARD SCREEN AFTER EXCLUDED THE PROPERTY - SUPER ADMIN USER ********************");

		try {

			// wait for the element
			Thread.sleep(5000);

			// click on the side menu
			click("menubtn_CSS");
			ngDriver.waitForAngularRequestsToFinish();
			System.out.println("Clicked on the side menu.");

			// wait for the element
			Thread.sleep(5000);

			// click on the portfolio summary option
			click("sidemenu_portfoliosummary_XPATH");
			ngDriver.waitForAngularRequestsToFinish();
			System.out.println("Clicked on the portfolio summary option.");

			try {
				// scroll down the screen
				JavascriptExecutor js = (JavascriptExecutor) driver;
				WebElement environmentalactionreport = driver.findElement(
						By.xpath(OR.getProperty("portfoliodashboard_environmentalactionreportcard_XPATH")));
				js.executeScript("arguments[0].scrollIntoView(true);", environmentalactionreport);

				switchVerification("portfoliodashboard_environmentalactionreportcard_XPATH",
						"Environmental Action Report", "The Environmental Action Report is not displayed.");

				System.out.println("THE ENVIRONMENTAL ACTION REPORT CARD IS DISPLAYED SUCCESSFULLY.");
				test.log(LogStatus.INFO, "THE ENVIRONMENTAL ACTION REPORT CARD IS DISPLAYED SUCCESSFULLY.");
				Reporter.log("THE ENVIRONMENTAL ACTION REPORT CARD IS DISPLAYED SUCCESSFULLY.");
				log.info("THE ENVIRONMENTAL ACTION REPORT CARD IS DISPLAYED SUCCESSFULLY.");

				try {
					String notAvailableCount11_past = driver
							.findElement(By.cssSelector(OR.getProperty("environmental_notavailablecount_CSS")))
							.getText();

					String finalNotAvailableCount11_past = notAvailableCount11_past.trim();

					int value1_past = Integer.parseInt(finalNotAvailableCount1);
					int value2_past = Integer.parseInt(finalNotAvailableCount11_past);

					if (value1_past == ((value2_past) + 1)) {

						System.out.println(
								"NOT AVAILABLE COUNT OF THE ENVIRONMENTAL ACTION REPORT IS DISPLAYED CORRECT.");
						test.log(LogStatus.INFO,
								"NOT AVAILABLE COUNT OF THE ENVIRONMENTAL ACTION REPORT IS DISPLAYED CORRECT.");
						Reporter.log("NOT AVAILABLE COUNT OF THE ENVIRONMENTAL ACTION REPORT IS DISPLAYED CORRECT.");
						log.info("NOT AVAILABLE COUNT OF THE ENVIRONMENTAL ACTION REPORT IS DISPLAYED CORRECT.");

					} else {
						TestUtil.captureScreenshot();

						// ReportNG
						Reporter.log("<br>"
								+ " NOT AVAILABLE COUNT OF THE ENVIRONMENTAL ACTION REPORT IS NOT DISPLAYED CORRECT. : "
								+ "<br>");
						Reporter.log("<a target=\"_blank\" href=" + TestUtil.screenshotName + "><img src="
								+ TestUtil.screenshotName + " height=200 width=200></img></a>");
						Reporter.log("<br>");
						Reporter.log("<br>");

						// Extent Report
						test.log(LogStatus.FAIL,
								" NOT AVAILABLE COUNT OF THE ENVIRONMENTAL ACTION REPORT IS NOT DISPLAYED CORRECT. : ");
						test.log(LogStatus.FAIL, test.addScreenCapture(TestUtil.screenshotName));

						System.out.println(
								"NOT AVAILABLE COUNT OF THE ENVIRONMENTAL ACTION REPORT IS NOT DISPLAYED CORRECT.");
						log.info("NOT AVAILABLE COUNT OF THE ENVIRONMENTAL ACTION REPORT IS NOT DISPLAYED CORRECT.");

					}
				} catch (Throwable t) {
					verificationFailed();
				}

				try {
					String notApplicableCount11_past = driver
							.findElement(By.cssSelector(OR.getProperty("environmental_notapplicablecount_CSS")))
							.getText();

					String finalNotApplicableCount11_past = notApplicableCount11_past.trim();

					int value1_1_past = Integer.parseInt(finalNotApplicableCount1);
					int value2_1_past = Integer.parseInt(finalNotApplicableCount11_past);

					if (value1_1_past == ((value2_1_past) - 1)) {

						System.out.println(
								"NOT APPLICABLE COUNT OF THE ENVIRONMENTAL ACTION REPORT IS DISPLAYED CORRECT.");
						test.log(LogStatus.INFO,
								"NOT APPLICABLE COUNT OF THE ENVIRONMENTAL ACTION REPORT IS DISPLAYED CORRECT.");
						Reporter.log("NOT APPLICABLE COUNT OF THE ENVIRONMENTAL ACTION REPORT IS DISPLAYED CORRECT.");
						log.info("NOT APPLICABLE COUNT OF THE ENVIRONMENTAL ACTION REPORT IS DISPLAYED CORRECT.");

					} else {
						TestUtil.captureScreenshot();

						// ReportNG
						Reporter.log("<br>"
								+ " NOT APPLICABLE COUNT OF THE ENVIRONMENTAL ACTION REPORT IS NOT DISPLAYED CORRECT. : "
								+ "<br>");
						Reporter.log("<a target=\"_blank\" href=" + TestUtil.screenshotName + "><img src="
								+ TestUtil.screenshotName + " height=200 width=200></img></a>");
						Reporter.log("<br>");
						Reporter.log("<br>");

						// Extent Report
						test.log(LogStatus.FAIL,
								" NOT APPLICABLE COUNT OF THE ENVIRONMENTAL ACTION REPORT IS NOT DISPLAYED CORRECT. : ");
						test.log(LogStatus.FAIL, test.addScreenCapture(TestUtil.screenshotName));

						System.out.println(
								"NOT APPLICABLE COUNT OF THE ENVIRONMENTAL ACTION REPORT IS NOT DISPLAYED CORRECT.");
						log.info("NOT APPLICABLE COUNT OF THE ENVIRONMENTAL ACTION REPORT IS NOT DISPLAYED CORRECT.");

					}
				} catch (Throwable t) {
					verificationFailed();
				}

				try {
					String overDueTaskCount11_past = driver
							.findElement(By.cssSelector(OR.getProperty("environmental_overduetaskcount_CSS")))
							.getText();

					String finalOverDueTaskCount11_past = overDueTaskCount11_past.trim();

					int value1_11_past = Integer.parseInt(finalOverDueTaskCount1);
					int value2_11_past = Integer.parseInt(finalOverDueTaskCount11_past);

					if (value1_11_past == ((value2_11_past) - 1)) {

						System.out
								.println("OVERDUE TASK COUNT OF THE ENVIRONMENTAL ACTION REPORT IS DISPLAYED CORRECT.");
						test.log(LogStatus.INFO,
								"OVERDUE TASK COUNT OF THE ENVIRONMENTAL ACTION REPORT IS DISPLAYED CORRECT.");
						Reporter.log("OVERDUE TASK COUNT OF THE ENVIRONMENTAL ACTION REPORT IS DISPLAYED CORRECT.");
						log.info("OVERDUE TASK COUNT OF THE ENVIRONMENTAL ACTION REPORT IS DISPLAYED CORRECT.");

					} else {
						TestUtil.captureScreenshot();

						// ReportNG
						Reporter.log("<br>"
								+ " OVERDUE TASK COUNT OF THE ENVIRONMENTAL ACTION REPORT IS NOT DISPLAYED CORRECT. : "
								+ "<br>");
						Reporter.log("<a target=\"_blank\" href=" + TestUtil.screenshotName + "><img src="
								+ TestUtil.screenshotName + " height=200 width=200></img></a>");
						Reporter.log("<br>");
						Reporter.log("<br>");

						// Extent Report
						test.log(LogStatus.FAIL,
								" OVERDUE TASK COUNT OF THE ENVIRONMENTAL ACTION REPORT IS NOT DISPLAYED CORRECT. : ");
						test.log(LogStatus.FAIL, test.addScreenCapture(TestUtil.screenshotName));

						System.out.println(
								"OVERDUE TASK COUNT OF THE ENVIRONMENTAL ACTION REPORT IS NOT DISPLAYED CORRECT.");
						log.info("OVERDUE TASK COUNT OF THE ENVIRONMENTAL ACTION REPORT IS NOT DISPLAYED CORRECT.");

					}
				} catch (Throwable t) {
					verificationFailed();
				}

				try {
					// click on the graph of the environmental action report
					click("portfolio_environmentalactionreport_graph_XPATH");
					ngDriver.waitForAngularRequestsToFinish();
					System.out.println("Clicked on the graph of the environmental action report.");

					// enter the property name in the search field
					clear("users_filtertxt_CSS");
					type("users_filtertxt_CSS", data.get("property_1"));
					ngDriver.waitForAngularRequestsToFinish();
					System.out.println("Entered the property name in the search field.");

					// the excluded property is displayed or not

					try {

						String deleteElement = driver
								.findElement(
										By.xpath(OR.getProperty("portfolio_environmental_searchedproperty1_XPATH")))
								.getText();

						if (deleteElement.equals("CAPREIT - White Frost")) {

							Assert.assertTrue(
									isElementPresent(By
											.xpath(OR.getProperty("portfolio_environmental_searchedproperty1_XPATH"))),
									"The CAPREIT - White Frost is displayed.");

							TestUtil.captureScreenshot();

							// ReportNG
							Reporter.log("<br>" + "The CAPREIT - White Frost is displayed.: " + "<br>");
							Reporter.log("<a target=\"_blank\" href=" + TestUtil.screenshotName + "><img src="
									+ TestUtil.screenshotName + " height=200 width=200></img></a>");
							Reporter.log("<br>");
							Reporter.log("<br>");

							// Extent Report
							test.log(LogStatus.FAIL, " The CAPREIT - White Frost is displayed.: ");
							test.log(LogStatus.FAIL, test.addScreenCapture(TestUtil.screenshotName));

							System.out.println("The CAPREIT - White Frost is displayed.");
							log.info("The CAPREIT - White Frost is displayed.");

						}
					} catch (Throwable t) {
						System.out.println("The CAPREIT - White Frost is deleted successfully.");
						test.log(LogStatus.INFO, "The CAPREIT - White Frost is deleted successfully.");
						Reporter.log("The CAPREIT - White Frost is deleted successfully.");
						log.info("The CAPREIT - White Frost is deleted successfully.");
					}

				} catch (Throwable t) {
					verificationFailed();
				}

			} catch (Throwable t) {

				TestUtil.captureScreenshot();

				// ReportNG
				Reporter.log(
						"<br>" + " The Environmental Action Report environmental card is not displayed : " + "<br>");
				Reporter.log("<a target=\"_blank\" href=" + TestUtil.screenshotName + "><img src="
						+ TestUtil.screenshotName + " height=200 width=200></img></a>");
				Reporter.log("<br>");
				Reporter.log("<br>");

				// Extent Report
				test.log(LogStatus.FAIL, " The Environmental Action Report environmental card is not displayed : ");
				test.log(LogStatus.FAIL, test.addScreenCapture(TestUtil.screenshotName));

				System.out.println("The Environmental Action Report environmental card is not displayed ");
				log.info("The Environmental Action Report environmental card is not displayed ");

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

		// VERIFY ENVIRONMENTAL CARD ON THE ASSESSMENTS/INSPECTIONS DASHBOARD OF THE
		// ENVIRONMENTAL MODULE AFTER EXCLUDING THE PROPERTY - SUPER ADMIN USER

		System.out.println(
				"******************** VERIFY ENVIRONMENTAL CARD ON THE ASSESSMENTS/INSPECTIONS DASHBOARD OF THE ENVIRONMENTAL MODULE AFTER EXCLUDING THE PROPERTY - SUPER ADMIN USER ********************");
		test.log(LogStatus.INFO,
				"******************** VERIFY ENVIRONMENTAL CARD ON THE ASSESSMENTS/INSPECTIONS DASHBOARD OF THE ENVIRONMENTAL MODULE AFTER EXCLUDING THE PROPERTY - SUPER ADMIN USER ********************");
		Reporter.log(
				"******************** VERIFY ENVIRONMENTAL CARD ON THE ASSESSMENTS/INSPECTIONS DASHBOARD OF THE ENVIRONMENTAL MODULE AFTER EXCLUDING THE PROPERTY - SUPER ADMIN USER ********************");
		log.info(
				"******************** VERIFY ENVIRONMENTAL CARD ON THE ASSESSMENTS/INSPECTIONS DASHBOARD OF THE ENVIRONMENTAL MODULE AFTER EXCLUDING THE PROPERTY - SUPER ADMIN USER ********************");

		try {

			// wait for the element
			Thread.sleep(5000);

			// click on the side menu
			click("menubtn_CSS");
			ngDriver.waitForAngularRequestsToFinish();
			System.out.println("Clicked on the side menu.");

			// wait for the element
			Thread.sleep(5000);

			// click on the environmental option
			click("sidemenu_environmental_XPATH");
			ngDriver.waitForAngularRequestsToFinish();
			System.out.println("Clicked on the environmental option.");

			// select the Assessments/Inspections option from the dashbaord drop down
			select("dashboard_CSS", data.get("dashboard_2"));
			ngDriver.waitForAngularRequestsToFinish();
			System.out.println("Selected the Assessments/Inspections option from the dashbaord drop down.");

			// wait for the 3 seconds
			Thread.sleep(3000);

			try {
				// scroll down the screen
				JavascriptExecutor js = (JavascriptExecutor) driver;
				WebElement environmentalactionreport = driver.findElement(
						By.xpath(OR.getProperty("portfoliodashboard_environmentalactionreportcard_XPATH")));
				js.executeScript("arguments[0].scrollIntoView(true);", environmentalactionreport);

				switchVerification("portfoliodashboard_environmentalactionreportcard_XPATH",
						"Environmental Action Report", "The Environmental Action Report is not displayed.");

				System.out.println("THE ENVIRONMENTAL ACTION REPORT CARD IS DISPLAYED SUCCESSFULLY.");
				test.log(LogStatus.INFO, "THE ENVIRONMENTAL ACTION REPORT CARD IS DISPLAYED SUCCESSFULLY.");
				Reporter.log("THE ENVIRONMENTAL ACTION REPORT CARD IS DISPLAYED SUCCESSFULLY.");
				log.info("THE ENVIRONMENTAL ACTION REPORT CARD IS DISPLAYED SUCCESSFULLY.");

				try {
					String notAvailableCount22_past = driver
							.findElement(By.cssSelector(OR.getProperty("environmental_notavailablecount_CSS")))
							.getText();

					String finalNotAvailableCount22_past = notAvailableCount22_past.trim();

					int value1_2_past = Integer.parseInt(finalNotAvailableCount2);
					int value2_2_past = Integer.parseInt(finalNotAvailableCount22_past);

					if (value1_2_past == ((value2_2_past) + 1)) {

						System.out.println(
								"NOT AVAILABLE COUNT OF THE ENVIRONMENTAL ACTION REPORT IS DISPLAYED CORRECT.");
						test.log(LogStatus.INFO,
								"NOT AVAILABLE COUNT OF THE ENVIRONMENTAL ACTION REPORT IS DISPLAYED CORRECT.");
						Reporter.log("NOT AVAILABLE COUNT OF THE ENVIRONMENTAL ACTION REPORT IS DISPLAYED CORRECT.");
						log.info("NOT AVAILABLE COUNT OF THE ENVIRONMENTAL ACTION REPORT IS DISPLAYED CORRECT.");

					} else {
						TestUtil.captureScreenshot();

						// ReportNG
						Reporter.log("<br>"
								+ " NOT AVAILABLE COUNT OF THE ENVIRONMENTAL ACTION REPORT IS NOT DISPLAYED CORRECT. : "
								+ "<br>");
						Reporter.log("<a target=\"_blank\" href=" + TestUtil.screenshotName + "><img src="
								+ TestUtil.screenshotName + " height=200 width=200></img></a>");
						Reporter.log("<br>");
						Reporter.log("<br>");

						// Extent Report
						test.log(LogStatus.FAIL,
								" NOT AVAILABLE COUNT OF THE ENVIRONMENTAL ACTION REPORT IS NOT DISPLAYED CORRECT. : ");
						test.log(LogStatus.FAIL, test.addScreenCapture(TestUtil.screenshotName));

						System.out.println(
								"NOT AVAILABLE COUNT OF THE ENVIRONMENTAL ACTION REPORT IS NOT DISPLAYED CORRECT.");
						log.info("NOT AVAILABLE COUNT OF THE ENVIRONMENTAL ACTION REPORT IS NOT DISPLAYED CORRECT.");

					}
				} catch (Throwable t) {
					verificationFailed();
				}

				try {
					String notApplicableCount22_past = driver
							.findElement(By.cssSelector(OR.getProperty("environmental_notapplicablecount_CSS")))
							.getText();

					String finalNotApplicableCount22_past = notApplicableCount22_past.trim();

					int value1_22_past = Integer.parseInt(finalNotApplicableCount2);
					int value2_22_past = Integer.parseInt(finalNotApplicableCount22_past);

					if (value1_22_past == ((value2_22_past) - 1)) {

						System.out.println(
								"NOT APPLICABLE COUNT OF THE ENVIRONMENTAL ACTION REPORT IS DISPLAYED CORRECT.");
						test.log(LogStatus.INFO,
								"NOT APPLICABLE COUNT OF THE ENVIRONMENTAL ACTION REPORT IS DISPLAYED CORRECT.");
						Reporter.log("NOT APPLICABLE COUNT OF THE ENVIRONMENTAL ACTION REPORT IS DISPLAYED CORRECT.");
						log.info("NOT APPLICABLE COUNT OF THE ENVIRONMENTAL ACTION REPORT IS DISPLAYED CORRECT.");

					} else {
						TestUtil.captureScreenshot();

						// ReportNG
						Reporter.log("<br>"
								+ " NOT APPLICABLE COUNT OF THE ENVIRONMENTAL ACTION REPORT IS NOT DISPLAYED CORRECT. : "
								+ "<br>");
						Reporter.log("<a target=\"_blank\" href=" + TestUtil.screenshotName + "><img src="
								+ TestUtil.screenshotName + " height=200 width=200></img></a>");
						Reporter.log("<br>");
						Reporter.log("<br>");

						// Extent Report
						test.log(LogStatus.FAIL,
								" NOT APPLICABLE COUNT OF THE ENVIRONMENTAL ACTION REPORT IS NOT DISPLAYED CORRECT. : ");
						test.log(LogStatus.FAIL, test.addScreenCapture(TestUtil.screenshotName));

						System.out.println(
								"NOT APPLICABLE COUNT OF THE ENVIRONMENTAL ACTION REPORT IS NOT DISPLAYED CORRECT.");
						log.info("NOT APPLICABLE COUNT OF THE ENVIRONMENTAL ACTION REPORT IS NOT DISPLAYED CORRECT.");

					}
				} catch (Throwable t) {
					verificationFailed();
				}

				try {
					String overDueTaskCount22_past = driver
							.findElement(By.cssSelector(OR.getProperty("environmental_overduetaskcount_CSS")))
							.getText();

					String finalOverDueTaskCount22_past = overDueTaskCount22_past.trim();

					int value1_222_past = Integer.parseInt(finalOverDueTaskCount2);
					int value2_222_past = Integer.parseInt(finalOverDueTaskCount22_past);

					if (value1_222_past == ((value2_222_past) - 1)) {

						System.out
								.println("OVERDUE TASK COUNT OF THE ENVIRONMENTAL ACTION REPORT IS DISPLAYED CORRECT.");
						test.log(LogStatus.INFO,
								"OVERDUE TASK COUNT OF THE ENVIRONMENTAL ACTION REPORT IS DISPLAYED CORRECT.");
						Reporter.log("OVERDUE TASK COUNT OF THE ENVIRONMENTAL ACTION REPORT IS DISPLAYED CORRECT.");
						log.info("OVERDUE TASK COUNT OF THE ENVIRONMENTAL ACTION REPORT IS DISPLAYED CORRECT.");

					} else {
						TestUtil.captureScreenshot();

						// ReportNG
						Reporter.log("<br>"
								+ " OVERDUE TASK COUNT OF THE ENVIRONMENTAL ACTION REPORT IS NOT DISPLAYED CORRECT. : "
								+ "<br>");
						Reporter.log("<a target=\"_blank\" href=" + TestUtil.screenshotName + "><img src="
								+ TestUtil.screenshotName + " height=200 width=200></img></a>");
						Reporter.log("<br>");
						Reporter.log("<br>");

						// Extent Report
						test.log(LogStatus.FAIL,
								" OVERDUE TASK COUNT OF THE ENVIRONMENTAL ACTION REPORT IS NOT DISPLAYED CORRECT. : ");
						test.log(LogStatus.FAIL, test.addScreenCapture(TestUtil.screenshotName));

						System.out.println(
								"OVERDUE TASK COUNT OF THE ENVIRONMENTAL ACTION REPORT IS NOT DISPLAYED CORRECT.");
						log.info("OVERDUE TASK COUNT OF THE ENVIRONMENTAL ACTION REPORT IS NOT DISPLAYED CORRECT.");

					}
				} catch (Throwable t) {
					verificationFailed();
				}

				try {
					// click on the graph of the environmental action report
					click("portfolio_environmentalactionreport_graph_XPATH");
					ngDriver.waitForAngularRequestsToFinish();
					System.out.println("Clicked on the graph of the environmental action report.");

					// enter the property name in the search field
					clear("users_filtertxt_CSS");
					type("users_filtertxt_CSS", data.get("property_1"));
					ngDriver.waitForAngularRequestsToFinish();
					System.out.println("Entered the property name in the search field.");

					// the excluded property is displayed or not

					try {

						String deleteElement = driver
								.findElement(
										By.xpath(OR.getProperty("portfolio_environmental_searchedproperty1_XPATH")))
								.getText();

						if (deleteElement.equals("CAPREIT - White Frost")) {

							Assert.assertTrue(
									isElementPresent(By
											.xpath(OR.getProperty("portfolio_environmental_searchedproperty1_XPATH"))),
									"The CAPREIT - White Frost is displayed.");

							TestUtil.captureScreenshot();

							// ReportNG
							Reporter.log("<br>" + "The CAPREIT - White Frost is displayed.: " + "<br>");
							Reporter.log("<a target=\"_blank\" href=" + TestUtil.screenshotName + "><img src="
									+ TestUtil.screenshotName + " height=200 width=200></img></a>");
							Reporter.log("<br>");
							Reporter.log("<br>");

							// Extent Report
							test.log(LogStatus.FAIL, " The CAPREIT - White Frost is displayed.: ");
							test.log(LogStatus.FAIL, test.addScreenCapture(TestUtil.screenshotName));

							System.out.println("The CAPREIT - White Frost is displayed.");
							log.info("The CAPREIT - White Frost is displayed.");

						}
					} catch (Throwable t) {
						System.out.println("The CAPREIT - White Frost is deleted successfully.");
						test.log(LogStatus.INFO, "The CAPREIT - White Frost is deleted successfully.");
						Reporter.log("The CAPREIT - White Frost is deleted successfully.");
						log.info("The CAPREIT - White Frost is deleted successfully.");
					}

				} catch (Throwable t) {
					verificationFailed();
				}

			} catch (Throwable t) {

				TestUtil.captureScreenshot();

				// ReportNG
				Reporter.log(
						"<br>" + " The Environmental Action Report environmental card is not displayed : " + "<br>");
				Reporter.log("<a target=\"_blank\" href=" + TestUtil.screenshotName + "><img src="
						+ TestUtil.screenshotName + " height=200 width=200></img></a>");
				Reporter.log("<br>");
				Reporter.log("<br>");

				// Extent Report
				test.log(LogStatus.FAIL, " The Environmental Action Report environmental card is not displayed : ");
				test.log(LogStatus.FAIL, test.addScreenCapture(TestUtil.screenshotName));

				System.out.println("The Environmental Action Report environmental card is not displayed ");
				log.info("The Environmental Action Report environmental card is not displayed ");

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

		// DELETE THE TASK - SUPER ADMIN USER

		System.out.println("******************** DELETE THE TASK - SUPER ADMIN USER ********************");
		test.log(LogStatus.INFO, "******************** DELETE THE TASK - SUPER ADMIN USER ********************");
		Reporter.log("******************** DELETE THE TASK - SUPER ADMIN USER ********************");
		log.info("******************** DELETE THE TASK - SUPER ADMIN USER ********************");

		try {

			// enter the property name in the search field
			clear("envreports_propertylist_filtertxt_CSS");
			type("envreports_propertylist_filtertxt_CSS", data.get("property_1"));
			ngDriver.waitForAngularRequestsToFinish();
			System.out.println("Entered the property name in the search field.");

			// click on the task icon
			click("taskicon_CSS");
			System.out.println("Clicked on the task icon.");
			ngDriver.waitForAngularRequestsToFinish();

			// type the task name in the search field
			clear("survey_task_searchfield_CSS");
			type("survey_task_searchfield_CSS", data.get("task_title"));
			ngDriver.waitForAngularRequestsToFinish();
			System.out.println("Typed the task name in the search field.");

			// click on the action icon of the task
			click("task_addtask_pendinglbl_actionicon_report2_XPATH");
			ngDriver.waitForAngularRequestsToFinish();
			System.out.println("Clicked on the action icon of the task.");

			// click on the delete task option
			click("task_addtask_pendinglbl_actionicon_deleteoption_report2_XPATH");
			ngDriver.waitForAngularRequestsToFinish();
			System.out.println("Clicked on the complete task option.");

			// wait for the element
			explicitWaitClickable("closetoastmsg_CSS");

			// click on the toaster close button
			click("closetoastmsg_CSS");
			ngDriver.waitForAngularRequestsToFinish();
			System.out.println("Clicked on the toaster close button.");

			// type the task name in the search field
			clear("survey_task_searchfield_CSS");
			type("survey_task_searchfield_CSS", data.get("task_title"));
			ngDriver.waitForAngularRequestsToFinish();
			System.out.println("Typed the task name in the search field.");

			deleteVerification("portfolio_environmental_searchedtask1_XPATH",
					"Test Task Title Environmental Action Report 2");

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

		// DELETE THE ENVIRONMENTAL REPORT - SUPER ADMIN USER

		System.out.println(
				"******************** DELETE THE ENVIRONMENTAL REPORT - SUPER ADMIN USER ********************");
		test.log(LogStatus.INFO,
				"******************** DELETE THE ENVIRONMENTAL REPORT - SUPER ADMIN USER ********************");
		Reporter.log("******************** DELETE THE ENVIRONMENTAL REPORT - SUPER ADMIN USER ********************");
		log.info("******************** DELETE THE ENVIRONMENTAL REPORT - SUPER ADMIN USER ********************");

		try {

			// enter the property name in the search field
			clear("envreports_propertylist_filtertxt_CSS");
			type("envreports_propertylist_filtertxt_CSS", data.get("property_1"));
			ngDriver.waitForAngularRequestsToFinish();
			System.out.println("Entered the property name in the search field.");

			// click on the environmental icon
			click("environmentalicon_CSS");
			System.out.println("Clicked on the environmental icon.");
			ngDriver.waitForAngularRequestsToFinish();

			// wait for the element
			Thread.sleep(5000);

			// click on the side menu
			click("ssc_leftsidemenubtn_CSS");
			ngDriver.waitForAngularRequestsToFinish();
			System.out.println("Clicked on the side menu.");

			// wait for the element
			Thread.sleep(5000);

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
			click("environmental_searchedreport2_XPATH");
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

			// verification of the environmental report is deleted or not

			// enter the newly created environmental report in the search field
			clear("task_listofchecklist_filterfield_CSS");
			type("task_listofchecklist_filterfield_CSS", data.get("title"));
			System.out.println("Entered the newly updated environmental report in the search field.");
			ngDriver.waitForAngularRequestsToFinish();

			deleteVerification("environmental_searchedreport2_XPATH", "Test Environmental Report Count 2");

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
