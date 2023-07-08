package testcases.E2Etestcasesuite.propertyprojectmodule;

import java.io.IOException;
import java.util.Hashtable;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.SkipException;
import org.testng.annotations.Test;

import com.relevantcodes.extentreports.LogStatus;

import base.Helper;
import base.TestBase;
import utilities.TestUtil;

public class RR4931PropertyProjectOneTest extends TestBase {

	@Test(dataProviderClass = TestUtil.class, dataProvider = "dp")
	public void rR4931PropertyProjectOneTest(Hashtable<String, String> data) throws IOException, InterruptedException {

		execution(data, "rR4931PropertyProjectOneTest");

		// APPLY THE "PERMISSION TO DOWNLOAD TASK ATTACHMENTS" SECURITY SETTINGS TO
		// THE ATTACHMENT FOR THE REPAIR (TASK)

		System.out.println(
				"APPLY THE \"PERMISSION TO DOWNLOAD TASK ATTACHMENTS\" SECURITY SETTINGS TO THE ATTACHMENT FOR THE REPAIR (TASK).");
		test.log(LogStatus.INFO,
				"APPLY THE \"PERMISSION TO DOWNLOAD TASK ATTACHMENTS\" SECURITY SETTINGS TO THE ATTACHMENT FOR THE REPAIR (TASK).");
		Reporter.log(
				"APPLY THE \"PERMISSION TO DOWNLOAD TASK ATTACHMENTS\" SECURITY SETTINGS TO THE ATTACHMENT FOR THE REPAIR (TASK).");
		log.info(
				"APPLY THE \"PERMISSION TO DOWNLOAD TASK ATTACHMENTS\" SECURITY SETTINGS TO THE ATTACHMENT FOR THE REPAIR (TASK).");

		Helper helper = new Helper();

		// refresh the page
		driver.navigate().refresh();
		Thread.sleep(5000);
		driver.navigate().refresh();

		System.out.println("Navigate to the Home Screen i.e. Property List Screen.");

		System.out.println("*************** SET SECURITY SETTINGS FOR THE ATTACHMENTS *************");
		test.log(LogStatus.INFO, "*************** SET SECURITY SETTINGS FOR THE ATTACHMENTS *************");
		Reporter.log("*************** SET SECURITY SETTINGS FOR THE ATTACHMENTS *************");
		log.info("*************** SET SECURITY SETTINGS FOR THE ATTACHMENTS *************");

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

			// APPLY THE PERMISSION TO RESTRICTED ATTACHMENT

			helper.addPermissionOneUsersRole(data, "security_setting_attachment_1",
					"propertyproject_securitysettings_attachments1_XPATH");

			// RESET THE PERMISSION TO MARK ATTACHMENTS AS RESTRICTED

			helper.resetPermission(data, "security_setting_attachment_2",
					"propertyproject_securitysettings_attachments2_XPATH");

			// RESET THE PERMISSION TO MODIFY TASK ATTACHMENTS

			helper.resetPermission(data, "security_setting_attachment_3",
					"propertyproject_securitysettings_attachments3_XPATH");

			// RESET THE PERMISSION TO VIEW RESTRICTED ATTACHMENTS

			helper.resetPermission(data, "security_setting_attachment_4",
					"propertyproject_securitysettings_attachments4_XPATH");

		} catch (Throwable t) {
			verificationFailed();
		}

		System.out.println(
				"*************** ADD SECURITY SETTINGS OF VIEW / ADD MORTGAGE UNDERTAKING TO USER/ROLE ACCESS *************");
		test.log(LogStatus.INFO,
				"*************** ADD SECURITY SETTINGS OF VIEW / ADD MORTGAGE UNDERTAKING TO USER/ROLE ACCESS *************");
		Reporter.log(
				"*************** ADD SECURITY SETTINGS OF VIEW / ADD MORTGAGE UNDERTAKING TO USER/ROLE ACCESS *************");
		log.info(
				"*************** ADD SECURITY SETTINGS OF VIEW / ADD MORTGAGE UNDERTAKING TO USER/ROLE ACCESS *************");

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

			// click on the burger menu
			click("menubtn_CSS");
			System.out.println("Clicked on the burger menu button successfully!!!");
			ngDriver.waitForAngularRequestsToFinish();

