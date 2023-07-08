package testcases.E2Etestcasesuite.propertyprojectmodule;

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

public class RR4904PropertyProjectFourTest extends TestBase {

	@Test(dataProviderClass = TestUtil.class, dataProvider = "dp")
	public void rR4904PropertyProjectFourTest(Hashtable<String, String> data) throws IOException, InterruptedException {

		execution(data, "rR4904PropertyProjectFourTest");

		// APPLY THE SECURITY SETTING OF THE VIEW CAPEX PROJECTS PERMISSION TO THE
		// ASSIGNED USER/ROLE AND THE RESPECTIVE USER/ROLE MUST HAVE ONLY GRANTED
		// PERMISSION TO PERFORM ACTIONS.
		title("APPLY THE SECURITY SETTING OF THE VIEW CAPEX PROJECTS PERMISSION TO THE ASSIGNED USER/ROLE AND THE RESPECTIVE USER/ROLE MUST HAVE ONLY GRANTED PERMISSION TO PERFORM ACTIONS.");

		Helper helper = new Helper();

		// refresh the page
		driver.navigate().refresh();
		Thread.sleep(5000);
		driver.navigate().refresh();

		// VIEW SECURITY SETTINGS OF VIEW CAPEX PROJECTS TO USER/ROLE ACCESS
		title("VIEW SECURITY SETTINGS OF VIEW CAPEX PROJECTS TO USER/ROLE ACCESS");

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

			// APPLY THE VIEW CAPEX PROJECTS PERMISSION
			helper.addPermissionOneUsersRole(data, "security_setting_5", "propertyproject_securitysettings5_XPATH");

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

			// VERIFY THE VIEW ACCESS IN THE JINESH USER
			title("VERIFY THE VIEW ACCESS IN THE JINESH USER");

			// LOGIN IN JINESH USER
			title("LOGIN IN JINESH USER");

			helper.loginAndUpdateSystemCompany(data, "username", "password", "system_company_1");

			// VERIFY THE JINESH ABLE TO VIEW THE CAPEX PROJECTS DETAILS OR NOT
			title("VERIFY THE JINESH ABLE TO VIEW THE CAPEX PROJECTS DETAILS OR NOT");

			// VIEW CAPEX PROJECTS - JINESH
			title("VIEW CAPEX PROJECTS - JINESH");

			try {

				// click on the property project icon from the property list page
				click("propertyproject_icon_CSS");

				// wait for the element
				explicitWaitClickable("propertyproject_cp_capexprojectsttl1_CSS");

				try {
					boolean title1 = driver
							.findElement(By.cssSelector(OR.getProperty("propertyproject_cp_capexprojectsttl1_CSS")))
							.isDisplayed();

					if (title1 == true) {
						successMessage("The CAPEX Projects title is displayed in the Projects Overview section.");
					} else {
						verificationFailedMessage(
								"The CAPEX Projects title is not displayed in the Projects Overview section.");
					}
				} catch (Throwable t) {
					verificationFailedMessage(
							"The CAPEX Projects title is not displayed in the Projects Overview section.");
				}

				// wait for the element
				explicitWaitClickable("menubtn_CSS");

				// click on the burger menu
				click("menubtn_CSS");

				// wait for the element
				Thread.sleep(5000);

				try {

					boolean title2 = driver
							.findElement(By.xpath(OR.getProperty("propertyproject_capexprojectsoption_XPATH")))
							.isDisplayed();

					if (title2 == true) {
						successMessage("The CAPEX Projects option is displayed in the side menu.");
					} else {
						verificationFailedMessage("The CAPEX Projects option is not displayed in the side menu.");
					}

				} catch (Throwable t) {
					verificationFailedMessage("The CAPEX Projects option is not displayed in the side menu.");
				}

				// click on the close button for close the side menu
				click("propertyproject_closesidemenu_CSS");

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

			// VERIFY THE VIEW ACCESS IN THE JINESH CONTRACTOR
			title("VERIFY THE VIEW ACCESS IN THE JINESH CONTRACTOR");

			// LOGIN IN JINESH CONTRACTOR
			title("LOGIN IN JINESH CONTRACTOR");

			helper.loginAndUpdateSystemCompany(data, "username_2", "password_2", "system_company_1");

			// VERIFY THE JINESH CONTRACTOR ABLE TO VIEW THE CAPEX PROJECTS DETAILS OR NOT
			title("VERIFY THE JINESH CONTRACTOR ABLE TO VIEW THE CAPEX PROJECTS DETAILS OR NOT");

			// VIEW CAPEX PROJECTS - JINESH CONTRACTOR
			title("VIEW CAPEX PROJECTS - JINESH CONTRACTOR");

			try {

				// click on the property project icon from the property list page
				click("propertyproject_icon_CSS");

				// wait for the element
				explicitWaitClickable("propertyproject_cp_capexprojectsttl1_CSS");

				try {
					boolean title3 = driver
							.findElement(By.cssSelector(OR.getProperty("propertyproject_cp_capexprojectsttl1_CSS")))
							.isDisplayed();

					if (title3 == true) {
						successMessage("The CAPEX Projects title is displayed in the Projects Overview section.");
					} else {
						verificationFailedMessage(
								"The CAPEX Projects title is not displayed in the Projects Overview section.");
					}

				} catch (Throwable t) {
					verificationFailedMessage(
							"The CAPEX Projects title is not displayed in the Projects Overview section.");
				}

				// wait for the element
				explicitWaitClickable("menubtn_CSS");

				// click on the burger menu
				click("menubtn_CSS");

				// wait for the element
				Thread.sleep(5000);

				try {
					boolean title4 = driver
							.findElement(By.xpath(OR.getProperty("propertyproject_capexprojectsoption_XPATH")))
							.isDisplayed();

					if (title4 == true) {
						successMessage("The CAPEX Projects option is displayed in the side menu.");
					} else {
						verificationFailedMessage("The CAPEX Projects option is displayed in the side menu.");
					}

				} catch (Throwable t) {
					verificationFailedMessage("The CAPEX Projects option is displayed in the side menu.");
				}

				// click on the close button for close the side menu
				click("propertyproject_closesidemenu_CSS");

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

			// VERIFY THE VIEW ACCESS IN THE JINESH HR
			title("VERIFY THE VIEW ACCESS IN THE JINESH HR");

			// LOGIN IN JINESH HR
			title("LOGIN IN JINESH HR");

			helper.loginAndUpdateSystemCompany(data, "username_3", "password_3", "system_company_1");

			// VERIFY THE JINESH HR ABLE TO VIEW THE CAPEX PROJECTS DETAILS OR NOT
			title("VERIFY THE JINESH HR ABLE TO VIEW THE CAPEX PROJECTS DETAILS OR NOT");

			// VIEW CAPEX PROJECTS - JINESH HR
			title("VIEW CAPEX PROJECTS - JINESH HR");

			try {

				// click on the property project icon from the property list page
				click("propertyproject_icon_CSS");

				// wait for the element
				explicitWaitClickable("propertyproject_cp_capexprojectsttl2_XPATH");

				try {
					boolean title5 = driver
							.findElement(By.cssSelector(OR.getProperty("propertyproject_cp_capexprojectsttl1_CSS")))
							.isDisplayed();

					if (title5 == true) {
						verificationFailedMessage(
								"The CAPEX Projects title is displayed in the Projects Overview section without the view access.");
					} else {
						successMessage(
								"The CAPEX Projects title is not displayed in the Projects Overview section as expected.");
					}

				} catch (Throwable t) {
					successMessage(
							"The CAPEX Projects title is not displayed in the Projects Overview section as expected.");
				}

				// wait for the element
				explicitWaitClickable("menubtn_CSS");

				// click on the burger menu
				click("menubtn_CSS");

				// wait for the element
				Thread.sleep(5000);

				try {
					boolean title6 = driver
							.findElement(By.xpath(OR.getProperty("propertyproject_capexprojectsoption_XPATH")))
							.isDisplayed();

					if (title6 == true) {
						verificationFailedMessage(
								"The CAPEX Projects option is not displayed in the side menu as expected.");
					} else {
						successMessage(
								"The CAPEX Projects option is displayed in the side menu without the view access.");
					}

				} catch (Throwable t) {
					successMessage("The CAPEX Projects option is displayed in the side menu without the view access.");
				}

				// click on the close button for close the side menu
				click("propertyproject_closesidemenu_CSS");

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

			// RESET THE VIEW CAPEX PROJECTS PERMISSION
			helper.resetPermission(data, "security_setting_5", "propertyproject_securitysettings5_XPATH");

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