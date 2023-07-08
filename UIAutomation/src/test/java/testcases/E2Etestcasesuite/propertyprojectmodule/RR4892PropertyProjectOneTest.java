package testcases.E2Etestcasesuite.propertyprojectmodule;

import java.io.IOException;
import java.util.Hashtable;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Reporter;
import org.testng.SkipException;
import org.testng.annotations.Test;

import com.relevantcodes.extentreports.LogStatus;

import base.Helper;
import base.TestBase;
import utilities.TestUtil;

public class RR4892PropertyProjectOneTest extends TestBase {

	@Test(dataProviderClass = TestUtil.class, dataProvider = "dp")
	public void rR4892PropertyProjectOneTest(Hashtable<String, String> data) throws IOException, InterruptedException {

		execution(data, "rR4892PropertyProjectOneTest");

		// APPLY THE SECURITY SETTING OF THE ADD MORTGAGE UNDERTAKING PERMISSION TO THE
		// ASSIGNED USER/ROLE AND RESPECTIVE USER/ROLE MUST HAVE ONLY GRANTED PERMISSION
		// TO PERFORM ACTIONS.

		System.out.println(
				"APPLY THE SECURITY SETTING OF THE ADD MORTGAGE UNDERTAKING PERMISSION TO THE ASSIGNED USER/ROLE AND RESPECTIVE USER/ROLE MUST HAVE ONLY GRANTED PERMISSION TO PERFORM ACTIONS.");
		test.log(LogStatus.INFO,
				"APPLY THE SECURITY SETTING OF THE ADD MORTGAGE UNDERTAKING PERMISSION TO THE ASSIGNED USER/ROLE AND RESPECTIVE USER/ROLE MUST HAVE ONLY GRANTED PERMISSION TO PERFORM ACTIONS.");
		Reporter.log(
				"APPLY THE SECURITY SETTING OF THE ADD MORTGAGE UNDERTAKING PERMISSION TO THE ASSIGNED USER/ROLE AND RESPECTIVE USER/ROLE MUST HAVE ONLY GRANTED PERMISSION TO PERFORM ACTIONS.");
		log.info(
				"APPLY THE SECURITY SETTING OF THE ADD MORTGAGE UNDERTAKING PERMISSION TO THE ASSIGNED USER/ROLE AND RESPECTIVE USER/ROLE MUST HAVE ONLY GRANTED PERMISSION TO PERFORM ACTIONS.");

		Helper helper = new Helper();

		// refresh the page
		driver.navigate().refresh();
		Thread.sleep(5000);
		driver.navigate().refresh();

		System.out.println("Navigate to the Home Screen i.e. Property List Screen.");

		System.out.println(
				"*************** ADD SECURITY SETTINGS OF VIEW / ADD MORTGAGE UNDERTAKING TO USER/ROLE ACCESS *************");
		test.log(LogStatus.INFO,
				"*************** ADD SECURITY SETTINGS OF VIEW / ADD MORTGAGE UNDERTAKING TO USER/ROLE ACCESS *************");
		Reporter.log(
				"*************** ADD SECURITY SETTINGS OF VIEW / ADD MORTGAGE UNDERTAKING TO USER/ROLE ACCESS *************");
		log.info(
				"*************** ADD SECURITY SETTINGS OF VIEW / ADD MORTGAGE UNDERTAKING TO USER/ROLE ACCESS *************");

		try {
			// wait for the element
			explicitWaitClickable("questionnaire_settingicon_CSS");

			// click on the settings icon from the top of the screen
			click("questionnaire_settingicon_CSS");

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

			// APPLY THE VIEW MORTGAGE UNDERTAKING PERMISSION

			helper.addPermissionTwoUsersRole(data, "security_setting_1", "propertyproject_securitysettings1_XPATH");

			// APPLY THE ADD MORTGAGE UNDERTAKING PERMISSION

			helper.addPermissionOneUsersRole(data, "security_setting_2", "propertyproject_securitysettings2_XPATH");

			// APPLY THE EDIT MORTGAGE UNDERTAKING PERMISSION

			helper.resetPermission(data, "security_setting_3", "propertyproject_securitysettings3_XPATH");

			// APPLY THE DELETE MORTGAGE UNDERTAKING PERMISSION

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

			// VERIFY THE ADD, EDIT AND DELETE ACCESS IN THE JINESH USER

			System.out.println(
					"**************** VERIFY THE ADD, EDIT AND DELETE ACCESS IN THE JINESH USER ****************");
			test.log(LogStatus.INFO,
					"**************** VERIFY THE ADD, EDIT AND DELETE ACCESS IN THE JINESH USER ****************");
			Reporter.log("**************** VERIFY THE ADD, EDIT AND DELETE ACCESS IN THE JINESH USER ****************");
			log.info("**************** VERIFY THE ADD, EDIT AND DELETE ACCESS IN THE JINESH USER ****************");

			System.out.println("**************** LOGIN IN JINESH USER ****************");
			test.log(LogStatus.INFO, "**************** LOGIN IN JINESH USER ****************");
			Reporter.log("**************** LOGIN IN JINESH USER ****************");
			log.info("**************** LOGIN IN JINESH USER ****************");

			helper.loginAndUpdateSystemCompany(data, "username", "password", "system_company_1");

			// VERIFY THE JINESH ABLE TO ADD THE MORTGAGE UNDERTAKING DETAILS OR NOT

			System.out.println("**************** ADD MORTGAGE UNDERTAKINGS - JINESH ****************");
			test.log(LogStatus.INFO, "**************** ADD MORTGAGE UNDERTAKINGS - JINESH ****************");
			Reporter.log("**************** ADD MORTGAGE UNDERTAKINGS - JINESH ****************");
			log.info("**************** ADD MORTGAGE UNDERTAKINGS - JINESH ****************");

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
				explicitWaitClickable("propertyproject_mu_cancelbtn_CSS");

				// click on the cancel button
				click("propertyproject_mu_cancelbtn_CSS");
				ngDriver.waitForAngularRequestsToFinish();
				System.out.println("Clicked on the cancel button.");

				// verification of the Mortgage Undertakings is added or not
				switchVerification("propertyproject_mu_addedmortgageundertakings_ss1_XPATH",
						"UNDERTAKINGPERMISSIONONE2021", "Mortgage Undertakings is not displayed successfully.");

			} catch (Throwable t) {
				verificationFailed();
			}

			// VERIFY THE USER ABLE TO UPDATE THE MORTGAGE UNDERTAKING DETAILS OR NOT

			System.out.println("**************** UPDATE MORTGAGE UNDERTAKINGS - JINESH ****************");
			test.log(LogStatus.INFO, "**************** UPDATE MORTGAGE UNDERTAKINGS - JINESH ****************");
			Reporter.log("**************** UPDATE MORTGAGE UNDERTAKINGS - JINESH ****************");
			log.info("**************** UPDATE MORTGAGE UNDERTAKINGS - JINESH ****************");

			try {

				// click on the newly created Mortgage Undertakings
				click("propertyproject_mu_addedmortgageundertakings_ss1_XPATH");
				ngDriver.waitForAngularRequestsToFinish();
				System.out.println("Clicked on the newly created Mortgage Undertakings.");

				// update the title of the undertaking number
				clear("propertyproject_mu_undertakingnumbertxt_CSS");
				ngDriver.waitForAngularRequestsToFinish();
				System.out.println("Clear the title field.");
				type("propertyproject_mu_undertakingnumbertxt_CSS", data.get("update_undertaking_number"));
				ngDriver.waitForAngularRequestsToFinish();
				System.out.println("update the title of the undertaking number.");

				// update the title of the undertaking number
				clear("propertyproject_mu_undertakingnumbertxt_CSS");
				ngDriver.waitForAngularRequestsToFinish();
				System.out.println("Clear the title field.");
				type("propertyproject_mu_undertakingnumbertxt_CSS", data.get("undertaking_number"));
				ngDriver.waitForAngularRequestsToFinish();
				System.out.println("update the title of the undertaking number.");

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

				TestUtil.captureScreenshot();

				// ReportNG
				Reporter.log("<br>" + "The user able to update the Mortgage Undertakings details without the Access: "
						+ "<br>");
				Reporter.log("<a target=\"_blank\" href=" + TestUtil.screenshotName + "><img src="
						+ TestUtil.screenshotName + " height=200 width=200></img></a>");
				Reporter.log("<br>");
				Reporter.log("<br>");

				// Extent Report
				test.log(LogStatus.FAIL,
						" The user able to update the Mortgage Undertakings details without the Access : ");
				test.log(LogStatus.FAIL, test.addScreenCapture(TestUtil.screenshotName));

				System.out.println("The user able to update the Mortgage Undertakings details without the Access.");
				log.info("The user able to update the Mortgage Undertakings details without the Access.");

			} catch (Throwable t) {

				System.out.println("The user not able to update the Mortgage Undertakings details as expected.");
				test.log(LogStatus.INFO, "The user not able to update the Mortgage Undertakings details as expected");
				Reporter.log("The user not able to update the Mortgage Undertakings details as expected");
				log.info("The user not able to update the Mortgage Undertakings details as expected");

				// click on the cancel button
				click("propertyproject_mu_cancelbtn_CSS");
				ngDriver.waitForAngularRequestsToFinish();
				System.out.println("Clicked on the cancel button.");

			}

			// VERIFY THE USER ABLE TO DELETE THE MORTGAGE UNDERTAKING DETAILS OR NOT

			System.out.println("**************** DELETE MORTGAGE UNDERTAKINGS - JINESH ****************");
			test.log(LogStatus.INFO, "**************** DELETE MORTGAGE UNDERTAKINGS - JINESH ****************");
			Reporter.log("**************** DELETE MORTGAGE UNDERTAKINGS - JINESH ****************");
			log.info("**************** DELETE MORTGAGE UNDERTAKINGS - JINESH ****************");

			try {

				boolean mu1 = driver.findElement(By.cssSelector(OR.getProperty("propertyproject_mu_deletebtn_CSS")))
						.isDisplayed();

				if (mu1 == true) {
					TestUtil.captureScreenshot();

					// ReportNG
					Reporter.log(
							"<br>" + "The delete button is displayed in the Mortgage Undertakings without the Access: "
									+ "<br>");
					Reporter.log("<a target=\"_blank\" href=" + TestUtil.screenshotName + "><img src="
							+ TestUtil.screenshotName + " height=200 width=200></img></a>");
					Reporter.log("<br>");
					Reporter.log("<br>");

					// Extent Report
					test.log(LogStatus.FAIL,
							" The delete button is displayed in the Mortgage Undertakings without the Access : ");
					test.log(LogStatus.FAIL, test.addScreenCapture(TestUtil.screenshotName));

					System.out
							.println("The delete button is displayed in the Mortgage Undertakings without the Access.");
					log.info("The delete button is displayed in the Mortgage Undertakings without the Access.");
				}

			} catch (Throwable t) {

				System.out.println("The user not able to delete the Mortgage Undertakings details as expected.");
				test.log(LogStatus.INFO, "The user not able to delete the Mortgage Undertakings details as expected");
				Reporter.log("The user not able to delete the Mortgage Undertakings details as expected");
				log.info("The user not able to delete the Mortgage Undertakings details as expected");

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
					"**************** VERIFY THE ADD, EDIT AND DELETE ACCESS IN THE CONTRACTOR ROLE ****************");
			test.log(LogStatus.INFO,
					"**************** VERIFY THE ADD, EDIT AND DELETE ACCESS IN THE CONTRACTOR ROLE ****************");
			Reporter.log(
					"**************** VERIFY THE ADD, EDIT AND DELETE ACCESS IN THE CONTRACTOR ROLE ****************");
			log.info("**************** VERIFY THE ADD, EDIT AND DELETE ACCESS IN THE CONTRACTOR ROLE ****************");

			System.out.println("**************** LOGIN IN JINESH CONTRACTOR USER ****************");
			test.log(LogStatus.INFO, "**************** LOGIN IN JINESH CONTRACTOR USER ****************");
			Reporter.log("**************** LOGIN IN JINESH CONTRACTOR USER ****************");
			log.info("**************** LOGIN IN JINESH CONTRACTOR USER ****************");

			helper.loginAndUpdateSystemCompany(data, "username_2", "password_2", "system_company_1");

			// VERIFY THE CONTRACTOR - JINESHCONTRACTOR ABLE TO ADD THE MORTGAGE UNDERTAKING
			// DETAILS OR NOT

			System.out.println(
					"**************** ADD MORTGAGE UNDERTAKINGS - CONTRACTOR - JINESHCONTRACTOR ****************");
			test.log(LogStatus.INFO,
					"**************** ADD MORTGAGE UNDERTAKINGS - CONTRACTOR - JINESHCONTRACTOR ****************");
			Reporter.log("**************** ADD MORTGAGE UNDERTAKINGS - CONTRACTOR - JINESHCONTRACTOR ****************");
			log.info("**************** ADD MORTGAGE UNDERTAKINGS - CONTRACTOR - JINESHCONTRACTOR ****************");

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
				type("propertyproject_mu_undertakingnumbertxt_CSS", data.get("undertaking_number2"));
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
				explicitWaitClickable("propertyproject_mu_cancelbtn_CSS");

				// click on the cancel button
				click("propertyproject_mu_cancelbtn_CSS");
				ngDriver.waitForAngularRequestsToFinish();
				System.out.println("Clicked on the cancel button.");

				// verification of the Mortgage Undertakings is added or not
				switchVerification("propertyproject_mu_addedmortgageundertakings2_ss1_XPATH",
						"UNDERTAKINGPERMISSIONTWO2021", "Mortgage Undertakings is not displayed successfully.");

			} catch (Throwable t) {
				verificationFailed();
			}