			// wait for the element
			explicitWaitClickable("propertyproject_mortgageundertakingsoption_XPATH");

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
			explicitWaitClickable("propertyproject_mu_newrepairbtn_BTNTEXT");

			// click on the new repair button
			click("propertyproject_mu_newrepairbtn_BTNTEXT");
			ngDriver.waitForAngularRequestsToFinish();
			System.out.println("Clicked on the new repair button.");

			// scroll down the screen
			JavascriptExecutor js = (JavascriptExecutor) driver;
			js.executeScript("window.scrollBy(0,600)");

			System.out.println("Scroll down the screen.");

			// enter the title of the repair
			type("propertyproject_mu_repair_titletxt_CSS", data.get("task_title"));
			ngDriver.waitForAngularRequestsToFinish();
			System.out.println("Entered the title of the repair.");

			// enter the description
			type("propertyproject_mu_descriptiontxt_CSS", data.get("short_description"));
			ngDriver.waitForAngularRequestsToFinish();
			System.out.println("Entered the description.");

			// enter the unit number
			type("propertyproject_mu_unitenotxt_CSS", data.get("unit_number"));
			ngDriver.waitForAngularRequestsToFinish();
			System.out.println("Entered the unit number.");

			// click on assign to field
			click("propertyproject_mu_repair_assigntotxt_CSS");
			System.out.println("Clicked on assign to field.");
			ngDriver.waitForAngularRequestsToFinish();

			// click on the none button
			click("propertyproject_mu_repair_nonebtn_CSS");
			System.out.println("Clicked on the none button.");
			ngDriver.waitForAngularRequestsToFinish();

			// enter username in search field
			clear("propertyproject_mu_repair_searchusertxt_CSS");
			ngDriver.waitForAngularRequestsToFinish();
			System.out.println("Entered username in search field.");
			type("propertyproject_mu_repair_searchusertxt_CSS", data.get("user_1"));
			System.out.println("Entered username in search field.");
			ngDriver.waitForAngularRequestsToFinish();

			// click on the searched username
			click("propertyproject_mu_repair_searcheduser_XPATH");
			ngDriver.waitForAngularRequestsToFinish();
			System.out.println("Clicked on the searched username.");

			// enter role in search field
			clear("propertyproject_mu_repair_searchusertxt_CSS");
			ngDriver.waitForAngularRequestsToFinish();
			System.out.println("Entered role in search field.");
			type("propertyproject_mu_repair_searchusertxt_CSS", data.get("role_1"));
			System.out.println("Entered role in search field.");
			ngDriver.waitForAngularRequestsToFinish();

			// click on the searched role
			click("propertyproject_mu_repair_searchedrole_XPATH");
			ngDriver.waitForAngularRequestsToFinish();
			System.out.println("Clicked on the searched username.");

			// click on assign to field
			click("propertyproject_mu_repair_assigntotxt_CSS");
			System.out.println("Clicked on assign to field.");
			ngDriver.waitForAngularRequestsToFinish();

			// scroll up the screen
			js.executeScript("window.scrollBy(0,-600)");
			ngDriver.waitForAngularRequestsToFinish();
			System.out.println("Scroll up the screen.");

			// DETAILS OF THE ATTACHMENT TAB

			// click on the attachment tab
			click("propertyproject_mu_attachmenttab_CSS");
			ngDriver.waitForAngularRequestsToFinish();
			System.out.println("Clicked on the attachment tab.");

			// scroll down the screen
			js.executeScript("window.scrollBy(0,600)");

			// AUTO IT Concept

