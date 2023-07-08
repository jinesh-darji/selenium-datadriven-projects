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

public class RR6051Sustainability3Test extends TestBase {

	@Test(dataProviderClass = TestUtil.class, dataProvider = "dp")
	public void rR6051Sustainability3Test(Hashtable<String, String> data) throws IOException, InterruptedException {

		execution(data, "rR6051Sustainability3Test");

		// VALIDATE THE CONSUMPTION ANALYSIS MODULE - WITH DIFFERENT UTILITY TYPE AND
		// METER NUMBER
		title("VALIDATE THE CONSUMPTION ANALYSIS MODULE - WITH DIFFERENT UTILITY TYPE AND METER NUMBER");

		// refresh the page
		driver.navigate().refresh();
		Thread.sleep(5000);
		driver.navigate().refresh();

		// CREATE NEW UTILITY METERS RECORD - ELECTRICITY
		title("CREATE NEW UTILITY METERS RECORD - ELECTRICITY");

		String utilityMeter1 = RandomStringUtils.randomAlphanumeric(8);

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

			// click on the UTILITY METERS option
			click("sustainability_sidemenu_utilitymetersoption_XPATH");

			// click on the add button
			click("sustainability_utilitymeter_addbtn_XPATH");

			// enter the meter number
			type("sustainability_utilitymeter_metertxt_XPATH", utilityMeter1);

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

			// verify the newly created utility meter record
			try {
				String UtilityMeter = "//td[text()='" + utilityMeter1 + "']";
				String addedUtilityMeter = (driver.findElement(By.xpath(UtilityMeter)).getText()).trim();
				if (addedUtilityMeter.equals(utilityMeter1)) {
					successMessage("The utility meter is verified successfully.");
				} else {
					verificationFailedMessage("The utility meter is not verified.");
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

		// CREATE NEW UTILITY METERS RECORD - NATURAL GAS
		title("CREATE NEW UTILITY METERS RECORD - NATURAL GAS");

		String utilityMeter2 = RandomStringUtils.randomAlphanumeric(8);

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

			// click on the UTILITY METERS option
			click("sustainability_sidemenu_utilitymetersoption_XPATH");

			// click on the add button
			click("sustainability_utilitymeter_addbtn_XPATH");

			// enter the meter number
			type("sustainability_utilitymeter_metertxt_XPATH", utilityMeter2);

			// enter the details in the description field
			type("sustainability_utilitymeter_descriptiontxt_XPATH", data.get("description"));

			// select the utility type from the drop down
			select("sustainability_utilitymeter_utilitytypedd_XPATH", data.get("update_utility_type"));

			// select the unit of measurement
			select("sustainability_utilitymeter_unitofmeasurementdd_XPATH", data.get("update_unit_measurement"));

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
			select("sustainability_utilitymeter_scope_XPATH", data.get("update_scope"));

			// select the Consumption Category from the dropdown
			select("sustainability_utilitymeter_consumptioncategorydd_XPATH", data.get("update_consumption_category"));

			// select the Source of Data from the dropdown
			select("sustainability_utilitymeter_sourceofdatadd_XPATH", data.get("update_source_of_data"));

			// select the Floor Area Type from the dropdown
			select("sustainability_utilitymeter_floorareatypeadd_XPATH", data.get("update_floor_area_type"));

			// enter the details in the Meter Manufacturer field
			type("sustainability_utilitymeter_metermanufacturertxt_XPATH", data.get("update_meter_manufacturer"));

			// select the Special Use Type from the dropdown
			select("sustainability_utilitymeter_specialusetypedd_XPATH", data.get("update_special_use_type"));

			// select the Financial Control of Meter from the dropdown
			select("sustainability_utilitymeter_financialcontrolofmeterdd_XPATH",
					data.get("update_financial_control_of_meter"));

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

			// verify the newly created utility meter record
			try {
				String UtilityMeter = "//td[text()='" + utilityMeter2 + "']";
				String addedUtilityMeter = (driver.findElement(By.xpath(UtilityMeter)).getText()).trim();
				if (addedUtilityMeter.equals(utilityMeter2)) {
					successMessage("The utility meter is verified successfully.");
				} else {
					verificationFailedMessage("The utility meter is not verified.");
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

		// CREATE NEW CONSUMPTION ANALYSIS RECORD AND IDENTIFY THE METER NUMBER AS PER
		// THE UTILITY TYPE
		title("CREATE NEW CONSUMPTION ANALYSIS RECORD AND IDENTIFY THE METER NUMBER AS PER THE UTILITY TYPE");

		String random1 = RandomStringUtils.randomAlphabetic(8);

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

			// scroll down the screen
			scrollTillElement("sustainability_utilitybills_buildingperformancedataoption_XPATH");

			// click on the building performance data
			click("sustainability_utilitybills_buildingperformancedataoption_XPATH");

			// scroll down the side menu
			scrollTillElement("sustainability_utilitybills_consumptionanalysisoption_XPATH");

			// click on the Consumption Analysis
			click("sustainability_utilitybills_consumptionanalysisoption_XPATH");

			// click on the add button
			click("sustainability_consumptionanalysis_addbtn_XPATH");

			// enter the title in the field
			type("sustainability_consumptionanalysis_titletxt_XPATH", random1);

			// select the option of the utility type
			select("sustainability_consumptionanalysis_utilitytypedd_XPATH", data.get("utility_type"));

			// wait for the element
			Thread.sleep(5000);

			// validate the respective meter in the list
			try {
				List<WebElement> meterOption = driver
						.findElements(By.xpath("//select[@name='meterNumber']//option[@label]"));
				int meterOptionCount = meterOption.size();

				for (int i = 0; i < meterOptionCount; i++) {

					String option = meterOption.get(i).getText();

					if (option.equals(utilityMeter1)) {
						successMessage("The respective meter number is displayed in the meter list.");
					}
				}
			} catch (Throwable t) {
				verificationFailedMessage("The respective meter number is not displayed in the meter list.");
			}

			try {
				List<WebElement> meterOption1 = driver
						.findElements(By.xpath("//select[@name='meterNumber']//option[@label]"));
				int meterOptionCount1 = meterOption1.size();

				for (int i = 0; i < meterOptionCount1; i++) {

					String option1 = meterOption1.get(i).getText();

					if (option1.equals(utilityMeter2)) {

						verificationFailedMessage("The invalid meter number is displayed in the meter list.");

					}
				}
			} catch (Throwable t) {
				verificationFailedMessage("Verification Failed...");
			}

			// select the updated option of the utility type
			select("sustainability_consumptionanalysis_utilitytypedd_XPATH", data.get("update_utility_type"));

			// wait for the element
			Thread.sleep(5000);

			// validate the respective meter in the list
			try {
				List<WebElement> meterOption = driver
						.findElements(By.xpath("//select[@name='meterNumber']//option[@label]"));
				int meterOptionCount = meterOption.size();

				for (int i = 0; i < meterOptionCount; i++) {

					String option = meterOption.get(i).getText();

					if (option.equals(utilityMeter2)) {
						successMessage("The respective meter number is displayed in the meter list.");
					}
				}
			} catch (Throwable t) {
				verificationFailedMessage("The respective meter number is not displayed in the meter list.");
			}

			try {
				List<WebElement> meterOption1 = driver
						.findElements(By.xpath("//select[@name='meterNumber']//option[@label]"));
				int meterOptionCount1 = meterOption1.size();

				for (int i = 0; i < meterOptionCount1; i++) {

					String option1 = meterOption1.get(i).getText();

					if (option1.equals(utilityMeter1)) {

						verificationFailedMessage("The invalid meter number is displayed in the meter list.");

					}
				}
			} catch (Throwable t) {
				verificationFailedMessage("Verification Failed...");
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

		// DELETE THE FIRST UTILITY METER RECORD
		title("DELETE THE FIRST UTILITY METER RECORD");

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

			// click on the UTILITY METERS option
			click("sustainability_sidemenu_utilitymetersoption_XPATH");

			// click on the delete button
			String deletebtn = "//td[text()='" + utilityMeter1
					+ "']//following-sibling::td[@class='text-center w-16-per']//i[@ng-click='setToDelete(meter)']";
			driver.findElement(By.xpath(deletebtn)).click();

			// wait for the element
			explicitWaitClickable("sustainability_utilitymeter_deletebtn_confirmation_XPATH");

			// click on the delete button of the confirmation popup
			click("sustainability_utilitymeter_deletebtn_confirmation_XPATH");

			// wait for the element
			explicitWaitClickable("closetoastmsg_CSS");

			// click on the toaster close button
			click("closetoastmsg_CSS");

			// verify the deleted utility meter record displayed or not

			try {

				String UpdateUtilityMeter1 = "//td[text()='" + utilityMeter1 + "']";
				String updatedUtilityMeter1 = (driver.findElement(By.xpath(UpdateUtilityMeter1)).getText()).trim();

				if (updatedUtilityMeter1.equals(utilityMeter1)) {

					verificationFailedMessage("The utility meter is not deleted.");

				} else {
					successMessage("The utility meter is deleted successfully.");
				}

			} catch (Throwable t) {

				successMessage("The utility meter is deleted successfully.");

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

		// DELETE THE SECOND UTILITY METER RECORD
		title("DELETE THE SECOND UTILITY METER RECORD");

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

			// click on the UTILITY METERS option
			click("sustainability_sidemenu_utilitymetersoption_XPATH");

			// click on the delete button
			String deletebtn = "//td[text()='" + utilityMeter2
					+ "']//following-sibling::td[@class='text-center w-16-per']//i[@ng-click='setToDelete(meter)']";
			driver.findElement(By.xpath(deletebtn)).click();

			// wait for the element
			explicitWaitClickable("sustainability_utilitymeter_deletebtn_confirmation_XPATH");

			// click on the delete button of the confirmation popup
			click("sustainability_utilitymeter_deletebtn_confirmation_XPATH");

			// wait for the element
			explicitWaitClickable("closetoastmsg_CSS");

			// click on the toaster close button
			click("closetoastmsg_CSS");

			// verify the deleted utility meter record displayed or not
			try {

				String UpdateUtilityMeter2 = "//td[text()='" + utilityMeter2 + "']";
				String updatedUtilityMeter2 = (driver.findElement(By.xpath(UpdateUtilityMeter2)).getText()).trim();

				if (updatedUtilityMeter2.equals(utilityMeter2)) {

					verificationFailedMessage("The utility meter is not deleted.");

				} else {
					successMessage("The utility meter is deleted successfully.");
				}

			} catch (Throwable t) {

				successMessage("The utility meter is deleted successfully.");

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