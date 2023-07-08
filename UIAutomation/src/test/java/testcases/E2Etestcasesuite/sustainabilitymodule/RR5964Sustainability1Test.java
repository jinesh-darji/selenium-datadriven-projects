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

public class RR5964Sustainability1Test extends TestBase {

	@Test(dataProviderClass = TestUtil.class, dataProvider = "dp")
	public void rR5964Sustainability1Test(Hashtable<String, String> data) throws IOException, InterruptedException {

		execution(data, "rR5964Sustainability1Test");

		// PERFORMED CRUD OPERATION OF THE UTILITY BILLS MODULE - AT PROPERTY LEVEL

		System.out.println("PERFORMED CRUD OPERATION OF THE UTILITY BILLS MODULE - AT PROPERTY LEVEL");
		test.log(LogStatus.INFO, "PERFORMED CRUD OPERATION OF THE UTILITY BILLS MODULE - AT PROPERTY LEVEL");
		Reporter.log("PERFORMED CRUD OPERATION OF THE UTILITY BILLS MODULE - AT PROPERTY LEVEL");
		log.info("PERFORMED CRUD OPERATION OF THE UTILITY BILLS MODULE - AT PROPERTY LEVEL");

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
		String updateUtilityBills = RandomStringUtils.randomNumeric(8);

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

		// UPDATE THE NEWLY CREATED UTILITY BILLS RECORD

		System.out.println("***************** UPDATE THE NEWLY CREATED UTILITY BILLS RECORD *****************");
		test.log(LogStatus.INFO, "***************** UPDATE THE NEWLY CREATED UTILITY BILLS RECORD *****************");
		Reporter.log("***************** UPDATE THE NEWLY CREATED UTILITY BILLS RECORD *****************");
		log.info("***************** UPDATE THE NEWLY CREATED UTILITY BILLS RECORD *****************");

		try {

			// click on the newly created utility bill record
			LocalDate updateDate = LocalDate.now().minusMonths(6);
			String updateDate_String = updateDate.toString();
			String UtilityBills = "//td[contains(text(),'" + updateDate_String + "')]";
			driver.findElement(By.xpath(UtilityBills)).click();
			ngDriver.waitForAngularRequestsToFinish();
			System.out.println("Clicked on the newly created bill record.");

			// click on the no button of the tenant paid field
			click("sustainability_utilitybills_tenantpaidno_XPATH");
			ngDriver.waitForAngularRequestsToFinish();
			System.out.println("Clicked on the no button of the tenant paid field.");

			// click on the no button of the Estimated field
			click("sustainability_utilitybills_estimatedno_XPATH");
			ngDriver.waitForAngularRequestsToFinish();
			System.out.println("Clicked on the no button of the Estimated field.");

			// enter the details in the Period From field
			LocalDate updateDate1 = LocalDate.now().minusMonths(8);
			String updateDate1_String = updateDate1.toString();
			clear("sustainability_utilitybills_periodfrom_XPATH");
			type("sustainability_utilitybills_periodfrom_XPATH", updateDate1_String);
			ngDriver.waitForAngularRequestsToFinish();
			System.out.println("Entered the details in the Period From field.");

			// enter the details in the Period To field
			LocalDate updateDate2 = LocalDate.now().plusMonths(8);
			String updateDate2_String = updateDate2.toString();
			clear("sustainability_utilitybills_periodto_XPATH");
			type("sustainability_utilitybills_periodto_XPATH", updateDate2_String);
			ngDriver.waitForAngularRequestsToFinish();
			System.out.println("Entered the details in the Period To field.");

			// enter details in the Number of Billing Days field
			clear("sustainability_utilitybills_numberofbillingdays_XPATH");
			type("sustainability_utilitybills_numberofbillingdays_XPATH", "400");
			ngDriver.waitForAngularRequestsToFinish();
			System.out.println("Entered details in the Number of Billing Days field.");

			// enter the details in the reading date field
			LocalDate updateDate3 = LocalDate.now();
			String updateDate3_String = updateDate3.toString();
			clear("sustainability_utilitybills_readingdate_XPATH");
			type("sustainability_utilitybills_readingdate_XPATH", updateDate3_String);
			ngDriver.waitForAngularRequestsToFinish();
			System.out.println("Entered the details in the reading date field.");

			// enter details in the Current Meter Reading field
			clear("sustainability_utilitybills_currentmeterreading_XPATH");
			type("sustainability_utilitybills_currentmeterreading_XPATH", "200");
			ngDriver.waitForAngularRequestsToFinish();
			System.out.println("Entered details in the Current Meter Reading field.");

			// enter details in the Last Meter Reading field
			clear("sustainability_utilitybills_lastmeterreading_XPATH");
			type("sustainability_utilitybills_lastmeterreading_XPATH", "1500");
			ngDriver.waitForAngularRequestsToFinish();
			System.out.println("Entered details in the Last Meter Reading field.");

			// enter details in the Meter Number field
			clear("sustainability_utilitybills_meternumber_XPATH");
			type("sustainability_utilitybills_meternumber_XPATH", updateUtilityBills);
			ngDriver.waitForAngularRequestsToFinish();
			System.out.println("Entered details in the Meter Number field.");

			// enter the details in the Billing Date field
			LocalDate updateDate4 = LocalDate.now().plusDays(7);
			String updateDate4_String = updateDate4.toString();
			clear("sustainability_utilitybills_billingdate_XPATH");
			type("sustainability_utilitybills_billingdate_XPATH", updateDate4_String);
			ngDriver.waitForAngularRequestsToFinish();
			System.out.println("Entered the details in the Billing Date field.");

			// enter details in the Consumption field
			String random22 = RandomStringUtils.randomNumeric(2);
			clear("sustainability_utilitybills_consumption_XPATH");
			type("sustainability_utilitybills_consumption_XPATH", random22);
			ngDriver.waitForAngularRequestsToFinish();
			System.out.println("Entered details in the Consumption field.");

			// enter details in the Adjusted Consumption field
			clear("sustainability_utilitybills_adjustedconsumption_XPATH");
			type("sustainability_utilitybills_adjustedconsumption_XPATH", "0");
			ngDriver.waitForAngularRequestsToFinish();
			System.out.println("Entered details in the Adjusted Consumption field.");

			// select the Unit of Measure option from the dropdown
			select("sustainability_utilitybills_unitofmeasure_XPATH", data.get("update_unit"));
			ngDriver.waitForAngularRequestsToFinish();
			System.out.println("Selected the Unit of Measure option from the dropdown.");

			// enter details in the Peak Demand field
			clear("sustainability_utilitybills_peakdemand_XPATH");
			type("sustainability_utilitybills_peakdemand_XPATH", "20");
			ngDriver.waitForAngularRequestsToFinish();
			System.out.println("Entered details in the Peak Demand field.");

			// select the Peak Demand Unit of Measure option from the dropdown
			select("sustainability_utilitybills_peakdemandunitofmeasure_XPATH", data.get("update_unit"));
			ngDriver.waitForAngularRequestsToFinish();
			System.out.println("Selected the Peak Demand Unit of Measure option from the dropdown.");

			// enter details in the Total Cost field
			clear("sustainability_utilitybills_totalcost_XPATH");
			type("sustainability_utilitybills_totalcost_XPATH", "100");
			ngDriver.waitForAngularRequestsToFinish();
			System.out.println("Entered details in the Total Cost field.");

			// enter details in the Reference Number field
			String random33 = RandomStringUtils.randomNumeric(8);
			clear("sustainability_utilitybills_referencenumber_XPATH");
			type("sustainability_utilitybills_referencenumber_XPATH", random33);
			ngDriver.waitForAngularRequestsToFinish();
			System.out.println("Entered details in the Reference Number field.");

			// enter details in the Control Number field
			String random44 = RandomStringUtils.randomNumeric(8);
			clear("sustainability_utilitybills_controlnumber_XPATH");
			type("sustainability_utilitybills_controlnumber_XPATH", random44);
			ngDriver.waitForAngularRequestsToFinish();
			System.out.println("Entered details in the Control Number field.");

			// enter details in the Multiplier field
			String random55 = RandomStringUtils.randomNumeric(2);
			clear("sustainability_utilitybills_multiplier_XPATH");
			type("sustainability_utilitybills_multiplier_XPATH", random55);
			ngDriver.waitForAngularRequestsToFinish();
			System.out.println("Entered details in the Multiplier field.");

			// enter details in the Description field
			clear("sustainability_utilitybills_description_XPATH");
			type("sustainability_utilitybills_description_XPATH", data.get("update_description"));
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
			type("sustainability_searchtxt_XPATH", updateUtilityBills);
			ngDriver.waitForAngularRequestsToFinish();
			System.out.println("Entered the newly created certification record in the search field.");

			// verify the updated utility bill record
			try {
				String UtilityBills2 = "//td[contains(text(),'" + updateUtilityBills + "')]";
				String addedUtilityBills2 = (driver.findElement(By.xpath(UtilityBills2)).getText()).trim();
				if (addedUtilityBills2.equals(updateUtilityBills)) {

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

		// DELETE THE UPDATED UTILITY BILLS RECORD

		System.out.println("***************** DELETE THE UPDATED UTILITY BILLS RECORD *****************");
		test.log(LogStatus.INFO, "***************** DELETE THE UPDATED UTILITY BILLS RECORD *****************");
		Reporter.log("***************** DELETE THE UPDATED UTILITY BILLS RECORD *****************");
		log.info("***************** DELETE THE UPDATED UTILITY BILLS RECORD *****************");

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
			LocalDate deleteDate = LocalDate.now().minusMonths(8);
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

			// click on the refresh button
			click("sustainability_utilitybills_refreshbtn_XPATH");
			ngDriver.waitForAngularRequestsToFinish();
			System.out.println("Clicked on the refresh button.");

			// enter the updated utility meter record in the search field
			clear("sustainability_searchtxt_XPATH");
			type("sustainability_searchtxt_XPATH", updateUtilityBills);
			ngDriver.waitForAngularRequestsToFinish();
			System.out.println("Entered the updated utility meter record in the search field.");

			// verify the deleted utility bill record displayed or not

			try {

				String UpdateUtilityBills1 = "//td[contains(text(),'" + updateUtilityBills + "')]";
				String updatedUtilityBills1 = (driver.findElement(By.xpath(UpdateUtilityBills1)).getText()).trim();

				if (updatedUtilityBills1.equals(updateUtilityBills)) {

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

	}
}