			// VERIFY THE ROLE ABLE TO UPDATE THE MORTGAGE UNDERTAKING DETAILS OR NOT

			System.out.println(
					"**************** UPDATE MORTGAGE UNDERTAKINGS - CONTRACTOR - JINESHCONTRACTOR ****************");
			test.log(LogStatus.INFO,
					"**************** UPDATE MORTGAGE UNDERTAKINGS - CONTRACTOR - JINESHCONTRACTOR ****************");
			Reporter.log(
					"**************** UPDATE MORTGAGE UNDERTAKINGS - CONTRACTOR - JINESHCONTRACTOR ****************");
			log.info("**************** UPDATE MORTGAGE UNDERTAKINGS - CONTRACTOR - JINESHCONTRACTOR ****************");

			try {

				// click on the newly created Mortgage Undertakings
				click("propertyproject_mu_addedmortgageundertakings2_ss1_XPATH");
				ngDriver.waitForAngularRequestsToFinish();
				System.out.println("Clicked on the newly created Mortgage Undertakings.");

				// update the title of the undertaking number
				clear("propertyproject_mu_undertakingnumbertxt_CSS");
				ngDriver.waitForAngularRequestsToFinish();
				System.out.println("Clear the title field.");
				type("propertyproject_mu_undertakingnumbertxt_CSS", data.get("update_undertaking_number2"));
				ngDriver.waitForAngularRequestsToFinish();
				System.out.println("update the title of the undertaking number.");

				// update the title of the undertaking number
				clear("propertyproject_mu_undertakingnumbertxt_CSS");
				ngDriver.waitForAngularRequestsToFinish();
				System.out.println("Clear the title field.");
				type("propertyproject_mu_undertakingnumbertxt_CSS", data.get("undertaking_number2"));
				ngDriver.waitForAngularRequestsToFinish();
				System.out.println("update the title of the undertaking number.");

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

				TestUtil.captureScreenshot();

				// ReportNG
				Reporter.log("<br>" + "The user able to update the Mortgage Undertakings details without the Access: "
						+ "<br>");
				Reporter.log("<a target=\"_blank\" href=" + TestUtil.screenshotName + "><img src="
						+ TestUtil.screenshotName + " height=200 width=200></img></a>");
				Reporter.log("<br>");
				Reporter.log("<br>");

				// Extent Report
				test.log(LogStatus.FAIL,
						" The user able to update the Mortgage Undertakings details without the Access : ");
				test.log(LogStatus.FAIL, test.addScreenCapture(TestUtil.screenshotName));

				System.out.println("The user able to update the Mortgage Undertakings details without the Access.");
				log.info("The user able to update the Mortgage Undertakings details without the Access.");

			} catch (Throwable t) {

				System.out.println("The user not able to update the Mortgage Undertakings details as expected.");
				test.log(LogStatus.INFO, "The user not able to update the Mortgage Undertakings details as expected");
				Reporter.log("The user not able to update the Mortgage Undertakings details as expected");
				log.info("The user not able to update the Mortgage Undertakings details as expected");

				// click on the cancel button
				click("propertyproject_mu_cancelbtn_CSS");
				ngDriver.waitForAngularRequestsToFinish();
				System.out.println("Clicked on the cancel button.");

			}

