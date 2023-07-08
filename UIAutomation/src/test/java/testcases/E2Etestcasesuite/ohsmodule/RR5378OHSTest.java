package testcases.E2Etestcasesuite.ohsmodule;

import java.io.IOException;
import java.util.Hashtable;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.testng.Reporter;
import org.testng.SkipException;
import org.testng.annotations.Test;

import com.relevantcodes.extentreports.LogStatus;

import base.TestBase;
import utilities.TestUtil;

public class RR5378OHSTest extends TestBase {

	@Test(dataProviderClass = TestUtil.class, dataProvider = "dp")
	public void rR5378OHSTest(Hashtable<String, String> data) throws IOException, InterruptedException {

		execution(data, "rR5378OHSTest");

		// THE EHS INCIDENTS IS SET TO A LANDING PAGE IN DASHBOARD CONFIGURATION, IT
		// SHOULD LOAD THE LIST AFTER USER LOGS IN.

		System.out.println(
				"THE EHS INCIDENTS IS SET TO A LANDING PAGE IN DASHBOARD CONFIGURATION, IT SHOULD LOAD THE LIST AFTER USER LOGS IN.");
		test.log(LogStatus.INFO,
				"THE EHS INCIDENTS IS SET TO A LANDING PAGE IN DASHBOARD CONFIGURATION, IT SHOULD LOAD THE LIST AFTER USER LOGS IN.");
		Reporter.log(
				"THE EHS INCIDENTS IS SET TO A LANDING PAGE IN DASHBOARD CONFIGURATION, IT SHOULD LOAD THE LIST AFTER USER LOGS IN.");
		log.info(
				"THE EHS INCIDENTS IS SET TO A LANDING PAGE IN DASHBOARD CONFIGURATION, IT SHOULD LOAD THE LIST AFTER USER LOGS IN.");

		// refresh the page
		driver.navigate().refresh();
		Thread.sleep(5000);
		driver.navigate().refresh();

		System.out.println("Navigate to the Home Screen i.e. Property List Screen.");

		try {
			// wait for the element
			explicitWaitClickable("questionnaire_settingicon_CSS");

			// click on the settings icon from the top of the screen
			click("questionnaire_settingicon_CSS");
			System.out.println("Clicked on the settings icon.");
			ngDriver.waitForAngularRequestsToFinish();

			// wait for the element
			explicitWaitClickable("questionnaire_administrationoption_XPATH");

			// click on the Administration option from the side menu
			click("questionnaire_administrationoption_XPATH");
			System.out.println("Clicked on the Administration option from the side menu.");
			ngDriver.waitForAngularRequestsToFinish();

			// click on the system tab
			click("questionnaire_securitytab_XPATH");
			System.out.println("Clicked on the system tab.");
			ngDriver.waitForAngularRequestsToFinish();

			// click on the notifications option
			click("questionnaire_dashboardconfigurationoption_XPATH");
			System.out.println("Clicked on the notifications option.");
			ngDriver.waitForAngularRequestsToFinish();

			// enter the dashboard name in the search field
			type("questionnaire_dashboardconfiguration_searchtxt_CSS", data.get("dashboard_name"));
			ngDriver.waitForAngularRequestsToFinish();
			System.out.println("Entered the dashboard name in the search field.");

			// click on the searched dashboard
			click("questionnaire_dashboardconfiguration_executive_XPATH");
			ngDriver.waitForAngularRequestsToFinish();
			System.out.println("Clicked on the searched dashboard.");

			// scroll down the screen
			JavascriptExecutor js = (JavascriptExecutor) driver;
			js.executeScript("window.scrollBy(0,400)");

			try {

				String ehsIncidentlbl = driver
						.findElement(
								By.xpath(OR.getProperty("questionnaire_dashboardconfiguration_ehsinsidentlbl_XPATH")))
						.getText();

				if (ehsIncidentlbl.equalsIgnoreCase("EHS Incidents")) {

					// click on the checkbox of the EHS Incident
					click("questionnaire_dashboardconfiguration_ehsinsidentckbx_XPATH");
					ngDriver.waitForAngularRequestsToFinish();
					System.out.println("Clicked on the checkbox of the EHS Incident.");

				} else {
					verificationFailed();
				}

			} catch (Throwable t) {
				verificationFailed();
			}

			// click on the home icon from the top of the screen
			click("questionnaire_homeburgermenubtn_CSS");
			System.out.println("Clicked on the home icon from the top of the screen.");
			ngDriver.waitForAngularRequestsToFinish();

			// synchronization
			explicitWait("questionnaire_dashboard_ehsincidentstitlelbl_XPATH");

			// verify the property list
			switchVerification("questionnaire_dashboard_ehsincidentstitlelbl_XPATH", "EHS Incidents",
					"The EHS Incidents is not displayed.");

			// wait for 5 seconds
			Thread.sleep(5000);

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

			System.out.println("**************** LOGIN IN SAME USER ****************");
			test.log(LogStatus.INFO, "**************** LOGIN IN SAME USER ****************");
			Reporter.log("**************** LOGIN IN SAME USER ****************");
			log.info("**************** LOGIN IN SAME USER ****************");

			// VERIFY THE EHS INCIDENT DASHBOARD IS DISPLAYED OR NOT

			System.out
					.println("**************** VERIFY THE EHS INCIDENT DASHBOARD IS DISPLAYED OR NOT ****************");
			test.log(LogStatus.INFO,
					"**************** VERIFY THE EHS INCIDENT DASHBOARD IS DISPLAYED OR NOT ****************");
			Reporter.log("**************** VERIFY THE EHS INCIDENT DASHBOARD IS DISPLAYED OR NOT ****************");
			log.info("**************** VERIFY THE EHS INCIDENT DASHBOARD IS DISPLAYED OR NOT ****************");

			// Enter the username
			ngDriver.waitForAngularRequestsToFinish();
			type("username_MODEL", data.get("username"));

			// Enter the password
			type("password_MODEL", data.get("password"));

			// Clicking on the "Sign In" button
			click("signinbtn_BTNTEXT");
			ngDriver.waitForAngularRequestsToFinish();

			// wait for the element
			Thread.sleep(10000);

			try {
				// wait for the element
				explicitWaitClickable("questionnaire_settingicon_CSS");

				// click on the settings icon from the top of the screen
				click("questionnaire_settingicon_CSS");
				System.out.println("Clicked on the settings icon.");
				ngDriver.waitForAngularRequestsToFinish();

				// wait for the element
				explicitWaitClickable("ssc_sidemenubtn_CSS");

				// click on the Switch System Company option from the side menu
				click("ssc_sidemenubtn_CSS");
				System.out.println("Clicked on the Switch System Company option from the side menu.");
				ngDriver.waitForAngularRequestsToFinish();

				// click on the switch system company dropdown
				click("ssc_systemcompanydd_CSS");
				System.out.println("Clicked on the switch system company.");
				ngDriver.waitForAngularRequestsToFinish();

				// select the system company from the system company dropdown
				select("ssc_systemcompanydd_CSS", data.get("system_company_1"));
				System.out.println("The system company is selected successfully.");
				ngDriver.waitForAngularRequestsToFinish();

				// click on system company dropdown
				click("ssc_systemcompanydd_CSS");
				System.out.println("Clicked on the system company dropdown.");
				ngDriver.waitForAngularRequestsToFinish();

				// click on the select button
				click("ssc_selectbtn_BTNTEXT");
				System.out.println("Clicked on the select button.");
				ngDriver.waitForAngularRequestsToFinish();

				// wait for the element
				Thread.sleep(5000);

				String dashboardTitle = driver
						.findElement(By.xpath(OR.getProperty("questionnaire_dashboard_ehsincidentstitlelbl_XPATH")))
						.getText();

				if (dashboardTitle.equals("EHS Incidents")) {

					// VERIFY THE EHS INCIDENT DASHBOARD IS DISPLAYED OR NOT

					System.out.println("THE EHS INCIDENT DASHBOARD IS DISPLAYED SUCCESSFULLY.");
					test.log(LogStatus.INFO, "THE EHS INCIDENT DASHBOARD IS DISPLAYED SUCCESSFULLY");
					Reporter.log("THE EHS INCIDENT DASHBOARD IS DISPLAYED SUCCESSFULLY");
					log.info("THE EHS INCIDENT DASHBOARD IS DISPLAYED SUCCESSFULLY");

				} else {
					verificationFailed();
				}

			} catch (Throwable t) {
				verificationFailed();
			}

			// click on the home icon from the top of the screen
			click("questionnaire_homeburgermenubtn_hide_CSS");
			System.out.println("Clicked on the home icon from the top of the screen.");
			ngDriver.waitForAngularRequestsToFinish();

			// wait for the element
			explicitWait("questionnaire_dashboard_ehsincidentstitlelbl_XPATH");

			// verify the property list
			switchVerification("questionnaire_dashboard_ehsincidentstitlelbl_XPATH", "EHS Incidents",
					"The EHS Incidents is not displayed.");

			// wait for the element
			explicitWaitClickable("questionnaire_settingicon_CSS");

			// click on the settings icon from the top of the screen
			click("questionnaire_settingicon_CSS");
			System.out.println("Clicked on the settings icon.");
			ngDriver.waitForAngularRequestsToFinish();

			// wait for the element
			explicitWaitClickable("questionnaire_administrationoption_XPATH");

			// click on the Administration option from the side menu
			click("questionnaire_administrationoption_XPATH");
			System.out.println("Clicked on the Administration option from the side menu.");
			ngDriver.waitForAngularRequestsToFinish();

			// click on the system tab
			click("questionnaire_securitytab_XPATH");
			System.out.println("Clicked on the system tab.");
			ngDriver.waitForAngularRequestsToFinish();

			// click on the notifications option
			click("questionnaire_dashboardconfigurationoption_XPATH");
			System.out.println("Clicked on the notifications option.");
			ngDriver.waitForAngularRequestsToFinish();

			// enter the dashboard name in the search field
			type("questionnaire_dashboardconfiguration_searchtxt_CSS", data.get("dashboard_name"));
			ngDriver.waitForAngularRequestsToFinish();
			System.out.println("Entered the dashboard name in the search field.");

			// click on the searched dashboard
			click("questionnaire_dashboardconfiguration_executive_XPATH");
			ngDriver.waitForAngularRequestsToFinish();
			System.out.println("Clicked on the searched dashboard.");

			// scroll down the screen
			js.executeScript("window.scrollBy(0,document.body.scrollHeight)");

			try {

				String propertyListlbl = driver
						.findElement(
								By.xpath(OR.getProperty("questionnaire_dashboardconfiguration_propertylistlbl_XPATH")))
						.getText();

				if (propertyListlbl.equalsIgnoreCase("Property List")) {

					// click on the checkbox of the Property List
					click("questionnaire_dashboardconfiguration_propertylistckbx_XPATH");
					ngDriver.waitForAngularRequestsToFinish();
					System.out.println("Clicked on the checkbox of the EHS Incident.");

				} else {
					verificationFailed();
				}

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

		} catch (Throwable t) {

			// refresh the page
			driver.navigate().refresh();
			Thread.sleep(5000);
			driver.navigate().refresh();

			// wait for the element
			explicitWaitClickable("questionnaire_settingicon_CSS");

			// click on the settings icon from the top of the screen
			click("questionnaire_settingicon_CSS");
			System.out.println("Clicked on the settings icon.");
			ngDriver.waitForAngularRequestsToFinish();

			// wait for the element
			explicitWaitClickable("questionnaire_administrationoption_XPATH");

			// click on the Administration option from the side menu
			click("questionnaire_administrationoption_XPATH");
			System.out.println("Clicked on the Administration option from the side menu.");
			ngDriver.waitForAngularRequestsToFinish();

			// click on the system tab
			click("questionnaire_securitytab_XPATH");
			System.out.println("Clicked on the system tab.");
			ngDriver.waitForAngularRequestsToFinish();

			// click on the notifications option
			click("questionnaire_dashboardconfigurationoption_XPATH");
			System.out.println("Clicked on the notifications option.");
			ngDriver.waitForAngularRequestsToFinish();

			// enter the dashboard name in the search field
			type("questionnaire_dashboardconfiguration_searchtxt_CSS", data.get("dashboard_name"));
			ngDriver.waitForAngularRequestsToFinish();
			System.out.println("Entered the dashboard name in the search field.");

			// click on the searched dashboard
			click("questionnaire_dashboardconfiguration_executive_XPATH");
			ngDriver.waitForAngularRequestsToFinish();
			System.out.println("Clicked on the searched dashboard.");

			// scroll down the screen
			JavascriptExecutor js = (JavascriptExecutor) driver;
			js.executeScript("window.scrollBy(0,document.body.scrollHeight)");

			try {

				String propertyListlbl = driver
						.findElement(
								By.xpath(OR.getProperty("questionnaire_dashboardconfiguration_propertylistlbl_XPATH")))
						.getText();

				if (propertyListlbl.equalsIgnoreCase("Property List")) {

					// click on the checkbox of the Property List
					click("questionnaire_dashboardconfiguration_propertylistckbx_XPATH");
					ngDriver.waitForAngularRequestsToFinish();
					System.out.println("Clicked on the checkbox of the EHS Incident.");

				} else {
					verificationFailed();
				}

			} catch (Throwable t1) {
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

		}

		// click on the home icon from the top of the screen
		click("questionnaire_homeburgermenubtn_hide_CSS");
		System.out.println("Clicked on the home icon from the top of the screen.");
		ngDriver.waitForAngularRequestsToFinish();

		// synchronization
		explicitWait("propertylist_title_XPATH");

		// verify the property list
		switchVerification("propertylist_title_XPATH", "Property List", "The property list is not displayed.");

	}
}