			try {
				// click on the local upload file button
				WebElement chooseFile = driver.findElement(
						By.cssSelector(OR.getProperty("task_addtask_attachmentstab_uploadlocalfilebtn_CSS")));
				chooseFile.click();
				Runtime.getRuntime().exec(System.getProperty("user.dir") + "\\src\\test\\resources\\logs\\Upload.exe");
				System.out.println("Clicked on the local upload file button.");

//			// ROBOT CLASS Concept
//
//			// click on the upload local file
//			click("propertyproject_mu_uploaddocumentbtn_CSS");
//			ngDriver.waitForAngularRequestsToFinish();
//			System.out.println("Clicked on the upload local file.");
//
//			// upload the document using robot class methods
//			uploadFile(System.getProperty("user.dir") + "\\src\\test\\resources\\logs\\sample.pdf");

				// wait for the element
				explicitWaitClickable("propertyproject_mu_attchedfilename_CSS");

				// verify uploaded file is displayed or not

				String str1 = driver.findElement(By.xpath(OR.getProperty("propertyproject_mu_attchedfilename_CSS")))
						.getText();

				if (str1.equals("sample.pdf")) {
					System.out.println("The uploaded file displayed successfully.");
					test.log(LogStatus.INFO, "The uploaded file displayed successfully.");
					Reporter.log("The uploaded file displayed successfully.");
					log.info("The uploaded file displayed successfully.");

				} else {
					Assert.assertTrue(
							isElementPresent(By.xpath(OR.getProperty("propertyproject_mu_attchedfilename_CSS"))),
							"The The uploaded file is not displayed.");

					TestUtil.captureScreenshot();

					// ReportNG
					Reporter.log("<br>" + "The The uploaded file is not displayed : " + "<br>");
					Reporter.log("<a target=\"_blank\" href=" + TestUtil.screenshotName + "><img src="
							+ TestUtil.screenshotName + " height=200 width=200></img></a>");
					Reporter.log("<br>");
					Reporter.log("<br>");

					// Extent Report
					test.log(LogStatus.FAIL, " The The uploaded file is not displayed: ");
					test.log(LogStatus.FAIL, test.addScreenCapture(TestUtil.screenshotName));

					System.out.println("The The uploaded file is not displayed.");
					log.info("The The uploaded file is not displayed.");
				}

			} catch (Throwable t) {
				Assert.assertTrue(isElementPresent(By.xpath(OR.getProperty("propertyproject_mu_attchedfilename_CSS"))),
						"The The uploaded file is not displayed.");

				TestUtil.captureScreenshot();

				// ReportNG
				Reporter.log("<br>" + "The The uploaded file is not displayed : " + "<br>");
				Reporter.log("<a target=\"_blank\" href=" + TestUtil.screenshotName + "><img src="
						+ TestUtil.screenshotName + " height=200 width=200></img></a>");
				Reporter.log("<br>");
				Reporter.log("<br>");

				// Extent Report
				test.log(LogStatus.FAIL, " The The uploaded file is not displayed: ");
				test.log(LogStatus.FAIL, test.addScreenCapture(TestUtil.screenshotName));

				System.out.println("The The uploaded file is not displayed.");
				log.info("The The uploaded file is not displayed.");
			}

			// click on the save button
			click("propertyproject_mu_tasksavebtn_BTNTEXT");
			ngDriver.waitForAngularRequestsToFinish();
			System.out.println("Clicked on the save button.");

			// wait for the element
			explicitWaitClickable("propertyproject_mu_addedrepair_attachment1_XPATH");

			// verify newly created repair is displayed or not
			switchVerification("propertyproject_mu_addedrepair_attachment1_XPATH",
					"Test SS Attachment 1 Mortgage Undertakings Title",
					"The Test SS Attachment 1 Mortgage Undertakings Title is not displayed.");

			// click on the update button
			click("propertyproject_mu_repair_updatebtn_CSS");
			ngDriver.waitForAngularRequestsToFinish();
			System.out.println("Clicked on the update button.");

			// wait for the element
			explicitWaitClickable("propertyproject_mu_addedmortgageundertakings_attachment1_XPATH");

			// verify newly created mortgage undertaking is displayed or not
			switchVerification("propertyproject_mu_addedmortgageundertakings_attachment1_XPATH",
					"UNDERTAKINGSSATTACHMENTONE2021", "The UNDERTAKINGSSATTACHMENTONE2021 is not displayed.");

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

