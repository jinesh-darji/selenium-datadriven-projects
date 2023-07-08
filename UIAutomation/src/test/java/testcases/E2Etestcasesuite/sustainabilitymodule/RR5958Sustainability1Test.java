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
		title("PERFORMED CRUD OPERATION OF THE CERTIFICATIONS MODULE - AT PROPERTY LEVEL");

		Helper helper = new Helper();

		// refresh the page
		driver.navigate().refresh();
		explicitWait("sustainabilityicon_CSS");
		driver.navigate().refresh();

		// CREATE NEW CERTIFICATIONS RECORD - AT PROPERTY LEVEL
		title("CREATE NEW CERTIFICATIONS RECORD - AT PROPERTY LEVEL");

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

		// UPDATE THE NEWLY CREATED CERTIFICATION RECORD
		title("UPDATE THE NEWLY CREATED CERTIFICATION RECORD");

		try {
			// click on the newly created certification record
			click("sustainability_certification_addedtype_XPATH");

			// select the certification type from the dropdown
			select("sustainability_certification_certificationtype_XPATH", data.get("update_type"));

			// select the certification name from the dropdown
			select("sustainability_certification_certificationname_XPATH", data.get("update_name"));

			// select the certification sub type from the dropdown
			select("sustainability_certification_certificationsubtype_XPATH", data.get("update_sub_type"));

			// select the level of certification from the dropdown
			select("sustainability_certification_levelofcertification_XPATH", data.get("update_level"));

			// enter the certification score in the field
			type("sustainability_certification_certificationscore_XPATH", "5");

			// enter on the date of certification
			LocalDate pastUpdateDate1 = LocalDate.now().minusDays(5);
			String pastUpdateDate1_string = pastUpdateDate1.toString();
			type("sustainability_certification_dateofcertification_XPATH", pastUpdateDate1_string);

			// enter on the date of certification
			LocalDate currentUpdatedDate1 = LocalDate.now();
			String currentUpdatedDate1_string = currentUpdatedDate1.toString();
			type("sustainability_certification_certificationexpiration_XPATH", currentUpdatedDate1_string);

			// select the certification status from the dropdown
			select("sustainability_certification_certificationstatus_XPATH", data.get("update_status"));

			// select the Portfolio Program from the dropdown
			select("sustainability_certification_portfolioprogram_XPATH", data.get("update_portfolio_program"));

			// enter the Project ID in the field
			String random3 = RandomStringUtils.randomAlphanumeric(8);
			type("sustainability_certification_projectid_XPATH", random3);

			// enter the Building ID in the field
			String random4 = RandomStringUtils.randomAlphanumeric(8);
			type("sustainability_certification_buildingid_XPATH", random4);

			// click on the save button
			click("sustainability_certification_savebtn_XPATH");

			// wait for the element
			explicitWaitClickable("closetoastmsg_CSS");

			// click on the toaster close button
			click("closetoastmsg_CSS");

			// enter the updated certification record in the search field
			type("sustainability_searchtxt_XPATH", data.get("update_type"));

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

		// DELETE THE UPDATED CERTIFICATION RECORD
		title("DELETE THE UPDATED CERTIFICATION RECORD");

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

			// click on the certifications option
			click("sustainability_sidemenu_certificationsoption_XPATH");

			// enter the updated certification record in the search field
			type("sustainability_searchtxt_XPATH", data.get("update_type"));

			// click on the updated certification record
			click("sustainability_certification_updatedtype_XPATH");

			// wait for the element
			explicitWaitClickable("sustainability_certification_deletebtn_XPATH");

			// click on the delete button
			click("sustainability_certification_deletebtn_XPATH");

			// wait for the element
			explicitWaitClickable("sustainability_certification_deletebtn_confirmation_XPATH");

			// click on the delete button of the confirmation popup
			click("sustainability_certification_deletebtn_confirmation_XPATH");

			// enter the updated certification record in the search field
			type("sustainability_searchtxt_XPATH", data.get("update_type"));

			// wait for the element
			explicitWaitClickable("closetoastmsg_CSS");

			// click on the toaster close button
			click("closetoastmsg_CSS");

			// verify the deleted certification record displayed or not
			helper.deleteVerification("sustainability_certification_addedtype_XPATH", "LEED");

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