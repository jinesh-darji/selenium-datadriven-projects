package testcases.E2Etestcasesuite.sustainabilitymodule;

import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;
import java.io.File;
import java.io.IOException;
import java.time.LocalDate;
import java.util.Hashtable;
import java.util.List;
import java.util.Random;

import org.apache.commons.lang3.RandomStringUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Reporter;
import org.testng.SkipException;
import org.testng.annotations.Test;

import com.relevantcodes.extentreports.LogStatus;

import base.TestBase;
import utilities.ExcelReader;
import utilities.TestUtil;

public class RR5964Sustainability5Test extends TestBase {

	@Test(dataProviderClass = TestUtil.class, dataProvider = "dp")
	public void rR5964Sustainability5Test(Hashtable<String, String> data) throws IOException, InterruptedException {

		execution(data, "rR5964Sustainability5Test");

		// VERIFY THE EXTRACT AND IMPORT FEATURE OF THE UTILITY BILLS MODULE

		System.out.println("VERIFY THE EXTRACT AND IMPORT FEATURE OF THE UTILITY BILLS MODULE");
		test.log(LogStatus.INFO, "VERIFY THE EXTRACT AND IMPORT FEATURE OF THE UTILITY BILLS MODULE");
		Reporter.log("VERIFY THE EXTRACT AND IMPORT FEATURE OF THE UTILITY BILLS MODULE");
		log.info("VERIFY THE EXTRACT AND IMPORT FEATURE OF THE UTILITY BILLS MODULE");

		// refresh the page
		driver.navigate().refresh();
		explicitWait("sustainabilityicon_CSS");
		driver.navigate().refresh();

		System.out.println("Navigate to the Home Screen i.e. Property List Screen.");

		// DELETE ALL THE PREVIOUSLY CREATED UTILITY BILLS RECORD

		System.out
				.println("***************** DELETE ALL THE PREVIOUSLY CREATED UTILITY BILLS RECORD *****************");
		test.log(LogStatus.INFO,
				"***************** DELETE ALL THE PREVIOUSLY CREATED UTILITY BILLS RECORD *****************");
		Reporter.log("***************** DELETE ALL THE PREVIOUSLY CREATED UTILITY BILLS RECORD *****************");
		log.info("***************** DELETE ALL THE PREVIOUSLY CREATED UTILITY BILLS RECORD *****************");

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

		// CREATE RANDOM NUMBER OF NEW UTILITY BILLS RECORD - AT PROPERTY LEVEL

		System.out.println(
				"***************** CREATE RANDOM NUMBER OF NEW UTILITY BILLS RECORD - AT PROPERTY LEVEL *****************");
		test.log(LogStatus.INFO,
				"***************** CREATE RANDOM NUMBER OF NEW UTILITY BILLS RECORD - AT PROPERTY LEVEL *****************");
		Reporter.log(
				"***************** CREATE RANDOM NUMBER OF NEW UTILITY BILLS RECORD - AT PROPERTY LEVEL *****************");
		log.info(
				"***************** CREATE RANDOM NUMBER OF NEW UTILITY BILLS RECORD - AT PROPERTY LEVEL *****************");

		String utilityBills = RandomStringUtils.randomNumeric(8);
		String updateUtilityMeter1 = RandomStringUtils.randomAlphanumeric(8);
		String updateUtilityMeter2 = RandomStringUtils.randomAlphanumeric(8);
		String updateControlNumber1 = RandomStringUtils.randomAlphanumeric(8);
		String updateControlNumber2 = RandomStringUtils.randomAlphanumeric(8);
		String updateInvoiceNumber1 = RandomStringUtils.randomAlphanumeric(8);
		String updateInvoiceNumber2 = RandomStringUtils.randomAlphanumeric(8);
		String updateConsumption1 = RandomStringUtils.randomAlphanumeric(6);
		String updateConsumption2 = RandomStringUtils.randomAlphanumeric(6);
		String updateTotalCost1 = RandomStringUtils.randomAlphanumeric(6);
		String updateTotalCost2 = RandomStringUtils.randomAlphanumeric(6);

		Random random = new Random();
		int billCount = random.nextInt(7 - 3) + 3;

		String fetch1 = null;
		String fetch2 = null;
		String fetch3 = null;
		String fetch4 = null;
		String fetch5 = null;
		String fetch6 = null;
		String fetch7 = null;
		String fetch8 = null;
		String fetch9 = null;
		String fetch10 = null;
		String fetch11 = null;
		String fetch12 = null;
		String fetch13 = null;
		String fetch14 = null;

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
				LocalDate addDate1 = LocalDate.now().minusMonths(1);
				String addDate1_String = addDate1.toString();
				clear("sustainability_utilitybills_periodfrom_XPATH");
				type("sustainability_utilitybills_periodfrom_XPATH", addDate1_String);
				ngDriver.waitForAngularRequestsToFinish();
				System.out.println("Entered the details in the Period From field.");

				// enter the details in the Period To field
				LocalDate addDate2 = LocalDate.now().plusMonths(1);
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
				String random3 = RandomStringUtils.randomNumeric(6);
				clear("sustainability_utilitybills_totalcost_XPATH");
				type("sustainability_utilitybills_totalcost_XPATH", random3);
				ngDriver.waitForAngularRequestsToFinish();
				System.out.println("Entered details in the Total Cost field.");

				// enter details in the Reference Number field
				String random4 = RandomStringUtils.randomNumeric(8);
				clear("sustainability_utilitybills_referencenumber_XPATH");
				type("sustainability_utilitybills_referencenumber_XPATH", random4);
				ngDriver.waitForAngularRequestsToFinish();
				System.out.println("Entered details in the Reference Number field.");

				// enter details in the Control Number field
				String random5 = RandomStringUtils.randomNumeric(8);
				clear("sustainability_utilitybills_controlnumber_XPATH");
				type("sustainability_utilitybills_controlnumber_XPATH", random5);
				ngDriver.waitForAngularRequestsToFinish();
				System.out.println("Entered details in the Control Number field.");

				// enter details in the Multiplier field
				String random6 = RandomStringUtils.randomNumeric(2);
				clear("sustainability_utilitybills_multiplier_XPATH");
				type("sustainability_utilitybills_multiplier_XPATH", random6);
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

		// EXTRACT AND IMPORT THE NEWLY CREATED UTILITY BILLS

		System.out.println("***************** EXTRACT AND IMPORT THE NEWLY CREATED UTILITY BILLS *****************");
		test.log(LogStatus.INFO,
				"***************** EXTRACT AND IMPORT THE NEWLY CREATED UTILITY BILLS *****************");
		Reporter.log("***************** EXTRACT AND IMPORT THE NEWLY CREATED UTILITY BILLS *****************");
		log.info("***************** EXTRACT AND IMPORT THE NEWLY CREATED UTILITY BILLS *****************");

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

			// wait for the element
			Thread.sleep(5000);

			// click on the action icon
			click("sustainability_utilitybills_actionicon_XPATH");
			ngDriver.waitForAngularRequestsToFinish();
			System.out.println("Clicked on the action icon.");

			// click on the extraction consumption option
			click("sustainability_utilitybills_extractconsumption_XPATH");
			ngDriver.waitForAngularRequestsToFinish();
			System.out.println("Clicked on the extraction consumption option.");

			// wait for the element
			Thread.sleep(5000);

			// click on the extraction button
			click("sustainability_utilitybills_extractbtn_XPATH");
			ngDriver.waitForAngularRequestsToFinish();
			System.out.println("Clicked on the extraction button.");

			// wait for the element
			Thread.sleep(5000);

			// fetch the record from the download file

			File downloaded = getLastModified("C:\\Users\\Jinesh\\Downloads");
			String path_string = downloaded.toString();
			System.out.println(path_string);

			ExcelReader file = new ExcelReader(path_string);

			// validate the count of the row is displayed correctly or not
			try {
				int actualRowCount = file.getRowCount("Utility Invoices");
				if ((actualRowCount - 1) == billCount) {

					successMessage("The newly created bills record count is displayed correctly.");

				} else {
					verificationFailedMessage("The newly created bills record count is not displayed correctly.");
				}
			} catch (Throwable t) {
				verificationFailedMessage("The newly created bills record count is not displayed correctly.");
			}

			// wait for the element
			Thread.sleep(5000);

			// update the details of the first record from the list
			file.setCellData("Utility Invoices", "Control Number", 2, updateControlNumber1);
			file.setCellData("Utility Invoices", "Invoice Number", 2, updateInvoiceNumber1);
			file.setCellData("Utility Invoices", "Meter Number", 2, updateUtilityMeter1);
			file.setCellData("Utility Invoices", "Total Consumption", 2, updateConsumption1);
			file.setCellData("Utility Invoices", "Total Cost", 2, updateTotalCost1);
			file.setCellData("Utility Invoices", "Tenant Consumption", 2, "N");
			file.setCellData("Utility Invoices", "Is Estimate", 2, "N");

			// wait for the element
			Thread.sleep(5000);

			// update the details of the third record from the list
			file.setCellData("Utility Invoices", "Control Number", 4, updateControlNumber2);
			file.setCellData("Utility Invoices", "Invoice Number", 4, updateInvoiceNumber2);
			file.setCellData("Utility Invoices", "Meter Number", 4, updateUtilityMeter2);
			file.setCellData("Utility Invoices", "Total Consumption", 4, updateConsumption2);
			file.setCellData("Utility Invoices", "Total Cost", 4, updateTotalCost2);
			file.setCellData("Utility Invoices", "Tenant Consumption", 4, "N");
			file.setCellData("Utility Invoices", "Is Estimate", 4, "N");

			// wait for the element
			Thread.sleep(5000);

			// get the details of first record from the list
			fetch1 = file.getCellData("Utility Invoices", "Control Number", 2);
			fetch2 = file.getCellData("Utility Invoices", "Invoice Number", 2);
			fetch3 = file.getCellData("Utility Invoices", "Meter Number", 2);
			fetch4 = file.getCellData("Utility Invoices", "Total Consumption", 2);
			fetch5 = file.getCellData("Utility Invoices", "Total Cost", 2);
			fetch6 = file.getCellData("Utility Invoices", "Tenant Consumption", 2);
			fetch7 = file.getCellData("Utility Invoices", "Is Estimate", 2);

			// wait for the element
			Thread.sleep(5000);

			// get the details of third record from the list
			fetch8 = file.getCellData("Utility Invoices", "Control Number", 4);
			fetch9 = file.getCellData("Utility Invoices", "Invoice Number", 4);
			fetch10 = file.getCellData("Utility Invoices", "Meter Number", 4);
			fetch11 = file.getCellData("Utility Invoices", "Total Consumption", 4);
			fetch12 = file.getCellData("Utility Invoices", "Total Cost", 4);
			fetch13 = file.getCellData("Utility Invoices", "Tenant Consumption", 4);
			fetch14 = file.getCellData("Utility Invoices", "Is Estimate", 4);

			// wait for the element
			Thread.sleep(5000);

			System.out.println("fetch1:::::::::::::::" + fetch1);
			System.out.println("fetch2:::::::::::::::" + fetch2);
			System.out.println("fetch3:::::::::::::::" + fetch3);
			System.out.println("fetch4:::::::::::::::" + fetch4);
			System.out.println("fetch5:::::::::::::::" + fetch5);
			System.out.println("fetch6:::::::::::::::" + fetch6);
			System.out.println("fetch7:::::::::::::::" + fetch7);
			System.out.println("fetch8:::::::::::::::" + fetch8);
			System.out.println("fetch9:::::::::::::::" + fetch9);
			System.out.println("fetch10:::::::::::::::" + fetch10);
			System.out.println("fetch11:::::::::::::::" + fetch11);
			System.out.println("fetch12:::::::::::::::" + fetch12);
			System.out.println("fetch13:::::::::::::::" + fetch13);
			System.out.println("fetch14:::::::::::::::" + fetch14);

			// wait for the element
			Thread.sleep(5000);

			// click on the action icon
			click("sustainability_utilitybills_actionicon_XPATH");
			ngDriver.waitForAngularRequestsToFinish();
			System.out.println("Clicked on the action icon.");

			// click on the import consumption option
			click("sustainability_utilitybills_import_XPATH");
			ngDriver.waitForAngularRequestsToFinish();
			System.out.println("Clicked on the import consumption option.");

			// wait for the element
			Thread.sleep(5000);

			// import the file
			uploadFile(path_string);

			// wait for the element
			Thread.sleep(5000);

			try {
				// enter the updated meter number 1 in search field
				clear("sustainability_searchtxt_XPATH");
				type("sustainability_searchtxt_XPATH", fetch3);
				ngDriver.waitForAngularRequestsToFinish();
				System.out.println("Entered the updated meter number 1 in search field.");

				// verify imported record of the meter number 1 is displayed with updated
				// details
				try {
					String validation1 = "//td[contains(text(),'" + updateUtilityMeter1 + "')]";
					String validation1_actual = (driver.findElement(By.xpath(validation1)).getText()).trim();

					if (validation1_actual.equals(updateUtilityMeter1)) {
						successMessage("The meter number 1 is updated successfully.");
					} else {
						verificationFailedMessage("The meter number 1 is not updated.");
					}
				} catch (Throwable t) {
					verificationFailedMessage("The meter number 1 is not updated.");
				}

				// verify imported record of the Consumption 1 is displayed with updated details
				try {
					String validation2 = "//td[contains(text(),'" + updateUtilityMeter1
							+ "')]//following-sibling::td[contains(text(),'" + updateConsumption1 + "')]";

					String validation2_actual = (driver.findElement(By.xpath(validation2)).getText()).trim();

					if (validation2_actual.equals(updateConsumption1)) {
						successMessage("The Consumption 1 is updated successfully.");
					} else {
						verificationFailedMessage("The Consumption 1 is not updated.");
					}
				} catch (Throwable t) {
					verificationFailedMessage("The Consumption 1 is not updated.");
				}

				// verify imported record of the total cost 1 is displayed with updated details
				try {
					String validation3 = "//td[contains(text(),'" + updateUtilityMeter1
							+ "')]//following-sibling::td[contains(text(),'" + updateTotalCost1 + "')]";

					String validation3_actual = (driver.findElement(By.xpath(validation3)).getText()).trim();

					if (validation3_actual.equals(updateTotalCost1)) {
						successMessage("The total cost 1 is updated successfully.");
					} else {
						verificationFailedMessage("The total cost 1 is not updated.");
					}
				} catch (Throwable t) {
					verificationFailedMessage("The total cost 1 is not updated.");
				}
			} catch (Throwable t) {
				verificationFailedMessage("The correct updated record is not found after import the file.");
			}

			try {
				// enter the updated meter number 2 in search field
				clear("sustainability_searchtxt_XPATH");
				type("sustainability_searchtxt_XPATH", fetch10);
				ngDriver.waitForAngularRequestsToFinish();
				System.out.println("Entered the updated meter number 2 in search field.");

				// verify imported record of the meter number 2 is displayed with updated
				// details
				try {
					String validation4 = "//td[contains(text(),'" + updateUtilityMeter2 + "')]";
					String validation4_actual = (driver.findElement(By.xpath(validation4)).getText()).trim();

					if (validation4_actual.equals(updateUtilityMeter2)) {
						successMessage("The meter number 2 is updated successfully.");
					} else {
						verificationFailedMessage("The meter number 2 is not updated.");
					}
				} catch (Throwable t) {
					verificationFailedMessage("The meter number 2 is not updated.");
				}

				// verify imported record of the Consumption 2 is displayed with updated details
				try {
					String validation5 = "//td[contains(text(),'" + updateUtilityMeter2
							+ "')]//following-sibling::td[contains(text(),'" + updateConsumption2 + "')]";

					String validation5_actual = (driver.findElement(By.xpath(validation5)).getText()).trim();

					if (validation5_actual.equals(updateConsumption2)) {
						successMessage("The Consumption 2 is updated successfully.");
					} else {
						verificationFailedMessage("The Consumption 2 is not updated.");
					}
				} catch (Throwable t) {
					verificationFailedMessage("The Consumption 2 is not updated.");
				}

				// verify imported record of the total cost 2 is displayed with updated details
				try {
					String validation6 = "//td[contains(text(),'" + updateUtilityMeter2
							+ "')]//following-sibling::td[contains(text(),'" + updateTotalCost2 + "')]";

					String validation6_actual = (driver.findElement(By.xpath(validation6)).getText()).trim();

					if (validation6_actual.equals(updateTotalCost2)) {
						successMessage("The total cost 2 is updated successfully.");
					} else {
						verificationFailedMessage("The total cost 2 is not updated.");
					}
				} catch (Throwable t) {
					verificationFailedMessage("The total cost 2 is not updated.");
				}
			} catch (Throwable t) {
				verificationFailedMessage("The correct updated record is not found after import the file.");
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

		// DELETE ALL THE NEWLY CREATED UTILITY BILLS RECORD

		System.out.println("***************** DELETE ALL THE NEWLY CREATED UTILITY BILLS RECORD *****************");
		test.log(LogStatus.INFO,
				"***************** DELETE ALL THE NEWLY CREATED UTILITY BILLS RECORD *****************");
		Reporter.log("***************** DELETE ALL THE NEWLY CREATED UTILITY BILLS RECORD *****************");
		log.info("***************** DELETE ALL THE NEWLY CREATED UTILITY BILLS RECORD *****************");

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

	}
}
