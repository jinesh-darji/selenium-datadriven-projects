package testcases.E2Etestcasesuite.sustainabilitymodule;

import java.io.IOException;
import java.time.LocalDate;
import java.util.Hashtable;
import java.util.List;
import java.util.Random;

import org.apache.commons.lang3.RandomStringUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.testng.Reporter;
import org.testng.SkipException;
import org.testng.annotations.Test;

import com.relevantcodes.extentreports.LogStatus;

import base.Helper;
import base.TestBase;
import utilities.TestUtil;

public class RR6034Sustainability6Test extends TestBase {

	@Test(dataProviderClass = TestUtil.class, dataProvider = "dp")
	public void rR6034Sustainability6Test(Hashtable<String, String> data) throws IOException, InterruptedException {

		execution(data, "rR6034Sustainability6Test");

		// VALIDATE THE PERMISSION TO CREATE, READ, UPDATE AND DELETE OCCUPANCY DATA
		// SECURITY SETTINGS

		System.out
				.println("VALIDATE THE PERMISSION TO CREATE, READ, UPDATE AND DELETE OCCUPANCY DATA SECURITY SETTINGS");
		test.log(LogStatus.INFO,
				"VALIDATE THE PERMISSION TO CREATE, READ, UPDATE AND DELETE OCCUPANCY DATA SECURITY SETTINGS");
		Reporter.log("VALIDATE THE PERMISSION TO CREATE, READ, UPDATE AND DELETE OCCUPANCY DATA SECURITY SETTINGS");
		log.info("VALIDATE THE PERMISSION TO CREATE, READ, UPDATE AND DELETE OCCUPANCY DATA SECURITY SETTINGS");

		Helper helper = new Helper();

		// refresh the page
		driver.navigate().refresh();
		explicitWait("sustainabilityicon_CSS");
		driver.navigate().refresh();

		System.out.println("Navigate to the Home Screen i.e. Property List Screen.");

		// UPDATE THE PERMISSION TO CREATE, READ, UPDATE AND DELETE OCCUPANCY DATA
		// SECURITY SETTINGS

		System.out.println(
				"***************** UPDATE THE PERMISSION TO CREATE, READ, UPDATE AND DELETE OCCUPANCY DATA SECURITY SETTINGS *****************");
		test.log(LogStatus.INFO,
				"***************** UPDATE THE PERMISSION TO CREATE, READ, UPDATE AND DELETE OCCUPANCY DATA SECURITY SETTINGS *****************");
		Reporter.log(
				"***************** UPDATE THE PERMISSION TO CREATE, READ, UPDATE AND DELETE OCCUPANCY DATA SECURITY SETTINGS *****************");
		log.info(
				"***************** UPDATE THE PERMISSION TO CREATE, READ, UPDATE AND DELETE OCCUPANCY DATA SECURITY SETTINGS *****************");

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

			// click on the security tab
			click("questionnaire_securitytab_XPATH");
			System.out.println("Clicked on the security tab.");
			ngDriver.waitForAngularRequestsToFinish();

			// click on the security settings option
			click("questionnaire_securotysettingsoption_XPATH");
			System.out.println("Clicked on the security settings option.");
			ngDriver.waitForAngularRequestsToFinish();

			// RESET THE PERMISSION TO ADMINISTER GRESB FEATURE SECURITY SETTINGS

			helper.resetPermission(data, "security_setting_1", "sustainability_utilitybills_securitysettings6_XPATH");

		} catch (Throwable t) {
			verificationFailed();
		}

		// click on the home icon
		click("questionnaire_homeburgermenubtn_CSS");
		ngDriver.waitForAngularRequestsToFinish();
		System.out.println("Clicked on the home icon.");

		// wait for the element
		explicitWait("propertylist_title_XPATH");

		// verify the property list
		switchVerification("propertylist_title_XPATH", "Property List", "The property list is not displayed.");

		// CREATE NEW UTILITY BILLS RECORD - AT PROPERTY LEVEL

		System.out.println("***************** CREATE NEW UTILITY BILLS RECORD - AT PROPERTY LEVEL *****************");
		test.log(LogStatus.INFO,
				"***************** CREATE NEW UTILITY BILLS RECORD - AT PROPERTY LEVEL *****************");
		Reporter.log("***************** CREATE NEW UTILITY BILLS RECORD - AT PROPERTY LEVEL *****************");
		log.info("***************** CREATE NEW UTILITY BILLS RECORD - AT PROPERTY LEVEL *****************");

