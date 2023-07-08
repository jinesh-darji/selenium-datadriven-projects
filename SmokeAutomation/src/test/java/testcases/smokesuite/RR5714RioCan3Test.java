package testcases.smokesuite;

import java.io.IOException;
import java.time.LocalDate;
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

public class RR5714RioCan3Test extends TestBase {

	@Test(dataProviderClass = TestUtil.class, dataProvider = "dp")
	public void rR5714RioCan3Test(Hashtable<String, String> data) throws IOException, InterruptedException {

		execution(data, "rR5714RioCan3Test");

		// VERIFY THE COUNT OF THE RECOMMENDATION SUMMARY DASHBOARD
		title("VERIFY THE COUNT OF THE RECOMMENDATION SUMMARY DASHBOARD");

		String taskType = RandomStringUtils.randomAlphabetic(12);

		Random random = new Random();
		int taskCount1 = 2 + random.nextInt(5 - 2) + 2;
		int taskCount2 = 2 + random.nextInt(5 - 2) + 2;
		int taskCount3 = 2 + random.nextInt(5 - 2) + 2;

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

			for (int j = 0; j < recommendationCount; j++) {

				List<WebElement> recommendationList1 = driver
						.findElements(By.xpath(OR.getProperty("riskmanagement_recommendationtasklist_XPATH")));
				int recommendationCount1 = recommendationList1.size();

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

		} catch (Throwable t) {
			verificationFailed();
		}

		// click on the home icon from the top of the screen
		click("questionnaire_homeburgermenubtn_hide_CSS");

		// synchronization
		explicitWait("propertylist_title_XPATH");

		// verify the property list
		switchVerification("propertylist_title_XPATH", "Property List", "The property list is not displayed.");

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
		// RECOMMENDATION TEMPLATE AND 3 DAYS PASTE
		title("CREATE RANDOM NUMBER OF RECOMMENDATION TASKS WITH NEWLY CREATED RECOMMENDATION TEMPLATE AND 3 DAYS PASTE");

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

			for (int i = 1; i <= taskCount1; i++) {

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

				// enter the 3 days past date in the due date
				LocalDate currentDate = LocalDate.now();
				LocalDate pastDate = currentDate.minusDays(3);
				String expectedPastDate = pastDate.toString();
				type("riskmanagement_addtaskbtn_duedatetxt_XPATH", expectedPastDate);

				// click on the save button
				click("riskmanagement_addtaskbtn_savebtn_CSS");

				// wait for the element
				Thread.sleep(5000);
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

		// VERIFY NEWLY CREATED TASK COUNT IS DISPLAYED IN THE LAST 30 DAYS DUE DATE
		// SECTION ON THE RECOMMENDATION SUMMARY DASHBOARD
		title("VERIFY NEWLY CREATED TASK COUNT IS DISPLAYED IN THE LAST 30 DAYS DUE DATE SECTION ON THE RECOMMENDATION SUMMARY DASHBOARD");

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

			try {
				// verify count of the overdue tasks
				String pastDate = (driver
						.findElement(By.xpath(OR.getProperty("ssc_riskmanagement_recommendations_record1_XPATH")))
						.getText()).trim();
				int pastDateInt = Integer.parseInt(pastDate);

				if (pastDateInt == taskCount1) {
					successMessage(
							"THE COUNT OF THE OVERDUE TASKS OF THE LAST 30 DAYS SECTION IS DISPLAYED CORRECTLY.");
				} else {

					verificationFailedMessage(
							"THE COUNT OF THE OVERDUE TASKS OF THE LAST 30 DAYS SECTION IS NOT DISPLAYED CORRECTLY.");
				}

			} catch (Throwable t) {
				verificationFailedMessage(
						"THE COUNT OF THE OVERDUE TASKS OF THE LAST 30 DAYS SECTION IS NOT DISPLAYED CORRECTLY.");
			}

			try {
				// verify count of the total tasks
				String pastDate = (driver
						.findElement(By.xpath(OR.getProperty("ssc_riskmanagement_recommendations_record2_XPATH")))
						.getText()).trim();
				int pastDateInt = Integer.parseInt(pastDate);

				if (pastDateInt == taskCount1) {
					successMessage("THE COUNT OF THE TOTAL TASKS OF THE LAST 30 DAYS SECTION IS DISPLAYED CORRECTLY.");
				} else {

					verificationFailedMessage(
							"THE COUNT OF THE TOTAL TASKS OF THE LAST 30 DAYS SECTION IS NOT DISPLAYED CORRECTLY.");
				}

			} catch (Throwable t) {
				verificationFailedMessage(
						"THE COUNT OF THE TOTAL TASKS OF THE LAST 30 DAYS SECTION IS NOT DISPLAYED CORRECTLY.");
			}

			// scroll up the screen
			scrollTop();

			// select the hours option from the drop down
			select("ssc_riskmanagement_recommendations_taskfrequency_XPATH", data.get("task_frequency"));

			// scroll down till bottom of the screen
			scrollBottom();

			try {
				// verify count of the overdue tasks
				String pastDate = (driver
						.findElement(By.xpath(OR.getProperty("ssc_riskmanagement_recommendations_record1_XPATH")))
						.getText()).trim();
				int pastDateInt = Integer.parseInt(pastDate);

				if (pastDateInt == 0) {
					successMessage(
							"THE COUNT OF THE OVERDUE TASKS OF THE LAST 30 DAYS SECTION IS DISPLAYED CORRECTLY.");
				} else {

					verificationFailedMessage(
							"THE COUNT OF THE OVERDUE TASKS OF THE LAST 30 DAYS SECTION IS NOT DISPLAYED CORRECTLY.");
				}

			} catch (Throwable t) {
				verificationFailedMessage(
						"THE COUNT OF THE OVERDUE TASKS OF THE LAST 30 DAYS SECTION IS NOT DISPLAYED CORRECTLY.");
			}

			try {
				// verify count of the total tasks
				String pastDate = (driver
						.findElement(By.xpath(OR.getProperty("ssc_riskmanagement_recommendations_record2_XPATH")))
						.getText()).trim();
				int pastDateInt = Integer.parseInt(pastDate);

				if (pastDateInt == 0) {
					successMessage("THE COUNT OF THE TOTAL TASKS OF THE LAST 30 DAYS SECTION IS DISPLAYED CORRECTLY.");
				} else {

					verificationFailedMessage(
							"THE COUNT OF THE TOTAL TASKS OF THE LAST 30 DAYS SECTION IS NOT DISPLAYED CORRECTLY.");
				}

			} catch (Throwable t) {
				verificationFailedMessage(
						"THE COUNT OF THE TOTAL TASKS OF THE LAST 30 DAYS SECTION IS NOT DISPLAYED CORRECTLY.");
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

		// DELETE THE ALL NEWLY CREATED RECOMMENDATIONS TASK - LESS THAN 30 PAST DAYS
		title("DELETE THE ALL NEWLY CREATED RECOMMENDATIONS TASK - LESS THAN 30 PAST DAYS");

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

			List<WebElement> recommendationList1 = driver
					.findElements(By.xpath(OR.getProperty("riskmanagement_recommendationtasklist_XPATH")));
			int recommendationCount1 = recommendationList1.size();

			consoleMessage("recommendation Task Count :::::::::::::" + recommendationCount1);

			for (int j = 0; j < recommendationCount1; j++) {

				List<WebElement> recommendationList11 = driver
						.findElements(By.xpath(OR.getProperty("riskmanagement_recommendationtasklist_XPATH")));
				int recommendationCount11 = recommendationList11.size();
				consoleMessage("recommendation Task Count :::::::::::::" + recommendationCount11);

				// click on the newly created recommendation task
				Random r = new Random();
				recommendationList11.get(r.nextInt(recommendationCount11)).click();

				// wait for the element
				explicitWaitClickable("riskmanagement_recommendationtask_deletebtn_XPATH");

				// click on the delete button
				click("riskmanagement_recommendationtask_deletebtn_XPATH");

				// wait for the element
				explicitWaitClickable("riskmanagement_recommendationtask_deletebtn_confirmation_XPATH");

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

		// CREATE RANDOM NUMBER OF RECOMMENDATION TASKS WITH NEWLY CREATED
		// RECOMMENDATION TEMPLATE AND 31 TO 90 DAYS PASTE
		title("CREATE RANDOM NUMBER OF RECOMMENDATION TASKS WITH NEWLY CREATED RECOMMENDATION TEMPLATE AND 31 TO 90 DAYS PASTE");

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

			for (int i = 1; i <= taskCount2; i++) {

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

				// enter the 2 months past date in the due date
				LocalDate currentDate = LocalDate.now();
				LocalDate morepastDate = currentDate.minusMonths(2);
				String expectedMorePastDate = morepastDate.toString();
				type("riskmanagement_addtaskbtn_duedatetxt_XPATH", expectedMorePastDate);

				// click on the save button
				click("riskmanagement_addtaskbtn_savebtn_CSS");

				// wait for the element
				Thread.sleep(5000);

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

		// VERIFY NEWLY CREATED TASK COUNT IS DISPLAYED IN THE BETWEEN 31 TO 90 DAYS DUE
		// DATE SECTION ON THE RECOMMENDATION SUMMARY DASHBOARD
		title("VERIFY NEWLY CREATED TASK COUNT IS DISPLAYED IN THE BETWEEN 31 TO 90 DAYS DUE DATE SECTION ON THE RECOMMENDATION SUMMARY DASHBOARD");

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

			try {
				// verify count of the overdue tasks
				String morePastDate = (driver
						.findElement(By.xpath(OR.getProperty("ssc_riskmanagement_recommendations_record3_XPATH")))
						.getText()).trim();
				int morePastDateInt = Integer.parseInt(morePastDate);

				if (morePastDateInt == taskCount2) {
					successMessage(
							"THE COUNT OF THE OVERDUE TASKS OF THE BETWEEN 31 TO 90 DAYS DAYS SECTION IS DISPLAYED CORRECTLY.");
				} else {

					verificationFailedMessage(
							"THE COUNT OF THE OVERDUE TASKS OF THE BETWEEN 31 TO 90 DAYS DAYS SECTION IS NOT DISPLAYED CORRECTLY.");
				}

			} catch (Throwable t) {
				verificationFailedMessage(
						"THE COUNT OF THE OVERDUE TASKS OF THE BETWEEN 31 TO 90 DAYS DAYS SECTION IS NOT DISPLAYED CORRECTLY.");
			}

			try {
				// verify count of the total tasks
				String morePastDate = (driver
						.findElement(By.xpath(OR.getProperty("ssc_riskmanagement_recommendations_record4_XPATH")))
						.getText()).trim();
				int morePastDateInt = Integer.parseInt(morePastDate);

				if (morePastDateInt == taskCount2) {
					successMessage(
							"THE COUNT OF THE TOTAL TASKS OF THE BETWEEN 31 TO 90 DAYS SECTION IS DISPLAYED CORRECTLY.");
				} else {

					verificationFailedMessage(
							"THE COUNT OF THE TOTAL TASKS OF THE BETWEEN 31 TO 90 DAYS SECTION IS NOT DISPLAYED CORRECTLY.");
				}

			} catch (Throwable t) {
				verificationFailedMessage(
						"THE COUNT OF THE TOTAL TASKS OF THE BETWEEN 31 TO 90 DAYS SECTION IS NOT DISPLAYED CORRECTLY.");
			}

			// scroll up the screen
			scrollTop();

			// select the hours option from the drop down
			select("ssc_riskmanagement_recommendations_taskfrequency_XPATH", data.get("task_frequency"));

			// scroll down till bottom of the screen
			scrollBottom();

			try {
				// verify count of the overdue tasks
				String morePastDate = (driver
						.findElement(By.xpath(OR.getProperty("ssc_riskmanagement_recommendations_record3_XPATH")))
						.getText()).trim();
				int morePastDateInt = Integer.parseInt(morePastDate);

				if (morePastDateInt == 0) {
					successMessage(
							"THE COUNT OF THE OVERDUE TASKS OF THE BETWEEN 31 TO 90 DAYS SECTION IS DISPLAYED CORRECTLY.");
				} else {

					verificationFailedMessage(
							"THE COUNT OF THE OVERDUE TASKS OF THE BETWEEN 31 TO 90 DAYS SECTION IS NOT DISPLAYED CORRECTLY.");
				}

			} catch (Throwable t) {
				verificationFailedMessage(
						"THE COUNT OF THE OVERDUE TASKS OF THE BETWEEN 31 TO 90 DAYS SECTION IS NOT DISPLAYED CORRECTLY.");
			}

			try {
				// verify count of the total tasks
				String morePastDate = (driver
						.findElement(By.xpath(OR.getProperty("ssc_riskmanagement_recommendations_record4_XPATH")))
						.getText()).trim();
				int morePastDateInt = Integer.parseInt(morePastDate);

				if (morePastDateInt == 0) {
					successMessage(
							"THE COUNT OF THE TOTAL TASKS OF THE BETWEEN 31 TO 90 DAYS SECTION IS DISPLAYED CORRECTLY.");
				} else {

					verificationFailedMessage(
							"THE COUNT OF THE TOTAL TASKS OF THE BETWEEN 31 TO 90 DAYS SECTION IS NOT DISPLAYED CORRECTLY.");
				}

			} catch (Throwable t) {
				verificationFailedMessage(
						"THE COUNT OF THE TOTAL TASKS OF THE BETWEEN 31 TO 90 DAYS SECTION IS NOT DISPLAYED CORRECTLY.");
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

		// DELETE THE ALL NEWLY CREATED RECOMMENDATIONS TASK - BETWEEN 31 TO 90 DAYS
		// PAST DATE
		title("DELETE THE ALL NEWLY CREATED RECOMMENDATIONS TASK - BETWEEN 31 TO 90 DAYS PAST DATE");

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

			List<WebElement> recommendationList2 = driver
					.findElements(By.xpath(OR.getProperty("riskmanagement_recommendationtasklist_XPATH")));
			int recommendationCount2 = recommendationList2.size();

			for (int j = 0; j < recommendationCount2; j++) {

				List<WebElement> recommendationList12 = driver
						.findElements(By.xpath(OR.getProperty("riskmanagement_recommendationtasklist_XPATH")));
				int recommendationCount12 = recommendationList12.size();

				// click on the newly created recommendation task
				Random r = new Random();
				recommendationList12.get(r.nextInt(recommendationCount12)).click();

				// wait for the element
				explicitWaitClickable("riskmanagement_recommendationtask_deletebtn_XPATH");

				// click on the delete button
				click("riskmanagement_recommendationtask_deletebtn_XPATH");

				// wait for the element
				explicitWaitClickable("riskmanagement_recommendationtask_deletebtn_confirmation_XPATH");

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

		// CREATE RANDOM NUMBER OF RECOMMENDATION TASKS WITH NEWLY CREATED
		// RECOMMENDATION TEMPLATE AND MORE THAN 90 DAYS PASTE
		title("CREATE RANDOM NUMBER OF RECOMMENDATION TASKS WITH NEWLY CREATED RECOMMENDATION TEMPLATE AND MORE THAN 90 DAYS PASTE");

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

			for (int i = 1; i <= taskCount3; i++) {

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

				// enter the 5 months past date in the due date
				LocalDate currentDate = LocalDate.now();
				LocalDate mostPastDate = currentDate.minusMonths(5);
				String expectedMostPastDate = mostPastDate.toString();
				type("riskmanagement_addtaskbtn_duedatetxt_XPATH", expectedMostPastDate);

				// click on the save button
				click("riskmanagement_addtaskbtn_savebtn_CSS");

				// wait for the element
				Thread.sleep(5000);

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

		// VERIFY NEWLY CREATED TASK COUNT IS DISPLAYED IN THE MORE THAN 90 DAYS DUE
		// DATE SECTION ON THE RECOMMENDATION SUMMARY DASHBOARD
		title("VERIFY NEWLY CREATED TASK COUNT IS DISPLAYED IN THE MORE THAN 90 DAYS DUE DATE SECTION ON THE RECOMMENDATION SUMMARY DASHBOARD");

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

			try {
				// verify count of the overdue tasks
				String mostPastDate = (driver
						.findElement(By.xpath(OR.getProperty("ssc_riskmanagement_recommendations_record5_XPATH")))
						.getText()).trim();
				int mostPastDateInt = Integer.parseInt(mostPastDate);

				if (mostPastDateInt == taskCount3) {
					successMessage(
							"THE COUNT OF THE OVERDUE TASKS OF THE MORE THAN 90 DAYS DAYS SECTION IS DISPLAYED CORRECTLY.");
				} else {

					verificationFailedMessage(
							"THE COUNT OF THE OVERDUE TASKS OF THE MORE THAN 90 DAYS DAYS SECTION IS NOT DISPLAYED CORRECTLY.");
				}

			} catch (Throwable t) {
				verificationFailedMessage(
						"THE COUNT OF THE OVERDUE TASKS OF THE MORE THAN 90 DAYS DAYS SECTION IS NOT DISPLAYED CORRECTLY.");
			}

			// scroll up the screen
			scrollTop();

			// select the hours option from the drop down
			select("ssc_riskmanagement_recommendations_taskfrequency_XPATH", data.get("task_frequency"));

			// scroll down till bottom of the screen
			scrollBottom();

			try {
				// verify count of the overdue tasks
				String mostPastDate = (driver
						.findElement(By.xpath(OR.getProperty("ssc_riskmanagement_recommendations_record5_XPATH")))
						.getText()).trim();
				int mostPastDateInt = Integer.parseInt(mostPastDate);

				if (mostPastDateInt == 0) {
					successMessage(
							"THE COUNT OF THE OVERDUE TASKS OF THE MORE THAN 90 DAYS SECTION IS DISPLAYED CORRECTLY.");
				} else {

					verificationFailedMessage(
							"THE COUNT OF THE OVERDUE TASKS OF THE MORE THAN 90 DAYS SECTION IS NOT DISPLAYED CORRECTLY.");
				}

			} catch (Throwable t) {
				verificationFailedMessage(
						"THE COUNT OF THE OVERDUE TASKS OF THE MORE THAN 90 DAYS SECTION IS NOT DISPLAYED CORRECTLY.");
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

		// DELETE THE ALL NEWLY CREATED RECOMMENDATIONS TASK - MORE THAN 90 PAST DAYS
		title("DELETE THE ALL NEWLY CREATED RECOMMENDATIONS TASK - MORE THAN 90 PAST DAYS");

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

			List<WebElement> recommendationList3 = driver
					.findElements(By.xpath(OR.getProperty("riskmanagement_recommendationtasklist_XPATH")));
			int recommendationCount3 = recommendationList3.size();

			consoleMessage("recommendation Task Count :::::::::::::" + recommendationCount3);

			for (int j = 0; j < recommendationCount3; j++) {

				List<WebElement> recommendationList13 = driver
						.findElements(By.xpath(OR.getProperty("riskmanagement_recommendationtasklist_XPATH")));
				int recommendationCount13 = recommendationList13.size();
				consoleMessage("recommendation Task Count :::::::::::::" + recommendationCount13);

				// click on the newly created recommendation task
				Random r = new Random();
				recommendationList13.get(r.nextInt(recommendationCount13)).click();

				// wait for the element
				explicitWaitClickable("riskmanagement_recommendationtask_deletebtn_XPATH");

				// click on the delete button
				click("riskmanagement_recommendationtask_deletebtn_XPATH");

				// wait for the element
				explicitWaitClickable("riskmanagement_recommendationtask_deletebtn_confirmation_XPATH");

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

//		// DELETE THE NEWLY CREATED RECOMMENDATION TEMPLATE AFTER DELETE
//		// RECOMMENDATION TASK
//		title("DELETE THE NEWLY CREATED RECOMMENDATION TEMPLATE AFTER DELETE RECOMMENDATION TASK");
//
//		try {
//			// wait for the element
//					Thread.sleep(5000);
//
//			// click on the side menu
//			click("ssc_leftsidemenubtn_CSS");
//
//			// wait for the element
//					Thread.sleep(5000);
//
//			// click on the risk management
//			click("sidemenu_riskmanagement_CSS");
//
//			// select the Recommendations option from the Dashboard drop down
//			select("dashboard_CSS", data.get("recommendations_dashboard"));
//
//			// wait for the element
//			Thread.sleep(3000);
//
//			// scroll down till bottom of the screen
//			 
//			scrollBottom();
//
//			// click on the Recommendations Overview link
//			click("riskmanagement_recommendationsdashboard_recommendationsoverviewlink_XPATH");
//
//			// verify task type screen is displayed
//			switchVerification("riskmanagement_recommendationsdashboard_tasktypetitle_XPATH", "Task Type",
//					"The Task Type title is not displayed.");
//
//			// enter the newly created task type in the search field
//			 
//			type("ssc_task_tasktemplateoption_filter_CSS", taskType);
//
//			// click on the newly created recommendation template
//			String searchedRecommendationTemplate = "//td[contains(text(),'" + taskType + "')]";
//			driver.findElement(By.xpath(searchedRecommendationTemplate)).click();
//
//			// wait for the element
//			Thread.sleep(7000);
//
//			// click on the delete button
//			click("riskmanagement_deletebtn_XPATH");
//
//			// wait for the element
//			Thread.sleep(3000);
//
//			// click on the delete button of confirmation popup
//			click("riskmanagement_deletebtn_confirmation_XPATH");
//
//			// enter the newly created task type in the search field
//			 
//			type("ssc_task_tasktemplateoption_filter_CSS", taskType);
//
//			// verify deleted recommendation template is displayed or not
//			try {
//
//				String createdRecommendationTemplate_XPATH = "//td[text()='" + taskType + "']";
//
//				String deleteElement1 = (driver.findElement(By.xpath(createdRecommendationTemplate_XPATH)).getText())
//						.trim();
//
//				if (deleteElement1.equals(taskType)) {
//					verificationFailedMessage("The  " + taskType + " is not deleted : ");
//				}
//
//			} catch (Throwable t) {
//				successMessage("The " + taskType + " is deleted successfully.");
//			}
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