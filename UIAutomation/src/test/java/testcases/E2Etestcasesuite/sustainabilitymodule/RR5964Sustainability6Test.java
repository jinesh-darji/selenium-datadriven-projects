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

		System.out.println("VALIDATE AN ERROR OF THE RECORDS OF THE UTILITY BILLS MODULE");
		test.log(LogStatus.INFO, "VALIDATE AN ERROR OF THE RECORDS OF THE UTILITY BILLS MODULE");
		Reporter.log("VALIDATE AN ERROR OF THE RECORDS OF THE UTILITY BILLS MODULE");
		log.info("VALIDATE AN ERROR OF THE RECORDS OF THE UTILITY BILLS MODULE");

		Helper helper = new Helper();
		
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

			try {
				// select the all option from the meter filter
				select("sustainability_utilitybills_meterfilter_XPATH", "All");
				ngDriver.waitForAngularRequestsToFinish();
				System.out.println("Selected the all option from the meter filter.");

			} catch (Throwable t) {
				successMessage("This time meter filter not showing the options");
			}

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

		// CREATE NEW UTILITY BILLS RECORD - WITH PERIOD START AND END WITH TODAY'S DATE

		System.out.println(
				"***************** CREATE NEW UTILITY BILLS RECORD - WITH PERIOD START AND END WITH TODAY'S DATE *****************");
		test.log(LogStatus.INFO,
				"***************** CREATE NEW UTILITY BILLS RECORD - WITH PERIOD START AND END WITH TODAY'S DATE *****************");
		Reporter.log(
				"***************** CREATE NEW UTILITY BILLS RECORD - WITH PERIOD START AND END WITH TODAY'S DATE *****************");
		log.info(
				"***************** CREATE NEW UTILITY BILLS RECORD - WITH PERIOD START AND END WITH TODAY'S DATE *****************");

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
			LocalDate addDate1 = LocalDate.now();
			String addDate1_String = addDate1.toString();
			clear("sustainability_utilitybills_periodfrom_XPATH");
			type("sustainability_utilitybills_periodfrom_XPATH", addDate1_String);
			ngDriver.waitForAngularRequestsToFinish();
			System.out.println("Entered the details in the Period From field.");

			// enter the details in the Period To field
			LocalDate addDate2 = LocalDate.now();
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

			// wait for the element
			Thread.sleep(5000);

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

			// verify the error icon and error of the newly created bill
			try {

				boolean errorIcon = driver
						.findElement(By.xpath(OR.getProperty("sustainability_utilitybills_erroricon_XPATH")))
						.isDisplayed();
				if (errorIcon == true) {

					successMessage("An error icon is displayed successfully.");

					// click on the error icon
					click("sustainability_utilitybills_erroricon_XPATH");
					ngDriver.waitForAngularRequestsToFinish();
					System.out.println("Clicked on the error icon.");

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
					ngDriver.waitForAngularRequestsToFinish();
					System.out.println("Clicked on the conform button.");

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
		System.out.println("Clicked on the home icon from the top of the screen.");
		ngDriver.waitForAngularRequestsToFinish();

		// synchronization
		explicitWait("propertylist_title_XPATH");

		// verify the property list
		switchVerification("propertylist_title_XPATH", "Property List", "The property list is not displayed.");

		// UPDATE NEWLY CREATED UTILITY BILLS RECORD - WITH PERIOD START AS A FIRST DAY
		// OF THE YEAR AND END AS A TODAY'S DATE

		System.out.println(
				"***************** UPDATE NEWLY CREATED UTILITY BILLS RECORD - WITH PERIOD START AS A FIRST DAY OF THE YEAR AND END AS A TODAY'S DATE *****************");
		test.log(LogStatus.INFO,
				"***************** UPDATE NEWLY CREATED UTILITY BILLS RECORD - WITH PERIOD START AS A FIRST DAY OF THE YEAR AND END AS A TODAY'S DATE *****************");
		Reporter.log(
				"***************** UPDATE NEWLY CREATED UTILITY BILLS RECORD - WITH PERIOD START AS A FIRST DAY OF THE YEAR AND END AS A TODAY'S DATE *****************");
		log.info(
				"***************** UPDATE NEWLY CREATED UTILITY BILLS RECORD - WITH PERIOD START AS A FIRST DAY OF THE YEAR AND END AS A TODAY'S DATE *****************");

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

			// enter the meter number of bill in the search field
			type("sustainability_searchtxt_XPATH", utilityBills);
			ngDriver.waitForAngularRequestsToFinish();
			System.out.println("Entered the meter number of bill in the search field.");

			// click on the searched bill
			click("sustainability_utilitybills_firstrecord_XPATH");
			ngDriver.waitForAngularRequestsToFinish();
			System.out.println("Clicked on the searched bill.");

			// enter the details in the Period From field
			LocalDate addDate2 = LocalDate.now();
			String addDate2_String = addDate2.toString();
			String[] arrayOfDate = addDate2_String.split("-");
			String year2 = arrayOfDate[0];

			clear("sustainability_utilitybills_periodfrom_XPATH");
			type("sustainability_utilitybills_periodfrom_XPATH", year2 + "-01-01");
			ngDriver.waitForAngularRequestsToFinish();
			System.out.println("Entered the details in the Period From field.");

//			// enter the details in the Period To field
//			LocalDate addDate2 = LocalDate.now();
//			String addDate2_String = addDate2.toString();
//			clear("sustainability_utilitybills_periodto_XPATH");
//			type("sustainability_utilitybills_periodto_XPATH", addDate2_String);
//			ngDriver.waitForAngularRequestsToFinish();
//			System.out.println("Entered the details in the Period To field.");

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

			// verify the error icon and error of the newly created bill
			try {

				boolean errorIcon = driver
						.findElement(By.xpath(OR.getProperty("sustainability_utilitybills_erroricon_XPATH")))
						.isDisplayed();
				if (errorIcon == true) {

					successMessage("An error icon is displayed successfully.");

					// click on the error icon
					click("sustainability_utilitybills_erroricon_XPATH");
					ngDriver.waitForAngularRequestsToFinish();
					System.out.println("Clicked on the error icon.");

					// wait for the element
					Thread.sleep(5000);

					// validate the first error message
					switchVerification("sustainability_utilitybills_error_gap1_XPATH", "Gap in billing periods",
							"The Gap in billing periods error message is not displayed.");

					// validate the second error message
					helper.deleteVerification("sustainability_utilitybills_error_gap2_XPATH", "Gap in billing periods");

					// click on the confirm button
					click("sustainability_utilitybills_error_confirmbtn_XPATH");
					ngDriver.waitForAngularRequestsToFinish();
					System.out.println("Clicked on the conform button.");

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
		System.out.println("Clicked on the home icon from the top of the screen.");
		ngDriver.waitForAngularRequestsToFinish();

		// synchronization
		explicitWait("propertylist_title_XPATH");

		// verify the property list
		switchVerification("propertylist_title_XPATH", "Property List", "The property list is not displayed.");

		// UPDATE NEWLY CREATED UTILITY BILLS RECORD - WITH PERIOD START AS A FIRST DAY
		// OF THE YEAR AND END AS A LAST DAY OF THE YEAR

		System.out.println(
				"***************** UPDATE NEWLY CREATED UTILITY BILLS RECORD - WITH PERIOD START AS A FIRST DAY OF THE YEAR AND END AS A LAST DAY OF THE YEAR *****************");
		test.log(LogStatus.INFO,
				"***************** UPDATE NEWLY CREATED UTILITY BILLS RECORD - WITH PERIOD START AS A FIRST DAY OF THE YEAR AND END AS A LAST DAY OF THE YEAR *****************");
		Reporter.log(
				"***************** UPDATE NEWLY CREATED UTILITY BILLS RECORD - WITH PERIOD START AS A FIRST DAY OF THE YEAR AND END AS A LAST DAY OF THE YEAR *****************");
		log.info(
				"***************** UPDATE NEWLY CREATED UTILITY BILLS RECORD - WITH PERIOD START AS A FIRST DAY OF THE YEAR AND END AS A LAST DAY OF THE YEAR *****************");

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

			// enter the meter number of bill in the search field
			type("sustainability_searchtxt_XPATH", utilityBills);
			ngDriver.waitForAngularRequestsToFinish();
			System.out.println("Entered the meter number of bill in the search field.");

			// click on the searched bill
			click("sustainability_utilitybills_firstrecord_XPATH");
			ngDriver.waitForAngularRequestsToFinish();
			System.out.println("Clicked on the searched bill.");

			// enter the details in the Period From field
			LocalDate addDate3 = LocalDate.now();
			String addDate3_String = addDate3.toString();
			String[] arrayOfDate3 = addDate3_String.split("-");
			String year3 = arrayOfDate3[0];

			clear("sustainability_utilitybills_periodfrom_XPATH");
			type("sustainability_utilitybills_periodfrom_XPATH", year3 + "-01-01");
			ngDriver.waitForAngularRequestsToFinish();
			System.out.println("Entered the details in the Period From field.");

			// enter the details in the Period To field
			LocalDate addDate4 = LocalDate.now();
			String addDate4_String = addDate4.toString();
			String[] arrayOfDate4 = addDate4_String.split("-");
			String year4 = arrayOfDate4[0];
			clear("sustainability_utilitybills_periodto_XPATH");
			type("sustainability_utilitybills_periodto_XPATH", year4 + "-12-31");
			ngDriver.waitForAngularRequestsToFinish();
			System.out.println("Entered the details in the Period From field.");

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

			// verify the error icon and error of the newly created bill
			try {

				boolean errorIcon = driver
						.findElement(By.xpath(OR.getProperty("sustainability_utilitybills_erroricon_XPATH")))
						.isDisplayed();
				if (errorIcon == true) {

					successMessage("An error icon is displayed successfully.");

					// click on the error icon
					click("sustainability_utilitybills_erroricon_XPATH");
					ngDriver.waitForAngularRequestsToFinish();
					System.out.println("Clicked on the error icon.");

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
					ngDriver.waitForAngularRequestsToFinish();
					System.out.println("Clicked on the conform button.");

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
		System.out.println("Clicked on the home icon from the top of the screen.");
		ngDriver.waitForAngularRequestsToFinish();

		// synchronization
		explicitWait("propertylist_title_XPATH");

		// verify the property list
		switchVerification("propertylist_title_XPATH", "Property List", "The property list is not displayed.");

		// UPDATE NEWLY CREATED UTILITY BILLS RECORD - WITH PERIOD START AS A FIRST DAY
		// OF THE YEAR AND END AS A FUTURE DATE AND SAME YEAR

		System.out.println(
				"***************** UPDATE NEWLY CREATED UTILITY BILLS RECORD - WITH PERIOD START AS A FIRST DAY OF THE YEAR AND END AS A FUTURE DATE AND SAME YEAR *****************");
		test.log(LogStatus.INFO,
				"***************** UPDATE NEWLY CREATED UTILITY BILLS RECORD - WITH PERIOD START AS A FIRST DAY OF THE YEAR AND END AS A FUTURE DATE AND SAME YEAR *****************");
		Reporter.log(
				"***************** UPDATE NEWLY CREATED UTILITY BILLS RECORD - WITH PERIOD START AS A FIRST DAY OF THE YEAR AND END AS A FUTURE DATE AND SAME YEAR *****************");
		log.info(
				"***************** UPDATE NEWLY CREATED UTILITY BILLS RECORD - WITH PERIOD START AS A FIRST DAY OF THE YEAR AND END AS A FUTURE DATE AND SAME YEAR *****************");

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

			// enter the meter number of bill in the search field
			type("sustainability_searchtxt_XPATH", utilityBills);
			ngDriver.waitForAngularRequestsToFinish();
			System.out.println("Entered the meter number of bill in the search field.");

			// click on the searched bill
			click("sustainability_utilitybills_firstrecord_XPATH");
			ngDriver.waitForAngularRequestsToFinish();
			System.out.println("Clicked on the searched bill.");

			// enter the details in the Period From field
			LocalDate addDate3 = LocalDate.now();
			String addDate3_String = addDate3.toString();
			String[] arrayOfDate3 = addDate3_String.split("-");
			String year3 = arrayOfDate3[0];

			clear("sustainability_utilitybills_periodfrom_XPATH");
			type("sustainability_utilitybills_periodfrom_XPATH", year3 + "-01-01");
			ngDriver.waitForAngularRequestsToFinish();
			System.out.println("Entered the details in the Period From field.");

			// enter the details in the Period To field
			LocalDate addDate5 = LocalDate.now().plusDays(2);
			String addDate5_String = addDate5.toString();
			clear("sustainability_utilitybills_periodto_XPATH");
			type("sustainability_utilitybills_periodto_XPATH", addDate5_String);
			ngDriver.waitForAngularRequestsToFinish();
			System.out.println("Entered the details in the Period From field.");

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

			// verify the error icon and error of the newly created bill
			try {

				boolean errorIcon = driver
						.findElement(By.xpath(OR.getProperty("sustainability_utilitybills_erroricon_XPATH")))
						.isDisplayed();
				if (errorIcon == true) {

					successMessage("An error icon is displayed successfully.");

					// click on the error icon
					click("sustainability_utilitybills_erroricon_XPATH");
					ngDriver.waitForAngularRequestsToFinish();
					System.out.println("Clicked on the error icon.");

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
					ngDriver.waitForAngularRequestsToFinish();
					System.out.println("Clicked on the conform button.");

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
		System.out.println("Clicked on the home icon from the top of the screen.");
		ngDriver.waitForAngularRequestsToFinish();

		// synchronization
		explicitWait("propertylist_title_XPATH");

		// verify the property list
		switchVerification("propertylist_title_XPATH", "Property List", "The property list is not displayed.");

		// UPDATE NEWLY CREATED UTILITY BILLS RECORD - WITH PERIOD START DATE AS A
		// GREATED THAN THE END DATE

		System.out.println(
				"***************** UPDATE NEWLY CREATED UTILITY BILLS RECORD - WITH PERIOD START DATE AS A GREATED THAN THE END DATE *****************");
		test.log(LogStatus.INFO,
				"***************** UPDATE NEWLY CREATED UTILITY BILLS RECORD - WITH PERIOD START DATE AS A GREATED THAN THE END DATE *****************");
		Reporter.log(
				"***************** UPDATE NEWLY CREATED UTILITY BILLS RECORD - WITH PERIOD START DATE AS A GREATED THAN THE END DATE *****************");
		log.info(
				"***************** UPDATE NEWLY CREATED UTILITY BILLS RECORD - WITH PERIOD START DATE AS A GREATED THAN THE END DATE *****************");

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

			// enter the meter number of bill in the search field
			type("sustainability_searchtxt_XPATH", utilityBills);
			ngDriver.waitForAngularRequestsToFinish();
			System.out.println("Entered the meter number of bill in the search field.");

			// click on the searched bill
			click("sustainability_utilitybills_firstrecord_XPATH");
			ngDriver.waitForAngularRequestsToFinish();
			System.out.println("Clicked on the searched bill.");

			// enter the details in the Period From field
			LocalDate addDate6 = LocalDate.now();
			String addDate6_String = addDate6.toString();
			clear("sustainability_utilitybills_periodfrom_XPATH");
			type("sustainability_utilitybills_periodfrom_XPATH", addDate6_String);
			ngDriver.waitForAngularRequestsToFinish();
			System.out.println("Entered the details in the Period From field.");

			// enter the details in the Period To field
			LocalDate addDate7 = LocalDate.now().minusDays(2);
			String addDate7_String = addDate7.toString();
			clear("sustainability_utilitybills_periodto_XPATH");
			type("sustainability_utilitybills_periodto_XPATH", addDate7_String);
			ngDriver.waitForAngularRequestsToFinish();
			System.out.println("Entered the details in the Period From field.");

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

			// wait for the element
			Thread.sleep(5000);

			// validate refresh button is displayed or not

			try {

				boolean refreshbtn = driver
						.findElement(By.xpath(OR.getProperty("sustainability_utilitybills_refreshbtn_XPATH")))
						.isDisplayed();

				System.out.println("refreshbtn:::::::::" + refreshbtn);

				if (refreshbtn == true) {

					verificationFailedMessage("The application is allowed to save an invalid dates.");

				} else {

					successMessage("The application not allow to save an invalid dates.");

					// click on the cancel button
					click("sustainability_utilitybills_cancelbtn_XPATH");
					ngDriver.waitForAngularRequestsToFinish();
					System.out.println("Clicked on the cancel button.");

					// wait for the element
					Thread.sleep(5000);

				}

			} catch (Throwable t) {
				successMessage("The application not allow to save an invalid dates.");

				// click on the cancel button
				click("sustainability_utilitybills_cancelbtn_XPATH");
				ngDriver.waitForAngularRequestsToFinish();
				System.out.println("Clicked on the cancel button.");

				// wait for the element
				Thread.sleep(5000);

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

		// UPDATE NEWLY CREATED UTILITY BILLS RECORD - WITH PERIOD START AS A TODAY AND
		// END AS A FUTURE DATE AND SAME YEAR

		System.out.println(
				"***************** UPDATE NEWLY CREATED UTILITY BILLS RECORD - WITH PERIOD START AS A TODAY AND END AS A FUTURE DATE AND SAME YEAR *****************");
		test.log(LogStatus.INFO,
				"***************** UPDATE NEWLY CREATED UTILITY BILLS RECORD - WITH PERIOD START AS A TODAY AND END AS A FUTURE DATE AND SAME YEAR *****************");
		Reporter.log(
				"***************** UPDATE NEWLY CREATED UTILITY BILLS RECORD - WITH PERIOD START AS A TODAY AND END AS A FUTURE DATE AND SAME YEAR *****************");
		log.info(
				"***************** UPDATE NEWLY CREATED UTILITY BILLS RECORD - WITH PERIOD START AS A TODAY AND END AS A FUTURE DATE AND SAME YEAR *****************");

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

			// enter the meter number of bill in the search field
			type("sustainability_searchtxt_XPATH", utilityBills);
			ngDriver.waitForAngularRequestsToFinish();
			System.out.println("Entered the meter number of bill in the search field.");

			// click on the searched bill
			click("sustainability_utilitybills_firstrecord_XPATH");
			ngDriver.waitForAngularRequestsToFinish();
			System.out.println("Clicked on the searched bill.");

			// enter the details in the Period From field
			LocalDate addDate8 = LocalDate.now();
			String addDate8_String = addDate8.toString();

			clear("sustainability_utilitybills_periodfrom_XPATH");
			type("sustainability_utilitybills_periodfrom_XPATH", addDate8_String);
			ngDriver.waitForAngularRequestsToFinish();
			System.out.println("Entered the details in the Period From field.");

			// enter the details in the Period To field
			LocalDate addDate9 = LocalDate.now().plusDays(4);
			String addDate9_String = addDate9.toString();
			clear("sustainability_utilitybills_periodto_XPATH");
			type("sustainability_utilitybills_periodto_XPATH", addDate9_String);
			ngDriver.waitForAngularRequestsToFinish();
			System.out.println("Entered the details in the Period From field.");

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

			// verify the error icon and error of the newly created bill
			try {

				boolean errorIcon = driver
						.findElement(By.xpath(OR.getProperty("sustainability_utilitybills_erroricon_XPATH")))
						.isDisplayed();
				if (errorIcon == true) {

					successMessage("An error icon is displayed successfully.");

					// click on the error icon
					click("sustainability_utilitybills_erroricon_XPATH");
					ngDriver.waitForAngularRequestsToFinish();
					System.out.println("Clicked on the error icon.");

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
					ngDriver.waitForAngularRequestsToFinish();
					System.out.println("Clicked on the conform button.");

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
		System.out.println("Clicked on the home icon from the top of the screen.");
		ngDriver.waitForAngularRequestsToFinish();

		// synchronization
		explicitWait("propertylist_title_XPATH");

		// verify the property list
		switchVerification("propertylist_title_XPATH", "Property List", "The property list is not displayed.");

		// CREATE NEW UTILITY BILLS RECORD - WITH SAME METER NUMBER AND OVERLAP THE
		// DATES

		System.out.println(
				"***************** CREATE NEW UTILITY BILLS RECORD - WITH SAME METER NUMBER AND OVERLAP THE DATES - UPDATE PERIOD FROM DATE *****************");
		test.log(LogStatus.INFO,
				"***************** CREATE NEW UTILITY BILLS RECORD - WITH SAME METER NUMBER AND OVERLAP THE DATES - UPDATE PERIOD FROM DATE *****************");
		Reporter.log(
				"***************** CREATE NEW UTILITY BILLS RECORD - WITH SAME METER NUMBER AND OVERLAP THE DATES - UPDATE PERIOD FROM DATE *****************");
		log.info(
				"***************** CREATE NEW UTILITY BILLS RECORD - WITH SAME METER NUMBER AND OVERLAP THE DATES - UPDATE PERIOD FROM DATE *****************");

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
			LocalDate addDate9 = LocalDate.now().plusDays(2);
			String addDate9_String = addDate9.toString();
			clear("sustainability_utilitybills_periodfrom_XPATH");
			type("sustainability_utilitybills_periodfrom_XPATH", addDate9_String);
			ngDriver.waitForAngularRequestsToFinish();
			System.out.println("Entered the details in the Period From field.");

			// enter the details in the Period To field
			LocalDate addDate10 = LocalDate.now().plusDays(4);
			String addDate10_String = addDate10.toString();
			clear("sustainability_utilitybills_periodto_XPATH");
			type("sustainability_utilitybills_periodto_XPATH", addDate10_String);
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

			// wait for the element
			Thread.sleep(5000);

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
					ngDriver.waitForAngularRequestsToFinish();
					System.out.println("Clicked on the error icon.");

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
					ngDriver.waitForAngularRequestsToFinish();
					System.out.println("Clicked on the conform button.");

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
		System.out.println("Clicked on the home icon from the top of the screen.");
		ngDriver.waitForAngularRequestsToFinish();

		// synchronization
		explicitWait("propertylist_title_XPATH");

		// verify the property list
		switchVerification("propertylist_title_XPATH", "Property List", "The property list is not displayed.");

		// CREATE NEW UTILITY BILLS RECORD - WITH SAME METER NUMBER AND OVERLAP THE
		// DATES - UPDATE PERIOD TO DATE

		System.out.println(
				"***************** CREATE NEW UTILITY BILLS RECORD - WITH SAME METER NUMBER AND OVERLAP THE DATES - UPDATE PERIOD TO DATE *****************");
		test.log(LogStatus.INFO,
				"***************** CREATE NEW UTILITY BILLS RECORD - WITH SAME METER NUMBER AND OVERLAP THE DATES - UPDATE PERIOD TO DATE *****************");
		Reporter.log(
				"***************** CREATE NEW UTILITY BILLS RECORD - WITH SAME METER NUMBER AND OVERLAP THE DATES - UPDATE PERIOD TO DATE  *****************");
		log.info(
				"***************** CREATE NEW UTILITY BILLS RECORD - WITH SAME METER NUMBER AND OVERLAP THE DATES - UPDATE PERIOD TO DATE  *****************");

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
			LocalDate addDate12 = LocalDate.now();
			String addDate12_String = addDate12.toString();
			clear("sustainability_utilitybills_periodfrom_XPATH");
			type("sustainability_utilitybills_periodfrom_XPATH", addDate12_String);
			ngDriver.waitForAngularRequestsToFinish();
			System.out.println("Entered the details in the Period From field.");

			// enter the details in the Period To field
			LocalDate addDate13 = LocalDate.now().plusDays(3);
			String addDate13_String = addDate13.toString();
			clear("sustainability_utilitybills_periodto_XPATH");
			type("sustainability_utilitybills_periodto_XPATH", addDate13_String);
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

			// wait for the element
			Thread.sleep(5000);

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
					ngDriver.waitForAngularRequestsToFinish();
					System.out.println("Clicked on the error icon.");

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
					ngDriver.waitForAngularRequestsToFinish();
					System.out.println("Clicked on the conform button.");

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
