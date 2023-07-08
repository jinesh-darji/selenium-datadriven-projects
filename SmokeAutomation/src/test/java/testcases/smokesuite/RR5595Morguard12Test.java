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

		execution(data, "rR5595Morguard12Test");

		// refresh the page
		driver.navigate().refresh();
		Thread.sleep(5000);
		driver.navigate().refresh();

		// LOGIN WITH ENVIRO MANAGER USER
		title("LOGIN WITH ENVIRO MANAGER USER");

		try {
			// wait for the element
			explicitWaitClickable("signinbtn_BTNTEXT");

			// Enter the username
			type("usernametxt_CSS", data.get("username_2"));

			// Enter the password
			type("passwordtxt_CSS", data.get("password"));

			// Clicking on the "Sign In" button
			click("signinbtn_BTNTEXT");

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
		title("VERIFY PROPERTY, SEARCH PROPERTY, ADMINISTRATION, TASKS, PROFILE, HELP, LOGOUT ARE VISIBLE");

		// VERIFY THE PROPERTY IS VISIBLE OR NOT
		title("VERIFY THE PROPERTY IS VISIBLE OR NOT");

		try {

			// enter the property name in the search field

			type("envreports_propertylist_filtertxt_CSS", data.get("property_2"));

			// verify the respective searched property is displayed or not
			switchVerification("administration_security_groupproperty_addedproperty_XPATH", "CAPREIT - White Frost",
					"The CAPREIT - White Frost property is not displayed.");

			successMessage("THE PROPERTY IS VISIBLE SUCCESSFULLY");

		} catch (Throwable t) {
			verificationFailedMessage("THE PROPERTY IS NOT VISIBLE");
		}

		// VERIFY THE SEARCH PROPERTY ICON IS VISIBLE OR NOT
		title("VERIFY THE SEARCH PROPERTY ICON IS VISIBLE OR NOT");

		try {

			boolean searchIcon = driver.findElement(By.xpath(OR.getProperty("property_searchicon_XPATH")))
					.isDisplayed();

			if (searchIcon == true) {
				successMessage("THE SEARCH PROPERTY ICON IS VISIBLE SUCCESSFULLY");

			} else {
				verificationFailedMessage("THE SEARCH PROPERTY ICON IS NOT VISIBLE");
			}

		} catch (Throwable t) {
			verificationFailedMessage("THE SEARCH PROPERTY ICON IS NOT VISIBLE");
		}

		// VERIFY THE ADMINISTRATION, TASKS, PROFILE, HELP, LOGOUT OPTIONS ARE VISIBLE
		// IN SIDE MENU OR NOT
		title("VERIFY THE ADMINISTRATION, TASKS, PROFILE, HELP, LOGOUT OPTIONS ARE VISIBLE IN SIDE MENU OR NOT");

		try {

			// wait for the element
			explicitWaitClickable("questionnaire_settingicon_CSS");

			// click on the settings icon from the top of the screen
			click("questionnaire_settingicon_CSS");

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

			// refresh the screen
			driver.navigate().refresh();

		} catch (Throwable t) {
			verificationFailed();

			// refresh the screen
			driver.navigate().refresh();

		}

		// VERIFY ENVIRONMENTAL SUMMARY IS VISIBLE
		title("VERIFY ENVIRONMENTAL SUMMARY IS VISIBLE");

		try {

			// synchronization
			explicitWait("propertylist_title_XPATH");

			// verify the property list
			switchVerification("propertylist_title_XPATH", "Property List", "The property list is not displayed.");

			// wait for the element
			Thread.sleep(5000);

			// click on the side menu
			click("ssc_leftsidemenubtn_CSS");

			// wait for the element
			Thread.sleep(5000);

			// click on the environmental option
			click("sidemenu_environmental_CSS");

			// select the environmental summary option from the dashboard drop down
			select("dashboard_CSS", data.get("dashboard_dd"));

			// verify environmental summary screen is displayed or not
			switchVerification("environmentalsummary_title_XPATH", "Environmental Summary",
					"The Environmental Summary screen is not displayed.");

		} catch (Throwable t) {
			verificationFailed();
		}

		// click on the home icon from the top of the screen
		click("questionnaire_homeburgermenubtn_hide_CSS");

		// synchronization
		explicitWait("propertylist_title_XPATH");

		// verify the property list
		switchVerification("propertylist_title_XPATH", "Property List", "The property list is not displayed.");

		// COLOURED ICONS � ENVIRONMENTAL, PROPERTY REPORTS, COMPLIANCE, REPORTS ARE
		// VISIBLE
		title("COLOURED ICONS � ENVIRONMENTAL, PROPERTY REPORTS, COMPLIANCE, REPORTS ARE VISIBLE");

		try {

			// wait for the element
			Thread.sleep(5000);

			// click on the side menu
			click("ssc_leftsidemenubtn_CSS");

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

		// synchronization
		explicitWait("propertylist_title_XPATH");

		// verify the property list
		switchVerification("propertylist_title_XPATH", "Property List", "The property list is not displayed.");

		// VERIFY ADVANCE SEARCH FEATURE FOR THE PROPERTY
		title("VERIFY ADVANCE SEARCH FEATURE FOR THE PROPERTY");

		try {

			// double click on the search icon from the top
			Actions action = new Actions(driver);
			WebElement searchIcon = driver.findElement(By.xpath(OR.getProperty("property_searchicon_XPATH")));
			action.doubleClick(searchIcon);

			// verify advance search screen is displayed
			switchVerification("property_searchscreen_validation1_XPATH", "Advanced Property Search",
					"The Advanced Property Search title is not displayed.");

			// enter the property number in the search field
			type("property_searchscreen_searchtxt_XPATH", data.get("property_number_2"));

			try {
				// select the active checkbox
				boolean activeckbx = driver
						.findElement(By.xpath(OR.getProperty("property_searchscreen_validation8_XPATH"))).isSelected();

				if (!(activeckbx == true)) {

					// click on the active checkbox
					click("property_searchscreen_validation8_XPATH");

					successMessage("THE ACTIVE CHECKBOX IS SELECTED SUCCESSFULLY.");
				} else {
					successMessage("THE ACTIVE CHECKBOX IS SELECTED SUCCESSFULLY.");
				}

			} catch (Throwable t) {
				successMessage("THE ACTIVE CHECKBOX IS SELECTED SUCCESSFULLY.");
			}

			// scroll down the screen till find property button
			scrollTillElement("property_searchscreen_validation7_XPATH");

			// click on the find property button
			click("property_searchscreen_validation7_XPATH");

			// scroll up the screen
			scrollTillElement("property_searchscreen_validation1_XPATH");

			// verify searched result is displayed or not
			switchVerification("property_searchscreen_searchedresult_XPATH", "Capreit - *Off-Site Incident Report",
					"The Capreit - *Off-Site Incident Report is not displayed.");

		} catch (Throwable t) {
			verificationFailed();
		}

		// click on the home icon from the top of the screen
		click("questionnaire_homeburgermenubtn_hide_CSS");

		// synchronization
		explicitWait("propertylist_title_XPATH");

		// verify the property list
		switchVerification("propertylist_title_XPATH", "Property List", "The property list is not displayed.");

//		// VERIFY THE RESPECTIVE DOCUMENT DISPLAYED IN THE ENVIRONMENTAL REPORT MODULE
//		// WHEN SUBMIT THE QUESTIONNAIRE FROM PROPERTY LEVEL
//		title("VERIFY THE RESPECTIVE DOCUMENT DISPLAYED IN THE ENVIRONMENTAL REPORT MODULE WHEN SUBMIT THE QUESTIONNAIRE FROM PROPERTY LEVEL");
//
//		// GIVE THE ANSWER TO THE RESPECTIVE QUESTIONNAIRE FROM PROPERTY LEVEL
//		title("GIVE THE ANSWER TO THE RESPECTIVE QUESTIONNAIRE FROM PROPERTY LEVEL");
//
//		try {
//			// enter the property name in the search field
//
//			type("envreports_propertylist_filtertxt_CSS", data.get("property_2"));
//
//			// click on the environmental icon from the property list page
//			click("environmentalicon_CSS");
//
//			// wait for the element
//			explicitWaitClickable("menubtn_CSS");
//
//			// click on the burger menu
//			click("menubtn_CSS");
//
//			// wait for the element
//			explicitWaitClickable("surveyoption_XPATH");
//
//			// click on the survey option from side menu
//			click("surveyoption_XPATH");
//
//			// select the respective questionnaire from the dropdown
//			select("survey_questionnairedd_CSS", data.get("questionnaire_title"));
//
//			// verify respective category type displayed or not
//			switchVerification("survey_categorytxt_XPATH", "PCB - Containing Equipment",
//					"The PCB - Containing Equipment is not displayed.");
//
//			// click on the yes option of the first question
//			click("survey_yesanswerbtn_1_CSS");
//
//			// click on the yes option of the second question
//			click("survey_yesanswerbtn_2_CSS");
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
//
//		// synchronization
//		explicitWait("propertylist_title_XPATH");
//
//		// verify the property list
//		switchVerification("propertylist_title_XPATH", "Property List", "The property list is not displayed.");
//
//		// VERIFY THE DOCUMENT IS DISPLAYED IN THE ENVIRONMENTAL REPORT LIST WITHOUT
//		// SUBMIT THE SURVEY
//		title("VERIFY THE DOCUMENT IS DISPLAYED IN THE ENVIRONMENTAL REPORT LIST WITHOUT SUBMIT THE SURVEY");
//
//		try {
//			// enter the property name in the search field
//			type("envreports_propertylist_filtertxt_CSS", data.get("property_2"));
//
//			// click on the environmental icon
//			click("environmentalicon_CSS");
//
//			// wait for the element
//			explicitWaitClickable("ssc_leftsidemenubtn_CSS");
//
//			// click on the side menu
//			click("ssc_leftsidemenubtn_CSS");
//
//			// wait for the element
//			explicitWaitClickable("envreportoption_XPATH");
//
//			// click on the environmental report
//			click("envreportoption_XPATH");
//
//			// enter the newly created environmental report in the search field
//
//			type("task_listofchecklist_filterfield_CSS", data.get("questionnaire_title"));
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
//
//		// synchronization
//		explicitWait("propertylist_title_XPATH");
//
//		// verify the property list
//		switchVerification("propertylist_title_XPATH", "Property List", "The property list is not displayed.");
//
//		// SUBMIT THE RESPECTIVE QUESTIONNAIRE FROM PROPERTY LEVEL
//		title("SUBMIT THE RESPECTIVE QUESTIONNAIRE FROM PROPERTY LEVEL");
//
//		try {
//			// enter the property name in the search field
//
//			type("envreports_propertylist_filtertxt_CSS", data.get("property_2"));
//
//			// click on the environmental icon from the property list page
//			click("environmentalicon_CSS");
//
//			// wait for the element
//			explicitWaitClickable("menubtn_CSS");
//
//			// click on the burger menu
//			click("menubtn_CSS");
//
//			// wait for the element
//			explicitWaitClickable("surveyoption_XPATH");
//
//			// click on the survey option from side menu
//			click("surveyoption_XPATH");
//
//			// select the respective questionnaire from the dropdown
//			select("survey_questionnairedd_CSS", data.get("questionnaire_title"));
//
//			// verify respective category type displayed or not
//			switchVerification("survey_categorytxt_XPATH", "PCB - Containing Equipment",
//					"The PCB - Containing Equipment is not displayed.");
//
//			// scroll down the screen
//			WebElement submitbtn = driver.findElement(By.xpath(OR.getProperty("survey_submitbtn_morguard_XPATH")));
//
//			js.executeScript("arguments[0].scrollIntoView(true);", submitbtn);
//
//			// click on the submit button
//			click("survey_submitbtn_morguard_XPATH");
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
//
//		// synchronization
//		explicitWait("propertylist_title_XPATH");
//
//		// verify the property list
//		switchVerification("propertylist_title_XPATH", "Property List", "The property list is not displayed.");
//
//		// VERIFY THE DOCUMENT IS DISPLAYED IN THE ENVIRONMENTAL REPORT LIST AFTER
//		// SUBMIT THE SURVEY
//		title("VERIFY THE DOCUMENT IS DISPLAYED IN THE ENVIRONMENTAL REPORT LIST AFTER SUBMIT THE SURVEY");
//
//		try {
//			// enter the property name in the search field
//			type("envreports_propertylist_filtertxt_CSS", data.get("property_2"));
//
//			// click on the environmental icon
//			click("environmentalicon_CSS");
//
//			// wait for the element
//			explicitWaitClickable("ssc_leftsidemenubtn_CSS");
//
//			// click on the side menu
//			click("ssc_leftsidemenubtn_CSS");
//
//			// wait for the element
//			explicitWaitClickable("envreportoption_XPATH");
//
//			// click on the environmental report
//			click("envreportoption_XPATH");
//
//			// enter the newly created environmental report in the search field
//
//			type("task_listofchecklist_filterfield_CSS", data.get("questionnaire_title"));
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
//
//		// synchronization
//		explicitWait("propertylist_title_XPATH");
//
//		// verify the property list
//		switchVerification("propertylist_title_XPATH", "Property List", "The property list is not displayed.");
//
//		// DELETE THE NEWLY CREATED DOCUMENT IN THE ENVIRONMENTAL REPORT
//		title("DELETE THE NEWLY CREATED DOCUMENT IN THE ENVIRONMENTAL REPORT");
//
//		try {
//			// enter the property name in the search field
//			type("envreports_propertylist_filtertxt_CSS", data.get("property_2"));
//
//			// click on the environmental icon
//			click("environmentalicon_CSS");
//
//			// wait for the element
//			explicitWaitClickable("ssc_leftsidemenubtn_CSS");
//
//			// click on the side menu
//			click("ssc_leftsidemenubtn_CSS");
//
//			// wait for the element
//			explicitWaitClickable("envreportoption_XPATH");
//
//			// click on the environmental report
//			click("envreportoption_XPATH");
//
//			// enter the newly created environmental report in the search field
//
//			type("task_listofchecklist_filterfield_CSS", data.get("questionnaire_title"));
//
//			// click on the newly generated environmental report
//			click("environmental_searchedcreatedreport_morguard12_XPATH");
//
//			// click on the delete button
//			click("envreports_asbestosmaterials_deletebtn_CSS");
//
//			// click on the delete button of the confirmation popup
//			click("envreports_asbestosmaterials_modeldeletebtn_CSS");
//
//			// wait for the element
//			explicitWaitClickable("closetoastmsg_CSS");
//
//			// click on the toaster close button
//			click("closetoastmsg_CSS");
//
//			// enter the newly created environmental report in the search field
//
//			type("task_listofchecklist_filterfield_CSS", data.get("questionnaire_title"));
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
//
//		// synchronization
//		explicitWait("propertylist_title_XPATH");
//
//		// verify the property list
//		switchVerification("propertylist_title_XPATH", "Property List", "The property list is not displayed.");
//
//		// UNLOCK THE SURVEY AND RESET THE ANSWERS
//		title("UNLOCK THE SURVEY AND RESET THE ANSWERS");
//
//		try {
//			// enter the property name in the search field
//
//			type("envreports_propertylist_filtertxt_CSS", data.get("property_2"));
//
//			// click on the environmental icon from the property list page
//			click("environmentalicon_CSS");
//
//			// wait for the element
//			explicitWaitClickable("menubtn_CSS");
//
//			// click on the burger menu
//			click("menubtn_CSS");
//
//			// wait for the element
//			explicitWaitClickable("surveyoption_XPATH");
//
//			// click on the survey option from side menu
//			click("surveyoption_XPATH");
//
//			// select the respective questionnaire from the dropdown
//			select("survey_questionnairedd_CSS", data.get("questionnaire_title"));
//
//			// verify respective category type displayed or not
//			switchVerification("survey_categorytxt_XPATH", "PCB - Containing Equipment",
//					"The PCB - Containing Equipment is not displayed.");
//
//			// click on the unlock icon
//			click("survey_unlockicon_CSS");
//
//			// click on the reopen button
//			click("survey_approvedbtn_CSS");
//
//			// wait for the element
//			explicitWaitClickable("closetoastmsg_CSS");
//
//			// click on the toaster close button
//			click("closetoastmsg_CSS");
//
//			// click on the yes option of the first question
//			click("survey_yesanswerbtn_1_CSS");
//
//			// click on the yes option of the second question
//			click("survey_yesanswerbtn_2_CSS");
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

			// wait for the element
			explicitWaitClickable("sidemenu_logout_CSS");

			// click on the logout option from the side menu
			click("sidemenu_logout_CSS");

			// wait for the element
			explicitWaitClickable("signinbtn_BTNTEXT");

		} catch (Throwable t) {
			verificationFailed();
		}

	}
}