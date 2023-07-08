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

import base.Helper;
import base.TestBase;
import utilities.TestUtil;

public class RR5961Sustainability2Test extends TestBase {

	@Test(dataProviderClass = TestUtil.class, dataProvider = "dp")
	public void rR5961Sustainability2Test(Hashtable<String, String> data) throws IOException, InterruptedException {

		execution(data, "rR5961Sustainability2Test");

		Helper helper = new Helper();

		// PERFORMED CRUD OPERATION OF THE UTILITY METER MODULE - AT BUILDING LEVEL

		System.out.println("PERFORMED CRUD OPERATION OF THE UTILITY METER MODULE - AT BUILDING LEVEL");
		test.log(LogStatus.INFO, "PERFORMED CRUD OPERATION OF THE UTILITY METER MODULE - AT BUILDING LEVEL");
		Reporter.log("PERFORMED CRUD OPERATION OF THE UTILITY METER MODULE - AT BUILDING LEVEL");
		log.info("PERFORMED CRUD OPERATION OF THE UTILITY METER MODULE - AT BUILDING LEVEL");

		// refresh the page
		driver.navigate().refresh();
		explicitWait("sustainabilityicon_CSS");
		driver.navigate().refresh();

		System.out.println("Navigate to the Home Screen i.e. Property List Screen.");

		// CREATE NEW UTILITY METER RECORD - AT PROPERTY LEVEL

		System.out.println("***************** CREATE NEW UTILITY METER RECORD - AT PROPERTY LEVEL *****************");
		test.log(LogStatus.INFO,
				"***************** CREATE NEW UTILITY METER RECORD - AT PROPERTY LEVEL *****************");
		Reporter.log("***************** CREATE NEW UTILITY METER RECORD - AT PROPERTY LEVEL *****************");
		log.info("***************** CREATE NEW UTILITY METER RECORD - AT PROPERTY LEVEL *****************");

		String utilityMeter_property = RandomStringUtils.randomAlphanumeric(8);
		String utilityMeter_building = RandomStringUtils.randomAlphanumeric(8);
		String updateUtilityMeter_building = RandomStringUtils.randomAlphanumeric(8);

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

			// click on the UTILITY METERS option
			click("sustainability_sidemenu_utilitymetersoption_XPATH");
			ngDriver.waitForAngularRequestsToFinish();
			System.out.println("Clicked on the UTILITY METERS option.");

			// click on the add button
			click("sustainability_utilitymeter_addbtn_XPATH");
			ngDriver.waitForAngularRequestsToFinish();
			System.out.println("Clicked on the add button.");

			// enter the meter number
			clear("sustainability_utilitymeter_metertxt_XPATH");
			type("sustainability_utilitymeter_metertxt_XPATH", utilityMeter_property);
			ngDriver.waitForAngularRequestsToFinish();
			System.out.println("Entered the meter number.");

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
			JavascriptExecutor js = (JavascriptExecutor) driver;
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

			// verify the newly created utility meter record
			try {
				String UtilityMeter = "//td[text()='" + utilityMeter_property + "']";
				String addedUtilityMeter = (driver.findElement(By.xpath(UtilityMeter)).getText()).trim();
				if (addedUtilityMeter.equals(utilityMeter_property)) {

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

		// CREATE NEW UTILITY METER RECORD - AT BUILDING LEVEL

		System.out.println("***************** CREATE NEW UTILITY METER RECORD - AT BUILDING LEVEL *****************");
		test.log(LogStatus.INFO,
				"***************** CREATE NEW UTILITY METER RECORD - AT BUILDING LEVEL *****************");
		Reporter.log("***************** CREATE NEW UTILITY METER RECORD - AT BUILDING LEVEL *****************");
		log.info("***************** CREATE NEW UTILITY METER RECORD - AT BUILDING LEVEL *****************");

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

			// click on the UTILITY METERS option
			click("sustainability_sidemenu_utilitymetersoption_XPATH");
			ngDriver.waitForAngularRequestsToFinish();
			System.out.println("Clicked on the UTILITY METERS option.");

			// select the building from the top dropdown
			select("task_addedtask_propertybuildingdd_CSS", data.get("property_dd_building"));
			ngDriver.waitForAngularRequestsToFinish();
			System.out.println("Selected the building from the top dropdown.");

			// click on the add button
			click("sustainability_utilitymeter_addbtn_XPATH");
			ngDriver.waitForAngularRequestsToFinish();
			System.out.println("Clicked on the add button.");

			// enter the meter number
			type("sustainability_utilitymeter_metertxt_XPATH", utilityMeter_building);
			ngDriver.waitForAngularRequestsToFinish();
			System.out.println("Entered the meter number.");

			// enter the details in the description field
			type("sustainability_utilitymeter_descriptiontxt_XPATH", data.get("description_building"));
			ngDriver.waitForAngularRequestsToFinish();
			System.out.println("Entered the details in the description field.");

			// select the utility type from the drop down
			select("sustainability_utilitymeter_utilitytypedd_XPATH", data.get("utility_type_building"));
			ngDriver.waitForAngularRequestsToFinish();
			System.out.println("Selected the utility type from the drop down.");

			// select the unit of measurement
			select("sustainability_utilitymeter_unitofmeasurementdd_XPATH", data.get("unit_measurement_building"));
			ngDriver.waitForAngularRequestsToFinish();
			System.out.println("Selected the unit of measurement.");

			// scroll down the screen
			JavascriptExecutor js = (JavascriptExecutor) driver;
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
			type("sustainability_utilitymeter_areacoveredtxt_XPATH", "10");
			ngDriver.waitForAngularRequestsToFinish();
			System.out.println("Entered the details in the area covered.");

			// select the GHG Emissions Scope from the dropdown
			select("sustainability_utilitymeter_scope_XPATH", data.get("scope_building"));
			ngDriver.waitForAngularRequestsToFinish();
			System.out.println("Selected the GHG Emissions Scope from the dropdown.");

			// select the Consumption Category from the dropdown
			select("sustainability_utilitymeter_consumptioncategorydd_XPATH",
					data.get("consumption_category_building"));
			ngDriver.waitForAngularRequestsToFinish();
			System.out.println("Selected the Consumption Category from the dropdown.");

			// select the Source of Data from the dropdown
			select("sustainability_utilitymeter_sourceofdatadd_XPATH", data.get("source_of_data_building"));
			ngDriver.waitForAngularRequestsToFinish();
			System.out.println("Selected the Source of Data from the dropdown.");

			// select the Floor Area Type from the dropdown
			select("sustainability_utilitymeter_floorareatypeadd_XPATH", data.get("floor_area_type_building"));
			ngDriver.waitForAngularRequestsToFinish();
			System.out.println("Selected the Floor Area Type from the dropdown.");

			// enter the details in the Meter Manufacturer field
			type("sustainability_utilitymeter_metermanufacturertxt_XPATH", data.get("meter_manufacturer_building"));
			ngDriver.waitForAngularRequestsToFinish();
			System.out.println("Entered the details in the Meter Manufacturer field.");

			// select the Special Use Type from the dropdown
			select("sustainability_utilitymeter_specialusetypedd_XPATH", data.get("special_use_type_building"));
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
			type("sustainability_utilitymeter_dateinstalled_XPATH", addCurrentDate1_String);
			ngDriver.waitForAngularRequestsToFinish();
			System.out.println("Entered the details in the Date Installed field.");

			// enter the details in the Date Activated field
			LocalDate addCurrentDate2 = LocalDate.now();
			String addCurrentDate2_String = addCurrentDate2.toString();
			type("sustainability_utilitymeter_dateactivated_XPATH", addCurrentDate2_String);
			ngDriver.waitForAngularRequestsToFinish();
			System.out.println("Entered the details in the Date Activated field.");

			// enter the details in the Date Deactivated field
			LocalDate addFutureDate1 = LocalDate.now().plusMonths(9);
			String addFutureDate1_String = addFutureDate1.toString();
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

			// verify the newly created utility meter record
			try {
				String UtilityMeter = "//td[text()='" + utilityMeter_building + "']";
				String addedUtilityMeter = (driver.findElement(By.xpath(UtilityMeter)).getText()).trim();
				if (addedUtilityMeter.equals(utilityMeter_building)) {

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

			// verify the newly created utility meter record displayed or not at building
			// level verify the type of the newly created utility meter record

			try {
				String UtilityMeter = "//td[text()='" + utilityMeter_property + "']";
				String addedUtilityMeter = (driver.findElement(By.xpath(UtilityMeter)).getText()).trim();
				if (addedUtilityMeter.equals(utilityMeter_property)) {

					helper.verificationFailedMessage("The property utility meter is displayed at building level.");

				} else {

					helper.successMessage("The property utility meter is not displayed at building level as expected.");
				}
			} catch (Throwable t) {

				helper.successMessage("The property utility meter is not displayed at building level as expected.");

			}

			// select the property from the top dropdown
			select("task_addedtask_propertybuildingdd_CSS", data.get("property_dd_property"));
			ngDriver.waitForAngularRequestsToFinish();
			System.out.println("Selected the property from the top dropdown.");

			// verify the newly created utility meter record
			try {
				String UtilityMeter = "//td[text()='1']//preceding-sibling::td[text()='" + utilityMeter_building + "']";
				String addedUtilityMeter = (driver.findElement(By.xpath(UtilityMeter)).getText()).trim();
				if (addedUtilityMeter.equals(utilityMeter_building)) {

					helper.successMessage("The utility meter is verified successfully.");

				} else {
					helper.verificationFailedMessage("The utility meter is not verified.");
				}
			} catch (Throwable t) {
				helper.verificationFailedMessage("The utility meter is not verified.");

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

		// UPDATE THE NEWLY CREATED UTILITY METER RECORD - AT BUILDING LEVEL

		System.out.println(
				"***************** UPDATE THE NEWLY CREATED UTILITY METER RECORD - AT BUILDING LEVEL *****************");
		test.log(LogStatus.INFO,
				"***************** UPDATE THE NEWLY CREATED UTILITY METER RECORD - AT BUILDING LEVEL *****************");
		Reporter.log(
				"***************** UPDATE THE NEWLY CREATED UTILITY METER RECORD - AT BUILDING LEVEL *****************");
		log.info(
				"***************** UPDATE THE NEWLY CREATED UTILITY METER RECORD - AT BUILDING LEVEL *****************");

		try {

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

			// click on the utility meters option
			click("sustainability_sidemenu_utilitymetersoption_XPATH");
			ngDriver.waitForAngularRequestsToFinish();
			System.out.println("Clicked on the utility meters option.");

			// wait for the element
			Thread.sleep(5000);

			// select the building from the top dropdown
			select("task_addedtask_propertybuildingdd_CSS", data.get("property_dd_building"));
			ngDriver.waitForAngularRequestsToFinish();
			System.out.println("Selected the building from the top dropdown.");

			// click on the newly created utility meter record
			String UtilityMeter1 = "//td[text()='" + utilityMeter_building + "']";
			driver.findElement(By.xpath(UtilityMeter1)).click();
			ngDriver.waitForAngularRequestsToFinish();
			System.out.println("Clicked on the newly created document / report record.");

			// click on the details tab
			click("sustainability_utilitymeter_detailtab_XPATH");
			ngDriver.waitForAngularRequestsToFinish();
			System.out.println("Clicked on the details tab.");

			// enter the meter number
			clear("sustainability_utilitymeter_metertxt_XPATH");
			type("sustainability_utilitymeter_metertxt_XPATH", updateUtilityMeter_building);
			ngDriver.waitForAngularRequestsToFinish();
			System.out.println("Entered the meter number.");

			// enter the details in the description field
			clear("sustainability_utilitymeter_descriptiontxt_XPATH");
			type("sustainability_utilitymeter_descriptiontxt_XPATH", data.get("update_description_building"));
			ngDriver.waitForAngularRequestsToFinish();
			System.out.println("Entered the details in the description field.");

			// scroll down the screen
			JavascriptExecutor js = (JavascriptExecutor) driver;
			WebElement ele2 = driver
					.findElement(By.xpath(OR.getProperty("sustainability_utilitymeter_unitofmeasurementdd_XPATH")));
			js.executeScript("arguments[0].scrollIntoView(true);", ele2);

			// click on the no option of the is green energy field
			click("sustainability_utilitymeter_isgreenenergyno_XPATH");
			ngDriver.waitForAngularRequestsToFinish();
			System.out.println("Clicked on the no option of the is green energy field.");

			// enter the details in the area covered
			clear("sustainability_utilitymeter_areacoveredtxt_XPATH");
			type("sustainability_utilitymeter_areacoveredtxt_XPATH", "20");
			ngDriver.waitForAngularRequestsToFinish();
			System.out.println("Entered the details in the area covered.");

			// select the GHG Emissions Scope from the dropdown
			select("sustainability_utilitymeter_scope_XPATH", data.get("update_scope_building"));
			ngDriver.waitForAngularRequestsToFinish();
			System.out.println("Selected the GHG Emissions Scope from the dropdown.");

			// select the Consumption Category from the dropdown
			select("sustainability_utilitymeter_consumptioncategorydd_XPATH",
					data.get("update_consumption_category_building"));
			ngDriver.waitForAngularRequestsToFinish();
			System.out.println("Selected the Consumption Category from the dropdown.");

			// select the Source of Data from the dropdown
			select("sustainability_utilitymeter_sourceofdatadd_XPATH", data.get("update_source_of_data_building"));
			ngDriver.waitForAngularRequestsToFinish();
			System.out.println("Selected the Source of Data from the dropdown.");

			// select the Floor Area Type from the dropdown
			select("sustainability_utilitymeter_floorareatypeadd_XPATH", data.get("update_floor_area_type_building"));
			ngDriver.waitForAngularRequestsToFinish();
			System.out.println("Selected the Floor Area Type from the dropdown.");

			// enter the details in the Meter Manufacturer field
			clear("sustainability_utilitymeter_metermanufacturertxt_XPATH");
			type("sustainability_utilitymeter_metermanufacturertxt_XPATH",
					data.get("update_meter_manufacturer_building"));
			ngDriver.waitForAngularRequestsToFinish();
			System.out.println("Entered the details in the Meter Manufacturer field.");

			// select the Special Use Type from the dropdown
			select("sustainability_utilitymeter_specialusetypedd_XPATH", data.get("update_special_use_type_building"));
			ngDriver.waitForAngularRequestsToFinish();
			System.out.println("Selected the Special Use Type from the dropdown.");

			// select the Financial Control of Meter from the dropdown
			select("sustainability_utilitymeter_financialcontrolofmeterdd_XPATH",
					data.get("update_financial_control_of_meter_building"));
			ngDriver.waitForAngularRequestsToFinish();
			System.out.println("Selected the Financial Control of Meter from the dropdown.");

			// scroll down the screen
			js.executeScript("window.scrollBy(0,100)");

			// enter the details in the Date Installed field
			LocalDate updatePastDate1 = LocalDate.now().minusDays(5);
			String updatePastDate1_String = updatePastDate1.toString();
			clear("sustainability_utilitymeter_dateinstalled_XPATH");
			type("sustainability_utilitymeter_dateinstalled_XPATH", updatePastDate1_String);
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
			LocalDate addFutureDate1 = LocalDate.now().plusYears(1);
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

			// verify the newly created utility meter record
			try {
				String UpdateUtilityMeter = "//td[text()='" + updateUtilityMeter_building + "']";
				String updatedUtilityMeter = (driver.findElement(By.xpath(UpdateUtilityMeter)).getText()).trim();
				if (updatedUtilityMeter.equals(updateUtilityMeter_building)) {

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

		// DELETE THE UPDATED UTILITY METER RECORD - AT PROPERTY AND BUILDING
		// LEVEL

		System.out.println(
				"***************** DELETE THE UPDATED UTILITY METER RECORD - AT PROPERTY AND BUILDING LEVEL *****************");
		test.log(LogStatus.INFO,
				"***************** DELETE THE UPDATED UTILITY METER RECORD - AT PROPERTY AND BUILDING LEVEL *****************");
		Reporter.log(
				"***************** DELETE THE UPDATED UTILITY METER RECORD - AT PROPERTY AND BUILDING LEVEL *****************");
		log.info(
				"***************** DELETE THE UPDATED UTILITY METER RECORD - AT PROPERTY AND BUILDING LEVEL *****************");

		try {

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

			// click on the UTILITY METERS option
			click("sustainability_sidemenu_utilitymetersoption_XPATH");
			ngDriver.waitForAngularRequestsToFinish();
			System.out.println("Clicked on the UTILITY METERS option.");

			// select the building from the top dropdown
			select("task_addedtask_propertybuildingdd_CSS", data.get("property_dd_building"));
			ngDriver.waitForAngularRequestsToFinish();
			System.out.println("Selected the building from the top dropdown.");

			// click on the delete button
			String deletebtn = "//td[text()='" + updateUtilityMeter_building
					+ "']//following-sibling::td[@class='text-center w-16-per']//i[@ng-click='setToDelete(meter)']";
			driver.findElement(By.xpath(deletebtn)).click();
			ngDriver.waitForAngularRequestsToFinish();
			System.out.println("Clicked on the delete button.");

			// wait for the element
			explicitWaitClickable("sustainability_utilitymeter_deletebtn_confirmation_XPATH");

			// click on the delete button of the confirmation popup
			click("sustainability_utilitymeter_deletebtn_confirmation_XPATH");
			ngDriver.waitForAngularRequestsToFinish();
			System.out.println("Clicked on the delete button of the confirmation popup.");

			// wait for the element
			explicitWaitClickable("closetoastmsg_CSS");

			// click on the toaster close button
			click("closetoastmsg_CSS");
			ngDriver.waitForAngularRequestsToFinish();
			System.out.println("Clicked on the toaster close button.");

			// verify the deleted utility meter record displayed or not

			try {

				String UpdateUtilityMeter1 = "//td[text()='" + updateUtilityMeter_building + "']";
				String updatedUtilityMeter1 = (driver.findElement(By.xpath(UpdateUtilityMeter1)).getText()).trim();

				if (updatedUtilityMeter1.equals(updateUtilityMeter_building)) {

					TestUtil.captureScreenshot();

					// ReportNG
					Reporter.log("<br>" + "The utility meter is not deleted : " + "<br>");
					Reporter.log("<a target=\"_blank\" href=" + TestUtil.screenshotName + "><img src="
							+ TestUtil.screenshotName + " height=200 width=200></img></a>");
					Reporter.log("<br>");
					Reporter.log("<br>");

					// Extent Report
					test.log(LogStatus.FAIL, " The utility meter is not deleted : ");
					test.log(LogStatus.FAIL, test.addScreenCapture(TestUtil.screenshotName));

					System.out.println("The utility meter is not deleted.");
					log.info("The utility meter is not deleted.");

				}
			} catch (Throwable t) {
				System.out.println("The utility meter is deleted successfully.");
				test.log(LogStatus.INFO, "The utility meter is deleted successfully.");
				Reporter.log("The utility meter is deleted successfully.");
				log.info("The utility meter is deleted successfully.");
			}

			// select the property from the top dropdown
			select("task_addedtask_propertybuildingdd_CSS", data.get("property_dd_property"));
			ngDriver.waitForAngularRequestsToFinish();
			System.out.println("Selected the property from the top dropdown.");

			// click on the delete button
			String deletebtn_property = "//td[text()='" + utilityMeter_property
					+ "']//following-sibling::td[@class='text-center w-16-per']//i[@ng-click='setToDelete(meter)']";
			driver.findElement(By.xpath(deletebtn_property)).click();
			ngDriver.waitForAngularRequestsToFinish();
			System.out.println("Clicked on the delete button.");

			// wait for the element
			explicitWaitClickable("sustainability_utilitymeter_deletebtn_confirmation_XPATH");

			// click on the delete button of the confirmation popup
			click("sustainability_utilitymeter_deletebtn_confirmation_XPATH");
			ngDriver.waitForAngularRequestsToFinish();
			System.out.println("Clicked on the delete button of the confirmation popup.");

			// wait for the element
			explicitWaitClickable("closetoastmsg_CSS");

			// click on the toaster close button
			click("closetoastmsg_CSS");
			ngDriver.waitForAngularRequestsToFinish();
			System.out.println("Clicked on the toaster close button.");

			// verify the deleted utility meter record displayed or not

			try {

				String UpdateUtilityMeter1 = "//td[text()='" + utilityMeter_property + "']";
				String updatedUtilityMeter1 = (driver.findElement(By.xpath(UpdateUtilityMeter1)).getText()).trim();

				if (updatedUtilityMeter1.equals(utilityMeter_property)) {

					TestUtil.captureScreenshot();

					// ReportNG
					Reporter.log("<br>" + "The utility meter is not deleted : " + "<br>");
					Reporter.log("<a target=\"_blank\" href=" + TestUtil.screenshotName + "><img src="
							+ TestUtil.screenshotName + " height=200 width=200></img></a>");
					Reporter.log("<br>");
					Reporter.log("<br>");

					// Extent Report
					test.log(LogStatus.FAIL, " The utility meter is not deleted : ");
					test.log(LogStatus.FAIL, test.addScreenCapture(TestUtil.screenshotName));

					System.out.println("The utility meter is not deleted.");
					log.info("The utility meter is not deleted.");

				}
			} catch (Throwable t) {
				System.out.println("The utility meter is deleted successfully.");
				test.log(LogStatus.INFO, "The utility meter is deleted successfully.");
				Reporter.log("The utility meter is deleted successfully.");
				log.info("The utility meter is deleted successfully.");
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