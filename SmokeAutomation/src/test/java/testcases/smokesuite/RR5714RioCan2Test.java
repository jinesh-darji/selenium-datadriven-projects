package testcases.smokesuite;

import java.io.IOException;
import java.util.Hashtable;
import java.util.List;
import java.util.Random;

import org.apache.commons.lang3.RandomStringUtils;
import org.apache.commons.text.CharacterPredicates;
import org.apache.commons.text.RandomStringGenerator;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.SkipException;
import org.testng.annotations.Test;

import com.relevantcodes.extentreports.LogStatus;

import base.Helper;
import base.TestBase;
import utilities.TestUtil;

public class RR5714RioCan2Test extends TestBase {

	@Test(dataProviderClass = TestUtil.class, dataProvider = "dp")
	public void rR5714RioCan2Test(Hashtable<String, String> data) throws IOException, InterruptedException {

		execution(data, "rR5714RioCan2Test");

		// ONLY FIRST 5 TASKS SHOULD DISPLAY IN "ALERTS AND NOTIFICATIONS" SECTION
		title("ONLY FIRST 5 TASKS SHOULD DISPLAY IN \"ALERTS AND NOTIFICATIONS\" SECTION");

		String taskType = RandomStringUtils.randomAlphabetic(12);

		Random random = new Random();
		int taskCount = 5 + random.nextInt(8 - 5) + 5;

		// refresh the page
		driver.navigate().refresh();
		Thread.sleep(5000);
		driver.navigate().refresh();

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

		} catch (Throwable t) {
			verificationFailed();
		}

		// CREATE A NEW RECOMMENDATION TEMPLATE
		title("CREATE A NEW RECOMMENDATION TEMPLATE");

