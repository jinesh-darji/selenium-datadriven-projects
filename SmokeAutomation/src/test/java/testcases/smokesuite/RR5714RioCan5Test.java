package testcases.smokesuite;

import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;
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

public class RR5714RioCan5Test extends TestBase {

	@Test(dataProviderClass = TestUtil.class, dataProvider = "dp")
	public void rR5714RioCan5Test(Hashtable<String, String> data) throws IOException, InterruptedException {

		execution(data, "rR5714RioCan5Test");

		// OPEN RECURRENCE TASKS - UPDATE ITS DUE DATE WITH REASON - CLOSE THE TASK
		title("OPEN RECURRENCE TASKS - UPDATE ITS DUE DATE WITH REASON - CLOSE THE TASK");

		String taskType = RandomStringUtils.randomAlphabetic(12);

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
			Thread.sleep(5000);

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

		// CREATE RECOMMENDATION TASKS WITH NEWLY CREATED RECOMMENDATION TEMPLATE
		title("CREATE RECOMMENDATION TASKS WITH NEWLY CREATED RECOMMENDATION TEMPLATE");

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

			// enter interval in the frequency interval field

			type("ssc_riskmanagement_recommendations_taskfrequencyinterval_XPATH", "1");

			// select year option from the frequency dropdown
			select("ssc_riskmanagement_recommendations_taskfrequency1_XPATH", data.get("task_frequency"));

			// wait for the element
			Thread.sleep(3000);

			// enter the 3 days past date in the due date
			LocalDate currentDate = LocalDate.now();
			String expectedCurrentDate = currentDate.toString();

			type("riskmanagement_addtaskbtn_duedatetxt_XPATH", expectedCurrentDate);

			// click on the save button
			click("riskmanagement_addtaskbtn_savebtn_CSS");

			// wait for the element
			Thread.sleep(5000);

		} catch (Throwable t) {
			verificationFailed();
		}

		// click on the home icon from the top of the screen
		click("questionnaire_homeburgermenubtn_hide_CSS");

		// synchronization
		explicitWait("propertylist_title_XPATH");

		// verify the property list
		switchVerification("propertylist_title_XPATH", "Property List", "The property list is not displayed.");

		// UPDATE THE DUE DATE AND VALIDATE NEWLY UPDATED DUE DATE
		title("UPDATE THE DUE DATE AND VALIDATE NEWLY UPDATED DUE DATE");

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

			// click on the newly created task
			String newTask = "//td[text()='" + taskType + "']";
			driver.findElement(By.xpath(newTask)).click();

			// click on the change due date button
			click("riskmanagement_dashboardtaskscreen_changeduedatebtn_XPATH");

			// wait for the element
			Thread.sleep(5000);

			// enter the past due date in the due date field
			LocalDate currentDate1 = LocalDate.now();
			LocalDate pastDate1 = currentDate1.minusDays(5);
			String expectedPastDate1 = pastDate1.toString();
			type("riskmanagement_dashboardtaskscreen_newduedatetxt1_XPATH", expectedPastDate1);

			// enter the details in the reason field
			type("riskmanagement_dashboardtaskscreen_reasonforchangetxt1_XPATH", data.get("reason"));

			// click on the apply button
			click("riskmanagement_recommendationsdashboard_createrecommendations_applybtn_XPATH");

			// enter newly created recommendation task in search field

			type("riskmanagement_task_searchtxt_XPATH", taskType);

