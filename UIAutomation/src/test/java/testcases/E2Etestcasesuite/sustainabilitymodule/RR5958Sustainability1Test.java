package testcases.E2Etestcasesuite.sustainabilitymodule;

import java.io.IOException;
import java.time.LocalDate;
import java.util.Hashtable;

import org.apache.commons.lang3.RandomStringUtils;
import org.openqa.selenium.By;
import org.testng.Reporter;
import org.testng.SkipException;
import org.testng.annotations.Test;

import com.relevantcodes.extentreports.LogStatus;

import base.Helper;
import base.TestBase;
import utilities.TestUtil;

public class RR5958Sustainability1Test extends TestBase {

	@Test(dataProviderClass = TestUtil.class, dataProvider = "dp")
	public void rR5958Sustainability1Test(Hashtable<String, String> data) throws IOException, InterruptedException {

		execution(data, "rR5958Sustainability1Test");

		// PERFORMED CRUD OPERATION OF THE CERTIFICATIONS MODULE - AT PROPERTY LEVEL

		System.out.println("PERFORMED CRUD OPERATION OF THE CERTIFICATIONS MODULE - AT PROPERTY LEVEL");
		test.log(LogStatus.INFO, "PERFORMED CRUD OPERATION OF THE CERTIFICATIONS MODULE - AT PROPERTY LEVEL");
		Reporter.log("PERFORMED CRUD OPERATION OF THE CERTIFICATIONS MODULE - AT PROPERTY LEVEL");
		log.info("PERFORMED CRUD OPERATION OF THE CERTIFICATIONS MODULE - AT PROPERTY LEVEL");

		Helper helper = new Helper();
		
		// refresh the page
		driver.navigate().refresh();
		explicitWait("sustainabilityicon_CSS");
		driver.navigate().refresh();

		System.out.println("Navigate to the Home Screen i.e. Property List Screen.");

		// CREATE NEW CERTIFICATIONS RECORD - AT PROPERTY LEVEL

		System.out.println("***************** CREATE NEW CERTIFICATIONS RECORD - AT PROPERTY LEVEL *****************");
		test.log(LogStatus.INFO,
				"***************** CREATE NEW CERTIFICATIONS RECORD - AT PROPERTY LEVEL *****************");
		Reporter.log("***************** CREATE NEW CERTIFICATIONS RECORD - AT PROPERTY LEVEL *****************");
		log.info("***************** CREATE NEW CERTIFICATIONS RECORD - AT PROPERTY LEVEL *****************");

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

			// click on the certifications option
			click("sustainability_sidemenu_certificationsoption_XPATH");
			ngDriver.waitForAngularRequestsToFinish();
			System.out.println("Clicked on the certifications option.");

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

			// enter the newly created certification record in the search field
			clear("sustainability_searchtxt_XPATH");
			type("sustainability_searchtxt_XPATH", data.get("type"));
			ngDriver.waitForAngularRequestsToFinish();
			System.out.println("Entered the newly created certification record in the search field.");

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

			// verify the Certification Date of the newly created certification record
			try {
				String currentDate_XPATH = "//td[text()='Time of Design / Construction']//following-sibling::td[text()='"
						+ currentDate + "']";
				String addedDate1 = (driver.findElement(By.xpath(currentDate_XPATH)).getText()).trim();
				if (addedDate1.equals(currentDate)) {

					System.out.println("The Certification Date is verified successfully.");
					test.log(LogStatus.INFO, "The Certification Dateis verified successfully.");
					Reporter.log("The Certification Date is verified successfully.");
					log.info("The Certification Date is verified successfully.");
				} else {
					verificationFailed();

					System.out.println("The Certification Date is not verified.");
					test.log(LogStatus.INFO, "The Certification Date is not verified.");
					Reporter.log("The Certification Date is not verified.");
					log.info("The Certification Date is not verified.");
				}
			} catch (Throwable t) {
				verificationFailed();
			}

			// verify the Certification Expiry of the newly created certification record
			try {
				String futureDate_XPATH = "//td[text()='Time of Design / Construction']//following-sibling::td[text()='"
						+ futureDate1 + "']";
				String addedDate2 = (driver.findElement(By.xpath(futureDate_XPATH)).getText()).trim();
				if (addedDate2.equals(futureDate1)) {

					System.out.println("The Certification Expiry is verified successfully.");
					test.log(LogStatus.INFO, "The Certification Expiry is verified successfully.");
					Reporter.log("The Certification Expiry is verified successfully.");
					log.info("The Certification Expiry is verified successfully.");
				} else {
					verificationFailed();

					System.out.println("The Certification Expiry is not verified.");
					test.log(LogStatus.INFO, "The Certification Expiry is not verified.");
					Reporter.log("The Certification Expiry is not verified.");
					log.info("The Certification Expiry is not verified.");
				}

			} catch (Throwable t) {
				verificationFailed();
			}

		} catch (Throwable t) {
			verificationFailed();
		}

