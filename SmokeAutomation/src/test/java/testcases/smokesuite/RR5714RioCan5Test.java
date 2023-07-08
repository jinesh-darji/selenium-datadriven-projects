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

		if (!(TestUtil.isTestRunnable("rR5714RioCan5Test", excel))) {

			throw new SkipException("Skipping the test " + "rR5714RioCan5Test".toUpperCase() + "as the Run mode is NO");
		}

		if (!data.get("runmode").equals("Y")) {

			throw new SkipException("Skipping the test case as the Run Mode for data set is NO");
		}

		// OPEN RECURRENCE TASKS - UPDATE ITS DUE DATE WITH REASON - CLOSE THE TASK

		System.out.println(
				"******************** OPEN RECURRENCE TASKS - UPDATE ITS DUE DATE WITH REASON - CLOSE THE TASK ********************");
		test.log(LogStatus.INFO,
				"******************** OPEN RECURRENCE TASKS - UPDATE ITS DUE DATE WITH REASON - CLOSE THE TASK ********************");
		Reporter.log(
				"******************** OPEN RECURRENCE TASKS - UPDATE ITS DUE DATE WITH REASON - CLOSE THE TASK ********************");
		log.info(
				"******************** OPEN RECURRENCE TASKS - UPDATE ITS DUE DATE WITH REASON - CLOSE THE TASK ********************");

		String taskType = RandomStringUtils.randomAlphabetic(12);

		System.out.println("TASKTYPE:::::::::::::::::" + taskType);

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

		// CREATE RECOMMENDATION TASKS WITH NEWLY CREATED RECOMMENDATION TEMPLATE

		System.out.println(
				"******************** CREATE RECOMMENDATION TASKS WITH NEWLY CREATED RECOMMENDATION TEMPLATE ********************");
		test.log(LogStatus.INFO,
				"******************** CREATE RECOMMENDATION TASKS WITH NEWLY CREATED RECOMMENDATION TEMPLATE ********************");
		Reporter.log(
				"******************** CREATE RECOMMENDATION TASKS WITH NEWLY CREATED RECOMMENDATION TEMPLATE ********************");
		log.info(
				"******************** CREATE RECOMMENDATION TASKS WITH NEWLY CREATED RECOMMENDATION TEMPLATE ********************");

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

			// enter interval in the frequency interval field
			clear("ssc_riskmanagement_recommendations_taskfrequencyinterval_XPATH");
			type("ssc_riskmanagement_recommendations_taskfrequencyinterval_XPATH", "1");
			ngDriver.waitForAngularRequestsToFinish();
			System.out.println("Entered interval in the frequency interval field.");

			// select year option from the frequency dropdown
			select("ssc_riskmanagement_recommendations_taskfrequency1_XPATH", data.get("task_frequency"));
			ngDriver.waitForAngularRequestsToFinish();
			System.out.println("Selected year option from the frequency dropdown.");

			// wait for the element
			Thread.sleep(3000);

			// enter the 3 days past date in the due date
			LocalDate currentDate = LocalDate.now();
			String expectedCurrentDate = currentDate.toString();
			System.out.println("//////////////////////////////// EXPECTED CURRENT DATE" + expectedCurrentDate);

			clear("riskmanagement_addtaskbtn_duedatetxt_XPATH");
			type("riskmanagement_addtaskbtn_duedatetxt_XPATH", expectedCurrentDate);
			ngDriver.waitForAngularRequestsToFinish();
			System.out.println("Entered the today's date in the due date.");

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

		// UPDATE THE DUE DATE AND VALIDATE NEWLY UPDATED DUE DATE

		System.out.println(
				"******************** UPDATE THE DUE DATE AND VALIDATE NEWLY UPDATED DUE DATE ********************");
		test.log(LogStatus.INFO,
				"******************** UPDATE THE DUE DATE AND VALIDATE NEWLY UPDATED DUE DATE ********************");
		Reporter.log(
				"******************** UPDATE THE DUE DATE AND VALIDATE NEWLY UPDATED DUE DATE ********************");
		log.info("******************** UPDATE THE DUE DATE AND VALIDATE NEWLY UPDATED DUE DATE ********************");

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

			// click on the newly created task
			String newTask = "//td[text()='" + taskType + "']";
			driver.findElement(By.xpath(newTask)).click();
			ngDriver.waitForAngularRequestsToFinish();
			System.out.println("Clicked on the newly created task.");

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

			// enter newly created recommendation task in search field
			clear("riskmanagement_task_searchtxt_XPATH");
			type("riskmanagement_task_searchtxt_XPATH", taskType);
			ngDriver.waitForAngularRequestsToFinish();
			System.out.println("Entered newly created recommendation task in search field.");

			try {
				// verify updated data is displayed correctly or not
				String updatedDetails = "//td[text()='" + taskType + "']//following-sibling::td[text()='"
						+ expectedPastDate1 + "']";

				String str2 = (driver.findElement(By.xpath(updatedDetails)).getText()).trim();
				ngDriver.waitForAngularRequestsToFinish();
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

		// click on the home icon from the top of the screen
		click("questionnaire_homeburgermenubtn_hide_CSS");
		System.out.println("Clicked on the home icon from the top of the screen.");
		ngDriver.waitForAngularRequestsToFinish();

		// synchronization
		explicitWait("propertylist_title_XPATH");

		// verify the property list
		switchVerification("propertylist_title_XPATH", "Property List", "The property list is not displayed.");

		// CLOSE THE NEWLY CREATED TASK

		System.out.println("******************** CLOSE THE NEWLY CREATED TASK ********************");
		test.log(LogStatus.INFO, "******************** CLOSE THE NEWLY CREATED TASK ********************");
		Reporter.log("******************** CLOSE THE NEWLY CREATED TASK ********************");
		log.info("******************** CLOSE THE NEWLY CREATED TASK ********************");

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

			// click on the newly created task
			String newTask = "//td[text()='" + taskType + "']";
			driver.findElement(By.xpath(newTask)).click();
			ngDriver.waitForAngularRequestsToFinish();
			System.out.println("Clicked on the newly created task.");

			// click on the start button
			click("propertyproject_mu_repair_startbtn_CSS");
			ngDriver.waitForAngularRequestsToFinish();
			System.out.println("Clicked on the start button.");

			// scroll down the screen
			WebElement forwhotxt = driver
					.findElement(By.xpath(OR.getProperty("riskmanagement_addtaskbtn_forwhodd_XPATH")));
			JavascriptExecutor js = (JavascriptExecutor) driver;
			js.executeScript("arguments[0].scrollIntoView(true);", forwhotxt);

			// verify updated status is displayed or not
			switchVerification("propertyproject_mu_inprogressstatus_XPATH", "In Progress",
					"The In Progress status is not displayed.");

			// click on the close button
			click("riskmanagement_task_closebtn_XPATH");
			ngDriver.waitForAngularRequestsToFinish();
			System.out.println("Clicked on the close button.");

			// click on the close button of confirmation popup
			click("riskmanagement_task_closebtn_confirmation_XPATH");
			ngDriver.waitForAngularRequestsToFinish();
			System.out.println("Clicked on the close button of confirmation popup.");

			// wait for the validation message
			Thread.sleep(5000);

			// verify the attachment validation message
			switchVerification("riskmanagement_task_attachmentvalidation_XPATH", "No attachments provided",
					"The No attachments provided is not displayed.");

			// click on the close button
			click("riskmanagement_task_attachmentvalidation_closebtn_XPATH");
			ngDriver.waitForAngularRequestsToFinish();
			System.out.println("Clicked on the close button.");

			// wait for the validation message
			Thread.sleep(5000);

			// scroll up the screen
			js.executeScript("window.scrollTo(0,0)");

			// click on the attachment tab
			click("riskmanagement_task_attachmenttab_XPATH");
			ngDriver.waitForAngularRequestsToFinish();
			System.out.println("Clicked on the attachment tab.");

			// click on upload local file button

//			driver.findElement(By.xpath(OR.getProperty("riskmanagement_task_attachmenttab_uploadbtn_XPATH")))
//					.sendKeys("C:\\Users\\Jinesh\\risktestautomation\\Refined_Risk_SmokeAutomation\\src\\test\\resources\\logs\\sample.pdf");

//			click("riskmanagement_task_attachmenttab_uploadbtn_XPATH");
//			ngDriver.waitForAngularRequestsToFinish();
//			System.out.println("Clicked on upload local file button.");

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

			Runtime.getRuntime().exec(System.getProperty("user.dir") + "/src/test/resources/logs/FileUpload.exe");

			// wait for the element
			Thread.sleep(10000);

			// click on the close button
			click("riskmanagement_task_closebtn_XPATH");
			ngDriver.waitForAngularRequestsToFinish();
			System.out.println("Clicked on the close button.");

			// click on the close button of confirmation popup
			click("riskmanagement_task_closebtn_confirmation_XPATH");
			ngDriver.waitForAngularRequestsToFinish();
			System.out.println("Clicked on the close button of confirmation popup.");

			try {
				// verify reopen button is displayed or not
				boolean reopenBTN = driver.findElement(By.xpath(OR.getProperty("riskmanagement_task_reopenbtn_XPATH")))
						.isDisplayed();

				if (reopenBTN == true) {
					System.out.println("THE REOPEN BUTTON IS DISPLAYED SUCCESSFULLY.");
					test.log(LogStatus.INFO, "THE REOPEN BUTTON IS DISPLAYED SUCCESSFULLY.");
					Reporter.log("THE REOPEN BUTTON IS DISPLAYED SUCCESSFULLY.");
					log.info("THE REOPEN BUTTON IS DISPLAYED SUCCESSFULLY.");
				} else {
					verificationFailed();

					System.out.println("THE REOPEN BUTTON IS NOT DISPLAYED.");
					test.log(LogStatus.INFO, "THE REOPEN BUTTON IS NOT DISPLAYED.");
					Reporter.log("THE REOPEN BUTTON IS NOT DISPLAYED.");
					log.info("THE REOPEN BUTTON IS NOT DISPLAYED.");
				}

			} catch (Throwable t) {
				verificationFailed();

				System.out.println("THE REOPEN BUTTON IS NOT DISPLAYED.");
				test.log(LogStatus.INFO, "THE REOPEN BUTTON IS NOT DISPLAYED.");
				Reporter.log("THE REOPEN BUTTON IS NOT DISPLAYED.");
				log.info("THE REOPEN BUTTON IS NOT DISPLAYED.");
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

		// VERIFY NEWLY CREATED RECURRING TASK IN ACTIVE TASK LIST AND REOPEN THE CLOSED
		// TASK

		System.out.println(
				"******************** VERIFY NEWLY CREATED RECURRING TASK IN ACTIVE TASK LIST AND REOPEN THE CLOSED TASK ********************");
		test.log(LogStatus.INFO,
				"******************** VERIFY NEWLY CREATED RECURRING TASK IN ACTIVE TASK LIST AND REOPEN THE CLOSED TASK ********************");
		Reporter.log(
				"******************** VERIFY NEWLY CREATED RECURRING TASK IN ACTIVE TASK LIST AND REOPEN THE CLOSED TASK ********************");
		log.info(
				"******************** VERIFY NEWLY CREATED RECURRING TASK IN ACTIVE TASK LIST AND REOPEN THE CLOSED TASK ********************");

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

			// select active option from the task status drop down
			select("riskmanagement_task_taskstatusdd_XPATH", data.get("task_status_activeoption"));
			ngDriver.waitForAngularRequestsToFinish();
			System.out.println("Selected active option from the task status drop down.");

			// type newly created recurring task
			clear("riskmanagement_task_searchtxt_XPATH");
			type("riskmanagement_task_searchtxt_XPATH", taskType);
			ngDriver.waitForAngularRequestsToFinish();
			System.out.println("Typed newly created recurring task.");

			try {
				// verify newly created recurring task
				LocalDate currentDate1 = LocalDate.now();
				LocalDate futureDate1 = currentDate1.plusYears(1);
				String expectedFutureDate1 = futureDate1.toString();
				System.out.println("//////////////////////////////// EXPECTED FUTURE DATE 1" + expectedFutureDate1);
				String futureTaskDate = "//td[text()='" + taskType + "']//following-sibling::td[text()='"
						+ expectedFutureDate1 + "']";

				boolean recurringTask = driver.findElement(By.xpath(futureTaskDate)).isDisplayed();

				if (recurringTask == true) {
					System.out.println("THE NEWLY CREATED RECURRING TASK IS DISPLAYED SUCCESSFULLY.");
					test.log(LogStatus.INFO, "THE NEWLY CREATED RECURRING TASK IS DISPLAYED SUCCESSFULLY.");
					Reporter.log("THE NEWLY CREATED RECURRING TASK IS DISPLAYED SUCCESSFULLY.");
					log.info("THE NEWLY CREATED RECURRING TASK IS DISPLAYED SUCCESSFULLY.");

				} else {
					verificationFailed();

					System.out.println("THE NEWLY CREATED RECURRING TASK IS NOT DISPLAYED.");
					test.log(LogStatus.INFO, "THE NEWLY CREATED RECURRING TASK IS NOT DISPLAYED.");
					Reporter.log("THE NEWLY CREATED RECURRING TASK IS NOT DISPLAYED.");
					log.info("THE NEWLY CREATED RECURRING TASK IS NOT DISPLAYED.");
				}

			} catch (Throwable t) {
				verificationFailed();

				System.out.println("THE NEWLY CREATED RECURRING TASK IS NOT DISPLAYED.");
				test.log(LogStatus.INFO, "THE NEWLY CREATED RECURRING TASK IS NOT DISPLAYED.");
				Reporter.log("THE NEWLY CREATED RECURRING TASK IS NOT DISPLAYED.");
				log.info("THE NEWLY CREATED RECURRING TASK IS NOT DISPLAYED.");
			}

			// click on the newly recurring task
			String futuretask1 = "//td[text()='" + taskType + "']";
			driver.findElement(By.xpath(futuretask1)).click();
			ngDriver.waitForAngularRequestsToFinish();
			System.out.println("Clicked on the newly recurring task.");

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

			// select closed option from the task status drop down
			select("riskmanagement_task_taskstatusdd_XPATH", data.get("task_status_closedoption"));
			ngDriver.waitForAngularRequestsToFinish();
			System.out.println("Selected closed option from the task status drop down.");

			// type newly created recurring task
			clear("riskmanagement_task_searchtxt_XPATH");
			type("riskmanagement_task_searchtxt_XPATH", taskType);
			ngDriver.waitForAngularRequestsToFinish();
			System.out.println("Typed newly created recurring task.");

			try {
				// enter the past due date in the due date field
				LocalDate currentDate2 = LocalDate.now();
				LocalDate pastDate2 = currentDate2.minusDays(5);
				String expectedPastDate2 = pastDate2.toString();
				System.out.println("//////////////////////////////// EXPECTED PAST DATE 2" + expectedPastDate2);
				String pastTaskDate2 = "//td[text()='" + taskType + "']//following-sibling::td[text()='"
						+ expectedPastDate2 + "']";

				boolean recurringClosedTask = driver.findElement(By.xpath(pastTaskDate2)).isDisplayed();

				if (recurringClosedTask == true) {
					System.out.println("THE NEWLY CREATED RECURRING TASK IS DISPLAYED SUCCESSFULLY.");
					test.log(LogStatus.INFO, "THE NEWLY CREATED RECURRING TASK IS DISPLAYED SUCCESSFULLY.");
					Reporter.log("THE NEWLY CREATED RECURRING TASK IS DISPLAYED SUCCESSFULLY.");
					log.info("THE NEWLY CREATED RECURRING TASK IS DISPLAYED SUCCESSFULLY.");

					// click on the closed task
					driver.findElement(By.xpath(pastTaskDate2)).click();
					ngDriver.waitForAngularRequestsToFinish();
					System.out.println("Clicked on the closed task.");

					// click on the reopen button
					click("riskmanagement_task_reopenbtn_XPATH");
					ngDriver.waitForAngularRequestsToFinish();
					System.out.println("Clicked on the reopen button.");

					// wait for the element
					Thread.sleep(5000);

					// verify approve button
					boolean approveBTN = driver
							.findElement(By.xpath(OR.getProperty("riskmanagement_task_approvebtn_XPATH")))
							.isDisplayed();

					if (approveBTN == true) {
						System.out.println("THE APPROVE BUTTON IS DISPLAYED SUCCESSFULLY.");
						test.log(LogStatus.INFO, "THE APPROVE BUTTON IS DISPLAYED SUCCESSFULLY.");
						Reporter.log("THE APPROVE BUTTON IS DISPLAYED SUCCESSFULLY.");
						log.info("THE APPROVE BUTTON IS DISPLAYED SUCCESSFULLY.");
					}

				} else {
					verificationFailed();

					System.out.println("THE APPROVE BUTTON IS NOT DISPLAYED.");
					test.log(LogStatus.INFO, "THE APPROVE BUTTON IS NOT DISPLAYED.");
					Reporter.log("THE APPROVE BUTTON IS NOT DISPLAYED.");
					log.info("THE APPROVE BUTTON IS NOT DISPLAYED.");
				}

			} catch (Throwable t) {
				verificationFailed();

				System.out.println("THE APPROVE BUTTON IS NOT DISPLAYED.");
				test.log(LogStatus.INFO, "THE APPROVE BUTTON IS NOT DISPLAYED.");
				Reporter.log("THE APPROVE BUTTON IS NOT DISPLAYED.");
				log.info("THE APPROVE BUTTON IS NOT DISPLAYED.");
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

			// click on the newly recurring task
			String futuretask1 = "//td[text()='" + taskType + "']";
			driver.findElement(By.xpath(futuretask1)).click();
			ngDriver.waitForAngularRequestsToFinish();
			System.out.println("Clicked on the newly recurring task.");

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

		// DELETE THE NEWLY CREATED RECOMMENDATION TEMPLATE AFTER DELETE
		// RECOMMENDATION TASK

		System.out.println(
				"******************** DELETE THE NEWLY CREATED RECOMMENDATION TEMPLATE AFTER DELETE RECOMMENDATION TASK ********************");
		test.log(LogStatus.INFO,
				"******************** DELETE THE NEWLY CREATED RECOMMENDATION TEMPLATE AFTER DELETE RECOMMENDATION TASK ********************");
		Reporter.log(
				"******************** DELETE THE NEWLY CREATED RECOMMENDATION TEMPLATE AFTER DELETE RECOMMENDATION TASK ********************");
		log.info(
				"******************** DELETE THE NEWLY CREATED RECOMMENDATION TEMPLATE AFTER DELETE RECOMMENDATION TASK ********************");

		try {
			// click on the side menu
			click("ssc_leftsidemenubtn_CSS");
			ngDriver.waitForAngularRequestsToFinish();
			System.out.println("Clicked on the side menu.");

			// wait for the element
			explicitWaitClickable("sidemenu_riskmanagement_CSS");

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

			// enter the newly created task type in the search field
			clear("ssc_task_tasktemplateoption_filter_CSS");
			type("ssc_task_tasktemplateoption_filter_CSS", taskType);
			ngDriver.waitForAngularRequestsToFinish();
			System.out.println("Entered the newly created task type in the search field.");

			// click on the newly created recommendation template
			String searchedRecommendationTemplate = "//td[contains(text(),'" + taskType + "')]";
			driver.findElement(By.xpath(searchedRecommendationTemplate)).click();
			ngDriver.waitForAngularRequestsToFinish();
			System.out.println("Clicked on the newly created recommendation template.");

			// wait for the element
			Thread.sleep(7000);

			// click on the delete button
			click("riskmanagement_deletebtn_XPATH");
			ngDriver.waitForAngularRequestsToFinish();
			System.out.println("Clicked on the delete button.");

			// wait for the element
			Thread.sleep(3000);

			// click on the delete button of confirmation popup
			click("riskmanagement_deletebtn_confirmation_XPATH");
			ngDriver.waitForAngularRequestsToFinish();
			System.out.println("Clicked on the delete button of confirmation popup.");

			// enter the newly created task type in the search field
			clear("ssc_task_tasktemplateoption_filter_CSS");
			type("ssc_task_tasktemplateoption_filter_CSS", taskType);
			ngDriver.waitForAngularRequestsToFinish();
			System.out.println("Entered the newly created task type in the search field.");

			// verify deleted recommendation template is displayed or not
			try {

				String createdRecommendationTemplate_XPATH = "//td[text()='" + taskType + "']";

				String deleteElement1 = (driver.findElement(By.xpath(createdRecommendationTemplate_XPATH)).getText())
						.trim();

				if (deleteElement1.equals(taskType)) {

					Assert.assertTrue(isElementPresent(By.xpath(createdRecommendationTemplate_XPATH)),
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
