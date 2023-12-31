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
		title("VERIFY THE EXTRACT AND IMPORT FEATURE OF THE UTILITY BILLS MODULE");

		// refresh the page
		driver.navigate().refresh();
		explicitWait("sustainabilityicon_CSS");
		driver.navigate().refresh();

		// DELETE ALL THE PREVIOUSLY CREATED UTILITY BILLS RECORD
		title("DELETE ALL THE PREVIOUSLY CREATED UTILITY BILLS RECORD");

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

			// select the all option from the meter filter
			select("sustainability_utilitybills_meterfilter_XPATH", "All");

			// ========= TEMPORARY CODE - ABOVE =========

			// click on the refresh button
			click("sustainability_utilitybills_refreshbtn_XPATH");

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

						// click on the first record of the utility bill
						click("sustainability_utilitybills_firstrecord_XPATH");

						// wait for the element
						explicitWaitClickable("sustainability_utilitybills_deletebtn_XPATH");

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

		// CREATE RANDOM NUMBER OF NEW UTILITY BILLS RECORD - AT PROPERTY LEVEL
		title("CREATE RANDOM NUMBER OF NEW UTILITY BILLS RECORD - AT PROPERTY LEVEL");

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

			for (int i = 0; i < billCount; i++) {

				// click on the add button
				click("sustainability_utilitybills_addbtn_XPATH");

				// click on the yes button of the tenant paid field
				click("sustainability_utilitybills_tenantpaidyes_XPATH");

				// click on the yes button of the Estimated field
				click("sustainability_utilitybills_estimatedyes_XPATH");

				// enter the details in the Period From field
				LocalDate addDate1 = LocalDate.now().minusMonths(1);
				String addDate1_String = addDate1.toString();
				type("sustainability_utilitybills_periodfrom_XPATH", addDate1_String);

				// enter the details in the Period To field
				LocalDate addDate2 = LocalDate.now().plusMonths(1);
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
				String random2 = RandomStringUtils.randomNumeric(6);
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
				String random3 = RandomStringUtils.randomNumeric(6);
				type("sustainability_utilitybills_totalcost_XPATH", random3);

				// enter details in the Reference Number field
				String random4 = RandomStringUtils.randomNumeric(8);
				type("sustainability_utilitybills_referencenumber_XPATH", random4);

				// enter details in the Control Number field
				String random5 = RandomStringUtils.randomNumeric(8);
				type("sustainability_utilitybills_controlnumber_XPATH", random5);

				// enter details in the Multiplier field
				String random6 = RandomStringUtils.randomNumeric(2);
				type("sustainability_utilitybills_multiplier_XPATH", random6);

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

		// EXTRACT AND IMPORT THE NEWLY CREATED UTILITY BILLS
		title("EXTRACT AND IMPORT THE NEWLY CREATED UTILITY BILLS");

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

			// select the all option from the meter filter
			select("sustainability_utilitybills_meterfilter_XPATH", "All");

			// ========= TEMPORARY CODE - ABOVE =========

			// click on the refresh button
			click("sustainability_utilitybills_refreshbtn_XPATH");

			// wait for the element
			Thread.sleep(5000);

			// click on the action icon
			click("sustainability_utilitybills_actionicon_XPATH");

			// click on the extraction consumption option
			click("sustainability_utilitybills_extractconsumption_XPATH");

			// wait for the element
			Thread.sleep(5000);

			// click on the extraction button
			click("sustainability_utilitybills_extractbtn_XPATH");

			// wait for the element
			Thread.sleep(5000);

			// fetch the record from the download file
			File downloaded = getLastModified(config.getProperty("downloadFilePath"));
			String path_string = downloaded.toString();
			consoleMessage(path_string);

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

			consoleMessage("fetch1:::::::::::::::" + fetch1);
			consoleMessage("fetch2:::::::::::::::" + fetch2);
			consoleMessage("fetch3:::::::::::::::" + fetch3);
			consoleMessage("fetch4:::::::::::::::" + fetch4);
			consoleMessage("fetch5:::::::::::::::" + fetch5);
			consoleMessage("fetch6:::::::::::::::" + fetch6);
			consoleMessage("fetch7:::::::::::::::" + fetch7);
			consoleMessage("fetch8:::::::::::::::" + fetch8);
			consoleMessage("fetch9:::::::::::::::" + fetch9);
			consoleMessage("fetch10:::::::::::::::" + fetch10);
			consoleMessage("fetch11:::::::::::::::" + fetch11);
			consoleMessage("fetch12:::::::::::::::" + fetch12);
			consoleMessage("fetch13:::::::::::::::" + fetch13);
			consoleMessage("fetch14:::::::::::::::" + fetch14);

			// wait for the element
			Thread.sleep(5000);

			// click on the action icon
			click("sustainability_utilitybills_actionicon_XPATH");

			// click on the import consumption option
			click("sustainability_utilitybills_import_XPATH");

			// wait for the element
			Thread.sleep(5000);

			// import the file
			uploadFile(path_string);

			// wait for the element
			Thread.sleep(5000);

			try {
				// enter the updated meter number 1 in search field

				type("sustainability_searchtxt_XPATH", fetch3);

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
				type("sustainability_searchtxt_XPATH", fetch10);

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

		// synchronization
		explicitWait("propertylist_title_XPATH");

		// verify the property list
		switchVerification("propertylist_title_XPATH", "Property List", "The property list is not displayed.");

		// DELETE ALL THE NEWLY CREATED UTILITY BILLS RECORD
		title("DELETE ALL THE NEWLY CREATED UTILITY BILLS RECORD");

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

			// select the all option from the meter filter
			select("sustainability_utilitybills_meterfilter_XPATH", "All");

			// ========= TEMPORARY CODE - ABOVE =========

			// click on the refresh button
			click("sustainability_utilitybills_refreshbtn_XPATH");

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

						// click on the first record of the utility bill
						click("sustainability_utilitybills_firstrecord_XPATH");

						// wait for the element
						explicitWaitClickable("sustainability_utilitybills_deletebtn_XPATH");

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