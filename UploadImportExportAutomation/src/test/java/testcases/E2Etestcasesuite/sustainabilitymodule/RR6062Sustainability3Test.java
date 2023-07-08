package testcases.E2Etestcasesuite.sustainabilitymodule;

import java.io.File;
import java.io.IOException;
import java.time.LocalDate;
import java.util.Hashtable;
import java.util.List;
import java.util.Random;

import org.apache.commons.lang3.RandomStringUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.SkipException;
import org.testng.annotations.Test;

import base.TestBase;
import utilities.ExcelReader;
import utilities.TestUtil;

public class RR6062Sustainability3Test extends TestBase {

	@Test(dataProviderClass = TestUtil.class, dataProvider = "dp")
	public void rR6062Sustainability3Test(Hashtable<String, String> data) throws IOException, InterruptedException {

		execution(data, "rR6062Sustainability3Test");

		// VALIDATE THE EXPORT FILE FEATURE

		title("VALIDATE THE EXPORT FILE FEATURE");

		// refresh the page
		driver.navigate().refresh();
		explicitWait("sustainabilityicon_CSS");
		driver.navigate().refresh();

		System.out.println("Navigate to the Home Screen i.e. Property List Screen.");

		// CREATE THE RANDOM NUMBER OF THE PERFORMANCE TARGETS RECORD

		title("CREATE THE RANDOM NUMBER OF THE PERFORMANCE TARGETS RECORD");

		Random random = new Random();
		int count = random.nextInt(5 - 3) + 3;

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

			// click on the building performance data
			click("sustainability_utilitybills_buildingperformancedataoption_XPATH");
			ngDriver.waitForAngularRequestsToFinish();
			System.out.println("Clicked on the building performance data.");

			// click on the Performance Targets
			click("sustainability_performancetargets_sideoption_XPATH");
			ngDriver.waitForAngularRequestsToFinish();
			System.out.println("Clicked on the Performance Targets.");

			for (int i = 0; i < count; i++) {

				// click on the add button
				click("sustainability_performancetargets_addbtn_XPATH");
				ngDriver.waitForAngularRequestsToFinish();
				System.out.println("Clicked on the add button.");

				// select the option of the utility type
				select("sustainability_performancetargets_utilitytargettypedd_XPATH", data.get("utility_type"));
				ngDriver.waitForAngularRequestsToFinish();
				System.out.println("Selected the option of the utility type.");

				// select the option of the Period
				select("sustainability_performancetargets_perioddd_XPATH", data.get("period"));
				ngDriver.waitForAngularRequestsToFinish();
				System.out.println("Selected the option of the Period.");

				// enter the year in the baseline year field
				LocalDate currentDate = LocalDate.now();
				String currentDate_String = currentDate.toString();
				String[] currentDate_arr = currentDate_String.split("-");
				String currentYear = currentDate_arr[0];
				clear("sustainability_performancetargets_baselineyeartxt_XPATH");
				type("sustainability_performancetargets_baselineyeartxt_XPATH", currentYear);
				ngDriver.waitForAngularRequestsToFinish();
				System.out.println("Entered the year in the baseline year field.");

				// enter the year in the target year field
				LocalDate futureDate = LocalDate.now().plusYears(5);
				String futureDate_String = futureDate.toString();
				String[] futureDate_arr = futureDate_String.split("-");
				String futureYear = futureDate_arr[0];
				clear("sustainability_performancetargets_targetyeartxt_XPATH");
				type("sustainability_performancetargets_targetyeartxt_XPATH", futureYear);
				ngDriver.waitForAngularRequestsToFinish();
				System.out.println("Entered the year in the target year field.");

				// select the month in the target month field
				select("sustainability_performancetargets_targetmonthtxt_XPATH", data.get("month"));
				ngDriver.waitForAngularRequestsToFinish();
				System.out.println("Selected the month in the target month field.");

				// enter the percentage in the reduction percentage
				String percentage = RandomStringUtils.randomNumeric(2);
				clear("sustainability_performancetargets_reductionpercentagetxt_XPATH");
				type("sustainability_performancetargets_reductionpercentagetxt_XPATH", percentage);
				ngDriver.waitForAngularRequestsToFinish();
				System.out.println("Entered the percentage in the reduction percentage.");

				// click on the save button
				click("sustainability_performancetargets_savebtn_XPATH");
				ngDriver.waitForAngularRequestsToFinish();
				System.out.println("Clicked on the save button.");

				// wait for the element
				explicitWaitClickable("closetoastmsg_CSS");

				// click on the toaster close button
				click("closetoastmsg_CSS");
				ngDriver.waitForAngularRequestsToFinish();
				System.out.println("Clicked on the toaster close button.");

				// enter newly created record
				clear("sustainability_performancetargets_searchtxt_XPATH");
				type("sustainability_performancetargets_searchtxt_XPATH", percentage);
				ngDriver.waitForAngularRequestsToFinish();
				System.out.println("Entered newly created record.");

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

		// EXPORT THE FILE AND VALIDATE

		title("EXPORT THE FILE AND VALIDATE");

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

			// click on the building performance data
			click("sustainability_utilitybills_buildingperformancedataoption_XPATH");
			ngDriver.waitForAngularRequestsToFinish();
			System.out.println("Clicked on the building performance data.");

			// click on the Performance Targets
			click("sustainability_performancetargets_sideoption_XPATH");
			ngDriver.waitForAngularRequestsToFinish();
			System.out.println("Clicked on the Performance Targets.");

			// click on the extract button
			click("sustainability_performancetargets_actionbtn_XPATH");
			ngDriver.waitForAngularRequestsToFinish();
			System.out.println("Clicked on the extract button.");

			// fetch the record from the download file
			File downloaded = getLastModified("C:\\Users\\Jinesh\\Downloads");
			String path_string = downloaded.toString();
			System.out.println(path_string);

			ExcelReader file = new ExcelReader(path_string);

			// validate the count of the row is displayed correctly or not
			try {
				int actualRowCount = file.getRowCount("Sheet0");
				if ((actualRowCount - 1) == count) {

					successMessage("The Performance Targets record count is displayed correctly.");

				} else {
					verificationFailedMessage("The Performance Targets record count is not displayed correctly.");
				}
			} catch (Throwable t) {
				verificationFailedMessage("The Performance Targets record count is not displayed correctly.");
			}

		} catch (Throwable t) {
			verificationFailed();
		}

		// DELETE ALL THE PERFORMANCE TARGETS RECORDS

		title("DELETE ALL THE PERFORMANCE TARGETS RECORDS");

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

			// click on the building performance data
			click("sustainability_utilitybills_buildingperformancedataoption_XPATH");
			ngDriver.waitForAngularRequestsToFinish();
			System.out.println("Clicked on the building performance data.");

			// click on the Performance Targets
			click("sustainability_performancetargets_sideoption_XPATH");
			ngDriver.waitForAngularRequestsToFinish();
			System.out.println("Clicked on the Performance Targets.");

			try {
				List<WebElement> percentageTarget = driver
						.findElements(By.xpath("//table[@class='table table-striped table-hover']//tbody//tr"));
				int percentageTargetCount = percentageTarget.size();

				for (int i = 0; i < percentageTargetCount; i++) {

					// click on the first record of the performance targets
					click("sustainability_performancetargets_firstrecord_XPATH");
					ngDriver.waitForAngularRequestsToFinish();
					System.out.println("Clicked on the first record of the performance targets.");

					// wait for the element
					explicitWaitClickable("sustainability_performancetargets_deletebn_XPATH");

					// click on the delete button
					click("sustainability_performancetargets_deletebn_XPATH");
					ngDriver.waitForAngularRequestsToFinish();
					System.out.println("Clicked on the delete button.");

					// wait for the element
					explicitWaitClickable("sustainability_performancetargets_confirmationdeletebn_XPATH");

					// click on the delete button of confirmation popup model
					click("sustainability_performancetargets_confirmationdeletebn_XPATH");
					ngDriver.waitForAngularRequestsToFinish();
					System.out.println("Clicked on the delete button of confirmation popup model.");

					// wait for the element
					explicitWaitClickable("closetoastmsg_CSS");

					// click on the toaster close button
					click("closetoastmsg_CSS");
					ngDriver.waitForAngularRequestsToFinish();
					System.out.println("Clicked on the toaster close button.");

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
