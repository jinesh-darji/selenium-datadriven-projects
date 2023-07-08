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

public class RR5255OHSEightTest extends TestBase {

	@Test(dataProviderClass = TestUtil.class, dataProvider = "dp")
	public void rR5255OHSEightTest(Hashtable<String, String> data) throws IOException, InterruptedException {

		execution(data, "rR5255OHSEightTest");

		// SECURITY SETTING CONTROLS TO MAKE SURE THE OHS PRIVATE INFORMATION CAN BE
		// ONLY PERFORMED BY THE USER/ROLE WITH ACCESS TO IT.
		title("SECURITY SETTING CONTROLS TO MAKE SURE THE OHS PRIVATE INFORMATION CAN BE ONLY PERFORMED BY THE USER/ROLE WITH ACCESS TO IT.");

		Helper helper = new Helper();

		// refresh the page
		driver.navigate().refresh();
		Thread.sleep(5000);
		driver.navigate().refresh();

		// APPLY THE OHS PRIVATE INFORMATION PERMISSION
		title("APPLY THE OHS PRIVATE INFORMATION PERMISSION");

		try {
			// wait for the element
			Thread.sleep(5000);

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
			helper.addPermissionOneUsersRole(data, "ohs_security_setting_1", "ohs_securitysettings8_XPATH");

			// APPLY THE ACCESS TO OHS INCIDENT REPORTS
			helper.addPermissionTwoUsersRole(data, "ohs_security_setting_2", "ohs_securitysettings2_XPATH");

			// click on the home icon
			click("questionnaire_homeburgermenubtn_CSS");

			// wait for the element
			explicitWait("propertylist_title_XPATH");

			// verify the property list
			switchVerification("propertylist_title_XPATH", "Property List", "The property list is not displayed.");

		} catch (Throwable t) {
			verificationFailed();
		}

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

			// ADD DETAILS IN THE DETAILS, CAUSES TAB
			title("ADD DETAILS IN THE DETAILS, CAUSES TAB");

			// Enter the data in the description incident field
			type("ohs_incident_descriptionincidenttxt_CSS", data.get("describe_incident"));

			// Enter the data in the Incident Cause field
			type("ohs_incident_incidentcausetxt_CSS", data.get("incident_cause"));

			// scroll down the screen
			scrollByPixel(500);

			// Enter the data in the Actions Taken field
			type("ohs_incident_actionstakentxt_CSS", data.get("actions_taken"));

		} catch (Throwable t) {
			verificationFailed();
		}