		String utilityBills1 = RandomStringUtils.randomNumeric(8);
		Random random = new Random();
		int billCount = random.nextInt(4 - 2) + 2;

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

			for (int i = 0; i < billCount; i++) {

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
				type("sustainability_utilitybills_meternumber_XPATH", utilityBills1 + i);
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
				String random2 = RandomStringUtils.randomNumeric(6);
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
				String random22 = RandomStringUtils.randomNumeric(6);
				clear("sustainability_utilitybills_totalcost_XPATH");
				type("sustainability_utilitybills_totalcost_XPATH", random22);
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

				// select the current year in the dropdown
				LocalDate today1 = LocalDate.now();
				String[] todayDate1 = today1.toString().split("-");
				select("sustainability_utilitybills_yearfilterdd_XPATH", todayDate1[0]);

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
				type("sustainability_searchtxt_XPATH", utilityBills1 + i);
				ngDriver.waitForAngularRequestsToFinish();
				System.out.println("Entered the newly created certification record in the search field.");

				// verify the newly created utility meter record
				try {
					String UtilityBills = "//td[contains(text(),'" + utilityBills1 + i + "')]";
					String addedUtilityBills = (driver.findElement(By.xpath(UtilityBills)).getText()).trim();
					if (addedUtilityBills.equals(utilityBills1 + i)) {

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
							+ utilityBills1 + i + "')]";
					String addedUtilityBills = (driver.findElement(By.xpath(MeterIndicatorRed)).getText()).trim();
					if (addedUtilityBills.equals(utilityBills1 + i)) {

						successMessage("The meter indicator of the utility bill is verified successfully.");

					} else {

						verificationFailedMessage("The meter indicator of the utility bill is not verified.");

					}
				} catch (Throwable t) {
					verificationFailed();
				}

				// click on the newly created utility bill record
				String redIndicator = "//td[contains(text(),'" + utilityBills1 + i
						+ "')]//i[@ng-click='goToAndCreateMeter(d.meterNumber)' and @class='icon-meter i-red']";
				driver.findElement(By.xpath(redIndicator)).click();
				ngDriver.waitForAngularRequestsToFinish();
				System.out.println("Clicked on the newly created bill record.");

				// validate the meter number
				try {
					String meterValue = driver
							.findElement(By.xpath(OR.getProperty("sustainability_utilitymeter_metertxt_XPATH")))
							.getAttribute("value");
					if (meterValue.equals(utilityBills1 + i)) {
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
				type("sustainability_utilitymeter_descriptiontxt_XPATH", data.get("description"));
				ngDriver.waitForAngularRequestsToFinish();
				System.out.println("Entered the details in the description field.");

				// scroll down the screen
				JavascriptExecutor js = (JavascriptExecutor) driver;
				js.executeScript("window.scrollBy(0,200)");

				// select the utility type from the drop down
				select("sustainability_utilitymeter_utilitytypedd_XPATH", data.get("utility_type"));
				ngDriver.waitForAngularRequestsToFinish();
				System.out.println("Selected the utility type from the drop down.");

				// select the unit of measurement
				select("sustainability_utilitymeter_unitofmeasurementdd_XPATH", data.get("unit_measurement"));
				ngDriver.waitForAngularRequestsToFinish();
				System.out.println("Selected the unit of measurement.");

				// scroll down the screen
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
				type("sustainability_searchtxt_XPATH", utilityBills1 + i);
				ngDriver.waitForAngularRequestsToFinish();
				System.out.println("Entered the newly created certification record in the search field.");

				// verify the newly created utility meter record
				try {
					String UtilityBills = "//td[contains(text(),'" + utilityBills1 + i + "')]";
					String addedUtilityBills = (driver.findElement(By.xpath(UtilityBills)).getText()).trim();
					if (addedUtilityBills.equals(utilityBills1 + i)) {

						successMessage("The utility bills is verified successfully.");

					} else {

						verificationFailedMessage("The utility bills is not verified.");

					}
				} catch (Throwable t) {
					verificationFailed();
				}

				// validate the meter indicator of the utility bill
				try {
					String MeterIndicatorGreen = "//i[@ng-click='goToMeter(d.meterNumber)' and @class='icon-meter i-green']//parent::span//parent::td[contains(text(),'"
							+ utilityBills1 + i + "')]";
					String addedUtilityBills1 = (driver.findElement(By.xpath(MeterIndicatorGreen)).getText()).trim();
					if (addedUtilityBills1.equals(utilityBills1 + i)) {

						successMessage("The meter indicator of the utility bill is verified successfully.");

					} else {

						verificationFailedMessage("The meter indicator of the utility bill is not verified.");

					}
				} catch (Throwable t) {
					verificationFailed();
				}

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

		// VALIDATE THE PERMISSION TO CREATE, READ, UPDATE AND DELETE OCCUPANCY DATA IN
		// ADMIN USER

		System.out.println(
				"***************** VALIDATE THE PERMISSION TO CREATE, READ, UPDATE AND DELETE OCCUPANCY DATA IN ADMIN USER *****************");
		test.log(LogStatus.INFO,
				"***************** VALIDATE THE PERMISSION TO CREATE, READ, UPDATE AND DELETE OCCUPANCY DATA IN ADMIN USER *****************");
		Reporter.log(
				"***************** VALIDATE THE PERMISSION TO CREATE, READ, UPDATE AND DELETE OCCUPANCY DATA IN ADMIN USER *****************");
		log.info(
				"***************** VALIDATE THE PERMISSION TO CREATE, READ, UPDATE AND DELETE OCCUPANCY DATA IN ADMIN USER *****************");

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

			// click on the building performance data option
			click("sustainability_sidemenu_buildingperformancedataoption_XPATH");
			ngDriver.waitForAngularRequestsToFinish();
			System.out.println("Clicked on the building performance data option.");

			// click on the energy option
			click("sustainability_sidemenu_buildingperformancedataoption_energyoption_XPATH");
			ngDriver.waitForAngularRequestsToFinish();
			System.out.println("Clicked on the energy option.");

			// scroll down to the bottom of the screen
			JavascriptExecutor js = (JavascriptExecutor) driver;
			js.executeScript("window.scrollBy(0,document.body.scrollHeight)");

			// wait for the element
			Thread.sleep(5000);

			// click on the occupancy icon - year
			click("sustainability_energydashboard_occupancyicon_XPATH");
			ngDriver.waitForAngularRequestsToFinish();
			System.out.println("Clicked on the occupancy icon - year.");

			// wait for the element
			Thread.sleep(5000);

			// click on the occupancy icon - month
			click("sustainability_energydashboard_occupancyiconmonth_XPATH");
			ngDriver.waitForAngularRequestsToFinish();
			System.out.println("Clicked on the occupancy icon - month.");

			// wait for the element
			Thread.sleep(5000);

			// validate the user able to update the occupancy
			try {
				boolean occupancyPercentage = driver
						.findElement(By.xpath(OR.getProperty(
								"sustainability_energydashboard_occupancyicon_occupancypercentagetxt_XPATH")))
						.isDisplayed();

				if (occupancyPercentage == true) {

					successMessage("The user able to update the occupancy details as expected.");

					// enter the occupancy percentage
					String occPer = RandomStringUtils.randomNumeric(2);
					clear("sustainability_energydashboard_occupancyicon_occupancypercentagetxt_XPATH");
					type("sustainability_energydashboard_occupancyicon_occupancypercentagetxt_XPATH", occPer);
					ngDriver.waitForAngularRequestsToFinish();
					System.out.println("Entered the occupancy percentage.");

					// enter the average number of people
					String peoplenumber = RandomStringUtils.randomNumeric(3);
					clear("sustainability_energydashboard_occupancyicon_numberofpeopletxt_XPATH");
					type("sustainability_energydashboard_occupancyicon_numberofpeopletxt_XPATH", peoplenumber);
					ngDriver.waitForAngularRequestsToFinish();
					System.out.println("Entered the average number of people.");

					// enter the average number of people
					clear("sustainability_energydashboard_occupancyicon_occupancynotestxt_XPATH");
					type("sustainability_energydashboard_occupancyicon_occupancynotestxt_XPATH",
							data.get("occupancy_note"));
					ngDriver.waitForAngularRequestsToFinish();
					System.out.println("Entered the average number of people.");

					// click on the save button
					click("sustainability_energydashboard_occupancyicon_savebtn_XPATH");
					ngDriver.waitForAngularRequestsToFinish();
					System.out.println("Clicked on the save button.");

					// scroll down to the bottom of the screen
					js.executeScript("window.scrollBy(0,document.body.scrollHeight)");

					// validate the entered occupancy details are updated or not
					try {
						String actual_occPer = (driver
								.findElement(By.xpath(
										OR.getProperty("sustainability_energydashboard_occupancyiconmonth_XPATH")))
								.getText()).trim();
						if (actual_occPer.equals(occPer)) {

							successMessage("The user able to update the occupancy details.");

						} else {
							verificationFailedMessage("The updated occupancy details are not displayed.");
						}
					} catch (Throwable t) {
						verificationFailedMessage("The updated occupancy details are not displayed.");
					}

				} else {
					verificationFailedMessage("The user not able to update the occupancy details.");
				}
			} catch (Throwable t) {
				verificationFailedMessage("The user not able to update the occupancy details.");
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

		// LOGOUT FROM THE ADMIN USER AND LOGIN IN JINESH USER

		System.out.println("***************** LOGOUT FROM THE ADMIN USER AND LOGIN IN JINESH USER *****************");
		test.log(LogStatus.INFO,
				"***************** LOGOUT FROM THE ADMIN USER AND LOGIN IN JINESH USER *****************");
		Reporter.log("***************** LOGOUT FROM THE ADMIN USER AND LOGIN IN JINESH USER *****************");
		log.info("***************** LOGOUT FROM THE ADMIN USER AND LOGIN IN JINESH USER *****************");

		try {

			try {
				// wait for the element
				explicitWaitClickable("questionnaire_settingicon_CSS");

				// click on the settings icon from the top of the screen
				click("questionnaire_settingicon_CSS");
				System.out.println("Clicked on the settings icon.");
				ngDriver.waitForAngularRequestsToFinish();

				// wait for the element
				explicitWaitClickable("sidemenu_logout_CSS");

				// click on the logout option from the side menu
				click("sidemenu_logout_CSS");
				System.out.println("Clicked on the logout option from the side menu.");
				ngDriver.waitForAngularRequestsToFinish();

				helper.loginAndUpdateSystemCompany(data, "username", "password", "SystemCompany");

			} catch (Throwable t) {
				verificationFailed();
			}

			// VALIDATE THE PERMISSION TO CREATE, READ, UPDATE AND DELETE OCCUPANCY DATA IN
			// PROPERTY MANAGER USER

			System.out.println(
					"***************** VALIDATE THE PERMISSION TO CREATE, READ, UPDATE AND DELETE OCCUPANCY DATA IN PROPERTY MANAGER USER *****************");
			test.log(LogStatus.INFO,
					"***************** VALIDATE THE PERMISSION TO CREATE, READ, UPDATE AND DELETE OCCUPANCY DATA IN PROPERTY MANAGER USER *****************");
			Reporter.log(
					"***************** VALIDATE THE PERMISSION TO CREATE, READ, UPDATE AND DELETE OCCUPANCY DATA IN PROPERTY MANAGER USER *****************");
			log.info(
					"***************** VALIDATE THE PERMISSION TO CREATE, READ, UPDATE AND DELETE OCCUPANCY DATA IN PROPERTY MANAGER USER *****************");

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

				// click on the building performance data option
				click("sustainability_sidemenu_buildingperformancedataoption_XPATH");
				ngDriver.waitForAngularRequestsToFinish();
				System.out.println("Clicked on the building performance data option.");

				// click on the energy option
				click("sustainability_sidemenu_buildingperformancedataoption_energyoption_XPATH");
				ngDriver.waitForAngularRequestsToFinish();
				System.out.println("Clicked on the energy option.");

				// scroll down to the bottom of the screen
				JavascriptExecutor js = (JavascriptExecutor) driver;
				js.executeScript("window.scrollBy(0,document.body.scrollHeight)");

				// wait for the element
				Thread.sleep(5000);

				// click on the occupancy icon - year
				click("sustainability_energydashboard_occupancyicon_XPATH");
				ngDriver.waitForAngularRequestsToFinish();
				System.out.println("Clicked on the occupancy icon - year.");

				// wait for the element
				Thread.sleep(5000);

				// click on the occupancy icon - month
				click("sustainability_energydashboard_occupancyiconmonth_XPATH");
				ngDriver.waitForAngularRequestsToFinish();
				System.out.println("Clicked on the occupancy icon - month.");

				// wait for the element
				Thread.sleep(5000);

				// validate the user able to update the occupancy
				try {
					boolean occupancyPercentage = driver
							.findElement(By.xpath(OR.getProperty(
									"sustainability_energydashboard_occupancyicon_occupancypercentagetxt_XPATH")))
							.isDisplayed();

					if (occupancyPercentage == true) {

						verificationFailedMessage("The user able to update the occupancy details.");

					} else {

						successMessage("The user not able to update the occupancy details as expected.");

					}
				} catch (Throwable t) {
					successMessage("The user not able to update the occupancy details as expected.");

				}
			} catch (Throwable t) {
				verificationFailed();
			}

			// click on the close button
			click("sustainability_utilitybills_closebtn_occupancymodel_XPATH");
			ngDriver.waitForAngularRequestsToFinish();
			System.out.println("Clicked on the close button.");

			// click on the home icon from the top of the screen
			click("questionnaire_homeburgermenubtn_hide_CSS");
			System.out.println("Clicked on the home icon from the top of the screen.");
			ngDriver.waitForAngularRequestsToFinish();

			// synchronization
			explicitWait("propertylist_title_XPATH");

			// verify the property list
			switchVerification("propertylist_title_XPATH", "Property List", "The property list is not displayed.");

			// LOGOUT FROM THE PROPERTY MANAGER USER AND LOGIN IN ADMIN USER

			System.out.println(
					"***************** LOGOUT FROM THE PROPERTY MANAGER USER AND LOGIN IN ADMIN USER *****************");
			test.log(LogStatus.INFO,
					"***************** LOGOUT FROM THE PROPERTY MANAGER USER AND LOGIN IN ADMIN USER *****************");
			Reporter.log(
					"***************** LOGOUT FROM THE PROPERTY MANAGER USER AND LOGIN IN ADMIN USER *****************");
			log.info(
					"***************** LOGOUT FROM THE PROPERTY MANAGER USER AND LOGIN IN ADMIN USER *****************");

			try {
				// wait for the element
				explicitWaitClickable("questionnaire_settingicon_CSS");

				// click on the settings icon from the top of the screen
				click("questionnaire_settingicon_CSS");
				System.out.println("Clicked on the settings icon.");
				ngDriver.waitForAngularRequestsToFinish();

				// wait for the element
				explicitWaitClickable("sidemenu_logout_CSS");

				// click on the logout option from the side menu
				click("sidemenu_logout_CSS");
				System.out.println("Clicked on the logout option from the side menu.");
				ngDriver.waitForAngularRequestsToFinish();

				helper.loginAndUpdateSystemCompany(data, "username_1", "password_1", "SystemCompany");

			} catch (Throwable t) {
				verificationFailed();
			}

		} catch (Throwable t) {
			helper.questionnaireNotDisplayLogout(data);
		}

		// click on the home icon from the top of the screen
		click("questionnaire_homeburgermenubtn_hide_CSS");
		System.out.println("Clicked on the home icon from the top of the screen.");
		ngDriver.waitForAngularRequestsToFinish();

		// synchronization
		explicitWait("propertylist_title_XPATH");

		// verify the property list
		switchVerification("propertylist_title_XPATH", "Property List", "The property list is not displayed.");

		// DELETE ALL THE NEWLY CREATAED UTILITY BILLS

		System.out.println("***************** DELETE ALL THE NEWLY CREATAED UTILITY BILLS *****************");
		test.log(LogStatus.INFO, "***************** DELETE ALL THE NEWLY CREATAED UTILITY BILLS *****************");
		Reporter.log("***************** DELETE ALL THE NEWLY CREATAED UTILITY BILLS *****************");
		log.info("***************** DELETE ALL THE NEWLY CREATAED UTILITY BILLS *****************");

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
			LocalDate today1 = LocalDate.now();
			String[] todayDate1 = today1.toString().split("-");
			select("sustainability_utilitybills_yearfilterdd_XPATH", todayDate1[0]);

			// select the all option from the meter filter
			select("sustainability_utilitybills_meterfilter_XPATH", "All");
			ngDriver.waitForAngularRequestsToFinish();
			System.out.println("Selected the all option from the meter filter.");

			// ========= TEMPORARY CODE - ABOVE =========

			// click on the refresh button
			click("sustainability_utilitybills_refreshbtn_XPATH");
			ngDriver.waitForAngularRequestsToFinish();
			System.out.println("Clicked on the refresh button.");

			try {

				String pages = driver.findElement(By.xpath("(//strong)[1]")).getText();
				String[] arrOfStr = pages.split(" ");
				String pageno = arrOfStr[3];
				int pagecount = Integer.parseInt(pageno);

				for (int j = 0; j < pagecount; j++) {

					List<WebElement> bill = driver
							.findElements(By.xpath("//table[@class='table table-striped text-center']//tbody//tr"));
					int billnum = bill.size();

					for (int i = 0; i < billnum; i++) {

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

						// click on the first record of the utility bill
						click("sustainability_utilitybills_firstrecord_XPATH");
						ngDriver.waitForAngularRequestsToFinish();
						System.out.println("Clicked on the first record of the utility bill.");

						// wait for the element
						explicitWaitClickable("sustainability_utilitybills_deletebtn_XPATH");

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

					}
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

		// RESET THE APPLIED PERMISSION

		System.out.println("**************** RESET THE APPLIED PERMISSIONS ****************");
		test.log(LogStatus.INFO, "**************** RESET THE APPLIED PERMISSIONS ****************");
		Reporter.log("**************** RESET THE APPLIED PERMISSIONS ****************");
		log.info("**************** RESET THE APPLIED PERMISSIONS ****************");

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

			// click on the security tab
			click("questionnaire_securitytab_XPATH");
			System.out.println("Clicked on the security tab.");
			ngDriver.waitForAngularRequestsToFinish();

			// click on the security settings option
			click("questionnaire_securotysettingsoption_XPATH");
			System.out.println("Clicked on the security settings option.");
			ngDriver.waitForAngularRequestsToFinish();

			// enter security setting name in the search field
			clear("propertyproject_le_filtertxt_CSS");
			type("propertyproject_le_filtertxt_CSS", data.get("security_setting_1"));
			ngDriver.waitForAngularRequestsToFinish();
			System.out.println("Entered security setting name in the search field.");

			// click on the searched result
			click("sustainability_utilitybills_securitysettings6_XPATH");
			ngDriver.waitForAngularRequestsToFinish();
			System.out.println("Clicked on the searched result.");

			// click on the select role field
			click("propertyproject_securitysettings1_selectroles_CSS");
			ngDriver.waitForAngularRequestsToFinish();
			System.out.println("Clicked on the select role field.");

			// click on the none button
			click("propertyproject_securitysettings1_nonebtn_CSS");
			ngDriver.waitForAngularRequestsToFinish();
			System.out.println("Clicked on the none button.");

			// enter the name of the role in search field
			clear("propertyproject_securitysettings1_searchtxt_CSS");
			ngDriver.waitForAngularRequestsToFinish();
			System.out.println("Clear the search field.");
			type("propertyproject_securitysettings1_searchtxt_CSS", data.get("role_1"));
			ngDriver.waitForAngularRequestsToFinish();
			System.out.println("Entered the name of the role in search field.");

			// click on the searched result
			click("sustainability_utilitybills_searchedpm_XPATH");
			ngDriver.waitForAngularRequestsToFinish();
			System.out.println("Clicked on the searched result.");

			// click on the select role field
			click("propertyproject_securitysettings1_selectroles_CSS");
			ngDriver.waitForAngularRequestsToFinish();
			System.out.println("Clicked on the select role field.");

			// click on the save button
			click("propertyproject_securitysettings1_savebtn_CSS");
			ngDriver.waitForAngularRequestsToFinish();
			System.out.println("Clicked on the save button.");

			// wait for the element
			explicitWaitClickable("closetoastmsg_CSS");

			// click on the toaster close button
			click("closetoastmsg_CSS");
			ngDriver.waitForAngularRequestsToFinish();
			System.out.println("Clicked on the toaster close button.");

		} catch (Throwable t) {
			verificationFailed();
		}

		// click on the home icon
		click("questionnaire_homeburgermenubtn_CSS");
		ngDriver.waitForAngularRequestsToFinish();
		System.out.println("Clicked on the home icon.");

		// wait for the element
		explicitWait("propertylist_title_XPATH");

		// verify the property list
		switchVerification("propertylist_title_XPATH", "Property List", "The property list is not displayed.");

	}
}
