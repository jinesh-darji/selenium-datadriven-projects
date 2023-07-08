package testcases.E2Etestcasesuite.riskmanagementmodule;

import java.io.IOException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Hashtable;
import java.util.List;
import java.util.Random;

import org.apache.commons.lang3.RandomStringUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import base.Helper;
import base.TestBase;
import utilities.TestUtil;

public class RR6533RiskManagementTest extends TestBase {

	@Test(dataProviderClass = TestUtil.class, dataProvider = "dp")
	public void rR6533RiskManagementTest(Hashtable<String, String> data) throws IOException, InterruptedException {

		execution(data, "rR6533RiskManagementTest");

		// VALIDATE THE INCIDENT EVENT TYPE AND CLAIM EVENT TYPE FIELDS IN THE INSURANCE
		// CLAIM
		title("VALIDATE THE INCIDENT EVENT TYPE AND CLAIM EVENT TYPE FIELDS IN THE INSURANCE CLAIM");

		// refresh the page
		driver.navigate().refresh();
		Thread.sleep(5000);
		driver.navigate().refresh();

		Helper helper = new Helper();

		// CREATE NEW INCIDENT REPORT
		title("CREATE NEW INCIDENT REPORT");

		String incidentDescription = RandomStringUtils.randomAlphabetic(8);
		String companyName = RandomStringUtils.randomAlphabetic(8);
		String claimNumber = RandomStringUtils.randomNumeric(8);
		LocalDate today = LocalDate.now();
		String today_string = today.toString();
		String incidentNumber = "";
		int randomCount = 0;

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

		// VERIFY INCIDENT EVENT TYPE AND CLAIM EVENT TYPE FIELDS OF THE INSURANCE CLAIM
		// OF THE RISK MANAGEMENT MODULE AFTER JUMP FROM INSURANCE TAB OF THE INCIDENT
		// REPORT AND SAVE THE INSURANCE CLAIM RECORD.
		title("VERIFY INCIDENT EVENT TYPE AND CLAIM EVENT TYPE FIELDS OF THE INSURANCE CLAIM OF THE RISK MANAGEMENT "
				+ "MODULE AFTER JUMP FROM INSURANCE TAB OF THE INCIDENT REPORT AND SAVE THE INSURANCE CLAIM RECORD.");

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

			// scroll down the screen
			scrollBottom();

			// click on the jump to button of the newly created insurance
			String createdInsurance = "//td[text()='" + companyName
					+ "']//following-sibling::td[@ng-click='jumpToInsuranceClaim(insurance.insuranceClaim)']";
			driver.findElement(By.xpath(createdInsurance)).click();
			consoleMessage("Clicked on the jump to button of the newly created insurance.");

			// scroll up the screen
			scrollTop();

			// verify the title of the insurance details screen
			switchVerification("ohs_insurance_title1_XPATH", "Insurance Claim Form",
					"The Insurance Claim Form title of the screen is not displayed.");

			// fetch the incident number of the incident report
			incidentNumber = driver
					.findElement(By.xpath(OR.getProperty("ohs_incidentreport_insurance_incidentnumber_XPATH")))
					.getAttribute("value");

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

			// scroll down the screen
			scrollBottom();

			// validate the incident event type is displayed correctly or not
			try {
				String incidentEventType_actual = (driver
						.findElement(By.xpath(OR.getProperty("ohs_incident_incidenteventtype_XPATH"))).getText())
								.trim();

				if (incidentEventType_actual.equals(data.get("event_type"))) {

					successMessage("The incident event type is displayed correctly.");
				} else {
					verificationFailedMessage("The incident event type is not displayed correctly.");
				}
			} catch (Throwable t) {
				verificationFailedMessage("The incident event type is not displayed correctly.");
			}

			// validate the claim event type label is displayed correctly or not
			try {
				boolean claimEventType_actual = driver
						.findElement(By.xpath(OR.getProperty("ohs_incident_claimeventtypelbl_XPATH"))).isDisplayed();

				if (claimEventType_actual == true) {

					successMessage("The claim event type label is displayed correctly.");
				} else {
					verificationFailedMessage("The claim event type label is not displayed correctly.");
				}
			} catch (Throwable t) {
				verificationFailedMessage("The claim event type label is not displayed correctly.");
			}

			// validate the select claim event type label is displayed correctly or not
			try {
				boolean selectClaimEventType_actual = driver
						.findElement(By.xpath(OR.getProperty("ohs_incident_selectclaimeventtypeslbl_XPATH")))
						.isDisplayed();

				if (selectClaimEventType_actual == true) {

					successMessage("The select claim event type label is displayed correctly.");
				} else {
					verificationFailedMessage("The select claim event type label is not displayed correctly.");
				}
			} catch (Throwable t) {
				verificationFailedMessage("The select claim event type label is not displayed correctly.");
			}

			// click on the select claim event type field
			click("ohs_incident_selectclaimeventtypestxt_XPATH");

			// scroll down the screen
			scrollBottom();

			// validate the options available for the claim event type field
			try {
				List<WebElement> options = driver.findElements(
						By.xpath(OR.getProperty("ohs_incident_selectclaimeventtypestxt_optionlist_XPATH")));
				int optionCount = options.size();

				// validate the count of the options
				if (optionCount == 6) {
					successMessage("The count of the claim event type is displayed correctly.");
				} else {
					verificationFailedMessage("The count of the claim event type is displayed incorrectly.");
				}

				for (int i = 0; i < optionCount; i++) {

					String singleOption = "//div[@id='pickerBody']//div[@class='popover-content']//div[@class='ng-scope']["
							+ i
							+ "]//div[@ng-click='addOrRemoveToSelected(item)']//div[@class='row']//div[@class='col-md-10']//span[@ng-show='getLabel(item).length > 0']";
					String claimeventtypeoption = driver.findElement(By.xpath(singleOption)).getText();

					consoleMessage("claimeventtypeoption::::::::::::::" + claimeventtypeoption);

					switch (claimeventtypeoption) {

					case "Tenant Injury (Other)":

						successMessage("The Tenant Injury (Other) claim event type is displayed successfully.");
						break;

					case "Tenant Injury (Slip and Fall)":

						successMessage("The Tenant Injury (Slip and Fall) claim event type is displayed successfully.");
						break;

					case "Tenant Injury (Trip and Fall)":

						successMessage("The Tenant Injury (Trip and Fall) claim event type is displayed successfully.");
						break;

					case "Third Party Injury (Other)":

						successMessage("The Third Party Injury (Other) claim event type is displayed successfully.");
						break;

					case "Third Party Injury (Slip and Fall)":

						successMessage(
								"The Third Party Injury (Slip and Fall) claim event type is displayed successfully.");
						break;

					case "Third Party Injury (Trip and Fall)":

						successMessage(
								"The Third Party Injury (Trip and Fall) claim event type is displayed successfully.");
						break;

					default:
						verificationFailedMessage("Incorrect claim event type is displayed.");
						break;
					}

				}

			} catch (Throwable t) {
				verificationFailedMessage("The count of the claim event type or options are displayed incorrectly.");
			}

			// click on the select claim event type field
			click("ohs_incident_selectclaimeventtypestxt_XPATH");

			// click on the save button
			click("riskmanagement_insuranceclaim_saveinsuranceclaim_CSS");

			// wait for the element
			explicitWaitClickable("closetoastmsg_CSS");

			// click on the toaster close button
			click("closetoastmsg_CSS");

			// enter the incident in the search field
			type("riskmanagement_insuranceclaim_searchtxt_CSS", incidentNumber);

			// validate the newly created insurance claim record
			try {
				String insuranceClaimRecord = "//td[text()='" + incidentNumber + "']";
				boolean insuranceClaimRecord_actual = driver.findElement(By.xpath(insuranceClaimRecord)).isDisplayed();
				if (insuranceClaimRecord_actual == true) {
					successMessage("The newly created insurance claim record is displayed successfully.");
				} else {
					verificationFailedMessage("The newly created insurance claim record is not displayed.");
				}
			} catch (Throwable t) {
				verificationFailedMessage("The newly created insurance claim record is not displayed.");
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

		// ADD THE CLAIM EVENT TYPES IN THE INSURANCE CLAIM REPORT
		title("ADD THE CLAIM EVENT TYPES IN THE INSURANCE CLAIM REPORT");

		try {
			// click on the risk management icon
			click("riskmanagementicon_CSS");

			// wait for the element
			explicitWaitClickable("menubtn_CSS");

			// click on the burger menu
			click("menubtn_CSS");

			// wait for the element
			Thread.sleep(5000);

			// click on the insurance claim
			click("riskmanagement_insuranceclaimoption_XPATH");

			// click on the newly created insurance claim
			String insuranceClaim = "//td[text()='" + incidentNumber + "']";
			driver.findElement(By.xpath(insuranceClaim)).click();
			consoleMessage("Clicked on the newly created insurance claim.");

			// scroll down the screen
			scrollBottom();

			// click on the select claim event type field
			click("ohs_incident_selectclaimeventtypestxt_XPATH");

			// click on the none button
			click("riskmanagement_insuranceclaim_claimeventtype_nonebtn_XPATH");

			try {
				List<WebElement> optionList = driver.findElements(
						By.xpath(OR.getProperty("riskmanagement_insuranceclaim_claimeventtype_optionlist_XPATH")));
				int optionList_int = optionList.size();

				Random count = new Random();
				randomCount = count.nextInt(optionList_int - 2) + 2;

				for (int i = 0; i < randomCount; i++) {

					optionList.get(i).click();
					consoleMessage("Clicked on the claim event type option: " + i);
				}
			} catch (Throwable t) {
				verificationFailedMessage("The options are not displayed in the select claim event type field.");
			}

			// click on the select claim event type field
			click("ohs_incident_selectclaimeventtypestxt_XPATH");

			// validate the number of the selected claim event type
			try {
				List<WebElement> selectedOption = driver.findElements(
						By.xpath(OR.getProperty("riskmanagement_insuranceclaim_claimeventtype_selectedoptions_XPATH")));
				int selectedOption_int = selectedOption.size();

				if (selectedOption_int == randomCount) {
					successMessage("The selected clint event type count is displayed correctly.");
				} else {
					verificationFailedMessage("The selected clint event type count is displayed incorrectly.");
				}
			} catch (Throwable t) {
				verificationFailedMessage("The selected clint event type count is displayed incorrectly.");
			}

			// click on the save button
			click("riskmanagement_insuranceclaim_saveinsuranceclaim_CSS");

			// wait for the element
			explicitWaitClickable("closetoastmsg_CSS");

			// click on the toaster close button
			click("closetoastmsg_CSS");

			// enter the incident in the search field
			type("riskmanagement_insuranceclaim_searchtxt_CSS", incidentNumber);

			// validate the newly created insurance claim record
			try {
				String insuranceClaimRecord = "//td[text()='" + incidentNumber + "']";
				boolean insuranceClaimRecord_actual = driver.findElement(By.xpath(insuranceClaimRecord)).isDisplayed();
				if (insuranceClaimRecord_actual == true) {
					successMessage("The newly created insurance claim record is displayed successfully.");
				} else {
					verificationFailedMessage("The newly created insurance claim record is not displayed.");
				}
			} catch (Throwable t) {
				verificationFailedMessage("The newly created insurance claim record is not displayed.");
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

		// VALIDATE THE DELETED INSURANCE CLAIM
		title("VALIDATE THE DELETED INSURANCE CLAIM");

		try {
			// click on the risk management icon
			click("riskmanagementicon_CSS");

			// wait for the element
			explicitWaitClickable("menubtn_CSS");

			// click on the burger menu
			click("menubtn_CSS");

			// wait for the element
			Thread.sleep(5000);

			// click on the insurance claim
			click("riskmanagement_insuranceclaimoption_XPATH");

			// enter the incident in the search field
			type("riskmanagement_insuranceclaim_searchtxt_CSS", incidentNumber);

			// validate the newdeleted insurance claim record
			try {
				String insuranceClaim1 = "//td[text()='" + incidentNumber + "']";
				boolean insuranceClaim1_actual = driver.findElement(By.xpath(insuranceClaim1)).isDisplayed();
				if (insuranceClaim1_actual == true) {
					verificationFailedMessage("The newly created insurance claim record is displayed.");
				} else {
					successMessage("The newly created insurance claim record is not displayed as expected.");
				}
			} catch (Throwable t) {
				successMessage("The newly created insurance claim record is not displayed as expected.");
			}

		} catch (Throwable t) {
			verificationFailed();
		}

		// click on the home icon
		click("questionnaire_homeburgermenubtn_hide_CSS");

		// wait for the element
		explicitWait("propertylist_title_XPATH");

		// verify the property list
		switchVerification("propertylist_title_XPATH", "Property List", "The property list is not displayed.");

	}
}