			// VERIFY THE ROLE ABLE TO DELETE THE MORTGAGE UNDERTAKING DETAILS OR NOT

			System.out.println(
					"**************** DELETE MORTGAGE UNDERTAKINGS - CONTRACTOR - JINESHCONTRACTOR ****************");
			test.log(LogStatus.INFO,
					"**************** DELETE MORTGAGE UNDERTAKINGS - CONTRACTOR - JINESHCONTRACTOR ****************");
			Reporter.log(
					"**************** DELETE MORTGAGE UNDERTAKINGS - CONTRACTOR - JINESHCONTRACTOR ****************");
			log.info("**************** DELETE MORTGAGE UNDERTAKINGS - CONTRACTOR - JINESHCONTRACTOR ****************");

			try {

				boolean mu2 = driver.findElement(By.cssSelector(OR.getProperty("propertyproject_mu_deletebtn_CSS")))
						.isDisplayed();

				if (mu2 == true) {
					TestUtil.captureScreenshot();

					// ReportNG
					Reporter.log(
							"<br>" + "The delete button is displayed in the Mortgage Undertakings without the Access: "
									+ "<br>");
					Reporter.log("<a target=\"_blank\" href=" + TestUtil.screenshotName + "><img src="
							+ TestUtil.screenshotName + " height=200 width=200></img></a>");
					Reporter.log("<br>");
					Reporter.log("<br>");

					// Extent Report
					test.log(LogStatus.FAIL,
							" The delete button is displayed in the Mortgage Undertakings without the Access : ");
					test.log(LogStatus.FAIL, test.addScreenCapture(TestUtil.screenshotName));

					System.out
							.println("The delete button is displayed in the Mortgage Undertakings without the Access.");
					log.info("The delete button is displayed in the Mortgage Undertakings without the Access.");
				}
			} catch (Throwable t) {

				System.out.println("The user not able to delete the Mortgage Undertakings details as expected.");
				test.log(LogStatus.INFO, "The user not able to delete the Mortgage Undertakings details as expected");
				Reporter.log("The user not able to delete the Mortgage Undertakings details as expected");
				log.info("The user not able to delete the Mortgage Undertakings details as expected");

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

			// VERIFY THE ADD, EDIT AND DELETE ACCESS IN THE HR ROLE

			System.out.println(
					"**************** VERIFY THE ADD, EDIT AND DELETE ACCESS IN THE JINESH HR ****************");
			test.log(LogStatus.INFO,
					"**************** VERIFY THE ADD, EDIT AND DELETE ACCESS IN THE JINESH HR ****************");
			Reporter.log("**************** VERIFY THE ADD, EDIT AND DELETE ACCESS IN THE JINESH HR ****************");
			log.info("**************** VERIFY THE ADD, EDIT AND DELETE ACCESS IN THE JINESH HR ****************");

			System.out.println("**************** LOGIN IN JINESH HR USER ****************");
			test.log(LogStatus.INFO, "**************** LOGIN IN JINESH HR USER ****************");
			Reporter.log("**************** LOGIN IN JINESH HR USER ****************");
			log.info("**************** LOGIN IN JINESH HR USER ****************");

			helper.loginAndUpdateSystemCompany(data, "username_3", "password_3", "system_company_1");

			// VERIFY THE JINESH HR ABLE TO ADD THE MORTGAGE UNDERTAKING DETAILS OR NOT

			System.out.println("**************** ADD MORTGAGE UNDERTAKINGS - JINESH HR ****************");
			test.log(LogStatus.INFO, "**************** ADD MORTGAGE UNDERTAKINGS - JINESH HR ****************");
			Reporter.log("**************** ADD MORTGAGE UNDERTAKINGS - JINESH HR ****************");
			log.info("**************** ADD MORTGAGE UNDERTAKINGS - JINESH HR ****************");

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

				try {
					// click on the add button
					click("propertyproject_mu_addbtn_CSS");
					System.out.println("Clicked on the Add button.");
					ngDriver.waitForAngularRequestsToFinish();
					System.out.println("Navigate to the Add Mortgage Undertakings Screen");

					// click on the cancel button
					click("propertyproject_mu_cancelbtn_CSS");
					ngDriver.waitForAngularRequestsToFinish();
					System.out.println("Clicked on the cancel button.");

					TestUtil.captureScreenshot();

					// ReportNG
					Reporter.log("<br>" + "The user able to add the Mortgage Undertakings details without the Access: "
							+ "<br>");
					Reporter.log("<a target=\"_blank\" href=" + TestUtil.screenshotName + "><img src="
							+ TestUtil.screenshotName + " height=200 width=200></img></a>");
					Reporter.log("<br>");
					Reporter.log("<br>");

					// Extent Report
					test.log(LogStatus.FAIL,
							" The user able to add the Mortgage Undertakings details without the Access : ");
					test.log(LogStatus.FAIL, test.addScreenCapture(TestUtil.screenshotName));

					System.out.println("The user able to add the Mortgage Undertakings details without the Access.");
					log.info("The user able to add the Mortgage Undertakings details without the Access.");

				} catch (Throwable t) {

					System.out.println("The user not able to add the Mortgage Undertakings details as expected.");
					test.log(LogStatus.INFO, "The user not able to add the Mortgage Undertakings details as expected");
					Reporter.log("The user not able to add the Mortgage Undertakings details as expected");
					log.info("The user not able to add the Mortgage Undertakings details as expected");

				}

			} catch (Throwable t) {
				verificationFailed();
			}

