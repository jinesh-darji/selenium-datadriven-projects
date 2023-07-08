package testcases.E2Etestcasesuite.ohsmodule;

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

public class RR5255OHSSixTest extends TestBase {

	@Test(dataProviderClass = TestUtil.class, dataProvider = "dp")
	public void rR5255OHSSixTest(Hashtable<String, String> data) throws IOException, InterruptedException {

		execution(data, "rR5255OHSSixTest");

		// SECURITY SETTING CONTROLS TO MAKE SURE THE ACCESS TO OHS INCIDENT REPORTS
		// CAN BE ONLY PERFORMED BY THE USER/ROLE WITH ACCESS TO IT.
		title("SECURITY SETTING CONTROLS TO MAKE SURE THE ACCESS TO OHS INCIDENT REPORTS CAN BE ONLY PERFORMED BY THE USER/ROLE WITH ACCESS TO IT.");

		Helper helper = new Helper();

		// refresh the page
		driver.navigate().refresh();
		Thread.sleep(5000);
		driver.navigate().refresh();

		// APPLY THE ACCESS TO OHS INCIDENT REPORTS PERMISSION
		title("APPLY THE ACCESS TO OHS INCIDENT REPORTS PERMISSION");

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

			// APPLY THE ACCESS TO OHS INCIDENT REPORTS
			helper.addPermissionOneUsersRole(data, "ohs_security_setting_2", "ohs_securitysettings2_XPATH");

		} catch (Throwable t) {
			verificationFailed();
		}

		// click on the home icon
		click("questionnaire_homeburgermenubtn_CSS");

		// wait for the element
		explicitWait("propertylist_title_XPATH");

		// verify the property list
		switchVerification("propertylist_title_XPATH", "Property List", "The property list is not displayed.");

