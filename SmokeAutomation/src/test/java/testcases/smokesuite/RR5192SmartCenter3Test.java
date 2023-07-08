package testcases.smokesuite;

import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.Date;
import java.util.Hashtable;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.testng.Reporter;
import org.testng.SkipException;
import org.testng.annotations.Test;

import com.relevantcodes.extentreports.LogStatus;

import base.Helper;
import base.TestBase;
import utilities.TestUtil;

public class RR5192SmartCenter3Test extends TestBase {

	@Test(dataProviderClass = TestUtil.class, dataProvider = "dp")
	public void rR5192SmartCenter3Test(Hashtable<String, String> data) throws IOException, InterruptedException {

		if (!(TestUtil.isTestRunnable("rR5192SmartCenter3Test", excel))) {

			throw new SkipException(
					"Skipping the test " + "rR5192SmartCenter3Test".toUpperCase() + "as the Run mode is NO");
		}

		if (!data.get("runmode").equals("Y")) {

			throw new SkipException("Skipping the test case as the Run Mode for data set is NO");
		}

		Helper helper = new Helper();

		// PERFORM THE TEST CASES OF THE SMART CENTERS - PROPERTY MANAGER USER

		System.out.println(
				"******************** PERFORM THE TEST CASES OF THE SMART CENTERS - PROPERTY MANAGER USER ********************");
		test.log(LogStatus.INFO,
				"******************** PERFORM THE TEST CASES OF THE SMART CENTERS - PROPERTY MANAGER USER ********************");
		Reporter.log(
				"******************** PERFORM THE TEST CASES OF THE SMART CENTERS - PROPERTY MANAGER USER ********************");
		log.info(
				"******************** PERFORM THE TEST CASES OF THE SMART CENTERS - PROPERTY MANAGER USER ********************");

		// refresh the page
		driver.navigate().refresh();
		Thread.sleep(5000);
		driver.navigate().refresh();

		try {
			// LOGIN WITH PROPERTY MANAGER USER

			System.out.println("******************** LOGIN WITH PROPERTY MANAGER USER ********************");
			test.log(LogStatus.INFO, "******************** LOGIN WITH PROPERTY MANAGER USER ********************");
			Reporter.log("******************** LOGIN WITH PROPERTY MANAGER USER ********************");
			log.info("******************** LOGIN WITH PROPERTY MANAGER USER ********************");

			// wait for the element
			explicitWaitClickable("signinbtn_BTNTEXT");

			// Enter the username
			type("usernametxt_CSS", data.get("username"));
			ngDriver.waitForAngularRequestsToFinish();
			System.out.println("Entered the username.");

			// Enter the password
			type("passwordtxt_CSS", data.get("password"));
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

			// ADD THE TASK

			System.out.println("******************** ADD THE TASK ********************");
			test.log(LogStatus.INFO, "******************** ADD THE TASK ********************");
			Reporter.log("******************** ADD THE TASK ********************");
			log.info("******************** ADD THE TASK ********************");

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
				ngDriver.waitForAngularRequestsToFinish();
				System.out.println("Entered the data in the task title field.");
				type("task_addtask_titletxt_CSS", data.get("task_title"));
				System.out.println("Entered the data in the task title field.");
				ngDriver.waitForAngularRequestsToFinish();

				// enter the data in the task location field
				clear("task_addtask_locationtxt_CSS");
				ngDriver.waitForAngularRequestsToFinish();
				System.out.println("Entered the data in the task location field.");
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

				// SELECT RECURRENT DATE

				// select the month option from the recurrent drop down
				select("task_reccurentdd_CSS", data.get("recurrent_type"));
				ngDriver.waitForAngularRequestsToFinish();
				System.out.println("Selected the day option from the recurrent drop down.");

				// enter the data in the recurrent interval field
				clear("task_reccurentintervaltxt_CSS");
				ngDriver.waitForAngularRequestsToFinish();
				System.out.println("Cleared the ruccurent interval field.");
				type("task_reccurentintervaltxt_CSS", "1");
				ngDriver.waitForAngularRequestsToFinish();
				System.out.println("Entered the data in the recurrent interval field.");

				// wait for the element
				explicitWait("task_addtask_moduledd_CSS");

				// select the application option from the module dropdown
				select("task_addtask_moduledd_CSS", data.get("task_module"));
				System.out.println("Selected the environmental option from the module dropdown.");
				ngDriver.waitForAngularRequestsToFinish();

				// scroll down the screen
				js.executeScript("window.scrollBy(0,400)");

				// click on the task tag field
				click("task_tasktag_field_CSS");
				ngDriver.waitForAngularRequestsToFinish();
				System.out.println("Clicked on the task tag field.");

				// click on the none button
				click("task_tasktag_nonebtn_CSS");
				ngDriver.waitForAngularRequestsToFinish();
				System.out.println("Clicked on the none button.");

				// enter the task tag name in the search field
				clear("task_tasktag_searchtxt_CSS");
				ngDriver.waitForAngularRequestsToFinish();
				System.out.println("Entered the task tag name in the search field.");
				type("task_tasktag_searchtxt_CSS", data.get("search_4"));
				ngDriver.waitForAngularRequestsToFinish();
				System.out.println("Entered the task tag name in the search field.");

				// click on the searched result
				click("task_tasktag_searchedresult7_XPATH");
				ngDriver.waitForAngularRequestsToFinish();
				System.out.println("Clicked on the searched result.");

				// click on the task tag field
				click("task_tasktag_field_CSS");
				ngDriver.waitForAngularRequestsToFinish();
				System.out.println("Clicked on the task tag field.");

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
				switchVerification("task_addedtask_smoke3_XPATH", "Smoke Test Three Task Title",
						"The Smoke Test Three Task Title is not displayed.");

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
				switchVerification("task_addedtask_smoke3_XPATH", "Smoke Test Three Task Title",
						"The Smoke Test Three Task Title is not displayed.");

				// click on the newly created task
				click("task_addedtask_smoke3_XPATH");
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
				type("task_filter_CSS", data.get("task_title"));
				ngDriver.waitForAngularRequestsToFinish();
				System.out.println("Selected the newly created task.");

				// click on the search button
				click("task_createdtask_searchbtn_XPATH");
				ngDriver.waitForAngularRequestsToFinish();
				System.out.println("Clicked on the search button.");

				switchVerification("task_addedtask_smoke3_XPATH", "Smoke Test Three Task Title",
						"The Smoke Test Three Task Title is not displayed.");

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

				switchVerification("task_addedtask_smoke3_XPATH", "Smoke Test Three Task Title",
						"The Smoke Test Three Task Title is not displayed.");

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

				// select the active option from the status drop down
				select("survey_task_closefilter_CSS", data.get("task_active_status"));
				ngDriver.waitForAngularRequestsToFinish();
				System.out.println("Selected the active option from the status drop down.");

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
				switchVerification("task_addedtask_smoke3_XPATH", "Smoke Test Three Task Title",
						"The Smoke Test Three Task Title is not displayed.");

				// click on the newly created task
				click("task_addedtask_smoke3_XPATH");
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

				// click on the apply button
				click("task_updateduedate_applybtn_CSS");
				ngDriver.waitForAngularRequestsToFinish();
				System.out.println("Clicked on the apply button.");

				// scroll up the screen
				JavascriptExecutor js = (JavascriptExecutor) driver;
				js.executeScript("window.scrollBy(0,-500)");

				// enter the data in the task title field
				clear("task_addtask_titletxt_CSS");
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

				switchVerification("task_addedtask_smoke333_XPATH", "Smoke Test Three Task Title After Due Date Update",
						"The Smoke Test Three Task Title After Due Date Update is not displayed.");

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
				switchVerification("task_addedtask_smoke333_XPATH", "Smoke Test Three Task Title After Due Date Update",
						"The Smoke Test Three Task Title After Due Date Update is not displayed.");

				// click on the newly created task
				click("task_addedtask_smoke333_XPATH");
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

				switchVerification("task_addedtask_smoke333_XPATH", "Smoke Test Three Task Title After Due Date Update",
						"The Smoke Test Three Task Title After Due Date Update is not displayed.");

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

				switchVerification("task_addedtask_smoke333_XPATH", "Smoke Test Three Task Title After Due Date Update",
						"The Smoke Test Three Task Title After Due Date Update is not displayed.");

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
					LocalDate updatedFutureDate = LocalDate.now().plusMonths(2);

					String expectedUpdatedFutureDate = updatedFutureDate.toString();

					String updatedFutureDateXpath = "//td[text()='" + updatedFutureDate + "']";

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

				// click on the action icon of the newly created task
				click("task_addedtask_smoke3_actionicon_XPATH");
				ngDriver.waitForAngularRequestsToFinish();
				System.out.println("click on the action icon of the newly created task.");

				// click on the delete button
				click("task_addedtask_smoke3_actionicon_deleteoption_XPATH");
				ngDriver.waitForAngularRequestsToFinish();
				System.out.println("Clicked on the delete button.");

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

				deleteVerification("task_addedtask_smoke333_XPATH",
						"Smoke Test Three Task Title After Due Date Update");

				// DELETE THE NEWLY CREATED TASKS FROM THE ACTIVE TASK LIST

				System.out.println(
						"**************** DELETE THE NEWLY CREATED TASKS FROM THE CLOSE TASK LIST ****************");
				test.log(LogStatus.INFO,
						"**************** DELETE THE NEWLY CREATED TASKS FROM THE CLOSE TASK LIST ****************");
				Reporter.log(
						"**************** DELETE THE NEWLY CREATED TASKS FROM THE CLOSE TASK LIST ****************");
				log.info("**************** DELETE THE NEWLY CREATED TASKS FROM THE CLOSE TASK LIST ****************");

				// select the close option from the status drop down
				select("survey_task_closefilter_CSS", data.get("task_closed_status"));
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

				// click on the action button of the newly created task
				click("task_addedtask_smoke3_actionicon_XPATH");
				ngDriver.waitForAngularRequestsToFinish();
				System.out.println("Clicked on the newly created task.");

				// click on the reopen button
				click("task_addedtask_smoke3_actionicon_reopenoption_XPATH");
				System.out.println("Clicked on the reopen button.");
				ngDriver.waitForAngularRequestsToFinish();

				// wait for the element
				explicitWaitClickable("closetoastmsg_CSS");

				// click on the toaster close button
				click("closetoastmsg_CSS");
				ngDriver.waitForAngularRequestsToFinish();
				System.out.println("Clicked on the toaster close button.");

				// select the active option from the status drop down
				select("survey_task_closefilter_CSS", data.get("task_active_status"));
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

				// click on the action button of the newly created task
				click("task_addedtask_smoke3_actionicon_XPATH");
				ngDriver.waitForAngularRequestsToFinish();
				System.out.println("Clicked on the newly created task.");

				// click on the reopen button
				click("task_addedtask_smoke3_actionicon_deleteoption_XPATH");
				System.out.println("Clicked on the reopen button.");
				ngDriver.waitForAngularRequestsToFinish();

				// wait for the element
				explicitWaitClickable("closetoastmsg_CSS");

				// click on the toaster close button
				click("closetoastmsg_CSS");
				ngDriver.waitForAngularRequestsToFinish();
				System.out.println("Clicked on the toaster close button.");

				// select the close option from the status drop down
				select("survey_task_closefilter_CSS", data.get("task_closed_status"));
				ngDriver.waitForAngularRequestsToFinish();
				System.out.println("Selected the active option from the status drop down.");

				// click on the clear button
				click("task_createdtask_clearbtn_XPATH");
				ngDriver.waitForAngularRequestsToFinish();
				System.out.println("Clicked on the clear button.");

				// enter the data in the search field
				type("task_filter_CSS", data.get("task_title"));
				System.out.println("Entered the data in the search field.");
				ngDriver.waitForAngularRequestsToFinish();

				// click on the action button of the newly created task
				click("task_addedtask_smoke3_actionicon1_XPATH");
				ngDriver.waitForAngularRequestsToFinish();
				System.out.println("Clicked on the newly created task.");

				// click on the reopen button
				click("task_addedtask_smoke3_actionicon_reopenoption1_XPATH");
				System.out.println("Clicked on the reopen button.");
				ngDriver.waitForAngularRequestsToFinish();

				// wait for the element
				explicitWaitClickable("closetoastmsg_CSS");

				// click on the toaster close button
				click("closetoastmsg_CSS");
				ngDriver.waitForAngularRequestsToFinish();
				System.out.println("Clicked on the toaster close button.");

				// select the active option from the status drop down
				select("survey_task_closefilter_CSS", data.get("task_active_status"));
				ngDriver.waitForAngularRequestsToFinish();
				System.out.println("Selected the close option from the status drop down.");

				// click on the clear button
				click("task_createdtask_clearbtn_XPATH");
				ngDriver.waitForAngularRequestsToFinish();
				System.out.println("Clicked on the clear button.");

				// enter the data in the search field
				type("task_filter_CSS", data.get("task_title"));
				System.out.println("Entered the data in the search field.");
				ngDriver.waitForAngularRequestsToFinish();

				// click on the action button of the newly created task
				click("task_addedtask_smoke3_actionicon1_XPATH");
				ngDriver.waitForAngularRequestsToFinish();
				System.out.println("Clicked on the newly created task.");

				// click on the reopen button
				click("task_addedtask_smoke3_actionicon_deleteoption1_XPATH");
				System.out.println("Clicked on the reopen button.");
				ngDriver.waitForAngularRequestsToFinish();

				// wait for the element
				explicitWaitClickable("closetoastmsg_CSS");

				// click on the toaster close button
				click("closetoastmsg_CSS");
				ngDriver.waitForAngularRequestsToFinish();
				System.out.println("Clicked on the toaster close button.");

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
