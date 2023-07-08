package testcases.E2Etestcasesuite.sustainabilitymodule;

import java.io.IOException;
import java.time.LocalDate;
import java.util.Hashtable;
import java.util.List;

import org.apache.commons.lang3.RandomStringUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Reporter;
import org.testng.SkipException;
import org.testng.annotations.Test;

import com.relevantcodes.extentreports.LogStatus;

import base.Helper;
import base.TestBase;
import utilities.TestUtil;

public class RR5964Sustainability6Test extends TestBase {

	@Test(dataProviderClass = TestUtil.class, dataProvider = "dp")
	public void rR5964Sustainability6Test(Hashtable<String, String> data) throws IOException, InterruptedException {

		execution(data, "rR5964Sustainability6Test");

		// VALIDATE AN ERROR OF THE RECORDS OF THE UTILITY BILLS MODULE
		title("VALIDATE AN ERROR OF THE RECORDS OF THE UTILITY BILLS MODULE");

		Helper helper = new Helper();

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

			try {
				// select the all option from the meter filter
				select("sustainability_utilitybills_meterfilter_XPATH", "All");

			} catch (Throwable t) {
				successMessage("This time meter filter not showing the options");
			}

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

		// CREATE NEW UTILITY BILLS RECORD - WITH PERIOD START AND END WITH TODAY'S DATE
		title("CREATE NEW UTILITY BILLS RECORD - WITH PERIOD START AND END WITH TODAY'S DATE");

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
			LocalDate addDate1 = LocalDate.now();
			String addDate1_String = addDate1.toString();
			type("sustainability_utilitybills_periodfrom_XPATH", addDate1_String);

			// enter the details in the Period To field
			LocalDate addDate2 = LocalDate.now();
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

			// wait for the element
			Thread.sleep(5000);

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
					successMessage("The utility bills is verified successfully.");
				} else {
					verificationFailedMessage("The utility bills is not verified.");
				}
			} catch (Throwable t) {
				verificationFailed();
			}

			// verify the error icon and error of the newly created bill
			try {

				boolean errorIcon = driver
						.findElement(By.xpath(OR.getProperty("sustainability_utilitybills_erroricon_XPATH")))
						.isDisplayed();
				if (errorIcon == true) {

					successMessage("An error icon is displayed successfully.");

					// click on the error icon
					click("sustainability_utilitybills_erroricon_XPATH");

					// wait for the element
					Thread.sleep(5000);

					// validate the first error message
					switchVerification("sustainability_utilitybills_error_gap1_XPATH", "Gap in billing periods",
							"The Gap in billing periods error message is not displayed.");

					// validate the second error message
					switchVerification("sustainability_utilitybills_error_gap2_XPATH", "Gap in billing periods",
							"The Gap in billing periods error message is not displayed.");

					// click on the confirm button
					click("sustainability_utilitybills_error_confirmbtn_XPATH");

					// wait for the element
					Thread.sleep(5000);

				} else {
					verificationFailedMessage("An error icon is not displayed.");
				}
			} catch (Throwable t) {
				verificationFailedMessage("An error icon is not displayed.");
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

		// UPDATE NEWLY CREATED UTILITY BILLS RECORD - WITH PERIOD START AS A FIRST DAY
		// OF THE YEAR AND END AS A TODAY'S DATE
		title("UPDATE NEWLY CREATED UTILITY BILLS RECORD - WITH PERIOD START AS A FIRST DAY OF THE YEAR AND END AS A TODAY'S DATE");

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

			// enter the meter number of bill in the search field
			type("sustainability_searchtxt_XPATH", utilityBills);

			// click on the searched bill
			click("sustainability_utilitybills_firstrecord_XPATH");

			// enter the details in the Period From field
			LocalDate addDate2 = LocalDate.now();
			String addDate2_String = addDate2.toString();
			String[] arrayOfDate = addDate2_String.split("-");
			String year2 = arrayOfDate[0];
			type("sustainability_utilitybills_periodfrom_XPATH", year2 + "-01-01");

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
					successMessage("The utility bills is verified successfully.");
				} else {
					verificationFailedMessage("The utility bills is not verified.");
				}
			} catch (Throwable t) {
				verificationFailed();
			}

			// verify the error icon and error of the newly created bill
			try {

				boolean errorIcon = driver
						.findElement(By.xpath(OR.getProperty("sustainability_utilitybills_erroricon_XPATH")))
						.isDisplayed();
				if (errorIcon == true) {

					successMessage("An error icon is displayed successfully.");

					// click on the error icon
					click("sustainability_utilitybills_erroricon_XPATH");

					// wait for the element
					Thread.sleep(5000);

					// validate the first error message
					switchVerification("sustainability_utilitybills_error_gap1_XPATH", "Gap in billing periods",
							"The Gap in billing periods error message is not displayed.");

					// validate the second error message
					helper.deleteVerification("sustainability_utilitybills_error_gap2_XPATH", "Gap in billing periods");

					// click on the confirm button
					click("sustainability_utilitybills_error_confirmbtn_XPATH");

					// wait for the element
					Thread.sleep(5000);

				} else {
					verificationFailedMessage("An error icon is not displayed.");
				}
			} catch (Throwable t) {
				verificationFailedMessage("An error icon is not displayed.");
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

		// UPDATE NEWLY CREATED UTILITY BILLS RECORD - WITH PERIOD START AS A FIRST DAY
		// OF THE YEAR AND END AS A LAST DAY OF THE YEAR
		title("UPDATE NEWLY CREATED UTILITY BILLS RECORD - WITH PERIOD START AS A FIRST DAY OF THE YEAR AND END AS A LAST DAY OF THE YEAR");

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

			// enter the meter number of bill in the search field
			type("sustainability_searchtxt_XPATH", utilityBills);

			// click on the searched bill
			click("sustainability_utilitybills_firstrecord_XPATH");

			// enter the details in the Period From field
			LocalDate addDate3 = LocalDate.now();
			String addDate3_String = addDate3.toString();
			String[] arrayOfDate3 = addDate3_String.split("-");
			String year3 = arrayOfDate3[0];
			type("sustainability_utilitybills_periodfrom_XPATH", year3 + "-01-01");

			// enter the details in the Period To field
			LocalDate addDate4 = LocalDate.now();
			String addDate4_String = addDate4.toString();
			String[] arrayOfDate4 = addDate4_String.split("-");
			String year4 = arrayOfDate4[0];
			type("sustainability_utilitybills_periodto_XPATH", year4 + "-12-31");

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
					successMessage("The utility bills is verified successfully.");
				} else {
					verificationFailedMessage("The utility bills is not verified.");
				}
			} catch (Throwable t) {
				verificationFailed();
			}

			// verify the error icon and error of the newly created bill
			try {

				boolean errorIcon = driver
						.findElement(By.xpath(OR.getProperty("sustainability_utilitybills_erroricon_XPATH")))
						.isDisplayed();
				if (errorIcon == true) {

					successMessage("An error icon is displayed successfully.");

					// click on the error icon
					click("sustainability_utilitybills_erroricon_XPATH");

					// wait for the element
					Thread.sleep(5000);

					// validate the first error message
					helper.deleteVerification("sustainability_utilitybills_error_gap1_XPATH", "Gap in billing periods");

					// validate the second error message
					helper.deleteVerification("sustainability_utilitybills_error_gap2_XPATH", "Gap in billing periods");

					// validate the third error message
					switchVerification("sustainability_utilitybills_error_futuredate_XPATH",
							"Billing period start or end date is in the future",
							"The Billing period start or end date is in the future is not displayed.");

					// click on the confirm button
					click("sustainability_utilitybills_error_confirmbtn_XPATH");

					// wait for the element
					Thread.sleep(5000);
				} else {
					verificationFailedMessage("An error icon is not displayed.");
				}
			} catch (Throwable t) {
				verificationFailedMessage("An error icon is not displayed.");
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

		// UPDATE NEWLY CREATED UTILITY BILLS RECORD - WITH PERIOD START AS A FIRST DAY
		// OF THE YEAR AND END AS A FUTURE DATE AND SAME YEAR
		title("UPDATE NEWLY CREATED UTILITY BILLS RECORD - WITH PERIOD START AS A FIRST DAY OF THE YEAR AND END AS A FUTURE DATE AND SAME YEAR");

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

			// enter the meter number of bill in the search field
			type("sustainability_searchtxt_XPATH", utilityBills);

			// click on the searched bill
			click("sustainability_utilitybills_firstrecord_XPATH");

			// enter the details in the Period From field
			LocalDate addDate3 = LocalDate.now();
			String addDate3_String = addDate3.toString();
			String[] arrayOfDate3 = addDate3_String.split("-");
			String year3 = arrayOfDate3[0];
			type("sustainability_utilitybills_periodfrom_XPATH", year3 + "-01-01");

			// enter the details in the Period To field
			LocalDate addDate5 = LocalDate.now().plusDays(2);
			String addDate5_String = addDate5.toString();
			type("sustainability_utilitybills_periodto_XPATH", addDate5_String);

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
					successMessage("The utility bills is verified successfully.");
				} else {
					verificationFailedMessage("The utility bills is not verified.");
				}
			} catch (Throwable t) {
				verificationFailed();
			}

			// verify the error icon and error of the newly created bill
			try {

				boolean errorIcon = driver
						.findElement(By.xpath(OR.getProperty("sustainability_utilitybills_erroricon_XPATH")))
						.isDisplayed();
				if (errorIcon == true) {

					successMessage("An error icon is displayed successfully.");

					// click on the error icon
					click("sustainability_utilitybills_erroricon_XPATH");

					// wait for the element
					Thread.sleep(5000);

//					// validate the first error message
//					switchVerification("sustainability_utilitybills_error_gap1_XPATH", "Gap in billing periods",
//							"The Gap in billing periods is not displayed.");

					// validate the second error message
					helper.deleteVerification("sustainability_utilitybills_error_gap2_XPATH", "Gap in billing periods");

					// validate the third error message
					switchVerification("sustainability_utilitybills_error_futuredate_XPATH",
							"Billing period start or end date is in the future",
							"The Billing period start or end date is in the future is not displayed.");

					// click on the confirm button
					click("sustainability_utilitybills_error_confirmbtn_XPATH");

					// wait for the element
					Thread.sleep(5000);

				} else {
					verificationFailedMessage("An error icon is not displayed.");
				}
			} catch (Throwable t) {
				verificationFailedMessage("An error icon is not displayed.");
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

		// UPDATE NEWLY CREATED UTILITY BILLS RECORD - WITH PERIOD START DATE AS A
		// GREATED THAN THE END DATE
		title("UPDATE NEWLY CREATED UTILITY BILLS RECORD - WITH PERIOD START DATE AS A GREATED THAN THE END DATE");

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

			// enter the meter number of bill in the search field
			type("sustainability_searchtxt_XPATH", utilityBills);

			// click on the searched bill
			click("sustainability_utilitybills_firstrecord_XPATH");

			// enter the details in the Period From field
			LocalDate addDate6 = LocalDate.now();
			String addDate6_String = addDate6.toString();
			type("sustainability_utilitybills_periodfrom_XPATH", addDate6_String);

			// enter the details in the Period To field
			LocalDate addDate7 = LocalDate.now().minusDays(2);
			String addDate7_String = addDate7.toString();
			type("sustainability_utilitybills_periodto_XPATH", addDate7_String);

			// click on the save button
			click("sustainability_utilitybills_saverecordbtn_XPATH");

			// wait for the element
			explicitWaitClickable("closetoastmsg_CSS");

			// click on the toaster close button
			click("closetoastmsg_CSS");

			// wait for the element
			Thread.sleep(5000);

			// validate refresh button is displayed or not
			try {

				boolean refreshbtn = driver
						.findElement(By.xpath(OR.getProperty("sustainability_utilitybills_refreshbtn_XPATH")))
						.isDisplayed();

				if (refreshbtn == true) {
					verificationFailedMessage("The application is allowed to save an invalid dates.");
				} else {
					successMessage("The application not allow to save an invalid dates.");

					// click on the cancel button
					click("sustainability_utilitybills_cancelbtn_XPATH");

					// wait for the element
					Thread.sleep(5000);
				}

			} catch (Throwable t) {
				successMessage("The application not allow to save an invalid dates.");

				// click on the cancel button
				click("sustainability_utilitybills_cancelbtn_XPATH");

				// wait for the element
				Thread.sleep(5000);
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

		// UPDATE NEWLY CREATED UTILITY BILLS RECORD - WITH PERIOD START AS A TODAY AND
		// END AS A FUTURE DATE AND SAME YEAR
		title("UPDATE NEWLY CREATED UTILITY BILLS RECORD - WITH PERIOD START AS A TODAY AND END AS A FUTURE DATE AND SAME YEAR");

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

			// enter the meter number of bill in the search field
			type("sustainability_searchtxt_XPATH", utilityBills);

			// click on the searched bill
			click("sustainability_utilitybills_firstrecord_XPATH");

			// enter the details in the Period From field
			LocalDate addDate8 = LocalDate.now();
			String addDate8_String = addDate8.toString();
			type("sustainability_utilitybills_periodfrom_XPATH", addDate8_String);

			// enter the details in the Period To field
			LocalDate addDate9 = LocalDate.now().plusDays(4);
			String addDate9_String = addDate9.toString();
			type("sustainability_utilitybills_periodto_XPATH", addDate9_String);

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
					successMessage("The utility bills is verified successfully.");
				} else {
					verificationFailedMessage("The utility bills is not verified.");
				}
			} catch (Throwable t) {
				verificationFailed();
			}

			// verify the error icon and error of the newly created bill
			try {

				boolean errorIcon = driver
						.findElement(By.xpath(OR.getProperty("sustainability_utilitybills_erroricon_XPATH")))
						.isDisplayed();
				if (errorIcon == true) {

					successMessage("An error icon is displayed successfully.");

					// click on the error icon
					click("sustainability_utilitybills_erroricon_XPATH");

					// wait for the element
					Thread.sleep(5000);

					// validate the first error message
					switchVerification("sustainability_utilitybills_error_gap1_XPATH", "Gap in billing periods",
							"The Gap in billing periods is not displayed.");

					// validate the second error message
					switchVerification("sustainability_utilitybills_error_gap2_XPATH", "Gap in billing periods",
							"The Gap in billing periods is not displayed.");

					// validate the third error message
					switchVerification("sustainability_utilitybills_error_futuredate_XPATH",
							"Billing period start or end date is in the future",
							"The Billing period start or end date is in the future is not displayed.");

					// click on the confirm button
					click("sustainability_utilitybills_error_confirmbtn_XPATH");

					// wait for the element
					Thread.sleep(5000);

				} else {

					verificationFailedMessage("An error icon is not displayed.");

				}

			} catch (Throwable t) {

				verificationFailedMessage("An error icon is not displayed.");
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

		// CREATE NEW UTILITY BILLS RECORD - WITH SAME METER NUMBER AND OVERLAP THE
		// DATES
		title("CREATE NEW UTILITY BILLS RECORD - WITH SAME METER NUMBER AND OVERLAP THE DATES - UPDATE PERIOD FROM DATE");

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
			LocalDate addDate9 = LocalDate.now().plusDays(2);
			String addDate9_String = addDate9.toString();
			type("sustainability_utilitybills_periodfrom_XPATH", addDate9_String);

			// enter the details in the Period To field
			LocalDate addDate10 = LocalDate.now().plusDays(4);
			String addDate10_String = addDate10.toString();
			type("sustainability_utilitybills_periodto_XPATH", addDate10_String);

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

			// wait for the element
			Thread.sleep(5000);

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
					successMessage("The utility bills is verified successfully.");
				} else {
					verificationFailedMessage("The utility bills is not verified.");
				}
			} catch (Throwable t) {
				verificationFailed();
			}

			// verify the error icon and error of the newly created bill
			try {

				boolean errorIcon = driver
						.findElement(By.xpath(OR.getProperty("sustainability_utilitybills_erroricon_XPATH")))
						.isDisplayed();
				if (errorIcon == true) {

					successMessage("An error icon is displayed successfully.");

					// click on the error icon
					LocalDate addDate11 = LocalDate.now().plusDays(2);
					String addDate11_String = addDate11.toString();
					String error22 = "//td[text()='" + addDate11_String
							+ "']//following-sibling::td//a[@ng-click='setSelectedErrorRecord(d)']";
					driver.findElement(By.xpath(error22)).click();

					// wait for the element
					Thread.sleep(5000);

					// validate the first error message
					switchVerification("sustainability_utilitybills_error_gap1_XPATH", "Gap in billing periods",
							"The Gap in billing periods is not displayed.");

					// validate the second error message
					helper.deleteVerification("sustainability_utilitybills_error_gap2_XPATH", "Gap in billing periods");

					// validate the third error message
					switchVerification("sustainability_utilitybills_error_futuredate_XPATH",
							"Billing period start or end date is in the future",
							"The Billing period start or end date is in the future is not displayed.");

					// validate the firth error message
					switchVerification("sustainability_utilitybills_error_overlap_XPATH", "Overlapping billing periods",
							"The Overlapping billing periods is not displayed.");

					// click on the confirm button
					click("sustainability_utilitybills_error_confirmbtn_XPATH");

					// wait for the element
					Thread.sleep(5000);

				} else {

					verificationFailedMessage("An error icon is not displayed.");

				}

			} catch (Throwable t) {

				verificationFailedMessage("An error icon is not displayed.");
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

		// CREATE NEW UTILITY BILLS RECORD - WITH SAME METER NUMBER AND OVERLAP THE
		// DATES - UPDATE PERIOD TO DATE
		title("CREATE NEW UTILITY BILLS RECORD - WITH SAME METER NUMBER AND OVERLAP THE DATES - UPDATE PERIOD TO DATE");

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
			LocalDate addDate12 = LocalDate.now();
			String addDate12_String = addDate12.toString();
			type("sustainability_utilitybills_periodfrom_XPATH", addDate12_String);

			// enter the details in the Period To field
			LocalDate addDate13 = LocalDate.now().plusDays(3);
			String addDate13_String = addDate13.toString();
			type("sustainability_utilitybills_periodto_XPATH", addDate13_String);

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

			// wait for the element
			Thread.sleep(5000);

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
					successMessage("The utility bills is verified successfully.");
				} else {
					verificationFailedMessage("The utility bills is not verified.");
				}
			} catch (Throwable t) {
				verificationFailed();
			}

			// verify the error icon and error of the newly created bill
			try {

				boolean errorIcon = driver
						.findElement(By.xpath(OR.getProperty("sustainability_utilitybills_erroricon_XPATH")))
						.isDisplayed();
				if (errorIcon == true) {

					successMessage("An error icon is displayed successfully.");

					// click on the error icon
					LocalDate addDate11 = LocalDate.now().plusDays(3);
					String addDate11_String = addDate11.toString();
					String error22 = "//td[text()='" + addDate11_String
							+ "']//following-sibling::td//a[@ng-click='setSelectedErrorRecord(d)']";
					driver.findElement(By.xpath(error22)).click();

					// wait for the element
					Thread.sleep(5000);

					// validate the first error message
					switchVerification("sustainability_utilitybills_error_gap1_XPATH", "Gap in billing periods",
							"The Gap in billing periods is not displayed.");

					// validate the second error message
					helper.deleteVerification("sustainability_utilitybills_error_gap2_XPATH", "Gap in billing periods");

					// validate the third error message
					switchVerification("sustainability_utilitybills_error_futuredate_XPATH",
							"Billing period start or end date is in the future",
							"The Billing period start or end date is in the future is not displayed.");

					// validate the firth error message
					switchVerification("sustainability_utilitybills_error_overlap_XPATH", "Overlapping billing periods",
							"The Overlapping billing periods is not displayed.");

					// click on the confirm button
					click("sustainability_utilitybills_error_confirmbtn_XPATH");

					// wait for the element
					Thread.sleep(5000);

				} else {

					verificationFailedMessage("An error icon is not displayed.");

				}

			} catch (Throwable t) {

				verificationFailedMessage("An error icon is not displayed.");
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