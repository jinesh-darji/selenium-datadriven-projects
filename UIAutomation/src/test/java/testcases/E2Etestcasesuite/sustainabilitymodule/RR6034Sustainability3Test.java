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

public class RR6034Sustainability3Test extends TestBase {

	@Test(dataProviderClass = TestUtil.class, dataProvider = "dp")
	public void rR6034Sustainability3Test(Hashtable<String, String> data) throws IOException, InterruptedException {

		execution(data, "rR6034Sustainability3Test");

		// VALIDATE THE ACCESS TO IMPORT METERS SECURITY SETTINGS
		title("VALIDATE THE ACCESS TO IMPORT METERS SECURITY SETTINGS");

		Helper helper = new Helper();

		// refresh the page
		driver.navigate().refresh();
		explicitWait("sustainabilityicon_CSS");
		driver.navigate().refresh();

		// UPDATE THE ACCESS TO IMPORT METERS SECURITY SETTINGS
		title("UPDATE THE ACCESS TO IMPORT METERS SECURITY SETTINGS");

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

			// RESET THE ACCESS TO ENERGY DASHBOARD OPTIONS SECURITY SETTINGS
			helper.resetPermission(data, "security_setting_1", "sustainability_utilitybills_securitysettings3_XPATH");

		} catch (Throwable t) {
			verificationFailed();
		}

		// click on the home icon
		click("questionnaire_homeburgermenubtn_CSS");

		// wait for the element
		explicitWait("propertylist_title_XPATH");

		// verify the property list
		switchVerification("propertylist_title_XPATH", "Property List", "The property list is not displayed.");

		// VALIDATE THE IMPORT METERS OPTION IN ADMIN USER
		title("VALIDATE THE IMPORT METERS OPTION IN ADMIN USER");

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
			click("sustainability_sidemenu_utilitymetersoption_XPATH");

			// click on the document icon
			click("sustainability_utilitymeters_documenticon_XPATH");

			// wait for the element
			Thread.sleep(3000);

			// validate option icon
			try {
				boolean importOption = driver
						.findElement(By
								.xpath(OR.getProperty("sustainability_utilitymeters_documenticon_importoption_XPATH")))
						.isDisplayed();

				if (importOption == true) {
					successMessage("The import meter option is displayed as expected.");
				} else {
					verificationFailedMessage("The import meter option is not displayed.");
				}
			} catch (Throwable t) {
				verificationFailedMessage("The import meter option is not displayed.");
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

			// VALIDATE ACCESS TO IMPORT METERS IN PROPERTY MANAGER USER
			title("VALIDATE ACCESS TO IMPORT METERS IN PROPERTY MANAGER USER");

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
				click("sustainability_sidemenu_utilitymetersoption_XPATH");

				// click on the document icon
				click("sustainability_utilitymeters_documenticon_XPATH");

				// wait for the element
				Thread.sleep(3000);

				// validate option icon
				try {
					boolean importOption = driver
							.findElement(By.xpath(
									OR.getProperty("sustainability_utilitymeters_documenticon_importoption_XPATH")))
							.isDisplayed();

					if (importOption == true) {

						verificationFailedMessage("The import meter option is displayed without permission.");

					} else {

						successMessage("The import meter option is not displayed as expected.");

					}
				} catch (Throwable t) {
					successMessage("The import meter option is not displayed as expected.");
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
			click("sustainability_utilitybills_securitysettings3_XPATH");

			// click on the select role field
			click("propertyproject_securitysettings1_selectroles_CSS");

			// click on the none button
			click("propertyproject_securitysettings1_nonebtn_CSS");

			// enter the name of the role in search field
			type("propertyproject_securitysettings1_searchtxt_CSS", data.get("role_1"));

			// click on the searched result
			click("sustainability_utilitybills_searchedadmins_XPATH");

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