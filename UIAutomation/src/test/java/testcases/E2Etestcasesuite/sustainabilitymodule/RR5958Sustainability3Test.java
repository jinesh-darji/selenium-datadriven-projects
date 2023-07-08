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
		title("VALIDATE THE BUILDING CERTIFICATE DASHBOARD RECORDS WITH DIFFERENT SCENARIOS");

		// refresh the page
		driver.navigate().refresh();
		Thread.sleep(5000);
		driver.navigate().refresh();

		// DELETE ALL THE PREVIOUSLY CREATED CERTIFICATES FROM ALL THE PROPERTIES
		title("DELETE ALL THE PREVIOUSLY CREATED CERTIFICATES FROM ALL THE PROPERTIES");

		helper.deleteAllCertificates(data.get("property_1"));
		helper.deleteAllCertificates(data.get("property_2"));
		helper.deleteAllCertificates(data.get("property_3"));
		helper.deleteAllCertificates(data.get("property_4"));

		// click on the home icon from the top of the screen
		click("questionnaire_homeburgermenubtn_hide_CSS");

		// synchronization
		explicitWait("propertylist_title_XPATH");

		// verify the property list
		switchVerification("propertylist_title_XPATH", "Property List", "The property list is not displayed.");

		// CREATE NEW CERTIFICATIONS RECORD - BOMA BEST - ACTIVE STATUS
		title("CREATE NEW CERTIFICATIONS RECORD - BOMA BEST - ACTIVE STATUS");

		try {
			// enter the property name in the search field
			type("envreports_propertylist_filtertxt_CSS", data.get("property_1"));

			// click on the sustainability icon
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
			select("sustainability_certification_certificationtype_XPATH", data.get("type_1"));

			// select the certification name from the dropdown
			select("sustainability_certification_certificationname_XPATH", data.get("name_1"));

			// select the certification sub type from the dropdown
			select("sustainability_certification_certificationsubtype_XPATH", data.get("sub_type_1"));

			// select the level of certification from the dropdown
			select("sustainability_certification_levelofcertification_XPATH", data.get("level_1"));

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
			select("sustainability_certification_certificationstatus_XPATH", data.get("status_1"));

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
			type("sustainability_searchtxt_XPATH", data.get("name_1"));

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

		// synchronization
		explicitWait("propertylist_title_XPATH");

		// verify the property list
		switchVerification("propertylist_title_XPATH", "Property List", "The property list is not displayed.");

		// CREATE NEW CERTIFICATIONS RECORD - LEED - PENDING STATUS
		title("CREATE NEW CERTIFICATIONS RECORD - LEED - PENDING STATUS");

		try {
			// enter the property name in the search field
			type("envreports_propertylist_filtertxt_CSS", data.get("property_1"));

			// click on the sustainability icon
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
			select("sustainability_certification_certificationtype_XPATH", data.get("type_2"));

			// select the certification name from the dropdown
			select("sustainability_certification_certificationname_XPATH", data.get("name_2"));

			// select the certification sub type from the dropdown
			select("sustainability_certification_certificationsubtype_XPATH", data.get("sub_type_2"));

			// select the level of certification from the dropdown
			select("sustainability_certification_levelofcertification_XPATH", data.get("level_1"));

			// enter the certification score in the field
			type("sustainability_certification_certificationscore_XPATH", "5");

			// enter on the date of certification
			LocalDate date2 = LocalDate.now().plusDays(2);
			String currentDate2 = date2.toString();
			type("sustainability_certification_dateofcertification_XPATH", currentDate2);

			// enter on the date of certification
			LocalDate date22 = LocalDate.now().plusDays(7);
			String futureDate22 = date22.toString();
			type("sustainability_certification_certificationexpiration_XPATH", futureDate22);

			// select the certification status from the dropdown
			select("sustainability_certification_certificationstatus_XPATH", data.get("status_2"));

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
			type("sustainability_searchtxt_XPATH", data.get("name_2"));

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

		// synchronization
		explicitWait("propertylist_title_XPATH");

		// verify the property list
		switchVerification("propertylist_title_XPATH", "Property List", "The property list is not displayed.");

		// CREATE NEW CERTIFICATIONS RECORD - WIREDSCORE - DENIED STATUS
		title("CREATE NEW CERTIFICATIONS RECORD - WIREDSCORE - DENIED STATUS");

		try {
			// enter the property name in the search field
			type("envreports_propertylist_filtertxt_CSS", data.get("property_1"));

			// click on the sustainability icon
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
			select("sustainability_certification_certificationtype_XPATH", data.get("type_1"));

			// select the certification name from the dropdown
			select("sustainability_certification_certificationname_XPATH", data.get("name_3"));

			// select the certification sub type from the dropdown
			select("sustainability_certification_certificationsubtype_XPATH", data.get("sub_type_3"));

			// select the level of certification from the dropdown
			select("sustainability_certification_levelofcertification_XPATH", data.get("level_1"));

			// enter the certification score in the field
			type("sustainability_certification_certificationscore_XPATH", "5");

			// enter on the date of certification
			LocalDate date3 = LocalDate.now().plusDays(4);
			String currentDate3 = date3.toString();
			type("sustainability_certification_dateofcertification_XPATH", currentDate3);

			// enter on the date of certification
			LocalDate date33 = LocalDate.now().plusDays(12);
			String futureDate33 = date33.toString();
			type("sustainability_certification_certificationexpiration_XPATH", futureDate33);

			// select the certification status from the dropdown
			select("sustainability_certification_certificationstatus_XPATH", data.get("status_3"));

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
			type("sustainability_searchtxt_XPATH", data.get("name_3"));

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

		// synchronization
		explicitWait("propertylist_title_XPATH");

		// verify the property list
		switchVerification("propertylist_title_XPATH", "Property List", "The property list is not displayed.");

		// CREATE NEW CERTIFICATIONS RECORD - FITWEL - ACTIVE STATUS - EXPIRED
		title("CREATE NEW CERTIFICATIONS RECORD - FITWEL - ACTIVE STATUS - EXPIRED");

		try {
			// enter the property name in the search field
			type("envreports_propertylist_filtertxt_CSS", data.get("property_1"));

			// click on the sustainability icon
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
			select("sustainability_certification_certificationtype_XPATH", data.get("type_1"));

			// select the certification name from the dropdown
			select("sustainability_certification_certificationname_XPATH", data.get("name_4"));

			// select the certification sub type from the dropdown
			select("sustainability_certification_certificationsubtype_XPATH", data.get("sub_type_4"));

			// select the level of certification from the dropdown
			select("sustainability_certification_levelofcertification_XPATH", data.get("level_1"));

			// enter the certification score in the field
			type("sustainability_certification_certificationscore_XPATH", "5");

			// enter on the date of certification
			LocalDate date4 = LocalDate.now().minusDays(10);
			String currentDate4 = date4.toString();
			type("sustainability_certification_dateofcertification_XPATH", currentDate4);

			// enter on the date of certification
			LocalDate date44 = LocalDate.now().minusDays(5);
			String futureDate44 = date44.toString();
			type("sustainability_certification_certificationexpiration_XPATH", futureDate44);

			// select the certification status from the dropdown
			select("sustainability_certification_certificationstatus_XPATH", data.get("status_1"));

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
			type("sustainability_searchtxt_XPATH", data.get("name_4"));

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

		// synchronization
		explicitWait("propertylist_title_XPATH");

		// verify the property list
		switchVerification("propertylist_title_XPATH", "Property List", "The property list is not displayed.");

		// CREATE NEW CERTIFICATIONS RECORD - WELL BUILDING STANDARD - DENIED STATUS -
		// EXPIRED
		title("CREATE NEW CERTIFICATIONS RECORD - WELL BUILDING STANDARD - DENIED STATUS - EXPIRED");

		try {
			// enter the property name in the search field
			type("envreports_propertylist_filtertxt_CSS", data.get("property_1"));

			// click on the sustainability icon
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
			select("sustainability_certification_certificationtype_XPATH", data.get("type_1"));

			// select the certification name from the dropdown
			select("sustainability_certification_certificationname_XPATH", data.get("name_5"));

			// select the certification sub type from the dropdown
			select("sustainability_certification_certificationsubtype_XPATH", data.get("sub_type_5"));

			// select the level of certification from the dropdown
			select("sustainability_certification_levelofcertification_XPATH", data.get("level_1"));

			// enter the certification score in the field
			type("sustainability_certification_certificationscore_XPATH", "5");

			// enter on the date of certification
			LocalDate date5 = LocalDate.now().minusDays(7);
			String currentDate5 = date5.toString();
			type("sustainability_certification_dateofcertification_XPATH", currentDate5);

			// enter on the date of certification
			LocalDate date55 = LocalDate.now().minusDays(3);
			String futureDate55 = date55.toString();
			type("sustainability_certification_certificationexpiration_XPATH", futureDate55);

			// select the certification status from the dropdown
			select("sustainability_certification_certificationstatus_XPATH", data.get("status_3"));

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
			type("sustainability_searchtxt_XPATH", data.get("name_5"));

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

		// synchronization
		explicitWait("propertylist_title_XPATH");

		// verify the property list
		switchVerification("propertylist_title_XPATH", "Property List", "The property list is not displayed.");

		// VALIDATE THE COUNT OF THE NEWLY CREATED CERTIFICATION IN THE BUILDING
		// CERTIFICATION DASHBOARD
		title("VALIDATE THE COUNT OF THE NEWLY CREATED CERTIFICATION IN THE BUILDING CERTIFICATION DASHBOARD");

		// order of the certification type in the dashboard: leed, well building
		// standard, boma best, fitwel, wiredscore
		try {

			// wait for the element
			Thread.sleep(5000);

			// click on the side menu
			click("menubtn_CSS");

			// wait for the element
			Thread.sleep(5000);

			// click on the sustainability option
			click("sidemenu_sustainability_CSS");

			// select the building certifications option from the dashboard drop down
			select("ssc_sustainability_dashboarddd_CSS", data.get("dashboard_1"));

			// enter todays date in the date field of the active certification section
			LocalDate date1 = LocalDate.now();
			String date1_String = date1.toString();
			type("sustainability_certification_dashboard_date1_XPATH", date1_String);

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
			type("sustainability_certification_dashboard_date2_XPATH", Year_actual);

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
//			type("sustainability_certification_dashboard_date3_XPATH", date3_String);

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

		// synchronization
		explicitWait("propertylist_title_XPATH");

		// verify the property list
		switchVerification("propertylist_title_XPATH", "Property List", "The property list is not displayed.");

		// UPDATE THE STATUS OF THE CERTIFICATION VIA DASHBOARD - ACTIVE TO DENIED
		title("UPDATE THE STATUS OF THE CERTIFICATION VIA DASHBOARD - ACTIVE TO DENIED");

		try {

			// wait for the element
			Thread.sleep(5000);

			// click on the side menu
			click("menubtn_CSS");

			// wait for the element
			Thread.sleep(5000);

			// click on the sustainability option
			click("sidemenu_sustainability_CSS");

			// select the building certifications option from the dashboard drop down
			select("ssc_sustainability_dashboarddd_CSS", data.get("dashboard_1"));

			// click on the active certificate
			click("sustainability_certification_dashboard_section1_count33_XPATH");

			// validate active certification title
			switchVerification("sustainability_activecertification_title_XPATH", "Active Certifications:",
					"The Active Certifications title is not displayed.");

			// enter the name of the property in the search field
			type("sustainability_searchtxt_XPATH", data.get("property_1"));

			// click on the searched property
			String propertyName = "//td[contains(text(),'" + data.get("property_1") + "')]";
			driver.findElement(By.xpath(propertyName)).click();

			// select the certification status from the dropdown
			select("sustainability_certification_certificationstatus_XPATH", data.get("status_3"));

			// click on the save button
			click("sustainability_certification_savebtn_XPATH");

			// wait for the element
			explicitWaitClickable("closetoastmsg_CSS");

			// click on the toaster close button
			click("closetoastmsg_CSS");

			// click on the back to dashboard button
			click("sustainability_activecertification_backtodashboardbtn_XPATH");

			// select the building certifications option from the dashboard drop down
			select("ssc_sustainability_dashboarddd_CSS", data.get("dashboard_1"));

//			// enter todays date in the date field of the active certification section
//			LocalDate date1 = LocalDate.now();
//			String date1_String = date1.toString();
//			type("sustainability_certification_dashboard_date1_XPATH", date1_String);			 

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
//			type("sustainability_certification_dashboard_date2_XPATH", Year_actual);

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
//			type("sustainability_certification_dashboard_date3_XPATH", date3_String);

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

		// synchronization
		explicitWait("propertylist_title_XPATH");

		// verify the property list
		switchVerification("propertylist_title_XPATH", "Property List", "The property list is not displayed.");

		// UPDATE THE STATUS OF THE CERTIFICATION VIA SUSTAINABILITY MODULE - BOMA BEST
		// - DENIED TO PENDING
		title("UPDATE THE STATUS OF THE CERTIFICATION VIA DASHBOARD - BOMA BEST - DENIED TO PENDING");

		try {
			// enter the property name in the search field
			type("envreports_propertylist_filtertxt_CSS", data.get("property_1"));

			// click on the sustainability icon
			click("sustainabilityicon_CSS");

			// wait for the element
			Thread.sleep(5000);

			// click on the side menu
			click("ssc_leftsidemenubtn_CSS");

			// wait for the element
			Thread.sleep(5000);

			// click on the certifications option
			click("sustainability_sidemenu_certificationsoption_XPATH");

			// enter the certificate name in the search field
			type("sustainability_searchtxt_XPATH", data.get("name_1"));

			// click on the searched certification
			String name1 = "//td[text()='" + data.get("name_1") + "']";
			driver.findElement(By.xpath(name1)).click();

			// select the certification status from the dropdown
			select("sustainability_certification_certificationstatus_XPATH", data.get("status_2"));

			// click on the save button
			click("sustainability_certification_savebtn_XPATH");

			// wait for the element
			explicitWaitClickable("closetoastmsg_CSS");

			// click on the toaster close button
			click("closetoastmsg_CSS");

			// click on the home icon from the top of the screen
			click("questionnaire_homeburgermenubtn_hide_CSS");

			// synchronization
			explicitWait("propertylist_title_XPATH");

			// verify the property list
			switchVerification("propertylist_title_XPATH", "Property List", "The property list is not displayed.");

			// wait for the element
			Thread.sleep(5000);

			// click on the side menu
			click("menubtn_CSS");

			// wait for the element
			Thread.sleep(5000);

			// click on the sustainability option
			click("sidemenu_sustainability_CSS");

			// select the building certifications option from the dashboard drop down
			select("ssc_sustainability_dashboarddd_CSS", data.get("dashboard_1"));

//			// enter todays date in the date field of the active certification section
//			LocalDate date1 = LocalDate.now();
//			String date1_String = date1.toString();			 
//			type("sustainability_certification_dashboard_date1_XPATH", date1_String);

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
//			type("sustainability_certification_dashboard_date2_XPATH", Year_actual);

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
//			type("sustainability_certification_dashboard_date3_XPATH", date3_String);

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

		// synchronization
		explicitWait("propertylist_title_XPATH");

		// verify the property list
		switchVerification("propertylist_title_XPATH", "Property List", "The property list is not displayed.");

		// UPDATE THE EFFECTIVE DATE OF THE EACH SECTION AND VALIDATE THE COUNT
		title("UPDATE THE EFFECTIVE DATE OF THE EACH SECTION AND VALIDATE THE COUNT");

		try {
			// wait for the element
			Thread.sleep(5000);

			// click on the side menu
			click("menubtn_CSS");

			// wait for the element
			Thread.sleep(5000);

			// click on the sustainability option
			click("sidemenu_sustainability_CSS");

			// select the building certifications option from the dashboard drop down
			select("ssc_sustainability_dashboarddd_CSS", data.get("dashboard_1"));

			// enter 2 dates in future in the date field of the active certification section
			LocalDate futureDate1 = LocalDate.now().plusDays(2);
			String futureDate1_String = futureDate1.toString();
			type("sustainability_certification_dashboard_date1_XPATH", futureDate1_String);

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
			type("sustainability_certification_dashboard_date1_XPATH", futureDate11_String);

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
			type("sustainability_certification_dashboard_date2_XPATH", Year2_actual);

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
			type("sustainability_certification_dashboard_date3_XPATH", futureDate3_String);

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
			type("sustainability_certification_dashboard_date3_XPATH", futureDate33_String);

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

		// synchronization
		explicitWait("propertylist_title_XPATH");

		// verify the property list
		switchVerification("propertylist_title_XPATH", "Property List", "The property list is not displayed.");

		// UPDATE THE YEAR OF THE ACTIVE CERIFICATE - LEED
		title("UPDATE THE YEAR OF THE ACTIVE CERIFICATE - LEED");

		try {
			// wait for the element
			Thread.sleep(5000);

			// click on the side menu
			click("menubtn_CSS");

			// wait for the element
			Thread.sleep(5000);

			// click on the sustainability option
			click("sidemenu_sustainability_CSS");

			// select the building certifications option from the dashboard drop down
			select("ssc_sustainability_dashboarddd_CSS", data.get("dashboard_1"));

			// enter 2 dates in future in the date field of the active certification section
			LocalDate futureDate1 = LocalDate.now().plusDays(2);
			String futureDate1_String = futureDate1.toString();
			type("sustainability_certification_dashboard_date1_XPATH", futureDate1_String);

			// click on the count of the active certification
			click("sustainability_certification_dashboard_section1_count1_XPATH");

			// click on the count of the sub type of the active certificate
			click("sustainability_certification_dashboard_section1_count11_XPATH");

			// validate active certification title
			switchVerification("sustainability_activecertification_title_XPATH", "Active Certifications:",
					"The Active Certifications title is not displayed.");

			// enter the name of the property in the search field
			type("sustainability_searchtxt_XPATH", data.get("property_1"));

			// click on the searched property
			String propertyName = "//td[contains(text(),'" + data.get("property_1") + "')]";
			driver.findElement(By.xpath(propertyName)).click();

			// update the expiration date
			LocalDate futureDate3 = LocalDate.now().plusYears(1);
			String futureDate3_String = futureDate3.toString();
//			String[] Year3 = futureDate3_String.split("-");
//			String Year3_actual = Year3[0];
			type("sustainability_certification_certificationexpiration_XPATH", futureDate3_String);

			// click on the save button
			click("sustainability_certification_savebtn_XPATH");

			// wait for the element
			explicitWaitClickable("closetoastmsg_CSS");

			// click on the toaster close button
			click("closetoastmsg_CSS");

			// click on the back to dashboard button
			click("sustainability_activecertification_backtodashboardbtn_XPATH");

			// select the building certifications option from the dashboard drop down
			select("ssc_sustainability_dashboarddd_CSS", data.get("dashboard_1"));

			// enter 2 dates in future in the date field of the active certification section
			LocalDate futureDate4 = LocalDate.now().plusDays(2);
			String futureDate4_String = futureDate4.toString();
			type("sustainability_certification_dashboard_date1_XPATH", futureDate4_String);

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
			type("sustainability_certification_dashboard_date1_XPATH", futureDate11_String);

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
			type("sustainability_certification_dashboard_date2_XPATH", Year6_actual);

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
			type("sustainability_certification_dashboard_date3_XPATH", futureDate7_String);

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
			type("sustainability_certification_dashboard_date3_XPATH", futureDate33_String);

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

		// synchronization
		explicitWait("propertylist_title_XPATH");

		// verify the property list
		switchVerification("propertylist_title_XPATH", "Property List", "The property list is not displayed.");

		// UPDATE THE YEARS OF THE EXPIRED CERTIFICATE - FITWEL
		title("UPDATE THE YEARS OF THE EXPIRED CERTIFICATE - FITWEL");

		try {
			// wait for the element
			Thread.sleep(5000);

			// click on the side menu
			click("menubtn_CSS");

			// wait for the element
			Thread.sleep(5000);

			// click on the sustainability option
			click("sidemenu_sustainability_CSS");

			// select the building certifications option from the dashboard drop down
			select("ssc_sustainability_dashboarddd_CSS", data.get("dashboard_1"));

			// click on the count of the sub type of the expired certification
			click("sustainability_certification_dashboard_section2_count44_XPATH");

			// validate active certification title
			switchVerification("sustainability_expiredcertification_title_XPATH", "Expiring Certifications:",
					"The Expiring Certifications title is not displayed.");

			// enter the name of the property in the search field
			type("sustainability_searchtxt_XPATH", data.get("property_1"));

			// click on the searched property
			String propertyName = "//td[contains(text(),'" + data.get("property_1") + "')]";
			driver.findElement(By.xpath(propertyName)).click();

			// update the expiration date
			LocalDate futureDate4 = LocalDate.now().plusYears(2);
			String futureDate4_String = futureDate4.toString();
			type("sustainability_certification_certificationexpiration_XPATH", futureDate4_String);

			// click on the save button
			click("sustainability_certification_savebtn_XPATH");

			// wait for the element
			explicitWaitClickable("closetoastmsg_CSS");

			// click on the toaster close button
			click("closetoastmsg_CSS");

			// click on the back to dashboard button
			click("sustainability_activecertification_backtodashboardbtn_XPATH");

			// select the building certifications option from the dashboard drop down
			select("ssc_sustainability_dashboarddd_CSS", data.get("dashboard_1"));

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
			type("sustainability_certification_dashboard_date2_XPATH", Year7_actual);

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
			type("sustainability_certification_dashboard_date2_XPATH", Year8_actual);

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

		// synchronization
		explicitWait("propertylist_title_XPATH");

		// verify the property list
		switchVerification("propertylist_title_XPATH", "Property List", "The property list is not displayed.");

		// UPDATE EXPIRED CERTIFICATE WITH DENIED STATUS - BOMA BEST
		title("UPDATE EXPIRED CERTIFICATE WITH DENIED STATUS - BOMA BEST");

		try {
			// wait for the element
			Thread.sleep(5000);

			// click on the side menu
			click("menubtn_CSS");

			// wait for the element
			Thread.sleep(5000);

			// click on the sustainability option
			click("sidemenu_sustainability_CSS");

			// select the building certifications option from the dashboard drop down
			select("ssc_sustainability_dashboarddd_CSS", data.get("dashboard_1"));

			// click on the count of the sub type of the expired certification
			click("sustainability_certification_dashboard_section2_count33_XPATH");

			// validate active certification title
			switchVerification("sustainability_expiredcertification_title_XPATH", "Expiring Certifications:",
					"The Expiring Certifications title is not displayed.");

			// enter the name of the property in the search field
			type("sustainability_searchtxt_XPATH", data.get("property_1"));

			// click on the searched property
			String propertyName = "//td[contains(text(),'" + data.get("property_1") + "')]";
			driver.findElement(By.xpath(propertyName)).click();

			// update the status of the expired certificate
			select("sustainability_certification_certificationstatus_XPATH", data.get("status_3"));

			// click on the save button
			click("sustainability_certification_savebtn_XPATH");

			// wait for the element
			explicitWaitClickable("closetoastmsg_CSS");

			// click on the toaster close button
			click("closetoastmsg_CSS");

			// click on the back to dashboard button
			click("sustainability_activecertification_backtodashboardbtn_XPATH");

			// select the building certifications option from the dashboard drop down
			select("ssc_sustainability_dashboarddd_CSS", data.get("dashboard_1"));

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

		// synchronization
		explicitWait("propertylist_title_XPATH");

		// verify the property list
		switchVerification("propertylist_title_XPATH", "Property List", "The property list is not displayed.");

		// ADD NEW RECORD OF THE FITWEL CERTIFICATE IN ANOTHER PROPERTY
		title("ADD NEW RECORD OF THE FITWEL CERTIFICATE IN ANOTHER PROPERTY");

		try {
			// enter the property name in the search field
			type("envreports_propertylist_filtertxt_CSS", data.get("property_2"));

			// click on the sustainability icon
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
			select("sustainability_certification_certificationtype_XPATH", data.get("type_1"));

			// select the certification name from the dropdown
			select("sustainability_certification_certificationname_XPATH", data.get("name_4"));

			// select the certification sub type from the dropdown
			select("sustainability_certification_certificationsubtype_XPATH", data.get("sub_type_4"));

			// select the level of certification from the dropdown
			select("sustainability_certification_levelofcertification_XPATH", data.get("level_1"));

			// enter the certification score in the field
			type("sustainability_certification_certificationscore_XPATH", "5");

			// enter on the date of certification
			LocalDate date4 = LocalDate.now();
			String currentDate4 = date4.toString();
			type("sustainability_certification_dateofcertification_XPATH", currentDate4);

			// enter on the date of certification
			LocalDate date44 = LocalDate.now().plusDays(10);
			String futureDate44 = date44.toString();
			type("sustainability_certification_certificationexpiration_XPATH", futureDate44);

			// select the certification status from the dropdown
			select("sustainability_certification_certificationstatus_XPATH", data.get("status_1"));

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
			type("sustainability_searchtxt_XPATH", data.get("name_4"));

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

		// synchronization
		explicitWait("propertylist_title_XPATH");

		// verify the property list
		switchVerification("propertylist_title_XPATH", "Property List", "The property list is not displayed.");

		// VERIFIED COUNT OF THE ACTIVE AND EXPIRY SECTION FOR BOTH PROPERTIES
		title("VERIFIED COUNT OF THE ACTIVE AND EXPIRY SECTION FOR BOTH PROPERTIES");

		try {
			// wait for the element
			Thread.sleep(5000);

			// click on the side menu
			click("menubtn_CSS");

			// wait for the element
			Thread.sleep(5000);

			// click on the sustainability option
			click("sidemenu_sustainability_CSS");

			// select the building certifications option from the dashboard drop down
			select("ssc_sustainability_dashboarddd_CSS", data.get("dashboard_1"));

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

		// synchronization
		explicitWait("propertylist_title_XPATH");

		// verify the property list
		switchVerification("propertylist_title_XPATH", "Property List", "The property list is not displayed.");

		// DELETE ALL THE NEWLY CREATED CERTIFICATES FROM ALL THE PROPERTIES
		title("DELETE ALL THE NEWLY CREATED CERTIFICATES FROM ALL THE PROPERTIES");

		helper.deleteAllCertificates(data.get("property_1"));
		helper.deleteAllCertificates(data.get("property_2"));
		helper.deleteAllCertificates(data.get("property_3"));
		helper.deleteAllCertificates(data.get("property_4"));

		// click on the home icon from the top of the screen
		click("questionnaire_homeburgermenubtn_hide_CSS");

		// synchronization
		explicitWait("propertylist_title_XPATH");

		// verify the property list
		switchVerification("propertylist_title_XPATH", "Property List", "The property list is not displayed.");

	}
}
