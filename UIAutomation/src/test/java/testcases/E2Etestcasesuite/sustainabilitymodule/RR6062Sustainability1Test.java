package testcases.E2Etestcasesuite.sustainabilitymodule;

import java.io.IOException;
import java.time.LocalDate;
import java.util.Hashtable;
import java.util.Random;

import org.apache.commons.lang3.RandomStringUtils;
import org.openqa.selenium.By;
import org.testng.SkipException;
import org.testng.annotations.Test;

import base.TestBase;
import utilities.TestUtil;

public class RR6062Sustainability1Test extends TestBase {

	@Test(dataProviderClass = TestUtil.class, dataProvider = "dp")
	public void rR6062Sustainability1Test(Hashtable<String, String> data) throws IOException, InterruptedException {

		execution(data, "rR6062Sustainability1Test");

		// PERFORMED CRUD OPERATION OF THE PERFORMANCE TARGETS MODULE - AT PROPERTY
		// LEVEL
		title("PERFORMED CRUD OPERATION OF THE PERFORMANCE TARGETS MODULE - AT PROPERTY LEVEL");

		// refresh the page
		driver.navigate().refresh();
		explicitWait("sustainabilityicon_CSS");
		driver.navigate().refresh();

		// CREATE NEW PERFORMANCE TARGETS RECORD
		title("CREATE NEW PERFORMANCE TARGETS RECORD");

		Random random = new Random();
		int percentage_int = random.nextInt(99 - 11) + 11;
		String percentage = Integer.toString(percentage_int);
		String percentage1 = Integer.toString(percentage_int);

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

			// click on the building performance data
			click("sustainability_utilitybills_buildingperformancedataoption_XPATH");

			// click on the Performance Targets
			click("sustainability_performancetargets_sideoption_XPATH");

			// click on the add button
			click("sustainability_performancetargets_addbtn_XPATH");

			// select the option of the utility type
			select("sustainability_performancetargets_utilitytargettypedd_XPATH", data.get("utility_type"));

			// select the option of the Period
			select("sustainability_performancetargets_perioddd_XPATH", data.get("period"));

			// enter the year in the baseline year field
			LocalDate currentDate = LocalDate.now();
			String currentDate_String = currentDate.toString();
			String[] currentDate_arr = currentDate_String.split("-");
			String currentYear = currentDate_arr[0];
			type("sustainability_performancetargets_baselineyeartxt_XPATH", currentYear);

			// enter the year in the target year field
			LocalDate futureDate = LocalDate.now().plusYears(5);
			String futureDate_String = futureDate.toString();
			String[] futureDate_arr = futureDate_String.split("-");
			String futureYear = futureDate_arr[0];
			type("sustainability_performancetargets_targetyeartxt_XPATH", futureYear);

			// select the month in the target month field
			select("sustainability_performancetargets_targetmonthtxt_XPATH", data.get("month"));

			// enter the percentage in the reduction percentage
			type("sustainability_performancetargets_reductionpercentagetxt_XPATH", percentage);

			// click on the save button
			click("sustainability_performancetargets_savebtn_XPATH");

			// wait for the element
			explicitWaitClickable("closetoastmsg_CSS");

			// click on the toaster close button
			click("closetoastmsg_CSS");

			// enter newly created record
			type("sustainability_performancetargets_searchtxt_XPATH", percentage);

			// validate newly created record is displayed or not
			try {
				String searchedRecord = "//td[text()='" + percentage + "']";

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

		// UPDATE THE NEWLY CREATED PERFORMANCE TARGETS RECORD
		title("UPDATE THE NEWLY CREATED PERFORMANCE TARGETS RECORD");

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

			// click on the building performance data
			click("sustainability_utilitybills_buildingperformancedataoption_XPATH");

			// click on the Performance Targets
			click("sustainability_performancetargets_sideoption_XPATH");

			// enter newly created record
			type("sustainability_performancetargets_searchtxt_XPATH", percentage);

			// click on the newly created record
			String searchedRecord = "//td[text()='" + percentage + "']";
			driver.findElement(By.xpath(searchedRecord)).click();

			// select the option of the utility type
			select("sustainability_performancetargets_utilitytargettypedd_XPATH", data.get("update_utility_type"));

			// select the option of the Period
			select("sustainability_performancetargets_perioddd_XPATH", data.get("update_period"));

			// enter the year in the baseline year field
			LocalDate currentDate = LocalDate.now().minusYears(2);
			String currentDate_String = currentDate.toString();
			String[] currentDate_arr = currentDate_String.split("-");
			String currentYear = currentDate_arr[0];
			type("sustainability_performancetargets_baselineyeartxt_XPATH", currentYear);

			// enter the year in the target year field
			LocalDate futureDate = LocalDate.now().plusDays(2);
			String futureDate_String = futureDate.toString();
			String[] futureDate_arr = futureDate_String.split("-");
			String futureYear = futureDate_arr[0];
			type("sustainability_performancetargets_targetyeartxt_XPATH", futureYear);

			// enter the percentage in the reduction percentage
			type("sustainability_performancetargets_reductionpercentagetxt_XPATH", percentage1);

			// click on the save button
			click("sustainability_performancetargets_savebtn_XPATH");

			// wait for the element
			explicitWaitClickable("closetoastmsg_CSS");

			// click on the toaster close button
			click("closetoastmsg_CSS");

			// enter newly created record
			type("sustainability_performancetargets_searchtxt_XPATH", percentage1);

			// validate newly created record is displayed or not
			try {
				String searchedRecord1 = "//td[text()='" + percentage1 + "']";

				boolean actual_searchedRecord1 = driver.findElement(By.xpath(searchedRecord1)).isDisplayed();

				if (actual_searchedRecord1 == true) {

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

		// DELETE THE UPDATED PERFORMANCE TARGETS RECORD
		title("DELETE THE UPDATED PERFORMANCE TARGETS RECORD");

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

			// click on the building performance data
			click("sustainability_utilitybills_buildingperformancedataoption_XPATH");

			// click on the Performance Targets
			click("sustainability_performancetargets_sideoption_XPATH");

			// enter newly created record
			type("sustainability_performancetargets_searchtxt_XPATH", percentage1);

			// click on the newly created record
			String searchedRecord1 = "//td[text()='" + percentage1 + "']";
			driver.findElement(By.xpath(searchedRecord1)).click();

			// wait for the element
			explicitWaitClickable("sustainability_performancetargets_deletebn_XPATH");

			// click on the delete button
			click("sustainability_performancetargets_deletebn_XPATH");

			// wait for the element
			explicitWaitClickable("sustainability_performancetargets_confirmationdeletebn_XPATH");

			// click on the delete button of confirmation popup model
			click("sustainability_performancetargets_confirmationdeletebn_XPATH");

			// wait for the element
			Thread.sleep(5000);

			try {
				boolean deletebtn = driver
						.findElement(By
								.xpath(OR.getProperty("sustainability_performancetargets_confirmationdeletebn_XPATH")))
						.isDisplayed();

				if (deletebtn == true) {

					verificationFailedMessage(
							"The confirmation message for the delete PERFORMANCE TARGETS is displayed after delete the record.");

					// click on the close button of confirmation popup model
					click("sustainability_performancetargets_closebtn_XPATH");

				} else {
					successMessage(
							"The confirmation message for the delete PERFORMANCE TARGETS is not displayed after delete the record.");
				}

			} catch (Throwable t) {
				successMessage(
						"The confirmation message for the delete PERFORMANCE TARGETS is not displayed after delete the record.");
			}

			// enter newly created record
			type("sustainability_performancetargets_searchtxt_XPATH", percentage1);

			// validate newly created record is displayed or not
			try {
				String updatedSearchedRecord1 = "//td[text()='" + percentage1 + "']";

				boolean actual_updatedSearchedRecord1 = driver.findElement(By.xpath(updatedSearchedRecord1))
						.isDisplayed();

				if (actual_updatedSearchedRecord1 == true) {

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