		try {
			// VERIFY THE RESTRICTED ATTACHMENT ACCESS IN THE JINESH USER

			System.out.println(
					"**************** VERIFY THE RESTRICTED ATTACHMENT ACCESS IN THE JINESH USER ****************");
			test.log(LogStatus.INFO,
					"**************** VERIFY THE RESTRICTED ATTACHMENT ACCESS IN THE JINESH USER ****************");
			Reporter.log(
					"**************** VERIFY THE RESTRICTED ATTACHMENT ACCESS IN THE JINESH USER ****************");
			log.info("**************** VERIFY THE RESTRICTED ATTACHMENT ACCESS IN THE JINESH USER ****************");

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
			switchVerification("propertyproject_mu_addedmortgageundertakings_attachment1_XPATH",
					"UNDERTAKINGSSATTACHMENTONE2021", "The UNDERTAKINGSSATTACHMENTONE2021 is not displayed.");

			// click on the created mortgage undertaking
			click("propertyproject_mu_addedmortgageundertakings_attachment1_XPATH");
			ngDriver.waitForAngularRequestsToFinish();
			System.out.println("Clicked on the created mortgage undertaking.");

			// scroll down the screen
			JavascriptExecutor js = (JavascriptExecutor) driver;
			js.executeScript("window.scrollBy(0,600)");

			// verify newly created repair is displayed or not
			switchVerification("propertyproject_mu_addedrepair_attachment1_XPATH",
					"Test SS Attachment 1 Mortgage Undertakings Title",
					"The Test SS Attachment 1 Mortgage Undertakings Title is not displayed.");

			// click on the newly created repair
			click("propertyproject_mu_addedrepair_attachment1_XPATH");
			ngDriver.waitForAngularRequestsToFinish();
			System.out.println("Clicked on the newly created repair.");

			// click on the attachment tab
			click("propertyproject_mu_attachmenttab_CSS");
			ngDriver.waitForAngularRequestsToFinish();
			System.out.println("Clicked on the attachment tab.");

			// scroll down the screen
			js.executeScript("window.scrollBy(0,600)");

			try {
				// click on the attachment
				click("propertyproject_mu_attchedfilename_CSS");
				ngDriver.waitForAngularRequestsToFinish();
				System.out.println("Clicked on the attachment.");

				// wait for the element
				explicitWaitClickable("propertyproject_mu_downloadbtn_CSS");

				boolean downloadbtn1 = driver
						.findElement(By.cssSelector(OR.getProperty("propertyproject_mu_downloadbtn_CSS")))
						.isDisplayed();

				if (downloadbtn1 == true) {
					System.out.println("The Download button is displayed as expected.");
					test.log(LogStatus.INFO, "The Download button is displayed as expected.");
					Reporter.log("The Download button is displayed as expected.");
					log.info("The Download button is displayed as expected.");
				} else {
					TestUtil.captureScreenshot();

					// ReportNG
					Reporter.log("<br>" + "The Download button is not displayed: " + "<br>");
					Reporter.log("<a target=\"_blank\" href=" + TestUtil.screenshotName + "><img src="
							+ TestUtil.screenshotName + " height=200 width=200></img></a>");
					Reporter.log("<br>");
					Reporter.log("<br>");

					// Extent Report
					test.log(LogStatus.FAIL, " The Download button is not displayed : ");
					test.log(LogStatus.FAIL, test.addScreenCapture(TestUtil.screenshotName));

					System.out.println("The Download button is not displayed");
					log.info("The Download button is not displayed");

				}

			} catch (Throwable t) {
				TestUtil.captureScreenshot();

				// ReportNG
				Reporter.log("<br>" + "The Download button is not displayed: " + "<br>");
				Reporter.log("<a target=\"_blank\" href=" + TestUtil.screenshotName + "><img src="
						+ TestUtil.screenshotName + " height=200 width=200></img></a>");
				Reporter.log("<br>");
				Reporter.log("<br>");

				// Extent Report
				test.log(LogStatus.FAIL, " The Download button is not displayed : ");
				test.log(LogStatus.FAIL, test.addScreenCapture(TestUtil.screenshotName));

				System.out.println("The Download button is not displayed");
				log.info("The Download button is not displayed");

			}

			// click on the cancel button
			click("propertyproject_mu_downloadcancelbtn_CSS");
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
			explicitWaitClickable("sidemenu_logout_CSS");

			// click on the logout option from the side menu
			click("sidemenu_logout_CSS");
			System.out.println("Clicked on the logout option from the side menu.");
			ngDriver.waitForAngularRequestsToFinish();

			// VERIFY THE RESTRICTED ATTACHMENT ACCESS IN THE JINESH CONTRACTOR

			System.out.println(
					"**************** VERIFY THE RESTRICTED ATTACHMENT ACCESS IN THE JINESH CONTRACTOR ****************");
			test.log(LogStatus.INFO,
					"**************** VERIFY THE RESTRICTED ATTACHMENT ACCESS IN THE JINESH CONTRACTOR ****************");
			Reporter.log(
					"**************** VERIFY THE RESTRICTED ATTACHMENT ACCESS IN THE JINESH CONTRACTOR ****************");
			log.info(
					"**************** VERIFY THE RESTRICTED ATTACHMENT ACCESS IN THE JINESH CONTRACTOR ****************");

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
			switchVerification("propertyproject_mu_addedmortgageundertakings_attachment1_XPATH",
					"UNDERTAKINGSSATTACHMENTONE2021", "The UNDERTAKINGSSATTACHMENTONE2021 is not displayed.");

			// click on the created mortgage undertaking
			click("propertyproject_mu_addedmortgageundertakings_attachment1_XPATH");
			ngDriver.waitForAngularRequestsToFinish();
			System.out.println("Clicked on the created mortgage undertaking.");

			// scroll down the screen
			js.executeScript("window.scrollBy(0,600)");

			// verify newly created repair is displayed or not
			switchVerification("propertyproject_mu_addedrepair_attachment1_XPATH",
					"Test SS Attachment 1 Mortgage Undertakings Title",
					"The Test SS Attachment 1 Mortgage Undertakings Title is not displayed.");

			// click on the newly created repair
			click("propertyproject_mu_addedrepair_attachment1_XPATH");
			ngDriver.waitForAngularRequestsToFinish();
			System.out.println("Clicked on the newly created repair.");

			// click on the attachment tab
			click("propertyproject_mu_attachmenttab_CSS");
			ngDriver.waitForAngularRequestsToFinish();
			System.out.println("Clicked on the attachment tab.");

			// scroll down the screen
			js.executeScript("window.scrollBy(0,600)");

			try {

				// click on the attachment
				click("propertyproject_mu_attchedfilename_CSS");
				ngDriver.waitForAngularRequestsToFinish();

				// wait for the element
				explicitWaitClickable("propertyproject_mu_downloadbtn_CSS");

				boolean downloadbtn2 = driver
						.findElement(By.cssSelector(OR.getProperty("propertyproject_mu_downloadbtn_CSS")))
						.isDisplayed();

				if (downloadbtn2 == true) {
					System.out.println("The Download button is displayed as expected.");
					test.log(LogStatus.INFO, "The Download button is displayed as expected.");
					Reporter.log("The Download button is displayed as expected.");
					log.info("The Download button is displayed as expected.");
				} else {
					TestUtil.captureScreenshot();

					// ReportNG
					Reporter.log("<br>" + "The Download button is not displayed: " + "<br>");
					Reporter.log("<a target=\"_blank\" href=" + TestUtil.screenshotName + "><img src="
							+ TestUtil.screenshotName + " height=200 width=200></img></a>");
					Reporter.log("<br>");
					Reporter.log("<br>");

					// Extent Report
					test.log(LogStatus.FAIL, " The Download button is not displayed : ");
					test.log(LogStatus.FAIL, test.addScreenCapture(TestUtil.screenshotName));

					System.out.println("The Download button is not displayed");
					log.info("The Download button is not displayed");

				}

			} catch (Throwable t) {
				TestUtil.captureScreenshot();

				// ReportNG
				Reporter.log("<br>" + "The Download button is not displayed: " + "<br>");
				Reporter.log("<a target=\"_blank\" href=" + TestUtil.screenshotName + "><img src="
						+ TestUtil.screenshotName + " height=200 width=200></img></a>");
				Reporter.log("<br>");
				Reporter.log("<br>");

				// Extent Report
				test.log(LogStatus.FAIL, " The Download button is not displayed : ");
				test.log(LogStatus.FAIL, test.addScreenCapture(TestUtil.screenshotName));

				System.out.println("The Download button is not displayed");
				log.info("The Download button is not displayed");

			}

			// click on the cancel button
			click("propertyproject_mu_downloadcancelbtn_CSS");
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
			explicitWaitClickable("sidemenu_logout_CSS");

			// click on the logout option from the side menu
			click("sidemenu_logout_CSS");
			System.out.println("Clicked on the logout option from the side menu.");
			ngDriver.waitForAngularRequestsToFinish();

			// VERIFY THE RESTRICTED ATTACHMENT ACCESS IN THE JINESH HR

			System.out.println(
					"**************** VERIFY THE RESTRICTED ATTACHMENT ACCESS IN THE JINESH HR ****************");
			test.log(LogStatus.INFO,
					"**************** VERIFY THE RESTRICTED ATTACHMENT ACCESS IN THE JINESH HR ****************");
			Reporter.log("**************** VERIFY THE RESTRICTED ATTACHMENT ACCESS IN THE JINESH HR ****************");
			log.info("**************** VERIFY THE RESTRICTED ATTACHMENT ACCESS IN THE JINESH HR ****************");

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
			switchVerification("propertyproject_mu_addedmortgageundertakings_attachment1_XPATH",
					"UNDERTAKINGSSATTACHMENTONE2021", "The UNDERTAKINGSSATTACHMENTONE2021 is not displayed.");

			// click on the created mortgage undertaking
			click("propertyproject_mu_addedmortgageundertakings_attachment1_XPATH");
			ngDriver.waitForAngularRequestsToFinish();
			System.out.println("Clicked on the created mortgage undertaking.");

			// scroll down the screen
			js.executeScript("window.scrollBy(0,600)");

			// verify newly created repair is displayed or not
			switchVerification("propertyproject_mu_addedrepair_attachment1_XPATH",
					"Test SS Attachment 1 Mortgage Undertakings Title",
					"The Test SS Attachment 1 Mortgage Undertakings Title is not displayed.");

			// click on the newly created repair
			click("propertyproject_mu_addedrepair_attachment1_XPATH");
			ngDriver.waitForAngularRequestsToFinish();
			System.out.println("Clicked on the newly created repair.");

			// click on the attachment tab
			click("propertyproject_mu_attachmenttab_CSS");
			ngDriver.waitForAngularRequestsToFinish();
			System.out.println("Clicked on the attachment tab.");

			// scroll down the screen
			js.executeScript("window.scrollBy(0,600)");

			try {
				// click on the attachment
				click("propertyproject_mu_attchedfilename_CSS");
				ngDriver.waitForAngularRequestsToFinish();

				// wait for the element
				explicitWaitClickable("propertyproject_mu_downloadbtn_CSS");

				boolean downloadbtn3 = driver
						.findElement(By.cssSelector(OR.getProperty("propertyproject_mu_downloadbtn_CSS")))
						.isDisplayed();

				if (downloadbtn3 == true) {

					TestUtil.captureScreenshot();

					// ReportNG
					Reporter.log("<br>" + "The Download button is displayed without the permission: " + "<br>");
					Reporter.log("<a target=\"_blank\" href=" + TestUtil.screenshotName + "><img src="
							+ TestUtil.screenshotName + " height=200 width=200></img></a>");
					Reporter.log("<br>");
					Reporter.log("<br>");

					// Extent Report
					test.log(LogStatus.FAIL, " The Download button is displayed without the permission : ");
					test.log(LogStatus.FAIL, test.addScreenCapture(TestUtil.screenshotName));

					System.out.println("The Download button is displayed without the permission");
					log.info("The Download button is displayed without the permission");

				} else {
					System.out.println("The Download button is not displayed as expected.");
					test.log(LogStatus.INFO, "The Download button is not displayed as expected.");
					Reporter.log("The Download button is not displayed as expected.");
					log.info("The Download button is not displayed as expected.");

				}

			} catch (Throwable t) {
				System.out.println("The Download button is not displayed as expected.");
				test.log(LogStatus.INFO, "The Download button is not displayed as expected.");
				Reporter.log("The Download button is not displayed as expected.");
				log.info("The Download button is not displayed as expected.");

			}

			// click on the back button
			click("propertyproject_mu_attachmenttab_backbtn_CSS");
			ngDriver.waitForAngularRequestsToFinish();
			System.out.println("Clicked on the back button.");

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

			System.out.println("**************** LOGIN IN AUTOMATION TESTER USER ****************");
			test.log(LogStatus.INFO, "**************** LOGIN IN AUTOMATION TESTER USER ****************");
			Reporter.log("**************** LOGIN IN AUTOMATION TESTER USER ****************");
			log.info("**************** LOGIN IN AUTOMATION TESTER USER ****************");

			// DELETE THE CREATED MORTGAGE UNDERTAKING AND RESET THE GIVEN PERMISSIONS

			System.out.println(
					"**************** DELETE THE CREATED MORTGAGE UNDERTAKING AND RESET THE GIVEN PERMISSIONS ****************");
			test.log(LogStatus.INFO,
					"**************** DELETE THE CREATED MORTGAGE UNDERTAKING AND RESET THE GIVEN PERMISSIONS ****************");
			Reporter.log(
					"**************** DELETE THE CREATED MORTGAGE UNDERTAKING AND RESET THE GIVEN PERMISSIONS ****************");
			log.info(
					"**************** DELETE THE CREATED MORTGAGE UNDERTAKING AND RESET THE GIVEN PERMISSIONS ****************");

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
			switchVerification("propertyproject_mu_addedmortgageundertakings_attachment1_XPATH",
					"UNDERTAKINGSSATTACHMENTONE2021", "The UNDERTAKINGSSATTACHMENTONE2021 is not displayed.");

			// click on the Mortgage Undertakings
			click("propertyproject_mu_addedmortgageundertakings_attachment1_XPATH");
			ngDriver.waitForAngularRequestsToFinish();
			System.out.println("Clicked on the newly created Mortgage Undertakings.");

			// scroll down the screen
			JavascriptExecutor js = (JavascriptExecutor) driver;
			js.executeScript("window.scrollBy(0,600)");

			// verify newly created repair is displayed or not
			switchVerification("propertyproject_mu_addedrepair_attachment1_XPATH",
					"Test SS Attachment 1 Mortgage Undertakings Title",
					"The Test SS Attachment 1 Mortgage Undertakings Title is not displayed.");

			// DELETE THE REPAIR

			// scroll down the screen
			js.executeScript("window.scrollBy(0,600)");

			// click on the repair
			click("propertyproject_mu_addedrepair_attachment1_XPATH");
			ngDriver.waitForAngularRequestsToFinish();
			System.out.println("Clicked on the repair.");

			// click on the delete button
			click("task_deletedtaskbtn_CSS");
			ngDriver.waitForAngularRequestsToFinish();
			System.out.println("Clicked on the delete button.");

			// click on the delete button of the confirmation
			click("task_deletedtaskbtn_confirmaiton_CSS");
			ngDriver.waitForAngularRequestsToFinish();
			System.out.println("Clicked on the delete button of the confirmation.");

			// wait for the element
			explicitWaitClickable("closetoastmsg_CSS");

			// click on the toaster close button
			click("closetoastmsg_CSS");
			ngDriver.waitForAngularRequestsToFinish();
			System.out.println("Clicked on the toaster close button.");

			// verify repair is deleted or not

			try {
				helper.deleteVerification("propertyproject_mu_addedrepair_attachment1_XPATH",
						"Test SS Attachment 1 Mortgage Undertakings Title");

			} catch (Throwable t) {
				verificationFailed();
			}

			// click on the update button
			click("propertyproject_mu_taskupdatebtn_BTNTEXT");
			ngDriver.waitForAngularRequestsToFinish();
			System.out.println("Clicked on the update button.");

			// wait for the element
			explicitWaitClickable("closetoastmsg_CSS");

			// click on the toaster close button
			click("closetoastmsg_CSS");
			ngDriver.waitForAngularRequestsToFinish();
			System.out.println("Clicked on the toaster close button.");

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

			helper.deleteVerification("propertyproject_mu_addedmortgageundertakings_attachment1_XPATH",
					"UNDERTAKINGSSATTACHMENTONE2021");

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

			helper.resetPermission(data, "security_setting_attachment_1",
					"propertyproject_securitysettings_attachments1_XPATH");

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