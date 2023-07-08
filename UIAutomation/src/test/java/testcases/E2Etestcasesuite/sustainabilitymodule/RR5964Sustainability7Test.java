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

		Helper helper = new Helper();

		// VALIDATE THE PERFORMANCE DATA VALIDATION OF THE UTILITY BILLS

		System.out.println("VALIDATE THE PERFORMANCE DATA VALIDATION OF THE UTILITY BILLS");
		test.log(LogStatus.INFO, "VALIDATE THE PERFORMANCE DATA VALIDATION OF THE UTILITY BILLS");
		Reporter.log("VALIDATE THE PERFORMANCE DATA VALIDATION OF THE UTILITY BILLS");
		log.info("VALIDATE THE PERFORMANCE DATA VALIDATION OF THE UTILITY BILLS");

		// refresh the page
		driver.navigate().refresh();
		Thread.sleep(5000);
		driver.navigate().refresh();

		System.out.println("Navigate to the Home Screen i.e. Property List Screen.");

		// MAKE UTILITY BILL AS A UNVERIFIED FROM THE PERFORMANCE DATA VALIDATION MODULE

		title("MAKE UTILITY BILL AS A UNVERIFIED FROM THE PERFORMANCE DATA VALIDATION MODULE");

		try {
			// enter the property name in the search field
			type("envreports_propertylist_filtertxt_CSS", data.get("property_1"));
			ngDriver.waitForAngularRequestsToFinish();
			System.out.println("Entered the property name in the search field.");

			// click on the Sustainability icon
			click("sustainabilityicon_CSS");
			System.out.println("Clicked on the Sustainability icon.");
			ngDriver.waitForAngularRequestsToFinish();

			// wait for the element
			Thread.sleep(5000);

			// click on the side menu
			click("ssc_leftsidemenubtn_CSS");
			ngDriver.waitForAngularRequestsToFinish();
			System.out.println("Clicked on the side menu.");

			// wait for the element
			Thread.sleep(5000);

			// scroll down the screen
			scrollTillElement("sustainability_utilitybills_buildingperformancedataoption_XPATH");

			// click on the building performance data
			click("sustainability_utilitybills_buildingperformancedataoption_XPATH");
			ngDriver.waitForAngularRequestsToFinish();
			System.out.println("Clicked on the building performance data.");

			// scroll down the side menu
			scrollTillElement("sustainability_utilitybills_performancedatavalidationoption_XPATH");

			// click on the performance data validation
			click("sustainability_utilitybills_performancedatavalidationoption_XPATH");
			ngDriver.waitForAngularRequestsToFinish();
			System.out.println("Clicked on the performance data validation.");

			// click on the clear all button
			click("sustainability_utilitybills_datavalidation_clearall_XPATH");
			ngDriver.waitForAngularRequestsToFinish();
			System.out.println("Clicked on the clear all button.");

			// wait for the element
			Thread.sleep(5000);

		} catch (Throwable t) {
			verificationFailed();
		}

		// click on the home icon from the top of the screen
		click("questionnaire_homeburgermenubtn_hide_CSS");
		System.out.println("Clicked on the home icon from the top of the screen.");
		ngDriver.waitForAngularRequestsToFinish();

		// synchronization
		explicitWait("propertylist_title_XPATH");

		// verify the property list
		switchVerification("propertylist_title_XPATH", "Property List", "The property list is not displayed.");

		// CREATE NEW UTILITY BILLS RECORD - AT PROPERTY LEVEL

		System.out.println("***************** CREATE NEW UTILITY BILLS RECORD - AT PROPERTY LEVEL *****************");
		test.log(LogStatus.INFO,
				"***************** CREATE NEW UTILITY BILLS RECORD - AT PROPERTY LEVEL *****************");
		Reporter.log("***************** CREATE NEW UTILITY BILLS RECORD - AT PROPERTY LEVEL *****************");
		log.info("***************** CREATE NEW UTILITY BILLS RECORD - AT PROPERTY LEVEL *****************");

		String utilityBills = RandomStringUtils.randomNumeric(8);

		try {

			// enter the property name in the search field
			type("envreports_propertylist_filtertxt_CSS", data.get("property_1"));
			ngDriver.waitForAngularRequestsToFinish();
			System.out.println("Entered the property name in the search field.");

			// click on the Sustainability icon
			click("sustainabilityicon_CSS");
			System.out.println("Clicked on the Sustainability icon.");
			ngDriver.waitForAngularRequestsToFinish();

			// wait for the element
			Thread.sleep(5000);

			// click on the side menu
			click("ssc_leftsidemenubtn_CSS");
			ngDriver.waitForAngularRequestsToFinish();
			System.out.println("Clicked on the side menu.");

			// wait for the element
			Thread.sleep(5000);

			// click on the utility bills option
			click("sustainability_sidemenu_utilitybillsoption_XPATH");
			ngDriver.waitForAngularRequestsToFinish();
			System.out.println("Clicked on the utility bills option.");

			// click on the add button
			click("sustainability_utilitybills_addbtn_XPATH");
			ngDriver.waitForAngularRequestsToFinish();
			System.out.println("Clicked on the add button.");

			// click on the yes button of the tenant paid field
			click("sustainability_utilitybills_tenantpaidyes_XPATH");
			ngDriver.waitForAngularRequestsToFinish();
			System.out.println("Clicked on the yes button of the tenant paid field.");

			// click on the yes button of the Estimated field
			click("sustainability_utilitybills_estimatedyes_XPATH");
			ngDriver.waitForAngularRequestsToFinish();
			System.out.println("Clicked on the yes button of the Estimated field.");

			// enter the details in the Period From field
			LocalDate addDate1 = LocalDate.now().minusMonths(6);
			String addDate1_String = addDate1.toString();
			clear("sustainability_utilitybills_periodfrom_XPATH");
			type("sustainability_utilitybills_periodfrom_XPATH", addDate1_String);
			ngDriver.waitForAngularRequestsToFinish();
			System.out.println("Entered the details in the Period From field.");

			// enter the details in the Period To field
			LocalDate addDate2 = LocalDate.now().plusMonths(6);
			String addDate2_String = addDate2.toString();
			clear("sustainability_utilitybills_periodto_XPATH");
			type("sustainability_utilitybills_periodto_XPATH", addDate2_String);
			ngDriver.waitForAngularRequestsToFinish();
			System.out.println("Entered the details in the Period To field.");

			// enter details in the Number of Billing Days field
			clear("sustainability_utilitybills_numberofbillingdays_XPATH");
			type("sustainability_utilitybills_numberofbillingdays_XPATH", "365");
			ngDriver.waitForAngularRequestsToFinish();
			System.out.println("Entered details in the Number of Billing Days field.");

			// enter the details in the reading date field
			LocalDate addDate3 = LocalDate.now();
			String addDate3_String = addDate3.toString();
			clear("sustainability_utilitybills_readingdate_XPATH");
			type("sustainability_utilitybills_readingdate_XPATH", addDate3_String);
			ngDriver.waitForAngularRequestsToFinish();
			System.out.println("Entered the details in the reading date field.");

			// enter details in the Current Meter Reading field
			clear("sustainability_utilitybills_currentmeterreading_XPATH");
			type("sustainability_utilitybills_currentmeterreading_XPATH", "150");
			ngDriver.waitForAngularRequestsToFinish();
			System.out.println("Entered details in the Current Meter Reading field.");

			// enter details in the Last Meter Reading field
			clear("sustainability_utilitybills_lastmeterreading_XPATH");
			type("sustainability_utilitybills_lastmeterreading_XPATH", "120");
			ngDriver.waitForAngularRequestsToFinish();
			System.out.println("Entered details in the Last Meter Reading field.");

			// enter details in the Meter Number field
			clear("sustainability_utilitybills_meternumber_XPATH");
			type("sustainability_utilitybills_meternumber_XPATH", utilityBills);
			ngDriver.waitForAngularRequestsToFinish();
			System.out.println("Entered details in the Meter Number field.");

			// enter the details in the Billing Date field
			LocalDate addDate4 = LocalDate.now().plusDays(5);
			String addDate4_String = addDate4.toString();
			clear("sustainability_utilitybills_billingdate_XPATH");
			type("sustainability_utilitybills_billingdate_XPATH", addDate4_String);
			ngDriver.waitForAngularRequestsToFinish();
			System.out.println("Entered the details in the Billing Date field.");

			// enter details in the Consumption field
			String random2 = RandomStringUtils.randomNumeric(2);
			clear("sustainability_utilitybills_consumption_XPATH");
			type("sustainability_utilitybills_consumption_XPATH", random2);
			ngDriver.waitForAngularRequestsToFinish();
			System.out.println("Entered details in the Consumption field.");

			// enter details in the Adjusted Consumption field
			clear("sustainability_utilitybills_adjustedconsumption_XPATH");
			type("sustainability_utilitybills_adjustedconsumption_XPATH", "0");
			ngDriver.waitForAngularRequestsToFinish();
			System.out.println("Entered details in the Adjusted Consumption field.");

			// select the Unit of Measure option from the dropdown
			select("sustainability_utilitybills_unitofmeasure_XPATH", data.get("unit"));
			ngDriver.waitForAngularRequestsToFinish();
			System.out.println("Selected the Unit of Measure option from the dropdown.");

			// enter details in the Peak Demand field
			clear("sustainability_utilitybills_peakdemand_XPATH");
			type("sustainability_utilitybills_peakdemand_XPATH", "10");
			ngDriver.waitForAngularRequestsToFinish();
			System.out.println("Entered details in the Peak Demand field.");

			// select the Peak Demand Unit of Measure option from the dropdown
			select("sustainability_utilitybills_peakdemandunitofmeasure_XPATH", data.get("unit"));
			ngDriver.waitForAngularRequestsToFinish();
			System.out.println("Selected the Peak Demand Unit of Measure option from the dropdown.");

			// enter details in the Total Cost field
			clear("sustainability_utilitybills_totalcost_XPATH");
			type("sustainability_utilitybills_totalcost_XPATH", "100");
			ngDriver.waitForAngularRequestsToFinish();
			System.out.println("Entered details in the Total Cost field.");

			// enter details in the Reference Number field
			String random3 = RandomStringUtils.randomNumeric(8);
			clear("sustainability_utilitybills_referencenumber_XPATH");
			type("sustainability_utilitybills_referencenumber_XPATH", random3);
			ngDriver.waitForAngularRequestsToFinish();
			System.out.println("Entered details in the Reference Number field.");

			// enter details in the Control Number field
			String random4 = RandomStringUtils.randomNumeric(8);
			clear("sustainability_utilitybills_controlnumber_XPATH");
			type("sustainability_utilitybills_controlnumber_XPATH", random4);
			ngDriver.waitForAngularRequestsToFinish();
			System.out.println("Entered details in the Control Number field.");

			// enter details in the Multiplier field
			String random5 = RandomStringUtils.randomNumeric(2);
			clear("sustainability_utilitybills_multiplier_XPATH");
			type("sustainability_utilitybills_multiplier_XPATH", random5);
			ngDriver.waitForAngularRequestsToFinish();
			System.out.println("Entered details in the Multiplier field.");

			// enter details in the Description field
			clear("sustainability_utilitybills_description_XPATH");
			type("sustainability_utilitybills_description_XPATH", data.get("description"));
			ngDriver.waitForAngularRequestsToFinish();
			System.out.println("Entered details in the Description field.");

			// click on the save button
			click("sustainability_utilitybills_saverecordbtn_XPATH");
			ngDriver.waitForAngularRequestsToFinish();
			System.out.println("Clicked on the save button.");

			// wait for the element
			explicitWaitClickable("closetoastmsg_CSS");

			// click on the toaster close button
			click("closetoastmsg_CSS");
			ngDriver.waitForAngularRequestsToFinish();
			System.out.println("Clicked on the toaster close button.");

			// ========= TEMPORARY CODE - BELOW =========

			// click on the utility filter
			click("sustainability_utilitybills_filter_utilitybtn_XPATH");
			ngDriver.waitForAngularRequestsToFinish();
			System.out.println("Clicked on the utility filter.");

			// click on the clear button
			click("sustainability_utilitybills_filter_clearbtn_XPATH");
			ngDriver.waitForAngularRequestsToFinish();
			System.out.println("Clicked on the clear button.");

			// enter utility in the search field
			clear("sustainability_utilitybills_filter_searchtxt_XPATH");
			type("sustainability_utilitybills_filter_searchtxt_XPATH", "Electricity");
			ngDriver.waitForAngularRequestsToFinish();
			System.out.println("enter utility in the search field");

			// click on the searched result
			click("sustainability_utilitybills_filter_searchedresult_XPATH");
			ngDriver.waitForAngularRequestsToFinish();
			System.out.println("Clicked on the searched result.");

			// select the all option from the meter filter
			select("sustainability_utilitybills_meterfilter_XPATH", "All");
			ngDriver.waitForAngularRequestsToFinish();
			System.out.println("Selected the all option from the meter filter.");

			// ========= TEMPORARY CODE - ABOVE =========

			// click on the refresh button
			click("sustainability_utilitybills_refreshbtn_XPATH");
			ngDriver.waitForAngularRequestsToFinish();
			System.out.println("Clicked on the refresh button.");

			// enter the newly created certification record in the search field
			clear("sustainability_searchtxt_XPATH");
			type("sustainability_searchtxt_XPATH", utilityBills);
			ngDriver.waitForAngularRequestsToFinish();
			System.out.println("Entered the newly created certification record in the search field.");

			// verify the newly created utility meter record
			try {
				String UtilityBills = "//td[contains(text(),'" + utilityBills + "')]";
				String addedUtilityBills = (driver.findElement(By.xpath(UtilityBills)).getText()).trim();
				if (addedUtilityBills.equals(utilityBills)) {

					System.out.println("The utility bills is verified successfully.");
					test.log(LogStatus.INFO, "The utility bills is verified successfully.");
					Reporter.log("The utility bills is verified successfully.");
					log.info("The utility bills is verified successfully.");
				} else {
					verificationFailed();

					System.out.println("The utility bills is not verified.");
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
		System.out.println("Clicked on the home icon from the top of the screen.");
		ngDriver.waitForAngularRequestsToFinish();

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
			System.out.println("Clicked on the settings icon.");
			ngDriver.waitForAngularRequestsToFinish();

			// wait for the element
			explicitWaitClickable("questionnaire_administrationoption_XPATH");

			// click on the Administration option from the side menu
			click("questionnaire_administrationoption_XPATH");
			System.out.println("Clicked on the Administration option from the side menu.");
			ngDriver.waitForAngularRequestsToFinish();

			// click on the system tab
			click("questionnaire_systemtab_XPATH");
			System.out.println("Clicked on the system tab.");
			ngDriver.waitForAngularRequestsToFinish();

			// click on the Batch Processes option
			click("questionnaire_batchprocesssoption_XPATH");
			System.out.println("Clicked on the Batch Processes option.");
			ngDriver.waitForAngularRequestsToFinish();

			// enter the batch name in the search name
			type("sustainability_searchtxt_XPATH", data.get("batch"));
			ngDriver.waitForAngularRequestsToFinish();
			System.out.println("Entered the batch name in the search name.");

			// wait for the element
			Thread.sleep(5000);

			// click on the play button of the searched batch process
			click("sustainability_utilitybills_batchprocess_playbtn_XPATH");
			ngDriver.waitForAngularRequestsToFinish();
			System.out.println("Clicked on the play button of the searched batch process.");

			// wait for the element
			Thread.sleep(5000);

			// click on the run button
			click("sustainability_utilitybills_batchprocess_runbtn_XPATH");
			ngDriver.waitForAngularRequestsToFinish();
			System.out.println("Clicked on the run button.");

			// wait for the element
			explicitWaitClickable("closetoastmsg_CSS");

			// click on the toaster close button
			click("closetoastmsg_CSS");
			ngDriver.waitForAngularRequestsToFinish();
			System.out.println("Clicked on the toaster close button.");

		} catch (Throwable t) {
			verificationFailed();
		}

		// click on the home icon from the top of the screen
		click("questionnaire_homeburgermenubtn_CSS");
		System.out.println("Clicked on the home icon from the top of the screen.");
		ngDriver.waitForAngularRequestsToFinish();

		// synchronization
		explicitWait("propertylist_title_XPATH");

		// verify the property list
		switchVerification("propertylist_title_XPATH", "Property List", "The property list is not displayed.");

		// MAKE UTILITY BILL AS A VERIFIED FROM THE PERFORMANCE DATA VALIDATION MODULE

		title("MAKE UTILITY BILL AS A VERIFIED FROM THE PERFORMANCE DATA VALIDATION MODULE");

		try {
			// enter the property name in the search field
			type("envreports_propertylist_filtertxt_CSS", data.get("property_1"));
			ngDriver.waitForAngularRequestsToFinish();
			System.out.println("Entered the property name in the search field.");

			// click on the Sustainability icon
			click("sustainabilityicon_CSS");
			System.out.println("Clicked on the Sustainability icon.");
			ngDriver.waitForAngularRequestsToFinish();

			// wait for the element
			Thread.sleep(5000);

			// click on the side menu
			click("ssc_leftsidemenubtn_CSS");
			ngDriver.waitForAngularRequestsToFinish();
			System.out.println("Clicked on the side menu.");

			// wait for the element
			Thread.sleep(5000);

			// scroll down the screen
			scrollTillElement("sustainability_utilitybills_buildingperformancedataoption_XPATH");

			// click on the building performance data
			click("sustainability_utilitybills_buildingperformancedataoption_XPATH");
			ngDriver.waitForAngularRequestsToFinish();
			System.out.println("Clicked on the building performance data.");

			// scroll down the side menu
			scrollTillElement("sustainability_utilitybills_performancedatavalidationoption_XPATH");

			// click on the performance data validation
			click("sustainability_utilitybills_performancedatavalidationoption_XPATH");
			ngDriver.waitForAngularRequestsToFinish();
			System.out.println("Clicked on the performance data validation.");

			// enter the meter name in the search field
			clear("sustainability_searchtxt_XPATH");
			type("sustainability_searchtxt_XPATH", utilityBills);
			ngDriver.waitForAngularRequestsToFinish();
			System.out.println("Entered the meter name in the search field.");

			// click on the searched meter record
			String meter = "(//td[text()='" + utilityBills + "'])[1]";
			driver.findElement(By.xpath(meter)).click();
			ngDriver.waitForAngularRequestsToFinish();
			System.out.println("Clicked on the searched meter record.");

			// click on the verify all button
			click("sustainability_utilitybills_datavalidation_verifyall_XPATH");
			ngDriver.waitForAngularRequestsToFinish();
			System.out.println("Clicked on the verify all button.");

			// click on the save button
			click("sustainability_utility_performancedata_savebtn_XPATH");
			ngDriver.waitForAngularRequestsToFinish();
			System.out.println("Clicked on the save button.");

			// wait for the element
			Thread.sleep(10000);

		} catch (Throwable t) {
			verificationFailed();
		}

		// click on the home icon from the top of the screen
		click("questionnaire_homeburgermenubtn_hide_CSS");
		System.out.println("Clicked on the home icon from the top of the screen.");
		ngDriver.waitForAngularRequestsToFinish();

		// synchronization
		explicitWait("propertylist_title_XPATH");

		// verify the property list
		switchVerification("propertylist_title_XPATH", "Property List", "The property list is not displayed.");

		// DELETE THE UPDATED UTILITY BILLS RECORD AFTER VERIFIED

		title("DELETE THE UPDATED UTILITY BILLS RECORD AFTER VERIFIED");

		try {

			// enter the property name in the search field
			clear("envreports_propertylist_filtertxt_CSS");
			type("envreports_propertylist_filtertxt_CSS", data.get("property_1"));
			ngDriver.waitForAngularRequestsToFinish();
			System.out.println("Entered the property name in the search field.");

			// click on the Sustainability icon
			click("sustainabilityicon_CSS");
			System.out.println("Clicked on the Sustainability icon.");
			ngDriver.waitForAngularRequestsToFinish();

			// wait for the element
			Thread.sleep(5000);

			// click on the side menu
			click("ssc_leftsidemenubtn_CSS");
			ngDriver.waitForAngularRequestsToFinish();
			System.out.println("Clicked on the side menu.");

			// wait for the element
			Thread.sleep(5000);

			// click on the utility bills option
			click("sustainability_sidemenu_utilitybillsoption_XPATH");
			ngDriver.waitForAngularRequestsToFinish();
			System.out.println("Clicked on the utility bills option.");

			// ========= TEMPORARY CODE - BELOW =========

			// click on the utility filter
			click("sustainability_utilitybills_filter_utilitybtn_XPATH");
			ngDriver.waitForAngularRequestsToFinish();
			System.out.println("Clicked on the utility filter.");

			// click on the clear button
			click("sustainability_utilitybills_filter_clearbtn_XPATH");
			ngDriver.waitForAngularRequestsToFinish();
			System.out.println("Clicked on the clear button.");

			// enter utility in the search field
			clear("sustainability_utilitybills_filter_searchtxt_XPATH");
			type("sustainability_utilitybills_filter_searchtxt_XPATH", "Electricity");
			ngDriver.waitForAngularRequestsToFinish();
			System.out.println("enter utility in the search field");

			// click on the searched result
			click("sustainability_utilitybills_filter_searchedresult_XPATH");
			ngDriver.waitForAngularRequestsToFinish();
			System.out.println("Clicked on the searched result.");

			// select the current year in the dropdown
			LocalDate today = LocalDate.now();
			String[] todayDate = today.toString().split("-");
			select("sustainability_utilitybills_yearfilterdd_XPATH", todayDate[0]);
			ngDriver.waitForAngularRequestsToFinish();
			System.out.println("Selected the current year in the dropdown.");

			// select the all option from the meter filter
			select("sustainability_utilitybills_meterfilter_XPATH", "All");
			ngDriver.waitForAngularRequestsToFinish();
			System.out.println("Selected the all option from the meter filter.");

			// ========= TEMPORARY CODE - ABOVE =========

			// click on the refresh button
			click("sustainability_utilitybills_refreshbtn_XPATH");
			ngDriver.waitForAngularRequestsToFinish();
			System.out.println("Clicked on the refresh button.");

			// click on the updated utility bill record
			LocalDate deleteDate = LocalDate.now().minusMonths(6);
			String deleteDate_String = deleteDate.toString();
			String UtilityBills3 = "//td[contains(text(),'" + deleteDate_String + "')]";
			driver.findElement(By.xpath(UtilityBills3)).click();
			ngDriver.waitForAngularRequestsToFinish();
			System.out.println("Clicked on the updated bill record.");

			// click on the delete button
			click("sustainability_utilitybills_deletebtn_XPATH");
			ngDriver.waitForAngularRequestsToFinish();
			System.out.println("Clicked on the delete button.");

			// wait for the element
			explicitWaitClickable("sustainability_utilitybills_deletebtn_confirmation_XPATH");

			// click on the delete button of the confirmation popup
			click("sustainability_utilitybills_deletebtn_confirmation_XPATH");
			ngDriver.waitForAngularRequestsToFinish();
			System.out.println("Clicked on the delete button of the confirmation popup.");

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
					ngDriver.waitForAngularRequestsToFinish();
					System.out.println("Clicked on the ok button.");

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
		System.out.println("Clicked on the home icon from the top of the screen.");
		ngDriver.waitForAngularRequestsToFinish();

		// synchronization
		explicitWait("propertylist_title_XPATH");

		// verify the property list
		switchVerification("propertylist_title_XPATH", "Property List", "The property list is not displayed.");

		// MAKE UTILITY BILL AS A UNVERIFIED FROM THE PERFORMANCE DATA VALIDATION MODULE

		title("MAKE UTILITY BILL AS A UNVERIFIED FROM THE PERFORMANCE DATA VALIDATION MODULE");

		try {
			// enter the property name in the search field
			type("envreports_propertylist_filtertxt_CSS", data.get("property_1"));
			ngDriver.waitForAngularRequestsToFinish();
			System.out.println("Entered the property name in the search field.");

			// click on the Sustainability icon
			click("sustainabilityicon_CSS");
			System.out.println("Clicked on the Sustainability icon.");
			ngDriver.waitForAngularRequestsToFinish();

			// wait for the element
			Thread.sleep(5000);

			// click on the side menu
			click("ssc_leftsidemenubtn_CSS");
			ngDriver.waitForAngularRequestsToFinish();
			System.out.println("Clicked on the side menu.");

			// wait for the element
			Thread.sleep(5000);

			// scroll down the screen
			scrollTillElement("sustainability_utilitybills_buildingperformancedataoption_XPATH");

			// click on the building performance data
			click("sustainability_utilitybills_buildingperformancedataoption_XPATH");
			ngDriver.waitForAngularRequestsToFinish();
			System.out.println("Clicked on the building performance data.");

			// scroll down the side menu
			scrollTillElement("sustainability_utilitybills_performancedatavalidationoption_XPATH");

			// click on the performance data validation
			click("sustainability_utilitybills_performancedatavalidationoption_XPATH");
			ngDriver.waitForAngularRequestsToFinish();
			System.out.println("Clicked on the performance data validation.");

			// enter the meter name in the search field
			clear("sustainability_searchtxt_XPATH");
			type("sustainability_searchtxt_XPATH", utilityBills);
			ngDriver.waitForAngularRequestsToFinish();
			System.out.println("Entered the meter name in the search field.");

			// click on the searched meter record
			String meter = "(//td[text()='" + utilityBills + "'])[1]";
			driver.findElement(By.xpath(meter)).click();
			ngDriver.waitForAngularRequestsToFinish();
			System.out.println("Clicked on the searched meter record.");

			// click on the clear all button
			click("sustainability_utilitybills_datavalidation_clearall_XPATH");
			ngDriver.waitForAngularRequestsToFinish();
			System.out.println("Clicked on the clear all button.");

			// click on the save button
			click("sustainability_utility_performancedata_savebtn_XPATH");
			ngDriver.waitForAngularRequestsToFinish();
			System.out.println("Clicked on the save button.");

		} catch (Throwable t) {
			verificationFailed();
		}

		// click on the home icon from the top of the screen
		click("questionnaire_homeburgermenubtn_hide_CSS");
		System.out.println("Clicked on the home icon from the top of the screen.");
		ngDriver.waitForAngularRequestsToFinish();

		// synchronization
		explicitWait("propertylist_title_XPATH");

		// verify the property list
		switchVerification("propertylist_title_XPATH", "Property List", "The property list is not displayed.");

		// DELETE THE UTILITY BILLS RECORD

		title("DELETE THE UTILITY BILLS RECORD");

		try {

			// enter the property name in the search field
			type("envreports_propertylist_filtertxt_CSS", data.get("property_1"));
			ngDriver.waitForAngularRequestsToFinish();
			System.out.println("Entered the property name in the search field.");

			// click on the Sustainability icon
			click("sustainabilityicon_CSS");
			System.out.println("Clicked on the Sustainability icon.");
			ngDriver.waitForAngularRequestsToFinish();

			// wait for the element
			Thread.sleep(5000);

			// click on the side menu
			click("ssc_leftsidemenubtn_CSS");
			ngDriver.waitForAngularRequestsToFinish();
			System.out.println("Clicked on the side menu.");

			// wait for the element
			Thread.sleep(5000);

			// click on the utility bills option
			click("sustainability_sidemenu_utilitybillsoption_XPATH");
			ngDriver.waitForAngularRequestsToFinish();
			System.out.println("Clicked on the utility bills option.");

			// ========= TEMPORARY CODE - BELOW =========

			// click on the utility filter
			click("sustainability_utilitybills_filter_utilitybtn_XPATH");
			ngDriver.waitForAngularRequestsToFinish();
			System.out.println("Clicked on the utility filter.");

			// click on the clear button
			click("sustainability_utilitybills_filter_clearbtn_XPATH");
			ngDriver.waitForAngularRequestsToFinish();
			System.out.println("Clicked on the clear button.");

			// enter utility in the search field
			clear("sustainability_utilitybills_filter_searchtxt_XPATH");
			type("sustainability_utilitybills_filter_searchtxt_XPATH", "Electricity");
			ngDriver.waitForAngularRequestsToFinish();
			System.out.println("enter utility in the search field");

			// click on the searched result
			click("sustainability_utilitybills_filter_searchedresult_XPATH");
			ngDriver.waitForAngularRequestsToFinish();
			System.out.println("Clicked on the searched result.");

			// select the current year in the dropdown
			LocalDate today = LocalDate.now();
			String[] todayDate = today.toString().split("-");
			select("sustainability_utilitybills_yearfilterdd_XPATH", todayDate[0]);
			ngDriver.waitForAngularRequestsToFinish();
			System.out.println("Selected the current year in the dropdown.");

			// select the all option from the meter filter
			select("sustainability_utilitybills_meterfilter_XPATH", "All");
			ngDriver.waitForAngularRequestsToFinish();
			System.out.println("Selected the all option from the meter filter.");

			// ========= TEMPORARY CODE - ABOVE =========

			// click on the refresh button
			click("sustainability_utilitybills_refreshbtn_XPATH");
			ngDriver.waitForAngularRequestsToFinish();
			System.out.println("Clicked on the refresh button.");

			// click on the updated utility bill record
			LocalDate deleteDate = LocalDate.now().minusMonths(6);
			String deleteDate_String = deleteDate.toString();
			String UtilityBills3 = "//td[contains(text(),'" + deleteDate_String + "')]";
			driver.findElement(By.xpath(UtilityBills3)).click();
			ngDriver.waitForAngularRequestsToFinish();
			System.out.println("Clicked on the updated bill record.");

			// click on the delete button
			click("sustainability_utilitybills_deletebtn_XPATH");
			ngDriver.waitForAngularRequestsToFinish();
			System.out.println("Clicked on the delete button.");

			// wait for the element
			explicitWaitClickable("sustainability_utilitybills_deletebtn_confirmation_XPATH");

			// click on the delete button of the confirmation popup
			click("sustainability_utilitybills_deletebtn_confirmation_XPATH");
			ngDriver.waitForAngularRequestsToFinish();
			System.out.println("Clicked on the delete button of the confirmation popup.");

			// wait for the element
			explicitWaitClickable("closetoastmsg_CSS");

			// click on the toaster close button
			click("closetoastmsg_CSS");
			ngDriver.waitForAngularRequestsToFinish();
			System.out.println("Clicked on the toaster close button.");

			// enter the updated utility meter record in the search field
			clear("sustainability_searchtxt_XPATH");
			type("sustainability_searchtxt_XPATH", utilityBills);
			ngDriver.waitForAngularRequestsToFinish();
			System.out.println("Entered the updated utility meter record in the search field.");

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
		System.out.println("Clicked on the home icon from the top of the screen.");
		ngDriver.waitForAngularRequestsToFinish();

		// synchronization
		explicitWait("propertylist_title_XPATH");

		// verify the property list
		switchVerification("propertylist_title_XPATH", "Property List", "The property list is not displayed.");

	}
}
