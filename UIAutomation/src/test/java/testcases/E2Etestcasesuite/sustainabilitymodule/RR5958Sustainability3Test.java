package testcases.E2Etestcasesuite.sustainabilitymodule;

import java.io.IOException;
import java.time.LocalDate;
import java.util.Hashtable;
import java.util.List;

import org.apache.commons.lang3.RandomStringUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.SkipException;
import org.testng.annotations.Test;

import com.relevantcodes.extentreports.LogStatus;

import base.Helper;
import base.TestBase;
import utilities.TestUtil;

public class RR5958Sustainability3Test extends TestBase {

	@Test(dataProviderClass = TestUtil.class, dataProvider = "dp")
	public void rR5958Sustainability3Test(Hashtable<String, String> data) throws IOException, InterruptedException {

		execution(data, "rR5958Sustainability3Test");

		Helper helper = new Helper();

		// VALIDATE THE BUILDING CERTIFICATE DASHBOARD RECORDS WITH DIFFERENT SCENARIOS

		System.out.println("VALIDATE THE BUILDING CERTIFICATE DASHBOARD RECORDS WITH DIFFERENT SCENARIOS");
		test.log(LogStatus.INFO, "VALIDATE THE BUILDING CERTIFICATE DASHBOARD RECORDS WITH DIFFERENT SCENARIOS");
		Reporter.log("VALIDATE THE BUILDING CERTIFICATE DASHBOARD RECORDS WITH DIFFERENT SCENARIOS");
		log.info("VALIDATE THE BUILDING CERTIFICATE DASHBOARD RECORDS WITH DIFFERENT SCENARIOS");

		// refresh the page
		driver.navigate().refresh();
		Thread.sleep(5000);
		driver.navigate().refresh();

		// DELETE ALL THE PREVIOUSLY CREATED CERTIFICATES FROM ALL THE PROPERTIES

		System.out.println(
				"***************** DELETE ALL THE PREVIOUSLY CREATED CERTIFICATES FROM ALL THE PROPERTIES *****************");
		test.log(LogStatus.INFO,
				"***************** DELETE ALL THE PREVIOUSLY CREATED CERTIFICATES FROM ALL THE PROPERTIES *****************");
		Reporter.log(
				"***************** DELETE ALL THE PREVIOUSLY CREATED CERTIFICATES FROM ALL THE PROPERTIES *****************");
		log.info(
				"***************** DELETE ALL THE PREVIOUSLY CREATED CERTIFICATES FROM ALL THE PROPERTIES *****************");

		helper.deleteAllCertificates(data.get("property_1"));
		helper.deleteAllCertificates(data.get("property_2"));
		helper.deleteAllCertificates(data.get("property_3"));
		helper.deleteAllCertificates(data.get("property_4"));

		// click on the home icon from the top of the screen
		click("questionnaire_homeburgermenubtn_hide_CSS");
		System.out.println("Clicked on the home icon from the top of the screen.");
		ngDriver.waitForAngularRequestsToFinish();

		// synchronization
		explicitWait("propertylist_title_XPATH");

		// verify the property list
		switchVerification("propertylist_title_XPATH", "Property List", "The property list is not displayed.");

		// CREATE NEW CERTIFICATIONS RECORD - BOMA BEST - ACTIVE STATUS

		System.out.println(
				"***************** CREATE NEW CERTIFICATIONS RECORD - BOMA BEST - ACTIVE STATUS *****************");
		test.log(LogStatus.INFO,
				"***************** CREATE NEW CERTIFICATIONS RECORD - BOMA BEST - ACTIVE STATUS *****************");
		Reporter.log(
				"***************** CREATE NEW CERTIFICATIONS RECORD - BOMA BEST - ACTIVE STATUS *****************");
		log.info("***************** CREATE NEW CERTIFICATIONS RECORD - BOMA BEST - ACTIVE STATUS *****************");

		try {
			// enter the property name in the search field
			type("envreports_propertylist_filtertxt_CSS", data.get("property_1"));
			ngDriver.waitForAngularRequestsToFinish();
			System.out.println("Entered the property name in the search field.");

			// click on the sustainability icon
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

			// click on the add button
			click("sustainability_certification_addbtn_XPATH");
			ngDriver.waitForAngularRequestsToFinish();
			System.out.println("Clicked on the add button.");

			// select the certification type from the dropdown
			select("sustainability_certification_certificationtype_XPATH", data.get("type_1"));
			ngDriver.waitForAngularRequestsToFinish();
			System.out.println("Selected the certification type from the dropdown.");

			// select the certification name from the dropdown
			select("sustainability_certification_certificationname_XPATH", data.get("name_1"));
			ngDriver.waitForAngularRequestsToFinish();
			System.out.println("Selected the certification name from the dropdown.");

			// select the certification sub type from the dropdown
			select("sustainability_certification_certificationsubtype_XPATH", data.get("sub_type_1"));
			ngDriver.waitForAngularRequestsToFinish();
			System.out.println("Selected the certification sub type from the dropdown.");

			// select the level of certification from the dropdown
			select("sustainability_certification_levelofcertification_XPATH", data.get("level_1"));
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
			select("sustainability_certification_certificationstatus_XPATH", data.get("status_1"));
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

			// enter the newly created certification record in the search field
			clear("sustainability_searchtxt_XPATH");
			type("sustainability_searchtxt_XPATH", data.get("name_1"));
			ngDriver.waitForAngularRequestsToFinish();
			System.out.println("Entered the newly created certification record in the search field.");

			// verify the category of the newly created certification record
			switchVerification("sustainability_certification_addedcategory1_XPATH", "Time of Design / Construction",
					"The Time of Design / Construction record is not displayed.");

			// verify the type of the newly created certification record
			switchVerification("sustainability_certification_addedtype1_XPATH", "BOMA BEST",
					"The BOMA BEST record is not displayed.");

			// verify the level of the newly created certification record
			switchVerification("sustainability_certification_addedlevel1_XPATH", "Certified",
					"The Certified record is not displayed.");

			// verify the status of the newly created certification record
			switchVerification("sustainability_certification_addedstatus1_XPATH", "Active",
					"The Active record is not displayed.");

			// verify the Certification Date of the newly created certification record
			try {
				String currentDate_XPATH = "//td[text()='" + data.get("type_1") + "']//following-sibling::td[text()='"
						+ currentDate + "']";
				String addedDate1 = (driver.findElement(By.xpath(currentDate_XPATH)).getText()).trim();
				if (addedDate1.equals(currentDate)) {

					successMessage("The Certification Date is verified successfully.");

				} else {

					verificationFailedMessage("The Certification Date is not verified.");

				}
			} catch (Throwable t) {
				verificationFailed();
			}

			// verify the Certification Expiry of the newly created certification record
			try {
				String futureDate_XPATH = "//td[text()='" + data.get("type_1") + "']//following-sibling::td[text()='"
						+ futureDate1 + "']";
				String addedDate2 = (driver.findElement(By.xpath(futureDate_XPATH)).getText()).trim();
				if (addedDate2.equals(futureDate1)) {

					successMessage("The Certification Expiry is verified successfully.");

				} else {

					verificationFailedMessage("The Certification Expiry is not verified.");

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

		// CREATE NEW CERTIFICATIONS RECORD - LEED - PENDING STATUS

		System.out.println(
				"***************** CREATE NEW CERTIFICATIONS RECORD - LEED - PENDING STATUS *****************");
		test.log(LogStatus.INFO,
				"***************** CREATE NEW CERTIFICATIONS RECORD - LEED - PENDING STATUS *****************");
		Reporter.log("***************** CREATE NEW CERTIFICATIONS RECORD - LEED - PENDING STATUS *****************");
		log.info("***************** CREATE NEW CERTIFICATIONS RECORD - LEED - PENDING STATUS *****************");

		try {
			// enter the property name in the search field
			type("envreports_propertylist_filtertxt_CSS", data.get("property_1"));
			ngDriver.waitForAngularRequestsToFinish();
			System.out.println("Entered the property name in the search field.");

			// click on the sustainability icon
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

			// click on the add button
			click("sustainability_certification_addbtn_XPATH");
			ngDriver.waitForAngularRequestsToFinish();
			System.out.println("Clicked on the add button.");

			// select the certification type from the dropdown
			select("sustainability_certification_certificationtype_XPATH", data.get("type_2"));
			ngDriver.waitForAngularRequestsToFinish();
			System.out.println("Selected the certification type from the dropdown.");

			// select the certification name from the dropdown
			select("sustainability_certification_certificationname_XPATH", data.get("name_2"));
			ngDriver.waitForAngularRequestsToFinish();
			System.out.println("Selected the certification name from the dropdown.");

			// select the certification sub type from the dropdown
			select("sustainability_certification_certificationsubtype_XPATH", data.get("sub_type_2"));
			ngDriver.waitForAngularRequestsToFinish();
			System.out.println("Selected the certification sub type from the dropdown.");

			// select the level of certification from the dropdown
			select("sustainability_certification_levelofcertification_XPATH", data.get("level_1"));
			ngDriver.waitForAngularRequestsToFinish();
			System.out.println("Selected the level of certification from the dropdown.");

			// enter the certification score in the field
			clear("sustainability_certification_certificationscore_XPATH");
			type("sustainability_certification_certificationscore_XPATH", "5");
			ngDriver.waitForAngularRequestsToFinish();
			System.out.println("Entered the certification score in the field.");

			// enter on the date of certification
			LocalDate date2 = LocalDate.now().plusDays(2);
			String currentDate2 = date2.toString();
			clear("sustainability_certification_dateofcertification_XPATH");
			type("sustainability_certification_dateofcertification_XPATH", currentDate2);
			ngDriver.waitForAngularRequestsToFinish();
			System.out.println("Clicked on the date of certification.");

			// enter on the date of certification
			LocalDate date22 = LocalDate.now().plusDays(7);
			String futureDate22 = date22.toString();
			clear("sustainability_certification_certificationexpiration_XPATH");
			type("sustainability_certification_certificationexpiration_XPATH", futureDate22);
			ngDriver.waitForAngularRequestsToFinish();
			System.out.println("Clicked on the date of certification.");

			// select the certification status from the dropdown
			select("sustainability_certification_certificationstatus_XPATH", data.get("status_2"));
			ngDriver.waitForAngularRequestsToFinish();
			System.out.println("Selected the certification status from the dropdown.");

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

			// enter the newly created certification record in the search field
			clear("sustainability_searchtxt_XPATH");
			type("sustainability_searchtxt_XPATH", data.get("name_2"));
			ngDriver.waitForAngularRequestsToFinish();
			System.out.println("Entered the newly created certification record in the search field.");

			// verify the category of the newly created certification record
			switchVerification("sustainability_certification1_addedcategory2_XPATH", "Operational",
					"The Operational record is not displayed.");

			// verify the type of the newly created certification record
			switchVerification("sustainability_certification1_addedtype2_XPATH", "LEED",
					"The BOMA BEST record is not displayed.");

			// verify the level of the newly created certification record
			switchVerification("sustainability_certification1_addedlevel2_XPATH", "Certified",
					"The Certified record is not displayed.");

			// verify the status of the newly created certification record
			switchVerification("sustainability_certification1_addedstatus2_XPATH", "Pending",
					"The Pending record is not displayed.");

			// verify the Certification Date of the newly created certification record
			try {
				String currentDate_XPATH = "//td[text()='" + data.get("type_2") + "']//following-sibling::td[text()='"
						+ currentDate2 + "']";
				String addedDate1 = (driver.findElement(By.xpath(currentDate_XPATH)).getText()).trim();
				if (addedDate1.equals(currentDate2)) {

					successMessage("The Certification Date is verified successfully.");

				} else {

					verificationFailedMessage("The Certification Date is not verified.");

				}
			} catch (Throwable t) {
				verificationFailed();
			}

			// verify the Certification Expiry of the newly created certification record
			try {
				String futureDate_XPATH = "//td[text()='" + data.get("type_2") + "']//following-sibling::td[text()='"
						+ futureDate22 + "']";
				String addedDate2 = (driver.findElement(By.xpath(futureDate_XPATH)).getText()).trim();
				if (addedDate2.equals(futureDate22)) {

					successMessage("The Certification Expiry is verified successfully.");

				} else {

					verificationFailedMessage("The Certification Expiry is not verified.");

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

		// CREATE NEW CERTIFICATIONS RECORD - WIREDSCORE - DENIED STATUS

		System.out.println(
				"***************** CREATE NEW CERTIFICATIONS RECORD - WIREDSCORE - DENIED STATUS *****************");
		test.log(LogStatus.INFO,
				"***************** CREATE NEW CERTIFICATIONS RECORD - WIREDSCORE - DENIED STATUS *****************");
		Reporter.log(
				"***************** CREATE NEW CERTIFICATIONS RECORD - WIREDSCORE - DENIED STATUS *****************");
		log.info("***************** CREATE NEW CERTIFICATIONS RECORD - WIREDSCORE - DENIED STATUS *****************");

		try {
			// enter the property name in the search field
			type("envreports_propertylist_filtertxt_CSS", data.get("property_1"));
			ngDriver.waitForAngularRequestsToFinish();
			System.out.println("Entered the property name in the search field.");

			// click on the sustainability icon
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

			// click on the add button
			click("sustainability_certification_addbtn_XPATH");
			ngDriver.waitForAngularRequestsToFinish();
			System.out.println("Clicked on the add button.");

			// select the certification type from the dropdown
			select("sustainability_certification_certificationtype_XPATH", data.get("type_1"));
			ngDriver.waitForAngularRequestsToFinish();
			System.out.println("Selected the certification type from the dropdown.");

			// select the certification name from the dropdown
			select("sustainability_certification_certificationname_XPATH", data.get("name_3"));
			ngDriver.waitForAngularRequestsToFinish();
			System.out.println("Selected the certification name from the dropdown.");

			// select the certification sub type from the dropdown
			select("sustainability_certification_certificationsubtype_XPATH", data.get("sub_type_3"));
			ngDriver.waitForAngularRequestsToFinish();
			System.out.println("Selected the certification sub type from the dropdown.");

			// select the level of certification from the dropdown
			select("sustainability_certification_levelofcertification_XPATH", data.get("level_1"));
			ngDriver.waitForAngularRequestsToFinish();
			System.out.println("Selected the level of certification from the dropdown.");

			// enter the certification score in the field
			clear("sustainability_certification_certificationscore_XPATH");
			type("sustainability_certification_certificationscore_XPATH", "5");
			ngDriver.waitForAngularRequestsToFinish();
			System.out.println("Entered the certification score in the field.");

			// enter on the date of certification
			LocalDate date3 = LocalDate.now().plusDays(4);
			String currentDate3 = date3.toString();
			clear("sustainability_certification_dateofcertification_XPATH");
			type("sustainability_certification_dateofcertification_XPATH", currentDate3);
			ngDriver.waitForAngularRequestsToFinish();
			System.out.println("Clicked on the date of certification.");

			// enter on the date of certification
			LocalDate date33 = LocalDate.now().plusDays(12);
			String futureDate33 = date33.toString();
			clear("sustainability_certification_certificationexpiration_XPATH");
			type("sustainability_certification_certificationexpiration_XPATH", futureDate33);
			ngDriver.waitForAngularRequestsToFinish();
			System.out.println("Clicked on the date of certification.");

			// select the certification status from the dropdown
			select("sustainability_certification_certificationstatus_XPATH", data.get("status_3"));
			ngDriver.waitForAngularRequestsToFinish();
			System.out.println("Selected the certification status from the dropdown.");

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

			// enter the newly created certification record in the search field
			clear("sustainability_searchtxt_XPATH");
			type("sustainability_searchtxt_XPATH", data.get("name_3"));
			ngDriver.waitForAngularRequestsToFinish();
			System.out.println("Entered the newly created certification record in the search field.");

			// verify the category of the newly created certification record
			switchVerification("sustainability_certification_addedcategory1_XPATH", "Time of Design / Construction",
					"The Time of Design / Construction record is not displayed.");

			// verify the type of the newly created certification record
			switchVerification("sustainability_certification_addedtype3_XPATH", "WiredScore",
					"The LEED record is not displayed.");

			// verify the level of the newly created certification record
			switchVerification("sustainability_certification_addedlevel1_XPATH", "Certified",
					"The Certified record is not displayed.");

			// verify the status of the newly created certification record
			switchVerification("sustainability_certification_addedstatus3_XPATH", "Denied",
					"The Denied record is not displayed.");

			// verify the Certification Date of the newly created certification record
			try {
				String currentDate_XPATH = "//td[text()='" + data.get("type_1") + "']//following-sibling::td[text()='"
						+ currentDate3 + "']";
				String addedDate1 = (driver.findElement(By.xpath(currentDate_XPATH)).getText()).trim();
				if (addedDate1.equals(currentDate3)) {

					successMessage("The Certification Date is verified successfully.");

				} else {

					verificationFailedMessage("The Certification Date is not verified.");

				}
			} catch (Throwable t) {
				verificationFailed();
			}

			// verify the Certification Expiry of the newly created certification record
			try {
				String futureDate_XPATH = "//td[text()='" + data.get("type_1") + "']//following-sibling::td[text()='"
						+ futureDate33 + "']";
				String addedDate2 = (driver.findElement(By.xpath(futureDate_XPATH)).getText()).trim();
				if (addedDate2.equals(futureDate33)) {

					successMessage("The Certification Expiry is verified successfully.");

				} else {

					verificationFailedMessage("The Certification Expiry is not verified.");

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

		// CREATE NEW CERTIFICATIONS RECORD - FITWEL - ACTIVE STATUS - EXPIRED

		System.out.println(
				"***************** CREATE NEW CERTIFICATIONS RECORD - FITWEL - ACTIVE STATUS - EXPIRED *****************");
		test.log(LogStatus.INFO,
				"***************** CREATE NEW CERTIFICATIONS RECORD - FITWEL - ACTIVE STATUS - EXPIRED *****************");
		Reporter.log(
				"***************** CREATE NEW CERTIFICATIONS RECORD - FITWEL - ACTIVE STATUS - EXPIRED *****************");
		log.info(
				"***************** CREATE NEW CERTIFICATIONS RECORD - FITWEL - ACTIVE STATUS - EXPIRED *****************");

		try {
			// enter the property name in the search field
			type("envreports_propertylist_filtertxt_CSS", data.get("property_1"));
			ngDriver.waitForAngularRequestsToFinish();
			System.out.println("Entered the property name in the search field.");

			// click on the sustainability icon
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

			// click on the add button
			click("sustainability_certification_addbtn_XPATH");
			ngDriver.waitForAngularRequestsToFinish();
			System.out.println("Clicked on the add button.");

			// select the certification type from the dropdown
			select("sustainability_certification_certificationtype_XPATH", data.get("type_1"));
			ngDriver.waitForAngularRequestsToFinish();
			System.out.println("Selected the certification type from the dropdown.");

			// select the certification name from the dropdown
			select("sustainability_certification_certificationname_XPATH", data.get("name_4"));
			ngDriver.waitForAngularRequestsToFinish();
			System.out.println("Selected the certification name from the dropdown.");

			// select the certification sub type from the dropdown
			select("sustainability_certification_certificationsubtype_XPATH", data.get("sub_type_4"));
			ngDriver.waitForAngularRequestsToFinish();
			System.out.println("Selected the certification sub type from the dropdown.");

			// select the level of certification from the dropdown
			select("sustainability_certification_levelofcertification_XPATH", data.get("level_1"));
			ngDriver.waitForAngularRequestsToFinish();
			System.out.println("Selected the level of certification from the dropdown.");

			// enter the certification score in the field
			clear("sustainability_certification_certificationscore_XPATH");
			type("sustainability_certification_certificationscore_XPATH", "5");
			ngDriver.waitForAngularRequestsToFinish();
			System.out.println("Entered the certification score in the field.");

			// enter on the date of certification
			LocalDate date4 = LocalDate.now().minusDays(10);
			String currentDate4 = date4.toString();
			clear("sustainability_certification_dateofcertification_XPATH");
			type("sustainability_certification_dateofcertification_XPATH", currentDate4);
			ngDriver.waitForAngularRequestsToFinish();
			System.out.println("Clicked on the date of certification.");

			// enter on the date of certification
			LocalDate date44 = LocalDate.now().minusDays(5);
			String futureDate44 = date44.toString();
			clear("sustainability_certification_certificationexpiration_XPATH");
			type("sustainability_certification_certificationexpiration_XPATH", futureDate44);
			ngDriver.waitForAngularRequestsToFinish();
			System.out.println("Clicked on the date of certification.");

			// select the certification status from the dropdown
			select("sustainability_certification_certificationstatus_XPATH", data.get("status_1"));
			ngDriver.waitForAngularRequestsToFinish();
			System.out.println("Selected the certification status from the dropdown.");

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

			// enter the newly created certification record in the search field
			clear("sustainability_searchtxt_XPATH");
			type("sustainability_searchtxt_XPATH", data.get("name_4"));
			ngDriver.waitForAngularRequestsToFinish();
			System.out.println("Entered the newly created certification record in the search field.");

			// verify the category of the newly created certification record
			switchVerification("sustainability_certification_addedcategory1_XPATH", "Time of Design / Construction",
					"The Time of Design / Construction record is not displayed.");

			// verify the type of the newly created certification record
			switchVerification("sustainability_certification_addedtype4_XPATH", "Fitwel",
					"The BOMA BEST record is not displayed.");

			// verify the level of the newly created certification record
			switchVerification("sustainability_certification_addedlevel1_XPATH", "Certified",
					"The Certified record is not displayed.");

			// verify the status of the newly created certification record
			switchVerification("sustainability_certification_addedstatus1_XPATH", "Active",
					"The Active record is not displayed.");

			// verify the Certification Date of the newly created certification record
			try {
				String currentDate_XPATH = "//td[text()='" + data.get("type_1") + "']//following-sibling::td[text()='"
						+ currentDate4 + "']";
				String addedDate1 = (driver.findElement(By.xpath(currentDate_XPATH)).getText()).trim();
				if (addedDate1.equals(currentDate4)) {

					successMessage("The Certification Date is verified successfully.");

				} else {

					verificationFailedMessage("The Certification Date is not verified.");

				}
			} catch (Throwable t) {
				verificationFailed();
			}

			// verify the Certification Expiry of the newly created certification record
			try {
				String futureDate_XPATH = "//td[text()='" + data.get("type_1") + "']//following-sibling::td[text()='"
						+ futureDate44 + "']";
				String addedDate2 = (driver.findElement(By.xpath(futureDate_XPATH)).getText()).trim();
				if (addedDate2.equals(futureDate44)) {

					successMessage("The Certification Expiry is verified successfully.");

				} else {

					verificationFailedMessage("The Certification Expiry is not verified.");

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

		// CREATE NEW CERTIFICATIONS RECORD - WELL BUILDING STANDARD - DENIED STATUS -
		// EXPIRED

		System.out.println(
				"***************** CREATE NEW CERTIFICATIONS RECORD - WELL BUILDING STANDARD - DENIED STATUS - EXPIRED *****************");
		test.log(LogStatus.INFO,
				"***************** CREATE NEW CERTIFICATIONS RECORD - WELL BUILDING STANDARD - DENIED STATUS - EXPIRED *****************");
		Reporter.log(
				"***************** CREATE NEW CERTIFICATIONS RECORD - WELL BUILDING STANDARD - DENIED STATUS - EXPIRED *****************");
		log.info(
				"***************** CREATE NEW CERTIFICATIONS RECORD - WELL BUILDING STANDARD - DENIED STATUS - EXPIRED *****************");

		try {
			// enter the property name in the search field
			type("envreports_propertylist_filtertxt_CSS", data.get("property_1"));
			ngDriver.waitForAngularRequestsToFinish();
			System.out.println("Entered the property name in the search field.");

			// click on the sustainability icon
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

			// click on the add button
			click("sustainability_certification_addbtn_XPATH");
			ngDriver.waitForAngularRequestsToFinish();
			System.out.println("Clicked on the add button.");

			// select the certification type from the dropdown
			select("sustainability_certification_certificationtype_XPATH", data.get("type_1"));
			ngDriver.waitForAngularRequestsToFinish();
			System.out.println("Selected the certification type from the dropdown.");

			// select the certification name from the dropdown
			select("sustainability_certification_certificationname_XPATH", data.get("name_5"));
			ngDriver.waitForAngularRequestsToFinish();
			System.out.println("Selected the certification name from the dropdown.");

			// select the certification sub type from the dropdown
			select("sustainability_certification_certificationsubtype_XPATH", data.get("sub_type_5"));
			ngDriver.waitForAngularRequestsToFinish();
			System.out.println("Selected the certification sub type from the dropdown.");

			// select the level of certification from the dropdown
			select("sustainability_certification_levelofcertification_XPATH", data.get("level_1"));
			ngDriver.waitForAngularRequestsToFinish();
			System.out.println("Selected the level of certification from the dropdown.");

			// enter the certification score in the field
			clear("sustainability_certification_certificationscore_XPATH");
			type("sustainability_certification_certificationscore_XPATH", "5");
			ngDriver.waitForAngularRequestsToFinish();
			System.out.println("Entered the certification score in the field.");

			// enter on the date of certification
			LocalDate date5 = LocalDate.now().minusDays(7);
			String currentDate5 = date5.toString();
			clear("sustainability_certification_dateofcertification_XPATH");
			type("sustainability_certification_dateofcertification_XPATH", currentDate5);
			ngDriver.waitForAngularRequestsToFinish();
			System.out.println("Clicked on the date of certification.");

			// enter on the date of certification
			LocalDate date55 = LocalDate.now().minusDays(3);
			String futureDate55 = date55.toString();
			clear("sustainability_certification_certificationexpiration_XPATH");
			type("sustainability_certification_certificationexpiration_XPATH", futureDate55);
			ngDriver.waitForAngularRequestsToFinish();
			System.out.println("Clicked on the date of certification.");

			// select the certification status from the dropdown
			select("sustainability_certification_certificationstatus_XPATH", data.get("status_3"));
			ngDriver.waitForAngularRequestsToFinish();
			System.out.println("Selected the certification status from the dropdown.");

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

			// enter the newly created certification record in the search field
			clear("sustainability_searchtxt_XPATH");
			type("sustainability_searchtxt_XPATH", data.get("name_5"));
			ngDriver.waitForAngularRequestsToFinish();
			System.out.println("Entered the newly created certification record in the search field.");

			// verify the category of the newly created certification record
			switchVerification("sustainability_certification_addedcategory1_XPATH", "Time of Design / Construction",
					"The Time of Design / Construction record is not displayed.");

			// verify the type of the newly created certification record
			switchVerification("sustainability_certification_addedtype5_XPATH", "WELL Building Standard",
					"The LEED record is not displayed.");

			// verify the level of the newly created certification record
			switchVerification("sustainability_certification_addedlevel1_XPATH", "Certified",
					"The Certified record is not displayed.");

			// verify the status of the newly created certification record
			switchVerification("sustainability_certification_addedstatus3_XPATH", "Denied",
					"The Denied record is not displayed.");

			// verify the Certification Date of the newly created certification record
			try {
				String currentDate_XPATH = "//td[text()='" + data.get("type_1") + "']//following-sibling::td[text()='"
						+ currentDate5 + "']";
				String addedDate1 = (driver.findElement(By.xpath(currentDate_XPATH)).getText()).trim();
				if (addedDate1.equals(currentDate5)) {

					successMessage("The Certification Date is verified successfully.");

				} else {

					verificationFailedMessage("The Certification Date is not verified.");

				}
			} catch (Throwable t) {
				verificationFailed();
			}

			// verify the Certification Expiry of the newly created certification record
			try {
				String futureDate_XPATH = "//td[text()='" + data.get("type_1") + "']//following-sibling::td[text()='"
						+ futureDate55 + "']";
				String addedDate2 = (driver.findElement(By.xpath(futureDate_XPATH)).getText()).trim();
				if (addedDate2.equals(futureDate55)) {

					successMessage("The Certification Expiry is verified successfully.");

				} else {

					verificationFailedMessage("The Certification Expiry is not verified.");

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

		// VALIDATE THE COUNT OF THE NEWLY CREATED CERTIFICATION IN THE BUILDING
		// CERTIFICATION DASHBOARD

		System.out.println(
				"***************** VALIDATE THE COUNT OF THE NEWLY CREATED CERTIFICATION IN THE BUILDING CERTIFICATION DASHBOARD *****************");
		test.log(LogStatus.INFO,
				"***************** VALIDATE THE COUNT OF THE NEWLY CREATED CERTIFICATION IN THE BUILDING CERTIFICATION DASHBOARD *****************");
		Reporter.log(
				"***************** VALIDATE THE COUNT OF THE NEWLY CREATED CERTIFICATION IN THE BUILDING CERTIFICATION DASHBOARD *****************");
		log.info(
				"***************** VALIDATE THE COUNT OF THE NEWLY CREATED CERTIFICATION IN THE BUILDING CERTIFICATION DASHBOARD *****************");

		// order of the certification type in the dashboard: leed, well building
		// standard, boma best, fitwel, wiredscore

		try {

			// wait for the element
			Thread.sleep(5000);

			// click on the side menu
			click("menubtn_CSS");
			ngDriver.waitForAngularRequestsToFinish();
			System.out.println("Clicked on the side menu.");

			// wait for the element
			Thread.sleep(5000);

			// click on the sustainability option
			click("sidemenu_sustainability_CSS");
			ngDriver.waitForAngularRequestsToFinish();
			System.out.println("Clicked on the sustainability option.");

			// select the building certifications option from the dashboard drop down
			select("ssc_sustainability_dashboarddd_CSS", data.get("dashboard_1"));
			ngDriver.waitForAngularRequestsToFinish();
			System.out.println("Selected the building certifications option from the dashboard drop down.");

			// enter todays date in the date field of the active certification section
			LocalDate date1 = LocalDate.now();
			String date1_String = date1.toString();
			clear("sustainability_certification_dashboard_date1_XPATH");
			type("sustainability_certification_dashboard_date1_XPATH", date1_String);
			ngDriver.waitForAngularRequestsToFinish();
			System.out.println("Entered todays date in the date field of the active certification section.");

			// wait for the element
			Thread.sleep(5000);

			// validate leed count of the section 1
			switchVerification("sustainability_certification_dashboard_section1_count1_XPATH", "0",
					"The correct count is not displayed.");

			// validate well building standard count of the section 1
			switchVerification("sustainability_certification_dashboard_section1_count2_XPATH", "0",
					"The correct count is not displayed.");

			// validate boma best count of the section 1
			switchVerification("sustainability_certification_dashboard_section1_count3_XPATH", "1",
					"The correct count is not displayed.");

			// validate sub title of the boma best count of the section 1
			switchVerification("sustainability_certification_dashboard_section1_count33_XPATH", "1",
					"The correct count is not displayed.");

			// validate fitwel count of the section 1
			switchVerification("sustainability_certification_dashboard_section1_count4_XPATH", "0",
					"The correct count is not displayed.");

			// validate wiredscore count of the section 1
			switchVerification("sustainability_certification_dashboard_section1_count5_XPATH", "0",
					"The correct count is not displayed.");

			// enter current year in the year field of the expiring certification section
			LocalDate date2 = LocalDate.now();
			String date2_String = date2.toString();
			String[] Year = date2_String.split("-");
			String Year_actual = Year[0];

			clear("sustainability_certification_dashboard_date2_XPATH");
			type("sustainability_certification_dashboard_date2_XPATH", Year_actual);
			ngDriver.waitForAngularRequestsToFinish();
			System.out.println("Entered current year in the year field of the expiring certification section.");

			// wait for the element
			Thread.sleep(5000);

			// validate leed count of the section 2
			switchVerification("sustainability_certification_dashboard_section2_count1_XPATH", "1",
					"The correct count is not displayed.");

			// validate the count of the sub type of the leed of the section 2
			switchVerification("sustainability_certification_dashboard_section2_count11_XPATH", "1",
					"The correct count is not displayed.");

			// validate well building standard count of the section 2
			switchVerification("sustainability_certification_dashboard_section2_count2_XPATH", "0",
					"The correct count is not displayed.");

			// validate boma best count of the section 2
			switchVerification("sustainability_certification_dashboard_section2_count3_XPATH", "1",
					"The correct count is not displayed.");

			// validate sub title of the boma best count of the section 2
			switchVerification("sustainability_certification_dashboard_section2_count33_XPATH", "1",
					"The correct count is not displayed.");

			// validate fitwel count of the section 2
			switchVerification("sustainability_certification_dashboard_section2_count4_XPATH", "1",
					"The correct count is not displayed.");

			// validate the count of the sub type of the fitwel of the section 2
			switchVerification("sustainability_certification_dashboard_section2_count44_XPATH", "1",
					"The correct count is not displayed.");

			// validate wiredscore count of the section 2
			switchVerification("sustainability_certification_dashboard_section2_count5_XPATH", "0",
					"The correct count is not displayed.");

//			// enter todays date in the date field of the Properties Not Certified section
//			LocalDate date3 = LocalDate.now();
//			String date3_String = date3.toString();
//			clear("sustainability_certification_dashboard_date3_XPATH");
//			type("sustainability_certification_dashboard_date3_XPATH", date3_String);
//			ngDriver.waitForAngularRequestsToFinish();
//			System.out.println("Entered todays date in the date field of the Properties Not Certified section.");

			// wait for the element
			Thread.sleep(5000);

			// validate leed count of the section 3
			switchVerification("sustainability_certification_dashboard_section3_count1_XPATH", "4",
					"The correct count is not displayed.");

			// validate well building standard count of the section 3
			switchVerification("sustainability_certification_dashboard_section3_count2_XPATH", "4",
					"The correct count is not displayed.");

			// validate boma best count of the section 3
			switchVerification("sustainability_certification_dashboard_section3_count3_XPATH", "3",
					"The correct count is not displayed.");

			// validate fitwel count of the section 3
			switchVerification("sustainability_certification_dashboard_section3_count4_XPATH", "4",
					"The correct count is not displayed.");

			// validate wiredscore count of the section 3
			switchVerification("sustainability_certification_dashboard_section3_count5_XPATH", "4",
					"The correct count is not displayed.");

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

		// UPDATE THE STATUS OF THE CERTIFICATION VIA DASHBOARD - ACTIVE TO DENIED

		System.out.println(
				"***************** UPDATE THE STATUS OF THE CERTIFICATION VIA DASHBOARD - BOMA BEST - ACTIVE TO DENIED *****************");
		test.log(LogStatus.INFO,
				"***************** UPDATE THE STATUS OF THE CERTIFICATION VIA DASHBOARD - BOMA BEST - ACTIVE TO DENIED *****************");
		Reporter.log(
				"***************** UPDATE THE STATUS OF THE CERTIFICATION VIA DASHBOARD - BOMA BEST - ACTIVE TO DENIED *****************");
		log.info(
				"***************** UPDATE THE STATUS OF THE CERTIFICATION VIA DASHBOARD - BOMA BEST - ACTIVE TO DENIED *****************");

		try {

			// wait for the element
			Thread.sleep(5000);

			// click on the side menu
			click("menubtn_CSS");
			ngDriver.waitForAngularRequestsToFinish();
			System.out.println("Clicked on the side menu.");

			// wait for the element
			Thread.sleep(5000);

			// click on the sustainability option
			click("sidemenu_sustainability_CSS");
			ngDriver.waitForAngularRequestsToFinish();
			System.out.println("Clicked on the sustainability option.");

			// select the building certifications option from the dashboard drop down
			select("ssc_sustainability_dashboarddd_CSS", data.get("dashboard_1"));
			ngDriver.waitForAngularRequestsToFinish();
			System.out.println("Selected the building certifications option from the dashboard drop down.");

			// click on the active certificate
			click("sustainability_certification_dashboard_section1_count33_XPATH");
			ngDriver.waitForAngularRequestsToFinish();
			System.out.println("Clicked on the active certificate.");

			// validate active certification title
			switchVerification("sustainability_activecertification_title_XPATH", "Active Certifications:",
					"The Active Certifications title is not displayed.");

			// enter the name of the property in the search field
			type("sustainability_searchtxt_XPATH", data.get("property_1"));
			ngDriver.waitForAngularRequestsToFinish();
			System.out.println("Entered the name of the property in the search field.");

			// click on the searched property
			String propertyName = "//td[contains(text(),'" + data.get("property_1") + "')]";
			driver.findElement(By.xpath(propertyName)).click();
			ngDriver.waitForAngularRequestsToFinish();
			System.out.println("Clicked on the searched property.");

			// select the certification status from the dropdown
			select("sustainability_certification_certificationstatus_XPATH", data.get("status_3"));
			ngDriver.waitForAngularRequestsToFinish();
			System.out.println("Selected the certification status from the dropdown.");

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

			// click on the back to dashboard button
			click("sustainability_activecertification_backtodashboardbtn_XPATH");
			ngDriver.waitForAngularRequestsToFinish();
			System.out.println("Clicked on the back to dashboard button.");

			// select the building certifications option from the dashboard drop down
			select("ssc_sustainability_dashboarddd_CSS", data.get("dashboard_1"));
			ngDriver.waitForAngularRequestsToFinish();
			System.out.println("Selected the building certifications option from the dashboard drop down.");

//			// enter todays date in the date field of the active certification section
//			LocalDate date1 = LocalDate.now();
//			String date1_String = date1.toString();
//			clear("sustainability_certification_dashboard_date1_XPATH");
//			type("sustainability_certification_dashboard_date1_XPATH", date1_String);
//			ngDriver.waitForAngularRequestsToFinish();
//			System.out.println("Entered todays date in the date field of the active certification section.");

			// wait for the element
			Thread.sleep(5000);

			// validate leed count of the section 1
			switchVerification("sustainability_certification_dashboard_section1_count1_XPATH", "0",
					"The correct count is not displayed.");

			// validate well building standard count of the section 1
			switchVerification("sustainability_certification_dashboard_section1_count2_XPATH", "0",
					"The correct count is not displayed.");

			// validate boma best count of the section 1
			switchVerification("sustainability_certification_dashboard_section1_count3_XPATH", "0",
					"The correct count is not displayed.");

			// validate fitwel count of the section 1
			switchVerification("sustainability_certification_dashboard_section1_count4_XPATH", "0",
					"The correct count is not displayed.");

			// validate wiredscore count of the section 1
			switchVerification("sustainability_certification_dashboard_section1_count5_XPATH", "0",
					"The correct count is not displayed.");

//			// enter current year in the year field of the expiring certification section
//			LocalDate date2 = LocalDate.now();
//			String date2_String = date2.toString();
//			String[] Year = date2_String.split("-");
//			String Year_actual = Year[0];
//
//			clear("sustainability_certification_dashboard_date2_XPATH");
//			type("sustainability_certification_dashboard_date2_XPATH", Year_actual);
//			ngDriver.waitForAngularRequestsToFinish();
//			System.out.println("Entered current year in the year field of the expiring certification section.");

			// wait for the element
			Thread.sleep(5000);

			// validate leed count of the section 2
			switchVerification("sustainability_certification_dashboard_section2_count1_XPATH", "1",
					"The correct count is not displayed.");

			// validate the count of the sub type of the leed of the section 2
			switchVerification("sustainability_certification_dashboard_section2_count11_XPATH", "1",
					"The correct count is not displayed.");

			// validate well building standard count of the section 2
			switchVerification("sustainability_certification_dashboard_section2_count2_XPATH", "0",
					"The correct count is not displayed.");

			// validate boma best count of the section 2
			switchVerification("sustainability_certification_dashboard_section2_count3_XPATH", "0",
					"The correct count is not displayed.");

			// validate fitwel count of the section 2
			switchVerification("sustainability_certification_dashboard_section2_count4_XPATH", "1",
					"The correct count is not displayed.");

			// validate the count of the sub type of the fitwel of the section 2
			switchVerification("sustainability_certification_dashboard_section2_count44_XPATH", "1",
					"The correct count is not displayed.");

			// validate wiredscore count of the section 2
			switchVerification("sustainability_certification_dashboard_section2_count5_XPATH", "0",
					"The correct count is not displayed.");

//			// enter todays date in the date field of the Properties Not Certified section
//			LocalDate date3 = LocalDate.now();
//			String date3_String = date3.toString();
//			clear("sustainability_certification_dashboard_date3_XPATH");
//			type("sustainability_certification_dashboard_date3_XPATH", date3_String);
//			ngDriver.waitForAngularRequestsToFinish();
//			System.out.println("Entered todays date in the date field of the Properties Not Certified section.");

			// wait for the element
			Thread.sleep(5000);

			// validate leed count of the section 3
			switchVerification("sustainability_certification_dashboard_section3_count1_XPATH", "4",
					"The correct count is not displayed.");

			// validate well building standard count of the section 3
			switchVerification("sustainability_certification_dashboard_section3_count2_XPATH", "4",
					"The correct count is not displayed.");

			// validate boma best count of the section 3
			switchVerification("sustainability_certification_dashboard_section3_count3_XPATH", "4",
					"The correct count is not displayed.");

			// validate fitwel count of the section 3
			switchVerification("sustainability_certification_dashboard_section3_count4_XPATH", "4",
					"The correct count is not displayed.");

			// validate wiredscore count of the section 3
			switchVerification("sustainability_certification_dashboard_section3_count5_XPATH", "4",
					"The correct count is not displayed.");
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

		// UPDATE THE STATUS OF THE CERTIFICATION VIA SUSTAINABILITY MODULE - BOMA BEST
		// - DENIED TO PENDING

		System.out.println(
				"***************** UPDATE THE STATUS OF THE CERTIFICATION VIA DASHBOARD - BOMA BEST - DENIED TO PENDING *****************");
		test.log(LogStatus.INFO,
				"***************** UPDATE THE STATUS OF THE CERTIFICATION VIA DASHBOARD - BOMA BEST - DENIED TO PENDING *****************");
		Reporter.log(
				"***************** UPDATE THE STATUS OF THE CERTIFICATION VIA DASHBOARD - BOMA BEST - DENIED TO PENDING *****************");
		log.info(
				"***************** UPDATE THE STATUS OF THE CERTIFICATION VIA DASHBOARD - BOMA BEST - DENIED TO PENDING *****************");

		try {
			// enter the property name in the search field
			type("envreports_propertylist_filtertxt_CSS", data.get("property_1"));
			ngDriver.waitForAngularRequestsToFinish();
			System.out.println("Entered the property name in the search field.");

			// click on the sustainability icon
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

			// enter the certificate name in the search field
			type("sustainability_searchtxt_XPATH", data.get("name_1"));
			ngDriver.waitForAngularRequestsToFinish();
			System.out.println("Entered the certificate name in the search field.");

			// click on the searched certification
			String name1 = "//td[text()='" + data.get("name_1") + "']";
			driver.findElement(By.xpath(name1)).click();
			ngDriver.waitForAngularRequestsToFinish();
			System.out.println("Clicked on the searched certification.");

			// select the certification status from the dropdown
			select("sustainability_certification_certificationstatus_XPATH", data.get("status_2"));
			ngDriver.waitForAngularRequestsToFinish();
			System.out.println("Selected the certification status from the dropdown.");

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

			// click on the home icon from the top of the screen
			click("questionnaire_homeburgermenubtn_hide_CSS");
			System.out.println("Clicked on the home icon from the top of the screen.");
			ngDriver.waitForAngularRequestsToFinish();

			// synchronization
			explicitWait("propertylist_title_XPATH");

			// verify the property list
			switchVerification("propertylist_title_XPATH", "Property List", "The property list is not displayed.");

			// wait for the element
			Thread.sleep(5000);

			// click on the side menu
			click("menubtn_CSS");
			ngDriver.waitForAngularRequestsToFinish();
			System.out.println("Clicked on the side menu.");

			// wait for the element
			Thread.sleep(5000);

			// click on the sustainability option
			click("sidemenu_sustainability_CSS");
			ngDriver.waitForAngularRequestsToFinish();
			System.out.println("Clicked on the sustainability option.");

			// select the building certifications option from the dashboard drop down
			select("ssc_sustainability_dashboarddd_CSS", data.get("dashboard_1"));
			ngDriver.waitForAngularRequestsToFinish();
			System.out.println("Selected the building certifications option from the dashboard drop down.");

//			// enter todays date in the date field of the active certification section
//			LocalDate date1 = LocalDate.now();
//			String date1_String = date1.toString();
//			clear("sustainability_certification_dashboard_date1_XPATH");
//			type("sustainability_certification_dashboard_date1_XPATH", date1_String);
//			ngDriver.waitForAngularRequestsToFinish();
//			System.out.println("Entered todays date in the date field of the active certification section.");

			// wait for the element
			Thread.sleep(5000);

			// validate leed count of the section 1
			switchVerification("sustainability_certification_dashboard_section1_count1_XPATH", "0",
					"The correct count is not displayed.");

			// validate well building standard count of the section 1
			switchVerification("sustainability_certification_dashboard_section1_count2_XPATH", "0",
					"The correct count is not displayed.");

			// validate boma best count of the section 1
			switchVerification("sustainability_certification_dashboard_section1_count3_XPATH", "1",
					"The correct count is not displayed.");

			// validate sub title of the boma best count of the section 1
			switchVerification("sustainability_certification_dashboard_section1_count33_XPATH", "1",
					"The correct count is not displayed.");

			// validate fitwel count of the section 1
			switchVerification("sustainability_certification_dashboard_section1_count4_XPATH", "0",
					"The correct count is not displayed.");

			// validate wiredscore count of the section 1
			switchVerification("sustainability_certification_dashboard_section1_count5_XPATH", "0",
					"The correct count is not displayed.");

//			// enter current year in the year field of the expiring certification section
//			LocalDate date2 = LocalDate.now();
//			String date2_String = date2.toString();
//			String[] Year = date2_String.split("-");
//			String Year_actual = Year[0];
//
//			clear("sustainability_certification_dashboard_date2_XPATH");
//			type("sustainability_certification_dashboard_date2_XPATH", Year_actual);
//			ngDriver.waitForAngularRequestsToFinish();
//			System.out.println("Entered current year in the year field of the expiring certification section.");

			// wait for the element
			Thread.sleep(5000);

			// validate leed count of the section 2
			switchVerification("sustainability_certification_dashboard_section2_count1_XPATH", "1",
					"The correct count is not displayed.");

			// validate the count of the sub type of the leed of the section 2
			switchVerification("sustainability_certification_dashboard_section2_count11_XPATH", "1",
					"The correct count is not displayed.");

			// validate well building standard count of the section 2
			switchVerification("sustainability_certification_dashboard_section2_count2_XPATH", "0",
					"The correct count is not displayed.");

			// validate boma best count of the section 2
			switchVerification("sustainability_certification_dashboard_section2_count3_XPATH", "1",
					"The correct count is not displayed.");

			// validate sub title of the boma best count of the section 2
			switchVerification("sustainability_certification_dashboard_section2_count33_XPATH", "1",
					"The correct count is not displayed.");

			// validate fitwel count of the section 2
			switchVerification("sustainability_certification_dashboard_section2_count4_XPATH", "1",
					"The correct count is not displayed.");

			// validate the count of the sub type of the fitwel of the section 2
			switchVerification("sustainability_certification_dashboard_section2_count44_XPATH", "1",
					"The correct count is not displayed.");

			// validate wiredscore count of the section 2
			switchVerification("sustainability_certification_dashboard_section2_count5_XPATH", "0",
					"The correct count is not displayed.");

//			// enter todays date in the date field of the Properties Not Certified section
//			LocalDate date3 = LocalDate.now();
//			String date3_String = date3.toString();
//			clear("sustainability_certification_dashboard_date3_XPATH");
//			type("sustainability_certification_dashboard_date3_XPATH", date3_String);
//			ngDriver.waitForAngularRequestsToFinish();
//			System.out.println("Entered todays date in the date field of the Properties Not Certified section.");

			// wait for the element
			Thread.sleep(5000);

			// validate leed count of the section 3
			switchVerification("sustainability_certification_dashboard_section3_count1_XPATH", "4",
					"The correct count is not displayed.");

			// validate well building standard count of the section 3
			switchVerification("sustainability_certification_dashboard_section3_count2_XPATH", "4",
					"The correct count is not displayed.");

			// validate boma best count of the section 3
			switchVerification("sustainability_certification_dashboard_section3_count3_XPATH", "3",
					"The correct count is not displayed.");

			// validate fitwel count of the section 3
			switchVerification("sustainability_certification_dashboard_section3_count4_XPATH", "4",
					"The correct count is not displayed.");

			// validate wiredscore count of the section 3
			switchVerification("sustainability_certification_dashboard_section3_count5_XPATH", "4",
					"The correct count is not displayed.");

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

		// UPDATE THE EFFECTIVE DATE OF THE EACH SECTION AND VALIDATE THE COUNT

		System.out.println(
				"***************** UPDATE THE EFFECTIVE DATE OF THE EACH SECTION AND VALIDATE THE COUNT *****************");
		test.log(LogStatus.INFO,
				"***************** UPDATE THE EFFECTIVE DATE OF THE EACH SECTION AND VALIDATE THE COUNT *****************");
		Reporter.log(
				"***************** UPDATE THE EFFECTIVE DATE OF THE EACH SECTION AND VALIDATE THE COUNT *****************");
		log.info(
				"***************** UPDATE THE EFFECTIVE DATE OF THE EACH SECTION AND VALIDATE THE COUNT *****************");

		try {
			// wait for the element
			Thread.sleep(5000);

			// click on the side menu
			click("menubtn_CSS");
			ngDriver.waitForAngularRequestsToFinish();
			System.out.println("Clicked on the side menu.");

			// wait for the element
			Thread.sleep(5000);

			// click on the sustainability option
			click("sidemenu_sustainability_CSS");
			ngDriver.waitForAngularRequestsToFinish();
			System.out.println("Clicked on the sustainability option.");

			// select the building certifications option from the dashboard drop down
			select("ssc_sustainability_dashboarddd_CSS", data.get("dashboard_1"));
			ngDriver.waitForAngularRequestsToFinish();
			System.out.println("Selected the building certifications option from the dashboard drop down.");

			// enter 2 dates in future in the date field of the active certification section
			LocalDate futureDate1 = LocalDate.now().plusDays(2);
			String futureDate1_String = futureDate1.toString();
			clear("sustainability_certification_dashboard_date1_XPATH");
			type("sustainability_certification_dashboard_date1_XPATH", futureDate1_String);
			ngDriver.waitForAngularRequestsToFinish();
			System.out.println("Entered 2 dates in future in the date field of the active certification section.");

			// wait for the element
			Thread.sleep(5000);

			// validate leed count of the section 1
			switchVerification("sustainability_certification_dashboard_section1_count1_XPATH", "1",
					"The correct count is not displayed.");

			// validate well building standard count of the section 1
			switchVerification("sustainability_certification_dashboard_section1_count2_XPATH", "0",
					"The correct count is not displayed.");

			// validate boma best count of the section 1
			switchVerification("sustainability_certification_dashboard_section1_count3_XPATH", "1",
					"The correct count is not displayed.");

			// validate sub title of the boma best count of the section 1
			switchVerification("sustainability_certification_dashboard_section1_count33_XPATH", "1",
					"The correct count is not displayed.");

			// validate fitwel count of the section 1
			switchVerification("sustainability_certification_dashboard_section1_count4_XPATH", "0",
					"The correct count is not displayed.");

			// validate wiredscore count of the section 1
			switchVerification("sustainability_certification_dashboard_section1_count5_XPATH", "0",
					"The correct count is not displayed.");

			// enter 14 dates in future in the date field of the active certification
			// section
			LocalDate futureDate11 = LocalDate.now().plusDays(14);
			String futureDate11_String = futureDate11.toString();
			clear("sustainability_certification_dashboard_date1_XPATH");
			type("sustainability_certification_dashboard_date1_XPATH", futureDate11_String);
			ngDriver.waitForAngularRequestsToFinish();
			System.out.println("Entered 14 dates in future in the date field of the active certification section.");

			// wait for the element
			Thread.sleep(5000);

			// validate leed count of the section 1
			switchVerification("sustainability_certification_dashboard_section1_count1_XPATH", "0",
					"The correct count is not displayed.");

			// validate well building standard count of the section 1
			switchVerification("sustainability_certification_dashboard_section1_count2_XPATH", "0",
					"The correct count is not displayed.");

			// validate boma best count of the section 1
			switchVerification("sustainability_certification_dashboard_section1_count3_XPATH", "0",
					"The correct count is not displayed.");

			// validate fitwel count of the section 1
			switchVerification("sustainability_certification_dashboard_section1_count4_XPATH", "0",
					"The correct count is not displayed.");

			// validate wiredscore count of the section 1
			switchVerification("sustainability_certification_dashboard_section1_count5_XPATH", "0",
					"The correct count is not displayed.");

			// enter current year in the year field of the expiring certification section
			LocalDate futureDate2 = LocalDate.now().plusYears(1);
			String futureDate2_String = futureDate2.toString();
			String[] Year2 = futureDate2_String.split("-");
			String Year2_actual = Year2[0];

			clear("sustainability_certification_dashboard_date2_XPATH");
			type("sustainability_certification_dashboard_date2_XPATH", Year2_actual);
			ngDriver.waitForAngularRequestsToFinish();
			System.out.println("Entered current year in the year field of the expiring certification section.");

			// wait for the element
			Thread.sleep(5000);

			// validate leed count of the section 2
			switchVerification("sustainability_certification_dashboard_section2_count1_XPATH", "0",
					"The correct count is not displayed.");

			// validate well building standard count of the section 2
			switchVerification("sustainability_certification_dashboard_section2_count2_XPATH", "0",
					"The correct count is not displayed.");

			// validate boma best count of the section 2
			switchVerification("sustainability_certification_dashboard_section2_count3_XPATH", "0",
					"The correct count is not displayed.");

			// validate fitwel count of the section 2
			switchVerification("sustainability_certification_dashboard_section2_count4_XPATH", "0",
					"The correct count is not displayed.");

			// validate wiredscore count of the section 2
			switchVerification("sustainability_certification_dashboard_section2_count5_XPATH", "0",
					"The correct count is not displayed.");

			// enter 7 dates in future in the date field of the Properties Not Certified
			// section
			LocalDate futureDate3 = LocalDate.now().plusDays(7);
			String futureDate3_String = futureDate3.toString();
			clear("sustainability_certification_dashboard_date3_XPATH");
			type("sustainability_certification_dashboard_date3_XPATH", futureDate3_String);
			ngDriver.waitForAngularRequestsToFinish();
			System.out.println("Entered 7 dates in future in the date field of the Properties Not Certified section.");

			// wait for the element
			Thread.sleep(5000);

			// validate leed count of the section 3
			switchVerification("sustainability_certification_dashboard_section3_count1_XPATH", "3",
					"The correct count is not displayed.");

			// validate well building standard count of the section 3
			switchVerification("sustainability_certification_dashboard_section3_count2_XPATH", "4",
					"The correct count is not displayed.");

			// validate boma best count of the section 3
			switchVerification("sustainability_certification_dashboard_section3_count3_XPATH", "3",
					"The correct count is not displayed.");

			// validate fitwel count of the section 3
			switchVerification("sustainability_certification_dashboard_section3_count4_XPATH", "4",
					"The correct count is not displayed.");

			// validate wiredscore count of the section 3
			switchVerification("sustainability_certification_dashboard_section3_count5_XPATH", "4",
					"The correct count is not displayed.");

			// enter 14 dates in future in the date field of the Properties Not Certified
			// section
			LocalDate futureDate33 = LocalDate.now().plusDays(14);
			String futureDate33_String = futureDate33.toString();
			clear("sustainability_certification_dashboard_date3_XPATH");
			type("sustainability_certification_dashboard_date3_XPATH", futureDate33_String);
			ngDriver.waitForAngularRequestsToFinish();
			System.out.println("Entered 14 dates in future in the date field of the Properties Not Certified section.");

			// wait for the element
			Thread.sleep(5000);

			// validate leed count of the section 3
			switchVerification("sustainability_certification_dashboard_section3_count1_XPATH", "4",
					"The correct count is not displayed.");

			// validate well building standard count of the section 3
			switchVerification("sustainability_certification_dashboard_section3_count2_XPATH", "4",
					"The correct count is not displayed.");

			// validate boma best count of the section 3
			switchVerification("sustainability_certification_dashboard_section3_count3_XPATH", "4",
					"The correct count is not displayed.");

			// validate fitwel count of the section 3
			switchVerification("sustainability_certification_dashboard_section3_count4_XPATH", "4",
					"The correct count is not displayed.");

			// validate wiredscore count of the section 3
			switchVerification("sustainability_certification_dashboard_section3_count5_XPATH", "4",
					"The correct count is not displayed.");

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

		// UPDATE THE YEAR OF THE ACTIVE CERIFICATE - LEED

		System.out.println("***************** UPDATE THE YEAR OF THE ACTIVE CERIFICATE - LEED *****************");
		test.log(LogStatus.INFO, "***************** UPDATE THE YEAR OF THE ACTIVE CERIFICATE - LEED *****************");
		Reporter.log("***************** UPDATE THE YEAR OF THE ACTIVE CERIFICATE - LEED *****************");
		log.info("***************** UPDATE THE YEAR OF THE ACTIVE CERIFICATE - LEED *****************");

		try {
			// wait for the element
			Thread.sleep(5000);

			// click on the side menu
			click("menubtn_CSS");
			ngDriver.waitForAngularRequestsToFinish();
			System.out.println("Clicked on the side menu.");

			// wait for the element
			Thread.sleep(5000);

			// click on the sustainability option
			click("sidemenu_sustainability_CSS");
			ngDriver.waitForAngularRequestsToFinish();
			System.out.println("Clicked on the sustainability option.");

			// select the building certifications option from the dashboard drop down
			select("ssc_sustainability_dashboarddd_CSS", data.get("dashboard_1"));
			ngDriver.waitForAngularRequestsToFinish();
			System.out.println("Selected the building certifications option from the dashboard drop down.");

			// enter 2 dates in future in the date field of the active certification section
			LocalDate futureDate1 = LocalDate.now().plusDays(2);
			String futureDate1_String = futureDate1.toString();
			clear("sustainability_certification_dashboard_date1_XPATH");
			type("sustainability_certification_dashboard_date1_XPATH", futureDate1_String);
			ngDriver.waitForAngularRequestsToFinish();
			System.out.println("Entered 2 dates in future in the date field of the active certification section.");

			// click on the count of the active certification
			click("sustainability_certification_dashboard_section1_count1_XPATH");
			ngDriver.waitForAngularRequestsToFinish();
			System.out.println("Clicked on the count of the active certification.");

			// click on the count of the sub type of the active certificate
			click("sustainability_certification_dashboard_section1_count11_XPATH");
			ngDriver.waitForAngularRequestsToFinish();
			System.out.println("Clicked on the count of the sub type of the active certificate.");

			// validate active certification title
			switchVerification("sustainability_activecertification_title_XPATH", "Active Certifications:",
					"The Active Certifications title is not displayed.");

			// enter the name of the property in the search field
			type("sustainability_searchtxt_XPATH", data.get("property_1"));
			ngDriver.waitForAngularRequestsToFinish();
			System.out.println("Entered the name of the property in the search field.");

			// click on the searched property
			String propertyName = "//td[contains(text(),'" + data.get("property_1") + "')]";
			driver.findElement(By.xpath(propertyName)).click();
			ngDriver.waitForAngularRequestsToFinish();
			System.out.println("Clicked on the searched property.");

			// update the expiration date
			LocalDate futureDate3 = LocalDate.now().plusYears(1);
			String futureDate3_String = futureDate3.toString();
//			String[] Year3 = futureDate3_String.split("-");
//			String Year3_actual = Year3[0];
			clear("sustainability_certification_certificationexpiration_XPATH");
			type("sustainability_certification_certificationexpiration_XPATH", futureDate3_String);
			ngDriver.waitForAngularRequestsToFinish();
			System.out.println("Updated the expiration date.");

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

			// click on the back to dashboard button
			click("sustainability_activecertification_backtodashboardbtn_XPATH");
			ngDriver.waitForAngularRequestsToFinish();
			System.out.println("Clicked on the back to dashboard button.");

			// select the building certifications option from the dashboard drop down
			select("ssc_sustainability_dashboarddd_CSS", data.get("dashboard_1"));
			ngDriver.waitForAngularRequestsToFinish();
			System.out.println("Selected the building certifications option from the dashboard drop down.");

			// enter 2 dates in future in the date field of the active certification section
			LocalDate futureDate4 = LocalDate.now().plusDays(2);
			String futureDate4_String = futureDate4.toString();
			clear("sustainability_certification_dashboard_date1_XPATH");
			type("sustainability_certification_dashboard_date1_XPATH", futureDate4_String);
			ngDriver.waitForAngularRequestsToFinish();
			System.out.println("Entered 2 dates in future in the date field of the active certification section.");

			// wait for the element
			Thread.sleep(5000);

			// validate leed count of the section 1
			switchVerification("sustainability_certification_dashboard_section1_count1_XPATH", "1",
					"The correct count is not displayed.");

			// validate well building standard count of the section 1
			switchVerification("sustainability_certification_dashboard_section1_count2_XPATH", "0",
					"The correct count is not displayed.");

			// validate boma best count of the section 1
			switchVerification("sustainability_certification_dashboard_section1_count3_XPATH", "1",
					"The correct count is not displayed.");

			// validate sub title of the boma best count of the section 1
			switchVerification("sustainability_certification_dashboard_section1_count33_XPATH", "1",
					"The correct count is not displayed.");

			// validate fitwel count of the section 1
			switchVerification("sustainability_certification_dashboard_section1_count4_XPATH", "0",
					"The correct count is not displayed.");

			// validate wiredscore count of the section 1
			switchVerification("sustainability_certification_dashboard_section1_count5_XPATH", "0",
					"The correct count is not displayed.");

			// enter 14 dates in future in the date field of the active certification
			// section
			LocalDate futureDate11 = LocalDate.now().plusDays(14);
			String futureDate11_String = futureDate11.toString();
			clear("sustainability_certification_dashboard_date1_XPATH");
			type("sustainability_certification_dashboard_date1_XPATH", futureDate11_String);
			ngDriver.waitForAngularRequestsToFinish();
			System.out.println("Entered 14 dates in future in the date field of the active certification section.");

			// wait for the element
			Thread.sleep(5000);

			// validate leed count of the section 1
			switchVerification("sustainability_certification_dashboard_section1_count1_XPATH", "1",
					"The correct count is not displayed.");

			// validate well building standard count of the section 1
			switchVerification("sustainability_certification_dashboard_section1_count2_XPATH", "0",
					"The correct count is not displayed.");

			// validate boma best count of the section 1
			switchVerification("sustainability_certification_dashboard_section1_count3_XPATH", "0",
					"The correct count is not displayed.");

			// validate fitwel count of the section 1
			switchVerification("sustainability_certification_dashboard_section1_count4_XPATH", "0",
					"The correct count is not displayed.");

			// validate wiredscore count of the section 1
			switchVerification("sustainability_certification_dashboard_section1_count5_XPATH", "0",
					"The correct count is not displayed.");

			// enter next year in the year field of the expiring certification section
			LocalDate futureDate6 = LocalDate.now().plusYears(1);
			String futureDate6_String = futureDate6.toString();
			String[] Year6 = futureDate6_String.split("-");
			String Year6_actual = Year6[0];

			clear("sustainability_certification_dashboard_date2_XPATH");
			type("sustainability_certification_dashboard_date2_XPATH", Year6_actual);
			ngDriver.waitForAngularRequestsToFinish();
			System.out.println("Entered next year in the year field of the expiring certification section.");

			// wait for the element
			Thread.sleep(5000);

			// validate leed count of the section 2
			switchVerification("sustainability_certification_dashboard_section2_count1_XPATH", "1",
					"The correct count is not displayed.");

			// validate well building standard count of the section 2
			switchVerification("sustainability_certification_dashboard_section2_count2_XPATH", "0",
					"The correct count is not displayed.");

			// validate boma best count of the section 2
			switchVerification("sustainability_certification_dashboard_section2_count3_XPATH", "0",
					"The correct count is not displayed.");

			// validate fitwel count of the section 2
			switchVerification("sustainability_certification_dashboard_section2_count4_XPATH", "0",
					"The correct count is not displayed.");

			// validate wiredscore count of the section 2
			switchVerification("sustainability_certification_dashboard_section2_count5_XPATH", "0",
					"The correct count is not displayed.");

			// enter 7 dates in future in the date field of the Properties Not Certified
			// section
			LocalDate futureDate7 = LocalDate.now().plusDays(7);
			String futureDate7_String = futureDate7.toString();
			clear("sustainability_certification_dashboard_date3_XPATH");
			type("sustainability_certification_dashboard_date3_XPATH", futureDate7_String);
			ngDriver.waitForAngularRequestsToFinish();
			System.out.println("Entered 7 dates in future in the date field of the Properties Not Certified section.");

			// wait for the element
			Thread.sleep(5000);

			// validate leed count of the section 3
			switchVerification("sustainability_certification_dashboard_section3_count1_XPATH", "3",
					"The correct count is not displayed.");

			// validate well building standard count of the section 3
			switchVerification("sustainability_certification_dashboard_section3_count2_XPATH", "4",
					"The correct count is not displayed.");

			// validate boma best count of the section 3
			switchVerification("sustainability_certification_dashboard_section3_count3_XPATH", "3",
					"The correct count is not displayed.");

			// validate fitwel count of the section 3
			switchVerification("sustainability_certification_dashboard_section3_count4_XPATH", "4",
					"The correct count is not displayed.");

			// validate wiredscore count of the section 3
			switchVerification("sustainability_certification_dashboard_section3_count5_XPATH", "4",
					"The correct count is not displayed.");

			// enter 14 dates in future in the date field of the Properties Not Certified
			// section
			LocalDate futureDate33 = LocalDate.now().plusDays(14);
			String futureDate33_String = futureDate33.toString();
			clear("sustainability_certification_dashboard_date3_XPATH");
			type("sustainability_certification_dashboard_date3_XPATH", futureDate33_String);
			ngDriver.waitForAngularRequestsToFinish();
			System.out.println("Entered 14 dates in future in the date field of the Properties Not Certified section.");

			// wait for the element
			Thread.sleep(5000);

			// validate leed count of the section 3
			switchVerification("sustainability_certification_dashboard_section3_count1_XPATH", "3",
					"The correct count is not displayed.");

			// validate well building standard count of the section 3
			switchVerification("sustainability_certification_dashboard_section3_count2_XPATH", "4",
					"The correct count is not displayed.");

			// validate boma best count of the section 3
			switchVerification("sustainability_certification_dashboard_section3_count3_XPATH", "4",
					"The correct count is not displayed.");

			// validate fitwel count of the section 3
			switchVerification("sustainability_certification_dashboard_section3_count4_XPATH", "4",
					"The correct count is not displayed.");

			// validate wiredscore count of the section 3
			switchVerification("sustainability_certification_dashboard_section3_count5_XPATH", "4",
					"The correct count is not displayed.");

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

		// UPDATE THE YEARS OF THE EXPIRED CERTIFICATE - FITWEL

		System.out.println("***************** UPDATE THE YEARS OF THE EXPIRED CERTIFICATE - FITWEL *****************");
		test.log(LogStatus.INFO,
				"***************** UPDATE THE YEARS OF THE EXPIRED CERTIFICATE - FITWEL *****************");
		Reporter.log("***************** UPDATE THE YEARS OF THE EXPIRED CERTIFICATE - FITWEL *****************");
		log.info("***************** UPDATE THE YEARS OF THE EXPIRED CERTIFICATE - FITWEL *****************");

		try {
			// wait for the element
			Thread.sleep(5000);

			// click on the side menu
			click("menubtn_CSS");
			ngDriver.waitForAngularRequestsToFinish();
			System.out.println("Clicked on the side menu.");

			// wait for the element
			Thread.sleep(5000);

			// click on the sustainability option
			click("sidemenu_sustainability_CSS");
			ngDriver.waitForAngularRequestsToFinish();
			System.out.println("Clicked on the sustainability option.");

			// select the building certifications option from the dashboard drop down
			select("ssc_sustainability_dashboarddd_CSS", data.get("dashboard_1"));
			ngDriver.waitForAngularRequestsToFinish();
			System.out.println("Selected the building certifications option from the dashboard drop down.");

			// click on the count of the sub type of the expired certification
			click("sustainability_certification_dashboard_section2_count44_XPATH");
			ngDriver.waitForAngularRequestsToFinish();
			System.out.println("Clicked on the sub type of the expired certification.");

			// validate active certification title
			switchVerification("sustainability_expiredcertification_title_XPATH", "Expiring Certifications:",
					"The Expiring Certifications title is not displayed.");

			// enter the name of the property in the search field
			type("sustainability_searchtxt_XPATH", data.get("property_1"));
			ngDriver.waitForAngularRequestsToFinish();
			System.out.println("Entered the name of the property in the search field.");

			// click on the searched property
			String propertyName = "//td[contains(text(),'" + data.get("property_1") + "')]";
			driver.findElement(By.xpath(propertyName)).click();
			ngDriver.waitForAngularRequestsToFinish();
			System.out.println("Clicked on the searched property.");

			// update the expiration date
			LocalDate futureDate4 = LocalDate.now().plusYears(2);
			String futureDate4_String = futureDate4.toString();
			clear("sustainability_certification_certificationexpiration_XPATH");
			type("sustainability_certification_certificationexpiration_XPATH", futureDate4_String);
			ngDriver.waitForAngularRequestsToFinish();
			System.out.println("Updated the expiration date.");

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

			// click on the back to dashboard button
			click("sustainability_activecertification_backtodashboardbtn_XPATH");
			ngDriver.waitForAngularRequestsToFinish();
			System.out.println("Clicked on the back to dashboard button.");

			// select the building certifications option from the dashboard drop down
			select("ssc_sustainability_dashboarddd_CSS", data.get("dashboard_1"));
			ngDriver.waitForAngularRequestsToFinish();
			System.out.println("Selected the building certifications option from the dashboard drop down.");

			// wait for the element
			Thread.sleep(5000);

			// validate leed count of the section 1
			switchVerification("sustainability_certification_dashboard_section1_count1_XPATH", "0",
					"The correct count is not displayed.");

			// validate well building standard count of the section 1
			switchVerification("sustainability_certification_dashboard_section1_count2_XPATH", "0",
					"The correct count is not displayed.");

			// validate boma best count of the section 1
			switchVerification("sustainability_certification_dashboard_section1_count3_XPATH", "1",
					"The correct count is not displayed.");

			// validate sub title of the boma best count of the section 1
			switchVerification("sustainability_certification_dashboard_section1_count33_XPATH", "1",
					"The correct count is not displayed.");

			// validate fitwel count of the section 1
			switchVerification("sustainability_certification_dashboard_section1_count4_XPATH", "1",
					"The correct count is not displayed.");

			// validate count of the sub type of the fitwel of the section 1
			switchVerification("sustainability_certification_dashboard_section1_count44_XPATH", "1",
					"The correct count is not displayed.");

			// validate wiredscore count of the section 1
			switchVerification("sustainability_certification_dashboard_section1_count5_XPATH", "0",
					"The correct count is not displayed.");

			// validate leed count of the section 2
			switchVerification("sustainability_certification_dashboard_section2_count1_XPATH", "0",
					"The correct count is not displayed.");

			// validate well building standard count of the section 2
			switchVerification("sustainability_certification_dashboard_section2_count2_XPATH", "0",
					"The correct count is not displayed.");

			// validate boma best count of the section 2
			switchVerification("sustainability_certification_dashboard_section2_count3_XPATH", "1",
					"The correct count is not displayed.");

			// validate boma best count of the section 2 - sub type
			switchVerification("sustainability_certification_dashboard_section2_count33_XPATH", "1",
					"The correct count is not displayed.");

			// validate fitwel count of the section 2
			switchVerification("sustainability_certification_dashboard_section2_count4_XPATH", "0",
					"The correct count is not displayed.");

			// validate wiredscore count of the section 2
			switchVerification("sustainability_certification_dashboard_section2_count5_XPATH", "0",
					"The correct count is not displayed.");

			// enter 2 years after in the year field of the expiring certification section
			LocalDate futureDate7 = LocalDate.now().plusYears(2);
			String futureDate7_String = futureDate7.toString();
			String[] Year7 = futureDate7_String.split("-");
			String Year7_actual = Year7[0];

			clear("sustainability_certification_dashboard_date2_XPATH");
			type("sustainability_certification_dashboard_date2_XPATH", Year7_actual);
			ngDriver.waitForAngularRequestsToFinish();
			System.out.println("Entered 2 years after in the year field of the expiring certification section.");

			// wait for the element
			Thread.sleep(5000);

			// validate leed count of the section 2
			switchVerification("sustainability_certification_dashboard_section2_count1_XPATH", "0",
					"The correct count is not displayed.");

			// validate well building standard count of the section 2
			switchVerification("sustainability_certification_dashboard_section2_count2_XPATH", "0",
					"The correct count is not displayed.");

			// validate boma best count of the section 2
			switchVerification("sustainability_certification_dashboard_section2_count3_XPATH", "0",
					"The correct count is not displayed.");

			// validate fitwel count of the section 2
			switchVerification("sustainability_certification_dashboard_section2_count4_XPATH", "1",
					"The correct count is not displayed.");

			// validate wiredscore count of the section 2
			switchVerification("sustainability_certification_dashboard_section2_count5_XPATH", "0",
					"The correct count is not displayed.");

			// enter 2 years before in the year field of the expiring certification section
			LocalDate futureDate8 = LocalDate.now().minusYears(2);
			String futureDate8_String = futureDate8.toString();
			String[] Year8 = futureDate8_String.split("-");
			String Year8_actual = Year8[0];

			clear("sustainability_certification_dashboard_date2_XPATH");
			type("sustainability_certification_dashboard_date2_XPATH", Year8_actual);
			ngDriver.waitForAngularRequestsToFinish();
			System.out.println("Entered 2 years before in the year field of the expiring certification section.");

			// wait for the element
			Thread.sleep(5000);

			// validate leed count of the section 2
			switchVerification("sustainability_certification_dashboard_section2_count1_XPATH", "0",
					"The correct count is not displayed.");

			// validate well building standard count of the section 2
			switchVerification("sustainability_certification_dashboard_section2_count2_XPATH", "0",
					"The correct count is not displayed.");

			// validate boma best count of the section 2
			switchVerification("sustainability_certification_dashboard_section2_count3_XPATH", "0",
					"The correct count is not displayed.");

			// validate fitwel count of the section 2
			switchVerification("sustainability_certification_dashboard_section2_count4_XPATH", "0",
					"The correct count is not displayed.");

			// validate wiredscore count of the section 2
			switchVerification("sustainability_certification_dashboard_section2_count5_XPATH", "0",
					"The correct count is not displayed.");

			// validate leed count of the section 3
			switchVerification("sustainability_certification_dashboard_section3_count1_XPATH", "4",
					"The correct count is not displayed.");

			// validate well building standard count of the section 3
			switchVerification("sustainability_certification_dashboard_section3_count2_XPATH", "4",
					"The correct count is not displayed.");

			// validate boma best count of the section 3
			switchVerification("sustainability_certification_dashboard_section3_count3_XPATH", "3",
					"The correct count is not displayed.");

			// validate fitwel count of the section 3
			switchVerification("sustainability_certification_dashboard_section3_count4_XPATH", "3",
					"The correct count is not displayed.");

			// validate wiredscore count of the section 3
			switchVerification("sustainability_certification_dashboard_section3_count5_XPATH", "4",
					"The correct count is not displayed.");

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

		// UPDATE EXPIRED CERTIFICATE WITH DENIED STATUS - BOMA BEST

		System.out.println(
				"***************** UPDATE EXPIRED CERTIFICATE WITH DENIED STATUS - BOMA BEST *****************");
		test.log(LogStatus.INFO,
				"***************** UPDATE EXPIRED CERTIFICATE WITH DENIED STATUS - BOMA BEST *****************");
		Reporter.log("***************** UPDATE EXPIRED CERTIFICATE WITH DENIED STATUS - BOMA BEST *****************");
		log.info("***************** UPDATE EXPIRED CERTIFICATE WITH DENIED STATUS - BOMA BEST *****************");

		try {
			// wait for the element
			Thread.sleep(5000);

			// click on the side menu
			click("menubtn_CSS");
			ngDriver.waitForAngularRequestsToFinish();
			System.out.println("Clicked on the side menu.");

			// wait for the element
			Thread.sleep(5000);

			// click on the sustainability option
			click("sidemenu_sustainability_CSS");
			ngDriver.waitForAngularRequestsToFinish();
			System.out.println("Clicked on the sustainability option.");

			// select the building certifications option from the dashboard drop down
			select("ssc_sustainability_dashboarddd_CSS", data.get("dashboard_1"));
			ngDriver.waitForAngularRequestsToFinish();
			System.out.println("Selected the building certifications option from the dashboard drop down.");

			// click on the count of the sub type of the expired certification
			click("sustainability_certification_dashboard_section2_count33_XPATH");
			ngDriver.waitForAngularRequestsToFinish();
			System.out.println("Clicked on the sub type of the expired certification.");

			// validate active certification title
			switchVerification("sustainability_expiredcertification_title_XPATH", "Expiring Certifications:",
					"The Expiring Certifications title is not displayed.");

			// enter the name of the property in the search field
			type("sustainability_searchtxt_XPATH", data.get("property_1"));
			ngDriver.waitForAngularRequestsToFinish();
			System.out.println("Entered the name of the property in the search field.");

			// click on the searched property
			String propertyName = "//td[contains(text(),'" + data.get("property_1") + "')]";
			driver.findElement(By.xpath(propertyName)).click();
			ngDriver.waitForAngularRequestsToFinish();
			System.out.println("Clicked on the searched property.");

			// update the status of the expired certificate
			select("sustainability_certification_certificationstatus_XPATH", data.get("status_3"));
			ngDriver.waitForAngularRequestsToFinish();
			System.out.println("Updated the status of the expired certificate.");

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

			// click on the back to dashboard button
			click("sustainability_activecertification_backtodashboardbtn_XPATH");
			ngDriver.waitForAngularRequestsToFinish();
			System.out.println("Clicked on the back to dashboard button.");

			// select the building certifications option from the dashboard drop down
			select("ssc_sustainability_dashboarddd_CSS", data.get("dashboard_1"));
			ngDriver.waitForAngularRequestsToFinish();
			System.out.println("Selected the building certifications option from the dashboard drop down.");

			// wait for the element
			Thread.sleep(5000);

			// validate leed count of the section 1
			switchVerification("sustainability_certification_dashboard_section1_count1_XPATH", "0",
					"The correct count is not displayed.");

			// validate well building standard count of the section 1
			switchVerification("sustainability_certification_dashboard_section1_count2_XPATH", "0",
					"The correct count is not displayed.");

			// validate boma best count of the section 1
			switchVerification("sustainability_certification_dashboard_section1_count3_XPATH", "0",
					"The correct count is not displayed.");

			// validate fitwel count of the section 1
			switchVerification("sustainability_certification_dashboard_section1_count4_XPATH", "1",
					"The correct count is not displayed.");

			// validate count of the sub type of the fitwel of the section 1
			switchVerification("sustainability_certification_dashboard_section1_count44_XPATH", "1",
					"The correct count is not displayed.");

			// validate wiredscore count of the section 1
			switchVerification("sustainability_certification_dashboard_section1_count5_XPATH", "0",
					"The correct count is not displayed.");

			// validate leed count of the section 2
			switchVerification("sustainability_certification_dashboard_section2_count1_XPATH", "0",
					"The correct count is not displayed.");

			// validate well building standard count of the section 2
			switchVerification("sustainability_certification_dashboard_section2_count2_XPATH", "0",
					"The correct count is not displayed.");

			// validate boma best count of the section 2
			switchVerification("sustainability_certification_dashboard_section2_count3_XPATH", "0",
					"The correct count is not displayed.");

			// validate fitwel count of the section 2
			switchVerification("sustainability_certification_dashboard_section2_count4_XPATH", "0",
					"The correct count is not displayed.");

			// validate wiredscore count of the section 2
			switchVerification("sustainability_certification_dashboard_section2_count5_XPATH", "0",
					"The correct count is not displayed.");

			// validate leed count of the section 3
			switchVerification("sustainability_certification_dashboard_section3_count1_XPATH", "4",
					"The correct count is not displayed.");

			// validate well building standard count of the section 3
			switchVerification("sustainability_certification_dashboard_section3_count2_XPATH", "4",
					"The correct count is not displayed.");

			// validate boma best count of the section 3
			switchVerification("sustainability_certification_dashboard_section3_count3_XPATH", "4",
					"The correct count is not displayed.");

			// validate fitwel count of the section 3
			switchVerification("sustainability_certification_dashboard_section3_count4_XPATH", "3",
					"The correct count is not displayed.");

			// validate wiredscore count of the section 3
			switchVerification("sustainability_certification_dashboard_section3_count5_XPATH", "4",
					"The correct count is not displayed.");

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

		// ADD NEW RECORD OF THE FITWEL CERTIFICATE IN ANOTHER PROPERTY

		System.out.println(
				"***************** ADD NEW RECORD OF THE FITWEL CERTIFICATE IN ANOTHER PROPERTY - ACTIVE *****************");
		test.log(LogStatus.INFO,
				"***************** ADD NEW RECORD OF THE FITWEL CERTIFICATE IN ANOTHER PROPERTY - ACTIVE *****************");
		Reporter.log(
				"***************** ADD NEW RECORD OF THE FITWEL CERTIFICATE IN ANOTHER PROPERTY - ACTIVE *****************");
		log.info(
				"***************** ADD NEW RECORD OF THE FITWEL CERTIFICATE IN ANOTHER PROPERTY - ACTIVE *****************");

		try {
			// enter the property name in the search field
			type("envreports_propertylist_filtertxt_CSS", data.get("property_2"));
			ngDriver.waitForAngularRequestsToFinish();
			System.out.println("Entered the property name in the search field.");

			// click on the sustainability icon
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

			// click on the add button
			click("sustainability_certification_addbtn_XPATH");
			ngDriver.waitForAngularRequestsToFinish();
			System.out.println("Clicked on the add button.");

			// select the certification type from the dropdown
			select("sustainability_certification_certificationtype_XPATH", data.get("type_1"));
			ngDriver.waitForAngularRequestsToFinish();
			System.out.println("Selected the certification type from the dropdown.");

			// select the certification name from the dropdown
			select("sustainability_certification_certificationname_XPATH", data.get("name_4"));
			ngDriver.waitForAngularRequestsToFinish();
			System.out.println("Selected the certification name from the dropdown.");

			// select the certification sub type from the dropdown
			select("sustainability_certification_certificationsubtype_XPATH", data.get("sub_type_4"));
			ngDriver.waitForAngularRequestsToFinish();
			System.out.println("Selected the certification sub type from the dropdown.");

			// select the level of certification from the dropdown
			select("sustainability_certification_levelofcertification_XPATH", data.get("level_1"));
			ngDriver.waitForAngularRequestsToFinish();
			System.out.println("Selected the level of certification from the dropdown.");

			// enter the certification score in the field
			clear("sustainability_certification_certificationscore_XPATH");
			type("sustainability_certification_certificationscore_XPATH", "5");
			ngDriver.waitForAngularRequestsToFinish();
			System.out.println("Entered the certification score in the field.");

			// enter on the date of certification
			LocalDate date4 = LocalDate.now();
			String currentDate4 = date4.toString();
			clear("sustainability_certification_dateofcertification_XPATH");
			type("sustainability_certification_dateofcertification_XPATH", currentDate4);
			ngDriver.waitForAngularRequestsToFinish();
			System.out.println("Clicked on the date of certification.");

			// enter on the date of certification
			LocalDate date44 = LocalDate.now().plusDays(10);
			String futureDate44 = date44.toString();
			clear("sustainability_certification_certificationexpiration_XPATH");
			type("sustainability_certification_certificationexpiration_XPATH", futureDate44);
			ngDriver.waitForAngularRequestsToFinish();
			System.out.println("Clicked on the date of certification.");

			// select the certification status from the dropdown
			select("sustainability_certification_certificationstatus_XPATH", data.get("status_1"));
			ngDriver.waitForAngularRequestsToFinish();
			System.out.println("Selected the certification status from the dropdown.");

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

			// enter the newly created certification record in the search field
			clear("sustainability_searchtxt_XPATH");
			type("sustainability_searchtxt_XPATH", data.get("name_4"));
			ngDriver.waitForAngularRequestsToFinish();
			System.out.println("Entered the newly created certification record in the search field.");

			// wait for the element
			Thread.sleep(5000);

			// verify the category of the newly created certification record
			switchVerification("sustainability_certification_addedcategory1_XPATH", "Time of Design / Construction",
					"The Time of Design / Construction record is not displayed.");

			// verify the type of the newly created certification record
			switchVerification("sustainability_certification_addedtype4_XPATH", "Fitwel",
					"The Fitwel record is not displayed.");

			// verify the level of the newly created certification record
			switchVerification("sustainability_certification_addedlevel1_XPATH", "Certified",
					"The Certified record is not displayed.");

			// verify the status of the newly created certification record
			switchVerification("sustainability_certification_addedstatus1_XPATH", "Active",
					"The Active record is not displayed.");

			// verify the Certification Date of the newly created certification record
			try {
				String currentDate_XPATH = "//td[text()='" + data.get("type_1") + "']//following-sibling::td[text()='"
						+ currentDate4 + "']";
				String addedDate1 = (driver.findElement(By.xpath(currentDate_XPATH)).getText()).trim();
				if (addedDate1.equals(currentDate4)) {

					successMessage("The Certification Date is verified successfully.");

				} else {

					verificationFailedMessage("The Certification Date is not verified.");

				}
			} catch (Throwable t) {
				verificationFailed();
			}

			// verify the Certification Expiry of the newly created certification record
			try {
				String futureDate_XPATH = "//td[text()='" + data.get("type_1") + "']//following-sibling::td[text()='"
						+ futureDate44 + "']";
				String addedDate2 = (driver.findElement(By.xpath(futureDate_XPATH)).getText()).trim();
				if (addedDate2.equals(futureDate44)) {

					successMessage("The Certification Expiry is verified successfully.");

				} else {

					verificationFailedMessage("The Certification Expiry is not verified.");

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

		// VERIFIED COUNT OF THE ACTIVE AND EXPIRY SECTION FOR BOTH PROPERTIES

		System.out.println(
				"***************** VERIFIED COUNT OF THE ACTIVE AND EXPIRY SECTION FOR BOTH PROPERTIES *****************");
		test.log(LogStatus.INFO,
				"***************** VERIFIED COUNT OF THE ACTIVE AND EXPIRY SECTION FOR BOTH PROPERTIES *****************");
		Reporter.log(
				"***************** VERIFIED COUNT OF THE ACTIVE AND EXPIRY SECTION FOR BOTH PROPERTIES *****************");
		log.info(
				"***************** VERIFIED COUNT OF THE ACTIVE AND EXPIRY SECTION FOR BOTH PROPERTIES *****************");

		try {
			// wait for the element
			Thread.sleep(5000);

			// click on the side menu
			click("menubtn_CSS");
			ngDriver.waitForAngularRequestsToFinish();
			System.out.println("Clicked on the side menu.");

			// wait for the element
			Thread.sleep(5000);

			// click on the sustainability option
			click("sidemenu_sustainability_CSS");
			ngDriver.waitForAngularRequestsToFinish();
			System.out.println("Clicked on the sustainability option.");

			// select the building certifications option from the dashboard drop down
			select("ssc_sustainability_dashboarddd_CSS", data.get("dashboard_1"));
			ngDriver.waitForAngularRequestsToFinish();
			System.out.println("Selected the building certifications option from the dashboard drop down.");

			// wait for the element
			Thread.sleep(5000);

			// validate leed count of the section 1
			switchVerification("sustainability_certification_dashboard_section1_count1_XPATH", "0",
					"The correct count is not displayed.");

			// validate well building standard count of the section 1
			switchVerification("sustainability_certification_dashboard_section1_count2_XPATH", "0",
					"The correct count is not displayed.");

			// validate boma best count of the section 1
			switchVerification("sustainability_certification_dashboard_section1_count3_XPATH", "0",
					"The correct count is not displayed.");

			// validate fitwel count of the section 1
			switchVerification("sustainability_certification_dashboard_section1_count4_XPATH", "2",
					"The correct count is not displayed.");

			// validate count of the sub type of the fitwel of the section 1
			switchVerification("sustainability_certification_dashboard_section1_count44_XPATH", "2",
					"The correct count is not displayed.");

			// validate wiredscore count of the section 1
			switchVerification("sustainability_certification_dashboard_section1_count5_XPATH", "0",
					"The correct count is not displayed.");

			// validate leed count of the section 2
			switchVerification("sustainability_certification_dashboard_section2_count1_XPATH", "0",
					"The correct count is not displayed.");

			// validate well building standard count of the section 2
			switchVerification("sustainability_certification_dashboard_section2_count2_XPATH", "0",
					"The correct count is not displayed.");

			// validate boma best count of the section 2
			switchVerification("sustainability_certification_dashboard_section2_count3_XPATH", "0",
					"The correct count is not displayed.");

			// validate fitwel count of the section 2
			switchVerification("sustainability_certification_dashboard_section2_count4_XPATH", "1",
					"The correct count is not displayed.");

			// validate fitwel count of the section 2 - sub type
			switchVerification("sustainability_certification_dashboard_section2_count44_XPATH", "1",
					"The correct count is not displayed.");

			// validate wiredscore count of the section 2
			switchVerification("sustainability_certification_dashboard_section2_count5_XPATH", "0",
					"The correct count is not displayed.");

			// validate leed count of the section 3
			switchVerification("sustainability_certification_dashboard_section3_count1_XPATH", "4",
					"The correct count is not displayed.");

			// validate well building standard count of the section 3
			switchVerification("sustainability_certification_dashboard_section3_count2_XPATH", "4",
					"The correct count is not displayed.");

			// validate boma best count of the section 3
			switchVerification("sustainability_certification_dashboard_section3_count3_XPATH", "4",
					"The correct count is not displayed.");

			// validate fitwel count of the section 3
			switchVerification("sustainability_certification_dashboard_section3_count4_XPATH", "2",
					"The correct count is not displayed.");

			// validate wiredscore count of the section 3
			switchVerification("sustainability_certification_dashboard_section3_count5_XPATH", "4",
					"The correct count is not displayed.");

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

		// DELETE ALL THE NEWLY CREATED CERTIFICATES FROM ALL THE PROPERTIES

		System.out.println(
				"***************** DELETE ALL THE NEWLY CREATED CERTIFICATES FROM ALL THE PROPERTIES *****************");
		test.log(LogStatus.INFO,
				"***************** DELETE ALL THE NEWLY CREATED CERTIFICATES FROM ALL THE PROPERTIES *****************");
		Reporter.log(
				"***************** DELETE ALL THE NEWLY CREATED CERTIFICATES FROM ALL THE PROPERTIES *****************");
		log.info(
				"***************** DELETE ALL THE NEWLY CREATED CERTIFICATES FROM ALL THE PROPERTIES *****************");

		helper.deleteAllCertificates(data.get("property_1"));
		helper.deleteAllCertificates(data.get("property_2"));
		helper.deleteAllCertificates(data.get("property_3"));
		helper.deleteAllCertificates(data.get("property_4"));

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
