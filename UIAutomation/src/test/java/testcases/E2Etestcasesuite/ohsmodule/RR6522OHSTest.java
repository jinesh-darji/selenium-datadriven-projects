package testcases.E2Etestcasesuite.ohsmodule;

import java.io.IOException;
import java.time.LocalDate;
import java.util.Hashtable;

import org.apache.commons.lang3.RandomStringUtils;
import org.openqa.selenium.By;
import org.testng.annotations.Test;

import base.Helper;
import base.TestBase;
import utilities.TestUtil;

public class RR6522OHSTest extends TestBase {

	@Test(dataProviderClass = TestUtil.class, dataProvider = "dp")
	public void rR6522OHSTest(Hashtable<String, String> data) throws IOException, InterruptedException {

		execution(data, "rR6522OHSTest");

		// refresh the page
		driver.navigate().refresh();
		Thread.sleep(5000);
		driver.navigate().refresh();

		// VALIDATE THE DATE CHANGE OF THE INCIDENT REPORT ON THE LINKED INSURANCE
		// CLAIM.
		title("VALIDATE THE DATE CHANGE OF THE INCIDENT REPORT ON THE LINKED INSURANCE CLAIM.");

		Helper helper = new Helper();

		// CREATE NEW INCIDENT REPORT
		title("CREATE NEW INCIDENT REPORT");
		
		String incidentDescription = RandomStringUtils.randomAlphabetic(8);
		String companyName = RandomStringUtils.randomAlphabetic(8);
		String claimNumber = RandomStringUtils.randomNumeric(8);
		LocalDate today = LocalDate.now();
		String today_string = today.toString();

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

			// ADD DETAILS IN THE INCIDENT REPORT TAB
			title("ADD DETAILS IN THE INCIDENT REPORT TAB");

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
			type("ohs_incident_shortdescriptiontxt_CSS", incidentDescription);

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

			// ADD DETAILS IN THE INSURANCE TAB
			title("ADD DETAILS IN THE INSURANCE TAB");

			// wait for the element
			Thread.sleep(5000);

			// click on the add button
			click("ohs_incident_insurancetab_addbtn_CSS");

			// enter data in the company name field
			type("ohs_incident_insurance_companynametxt_CSS", companyName);

			// enter data in the Claim Number field
			type("ohs_incident_insurance_claimnumbertxt_CSS", claimNumber);

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
			try {
				String companyname = "//td[contains(text(),'" + companyName + "')]";
				boolean companyname_actual = driver.findElement(By.xpath(companyname)).isDisplayed();

				if (companyname_actual == true) {

					successMessage("The newly created insurance is displayed successfully.");

				} else {
					verificationFailedMessage("The newly created insurance is not displayed.");
				}
			} catch (Throwable t) {
				verificationFailedMessage("The newly created insurance is not displayed.");
			}

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
			type("ohs_incident_searchtxt_CSS", incidentDescription);

			// click on the search button
			click("ohs_incident_search_searchbtn_CSS");

			// verification of the incident report is added or not
			try {
				String incidentname = "//td[text()='" + incidentDescription + "']";
				boolean incidentname_actual = driver.findElement(By.xpath(incidentname)).isDisplayed();

				if (incidentname_actual == true) {

					successMessage("The newly created incident report is displayed successfully.");

				} else {
					verificationFailedMessage("The newly created incident report is not displayed.");
				}
			} catch (Throwable t) {
				verificationFailedMessage("The newly created incident report is not displayed.");
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

		// VERIFY INSURANCE CLAIM ASSOCIATION OF THE RISK MANAGEMENT MODULE AFTER JUMP
		// FROM INSURANCE TAB OF THE INCIDENT REPORT
		title("VERIFY INSURANCE CLAIM ASSOCIATION OF THE RISK MANAGEMENT MODULE AFTER JUMP FROM INSURANCE TAB OF THE INCIDENT REPORT");

		try {

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

			// click on the clear button
			click("ohs_incidentreport_clearbtn_XPATH");

			// enter incident report in the search field
			type("ohs_incidentreport_searchtxt_XPATH", incidentDescription);

			// click on the search button
			click("ohs_incidentreport_searchbtn_XPATH");

			// click on the added incident report
			String incidentname = "//td[text()='" + incidentDescription + "']";
			driver.findElement(By.xpath(incidentname)).click();
			consoleMessage("Clicked on the added incident report");

			// click on the insurance tab
			click("ohs_incident_insurancetab_CSS");

			// wait for the element
			Thread.sleep(7000);

			// click on the jump to button of the newly created insurance
			String createdInsurance = "//td[text()='" + companyName
					+ "']//following-sibling::td[@ng-click='jumpToInsuranceClaim(insurance.insuranceClaim)']";
			driver.findElement(By.xpath(createdInsurance)).click();
			consoleMessage("Clicked on the jump to button of the newly created insurance.");

			// verify the title of the insurance details screen
			switchVerification("ohs_insurance_title1_XPATH", "Insurance Claim Form",
					"The Insurance Claim Form title of the screen is not displayed.");

			// validate the date of the incident report
			try {
				String incidentdate = driver
						.findElement(By.xpath(OR.getProperty("ohs_incidentreport_insurance_incidentdate_XPATH")))
						.getAttribute("value");

				if (incidentdate.equals(today_string)) {
					successMessage("The incident date is displayed correctly.");
				} else {
					verificationFailedMessage("The incident date is not displayed correctly.");
				}
			} catch (Throwable t) {
				verificationFailedMessage("The incident date is not displayed correctly.");
			}

			// click on the incident return icon
			click("ohs_insurance_returntoincidenticon_XPATH");

			// wait for the element
			Thread.sleep(5000);

			// verify incident title
			switchVerification("ohs_insurance_incidenttitle_XPATH", "Incident Report",
					"The Incident Report title is not displayed.");

		} catch (Throwable t) {
			verificationFailed();
		}

		// click on the home icon from the top of the screen
		click("questionnaire_homeburgermenubtn_hide_CSS");

		// wait for the element
		explicitWait("propertylist_title_XPATH");

		// verify the property list
		switchVerification("propertylist_title_XPATH", "Property List", "The property list is not displayed.");

		// UPDATE THE INCIDENT DATE OF THE NEWLY CREATED INCIDENT REPORT
		title("UPDATE THE INCIDENT DATE OF THE NEWLY CREATED INCIDENT REPORT");

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

			// click on the added incident report
			String incidentname = "//td[text()='" + incidentDescription + "']";
			driver.findElement(By.xpath(incidentname)).click();
			consoleMessage("Clicked on the added incident report");

			// wait for the element
			Thread.sleep(5000);

			// click on the incident date field
			click("ohs_incidentreport_incidentdate_XPATH");

			// click on the header of the date field
			click("ohs_incidentreport_incidentdate_header_XPATH");

			// click on the december month of the current year
			click("ohs_incidentreport_incidentdate_decembermonth_XPATH");

			// click on the 31th date of the current month
			click("ohs_incidentreport_incidentdate_31date_XPATH");

			// scroll down the screen
			scrollBottom();

			// click on the update record button
			click("ohs_incident_updaterecordbtn_XPATH");

			// click on the cancel button
			click("ohs_incident_cancelbtn_CSS");

			// wait for the element
			explicitWaitClickable("ohs_incident_search_clearbtn_XPATH");

			// click on the clear button
			click("ohs_incident_search_clearbtn_XPATH");

			// enter the newly created incident report in the search field
			type("ohs_incident_searchtxt_CSS", incidentDescription);

			// click on the search button
			click("ohs_incident_search_searchbtn_CSS");

			// verification of the incident report is added or not
			try {
				String incidentname1 = "//td[text()='" + incidentDescription + "']";
				boolean incidentname1_actual = driver.findElement(By.xpath(incidentname1)).isDisplayed();

				if (incidentname1_actual == true) {

					successMessage("The newly created incident report is displayed successfully.");

				} else {
					verificationFailedMessage("The newly created incident report is not displayed.");
				}
			} catch (Throwable t) {
				verificationFailedMessage("The newly created incident report is not displayed.");
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

		// VERIFY UPDATED INCIDENT DATE OF THE INSURANCE CLAIM ASSOCIATION OF THE RISK
		// MANAGEMENT MODULE AFTER JUMP FROM INSURANCE TAB OF THE INCIDENT REPORT
		title("VERIFY UPDATED INCIDENT DATE OF THE INSURANCE CLAIM ASSOCIATION OF THE RISK MANAGEMENT MODULE AFTER JUMP FROM INSURANCE TAB OF THE INCIDENT REPORT");

		try {

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

			// click on the clear button
			click("ohs_incidentreport_clearbtn_XPATH");

			// enter incident report in the search field
			type("ohs_incidentreport_searchtxt_XPATH", incidentDescription);

			// click on the search button
			click("ohs_incidentreport_searchbtn_XPATH");

			// click on the added incident report
			String incidentname = "//td[text()='" + incidentDescription + "']";
			driver.findElement(By.xpath(incidentname)).click();
			consoleMessage("Clicked on the added incident report");

			// click on the insurance tab
			click("ohs_incident_insurancetab_CSS");

			// wait for the element
			Thread.sleep(7000);

			// click on the jump to button of the newly created insurance
			String createdInsurance = "//td[text()='" + companyName
					+ "']//following-sibling::td[@ng-click='jumpToInsuranceClaim(insurance.insuranceClaim)']";
			driver.findElement(By.xpath(createdInsurance)).click();
			consoleMessage("Clicked on the jump to button of the newly created insurance.");

			// verify the title of the insurance details screen
			switchVerification("ohs_insurance_title1_XPATH", "Insurance Claim Form",
					"The Insurance Claim Form title of the screen is not displayed.");

			// validate the date of the incident report
			try {
				String incidentdate = driver
						.findElement(By.xpath(OR.getProperty("ohs_incidentreport_insurance_incidentdate_XPATH")))
						.getAttribute("value");
				LocalDate currentDate = LocalDate.now();
				String currentDate_string = currentDate.toString();
				String[] currentDate_arr = currentDate_string.split("-");
				String currentYear = currentDate_arr[0];
				String currentYear_actual = currentYear + "-12-31";

				if (incidentdate.equals(currentYear_actual)) {
					successMessage("The incident date is displayed correctly.");
				} else {
					verificationFailedMessage("The incident date is not displayed correctly.");
				}
			} catch (Throwable t) {
				verificationFailedMessage("The incident date is not displayed correctly.");
			}

			// click on the incident return icon
			click("ohs_insurance_returntoincidenticon_XPATH");

			// wait for the element
			Thread.sleep(5000);

			// verify incident title
			switchVerification("ohs_insurance_incidenttitle_XPATH", "Incident Report",
					"The Incident Report title is not displayed.");

		} catch (Throwable t) {
			verificationFailed();
		}

		// click on the home icon from the top of the screen
		click("questionnaire_homeburgermenubtn_hide_CSS");

		// wait for the element
		explicitWait("propertylist_title_XPATH");

		// verify the property list
		switchVerification("propertylist_title_XPATH", "Property List", "The property list is not displayed.");

		// DELETE THE INCIDENT REPORT AND INSURANCE
		title("DELETE THE INCIDENT REPORT AND INSURANCE");

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

			// click on the clear button
			click("ohs_incidentreport_clearbtn_XPATH");

			// enter incident report in the search field
			type("ohs_incidentreport_searchtxt_XPATH", incidentDescription);

			// click on the search button
			click("ohs_incidentreport_searchbtn_XPATH");

			// click on the added incident report
			String incidentname = "//td[text()='" + incidentDescription + "']";
			driver.findElement(By.xpath(incidentname)).click();
			consoleMessage("Clicked on the added incident report");

			// click on the insurance tab
			click("ohs_incident_insurancetab_CSS");

			// click on the delete button of the added property damage
			click("ohs_incident_insurancedeletebtn_CSS");

			// verify details are deleted or not
			helper.deleteVerification("ohs_insurance_companyname_XPATH", "Add Insurance Company Name Test");

			// verify deleted insurance details are displayed or not
			try {
				String companyname = "//td[contains(text(),'" + companyName + "')]";
				boolean companyname_actual = driver.findElement(By.xpath(companyname)).isDisplayed();

				if (companyname_actual == true) {
					verificationFailedMessage("The newly created insurance is not deleted.");

				} else {
					successMessage("The newly created insurance is deleted successfully.");
				}
			} catch (Throwable t) {
				successMessage("The newly created insurance is deleted successfully.");
			}

			// click on the incident summary
			click("ohs_incident_incidentsummarytab_CSS");

			// wait for the element
			explicitWaitClickable("ohs_incident_deletebtn_CSS");

			// click on the delete button
			click("ohs_incident_deletebtn_CSS");

			// wait for the element
			explicitWaitClickable("ohs_incident_confirmdeletebtn_CSS");

			// click on the delete button of confirmation popup
			click("ohs_incident_confirmdeletebtn_CSS");

			// verify details are deleted or not
			helper.deleteVerification("ohs_incident_addedincidentreport_jumpto_XPATH",
					"Describe Incident Text Jump To");

			// verification of the incident report is displayed or not
			try {
				String incidentname2 = "//td[text()='" + incidentDescription + "']";
				boolean incidentname2_actual = driver.findElement(By.xpath(incidentname2)).isDisplayed();

				if (incidentname2_actual == true) {
					verificationFailedMessage("The incident report is displayed after deleted the record.");

				} else {
					successMessage("The incident report is not displayed after deleted the record.");

				}
			} catch (Throwable t) {
				successMessage("The incident report is not displayed after deleted the record.");
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
