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
		title("VALIDATE THE PERMISSION TO CREATE, READ, UPDATE AND DELETE UTILITY TARGETS SECURITY SETTINGS");

		Helper helper = new Helper();

		String reductionPercentage = RandomStringUtils.randomNumeric(2);

		// refresh the page
		driver.navigate().refresh();
		explicitWait("sustainabilityicon_CSS");
		driver.navigate().refresh();

		// UPDATE THE PERMISSION TO CREATE, READ, UPDATE AND DELETE UTILITY TARGETS
		// SECURITY SETTINGS
		title("UPDATE THE PERMISSION TO CREATE, READ, UPDATE AND DELETE UTILITY TARGETS SECURITY SETTINGS");

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

			// RESET THE PERMISSION TO CREATE, READ, UPDATE AND DELETE UTILITY TARGETS
			// SECURITY SETTINGS
			helper.resetPermission(data, "security_setting_1", "sustainability_utilitybills_securitysettings7_XPATH");

		} catch (Throwable t) {
			verificationFailed();
		}

		// click on the home icon
		click("questionnaire_homeburgermenubtn_CSS");

		// wait for the element
		explicitWait("propertylist_title_XPATH");

		// verify the property list
		switchVerification("propertylist_title_XPATH", "Property List", "The property list is not displayed.");

		// CREATE NEW PERFORMANCE TARGETS RECORD
		title("CREATE NEW PERFORMANCE TARGETS RECORD");

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

			// click on the building performance data option
			click("sustainability_sidemenu_buildingperformancedataoption_XPATH");

			// click on the Performance Targets option
			click("sustainability_sidemenu_buildingperformancedataoption_performancetargetsoption_XPATH");

			// click on the add button
			click("sustainability_performancetargets_addbtn_XPATH");

			// select the respective Performance Category from the drop down
			select("sustainability_performancetargets_performancecategorydd_XPATH", data.get("category"));

			// select the respective Period from the drop down
			select("sustainability_performancetargets_perioddd_XPATH", data.get("period"));

			// enter the current year in the baseline year
			LocalDate addDate1 = LocalDate.now();
			String addDate1_String = addDate1.toString();
			String[] arrOfStr = addDate1_String.split("-");
			String currentyear = arrOfStr[0];
			type("sustainability_performancetargets_baselineyeartxt_XPATH", currentyear);

			// enter the year in the target year
			LocalDate addDate2 = LocalDate.now().plusYears(4);
			String addDate2_String = addDate2.toString();
			String[] arrOfStr2 = addDate2_String.split("-");
			String currentyear2 = arrOfStr2[0];
			type("sustainability_performancetargets_targetyeartxt_XPATH", currentyear2);

			// select target month
			select("sustainability_performancetargets_targetmonthdd_XPATH", "December");

			// enter the reduction percentage
			type("sustainability_performancetargets_reductionpercentagetxt_XPATH", reductionPercentage);

			// click on the save button
			click("sustainability_performancetargets_savebtn_XPATH");

			// wait for the element
			explicitWaitClickable("closetoastmsg_CSS");

			// click on the toaster close button
			click("closetoastmsg_CSS");

			// enter the newly created record in the search field
			type("sustainability_searchtxt_XPATH", "December");

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

		// synchronization
		explicitWait("propertylist_title_XPATH");

		// verify the property list
		switchVerification("propertylist_title_XPATH", "Property List", "The property list is not displayed.");

		// VALIDATE THE PERMISSION TO CREATE, READ, UPDATE AND DELETE PERFORMANCE
		// TARGETS IN ADMIN USER
		title("VALIDATE THE PERMISSION TO CREATE, READ, UPDATE AND DELETE PERFORMANCE TARGETS IN ADMIN USER");

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

			// click on the building performance data option
			click("sustainability_sidemenu_buildingperformancedataoption_XPATH");

			// click on the Performance Targets option
			click("sustainability_sidemenu_buildingperformancedataoption_performancetargetsoption_XPATH");

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
			type("sustainability_searchtxt_XPATH", "December");

			// click on the newly created record
			String PerformanceTargets2 = "//td[text()='" + reductionPercentage + "']";
			driver.findElement(By.xpath(PerformanceTargets2)).click();

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

			// VALIDATE THE PERMISSION TO CREATE, READ, UPDATE AND DELETE PERFORMANCE
			// TARGETS IN PROPERTY MANAGER USER
			title("VALIDATE THE PERMISSION TO CREATE, READ, UPDATE AND DELETE PERFORMANCE TARGETS IN PROPERTY MANAGER USER");

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

				// click on the building performance data option
				click("sustainability_sidemenu_buildingperformancedataoption_XPATH");

				// click on the Performance Targets option
				click("sustainability_sidemenu_buildingperformancedataoption_performancetargetsoption_XPATH");

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
				type("sustainability_searchtxt_XPATH", "December");

				// click on the newly created record
				String PerformanceTargets2 = "//td[text()='" + reductionPercentage + "']";
				driver.findElement(By.xpath(PerformanceTargets2)).click();

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

		// DELETE THE NEWLY CREATAED PERFORMANCE TARGETS RECORD
		title("DELETE THE NEWLY CREATAED PERFORMANCE TARGETS RECORD");

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

			// click on the building performance data option
			click("sustainability_sidemenu_buildingperformancedataoption_XPATH");

			// click on the Performance Targets option
			click("sustainability_sidemenu_buildingperformancedataoption_performancetargetsoption_XPATH");

			// enter the newly created record in the search field
			type("sustainability_searchtxt_XPATH", "December");

			// click on the newly created record
			String PerformanceTargets2 = "//td[text()='" + reductionPercentage + "']";
			driver.findElement(By.xpath(PerformanceTargets2)).click();

			// wait for the element
			Thread.sleep(5000);

			// click on the delete button
			click("sustainability_performancetargets_deletebtn_XPATH");

			// wait for the element
			Thread.sleep(5000);

			// click on the delete button of confirmation message
			click("sustainability_performancetargets_confirmdeletebtn_XPATH");

			// wait for the element
			explicitWaitClickable("closetoastmsg_CSS");

			// click on the toaster close button
			click("closetoastmsg_CSS");

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
			click("sustainability_utilitybills_securitysettings7_XPATH");

			// click on the select role field
			click("propertyproject_securitysettings1_selectroles_CSS");

			// click on the none button
			click("propertyproject_securitysettings1_nonebtn_CSS");

			// enter the name of the role in search field
			type("propertyproject_securitysettings1_searchtxt_CSS", data.get("role_1"));

			// click on the searched result
			click("sustainability_utilitybills_searchedpm_XPATH");

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