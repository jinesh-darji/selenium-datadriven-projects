package testcases.E2Etestcasesuite.ohsmodule;

import java.io.IOException;
import java.time.LocalDate;
import java.util.Hashtable;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.testng.Reporter;
import org.testng.SkipException;
import org.testng.annotations.Test;

import com.relevantcodes.extentreports.LogStatus;

import base.Helper;
import base.TestBase;
import utilities.TestUtil;

public class RR5241OHSTest extends TestBase {

	@Test(dataProviderClass = TestUtil.class, dataProvider = "dp")
	public void rR5241OHSTest(Hashtable<String, String> data) throws IOException, InterruptedException {

		execution(data, "rR5241OHSTest");

		// VERIFY THE INCIDENT REPORT IN THE EHS INCIDANCE, HR INCIDANCE, INSURANCE
		// INCIDANCE DASHBOARDS.
		title("VERIFY THE INCIDENT REPORT IN THE EHS INCIDANCE, HR INCIDANCE, INSURANCE INCIDANCE DASHBOARDS.");

		Helper helper = new Helper();

		// refresh the page
		driver.navigate().refresh();
		Thread.sleep(5000);
		driver.navigate().refresh();

		String insuranceNumber = null;

		try {

			// wait for the element
			explicitWaitClickable("ohsicon_CSS");

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

			// wait for the element
			Thread.sleep(5000);

			// enter the incident time - hours
			type("ohs_incident_hourstxt_CSS", "11");

			// enter the incident time - minute
			type("ohs_incident_minutestxt_CSS", "20");

			// scroll down the screen
			scrollByPixel(500);

			// enter the short description
			type("ohs_incident_shortdescriptiontxt_CSS", data.get("describe_incident"));

			// wait for the element
			explicitWaitClickable("ohs_incident_addeventtypebtn_CSS");

			// click on the add event type button
			click("ohs_incident_addeventtypebtn_CSS");

			// wait for the element
			explicitWaitClickable("ohs_incident_eventtypedd_CSS");

			// click on the event type dropdown
			select("ohs_incident_eventtypedd_CSS", data.get("event_type"));

			// click on the add button of the add event type record model
			click("ohs_incident_eventty_addbtn_CSS");

			// scroll up the screen
			scrollByPixel(-700);

			// fetch the insurance number
			insuranceNumber = (driver.findElement(By.xpath(OR.getProperty("ohs_incident_insurancenumber_XPATH")))
					.getText()).trim();
			consoleMessage("fetch the insurance number: " + insuranceNumber);

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

			// click on the next button
			click("ohs_incident_nextbtn_CSS");

			// synchronization
			explicitWait("ohs_incident_personsinvolved_addbtn_CSS");
			consoleMessage("Navigate to the Persons Involved Tab.");

			// ADD DETAILS IN THE PERSONS INVOLVED TAB
			title("ADD DETAILS IN THE PERSONS INVOLVED TAB");

			// click on the add button
			click("ohs_incident_personsinvolved_addbtn_CSS");

			// select an employee option from the type dropdown
			select("ohs_incident_typedd_CSS", data.get("person_type"));

			// enter data in the Insurance Company Name field
			type("ohs_incident_insurancecompanynametxt_CSS", data.get("insurance_policy_number"));

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

			// ADD DETAILS IN THE NATURE OF INJURY TAB
			title("ADD DETAILS IN THE NATURE OF INJURY TAB");

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

			// ADD DETAILS IN THE CAUSE OF INJURY TAB
			title("ADD DETAILS IN THE CAUSE OF INJURY TAB");

			// click on the causes of injury tab
			click("ohs_incident_causeofinjurytab_CSS");

			try {

				// wait for the element
				explicitWaitClickable("ohs_incident_causeofinjury_animaloption_XPATH");

				// click on the first option of the causes of injury
				click("ohs_incident_causeofinjury_animaloption_XPATH");

			} catch (Throwable t) {

				verificationFailedMessage("The checklists are not displayed in classic mode.");

			}

			// scroll down the screen
			scrollByPixel(500);

			// click on the save button
			click("ohs_incident_causesofinjurytab_savebtn_CSS");

			// verify added person involved details are displayed or not
			switchVerification("ohs_incident_addedpersoninvolved1_XPATH", "Employee", "The Employee is not displayed.");

			// click on the next button
			click("ohs_incident_nextbtn_CSS");

			// synchronization
			explicitWait("ohs_incident_nextbtn_CSS");
			consoleMessage("Navigate to the Witnesses Tab.");

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
			scrollByPixel(500);

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
			scrollByPixel(-500);

			// verify added witness details are displayed or not
			switchVerification("ohs_incident_addedwitness1_XPATH", "Witness", "The Witness is not displayed.");

			// click on the next button
			click("ohs_incident_nextbtn_CSS");

			// synchronization
			explicitWait("ohs_incident_nextbtn_CSS");
			consoleMessage("Navigate to the emergency services Tab.");

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

			// click on the next button
			click("ohs_incident_nextbtn_CSS");

			// synchronization
			explicitWait("ohs_incident_nextbtn_CSS");
			consoleMessage("Navigate to the property damage Tab.");

			// ADD DETAILS IN THE PROPERTY DAMAGE TAB
			title("ADD DETAILS IN THE PROPERTY DAMAGE TAB");

			// click on the add button
			click("ohs_incident_propertydamagetab_addbtn_CSS");

			// enter data in the nature of damage field
			type("ohs_incident_natureofdamagetxt_CSS", data.get("nature_of_damage"));

			// scroll down the screen
			scrollByPixel(500);

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

			// click on the next button
			click("ohs_incident_nextbtn_CSS");

			// synchronization
			explicitWait("ohs_incident_nextbtn_CSS");
			consoleMessage("Navigate to the insurance Tab.");

			// ADD DETAILS IN THE INSURANCE TAB
			title("ADD DETAILS IN THE INSURANCE TAB");

			// click on the add button
			click("ohs_incident_insurancetab_addbtn_CSS");

			// enter data in the company name field
			type("ohs_incident_insurance_companynametxt_CSS", data.get("company_name"));

			// enter data in the Claim Number field
			type("ohs_incident_insurance_claimnumbertxt_CSS", data.get("claim_number"));

			// scroll down the screen
			scrollByPixel(500);

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
			switchVerification("ohs_incident_addedinsurance_XPATH", "Add Company Name Test",
					"The Add Company Name Test is not displayed.");

			// ADD DETAILS IN THE ATTACHMENTS TAB
			title("ADD DETAILS IN THE ATTACHMENTS TAB");

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
			switchVerification("ohs_incident_addedincidentreport2_XPATH",
					"Describe Incident Text Dashboard Testing Purpose",
					"The Describe Incident Text Dashboard Testing Purpose is not displayed successfully.");
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
			explicitWaitClickable("menubtn_CSS");

			// click on the side menu icon
			click("menubtn_CSS");

			// wait for the element
			explicitWaitClickable("sidemenu_occupationalhealthandsafety_CSS");

			// click on the OHS option from side menu
			click("sidemenu_occupationalhealthandsafety_CSS");

			// VERIFY NEWLY CREATED INCIDENT REPORT ON EHS INCIDENT DASHBOARD
			title("VERIFY NEWLY CREATED INCIDENT REPORT ON EHS INCIDENT DASHBOARD");

			try {

				// wait for the element
				explicitWait("dashboard_CSS");

				// select the EHS Incident from the dashboard screen
				select("dashboard_CSS", data.get("ehs_incidents"));

				// wait for the element
				Thread.sleep(5000);

				LocalDate currentDate = LocalDate.now();
				String currentDateText = currentDate.toString();

				String incidentReport = "//tr[@ng-click='editReport(report)']//td[text()='" + insuranceNumber
						+ "']//following-sibling::td[text()='" + currentDateText + "']";

				consoleMessage("incidentReport::::::::::::::::::::" + incidentReport);

				boolean str = driver.findElement(By.xpath(incidentReport)).isDisplayed();
				if (str == true) {
					successMessage("The newly created incident report is verified successfully.");
				} else {
					verificationFailedMessage("The newly created incident report is not verified.");
				}

			} catch (Throwable t) {
				verificationFailedMessage("The newly created incident report is not verified.");
			}

			// VERIFY NEWLY CREATED INCIDENT REPORT ON HR INCIDENT DASHBOARD
			title("VERIFY NEWLY CREATED INCIDENT REPORT ON HR INCIDENT DASHBOARD");

			try {
				// select the HR Incident from the dashboard screen
				select("dashboard_CSS", data.get("hr_incidents"));

				// wait for the element
				Thread.sleep(5000);

				LocalDate currentDate = LocalDate.now();
				String currentDateText = currentDate.toString();

				String incidentReport1 = "//tr[@ng-click='editReport(report)']//td[text()='" + insuranceNumber
						+ "']//following-sibling::td[text()='" + currentDateText + "']";

				consoleMessage("incidentReport1::::::::::::::::::::" + incidentReport1);

				boolean str2 = driver.findElement(By.xpath(incidentReport1)).isDisplayed();
				if (str2 == true) {

					test.log(LogStatus.INFO, "The newly created incident report is verified successfully.");
					Reporter.log("The newly created incident report is verified successfully.");
					log.info("The newly created incident report is verified successfully.");
				} else {
					TestUtil.captureScreenshot();

					// ReportNG
					Reporter.log("<br>" + "Verification failure : " + "<br>");
					Reporter.log("<a target=\"_blank\" href=" + TestUtil.screenshotName + "><img src="
							+ TestUtil.screenshotName + " height=200 width=200></img></a>");
					Reporter.log("<br>");
					Reporter.log("<br>");

					// Extent Report
					test.log(LogStatus.FAIL, " Verification failed with exception : ");
					test.log(LogStatus.FAIL, test.addScreenCapture(TestUtil.screenshotName));

					log.info("The newly created incident report is not verified.");
				}

			} catch (Throwable t) {
				TestUtil.captureScreenshot();

				// ReportNG
				Reporter.log("<br>" + "Verification failure : " + "<br>");
				Reporter.log("<a target=\"_blank\" href=" + TestUtil.screenshotName + "><img src="
						+ TestUtil.screenshotName + " height=200 width=200></img></a>");
				Reporter.log("<br>");
				Reporter.log("<br>");

				// Extent Report
				test.log(LogStatus.FAIL, " Verification failed with exception : ");
				test.log(LogStatus.FAIL, test.addScreenCapture(TestUtil.screenshotName));

				log.info("The newly created incident report is not verified.");
			}

			// VERIFY NEWLY CREATED INCIDENT REPORT ON INSURANCE INCIDENT DASHBOARD

			consoleMessage(
					"********** VERIFY NEWLY CREATED INCIDENT REPORT ON INSURANCE INCIDENT DASHBOARD **********");
			test.log(LogStatus.INFO,
					"********** VERIFY NEWLY CREATED INCIDENT REPORT ON INSURANCE INCIDENT DASHBOARD **********");
			Reporter.log("********** VERIFY NEWLY CREATED INCIDENT REPORT ON INSURANCE INCIDENT DASHBOARD **********");
			log.info("********** VERIFY NEWLY CREATED INCIDENT REPORT ON INSURANCE INCIDENT DASHBOARD **********");

			try {
				// wait for the element
				explicitWait("dashboard_CSS");

				// select the Insurance Incident from the dashboard screen
				select("dashboard_CSS", data.get("insurance_incidents"));

				// wait for the element
				Thread.sleep(5000);

				LocalDate currentDate = LocalDate.now();
				String currentDateText = currentDate.toString();

				String incidentReport2 = "//tr[@ng-click='editReport(report)']//td[text()='" + insuranceNumber
						+ "']//following-sibling::td[text()='" + currentDateText + "']";

				consoleMessage("incidentReport2::::::::::::::::::::" + incidentReport2);

				boolean str3 = driver.findElement(By.xpath(incidentReport2)).isDisplayed();
				if (str3 == true) {
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

		// DELETE DETAILS IN THE INCIDENT REPORT
		title("DELETE DETAILS IN THE INCIDENT REPORT");

		try {
			// click on the OHS icon from the property list page
			click("ohsicon_CSS");

			// click on the burger menu
			click("menubtn_CSS");

			// wait for the element
			explicitWaitClickable("questionnaire_option_ohstab_incidentreports_XPATH");

			// click on the incident reports
			click("questionnaire_option_ohstab_incidentreports_XPATH");

			// click on the newly created incident report
			click("ohs_incident_addedincidentreport2_XPATH");

			// wait for the element
			Thread.sleep(5000);

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
			helper.deleteVerification("ohs_incident_addedincidentreport2_XPATH",
					"Describe Incident Text Dashboard Testing Purpose");

		} catch (Throwable t) {
			verificationFailed();
		}

		// click on the home icon from the top of the screen
		click("questionnaire_homeburgermenubtn_hide_CSS");

		// synchronization
		explicitWait("propertylist_title_XPATH");

		// verify the property list
		switchVerification("propertylist_title_XPATH", "Property List", "The property list is not displayed.");

		// VERIFY DELETED INCIDENT REPORT ON EHS INCIDENT DASHBOARD
		title("VERIFY DELETED INCIDENT REPORT ON EHS INCIDENT DASHBOARD");

		try {

			// wait for the element
			Thread.sleep(5000);

			// click on the side menu icon
			click("menubtn_CSS");

			// wait for the element
			Thread.sleep(5000);

			// click on the OHS option from side menu
			click("sidemenu_occupationalhealthandsafety_CSS");

			// wait for the element
			explicitWait("dashboard_CSS");

			// select the EHS Incident from the dashboard screen
			select("dashboard_CSS", data.get("ehs_incidents"));

			// wait for the element
			Thread.sleep(5000);

			// filter the respective incident report
			type("ohs_incident_dashboardfilter_XPATH", insuranceNumber);

			// hit the enter key
			driver.findElement(By.xpath(OR.getProperty("ohs_incident_dashboardfilter_XPATH"))).sendKeys(Keys.ENTER);

			// wait for the element
			Thread.sleep(5000);

			LocalDate currentDate = LocalDate.now();
			String currentDateText = currentDate.toString();

			String incidentReport = "//tr[@ng-click='editReport(report)']//td[text()='" + insuranceNumber
					+ "']//following-sibling::td[text()='" + currentDateText + "']";

			try {

				boolean str11 = driver.findElement(By.xpath(incidentReport)).isDisplayed();
				if (str11 == true) {
					verificationFailedMessage("The newly created incident report is displayed after delete.");
				} else {
					successMessage("The newly created incident report is deleted successfully.");
				}
			} catch (Throwable t) {
				successMessage("The newly created incident report is deleted successfully.");
			}

			// VERIFY DELETED INCIDENT REPORT ON HR INCIDENT DASHBOARD
			title("VERIFY DELETED INCIDENT REPORT ON HR INCIDENT DASHBOARD");

			// select the HR Incident from the dashboard screen
			select("dashboard_CSS", data.get("hr_incidents"));

			// wait for the element
			Thread.sleep(5000);

			// filter the respective incident report
			type("ohs_incident_dashboardfilter_XPATH", insuranceNumber);

			// hit the enter key
			driver.findElement(By.xpath(OR.getProperty("ohs_incident_dashboardfilter_XPATH"))).sendKeys(Keys.ENTER);
			consoleMessage("Hit the enter key.");

			// wait for the element
			Thread.sleep(5000);

			LocalDate currentDate1 = LocalDate.now();
			String currentDateText1 = currentDate1.toString();

			String incidentReport1 = "//tr[@ng-click='editReport(report)']//td[text()='" + insuranceNumber
					+ "']//following-sibling::td[text()='" + currentDateText1 + "']";

			try {

				boolean str22 = driver.findElement(By.xpath(incidentReport1)).isDisplayed();

				if (str22 == true) {
					verificationFailedMessage("The newly created incident report is displayed after delete.");
				} else {
					successMessage("The newly created incident report is deleted successfully.");
				}
			} catch (Throwable t) {
				successMessage("The newly created incident report is deleted successfully.");
			}

			// VERIFY DELETED INCIDENT REPORT ON INSURANCE INCIDENT DASHBOARD
			title("VERIFY DELETED INCIDENT REPORT ON INSURANCE INCIDENT DASHBOARD");

			// wait for the element
			explicitWait("dashboard_CSS");

			// select the Insurance Incident from the dashboard screen
			select("dashboard_CSS", data.get("insurance_incidents"));

			// wait for the element
			Thread.sleep(5000);

			// filter the respective incident report
			type("ohs_incident_dashboardfilter_XPATH", insuranceNumber);

			// hit the enter key
			driver.findElement(By.xpath(OR.getProperty("ohs_incident_dashboardfilter_XPATH"))).sendKeys(Keys.ENTER);

			// wait for the element
			Thread.sleep(5000);

			LocalDate currentDate2 = LocalDate.now();
			String currentDateText2 = currentDate2.toString();

			String incidentReport2 = "//tr[@ng-click='editReport(report)']//td[text()='" + insuranceNumber
					+ "']//following-sibling::td[text()='" + currentDateText2 + "']";

			try {

				boolean str33 = driver.findElement(By.xpath(incidentReport2)).isDisplayed();

				if (str33 == true) {
					verificationFailedMessage("The newly created incident report is displayed after delete.");
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
