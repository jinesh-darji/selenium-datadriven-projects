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

public class RR6034Sustainability9Test extends TestBase {

	@Test(dataProviderClass = TestUtil.class, dataProvider = "dp")
	public void rR6034Sustainability9Test(Hashtable<String, String> data) throws IOException, InterruptedException {

		execution(data, "rR6034Sustainability9Test");

		// VALIDATE THE PERMISSION TO EDIT BUILDING CERTIFICATES SECURITY SETTINGS
		title("VALIDATE THE PERMISSION TO EDIT BUILDING CERTIFICATES SECURITY SETTINGS");

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

		// click on the home icon from the top of the screen
		click("questionnaire_homeburgermenubtn_hide_CSS");

		// synchronization
		explicitWait("propertylist_title_XPATH");

		// verify the property list
		switchVerification("propertylist_title_XPATH", "Property List", "The property list is not displayed.");

		// UPDATE THE PERMISSION TO EDIT BUILDING CERTIFICATES SECURITY SETTINGS
		title("UPDATE THE PERMISSION TO EDIT BUILDING CERTIFICATES SECURITY SETTINGS");

		try {

			// wait for the element
			explicitWaitClickable("questionnaire_settingicon_CSS");

			// click on the settings icon from the top of the screen
			click("questionnaire_settingicon_CSS");

			// wait for the element
			explicitWaitClickable("questionnaire_administrationoption_XPATH");

			// click on the Administration option from the side menu
			click("questionnaire_administrationoption_XPATH");

			// click on the security tab
			click("questionnaire_securitytab_XPATH");

			// click on the security settings option
			click("questionnaire_securotysettingsoption_XPATH");

			// RESET THE PERMISSION TO EDIT BUILDING CERTIFICATES SECURITY SETTINGS
			helper.resetPermission(data, "security_setting_1", "sustainability_utilitybills_securitysettings9_XPATH");

		} catch (Throwable t) {
			verificationFailed();
		}

		// click on the home icon
		click("questionnaire_homeburgermenubtn_CSS");

		// wait for the element
		explicitWait("propertylist_title_XPATH");

		// verify the property list
		switchVerification("propertylist_title_XPATH", "Property List", "The property list is not displayed.");

		// VALIDATE THE PERMISSION TO EDIT BUILDING CERTIFICATES IN ADMIN USER
		title("VALIDATE THE PERMISSION TO EDIT BUILDING CERTIFICATES IN ADMIN USER");

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

			// validate the add button of the building certification
			try {
				boolean addBtn = driver
						.findElement(By.xpath(OR.getProperty("sustainability_certification_addbtn_XPATH")))
						.isDisplayed();

				if (addBtn == true) {

					successMessage("The add button of the building certification is displayed as expected.");

				} else {
					verificationFailedMessage("The add button of the building certification is not displayed.");
				}

			} catch (Throwable t) {
				verificationFailedMessage("The add button of the building certification is not displayed.");

			}

			// enter the newly created certification record in the search field
			type("sustainability_searchtxt_XPATH", data.get("type"));

			// click on the newly created certification record
			click("sustainability_certification_addedtype_XPATH");

			// validate the save button of the building certification
			try {
				boolean saveBtn = driver
						.findElement(By.xpath(OR.getProperty("sustainability_certification_savebtn_XPATH")))
						.isDisplayed();

				if (saveBtn == true) {

					successMessage("The save button of the building certification is displayed as expected.");

				} else {
					verificationFailedMessage("The save button of the building certification is not displayed.");
				}

			} catch (Throwable t) {
				verificationFailedMessage("The save button of the building certification is not displayed.");

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

		// LOGOUT FROM THE ADMIN USER AND LOGIN IN JINESH USER
		title("LOGOUT FROM THE ADMIN USER AND LOGIN IN JINESH USER");

		try {

			try {
				// wait for the element
				explicitWaitClickable("questionnaire_settingicon_CSS");

				// click on the settings icon from the top of the screen
				click("questionnaire_settingicon_CSS");

				// wait for the element
				explicitWaitClickable("sidemenu_logout_CSS");

				// click on the logout option from the side menu
				click("sidemenu_logout_CSS");

				helper.loginAndUpdateSystemCompany(data, "username", "password", "SystemCompany");

			} catch (Throwable t) {
				verificationFailed();
			}

			// VALIDATE THE PERMISSION TO EDIT BUILDING CERTIFICATES IN PROPERTY MANAGER
			// USER
			title("VALIDATE THE PERMISSION TO EDIT BUILDING CERTIFICATES IN PROPERTY MANAGER USER");

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

				// validate the add button of the building certification
				try {
					boolean addBtn = driver
							.findElement(By.xpath(OR.getProperty("sustainability_certification_addbtn_XPATH")))
							.isDisplayed();

					if (addBtn == true) {

						verificationFailedMessage(
								"The add button of the building certification is displayed without permission.");

					} else {
						successMessage("The add button of the building certification is not displayed as expected.");
					}

				} catch (Throwable t) {
					successMessage("The add button of the building certification is not displayed as expected.");

				}

				// enter the newly created certification record in the search field
				type("sustainability_searchtxt_XPATH", data.get("type"));

				// click on the newly created certification record
				click("sustainability_certification_addedtype_XPATH");

				// validate the save button of the building certification
				try {
					boolean saveBtn = driver
							.findElement(By.xpath(OR.getProperty("sustainability_certification_savebtn_XPATH")))
							.isDisplayed();

					if (saveBtn == true) {
						verificationFailedMessage(
								"The save button of the building certification is displayed without permission.");

					} else {
						successMessage("The save button of the building certification is not displayed as expected.");
					}

				} catch (Throwable t) {
					successMessage("The save button of the building certification is not displayed as expected.");

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

			// LOGOUT FROM THE PROPERTY MANAGER USER AND LOGIN IN ADMIN USER
			title("LOGOUT FROM THE PROPERTY MANAGER USER AND LOGIN IN ADMIN USER");

			try {
				// wait for the element
				explicitWaitClickable("questionnaire_settingicon_CSS");

				// click on the settings icon from the top of the screen
				click("questionnaire_settingicon_CSS");

				// wait for the element
				explicitWaitClickable("sidemenu_logout_CSS");

				// click on the logout option from the side menu
				click("sidemenu_logout_CSS");

				helper.loginAndUpdateSystemCompany(data, "username_1", "password_1", "SystemCompany");

			} catch (Throwable t) {
				verificationFailed();
			}

		} catch (Throwable t) {
			helper.questionnaireNotDisplayLogout(data);
		}

		// click on the home icon from the top of the screen
		click("questionnaire_homeburgermenubtn_hide_CSS");

		// synchronization
		explicitWait("propertylist_title_XPATH");

		// verify the property list
		switchVerification("propertylist_title_XPATH", "Property List", "The property list is not displayed.");

		// DELETE THE NEWLY CREATED CERTIFICATION RECORD
		title("DELETE THE NEWLY CREATED CERTIFICATION RECORD");

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
			click("sustainability_sidemenu_certificationsoption_XPATH");

			// enter the certification record in the search field
			type("sustainability_searchtxt_XPATH", data.get("type"));

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

		} catch (Throwable t) {
			verificationFailed();
		}

		// click on the home icon from the top of the screen
		click("questionnaire_homeburgermenubtn_hide_CSS");

		// synchronization
		explicitWait("propertylist_title_XPATH");

		// verify the property list
		switchVerification("propertylist_title_XPATH", "Property List", "The property list is not displayed.");

		// RESET THE APPLIED PERMISSION
		title("RESET THE APPLIED PERMISSION");

		try {
			// wait for the element
			explicitWaitClickable("questionnaire_settingicon_CSS");

			// click on the settings icon from the top of the screen
			click("questionnaire_settingicon_CSS");

			// wait for the element
			explicitWaitClickable("questionnaire_administrationoption_XPATH");

			// click on the Administration option from the side menu
			click("questionnaire_administrationoption_XPATH");

			// click on the security tab
			click("questionnaire_securitytab_XPATH");

			// click on the security settings option
			click("questionnaire_securotysettingsoption_XPATH");

			// enter security setting name in the search field
			type("propertyproject_le_filtertxt_CSS", data.get("security_setting_1"));

			// click on the searched result
			click("sustainability_utilitybills_securitysettings9_XPATH");

			// click on the select role field
			click("propertyproject_securitysettings1_selectroles_CSS");

			// click on the none button
			click("propertyproject_securitysettings1_nonebtn_CSS");

			// enter the name of the role in search field
			type("propertyproject_securitysettings1_searchtxt_CSS", data.get("role_1"));

			// click on the searched result
			click("sustainability_utilitybills_searchedpm_XPATH");

			// click on the select role field
			click("propertyproject_securitysettings1_selectroles_CSS");

			// click on the save button
			click("propertyproject_securitysettings1_savebtn_CSS");

			// wait for the element
			explicitWaitClickable("closetoastmsg_CSS");

			// click on the toaster close button
			click("closetoastmsg_CSS");

		} catch (Throwable t) {
			verificationFailed();
		}

		// click on the home icon
		click("questionnaire_homeburgermenubtn_CSS");

		// wait for the element
		explicitWait("propertylist_title_XPATH");

		// verify the property list
		switchVerification("propertylist_title_XPATH", "Property List", "The property list is not displayed.");

	}
}