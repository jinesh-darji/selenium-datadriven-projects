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
		title("PERFORME UPDATE SNAPSHOT FEATURE OF THE UTILITY BILLS AND VERIFIED IN RESPECTIVE DASHBOARD");

		// refresh the page
		driver.navigate().refresh();
		Thread.sleep(5000);
		driver.navigate().refresh();

		// DELETE THE ALL THE PREVIOUSLY CREATED UTILITY BILLS RECORDS
		title("DELETE THE ALL THE PREVIOUSLY CREATED UTILITY BILLS RECORDS");

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

			try {
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

		// synchronization
		explicitWait("propertylist_title_XPATH");

		// verify the property list
		switchVerification("propertylist_title_XPATH", "Property List", "The property list is not displayed.");

		// CREATE NEW UTILITY BILLS RECORD - AT PROPERTY LEVEL
		title("CREATE NEW UTILITY BILLS RECORD - AT PROPERTY LEVEL");

		String utilityBills = RandomStringUtils.randomNumeric(8);

		Random random = new Random();
		int billCount = random.nextInt(15 - 10) + 10;

		int consumptionTotal = 0;

		try {

			// enter the property name in the search field
			type("envreports_propertylist_filtertxt_CSS", data.get("property_1"));

			// click on the sustainability icon
			click("sustainabilityicon_CSS");

			// click on the side menu
			click("ssc_leftsidemenubtn_CSS");

			// wait for the element
			Thread.sleep(5000);

			// click on the utility bills option
			click("sustainability_sidemenu_utilitybillsoption_XPATH");

			for (int i = 0; i < billCount; i++) {

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
				type("sustainability_utilitybills_meternumber_XPATH", utilityBills + i);

				// enter the details in the Billing Date field
				LocalDate addDate4 = LocalDate.now().plusDays(5);
				String addDate4_String = addDate4.toString();
				type("sustainability_utilitybills_billingdate_XPATH", addDate4_String);

				// enter details in the Consumption field
				String random1 = RandomStringUtils.randomNumeric(5);
				type("sustainability_utilitybills_consumption_XPATH", random1);

				// sum of the consumptions
				int consumption_int = Integer.parseInt(random1);
				consumptionTotal = consumptionTotal + consumption_int;
				System.out.println(
						"The total consumption is " + consumptionTotal + " after " + (i + 1) + " bills are created.");

				// enter details in the Adjusted Consumption field
				type("sustainability_utilitybills_adjustedconsumption_XPATH", "0");

				// select the Unit of Measure option from the dropdown
				select("sustainability_utilitybills_unitofmeasure_XPATH", data.get("unit"));

				// enter details in the Peak Demand field
				type("sustainability_utilitybills_peakdemand_XPATH", "10");

				// select the Peak Demand Unit of Measure option from the dropdown
				select("sustainability_utilitybills_peakdemandunitofmeasure_XPATH", data.get("unit"));

				// enter details in the Total Cost field
				String random2 = RandomStringUtils.randomNumeric(8);
				type("sustainability_utilitybills_totalcost_XPATH", random2);

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

				// scroll up the screen
				scrollTop();

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

				// wait for the element
				Thread.sleep(5000);

				// enter the newly created certification record in the search field
				type("sustainability_searchtxt_XPATH", utilityBills + i);

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

				// validate the meter number
				try {
					String meterValue = driver
							.findElement(By.xpath(OR.getProperty("sustainability_utilitymeter_metertxt_XPATH")))
							.getAttribute("value");
					if (meterValue.equals(utilityBills + i)) {
						successMessage("The utility meter is verified successfully.");
					} else {

						verificationFailedMessage("The utility meter is not verified.");
					}
				} catch (Throwable t) {
					verificationFailed();
				}

				// enter the details in the description field
				type("sustainability_utilitymeter_descriptiontxt_XPATH", data.get("description"));

				// select the utility type from the drop down
				select("sustainability_utilitymeter_utilitytypedd_XPATH", data.get("utility_type"));

				// select the unit of measurement
				select("sustainability_utilitymeter_unitofmeasurementdd_XPATH", data.get("unit_measurement"));

				// scroll down the screen
				scrollTillElement("sustainability_utilitymeter_unitofmeasurementdd_XPATH");

				// click on the yes option of the is green energy field
				click("sustainability_utilitymeter_isgreenenergyyes_XPATH");

				// select the Green Consumption Category from the dropdown
				select("sustainability_utilitymeter_greenconsumptioncategorydd_XPATH",
						data.get("green_consumption_category"));

				// enter the details in the area covered
				type("sustainability_utilitymeter_areacoveredtxt_XPATH", "10");

				// select the GHG Emissions Scope from the dropdown
				select("sustainability_utilitymeter_scope_XPATH", data.get("scope"));

				// select the Consumption Category from the dropdown
				select("sustainability_utilitymeter_consumptioncategorydd_XPATH", data.get("consumption_category"));

				// select the Source of Data from the dropdown
				select("sustainability_utilitymeter_sourceofdatadd_XPATH", data.get("source_of_data"));

				// select the Floor Area Type from the dropdown
				select("sustainability_utilitymeter_floorareatypeadd_XPATH", data.get("floor_area_type"));

				// enter the details in the Meter Manufacturer field
				type("sustainability_utilitymeter_metermanufacturertxt_XPATH", data.get("meter_manufacturer"));

				// select the Special Use Type from the dropdown
				select("sustainability_utilitymeter_specialusetypedd_XPATH", data.get("special_use_type"));

				// select the Financial Control of Meter from the dropdown
				select("sustainability_utilitymeter_financialcontrolofmeterdd_XPATH",
						data.get("financial_control_of_meter"));

				// scroll down the screen
				scrollByPixel(100);

				// enter the details in the Date Installed field
				LocalDate addCurrentDate1 = LocalDate.now();
				String addCurrentDate1_String = addCurrentDate1.toString();
				type("sustainability_utilitymeter_dateinstalled_XPATH", addCurrentDate1_String);

				// enter the details in the Date Activated field
				LocalDate addCurrentDate2 = LocalDate.now();
				String addCurrentDate2_String = addCurrentDate2.toString();
				type("sustainability_utilitymeter_dateactivated_XPATH", addCurrentDate2_String);

				// enter the details in the Date Deactivated field
				LocalDate addFutureDate1 = LocalDate.now().plusMonths(6);
				String addFutureDate1_String = addFutureDate1.toString();
				type("sustainability_utilitymeter_datedeactivated_XPATH", addFutureDate1_String);

				// click on the save button
				click("sustainability_utilitymeter_savebtn_XPATH");

				// wait for the element
				explicitWaitClickable("closetoastmsg_CSS");

				// click on the toaster close button
				click("closetoastmsg_CSS");

				// enter the newly created certification record in the search field
				type("sustainability_searchtxt_XPATH", utilityBills + i);

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

			// click on the update snapshot option
			click("sustainability_utilitybills_actionicon_updatestapshotoption_XPATH");

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

		// RUN THE BATCH OF THE ENERGY CONSUMPTION
		title("RUN THE BATCH OF THE ENERGY CONSUMPTION");

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

		// VALIDATE TOTAL CONSAMPTION COUNT IN SUSTAINABILITY DASHBOARD
		title("VALIDATE TOTAL CONSAMPTION COUNT IN SUSTAINABILITY DASHBOARD");

		try {

			// wait for the element
			Thread.sleep(5000);

			// click on the side menu
			click("ssc_leftsidemenubtn_CSS");

			// wait for the element
			Thread.sleep(5000);

			// click on the sustainability option
			click("sidemenu_sustainability_CSS");

			// select the user in the to year field
			LocalDate currentyear = LocalDate.now();
			String currentyear_String = currentyear.toString();
			String[] currentDate_Arr = currentyear_String.split("-");
			String actual_currentYear = currentDate_Arr[0];
			select("sustainability_utilitybills_energydashboard_toyear_XPATH", actual_currentYear);

			// scroll down the screen
			scrollByPixel(100);

			// click on the consumption radio button
			click("sustainability_energydashboard_consumptionckbx_XPATH");

			// scroll up the screen
			scrollByPixel(-100);

			// click on the refresh button
			click("sustainability_energydashboard_refreshbtn_XPATH");

			// scroll down to the bottom of the screen
			scrollBottom();

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

		// synchronization
		explicitWait("propertylist_title_XPATH");

		// verify the property list
		switchVerification("propertylist_title_XPATH", "Property List", "The property list is not displayed.");

		// DELETE THE ALL THE NEWLY CREATED UTILITY BILLS RECORDS
		title("DELETE THE ALL THE NEWLY CREATED UTILITY BILLS RECORDS");

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

						// click on the clear button
						click("sustainability_utilitybills_filter_clearbtn_XPATH");

						// enter utility in the search field
						type("sustainability_utilitybills_filter_searchtxt_XPATH", "Electricity");

						// click on the searched result
						click("sustainability_utilitybills_filter_searchedresult_XPATH");

						// select the current year in the dropdown
						LocalDate today1 = LocalDate.now();
						String[] todayDate1 = today1.toString().split("-");
						select("sustainability_utilitybills_yearfilterdd_XPATH", todayDate1[0]);

						// select the all option from the meter filter
						select("sustainability_utilitybills_meterfilter_XPATH", "All");

						// ========= TEMPORARY CODE - ABOVE =========

						// click on the refresh button
						click("sustainability_utilitybills_refreshbtn_XPATH");

						// click on the first record of the utility bill
						click("sustainability_utilitybills_firstrecord_XPATH");

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

		// synchronization
		explicitWait("propertylist_title_XPATH");

		// verify the property list
		switchVerification("propertylist_title_XPATH", "Property List", "The property list is not displayed.");

	}
}