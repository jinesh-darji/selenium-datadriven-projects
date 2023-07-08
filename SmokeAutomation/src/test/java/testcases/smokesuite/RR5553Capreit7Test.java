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

import base.TestBase;
import utilities.TestUtil;

public class RR5553Capreit7Test extends TestBase {

	@Test(dataProviderClass = TestUtil.class, dataProvider = "dp")
	public void rR5553Capreit7Test(Hashtable<String, String> data) throws IOException, InterruptedException {

		execution(data, "rR5553Capreit7Test");

		// refresh the page
		driver.navigate().refresh();
		Thread.sleep(5000);
		driver.navigate().refresh();

		// UPDATE THE INCIDENT REPORT FROM THE INSURANCE INCIDENT DASHBOARD
		title("UPDATE THE INCIDENT REPORT FROM THE INSURANCE INCIDENT DASHBOARD");

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

		try {

			// click on the next button
			click("ohs_incident_nextbtn_CSS");

			// synchronization
			explicitWait("ohs_incident_personsinvolved_addbtn_CSS");

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

			// click on the add button
			click("ohs_incident_witnessestab_addbtn_CSS");

			// enter data in the first name field
			type("ohs_incident_personfirstnametxt_CSS", data.get("witness_first_name"));

			// enter data in the last name field
			type("ohs_incident_personlastnametxt_CSS", data.get("witness_last_name"));

			// enter data in the phone number field
			type("ohs_incident_personphonenumbertxt_CSS", "9988776655");

			// scroll down the screen

			scrollByPixel(600);

			// enter data in the address one field
			type("ohs_incident_addressone_CSS", data.get("address_1"));

			// enter data in the address two field
			type("ohs_incident_addresstwo_CSS", data.get("address_2"));

			// enter data in the city field
			type("ohs_incident_citytxt_CSS", data.get("city"));

			// enter data in the province field
			type("ohs_incident_provincetxt_CSS", data.get("province"));

			// enter data in the country field
			type("ohs_incident_countrytxt_CSS", data.get("country"));

			// enter data in the postal code field
			type("ohs_incident_postalcodetxt_CSS", "968574");

			// enter data in the description field
			type("ohs_incident_descriptiontxt_CSS", data.get("short_description"));

			// click on the save button
			click("ohs_incident_witnessestab_savebtn_CSS");

			// scroll down the screen
			scrollByPixel(-600);

			// verify added witness details are displayed or not
			switchVerification("ohs_incident_addedwitness_XPATH", "Witness", "The Witness is not displayed.");

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

			// click on the add button
			click("ohs_incident_emergencyservicestab_addbtn_CSS");

			// select the data from the type dropdown
			select("ohs_incident_contacttypedd_CSS", data.get("contacttype"));

			// enter data in the description field
			type("ohs_incident_descriptiontxt_CSS", data.get("short_description"));

			// click on the save button
			click("ohs_incident_emergencyservicestab_savebtn_CSS");

			// verify added emergency services details are displayed or not
			switchVerification("ohs_incident_addedemergencyservices_XPATH", "Ambulance",
					"The Ambulance is not displayed.");

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

			// click on the add button
			click("ohs_incident_propertydamagetab_addbtn_CSS");

			// enter data in the nature of damage field
			type("ohs_incident_natureofdamagetxt_CSS", data.get("nature_of_damage"));

			// scroll down the screen

			scrollByPixel(400);

			// select data from the Estimated Cost of Repairs field
			select("ohs_incident_estimatedcostofrepairsdd_CSS", data.get("estimated_cost_of_repairs"));

			// enter data in the Insurance Company Name field
			type("ohs_incident_propertydamagetab_insurancecompanynametxt_CSS", data.get("insurance_company_name_2"));

			// enter data in the Insurance Policy Number field
			type("ohs_incident_propertydamagetab_insurancepolicynumbertxt_CSS", data.get("insurance_policy_number2"));

			// click on the save button
			click("ohs_incident_propertydamagetab_savebtn_CSS");

			// verify added property damage details are displayed or not
			switchVerification("ohs_incident_addedpropertydamage_XPATH", "Add Nature Of Damage Test",
					"The Add Nature Of Damage Test is not displayed.");

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

			// click on the add button
			click("ohs_incident_insurancetab_addbtn_CSS");

			// enter data in the company name field
			type("ohs_incident_insurance_companynametxt_CSS", data.get("company_name"));

			// enter data in the Claim Number field
			type("ohs_incident_insurance_claimnumbertxt_CSS", data.get("claim_number"));

			// scroll down the screen

			scrollByPixel(600);

			// select data from the Status drop down
			select("ohs_incident_insurance_statusdd_CSS", data.get("insurance_status"));

			// select data from the type drop down
			select("ohs_incident_insurance_typedd_CSS", data.get("insurance_type"));

			// click on the notification date field
			click("ohs_incident_insurance_notificationdate_CSS");

			// click on the today button
			click("ohs_incident_insurance_notificationdate_todayduedatebtn_XPATH");

			// enter data in the Policy Number field
			type("ohs_incident_insurance_policynumbertxt_CSS", data.get("insurance_policy_number"));

			// enter data in the loss description field
			type("ohs_incident_insurance_lossdescription_CSS", data.get("short_description"));

			// click on the save button
			click("ohs_incident_insurancetab_savebtn_CSS");

			// verify added insurance details are displayed or not
			switchVerification("ohs_incident_addedinsurance_XPATH", "ADDCLAIMNUMBERTEST",
					"The ADDCLAIMNUMBERTEST is not displayed.");

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

			test.log(LogStatus.INFO, "Navigate to the attachments Tab.");
			Reporter.log("Navigate to the attachments Tab.");
			successMessage("Navigate to the attachments Tab.");

			// ADD DETAILS IN THE ATTACHMENTS TAB
			title("ADD DETAILS IN THE ATTACHMENTS TAB");

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
			switchVerification("ohs_incident_addedincidentreport_capreit7_XPATH",
					"Capreit7 Describe Incident Text Testing Purpose",
					"The Capreit7 Describe Incident Text Testing Purpose is not displayed successfully.");

		} catch (Throwable t) {
			verificationFailed();
		}

		// click on the home icon from the top of the screen
		click("questionnaire_homeburgermenubtn_hide_CSS");

		// synchronization
		explicitWait("propertylist_title_XPATH");

		// verify the property list
		switchVerification("propertylist_title_XPATH", "Property List", "The property list is not displayed.");

		// UPDATE THE DETAILS OF THE NEWLY ADDED INCIDENT REPORT FROM THE INSURANCE
		// DASHBOARD
		title("UPDATE THE DETAILS OF THE NEWLY ADDED INCIDENT REPORT FROM THE INSURANCE DASHBOARD");

		try {

			// wait for the element
			Thread.sleep(5000);

			// click on the side menu
			click("menubtn_CSS");

			// wait for the element
			Thread.sleep(5000);

			// click on the ohs option
			click("sidemenu_occupationalhealthandsafety_CSS");

			// select the ehs dashboard option from the dashboard dropdown
			select("dashboard_CSS", data.get("insurance_dashboard"));

			// wait for the element
			Thread.sleep(3000);

			// select the event type
			select("ohs_ehsdashboard_filter_eventtypedd_XPATH", data.get("event_type"));

			// wait for the element
			Thread.sleep(3000);

			// click on the newly created incident report
			LocalDate Date = LocalDate.now();
			String todayDate = Date.toString();
			String incidentReport = "//td[text()='" + todayDate + "']";
			driver.findElement(By.xpath(incidentReport)).click();

			// scroll down the screen

			scrollByPixel(400);

			// wait for the element
			Thread.sleep(7000);

			// enter the incident time - hours

			type("ohs_incident_hourstxt_CSS", "12");

			// update the incident time - minute

			type("ohs_incident_minutestxt_CSS", "00");

			// scroll down the screen
			scrollByPixel(500);

			// Update the short description

			type("ohs_incident_shortdescriptiontxt_CSS", data.get("update_describe_incident"));

			// wait for the element
			explicitWaitClickable("ohs_incident_deleteeventbtn_CSS");

			// delete the previously added event type
			click("ohs_incident_deleteeventbtn_CSS");

			// wait for the element
			explicitWaitClickable("ohs_incident_confirmation_deleteeventbtn_CSS");

			// click on the delete button of confirmation message
			click("ohs_incident_confirmation_deleteeventbtn_CSS");

			// click on the add event type button
			click("ohs_incident_addeventtypebtn_CSS");

			// wait for the element
			Thread.sleep(3000);

			// click on the event type dropdown
			select("ohs_incident_eventtypedd_CSS", data.get("update_event_type"));

			// click on the add button of the add event type record model
			click("ohs_incident_eventty_addbtn_CSS");

			// scroll up the screen
			scrollByPixel(-600);

			// click on the detail cause tab
			click("ohs_incident_detailcausetab_CSS");

			// wait for the element
			Thread.sleep(5000);

			// click on the close button
			click("ohs_incident_updatedetails_closebtn_XPATH");

			// click on the update button
			click("ohs_incident_updatebtn_XPATH");

			// wait for the element
			explicitWaitClickable("closetoastmsg_CSS");

			// click on the toaster close button
			click("closetoastmsg_CSS");

		} catch (Throwable t) {

			verificationFailed();

		}

		// UPDATE DETAILS IN THE DETAILS, CAUSES TAB
		title("UPDATE DETAILS IN THE DETAILS, CAUSES TAB");

		try {
			// click on the detail cause tab
			click("ohs_incident_detailcausetab_CSS");

			// wait for the element
			Thread.sleep(7000);

			// Update the data in the description incident field

			type("ohs_incident_descriptionincidenttxt_CSS", data.get("update_describe_incident"));

			// Update the data in the Incident Cause field

			type("ohs_incident_incidentcausetxt_CSS", data.get("update_incident_cause"));

			// scroll down the screen

			scrollByPixel(400);

			// Update the data in the Actions Taken field

			type("ohs_incident_actionstakentxt_CSS", data.get("update_actions_taken"));

			// scroll up the screen
			scrollByPixel(-600);

			// click on the person involved tab
			click("ohs_incident_personsinvolvedtab_CSS");

			// wait for the element
			explicitWaitClickable("ohs_incident_updatedetails_closebtn_XPATH");

			// click on the close button
			click("ohs_incident_updatedetails_closebtn_XPATH");

			// click on the update details button
			click("ohs_incident_updatedetailsbtn_XPATH");

		} catch (Throwable t) {

			verificationFailed();

		}

		// UPDATE DETAILS IN THE PERSONS INVOLVED TAB
		title("UPDATE DETAILS IN THE PERSONS INVOLVED TAB");

		try {
			// click on the person involved tab
			click("ohs_incident_personsinvolvedtab_CSS");

			// wait for the element
			Thread.sleep(7000);

			// click on the added person involved
			click("ohs_incident_addedpersoninvolved1_XPATH");

			try {

				// update data in the Insurance Company Name field

				type("ohs_incident_insurancecompanynametxt_CSS", data.get("update_insurance_company_name"));

				// update data in the Insurance Policy Number field

				type("ohs_incident_insurancepolicynumbertxt_CSS", data.get("update_insurance_policy_number"));

				// scroll down the screen

				scrollByPixel(600);

				// update data in the job title

				type("ohs_incident_personjobtitletxt_CSS", data.get("update_job_title"));

				// updated data in the manager name field

				type("ohs_incident_managernametxt_CSS", data.get("update_manager_name"));

				// update data in the manager email field

				type("ohs_incident_manageremailtxt_CSS", data.get("update_manager_email"));

				// scroll up the screen
				scrollByPixel(-600);

				// UPDATE DETAILS IN THE NATURE OF INJURY TAB
				title("UPDATE DETAILS IN THE NATURE OF INJURY TAB");

				// click on the nature of injury tab
				click("ohs_incident_natureofinjurytab_CSS");

				// wait for the element
				Thread.sleep(7000);

				// click on the abdomen checkbox
				click("ohs_incident_chestckbx_CSS");

				// UPDATE DETAILS IN THE CAUSE OF INJURY TAB
				title("UPDATE DETAILS IN THE CAUSE OF INJURY TAB");

				// click on the causes of injury tab
				click("ohs_incident_causeofinjurytab_CSS");

				// wait for the element
				Thread.sleep(7000);

				try {

					// click on the second option of the causes of injury
					click("ohs_incident_causeofinjury_motionoption_XPATH");

				} catch (Throwable t) {

					verificationFailedMessage("The checklists are not displayed in classic mode.");

				}

				// click on the save button
				click("ohs_incident_causesofinjurytab_savebtn_CSS");

				// scroll up the screen
				scrollByPixel(-400);

			} catch (Throwable t) {

				verificationFailed();

				// click on the persons involved tab
				click("ohs_incident_personsinvolvedtab_CSS");

				// click on the cancel button
				click("ohs_incident_updatebrn_XPATH");

				// scroll up the screen

				scrollByPixel(-400);

			}

		} catch (Throwable t) {

			verificationFailed();

		}

		// UPDATE DETAILS IN THE WITNESSES TAB
		title("UPDATE DETAILS IN THE WITNESSES TAB");

		try {

			// click on the witnesses tab
			click("ohs_incident_witnessestab_CSS");

			// wait for the element
			Thread.sleep(7000);

			// click on the added witness
			click("ohs_incident_addedwitness_XPATH");

			try {

				// scroll down the screen

				scrollByPixel(600);

				// update data in the address one field

				type("ohs_incident_addressone_CSS", data.get("address_1"));

				// update data in the address two field

				type("ohs_incident_addresstwo_CSS", data.get("address_2"));

				// click on the save button
				click("ohs_incident_witnessestab_savebtn_CSS");

				// scroll up the screen
				scrollByPixel(-600);

			} catch (Throwable t) {

				verificationFailed();

				// click on the cancel button
				click("ohs_incident_updatebrn_XPATH");

			}
		} catch (Throwable t) {

			verificationFailed();

		}

		// UPDATE DETAILS IN THE EMERGENCY SERVICES TAB
		title("UPDATE DETAILS IN THE EMERGENCY SERVICES TAB");

		try {
			// click on the emergency services tab
			click("ohs_incident_emergencyservicestab_CSS");

			// wait for the element
			Thread.sleep(7000);

			// click on the added emergency services
			click("ohs_incident_addedemergencyservices_XPATH");

			try {
				// select the data from the type dropdown
				select("ohs_incident_contacttypedd_CSS", data.get("update_contacttype"));

				// enter data in the report number field

				type("ohs_incident_emergencyservicestab_reportnametxt_CSS", data.get("report_number"));

				// update data in the description field

				type("ohs_incident_descriptiontxt_CSS", data.get("update_short_description"));

				// click on the save button
				click("ohs_incident_emergencyservicestab_savebtn_CSS");

				// scroll up the screen

				scrollByPixel(-600);

			} catch (Throwable t) {

				verificationFailed();

				// click on the cancel button
				click("ohs_incident_updatebrn_XPATH");

			}

		} catch (Throwable t) {

			verificationFailed();

		}

		// UPDATE DETAILS IN THE PROPERTY DAMAGE TAB
		title("UPDATE DETAILS IN THE PROPERTY DAMAGE TAB");

		try {
			// click on the property damage tab
			click("ohs_incident_propertydamagetab_CSS");

			// wait for the element
			Thread.sleep(7000);

			// click on the added property damage
			click("ohs_incident_addedpropertydamage_XPATH");

			try {
				// update data in the nature of damage field

				type("ohs_incident_natureofdamagetxt_CSS", data.get("update_nature_of_damage"));

				// scroll down the screen

				scrollByPixel(400);

				// select data from the Estimated Cost of Repairs field
				select("ohs_incident_estimatedcostofrepairsdd_CSS", data.get("update_estimated_cost_of_repairs"));

				// update data in the Insurance Company Name field

				type("ohs_incident_propertydamagetab_insurancecompanynametxt_CSS",
						data.get("update_insurance_company_name_2"));

				// update data in the Insurance Policy Number field

				type("ohs_incident_propertydamagetab_insurancepolicynumbertxt_CSS",
						data.get("update_insurance_policy_number2"));

				// click on the save button
				click("ohs_incident_propertydamagetab_savebtn_CSS");

				// scroll up the screen
				scrollByPixel(-600);

			} catch (Throwable t) {
				verificationFailed();

				// click on the cancel button
				click("ohs_incident_propertydamagetab_cancelbtn_XPATH");

			}

		} catch (Throwable t) {
			verificationFailed();
		}

		// UPDATE DETAILS IN THE INSURANCE TAB
		title("UPDATE DETAILS IN THE INSURANCE TAB");

		try {
			// click on the insurance tab
			click("ohs_incident_insurancetab_CSS");

			// wait for the element
			Thread.sleep(7000);

			// click on the added insurance
			click("ohs_incident_addedinsurance_XPATH");

			try {
				// update data in the company name field

				type("ohs_incident_insurance_companynametxt_CSS", data.get("update_company_name"));

				// update data in the Claim Number field

				type("ohs_incident_insurance_claimnumbertxt_CSS", data.get("update_claim_number"));

				// scroll down the screen

				scrollByPixel(600);

				// select data from the Status drop down
				select("ohs_incident_insurance_statusdd_CSS", data.get("update_insurance_status"));

				// select data from the type drop down
				select("ohs_incident_insurance_typedd_CSS", data.get("update_insurance_type"));

				// click on the notification date field
				click("ohs_incident_insurance_notificationdate_CSS");

				// click on the today button
				click("ohs_incident_insurance_notificationdate_todayduedatebtn_XPATH");

				// update data in the Policy Number field

				type("ohs_incident_insurance_policynumbertxt_CSS", data.get("update_insurance_policy_number"));

				// update data in the loss description field

				type("ohs_incident_insurance_lossdescription_CSS", data.get("update_short_description"));

				// click on the save button
				click("ohs_incident_insurancetab_savebtn_CSS");

				// scroll up the screen
				scrollByPixel(-600);

			} catch (Throwable t) {
				verificationFailed();

				// click on the cancel button
				click("ohs_incident_insurancetab_cancelbtn_XPATH");

			}

		} catch (Throwable t) {
			verificationFailed();
		}

		// UPDATE DETAILS IN THE ATTACHMENTS TAB
		title("UPDATE DETAILS IN THE ATTACHMENTS TAB");

		try {

			// click on the attachments tab
			click("ohs_incident_attachmentstab_CSS");

		} catch (Throwable t) {

			verificationFailed();

		}

		// ADD DETAILS IN THE NOTES AND COMMNETS TAB
		title("ADD DETAILS IN THE NOTES AND COMMNETS TAB");

		try {

			// click on the notes and comments tab
			click("ohs_incident_notescommentstab_CSS");

			// wait for the element
			Thread.sleep(7000);

			// click on the add comment button
			click("task_addcommentbtn_CSS");

			// enter the comment

			type("propertyproject_mu_commenttxt_CSS", data.get("short_description"));

			// click on the add button
			click("task_comment_addcommentbtn_CSS");

			// scroll down the screen

			scrollByPixel(400);

			// verify added comment is displayed or not
			switchVerification("task_comment_addedcomment_XPATH", "Short Description for Testing Purpose",
					"The Short Description for Testing Purpose is nto displayed.");

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

		} catch (Throwable t) {
			verificationFailed();

			// click on the cancel button
			click("ohs_incident_personalinvolvedtab_cancelbrn_XPATH");

		}

		try {

			// wait for the element
			explicitWaitClickable("ohs_incident_search_clearbtn_XPATH");

			// click on the clear button
			click("ohs_incident_search_clearbtn_XPATH");

			// enter the newly created incident report in the search field
			type("ohs_incident_searchtxt_CSS", data.get("update_describe_incident"));

			// click on the search button
			click("ohs_incident_search_searchbtn_CSS");

			// verification of the incident report is added or not
			switchVerification("ohs_incident_updatedincidentreport_capreit7_XPATH",
					"Update Capreit7 Describe Incident Text Testing Purpose",
					"The Update Capreit7 Describe Incident Text Testing Purpose is not displayed successfully.");

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
			type("ohs_incident_searchtxt_CSS", data.get("update_describe_incident"));

			// click on the search button
			click("ohs_incident_search_searchbtn_CSS");

			// click on the updated incident report
			click("ohs_incident_updatedincidentreport_capreit7_XPATH");

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
			type("ohs_incident_searchtxt_CSS", data.get("update_describe_incident"));

			// click on the search button
			click("ohs_incident_search_searchbtn_CSS");

			// verify details are deleted or not
			deleteVerification("ohs_incident_updatedincidentreport_capreit7_XPATH",
					"Update Capreit7 Describe Incident Text Testing Purpose");

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