			// VERIFY THE JINESH HR ABLE TO UPDATE THE MORTGAGE UNDERTAKING DETAILS OR NOT

			System.out.println("**************** UPDATE MORTGAGE UNDERTAKINGS - JINESH HR ****************");
			test.log(LogStatus.INFO, "**************** UPDATE MORTGAGE UNDERTAKINGS - JINESH HR ****************");
			Reporter.log("**************** UPDATE MORTGAGE UNDERTAKINGS - JINESH HR ****************");
			log.info("**************** UPDATE MORTGAGE UNDERTAKINGS - JINESH HR ****************");

			try {

				// click on the newly created Mortgage Undertakings
				click("propertyproject_mu_addedmortgageundertakings2_ss1_XPATH");
				ngDriver.waitForAngularRequestsToFinish();
				System.out.println("Clicked on the newly created Mortgage Undertakings.");

				// update the title of the undertaking number
				clear("propertyproject_mu_undertakingnumbertxt_CSS");
				ngDriver.waitForAngularRequestsToFinish();
				System.out.println("Clear the title field.");
				type("propertyproject_mu_undertakingnumbertxt_CSS", data.get("update_undertaking_number3"));
				ngDriver.waitForAngularRequestsToFinish();
				System.out.println("update the title of the undertaking number.");

				// update the title of the undertaking number
				clear("propertyproject_mu_undertakingnumbertxt_CSS");
				ngDriver.waitForAngularRequestsToFinish();
				System.out.println("Clear the title field.");
				type("propertyproject_mu_undertakingnumbertxt_CSS", data.get("undertaking_number3"));
				ngDriver.waitForAngularRequestsToFinish();
				System.out.println("update the title of the undertaking number.");

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

				TestUtil.captureScreenshot();

				// ReportNG
				Reporter.log("<br>" + "The user able to update the Mortgage Undertakings details without the Access: "
						+ "<br>");
				Reporter.log("<a target=\"_blank\" href=" + TestUtil.screenshotName + "><img src="
						+ TestUtil.screenshotName + " height=200 width=200></img></a>");
				Reporter.log("<br>");
				Reporter.log("<br>");

				// Extent Report
				test.log(LogStatus.FAIL,
						" The user able to update the Mortgage Undertakings details without the Access : ");
				test.log(LogStatus.FAIL, test.addScreenCapture(TestUtil.screenshotName));

				System.out.println("The user able to update the Mortgage Undertakings details without the Access.");
				log.info("The user able to update the Mortgage Undertakings details without the Access.");

			} catch (Throwable t) {

				System.out.println("The user not able to update the Mortgage Undertakings details as expected.");
				test.log(LogStatus.INFO, "The user not able to update the Mortgage Undertakings details as expected");
				Reporter.log("The user not able to update the Mortgage Undertakings details as expected");
				log.info("The user not able to update the Mortgage Undertakings details as expected");

				// click on the cancel button
				click("propertyproject_mu_cancelbtn_CSS");
				ngDriver.waitForAngularRequestsToFinish();
				System.out.println("Clicked on the cancel button.");

			}