		try {

			// click on the next button
			click("ohs_incident_nextbtn_CSS");

			// synchronization
			explicitWait("ohs_incident_personsinvolved_addbtn_CSS");
			consoleMessage("Navigate to the Persons Involved Tab.");

			// ADD DETAILS IN THE PERSONS INVOLVED TAB
			title("ADD DETAILS IN THE PERSONS INVOLVED TAB");

			try {
				// click on the add button
				click("ohs_incident_personsinvolved_addbtn_CSS");

				// select an employee option from the type dropdown
				select("ohs_incident_typedd_CSS", data.get("person_type"));

				// enter data in the Insurance Company Name field
				type("ohs_incident_insurancecompanynametxt_CSS", data.get("insurance_company_name"));

				// enter data in the Insurance Policy Number field
				type("ohs_incident_insurancepolicynumbertxt_CSS", data.get("insurance_policy_number"));

				// click on the Is this person injured? checkbox
				click("ohs_incident_personinjuredckbx_CSS");

				// scroll down the screen
				scrollByPixel(500);

				// enter data in the first name field
				type("ohs_incident_personfirstnametxt_CSS", data.get("person_first_name"));

				// enter data in the last name field
				type("ohs_incident_personlastnametxt_CSS", data.get("person_last_name"));

				// enter data in the job title
				type("ohs_incident_personjobtitletxt_CSS", data.get("job_title"));

				// enter data in the email field
				type("ohs_incident_personemailtxt_CSS", data.get("person_email"));

				// enter data in the phone number field
				type("ohs_incident_personphonenumbertxt_CSS", "9876543210");

				// enter data in the manager name field
				type("ohs_incident_managernametxt_CSS", data.get("manager_name"));

				// enter data in the manager email field
				type("ohs_incident_manageremailtxt_CSS", data.get("manager_email"));

			} catch (Throwable t) {
				verificationFailed();

			}

			// ADD DETAILS IN THE NATURE OF INJURY TAB
			title("ADD DETAILS IN THE NATURE OF INJURY TAB");

			try {
				// scroll up the screen
				scrollByPixel(-500);

				// click on the nature of injury tab
				click("ohs_incident_natureofinjurytab_CSS");

				// click on the abdomen checkbox
				click("ohs_incident_abdomenckbx_CSS");

				// click on the left hand checkbox
				click("ohs_incident_lefthandckbx_CSS");

				// click on the psychological checkbox
				click("ohs_incident_psychologicalckbx_CSS");

				// click on the right shoulder checkbox
				click("ohs_incident_rightshoulderckbx_CSS");

			} catch (Throwable t) {
				verificationFailed();

			}

			// ADD DETAILS IN THE CAUSE OF INJURY TAB
			title("ADD DETAILS IN THE CAUSE OF INJURY TAB");

			try {
				// click on the causes of injury tab
				click("ohs_incident_causeofinjurytab_CSS");

				try {

					// wait for the element
					explicitWaitClickable("ohs_incident_causeofinjury_animaloption_XPATH");

					// click on the first option of the causes of injury
					click("ohs_incident_causeofinjury_animaloption_XPATH");

					// scroll down the screen
					scrollByPixel(500);

					// click on the save button
					click("ohs_incident_causesofinjurytab_savebtn_CSS");

					// verify added person involved details are displayed or not
					switchVerification("ohs_incident_addedpersoninvolved1_XPATH", "Employee",
							"The Employee is not displayed.");

				} catch (Throwable t) {

					verificationFailedMessage("The checklists are not displayed in classic mode.");

					// click on the cancel button
					click("ohs_incident_causesofinjurytab_cancelbtn_XPATH");
				}
			} catch (Throwable t) {
				verificationFailed();
			}
		} catch (Throwable t) {
			verificationFailed();
		}

