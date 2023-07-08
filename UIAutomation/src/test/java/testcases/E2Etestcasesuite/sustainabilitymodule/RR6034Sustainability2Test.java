package testcases.E2Etestcasesuite.sustainabilitymodule;

import java.io.IOException;
import java.util.Hashtable;

import org.openqa.selenium.By;
import org.testng.Reporter;
import org.testng.SkipException;
import org.testng.annotations.Test;

import com.relevantcodes.extentreports.LogStatus;

import base.Helper;
import base.TestBase;
import utilities.TestUtil;

public class RR6034Sustainability2Test extends TestBase {

	@Test(dataProviderClass = TestUtil.class, dataProvider = "dp")
	public void rR6034Sustainability2Test(Hashtable<String, String> data) throws IOException, InterruptedException {

		execution(data, "rR6034Sustainability2Test");

		// VALIDATE THE ACCESS TO ENERGY STAR DATA SECURITY SETTINGS

		System.out.println("VALIDATE THE ACCESS TO ENERGY STAR DATA SECURITY SETTINGS");
		test.log(LogStatus.INFO, "VALIDATE THE ACCESS TO ENERGY STAR DATA SECURITY SETTINGS");
		Reporter.log("VALIDATE THE ACCESS TO ENERGY STAR DATA SECURITY SETTINGS");
		log.info("VALIDATE THE ACCESS TO ENERGY STAR DATA SECURITY SETTINGS");

		Helper helper = new Helper();

		// refresh the page
		driver.navigate().refresh();
		explicitWait("sustainabilityicon_CSS");
		driver.navigate().refresh();

		System.out.println("Navigate to the Home Screen i.e. Property List Screen.");

		// UPDATE THE ACCESS TO ENERGY STAR DATA SECURITY SETTINGS

		System.out
				.println("***************** UPDATE THE ACCESS TO ENERGY STAR DATA SECURITY SETTINGS *****************");
		test.log(LogStatus.INFO,
				"***************** UPDATE THE ACCESS TO ENERGY STAR DATA SECURITY SETTINGS *****************");
		Reporter.log("***************** UPDATE THE ACCESS TO ENERGY STAR DATA SECURITY SETTINGS *****************");
		log.info("***************** UPDATE THE ACCESS TO ENERGY STAR DATA SECURITY SETTINGS *****************");

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

			// RESET THE ACCESS TO ENERGY DASHBOARD OPTIONS SECURITY SETTINGS

			helper.resetPermission(data, "security_setting_1", "sustainability_utilitybills_securitysettings2_XPATH");

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

		// VALIDATE ACCESS TO ENERGY DASHBOARD OPTIONS IN ADMIN USER

		System.out.println("***************** VALIDATE ACCESS TO ENERGY STAR DATA IN ADMIN USER *****************");
		test.log(LogStatus.INFO,
				"***************** VALIDATE ACCESS TO ENERGY STAR DATA IN ADMIN USER *****************");
		Reporter.log("***************** VALIDATE ACCESS TO ENERGY STAR DATA IN ADMIN USER *****************");
		log.info("***************** VALIDATE ACCESS TO ENERGY STAR DATA IN ADMIN USER *****************");

		try {
			// enter the property name in the search field
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

			// validate access to energy star data option
			try {
				boolean option2 = driver
						.findElement(By.xpath(OR.getProperty("sustainability_utilitybills_energystaroption_XPATH")))
						.isDisplayed();

				if (option2 == true) {
					successMessage("The energy star data option is displayed as expected.");

				} else {
					verificationFailedMessage("The energy star data option is not displayed.");
				}
			} catch (Throwable t) {
				verificationFailedMessage("The energy star data option is not displayed.");
			}
		} catch (Throwable t) {
			verificationFailed();
		}

		// click on the close the side menu
		click("propertyproject_closesidemenu_CSS");
		ngDriver.waitForAngularRequestsToFinish();
		System.out.println("Clicked on the close the side menu.");

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

			// VALIDATE ACCESS TO ENERGY STAR DATA IN PROPERTY MANAGER USER

			System.out.println(
					"***************** VALIDATE ACCESS TO ENERGY STAR DATA IN PROPERTY MANAGER USER *****************");
			test.log(LogStatus.INFO,
					"***************** VALIDATE ACCESS TO ENERGY STAR DATA IN PROPERTY MANAGER USER *****************");
			Reporter.log(
					"***************** VALIDATE ACCESS TO ENERGY STAR DATA IN PROPERTY MANAGER USER *****************");
			log.info(
					"***************** VALIDATE ACCESS TO ENERGY STAR DATA IN PROPERTY MANAGER USER *****************");

			try {
				// enter the property name in the search field
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

				// validate access to energy star data option
				try {
					boolean option2 = driver
							.findElement(By.xpath(OR.getProperty("sustainability_utilitybills_energystaroption_XPATH")))
							.isDisplayed();

					if (option2 == true) {

						verificationFailedMessage("The energy star data option is displayed without permission.");

					} else {

						successMessage("The energy star data option is not displayed as expected.");

					}
				} catch (Throwable t) {
					successMessage("The energy star data option is not displayed as expected.");

				}
			} catch (Throwable t) {
				verificationFailed();
			}

			// click on the close the side menu
			click("propertyproject_closesidemenu_CSS");
			ngDriver.waitForAngularRequestsToFinish();
			System.out.println("Clicked on the close the side menu.");

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
			click("sustainability_utilitybills_securitysettings2_XPATH");
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

			// VALIDATE ACCESS TO ENERGY STAR DATA IN PROPERTY MANAGER USER

			System.out.println(
					"***************** VALIDATE ACCESS TO ENERGY STAR DATA IN PROPERTY MANAGER USER *****************");
			test.log(LogStatus.INFO,
					"***************** VALIDATE ACCESS TO ENERGY STAR DATA IN PROPERTY MANAGER USER *****************");
			Reporter.log(
					"***************** VALIDATE ACCESS TO ENERGY STAR DATA IN PROPERTY MANAGER USER *****************");
			log.info(
					"***************** VALIDATE ACCESS TO ENERGY STAR DATA IN PROPERTY MANAGER USER *****************");

			try {
				// enter the property name in the search field
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

				// validate access to energy star data option
				try {
					boolean option2 = driver
							.findElement(By.xpath(OR.getProperty("sustainability_utilitybills_energystaroption_XPATH")))
							.isDisplayed();

					if (option2 == true) {
						successMessage("The energy star data option is displayed as expected.");
					} else {
						verificationFailedMessage("The energy star data option is not displayed.");
					}
				} catch (Throwable t) {
					verificationFailedMessage("The energy star data option is not displayed.");
				}
			} catch (Throwable t) {
				verificationFailed();
			}

			// click on the close the side menu
			click("propertyproject_closesidemenu_CSS");
			ngDriver.waitForAngularRequestsToFinish();
			System.out.println("Clicked on the close the side menu.");

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

	}
}
