package testcases.E2Etestcasesuite.ohsmodule;

import java.io.IOException;
import java.util.Hashtable;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.testng.Reporter;
import org.testng.SkipException;
import org.testng.annotations.Test;

import com.relevantcodes.extentreports.LogStatus;

import base.Helper;
import base.TestBase;
import utilities.TestUtil;

public class RR5255OHSTwoTest extends TestBase {

	@Test(dataProviderClass = TestUtil.class, dataProvider = "dp")
	public void rR5255OHSTwoTest(Hashtable<String, String> data) throws IOException, InterruptedException {

		execution(data, "rR5255OHSTwoTest");

		// SECURITY SETTING CONTROLS TO MAKE SURE THE ACCESS TO MODIFY EHS STATUS IN
		// INCIDENT REPORT CAN BE ONLY PERFORMED BY THE USER/ROLE WITH ACCESS TO IT.
		title("SECURITY SETTING CONTROLS TO MAKE SURE THE ACCESS TO MODIFY EHS STATUS IN INCIDENT REPORT CAN BE ONLY PERFORMED BY THE USER/ROLE WITH ACCESS TO IT.");

		Helper helper = new Helper();

		// refresh the page
		driver.navigate().refresh();
		Thread.sleep(5000);
		driver.navigate().refresh();

		// APPLY THE ACCESS TO INSURANCE DATA IN INCIDENT REPORT PERMISSION
		title("APPLY THE ACCESS TO INSURANCE DATA IN INCIDENT REPORT PERMISSION");

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

			// APPLY THE ACCESS TO MODIFY EHS STATUS IN INCIDENT REPORT PERMISSION
			helper.addPermissionOneUsersRole(data, "ohs_security_setting_1", "ohs_securitysettings22_XPATH");

			// APPLY THE ACCESS TO OHS INCIDENT REPORTS
			helper.addPermissionTwoUsersRole(data, "ohs_security_setting_2", "ohs_securitysettings2_XPATH");

		} catch (Throwable t) {
			verificationFailed();
		}

		// click on the home icon
		click("questionnaire_homeburgermenubtn_CSS");

		// wait for the element
		explicitWait("propertylist_title_XPATH");

		// verify the property list
		switchVerification("propertylist_title_XPATH", "Property List", "The property list is not displayed.");

		// ADD THE NEWLY INCIDENT REPORT
		title("ADD THE NEWLY INCIDENT REPORT");

		try {

			// click on the OHS icon from the property list page
			click("ohsicon_CSS");

			// click on the burger menu
			click("menubtn_CSS");

			// wait for the element
			explicitWaitClickable("questionnaire_option_ohstab_incidentreports_XPATH");

			// click on the incident reports
			click("questionnaire_option_ohstab_incidentreports_XPATH");

			// ADD DETAILS IN THE INCIDENT REPORT TAB
			title("ADD DETAILS IN THE INCIDENT REPORT TAB");

			// click on the add button
			click("ohs_incident_addbtn_CSS");

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

		} catch (Throwable t) {
			verificationFailed();
		}

