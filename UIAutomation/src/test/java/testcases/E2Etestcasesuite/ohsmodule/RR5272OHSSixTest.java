package testcases.E2Etestcasesuite.ohsmodule;

import java.io.IOException;
import java.util.Hashtable;
import java.util.List;
import java.util.Random;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.testng.Reporter;
import org.testng.SkipException;
import org.testng.annotations.Test;

import com.relevantcodes.extentreports.LogStatus;

import base.Helper;
import base.TestBase;
import utilities.TestUtil;

public class RR5272OHSSixTest extends TestBase {

	@Test(dataProviderClass = TestUtil.class, dataProvider = "dp")
	public void rR5272OHSSixTest(Hashtable<String, String> data) throws IOException, InterruptedException {

		execution(data, "rR5272OHSSixTest");

		// ALERT NOTIFICATION - ALERT TYPE: EDIT AND TIME OF DAY: AM

		System.out.println("********** ALERT NOTIFICATION - ALERT TYPE: EDIT AND TIME OF DAY: AM **********");
		test.log(LogStatus.INFO, "********** ALERT NOTIFICATION - ALERT TYPE: EDIT AND TIME OF DAY: AM **********");
		Reporter.log("********** ALERT NOTIFICATION - ALERT TYPE: EDIT AND TIME OF DAY: AM **********");
		log.info("********** ALERT NOTIFICATION - ALERT TYPE: EDIT AND TIME OF DAY: AM **********");

		Helper helper = new Helper();
		
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
			click("questionnaire_systemtab_XPATH");
			System.out.println("Clicked on the system tab.");
			ngDriver.waitForAngularRequestsToFinish();

			// click on the notifications option
			click("questionnaire_notificationsoption_XPATH");
			System.out.println("Clicked on the notifications option.");
			ngDriver.waitForAngularRequestsToFinish();

			// click on the delete button of the newly created Mortgage Undertakings
			List<WebElement> links = driver
					.findElements(By.xpath(OR.getProperty("ohs_alertnotification_alertscount_XPATH")));
			int count = links.size();
			System.out.println("Number of links are:" + count);

			for (int i = 1; i <= count; i++) {

				// click on alert randomly
				List<WebElement> links1 = driver
						.findElements(By.xpath(OR.getProperty("ohs_alertnotification_alertscount_XPATH")));
				int count1 = links1.size();
				System.out.println("Remaining repair links after deleted the repair link: " + count1);

				Random r = new Random();
				links1.get(r.nextInt(count1)).click();

				// scroll down the screen
				JavascriptExecutor js = (JavascriptExecutor) driver;
				js.executeScript("window.scrollBy(0,700)");

				// wait for the element
				explicitWaitClickable("ohs_incident_alertnotification_deletebtn_CSS");

				// click on the delete button
				click("ohs_incident_alertnotification_deletebtn_CSS");
				ngDriver.waitForAngularRequestsToFinish();
				System.out.println("Clicked on the delete button.");

				// wait for the element
				explicitWaitClickable("ohs_incident_alertnotification_confirmdeletebtn_CSS");

				// click on the delete button of confirmation message
				click("ohs_incident_alertnotification_confirmdeletebtn_CSS");
				ngDriver.waitForAngularRequestsToFinish();
				System.out.println("Clicked on the delete button of confirmation message.");

			}

		} catch (Throwable t) {
			verificationFailed();
		}

		// ADD NEW ALERT NOTIFICATION - ALERT TYPE: EDIT AND TIME OF DAY: AM

		System.out.println("********** ADD NEW ALERT NOTIFICATION - ALERT TYPE: EDIT AND TIME OF DAY: AM **********");
		test.log(LogStatus.INFO,
				"********** ADD NEW ALERT NOTIFICATION - ALERT TYPE: EDIT AND TIME OF DAY: AM **********");
		Reporter.log("********** ADD NEW ALERT NOTIFICATION - ALERT TYPE: EDIT AND TIME OF DAY: AM **********");
		log.info("********** ADD NEW ALERT NOTIFICATION - ALERT TYPE: EDIT AND TIME OF DAY: AM **********");

