package testcases.smokesuite;

import java.io.IOException;
import java.time.LocalDate;
import java.util.Hashtable;
import java.util.List;
import java.util.Random;

import org.apache.commons.text.CharacterPredicates;
import org.apache.commons.text.RandomStringGenerator;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
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

public class RR5595Morguard12Test extends TestBase {

	@Test(dataProviderClass = TestUtil.class, dataProvider = "dp")
	public void rR5595Morguard12Test(Hashtable<String, String> data) throws IOException, InterruptedException {

		if (!(TestUtil.isTestRunnable("rR5595Morguard12Test", excel))) {

			throw new SkipException(
					"Skipping the test " + "rR5595Morguard12Test".toUpperCase() + "as the Run mode is NO");
		}

		if (!data.get("runmode").equals("Y")) {

			throw new SkipException("Skipping the test case as the Run Mode for data set is NO");
		}

		// refresh the page
		driver.navigate().refresh();
		Thread.sleep(5000);
		driver.navigate().refresh();

		// LOGIN WITH ENVIRO MANAGER USER

		System.out.println("******************** LOGIN WITH ENVIRO MANAGER USER ********************");
		test.log(LogStatus.INFO, "******************** LOGIN WITH ENVIRO MANAGER USER ********************");
		Reporter.log("******************** LOGIN WITH ENVIRO MANAGER USER ********************");
		log.info("******************** LOGIN WITH ENVIRO MANAGER USER ********************");

		try {
			// wait for the element
			explicitWaitClickable("signinbtn_BTNTEXT");

			// Enter the username
			type("usernametxt_CSS", data.get("username_2"));
			ngDriver.waitForAngularRequestsToFinish();
			System.out.println("Entered the username.");

			// Enter the password
			type("passwordtxt_CSS", data.get("password"));
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

		// VERIFY PROPERTY, SEARCH PROPERTY, ADMINISTRATION, TASKS, PROFILE, HELP,
		// LOGOUT ARE VISIBLE.

		System.out.println(
				"******************** VERIFY PROPERTY, SEARCH PROPERTY, ADMINISTRATION, TASKS, PROFILE, HELP, LOGOUT ARE VISIBLE ********************");
		test.log(LogStatus.INFO,
				"******************** VERIFY PROPERTY, SEARCH PROPERTY, ADMINISTRATION, TASKS, PROFILE, HELP, LOGOUT ARE VISIBLE ********************");
		Reporter.log(
				"******************** VERIFY PROPERTY, SEARCH PROPERTY, ADMINISTRATION, TASKS, PROFILE, HELP, LOGOUT ARE VISIBLE ********************");
		log.info(
				"******************** VERIFY PROPERTY, SEARCH PROPERTY, ADMINISTRATION, TASKS, PROFILE, HELP, LOGOUT ARE VISIBLE ********************");

		// VERIFY THE PROPERTY IS VISIBLE OR NOT

		System.out.println("******************** VERIFY THE PROPERTY IS VISIBLE OR NOT ********************");
		test.log(LogStatus.INFO, "******************** VERIFY THE PROPERTY IS VISIBLE OR NOT ********************");
		Reporter.log("******************** VERIFY THE PROPERTY IS VISIBLE OR NOT ********************");
		log.info("******************** VERIFY THE PROPERTY IS VISIBLE OR NOT ********************");

		try {

			// enter the property name in the search field
			clear("envreports_propertylist_filtertxt_CSS");
			type("envreports_propertylist_filtertxt_CSS", data.get("property_2"));
			ngDriver.waitForAngularRequestsToFinish();
			System.out.println("Entered the property name in the search field.");

			// verify the respective searched property is displayed or not
			switchVerification("administration_security_groupproperty_addedproperty_XPATH", "CAPREIT - White Frost",
					"The CAPREIT - White Frost property is not displayed.");

			System.out.println("THE PROPERTY IS VISIBLE SUCCESSFULLY");
			test.log(LogStatus.INFO, "THE PROPERTY IS VISIBLE SUCCESSFULLY");
			Reporter.log("THE PROPERTY IS VISIBLE SUCCESSFULLY");
			log.info("THE PROPERTY IS VISIBLE SUCCESSFULLY");

		} catch (Throwable t) {
			verificationFailed();

			System.out.println("THE PROPERTY IS NOT VISIBLE");
			test.log(LogStatus.INFO, "THE PROPERTY IS NOT VISIBLE");
			Reporter.log("THE PROPERTY IS NOT VISIBLE");
			log.info("THE PROPERTY IS NOT VISIBLE");

		}

		// VERIFY THE SEARCH PROPERTY ICON IS VISIBLE OR NOT

		System.out.println(
				"******************** VERIFY THE SEARCH PROPERTY ICON  IS VISIBLE OR NOT ********************");
		test.log(LogStatus.INFO,
				"******************** VERIFY THE SEARCH PROPERTY ICON  IS VISIBLE OR NOT ********************");
		Reporter.log("******************** VERIFY THE SEARCH PROPERTY ICON  IS VISIBLE OR NOT ********************");
		log.info("******************** VERIFY THE SEARCH PROPERTY ICON  IS VISIBLE OR NOT ********************");

		try {

			boolean searchIcon = driver.findElement(By.xpath(OR.getProperty("property_searchicon_XPATH")))
					.isDisplayed();

			if (searchIcon == true) {

				System.out.println("THE SEARCH PROPERTY ICON IS VISIBLE SUCCESSFULLY");
				test.log(LogStatus.INFO, "THE SEARCH PROPERTY ICON IS VISIBLE SUCCESSFULLY");
				Reporter.log("THE SEARCH PROPERTY ICON IS VISIBLE SUCCESSFULLY");
				log.info("THE SEARCH PROPERTY ICON IS VISIBLE SUCCESSFULLY");

			} else {

				verificationFailed();

				System.out.println("THE SEARCH PROPERTY ICON IS NOT VISIBLE");
				test.log(LogStatus.INFO, "THE SEARCH PROPERTY ICON IS NOT VISIBLE");
				Reporter.log("THE SEARCH PROPERTY ICON IS NOT VISIBLE");
				log.info("THE SEARCH PROPERTY ICON IS NOT VISIBLE");
			}

		} catch (Throwable t) {
			verificationFailed();

			System.out.println("THE SEARCH PROPERTY ICON IS NOT VISIBLE");
			test.log(LogStatus.INFO, "THE SEARCH PROPERTY ICON IS NOT VISIBLE");
			Reporter.log("THE SEARCH PROPERTY ICON IS NOT VISIBLE");
			log.info("THE SEARCH PROPERTY ICON IS NOT VISIBLE");

		}

		// VERIFY THE ADMINISTRATION, TASKS, PROFILE, HELP, LOGOUT OPTIONS ARE VISIBLE
		// IN SIDE MENU OR NOT

		System.out.println(
				"******************** VERIFY THE ADMINISTRATION, TASKS, PROFILE, HELP, LOGOUT OPTIONS ARE VISIBLE IN SIDE MENU OR NOT ********************");
		test.log(LogStatus.INFO,
				"******************** VERIFY THE ADMINISTRATION, TASKS, PROFILE, HELP, LOGOUT OPTIONS ARE VISIBLE IN SIDE MENU OR NOT ********************");
		Reporter.log(
				"******************** VERIFY THE ADMINISTRATION, TASKS, PROFILE, HELP, LOGOUT OPTIONS ARE VISIBLE IN SIDE MENU OR NOT ********************");
		log.info(
				"******************** VERIFY THE ADMINISTRATION, TASKS, PROFILE, HELP, LOGOUT OPTIONS ARE VISIBLE IN SIDE MENU OR NOT ********************");

		try {

			// wait for the element
			explicitWaitClickable("questionnaire_settingicon_CSS");

			// click on the settings icon from the top of the screen
			click("questionnaire_settingicon_CSS");
			System.out.println("Clicked on the settings icon.");
			ngDriver.waitForAngularRequestsToFinish();

			// verify administration option is displayed or not
			switchVerification("questionnaire_administrationoption_XPATH", "Administration",
					"The Administration option is not displayed.");

			// verify task option is displayed or not
			switchVerification("questionnaire_tasksoption_XPATH", "Tasks", "The Tasks option is not displayed.");

			// verify profile option is displayed or not
			switchVerification("questionnaire_profileoption_XPATH", "Profile", "The Profile option is not displayed.");

			// verify help option is displayed or not
			switchVerification("questionnaire_helpoption_XPATH", "Help", "The Help option is not displayed.");

			// verify logout option is displayed or not
			switchVerification("sidemenu_logout_CSS", "Logout", "The Logout option is not displayed.");

			// click on the close side menu icon
			click("sidemenu_closeicon_XPATH");
			ngDriver.waitForAngularRequestsToFinish();
			System.out.println("Clicked on the close side menu icon.");

			// refresh the screen
			driver.navigate().refresh();

		} catch (Throwable t) {
			verificationFailed();

			// refresh the screen
			driver.navigate().refresh();

		}

		// VERIFY ENVIRONMENTAL SUMMARY IS VISIBLE

		System.out.println("******************** VERIFY ENVIRONMENTAL SUMMARY IS VISIBLE ********************");
		test.log(LogStatus.INFO, "******************** VERIFY ENVIRONMENTAL SUMMARY IS VISIBLE ********************");
		Reporter.log("******************** VERIFY ENVIRONMENTAL SUMMARY IS VISIBLE ********************");
		log.info("******************** VERIFY ENVIRONMENTAL SUMMARY IS VISIBLE ********************");

		try {

			// synchronization
			explicitWait("propertylist_title_XPATH");

			// verify the property list
			switchVerification("propertylist_title_XPATH", "Property List", "The property list is not displayed.");

			// wait for the element
			Thread.sleep(5000);

			// click on the side menu
			click("ssc_leftsidemenubtn_CSS");
			ngDriver.waitForAngularRequestsToFinish();
			System.out.println("Clicked on the side menu.");

			// wait for the element
			Thread.sleep(5000);

			// click on the environmental option
			click("sidemenu_environmental_CSS");
			ngDriver.waitForAngularRequestsToFinish();
			System.out.println("Clicked on the environmental option.");

			// select the environmental summary option from the dashboard drop down
			select("dashboard_CSS", data.get("dashboard_dd"));
			ngDriver.waitForAngularRequestsToFinish();
			System.out.println("Selected the environmental summary option from the dashboard drop down.");

			// verify environmental summary screen is displayed or not
			switchVerification("environmentalsummary_title_XPATH", "Environmental Summary",
					"The Environmental Summary screen is not displayed.");

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

		// COLOURED ICONS – ENVIRONMENTAL, PROPERTY REPORTS, COMPLIANCE, REPORTS ARE
		// VISIBLE

		System.out.println(
				"******************** COLOURED ICONS – ENVIRONMENTAL, PROPERTY REPORTS, COMPLIANCE, REPORTS ARE VISIBLE ********************");
		test.log(LogStatus.INFO,
				"******************** COLOURED ICONS – ENVIRONMENTAL, PROPERTY REPORTS, COMPLIANCE, REPORTS ARE VISIBLE ********************");
		Reporter.log(
				"******************** COLOURED ICONS – ENVIRONMENTAL, PROPERTY REPORTS, COMPLIANCE, REPORTS ARE VISIBLE ********************");
		log.info(
				"******************** COLOURED ICONS – ENVIRONMENTAL, PROPERTY REPORTS, COMPLIANCE, REPORTS ARE VISIBLE ********************");

		try {

			// wait for the element
			Thread.sleep(5000);

			// click on the side menu
			click("ssc_leftsidemenubtn_CSS");
			ngDriver.waitForAngularRequestsToFinish();
			System.out.println("Clicked on the side menu.");

			// wait for the element
			Thread.sleep(5000);

			// verify environmental option is displayed or not
			switchVerification("sidemenu_environmental_CSS", "Environmental",
					"The Environmental option is not displayed.");

			// verify environmental option is displayed or not
			switchVerification("sidemenu_propertyreport_CSS", "Property Reports",
					"The Property Reports option is not displayed.");

			// verify environmental option is displayed or not
			switchVerification("sidemenu_compliance_CSS", "Compliance", "The Compliance option is not displayed.");

			// verify environmental option is displayed or not
			switchVerification("sidemenu_reports_CSS", "Reports", "The Reports option is not displayed.");

			// refresh the screen
			driver.navigate().refresh();

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

		// VERIFY ADVANCE SEARCH FEATURE FOR THE PROPERTY

		System.out.println("******************** VERIFY ADVANCE SEARCH FEATURE FOR THE PROPERTY ********************");
		test.log(LogStatus.INFO,
				"******************** VERIFY ADVANCE SEARCH FEATURE FOR THE PROPERTY ********************");
		Reporter.log("******************** VERIFY ADVANCE SEARCH FEATURE FOR THE PROPERTY ********************");
		log.info("******************** VERIFY ADVANCE SEARCH FEATURE FOR THE PROPERTY ********************");

		try {

			// double click on the search icon from the top
			Actions action = new Actions(driver);
			WebElement searchIcon = driver.findElement(By.xpath(OR.getProperty("property_searchicon_XPATH")));
			action.doubleClick(searchIcon);
			ngDriver.waitForAngularRequestsToFinish();
			System.out.println("Double clicked on the search icon from the top.");

			// verify advance search screen is displayed
			switchVerification("property_searchscreen_validation1_XPATH", "Advanced Property Search",
					"The Advanced Property Search title is not displayed.");

			// enter the property number in the search field
			type("property_searchscreen_searchtxt_XPATH", data.get("property_number_2"));
			ngDriver.waitForAngularRequestsToFinish();
			System.out.println("Entered the property number in the search field.");

			try {
				// select the active checkbox
				boolean activeckbx = driver
						.findElement(By.xpath(OR.getProperty("property_searchscreen_validation8_XPATH"))).isSelected();

				if (!(activeckbx == true)) {

					// click on the active checkbox
					click("property_searchscreen_validation8_XPATH");
					ngDriver.waitForAngularRequestsToFinish();
					System.out.println("Clicked on the active checkbox.");

					System.out.println("THE ACTIVE CHECKBOX IS SELECTED SUCCESSFULLY.");
					test.log(LogStatus.INFO, "THE ACTIVE CHECKBOX IS SELECTED SUCCESSFULLY.");
					Reporter.log("THE ACTIVE CHECKBOX IS SELECTED SUCCESSFULLY.");
					log.info("THE ACTIVE CHECKBOX IS SELECTED SUCCESSFULLY.");
				} else {
					System.out.println("THE ACTIVE CHECKBOX IS SELECTED SUCCESSFULLY.");
					test.log(LogStatus.INFO, "THE ACTIVE CHECKBOX IS SELECTED SUCCESSFULLY.");
					Reporter.log("THE ACTIVE CHECKBOX IS SELECTED SUCCESSFULLY.");
					log.info("THE ACTIVE CHECKBOX IS SELECTED SUCCESSFULLY.");
				}

			} catch (Throwable t) {
				System.out.println("THE ACTIVE CHECKBOX IS SELECTED SUCCESSFULLY.");
				test.log(LogStatus.INFO, "THE ACTIVE CHECKBOX IS SELECTED SUCCESSFULLY.");
				Reporter.log("THE ACTIVE CHECKBOX IS SELECTED SUCCESSFULLY.");
				log.info("THE ACTIVE CHECKBOX IS SELECTED SUCCESSFULLY.");
			}

			// scroll down the screen till find property button
			WebElement findPropertyBTN = driver
					.findElement(By.xpath(OR.getProperty("property_searchscreen_validation7_XPATH")));
			JavascriptExecutor js = (JavascriptExecutor) driver;
			js.executeScript("arguments[0].scrollIntoView(true);", findPropertyBTN);

			// click on the find property button
			click("property_searchscreen_validation7_XPATH");
			ngDriver.waitForAngularRequestsToFinish();
			System.out.println("Clicked on the find property button.");

			// scroll up the screen
			WebElement title = driver.findElement(By.xpath(OR.getProperty("property_searchscreen_validation1_XPATH")));
			js.executeScript("arguments[0].scrollIntoView(true);", title);

			// verify searched result is displayed or not
			switchVerification("property_searchscreen_searchedresult_XPATH", "Capreit - *Off-Site Incident Report",
					"The Capreit - *Off-Site Incident Report is not displayed.");

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

//		// VERIFY THE RESPECTIVE DOCUMENT DISPLAYED IN THE ENVIRONMENTAL REPORT MODULE
//		// WHEN SUBMIT THE QUESTIONNAIRE FROM PROPERTY LEVEL
//
//		System.out.println(
//				"******************** VERIFY THE RESPECTIVE DOCUMENT DISPLAYED IN THE ENVIRONMENTAL REPORT MODULE WHEN SUBMIT THE QUESTIONNAIRE FROM PROPERTY LEVEL ********************");
//		test.log(LogStatus.INFO,
//				"******************** VERIFY THE RESPECTIVE DOCUMENT DISPLAYED IN THE ENVIRONMENTAL REPORT MODULE WHEN SUBMIT THE QUESTIONNAIRE FROM PROPERTY LEVEL ********************");
//		Reporter.log(
//				"******************** VERIFY THE RESPECTIVE DOCUMENT DISPLAYED IN THE ENVIRONMENTAL REPORT MODULE WHEN SUBMIT THE QUESTIONNAIRE FROM PROPERTY LEVEL ********************");
//		log.info(
//				"******************** VERIFY THE RESPECTIVE DOCUMENT DISPLAYED IN THE ENVIRONMENTAL REPORT MODULE WHEN SUBMIT THE QUESTIONNAIRE FROM PROPERTY LEVEL ********************");
//
//		// GIVE THE ANSWER TO THE RESPECTIVE QUESTIONNAIRE FROM PROPERTY LEVEL
//
//		System.out.println(
//				"******************** GIVE THE ANSWER TO THE RESPECTIVE QUESTIONNAIRE FROM PROPERTY LEVEL ********************");
//		test.log(LogStatus.INFO,
//				"******************** GIVE THE ANSWER TO THE RESPECTIVE QUESTIONNAIRE FROM PROPERTY LEVEL ********************");
//		Reporter.log(
//				"******************** GIVE THE ANSWER TO THE RESPECTIVE QUESTIONNAIRE FROM PROPERTY LEVEL ********************");
//		log.info(
//				"******************** GIVE THE ANSWER TO THE RESPECTIVE QUESTIONNAIRE FROM PROPERTY LEVEL ********************");
//
//		try {
//			// enter the property name in the search field
//			clear("envreports_propertylist_filtertxt_CSS");
//			type("envreports_propertylist_filtertxt_CSS", data.get("property_2"));
//			ngDriver.waitForAngularRequestsToFinish();
//			System.out.println("Entered the property name in the search field.");
//
//			// click on the environmental icon from the property list page
//			click("environmentalicon_CSS");
//			System.out.println("Clicked on the environmental icon of the Property.");
//			ngDriver.waitForAngularRequestsToFinish();
//			System.out.println("Navigate to the environmental screen of the perticular property.");
//
//			// wait for the element
//			explicitWaitClickable("menubtn_CSS");
//
//			// click on the burger menu
//			click("menubtn_CSS");
//			System.out.println("Clicked on the burger menu button successfully!!!");
//			ngDriver.waitForAngularRequestsToFinish();
//
//			// wait for the element
//			explicitWaitClickable("surveyoption_XPATH");
//
//			// click on the survey option from side menu
//			click("surveyoption_XPATH");
//			System.out.println("Clicked on the survey option from side menu");
//			ngDriver.waitForAngularRequestsToFinish();
//			System.out.println("Navigate to the survey screen");
//
//			// select the respective questionnaire from the dropdown
//			select("survey_questionnairedd_CSS", data.get("questionnaire_title"));
//			System.out.println("The questionnaire selected successfully.");
//			ngDriver.waitForAngularRequestsToFinish();
//
//			// verify respective category type displayed or not
//			switchVerification("survey_categorytxt_XPATH", "PCB - Containing Equipment",
//					"The PCB - Containing Equipment is not displayed.");
//
//			// click on the yes option of the first question
//			click("survey_yesanswerbtn_1_CSS");
//			ngDriver.waitForAngularRequestsToFinish();
//			System.out.println("Clicked on the yes option of the first question.");
//
//			// click on the yes option of the second question
//			click("survey_yesanswerbtn_2_CSS");
//			ngDriver.waitForAngularRequestsToFinish();
//			System.out.println("Clicked on the yes option of the second question.");
//
//			// verify 100 % completion of the survey
//			switchVerification("survey_imported_questionnaire_100_XPATH", "100% complete",
//					"The 100% survey is not completed.");
//
//		} catch (Throwable t) {
//			verificationFailed();
//		}
//
//		// click on the home icon from the top of the screen
//		click("questionnaire_homeburgermenubtn_hide_CSS");
//		System.out.println("Clicked on the home icon from the top of the screen.");
//		ngDriver.waitForAngularRequestsToFinish();
//
//		// synchronization
//		explicitWait("propertylist_title_XPATH");
//
//		// verify the property list
//		switchVerification("propertylist_title_XPATH", "Property List", "The property list is not displayed.");
//
//		// VERIFY THE DOCUMENT IS DISPLAYED IN THE ENVIRONMENTAL REPORT LIST WITHOUT
//		// SUBMIT THE SURVEY
//
//		System.out.println(
//				"******************** VERIFY THE DOCUMENT IS DISPLAYED IN THE ENVIRONMENTAL REPORT LIST WITHOUT SUBMIT THE SURVEY ********************");
//		test.log(LogStatus.INFO,
//				"******************** VERIFY THE DOCUMENT IS DISPLAYED IN THE ENVIRONMENTAL REPORT LIST WITHOUT SUBMIT THE SURVEY ********************");
//		Reporter.log(
//				"******************** VERIFY THE DOCUMENT IS DISPLAYED IN THE ENVIRONMENTAL REPORT LIST WITHOUT SUBMIT THE SURVEY ********************");
//		log.info(
//				"******************** VERIFY THE DOCUMENT IS DISPLAYED IN THE ENVIRONMENTAL REPORT LIST WITHOUT SUBMIT THE SURVEY ********************");
//
//		try {
//			// enter the property name in the search field
//			type("envreports_propertylist_filtertxt_CSS", data.get("property_2"));
//			ngDriver.waitForAngularRequestsToFinish();
//			System.out.println("Entered the property name in the search field.");
//
//			// click on the environmental icon
//			click("environmentalicon_CSS");
//			System.out.println("Clicked on the environmental icon.");
//			ngDriver.waitForAngularRequestsToFinish();
//
//			// wait for the element
//			explicitWaitClickable("ssc_leftsidemenubtn_CSS");
//
//			// click on the side menu
//			click("ssc_leftsidemenubtn_CSS");
//			ngDriver.waitForAngularRequestsToFinish();
//			System.out.println("Clicked on the side menu.");
//
//			// wait for the element
//			explicitWaitClickable("envreportoption_XPATH");
//
//			// click on the environmental report
//			click("envreportoption_XPATH");
//			ngDriver.waitForAngularRequestsToFinish();
//			System.out.println("Clicked on the environmental report.");
//
//			// enter the newly created environmental report in the search field
//			clear("task_listofchecklist_filterfield_CSS");
//			type("task_listofchecklist_filterfield_CSS", data.get("questionnaire_title"));
//			ngDriver.waitForAngularRequestsToFinish();
//			System.out.println("Entered the newly created environmental report in the search field.");
//
//			// verify the newly created environmental report is displayed or not
//			deleteVerification("environmental_searchedcreatedreport_morguard12_XPATH",
//					"Test Environmental Report Morguard 12");
//
//		} catch (Throwable t) {
//			verificationFailed();
//		}
//
//		// click on the home icon from the top of the screen
//		click("questionnaire_homeburgermenubtn_hide_CSS");
//		System.out.println("Clicked on the home icon from the top of the screen.");
//		ngDriver.waitForAngularRequestsToFinish();
//
//		// synchronization
//		explicitWait("propertylist_title_XPATH");
//
//		// verify the property list
//		switchVerification("propertylist_title_XPATH", "Property List", "The property list is not displayed.");
//
//		// SUBMIT THE RESPECTIVE QUESTIONNAIRE FROM PROPERTY LEVEL
//
//		System.out.println(
//				"******************** SUBMIT THE RESPECTIVE QUESTIONNAIRE FROM PROPERTY LEVEL ********************");
//		test.log(LogStatus.INFO,
//				"******************** SUBMIT THE RESPECTIVE QUESTIONNAIRE FROM PROPERTY LEVEL ********************");
//		Reporter.log(
//				"******************** SUBMIT THE RESPECTIVE QUESTIONNAIRE FROM PROPERTY LEVEL ********************");
//		log.info("******************** SUBMIT THE RESPECTIVE QUESTIONNAIRE FROM PROPERTY LEVEL ********************");
//
//		try {
//			// enter the property name in the search field
//			clear("envreports_propertylist_filtertxt_CSS");
//			type("envreports_propertylist_filtertxt_CSS", data.get("property_2"));
//			ngDriver.waitForAngularRequestsToFinish();
//			System.out.println("Entered the property name in the search field.");
//
//			// click on the environmental icon from the property list page
//			click("environmentalicon_CSS");
//			System.out.println("Clicked on the environmental icon of the Property.");
//			ngDriver.waitForAngularRequestsToFinish();
//			System.out.println("Navigate to the environmental screen of the perticular property.");
//
//			// wait for the element
//			explicitWaitClickable("menubtn_CSS");
//
//			// click on the burger menu
//			click("menubtn_CSS");
//			System.out.println("Clicked on the burger menu button successfully!!!");
//			ngDriver.waitForAngularRequestsToFinish();
//
//			// wait for the element
//			explicitWaitClickable("surveyoption_XPATH");
//
//			// click on the survey option from side menu
//			click("surveyoption_XPATH");
//			System.out.println("Clicked on the survey option from side menu");
//			ngDriver.waitForAngularRequestsToFinish();
//			System.out.println("Navigate to the survey screen");
//
//			// select the respective questionnaire from the dropdown
//			select("survey_questionnairedd_CSS", data.get("questionnaire_title"));
//			System.out.println("The questionnaire selected successfully.");
//			ngDriver.waitForAngularRequestsToFinish();
//
//			// verify respective category type displayed or not
//			switchVerification("survey_categorytxt_XPATH", "PCB - Containing Equipment",
//					"The PCB - Containing Equipment is not displayed.");
//
//			// scroll down the screen
//			WebElement submitbtn = driver.findElement(By.xpath(OR.getProperty("survey_submitbtn_morguard_XPATH")));
//			JavascriptExecutor js = (JavascriptExecutor) driver;
//			js.executeScript("arguments[0].scrollIntoView(true);", submitbtn);
//
//			// click on the submit button
//			click("survey_submitbtn_morguard_XPATH");
//			ngDriver.waitForAngularRequestsToFinish();
//			System.out.println("Clicked on the submit button.");
//
//			// verify the submitted survey text
//			switchVerification("survey_submittedtext_morguard_XPATH", "The survey has been submitted successfully",
//					"The survey has been submitted successfully message is not displayed.");
//
//		} catch (Throwable t) {
//			verificationFailed();
//		}
//
//		// click on the home icon from the top of the screen
//		click("questionnaire_homeburgermenubtn_hide_CSS");
//		System.out.println("Clicked on the home icon from the top of the screen.");
//		ngDriver.waitForAngularRequestsToFinish();
//
//		// synchronization
//		explicitWait("propertylist_title_XPATH");
//
//		// verify the property list
//		switchVerification("propertylist_title_XPATH", "Property List", "The property list is not displayed.");
//
//		// VERIFY THE DOCUMENT IS DISPLAYED IN THE ENVIRONMENTAL REPORT LIST AFTER
//		// SUBMIT THE SURVEY
//
//		System.out.println(
//				"******************** VERIFY THE DOCUMENT IS DISPLAYED IN THE ENVIRONMENTAL REPORT LIST AFTER SUBMIT THE SURVEY ********************");
//		test.log(LogStatus.INFO,
//				"******************** VERIFY THE DOCUMENT IS DISPLAYED IN THE ENVIRONMENTAL REPORT LIST AFTER SUBMIT THE SURVEY ********************");
//		Reporter.log(
//				"******************** VERIFY THE DOCUMENT IS DISPLAYED IN THE ENVIRONMENTAL REPORT LIST AFTER SUBMIT THE SURVEY ********************");
//		log.info(
//				"******************** VERIFY THE DOCUMENT IS DISPLAYED IN THE ENVIRONMENTAL REPORT LIST AFTER SUBMIT THE SURVEY ********************");
//
//		try {
//			// enter the property name in the search field
//			type("envreports_propertylist_filtertxt_CSS", data.get("property_2"));
//			ngDriver.waitForAngularRequestsToFinish();
//			System.out.println("Entered the property name in the search field.");
//
//			// click on the environmental icon
//			click("environmentalicon_CSS");
//			System.out.println("Clicked on the environmental icon.");
//			ngDriver.waitForAngularRequestsToFinish();
//
//			// wait for the element
//			explicitWaitClickable("ssc_leftsidemenubtn_CSS");
//
//			// click on the side menu
//			click("ssc_leftsidemenubtn_CSS");
//			ngDriver.waitForAngularRequestsToFinish();
//			System.out.println("Clicked on the side menu.");
//
//			// wait for the element
//			explicitWaitClickable("envreportoption_XPATH");
//
//			// click on the environmental report
//			click("envreportoption_XPATH");
//			ngDriver.waitForAngularRequestsToFinish();
//			System.out.println("Clicked on the environmental report.");
//
//			// enter the newly created environmental report in the search field
//			clear("task_listofchecklist_filterfield_CSS");
//			type("task_listofchecklist_filterfield_CSS", data.get("questionnaire_title"));
//			ngDriver.waitForAngularRequestsToFinish();
//			System.out.println("Entered the newly created environmental report in the search field.");
//
//			// verify the newly created environmental report is displayed or not
//			switchVerification("environmental_searchedcreatedreport_morguard12_XPATH",
//					"Test Environmental Report Morguard 12",
//					"The Test Environmental Report Morguard 12 is not displayed.");
//
//		} catch (Throwable t) {
//			verificationFailed();
//		}
//
//		// click on the home icon from the top of the screen
//		click("questionnaire_homeburgermenubtn_hide_CSS");
//		System.out.println("Clicked on the home icon from the top of the screen.");
//		ngDriver.waitForAngularRequestsToFinish();
//
//		// synchronization
//		explicitWait("propertylist_title_XPATH");
//
//		// verify the property list
//		switchVerification("propertylist_title_XPATH", "Property List", "The property list is not displayed.");
//
//		// DELETE THE NEWLY CREATED DOCUMENT IN THE ENVIRONMENTAL REPORT
//
//		System.out.println(
//				"******************** DELETE THE NEWLY CREATED DOCUMENT IN THE ENVIRONMENTAL REPORT ********************");
//		test.log(LogStatus.INFO,
//				"******************** DELETE THE NEWLY CREATED DOCUMENT IN THE ENVIRONMENTAL REPORT ********************");
//		Reporter.log(
//				"******************** DELETE THE NEWLY CREATED DOCUMENT IN THE ENVIRONMENTAL REPORT ********************");
//		log.info(
//				"******************** DELETE THE NEWLY CREATED DOCUMENT IN THE ENVIRONMENTAL REPORT ********************");
//
//		try {
//			// enter the property name in the search field
//			type("envreports_propertylist_filtertxt_CSS", data.get("property_2"));
//			ngDriver.waitForAngularRequestsToFinish();
//			System.out.println("Entered the property name in the search field.");
//
//			// click on the environmental icon
//			click("environmentalicon_CSS");
//			System.out.println("Clicked on the environmental icon.");
//			ngDriver.waitForAngularRequestsToFinish();
//
//			// wait for the element
//			explicitWaitClickable("ssc_leftsidemenubtn_CSS");
//
//			// click on the side menu
//			click("ssc_leftsidemenubtn_CSS");
//			ngDriver.waitForAngularRequestsToFinish();
//			System.out.println("Clicked on the side menu.");
//
//			// wait for the element
//			explicitWaitClickable("envreportoption_XPATH");
//
//			// click on the environmental report
//			click("envreportoption_XPATH");
//			ngDriver.waitForAngularRequestsToFinish();
//			System.out.println("Clicked on the environmental report.");
//
//			// enter the newly created environmental report in the search field
//			clear("task_listofchecklist_filterfield_CSS");
//			type("task_listofchecklist_filterfield_CSS", data.get("questionnaire_title"));
//			ngDriver.waitForAngularRequestsToFinish();
//			System.out.println("Entered the newly created environmental report in the search field.");
//
//			// click on the newly generated environmental report
//			click("environmental_searchedcreatedreport_morguard12_XPATH");
//			ngDriver.waitForAngularRequestsToFinish();
//			System.out.println("Clicked on the newly generated environmental report.");
//
//			// click on the delete button
//			click("envreports_asbestosmaterials_deletebtn_CSS");
//			ngDriver.waitForAngularRequestsToFinish();
//			System.out.println("Clicked on the delete button.");
//
//			// click on the delete button of the confirmation popup
//			click("envreports_asbestosmaterials_modeldeletebtn_CSS");
//			ngDriver.waitForAngularRequestsToFinish();
//			System.out.println("Clicked on the delete button of the confirmation popup.");
//
//			// wait for the element
//			explicitWaitClickable("closetoastmsg_CSS");
//
//			// click on the toaster close button
//			click("closetoastmsg_CSS");
//			ngDriver.waitForAngularRequestsToFinish();
//			System.out.println("Clicked on the toaster close button.");
//
//			// enter the newly created environmental report in the search field
//			clear("task_listofchecklist_filterfield_CSS");
//			type("task_listofchecklist_filterfield_CSS", data.get("questionnaire_title"));
//			ngDriver.waitForAngularRequestsToFinish();
//			System.out.println("Entered the newly created environmental report in the search field.");
//
//			// verify the newly created environmental report is displayed or not
//			deleteVerification("environmental_searchedcreatedreport_morguard12_XPATH",
//					"Test Environmental Report Morguard 12");
//
//		} catch (Throwable t) {
//			verificationFailed();
//		}
//
//		// click on the home icon from the top of the screen
//		click("questionnaire_homeburgermenubtn_hide_CSS");
//		System.out.println("Clicked on the home icon from the top of the screen.");
//		ngDriver.waitForAngularRequestsToFinish();
//
//		// synchronization
//		explicitWait("propertylist_title_XPATH");
//
//		// verify the property list
//		switchVerification("propertylist_title_XPATH", "Property List", "The property list is not displayed.");
//
//		// UNLOCK THE SURVEY AND RESET THE ANSWERS
//
//		System.out.println("******************** UNLOCK THE SURVEY AND RESET THE ANSWERS ********************");
//		test.log(LogStatus.INFO, "******************** UNLOCK THE SURVEY AND RESET THE ANSWERS ********************");
//		Reporter.log("******************** UNLOCK THE SURVEY AND RESET THE ANSWERS ********************");
//		log.info("******************** UNLOCK THE SURVEY AND RESET THE ANSWERS ********************");
//
//		try {
//			// enter the property name in the search field
//			clear("envreports_propertylist_filtertxt_CSS");
//			type("envreports_propertylist_filtertxt_CSS", data.get("property_2"));
//			ngDriver.waitForAngularRequestsToFinish();
//			System.out.println("Entered the property name in the search field.");
//
//			// click on the environmental icon from the property list page
//			click("environmentalicon_CSS");
//			System.out.println("Clicked on the environmental icon of the Property.");
//			ngDriver.waitForAngularRequestsToFinish();
//			System.out.println("Navigate to the environmental screen of the particular property.");
//
//			// wait for the element
//			explicitWaitClickable("menubtn_CSS");
//
//			// click on the burger menu
//			click("menubtn_CSS");
//			System.out.println("Clicked on the burger menu button successfully!!!");
//			ngDriver.waitForAngularRequestsToFinish();
//
//			// wait for the element
//			explicitWaitClickable("surveyoption_XPATH");
//
//			// click on the survey option from side menu
//			click("surveyoption_XPATH");
//			System.out.println("Clicked on the survey option from side menu");
//			ngDriver.waitForAngularRequestsToFinish();
//			System.out.println("Navigate to the survey screen");
//
//			// select the respective questionnaire from the dropdown
//			select("survey_questionnairedd_CSS", data.get("questionnaire_title"));
//			System.out.println("The questionnaire selected successfully.");
//			ngDriver.waitForAngularRequestsToFinish();
//
//			// verify respective category type displayed or not
//			switchVerification("survey_categorytxt_XPATH", "PCB - Containing Equipment",
//					"The PCB - Containing Equipment is not displayed.");
//
//			// click on the unlock icon
//			click("survey_unlockicon_CSS");
//			ngDriver.waitForAngularRequestsToFinish();
//			System.out.println("Clicked on the unlock icon.");
//
//			// click on the reopen button
//			click("survey_approvedbtn_CSS");
//			ngDriver.waitForAngularRequestsToFinish();
//			System.out.println("Clicked on the reopen button.");
//
//			// wait for the element
//			explicitWaitClickable("closetoastmsg_CSS");
//
//			// click on the toaster close button
//			click("closetoastmsg_CSS");
//			ngDriver.waitForAngularRequestsToFinish();
//			System.out.println("Clicked on the toaster close button.");
//
//			// click on the yes option of the first question
//			click("survey_yesanswerbtn_1_CSS");
//			ngDriver.waitForAngularRequestsToFinish();
//			System.out.println("Clicked on the yes option of the first question.");
//
//			// click on the yes option of the second question
//			click("survey_yesanswerbtn_2_CSS");
//			ngDriver.waitForAngularRequestsToFinish();
//			System.out.println("Clicked on the yes option of the second question.");
//
//			// wait for the element
//			Thread.sleep(3000);
//
//			// verify 0 % completion of the survey
//			switchVerification("survey_imported_questionnaire_0_XPATH", "0% complete",
//					"The 0% survey is not completed.");
//
//		} catch (Throwable t) {
//			verificationFailed();
//		}
//
//		// click on the home icon from the top of the screen
//		click("questionnaire_homeburgermenubtn_hide_CSS");
//		System.out.println("Clicked on the home icon from the top of the screen.");
//		ngDriver.waitForAngularRequestsToFinish();
//
//		// synchronization
//		explicitWait("propertylist_title_XPATH");
//
//		// verify the property list
//		switchVerification("propertylist_title_XPATH", "Property List", "The property list is not displayed.");

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