		try {
			// wait for the element
			Thread.sleep(5000);

			// click on the side menu
			click("ssc_leftsidemenubtn_CSS");

			// wait for the element
			Thread.sleep(5000);

			// click on the risk management
			click("sidemenu_riskmanagement_CSS");

			// select the Recommendations option from the Dashboard drop down
			select("dashboard_CSS", data.get("recommendations_dashboard"));

			// wait for the element
			Thread.sleep(3000);

			// scroll down till bottom of the screen

			scrollBottom();

			// click on the Recommendations Overview link
			click("riskmanagement_recommendationsdashboard_recommendationsoverviewlink_XPATH");

			// verify task type screen is displayed
			switchVerification("riskmanagement_recommendationsdashboard_tasktypetitle_XPATH", "Task Type",
					"The Task Type title is not displayed.");

			// click on the add recommendations button
			click("riskmanagement_recommendationsdashboard_createrecommendationsbtn_XPATH");

			// enter task title in the field

			type("riskmanagement_recommendationsdashboard_createrecommendations_tasktypetxt_XPATH", taskType);

			// scroll down till assign to label
			scrollTillElement("riskmanagement_recommendationsdashboard_createrecommendations_assignedtolbl_XPATH");

			// select the Not Applicable option from the recurring type drop down
			select("riskmanagement_recommendationsdashboard_createrecommendations_recurringtypedd_XPATH",
					data.get("recurrence_type_option"));

			// select the environmental option from the drop down
			select("riskmanagement_recommendationsdashboard_createrecommendations_moduledd_XPATH", data.get("module"));

			// click on the save button
			click("riskmanagement_recommendationsdashboard_createrecommendations_savebtn_XPATH");

			// wait for the element
			explicitWaitClickable("closetoastmsg_CSS");

			// click on the toaster close button
			click("closetoastmsg_CSS");

			// enter the newly created task type in the search field

			type("ssc_task_tasktemplateoption_filter_CSS", taskType);

			// verify newly created task type is displayed or not

			try {
				String createdTaskType_XPATH = "//td[contains(text(),'" + taskType + "')]";

				String str2 = (driver.findElement(By.xpath(createdTaskType_XPATH)).getText()).trim();

				if (str2.equals(taskType)) {
					successMessage("The " + taskType + " is verified successfully.");
				} else {
					verificationFailedMessage("The " + taskType + " is not displayed.");
				}

			} catch (Throwable t) {
				verificationFailed();
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

		// CREATE RANDOM NUMBER OF RECOMMENDATION TASKS WITH NEWLY CREATED
		// RECOMMENDATION TEMPLATE
		title("CREATE RANDOM NUMBER OF RECOMMENDATION TASKS WITH NEWLY CREATED RECOMMENDATION TEMPLATE");

		try {
			// enter the property name in the search field

			type("envreports_propertylist_filtertxt_CSS", data.get("property_2"));

			// click on the risk management icon from the property list page
			click("riskmanagementicon_CSS");

			// wait for the element
			Thread.sleep(5000);

			// click on the burger menu
			click("menubtn_CSS");

			// wait for the element
			Thread.sleep(5000);

			// click on the tasks option
			click("riskmanagement_taskoption_CSS");

			for (int i = 1; i <= taskCount; i++) {

				// click on the add button
				click("riskmanagement_addtaskbtn_CSS");

				// click on the recommendation field
				click("riskmanagement_addtaskbtn_recommendationtxt_XPATH");

				// click on the clear button
				click("riskmanagement_addtaskbtn_recommendationclearbtn_XPATH");

				// enter newly created recommendation in search field

				type("riskmanagement_addtaskbtn_roleassignsearchtxt_CSS", taskType);

				// click on the searched recommendation
				String searchedRecommendation = "//div[@ng-click='addOrRemoveToSelected(item); $hide()']//span[text()='"
						+ taskType + "']";
				driver.findElement(By.xpath(searchedRecommendation)).click();

				// select the option from the for who drop down
				select("riskmanagement_addtaskbtn_forwhodd_XPATH", data.get("for_who"));

				// scroll down the screen
				scrollTillElement("riskmanagement_addtaskbtn_statuslbl_XPATH");

				// wait for the element
				Thread.sleep(3000);

				// click on the due date field
				click("riskmanagement_addtaskbtn_duedatetxt_XPATH");

				// click on the today button
				click("riskmanagement_addtaskbtn_todaybtn_XPATH");

				// click on the save button
				click("riskmanagement_addtaskbtn_savebtn_CSS");

				// enter the newly created recommendation task in the search field

				type("riskmanagement_searchtxt_CSS", taskType);

				// verify newly created recommendation task is displayed or not

				try {
					String createdRecommendationTask_XPATH = "//td[text()='" + taskType + "']";

					String str2 = (driver.findElement(By.xpath(createdRecommendationTask_XPATH)).getText()).trim();

					if (str2.equals(taskType)) {
						successMessage("The " + taskType + " is verified successfully.");
					} else {
						verificationFailedMessage("The " + taskType + " is not displayed.");
					}

				} catch (Throwable t) {
					verificationFailed();

					break;
				}
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

		// VERIFY NEWLY CREATED TASK ON THE PROPERTY SUMMARY SCREEN OF THE RISK
		// MANAGERMENT
		title("VERIFY NEWLY CREATED TASK ON THE PROPERTY SUMMARY SCREEN OF THE RISK MANAGERMENT");

		try {

			// enter the property name in the search field

			type("envreports_propertylist_filtertxt_CSS", data.get("property_2"));

			// click on the risk management icon from the property list page
			click("riskmanagementicon_CSS");

			// verify the maximum 5 recommendation task are displayed in the alert and
			// notification section of the property summary screen of the risk management

			List<WebElement> recommendationTask = driver.findElements(
					By.xpath(OR.getProperty("riskmanagement_recommendationtasklist_propertysummary_XPATH")));
			int recommendationTaskCount = recommendationTask.size();

			if (recommendationTaskCount <= 5) {
				successMessage(
						"THE RECOMMENDATION TASKS ARE NOT DISPLAYED MORE THAN 5 IN THE ALERT AND NOTIFICATION SECTION OF THE PROPERTY SUMMARY SCREEN OF THE RISK MANAGEMENT.");
			} else {
				verificationFailedMessage(
						"THE MORE THAN 5 RECOMMENDATION TASKS ARE DISPLAYED IN THE ALERT AND NOTIFICATION SECTION OF THE PROPERTY SUMMARY SCREEN OF THE RISK MANAGEMENT.");
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

		// DELETE THE ALL NEWLY CREATED RECOMMENDATIONS TASK
		title("DELETE THE ALL NEWLY CREATED RECOMMENDATIONS TASK");

		try {
			// enter the property name in the search field

			type("envreports_propertylist_filtertxt_CSS", data.get("property_2"));

			// click on the risk management icon from the property list page
			click("riskmanagementicon_CSS");

			// wait for the element
			Thread.sleep(5000);

			// click on the burger menu
			click("menubtn_CSS");

			// wait for the element
			Thread.sleep(5000);

			// click on the tasks option
			click("riskmanagement_taskoption_CSS");

			List<WebElement> recommendationList = driver
					.findElements(By.xpath(OR.getProperty("riskmanagement_recommendationtasklist_XPATH")));
			int recommendationCount = recommendationList.size();

			consoleMessage("recommendation Task Count :::::::::::::" + recommendationCount);

			for (int j = 0; j < recommendationCount; j++) {

				List<WebElement> recommendationList1 = driver
						.findElements(By.xpath(OR.getProperty("riskmanagement_recommendationtasklist_XPATH")));
				int recommendationCount1 = recommendationList1.size();
				consoleMessage("recommendation Task Count :::::::::::::" + recommendationCount1);

				// click on the newly created recommendation task
				Random r = new Random();
				recommendationList1.get(r.nextInt(recommendationCount1)).click();

				// wait for the element
				Thread.sleep(5000);

				// click on the delete button
				click("riskmanagement_recommendationtask_deletebtn_XPATH");

				// wait for the element
				Thread.sleep(3000);

				// click on the delete button of the confirmation popup
				click("riskmanagement_recommendationtask_deletebtn_confirmation_XPATH");

				// wait for the element
				Thread.sleep(3000);

			}

			// enter the newly created recommendation task in the search field

			type("riskmanagement_searchtxt_CSS", taskType);

			// verify deleted recommendation task is displayed or not
			try {

				String createdRecommendationTask_XPATH = "//td[text()='" + taskType + "']";

				String deleteElement = (driver.findElement(By.xpath(createdRecommendationTask_XPATH)).getText()).trim();

				if (deleteElement.equals(taskType)) {
					verificationFailedMessage("The  " + taskType + " is not deleted : ");
				}
			} catch (Throwable t) {
				successMessage("The " + taskType + " is deleted successfully.");
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

		// DELETE THE NEWLY CREATED RECOMMENDATION TEMPLATE AFTER DELETE
		// RECOMMENDATION TASK
		title("DELETE THE NEWLY CREATED RECOMMENDATION TEMPLATE AFTER DELETE RECOMMENDATION TASK");

		try {
			// wait for the element
			Thread.sleep(5000);

			// click on the side menu
			click("ssc_leftsidemenubtn_CSS");

			// wait for the element
			Thread.sleep(5000);

			// click on the risk management
			click("sidemenu_riskmanagement_CSS");

			// wait for the element
			Thread.sleep(5000);

			// select the Recommendations option from the Dashboard drop down
			select("dashboard_CSS", data.get("recommendations_dashboard"));

			// wait for the element
			Thread.sleep(3000);

			// scroll down till bottom of the screen

			scrollBottom();

			// click on the Recommendations Overview link
			click("riskmanagement_recommendationsdashboard_recommendationsoverviewlink_XPATH");

			// verify task type screen is displayed
			switchVerification("riskmanagement_recommendationsdashboard_tasktypetitle_XPATH", "Task Type",
					"The Task Type title is not displayed.");

			// enter the newly created task type in the search field

			type("ssc_task_tasktemplateoption_filter_CSS", taskType);

			// click on the newly created recommendation template
			String searchedRecommendationTemplate = "//td[contains(text(),'" + taskType + "')]";
			driver.findElement(By.xpath(searchedRecommendationTemplate)).click();

			// wait for the element
			Thread.sleep(7000);

			// click on the delete button
			click("riskmanagement_deletebtn_XPATH");

			// wait for the element
			Thread.sleep(3000);

			// click on the delete button of confirmation popup
			click("riskmanagement_deletebtn_confirmation_XPATH");

			// enter the newly created task type in the search field

			type("ssc_task_tasktemplateoption_filter_CSS", taskType);

			// verify deleted recommendation template is displayed or not
			try {

				String createdRecommendationTemplate_XPATH = "//td[text()='" + taskType + "']";

				String deleteElement1 = (driver.findElement(By.xpath(createdRecommendationTemplate_XPATH)).getText())
						.trim();

				if (deleteElement1.equals(taskType)) {
					verificationFailedMessage("The  " + taskType + " is not deleted : ");
				}

			} catch (Throwable t) {
				successMessage("The " + taskType + " is deleted successfully.");
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