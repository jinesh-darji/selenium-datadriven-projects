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

public class RR4918PropertyProjectOneTest extends TestBase {

	@Test(dataProviderClass = TestUtil.class, dataProvider = "dp")
	public void rR4918PropertyProjectOneTest(Hashtable<String, String> data) throws IOException, InterruptedException {

		execution(data, "rR4918PropertyProjectOneTest");

		// APPLY THE SECURITY SETTING TO MUNICIPAL ORDERS OF THE USER/ROLE ACCESS TO
		// THIS MUST ONLY HAVE PERMISSION TO PERFORM ACTIONS - ADD.

		System.out.println(
				"APPLY THE SECURITY SETTING TO MUNICIPAL ORDERS OF THE USER/ROLE ACCESS TO THIS MUST ONLY HAVE PERMISSION TO PERFORM ACTIONS - ADD.");
		test.log(LogStatus.INFO,
				"APPLY THE SECURITY SETTING TO MUNICIPAL ORDERS OF THE USER/ROLE ACCESS TO THIS MUST ONLY HAVE PERMISSION TO PERFORM ACTIONS - ADD.");
		Reporter.log(
				"APPLY THE SECURITY SETTING TO MUNICIPAL ORDERS OF THE USER/ROLE ACCESS TO THIS MUST ONLY HAVE PERMISSION TO PERFORM ACTIONS - ADD.");
		log.info(
				"APPLY THE SECURITY SETTING TO MUNICIPAL ORDERS OF THE USER/ROLE ACCESS TO THIS MUST ONLY HAVE PERMISSION TO PERFORM ACTIONS - ADD.");

		Helper helper = new Helper();
		
		// refresh the page
		driver.navigate().refresh();
		Thread.sleep(5000);
		driver.navigate().refresh();

		System.out.println("Navigate to the Home Screen i.e. Property List Screen.");

		System.out.println(
				"*************** ADD SECURITY SETTINGS OF VIEW / ADD MUNICIPAL ORDERS TO USER/ROLE ACCESS *************");
		test.log(LogStatus.INFO,
				"*************** ADD SECURITY SETTINGS OF VIEW / ADD MUNICIPAL ORDERS TO USER/ROLE ACCESS *************");
		Reporter.log(
				"*************** ADD SECURITY SETTINGS OF VIEW / ADD MUNICIPAL ORDERS TO USER/ROLE ACCESS *************");
		log.info(
				"*************** ADD SECURITY SETTINGS OF VIEW / ADD MUNICIPAL ORDERS TO USER/ROLE ACCESS *************");

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

			// APPLY THE VIEW MUNICIPAL ORDERS PERMISSION

			helper.addPermissionTwoUsersRole(data, "security_setting_9", "propertyproject_securitysettings9_XPATH");

			// APPLY THE ADD MUNICIPAL ORDERS PERMISSION

			helper.addPermissionOneUsersRole(data, "security_setting_10", "propertyproject_securitysettings10_XPATH");

			// RESET THE EDIT MUNICIPAL ORDERS PERMISSION

			helper.resetPermission(data, "security_setting_11", "propertyproject_securitysettings11_XPATH");

			// RESET THE DELETE MUNICIPAL ORDERS PERMISSION

			helper.resetPermission(data, "security_setting_12", "propertyproject_securitysettings12_XPATH");

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

			// VERIFY THE JINESH ABLE TO ADD THE MUNICIPAL ORDERS DETAILS OR NOT

			try {
				System.out.println("**************** ADD MUNICIPAL ORDERS - JINESH ****************");
				test.log(LogStatus.INFO, "**************** ADD MUNICIPAL ORDERS - JINESH ****************");
				Reporter.log("**************** ADD MUNICIPAL ORDERS - JINESH ****************");
				log.info("**************** ADD MUNICIPAL ORDERS - JINESH ****************");

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

				// click on the Municipal Orders
				click("propertyproject_municipalordersoption_XPATH");
				System.out.println("Clicked on the Municipal Orders option.");
				ngDriver.waitForAngularRequestsToFinish();

				// ADD RECORD - MUNICIPAL ORDERS

				// click on the add button
				click("propertyproject_mu_addbtn_CSS");
				System.out.println("Clicked on the Add button.");
				ngDriver.waitForAngularRequestsToFinish();
				System.out.println("Navigate to the Add Municipal Orders Screen");

				// enter the project reference
				type("propertyproject_mo_projectnumbertxt_CSS", data.get("project_reference"));
				System.out.println("Entered the project reference.");
				ngDriver.waitForAngularRequestsToFinish();

				// select the Municipality
				select("propertyproject_mo_municipalitydd_CSS", data.get("municipality"));
				ngDriver.waitForAngularRequestsToFinish();
				System.out.println("Selected the Municipality.");

				// click on the save button
				click("propertyproject_mo_savebtn_CSS");
				ngDriver.waitForAngularRequestsToFinish();
				System.out.println("Clicked on the save button.");

				// wait for the element
				explicitWaitClickable("closetoastmsg_CSS");

				// click on the toaster close button
				click("closetoastmsg_CSS");
				ngDriver.waitForAngularRequestsToFinish();
				System.out.println("Clicked on the toaster close button.");

				// wait for the element
				explicitWaitClickable("propertyproject_mo_canceltask_CSS");

				// click on the cancel button
				click("propertyproject_mo_canceltask_CSS");
				ngDriver.waitForAngularRequestsToFinish();
				System.out.println("Clicked on the cancel button.");

				// verification of the MUNICIPAL ORDERS is added or not
				switchVerification("propertyproject_mo_addedmunicipalorders_ss1_XPATH", "MUNICIPALORDERSONE2021",
						"MUNICIPAL ORDERS is not displayed successfully.");

			} catch (Throwable t) {
				verificationFailed();
			}

			// VERIFY THE USER ABLE TO UPDATE THE MUNICIPAL ORDERS DETAILS OR NOT

			System.out.println("**************** UPDATE MUNICIPAL ORDERS - JINESH ****************");
			test.log(LogStatus.INFO, "**************** UPDATE MUNICIPAL ORDERS - JINESH ****************");
			Reporter.log("**************** UPDATE MUNICIPAL ORDERS - JINESH ****************");
			log.info("**************** UPDATE MUNICIPAL ORDERS - JINESH ****************");

			try {

				// click on the newly created MUNICIPAL ORDERS
				click("propertyproject_mo_addedmunicipalorders_ss1_XPATH");
				ngDriver.waitForAngularRequestsToFinish();
				System.out.println("Clicked on the newly created MUNICIPAL ORDERS.");

				// update the title of the project number
				clear("propertyproject_mo_projectnumbertxt_CSS");
				ngDriver.waitForAngularRequestsToFinish();
				System.out.println("Clear the title field.");
				type("propertyproject_mo_projectnumbertxt_CSS", data.get("update_project_reference"));
				ngDriver.waitForAngularRequestsToFinish();
				System.out.println("update the title of the project number.");

				// update the title of the project number
				clear("propertyproject_mo_projectnumbertxt_CSS");
				ngDriver.waitForAngularRequestsToFinish();
				System.out.println("Clear the title field.");
				type("propertyproject_mo_projectnumbertxt_CSS", data.get("project_reference"));
				ngDriver.waitForAngularRequestsToFinish();
				System.out.println("update the title of the project number.");

				// click on the update button
				click("propertyproject_mo_updatebtn_CSS");
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
				Reporter.log(
						"<br>" + "The user able to update the MUNICIPAL ORDERS details without the Access: " + "<br>");
				Reporter.log("<a target=\"_blank\" href=" + TestUtil.screenshotName + "><img src="
						+ TestUtil.screenshotName + " height=200 width=200></img></a>");
				Reporter.log("<br>");
				Reporter.log("<br>");

				// Extent Report
				test.log(LogStatus.FAIL, " The user able to update the MUNICIPAL ORDERS details without the Access : ");
				test.log(LogStatus.FAIL, test.addScreenCapture(TestUtil.screenshotName));

				System.out.println("The user able to update the MUNICIPAL ORDERS details without the Access.");
				log.info("The user able to update the MUNICIPAL ORDERS details without the Access.");

			} catch (Throwable t) {

				System.out.println("The user not able to update the MUNICIPAL ORDERS details as expected.");
				test.log(LogStatus.INFO, "The user not able to update the MUNICIPAL ORDERS details as expected");
				Reporter.log("The user not able to update the MUNICIPAL ORDERS details as expected");
				log.info("The user not able to update the MUNICIPAL ORDERS details as expected");

				// click on the cancel button
				click("propertyproject_mo_cancelbtn_CSS");
				ngDriver.waitForAngularRequestsToFinish();
				System.out.println("Clicked on the cancel button.");

			}

			// VERIFY THE USER ABLE TO DELETE THE MUNICIPAL ORDERS DETAILS OR NOT

			System.out.println("**************** DELETE MUNICIPAL ORDERS - JINESH ****************");
			test.log(LogStatus.INFO, "**************** DELETE MUNICIPAL ORDERS - JINESH ****************");
			Reporter.log("**************** DELETE MUNICIPAL ORDERS - JINESH ****************");
			log.info("**************** DELETE MUNICIPAL ORDERS - JINESH ****************");

			try {

				boolean mu1 = driver.findElement(By.cssSelector(OR.getProperty("propertyproject_mo_deletebtn_CSS")))
						.isDisplayed();

				if (mu1 == true) {
					TestUtil.captureScreenshot();

					// ReportNG
					Reporter.log("<br>" + "The delete button is displayed in the MUNICIPAL ORDERS without the Access: "
							+ "<br>");
					Reporter.log("<a target=\"_blank\" href=" + TestUtil.screenshotName + "><img src="
							+ TestUtil.screenshotName + " height=200 width=200></img></a>");
					Reporter.log("<br>");
					Reporter.log("<br>");

					// Extent Report
					test.log(LogStatus.FAIL,
							" The delete button is displayed in the MUNICIPAL ORDERS without the Access : ");
					test.log(LogStatus.FAIL, test.addScreenCapture(TestUtil.screenshotName));

					System.out.println("The delete button is displayed in the MUNICIPAL ORDERS without the Access.");
					log.info("The delete button is displayed in the MUNICIPAL ORDERS without the Access.");
				}

			} catch (Throwable t) {

				System.out.println("The user not able to delete the MUNICIPAL ORDERS details as expected.");
				test.log(LogStatus.INFO, "The user not able to delete the MUNICIPAL ORDERS details as expected");
				Reporter.log("The user not able to delete the MUNICIPAL ORDERS details as expected");
				log.info("The user not able to delete the MUNICIPAL ORDERS details as expected");

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

			// VERIFY THE CONTRACTOR - JINESHCONTRACTOR ABLE TO ADD THE MUNICIPAL ORDERS
			// DETAILS OR NOT

			System.out
					.println("**************** ADD MUNICIPAL ORDERS - CONTRACTOR - JINESHCONTRACTOR ****************");
			test.log(LogStatus.INFO,
					"**************** ADD MUNICIPAL ORDERS - CONTRACTOR - JINESHCONTRACTOR ****************");
			Reporter.log("**************** ADD MUNICIPAL ORDERS - CONTRACTOR - JINESHCONTRACTOR ****************");
			log.info("**************** ADD MUNICIPAL ORDERS - CONTRACTOR - JINESHCONTRACTOR ****************");

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

				// click on the MUNICIPAL ORDERS
				click("propertyproject_municipalordersoption_XPATH");
				System.out.println("Clicked on the MUNICIPAL ORDERS option.");
				ngDriver.waitForAngularRequestsToFinish();

				// ADD RECORD - MUNICIPAL ORDERS

				// click on the add button
				click("propertyproject_mu_addbtn_CSS");
				System.out.println("Clicked on the Add button.");
				ngDriver.waitForAngularRequestsToFinish();
				System.out.println("Navigate to the Add Municipal Orders Screen");

				// enter the project reference
				type("propertyproject_mo_projectnumbertxt_CSS", data.get("project_reference2"));
				System.out.println("Entered the project reference.");
				ngDriver.waitForAngularRequestsToFinish();

				// select the Municipality
				select("propertyproject_mo_municipalitydd_CSS", data.get("municipality"));
				ngDriver.waitForAngularRequestsToFinish();
				System.out.println("Selected the Municipality.");

				// click on the save button
				click("propertyproject_mo_savebtn_CSS");
				ngDriver.waitForAngularRequestsToFinish();
				System.out.println("Clicked on the save button.");

				// wait for the element
				explicitWaitClickable("closetoastmsg_CSS");

				// click on the toaster close button
				click("closetoastmsg_CSS");
				ngDriver.waitForAngularRequestsToFinish();
				System.out.println("Clicked on the toaster close button.");

				// wait for the element
				explicitWaitClickable("propertyproject_mo_cancelbtn_CSS");

				// click on the cancel button
				click("propertyproject_mo_cancelbtn_CSS");
				ngDriver.waitForAngularRequestsToFinish();
				System.out.println("Clicked on the cancel button.");

				// verification of the MUNICIPAL ORDERS is added or not
				switchVerification("propertyproject_mo_addedmunicipalorders2_ss1_XPATH", "MUNICIPALORDERSTWO2021",
						"MUNICIPAL ORDERS is not displayed successfully.");

			} catch (Throwable t) {
				verificationFailed();
			}

			// VERIFY THE ROLE ABLE TO UPDATE THE MUNICIPAL ORDERS DETAILS OR NOT

			System.out.println(
					"**************** UPDATE MUNICIPAL ORDERS - CONTRACTOR - JINESHCONTRACTOR ****************");
			test.log(LogStatus.INFO,
					"**************** UPDATE MUNICIPAL ORDERS - CONTRACTOR - JINESHCONTRACTOR ****************");
			Reporter.log("**************** UPDATE MUNICIPAL ORDERS - CONTRACTOR - JINESHCONTRACTOR ****************");
			log.info("**************** UPDATE MUNICIPAL ORDERS - CONTRACTOR - JINESHCONTRACTOR ****************");

			try {

				// click on the newly created MUNICIPAL ORDERS
				click("propertyproject_mo_addedmunicipalorders2_ss1_XPATH");
				ngDriver.waitForAngularRequestsToFinish();
				System.out.println("Clicked on the newly created MUNICIPAL ORDERS.");

				// update the title of the project number
				clear("propertyproject_mo_projectnumbertxt_CSS");
				ngDriver.waitForAngularRequestsToFinish();
				System.out.println("Clear the title field.");
				type("propertyproject_mo_projectnumbertxt_CSS", data.get("update_project_reference2"));
				ngDriver.waitForAngularRequestsToFinish();
				System.out.println("update the title of the project number.");

				// update the title of the project number
				clear("propertyproject_mo_projectnumbertxt_CSS");
				ngDriver.waitForAngularRequestsToFinish();
				System.out.println("Clear the title field.");
				type("propertyproject_mo_projectnumbertxt_CSS", data.get("project_reference2"));
				ngDriver.waitForAngularRequestsToFinish();
				System.out.println("update the title of the project number.");

				// click on the update button
				click("propertyproject_mo_updatebtn_CSS");
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
				Reporter.log(
						"<br>" + "The user able to update the MUNICIPAL ORDERS details without the Access: " + "<br>");
				Reporter.log("<a target=\"_blank\" href=" + TestUtil.screenshotName + "><img src="
						+ TestUtil.screenshotName + " height=200 width=200></img></a>");
				Reporter.log("<br>");
				Reporter.log("<br>");

				// Extent Report
				test.log(LogStatus.FAIL, " The user able to update the MUNICIPAL ORDERS details without the Access : ");
				test.log(LogStatus.FAIL, test.addScreenCapture(TestUtil.screenshotName));

				System.out.println("The user able to update the MUNICIPAL ORDERS details without the Access.");
				log.info("The user able to update the MUNICIPAL ORDERS details without the Access.");

			} catch (Throwable t) {

				System.out.println("The user not able to update the MUNICIPAL ORDERS details as expected.");
				test.log(LogStatus.INFO, "The user not able to update the MUNICIPAL ORDERS details as expected");
				Reporter.log("The user not able to update the MUNICIPAL ORDERS details as expected");
				log.info("The user not able to update the MUNICIPAL ORDERS details as expected");

				// click on the cancel button
				click("propertyproject_mo_cancelbtn_CSS");
				ngDriver.waitForAngularRequestsToFinish();
				System.out.println("Clicked on the cancel button.");

			}

			// VERIFY THE ROLE ABLE TO DELETE THE MUNICIPAL ORDERS DETAILS OR NOT

			System.out.println(
					"**************** DELETE MUNICIPAL ORDERS - CONTRACTOR - JINESHCONTRACTOR ****************");
			test.log(LogStatus.INFO,
					"**************** DELETE MUNICIPAL ORDERS - CONTRACTOR - JINESHCONTRACTOR ****************");
			Reporter.log("**************** DELETE MUNICIPAL ORDERS - CONTRACTOR - JINESHCONTRACTOR ****************");
			log.info("**************** DELETE MUNICIPAL ORDERS - CONTRACTOR - JINESHCONTRACTOR ****************");

			try {

				boolean mu2 = driver.findElement(By.cssSelector(OR.getProperty("propertyproject_mo_deletebtn_CSS")))
						.isDisplayed();

				if (mu2 == true) {
					TestUtil.captureScreenshot();

					// ReportNG
					Reporter.log("<br>" + "The delete button is displayed in the MUNICIPAL ORDERS without the Access: "
							+ "<br>");
					Reporter.log("<a target=\"_blank\" href=" + TestUtil.screenshotName + "><img src="
							+ TestUtil.screenshotName + " height=200 width=200></img></a>");
					Reporter.log("<br>");
					Reporter.log("<br>");

					// Extent Report
					test.log(LogStatus.FAIL,
							" The delete button is displayed in the MUNICIPAL ORDERS without the Access : ");
					test.log(LogStatus.FAIL, test.addScreenCapture(TestUtil.screenshotName));

					System.out.println("The delete button is displayed in the MUNICIPAL ORDERS without the Access.");
					log.info("The delete button is displayed in the MUNICIPAL ORDERS without the Access.");
				}
			} catch (Throwable t) {

				System.out.println("The user not able to delete the MUNICIPAL ORDERS details as expected.");
				test.log(LogStatus.INFO, "The user not able to delete the MUNICIPAL ORDERS details as expected");
				Reporter.log("The user not able to delete the MUNICIPAL ORDERS details as expected");
				log.info("The user not able to delete the MUNICIPAL ORDERS details as expected");

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

			// VERIFY THE JINESH HR ABLE TO ADD THE MUNICIPAL ORDERS DETAILS OR NOT

			System.out.println("**************** ADD MUNICIPAL ORDERS - JINESH HR ****************");
			test.log(LogStatus.INFO, "**************** ADD MUNICIPAL ORDERS - JINESH HR ****************");
			Reporter.log("**************** ADD MUNICIPAL ORDERS - JINESH HR ****************");
			log.info("**************** ADD MUNICIPAL ORDERS - JINESH HR ****************");

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

				// click on the MUNICIPAL ORDERS
				click("propertyproject_municipalordersoption_XPATH");
				System.out.println("Clicked on the MUNICIPAL ORDERS option.");
				ngDriver.waitForAngularRequestsToFinish();

				// ADD RECORD - MUNICIPAL ORDERS

				try {
					// click on the add button
					click("propertyproject_mo_addbtn_CSS");
					System.out.println("Clicked on the Add button.");
					ngDriver.waitForAngularRequestsToFinish();
					System.out.println("Navigate to the Add MUNICIPAL ORDERS Screen");

					// click on the cancel button
					click("propertyproject_mo_cancelbtn_CSS");
					ngDriver.waitForAngularRequestsToFinish();
					System.out.println("Clicked on the cancel button.");

					TestUtil.captureScreenshot();

					// ReportNG
					Reporter.log(
							"<br>" + "The user able to add the MUNICIPAL ORDERS details without the Access: " + "<br>");
					Reporter.log("<a target=\"_blank\" href=" + TestUtil.screenshotName + "><img src="
							+ TestUtil.screenshotName + " height=200 width=200></img></a>");
					Reporter.log("<br>");
					Reporter.log("<br>");

					// Extent Report
					test.log(LogStatus.FAIL,
							" The user able to add the MUNICIPAL ORDERS details without the Access : ");
					test.log(LogStatus.FAIL, test.addScreenCapture(TestUtil.screenshotName));

					System.out.println("The user able to add the MUNICIPAL ORDERS details without the Access.");
					log.info("The user able to add the MUNICIPAL ORDERS details without the Access.");

				} catch (Throwable t) {

					System.out.println("The user not able to add the MUNICIPAL ORDERS details as expected.");
					test.log(LogStatus.INFO, "The user not able to add the MUNICIPAL ORDERS details as expected");
					Reporter.log("The user not able to add the MUNICIPAL ORDERS details as expected");
					log.info("The user not able to add the MUNICIPAL ORDERS details as expected");

				}

			} catch (Throwable t) {
				verificationFailed();
			}

			// VERIFY THE JINESH HR ABLE TO UPDATE THE MUNICIPAL ORDERS DETAILS OR NOT

			System.out.println("**************** UPDATE MUNICIPAL ORDERS - JINESH HR ****************");
			test.log(LogStatus.INFO, "**************** UPDATE MUNICIPAL ORDERS - JINESH HR ****************");
			Reporter.log("**************** UPDATE MUNICIPAL ORDERS - JINESH HR ****************");
			log.info("**************** UPDATE MUNICIPAL ORDERS - JINESH HR ****************");

			try {

				// click on the newly created MUNICIPAL ORDERS
				click("propertyproject_mo_addedmunicipalorders2_ss1_XPATH");
				ngDriver.waitForAngularRequestsToFinish();
				System.out.println("Clicked on the newly created MUNICIPAL ORDERS.");

				// update the title of the project number
				clear("propertyproject_mo_projectnumbertxt_CSS");
				ngDriver.waitForAngularRequestsToFinish();
				System.out.println("Clear the title field.");
				type("propertyproject_mo_projectnumbertxt_CSS", data.get("update_project_reference3"));
				ngDriver.waitForAngularRequestsToFinish();
				System.out.println("update the title of the project number.");

				// update the title of the project number
				clear("propertyproject_mo_projectnumbertxt_CSS");
				ngDriver.waitForAngularRequestsToFinish();
				System.out.println("Clear the title field.");
				type("propertyproject_mo_projectnumbertxt_CSS", data.get("project_reference3"));
				ngDriver.waitForAngularRequestsToFinish();
				System.out.println("update the title of the project number.");

				// click on the update button
				click("propertyproject_mo_updatebtn_CSS");
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
				Reporter.log(
						"<br>" + "The user able to update the MUNICIPAL ORDERS details without the Access: " + "<br>");
				Reporter.log("<a target=\"_blank\" href=" + TestUtil.screenshotName + "><img src="
						+ TestUtil.screenshotName + " height=200 width=200></img></a>");
				Reporter.log("<br>");
				Reporter.log("<br>");

				// Extent Report
				test.log(LogStatus.FAIL, " The user able to update the MUNICIPAL ORDERS details without the Access : ");
				test.log(LogStatus.FAIL, test.addScreenCapture(TestUtil.screenshotName));

				System.out.println("The user able to update the MUNICIPAL ORDERS details without the Access.");
				log.info("The user able to update the MUNICIPAL ORDERS details without the Access.");

			} catch (Throwable t) {

				System.out.println("The user not able to update the MUNICIPAL ORDERS details as expected.");
				test.log(LogStatus.INFO, "The user not able to update the MUNICIPAL ORDERS details as expected");
				Reporter.log("The user not able to update the MUNICIPAL ORDERS details as expected");
				log.info("The user not able to update the MUNICIPAL ORDERS details as expected");

				// click on the cancel button
				click("propertyproject_mo_cancelbtn_CSS");
				ngDriver.waitForAngularRequestsToFinish();
				System.out.println("Clicked on the cancel button.");

			}

			// VERIFY THE ROLE ABLE TO DELETE THE MUNICIPAL ORDERS DETAILS OR NOT

			System.out.println("**************** DELETE MUNICIPAL ORDERS - JINESH HR ****************");
			test.log(LogStatus.INFO, "**************** DELETE MUNICIPAL ORDERS - JINESH HR ****************");
			Reporter.log("**************** DELETE MUNICIPAL ORDERS - JINESH HR ****************");
			log.info("**************** DELETE MUNICIPAL ORDERS - JINESH HR ****************");

			try {

				boolean mu3 = driver.findElement(By.cssSelector(OR.getProperty("propertyproject_mo_deletebtn_CSS")))
						.isDisplayed();

				if (mu3 == true) {
					TestUtil.captureScreenshot();

					// ReportNG
					Reporter.log("<br>" + "The delete button is displayed in the MUNICIPAL ORDERS without the Access: "
							+ "<br>");
					Reporter.log("<a target=\"_blank\" href=" + TestUtil.screenshotName + "><img src="
							+ TestUtil.screenshotName + " height=200 width=200></img></a>");
					Reporter.log("<br>");
					Reporter.log("<br>");

					// Extent Report
					test.log(LogStatus.FAIL,
							" The delete button is displayed in the MUNICIPAL ORDERS without the Access : ");
					test.log(LogStatus.FAIL, test.addScreenCapture(TestUtil.screenshotName));

					System.out.println("The delete button is displayed in the MUNICIPAL ORDERS without the Access.");
					log.info("The delete button is displayed in the MUNICIPAL ORDERS without the Access.");
				}
			} catch (Throwable t) {

				System.out.println("The user not able to delete the MUNICIPAL ORDERS details as expected.");
				test.log(LogStatus.INFO, "The user not able to delete the MUNICIPAL ORDERS details as expected");
				Reporter.log("The user not able to delete the MUNICIPAL ORDERS details as expected");
				log.info("The user not able to delete the MUNICIPAL ORDERS details as expected");

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

		// DELETE THE CREATED MUNICIPAL ORDERS AND RESET THE GIVEN PERMISSIONS

		System.out.println(
				"**************** DELETE THE CREATED MUNICIPAL ORDERS AND RESET THE GIVEN PERMISSIONS ****************");
		test.log(LogStatus.INFO,
				"**************** DELETE THE CREATED MUNICIPAL ORDERS AND RESET THE GIVEN PERMISSIONS ****************");
		Reporter.log(
				"**************** DELETE THE CREATED MUNICIPAL ORDERS AND RESET THE GIVEN PERMISSIONS ****************");
		log.info(
				"**************** DELETE THE CREATED MUNICIPAL ORDERS AND RESET THE GIVEN PERMISSIONS ****************");

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

			// click on the MUNICIPAL ORDERS
			click("propertyproject_municipalordersoption_XPATH");
			System.out.println("Clicked on the MUNICIPAL ORDERS option.");
			ngDriver.waitForAngularRequestsToFinish();

			System.out.println("**************** DELETE THE CREATED MUNICIPAL ORDERS ****************");
			test.log(LogStatus.INFO, "**************** DELETE THE CREATED MUNICIPAL ORDERS ****************");
			Reporter.log("**************** DELETE THE CREATED MUNICIPAL ORDERS ****************");
			log.info("**************** DELETE THE CREATED MUNICIPAL ORDERS ****************");

			// click on the delete button of the newly created MUNICIPAL ORDERS
			List<WebElement> links = driver.findElements(By.xpath("//tr"));
			int count = links.size();
			System.out.println("Number of links are:" + count);

			for (int i = 0; i < count - 1; i++) {

				// wait for the element
				explicitWaitClickable("propertyproject_mo_deletebtn_CSS");

				// delete the all the MUNICIPAL ORDERS
				click("propertyproject_mo_deletebtn_CSS");
				System.out.println("Deleted the all the MUNICIPAL ORDERS");
				ngDriver.waitForAngularRequestsToFinish();

				// wait for the element
				explicitWaitClickable("propertyproject_mo_confirmationdeletebtn_CSS");

				// click on the delete button of confirmation
				click("propertyproject_mo_confirmationdeletebtn_CSS");
				System.out.println("Clicked on the delete button of confirmation.");
				ngDriver.waitForAngularRequestsToFinish();

				// wait for the element
				explicitWaitClickable("closetoastmsg_CSS");

				// click on the toaster close button
				click("closetoastmsg_CSS");
				ngDriver.waitForAngularRequestsToFinish();
				System.out.println("Clicked on the toaster close button.");

			}

			// verify newly created MUNICIPAL ORDERS - JINESH is deleted or not

			helper.deleteVerification("propertyproject_mo_addedmunicipalorders_ss1_XPATH", "MUNICIPALORDERSONE2021");

			// verify newly created MUNICIPAL ORDERS - JINESHCONTRACTOR is deleted or
			// not

			helper.deleteVerification("propertyproject_mo_addedmunicipalorders2_ss1_XPATH", "MUNICIPALORDERSTWO2021");

			// verify newly created MUNICIPAL ORDERS - JINESHHR is deleted or not

			helper.deleteVerification("propertyproject_mo_addedmunicipalorders3_ss1_XPATH", "MUNICIPALORDERSTHREE2021");

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

			// RESET THE VIEW MUNICIPAL ORDERS PERMISSION

			helper.resetPermission(data, "security_setting_9", "propertyproject_securitysettings9_XPATH");

			// RESET THE ADD MUNICIPAL ORDERS PERMISSION

			helper.resetPermission(data, "security_setting_10", "propertyproject_securitysettings10_XPATH");

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