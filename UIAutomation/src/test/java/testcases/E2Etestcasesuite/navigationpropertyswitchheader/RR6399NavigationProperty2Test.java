package testcases.E2Etestcasesuite.navigationpropertyswitchheader;

import java.io.IOException;
import java.time.LocalDate;
import java.util.Hashtable;
import java.util.List;

import org.apache.commons.lang3.RandomStringUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.Reporter;
import org.testng.annotations.Test;

import com.relevantcodes.extentreports.LogStatus;

import base.Helper;
import base.TestBase;
import utilities.TestUtil;

public class RR6399NavigationProperty2Test extends TestBase {

	@Test(dataProviderClass = TestUtil.class, dataProvider = "dp")
	public void rR6399NavigationProperty2Test(Hashtable<String, String> data) throws InterruptedException, IOException {

		execution(data, "rR6399NavigationProperty2Test");

		Helper helper = new Helper();

		// SUSTAINABILITY MODULE - NAVIGATION SCENARIO OF THE
		title("SUSTAINABILITY MODULE - NAVIGATION SCENARIO OF ");

		// refresh the page
		driver.navigate().refresh();
		Thread.sleep(5000);
		driver.navigate().refresh();

		// CREATE NEW DOCUMENTS/REPORTS RECORD - AT PROPERTY LEVEL
		title("CREATE NEW DOCUMENTS/REPORTS RECORD - AT PROPERTY LEVEL");

		try {
			// click on the Sustainability icon
			click("sustainabilityicon_CSS");

			// wait for the element
			Thread.sleep(5000);

			// click on the side menu
			click("ssc_leftsidemenubtn_CSS");

			// wait for the element
			Thread.sleep(5000);

			// click on the document/reports option
			click("sustainability_sidemenu_documentreportoption_XPATH");

			// click on the add button
			click("sustainability_addbtn_XPATH");

			// enter the document/report title
			type("sustainability_add_documentreporttitletxt_XPATH", data.get("documentreport_title"));

			// select the type from the dropdown
			select("sustainability_add_typedd_XPATH", data.get("type_document"));

			// click on the date field
			click("sustainability_add_datetxt_XPATH");

			// click on the today button
			click("sustainability_add_datetxt_todatbtn_XPATH");

			// enter the description
			type("sustainability_add_descriptiontxt_XPATH", data.get("description"));

			// click on the save button
			click("sustainability_add_savebtn_XPATH");

			// enter the newly created document/report record in the search field
			type("sustainability_searchtxt_XPATH", data.get("documentreport_title"));

			// verify the newly created document/report record displayed or not
			switchVerification("navigation_sustainabilitynavigation_addeddocumentrecord1_XPATH",
					"Test Document Sustainability Title 2",
					"The Test Document Sustainability Title 2 record is not displayed.");

		} catch (Throwable t) {
			verificationFailed();
		}

		// click on the home icon from the top of the screen
		click("questionnaire_homeburgermenubtn_hide_CSS");

		// synchronization
		explicitWait("propertylist_title_XPATH");

		// verify the property list
		switchVerification("propertylist_title_XPATH", "Property List", "The property list is not displayed.");

		// CREATE NEW CERTIFICATIONS RECORD - AT PROPERTY LEVEL
		title("CREATE NEW CERTIFICATIONS RECORD - AT PROPERTY LEVEL");

		String random1 = RandomStringUtils.randomAlphanumeric(8);
		String random2 = RandomStringUtils.randomAlphanumeric(8);

		try {

			// click on the Sustainability icon
			click("sustainabilityicon_CSS");

			// wait for the element
			Thread.sleep(5000);

			// click on the side menu
			click("ssc_leftsidemenubtn_CSS");

			// wait for the element
			Thread.sleep(5000);

			// click on the certifications option
			click("sustainability_sidemenu_certificationsoption_XPATH");

			// click on the add button
			click("sustainability_certification_addbtn_XPATH");

			// select the certification type from the dropdown
			select("sustainability_certification_certificationtype_XPATH", data.get("type"));

			// select the certification name from the dropdown
			select("sustainability_certification_certificationname_XPATH", data.get("name"));

			// select the certification sub type from the dropdown
			select("sustainability_certification_certificationsubtype_XPATH", data.get("sub_type"));

			// select the level of certification from the dropdown
			select("sustainability_certification_levelofcertification_XPATH", data.get("level"));

			// enter the certification score in the field
			type("sustainability_certification_certificationscore_XPATH", "5");

			// enter on the date of certification
			LocalDate date = LocalDate.now();
			String currentDate = date.toString();
			type("sustainability_certification_dateofcertification_XPATH", currentDate);

			// enter on the date of certification
			LocalDate date1 = LocalDate.now().plusDays(10);
			String futureDate1 = date1.toString();
			type("sustainability_certification_certificationexpiration_XPATH", futureDate1);

			// select the certification status from the dropdown
			select("sustainability_certification_certificationstatus_XPATH", data.get("status"));

			// enter the verification year
			type("sustainability_certification_verificationyear_XPATH", "2022");

			// select the Portfolio Program from the dropdown
			select("sustainability_certification_portfolioprogram_XPATH", data.get("portfolio_program"));

			// enter the Project ID in the field
			type("sustainability_certification_projectid_XPATH", random1);

			// enter the Building ID in the field
			type("sustainability_certification_buildingid_XPATH", random2);

			// click on the save button
			click("sustainability_certification_savebtn_XPATH");

			// wait for the element
			explicitWaitClickable("closetoastmsg_CSS");

			// click on the toaster close button
			click("closetoastmsg_CSS");

			// enter the newly created certification record in the search field
			type("sustainability_searchtxt_XPATH", data.get("type"));

			// verify the category of the newly created certification record
			switchVerification("sustainability_certification_addedcategory_XPATH", "Time of Design / Construction",
					"The Time of Design / Construction record is not displayed.");

			// verify the type of the newly created certification record
			switchVerification("sustainability_certification_addedtype_XPATH", "BOMA BEST",
					"The BOMA BEST record is not displayed.");

			// verify the level of the newly created certification record
			switchVerification("sustainability_certification_addedlevel_XPATH", "Certified",
					"The Certified record is not displayed.");

			// verify the status of the newly created certification record
			switchVerification("sustainability_certification_addedstatus_XPATH", "Pending",
					"The Pending record is not displayed.");

		} catch (Throwable t) {
			verificationFailed();
		}

		// click on the home icon from the top of the screen
		click("questionnaire_homeburgermenubtn_hide_CSS");

		// synchronization
		explicitWait("propertylist_title_XPATH");

		// verify the property list
		switchVerification("propertylist_title_XPATH", "Property List", "The property list is not displayed.");

		// CREATE NEW UTILITY METERS RECORD - AT PROPERTY LEVEL
		title("CREATE NEW UTILITY METERS RECORD - AT PROPERTY LEVEL");

		String utilityMeter = RandomStringUtils.randomAlphabetic(8);

		try {

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
			type("sustainability_utilitymeter_metertxt_XPATH", utilityMeter);

			// enter the details in the description field
			type("sustainability_utilitymeter_descriptiontxt_XPATH", data.get("description_meter"));

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
			consoleMessage("Entered the details in the Date Installed field.");

			// enter the details in the Date Activated field
			LocalDate addCurrentDate2 = LocalDate.now();
			String addCurrentDate2_String = addCurrentDate2.toString();
			type("sustainability_utilitymeter_dateactivated_XPATH", addCurrentDate2_String);
			consoleMessage("Entered the details in the Date Activated field.");

			// enter the details in the Date Deactivated field
			LocalDate addFutureDate1 = LocalDate.now().plusMonths(6);
			String addFutureDate1_String = addFutureDate1.toString();
			type("sustainability_utilitymeter_datedeactivated_XPATH", addFutureDate1_String);
			consoleMessage("Entered the details in the Date Deactivated field.");

			// click on the save button
			click("sustainability_utilitymeter_savebtn_XPATH");

			// wait for the element
			explicitWaitClickable("closetoastmsg_CSS");

			// click on the toaster close button
			click("closetoastmsg_CSS");

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

		// synchronization
		explicitWait("propertylist_title_XPATH");

		// verify the property list
		switchVerification("propertylist_title_XPATH", "Property List", "The property list is not displayed.");

		// CREATE NEW UTILITY BILLS RECORD - AT PROPERTY LEVEL
		title("CREATE NEW UTILITY BILLS RECORD - AT PROPERTY LEVEL");

		String utilityBills = RandomStringUtils.randomNumeric(8);

		try {

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
			String random3 = RandomStringUtils.randomNumeric(2);
			type("sustainability_utilitybills_consumption_XPATH", random3);

			// enter details in the Adjusted Consumption field
			type("sustainability_utilitybills_adjustedconsumption_XPATH", "0");

			// select the Unit of Measure option from the dropdown
			select("sustainability_utilitybills_unitofmeasure_XPATH", data.get("unit_measurement"));

			// enter details in the Peak Demand field
			type("sustainability_utilitybills_peakdemand_XPATH", "10");

			// select the Peak Demand Unit of Measure option from the dropdown
			select("sustainability_utilitybills_peakdemandunitofmeasure_XPATH", data.get("unit_measurement"));

			// enter details in the Total Cost field
			type("sustainability_utilitybills_totalcost_XPATH", "100");

			// enter details in the Reference Number field
			String random33 = RandomStringUtils.randomNumeric(8);
			type("sustainability_utilitybills_referencenumber_XPATH", random33);

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

		// click on the home icon from the top of the screen
		click("questionnaire_homeburgermenubtn_hide_CSS");

		// synchronization
		explicitWait("propertylist_title_XPATH");

		// verify the property list
		switchVerification("propertylist_title_XPATH", "Property List", "The property list is not displayed.");

		// VALIDATE THE NAVIGATION AFTER SWITCHING THE PROPERTY FROM THE HEADER OF
		// THE DOCUMENTS/REPORTS SCREENS
		title("VALIDATE THE NAVIGATION AFTER SWITCHING THE PROPERTY FROM THE HEADER OF THE DOCUMENTS/REPORTS SCREENS");

		try {
			// click on the Sustainability icon
			click("sustainabilityicon_CSS");

			// wait for the element
			Thread.sleep(5000);

			// click on the side menu
			click("ssc_leftsidemenubtn_CSS");

			// wait for the element
			Thread.sleep(5000);

			// click on the document/reports option
			click("sustainability_sidemenu_documentreportoption_XPATH");

			// enter the newly created document/report record in the search field
			type("sustainability_searchtxt_XPATH", data.get("documentreport_title"));

			// click on the newly created document/report record
			click("navigation_sustainabilitynavigation_addeddocumentrecord1_XPATH");

			// VALIDATE FOR PROPERTY ONE
			title("VALIDATE FOR PROPERTY ONE");

			// validate the property name
			switchVerification("navigation_header_propertyname1_XPATH", "[DND] AAAA Risk Test Prop 01 - 01",
					"The property name is not displayed.");

			// validate the title of the document/report record is displayed selected or not
			try {

				String title_actual = driver
						.findElement(By.xpath(OR.getProperty("sustainability_add_documentreporttitletxt_XPATH")))
						.getAttribute("value");

				if (title_actual.equals(data.get("documentreport_title"))) {
					successMessage("The title of the document/report is display successfully.");

				} else {
					verificationFailedMessage("The title of the document/report is not display.");

				}
			} catch (Throwable t) {
				verificationFailedMessage("The title of the document/report is not display.");
			}

			// VALIDATE FOR PROPERTY TWO
			title("VALIDATE FOR PROPERTY TWO");

			// wait for the element
			explicitWaitClickable("navigation_header_searchicon_XPATH");

			// click on the search icon from the header
			click("navigation_header_searchicon_XPATH");

			// enter property 2 number in text field
			type("navigation_header_searchtxt_XPATH", "02");

			// hit enter key
			driver.findElement(By.xpath(OR.getProperty("navigation_header_searchtxt_XPATH"))).sendKeys(Keys.ENTER);
			consoleMessage("Hit enter key.");

			// wait for the element
			Thread.sleep(2000);

			// click on the settings icon from the top of the screen
			click("questionnaire_settingicon_CSS");

			// wait for the element
			Thread.sleep(1000);

			// click on the cancel icon
			click("questionnaire_setting_cancelicon_XPATH");

			// validate the property name
			switchVerification("navigation_header_propertyname2_XPATH", "[DND] AAAA Risk Test Prop 02 - 02",
					"The property name is not displayed.");

			// validate the title of the document/report record is displayed selected or not
			try {

				String title_actual = driver
						.findElement(By.xpath(OR.getProperty("sustainability_add_documentreporttitletxt_XPATH")))
						.getAttribute("value");

				if (title_actual.equals(data.get("documentreport_title"))) {
					verificationFailedMessage("The title of the document/report is display.");

				} else {
					successMessage("The title of the document/report is not display as expected.");

				}
			} catch (Throwable t) {
				successMessage("The title of the document/report is not display as expected.");
			}

			// validate the title of the document/report in the listing screen is
			// displayed selected or not
			try {
				String titlelist = "//td[text()='" + data.get("documentreport_title") + "']";
				boolean titlelist_actual = driver.findElement(By.xpath(titlelist)).isDisplayed();

				if (titlelist_actual == true) {
					verificationFailedMessage("The newly created document/report is display.");

				} else {
					successMessage("The newly created document/report is not display successfully.");

				}
			} catch (Throwable t) {
				successMessage("The newly created document/report is not display successfully.");
			}

			// VALIDATE FOR PROPERTY THREE
			title("VALIDATE FOR PROPERTY THREE");

			// wait for the element
			explicitWaitClickable("navigation_header_searchicon_XPATH");

			// click on the search icon from the header
			click("navigation_header_searchicon_XPATH");

			// enter property 3 number in text field
			type("navigation_header_searchtxt_XPATH", "03");

			// hit enter key
			driver.findElement(By.xpath(OR.getProperty("navigation_header_searchtxt_XPATH"))).sendKeys(Keys.ENTER);
			consoleMessage("Hit enter key.");

			// wait for the element
			Thread.sleep(2000);

			// click on the settings icon from the top of the screen
			click("questionnaire_settingicon_CSS");

			// wait for the element
			Thread.sleep(1000);

			// click on the cancel icon
			click("questionnaire_setting_cancelicon_XPATH");

			// validate the property name
			switchVerification("navigation_header_propertyname3_XPATH", "[DND] AAAA Risk Test Prop 03 - 03",
					"The property name is not displayed.");

			// validate the title of the document/report record is displayed selected or not
			try {

				String title_actual = driver
						.findElement(By.xpath(OR.getProperty("sustainability_add_documentreporttitletxt_XPATH")))
						.getAttribute("value");

				if (title_actual.equals(data.get("documentreport_title"))) {
					verificationFailedMessage("The title of the document/report is display.");

				} else {
					successMessage("The title of the document/report is not display as expected.");

				}
			} catch (Throwable t) {
				successMessage("The title of the document/report is not display as expected.");
			}

			// validate the title of the document/report in the listing screen is
			// displayed selected or not
			try {
				String titlelist = "//td[text()='" + data.get("documentreport_title") + "']";
				boolean titlelist_actual = driver.findElement(By.xpath(titlelist)).isDisplayed();

				if (titlelist_actual == true) {
					verificationFailedMessage("The newly created document/report is display.");

				} else {
					successMessage("The newly created document/report is not display successfully.");

				}
			} catch (Throwable t) {
				successMessage("The newly created document/report is not display successfully.");
			}

			// VALIDATE FOR PROPERTY ONE
			title("VALIDATE FOR PROPERTY ONE");

			// wait for the element
			explicitWaitClickable("navigation_header_searchicon_XPATH");

			// click on the search icon from the header
			click("navigation_header_searchicon_XPATH");

			// enter property number in text field
			type("navigation_header_searchtxt_XPATH", "01");

			// hit enter key
			driver.findElement(By.xpath(OR.getProperty("navigation_header_searchtxt_XPATH"))).sendKeys(Keys.ENTER);
			consoleMessage("Hit enter key.");

			// validate the property name
			switchVerification("navigation_header_propertyname1_XPATH", "[DND] AAAA Risk Test Prop 01 - 01",
					"The property name is not displayed.");

			// validate the title of the document/report record is displayed selected or not
			try {

				String title_actual = driver
						.findElement(By.xpath(OR.getProperty("sustainability_add_documentreporttitletxt_XPATH")))
						.getAttribute("value");

				if (title_actual.equals(data.get("documentreport_title"))) {
					verificationFailedMessage("The title of the document/report is display.");

				} else {
					successMessage("The title of the document/report is not display as expected.");

				}
			} catch (Throwable t) {
				successMessage("The title of the document/report is not display as expected.");
			}

			// validate the title of the document/report in the listing screen is
			// displayed selected or not
			try {
				String titlelist = "//td[text()='" + data.get("documentreport_title") + "']";
				boolean titlelist_actual = driver.findElement(By.xpath(titlelist)).isDisplayed();

				if (titlelist_actual == true) {
					successMessage("The newly created document/report is display successfully.");

				} else {
					verificationFailedMessage("The newly created document/report is not display.");

				}
			} catch (Throwable t) {
				verificationFailedMessage("The newly created document/report is not display.");
			}

		} catch (Throwable t) {
			verificationFailed();
		}

		// click on the home icon from the top of the screen
		click("questionnaire_homeburgermenubtn_hide_CSS");

		// wait for the element
		explicitWait("propertylist_title_XPATH");

		// verify the property list
		switchVerification("propertylist_title_XPATH", "Property List", "The property list is not displayed.");

		// VALIDATE THE NAVIGATION AFTER SWITCHING THE PROPERTY FROM THE HEADER OF
		// THE CERTIFICATIONS SCREENS
		title("VALIDATE THE NAVIGATION AFTER SWITCHING THE PROPERTY FROM THE HEADER OF THE CERTIFICATIONS SCREENS");

		try {

			// click on the Sustainability icon
			click("sustainabilityicon_CSS");

			// wait for the element
			Thread.sleep(5000);

			// click on the side menu
			click("ssc_leftsidemenubtn_CSS");

			// wait for the element
			Thread.sleep(5000);

			// click on the certifications option
			click("sustainability_sidemenu_certificationsoption_XPATH");

			// enter the newly created certification record in the search field
			type("sustainability_searchtxt_XPATH", data.get("type"));

			// click on the type of the newly created certification record
			click("sustainability_certification_addedtype_XPATH");

			// VALIDATE FOR PROPERTY ONE
			title("VALIDATE FOR PROPERTY ONE");

			// validate the property name
			switchVerification("navigation_header_propertyname1_XPATH", "[DND] AAAA Risk Test Prop 01 - 01",
					"The property name is not displayed.");

			// scroll down
			scrollBottom();

			// validate the certificate record is displayed selected or not
			try {

				String propertyid1_actual = driver
						.findElement(By.xpath(OR.getProperty("sustainability_certification_projectid_XPATH")))
						.getAttribute("value");

				if (propertyid1_actual.equals(random1)) {
					successMessage("The type of the certificate is display successfully.");

				} else {
					verificationFailedMessage("The type of the certificate is not display.");

				}
			} catch (Throwable t) {
				verificationFailedMessage("The type of the certificate is not display.");
			}

			// VALIDATE FOR PROPERTY TWO
			title("VALIDATE FOR PROPERTY TWO");

			// wait for the element
			explicitWaitClickable("navigation_header_searchicon_XPATH");

			// click on the search icon from the header
			click("navigation_header_searchicon_XPATH");

			// enter property 2 number in text field
			type("navigation_header_searchtxt_XPATH", "02");

			// hit enter key
			driver.findElement(By.xpath(OR.getProperty("navigation_header_searchtxt_XPATH"))).sendKeys(Keys.ENTER);
			consoleMessage("Hit enter key.");

			// wait for the element
			Thread.sleep(2000);

			// click on the settings icon from the top of the screen
			click("questionnaire_settingicon_CSS");

			// wait for the element
			Thread.sleep(1000);

			// click on the cancel icon
			click("questionnaire_setting_cancelicon_XPATH");

			// validate the property name
			switchVerification("navigation_header_propertyname2_XPATH", "[DND] AAAA Risk Test Prop 02 - 02",
					"The property name is not displayed.");

			// validate the title of the certificate in the listing screen is
			// displayed selected or not
			try {
				String titlelist = "//td[text()='" + data.get("type") + "']";
				boolean titlelist_actual = driver.findElement(By.xpath(titlelist)).isDisplayed();

				if (titlelist_actual == true) {
					verificationFailedMessage("The newly created certificate is display.");

				} else {
					successMessage("The newly created certificate is not display successfully.");

				}
			} catch (Throwable t) {
				successMessage("The newly created certificate is not display successfully.");
			}

			// VALIDATE FOR PROPERTY THREE
			title("VALIDATE FOR PROPERTY THREE");

			// wait for the element
			explicitWaitClickable("navigation_header_searchicon_XPATH");

			// click on the search icon from the header
			click("navigation_header_searchicon_XPATH");

			// enter property 3 number in text field
			type("navigation_header_searchtxt_XPATH", "03");

			// hit enter key
			driver.findElement(By.xpath(OR.getProperty("navigation_header_searchtxt_XPATH"))).sendKeys(Keys.ENTER);
			consoleMessage("Hit enter key.");

			// wait for the element
			Thread.sleep(2000);

			// click on the settings icon from the top of the screen
			click("questionnaire_settingicon_CSS");

			// wait for the element
			Thread.sleep(1000);

			// click on the cancel icon
			click("questionnaire_setting_cancelicon_XPATH");

			// validate the property name
			switchVerification("navigation_header_propertyname3_XPATH", "[DND] AAAA Risk Test Prop 03 - 03",
					"The property name is not displayed.");

			// validate the title of the certificate in the listing screen is
			// displayed selected or not
			try {
				String titlelist = "//td[text()='" + data.get("type") + "']";
				boolean titlelist_actual = driver.findElement(By.xpath(titlelist)).isDisplayed();

				if (titlelist_actual == true) {
					verificationFailedMessage("The newly created certificate is display.");

				} else {
					successMessage("The newly created certificate is not display successfully.");

				}
			} catch (Throwable t) {
				successMessage("The newly created certificate is not display successfully.");
			}

			// VALIDATE FOR PROPERTY ONE
			title("VALIDATE FOR PROPERTY ONE");

			// wait for the element
			explicitWaitClickable("navigation_header_searchicon_XPATH");

			// click on the search icon from the header
			click("navigation_header_searchicon_XPATH");

			// enter property number in text field
			type("navigation_header_searchtxt_XPATH", "01");

			// hit enter key
			driver.findElement(By.xpath(OR.getProperty("navigation_header_searchtxt_XPATH"))).sendKeys(Keys.ENTER);
			consoleMessage("Hit enter key.");

			// validate the property name
			switchVerification("navigation_header_propertyname1_XPATH", "[DND] AAAA Risk Test Prop 01 - 01",
					"The property name is not displayed.");

			// validate the title of the certificate in the listing screen is
			// displayed selected or not
			try {
				String titlelist = "//td[text()='" + data.get("type") + "']";
				boolean titlelist_actual = driver.findElement(By.xpath(titlelist)).isDisplayed();

				if (titlelist_actual == true) {
					successMessage("The newly created certificate is display successfully.");

				} else {
					verificationFailedMessage("The newly created certificate is not display.");

				}
			} catch (Throwable t) {
				verificationFailedMessage("The newly created certificate is not display.");
			}

		} catch (Throwable t) {
			verificationFailed();
		}

		// click on the home icon from the top of the screen
		click("questionnaire_homeburgermenubtn_hide_CSS");

		// wait for the element
		explicitWait("propertylist_title_XPATH");

		// verify the property list
		switchVerification("propertylist_title_XPATH", "Property List", "The property list is not displayed.");

		// VALIDATE THE NAVIGATION AFTER SWITCHING THE PROPERTY FROM THE HEADER OF
		// THE UTILITY METER SCREENS
		title("VALIDATE THE NAVIGATION AFTER SWITCHING THE PROPERTY FROM THE HEADER OF THE UTILITY METER SCREENS");

		try {

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

			// click on the newly created utility meter
			String UtilityMeter = "//td[text()='" + utilityMeter + "']";
			driver.findElement(By.xpath(UtilityMeter)).click();
			consoleMessage("Clicked on the newly created utility meter.");

			// click on the details tab
			click("navigation_sustainability_utilitymeter_detailstab_XPATH");

			// VALIDATE FOR PROPERTY ONE
			title("VALIDATE FOR PROPERTY ONE");

			// validate the property name
			switchVerification("navigation_header_propertyname1_XPATH", "[DND] AAAA Risk Test Prop 01 - 01",
					"The property name is not displayed.");

			// validate the meter number is displayed selected or not
			try {

				String meternumber_actual = driver
						.findElement(By.xpath(OR.getProperty("sustainability_utilitymeter_metertxt_XPATH")))
						.getAttribute("value");

				if (meternumber_actual.equals(utilityMeter)) {
					successMessage("The meter number is display successfully.");

				} else {
					verificationFailedMessage("The meter number is not display.");

				}
			} catch (Throwable t) {
				verificationFailedMessage("The meter number is not display.");
			}

			// VALIDATE FOR PROPERTY TWO
			title("VALIDATE FOR PROPERTY TWO");

			// wait for the element
			explicitWaitClickable("navigation_header_searchicon_XPATH");

			// click on the search icon from the header
			click("navigation_header_searchicon_XPATH");

			// enter property 2 number in text field
			type("navigation_header_searchtxt_XPATH", "02");

			// hit enter key
			driver.findElement(By.xpath(OR.getProperty("navigation_header_searchtxt_XPATH"))).sendKeys(Keys.ENTER);
			consoleMessage("Hit enter key.");

			// wait for the element
			Thread.sleep(2000);

			// click on the settings icon from the top of the screen
			click("questionnaire_settingicon_CSS");

			// wait for the element
			Thread.sleep(1000);

			// click on the cancel icon
			click("questionnaire_setting_cancelicon_XPATH");

			// validate the property name
			switchVerification("navigation_header_propertyname2_XPATH", "[DND] AAAA Risk Test Prop 02 - 02",
					"The property name is not displayed.");

			// validate the meter number is displayed selected or not
			try {

				String meternumber_actual = driver
						.findElement(By.xpath(OR.getProperty("sustainability_utilitymeter_metertxt_XPATH")))
						.getAttribute("value");

				if (meternumber_actual.equals(utilityMeter)) {
					verificationFailedMessage("The meter number is display.");

				} else {
					successMessage("The meter number is not display as expected.");

				}
			} catch (Throwable t) {
				successMessage("The meter number is not display as expected.");
			}

			// validate the title of the meter number in the listing screen is
			// displayed selected or not
			try {
				String meternumberlist = "//td[contains(text(),'" + utilityMeter + "')]";
				boolean meternumberlist_actual = driver.findElement(By.xpath(meternumberlist)).isDisplayed();

				if (meternumberlist_actual == true) {
					verificationFailedMessage("The newly created meter number is display.");

				} else {
					successMessage("The newly created meter number is not display.");

				}
			} catch (Throwable t) {
				successMessage("The newly created meter number is not display.");
			}

			// VALIDATE FOR PROPERTY THREE
			title("VALIDATE FOR PROPERTY THREE");

			// wait for the element
			explicitWaitClickable("navigation_header_searchicon_XPATH");

			// click on the search icon from the header
			click("navigation_header_searchicon_XPATH");

			// enter property 3 number in text field
			type("navigation_header_searchtxt_XPATH", "03");

			// hit enter key
			driver.findElement(By.xpath(OR.getProperty("navigation_header_searchtxt_XPATH"))).sendKeys(Keys.ENTER);
			consoleMessage("Hit enter key.");

			// wait for the element
			Thread.sleep(2000);

			// click on the settings icon from the top of the screen
			click("questionnaire_settingicon_CSS");

			// wait for the element
			Thread.sleep(1000);

			// click on the cancel icon
			click("questionnaire_setting_cancelicon_XPATH");

			// validate the property name
			switchVerification("navigation_header_propertyname3_XPATH", "[DND] AAAA Risk Test Prop 03 - 03",
					"The property name is not displayed.");

			// validate the meter number is displayed selected or not
			try {

				String meternumber_actual = driver
						.findElement(By.xpath(OR.getProperty("sustainability_utilitymeter_metertxt_XPATH")))
						.getAttribute("value");

				if (meternumber_actual.equals(utilityMeter)) {
					verificationFailedMessage("The meter number is display.");

				} else {
					successMessage("The meter number is not display as expected.");

				}
			} catch (Throwable t) {
				successMessage("The meter number is not display as expected.");
			}

			// validate the title of the meter number in the listing screen is
			// displayed selected or not
			try {
				String meternumberlist = "//td[contains(text(),'" + utilityMeter + "')]";
				boolean meternumberlist_actual = driver.findElement(By.xpath(meternumberlist)).isDisplayed();

				if (meternumberlist_actual == true) {
					verificationFailedMessage("The newly created meter number is display.");

				} else {
					successMessage("The newly created meter number is not display.");

				}
			} catch (Throwable t) {
				successMessage("The newly created meter number is not display.");
			}

			// VALIDATE FOR PROPERTY ONE
			title("VALIDATE FOR PROPERTY ONE");

			// wait for the element
			explicitWaitClickable("navigation_header_searchicon_XPATH");

			// click on the search icon from the header
			click("navigation_header_searchicon_XPATH");

			// enter property number in text field
			type("navigation_header_searchtxt_XPATH", "01");

			// hit enter key
			driver.findElement(By.xpath(OR.getProperty("navigation_header_searchtxt_XPATH"))).sendKeys(Keys.ENTER);
			consoleMessage("Hit enter key.");

			// validate the property name
			switchVerification("navigation_header_propertyname1_XPATH", "[DND] AAAA Risk Test Prop 01 - 01",
					"The property name is not displayed.");

			// validate the meter number is displayed selected or not
			try {

				String meternumber_actual = driver
						.findElement(By.xpath(OR.getProperty("sustainability_utilitymeter_metertxt_XPATH")))
						.getAttribute("value");

				if (meternumber_actual.equals(utilityMeter)) {
					verificationFailedMessage("The meter number is display.");

				} else {
					successMessage("The meter number is not display as expected.");

				}
			} catch (Throwable t) {
				successMessage("The meter number is not display as expected.");
			}

			// validate the title of the meter number in the listing screen is
			// displayed selected or not
			try {
				String meternumberlist = "//td[contains(text(),'" + utilityMeter + "')]";
				boolean meternumberlist_actual = driver.findElement(By.xpath(meternumberlist)).isDisplayed();

				if (meternumberlist_actual == true) {
					successMessage("The newly created meter number is display as expected.");

				} else {
					verificationFailedMessage("The newly created meter number is not display.");

				}
			} catch (Throwable t) {
				verificationFailedMessage("The newly created meter number is not display.");
			}

		} catch (Throwable t) {
			verificationFailed();
		}

		// click on the home icon from the top of the screen
		click("questionnaire_homeburgermenubtn_hide_CSS");

		// wait for the element
		explicitWait("propertylist_title_XPATH");

		// verify the property list
		switchVerification("propertylist_title_XPATH", "Property List", "The property list is not displayed.");

		// VALIDATE THE NAVIGATION AFTER SWITCHING THE PROPERTY FROM THE HEADER OF
		// THE UTILITY BILL SCREENS
		title("VALIDATE THE NAVIGATION AFTER SWITCHING THE PROPERTY FROM THE HEADER OF THE UTILITY BILL SCREENS");

		try {

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

			// enter the newly created certification record in the search field
			type("sustainability_searchtxt_XPATH", utilityBills);

			// click on the newly created utility bills
			String UtilityBills = "//td[contains(text(),'" + utilityBills + "')]";
			driver.findElement(By.xpath(UtilityBills)).click();
			consoleMessage("click on the newly created utility bills");

			// VALIDATE FOR PROPERTY ONE
			title("VALIDATE FOR PROPERTY ONE");

			// validate the property name
			switchVerification("navigation_header_propertyname1_XPATH", "[DND] AAAA Risk Test Prop 01 - 01",
					"The property name is not displayed.");

			// validate the meter number is displayed selected or not
			try {

				String meternumber_actual = driver
						.findElement(By.xpath(OR.getProperty("sustainability_utilitybills_meternumber_XPATH")))
						.getAttribute("value");

				if (meternumber_actual.equals(utilityBills)) {
					successMessage("The meter is display successfully.");

				} else {
					verificationFailedMessage("The meter number is not display.");

				}
			} catch (Throwable t) {
				verificationFailedMessage("The meter number is not display.");
			}

			// VALIDATE FOR PROPERTY TWO
			title("VALIDATE FOR PROPERTY TWO");

			// wait for the element
			explicitWaitClickable("navigation_header_searchicon_XPATH");

			// click on the search icon from the header
			click("navigation_header_searchicon_XPATH");

			// enter property 2 number in text field
			type("navigation_header_searchtxt_XPATH", "02");

			// hit enter key
			driver.findElement(By.xpath(OR.getProperty("navigation_header_searchtxt_XPATH"))).sendKeys(Keys.ENTER);
			consoleMessage("Hit enter key.");

			// wait for the element
			Thread.sleep(2000);

			// click on the settings icon from the top of the screen
			click("questionnaire_settingicon_CSS");

			// wait for the element
			Thread.sleep(1000);

			// click on the cancel icon
			click("questionnaire_setting_cancelicon_XPATH");

			// validate the property name
			switchVerification("navigation_header_propertyname2_XPATH", "[DND] AAAA Risk Test Prop 02 - 02",
					"The property name is not displayed.");

			// validate the meter number is displayed selected or not
			try {

				String meternumber_actual = driver
						.findElement(By.xpath(OR.getProperty("sustainability_utilitybills_meternumber_XPATH")))
						.getAttribute("value");

				if (meternumber_actual.equals(utilityMeter)) {
					verificationFailedMessage("The meter number is display.");

				} else {
					successMessage("The meter number is not display as expected.");

				}
			} catch (Throwable t) {
				successMessage("The meter number is not display as expected.");
			}

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

			// validate the meter number in the listing screen is
			// displayed selected or not
			try {
				String meternumberlist = "//td[contains(text(),'" + utilityMeter + "')]";
				boolean meternumberlist_actual = driver.findElement(By.xpath(meternumberlist)).isDisplayed();

				if (meternumberlist_actual == true) {
					verificationFailedMessage("The newly created meter number is display.");

				} else {
					successMessage("The newly created meter number is not display.");

				}
			} catch (Throwable t) {
				successMessage("The newly created meter number is not display.");
			}

			// VALIDATE FOR PROPERTY THREE
			title("VALIDATE FOR PROPERTY THREE");

			// wait for the element
			explicitWaitClickable("navigation_header_searchicon_XPATH");

			// click on the search icon from the header
			click("navigation_header_searchicon_XPATH");

			// enter property 3 number in text field
			type("navigation_header_searchtxt_XPATH", "03");

			// hit enter key
			driver.findElement(By.xpath(OR.getProperty("navigation_header_searchtxt_XPATH"))).sendKeys(Keys.ENTER);
			consoleMessage("Hit enter key.");

			// wait for the element
			Thread.sleep(2000);

			// click on the settings icon from the top of the screen
			click("questionnaire_settingicon_CSS");

			// wait for the element
			Thread.sleep(1000);

			// click on the cancel icon
			click("questionnaire_setting_cancelicon_XPATH");

			// validate the property name
			switchVerification("navigation_header_propertyname3_XPATH", "[DND] AAAA Risk Test Prop 03 - 03",
					"The property name is not displayed.");

			// validate the meter number is displayed selected or not
			try {

				String meternumber_actual = driver
						.findElement(By.xpath(OR.getProperty("sustainability_utilitybills_meternumber_XPATH")))
						.getAttribute("value");

				if (meternumber_actual.equals(utilityMeter)) {
					verificationFailedMessage("The meter number is display.");

				} else {
					successMessage("The meter number is not display as expected.");

				}
			} catch (Throwable t) {
				successMessage("The meter number is not display as expected.");
			}

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

			// validate the meter number in the listing screen is
			// displayed selected or not
			try {
				String meternumberlist = "//td[contains(text(),'" + utilityMeter + "')]";
				boolean meternumberlist_actual = driver.findElement(By.xpath(meternumberlist)).isDisplayed();

				if (meternumberlist_actual == true) {
					verificationFailedMessage("The newly created meter number is display.");

				} else {
					successMessage("The newly created meter number is not display.");

				}
			} catch (Throwable t) {
				successMessage("The newly created meter number is not display.");
			}

			// VALIDATE FOR PROPERTY ONE
			title("VALIDATE FOR PROPERTY ONE");

			// wait for the element
			explicitWaitClickable("navigation_header_searchicon_XPATH");

			// click on the search icon from the header
			click("navigation_header_searchicon_XPATH");

			// enter property number in text field
			type("navigation_header_searchtxt_XPATH", "01");

			// hit enter key
			driver.findElement(By.xpath(OR.getProperty("navigation_header_searchtxt_XPATH"))).sendKeys(Keys.ENTER);
			consoleMessage("Hit enter key.");

			// validate the property name
			switchVerification("navigation_header_propertyname1_XPATH", "[DND] AAAA Risk Test Prop 01 - 01",
					"The property name is not displayed.");

			// validate the meter number is displayed selected or not
			try {

				String meternumber_actual = driver
						.findElement(By.xpath(OR.getProperty("sustainability_utilitybills_meternumber_XPATH")))
						.getAttribute("value");

				if (meternumber_actual.equals(utilityMeter)) {
					verificationFailedMessage("The meter number is display.");

				} else {
					successMessage("The meter number is not display as expected.");

				}
			} catch (Throwable t) {
				successMessage("The meter number is not display as expected.");
			}

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

			// validate the meter number in the listing screen is
			// displayed selected or not
			try {
				String meternumberlist = "//td[contains(text(),'" + utilityMeter + "')]";
				boolean meternumberlist_actual = driver.findElement(By.xpath(meternumberlist)).isDisplayed();

				if (meternumberlist_actual == true) {
					successMessage("The newly created meter number is display successfully.");

				} else {
					verificationFailedMessage("The newly created meter number is not display.");

				}
			} catch (Throwable t) {
				verificationFailedMessage("The newly created meter number is not display.");
			}

		} catch (Throwable t) {
			verificationFailed();
		}

		// click on the home icon from the top of the screen
		click("questionnaire_homeburgermenubtn_hide_CSS");

		// wait for the element
		explicitWait("propertylist_title_XPATH");

		// verify the property list
		switchVerification("propertylist_title_XPATH", "Property List", "The property list is not displayed.");

		// VALIDATE THE NAVIGATION AFTER SWITCHING THE PROPERTY FROM THE HEADER OF
		// THE METER DETAILS SCREEN OF THE UTILITY BILL
		title("VALIDATE THE NAVIGATION AFTER SWITCHING THE PROPERTY FROM THE METER DETAILS SCREEN OF THE UTILITY BILL");

		try {

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

			// enter the newly created certification record in the search field
			type("sustainability_searchtxt_XPATH", utilityBills);

			// click on the meter icon
			click("sustainability_utilitybills_meterredindicator_XPATH");

			// VALIDATE FOR PROPERTY ONE
			title("VALIDATE FOR PROPERTY ONE");

			// validate the property name
			switchVerification("navigation_header_propertyname1_XPATH", "[DND] AAAA Risk Test Prop 01 - 01",
					"The property name is not displayed.");

			// validate the meter number is displayed selected or not
			try {

				String meternumber_actual = driver
						.findElement(By
								.xpath(OR.getProperty("navigation_sustainability_utilitybills_utilitymetertxt_XPATH")))
						.getAttribute("value");

				if (meternumber_actual.equals(utilityBills)) {
					successMessage("The meter is display successfully.");

				} else {
					verificationFailedMessage("The meter number is not display.");

				}
			} catch (Throwable t) {
				verificationFailedMessage("The meter number is not display.");
			}

			// VALIDATE FOR PROPERTY TWO
			title("VALIDATE FOR PROPERTY TWO");

			// wait for the element
			explicitWaitClickable("navigation_header_searchicon_XPATH");

			// click on the search icon from the header
			click("navigation_header_searchicon_XPATH");

			// enter property 2 number in text field
			type("navigation_header_searchtxt_XPATH", "02");

			// hit enter key
			driver.findElement(By.xpath(OR.getProperty("navigation_header_searchtxt_XPATH"))).sendKeys(Keys.ENTER);
			consoleMessage("Hit enter key.");

			// wait for the element
			Thread.sleep(2000);

			// click on the settings icon from the top of the screen
			click("questionnaire_settingicon_CSS");

			// wait for the element
			Thread.sleep(1000);

			// click on the cancel icon
			click("questionnaire_setting_cancelicon_XPATH");

			// validate the property name
			switchVerification("navigation_header_propertyname2_XPATH", "[DND] AAAA Risk Test Prop 02 - 02",
					"The property name is not displayed.");

			// validate the meter number is displayed selected or not
			try {

				String meternumber_actual = driver
						.findElement(By
								.xpath(OR.getProperty("navigation_sustainability_utilitybills_utilitymetertxt_XPATH")))
						.getAttribute("value");

				if (meternumber_actual.equals(utilityMeter)) {
					verificationFailedMessage("The meter number is display.");

				} else {
					successMessage("The meter number is not display as expected.");

				}
			} catch (Throwable t) {
				successMessage("The meter number is not display as expected.");
			}

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

			// validate the meter number in the listing screen is
			// displayed selected or not
			try {
				String meternumberlist = "//td[contains(text(),'" + utilityMeter + "')]";
				boolean meternumberlist_actual = driver.findElement(By.xpath(meternumberlist)).isDisplayed();

				if (meternumberlist_actual == true) {
					verificationFailedMessage("The newly created meter number is display.");

				} else {
					successMessage("The newly created meter number is not display.");

				}
			} catch (Throwable t) {
				successMessage("The newly created meter number is not display.");
			}

			// VALIDATE FOR PROPERTY THREE
			title("VALIDATE FOR PROPERTY THREE");

			// wait for the element
			explicitWaitClickable("navigation_header_searchicon_XPATH");

			// click on the search icon from the header
			click("navigation_header_searchicon_XPATH");

			// enter property 3 number in text field
			type("navigation_header_searchtxt_XPATH", "03");

			// hit enter key
			driver.findElement(By.xpath(OR.getProperty("navigation_header_searchtxt_XPATH"))).sendKeys(Keys.ENTER);
			consoleMessage("Hit enter key.");

			// wait for the element
			Thread.sleep(2000);

			// click on the settings icon from the top of the screen
			click("questionnaire_settingicon_CSS");

			// wait for the element
			Thread.sleep(1000);

			// click on the cancel icon
			click("questionnaire_setting_cancelicon_XPATH");

			// validate the property name
			switchVerification("navigation_header_propertyname3_XPATH", "[DND] AAAA Risk Test Prop 03 - 03",
					"The property name is not displayed.");

			// validate the meter number is displayed selected or not
			try {

				String meternumber_actual = driver
						.findElement(By
								.xpath(OR.getProperty("navigation_sustainability_utilitybills_utilitymetertxt_XPATH")))
						.getAttribute("value");

				if (meternumber_actual.equals(utilityMeter)) {
					verificationFailedMessage("The meter number is display.");

				} else {
					successMessage("The meter number is not display as expected.");

				}
			} catch (Throwable t) {
				successMessage("The meter number is not display as expected.");
			}

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

			// validate the meter number in the listing screen is
			// displayed selected or not
			try {
				String meternumberlist = "//td[contains(text(),'" + utilityMeter + "')]";
				boolean meternumberlist_actual = driver.findElement(By.xpath(meternumberlist)).isDisplayed();

				if (meternumberlist_actual == true) {
					verificationFailedMessage("The newly created meter number is display.");

				} else {
					successMessage("The newly created meter number is not display.");

				}
			} catch (Throwable t) {
				successMessage("The newly created meter number is not display.");
			}

			// VALIDATE FOR PROPERTY ONE
			title("VALIDATE FOR PROPERTY ONE");

			// wait for the element
			explicitWaitClickable("navigation_header_searchicon_XPATH");

			// click on the search icon from the header
			click("navigation_header_searchicon_XPATH");

			// enter property number in text field
			type("navigation_header_searchtxt_XPATH", "01");

			// hit enter key
			driver.findElement(By.xpath(OR.getProperty("navigation_header_searchtxt_XPATH"))).sendKeys(Keys.ENTER);
			consoleMessage("Hit enter key.");

			// validate the property name
			switchVerification("navigation_header_propertyname1_XPATH", "[DND] AAAA Risk Test Prop 01 - 01",
					"The property name is not displayed.");

			// validate the meter number is displayed selected or not
			try {

				String meternumber_actual = driver
						.findElement(By.xpath(OR.getProperty("sustainability_utilitybills_meternumber_XPATH")))
						.getAttribute("value");

				if (meternumber_actual.equals(utilityMeter)) {
					verificationFailedMessage("The meter number is display.");

				} else {
					successMessage("The meter number is not display as expected.");

				}
			} catch (Throwable t) {
				successMessage("The meter number is not display as expected.");
			}

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

			// validate the meter number in the listing screen is
			// displayed selected or not
			try {
				String meternumberlist = "//td[contains(text(),'" + utilityMeter + "')]";
				boolean meternumberlist_actual = driver.findElement(By.xpath(meternumberlist)).isDisplayed();

				if (meternumberlist_actual == true) {
					successMessage("The newly created meter number is display successfully.");

				} else {
					verificationFailedMessage("The newly created meter number is not display.");

				}
			} catch (Throwable t) {
				verificationFailedMessage("The newly created meter number is not display.");
			}

		} catch (Throwable t) {
			verificationFailed();
		}

		// click on the home icon from the top of the screen
		click("questionnaire_homeburgermenubtn_hide_CSS");

		// wait for the element
		explicitWait("propertylist_title_XPATH");

		// verify the property list
		switchVerification("propertylist_title_XPATH", "Property List", "The property list is not displayed.");

		// VALIDATE THE NAVIGATION AFTER SWITCHING THE PROPERTY FROM THE HEADER OF
		// THE ENERGY SCREENS
		title("VALIDATE THE NAVIGATION AFTER SWITCHING THE PROPERTY FROM THE HEADER OF THE ENERGY SCREENS");

		try {

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

			// VALIDATE FOR PROPERTY ONE
			title("VALIDATE FOR PROPERTY ONE");

			// validate the property name
			switchVerification("navigation_header_propertyname1_XPATH", "[DND] AAAA Risk Test Prop 01 - 01",
					"The property name is not displayed.");

			// validate the energy title
			switchVerification("navigation_sustainability_energylbl_XPATH", "Energy",
					"The Energy title is not displayed.");

			// ***** VALIDATE DETAILS OF THE SCREEN *****

			// VALIDATE FOR PROPERTY TWO
			title("VALIDATE FOR PROPERTY TWO");

			// wait for the element
			explicitWaitClickable("navigation_header_searchicon_XPATH");

			// click on the search icon from the header
			click("navigation_header_searchicon_XPATH");

			// enter property 2 number in text field
			type("navigation_header_searchtxt_XPATH", "02");

			// hit enter key
			driver.findElement(By.xpath(OR.getProperty("navigation_header_searchtxt_XPATH"))).sendKeys(Keys.ENTER);
			consoleMessage("Hit enter key.");

			// wait for the element
			Thread.sleep(2000);

			// click on the settings icon from the top of the screen
			click("questionnaire_settingicon_CSS");

			// wait for the element
			Thread.sleep(1000);

			// click on the cancel icon
			click("questionnaire_setting_cancelicon_XPATH");

			// validate the property name
			switchVerification("navigation_header_propertyname2_XPATH", "[DND] AAAA Risk Test Prop 02 - 02",
					"The property name is not displayed.");

			// validate the energy title
			switchVerification("navigation_sustainability_energylbl_XPATH", "Energy",
					"The Energy title is not displayed.");

			// ***** VALIDATE DETAILS OF THE SCREEN *****

			// VALIDATE FOR PROPERTY THREE
			title("VALIDATE FOR PROPERTY THREE");

			// wait for the element
			explicitWaitClickable("navigation_header_searchicon_XPATH");

			// click on the search icon from the header
			click("navigation_header_searchicon_XPATH");

			// enter property 3 number in text field
			type("navigation_header_searchtxt_XPATH", "03");

			// hit enter key
			driver.findElement(By.xpath(OR.getProperty("navigation_header_searchtxt_XPATH"))).sendKeys(Keys.ENTER);
			consoleMessage("Hit enter key.");

			// wait for the element
			Thread.sleep(2000);

			// click on the settings icon from the top of the screen
			click("questionnaire_settingicon_CSS");

			// wait for the element
			Thread.sleep(1000);

			// click on the cancel icon
			click("questionnaire_setting_cancelicon_XPATH");

			// validate the property name
			switchVerification("navigation_header_propertyname3_XPATH", "[DND] AAAA Risk Test Prop 03 - 03",
					"The property name is not displayed.");

			// validate the energy title
			switchVerification("navigation_sustainability_energylbl_XPATH", "Energy",
					"The Energy title is not displayed.");

			// ***** VALIDATE DETAILS OF THE SCREEN *****

			// VALIDATE FOR PROPERTY ONE
			title("VALIDATE FOR PROPERTY ONE");

			// wait for the element
			explicitWaitClickable("navigation_header_searchicon_XPATH");

			// click on the search icon from the header
			click("navigation_header_searchicon_XPATH");

			// enter property number in text field
			type("navigation_header_searchtxt_XPATH", "01");

			// hit enter key
			driver.findElement(By.xpath(OR.getProperty("navigation_header_searchtxt_XPATH"))).sendKeys(Keys.ENTER);
			consoleMessage("Hit enter key.");

			// validate the property name
			switchVerification("navigation_header_propertyname1_XPATH", "[DND] AAAA Risk Test Prop 01 - 01",
					"The property name is not displayed.");

			// validate the energy title
			switchVerification("navigation_sustainability_energylbl_XPATH", "Energy",
					"The Energy title is not displayed.");

			// ***** VALIDATE DETAILS OF THE SCREEN *****

		} catch (Throwable t) {
			verificationFailed();
		}

		// click on the home icon from the top of the screen
		click("questionnaire_homeburgermenubtn_hide_CSS");

		// wait for the element
		explicitWait("propertylist_title_XPATH");

		// verify the property list
		switchVerification("propertylist_title_XPATH", "Property List", "The property list is not displayed.");

		// VALIDATE THE NAVIGATION AFTER SWITCHING THE PROPERTY FROM THE HEADER OF
		// THE ELECTRICITY SCREENS
		title("VALIDATE THE NAVIGATION AFTER SWITCHING THE PROPERTY FROM THE HEADER OF THE ELECTRICITY SCREENS");

		try {

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

			// click on the Electricity option
			click("sustainability_sidemenu_buildingperformancedataoption_electricityoption_XPATH");

			// VALIDATE FOR PROPERTY ONE
			title("VALIDATE FOR PROPERTY ONE");

			// validate the property name
			switchVerification("navigation_header_propertyname1_XPATH", "[DND] AAAA Risk Test Prop 01 - 01",
					"The property name is not displayed.");

			// validate the Electricity title
			switchVerification("navigation_sustainability_electricitylbl_XPATH", "Electricity",
					"The Electricity title is not displayed.");

			// ***** VALIDATE DETAILS OF THE SCREEN *****

			// VALIDATE FOR PROPERTY TWO
			title("VALIDATE FOR PROPERTY TWO");

			// wait for the element
			explicitWaitClickable("navigation_header_searchicon_XPATH");

			// click on the search icon from the header
			click("navigation_header_searchicon_XPATH");

			// enter property 2 number in text field
			type("navigation_header_searchtxt_XPATH", "02");

			// hit enter key
			driver.findElement(By.xpath(OR.getProperty("navigation_header_searchtxt_XPATH"))).sendKeys(Keys.ENTER);
			consoleMessage("Hit enter key.");

			// wait for the element
			Thread.sleep(2000);

			// click on the settings icon from the top of the screen
			click("questionnaire_settingicon_CSS");

			// wait for the element
			Thread.sleep(1000);

			// click on the cancel icon
			click("questionnaire_setting_cancelicon_XPATH");

			// validate the property name
			switchVerification("navigation_header_propertyname2_XPATH", "[DND] AAAA Risk Test Prop 02 - 02",
					"The property name is not displayed.");

			// validate the Electricity title
			switchVerification("navigation_sustainability_electricitylbl_XPATH", "Electricity",
					"The Electricity title is not displayed.");

			// ***** VALIDATE DETAILS OF THE SCREEN *****

			// VALIDATE FOR PROPERTY THREE
			title("VALIDATE FOR PROPERTY THREE");

			// wait for the element
			explicitWaitClickable("navigation_header_searchicon_XPATH");

			// click on the search icon from the header
			click("navigation_header_searchicon_XPATH");

			// enter property 3 number in text field
			type("navigation_header_searchtxt_XPATH", "03");

			// hit enter key
			driver.findElement(By.xpath(OR.getProperty("navigation_header_searchtxt_XPATH"))).sendKeys(Keys.ENTER);
			consoleMessage("Hit enter key.");

			// wait for the element
			Thread.sleep(2000);

			// click on the settings icon from the top of the screen
			click("questionnaire_settingicon_CSS");

			// wait for the element
			Thread.sleep(1000);

			// click on the cancel icon
			click("questionnaire_setting_cancelicon_XPATH");

			// validate the property name
			switchVerification("navigation_header_propertyname3_XPATH", "[DND] AAAA Risk Test Prop 03 - 03",
					"The property name is not displayed.");

			// validate the Electricity title
			switchVerification("navigation_sustainability_electricitylbl_XPATH", "Electricity",
					"The Electricity title is not displayed.");

			// ***** VALIDATE DETAILS OF THE SCREEN *****

			// VALIDATE FOR PROPERTY ONE
			title("VALIDATE FOR PROPERTY ONE");

			// wait for the element
			explicitWaitClickable("navigation_header_searchicon_XPATH");

			// click on the search icon from the header
			click("navigation_header_searchicon_XPATH");

			// enter property number in text field
			type("navigation_header_searchtxt_XPATH", "01");

			// hit enter key
			driver.findElement(By.xpath(OR.getProperty("navigation_header_searchtxt_XPATH"))).sendKeys(Keys.ENTER);
			consoleMessage("Hit enter key.");

			// validate the property name
			switchVerification("navigation_header_propertyname1_XPATH", "[DND] AAAA Risk Test Prop 01 - 01",
					"The property name is not displayed.");

			// validate the Electricity title
			switchVerification("navigation_sustainability_electricitylbl_XPATH", "Electricity",
					"The Electricity title is not displayed.");

			// ***** VALIDATE DETAILS OF THE SCREEN *****

		} catch (Throwable t) {
			verificationFailed();
		}

		// click on the home icon from the top of the screen
		click("questionnaire_homeburgermenubtn_hide_CSS");

		// wait for the element
		explicitWait("propertylist_title_XPATH");

		// verify the property list
		switchVerification("propertylist_title_XPATH", "Property List", "The property list is not displayed.");

		// VALIDATE THE NAVIGATION AFTER SWITCHING THE PROPERTY FROM THE HEADER OF
		// THE NATURAL GAS SCREENS
		title("VALIDATE THE NAVIGATION AFTER SWITCHING THE PROPERTY FROM THE HEADER OF THE NATURAL GAS SCREENS");

		try {

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

			// click on the natural gas option
			click("sustainability_sidemenu_buildingperformancedataoption_naturalgasoption_XPATH");

			// VALIDATE FOR PROPERTY ONE
			title("VALIDATE FOR PROPERTY ONE");

			// validate the property name
			switchVerification("navigation_header_propertyname1_XPATH", "[DND] AAAA Risk Test Prop 01 - 01",
					"The property name is not displayed.");

			// validate the Natural Gas title
			switchVerification("navigation_sustainability_natualgaslbl_XPATH", "Natural Gas",
					"The Natural Gas title is not displayed.");

			// ***** VALIDATE DETAILS OF THE SCREEN *****

			// VALIDATE FOR PROPERTY TWO
			title("VALIDATE FOR PROPERTY TWO");

			// wait for the element
			explicitWaitClickable("navigation_header_searchicon_XPATH");

			// click on the search icon from the header
			click("navigation_header_searchicon_XPATH");

			// enter property 2 number in text field
			type("navigation_header_searchtxt_XPATH", "02");

			// hit enter key
			driver.findElement(By.xpath(OR.getProperty("navigation_header_searchtxt_XPATH"))).sendKeys(Keys.ENTER);
			consoleMessage("Hit enter key.");

			// wait for the element
			Thread.sleep(2000);

			// click on the settings icon from the top of the screen
			click("questionnaire_settingicon_CSS");

			// wait for the element
			Thread.sleep(1000);

			// click on the cancel icon
			click("questionnaire_setting_cancelicon_XPATH");

			// validate the property name
			switchVerification("navigation_header_propertyname2_XPATH", "[DND] AAAA Risk Test Prop 02 - 02",
					"The property name is not displayed.");

			// validate the Natural Gas title
			switchVerification("navigation_sustainability_natualgaslbl_XPATH", "Natural Gas",
					"The Natural Gas title is not displayed.");

			// ***** VALIDATE DETAILS OF THE SCREEN *****

			// VALIDATE FOR PROPERTY THREE
			title("VALIDATE FOR PROPERTY THREE");

			// wait for the element
			explicitWaitClickable("navigation_header_searchicon_XPATH");

			// click on the search icon from the header
			click("navigation_header_searchicon_XPATH");

			// enter property 3 number in text field
			type("navigation_header_searchtxt_XPATH", "03");

			// hit enter key
			driver.findElement(By.xpath(OR.getProperty("navigation_header_searchtxt_XPATH"))).sendKeys(Keys.ENTER);
			consoleMessage("Hit enter key.");

			// wait for the element
			Thread.sleep(2000);

			// click on the settings icon from the top of the screen
			click("questionnaire_settingicon_CSS");

			// wait for the element
			Thread.sleep(1000);

			// click on the cancel icon
			click("questionnaire_setting_cancelicon_XPATH");

			// validate the property name
			switchVerification("navigation_header_propertyname3_XPATH", "[DND] AAAA Risk Test Prop 03 - 03",
					"The property name is not displayed.");

			// validate the Natural Gas title
			switchVerification("navigation_sustainability_natualgaslbl_XPATH", "Natural Gas",
					"The Natural Gas title is not displayed.");

			// ***** VALIDATE DETAILS OF THE SCREEN *****

			// VALIDATE FOR PROPERTY ONE
			title("VALIDATE FOR PROPERTY ONE");

			// wait for the element
			explicitWaitClickable("navigation_header_searchicon_XPATH");

			// click on the search icon from the header
			click("navigation_header_searchicon_XPATH");

			// enter property number in text field
			type("navigation_header_searchtxt_XPATH", "01");

			// hit enter key
			driver.findElement(By.xpath(OR.getProperty("navigation_header_searchtxt_XPATH"))).sendKeys(Keys.ENTER);
			consoleMessage("Hit enter key.");

			// validate the property name
			switchVerification("navigation_header_propertyname1_XPATH", "[DND] AAAA Risk Test Prop 01 - 01",
					"The property name is not displayed.");

			// validate the Natural Gas title
			switchVerification("navigation_sustainability_natualgaslbl_XPATH", "Natural Gas",
					"The Natural Gas title is not displayed.");

			// ***** VALIDATE DETAILS OF THE SCREEN *****

		} catch (Throwable t) {
			verificationFailed();
		}

		// click on the home icon from the top of the screen
		click("questionnaire_homeburgermenubtn_hide_CSS");

		// wait for the element
		explicitWait("propertylist_title_XPATH");

		// verify the property list
		switchVerification("propertylist_title_XPATH", "Property List", "The property list is not displayed.");

		// VALIDATE THE NAVIGATION AFTER SWITCHING THE PROPERTY FROM THE HEADER OF
		// THE STEAM SCREENS
		title("VALIDATE THE NAVIGATION AFTER SWITCHING THE PROPERTY FROM THE HEADER OF THE STEAM SCREENS");

		try {

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

			// click on the steam option
			click("sustainability_sidemenu_buildingperformancedataoption_steamoption_XPATH");

			// VALIDATE FOR PROPERTY ONE
			title("VALIDATE FOR PROPERTY ONE");

			// validate the property name
			switchVerification("navigation_header_propertyname1_XPATH", "[DND] AAAA Risk Test Prop 01 - 01",
					"The property name is not displayed.");

			// validate the steam title
			switchVerification("navigation_sustainability_steamlbl_XPATH", "Steam",
					"The Steam title is not displayed.");

			// ***** VALIDATE DETAILS OF THE SCREEN *****

			// VALIDATE FOR PROPERTY TWO
			title("VALIDATE FOR PROPERTY TWO");

			// wait for the element
			explicitWaitClickable("navigation_header_searchicon_XPATH");

			// click on the search icon from the header
			click("navigation_header_searchicon_XPATH");

			// enter property 2 number in text field
			type("navigation_header_searchtxt_XPATH", "02");

			// hit enter key
			driver.findElement(By.xpath(OR.getProperty("navigation_header_searchtxt_XPATH"))).sendKeys(Keys.ENTER);
			consoleMessage("Hit enter key.");

			// wait for the element
			Thread.sleep(2000);

			// click on the settings icon from the top of the screen
			click("questionnaire_settingicon_CSS");

			// wait for the element
			Thread.sleep(1000);

			// click on the cancel icon
			click("questionnaire_setting_cancelicon_XPATH");

			// validate the property name
			switchVerification("navigation_header_propertyname2_XPATH", "[DND] AAAA Risk Test Prop 02 - 02",
					"The property name is not displayed.");

			// validate the steam title
			switchVerification("navigation_sustainability_steamlbl_XPATH", "Steam",
					"The Steam title is not displayed.");

			// ***** VALIDATE DETAILS OF THE SCREEN *****

			// VALIDATE FOR PROPERTY THREE
			title("VALIDATE FOR PROPERTY THREE");

			// wait for the element
			explicitWaitClickable("navigation_header_searchicon_XPATH");

			// click on the search icon from the header
			click("navigation_header_searchicon_XPATH");

			// enter property 3 number in text field
			type("navigation_header_searchtxt_XPATH", "03");

			// hit enter key
			driver.findElement(By.xpath(OR.getProperty("navigation_header_searchtxt_XPATH"))).sendKeys(Keys.ENTER);
			consoleMessage("Hit enter key.");

			// wait for the element
			Thread.sleep(2000);

			// click on the settings icon from the top of the screen
			click("questionnaire_settingicon_CSS");

			// wait for the element
			Thread.sleep(1000);

			// click on the cancel icon
			click("questionnaire_setting_cancelicon_XPATH");

			// validate the property name
			switchVerification("navigation_header_propertyname3_XPATH", "[DND] AAAA Risk Test Prop 03 - 03",
					"The property name is not displayed.");

			// validate the steam title
			switchVerification("navigation_sustainability_steamlbl_XPATH", "Steam",
					"The Steam title is not displayed.");

			// ***** VALIDATE DETAILS OF THE SCREEN *****

			// VALIDATE FOR PROPERTY ONE
			title("VALIDATE FOR PROPERTY ONE");

			// wait for the element
			explicitWaitClickable("navigation_header_searchicon_XPATH");

			// click on the search icon from the header
			click("navigation_header_searchicon_XPATH");

			// enter property number in text field
			type("navigation_header_searchtxt_XPATH", "01");

			// hit enter key
			driver.findElement(By.xpath(OR.getProperty("navigation_header_searchtxt_XPATH"))).sendKeys(Keys.ENTER);
			consoleMessage("Hit enter key.");

			// validate the property name
			switchVerification("navigation_header_propertyname1_XPATH", "[DND] AAAA Risk Test Prop 01 - 01",
					"The property name is not displayed.");

			// validate the steam title
			switchVerification("navigation_sustainability_steamlbl_XPATH", "Steam",
					"The Steam title is not displayed.");

			// ***** VALIDATE DETAILS OF THE SCREEN *****

		} catch (Throwable t) {
			verificationFailed();
		}

		// click on the home icon from the top of the screen
		click("questionnaire_homeburgermenubtn_hide_CSS");

		// wait for the element
		explicitWait("propertylist_title_XPATH");

		// verify the property list
		switchVerification("propertylist_title_XPATH", "Property List", "The property list is not displayed.");

		// VALIDATE THE NAVIGATION AFTER SWITCHING THE PROPERTY FROM THE HEADER OF
		// THE CHILLED WATER SCREENS
		title("VALIDATE THE NAVIGATION AFTER SWITCHING THE PROPERTY FROM THE HEADER OF THE CHILLED WATER SCREENS");

		try {

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

			// click on the chilled water option
			click("sustainability_sidemenu_buildingperformancedataoption_chilledwateroption_XPATH");

			// VALIDATE FOR PROPERTY ONE
			title("VALIDATE FOR PROPERTY ONE");

			// validate the property name
			switchVerification("navigation_header_propertyname1_XPATH", "[DND] AAAA Risk Test Prop 01 - 01",
					"The property name is not displayed.");

			// validate the Chilled Water title
			switchVerification("navigation_sustainability_chilledwaterlbl_XPATH", "Chilled Water",
					"The Chilled Water title is not displayed.");

			// ***** VALIDATE DETAILS OF THE SCREEN *****

			// VALIDATE FOR PROPERTY TWO
			title("VALIDATE FOR PROPERTY TWO");

			// wait for the element
			explicitWaitClickable("navigation_header_searchicon_XPATH");

			// click on the search icon from the header
			click("navigation_header_searchicon_XPATH");

			// enter property 2 number in text field
			type("navigation_header_searchtxt_XPATH", "02");

			// hit enter key
			driver.findElement(By.xpath(OR.getProperty("navigation_header_searchtxt_XPATH"))).sendKeys(Keys.ENTER);
			consoleMessage("Hit enter key.");

			// wait for the element
			Thread.sleep(2000);

			// click on the settings icon from the top of the screen
			click("questionnaire_settingicon_CSS");

			// wait for the element
			Thread.sleep(1000);

			// click on the cancel icon
			click("questionnaire_setting_cancelicon_XPATH");

			// validate the property name
			switchVerification("navigation_header_propertyname2_XPATH", "[DND] AAAA Risk Test Prop 02 - 02",
					"The property name is not displayed.");

			// validate the Chilled Water title
			switchVerification("navigation_sustainability_chilledwaterlbl_XPATH", "Chilled Water",
					"The Chilled Water title is not displayed.");

			// ***** VALIDATE DETAILS OF THE SCREEN *****

			// VALIDATE FOR PROPERTY THREE
			title("VALIDATE FOR PROPERTY THREE");

			// wait for the element
			explicitWaitClickable("navigation_header_searchicon_XPATH");

			// click on the search icon from the header
			click("navigation_header_searchicon_XPATH");

			// enter property 3 number in text field
			type("navigation_header_searchtxt_XPATH", "03");

			// hit enter key
			driver.findElement(By.xpath(OR.getProperty("navigation_header_searchtxt_XPATH"))).sendKeys(Keys.ENTER);
			consoleMessage("Hit enter key.");

			// wait for the element
			Thread.sleep(2000);

			// click on the settings icon from the top of the screen
			click("questionnaire_settingicon_CSS");

			// wait for the element
			Thread.sleep(1000);

			// click on the cancel icon
			click("questionnaire_setting_cancelicon_XPATH");

			// validate the property name
			switchVerification("navigation_header_propertyname3_XPATH", "[DND] AAAA Risk Test Prop 03 - 03",
					"The property name is not displayed.");

			// validate the Chilled Water title
			switchVerification("navigation_sustainability_chilledwaterlbl_XPATH", "Chilled Water",
					"The Chilled Water title is not displayed.");

			// ***** VALIDATE DETAILS OF THE SCREEN *****

			// VALIDATE FOR PROPERTY ONE
			title("VALIDATE FOR PROPERTY ONE");

			// wait for the element
			explicitWaitClickable("navigation_header_searchicon_XPATH");

			// click on the search icon from the header
			click("navigation_header_searchicon_XPATH");

			// enter property number in text field
			type("navigation_header_searchtxt_XPATH", "01");

			// hit enter key
			driver.findElement(By.xpath(OR.getProperty("navigation_header_searchtxt_XPATH"))).sendKeys(Keys.ENTER);
			consoleMessage("Hit enter key.");

			// validate the property name
			switchVerification("navigation_header_propertyname1_XPATH", "[DND] AAAA Risk Test Prop 01 - 01",
					"The property name is not displayed.");

			// validate the Chilled Water title
			switchVerification("navigation_sustainability_chilledwaterlbl_XPATH", "Chilled Water",
					"The Chilled Water title is not displayed.");

			// ***** VALIDATE DETAILS OF THE SCREEN *****

		} catch (Throwable t) {
			verificationFailed();
		}

		// click on the home icon from the top of the screen
		click("questionnaire_homeburgermenubtn_hide_CSS");

		// wait for the element
		explicitWait("propertylist_title_XPATH");

		// verify the property list
		switchVerification("propertylist_title_XPATH", "Property List", "The property list is not displayed.");

		// VALIDATE THE NAVIGATION AFTER SWITCHING THE PROPERTY FROM THE HEADER OF
		// THE HEATING OIL SCREENS
		title("VALIDATE THE NAVIGATION AFTER SWITCHING THE PROPERTY FROM THE HEADER OF THE HEATING OIL SCREENS");

		try {

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

			// click on the heating oil option
			click("sustainability_sidemenu_buildingperformancedataoption_heatingoiloption_XPATH");

			// VALIDATE FOR PROPERTY ONE
			title("VALIDATE FOR PROPERTY ONE");

			// validate the property name
			switchVerification("navigation_header_propertyname1_XPATH", "[DND] AAAA Risk Test Prop 01 - 01",
					"The property name is not displayed.");

			// validate the Heating Oil title
			switchVerification("navigation_sustainability_heatingoillbl_XPATH", "Heating Oil",
					"The Heating Oil title is not displayed.");

			// ***** VALIDATE DETAILS OF THE SCREEN *****

			// VALIDATE FOR PROPERTY TWO
			title("VALIDATE FOR PROPERTY TWO");

			// wait for the element
			explicitWaitClickable("navigation_header_searchicon_XPATH");

			// click on the search icon from the header
			click("navigation_header_searchicon_XPATH");

			// enter property 2 number in text field
			type("navigation_header_searchtxt_XPATH", "02");

			// hit enter key
			driver.findElement(By.xpath(OR.getProperty("navigation_header_searchtxt_XPATH"))).sendKeys(Keys.ENTER);
			consoleMessage("Hit enter key.");

			// wait for the element
			Thread.sleep(2000);

			// click on the settings icon from the top of the screen
			click("questionnaire_settingicon_CSS");

			// wait for the element
			Thread.sleep(1000);

			// click on the cancel icon
			click("questionnaire_setting_cancelicon_XPATH");

			// validate the property name
			switchVerification("navigation_header_propertyname2_XPATH", "[DND] AAAA Risk Test Prop 02 - 02",
					"The property name is not displayed.");

			// validate the Heating Oil title
			switchVerification("navigation_sustainability_heatingoillbl_XPATH", "Heating Oil",
					"The Heating Oil title is not displayed.");

			// ***** VALIDATE DETAILS OF THE SCREEN *****

			// VALIDATE FOR PROPERTY THREE
			title("VALIDATE FOR PROPERTY THREE");

			// wait for the element
			explicitWaitClickable("navigation_header_searchicon_XPATH");

			// click on the search icon from the header
			click("navigation_header_searchicon_XPATH");

			// enter property 3 number in text field
			type("navigation_header_searchtxt_XPATH", "03");

			// hit enter key
			driver.findElement(By.xpath(OR.getProperty("navigation_header_searchtxt_XPATH"))).sendKeys(Keys.ENTER);
			consoleMessage("Hit enter key.");

			// wait for the element
			Thread.sleep(2000);

			// click on the settings icon from the top of the screen
			click("questionnaire_settingicon_CSS");

			// wait for the element
			Thread.sleep(1000);

			// click on the cancel icon
			click("questionnaire_setting_cancelicon_XPATH");

			// validate the property name
			switchVerification("navigation_header_propertyname3_XPATH", "[DND] AAAA Risk Test Prop 03 - 03",
					"The property name is not displayed.");

			// validate the Heating Oil title
			switchVerification("navigation_sustainability_heatingoillbl_XPATH", "Heating Oil",
					"The Heating Oil title is not displayed.");

			// ***** VALIDATE DETAILS OF THE SCREEN *****

			// VALIDATE FOR PROPERTY ONE
			title("VALIDATE FOR PROPERTY ONE");

			// wait for the element
			explicitWaitClickable("navigation_header_searchicon_XPATH");

			// click on the search icon from the header
			click("navigation_header_searchicon_XPATH");

			// enter property number in text field
			type("navigation_header_searchtxt_XPATH", "01");

			// hit enter key
			driver.findElement(By.xpath(OR.getProperty("navigation_header_searchtxt_XPATH"))).sendKeys(Keys.ENTER);
			consoleMessage("Hit enter key.");

			// validate the property name
			switchVerification("navigation_header_propertyname1_XPATH", "[DND] AAAA Risk Test Prop 01 - 01",
					"The property name is not displayed.");

			// validate the Heating Oil title
			switchVerification("navigation_sustainability_heatingoillbl_XPATH", "Heating Oil",
					"The Heating Oil title is not displayed.");

			// ***** VALIDATE DETAILS OF THE SCREEN *****

		} catch (Throwable t) {
			verificationFailed();
		}

		// click on the home icon from the top of the screen
		click("questionnaire_homeburgermenubtn_hide_CSS");

		// wait for the element
		explicitWait("propertylist_title_XPATH");

		// verify the property list
		switchVerification("propertylist_title_XPATH", "Property List", "The property list is not displayed.");

		// VALIDATE THE NAVIGATION AFTER SWITCHING THE PROPERTY FROM THE HEADER OF
		// THE DIESEL SCREENS
		title("VALIDATE THE NAVIGATION AFTER SWITCHING THE PROPERTY FROM THE HEADER OF THE DIESEL SCREENS");

		try {

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

			// click on the diesel option
			click("sustainability_sidemenu_buildingperformancedataoption_dieseloption_XPATH");

			// VALIDATE FOR PROPERTY ONE
			title("VALIDATE FOR PROPERTY ONE");

			// validate the property name
			switchVerification("navigation_header_propertyname1_XPATH", "[DND] AAAA Risk Test Prop 01 - 01",
					"The property name is not displayed.");

			// validate the diesel title
			switchVerification("navigation_sustainability_diesellbl_XPATH", "Diesel",
					"The Diesel title is not displayed.");

			// ***** VALIDATE DETAILS OF THE SCREEN *****

			// VALIDATE FOR PROPERTY TWO
			title("VALIDATE FOR PROPERTY TWO");

			// wait for the element
			explicitWaitClickable("navigation_header_searchicon_XPATH");

			// click on the search icon from the header
			click("navigation_header_searchicon_XPATH");

			// enter property 2 number in text field
			type("navigation_header_searchtxt_XPATH", "02");

			// hit enter key
			driver.findElement(By.xpath(OR.getProperty("navigation_header_searchtxt_XPATH"))).sendKeys(Keys.ENTER);
			consoleMessage("Hit enter key.");

			// wait for the element
			Thread.sleep(2000);

			// click on the settings icon from the top of the screen
			click("questionnaire_settingicon_CSS");

			// wait for the element
			Thread.sleep(1000);

			// click on the cancel icon
			click("questionnaire_setting_cancelicon_XPATH");

			// validate the property name
			switchVerification("navigation_header_propertyname2_XPATH", "[DND] AAAA Risk Test Prop 02 - 02",
					"The property name is not displayed.");

			// validate the diesel title
			switchVerification("navigation_sustainability_diesellbl_XPATH", "Diesel",
					"The Diesel title is not displayed.");

			// ***** VALIDATE DETAILS OF THE SCREEN *****

			// VALIDATE FOR PROPERTY THREE
			title("VALIDATE FOR PROPERTY THREE");

			// wait for the element
			explicitWaitClickable("navigation_header_searchicon_XPATH");

			// click on the search icon from the header
			click("navigation_header_searchicon_XPATH");

			// enter property 3 number in text field
			type("navigation_header_searchtxt_XPATH", "03");

			// hit enter key
			driver.findElement(By.xpath(OR.getProperty("navigation_header_searchtxt_XPATH"))).sendKeys(Keys.ENTER);
			consoleMessage("Hit enter key.");

			// wait for the element
			Thread.sleep(2000);

			// click on the settings icon from the top of the screen
			click("questionnaire_settingicon_CSS");

			// wait for the element
			Thread.sleep(1000);

			// click on the cancel icon
			click("questionnaire_setting_cancelicon_XPATH");

			// validate the property name
			switchVerification("navigation_header_propertyname3_XPATH", "[DND] AAAA Risk Test Prop 03 - 03",
					"The property name is not displayed.");

			// validate the diesel title
			switchVerification("navigation_sustainability_diesellbl_XPATH", "Diesel",
					"The Diesel title is not displayed.");

			// ***** VALIDATE DETAILS OF THE SCREEN *****

			// VALIDATE FOR PROPERTY ONE
			title("VALIDATE FOR PROPERTY ONE");

			// wait for the element
			explicitWaitClickable("navigation_header_searchicon_XPATH");

			// click on the search icon from the header
			click("navigation_header_searchicon_XPATH");

			// enter property number in text field
			type("navigation_header_searchtxt_XPATH", "01");

			// hit enter key
			driver.findElement(By.xpath(OR.getProperty("navigation_header_searchtxt_XPATH"))).sendKeys(Keys.ENTER);
			consoleMessage("Hit enter key.");

			// validate the property name
			switchVerification("navigation_header_propertyname1_XPATH", "[DND] AAAA Risk Test Prop 01 - 01",
					"The property name is not displayed.");

			// validate the diesel title
			switchVerification("navigation_sustainability_diesellbl_XPATH", "Diesel",
					"The Diesel title is not displayed.");

			// ***** VALIDATE DETAILS OF THE SCREEN *****

		} catch (Throwable t) {
			verificationFailed();
		}

		// click on the home icon from the top of the screen
		click("questionnaire_homeburgermenubtn_hide_CSS");

		// wait for the element
		explicitWait("propertylist_title_XPATH");

		// verify the property list
		switchVerification("propertylist_title_XPATH", "Property List", "The property list is not displayed.");

		// VALIDATE THE NAVIGATION AFTER SWITCHING THE PROPERTY FROM THE HEADER OF
		// THE PROPANE SCREENS
		title("VALIDATE THE NAVIGATION AFTER SWITCHING THE PROPERTY FROM THE HEADER OF THE PROPANE SCREENS");

		try {

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

			// click on the propane option
			click("sustainability_sidemenu_buildingperformancedataoption_propaneoption_XPATH");

			// VALIDATE FOR PROPERTY ONE
			title("VALIDATE FOR PROPERTY ONE");

			// validate the property name
			switchVerification("navigation_header_propertyname1_XPATH", "[DND] AAAA Risk Test Prop 01 - 01",
					"The property name is not displayed.");

			// validate the Propane title
			switchVerification("navigation_sustainability_propanelbl_XPATH", "Propane",
					"The Propane title is not displayed.");

			// ***** VALIDATE DETAILS OF THE SCREEN *****

			// VALIDATE FOR PROPERTY TWO
			title("VALIDATE FOR PROPERTY TWO");

			// wait for the element
			explicitWaitClickable("navigation_header_searchicon_XPATH");

			// click on the search icon from the header
			click("navigation_header_searchicon_XPATH");

			// enter property 2 number in text field
			type("navigation_header_searchtxt_XPATH", "02");

			// hit enter key
			driver.findElement(By.xpath(OR.getProperty("navigation_header_searchtxt_XPATH"))).sendKeys(Keys.ENTER);
			consoleMessage("Hit enter key.");

			// wait for the element
			Thread.sleep(2000);

			// click on the settings icon from the top of the screen
			click("questionnaire_settingicon_CSS");

			// wait for the element
			Thread.sleep(1000);

			// click on the cancel icon
			click("questionnaire_setting_cancelicon_XPATH");

			// validate the property name
			switchVerification("navigation_header_propertyname2_XPATH", "[DND] AAAA Risk Test Prop 02 - 02",
					"The property name is not displayed.");

			// validate the Propane title
			switchVerification("navigation_sustainability_propanelbl_XPATH", "Propane",
					"The Propane title is not displayed.");

			// ***** VALIDATE DETAILS OF THE SCREEN *****

			// VALIDATE FOR PROPERTY THREE
			title("VALIDATE FOR PROPERTY THREE");

			// wait for the element
			explicitWaitClickable("navigation_header_searchicon_XPATH");

			// click on the search icon from the header
			click("navigation_header_searchicon_XPATH");

			// enter property 3 number in text field
			type("navigation_header_searchtxt_XPATH", "03");

			// hit enter key
			driver.findElement(By.xpath(OR.getProperty("navigation_header_searchtxt_XPATH"))).sendKeys(Keys.ENTER);
			consoleMessage("Hit enter key.");

			// wait for the element
			Thread.sleep(2000);

			// click on the settings icon from the top of the screen
			click("questionnaire_settingicon_CSS");

			// wait for the element
			Thread.sleep(1000);

			// click on the cancel icon
			click("questionnaire_setting_cancelicon_XPATH");

			// validate the property name
			switchVerification("navigation_header_propertyname3_XPATH", "[DND] AAAA Risk Test Prop 03 - 03",
					"The property name is not displayed.");

			// validate the Propane title
			switchVerification("navigation_sustainability_propanelbl_XPATH", "Propane",
					"The Propane title is not displayed.");

			// ***** VALIDATE DETAILS OF THE SCREEN *****

			// VALIDATE FOR PROPERTY ONE
			title("VALIDATE FOR PROPERTY ONE");

			// wait for the element
			explicitWaitClickable("navigation_header_searchicon_XPATH");

			// click on the search icon from the header
			click("navigation_header_searchicon_XPATH");

			// enter property number in text field
			type("navigation_header_searchtxt_XPATH", "01");

			// hit enter key
			driver.findElement(By.xpath(OR.getProperty("navigation_header_searchtxt_XPATH"))).sendKeys(Keys.ENTER);
			consoleMessage("Hit enter key.");

			// validate the property name
			switchVerification("navigation_header_propertyname1_XPATH", "[DND] AAAA Risk Test Prop 01 - 01",
					"The property name is not displayed.");

			// validate the Propane title
			switchVerification("navigation_sustainability_propanelbl_XPATH", "Propane",
					"The Propane title is not displayed.");

			// ***** VALIDATE DETAILS OF THE SCREEN *****

		} catch (Throwable t) {
			verificationFailed();
		}

		// click on the home icon from the top of the screen
		click("questionnaire_homeburgermenubtn_hide_CSS");

		// wait for the element
		explicitWait("propertylist_title_XPATH");

		// verify the property list
		switchVerification("propertylist_title_XPATH", "Property List", "The property list is not displayed.");

		// VALIDATE THE NAVIGATION AFTER SWITCHING THE PROPERTY FROM THE HEADER OF
		// THE WATER SCREENS
		title("VALIDATE THE NAVIGATION AFTER SWITCHING THE PROPERTY FROM THE HEADER OF THE WATER SCREENS");

		try {

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

			// click on the water option
			click("sustainability_sidemenu_buildingperformancedataoption_wateroption_XPATH");

			// VALIDATE FOR PROPERTY ONE
			title("VALIDATE FOR PROPERTY ONE");

			// validate the property name
			switchVerification("navigation_header_propertyname1_XPATH", "[DND] AAAA Risk Test Prop 01 - 01",
					"The property name is not displayed.");

			// validate the Water title
			switchVerification("navigation_sustainability_waterlbl_XPATH", "Water",
					"The Water title is not displayed.");

			// ***** VALIDATE DETAILS OF THE SCREEN *****

			// VALIDATE FOR PROPERTY TWO
			title("VALIDATE FOR PROPERTY TWO");

			// wait for the element
			explicitWaitClickable("navigation_header_searchicon_XPATH");

			// click on the search icon from the header
			click("navigation_header_searchicon_XPATH");

			// enter property 2 number in text field
			type("navigation_header_searchtxt_XPATH", "02");

			// hit enter key
			driver.findElement(By.xpath(OR.getProperty("navigation_header_searchtxt_XPATH"))).sendKeys(Keys.ENTER);
			consoleMessage("Hit enter key.");

			// wait for the element
			Thread.sleep(2000);

			// click on the settings icon from the top of the screen
			click("questionnaire_settingicon_CSS");

			// wait for the element
			Thread.sleep(1000);

			// click on the cancel icon
			click("questionnaire_setting_cancelicon_XPATH");

			// validate the property name
			switchVerification("navigation_header_propertyname2_XPATH", "[DND] AAAA Risk Test Prop 02 - 02",
					"The property name is not displayed.");

			// validate the Water title
			switchVerification("navigation_sustainability_waterlbl_XPATH", "Water",
					"The Water title is not displayed.");

			// ***** VALIDATE DETAILS OF THE SCREEN *****

			// VALIDATE FOR PROPERTY THREE
			title("VALIDATE FOR PROPERTY THREE");

			// wait for the element
			explicitWaitClickable("navigation_header_searchicon_XPATH");

			// click on the search icon from the header
			click("navigation_header_searchicon_XPATH");

			// enter property 3 number in text field
			type("navigation_header_searchtxt_XPATH", "03");

			// hit enter key
			driver.findElement(By.xpath(OR.getProperty("navigation_header_searchtxt_XPATH"))).sendKeys(Keys.ENTER);
			consoleMessage("Hit enter key.");

			// wait for the element
			Thread.sleep(2000);

			// click on the settings icon from the top of the screen
			click("questionnaire_settingicon_CSS");

			// wait for the element
			Thread.sleep(1000);

			// click on the cancel icon
			click("questionnaire_setting_cancelicon_XPATH");

			// validate the property name
			switchVerification("navigation_header_propertyname3_XPATH", "[DND] AAAA Risk Test Prop 03 - 03",
					"The property name is not displayed.");

			// validate the Water title
			switchVerification("navigation_sustainability_waterlbl_XPATH", "Water",
					"The Water title is not displayed.");

			// ***** VALIDATE DETAILS OF THE SCREEN *****

			// VALIDATE FOR PROPERTY ONE
			title("VALIDATE FOR PROPERTY ONE");

			// wait for the element
			explicitWaitClickable("navigation_header_searchicon_XPATH");

			// click on the search icon from the header
			click("navigation_header_searchicon_XPATH");

			// enter property number in text field
			type("navigation_header_searchtxt_XPATH", "01");

			// hit enter key
			driver.findElement(By.xpath(OR.getProperty("navigation_header_searchtxt_XPATH"))).sendKeys(Keys.ENTER);
			consoleMessage("Hit enter key.");

			// validate the property name
			switchVerification("navigation_header_propertyname1_XPATH", "[DND] AAAA Risk Test Prop 01 - 01",
					"The property name is not displayed.");

			// validate the Water title
			switchVerification("navigation_sustainability_waterlbl_XPATH", "Water",
					"The Water title is not displayed.");

			// ***** VALIDATE DETAILS OF THE SCREEN *****

		} catch (Throwable t) {
			verificationFailed();
		}

		// click on the home icon from the top of the screen
		click("questionnaire_homeburgermenubtn_hide_CSS");

		// wait for the element
		explicitWait("propertylist_title_XPATH");

		// verify the property list
		switchVerification("propertylist_title_XPATH", "Property List", "The property list is not displayed.");

		// VALIDATE THE NAVIGATION AFTER SWITCHING THE PROPERTY FROM THE HEADER OF
		// THE WASTE SCREENS
		title("VALIDATE THE NAVIGATION AFTER SWITCHING THE PROPERTY FROM THE HEADER OF THE WASTE SCREENS");

		try {

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

			// click on the waste option
			click("sustainability_sidemenu_buildingperformancedataoption_wasteoption_XPATH");

			// VALIDATE FOR PROPERTY ONE
			title("VALIDATE FOR PROPERTY ONE");

			// validate the property name
			switchVerification("navigation_header_propertyname1_XPATH", "[DND] AAAA Risk Test Prop 01 - 01",
					"The property name is not displayed.");

			// validate the Waste title
			switchVerification("navigation_sustainability_wastelbl_XPATH", "Waste Records",
					"The Waste title is not displayed.");

			// ***** VALIDATE DETAILS OF THE SCREEN *****

			// VALIDATE FOR PROPERTY TWO
			title("VALIDATE FOR PROPERTY TWO");

			// wait for the element
			explicitWaitClickable("navigation_header_searchicon_XPATH");

			// click on the search icon from the header
			click("navigation_header_searchicon_XPATH");

			// enter property 2 number in text field
			type("navigation_header_searchtxt_XPATH", "02");

			// hit enter key
			driver.findElement(By.xpath(OR.getProperty("navigation_header_searchtxt_XPATH"))).sendKeys(Keys.ENTER);
			consoleMessage("Hit enter key.");

			// wait for the element
			Thread.sleep(2000);

			// click on the settings icon from the top of the screen
			click("questionnaire_settingicon_CSS");

			// wait for the element
			Thread.sleep(1000);

			// click on the cancel icon
			click("questionnaire_setting_cancelicon_XPATH");

			// validate the property name
			switchVerification("navigation_header_propertyname2_XPATH", "[DND] AAAA Risk Test Prop 02 - 02",
					"The property name is not displayed.");

			// validate the Waste title
			switchVerification("navigation_sustainability_wastelbl_XPATH", "Waste Records",
					"The Waste title is not displayed.");

			// ***** VALIDATE DETAILS OF THE SCREEN *****

			// VALIDATE FOR PROPERTY THREE
			title("VALIDATE FOR PROPERTY THREE");

			// wait for the element
			explicitWaitClickable("navigation_header_searchicon_XPATH");

			// click on the search icon from the header
			click("navigation_header_searchicon_XPATH");

			// enter property 3 number in text field
			type("navigation_header_searchtxt_XPATH", "03");

			// hit enter key
			driver.findElement(By.xpath(OR.getProperty("navigation_header_searchtxt_XPATH"))).sendKeys(Keys.ENTER);
			consoleMessage("Hit enter key.");

			// wait for the element
			Thread.sleep(2000);

			// click on the settings icon from the top of the screen
			click("questionnaire_settingicon_CSS");

			// wait for the element
			Thread.sleep(1000);

			// click on the cancel icon
			click("questionnaire_setting_cancelicon_XPATH");

			// validate the property name
			switchVerification("navigation_header_propertyname3_XPATH", "[DND] AAAA Risk Test Prop 03 - 03",
					"The property name is not displayed.");

			// validate the Waste title
			switchVerification("navigation_sustainability_wastelbl_XPATH", "Waste Records",
					"The Waste title is not displayed.");

			// ***** VALIDATE DETAILS OF THE SCREEN *****

			// VALIDATE FOR PROPERTY ONE
			title("VALIDATE FOR PROPERTY ONE");

			// wait for the element
			explicitWaitClickable("navigation_header_searchicon_XPATH");

			// click on the search icon from the header
			click("navigation_header_searchicon_XPATH");

			// enter property number in text field
			type("navigation_header_searchtxt_XPATH", "01");

			// hit enter key
			driver.findElement(By.xpath(OR.getProperty("navigation_header_searchtxt_XPATH"))).sendKeys(Keys.ENTER);
			consoleMessage("Hit enter key.");

			// validate the property name
			switchVerification("navigation_header_propertyname1_XPATH", "[DND] AAAA Risk Test Prop 01 - 01",
					"The property name is not displayed.");

			// validate the Waste title
			switchVerification("navigation_sustainability_wastelbl_XPATH", "Waste Records",
					"The Waste title is not displayed.");

			// ***** VALIDATE DETAILS OF THE SCREEN *****

		} catch (Throwable t) {
			verificationFailed();
		}

		// click on the home icon from the top of the screen
		click("questionnaire_homeburgermenubtn_hide_CSS");

		// wait for the element
		explicitWait("propertylist_title_XPATH");

		// verify the property list
		switchVerification("propertylist_title_XPATH", "Property List", "The property list is not displayed.");

		// VALIDATE THE NAVIGATION AFTER SWITCHING THE PROPERTY FROM THE HEADER OF
		// THE PERFORMANCE TARGETS SCREENS
		title("VALIDATE THE NAVIGATION AFTER SWITCHING THE PROPERTY FROM THE HEADER OF THE PERFORMANCE TARGETS SCREENS");

		try {

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

			// click on the performance targets option
			click("sustainability_sidemenu_buildingperformancedataoption_performancetargetsoption_XPATH");

			// VALIDATE FOR PROPERTY ONE
			title("VALIDATE FOR PROPERTY ONE");

			// validate the property name
			switchVerification("navigation_header_propertyname1_XPATH", "[DND] AAAA Risk Test Prop 01 - 01",
					"The property name is not displayed.");

			// validate the Performance Targets title
			switchVerification("navigation_sustainability_performancetargetslbl_XPATH", "Performance Targets",
					"The Performance Targets title is not displayed.");

			// ***** VALIDATE DETAILS OF THE SCREEN *****

			// VALIDATE FOR PROPERTY TWO
			title("VALIDATE FOR PROPERTY TWO");

			// wait for the element
			explicitWaitClickable("navigation_header_searchicon_XPATH");

			// click on the search icon from the header
			click("navigation_header_searchicon_XPATH");

			// enter property 2 number in text field
			type("navigation_header_searchtxt_XPATH", "02");

			// hit enter key
			driver.findElement(By.xpath(OR.getProperty("navigation_header_searchtxt_XPATH"))).sendKeys(Keys.ENTER);
			consoleMessage("Hit enter key.");

			// wait for the element
			Thread.sleep(2000);

			// click on the settings icon from the top of the screen
			click("questionnaire_settingicon_CSS");

			// wait for the element
			Thread.sleep(1000);

			// click on the cancel icon
			click("questionnaire_setting_cancelicon_XPATH");

			// validate the property name
			switchVerification("navigation_header_propertyname2_XPATH", "[DND] AAAA Risk Test Prop 02 - 02",
					"The property name is not displayed.");

			// validate the Performance Targets title
			switchVerification("navigation_sustainability_performancetargetslbl_XPATH", "Performance Targets",
					"The Performance Targets title is not displayed.");

			// ***** VALIDATE DETAILS OF THE SCREEN *****

			// VALIDATE FOR PROPERTY THREE
			title("VALIDATE FOR PROPERTY THREE");

			// wait for the element
			explicitWaitClickable("navigation_header_searchicon_XPATH");

			// click on the search icon from the header
			click("navigation_header_searchicon_XPATH");

			// enter property 3 number in text field
			type("navigation_header_searchtxt_XPATH", "03");

			// hit enter key
			driver.findElement(By.xpath(OR.getProperty("navigation_header_searchtxt_XPATH"))).sendKeys(Keys.ENTER);
			consoleMessage("Hit enter key.");

			// wait for the element
			Thread.sleep(2000);

			// click on the settings icon from the top of the screen
			click("questionnaire_settingicon_CSS");

			// wait for the element
			Thread.sleep(1000);

			// click on the cancel icon
			click("questionnaire_setting_cancelicon_XPATH");

			// validate the property name
			switchVerification("navigation_header_propertyname3_XPATH", "[DND] AAAA Risk Test Prop 03 - 03",
					"The property name is not displayed.");

			// validate the Performance Targets title
			switchVerification("navigation_sustainability_performancetargetslbl_XPATH", "Performance Targets",
					"The Performance Targets title is not displayed.");

			// ***** VALIDATE DETAILS OF THE SCREEN *****

			// VALIDATE FOR PROPERTY ONE
			title("VALIDATE FOR PROPERTY ONE");

			// wait for the element
			explicitWaitClickable("navigation_header_searchicon_XPATH");

			// click on the search icon from the header
			click("navigation_header_searchicon_XPATH");

			// enter property number in text field
			type("navigation_header_searchtxt_XPATH", "01");

			// hit enter key
			driver.findElement(By.xpath(OR.getProperty("navigation_header_searchtxt_XPATH"))).sendKeys(Keys.ENTER);
			consoleMessage("Hit enter key.");

			// validate the property name
			switchVerification("navigation_header_propertyname1_XPATH", "[DND] AAAA Risk Test Prop 01 - 01",
					"The property name is not displayed.");

			// validate the Performance Targets title
			switchVerification("navigation_sustainability_performancetargetslbl_XPATH", "Performance Targets",
					"The Performance Targets title is not displayed.");

			// ***** VALIDATE DETAILS OF THE SCREEN *****

		} catch (Throwable t) {
			verificationFailed();
		}

		// click on the home icon from the top of the screen
		click("questionnaire_homeburgermenubtn_hide_CSS");

		// wait for the element
		explicitWait("propertylist_title_XPATH");

		// verify the property list
		switchVerification("propertylist_title_XPATH", "Property List", "The property list is not displayed.");

		// VALIDATE THE NAVIGATION AFTER SWITCHING THE PROPERTY FROM THE HEADER OF
		// THE ENERGY STAR PORTFOLIO MANAGER SCREENS
		title("VALIDATE THE NAVIGATION AFTER SWITCHING THE PROPERTY FROM THE HEADER OF THE ENERGY STAR PORTFOLIO MANAGER SCREENS");

		try {

			// click on the Sustainability icon
			click("sustainabilityicon_CSS");

			// wait for the element
			Thread.sleep(5000);

			// click on the side menu
			click("ssc_leftsidemenubtn_CSS");

			// wait for the element
			Thread.sleep(5000);

			// click on the energy star portfolio manager option
			click("sustainability_utilitybills_energystaroption_XPATH");

			// VALIDATE FOR PROPERTY ONE
			title("VALIDATE FOR PROPERTY ONE");

			// validate the property name
			switchVerification("navigation_header_propertyname1_XPATH", "[DND] AAAA Risk Test Prop 01 - 01",
					"The property name is not displayed.");

			// validate the Link to property in Portfolio Manager button
			try {
				boolean starbtn = driver
						.findElement(By.xpath(OR.getProperty("sustainability_utilitybills_energystarbtn_XPATH")))
						.isDisplayed();

				if (starbtn == true) {
					successMessage("The Link to property in Portfolio Manager button is displayed successfully.");
				} else {
					verificationFailedMessage("The Link to property in Portfolio Manager button is not displayed.");
				}

			} catch (Throwable t) {
				verificationFailedMessage("The Link to property in Portfolio Manager button is not displayed.");
			}

			// ***** VALIDATE DETAILS OF THE SCREEN *****

			// VALIDATE FOR PROPERTY TWO
			title("VALIDATE FOR PROPERTY TWO");

			// wait for the element
			explicitWaitClickable("navigation_header_searchicon_XPATH");

			// click on the search icon from the header
			click("navigation_header_searchicon_XPATH");

			// enter property 2 number in text field
			type("navigation_header_searchtxt_XPATH", "02");

			// hit enter key
			driver.findElement(By.xpath(OR.getProperty("navigation_header_searchtxt_XPATH"))).sendKeys(Keys.ENTER);
			consoleMessage("Hit enter key.");

			// wait for the element
			Thread.sleep(2000);

			// click on the settings icon from the top of the screen
			click("questionnaire_settingicon_CSS");

			// wait for the element
			Thread.sleep(1000);

			// click on the cancel icon
			click("questionnaire_setting_cancelicon_XPATH");

			// validate the property name
			switchVerification("navigation_header_propertyname2_XPATH", "[DND] AAAA Risk Test Prop 02 - 02",
					"The property name is not displayed.");

			// validate the Link to property in Portfolio Manager button
			try {
				boolean starbtn = driver
						.findElement(By.xpath(OR.getProperty("sustainability_utilitybills_energystarbtn_XPATH")))
						.isDisplayed();

				if (starbtn == true) {
					successMessage("The Link to property in Portfolio Manager button is displayed successfully.");
				} else {
					verificationFailedMessage("The Link to property in Portfolio Manager button is not displayed.");
				}

			} catch (Throwable t) {
				verificationFailedMessage("The Link to property in Portfolio Manager button is not displayed.");
			}

			// ***** VALIDATE DETAILS OF THE SCREEN *****

			// VALIDATE FOR PROPERTY THREE
			title("VALIDATE FOR PROPERTY THREE");

			// wait for the element
			explicitWaitClickable("navigation_header_searchicon_XPATH");

			// click on the search icon from the header
			click("navigation_header_searchicon_XPATH");

			// enter property 3 number in text field
			type("navigation_header_searchtxt_XPATH", "03");

			// hit enter key
			driver.findElement(By.xpath(OR.getProperty("navigation_header_searchtxt_XPATH"))).sendKeys(Keys.ENTER);
			consoleMessage("Hit enter key.");

			// wait for the element
			Thread.sleep(2000);

			// click on the settings icon from the top of the screen
			click("questionnaire_settingicon_CSS");

			// wait for the element
			Thread.sleep(1000);

			// click on the cancel icon
			click("questionnaire_setting_cancelicon_XPATH");

			// validate the property name
			switchVerification("navigation_header_propertyname3_XPATH", "[DND] AAAA Risk Test Prop 03 - 03",
					"The property name is not displayed.");

			// validate the Link to property in Portfolio Manager button
			try {
				boolean starbtn = driver
						.findElement(By.xpath(OR.getProperty("sustainability_utilitybills_energystarbtn_XPATH")))
						.isDisplayed();

				if (starbtn == true) {
					successMessage("The Link to property in Portfolio Manager button is displayed successfully.");
				} else {
					verificationFailedMessage("The Link to property in Portfolio Manager button is not displayed.");
				}

			} catch (Throwable t) {
				verificationFailedMessage("The Link to property in Portfolio Manager button is not displayed.");
			}

			// ***** VALIDATE DETAILS OF THE SCREEN *****

			// VALIDATE FOR PROPERTY ONE
			title("VALIDATE FOR PROPERTY ONE");

			// wait for the element
			explicitWaitClickable("navigation_header_searchicon_XPATH");

			// click on the search icon from the header
			click("navigation_header_searchicon_XPATH");

			// enter property number in text field
			type("navigation_header_searchtxt_XPATH", "01");

			// hit enter key
			driver.findElement(By.xpath(OR.getProperty("navigation_header_searchtxt_XPATH"))).sendKeys(Keys.ENTER);
			consoleMessage("Hit enter key.");

			// validate the property name
			switchVerification("navigation_header_propertyname1_XPATH", "[DND] AAAA Risk Test Prop 01 - 01",
					"The property name is not displayed.");

			// validate the Link to property in Portfolio Manager button
			try {
				boolean starbtn = driver
						.findElement(By.xpath(OR.getProperty("sustainability_utilitybills_energystarbtn_XPATH")))
						.isDisplayed();

				if (starbtn == true) {
					successMessage("The Link to property in Portfolio Manager button is displayed successfully.");
				} else {
					verificationFailedMessage("The Link to property in Portfolio Manager button is not displayed.");
				}

			} catch (Throwable t) {
				verificationFailedMessage("The Link to property in Portfolio Manager button is not displayed.");
			}

			// ***** VALIDATE DETAILS OF THE SCREEN *****

		} catch (Throwable t) {
			verificationFailed();
		}

		// click on the home icon from the top of the screen
		click("questionnaire_homeburgermenubtn_hide_CSS");

		// wait for the element
		explicitWait("propertylist_title_XPATH");

		// verify the property list
		switchVerification("propertylist_title_XPATH", "Property List", "The property list is not displayed.");

		// VALIDATE THE NAVIGATION AFTER SWITCHING THE PROPERTY FROM THE HEADER OF
		// THE SUSTAINABILITY OPTIONS SCREENS
		title("VALIDATE THE NAVIGATION AFTER SWITCHING THE PROPERTY FROM THE HEADER OF THE SUSTAINABILITY OPTIONS SCREENS");

		try {

			// click on the Sustainability icon
			click("sustainabilityicon_CSS");

			// wait for the element
			Thread.sleep(5000);

			// click on the side menu
			click("ssc_leftsidemenubtn_CSS");

			// wait for the element
			Thread.sleep(5000);

			// click on the sustainability options option
			click("sustainability_sidemenu_buildingperformancedataoption_sustainabilityoption_XPATH");

			// VALIDATE FOR PROPERTY ONE
			title("VALIDATE FOR PROPERTY ONE");

			// validate the property name
			switchVerification("navigation_header_propertyname1_XPATH", "[DND] AAAA Risk Test Prop 01 - 01",
					"The property name is not displayed.");

			// validate the Sustainability Options title
			switchVerification("navigation_sustainability_sustainabilityoptionslbl_XPATH", "Sustainability Options",
					"The Sustainability Options title is not displayed.");

			// ***** VALIDATE DETAILS OF THE SCREEN *****

			// VALIDATE FOR PROPERTY TWO
			title("VALIDATE FOR PROPERTY TWO");

			// wait for the element
			explicitWaitClickable("navigation_header_searchicon_XPATH");

			// click on the search icon from the header
			click("navigation_header_searchicon_XPATH");

			// enter property 2 number in text field
			type("navigation_header_searchtxt_XPATH", "02");

			// hit enter key
			driver.findElement(By.xpath(OR.getProperty("navigation_header_searchtxt_XPATH"))).sendKeys(Keys.ENTER);
			consoleMessage("Hit enter key.");

			// wait for the element
			Thread.sleep(2000);

			// click on the settings icon from the top of the screen
			click("questionnaire_settingicon_CSS");

			// wait for the element
			Thread.sleep(1000);

			// click on the cancel icon
			click("questionnaire_setting_cancelicon_XPATH");

			// validate the property name
			switchVerification("navigation_header_propertyname2_XPATH", "[DND] AAAA Risk Test Prop 02 - 02",
					"The property name is not displayed.");

			// validate the Sustainability Options title
			switchVerification("navigation_sustainability_sustainabilityoptionslbl_XPATH", "Sustainability Options",
					"The Sustainability Options title is not displayed.");

			// ***** VALIDATE DETAILS OF THE SCREEN *****

			// VALIDATE FOR PROPERTY THREE
			title("VALIDATE FOR PROPERTY THREE");

			// wait for the element
			explicitWaitClickable("navigation_header_searchicon_XPATH");

			// click on the search icon from the header
			click("navigation_header_searchicon_XPATH");

			// enter property 3 number in text field
			type("navigation_header_searchtxt_XPATH", "03");

			// hit enter key
			driver.findElement(By.xpath(OR.getProperty("navigation_header_searchtxt_XPATH"))).sendKeys(Keys.ENTER);
			consoleMessage("Hit enter key.");

			// wait for the element
			Thread.sleep(2000);

			// click on the settings icon from the top of the screen
			click("questionnaire_settingicon_CSS");

			// wait for the element
			Thread.sleep(1000);

			// click on the cancel icon
			click("questionnaire_setting_cancelicon_XPATH");

			// validate the property name
			switchVerification("navigation_header_propertyname3_XPATH", "[DND] AAAA Risk Test Prop 03 - 03",
					"The property name is not displayed.");

			// validate the Sustainability Options title
			switchVerification("navigation_sustainability_sustainabilityoptionslbl_XPATH", "Sustainability Options",
					"The Sustainability Options title is not displayed.");

			// ***** VALIDATE DETAILS OF THE SCREEN *****

			// VALIDATE FOR PROPERTY ONE
			title("VALIDATE FOR PROPERTY ONE");

			// wait for the element
			explicitWaitClickable("navigation_header_searchicon_XPATH");

			// click on the search icon from the header
			click("navigation_header_searchicon_XPATH");

			// enter property number in text field
			type("navigation_header_searchtxt_XPATH", "01");

			// hit enter key
			driver.findElement(By.xpath(OR.getProperty("navigation_header_searchtxt_XPATH"))).sendKeys(Keys.ENTER);
			consoleMessage("Hit enter key.");

			// validate the property name
			switchVerification("navigation_header_propertyname1_XPATH", "[DND] AAAA Risk Test Prop 01 - 01",
					"The property name is not displayed.");

			// validate the Sustainability Options title
			switchVerification("navigation_sustainability_sustainabilityoptionslbl_XPATH", "Sustainability Options",
					"The Sustainability Options title is not displayed.");

			// ***** VALIDATE DETAILS OF THE SCREEN *****

		} catch (Throwable t) {
			verificationFailed();
		}

		// click on the home icon from the top of the screen
		click("questionnaire_homeburgermenubtn_hide_CSS");

		// wait for the element
		explicitWait("propertylist_title_XPATH");

		// verify the property list
		switchVerification("propertylist_title_XPATH", "Property List", "The property list is not displayed.");

		// DELETE NEWLY CREATED DOCUMENTS/REPORTS RECORD - AT PROPERTY LEVEL
		title("DELETE NEWLY CREATED DOCUMENTS/REPORTS RECORD - AT PROPERTY LEVEL");

		try {
			// click on the Sustainability icon
			click("sustainabilityicon_CSS");

			// wait for the element
			Thread.sleep(5000);

			// click on the side menu
			click("ssc_leftsidemenubtn_CSS");

			// wait for the element
			Thread.sleep(5000);

			// click on the document/reports option
			click("sustainability_sidemenu_documentreportoption_XPATH");

			// enter the newly created document/report record in the search field
			type("sustainability_searchtxt_XPATH", data.get("documentreport_title"));

			// click on the documents/reports record
			click("navigation_sustainabilitynavigation_addeddocumentrecord1_XPATH");

			// click on the delete button
			click("sustainability_deletebtn_XPATH");

			// click on the delete button of the confirmation popup
			click("sustainability_deletebtn_confirmation_XPATH");

			// enter the updated document/report record in the search field
			type("sustainability_searchtxt_XPATH", data.get("documentreport_title"));

			// verify the deleted document/report record displayed or not
			helper.deleteVerification("navigation_sustainabilitynavigation_addeddocumentrecord1_XPATH",
					"Test Document Sustainability Title 2");

		} catch (Throwable t) {
			verificationFailed();
		}

		// click on the home icon from the top of the screen
		click("questionnaire_homeburgermenubtn_hide_CSS");

		// synchronization
		explicitWait("propertylist_title_XPATH");

		// verify the property list
		switchVerification("propertylist_title_XPATH", "Property List", "The property list is not displayed.");

		// DELETE NEWLY CREATED CERTIFICATIONS RECORD - AT PROPERTY LEVEL
		title("DELETE NEWLY CREATED CERTIFICATIONS RECORD - AT PROPERTY LEVEL");

		try {

			// click on the Sustainability icon
			click("sustainabilityicon_CSS");

			// wait for the element
			Thread.sleep(5000);

			// click on the side menu
			click("ssc_leftsidemenubtn_CSS");

			// wait for the element
			Thread.sleep(5000);

			// click on the certifications option
			click("sustainability_sidemenu_certificationsoption_XPATH");

			// enter the certification record in the search field
			type("sustainability_searchtxt_XPATH", data.get("type"));

			// click on the certification record
			click("sustainability_certification_addedtype_XPATH");

			// wait for the element
			explicitWaitClickable("sustainability_certification_deletebtn_XPATH");

			// click on the delete button
			click("sustainability_certification_deletebtn_XPATH");

			// wait for the element
			explicitWaitClickable("sustainability_certification_deletebtn_confirmation_XPATH");

			// click on the delete button of the confirmation popup
			click("sustainability_certification_deletebtn_confirmation_XPATH");

			// enter the updated certification record in the search field
			type("sustainability_searchtxt_XPATH", data.get("type"));

			// wait for the element
			explicitWaitClickable("closetoastmsg_CSS");

			// click on the toaster close button
			click("closetoastmsg_CSS");

			// verify the deleted certification record displayed or not
			helper.deleteVerification("sustainability_certification_addedtype_XPATH", "BOMA BEST");

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

			// click on the Sustainability icon
			click("sustainabilityicon_CSS");

			// wait for the element
			explicitWaitClickable("ssc_leftsidemenubtn_CSS");

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
			LocalDate deleteDate = LocalDate.now().minusMonths(6);
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
			type("sustainability_searchtxt_XPATH", utilityBills);

			// verify the deleted utility bill record displayed or not
			try {

				String UtilityBills1 = "//td[contains(text(),'" + utilityBills + "')]";
				String utilityBills1 = (driver.findElement(By.xpath(UtilityBills1)).getText()).trim();

				if (utilityBills1.equals(utilityBills)) {

					verificationFailedMessage("The utility bill is not deleted.");

				} else {
					successMessage("The utility bill is deleted successfully.");
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

		// DELETE ALL THE UTILITY METER RECORDS
		title("DELETE ALL THE UTILITY METER RECORDS");

		try {

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

			try {
				String pages = driver.findElement(By.xpath("(//strong)[1]")).getText();
				String[] arrOfStr = pages.split(" ");
				String pageno = arrOfStr[3];
				int pagecount = Integer.parseInt(pageno);

				for (int i = 0; i < pagecount; i++) {

					List<WebElement> meter = driver.findElements(By.xpath("//i[@ng-click='setToDelete(meter)']"));
					int meternum = meter.size();

					for (int j = 0; j < meternum; j++) {

						// wait for the element
						explicitWaitClickable("sustainability_utilitymeter_deletefirstrecord_XPATH");

						// click on the delete button
						click("sustainability_utilitymeter_deletefirstrecord_XPATH");

						// wait for the element
						explicitWaitClickable("sustainability_utilitymeter_deletebtn_confirmation_XPATH");

						// click on the delete button of the confirmation popup modal
						click("sustainability_utilitymeter_deletebtn_confirmation_XPATH");

					}

				}
			} catch (Throwable t) {
				verificationFailedMessage("The deleting process of the meter caused some issue.");
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
