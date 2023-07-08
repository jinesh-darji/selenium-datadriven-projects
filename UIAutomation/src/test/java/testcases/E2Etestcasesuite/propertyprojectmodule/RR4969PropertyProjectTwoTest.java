package testcases.E2Etestcasesuite.propertyprojectmodule;

import java.io.IOException;
import java.util.Hashtable;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.testng.Reporter;
import org.testng.SkipException;
import org.testng.annotations.Test;

import com.relevantcodes.extentreports.LogStatus;

import base.Helper;
import base.TestBase;
import utilities.TestUtil;

public class RR4969PropertyProjectTwoTest extends TestBase {

	@Test(dataProviderClass = TestUtil.class, dataProvider = "dp")
	public void rR4969PropertyProjectTwoTest(Hashtable<String, String> data) throws IOException, InterruptedException {

		execution(data, "rR4969PropertyProjectTwoTest");

		// APPLY THE "ACCESS TO VIEW RESTRICTED COMMENTS" SECURITY SETTINGS TO THE
		// COMMENTS FOR THE MORTGAGE UNDERTAKING.

		System.out.println(
				"APPLY THE \"ACCESS TO VIEW RESTRICTED COMMENTS\" SECURITY SETTINGS TO THE COMMENTS FOR THE MORTGAGE UNDERTAKING..");
		test.log(LogStatus.INFO,
				"APPLY THE \"ACCESS TO VIEW RESTRICTED COMMENTS\" SECURITY SETTINGS TO THE COMMENTS FOR THE MORTGAGE UNDERTAKING.");
		Reporter.log(
				"APPLY THE \"ACCESS TO VIEW RESTRICTED COMMENTS\" SECURITY SETTINGS TO THE COMMENTS FOR THE MORTGAGE UNDERTAKING.");
		log.info(
				"APPLY THE \"ACCESS TO VIEW RESTRICTED COMMENTS\" SECURITY SETTINGS TO THE COMMENTS FOR THE MORTGAGE UNDERTAKING.");

		Helper helper = new Helper();
		
		// refresh the page
		driver.navigate().refresh();
		Thread.sleep(5000);
		driver.navigate().refresh();

		System.out.println("Navigate to the Home Screen i.e. Property List Screen.");

		System.out.println("*************** SET SECURITY SETTINGS FOR THE COMMENTS *************");
		test.log(LogStatus.INFO, "*************** SET SECURITY SETTINGS FOR THE COMMENTS *************");
		Reporter.log("*************** SET SECURITY SETTINGS FOR THE COMMENTS *************");
		log.info("*************** SET SECURITY SETTINGS FOR THE COMMENTS *************");

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

			// RESET THE ACCESS TO VIEW RESTRICTED COMMENTS

			helper.resetPermission(data, "security_setting_comment_1", "propertyproject_securitysettings_comment1_XPATH");

			// APPLY THE ACCESS TO VIEW RESTRICTED COMMENTS

			helper.addPermissionOneUsersRole(data, "security_setting_comment_2",
					"propertyproject_securitysettings_comment2_XPATH");

			// RESET THE VIEW OHS RESTRICTED COMMENTS

			helper.resetPermission(data, "security_setting_comment_3", "propertyproject_securitysettings_comment3_XPATH");

		} catch (Throwable t) {
			verificationFailed();
		}

		System.out.println(
				"*************** ADD SECURITY SETTINGS OF VIEW MORTGAGE UNDERTAKING TO USER/ROLE ACCESS *************");
		test.log(LogStatus.INFO,
				"*************** ADD SECURITY SETTINGS OF VIEW MORTGAGE UNDERTAKING TO USER/ROLE ACCESS *************");
		Reporter.log(
				"*************** ADD SECURITY SETTINGS OF VIEW MORTGAGE UNDERTAKING TO USER/ROLE ACCESS *************");
		log.info(
				"*************** ADD SECURITY SETTINGS OF VIEW MORTGAGE UNDERTAKING TO USER/ROLE ACCESS *************");