			// VERIFY THE ROLE ABLE TO DELETE THE MORTGAGE UNDERTAKING DETAILS OR NOT

			System.out.println("**************** DELETE MORTGAGE UNDERTAKINGS - JINESH HR ****************");
			test.log(LogStatus.INFO, "**************** DELETE MORTGAGE UNDERTAKINGS - JINESH HR ****************");
			Reporter.log("**************** DELETE MORTGAGE UNDERTAKINGS - JINESH HR ****************");
			log.info("**************** DELETE MORTGAGE UNDERTAKINGS - JINESH HR ****************");

			try {

				boolean mu3 = driver.findElement(By.cssSelector(OR.getProperty("propertyproject_mu_deletebtn_CSS")))
						.isDisplayed();

				if (mu3 == true) {
					TestUtil.captureScreenshot();

					// ReportNG
					Reporter.log(
							"<br>" + "The delete button is displayed in the Mortgage Undertakings without the Access: "
									+ "<br>");
					Reporter.log("<a target=\"_blank\" href=" + TestUtil.screenshotName + "><img src="
							+ TestUtil.screenshotName + " height=200 width=200></img></a>");
					Reporter.log("<br>");
					Reporter.log("<br>");

					// Extent Report
					test.log(LogStatus.FAIL,
							" The delete button is displayed in the Mortgage Undertakings without the Access : ");
					test.log(LogStatus.FAIL, test.addScreenCapture(TestUtil.screenshotName));

					System.out
							.println("The delete button is displayed in the Mortgage Undertakings without the Access.");
					log.info("The delete button is displayed in the Mortgage Undertakings without the Access.");
				}
			} catch (Throwable t) {

				System.out.println("The user not able to delete the Mortgage Undertakings details as expected.");
				test.log(LogStatus.INFO, "The user not able to delete the Mortgage Undertakings details as expected");
				Reporter.log("The user not able to delete the Mortgage Undertakings details as expected");
				log.info("The user not able to delete the Mortgage Undertakings details as expected");

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

			System.out.println("**************** DELETE THE CREATED MORTGAGE UNDERTAKING ****************");
			test.log(LogStatus.INFO, "**************** DELETE THE CREATED MORTGAGE UNDERTAKING ****************");
			Reporter.log("**************** DELETE THE CREATED MORTGAGE UNDERTAKING ****************");
			log.info("**************** DELETE THE CREATED MORTGAGE UNDERTAKING ****************");

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

			// verify newly created MORTGAGE UNDERTAKINGS - JINESH is deleted or not

			helper.deleteVerification("propertyproject_mu_addedmortgageundertakings_ss1_XPATH",
					"UNDERTAKINGPERMISSIONONE2021");

			// verify newly created MORTGAGE UNDERTAKINGS - JINESHCONTRACTOR is deleted or
			// not

			helper.deleteVerification("propertyproject_mu_addedmortgageundertakings2_ss1_XPATH",
					"UNDERTAKINGPERMISSIONTWO2021");

			// verify newly created MORTGAGE UNDERTAKINGS - JINESHHR is deleted or not

			helper.deleteVerification("propertyproject_mu_addedmortgageundertakings3_ss1_XPATH",
					"UNDERTAKINGPERMISSIONTHREE2021");

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

			// RESET THE VIEW MORTGAGE UNDERTAKING PERMISSION

			helper.resetPermission(data, "security_setting_1", "propertyproject_securitysettings1_XPATH");

			// RESET THE ADD MORTGAGE UNDERTAKING PERMISSION

			helper.resetPermission(data, "security_setting_2", "propertyproject_securitysettings2_XPATH");

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