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
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.testng.Reporter;
import org.testng.SkipException;
import org.testng.annotations.Test;

import com.relevantcodes.extentreports.LogStatus;

import base.TestBase;
import utilities.ExcelReader;
import utilities.TestUtil;

public class RR5961Sustainability4Test extends TestBase {

	@Test(dataProviderClass = TestUtil.class, dataProvider = "dp")
	public void rR5961Sustainability4Test(Hashtable<String, String> data) throws IOException, InterruptedException {

		execution(data, "rR5961Sustainability4Test");

		// PERFORMED IMPORT AND EXPORT OPERATION OF THE UTILITY METERS RECORDS
		title("PERFORMED IMPORT AND EXPORT OPERATION OF THE UTILITY METERS RECORDS");

		// refresh the page
		driver.navigate().refresh();
		Thread.sleep(5000);
		driver.navigate().refresh();

		// DELETE ALL THE UTILITY METER RECORDS BEFORE STARTING THE TEST CASE
		title("DELETE ALL THE UTILITY METER RECORDS BEFORE STARTING THE TEST CASE");

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
						Thread.sleep(3000);

						// click on the delete button
						click("sustainability_utilitymeter_deletefirstrecord_XPATH");

						// wait for the element
						Thread.sleep(3000);

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

		// CREATE NEW UTILITY METERS RECORDS RANDOMLY BETWEEN 3 TO 7 RECORDS
		title("CREATE NEW UTILITY METERS RECORDS RANDOMLY BETWEEN 3 TO 7 RECORDS");

		String utilityMeter = RandomStringUtils.randomAlphanumeric(8);
		String updateUtilityMeter1 = RandomStringUtils.randomAlphanumeric(8);
		String updateUtilityMeter2 = RandomStringUtils.randomAlphanumeric(8);
		Random random = new Random();
		int meterCount = random.nextInt(7 - 3) + 3;
		int areaCoverRandom = random.nextInt(100 - 10) + 10;
		int updateAreaCoverRandom1 = random.nextInt(200 - 101) + 101;
		String updateAreaCoverRandom1_String = Integer.toString(updateAreaCoverRandom1);
		int updateAreaCoverRandom2 = random.nextInt(300 - 201) + 201;
		String updateAreaCoverRandom2_String = Integer.toString(updateAreaCoverRandom2);

		String fetch1 = null;
		String fetch2 = null;
		String fetch3 = null;
		String fetch4 = null;

		String fetch5 = null;
		String fetch6 = null;
		String fetch7 = null;
		String fetch8 = null;

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

			for (int i = 0; i < meterCount; i++) {

				// click on the add button
				click("sustainability_utilitymeter_addbtn_XPATH");

				// enter the meter number
				type("sustainability_utilitymeter_metertxt_XPATH", utilityMeter + i);

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
				String areaCoverRandom_String = Integer.toString(areaCoverRandom);
				type("sustainability_utilitymeter_areacoveredtxt_XPATH", areaCoverRandom_String);

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
				type("sustainability_searchtxt_XPATH", utilityMeter + i);

				// verify the newly created utility meter record
				try {
					String UtilityMeter = "//td[text()='" + utilityMeter + i + "']";
					String addedUtilityMeter = (driver.findElement(By.xpath(UtilityMeter)).getText()).trim();
					if (addedUtilityMeter.equals(utilityMeter + i)) {
						successMessage("The utility meter is verified successfully.");
					} else {
						verificationFailedMessage("The utility meter is not verified.");
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

		// EXPORT THE ALL THE RECORDS AND IMPORT THE UPDATED DETAILS OF THE METER
		title("EXPORT THE ALL THE RECORDS AND IMPORT THE UPDATED DETAILS OF THE METER");

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

			// click on the document icon
			click("sustainability_utilitymeters_documenticon_XPATH");

			// wait for the element
			Thread.sleep(3000);

			// click on the extract option
			click("sustainability_utilitymeters_documenticon_extractoption_XPATH");

			// wait for the element
			Thread.sleep(3000);

			// click on the property field
			click("sustainability_utilitymeters_documenticon_propertybtn_XPATH");

			// click on the none button
			click("sustainability_utilitymeters_documenticon_nonebtn_XPATH");

			// enter property name in the search field
			type("sustainability_utilitymeters_documenticon_searchtxt_XPATH", data.get("property_1"));

			// click on the searched property name
			String searchedProperty = "//div[@ng-click='addOrRemoveToSelected(item)']//span[text()='"
					+ data.get("property_1") + "']";
			driver.findElement(By.xpath(searchedProperty)).click();

			// click on the property field
			click("sustainability_utilitymeters_documenticon_propertybtn_XPATH");

			// wait for the element
			Thread.sleep(5000);

			// click on the extract button
			click("sustainability_utilitymeters_documenticon_extractbtn_XPATH");

			// wait for the element
			Thread.sleep(5000);

			// fetch the record from the download file
			File downloaded = getLastModified(config.getProperty("downloadFilePath"));
			String path_string = downloaded.toString();
			consoleMessage(path_string);

			ExcelReader file = new ExcelReader(path_string);

			// update the details of the first record from the list
			file.setCellData("Utility Meters", "Meter #", 2, updateUtilityMeter1);
			file.setCellData("Utility Meters", "Utility Type", 2, data.get("update_utility_type"));
			file.setCellData("Utility Meters", "Area Covered by Meter", 2, updateAreaCoverRandom1_String);
			file.setCellData("Utility Meters", "Description", 2, data.get("update_description"));

			// update the details of the third record from the list
			file.setCellData("Utility Meters", "Meter #", 4, updateUtilityMeter2);
			file.setCellData("Utility Meters", "Utility Type", 4, data.get("update_utility_type"));
			file.setCellData("Utility Meters", "Area Covered by Meter", 4, updateAreaCoverRandom2_String);
			file.setCellData("Utility Meters", "Description", 4, data.get("update_description"));

			// get the details of first record from the list
			fetch1 = file.getCellData("Utility Meters", "Meter #", 2);
			fetch2 = file.getCellData("Utility Meters", "Utility Type", 2);
			fetch3 = file.getCellData("Utility Meters", "Area Covered by Meter", 2);
			fetch4 = file.getCellData("Utility Meters", "Description", 2);

			// get the details of third record from the list
			fetch5 = file.getCellData("Utility Meters", "Meter #", 4);
			fetch6 = file.getCellData("Utility Meters", "Utility Type", 4);
			fetch7 = file.getCellData("Utility Meters", "Area Covered by Meter", 4);
			fetch8 = file.getCellData("Utility Meters", "Description", 4);

			consoleMessage("fetch1:::::::::::::::" + fetch1);
			consoleMessage("fetch2:::::::::::::::" + fetch2);
			consoleMessage("fetch3:::::::::::::::" + fetch3);
			consoleMessage("fetch4:::::::::::::::" + fetch4);
			consoleMessage("fetch5:::::::::::::::" + fetch5);
			consoleMessage("fetch6:::::::::::::::" + fetch6);
			consoleMessage("fetch7:::::::::::::::" + fetch7);
			consoleMessage("fetch8:::::::::::::::" + fetch8);

			// wait for the element
			Thread.sleep(5000);

			// click on the document icon
			click("sustainability_utilitymeters_documenticon_XPATH");

			// wait for the element
			Thread.sleep(5000);

			// click on the import option
			click("sustainability_utilitymeters_documenticon_importoption_XPATH");

			// import the file
			uploadFile(path_string);

			// wait for the element
			Thread.sleep(10000);

			try {
				// enter the updated meter number 1 in search field
				type("sustainability_searchtxt_XPATH", fetch1);

				// verify imported record of the meter number 1 is displayed with updated
				// details
				try {
					String validation1 = "//td[text()='" + updateUtilityMeter1 + "']";
					String validation1_actual = driver.findElement(By.xpath(validation1)).getText();

					if (validation1_actual.equals(updateUtilityMeter1)) {
						successMessage("The meter number 1 is updated successfully.");
					} else {
						verificationFailedMessage("The meter number 1 is not updated.");
					}
				} catch (Throwable t) {
					verificationFailedMessage("The meter number 1 is not updated.");
				}

				// verify imported record of the Utility 1 is displayed with updated details
				try {
					String validation2 = "//td[text()='" + updateUtilityMeter1 + "']//following-sibling::td[text()='"
							+ data.get("update_utility_type") + "']";

					String validation2_actual = driver.findElement(By.xpath(validation2)).getText();

					if (validation2_actual.equals(data.get("update_utility_type"))) {
						successMessage("The Utility 1 is updated successfully.");
					} else {
						verificationFailedMessage("The Utility 1 is not updated.");
					}
				} catch (Throwable t) {
					verificationFailedMessage("The Utility 1 is not updated.");
				}

				// verify imported record of the Area Covered 1 is displayed with updated
				// details
				try {
					String validation3 = "//td[text()='" + updateUtilityMeter1 + "']//following-sibling::td[text()='"
							+ updateAreaCoverRandom1_String + "']";

					String validation3_actual = driver.findElement(By.xpath(validation3)).getText();

					if (validation3_actual.equals(updateAreaCoverRandom1_String)) {
						successMessage("The Area Covered 1 is updated successfully.");
					} else {
						verificationFailedMessage("The Area Covered 1 is not updated.");
					}
				} catch (Throwable t) {
					verificationFailedMessage("The Area Covered 1 is not updated.");
				}

				// verify imported record of the description 1 is displayed with updated
				// details
				try {
					String validation4 = "//td[text()='" + updateUtilityMeter1 + "']//following-sibling::td[text()='"
							+ data.get("update_description") + "']";

					String validation4_actual = driver.findElement(By.xpath(validation4)).getText();

					if (validation4_actual.equals(data.get("update_description"))) {
						successMessage("The description 1 is updated successfully.");
					} else {
						verificationFailedMessage("The description 1 is not updated.");
					}
				} catch (Throwable t) {
					verificationFailedMessage("The description 1 is not updated.");
				}

			} catch (Throwable t) {
				verificationFailedMessage("The correct updated record is not found after import the file.");
			}

			try {
				// enter the updated meter number 2 in search field
				type("sustainability_searchtxt_XPATH", fetch5);

				// verify imported record of the meter number 2 is displayed with updated
				// details
				try {
					String validation5 = "//td[text()='" + updateUtilityMeter2 + "']";

					String validation5_actual = driver.findElement(By.xpath(validation5)).getText();

					if (validation5_actual.equals(updateUtilityMeter2)) {
						successMessage("The meter number 2 is updated successfully.");
					} else {
						verificationFailedMessage("The meter number 2 is not updated.");
					}
				} catch (Throwable t) {
					verificationFailedMessage("The meter number 2 is not updated.");
				}

				// verify imported record of the Utility 2 is displayed with updated details
				try {
					String validation6 = "//td[text()='" + updateUtilityMeter2 + "']//following-sibling::td[text()='"
							+ data.get("update_utility_type") + "']";

					String validation6_actual = driver.findElement(By.xpath(validation6)).getText();

					if (validation6_actual.equals(data.get("update_utility_type"))) {
						successMessage("The Utility 2 is updated successfully.");
					} else {
						verificationFailedMessage("The Utility 2 is not updated.");
					}
				} catch (Throwable t) {
					verificationFailedMessage("The Utility 2 is not updated.");
				}

				// verify imported record of the Area Covered 2 is displayed with updated
				// details
				try {
					String validation7 = "//td[text()='" + updateUtilityMeter2 + "']//following-sibling::td[text()='"
							+ updateAreaCoverRandom2_String + "']";

					String validation7_actual = driver.findElement(By.xpath(validation7)).getText();

					if (validation7_actual.equals(updateAreaCoverRandom2_String)) {
						successMessage("The Area Covered 2 is updated successfully.");
					} else {
						verificationFailedMessage("The Area Covered 2 is not updated.");
					}
				} catch (Throwable t) {
					verificationFailedMessage("The Area Covered 2 is not updated.");
				}

				// verify imported record of the description 2 is displayed with updated
				// details
				try {
					String validation8 = "//td[text()='" + updateUtilityMeter2 + "']//following-sibling::td[text()='"
							+ data.get("update_description") + "']";

					String validation8_actual = driver.findElement(By.xpath(validation8)).getText();

					if (validation8_actual.equals(data.get("update_description"))) {
						successMessage("The description 2 is updated successfully.");
					} else {
						verificationFailedMessage("The description 2 is not updated.");
					}
				} catch (Throwable t) {
					verificationFailedMessage("The description 2 is not updated.");
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

		// DELETE ALL THE UTILITY METER RECORDS
		title("DELETE ALL THE UTILITY METER RECORDS");

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
						Thread.sleep(3000);

						// click on the delete button
						click("sustainability_utilitymeter_deletefirstrecord_XPATH");

						// wait for the element
						Thread.sleep(3000);

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