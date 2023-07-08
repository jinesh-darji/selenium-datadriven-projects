package testcases.smokesuite;

import java.io.IOException;
import java.util.Hashtable;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.testng.Reporter;
import org.testng.SkipException;
import org.testng.annotations.Test;

import com.relevantcodes.extentreports.LogStatus;

import base.TestBase;
import utilities.TestUtil;

public class RR5553Capreit2Test extends TestBase {

	@Test(dataProviderClass = TestUtil.class, dataProvider = "dp")
	public void rR5553Capreit2Test(Hashtable<String, String> data) throws IOException, InterruptedException {

		execution(data, "rR5553Capreit2Test");

		// refresh the page
		driver.navigate().refresh();
		Thread.sleep(5000);
		driver.navigate().refresh();

		// VERIFY THE INCIDENTS SUBSTANCE SPILL WORKFLOW - CAPREIT
		title("VERIFY THE INCIDENTS SUBSTANCE SPILL WORKFLOW - CAPREIT");

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

		// UPDATE THE INCIDENT EVENT TYPE FOR THE INCIDENTS SUBSTANCE SPILL WORKFLOW
		title("UPDATE THE INCIDENT EVENT TYPE FOR THE INCIDENTS SUBSTANCE SPILL WORKFLOW");

		try {
			// wait for the element
			explicitWaitClickable("questionnaire_settingicon_CSS");

			// click on the settings icon from the top of the screen
			click("questionnaire_settingicon_CSS");

			// wait for the element
			explicitWaitClickable("questionnaire_administrationoption_XPATH");

			// click on the administration option from the side menu
			click("questionnaire_administrationoption_XPATH");

			// scroll down the screen

			scrollByPixel(400);

			// click on the OHS tab
			click("questionnaire_ohstab_XPATH");

			// click on the Incident Event Types
			click("questionnaire_incidenteventtypeoption_XPATH");

			// scroll down the screen
			scrollTillElement("ohs_incident_substancespill_XPATH");
			scrollByPixel(-400);

			// click on the substance spill record
			click("ohs_incident_substancespill_XPATH");

			// scroll down the screen
			scrollByPixel(400);

			try {
				boolean isSpill = driver
						.findElement(By.cssSelector(OR.getProperty("ohs_incident_substancespill_checkbox_CSS")))
						.isSelected();

				if (isSpill != true) {

					// click on the isSpill checkbox
					click("ohs_incident_substancespill_checkbox_CSS");

					// click on update button
					click("ohs_incident_alertnotification_updatebtn_CSS");

				} else {
					// click on update button
					click("ohs_incident_alertnotification_updatebtn_CSS");

				}

			} catch (Throwable t) {
				verificationFailed();

				// click on update button
				click("ohs_incident_alertnotification_updatebtn_CSS");

			}

			// scroll down the screen
			scrollTillElement("ohs_incident_employeeinjury_XPATH");
			scrollByPixel(-400);

			// click on the Employee Injury record
			click("ohs_incident_employeeinjury_XPATH");

			// scroll down the screen
			scrollByPixel(400);

			try {
				boolean injuryRequired = driver
						.findElement(By.cssSelector(OR.getProperty("ohs_incident_employeeinjury_checkbox_CSS")))
						.isSelected();

				if (injuryRequired != true) {

					// click on the isSpill checkbox
					click("ohs_incident_employeeinjury_checkbox_CSS");

					// click on update button
					click("ohs_incident_alertnotification_updatebtn_CSS");

				} else {
					// click on update button
					click("ohs_incident_alertnotification_updatebtn_CSS");

				}

			} catch (Throwable t) {
				verificationFailed();

				// click on update button
				click("ohs_incident_alertnotification_updatebtn_CSS");

			}

		} catch (Throwable t) {
			verificationFailed();
		}

		// click on the home icon from the top of the screen
		click("questionnaire_homeburgermenubtn_CSS");

		// synchronization
		explicitWait("propertylist_title_XPATH");

		// verify the property list
		switchVerification("propertylist_title_XPATH", "Property List", "The property list is not displayed.");

		// CREATE NEW INCIDENT REPORT
		title("CREATE NEW INCIDENT REPORT");

		try {

			// enter the property name in the search field
			type("envreports_propertylist_filtertxt_CSS", data.get("property_1"));

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
			select("ohs_incident_eventtypedd_CSS", data.get("substance_spill"));

			// click on the add button of the add event type record model
			click("ohs_incident_eventty_addbtn_CSS");

			// wait for the element
			Thread.sleep(5000);

			try {
				// verify the spill information tab is displayed or not
				String spillInformation = driver
						.findElement(By.cssSelector(OR.getProperty("ohs_incident_spillinformationtab_CSS"))).getText();
				String finalSpillInformation = spillInformation.trim();

				if (finalSpillInformation.equals("Spill Information")) {
					successMessage("THE SPILL INFORMATION TAB IS DISPLAYED SUCCESSFULLY.");
				} else {
					verificationFailed();
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

			test.log(LogStatus.INFO, "Navigate to the Spill Information Tab.");
			Reporter.log("Navigate to the Spill Information Tab.");
			successMessage("Navigate to the Spill Information Tab.");

			// ADD DETAILS IN THE SPILL INFORMATION TAB
			title("ADD DETAILS IN THE SPILL INFORMATION TAB");

			// Enter the data in the location details field
			type("ohs_incident_spillinformationtab_locationdetailstxt_CSS", data.get("location_details"));

		} catch (Throwable t) {
			verificationFailed();
		}

		try {

			// click on the previous button
			click("ohs_incident_previousbtn_XPATH");

			// synchronization
			explicitWait("ohs_incident_nextbtn_CSS");

			// UPDATE THE EVENT TYPE
			title("UPDATE THE EVENT TYPE");

			// scroll down the screen

			scrollByPixel(500);

			// delete the previously added event type
			click("ohs_incident_deleteeventbtn_CSS");

			// wait for the element
			Thread.sleep(5000);

			// click on the delete button of confirmation message
			click("ohs_incident_confirmation_deleteeventbtn_CSS");

			// click on the add event type button
			click("ohs_incident_addeventtypebtn_CSS");

			// click on the event type dropdown
			select("ohs_incident_eventtypedd_CSS", data.get("employee_injury"));

			// click on the add button of the add event type record model
			click("ohs_incident_eventty_addbtn_CSS");

			// wait for the element
			Thread.sleep(5000);

			try {
				// verify the spill information tab is displayed or not
				String spillInformation = driver
						.findElement(By.cssSelector(OR.getProperty("ohs_incident_spillinformationtab_CSS"))).getText();
				String finalSpillInformation = spillInformation.trim();

				if (finalSpillInformation.equals("Spill Information")) {

					verificationFailed();

				}
			} catch (Throwable t) {
				successMessage("THE SPILL INFORMATION TAB IS NOT DISPLAYED AS EXPECTED.");
			}

		} catch (Throwable t) {
			verificationFailed();
		}

		try {

			// click on the next button
			click("ohs_incident_nextbtn_CSS");

			// synchronization
			explicitWait("ohs_incident_nextbtn_CSS");

			// ADD DETAILS IN THE DETAILS, CAUSES TAB
			title("ADD DETAILS IN THE DETAILS, CAUSES TAB");

			// Enter the data in the description incident field
			type("ohs_incident_descriptionincidenttxt_CSS", data.get("describe_incident"));

			// Enter the data in the Incident Cause field
			type("ohs_incident_incidentcausetxt_CSS", data.get("incident_cause"));

			// scroll down the screen

			scrollByPixel(400);

			// Enter the data in the Actions Taken field
			type("ohs_incident_actionstakentxt_CSS", data.get("actions_taken"));

		} catch (Throwable t) {
			verificationFailed();
		}

		// VERIFY USER ALLOW TO MOVE WITHOUT ENTERED DETAILS IN THE PERSONS INVOLVED TAB
		// AND SPECIFY THE NATURE OF INJURY AND CAUSE OF INJURY.
		title("VERIFY USER ALLOW TO MOVE WITHOUT ENTERED DETAILS IN THE PERSONS INVOLVED TAB AND SPECIFY THE NATURE OF INJURY AND CAUSE OF INJURY.");

		try {

			// click on the next button
			click("ohs_incident_nextbtn_CSS");

			// synchronization
			explicitWait("ohs_incident_personsinvolved_addbtn_CSS");

			// click on the next button
			click("ohs_incident_nextbtn_CSS");

			// synchronization
			explicitWait("ohs_incident_nextbtn_CSS");

			try {

				// wait for the element
				explicitWait("ohs_incident_mandatorytext_XPATH");

				// verify validation is work or not
				boolean validationmsg = driver.findElement(By.xpath(OR.getProperty("ohs_incident_mandatorytext_XPATH")))
						.isDisplayed();

				if (validationmsg == true) {
					successMessage("THE VALIDATION IS DISPLAYED SUCCESSFULLY AS EXPECTED.");
				} else {
					verificationFailed();
				}

			} catch (Throwable t) {
				verificationFailed();
			}

			// click on the previous button
			click("ohs_incident_previousbtn_XPATH");

		} catch (Throwable t) {
			verificationFailed();
		}

		try {

			// click on the next button
			click("ohs_incident_nextbtn_CSS");

			// synchronization
			explicitWait("ohs_incident_personsinvolved_addbtn_CSS");

			// ADD DETAILS IN THE PERSONS INVOLVED TAB
			title("ADD DETAILS IN THE PERSONS INVOLVED TAB");

			try {

				// wait for the element
				Thread.sleep(7000);

				// click on the add button
				click("ohs_incident_personsinvolved_addbtn_CSS");

				// select an employee option from the type dropdown
				select("ohs_incident_typedd_CSS", data.get("person_type"));

				// enter data in the Insurance Company Name field
				type("ohs_incident_insurancecompanynametxt_CSS", data.get("insurance_company_name"));

				// enter data in the Insurance Policy Number field
				type("ohs_incident_insurancepolicynumbertxt_CSS", data.get("insurance_policy_number"));

				try {
					boolean injuredcheckbox = driver
							.findElement(By.xpath(OR.getProperty("ohs_incident_isinjured_disabled_XPATH")))
							.isDisplayed();

					if (injuredcheckbox == true) {
						successMessage("THE PERSON INJURED CHECKBOX DISPLAYED DISABLED SUCCESSFULLY AS EXPECTED.");
					} else {
						verificationFailed();
					}
				} catch (Throwable t) {
					verificationFailed();
				}

				// scroll down the screen

				scrollByPixel(600);

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

				scrollByPixel(-600);

				// click on the nature of injury tab
				click("ohs_incident_natureofinjurytab_CSS");

				// wait for the element
				Thread.sleep(7000);

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

				// wait for the element
				Thread.sleep(7000);

				try {

					// wait for the element
					explicitWaitClickable("ohs_incident_causeofinjury_animaloption_XPATH");

					// click on the first option of the causes of injury
					click("ohs_incident_causeofinjury_animaloption_XPATH");

					// scroll down the screen

					scrollByPixel(400);

					// click on the save button
					click("ohs_incident_causesofinjurytab_savebtn_CSS");

					// verify added person involved details are displayed or not
					switchVerification("ohs_incident_addedpersoninvolved_XPATH", "Employee",
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

			// ADD DETAILS IN THE WITNESSES TAB
			title("ADD DETAILS IN THE WITNESSES TAB");

			// wait for the element
			Thread.sleep(7000);

		} catch (Throwable t) {

			verificationFailed();

			// click on the cancel button
			click("ohs_incident_updatebrn_XPATH");

		}

		try {

			// click on the next button
			click("ohs_incident_nextbtn_CSS");

			explicitWait("ohs_incident_nextbtn_CSS");

			// ADD DETAILS IN THE EMERGENCY SERVICES TAB
			title("ADD DETAILS IN THE EMERGENCY SERVICES TAB");

		} catch (Throwable t) {
			verificationFailed();

			// click on the cancel button
			click("ohs_incident_updatebrn_XPATH");

		}

		try {

			// click on the next button
			click("ohs_incident_nextbtn_CSS");

			// synchronization
			explicitWait("ohs_incident_nextbtn_CSS");

			// ADD DETAILS IN THE PROPERTY DAMAGE TAB
			title("ADD DETAILS IN THE PROPERTY DAMAGE TAB");

		} catch (Throwable t) {
			verificationFailed();

			// click on the cancel button
			click("ohs_incident_propertydamage_cancelbtn_XPATH");

		}

		try {
			// click on the next button
			click("ohs_incident_nextbtn_CSS");

			// synchronization
			explicitWait("ohs_incident_nextbtn_CSS");

			// ADD DETAILS IN THE INSURANCE TAB
			title("ADD DETAILS IN THE INSURANCE TAB");

		} catch (Throwable t) {
			verificationFailed();

			// click on the cancel button
			click("ohs_incident_insurancetab_cancelbtn_XPATH");

		}

		try {

			// click on the next button
			click("ohs_incident_nextbtn_CSS");

			// synchronization
			explicitWait("ohs_incident_updaterecordbtn_CSS");

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
			switchVerification("ohs_incident_addedincidentreport_capreit2_XPATH",
					"Capreit2 Describe Incident Text Testing Purpose",
					"The Capreit2 Describe Incident Text Testing Purpose is not displayed successfully.");

		} catch (Throwable t) {
			verificationFailed();
		}

		// click on the home icon from the top of the screen
		click("questionnaire_homeburgermenubtn_hide_CSS");

		// synchronization
		explicitWait("propertylist_title_XPATH");

		// verify the property list
		switchVerification("propertylist_title_XPATH", "Property List", "The property list is not displayed.");

		// DELETE DETAILS IN THE INCIDENT REPORT
		title("DELETE DETAILS IN THE INCIDENT REPORT");

		try {

			// enter the property name in the search field
			type("envreports_propertylist_filtertxt_CSS", data.get("property_1"));

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
			click("ohs_incident_addedincidentreport_capreit2_XPATH");

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
			deleteVerification("ohs_incident_addedincidentreport_capreit2_XPATH",
					"Capreit2 Describe Incident Text Testing Purpose");

		} catch (Throwable t) {
			verificationFailed();
		}

		// click on the home icon from the top of the screen
		click("questionnaire_homeburgermenubtn_hide_CSS");

		// synchronization
		explicitWait("propertylist_title_XPATH");

		// verify the property list
		switchVerification("propertylist_title_XPATH", "Property List", "The property list is not displayed.");

		// RESET THE INCIDENT EVENT TYPE FOR THE INCIDENTS SUBSTANCE SPILL AND INJURY
		// CHECKLIST
		title("RESET THE INCIDENT EVENT TYPE FOR THE INCIDENTS SUBSTANCE SPILL AND INJURY CHECKLIST");

		try {
			// wait for the element
			Thread.sleep(10000);

			// click on the settings icon from the top of the screen
			click("questionnaire_settingicon_CSS");

			// wait for the element
			explicitWaitClickable("questionnaire_administrationoption_XPATH");

			// click on the administration option from the side menu
			click("questionnaire_administrationoption_XPATH");

			// scroll down the screen

			scrollByPixel(400);

			// click on the OHS tab
			click("questionnaire_ohstab_XPATH");

			// click on the Incident Event Types
			click("questionnaire_incidenteventtypeoption_XPATH");

			// scroll down the screen
			scrollTillElement("ohs_incident_substancespill_XPATH");
			scrollByPixel(-400);

			// click on the substance spill record
			click("ohs_incident_substancespill_XPATH");

			// scroll down the screen
			scrollByPixel(400);

			try {
				boolean isSpill = driver
						.findElement(By.cssSelector(OR.getProperty("ohs_incident_substancespill_checkbox_CSS")))
						.isSelected();

				if (isSpill == true) {

					// click on the isSpill checkbox
					click("ohs_incident_substancespill_checkbox_CSS");

					// click on update button
					click("ohs_incident_alertnotification_updatebtn_CSS");

				} else {
					// click on update button
					click("ohs_incident_alertnotification_updatebtn_CSS");

				}

			} catch (Throwable t) {
				verificationFailed();

				// click on update button
				click("ohs_incident_alertnotification_updatebtn_CSS");

			}

			// scroll down the screen
			scrollTillElement("ohs_incident_employeeinjury_XPATH");
			scrollByPixel(-400);

			// click on the Employee Injury record
			click("ohs_incident_employeeinjury_XPATH");

			// scroll down the screen
			scrollByPixel(400);

			try {
				boolean injuryRequired = driver
						.findElement(By.cssSelector(OR.getProperty("ohs_incident_employeeinjury_checkbox_CSS")))
						.isSelected();

				if (injuryRequired == true) {

					// click on the isSpill checkbox
					click("ohs_incident_employeeinjury_checkbox_CSS");

					// click on update button
					click("ohs_incident_alertnotification_updatebtn_CSS");

				} else {
					// click on update button
					click("ohs_incident_alertnotification_updatebtn_CSS");

				}

			} catch (Throwable t) {
				verificationFailed();

				// click on update button
				click("ohs_incident_alertnotification_updatebtn_CSS");

			}

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
			// wait for the element
			Thread.sleep(7000);

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