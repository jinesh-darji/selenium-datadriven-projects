package testcases.E2Etestcasesuite.ohsmodule;

import java.io.IOException;
import java.util.Hashtable;
import java.util.Random;

import org.apache.commons.lang3.RandomStringUtils;
import org.openqa.selenium.By;
import org.testng.annotations.Test;

import base.TestBase;
import utilities.TestUtil;

public class RR6575OHS1Test extends TestBase {

	@Test(dataProviderClass = TestUtil.class, dataProvider = "dp")
	public void rR6575OHS1Test(Hashtable<String, String> data) throws IOException, InterruptedException {

		execution(data, "rR6575OHS1Test");

		// VERIFY THE NEWLY ADDED COMMENTS OF THE INCIDENT REPORT DISPLAYED AT THE TOP
		// OF THE COMMENT LIST.
		title("VERIFY THE NEWLY ADDED COMMENTS OF THE INCIDENT REPORT DISPLAYED AT THE TOP OF THE COMMENT LIST.");

		// refresh the page
		driver.navigate().refresh();
		Thread.sleep(5000);
		driver.navigate().refresh();

		Random random = new Random();
		int count = random.nextInt(12 - 8) + 8;

		// ADD THE NEWLY INCIDENT REPORT
		title("ADD THE NEWLY INCIDENT REPORT");

		String describe_incident = RandomStringUtils.randomAlphabetic(8);

		try {

			// click on the OHS icon from the property list page
			click("ohsicon_CSS");

			// wait for the element
			explicitWaitClickable("menubtn_CSS");

			// click on the burger menu
			click("menubtn_CSS");

			// wait for the element
			Thread.sleep(5000);

			// click on the incident reports
			click("questionnaire_option_ohstab_incidentreports_XPATH");

			// ADD DETAILS IN THE INCIDENT REPORT TAB
			consoleMessage("ADD DETAILS IN THE INCIDENT REPORT TAB");

			// click on the add button
			click("ohs_incident_addbtn_CSS");

			// enter the incident time - hours
			type("ohs_incident_hourstxt_CSS", "11");

			// enter the incident time - minute
			type("ohs_incident_minutestxt_CSS", "20");

			// scroll down the screen
			scrollByPixel(500);

			// enter the short description
			type("ohs_incident_shortdescriptiontxt_CSS", describe_incident);

			// click on the add event type button
			click("ohs_incident_addeventtypebtn_CSS");

			// click on the event type dropdown
			select("ohs_incident_eventtypedd_CSS", data.get("event_type"));

			// click on the add button of the add event type record model
			click("ohs_incident_eventty_addbtn_CSS");

			// click on the next button
			click("ohs_incident_nextbtn_CSS");

			// NAVIGATED TO DETAILS, CAUSE TAB
			consoleMessage("NAVIGATED TO DETAILS, CAUSE TAB");

			// synchronization
			explicitWaitClickable("ohs_incident_nextbtn_CSS");

			// click on the next button
			click("ohs_incident_nextbtn_CSS");

			// NAVIGATED TO PERSONS INVOLVED TAB
			consoleMessage("NAVIGATED TO PERSONS INVOLVED TAB");

			// synchronization
			explicitWaitClickable("ohs_incident_nextbtn_CSS");

			// click on the next button
			click("ohs_incident_nextbtn_CSS");

			// NAVIGATED TO WITHNESS TAB
			consoleMessage("NAVIGATED TO WITHNESS TAB");

			// synchronization
			explicitWaitClickable("ohs_incident_nextbtn_CSS");

			// click on the next button
			click("ohs_incident_nextbtn_CSS");

			// NAVIGATED TO EMERGENCY SERVICE TAB
			consoleMessage("NAVIGATED TO EMERGENCY SERVICE TAB");

			// synchronization
			explicitWaitClickable("ohs_incident_nextbtn_CSS");

			// click on the next button
			click("ohs_incident_nextbtn_CSS");

			// NAVIGATED TO PROPERTY DAMAGE TAB
			consoleMessage("NAVIGATED TO PROPERTY DAMAGE TAB");

			// synchronization
			explicitWaitClickable("ohs_incident_nextbtn_CSS");

			// click on the next button
			click("ohs_incident_nextbtn_CSS");

			// NAVIGATED TO INSURANCE TAB
			consoleMessage("NAVIGATED TO INSURANCE TAB");

			// synchronization
			explicitWaitClickable("ohs_incident_nextbtn_CSS");

			// click on the next button
			click("ohs_incident_nextbtn_CSS");

			// NAVIGATED TO ATTACHMENTS TAB
			consoleMessage("NAVIGATED TO ATTACHMENTS TAB");

			// synchronization
			explicitWaitClickable("ohs_incident_updaterecordbtn_CSS");

			// click on the update record button
			click("ohs_incident_updaterecordbtn_CSS");

			// wait for the element
			explicitWaitClickable("ohs_incident_search_clearbtn_XPATH");

			// click on the clear button
			click("ohs_incident_search_clearbtn_XPATH");

			// enter the newly created incident report in the search field
			type("ohs_incident_searchtxt_CSS", describe_incident);

			// click on the search button
			click("ohs_incident_search_searchbtn_CSS");

			try {

				String describeincident_XPATH = "//td[text()='" + describe_incident + "']";
				String str2 = (driver.findElement(By.xpath(describeincident_XPATH)).getText()).trim();

				if (str2.equals(describe_incident)) {

					successMessage("The newly created incident report is verified successfully.");

				} else {
					verificationFailedMessage("The newly created incident report is not verified.");
				}

			} catch (Throwable t) {
				verificationFailedMessage("The newly created incident report is not verified.");
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

		// VALIDATE THE NEW IMPLENTATION OF COMMENT TAB
		title("VALIDATE THE NEW IMPLENTATION OF COMMENT TAB");

		try {

			// click on the OHS icon from the property list page
			click("ohsicon_CSS");

			// wait for the element
			explicitWaitClickable("menubtn_CSS");

			// click on the burger menu
			click("menubtn_CSS");

			// wait for the element
			Thread.sleep(5000);

			// click on the incident reports
			click("questionnaire_option_ohstab_incidentreports_XPATH");

			// click on the added incident report
			String describeincident_XPATH = "//td[text()='" + describe_incident + "']";
			driver.findElement(By.xpath(describeincident_XPATH)).click();
			consoleMessage("Clicked on the incident record for add the task.");

			// click on the notes and comments tab
			click("ohs_incident_notescommentstab_CSS");

			// add the random number of comment and validate the screen scroll down for each
			// newly added comment
			consoleMessage(
					"add the random number of comment and validate the screen scroll down for each newly added comment");

			for (int i = 0; i < count; i++) {

				// click on the add comment button
				click("task_addcommentbtn_CSS");

				// wait for the element
				explicitWaitClickable("propertyproject_mu_commenttxt_XPATH");

				// enter the comment
				String comment = RandomStringUtils.randomAlphabetic(8);
				type("propertyproject_mu_commenttxt_XPATH", comment);

				// click on the add button
				click("task_comment_addcommentbtn_CSS");

				// verify added comment is displayed or not
				try {
					String addedComment = "//p[text()='" + comment + "']";
					String str2 = (driver.findElement(By.xpath(addedComment)).getText()).trim();

					if (str2.equals(comment)) {

						successMessage("The newly created comment i.e. " + comment + "is verified successfully.");

					} else {
						verificationFailedMessage("The newly created comment i.e. " + comment + "is not verified.");
					}

				} catch (Throwable t) {
					verificationFailedMessage("The newly created comment i.e. " + comment + "is not verified.");
				}

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
			type("ohs_incident_searchtxt_CSS", describe_incident);

			// click on the search button
			click("ohs_incident_search_searchbtn_CSS");

			// verification of the incident report is added or not
			try {

				String describeincident1_XPATH = "//td[text()='" + describe_incident + "']";
				String str2 = (driver.findElement(By.xpath(describeincident1_XPATH)).getText()).trim();

				if (str2.equals(describe_incident)) {

					successMessage("The newly created incident report is verified successfully.");

				} else {
					verificationFailedMessage("The newly created incident report is not verified.");
				}

			} catch (Throwable t) {
				verificationFailedMessage("The newly created incident report is not verified.");
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

		// DELETE THE NEWLY CREATED INCIDENT REPORT
		title("DELETE THE NEWLY CREATED INCIDENT REPORT");

		try {

			// click on the OHS icon from the property list page
			click("ohsicon_CSS");

			// wait for the element
			explicitWaitClickable("menubtn_CSS");

			// click on the burger menu
			click("menubtn_CSS");

			// wait for the element
			Thread.sleep(5000);

			// click on the incident reports
			click("questionnaire_option_ohstab_incidentreports_XPATH");

			// click on the newly created incident report
			String describeincident1_XPATH = "//td[text()='" + describe_incident + "']";
			driver.findElement(By.xpath(describeincident1_XPATH)).click();
			consoleMessage("Clicked on the newly created incident report.");

			// wait for the element
			explicitWaitClickable("ohs_incident_deletebtn_CSS");

			// click on the delete button
			click("ohs_incident_deletebtn_CSS");

			// wait for the element
			explicitWaitClickable("ohs_incident_confirmdeletebtn_CSS");

			// click on the delete button of confirmation popup
			click("ohs_incident_confirmdeletebtn_CSS");

			// verify details are deleted or not
			try {

				String describeincident2_XPATH = "//td[text()='" + describe_incident + "']";
				String str2 = (driver.findElement(By.xpath(describeincident2_XPATH)).getText()).trim();

				if (str2.equals(describe_incident)) {
					verificationFailedMessage("The newly created incident report is not deleted.");

				} else {
					successMessage("The newly created incident report is deleted successfully.");
				}

			} catch (Throwable t) {
				successMessage("The newly created incident report is deleted successfully.");
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

	}
}