		try {

			// wait for the element
			explicitWaitClickable("ohs_incident_alertnotification_addbtn_CSS");

			// click on the add button
			click("ohs_incident_alertnotification_addbtn_CSS");
			ngDriver.waitForAngularRequestsToFinish();
			System.out.println("Clicked on the add button.");

			// click on the ohs module
			click("ohs_incident_alertnotification_ohsmodule_CSS");
			ngDriver.waitForAngularRequestsToFinish();
			System.out.println("Clicked on the ohs module.");

			// select the incident option from the record type
			select("ohs_incident_alertnotification_recordtypedd_CSS", data.get("record_type"));
			ngDriver.waitForAngularRequestsToFinish();
			System.out.println("Selected the incident option from the record type.");

			// select add record option from the alert type
			select("ohs_incident_alertnotification_alerttypedd_CSS", data.get("alert_type"));
			ngDriver.waitForAngularRequestsToFinish();
			System.out.println("Selected add record option from the record type.");

			// scroll down the screen
			JavascriptExecutor js = (JavascriptExecutor) driver;
			js.executeScript("window.scrollBy(0,500)");

			// select active option from the alert status
			select("ohs_incident_alertnotification_alertstatusdd_CSS", data.get("alert_status"));
			ngDriver.waitForAngularRequestsToFinish();
			System.out.println("Selected active option from the alert status.");

			// select All Day option from the time of day
			select("ohs_incident_alertnotification_timeofdaydd_CSS", data.get("time_of_day"));
			ngDriver.waitForAngularRequestsToFinish();
			System.out.println("Selected All Day option from the time of day.");

			// scroll down the screen
			js.executeScript("window.scrollBy(0,500)");

			// click on the add a condition button
			click("ohs_incident_alertnotification_addaconditionbtn_CSS");
			ngDriver.waitForAngularRequestsToFinish();
			System.out.println("Clicked on the add a condition button.");

			// select event type of incident option
			select("ohs_incident_alertnotification_fieldcondition1_CSS", data.get("field_condition_1"));
			ngDriver.waitForAngularRequestsToFinish();
			System.out.println("Selected event type of incident option.");

			// select is equal to option
			select("ohs_incident_alertnotification_fieldcondition2_CSS", data.get("field_condition_2"));
			ngDriver.waitForAngularRequestsToFinish();
			System.out.println("Selected is equal to option.");

			// enter the field name
			type("ohs_incident_alertnotification_fieldcondition3_CSS", data.get("field_condition_3"));
			ngDriver.waitForAngularRequestsToFinish();
			System.out.println("Entered the field name.");

			// scroll down the screen
			js.executeScript("window.scrollBy(0,500)");

			// click on the user field
			click("ohs_incident_alertnotification_usernotificationtxt_CSS");
			ngDriver.waitForAngularRequestsToFinish();
			System.out.println("Clicked on the user field.");

			// click on the none button
			click("ohs_incident_alertnotification_nonebtn_CSS");
			ngDriver.waitForAngularRequestsToFinish();
			System.out.println("Clicked on the none button.");

			// enter username on the search field
			type("ohs_incident_alertnotification_searchtxt_CSS", data.get("username"));
			ngDriver.waitForAngularRequestsToFinish();
			System.out.println("Entered username on the search field.");

			// click on the searched user
			click("ohs_incident_alertnotification_searcheduser_XPATH");
			ngDriver.waitForAngularRequestsToFinish();
			System.out.println("Clicked on the searched user.");

			// click on the user field
			click("ohs_incident_alertnotification_usernotificationtxt_CSS");
			ngDriver.waitForAngularRequestsToFinish();
			System.out.println("Clicked on the user field.");

			// click on the save button
			click("ohs_incident_alertnotification_savebtn_CSS");
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

		// CREATE NEW INCIDENT REPORT

		System.out.println("********** CREATE NEW INCIDENT REPORT **********");
		test.log(LogStatus.INFO, "********** CREATE NEW INCIDENT REPORT **********");
		Reporter.log("********** CREATE NEW INCIDENT REPORT **********");
		log.info("********** CREATE NEW INCIDENT REPORT **********");

		try {

			// click on the OHS icon from the property list page
			click("ohsicon_CSS");
			System.out.println("Clicked on the OHS icon of the Property.");
			ngDriver.waitForAngularRequestsToFinish();
			System.out.println("Navigate to the OHS screen of the perticular property.");

			// click on the burger menu
			click("menubtn_CSS");
			System.out.println("Clicked on the burger menu button successfully!!!");
			ngDriver.waitForAngularRequestsToFinish();

			// wait for the element
			explicitWaitClickable("questionnaire_option_ohstab_incidentreports_XPATH");

			// click on the incident reports
			click("questionnaire_option_ohstab_incidentreports_XPATH");
			System.out.println("Clicked on the incident reports option.");
			ngDriver.waitForAngularRequestsToFinish();

			// ADD DETAILS IN THE INCIDENT REPORT TAB

			System.out.println("********** ADD DETAILS IN THE INCIDENT REPORT TAB **********");
			test.log(LogStatus.INFO, "********** ADD DETAILS IN THE INCIDENT REPORT TAB **********");
			Reporter.log("********** ADD DETAILS IN THE INCIDENT REPORT TAB **********");
			log.info("********** ADD DETAILS IN THE DETAILS, CAUSES TAB **********");

			// wait for the element
			explicitWaitClickable("ohs_incident_addbtn_CSS");

			// click on the add button
			click("ohs_incident_addbtn_CSS");
			System.out.println("Clicked on the Add button.");
			ngDriver.waitForAngularRequestsToFinish();
			System.out.println("Navigate to the Add incident report Screen");

			// wait for the element
			Thread.sleep(5000);

			// enter the incident time - hours
			clear("ohs_incident_hourstxt_CSS");
			System.out.println("Cleared the hours field of incident time.");
			ngDriver.waitForAngularRequestsToFinish();
			type("ohs_incident_hourstxt_CSS", "11");
			System.out.println("Entered the hours in the incident time.");
			ngDriver.waitForAngularRequestsToFinish();

			// enter the incident time - minute
			clear("ohs_incident_minutestxt_CSS");
			System.out.println("Cleared the minute field of incident time.");
			ngDriver.waitForAngularRequestsToFinish();
			type("ohs_incident_minutestxt_CSS", "20");
			System.out.println("Entered the minute in the incident time.");
			ngDriver.waitForAngularRequestsToFinish();

			// scroll down the screen
			JavascriptExecutor js = (JavascriptExecutor) driver;
			js.executeScript("window.scrollBy(0,500)");

			// enter the short description
			type("ohs_incident_shortdescriptiontxt_CSS", data.get("describe_incident"));
			System.out.println("Entered the short description");
			ngDriver.waitForAngularRequestsToFinish();

			// click on the add event type button
			click("ohs_incident_addeventtypebtn_CSS");
			System.out.println("Clicked on the add event type button.");
			ngDriver.waitForAngularRequestsToFinish();

			// click on the event type dropdown
			select("ohs_incident_eventtypedd_CSS", data.get("event_type"));
			System.out.println("Clicked on the event type dropdown.");
			ngDriver.waitForAngularRequestsToFinish();

			// click on the add button of the add event type record model
			click("ohs_incident_eventty_addbtn_CSS");
			System.out.println("Clicked on the add button of the add event type record model.");
			ngDriver.waitForAngularRequestsToFinish();

			// click on the next button
			click("ohs_incident_nextbtn_CSS");
			System.out.println("Clicked on the next button.");
			ngDriver.waitForAngularRequestsToFinish();

			// synchronization
			explicitWait("ohs_incident_nextbtn_CSS");
			System.out.println("Navigate to the Details, Cause Tab.");
			test.log(LogStatus.INFO, "Navigate to the Details, Cause Tab..");
			Reporter.log("Navigate to the Details, Cause Tab..");
			log.info("Navigate to the Details, Cause Tab..");

			// ADD DETAILS IN THE DETAILS, CAUSES TAB

			System.out.println("********** ADD DETAILS IN THE DETAILS, CAUSES TAB **********");
			test.log(LogStatus.INFO, "********** ADD DETAILS IN THE DETAILS, CAUSES TAB **********");
			Reporter.log("********** ADD DETAILS IN THE DETAILS, CAUSES TAB **********");
			log.info("********** ADD DETAILS IN THE DETAILS, CAUSES TAB **********");

			// click on the next button
			click("ohs_incident_nextbtn_CSS");
			System.out.println("Clicked on the next button.");
			ngDriver.waitForAngularRequestsToFinish();

			// synchronization
			explicitWait("ohs_incident_personsinvolved_addbtn_CSS");
			System.out.println("Navigate to the Persons Involved Tab.");
			test.log(LogStatus.INFO, "Navigate to the Persons Involved Tab.");
			Reporter.log("Navigate to the Persons Involved Tab.");
			log.info("Navigate to the Persons Involved Tab.");

			// ADD DETAILS IN THE PERSONS INVOLVED TAB

			System.out.println("********** ADD DETAILS IN THE PERSONS INVOLVED TAB **********");
			test.log(LogStatus.INFO, "********** ADD DETAILS IN THE PERSONS INVOLVED TAB **********");
			Reporter.log("********** ADD DETAILS IN THE PERSONS INVOLVED TAB **********");
			log.info("********** ADD DETAILS IN THE PERSONS INVOLVED TAB **********");

			// click on the next button
			click("ohs_incident_nextbtn_CSS");
			System.out.println("Clicked on the next button.");
			ngDriver.waitForAngularRequestsToFinish();

			// synchronization
			explicitWait("ohs_incident_nextbtn_CSS");
			System.out.println("Navigate to the Witnesses Tab.");
			test.log(LogStatus.INFO, "Navigate to the Witnesses Tab.");
			Reporter.log("Navigate to the Witnesses Tab.");
			log.info("Navigate to the Witnesses Tab.");

			// ADD DETAILS IN THE WITNESSES TAB

			System.out.println("********** ADD DETAILS IN THE WITNESSES TAB **********");
			test.log(LogStatus.INFO, "********** ADD DETAILS IN THE WITNESSES TAB **********");
			Reporter.log("********** ADD DETAILS IN THE WITNESSES TAB **********");
			log.info("********** ADD DETAILS IN THE WITNESSES TAB **********");

			// click on the next button
			click("ohs_incident_nextbtn_CSS");
			System.out.println("Clicked on the next button.");
			ngDriver.waitForAngularRequestsToFinish();

			// synchronization
			explicitWait("ohs_incident_nextbtn_CSS");
			System.out.println("Navigate to the emergency services Tab.");
			test.log(LogStatus.INFO, "Navigate to the emergency services Tab.");
			Reporter.log("Navigate to the emergency services Tab.");
			log.info("Navigate to the emergency services Tab.");

			// ADD DETAILS IN THE EMERGENCY SERVICES TAB

			System.out.println("********** ADD DETAILS IN THE EMERGENCY SERVICES TAB **********");
			test.log(LogStatus.INFO, "********** ADD DETAILS IN THE EMERGENCY SERVICES TAB **********");
			Reporter.log("********** ADD DETAILS IN THE EMERGENCY SERVICES TAB **********");
			log.info("********** ADD DETAILS IN THE EMERGENCY SERVICES TAB **********");

			// click on the next button
			click("ohs_incident_nextbtn_CSS");
			System.out.println("Clicked on the next button.");
			ngDriver.waitForAngularRequestsToFinish();

			// synchronization
			explicitWait("ohs_incident_nextbtn_CSS");
			System.out.println("Navigate to the property damage Tab.");
			test.log(LogStatus.INFO, "Navigate to the property damage Tab.");
			Reporter.log("Navigate to the property damage Tab.");
			log.info("Navigate to the property damage Tab.");

			// ADD DETAILS IN THE PROPERTY DAMAGE TAB

			System.out.println("********** ADD DETAILS IN THE PROPERTY DAMAGE TAB **********");
			test.log(LogStatus.INFO, "********** ADD DETAILS IN THE PROPERTY DAMAGE TAB **********");
			Reporter.log("********** ADD DETAILS IN THE PROPERTY DAMAGE TAB **********");
			log.info("********** ADD DETAILS IN THE PROPERTY DAMAGE TAB **********");

			// click on the next button
			click("ohs_incident_nextbtn_CSS");
			System.out.println("Clicked on the next button.");
			ngDriver.waitForAngularRequestsToFinish();

			// synchronization
			explicitWait("ohs_incident_nextbtn_CSS");
			System.out.println("Navigate to the insurance Tab.");
			test.log(LogStatus.INFO, "Navigate to the insurance Tab.");
			Reporter.log("Navigate to the insurance Tab.");
			log.info("Navigate to the insurance Tab.");

			// ADD DETAILS IN THE INSURANCE TAB

			System.out.println("********** ADD DETAILS IN THE INSURANCE TAB **********");
			test.log(LogStatus.INFO, "********** ADD DETAILS IN THE INSURANCE TAB **********");
			Reporter.log("********** ADD DETAILS IN THE INSURANCE TAB **********");
			log.info("********** ADD DETAILS IN THE INSURANCE TAB **********");

			// click on the next button
			click("ohs_incident_nextbtn_CSS");
			System.out.println("Clicked on the next button.");
			ngDriver.waitForAngularRequestsToFinish();

			// synchronization
			explicitWait("ohs_incident_updaterecordbtn_CSS");
			System.out.println("Navigate to the attachments Tab.");
			test.log(LogStatus.INFO, "Navigate to the attachments Tab.");
			Reporter.log("Navigate to the attachments Tab.");
			log.info("Navigate to the attachments Tab.");

			// ADD DETAILS IN THE ATTACHMENTS TAB

			System.out.println("********** ADD DETAILS IN THE ATTACHMENTS TAB **********");
			test.log(LogStatus.INFO, "********** ADD DETAILS IN THE ATTACHMENTS TAB **********");
			Reporter.log("********** ADD DETAILS IN THE ATTACHMENTS TAB **********");
			log.info("********** ADD DETAILS IN THE ATTACHMENTS TAB **********");

			// click on the update record button
			click("ohs_incident_updaterecordbtn_CSS");
			ngDriver.waitForAngularRequestsToFinish();
			System.out.println("The update record button clicked successfully");

			// wait for the element
			explicitWaitClickable("ohs_incident_search_clearbtn_XPATH");

			// click on the clear button
			click("ohs_incident_search_clearbtn_XPATH");
			ngDriver.waitForAngularRequestsToFinish();
			System.out.println("Clicked on the clear button.");
			
			// enter the newly created incident report in the search field
			type("ohs_incident_searchtxt_CSS", data.get("describe_incident"));
			System.out.println("Entered the newly created incident report in the search field.");
			ngDriver.waitForAngularRequestsToFinish();

			// click on the search button
			click("ohs_incident_search_searchbtn_CSS");
			ngDriver.waitForAngularRequestsToFinish();
			System.out.println("Clicked on the search button.");

			// verification of the incident report is added or not
			switchVerification("ohs_incident_alertnotification_addedincidentreport6_XPATH",
					"Describe Incident Text Alert Notification Six",
					"The Describe Incident Text Alert Notification Six is not displayed successfully.");

		} catch (Throwable t) {
			verificationFailed();
		}

		// UPDATE THE NEWLY CREATED INCIDENT REPORT

		System.out.println("********** UPDATE THE NEWLY CREATED INCIDENT REPORT **********");
		test.log(LogStatus.INFO, "********** UPDATE THE NEWLY CREATED INCIDENT REPORT **********");
		Reporter.log("********** UPDATE THE NEWLY CREATED INCIDENT REPORT **********");
		log.info("********** UPDATE THE NEWLY CREATED INCIDENT REPORT **********");

		try {
			// click on the newly created incident report
			click("ohs_incident_alertnotification_addedincidentreport6_XPATH");
			System.out.println("Clicked on the newly created incident report.");
			ngDriver.waitForAngularRequestsToFinish();
			System.out.println("Naviagte to the Update Incident record Screen.");

			// scroll down the screen
			JavascriptExecutor js = (JavascriptExecutor) driver;
			js.executeScript("window.scrollBy(0,500)");

			// update the short description
			clear("ohs_incident_shortdescriptiontxt_CSS");
			ngDriver.waitForAngularRequestsToFinish();
			System.out.println("Cleared the short description.");
			type("ohs_incident_shortdescriptiontxt_CSS", data.get("update_describe_incident"));
			System.out.println("Entered the short description");
			ngDriver.waitForAngularRequestsToFinish();

			// click on the update button
			click("ohs_incident_updatebtn_CSS");
			ngDriver.waitForAngularRequestsToFinish();
			System.out.println("Clicked on the update button.");

			// wait for the element
			explicitWaitClickable("closetoastmsg_CSS");

			// click on the toaster close button
			click("closetoastmsg_CSS");
			ngDriver.waitForAngularRequestsToFinish();
			System.out.println("Clicked on the toaster close button.");

			// click on the cancel button
			click("ohs_incident_alertnotification_cancelbtn_XPATH");
			ngDriver.waitForAngularRequestsToFinish();
			System.out.println("Clicked on the cancel button.");

			// wait for the element
			explicitWaitClickable("ohs_incident_search_clearbtn_XPATH");

			// click on the clear button
			click("ohs_incident_search_clearbtn_XPATH");
			ngDriver.waitForAngularRequestsToFinish();
			System.out.println("Clicked on the clear button.");
			
			// enter the newly created incident report in the search field
			type("ohs_incident_searchtxt_CSS", data.get("update_describe_incident"));
			System.out.println("Entered the newly created incident report in the search field.");
			ngDriver.waitForAngularRequestsToFinish();

			// click on the search button
			click("ohs_incident_search_searchbtn_CSS");
			ngDriver.waitForAngularRequestsToFinish();
			System.out.println("Clicked on the search button.");
			
			// verification of the incident report is added or not
			switchVerification("ohs_incident_alertnotification_updatedincidentreport6_XPATH",
					"Update Describe Incident Text Alert Notification Six",
					"The Update Describe Incident Text Alert Notification Six is not displayed successfully.");

		} catch (Throwable t) {
			verificationFailed();
		}

		// DELETE THE NEWLY UPDATED REPORT

		System.out.println("********** DELETE THE UPDATED INCIDENT REPORT **********");
		test.log(LogStatus.INFO, "********** DELETE THE UPDATED INCIDENT REPORT **********");
		Reporter.log("********** DELETE THE UPDATED INCIDENT REPORT **********");
		log.info("********** DELETE THE UPDATED INCIDENT REPORT **********");

		try {
			// click on the newly created incident report
			click("ohs_incident_alertnotification_updatedincidentreport6_XPATH");
			System.out.println("Clicked on the newly created incident report.");
			ngDriver.waitForAngularRequestsToFinish();
			System.out.println("Naviagte to the Update Incident record Screen.");

			// wait for the element
			explicitWaitClickable("ohs_incident_deletebtn_CSS");

			// click on the delete button
			click("ohs_incident_deletebtn_CSS");
			ngDriver.waitForAngularRequestsToFinish();
			System.out.println("Clicked on the delete button.");

			// wait for the element
			explicitWaitClickable("ohs_incident_confirmdeletebtn_CSS");

			// click on the delete button of confirmation popup
			click("ohs_incident_confirmdeletebtn_CSS");
			ngDriver.waitForAngularRequestsToFinish();
			System.out.println("Clicked on the delete button of confirmation popup.");

			// verify details are deleted or not
			helper.deleteVerification("ohs_incident_alertnotification_updatedincidentreport6_XPATH",
					"Update Describe Incident Text Alert Notification Six");

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

		// DELETE THE NEWLY CREATED ALERT NOTIFICATION

		System.out.println("********** DELETE THE NEWLY CREATED ALERT NOTIFICATION **********");
		test.log(LogStatus.INFO, "********** DELETE THE NEWLY CREATED ALERT NOTIFICATION **********");
		Reporter.log("********** DELETE THE NEWLY CREATED ALERT NOTIFICATION **********");
		log.info("********** DELETE THE NEWLY CREATED ALERT NOTIFICATION **********");

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
			click("questionnaire_systemtab_XPATH");
			System.out.println("Clicked on the system tab.");
			ngDriver.waitForAngularRequestsToFinish();

			// click on the notifications option
			click("questionnaire_notificationsoption_XPATH");
			System.out.println("Clicked on the notifications option.");
			ngDriver.waitForAngularRequestsToFinish();

			// click on the delete button of the newly created Mortgage Undertakings
			List<WebElement> links = driver
					.findElements(By.xpath(OR.getProperty("ohs_alertnotification_alertscount_XPATH")));
			int count = links.size();
			System.out.println("Number of links are:" + count);

			for (int i = 1; i <= count; i++) {

				// click on alert randomly
				List<WebElement> links1 = driver
						.findElements(By.xpath(OR.getProperty("ohs_alertnotification_alertscount_XPATH")));
				int count1 = links1.size();
				System.out.println("Remaining repair links after deleted the repair link: " + count1);

				Random r = new Random();
				links1.get(r.nextInt(count1)).click();

				// scroll down the screen
				JavascriptExecutor js = (JavascriptExecutor) driver;
				js.executeScript("window.scrollBy(0,700)");

				// wait for the element
				explicitWaitClickable("ohs_incident_alertnotification_deletebtn_CSS");

				// click on the delete button
				click("ohs_incident_alertnotification_deletebtn_CSS");
				ngDriver.waitForAngularRequestsToFinish();
				System.out.println("Clicked on the delete button.");

				// wait for the element
				explicitWaitClickable("ohs_incident_alertnotification_confirmdeletebtn_CSS");

				// click on the delete button of confirmation message
				click("ohs_incident_alertnotification_confirmdeletebtn_CSS");
				ngDriver.waitForAngularRequestsToFinish();
				System.out.println("Clicked on the delete button of confirmation message.");

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

	}
}