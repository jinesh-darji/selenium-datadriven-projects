package testcases.E2Etestcasesuite.ohsmodule;

import java.io.IOException;
import java.util.Hashtable;
import java.util.List;
import java.util.Random;

import javax.swing.border.TitledBorder;

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

public class RR5138OHSOneTest extends TestBase {

	@Test(dataProviderClass = TestUtil.class, dataProvider = "dp")
	public void rR5138OHSOneTest(Hashtable<String, String> data) throws IOException, InterruptedException {

		execution(data, "rR5138OHSOneTest");

		// NUMBER OF TASKS ON THE OHS PROPERTY LANDING PAGE. (WHICH ARE DUE IN 30 DAYS)

		// NOTE: 1. NEED RECOMMENDATAION CREATED FOR CREATE THE NEW TASK. THE
		// RECOMMENDATAION IS CREATED FROM THE TASK TYPE DASHBOARD.
		title("NUMBER OF TASKS ON THE OHS PROPERTY LANDING PAGE. (WHICH ARE DUE IN 30 DAYS)");

		Helper helper = new Helper();

		// refresh the page
		driver.navigate().refresh();
		Thread.sleep(5000);
		driver.navigate().refresh();

		// DELETE THE PREVIOUSLY CREATED INCIDENT REPORT
		title("DELETE THE PREVIOUSLY CREATED INCIDENT REPORT");

		try {

			// click on the OHS icon from the property list page
			click("ohsicon_CSS");

			// click on the burger menu
			click("menubtn_CSS");

			// wait for the element
			explicitWaitClickable("questionnaire_option_ohstab_incidentreports_XPATH");

			// click on the incident reports
			click("questionnaire_option_ohstab_incidentreports_XPATH");

			// click on the delete button of the incident report
			List<WebElement> links3 = driver.findElements(By.xpath(OR.getProperty("ohs_incident_incidentlist_XPATH")));
			int count3 = links3.size();
			consoleMessage("Number of incident report are:" + count3);

			for (int i = 0; i < count3 - 1; i++) {

				// click on repair randomly
				List<WebElement> links33 = driver
						.findElements(By.xpath(OR.getProperty("ohs_incident_incidentlistbody_XPATH")));
				int count33 = links33.size();
				consoleMessage("Remaining incident report after deleted the incident report recod: " + count33);

				Random r = new Random();
				links33.get(r.nextInt(count33)).click();

				// wait for the element
				explicitWaitClickable("ohs_incident_deletebtn_CSS");

				// click on the delete button for delete the incident report
				click("ohs_incident_deletebtn_CSS");

				// wait for the element
				explicitWaitClickable("ohs_incident_confirmdeletebtn_CSS");

				// click on the delete button of confirmation model for delete the incident
				// report
				click("ohs_incident_confirmdeletebtn_CSS");
			}
		} catch (Throwable t) {
			verificationFailed();
		}

		// wait for the element
		explicitWaitClickable("questionnaire_homeburgermenubtn_hide_CSS");

		// click on the home icon from the top of the screen
		click("questionnaire_homeburgermenubtn_hide_CSS");

		// synchronization
		explicitWait("propertylist_title_XPATH");

		// verify the property list
		switchVerification("propertylist_title_XPATH", "Property List", "The property list is not displayed.");

		// ADD RECORD - INCIDENT REPORT
		consoleMessage("ADD RECORD - INCIDENT REPORT");

		try {
			// click on the OHS icon from the property list page
			click("ohsicon_CSS");

			// click on the burger menu
			click("menubtn_CSS");

			// wait for the element
			explicitWaitClickable("questionnaire_option_ohstab_incidentreports_XPATH");

			// click on the incident reports
			click("questionnaire_option_ohstab_incidentreports_XPATH");

			// click on the add button
			click("ohs_incident_addbtn_CSS");

			// wait for the element
			Thread.sleep(5000);

			// enter the incident time - hours
			type("ohs_incident_hourstxt_CSS", "11");

			// enter the incident time - minute
			type("ohs_incident_minutestxt_CSS", "20");

			// scroll down the screen
			scrollByPixel(500);

			// enter the short description
			type("ohs_incident_shortdescriptiontxt_CSS", data.get("short_description"));

			// click on the add event type button
			click("ohs_incident_addeventtypebtn_CSS");

			// click on the event type dropdown
			select("ohs_incident_eventtypedd_CSS", data.get("event_type"));

			// click on the add button of the add event type record model
			click("ohs_incident_eventty_addbtn_CSS");

			// click on the next button
			click("ohs_incident_nextbtn_CSS");

			// synchronization
			explicitWait("ohs_incident_nextbtn_CSS");
			consoleMessage("Navigate to the Details, Cause Tab.");

			// click on the next button
			click("ohs_incident_nextbtn_CSS");

			// synchronization
			explicitWait("ohs_incident_nextbtn_CSS");
			consoleMessage("Navigate to the Persons Involved Tab.");

			// click on the next button
			click("ohs_incident_nextbtn_CSS");

			// synchronization
			explicitWait("ohs_incident_nextbtn_CSS");
			consoleMessage("Navigate to the Witnesses Tab.");

			// click on the next button
			click("ohs_incident_nextbtn_CSS");

			// synchronization
			explicitWait("ohs_incident_nextbtn_CSS");
			consoleMessage("Navigate to the Emergency Services Tab.");

			// click on the next button
			click("ohs_incident_nextbtn_CSS");

			// synchronization
			explicitWait("ohs_incident_nextbtn_CSS");
			consoleMessage("Navigate to the Property Damage Tab.");

			// click on the next button
			click("ohs_incident_nextbtn_CSS");

			// synchronization
			explicitWait("ohs_incident_nextbtn_CSS");
			consoleMessage("Navigate to the Insurance Tab.");

			// click on the next button
			click("ohs_incident_nextbtn_CSS");

			// synchronization
			explicitWait("ohs_incident_updaterecordbtn_CSS");
			consoleMessage("Navigate to the Attachments Tab.");

			// click on the update record button
			click("ohs_incident_updaterecordbtn_CSS");

			// wait for the element
			explicitWaitClickable("ohs_incident_search_clearbtn_XPATH");

			// click on the clear button
			click("ohs_incident_search_clearbtn_XPATH");

			// enter the newly created incident report in the search field
			type("ohs_incident_searchtxt_CSS", data.get("short_description"));

			// click on the search button
			click("ohs_incident_search_searchbtn_CSS");

			// verification of the incident report is added or not
			switchVerification("ohs_incident_addedincidentreport_taskcount_XPATH",
					"Task Count Short Description for Testing Purpose",
					"The Task Count Short Description for Testing Purpose is not displayed successfully.");

		} catch (Throwable t) {
			verificationFailed();
		}

		Random random = new Random();
		int task1 = random.nextInt(5 - 1) + 1;
		consoleMessage("Task's Count in incident report: " + task1);

		try {
			// click on the added incident report
			click("ohs_incident_addedincidentreport_taskcount_XPATH");

			// CREATE THE RANDOM TASKS IN THE INCIDENT REPORT
			title("CREATE THE RANDOM TASKS IN THE INCIDENT REPORT");

			for (int i = 1; i <= task1; i++) {

				// ADD THE TASK
				title("ADD THE TASK");

				// click on the task tab
				click("ohs_incident_tasktab_CSS");

				// click on the add task button
				click("ohs_incident_tasktab_addbtn_CSS");

				// scroll down the screen
				scrollByPixel(500);

				// generate the random string for task title
				String tasktitle1 = RandomStringUtils.randomAlphabetic(8);

				// enter the data in the task title field
				type("task_addtask_titletxt_CSS", tasktitle1);

				// enter the data in the task location field
				type("task_addtask_locationtxt_CSS", data.get("task_location"));

				// click on the assign to field
				click("task_assigntotxt_CSS");

				// click on the none button
				click("task_tasktag_nonebtn_CSS");

				// enter the user name in the search field
				type("workflowsecurity_editortask_taskdetails_searchtasktagtxt_CSS", data.get("search_user"));

				// click on the searched result
				click("questionnaire_createtask_selectusertxt_XPATH");

				// click on the assign to field
				click("task_assigntotxt_CSS");

				// click on the save button
				click("ohs_incident_tasktab_addtaskbtn_CSS");

			}

			// click on the incident summary
			click("ohs_incident_incidentsummarytab_CSS");

			// click on the update button
			click("ohs_incident_updatebtn_XPATH");

			// wait for the element
			explicitWaitClickable("closetoastmsg_CSS");

			// click on the toaster close button
			click("closetoastmsg_CSS");

			// click on the cancel button
			click("ohs_incident_cancelbtn1_XPATH");

			// wait for the element
			explicitWaitClickable("ohs_incident_search_clearbtn_XPATH");

			// click on the clear button
			click("ohs_incident_search_clearbtn_XPATH");

			// enter the newly created incident report in the search field
			type("ohs_incident_searchtxt_CSS", data.get("short_description"));

			// click on the search button
			click("ohs_incident_search_searchbtn_CSS");

			// verification of the incident report is added or not
			switchVerification("ohs_incident_addedincidentreport_taskcount_XPATH",
					"Task Count Short Description for Testing Purpose",
					"The Task Count Short Description for Testing Purpose is not displayed successfully.");

		} catch (Throwable t) {
			verificationFailed();
		}

		// click on the home icon from the top of the screen
		click("questionnaire_homeburgermenubtn_hide_CSS");

		// synchronization
		explicitWait("propertylist_title_XPATH");

		// verify the property list
		switchVerification("propertylist_title_XPATH", "Property List", "The property list is not displayed.");

		// VERIFY THE NEWLY CREATED TASK'S COUNT ON OHS PROPERTY SUMMARY SCREEN
		title("VERIFY THE NEWLY CREATED TASK'S COUNT ON OHS PROPERTY SUMMARY SCREEN");

		try {
			// click on the OHS icon from the property list page
			click("ohsicon_CSS");

			String thirtydaystaskcount = driver
					.findElement(By.xpath(OR.getProperty("ohs_incident_30daystaskcounts_XPATH"))).getText();
			String stringtask1 = String.valueOf(task1);

			if (thirtydaystaskcount.equals(stringtask1)) {
				successMessage("The task's count is displayed correctly.");

			} else {
				verificationFailedMessage("The task's count is displayed incorrectly");
			}
		} catch (Throwable t) {
			verificationFailedMessage("The task's count is displayed incorrectly");
		}

		// click on the home icon from the top of the screen
		click("questionnaire_homeburgermenubtn_hide_CSS");

		// synchronization
		explicitWait("propertylist_title_XPATH");

		// verify the property list
		switchVerification("propertylist_title_XPATH", "Property List", "The property list is not displayed.");

		// DELETE THE INCIDENT REPORT
		title("DELETE THE INCIDENT REPORT");

		try {
			// click on the OHS icon from the property list page
			click("ohsicon_CSS");

			// click on the burger menu
			click("menubtn_CSS");

			// wait for the element
			explicitWaitClickable("questionnaire_option_ohstab_incidentreports_XPATH");

			// click on the incident reports
			click("questionnaire_option_ohstab_incidentreports_XPATH");

			// wait for the element
			explicitWaitClickable("ohs_incident_search_clearbtn_XPATH");

			// click on the clear button
			click("ohs_incident_search_clearbtn_XPATH");

			// enter the newly created incident report in the search field
			type("ohs_incident_searchtxt_CSS", data.get("short_description"));

			// click on the search button
			click("ohs_incident_search_searchbtn_CSS");

			// verification of the incident report is added or not
			switchVerification("ohs_incident_addedincidentreport_taskcount_XPATH",
					"Task Count Short Description for Testing Purpose",
					"The Task Count Short Description for Testing Purpose is not displayed successfully.");

			// click on the added incident report
			click("ohs_incident_addedincidentreport_taskcount_XPATH");

			// click on the delete button for delete the incident report
			click("ohs_incident_deletebtn_CSS");

			// click on the delete button of confirmation model for delete the incident
			// report
			click("ohs_incident_confirmdeletebtn_CSS");

			// wait for the element
			explicitWaitClickable("ohs_incident_search_clearbtn_XPATH");

			// click on the clear button
			click("ohs_incident_search_clearbtn_XPATH");

			// enter the newly created incident report in the search field
			type("ohs_incident_searchtxt_CSS", data.get("short_description"));

			// click on the search button
			click("ohs_incident_search_searchbtn_CSS");

			helper.deleteVerification("ohs_incident_addedincidentreport_taskcount_XPATH",
					"Task Count Short Description for Testing Purpose");

		} catch (Throwable t) {
			verificationFailed();
		}

		// click on the home icon from the top of the screen
		click("questionnaire_homeburgermenubtn_hide_CSS");

		// synchronization
		explicitWait("propertylist_title_XPATH");

		// verify the property list
		switchVerification("propertylist_title_XPATH", "Property List", "The property list is not displayed.");

		try {
			// click on the OHS icon from the property list page
			click("ohsicon_CSS");

			String thirtydaystaskcount1 = driver
					.findElement(By.xpath(OR.getProperty("ohs_incident_30daystaskcounts_XPATH"))).getText();
			String stringtask1 = String.valueOf(task1);

			if (thirtydaystaskcount1.equals(stringtask1)) {
				verificationFailedMessage("The task's count is displayed after deleted the incident report.");
			}
		} catch (Throwable t) {
			successMessage("The task's count is not displayed as expected.");

		}

		// click on the home icon from the top of the screen
		click("questionnaire_homeburgermenubtn_hide_CSS");

		// synchronization
		explicitWait("propertylist_title_XPATH");

		// verify the property list
		switchVerification("propertylist_title_XPATH", "Property List", "The property list is not displayed.");

	}
}