		try {

			// click on the next button
			click("ohs_incident_nextbtn_CSS");

			// synchronization
			explicitWait("ohs_incident_nextbtn_CSS");
			consoleMessage("Navigate to the Details, Cause Tab.");

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

			// synchronization
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

			// click on the update record button
			click("ohs_incident_updaterecordbtn_CSS");

			// wait for the element
			explicitWaitClickable("ohs_incident_search_clearbtn_XPATH");

			// click on the clear button
			click("ohs_incident_search_clearbtn_XPATH");

			// enter the newly created incident report in the search field
			type("ohs_incident_searchtxt_CSS", data.get("describe_incident"));

			// click on the search button
			click("ohs_incident_search_searchbtn_CSS");

			// verification of the incident report is added or not
			switchVerification("ohs_incident_addedincidentreport22_XPATH",
					"Describe Incident Text SS Two Testing Purpose",
					"The Describe Incident Text SS Two Testing Purpose is not displayed successfully.");

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

			// wait for 5 seconds
			Thread.sleep(5000);

			// wait for the element
			explicitWaitClickable("questionnaire_settingicon_CSS");

			// click on the settings icon from the top of the screen
			click("questionnaire_settingicon_CSS");

			// wait for the element
			explicitWaitClickable("sidemenu_logout_CSS");

			// click on the logout option from the side menu
			click("sidemenu_logout_CSS");

			// VERIFY THE EHS Status field IS ACCESS IN JINESH USER OR NOT
			title("VERIFY THE EHS Status field IS ACCESS IN JINESH USER OR NOT");

			// LOGIN IN JINESH USER
			title("LOGIN IN JINESH USER");

			helper.loginAndUpdateSystemCompany(data, "username", "password", "system_company_1");

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
				type("ohs_incident_searchtxt_CSS", data.get("describe_incident"));

				// click on the search button
				click("ohs_incident_search_searchbtn_CSS");

				// verification of the incident report is added or not
				switchVerification("ohs_incident_addedincidentreport22_XPATH",
						"Describe Incident Text SS Two Testing Purpose",
						"The Describe Incident Text SS Two Testing Purpose is not displayed successfully.");

				// click on the incident report
				click("ohs_incident_addedincidentreport22_XPATH");

				try {
					boolean ss1 = driver.findElement(By.cssSelector(OR.getProperty("ohs_incident_ss_ehsstatustxt_CSS")))
							.isEnabled();

					if (ss1 == true) {
						successMessage("The EHS Status field is display enabled as expected.");
					} else {
						verificationFailedMessage("The EHS Status field is display disabled.");
					}
				} catch (Throwable t) {
					verificationFailedMessage("The EHS Status field is display disabled.");
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

			// wait for the element
			explicitWaitClickable("questionnaire_settingicon_CSS");

			// click on the settings icon from the top of the screen
			click("questionnaire_settingicon_CSS");

			// wait for the element
			explicitWaitClickable("sidemenu_logout_CSS");

			// click on the logout option from the side menu
			click("sidemenu_logout_CSS");

			// VERIFY EHS Status field ACCESS IN THE CONTRACTOR ROLE
			title("VERIFY EHS Status field ACCESS IN THE CONTRACTOR ROLE");

			// LOGIN IN JINESH CONTRACTOR USER
			title("LOGIN IN JINESH CONTRACTOR USER");

			helper.loginAndUpdateSystemCompany(data, "username_2", "password_2", "system_company_1");

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
				type("ohs_incident_searchtxt_CSS", data.get("describe_incident"));

				// click on the search button
				click("ohs_incident_search_searchbtn_CSS");

				// verification of the incident report is added or not
				switchVerification("ohs_incident_addedincidentreport22_XPATH",
						"Describe Incident Text SS Two Testing Purpose",
						"The Describe Incident Text SS Two Testing Purpose is not displayed successfully.");

				// click on the incident report
				click("ohs_incident_addedincidentreport22_XPATH");

				try {
					boolean ss2 = driver.findElement(By.cssSelector(OR.getProperty("ohs_incident_ss_ehsstatustxt_CSS")))
							.isEnabled();

					if (ss2 == true) {
						successMessage("The EHS Status field is display enabled as expected.");
					} else {
						verificationFailedMessage("The EHS Status field is display disabled.");
					}
				} catch (Throwable t) {
					verificationFailedMessage("The EHS Status field is display disabled.");
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

			// wait for the element
			explicitWaitClickable("questionnaire_settingicon_CSS");

			// click on the settings icon from the top of the screen
			click("questionnaire_settingicon_CSS");

			// wait for the element
			explicitWaitClickable("sidemenu_logout_CSS");

			// click on the logout option from the side menu
			click("sidemenu_logout_CSS");

			// VERIFY THE EHS Status field ACCESS IN THE JINESH HR
			title("VERIFY THE EHS Status field ACCESS IN THE JINESH HR");

			// LOGIN IN JINESH HR USER
			title("LOGIN IN JINESH HR USER");

			helper.loginAndUpdateSystemCompany(data, "username_3", "password_3", "system_company_1");

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
				type("ohs_incident_searchtxt_CSS", data.get("describe_incident"));

				// click on the search button
				click("ohs_incident_search_searchbtn_CSS");

				// verification of the incident report is added or not
				switchVerification("ohs_incident_addedincidentreport22_XPATH",
						"Describe Incident Text SS Two Testing Purpose",
						"The Describe Incident Text SS Two Testing Purpose is not displayed successfully.");

				// click on the incident report
				click("ohs_incident_addedincidentreport22_XPATH");

				try {
					boolean ss3 = driver.findElement(By.cssSelector(OR.getProperty("ohs_incident_ss_ehsstatustxt_CSS")))
							.isEnabled();

					if (ss3 == true) {
						verificationFailedMessage("The EHS Status field is display enabled without permission.");
					} else {
						successMessage("The EHS Status field is display disabled as expected.");
					}
				} catch (Throwable t) {
					successMessage("The EHS Status field is display disabled as expected.");
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

			// wait for the element
			explicitWaitClickable("questionnaire_settingicon_CSS");

			// click on the settings icon from the top of the screen
			click("questionnaire_settingicon_CSS");

			// wait for the element
			explicitWaitClickable("sidemenu_logout_CSS");

			// click on the logout option from the side menu
			click("sidemenu_logout_CSS");

			// DELETE THE CREATED MORTGAGE UNDERTAKING AND RESET THE GIVEN PERMISSIONS
			title("DELETE THE CREATED MORTGAGE UNDERTAKING AND RESET THE GIVEN PERMISSIONS");

			// LOGIN IN AUTOMATION TESTER USER
			title("LOGIN IN AUTOMATION TESTER USER");

			helper.loginAndUpdateSystemCompany(data, "username_1", "password_1", "system_company_1");

		} catch (Throwable t) {
			helper.questionnaireNotDisplayLogout(data);
		}

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
			type("ohs_incident_searchtxt_CSS", data.get("describe_incident"));

			// click on the search button
			click("ohs_incident_search_searchbtn_CSS");

			// verification of the incident report is added or not
			switchVerification("ohs_incident_addedincidentreport22_XPATH",
					"Describe Incident Text SS Two Testing Purpose",
					"The Describe Incident Text SS Two Testing Purpose is not displayed successfully.");

			// click on the incident report
			click("ohs_incident_addedincidentreport22_XPATH");

			// click on the delete button
			click("ohs_incident_deletebtn_CSS");

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
			helper.deleteVerification("ohs_incident_addedincidentreport22_XPATH",
					"Describe Incident Text SS Two Testing Purpose");

		} catch (Throwable t) {
			verificationFailed();
		}

		// click on the home icon from the top of the screen
		click("questionnaire_homeburgermenubtn_hide_CSS");

		// wait for the element
		explicitWait("propertylist_title_XPATH");

		// verify the property list
		switchVerification("propertylist_title_XPATH", "Property List", "The property list is not displayed.");

		// RESET THE APPLIED PERMISSIONS
		title("RESET THE APPLIED PERMISSIONS");

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

			// RESET THE ACCESS TO INSURANCE DATA IN INCIDENT REPORT PERMISSION
			helper.resetPermission(data, "ohs_security_setting_1", "ohs_securitysettings22_XPATH");

			// RESET THE ACCESS TO OHS INCIDENT REPORTS PERMISSION
			helper.resetPermission(data, "ohs_security_setting_2", "ohs_securitysettings2_XPATH");

		} catch (Throwable t) {
			verificationFailed();
		}

		// click on the home icon
		click("questionnaire_homeburgermenubtn_CSS");

		// wait for the element
		explicitWait("propertylist_title_XPATH");

		// verify the property list
		switchVerification("propertylist_title_XPATH", "Property List", "The property list is not displayed.");

	}
}
