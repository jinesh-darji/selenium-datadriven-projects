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

		execution(data, "rR5753ClientIssue4Test");

		// refresh the page
		driver.navigate().refresh();
		Thread.sleep(5000);
		driver.navigate().refresh();

		// MY TASKS DASHBOARD - NAVIGATION ISSUE - RR-4394
		title("MY TASKS DASHBOARD - NAVIGATION ISSUE - RR-4394");

		// LOGIN WITH ADMIN USER
		title("LOGIN WITH ADMIN USER");

		try {
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

		} catch (Throwable t) {
			verificationFailed();
		}

		// ADD ENVIRONMENTAL REPORT AT PROPERTY LEVEL
		title("ADD ENVIRONMENTAL REPORT AT PROPERTY LEVEL");

		try {

			// enter the property name in the search field

			type("envreports_propertylist_filtertxt_CSS", data.get("property_2"));

			// click on the environmental icon from the property list page
			click("environmentalicon_CSS");

			// wait for the element
			Thread.sleep(5000);

			// click on the burger menu
			click("menubtn_CSS");

			// wait for the element
			Thread.sleep(5000);

			// click on the environmental reports
			click("questionnaire_option_environmentalreports_XPATH");

			// select the building from the drop down
			select("propertyinfo_propertydd_XPATH", data.get("property"));

			// click on the Add report button
			click("envreportaddbtn_CSS");

			// select the checklist from the type dropdown
			select("envreporttypedd_CSS", data.get("type"));

			// enter the title

			type("envreporttitletxt_CSS", data.get("title"));

			// enter the company

			type("envreportcompanytxt_CSS", data.get("company"));

			// enter the author

			type("envreportauthortxt_CSS", data.get("author"));

			// scroll down the screen

			scrollByPixel(400);

			// enter the description

			type("envreportdescriptiontxt_CSS", data.get("description"));

			// click on the Add report button
			click("envreportsavebtn_CSS");

			// wait for the element
			explicitWaitClickable("closetoastmsg_CSS");

			// click on the toaster close button
			click("closetoastmsg_CSS");

			// enter the newly created environmental report in the search field

			type("task_listofchecklist_filterfield_CSS", data.get("title"));

			try {

				String propertyLevel1_XPATH = "//td[@id='68003']//following-sibling::td//span[text()='"
						+ data.get("title") + "']";

				boolean propertyLevel = driver.findElement(By.xpath(propertyLevel1_XPATH)).isDisplayed();

				if (propertyLevel == true) {
					successMessage("THE NEW ENVIRONMENTAL REPORT IS CREATED AT PROPERTY LEVEL SUCCESSFULLY");
				} else {

					verificationFailedMessage("THE NEW ENVIRONMENTAL REPORT IS NOT CREATED AT PROPERTY LEVEL.");
				}
			} catch (Throwable t) {
				verificationFailedMessage("THE NEW ENVIRONMENTAL REPORT IS NOT CREATED AT PROPERTY LEVEL.");
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

		// ADD TASK IN THE NEWLY CREATED ENVIRONMENTAL REPORT
		title("ADD TASK IN THE NEWLY CREATED ENVIRONMENTAL REPORT");

		try {
			// enter the property name in the search field

			type("envreports_propertylist_filtertxt_CSS", data.get("property_2"));

			// click on the environmental icon from the property list page
			click("environmentalicon_CSS");

			// wait for the element
			Thread.sleep(5000);

			// click on the burger menu
			click("menubtn_CSS");

			// wait for the element
			Thread.sleep(5000);

			// click on the environmental reports
			click("questionnaire_option_environmentalreports_XPATH");

			// select the building from the drop down
			select("propertyinfo_propertydd_XPATH", data.get("property"));

			// click on the newly created environmental report
			String propertyLevel2_XPATH = "//td[@id='68003']//following-sibling::td//span[text()='" + data.get("title")
					+ "']";
			driver.findElement(By.xpath(propertyLevel2_XPATH)).click();

			// click on the task tab
			click("envreportaddedrecord_tasktab_XPATH");

			// click on the new task button
			click("envreportaddedrecord_tasktab_newtaskbtn_XPATH");

			// enter title in the field
			type("riskmanagement_insuranceclaim_task_titletxt_XPATH", data.get("task_title"));

			// click on the save button
			click("environmental_task_submitbtn_XPATH");

			// scroll up the screen
			scrollTillElement("envreportaddedrecord_tasktab_XPATH");

			// verify newly created task
			switchVerification("environmental_task_createdtask_ci4_XPATH", "Test Task Title CI4",
					"The Test Task Title CI4 task is not displayed.");

		} catch (Throwable t) {
			verificationFailed();
		}

		// click on the home icon from the top of the screen
		click("questionnaire_homeburgermenubtn_hide_CSS");

		// synchronization
		explicitWait("propertylist_title_XPATH");

		// verify the property list
		switchVerification("propertylist_title_XPATH", "Property List", "The property list is not displayed.");

		// UPDATE NEWLY CREATED TASK OF THE ENVIRONMENTAL REPORT IN THE MY TASK
		// DASHBOARD AND VERIFY NAVIGATION OF IT
		title("UPDATE NEWLY CREATED TASK OF THE ENVIRONMENTAL REPORT IN THE MY TASK DASHBOARD AND VERIFY NAVIGATION OF IT");

		try {
			// wait for the element
			Thread.sleep(3000);

			// select the my task option from the dropdown
			select("ssc_environmental_dashboarddd_CSS", data.get("my_task_dashboard"));

			// wait for the element
			Thread.sleep(5000);

			// click on the clear button
			click("mytaskdashboard_clearbtn_XPATH");

			// type the newly created task in the search field
			type("ssc_task_mytaskoption_filter_CSS", data.get("task_title"));

			// click on the search button
			click("mytaskdashboard_searchbtn_XPATH");

			// click on the searched task
			click("mytaskdashboard_searchedrecord_ci4_XPATH");

			// wait for the element
			Thread.sleep(10000);

			// update title in the field

			type("riskmanagement_insuranceclaim_task_titletxt_XPATH", data.get("task_title_update"));

			// click on the update button
			click("mytaskdashboard_task_updatebtn_ci4_XPATH");

			// scroll up till top

			scrollTop();

			// verify title of the my task screen
			switchVerification("mytaskdashboard_mytasktitle_XPATH", "My Tasks", "The My Tasks title is not displayed.");

		} catch (Throwable t) {
			verificationFailed();
		}

		// click on the home icon from the top of the screen
		click("questionnaire_homeburgermenubtn_hide_CSS");

		// synchronization
		explicitWait("propertylist_title_XPATH");

		// verify the property list
		switchVerification("propertylist_title_XPATH", "Property List", "The property list is not displayed.");

		// NAVIGATE TO THE MY TASK DASHBOARD SCREEN FROM THE TASK DETAILS SCREEN BY
		// CLICKING ON THE BACK BUTTON
		title("NAVIGATE TO THE MY TASK DASHBOARD SCREEN FROM THE TASK DETAILS SCREEN BY CLICKING ON THE BACK BUTTON");

		try {
			// wait for the element
			Thread.sleep(3000);

			// select the my task option from the dropdown
			select("ssc_environmental_dashboarddd_CSS", data.get("my_task_dashboard"));

			// wait for the element
			Thread.sleep(5000);

			// click on the clear button
			click("mytaskdashboard_clearbtn_XPATH");

			// type the newly created task in the search field
			type("ssc_task_mytaskoption_filter_CSS", data.get("task_title_update"));

			// click on the search button
			click("mytaskdashboard_searchbtn_XPATH");

			// click on the searched task
			click("mytaskdashboard_searchedupdatedrecord_ci4_XPATH");

			// wait for the element
			Thread.sleep(10000);

			// click on the back button
			click("mytaskdashboard_task_backbtn_ci4_XPATH");

			// scroll up till top

			scrollTop();

			// verify title of the my task screen
			switchVerification("mytaskdashboard_mytasktitle_XPATH", "My Tasks", "The My Tasks title is not displayed.");

		} catch (Throwable t) {
			verificationFailed();
		}

		// click on the home icon from the top of the screen
		click("questionnaire_homeburgermenubtn_hide_CSS");

		// synchronization
		explicitWait("propertylist_title_XPATH");

		// verify the property list
		switchVerification("propertylist_title_XPATH", "Property List", "The property list is not displayed.");

		// DELETE THE NEWLY CREATED ENVIRONEMTAL REPORT
		title("DELETE THE NEWLY CREATED ENVIRONEMTAL REPORT");

		try {
			// enter the property name in the search field

			type("envreports_propertylist_filtertxt_CSS", data.get("property_2"));

			// click on the environmental icon from the property list page
			click("environmentalicon_CSS");

			// wait for the element
			Thread.sleep(5000);

			// click on the burger menu
			click("menubtn_CSS");

			// wait for the element
			Thread.sleep(5000);

			// click on the environmental reports
			click("questionnaire_option_environmentalreports_XPATH");

			// select the building from the drop down
			select("propertyinfo_propertydd_XPATH", data.get("property"));

			// click on the newly created environmental report
			String propertyLevel2_XPATH = "//td[@id='68003']//following-sibling::td//span[text()='" + data.get("title")
					+ "']";
			driver.findElement(By.xpath(propertyLevel2_XPATH)).click();

			// wait for the element
			explicitWaitClickable("envreportdeletebtn_CSS");

			// click on the delete button
			click("envreportdeletebtn_CSS");

			// wait for the element
			explicitWaitClickable("envreportmodeldeletebtn_CSS");

			// click on the delete button of the confirmation model
			click("envreportmodeldeletebtn_CSS");

			// wait for the element
			explicitWaitClickable("closetoastmsg_CSS");

			// click on the toaster close button
			click("closetoastmsg_CSS");

			// verification of the environmental report is deleted or not

			// enter the newly created environmental report in the search field

			type("task_listofchecklist_filterfield_CSS", data.get("title"));

			try {

				String propertyLevel1_XPATH = "//td[@id='68003']//following-sibling::td//span[text()='"
						+ data.get("title") + "']";

				boolean propertyLevel = driver.findElement(By.xpath(propertyLevel1_XPATH)).isDisplayed();

				if (propertyLevel == true) {

					verificationFailedMessage(
							"THE NEW ENVIRONMENTAL REPORT IS DISPLAYED, WHICH WAS CREATED AT PROPERTY LEVEL.");
				} else {
					successMessage(
							"THE NEW ENVIRONMENTAL REPORT IS NOT DISPLAYED AS EXPECTATION, WHICH WAS CREATED AT PROPERTY LEVEL.");
				}
			} catch (Throwable t) {
				successMessage(
						"THE NEW ENVIRONMENTAL REPORT IS NOT DISPLAYED AS EXPECTATION, WHICH WAS CREATED AT PROPERTY LEVEL.");
			}

		} catch (Throwable t) {
			verificationFailed();
		}

		// click on the home icon from the top of the screen
		click("questionnaire_homeburgermenubtn_hide_CSS");

		// wait for the element
		explicitWait("propertylist_title_XPATH");

		// verify the property list
		switchVerification("propertylist_title_XPATH", "Property List", "The property list is not displayed.");

		// DELETE THE NEWLY CREATED TASK
		title("DELETE THE NEWLY CREATED TASK");

		try {
			// enter the property name in the search field

			type("envreports_propertylist_filtertxt_CSS", data.get("property_2"));

			// click on the task icon from the property list page
			click("taskicon_CSS");

			// click on the clear button
			click("task_clearbtn_XPATH");

			// enter the task title in the search field
			type("survey_task_searchfield_CSS", data.get("task_title_update"));

			// click on the search button
			click("task_searchbtn_XPATH");

			// click on the action icon of the task
			String actionIcon = "//p[text()='" + data.get("task_title_update")
					+ "']//parent::td[@ng-click='editTaskFromLandingPage(task)']//following-sibling::td[@class='text-center pointer']//div[@class='dropdown']";
			driver.findElement(By.xpath(actionIcon)).click();

			// click on the delete option
			String deleteButton = "//p[text()='" + data.get("task_title_update")
					+ "']//parent::td[@ng-click='editTaskFromLandingPage(task)']//following-sibling::td[@class='text-center pointer']//div[@class='dropdown open']//li[@ng-click='deleteSelectedTask(task.id, false);']";
			driver.findElement(By.xpath(deleteButton)).click();

			// wait for the element
			explicitWaitClickable("closetoastmsg_CSS");

			// click on the toaster close button
			click("closetoastmsg_CSS");

			// click on the clear button
			click("task_clearbtn_XPATH");

			// enter the task title in the search field
			type("survey_task_searchfield_CSS", data.get("task_title_update"));

			// click on the search button
			click("task_searchbtn_XPATH");

			try {

				String actionIcon1_XPATH = "//p[text()='" + data.get("task_title_update") + "']";

				boolean actionIcon1 = driver.findElement(By.xpath(actionIcon1_XPATH)).isDisplayed();

				if (actionIcon1 == true) {

					verificationFailedMessage("THE DELETED TASK IS DISPLAYED.");
				} else {
					successMessage("THE DELETED TASK IS NOT DISPLAYED, AS EXPECTED.");
				}
			} catch (Throwable t) {
				successMessage("THE DELETED TASK IS NOT DISPLAYED, AS EXPECTED.");
			}

		} catch (Throwable t) {
			verificationFailed();
		}

		// click on the home icon from the top of the screen
		click("questionnaire_homeburgermenubtn_hide_CSS");

		// wait for the element
		explicitWait("propertylist_title_XPATH");

		// verify the property list
		switchVerification("propertylist_title_XPATH", "Property List", "The property list is not displayed.");

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