		try {
			// wait for the element
			explicitWaitClickable("questionnaire_settingicon_CSS");

			// click on the settings icon from the top of the screen
			click("questionnaire_settingicon_CSS");

			// wait for the element
			explicitWaitClickable("sidemenu_logout_CSS");

			// click on the logout option from the side menu
			click("sidemenu_logout_CSS");

			// VERIFY THE INCIDENT REPORT OPTION IS ACCESS IN JINESH USER OR NOT
			title("VERIFY THE INCIDENT REPORT OPTION IS ACCESS IN JINESH USER OR NOT");

			// LOGIN IN JINESH USER
			title("LOGIN IN JINESH USER");

			helper.loginAndUpdateSystemCompany(data, "username", "password", "system_company_1");

			try {
				// click on the OHS icon from the property list page
				click("ohsicon_CSS");

				// wait for the element
				explicitWaitClickable("menubtn_CSS");

				// click on the burger menu
				click("menubtn_CSS");

				// wait for the element
				Thread.sleep(5000);

				try {

					boolean ss1 = driver
							.findElement(By.xpath(OR.getProperty("questionnaire_option_ohstab_incidentreports_XPATH")))
							.isDisplayed();

					if (ss1 == true) {
						successMessage("The Incident Report Option is display as expected.");

						// click on the cancel button of side menu
						click("propertyproject_closesidemenu_CSS");

					} else {
						verificationFailedMessage("The Incident Report Option is not display.");

						// click on the cancel button of side menu
						click("propertyproject_closesidemenu_CSS");
					}
				} catch (Throwable t) {
					verificationFailedMessage("The Incident Report Option is not display.");

					// click on the cancel button of side menu
					click("propertyproject_closesidemenu_CSS");
				}
			} catch (Throwable t) {
				verificationFailed();
			}

			// click on the home icon from the top of the screen
			click("questionnaire_homeburgermenubtn_hide_CSS");

			// wait for the element
			explicitWait("propertylist_title_XPATH");

			// verify the property list
			switchVerification("propertylist_title_XPATH", "Property List", "The property list is not displayed.");

			// wait for the element
			explicitWaitClickable("questionnaire_settingicon_CSS");

			// click on the settings icon from the top of the screen
			click("questionnaire_settingicon_CSS");

			// wait for the element
			explicitWaitClickable("sidemenu_logout_CSS");

			// click on the logout option from the side menu
			click("sidemenu_logout_CSS");

			// VERIFY THE ADD, EDIT AND DELETE ACCESS IN THE CONTRACTOR ROLE
			title("VERIFY THE ADD, EDIT AND DELETE ACCESS IN THE CONTRACTOR ROLE");

			// LOGIN IN JINESH CONTRACTOR USER
			title("LOGIN IN JINESH CONTRACTOR USER");

			helper.loginAndUpdateSystemCompany(data, "username_2", "password_2", "system_company_1");

			try {
				// click on the OHS icon from the property list page
				click("ohsicon_CSS");

				// wait for the element
				explicitWaitClickable("menubtn_CSS");

				// click on the burger menu
				click("menubtn_CSS");

				// wait for the element
				Thread.sleep(5000);

				try {

					boolean ss2 = driver
							.findElement(By.xpath(OR.getProperty("questionnaire_option_ohstab_incidentreports_XPATH")))
							.isDisplayed();

					if (ss2 == true) {

						successMessage("The Incident Report Option is display as expected.");

						// click on the cancel button of side menu
						click("propertyproject_closesidemenu_CSS");

					} else {
						verificationFailedMessage("The Incident Report Option is not display.");

						// click on the cancel button of side menu
						click("propertyproject_closesidemenu_CSS");
					}

				} catch (Throwable t) {
					verificationFailedMessage("The Incident Report Option is not display.");

					// click on the cancel button of side menu
					click("propertyproject_closesidemenu_CSS");
				}

			} catch (Throwable t) {
				verificationFailed();
			}

			// click on the home icon from the top of the screen
			click("questionnaire_homeburgermenubtn_hide_CSS");

			// wait for the element
			explicitWait("propertylist_title_XPATH");

			// verify the property list
			switchVerification("propertylist_title_XPATH", "Property List", "The property list is not displayed.");

			// wait for the element
			explicitWaitClickable("questionnaire_settingicon_CSS");

			// click on the settings icon from the top of the screen
			click("questionnaire_settingicon_CSS");

			// wait for the element
			explicitWaitClickable("sidemenu_logout_CSS");

			// click on the logout option from the side menu
			click("sidemenu_logout_CSS");

			// VERIFY THE INCIDENT REPORT OPTION ACCESS IN THE JINESH HR
			title("VERIFY THE INCIDENT REPORT OPTION ACCESS IN THE JINESH HR");

			// LOGIN IN JINESH HR USER
			title("LOGIN IN JINESH HR USER");

			helper.loginAndUpdateSystemCompany(data, "username_3", "password_3", "system_company_1");

			try {
				// click on the OHS icon from the property list page
				click("ohsicon_CSS");

				// wait for the element
				explicitWaitClickable("menubtn_CSS");

				// click on the burger menu
				click("menubtn_CSS");

				// wait for the element
				Thread.sleep(5000);

				try {

					boolean ss3 = driver
							.findElement(By.xpath(OR.getProperty("questionnaire_option_ohstab_incidentreports_XPATH")))
							.isDisplayed();

					if (ss3 == true) {
						verificationFailedMessage("The Incident Report Option is display withour access.");

						// click on the cancel button of side menu
						click("propertyproject_closesidemenu_CSS");
					} else {
						successMessage("The Incident Report Option is not display as expected.");

						// click on the cancel button of side menu
						click("propertyproject_closesidemenu_CSS");
					}
				} catch (Throwable t) {
					successMessage("The Incident Report Option is not display as expected.");

					// click on the cancel button of side menu
					click("propertyproject_closesidemenu_CSS");
				}
			} catch (Throwable t) {
				verificationFailed();
			}

			// click on the home icon from the top of the screen
			click("questionnaire_homeburgermenubtn_hide_CSS");

			// wait for the element
			explicitWait("propertylist_title_XPATH");

			// verify the property list
			switchVerification("propertylist_title_XPATH", "Property List", "The property list is not displayed.");

			// wait for the element
			explicitWaitClickable("questionnaire_settingicon_CSS");

			// click on the settings icon from the top of the screen
			click("questionnaire_settingicon_CSS");

			// wait for the element
			explicitWaitClickable("sidemenu_logout_CSS");

			// click on the logout option from the side menu
			click("sidemenu_logout_CSS");

			// RESET THE GIVEN PERMISSIONS
			title("RESET THE GIVEN PERMISSIONS");

			// LOGIN IN AUTOMATION TESTER USER
			title("LOGIN IN AUTOMATION TESTER USER");

			helper.loginAndUpdateSystemCompany(data, "username_1", "password_1", "system_company_1");

		} catch (Throwable t) {
			helper.questionnaireNotDisplayLogout(data);
		}

		// RESET THE APPLIED PERMISSIONS
		title("RESET THE APPLIED PERMISSIONS");

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

			// RESET THE ACCESS TO OHS INCIDENT REPORTS PERMISSION
			helper.resetPermission(data, "ohs_security_setting_2", "ohs_securitysettings2_XPATH");

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
