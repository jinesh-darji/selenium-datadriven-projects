package testcases.E2Etestcasesuite.sustainabilitymodule;

import java.io.IOException;
import java.time.LocalDate;
import java.util.Hashtable;

import org.apache.commons.lang3.RandomStringUtils;
import org.openqa.selenium.By;
import org.testng.Reporter;
import org.testng.SkipException;
import org.testng.annotations.Test;

import com.relevantcodes.extentreports.LogStatus;

import base.Helper;
import base.TestBase;
import utilities.TestUtil;

public class RR6034Sustainability7Test extends TestBase {

	@Test(dataProviderClass = TestUtil.class, dataProvider = "dp")
	public void rR6034Sustainability7Test(Hashtable<String, String> data) throws IOException, InterruptedException {

		execution(data, "rR6034Sustainability7Test");

		// VALIDATE THE PERMISSION TO CREATE, READ, UPDATE AND DELETE UTILITY TARGETS
		// SECURITY SETTINGS

		System.out.println(
				"VALIDATE THE PERMISSION TO CREATE, READ, UPDATE AND DELETE UTILITY TARGETS SECURITY SETTINGS");
		test.log(LogStatus.INFO,
				"VALIDATE THE PERMISSION TO CREATE, READ, UPDATE AND DELETE UTILITY TARGETS SECURITY SETTINGS");
		Reporter.log("VALIDATE THE PERMISSION TO CREATE, READ, UPDATE AND DELETE UTILITY TARGETS SECURITY SETTINGS");
		log.info("VALIDATE THE PERMISSION TO CREATE, READ, UPDATE AND DELETE UTILITY TARGETS SECURITY SETTINGS");

		Helper helper = new Helper();
		
		String reductionPercentage = RandomStringUtils.randomNumeric(2);

		// refresh the page
		driver.navigate().refresh();
		explicitWait("sustainabilityicon_CSS");
		driver.navigate().refresh();

		System.out.println("Navigate to the Home Screen i.e. Property List Screen.");

		// UPDATE THE PERMISSION TO CREATE, READ, UPDATE AND DELETE UTILITY TARGETS
		// SECURITY SETTINGS

		System.out.println(
				"***************** UPDATE THE PERMISSION TO CREATE, READ, UPDATE AND DELETE UTILITY TARGETS SECURITY SETTINGS *****************");
		test.log(LogStatus.INFO,
				"***************** UPDATE THE PERMISSION TO CREATE, READ, UPDATE AND DELETE UTILITY TARGETS SECURITY SETTINGS *****************");
		Reporter.log(
				"***************** UPDATE THE PERMISSION TO CREATE, READ, UPDATE AND DELETE UTILITY TARGETS SECURITY SETTINGS *****************");
		log.info(
				"***************** UPDATE THE PERMISSION TO CREATE, READ, UPDATE AND DELETE UTILITY TARGETS SECURITY SETTINGS *****************");

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

			// RESET THE PERMISSION TO CREATE, READ, UPDATE AND DELETE UTILITY TARGETS
			// SECURITY SETTINGS

			helper.resetPermission(data, "security_setting_1", "sustainability_utilitybills_securitysettings7_XPATH");

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

		// CREATE NEW PERFORMANCE TARGETS RECORD

		System.out.println("***************** CREATE NEW PERFORMANCE TARGETS RECORD *****************");
		test.log(LogStatus.INFO, "***************** CREATE NEW PERFORMANCE TARGETS RECORD *****************");
		Reporter.log("***************** CREATE NEW PERFORMANCE TARGETS RECORD *****************");
		log.info("***************** CREATE NEW PERFORMANCE TARGETS RECORD *****************");

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

			// click on the building performance data option
			click("sustainability_sidemenu_buildingperformancedataoption_XPATH");
			ngDriver.waitForAngularRequestsToFinish();
			System.out.println("Clicked on the building performance data option.");

			// click on the Performance Targets option
			click("sustainability_sidemenu_buildingperformancedataoption_performancetargetsoption_XPATH");
			ngDriver.waitForAngularRequestsToFinish();
			System.out.println("Clicked on the Performance Targets option.");

			// click on the add button
			click("sustainability_performancetargets_addbtn_XPATH");
			ngDriver.waitForAngularRequestsToFinish();
			System.out.println("Clicked on the add button.");

			// select the respective Performance Category from the drop down
			select("sustainability_performancetargets_performancecategorydd_XPATH", data.get("category"));
			ngDriver.waitForAngularRequestsToFinish();
			System.out.println("Selected the respective Performance Category from the drop down.");

			// select the respective Period from the drop down
			select("sustainability_performancetargets_perioddd_XPATH", data.get("period"));
			ngDriver.waitForAngularRequestsToFinish();
			System.out.println("Selected the respective Period from the drop down.");

			// enter the current year in the baseline year
			LocalDate addDate1 = LocalDate.now();
			String addDate1_String = addDate1.toString();
			String[] arrOfStr = addDate1_String.split("-");
			String currentyear = arrOfStr[0];
			clear("sustainability_performancetargets_baselineyeartxt_XPATH");
			type("sustainability_performancetargets_baselineyeartxt_XPATH", currentyear);
			ngDriver.waitForAngularRequestsToFinish();
			System.out.println("Entered the current year in the baseline year.");

			// enter the year in the target year
			LocalDate addDate2 = LocalDate.now().plusYears(4);
			String addDate2_String = addDate2.toString();
			String[] arrOfStr2 = addDate2_String.split("-");
			String currentyear2 = arrOfStr2[0];
			clear("sustainability_performancetargets_targetyeartxt_XPATH");
			type("sustainability_performancetargets_targetyeartxt_XPATH", currentyear2);
			ngDriver.waitForAngularRequestsToFinish();
			System.out.println("Entered the year in the target year.");

			// select target month
			select("sustainability_performancetargets_targetmonthdd_XPATH", "December");
			ngDriver.waitForAngularRequestsToFinish();
			System.out.println("Selected target month.");

			// enter the reduction percentage
			clear("sustainability_performancetargets_reductionpercentagetxt_XPATH");
			type("sustainability_performancetargets_reductionpercentagetxt_XPATH", reductionPercentage);
			ngDriver.waitForAngularRequestsToFinish();
			System.out.println("Entered the reduction percentage.");

			// click on the save button
			click("sustainability_performancetargets_savebtn_XPATH");
			ngDriver.waitForAngularRequestsToFinish();
			System.out.println("Clicked on the save button.");

			// wait for the element
			explicitWaitClickable("closetoastmsg_CSS");

			// click on the toaster close button
			click("closetoastmsg_CSS");
			ngDriver.waitForAngularRequestsToFinish();
			System.out.println("Clicked on the toaster close button.");

			// enter the newly created record in the search field
			clear("sustainability_searchtxt_XPATH");
			type("sustainability_searchtxt_XPATH", "December");
			ngDriver.waitForAngularRequestsToFinish();
			System.out.println("Entered the newly created record in the search field.");

			// verify the newly created Performance Targets record
			try {
				String PerformanceTargets = "//td[text()='" + reductionPercentage + "']";
				String PerformanceTargets_actual = (driver.findElement(By.xpath(PerformanceTargets)).getText()).trim();
				if (PerformanceTargets_actual.equals(reductionPercentage)) {

					successMessage("The Performance Targets record is verified successfully");

				} else {

					verificationFailedMessage("The Performance Targets record is not displayed.");

				}
			} catch (Throwable t) {
				verificationFailedMessage("The Performance Targets record is not displayed.");
			}

		} catch (Throwable t) {
			verificationFailed();
		}

