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

public class RR5714RioCan4Test extends TestBase {

	@Test(dataProviderClass = TestUtil.class, dataProvider = "dp")
	public void rR5714RioCan4Test(Hashtable<String, String> data) throws IOException, InterruptedException {

		if (!(TestUtil.isTestRunnable("rR5714RioCan4Test", excel))) {

			throw new SkipException("Skipping the test " + "rR5714RioCan4Test".toUpperCase() + "as the Run mode is NO");
		}

		if (!data.get("runmode").equals("Y")) {

			throw new SkipException("Skipping the test case as the Run Mode for data set is NO");
		}

		// MANAGE RECOMMENDATIONS TASKS FROM THE DASHBOARD VIEW

		System.out.println(
				"******************** MANAGE RECOMMENDATIONS TASKS FROM THE DASHBOARD VIEW ********************");
		test.log(LogStatus.INFO,
				"******************** MANAGE RECOMMENDATIONS TASKS FROM THE DASHBOARD VIEW ********************");
		Reporter.log("******************** MANAGE RECOMMENDATIONS TASKS FROM THE DASHBOARD VIEW ********************");
		log.info("******************** MANAGE RECOMMENDATIONS TASKS FROM THE DASHBOARD VIEW ********************");

		String taskType = RandomStringUtils.randomAlphabetic(12);

		Random random = new Random();
		int taskCount = 2 + random.nextInt(5 - 2) + 2;

		System.out.println("TASKTYPE:::::::::::::::::" + taskType);
		System.out.println("TASKCOUNT::::::::::::::::" + taskCount);

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

		} catch (Throwable t) {
			verificationFailed();
		}

		// DELETE THE ALL NEWLY CREATED RECOMMENDATIONS TASK

		System.out
				.println("******************** DELETE THE ALL NEWLY CREATED RECOMMENDATIONS TASK ********************");
		test.log(LogStatus.INFO,
				"******************** DELETE THE ALL NEWLY CREATED RECOMMENDATIONS TASK ********************");
		Reporter.log("******************** DELETE THE ALL NEWLY CREATED RECOMMENDATIONS TASK ********************");
		log.info("******************** DELETE THE ALL NEWLY CREATED RECOMMENDATIONS TASK ********************");