		try {

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
			switchVerification("ohs_incident_addedincidentreport88_XPATH",
					"Describe Incident Text SS Eight Testing Purpose",
					"The Describe Incident Text SS Eight Testing Purpose is not displayed successfully.");

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

			// VERIFY THE PERSONAL INFORMATION IS ACCESS IN JINESH USER OR NOT
			title("VERIFY THE PERSONAL INFORMATION IS ACCESS IN JINESH USER OR NOT");

			// LOGIN IN JINESH USER
			title("LOGIN IN JINESH USER");

			helper.loginAndUpdateSystemCompany(data, "username", "password", "system_company_1");

			try {
				// click on the OHS icon from the property list page
				click("ohsicon_CSS");

				// wait for the element
				explicitWaitClickable("menubtn_CSS");

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
				switchVerification("ohs_incident_addedincidentreport88_XPATH",
						"Describe Incident Text SS Eight Testing Purpose",
						"The Describe Incident Text SS Eight Testing Purpose is not displayed successfully.");

				// click on the incident report
				click("ohs_incident_addedincidentreport88_XPATH");

				// click on the update details button
				click("ohs_incident_updatebtn_XPATH");

				// wait for the element
				explicitWaitClickable("ohs_incident_personsinvolvedtab_CSS");

				// click on persons involved tab
				click("ohs_incident_personsinvolvedtab_CSS");

				// click on the added person involved
				click("ohs_incident_addedpersoninvolved_XPATH");

				// scroll down the screen
				scrollByPixel(500);

				try {

					boolean ss1 = driver
							.findElement(By.cssSelector(OR.getProperty("ohs_incident_personfirstnametxt_CSS")))
							.isDisplayed();

					boolean ss2 = driver
							.findElement(By.cssSelector(OR.getProperty("ohs_incident_personlastnametxt_CSS")))
							.isDisplayed();

					if ((ss1 && ss2) == true) {
						successMessage("The first name and last name fields are display as expected.");
					} else {
						verificationFailedMessage("The first name and last name fields are not display.");
					}
				} catch (Throwable t) {
					verificationFailedMessage("The first name and last name fields are not display.");
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
			Thread.sleep(5000);

			// click on the settings icon from the top of the screen
			click("questionnaire_settingicon_CSS");

			// wait for the element
			explicitWaitClickable("sidemenu_logout_CSS");

			// click on the logout option from the side menu
			click("sidemenu_logout_CSS");

			// VERIFY THE ADD, EDIT AND DELETE ACCESS IN THE CONTRACTOR ROLE
			title("VERIFY THE ADD, EDIT AND DELETE ACCESS IN THE CONTRACTOR ROLE");

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
				switchVerification("ohs_incident_addedincidentreport88_XPATH",
						"Describe Incident Text SS Eight Testing Purpose",
						"The Describe Incident Text SS Eight Testing Purpose is not displayed successfully.");

				// click on the incident report
				click("ohs_incident_addedincidentreport88_XPATH");

				// wait for the element
				explicitWaitClickable("ohs_incident_personsinvolvedtab_CSS");

				// click on persons involved tab
				click("ohs_incident_personsinvolvedtab_CSS");

				// click on the added person involved
				click("ohs_incident_addedpersoninvolved_XPATH");

				// scroll down the screen
				scrollByPixel(500);

				try {

					boolean ss11 = driver
							.findElement(By.cssSelector(OR.getProperty("ohs_incident_personfirstnametxt_CSS")))
							.isDisplayed();

					boolean ss22 = driver
							.findElement(By.cssSelector(OR.getProperty("ohs_incident_personlastnametxt_CSS")))
							.isDisplayed();

					if ((ss11 && ss22) == true) {
						successMessage("The first name and last name fields are display as expected.");
					} else {
						verificationFailedMessage("The first name and last name fields are not display.");
					}
				} catch (Throwable t) {
					verificationFailedMessage("The first name and last name fields are not display.");
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
			Thread.sleep(5000);

			// click on the settings icon from the top of the screen
			click("questionnaire_settingicon_CSS");

			// wait for the element
			explicitWaitClickable("sidemenu_logout_CSS");

			// click on the logout option from the side menu
			click("sidemenu_logout_CSS");

			// VERIFY THE Private Information ACCESS IN THE CONTRACTOR ROLE
			title("VERIFY THE Private Information ACCESS IN THE CONTRACTOR ROLE");

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
				switchVerification("ohs_incident_addedincidentreport88_XPATH",
						"Describe Incident Text SS Eight Testing Purpose",
						"The Describe Incident Text SS Eight Testing Purpose is not displayed successfully.");

				// click on the incident report
				click("ohs_incident_addedincidentreport88_XPATH");

				// wait for the element
				explicitWaitClickable("ohs_incident_personsinvolvedtab_CSS");

				// click on persons involved tab
				click("ohs_incident_personsinvolvedtab_CSS");

				try {

					boolean ss111 = driver
							.findElement(By.cssSelector(OR.getProperty("ohs_incident_addedpersoninvolved_XPATH")))
							.isDisplayed();

					if (ss111 == true) {
						verificationFailedMessage("The first name and last name fields display as expected.");
					} else {
						successMessage("The first name and last name fields display as expected.");
					}
				} catch (Throwable t) {
					successMessage("The first name and last name fields display as expected.");
				}

				// click on the added person involved
				click("ohs_incident_addedpersoninvolved1_XPATH");

				// scroll down the screen
				scrollByPixel(500);

				try {

					boolean ss1111 = driver
							.findElement(By.cssSelector(OR.getProperty("ohs_incident_personfirstnametxt_CSS")))
							.isDisplayed();

					boolean ss2222 = driver
							.findElement(By.cssSelector(OR.getProperty("ohs_incident_personlastnametxt_CSS")))
							.isDisplayed();

					if ((ss1111 && ss2222) == true) {
						verificationFailedMessage("The first name and last name fields display without permission.");
					} else {
						successMessage("The first name and last name fields display as expected.");
					}
				} catch (Throwable t) {
					successMessage("The first name and last name fields display as expected.");
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
			Thread.sleep(5000);

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
			switchVerification("ohs_incident_addedincidentreport88_XPATH",
					"Describe Incident Text SS Eight Testing Purpose",
					"The Describe Incident Text SS Eight Testing Purpose is not displayed successfully.");

			// click on the incident report
			click("ohs_incident_addedincidentreport88_XPATH");

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
			helper.deleteVerification("ohs_incident_addedincidentreport88_XPATH",
					"Describe Incident Text SS Eight Testing Purpose");

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
			Thread.sleep(5000);

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
			helper.resetPermission(data, "ohs_security_setting_1", "ohs_securitysettings8_XPATH");

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
