package testcases.smokesuite;

import java.io.IOException;
import java.util.Hashtable;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.testng.Reporter;
import org.testng.SkipException;
import org.testng.annotations.Test;

import com.relevantcodes.extentreports.LogStatus;

import base.TestBase;
import utilities.TestUtil;

public class RR5753ClientIssue4Test extends TestBase {

	@Test(dataProviderClass = TestUtil.class, dataProvider = "dp")
	public void rR5753ClientIssue4Test(Hashtable<String, String> data) throws IOException, InterruptedException {

		if (!(TestUtil.isTestRunnable("rR5753ClientIssue4Test", excel))) {

			throw new SkipException(
					"Skipping the test " + "rR5753ClientIssue4Test".toUpperCase() + "as the Run mode is NO");
		}

		if (!data.get("runmode").equals("Y")) {

			throw new SkipException("Skipping the test case as the Run Mode for data set is NO");
		}

		// refresh the page
		driver.navigate().refresh();
		Thread.sleep(5000);
		driver.navigate().refresh();

		// MY TASKS DASHBOARD - NAVIGATION ISSUE - RR-4394

		System.out.println("******************** MY TASKS DASHBOARD - NAVIGATION ISSUE - RR-4394 ********************");
		test.log(LogStatus.INFO,
				"******************** MY TASKS DASHBOARD - NAVIGATION ISSUE - RR-4394 ********************");
		Reporter.log("******************** MY TASKS DASHBOARD - NAVIGATION ISSUE - RR-4394 ********************");
		log.info("******************** MY TASKS DASHBOARD - NAVIGATION ISSUE - RR-4394 ********************");

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

		// ADD ENVIRONMENTAL REPORT AT PROPERTY LEVEL

		System.out.println("******************** ADD ENVIRONMENTAL REPORT AT PROPERTY LEVEL ********************");
		test.log(LogStatus.INFO,
				"******************** ADD ENVIRONMENTAL REPORT AT PROPERTY LEVEL ********************");
		Reporter.log("******************** ADD ENVIRONMENTAL REPORT AT PROPERTY LEVEL ********************");
		log.info("******************** ADD ENVIRONMENTAL REPORT AT PROPERTY LEVEL ********************");

		try {

			// enter the property name in the search field
			clear("envreports_propertylist_filtertxt_CSS");
			type("envreports_propertylist_filtertxt_CSS", data.get("property_2"));
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
			ngDriver.waitForAngularRequestsToFinish();
			System.out.println("Clicked on the burger menu button successfully!!!");

			// wait for the element
			Thread.sleep(5000);

			// click on the environmental reports
			click("questionnaire_option_environmentalreports_XPATH");
			ngDriver.waitForAngularRequestsToFinish();
			System.out.println("Clicked on the Environmental Reports option.");

			// select the building from the drop down
			select("propertyinfo_propertydd_XPATH", data.get("property"));
			ngDriver.waitForAngularRequestsToFinish();
			System.out.println("Selected the building from the drop down.");

			// click on the Add report button
			click("envreportaddbtn_CSS");
			System.out.println("Clicked on the Add report button");
			ngDriver.waitForAngularRequestsToFinish();
			System.out.println("Navigate to the Add Environmental Report Screen.");

			// select the checklist from the type dropdown
			select("envreporttypedd_CSS", data.get("type"));
			System.out.println("The option is selected from the Type dropdown.");
			ngDriver.waitForAngularRequestsToFinish();

			// enter the title
			clear("envreporttitletxt_CSS");
			type("envreporttitletxt_CSS", data.get("title"));
			ngDriver.waitForAngularRequestsToFinish();
			System.out.println("The data entered in the Title field.");

			// enter the company
			clear("envreportcompanytxt_CSS");
			type("envreportcompanytxt_CSS", data.get("company"));
			ngDriver.waitForAngularRequestsToFinish();
			System.out.println("The data entered in the Company field.");

			// enter the author
			clear("envreportauthortxt_CSS");
			type("envreportauthortxt_CSS", data.get("author"));
			ngDriver.waitForAngularRequestsToFinish();
			System.out.println("The data entered in the Author field.");

			// scroll down the screen
			JavascriptExecutor js = (JavascriptExecutor) driver;
			js.executeScript("window.scrollBy(0,400)");

			// enter the description
			clear("envreportdescriptiontxt_CSS");
			type("envreportdescriptiontxt_CSS", data.get("description"));
			ngDriver.waitForAngularRequestsToFinish();
			System.out.println("The data entered in the Description field.");

			// click on the Add report button
			click("envreportsavebtn_CSS");
			ngDriver.waitForAngularRequestsToFinish();
			System.out.println("Clicked on the Save Button.");

			// wait for the element
			explicitWaitClickable("closetoastmsg_CSS");

			// click on the toaster close button
			click("closetoastmsg_CSS");
			ngDriver.waitForAngularRequestsToFinish();
			System.out.println("Clicked on the toaster close button.");

			// enter the newly created environmental report in the search field
			clear("task_listofchecklist_filterfield_CSS");
			type("task_listofchecklist_filterfield_CSS", data.get("title"));
			ngDriver.waitForAngularRequestsToFinish();
			System.out.println("Entered the newly created environmental report in the search field.");

			try {

				String propertyLevel1_XPATH = "//td[@id='68003']//following-sibling::td//span[text()='"
						+ data.get("title") + "']";

				boolean propertyLevel = driver.findElement(By.xpath(propertyLevel1_XPATH)).isDisplayed();

				if (propertyLevel == true) {
					System.out.println("THE NEW ENVIRONMENTAL REPORT IS CREATED AT PROPERTY LEVEL SUCCESSFULLY.");
					test.log(LogStatus.INFO, "THE NEW ENVIRONMENTAL REPORT IS CREATED AT PROPERTY LEVEL SUCCESSFULLY");
					Reporter.log("THE NEW ENVIRONMENTAL REPORT IS CREATED AT PROPERTY LEVEL SUCCESSFULLY");
					log.info("THE NEW ENVIRONMENTAL REPORT IS CREATED AT PROPERTY LEVEL SUCCESSFULLY");
				} else {

					verificationFailed();

					System.out.println("THE NEW ENVIRONMENTAL REPORT IS NOT CREATED AT PROPERTY LEVEL.");
					test.log(LogStatus.INFO, "THE NEW ENVIRONMENTAL REPORT IS NOT CREATED AT PROPERTY LEVEL.");
					Reporter.log("THE NEW ENVIRONMENTAL REPORT IS NOT CREATED AT PROPERTY LEVEL.");
					log.info("THE NEW ENVIRONMENTAL REPORT IS NOT CREATED AT PROPERTY LEVEL.");
				}
			} catch (Throwable t) {
				verificationFailed();

				System.out.println("THE NEW ENVIRONMENTAL REPORT IS NOT CREATED AT PROPERTY LEVEL.");
				test.log(LogStatus.INFO, "THE NEW ENVIRONMENTAL REPORT IS NOT CREATED AT PROPERTY LEVEL.");
				Reporter.log("THE NEW ENVIRONMENTAL REPORT IS NOT CREATED AT PROPERTY LEVEL.");
				log.info("THE NEW ENVIRONMENTAL REPORT IS NOT CREATED AT PROPERTY LEVEL.");
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

		// ADD TASK IN THE NEWLY CREATED ENVIRONMENTAL REPORT

		System.out.println(
				"******************** ADD TASK IN THE NEWLY CREATED ENVIRONMENTAL REPORT ********************");
		test.log(LogStatus.INFO,
				"******************** ADD TASK IN THE NEWLY CREATED ENVIRONMENTAL REPORT ********************");
		Reporter.log("******************** ADD TASK IN THE NEWLY CREATED ENVIRONMENTAL REPORT ********************");
		log.info("******************** ADD TASK IN THE NEWLY CREATED ENVIRONMENTAL REPORT ********************");

		try {
			// enter the property name in the search field
			clear("envreports_propertylist_filtertxt_CSS");
			type("envreports_propertylist_filtertxt_CSS", data.get("property_2"));
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
			ngDriver.waitForAngularRequestsToFinish();
			System.out.println("Clicked on the burger menu button successfully!!!");

			// wait for the element
			Thread.sleep(5000);

			// click on the environmental reports
			click("questionnaire_option_environmentalreports_XPATH");
			ngDriver.waitForAngularRequestsToFinish();
			System.out.println("Clicked on the Environmental Reports option.");

			// select the building from the drop down
			select("propertyinfo_propertydd_XPATH", data.get("property"));
			ngDriver.waitForAngularRequestsToFinish();
			System.out.println("Selected the building from the drop down.");

			// click on the newly created environmental report
			String propertyLevel2_XPATH = "//td[@id='68003']//following-sibling::td//span[text()='" + data.get("title")
					+ "']";
			driver.findElement(By.xpath(propertyLevel2_XPATH)).click();
			ngDriver.waitForAngularRequestsToFinish();
			System.out.println("Clicked on the newly created environmental report.");

			// click on the task tab
			click("envreportaddedrecord_tasktab_XPATH");
			ngDriver.waitForAngularRequestsToFinish();
			System.out.println("Clicked on the task tab.");

			// click on the new task button
			click("envreportaddedrecord_tasktab_newtaskbtn_XPATH");
			ngDriver.waitForAngularRequestsToFinish();
			System.out.println("Clicked on the new task button.");

			// enter title in the field
			type("riskmanagement_insuranceclaim_task_titletxt_XPATH", data.get("task_title"));
			ngDriver.waitForAngularRequestsToFinish();
			System.out.println("Entered title in the field.");

			// click on the save button
			click("environmental_task_submitbtn_XPATH");
			ngDriver.waitForAngularRequestsToFinish();
			System.out.println("Clicked on the save button.");

			// scroll up the screen
			WebElement tasktab = driver.findElement(By.xpath(OR.getProperty("envreportaddedrecord_tasktab_XPATH")));
			JavascriptExecutor js = (JavascriptExecutor) driver;
			js.executeScript("arguments[0].scrollIntoView(true);", tasktab);

			// verify newly created task
			switchVerification("environmental_task_createdtask_ci4_XPATH", "Test Task Title CI4",
					"The Test Task Title CI4 task is not displayed.");

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

		// UPDATE NEWLY CREATED TASK OF THE ENVIRONMENTAL REPORT IN THE MY TASK
		// DASHBOARD AND VERIFY NAVIGATION OF IT

		System.out.println(
				"******************** UPDATE NEWLY CREATED TASK OF THE ENVIRONMENTAL REPORT IN THE MY TASK DASHBOARD AND VERIFY NAVIGATION OF IT ********************");
		test.log(LogStatus.INFO,
				"******************** UPDATE NEWLY CREATED TASK OF THE ENVIRONMENTAL REPORT IN THE MY TASK DASHBOARD AND VERIFY NAVIGATION OF IT ********************");
		Reporter.log(
				"******************** UPDATE NEWLY CREATED TASK OF THE ENVIRONMENTAL REPORT IN THE MY TASK DASHBOARD AND VERIFY NAVIGATION OF IT ********************");
		log.info(
				"******************** UPDATE NEWLY CREATED TASK OF THE ENVIRONMENTAL REPORT IN THE MY TASK DASHBOARD AND VERIFY NAVIGATION OF IT ********************");

		try {
			// wait for the element
			Thread.sleep(3000);

			// select the my task option from the dropdown
			select("ssc_environmental_dashboarddd_CSS", data.get("my_task_dashboard"));
			ngDriver.waitForAngularRequestsToFinish();
			System.out.println("Selected the my task option from the dropdown.");

			// wait for the element
			Thread.sleep(5000);

			// click on the clear button
			click("mytaskdashboard_clearbtn_XPATH");
			ngDriver.waitForAngularRequestsToFinish();
			System.out.println("Clicked on the clear button.");

			// type the newly created task in the search field
			type("ssc_task_mytaskoption_filter_CSS", data.get("task_title"));
			ngDriver.waitForAngularRequestsToFinish();
			System.out.println("Typed the newly created task in the search field.");

			// click on the search button
			click("mytaskdashboard_searchbtn_XPATH");
			ngDriver.waitForAngularRequestsToFinish();
			System.out.println("Clicked on the search button.");

			// click on the searched task
			click("mytaskdashboard_searchedrecord_ci4_XPATH");
			ngDriver.waitForAngularRequestsToFinish();
			System.out.println("Clicked on the searched task.");

			// wait for the element
			Thread.sleep(10000);

			// update title in the field
			clear("riskmanagement_insuranceclaim_task_titletxt_XPATH");
			type("riskmanagement_insuranceclaim_task_titletxt_XPATH", data.get("task_title_update"));
			ngDriver.waitForAngularRequestsToFinish();
			System.out.println("Updated title in the field.");

			// click on the update button
			click("mytaskdashboard_task_updatebtn_ci4_XPATH");
			ngDriver.waitForAngularRequestsToFinish();
			System.out.println("Clicked on the update button.");

			// scroll up till top
			JavascriptExecutor js = (JavascriptExecutor) driver;
			js.executeScript("window.scrollTo(0,0)");

			// verify title of the my task screen
			switchVerification("mytaskdashboard_mytasktitle_XPATH", "My Tasks", "The My Tasks title is not displayed.");

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

		// NAVIGATE TO THE MY TASK DASHBOARD SCREEN FROM THE TASK DETAILS SCREEN BY
		// CLICKING ON THE BACK BUTTON

		System.out.println(
				"******************** NAVIGATE TO THE MY TASK DASHBOARD SCREEN FROM THE TASK DETAILS SCREEN BY CLICKING ON THE BACK BUTTON ********************");
		test.log(LogStatus.INFO,
				"******************** NAVIGATE TO THE MY TASK DASHBOARD SCREEN FROM THE TASK DETAILS SCREEN BY CLICKING ON THE BACK BUTTON ********************");
		Reporter.log(
				"******************** NAVIGATE TO THE MY TASK DASHBOARD SCREEN FROM THE TASK DETAILS SCREEN BY CLICKING ON THE BACK BUTTON ********************");
		log.info(
				"******************** NAVIGATE TO THE MY TASK DASHBOARD SCREEN FROM THE TASK DETAILS SCREEN BY CLICKING ON THE BACK BUTTON ********************");

		try {
			// wait for the element
			Thread.sleep(3000);

			// select the my task option from the dropdown
			select("ssc_environmental_dashboarddd_CSS", data.get("my_task_dashboard"));
			ngDriver.waitForAngularRequestsToFinish();
			System.out.println("Selected the my task option from the dropdown.");

			// wait for the element
			Thread.sleep(5000);

			// click on the clear button
			click("mytaskdashboard_clearbtn_XPATH");
			ngDriver.waitForAngularRequestsToFinish();
			System.out.println("Clicked on the clear button.");

			// type the newly created task in the search field
			type("ssc_task_mytaskoption_filter_CSS", data.get("task_title_update"));
			ngDriver.waitForAngularRequestsToFinish();
			System.out.println("Typed the newly created task in the search field.");

			// click on the search button
			click("mytaskdashboard_searchbtn_XPATH");
			ngDriver.waitForAngularRequestsToFinish();
			System.out.println("Clicked on the search button.");

			// click on the searched task
			click("mytaskdashboard_searchedupdatedrecord_ci4_XPATH");
			ngDriver.waitForAngularRequestsToFinish();
			System.out.println("Clicked on the searched task.");

			// wait for the element
			Thread.sleep(10000);

			// click on the back button
			click("mytaskdashboard_task_backbtn_ci4_XPATH");
			ngDriver.waitForAngularRequestsToFinish();
			System.out.println("Clicked on the back button.");

			// scroll up till top
			JavascriptExecutor js = (JavascriptExecutor) driver;
			js.executeScript("window.scrollTo(0,0)");

			// verify title of the my task screen
			switchVerification("mytaskdashboard_mytasktitle_XPATH", "My Tasks", "The My Tasks title is not displayed.");

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

		// DELETE THE NEWLY CREATED ENVIRONEMTAL REPORT

		System.out.println("******************** DELETE THE NEWLY CREATED ENVIRONEMTAL REPORT ********************");
		test.log(LogStatus.INFO,
				"******************** DELETE THE NEWLY CREATED ENVIRONEMTAL REPORT ********************");
		Reporter.log("******************** DELETE THE NEWLY CREATED ENVIRONEMTAL REPORT ********************");
		log.info("******************** DELETE THE NEWLY CREATED ENVIRONEMTAL REPORT ********************");

		try {
			// enter the property name in the search field
			clear("envreports_propertylist_filtertxt_CSS");
			type("envreports_propertylist_filtertxt_CSS", data.get("property_2"));
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
			ngDriver.waitForAngularRequestsToFinish();
			System.out.println("Clicked on the burger menu button successfully!!!");

			// wait for the element
			Thread.sleep(5000);

			// click on the environmental reports
			click("questionnaire_option_environmentalreports_XPATH");
			ngDriver.waitForAngularRequestsToFinish();
			System.out.println("Clicked on the Environmental Reports option.");

			// select the building from the drop down
			select("propertyinfo_propertydd_XPATH", data.get("property"));
			ngDriver.waitForAngularRequestsToFinish();
			System.out.println("Selected the building from the drop down.");

			// click on the newly created environmental report
			String propertyLevel2_XPATH = "//td[@id='68003']//following-sibling::td//span[text()='" + data.get("title")
					+ "']";
			driver.findElement(By.xpath(propertyLevel2_XPATH)).click();
			ngDriver.waitForAngularRequestsToFinish();
			System.out.println("Clicked on the newly created environmental report.");

			// wait for the element
			explicitWaitClickable("envreportdeletebtn_CSS");

			// click on the delete button
			click("envreportdeletebtn_CSS");
			System.out.println("Clicked on the Delete Button.");
			ngDriver.waitForAngularRequestsToFinish();
			System.out.println("The confirmation pop up model is displayed.");

			// wait for the element
			explicitWaitClickable("envreportmodeldeletebtn_CSS");

			// click on the delete button of the confirmation model
			click("envreportmodeldeletebtn_CSS");
			System.out.println("Clicked on the Delete Button of the confirmation popup model.");
			ngDriver.waitForAngularRequestsToFinish();

			// wait for the element
			explicitWaitClickable("closetoastmsg_CSS");

			// click on the toaster close button
			click("closetoastmsg_CSS");
			ngDriver.waitForAngularRequestsToFinish();
			System.out.println("Clicked on the toaster close button.");

			// verification of the environmental report is deleted or not

			// enter the newly created environmental report in the search field
			clear("task_listofchecklist_filterfield_CSS");
			type("task_listofchecklist_filterfield_CSS", data.get("title"));
			System.out.println("Entered the newly updated environmental report in the search field.");
			ngDriver.waitForAngularRequestsToFinish();

			try {

				String propertyLevel1_XPATH = "//td[@id='68003']//following-sibling::td//span[text()='"
						+ data.get("title") + "']";

				boolean propertyLevel = driver.findElement(By.xpath(propertyLevel1_XPATH)).isDisplayed();

				if (propertyLevel == true) {

					verificationFailed();

					System.out
							.println("THE NEW ENVIRONMENTAL REPORT IS DISPLAYED, WHICH WAS CREATED AT PROPERTY LEVEL.");
					test.log(LogStatus.INFO,
							"THE NEW ENVIRONMENTAL REPORT IS DISPLAYED, WHICH WAS CREATED AT PROPERTY LEVEL.");
					Reporter.log("THE NEW ENVIRONMENTAL REPORT IS DISPLAYED, WHICH WAS CREATED AT PROPERTY LEVEL.");
					log.info("THE NEW ENVIRONMENTAL REPORT IS DISPLAYED, WHICH WAS CREATED AT PROPERTY LEVEL.");
				} else {

					System.out.println(
							"THE NEW ENVIRONMENTAL REPORT IS NOT DISPLAYED AS EXPECTATION, WHICH WAS CREATED AT PROPERTY LEVEL.");
					test.log(LogStatus.INFO,
							"THE NEW ENVIRONMENTAL REPORT IS NOT DISPLAYED AS EXPECTATION, WHICH WAS CREATED AT PROPERTY LEVEL.");
					Reporter.log(
							"THE NEW ENVIRONMENTAL REPORT IS NOT DISPLAYED AS EXPECTATION, WHICH WAS CREATED AT PROPERTY LEVEL.");
					log.info(
							"THE NEW ENVIRONMENTAL REPORT IS NOT DISPLAYED AS EXPECTATION, WHICH WAS CREATED AT PROPERTY LEVEL.");
				}
			} catch (Throwable t) {
				System.out.println(
						"THE NEW ENVIRONMENTAL REPORT IS NOT DISPLAYED AS EXPECTATION, WHICH WAS CREATED AT PROPERTY LEVEL.");
				test.log(LogStatus.INFO,
						"THE NEW ENVIRONMENTAL REPORT IS NOT DISPLAYED AS EXPECTATION, WHICH WAS CREATED AT PROPERTY LEVEL.");
				Reporter.log(
						"THE NEW ENVIRONMENTAL REPORT IS NOT DISPLAYED AS EXPECTATION, WHICH WAS CREATED AT PROPERTY LEVEL.");
				log.info(
						"THE NEW ENVIRONMENTAL REPORT IS NOT DISPLAYED AS EXPECTATION, WHICH WAS CREATED AT PROPERTY LEVEL.");
			}

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

		// DELETE THE NEWLY CREATED TASK

		System.out.println("******************** DELETE THE NEWLY CREATED TASK ********************");
		test.log(LogStatus.INFO, "******************** DELETE THE NEWLY CREATED TASK ********************");
		Reporter.log("******************** DELETE THE NEWLY CREATED TASK ********************");
		log.info("******************** DELETE THE NEWLY CREATED TASK ********************");

		try {
			// enter the property name in the search field
			clear("envreports_propertylist_filtertxt_CSS");
			type("envreports_propertylist_filtertxt_CSS", data.get("property_2"));
			ngDriver.waitForAngularRequestsToFinish();
			System.out.println("Entered the property name in the search field.");

			// click on the task icon from the property list page
			click("taskicon_CSS");
			ngDriver.waitForAngularRequestsToFinish();
			System.out.println("Clicked on the task icon of the Property.");

			// click on the clear button
			click("task_clearbtn_XPATH");
			ngDriver.waitForAngularRequestsToFinish();
			System.out.println("Clicked on the clear button.");

			// enter the task title in the search field
			type("survey_task_searchfield_CSS", data.get("task_title_update"));
			ngDriver.waitForAngularRequestsToFinish();
			System.out.println("Entered the task title in the search field.");

			// click on the search button
			click("task_searchbtn_XPATH");
			ngDriver.waitForAngularRequestsToFinish();
			System.out.println("Clicked on the search button.");

			// click on the action icon of the task
			String actionIcon = "//p[text()='" + data.get("task_title_update")
					+ "']//parent::td[@ng-click='editTaskFromLandingPage(task)']//following-sibling::td[@class='text-center pointer']//div[@class='dropdown']";
			driver.findElement(By.xpath(actionIcon)).click();
			ngDriver.waitForAngularRequestsToFinish();
			System.out.println("Clicked on the action icon of the task.");

			// click on the delete option
			String deleteButton = "//p[text()='" + data.get("task_title_update")
					+ "']//parent::td[@ng-click='editTaskFromLandingPage(task)']//following-sibling::td[@class='text-center pointer']//div[@class='dropdown open']//li[@ng-click='deleteSelectedTask(task.id, false);']";
			driver.findElement(By.xpath(deleteButton)).click();
			ngDriver.waitForAngularRequestsToFinish();
			System.out.println("Clicked on the delete button.");

			// wait for the element
			explicitWaitClickable("closetoastmsg_CSS");

			// click on the toaster close button
			click("closetoastmsg_CSS");
			ngDriver.waitForAngularRequestsToFinish();
			System.out.println("Clicked on the toaster close button.");

			// click on the clear button
			click("task_clearbtn_XPATH");
			ngDriver.waitForAngularRequestsToFinish();
			System.out.println("Clicked on the clear button.");

			// enter the task title in the search field
			type("survey_task_searchfield_CSS", data.get("task_title_update"));
			ngDriver.waitForAngularRequestsToFinish();
			System.out.println("Entered the task title in the search field.");

			// click on the search button
			click("task_searchbtn_XPATH");
			ngDriver.waitForAngularRequestsToFinish();
			System.out.println("Clicked on the search button.");

			try {

				String actionIcon1_XPATH = "//p[text()='" + data.get("task_title_update") + "']";

				boolean actionIcon1 = driver.findElement(By.xpath(actionIcon1_XPATH)).isDisplayed();

				if (actionIcon1 == true) {

					verificationFailed();

					System.out.println("THE DELETED TASK IS DISPLAYED.");
					test.log(LogStatus.INFO, "THE DELETED TASK IS DISPLAYED.");
					Reporter.log("THE DELETED TASK IS DISPLAYED.");
					log.info("THE DELETED TASK IS DISPLAYED.");
				} else {

					System.out.println("THE DELETED TASK IS NOT DISPLAYED, AS EXPECTED.");
					test.log(LogStatus.INFO, "THE DELETED TASK IS NOT DISPLAYED, AS EXPECTED.");
					Reporter.log("THE DELETED TASK IS NOT DISPLAYED, AS EXPECTED.");
					log.info("THE DELETED TASK IS NOT DISPLAYED, AS EXPECTED.");
				}
			} catch (Throwable t) {
				System.out.println("THE DELETED TASK IS NOT DISPLAYED, AS EXPECTED.");
				test.log(LogStatus.INFO, "THE DELETED TASK IS NOT DISPLAYED, AS EXPECTED.");
				Reporter.log("THE DELETED TASK IS NOT DISPLAYED, AS EXPECTED.");
				log.info("THE DELETED TASK IS NOT DISPLAYED, AS EXPECTED.");
			}

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