		// click on the home icon from the top of the screen
		click("questionnaire_homeburgermenubtn_hide_CSS");
		System.out.println("Clicked on the home icon from the top of the screen.");
		ngDriver.waitForAngularRequestsToFinish();

		// synchronization
		explicitWait("propertylist_title_XPATH");

		// verify the property list
		switchVerification("propertylist_title_XPATH", "Property List", "The property list is not displayed.");

		// VALIDATE THE PERMISSION TO CREATE, READ, UPDATE AND DELETE PERFORMANCE
		// TARGETS IN ADMIN USER

		System.out.println(
				"***************** VALIDATE THE PERMISSION TO CREATE, READ, UPDATE AND DELETE PERFORMANCE TARGETS IN ADMIN USER *****************");
		test.log(LogStatus.INFO,
				"***************** VALIDATE THE PERMISSION TO CREATE, READ, UPDATE AND DELETE PERFORMANCE TARGETS IN ADMIN USER *****************");
		Reporter.log(
				"***************** VALIDATE THE PERMISSION TO CREATE, READ, UPDATE AND DELETE PERFORMANCE TARGETS IN ADMIN USER *****************");
		log.info(
				"***************** VALIDATE THE PERMISSION TO CREATE, READ, UPDATE AND DELETE PERFORMANCE TARGETS IN ADMIN USER *****************");

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

			// click on the building performance data option
			click("sustainability_sidemenu_buildingperformancedataoption_XPATH");
			ngDriver.waitForAngularRequestsToFinish();
			System.out.println("Clicked on the building performance data option.");

