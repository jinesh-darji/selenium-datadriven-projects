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

import base.TestBase;
import utilities.TestUtil;

public class RR5964Sustainability3Test extends TestBase {

	@Test(dataProviderClass = TestUtil.class, dataProvider = "dp")
	public void rR5964Sustainability3Test(Hashtable<String, String> data) throws IOException, InterruptedException {

		execution(data, "rR5964Sustainability3Test");

		// VALIDATE METER INDICATOR AND ADD THE METER DETAILS

		System.out.println("VALIDATE METER INDICATOR AND ADD THE METER DETAILS");
		test.log(LogStatus.INFO, "VALIDATE METER INDICATOR AND ADD THE METER DETAILS");
		Reporter.log("VALIDATE METER INDICATOR AND ADD THE METER DETAILS");
		log.info("VALIDATE METER INDICATOR AND ADD THE METER DETAILS");

		// refresh the page
		driver.navigate().refresh();
		explicitWait("sustainabilityicon_CSS");
		driver.navigate().refresh();

		System.out.println("Navigate to the Home Screen i.e. Property List Screen.");

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

			// validate the meter indicator of the utility bill
			try {
				String MeterIndicatorRed = "//i[@ng-click='goToAndCreateMeter(d.meterNumber)' and @class='icon-meter i-red']//parent::span//parent::td[contains(text(),'"
						+ utilityBills + "')]";
				String addedUtilityBills = (driver.findElement(By.xpath(MeterIndicatorRed)).getText()).trim();
				if (addedUtilityBills.equals(utilityBills)) {

					successMessage("The meter indicator of the utility bill is verified successfully.");

				} else {

					verificationFailedMessage("The meter indicator of the utility bill is not verified.");

				}
			} catch (Throwable t) {
				verificationFailed();
			}

		} catch (Throwable t) {
			verificationFailed();
		}

		// ADD METER DETAILS FROM THE NEWLY CREATED UTILITY BILLS RECORD

		System.out.println(
				"***************** ADD METER DETAILS FROM THE NEWLY CREATED UTILITY BILLS RECORD *****************");
		test.log(LogStatus.INFO,
				"***************** ADD METER DETAILS FROM THE NEWLY CREATED UTILITY BILLS RECORD *****************");
		Reporter.log(
				"***************** ADD METER DETAILS FROM THE NEWLY CREATED UTILITY BILLS RECORD *****************");
		log.info("***************** ADD METER DETAILS FROM THE NEWLY CREATED UTILITY BILLS RECORD *****************");

