package testcases.E2Etestcasesuite.sustainabilitymodule;

import java.io.IOException;
import java.time.LocalDate;
import java.util.Hashtable;

import org.apache.commons.lang3.RandomStringUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.SkipException;
import org.testng.annotations.Test;

import com.relevantcodes.extentreports.LogStatus;

import base.Helper;
import base.TestBase;
import utilities.TestUtil;

public class RR5964Sustainability7Test extends TestBase {

	@Test(dataProviderClass = TestUtil.class, dataProvider = "dp")
	public void rR5964Sustainability7Test(Hashtable<String, String> data) throws IOException, InterruptedException {

		execution(data, "rR5964Sustainability7Test");

		// VALIDATE THE PERFORMANCE DATA VALIDATION OF THE UTILITY BILLS
		title("VALIDATE THE PERFORMANCE DATA VALIDATION OF THE UTILITY BILLS");

		// refresh the page
		driver.navigate().refresh();
		Thread.sleep(5000);
		driver.navigate().refresh();

		// MAKE UTILITY BILL AS A UNVERIFIED FROM THE PERFORMANCE DATA VALIDATION MODULE
		title("MAKE UTILITY BILL AS A UNVERIFIED FROM THE PERFORMANCE DATA VALIDATION MODULE");

		try {
			// enter the property name in the search field
			type("envreports_propertylist_filtertxt_CSS", data.get("property_1"));

			// click on the Sustainability icon
			click("sustainabilityicon_CSS");

			// wait for the element
			Thread.sleep(5000);

			// click on the side menu
			click("ssc_leftsidemenubtn_CSS");

			// wait for the element
			Thread.sleep(5000);

			// scroll down the screen
			scrollTillElement("sustainability_utilitybills_buildingperformancedataoption_XPATH");

			// click on the building performance data
			click("sustainability_utilitybills_buildingperformancedataoption_XPATH");

			// scroll down the side menu
			scrollTillElement("sustainability_utilitybills_performancedatavalidationoption_XPATH");

			// click on the performance data validation
			click("sustainability_utilitybills_performancedatavalidationoption_XPATH");

			// click on the clear all button
			click("sustainability_utilitybills_datavalidation_clearall_XPATH");

			// wait for the element
			Thread.sleep(5000);

		} catch (Throwable t) {
			verificationFailed();
		}

		// click on the home icon from the top of the screen
		click("questionnaire_homeburgermenubtn_hide_CSS");

		// synchronization
		explicitWait("propertylist_title_XPATH");

		// verify the property list
		switchVerification("propertylist_title_XPATH", "Property List", "The property list is not displayed.");

		// CREATE NEW UTILITY BILLS RECORD - AT PROPERTY LEVEL
		title("CREATE NEW UTILITY BILLS RECORD - AT PROPERTY LEVEL");

		String utilityBills = RandomStringUtils.randomNumeric(8);

		try {

			// enter the property name in the search field
			type("envreports_propertylist_filtertxt_CSS", data.get("property_1"));

			// click on the Sustainability icon
			click("sustainabilityicon_CSS");

			// wait for the element
			Thread.sleep(5000);

			// click on the side menu
			click("ssc_leftsidemenubtn_CSS");

			// wait for the element
			Thread.sleep(5000);

			// click on the utility bills option
			click("sustainability_sidemenu_utilitybillsoption_XPATH");

			// click on the add button
			click("sustainability_utilitybills_addbtn_XPATH");

			// click on the yes button of the tenant paid field
			click("sustainability_utilitybills_tenantpaidyes_XPATH");

			// click on the yes button of the Estimated field
			click("sustainability_utilitybills_estimatedyes_XPATH");

			// enter the details in the Period From field
			LocalDate addDate1 = LocalDate.now().minusMonths(6);
			String addDate1_String = addDate1.toString();
			type("sustainability_utilitybills_periodfrom_XPATH", addDate1_String);

			// enter the details in the Period To field
			LocalDate addDate2 = LocalDate.now().plusMonths(6);
			String addDate2_String = addDate2.toString();
			type("sustainability_utilitybills_periodto_XPATH", addDate2_String);

			// enter details in the Number of Billing Days field
			type("sustainability_utilitybills_numberofbillingdays_XPATH", "365");

			// enter the details in the reading date field
			LocalDate addDate3 = LocalDate.now();
			String addDate3_String = addDate3.toString();
			type("sustainability_utilitybills_readingdate_XPATH", addDate3_String);

			// enter details in the Current Meter Reading field
			type("sustainability_utilitybills_currentmeterreading_XPATH", "150");

			// enter details in the Last Meter Reading field
			type("sustainability_utilitybills_lastmeterreading_XPATH", "120");

			// enter details in the Meter Number field
			type("sustainability_utilitybills_meternumber_XPATH", utilityBills);

			// enter the details in the Billing Date field
			LocalDate addDate4 = LocalDate.now().plusDays(5);
			String addDate4_String = addDate4.toString();
			type("sustainability_utilitybills_billingdate_XPATH", addDate4_String);

			// enter details in the Consumption field
			String random2 = RandomStringUtils.randomNumeric(2);
			type("sustainability_utilitybills_consumption_XPATH", random2);

			// enter details in the Adjusted Consumption field
			type("sustainability_utilitybills_adjustedconsumption_XPATH", "0");

			// select the Unit of Measure option from the dropdown
			select("sustainability_utilitybills_unitofmeasure_XPATH", data.get("unit"));

			// enter details in the Peak Demand field
			type("sustainability_utilitybills_peakdemand_XPATH", "10");

			// select the Peak Demand Unit of Measure option from the dropdown
			select("sustainability_utilitybills_peakdemandunitofmeasure_XPATH", data.get("unit"));

			// enter details in the Total Cost field
			type("sustainability_utilitybills_totalcost_XPATH", "100");

			// enter details in the Reference Number field
			String random3 = RandomStringUtils.randomNumeric(8);
			type("sustainability_utilitybills_referencenumber_XPATH", random3);

			// enter details in the Control Number field
			String random4 = RandomStringUtils.randomNumeric(8);
			type("sustainability_utilitybills_controlnumber_XPATH", random4);

			// enter details in the Multiplier field
			String random5 = RandomStringUtils.randomNumeric(2);
			type("sustainability_utilitybills_multiplier_XPATH", random5);

			// enter details in the Description field
			type("sustainability_utilitybills_description_XPATH", data.get("description"));

			// click on the save button
			click("sustainability_utilitybills_saverecordbtn_XPATH");

			// wait for the element
			explicitWaitClickable("closetoastmsg_CSS");

			// click on the toaster close button
			click("closetoastmsg_CSS");

			// ========= TEMPORARY CODE - BELOW =========

			// click on the utility filter
			click("sustainability_utilitybills_filter_utilitybtn_XPATH");

			// click on the clear button
			click("sustainability_utilitybills_filter_clearbtn_XPATH");

			// enter utility in the search field
			type("sustainability_utilitybills_filter_searchtxt_XPATH", "Electricity");

			// click on the searched result
			click("sustainability_utilitybills_filter_searchedresult_XPATH");

			// select the all option from the meter filter
			select("sustainability_utilitybills_meterfilter_XPATH", "All");

			// ========= TEMPORARY CODE - ABOVE =========

			// click on the refresh button
			click("sustainability_utilitybills_refreshbtn_XPATH");

			// enter the newly created certification record in the search field
			type("sustainability_searchtxt_XPATH", utilityBills);

			// verify the newly created utility meter record
			try {
				String UtilityBills = "//td[contains(text(),'" + utilityBills + "')]";
				String addedUtilityBills = (driver.findElement(By.xpath(UtilityBills)).getText()).trim();
				if (addedUtilityBills.equals(utilityBills)) {

					test.log(LogStatus.INFO, "The utility bills is verified successfully.");
					Reporter.log("The utility bills is verified successfully.");
					log.info("The utility bills is verified successfully.");
				} else {
					verificationFailed();

					test.log(LogStatus.INFO, "The utility bills is not verified.");
					Reporter.log("The utility bills is not verified.");
					log.info("The utility bills is not verified.");
				}
			} catch (Throwable t) {
				verificationFailed();
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

		// RUN THE BATCH FOR THE ELECRICITY UTILITY
		title("RUN THE BATCH FOR THE ELECRICITY UTILITY");

		try {

			// wait for the element
			explicitWaitClickable("questionnaire_settingicon_CSS");

			// click on the settings icon from the top of the screen
			click("questionnaire_settingicon_CSS");

			// wait for the element
			explicitWaitClickable("questionnaire_administrationoption_XPATH");

			// click on the Administration option from the side menu
			click("questionnaire_administrationoption_XPATH");

			// click on the system tab
			click("questionnaire_systemtab_XPATH");

			// click on the Batch Processes option
			click("questionnaire_batchprocesssoption_XPATH");

			// enter the batch name in the search name
			type("sustainability_searchtxt_XPATH", data.get("batch"));

			// wait for the element
			Thread.sleep(5000);

			// click on the play button of the searched batch process
			click("sustainability_utilitybills_batchprocess_playbtn_XPATH");

			// wait for the element
			Thread.sleep(5000);

			// click on the run button
			click("sustainability_utilitybills_batchprocess_runbtn_XPATH");

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

		// MAKE UTILITY BILL AS A VERIFIED FROM THE PERFORMANCE DATA VALIDATION MODULE
		title("MAKE UTILITY BILL AS A VERIFIED FROM THE PERFORMANCE DATA VALIDATION MODULE");

		try {
			// enter the property name in the search field
			type("envreports_propertylist_filtertxt_CSS", data.get("property_1"));

			// click on the Sustainability icon
			click("sustainabilityicon_CSS");

			// wait for the element
			Thread.sleep(5000);

			// click on the side menu
			click("ssc_leftsidemenubtn_CSS");

			// wait for the element
			Thread.sleep(5000);

			// scroll down the screen
			scrollTillElement("sustainability_utilitybills_buildingperformancedataoption_XPATH");

			// click on the building performance data
			click("sustainability_utilitybills_buildingperformancedataoption_XPATH");

			// scroll down the side menu
			scrollTillElement("sustainability_utilitybills_performancedatavalidationoption_XPATH");

			// click on the performance data validation
			click("sustainability_utilitybills_performancedatavalidationoption_XPATH");

			// enter the meter name in the search field

			type("sustainability_searchtxt_XPATH", utilityBills);

			// click on the searched meter record
			String meter = "(//td[text()='" + utilityBills + "'])[1]";
			driver.findElement(By.xpath(meter)).click();

			// click on the verify all button
			click("sustainability_utilitybills_datavalidation_verifyall_XPATH");

			// click on the save button
			click("sustainability_utility_performancedata_savebtn_XPATH");

			// wait for the element
			Thread.sleep(10000);

		} catch (Throwable t) {
			verificationFailed();
		}

		// click on the home icon from the top of the screen
		click("questionnaire_homeburgermenubtn_hide_CSS");

		// synchronization
		explicitWait("propertylist_title_XPATH");

		// verify the property list
		switchVerification("propertylist_title_XPATH", "Property List", "The property list is not displayed.");

		// DELETE THE UPDATED UTILITY BILLS RECORD AFTER VERIFIED
		title("DELETE THE UPDATED UTILITY BILLS RECORD AFTER VERIFIED");

		try {

			// enter the property name in the search field
			type("envreports_propertylist_filtertxt_CSS", data.get("property_1"));

			// click on the Sustainability icon
			click("sustainabilityicon_CSS");

			// wait for the element
			Thread.sleep(5000);

			// click on the side menu
			click("ssc_leftsidemenubtn_CSS");

			// wait for the element
			Thread.sleep(5000);

			// click on the utility bills option
			click("sustainability_sidemenu_utilitybillsoption_XPATH");

			// ========= TEMPORARY CODE - BELOW =========

			// click on the utility filter
			click("sustainability_utilitybills_filter_utilitybtn_XPATH");

			// click on the clear button
			click("sustainability_utilitybills_filter_clearbtn_XPATH");

			// enter utility in the search field
			type("sustainability_utilitybills_filter_searchtxt_XPATH", "Electricity");

			// click on the searched result
			click("sustainability_utilitybills_filter_searchedresult_XPATH");

			// select the current year in the dropdown
			LocalDate today = LocalDate.now();
			String[] todayDate = today.toString().split("-");
			select("sustainability_utilitybills_yearfilterdd_XPATH", todayDate[0]);

			// select the all option from the meter filter
			select("sustainability_utilitybills_meterfilter_XPATH", "All");

			// ========= TEMPORARY CODE - ABOVE =========

			// click on the refresh button
			click("sustainability_utilitybills_refreshbtn_XPATH");

			// click on the updated utility bill record
			LocalDate deleteDate = LocalDate.now().minusMonths(6);
			String deleteDate_String = deleteDate.toString();
			String UtilityBills3 = "//td[contains(text(),'" + deleteDate_String + "')]";
			driver.findElement(By.xpath(UtilityBills3)).click();

			// click on the delete button
			click("sustainability_utilitybills_deletebtn_XPATH");

			// wait for the element
			explicitWaitClickable("sustainability_utilitybills_deletebtn_confirmation_XPATH");

			// click on the delete button of the confirmation popup
			click("sustainability_utilitybills_deletebtn_confirmation_XPATH");

			// wait for the element
			Thread.sleep(5000);

			// verify the validation message is displayed or not
			try {

				boolean validationMessage = driver
						.findElement(By.xpath(
								OR.getProperty("sustainability_utility_performancedata_validationmessage_XPATH")))
						.isDisplayed();

				if (validationMessage == true) {

					successMessage("The validation message is displayed.");

					// click on the ok button
					click("sustainability_utility_performancedata_okbtn_XPATH");

				} else {
					verificationFailedMessage("The validation message is not displayed.");

					// refresh the screen
					driver.navigate().refresh();
					Thread.sleep(5000);
					driver.navigate().refresh();
				}

			} catch (Throwable t) {

				verificationFailedMessage("The validation message is not displayed.");
				// refresh the screen
				driver.navigate().refresh();
				Thread.sleep(5000);
				driver.navigate().refresh();
			}

		} catch (Throwable t) {
			verificationFailed();

			// refresh the screen
			driver.navigate().refresh();
			Thread.sleep(5000);
			driver.navigate().refresh();
		}

		// click on the home icon from the top of the screen
		click("questionnaire_homeburgermenubtn_hide_CSS");

		// synchronization
		explicitWait("propertylist_title_XPATH");

		// verify the property list
		switchVerification("propertylist_title_XPATH", "Property List", "The property list is not displayed.");

		// MAKE UTILITY BILL AS A UNVERIFIED FROM THE PERFORMANCE DATA VALIDATION MODULE
		title("MAKE UTILITY BILL AS A UNVERIFIED FROM THE PERFORMANCE DATA VALIDATION MODULE");

		try {
			// enter the property name in the search field
			type("envreports_propertylist_filtertxt_CSS", data.get("property_1"));

			// click on the Sustainability icon
			click("sustainabilityicon_CSS");

			// wait for the element
			Thread.sleep(5000);

			// click on the side menu
			click("ssc_leftsidemenubtn_CSS");

			// wait for the element
			Thread.sleep(5000);

			// scroll down the screen
			scrollTillElement("sustainability_utilitybills_buildingperformancedataoption_XPATH");

			// click on the building performance data
			click("sustainability_utilitybills_buildingperformancedataoption_XPATH");

			// scroll down the side menu
			scrollTillElement("sustainability_utilitybills_performancedatavalidationoption_XPATH");

			// click on the performance data validation
			click("sustainability_utilitybills_performancedatavalidationoption_XPATH");

			// enter the meter name in the search field
			type("sustainability_searchtxt_XPATH", utilityBills);

			// click on the searched meter record
			String meter = "(//td[text()='" + utilityBills + "'])[1]";
			driver.findElement(By.xpath(meter)).click();

			// click on the clear all button
			click("sustainability_utilitybills_datavalidation_clearall_XPATH");

			// click on the save button
			click("sustainability_utility_performancedata_savebtn_XPATH");

		} catch (Throwable t) {
			verificationFailed();
		}

		// click on the home icon from the top of the screen
		click("questionnaire_homeburgermenubtn_hide_CSS");

		// synchronization
		explicitWait("propertylist_title_XPATH");

		// verify the property list
		switchVerification("propertylist_title_XPATH", "Property List", "The property list is not displayed.");

		// DELETE THE UTILITY BILLS RECORD
		title("DELETE THE UTILITY BILLS RECORD");

		try {

			// enter the property name in the search field
			type("envreports_propertylist_filtertxt_CSS", data.get("property_1"));

			// click on the Sustainability icon
			click("sustainabilityicon_CSS");

			// wait for the element
			Thread.sleep(5000);

			// click on the side menu
			click("ssc_leftsidemenubtn_CSS");

			// wait for the element
			Thread.sleep(5000);

			// click on the utility bills option
			click("sustainability_sidemenu_utilitybillsoption_XPATH");

			// ========= TEMPORARY CODE - BELOW =========

			// click on the utility filter
			click("sustainability_utilitybills_filter_utilitybtn_XPATH");

			// click on the clear button
			click("sustainability_utilitybills_filter_clearbtn_XPATH");

			// enter utility in the search field
			type("sustainability_utilitybills_filter_searchtxt_XPATH", "Electricity");

			// click on the searched result
			click("sustainability_utilitybills_filter_searchedresult_XPATH");

			// select the current year in the dropdown
			LocalDate today = LocalDate.now();
			String[] todayDate = today.toString().split("-");
			select("sustainability_utilitybills_yearfilterdd_XPATH", todayDate[0]);

			// select the all option from the meter filter
			select("sustainability_utilitybills_meterfilter_XPATH", "All");

			// ========= TEMPORARY CODE - ABOVE =========

			// click on the refresh button
			click("sustainability_utilitybills_refreshbtn_XPATH");

			// click on the updated utility bill record
			LocalDate deleteDate = LocalDate.now().minusMonths(6);
			String deleteDate_String = deleteDate.toString();
			String UtilityBills3 = "//td[contains(text(),'" + deleteDate_String + "')]";
			driver.findElement(By.xpath(UtilityBills3)).click();

			// click on the delete button
			click("sustainability_utilitybills_deletebtn_XPATH");

			// wait for the element
			explicitWaitClickable("sustainability_utilitybills_deletebtn_confirmation_XPATH");

			// click on the delete button of the confirmation popup
			click("sustainability_utilitybills_deletebtn_confirmation_XPATH");

			// wait for the element
			explicitWaitClickable("closetoastmsg_CSS");

			// click on the toaster close button
			click("closetoastmsg_CSS");

			// enter the updated utility meter record in the search field
			type("sustainability_searchtxt_XPATH", utilityBills);

			// verify the deleted utility bill record displayed or not

			try {

				String UpdateUtilityBills1 = "//td[contains(text(),'" + utilityBills + "')]";
				String updatedUtilityBills1 = (driver.findElement(By.xpath(UpdateUtilityBills1)).getText()).trim();

				if (updatedUtilityBills1.equals(utilityBills)) {

					verificationFailedMessage("The utility bill is not deleted.");

				}
			} catch (Throwable t) {

				successMessage("The utility bill is deleted successfully.");

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