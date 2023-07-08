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
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.SkipException;
import org.testng.annotations.Test;

import com.relevantcodes.extentreports.LogStatus;

import base.TestBase;
import utilities.TestUtil;

public class RR5964Sustainability4Test extends TestBase {

	@Test(dataProviderClass = TestUtil.class, dataProvider = "dp")
	public void rR5964Sustainability4Test(Hashtable<String, String> data) throws IOException, InterruptedException {

		execution(data, "rR5964Sustainability4Test");

		// PERFORME UPDATE SNAPSHOT FEATURE OF THE UTILITY BILLS AND VERIFIED IN
		// RESPECTIVE DASHBOARD

		System.out
				.println("PERFORME UPDATE SNAPSHOT FEATURE OF THE UTILITY BILLS AND VERIFIED IN RESPECTIVE DASHBOARD");
		test.log(LogStatus.INFO,
				"PERFORME UPDATE SNAPSHOT FEATURE OF THE UTILITY BILLS AND VERIFIED IN RESPECTIVE DASHBOARD");
		Reporter.log("PERFORME UPDATE SNAPSHOT FEATURE OF THE UTILITY BILLS AND VERIFIED IN RESPECTIVE DASHBOARD");
		log.info("PERFORME UPDATE SNAPSHOT FEATURE OF THE UTILITY BILLS AND VERIFIED IN RESPECTIVE DASHBOARD");

		// refresh the page
		driver.navigate().refresh();
		Thread.sleep(5000);
		driver.navigate().refresh();

		System.out.println("Navigate to the Home Screen i.e. Property List Screen.");

		// DELETE THE ALL THE PREVIOUSLY CREATED UTILITY BILLS RECORDS

		System.out.println(
				"***************** DELETE THE ALL THE PREVIOUSLY CREATED UTILITY BILLS RECORDS *****************");
		test.log(LogStatus.INFO,
				"***************** DELETE THE ALL THE PREVIOUSLY CREATED UTILITY BILLS RECORDS *****************");
		Reporter.log("***************** DELETE THE ALL THE PREVIOUSLY CREATED UTILITY BILLS RECORDS *****************");
		log.info("***************** DELETE THE ALL THE PREVIOUSLY CREATED UTILITY BILLS RECORDS *****************");

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

			try {
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

				// wait for the element
				Thread.sleep(5000);

				try {
					String pages = driver.findElement(By.xpath("(//strong)[1]")).getText();
					String[] arrOfStr = pages.split(" ");
					String pageno = arrOfStr[3];
					int pagecount = Integer.parseInt(pageno);

					for (int i = 0; i < pagecount; i++) {

						List<WebElement> bill = driver
								.findElements(By.xpath("//table[@class='table table-striped text-center']//tbody//tr"));
						int billnum = bill.size();

						for (int j = 0; j < billnum; j++) {

							// click on the first record of the utility bill
							click("sustainability_utilitybills_firstrecord_XPATH");
							ngDriver.waitForAngularRequestsToFinish();
							System.out.println("Clicked on the first record of the utility bill.");

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
					verificationFailedMessage("The deleting process of the bills caused some issue.");
				}

			} catch (Throwable t) {
				successMessage("No record available in the Utility Bills Record Listing.");
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

		// CREATE NEW UTILITY BILLS RECORD - AT PROPERTY LEVEL

		System.out.println("***************** CREATE NEW UTILITY BILLS RECORD - AT PROPERTY LEVEL *****************");
		test.log(LogStatus.INFO,
				"***************** CREATE NEW UTILITY BILLS RECORD - AT PROPERTY LEVEL *****************");
		Reporter.log("***************** CREATE NEW UTILITY BILLS RECORD - AT PROPERTY LEVEL *****************");
		log.info("***************** CREATE NEW UTILITY BILLS RECORD - AT PROPERTY LEVEL *****************");

		String utilityBills = RandomStringUtils.randomNumeric(8);

		Random random = new Random();
		int billCount = random.nextInt(15 - 10) + 10;

		int consumptionTotal = 0;

		try {

			// enter the property name in the search field
			type("envreports_propertylist_filtertxt_CSS", data.get("property_1"));
			ngDriver.waitForAngularRequestsToFinish();
			System.out.println("Entered the property name in the search field.");

			// click on the sustainability icon
			click("sustainabilityicon_CSS");
			System.out.println("Clicked on the Sustainability icon.");
			ngDriver.waitForAngularRequestsToFinish();

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
				type("sustainability_utilitybills_meternumber_XPATH", utilityBills + i);
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
				String random1 = RandomStringUtils.randomNumeric(5);
				clear("sustainability_utilitybills_consumption_XPATH");
				type("sustainability_utilitybills_consumption_XPATH", random1);
				ngDriver.waitForAngularRequestsToFinish();
				System.out.println("Entered details in the Consumption field.");

				// sum of the consumptions
				int consumption_int = Integer.parseInt(random1);
				consumptionTotal = consumptionTotal + consumption_int;
				System.out.println(
						"The total consumption is " + consumptionTotal + " after " + (i + 1) + " bills are created.");

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
				String random2 = RandomStringUtils.randomNumeric(8);
				clear("sustainability_utilitybills_totalcost_XPATH");
				type("sustainability_utilitybills_totalcost_XPATH", random2);
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

				// scroll up the screen
				JavascriptExecutor js = (JavascriptExecutor) driver;
				js.executeScript("window.scrollTo(0,0)");

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

				// wait for the element
				Thread.sleep(5000);

				// enter the newly created certification record in the search field
				clear("sustainability_searchtxt_XPATH");
				type("sustainability_searchtxt_XPATH", utilityBills + i);
				ngDriver.waitForAngularRequestsToFinish();
				System.out.println("Entered the newly created certification record in the search field.");

				// verify the newly created utility meter record
				try {
					String UtilityBills = "//td[contains(text(),'" + utilityBills + i + "')]";
					String addedUtilityBills = (driver.findElement(By.xpath(UtilityBills)).getText()).trim();
					if (addedUtilityBills.equals(utilityBills + i)) {

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
							+ utilityBills + i + "')]";
					String addedUtilityBills = (driver.findElement(By.xpath(MeterIndicatorRed)).getText()).trim();
					if (addedUtilityBills.equals(utilityBills + i)) {

						successMessage("The meter indicator of the utility bill is verified successfully.");

					} else {

						verificationFailedMessage("The meter indicator of the utility bill is not verified.");

					}
				} catch (Throwable t) {
					verificationFailed();
				}

				// click on the newly created utility bill record
				String redIndicator = "//td[contains(text(),'" + utilityBills + i
						+ "')]//i[@ng-click='goToAndCreateMeter(d.meterNumber)' and @class='icon-meter i-red']";
				driver.findElement(By.xpath(redIndicator)).click();
				ngDriver.waitForAngularRequestsToFinish();
				System.out.println("Clicked on the newly created bill record.");

				// validate the meter number
				try {
					String meterValue = driver
							.findElement(By.xpath(OR.getProperty("sustainability_utilitymeter_metertxt_XPATH")))
							.getAttribute("value");
					if (meterValue.equals(utilityBills + i)) {
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
				type("sustainability_searchtxt_XPATH", utilityBills + i);
				ngDriver.waitForAngularRequestsToFinish();
				System.out.println("Entered the newly created certification record in the search field.");

				// verify the newly created utility meter record
				try {
					String UtilityBills = "//td[contains(text(),'" + utilityBills + i + "')]";
					String addedUtilityBills = (driver.findElement(By.xpath(UtilityBills)).getText()).trim();
					if (addedUtilityBills.equals(utilityBills + i)) {

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
							+ utilityBills + i + "')]";
					String addedUtilityBills1 = (driver.findElement(By.xpath(MeterIndicatorGreen)).getText()).trim();
					if (addedUtilityBills1.equals(utilityBills + i)) {

						successMessage("The meter indicator of the utility bill is verified successfully.");

					} else {

						verificationFailedMessage("The meter indicator of the utility bill is not verified.");

					}
				} catch (Throwable t) {
					verificationFailed();
				}

			}

			// validate total consumption
			System.out.println("TOTAL CONSMPTION = " + consumptionTotal);

			// wait for the element
			Thread.sleep(5000);

			// click on the action button
			click("sustainability_utilitybills_actionicon_XPATH");
			ngDriver.waitForAngularRequestsToFinish();
			System.out.println("Clicked on the action button.");

			// click on the update snapshot option
			click("sustainability_utilitybills_actionicon_updatestapshotoption_XPATH");
			ngDriver.waitForAngularRequestsToFinish();
			System.out.println("Clicked on the update snapshot option.");

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

		// RUN THE BATCH OF THE ENERGY CONSUMPTION

		System.out.println("***************** RUN THE BATCH OF THE ENERGY CONSUMPTION *****************");
		test.log(LogStatus.INFO, "***************** RUN THE BATCH OF THE ENERGY CONSUMPTION *****************");
		Reporter.log("***************** RUN THE BATCH OF THE ENERGY CONSUMPTION *****************");
		log.info("***************** RUN THE BATCH OF THE ENERGY CONSUMPTION *****************");

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

		// VALIDATE TOTAL CONSAMPTION COUNT IN SUSTAINABILITY DASHBOARD

		System.out.println(
				"***************** VALIDATE TOTAL CONSAMPTION COUNT IN SUSTAINABILITY DASHBOARD *****************");
		test.log(LogStatus.INFO,
				"***************** VALIDATE TOTAL CONSAMPTION COUNT IN SUSTAINABILITY DASHBOARD *****************");
		Reporter.log(
				"***************** VALIDATE TOTAL CONSAMPTION COUNT IN SUSTAINABILITY DASHBOARD *****************");
		log.info("***************** VALIDATE TOTAL CONSAMPTION COUNT IN SUSTAINABILITY DASHBOARD *****************");

		try {

			// wait for the element
			Thread.sleep(5000);

			// click on the side menu
			click("ssc_leftsidemenubtn_CSS");
			ngDriver.waitForAngularRequestsToFinish();
			System.out.println("Clicked on the side menu.");

			// wait for the element
			Thread.sleep(5000);

			// click on the sustainability option
			click("sidemenu_sustainability_CSS");
			ngDriver.waitForAngularRequestsToFinish();
			System.out.println("Clicked on the sustainability option.");

			// select the user in the to year field
			LocalDate currentyear = LocalDate.now();
			String currentyear_String = currentyear.toString();
			String[] currentDate_Arr = currentyear_String.split("-");
			String actual_currentYear = currentDate_Arr[0];
			select("sustainability_utilitybills_energydashboard_toyear_XPATH", actual_currentYear);
			ngDriver.waitForAngularRequestsToFinish();
			System.out.println("Selected the user in the to year field.");

			// scroll down the screen
			JavascriptExecutor js = (JavascriptExecutor) driver;
			js.executeScript("window.scrollBy(0,100)");

			// click on the consumption radio button
			click("sustainability_energydashboard_consumptionckbx_XPATH");
			ngDriver.waitForAngularRequestsToFinish();
			System.out.println("Clicked on the consumption radio button.");

			// scroll up the screen
			js.executeScript("window.scrollBy(0,-100)");

			// click on the refresh button
			click("sustainability_energydashboard_refreshbtn_XPATH");
			ngDriver.waitForAngularRequestsToFinish();
			System.out.println("Clicked on the refresh button.");

			// scroll down to the bottom of the screen
			js.executeScript("window.scrollBy(0,document.body.scrollHeight)");

			// validate the total consumption
			try {
				String totalConsumption = "//span[text()='" + actual_currentYear
						+ "']//parent::td//following-sibling::td[3]";
				String actual_totalConsumption = (driver.findElement(By.xpath(totalConsumption)).getText()).trim();
				int actual_totalConsumption_int = Integer.parseInt(actual_totalConsumption);

				if (actual_totalConsumption_int == consumptionTotal) {

					successMessage("The total consumption count is displayed correctly.");

				} else {
					verificationFailedMessage("The total consumption count is not displayed correctly.");
				}

			} catch (Throwable t) {
				verificationFailedMessage("The total consumption count is not displayed correctly.");
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

		// DELETE THE ALL THE NEWLY CREATED UTILITY BILLS RECORDS

		System.out
				.println("***************** DELETE THE ALL THE NEWLY CREATED UTILITY BILLS RECORDS *****************");
		test.log(LogStatus.INFO,
				"***************** DELETE THE ALL THE NEWLY CREATED UTILITY BILLS RECORDS *****************");
		Reporter.log("***************** DELETE THE ALL THE NEWLY CREATED UTILITY BILLS RECORDS *****************");
		log.info("***************** DELETE THE ALL THE NEWLY CREATED UTILITY BILLS RECORDS *****************");

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

			// wait for the element
			Thread.sleep(5000);

			try {
				String pages = driver.findElement(By.xpath("(//strong)[1]")).getText();
				String[] arrOfStr = pages.split(" ");
				String pageno = arrOfStr[3];
				int pagecount = Integer.parseInt(pageno);

				for (int i = 0; i < pagecount; i++) {

					List<WebElement> bill = driver
							.findElements(By.xpath("//table[@class='table table-striped text-center']//tbody//tr"));
					int billnum = bill.size();

					for (int j = 0; j < billnum; j++) {

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

						// click on the first record of the utility bill
						click("sustainability_utilitybills_firstrecord_XPATH");
						ngDriver.waitForAngularRequestsToFinish();
						System.out.println("Clicked on the first record of the utility bill.");

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
				verificationFailedMessage("The deleting process of the bills caused some issue.");
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

		// DELETE ALL THE UTILITY METER RECORDS
		title("DELETE ALL THE UTILITY METER RECORDS");

		try {

			// click on the Sustainability icon
			click("sustainabilityicon_CSS");

			// wait for the element
			Thread.sleep(5000);

			// click on the side menu
			click("ssc_leftsidemenubtn_CSS");

			// wait for the element
			Thread.sleep(5000);

			// click on the UTILITY METERS option
			click("sustainability_sidemenu_utilitymetersoption_XPATH");

			try {
				String pages = driver.findElement(By.xpath("(//strong)[1]")).getText();
				String[] arrOfStr = pages.split(" ");
				String pageno = arrOfStr[3];
				int pagecount = Integer.parseInt(pageno);

				for (int i = 0; i < pagecount; i++) {

					List<WebElement> bill = driver
							.findElements(By.xpath("//table[@class='table table-striped table-hover']//tbody//tr"));
					int billnum = bill.size();

					for (int j = 0; j < billnum; j++) {

						// click on the delete button
						driver.findElement(By.xpath(
								"//table[@class='table table-striped table-hover']//tbody//tr[1]//td[1]//following-sibling::td[5]"))
								.click();

						// wait for the element
						explicitWaitClickable("sustainability_utilitymeter_deletebtn_confirmation_XPATH");

						// click on the delete button of the confirmation popup
						click("sustainability_utilitymeter_deletebtn_confirmation_XPATH");

						// wait for the element
						explicitWaitClickable("closetoastmsg_CSS");

						// click on the toaster close button
						click("closetoastmsg_CSS");
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

	}
}
