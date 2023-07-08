package testcases.smokesuite;

import java.io.IOException;
import java.time.LocalDate;
import java.util.Date;
import java.util.Hashtable;

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

public class RR5753ClientIssue2Test extends TestBase {

	@Test(dataProviderClass = TestUtil.class, dataProvider = "dp")
	public void rR5753ClientIssue2Test(Hashtable<String, String> data) throws IOException, InterruptedException {

		execution(data, "rR5753ClientIssue2Test");

		Helper helper = new Helper();

		// refresh the page
		driver.navigate().refresh();
		Thread.sleep(5000);
		driver.navigate().refresh();

		// MOVE BUTTON SHOULDN'T BE AVAILABLE IN INCIDENT PORTAL REGARDLESS OF
		// PERMISSION - RR-5621
		title("MOVE BUTTON SHOULDN'T BE AVAILABLE IN INCIDENT PORTAL REGARDLESS OF PERMISSION - RR-5621");

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

		// CREATE A NEW INCIDENT REPORT
		title("CREATE A NEW INCIDENT REPORT");

		try {

			// enter the property name in the search field
			type("envreports_propertylist_filtertxt_CSS", data.get("property_2"));

			// click on the OHS icon from the property list page
			click("ohsicon_CSS");

			// wait for the element
			Thread.sleep(5000);

			// click on the burger menu
			click("menubtn_CSS");

			// wait for the element
			Thread.sleep(5000);

			// click on the incident reports
			click("questionnaire_option_ohstab_incidentreports_XPATH");

			// ADD DETAILS IN THE INCIDENT REPORT TAB
			title("ADD DETAILS IN THE INCIDENT REPORT TAB");

			// click on the add button
			click("ohs_incident_addbtn_CSS");

			// wait for the element
			Thread.sleep(7000);

			// enter the incident time - hours

			type("ohs_incident_hourstxt_CSS", "11");

			// enter the incident time - minute

			type("ohs_incident_minutestxt_CSS", "20");

			// scroll down the screen

			scrollByPixel(500);

			// enter the short description
			type("ohs_incident_shortdescriptiontxt_CSS", data.get("describe_incident"));

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

			consoleMessage("Navigate to the Details, Cause Tab..");

			// click on the next button
			click("ohs_incident_nextbtn_CSS");

			// synchronization
			explicitWait("ohs_incident_personsinvolved_addbtn_CSS");

			consoleMessage("Navigate to the Persons Involved Tab.");

			// click on the next button
			click("ohs_incident_nextbtn_CSS");

			// synchronization
			explicitWait("ohs_incident_nextbtn_CSS");

			consoleMessage("Navigate to the Witnesses Tab.");

			// click on the next button
			click("ohs_incident_nextbtn_CSS");

			explicitWait("ohs_incident_nextbtn_CSS");

			consoleMessage("Navigate to the emergency services Tab.");

			// click on the next button
			click("ohs_incident_nextbtn_CSS");

			// synchronization
			explicitWait("ohs_incident_nextbtn_CSS");

			consoleMessage("Navigate to the property damage Tab.");

			// click on the next button
			click("ohs_incident_nextbtn_CSS");

			// synchronization
			explicitWait("ohs_incident_nextbtn_CSS");

			consoleMessage("Navigate to the insurance Tab.");

			// click on the next button
			click("ohs_incident_nextbtn_CSS");

			// synchronization
			explicitWait("ohs_incident_updaterecordbtn_CSS");

			consoleMessage("Navigate to the attachments Tab.");

			// wait for the element
			Thread.sleep(7000);

			// click on the update record button
			click("ohs_incident_updaterecordbtn_CSS");

		} catch (Throwable t) {
			verificationFailed();
		}

		try {
			// wait for the element
			explicitWaitClickable("ohs_incident_search_clearbtn_XPATH");

			// click on the clear button
			click("ohs_incident_search_clearbtn_XPATH");

			// enter the newly created incident report in the search field
			type("ohs_incident_searchtxt_CSS", data.get("describe_incident"));

			// click on the search button
			click("ohs_incident_search_searchbtn_CSS");

			// verification of the incident report is added or not
			switchVerification("ohs_incident_addedincidentreport_clientissue2_XPATH",
					"Clientissue2 Describe Incident Text Testing Purpose",
					"The Clientissue2 Describe Incident Text Testing Purpose is not displayed successfully.");

		} catch (Throwable t) {
			verificationFailed();
		}

		// click on the home icon from the top of the screen
		click("questionnaire_homeburgermenubtn_hide_CSS");

		// synchronization
		explicitWait("propertylist_title_XPATH");

		// verify the property list
		switchVerification("propertylist_title_XPATH", "Property List", "The property list is not displayed.");

		// VALIDATE THE MOVE BUTTON IS DISPLAYED IN THE INCIDENT REPORTS WHEN PERMISSION
		// IS GRANTED
		title("VALIDATE THE MOVE BUTTON IS DISPLAYED IN THE INCIDENT REPORTS WHEN PERMISSION IS GRANTED");

		try {

			// enter the property name in the search field
			type("envreports_propertylist_filtertxt_CSS", data.get("property_2"));

			// click on the OHS icon from the property list page
			click("ohsicon_CSS");

			// wait for the element
			Thread.sleep(5000);

			// click on the burger menu
			click("menubtn_CSS");

			// wait for the element
			Thread.sleep(5000);

			// click on the incident reports
			click("questionnaire_option_ohstab_incidentreports_XPATH");

			// enter the newly created incident report in the search field

			type("ohs_incident_searchtxt_CSS", data.get("describe_incident"));

			// verify move button is displayed or not
			try {
				boolean movebtn1 = driver.findElement(By.cssSelector(OR.getProperty("ohs_incident_movebtn_CSS")))
						.isDisplayed();
				if (movebtn1 == true) {
					successMessage("THE MOVE BUTTON IS DISPLAYED AS EXPECTED.");
				} else {

					verificationFailedMessage("THE MOVE BUTTON IS NOT DISPLAYED.");
				}
			} catch (Throwable t) {
				verificationFailedMessage("THE MOVE BUTTON IS NOT DISPLAYED.");
			}

			// verify the checkbox for move incident report
			try {
				String moveCheckbox_XPATH = "//td[text()='" + data.get("describe_incident")
						+ "']//preceding-sibling::td//input[@ng-click='selectRecordToMove(record)']";

				boolean moveCheckbox = driver.findElement(By.xpath(moveCheckbox_XPATH)).isDisplayed();

				if (moveCheckbox == true) {
					successMessage("THE CHECKBOX FOR THE MOVE INCIDENT REPORT IS DISPLAYED SUCCESSFULLY.");
				} else {
					verificationFailedMessage("THE CHECKBOX FOR THE MOVE INCIDENT REPORT IS NOT DISPLAYED.");
				}
			} catch (Throwable t) {
				verificationFailedMessage("THE CHECKBOX FOR THE MOVE INCIDENT REPORT IS NOT DISPLAYED.");
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

		// UPDATE THE SESURITY SETTINGS OF THE MOVE BUTTON OF INCIDENT REPORT
		title("UPDATE THE SESURITY SETTINGS OF THE MOVE BUTTON OF INCIDENT REPORT");

		try {
			// wait for the element
			explicitWaitClickable("questionnaire_settingicon_CSS");

			// click on the settings icon from the top of the screen
			click("questionnaire_settingicon_CSS");

			// wait for the element
			Thread.sleep(5000);

			// click on the Administration option from the side menu
			click("questionnaire_administrationoption_XPATH");

			// wait for the element
			Thread.sleep(5000);

			// click on the security tab
			click("questionnaire_securitytab_XPATH");

			// click on the security settings option
			click("questionnaire_securotysettingsoption_XPATH");

			// enter security setting name in the search field

			type("propertyproject_le_filtertxt_CSS", data.get("permission_1"));

			// click on the searched result
			click("administration_securitysettings_accessincidentreport_XPATH");

			// click on the select role field
			click("propertyproject_securitysettings1_selectroles_CSS");

			// click on the none button
			click("propertyproject_securitysettings1_nonebtn_CSS");

			// enter the name of the role in search field

			type("propertyproject_securitysettings1_searchtxt_CSS", data.get("role_1"));

			// click on the searched result
			click("propertyproject_securitysettings1_searchedpm1_XPATH");

			// click on the select role field
			click("propertyproject_securitysettings1_selectroles_CSS");

			// click on the save button
			click("propertyproject_securitysettings1_savebtn_CSS");

			// wait for the element
			explicitWaitClickable("closetoastmsg_CSS");

			// click on the toaster close button
			click("closetoastmsg_CSS");

			// enter security setting name in the search field

			type("propertyproject_le_filtertxt_CSS", data.get("permission_2"));

			// click on the searched result
			click("administration_securitysettings_moveincidentreport_XPATH");

			// click on the select role field
			click("propertyproject_securitysettings1_selectroles_CSS");

			// click on the none button
			click("propertyproject_securitysettings1_nonebtn_CSS");

			// click on the select role field
			click("propertyproject_securitysettings1_selectroles_CSS");

			// click on the select user field
			click("propertyproject_securitysettings1_selectusers_CSS");

			// click on the none button
			click("propertyproject_securitysettings1_nonebtn_CSS");

			// click on the select user field
			click("propertyproject_securitysettings1_selectusers_CSS");

			// click on the save button
			click("propertyproject_securitysettings1_savebtn_CSS");

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
			// wait for the 5 seconds
			Thread.sleep(5000);

			// click on the settings icon from the top of the screen
			click("questionnaire_settingicon_CSS");

			// wait for the element
			explicitWaitClickable("sidemenu_logout_CSS");

			// click on the logout option from the side menu
			click("sidemenu_logout_CSS");

			// wait for the element
			explicitWaitClickable("signinbtn_BTNTEXT");

			// Enter the username
			type("usernametxt_CSS", data.get("username"));

			// Enter the password
			type("passwordtxt_CSS", data.get("password"));

			// Clicking on the "Sign In" button
			click("signinbtn_BTNTEXT");

			// wait for the element
			explicitWait("propertylist_title_XPATH");

			// verify the property list
			switchVerification("propertylist_title_XPATH", "Property List", "The property list is not displayed.");

			// UPDATE THE SYSTEM COMPANY
			updateCompany(data);

			// VALIDATE THE MOVE BUTTON IS DISPLAYED IN THE INCIDENT REPORTS WHEN PERMISSION
			// IS NOT GRANTED
			title("VALIDATE THE MOVE BUTTON IS DISPLAYED IN THE INCIDENT REPORTS WHEN PERMISSION IS NOT GRANTED");

			try {

				// enter the property name in the search field
				type("envreports_propertylist_filtertxt_CSS", data.get("property_2"));

				// click on the OHS icon from the property list page
				click("ohsicon_CSS");

				// wait for the element
				Thread.sleep(5000);

				// click on the burger menu
				click("menubtn_CSS");

				// wait for the element
				Thread.sleep(5000);

				// click on the incident reports
				click("questionnaire_option_ohstab_incidentreports_XPATH");

				// enter the newly created incident report in the search field

				type("ohs_incident_searchtxt_CSS", data.get("describe_incident"));

				// verify move button is displayed or not
				try {
					boolean movebtn1 = driver.findElement(By.xpath(OR.getProperty("ohs_incident_movebtn_CSS")))
							.isDisplayed();
					if (movebtn1 == true) {

						verificationFailedMessage("THE MOVE BUTTON IS DISPLAYED WITHOUT PERMISSION.");
					} else {
						successMessage("THE MOVE BUTTON IS NOT DISPLAYED AS EXPECTED.");
					}
				} catch (Throwable t) {
					successMessage("THE MOVE BUTTON IS NOT DISPLAYED AS EXPECTED.");
				}

				// verify the checkbox for move incident report
				try {
					String moveCheckbox_XPATH = "//td[text()='" + data.get("describe_incident")
							+ "']//preceding-sibling::td//input[@ng-click='selectRecordToMove(record)']";

					boolean moveCheckbox = driver.findElement(By.xpath(moveCheckbox_XPATH)).isDisplayed();

					if (moveCheckbox == true) {

						verificationFailedMessage("THE CHECKBOX FOR THE MOVE INCIDENT REPORT IS DISPLAYED.");
					} else {
						successMessage("THE CHECKBOX FOR THE MOVE INCIDENT REPORT IS NOT DISPLAYED AS EXPECTED.");
					}
				} catch (Throwable t) {
					successMessage("THE CHECKBOX FOR THE MOVE INCIDENT REPORT IS NOT DISPLAYED AS EXPECTED.");
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

			// wait for the 5 seconds
			Thread.sleep(5000);

			// click on the settings icon from the top of the screen
			click("questionnaire_settingicon_CSS");

			// wait for the element
			explicitWaitClickable("sidemenu_logout_CSS");

			// click on the logout option from the side menu
			click("sidemenu_logout_CSS");

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
			helper.questionnaireNotDisplayLogout(data);
		}

		// RESET THE SESURITY SETTINGS OF THE MOVE BUTTON OF INCIDENT REPORT
		title("RESET THE SESURITY SETTINGS OF THE MOVE BUTTON OF INCIDENT REPORT");

		try {
			// wait for the element
			explicitWaitClickable("questionnaire_settingicon_CSS");

			// click on the settings icon from the top of the screen
			click("questionnaire_settingicon_CSS");

			// wait for the element
			explicitWaitClickable("questionnaire_administrationoption_XPATH");

			// click on the Administration option from the side menu
			click("questionnaire_administrationoption_XPATH");

			// click on the security tab
			click("questionnaire_securitytab_XPATH");

			// click on the security settings option
			click("questionnaire_securotysettingsoption_XPATH");

			// enter security setting name in the search field

			type("propertyproject_le_filtertxt_CSS", data.get("permission_1"));

			// click on the searched result
			click("administration_securitysettings_accessincidentreport_XPATH");

			// click on the select role field
			click("propertyproject_securitysettings1_selectroles_CSS");

			// click on the none button
			click("propertyproject_securitysettings1_nonebtn_CSS");

			// click on the select role field
			click("propertyproject_securitysettings1_selectroles_CSS");

			// click on the select user field
			click("propertyproject_securitysettings1_selectusers_CSS");

			// click on the none button
			click("propertyproject_securitysettings1_nonebtn_CSS");

			// click on the select user field
			click("propertyproject_securitysettings1_selectusers_CSS");

			// click on the save button
			click("propertyproject_securitysettings1_savebtn_CSS");

			// wait for the element
			explicitWaitClickable("closetoastmsg_CSS");

			// click on the toaster close button
			click("closetoastmsg_CSS");

			// enter security setting name in the search field

			type("propertyproject_le_filtertxt_CSS", data.get("permission_2"));

			// click on the searched result
			click("administration_securitysettings_moveincidentreport_XPATH");

			// click on the select role field
			click("propertyproject_securitysettings1_selectroles_CSS");

			// click on the none button
			click("propertyproject_securitysettings1_nonebtn_CSS");

			// click on the select role field
			click("propertyproject_securitysettings1_selectroles_CSS");

			// click on the select user field
			click("propertyproject_securitysettings1_selectusers_CSS");

			// click on the none button
			click("propertyproject_securitysettings1_nonebtn_CSS");

			// click on the select user field
			click("propertyproject_securitysettings1_selectusers_CSS");

			// click on the save button
			click("propertyproject_securitysettings1_savebtn_CSS");

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

		// DELETE DETAILS IN THE INCIDENT REPORT
		title("DELETE DETAILS IN THE INCIDENT REPORT");

		try {

			// enter the property name in the search field
			type("envreports_propertylist_filtertxt_CSS", data.get("property_2"));

			// click on the OHS icon from the property list page
			click("ohsicon_CSS");

			// wait for the element
			Thread.sleep(5000);

			// click on the burger menu
			click("menubtn_CSS");

			// wait for the element
			Thread.sleep(5000);

			// click on the incident reports
			click("questionnaire_option_ohstab_incidentreports_XPATH");

			// wait for the element
			explicitWaitClickable("ohs_incident_search_clearbtn_XPATH");

			// click on the clear button
			click("ohs_incident_search_clearbtn_XPATH");

			// enter the newly created incident report in the search field
			type("ohs_incident_searchtxt_CSS", data.get("describe_incident"));

			// click on the search button
			click("ohs_incident_search_searchbtn_CSS");

			// click on the incident report
			click("ohs_incident_addedincidentreport_clientissue2_XPATH");

			// wait for the element
			explicitWaitClickable("ohs_incident_deletebtn_CSS");

			// click on the delete button
			click("ohs_incident_deletebtn_CSS");

			// wait for the element
			explicitWaitClickable("ohs_incident_confirmdeletebtn_CSS");

			// click on the delete button of confirmation popup
			click("ohs_incident_confirmdeletebtn_CSS");

			// wait for the element
			explicitWaitClickable("ohs_incident_search_clearbtn_XPATH");

			// click on the clear button
			click("ohs_incident_search_clearbtn_XPATH");

			// enter the newly created incident report in the search field

			type("ohs_incident_searchtxt_CSS", data.get("describe_incident"));

			// click on the search button
			click("ohs_incident_search_searchbtn_CSS");

			// verify details are deleted or not
			deleteVerification("ohs_incident_addedincidentreport_clientissue2_XPATH",
					"Clientissue2 Describe Incident Text Testing Purpose");

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