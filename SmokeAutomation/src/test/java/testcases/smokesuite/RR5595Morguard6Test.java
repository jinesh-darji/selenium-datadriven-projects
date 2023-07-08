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

		execution(data, "rR5595Morguard6Test");

		// refresh the page
		driver.navigate().refresh();
		Thread.sleep(5000);
		driver.navigate().refresh();

		// ENVIRONMENTAL ASSESSMENT DASHBOARD - VERIFICATION OF THE PROPERTIES NOT
		// ASSESSED COUNT - RR-4143
		title("ENVIRONMENTAL ASSESSMENT DASHBOARD - VERIFICATION OF THE PROPERTIES NOT ASSESSED COUNT - RR-4143");

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

		// DELETE PREVIOUSLY CREATED ENVIRONMENTAL REPORT FROM PROPERTY 2
		title("DELETE PREVIOUSLY CREATED ENVIRONMENTAL REPORT FROM PROPERTY 2");

		try {

			// enter the property name in the search field

			type("envreports_propertylist_filtertxt_CSS", data.get("property_2"));

			// click on the environmental icon from the property list page
			click("environmentalicon_CSS");

			// wait for the element
			Thread.sleep(5000);

			// click on the burger menu
			click("menubtn_CSS");

			// wait for the element
			Thread.sleep(5000);

			// click on the Environmental Reports option
			click("envreportoption_XPATH");

			// collect all the report

			List<WebElement> reportList = driver.findElements(By.xpath(OR.getProperty("envreport_totalreports_XPATH")));
			int reportCount = reportList.size();

			consoleMessage("reportCount:::::::::::::::::::" + reportCount);

			for (int i = 1; i <= reportCount; i++) {

				List<WebElement> reportList1 = driver
						.findElements(By.xpath(OR.getProperty("envreport_totalreports_XPATH")));
				int maxProducts = reportList1.size();
				Random random = new Random();
				int randomProduct = random.nextInt(maxProducts);
				reportList1.get(randomProduct).click();

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
			verificationFailed();
		}

		// click on the home icon from the top of the screen
		click("questionnaire_homeburgermenubtn_hide_CSS");

		// synchronization
		explicitWait("propertylist_title_XPATH");

		// verify the property list
		switchVerification("propertylist_title_XPATH", "Property List", "The property list is not displayed.");

		// DELETE PREVIOUSLY CREATED ENVIRONMENTAL REPORT FROM PROPERTY 4
		title("DELETE PREVIOUSLY CREATED ENVIRONMENTAL REPORT FROM PROPERTY 4");

		try {

			// enter the property name in the search field

			type("envreports_propertylist_filtertxt_CSS", data.get("property_2"));

			// click on the environmental icon from the property list page
			click("environmentalicon_CSS");

			// wait for the element
			Thread.sleep(5000);

			// click on the burger menu
			click("menubtn_CSS");

			// wait for the element
			Thread.sleep(5000);

			// click on the Environmental Reports option
			click("envreportoption_XPATH");

			// collect all the report

			List<WebElement> reportList = driver.findElements(By.xpath(OR.getProperty("envreport_totalreports_XPATH")));
			int reportCount1 = reportList.size();

			consoleMessage("reportCount1:::::::::::::::::::" + reportCount1);

			for (int i = 1; i <= reportCount1; i++) {

				List<WebElement> reportList1 = driver
						.findElements(By.xpath(OR.getProperty("envreport_totalreports_XPATH")));
				int maxProducts = reportList1.size();
				Random random = new Random();
				int randomProduct = random.nextInt(maxProducts);
				reportList1.get(randomProduct).click();

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
			verificationFailed();
		}

		// click on the home icon from the top of the screen
		click("questionnaire_homeburgermenubtn_hide_CSS");

		// synchronization
		explicitWait("propertylist_title_XPATH");

		// verify the property list
		switchVerification("propertylist_title_XPATH", "Property List", "The property list is not displayed.");

		// VERIFY THE PHASE-II REPORT CONFIGURATION - UNCHECK THE ASSESSMENT WORKFLOW
		// CHECKBOX
		title("VERIFY THE PHASE-II REPORT CONFIGURATION - UNCHECK THE ASSESSMENT WORKFLOW CHECKBOX");

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
			scrollTillElement("environmental_reportlist_phaseIItext_dropdown_XPATH");
			scrollByPixel(-400);

			// click on the drop down of the Phase II ESA report
			click("environmental_reportlist_phaseIItext_dropdown_XPATH");

			// click on the other options option
			click("environmental_reportlist_phaseIItext_dropdown_otheroption_XPATH");

			// select the level of the environmental report
			select("envreport_leveldd_CSS", data.get("level"));

			// verify assessment workflow checkbox is displayed selected or not

			try {
				boolean assessmentckbx = driver
						.findElement(By.xpath(OR.getProperty("envreport_assessmentworkflowckbx_XPATH"))).isSelected();

				if (assessmentckbx == true) {

					// click on the assessment workflow checkbox
					click("envreport_assessmentworkflowckbx_XPATH");

					successMessage("THE CHECKBOX OF THE ASSESSMENT WORKFLOW IS DISPLAYED UNSELECTED AS EXPECTED.");

				} else {
					successMessage("THE CHECKBOX OF THE ASSESSMENT WORKFLOW IS DISPLAYED UNSELECTED AS EXPECTED.");
				}

			} catch (Throwable t) {
				successMessage("THE CHECKBOX OF THE ASSESSMENT WORKFLOW IS DISPLAYED UNSELECTED AS EXPECTED.");
			}

			// enter the data in the report frequency field

			type("environmental_reportlist_environmentalactionreporttext_reportfrequencytxt_CSS", "4");

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

		// VERIFY ENVIRONMENTAL CARD ON THE ASSESSMENTS/INSPECTIONS DASHBOARD OF THE
		// ENVIRONMENTAL MODULE AFTER UNCHECKED THE ASSESSMENT WORKFLOW CHECKBOX
		title("VERIFY ENVIRONMENTAL CARD ON THE ASSESSMENTS/INSPECTIONS DASHBOARD OF THE ENVIRONMENTAL MODULE AFTER UNCHECKED THE ASSESSMENT WORKFLOW CHECKBOX");

		int value = 0;

		try {

			// wait for the element
			Thread.sleep(5000);

			// click on the side menu
			click("menubtn_CSS");

			// wait for the element
			Thread.sleep(5000);

			// click on the environmental option
			click("sidemenu_environmental_XPATH");

			// select the Assessments/Inspections option from the dashbaord drop down
			select("dashboard_CSS", data.get("dashboard_2"));

			// wait for the 3 seconds
			Thread.sleep(3000);

			// scroll down the screen
			scrollTillElement("portfoliodashboard_phaseIIreportcard_XPATH");

			switchVerification("portfoliodashboard_phaseIIreportcard_XPATH", "Phase II ESA",
					"The Phase II ESA is not displayed.");

			successMessage("THE Phase II ESA CARD IS DISPLAYED SUCCESSFULLY.");

			try {
				String notAvailableCount = driver
						.findElement(By.cssSelector(OR.getProperty("environmental_notavailablecount_phaseII_CSS")))
						.getText();

				String finalNotAvailableCount = notAvailableCount.trim();

				value = Integer.parseInt(finalNotAvailableCount);

				consoleMessage("///////////////////////// value : " + value);

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

		// CREATE ENVIRONMENTAL REPORT WITH THE PHASE II ESA
		title("CREATE ENVIRONMENTAL REPORT WITH THE PHASE II ESA");

		try {

			// enter the property name in the search field
			type("envreports_propertylist_filtertxt_CSS", data.get("property_2"));

			// click on the environmental icon
			click("environmentalicon_CSS");

			// wait for the element
			Thread.sleep(5000);

			// click on the side menu
			click("ssc_leftsidemenubtn_CSS");

			// wait for the element
			Thread.sleep(5000);

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
			switchVerification("environmental_searchedreport6_XPATH", "Test Environmental Report Count 6",
					"The Test Environmental Report Count 6 is not displayed.");

		} catch (Throwable t) {
			verificationFailed();
		}

		// click on the home icon from the top of the screen
		click("questionnaire_homeburgermenubtn_hide_CSS");

		// synchronization
		explicitWait("propertylist_title_XPATH");

		// verify the property list
		switchVerification("propertylist_title_XPATH", "Property List", "The property list is not displayed.");

		// VERIFY ENVIRONMENTAL CARD ON THE ASSESSMENTS/INSPECTIONS DASHBOARD OF THE
		// ENVIRONMENTAL MODULE AFTER UNCHECKED THE ASSESSMENT WORKFLOW CHECKBOX
		title("VERIFY ENVIRONMENTAL CARD ON THE ASSESSMENTS/INSPECTIONS DASHBOARD OF THE ENVIRONMENTAL MODULE AFTER UNCHECKED THE ASSESSMENT WORKFLOW CHECKBOX");

		try {

			// wait for the element
			Thread.sleep(5000);

			// click on the side menu
			click("menubtn_CSS");

			// wait for the element
			Thread.sleep(5000);

			// click on the environmental option
			click("sidemenu_environmental_XPATH");

			// select the Assessments/Inspections option from the dashbaord drop down
			select("dashboard_CSS", data.get("dashboard_2"));

			// wait for the 3 seconds
			Thread.sleep(3000);

			// scroll down the screen
			scrollTillElement("portfoliodashboard_phaseIIreportcard_XPATH");

			switchVerification("portfoliodashboard_phaseIIreportcard_XPATH", "Phase II ESA",
					"The Phase II ESA is not displayed.");

			successMessage("THE Phase II ESA CARD IS DISPLAYED SUCCESSFULLY.");

			try {

				// scroll down the screen
				scrollTillElement("portfoliodashboard_phaseIIreportcard_XPATH");

				switchVerification("portfoliodashboard_phaseIIreportcard_XPATH", "Phase II ESA",
						"The Phase II ESA is not displayed.");

				successMessage("THE Phase II ESA CARD IS DISPLAYED SUCCESSFULLY.");

				String notAvailableCount = driver
						.findElement(By.cssSelector(OR.getProperty("environmental_notavailablecount_phaseII_CSS")))
						.getText();

				String finalNotAvailableCount = notAvailableCount.trim();

				int value2 = Integer.parseInt(finalNotAvailableCount);

				if (value == (value2 + 1)) {
					successMessage("THE COUNT OF THE PHASE II IS DISPLAYED CORRECT.");
				} else {

					verificationFailedMessage("THE COUNT OF THE PHASE II IS NOT DISPLAYED CORRECT.");
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

		// DELETE THE ENVIRONMENTAL REPORT - SUPER ADMIN USER
		title("DELETE THE ENVIRONMENTAL REPORT - SUPER ADMIN USER");

		try {

			// enter the property name in the search field
			type("envreports_propertylist_filtertxt_CSS", data.get("property_2"));

			// click on the environmental icon
			click("environmentalicon_CSS");

			// wait for the element
			Thread.sleep(5000);

			// click on the side menu
			click("ssc_leftsidemenubtn_CSS");

			// wait for the element
			Thread.sleep(5000);

			// click on the environmental report
			click("envreportoption_XPATH");

			// enter environmental report in the search field

			type("task_listofchecklist_filterfield_CSS", data.get("title"));

			// click on the environmental report
			click("environmental_searchedreport6_XPATH");

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

			// verification of the environmental report is deleted or not

			// enter the newly created environmental report in the search field

			type("task_listofchecklist_filterfield_CSS", data.get("title"));

			deleteVerification("environmental_searchedreport6_XPATH", "Test Environmental Report Count 6");

		} catch (Throwable t) {
			verificationFailed();
		}

		// click on the home icon from the top of the screen
		click("questionnaire_homeburgermenubtn_hide_CSS");

		// wait for the element
		explicitWait("propertylist_title_XPATH");

		// verify the property list
		switchVerification("propertylist_title_XPATH", "Property List", "The property list is not displayed.");

		// VERIFY THE PHASE-II REPORT CONFIGURATION - CHECK THE ASSESSMENT WORKFLOW
		// CHECKBOX
		title("VERIFY THE PHASE-II REPORT CONFIGURATION - CHECK THE ASSESSMENT WORKFLOW CHECKBOX");

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
			scrollTillElement("environmental_reportlist_phaseIItext_dropdown_XPATH");
			scrollByPixel(-400);

			// click on the drop down of the Phase II ESA report
			click("environmental_reportlist_phaseIItext_dropdown_XPATH");

			// click on the other options option
			click("environmental_reportlist_phaseIItext_dropdown_otheroption_XPATH");

			// select the level of the environmental report
			select("envreport_leveldd_CSS", data.get("level"));

			// verify assessment workflow checkbox is displayed selected or not

			try {
				boolean assessmentckbx = driver
						.findElement(By.xpath(OR.getProperty("envreport_assessmentworkflowckbx_XPATH"))).isSelected();

				if (assessmentckbx == true) {
					successMessage("THE CHECKBOX OF THE ASSESSMENT WORKFLOW IS DISPLAYED SELECTED AS EXPECTED.");
				} else {

					// click on the assessment workflow checkbox
					click("envreport_assessmentworkflowckbx_XPATH");

					successMessage("THE CHECKBOX OF THE ASSESSMENT WORKFLOW IS DISPLAYED SELECTED AS EXPECTED.");
				}

			} catch (Throwable t) {

				// click on the assessment workflow checkbox
				click("envreport_assessmentworkflowckbx_XPATH");

				successMessage("THE CHECKBOX OF THE ASSESSMENT WORKFLOW IS DISPLAYED SELECTED AS EXPECTED.");
			}

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
			// wait for the 7 seconds
			Thread.sleep(7000);

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

		// VERIFY ENVIRONMENTAL CARD ON THE ASSESSMENTS/INSPECTIONS DASHBOARD OF THE
		// ENVIRONMENTAL MODULE AFTER UNCHECKED THE ASSESSMENT WORKFLOW CHECKBOX
		title("VERIFY ENVIRONMENTAL CARD ON THE ASSESSMENTS/INSPECTIONS DASHBOARD OF THE ENVIRONMENTAL MODULE AFTER UNCHECKED THE ASSESSMENT WORKFLOW CHECKBOX");

		int value1 = 0;

		try {

			// wait for the element
			Thread.sleep(5000);

			// click on the side menu
			click("menubtn_CSS");

			// wait for the element
			Thread.sleep(5000);

			// click on the environmental option
			click("sidemenu_environmental_XPATH");

			// select the Assessments/Inspections option from the dashbaord drop down
			select("dashboard_CSS", data.get("dashboard_2"));

			// wait for the 3 seconds
			Thread.sleep(3000);

			// scroll down the screen
			scrollTillElement("portfoliodashboard_phaseIIreportcard_XPATH");

			switchVerification("portfoliodashboard_phaseIIreportcard_XPATH", "Phase II ESA",
					"The Phase II ESA is not displayed.");

			successMessage("THE Phase II ESA CARD IS DISPLAYED SUCCESSFULLY.");

			try {
				String notAvailableCount = driver
						.findElement(By.cssSelector(OR.getProperty("environmental_notavailablecount_phaseII_CSS")))
						.getText();

				String finalNotAvailableCount = notAvailableCount.trim();

				value1 = Integer.parseInt(finalNotAvailableCount);

				consoleMessage("///////////////////////// value1 : " + value1);

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

		// CREATE ENVIRONMENTAL REPORT WITH THE PHASE II ESA - SELECT YES OPTION IN
		// ASSESSMENT
		title("CREATE ENVIRONMENTAL REPORT WITH THE PHASE II ESA - SELECT YES OPTION IN ASSESSMENT");

		try {

			// enter the property name in the search field
			type("envreports_propertylist_filtertxt_CSS", data.get("property_2"));

			// click on the environmental icon
			click("environmentalicon_CSS");

			// wait for the element
			Thread.sleep(5000);

			// click on the side menu
			click("ssc_leftsidemenubtn_CSS");

			// wait for the element
			Thread.sleep(5000);

			// click on the environmental report
			click("envreportoption_XPATH");

			// click on the add button
			click("envreportaddbtn_CSS");

			// select the checklist from the type dropdown
			select("envreporttypedd_CSS", data.get("type"));

			// enter the title
			type("envreporttitletxt_CSS", data.get("title_yesbtn"));

			// scroll down the screen

			scrollByPixel(400);

			// click on the date field
			click("envreportdatetxt_CSS");

			// click on the today button
			click("envreporttodaydate_BTNTEXT");

			// click on the save report button
			click("envreportsavebtn_CSS");

			// click on the yes button
			click("envreport_assessment_yesbtn_CSS");

			// verify the redirection of the screen
			switchVerification("envreport_assessment_title_XPATH", "Environmental Reports Record",
					"The Environmental Reports Record title is not displayed.");

			// click on the update button
			click("envreportupdatebtn_CSS");

			// wait for the element
			Thread.sleep(5000);

			// enter the newly created environmental report in the search field

			type("task_listofchecklist_filterfield_CSS", data.get("title_yesbtn"));

			// verify the newly created environmental report is displayed or not
			switchVerification("environmental_searchedreport6_yesbtn_XPATH",
					"Test Environmental Report Count 6 Yes Button",
					"The Test Environmental Report Count 6 Yes Button is not displayed.");

		} catch (Throwable t) {
			verificationFailed();
		}

		// click on the home icon from the top of the screen
		click("questionnaire_homeburgermenubtn_hide_CSS");

		// synchronization
		explicitWait("propertylist_title_XPATH");

		// verify the property list
		switchVerification("propertylist_title_XPATH", "Property List", "The property list is not displayed.");

		// VERIFY ENVIRONMENTAL CARD ON THE ASSESSMENTS/INSPECTIONS DASHBOARD OF THE
		// ENVIRONMENTAL MODULE AFTER UNCHECKED THE ASSESSMENT WORKFLOW CHECKBOX
		title("VERIFY ENVIRONMENTAL CARD ON THE ASSESSMENTS/INSPECTIONS DASHBOARD OF THE ENVIRONMENTAL MODULE AFTER UNCHECKED THE ASSESSMENT WORKFLOW CHECKBOX");

		try {

			// wait for the element
			Thread.sleep(5000);

			// click on the side menu
			click("menubtn_CSS");

			// wait for the element
			Thread.sleep(5000);

			// click on the environmental option
			click("sidemenu_environmental_XPATH");

			// select the Assessments/Inspections option from the dashbaord drop down
			select("dashboard_CSS", data.get("dashboard_2"));

			// wait for the 3 seconds
			Thread.sleep(3000);

			// scroll down the screen
			scrollTillElement("portfoliodashboard_phaseIIreportcard_XPATH");

			switchVerification("portfoliodashboard_phaseIIreportcard_XPATH", "Phase II ESA",
					"The Phase II ESA is not displayed.");

			successMessage("THE Phase II ESA CARD IS DISPLAYED SUCCESSFULLY.");

			try {

				// scroll down the screen
				scrollTillElement("portfoliodashboard_phaseIIreportcard_XPATH");

				switchVerification("portfoliodashboard_phaseIIreportcard_XPATH", "Phase II ESA",
						"The Phase II ESA is not displayed.");

				successMessage("THE Phase II ESA CARD IS DISPLAYED SUCCESSFULLY.");

				String notAvailableCount = driver
						.findElement(By.cssSelector(OR.getProperty("environmental_notavailablecount_phaseII_CSS")))
						.getText();

				String finalNotAvailableCount = notAvailableCount.trim();

				int value11 = Integer.parseInt(finalNotAvailableCount);

				if (value1 == (value11 + 1)) {
					successMessage("THE COUNT OF THE PHASE II IS DISPLAYED CORRECT.");
				} else {
					verificationFailedMessage("THE COUNT OF THE PHASE II IS NOT DISPLAYED CORRECT.");
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

		// CREATE ENVIRONMENTAL REPORT WITH THE PHASE II ESA - SELECT NO OPTION IN
		// ASSESSMENT
		title("CREATE ENVIRONMENTAL REPORT WITH THE PHASE II ESA - SELECT NO OPTION IN ASSESSMENT");

		try {

			// enter the property name in the search field
			type("envreports_propertylist_filtertxt_CSS", data.get("property_4"));

			// click on the environmental icon
			click("environmentalicon_CSS");

			// wait for the element
			Thread.sleep(5000);

			// click on the side menu
			click("ssc_leftsidemenubtn_CSS");

			// wait for the element
			Thread.sleep(5000);

			// click on the environmental report
			click("envreportoption_XPATH");

			// click on the add button
			click("envreportaddbtn_CSS");

			// select the checklist from the type dropdown
			select("envreporttypedd_CSS", data.get("type"));

			// enter the title
			type("envreporttitletxt_CSS", data.get("title_nobtn"));

			// scroll down the screen

			scrollByPixel(400);

			// click on the date field
			click("envreportdatetxt_CSS");

			// click on the today button
			click("envreporttodaydate_BTNTEXT");

			// click on the save report button
			click("envreportsavebtn_CSS");

			// click on the no button
			click("envreport_assessment_nobtn_CSS");

			// verify the redirection of the screen
			switchVerification("envreport_title_XPATH", "Environmental Reports",
					"The Environmental Reports title is not displayed.");

			// wait for the element
			Thread.sleep(5000);

			// enter the newly created environmental report in the search field

			type("task_listofchecklist_filterfield_CSS", data.get("title_nobtn"));

			// verify the newly created environmental report is displayed or not
			switchVerification("environmental_searchedreport6_nobtn_XPATH",
					"Test Environmental Report Count 6 No Button",
					"The Test Environmental Report Count 6 No Button is not displayed.");

		} catch (Throwable t) {
			verificationFailed();
		}

		// click on the home icon from the top of the screen
		click("questionnaire_homeburgermenubtn_hide_CSS");

		// synchronization
		explicitWait("propertylist_title_XPATH");

		// verify the property list
		switchVerification("propertylist_title_XPATH", "Property List", "The property list is not displayed.");

		// VERIFY ENVIRONMENTAL CARD ON THE ASSESSMENTS/INSPECTIONS DASHBOARD OF THE
		// ENVIRONMENTAL MODULE AFTER CHECKED THE ASSESSMENT WORKFLOW CHECKBOX
		title("VERIFY ENVIRONMENTAL CARD ON THE ASSESSMENTS/INSPECTIONS DASHBOARD OF THE ENVIRONMENTAL MODULE AFTER CHECKED THE ASSESSMENT WORKFLOW CHECKBOX");

		try {

			// wait for the element
			Thread.sleep(5000);

			// click on the side menu
			click("menubtn_CSS");

			// wait for the element
			Thread.sleep(5000);

			// click on the environmental option
			click("sidemenu_environmental_XPATH");

			// select the Assessments/Inspections option from the dashbaord drop down
			select("dashboard_CSS", data.get("dashboard_2"));

			// wait for the 3 seconds
			Thread.sleep(3000);

			// scroll down the screen
			scrollTillElement("portfoliodashboard_phaseIIreportcard_XPATH");

			switchVerification("portfoliodashboard_phaseIIreportcard_XPATH", "Phase II ESA",
					"The Phase II ESA is not displayed.");

			successMessage("THE Phase II ESA CARD IS DISPLAYED SUCCESSFULLY.");

			try {

				// scroll down the screen
				scrollTillElement("portfoliodashboard_phaseIIreportcard_XPATH");

				switchVerification("portfoliodashboard_phaseIIreportcard_XPATH", "Phase II ESA",
						"The Phase II ESA is not displayed.");

				successMessage("THE Phase II ESA CARD IS DISPLAYED SUCCESSFULLY.");

				String notAvailableCount = driver
						.findElement(By.cssSelector(OR.getProperty("environmental_notavailablecount_phaseII_CSS")))
						.getText();

				String finalNotAvailableCount = notAvailableCount.trim();

				int value22 = Integer.parseInt(finalNotAvailableCount);

				if (value1 == (value22 + 2)) {
					successMessage("THE COUNT OF THE PHASE II IS DISPLAYED CORRECT.");
				} else {
					verificationFailedMessage("THE COUNT OF THE PHASE II IS NOT DISPLAYED CORRECT.");
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

		// DELETE THE ENVIRONMENTAL REPORT - PROPERTY 2
		title("DELETE THE ENVIRONMENTAL REPORT - PROPERTY 2");

		try {

			// enter the property name in the search field
			type("envreports_propertylist_filtertxt_CSS", data.get("property_2"));

			// click on the environmental icon
			click("environmentalicon_CSS");

			// wait for the element
			Thread.sleep(5000);

			// click on the side menu
			click("ssc_leftsidemenubtn_CSS");

			// wait for the element
			Thread.sleep(5000);

			// click on the environmental report
			click("envreportoption_XPATH");

			// enter environmental report in the search field

			type("task_listofchecklist_filterfield_CSS", data.get("title_yesbtn"));

			// click on the environmental report
			click("environmental_searchedreport6_yesbtn_XPATH");

			// wait for the element
			explicitWaitClickable("envreportdeletebtn_CSS");

			// click on the delete button
			click("envreportdeletebtn_CSS");

			// wait for the element
			explicitWaitClickable("envreportmodeldeletebtn_CSS");

			// click on the delete button of the confirmation model
			click("envreportmodeldeletebtn_CSS");

			// enter the newly created environmental report in the search field

			type("task_listofchecklist_filterfield_CSS", data.get("title_yesbtn"));

			// verification of the environmental report is deleted or not
			deleteVerification("environmental_searchedreport6_yesbtn_XPATH",
					"Test Environmental Report Count 6 Yes Button");

		} catch (Throwable t) {
			verificationFailed();
		}

		// click on the home icon from the top of the screen
		click("questionnaire_homeburgermenubtn_hide_CSS");

		// wait for the element
		explicitWait("propertylist_title_XPATH");

		// verify the property list
		switchVerification("propertylist_title_XPATH", "Property List", "The property list is not displayed.");

		// DELETE THE ENVIRONMENTAL REPORT - PROPERTY 4
		title("DELETE THE ENVIRONMENTAL REPORT - PROPERTY 4");

		try {

			// enter the property name in the search field
			type("envreports_propertylist_filtertxt_CSS", data.get("property_4"));

			// click on the environmental icon
			click("environmentalicon_CSS");

			// wait for the element
			Thread.sleep(5000);

			// click on the side menu
			click("ssc_leftsidemenubtn_CSS");

			// wait for the element
			Thread.sleep(5000);

			// click on the environmental report
			click("envreportoption_XPATH");

			// enter environmental report in the search field

			type("task_listofchecklist_filterfield_CSS", data.get("title_nobtn"));

			// click on the environmental report
			click("environmental_searchedreport6_nobtn_XPATH");

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

			type("task_listofchecklist_filterfield_CSS", data.get("title_nobtn"));

			// verification of the environmental report is deleted or not
			deleteVerification("environmental_searchedreport6_nobtn_XPATH",
					"Test Environmental Report Count 6 No Button");

		} catch (Throwable t) {
			verificationFailed();
		}

		// click on the home icon from the top of the screen
		click("questionnaire_homeburgermenubtn_hide_CSS");

		// wait for the element
		explicitWait("propertylist_title_XPATH");

		// verify the property list
		switchVerification("propertylist_title_XPATH", "Property List", "The property list is not displayed.");

		// VERIFY ENVIRONMENTAL CARD ON THE ASSESSMENTS/INSPECTIONS DASHBOARD OF THE
		// ENVIRONMENTAL MODULE AFTER DELETE THE ENVIRONMENTAL REPORT
		title("VERIFY ENVIRONMENTAL CARD ON THE ASSESSMENTS/INSPECTIONS DASHBOARD OF THE ENVIRONMENTAL MODULE AFTER DELETE THE ENVIRONMENTAL REPORT");

		try {

			// wait for the element
			Thread.sleep(5000);

			// click on the side menu
			click("menubtn_CSS");

			// wait for the element
			Thread.sleep(5000);

			// click on the environmental option
			click("sidemenu_environmental_XPATH");

			// select the Assessments/Inspections option from the dashbaord drop down
			select("dashboard_CSS", data.get("dashboard_2"));

			// wait for the 3 seconds
			Thread.sleep(3000);

			// scroll down the screen
			scrollTillElement("portfoliodashboard_phaseIIreportcard_XPATH");

			switchVerification("portfoliodashboard_phaseIIreportcard_XPATH", "Phase II ESA",
					"The Phase II ESA is not displayed.");

			successMessage("THE Phase II ESA CARD IS DISPLAYED SUCCESSFULLY.");

			try {

				// scroll down the screen
				scrollTillElement("portfoliodashboard_phaseIIreportcard_XPATH");

				switchVerification("portfoliodashboard_phaseIIreportcard_XPATH", "Phase II ESA",
						"The Phase II ESA is not displayed.");

				successMessage("THE Phase II ESA CARD IS DISPLAYED SUCCESSFULLY.");

				String notAvailableCount = driver
						.findElement(By.cssSelector(OR.getProperty("environmental_notavailablecount_phaseII_CSS")))
						.getText();

				String finalNotAvailableCount = notAvailableCount.trim();

				int value33 = Integer.parseInt(finalNotAvailableCount);

				if (value1 == value33) {
					successMessage("THE COUNT OF THE PHASE II IS DISPLAYED CORRECT.");
				} else {
					verificationFailedMessage("THE COUNT OF THE PHASE II IS NOT DISPLAYED CORRECT.");
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

		// RESET THE PHASE-II REPORT CONFIGURATION
		title("RESET THE PHASE-II REPORT CONFIGURATION");

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
			scrollTillElement("environmental_reportlist_phaseIItext_dropdown_XPATH");
			scrollByPixel(-400);

			// click on the drop down of the Phase II ESA report
			click("environmental_reportlist_phaseIItext_dropdown_XPATH");

			// click on the other options option
			click("environmental_reportlist_phaseIItext_dropdown_otheroption_XPATH");

			// select the level of the environmental report
			select("envreport_leveldd_CSS", data.get("level_1"));

			// verify assessment workflow checkbox is displayed selected or not

			try {
				boolean assessmentckbx = driver
						.findElement(By.xpath(OR.getProperty("envreport_assessmentworkflowckbx_XPATH"))).isSelected();

				if (assessmentckbx == true) {

					// click on the assessment workflow checkbox
					click("envreport_assessmentworkflowckbx_XPATH");

					successMessage("THE CHECKBOX OF THE ASSESSMENT WORKFLOW IS DISPLAYED UNSELECTED AS EXPECTED.");

				} else {
					successMessage("THE CHECKBOX OF THE ASSESSMENT WORKFLOW IS DISPLAYED UNSELECTED AS EXPECTED.");
				}

			} catch (Throwable t) {
				successMessage("THE CHECKBOX OF THE ASSESSMENT WORKFLOW IS DISPLAYED UNSELECTED AS EXPECTED.");
			}

			// enter the data in the report frequency field

			type("environmental_reportlist_environmentalactionreporttext_reportfrequencytxt_CSS", "1");

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

			// wait for the element
			explicitWaitClickable("questionnaire_administrationoption_XPATH");

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

			driver.navigate().refresh();

		}

		// click on the home icon from the top of the screen
		click("questionnaire_homeburgermenubtn_CSS");

		// synchronization
		explicitWait("propertylist_title_XPATH");

		// verify the property list
		switchVerification("propertylist_title_XPATH", "Property List", "The property list is not displayed.");

		// PROPERTY SEARCH - WEIRD BEHAVIOR FOR SOME USERS - RR-4162
		title("PROPERTY SEARCH - WEIRD BEHAVIOR FOR SOME USERS - RR-4162");

		// VERIFY THE PROPERTY 1
		title("VERIFY THE PROPERTY 1");

		try {

			// click on the search icon
			WebElement searchicon = driver.findElement(By.xpath(OR.getProperty("property_searchicon_XPATH")));
			Actions action = new Actions(driver);
			action.doubleClick(searchicon).build().perform();

			// enter the the property number in the search field
			type("property_searchicon_searchtxt_XPATH", data.get("property_number_1"));

			// remove the decimal characters from the search field
			driver.findElement(By.xpath(OR.getProperty("property_searchicon_searchtxt_XPATH")))
					.sendKeys(Keys.BACK_SPACE);
			driver.findElement(By.xpath(OR.getProperty("property_searchicon_searchtxt_XPATH")))
					.sendKeys(Keys.BACK_SPACE);

			// hit the enter key
			driver.findElement(By.xpath(OR.getProperty("property_searchicon_searchtxt_XPATH"))).sendKeys(Keys.ENTER);

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

			scrollByPixel(500);

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
					successMessage("THE FIND PROPERTY BUTTON IS DISPLAYED SUCCESSFULLY.");
				} else {
					verificationFailedMessage("THE FIND PROPERTY BUTTON IS NOT DISPLAYED.");
				}
			} catch (Throwable t) {
				verificationFailedMessage("THE FIND PROPERTY BUTTON IS NOT DISPLAYED.");
			}

			// scroll up the screen
			scrollByPixel(-500);

			// verify the active radio button
			try {
				boolean validation8 = driver
						.findElement(By.xpath(OR.getProperty("property_searchscreen_validation8_XPATH"))).isDisplayed();
				if (validation8 == true) {
					successMessage("THE ACTIVE RADIO BUTTON IS DISPLAYED SUCCESSFULLY.");
				} else {
					verificationFailedMessage("THE ACTIVE RADIO BUTTON IS NOT DISPLAYED.");
				}
			} catch (Throwable t) {
				verificationFailedMessage("THE ACTIVE RADIO BUTTON IS NOT DISPLAYED.");
			}

			// verify the inactive radio button
			try {
				boolean validation9 = driver
						.findElement(By.xpath(OR.getProperty("property_searchscreen_validation9_XPATH"))).isDisplayed();
				if (validation9 == true) {
					successMessage("THE INACTIVE RADIO BUTTON IS DISPLAYED SUCCESSFULLY.");
				} else {
					verificationFailedMessage("THE INACTIVE RADIO BUTTON IS NOT DISPLAYED.");
				}
			} catch (Throwable t) {
				verificationFailedMessage("THE INACTIVE RADIO BUTTON IS NOT DISPLAYED.");
			}

			// VERIFY THE PROPERTY 2
			title("VERIFY THE PROPERTY 2");

			// enter the the property number in the search field
			type("property_searchicon_searchtxt_XPATH", data.get("property_number_2"));

			// hit the enter key
			driver.findElement(By.xpath(OR.getProperty("property_searchicon_searchtxt_XPATH"))).sendKeys(Keys.ENTER);

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
			scrollByPixel(500);

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
					successMessage("THE FIND PROPERTY BUTTON IS DISPLAYED SUCCESSFULLY.");
				} else {
					verificationFailedMessage("THE FIND PROPERTY BUTTON IS NOT DISPLAYED.");
				}
			} catch (Throwable t) {
				verificationFailedMessage("THE FIND PROPERTY BUTTON IS NOT DISPLAYED.");
			}

			// scroll up the screen
			scrollByPixel(-500);

			// verify the active radio button
			try {
				boolean validation8 = driver
						.findElement(By.xpath(OR.getProperty("property_searchscreen_validation8_XPATH"))).isDisplayed();
				if (validation8 == true) {
					successMessage("THE ACTIVE RADIO BUTTON IS DISPLAYED SUCCESSFULLY.");
				} else {
					verificationFailedMessage("THE ACTIVE RADIO BUTTON IS NOT DISPLAYED.");
				}
			} catch (Throwable t) {
				verificationFailedMessage("THE ACTIVE RADIO BUTTON IS NOT DISPLAYED.");
			}

			// verify the inactive radio button
			try {
				boolean validation9 = driver
						.findElement(By.xpath(OR.getProperty("property_searchscreen_validation9_XPATH"))).isDisplayed();
				if (validation9 == true) {
					successMessage("THE INACTIVE RADIO BUTTON IS DISPLAYED SUCCESSFULLY.");
				} else {
					verificationFailedMessage("THE INACTIVE RADIO BUTTON IS NOT DISPLAYED.");
				}
			} catch (Throwable t) {
				verificationFailedMessage("THE INACTIVE RADIO BUTTON IS NOT DISPLAYED.");
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