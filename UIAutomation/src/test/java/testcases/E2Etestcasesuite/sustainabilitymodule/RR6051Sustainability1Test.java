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

public class RR6051Sustainability1Test extends TestBase {

	@Test(dataProviderClass = TestUtil.class, dataProvider = "dp")
	public void rR6051Sustainability1Test(Hashtable<String, String> data) throws IOException, InterruptedException {

		execution(data, "rR6051Sustainability1Test");

		// PERFORMED CRUD OPERATION OF THE CONSUMPTION ANALYSIS MODULE - AT PROPERTY
		// LEVEL
		title("PERFORMED CRUD OPERATION OF THE CONSUMPTION ANALYSIS MODULE - AT PROPERTY LEVEL");

		// refresh the page
		driver.navigate().refresh();
		explicitWait("sustainabilityicon_CSS");
		driver.navigate().refresh();

		// CREATE NEW CONSUMPTION ANALYSIS RECORD
		title("CREATE NEW CONSUMPTION ANALYSIS RECORD");

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

			// select the option of the Analysis Type
			select("sustainability_consumptionanalysis_analysistypedd_XPATH", data.get("analysis_type"));

			// select the option of the meter number
			select("sustainability_consumptionanalysis_meternumberdd_XPATH", data.get("meter_option1"));

			// click on the monthly radio button of the data to use field
			click("sustainability_consumptionanalysis_datatousemonthly_XPATH");

			// select the option of the Weather Station
			select("sustainability_consumptionanalysis_weatherstationdd_XPATH", data.get("weather_station"));

			// select the option of the Temperature Units
			select("sustainability_consumptionanalysis_tempratureunitdd_XPATH", data.get("temprature_unit"));

			// enter the base temperature
			type("sustainability_consumptionanalysis_basetemprature_XPATH", "25");

			// enter the date in the from date field
			LocalDate currentDate = LocalDate.now();
			String currentDate_String = currentDate.toString();
			type("sustainability_consumptionanalysis_fromdate_XPATH", currentDate_String);

			// enter the date in the to date field
			LocalDate futureDate = LocalDate.now().plusDays(5);
			String futureDate_String = futureDate.toString();
			type("sustainability_consumptionanalysis_todate_XPATH", futureDate_String);

			// validate the information text is displayed or not
			try {
				boolean info = driver
						.findElement(By.xpath(OR.getProperty("sustainability_consumptionanalysis_information_XPATH")))
						.isDisplayed();
				if (info == true) {

					successMessage("The information text is displayed successfully.");

				} else {

					verificationFailedMessage("The information text is not displayed");

				}
			} catch (Throwable t) {
				verificationFailedMessage("The information text is not displayed");
			}

			// click on the save button
			click("sustainability_consumptionanalysis_savebtn_XPATH");

			// wait for the element
			explicitWaitClickable("closetoastmsg_CSS");

			// click on the toaster close button
			click("closetoastmsg_CSS");

			// click on the back button
			click("sustainability_consumptionanalysis_backbtn_XPATH");

			// enter newly created record
			type("sustainability_consumptionanalysis_searchtxt_XPATH", random1);

			// validate newly created record is displayed or not
			try {
				String searchedRecord = "//td[text()='" + random1 + "']";

				boolean actual_searchedRecord = driver.findElement(By.xpath(searchedRecord)).isDisplayed();

				if (actual_searchedRecord == true) {

					successMessage("The newly created record is displayed successfully.");

				} else {

					verificationFailedMessage("The newly created record is not displayed");

				}
			} catch (Throwable t) {
				verificationFailedMessage("The newly created record is not displayed");
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

		// UPDATE THE NEWLY CREATED CONSUMPTION ANALYSIS RECORD
		title("UPDATE THE NEWLY CREATED CONSUMPTION ANALYSIS RECORD");

		String random2 = RandomStringUtils.randomAlphabetic(8);

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

			// enter newly created record
			type("sustainability_consumptionanalysis_searchtxt_XPATH", random1);

			// click on the newly created record
			String searchedRecord1 = "//td[text()='" + random1 + "']";
			driver.findElement(By.xpath(searchedRecord1)).click();

			// enter the title in the field
			type("sustainability_consumptionanalysis_titletxt_XPATH", random2);

			// select the option of the utility type
			select("sustainability_consumptionanalysis_utilitytypedd_XPATH", data.get("update_utility_type"));

			// select the option of the Analysis Type
			select("sustainability_consumptionanalysis_analysistypedd_XPATH", data.get("update_analysis_type"));

			// select the option of the meter number
			select("sustainability_consumptionanalysis_meternumberdd_XPATH", data.get("update_meter_option1"));

			// click on the daily radio button of the data to use field
			click("sustainability_consumptionanalysis_datatousedaily_XPATH");

			// select the option of the Temperature Units
			select("sustainability_consumptionanalysis_tempratureunitdd_XPATH", data.get("update_temprature_unit"));

			// enter the date in the from date field
			LocalDate currentDate = LocalDate.now();
			String currentDate_String = currentDate.toString();
			type("sustainability_consumptionanalysis_fromdate_XPATH", currentDate_String);

			// enter the date in the to date field
			LocalDate futureDate = LocalDate.now().plusDays(8);
			String futureDate_String = futureDate.toString();
			type("sustainability_consumptionanalysis_todate_XPATH", futureDate_String);

			// scroll down the screen
			scrollBottom();

			// click on the checkbox of the weekend
			click("sustainability_consumptionanalysis_weekendsckbx_XPATH");

			// validate the information text is displayed or not
			try {
				boolean info = driver
						.findElement(By.xpath(OR.getProperty("sustainability_consumptionanalysis_information_XPATH")))
						.isDisplayed();
				if (info == true) {

					verificationFailedMessage("The information text is not displayed as expected.");

				} else {

					successMessage("The information text is not displayed as expected.");

				}
			} catch (Throwable t) {
				successMessage("The information text is not displayed as expected.");

			}

			// click on the save button
			click("sustainability_consumptionanalysis_savebtn_XPATH");

			// wait for the element
			explicitWaitClickable("closetoastmsg_CSS");

			// click on the toaster close button
			click("closetoastmsg_CSS");

			// click on the back button
			click("sustainability_consumptionanalysis_backbtn_XPATH");

			// enter newly created record
			type("sustainability_consumptionanalysis_searchtxt_XPATH", random2);

			// validate newly created record is displayed or not
			try {
				String updatedSearchedRecord = "//td[text()='" + random2 + "']";

				boolean actual_updatedSearchedRecord = driver.findElement(By.xpath(updatedSearchedRecord))
						.isDisplayed();

				if (actual_updatedSearchedRecord == true) {

					successMessage("The updated record is displayed successfully.");

				} else {

					verificationFailedMessage("The updated record is not displayed");

				}
			} catch (Throwable t) {
				verificationFailedMessage("The updated record is not displayed");
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

		// DELETE THE UPDATED CONSUMPTION ANALYSIS RECORD
		title("DELETE THE UPDATED CONSUMPTION ANALYSIS RECORD");

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

			// enter newly created record
			type("sustainability_consumptionanalysis_searchtxt_XPATH", random2);

			// click on the newly created record
			String searchedRecord2 = "//td[text()='" + random2 + "']";
			driver.findElement(By.xpath(searchedRecord2)).click();

			// wait for the element
			Thread.sleep(5000);

			// click on the delete button
			click("sustainability_consumptionanalysis_deletebtn_XPATH");

			// wait for the element
			Thread.sleep(5000);

			// click on the delete button of confirmation popup model
			click("sustainability_consumptionanalysis_confirmationdeletebtn_XPATH");

			// wait for the element
			Thread.sleep(5000);

			// enter newly created record
			type("sustainability_consumptionanalysis_searchtxt_XPATH", random2);

			// validate newly created record is displayed or not
			try {
				String updatedSearchedRecord = "//td[text()='" + random2 + "']";

				boolean actual_updatedSearchedRecord = driver.findElement(By.xpath(updatedSearchedRecord))
						.isDisplayed();

				if (actual_updatedSearchedRecord == true) {

					verificationFailedMessage("The deleted record is displayed");

				} else {

					successMessage("The deleted record is not displayed as expected.");

				}
			} catch (Throwable t) {
				successMessage("The deleted record is not displayed as expected.");
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