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

		System.out.println(
				"SECURITY SETTING CONTROLS TO MAKE SURE THE ACCESS TO OHS INCIDENT REPORTS CAN BE ONLY PERFORMED BY THE USER/ROLE WITH ACCESS TO IT.");
		test.log(LogStatus.INFO,
				"SECURITY SETTING CONTROLS TO MAKE SURE THE ACCESS TO OHS INCIDENT REPORTS CAN BE ONLY PERFORMED BY THE USER/ROLE WITH ACCESS TO IT.");
		Reporter.log(
				"SECURITY SETTING CONTROLS TO MAKE SURE THE ACCESS TO OHS INCIDENT REPORTS CAN BE ONLY PERFORMED BY THE USER/ROLE WITH ACCESS TO IT.");
		log.info(
				"SECURITY SETTING CONTROLS TO MAKE SURE THE ACCESS TO OHS INCIDENT REPORTS CAN BE ONLY PERFORMED BY THE USER/ROLE WITH ACCESS TO IT.");

		Helper helper = new Helper();

		// refresh the page
		driver.navigate().refresh();
		Thread.sleep(5000);
		driver.navigate().refresh();

		System.out.println("Navigate to the Home Screen i.e. Property List Screen.");

		// APPLY THE ACCESS TO OHS INCIDENT REPORTS PERMISSION

		System.out.println("********** APPLY THE ACCESS TO OHS INCIDENT REPORTS PERMISSION **********");
		test.log(LogStatus.INFO, "********** APPLY THE ACCESS TO OHS INCIDENT REPORTS PERMISSION **********");
		Reporter.log("********** APPLY THE ACCESS TO OHS INCIDENT REPORTS PERMISSION **********");
		log.info("********** APPLY THE ACCESS TO OHS INCIDENT REPORTS PERMISSION **********");

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

			// APPLY THE ACCESS TO OHS INCIDENT REPORTS
			helper.addPermissionOneUsersRole(data, "ohs_security_setting_2", "ohs_securitysettings2_XPATH");

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

			// VERIFY THE INCIDENT REPORT OPTION IS ACCESS IN JINESH USER OR NOT

			System.out.println(
					"**************** VERIFY THE INCIDENT REPORT OPTION IS ACCESS IN JINESH USER OR NOT ****************");
			test.log(LogStatus.INFO,
					"**************** VERIFY THE INCIDENT REPORT OPTION IS ACCESS IN JINESH USER OR NOT ****************");
			Reporter.log(
					"**************** VERIFY THE INCIDENT REPORT OPTION IS ACCESS IN JINESH USER OR NOT ****************");
			log.info(
					"**************** VERIFY THE INCIDENT REPORT OPTION IS ACCESS IN JINESH USER OR NOT ****************");

			System.out.println("**************** LOGIN IN JINESH USER ****************");
			test.log(LogStatus.INFO, "**************** LOGIN IN JINESH USER ****************");
			Reporter.log("**************** LOGIN IN JINESH USER ****************");
			log.info("**************** LOGIN IN JINESH USER ****************");

			helper.loginAndUpdateSystemCompany(data, "username", "password", "system_company_1");

			try {
				// click on the OHS icon from the property list page
				click("ohsicon_CSS");
				System.out.println("Clicked on the OHS icon of the Property.");
				ngDriver.waitForAngularRequestsToFinish();
				System.out.println("Navigate to the OHS screen of the perticular property.");

				// wait for the element
				explicitWaitClickable("menubtn_CSS");

				// click on the burger menu
				click("menubtn_CSS");
				System.out.println("Clicked on the burger menu button successfully!!!");
				ngDriver.waitForAngularRequestsToFinish();

				// wait for the element
				Thread.sleep(5000);

				try {

					boolean ss1 = driver
							.findElement(By.xpath(OR.getProperty("questionnaire_option_ohstab_incidentreports_XPATH")))
							.isDisplayed();

					if (ss1 == true) {

						System.out.println("The Incident Report Option is display as expected.");
						test.log(LogStatus.INFO, "The Incident Report Option is display as expected.");
						Reporter.log("The Incident Report Option is display as expected.");
						log.info("The Incident Report Option is display as expected.");

						// click on the cancel button of side menu
						click("propertyproject_closesidemenu_CSS");
						ngDriver.waitForAngularRequestsToFinish();
						System.out.println("Clicked on the cancel button of side menu.");

					} else {
						TestUtil.captureScreenshot();

						// ReportNG
						Reporter.log("<br>" + " The Incident Report Option is not display. : " + "<br>");
						Reporter.log("<a target=\"_blank\" href=" + TestUtil.screenshotName + "><img src="
								+ TestUtil.screenshotName + " height=200 width=200></img></a>");
						Reporter.log("<br>");
						Reporter.log("<br>");

						// Extent Report
						test.log(LogStatus.FAIL, " The Incident Report Option is not display. : ");
						test.log(LogStatus.FAIL, test.addScreenCapture(TestUtil.screenshotName));

						System.out.println("The Incident Report Option is not display.");
						log.info("The Incident Report Option is not display.");

						// click on the cancel button of side menu
						click("propertyproject_closesidemenu_CSS");
						ngDriver.waitForAngularRequestsToFinish();
						System.out.println("Clicked on the cancel button of side menu.");

					}

				} catch (Throwable t) {
					TestUtil.captureScreenshot();

					// ReportNG
					Reporter.log("<br>" + " The Incident Report Option is not display. : " + "<br>");
					Reporter.log("<a target=\"_blank\" href=" + TestUtil.screenshotName + "><img src="
							+ TestUtil.screenshotName + " height=200 width=200></img></a>");
					Reporter.log("<br>");
					Reporter.log("<br>");

					// Extent Report
					test.log(LogStatus.FAIL, " The Incident Report Option is not display. : ");
					test.log(LogStatus.FAIL, test.addScreenCapture(TestUtil.screenshotName));

					System.out.println("The Incident Report Option is not display.");
					log.info("The Incident Report Option is not display.");

					// click on the cancel button of side menu
					click("propertyproject_closesidemenu_CSS");
					ngDriver.waitForAngularRequestsToFinish();
					System.out.println("Clicked on the cancel button of side menu.");

				}

			} catch (Throwable t) {

				verificationFailed();
			}

			// click on the home icon from the top of the screen
			click("questionnaire_homeburgermenubtn_hide_CSS");
			System.out.println("Clicked on the home icon from the top of the screen.");
			ngDriver.waitForAngularRequestsToFinish();

			// wait for the element
			explicitWait("propertylist_title_XPATH");

			// verify the property list
			switchVerification("propertylist_title_XPATH", "Property List", "The property list is not displayed.");

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

			// VERIFY THE ADD, EDIT AND DELETE ACCESS IN THE CONTRACTOR ROLE

			System.out.println(
					"**************** VERIFY THE INCIDENT REPORT OPTION IS ACCESS IN THE CONTRACTOR ROLE ****************");
			test.log(LogStatus.INFO,
					"**************** VERIFY THE INCIDENT REPORT OPTION IS ACCESS IN THE CONTRACTOR ROLE ****************");
			Reporter.log(
					"**************** VERIFY THE INCIDENT REPORT OPTION IS ACCESS IN THE CONTRACTOR ROLE ****************");
			log.info(
					"**************** VERIFY THE INCIDENT REPORT OPTION ACCESS IN THE CONTRACTOR ROLE ****************");

			System.out.println("**************** LOGIN IN JINESH CONTRACTOR USER ****************");
			test.log(LogStatus.INFO, "**************** LOGIN IN JINESH CONTRACTOR USER ****************");
			Reporter.log("**************** LOGIN IN JINESH CONTRACTOR USER ****************");
			log.info("**************** LOGIN IN JINESH CONTRACTOR USER ****************");

			helper.loginAndUpdateSystemCompany(data, "username_2", "password_2", "system_company_1");

			try {
				// click on the OHS icon from the property list page
				click("ohsicon_CSS");
				System.out.println("Clicked on the OHS icon of the Property.");
				ngDriver.waitForAngularRequestsToFinish();
				System.out.println("Navigate to the OHS screen of the perticular property.");

				// wait for the element
				explicitWaitClickable("menubtn_CSS");

				// click on the burger menu
				click("menubtn_CSS");
				System.out.println("Clicked on the burger menu button successfully!!!");
				ngDriver.waitForAngularRequestsToFinish();

				// wait for the element
				Thread.sleep(5000);

				try {

					boolean ss2 = driver
							.findElement(By.xpath(OR.getProperty("questionnaire_option_ohstab_incidentreports_XPATH")))
							.isDisplayed();

					if (ss2 == true) {

						System.out.println("The Incident Report Option is display as expected.");
						test.log(LogStatus.INFO, "The Incident Report Option is display as expected.");
						Reporter.log("The Incident Report Option is display as expected.");
						log.info("The Incident Report Option is display as expected.");

						// click on the cancel button of side menu
						click("propertyproject_closesidemenu_CSS");
						ngDriver.waitForAngularRequestsToFinish();
						System.out.println("Clicked on the cancel button of side menu.");

					} else {
						TestUtil.captureScreenshot();

						// ReportNG
						Reporter.log("<br>" + " The Incident Report Option is not display. : " + "<br>");
						Reporter.log("<a target=\"_blank\" href=" + TestUtil.screenshotName + "><img src="
								+ TestUtil.screenshotName + " height=200 width=200></img></a>");
						Reporter.log("<br>");
						Reporter.log("<br>");

						// Extent Report
						test.log(LogStatus.FAIL, " The Incident Report Option is not display. : ");
						test.log(LogStatus.FAIL, test.addScreenCapture(TestUtil.screenshotName));

						System.out.println("The Incident Report Option is not display.");
						log.info("The Incident Report Option is not display.");

						// click on the cancel button of side menu
						click("propertyproject_closesidemenu_CSS");
						ngDriver.waitForAngularRequestsToFinish();
						System.out.println("Clicked on the cancel button of side menu.");

					}

				} catch (Throwable t) {
					TestUtil.captureScreenshot();

					// ReportNG
					Reporter.log("<br>" + " The Incident Report Option is not display. : " + "<br>");
					Reporter.log("<a target=\"_blank\" href=" + TestUtil.screenshotName + "><img src="
							+ TestUtil.screenshotName + " height=200 width=200></img></a>");
					Reporter.log("<br>");
					Reporter.log("<br>");

					// Extent Report
					test.log(LogStatus.FAIL, " The Incident Report Option is not display. : ");
					test.log(LogStatus.FAIL, test.addScreenCapture(TestUtil.screenshotName));

					System.out.println("The Incident Report Option is not display.");
					log.info("The Incident Report Option is not display.");

					// click on the cancel button of side menu
					click("propertyproject_closesidemenu_CSS");
					ngDriver.waitForAngularRequestsToFinish();
					System.out.println("Clicked on the cancel button of side menu.");

				}
			} catch (Throwable t) {

				verificationFailed();
			}

			// click on the home icon from the top of the screen
			click("questionnaire_homeburgermenubtn_hide_CSS");
			System.out.println("Clicked on the home icon from the top of the screen.");
			ngDriver.waitForAngularRequestsToFinish();

			// wait for the element
			explicitWait("propertylist_title_XPATH");

			// verify the property list
			switchVerification("propertylist_title_XPATH", "Property List", "The property list is not displayed.");

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

			// VERIFY THE INCIDENT REPORT OPTION ACCESS IN THE CONTRACTOR ROLE

			System.out.println(
					"**************** VERIFY THE INCIDENT REPORT OPTION ACCESS IN THE JINESH HR ****************");
			test.log(LogStatus.INFO,
					"**************** VERIFY THE INCIDENT REPORT OPTION ACCESS IN THE JINESH HR ****************");
			Reporter.log("**************** VERIFY THE INCIDENT REPORT OPTION ACCESS IN THE JINESH HR ****************");
			log.info("**************** VERIFY THE INCIDENT REPORT OPTION ACCESS IN THE JINESH HR ****************");

			System.out.println("**************** LOGIN IN JINESH HR USER ****************");
			test.log(LogStatus.INFO, "**************** LOGIN IN JINESH HR USER ****************");
			Reporter.log("**************** LOGIN IN JINESH HR USER ****************");
			log.info("**************** LOGIN IN JINESH HR USER ****************");

			helper.loginAndUpdateSystemCompany(data, "username_3", "password_3", "system_company_1");

			try {
				// click on the OHS icon from the property list page
				click("ohsicon_CSS");
				System.out.println("Clicked on the OHS icon of the Property.");
				ngDriver.waitForAngularRequestsToFinish();
				System.out.println("Navigate to the OHS screen of the perticular property.");

				// wait for the element
				explicitWaitClickable("menubtn_CSS");

				// click on the burger menu
				click("menubtn_CSS");
				System.out.println("Clicked on the burger menu button successfully!!!");
				ngDriver.waitForAngularRequestsToFinish();

				// wait for the element
				Thread.sleep(5000);

				try {

					boolean ss3 = driver
							.findElement(By.xpath(OR.getProperty("questionnaire_option_ohstab_incidentreports_XPATH")))
							.isDisplayed();

					if (ss3 == true) {

						TestUtil.captureScreenshot();

						// ReportNG
						Reporter.log("<br>" + " The Incident Report Option is display withour access. : " + "<br>");
						Reporter.log("<a target=\"_blank\" href=" + TestUtil.screenshotName + "><img src="
								+ TestUtil.screenshotName + " height=200 width=200></img></a>");
						Reporter.log("<br>");
						Reporter.log("<br>");

						// Extent Report
						test.log(LogStatus.FAIL, " The Incident Report Option is display withour access. : ");
						test.log(LogStatus.FAIL, test.addScreenCapture(TestUtil.screenshotName));

						System.out.println("The Incident Report Option is display withour access.");
						log.info("The Incident Report Option is display withour access.");

						// click on the cancel button of side menu
						click("propertyproject_closesidemenu_CSS");
						ngDriver.waitForAngularRequestsToFinish();
						System.out.println("Clicked on the cancel button of side menu.");

					} else {
						System.out.println("The Incident Report Option is not display as expected.");
						test.log(LogStatus.INFO, "The Incident Report Option is not display as expected.");
						Reporter.log("The Incident Report Option is not display as expected.");
						log.info("The Incident Report Option is not display as expected.");

						// click on the cancel button of side menu
						click("propertyproject_closesidemenu_CSS");
						ngDriver.waitForAngularRequestsToFinish();
						System.out.println("Clicked on the cancel button of side menu.");

					}

				} catch (Throwable t) {
					System.out.println("The Incident Report Option is not display as expected.");
					test.log(LogStatus.INFO, "The Incident Report Option is not display as expected.");
					Reporter.log("The Incident Report Option is not display as expected.");
					log.info("The Incident Report Option is not display as expected.");

					// click on the cancel button of side menu
					click("propertyproject_closesidemenu_CSS");
					ngDriver.waitForAngularRequestsToFinish();
					System.out.println("Clicked on the cancel button of side menu.");

				}

			} catch (Throwable t) {

				verificationFailed();
			}

			// click on the home icon from the top of the screen
			click("questionnaire_homeburgermenubtn_hide_CSS");
			System.out.println("Clicked on the home icon from the top of the screen.");
			ngDriver.waitForAngularRequestsToFinish();

			// wait for the element
			explicitWait("propertylist_title_XPATH");

			// verify the property list
			switchVerification("propertylist_title_XPATH", "Property List", "The property list is not displayed.");

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

			// RESET THE GIVEN PERMISSIONS

			System.out.println("**************** RESET THE GIVEN PERMISSIONS ****************");
			test.log(LogStatus.INFO, "**************** RESET THE GIVEN PERMISSIONS ****************");
			Reporter.log("**************** RESET THE GIVEN PERMISSIONS ****************");
			log.info("**************** RESET THE GIVEN PERMISSIONS ****************");

			System.out.println("**************** LOGIN IN AUTOMATION TESTER USER ****************");
			test.log(LogStatus.INFO, "**************** LOGIN IN AUTOMATION TESTER USER ****************");
			Reporter.log("**************** LOGIN IN AUTOMATION TESTER USER ****************");
			log.info("**************** LOGIN IN AUTOMATION TESTER USER ****************");

			helper.loginAndUpdateSystemCompany(data, "username_1", "password_1", "system_company_1");

		} catch (Throwable t) {

			helper.questionnaireNotDisplayLogout(data);
		}

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

			// RESET THE ACCESS TO OHS INCIDENT REPORTS PERMISSION
			helper.resetPermission(data, "ohs_security_setting_2", "ohs_securitysettings2_XPATH");

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