		try {

			// APPLY THE VIEW MORTGAGE UNDERTAKING PERMISSION

			helper.addPermissionTwoUsersRole(data, "security_setting_1", "propertyproject_securitysettings1_XPATH");

			// RESET THE ADD MORTGAGE UNDERTAKING PERMISSION

			helper.resetPermission(data, "security_setting_2", "propertyproject_securitysettings2_XPATH");

			// RESET THE EDIT MORTGAGE UNDERTAKING PERMISSION

			helper.resetPermission(data, "security_setting_3", "propertyproject_securitysettings3_XPATH");

			// RESET THE DELETE MORTGAGE UNDERTAKING PERMISSION

			helper.resetPermission(data, "security_setting_4", "propertyproject_securitysettings4_XPATH");

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

		// ADD MORTGAGE UNDERTAKINGS

		System.out.println("**************** ADD MORTGAGE UNDERTAKINGS ****************");
		test.log(LogStatus.INFO, "**************** ADD MORTGAGE UNDERTAKINGS ****************");
		Reporter.log("**************** ADD MORTGAGE UNDERTAKINGS ****************");
		log.info("**************** ADD MORTGAGE UNDERTAKINGS ****************");

		try {
			// click on the property project icon from the property list page
			click("propertyproject_icon_CSS");
			System.out.println("Clicked on the property project icon of the Property.");
			ngDriver.waitForAngularRequestsToFinish();
			System.out.println("Navigate to the property project screen of the perticular property.");

			// wait for the element
			explicitWaitClickable("menubtn_CSS");

			// click on the burger menu
			click("menubtn_CSS");
			System.out.println("Clicked on the burger menu button successfully!!!");
			ngDriver.waitForAngularRequestsToFinish();

			// wait for the element
			Thread.sleep(5000);

			// click on the Mortgage Undertakings
			click("propertyproject_mortgageundertakingsoption_XPATH");
			System.out.println("Clicked on the Mortgage Undertakings option.");
			ngDriver.waitForAngularRequestsToFinish();

			// ADD RECORD - MORTGAGE UNDERTAKINGS

			// click on the add button
			click("propertyproject_mu_addbtn_CSS");
			System.out.println("Clicked on the Add button.");
			ngDriver.waitForAngularRequestsToFinish();
			System.out.println("Navigate to the Add Mortgage Undertakings Screen");

			// enter the undertaking number
			type("propertyproject_mu_undertakingnumbertxt_CSS", data.get("undertaking_number"));
			System.out.println("Entered the undertaking number.");
			ngDriver.waitForAngularRequestsToFinish();

			// select the lender
			select("propertyproject_mu_lenderdd_CSS", data.get("lender"));
			ngDriver.waitForAngularRequestsToFinish();
			System.out.println("Selected the lender.");

			// click on the save button
			click("propertyproject_mu_savebtn_CSS");
			ngDriver.waitForAngularRequestsToFinish();
			System.out.println("Clicked on the save button.");

			// wait for the element
			explicitWaitClickable("closetoastmsg_CSS");

			// click on the toaster close button
			click("closetoastmsg_CSS");
			ngDriver.waitForAngularRequestsToFinish();
			System.out.println("Clicked on the toaster close button.");

			// wait for the element
			explicitWaitClickable("propertyproject_mu_newrepairbtn_BTNTEXT");

			// ADD COMMENT OF THE MORTGAGE UNDERTAKING

			// click on the comment tab
			click("propertyproject_mu_commenttab_XPATH");
			ngDriver.waitForAngularRequestsToFinish();
			System.out.println("Clicked on the attachment tab.");

			// scroll down the screen
			JavascriptExecutor js = (JavascriptExecutor) driver;
			js.executeScript("window.scrollBy(0,800)");

			// enter the details in the comment field
			type("propertyproject_mu_commenttxt_CSS", data.get("description"));
			ngDriver.waitForAngularRequestsToFinish();
			System.out.println("Entered the details in the comment field.");

			// click on the restricted comment checkbox
			click("propertyproject_mu_comment_restricted_CSS");
			ngDriver.waitForAngularRequestsToFinish();
			System.out.println("Clicked on the restricted comment checkbox.");

			// click on the update button
			click("propertyproject_mu_updatebtn_CSS");
			ngDriver.waitForAngularRequestsToFinish();
			System.out.println("Clicked on the update button.");

			// wait for the element
			explicitWaitClickable("closetoastmsg_CSS");

			// click on the toaster close button
			click("closetoastmsg_CSS");
			ngDriver.waitForAngularRequestsToFinish();
			System.out.println("Clicked on the toaster close button.");

			// verify newly created mortgage undertaking is displayed or not
			switchVerification("propertyproject_mu_addedmortgageundertakings_comment2_XPATH",
					"UNDERTAKINGSSCOMMENTTWO2021", "The UNDERTAKINGSSCOMMENTTWO2021 is not displayed.");

		} catch (Throwable t) {
			verificationFailed();
		}

		// click on the home icon
		click("questionnaire_homeburgermenubtn_hide_CSS");
		ngDriver.waitForAngularRequestsToFinish();
		System.out.println("Clicked on the home icon.");

		// wait for the element
		explicitWait("propertylist_title_XPATH");

		// verify the property list
		switchVerification("propertylist_title_XPATH", "Property List", "The property list is not displayed.");

		// wait for the element
		explicitWaitClickable("questionnaire_settingicon_CSS");

		try {
			// click on the settings icon from the top of the screen
			click("questionnaire_settingicon_CSS");
			System.out.println("Clicked on the settings icon.");
			ngDriver.waitForAngularRequestsToFinish();

			// wait for the element
			Thread.sleep(5000);

			// click on the logout option from the side menu
			click("sidemenu_logout_CSS");
			System.out.println("Clicked on the logout option from the side menu.");
			ngDriver.waitForAngularRequestsToFinish();

			// VERIFY THE RESTRICTED ATTACHMENT ACCESS IN THE JINESH USER

			System.out.println(
					"**************** VERIFY THE ACCESS TO VIEW RESTRICTED COMMENTS IN THE JINESH USER ****************");
			test.log(LogStatus.INFO,
					"**************** VERIFY THE ACCESS TO VIEW RESTRICTED COMMENTS IN THE JINESH USER ****************");
			Reporter.log(
					"**************** VERIFY THE ACCESS TO VIEW RESTRICTED COMMENTS IN THE JINESH USER ****************");
			log.info(
					"**************** VERIFY THE ACCESS TO VIEW RESTRICTED COMMENTS IN THE JINESH USER ****************");

			System.out.println("**************** LOGIN IN JINESH USER ****************");
			test.log(LogStatus.INFO, "**************** LOGIN IN JINESH USER ****************");
			Reporter.log("**************** LOGIN IN JINESH USER ****************");
			log.info("**************** LOGIN IN JINESH USER ****************");

			helper.loginAndUpdateSystemCompany(data, "username", "password", "system_company_1");

			// click on the property project icon from the property list page
			click("propertyproject_icon_CSS");
			System.out.println("Clicked on the property project icon of the Property.");
			ngDriver.waitForAngularRequestsToFinish();
			System.out.println("Navigate to the property project screen of the perticular property.");

			// wait for the element
			explicitWaitClickable("menubtn_CSS");

			// click on the burger menu
			click("menubtn_CSS");
			System.out.println("Clicked on the burger menu button successfully!!!");
			ngDriver.waitForAngularRequestsToFinish();

			// wait for the element
			Thread.sleep(5000);

			// click on the Mortgage Undertakings
			click("propertyproject_mortgageundertakingsoption_XPATH");
			System.out.println("Clicked on the Mortgage Undertakings option.");
			ngDriver.waitForAngularRequestsToFinish();

			// verify newly created mortgage undertaking is displayed or not
			switchVerification("propertyproject_mu_addedmortgageundertakings_comment2_XPATH",
					"UNDERTAKINGSSCOMMENTTWO2021", "The UNDERTAKINGSSCOMMENTTWO2021 is not displayed.");

			// click on the created mortgage undertaking
			click("propertyproject_mu_addedmortgageundertakings_comment2_XPATH");
			ngDriver.waitForAngularRequestsToFinish();
			System.out.println("Clicked on the created mortgage undertaking.");

			// scroll down the screen
			JavascriptExecutor js = (JavascriptExecutor) driver;
			js.executeScript("window.scrollBy(0,600)");

			// VERIFY COMMENT OF THE MORTGAGE UNDERTAKING

			// click on the comment tab
			click("propertyproject_mu_commenttab_XPATH");
			ngDriver.waitForAngularRequestsToFinish();
			System.out.println("Clicked on the attachment tab.");

			// scroll down the screen
			js.executeScript("window.scrollBy(0,800)");

			try {

				boolean checked1 = driver
						.findElement(By.xpath(OR.getProperty("propertyproject_mu_restrictedcomment2_XPATH")))
						.isDisplayed();

				if (checked1 == true) {
					System.out.println("The Restricted Comment is displayed as per the permission.");
					test.log(LogStatus.INFO, "The Restricted Comment is displayed as per the permission.");
					Reporter.log("The Restricted Comment is displayed as per the permission.");
					log.info("The Restricted Comment is displayed as per the permission.");

				} else {
					TestUtil.captureScreenshot();

					// ReportNG
					Reporter.log("<br>" + "The Restricted Comment is not displayed: " + "<br>");
					Reporter.log("<a target=\"_blank\" href=" + TestUtil.screenshotName + "><img src="
							+ TestUtil.screenshotName + " height=200 width=200></img></a>");
					Reporter.log("<br>");
					Reporter.log("<br>");

					// Extent Report
					test.log(LogStatus.FAIL, " The Restricted Comment is not displayed : ");
					test.log(LogStatus.FAIL, test.addScreenCapture(TestUtil.screenshotName));

					System.out.println("The Restricted Comment is not displayed");
					log.info("The Restricted Comment is not displayed");

				}

			} catch (Throwable t) {
				TestUtil.captureScreenshot();

				// ReportNG
				Reporter.log("<br>" + "The Restricted Comment is not displayed: " + "<br>");
				Reporter.log("<a target=\"_blank\" href=" + TestUtil.screenshotName + "><img src="
						+ TestUtil.screenshotName + " height=200 width=200></img></a>");
				Reporter.log("<br>");
				Reporter.log("<br>");

				// Extent Report
				test.log(LogStatus.FAIL, " The Restricted Comment is not displayed : ");
				test.log(LogStatus.FAIL, test.addScreenCapture(TestUtil.screenshotName));

				System.out.println("The Restricted Comment is not displayed");
				log.info("The Restricted Comment is not displayed");

			}

			// click on the cancel button
			click("propertyproject_mu_cancelbtn_CSS");
			ngDriver.waitForAngularRequestsToFinish();
			System.out.println("Clicked on the cancel button.");

			// click on the home icon
			click("questionnaire_homeburgermenubtn_hide_CSS");
			ngDriver.waitForAngularRequestsToFinish();
			System.out.println("Clicked on the home icon.");

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
			Thread.sleep(5000);

			// click on the logout option from the side menu
			click("sidemenu_logout_CSS");
			System.out.println("Clicked on the logout option from the side menu.");
			ngDriver.waitForAngularRequestsToFinish();

			// VERIFY THE ACCESS TO VIEW RESTRICTED COMMENTS IN THE JINESH CONTRACTOR

			System.out.println(
					"**************** VERIFY THE ACCESS TO VIEW RESTRICTED COMMENTS IN THE JINESH CONTRACTOR ****************");
			test.log(LogStatus.INFO,
					"**************** VERIFY THE ACCESS TO VIEW RESTRICTED COMMENTS IN THE JINESH CONTRACTOR ****************");
			Reporter.log(
					"**************** VERIFY THE ACCESS TO VIEW RESTRICTED COMMENTS IN THE JINESH CONTRACTOR ****************");
			log.info(
					"**************** VERIFY THE ACCESS TO VIEW RESTRICTED COMMENTS IN THE JINESH CONTRACTOR ****************");
			System.out.println("**************** LOGIN IN JINESH CONTRACTOR ****************");
			test.log(LogStatus.INFO, "**************** LOGIN IN JINESH CONTRACTOR ****************");
			Reporter.log("**************** LOGIN IN JINESH CONTRACTOR ****************");
			log.info("**************** LOGIN IN JINESH CONTRACTOR ****************");

			helper.loginAndUpdateSystemCompany(data, "username_2", "password_2", "system_company_1");

			// click on the property project icon from the property list page
			click("propertyproject_icon_CSS");
			System.out.println("Clicked on the property project icon of the Property.");
			ngDriver.waitForAngularRequestsToFinish();
			System.out.println("Navigate to the property project screen of the perticular property.");

			// wait for the element
			explicitWaitClickable("menubtn_CSS");

			// click on the burger menu
			click("menubtn_CSS");
			System.out.println("Clicked on the burger menu button successfully!!!");
			ngDriver.waitForAngularRequestsToFinish();

			// wait for the element
			Thread.sleep(5000);

			// click on the Mortgage Undertakings
			click("propertyproject_mortgageundertakingsoption_XPATH");
			System.out.println("Clicked on the Mortgage Undertakings option.");
			ngDriver.waitForAngularRequestsToFinish();

			// verify newly created mortgage undertaking is displayed or not
			switchVerification("propertyproject_mu_addedmortgageundertakings_comment2_XPATH",
					"UNDERTAKINGSSCOMMENTTWO2021", "The UNDERTAKINGSSCOMMENTTWO2021 is not displayed.");

			// click on the created mortgage undertaking
			click("propertyproject_mu_addedmortgageundertakings_comment2_XPATH");
			ngDriver.waitForAngularRequestsToFinish();
			System.out.println("Clicked on the created mortgage undertaking.");

			// scroll down the screen
			js.executeScript("window.scrollBy(0,600)");

			// VERIFY COMMENT OF THE MORTGAGE UNDERTAKING

			// click on the comment tab
			click("propertyproject_mu_commenttab_XPATH");
			ngDriver.waitForAngularRequestsToFinish();
			System.out.println("Clicked on the attachment tab.");

			// scroll down the screen
			js.executeScript("window.scrollBy(0,800)");

			try {

				boolean checked2 = driver
						.findElement(By.xpath(OR.getProperty("propertyproject_mu_restrictedcomment2_XPATH")))
						.isDisplayed();

				if (checked2 == true) {
					System.out.println("The Restricted Comment is displayed as per the permission.");
					test.log(LogStatus.INFO, "The Restricted Comment is displayed as per the permission.");
					Reporter.log("The Restricted Comment is displayed as per the permission.");
					log.info("The Restricted Comment is displayed as per the permission.");

				} else {
					TestUtil.captureScreenshot();

					// ReportNG
					Reporter.log("<br>" + "The Restricted Comment is not displayed: " + "<br>");
					Reporter.log("<a target=\"_blank\" href=" + TestUtil.screenshotName + "><img src="
							+ TestUtil.screenshotName + " height=200 width=200></img></a>");
					Reporter.log("<br>");
					Reporter.log("<br>");

					// Extent Report
					test.log(LogStatus.FAIL, " The Restricted Comment is not displayed : ");
					test.log(LogStatus.FAIL, test.addScreenCapture(TestUtil.screenshotName));

					System.out.println("The Restricted Comment is not displayed");
					log.info("The Restricted Comment is not displayed");

				}

			} catch (Throwable t) {
				TestUtil.captureScreenshot();

				// ReportNG
				Reporter.log("<br>" + "The Restricted Comment is not displayed: " + "<br>");
				Reporter.log("<a target=\"_blank\" href=" + TestUtil.screenshotName + "><img src="
						+ TestUtil.screenshotName + " height=200 width=200></img></a>");
				Reporter.log("<br>");
				Reporter.log("<br>");

				// Extent Report
				test.log(LogStatus.FAIL, " The Restricted Comment is not displayed : ");
				test.log(LogStatus.FAIL, test.addScreenCapture(TestUtil.screenshotName));

				System.out.println("The Restricted Comment is not displayed");
				log.info("The Restricted Comment is not displayed");

			}

			// click on the cancel button
			click("propertyproject_mu_cancelbtn_CSS");
			ngDriver.waitForAngularRequestsToFinish();
			System.out.println("Clicked on the cancel button.");

			// click on the home icon
			click("questionnaire_homeburgermenubtn_hide_CSS");
			ngDriver.waitForAngularRequestsToFinish();
			System.out.println("Clicked on the home icon.");

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
			Thread.sleep(5000);

			// click on the logout option from the side menu
			click("sidemenu_logout_CSS");
			System.out.println("Clicked on the logout option from the side menu.");
			ngDriver.waitForAngularRequestsToFinish();

			// VERIFY THE ACCESS TO VIEW RESTRICTED COMMENTS IN THE JINESH HR

			System.out.println(
					"**************** VERIFY THE ACCESS TO VIEW RESTRICTED COMMENTS IN THE JINESH HR ****************");
			test.log(LogStatus.INFO,
					"**************** VERIFY THE ACCESS TO VIEW RESTRICTED COMMENTS IN THE JINESH HR ****************");
			Reporter.log(
					"**************** VERIFY THE ACCESS TO VIEW RESTRICTED COMMENTS IN THE JINESH HR ****************");
			log.info(
					"**************** VERIFY THE ACCESS TO VIEW RESTRICTED COMMENTS IN THE JINESH HR ****************");

			System.out.println("**************** LOGIN IN JINESH HR ****************");
			test.log(LogStatus.INFO, "**************** LOGIN IN JINESH HR ****************");
			Reporter.log("**************** LOGIN IN JINESH HR ****************");
			log.info("**************** LOGIN IN JINESH HR ****************");

			helper.loginAndUpdateSystemCompany(data, "username_3", "password_3", "system_company_1");

			// click on the property project icon from the property list page
			click("propertyproject_icon_CSS");
			System.out.println("Clicked on the property project icon of the Property.");
			ngDriver.waitForAngularRequestsToFinish();
			System.out.println("Navigate to the property project screen of the perticular property.");

			// wait for the element
			explicitWaitClickable("menubtn_CSS");

			// click on the burger menu
			click("menubtn_CSS");
			System.out.println("Clicked on the burger menu button successfully!!!");
			ngDriver.waitForAngularRequestsToFinish();

			// wait for the element
			Thread.sleep(5000);

			// click on the Mortgage Undertakings
			click("propertyproject_mortgageundertakingsoption_XPATH");
			System.out.println("Clicked on the Mortgage Undertakings option.");
			ngDriver.waitForAngularRequestsToFinish();

			// verify newly created mortgage undertaking is displayed or not
			switchVerification("propertyproject_mu_addedmortgageundertakings_comment2_XPATH",
					"UNDERTAKINGSSCOMMENTTWO2021", "The UNDERTAKINGSSCOMMENTTWO2021 is not displayed.");

			// click on the created mortgage undertaking
			click("propertyproject_mu_addedmortgageundertakings_comment2_XPATH");
			ngDriver.waitForAngularRequestsToFinish();
			System.out.println("Clicked on the created mortgage undertaking.");

			// scroll down the screen
			js.executeScript("window.scrollBy(0,600)");

			// VERIFY COMMENT OF THE MORTGAGE UNDERTAKING

			// click on the comment tab
			click("propertyproject_mu_commenttab_XPATH");
			ngDriver.waitForAngularRequestsToFinish();
			System.out.println("Clicked on the attachment tab.");

			// scroll down the screen
			js.executeScript("window.scrollBy(0,800)");

			try {

				boolean checked3 = driver
						.findElement(By.xpath(OR.getProperty("propertyproject_mu_restrictedcomment2_XPATH")))
						.isDisplayed();

				if (checked3 == true) {

					TestUtil.captureScreenshot();

					// ReportNG
					Reporter.log("<br>" + "The Restricted Comment is displayed: " + "<br>");
					Reporter.log("<a target=\"_blank\" href=" + TestUtil.screenshotName + "><img src="
							+ TestUtil.screenshotName + " height=200 width=200></img></a>");
					Reporter.log("<br>");
					Reporter.log("<br>");

					// Extent Report
					test.log(LogStatus.FAIL, " The Restricted Comment is displayed : ");
					test.log(LogStatus.FAIL, test.addScreenCapture(TestUtil.screenshotName));

					System.out.println("The Restricted Comment is displayed");
					log.info("The Restricted Comment is not displayed");

				} else {
					System.out.println("The Restricted Comment is not displayed.");
					test.log(LogStatus.INFO, "The Restricted Comment is not displayed.");
					Reporter.log("The Restricted Comment is not displayed.");
					log.info("The Restricted Comment is not displayed.");

				}

			} catch (Throwable t) {
				System.out.println("The Restricted Comment is not displayed.");
				test.log(LogStatus.INFO, "The Restricted Comment is not displayed.");
				Reporter.log("The Restricted Comment is not displayed.");
				log.info("The Restricted Comment is not displayed.");

			}

			// click on the cancel button
			click("propertyproject_mu_cancelbtn_CSS");
			ngDriver.waitForAngularRequestsToFinish();
			System.out.println("Clicked on the cancel button.");

			// click on the home icon
			click("questionnaire_homeburgermenubtn_hide_CSS");
			ngDriver.waitForAngularRequestsToFinish();
			System.out.println("Clicked on the home icon.");

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
			Thread.sleep(5000);

			// click on the logout option from the side menu
			click("sidemenu_logout_CSS");
			System.out.println("Clicked on the logout option from the side menu.");
			ngDriver.waitForAngularRequestsToFinish();

			// DELETE THE CREATED MORTGAGE UNDERTAKING AND RESET THE GIVEN PERMISSIONS

			System.out.println(
					"**************** DELETE THE CREATED MORTGAGE UNDERTAKING AND RESET THE GIVEN PERMISSIONS ****************");
			test.log(LogStatus.INFO,
					"**************** DELETE THE CREATED MORTGAGE UNDERTAKING AND RESET THE GIVEN PERMISSIONS ****************");
			Reporter.log(
					"**************** DELETE THE CREATED MORTGAGE UNDERTAKING AND RESET THE GIVEN PERMISSIONS ****************");
			log.info(
					"**************** DELETE THE CREATED MORTGAGE UNDERTAKING AND RESET THE GIVEN PERMISSIONS ****************");

			System.out.println("**************** LOGIN IN AUTOMATION TESTER USER ****************");
			test.log(LogStatus.INFO, "**************** LOGIN IN AUTOMATION TESTER USER ****************");
			Reporter.log("**************** LOGIN IN AUTOMATION TESTER USER ****************");
			log.info("**************** LOGIN IN AUTOMATION TESTER USER ****************");

			helper.loginAndUpdateSystemCompany(data, "username_1", "password_1", "system_company_1");

		} catch (Throwable t) {
			helper.questionnaireNotDisplayLogout(data);
		}

		try {

			// DELETE THE MORTGAGE UNDERTAKINGS

			System.out.println("**************** DELETE MORTGAGE UNDERTAKINGS ****************");
			test.log(LogStatus.INFO, "**************** DELETE MORTGAGE UNDERTAKINGS ****************");
			Reporter.log("**************** DELETE MORTGAGE UNDERTAKINGS ****************");
			log.info("**************** DELETE MORTGAGE UNDERTAKINGS ****************");

			// click on the property project icon from the property list page
			click("propertyproject_icon_CSS");
			System.out.println("Clicked on the property project icon of the Property.");
			ngDriver.waitForAngularRequestsToFinish();
			System.out.println("Navigate to the property project screen of the perticular property.");

			// wait for the element
			explicitWaitClickable("menubtn_CSS");

			// click on the burger menu
			click("menubtn_CSS");
			System.out.println("Clicked on the burger menu button successfully!!!");
			ngDriver.waitForAngularRequestsToFinish();

			// wait for the element
			Thread.sleep(5000);

			// click on the Mortgage Undertakings
			click("propertyproject_mortgageundertakingsoption_XPATH");
			System.out.println("Clicked on the Mortgage Undertakings option.");
			ngDriver.waitForAngularRequestsToFinish();

			// verify newly created mortgage undertaking is displayed or not
			switchVerification("propertyproject_mu_addedmortgageundertakings_comment2_XPATH",
					"UNDERTAKINGSSCOMMENTTWO2021", "The UNDERTAKINGSSCOMMENTTWO2021 is not displayed.");

			// click on the delete button of the newly created Mortgage Undertakings
			List<WebElement> links = driver.findElements(By.xpath("//tr"));
			int count = links.size();
			System.out.println("Number of links are:" + count);

			for (int i = 0; i < count - 1; i++) {

				// wait for the element
				explicitWaitClickable("propertyproject_mu_deletebtn_CSS");

				// delete the all the Mortgage Undertakings
				click("propertyproject_mu_deletebtn_CSS");
				System.out.println("Deleted the all the Mortgage Undertakings");
				ngDriver.waitForAngularRequestsToFinish();

				// wait for the element
				explicitWaitClickable("propertyproject_mu_confirmationdeletebtn_CSS");

				// click on the delete button of confirmation
				click("propertyproject_mu_confirmationdeletebtn_CSS");
				System.out.println("Clicked on the delete button of confirmation.");
				ngDriver.waitForAngularRequestsToFinish();

				// wait for the element
				explicitWaitClickable("closetoastmsg_CSS");

				// click on the toaster close button
				click("closetoastmsg_CSS");
				ngDriver.waitForAngularRequestsToFinish();
				System.out.println("Clicked on the toaster close button.");

			}

			// verify newly created MORTGAGE UNDERTAKINGS is deleted or not

			helper.deleteVerification("propertyproject_mu_addedmortgageundertakings_comment2_XPATH",
					"UNDERTAKINGSSCOMMENTTWO2021");

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

			// RESET THE VIEW MORTGAGE UNDERTAKING PERMISSION

			helper.resetPermission(data, "security_setting_1", "propertyproject_securitysettings1_XPATH");

			// RESET THE PERMISSION TO RESTRICTED ATTACHMENT

			helper.resetPermission(data, "security_setting_comment_2", "propertyproject_securitysettings_comment2_XPATH");

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