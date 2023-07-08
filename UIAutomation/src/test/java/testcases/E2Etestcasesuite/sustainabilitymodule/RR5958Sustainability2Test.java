package testcases.E2Etestcasesuite.sustainabilitymodule;

import java.io.IOException;
import java.time.LocalDate;
import java.util.Hashtable;

import org.apache.commons.lang3.RandomStringUtils;
import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.SkipException;
import org.testng.annotations.Test;

import com.relevantcodes.extentreports.LogStatus;

import base.Helper;
import base.TestBase;
import utilities.TestUtil;

public class RR5958Sustainability2Test extends TestBase {

	@Test(dataProviderClass = TestUtil.class, dataProvider = "dp")
	public void rR5958Sustainability2Test(Hashtable<String, String> data) throws IOException, InterruptedException {

		execution(data, "rR5958Sustainability2Test");

		// PERFORMED CRUD OPERATION OF THE CERTIFICATION MODULE - AT BUILDING LEVEL
		title("PERFORMED CRUD OPERATION OF THE CERTIFICATION MODULE - AT BUILDING LEVEL");

		Helper helper = new Helper();

		// refresh the page
		driver.navigate().refresh();
		explicitWait("sustainabilityicon_CSS");
		driver.navigate().refresh();

		// CREATE NEW CERTIFICATION RECORD - AT PROPERTY LEVEL
		title("CREATE NEW CERTIFICATION RECORD - AT PROPERTY LEVEL");

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
			select("sustainability_certification_certificationtype_XPATH", data.get("type_property"));

			// select the certification name from the dropdown
			select("sustainability_certification_certificationname_XPATH", data.get("name_property"));

			// select the certification sub type from the dropdown
			select("sustainability_certification_certificationsubtype_XPATH", data.get("sub_type_property"));

			// select the level of certification from the dropdown
			select("sustainability_certification_levelofcertification_XPATH", data.get("level_property"));

			// enter the certification score in the field
			type("sustainability_certification_certificationscore_XPATH", "5");

			// enter on the date of certification
			LocalDate date = LocalDate.now();
			String currentDate = date.toString();
			type("sustainability_certification_dateofcertification_XPATH", currentDate);

			// enter on the date of certification
			LocalDate date1 = LocalDate.now().plusDays(5);
			String futureDate1 = date1.toString();
			type("sustainability_certification_certificationexpiration_XPATH", futureDate1);

			// select the certification status from the dropdown
			select("sustainability_certification_certificationstatus_XPATH", data.get("status_property"));

			// enter the verification year
			type("sustainability_certification_verificationyear_XPATH", "2022");

			// select the Portfolio Program from the dropdown
			select("sustainability_certification_portfolioprogram_XPATH", data.get("portfolio_program_property"));

			// enter the Project ID in the field
			String random1 = RandomStringUtils.randomAlphanumeric(8);
			type("sustainability_certification_projectid_XPATH", random1);

			// enter the Building ID in the field
			String random2 = RandomStringUtils.randomAlphanumeric(8);
			type("sustainability_certification_buildingid_XPATH", random2);

			// click on the save button
			click("sustainability_certification_savebtn_XPATH");

			// wait for the element
			explicitWaitClickable("closetoastmsg_CSS");

			// click on the toaster close button
			click("closetoastmsg_CSS");

			// enter the newly created certification record in the search field
			type("sustainability_searchtxt_XPATH", data.get("type_property"));

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
					successMessage("The Certification Date is verified successfully.");
				} else {
					verificationFailedMessage("The Certification Date is not verified.");
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

		// synchronization
		explicitWait("propertylist_title_XPATH");

		// verify the property list
		switchVerification("propertylist_title_XPATH", "Property List", "The property list is not displayed.");

		// CREATE NEW CERTIFICATION RECORD - AT BUILDING LEVEL
		title("CREATE NEW CERTIFICATION RECORD - AT BUILDING LEVEL");

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

			// wait for the element
			Thread.sleep(5000);

			// select the building from the top dropdown
			select("task_addedtask_propertybuildingdd_CSS", data.get("property_dd_building"));

			// click on the add button
			click("sustainability_certification_addbtn_XPATH");

			// select the certification type from the dropdown
			select("sustainability_certification_certificationtype_XPATH", data.get("type_building"));

			// select the certification name from the dropdown
			select("sustainability_certification_certificationname_XPATH", data.get("name_building"));

			// select the certification sub type from the dropdown
			select("sustainability_certification_certificationsubtype_XPATH", data.get("sub_type_building"));

			// select the level of certification from the dropdown
			select("sustainability_certification_levelofcertification_XPATH", data.get("level_building"));

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
			select("sustainability_certification_certificationstatus_XPATH", data.get("status_building"));

			// select the Portfolio Program from the dropdown
			select("sustainability_certification_portfolioprogram_XPATH", data.get("portfolio_program_building"));

			// enter the Project ID in the field
			String random1 = RandomStringUtils.randomAlphanumeric(8);
			type("sustainability_certification_projectid_XPATH", random1);

			// enter the Building ID in the field
			String random2 = RandomStringUtils.randomAlphanumeric(8);
			type("sustainability_certification_buildingid_XPATH", random2);

			// click on the save button
			click("sustainability_certification_savebtn_XPATH");

			// wait for the element
			explicitWaitClickable("closetoastmsg_CSS");

			// click on the toaster close button
			click("closetoastmsg_CSS");

			// enter the newly created certification record in the search field
			type("sustainability_searchtxt_XPATH", data.get("type_building"));

			// verify the category of the newly created certification record
			switchVerification("sustainability_certification_addedcategory_XPATH", "Time of Design / Construction",
					"The Time of Design / Construction record is not displayed.");

			// verify the type of the newly created certification record
			switchVerification("sustainability_certification_addedtype_blevel_XPATH", "WELL Building Standard",
					"The WELL Building Standard record is not displayed.");

			// verify the level of the newly created certification record
			switchVerification("sustainability_certification_addedlevel_blevel_XPATH", "Certified",
					"The Certified record is not displayed.");

			// verify the status of the newly created certification record
			switchVerification("sustainability_certification_addedstatus_blevel_XPATH", "Pending",
					"The Pending record is not displayed.");

			// verify the Certification Date of the newly created certification record
			try {
				String currentDate_XPATH = "//td[text()='Time of Design / Construction']//following-sibling::td[text()='"
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
				String futureDate_XPATH = "//td[text()='Time of Design / Construction']//following-sibling::td[text()='"
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

			// enter the newly created certification record in the search field
			type("sustainability_searchtxt_XPATH", data.get("type_property"));

			// verify the newly created certification record displayed or not at property
			// level verify the type of the newly created certification record
			helper.deleteVerification("sustainability_certification_addedtype_XPATH", "BOMA BEST");

			try {

				String deleteElement = driver
						.findElement(By.xpath(OR.getProperty("sustainability_certification_addedtype_XPATH")))
						.getText();

				if (deleteElement.equals("BOMA BEST")) {
					verificationFailedMessage("The BOMA BEST is displayed at building level");
				}
			} catch (Throwable t) {
				successMessage("The BOMA BEST is not displayed at building level as expected.");
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

		// UPDATE THE NEWLY CREATED CERTIFICATION RECORD - AT BUILDING LEVEL
		title("UPDATE THE NEWLY CREATED CERTIFICATION RECORD - AT BUILDING LEVEL");

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

			// wait for the element
			Thread.sleep(5000);

			// select the building from the top dropdown
			select("task_addedtask_propertybuildingdd_CSS", data.get("property_dd_building"));

			// enter the newly created certification record in the search field
			type("sustainability_searchtxt_XPATH", data.get("type_building"));

			// click on the newly created certification record
			click("sustainability_certification_addedtype_blevel_XPATH");

			// select the certification type from the dropdown
			select("sustainability_certification_certificationtype_XPATH", data.get("update_type_building"));

			// select the certification name from the dropdown
			select("sustainability_certification_certificationname_XPATH", data.get("update_name_building"));

			// select the certification sub type from the dropdown
			select("sustainability_certification_certificationsubtype_XPATH", data.get("update_sub_type_building"));

			// select the level of certification from the dropdown
			select("sustainability_certification_levelofcertification_XPATH", data.get("update_level_building"));

			// update the certification score in the field
			type("sustainability_certification_certificationscore_XPATH", "10");

			// enter on the date of certification
			LocalDate pastUpdateDate1 = LocalDate.now().minusDays(5);
			String pastUpdateDate1_string = pastUpdateDate1.toString();
			type("sustainability_certification_dateofcertification_XPATH", pastUpdateDate1_string);

			// enter on the date of certification
			LocalDate currentUpdatedDate1 = LocalDate.now();
			String currentUpdatedDate1_string = currentUpdatedDate1.toString();
			type("sustainability_certification_certificationexpiration_XPATH", currentUpdatedDate1_string);

			// select the certification status from the dropdown
			select("sustainability_certification_certificationstatus_XPATH", data.get("update_status_building"));

			// select the Portfolio Program from the dropdown
			select("sustainability_certification_portfolioprogram_XPATH",
					data.get("update_portfolio_program_building"));

			// update the Project ID in the field
			String random1 = RandomStringUtils.randomAlphanumeric(8);
			type("sustainability_certification_projectid_XPATH", random1);

			// update the Building ID in the field
			String random2 = RandomStringUtils.randomAlphanumeric(8);
			type("sustainability_certification_buildingid_XPATH", random2);

			// click on the save button
			click("sustainability_certification_savebtn_XPATH");

			// wait for the element
			explicitWaitClickable("closetoastmsg_CSS");

			// click on the toaster close button
			click("closetoastmsg_CSS");

			// enter the newly created certification record in the search field
			type("sustainability_searchtxt_XPATH", data.get("update_type_building"));

			// verify the category of the updated certification record
			switchVerification("sustainability_certification_updatedcategory_blevel_XPATH", "Operational",
					"The Operational record is not displayed.");

			// verify the type of the updated certification record
			switchVerification("sustainability_certification_updatedtype_blevel_XPATH", "Fitwel",
					"The Fitwel record is not displayed.");

			// verify the level of the updated certification record
			switchVerification("sustainability_certification_updatedlevel_blevel_XPATH", "Platinum",
					"The Platinum record is not displayed.");

			// verify the status of the updated certification record
			switchVerification("sustainability_certification_updatedstatus_blevel_XPATH", "Active",
					"The Active record is not displayed.");

			// verify the Certification Date of the updated certification record
			try {
				String pastUpdateDate1_string_XPATH = "//td[text()='Operational']//following-sibling::td[text()='"
						+ pastUpdateDate1_string + "']";
				String updatedDate1 = (driver.findElement(By.xpath(pastUpdateDate1_string_XPATH)).getText()).trim();
				if (updatedDate1.equals(pastUpdateDate1_string)) {
					successMessage("The Certification Date is verified successfully.");
				} else {
					verificationFailedMessage("The Certification Date is not verified.");
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

		// synchronization
		explicitWait("propertylist_title_XPATH");

		// verify the property list
		switchVerification("propertylist_title_XPATH", "Property List", "The property list is not displayed.");

		// DELETE THE UPDATED CERTIFICATION RECORD - AT PROPERTY AND BUILDING
		// LEVEL
		title("DELETE THE UPDATED CERTIFICATION RECORD - AT PROPERTY AND BUILDING LEVEL");

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

			// select the building from the top dropdown
			select("task_addedtask_propertybuildingdd_CSS", data.get("property_dd_building"));

			// enter the newly created certification record in the search field
			type("sustainability_searchtxt_XPATH", data.get("update_type_building"));

			// click on the updated certification record
			click("sustainability_certification_updatedtype_blevel_XPATH");

			// wait for the element
			explicitWaitClickable("sustainability_certification_deletebtn_XPATH");

			// click on the delete button
			click("sustainability_certification_deletebtn_XPATH");

			// wait for the element
			explicitWaitClickable("sustainability_certification_deletebtn_confirmation_XPATH");

			// click on the delete button of the confirmation popup
			click("sustainability_certification_deletebtn_confirmation_XPATH");

			// wait for the element
			explicitWaitClickable("closetoastmsg_CSS");

			// click on the toaster close button
			click("closetoastmsg_CSS");

			// enter the updated certification record in the search field
			type("sustainability_searchtxt_XPATH", data.get("update_type_building"));

			// verify the deleted certification record displayed or not
			helper.deleteVerification("sustainability_certification_updatedtype_blevel_XPATH", "Fitwel");

			// select the property from the top dropdown
			select("task_addedtask_propertybuildingdd_CSS", data.get("property_dd_property"));

			// enter the newly created certification record in the search field
			type("sustainability_searchtxt_XPATH", data.get("type_property"));

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

			// wait for the element
			explicitWaitClickable("closetoastmsg_CSS");

			// click on the toaster close button
			click("closetoastmsg_CSS");

			// enter the newly created certification record in the search field
			type("sustainability_searchtxt_XPATH", data.get("type_property"));

			// verify deleted document/report record displayed or not
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

	}
}