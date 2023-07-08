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
import org.testng.Reporter;
import org.testng.SkipException;
import org.testng.annotations.Test;

import com.relevantcodes.extentreports.LogStatus;

import base.Helper;
import base.TestBase;
import utilities.TestUtil;

public class RR6034Sustainability6Test extends TestBase {

	@Test(dataProviderClass = TestUtil.class, dataProvider = "dp")
	public void rR6034Sustainability6Test(Hashtable<String, String> data) throws IOException, InterruptedException {

		execution(data, "rR6034Sustainability6Test");

		// VALIDATE THE PERMISSION TO CREATE, READ, UPDATE AND DELETE OCCUPANCY DATA
		// SECURITY SETTINGS
		title("VALIDATE THE PERMISSION TO CREATE, READ, UPDATE AND DELETE OCCUPANCY DATA SECURITY SETTINGS");

		Helper helper = new Helper();

		// refresh the page
		driver.navigate().refresh();
		explicitWait("sustainabilityicon_CSS");
		driver.navigate().refresh();

		// UPDATE THE PERMISSION TO CREATE, READ, UPDATE AND DELETE OCCUPANCY DATA
		// SECURITY SETTINGS
		title("UPDATE THE PERMISSION TO CREATE, READ, UPDATE AND DELETE OCCUPANCY DATA SECURITY SETTINGS");

		try {

			// wait for the element
			explicitWaitClickable("questionnaire_settingicon_CSS");

			// click on the settings icon from the top of the screen
			click("questionnaire_settingicon_CSS");

			// wait for the element
			explicitWaitClickable("questionnaire_administrationoption_XPATH");

			// click on the Administration option from the side menu
			click("questionnaire_administrationoption_XPATH");

			// click on the security tab
			click("questionnaire_securitytab_XPATH");

			// click on the security settings option
			click("questionnaire_securotysettingsoption_XPATH");

			// RESET THE PERMISSION TO ADMINISTER GRESB FEATURE SECURITY SETTINGS
			helper.resetPermission(data, "security_setting_1", "sustainability_utilitybills_securitysettings6_XPATH");

		} catch (Throwable t) {
			verificationFailed();
		}

		// click on the home icon
		click("questionnaire_homeburgermenubtn_CSS");

		// wait for the element
		explicitWait("propertylist_title_XPATH");

		// verify the property list
		switchVerification("propertylist_title_XPATH", "Property List", "The property list is not displayed.");

		// CREATE NEW UTILITY BILLS RECORD - AT PROPERTY LEVEL
		title("CREATE NEW UTILITY BILLS RECORD - AT PROPERTY LEVEL");

		String utilityBills1 = RandomStringUtils.randomNumeric(8);
		Random random = new Random();
		int billCount = random.nextInt(4 - 2) + 2;

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
				type("sustainability_utilitybills_meternumber_XPATH", utilityBills1 + i);

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
				String random22 = RandomStringUtils.randomNumeric(6);
				type("sustainability_utilitybills_totalcost_XPATH", random22);

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

				// select the current year in the dropdown
				LocalDate today1 = LocalDate.now();
				String[] todayDate1 = today1.toString().split("-");
				select("sustainability_utilitybills_yearfilterdd_XPATH", todayDate1[0]);

				// select the all option from the meter filter
				select("sustainability_utilitybills_meterfilter_XPATH", "All");

				// ========= TEMPORARY CODE - ABOVE =========

				// click on the refresh button
				click("sustainability_utilitybills_refreshbtn_XPATH");

				// enter the newly created certification record in the search field
				type("sustainability_searchtxt_XPATH", utilityBills1 + i);

				// verify the newly created utility meter record
				try {
					String UtilityBills = "//td[contains(text(),'" + utilityBills1 + i + "')]";
					String addedUtilityBills = (driver.findElement(By.xpath(UtilityBills)).getText()).trim();
					if (addedUtilityBills.equals(utilityBills1 + i)) {
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
							+ utilityBills1 + i + "')]";
					String addedUtilityBills = (driver.findElement(By.xpath(MeterIndicatorRed)).getText()).trim();
					if (addedUtilityBills.equals(utilityBills1 + i)) {

						successMessage("The meter indicator of the utility bill is verified successfully.");

					} else {

						verificationFailedMessage("The meter indicator of the utility bill is not verified.");

					}
				} catch (Throwable t) {
					verificationFailed();
				}

				// click on the newly created utility bill record
				String redIndicator = "//td[contains(text(),'" + utilityBills1 + i
						+ "')]//i[@ng-click='goToAndCreateMeter(d.meterNumber)' and @class='icon-meter i-red']";
				driver.findElement(By.xpath(redIndicator)).click();

				// validate the meter number
				try {
					String meterValue = driver
							.findElement(By.xpath(OR.getProperty("sustainability_utilitymeter_metertxt_XPATH")))
							.getAttribute("value");
					if (meterValue.equals(utilityBills1 + i)) {
						successMessage("The utility meter is verified successfully.");
					} else {

						verificationFailedMessage("The utility meter is not verified.");
					}
				} catch (Throwable t) {
					verificationFailed();
				}

				// enter the details in the description field
				type("sustainability_utilitymeter_descriptiontxt_XPATH", data.get("description"));

				// scroll down the screen
				scrollByPixel(200);

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
				type("sustainability_searchtxt_XPATH", utilityBills1 + i);

				// verify the newly created utility meter record
				try {
					String UtilityBills = "//td[contains(text(),'" + utilityBills1 + i + "')]";
					String addedUtilityBills = (driver.findElement(By.xpath(UtilityBills)).getText()).trim();
					if (addedUtilityBills.equals(utilityBills1 + i)) {

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
							+ utilityBills1 + i + "')]";
					String addedUtilityBills1 = (driver.findElement(By.xpath(MeterIndicatorGreen)).getText()).trim();
					if (addedUtilityBills1.equals(utilityBills1 + i)) {

						successMessage("The meter indicator of the utility bill is verified successfully.");

					} else {

						verificationFailedMessage("The meter indicator of the utility bill is not verified.");

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

		// VALIDATE THE PERMISSION TO CREATE, READ, UPDATE AND DELETE OCCUPANCY DATA IN
		// ADMIN USER
		title("VALIDATE THE PERMISSION TO CREATE, READ, UPDATE AND DELETE OCCUPANCY DATA IN ADMIN USER");

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

			// click on the building performance data option
			click("sustainability_sidemenu_buildingperformancedataoption_XPATH");

			// click on the energy option
			click("sustainability_sidemenu_buildingperformancedataoption_energyoption_XPATH");

			// scroll down to the bottom of the screen
			scrollBottom();

			// wait for the element
			Thread.sleep(5000);

			// click on the occupancy icon - year
			click("sustainability_energydashboard_occupancyicon_XPATH");

			// wait for the element
			Thread.sleep(5000);

			// click on the occupancy icon - month
			click("sustainability_energydashboard_occupancyiconmonth_XPATH");

			// wait for the element
			Thread.sleep(5000);

			// validate the user able to update the occupancy
			try {
				boolean occupancyPercentage = driver
						.findElement(By.xpath(OR.getProperty(
								"sustainability_energydashboard_occupancyicon_occupancypercentagetxt_XPATH")))
						.isDisplayed();

				if (occupancyPercentage == true) {

					successMessage("The user able to update the occupancy details as expected.");

					// enter the occupancy percentage
					String occPer = RandomStringUtils.randomNumeric(2);
					type("sustainability_energydashboard_occupancyicon_occupancypercentagetxt_XPATH", occPer);

					// enter the average number of people
					String peoplenumber = RandomStringUtils.randomNumeric(3);
					type("sustainability_energydashboard_occupancyicon_numberofpeopletxt_XPATH", peoplenumber);

					// enter the average number of people
					type("sustainability_energydashboard_occupancyicon_occupancynotestxt_XPATH",
							data.get("occupancy_note"));

					// click on the save button
					click("sustainability_energydashboard_occupancyicon_savebtn_XPATH");

					// scroll down to the bottom of the screen
					scrollBottom();

					// validate the entered occupancy details are updated or not
					try {
						String actual_occPer = (driver
								.findElement(By.xpath(
										OR.getProperty("sustainability_energydashboard_occupancyiconmonth_XPATH")))
								.getText()).trim();
						if (actual_occPer.equals(occPer)) {

							successMessage("The user able to update the occupancy details.");

						} else {
							verificationFailedMessage("The updated occupancy details are not displayed.");
						}
					} catch (Throwable t) {
						verificationFailedMessage("The updated occupancy details are not displayed.");
					}

				} else {
					verificationFailedMessage("The user not able to update the occupancy details.");
				}
			} catch (Throwable t) {
				verificationFailedMessage("The user not able to update the occupancy details.");
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

		// LOGOUT FROM THE ADMIN USER AND LOGIN IN JINESH USER
		title("LOGOUT FROM THE ADMIN USER AND LOGIN IN JINESH USER");

		try {

			try {
				// wait for the element
				explicitWaitClickable("questionnaire_settingicon_CSS");

				// click on the settings icon from the top of the screen
				click("questionnaire_settingicon_CSS");

				// wait for the element
				explicitWaitClickable("sidemenu_logout_CSS");

				// click on the logout option from the side menu
				click("sidemenu_logout_CSS");

				helper.loginAndUpdateSystemCompany(data, "username", "password", "SystemCompany");

			} catch (Throwable t) {
				verificationFailed();
			}

			// VALIDATE THE PERMISSION TO CREATE, READ, UPDATE AND DELETE OCCUPANCY DATA IN
			// PROPERTY MANAGER USER
			title("VALIDATE THE PERMISSION TO CREATE, READ, UPDATE AND DELETE OCCUPANCY DATA IN PROPERTY MANAGER USER");

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

				// click on the building performance data option
				click("sustainability_sidemenu_buildingperformancedataoption_XPATH");

				// click on the energy option
				click("sustainability_sidemenu_buildingperformancedataoption_energyoption_XPATH");

				// scroll down to the bottom of the screen
				scrollBottom();

				// wait for the element
				Thread.sleep(5000);

				// click on the occupancy icon - year
				click("sustainability_energydashboard_occupancyicon_XPATH");

				// wait for the element
				Thread.sleep(5000);

				// click on the occupancy icon - month
				click("sustainability_energydashboard_occupancyiconmonth_XPATH");

				// wait for the element
				Thread.sleep(5000);

				// validate the user able to update the occupancy
				try {
					boolean occupancyPercentage = driver
							.findElement(By.xpath(OR.getProperty(
									"sustainability_energydashboard_occupancyicon_occupancypercentagetxt_XPATH")))
							.isDisplayed();

					if (occupancyPercentage == true) {

						verificationFailedMessage("The user able to update the occupancy details.");

					} else {

						successMessage("The user not able to update the occupancy details as expected.");

					}
				} catch (Throwable t) {
					successMessage("The user not able to update the occupancy details as expected.");

				}
			} catch (Throwable t) {
				verificationFailed();
			}

			// click on the close button
			click("sustainability_utilitybills_closebtn_occupancymodel_XPATH");

			// click on the home icon from the top of the screen
			click("questionnaire_homeburgermenubtn_hide_CSS");

			// synchronization
			explicitWait("propertylist_title_XPATH");

			// verify the property list
			switchVerification("propertylist_title_XPATH", "Property List", "The property list is not displayed.");

			// LOGOUT FROM THE PROPERTY MANAGER USER AND LOGIN IN ADMIN USER
			title("LOGOUT FROM THE PROPERTY MANAGER USER AND LOGIN IN ADMIN USER");

			try {
				// wait for the element
				explicitWaitClickable("questionnaire_settingicon_CSS");

				// click on the settings icon from the top of the screen
				click("questionnaire_settingicon_CSS");

				// wait for the element
				explicitWaitClickable("sidemenu_logout_CSS");

				// click on the logout option from the side menu
				click("sidemenu_logout_CSS");

				helper.loginAndUpdateSystemCompany(data, "username_1", "password_1", "SystemCompany");

			} catch (Throwable t) {
				verificationFailed();
			}

		} catch (Throwable t) {
			helper.questionnaireNotDisplayLogout(data);
		}

		// click on the home icon from the top of the screen
		click("questionnaire_homeburgermenubtn_hide_CSS");

		// synchronization
		explicitWait("propertylist_title_XPATH");

		// verify the property list
		switchVerification("propertylist_title_XPATH", "Property List", "The property list is not displayed.");

		// DELETE ALL THE NEWLY CREATAED UTILITY BILLS
		title("DELETE ALL THE NEWLY CREATAED UTILITY BILLS");

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
			LocalDate today1 = LocalDate.now();
			String[] todayDate1 = today1.toString().split("-");
			select("sustainability_utilitybills_yearfilterdd_XPATH", todayDate1[0]);

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

		// RESET THE APPLIED PERMISSION
		title("RESET THE APPLIED PERMISSION");

		try {
			// wait for the element
			explicitWaitClickable("questionnaire_settingicon_CSS");

			// click on the settings icon from the top of the screen
			click("questionnaire_settingicon_CSS");

			// wait for the element
			explicitWaitClickable("questionnaire_administrationoption_XPATH");

			// click on the Administration option from the side menu
			click("questionnaire_administrationoption_XPATH");

			// click on the security tab
			click("questionnaire_securitytab_XPATH");

			// click on the security settings option
			click("questionnaire_securotysettingsoption_XPATH");

			// enter security setting name in the search field
			type("propertyproject_le_filtertxt_CSS", data.get("security_setting_1"));

			// click on the searched result
			click("sustainability_utilitybills_securitysettings6_XPATH");

			// click on the select role field
			click("propertyproject_securitysettings1_selectroles_CSS");

			// click on the none button
			click("propertyproject_securitysettings1_nonebtn_CSS");

			// enter the name of the role in search field
			type("propertyproject_securitysettings1_searchtxt_CSS", data.get("role_1"));

			// click on the searched result
			click("sustainability_utilitybills_searchedpm_XPATH");

			// click on the select role field
			click("propertyproject_securitysettings1_selectroles_CSS");

			// click on the save button
			click("propertyproject_securitysettings1_savebtn_CSS");

			// wait for the element
			explicitWaitClickable("closetoastmsg_CSS");

			// click on the toaster close button
			click("closetoastmsg_CSS");

		} catch (Throwable t) {
			verificationFailed();
		}

		// click on the home icon
		click("questionnaire_homeburgermenubtn_CSS");

		// wait for the element
		explicitWait("propertylist_title_XPATH");

		// verify the property list
		switchVerification("propertylist_title_XPATH", "Property List", "The property list is not displayed.");

	}
}