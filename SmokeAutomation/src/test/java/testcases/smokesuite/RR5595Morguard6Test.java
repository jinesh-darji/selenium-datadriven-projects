package testcases.smokesuite;

import java.io.IOException;
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

public class RR5595Morguard6Test extends TestBase {

	@Test(dataProviderClass = TestUtil.class, dataProvider = "dp")
	public void rR5595Morguard6Test(Hashtable<String, String> data) throws IOException, InterruptedException {

		if (!(TestUtil.isTestRunnable("rR5595Morguard6Test", excel))) {

			throw new SkipException(
					"Skipping the test " + "rR5595Morguard6Test".toUpperCase() + "as the Run mode is NO");
		}

		if (!data.get("runmode").equals("Y")) {

			throw new SkipException("Skipping the test case as the Run Mode for data set is NO");
		}

		// refresh the page
		driver.navigate().refresh();
		Thread.sleep(5000);
		driver.navigate().refresh();

		// ENVIRONMENTAL ASSESSMENT DASHBOARD - VERIFICATION OF THE PROPERTIES NOT
		// ASSESSED COUNT - RR-4143

		System.out.println(
				"******************** ENVIRONMENTAL ASSESSMENT DASHBOARD - VERIFICATION OF THE PROPERTIES NOT ASSESSED COUNT - RR-4143 ********************");
		test.log(LogStatus.INFO,
				"******************** ENVIRONMENTAL ASSESSMENT DASHBOARD - VERIFICATION OF THE PROPERTIES NOT ASSESSED COUNT - RR-4143 ********************");
		Reporter.log(
				"******************** ENVIRONMENTAL ASSESSMENT DASHBOARD - VERIFICATION OF THE PROPERTIES NOT ASSESSED COUNT - RR-4143 ********************");
		log.info(
				"******************** ENVIRONMENTAL ASSESSMENT DASHBOARD - VERIFICATION OF THE PROPERTIES NOT ASSESSED COUNT - RR-4143 ********************");

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

		// DELETE PREVIOUSLY CREATED ENVIRONMENTAL REPORT FROM PROPERTY 2

		System.out.println(
				"******************** DELETE PREVIOUSLY CREATED ENVIRONMENTAL REPORT FROM PROPERTY 2 ********************");
		test.log(LogStatus.INFO,
				"******************** DELETE PREVIOUSLY CREATED ENVIRONMENTAL REPORT FROM PROPERTY 2 ********************");
		Reporter.log(
				"******************** DELETE PREVIOUSLY CREATED ENVIRONMENTAL REPORT FROM PROPERTY 2 ********************");
		log.info(
				"******************** DELETE PREVIOUSLY CREATED ENVIRONMENTAL REPORT FROM PROPERTY 2 ********************");

		try {

			// enter the property name in the search field
			clear("envreports_propertylist_filtertxt_CSS");
			type("envreports_propertylist_filtertxt_CSS", data.get("property_2"));
			ngDriver.waitForAngularRequestsToFinish();
			System.out.println("Entered the property name in the search field.");

			// click on the environmental icon from the property list page
			click("environmentalicon_CSS");
			System.out.println("Clicked on the environmental icon of the Property.");
			ngDriver.waitForAngularRequestsToFinish();
			System.out.println("Navigate to the environmental screen of the perticular property.");

			// wait for the element
			Thread.sleep(5000);

			// click on the burger menu
			click("menubtn_CSS");
			System.out.println("Clicked on the burger menu button successfully!!!");
			ngDriver.waitForAngularRequestsToFinish();

			// wait for the element
			Thread.sleep(5000);

			// click on the Environmental Reports option
			click("envreportoption_XPATH");
			System.out.println("Clicked on the Environmental Reports option.");
			ngDriver.waitForAngularRequestsToFinish();
			System.out.println("Navigate to the Environmental Report Screen.");

			// collect all the report

			List<WebElement> reportList = driver.findElements(By.xpath(OR.getProperty("envreport_totalreports_XPATH")));
			int reportCount = reportList.size();

			System.out.println("reportCount:::::::::::::::::::" + reportCount);

			for (int i = 1; i <= reportCount; i++) {

				List<WebElement> reportList1 = driver
						.findElements(By.xpath(OR.getProperty("envreport_totalreports_XPATH")));
				int maxProducts = reportList1.size();
				Random random = new Random();
				int randomProduct = random.nextInt(maxProducts);
				reportList1.get(randomProduct).click();
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

		// DELETE PREVIOUSLY CREATED ENVIRONMENTAL REPORT FROM PROPERTY 4

		System.out.println(
				"******************** DELETE PREVIOUSLY CREATED ENVIRONMENTAL REPORT FROM PROPERTY 4 ********************");
		test.log(LogStatus.INFO,
				"******************** DELETE PREVIOUSLY CREATED ENVIRONMENTAL REPORT FROM PROPERTY 4 ********************");
		Reporter.log(
				"******************** DELETE PREVIOUSLY CREATED ENVIRONMENTAL REPORT FROM PROPERTY 4 ********************");
		log.info(
				"******************** DELETE PREVIOUSLY CREATED ENVIRONMENTAL REPORT FROM PROPERTY 4 ********************");

		try {

			// enter the property name in the search field
			clear("envreports_propertylist_filtertxt_CSS");
			type("envreports_propertylist_filtertxt_CSS", data.get("property_2"));
			ngDriver.waitForAngularRequestsToFinish();
			System.out.println("Entered the property name in the search field.");

			// click on the environmental icon from the property list page
			click("environmentalicon_CSS");
			System.out.println("Clicked on the environmental icon of the Property.");
			ngDriver.waitForAngularRequestsToFinish();
			System.out.println("Navigate to the environmental screen of the perticular property.");

			// wait for the element
			Thread.sleep(5000);

			// click on the burger menu
			click("menubtn_CSS");
			System.out.println("Clicked on the burger menu button successfully!!!");
			ngDriver.waitForAngularRequestsToFinish();

			// wait for the element
			Thread.sleep(5000);

			// click on the Environmental Reports option
			click("envreportoption_XPATH");
			System.out.println("Clicked on the Environmental Reports option.");
			ngDriver.waitForAngularRequestsToFinish();
			System.out.println("Navigate to the Environmental Report Screen.");

			// collect all the report

			List<WebElement> reportList = driver.findElements(By.xpath(OR.getProperty("envreport_totalreports_XPATH")));
			int reportCount1 = reportList.size();

			System.out.println("reportCount1:::::::::::::::::::" + reportCount1);

			for (int i = 1; i <= reportCount1; i++) {

				List<WebElement> reportList1 = driver
						.findElements(By.xpath(OR.getProperty("envreport_totalreports_XPATH")));
				int maxProducts = reportList1.size();
				Random random = new Random();
				int randomProduct = random.nextInt(maxProducts);
				reportList1.get(randomProduct).click();
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

		// VERIFY THE PHASE-II REPORT CONFIGURATION - UNCHECK THE ASSESSMENT WORKFLOW
		// CHECKBOX

		System.out.println(
				"******************** VERIFY THE PHASE-II REPORT CONFIGURATION - UNCHECK THE ASSESSMENT WORKFLOW CHECKBOX ********************");
		test.log(LogStatus.INFO,
				"******************** VERIFY THE PHASE-II REPORT CONFIGURATION - UNCHECK THE ASSESSMENT WORKFLOW CHECKBOX ********************");
		Reporter.log(
				"******************** VERIFY THE PHASE-II REPORT CONFIGURATION - UNCHECK THE ASSESSMENT WORKFLOW CHECKBOX ********************");
		log.info(
				"******************** VERIFY THE PHASE-II REPORT CONFIGURATION - UNCHECK THE ASSESSMENT WORKFLOW CHECKBOX ********************");

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
			WebElement dropdown = driver
					.findElement(By.xpath(OR.getProperty("environmental_reportlist_phaseIItext_dropdown_XPATH")));
			JavascriptExecutor js = (JavascriptExecutor) driver;
			js.executeScript("arguments[0].scrollIntoView(true);", dropdown);
			js.executeScript("window.scrollBy(0,-400)");

			// click on the drop down of the Phase II ESA report
			click("environmental_reportlist_phaseIItext_dropdown_XPATH");
			ngDriver.waitForAngularRequestsToFinish();
			System.out.println("Clicked on the drop down of the Phase II ESA report.");

			// click on the other options option
			click("environmental_reportlist_phaseIItext_dropdown_otheroption_XPATH");
			ngDriver.waitForAngularRequestsToFinish();
			System.out.println("Clicked on the other options option.");

			// select the level of the environmental report
			select("envreport_leveldd_CSS", data.get("level"));
			ngDriver.waitForAngularRequestsToFinish();
			System.out.println("Selected the level of the environmental report.");

			// verify assessment workflow checkbox is displayed selected or not

			try {
				boolean assessmentckbx = driver
						.findElement(By.xpath(OR.getProperty("envreport_assessmentworkflowckbx_XPATH"))).isSelected();

				if (assessmentckbx == true) {

					// click on the assessment workflow checkbox
					click("envreport_assessmentworkflowckbx_XPATH");
					ngDriver.waitForAngularRequestsToFinish();
					System.out.println("Clicked on the assessment workflow checkbox.");

					System.out.println("THE CHECKBOX OF THE ASSESSMENT WORKFLOW IS DISPLAYED UNSELECTED AS EXPECTED.");
					test.log(LogStatus.INFO,
							"THE CHECKBOX OF THE ASSESSMENT WORKFLOW IS DISPLAYED UNSELECTED AS EXPECTED.");
					Reporter.log("THE CHECKBOX OF THE ASSESSMENT WORKFLOW IS DISPLAYED UNSELECTED AS EXPECTED.");
					log.info("THE CHECKBOX OF THE ASSESSMENT WORKFLOW IS DISPLAYED UNSELECTED AS EXPECTED.");

				} else {

					System.out.println("THE CHECKBOX OF THE ASSESSMENT WORKFLOW IS DISPLAYED UNSELECTED AS EXPECTED.");
					test.log(LogStatus.INFO,
							"THE CHECKBOX OF THE ASSESSMENT WORKFLOW IS DISPLAYED UNSELECTED AS EXPECTED.");
					Reporter.log("THE CHECKBOX OF THE ASSESSMENT WORKFLOW IS DISPLAYED UNSELECTED AS EXPECTED.");
					log.info("THE CHECKBOX OF THE ASSESSMENT WORKFLOW IS DISPLAYED UNSELECTED AS EXPECTED.");
				}

			} catch (Throwable t) {
				System.out.println("THE CHECKBOX OF THE ASSESSMENT WORKFLOW IS DISPLAYED UNSELECTED AS EXPECTED.");
				test.log(LogStatus.INFO,
						"THE CHECKBOX OF THE ASSESSMENT WORKFLOW IS DISPLAYED UNSELECTED AS EXPECTED.");
				Reporter.log("THE CHECKBOX OF THE ASSESSMENT WORKFLOW IS DISPLAYED UNSELECTED AS EXPECTED.");
				log.info("THE CHECKBOX OF THE ASSESSMENT WORKFLOW IS DISPLAYED UNSELECTED AS EXPECTED.");
			}

			// enter the data in the report frequency field
			clear("environmental_reportlist_environmentalactionreporttext_reportfrequencytxt_CSS");
			type("environmental_reportlist_environmentalactionreporttext_reportfrequencytxt_CSS", "4");
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

		// VERIFY ENVIRONMENTAL CARD ON THE ASSESSMENTS/INSPECTIONS DASHBOARD OF THE
		// ENVIRONMENTAL MODULE AFTER UNCHECKED THE ASSESSMENT WORKFLOW CHECKBOX

		System.out.println(
				"******************** VERIFY ENVIRONMENTAL CARD ON THE ASSESSMENTS/INSPECTIONS DASHBOARD OF THE ENVIRONMENTAL MODULE AFTER UNCHECKED THE ASSESSMENT WORKFLOW CHECKBOX ********************");
		test.log(LogStatus.INFO,
				"******************** VERIFY ENVIRONMENTAL CARD ON THE ASSESSMENTS/INSPECTIONS DASHBOARD OF THE ENVIRONMENTAL MODULE AFTER UNCHECKED THE ASSESSMENT WORKFLOW CHECKBOX ********************");
		Reporter.log(
				"******************** VERIFY ENVIRONMENTAL CARD ON THE ASSESSMENTS/INSPECTIONS DASHBOARD OF THE ENVIRONMENTAL MODULE AFTER UNCHECKED THE ASSESSMENT WORKFLOW CHECKBOX ********************");
		log.info(
				"******************** VERIFY ENVIRONMENTAL CARD ON THE ASSESSMENTS/INSPECTIONS DASHBOARD OF THE ENVIRONMENTAL MODULE AFTER UNCHECKED THE ASSESSMENT WORKFLOW CHECKBOX ********************");

		int value = 0;

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

			// scroll down the screen
			JavascriptExecutor js = (JavascriptExecutor) driver;
			WebElement phaseIIreport = driver
					.findElement(By.xpath(OR.getProperty("portfoliodashboard_phaseIIreportcard_XPATH")));
			js.executeScript("arguments[0].scrollIntoView(true);", phaseIIreport);

			switchVerification("portfoliodashboard_phaseIIreportcard_XPATH", "Phase II ESA",
					"The Phase II ESA is not displayed.");

			System.out.println("THE Phase II ESA CARD IS DISPLAYED SUCCESSFULLY.");
			test.log(LogStatus.INFO, "THE Phase II ESA CARD IS DISPLAYED SUCCESSFULLY.");
			Reporter.log("THE Phase II ESA CARD IS DISPLAYED SUCCESSFULLY.");
			log.info("THE Phase II ESA CARD IS DISPLAYED SUCCESSFULLY.");

			try {
				String notAvailableCount = driver
						.findElement(By.cssSelector(OR.getProperty("environmental_notavailablecount_phaseII_CSS")))
						.getText();

				String finalNotAvailableCount = notAvailableCount.trim();

				value = Integer.parseInt(finalNotAvailableCount);

				System.out.println("///////////////////////// value : " + value);

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

		// CREATE ENVIRONMENTAL REPORT WITH THE PHASE II ESA

		System.out
				.println("******************** CREATE ENVIRONMENTAL REPORT WITH THE PHASE II ESA ********************");
		test.log(LogStatus.INFO,
				"******************** CREATE ENVIRONMENTAL REPORT WITH THE PHASE II ESA ********************");
		Reporter.log("******************** CREATE ENVIRONMENTAL REPORT WITH THE PHASE II ESA ********************");
		log.info("******************** CREATE ENVIRONMENTAL REPORT WITH THE PHASE II ESA ********************");

		try {

			// enter the property name in the search field
			type("envreports_propertylist_filtertxt_CSS", data.get("property_2"));
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
			ngDriver.waitForAngularRequestsToFinish();
			System.out.println("Cleared the search field.");
			type("task_listofchecklist_filterfield_CSS", data.get("title"));
			ngDriver.waitForAngularRequestsToFinish();
			System.out.println("Entered the newly created environmental report in the search field.");

			// verify the newly created environmental report is displayed or not
			switchVerification("environmental_searchedreport6_XPATH", "Test Environmental Report Count 6",
					"The Test Environmental Report Count 6 is not displayed.");

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
		// ENVIRONMENTAL MODULE AFTER UNCHECKED THE ASSESSMENT WORKFLOW CHECKBOX

		System.out.println(
				"******************** VERIFY ENVIRONMENTAL CARD ON THE ASSESSMENTS/INSPECTIONS DASHBOARD OF THE ENVIRONMENTAL MODULE AFTER UNCHECKED THE ASSESSMENT WORKFLOW CHECKBOX ********************");
		test.log(LogStatus.INFO,
				"******************** VERIFY ENVIRONMENTAL CARD ON THE ASSESSMENTS/INSPECTIONS DASHBOARD OF THE ENVIRONMENTAL MODULE AFTER UNCHECKED THE ASSESSMENT WORKFLOW CHECKBOX ********************");
		Reporter.log(
				"******************** VERIFY ENVIRONMENTAL CARD ON THE ASSESSMENTS/INSPECTIONS DASHBOARD OF THE ENVIRONMENTAL MODULE AFTER UNCHECKED THE ASSESSMENT WORKFLOW CHECKBOX ********************");
		log.info(
				"******************** VERIFY ENVIRONMENTAL CARD ON THE ASSESSMENTS/INSPECTIONS DASHBOARD OF THE ENVIRONMENTAL MODULE AFTER UNCHECKED THE ASSESSMENT WORKFLOW CHECKBOX ********************");

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

			// scroll down the screen
			JavascriptExecutor js = (JavascriptExecutor) driver;
			WebElement phaseIIreport = driver
					.findElement(By.xpath(OR.getProperty("portfoliodashboard_phaseIIreportcard_XPATH")));
			js.executeScript("arguments[0].scrollIntoView(true);", phaseIIreport);

			switchVerification("portfoliodashboard_phaseIIreportcard_XPATH", "Phase II ESA",
					"The Phase II ESA is not displayed.");

			System.out.println("THE Phase II ESA CARD IS DISPLAYED SUCCESSFULLY.");
			test.log(LogStatus.INFO, "THE Phase II ESA CARD IS DISPLAYED SUCCESSFULLY.");
			Reporter.log("THE Phase II ESA CARD IS DISPLAYED SUCCESSFULLY.");
			log.info("THE Phase II ESA CARD IS DISPLAYED SUCCESSFULLY.");

			try {

				// scroll down the screen
				WebElement phaseIIreport1 = driver
						.findElement(By.xpath(OR.getProperty("portfoliodashboard_phaseIIreportcard_XPATH")));
				js.executeScript("arguments[0].scrollIntoView(true);", phaseIIreport1);

				switchVerification("portfoliodashboard_phaseIIreportcard_XPATH", "Phase II ESA",
						"The Phase II ESA is not displayed.");

				System.out.println("THE Phase II ESA CARD IS DISPLAYED SUCCESSFULLY.");
				test.log(LogStatus.INFO, "THE Phase II ESA CARD IS DISPLAYED SUCCESSFULLY.");
				Reporter.log("THE Phase II ESA CARD IS DISPLAYED SUCCESSFULLY.");
				log.info("THE Phase II ESA CARD IS DISPLAYED SUCCESSFULLY.");

				String notAvailableCount = driver
						.findElement(By.cssSelector(OR.getProperty("environmental_notavailablecount_phaseII_CSS")))
						.getText();

				String finalNotAvailableCount = notAvailableCount.trim();

				int value2 = Integer.parseInt(finalNotAvailableCount);

				System.out.println("///////////////////////// finalNotAvailableCount : " + value);
				System.out.println("///////////////////////// finalNotAvailableCount2 : " + value2);

				if (value == (value2 + 1)) {

					System.out.println("THE COUNT OF THE PHASE II IS DISPLAYED CORRECT.");
					test.log(LogStatus.INFO, "THE COUNT OF THE PHASE II IS DISPLAYED CORRECT.");
					Reporter.log("THE COUNT OF THE PHASE II IS DISPLAYED CORRECT.");
					log.info("THE COUNT OF THE PHASE II IS DISPLAYED CORRECT.");
				} else {

					verificationFailed();

					System.out.println("THE COUNT OF THE PHASE II IS NOT DISPLAYED CORRECT.");
					test.log(LogStatus.INFO, "THE COUNT OF THE PHASE II IS NOT DISPLAYED CORRECT.");
					Reporter.log("THE COUNT OF THE PHASE II IS NOT DISPLAYED CORRECT.");
					log.info("THE COUNT OF THE PHASE II IS NOT DISPLAYED CORRECT.");

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

		// DELETE THE ENVIRONMENTAL REPORT - SUPER ADMIN USER

		System.out.println("******************** DELETE THE ENVIRONMENTAL REPORT ********************");
		test.log(LogStatus.INFO, "******************** DELETE THE ENVIRONMENTAL REPORT ********************");
		Reporter.log("******************** DELETE THE ENVIRONMENTAL REPORT ********************");
		log.info("******************** DELETE THE ENVIRONMENTAL REPORT ********************");

		try {

			// enter the property name in the search field
			type("envreports_propertylist_filtertxt_CSS", data.get("property_2"));
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
			ngDriver.waitForAngularRequestsToFinish();
			System.out.println("Cleared the search field.");
			type("task_listofchecklist_filterfield_CSS", data.get("title"));
			ngDriver.waitForAngularRequestsToFinish();
			System.out.println("Entered environmental report in the search field.");

			// click on the environmental report
			click("environmental_searchedreport6_XPATH");
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
			System.out.println("Cleared the search field.");
			ngDriver.waitForAngularRequestsToFinish();
			type("task_listofchecklist_filterfield_CSS", data.get("title"));
			System.out.println("Entered the newly updated environmental report in the search field.");
			ngDriver.waitForAngularRequestsToFinish();

			deleteVerification("environmental_searchedreport6_XPATH", "Test Environmental Report Count 6");

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

		// VERIFY THE PHASE-II REPORT CONFIGURATION - CHECK THE ASSESSMENT WORKFLOW
		// CHECKBOX

		System.out.println(
				"******************** VERIFY THE PHASE-II REPORT CONFIGURATION - CHECK THE ASSESSMENT WORKFLOW CHECKBOX ********************");
		test.log(LogStatus.INFO,
				"******************** VERIFY THE PHASE-II REPORT CONFIGURATION - CHECK THE ASSESSMENT WORKFLOW CHECKBOX ********************");
		Reporter.log(
				"******************** VERIFY THE PHASE-II REPORT CONFIGURATION - CHECK THE ASSESSMENT WORKFLOW CHECKBOX ********************");
		log.info(
				"******************** VERIFY THE PHASE-II REPORT CONFIGURATION - CHECK THE ASSESSMENT WORKFLOW CHECKBOX ********************");

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
			WebElement dropdown = driver
					.findElement(By.xpath(OR.getProperty("environmental_reportlist_phaseIItext_dropdown_XPATH")));
			JavascriptExecutor js = (JavascriptExecutor) driver;
			js.executeScript("arguments[0].scrollIntoView(true);", dropdown);
			js.executeScript("window.scrollBy(0,-400)");

			// click on the drop down of the Phase II ESA report
			click("environmental_reportlist_phaseIItext_dropdown_XPATH");
			ngDriver.waitForAngularRequestsToFinish();
			System.out.println("Clicked on the drop down of the Phase II ESA report.");

			// click on the other options option
			click("environmental_reportlist_phaseIItext_dropdown_otheroption_XPATH");
			ngDriver.waitForAngularRequestsToFinish();
			System.out.println("Clicked on the other options option.");

			// select the level of the environmental report
			select("envreport_leveldd_CSS", data.get("level"));
			ngDriver.waitForAngularRequestsToFinish();
			System.out.println("Selected the level of the environmental report.");

			// verify assessment workflow checkbox is displayed selected or not

			try {
				boolean assessmentckbx = driver
						.findElement(By.xpath(OR.getProperty("envreport_assessmentworkflowckbx_XPATH"))).isSelected();

				if (assessmentckbx == true) {

					System.out.println("THE CHECKBOX OF THE ASSESSMENT WORKFLOW IS DISPLAYED SELECTED AS EXPECTED.");
					test.log(LogStatus.INFO,
							"THE CHECKBOX OF THE ASSESSMENT WORKFLOW IS DISPLAYED SELECTED AS EXPECTED.");
					Reporter.log("THE CHECKBOX OF THE ASSESSMENT WORKFLOW IS DISPLAYED SELECTED AS EXPECTED.");
					log.info("THE CHECKBOX OF THE ASSESSMENT WORKFLOW IS DISPLAYED SELECTED AS EXPECTED.");

				} else {

					// click on the assessment workflow checkbox
					click("envreport_assessmentworkflowckbx_XPATH");
					ngDriver.waitForAngularRequestsToFinish();
					System.out.println("Clicked on the assessment workflow checkbox.");

					System.out.println("THE CHECKBOX OF THE ASSESSMENT WORKFLOW IS DISPLAYED SELECTED AS EXPECTED.");
					test.log(LogStatus.INFO,
							"THE CHECKBOX OF THE ASSESSMENT WORKFLOW IS DISPLAYED SELECTED AS EXPECTED.");
					Reporter.log("THE CHECKBOX OF THE ASSESSMENT WORKFLOW IS DISPLAYED SELECTED AS EXPECTED.");
					log.info("THE CHECKBOX OF THE ASSESSMENT WORKFLOW IS DISPLAYED SELECTED AS EXPECTED.");
				}

			} catch (Throwable t) {

				// click on the assessment workflow checkbox
				click("envreport_assessmentworkflowckbx_XPATH");
				ngDriver.waitForAngularRequestsToFinish();
				System.out.println("Clicked on the assessment workflow checkbox.");

				System.out.println("THE CHECKBOX OF THE ASSESSMENT WORKFLOW IS DISPLAYED SELECTED AS EXPECTED.");
				test.log(LogStatus.INFO, "THE CHECKBOX OF THE ASSESSMENT WORKFLOW IS DISPLAYED SELECTED AS EXPECTED.");
				Reporter.log("THE CHECKBOX OF THE ASSESSMENT WORKFLOW IS DISPLAYED SELECTED AS EXPECTED.");
				log.info("THE CHECKBOX OF THE ASSESSMENT WORKFLOW IS DISPLAYED SELECTED AS EXPECTED.");
			}

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

		// VERIFY ENVIRONMENTAL CARD ON THE ASSESSMENTS/INSPECTIONS DASHBOARD OF THE
		// ENVIRONMENTAL MODULE AFTER UNCHECKED THE ASSESSMENT WORKFLOW CHECKBOX

		System.out.println(
				"******************** VERIFY ENVIRONMENTAL CARD ON THE ASSESSMENTS/INSPECTIONS DASHBOARD OF THE ENVIRONMENTAL MODULE AFTER UNCHECKED THE ASSESSMENT WORKFLOW CHECKBOX ********************");
		test.log(LogStatus.INFO,
				"******************** VERIFY ENVIRONMENTAL CARD ON THE ASSESSMENTS/INSPECTIONS DASHBOARD OF THE ENVIRONMENTAL MODULE AFTER UNCHECKED THE ASSESSMENT WORKFLOW CHECKBOX ********************");
		Reporter.log(
				"******************** VERIFY ENVIRONMENTAL CARD ON THE ASSESSMENTS/INSPECTIONS DASHBOARD OF THE ENVIRONMENTAL MODULE AFTER UNCHECKED THE ASSESSMENT WORKFLOW CHECKBOX ********************");
		log.info(
				"******************** VERIFY ENVIRONMENTAL CARD ON THE ASSESSMENTS/INSPECTIONS DASHBOARD OF THE ENVIRONMENTAL MODULE AFTER UNCHECKED THE ASSESSMENT WORKFLOW CHECKBOX ********************");

		int value1 = 0;

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

			// scroll down the screen
			JavascriptExecutor js = (JavascriptExecutor) driver;
			WebElement phaseIIreport = driver
					.findElement(By.xpath(OR.getProperty("portfoliodashboard_phaseIIreportcard_XPATH")));
			js.executeScript("arguments[0].scrollIntoView(true);", phaseIIreport);

			switchVerification("portfoliodashboard_phaseIIreportcard_XPATH", "Phase II ESA",
					"The Phase II ESA is not displayed.");

			System.out.println("THE Phase II ESA CARD IS DISPLAYED SUCCESSFULLY.");
			test.log(LogStatus.INFO, "THE Phase II ESA CARD IS DISPLAYED SUCCESSFULLY.");
			Reporter.log("THE Phase II ESA CARD IS DISPLAYED SUCCESSFULLY.");
			log.info("THE Phase II ESA CARD IS DISPLAYED SUCCESSFULLY.");

			try {
				String notAvailableCount = driver
						.findElement(By.cssSelector(OR.getProperty("environmental_notavailablecount_phaseII_CSS")))
						.getText();

				String finalNotAvailableCount = notAvailableCount.trim();

				value1 = Integer.parseInt(finalNotAvailableCount);

				System.out.println("///////////////////////// value1 : " + value1);

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

		// CREATE ENVIRONMENTAL REPORT WITH THE PHASE II ESA - SELECT YES OPTION IN
		// ASSESSMENT

		System.out.println(
				"******************** CREATE ENVIRONMENTAL REPORT WITH THE PHASE II ESA - SELECT YES OPTION IN ASSESSMENT ********************");
		test.log(LogStatus.INFO,
				"******************** CREATE ENVIRONMENTAL REPORT WITH THE PHASE II ESA - SELECT YES OPTION IN ASSESSMENT ********************");
		Reporter.log(
				"******************** CREATE ENVIRONMENTAL REPORT WITH THE PHASE II ESA - SELECT YES OPTION IN ASSESSMENT ********************");
		log.info(
				"******************** CREATE ENVIRONMENTAL REPORT WITH THE PHASE II ESA - SELECT YES OPTION IN ASSESSMENT ********************");

		try {

			// enter the property name in the search field
			type("envreports_propertylist_filtertxt_CSS", data.get("property_2"));
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

			// enter the title
			type("envreporttitletxt_CSS", data.get("title_yesbtn"));
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

			// click on the yes button
			click("envreport_assessment_yesbtn_CSS");
			ngDriver.waitForAngularRequestsToFinish();
			System.out.println("Clicked on the yes button.");

			// verify the redirection of the screen
			switchVerification("envreport_assessment_title_XPATH", "Environmental Reports Record",
					"The Environmental Reports Record title is not displayed.");

			// click on the update button
			click("envreportupdatebtn_CSS");
			ngDriver.waitForAngularRequestsToFinish();
			System.out.println("Clicked on the update button.");

			// wait for the element
			Thread.sleep(5000);

			// enter the newly created environmental report in the search field
			clear("task_listofchecklist_filterfield_CSS");
			ngDriver.waitForAngularRequestsToFinish();
			System.out.println("Cleared the search field.");
			type("task_listofchecklist_filterfield_CSS", data.get("title_yesbtn"));
			ngDriver.waitForAngularRequestsToFinish();
			System.out.println("Entered the newly created environmental report in the search field.");

			// verify the newly created environmental report is displayed or not
			switchVerification("environmental_searchedreport6_yesbtn_XPATH",
					"Test Environmental Report Count 6 Yes Button",
					"The Test Environmental Report Count 6 Yes Button is not displayed.");

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
		// ENVIRONMENTAL MODULE AFTER UNCHECKED THE ASSESSMENT WORKFLOW CHECKBOX

		System.out.println(
				"******************** VERIFY ENVIRONMENTAL CARD ON THE ASSESSMENTS/INSPECTIONS DASHBOARD OF THE ENVIRONMENTAL MODULE AFTER UNCHECKED THE ASSESSMENT WORKFLOW CHECKBOX ********************");
		test.log(LogStatus.INFO,
				"******************** VERIFY ENVIRONMENTAL CARD ON THE ASSESSMENTS/INSPECTIONS DASHBOARD OF THE ENVIRONMENTAL MODULE AFTER UNCHECKED THE ASSESSMENT WORKFLOW CHECKBOX ********************");
		Reporter.log(
				"******************** VERIFY ENVIRONMENTAL CARD ON THE ASSESSMENTS/INSPECTIONS DASHBOARD OF THE ENVIRONMENTAL MODULE AFTER UNCHECKED THE ASSESSMENT WORKFLOW CHECKBOX ********************");
		log.info(
				"******************** VERIFY ENVIRONMENTAL CARD ON THE ASSESSMENTS/INSPECTIONS DASHBOARD OF THE ENVIRONMENTAL MODULE AFTER UNCHECKED THE ASSESSMENT WORKFLOW CHECKBOX ********************");

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

			// scroll down the screen
			JavascriptExecutor js = (JavascriptExecutor) driver;
			WebElement phaseIIreport = driver
					.findElement(By.xpath(OR.getProperty("portfoliodashboard_phaseIIreportcard_XPATH")));
			js.executeScript("arguments[0].scrollIntoView(true);", phaseIIreport);

			switchVerification("portfoliodashboard_phaseIIreportcard_XPATH", "Phase II ESA",
					"The Phase II ESA is not displayed.");

			System.out.println("THE Phase II ESA CARD IS DISPLAYED SUCCESSFULLY.");
			test.log(LogStatus.INFO, "THE Phase II ESA CARD IS DISPLAYED SUCCESSFULLY.");
			Reporter.log("THE Phase II ESA CARD IS DISPLAYED SUCCESSFULLY.");
			log.info("THE Phase II ESA CARD IS DISPLAYED SUCCESSFULLY.");

			try {

				// scroll down the screen
				WebElement phaseIIreport1 = driver
						.findElement(By.xpath(OR.getProperty("portfoliodashboard_phaseIIreportcard_XPATH")));
				js.executeScript("arguments[0].scrollIntoView(true);", phaseIIreport1);

				switchVerification("portfoliodashboard_phaseIIreportcard_XPATH", "Phase II ESA",
						"The Phase II ESA is not displayed.");

				System.out.println("THE Phase II ESA CARD IS DISPLAYED SUCCESSFULLY.");
				test.log(LogStatus.INFO, "THE Phase II ESA CARD IS DISPLAYED SUCCESSFULLY.");
				Reporter.log("THE Phase II ESA CARD IS DISPLAYED SUCCESSFULLY.");
				log.info("THE Phase II ESA CARD IS DISPLAYED SUCCESSFULLY.");

				String notAvailableCount = driver
						.findElement(By.cssSelector(OR.getProperty("environmental_notavailablecount_phaseII_CSS")))
						.getText();

				String finalNotAvailableCount = notAvailableCount.trim();

				int value11 = Integer.parseInt(finalNotAvailableCount);

				System.out.println("///////////////////////// finalNotAvailableCount : " + value1);
				System.out.println("///////////////////////// finalNotAvailableCount11 : " + value11);

				if (value1 == (value11 + 1)) {

					System.out.println("THE COUNT OF THE PHASE II IS DISPLAYED CORRECT.");
					test.log(LogStatus.INFO, "THE COUNT OF THE PHASE II IS DISPLAYED CORRECT.");
					Reporter.log("THE COUNT OF THE PHASE II IS DISPLAYED CORRECT.");
					log.info("THE COUNT OF THE PHASE II IS DISPLAYED CORRECT.");
				} else {

					verificationFailed();

					System.out.println("THE COUNT OF THE PHASE II IS NOT DISPLAYED CORRECT.");
					test.log(LogStatus.INFO, "THE COUNT OF THE PHASE II IS NOT DISPLAYED CORRECT.");
					Reporter.log("THE COUNT OF THE PHASE II IS NOT DISPLAYED CORRECT.");
					log.info("THE COUNT OF THE PHASE II IS NOT DISPLAYED CORRECT.");

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

		// CREATE ENVIRONMENTAL REPORT WITH THE PHASE II ESA - SELECT NO OPTION IN
		// ASSESSMENT

		System.out.println(
				"******************** CREATE ENVIRONMENTAL REPORT WITH THE PHASE II ESA - SELECT NO OPTION IN ASSESSMENT ********************");
		test.log(LogStatus.INFO,
				"******************** CREATE ENVIRONMENTAL REPORT WITH THE PHASE II ESA - SELECT NO OPTION IN ASSESSMENT ********************");
		Reporter.log(
				"******************** CREATE ENVIRONMENTAL REPORT WITH THE PHASE II ESA - SELECT NO OPTION IN ASSESSMENT ********************");
		log.info(
				"******************** CREATE ENVIRONMENTAL REPORT WITH THE PHASE II ESA - SELECT NO OPTION IN ASSESSMENT ********************");

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

			// enter the title
			type("envreporttitletxt_CSS", data.get("title_nobtn"));
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

			// click on the no button
			click("envreport_assessment_nobtn_CSS");
			ngDriver.waitForAngularRequestsToFinish();
			System.out.println("Clicked on the yes button.");

			// verify the redirection of the screen
			switchVerification("envreport_title_XPATH", "Environmental Reports",
					"The Environmental Reports title is not displayed.");

			// wait for the element
			Thread.sleep(5000);

			// enter the newly created environmental report in the search field
			clear("task_listofchecklist_filterfield_CSS");
			ngDriver.waitForAngularRequestsToFinish();
			System.out.println("Cleared the search field.");
			type("task_listofchecklist_filterfield_CSS", data.get("title_nobtn"));
			ngDriver.waitForAngularRequestsToFinish();
			System.out.println("Entered the newly created environmental report in the search field.");

			// verify the newly created environmental report is displayed or not
			switchVerification("environmental_searchedreport6_nobtn_XPATH",
					"Test Environmental Report Count 6 No Button",
					"The Test Environmental Report Count 6 No Button is not displayed.");

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
		// ENVIRONMENTAL MODULE AFTER CHECKED THE ASSESSMENT WORKFLOW CHECKBOX

		System.out.println(
				"******************** VERIFY ENVIRONMENTAL CARD ON THE ASSESSMENTS/INSPECTIONS DASHBOARD OF THE ENVIRONMENTAL MODULE AFTER CHECKED THE ASSESSMENT WORKFLOW CHECKBOX ********************");
		test.log(LogStatus.INFO,
				"******************** VERIFY ENVIRONMENTAL CARD ON THE ASSESSMENTS/INSPECTIONS DASHBOARD OF THE ENVIRONMENTAL MODULE AFTER CHECKED THE ASSESSMENT WORKFLOW CHECKBOX ********************");
		Reporter.log(
				"******************** VERIFY ENVIRONMENTAL CARD ON THE ASSESSMENTS/INSPECTIONS DASHBOARD OF THE ENVIRONMENTAL MODULE AFTER CHECKED THE ASSESSMENT WORKFLOW CHECKBOX ********************");
		log.info(
				"******************** VERIFY ENVIRONMENTAL CARD ON THE ASSESSMENTS/INSPECTIONS DASHBOARD OF THE ENVIRONMENTAL MODULE AFTER CHECKED THE ASSESSMENT WORKFLOW CHECKBOX ********************");

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

			// scroll down the screen
			JavascriptExecutor js = (JavascriptExecutor) driver;
			WebElement phaseIIreport = driver
					.findElement(By.xpath(OR.getProperty("portfoliodashboard_phaseIIreportcard_XPATH")));
			js.executeScript("arguments[0].scrollIntoView(true);", phaseIIreport);

			switchVerification("portfoliodashboard_phaseIIreportcard_XPATH", "Phase II ESA",
					"The Phase II ESA is not displayed.");

			System.out.println("THE Phase II ESA CARD IS DISPLAYED SUCCESSFULLY.");
			test.log(LogStatus.INFO, "THE Phase II ESA CARD IS DISPLAYED SUCCESSFULLY.");
			Reporter.log("THE Phase II ESA CARD IS DISPLAYED SUCCESSFULLY.");
			log.info("THE Phase II ESA CARD IS DISPLAYED SUCCESSFULLY.");

			try {

				// scroll down the screen
				WebElement phaseIIreport1 = driver
						.findElement(By.xpath(OR.getProperty("portfoliodashboard_phaseIIreportcard_XPATH")));
				js.executeScript("arguments[0].scrollIntoView(true);", phaseIIreport1);

				switchVerification("portfoliodashboard_phaseIIreportcard_XPATH", "Phase II ESA",
						"The Phase II ESA is not displayed.");

				System.out.println("THE Phase II ESA CARD IS DISPLAYED SUCCESSFULLY.");
				test.log(LogStatus.INFO, "THE Phase II ESA CARD IS DISPLAYED SUCCESSFULLY.");
				Reporter.log("THE Phase II ESA CARD IS DISPLAYED SUCCESSFULLY.");
				log.info("THE Phase II ESA CARD IS DISPLAYED SUCCESSFULLY.");

				String notAvailableCount = driver
						.findElement(By.cssSelector(OR.getProperty("environmental_notavailablecount_phaseII_CSS")))
						.getText();

				String finalNotAvailableCount = notAvailableCount.trim();

				int value22 = Integer.parseInt(finalNotAvailableCount);

				System.out.println("///////////////////////// finalNotAvailableCount : " + value1);
				System.out.println("///////////////////////// finalNotAvailableCount22 : " + value22);

				if (value1 == (value22 + 2)) {

					System.out.println("THE COUNT OF THE PHASE II IS DISPLAYED CORRECT.");
					test.log(LogStatus.INFO, "THE COUNT OF THE PHASE II IS DISPLAYED CORRECT.");
					Reporter.log("THE COUNT OF THE PHASE II IS DISPLAYED CORRECT.");
					log.info("THE COUNT OF THE PHASE II IS DISPLAYED CORRECT.");
				} else {

					verificationFailed();

					System.out.println("THE COUNT OF THE PHASE II IS NOT DISPLAYED CORRECT.");
					test.log(LogStatus.INFO, "THE COUNT OF THE PHASE II IS NOT DISPLAYED CORRECT.");
					Reporter.log("THE COUNT OF THE PHASE II IS NOT DISPLAYED CORRECT.");
					log.info("THE COUNT OF THE PHASE II IS NOT DISPLAYED CORRECT.");

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

		// DELETE THE ENVIRONMENTAL REPORT - PROPERTY 2

		System.out.println("******************** DELETE THE ENVIRONMENTAL REPORT - PROPERTY 2 ********************");
		test.log(LogStatus.INFO,
				"******************** DELETE THE ENVIRONMENTAL REPORT - PROPERTY 2 ********************");
		Reporter.log("******************** DELETE THE ENVIRONMENTAL REPORT - PROPERTY 2 ********************");
		log.info("******************** DELETE THE ENVIRONMENTAL REPORT - PROPERTY 2 ********************");

		try {

			// enter the property name in the search field
			type("envreports_propertylist_filtertxt_CSS", data.get("property_2"));
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
			ngDriver.waitForAngularRequestsToFinish();
			System.out.println("Cleared the search field.");
			type("task_listofchecklist_filterfield_CSS", data.get("title_yesbtn"));
			ngDriver.waitForAngularRequestsToFinish();
			System.out.println("Entered environmental report in the search field.");

			// click on the environmental report
			click("environmental_searchedreport6_yesbtn_XPATH");
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

			// enter the newly created environmental report in the search field
			clear("task_listofchecklist_filterfield_CSS");
			System.out.println("Cleared the search field.");
			ngDriver.waitForAngularRequestsToFinish();
			type("task_listofchecklist_filterfield_CSS", data.get("title_yesbtn"));
			System.out.println("Entered the newly updated environmental report in the search field.");
			ngDriver.waitForAngularRequestsToFinish();

			// verification of the environmental report is deleted or not
			deleteVerification("environmental_searchedreport6_yesbtn_XPATH",
					"Test Environmental Report Count 6 Yes Button");

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

		// DELETE THE ENVIRONMENTAL REPORT - PROPERTY 4

		System.out.println("******************** DELETE THE ENVIRONMENTAL REPORT - PROPERTY 4 ********************");
		test.log(LogStatus.INFO,
				"******************** DELETE THE ENVIRONMENTAL REPORT - PROPERTY 4 ********************");
		Reporter.log("******************** DELETE THE ENVIRONMENTAL REPORT - PROPERTY 4 ********************");
		log.info("******************** DELETE THE ENVIRONMENTAL REPORT - PROPERTY 4 ********************");

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
			type("task_listofchecklist_filterfield_CSS", data.get("title_nobtn"));
			ngDriver.waitForAngularRequestsToFinish();
			System.out.println("Entered environmental report in the search field.");

			// click on the environmental report
			click("environmental_searchedreport6_nobtn_XPATH");
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
			System.out.println("Cleared the search field.");
			ngDriver.waitForAngularRequestsToFinish();
			type("task_listofchecklist_filterfield_CSS", data.get("title_nobtn"));
			System.out.println("Entered the newly updated environmental report in the search field.");
			ngDriver.waitForAngularRequestsToFinish();

			// verification of the environmental report is deleted or not
			deleteVerification("environmental_searchedreport6_nobtn_XPATH",
					"Test Environmental Report Count 6 No Button");

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

		// VERIFY ENVIRONMENTAL CARD ON THE ASSESSMENTS/INSPECTIONS DASHBOARD OF THE
		// ENVIRONMENTAL MODULE AFTER DELETE THE ENVIRONMENTAL REPORT

		System.out.println(
				"******************** VERIFY ENVIRONMENTAL CARD ON THE ASSESSMENTS/INSPECTIONS DASHBOARD OF THE ENVIRONMENTAL MODULE AFTER DELETE THE ENVIRONMENTAL REPORT ********************");
		test.log(LogStatus.INFO,
				"******************** VERIFY ENVIRONMENTAL CARD ON THE ASSESSMENTS/INSPECTIONS DASHBOARD OF THE ENVIRONMENTAL MODULE AFTER DELETE THE ENVIRONMENTAL REPORT ********************");
		Reporter.log(
				"******************** VERIFY ENVIRONMENTAL CARD ON THE ASSESSMENTS/INSPECTIONS DASHBOARD OF THE ENVIRONMENTAL MODULE AFTER DELETE THE ENVIRONMENTAL REPORT ********************");
		log.info(
				"******************** VERIFY ENVIRONMENTAL CARD ON THE ASSESSMENTS/INSPECTIONS DASHBOARD OF THE ENVIRONMENTAL MODULE AFTER DELETE THE ENVIRONMENTAL REPORT ********************");

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

			// scroll down the screen
			JavascriptExecutor js = (JavascriptExecutor) driver;
			WebElement phaseIIreport = driver
					.findElement(By.xpath(OR.getProperty("portfoliodashboard_phaseIIreportcard_XPATH")));
			js.executeScript("arguments[0].scrollIntoView(true);", phaseIIreport);

			switchVerification("portfoliodashboard_phaseIIreportcard_XPATH", "Phase II ESA",
					"The Phase II ESA is not displayed.");

			System.out.println("THE Phase II ESA CARD IS DISPLAYED SUCCESSFULLY.");
			test.log(LogStatus.INFO, "THE Phase II ESA CARD IS DISPLAYED SUCCESSFULLY.");
			Reporter.log("THE Phase II ESA CARD IS DISPLAYED SUCCESSFULLY.");
			log.info("THE Phase II ESA CARD IS DISPLAYED SUCCESSFULLY.");

			try {

				// scroll down the screen
				WebElement phaseIIreport1 = driver
						.findElement(By.xpath(OR.getProperty("portfoliodashboard_phaseIIreportcard_XPATH")));
				js.executeScript("arguments[0].scrollIntoView(true);", phaseIIreport1);

				switchVerification("portfoliodashboard_phaseIIreportcard_XPATH", "Phase II ESA",
						"The Phase II ESA is not displayed.");

				System.out.println("THE Phase II ESA CARD IS DISPLAYED SUCCESSFULLY.");
				test.log(LogStatus.INFO, "THE Phase II ESA CARD IS DISPLAYED SUCCESSFULLY.");
				Reporter.log("THE Phase II ESA CARD IS DISPLAYED SUCCESSFULLY.");
				log.info("THE Phase II ESA CARD IS DISPLAYED SUCCESSFULLY.");

				String notAvailableCount = driver
						.findElement(By.cssSelector(OR.getProperty("environmental_notavailablecount_phaseII_CSS")))
						.getText();

				String finalNotAvailableCount = notAvailableCount.trim();

				int value33 = Integer.parseInt(finalNotAvailableCount);

				System.out.println("///////////////////////// finalNotAvailableCount : " + value1);
				System.out.println("///////////////////////// finalNotAvailableCount33 : " + value33);

				if (value1 == value33) {

					System.out.println("THE COUNT OF THE PHASE II IS DISPLAYED CORRECT.");
					test.log(LogStatus.INFO, "THE COUNT OF THE PHASE II IS DISPLAYED CORRECT.");
					Reporter.log("THE COUNT OF THE PHASE II IS DISPLAYED CORRECT.");
					log.info("THE COUNT OF THE PHASE II IS DISPLAYED CORRECT.");
				} else {

					verificationFailed();

					System.out.println("THE COUNT OF THE PHASE II IS NOT DISPLAYED CORRECT.");
					test.log(LogStatus.INFO, "THE COUNT OF THE PHASE II IS NOT DISPLAYED CORRECT.");
					Reporter.log("THE COUNT OF THE PHASE II IS NOT DISPLAYED CORRECT.");
					log.info("THE COUNT OF THE PHASE II IS NOT DISPLAYED CORRECT.");

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

		// RESET THE PHASE-II REPORT CONFIGURATION

		System.out.println("******************** RESET THE PHASE-II REPORT CONFIGURATION ********************");
		test.log(LogStatus.INFO, "******************** RESET THE PHASE-II REPORT CONFIGURATION ********************");
		Reporter.log("******************** RESET THE PHASE-II REPORT CONFIGURATION ********************");
		log.info("******************** RESET THE PHASE-II REPORT CONFIGURATION ********************");

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
			WebElement dropdown = driver
					.findElement(By.xpath(OR.getProperty("environmental_reportlist_phaseIItext_dropdown_XPATH")));
			JavascriptExecutor js = (JavascriptExecutor) driver;
			js.executeScript("arguments[0].scrollIntoView(true);", dropdown);
			js.executeScript("window.scrollBy(0,-400)");

			// click on the drop down of the Phase II ESA report
			click("environmental_reportlist_phaseIItext_dropdown_XPATH");
			ngDriver.waitForAngularRequestsToFinish();
			System.out.println("Clicked on the drop down of the Phase II ESA report.");

			// click on the other options option
			click("environmental_reportlist_phaseIItext_dropdown_otheroption_XPATH");
			ngDriver.waitForAngularRequestsToFinish();
			System.out.println("Clicked on the other options option.");

			// select the level of the environmental report
			select("envreport_leveldd_CSS", data.get("level_1"));
			ngDriver.waitForAngularRequestsToFinish();
			System.out.println("Selected the level of the environmental report.");

			// verify assessment workflow checkbox is displayed selected or not

			try {
				boolean assessmentckbx = driver
						.findElement(By.xpath(OR.getProperty("envreport_assessmentworkflowckbx_XPATH"))).isSelected();

				if (assessmentckbx == true) {

					// click on the assessment workflow checkbox
					click("envreport_assessmentworkflowckbx_XPATH");
					ngDriver.waitForAngularRequestsToFinish();
					System.out.println("Clicked on the assessment workflow checkbox.");

					System.out.println("THE CHECKBOX OF THE ASSESSMENT WORKFLOW IS DISPLAYED UNSELECTED AS EXPECTED.");
					test.log(LogStatus.INFO,
							"THE CHECKBOX OF THE ASSESSMENT WORKFLOW IS DISPLAYED UNSELECTED AS EXPECTED.");
					Reporter.log("THE CHECKBOX OF THE ASSESSMENT WORKFLOW IS DISPLAYED UNSELECTED AS EXPECTED.");
					log.info("THE CHECKBOX OF THE ASSESSMENT WORKFLOW IS DISPLAYED UNSELECTED AS EXPECTED.");

				} else {

					System.out.println("THE CHECKBOX OF THE ASSESSMENT WORKFLOW IS DISPLAYED UNSELECTED AS EXPECTED.");
					test.log(LogStatus.INFO,
							"THE CHECKBOX OF THE ASSESSMENT WORKFLOW IS DISPLAYED UNSELECTED AS EXPECTED.");
					Reporter.log("THE CHECKBOX OF THE ASSESSMENT WORKFLOW IS DISPLAYED UNSELECTED AS EXPECTED.");
					log.info("THE CHECKBOX OF THE ASSESSMENT WORKFLOW IS DISPLAYED UNSELECTED AS EXPECTED.");
				}

			} catch (Throwable t) {

				System.out.println("THE CHECKBOX OF THE ASSESSMENT WORKFLOW IS DISPLAYED UNSELECTED AS EXPECTED.");
				test.log(LogStatus.INFO,
						"THE CHECKBOX OF THE ASSESSMENT WORKFLOW IS DISPLAYED UNSELECTED AS EXPECTED.");
				Reporter.log("THE CHECKBOX OF THE ASSESSMENT WORKFLOW IS DISPLAYED UNSELECTED AS EXPECTED.");
				log.info("THE CHECKBOX OF THE ASSESSMENT WORKFLOW IS DISPLAYED UNSELECTED AS EXPECTED.");
			}

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

			driver.navigate().refresh();

		}

		// click on the home icon from the top of the screen
		click("questionnaire_homeburgermenubtn_CSS");
		System.out.println("Clicked on the home icon from the top of the screen.");
		ngDriver.waitForAngularRequestsToFinish();

		// synchronization
		explicitWait("propertylist_title_XPATH");

		// verify the property list
		switchVerification("propertylist_title_XPATH", "Property List", "The property list is not displayed.");

		// PROPERTY SEARCH - WEIRD BEHAVIOR FOR SOME USERS - RR-4162

		System.out.println(
				"******************** PROPERTY SEARCH - WEIRD BEHAVIOR FOR SOME USERS - RR-4162 ********************");
		test.log(LogStatus.INFO,
				"******************** PROPERTY SEARCH - WEIRD BEHAVIOR FOR SOME USERS - RR-4162 ********************");
		Reporter.log(
				"******************** PROPERTY SEARCH - WEIRD BEHAVIOR FOR SOME USERS - RR-4162 ********************");
		log.info("******************** PROPERTY SEARCH - WEIRD BEHAVIOR FOR SOME USERS - RR-4162 ********************");

		// VERIFY THE PROPERTY 1

		System.out.println("******************** VERIFY THE PROPERTY 1 ********************");
		test.log(LogStatus.INFO, "******************** VERIFY THE PROPERTY 1 ********************");
		Reporter.log("******************** VERIFY THE PROPERTY 1 ********************");
		log.info("******************** VERIFY THE PROPERTY 1 ********************");

		try {

			// click on the search icon
			WebElement searchicon = driver.findElement(By.xpath(OR.getProperty("property_searchicon_XPATH")));
			Actions action = new Actions(driver);
			action.doubleClick(searchicon).build().perform();

			// enter the the property number in the search field
			type("property_searchicon_searchtxt_XPATH", data.get("property_number_1"));
			ngDriver.waitForAngularRequestsToFinish();
			System.out.println("Entered the the property number in the search field.");

			// remove the decimal characters from the search field
			driver.findElement(By.xpath(OR.getProperty("property_searchicon_searchtxt_XPATH")))
					.sendKeys(Keys.BACK_SPACE);
			driver.findElement(By.xpath(OR.getProperty("property_searchicon_searchtxt_XPATH")))
					.sendKeys(Keys.BACK_SPACE);
			ngDriver.waitForAngularRequestsToFinish();
			System.out.println("Removed the decimal characters from the search field.");

			// hit the enter key
			driver.findElement(By.xpath(OR.getProperty("property_searchicon_searchtxt_XPATH"))).sendKeys(Keys.ENTER);
			ngDriver.waitForAngularRequestsToFinish();
			System.out.println("Hited the enter key");

			// verify the title of the screen
			switchVerification("property_searchscreen_validation1_XPATH", "Advanced Property Search",
					"The Advanced Property Search is not displayed.");

			// verify the property name
			String propertyName1 = "//strong[text()='" + data.get("property_2") + "']";

			switchVerification(propertyName1, data.get("property_2"), "The property title is not displayed.");

			// verify the name field
			switchVerification("property_searchscreen_validation2_XPATH", "Name", "The Name field is not displayed.");

			// verify the Address field
			switchVerification("property_searchscreen_validation3_XPATH", "Address",
					"The Address field is not displayed.");

			// scroll down the screen
			JavascriptExecutor js = (JavascriptExecutor) driver;
			js.executeScript("window.scrollBy(0,500)");

			// verify the Manager field
			switchVerification("property_searchscreen_validation4_XPATH", "Manager",
					"The Manager field is not displayed.");

			// verify the Type field
			switchVerification("property_searchscreen_validation5_XPATH", "Type", "The Type field is not displayed.");

			// verify the Unit field
			switchVerification("property_searchscreen_validation6_XPATH", "Unit", "The Unit field is not displayed.");

			// verify the Property Search Results (1) text
			switchVerification("property_searchscreen_validation10_XPATH", "Property Search Results (1)",
					"The Property Search Results (1) text is not displayed.");

			// verify the find property button
			try {
				boolean validation7 = driver
						.findElement(By.xpath(OR.getProperty("property_searchscreen_validation7_XPATH"))).isDisplayed();
				if (validation7 == true) {
					System.out.println("THE FIND PROPERTY BUTTON IS DISPLAYED SUCCESSFULLY.");
					test.log(LogStatus.INFO, "THE FIND PROPERTY BUTTON IS DISPLAYED SUCCESSFULLY.");
					Reporter.log("THE FIND PROPERTY BUTTON IS DISPLAYED SUCCESSFULLY.");
					log.info("THE FIND PROPERTY BUTTON IS DISPLAYED SUCCESSFULLY.");
				} else {
					verificationFailed();

					System.out.println("THE FIND PROPERTY BUTTON IS NOT DISPLAYED.");
					test.log(LogStatus.INFO, "THE FIND PROPERTY BUTTON IS NOT DISPLAYED.");
					Reporter.log("THE FIND PROPERTY BUTTON IS NOT DISPLAYED.");
					log.info("THE FIND PROPERTY BUTTON IS NOT DISPLAYED.");
				}
			} catch (Throwable t) {
				verificationFailed();

				System.out.println("THE FIND PROPERTY BUTTON IS NOT DISPLAYED.");
				test.log(LogStatus.INFO, "THE FIND PROPERTY BUTTON IS NOT DISPLAYED.");
				Reporter.log("THE FIND PROPERTY BUTTON IS NOT DISPLAYED.");
				log.info("THE FIND PROPERTY BUTTON IS NOT DISPLAYED.");
			}

			// scroll up the screen
			js.executeScript("window.scrollBy(0,-500)");

			// verify the active radio button
			try {
				boolean validation8 = driver
						.findElement(By.xpath(OR.getProperty("property_searchscreen_validation8_XPATH"))).isDisplayed();
				if (validation8 == true) {
					System.out.println("THE ACTIVE RADIO BUTTON IS DISPLAYED SUCCESSFULLY.");
					test.log(LogStatus.INFO, "THE ACTIVE RADIO BUTTON IS DISPLAYED SUCCESSFULLY.");
					Reporter.log("THE ACTIVE RADIO BUTTON IS DISPLAYED SUCCESSFULLY.");
					log.info("THE ACTIVE RADIO BUTTON IS DISPLAYED SUCCESSFULLY.");
				} else {
					verificationFailed();

					System.out.println("THE ACTIVE RADIO BUTTON IS NOT DISPLAYED.");
					test.log(LogStatus.INFO, "THE ACTIVE RADIO BUTTON IS NOT DISPLAYED.");
					Reporter.log("THE ACTIVE RADIO BUTTON IS NOT DISPLAYED.");
					log.info("THE ACTIVE RADIO BUTTON IS NOT DISPLAYED.");
				}
			} catch (Throwable t) {
				verificationFailed();

				System.out.println("THE ACTIVE RADIO BUTTON IS NOT DISPLAYED.");
				test.log(LogStatus.INFO, "THE ACTIVE RADIO BUTTON IS NOT DISPLAYED.");
				Reporter.log("THE ACTIVE RADIO BUTTON IS NOT DISPLAYED.");
				log.info("THE ACTIVE RADIO BUTTON IS NOT DISPLAYED.");
			}

			// verify the inactive radio button
			try {
				boolean validation9 = driver
						.findElement(By.xpath(OR.getProperty("property_searchscreen_validation9_XPATH"))).isDisplayed();
				if (validation9 == true) {
					System.out.println("THE INACTIVE RADIO BUTTON IS DISPLAYED SUCCESSFULLY.");
					test.log(LogStatus.INFO, "THE INACTIVE RADIO BUTTON IS DISPLAYED SUCCESSFULLY.");
					Reporter.log("THE INACTIVE RADIO BUTTON IS DISPLAYED SUCCESSFULLY.");
					log.info("THE INACTIVE RADIO BUTTON IS DISPLAYED SUCCESSFULLY.");
				} else {
					verificationFailed();

					System.out.println("THE INACTIVE RADIO BUTTON IS NOT DISPLAYED.");
					test.log(LogStatus.INFO, "THE INACTIVE RADIO BUTTON IS NOT DISPLAYED.");
					Reporter.log("THE INACTIVE RADIO BUTTON IS NOT DISPLAYED.");
					log.info("THE INACTIVE RADIO BUTTON IS NOT DISPLAYED.");
				}
			} catch (Throwable t) {
				verificationFailed();

				System.out.println("THE INACTIVE RADIO BUTTON IS NOT DISPLAYED.");
				test.log(LogStatus.INFO, "THE INACTIVE RADIO BUTTON IS NOT DISPLAYED.");
				Reporter.log("THE INACTIVE RADIO BUTTON IS NOT DISPLAYED.");
				log.info("THE INACTIVE RADIO BUTTON IS NOT DISPLAYED.");
			}

			// VERIFY THE PROPERTY 2

			System.out.println("******************** VERIFY THE PROPERTY 2 ********************");
			test.log(LogStatus.INFO, "******************** VERIFY THE PROPERTY 2 ********************");
			Reporter.log("******************** VERIFY THE PROPERTY 2 ********************");
			log.info("******************** VERIFY THE PROPERTY 2 ********************");

			// enter the the property number in the search field
			type("property_searchicon_searchtxt_XPATH", data.get("property_number_2"));
			ngDriver.waitForAngularRequestsToFinish();
			System.out.println("Entered the the property number in the search field.");

			// hit the enter key
			driver.findElement(By.xpath(OR.getProperty("property_searchicon_searchtxt_XPATH"))).sendKeys(Keys.ENTER);
			ngDriver.waitForAngularRequestsToFinish();
			System.out.println("Hited the enter key");

			// verify the title of the screen
			switchVerification("property_searchscreen_validation1_XPATH", "Advanced Property Search",
					"The Advanced Property Search is not displayed.");

			// verify the property name
			String propertyName11 = "//strong[text()='" + data.get("property_1") + "']";

			switchVerification(propertyName11, data.get("property_2"), "The property title is not displayed.");

			// verify the name field
			switchVerification("property_searchscreen_validation2_XPATH", "Name", "The Name field is not displayed.");

			// verify the Address field
			switchVerification("property_searchscreen_validation3_XPATH", "Address",
					"The Address field is not displayed.");

			// scroll down the screen
			js.executeScript("window.scrollBy(0,500)");

			// verify the Manager field
			switchVerification("property_searchscreen_validation4_XPATH", "Manager",
					"The Manager field is not displayed.");

			// verify the Type field
			switchVerification("property_searchscreen_validation5_XPATH", "Type", "The Type field is not displayed.");

			// verify the Unit field
			switchVerification("property_searchscreen_validation6_XPATH", "Unit", "The Unit field is not displayed.");

			// verify the Property Search Results (1) text
			switchVerification("property_searchscreen_validation10_XPATH", "Property Search Results (1)",
					"The Property Search Results (1) text is not displayed.");

			// verify the find property button
			try {
				boolean validation7 = driver
						.findElement(By.xpath(OR.getProperty("property_searchscreen_validation7_XPATH"))).isDisplayed();
				if (validation7 == true) {
					System.out.println("THE FIND PROPERTY BUTTON IS DISPLAYED SUCCESSFULLY.");
					test.log(LogStatus.INFO, "THE FIND PROPERTY BUTTON IS DISPLAYED SUCCESSFULLY.");
					Reporter.log("THE FIND PROPERTY BUTTON IS DISPLAYED SUCCESSFULLY.");
					log.info("THE FIND PROPERTY BUTTON IS DISPLAYED SUCCESSFULLY.");
				} else {
					verificationFailed();

					System.out.println("THE FIND PROPERTY BUTTON IS NOT DISPLAYED.");
					test.log(LogStatus.INFO, "THE FIND PROPERTY BUTTON IS NOT DISPLAYED.");
					Reporter.log("THE FIND PROPERTY BUTTON IS NOT DISPLAYED.");
					log.info("THE FIND PROPERTY BUTTON IS NOT DISPLAYED.");
				}
			} catch (Throwable t) {
				verificationFailed();

				System.out.println("THE FIND PROPERTY BUTTON IS NOT DISPLAYED.");
				test.log(LogStatus.INFO, "THE FIND PROPERTY BUTTON IS NOT DISPLAYED.");
				Reporter.log("THE FIND PROPERTY BUTTON IS NOT DISPLAYED.");
				log.info("THE FIND PROPERTY BUTTON IS NOT DISPLAYED.");
			}

			// scroll up the screen
			js.executeScript("window.scrollBy(0,-500)");

			// verify the active radio button
			try {
				boolean validation8 = driver
						.findElement(By.xpath(OR.getProperty("property_searchscreen_validation8_XPATH"))).isDisplayed();
				if (validation8 == true) {
					System.out.println("THE ACTIVE RADIO BUTTON IS DISPLAYED SUCCESSFULLY.");
					test.log(LogStatus.INFO, "THE ACTIVE RADIO BUTTON IS DISPLAYED SUCCESSFULLY.");
					Reporter.log("THE ACTIVE RADIO BUTTON IS DISPLAYED SUCCESSFULLY.");
					log.info("THE ACTIVE RADIO BUTTON IS DISPLAYED SUCCESSFULLY.");
				} else {
					verificationFailed();

					System.out.println("THE ACTIVE RADIO BUTTON IS NOT DISPLAYED.");
					test.log(LogStatus.INFO, "THE ACTIVE RADIO BUTTON IS NOT DISPLAYED.");
					Reporter.log("THE ACTIVE RADIO BUTTON IS NOT DISPLAYED.");
					log.info("THE ACTIVE RADIO BUTTON IS NOT DISPLAYED.");
				}
			} catch (Throwable t) {
				verificationFailed();

				System.out.println("THE ACTIVE RADIO BUTTON IS NOT DISPLAYED.");
				test.log(LogStatus.INFO, "THE ACTIVE RADIO BUTTON IS NOT DISPLAYED.");
				Reporter.log("THE ACTIVE RADIO BUTTON IS NOT DISPLAYED.");
				log.info("THE ACTIVE RADIO BUTTON IS NOT DISPLAYED.");
			}

			// verify the inactive radio button
			try {
				boolean validation9 = driver
						.findElement(By.xpath(OR.getProperty("property_searchscreen_validation9_XPATH"))).isDisplayed();
				if (validation9 == true) {
					System.out.println("THE INACTIVE RADIO BUTTON IS DISPLAYED SUCCESSFULLY.");
					test.log(LogStatus.INFO, "THE INACTIVE RADIO BUTTON IS DISPLAYED SUCCESSFULLY.");
					Reporter.log("THE INACTIVE RADIO BUTTON IS DISPLAYED SUCCESSFULLY.");
					log.info("THE INACTIVE RADIO BUTTON IS DISPLAYED SUCCESSFULLY.");
				} else {
					verificationFailed();

					System.out.println("THE INACTIVE RADIO BUTTON IS NOT DISPLAYED.");
					test.log(LogStatus.INFO, "THE INACTIVE RADIO BUTTON IS NOT DISPLAYED.");
					Reporter.log("THE INACTIVE RADIO BUTTON IS NOT DISPLAYED.");
					log.info("THE INACTIVE RADIO BUTTON IS NOT DISPLAYED.");
				}
			} catch (Throwable t) {
				verificationFailed();

				System.out.println("THE INACTIVE RADIO BUTTON IS NOT DISPLAYED.");
				test.log(LogStatus.INFO, "THE INACTIVE RADIO BUTTON IS NOT DISPLAYED.");
				Reporter.log("THE INACTIVE RADIO BUTTON IS NOT DISPLAYED.");
				log.info("THE INACTIVE RADIO BUTTON IS NOT DISPLAYED.");
			}

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