		try {

			// enter the newly created utility bill in search field
			clear("sustainability_searchtxt_XPATH");
			type("sustainability_searchtxt_XPATH", utilityBills);
			ngDriver.waitForAngularRequestsToFinish();
			System.out.println("Entered the newly created utility bill in search field.");

			// click on the newly created utility bill record
			String redIndicator = "//td[contains(text(),'" + utilityBills
					+ "')]//i[@ng-click='goToAndCreateMeter(d.meterNumber)' and @class='icon-meter i-red']";
			driver.findElement(By.xpath(redIndicator)).click();
			ngDriver.waitForAngularRequestsToFinish();
			System.out.println("Clicked on the newly created bill record.");

			// validate the meter number
			try {
				String meterValue = driver
						.findElement(By.xpath(OR.getProperty("sustainability_utilitymeter_metertxt_XPATH")))
						.getAttribute("value");
				if (meterValue.equals(utilityBills)) {
					System.out.println("The utility meter is verified successfully.");
					test.log(LogStatus.INFO, "The utility meter is verified successfully.");
					Reporter.log("The utility meter is verified successfully.");
					log.info("The utility meter is verified successfully.");
				} else {

					verificationFailed();

					System.out.println("The utility meter is not verified.");
					test.log(LogStatus.INFO, "The utility meter is not verified.");
					Reporter.log("The utility meter is not verified.");
					log.info("The utility meter is not verified.");

				}
			} catch (Throwable t) {
				verificationFailed();
			}

			// enter the details in the description field
			clear("sustainability_utilitymeter_descriptiontxt_XPATH");
			type("sustainability_utilitymeter_descriptiontxt_XPATH", data.get("description"));
			ngDriver.waitForAngularRequestsToFinish();
			System.out.println("Entered the details in the description field.");

			// select the utility type from the drop down
			select("sustainability_utilitymeter_utilitytypedd_XPATH", data.get("utility_type"));
			ngDriver.waitForAngularRequestsToFinish();
			System.out.println("Selected the utility type from the drop down.");

			// select the unit of measurement
			select("sustainability_utilitymeter_unitofmeasurementdd_XPATH", data.get("unit_measurement"));
			ngDriver.waitForAngularRequestsToFinish();
			System.out.println("Selected the unit of measurement.");

			// scroll down the screen
			JavascriptExecutor js = (JavascriptExecutor) driver;
			WebElement ele1 = driver
					.findElement(By.xpath(OR.getProperty("sustainability_utilitymeter_unitofmeasurementdd_XPATH")));
			js.executeScript("arguments[0].scrollIntoView(true);", ele1);

			// click on the yes option of the is green energy field
			click("sustainability_utilitymeter_isgreenenergyyes_XPATH");
			ngDriver.waitForAngularRequestsToFinish();
			System.out.println("Clicked on the yes option of the is green energy field.");

			// select the Green Consumption Category from the dropdown
			select("sustainability_utilitymeter_greenconsumptioncategorydd_XPATH",
					data.get("green_consumption_category"));
			ngDriver.waitForAngularRequestsToFinish();
			System.out.println("Selected the Green Consumption Category from the dropdown.");

			// enter the details in the area covered
			clear("sustainability_utilitymeter_areacoveredtxt_XPATH");
			type("sustainability_utilitymeter_areacoveredtxt_XPATH", "10");
			ngDriver.waitForAngularRequestsToFinish();
			System.out.println("Entered the details in the area covered.");

			// select the GHG Emissions Scope from the dropdown
			select("sustainability_utilitymeter_scope_XPATH", data.get("scope"));
			ngDriver.waitForAngularRequestsToFinish();
			System.out.println("Selected the GHG Emissions Scope from the dropdown.");

			// select the Consumption Category from the dropdown
			select("sustainability_utilitymeter_consumptioncategorydd_XPATH", data.get("consumption_category"));
			ngDriver.waitForAngularRequestsToFinish();
			System.out.println("Selected the Consumption Category from the dropdown.");

			// select the Source of Data from the dropdown
			select("sustainability_utilitymeter_sourceofdatadd_XPATH", data.get("source_of_data"));
			ngDriver.waitForAngularRequestsToFinish();
			System.out.println("Selected the Source of Data from the dropdown.");

			// select the Floor Area Type from the dropdown
			select("sustainability_utilitymeter_floorareatypeadd_XPATH", data.get("floor_area_type"));
			ngDriver.waitForAngularRequestsToFinish();
			System.out.println("Selected the Floor Area Type from the dropdown.");

			// enter the details in the Meter Manufacturer field
			clear("sustainability_utilitymeter_metermanufacturertxt_XPATH");
			type("sustainability_utilitymeter_metermanufacturertxt_XPATH", data.get("meter_manufacturer"));
			ngDriver.waitForAngularRequestsToFinish();
			System.out.println("Entered the details in the Meter Manufacturer field.");

			// select the Special Use Type from the dropdown
			select("sustainability_utilitymeter_specialusetypedd_XPATH", data.get("special_use_type"));
			ngDriver.waitForAngularRequestsToFinish();
			System.out.println("Selected the Special Use Type from the dropdown.");

			// select the Financial Control of Meter from the dropdown
			select("sustainability_utilitymeter_financialcontrolofmeterdd_XPATH",
					data.get("financial_control_of_meter"));
			ngDriver.waitForAngularRequestsToFinish();
			System.out.println("Selected the Financial Control of Meter from the dropdown.");

			// scroll down the screen
			js.executeScript("window.scrollBy(0,100)");

			// enter the details in the Date Installed field
			LocalDate addCurrentDate1 = LocalDate.now();
			String addCurrentDate1_String = addCurrentDate1.toString();
			clear("sustainability_utilitymeter_dateinstalled_XPATH");
			type("sustainability_utilitymeter_dateinstalled_XPATH", addCurrentDate1_String);
			ngDriver.waitForAngularRequestsToFinish();
			System.out.println("Entered the details in the Date Installed field.");

			// enter the details in the Date Activated field
			LocalDate addCurrentDate2 = LocalDate.now();
			String addCurrentDate2_String = addCurrentDate2.toString();
			clear("sustainability_utilitymeter_dateactivated_XPATH");
			type("sustainability_utilitymeter_dateactivated_XPATH", addCurrentDate2_String);
			ngDriver.waitForAngularRequestsToFinish();
			System.out.println("Entered the details in the Date Activated field.");

			// enter the details in the Date Deactivated field
			LocalDate addFutureDate1 = LocalDate.now().plusMonths(6);
			String addFutureDate1_String = addFutureDate1.toString();
			clear("sustainability_utilitymeter_datedeactivated_XPATH");
			type("sustainability_utilitymeter_datedeactivated_XPATH", addFutureDate1_String);
			ngDriver.waitForAngularRequestsToFinish();
			System.out.println("Entered the details in the Date Deactivated field.");

			// click on the save button
			click("sustainability_utilitymeter_savebtn_XPATH");
			ngDriver.waitForAngularRequestsToFinish();
			System.out.println("Clicked on the save button.");

			// wait for the element
			explicitWaitClickable("closetoastmsg_CSS");

			// click on the toaster close button
			click("closetoastmsg_CSS");
			ngDriver.waitForAngularRequestsToFinish();
			System.out.println("Clicked on the toaster close button.");

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

			// validate the meter indicator of the utility bill
			try {
				String MeterIndicatorGreen = "//i[@ng-click='goToMeter(d.meterNumber)' and @class='icon-meter i-green']//parent::span//parent::td[contains(text(),'"
						+ utilityBills + "')]";
				String addedUtilityBills1 = (driver.findElement(By.xpath(MeterIndicatorGreen)).getText()).trim();
				if (addedUtilityBills1.equals(utilityBills)) {

					System.out.println("The meter indicator of the utility bill is verified successfully.");
					test.log(LogStatus.INFO, "The meter indicator of the utility bill is verified successfully.");
					Reporter.log("The meter indicator of the utility bill is verified successfully.");
					log.info("The meter indicator of the utility bill is verified successfully.");
				} else {
					verificationFailed();

					System.out.println("The meter indicator of the utility bill is not verified.");
					test.log(LogStatus.INFO, "The meter indicator of the utility bill is not verified.");
					Reporter.log("The meter indicator of the utility bill is not verified.");
					log.info("The meter indicator of the utility bill is not verified.");
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

		// VALIDATE NEWLY ADDED METER RECORD

		System.out.println("***************** VALIDATE NEWLY ADDED METER RECORD *****************");
		test.log(LogStatus.INFO, "***************** VALIDATE NEWLY ADDED METER RECORD *****************");
		Reporter.log("***************** VALIDATE NEWLY ADDED METER RECORD *****************");
		log.info("***************** VALIDATE NEWLY ADDED METER RECORD *****************");

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

			// click on the UTILITY METERS option
			click("sustainability_sidemenu_utilitymetersoption_XPATH");
			ngDriver.waitForAngularRequestsToFinish();
			System.out.println("Clicked on the UTILITY METERS option.");

			// verify the newly created utility meter record
			try {
				String UtilityBills = "//td[text()='" + utilityBills + "']";
				String addedUtilityBills = (driver.findElement(By.xpath(UtilityBills)).getText()).trim();
				if (addedUtilityBills.equals(utilityBills)) {

					System.out.println("The utility meter is verified successfully.");
					test.log(LogStatus.INFO, "The utility meter is verified successfully.");
					Reporter.log("The utility meter is verified successfully.");
					log.info("The utility meter is verified successfully.");
				} else {
					verificationFailed();

					System.out.println("The utility meter is not verified.");
					test.log(LogStatus.INFO, "The utility meter is not verified.");
					Reporter.log("The utility meter is not verified.");
					log.info("The utility meter is not verified.");
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

		// DELETE THE UTILITY METER RECORD

		System.out.println("***************** DELETE THE UTILITY METER RECORD *****************");
		test.log(LogStatus.INFO, "***************** DELETE THE UTILITY METER RECORD *****************");
		Reporter.log("***************** DELETE THE UTILITY METER RECORD *****************");
		log.info("***************** DELETE THE UTILITY METER RECORD *****************");

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

			// click on the UTILITY METERS option
			click("sustainability_sidemenu_utilitymetersoption_XPATH");
			ngDriver.waitForAngularRequestsToFinish();
			System.out.println("Clicked on the UTILITY METERS option.");

			// click on the delete button
			String deletebtn = "//td[text()='" + utilityBills
					+ "']//following-sibling::td[@class='text-center w-16-per']//i[@ng-click='setToDelete(meter)']";
			driver.findElement(By.xpath(deletebtn)).click();
			ngDriver.waitForAngularRequestsToFinish();
			System.out.println("Clicked on the delete button.");

			// wait for the element
			explicitWaitClickable("sustainability_utilitymeter_deletebtn_confirmation_XPATH");

			// click on the delete button of the confirmation popup
			click("sustainability_utilitymeter_deletebtn_confirmation_XPATH");
			ngDriver.waitForAngularRequestsToFinish();
			System.out.println("Clicked on the delete button of the confirmation popup.");

			// wait for the element
			explicitWaitClickable("closetoastmsg_CSS");

			// click on the toaster close button
			click("closetoastmsg_CSS");
			ngDriver.waitForAngularRequestsToFinish();
			System.out.println("Clicked on the toaster close button.");

			// verify the deleted utility meter record displayed or not

			try {

				String addbtn = "//td[text()='" + utilityBills
						+ "']//following-sibling::td[@class='text-center w-16-per']//i[@ng-click='openMeter(meter)']";

				boolean addbtn1 = driver.findElement(By.xpath(addbtn)).isDisplayed();

				if (addbtn1 == true) {

					System.out.println("The add utility meter icon is displayed successfully.");
					test.log(LogStatus.INFO, "The add utility meter icon is displayed successfully.");
					Reporter.log("The add utility meter icon is displayed successfully.");
					log.info("The add utility meter icon is displayed successfully.");

				} else {
					verificationFailed();

					System.out.println("The add utility meter icon is not displayed.");
					test.log(LogStatus.INFO, "The add utility meter icon is not displayed.");
					Reporter.log("The add utility meter icon is not displayed.");
					log.info("The add utility meter icon is not displayed.");
				}

			} catch (Throwable t) {

				verificationFailed();

				System.out.println("The add utility meter icon is not displayed.");
				test.log(LogStatus.INFO, "The add utility meter icon is not displayed.");
				Reporter.log("The add utility meter icon is not displayed.");
				log.info("The add utility meter icon is not displayed.");

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

		// VALIDATE DELETE METER IN THE UTILITY BILLS LIST AND ADD THE METER DETAILS
		// AGAIN

		System.out.println(
				"***************** VALIDATE DELETE METER IN THE UTILITY BILLS LIST AND ADD THE METER DETAILS AGAIN *****************");
		test.log(LogStatus.INFO,
				"***************** VALIDATE DELETE METER IN THE UTILITY BILLS LIST AND ADD THE METER DETAILS AGAIN *****************");
		Reporter.log(
				"***************** VALIDATE DELETE METER IN THE UTILITY BILLS LIST AND ADD THE METER DETAILS AGAIN *****************");
		log.info(
				"***************** VALIDATE DELETE METER IN THE UTILITY BILLS LIST AND ADD THE METER DETAILS AGAIN *****************");

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

			// validate the meter indicator of the utility bill
			try {
				String MeterIndicatorRed = "//i[@ng-click='goToAndCreateMeter(d.meterNumber)' and @class='icon-meter i-red']//parent::span//parent::td[contains(text(),'"
						+ utilityBills + "')]";
				String addedUtilityBills = (driver.findElement(By.xpath(MeterIndicatorRed)).getText()).trim();
				if (addedUtilityBills.equals(utilityBills)) {

					System.out.println("The meter indicator of the utility bill is verified successfully.");
					test.log(LogStatus.INFO, "The meter indicator of the utility bill is verified successfully.");
					Reporter.log("The meter indicator of the utility bill is verified successfully.");
					log.info("The meter indicator of the utility bill is verified successfully.");
				} else {
					verificationFailed();

					System.out.println("The meter indicator of the utility bill is not verified.");
					test.log(LogStatus.INFO, "The meter indicator of the utility bill is not verified.");
					Reporter.log("The meter indicator of the utility bill is not verified.");
					log.info("The meter indicator of the utility bill is not verified.");
				}
			} catch (Throwable t) {
				verificationFailed();
			}
		} catch (Throwable t) {
			verificationFailed();
		}

		// AGAIN ADD THE METER DETAILS

		System.out.println("***************** AGAIN ADD THE METER DETAILS *****************");
		test.log(LogStatus.INFO, "***************** AGAIN ADD THE METER DETAILS *****************");
		Reporter.log("***************** AGAIN ADD THE METER DETAILS *****************");
		log.info("***************** AGAIN ADD THE METER DETAILS *****************");

		try {

			// click on the newly created utility bill record
			String redIndicator = "//td[contains(text(),'" + utilityBills
					+ "')]//i[@ng-click='goToAndCreateMeter(d.meterNumber)' and @class='icon-meter i-red']";
			driver.findElement(By.xpath(redIndicator)).click();
			ngDriver.waitForAngularRequestsToFinish();
			System.out.println("Clicked on the newly created bill record.");

			// validate the meter number
			try {
				String meterValue = driver
						.findElement(By.xpath(OR.getProperty("sustainability_utilitymeter_metertxt_XPATH")))
						.getAttribute("value");
				if (meterValue.equals(utilityBills)) {
					System.out.println("The utility meter is verified successfully.");
					test.log(LogStatus.INFO, "The utility meter is verified successfully.");
					Reporter.log("The utility meter is verified successfully.");
					log.info("The utility meter is verified successfully.");
				} else {

					verificationFailed();

					System.out.println("The utility meter is not verified.");
					test.log(LogStatus.INFO, "The utility meter is not verified.");
					Reporter.log("The utility meter is not verified.");
					log.info("The utility meter is not verified.");

				}
			} catch (Throwable t) {
				verificationFailed();
			}

			// enter the details in the description field
			clear("sustainability_utilitymeter_descriptiontxt_XPATH");
			type("sustainability_utilitymeter_descriptiontxt_XPATH", data.get("description"));
			ngDriver.waitForAngularRequestsToFinish();
			System.out.println("Entered the details in the description field.");

			// select the utility type from the drop down
			select("sustainability_utilitymeter_utilitytypedd_XPATH", data.get("utility_type"));
			ngDriver.waitForAngularRequestsToFinish();
			System.out.println("Selected the utility type from the drop down.");

			// select the unit of measurement
			select("sustainability_utilitymeter_unitofmeasurementdd_XPATH", data.get("unit_measurement"));
			ngDriver.waitForAngularRequestsToFinish();
			System.out.println("Selected the unit of measurement.");

			// scroll down the screen
			JavascriptExecutor js = (JavascriptExecutor) driver;
			WebElement ele1 = driver
					.findElement(By.xpath(OR.getProperty("sustainability_utilitymeter_unitofmeasurementdd_XPATH")));
			js.executeScript("arguments[0].scrollIntoView(true);", ele1);

			// click on the yes option of the is green energy field
			click("sustainability_utilitymeter_isgreenenergyyes_XPATH");
			ngDriver.waitForAngularRequestsToFinish();
			System.out.println("Clicked on the yes option of the is green energy field.");

			// select the Green Consumption Category from the dropdown
			select("sustainability_utilitymeter_greenconsumptioncategorydd_XPATH",
					data.get("green_consumption_category"));
			ngDriver.waitForAngularRequestsToFinish();
			System.out.println("Selected the Green Consumption Category from the dropdown.");

			// enter the details in the area covered
			clear("sustainability_utilitymeter_areacoveredtxt_XPATH");
			type("sustainability_utilitymeter_areacoveredtxt_XPATH", "10");
			ngDriver.waitForAngularRequestsToFinish();
			System.out.println("Entered the details in the area covered.");

			// select the GHG Emissions Scope from the dropdown
			select("sustainability_utilitymeter_scope_XPATH", data.get("scope"));
			ngDriver.waitForAngularRequestsToFinish();
			System.out.println("Selected the GHG Emissions Scope from the dropdown.");

			// select the Consumption Category from the dropdown
			select("sustainability_utilitymeter_consumptioncategorydd_XPATH", data.get("consumption_category"));
			ngDriver.waitForAngularRequestsToFinish();
			System.out.println("Selected the Consumption Category from the dropdown.");

			// select the Source of Data from the dropdown
			select("sustainability_utilitymeter_sourceofdatadd_XPATH", data.get("source_of_data"));
			ngDriver.waitForAngularRequestsToFinish();
			System.out.println("Selected the Source of Data from the dropdown.");

			// select the Floor Area Type from the dropdown
			select("sustainability_utilitymeter_floorareatypeadd_XPATH", data.get("floor_area_type"));
			ngDriver.waitForAngularRequestsToFinish();
			System.out.println("Selected the Floor Area Type from the dropdown.");

			// enter the details in the Meter Manufacturer field
			clear("sustainability_utilitymeter_metermanufacturertxt_XPATH");
			type("sustainability_utilitymeter_metermanufacturertxt_XPATH", data.get("meter_manufacturer"));
			ngDriver.waitForAngularRequestsToFinish();
			System.out.println("Entered the details in the Meter Manufacturer field.");

			// select the Special Use Type from the dropdown
			select("sustainability_utilitymeter_specialusetypedd_XPATH", data.get("special_use_type"));
			ngDriver.waitForAngularRequestsToFinish();
			System.out.println("Selected the Special Use Type from the dropdown.");

			// select the Financial Control of Meter from the dropdown
			select("sustainability_utilitymeter_financialcontrolofmeterdd_XPATH",
					data.get("financial_control_of_meter"));
			ngDriver.waitForAngularRequestsToFinish();
			System.out.println("Selected the Financial Control of Meter from the dropdown.");

			// scroll down the screen
			js.executeScript("window.scrollBy(0,100)");

			// enter the details in the Date Installed field
			LocalDate addCurrentDate1 = LocalDate.now();
			String addCurrentDate1_String = addCurrentDate1.toString();
			clear("sustainability_utilitymeter_dateinstalled_XPATH");
			type("sustainability_utilitymeter_dateinstalled_XPATH", addCurrentDate1_String);
			ngDriver.waitForAngularRequestsToFinish();
			System.out.println("Entered the details in the Date Installed field.");

			// enter the details in the Date Activated field
			LocalDate addCurrentDate2 = LocalDate.now();
			String addCurrentDate2_String = addCurrentDate2.toString();
			clear("sustainability_utilitymeter_dateactivated_XPATH");
			type("sustainability_utilitymeter_dateactivated_XPATH", addCurrentDate2_String);
			ngDriver.waitForAngularRequestsToFinish();
			System.out.println("Entered the details in the Date Activated field.");

			// enter the details in the Date Deactivated field
			LocalDate addFutureDate1 = LocalDate.now().plusMonths(6);
			String addFutureDate1_String = addFutureDate1.toString();
			clear("sustainability_utilitymeter_datedeactivated_XPATH");
			type("sustainability_utilitymeter_datedeactivated_XPATH", addFutureDate1_String);
			ngDriver.waitForAngularRequestsToFinish();
			System.out.println("Entered the details in the Date Deactivated field.");

			// click on the save button
			click("sustainability_utilitymeter_savebtn_XPATH");
			ngDriver.waitForAngularRequestsToFinish();
			System.out.println("Clicked on the save button.");

			// wait for the element
			explicitWaitClickable("closetoastmsg_CSS");

			// click on the toaster close button
			click("closetoastmsg_CSS");
			ngDriver.waitForAngularRequestsToFinish();
			System.out.println("Clicked on the toaster close button.");

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

			// validate the meter indicator of the utility bill
			try {
				String MeterIndicatorGreen = "//i[@ng-click='goToMeter(d.meterNumber)' and @class='icon-meter i-green']//parent::span//parent::td[contains(text(),'"
						+ utilityBills + "')]";
				String addedUtilityBills1 = (driver.findElement(By.xpath(MeterIndicatorGreen)).getText()).trim();
				if (addedUtilityBills1.equals(utilityBills)) {

					System.out.println("The meter indicator of the utility bill is verified successfully.");
					test.log(LogStatus.INFO, "The meter indicator of the utility bill is verified successfully.");
					Reporter.log("The meter indicator of the utility bill is verified successfully.");
					log.info("The meter indicator of the utility bill is verified successfully.");
				} else {
					verificationFailed();

					System.out.println("The meter indicator of the utility bill is not verified.");
					test.log(LogStatus.INFO, "The meter indicator of the utility bill is not verified.");
					Reporter.log("The meter indicator of the utility bill is not verified.");
					log.info("The meter indicator of the utility bill is not verified.");
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

		// VALIDATE ADD ICON CONVERTED TO DELETE ICON OR NOT IN THE UTILITY METER LIST

		System.out.println(
				"***************** VALIDATE ADD ICON CONVERTED TO DELETE ICON OR NOT IN THE UTILITY METER LIST *****************");
		test.log(LogStatus.INFO,
				"***************** VALIDATE ADD ICON CONVERTED TO DELETE ICON OR NOT IN THE UTILITY METER LIST *****************");
		Reporter.log(
				"***************** VALIDATE ADD ICON CONVERTED TO DELETE ICON OR NOT IN THE UTILITY METER LIST *****************");
		log.info(
				"***************** VALIDATE ADD ICON CONVERTED TO DELETE ICON OR NOT IN THE UTILITY METER LIST *****************");

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

			// click on the UTILITY METERS option
			click("sustainability_sidemenu_utilitymetersoption_XPATH");
			ngDriver.waitForAngularRequestsToFinish();
			System.out.println("Clicked on the UTILITY METERS option.");

			// verify the delete utility meter icon displayed or not

			try {

				String deletebtn11 = "//td[text()='" + utilityBills
						+ "']//following-sibling::td[@class='text-center w-16-per']//i[@ng-click='setToDelete(meter)']";

				boolean addbtn11 = driver.findElement(By.xpath(deletebtn11)).isDisplayed();

				if (addbtn11 == true) {

					System.out.println("The delete utility meter icon is displayed successfully.");
					test.log(LogStatus.INFO, "The delete utility meter icon is displayed successfully.");
					Reporter.log("The delete utility meter icon is displayed successfully.");
					log.info("The delete utility meter icon is displayed successfully.");

				} else {
					verificationFailed();

					System.out.println("The delete utility meter icon is not displayed.");
					test.log(LogStatus.INFO, "The delete utility meter icon is not displayed.");
					Reporter.log("The delete utility meter icon is not displayed.");
					log.info("The delete utility meter icon is not displayed.");
				}

			} catch (Throwable t) {

				verificationFailed();

				System.out.println("The delete utility meter icon is not displayed.");
				test.log(LogStatus.INFO, "The delete utility meter icon is not displayed.");
				Reporter.log("The delete utility meter icon is not displayed.");
				log.info("The delete utility meter icon is not displayed.");

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

		// DELETE THE NEWLY CREATED UTILITY BILLS RECORD

		System.out.println("***************** DELETE THE NEWLY CREATED UTILITY BILLS RECORD *****************");
		test.log(LogStatus.INFO, "***************** DELETE THE NEWLY CREATED UTILITY BILLS RECORD *****************");
		Reporter.log("***************** DELETE THE NEWLY CREATED UTILITY BILLS RECORD *****************");
		log.info("***************** DELETE THE NEWLY CREATED UTILITY BILLS RECORD *****************");

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

			// wait for the element
			Thread.sleep(5000);

			// click on the delete button
			click("sustainability_utilitybills_deletebtn_XPATH");
			ngDriver.waitForAngularRequestsToFinish();
			System.out.println("Clicked on the delete button.");

			// wait for the element
			Thread.sleep(5000);

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

			// click on the refresh button
			click("sustainability_utilitybills_refreshbtn_XPATH");
			ngDriver.waitForAngularRequestsToFinish();
			System.out.println("Clicked on the refresh button.");

			// enter the updated utility meter record in the search field
			clear("sustainability_searchtxt_XPATH");
			type("sustainability_searchtxt_XPATH", utilityBills);
			ngDriver.waitForAngularRequestsToFinish();
			System.out.println("Entered the updated utility meter record in the search field.");

			// verify the deleted utility bill record displayed or not

			try {

				String UpdateUtilityBills1 = "//td[contains(text(),'" + utilityBills + "')]";
				String updatedUtilityBills1 = (driver.findElement(By.xpath(UpdateUtilityBills1)).getText()).trim();
				consoleMessage(updatedUtilityBills1);

				if (updatedUtilityBills1.equals(utilityBills)) {

					TestUtil.captureScreenshot();

					// ReportNG
					Reporter.log("<br>" + "The utility bill is not deleted : " + "<br>");
					Reporter.log("<a target=\"_blank\" href=" + TestUtil.screenshotName + "><img src="
							+ TestUtil.screenshotName + " height=200 width=200></img></a>");
					Reporter.log("<br>");
					Reporter.log("<br>");

					// Extent Report
					test.log(LogStatus.FAIL, " The utility bill is not deleted : ");
					test.log(LogStatus.FAIL, test.addScreenCapture(TestUtil.screenshotName));

					System.out.println("The utility bill is not deleted.");
					log.info("The utility bill is not deleted.");

				}
			} catch (Throwable t) {
				System.out.println("The utility bill is deleted successfully.");
				test.log(LogStatus.INFO, "The utility bill is deleted successfully.");
				Reporter.log("The utility bill is deleted successfully.");
				log.info("The utility bill is deleted successfully.");
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

		// DELETE THE UTILITY METER RECORD

		System.out.println("***************** DELETE THE UTILITY METER RECORD *****************");
		test.log(LogStatus.INFO, "***************** DELETE THE UTILITY METER RECORD *****************");
		Reporter.log("***************** DELETE THE UTILITY METER RECORD *****************");
		log.info("***************** DELETE THE UTILITY METER RECORD *****************");

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

			// click on the UTILITY METERS option
			click("sustainability_sidemenu_utilitymetersoption_XPATH");
			ngDriver.waitForAngularRequestsToFinish();
			System.out.println("Clicked on the UTILITY METERS option.");

			// click on the delete button
			String deletebtn = "//td[text()='" + utilityBills
					+ "']//following-sibling::td[@class='text-center w-16-per']//i[@ng-click='setToDelete(meter)']";
			driver.findElement(By.xpath(deletebtn)).click();
			ngDriver.waitForAngularRequestsToFinish();
			System.out.println("Clicked on the delete button.");

			// wait for the element
			explicitWaitClickable("sustainability_utilitymeter_deletebtn_confirmation_XPATH");

			// click on the delete button of the confirmation popup
			click("sustainability_utilitymeter_deletebtn_confirmation_XPATH");
			ngDriver.waitForAngularRequestsToFinish();
			System.out.println("Clicked on the delete button of the confirmation popup.");

			// wait for the element
			explicitWaitClickable("closetoastmsg_CSS");

			// click on the toaster close button
			click("closetoastmsg_CSS");
			ngDriver.waitForAngularRequestsToFinish();
			System.out.println("Clicked on the toaster close button.");

			// verify the deleted utility meter record displayed or not
			try {

				String UpdateUtilityMeter1 = "//td[text()='" + utilityBills + "']";
				String updatedUtilityMeter1 = (driver.findElement(By.xpath(UpdateUtilityMeter1)).getText()).trim();

				if (updatedUtilityMeter1.equals(utilityBills)) {

					TestUtil.captureScreenshot();

					// ReportNG
					Reporter.log("<br>" + "The utility meter is not deleted : " + "<br>");
					Reporter.log("<a target=\"_blank\" href=" + TestUtil.screenshotName + "><img src="
							+ TestUtil.screenshotName + " height=200 width=200></img></a>");
					Reporter.log("<br>");
					Reporter.log("<br>");

					// Extent Report
					test.log(LogStatus.FAIL, " The utility meter is not deleted : ");
					test.log(LogStatus.FAIL, test.addScreenCapture(TestUtil.screenshotName));

					System.out.println("The utility meter is not deleted.");
					log.info("The utility meter is not deleted.");

				}
			} catch (Throwable t) {
				System.out.println("The utility meter is deleted successfully.");
				test.log(LogStatus.INFO, "The utility meter is deleted successfully.");
				Reporter.log("The utility meter is deleted successfully.");
				log.info("The utility meter is deleted successfully.");
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
