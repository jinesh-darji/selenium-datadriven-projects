package testcases.smokesuite;

import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.Date;
import java.util.Hashtable;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.SkipException;
import org.testng.annotations.Test;

import com.relevantcodes.extentreports.LogStatus;

import base.Helper;
import base.TestBase;
import utilities.TestUtil;

public class RR5940PSDashboard1Test extends TestBase {

	@Test(dataProviderClass = TestUtil.class, dataProvider = "dp")
	public void rR5940PSDashboard1Test(Hashtable<String, String> data) throws IOException, InterruptedException {

		if (!(TestUtil.isTestRunnable("rR5940PSDashboard1Test", excel))) {

			throw new SkipException(
					"Skipping the test " + "rR5940PSDashboard1Test".toUpperCase() + "as the Run mode is NO");
		}

		if (!data.get("runmode").equals("Y")) {

			throw new SkipException("Skipping the test case as the Run Mode for data set is NO");
		}

		Helper helper = new Helper();

		// VERIFY THE COUNT AND DETAILS OF THE 30 DAYS OVERDUE TASK CARD

		System.out.println(
				"******************** VERIFY THE COUNT AND DETAILS OF THE 30 DAYS OVERDUE TASK CARD ********************");
		test.log(LogStatus.INFO,
				"******************** VERIFY THE COUNT AND DETAILS OF THE 30 DAYS OVERDUE TASK CARD ********************");
		Reporter.log(
				"******************** VERIFY THE COUNT AND DETAILS OF THE 30 DAYS OVERDUE TASK CARD ********************");
		log.info(
				"******************** VERIFY THE COUNT AND DETAILS OF THE 30 DAYS OVERDUE TASK CARD ********************");

		// refresh the page
		driver.navigate().refresh();
		Thread.sleep(5000);
		driver.navigate().refresh();
		
		try {
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

			// VERIFY COUNT OF THE 30 DAYS OVERDUE TASK CARD - INITIALY

			System.out.println(
					"***************** VERIFY COUNT OF THE 30 DAYS OVERDUE TASK CARD - INITIALY *****************");
			test.log(LogStatus.INFO,
					"***************** VERIFY COUNT OF THE 30 DAYS OVERDUE TASK CARD - INITIALY *****************");
			Reporter.log(
					"***************** VERIFY COUNT OF THE 30 DAYS OVERDUE TASK CARD - INITIALY *****************");
			log.info("***************** VERIFY COUNT OF THE 30 DAYS OVERDUE TASK CARD - INITIALY *****************");

			try {

				// wait for the element
				Thread.sleep(5000);

				// click on the side menu button
				click("menubtn_CSS");
				ngDriver.waitForAngularRequestsToFinish();
				System.out.println("Clicked on the side menu button.");

				// wait for the element
				Thread.sleep(5000);

				// click on the portfolio summary option
				click("sidemenu_portfoliosummary_XPATH");
				ngDriver.waitForAngularRequestsToFinish();
				System.out.println("Clicked on the portfolio summary option.");

				// verify property count
				switchVerification("portfoliosummary_toppropertycount_XPATH", "4",
						"The property count is not displayed correctly.");

				// scroll down the screen
				JavascriptExecutor js = (JavascriptExecutor) driver;
				WebElement label1 = driver.findElement(By.xpath("portfoliosummary_30daysduedatelabel_XPATH"));
				js.executeScript("arguments[0].scrollIntoView(true);", label1);

				// verify percentage of the 30 days due date task
				switchVerification("portfoliosummary_30daysduedate_count1_XPATH", "0%",
						"The percentage of the 30 days due date task is displayed incorrect.");

				// verify count of the overdue tasks of the 30 days due date task
				switchVerification("portfoliosummary_30daysduedate_count2_XPATH", "0",
						"The count of the overdue tasks of the 30 days due date task is displayed incorrect.");

				// verify count of the all tasks of the 30 days due date task
				switchVerification("portfoliosummary_30daysduedate_count3_XPATH", "0",
						"The count of the all tasks of the 30 days due date task is displayed incorrect.");

//				// scroll down the screen
//				WebElement label2 = driver.findElement(By.xpath("portfoliosummary_31to90daysduedatelabel_XPATH"));
//				js.executeScript("arguments[0].scrollIntoView(true);", label2);
//
//				// verify percentage of the 31 to 90 days due date task
//				switchVerification("portfoliosummary_31to90daysduedate_count1_XPATH", "0%",
//						"The percentage of the 31 to 90 days due date task is displayed incorrect.");
//
//				// verify count of the overdue tasks of the 31 to 90 days due date task
//				switchVerification("portfoliosummary_31to90daysduedate_count2_XPATH", "0",
//						"The count of the overdue tasks of the 31 to 90 days due date task is displayed incorrect.");
//
//				// verify count of the all tasks of the 31 to 90 days due date task
//				switchVerification("portfoliosummary_31to90daysduedate_count3_XPATH", "0",
//						"The count of the all tasks of the 31 to 90 days due date task is displayed incorrect.");
//
//				// verify count of the more than 90 days overdue of the 31 to 90 days due date
//				// task
//				switchVerification("portfoliosummary_31to90daysduedate_count4_XPATH", "0",
//						"The count of the more than 90 days overdue of the 31 to 90 days due date task is displayed incorrect.");

			} catch (Throwable t) {
				verificationFailed();
			}

			// click on the home icon from the top of the screen
			click("questionnaire_homeburgermenubtn_hide_CSS");
			ngDriver.waitForAngularRequestsToFinish();
			System.out.println("Clicked on the home icon from the top of the screen.");

			// wait for the element
			explicitWait("propertylist_title_XPATH");

			// verify the property list
			switchVerification("propertylist_title_XPATH", "Property List", "The property list is not displayed.");

			// ADD THE FIRST TASK - SET DUE DATE AS A TODAY

			System.out
					.println("******************** ADD THE FIRST TASK - SET DUE DATE AS A TODAY ********************");
			test.log(LogStatus.INFO,
					"******************** ADD THE FIRST TASK - SET DUE DATE AS A TODAY ********************");
			Reporter.log("******************** ADD THE FIRST TASK - SET DUE DATE AS A TODAY ********************");
			log.info("******************** ADD THE FIRST TASK - SET DUE DATE AS A TODAY ********************");

			try {

				// enter the property name in the search field
				type("envreports_propertylist_filtertxt_CSS", data.get("property_1"));
				ngDriver.waitForAngularRequestsToFinish();
				System.out.println("Entered the property name in the search field.");

				// click on the task icon
				click("taskicon_CSS");
				System.out.println("Clicked on the task icon.");
				ngDriver.waitForAngularRequestsToFinish();

				// click on the add task button
				click("task_addtaskbtn_CSS");
				System.out.println("Clicked on the add task button.");
				ngDriver.waitForAngularRequestsToFinish();

				// enter the data in the task title field
				clear("task_addtask_titletxt_CSS");
				type("task_addtask_titletxt_CSS", data.get("task_title"));
				System.out.println("Entered the data in the task title field.");
				ngDriver.waitForAngularRequestsToFinish();

				// enter the data in the task location field
				clear("task_addtask_locationtxt_CSS");
				type("task_addtask_locationtxt_CSS", data.get("task_location"));
				System.out.println("Entered the data in the task location field.");
				ngDriver.waitForAngularRequestsToFinish();

				// scroll down the screen
				JavascriptExecutor js = (JavascriptExecutor) driver;
				js.executeScript("window.scrollBy(0,600)");

				// SELECT THE DUE DATE

				// click on the due date field
				click("task_duedatetxt_CSS");
				ngDriver.waitForAngularRequestsToFinish();
				System.out.println("Clicked on the due date field.");

				// wait for the element
				explicitWaitClickable("task_tasktag_newduedatetxt_todaybtn_XPATH");

				// click on the today button
				click("task_tasktag_newduedatetxt_todaybtn_XPATH");
				ngDriver.waitForAngularRequestsToFinish();
				System.out.println("Clicked on the year button.");

				// scroll down the screen
				js.executeScript("window.scrollBy(0,600)");

				// wait for the element
				explicitWait("task_addtask_moduledd_CSS");

				// select the application option from the module dropdown
				select("task_addtask_moduledd_CSS", data.get("task_module"));
				System.out.println("Selected the environmental option from the module dropdown.");
				ngDriver.waitForAngularRequestsToFinish();

				// click on the save button
				click("survey_task_savebtn_CSS");
				System.out.println("Clicked on the save button.");
				ngDriver.waitForAngularRequestsToFinish();

				// scroll up the screen
				js.executeScript("window.scrollBy(0,-400)");

				// click on the clear button
				click("task_createdtask_clearbtn_XPATH");
				ngDriver.waitForAngularRequestsToFinish();
				System.out.println("Clicked on the clear button.");

				// enter the data in the search field
				type("task_filter_CSS", data.get("task_title"));
				System.out.println("Entered the data in the search field.");
				ngDriver.waitForAngularRequestsToFinish();

				// click on the search button
				click("task_createdtask_searchbtn_XPATH");
				ngDriver.waitForAngularRequestsToFinish();
				System.out.println("Clicked on the search button.");

				// verify newly created task is displayed or not
				switchVerification("task_addedtask_psd1_XPATH", "Smoke Test PSD 1 Task Title",
						"The Smoke Test PSD 1 Task Title is not displayed.");

			} catch (Throwable t) {
				verificationFailed();
			}

			// click on the home icon from the top of the screen
			click("questionnaire_homeburgermenubtn_hide_CSS");
			ngDriver.waitForAngularRequestsToFinish();
			System.out.println("Clicked on the home icon from the top of the screen.");

			// wait for the element
			explicitWait("propertylist_title_XPATH");

			// verify the property list
			switchVerification("propertylist_title_XPATH", "Property List", "The property list is not displayed.");

			// VERIFY COUNT OF THE 30 DAYS OVERDUE TASK CARDS - AFTER CREATED TASK WITH
			// TODAY'S DUE DATE

			System.out.println(
					"***************** VERIFY COUNT OF THE 30 DAYS OVERDUE TASK CARDS - AFTER CREATED TASK WITH TODAY'S DUE DATE *****************");
			test.log(LogStatus.INFO,
					"***************** VERIFY COUNT OF THE 30 DAYS OVERDUE TASK CARDS - AFTER CREATED TASK WITH TODAY'S DUE DATE *****************");
			Reporter.log(
					"***************** VERIFY COUNT OF THE 30 DAYS OVERDUE TASK CARDS - AFTER CREATED TASK WITH TODAY'S DUE DATE *****************");
			log.info(
					"***************** VERIFY COUNT OF THE 30 DAYS OVERDUE TASK CARDS - AFTER CREATED TASK WITH TODAY'S DUE DATE *****************");

			try {

				// wait for the element
				Thread.sleep(5000);

				// click on the side menu button
				click("menubtn_CSS");
				ngDriver.waitForAngularRequestsToFinish();
				System.out.println("Clicked on the side menu button.");

				// wait for the element
				Thread.sleep(5000);

				// click on the portfolio summary option
				click("sidemenu_portfoliosummary_XPATH");
				ngDriver.waitForAngularRequestsToFinish();
				System.out.println("Clicked on the portfolio summary option.");

				// verify property count
				switchVerification("portfoliosummary_toppropertycount_XPATH", "4",
						"The property count is not displayed correctly.");

				// scroll down the screen
				JavascriptExecutor js = (JavascriptExecutor) driver;
				WebElement label1 = driver.findElement(By.xpath("portfoliosummary_30daysduedatelabel_XPATH"));
				js.executeScript("arguments[0].scrollIntoView(true);", label1);

				// verify percentage of the 30 days due date task
				switchVerification("portfoliosummary_30daysduedate_count1_XPATH", "0%",
						"The percentage of the 30 days due date task is displayed incorrect.");

				// verify count of the overdue tasks of the 30 days due date task
				switchVerification("portfoliosummary_30daysduedate_count2_XPATH", "0",
						"The count of the overdue tasks of the 30 days due date task is displayed incorrect.");

				// verify count of the all tasks of the 30 days due date task
				switchVerification("portfoliosummary_30daysduedate_count3_XPATH", "0",
						"The count of the all tasks of the 30 days due date task is displayed incorrect.");

//				// scroll down the screen
//				WebElement label2 = driver.findElement(By.xpath("portfoliosummary_31to90daysduedatelabel_XPATH"));
//				js.executeScript("arguments[0].scrollIntoView(true);", label2);
//
//				// verify percentage of the 31 to 90 days due date task
//				switchVerification("portfoliosummary_31to90daysduedate_count1_XPATH", "0%",
//						"The percentage of the 31 to 90 days due date task is displayed incorrect.");
//
//				// verify count of the overdue tasks of the 31 to 90 days due date task
//				switchVerification("portfoliosummary_31to90daysduedate_count2_XPATH", "0",
//						"The count of the overdue tasks of the 31 to 90 days due date task is displayed incorrect.");
//
//				// verify count of the all tasks of the 31 to 90 days due date task
//				switchVerification("portfoliosummary_31to90daysduedate_count3_XPATH", "0",
//						"The count of the all tasks of the 31 to 90 days due date task is displayed incorrect.");
//
//				// verify count of the more than 90 days overdue of the 31 to 90 days due date
//				// task
//				switchVerification("portfoliosummary_31to90daysduedate_count4_XPATH", "0",
//						"The count of the more than 90 days overdue of the 31 to 90 days due date task is displayed incorrect.");

			} catch (Throwable t) {
				verificationFailed();
			}

			// click on the home icon from the top of the screen
			click("questionnaire_homeburgermenubtn_hide_CSS");
			ngDriver.waitForAngularRequestsToFinish();
			System.out.println("Clicked on the home icon from the top of the screen.");

			// wait for the element
			explicitWait("propertylist_title_XPATH");

			// verify the property list
			switchVerification("propertylist_title_XPATH", "Property List", "The property list is not displayed.");

			// UPDATE THE DUE DATE OF THE TASK FROM TODAY TO FUTURE DATE

			System.out.println(
					"******************** UPDATE THE DUE DATE OF THE TASK FROM TODAY TO FUTURE DATE ********************");
			test.log(LogStatus.INFO,
					"******************** UPDATE THE DUE DATE OF THE TASK FROM TODAY TO FUTURE DATE ********************");
			Reporter.log(
					"******************** UPDATE THE DUE DATE OF THE TASK FROM TODAY TO FUTURE DATE ********************");
			log.info(
					"******************** UPDATE THE DUE DATE OF THE TASK FROM TODAY TO FUTURE DATE ********************");

			try {

				// enter the property name in the search field
				type("envreports_propertylist_filtertxt_CSS", data.get("property_1"));
				ngDriver.waitForAngularRequestsToFinish();
				System.out.println("Entered the property name in the search field.");

				// click on the task icon
				click("taskicon_CSS");
				System.out.println("Clicked on the task icon.");
				ngDriver.waitForAngularRequestsToFinish();

				// click on the clear button
				click("task_createdtask_clearbtn_XPATH");
				ngDriver.waitForAngularRequestsToFinish();
				System.out.println("Clicked on the clear button.");

				// enter the data in the search field
				type("task_filter_CSS", data.get("task_title"));
				System.out.println("Entered the data in the search field.");
				ngDriver.waitForAngularRequestsToFinish();

				// click on the search button
				click("task_createdtask_searchbtn_XPATH");
				ngDriver.waitForAngularRequestsToFinish();
				System.out.println("Clicked on the search button.");

				// verify newly created task is displayed or not
				switchVerification("task_addedtask_psd1_XPATH", "Smoke Test PSD 1 Task Title",
						"The Smoke Test PSD 1 Task Title is not displayed.");

				// click on the newly created task
				click("task_addedtask_psd1_XPATH");
				ngDriver.waitForAngularRequestsToFinish();
				System.out.println("Clicked on the newly created task.");

				// click on the change due date button
				click("task_tasktag_changeduedatebtn_CSS");
				ngDriver.waitForAngularRequestsToFinish();
				System.out.println("Clicked on the change due date button.");

				// enter date which is 2 days after current date
				LocalDate futureDate = LocalDate.now().plusDays(2);
				String finalFutureDate = futureDate.toString();
				type("task_tasktag_changeduedate_newduedate_XPATH", finalFutureDate);
				ngDriver.waitForAngularRequestsToFinish();
				System.out.println("Entered date which is 2 days before current date");

				// click on the new due date label
				click("task_tasktag_changeduedate_newduedatelbl_XPATH");
				ngDriver.waitForAngularRequestsToFinish();
				System.out.println("Clicked on the new due date label.");

				// enter data in the reason for change field
				clear("task_updateduedate_reasonforchangetxt_CSS");
				type("task_updateduedate_reasonforchangetxt_CSS", data.get("reason_for_change"));
				ngDriver.waitForAngularRequestsToFinish();
				System.out.println("Entered data in the reason for change field.");

				// click on the apply button
				click("task_updateduedate_applybtn_CSS");
				ngDriver.waitForAngularRequestsToFinish();
				System.out.println("Clicked on the apply button.");

				// scroll up the screen
				JavascriptExecutor js = (JavascriptExecutor) driver;
				js.executeScript("window.scrollBy(0,-500)");

				// click on the update button
				click("survey_task_updatebtn_CSS");
				ngDriver.waitForAngularRequestsToFinish();
				System.out.println("Clicked on the update button.");

				// wait for the element
				explicitWaitClickable("closetoastmsg_CSS");

				// click on the toaster close button
				click("closetoastmsg_CSS");
				ngDriver.waitForAngularRequestsToFinish();
				System.out.println("Clicked on the toaster close button.");

				// click on the back button
				click("task_backbtn_CSS");
				ngDriver.waitForAngularRequestsToFinish();
				System.out.println("Clicked on the back button.");

				// click on the clear button
				click("task_createdtask_clearbtn_XPATH");
				ngDriver.waitForAngularRequestsToFinish();
				System.out.println("Selected the newly created task.");

				// type the newly created task in the search field
				type("task_filter_CSS", data.get("task_title"));
				ngDriver.waitForAngularRequestsToFinish();
				System.out.println("Selected the newly created task.");

				// click on the search button
				click("task_createdtask_searchbtn_XPATH");
				ngDriver.waitForAngularRequestsToFinish();
				System.out.println("Clicked on the search button.");

				// verify newly created task is displayed or not
				switchVerification("task_addedtask_psd1_XPATH", "Smoke Test PSD 1 Task Title",
						"The Smoke Test PSD 1 Task Title is not displayed.");

			} catch (Throwable t) {
				verificationFailed();
			}

			// click on the home icon from the top of the screen
			click("questionnaire_homeburgermenubtn_hide_CSS");
			ngDriver.waitForAngularRequestsToFinish();
			System.out.println("Clicked on the home icon from the top of the screen.");

			// wait for the element
			explicitWait("propertylist_title_XPATH");

			// verify the property list
			switchVerification("propertylist_title_XPATH", "Property List", "The property list is not displayed.");

			// VERIFY COUNT OF THE 30 DAYS OVERDUE TASK CARD - AFTER UPDATED THE DUE DATE OF THE TASK FROM TODAY TO FUTURE DATE

			System.out.println(
					"***************** VERIFY COUNT OF THE 30 DAYS OVERDUE TASK CARD - AFTER UPDATED THE DUE DATE OF THE TASK FROM TODAY TO FUTURE DATE *****************");
			test.log(LogStatus.INFO,
					"***************** VERIFY COUNT OF THE 30 DAYS OVERDUE TASK CARD - AFTER UPDATED THE DUE DATE OF THE TASK FROM TODAY TO FUTURE DATE *****************");
			Reporter.log(
					"***************** VERIFY COUNT OF THE 30 DAYS OVERDUE TASK CARD - AFTER UPDATED THE DUE DATE OF THE TASK FROM TODAY TO FUTURE DATE *****************");
			log.info(
					"***************** VERIFY COUNT OF THE 30 DAYS OVERDUE TASK CARD - AFTER UPDATED THE DUE DATE OF THE TASK FROM TODAY TO FUTURE DATE *****************");

			try {

				// wait for the element
				Thread.sleep(5000);

				// click on the side menu button
				click("menubtn_CSS");
				ngDriver.waitForAngularRequestsToFinish();
				System.out.println("Clicked on the side menu button.");

				// wait for the element
				Thread.sleep(5000);

				// click on the portfolio summary option
				click("sidemenu_portfoliosummary_XPATH");
				ngDriver.waitForAngularRequestsToFinish();
				System.out.println("Clicked on the portfolio summary option.");

				// verify property count
				switchVerification("portfoliosummary_toppropertycount_XPATH", "4",
						"The property count is not displayed correctly.");

				// scroll down the screen
				JavascriptExecutor js = (JavascriptExecutor) driver;
				WebElement label1 = driver.findElement(By.xpath("portfoliosummary_30daysduedatelabel_XPATH"));
				js.executeScript("arguments[0].scrollIntoView(true);", label1);

				// verify percentage of the 30 days due date task
				switchVerification("portfoliosummary_30daysduedate_count1_XPATH", "0%",
						"The percentage of the 30 days due date task is displayed incorrect.");

				// verify count of the overdue tasks of the 30 days due date task
				switchVerification("portfoliosummary_30daysduedate_count2_XPATH", "0",
						"The count of the overdue tasks of the 30 days due date task is displayed incorrect.");

				// verify count of the all tasks of the 30 days due date task
				switchVerification("portfoliosummary_30daysduedate_count3_XPATH", "0",
						"The count of the all tasks of the 30 days due date task is displayed incorrect.");

//				// scroll down the screen
//				WebElement label2 = driver.findElement(By.xpath("portfoliosummary_31to90daysduedatelabel_XPATH"));
//				js.executeScript("arguments[0].scrollIntoView(true);", label2);
//
//				// verify percentage of the 31 to 90 days due date task
//				switchVerification("portfoliosummary_31to90daysduedate_count1_XPATH", "0%",
//						"The percentage of the 31 to 90 days due date task is displayed incorrect.");
//
//				// verify count of the overdue tasks of the 31 to 90 days due date task
//				switchVerification("portfoliosummary_31to90daysduedate_count2_XPATH", "0",
//						"The count of the overdue tasks of the 31 to 90 days due date task is displayed incorrect.");
//
//				// verify count of the all tasks of the 31 to 90 days due date task
//				switchVerification("portfoliosummary_31to90daysduedate_count3_XPATH", "0",
//						"The count of the all tasks of the 31 to 90 days due date task is displayed incorrect.");
//
//				// verify count of the more than 90 days overdue of the 31 to 90 days due date
//				// task
//				switchVerification("portfoliosummary_31to90daysduedate_count4_XPATH", "0",
//						"The count of the more than 90 days overdue of the 31 to 90 days due date task is displayed incorrect.");

			} catch (Throwable t) {
				verificationFailed();
			}

			// click on the home icon from the top of the screen
			click("questionnaire_homeburgermenubtn_hide_CSS");
			ngDriver.waitForAngularRequestsToFinish();
			System.out.println("Clicked on the home icon from the top of the screen.");

			// wait for the element
			explicitWait("propertylist_title_XPATH");

			// verify the property list
			switchVerification("propertylist_title_XPATH", "Property List", "The property list is not displayed.");

			// UPDATE THE DUE DATE OF THE TASK FROM FUTURE TO PAST DATE - LESS THAN 30 DAYS

			System.out.println(
					"******************** UPDATE THE DUE DATE OF THE TASK FROM FUTURE TO PAST DATE - LESS THAN 30 DAYS ********************");
			test.log(LogStatus.INFO,
					"******************** UPDATE THE DUE DATE OF THE TASK FROM FUTURE TO PAST DATE - LESS THAN 30 DAYS ********************");
			Reporter.log(
					"******************** UPDATE THE DUE DATE OF THE TASK FROM FUTURE TO PAST DATE - LESS THAN 30 DAYS ********************");
			log.info(
					"******************** UPDATE THE DUE DATE OF THE TASK FROM FUTURE TO PAST DATE - LESS THAN 30 DAYS ********************");

			try {

				// enter the property name in the search field
				type("envreports_propertylist_filtertxt_CSS", data.get("property_1"));
				ngDriver.waitForAngularRequestsToFinish();
				System.out.println("Entered the property name in the search field.");

				// click on the task icon
				click("taskicon_CSS");
				System.out.println("Clicked on the task icon.");
				ngDriver.waitForAngularRequestsToFinish();

				// click on the clear button
				click("task_createdtask_clearbtn_XPATH");
				ngDriver.waitForAngularRequestsToFinish();
				System.out.println("Clicked on the clear button.");

				// enter the data in the search field
				type("task_filter_CSS", data.get("task_title"));
				System.out.println("Entered the data in the search field.");
				ngDriver.waitForAngularRequestsToFinish();

				// click on the search button
				click("task_createdtask_searchbtn_XPATH");
				ngDriver.waitForAngularRequestsToFinish();
				System.out.println("Clicked on the search button.");

				// verify newly created task is displayed or not
				switchVerification("task_addedtask_psd1_XPATH", "Smoke Test PSD 1 Task Title",
						"The Smoke Test PSD 1 Task Title is not displayed.");

				// click on the newly created task
				click("task_addedtask_psd1_XPATH");
				ngDriver.waitForAngularRequestsToFinish();
				System.out.println("Clicked on the newly created task.");

				// click on the change due date button
				click("task_tasktag_changeduedatebtn_CSS");
				ngDriver.waitForAngularRequestsToFinish();
				System.out.println("Clicked on the change due date button.");

				// enter date which is 5 days before current date
				LocalDate pastDate = LocalDate.now().minusDays(5);
				String finalPastDate = pastDate.toString();
				type("task_tasktag_changeduedate_newduedate_XPATH", finalPastDate);
				ngDriver.waitForAngularRequestsToFinish();
				System.out.println("Entered date which is 5 days before current date");

				// click on the new due date label
				click("task_tasktag_changeduedate_newduedatelbl_XPATH");
				ngDriver.waitForAngularRequestsToFinish();
				System.out.println("Clicked on the new due date label.");

				// enter data in the reason for change field
				clear("task_updateduedate_reasonforchangetxt_CSS");
				type("task_updateduedate_reasonforchangetxt_CSS", data.get("reason_for_change"));
				ngDriver.waitForAngularRequestsToFinish();
				System.out.println("Entered data in the reason for change field.");

				// click on the apply button
				click("task_updateduedate_applybtn_CSS");
				ngDriver.waitForAngularRequestsToFinish();
				System.out.println("Clicked on the apply button.");

				// scroll up the screen
				JavascriptExecutor js = (JavascriptExecutor) driver;
				js.executeScript("window.scrollBy(0,-500)");

				// click on the update button
				click("survey_task_updatebtn_CSS");
				ngDriver.waitForAngularRequestsToFinish();
				System.out.println("Clicked on the update button.");

				// wait for the element
				explicitWaitClickable("closetoastmsg_CSS");

				// click on the toaster close button
				click("closetoastmsg_CSS");
				ngDriver.waitForAngularRequestsToFinish();
				System.out.println("Clicked on the toaster close button.");

				// click on the back button
				click("task_backbtn_CSS");
				ngDriver.waitForAngularRequestsToFinish();
				System.out.println("Clicked on the back button.");

				// click on the clear button
				click("task_createdtask_clearbtn_XPATH");
				ngDriver.waitForAngularRequestsToFinish();
				System.out.println("Selected the newly created task.");

				// type the newly created task in the search field
				type("task_filter_CSS", data.get("task_title"));
				ngDriver.waitForAngularRequestsToFinish();
				System.out.println("Selected the newly created task.");

				// click on the search button
				click("task_createdtask_searchbtn_XPATH");
				ngDriver.waitForAngularRequestsToFinish();
				System.out.println("Clicked on the search button.");

				// verify newly created task is displayed or not
				switchVerification("task_addedtask_psd1_XPATH", "Smoke Test PSD 1 Task Title",
						"The Smoke Test PSD 1 Task Title is not displayed.");

			} catch (Throwable t) {
				verificationFailed();
			}

			// click on the home icon from the top of the screen
			click("questionnaire_homeburgermenubtn_hide_CSS");
			ngDriver.waitForAngularRequestsToFinish();
			System.out.println("Clicked on the home icon from the top of the screen.");

			// wait for the element
			explicitWait("propertylist_title_XPATH");

			// verify the property list
			switchVerification("propertylist_title_XPATH", "Property List", "The property list is not displayed.");

			// VERIFY COUNT OF THE 30 DAYS OVERDUE TASK CARD - AFTER UPDATED THE DUE DATE OF THE TASK FROM FUTURE TO PAST DATE - LESS THAN 30 DAYS

			System.out.println(
					"***************** VERIFY COUNT OF THE 30 DAYS OVERDUE TASK CARD - AFTER UPDATED THE DUE DATE OF THE TASK FROM FUTURE TO PAST DATE - LESS THAN 30 DAYS *****************");
			test.log(LogStatus.INFO,
					"***************** VERIFY COUNT OF THE 30 DAYS OVERDUE TASK CARD - AFTER UPDATED THE DUE DATE OF THE TASK FROM FUTURE TO PAST DATE - LESS THAN 30 DAYS *****************");
			Reporter.log(
					"***************** VERIFY COUNT OF THE 30 DAYS OVERDUE TASK CARD - AFTER UPDATED THE DUE DATE OF THE TASK FROM FUTURE TO PAST DATE - LESS THAN 30 DAYS *****************");
			log.info(
					"***************** VERIFY COUNT OF THE 30 DAYS OVERDUE TASK CARD - AFTER UPDATED THE DUE DATE OF THE TASK FROM FUTURE TO PAST DATE - LESS THAN 30 DAYS *****************");

			try {

				// wait for the element
				Thread.sleep(5000);

				// click on the side menu button
				click("menubtn_CSS");
				ngDriver.waitForAngularRequestsToFinish();
				System.out.println("Clicked on the side menu button.");

				// wait for the element
				Thread.sleep(5000);

				// click on the portfolio summary option
				click("sidemenu_portfoliosummary_XPATH");
				ngDriver.waitForAngularRequestsToFinish();
				System.out.println("Clicked on the portfolio summary option.");

				// verify property count
				switchVerification("portfoliosummary_toppropertycount_XPATH", "4",
						"The property count is not displayed correctly.");

				// scroll down the screen
				JavascriptExecutor js = (JavascriptExecutor) driver;
				WebElement label1 = driver.findElement(By.xpath("portfoliosummary_30daysduedatelabel_XPATH"));
				js.executeScript("arguments[0].scrollIntoView(true);", label1);

				// verify percentage of the 30 days due date task
				switchVerification("portfoliosummary_30daysduedate_count1_XPATH", "100%",
						"The percentage of the 30 days due date task is displayed incorrect.");

				// verify count of the overdue tasks of the 30 days due date task
				switchVerification("portfoliosummary_30daysduedate_count2_XPATH", "1",
						"The count of the overdue tasks of the 30 days due date task is displayed incorrect.");

				// verify count of the all tasks of the 30 days due date task
				switchVerification("portfoliosummary_30daysduedate_count3_XPATH", "1",
						"The count of the all tasks of the 30 days due date task is displayed incorrect.");

//				// scroll down the screen
//				WebElement label2 = driver.findElement(By.xpath("portfoliosummary_31to90daysduedatelabel_XPATH"));
//				js.executeScript("arguments[0].scrollIntoView(true);", label2);
//
//				// verify percentage of the 31 to 90 days due date task
//				switchVerification("portfoliosummary_31to90daysduedate_count1_XPATH", "0%",
//						"The percentage of the 31 to 90 days due date task is displayed incorrect.");
//
//				// verify count of the overdue tasks of the 31 to 90 days due date task
//				switchVerification("portfoliosummary_31to90daysduedate_count2_XPATH", "0",
//						"The count of the overdue tasks of the 31 to 90 days due date task is displayed incorrect.");
//
//				// verify count of the all tasks of the 31 to 90 days due date task
//				switchVerification("portfoliosummary_31to90daysduedate_count3_XPATH", "0",
//						"The count of the all tasks of the 31 to 90 days due date task is displayed incorrect.");
//
//				// verify count of the more than 90 days overdue of the 31 to 90 days due date
//				// task
//				switchVerification("portfoliosummary_31to90daysduedate_count4_XPATH", "0",
//						"The count of the more than 90 days overdue of the 31 to 90 days due date task is displayed incorrect.");

			} catch (Throwable t) {
				verificationFailed();
			}

			// click on the home icon from the top of the screen
			click("questionnaire_homeburgermenubtn_hide_CSS");
			ngDriver.waitForAngularRequestsToFinish();
			System.out.println("Clicked on the home icon from the top of the screen.");

			// wait for the element
			explicitWait("propertylist_title_XPATH");

			// verify the property list
			switchVerification("propertylist_title_XPATH", "Property List", "The property list is not displayed.");

			// VERIFY UPDATED DUE DATE IN THE TASK FROM THE PORTFOLIO SUMMARY DASHBOARD
			// SCREEN

			System.out.println(
					"***************** VERIFY UPDATED DUE DATE IN THE TASK FROM THE TASK LIST OF THE PORTFOLIO SUMMARY DASHBOARD SCREEN *****************");
			test.log(LogStatus.INFO,
					"***************** VERIFY UPDATED DUE DATE IN THE TASK FROM THE TASK LIST OF THE PORTFOLIO SUMMARY DASHBOARD SCREEN *****************");
			Reporter.log(
					"***************** VERIFY UPDATED DUE DATE IN THE TASK FROM THE TASK LIST OF THE PORTFOLIO SUMMARY DASHBOARD SCREEN *****************");
			log.info(
					"***************** VERIFY UPDATED DUE DATE IN THE TASK FROM THE TASK LIST OF THE PORTFOLIO SUMMARY DASHBOARD SCREEN *****************");

			try {

				// wait for the element
				Thread.sleep(5000);

				// click on the side menu button
				click("menubtn_CSS");
				ngDriver.waitForAngularRequestsToFinish();
				System.out.println("Clicked on the side menu button.");

				// wait for the element
				Thread.sleep(5000);

				// click on the portfolio summary option
				click("sidemenu_portfoliosummary_XPATH");
				ngDriver.waitForAngularRequestsToFinish();
				System.out.println("Clicked on the portfolio summary option.");

				// verify property count
				switchVerification("portfoliosummary_toppropertycount_XPATH", "4",
						"The property count is not displayed correctly.");

				// scroll down the screen
				JavascriptExecutor js = (JavascriptExecutor) driver;
				WebElement label1 = driver.findElement(By.xpath("portfoliosummary_30daysduedatelabel_XPATH"));
				js.executeScript("arguments[0].scrollIntoView(true);", label1);

				// verify percentage of the 30 days due date task
				switchVerification("portfoliosummary_30daysduedate_count1_XPATH", "100%",
						"The percentage of the 30 days due date task is displayed incorrect.");

				// enter the newly created first task in the search field
				clear("riskmanagement_task_searchtxt_XPATH");
				type("riskmanagement_task_searchtxt_XPATH", data.get("task_title"));
				ngDriver.waitForAngularRequestsToFinish();
				System.out.println("Entered the newly created first task in the search field.");

				try {
					// validate the due date is displayed correct or not
					LocalDate pastDate1 = LocalDate.now().minusDays(5);
					String finalPastDate1 = pastDate1.toString();
					String duedatetask1 = "//td[text()='" + data.get("task_title")
							+ "']//following-sibling::td[text()='" + finalPastDate1 + "']";
					String duedate1 = (driver.findElement(By.xpath(duedatetask1)).getText()).trim();

					if (duedate1.equals(finalPastDate1)) {

						System.out.println("The past due date is verified successfully.");
						test.log(LogStatus.INFO, "The past due date is verified successfully.");
						Reporter.log("The past due date is verified successfully.");
						log.info("The past due date is verified successfully.");
					} else {
						verificationFailed();

						System.out.println("The past due date is not displayed correct.");
						test.log(LogStatus.INFO, "The past due date is not displayed correct.");
						Reporter.log("The past due date is not displayed correct.");
						log.info("The past due date is not displayed correct.");

					}
				} catch (Throwable t) {
					verificationFailed();

					System.out.println("The past due date is not displayed correct.");
					test.log(LogStatus.INFO, "The past due date is not displayed correct.");
					Reporter.log("The past due date is not displayed correct.");
					log.info("The past due date is not displayed correct.");
				}

				// click on the searched task
				String task1 = "//td[text()='" + data.get("task_title") + "']";
				driver.findElement(By.xpath(task1)).click();
				ngDriver.waitForAngularRequestsToFinish();
				System.out.println("Clicked on the searched task.");

				// click on the change due date button
				click("task_tasktag_changeduedatebtn_CSS");
				ngDriver.waitForAngularRequestsToFinish();
				System.out.println("Clicked on the change due date button.");

				// enter date which is 5 days before current date
				LocalDate pastDate2 = LocalDate.now().minusDays(15);
				String finalPastDate2 = pastDate2.toString();
				type("task_tasktag_changeduedate_newduedate_XPATH", finalPastDate2);
				ngDriver.waitForAngularRequestsToFinish();
				System.out.println("Entered date which is 5 days before current date");

				// click on the new due date label
				click("task_tasktag_changeduedate_newduedatelbl_XPATH");
				ngDriver.waitForAngularRequestsToFinish();
				System.out.println("Clicked on the new due date label.");

				// enter data in the reason for change field
				clear("task_updateduedate_reasonforchangetxt_CSS");
				type("task_updateduedate_reasonforchangetxt_CSS", data.get("reason_for_change"));
				ngDriver.waitForAngularRequestsToFinish();
				System.out.println("Entered data in the reason for change field.");

				// click on the apply button
				click("task_updateduedate_applybtn_CSS");
				ngDriver.waitForAngularRequestsToFinish();
				System.out.println("Clicked on the apply button.");

				// scroll up the screen
				js.executeScript("window.scrollBy(0,-500)");

				// click on the update button
				click("survey_task_updatebtn_CSS");
				ngDriver.waitForAngularRequestsToFinish();
				System.out.println("Clicked on the update button.");

				// wait for the element
				explicitWaitClickable("closetoastmsg_CSS");

				// click on the toaster close button
				click("closetoastmsg_CSS");
				ngDriver.waitForAngularRequestsToFinish();
				System.out.println("Clicked on the toaster close button.");

				// enter the newly created first task in the search field
				clear("riskmanagement_task_searchtxt_XPATH");
				type("riskmanagement_task_searchtxt_XPATH", data.get("task_title"));
				ngDriver.waitForAngularRequestsToFinish();
				System.out.println("Entered the newly created first task in the search field.");

				try {
					// validate the due date is displayed correct or not
					LocalDate pastDate4 = LocalDate.now().minusDays(15);
					String finalPastDate4 = pastDate4.toString();
					String duedatetask4 = "//td[text()='" + data.get("task_title")
							+ "']//following-sibling::td[text()='" + finalPastDate4 + "']";
					String duedate4 = (driver.findElement(By.xpath(duedatetask4)).getText()).trim();

					if (duedate4.equals(finalPastDate4)) {

						System.out.println("The updated past due date is verified successfully.");
						test.log(LogStatus.INFO, "The updated past due date is verified successfully.");
						Reporter.log("The updated past due date is verified successfully.");
						log.info("The updated past due date is verified successfully.");
					} else {
						verificationFailed();

						System.out.println("The updated past due date is not displayed correct.");
						test.log(LogStatus.INFO, "The updated past due date is not displayed correct.");
						Reporter.log("The updated past due date is not displayed correct.");
						log.info("The updated past due date is not displayed correct.");

					}
				} catch (Throwable t) {
					verificationFailed();

					System.out.println("The updated past due date is not displayed correct.");
					test.log(LogStatus.INFO, "The updated past due date is not displayed correct.");
					Reporter.log("The updated past due date is not displayed correct.");
					log.info("The updated past due date is not displayed correct.");
				}

			} catch (Throwable t) {
				verificationFailed();
			}

			// click on the home icon from the top of the screen
			click("questionnaire_homeburgermenubtn_hide_CSS");
			ngDriver.waitForAngularRequestsToFinish();
			System.out.println("Clicked on the home icon from the top of the screen.");

			// wait for the element
			explicitWait("propertylist_title_XPATH");

			// verify the property list
			switchVerification("propertylist_title_XPATH", "Property List", "The property list is not displayed.");

			// VERIFY UPDATED DUE DATE IN THE TASK MODULE

			System.out.println("***************** VERIFY UPDATED DUE DATE IN THE TASK MODULE *****************");
			test.log(LogStatus.INFO, "***************** VERIFY UPDATED DUE DATE IN THE TASK MODULE *****************");
			Reporter.log("***************** VERIFY UPDATED DUE DATE IN THE TASK MODULE *****************");
			log.info("***************** VERIFY UPDATED DUE DATE IN THE TASK MODULE *****************");

			try {

				// enter the property name in the search field
				clear("envreports_propertylist_filtertxt_CSS");
				type("envreports_propertylist_filtertxt_CSS", data.get("property_1"));
				ngDriver.waitForAngularRequestsToFinish();
				System.out.println("Entered the property name in the search field.");

				// click on the task icon
				click("taskicon_CSS");
				System.out.println("Clicked on the task icon.");
				ngDriver.waitForAngularRequestsToFinish();

				// click on the clear button
				click("task_createdtask_clearbtn_XPATH");
				ngDriver.waitForAngularRequestsToFinish();
				System.out.println("Selected the newly created task.");

				// type the newly created task in the search field
				type("task_filter_CSS", data.get("task_title"));
				ngDriver.waitForAngularRequestsToFinish();
				System.out.println("Selected the newly created task.");

				// click on the search button
				click("task_createdtask_searchbtn_XPATH");
				ngDriver.waitForAngularRequestsToFinish();
				System.out.println("Clicked on the search button.");

				// verify newly created task is displayed or not
				switchVerification("task_addedtask_psd1_XPATH", "Smoke Test PSD 1 Task Title",
						"The Smoke Test PSD 1 Task Title is not displayed.");

				try {
					// verify the update due date of the first task
					LocalDate pastDate5 = LocalDate.now().minusDays(15);
					String finalPastDate5 = pastDate5.toString();
					String updatedDueDate5 = "//p[text()='" + data.get("task_title")
							+ "']//parent::td[@ng-click='editTaskFromLandingPage(task)']//following-sibling::td[text()='"
							+ finalPastDate5 + "']";

					if (updatedDueDate5.equals(finalPastDate5)) {

						System.out.println("The updated past due date is verified successfully.");
						test.log(LogStatus.INFO, "The updated past due date is verified successfully.");
						Reporter.log("The updated past due date is verified successfully.");
						log.info("The updated past due date is verified successfully.");
					} else {
						verificationFailed();

						System.out.println("The updated past due date is not displayed correct.");
						test.log(LogStatus.INFO, "The updated past due date is not displayed correct.");
						Reporter.log("The updated past due date is not displayed correct.");
						log.info("The updated past due date is not displayed correct.");

					}
				} catch (Throwable t) {
					verificationFailed();

					System.out.println("The updated past due date is not displayed correct.");
					test.log(LogStatus.INFO, "The updated past due date is not displayed correct.");
					Reporter.log("The updated past due date is not displayed correct.");
					log.info("The updated past due date is not displayed correct.");

				}

			} catch (Throwable t) {
				verificationFailed();
			}

			// click on the home icon from the top of the screen
			click("questionnaire_homeburgermenubtn_hide_CSS");
			ngDriver.waitForAngularRequestsToFinish();
			System.out.println("Clicked on the home icon from the top of the screen.");

			// wait for the element
			explicitWait("propertylist_title_XPATH");

			// verify the property list
			switchVerification("propertylist_title_XPATH", "Property List", "The property list is not displayed.");

			// ADD THE SECOND TASK - SET DUE DATE AS A TODAY

			System.out
					.println("******************** ADD THE SECOND TASK - SET DUE DATE AS A TODAY ********************");
			test.log(LogStatus.INFO,
					"******************** ADD THE SECOND TASK - SET DUE DATE AS A TODAY ********************");
			Reporter.log("******************** ADD THE SECOND TASK - SET DUE DATE AS A TODAY ********************");
			log.info("******************** ADD THE SECOND TASK - SET DUE DATE AS A TODAY ********************");

			try {

				// enter the property name in the search field
				type("envreports_propertylist_filtertxt_CSS", data.get("property_1"));
				ngDriver.waitForAngularRequestsToFinish();
				System.out.println("Entered the property name in the search field.");

				// click on the task icon
				click("taskicon_CSS");
				System.out.println("Clicked on the task icon.");
				ngDriver.waitForAngularRequestsToFinish();

				// click on the add task button
				click("task_addtaskbtn_CSS");
				System.out.println("Clicked on the add task button.");
				ngDriver.waitForAngularRequestsToFinish();

				// enter the data in the task title field
				clear("task_addtask_titletxt_CSS");
				type("task_addtask_titletxt_CSS", data.get("task_title_2"));
				System.out.println("Entered the data in the task title field.");
				ngDriver.waitForAngularRequestsToFinish();

				// enter the data in the task location field
				clear("task_addtask_locationtxt_CSS");
				type("task_addtask_locationtxt_CSS", data.get("task_location"));
				System.out.println("Entered the data in the task location field.");
				ngDriver.waitForAngularRequestsToFinish();

				// scroll down the screen
				JavascriptExecutor js = (JavascriptExecutor) driver;
				js.executeScript("window.scrollBy(0,600)");

				// SELECT THE DUE DATE

				// click on the due date field
				click("task_duedatetxt_CSS");
				ngDriver.waitForAngularRequestsToFinish();
				System.out.println("Clicked on the due date field.");

				// wait for the element
				explicitWaitClickable("task_tasktag_newduedatetxt_todaybtn_XPATH");

				// click on the today button
				click("task_tasktag_newduedatetxt_todaybtn_XPATH");
				ngDriver.waitForAngularRequestsToFinish();
				System.out.println("Clicked on the year button.");

				// scroll down the screen
				js.executeScript("window.scrollBy(0,600)");

				// wait for the element
				explicitWait("task_addtask_moduledd_CSS");

				// select the application option from the module dropdown
				select("task_addtask_moduledd_CSS", data.get("task_module"));
				System.out.println("Selected the environmental option from the module dropdown.");
				ngDriver.waitForAngularRequestsToFinish();

				// click on the save button
				click("survey_task_savebtn_CSS");
				System.out.println("Clicked on the save button.");
				ngDriver.waitForAngularRequestsToFinish();

				// scroll up the screen
				js.executeScript("window.scrollBy(0,-400)");

				// click on the clear button
				click("task_createdtask_clearbtn_XPATH");
				ngDriver.waitForAngularRequestsToFinish();
				System.out.println("Clicked on the clear button.");

				// enter the data in the search field
				type("task_filter_CSS", data.get("task_title_2"));
				System.out.println("Entered the data in the search field.");
				ngDriver.waitForAngularRequestsToFinish();

				// click on the search button
				click("task_createdtask_searchbtn_XPATH");
				ngDriver.waitForAngularRequestsToFinish();
				System.out.println("Clicked on the search button.");

				// verify newly created task is displayed or not
				switchVerification("task_addedtask_psd2_XPATH", "Smoke Test PSD 2 Task Title",
						"The Smoke Test PSD 2 Task Title is not displayed.");

			} catch (Throwable t) {
				verificationFailed();
			}

			// click on the home icon from the top of the screen
			click("questionnaire_homeburgermenubtn_hide_CSS");
			ngDriver.waitForAngularRequestsToFinish();
			System.out.println("Clicked on the home icon from the top of the screen.");

			// wait for the element
			explicitWait("propertylist_title_XPATH");

			// verify the property list
			switchVerification("propertylist_title_XPATH", "Property List", "The property list is not displayed.");

			// VERIFY COUNT OF THE 30 DAYS OVERDUE TASK CARD - AFTER CREATED THE SECOND TASK WITH TODAY'S DUE DATE

			System.out.println(
					"***************** VERIFY COUNT OF THE 30 DAYS OVERDUE TASK CARD - AFTER CREATED THE SECOND TASK WITH TODAY'S DUE DATE *****************");
			test.log(LogStatus.INFO,
					"***************** VERIFY COUNT OF THE 30 DAYS OVERDUE TASK CARD - AFTER CREATED THE SECOND TASK WITH TODAY'S DUE DATE *****************");
			Reporter.log(
					"***************** VERIFY COUNT OF THE 30 DAYS OVERDUE TASK CARD - AFTER CREATED THE SECOND TASK WITH TODAY'S DUE DATE *****************");
			log.info(
					"***************** VERIFY COUNT OF THE 30 DAYS OVERDUE TASK CARD - AFTER CREATED THE SECOND TASK WITH TODAY'S DUE DATE *****************");

			try {

				// wait for the element
				Thread.sleep(5000);

				// click on the side menu button
				click("menubtn_CSS");
				ngDriver.waitForAngularRequestsToFinish();
				System.out.println("Clicked on the side menu button.");

				// wait for the element
				Thread.sleep(5000);

				// click on the portfolio summary option
				click("sidemenu_portfoliosummary_XPATH");
				ngDriver.waitForAngularRequestsToFinish();
				System.out.println("Clicked on the portfolio summary option.");

				// verify property count
				switchVerification("portfoliosummary_toppropertycount_XPATH", "4",
						"The property count is not displayed correctly.");

				// scroll down the screen
				JavascriptExecutor js = (JavascriptExecutor) driver;
				WebElement label1 = driver.findElement(By.xpath("portfoliosummary_30daysduedatelabel_XPATH"));
				js.executeScript("arguments[0].scrollIntoView(true);", label1);

				// verify percentage of the 30 days due date task
				switchVerification("portfoliosummary_30daysduedate_count1_XPATH", "100%",
						"The percentage of the 30 days due date task is displayed incorrect.");

				// verify count of the overdue tasks of the 30 days due date task
				switchVerification("portfoliosummary_30daysduedate_count2_XPATH", "1",
						"The count of the overdue tasks of the 30 days due date task is displayed incorrect.");

				// verify count of the all tasks of the 30 days due date task
				switchVerification("portfoliosummary_30daysduedate_count3_XPATH", "1",
						"The count of the all tasks of the 30 days due date task is displayed incorrect.");

//				// scroll down the screen
//				WebElement label2 = driver.findElement(By.xpath("portfoliosummary_31to90daysduedatelabel_XPATH"));
//				js.executeScript("arguments[0].scrollIntoView(true);", label2);
//
//				// verify percentage of the 31 to 90 days due date task
//				switchVerification("portfoliosummary_31to90daysduedate_count1_XPATH", "0%",
//						"The percentage of the 31 to 90 days due date task is displayed incorrect.");
//
//				// verify count of the overdue tasks of the 31 to 90 days due date task
//				switchVerification("portfoliosummary_31to90daysduedate_count2_XPATH", "0",
//						"The count of the overdue tasks of the 31 to 90 days due date task is displayed incorrect.");
//
//				// verify count of the all tasks of the 31 to 90 days due date task
//				switchVerification("portfoliosummary_31to90daysduedate_count3_XPATH", "0",
//						"The count of the all tasks of the 31 to 90 days due date task is displayed incorrect.");
//
//				// verify count of the more than 90 days overdue of the 31 to 90 days due date
//				// task
//				switchVerification("portfoliosummary_31to90daysduedate_count4_XPATH", "0",
//						"The count of the more than 90 days overdue of the 31 to 90 days due date task is displayed incorrect.");

			} catch (Throwable t) {
				verificationFailed();
			}

			// click on the home icon from the top of the screen
			click("questionnaire_homeburgermenubtn_hide_CSS");
			ngDriver.waitForAngularRequestsToFinish();
			System.out.println("Clicked on the home icon from the top of the screen.");

			// wait for the element
			explicitWait("propertylist_title_XPATH");

			// verify the property list
			switchVerification("propertylist_title_XPATH", "Property List", "The property list is not displayed.");

			// UPDATE THE DUE DATE OF THE SECOND TASK FROM TODAY TO PAST DATE - LESS THAN 30
			// DAYS

			System.out.println(
					"******************** UPDATE THE DUE DATE OF THE SECOND TASK FROM TODAY TO PAST DATE - LESS THAN 30 DAYS ********************");
			test.log(LogStatus.INFO,
					"******************** UPDATE THE DUE DATE OF THE SECOND TASK FROM TODAY TO PAST DATE - LESS THAN 30 DAYS ********************");
			Reporter.log(
					"******************** UPDATE THE DUE DATE OF THE SECOND TASK FROM TODAY TO PAST DATE - LESS THAN 30 DAYS ********************");
			log.info(
					"******************** UPDATE THE DUE DATE OF THE SECOND TASK FROM TODAY TO PAST DATE - LESS THAN 30 DAYS ********************");

			try {

				// enter the property name in the search field
				type("envreports_propertylist_filtertxt_CSS", data.get("property_1"));
				ngDriver.waitForAngularRequestsToFinish();
				System.out.println("Entered the property name in the search field.");

				// click on the task icon
				click("taskicon_CSS");
				System.out.println("Clicked on the task icon.");
				ngDriver.waitForAngularRequestsToFinish();

				// click on the clear button
				click("task_createdtask_clearbtn_XPATH");
				ngDriver.waitForAngularRequestsToFinish();
				System.out.println("Clicked on the clear button.");

				// enter the data in the search field
				type("task_filter_CSS", data.get("task_title_2"));
				System.out.println("Entered the data in the search field.");
				ngDriver.waitForAngularRequestsToFinish();

				// click on the search button
				click("task_createdtask_searchbtn_XPATH");
				ngDriver.waitForAngularRequestsToFinish();
				System.out.println("Clicked on the search button.");

				// verify newly created task is displayed or not
				switchVerification("task_addedtask_psd2_XPATH", "Smoke Test PSD 2 Task Title",
						"The Smoke Test PSD 2 Task Title is not displayed.");

				// click on the newly created task
				click("task_addedtask_psd2_XPATH");
				ngDriver.waitForAngularRequestsToFinish();
				System.out.println("Clicked on the newly created task.");

				// click on the change due date button
				click("task_tasktag_changeduedatebtn_CSS");
				ngDriver.waitForAngularRequestsToFinish();
				System.out.println("Clicked on the change due date button.");

				// enter date which is 3 days before current date
				LocalDate pastDate = LocalDate.now().minusDays(3);
				String finalPastDate = pastDate.toString();
				type("task_tasktag_changeduedate_newduedate_XPATH", finalPastDate);
				ngDriver.waitForAngularRequestsToFinish();
				System.out.println("Entered date which is 3 days before current date");

				// click on the new due date label
				click("task_tasktag_changeduedate_newduedatelbl_XPATH");
				ngDriver.waitForAngularRequestsToFinish();
				System.out.println("Clicked on the new due date label.");

				// enter data in the reason for change field
				clear("task_updateduedate_reasonforchangetxt_CSS");
				type("task_updateduedate_reasonforchangetxt_CSS", data.get("reason_for_change"));
				ngDriver.waitForAngularRequestsToFinish();
				System.out.println("Entered data in the reason for change field.");

				// click on the apply button
				click("task_updateduedate_applybtn_CSS");
				ngDriver.waitForAngularRequestsToFinish();
				System.out.println("Clicked on the apply button.");

				// scroll up the screen
				JavascriptExecutor js = (JavascriptExecutor) driver;
				js.executeScript("window.scrollBy(0,-500)");

				// click on the update button
				click("survey_task_updatebtn_CSS");
				ngDriver.waitForAngularRequestsToFinish();
				System.out.println("Clicked on the update button.");

				// wait for the element
				explicitWaitClickable("closetoastmsg_CSS");

				// click on the toaster close button
				click("closetoastmsg_CSS");
				ngDriver.waitForAngularRequestsToFinish();
				System.out.println("Clicked on the toaster close button.");

				// click on the back button
				click("task_backbtn_CSS");
				ngDriver.waitForAngularRequestsToFinish();
				System.out.println("Clicked on the back button.");

				// click on the clear button
				click("task_createdtask_clearbtn_XPATH");
				ngDriver.waitForAngularRequestsToFinish();
				System.out.println("Selected the newly created task.");

				// type the newly created task in the search field
				type("task_filter_CSS", data.get("task_title"));
				ngDriver.waitForAngularRequestsToFinish();
				System.out.println("Selected the newly created task.");

				// click on the search button
				click("task_createdtask_searchbtn_XPATH");
				ngDriver.waitForAngularRequestsToFinish();
				System.out.println("Clicked on the search button.");

				// verify newly created task is displayed or not
				switchVerification("task_addedtask_psd2_XPATH", "Smoke Test PSD 2 Task Title",
						"The Smoke Test PSD 2 Task Title is not displayed.");

			} catch (Throwable t) {
				verificationFailed();
			}

			// click on the home icon from the top of the screen
			click("questionnaire_homeburgermenubtn_hide_CSS");
			ngDriver.waitForAngularRequestsToFinish();
			System.out.println("Clicked on the home icon from the top of the screen.");

			// wait for the element
			explicitWait("propertylist_title_XPATH");

			// verify the property list
			switchVerification("propertylist_title_XPATH", "Property List", "The property list is not displayed.");

			// VERIFY COUNT OF THE 30 DAYS OVERDUE TASK CARDS - AFTER UPDATED THE DUE DATE OF THE SECOND TASK FROM TODAY TO PAST DATE - LESS THAN 30 DAYS

			System.out.println(
					"***************** VERIFY COUNT OF THE 30 DAYS OVERDUE TASK CARD - AFTER UPDATED THE DUE DATE OF THE SECOND TASK FROM TODAY TO PAST DATE - LESS THAN 30 DAYS *****************");
			test.log(LogStatus.INFO,
					"***************** VERIFY COUNT OF THE 30 DAYS OVERDUE TASK CARD - AFTER UPDATED THE DUE DATE OF THE SECOND TASK FROM TODAY TO PAST DATE - LESS THAN 30 DAYS *****************");
			Reporter.log(
					"***************** VERIFY COUNT OF THE 30 DAYS OVERDUE TASK CARD - AFTER UPDATED THE DUE DATE OF THE SECOND TASK FROM TODAY TO PAST DATE - LESS THAN 30 DAYS *****************");
			log.info(
					"***************** VERIFY COUNT OF THE 30 DAYS OVERDUE TASK CARD - AFTER UPDATED THE DUE DATE OF THE SECOND TASK FROM TODAY TO PAST DATE - LESS THAN 30 DAYS *****************");

			try {

				// wait for the element
				Thread.sleep(5000);

				// click on the side menu button
				click("menubtn_CSS");
				ngDriver.waitForAngularRequestsToFinish();
				System.out.println("Clicked on the side menu button.");

				// wait for the element
				Thread.sleep(5000);

				// click on the portfolio summary option
				click("sidemenu_portfoliosummary_XPATH");
				ngDriver.waitForAngularRequestsToFinish();
				System.out.println("Clicked on the portfolio summary option.");

				// verify property count
				switchVerification("portfoliosummary_toppropertycount_XPATH", "4",
						"The property count is not displayed correctly.");

				// scroll down the screen
				JavascriptExecutor js = (JavascriptExecutor) driver;
				WebElement label1 = driver.findElement(By.xpath("portfoliosummary_30daysduedatelabel_XPATH"));
				js.executeScript("arguments[0].scrollIntoView(true);", label1);

				// verify percentage of the 30 days due date task
				switchVerification("portfoliosummary_30daysduedate_count1_XPATH", "100%",
						"The percentage of the 30 days due date task is displayed incorrect.");

				// verify count of the overdue tasks of the 30 days due date task
				switchVerification("portfoliosummary_30daysduedate_count2_XPATH", "2",
						"The count of the overdue tasks of the 30 days due date task is displayed incorrect.");

				// verify count of the all tasks of the 30 days due date task
				switchVerification("portfoliosummary_30daysduedate_count3_XPATH", "2",
						"The count of the all tasks of the 30 days due date task is displayed incorrect.");

//				// scroll down the screen
//				WebElement label2 = driver.findElement(By.xpath("portfoliosummary_31to90daysduedatelabel_XPATH"));
//				js.executeScript("arguments[0].scrollIntoView(true);", label2);
//
//				// verify percentage of the 31 to 90 days due date task
//				switchVerification("portfoliosummary_31to90daysduedate_count1_XPATH", "0%",
//						"The percentage of the 31 to 90 days due date task is displayed incorrect.");
//
//				// verify count of the overdue tasks of the 31 to 90 days due date task
//				switchVerification("portfoliosummary_31to90daysduedate_count2_XPATH", "0",
//						"The count of the overdue tasks of the 31 to 90 days due date task is displayed incorrect.");
//
//				// verify count of the all tasks of the 31 to 90 days due date task
//				switchVerification("portfoliosummary_31to90daysduedate_count3_XPATH", "0",
//						"The count of the all tasks of the 31 to 90 days due date task is displayed incorrect.");
//
//				// verify count of the more than 90 days overdue of the 31 to 90 days due date
//				// task
//				switchVerification("portfoliosummary_31to90daysduedate_count4_XPATH", "0",
//						"The count of the more than 90 days overdue of the 31 to 90 days due date task is displayed incorrect.");

			} catch (Throwable t) {
				verificationFailed();
			}

			// click on the home icon from the top of the screen
			click("questionnaire_homeburgermenubtn_hide_CSS");
			ngDriver.waitForAngularRequestsToFinish();
			System.out.println("Clicked on the home icon from the top of the screen.");

			// wait for the element
			explicitWait("propertylist_title_XPATH");

			// verify the property list
			switchVerification("propertylist_title_XPATH", "Property List", "The property list is not displayed.");

			// VERIFY UPDATED DUE DATE IN THE TASK FROM THE PORTFOLIO SUMMARY DASHBOARD
			// SCREEN

			System.out.println(
					"***************** VERIFY UPDATED DUE DATE IN THE TASK FROM THE TASK LIST OF THE PORTFOLIO SUMMARY DASHBOARD SCREEN *****************");
			test.log(LogStatus.INFO,
					"***************** VERIFY UPDATED DUE DATE IN THE TASK FROM THE TASK LIST OF THE PORTFOLIO SUMMARY DASHBOARD SCREEN *****************");
			Reporter.log(
					"***************** VERIFY UPDATED DUE DATE IN THE TASK FROM THE TASK LIST OF THE PORTFOLIO SUMMARY DASHBOARD SCREEN *****************");
			log.info(
					"***************** VERIFY UPDATED DUE DATE IN THE TASK FROM THE TASK LIST OF THE PORTFOLIO SUMMARY DASHBOARD SCREEN *****************");

			try {

				// wait for the element
				Thread.sleep(5000);

				// click on the side menu button
				click("menubtn_CSS");
				ngDriver.waitForAngularRequestsToFinish();
				System.out.println("Clicked on the side menu button.");

				// wait for the element
				Thread.sleep(5000);

				// click on the portfolio summary option
				click("sidemenu_portfoliosummary_XPATH");
				ngDriver.waitForAngularRequestsToFinish();
				System.out.println("Clicked on the portfolio summary option.");

				// verify property count
				switchVerification("portfoliosummary_toppropertycount_XPATH", "4",
						"The property count is not displayed correctly.");

				// scroll down the screen
				JavascriptExecutor js = (JavascriptExecutor) driver;
				WebElement label1 = driver.findElement(By.xpath("portfoliosummary_30daysduedatelabel_XPATH"));
				js.executeScript("arguments[0].scrollIntoView(true);", label1);

				// verify percentage of the 30 days due date task
				switchVerification("portfoliosummary_30daysduedate_count1_XPATH", "100%",
						"The percentage of the 30 days due date task is displayed incorrect.");

				// enter the newly created first task in the search field
				clear("riskmanagement_task_searchtxt_XPATH");
				type("riskmanagement_task_searchtxt_XPATH", data.get("task_title_2"));
				ngDriver.waitForAngularRequestsToFinish();
				System.out.println("Entered the newly created first task in the search field.");

				try {
					// validate the due date is displayed correct or not
					LocalDate pastDate1 = LocalDate.now().minusDays(3);
					String finalPastDate1 = pastDate1.toString();
					String duedatetask1 = "//td[text()='" + data.get("task_title_2")
							+ "']//following-sibling::td[text()='" + finalPastDate1 + "']";
					String duedate1 = (driver.findElement(By.xpath(duedatetask1)).getText()).trim();

					if (duedate1.equals(finalPastDate1)) {

						System.out.println("The past due date is verified successfully.");
						test.log(LogStatus.INFO, "The past due date is verified successfully.");
						Reporter.log("The past due date is verified successfully.");
						log.info("The past due date is verified successfully.");
					} else {
						verificationFailed();

						System.out.println("The past due date is not displayed correct.");
						test.log(LogStatus.INFO, "The past due date is not displayed correct.");
						Reporter.log("The past due date is not displayed correct.");
						log.info("The past due date is not displayed correct.");

					}
				} catch (Throwable t) {
					verificationFailed();

					System.out.println("The past due date is not displayed correct.");
					test.log(LogStatus.INFO, "The past due date is not displayed correct.");
					Reporter.log("The past due date is not displayed correct.");
					log.info("The past due date is not displayed correct.");
				}

				// click on the searched task
				String task1 = "//td[text()='" + data.get("task_title_2") + "']";
				driver.findElement(By.xpath(task1)).click();
				ngDriver.waitForAngularRequestsToFinish();
				System.out.println("Clicked on the searched task.");

				// click on the change due date button
				click("task_tasktag_changeduedatebtn_CSS");
				ngDriver.waitForAngularRequestsToFinish();
				System.out.println("Clicked on the change due date button.");

				// enter date which is 5 days before current date
				LocalDate pastDate2 = LocalDate.now().minusDays(10);
				String finalPastDate2 = pastDate2.toString();
				type("task_tasktag_changeduedate_newduedate_XPATH", finalPastDate2);
				ngDriver.waitForAngularRequestsToFinish();
				System.out.println("Entered date which is 5 days before current date");

				// click on the new due date label
				click("task_tasktag_changeduedate_newduedatelbl_XPATH");
				ngDriver.waitForAngularRequestsToFinish();
				System.out.println("Clicked on the new due date label.");

				// enter data in the reason for change field
				clear("task_updateduedate_reasonforchangetxt_CSS");
				type("task_updateduedate_reasonforchangetxt_CSS", data.get("reason_for_change"));
				ngDriver.waitForAngularRequestsToFinish();
				System.out.println("Entered data in the reason for change field.");

				// click on the apply button
				click("task_updateduedate_applybtn_CSS");
				ngDriver.waitForAngularRequestsToFinish();
				System.out.println("Clicked on the apply button.");

				// scroll up the screen
				js.executeScript("window.scrollBy(0,-500)");

				// click on the update button
				click("survey_task_updatebtn_CSS");
				ngDriver.waitForAngularRequestsToFinish();
				System.out.println("Clicked on the update button.");

				// wait for the element
				explicitWaitClickable("closetoastmsg_CSS");

				// click on the toaster close button
				click("closetoastmsg_CSS");
				ngDriver.waitForAngularRequestsToFinish();
				System.out.println("Clicked on the toaster close button.");

				// enter the newly created first task in the search field
				clear("riskmanagement_task_searchtxt_XPATH");
				type("riskmanagement_task_searchtxt_XPATH", data.get("task_title_2"));
				ngDriver.waitForAngularRequestsToFinish();
				System.out.println("Entered the newly created first task in the search field.");

				try {
					// validate the due date is displayed correct or not
					LocalDate pastDate4 = LocalDate.now().minusDays(10);
					String finalPastDate4 = pastDate4.toString();
					String duedatetask4 = "//td[text()='" + data.get("task_title_2")
							+ "']//following-sibling::td[text()='" + finalPastDate4 + "']";
					String duedate4 = (driver.findElement(By.xpath(duedatetask4)).getText()).trim();

					if (duedate4.equals(finalPastDate4)) {

						System.out.println("The updated past due date is verified successfully.");
						test.log(LogStatus.INFO, "The updated past due date is verified successfully.");
						Reporter.log("The updated past due date is verified successfully.");
						log.info("The updated past due date is verified successfully.");
					} else {
						verificationFailed();

						System.out.println("The updated past due date is not displayed correct.");
						test.log(LogStatus.INFO, "The updated past due date is not displayed correct.");
						Reporter.log("The updated past due date is not displayed correct.");
						log.info("The updated past due date is not displayed correct.");

					}
				} catch (Throwable t) {
					verificationFailed();

					System.out.println("The updated past due date is not displayed correct.");
					test.log(LogStatus.INFO, "The updated past due date is not displayed correct.");
					Reporter.log("The updated past due date is not displayed correct.");
					log.info("The updated past due date is not displayed correct.");
				}

			} catch (Throwable t) {
				verificationFailed();
			}

			// click on the home icon from the top of the screen
			click("questionnaire_homeburgermenubtn_hide_CSS");
			ngDriver.waitForAngularRequestsToFinish();
			System.out.println("Clicked on the home icon from the top of the screen.");

			// wait for the element
			explicitWait("propertylist_title_XPATH");

			// verify the property list
			switchVerification("propertylist_title_XPATH", "Property List", "The property list is not displayed.");

			// VERIFY UPDATED DUE DATE IN THE TASK MODULE

			System.out.println("***************** VERIFY UPDATED DUE DATE IN THE TASK MODULE *****************");
			test.log(LogStatus.INFO, "***************** VERIFY UPDATED DUE DATE IN THE TASK MODULE *****************");
			Reporter.log("***************** VERIFY UPDATED DUE DATE IN THE TASK MODULE *****************");
			log.info("***************** VERIFY UPDATED DUE DATE IN THE TASK MODULE *****************");

			try {

				// enter the property name in the search field
				clear("envreports_propertylist_filtertxt_CSS");
				type("envreports_propertylist_filtertxt_CSS", data.get("property_1"));
				ngDriver.waitForAngularRequestsToFinish();
				System.out.println("Entered the property name in the search field.");

				// click on the task icon
				click("taskicon_CSS");
				System.out.println("Clicked on the task icon.");
				ngDriver.waitForAngularRequestsToFinish();

				// click on the clear button
				click("task_createdtask_clearbtn_XPATH");
				ngDriver.waitForAngularRequestsToFinish();
				System.out.println("Selected the newly created task.");

				// type the newly created task in the search field
				type("task_filter_CSS", data.get("task_title_2"));
				ngDriver.waitForAngularRequestsToFinish();
				System.out.println("Selected the newly created task.");

				// click on the search button
				click("task_createdtask_searchbtn_XPATH");
				ngDriver.waitForAngularRequestsToFinish();
				System.out.println("Clicked on the search button.");

				// verify newly created task is displayed or not
				switchVerification("task_addedtask_psd2_XPATH", "Smoke Test PSD 2 Task Title",
						"The Smoke Test PSD 2 Task Title is not displayed.");

				try {
					// verify the update due date of the first task
					LocalDate pastDate5 = LocalDate.now().minusDays(10);
					String finalPastDate5 = pastDate5.toString();
					String updatedDueDate5 = "//p[text()='" + data.get("task_title_2")
							+ "']//parent::td[@ng-click='editTaskFromLandingPage(task)']//following-sibling::td[text()='"
							+ finalPastDate5 + "']";

					if (updatedDueDate5.equals(finalPastDate5)) {

						System.out.println("The updated past due date is verified successfully.");
						test.log(LogStatus.INFO, "The updated past due date is verified successfully.");
						Reporter.log("The updated past due date is verified successfully.");
						log.info("The updated past due date is verified successfully.");
					} else {
						verificationFailed();

						System.out.println("The updated past due date is not displayed correct.");
						test.log(LogStatus.INFO, "The updated past due date is not displayed correct.");
						Reporter.log("The updated past due date is not displayed correct.");
						log.info("The updated past due date is not displayed correct.");

					}
				} catch (Throwable t) {
					verificationFailed();

					System.out.println("The updated past due date is not displayed correct.");
					test.log(LogStatus.INFO, "The updated past due date is not displayed correct.");
					Reporter.log("The updated past due date is not displayed correct.");
					log.info("The updated past due date is not displayed correct.");

				}

			} catch (Throwable t) {
				verificationFailed();
			}

			// click on the home icon from the top of the screen
			click("questionnaire_homeburgermenubtn_hide_CSS");
			ngDriver.waitForAngularRequestsToFinish();
			System.out.println("Clicked on the home icon from the top of the screen.");

			// wait for the element
			explicitWait("propertylist_title_XPATH");

			// verify the property list
			switchVerification("propertylist_title_XPATH", "Property List", "The property list is not displayed.");

			// UPDATE THE STATUS OF THE FIRST TASK TO COMPLETED

			System.out.println(
					"******************** UPDATE THE STATUS OF THE FIRST TASK TO COMPLETED ********************");
			test.log(LogStatus.INFO,
					"******************** UPDATE THE STATUS OF THE FIRST TASK TO COMPLETED ********************");
			Reporter.log("******************** UPDATE THE STATUS OF THE FIRST TASK TO COMPLETED ********************");
			log.info("******************** UPDATE THE STATUS OF THE FIRST TASK TO COMPLETED ********************");

			try {

				// enter the property name in the search field
				type("envreports_propertylist_filtertxt_CSS", data.get("property_1"));
				ngDriver.waitForAngularRequestsToFinish();
				System.out.println("Entered the property name in the search field.");

				// click on the task icon
				click("taskicon_CSS");
				System.out.println("Clicked on the task icon.");
				ngDriver.waitForAngularRequestsToFinish();

				// click on the clear button
				click("task_createdtask_clearbtn_XPATH");
				ngDriver.waitForAngularRequestsToFinish();
				System.out.println("Clicked on the clear button.");

				// enter the data in the search field
				type("task_filter_CSS", data.get("task_title"));
				System.out.println("Entered the data in the search field.");
				ngDriver.waitForAngularRequestsToFinish();

				// click on the search button
				click("task_createdtask_searchbtn_XPATH");
				ngDriver.waitForAngularRequestsToFinish();
				System.out.println("Clicked on the search button.");

				// verify newly created task is displayed or not
				switchVerification("task_addedtask_psd1_XPATH", "Smoke Test PSD 1 Task Title",
						"The Smoke Test PSD 1 Task Title is not displayed.");

				// click on the newly created task
				click("task_addedtask_psd1_XPATH");
				ngDriver.waitForAngularRequestsToFinish();
				System.out.println("Clicked on the newly created task.");

				// click on the start button
				click("propertyproject_mu_repair_startbtn_CSS");
				ngDriver.waitForAngularRequestsToFinish();
				System.out.println("Clicked on the start button.");

				// wait for the element
				explicitWaitClickable("closetoastmsg_CSS");

				// click on the toaster close button
				click("closetoastmsg_CSS");
				ngDriver.waitForAngularRequestsToFinish();
				System.out.println("Clicked on the toaster close button.");

				// scroll up the screen
				JavascriptExecutor js = (JavascriptExecutor) driver;
				js.executeScript("window.scrollBy(0,-400)");

				// verify the in-progress status is displayed or not
				switchVerification("task_inprogress_statuslbl_XPATH", "In Progress",
						"The In Progress status is not displayed.");

				// wait for the element
				explicitWaitClickable("task_closebtn_CSS");

				// click on the close button
				click("task_closebtn_CSS");
				ngDriver.waitForAngularRequestsToFinish();
				System.out.println("Clicked on the close button.");

				// wait for the element
				explicitWaitClickable("task_closebtn_yesbtn_CSS");

				// click on the yes button of confirmation popup model
				click("task_closebtn_yesbtn_CSS");
				ngDriver.waitForAngularRequestsToFinish();
				System.out.println("Clicked on the yes button of confirmation popup model.");

				// scroll up the screen
				js.executeScript("window.scrollBy(0,-400)");

				// verify the close status is displayed or not
				switchVerification("task_closedstatus_XPATH", "Closed", "The Closed status is not displayed.");

				// click on the update button
				click("survey_task_updatebtn_CSS");
				ngDriver.waitForAngularRequestsToFinish();
				System.out.println("Clicked on the update button.");

				// wait for the element
				explicitWaitClickable("closetoastmsg_CSS");

				// click on the toaster close button
				click("closetoastmsg_CSS");
				ngDriver.waitForAngularRequestsToFinish();
				System.out.println("Clicked on the toaster close button.");

				// click on the back button
				click("task_backbtn_CSS");
				ngDriver.waitForAngularRequestsToFinish();
				System.out.println("Clicked on the back button.");

			} catch (Throwable t) {
				verificationFailed();
			}

			// click on the home icon from the top of the screen
			click("questionnaire_homeburgermenubtn_hide_CSS");
			ngDriver.waitForAngularRequestsToFinish();
			System.out.println("Clicked on the home icon from the top of the screen.");

			// wait for the element
			explicitWait("propertylist_title_XPATH");

			// verify the property list
			switchVerification("propertylist_title_XPATH", "Property List", "The property list is not displayed.");

			// VERIFY COUNT OF THE 30 DAYS OVERDUE TASK CARD - AFTER CLOSE THE FIRST TASK

			System.out.println(
					"***************** VERIFY COUNT AND CLOSED TASK OF THE 30 DAYS OVERDUE TASK CARD - AFTER CLOSE THE FIRST TASK *****************");
			test.log(LogStatus.INFO,
					"***************** VERIFY COUNT AND CLOSED TASK OF THE 30 DAYS OVERDUE TASK CARD - AFTER CLOSE THE FIRST TASK *****************");
			Reporter.log(
					"***************** VERIFY COUNT AND CLOSED TASK OF THE 30 DAYS OVERDUE TASK CARD - AFTER CLOSE THE FIRST TASK *****************");
			log.info(
					"***************** VERIFY COUNT AND CLOSED TASK OF THE 30 DAYS OVERDUE TASK CARD - AFTER CLOSE THE FIRST TASK *****************");

			try {

				// wait for the element
				Thread.sleep(5000);

				// click on the side menu button
				click("menubtn_CSS");
				ngDriver.waitForAngularRequestsToFinish();
				System.out.println("Clicked on the side menu button.");

				// wait for the element
				Thread.sleep(5000);

				// click on the portfolio summary option
				click("sidemenu_portfoliosummary_XPATH");
				ngDriver.waitForAngularRequestsToFinish();
				System.out.println("Clicked on the portfolio summary option.");

				// verify property count
				switchVerification("portfoliosummary_toppropertycount_XPATH", "4",
						"The property count is not displayed correctly.");

				// scroll down the screen
				JavascriptExecutor js = (JavascriptExecutor) driver;
				WebElement label1 = driver.findElement(By.xpath("portfoliosummary_30daysduedatelabel_XPATH"));
				js.executeScript("arguments[0].scrollIntoView(true);", label1);

				// verify percentage of the 30 days due date task
				switchVerification("portfoliosummary_30daysduedate_count1_XPATH", "50%",
						"The percentage of the 30 days due date task is displayed incorrect.");

				// verify count of the overdue tasks of the 30 days due date task
				switchVerification("portfoliosummary_30daysduedate_count2_XPATH", "1",
						"The count of the overdue tasks of the 30 days due date task is displayed incorrect.");

				// verify count of the all tasks of the 30 days due date task
				switchVerification("portfoliosummary_30daysduedate_count3_XPATH", "2",
						"The count of the all tasks of the 30 days due date task is displayed incorrect.");

				// click on the percentage of the due date of less than 30 days
				click("portfoliosummary_30daysduedate_count1_XPATH");
				ngDriver.waitForAngularRequestsToFinish();
				System.out.println("Clicked on the percentage of the due date of less than 30 days.");

				// enter the newly created first task in the search field
				clear("riskmanagement_task_searchtxt_XPATH");
				type("riskmanagement_task_searchtxt_XPATH", data.get("task_title"));
				ngDriver.waitForAngularRequestsToFinish();
				System.out.println("Entered the newly created first task in the search field.");

				// verify first task
				deleteVerification("portfoliosummary_tasklist_task1_XPATH", "Smoke Test PSD 1 Task Title");

				// enter the newly created first task in the search field
				clear("riskmanagement_task_searchtxt_XPATH");
				type("riskmanagement_task_searchtxt_XPATH", data.get("task_title_2"));
				ngDriver.waitForAngularRequestsToFinish();
				System.out.println("Entered the newly created first task in the search field.");

				// verify second task
				switchVerification("portfoliosummary_tasklist_task2_XPATH", "Smoke Test PSD 2 Task Title",
						"The Smoke Test PSD 2 Task Title is not displayed.");

				// click on the back button
				click("portfoliosummary_tasklist_backbtn_XPATH");
				ngDriver.waitForAngularRequestsToFinish();
				System.out.println("Clicked on the back button.");

				// click on the count of the due date of less than 30 days
				click("portfoliosummary_30daysduedate_count2_XPATH");
				ngDriver.waitForAngularRequestsToFinish();
				System.out.println("Clicked on the count of the due date of less than 30 days.");

				// enter the newly created first task in the search field
				clear("riskmanagement_task_searchtxt_XPATH");
				type("riskmanagement_task_searchtxt_XPATH", data.get("task_title"));
				ngDriver.waitForAngularRequestsToFinish();
				System.out.println("Entered the newly created first task in the search field.");

				// verify first task
				deleteVerification("portfoliosummary_tasklist_task1_XPATH", "Smoke Test PSD 1 Task Title");

				// enter the newly created first task in the search field
				clear("riskmanagement_task_searchtxt_XPATH");
				type("riskmanagement_task_searchtxt_XPATH", data.get("task_title_2"));
				ngDriver.waitForAngularRequestsToFinish();
				System.out.println("Entered the newly created first task in the search field.");

				// verify second task
				switchVerification("portfoliosummary_tasklist_task2_XPATH", "Smoke Test PSD 2 Task Title",
						"The Smoke Test PSD 2 Task Title is not displayed.");

				// click on the back button
				click("portfoliosummary_tasklist_backbtn_XPATH");
				ngDriver.waitForAngularRequestsToFinish();
				System.out.println("Clicked on the back button.");

				// click on the count of the due date of less than 30 days
				click("portfoliosummary_30daysduedate_count3_XPATH");
				ngDriver.waitForAngularRequestsToFinish();
				System.out.println("Clicked on the count of the due date of less than 30 days.");

				// enter the newly created first task in the search field
				clear("riskmanagement_task_searchtxt_XPATH");
				type("riskmanagement_task_searchtxt_XPATH", data.get("task_title"));
				ngDriver.waitForAngularRequestsToFinish();
				System.out.println("Entered the newly created first task in the search field.");

				// verify first task
				deleteVerification("portfoliosummary_tasklist_task1_XPATH", "Smoke Test PSD 1 Task Title");

				// enter the newly created first task in the search field
				clear("riskmanagement_task_searchtxt_XPATH");
				type("riskmanagement_task_searchtxt_XPATH", data.get("task_title_2"));
				ngDriver.waitForAngularRequestsToFinish();
				System.out.println("Entered the newly created first task in the search field.");

				// verify second task
				switchVerification("portfoliosummary_tasklist_task2_XPATH", "Smoke Test PSD 2 Task Title",
						"The Smoke Test PSD 2 Task Title is not displayed.");

				// click on the back button
				click("portfoliosummary_tasklist_backbtn_XPATH");
				ngDriver.waitForAngularRequestsToFinish();
				System.out.println("Clicked on the back button.");

			} catch (Throwable t) {
				verificationFailed();
			}

			// click on the home icon from the top of the screen
			click("questionnaire_homeburgermenubtn_hide_CSS");
			ngDriver.waitForAngularRequestsToFinish();
			System.out.println("Clicked on the home icon from the top of the screen.");
			// wait for the element
			explicitWait("propertylist_title_XPATH");

			// verify the property list
			switchVerification("propertylist_title_XPATH", "Property List", "The property list is not displayed.");

			// =================================================================

			// reopen closed task and verify count in PSD
			// UPDATE DUE DATE WITH MORE THAN 30 DAYS AND MORE THAN 90 DAYS
			// DELETE ALL THE CREATED TASKS

			// =================================================================

			// CLOSE THE TASK AND VERIFY UPDATED DUE DATE IS DISPLAYED OR NOT

			System.out.println(
					"******************** CLOSE THE TASK AND VERIFY UPDATED DUE DATE IS DISPLAYED OR NOT ********************");
			test.log(LogStatus.INFO,
					"******************** CLOSE THE TASK AND VERIFY UPDATED DUE DATE IS DISPLAYED OR NOT ********************");
			Reporter.log(
					"******************** CLOSE THE TASK AND VERIFY UPDATED DUE DATE IS DISPLAYED OR NOT ********************");
			log.info(
					"******************** CLOSE THE TASK AND VERIFY UPDATED DUE DATE IS DISPLAYED OR NOT ********************");

			try {
                                 				
				// enter the property name in the search field
				type("envreports_propertylist_filtertxt_CSS", data.get("property_1"));
				ngDriver.waitForAngularRequestsToFinish();
				System.out.println("Entered the property name in the search field.");

				// click on the task icon
				click("taskicon_CSS");
				System.out.println("Clicked on the task icon.");
				ngDriver.waitForAngularRequestsToFinish();

				// click on the clear button
				click("task_createdtask_clearbtn_XPATH");
				ngDriver.waitForAngularRequestsToFinish();
				System.out.println("Clicked on the clear button.");

				// enter the data in the search field
				type("task_filter_CSS", data.get("task_title"));
				System.out.println("Entered the data in the search field.");
				ngDriver.waitForAngularRequestsToFinish();

				// click on the search button
				click("task_createdtask_searchbtn_XPATH");
				ngDriver.waitForAngularRequestsToFinish();
				System.out.println("Clicked on the search button.");

				// verify newly created task is displayed or not
				switchVerification("task_addedtask_smoke11_XPATH", "Smoke Test One Task Title",
						"The Smoke Test One Task Title is not displayed.");

				// click on the newly created task
				click("task_addedtask_smoke11_XPATH");
				ngDriver.waitForAngularRequestsToFinish();
				System.out.println("Clicked on the newly created task.");

				// wait for the element
				explicitWaitClickable("task_closebtn_CSS");

				// click on the close button
				click("task_closebtn_CSS");
				ngDriver.waitForAngularRequestsToFinish();
				System.out.println("Clicked on the close button.");

				// wait for the element
				explicitWaitClickable("task_closebtn_yesbtn_CSS");

				// click on the yes button of confirmation popup model
				click("task_closebtn_yesbtn_CSS");
				ngDriver.waitForAngularRequestsToFinish();
				System.out.println("Clicked on the yes button of confirmation popup model.");

				// scroll up the screen
				JavascriptExecutor js = (JavascriptExecutor) driver;
				js.executeScript("window.scrollBy(0,-400)");

				// verify the close status is displayed or not
				switchVerification("task_closedstatus_XPATH", "Closed", "The Closed status is not displayed.");

				// click on the back button
				click("task_backbtn_CSS");
				ngDriver.waitForAngularRequestsToFinish();
				System.out.println("Clicked on the back button.");

				// select the close option from the status drop down
				select("survey_task_closefilter_CSS", data.get("task_closed_status"));
				ngDriver.waitForAngularRequestsToFinish();
				System.out.println("Selected the close option from the status drop down.");

				// click on the clear button
				click("task_createdtask_clearbtn_XPATH");
				ngDriver.waitForAngularRequestsToFinish();
				System.out.println("Selected the newly created task.");

				// type the newly created task in the search field
				type("task_filter_CSS", data.get("task_title"));
				ngDriver.waitForAngularRequestsToFinish();
				System.out.println("Selected the newly created task.");

				// click on the search button
				click("task_createdtask_searchbtn_XPATH");
				ngDriver.waitForAngularRequestsToFinish();
				System.out.println("Clicked on the search button.");

				switchVerification("task_addedtask_smoke11_XPATH", "Smoke Test One Task Title",
						"The Smoke Test One Task Title is not displayed.");

				// VERIFY THE DUE DATE IS DISPLAYED CORRECT OR NOT ON CLOSED TASK LIST

				System.out.println(
						"******************** VERIFY THE DUE DATE IS DISPLAYED CORRECT OR NOT ON CLOSED TASK LIST ********************");
				test.log(LogStatus.INFO,
						"******************** VERIFY THE DUE DATE IS DISPLAYED CORRECT OR NOT ON CLOSED TASK LIST ********************");
				Reporter.log(
						"******************** VERIFY THE DUE DATE IS DISPLAYED CORRECT OR NOT ON CLOSED TASK LIST ********************");
				log.info(
						"******************** VERIFY THE DUE DATE IS DISPLAYED CORRECT OR NOT ON CLOSED TASK LIST ********************");

				try {
					LocalDate currentDate = LocalDate.now();

					String expectedCurrentDate = currentDate.toString();

					String currentDateXpath = "//td[text()='" + currentDate + "']";

					String finalCurrentDate = driver.findElement(By.xpath(currentDateXpath)).getText();

					System.out.println("//////////////////////////////// EXPECTED" + expectedCurrentDate);
					System.out.println("//////////////////////////////// ACTUAL" + finalCurrentDate);

					if (expectedCurrentDate.equals(finalCurrentDate)) {

						System.out.println("THE DUE DATE IS DISPLAYED CORRECTLY ON CLOSED TASK LIST AS EXPECTED.");
						test.log(LogStatus.INFO,
								"THE DUE DATE IS DISPLAYED CORRECTLY ON CLOSED TASK LIST AS EXPECTED.");
						Reporter.log("THE DUE DATE IS DISPLAYED CORRECTLY ON CLOSED TASK LIST AS EXPECTED.");
						log.info("THE DUE DATE IS DISPLAYED CORRECTLY ON CLOSED TASK LIST AS EXPECTED.");

					} else {
						TestUtil.captureScreenshot();

						// ReportNG
						Reporter.log("<br>" + "The due date is displayed incorrect on closed task list." + "<br>");
						Reporter.log("<a target=\"_blank\" href=" + TestUtil.screenshotName + "><img src="
								+ TestUtil.screenshotName + " height=200 width=200></img></a>");
						Reporter.log("<br>");
						Reporter.log("<br>");

						// Extent Report
						test.log(LogStatus.FAIL, " The due date is displayed incorrect on closed task list. : ");
						test.log(LogStatus.FAIL, test.addScreenCapture(TestUtil.screenshotName));

						System.out.println("The due date is displayed incorrect on closed task list.");
						log.info("The due date is displayed incorrect on closed task list.");
					}

				} catch (Throwable t) {
					TestUtil.captureScreenshot();

					// ReportNG
					Reporter.log("<br>" + "The due date is displayed incorrect on closed task list." + "<br>");
					Reporter.log("<a target=\"_blank\" href=" + TestUtil.screenshotName + "><img src="
							+ TestUtil.screenshotName + " height=200 width=200></img></a>");
					Reporter.log("<br>");
					Reporter.log("<br>");

					// Extent Report
					test.log(LogStatus.FAIL, " The due date is displayed incorrect on closed task list. : ");
					test.log(LogStatus.FAIL, test.addScreenCapture(TestUtil.screenshotName));

					System.out.println("The due date is displayed incorrect on closed task list.");
					log.info("The due date is displayed incorrect on closed task list.");
				}

				// select the close option from the status drop down
				select("survey_task_closefilter_CSS", data.get("task_active_status"));
				ngDriver.waitForAngularRequestsToFinish();
				System.out.println("Selected the close option from the status drop down.");

				// click on the clear button
				click("task_createdtask_clearbtn_XPATH");
				ngDriver.waitForAngularRequestsToFinish();
				System.out.println("Selected the newly created task.");

				// type the newly created task in the search field
				type("task_filter_CSS", data.get("task_title"));
				ngDriver.waitForAngularRequestsToFinish();
				System.out.println("Selected the newly created task.");

				// click on the search button
				click("task_createdtask_searchbtn_XPATH");
				ngDriver.waitForAngularRequestsToFinish();
				System.out.println("Clicked on the search button.");

				switchVerification("task_addedtask_smoke11_XPATH", "Smoke Test One Task Title",
						"The Smoke Test One Task Title is not displayed.");

				// VERIFY THE DUE DATE IS DISPLAYED CORRECT OR NOT ON ACTIVE TASK LIST

				System.out.println(
						"******************** VERIFY THE DUE DATE IS DISPLAYED CORRECT OR NOT ON ACTIVE TASK LIST ********************");
				test.log(LogStatus.INFO,
						"******************** VERIFY THE DUE DATE IS DISPLAYED CORRECT OR NOT ON ACTIVE TASK LIST ********************");
				Reporter.log(
						"******************** VERIFY THE DUE DATE IS DISPLAYED CORRECT OR NOT ON ACTIVE TASK LIST ********************");
				log.info(
						"******************** VERIFY THE DUE DATE IS DISPLAYED CORRECT OR NOT ON ACTIVE TASK LIST ********************");

				try {
					LocalDate futureDate = LocalDate.now().plusMonths(1);

					String expectedFutureDate = futureDate.toString();

					String futureDateXpath = "//td[text()='" + futureDate + "']";

					String finalFutureDate = driver.findElement(By.xpath(futureDateXpath)).getText();

					System.out.println("//////////////////////////////// EXPECTED" + expectedFutureDate);
					System.out.println("//////////////////////////////// ACTUAL" + finalFutureDate);

					if (expectedFutureDate.equals(finalFutureDate)) {

						System.out.println("THE DUE DATE IS DISPLAYED CORRECTLY ON ACTIVE TASK LIST AS EXPECTED.");
						test.log(LogStatus.INFO,
								"THE DUE DATE IS DISPLAYED CORRECTLY ON ACTIVE TASK LIST AS EXPECTED.");
						Reporter.log("THE DUE DATE IS DISPLAYED CORRECTLY ON ACTIVE TASK LIST AS EXPECTED.");
						log.info("THE DUE DATE IS DISPLAYED CORRECTLY ON ACTIVE TASK LIST AS EXPECTED.");

					} else {
						TestUtil.captureScreenshot();

						// ReportNG
						Reporter.log("<br>" + "The due date is displayed incorrect on active task list." + "<br>");
						Reporter.log("<a target=\"_blank\" href=" + TestUtil.screenshotName + "><img src="
								+ TestUtil.screenshotName + " height=200 width=200></img></a>");
						Reporter.log("<br>");
						Reporter.log("<br>");

						// Extent Report
						test.log(LogStatus.FAIL, " The due date is displayed incorrect on active task list. : ");
						test.log(LogStatus.FAIL, test.addScreenCapture(TestUtil.screenshotName));

						System.out.println("The due date is displayed incorrect on active task list.");
						log.info("The due date is displayed incorrect on active task list.");
					}

				} catch (Throwable t) {
					TestUtil.captureScreenshot();

					// ReportNG
					Reporter.log("<br>" + "The due date is displayed incorrect on active task list." + "<br>");
					Reporter.log("<a target=\"_blank\" href=" + TestUtil.screenshotName + "><img src="
							+ TestUtil.screenshotName + " height=200 width=200></img></a>");
					Reporter.log("<br>");
					Reporter.log("<br>");

					// Extent Report
					test.log(LogStatus.FAIL, " The due date is displayed incorrect on active task list. : ");
					test.log(LogStatus.FAIL, test.addScreenCapture(TestUtil.screenshotName));

					System.out.println("The due date is displayed incorrect on active task list.");
					log.info("The due date is displayed incorrect on active task list.");
				}

			} catch (Throwable t) {
				verificationFailed();
			}

			// click on the home icon from the top of the screen
			click("questionnaire_homeburgermenubtn_hide_CSS");
			ngDriver.waitForAngularRequestsToFinish();
			System.out.println("Clicked on the home icon from the top of the screen.");

			// wait for the element
			explicitWait("propertylist_title_XPATH");

			// verify the property list
			switchVerification("propertylist_title_XPATH", "Property List", "The property list is not displayed.");

			// UPDATE THE DUE DATE OF THE TASK

			System.out.println("******************** UPDATE THE DUE DATE OF THE TASK ********************");
			test.log(LogStatus.INFO, "******************** UPDATE THE DUE DATE OF THE TASK ********************");
			Reporter.log("******************** UPDATE THE DUE DATE OF THE TASK ********************");
			log.info("******************** UPDATE THE DUE DATE OF THE TASK ********************");

			try {

				// enter the property name in the search field
				type("envreports_propertylist_filtertxt_CSS", data.get("property_1"));
				ngDriver.waitForAngularRequestsToFinish();
				System.out.println("Entered the property name in the search field.");

				// click on the task icon
				click("taskicon_CSS");
				System.out.println("Clicked on the task icon.");
				ngDriver.waitForAngularRequestsToFinish();

				// click on the clear button
				click("task_createdtask_clearbtn_XPATH");
				ngDriver.waitForAngularRequestsToFinish();
				System.out.println("Clicked on the clear button.");

				// enter the data in the search field
				type("task_filter_CSS", data.get("task_title"));
				System.out.println("Entered the data in the search field.");
				ngDriver.waitForAngularRequestsToFinish();

				// click on the search button
				click("task_createdtask_searchbtn_XPATH");
				ngDriver.waitForAngularRequestsToFinish();
				System.out.println("Clicked on the search button.");

				// verify newly created task is displayed or not
				switchVerification("task_addedtask_smoke11_XPATH", "Smoke Test One Task Title",
						"The Smoke Test One Task Title is not displayed.");

				// click on the newly created task
				click("task_addedtask_smoke11_XPATH");
				ngDriver.waitForAngularRequestsToFinish();
				System.out.println("Clicked on the newly created task.");

				// click on the change due date button
				click("task_tasktag_changeduedatebtn_CSS");
				ngDriver.waitForAngularRequestsToFinish();
				System.out.println("Clicked on the change due date button.");

				// enter date which is 2 days before current date

				LocalDate pastDate = LocalDate.now().minusDays(2);

				String finalPastDate = pastDate.toString();

				System.out.println("//////////////////////////////// ACTUAL" + finalPastDate);

				type("task_tasktag_changeduedate_newduedate_XPATH", finalPastDate);
				ngDriver.waitForAngularRequestsToFinish();
				System.out.println("Entered date which is 2 days before current date");

				// click on the new due date label
				click("task_tasktag_changeduedate_newduedatelbl_XPATH");
				ngDriver.waitForAngularRequestsToFinish();
				System.out.println("Clicked on the new due date label.");

				// enter data in the reason for change field
				type("task_updateduedate_reasonforchangetxt_CSS", data.get("reason_for_change"));
				ngDriver.waitForAngularRequestsToFinish();
				System.out.println("Entered data in the reason for change field.");

				// click on the reschedule checkbox
				click("task_updateduedate_rescheduleckbx_CSS");
				ngDriver.waitForAngularRequestsToFinish();
				System.out.println("Clicked on the reschedule checkbox.");

				// click on the apply button
				click("task_updateduedate_applybtn_CSS");
				ngDriver.waitForAngularRequestsToFinish();
				System.out.println("Clicked on the apply button.");

				// scroll up the screen
				JavascriptExecutor js = (JavascriptExecutor) driver;
				js.executeScript("window.scrollBy(0,-500)");

				// enter the data in the task title field
				clear("task_addtask_titletxt_CSS");
				ngDriver.waitForAngularRequestsToFinish();
				System.out.println("Clear the title field.");
				type("task_addtask_titletxt_CSS", data.get("task_title_updated"));
				ngDriver.waitForAngularRequestsToFinish();
				System.out.println("Entered the data in the task title field.");

				// click on the update button
				click("survey_task_updatebtn_CSS");
				ngDriver.waitForAngularRequestsToFinish();
				System.out.println("Clicked on the update button.");

				// wait for the element
				explicitWaitClickable("closetoastmsg_CSS");

				// click on the toaster close button
				click("closetoastmsg_CSS");
				ngDriver.waitForAngularRequestsToFinish();
				System.out.println("Clicked on the toaster close button.");

				// click on the back button
				click("task_backbtn_CSS");
				ngDriver.waitForAngularRequestsToFinish();
				System.out.println("Clicked on the back button.");

				// click on the clear button
				click("task_createdtask_clearbtn_XPATH");
				ngDriver.waitForAngularRequestsToFinish();
				System.out.println("Selected the newly created task.");

				// type the newly created task in the search field
				type("task_filter_CSS", data.get("task_title_updated"));
				ngDriver.waitForAngularRequestsToFinish();
				System.out.println("Selected the newly created task.");

				// click on the search button
				click("task_createdtask_searchbtn_XPATH");
				ngDriver.waitForAngularRequestsToFinish();
				System.out.println("Clicked on the search button.");

				switchVerification("task_addedtask_smoke111_XPATH", "Smoke Test One Task Title After Due Date Update",
						"The Smoke Test One Task Title After Due Date Update is not displayed.");

			} catch (Throwable t) {
				verificationFailed();
			}

			// click on the home icon from the top of the screen
			click("questionnaire_homeburgermenubtn_hide_CSS");
			ngDriver.waitForAngularRequestsToFinish();
			System.out.println("Clicked on the home icon from the top of the screen.");

			// wait for the element
			explicitWait("propertylist_title_XPATH");

			// verify the property list
			switchVerification("propertylist_title_XPATH", "Property List", "The property list is not displayed.");

			// CLOSE THE TASK AFTER UPDATE THE DUE DATE AND VERIFY UPDATED DUE DATE IS
			// DISPLAYED OR NOT

			System.out.println(
					"******************** CLOSE THE TASK AFTER UPDATE THE DUE DATE AND VERIFY UPDATED DUE DATE IS DISPLAYED OR NOT ********************");
			test.log(LogStatus.INFO,
					"******************** CLOSE THE TASK AFTER UPDATE THE DUE DATE AND VERIFY UPDATED DUE DATE IS DISPLAYED OR NOT ********************");
			Reporter.log(
					"******************** CLOSE THE TASK AFTER UPDATE THE DUE DATE AND VERIFY UPDATED DUE DATE IS DISPLAYED OR NOT ********************");
			log.info(
					"******************** CLOSE THE TASK AFTER UPDATE THE DUE DATE AND VERIFY UPDATED DUE DATE IS DISPLAYED OR NOT ********************");

			try {

				// enter the property name in the search field
				type("envreports_propertylist_filtertxt_CSS", data.get("property_1"));
				ngDriver.waitForAngularRequestsToFinish();
				System.out.println("Entered the property name in the search field.");

				// click on the task icon
				click("taskicon_CSS");
				System.out.println("Clicked on the task icon.");
				ngDriver.waitForAngularRequestsToFinish();

				// click on the clear button
				click("task_createdtask_clearbtn_XPATH");
				ngDriver.waitForAngularRequestsToFinish();
				System.out.println("Clicked on the clear button.");

				// enter the data in the search field
				type("task_filter_CSS", data.get("task_title"));
				System.out.println("Entered the data in the search field.");
				ngDriver.waitForAngularRequestsToFinish();

				// click on the search button
				click("task_createdtask_searchbtn_XPATH");
				ngDriver.waitForAngularRequestsToFinish();
				System.out.println("Clicked on the search button.");

				// verify newly created task is displayed or not
				switchVerification("task_addedtask_smoke111_XPATH", "Smoke Test One Task Title After Due Date Update",
						"The Smoke Test One Task Title After Due Date Update is not displayed.");

				// click on the newly created task
				click("task_addedtask_smoke111_XPATH");
				ngDriver.waitForAngularRequestsToFinish();
				System.out.println("Clicked on the newly created task.");

				// click on the close button
				click("task_closebtn_CSS");
				ngDriver.waitForAngularRequestsToFinish();
				System.out.println("Clicked on the close button.");

				// click on the yes button of confirmation popup model
				click("task_closebtn_yesbtn_CSS");
				ngDriver.waitForAngularRequestsToFinish();
				System.out.println("Clicked on the yes button of confirmation popup model.");

				// scroll up the screen
				JavascriptExecutor js = (JavascriptExecutor) driver;
				js.executeScript("window.scrollBy(0,-400)");

				// verify the close status is displayed or not
				switchVerification("task_closedstatus_XPATH", "Closed", "The Closed status is not displayed.");

				// click on the back button
				click("task_backbtn_CSS");
				ngDriver.waitForAngularRequestsToFinish();
				System.out.println("Clicked on the back button.");

				// select the close option from the status drop down
				select("survey_task_closefilter_CSS", data.get("task_closed_status"));
				ngDriver.waitForAngularRequestsToFinish();
				System.out.println("Selected the close option from the status drop down.");

				// click on the clear button
				click("task_createdtask_clearbtn_XPATH");
				ngDriver.waitForAngularRequestsToFinish();
				System.out.println("Selected the newly created task.");

				// type the newly created task in the search field
				type("task_filter_CSS", data.get("task_title_updated"));
				ngDriver.waitForAngularRequestsToFinish();
				System.out.println("Selected the newly created task.");

				// click on the search button
				click("task_createdtask_searchbtn_XPATH");
				ngDriver.waitForAngularRequestsToFinish();
				System.out.println("Clicked on the search button.");

				switchVerification("task_addedtask_smoke111_XPATH", "Smoke Test One Task Title After Due Date Update",
						"The Smoke Test One Task Title After Due Date Update is not displayed.");

				// VERIFY THE DUE DATE IS DISPLAYED CORRECT OR NOT ON THE CLOSED TASK LIST

				System.out.println(
						"******************** VERIFY THE DUE DATE IS DISPLAYED CORRECT OR NOT ON THE CLOSED TASK LIST ********************");
				test.log(LogStatus.INFO,
						"******************** VERIFY THE DUE DATE IS DISPLAYED CORRECT OR NOT ON THE CLOSED TASK LIST ********************");
				Reporter.log(
						"******************** VERIFY THE DUE DATE IS DISPLAYED CORRECT OR NOT ON THE CLOSED TASK LIST ********************");
				log.info(
						"******************** VERIFY THE DUE DATE IS DISPLAYED CORRECT OR NOT ON THE CLOSED TASK LIST ********************");

				try {
					LocalDate updatedDueDate = LocalDate.now().minusDays(2);

					String expectedUpdatedDueDate = updatedDueDate.toString();

					String updatedDueDateXpath = "//td[text()='" + updatedDueDate + "']";

					String finalUpdateDueDate = driver.findElement(By.xpath(updatedDueDateXpath)).getText();

					System.out.println("//////////////////////////////// EXPECTED" + expectedUpdatedDueDate);
					System.out.println("//////////////////////////////// ACTUAL" + finalUpdateDueDate);

					if (expectedUpdatedDueDate.equals(finalUpdateDueDate)) {

						System.out.println(
								"THE DUE DATE IS DISPLAYED CORRECTLY AFTER UPDATED THE DUE DATE ON CLOSED TASK LIST AS EXPECTED.");
						test.log(LogStatus.INFO,
								"THE DUE DATE IS DISPLAYED CORRECTLY AFTER UPDATED THE DUE DATE ON CLOSED TASK LIST AS EXPECTED.");
						Reporter.log(
								"THE DUE DATE IS DISPLAYED CORRECTLY AFTER UPDATED THE DUE DATE ON CLOSED TASK LIST AS EXPECTED.");
						log.info(
								"THE DUE DATE IS DISPLAYED CORRECTLY AFTER UPDATED THE DUE DATE ON CLOSED TASK LIST AS EXPECTED.");

					} else {
						TestUtil.captureScreenshot();

						// ReportNG
						Reporter.log("<br>"
								+ "The due date is displayed incorrect after updated the due date on closed task list."
								+ "<br>");
						Reporter.log("<a target=\"_blank\" href=" + TestUtil.screenshotName + "><img src="
								+ TestUtil.screenshotName + " height=200 width=200></img></a>");
						Reporter.log("<br>");
						Reporter.log("<br>");

						// Extent Report
						test.log(LogStatus.FAIL,
								" The due date is displayed incorrect after updated the due date on closed task list. : ");
						test.log(LogStatus.FAIL, test.addScreenCapture(TestUtil.screenshotName));

						System.out.println(
								"The due date is displayed incorrect after updated the due date on closed task list.");
						log.info("The due date is displayed incorrect after updated the due date on closed task list.");
					}

				} catch (Throwable t) {
					TestUtil.captureScreenshot();

					// ReportNG
					Reporter.log("<br>"
							+ "The due date is displayed incorrect after updated the due date on closed task list."
							+ "<br>");
					Reporter.log("<a target=\"_blank\" href=" + TestUtil.screenshotName + "><img src="
							+ TestUtil.screenshotName + " height=200 width=200></img></a>");
					Reporter.log("<br>");
					Reporter.log("<br>");

					// Extent Report
					test.log(LogStatus.FAIL,
							" The due date is displayed incorrect after updated the due date on closed task list. : ");
					test.log(LogStatus.FAIL, test.addScreenCapture(TestUtil.screenshotName));

					System.out.println(
							"The due date is displayed incorrect after updated the due date on closed task list.");
					log.info("The due date is displayed incorrect after updated the due date on closed task list.");
				}

				// select the active option from the status drop down
				select("survey_task_closefilter_CSS", data.get("task_active_status"));
				ngDriver.waitForAngularRequestsToFinish();
				System.out.println("Selected the close option from the status drop down.");

				// click on the clear button
				click("task_createdtask_clearbtn_XPATH");
				ngDriver.waitForAngularRequestsToFinish();
				System.out.println("Selected the newly created task.");

				// type the newly created task in the search field
				type("task_filter_CSS", data.get("task_title"));
				ngDriver.waitForAngularRequestsToFinish();
				System.out.println("Selected the newly created task.");

				// click on the search button
				click("task_createdtask_searchbtn_XPATH");
				ngDriver.waitForAngularRequestsToFinish();
				System.out.println("Clicked on the search button.");

				switchVerification("task_addedtask_smoke111_XPATH", "Smoke Test One Task Title After Due Date Update",
						"The Smoke Test One Task Title After Due Date Update is not displayed.");

				// VERIFY THE DUE DATE IS DISPLAYED CORRECT OR NOT ON THE ACTIVE TASK LIST

				System.out.println(
						"******************** VERIFY THE DUE DATE IS DISPLAYED CORRECT OR NOT ON THE ACTIVE TASK LIST ********************");
				test.log(LogStatus.INFO,
						"******************** VERIFY THE DUE DATE IS DISPLAYED CORRECT OR NOT ON THE ACTIVE TASK LIST ********************");
				Reporter.log(
						"******************** VERIFY THE DUE DATE IS DISPLAYED CORRECT OR NOT ON THE ACTIVE TASK LIST ********************");
				log.info(
						"******************** VERIFY THE DUE DATE IS DISPLAYED CORRECT OR NOT ON THE ACTIVE TASK LIST ********************");

				try {
					LocalDate updatedFutureDate = LocalDate.now().minusDays(2);

					LocalDate updatedPastFutureDate = updatedFutureDate.plusMonths(1);

					String expectedUpdatedFutureDate = updatedPastFutureDate.toString();

					String updatedFutureDateXpath = "//td[text()='" + updatedPastFutureDate + "']";

					String finalUpdatedFutureDate = driver.findElement(By.xpath(updatedFutureDateXpath)).getText();

					System.out.println("//////////////////////////////// EXPECTED" + expectedUpdatedFutureDate);
					System.out.println("//////////////////////////////// ACTUAL" + finalUpdatedFutureDate);

					if (expectedUpdatedFutureDate.equals(finalUpdatedFutureDate)) {

						System.out.println(
								"THE DUE DATE IS DISPLAYED CORRECTLY AFTER UPDATED THE DUE DATE ON ACTIVE TASK LIST AS EXPECTED.");
						test.log(LogStatus.INFO,
								"THE DUE DATE IS DISPLAYED CORRECTLY AFTER UPDATED THE DUE DATE ON ACTIVE TASK LIST AS EXPECTED.");
						Reporter.log(
								"THE DUE DATE IS DISPLAYED CORRECTLY AFTER UPDATED THE DUE DATE ON ACTIVE TASK LIST AS EXPECTED.");
						log.info(
								"THE DUE DATE IS DISPLAYED CORRECTLY AFTER UPDATED THE DUE DATE ON ACTIVE TASK LIST AS EXPECTED.");

					} else {
						TestUtil.captureScreenshot();

						// ReportNG
						Reporter.log("<br>"
								+ "The due date is displayed incorrect after updated the due date on active task list."
								+ "<br>");
						Reporter.log("<a target=\"_blank\" href=" + TestUtil.screenshotName + "><img src="
								+ TestUtil.screenshotName + " height=200 width=200></img></a>");
						Reporter.log("<br>");
						Reporter.log("<br>");

						// Extent Report
						test.log(LogStatus.FAIL,
								" The due date is displayed incorrect after updated the due date on active task list. : ");
						test.log(LogStatus.FAIL, test.addScreenCapture(TestUtil.screenshotName));

						System.out.println("The due date is displayed incorrect on active task list.");
						log.info("The due date is displayed incorrect on active task list.");
					}

				} catch (Throwable t) {
					TestUtil.captureScreenshot();

					// ReportNG
					Reporter.log("<br>"
							+ "The due date is displayed incorrect after updated the due date on active task list."
							+ "<br>");
					Reporter.log("<a target=\"_blank\" href=" + TestUtil.screenshotName + "><img src="
							+ TestUtil.screenshotName + " height=200 width=200></img></a>");
					Reporter.log("<br>");
					Reporter.log("<br>");

					// Extent Report
					test.log(LogStatus.FAIL,
							" The due date is displayed incorrect after updated the due date on active task list. : ");
					test.log(LogStatus.FAIL, test.addScreenCapture(TestUtil.screenshotName));

					System.out.println(
							"The due date is displayed incorrect after updated the due date on active task list.");
					log.info("The due date is displayed incorrect after updated the due date on active task list.");
				}

			} catch (Throwable t) {
				verificationFailed();
			}

			// click on the home icon from the top of the screen
			click("questionnaire_homeburgermenubtn_hide_CSS");
			ngDriver.waitForAngularRequestsToFinish();
			System.out.println("Clicked on the home icon from the top of the screen.");

			// wait for the element
			explicitWait("propertylist_title_XPATH");

			// verify the property list
			switchVerification("propertylist_title_XPATH", "Property List", "The property list is not displayed.");

			// DELETE THE NEWLY CREATED SECOND TASK FROM THE ACTIVE TASK LIST

			System.out.println(
					"**************** DELETE THE NEWLY CREATED SECOND TASK FROM THE ACTIVE TASK LIST ****************");
			test.log(LogStatus.INFO,
					"**************** DELETE THE NEWLY CREATED SECOND TASK FROM THE ACTIVE TASK LIST ****************");
			Reporter.log(
					"**************** DELETE THE NEWLY CREATED SECOND TASK FROM THE ACTIVE TASK LIST ****************");
			log.info(
					"**************** DELETE THE NEWLY CREATED SECOND TASK FROM THE ACTIVE TASK LIST ****************");

			try {
				// enter the property name in the search field
				type("envreports_propertylist_filtertxt_CSS", data.get("property_1"));
				ngDriver.waitForAngularRequestsToFinish();
				System.out.println("Entered the property name in the search field.");

				// click on the task icon
				click("taskicon_CSS");
				System.out.println("Clicked on the task icon.");
				ngDriver.waitForAngularRequestsToFinish();

				// click on the clear button
				click("task_createdtask_clearbtn_XPATH");
				ngDriver.waitForAngularRequestsToFinish();
				System.out.println("Selected the newly created task.");

				// type the newly created task in the search field
				type("task_filter_CSS", data.get("task_title_updated"));
				ngDriver.waitForAngularRequestsToFinish();
				System.out.println("Selected the newly created task.");

				// click on the search button
				click("task_createdtask_searchbtn_XPATH");
				ngDriver.waitForAngularRequestsToFinish();
				System.out.println("Clicked on the search button.");

				// click on the newly created task
				click("task_addedtask_smoke111_XPATH");
				ngDriver.waitForAngularRequestsToFinish();
				System.out.println("Clicked on the newly created task.");

				// click on the delete button
				click("task_deletedtaskbtn_CSS");
				System.out.println("Clicked on the delete button.");
				ngDriver.waitForAngularRequestsToFinish();

				// synchronization
				explicitWait("task_deletedtaskbtn_confirmaiton_CSS");

				// click on the delete button of the confirmation popup
				click("task_deletedtaskbtn_confirmaiton_CSS");
				System.out.println("Clicked on the delete button of the confirmation popup.");
				ngDriver.waitForAngularRequestsToFinish();

				// wait for the element
				explicitWaitClickable("closetoastmsg_CSS");

				// click on the toaster close button
				click("closetoastmsg_CSS");
				ngDriver.waitForAngularRequestsToFinish();
				System.out.println("Clicked on the toaster close button.");

				// scroll up the screen
				JavascriptExecutor js = (JavascriptExecutor) driver;
				js.executeScript("window.scrollBy(0,-500)");

				// click on the clear button
				click("task_createdtask_clearbtn_XPATH");
				ngDriver.waitForAngularRequestsToFinish();
				System.out.println("Clicked on the clear button.");

				// enter the data in the search field
				type("task_filter_CSS", data.get("task_title_updated"));
				System.out.println("Entered the data in the search field.");
				ngDriver.waitForAngularRequestsToFinish();

				// click on the search button
				click("task_createdtask_searchbtn_XPATH");
				ngDriver.waitForAngularRequestsToFinish();
				System.out.println("Clicked on the search button.");

				// verify the questionnaire deleted or not

				deleteVerification("task_addedtask_smoke111_XPATH", "Smoke Test One Task Title After Due Date Update");

			} catch (Throwable t) {

				verificationFailed();

			}

			// click on the home icon from the top of the screen
			click("questionnaire_homeburgermenubtn_hide_CSS");
			ngDriver.waitForAngularRequestsToFinish();
			System.out.println("Clicked on the home icon from the top of the screen.");

			// wait for the element
			explicitWait("propertylist_title_XPATH");

			// verify the property list
			switchVerification("propertylist_title_XPATH", "Property List", "The property list is not displayed.");

			// REOPEN THE NEWLY CREATED FIRST TASK FROM THE CLOSED TASK LIST

			System.out.println(
					"**************** REOPEN THE NEWLY CREATED FIRST TASK FROM THE CLOSED TASK LIST ****************");
			test.log(LogStatus.INFO,
					"**************** REOPEN THE NEWLY CREATED FIRST TASK FROM THE CLOSED TASK LIST ****************");
			Reporter.log(
					"**************** REOPEN THE NEWLY CREATED FIRST TASK FROM THE CLOSED TASK LIST ****************");
			log.info("**************** REOPEN THE NEWLY CREATED FIRST TASK FROM THE CLOSED TASK LIST ****************");

			try {

				// enter the property name in the search field
				type("envreports_propertylist_filtertxt_CSS", data.get("property_1"));
				ngDriver.waitForAngularRequestsToFinish();
				System.out.println("Entered the property name in the search field.");

				// click on the task icon
				click("taskicon_CSS");
				System.out.println("Clicked on the task icon.");
				ngDriver.waitForAngularRequestsToFinish();

				// select the close option from the status drop down
				select("survey_task_closefilter_CSS", data.get("task_closed_status"));
				ngDriver.waitForAngularRequestsToFinish();
				System.out.println("Selected the close option from the status drop down.");

				// click on the clear button
				click("task_createdtask_clearbtn_XPATH");
				ngDriver.waitForAngularRequestsToFinish();
				System.out.println("Selected the newly created task.");

				// type the newly created task in the search field
				type("task_filter_CSS", data.get("task_title"));
				ngDriver.waitForAngularRequestsToFinish();
				System.out.println("Selected the newly created task.");

				// click on the search button
				click("task_createdtask_searchbtn_XPATH");
				ngDriver.waitForAngularRequestsToFinish();
				System.out.println("Clicked on the search button.");

				switchVerification("task_addedtask_smoke11_XPATH", "Smoke Test One Task Title",
						"The Smoke Test One Task Title is not displayed.");

				// click on the newly created task
				click("task_addedtask_smoke11_XPATH");
				ngDriver.waitForAngularRequestsToFinish();
				System.out.println("Clicked on the newly created task.");

				// click on the reopen button
				click("survey_reopenbtn_CSS");
				ngDriver.waitForAngularRequestsToFinish();
				System.out.println("Clicked on the reopen button.");

				// wait for the element
				explicitWaitClickable("closetoastmsg_CSS");

				// click on the toaster close button
				click("closetoastmsg_CSS");
				ngDriver.waitForAngularRequestsToFinish();
				System.out.println("Clicked on the toaster close button.");

				// scroll down the screen
				JavascriptExecutor js = (JavascriptExecutor) driver;
				js.executeScript("window.scrollBy(0,400)");

				// wait for the element
				explicitWait("task_reopenedstatus_XPATH");

				// verify the Reopened status is displayed or not
				switchVerification("task_reopenedstatus_XPATH", "Reopened", "The Reopened status is not displayed.");

				// click on the update button
				click("survey_task_updatebtn_CSS");
				ngDriver.waitForAngularRequestsToFinish();
				System.out.println("Clicked on the update button.");

				// wait for the element
				explicitWaitClickable("closetoastmsg_CSS");

				// click on the toaster close button
				click("closetoastmsg_CSS");
				ngDriver.waitForAngularRequestsToFinish();
				System.out.println("Clicked on the toaster close button.");

				// click on the back button
				click("task_backbtn_CSS");
				ngDriver.waitForAngularRequestsToFinish();
				System.out.println("Clicked on the back button.");

				// click on the clear button
				click("task_createdtask_clearbtn_XPATH");
				ngDriver.waitForAngularRequestsToFinish();
				System.out.println("Selected the newly created task.");

				// type the newly created task in the search field
				type("task_filter_CSS", data.get("task_title_updated"));
				ngDriver.waitForAngularRequestsToFinish();
				System.out.println("Selected the newly created task.");

				// click on the search button
				click("task_createdtask_searchbtn_XPATH");
				ngDriver.waitForAngularRequestsToFinish();
				System.out.println("Clicked on the search button.");

				switchVerification("task_addedtask_smoke111_XPATH", "Smoke Test One Task Title After Due Date Update",
						"The Smoke Test One Task Title After Due Date Update is not displayed.");

				// click on the newly created task
				click("task_addedtask_smoke111_XPATH");
				ngDriver.waitForAngularRequestsToFinish();
				System.out.println("Clicked on the newly created task.");

				// click on the reopen button
				click("survey_reopenbtn_CSS");
				ngDriver.waitForAngularRequestsToFinish();
				System.out.println("Clicked on the reopen button.");

				// wait for the element
				explicitWaitClickable("closetoastmsg_CSS");

				// click on the toaster close button
				click("closetoastmsg_CSS");
				ngDriver.waitForAngularRequestsToFinish();
				System.out.println("Clicked on the toaster close button.");

				try {
					boolean reopenbtn = driver.findElement(By.cssSelector(OR.getProperty("survey_reopenbtn_CSS")))
							.isDisplayed();

					if (reopenbtn == true) {
						System.out.println("THE REOPEN BUTTON IS DISPLAYED BECAUSE OF VALIDATION MESSAGE.");
						test.log(LogStatus.INFO, "THE REOPEN BUTTON IS DISPLAYED BECAUSE OF VALIDATION MESSAGE.");
						Reporter.log("THE REOPEN BUTTON IS DISPLAYED BECAUSE OF VALIDATION MESSAGE.");
						log.info("THE REOPEN BUTTON IS DISPLAYED BECAUSE OF VALIDATION MESSAGE.");

					}

					else {

						TestUtil.captureScreenshot();

						// ReportNG
						Reporter.log("<br>" + " The validation message is not displayed : " + "<br>");
						Reporter.log("<a target=\"_blank\" href=" + TestUtil.screenshotName + "><img src="
								+ TestUtil.screenshotName + " height=200 width=200></img></a>");
						Reporter.log("<br>");
						Reporter.log("<br>");

						// Extent Report
						test.log(LogStatus.FAIL, " The validation message is not displayed : ");
						test.log(LogStatus.FAIL, test.addScreenCapture(TestUtil.screenshotName));

						System.out.println("The validation message is not displayed.");
						log.info("The validation message is not displayed.");
					}

				} catch (Throwable t) {
					verificationFailed();
				}

				// click on the back button
				click("task_backbtn_CSS");
				ngDriver.waitForAngularRequestsToFinish();
				System.out.println("Clicked on the back button.");

				System.out.println(
						"**************** DELETE THE NEWLY CREATED FIRST TASK WHICH ARE REOPENED ****************");
				test.log(LogStatus.INFO,
						"**************** DELETE THE NEWLY CREATED FIRST TASK WHICH ARE REOPENED ****************");
				Reporter.log(
						"**************** DELETE THE NEWLY CREATED FIRST TASK WHICH ARE REOPENED ****************");
				log.info("**************** DELETE THE NEWLY CREATED FIRST TASK WHICH ARE REOPENED ****************");

				// select the active option from the status drop down
				select("survey_task_closefilter_CSS", data.get("task_active_status"));
				ngDriver.waitForAngularRequestsToFinish();
				System.out.println("Selected the active option from the status drop down.");

				// click on the clear button
				click("task_createdtask_clearbtn_XPATH");
				ngDriver.waitForAngularRequestsToFinish();
				System.out.println("Selected the newly created task.");

				// type the newly created task in the search field
				type("task_filter_CSS", data.get("task_title"));
				ngDriver.waitForAngularRequestsToFinish();
				System.out.println("Selected the newly created task.");

				// click on the search button
				click("task_createdtask_searchbtn_XPATH");
				ngDriver.waitForAngularRequestsToFinish();
				System.out.println("Clicked on the search button.");

				switchVerification("task_addedtask_smoke11_XPATH", "Smoke Test One Task Title",
						"The Smoke Test One Task Title is not displayed.");

				// click on the newly created task
				click("task_addedtask_smoke11_XPATH");
				ngDriver.waitForAngularRequestsToFinish();
				System.out.println("Clicked on the newly created task.");

				// click on the delete button
				click("task_deletedtaskbtn_CSS");
				System.out.println("Clicked on the delete button.");
				ngDriver.waitForAngularRequestsToFinish();

				// synchronization
				explicitWait("task_deletedtaskbtn_confirmaiton_CSS");

				// click on the delete button of the confirmation popup
				click("task_deletedtaskbtn_confirmaiton_CSS");
				System.out.println("Clicked on the delete button of the confirmation popup.");
				ngDriver.waitForAngularRequestsToFinish();

				// wait for the element
				explicitWaitClickable("closetoastmsg_CSS");

				// click on the toaster close button
				click("closetoastmsg_CSS");
				ngDriver.waitForAngularRequestsToFinish();
				System.out.println("Clicked on the toaster close button.");

				// scroll up the screen
				js.executeScript("window.scrollBy(0,-500)");

				// click on the clear button
				click("task_createdtask_clearbtn_XPATH");
				ngDriver.waitForAngularRequestsToFinish();
				System.out.println("Clicked on the clear button.");

				// enter the data in the search field
				type("task_filter_CSS", data.get("task_title"));
				System.out.println("Entered the data in the search field.");
				ngDriver.waitForAngularRequestsToFinish();

				// click on the search button
				click("task_createdtask_searchbtn_XPATH");
				ngDriver.waitForAngularRequestsToFinish();
				System.out.println("Clicked on the search button.");

				// verify the questionnaire deleted or not

				deleteVerification("task_addedtask_smoke11_XPATH", "Smoke Test One Task Title");

				// select the closed option from the status drop down
				select("survey_task_closefilter_CSS", data.get("task_closed_status"));
				ngDriver.waitForAngularRequestsToFinish();
				System.out.println("Selected the closed option from the status drop down.");

				// click on the clear button
				click("task_createdtask_clearbtn_XPATH");
				ngDriver.waitForAngularRequestsToFinish();
				System.out.println("Clicked on the clear button.");

				// enter the newly created task in the search field
				type("task_filter_CSS", data.get("task_title_updated"));
				ngDriver.waitForAngularRequestsToFinish();
				System.out.println("Entered the newly created task in the search field.");

				// click on the search button
				click("task_createdtask_searchbtn_XPATH");
				ngDriver.waitForAngularRequestsToFinish();
				System.out.println("Clicked on the search button.");

				switchVerification("task_addedtask_smoke111_XPATH", "Smoke Test One Task Title After Due Date Update",
						"The Smoke Test One Task Title After Due Date Update is not displayed.");

				// click on the newly created task
				click("task_addedtask_smoke111_XPATH");
				ngDriver.waitForAngularRequestsToFinish();
				System.out.println("Clicked on the newly created task.");

				// click on the reopen button
				click("survey_reopenbtn_CSS");
				ngDriver.waitForAngularRequestsToFinish();
				System.out.println("Clicked on the reopen button.");

				// wait for the element
				explicitWaitClickable("closetoastmsg_CSS");

				// click on the toaster close button
				click("closetoastmsg_CSS");
				ngDriver.waitForAngularRequestsToFinish();
				System.out.println("Clicked on the toaster close button.");

				// scroll down the screen
				js.executeScript("window.scrollBy(0,400)");

				// wait for the element
				explicitWait("task_reopenedstatus_XPATH");

				// verify the Reopened status is displayed or not
				switchVerification("task_reopenedstatus_XPATH", "Reopened", "The Reopened status is not displayed.");

				// click on the update button
				click("survey_task_updatebtn_CSS");
				ngDriver.waitForAngularRequestsToFinish();
				System.out.println("Clicked on the update button.");

				// wait for the element
				explicitWaitClickable("closetoastmsg_CSS");

				// click on the toaster close button
				click("closetoastmsg_CSS");
				ngDriver.waitForAngularRequestsToFinish();
				System.out.println("Clicked on the toaster close button.");

				// click on the back button
				click("task_backbtn_CSS");
				ngDriver.waitForAngularRequestsToFinish();
				System.out.println("Clicked on the back button.");

				System.out.println(
						"**************** DELETE THE NEWLY CREATED SECOND TASK WHICH ARE REOPENED ****************");
				test.log(LogStatus.INFO,
						"**************** DELETE THE NEWLY CREATED SECOND TASK WHICH ARE REOPENED ****************");
				Reporter.log(
						"**************** DELETE THE NEWLY CREATED SECOND TASK WHICH ARE REOPENED ****************");
				log.info("**************** DELETE THE NEWLY CREATED SECOND TASK WHICH ARE REOPENED ****************");

				// select the active option from the status drop down
				select("survey_task_closefilter_CSS", data.get("task_active_status"));
				ngDriver.waitForAngularRequestsToFinish();
				System.out.println("Selected the active option from the status drop down.");

				// click on the clear button
				click("task_createdtask_clearbtn_XPATH");
				ngDriver.waitForAngularRequestsToFinish();
				System.out.println("Selected the newly created task.");

				// type the newly created task in the search field
				type("task_filter_CSS", data.get("task_title_updated"));
				ngDriver.waitForAngularRequestsToFinish();
				System.out.println("Selected the newly created task.");

				// click on the search button
				click("task_createdtask_searchbtn_XPATH");
				ngDriver.waitForAngularRequestsToFinish();
				System.out.println("Clicked on the search button.");

				// click on the newly created task
				click("task_addedtask_smoke111_XPATH");
				ngDriver.waitForAngularRequestsToFinish();
				System.out.println("Clicked on the newly created task.");

				// click on the delete button
				click("task_deletedtaskbtn_CSS");
				System.out.println("Clicked on the delete button.");
				ngDriver.waitForAngularRequestsToFinish();

				// synchronization
				explicitWait("task_deletedtaskbtn_confirmaiton_CSS");

				// click on the delete button of the confirmation popup
				click("task_deletedtaskbtn_confirmaiton_CSS");
				System.out.println("Clicked on the delete button of the confirmation popup.");
				ngDriver.waitForAngularRequestsToFinish();

				// wait for the element
				explicitWaitClickable("closetoastmsg_CSS");

				// click on the toaster close button
				click("closetoastmsg_CSS");
				ngDriver.waitForAngularRequestsToFinish();
				System.out.println("Clicked on the toaster close button.");

				// scroll up the screen
				js.executeScript("window.scrollBy(0,-500)");

				// click on the clear button
				click("task_createdtask_clearbtn_XPATH");
				ngDriver.waitForAngularRequestsToFinish();
				System.out.println("Clicked on the clear button.");

				// enter the data in the search field
				type("task_filter_CSS", data.get("task_title_updated"));
				System.out.println("Entered the data in the search field.");
				ngDriver.waitForAngularRequestsToFinish();

				// click on the search button
				click("task_createdtask_searchbtn_XPATH");
				ngDriver.waitForAngularRequestsToFinish();
				System.out.println("Clicked on the search button.");

				// verify the questionnaire deleted or not

				deleteVerification("task_addedtask_smoke111_XPATH", "Smoke Test One Task Title After Due Date Update");

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

			System.out.println("**************** LOGIN IN ADMIN USER ****************");
			test.log(LogStatus.INFO, "**************** LOGIN IN ADMIN USER ****************");
			Reporter.log("**************** LOGIN IN ADMIN USER ****************");
			log.info("**************** LOGIN IN ADMIN USER ****************");

			// Enter the username
			ngDriver.waitForAngularRequestsToFinish();
			type("username_MODEL", data.get("username_1"));

			// Enter the password
			type("password_MODEL", data.get("password_1"));

			// Clicking on the "Sign In" button
			click("signinbtn_BTNTEXT");
			ngDriver.waitForAngularRequestsToFinish();

			// wait for the element
			explicitWait("propertylist_title_XPATH");

			// verify the property list
			switchVerification("propertylist_title_XPATH", "Property List", "The property list is not displayed.");

		} catch (Throwable t) {
			helper.questionnaireNotDisplayLogout(data);
		}

		// UPDATE THE SYSTEM COMPANY
		updateCompany(data);

		// wait for the element
		Thread.sleep(10000);

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
