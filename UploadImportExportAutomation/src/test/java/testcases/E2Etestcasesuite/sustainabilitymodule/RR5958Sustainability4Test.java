package testcases.E2Etestcasesuite.sustainabilitymodule;

import java.io.File;
import java.io.IOException;
import java.time.LocalDate;
import java.util.Hashtable;
import java.util.Random;

import org.apache.commons.lang3.RandomStringUtils;
import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.SkipException;
import org.testng.annotations.Test;

import com.relevantcodes.extentreports.LogStatus;

import base.Helper;
import base.TestBase;
import utilities.ExcelReader;
import utilities.TestUtil;

public class RR5958Sustainability4Test extends TestBase {

	@Test(dataProviderClass = TestUtil.class, dataProvider = "dp")
	public void rR5958Sustainability4Test(Hashtable<String, String> data) throws IOException, InterruptedException {

		execution(data, "rR5958Sustainability4Test");

		// VERIFY THE EXTRACT FEATURE OF THE CERTIFICATION MODULE

		System.out.println("VERIFY THE EXTRACT FEATURE OF THE CERTIFICATION MODULE");
		test.log(LogStatus.INFO, "VERIFY THE EXTRACT FEATURE OF THE CERTIFICATION MODULE");
		Reporter.log("VERIFY THE EXTRACT FEATURE OF THE CERTIFICATION MODULE");
		log.info("VERIFY THE EXTRACT FEATURE OF THE CERTIFICATION MODULE");

		// refresh the page
		driver.navigate().refresh();
		explicitWait("sustainabilityicon_CSS");
		driver.navigate().refresh();

		Helper helper = new Helper();

		System.out.println("Navigate to the Home Screen i.e. Property List Screen.");

		// DELETE ALL THE PREVIOUSLY CREATED CERTIFICATES FROM THE PROPERTY

		System.out.println(
				"***************** DELETE ALL THE PREVIOUSLY CREATED CERTIFICATES FROM THE PROPERTY *****************");
		test.log(LogStatus.INFO,
				"***************** DELETE ALL THE PREVIOUSLY CREATED CERTIFICATES FROM THE PROPERTY *****************");
		Reporter.log(
				"***************** DELETE ALL THE PREVIOUSLY CREATED CERTIFICATES FROM THE PROPERTY *****************");
		log.info(
				"***************** DELETE ALL THE PREVIOUSLY CREATED CERTIFICATES FROM THE PROPERTY *****************");

		helper.deleteAllCertificates(data.get("property_1"));

		// click on the home icon from the top of the screen
		click("questionnaire_homeburgermenubtn_hide_CSS");
		System.out.println("Clicked on the home icon from the top of the screen.");
		ngDriver.waitForAngularRequestsToFinish();

		// synchronization
		explicitWait("propertylist_title_XPATH");

		// verify the property list
		switchVerification("propertylist_title_XPATH", "Property List", "The property list is not displayed.");

		// CREATE RANDOM NUMBER OF NEW CERTIFICATIONS RECORD - AT PROPERTY LEVEL

		System.out.println(
				"***************** CREATE RANDOM NUMBER OF NEW CERTIFICATIONS RECORD - AT PROPERTY LEVEL *****************");
		test.log(LogStatus.INFO,
				"***************** CREATE RANDOM NUMBER OF NEW CERTIFICATIONS RECORD - AT PROPERTY LEVEL *****************");
		Reporter.log(
				"***************** CREATE RANDOM NUMBER OF NEW CERTIFICATIONS RECORD - AT PROPERTY LEVEL *****************");
		log.info(
				"***************** CREATE RANDOM NUMBER OF NEW CERTIFICATIONS RECORD - AT PROPERTY LEVEL *****************");

		Random random = new Random();
		int certificateCount = random.nextInt(7 - 3) + 3;

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

			// click on the certifications option
			click("sustainability_sidemenu_certificationsoption_XPATH");
			ngDriver.waitForAngularRequestsToFinish();
			System.out.println("Clicked on the certifications option.");

			for (int i = 0; i < certificateCount; i++) {

				// click on the add button
				click("sustainability_certification_addbtn_XPATH");
				ngDriver.waitForAngularRequestsToFinish();
				System.out.println("Clicked on the add button.");

				// select the certification type from the dropdown
				select("sustainability_certification_certificationtype_XPATH", data.get("type"));
				ngDriver.waitForAngularRequestsToFinish();
				System.out.println("Selected the certification type from the dropdown.");

				// select the certification name from the dropdown
				select("sustainability_certification_certificationname_XPATH", data.get("name"));
				ngDriver.waitForAngularRequestsToFinish();
				System.out.println("Selected the certification name from the dropdown.");

				// select the certification sub type from the dropdown
				select("sustainability_certification_certificationsubtype_XPATH", data.get("sub_type"));
				ngDriver.waitForAngularRequestsToFinish();
				System.out.println("Selected the certification sub type from the dropdown.");

				// select the level of certification from the dropdown
				select("sustainability_certification_levelofcertification_XPATH", data.get("level"));
				ngDriver.waitForAngularRequestsToFinish();
				System.out.println("Selected the level of certification from the dropdown.");

				// enter the certification score in the field
				clear("sustainability_certification_certificationscore_XPATH");
				type("sustainability_certification_certificationscore_XPATH", "5");
				ngDriver.waitForAngularRequestsToFinish();
				System.out.println("Entered the certification score in the field.");

				// enter on the date of certification
				LocalDate date = LocalDate.now();
				String currentDate = date.toString();
				clear("sustainability_certification_dateofcertification_XPATH");
				type("sustainability_certification_dateofcertification_XPATH", currentDate);
				ngDriver.waitForAngularRequestsToFinish();
				System.out.println("Clicked on the date of certification.");

				// enter on the date of certification
				LocalDate date1 = LocalDate.now().plusDays(10);
				String futureDate1 = date1.toString();
				clear("sustainability_certification_certificationexpiration_XPATH");
				type("sustainability_certification_certificationexpiration_XPATH", futureDate1);
				ngDriver.waitForAngularRequestsToFinish();
				System.out.println("Clicked on the date of certification.");

				// select the certification status from the dropdown
				select("sustainability_certification_certificationstatus_XPATH", data.get("status"));
				ngDriver.waitForAngularRequestsToFinish();
				System.out.println("Selected the certification status from the dropdown.");

				// enter the verification year
				clear("sustainability_certification_verificationyear_XPATH");
				type("sustainability_certification_verificationyear_XPATH", "2022");
				ngDriver.waitForAngularRequestsToFinish();
				System.out.println("Entered the verification year.");

				// select the Portfolio Program from the dropdown
				select("sustainability_certification_portfolioprogram_XPATH", data.get("portfolio_program"));
				ngDriver.waitForAngularRequestsToFinish();
				System.out.println("Selected the Portfolio Program from the dropdown.");

				// enter the Project ID in the field
				String random1 = RandomStringUtils.randomAlphanumeric(8);
				clear("sustainability_certification_projectid_XPATH");
				type("sustainability_certification_projectid_XPATH", random1);
				ngDriver.waitForAngularRequestsToFinish();
				System.out.println("Entered the Project ID in the field.");

				// enter the Building ID in the field
				String random2 = RandomStringUtils.randomAlphanumeric(8);
				clear("sustainability_certification_buildingid_XPATH");
				type("sustainability_certification_buildingid_XPATH", random2);
				ngDriver.waitForAngularRequestsToFinish();
				System.out.println("Entered the Building ID in the field.");

				// click on the save button
				click("sustainability_certification_savebtn_XPATH");
				ngDriver.waitForAngularRequestsToFinish();
				System.out.println("Clicked on the save button.");

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

		// click on the home icon from the top of the screen
		click("questionnaire_homeburgermenubtn_hide_CSS");
		System.out.println("Clicked on the home icon from the top of the screen.");
		ngDriver.waitForAngularRequestsToFinish();

		// synchronization
		explicitWait("propertylist_title_XPATH");

		// verify the property list
		switchVerification("propertylist_title_XPATH", "Property List", "The property list is not displayed.");

		// EXTRACT THE NEWLY CREATED CERIFICATE RECORDS

		System.out.println("***************** EXTRACT THE NEWLY CREATED CERIFICATE RECORDS *****************");
		test.log(LogStatus.INFO, "***************** EXTRACT THE NEWLY CREATED CERIFICATE RECORDS *****************");
		Reporter.log("***************** EXTRACT THE NEWLY CREATED CERIFICATE RECORDS *****************");
		log.info("***************** EXTRACT THE NEWLY CREATED CERIFICATE RECORDS *****************");

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

			// click on the certifications option
			click("sustainability_sidemenu_certificationsoption_XPATH");
			ngDriver.waitForAngularRequestsToFinish();
			System.out.println("Clicked on the certifications option.");

			// click on the extract icon
			click("sustainability_certification_extracticon_XPATH");
			ngDriver.waitForAngularRequestsToFinish();
			System.out.println("Clicked on the extract icon.");

			// wait for the element
			Thread.sleep(5000);

			// click on the property list field
			click("sustainability_utilitymeters_documenticon_propertybtn_XPATH");
			ngDriver.waitForAngularRequestsToFinish();
			System.out.println("Clicked on the property list field.");

			// click on the none button
			click("sustainability_utilitymeters_documenticon_nonebtn_XPATH");
			ngDriver.waitForAngularRequestsToFinish();
			System.out.println("Clicked on the none button.");

			// enter property name in the search field
			type("sustainability_utilitymeters_documenticon_searchtxt_XPATH", data.get("property_1"));
			ngDriver.waitForAngularRequestsToFinish();
			System.out.println("Entered property name in the search field.");

			// click on the searched property name
			String searchedProperty = "//div[@ng-click='addOrRemoveToSelected(item)']//span[text()='"
					+ data.get("property_1") + "']";
			driver.findElement(By.xpath(searchedProperty)).click();
			ngDriver.waitForAngularRequestsToFinish();
			System.out.println("Clicked on the searched property name.");

			// click on the property field
			click("sustainability_utilitymeters_documenticon_propertybtn_XPATH");
			ngDriver.waitForAngularRequestsToFinish();
			System.out.println("Clicked on the property field.");

			// wait for the element
			Thread.sleep(5000);

			// click on the type field
			click("sustainability_certification_extract_typetxt_XPATH");
			ngDriver.waitForAngularRequestsToFinish();
			System.out.println("Clicked on the type field.");

			// click on the none button
			click("sustainability_utilitymeters_documenticon_nonebtn_XPATH");
			ngDriver.waitForAngularRequestsToFinish();
			System.out.println("Clicked on the none button.");

			// enter type name in the search field
			type("sustainability_utilitymeters_documenticon_searchtxt_XPATH", data.get("name"));
			ngDriver.waitForAngularRequestsToFinish();
			System.out.println("Entered type name in the search field.");

			// click on the searched property name
			String searchedCertificate = "//div[@ng-click='addOrRemoveToSelected(item)']//span[text()='"
					+ data.get("name") + "']";
			driver.findElement(By.xpath(searchedCertificate)).click();
			ngDriver.waitForAngularRequestsToFinish();
			System.out.println("Clicked on the searched property name.");

			// click on the type field
			click("sustainability_certification_extract_typetxt_XPATH");
			ngDriver.waitForAngularRequestsToFinish();
			System.out.println("Clicked on the type field.");

			// wait for the element
			Thread.sleep(5000);

			// click on the extract button
			click("sustainability_certification_extractbtn_XPATH");
			ngDriver.waitForAngularRequestsToFinish();
			System.out.println("Clicked on the extract button.");

			Thread.sleep(5000);

			// fetch the record from the download file

			// **************** ADD FILE CHOOSE CODE HERE ***********************

			File downloaded = getLastModified("C:\\Users\\Jinesh\\Downloads");
			String path_string = downloaded.toString();
			System.out.println(path_string);
			ExcelReader file = new ExcelReader(path_string);

			// validate the count of the row is displayed correctly or not
			try {
				int actualRowCount = file.getRowCount("Sheet0");
				if ((actualRowCount - 1) == certificateCount) {

					successMessage("The newly created certification record count is displayed correctly.");

				} else {
					verificationFailedMessage(
							"The newly created certification record count is not displayed correctly.");
				}
			} catch (Throwable t) {
				verificationFailedMessage("The newly created certification record count is not displayed correctly.");
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

		// DELETE ALL THE NEWLY CREATED CERTIFICATES FROM THE PROPERTY

		System.out.println(
				"***************** DELETE ALL THE NEWLY CREATED CERTIFICATES FROM THE PROPERTY *****************");
		test.log(LogStatus.INFO,
				"***************** DELETE ALL THE NEWLY CREATED CERTIFICATES FROM THE PROPERTY *****************");
		Reporter.log("***************** DELETE ALL THE NEWLY CREATED CERTIFICATES FROM THE PROPERTY *****************");
		log.info("***************** DELETE ALL THE NEWLY CREATED CERTIFICATES FROM THE PROPERTY *****************");

		helper.deleteAllCertificates(data.get("property_1"));

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
