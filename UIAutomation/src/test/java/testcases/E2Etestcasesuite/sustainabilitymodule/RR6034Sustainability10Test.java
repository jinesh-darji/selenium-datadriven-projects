package testcases.E2Etestcasesuite.sustainabilitymodule;

import java.io.IOException;
import java.time.LocalDate;
import java.util.Hashtable;

import org.apache.commons.lang3.RandomStringUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.testng.Reporter;
import org.testng.SkipException;
import org.testng.annotations.Test;

import com.relevantcodes.extentreports.LogStatus;

import base.Helper;
import base.TestBase;
import utilities.TestUtil;

public class RR6034Sustainability10Test extends TestBase {

	@Test(dataProviderClass = TestUtil.class, dataProvider = "dp")
	public void rR6034Sustainability10Test(Hashtable<String, String> data) throws IOException, InterruptedException {

		execution(data, "rR6034Sustainability10Test");

		// VALIDATE THE PERMISSION TO EDIT UTILITY METERS SECURITY SETTINGS

		System.out.println("VALIDATE THE PERMISSION TO EDIT UTILITY METERS SECURITY SETTINGS");
		test.log(LogStatus.INFO, "VALIDATE THE PERMISSION TO EDIT UTILITY METERS SECURITY SETTINGS");
		Reporter.log("VALIDATE THE PERMISSION TO EDIT UTILITY METERS SECURITY SETTINGS");
		log.info("VALIDATE THE PERMISSION TO EDIT UTILITY METERS SECURITY SETTINGS");

		Helper helper = new Helper();

		// refresh the page
		driver.navigate().refresh();
		explicitWait("sustainabilityicon_CSS");
		driver.navigate().refresh();

		System.out.println("Navigate to the Home Screen i.e. Property List Screen.");

		// CREATE NEW UTILITY METERS RECORD - AT PROPERTY LEVEL

		System.out.println("***************** CREATE NEW UTILITY METERS RECORD - AT PROPERTY LEVEL *****************");
		test.log(LogStatus.INFO,
				"***************** CREATE NEW UTILITY METERS RECORD - AT PROPERTY LEVEL *****************");
		Reporter.log("***************** CREATE NEW UTILITY METERS RECORD - AT PROPERTY LEVEL *****************");
		log.info("***************** CREATE NEW UTILITY METERS RECORD - AT PROPERTY LEVEL *****************");

		String utilityMeter = RandomStringUtils.randomAlphanumeric(8);

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

			// wait for the element
			Thread.sleep(5000);

			// click on the add button
			click("sustainability_utilitymeter_addbtn_XPATH");
			ngDriver.waitForAngularRequestsToFinish();
			System.out.println("Clicked on the add button.");

			// enter the meter number
			clear("sustainability_utilitymeter_metertxt_XPATH");
			type("sustainability_utilitymeter_metertxt_XPATH", utilityMeter);
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
				String UtilityMeter = "//td[text()='" + utilityMeter + "']";
				String addedUtilityMeter = (driver.findElement(By.xpath(UtilityMeter)).getText()).trim();
				if (addedUtilityMeter.equals(utilityMeter)) {

					successMessage("The utility meter is verified successfully.");

				} else {

					verificationFailedMessage("The utility meter is not verified.");

				}
			} catch (Throwable t) {
				verificationFailedMessage("The utility meter is not verified.");
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

		// UPDATE THE PERMISSION TO EDIT UTILITY METERS SECURITY SETTINGS

		System.out.println(
				"***************** UPDATE THE PERMISSION TO EDIT UTILITY METERS SECURITY SETTINGS *****************");
		test.log(LogStatus.INFO,
				"***************** UPDATE THE PERMISSION TO EDIT UTILITY METERS SECURITY SETTINGS *****************");
		Reporter.log(
				"***************** UPDATE THE PERMISSION TO EDIT UTILITY METERS SECURITY SETTINGS *****************");
		log.info("***************** UPDATE THE PERMISSION TO EDIT UTILITY METERS SECURITY SETTINGS *****************");

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

			// click on the security tab
			click("questionnaire_securitytab_XPATH");
			System.out.println("Clicked on the security tab.");
			ngDriver.waitForAngularRequestsToFinish();

			// click on the security settings option
			click("questionnaire_securotysettingsoption_XPATH");
			System.out.println("Clicked on the security settings option.");
			ngDriver.waitForAngularRequestsToFinish();

			// RESET THE PERMISSION TO EDIT BUILDING CERTIFICATES SECURITY SETTINGS

			helper.resetPermission(data, "security_setting_1", "sustainability_utilitybills_securitysettings10_XPATH");

		} catch (Throwable t) {
			verificationFailed();
		}

