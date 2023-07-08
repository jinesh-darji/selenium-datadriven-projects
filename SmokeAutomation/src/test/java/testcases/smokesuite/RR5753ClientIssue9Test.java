package testcases.smokesuite;

import java.io.IOException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Hashtable;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.SkipException;
import org.testng.annotations.Test;

import com.relevantcodes.extentreports.LogStatus;

import base.TestBase;
import utilities.TestUtil;

public class RR5753ClientIssue9Test extends TestBase {

	@Test(dataProviderClass = TestUtil.class, dataProvider = "dp")
	public void rR5753ClientIssue9Test(Hashtable<String, String> data) throws IOException, InterruptedException {

		execution(data, "rR5753ClientIssue9Test");

		// refresh the page
		driver.navigate().refresh();
		Thread.sleep(5000);
		driver.navigate().refresh();

		// AUTO-TASK DETAILS IS DISPLAYED IN INSPECTIONS WHEN CONFIGURED FOR THE
		// COMMENT OPTION - RR-5906
		title("AUTO-TASK DETAILS IS DISPLAYED IN INSPECTIONS WHEN CONFIGURED FOR THE COMMENT OPTION - RR-5906");

		// LOGIN WITH ADMIN USER
		title("LOGIN WITH ADMIN USER");

		// wait for the element
		explicitWaitClickable("signinbtn_BTNTEXT");

		// Enter the username
		type("usernametxt_CSS", data.get("username_1"));

		// Enter the password
		type("passwordtxt_CSS", data.get("password_1"));

		// Clicking on the "Sign In" button
		click("signinbtn_BTNTEXT");

		// wait for the element
		explicitWait("propertylist_title_XPATH");

		// verify the property list
		switchVerification("propertylist_title_XPATH", "Property List", "The property list is not displayed.");

		// UPDATE THE SYSTEM COMPANY
		updateCompany(data);

		// VERIFY AUTO TASK DETAILS AT INSPECTIONS LEVEL
		title("VERIFY AUTO TASK DETAILS AT INSPECTIONS LEVEL");

		try {

			// enter the property name in the search field
			type("envreports_propertylist_filtertxt_CSS", data.get("property_1"));

			// click on the environmental icon from the property list page
			click("environmentalicon_CSS");

			// wait for the element
			Thread.sleep(5000);

			// click on the burger menu
			click("menubtn_CSS");

			// wait for the element
			Thread.sleep(5000);

			// click on the checklist/inspection option from side menu
			click("checklist_sidemenu_XPATH");

			// wait for 3 seconds
			Thread.sleep(3000);

			// click on the new checklist button
			click("checklist_newchecklistbtn_CSS");

			// wait for the element
			Thread.sleep(3000);

			// select the questionnaire option from the checklist type dropdown
			select("checklist_addchecklist_checklisttypedd_CSS", data.get("questionnaire_checklist_title"));

			// enter data in the checklist title field
			type("checklist_addchecklist_titletxt_CSS", data.get("checklist_property_title"));

			// click on the save button
			click("checklist_addchecklist_savebtn_CSS");

			// verify questionnaire is selected correctly or not

			String inspectiontitle = driver
					.findElement(By.xpath(OR.getProperty("checklist_wizard_inspectiontitle9_XPATH"))).getText();
			consoleMessage("INSTECTION TITLE : " + inspectiontitle);
			switchVerification("checklist_wizard_inspectiontitle9_XPATH",
					"Test Questionnaire Property Title Smoke Capreit Nine",
					"The Test Questionnaire Property Title Smoke Capreit Nine is not displayed.");

			// wait for the element
			explicitWait("inspection_categoryname_risk_XPATH");

			// clear respective the comment box

			// enter the details in the comment box 1 of the category 1 question 1

			type("inspection_commentbox1_risk_XPATH", data.get("comment_1"));

			// click on the SAP Vacancy Report category label
			click("inspection_categoryname_risk_XPATH");

			// wait for the element
			Thread.sleep(5000);

			// scroll down the screen

			scrollByPixel(500);

			// verify validation 1
			switchVerification("survey_autotask_validation1_risk_XPATH", "Task/Action",
					"The Task/Action text is not displayed.");

			// verify validation 2
			switchVerification("inspection_autotask_validation2_risk_XPATH", "(1) Electrical (Light Fixture)",
					"The (1) Electrical (Light Fixture) text is not displayed.");

			// verify validation 3
			switchVerification("inspection_autotask_validation3_risk_XPATH", "Assigned To: ResPortal Entry",
					"The Assigned To: ResPortal Entry text is not displayed.");

			// verify validation 4
			LocalDate currentDate = LocalDate.now();
			LocalDate futureDate = currentDate.plusYears(1);
			String futureDateString = futureDate.toString();

			try {
				String duedate = (driver.findElement(By.xpath(OR.getProperty("survey_autotask_validation6_risk_XPATH")))
						.getAttribute("value")).trim();

				if (duedate.equals(futureDateString)) {
					successMessage("The due date is verified successfully.");
				} else {
					verificationFailed();
				}
			} catch (Throwable t) {
				verificationFailedMessage("The due date is displayed incorrect.");
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

		// GENERATE THE AUTO TASKS IN THE TASK MODULE
		title("GENERATE THE AUTO TASKS IN THE TASK MODULE");

		try {
			// enter the property name in the search field
			type("envreports_propertylist_filtertxt_CSS", data.get("property_1"));

			// click on the task icon from the property list page
			click("taskicon_CSS");

			// wait for the clear button
			explicitWaitClickable("task_clearbtn_XPATH");

			// click on the clear button
			click("task_clearbtn_XPATH");

			// enter auto generated task in the search field
			type("survey_task_searchfield_CSS", data.get("autotask_1"));

			// click on the search button
			click("survey_task_searchfield_CSS");

			// verify the auto generated task 1
			switchVerification("inspection_autotask1_risk_XPATH", "Electrical (Light Fixture)",
					"The Electrical (Light Fixture) task is not displayed.");

		} catch (Throwable t) {
			verificationFailed();
		}

		// click on the home icon from the top of the screen
		click("questionnaire_homeburgermenubtn_hide_CSS");

		// synchronization
		explicitWait("propertylist_title_XPATH");

		// verify the property list
		switchVerification("propertylist_title_XPATH", "Property List", "The property list is not displayed.");

		// REMOVE THE DETAILS FROM THE COMMENT BOXES
		title("REMOVE THE DETAILS FROM THE COMMENT BOXES");

		try {

			// enter the property name in the search field
			type("envreports_propertylist_filtertxt_CSS", data.get("property_1"));

			// click on the environmental icon from the property list page
			click("environmentalicon_CSS");

			// wait for the element
			Thread.sleep(5000);

			// click on the burger menu
			click("menubtn_CSS");

			// wait for the element
			Thread.sleep(5000);

			// click on the checklist/inspection option from side menu
			click("checklist_sidemenu_XPATH");

			// wait for 3 seconds
			Thread.sleep(3000);

			// click on the new created checklist
			click("inspection_newlycreated_clientissue_XPATH");

			// verify questionnaire is selected correctly or not
			String inspectiontitle = driver
					.findElement(By.xpath(OR.getProperty("checklist_wizard_inspectiontitle9_XPATH"))).getText();
			consoleMessage("INSTECTION TITLE : " + inspectiontitle);
			switchVerification("checklist_wizard_inspectiontitle9_XPATH",
					"Test Questionnaire Property Title Smoke Capreit Nine",
					"The Test Questionnaire Property Title Smoke Capreit Nine is not displayed.");

			// wait for the element
			explicitWait("inspection_categoryname_risk_XPATH");

			// clear respective the comment box

			// click on the SAP Vacancy Report category label
			click("inspection_categoryname_risk_XPATH");

		} catch (Throwable t) {
			verificationFailed();
		}

		// click on the home icon from the top of the screen
		click("questionnaire_homeburgermenubtn_hide_CSS");

		// synchronization
		explicitWait("propertylist_title_XPATH");

		// verify the property list
		switchVerification("propertylist_title_XPATH", "Property List", "The property list is not displayed.");

		// REMOVE THE AUTO GENERATED TASKS IN THE TASK MODULE
		title("REMOVE THE AUTO GENERATED TASKS IN THE TASK MODULE");

		try {
			// enter the property name in the search field
			type("envreports_propertylist_filtertxt_CSS", data.get("property_1"));

			// click on the task icon from the property list page
			click("taskicon_CSS");

			// wait for the clear button
			explicitWaitClickable("task_clearbtn_XPATH");

			// click on the clear button
			click("task_clearbtn_XPATH");

			// enter auto generated task in the search field
			type("survey_task_searchfield_CSS", data.get("autotask_1"));

			// click on the search button
			click("survey_task_searchfield_CSS");

			// verify the auto generated task 1
			deleteVerification("inspection_autotask1_risk_XPATH", "Electrical (Light Fixture)");

		} catch (Throwable t) {
			verificationFailed();
		}

		// click on the home icon from the top of the screen
		click("questionnaire_homeburgermenubtn_hide_CSS");

		// synchronization
		explicitWait("propertylist_title_XPATH");

		// verify the property list
		switchVerification("propertylist_title_XPATH", "Property List", "The property list is not displayed.");

		// DELETE THE NEWLY CREATED INSPECTION
		title("DELETE THE NEWLY CREATED INSPECTION");

		try {

			// enter the property name in the search field
			type("envreports_propertylist_filtertxt_CSS", data.get("property_1"));

			// click on the environmental icon from the property list page
			click("environmentalicon_CSS");

			// wait for the element
			Thread.sleep(5000);

			// click on the burger menu
			click("menubtn_CSS");

			// wait for the element
			Thread.sleep(5000);

			// click on the checklist/inspection option from side menu
			click("checklist_sidemenu_XPATH");

			// wait for 3 seconds
			Thread.sleep(3000);

			// click on the action icon of the new created checklist
			click("inspection_newlycreated_clientissue_actionicon_XPATH");

			// wait for the element
			explicitWaitClickable("inspection_newlycreated_clientissue_actionicon_deleteoption_XPATH");

			// click on the delete option
			click("inspection_newlycreated_clientissue_actionicon_deleteoption_XPATH");

			// wait for the element
			explicitWaitClickable("checklist_deletebtn_XPATH");

			// click on the delete button
			click("checklist_deletebtn_XPATH");

			// verify deleted inspection is displayed or not
			deleteVerification("inspection_newlycreated_clientissue_XPATH",
					"Test Questionnaire Property Title Smoke Capreit Nine");

		} catch (Throwable t) {
			verificationFailed();
		}

		// click on the home icon from the top of the screen
		click("questionnaire_homeburgermenubtn_hide_CSS");

		// synchronization
		explicitWait("propertylist_title_XPATH");

		// verify the property list
		switchVerification("propertylist_title_XPATH", "Property List", "The property list is not displayed.");

		try {
			// wait for the 5 seconds
			Thread.sleep(5000);

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