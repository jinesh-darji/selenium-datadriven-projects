package testcases.E2Etestcasesuite.ohsmodule;

import java.io.IOException;
import java.util.Hashtable;
import java.util.List;
import java.util.Random;

import org.apache.commons.lang3.RandomStringUtils;
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

public class RR5138OHSTwoTest extends TestBase {

	@Test(dataProviderClass = TestUtil.class, dataProvider = "dp")
	public void rR5138OHSTwoTest(Hashtable<String, String> data) throws IOException, InterruptedException {

		execution(data, "rR5138OHSTwoTest");

		// NUMBER OF TASKS ON THE OHS PROPERTY LANDING PAGE. (WHICH ARE DUE AFTER 30
		// DAYS)

		// NOTE: 1. NEED RECOMMENDATAION CREATED FOR CREATE THE NEW TASK. THE
		// RECOMMENDATAION IS CREATED FROM THE TASK TYPE DASHBOARD.

		System.out.println("NUMBER OF TASKS ON THE OHS PROPERTY LANDING PAGE. (WHICH ARE DUE AFTER 30 DAYS)");
		test.log(LogStatus.INFO, "NUMBER OF TASKS ON THE OHS PROPERTY LANDING PAGE. (WHICH ARE DUE AFTER 30 DAYS)");
		Reporter.log("NUMBER OF TASKS ON THE OHS PROPERTY LANDING PAGE. (WHICH ARE DUE AFTER 30 DAYS)");
		log.info("NUMBER OF TASKS ON THE OHS PROPERTY LANDING PAGE. (WHICH ARE DUE AFTER 30 DAYS)");

		Helper helper = new Helper();

		// refresh the page
		driver.navigate().refresh();
		Thread.sleep(5000);
		driver.navigate().refresh();

		System.out.println("Navigate to the Home Screen i.e. Property List Screen.");

		// DELETE THE previously CREATED INCIDENT REPORT

		title("DELETE THE previously CREATED INCIDENT REPORT");

		try {

			// wait for the element
			explicitWaitClickable("ohsicon_CSS");

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

			// click on the delete button of the incident report
			List<WebElement> links3 = driver.findElements(By.xpath(OR.getProperty("ohs_incident_incidentlist_XPATH")));
			int count3 = links3.size();
			System.out.println("Number of incident report are:" + count3);

			for (int i = 0; i < count3 - 1; i++) {

				// click on repair randomly
				List<WebElement> links33 = driver
						.findElements(By.xpath(OR.getProperty("ohs_incident_incidentlistbody_XPATH")));
				int count33 = links33.size();
				System.out.println("Remaining incident report after deleted the incident report recod: " + count33);

				Random r = new Random();
				links33.get(r.nextInt(count33)).click();

				// wait for the element
				explicitWaitClickable("ohs_incident_deletebtn_CSS");

				// click on the delete button for delete the incident report
				click("ohs_incident_deletebtn_CSS");
				System.out.println("Clicked on the delete button for delete the incident report.");
				ngDriver.waitForAngularRequestsToFinish();

				// wait for the element
				explicitWaitClickable("ohs_incident_confirmdeletebtn_CSS");

				// click on the delete button of confirmation model for delete the incident
				// report
				click("ohs_incident_confirmdeletebtn_CSS");
				System.out.println("Clicked on the delete button of confirmation model.");
				ngDriver.waitForAngularRequestsToFinish();

			}

		} catch (Throwable t) {

			verificationFailed();
		}

		// wait for the element
		explicitWaitClickable("questionnaire_homeburgermenubtn_hide_CSS");

		// click on the home icon from the top of the screen
		click("questionnaire_homeburgermenubtn_hide_CSS");
		System.out.println("Clicked on the home icon from the top of the screen.");
		ngDriver.waitForAngularRequestsToFinish();

		// synchronization
		explicitWait("propertylist_title_XPATH");

		// verify the property list
		switchVerification("propertylist_title_XPATH", "Property List", "The property list is not displayed.");

		try {
			// click on the OHS icon from the property list page
			click("ohsicon_CSS");
			System.out.println("Clicked on the OHS icon of the Property.");
			ngDriver.waitForAngularRequestsToFinish();
			System.out.println("Navigate to the OHS screen of the perticular property.");

			// wait for the element
			Thread.sleep(5000);

			// click on the burger menu
			click("menubtn_CSS");
			System.out.println("Clicked on the burger menu button successfully!!!");
			ngDriver.waitForAngularRequestsToFinish();

			// wait for the element
			Thread.sleep(5000);

			// click on the incident reports
			click("questionnaire_option_ohstab_incidentreports_XPATH");
			System.out.println("Clicked on the incident reports option.");
			ngDriver.waitForAngularRequestsToFinish();

			// ADD RECORD - INCIDENT REPORT

			System.out.println("**************** ADD RECORD - INCIDENT REPORT ****************");
			test.log(LogStatus.INFO, "**************** ADD RECORD - INCIDENT REPORT ****************");
			Reporter.log("**************** ADD RECORD - INCIDENT REPORT ****************");
			log.info("**************** ADD RECORD - INCIDENT REPORT ****************");

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
			type("ohs_incident_shortdescriptiontxt_CSS", data.get("short_description"));
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

			// click on the next button
			click("ohs_incident_nextbtn_CSS");
			System.out.println("Clicked on the next button.");
			ngDriver.waitForAngularRequestsToFinish();

			// synchronization
			explicitWait("ohs_incident_nextbtn_CSS");
			System.out.println("Navigate to the Persons Involved Tab.");
			test.log(LogStatus.INFO, "Navigate to the Persons Involved Tab.");
			Reporter.log("Navigate to the Persons Involved Tab.");
			log.info("Navigate to the Persons Involved Tab.");

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

			// click on the next button
			click("ohs_incident_nextbtn_CSS");
			System.out.println("Clicked on the next button.");
			ngDriver.waitForAngularRequestsToFinish();

			// synchronization
			explicitWait("ohs_incident_nextbtn_CSS");
			System.out.println("Navigate to the Emergency Services Tab.");
			test.log(LogStatus.INFO, "Navigate to the Emergency Services Tab.");
			Reporter.log("Navigate to the Emergency Services Tab.");
			log.info("Navigate to the Emergency Services Tab.");

			// click on the next button
			click("ohs_incident_nextbtn_CSS");
			System.out.println("Clicked on the next button.");
			ngDriver.waitForAngularRequestsToFinish();

			// synchronization
			explicitWait("ohs_incident_nextbtn_CSS");
			System.out.println("Navigate to the Property Damage Tab.");
			test.log(LogStatus.INFO, "Navigate to the Property Damage Tab.");
			Reporter.log("Navigate to the Property Damage Tab.");
			log.info("Navigate to the Property Damage Tab.");

			// click on the next button
			click("ohs_incident_nextbtn_CSS");
			System.out.println("Clicked on the next button.");
			ngDriver.waitForAngularRequestsToFinish();

			// synchronization
			explicitWait("ohs_incident_nextbtn_CSS");
			System.out.println("Navigate to the Insurance Tab.");
			test.log(LogStatus.INFO, "Navigate to the Insurance Tab.");
			Reporter.log("Navigate to the Insurance Tab.");
			log.info("Navigate to the Insurance Tab.");

			// click on the next button
			click("ohs_incident_nextbtn_CSS");
			System.out.println("Clicked on the next button.");
			ngDriver.waitForAngularRequestsToFinish();

			// synchronization
			explicitWait("ohs_incident_updaterecordbtn_CSS");
			System.out.println("Navigate to the Attachments Tab.");
			test.log(LogStatus.INFO, "Navigate to the Attachments Tab.");
			Reporter.log("Navigate to the Attachments Tab.");
			log.info("Navigate to the Attachments Tab.");

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
			type("short_description", data.get("short_description"));
			System.out.println("Entered the newly created incident report in the search field.");
			ngDriver.waitForAngularRequestsToFinish();

			// click on the search button
			click("ohs_incident_search_searchbtn_CSS");
			ngDriver.waitForAngularRequestsToFinish();
			System.out.println("Clicked on the search button.");

			// verification of the incident report is added or not
			switchVerification("ohs_incident_addedincidentreport_taskcount2_XPATH",
					"Task Count Two Short Description for Testing Purpose",
					"The Task Count Two Short Description for Testing Purpose is not displayed successfully.");

		} catch (Throwable t) {
			verificationFailed();
		}

		Random random = new Random();
		int task1 = random.nextInt(5 - 1) + 1;
		System.out.println("Task's Count in incident report: " + task1);
		test.log(LogStatus.INFO, "Task's Count in incident report: " + task1);
		Reporter.log("Task's Count in incident report: " + task1);
		log.info("Task's Count in incident report: " + task1);

		try {
			// click on the added incident report
			click("ohs_incident_addedincidentreport_taskcount2_XPATH");
			System.out.println("Clicked on the incident record for add the task.");
			ngDriver.waitForAngularRequestsToFinish();
			System.out.println("Naviagte to the Update Incident record Screen.");

			// CREATE THE RANDOM TASKS IN THE INCIDENT REPORT

			System.out.println("**************** CREATE THE RANDOM TASKS IN THE INCIDENT REPORT ****************");
			test.log(LogStatus.INFO,
					"**************** CREATE THE RANDOM TASKS IN THE INCIDENT REPORT ****************");
			Reporter.log("**************** CREATE THE RANDOM TASKS IN THE INCIDENT REPORT ****************");
			log.info("**************** CREATE THE RANDOM TASKS IN THE INCIDENT REPORT ****************");

			for (int i = 1; i <= task1; i++) {

				// ADD THE TASK

				// click on the task tab
				click("ohs_incident_tasktab_CSS");
				System.out.println("Clicked on the task tag.");
				ngDriver.waitForAngularRequestsToFinish();

				// click on the add task button
				click("ohs_incident_tasktab_addbtn_CSS");
				System.out.println("Clicked on the add task button.");
				ngDriver.waitForAngularRequestsToFinish();

				// scroll down the screen
				JavascriptExecutor js = (JavascriptExecutor) driver;
				js.executeScript("window.scrollBy(0,400)");

				// generate the random string for task title
				String tasktitle1 = RandomStringUtils.randomAlphabetic(8);

				// enter the data in the task title field
				type("task_addtask_titletxt_CSS", tasktitle1);
				System.out.println("Entered the data in the task title field.");
				ngDriver.waitForAngularRequestsToFinish();

				// enter the data in the task location field
				type("task_addtask_locationtxt_CSS", data.get("task_location"));
				System.out.println("Entered the data in the task location field.");
				ngDriver.waitForAngularRequestsToFinish();

				// click on the assign to field
				click("task_assigntotxt_CSS");
				System.out.println("Clicked on the assign to field.");
				ngDriver.waitForAngularRequestsToFinish();

				// click on the none button
				click("task_tasktag_nonebtn_CSS");
				System.out.println("Clicked on the none button.");
				ngDriver.waitForAngularRequestsToFinish();

				// enter the user name in the search field
				type("workflowsecurity_editortask_taskdetails_searchtasktagtxt_CSS", data.get("search_user"));
				System.out.println("Entered the user name in the search field.");
				ngDriver.waitForAngularRequestsToFinish();

				// click on the searched result
				click("questionnaire_createtask_selectusertxt_XPATH");
				System.out.println("Clicked on the searched result.");
				ngDriver.waitForAngularRequestsToFinish();

				// click on the assign to field
				click("task_assigntotxt_CSS");
				System.out.println("Clicked on the assign to field.");
				ngDriver.waitForAngularRequestsToFinish();

				// scroll down the screen
				js.executeScript("window.scrollBy(0,400)");

				// SELECT THE DUE DATE

				try {
					// click on the due date field
					click("task_duedatetxt_CSS");
					ngDriver.waitForAngularRequestsToFinish();
					System.out.println("Clicked on the due date field.");

					// wait for the element
					explicitWaitClickable("task_datepicker_yearbtn1_CSS");

					// click on the year button
					click("task_datepicker_yearbtn1_CSS");
					ngDriver.waitForAngularRequestsToFinish();
					System.out.println("Clicked on the year button.");

					int year = random.nextInt(5 - 1 + 1) + 1;
					System.out.println("Number of click for select the year : " + year);
					test.log(LogStatus.INFO, "Number of click for select the year: " + year);
					Reporter.log("Number of click for select the year: " + year);
					log.info("Number of click for select the year: " + year);

					for (int j = 1; j <= year; j++) {

						// wait for the element
						explicitWaitClickable("task_datepicker_nextbtn_CSS");

						// click on the next button for select the year
						click("task_datepicker_nextbtn_CSS");
						ngDriver.waitForAngularRequestsToFinish();

					}

					System.out.println("Clicked on the next button for select the year.");

					// click on the December month
					click("task_datepicker_decembermonth_XPATH");
					ngDriver.waitForAngularRequestsToFinish();
					System.out.println("Clicked on the December month.");

					// click on the 31 December date
					click("task_datepicker_31decemberdate_XPATH");
					ngDriver.waitForAngularRequestsToFinish();
					System.out.println("Clicked on the 31 December date.");

				} catch (Throwable t) {
					verificationFailed();
				}

				// click on the save button
				click("ohs_incident_tasktab_addtaskbtn_CSS");
				System.out.println("Clicked on the save button.");
				ngDriver.waitForAngularRequestsToFinish();

			}

			// click on the cancel button
			click("ohs_incident_cancelbtn_CSS");
			ngDriver.waitForAngularRequestsToFinish();
			System.out.println("Clicked on the cancel button.");

			// wait for the element
			explicitWaitClickable("ohs_incident_search_clearbtn_XPATH");

			// click on the clear button
			click("ohs_incident_search_clearbtn_XPATH");
			ngDriver.waitForAngularRequestsToFinish();
			System.out.println("Clicked on the clear button.");

			// enter the newly created incident report in the search field
			type("ohs_incident_searchtxt_CSS", data.get("short_description"));
			System.out.println("Entered the newly created incident report in the search field.");
			ngDriver.waitForAngularRequestsToFinish();

			// click on the search button
			click("ohs_incident_search_searchbtn_CSS");
			ngDriver.waitForAngularRequestsToFinish();
			System.out.println("Clicked on the search button.");

			// verification of the incident report is added or not
			switchVerification("ohs_incident_addedincidentreport_taskcount2_XPATH",
					"Task Count Two Short Description for Testing Purpose",
					"The Task Count Two Short Description for Testing Purpose is not displayed successfully.");

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

		// VERIFY THE NEWLY CREATED TASK'S COUNT ON OHS PROPERTY SUMMARY SCREEN

		System.out.println(
				"**************** VERIFY THE NEWLY CREATED TASK'S COUNT ON OHS PROPERTY SUMMARY SCREEN ****************");
		test.log(LogStatus.INFO,
				"**************** VERIFY THE NEWLY CREATED TASK'S COUNT ON OHS PROPERTY SUMMARY SCREEN ****************");
		Reporter.log(
				"**************** VERIFY THE NEWLY CREATED TASK'S COUNT ON OHS PROPERTY SUMMARY SCREEN ****************");
		log.info(
				"**************** VERIFY THE NEWLY CREATED TASK'S COUNT ON OHS PROPERTY SUMMARY SCREEN ****************");

		try {
			// click on the OHS icon from the property list page
			click("ohsicon_CSS");
			System.out.println("Clicked on the OHS icon of the Property.");
			ngDriver.waitForAngularRequestsToFinish();
			System.out.println("Navigate to the OHS screen of the perticular property.");

			driver.findElement(By.xpath(OR.getProperty("ohs_incident_30daystaskcounts_XPATH")));

			TestUtil.captureScreenshot();

			// ReportNG
			Reporter.log("<br>" + "The task's count is displayed incorrectly : " + "<br>");
			Reporter.log("<a target=\"_blank\" href=" + TestUtil.screenshotName + "><img src=" + TestUtil.screenshotName
					+ " height=200 width=200></img></a>");
			Reporter.log("<br>");
			Reporter.log("<br>");

			// Extent Report
			test.log(LogStatus.FAIL, " The task's count is displayed incorrectly : ");
			test.log(LogStatus.FAIL, test.addScreenCapture(TestUtil.screenshotName));

			System.out.println("The task's count is displayed incorrectly.");
			log.info("The task's count is displayed incorrectly.");

		} catch (Throwable t) {
			System.out.println("The task's count is displayed correctly.");
			test.log(LogStatus.INFO, "The task's count is displayed correctly.");
			Reporter.log("The task's count is displayed correctly.");
			log.info("The task's count is displayed correctly.");
		}

		// click on the home icon from the top of the screen
		click("questionnaire_homeburgermenubtn_hide_CSS");
		System.out.println("Clicked on the home icon from the top of the screen.");
		ngDriver.waitForAngularRequestsToFinish();

		// synchronization
		explicitWait("propertylist_title_XPATH");

		// verify the property list
		switchVerification("propertylist_title_XPATH", "Property List", "The property list is not displayed.");

		// DELETE THE INCIDENT REPORT

		System.out.println("**************** DELETE THE INCIDENT REPORT ****************");
		test.log(LogStatus.INFO, "**************** DELETE THE INCIDENT REPORT ****************");
		Reporter.log("**************** DELETE THE INCIDENT REPORT ****************");
		log.info("**************** DELETE THE INCIDENT REPORT ****************");

		try {

			// click on the OHS icon from the property list page
			click("ohsicon_CSS");
			System.out.println("Clicked on the OHS icon of the Property.");
			ngDriver.waitForAngularRequestsToFinish();
			System.out.println("Navigate to the OHS screen of the perticular property.");

			// wait for the element
			Thread.sleep(5000);

			// click on the burger menu
			click("menubtn_CSS");
			ngDriver.waitForAngularRequestsToFinish();
			System.out.println("Clicked on the burger menu button successfully!!!");

			// wait for the element
			Thread.sleep(5000);

			// click on the incident reports
			click("questionnaire_option_ohstab_incidentreports_XPATH");
			System.out.println("Clicked on the incident reports option.");
			ngDriver.waitForAngularRequestsToFinish();

			// wait for the element
			explicitWaitClickable("ohs_incident_search_clearbtn_XPATH");

			// click on the clear button
			click("ohs_incident_search_clearbtn_XPATH");
			ngDriver.waitForAngularRequestsToFinish();
			System.out.println("Clicked on the clear button.");

			// enter the newly created incident report in the search field
			type("ohs_incident_searchtxt_CSS", data.get("short_description"));
			System.out.println("Entered the newly created incident report in the search field.");
			ngDriver.waitForAngularRequestsToFinish();

			// click on the search button
			click("ohs_incident_search_searchbtn_CSS");
			ngDriver.waitForAngularRequestsToFinish();
			System.out.println("Clicked on the search button.");

			// verification of the incident report is added or not
			switchVerification("ohs_incident_addedincidentreport_taskcount2_XPATH",
					"Task Count Two Short Description for Testing Purpose",
					"The Task Count Two Short Description for Testing Purpose is not displayed successfully.");

			// click on the added incident report
			click("ohs_incident_addedincidentreport_taskcount2_XPATH");
			System.out.println("Clicked on the incident record for add the task.");
			ngDriver.waitForAngularRequestsToFinish();
			System.out.println("Naviagte to the Update Incident record Screen.");

			// click on the delete button for delete the incident report
			click("ohs_incident_deletebtn_CSS");
			System.out.println("Clicked on the delete button for delete the incident report.");
			ngDriver.waitForAngularRequestsToFinish();

			// click on the delete button of confirmation model for delete the incident
			// report
			click("ohs_incident_confirmdeletebtn_CSS");
			ngDriver.waitForAngularRequestsToFinish();
			System.out.println("Clicked on the delete button of confirmation model for delete the incident report.");

			// wait for the element
			explicitWaitClickable("ohs_incident_search_clearbtn_XPATH");

			// click on the clear button
			click("ohs_incident_search_clearbtn_XPATH");
			ngDriver.waitForAngularRequestsToFinish();
			System.out.println("Clicked on the clear button.");

			// enter the newly created incident report in the search field
			type("ohs_incident_searchtxt_CSS", data.get("short_description"));
			System.out.println("Entered the newly created incident report in the search field.");
			ngDriver.waitForAngularRequestsToFinish();

			// click on the search button
			click("ohs_incident_search_searchbtn_CSS");
			ngDriver.waitForAngularRequestsToFinish();
			System.out.println("Clicked on the search button.");

			helper.deleteVerification("ohs_incident_addedincidentreport_taskcount2_XPATH",
					"Task Count Two Short Description for Testing Purpose");

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

	}
}