		// click on the home icon
		click("questionnaire_homeburgermenubtn_CSS");
		ngDriver.waitForAngularRequestsToFinish();
		System.out.println("Clicked on the home icon.");

		// wait for the element
		explicitWait("propertylist_title_XPATH");

		// verify the property list
		switchVerification("propertylist_title_XPATH", "Property List", "The property list is not displayed.");

		// VALIDATE THE PERMISSION TO EDIT UTILITY METERS IN ADMIN USER

		System.out.println(
				"***************** VALIDATE THE PERMISSION TO EDIT UTILITY METERS IN ADMIN USER *****************");
		test.log(LogStatus.INFO,
				"***************** VALIDATE THE PERMISSION TO EDIT UTILITY METERS IN ADMIN USER *****************");
		Reporter.log(
				"***************** VALIDATE THE PERMISSION TO EDIT UTILITY METERS IN ADMIN USER *****************");
		log.info("***************** VALIDATE THE PERMISSION TO EDIT UTILITY METERS IN ADMIN USER *****************");

		try {

			// enter the property name in the search field
			clear("envreports_propertylist_filtertxt_CSS");
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

			// validate the add button of the utility meter
			try {
				boolean addBtn = driver
						.findElement(By.xpath(OR.getProperty("sustainability_utilitymeter_addbtn_XPATH")))
						.isDisplayed();

				if (addBtn == true) {

					successMessage("The add button of the utility meter is displayed as expected.");

				} else {
					verificationFailedMessage("The add button of the utility meter is not displayed.");
				}

			} catch (Throwable t) {
				verificationFailedMessage("The add button of the utility meter is not displayed.");

			}

			// click on the newly created utility meter record
			String UtilityMeter1 = "//td[text()='" + utilityMeter + "']";
			driver.findElement(By.xpath(UtilityMeter1)).click();
			ngDriver.waitForAngularRequestsToFinish();
			System.out.println("Clicked on the newly created meter record.");

			// validate the save button of the utility meter
			try {
				boolean saveBtn = driver
						.findElement(By.xpath(OR.getProperty("sustainability_utilitymeter_savebtn_XPATH")))
						.isDisplayed();

				if (saveBtn == true) {

					successMessage("The save button of the utility meter is displayed as expected.");

				} else {
					verificationFailedMessage("The save button of the utility meter is not displayed.");
				}

			} catch (Throwable t) {
				verificationFailedMessage("The save button of the utility meter is not displayed.");

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

		// LOGOUT FROM THE ADMIN USER AND LOGIN IN JINESH USER

		System.out.println("***************** LOGOUT FROM THE ADMIN USER AND LOGIN IN JINESH USER *****************");
		test.log(LogStatus.INFO,
				"***************** LOGOUT FROM THE ADMIN USER AND LOGIN IN JINESH USER *****************");
		Reporter.log("***************** LOGOUT FROM THE ADMIN USER AND LOGIN IN JINESH USER *****************");
		log.info("***************** LOGOUT FROM THE ADMIN USER AND LOGIN IN JINESH USER *****************");

		try {

			try {
				// wait for the element
				explicitWaitClickable("questionnaire_settingicon_CSS");

				// click on the settings icon from the top of the screen
				click("questionnaire_settingicon_CSS");
				System.out.println("Clicked on the settings icon.");
				ngDriver.waitForAngularRequestsToFinish();

				// wait for the element
				explicitWaitClickable("sidemenu_logout_CSS");

				// click on the logout option from the side menu
				click("sidemenu_logout_CSS");
				System.out.println("Clicked on the logout option from the side menu.");
				ngDriver.waitForAngularRequestsToFinish();

				helper.loginAndUpdateSystemCompany(data, "username", "password", "SystemCompany");

			} catch (Throwable t) {
				verificationFailed();
			}

			// VALIDATE THE PERMISSION TO EDIT UTILITY METERS IN PROPERTY MANAGER USER

			System.out.println(
					"***************** VALIDATE THE PERMISSION TO EDIT UTILITY METERS IN PROPERTY MANAGER USER *****************");
			test.log(LogStatus.INFO,
					"***************** VALIDATE THE PERMISSION TO EDIT UTILITY METERS IN PROPERTY MANAGER USER *****************");
			Reporter.log(
					"***************** VALIDATE THE PERMISSION TO EDIT UTILITY METERS IN PROPERTY MANAGER USER *****************");
			log.info(
					"***************** VALIDATE THE PERMISSION TO EDIT UTILITY METERS IN PROPERTY MANAGER USER *****************");

			try {

				// enter the property name in the search field
				clear("envreports_propertylist_filtertxt_CSS");
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

				// validate the add button of the utility meter
				try {
					boolean addBtn = driver
							.findElement(By.xpath(OR.getProperty("sustainability_utilitymeter_addbtn_XPATH")))
							.isDisplayed();

					if (addBtn == true) {

						verificationFailedMessage(
								"The add button of the utility meter is displayed without permission.");

					} else {
						successMessage("The add button of the utility meter is not displayed as expected.");
					}

				} catch (Throwable t) {
					successMessage("The add button of the utility meter is not displayed as expected.");

				}

				// click on the newly created utility meter record
				String UtilityMeter1 = "//td[text()='" + utilityMeter + "']";
				driver.findElement(By.xpath(UtilityMeter1)).click();
				ngDriver.waitForAngularRequestsToFinish();
				System.out.println("Clicked on the newly created meter record.");

				// validate the save button of the utility meter
				try {
					boolean saveBtn = driver
							.findElement(By.xpath(OR.getProperty("sustainability_utilitymeter_savebtn_XPATH")))
							.isDisplayed();

					if (saveBtn == true) {

						verificationFailedMessage(
								"The save button of the utility meter is displayed without permission.");

					} else {
						successMessage("The save button of the utility meter is not displayed as expected.");
					}

				} catch (Throwable t) {
					successMessage("The save button of the utility meter is not displayed as expected.");

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

			// LOGOUT FROM THE PROPERTY MANAGER USER AND LOGIN IN ADMIN USER

			System.out.println(
					"***************** LOGOUT FROM THE PROPERTY MANAGER USER AND LOGIN IN ADMIN USER *****************");
			test.log(LogStatus.INFO,
					"***************** LOGOUT FROM THE PROPERTY MANAGER USER AND LOGIN IN ADMIN USER *****************");
			Reporter.log(
					"***************** LOGOUT FROM THE PROPERTY MANAGER USER AND LOGIN IN ADMIN USER *****************");
			log.info(
					"***************** LOGOUT FROM THE PROPERTY MANAGER USER AND LOGIN IN ADMIN USER *****************");

			try {
				// wait for the element
				explicitWaitClickable("questionnaire_settingicon_CSS");

				// click on the settings icon from the top of the screen
				click("questionnaire_settingicon_CSS");
				System.out.println("Clicked on the settings icon.");
				ngDriver.waitForAngularRequestsToFinish();

				// wait for the element
				explicitWaitClickable("sidemenu_logout_CSS");

				// click on the logout option from the side menu
				click("sidemenu_logout_CSS");
				System.out.println("Clicked on the logout option from the side menu.");
				ngDriver.waitForAngularRequestsToFinish();

				helper.loginAndUpdateSystemCompany(data, "username_1", "password_1", "SystemCompany");

			} catch (Throwable t) {
				verificationFailed();
			}

		} catch (Throwable t) {
			helper.questionnaireNotDisplayLogout(data);
		}

		// click on the home icon from the top of the screen
		click("questionnaire_homeburgermenubtn_hide_CSS");
		System.out.println("Clicked on the home icon from the top of the screen.");
		ngDriver.waitForAngularRequestsToFinish();

		// synchronization
		explicitWait("propertylist_title_XPATH");

		// verify the property list
		switchVerification("propertylist_title_XPATH", "Property List", "The property list is not displayed.");

		// DELETE THE UPDATED UTILITY METER RECORD

		System.out.println("***************** DELETE THE UPDATED UTILITY METER RECORD *****************");
		test.log(LogStatus.INFO, "***************** DELETE THE UPDATED UTILITY METER RECORD *****************");
		Reporter.log("***************** DELETE THE UPDATED UTILITY METER RECORD *****************");
		log.info("***************** DELETE THE UPDATED UTILITY METER RECORD *****************");

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

			// click on the delete button
			String deletebtn = "//td[text()='" + utilityMeter
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

				String UtilityMeter = "//td[text()='" + utilityMeter + "']";
				String UtilityMeter_string = (driver.findElement(By.xpath(UtilityMeter)).getText()).trim();

				if (UtilityMeter_string.equals(utilityMeter)) {

					verificationFailedMessage("The utility meter is not deleted.");

				}
			} catch (Throwable t) {

				successMessage("The utility meter is deleted successfully.");

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

		// RESET THE APPLIED PERMISSION

		System.out.println("**************** RESET THE APPLIED PERMISSIONS ****************");
		test.log(LogStatus.INFO, "**************** RESET THE APPLIED PERMISSIONS ****************");
		Reporter.log("**************** RESET THE APPLIED PERMISSIONS ****************");
		log.info("**************** RESET THE APPLIED PERMISSIONS ****************");

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

			// click on the security tab
			click("questionnaire_securitytab_XPATH");
			System.out.println("Clicked on the security tab.");
			ngDriver.waitForAngularRequestsToFinish();

			// click on the security settings option
			click("questionnaire_securotysettingsoption_XPATH");
			System.out.println("Clicked on the security settings option.");
			ngDriver.waitForAngularRequestsToFinish();

			// enter security setting name in the search field
			clear("propertyproject_le_filtertxt_CSS");
			type("propertyproject_le_filtertxt_CSS", data.get("security_setting_1"));
			ngDriver.waitForAngularRequestsToFinish();
			System.out.println("Entered security setting name in the search field.");

			// click on the searched result
			click("sustainability_utilitybills_securitysettings10_XPATH");
			ngDriver.waitForAngularRequestsToFinish();
			System.out.println("Clicked on the searched result.");

			// click on the select role field
			click("propertyproject_securitysettings1_selectroles_CSS");
			ngDriver.waitForAngularRequestsToFinish();
			System.out.println("Clicked on the select role field.");

			// click on the none button
			click("propertyproject_securitysettings1_nonebtn_CSS");
			ngDriver.waitForAngularRequestsToFinish();
			System.out.println("Clicked on the none button.");

			// enter the name of the role in search field
			clear("propertyproject_securitysettings1_searchtxt_CSS");
			ngDriver.waitForAngularRequestsToFinish();
			System.out.println("Clear the search field.");
			type("propertyproject_securitysettings1_searchtxt_CSS", data.get("role_1"));
			ngDriver.waitForAngularRequestsToFinish();
			System.out.println("Entered the name of the role in search field.");

			// click on the searched result
			click("sustainability_utilitybills_searchedpm_XPATH");
			ngDriver.waitForAngularRequestsToFinish();
			System.out.println("Clicked on the searched result.");

			// click on the select role field
			click("propertyproject_securitysettings1_selectroles_CSS");
			ngDriver.waitForAngularRequestsToFinish();
			System.out.println("Clicked on the select role field.");

			// click on the save button
			click("propertyproject_securitysettings1_savebtn_CSS");
			ngDriver.waitForAngularRequestsToFinish();
			System.out.println("Clicked on the save button.");

			// wait for the element
			explicitWaitClickable("closetoastmsg_CSS");

			// click on the toaster close button
			click("closetoastmsg_CSS");
			ngDriver.waitForAngularRequestsToFinish();
			System.out.println("Clicked on the toaster close button.");

		} catch (Throwable t) {
			verificationFailed();
		}

		// click on the home icon
		click("questionnaire_homeburgermenubtn_CSS");
		ngDriver.waitForAngularRequestsToFinish();
		System.out.println("Clicked on the home icon.");

		// wait for the element
		explicitWait("propertylist_title_XPATH");

		// verify the property list
		switchVerification("propertylist_title_XPATH", "Property List", "The property list is not displayed.");

	}
}