			// click on the Performance Targets option
			click("sustainability_sidemenu_buildingperformancedataoption_performancetargetsoption_XPATH");
			ngDriver.waitForAngularRequestsToFinish();
			System.out.println("Clicked on the Performance Targets option.");

			// validate the add button of the performance targets
			try {
				boolean addBtn = driver
						.findElement(By.xpath(OR.getProperty("sustainability_performancetargets_addbtn_XPATH")))
						.isDisplayed();

				if (addBtn == true) {

					successMessage("The add button is displayed as expected.");

				} else {
					verificationFailedMessage("The add button is not displayed.");
				}

			} catch (Throwable t) {
				verificationFailedMessage("The add button is not displayed.");

			}

			// enter the newly created record in the search field
			clear("sustainability_searchtxt_XPATH");
			type("sustainability_searchtxt_XPATH", "December");
			ngDriver.waitForAngularRequestsToFinish();
			System.out.println("Entered the newly created record in the search field.");

			// click on the newly created record
			String PerformanceTargets2 = "//td[text()='" + reductionPercentage + "']";
			driver.findElement(By.xpath(PerformanceTargets2)).click();
			ngDriver.waitForAngularRequestsToFinish();
			System.out.println("Clicked on the newly created record.");

			// validate the save button of the performance targets
			try {
				boolean saveBtn = driver
						.findElement(By.xpath(OR.getProperty("sustainability_performancetargets_savebtn_XPATH")))
						.isDisplayed();

				if (saveBtn == true) {

					successMessage("The save button is displayed as expected.");

				} else {
					verificationFailedMessage("The save button is not displayed.");
				}

			} catch (Throwable t) {
				verificationFailedMessage("The save button is not displayed.");

			}

