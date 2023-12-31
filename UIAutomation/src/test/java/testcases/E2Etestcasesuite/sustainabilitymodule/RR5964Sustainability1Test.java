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
		title("PERFORMED CRUD OPERATION OF THE UTILITY BILLS MODULE - AT PROPERTY LEVEL");

		// refresh the page
		driver.navigate().refresh();
		explicitWait("sustainabilityicon_CSS");
		driver.navigate().refresh();

		// CREATE NEW UTILITY BILLS RECORD - AT PROPERTY LEVEL
		title("CREATE NEW UTILITY BILLS RECORD - AT PROPERTY LEVEL");

		String utilityBills = RandomStringUtils.randomNumeric(8);
		String updateUtilityBills = RandomStringUtils.randomNumeric(8);

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

		} catch (Throwable t) {
			verificationFailed();
		}

		// UPDATE THE NEWLY CREATED UTILITY BILLS RECORD
		title("UPDATE THE NEWLY CREATED UTILITY BILLS RECORD");

		try {

			// click on the newly created utility bill record
			LocalDate updateDate = LocalDate.now().minusMonths(6);
			String updateDate_String = updateDate.toString();
			String UtilityBills = "//td[contains(text(),'" + updateDate_String + "')]";
			driver.findElement(By.xpath(UtilityBills)).click();

			// click on the no button of the tenant paid field
			click("sustainability_utilitybills_tenantpaidno_XPATH");

			// click on the no button of the Estimated field
			click("sustainability_utilitybills_estimatedno_XPATH");

			// enter the details in the Period From field
			LocalDate updateDate1 = LocalDate.now().minusMonths(8);
			String updateDate1_String = updateDate1.toString();
			type("sustainability_utilitybills_periodfrom_XPATH", updateDate1_String);

			// enter the details in the Period To field
			LocalDate updateDate2 = LocalDate.now().plusMonths(8);
			String updateDate2_String = updateDate2.toString();
			type("sustainability_utilitybills_periodto_XPATH", updateDate2_String);

			// enter details in the Number of Billing Days field
			type("sustainability_utilitybills_numberofbillingdays_XPATH", "400");

			// enter the details in the reading date field
			LocalDate updateDate3 = LocalDate.now();
			String updateDate3_String = updateDate3.toString();
			type("sustainability_utilitybills_readingdate_XPATH", updateDate3_String);

			// enter details in the Current Meter Reading field
			type("sustainability_utilitybills_currentmeterreading_XPATH", "200");

			// enter details in the Last Meter Reading field
			type("sustainability_utilitybills_lastmeterreading_XPATH", "1500");

			// enter details in the Meter Number field
			type("sustainability_utilitybills_meternumber_XPATH", updateUtilityBills);

			// enter the details in the Billing Date field
			LocalDate updateDate4 = LocalDate.now().plusDays(7);
			String updateDate4_String = updateDate4.toString();
			type("sustainability_utilitybills_billingdate_XPATH", updateDate4_String);

			// enter details in the Consumption field
			String random22 = RandomStringUtils.randomNumeric(2);
			type("sustainability_utilitybills_consumption_XPATH", random22);

			// enter details in the Adjusted Consumption field
			type("sustainability_utilitybills_adjustedconsumption_XPATH", "0");

			// select the Unit of Measure option from the dropdown
			select("sustainability_utilitybills_unitofmeasure_XPATH", data.get("update_unit"));

			// enter details in the Peak Demand field
			type("sustainability_utilitybills_peakdemand_XPATH", "20");

			// select the Peak Demand Unit of Measure option from the dropdown
			select("sustainability_utilitybills_peakdemandunitofmeasure_XPATH", data.get("update_unit"));

			// enter details in the Total Cost field
			type("sustainability_utilitybills_totalcost_XPATH", "100");

			// enter details in the Reference Number field
			String random33 = RandomStringUtils.randomNumeric(8);
			type("sustainability_utilitybills_referencenumber_XPATH", random33);

			// enter details in the Control Number field
			String random44 = RandomStringUtils.randomNumeric(8);
			type("sustainability_utilitybills_controlnumber_XPATH", random44);

			// enter details in the Multiplier field
			String random55 = RandomStringUtils.randomNumeric(2);
			type("sustainability_utilitybills_multiplier_XPATH", random55);

			// enter details in the Description field
			type("sustainability_utilitybills_description_XPATH", data.get("update_description"));

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
			type("sustainability_searchtxt_XPATH", updateUtilityBills);

			// verify the updated utility bill record
			try {
				String UtilityBills2 = "//td[contains(text(),'" + updateUtilityBills + "')]";
				String addedUtilityBills2 = (driver.findElement(By.xpath(UtilityBills2)).getText()).trim();
				if (addedUtilityBills2.equals(updateUtilityBills)) {
					successMessage("The utility bills is verified successfully.");
				} else {
					verificationFailedMessage("The utility bills is not verified.");
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

		// DELETE THE UPDATED UTILITY BILLS RECORD
		title("DELETE THE UPDATED UTILITY BILLS RECORD");

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

			// click on the updated utility bill record
			LocalDate deleteDate = LocalDate.now().minusMonths(8);
			String deleteDate_String = deleteDate.toString();
			String UtilityBills3 = "//td[contains(text(),'" + deleteDate_String + "')]";
			driver.findElement(By.xpath(UtilityBills3)).click();

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

			// click on the refresh button
			click("sustainability_utilitybills_refreshbtn_XPATH");

			// enter the updated utility meter record in the search field
			type("sustainability_searchtxt_XPATH", updateUtilityBills);

			// verify the deleted utility bill record displayed or not
			try {

				String UpdateUtilityBills1 = "//td[contains(text(),'" + updateUtilityBills + "')]";
				String updatedUtilityBills1 = (driver.findElement(By.xpath(UpdateUtilityBills1)).getText()).trim();

				if (updatedUtilityBills1.equals(updateUtilityBills)) {

					verificationFailedMessage("The utility bill is not deleted");
				}
			} catch (Throwable t) {
				successMessage("The utility bill is deleted successfully.");
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