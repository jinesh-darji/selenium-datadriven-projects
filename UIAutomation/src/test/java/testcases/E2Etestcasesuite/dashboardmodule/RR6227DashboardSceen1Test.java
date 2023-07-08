package testcases.E2Etestcasesuite.dashboardmodule;

import java.io.IOException;
import java.time.LocalDate;
import java.util.Hashtable;
import java.util.List;
import java.util.Random;

import org.apache.commons.lang3.RandomStringUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.testng.SkipException;
import org.testng.annotations.Test;

import base.TestBase;
import utilities.TestUtil;

public class RR6227DashboardSceen1Test extends TestBase {

	@Test(dataProviderClass = TestUtil.class, dataProvider = "dp")
	public void rR6227DashboardSceen1Test(Hashtable<String, String> data) throws IOException, InterruptedException {

		execution(data, "rR6227DashboardSceen1Test");

		// VALIDATE THE TASKS SECTION COUNT OF THE PORTFOLIO DASHBOARD
		title("VALIDATE THE TASKS SECTION COUNT OF THE PORTFOLIO DASHBOARD");

		// refresh the page
		driver.navigate().refresh();
		Thread.sleep(5000);
		driver.navigate().refresh();

		System.out.println("Navigate to the Home Screen i.e. Property List Screen.");

		// DELETE ALL THE PREVIOUSLY CREATED TASKS FROM MY TASK LIST

		title("DELETE ALL THE PREVIOUSLY CREATED TASKS FROM MY TASK LIST");

		try {

			// wait for the element
			Thread.sleep(5000);

			// click on the side menu
			click("menubtn_CSS");
			ngDriver.waitForAngularRequestsToFinish();
			System.out.println("Clicked on the side menu.");

			// wait for the element
			Thread.sleep(5000);

			// click on the my task option
			click("mytask_sidemenu_XPATH");
			ngDriver.waitForAngularRequestsToFinish();
			System.out.println("Clicked on the my task option.");

			// delete all the previously created tasks
			try {
				String pages = (driver
						.findElement(By.xpath(
								"//i[@ng-click='previousPageData()']//following-sibling::strong[@class='ng-binding']"))
						.getText()).trim();
				String[] arrOfStr = pages.split(" ");
				String pageno = arrOfStr[3];
				int pagecount = Integer.parseInt(pageno);

				for (int i = 0; i < pagecount; i++) {

					List<WebElement> roles = driver.findElements(By.xpath("//table[@id='tasksTable']//tbody//tr"));
					int rolesnum = roles.size();

					for (int j = 0; j < rolesnum; j++) {

						// wait for the element
						Thread.sleep(3000);

						// click on the action icon of the first record
						click("mytask_firstactionicon_XPATH");
						ngDriver.waitForAngularRequestsToFinish();
						System.out.println("Clicked on the action icon of the first record.");

						// wait for the element
						Thread.sleep(3000);

						// click on the delete option
						click("mytask_firstactionicon_deleteoption_XPATH");
						ngDriver.waitForAngularRequestsToFinish();
						System.out.println("Clicked on the delete option.");

						// wait for the element
						explicitWaitClickable("closetoastmsg_CSS");

						// click on the toaster close button
						click("closetoastmsg_CSS");
						ngDriver.waitForAngularRequestsToFinish();
						System.out.println("Clicked on the toaster close button.");

					}

					// click on the next button
					click("task_permission_roles_nextbtn_CSS");
					ngDriver.waitForAngularRequestsToFinish();
					System.out.println("Clicked on the next button.");

				}
			} catch (Throwable t) {

				successMessage("Successfully deleted all the tasks.");

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

		// VALIDATE RESPECTIVE TASK COUNT ON THE TASKS SECTION OF THE PORTFOLIO SUMMARY
		// DASHBOARD BEFORE CREATE THE TASKS

		title("VALIDATE RESPECTIVE TASK COUNT ON THE TASKS SECTION OF THE PORTFOLIO SUMMARY DASHBOARD BEFORE CREATE THE TASKS");

		try {
			// wait for the element
			Thread.sleep(5000);

			// click on the side menu
			click("menubtn_CSS");
			ngDriver.waitForAngularRequestsToFinish();
			System.out.println("Clicked on the side menu.");

			// wait for the element
			Thread.sleep(5000);

			// click on the portfolio dashboard from side menu
			click("sidemenu_portfoliosummary_XPATH");
			ngDriver.waitForAngularRequestsToFinish();
			System.out.println("Clicked on the portfolio dashboard from side menu.");

			// scrolldown till task section
			WebElement taskTitle = driver
					.findElement(By.xpath(OR.getProperty("portfoliodashboard_tasksection_title_XPATH")));
			JavascriptExecutor js = (JavascriptExecutor) driver;
			js.executeScript("arguments[0].scrollIntoView(true);", taskTitle);

			// wait for the element
			Thread.sleep(10000);

			// validate the progress graph percentage

			try {
				String progressPercentage = (driver
						.findElement(By.xpath(OR.getProperty("portfoliodashboard_tasksection_progresscount_XPATH")))
						.getText()).trim();

				if (progressPercentage.equals("0%")) {

					successMessage(
							"The progressive percentage of tasks section of the portfolio dashboard is displayed correctly.");

				} else {

					verificationFailedMessage(
							"The progressive percentage of tasks section of the portfolio dashboard is not displayed correctly.");

				}
			} catch (Throwable t) {
				verificationFailedMessage(
						"The progressive percentage of tasks section of the portfolio dashboard is not displayed correctly.");
			}

			// validate the count of the open tasks

			try {
				String openTaskCount = (driver
						.findElement(By.xpath(OR.getProperty("portfoliodashboard_tasksection_opentaskcount_XPATH")))
						.getText()).trim();
				int openTaskCount_int = Integer.parseInt(openTaskCount);

				if (openTaskCount_int == 0) {

					successMessage(
							"The count of open task in the tasks section of the portfolio dashboard is displayed correctly.");

				} else {

					verificationFailedMessage(
							"The count of open task in the tasks section of the portfolio dashboard is not displayed correctly.");

				}
			} catch (Throwable t) {
				verificationFailedMessage(
						"The count of open task in the tasks section of the portfolio dashboard is not displayed correctly.");
			}

			// validate the count of the overdue tasks

			try {
				String overdueTaskCount = (driver
						.findElement(By.xpath(OR.getProperty("portfoliodashboard_tasksection_overduetaskcount_XPATH")))
						.getText()).trim();
				int overdueTaskCount_int = Integer.parseInt(overdueTaskCount);

				if (overdueTaskCount_int == 0) {

					successMessage(
							"The count of overdue task in the tasks section of the portfolio dashboard is displayed correctly.");

				} else {

					verificationFailedMessage(
							"The count of overdue task in the tasks section of the portfolio dashboard is not displayed correctly.");

				}
			} catch (Throwable t) {
				verificationFailedMessage(
						"The count of overdue task in the tasks section of the portfolio dashboard is not displayed correctly.");
			}

			// validate the count of the unscheduled tasks

			try {
				String unscheduledTaskCount = (driver
						.findElement(
								By.xpath(OR.getProperty("portfoliodashboard_tasksection_unscheduledtaskcount_XPATH")))
						.getText()).trim();
				int unscheduledTaskCount_int = Integer.parseInt(unscheduledTaskCount);

				if (unscheduledTaskCount_int == 0) {

					successMessage(
							"The count of unscheduled task in the tasks section of the portfolio dashboard is displayed correctly.");

				} else {

					verificationFailedMessage(
							"The count of unscheduled task in the tasks section of the portfolio dashboard is not displayed correctly.");

				}
			} catch (Throwable t) {
				verificationFailedMessage(
						"The count of unscheduled task in the tasks section of the portfolio dashboard is not displayed correctly.");
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

		// CREATE A RANDOM NUMBER OF TASK IN PROPERTY ONE

		title("CREATE A RANDOM NUMBER OF TASK IN PROPERTY ONE");

		Random random1 = new Random();
		int random11 = random1.nextInt(6 - 3) + 3;

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

			for (int i = 0; i < random11; i++) {

				// click on the add task button
				click("task_addtaskbtn_CSS");
				System.out.println("Clicked on the add task button.");
				ngDriver.waitForAngularRequestsToFinish();

				// enter the data in the task title field
				String taskTitle1 = RandomStringUtils.randomAlphabetic(8);
				type("task_addtask_titletxt_CSS", taskTitle1);
				System.out.println("Entered the data in the task title field.");
				ngDriver.waitForAngularRequestsToFinish();

				// enter the data in the task location field
				type("task_addtask_locationtxt_CSS", data.get("task_location"));
				System.out.println("Entered the data in the task location field.");
				ngDriver.waitForAngularRequestsToFinish();

				// click on the assign to field
				click("task_assigntotxt_CSS");
				System.out.println("Clicked on the assign to field.");
				ngDriver.waitForAngularRequestsToFinish();

				// click on the none button
				click("task_tasktag_nonebtn_CSS");
				System.out.println("Clicked on the none button.");
				ngDriver.waitForAngularRequestsToFinish();

				// enter the user name in the search field
				type("workflowsecurity_editortask_taskdetails_searchtasktagtxt_CSS", data.get("search_user"));
				System.out.println("Entered the user name in the search field.");
				ngDriver.waitForAngularRequestsToFinish();

				// click on the searched result
				click("questionnaire_createtask_selectusertxt_XPATH");
				System.out.println("Clicked on the searched result.");
				ngDriver.waitForAngularRequestsToFinish();

				// click on the assign to field
				click("task_assigntotxt_CSS");
				System.out.println("Clicked on the assign to field.");
				ngDriver.waitForAngularRequestsToFinish();

				// scroll down the screen
				JavascriptExecutor js = (JavascriptExecutor) driver;
				js.executeScript("window.scrollBy(0,document.body.scrollHeight)");

				// synchronization
				explicitWait("task_addtask_moduledd_CSS");

				// select the environmental option from the module dropdown
				select("task_addtask_moduledd_CSS", data.get("task_module"));
				System.out.println("Selected the environmental option from the module dropdown.");
				ngDriver.waitForAngularRequestsToFinish();

				// click on the save button
				click("survey_task_savebtn_CSS");
				System.out.println("Clicked on the save button.");
				ngDriver.waitForAngularRequestsToFinish();

				// wait for the element
				explicitWaitClickable("closetoastmsg_CSS");

				// click on the toaster close button
				click("closetoastmsg_CSS");
				ngDriver.waitForAngularRequestsToFinish();
				System.out.println("Clicked on the toaster close button.");

				// scroll up the screen
				js.executeScript("window.scrollTo(0,0)");

				// click on the clear button
				click("task_createdtask_clearbtn_XPATH");
				ngDriver.waitForAngularRequestsToFinish();
				System.out.println("Clicked on the clear button.");

				// enter the data in the search field
				type("task_filter_CSS", taskTitle1);
				System.out.println("Entered the data in the search field.");
				ngDriver.waitForAngularRequestsToFinish();

				// click on the search button
				click("task_createdtask_searchbtn_XPATH");
				ngDriver.waitForAngularRequestsToFinish();
				System.out.println("Clicked on the search button.");

				try {
					String task1 = "//p[contains(text(),'" + taskTitle1 + "')]";

					boolean task11 = driver.findElement(By.xpath(task1)).isDisplayed();

					if (task11 == true) {

						successMessage("The newly created task is displayed successfully.");

					} else {
						verificationFailedMessage("The newly created task in not displayed.");
					}

				} catch (Throwable t) {
					verificationFailedMessage("The newly created task in not displayed.");
				}
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

		// VALIDATE RESPECTIVE TASK COUNT ON THE TASKS SECTION OF THE PORTFOLIO SUMMARY
		// DASHBOARD AFTER CREATED THE TASKS

		title("VALIDATE RESPECTIVE TASK COUNT ON THE TASKS SECTION OF THE PORTFOLIO SUMMARY DASHBOARD AFTER CREATED THE TASKS");

		try {
			// wait for the element
			Thread.sleep(5000);

			// click on the side menu
			click("menubtn_CSS");
			ngDriver.waitForAngularRequestsToFinish();
			System.out.println("Clicked on the side menu.");

			// wait for the element
			Thread.sleep(5000);

			// click on the portfolio dashboard from side menu
			click("sidemenu_portfoliosummary_XPATH");
			ngDriver.waitForAngularRequestsToFinish();
			System.out.println("Clicked on the portfolio dashboard from side menu.");

			// scrolldown till task section
			WebElement taskTitle = driver
					.findElement(By.xpath(OR.getProperty("portfoliodashboard_tasksection_title_XPATH")));
			JavascriptExecutor js = (JavascriptExecutor) driver;
			js.executeScript("arguments[0].scrollIntoView(true);", taskTitle);

			// wait for the element
			Thread.sleep(10000);

			// validate the progress graph percentage

			try {
				String progressPercentage = (driver
						.findElement(By.xpath(OR.getProperty("portfoliodashboard_tasksection_progresscount_XPATH")))
						.getText()).trim();

				if (progressPercentage.equals("0%")) {

					successMessage(
							"The progressive percentage of tasks section of the portfolio dashboard is displayed correctly.");

				} else {

					verificationFailedMessage(
							"The progressive percentage of tasks section of the portfolio dashboard is not displayed correctly.");

				}
			} catch (Throwable t) {
				verificationFailedMessage(
						"The progressive percentage of tasks section of the portfolio dashboard is not displayed correctly.");
			}

			// validate the count of the open tasks

			try {
				String openTaskCount = (driver
						.findElement(By.xpath(OR.getProperty("portfoliodashboard_tasksection_opentaskcount_XPATH")))
						.getText()).trim();
				int openTaskCount_int = Integer.parseInt(openTaskCount);

				if (openTaskCount_int == random11) {

					successMessage(
							"The count of open task in the tasks section of the portfolio dashboard is displayed correctly.");

				} else {

					verificationFailedMessage(
							"The count of open task in the tasks section of the portfolio dashboard is not displayed correctly.");

				}
			} catch (Throwable t) {
				verificationFailedMessage(
						"The count of open task in the tasks section of the portfolio dashboard is not displayed correctly.");
			}

			// validate the count of the overdue tasks

			try {
				String overdueTaskCount = (driver
						.findElement(By.xpath(OR.getProperty("portfoliodashboard_tasksection_overduetaskcount_XPATH")))
						.getText()).trim();
				int overdueTaskCount_int = Integer.parseInt(overdueTaskCount);

				if (overdueTaskCount_int == 0) {

					successMessage(
							"The count of overdue task in the tasks section of the portfolio dashboard is displayed correctly.");

				} else {

					verificationFailedMessage(
							"The count of overdue task in the tasks section of the portfolio dashboard is not displayed correctly.");

				}
			} catch (Throwable t) {
				verificationFailedMessage(
						"The count of overdue task in the tasks section of the portfolio dashboard is not displayed correctly.");
			}

			// validate the count of the unscheduled tasks

			try {
				String unscheduledTaskCount = (driver
						.findElement(
								By.xpath(OR.getProperty("portfoliodashboard_tasksection_unscheduledtaskcount_XPATH")))
						.getText()).trim();
				int unscheduledTaskCount_int = Integer.parseInt(unscheduledTaskCount);

				if (unscheduledTaskCount_int == random11) {

					successMessage(
							"The count of unscheduled task in the tasks section of the portfolio dashboard is displayed correctly.");

				} else {

					verificationFailedMessage(
							"The count of unscheduled task in the tasks section of the portfolio dashboard is not displayed correctly.");

				}
			} catch (Throwable t) {
				verificationFailedMessage(
						"The count of unscheduled task in the tasks section of the portfolio dashboard is not displayed correctly.");
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

		// CREATE THE TASK IN PROPERTY ONE WITH TODAY'S DATE AS A DUE DATE

		title("CREATE THE TASK IN PROPERTY ONE WITH TODAY'S DATE AS A DUE DATE");

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

			// click on the add task button
			click("task_addtaskbtn_CSS");
			System.out.println("Clicked on the add task button.");
			ngDriver.waitForAngularRequestsToFinish();

			// enter the data in the task title field
			clear("task_addtask_titletxt_CSS");
			type("task_addtask_titletxt_CSS", data.get("task_title_1"));
			System.out.println("Entered the data in the task title field.");
			ngDriver.waitForAngularRequestsToFinish();

			// enter the data in the task location field
			clear("task_addtask_locationtxt_CSS");
			type("task_addtask_locationtxt_CSS", data.get("task_location"));
			System.out.println("Entered the data in the task location field.");
			ngDriver.waitForAngularRequestsToFinish();

			// click on the assign to field
			click("task_assigntotxt_CSS");
			System.out.println("Clicked on the assign to field.");
			ngDriver.waitForAngularRequestsToFinish();

			// click on the none button
			click("task_tasktag_nonebtn_CSS");
			System.out.println("Clicked on the none button.");
			ngDriver.waitForAngularRequestsToFinish();

			// enter the user name in the search field
			clear("workflowsecurity_editortask_taskdetails_searchtasktagtxt_CSS");
			type("workflowsecurity_editortask_taskdetails_searchtasktagtxt_CSS", data.get("search_user"));
			System.out.println("Entered the user name in the search field.");
			ngDriver.waitForAngularRequestsToFinish();

			// click on the searched result
			click("questionnaire_createtask_selectusertxt_XPATH");
			System.out.println("Clicked on the searched result.");
			ngDriver.waitForAngularRequestsToFinish();

			// click on the assign to field
			click("task_assigntotxt_CSS");
			System.out.println("Clicked on the assign to field.");
			ngDriver.waitForAngularRequestsToFinish();

			// scroll down the screen
			JavascriptExecutor js = (JavascriptExecutor) driver;
			js.executeScript("window.scrollBy(0,document.body.scrollHeight)");

			// select the environmental option from the module dropdown
			select("task_addtask_moduledd_CSS", data.get("task_module"));
			System.out.println("Selected the environmental option from the module dropdown.");
			ngDriver.waitForAngularRequestsToFinish();

			// click on the save button
			click("survey_task_savebtn_CSS");
			System.out.println("Clicked on the save button.");
			ngDriver.waitForAngularRequestsToFinish();

			// wait for the element
			explicitWaitClickable("closetoastmsg_CSS");

			// click on the toaster close button
			click("closetoastmsg_CSS");
			ngDriver.waitForAngularRequestsToFinish();
			System.out.println("Clicked on the toaster close button.");

			// scroll up the screen
			js.executeScript("window.scrollTo(0,0)");

			// click on the clear button
			click("task_createdtask_clearbtn_XPATH");
			ngDriver.waitForAngularRequestsToFinish();
			System.out.println("Clicked on the clear button.");

			// enter the data in the search field
			clear("task_filter_CSS");
			type("task_filter_CSS", data.get("task_title_1"));
			System.out.println("Entered the data in the search field.");
			ngDriver.waitForAngularRequestsToFinish();

			// click on the search button
			click("task_createdtask_searchbtn_XPATH");
			ngDriver.waitForAngularRequestsToFinish();
			System.out.println("Clicked on the search button.");

			// validate newly created task
			switchVerification("portfoliodashboard_tasksection_newlycreatedtask1_XPATH", data.get("task_title_1"),
					"The newly created task is not displayed.");

			// click on the searched task
			click("portfoliodashboard_tasksection_newlycreatedtask1_XPATH");
			ngDriver.waitForAngularRequestsToFinish();
			System.out.println("Clicked on the searched task.");

			// click on the change due date
			click("questionnaire_inspection_tasks_changeduedatbtn_XPATH");
			ngDriver.waitForAngularRequestsToFinish();
			System.out.println("Clicked on the change due date.");

			// enter today's date in the date field
			LocalDate currentDate = LocalDate.now();
			String currentDate_string = currentDate.toString();
			clear("portfoliodashboard_tasksection_newduedatetxt_XPATH");
			type("portfoliodashboard_tasksection_newduedatetxt_XPATH", currentDate_string);
			ngDriver.waitForAngularRequestsToFinish();
			System.out.println("Entered today's date in the date field.");

			// click on the apply button
			click("task_tasktag_newduedatetxt_applybtn_CSS");
			ngDriver.waitForAngularRequestsToFinish();
			System.out.println("Clicked on the apply button.");

			// click on the update button
			click("portfoliodashboard_tasksection_updatebtn_XPATH");
			ngDriver.waitForAngularRequestsToFinish();
			System.out.println("Clicked on the update button.");

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

		// VALIDATE RESPECTIVE TASK COUNT ON THE TASKS SECTION OF THE PORTFOLIO SUMMARY
		// DASHBOARD AFTER CREATED THE TASK WITH TODAY'S DATE AS A DUE DATE

		title("VALIDATE RESPECTIVE TASK COUNT ON THE TASKS SECTION OF THE PORTFOLIO SUMMARY DASHBOARD AFTER CREATED THE TASKS WITH TODAY'S DATE AS A DUE DATE");

		try {
			// wait for the element
			Thread.sleep(5000);

			// click on the side menu
			click("menubtn_CSS");
			ngDriver.waitForAngularRequestsToFinish();
			System.out.println("Clicked on the side menu.");

			// wait for the element
			Thread.sleep(5000);

			// click on the portfolio dashboard from side menu
			click("sidemenu_portfoliosummary_XPATH");
			ngDriver.waitForAngularRequestsToFinish();
			System.out.println("Clicked on the portfolio dashboard from side menu.");

			// scrolldown till task section
			WebElement taskTitle = driver
					.findElement(By.xpath(OR.getProperty("portfoliodashboard_tasksection_title_XPATH")));
			JavascriptExecutor js = (JavascriptExecutor) driver;
			js.executeScript("arguments[0].scrollIntoView(true);", taskTitle);

			// wait for the element
			Thread.sleep(10000);

			// validate the progress graph percentage

			try {

				int sum1 = random11 + 1;
				System.out.println("sum1 :::::::" + sum1);

				int graph1 = (1 * 100) / sum1;
				System.out.println("graph1 ::::::" + graph1);

				int graph1_round = Math.round(graph1);

				String graph1_round_string = Integer.toString(graph1_round);

				System.out.println("graph1_round_string:::::::::::" + graph1_round_string);

				String progressPercentage = (driver
						.findElement(By.xpath(OR.getProperty("portfoliodashboard_tasksection_progresscount_XPATH")))
						.getText()).trim();

				if (progressPercentage.equals(graph1_round_string + "%")) {

					System.out.println("graph1_round_string with %:::::::::::" + graph1_round_string + "%");

					successMessage(
							"The progressive percentage of tasks section of the portfolio dashboard is displayed correctly.");

				} else {

					verificationFailedMessage(
							"The progressive percentage of tasks section of the portfolio dashboard is not displayed correctly.");

				}
			} catch (Throwable t) {
				verificationFailedMessage(
						"The progressive percentage of tasks section of the portfolio dashboard is not displayed correctly.");
			}

			// validate the count of the open tasks

			try {
				String openTaskCount = (driver
						.findElement(By.xpath(OR.getProperty("portfoliodashboard_tasksection_opentaskcount_XPATH")))
						.getText()).trim();
				int openTaskCount_int = Integer.parseInt(openTaskCount);

				if (openTaskCount_int == (random11 + 1)) {

					successMessage(
							"The count of open task in the tasks section of the portfolio dashboard is displayed correctly.");

				} else {

					verificationFailedMessage(
							"The count of open task in the tasks section of the portfolio dashboard is not displayed correctly.");

				}
			} catch (Throwable t) {
				verificationFailedMessage(
						"The count of open task in the tasks section of the portfolio dashboard is not displayed correctly.");
			}

			// validate the count of the overdue tasks

			try {
				String overdueTaskCount = (driver
						.findElement(By.xpath(OR.getProperty("portfoliodashboard_tasksection_overduetaskcount_XPATH")))
						.getText()).trim();
				int overdueTaskCount_int = Integer.parseInt(overdueTaskCount);

				if (overdueTaskCount_int == 1) {

					successMessage(
							"The count of overdue task in the tasks section of the portfolio dashboard is displayed correctly.");

				} else {

					verificationFailedMessage(
							"The count of overdue task in the tasks section of the portfolio dashboard is not displayed correctly.");

				}
			} catch (Throwable t) {
				verificationFailedMessage(
						"The count of overdue task in the tasks section of the portfolio dashboard is not displayed correctly.");
			}

			// validate the count of the unscheduled tasks

			try {
				String unscheduledTaskCount = (driver
						.findElement(
								By.xpath(OR.getProperty("portfoliodashboard_tasksection_unscheduledtaskcount_XPATH")))
						.getText()).trim();
				int unscheduledTaskCount_int = Integer.parseInt(unscheduledTaskCount);

				if (unscheduledTaskCount_int == random11) {

					successMessage(
							"The count of unscheduled task in the tasks section of the portfolio dashboard is displayed correctly.");

				} else {

					verificationFailedMessage(
							"The count of unscheduled task in the tasks section of the portfolio dashboard is not displayed correctly.");

				}
			} catch (Throwable t) {
				verificationFailedMessage(
						"The count of unscheduled task in the tasks section of the portfolio dashboard is not displayed correctly.");
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

		// CREATE THE TASK IN PROPERTY TWO WITH PAST DATE AS A DUE DATE

		title("CREATE THE TASK IN PROPERTY TWO WITH PAST DATE AS A DUE DATE");

		try {

			// enter the property name in the search field
			clear("envreports_propertylist_filtertxt_CSS");
			type("envreports_propertylist_filtertxt_CSS", data.get("property_2"));
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

			// click on the assign to field
			click("task_assigntotxt_CSS");
			System.out.println("Clicked on the assign to field.");
			ngDriver.waitForAngularRequestsToFinish();

			// click on the none button
			click("task_tasktag_nonebtn_CSS");
			System.out.println("Clicked on the none button.");
			ngDriver.waitForAngularRequestsToFinish();

			// enter the user name in the search field
			clear("workflowsecurity_editortask_taskdetails_searchtasktagtxt_CSS");
			type("workflowsecurity_editortask_taskdetails_searchtasktagtxt_CSS", data.get("search_user"));
			System.out.println("Entered the user name in the search field.");
			ngDriver.waitForAngularRequestsToFinish();

			// click on the searched result
			click("questionnaire_createtask_selectusertxt_XPATH");
			System.out.println("Clicked on the searched result.");
			ngDriver.waitForAngularRequestsToFinish();

			// click on the assign to field
			click("task_assigntotxt_CSS");
			System.out.println("Clicked on the assign to field.");
			ngDriver.waitForAngularRequestsToFinish();

			// scroll down the screen
			JavascriptExecutor js = (JavascriptExecutor) driver;
			js.executeScript("window.scrollBy(0,document.body.scrollHeight)");

			// select the environmental option from the module dropdown
			select("task_addtask_moduledd_CSS", data.get("task_module"));
			System.out.println("Selected the environmental option from the module dropdown.");
			ngDriver.waitForAngularRequestsToFinish();

			// click on the save button
			click("survey_task_savebtn_CSS");
			System.out.println("Clicked on the save button.");
			ngDriver.waitForAngularRequestsToFinish();

			// wait for the element
			explicitWaitClickable("closetoastmsg_CSS");

			// click on the toaster close button
			click("closetoastmsg_CSS");
			ngDriver.waitForAngularRequestsToFinish();
			System.out.println("Clicked on the toaster close button.");

			// scroll up the screen
			js.executeScript("window.scrollTo(0,0)");

			// click on the clear button
			click("task_createdtask_clearbtn_XPATH");
			ngDriver.waitForAngularRequestsToFinish();
			System.out.println("Clicked on the clear button.");

			// enter the data in the search field
			clear("task_filter_CSS");
			type("task_filter_CSS", data.get("task_title_2"));
			System.out.println("Entered the data in the search field.");
			ngDriver.waitForAngularRequestsToFinish();

			// click on the search button
			click("task_createdtask_searchbtn_XPATH");
			ngDriver.waitForAngularRequestsToFinish();
			System.out.println("Clicked on the search button.");

			// click on the searched task
			click("portfoliodashboard_tasksection_newlycreatedtask2_XPATH");
			ngDriver.waitForAngularRequestsToFinish();
			System.out.println("Clicked on the searched task.");

			// click on the change due date
			click("questionnaire_inspection_tasks_changeduedatbtn_XPATH");
			ngDriver.waitForAngularRequestsToFinish();
			System.out.println("Clicked on the change due date.");

			// enter past date in the date field
			LocalDate pastDate = LocalDate.now().minusDays(5);
			String pastDate_string = pastDate.toString();
			clear("portfoliodashboard_tasksection_newduedatetxt_XPATH");
			type("portfoliodashboard_tasksection_newduedatetxt_XPATH", pastDate_string);
			ngDriver.waitForAngularRequestsToFinish();
			System.out.println("Entered past date in the date field.");

			// click on the apply button
			click("task_tasktag_newduedatetxt_applybtn_CSS");
			ngDriver.waitForAngularRequestsToFinish();
			System.out.println("Clicked on the apply button.");

			// click on the update button
			click("portfoliodashboard_tasksection_updatebtn_XPATH");
			ngDriver.waitForAngularRequestsToFinish();
			System.out.println("Clicked on the update button.");

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

		// VALIDATE RESPECTIVE TASK COUNT ON THE TASKS SECTION OF THE PORTFOLIO SUMMARY
		// DASHBOARD AFTER CREATED THE TASK WITH PAST DATE AS A DUE DATE

		title("VALIDATE RESPECTIVE TASK COUNT ON THE TASKS SECTION OF THE PORTFOLIO SUMMARY DASHBOARD AFTER CREATED THE TASKS WITH PAST DATE AS A DUE DATE");

		try {
			// wait for the element
			Thread.sleep(5000);

			// click on the side menu
			click("menubtn_CSS");
			ngDriver.waitForAngularRequestsToFinish();
			System.out.println("Clicked on the side menu.");

			// wait for the element
			Thread.sleep(5000);

			// click on the portfolio dashboard from side menu
			click("sidemenu_portfoliosummary_XPATH");
			ngDriver.waitForAngularRequestsToFinish();
			System.out.println("Clicked on the portfolio dashboard from side menu.");

			// scrolldown till task section
			WebElement taskTitle = driver
					.findElement(By.xpath(OR.getProperty("portfoliodashboard_tasksection_title_XPATH")));
			JavascriptExecutor js = (JavascriptExecutor) driver;
			js.executeScript("arguments[0].scrollIntoView(true);", taskTitle);

			// wait for the element
			Thread.sleep(10000);

			// validate the progress graph percentage

			try {

				int sum2 = random11 + 2;
				System.out.println("sum2 :::::::" + sum2);

				int graph2 = (2 * 100) / sum2;
				System.out.println("graph2 ::::::" + graph2);

				int graph2_round = Math.round(graph2);

				String graph2_round_string = Integer.toString(graph2_round);

				System.out.println("graph2_round_string:::::::::::" + graph2_round_string);

				String progressPercentage = (driver
						.findElement(By.xpath(OR.getProperty("portfoliodashboard_tasksection_progresscount_XPATH")))
						.getText()).trim();

				if (progressPercentage.equals(graph2_round_string + "%")) {

					System.out.println("graph2_string with %:::::::::::" + graph2_round_string + "%");

					successMessage(
							"The progressive percentage of tasks section of the portfolio dashboard is displayed correctly.");

				} else {

					verificationFailedMessage(
							"The progressive percentage of tasks section of the portfolio dashboard is not displayed correctly.");

				}
			} catch (Throwable t) {
				verificationFailedMessage(
						"The progressive percentage of tasks section of the portfolio dashboard is not displayed correctly.");
			}

			// validate the count of the open tasks

			try {
				String openTaskCount = (driver
						.findElement(By.xpath(OR.getProperty("portfoliodashboard_tasksection_opentaskcount_XPATH")))
						.getText()).trim();
				int openTaskCount_int = Integer.parseInt(openTaskCount);

				if (openTaskCount_int == (random11 + 2)) {

					successMessage(
							"The count of open task in the tasks section of the portfolio dashboard is displayed correctly.");

				} else {

					verificationFailedMessage(
							"The count of open task in the tasks section of the portfolio dashboard is not displayed correctly.");

				}
			} catch (Throwable t) {
				verificationFailedMessage(
						"The count of open task in the tasks section of the portfolio dashboard is not displayed correctly.");
			}

			// validate the count of the overdue tasks

			try {
				String overdueTaskCount = (driver
						.findElement(By.xpath(OR.getProperty("portfoliodashboard_tasksection_overduetaskcount_XPATH")))
						.getText()).trim();
				int overdueTaskCount_int = Integer.parseInt(overdueTaskCount);

				if (overdueTaskCount_int == 2) {

					successMessage(
							"The count of overdue task in the tasks section of the portfolio dashboard is displayed correctly.");

				} else {

					verificationFailedMessage(
							"The count of overdue task in the tasks section of the portfolio dashboard is not displayed correctly.");

				}
			} catch (Throwable t) {
				verificationFailedMessage(
						"The count of overdue task in the tasks section of the portfolio dashboard is not displayed correctly.");
			}

			// validate the count of the unscheduled tasks

			try {
				String unscheduledTaskCount = (driver
						.findElement(
								By.xpath(OR.getProperty("portfoliodashboard_tasksection_unscheduledtaskcount_XPATH")))
						.getText()).trim();
				int unscheduledTaskCount_int = Integer.parseInt(unscheduledTaskCount);

				if (unscheduledTaskCount_int == random11) {

					successMessage(
							"The count of unscheduled task in the tasks section of the portfolio dashboard is displayed correctly.");

				} else {

					verificationFailedMessage(
							"The count of unscheduled task in the tasks section of the portfolio dashboard is not displayed correctly.");

				}
			} catch (Throwable t) {
				verificationFailedMessage(
						"The count of unscheduled task in the tasks section of the portfolio dashboard is not displayed correctly.");
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

		// UPDATE THE TASK IN PROPERTY TWO WITH FURURE DATE AS A DUE DATE

		title("UPDATE THE TASK IN PROPERTY TWO WITH FURURE DATE AS A DUE DATE");

		try {

			// enter the property name in the search field
			clear("envreports_propertylist_filtertxt_CSS");
			type("envreports_propertylist_filtertxt_CSS", data.get("property_2"));
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
			clear("task_filter_CSS");
			type("task_filter_CSS", data.get("task_title_2"));
			System.out.println("Entered the data in the search field.");
			ngDriver.waitForAngularRequestsToFinish();

			// click on the search button
			click("task_createdtask_searchbtn_XPATH");
			ngDriver.waitForAngularRequestsToFinish();
			System.out.println("Clicked on the search button.");

			// click on the searched task
			click("portfoliodashboard_tasksection_newlycreatedtask2_XPATH");
			ngDriver.waitForAngularRequestsToFinish();
			System.out.println("Clicked on the searched task.");

			// click on the change due date
			click("questionnaire_inspection_tasks_changeduedatbtn_XPATH");
			ngDriver.waitForAngularRequestsToFinish();
			System.out.println("Clicked on the change due date.");

			// enter future date in the date field
			LocalDate futureDate = LocalDate.now().plusDays(5);
			String futureDate_string = futureDate.toString();
			clear("portfoliodashboard_tasksection_newduedatetxt_XPATH");
			type("portfoliodashboard_tasksection_newduedatetxt_XPATH", futureDate_string);
			ngDriver.waitForAngularRequestsToFinish();
			System.out.println("Entered past date in the date field.");

			// click on the apply button
			click("task_tasktag_newduedatetxt_applybtn_CSS");
			ngDriver.waitForAngularRequestsToFinish();
			System.out.println("Clicked on the apply button.");

			// click on the update button
			click("portfoliodashboard_tasksection_updatebtn_XPATH");
			ngDriver.waitForAngularRequestsToFinish();
			System.out.println("Clicked on the update button.");

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

		// VALIDATE RESPECTIVE TASK COUNT ON THE TASKS SECTION OF THE PORTFOLIO SUMMARY
		// DASHBOARD AFTER CREATED THE TASK WITH FUTURE DATE AS A DUE DATE

		title("VALIDATE RESPECTIVE TASK COUNT ON THE TASKS SECTION OF THE PORTFOLIO SUMMARY DASHBOARD AFTER CREATED THE TASKS WITH FUTURE DATE AS A DUE DATE");

		try {
			// wait for the element
			Thread.sleep(5000);

			// click on the side menu
			click("menubtn_CSS");
			ngDriver.waitForAngularRequestsToFinish();
			System.out.println("Clicked on the side menu.");

			// wait for the element
			Thread.sleep(5000);

			// click on the portfolio dashboard from side menu
			click("sidemenu_portfoliosummary_XPATH");
			ngDriver.waitForAngularRequestsToFinish();
			System.out.println("Clicked on the portfolio dashboard from side menu.");

			// scrolldown till task section
			WebElement taskTitle = driver
					.findElement(By.xpath(OR.getProperty("portfoliodashboard_tasksection_title_XPATH")));
			JavascriptExecutor js = (JavascriptExecutor) driver;
			js.executeScript("arguments[0].scrollIntoView(true);", taskTitle);

			// wait for the element
			Thread.sleep(10000);

			// validate the progress graph percentage

			try {

				int sum3 = random11 + 2;
				System.out.println("sum3 :::::::" + sum3);

				int graph3 = (1 * 100) / sum3;
				System.out.println("graph3 ::::::" + graph3);

				int graph3_round = Math.round(graph3);

				String graph3_round_string = Integer.toString(graph3_round);

				String progressPercentage = (driver
						.findElement(By.xpath(OR.getProperty("portfoliodashboard_tasksection_progresscount_XPATH")))
						.getText()).trim();

				if (progressPercentage.equals(graph3_round_string + "%")) {

					successMessage(
							"The progressive percentage of tasks section of the portfolio dashboard is displayed correctly.");

				} else {

					verificationFailedMessage(
							"The progressive percentage of tasks section of the portfolio dashboard is not displayed correctly.");

				}
			} catch (Throwable t) {
				verificationFailedMessage(
						"The progressive percentage of tasks section of the portfolio dashboard is not displayed correctly.");
			}

			// validate the count of the open tasks

			try {
				String openTaskCount = (driver
						.findElement(By.xpath(OR.getProperty("portfoliodashboard_tasksection_opentaskcount_XPATH")))
						.getText()).trim();
				int openTaskCount_int = Integer.parseInt(openTaskCount);

				if (openTaskCount_int == (random11 + 2)) {

					successMessage(
							"The count of open task in the tasks section of the portfolio dashboard is displayed correctly.");

				} else {

					verificationFailedMessage(
							"The count of open task in the tasks section of the portfolio dashboard is not displayed correctly.");

				}
			} catch (Throwable t) {
				verificationFailedMessage(
						"The count of open task in the tasks section of the portfolio dashboard is not displayed correctly.");
			}

			// validate the count of the overdue tasks

			try {
				String overdueTaskCount = (driver
						.findElement(By.xpath(OR.getProperty("portfoliodashboard_tasksection_overduetaskcount_XPATH")))
						.getText()).trim();
				int overdueTaskCount_int = Integer.parseInt(overdueTaskCount);

				if (overdueTaskCount_int == 1) {

					successMessage(
							"The count of overdue task in the tasks section of the portfolio dashboard is displayed correctly.");

				} else {

					verificationFailedMessage(
							"The count of overdue task in the tasks section of the portfolio dashboard is not displayed correctly.");

				}
			} catch (Throwable t) {
				verificationFailedMessage(
						"The count of overdue task in the tasks section of the portfolio dashboard is not displayed correctly.");
			}

			// validate the count of the unscheduled tasks

			try {
				String unscheduledTaskCount = (driver
						.findElement(
								By.xpath(OR.getProperty("portfoliodashboard_tasksection_unscheduledtaskcount_XPATH")))
						.getText()).trim();
				int unscheduledTaskCount_int = Integer.parseInt(unscheduledTaskCount);

				if (unscheduledTaskCount_int == (random11 + 1)) {

					successMessage(
							"The count of unscheduled task in the tasks section of the portfolio dashboard is displayed correctly.");

				} else {

					verificationFailedMessage(
							"The count of unscheduled task in the tasks section of the portfolio dashboard is not displayed correctly.");

				}
			} catch (Throwable t) {
				verificationFailedMessage(
						"The count of unscheduled task in the tasks section of the portfolio dashboard is not displayed correctly.");
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

		// DELETE ALL THE PREVIOUSLY CREATED TASKS FROM MY TASK LIST

		title("DELETE ALL THE PREVIOUSLY CREATED TASKS FROM MY TASK LIST");

		try {

			// wait for the element
			Thread.sleep(5000);

			// click on the side menu
			click("menubtn_CSS");
			ngDriver.waitForAngularRequestsToFinish();
			System.out.println("Clicked on the side menu.");

			// wait for the element
			Thread.sleep(5000);

			// click on the my task option
			click("mytask_sidemenu_XPATH");
			ngDriver.waitForAngularRequestsToFinish();
			System.out.println("Clicked on the my task option.");

			// click on the clear button
			click("mytaskdashboard_createdtask_clearbtn_XPATH");
			ngDriver.waitForAngularRequestsToFinish();
			System.out.println("Clicked on the clear button.");

			// wait for the element
			Thread.sleep(5000);

			// delete all the previously created tasks
			try {
				String pages1 = (driver
						.findElement(By.xpath(
								"//i[@ng-click='previousPageData()']//following-sibling::strong[@class='ng-binding']"))
						.getText()).trim();
				String[] arrOfStr1 = pages1.split(" ");
				String pageno1 = arrOfStr1[3];
				int pagecount1 = Integer.parseInt(pageno1);

				for (int i1 = 0; i1 < pagecount1; i1++) {

					List<WebElement> roles1 = driver.findElements(By.xpath("//table[@id='tasksTable']//tbody//tr"));
					int rolesnum1 = roles1.size();

					for (int j1 = 0; j1 < rolesnum1; j1++) {

						// wait for the element
						Thread.sleep(3000);

						// click on the action icon of the first record
						click("mytask_firstactionicon_XPATH");
						ngDriver.waitForAngularRequestsToFinish();
						System.out.println("Clicked on the action icon of the first record.");

						// wait for the element
						Thread.sleep(3000);

						// click on the delete option
						click("mytask_firstactionicon_deleteoption_XPATH");
						ngDriver.waitForAngularRequestsToFinish();
						System.out.println("Clicked on the delete option.");

						// wait for the element
						Thread.sleep(5000);

					}

					// click on the next button
					click("task_permission_roles_nextbtn_CSS");
					ngDriver.waitForAngularRequestsToFinish();
					System.out.println("Clicked on the next button.");

				}
			} catch (Throwable t) {

				successMessage("Successfully deleted all the tasks.");

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

		// VALIDATE RESPECTIVE TASK COUNT ON THE TASKS SECTION OF THE PORTFOLIO SUMMARY
		// DASHBOARD AFTER DELETE ALL THE TASKS

		title("VALIDATE RESPECTIVE TASK COUNT ON THE TASKS SECTION OF THE PORTFOLIO SUMMARY DASHBOARD AFTER DELETE ALL THE TASKS");

		try {
			// wait for the element
			Thread.sleep(5000);

			// click on the side menu
			click("menubtn_CSS");
			ngDriver.waitForAngularRequestsToFinish();
			System.out.println("Clicked on the side menu.");

			// wait for the element
			Thread.sleep(5000);

			// click on the portfolio dashboard from side menu
			click("sidemenu_portfoliosummary_XPATH");
			ngDriver.waitForAngularRequestsToFinish();
			System.out.println("Clicked on the portfolio dashboard from side menu.");

			// scrolldown till task section
			WebElement taskTitle = driver
					.findElement(By.xpath(OR.getProperty("portfoliodashboard_tasksection_title_XPATH")));
			JavascriptExecutor js = (JavascriptExecutor) driver;
			js.executeScript("arguments[0].scrollIntoView(true);", taskTitle);

			// wait for the element
			Thread.sleep(10000);

			// validate the progress graph percentage

			try {
				String progressPercentage = (driver
						.findElement(By.xpath(OR.getProperty("portfoliodashboard_tasksection_progresscount_XPATH")))
						.getText()).trim();

				if (progressPercentage.equals("0%")) {

					successMessage(
							"The progressive percentage of tasks section of the portfolio dashboard is displayed correctly.");

				} else {

					verificationFailedMessage(
							"The progressive percentage of tasks section of the portfolio dashboard is not displayed correctly.");

				}
			} catch (Throwable t) {
				verificationFailedMessage(
						"The progressive percentage of tasks section of the portfolio dashboard is not displayed correctly.");
			}

			// validate the count of the open tasks

			try {
				String openTaskCount = (driver
						.findElement(By.xpath(OR.getProperty("portfoliodashboard_tasksection_opentaskcount_XPATH")))
						.getText()).trim();
				int openTaskCount_int = Integer.parseInt(openTaskCount);

				if (openTaskCount_int == 0) {

					successMessage(
							"The count of open task in the tasks section of the portfolio dashboard is displayed correctly.");

				} else {

					verificationFailedMessage(
							"The count of open task in the tasks section of the portfolio dashboard is not displayed correctly.");

				}
			} catch (Throwable t) {
				verificationFailedMessage(
						"The count of open task in the tasks section of the portfolio dashboard is not displayed correctly.");
			}

			// validate the count of the overdue tasks

			try {
				String overdueTaskCount = (driver
						.findElement(By.xpath(OR.getProperty("portfoliodashboard_tasksection_overduetaskcount_XPATH")))
						.getText()).trim();
				int overdueTaskCount_int = Integer.parseInt(overdueTaskCount);

				if (overdueTaskCount_int == 0) {

					successMessage(
							"The count of overdue task in the tasks section of the portfolio dashboard is displayed correctly.");

				} else {

					verificationFailedMessage(
							"The count of overdue task in the tasks section of the portfolio dashboard is not displayed correctly.");

				}
			} catch (Throwable t) {
				verificationFailedMessage(
						"The count of overdue task in the tasks section of the portfolio dashboard is not displayed correctly.");
			}

			// validate the count of the unscheduled tasks

			try {
				String unscheduledTaskCount = (driver
						.findElement(
								By.xpath(OR.getProperty("portfoliodashboard_tasksection_unscheduledtaskcount_XPATH")))
						.getText()).trim();
				int unscheduledTaskCount_int = Integer.parseInt(unscheduledTaskCount);

				if (unscheduledTaskCount_int == 0) {

					successMessage(
							"The count of unscheduled task in the tasks section of the portfolio dashboard is displayed correctly.");

				} else {

					verificationFailedMessage(
							"The count of unscheduled task in the tasks section of the portfolio dashboard is not displayed correctly.");

				}
			} catch (Throwable t) {
				verificationFailedMessage(
						"The count of unscheduled task in the tasks section of the portfolio dashboard is not displayed correctly.");
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

	}
}
