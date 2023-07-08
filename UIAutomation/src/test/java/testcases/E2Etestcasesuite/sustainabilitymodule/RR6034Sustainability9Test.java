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

		System.out.println("VALIDATE THE PERMISSION TO EDIT BUILDING CERTIFICATES SECURITY SETTINGS");
		test.log(LogStatus.INFO, "VALIDATE THE PERMISSION TO EDIT BUILDING CERTIFICATES SECURITY SETTINGS");
		Reporter.log("VALIDATE THE PERMISSION TO EDIT BUILDING CERTIFICATES SECURITY SETTINGS");
		log.info("VALIDATE THE PERMISSION TO EDIT BUILDING CERTIFICATES SECURITY SETTINGS");

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

		// click on the home icon from the top of the screen
		click("questionnaire_homeburgermenubtn_hide_CSS");
		System.out.println("Clicked on the home icon from the top of the screen.");
		ngDriver.waitForAngularRequestsToFinish();

		// synchronization
		explicitWait("propertylist_title_XPATH");

		// verify the property list
		switchVerification("propertylist_title_XPATH", "Property List", "The property list is not displayed.");

		// UPDATE THE PERMISSION TO EDIT BUILDING CERTIFICATES SECURITY SETTINGS

		System.out.println(
				"***************** UPDATE THE PERMISSION TO EDIT BUILDING CERTIFICATES SECURITY SETTINGS *****************");
		test.log(LogStatus.INFO,
				"***************** UPDATE THE PERMISSION TO EDIT BUILDING CERTIFICATES SECURITY SETTINGS *****************");
		Reporter.log(
				"***************** UPDATE THE PERMISSION TO EDIT BUILDING CERTIFICATES SECURITY SETTINGS *****************");
		log.info(
				"***************** UPDATE THE PERMISSION TO EDIT BUILDING CERTIFICATES SECURITY SETTINGS *****************");

		try {

			// wait for the element
			explicitWaitClickable("questionnaire_settingicon_CSS");

			// click on the settings icon from the top of the screen
			click("questionnaire_settingicon_CSS");
			System.out.println("Clicked on the settings icon.");
			ngDriver.waitForAngularRequestsToFinish();

			// wait for the element
			explicitWaitClickable("questionnaire_administrationoption_XPATH");

			// click on the Administration option from the side menu
			click("questionnaire_administrationoption_XPATH");
			System.out.println("Clicked on the Administration option from the side menu.");
			ngDriver.waitForAngularRequestsToFinish();

			// click on the security tab
			click("questionnaire_securitytab_XPATH");
			System.out.println("Clicked on the security tab.");
			ngDriver.waitForAngularRequestsToFinish();

			// click on the security settings option
			click("questionnaire_securotysettingsoption_XPATH");
			System.out.println("Clicked on the security settings option.");
			ngDriver.waitForAngularRequestsToFinish();

			// RESET THE PERMISSION TO EDIT BUILDING CERTIFICATES SECURITY SETTINGS

			helper.resetPermission(data, "security_setting_1", "sustainability_utilitybills_securitysettings9_XPATH");

		} catch (Throwable t) {
			verificationFailed();
		}

		// click on the home icon
		click("questionnaire_homeburgermenubtn_CSS");
		ngDriver.waitForAngularRequestsToFinish();
		System.out.println("Clicked on the home icon.");

		// wait for the element
		explicitWait("propertylist_title_XPATH");

		// verify the property list
		switchVerification("propertylist_title_XPATH", "Property List", "The property list is not displayed.");

		// VALIDATE THE PERMISSION TO EDIT BUILDING CERTIFICATES IN ADMIN USER

		System.out.println(
				"***************** VALIDATE THE PERMISSION TO EDIT BUILDING CERTIFICATES IN ADMIN USER *****************");
		test.log(LogStatus.INFO,
				"***************** VALIDATE THE PERMISSION TO EDIT BUILDING CERTIFICATES IN ADMIN USER *****************");
		Reporter.log(
				"***************** VALIDATE THE PERMISSION TO EDIT BUILDING CERTIFICATES IN ADMIN USER *****************");
		log.info(
				"***************** VALIDATE THE PERMISSION TO EDIT BUILDING CERTIFICATES IN ADMIN USER *****************");

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
			clear("sustainability_searchtxt_XPATH");
			type("sustainability_searchtxt_XPATH", data.get("type"));
			ngDriver.waitForAngularRequestsToFinish();
			System.out.println("Entered the newly created certification record in the search field.");

			// click on the newly created certification record
			click("sustainability_certification_addedtype_XPATH");
			ngDriver.waitForAngularRequestsToFinish();
			System.out.println("Clicked on the newly created certification record.");

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
		System.out.println("Clicked on the home icon from the top of the screen.");
		ngDriver.waitForAngularRequestsToFinish();

		// synchronization
		explicitWait("propertylist_title_XPATH");

		// verify the property list
		switchVerification("propertylist_title_XPATH", "Property List", "The property list is not displayed.");

		// LOGOUT FROM THE ADMIN USER AND LOGIN IN JINESH USER

		System.out.println("***************** LOGOUT FROM THE ADMIN USER AND LOGIN IN JINESH USER *****************");
		test.log(LogStatus.INFO,
				"***************** LOGOUT FROM THE ADMIN USER AND LOGIN IN JINESH USER *****************");
		Reporter.log("***************** LOGOUT FROM THE ADMIN USER AND LOGIN IN JINESH USER *****************");
		log.info("***************** LOGOUT FROM THE ADMIN USER AND LOGIN IN JINESH USER *****************");

		try {

			try {
				// wait for the element
				explicitWaitClickable("questionnaire_settingicon_CSS");

				// click on the settings icon from the top of the screen
				click("questionnaire_settingicon_CSS");
				System.out.println("Clicked on the settings icon.");
				ngDriver.waitForAngularRequestsToFinish();

				// wait for the element
				explicitWaitClickable("sidemenu_logout_CSS");

				// click on the logout option from the side menu
				click("sidemenu_logout_CSS");
				System.out.println("Clicked on the logout option from the side menu.");
				ngDriver.waitForAngularRequestsToFinish();

				helper.loginAndUpdateSystemCompany(data, "username", "password", "SystemCompany");

			} catch (Throwable t) {
				verificationFailed();
			}

			// VALIDATE THE PERMISSION TO EDIT BUILDING CERTIFICATES IN PROPERTY MANAGER
			// USER

			System.out.println(
					"***************** VALIDATE THE PERMISSION TO EDIT BUILDING CERTIFICATES IN PROPERTY MANAGER USER *****************");
			test.log(LogStatus.INFO,
					"***************** VALIDATE THE PERMISSION TO EDIT BUILDING CERTIFICATES IN PROPERTY MANAGER USER *****************");
			Reporter.log(
					"***************** VALIDATE THE PERMISSION TO EDIT BUILDING CERTIFICATES IN PROPERTY MANAGER USER *****************");
			log.info(
					"***************** VALIDATE THE PERMISSION TO EDIT BUILDING CERTIFICATES IN PROPERTY MANAGER USER *****************");

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
				clear("sustainability_searchtxt_XPATH");
				type("sustainability_searchtxt_XPATH", data.get("type"));
				ngDriver.waitForAngularRequestsToFinish();
				System.out.println("Entered the newly created certification record in the search field.");

				// click on the newly created certification record
				click("sustainability_certification_addedtype_XPATH");
				ngDriver.waitForAngularRequestsToFinish();
				System.out.println("Clicked on the newly created certification record.");

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
			System.out.println("Clicked on the home icon from the top of the screen.");
			ngDriver.waitForAngularRequestsToFinish();

			// synchronization
			explicitWait("propertylist_title_XPATH");

			// verify the property list
			switchVerification("propertylist_title_XPATH", "Property List", "The property list is not displayed.");

			// LOGOUT FROM THE PROPERTY MANAGER USER AND LOGIN IN ADMIN USER

			System.out.println(
					"***************** LOGOUT FROM THE PROPERTY MANAGER USER AND LOGIN IN ADMIN USER *****************");
			test.log(LogStatus.INFO,
					"***************** LOGOUT FROM THE PROPERTY MANAGER USER AND LOGIN IN ADMIN USER *****************");
			Reporter.log(
					"***************** LOGOUT FROM THE PROPERTY MANAGER USER AND LOGIN IN ADMIN USER *****************");
			log.info(
					"***************** LOGOUT FROM THE PROPERTY MANAGER USER AND LOGIN IN ADMIN USER *****************");

			try {
				// wait for the element
				explicitWaitClickable("questionnaire_settingicon_CSS");

				// click on the settings icon from the top of the screen
				click("questionnaire_settingicon_CSS");
				System.out.println("Clicked on the settings icon.");
				ngDriver.waitForAngularRequestsToFinish();

				// wait for the element
				explicitWaitClickable("sidemenu_logout_CSS");

				// click on the logout option from the side menu
				click("sidemenu_logout_CSS");
				System.out.println("Clicked on the logout option from the side menu.");
				ngDriver.waitForAngularRequestsToFinish();

				helper.loginAndUpdateSystemCompany(data, "username_1", "password_1", "SystemCompany");

			} catch (Throwable t) {
				verificationFailed();
			}

		} catch (Throwable t) {
			helper.questionnaireNotDisplayLogout(data);
		}

		// click on the home icon from the top of the screen
		click("questionnaire_homeburgermenubtn_hide_CSS");
		System.out.println("Clicked on the home icon from the top of the screen.");
		ngDriver.waitForAngularRequestsToFinish();

		// synchronization
		explicitWait("propertylist_title_XPATH");

		// verify the property list
		switchVerification("propertylist_title_XPATH", "Property List", "The property list is not displayed.");

		// DELETE THE NEWLY CREATED CERTIFICATION RECORD

		System.out.println("***************** DELETE THE NEWLY CREATED CERTIFICATION RECORD *****************");
		test.log(LogStatus.INFO, "***************** DELETE THE NEWLY CREATED CERTIFICATION RECORD *****************");
		Reporter.log("***************** DELETE THE NEWLY CREATED CERTIFICATION RECORD *****************");
		log.info("***************** DELETE THE NEWLY CREATED CERTIFICATION RECORD *****************");

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

			// click on the UTILITY METERS option
			click("sustainability_sidemenu_certificationsoption_XPATH");
			ngDriver.waitForAngularRequestsToFinish();
			System.out.println("Clicked on the UTILITY METERS option.");

			// enter the certification record in the search field
			clear("sustainability_searchtxt_XPATH");
			type("sustainability_searchtxt_XPATH", data.get("type"));
			ngDriver.waitForAngularRequestsToFinish();
			System.out.println("Entered the updated certification record in the search field.");

			// click on the certification record
			click("sustainability_certification_addedtype_XPATH");
			ngDriver.waitForAngularRequestsToFinish();
			System.out.println("Clicked on the certification record.");

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

			// wait for the element
			explicitWaitClickable("closetoastmsg_CSS");

			// click on the toaster close button
			click("closetoastmsg_CSS");
			ngDriver.waitForAngularRequestsToFinish();
			System.out.println("Clicked on the toaster close button.");

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

		// RESET THE APPLIED PERMISSION

		System.out.println("**************** RESET THE APPLIED PERMISSIONS ****************");
		test.log(LogStatus.INFO, "**************** RESET THE APPLIED PERMISSIONS ****************");
		Reporter.log("**************** RESET THE APPLIED PERMISSIONS ****************");
		log.info("**************** RESET THE APPLIED PERMISSIONS ****************");

		try {
			// wait for the element
			explicitWaitClickable("questionnaire_settingicon_CSS");

			// click on the settings icon from the top of the screen
			click("questionnaire_settingicon_CSS");
			System.out.println("Clicked on the settings icon.");
			ngDriver.waitForAngularRequestsToFinish();

			// wait for the element
			explicitWaitClickable("questionnaire_administrationoption_XPATH");

			// click on the Administration option from the side menu
			click("questionnaire_administrationoption_XPATH");
			System.out.println("Clicked on the Administration option from the side menu.");
			ngDriver.waitForAngularRequestsToFinish();

			// click on the security tab
			click("questionnaire_securitytab_XPATH");
			System.out.println("Clicked on the security tab.");
			ngDriver.waitForAngularRequestsToFinish();

			// click on the security settings option
			click("questionnaire_securotysettingsoption_XPATH");
			System.out.println("Clicked on the security settings option.");
			ngDriver.waitForAngularRequestsToFinish();

			// enter security setting name in the search field
			clear("propertyproject_le_filtertxt_CSS");
			type("propertyproject_le_filtertxt_CSS", data.get("security_setting_1"));
			ngDriver.waitForAngularRequestsToFinish();
			System.out.println("Entered security setting name in the search field.");

			// click on the searched result
			click("sustainability_utilitybills_securitysettings9_XPATH");
			ngDriver.waitForAngularRequestsToFinish();
			System.out.println("Clicked on the searched result.");

			// click on the select role field
			click("propertyproject_securitysettings1_selectroles_CSS");
			ngDriver.waitForAngularRequestsToFinish();
			System.out.println("Clicked on the select role field.");

			// click on the none button
			click("propertyproject_securitysettings1_nonebtn_CSS");
			ngDriver.waitForAngularRequestsToFinish();
			System.out.println("Clicked on the none button.");

			// enter the name of the role in search field
			clear("propertyproject_securitysettings1_searchtxt_CSS");
			ngDriver.waitForAngularRequestsToFinish();
			System.out.println("Clear the search field.");
			type("propertyproject_securitysettings1_searchtxt_CSS", data.get("role_1"));
			ngDriver.waitForAngularRequestsToFinish();
			System.out.println("Entered the name of the role in search field.");

			// click on the searched result
			click("sustainability_utilitybills_searchedpm_XPATH");
			ngDriver.waitForAngularRequestsToFinish();
			System.out.println("Clicked on the searched result.");

			// click on the select role field
			click("propertyproject_securitysettings1_selectroles_CSS");
			ngDriver.waitForAngularRequestsToFinish();
			System.out.println("Clicked on the select role field.");

			// click on the save button
			click("propertyproject_securitysettings1_savebtn_CSS");
			ngDriver.waitForAngularRequestsToFinish();
			System.out.println("Clicked on the save button.");

			// wait for the element
			explicitWaitClickable("closetoastmsg_CSS");

			// click on the toaster close button
			click("closetoastmsg_CSS");
			ngDriver.waitForAngularRequestsToFinish();
			System.out.println("Clicked on the toaster close button.");

		} catch (Throwable t) {
			verificationFailed();
		}

		// click on the home icon
		click("questionnaire_homeburgermenubtn_CSS");
		ngDriver.waitForAngularRequestsToFinish();
		System.out.println("Clicked on the home icon.");

		// wait for the element
		explicitWait("propertylist_title_XPATH");

		// verify the property list
		switchVerification("propertylist_title_XPATH", "Property List", "The property list is not displayed.");

	}
}
