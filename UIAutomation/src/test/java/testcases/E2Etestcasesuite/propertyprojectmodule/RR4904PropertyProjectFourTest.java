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

		System.out.println(
				"APPLY THE SECURITY SETTING OF THE VIEW CAPEX PROJECTS PERMISSION TO THE ASSIGNED USER/ROLE AND THE RESPECTIVE USER/ROLE MUST HAVE ONLY GRANTED PERMISSION TO PERFORM ACTIONS.");
		test.log(LogStatus.INFO,
				"APPLY THE SECURITY SETTING OF THE VIEW CAPEX PROJECTS PERMISSION TO THE ASSIGNED USER/ROLE AND THE RESPECTIVE USER/ROLE MUST HAVE ONLY GRANTED PERMISSION TO PERFORM ACTIONS.");
		Reporter.log(
				"APPLY THE SECURITY SETTING OF THE VIEW CAPEX PROJECTS PERMISSION TO THE ASSIGNED USER/ROLE AND THE RESPECTIVE USER/ROLE MUST HAVE ONLY GRANTED PERMISSION TO PERFORM ACTIONS.");
		log.info(
				"APPLY THE SECURITY SETTING OF THE VIEW CAPEX PROJECTS PERMISSION TO THE ASSIGNED USER/ROLE AND THE RESPECTIVE USER/ROLE MUST HAVE ONLY GRANTED PERMISSION TO PERFORM ACTIONS.");

		Helper helper = new Helper();
		
		// refresh the page
		driver.navigate().refresh();
		Thread.sleep(5000);
		driver.navigate().refresh();

		System.out.println("Navigate to the Home Screen i.e. Property List Screen.");

		System.out.println(
				"*************** VIEW SECURITY SETTINGS OF VIEW CAPEX PROJECTS TO USER/ROLE ACCESS *************");
		test.log(LogStatus.INFO,
				"*************** VIEW SECURITY SETTINGS OF VIEW CAPEX PROJECTS TO USER/ROLE ACCESS *************");
		Reporter.log("*************** VIEW SECURITY SETTINGS OF VIEW CAPEX PROJECTS TO USER/ROLE ACCESS *************");
		log.info("*************** VIEW SECURITY SETTINGS OF VIEW CAPEX PROJECTS TO USER/ROLE ACCESS *************");

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

			// APPLY THE VIEW CAPEX PROJECTS PERMISSION

			helper.addPermissionOneUsersRole(data, "security_setting_5", "propertyproject_securitysettings5_XPATH");

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

			// VERIFY THE VIEW ACCESS IN THE JINESH USER

			System.out.println("**************** VERIFY THE VIEW ACCESS IN THE JINESH USER ****************");
			test.log(LogStatus.INFO, "**************** VERIFY THE VIEW ACCESS IN THE JINESH USER ****************");
			Reporter.log("**************** VERIFY THE VIEW ACCESS IN THE JINESH USER ****************");
			log.info("**************** VERIFY THE VIEW ACCESS IN THE JINESH USER ****************");

			System.out.println("**************** LOGIN IN JINESH USER ****************");
			test.log(LogStatus.INFO, "**************** LOGIN IN JINESH USER ****************");
			Reporter.log("**************** LOGIN IN JINESH USER ****************");
			log.info("**************** LOGIN IN JINESH USER ****************");

			helper.loginAndUpdateSystemCompany(data, "username", "password", "system_company_1");

			// VERIFY THE JINESH ABLE TO VIEW THE CAPEX PROJECTS DETAILS OR NOT

			System.out.println("**************** VIEW CAPEX PROJECTS - JINESH ****************");
			test.log(LogStatus.INFO, "**************** VIEW CAPEX PROJECTS - JINESH ****************");
			Reporter.log("**************** VIEW CAPEX PROJECTS - JINESH ****************");
			log.info("**************** VIEW CAPEX PROJECTS - JINESH ****************");

			try {

				// click on the property project icon from the property list page
				click("propertyproject_icon_CSS");
				System.out.println("Clicked on the property project icon of the Property.");
				ngDriver.waitForAngularRequestsToFinish();
				System.out.println("Navigate to the property project screen of the perticular property.");

				// wait for the element
				explicitWaitClickable("propertyproject_cp_capexprojectsttl1_CSS");

				try {
					boolean title1 = driver
							.findElement(By.cssSelector(OR.getProperty("propertyproject_cp_capexprojectsttl1_CSS")))
							.isDisplayed();

					if (title1 == true) {
						System.out.println("The CAPEX Projects title is displayed in the Projects Overview section.");
						test.log(LogStatus.INFO,
								"The CAPEX Projects title is displayed in the Projects Overview section.");
						Reporter.log("The CAPEX Projects title is displayed in the Projects Overview section.");
						log.info("The CAPEX Projects title is displayed in the Projects Overview section.");
					} else {
						TestUtil.captureScreenshot();

						// ReportNG
						Reporter.log(
								"<br>" + "The CAPEX Projects title is not displayed in the Projects Overview section.: "
										+ "<br>");
						Reporter.log("<a target=\"_blank\" href=" + TestUtil.screenshotName + "><img src="
								+ TestUtil.screenshotName + " height=200 width=200></img></a>");
						Reporter.log("<br>");
						Reporter.log("<br>");

						// Extent Report
						test.log(LogStatus.FAIL,
								" The CAPEX Projects title is not displayed in the Projects Overview section. : ");
						test.log(LogStatus.FAIL, test.addScreenCapture(TestUtil.screenshotName));

						System.out
								.println("The CAPEX Projects title is not displayed in the Projects Overview section.");
						log.info("The CAPEX Projects title is not displayed in the Projects Overview section.");

					}

				} catch (Throwable t) {
					TestUtil.captureScreenshot();

					// ReportNG
					Reporter.log("<br>"
							+ "The CAPEX Projects title is not displayed in the Projects Overview section.: " + "<br>");
					Reporter.log("<a target=\"_blank\" href=" + TestUtil.screenshotName + "><img src="
							+ TestUtil.screenshotName + " height=200 width=200></img></a>");
					Reporter.log("<br>");
					Reporter.log("<br>");

					// Extent Report
					test.log(LogStatus.FAIL,
							" The CAPEX Projects title is not displayed in the Projects Overview section. : ");
					test.log(LogStatus.FAIL, test.addScreenCapture(TestUtil.screenshotName));

					System.out.println("The CAPEX Projects title is not displayed in the Projects Overview section.");
					log.info("The CAPEX Projects title is not displayed in the Projects Overview section.");

				}

				// wait for the element
				explicitWaitClickable("menubtn_CSS");

				// click on the burger menu
				click("menubtn_CSS");
				System.out.println("Clicked on the burger menu button successfully!!!");
				ngDriver.waitForAngularRequestsToFinish();

				// wait for the element
				Thread.sleep(5000);

				try {

					boolean title2 = driver
							.findElement(By.xpath(OR.getProperty("propertyproject_capexprojectsoption_XPATH")))
							.isDisplayed();

					if (title2 == true) {
						System.out.println("The CAPEX Projects option is displayed in the side menu.");
						test.log(LogStatus.INFO, "The CAPEX Projects option is displayed in the side menu.");
						Reporter.log("The CAPEX Projects option is displayed in the side menu.");
						log.info("The CAPEX Projects option is displayed in the side menu.");
					} else {
						TestUtil.captureScreenshot();

						// ReportNG
						Reporter.log(
								"<br>" + "The CAPEX Projects option is not displayed in the side menu.: " + "<br>");
						Reporter.log("<a target=\"_blank\" href=" + TestUtil.screenshotName + "><img src="
								+ TestUtil.screenshotName + " height=200 width=200></img></a>");
						Reporter.log("<br>");
						Reporter.log("<br>");

						// Extent Report
						test.log(LogStatus.FAIL, " The CAPEX Projects option is not displayed in the side menu. : ");
						test.log(LogStatus.FAIL, test.addScreenCapture(TestUtil.screenshotName));

						System.out.println("The CAPEX Projects option is not displayed in the side menu.");
						log.info("The CAPEX Projects option is not displayed in the side menu.");

					}

				} catch (Throwable t) {
					TestUtil.captureScreenshot();

					// ReportNG
					Reporter.log("<br>" + "The CAPEX Projects option is not displayed in the side menu.: " + "<br>");
					Reporter.log("<a target=\"_blank\" href=" + TestUtil.screenshotName + "><img src="
							+ TestUtil.screenshotName + " height=200 width=200></img></a>");
					Reporter.log("<br>");
					Reporter.log("<br>");

					// Extent Report
					test.log(LogStatus.FAIL, " The CAPEX Projects option is not displayed in the side menu. : ");
					test.log(LogStatus.FAIL, test.addScreenCapture(TestUtil.screenshotName));

					System.out.println("The CAPEX Projects option is not displayed in the side menu.");
					log.info("The CAPEX Projects option is not displayed in the side menu.");

				}

				// click on the close button for close the side menu
				click("propertyproject_closesidemenu_CSS");
				ngDriver.waitForAngularRequestsToFinish();
				System.out.println("Clicked on the close button for close the side menu.");

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

			// VERIFY THE VIEW ACCESS IN THE JINESH CONTRACTOR

			System.out.println("**************** VERIFY THE VIEW ACCESS IN THE JINESH CONTRACTOR ****************");
			test.log(LogStatus.INFO,
					"**************** VERIFY THE VIEW ACCESS IN THE JINESH CONTRACTOR ****************");
			Reporter.log("**************** VERIFY THE VIEW ACCESS IN THE JINESH CONTRACTOR ****************");
			log.info("**************** VERIFY THE VIEW ACCESS IN THE JINESH CONTRACTOR ****************");

			System.out.println("**************** LOGIN IN JINESH CONTRACTOR ****************");
			test.log(LogStatus.INFO, "**************** LOGIN IN JINESH CONTRACTOR ****************");
			Reporter.log("**************** LOGIN IN JINESH CONTRACTOR ****************");
			log.info("**************** LOGIN IN JINESH CONTRACTOR ****************");

			helper.loginAndUpdateSystemCompany(data, "username_2", "password_2", "system_company_1");

			// VERIFY THE JINESH CONTRACTOR ABLE TO VIEW THE CAPEX PROJECTS DETAILS OR
			// NOT

			System.out.println("**************** VIEW CAPEX PROJECTS - JINESH CONTRACTOR ****************");
			test.log(LogStatus.INFO, "**************** VIEW CAPEX PROJECTS - JINESH CONTRACTOR ****************");
			Reporter.log("**************** VIEW CAPEX PROJECTS - JINESH CONTRACTOR ****************");
			log.info("**************** VIEW CAPEX PROJECTS - JINESH CONTRACTOR ****************");

			try {

				// click on the property project icon from the property list page
				click("propertyproject_icon_CSS");
				System.out.println("Clicked on the property project icon of the Property.");
				ngDriver.waitForAngularRequestsToFinish();
				System.out.println("Navigate to the property project screen of the perticular property.");

				// wait for the element
				explicitWaitClickable("propertyproject_cp_capexprojectsttl1_CSS");

				try {
					boolean title3 = driver
							.findElement(By.cssSelector(OR.getProperty("propertyproject_cp_capexprojectsttl1_CSS")))
							.isDisplayed();

					if (title3 == true) {
						System.out.println("The CAPEX Projects title is displayed in the Projects Overview section.");
						test.log(LogStatus.INFO,
								"The CAPEX Projects title is displayed in the Projects Overview section.");
						Reporter.log("The CAPEX Projects title is displayed in the Projects Overview section.");
						log.info("The CAPEX Projects title is displayed in the Projects Overview section.");
					} else {
						TestUtil.captureScreenshot();

						// ReportNG
						Reporter.log(
								"<br>" + "The CAPEX Projects title is not displayed in the Projects Overview section.: "
										+ "<br>");
						Reporter.log("<a target=\"_blank\" href=" + TestUtil.screenshotName + "><img src="
								+ TestUtil.screenshotName + " height=200 width=200></img></a>");
						Reporter.log("<br>");
						Reporter.log("<br>");

						// Extent Report
						test.log(LogStatus.FAIL,
								" The CAPEX Projects title is not displayed in the Projects Overview section. : ");
						test.log(LogStatus.FAIL, test.addScreenCapture(TestUtil.screenshotName));

						System.out
								.println("The CAPEX Projects title is not displayed in the Projects Overview section.");
						log.info("The CAPEX Projects title is not displayed in the Projects Overview section.");

					}

				} catch (Throwable t) {
					TestUtil.captureScreenshot();

					// ReportNG
					Reporter.log("<br>"
							+ "The CAPEX Projects title is not displayed in the Projects Overview section.: " + "<br>");
					Reporter.log("<a target=\"_blank\" href=" + TestUtil.screenshotName + "><img src="
							+ TestUtil.screenshotName + " height=200 width=200></img></a>");
					Reporter.log("<br>");
					Reporter.log("<br>");

					// Extent Report
					test.log(LogStatus.FAIL,
							" The CAPEX Projects title is not displayed in the Projects Overview section. : ");
					test.log(LogStatus.FAIL, test.addScreenCapture(TestUtil.screenshotName));

					System.out.println("The CAPEX Projects title is not displayed in the Projects Overview section.");
					log.info("The CAPEX Projects title is not displayed in the Projects Overview section.");

				}

				// wait for the element
				explicitWaitClickable("menubtn_CSS");

				// click on the burger menu
				click("menubtn_CSS");
				System.out.println("Clicked on the burger menu button successfully!!!");
				ngDriver.waitForAngularRequestsToFinish();

				// wait for the element
				Thread.sleep(5000);

				try {
					boolean title4 = driver
							.findElement(By.xpath(OR.getProperty("propertyproject_capexprojectsoption_XPATH")))
							.isDisplayed();

					if (title4 == true) {
						System.out.println("The CAPEX Projects option is displayed in the side menu.");
						test.log(LogStatus.INFO, "The CAPEX Projects option is displayed in the side menu.");
						Reporter.log("The CAPEX Projects option is displayed in the side menu.");
						log.info("The CAPEX Projects option is displayed in the side menu.");
					} else {
						TestUtil.captureScreenshot();

						// ReportNG
						Reporter.log("<br>" + "The CAPEX Projects option is displayed in the side menu.: " + "<br>");
						Reporter.log("<a target=\"_blank\" href=" + TestUtil.screenshotName + "><img src="
								+ TestUtil.screenshotName + " height=200 width=200></img></a>");
						Reporter.log("<br>");
						Reporter.log("<br>");

						// Extent Report
						test.log(LogStatus.FAIL, " The CAPEX Projects option is displayed in the side menu. : ");
						test.log(LogStatus.FAIL, test.addScreenCapture(TestUtil.screenshotName));

						System.out.println("The CAPEX Projects option is displayed in the side menu.");
						log.info("The CAPEX Projects option is displayed in the side menu.");

					}

				} catch (Throwable t) {
					TestUtil.captureScreenshot();

					// ReportNG
					Reporter.log("<br>" + "The CAPEX Projects option is displayed in the side menu.: " + "<br>");
					Reporter.log("<a target=\"_blank\" href=" + TestUtil.screenshotName + "><img src="
							+ TestUtil.screenshotName + " height=200 width=200></img></a>");
					Reporter.log("<br>");
					Reporter.log("<br>");

					// Extent Report
					test.log(LogStatus.FAIL, " The CAPEX Projects option is displayed in the side menu. : ");
					test.log(LogStatus.FAIL, test.addScreenCapture(TestUtil.screenshotName));

					System.out.println("The CAPEX Projects option is displayed in the side menu.");
					log.info("The CAPEX Projects option is displayed in the side menu.");

				}

				// click on the close button for close the side menu
				click("propertyproject_closesidemenu_CSS");
				ngDriver.waitForAngularRequestsToFinish();
				System.out.println("Clicked on the close button for close the side menu.");

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

			// VERIFY THE VIEW ACCESS IN THE JINESH HR

			System.out.println("**************** VERIFY THE VIEW ACCESS IN THE JINESH HR ****************");
			test.log(LogStatus.INFO, "**************** VERIFY THE VIEW ACCESS IN THE JINESH HR ****************");
			Reporter.log("**************** VERIFY THE VIEW ACCESS IN THE JINESH HR ****************");
			log.info("**************** VERIFY THE VIEW ACCESS IN THE JINESH HR ****************");

			System.out.println("**************** LOGIN IN JINESH HR ****************");
			test.log(LogStatus.INFO, "**************** LOGIN IN JINESH HR ****************");
			Reporter.log("**************** LOGIN IN JINESH HR ****************");
			log.info("**************** LOGIN IN JINESH HR ****************");

			helper.loginAndUpdateSystemCompany(data, "username_3", "password_3", "system_company_1");

			// VERIFY THE JINESH HR ABLE TO VIEW THE CAPEX PROJECTS DETAILS OR
			// NOT

			System.out.println("**************** VIEW CAPEX PROJECTS - JINESH HR ****************");
			test.log(LogStatus.INFO, "**************** VIEW CAPEX PROJECTS - JINESH HR ****************");
			Reporter.log("**************** VIEW CAPEX PROJECTS - JINESH HR ****************");
			log.info("**************** VIEW CAPEX PROJECTS - JINESH HR ****************");

			try {

				// click on the property project icon from the property list page
				click("propertyproject_icon_CSS");
				System.out.println("Clicked on the property project icon of the Property.");
				ngDriver.waitForAngularRequestsToFinish();
				System.out.println("Navigate to the property project screen of the perticular property.");

				// wait for the element
				explicitWaitClickable("propertyproject_cp_capexprojectsttl2_XPATH");

				try {
					boolean title5 = driver
							.findElement(By.cssSelector(OR.getProperty("propertyproject_cp_capexprojectsttl1_CSS")))
							.isDisplayed();

					if (title5 == true) {

						TestUtil.captureScreenshot();

						// ReportNG
						Reporter.log("<br>"
								+ "The CAPEX Projects title is displayed in the Projects Overview section without the view access.: "
								+ "<br>");
						Reporter.log("<a target=\"_blank\" href=" + TestUtil.screenshotName + "><img src="
								+ TestUtil.screenshotName + " height=200 width=200></img></a>");
						Reporter.log("<br>");
						Reporter.log("<br>");

						// Extent Report
						test.log(LogStatus.FAIL,
								" The CAPEX Projects title is displayed in the Projects Overview section without the view access. : ");
						test.log(LogStatus.FAIL, test.addScreenCapture(TestUtil.screenshotName));

						System.out.println(
								"The CAPEX Projects title is displayed in the Projects Overview section without the view access.");
						log.info(
								"The CAPEX Projects title is displayed in the Projects Overview section without the view access.");

					} else {

						System.out.println(
								"The CAPEX Projects title is not displayed in the Projects Overview section as expected.");
						test.log(LogStatus.INFO,
								"The CAPEX Projects title is not displayed in the Projects Overview section as expected.");
						Reporter.log(
								"The CAPEX Projects title is not displayed in the Projects Overview section as expected.");
						log.info(
								"The CAPEX Projects title is not displayed in the Projects Overview section as expected.");

					}

				} catch (Throwable t) {
					System.out.println(
							"The CAPEX Projects title is not displayed in the Projects Overview section as expected.");
					test.log(LogStatus.INFO,
							"The CAPEX Projects title is not displayed in the Projects Overview section as expected.");
					Reporter.log(
							"The CAPEX Projects title is not displayed in the Projects Overview section as expected.");
					log.info("The CAPEX Projects title is not displayed in the Projects Overview section as expected.");
				}

				// wait for the element
				explicitWaitClickable("menubtn_CSS");

				// click on the burger menu
				click("menubtn_CSS");
				System.out.println("Clicked on the burger menu button successfully!!!");
				ngDriver.waitForAngularRequestsToFinish();

				// wait for the element
				Thread.sleep(5000);

				try {
					boolean title6 = driver
							.findElement(By.xpath(OR.getProperty("propertyproject_capexprojectsoption_XPATH")))
							.isDisplayed();

					if (title6 == true) {

						TestUtil.captureScreenshot();

						// ReportNG
						Reporter.log(
								"<br>" + "The CAPEX Projects option is not displayed in the side menu as expected.: "
										+ "<br>");
						Reporter.log("<a target=\"_blank\" href=" + TestUtil.screenshotName + "><img src="
								+ TestUtil.screenshotName + " height=200 width=200></img></a>");
						Reporter.log("<br>");
						Reporter.log("<br>");

						// Extent Report
						test.log(LogStatus.FAIL,
								" The CAPEX Projects option is not displayed in the side menu as expected. : ");
						test.log(LogStatus.FAIL, test.addScreenCapture(TestUtil.screenshotName));

						System.out.println("The CAPEX Projects option is not displayed in the side menu as expected.");
						log.info("The CAPEX Projects option is not displayed in the side menu as expected.");

					} else {

						System.out.println(
								"The CAPEX Projects option is displayed in the side menu without the view access.");
						test.log(LogStatus.INFO,
								"The CAPEX Projects option is displayed in the side menu without the view access.");
						Reporter.log(
								"The CAPEX Projects option is displayed in the side menu without the view access.");
						log.info("The CAPEX Projects option is displayed in the side menu without the view access.");

					}

				} catch (Throwable t) {
					System.out.println(
							"The CAPEX Projects option is displayed in the side menu without the view access.");
					test.log(LogStatus.INFO,
							"The CAPEX Projects option is displayed in the side menu without the view access.");
					Reporter.log("The CAPEX Projects option is displayed in the side menu without the view access.");
					log.info("The CAPEX Projects option is displayed in the side menu without the view access.");

				}

				// click on the close button for close the side menu
				click("propertyproject_closesidemenu_CSS");
				ngDriver.waitForAngularRequestsToFinish();
				System.out.println("Clicked on the close button for close the side menu.");

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

			System.out.println("**************** LOGIN IN AUTOMATION TESTER USER ****************");
			test.log(LogStatus.INFO, "**************** LOGIN IN AUTOMATION TESTER USER ****************");
			Reporter.log("**************** LOGIN IN AUTOMATION TESTER USER ****************");
			log.info("**************** LOGIN IN AUTOMATION TESTER USER ****************");

			helper.loginAndUpdateSystemCompany(data, "username_1", "password_1", "system_company_1");

		} catch (Throwable t) {
			helper.questionnaireNotDisplayLogout(data);
		}

		// RESET THE APPLIED PERMISSIONS

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

			// RESET THE VIEW CAPEX PROJECTS PERMISSION

			helper.resetPermission(data, "security_setting_5", "propertyproject_securitysettings5_XPATH");

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