		try {
			// enter the property name in the search field
			clear("envreports_propertylist_filtertxt_CSS");
			type("envreports_propertylist_filtertxt_CSS", data.get("property_2"));
			ngDriver.waitForAngularRequestsToFinish();
			System.out.println("Entered the property name in the search field.");

			// click on the risk management icon from the property list page
			click("riskmanagementicon_CSS");
			ngDriver.waitForAngularRequestsToFinish();
			System.out.println("Clicked on the risk management icon of the Property.");

			// wait for the element
			Thread.sleep(5000);

			// click on the burger menu
			click("menubtn_CSS");
			ngDriver.waitForAngularRequestsToFinish();
			System.out.println("Clicked on the burger menu button successfully!!!");

			// wait for the element
			Thread.sleep(5000);

			// click on the tasks option
			click("riskmanagement_taskoption_CSS");
			ngDriver.waitForAngularRequestsToFinish();
			System.out.println("Clicked on the tasks option.");

			List<WebElement> recommendationList = driver
					.findElements(By.xpath(OR.getProperty("riskmanagement_recommendationtasklist_XPATH")));
			int recommendationCount = recommendationList.size();

			System.out.println("recommendation Task Count :::::::::::::" + recommendationCount);

			for (int j = 0; j < recommendationCount; j++) {

				List<WebElement> recommendationList1 = driver
						.findElements(By.xpath(OR.getProperty("riskmanagement_recommendationtasklist_XPATH")));
				int recommendationCount1 = recommendationList1.size();
				System.out.println("recommendation Task Count :::::::::::::" + recommendationCount1);

				// click on the newly created recommendation task
				Random r = new Random();
				recommendationList1.get(r.nextInt(recommendationCount1)).click();
				ngDriver.waitForAngularRequestsToFinish();
				System.out.println("Clicked on the newly created recommendation task.");

				// wait for the element
				Thread.sleep(5000);

				// click on the delete button
				click("riskmanagement_recommendationtask_deletebtn_XPATH");
				ngDriver.waitForAngularRequestsToFinish();
				System.out.println("Clicked on the delete button.");

				// wait for the element
				Thread.sleep(3000);

				// click on the delete button of the confirmation popup
				click("riskmanagement_recommendationtask_deletebtn_confirmation_XPATH");
				ngDriver.waitForAngularRequestsToFinish();
				System.out.println("Clicked on the delete button of the confirmation popup.");

				// wait for the element
				Thread.sleep(3000);

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

		// CREATE A NEW RECOMMENDATION TEMPLATE

		System.out.println("******************** CREATE A NEW RECOMMENDATION TEMPLATE ********************");
		test.log(LogStatus.INFO, "******************** CREATE A NEW RECOMMENDATION TEMPLATE ********************");
		Reporter.log("******************** CREATE A NEW RECOMMENDATION TEMPLATE ********************");
		log.info("******************** CREATE A NEW RECOMMENDATION TEMPLATE ********************");

		try {
			// wait for the element
			Thread.sleep(5000);

			// click on the side menu
			click("ssc_leftsidemenubtn_CSS");
			ngDriver.waitForAngularRequestsToFinish();
			System.out.println("Clicked on the side menu.");

			// wait for the element
			Thread.sleep(5000);

			// click on the risk management
			click("sidemenu_riskmanagement_CSS");
			ngDriver.waitForAngularRequestsToFinish();
			System.out.println("Clicked on the risk management.");

			// select the Recommendations option from the Dashboard drop down
			select("dashboard_CSS", data.get("recommendations_dashboard"));
			ngDriver.waitForAngularRequestsToFinish();
			System.out.println("Selected the Recommendations option from the Dashboard drop down.");

			// wait for the element
			Thread.sleep(3000);

			// scroll down till bottom of the screen
			JavascriptExecutor js = (JavascriptExecutor) driver;
			js.executeScript("window.scrollTo(0, document.body.scrollHeight)");

			// click on the Recommendations Overview link
			click("riskmanagement_recommendationsdashboard_recommendationsoverviewlink_XPATH");
			ngDriver.waitForAngularRequestsToFinish();
			System.out.println("Clicked on the Recommendations Overview link.");

			// verify task type screen is displayed
			switchVerification("riskmanagement_recommendationsdashboard_tasktypetitle_XPATH", "Task Type",
					"The Task Type title is not displayed.");

			// click on the add recommendations button
			click("riskmanagement_recommendationsdashboard_createrecommendationsbtn_XPATH");
			ngDriver.waitForAngularRequestsToFinish();
			System.out.println("Clicked on the add recommendations button.");

			// enter task title in the field
			clear("riskmanagement_recommendationsdashboard_createrecommendations_tasktypetxt_XPATH");
			type("riskmanagement_recommendationsdashboard_createrecommendations_tasktypetxt_XPATH", taskType);
			ngDriver.waitForAngularRequestsToFinish();
			System.out.println("Entered task title in the field.");

			// scroll down till assign to label
			WebElement assignto = driver.findElement(By.xpath(OR
					.getProperty("riskmanagement_recommendationsdashboard_createrecommendations_assignedtolbl_XPATH")));
			js.executeScript("arguments[0].scrollIntoView(true);", assignto);

			// select the Not Applicable option from the recurring type drop down
			select("riskmanagement_recommendationsdashboard_createrecommendations_recurringtypedd_XPATH",
					data.get("recurrence_type_option"));
			ngDriver.waitForAngularRequestsToFinish();
			System.out.println("Selected the Not Applicable option from the recurring type drop down.");

			// select the environmental option from the drop down
			select("riskmanagement_recommendationsdashboard_createrecommendations_moduledd_XPATH", data.get("module"));
			ngDriver.waitForAngularRequestsToFinish();
			System.out.println("Selected the environmental option from the drop down.");

			// click on the save button
			click("riskmanagement_recommendationsdashboard_createrecommendations_savebtn_XPATH");
			ngDriver.waitForAngularRequestsToFinish();
			System.out.println("Clicked on the save button.");

			// wait for the element
			Thread.sleep(5000);

			// enter the newly created task type in the search field
			clear("ssc_task_tasktemplateoption_filter_CSS");
			type("ssc_task_tasktemplateoption_filter_CSS", taskType);
			ngDriver.waitForAngularRequestsToFinish();
			System.out.println("Entered the newly created task type in the search field.");

			// verify newly created task type is displayed or not

			try {
				String createdTaskType_XPATH = "//td[contains(text(),'" + taskType + "')]";

				String str2 = (driver.findElement(By.xpath(createdTaskType_XPATH)).getText()).trim();
				ngDriver.waitForAngularRequestsToFinish();
				if (str2.equals(taskType)) {
					Assert.assertTrue(isElementPresent(By.xpath(createdTaskType_XPATH)),
							"The " + taskType + " is not displayed.");

					System.out.println("The " + taskType + " is verified successfully.");
					test.log(LogStatus.INFO, "The " + taskType + " is verified successfully.");
					Reporter.log("The " + taskType + " is verified successfully.");
					log.info("The " + taskType + " is verified successfully.");
				} else {
					verificationFailed();

					System.out.println("The " + taskType + " is not displayed.");
					test.log(LogStatus.INFO, "The " + taskType + " is not displayed.");
					Reporter.log("The " + taskType + " is not displayed.");
					log.info("The " + taskType + " is not displayed.");

				}

			} catch (Throwable t) {
				verificationFailed();
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

		// CREATE RECOMMENDATION TASKS WITH NEWLY CREATED
		// RECOMMENDATION TEMPLATE AND 3 DAYS PASTE

		System.out.println(
				"******************** CREATE RECOMMENDATION TASKS WITH NEWLY CREATED RECOMMENDATION TEMPLATE AND 3 DAYS PASTE ********************");
		test.log(LogStatus.INFO,
				"******************** CREATE RECOMMENDATION TASKS WITH NEWLY CREATED RECOMMENDATION TEMPLATE AND 3 DAYS PASTE ********************");
		Reporter.log(
				"******************** CREATE RECOMMENDATION TASKS WITH NEWLY CREATED RECOMMENDATION TEMPLATE AND 3 DAYS PASTE ********************");
		log.info(
				"******************** CREATE RECOMMENDATION TASKS WITH NEWLY CREATED RECOMMENDATION TEMPLATE AND 3 DAYS PASTE ********************");

		try {
			// enter the property name in the search field
			clear("envreports_propertylist_filtertxt_CSS");
			type("envreports_propertylist_filtertxt_CSS", data.get("property_2"));
			ngDriver.waitForAngularRequestsToFinish();
			System.out.println("Entered the property name in the search field.");

			// click on the risk management icon from the property list page
			click("riskmanagementicon_CSS");
			ngDriver.waitForAngularRequestsToFinish();
			System.out.println("Clicked on the risk management icon of the Property.");

			// wait for the element
			Thread.sleep(5000);

			// click on the burger menu
			click("menubtn_CSS");
			ngDriver.waitForAngularRequestsToFinish();
			System.out.println("Clicked on the burger menu button successfully!!!");

			// wait for the element
			Thread.sleep(5000);

			// click on the tasks option
			click("riskmanagement_taskoption_CSS");
			ngDriver.waitForAngularRequestsToFinish();
			System.out.println("Clicked on the tasks option.");

			// click on the add button
			click("riskmanagement_addtaskbtn_CSS");
			ngDriver.waitForAngularRequestsToFinish();
			System.out.println("Clicked on the add button.");

			// click on the recommendation field
			click("riskmanagement_addtaskbtn_recommendationtxt_XPATH");
			ngDriver.waitForAngularRequestsToFinish();
			System.out.println("Clicked on the recommendation field.");

			// click on the clear button
			click("riskmanagement_addtaskbtn_recommendationclearbtn_XPATH");
			ngDriver.waitForAngularRequestsToFinish();
			System.out.println("Clicked on the clear button.");

			// enter newly created recommendation in search field
			clear("riskmanagement_addtaskbtn_roleassignsearchtxt_CSS");
			type("riskmanagement_addtaskbtn_roleassignsearchtxt_CSS", taskType);
			ngDriver.waitForAngularRequestsToFinish();
			System.out.println("Entered newly created recommendation in search field.");

			// click on the searched recommendation
			String searchedRecommendation = "//div[@ng-click='addOrRemoveToSelected(item); $hide()']//span[text()='"
					+ taskType + "']";
			driver.findElement(By.xpath(searchedRecommendation)).click();
			ngDriver.waitForAngularRequestsToFinish();
			System.out.println("Clicked on the searched recommendation.");

			// select the option from the for who drop down
			select("riskmanagement_addtaskbtn_forwhodd_XPATH", data.get("for_who"));
			ngDriver.waitForAngularRequestsToFinish();
			System.out.println("Selected the option from the for who drop down.");

			// scroll down the screen
			WebElement statuslbl = driver
					.findElement(By.xpath(OR.getProperty("riskmanagement_addtaskbtn_statuslbl_XPATH")));
			JavascriptExecutor js = (JavascriptExecutor) driver;
			js.executeScript("arguments[0].scrollIntoView(true);", statuslbl);

			// wait for the element
			Thread.sleep(3000);

			// enter the 3 days past date in the due date
			LocalDate currentDate = LocalDate.now();
			LocalDate pastDate = currentDate.minusDays(3);
			String expectedPastDate = pastDate.toString();
			System.out.println("//////////////////////////////// EXPECTED PAST DATE" + expectedPastDate);

			type("riskmanagement_addtaskbtn_duedatetxt_XPATH", expectedPastDate);
			ngDriver.waitForAngularRequestsToFinish();
			System.out.println("Entered the 3 days past date in the due date.");

			// click on the save button
			click("riskmanagement_addtaskbtn_savebtn_CSS");
			ngDriver.waitForAngularRequestsToFinish();
			System.out.println("Clicked on the save button.");

			// wait for the element
			Thread.sleep(5000);

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

		// VERIFY NEWLY CREATED TASK IS DISPLAYED IN THE LAST 30 DAYS DUE DATE
		// SECTION ON THE RECOMMENDATION SUMMARY DASHBOARD AND VERIFY IN THE TASK LIST

		System.out.println(
				"******************** VERIFY NEWLY CREATED TASK IS DISPLAYED IN THE LAST 30 DAYS DUE DATE SECTION ON THE RECOMMENDATION SUMMARY DASHBOARD AND VERIFY IN THE TASK LIST ********************");
		test.log(LogStatus.INFO,
				"******************** VERIFY NEWLY CREATED TASK IS DISPLAYED IN THE LAST 30 DAYS DUE DATE SECTION ON THE RECOMMENDATION SUMMARY DASHBOARD AND VERIFY IN THE TASK LIST ********************");
		Reporter.log(
				"******************** VERIFY NEWLY CREATED TASK IS DISPLAYED IN THE LAST 30 DAYS DUE DATE SECTION ON THE RECOMMENDATION SUMMARY DASHBOARD AND VERIFY IN THE TASK LIST ********************");
		log.info(
				"******************** VERIFY NEWLY CREATED TASK IS DISPLAYED IN THE LAST 30 DAYS DUE DATE SECTION ON THE RECOMMENDATION SUMMARY DASHBOARD AND VERIFY IN THE TASK LIST ********************");

		try {

			// wait for the element
			Thread.sleep(5000);

			// click on the side menu
			click("ssc_leftsidemenubtn_CSS");
			ngDriver.waitForAngularRequestsToFinish();
			System.out.println("Clicked on the side menu.");

			// wait for the element
			Thread.sleep(5000);

			// click on the risk management
			click("sidemenu_riskmanagement_CSS");
			ngDriver.waitForAngularRequestsToFinish();
			System.out.println("Clicked on the risk management.");

			// select the Recommendations option from the Dashboard drop down
			select("dashboard_CSS", data.get("recommendations_dashboard"));
			ngDriver.waitForAngularRequestsToFinish();
			System.out.println("Selected the Recommendations option from the Dashboard drop down.");

			// wait for the element
			Thread.sleep(3000);

			// scroll down till bottom of the screen
			JavascriptExecutor js = (JavascriptExecutor) driver;
			js.executeScript("window.scrollTo(0, document.body.scrollHeight)");

			// click on the count of the overdue task
			click("ssc_riskmanagement_recommendations_record1_XPATH");
			ngDriver.waitForAngularRequestsToFinish();
			System.out.println("Clicked on the count of the overdue task.");

			// verify the overdue task title
			switchVerification("riskmanagement_dashboardtaskscreen_overduetitle_XPATH", "Overdue Tasks",
					"The Overdue Tasks title is not displayed.");

			// enter newly created recommendation task in search field
			clear("riskmanagement_dashboardtaskscreen_searchtxt_XPATH");
			type("riskmanagement_dashboardtaskscreen_searchtxt_XPATH", taskType);
			ngDriver.waitForAngularRequestsToFinish();
			System.out.println("Entered newly created recommendation task in search field.");

			// click on the action icon
			String overDueTask = "//td[text()='" + taskType
					+ "']//following-sibling::td[@class='dropdown']//i[@data-toggle='dropdown']";
			driver.findElement(By.xpath(overDueTask)).click();
			ngDriver.waitForAngularRequestsToFinish();
			System.out.println("Clicked on the action icon.");

			// click on the edit task option
			String editTakOption = "//td[text()='" + taskType
					+ "']//following-sibling::td[@class='dropdown open']//li[@ng-click='selectOverdueTask(task); editTask(task)']";
			driver.findElement(By.xpath(editTakOption)).click();
			ngDriver.waitForAngularRequestsToFinish();
			System.out.println("Clicked on the edit task option.");

			// select the option from the for who drop down
			select("riskmanagement_addtaskbtn_forwhodd_XPATH", data.get("update_for_who"));
			ngDriver.waitForAngularRequestsToFinish();
			System.out.println("Selected the option from the for who drop down.");

			// click on the start button
			click("propertyproject_mu_repair_startbtn_CSS");
			ngDriver.waitForAngularRequestsToFinish();
			System.out.println("Clicked on the start button.");

			// scroll down the screen
			WebElement forwhotxt = driver
					.findElement(By.xpath(OR.getProperty("riskmanagement_addtaskbtn_forwhodd_XPATH")));
			js.executeScript("arguments[0].scrollIntoView(true);", forwhotxt);

			// verify updated status is displayed or not
			switchVerification("propertyproject_mu_inprogressstatus_XPATH", "In Progress",
					"The In Progress status is not displayed.");

			// click on the update button
			click("riskmanagement_recommendationsdashboard_createrecommendations_updatebtn_XPATH");
			ngDriver.waitForAngularRequestsToFinish();
			System.out.println("Clicked on the update button.");

			// enter newly created recommendation task in search field
			clear("riskmanagement_dashboardtaskscreen_searchtxt_XPATH");
			type("riskmanagement_dashboardtaskscreen_searchtxt_XPATH", taskType);
			ngDriver.waitForAngularRequestsToFinish();
			System.out.println("Entered newly created recommendation task in search field.");

			// click on the action icon
			String overDueTask1 = "//td[text()='" + taskType
					+ "']//following-sibling::td[@class='dropdown']//i[@data-toggle='dropdown']";
			driver.findElement(By.xpath(overDueTask1)).click();
			ngDriver.waitForAngularRequestsToFinish();
			System.out.println("Clicked on the action icon.");

			// click on the edit task option
			String editTakOption1 = "//td[text()='" + taskType
					+ "']//following-sibling::td[@class='dropdown open']//li[@ng-click='selectOverdueTask(task); editTask(task)']";
			driver.findElement(By.xpath(editTakOption1)).click();
			ngDriver.waitForAngularRequestsToFinish();
			System.out.println("Clicked on the edit task option.");

			// click on the change due date button
			click("riskmanagement_dashboardtaskscreen_changeduedatebtn_XPATH");
			ngDriver.waitForAngularRequestsToFinish();
			System.out.println("Clicked on the change due date button.");

			// wait for the element
			Thread.sleep(5000);

			// enter the past due date in the due date field
			LocalDate currentDate1 = LocalDate.now();
			LocalDate pastDate1 = currentDate1.minusDays(5);
			String expectedPastDate1 = pastDate1.toString();
			System.out.println("//////////////////////////////// EXPECTED PAST DATE 1" + expectedPastDate1);

			type("riskmanagement_dashboardtaskscreen_newduedatetxt1_XPATH", expectedPastDate1);
			ngDriver.waitForAngularRequestsToFinish();
			System.out.println("Entered the past due date in the due date field.");

			// enter the details in the reason field
			type("riskmanagement_dashboardtaskscreen_reasonforchangetxt1_XPATH", data.get("reason"));
			ngDriver.waitForAngularRequestsToFinish();
			System.out.println("Entered the details in the reason field.");

			// click on the apply button
			click("riskmanagement_recommendationsdashboard_createrecommendations_applybtn_XPATH");
			ngDriver.waitForAngularRequestsToFinish();
			System.out.println("Clicked on the apply button.");

			// wait for the element
			explicitWaitClickable("closetoastmsg_CSS");

			// click on the toaster close button
			click("closetoastmsg_CSS");
			ngDriver.waitForAngularRequestsToFinish();
			System.out.println("Clicked on the toaster close button.");

			// wait for the element
			Thread.sleep(15000);

			// enter newly created recommendation task in search field
			clear("riskmanagement_dashboardtaskscreen_searchtxt_XPATH");
			type("riskmanagement_dashboardtaskscreen_searchtxt_XPATH", taskType);
			ngDriver.waitForAngularRequestsToFinish();
			System.out.println("Entered newly created recommendation task in search field.");

			try {
				// verify updated data is displayed correctly or not
				String updatedDetails = "//td[text()='" + taskType
						+ "']//following-sibling::td[text()='In Progress']//following-sibling::td[text()='"
						+ expectedPastDate1 + "']";

				String str2 = (driver.findElement(By.xpath(updatedDetails)).getText()).trim();
				if (str2.equals(expectedPastDate1)) {
					Assert.assertTrue(isElementPresent(By.xpath(updatedDetails)),
							"The updated details are not displayed.");

					System.out.println("The updated details are verified successfully.");
					test.log(LogStatus.INFO, "The updated details are verified successfully.");
					Reporter.log("The updated details are verified successfully.");
					log.info("The updated details are verified successfully.");
				} else {
					verificationFailed();

					System.out.println("The updated details are not verified.");
					test.log(LogStatus.INFO, "The updated details are not verified.");
					Reporter.log("The updated details are not verified.");
					log.info("The updated details are not verified.");
				}

			} catch (Throwable t) {
				verificationFailed();

				System.out.println("The updated details are not verified.");
				test.log(LogStatus.INFO, "The updated details are not verified.");
				Reporter.log("The updated details are not verified.");
				log.info("The updated details are not verified.");
			}

		} catch (Throwable t) {
			verificationFailed();
		}

		// refresh the screen
		driver.navigate().refresh();
		Thread.sleep(5000);
		driver.navigate().refresh();

		// click on the home icon from the top of the screen
		click("questionnaire_homeburgermenubtn_hide_CSS");
		System.out.println("Clicked on the home icon from the top of the screen.");
		ngDriver.waitForAngularRequestsToFinish();

		// synchronization
		explicitWait("propertylist_title_XPATH");

		// verify the property list
		switchVerification("propertylist_title_XPATH", "Property List", "The property list is not displayed.");

		// DELETE THE ALL NEWLY CREATED RECOMMENDATIONS TASK - LESS THAN 30 PAST DAYS

		System.out.println(
				"******************** DELETE THE ALL NEWLY CREATED RECOMMENDATIONS TASK - LESS THAN 30 PAST DAYS ********************");
		test.log(LogStatus.INFO,
				"******************** DELETE THE ALL NEWLY CREATED RECOMMENDATIONS TASK - LESS THAN 30 PAST DAYS ********************");
		Reporter.log(
				"******************** DELETE THE ALL NEWLY CREATED RECOMMENDATIONS TASK - LESS THAN 30 PAST DAYS ********************");
		log.info(
				"******************** DELETE THE ALL NEWLY CREATED RECOMMENDATIONS TASK - LESS THAN 30 PAST DAYS ********************");

		try {
			// enter the property name in the search field
			clear("envreports_propertylist_filtertxt_CSS");
			type("envreports_propertylist_filtertxt_CSS", data.get("property_2"));
			ngDriver.waitForAngularRequestsToFinish();
			System.out.println("Entered the property name in the search field.");

			// click on the risk management icon from the property list page
			click("riskmanagementicon_CSS");
			ngDriver.waitForAngularRequestsToFinish();
			System.out.println("Clicked on the risk management icon of the Property.");

			// wait for the element
			Thread.sleep(5000);

			// click on the burger menu
			click("menubtn_CSS");
			ngDriver.waitForAngularRequestsToFinish();
			System.out.println("Clicked on the burger menu button successfully!!!");

			// wait for the element
			Thread.sleep(5000);

			// click on the tasks option
			click("riskmanagement_taskoption_CSS");
			ngDriver.waitForAngularRequestsToFinish();
			System.out.println("Clicked on the tasks option.");

			// wait for the element
			Thread.sleep(5000);

			List<WebElement> recommendationList1 = driver
					.findElements(By.xpath(OR.getProperty("riskmanagement_recommendationtasklist_XPATH")));
			int recommendationCount1 = recommendationList1.size();

			System.out.println("recommendation Task Count :::::::::::::" + recommendationCount1);

			for (int j = 0; j < recommendationCount1; j++) {

				List<WebElement> recommendationList11 = driver
						.findElements(By.xpath(OR.getProperty("riskmanagement_recommendationtasklist_XPATH")));
				int recommendationCount11 = recommendationList11.size();
				System.out.println("recommendation Task Count :::::::::::::" + recommendationCount11);

				// click on the newly created recommendation task
				Random r = new Random();
				recommendationList11.get(r.nextInt(recommendationCount11)).click();
				ngDriver.waitForAngularRequestsToFinish();
				System.out.println("Clicked on the newly created recommendation task.");

				// wait for the element
				explicitWaitClickable("riskmanagement_recommendationtask_deletebtn_XPATH");

				// click on the delete button
				click("riskmanagement_recommendationtask_deletebtn_XPATH");
				ngDriver.waitForAngularRequestsToFinish();
				System.out.println("Clicked on the delete button.");

				// wait for the element
				explicitWaitClickable("riskmanagement_recommendationtask_deletebtn_confirmation_XPATH");

				// click on the delete button of the confirmation popup
				click("riskmanagement_recommendationtask_deletebtn_confirmation_XPATH");
				ngDriver.waitForAngularRequestsToFinish();
				System.out.println("Clicked on the delete button of the confirmation popup.");

				// wait for the element
				Thread.sleep(3000);

			}

			// enter the newly created recommendation task in the search field
			clear("riskmanagement_searchtxt_CSS");
			type("riskmanagement_searchtxt_CSS", taskType);
			ngDriver.waitForAngularRequestsToFinish();
			System.out.println("Entered the newly created recommendation task in the search field.");

			// verify deleted recommendation task is displayed or not
			try {

				String createdRecommendationTask_XPATH = "//td[text()='" + taskType + "']";

				String deleteElement = (driver.findElement(By.xpath(createdRecommendationTask_XPATH)).getText()).trim();

				if (deleteElement.equals(taskType)) {

					Assert.assertTrue(isElementPresent(By.xpath(createdRecommendationTask_XPATH)),
							"The " + taskType + " is displayed.");

					TestUtil.captureScreenshot();

					// ReportNG
					Reporter.log("<br>" + "The  " + taskType + " is not deleted : " + "<br>");
					Reporter.log("<a target=\"_blank\" href=" + TestUtil.screenshotName + "><img src="
							+ TestUtil.screenshotName + " height=200 width=200></img></a>");
					Reporter.log("<br>");
					Reporter.log("<br>");

					// Extent Report
					test.log(LogStatus.FAIL, " The " + taskType + " is not deleted : ");
					test.log(LogStatus.FAIL, test.addScreenCapture(TestUtil.screenshotName));

					System.out.println("The " + taskType + " is not deleted.");
					log.info("The " + taskType + " is not deleted.");

				}
			} catch (Throwable t) {
				System.out.println("The " + taskType + " is deleted successfully.");
				test.log(LogStatus.INFO, "The " + taskType + " is deleted successfully.");
				Reporter.log("The " + taskType + " is deleted successfully.");
				log.info("The " + taskType + " is deleted successfully.");
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

//		// DELETE THE NEWLY CREATED RECOMMENDATION TEMPLATE AFTER DELETE
//		// RECOMMENDATION TASK
//
//		System.out.println(
//				"******************** DELETE THE NEWLY CREATED RECOMMENDATION TEMPLATE AFTER DELETE RECOMMENDATION TASK ********************");
//		test.log(LogStatus.INFO,
//				"******************** DELETE THE NEWLY CREATED RECOMMENDATION TEMPLATE AFTER DELETE RECOMMENDATION TASK ********************");
//		Reporter.log(
//				"******************** DELETE THE NEWLY CREATED RECOMMENDATION TEMPLATE AFTER DELETE RECOMMENDATION TASK ********************");
//		log.info(
//				"******************** DELETE THE NEWLY CREATED RECOMMENDATION TEMPLATE AFTER DELETE RECOMMENDATION TASK ********************");
//
//		try {
//			// click on the side menu
//			click("ssc_leftsidemenubtn_CSS");
//			ngDriver.waitForAngularRequestsToFinish();
//			System.out.println("Clicked on the side menu.");
//
//			// wait for the element
//			explicitWaitClickable("sidemenu_riskmanagement_CSS");
//
//			// click on the risk management
//			click("sidemenu_riskmanagement_CSS");
//			ngDriver.waitForAngularRequestsToFinish();
//			System.out.println("Clicked on the risk management.");
//
//			// select the Recommendations option from the Dashboard drop down
//			select("dashboard_CSS", data.get("recommendations_dashboard"));
//			ngDriver.waitForAngularRequestsToFinish();
//			System.out.println("Selected the Recommendations option from the Dashboard drop down.");
//
//			// wait for the element
//			Thread.sleep(3000);
//
//			// scroll down till bottom of the screen
//			JavascriptExecutor js = (JavascriptExecutor) driver;
//			js.executeScript("window.scrollTo(0, document.body.scrollHeight)");
//
//			// click on the Recommendations Overview link
//			click("riskmanagement_recommendationsdashboard_recommendationsoverviewlink_XPATH");
//			ngDriver.waitForAngularRequestsToFinish();
//			System.out.println("Clicked on the Recommendations Overview link.");
//
//			// verify task type screen is displayed
//			switchVerification("riskmanagement_recommendationsdashboard_tasktypetitle_XPATH", "Task Type",
//					"The Task Type title is not displayed.");
//
//			// enter the newly created task type in the search field
//			clear("ssc_task_tasktemplateoption_filter_CSS");
//			type("ssc_task_tasktemplateoption_filter_CSS", taskType);
//			ngDriver.waitForAngularRequestsToFinish();
//			System.out.println("Entered the newly created task type in the search field.");
//
//			// click on the newly created recommendation template
//			String searchedRecommendationTemplate = "//td[contains(text(),'" + taskType + "')]";
//			driver.findElement(By.xpath(searchedRecommendationTemplate)).click();
//			ngDriver.waitForAngularRequestsToFinish();
//			System.out.println("Clicked on the newly created recommendation template.");
//
//			// wait for the element
//			Thread.sleep(7000);
//
//			// click on the delete button
//			click("riskmanagement_deletebtn_XPATH");
//			ngDriver.waitForAngularRequestsToFinish();
//			System.out.println("Clicked on the delete button.");
//
//			// wait for the element
//			Thread.sleep(3000);
//
//			// click on the delete button of confirmation popup
//			click("riskmanagement_deletebtn_confirmation_XPATH");
//			ngDriver.waitForAngularRequestsToFinish();
//			System.out.println("Clicked on the delete button of confirmation popup.");
//
//			// enter the newly created task type in the search field
//			clear("ssc_task_tasktemplateoption_filter_CSS");
//			type("ssc_task_tasktemplateoption_filter_CSS", taskType);
//			ngDriver.waitForAngularRequestsToFinish();
//			System.out.println("Entered the newly created task type in the search field.");
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
//
//					Assert.assertTrue(isElementPresent(By.xpath(createdRecommendationTemplate_XPATH)),
//							"The " + taskType + " is displayed.");
//
//					TestUtil.captureScreenshot();
//
//					// ReportNG
//					Reporter.log("<br>" + "The  " + taskType + " is not deleted : " + "<br>");
//					Reporter.log("<a target=\"_blank\" href=" + TestUtil.screenshotName + "><img src="
//							+ TestUtil.screenshotName + " height=200 width=200></img></a>");
//					Reporter.log("<br>");
//					Reporter.log("<br>");
//
//					// Extent Report
//					test.log(LogStatus.FAIL, " The " + taskType + " is not deleted : ");
//					test.log(LogStatus.FAIL, test.addScreenCapture(TestUtil.screenshotName));
//
//					System.out.println("The " + taskType + " is not deleted.");
//					log.info("The " + taskType + " is not deleted.");
//
//				}
//
//			} catch (Throwable t) {
//				System.out.println("The " + taskType + " is deleted successfully.");
//				test.log(LogStatus.INFO, "The " + taskType + " is deleted successfully.");
//				Reporter.log("The " + taskType + " is deleted successfully.");
//				log.info("The " + taskType + " is deleted successfully.");
//			}
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
