package testcases.smokesuite;

import java.io.IOException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Hashtable;
import java.util.List;
import java.util.Random;

import org.apache.commons.text.CharacterPredicates;
import org.apache.commons.text.RandomStringGenerator;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.SkipException;
import org.testng.annotations.Test;

import com.google.inject.Key;
import com.mysql.cj.jdbc.NonRegisteringDriver;
import com.paulhammant.ngwebdriver.ByAngularBinding.NgFindByBuilder;
import com.relevantcodes.extentreports.LogStatus;

import base.Helper;
import base.TestBase;
import utilities.TestUtil;

public class RR5595Morguard13Test extends TestBase {

	@Test(dataProviderClass = TestUtil.class, dataProvider = "dp")
	public void rR5595Morguard13Test(Hashtable<String, String> data) throws IOException, InterruptedException {

		if (!(TestUtil.isTestRunnable("rR5595Morguard13Test", excel))) {

			throw new SkipException(
					"Skipping the test " + "rR5595Morguard13Test".toUpperCase() + "as the Run mode is NO");
		}

		if (!data.get("runmode").equals("Y")) {

			throw new SkipException("Skipping the test case as the Run Mode for data set is NO");
		}

		Helper helper = new Helper();

		// refresh the page
		driver.navigate().refresh();
		Thread.sleep(5000);
		driver.navigate().refresh();

		// LOGIN WITH ADMIN USER

		System.out.println("******************** LOGIN WITH ADMIN USER ********************");
		test.log(LogStatus.INFO, "******************** LOGIN WITH ADMIN USER ********************");
		Reporter.log("******************** LOGIN WITH ADMIN USER ********************");
		log.info("******************** LOGIN WITH ADMIN USER ********************");

		try {
			// wait for the element
			explicitWaitClickable("signinbtn_BTNTEXT");

			// Enter the username
			type("usernametxt_CSS", data.get("username_1"));
			ngDriver.waitForAngularRequestsToFinish();
			System.out.println("Entered the username.");

			// Enter the password
			type("passwordtxt_CSS", data.get("password_1"));
			ngDriver.waitForAngularRequestsToFinish();
			System.out.println("Entered the password.");

			// Clicking on the "Sign In" button
			click("signinbtn_BTNTEXT");
			ngDriver.waitForAngularRequestsToFinish();
			System.out.println("Clicked on the sign in button.");

			// wait for the element
			explicitWait("propertylist_title_XPATH");

			// verify the property list
			switchVerification("propertylist_title_XPATH", "Property List", "The property list is not displayed.");

			// UPDATE THE SYSTEM COMPANY
			updateCompany(data);

		} catch (Throwable t) {
			verificationFailed();
		}

		// VERIFY THE REPORT BUILDER OPTION FOR ENVIRO MANAGER USER

		System.out.println(
				"******************** VERIFY THE REPORT BUILDER OPTION FOR ENVIRO MANAGER USER ********************");
		test.log(LogStatus.INFO,
				"******************** VERIFY THE REPORT BUILDER OPTION FOR ENVIRO MANAGER USER ********************");
		Reporter.log(
				"******************** VERIFY THE REPORT BUILDER OPTION FOR ENVIRO MANAGER USER ********************");
		log.info("******************** VERIFY THE REPORT BUILDER OPTION FOR ENVIRO MANAGER USER ********************");

		// VERIFY REPORT BUILDER OPTION FOR ENVIRO MANAGER USER IN SECURITY
		// SETTINGS

		System.out.println(
				"******************** VERIFY REPORT BUILDER OPTION FOR ENVIRO MANAGER USER IN SECURITY SETTINGS ********************");
		test.log(LogStatus.INFO,
				"******************** VERIFY REPORT BUILDER OPTION FOR ENVIRO MANAGER USER IN SECURITY SETTINGS ********************");
		Reporter.log(
				"******************** VERIFY REPORT BUILDER OPTION FOR ENVIRO MANAGER USER IN SECURITY SETTINGS ********************");
		log.info(
				"******************** VERIFY REPORT BUILDER OPTION FOR ENVIRO MANAGER USER IN SECURITY SETTINGS ********************");

		try {

			// wait for the element
			explicitWaitClickable("questionnaire_settingicon_CSS");

			// click on the settings icon from the top of the screen
			click("questionnaire_settingicon_CSS");
			System.out.println("Clicked on the settings icon.");
			ngDriver.waitForAngularRequestsToFinish();

			// wait for the element
			explicitWaitClickable("questionnaire_administrationoption_XPATH");

			// click on the administrative option
			click("questionnaire_administrationoption_XPATH");
			ngDriver.waitForAngularRequestsToFinish();
			System.out.println("Clicked on the administrative option.");

			// click on the security tab
			click("questionnaire_securitytab_XPATH");
			ngDriver.waitForAngularRequestsToFinish();
			System.out.println("Clicked on the security tab.");

			// click on the security settings option
			click("questionnaire_securotysettingsoption_XPATH");
			ngDriver.waitForAngularRequestsToFinish();
			System.out.println("Clicked on the security settings option.");

			// enter report builder security setting in the search field
			type("administration_securitysettings_searchtxt_XPATH", data.get("report_builder"));
			ngDriver.waitForAngularRequestsToFinish();
			System.out.println("Entered report builder security setting in the search field.");

			// click on the searched security settings
			click("administration_securitysettings_reportbuilder_XPATH");
			ngDriver.waitForAngularRequestsToFinish();
			System.out.println("Clicked on the searched security settings.");

			// wait for the element
			Thread.sleep(3000);

			// verify the enviro manager role is displayed or not

			List<WebElement> roleList = driver.findElements(
					By.xpath(OR.getProperty("administration_securitysettings_reportbuilder_roleslist_XPATH")));

			List<String> roleListString = new ArrayList<String>();

			for (WebElement role : roleList) {

				roleListString.add(role.getText());

			}

			int roleSize = roleListString.size();
			System.out.println("Total Number of roles are : " + roleSize);

			for (int i = 0; i < roleSize; i++) {

				String finalRole = roleListString.get(i);

				if (finalRole.equals("Enviro-Managers")) {

					verificationFailed();

					System.out.println(
							"THE ENVIRO-MANAGER ROLE IS DISPLAYED IN THE SECURITY SESSIONS OF THE REPORT BUILDER");
					test.log(LogStatus.INFO,
							"THE ENVIRO-MANAGER ROLE IS DISPLAYED IN THE SECURITY SESSIONS OF THE REPORT BUILDER");
					Reporter.log("THE ENVIRO-MANAGER ROLE IS DISPLAYED IN THE SECURITY SESSIONS OF THE REPORT BUILDER");
					log.info("THE ENVIRO-MANAGER ROLE IS DISPLAYED IN THE SECURITY SESSIONS OF THE REPORT BUILDER");

				} else {
					System.out.println(
							"THE ENVIRO-MANAGER ROLE IS DISPLAYED NOT IN THE SECURITY SESSIONS OF THE REPORT BUILDER AS EXPECTED");
					test.log(LogStatus.INFO,
							"THE ENVIRO-MANAGER ROLE IS DISPLAYED NOT IN THE SECURITY SESSIONS OF THE REPORT BUILDER AS EXPECTED");
					Reporter.log(
							"THE ENVIRO-MANAGER ROLE IS DISPLAYED NOT IN THE SECURITY SESSIONS OF THE REPORT BUILDER AS EXPECTED");
					log.info(
							"THE ENVIRO-MANAGER ROLE IS DISPLAYED NOT IN THE SECURITY SESSIONS OF THE REPORT BUILDER AS EXPECTED");
				}

			}

		} catch (Throwable t) {
			verificationFailed();
		}

		// click on the home icon from the top of the screen
		click("questionnaire_homeburgermenubtn_CSS");
		System.out.println("Clicked on the home icon from the top of the screen.");
		ngDriver.waitForAngularRequestsToFinish();

		// synchronization
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

			// wait for the element
			explicitWaitClickable("signinbtn_BTNTEXT");

			// LOGIN WITH ENVIRO-MANAGER USER

			System.out.println("**************** LOGIN IN WITH ENVIRO-MANAGER USER ****************");
			test.log(LogStatus.INFO, "**************** LOGIN IN WITH ENVIRO-MANAGER USER ****************");
			Reporter.log("**************** LOGIN IN WITH ENVIRO-MANAGER USER ****************");
			log.info("**************** LOGIN IN WITH ENVIRO-MANAGER USER ****************");

			// Enter the username
			ngDriver.waitForAngularRequestsToFinish();
			type("username_MODEL", data.get("username"));

			// Enter the password
			type("password_MODEL", data.get("password"));

			// Clicking on the "Sign In" button
			click("signinbtn_BTNTEXT");
			ngDriver.waitForAngularRequestsToFinish();

			// wait for the element
			explicitWait("propertylist_title_XPATH");

			// verify the property list
			switchVerification("propertylist_title_XPATH", "Property List", "The property list is not displayed.");

			// UPDATE THE SYSTEM COMPANY
			updateCompany(data);

			// VERIFY REPORT BUILDER OPTION IS DISPLAYED OR NOT IN THE ENVIRO-MANAGER USER

			System.out.println(
					"**************** VERIFY REPORT BUILDER OPTION IS DISPLAYED OR NOT IN THE ENVIRO-MANAGER USER ****************");
			test.log(LogStatus.INFO,
					"**************** VERIFY REPORT BUILDER OPTION IS DISPLAYED OR NOT IN THE ENVIRO-MANAGER USER ****************");
			Reporter.log(
					"**************** VERIFY REPORT BUILDER OPTION IS DISPLAYED OR NOT IN THE ENVIRO-MANAGER USER ****************");
			log.info(
					"**************** VERIFY REPORT BUILDER OPTION IS DISPLAYED OR NOT IN THE ENVIRO-MANAGER USER ****************");

			// wait for the element
			Thread.sleep(5000);

			// click on the side menu
			click("menubtn_CSS");
			ngDriver.waitForAngularRequestsToFinish();
			System.out.println("Clicked on the side menu.");

			// wait for the element
			Thread.sleep(5000);

			// click on the report module
			click("sidemenu_reports_CSS");
			ngDriver.waitForAngularRequestsToFinish();
			System.out.println("Clicked on the report module.");

			// wait for the element
			Thread.sleep(3000);

			// verify risk report builder tab is displayed or not

			deleteVerification("sidemenu_reports_riskreportbuildertab_XPATH", "Risk Report Builder");

			// click on the home icon from the top of the screen
			click("questionnaire_homeburgermenubtn_hide_CSS");
			System.out.println("Clicked on the home icon from the top of the screen.");
			ngDriver.waitForAngularRequestsToFinish();

			// synchronization
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

			// wait for the element
			explicitWaitClickable("signinbtn_BTNTEXT");

			// LOGIN WITH ENVIRO-MANAGER USER

			System.out.println("**************** LOGIN IN WITH ADMIN USER ****************");
			test.log(LogStatus.INFO, "**************** LOGIN IN WITH ADMIN USER ****************");
			Reporter.log("**************** LOGIN IN WITH ADMIN USER ****************");
			log.info("**************** LOGIN IN WITH ADMIN USER ****************");

			// Enter the username
			ngDriver.waitForAngularRequestsToFinish();
			type("username_MODEL", data.get("username_1"));

			// Enter the password
			type("password_MODEL", data.get("password_1"));

			// Clicking on the "Sign In" button
			click("signinbtn_BTNTEXT");
			ngDriver.waitForAngularRequestsToFinish();

			// wait for the element
			explicitWait("propertylist_title_XPATH");

			// verify the property list
			switchVerification("propertylist_title_XPATH", "Property List", "The property list is not displayed.");

			// UPDATE THE SYSTEM COMPANY
			updateCompany(data);

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

			// wait for the element
			explicitWaitClickable("signinbtn_BTNTEXT");

		} catch (Throwable t) {
			verificationFailed();
		}

	}
}
