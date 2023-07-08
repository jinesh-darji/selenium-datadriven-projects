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

		if (!(TestUtil.isTestRunnable("rR5753ClientIssue9Test", excel))) {

			throw new SkipException(
					"Skipping the test " + "rR5753ClientIssue9Test".toUpperCase() + "as the Run mode is NO");
		}

		if (!data.get("runmode").equals("Y")) {

			throw new SkipException("Skipping the test case as the Run Mode for data set is NO");
		}

		// refresh the page
		driver.navigate().refresh();
		Thread.sleep(5000);
		driver.navigate().refresh();

		// AUTO-TASK DETAILS IS DISPLAYED IN INSPECTIONS WHEN CONFIGURED FOR THE
		// COMMENT OPTION - RR-5906

		System.out.println(
				"******************** AUTO-TASK DETAILS IS DISPLAYED IN INSPECTIONS WHEN CONFIGURED FOR THE COMMENT OPTION - RR-5906 ********************");
		test.log(LogStatus.INFO,
				"******************** AUTO-TASK DETAILS IS DISPLAYED IN INSPECTIONS WHEN CONFIGURED FOR THE COMMENT OPTION - RR-5906 ********************");
		Reporter.log(
				"******************** AUTO-TASK DETAILS IS DISPLAYED IN INSPECTIONS WHEN CONFIGURED FOR THE COMMENT OPTION - RR-5906 ********************");
		log.info(
				"******************** AUTO-TASK DETAILS IS DISPLAYED IN INSPECTIONS WHEN CONFIGURED FOR THE COMMENT OPTION - RR-5906 ********************");

		System.out.println("Navigate to the Home Screen i.e. Property List Screen.");

		// LOGIN WITH ADMIN USER

		System.out.println("******************** LOGIN WITH ADMIN USER ********************");
		test.log(LogStatus.INFO, "******************** LOGIN WITH ADMIN USER ********************");
		Reporter.log("******************** LOGIN WITH ADMIN USER ********************");
		log.info("******************** LOGIN WITH ADMIN USER ********************");

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

		// VERIFY AUTO TASK DETAILS AT INSPECTIONS LEVEL

		System.out.println("******************** VERIFY AUTO TASK DETAILS AT INSPECTIONS LEVEL ********************");
		test.log(LogStatus.INFO,
				"******************** VERIFY AUTO TASK DETAILS AT INSPECTIONS LEVEL ********************");
		Reporter.log("******************** VERIFY AUTO TASK DETAILS AT INSPECTIONS LEVEL ********************");
		log.info("******************** VERIFY AUTO TASK DETAILS AT INSPECTIONS LEVEL ********************");

		try {

			// enter the property name in the search field
			type("envreports_propertylist_filtertxt_CSS", data.get("property_1"));
			ngDriver.waitForAngularRequestsToFinish();
			System.out.println("Entered the property name in the search field.");

			// click on the environmental icon from the property list page
			click("environmentalicon_CSS");
			System.out.println("Clicked on the environmental icon of the Property.");
			ngDriver.waitForAngularRequestsToFinish();
			System.out.println("Navigate to the environmental screen of the perticular property.");

			// wait for the element
			Thread.sleep(5000);

			// click on the burger menu
			click("menubtn_CSS");
			System.out.println("Clicked on the burger menu button successfully!!!");
			ngDriver.waitForAngularRequestsToFinish();

			// wait for the element
			Thread.sleep(5000);

			// click on the checklist/inspection option from side menu
			click("checklist_sidemenu_XPATH");
			System.out.println("Clicked on the checklist/inspection option from side menu");
			ngDriver.waitForAngularRequestsToFinish();
			System.out.println("Navigate to the checklist/inspection screen");

			// wait for 3 seconds
			Thread.sleep(3000);

			// click on the new checklist button
			click("checklist_newchecklistbtn_CSS");
			ngDriver.waitForAngularRequestsToFinish();
			System.out.println("Selected property from the property drop down.");

			// wait for the element
			Thread.sleep(3000);

			// select the questionnaire option from the checklist type dropdown
			select("checklist_addchecklist_checklisttypedd_CSS", data.get("questionnaire_checklist_title"));
			System.out.println("The created questionaaire is selected from the checklist type dropdown.");
			ngDriver.waitForAngularRequestsToFinish();

			// enter data in the checklist title field
			type("checklist_addchecklist_titletxt_CSS", data.get("checklist_property_title"));
			System.out.println("Entered the data in the checklist title field.");
			ngDriver.waitForAngularRequestsToFinish();

			// click on the save button
			click("checklist_addchecklist_savebtn_CSS");
			System.out.println("Clicked on the save button.");
			ngDriver.waitForAngularRequestsToFinish();

			// verify questionnaire is selected correctly or not

			String inspectiontitle = driver
					.findElement(By.xpath(OR.getProperty("checklist_wizard_inspectiontitle9_XPATH"))).getText();
			System.out.println("INSTECTION TITLE : " + inspectiontitle);
			switchVerification("checklist_wizard_inspectiontitle9_XPATH",
					"Test Questionnaire Property Title Smoke Capreit Nine",
					"The Test Questionnaire Property Title Smoke Capreit Nine is not displayed.");

			// wait for the element
			explicitWait("inspection_categoryname_risk_XPATH");

			// clear respective the comment box
			clear("inspection_commentbox1_risk_XPATH");

			// enter the details in the comment box 1 of the category 1 question 1
			clear("inspection_commentbox1_risk_XPATH");
			type("inspection_commentbox1_risk_XPATH", data.get("comment_1"));
			ngDriver.waitForAngularRequestsToFinish();
			System.out.println("Entered the details in the comment box 1 of the category 1 question 1.");

			// click on the SAP Vacancy Report category label
			click("inspection_categoryname_risk_XPATH");
			ngDriver.waitForAngularRequestsToFinish();
			System.out.println("Clicked on the SAP Vacancy Report category label.");

			// wait for the element
			Thread.sleep(5000);

			// scroll down the screen
			JavascriptExecutor js = (JavascriptExecutor) driver;
			js.executeScript("window.scrollBy(0,500)");

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

					System.out.println("The due date is verified successfully.");
					test.log(LogStatus.INFO, "The due date is verified successfully.");
					Reporter.log("The due date is verified successfully.");
					log.info("The due date is verified successfully.");
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
		System.out.println("Clicked on the home icon from the top of the screen.");
		ngDriver.waitForAngularRequestsToFinish();

		// synchronization
		explicitWait("propertylist_title_XPATH");

		// verify the property list
		switchVerification("propertylist_title_XPATH", "Property List", "The property list is not displayed.");

		// GENERATE THE AUTO TASKS IN THE TASK MODULE

		System.out.println("******************** GENERATE THE AUTO TASKS IN THE TASK MODULE ********************");
		test.log(LogStatus.INFO,
				"******************** GENERATE THE AUTO TASKS IN THE TASK MODULE ********************");
		Reporter.log("******************** GENERATE THE AUTO TASKS IN THE TASK MODULE ********************");
		log.info("******************** GENERATE THE AUTO TASKS IN THE TASK MODULE ********************");

		try {
			// enter the property name in the search field
			type("envreports_propertylist_filtertxt_CSS", data.get("property_1"));
			ngDriver.waitForAngularRequestsToFinish();
			System.out.println("Entered the property name in the search field.");

			// click on the task icon from the property list page
			click("taskicon_CSS");
			System.out.println("Clicked on the task icon of the Property.");
			ngDriver.waitForAngularRequestsToFinish();
			System.out.println("Navigate to the task screen of the perticular property.");

			// wait for the clear button
			explicitWaitClickable("task_clearbtn_XPATH");

			// click on the clear button
			click("task_clearbtn_XPATH");
			ngDriver.waitForAngularRequestsToFinish();
			System.out.println("Clicked on the clear button.");

			// enter auto generated task in the search field
			type("survey_task_searchfield_CSS", data.get("autotask_1"));
			ngDriver.waitForAngularRequestsToFinish();
			System.out.println("enter auto generated task in the search field.");

			// click on the search button
			click("survey_task_searchfield_CSS");
			ngDriver.waitForAngularRequestsToFinish();
			System.out.println("Clicked on the search button.");

			// verify the auto generated task 1
			switchVerification("inspection_autotask1_risk_XPATH", "Electrical (Light Fixture)",
					"The Electrical (Light Fixture) task is not displayed.");

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

		// REMOVE THE DETAILS FROM THE COMMENT BOXES

		System.out.println("***************** REMOVE THE DETAILS FROM THE COMMENT BOXES *****************");
		test.log(LogStatus.INFO, "***************** REMOVE THE DETAILS FROM THE COMMENT BOXES *****************");
		Reporter.log("***************** REMOVE THE DETAILS FROM THE COMMENT BOXES *****************");
		log.info("***************** REMOVE THE DETAILS FROM THE COMMENT BOXES *****************");

		try {

			// enter the property name in the search field
			type("envreports_propertylist_filtertxt_CSS", data.get("property_1"));
			ngDriver.waitForAngularRequestsToFinish();
			System.out.println("Entered the property name in the search field.");

			// click on the environmental icon from the property list page
			click("environmentalicon_CSS");
			System.out.println("Clicked on the environmental icon of the Property.");
			ngDriver.waitForAngularRequestsToFinish();
			System.out.println("Navigate to the environmental screen of the perticular property.");

			// wait for the element
			Thread.sleep(5000);

			// click on the burger menu
			click("menubtn_CSS");
			System.out.println("Clicked on the burger menu button successfully!!!");
			ngDriver.waitForAngularRequestsToFinish();

			// wait for the element
			Thread.sleep(5000);

			// click on the checklist/inspection option from side menu
			click("checklist_sidemenu_XPATH");
			System.out.println("Clicked on the checklist/inspection option from side menu");
			ngDriver.waitForAngularRequestsToFinish();
			System.out.println("Navigate to the checklist/inspection screen");

			// wait for 3 seconds
			Thread.sleep(3000);

			// click on the new created checklist
			click("inspection_newlycreated_clientissue_XPATH");
			ngDriver.waitForAngularRequestsToFinish();
			System.out.println("Clicked on the new created checklist.");

			// verify questionnaire is selected correctly or not
			String inspectiontitle = driver
					.findElement(By.xpath(OR.getProperty("checklist_wizard_inspectiontitle9_XPATH"))).getText();
			System.out.println("INSTECTION TITLE : " + inspectiontitle);
			switchVerification("checklist_wizard_inspectiontitle9_XPATH",
					"Test Questionnaire Property Title Smoke Capreit Nine",
					"The Test Questionnaire Property Title Smoke Capreit Nine is not displayed.");

			// wait for the element
			explicitWait("inspection_categoryname_risk_XPATH");

			// clear respective the comment box
			clear("inspection_commentbox1_risk_XPATH");

			// click on the SAP Vacancy Report category label
			click("inspection_categoryname_risk_XPATH");
			ngDriver.waitForAngularRequestsToFinish();
			System.out.println("Clicked on the SAP Vacancy Report category label.");

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

		// REMOVE THE AUTO GENERATED TASKS IN THE TASK MODULE

		System.out.println(
				"******************** REMOVE THE AUTO GENERATED TASKS IN THE TASK MODULE ********************");
		test.log(LogStatus.INFO,
				"******************** REMOVE THE AUTO GENERATED TASKS IN THE TASK MODULE ********************");
		Reporter.log("******************** REMOVE THE AUTO GENERATED TASKS IN THE TASK MODULE ********************");
		log.info("******************** REMOVE THE AUTO GENERATED TASKS IN THE TASK MODULE ********************");

		try {
			// enter the property name in the search field
			type("envreports_propertylist_filtertxt_CSS", data.get("property_1"));
			ngDriver.waitForAngularRequestsToFinish();
			System.out.println("Entered the property name in the search field.");

			// click on the task icon from the property list page
			click("taskicon_CSS");
			System.out.println("Clicked on the task icon of the Property.");
			ngDriver.waitForAngularRequestsToFinish();
			System.out.println("Navigate to the task screen of the perticular property.");

			// wait for the clear button
			explicitWaitClickable("task_clearbtn_XPATH");

			// click on the clear button
			click("task_clearbtn_XPATH");
			ngDriver.waitForAngularRequestsToFinish();
			System.out.println("Clicked on the clear button.");

			// enter auto generated task in the search field
			type("survey_task_searchfield_CSS", data.get("autotask_1"));
			ngDriver.waitForAngularRequestsToFinish();
			System.out.println("enter auto generated task in the search field.");

			// click on the search button
			click("survey_task_searchfield_CSS");
			ngDriver.waitForAngularRequestsToFinish();
			System.out.println("Clicked on the search button.");

			// verify the auto generated task 1
			deleteVerification("inspection_autotask1_risk_XPATH", "Electrical (Light Fixture)");

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

		// DELETE THE NEWLY CREATED INSPECTION

		System.out.println("***************** DELETE THE NEWLY CREATED INSPECTION *****************");
		test.log(LogStatus.INFO, "***************** DELETE THE NEWLY CREATED INSPECTION *****************");
		Reporter.log("***************** DELETE THE NEWLY CREATED INSPECTION *****************");
		log.info("***************** DELETE THE NEWLY CREATED INSPECTION *****************");

		try {

			// enter the property name in the search field
			type("envreports_propertylist_filtertxt_CSS", data.get("property_1"));
			ngDriver.waitForAngularRequestsToFinish();
			System.out.println("Entered the property name in the search field.");

			// click on the environmental icon from the property list page
			click("environmentalicon_CSS");
			System.out.println("Clicked on the environmental icon of the Property.");
			ngDriver.waitForAngularRequestsToFinish();
			System.out.println("Navigate to the environmental screen of the perticular property.");

			// wait for the element
			Thread.sleep(5000);

			// click on the burger menu
			click("menubtn_CSS");
			System.out.println("Clicked on the burger menu button successfully!!!");
			ngDriver.waitForAngularRequestsToFinish();

			// wait for the element
			Thread.sleep(5000);

			// click on the checklist/inspection option from side menu
			click("checklist_sidemenu_XPATH");
			System.out.println("Clicked on the checklist/inspection option from side menu");
			ngDriver.waitForAngularRequestsToFinish();
			System.out.println("Navigate to the checklist/inspection screen");

			// wait for 3 seconds
			Thread.sleep(3000);

			// click on the action icon of the new created checklist
			click("inspection_newlycreated_clientissue_actionicon_XPATH");
			ngDriver.waitForAngularRequestsToFinish();
			System.out.println("Clicked on the action icon of the new created checklist.");

			// wait for the element
			explicitWaitClickable("inspection_newlycreated_clientissue_actionicon_deleteoption_XPATH");

			// click on the delete option
			click("inspection_newlycreated_clientissue_actionicon_deleteoption_XPATH");
			ngDriver.waitForAngularRequestsToFinish();
			System.out.println("Clicked on the delete option.");

			// wait for the element
			explicitWaitClickable("checklist_deletebtn_XPATH");

			// click on the delete button
			click("checklist_deletebtn_XPATH");
			ngDriver.waitForAngularRequestsToFinish();
			System.out.println("Clicked on the delete button.");

			// verify deleted inspection is displayed or not
			deleteVerification("inspection_newlycreated_clientissue_XPATH",
					"Test Questionnaire Property Title Smoke Capreit Nine");

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

		try {
			// wait for the 5 seconds
			Thread.sleep(5000);

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
