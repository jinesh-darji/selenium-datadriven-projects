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

		if (!(TestUtil.isTestRunnable("rR5714RioCan3Test", excel))) {

			throw new SkipException("Skipping the test " + "rR5714RioCan3Test".toUpperCase() + "as the Run mode is NO");
		}

		if (!data.get("runmode").equals("Y")) {

			throw new SkipException("Skipping the test case as the Run Mode for data set is NO");
		}

		// VERIFY THE COUNT OF THE RECOMMENDATION SUMMARY DASHBOARD

		System.out.println(
				"******************** VERIFY THE COUNT OF THE RECOMMENDATION SUMMARY DASHBOARD ********************");
		test.log(LogStatus.INFO,
				"******************** VERIFY THE COUNT OF THE RECOMMENDATION SUMMARY DASHBOARD ********************");
		Reporter.log(
				"******************** VERIFY THE COUNT OF THE RECOMMENDATION SUMMARY DASHBOARD ********************");
		log.info("******************** VERIFY THE COUNT OF THE RECOMMENDATION SUMMARY DASHBOARD ********************");

		String taskType = RandomStringUtils.randomAlphabetic(12);

		Random random = new Random();
		int taskCount1 = 2 + random.nextInt(5 - 2) + 2;
		int taskCount2 = 2 + random.nextInt(5 - 2) + 2;
		int taskCount3 = 2 + random.nextInt(5 - 2) + 2;

		System.out.println("TASKTYPE:::::::::::::::::" + taskType);
		System.out.println("TASKCOUNT1::::::::::::::::" + taskCount1);
		System.out.println("TASKCOUNT2::::::::::::::::" + taskCount2);
		System.out.println("TASKCOUNT3::::::::::::::::" + taskCount3);

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
			explicitWaitClickable("closetoastmsg_CSS");

			// click on the toaster close button
			click("closetoastmsg_CSS");
			ngDriver.waitForAngularRequestsToFinish();
			System.out.println("Clicked on the toaster close button.");

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

		// CREATE RANDOM NUMBER OF RECOMMENDATION TASKS WITH NEWLY CREATED
		// RECOMMENDATION TEMPLATE AND 3 DAYS PASTE

		System.out.println(
				"******************** CREATE RANDOM NUMBER OF RECOMMENDATION TASKS WITH NEWLY CREATED RECOMMENDATION TEMPLATE AND 3 DAYS PASTE ********************");
		test.log(LogStatus.INFO,
				"******************** CREATE RANDOM NUMBER OF RECOMMENDATION TASKS WITH NEWLY CREATED RECOMMENDATION TEMPLATE AND 3 DAYS PASTE ********************");
		Reporter.log(
				"******************** CREATE RANDOM NUMBER OF RECOMMENDATION TASKS WITH NEWLY CREATED RECOMMENDATION TEMPLATE AND 3 DAYS PASTE ********************");
		log.info(
				"******************** CREATE RANDOM NUMBER OF RECOMMENDATION TASKS WITH NEWLY CREATED RECOMMENDATION TEMPLATE AND 3 DAYS PASTE ********************");

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

			for (int i = 1; i <= taskCount1; i++) {

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

		// VERIFY NEWLY CREATED TASK COUNT IS DISPLAYED IN THE LAST 30 DAYS DUE DATE
		// SECTION ON THE RECOMMENDATION SUMMARY DASHBOARD

		System.out.println(
				"******************** VERIFY NEWLY CREATED TASK COUNT IS DISPLAYED IN THE LAST 30 DAYS DUE DATE SECTION ON THE RECOMMENDATION SUMMARY DASHBOARD ********************");
		test.log(LogStatus.INFO,
				"******************** VERIFY NEWLY CREATED TASK COUNT IS DISPLAYED IN THE LAST 30 DAYS DUE DATE SECTION ON THE RECOMMENDATION SUMMARY DASHBOARD ********************");
		Reporter.log(
				"******************** VERIFY NEWLY CREATED TASK COUNT IS DISPLAYED IN THE LAST 30 DAYS DUE DATE SECTION ON THE RECOMMENDATION SUMMARY DASHBOARD ********************");
		log.info(
				"******************** VERIFY NEWLY CREATED TASK COUNT IS DISPLAYED IN THE LAST 30 DAYS DUE DATE SECTION ON THE RECOMMENDATION SUMMARY DASHBOARD ********************");

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

			try {
				// verify count of the overdue tasks
				String pastDate = (driver
						.findElement(By.xpath(OR.getProperty("ssc_riskmanagement_recommendations_record1_XPATH")))
						.getText()).trim();
				int pastDateInt = Integer.parseInt(pastDate);

				if (pastDateInt == taskCount1) {
					System.out.println(
							"THE COUNT OF THE OVERDUE TASKS OF THE LAST 30 DAYS SECTION IS DISPLAYED CORRECTLY.");
					test.log(LogStatus.INFO,
							"THE COUNT OF THE OVERDUE TASKS OF THE LAST 30 DAYS SECTION IS DISPLAYED CORRECTLY.");
					Reporter.log("THE COUNT OF THE OVERDUE TASKS OF THE LAST 30 DAYS SECTION IS DISPLAYED CORRECTLY.");
					log.info("THE COUNT OF THE OVERDUE TASKS OF THE LAST 30 DAYS SECTION IS DISPLAYED CORRECTLY.");
				} else {

					verificationFailed();

					System.out.println(
							"THE COUNT OF THE OVERDUE TASKS OF THE LAST 30 DAYS SECTION IS NOT DISPLAYED CORRECTLY.");
					test.log(LogStatus.INFO,
							"THE COUNT OF THE OVERDUE TASKS OF THE LAST 30 DAYS SECTION IS NOT DISPLAYED CORRECTLY.");
					Reporter.log(
							"THE COUNT OF THE OVERDUE TASKS OF THE LAST 30 DAYS SECTION IS NOT DISPLAYED CORRECTLY.");
					log.info("THE COUNT OF THE OVERDUE TASKS OF THE LAST 30 DAYS SECTION IS NOT DISPLAYED CORRECTLY.");
				}

			} catch (Throwable t) {
				verificationFailed();

				System.out.println(
						"THE COUNT OF THE OVERDUE TASKS OF THE LAST 30 DAYS SECTION IS NOT DISPLAYED CORRECTLY.");
				test.log(LogStatus.INFO,
						"THE COUNT OF THE OVERDUE TASKS OF THE LAST 30 DAYS SECTION IS NOT DISPLAYED CORRECTLY.");
				Reporter.log("THE COUNT OF THE OVERDUE TASKS OF THE LAST 30 DAYS SECTION IS NOT DISPLAYED CORRECTLY.");
				log.info("THE COUNT OF THE OVERDUE TASKS OF THE LAST 30 DAYS SECTION IS NOT DISPLAYED CORRECTLY.");
			}

			try {
				// verify count of the total tasks
				String pastDate = (driver
						.findElement(By.xpath(OR.getProperty("ssc_riskmanagement_recommendations_record2_XPATH")))
						.getText()).trim();
				int pastDateInt = Integer.parseInt(pastDate);

				if (pastDateInt == taskCount1) {
					System.out.println(
							"THE COUNT OF THE TOTAL TASKS OF THE LAST 30 DAYS SECTION IS DISPLAYED CORRECTLY.");
					test.log(LogStatus.INFO,
							"THE COUNT OF THE TOTAL TASKS OF THE LAST 30 DAYS SECTION IS DISPLAYED CORRECTLY.");
					Reporter.log("THE COUNT OF THE TOTAL TASKS OF THE LAST 30 DAYS SECTION IS DISPLAYED CORRECTLY.");
					log.info("THE COUNT OF THE TOTAL TASKS OF THE LAST 30 DAYS SECTION IS DISPLAYED CORRECTLY.");
				} else {

					verificationFailed();

					System.out.println(
							"THE COUNT OF THE TOTAL TASKS OF THE LAST 30 DAYS SECTION IS NOT DISPLAYED CORRECTLY.");
					test.log(LogStatus.INFO,
							"THE COUNT OF THE TOTAL TASKS OF THE LAST 30 DAYS SECTION IS NOT DISPLAYED CORRECTLY.");
					Reporter.log(
							"THE COUNT OF THE TOTAL TASKS OF THE LAST 30 DAYS SECTION IS NOT DISPLAYED CORRECTLY.");
					log.info("THE COUNT OF THE TOTAL TASKS OF THE LAST 30 DAYS SECTION IS NOT DISPLAYED CORRECTLY.");
				}

			} catch (Throwable t) {
				verificationFailed();

				System.out.println(
						"THE COUNT OF THE TOTAL TASKS OF THE LAST 30 DAYS SECTION IS NOT DISPLAYED CORRECTLY.");
				test.log(LogStatus.INFO,
						"THE COUNT OF THE TOTAL TASKS OF THE LAST 30 DAYS SECTION IS NOT DISPLAYED CORRECTLY.");
				Reporter.log("THE COUNT OF THE TOTAL TASKS OF THE LAST 30 DAYS SECTION IS NOT DISPLAYED CORRECTLY.");
				log.info("THE COUNT OF THE TOTAL TASKS OF THE LAST 30 DAYS SECTION IS NOT DISPLAYED CORRECTLY.");
			}

			// scroll up the screen
			js.executeScript("window.scrollTo(0,0)");

			// select the hours option from the drop down
			select("ssc_riskmanagement_recommendations_taskfrequency_XPATH", data.get("task_frequency"));
			ngDriver.waitForAngularRequestsToFinish();
			System.out.println("Selected the hours option from the drop down.");

			// scroll down till bottom of the screen
			js.executeScript("window.scrollTo(0, document.body.scrollHeight)");

			try {
				// verify count of the overdue tasks
				String pastDate = (driver
						.findElement(By.xpath(OR.getProperty("ssc_riskmanagement_recommendations_record1_XPATH")))
						.getText()).trim();
				int pastDateInt = Integer.parseInt(pastDate);

				if (pastDateInt == 0) {
					System.out.println(
							"THE COUNT OF THE OVERDUE TASKS OF THE LAST 30 DAYS SECTION IS DISPLAYED CORRECTLY.");
					test.log(LogStatus.INFO,
							"THE COUNT OF THE OVERDUE TASKS OF THE LAST 30 DAYS SECTION IS DISPLAYED CORRECTLY.");
					Reporter.log("THE COUNT OF THE OVERDUE TASKS OF THE LAST 30 DAYS SECTION IS DISPLAYED CORRECTLY.");
					log.info("THE COUNT OF THE OVERDUE TASKS OF THE LAST 30 DAYS SECTION IS DISPLAYED CORRECTLY.");
				} else {

					verificationFailed();

					System.out.println(
							"THE COUNT OF THE OVERDUE TASKS OF THE LAST 30 DAYS SECTION IS NOT DISPLAYED CORRECTLY.");
					test.log(LogStatus.INFO,
							"THE COUNT OF THE OVERDUE TASKS OF THE LAST 30 DAYS SECTION IS NOT DISPLAYED CORRECTLY.");
					Reporter.log(
							"THE COUNT OF THE OVERDUE TASKS OF THE LAST 30 DAYS SECTION IS NOT DISPLAYED CORRECTLY.");
					log.info("THE COUNT OF THE OVERDUE TASKS OF THE LAST 30 DAYS SECTION IS NOT DISPLAYED CORRECTLY.");
				}

			} catch (Throwable t) {
				verificationFailed();

				System.out.println(
						"THE COUNT OF THE OVERDUE TASKS OF THE LAST 30 DAYS SECTION IS NOT DISPLAYED CORRECTLY.");
				test.log(LogStatus.INFO,
						"THE COUNT OF THE OVERDUE TASKS OF THE LAST 30 DAYS SECTION IS NOT DISPLAYED CORRECTLY.");
				Reporter.log("THE COUNT OF THE OVERDUE TASKS OF THE LAST 30 DAYS SECTION IS NOT DISPLAYED CORRECTLY.");
				log.info("THE COUNT OF THE OVERDUE TASKS OF THE LAST 30 DAYS SECTION IS NOT DISPLAYED CORRECTLY.");
			}

			try {
				// verify count of the total tasks
				String pastDate = (driver
						.findElement(By.xpath(OR.getProperty("ssc_riskmanagement_recommendations_record2_XPATH")))
						.getText()).trim();
				int pastDateInt = Integer.parseInt(pastDate);

				if (pastDateInt == 0) {
					System.out.println(
							"THE COUNT OF THE TOTAL TASKS OF THE LAST 30 DAYS SECTION IS DISPLAYED CORRECTLY.");
					test.log(LogStatus.INFO,
							"THE COUNT OF THE TOTAL TASKS OF THE LAST 30 DAYS SECTION IS DISPLAYED CORRECTLY.");
					Reporter.log("THE COUNT OF THE TOTAL TASKS OF THE LAST 30 DAYS SECTION IS DISPLAYED CORRECTLY.");
					log.info("THE COUNT OF THE TOTAL TASKS OF THE LAST 30 DAYS SECTION IS DISPLAYED CORRECTLY.");
				} else {

					verificationFailed();

					System.out.println(
							"THE COUNT OF THE TOTAL TASKS OF THE LAST 30 DAYS SECTION IS NOT DISPLAYED CORRECTLY.");
					test.log(LogStatus.INFO,
							"THE COUNT OF THE TOTAL TASKS OF THE LAST 30 DAYS SECTION IS NOT DISPLAYED CORRECTLY.");
					Reporter.log(
							"THE COUNT OF THE TOTAL TASKS OF THE LAST 30 DAYS SECTION IS NOT DISPLAYED CORRECTLY.");
					log.info("THE COUNT OF THE TOTAL TASKS OF THE LAST 30 DAYS SECTION IS NOT DISPLAYED CORRECTLY.");
				}

			} catch (Throwable t) {
				verificationFailed();

				System.out.println(
						"THE COUNT OF THE TOTAL TASKS OF THE LAST 30 DAYS SECTION IS NOT DISPLAYED CORRECTLY.");
				test.log(LogStatus.INFO,
						"THE COUNT OF THE TOTAL TASKS OF THE LAST 30 DAYS SECTION IS NOT DISPLAYED CORRECTLY.");
				Reporter.log("THE COUNT OF THE TOTAL TASKS OF THE LAST 30 DAYS SECTION IS NOT DISPLAYED CORRECTLY.");
				log.info("THE COUNT OF THE TOTAL TASKS OF THE LAST 30 DAYS SECTION IS NOT DISPLAYED CORRECTLY.");
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

		// CREATE RANDOM NUMBER OF RECOMMENDATION TASKS WITH NEWLY CREATED
		// RECOMMENDATION TEMPLATE AND 31 TO 90 DAYS PASTE

		System.out.println(
				"******************** CREATE RANDOM NUMBER OF RECOMMENDATION TASKS WITH NEWLY CREATED RECOMMENDATION TEMPLATE AND 31 TO 90 DAYS PASTE ********************");
		test.log(LogStatus.INFO,
				"******************** CREATE RANDOM NUMBER OF RECOMMENDATION TASKS WITH NEWLY CREATED RECOMMENDATION TEMPLATE AND 31 TO 90 DAYS PASTE ********************");
		Reporter.log(
				"******************** CREATE RANDOM NUMBER OF RECOMMENDATION TASKS WITH NEWLY CREATED RECOMMENDATION TEMPLATE AND 31 TO 90 DAYS PASTE ********************");
		log.info(
				"******************** CREATE RANDOM NUMBER OF RECOMMENDATION TASKS WITH NEWLY CREATED RECOMMENDATION TEMPLATE AND 31 TO 90 DAYS PASTE ********************");

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

			for (int i = 1; i <= taskCount2; i++) {

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

				// enter the 2 months past date in the due date
				LocalDate currentDate = LocalDate.now();
				LocalDate morepastDate = currentDate.minusMonths(2);
				String expectedMorePastDate = morepastDate.toString();
				System.out.println("//////////////////////////////// EXPECTED MORE PAST DATE" + expectedMorePastDate);

				type("riskmanagement_addtaskbtn_duedatetxt_XPATH", expectedMorePastDate);
				ngDriver.waitForAngularRequestsToFinish();
				System.out.println("Entered the 2 months past date in the due date.");

				// click on the save button
				click("riskmanagement_addtaskbtn_savebtn_CSS");
				ngDriver.waitForAngularRequestsToFinish();
				System.out.println("Clicked on the save button.");

				// wait for the element
				Thread.sleep(5000);

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

		// VERIFY NEWLY CREATED TASK COUNT IS DISPLAYED IN THE BETWEEN 31 TO 90 DAYS DUE
		// DATE SECTION ON THE RECOMMENDATION SUMMARY DASHBOARD

		System.out.println(
				"******************** VERIFY NEWLY CREATED TASK COUNT IS DISPLAYED IN THE BETWEEN 31 TO 90 DAYS DUE DATE SECTION ON THE RECOMMENDATION SUMMARY DASHBOARD ********************");
		test.log(LogStatus.INFO,
				"******************** VERIFY NEWLY CREATED TASK COUNT IS DISPLAYED IN THE BETWEEN 31 TO 90 DAYS DUE DATE SECTION ON THE RECOMMENDATION SUMMARY DASHBOARD ********************");
		Reporter.log(
				"******************** VERIFY NEWLY CREATED TASK COUNT IS DISPLAYED IN THE BETWEEN 31 TO 90 DAYS DUE DATE SECTION ON THE RECOMMENDATION SUMMARY DASHBOARD ********************");
		log.info(
				"******************** VERIFY NEWLY CREATED TASK COUNT IS DISPLAYED IN THE BETWEEN 31 TO 90 DAYS DUE DATE SECTION ON THE RECOMMENDATION SUMMARY DASHBOARD ********************");

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

			try {
				// verify count of the overdue tasks
				String morePastDate = (driver
						.findElement(By.xpath(OR.getProperty("ssc_riskmanagement_recommendations_record3_XPATH")))
						.getText()).trim();
				int morePastDateInt = Integer.parseInt(morePastDate);

				if (morePastDateInt == taskCount2) {
					System.out.println(
							"THE COUNT OF THE OVERDUE TASKS OF THE BETWEEN 31 TO 90 DAYS DAYS SECTION IS DISPLAYED CORRECTLY.");
					test.log(LogStatus.INFO,
							"THE COUNT OF THE OVERDUE TASKS OF THE BETWEEN 31 TO 90 DAYS DAYS SECTION IS DISPLAYED CORRECTLY.");
					Reporter.log(
							"THE COUNT OF THE OVERDUE TASKS OF THE BETWEEN 31 TO 90 DAYS DAYS SECTION IS DISPLAYED CORRECTLY.");
					log.info(
							"THE COUNT OF THE OVERDUE TASKS OF THE BETWEEN 31 TO 90 DAYS DAYS SECTION IS DISPLAYED CORRECTLY.");
				} else {

					verificationFailed();

					System.out.println(
							"THE COUNT OF THE OVERDUE TASKS OF THE BETWEEN 31 TO 90 DAYS DAYS SECTION IS NOT DISPLAYED CORRECTLY.");
					test.log(LogStatus.INFO,
							"THE COUNT OF THE OVERDUE TASKS OF THE BETWEEN 31 TO 90 DAYS DAYS SECTION IS NOT DISPLAYED CORRECTLY.");
					Reporter.log(
							"THE COUNT OF THE OVERDUE TASKS OF THE BETWEEN 31 TO 90 DAYS DAYS SECTION IS NOT DISPLAYED CORRECTLY.");
					log.info(
							"THE COUNT OF THE OVERDUE TASKS OF THE BETWEEN 31 TO 90 DAYS DAYS SECTION IS NOT DISPLAYED CORRECTLY.");
				}

			} catch (Throwable t) {
				verificationFailed();

				System.out.println(
						"THE COUNT OF THE OVERDUE TASKS OF THE BETWEEN 31 TO 90 DAYS DAYS SECTION IS NOT DISPLAYED CORRECTLY.");
				test.log(LogStatus.INFO,
						"THE COUNT OF THE OVERDUE TASKS OF THE BETWEEN 31 TO 90 DAYS DAYS SECTION IS NOT DISPLAYED CORRECTLY.");
				Reporter.log(
						"THE COUNT OF THE OVERDUE TASKS OF THE BETWEEN 31 TO 90 DAYS DAYS SECTION IS NOT DISPLAYED CORRECTLY.");
				log.info(
						"THE COUNT OF THE OVERDUE TASKS OF THE BETWEEN 31 TO 90 DAYS DAYS SECTION IS NOT DISPLAYED CORRECTLY.");
			}

			try {
				// verify count of the total tasks
				String morePastDate = (driver
						.findElement(By.xpath(OR.getProperty("ssc_riskmanagement_recommendations_record4_XPATH")))
						.getText()).trim();
				int morePastDateInt = Integer.parseInt(morePastDate);

				if (morePastDateInt == taskCount2) {
					System.out.println(
							"THE COUNT OF THE TOTAL TASKS OF THE BETWEEN 31 TO 90 DAYS SECTION IS DISPLAYED CORRECTLY.");
					test.log(LogStatus.INFO,
							"THE COUNT OF THE TOTAL TASKS OF THE BETWEEN 31 TO 90 DAYS SECTION IS DISPLAYED CORRECTLY.");
					Reporter.log(
							"THE COUNT OF THE TOTAL TASKS OF THE BETWEEN 31 TO 90 DAYS SECTION IS DISPLAYED CORRECTLY.");
					log.info(
							"THE COUNT OF THE TOTAL TASKS OF THE BETWEEN 31 TO 90 DAYS SECTION IS DISPLAYED CORRECTLY.");
				} else {

					verificationFailed();

					System.out.println(
							"THE COUNT OF THE TOTAL TASKS OF THE BETWEEN 31 TO 90 DAYS SECTION IS NOT DISPLAYED CORRECTLY.");
					test.log(LogStatus.INFO,
							"THE COUNT OF THE TOTAL TASKS OF THE BETWEEN 31 TO 90 DAYS SECTION IS NOT DISPLAYED CORRECTLY.");
					Reporter.log(
							"THE COUNT OF THE TOTAL TASKS OF THE BETWEEN 31 TO 90 DAYS SECTION IS NOT DISPLAYED CORRECTLY.");
					log.info(
							"THE COUNT OF THE TOTAL TASKS OF THE BETWEEN 31 TO 90 DAYS SECTION IS NOT DISPLAYED CORRECTLY.");
				}

			} catch (Throwable t) {
				verificationFailed();

				System.out.println(
						"THE COUNT OF THE TOTAL TASKS OF THE BETWEEN 31 TO 90 DAYS SECTION IS NOT DISPLAYED CORRECTLY.");
				test.log(LogStatus.INFO,
						"THE COUNT OF THE TOTAL TASKS OF THE BETWEEN 31 TO 90 DAYS SECTION IS NOT DISPLAYED CORRECTLY.");
				Reporter.log(
						"THE COUNT OF THE TOTAL TASKS OF THE BETWEEN 31 TO 90 DAYS SECTION IS NOT DISPLAYED CORRECTLY.");
				log.info(
						"THE COUNT OF THE TOTAL TASKS OF THE BETWEEN 31 TO 90 DAYS SECTION IS NOT DISPLAYED CORRECTLY.");
			}

			// scroll up the screen
			js.executeScript("window.scrollTo(0,0)");

			// select the hours option from the drop down
			select("ssc_riskmanagement_recommendations_taskfrequency_XPATH", data.get("task_frequency"));
			ngDriver.waitForAngularRequestsToFinish();
			System.out.println("Selected the hours option from the drop down.");

			// scroll down till bottom of the screen
			js.executeScript("window.scrollTo(0, document.body.scrollHeight)");

			try {
				// verify count of the overdue tasks
				String morePastDate = (driver
						.findElement(By.xpath(OR.getProperty("ssc_riskmanagement_recommendations_record3_XPATH")))
						.getText()).trim();
				int morePastDateInt = Integer.parseInt(morePastDate);

				if (morePastDateInt == 0) {
					System.out.println(
							"THE COUNT OF THE OVERDUE TASKS OF THE BETWEEN 31 TO 90 DAYS SECTION IS DISPLAYED CORRECTLY.");
					test.log(LogStatus.INFO,
							"THE COUNT OF THE OVERDUE TASKS OF THE BETWEEN 31 TO 90 DAYS SECTION IS DISPLAYED CORRECTLY.");
					Reporter.log(
							"THE COUNT OF THE OVERDUE TASKS OF THE BETWEEN 31 TO 90 DAYS SECTION IS DISPLAYED CORRECTLY.");
					log.info(
							"THE COUNT OF THE OVERDUE TASKS OF THE BETWEEN 31 TO 90 DAYS SECTION IS DISPLAYED CORRECTLY.");
				} else {

					verificationFailed();

					System.out.println(
							"THE COUNT OF THE OVERDUE TASKS OF THE BETWEEN 31 TO 90 DAYS SECTION IS NOT DISPLAYED CORRECTLY.");
					test.log(LogStatus.INFO,
							"THE COUNT OF THE OVERDUE TASKS OF THE BETWEEN 31 TO 90 DAYS SECTION IS NOT DISPLAYED CORRECTLY.");
					Reporter.log(
							"THE COUNT OF THE OVERDUE TASKS OF THE BETWEEN 31 TO 90 DAYS SECTION IS NOT DISPLAYED CORRECTLY.");
					log.info(
							"THE COUNT OF THE OVERDUE TASKS OF THE BETWEEN 31 TO 90 DAYS SECTION IS NOT DISPLAYED CORRECTLY.");
				}

			} catch (Throwable t) {
				verificationFailed();

				System.out.println(
						"THE COUNT OF THE OVERDUE TASKS OF THE BETWEEN 31 TO 90 DAYS SECTION IS NOT DISPLAYED CORRECTLY.");
				test.log(LogStatus.INFO,
						"THE COUNT OF THE OVERDUE TASKS OF THE BETWEEN 31 TO 90 DAYS SECTION IS NOT DISPLAYED CORRECTLY.");
				Reporter.log(
						"THE COUNT OF THE OVERDUE TASKS OF THE BETWEEN 31 TO 90 DAYS SECTION IS NOT DISPLAYED CORRECTLY.");
				log.info(
						"THE COUNT OF THE OVERDUE TASKS OF THE BETWEEN 31 TO 90 DAYS SECTION IS NOT DISPLAYED CORRECTLY.");
			}

			try {
				// verify count of the total tasks
				String morePastDate = (driver
						.findElement(By.xpath(OR.getProperty("ssc_riskmanagement_recommendations_record4_XPATH")))
						.getText()).trim();
				int morePastDateInt = Integer.parseInt(morePastDate);

				if (morePastDateInt == 0) {
					System.out.println(
							"THE COUNT OF THE TOTAL TASKS OF THE BETWEEN 31 TO 90 DAYS SECTION IS DISPLAYED CORRECTLY.");
					test.log(LogStatus.INFO,
							"THE COUNT OF THE TOTAL TASKS OF THE BETWEEN 31 TO 90 DAYS SECTION IS DISPLAYED CORRECTLY.");
					Reporter.log(
							"THE COUNT OF THE TOTAL TASKS OF THE BETWEEN 31 TO 90 DAYS SECTION IS DISPLAYED CORRECTLY.");
					log.info(
							"THE COUNT OF THE TOTAL TASKS OF THE BETWEEN 31 TO 90 DAYS SECTION IS DISPLAYED CORRECTLY.");
				} else {

					verificationFailed();

					System.out.println(
							"THE COUNT OF THE TOTAL TASKS OF THE BETWEEN 31 TO 90 DAYS SECTION IS NOT DISPLAYED CORRECTLY.");
					test.log(LogStatus.INFO,
							"THE COUNT OF THE TOTAL TASKS OF THE BETWEEN 31 TO 90 DAYS SECTION IS NOT DISPLAYED CORRECTLY.");
					Reporter.log(
							"THE COUNT OF THE TOTAL TASKS OF THE BETWEEN 31 TO 90 DAYS SECTION IS NOT DISPLAYED CORRECTLY.");
					log.info(
							"THE COUNT OF THE TOTAL TASKS OF THE BETWEEN 31 TO 90 DAYS SECTION IS NOT DISPLAYED CORRECTLY.");
				}

			} catch (Throwable t) {
				verificationFailed();

				System.out.println(
						"THE COUNT OF THE TOTAL TASKS OF THE LAST 30 DAYS SECTION IS NOT DISPLAYED CORRECTLY.");
				test.log(LogStatus.INFO,
						"THE COUNT OF THE TOTAL TASKS OF THE LAST 30 DAYS SECTION IS NOT DISPLAYED CORRECTLY.");
				Reporter.log("THE COUNT OF THE TOTAL TASKS OF THE LAST 30 DAYS SECTION IS NOT DISPLAYED CORRECTLY.");
				log.info("THE COUNT OF THE TOTAL TASKS OF THE LAST 30 DAYS SECTION IS NOT DISPLAYED CORRECTLY.");
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

		// DELETE THE ALL NEWLY CREATED RECOMMENDATIONS TASK - BETWEEN 31 TO 90 DAYS
		// PAST DATE

		System.out.println(
				"******************** DELETE THE ALL NEWLY CREATED RECOMMENDATIONS TASK - BETWEEN 31 TO 90 DAYS PAST DATE ********************");
		test.log(LogStatus.INFO,
				"******************** DELETE THE ALL NEWLY CREATED RECOMMENDATIONS TASK - BETWEEN 31 TO 90 DAYS PAST DATE ********************");
		Reporter.log(
				"******************** DELETE THE ALL NEWLY CREATED RECOMMENDATIONS TASK - BETWEEN 31 TO 90 DAYS PAST DATE ********************");
		log.info(
				"******************** DELETE THE ALL NEWLY CREATED RECOMMENDATIONS TASK - BETWEEN 31 TO 90 DAYS PAST DATE ********************");

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

			List<WebElement> recommendationList2 = driver
					.findElements(By.xpath(OR.getProperty("riskmanagement_recommendationtasklist_XPATH")));
			int recommendationCount2 = recommendationList2.size();

			System.out.println("recommendation Task Count :::::::::::::" + recommendationCount2);

			for (int j = 0; j < recommendationCount2; j++) {

				List<WebElement> recommendationList12 = driver
						.findElements(By.xpath(OR.getProperty("riskmanagement_recommendationtasklist_XPATH")));
				int recommendationCount12 = recommendationList12.size();
				System.out.println("recommendation Task Count :::::::::::::" + recommendationCount12);

				// click on the newly created recommendation task
				Random r = new Random();
				recommendationList12.get(r.nextInt(recommendationCount12)).click();
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

		// CREATE RANDOM NUMBER OF RECOMMENDATION TASKS WITH NEWLY CREATED
		// RECOMMENDATION TEMPLATE AND MORE THAN 90 DAYS PASTE

		System.out.println(
				"******************** CREATE RANDOM NUMBER OF RECOMMENDATION TASKS WITH NEWLY CREATED RECOMMENDATION TEMPLATE AND MORE THAN 90 DAYS PASTE ********************");
		test.log(LogStatus.INFO,
				"******************** CREATE RANDOM NUMBER OF RECOMMENDATION TASKS WITH NEWLY CREATED RECOMMENDATION TEMPLATE AND MORE THAN 90 DAYS PASTE ********************");
		Reporter.log(
				"******************** CREATE RANDOM NUMBER OF RECOMMENDATION TASKS WITH NEWLY CREATED RECOMMENDATION TEMPLATE AND MORE THAN 90 DAYS PASTE ********************");
		log.info(
				"******************** CREATE RANDOM NUMBER OF RECOMMENDATION TASKS WITH NEWLY CREATED RECOMMENDATION TEMPLATE AND MORE THAN 90 DAYS PASTE ********************");

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

			for (int i = 1; i <= taskCount3; i++) {

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

				// enter the 5 months past date in the due date
				LocalDate currentDate = LocalDate.now();
				LocalDate mostPastDate = currentDate.minusMonths(5);
				String expectedMostPastDate = mostPastDate.toString();
				System.out.println("//////////////////////////////// EXPECTED MORE PAST DATE" + expectedMostPastDate);

				type("riskmanagement_addtaskbtn_duedatetxt_XPATH", expectedMostPastDate);
				ngDriver.waitForAngularRequestsToFinish();
				System.out.println("Entered the 5 months past date in the due date.");

				// click on the save button
				click("riskmanagement_addtaskbtn_savebtn_CSS");
				ngDriver.waitForAngularRequestsToFinish();
				System.out.println("Clicked on the save button.");

				// wait for the element
				Thread.sleep(5000);

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

		// VERIFY NEWLY CREATED TASK COUNT IS DISPLAYED IN THE MORE THAN 90 DAYS DUE
		// DATE SECTION ON THE RECOMMENDATION SUMMARY DASHBOARD

		System.out.println(
				"******************** VERIFY NEWLY CREATED TASK COUNT IS DISPLAYED IN THE MORE THAN 90 DAYS DUE DATE SECTION ON THE RECOMMENDATION SUMMARY DASHBOARD ********************");
		test.log(LogStatus.INFO,
				"******************** VERIFY NEWLY CREATED TASK COUNT IS DISPLAYED IN THE MORE THAN 90 DAYS DUE DATE SECTION ON THE RECOMMENDATION SUMMARY DASHBOARD ********************");
		Reporter.log(
				"******************** VERIFY NEWLY CREATED TASK COUNT IS DISPLAYED IN THE MORE THAN 90 DAYS DUE DATE SECTION ON THE RECOMMENDATION SUMMARY DASHBOARD ********************");
		log.info(
				"******************** VERIFY NEWLY CREATED TASK COUNT IS DISPLAYED IN THE MORE THAN 90 DAYS DUE DATE SECTION ON THE RECOMMENDATION SUMMARY DASHBOARD ********************");

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

			try {
				// verify count of the overdue tasks
				String mostPastDate = (driver
						.findElement(By.xpath(OR.getProperty("ssc_riskmanagement_recommendations_record5_XPATH")))
						.getText()).trim();
				int mostPastDateInt = Integer.parseInt(mostPastDate);

				if (mostPastDateInt == taskCount3) {
					System.out.println(
							"THE COUNT OF THE OVERDUE TASKS OF THE MORE THAN 90 DAYS DAYS SECTION IS DISPLAYED CORRECTLY.");
					test.log(LogStatus.INFO,
							"THE COUNT OF THE OVERDUE TASKS OF THE MORE THAN 90 DAYS DAYS SECTION IS DISPLAYED CORRECTLY.");
					Reporter.log(
							"THE COUNT OF THE OVERDUE TASKS OF THE MORE THAN 90 DAYS DAYS SECTION IS DISPLAYED CORRECTLY.");
					log.info(
							"THE COUNT OF THE OVERDUE TASKS OF THE MORE THAN 90 DAYS DAYS SECTION IS DISPLAYED CORRECTLY.");
				} else {

					verificationFailed();

					System.out.println(
							"THE COUNT OF THE OVERDUE TASKS OF THE MORE THAN 90 DAYS DAYS SECTION IS NOT DISPLAYED CORRECTLY.");
					test.log(LogStatus.INFO,
							"THE COUNT OF THE OVERDUE TASKS OF THE MORE THAN 90 DAYS DAYS SECTION IS NOT DISPLAYED CORRECTLY.");
					Reporter.log(
							"THE COUNT OF THE OVERDUE TASKS OF THE MORE THAN 90 DAYS DAYS SECTION IS NOT DISPLAYED CORRECTLY.");
					log.info(
							"THE COUNT OF THE OVERDUE TASKS OF THE MORE THAN 90 DAYS DAYS SECTION IS NOT DISPLAYED CORRECTLY.");
				}

			} catch (Throwable t) {
				verificationFailed();

				System.out.println(
						"THE COUNT OF THE OVERDUE TASKS OF THE MORE THAN 90 DAYS DAYS SECTION IS NOT DISPLAYED CORRECTLY.");
				test.log(LogStatus.INFO,
						"THE COUNT OF THE OVERDUE TASKS OF THE MORE THAN 90 DAYS DAYS SECTION IS NOT DISPLAYED CORRECTLY.");
				Reporter.log(
						"THE COUNT OF THE OVERDUE TASKS OF THE MORE THAN 90 DAYS DAYS SECTION IS NOT DISPLAYED CORRECTLY.");
				log.info(
						"THE COUNT OF THE OVERDUE TASKS OF THE MORE THAN 90 DAYS DAYS SECTION IS NOT DISPLAYED CORRECTLY.");
			}

			// scroll up the screen
			js.executeScript("window.scrollTo(0,0)");

			// select the hours option from the drop down
			select("ssc_riskmanagement_recommendations_taskfrequency_XPATH", data.get("task_frequency"));
			ngDriver.waitForAngularRequestsToFinish();
			System.out.println("Selected the hours option from the drop down.");

			// scroll down till bottom of the screen
			js.executeScript("window.scrollTo(0, document.body.scrollHeight)");

			try {
				// verify count of the overdue tasks
				String mostPastDate = (driver
						.findElement(By.xpath(OR.getProperty("ssc_riskmanagement_recommendations_record5_XPATH")))
						.getText()).trim();
				int mostPastDateInt = Integer.parseInt(mostPastDate);

				if (mostPastDateInt == 0) {
					System.out.println(
							"THE COUNT OF THE OVERDUE TASKS OF THE MORE THAN 90 DAYS SECTION IS DISPLAYED CORRECTLY.");
					test.log(LogStatus.INFO,
							"THE COUNT OF THE OVERDUE TASKS OF THE MORE THAN 90 DAYS SECTION IS DISPLAYED CORRECTLY.");
					Reporter.log(
							"THE COUNT OF THE OVERDUE TASKS OF THE MORE THAN 90 DAYS SECTION IS DISPLAYED CORRECTLY.");
					log.info("THE COUNT OF THE OVERDUE TASKS OF THE MORE THAN 90 DAYS SECTION IS DISPLAYED CORRECTLY.");
				} else {

					verificationFailed();

					System.out.println(
							"THE COUNT OF THE OVERDUE TASKS OF THE MORE THAN 90 DAYS SECTION IS NOT DISPLAYED CORRECTLY.");
					test.log(LogStatus.INFO,
							"THE COUNT OF THE OVERDUE TASKS OF THE MORE THAN 90 DAYS SECTION IS NOT DISPLAYED CORRECTLY.");
					Reporter.log(
							"THE COUNT OF THE OVERDUE TASKS OF THE MORE THAN 90 DAYS SECTION IS NOT DISPLAYED CORRECTLY.");
					log.info(
							"THE COUNT OF THE OVERDUE TASKS OF THE MORE THAN 90 DAYS SECTION IS NOT DISPLAYED CORRECTLY.");
				}

			} catch (Throwable t) {
				verificationFailed();

				System.out.println(
						"THE COUNT OF THE OVERDUE TASKS OF THE MORE THAN 90 DAYS SECTION IS NOT DISPLAYED CORRECTLY.");
				test.log(LogStatus.INFO,
						"THE COUNT OF THE OVERDUE TASKS OF THE MORE THAN 90 DAYS SECTION IS NOT DISPLAYED CORRECTLY.");
				Reporter.log(
						"THE COUNT OF THE OVERDUE TASKS OF THE MORE THAN 90 DAYS SECTION IS NOT DISPLAYED CORRECTLY.");
				log.info("THE COUNT OF THE OVERDUE TASKS OF THE MORE THAN 90 DAYS SECTION IS NOT DISPLAYED CORRECTLY.");
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

		// DELETE THE ALL NEWLY CREATED RECOMMENDATIONS TASK - MORE THAN 90 PAST DAYS

		System.out.println(
				"******************** DELETE THE ALL NEWLY CREATED RECOMMENDATIONS TASK - MORE THAN 90 PAST DAYS ********************");
		test.log(LogStatus.INFO,
				"******************** DELETE THE ALL NEWLY CREATED RECOMMENDATIONS TASK - MORE THAN 90 PAST DAYS ********************");
		Reporter.log(
				"******************** DELETE THE ALL NEWLY CREATED RECOMMENDATIONS TASK - MORE THAN 90 PAST DAYS ********************");
		log.info(
				"******************** DELETE THE ALL NEWLY CREATED RECOMMENDATIONS TASK - MORE THAN 90 PAST DAYS ********************");

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

			List<WebElement> recommendationList3 = driver
					.findElements(By.xpath(OR.getProperty("riskmanagement_recommendationtasklist_XPATH")));
			int recommendationCount3 = recommendationList3.size();

			System.out.println("recommendation Task Count :::::::::::::" + recommendationCount3);

			for (int j = 0; j < recommendationCount3; j++) {

				List<WebElement> recommendationList13 = driver
						.findElements(By.xpath(OR.getProperty("riskmanagement_recommendationtasklist_XPATH")));
				int recommendationCount13 = recommendationList13.size();
				System.out.println("recommendation Task Count :::::::::::::" + recommendationCount13);

				// click on the newly created recommendation task
				Random r = new Random();
				recommendationList13.get(r.nextInt(recommendationCount13)).click();
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
		// wait for the element
//					Thread.sleep(5000);

//			// click on the side menu
//			click("ssc_leftsidemenubtn_CSS");
//			ngDriver.waitForAngularRequestsToFinish();
//			System.out.println("Clicked on the side menu.");
//
//			// wait for the element
//					Thread.sleep(5000);
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