			// validate the delete button of the performance targets
			try {
				boolean deleteBtn = driver
						.findElement(By.xpath(OR.getProperty("sustainability_performancetargets_deletebtn_XPATH")))
						.isDisplayed();

				if (deleteBtn == true) {

					successMessage("The delete button is displayed as expected.");

				} else {
					verificationFailedMessage("The delete button is not displayed.");
				}

			} catch (Throwable t) {
				verificationFailedMessage("The delete button is not displayed.");

			}

		} catch (Throwable t) {
			verificationFailed();
		}

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

			// VALIDATE THE PERMISSION TO CREATE, READ, UPDATE AND DELETE PERFORMANCE
			// TARGETS IN PROPERTY MANAGER USER

			System.out.println(
					"***************** VALIDATE THE PERMISSION TO CREATE, READ, UPDATE AND DELETE PERFORMANCE TARGETS IN PROPERTY MANAGER USER *****************");
			test.log(LogStatus.INFO,
					"***************** VALIDATE THE PERMISSION TO CREATE, READ, UPDATE AND DELETE PERFORMANCE TARGETS IN PROPERTY MANAGER USER *****************");
			Reporter.log(
					"***************** VALIDATE THE PERMISSION TO CREATE, READ, UPDATE AND DELETE PERFORMANCE TARGETS IN PROPERTY MANAGER USER *****************");
			log.info(
					"***************** VALIDATE THE PERMISSION TO CREATE, READ, UPDATE AND DELETE PERFORMANCE TARGETS IN PROPERTY MANAGER USER *****************");

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

				// click on the building performance data option
				click("sustainability_sidemenu_buildingperformancedataoption_XPATH");
				ngDriver.waitForAngularRequestsToFinish();
				System.out.println("Clicked on the building performance data option.");

				// click on the Performance Targets option
				click("sustainability_sidemenu_buildingperformancedataoption_performancetargetsoption_XPATH");
				ngDriver.waitForAngularRequestsToFinish();
				System.out.println("Clicked on the Performance Targets option.");

				// validate the add button of the performance targets
				try {
					boolean addBtn = driver
							.findElement(By.xpath(OR.getProperty("sustainability_performancetargets_addbtn_XPATH")))
							.isDisplayed();

					if (addBtn == true) {

						verificationFailedMessage("The add button is displayed without permission.");

					} else {
						successMessage("The add button is not displayed as expected.");
					}

				} catch (Throwable t) {
					successMessage("The add button is not displayed as expected.");

				}

				// enter the newly created record in the search field
				clear("sustainability_searchtxt_XPATH");
				type("sustainability_searchtxt_XPATH", "December");
				ngDriver.waitForAngularRequestsToFinish();
				System.out.println("Entered the newly created record in the search field.");

				// click on the newly created record
				String PerformanceTargets2 = "//td[text()='" + reductionPercentage + "']";
				driver.findElement(By.xpath(PerformanceTargets2)).click();
				ngDriver.waitForAngularRequestsToFinish();
				System.out.println("Clicked on the newly created record.");

				// validate the save button of the performance targets
				try {
					boolean saveBtn = driver
							.findElement(By.xpath(OR.getProperty("sustainability_performancetargets_savebtn_XPATH")))
							.isDisplayed();

					if (saveBtn == true) {

						verificationFailedMessage("The save button is displayed without permission.");

					} else {
						successMessage("The save button is not displayed as expected.");
					}

				} catch (Throwable t) {
					successMessage("The save button is not displayed as expected.");

				}

				// validate the delete button of the performance targets
				try {
					boolean deleteBtn = driver
							.findElement(By.xpath(OR.getProperty("sustainability_performancetargets_deletebtn_XPATH")))
							.isDisplayed();

					if (deleteBtn == true) {

						verificationFailedMessage("The delete button is displayed without permission.");

					} else {
						successMessage("The delete button is not displayed as expected.");
					}

				} catch (Throwable t) {
					successMessage("The delete button is not displayed as expected.");

				}

			} catch (Throwable t) {
				verificationFailed();
			}

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

		// DELETE THE NEWLY CREATAED PERFORMANCE TARGETS RECORD

		System.out.println("***************** DELETE THE NEWLY CREATAED PERFORMANCE TARGETS RECORD *****************");
		test.log(LogStatus.INFO,
				"***************** DELETE THE NEWLY CREATAED PERFORMANCE TARGETS RECORD *****************");
		Reporter.log("***************** DELETE THE NEWLY CREATAED PERFORMANCE TARGETS RECORD *****************");
		log.info("***************** DELETE THE NEWLY CREATAED PERFORMANCE TARGETS RECORD *****************");

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

			// click on the building performance data option
			click("sustainability_sidemenu_buildingperformancedataoption_XPATH");
			ngDriver.waitForAngularRequestsToFinish();
			System.out.println("Clicked on the building performance data option.");

			// click on the Performance Targets option
			click("sustainability_sidemenu_buildingperformancedataoption_performancetargetsoption_XPATH");
			ngDriver.waitForAngularRequestsToFinish();
			System.out.println("Clicked on the Performance Targets option.");

			// enter the newly created record in the search field
			clear("sustainability_searchtxt_XPATH");
			type("sustainability_searchtxt_XPATH", "December");
			ngDriver.waitForAngularRequestsToFinish();
			System.out.println("Entered the newly created record in the search field.");

			// click on the newly created record
			String PerformanceTargets2 = "//td[text()='" + reductionPercentage + "']";
			driver.findElement(By.xpath(PerformanceTargets2)).click();
			ngDriver.waitForAngularRequestsToFinish();
			System.out.println("Clicked on the newly created record.");

			// wait for the element
			Thread.sleep(5000);

			// click on the delete button
			click("sustainability_performancetargets_deletebtn_XPATH");
			ngDriver.waitForAngularRequestsToFinish();
			System.out.println("Clicked on the delete button.");

			// wait for the element
			Thread.sleep(5000);

			// click on the delete button of confirmation message
			click("sustainability_performancetargets_confirmdeletebtn_XPATH");
			ngDriver.waitForAngularRequestsToFinish();
			System.out.println("Clicked on the delete button of confirmation message.");

			// wait for the element
			explicitWaitClickable("closetoastmsg_CSS");

			// click on the toaster close button
			click("closetoastmsg_CSS");
			ngDriver.waitForAngularRequestsToFinish();
			System.out.println("Clicked on the toaster close button.");

			// wait for the element
			Thread.sleep(5000);

			try {
				boolean deletebtn = driver
						.findElement(By
								.xpath(OR.getProperty("sustainability_performancetargets_confirmationdeletebn_XPATH")))
						.isDisplayed();

				if (deletebtn == true) {

					verificationFailedMessage(
							"The confirmation message for the delete PERFORMANCE TARGETS is displayed after delete the record.");

					// click on the close button of confirmation popup model
					click("sustainability_performancetargets_closebtn_XPATH");
					ngDriver.waitForAngularRequestsToFinish();
					System.out.println("Clicked on the close button of confirmation popup model.");

				} else {
					successMessage(
							"The confirmation message for the delete PERFORMANCE TARGETS is not displayed after delete the record.");
				}

			} catch (Throwable t) {
				successMessage(
						"The confirmation message for the delete PERFORMANCE TARGETS is not displayed after delete the record.");
			}

		} catch (Throwable t) {
			verificationFailed();
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
			click("sustainability_utilitybills_securitysettings7_XPATH");
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

	}
}