			try {
				// verify updated data is displayed correctly or not
				String updatedDetails = "//td[text()='" + taskType + "']//following-sibling::td[text()='"
						+ expectedPastDate1 + "']";

				String str2 = (driver.findElement(By.xpath(updatedDetails)).getText()).trim();

				if (str2.equals(expectedPastDate1)) {
					successMessage("The updated details are verified successfully.");
				} else {
					verificationFailedMessage("The updated details are not verified.");
				}

			} catch (Throwable t) {
				verificationFailedMessage("The updated details are not verified.");
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

		// CLOSE THE NEWLY CREATED TASK
		title("CLOSE THE NEWLY CREATED TASK");

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

			// click on the newly created task
			String newTask = "//td[text()='" + taskType + "']";
			driver.findElement(By.xpath(newTask)).click();

			// click on the start button
			click("propertyproject_mu_repair_startbtn_CSS");

			// scroll down the screen
			scrollTillElement("riskmanagement_addtaskbtn_forwhodd_XPATH");

			// verify updated status is displayed or not
			switchVerification("propertyproject_mu_inprogressstatus_XPATH", "In Progress",
					"The In Progress status is not displayed.");

			// click on the close button
			click("riskmanagement_task_closebtn_XPATH");

			// click on the close button of confirmation popup
			click("riskmanagement_task_closebtn_confirmation_XPATH");

			// wait for the validation message
			Thread.sleep(5000);

			// verify the attachment validation message
			switchVerification("riskmanagement_task_attachmentvalidation_XPATH", "No attachments provided",
					"The No attachments provided is not displayed.");

			// click on the close button
			click("riskmanagement_task_attachmentvalidation_closebtn_XPATH");

			// wait for the validation message
			Thread.sleep(5000);

			// scroll up the screen
			scrollTop();

			// click on the attachment tab
			click("riskmanagement_task_attachmenttab_XPATH");

			// click on upload local file button
//			driver.findElement(By.xpath(OR.getProperty("riskmanagement_task_attachmenttab_uploadbtn_XPATH")))
//					.sendKeys("C:\\Users\\Jinesh\\risktestautomation\\Refined_Risk_SmokeAutomation\\src\\test\\resources\\logs\\sample.pdf");
//			click("riskmanagement_task_attachmenttab_uploadbtn_XPATH");
//			 
//			// put path of the file in a clip board
//			StringSelection ss = new StringSelection(
//					System.getProperty("user.dir") + "/src/test/resources/logs/sample.pdf");
//			Toolkit.getDefaultToolkit().getSystemClipboard().setContents(ss, null);
//
//			// imitate mouse events like ENTER, CTRL+C, CTRL+V
//			Robot robot = new Robot();
//			robot.delay(250);
//			robot.keyPress(KeyEvent.VK_ENTER);
//			robot.keyRelease(KeyEvent.VK_ENTER);
//			robot.keyPress(KeyEvent.VK_CONTROL);
//			robot.keyPress(KeyEvent.VK_V);
//			robot.keyRelease(KeyEvent.VK_V);
//			robot.keyRelease(KeyEvent.VK_CONTROL);
//			robot.delay(90);
//			robot.keyPress(KeyEvent.VK_ENTER);
//			robot.keyRelease(KeyEvent.VK_ENTER);

			// wait for the element
			Thread.sleep(10000);

			// click on the close button
			click("riskmanagement_task_closebtn_XPATH");

			// click on the close button of confirmation popup
			click("riskmanagement_task_closebtn_confirmation_XPATH");

			try {
				// verify reopen button is displayed or not
				boolean reopenBTN = driver.findElement(By.xpath(OR.getProperty("riskmanagement_task_reopenbtn_XPATH")))
						.isDisplayed();

				if (reopenBTN == true) {
					successMessage("THE REOPEN BUTTON IS DISPLAYED SUCCESSFULLY.");
				} else {
					verificationFailedMessage("THE REOPEN BUTTON IS NOT DISPLAYED.");
				}

			} catch (Throwable t) {
				verificationFailedMessage("THE REOPEN BUTTON IS NOT DISPLAYED.");
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

		// VERIFY NEWLY CREATED RECURRING TASK IN ACTIVE TASK LIST AND REOPEN THE CLOSED
		// TASK
		title("VERIFY NEWLY CREATED RECURRING TASK IN ACTIVE TASK LIST AND REOPEN THE CLOSED TASK");

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

			// select active option from the task status drop down
			select("riskmanagement_task_taskstatusdd_XPATH", data.get("task_status_activeoption"));

			// type newly created recurring task

			type("riskmanagement_task_searchtxt_XPATH", taskType);

			try {
				// verify newly created recurring task
				LocalDate currentDate1 = LocalDate.now();
				LocalDate futureDate1 = currentDate1.plusYears(1);
				String expectedFutureDate1 = futureDate1.toString();
				String futureTaskDate = "//td[text()='" + taskType + "']//following-sibling::td[text()='"
						+ expectedFutureDate1 + "']";

				boolean recurringTask = driver.findElement(By.xpath(futureTaskDate)).isDisplayed();

				if (recurringTask == true) {
					successMessage("THE NEWLY CREATED RECURRING TASK IS DISPLAYED SUCCESSFULLY.");
				} else {
					verificationFailedMessage("THE NEWLY CREATED RECURRING TASK IS NOT DISPLAYED.");
				}

			} catch (Throwable t) {
				verificationFailedMessage("THE NEWLY CREATED RECURRING TASK IS NOT DISPLAYED.");
			}

			// click on the newly recurring task
			String futuretask1 = "//td[text()='" + taskType + "']";
			driver.findElement(By.xpath(futuretask1)).click();

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

			// select closed option from the task status drop down
			select("riskmanagement_task_taskstatusdd_XPATH", data.get("task_status_closedoption"));

			// type newly created recurring task

			type("riskmanagement_task_searchtxt_XPATH", taskType);

			try {
				// enter the past due date in the due date field
				LocalDate currentDate2 = LocalDate.now();
				LocalDate pastDate2 = currentDate2.minusDays(5);
				String expectedPastDate2 = pastDate2.toString();
				String pastTaskDate2 = "//td[text()='" + taskType + "']//following-sibling::td[text()='"
						+ expectedPastDate2 + "']";

				boolean recurringClosedTask = driver.findElement(By.xpath(pastTaskDate2)).isDisplayed();

				if (recurringClosedTask == true) {
					successMessage("THE NEWLY CREATED RECURRING TASK IS DISPLAYED SUCCESSFULLY.");

					// click on the closed task
					driver.findElement(By.xpath(pastTaskDate2)).click();

					// click on the reopen button
					click("riskmanagement_task_reopenbtn_XPATH");

					// wait for the element
					Thread.sleep(5000);

					// verify approve button
					boolean approveBTN = driver
							.findElement(By.xpath(OR.getProperty("riskmanagement_task_approvebtn_XPATH")))
							.isDisplayed();

					if (approveBTN == true) {
						successMessage("THE APPROVE BUTTON IS DISPLAYED SUCCESSFULLY.");
					}

				} else {
					verificationFailedMessage("THE APPROVE BUTTON IS NOT DISPLAYED.");
				}

			} catch (Throwable t) {
				verificationFailedMessage("THE APPROVE BUTTON IS NOT DISPLAYED.");
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

			// click on the newly recurring task
			String futuretask1 = "//td[text()='" + taskType + "']";
			driver.findElement(By.xpath(futuretask1)).click();

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
			// click on the side menu
			click("ssc_leftsidemenubtn_CSS");

			// wait for the element
			explicitWaitClickable("sidemenu_riskmanagement_CSS");

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