		// UPDATE THE NEWLY CREATED CERTIFICATION RECORD

		System.out.println("***************** UPDATE THE NEWLY CREATED CERTIFICATION RECORD *****************");
		test.log(LogStatus.INFO, "***************** UPDATE THE NEWLY CREATED CERTIFICATION RECORD *****************");
		Reporter.log("***************** UPDATE THE NEWLY CREATED CERTIFICATION RECORD *****************");
		log.info("***************** UPDATE THE NEWLY CREATED CERTIFICATION RECORD *****************");

		try {
			// click on the newly created certification record
			click("sustainability_certification_addedtype_XPATH");
			ngDriver.waitForAngularRequestsToFinish();
			System.out.println("Clicked on the newly created document / report record.");

			// select the certification type from the dropdown
			select("sustainability_certification_certificationtype_XPATH", data.get("update_type"));
			ngDriver.waitForAngularRequestsToFinish();
			System.out.println("Selected the certification type from the dropdown.");

			// select the certification name from the dropdown
			select("sustainability_certification_certificationname_XPATH", data.get("update_name"));
			ngDriver.waitForAngularRequestsToFinish();
			System.out.println("Selected the certification name from the dropdown.");

			// select the certification sub type from the dropdown
			select("sustainability_certification_certificationsubtype_XPATH", data.get("update_sub_type"));
			ngDriver.waitForAngularRequestsToFinish();
			System.out.println("Selected the certification sub type from the dropdown.");

			// select the level of certification from the dropdown
			select("sustainability_certification_levelofcertification_XPATH", data.get("update_level"));
			ngDriver.waitForAngularRequestsToFinish();
			System.out.println("Selected the level of certification from the dropdown.");

			// enter the certification score in the field
			clear("sustainability_certification_certificationscore_XPATH");
			type("sustainability_certification_certificationscore_XPATH", "5");
			ngDriver.waitForAngularRequestsToFinish();
			System.out.println("Entered the certification score in the field.");

			// enter on the date of certification
			LocalDate pastUpdateDate1 = LocalDate.now().minusDays(5);
			String pastUpdateDate1_string = pastUpdateDate1.toString();
			clear("sustainability_certification_dateofcertification_XPATH");
			type("sustainability_certification_dateofcertification_XPATH", pastUpdateDate1_string);
			ngDriver.waitForAngularRequestsToFinish();
			System.out.println("Clicked on the date of certification.");

			// enter on the date of certification
			LocalDate currentUpdatedDate1 = LocalDate.now();
			String currentUpdatedDate1_string = currentUpdatedDate1.toString();
			clear("sustainability_certification_certificationexpiration_XPATH");
			type("sustainability_certification_certificationexpiration_XPATH", currentUpdatedDate1_string);
			ngDriver.waitForAngularRequestsToFinish();
			System.out.println("Clicked on the date of certification.");

			// select the certification status from the dropdown
			select("sustainability_certification_certificationstatus_XPATH", data.get("update_status"));
			ngDriver.waitForAngularRequestsToFinish();
			System.out.println("Selected the certification status from the dropdown.");

			// select the Portfolio Program from the dropdown
			select("sustainability_certification_portfolioprogram_XPATH", data.get("update_portfolio_program"));
			ngDriver.waitForAngularRequestsToFinish();
			System.out.println("Selected the Portfolio Program from the dropdown.");

			// enter the Project ID in the field
			String random3 = RandomStringUtils.randomAlphanumeric(8);
			clear("sustainability_certification_projectid_XPATH");
			type("sustainability_certification_projectid_XPATH", random3);
			ngDriver.waitForAngularRequestsToFinish();
			System.out.println("Entered the Project ID in the field.");

			// enter the Building ID in the field
			String random4 = RandomStringUtils.randomAlphanumeric(8);
			clear("sustainability_certification_buildingid_XPATH");
			type("sustainability_certification_buildingid_XPATH", random4);
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

			// enter the updated certification record in the search field
			clear("sustainability_searchtxt_XPATH");
			type("sustainability_searchtxt_XPATH", data.get("update_type"));
			ngDriver.waitForAngularRequestsToFinish();
			System.out.println("Entered the updated certification record in the search field.");

			// verify the category of the updated certification record
			switchVerification("sustainability_certification_updatedcategory_XPATH", "Operational",
					"The Operational record is not displayed.");

			// verify the type of the updated certification record
			switchVerification("sustainability_certification_updatedtype_XPATH", "LEED",
					"The LEED record is not displayed.");

			// verify the level of the updated certification record
			switchVerification("sustainability_certification_updatedlevel_XPATH", "Platinum",
					"The Platinum record is not displayed.");

			// verify the status of the updated certification record
			switchVerification("sustainability_certification_updatedstatus_XPATH", "Active",
					"The Active record is not displayed.");

			// verify the Certification Date of the updated certification record
			try {
				String pastUpdateDate1_string_XPATH = "//td[text()='Operational']//following-sibling::td[text()='"
						+ pastUpdateDate1_string + "']";
				String updatedDate1 = (driver.findElement(By.xpath(pastUpdateDate1_string_XPATH)).getText()).trim();
				if (updatedDate1.equals(pastUpdateDate1_string)) {

					System.out.println("The Certification Date is verified successfully.");
					test.log(LogStatus.INFO, "The Certification Dateis verified successfully.");
					Reporter.log("The Certification Date is verified successfully.");
					log.info("The Certification Date is verified successfully.");
				} else {
					verificationFailed();

					System.out.println("The Certification Date is not verified.");
					test.log(LogStatus.INFO, "The Certification Date is not verified.");
					Reporter.log("The Certification Date is not verified.");
					log.info("The Certification Date is not verified.");
				}
			} catch (Throwable t) {
				verificationFailed();
			}

			// verify the Certification Expiry of the updated certification record
			try {
				String currentUpdatedDate1_string_XPATH = "//td[text()='Operational']//following-sibling::td[text()='"
						+ currentUpdatedDate1_string + "']";
				String updatedDate2 = (driver.findElement(By.xpath(currentUpdatedDate1_string_XPATH)).getText()).trim();
				if (updatedDate2.equals(currentUpdatedDate1_string)) {

					System.out.println("The Certification Expiry is verified successfully.");
					test.log(LogStatus.INFO, "The Certification Expiry is verified successfully.");
					Reporter.log("The Certification Expiry is verified successfully.");
					log.info("The Certification Expiry is verified successfully.");
				} else {
					verificationFailed();

					System.out.println("The Certification Expiry is not verified.");
					test.log(LogStatus.INFO, "The Certification Expiry is not verified.");
					Reporter.log("The Certification Expiry is not verified.");
					log.info("The Certification Expiry is not verified.");
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

		// DELETE THE UPDATED CERTIFICATION RECORD

		System.out.println("***************** DELETE THE UPDATED CERTIFICATION RECORD *****************");
		test.log(LogStatus.INFO, "***************** DELETE THE UPDATED CERTIFICATION RECORD *****************");
		Reporter.log("***************** DELETE THE UPDATED CERTIFICATION RECORD *****************");
		log.info("***************** DELETE THE UPDATED CERTIFICATION RECORD *****************");

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

			// click on the certifications option
			click("sustainability_sidemenu_certificationsoption_XPATH");
			ngDriver.waitForAngularRequestsToFinish();
			System.out.println("Clicked on the certifications option.");

			// enter the updated certification record in the search field
			clear("sustainability_searchtxt_XPATH");
			type("sustainability_searchtxt_XPATH", data.get("update_type"));
			ngDriver.waitForAngularRequestsToFinish();
			System.out.println("Entered the updated certification record in the search field.");

			// click on the updated certification record
			click("sustainability_certification_updatedtype_XPATH");
			ngDriver.waitForAngularRequestsToFinish();
			System.out.println("Clicked on the updated certification record.");

			// wait for the element
			explicitWaitClickable("sustainability_certification_deletebtn_XPATH");

			// click on the delete button
			click("sustainability_certification_deletebtn_XPATH");
			ngDriver.waitForAngularRequestsToFinish();
			System.out.println("Clicked on the delete button.");

			// wait for the element
			explicitWaitClickable("sustainability_certification_deletebtn_confirmation_XPATH");

			// click on the delete button of the confirmation popup
			click("sustainability_certification_deletebtn_confirmation_XPATH");
			ngDriver.waitForAngularRequestsToFinish();
			System.out.println("Clicked on the delete button of the confirmation popup.");

			// enter the updated certification record in the search field
			clear("sustainability_searchtxt_XPATH");
			type("sustainability_searchtxt_XPATH", data.get("update_type"));
			ngDriver.waitForAngularRequestsToFinish();
			System.out.println("Entered the updated certification record in the search field.");

			// wait for the element
			explicitWaitClickable("closetoastmsg_CSS");

			// click on the toaster close button
			click("closetoastmsg_CSS");
			ngDriver.waitForAngularRequestsToFinish();
			System.out.println("Clicked on the toaster close button.");

			// verify the deleted certification record displayed or not
			helper.deleteVerification("sustainability_certification_addedtype_XPATH", "LEED");

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
