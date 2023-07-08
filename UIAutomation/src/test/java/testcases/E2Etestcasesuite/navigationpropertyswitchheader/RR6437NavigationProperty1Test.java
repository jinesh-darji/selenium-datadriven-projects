package testcases.E2Etestcasesuite.navigationpropertyswitchheader;

import java.io.IOException;
import java.util.Hashtable;
import java.util.List;

import org.apache.commons.lang3.RandomStringUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import base.Helper;
import base.TestBase;
import utilities.TestUtil;

public class RR6437NavigationProperty1Test extends TestBase {

	@Test(dataProviderClass = TestUtil.class, dataProvider = "dp")
	public void rR6437NavigationProperty1Test(Hashtable<String, String> data) throws InterruptedException, IOException {

		execution(data, "rR6437NavigationProperty1Test");

		// APPLICATION DASHBOARD - NAVIGATION SCENARIO OF THE PROPERTY SUMMARY
		// DASHBOARD, SURVEYS, PROPERTY LIST, BUILDING LIST, HIGH RISK PROPERTIES, MY
		// TASKS, AND STATEMENT OF VALUES.
		title("APPLICATION DASHBOARD - NAVIGATION SCENARIO OF THE PROPERTY SUMMARY DASHBOARD, SURVEYS, PROPERTY LIST, BUILDING LIST, HIGH RISK PROPERTIES, MY TASKS, AND STATEMENT OF VALUES.");

		// refresh the page
		driver.navigate().refresh();
		Thread.sleep(5000);
		driver.navigate().refresh();

		// DELETE ALL THE NEWLY CREATED TASKS
		title("DELETE ALL THE NEWLY CREATED TASKS");

		try {
			// click on the task icon
			click("taskicon_CSS");

			// delete all the previously created tasks
			try {
				String pages = (driver.findElement(By.xpath(
						"//i[@ng-click='previousPageData(taskSelectedFilterType)']//following-sibling::strong[@class='ng-binding']"))
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
						click("task_firstactionicon_XPATH");
						ngDriver.waitForAngularRequestsToFinish();
						System.out.println("Clicked on the action icon of the first record.");

						// wait for the element
						Thread.sleep(3000);

						// click on the delete option
						click("task_firstactionicon_deleteoption_XPATH");

						// wait for the element
						explicitWaitClickable("closetoastmsg_CSS");

						// click on the toaster close button
						click("closetoastmsg_CSS");

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

		// synchronization
		explicitWait("propertylist_title_XPATH");

		// verify the property list
		switchVerification("propertylist_title_XPATH", "Property List", "The property list is not displayed.");

		// ADD THE TASK
		title("ADD THE TASK");

		String taskTitle = RandomStringUtils.randomAlphabetic(8);

		try {
			// click on the task icon
			click("taskicon_CSS");

			// click on the add task button
			click("task_addtaskbtn_CSS");

			// enter the data in the task title field
			type("task_addtask_titletxt_CSS", taskTitle);

			// enter the data in the task location field
			type("task_addtask_locationtxt_CSS", "USA");

			// click on the assign to field
			click("task_assigntotxt_CSS");

			// click on the none button
			click("task_tasktag_nonebtn_CSS");

			// enter the user name in the search field
			type("workflowsecurity_editortask_taskdetails_searchtasktagtxt_CSS", "Jinesh");

			// click on the searched result
			click("questionnaire_createtask_selectusertxt_XPATH");

			// click on the assign to field
			click("task_assigntotxt_CSS");

			// scroll down the screen
			scrollBottom();

			// click on the save button
			click("survey_task_savebtn_CSS");

			// scroll up the screen
			scrollTop();

			// click on the clear button
			click("task_createdtask_clearbtn_XPATH");

			// enter the data in the search field
			type("task_filter_CSS", taskTitle);

			// click on the search button
			click("task_createdtask_searchbtn_XPATH");

			// verify newly created task is displayed or not
			try {
				String title = "//p[contains(text(),'" + taskTitle + "')]";
				String title_actual = (driver.findElement(By.xpath(title)).getText()).trim();

				if (title_actual.equals(taskTitle)) {

					successMessage("The " + taskTitle + " is verified successfully.");

				} else {
					verificationFailedMessage("The " + taskTitle + " is not verified.");
				}
			} catch (Throwable t) {
				verificationFailedMessage("The " + taskTitle + " is not verified.");
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

		// VALIDATE THE NAVIGATION AFTER SWITCHING THE PROPERTY FROM THE HEADER OF
		// THE PROPERTY SUMMARY DASHBOARD SCREEN
		title("VALIDATE THE NAVIGATION AFTER SWITCHING THE PROPERTY FROM THE HEADER OF THE PROPERTY SUMMARY DASHBOARD SCREEN");

		try {

			// click on the property name from property listing screen
			click("propertylist_propertyname_XPATH");

			// VALIDATE FOR PROPERTY ONE
			title("VALIDATE FOR PROPERTY ONE");

			// validate the property name
			switchVerification("navigation_header_propertyname1_XPATH", "[DND] AAAA Risk Test Prop 01 - 01",
					"The property name is not displayed.");

			try {
				// scroll down till task card
				scrollTillElement("task_navigation_tasklbl_XPATH");

				// validate the task count
				String taskCount = (driver.findElement(By.xpath(OR.getProperty("propertydashboard_taskcount_XPATH")))
						.getText()).trim();

				if (taskCount.equals("1")) {
					successMessage("The task count is displayed correctly.");
				} else {
					verificationFailedMessage("The task count is not displayed correctly.");
				}
			} catch (Throwable t) {
				verificationFailedMessage("The task count is not displayed correctly.");
			}

			// VALIDATE FOR PROPERTY TWO
			title("VALIDATE FOR PROPERTY TWO");

			// wait for the element
			explicitWaitClickable("navigation_header_searchicon_XPATH");

			// click on the search icon from the header
			click("navigation_header_searchicon_XPATH");

			// enter property 2 number in text field
			type("navigation_header_searchtxt_XPATH", "02");

			// hit enter key
			driver.findElement(By.xpath(OR.getProperty("navigation_header_searchtxt_XPATH"))).sendKeys(Keys.ENTER);
			consoleMessage("Hit enter key.");

			// wait for the element
			Thread.sleep(2000);

			// click on the settings icon from the top of the screen
			click("questionnaire_settingicon_CSS");

			// wait for the element
			Thread.sleep(1000);

			// click on the cancel icon
			click("questionnaire_setting_cancelicon_XPATH");

			// validate the property name
			switchVerification("navigation_header_propertyname2_XPATH", "[DND] AAAA Risk Test Prop 02 - 02",
					"The property name is not displayed.");

			try {
				// scroll down till task card
				scrollTillElement("task_navigation_tasklbl_XPATH");

				// validate the task count
				String taskCount = (driver.findElement(By.xpath(OR.getProperty("propertydashboard_taskcount_XPATH")))
						.getText()).trim();

				if (taskCount.equals("0")) {
					successMessage("The task count is displayed correctly.");
				} else {
					verificationFailedMessage("The task count is not displayed correctly.");
				}
			} catch (Throwable t) {
				verificationFailedMessage("The task count is not displayed correctly.");
			}

			// VALIDATE FOR PROPERTY THREE
			title("VALIDATE FOR PROPERTY THREE");

			// wait for the element
			explicitWaitClickable("navigation_header_searchicon_XPATH");

			// click on the search icon from the header
			click("navigation_header_searchicon_XPATH");

			// enter property 2 number in text field
			type("navigation_header_searchtxt_XPATH", "03");

			// hit enter key
			driver.findElement(By.xpath(OR.getProperty("navigation_header_searchtxt_XPATH"))).sendKeys(Keys.ENTER);
			consoleMessage("Hit enter key.");

			// wait for the element
			Thread.sleep(2000);

			// click on the settings icon from the top of the screen
			click("questionnaire_settingicon_CSS");

			// wait for the element
			Thread.sleep(1000);

			// click on the cancel icon
			click("questionnaire_setting_cancelicon_XPATH");

			// validate the property name
			switchVerification("navigation_header_propertyname3_XPATH", "[DND] AAAA Risk Test Prop 03 - 03",
					"The property name is not displayed.");

			try {
				// scroll down till task card
				scrollTillElement("task_navigation_tasklbl_XPATH");

				// validate the task count
				String taskCount = (driver.findElement(By.xpath(OR.getProperty("propertydashboard_taskcount_XPATH")))
						.getText()).trim();

				if (taskCount.equals("0")) {
					successMessage("The task count is displayed correctly.");
				} else {
					verificationFailedMessage("The task count is not displayed correctly.");
				}
			} catch (Throwable t) {
				verificationFailedMessage("The task count is not displayed correctly.");
			}

			// VALIDATE FOR PROPERTY ONE
			title("VALIDATE FOR PROPERTY ONE");

			// wait for the element
			explicitWaitClickable("navigation_header_searchicon_XPATH");

			// click on the search icon from the header
			click("navigation_header_searchicon_XPATH");

			// enter property 2 number in text field
			type("navigation_header_searchtxt_XPATH", "01");

			// hit enter key
			driver.findElement(By.xpath(OR.getProperty("navigation_header_searchtxt_XPATH"))).sendKeys(Keys.ENTER);
			consoleMessage("Hit enter key.");

			// validate the property name
			switchVerification("navigation_header_propertyname1_XPATH", "[DND] AAAA Risk Test Prop 01 - 01",
					"The property name is not displayed.");

			try {
				// scroll down till task card
				scrollTillElement("task_navigation_tasklbl_XPATH");

				// validate the task count
				String taskCount = (driver.findElement(By.xpath(OR.getProperty("propertydashboard_taskcount_XPATH")))
						.getText()).trim();

				if (taskCount.equals("1")) {
					successMessage("The task count is displayed correctly.");
				} else {
					verificationFailedMessage("The task count is not displayed correctly.");
				}
			} catch (Throwable t) {
				verificationFailedMessage("The task count is not displayed correctly.");
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

		// VALIDATE THE NAVIGATION AFTER SWITCHING THE PROPERTY FROM THE HEADER OF
		// THE SURVEY DASHBOARD SCREEN
		title("VALIDATE THE NAVIGATION AFTER SWITCHING THE PROPERTY FROM THE HEADER OF THE SURVEY DASHBOARD SCREEN");

		try {

			// select the survey option from the dashboard dropdown
			select("dashboard_CSS", "Surveys");

			// VALIDATE FOR PROPERTY ONE
			title("VALIDATE FOR PROPERTY ONE");

			// validate the survey title
			switchVerification("applicationdashboard_surveytitle_XPATH", "Surveys",
					"The Surveys title is not displayed.");

			// VALIDATE FOR PROPERTY TWO
			title("VALIDATE FOR PROPERTY TWO");

			// wait for the element
			explicitWaitClickable("navigation_header_searchicon_XPATH");

			// click on the search icon from the header
			click("navigation_header_searchicon_XPATH");

			// enter property 2 number in text field
			type("navigation_header_searchtxt_XPATH", "02");

			// hit enter key
			driver.findElement(By.xpath(OR.getProperty("navigation_header_searchtxt_XPATH"))).sendKeys(Keys.ENTER);
			consoleMessage("Hit enter key.");

			// wait for the element
			Thread.sleep(2000);

			// click on the settings icon from the top of the screen
			click("questionnaire_settingicon_CSS");

			// wait for the element
			Thread.sleep(1000);

			// click on the cancel icon
			click("questionnaire_setting_cancelicon_XPATH");

			// validate the property name
			switchVerification("navigation_header_propertyname2_XPATH", "[DND] AAAA Risk Test Prop 02 - 02",
					"The property name is not displayed.");

			try {
				// scroll down till task card
				scrollTillElement("task_navigation_tasklbl_XPATH");

				// validate the task count
				String taskCount = (driver.findElement(By.xpath(OR.getProperty("propertydashboard_taskcount_XPATH")))
						.getText()).trim();

				if (taskCount.equals("0")) {
					successMessage("The task count is displayed correctly.");
				} else {
					verificationFailedMessage("The task count is not displayed correctly.");
				}
			} catch (Throwable t) {
				verificationFailedMessage("The task count is not displayed correctly.");
			}

			// VALIDATE FOR PROPERTY THREE
			title("VALIDATE FOR PROPERTY THREE");

			// wait for the element
			explicitWaitClickable("navigation_header_searchicon_XPATH");

			// click on the search icon from the header
			click("navigation_header_searchicon_XPATH");

			// enter property 2 number in text field
			type("navigation_header_searchtxt_XPATH", "03");

			// hit enter key
			driver.findElement(By.xpath(OR.getProperty("navigation_header_searchtxt_XPATH"))).sendKeys(Keys.ENTER);
			consoleMessage("Hit enter key.");

			// wait for the element
			Thread.sleep(2000);

			// click on the settings icon from the top of the screen
			click("questionnaire_settingicon_CSS");

			// wait for the element
			Thread.sleep(1000);

			// click on the cancel icon
			click("questionnaire_setting_cancelicon_XPATH");

			// validate the property name
			switchVerification("navigation_header_propertyname3_XPATH", "[DND] AAAA Risk Test Prop 03 - 03",
					"The property name is not displayed.");

			try {
				// scroll down till task card
				scrollTillElement("task_navigation_tasklbl_XPATH");

				// validate the task count
				String taskCount = (driver.findElement(By.xpath(OR.getProperty("propertydashboard_taskcount_XPATH")))
						.getText()).trim();

				if (taskCount.equals("0")) {
					successMessage("The task count is displayed correctly.");
				} else {
					verificationFailedMessage("The task count is not displayed correctly.");
				}
			} catch (Throwable t) {
				verificationFailedMessage("The task count is not displayed correctly.");
			}

			// VALIDATE FOR PROPERTY ONE
			title("VALIDATE FOR PROPERTY ONE");

			// wait for the element
			explicitWaitClickable("navigation_header_searchicon_XPATH");

			// click on the search icon from the header
			click("navigation_header_searchicon_XPATH");

			// enter property 2 number in text field
			type("navigation_header_searchtxt_XPATH", "01");

			// hit enter key
			driver.findElement(By.xpath(OR.getProperty("navigation_header_searchtxt_XPATH"))).sendKeys(Keys.ENTER);
			consoleMessage("Hit enter key.");

			// validate the property name
			switchVerification("navigation_header_propertyname1_XPATH", "[DND] AAAA Risk Test Prop 01 - 01",
					"The property name is not displayed.");

			try {
				// scroll down till task card
				scrollTillElement("task_navigation_tasklbl_XPATH");

				// validate the task count
				String taskCount = (driver.findElement(By.xpath(OR.getProperty("propertydashboard_taskcount_XPATH")))
						.getText()).trim();

				if (taskCount.equals("1")) {
					successMessage("The task count is displayed correctly.");
				} else {
					verificationFailedMessage("The task count is not displayed correctly.");
				}
			} catch (Throwable t) {
				verificationFailedMessage("The task count is not displayed correctly.");
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

		// VALIDATE THE NAVIGATION AFTER SWITCHING THE PROPERTY FROM THE HEADER OF
		// THE INSPECTION DASHBOARD SCREEN
		title("VALIDATE THE NAVIGATION AFTER SWITCHING THE PROPERTY FROM THE HEADER OF THE INSPECTION DASHBOARD SCREEN");

		try {

			// select the survey option from the dashboard dropdown
			select("dashboard_CSS", "Inspections");

			// VALIDATE FOR PROPERTY ONE
			title("VALIDATE FOR PROPERTY ONE");

			// validate the survey title
			switchVerification("applicationdashboard_inspectionstitle_XPATH", "Inspections",
					"The Inspections title is not displayed.");

			// VALIDATE FOR PROPERTY TWO
			title("VALIDATE FOR PROPERTY TWO");

			// wait for the element
			explicitWaitClickable("navigation_header_searchicon_XPATH");

			// click on the search icon from the header
			click("navigation_header_searchicon_XPATH");

			// enter property 2 number in text field
			type("navigation_header_searchtxt_XPATH", "02");

			// hit enter key
			driver.findElement(By.xpath(OR.getProperty("navigation_header_searchtxt_XPATH"))).sendKeys(Keys.ENTER);
			consoleMessage("Hit enter key.");

			// wait for the element
			Thread.sleep(2000);

			// click on the settings icon from the top of the screen
			click("questionnaire_settingicon_CSS");

			// wait for the element
			Thread.sleep(1000);

			// click on the cancel icon
			click("questionnaire_setting_cancelicon_XPATH");

			// validate the property name
			switchVerification("navigation_header_propertyname2_XPATH", "[DND] AAAA Risk Test Prop 02 - 02",
					"The property name is not displayed.");

			try {
				// scroll down till task card
				scrollTillElement("task_navigation_tasklbl_XPATH");

				// validate the task count
				String taskCount = (driver.findElement(By.xpath(OR.getProperty("propertydashboard_taskcount_XPATH")))
						.getText()).trim();

				if (taskCount.equals("0")) {
					successMessage("The task count is displayed correctly.");
				} else {
					verificationFailedMessage("The task count is not displayed correctly.");
				}
			} catch (Throwable t) {
				verificationFailedMessage("The task count is not displayed correctly.");
			}

			// VALIDATE FOR PROPERTY THREE
			title("VALIDATE FOR PROPERTY THREE");

			// wait for the element
			explicitWaitClickable("navigation_header_searchicon_XPATH");

			// click on the search icon from the header
			click("navigation_header_searchicon_XPATH");

			// enter property 2 number in text field
			type("navigation_header_searchtxt_XPATH", "03");

			// hit enter key
			driver.findElement(By.xpath(OR.getProperty("navigation_header_searchtxt_XPATH"))).sendKeys(Keys.ENTER);
			consoleMessage("Hit enter key.");

			// wait for the element
			Thread.sleep(2000);

			// click on the settings icon from the top of the screen
			click("questionnaire_settingicon_CSS");

			// wait for the element
			Thread.sleep(1000);

			// click on the cancel icon
			click("questionnaire_setting_cancelicon_XPATH");

			// validate the property name
			switchVerification("navigation_header_propertyname3_XPATH", "[DND] AAAA Risk Test Prop 03 - 03",
					"The property name is not displayed.");

			try {
				// scroll down till task card
				scrollTillElement("task_navigation_tasklbl_XPATH");

				// validate the task count
				String taskCount = (driver.findElement(By.xpath(OR.getProperty("propertydashboard_taskcount_XPATH")))
						.getText()).trim();

				if (taskCount.equals("0")) {
					successMessage("The task count is displayed correctly.");
				} else {
					verificationFailedMessage("The task count is not displayed correctly.");
				}
			} catch (Throwable t) {
				verificationFailedMessage("The task count is not displayed correctly.");
			}

			// VALIDATE FOR PROPERTY ONE
			title("VALIDATE FOR PROPERTY ONE");

			// wait for the element
			explicitWaitClickable("navigation_header_searchicon_XPATH");

			// click on the search icon from the header
			click("navigation_header_searchicon_XPATH");

			// enter property 2 number in text field
			type("navigation_header_searchtxt_XPATH", "01");

			// hit enter key
			driver.findElement(By.xpath(OR.getProperty("navigation_header_searchtxt_XPATH"))).sendKeys(Keys.ENTER);
			consoleMessage("Hit enter key.");

			// validate the property name
			switchVerification("navigation_header_propertyname1_XPATH", "[DND] AAAA Risk Test Prop 01 - 01",
					"The property name is not displayed.");

			try {
				// scroll down till task card
				scrollTillElement("task_navigation_tasklbl_XPATH");

				// validate the task count
				String taskCount = (driver.findElement(By.xpath(OR.getProperty("propertydashboard_taskcount_XPATH")))
						.getText()).trim();

				if (taskCount.equals("1")) {
					successMessage("The task count is displayed correctly.");
				} else {
					verificationFailedMessage("The task count is not displayed correctly.");
				}
			} catch (Throwable t) {
				verificationFailedMessage("The task count is not displayed correctly.");
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

		// VALIDATE THE NAVIGATION AFTER SWITCHING THE PROPERTY FROM THE HEADER OF
		// THE PROPERTY LIST SCREEN
		title("VALIDATE THE NAVIGATION AFTER SWITCHING THE PROPERTY FROM THE HEADER OF THE PROPERTY LIST SCREEN");

		try {

			// select the survey option from the dashboard dropdown
			select("dashboard_CSS", "Property List");

			// VALIDATE FOR PROPERTY ONE
			title("VALIDATE FOR PROPERTY ONE");

			// validate the property list title
			switchVerification("propertylist_title_XPATH", "Property List",
					"The Property List title is not displayed.");

			// VALIDATE FOR PROPERTY TWO
			title("VALIDATE FOR PROPERTY TWO");

			// wait for the element
			explicitWaitClickable("navigation_header_searchicon_XPATH");

			// click on the search icon from the header
			click("navigation_header_searchicon_XPATH");

			// enter property 2 number in text field
			type("navigation_header_searchtxt_XPATH", "02");

			// hit enter key
			driver.findElement(By.xpath(OR.getProperty("navigation_header_searchtxt_XPATH"))).sendKeys(Keys.ENTER);
			consoleMessage("Hit enter key.");

			// wait for the element
			Thread.sleep(2000);

			// click on the settings icon from the top of the screen
			click("questionnaire_settingicon_CSS");

			// wait for the element
			Thread.sleep(1000);

			// click on the cancel icon
			click("questionnaire_setting_cancelicon_XPATH");

			// validate the property name
			switchVerification("navigation_header_propertyname2_XPATH", "[DND] AAAA Risk Test Prop 02 - 02",
					"The property name is not displayed.");

			try {
				// scroll down till task card
				scrollTillElement("task_navigation_tasklbl_XPATH");

				// validate the task count
				String taskCount = (driver.findElement(By.xpath(OR.getProperty("propertydashboard_taskcount_XPATH")))
						.getText()).trim();

				if (taskCount.equals("0")) {
					successMessage("The task count is displayed correctly.");
				} else {
					verificationFailedMessage("The task count is not displayed correctly.");
				}
			} catch (Throwable t) {
				verificationFailedMessage("The task count is not displayed correctly.");
			}

			// VALIDATE FOR PROPERTY THREE
			title("VALIDATE FOR PROPERTY THREE");

			// wait for the element
			explicitWaitClickable("navigation_header_searchicon_XPATH");

			// click on the search icon from the header
			click("navigation_header_searchicon_XPATH");

			// enter property 2 number in text field
			type("navigation_header_searchtxt_XPATH", "03");

			// hit enter key
			driver.findElement(By.xpath(OR.getProperty("navigation_header_searchtxt_XPATH"))).sendKeys(Keys.ENTER);
			consoleMessage("Hit enter key.");

			// wait for the element
			Thread.sleep(2000);

			// click on the settings icon from the top of the screen
			click("questionnaire_settingicon_CSS");

			// wait for the element
			Thread.sleep(1000);

			// click on the cancel icon
			click("questionnaire_setting_cancelicon_XPATH");

			// validate the property name
			switchVerification("navigation_header_propertyname3_XPATH", "[DND] AAAA Risk Test Prop 03 - 03",
					"The property name is not displayed.");

			try {
				// scroll down till task card
				scrollTillElement("task_navigation_tasklbl_XPATH");

				// validate the task count
				String taskCount = (driver.findElement(By.xpath(OR.getProperty("propertydashboard_taskcount_XPATH")))
						.getText()).trim();

				if (taskCount.equals("0")) {
					successMessage("The task count is displayed correctly.");
				} else {
					verificationFailedMessage("The task count is not displayed correctly.");
				}
			} catch (Throwable t) {
				verificationFailedMessage("The task count is not displayed correctly.");
			}

			// VALIDATE FOR PROPERTY ONE
			title("VALIDATE FOR PROPERTY ONE");

			// wait for the element
			explicitWaitClickable("navigation_header_searchicon_XPATH");

			// click on the search icon from the header
			click("navigation_header_searchicon_XPATH");

			// enter property 2 number in text field
			type("navigation_header_searchtxt_XPATH", "01");

			// hit enter key
			driver.findElement(By.xpath(OR.getProperty("navigation_header_searchtxt_XPATH"))).sendKeys(Keys.ENTER);
			consoleMessage("Hit enter key.");

			// validate the property name
			switchVerification("navigation_header_propertyname1_XPATH", "[DND] AAAA Risk Test Prop 01 - 01",
					"The property name is not displayed.");

			try {
				// scroll down till task card
				scrollTillElement("task_navigation_tasklbl_XPATH");

				// validate the task count
				String taskCount = (driver.findElement(By.xpath(OR.getProperty("propertydashboard_taskcount_XPATH")))
						.getText()).trim();

				if (taskCount.equals("1")) {
					successMessage("The task count is displayed correctly.");
				} else {
					verificationFailedMessage("The task count is not displayed correctly.");
				}
			} catch (Throwable t) {
				verificationFailedMessage("The task count is not displayed correctly.");
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

		// VALIDATE THE NAVIGATION AFTER SWITCHING THE PROPERTY FROM THE HEADER OF
		// THE BUILDING LIST SCREEN
		title("VALIDATE THE NAVIGATION AFTER SWITCHING THE PROPERTY FROM THE HEADER OF THE BUILDING LIST SCREEN");

		try {

			// select the option from the dashboard dropdown
			select("dashboard_CSS", "Building List");

			// VALIDATE FOR PROPERTY ONE
			title("VALIDATE FOR PROPERTY ONE");

			// validate the Building List title
			switchVerification("buildinglist_title_XPATH", "Building List",
					"The Building List title is not displayed.");

			// VALIDATE FOR PROPERTY TWO
			title("VALIDATE FOR PROPERTY TWO");

			// wait for the element
			explicitWaitClickable("navigation_header_searchicon_XPATH");

			// click on the search icon from the header
			click("navigation_header_searchicon_XPATH");

			// enter property 2 number in text field
			type("navigation_header_searchtxt_XPATH", "02");

			// hit enter key
			driver.findElement(By.xpath(OR.getProperty("navigation_header_searchtxt_XPATH"))).sendKeys(Keys.ENTER);
			consoleMessage("Hit enter key.");

			// wait for the element
			Thread.sleep(2000);

			// click on the settings icon from the top of the screen
			click("questionnaire_settingicon_CSS");

			// wait for the element
			Thread.sleep(1000);

			// click on the cancel icon
			click("questionnaire_setting_cancelicon_XPATH");

			// validate the property name
			switchVerification("navigation_header_propertyname2_XPATH", "[DND] AAAA Risk Test Prop 02 - 02",
					"The property name is not displayed.");

			try {
				// scroll down till task card
				scrollTillElement("task_navigation_tasklbl_XPATH");

				// validate the task count
				String taskCount = (driver.findElement(By.xpath(OR.getProperty("propertydashboard_taskcount_XPATH")))
						.getText()).trim();

				if (taskCount.equals("0")) {
					successMessage("The task count is displayed correctly.");
				} else {
					verificationFailedMessage("The task count is not displayed correctly.");
				}
			} catch (Throwable t) {
				verificationFailedMessage("The task count is not displayed correctly.");
			}

			// VALIDATE FOR PROPERTY THREE
			title("VALIDATE FOR PROPERTY THREE");

			// wait for the element
			explicitWaitClickable("navigation_header_searchicon_XPATH");

			// click on the search icon from the header
			click("navigation_header_searchicon_XPATH");

			// enter property 2 number in text field
			type("navigation_header_searchtxt_XPATH", "03");

			// hit enter key
			driver.findElement(By.xpath(OR.getProperty("navigation_header_searchtxt_XPATH"))).sendKeys(Keys.ENTER);
			consoleMessage("Hit enter key.");

			// wait for the element
			Thread.sleep(2000);

			// click on the settings icon from the top of the screen
			click("questionnaire_settingicon_CSS");

			// wait for the element
			Thread.sleep(1000);

			// click on the cancel icon
			click("questionnaire_setting_cancelicon_XPATH");

			// validate the property name
			switchVerification("navigation_header_propertyname3_XPATH", "[DND] AAAA Risk Test Prop 03 - 03",
					"The property name is not displayed.");

			try {
				// scroll down till task card
				scrollTillElement("task_navigation_tasklbl_XPATH");

				// validate the task count
				String taskCount = (driver.findElement(By.xpath(OR.getProperty("propertydashboard_taskcount_XPATH")))
						.getText()).trim();

				if (taskCount.equals("0")) {
					successMessage("The task count is displayed correctly.");
				} else {
					verificationFailedMessage("The task count is not displayed correctly.");
				}
			} catch (Throwable t) {
				verificationFailedMessage("The task count is not displayed correctly.");
			}

			// VALIDATE FOR PROPERTY ONE
			title("VALIDATE FOR PROPERTY ONE");

			// wait for the element
			explicitWaitClickable("navigation_header_searchicon_XPATH");

			// click on the search icon from the header
			click("navigation_header_searchicon_XPATH");

			// enter property 2 number in text field
			type("navigation_header_searchtxt_XPATH", "01");

			// hit enter key
			driver.findElement(By.xpath(OR.getProperty("navigation_header_searchtxt_XPATH"))).sendKeys(Keys.ENTER);
			consoleMessage("Hit enter key.");

			// validate the property name
			switchVerification("navigation_header_propertyname1_XPATH", "[DND] AAAA Risk Test Prop 01 - 01",
					"The property name is not displayed.");

			try {
				// scroll down till task card
				scrollTillElement("task_navigation_tasklbl_XPATH");

				// validate the task count
				String taskCount = (driver.findElement(By.xpath(OR.getProperty("propertydashboard_taskcount_XPATH")))
						.getText()).trim();

				if (taskCount.equals("1")) {
					successMessage("The task count is displayed correctly.");
				} else {
					verificationFailedMessage("The task count is not displayed correctly.");
				}
			} catch (Throwable t) {
				verificationFailedMessage("The task count is not displayed correctly.");
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

		// VALIDATE THE NAVIGATION AFTER SWITCHING THE PROPERTY FROM THE HEADER OF
		// THE HIGH RISK PROPERTIES SCREEN
		title("VALIDATE THE NAVIGATION AFTER SWITCHING THE PROPERTY FROM THE HEADER OF THE HIGH RISK PROPERTIES SCREEN");

		try {

			// select the option from the dashboard dropdown
			select("dashboard_CSS", "High Risk Properties");

			// VALIDATE FOR PROPERTY ONE
			title("VALIDATE FOR PROPERTY ONE");

			// validate the High Risk Properties title
			switchVerification("highriskpropertieslist_title_XPATH", "High Risk Properties",
					"The High Risk Properties title is not displayed.");

			// VALIDATE FOR PROPERTY TWO
			title("VALIDATE FOR PROPERTY TWO");

			// wait for the element
			explicitWaitClickable("navigation_header_searchicon_XPATH");

			// click on the search icon from the header
			click("navigation_header_searchicon_XPATH");

			// enter property 2 number in text field
			type("navigation_header_searchtxt_XPATH", "02");

			// hit enter key
			driver.findElement(By.xpath(OR.getProperty("navigation_header_searchtxt_XPATH"))).sendKeys(Keys.ENTER);
			consoleMessage("Hit enter key.");

			// wait for the element// wait for the element
			Thread.sleep(2000);

			// click on the settings icon from the top of the screen
			click("questionnaire_settingicon_CSS");

			// wait for the element
			Thread.sleep(1000);

			// click on the cancel icon
			click("questionnaire_setting_cancelicon_XPATH");

			Thread.sleep(5000);

			// validate the property name
			switchVerification("navigation_header_propertyname2_XPATH", "[DND] AAAA Risk Test Prop 02 - 02",
					"The property name is not displayed.");

			try {
				// scroll down till task card
				scrollTillElement("task_navigation_tasklbl_XPATH");

				// validate the task count
				String taskCount = (driver.findElement(By.xpath(OR.getProperty("propertydashboard_taskcount_XPATH")))
						.getText()).trim();

				if (taskCount.equals("0")) {
					successMessage("The task count is displayed correctly.");
				} else {
					verificationFailedMessage("The task count is not displayed correctly.");
				}
			} catch (Throwable t) {
				verificationFailedMessage("The task count is not displayed correctly.");
			}

			// VALIDATE FOR PROPERTY THREE
			title("VALIDATE FOR PROPERTY THREE");

			// wait for the element
			explicitWaitClickable("navigation_header_searchicon_XPATH");

			// click on the search icon from the header
			click("navigation_header_searchicon_XPATH");

			// enter property 2 number in text field
			type("navigation_header_searchtxt_XPATH", "03");

			// hit enter key
			driver.findElement(By.xpath(OR.getProperty("navigation_header_searchtxt_XPATH"))).sendKeys(Keys.ENTER);
			consoleMessage("Hit enter key.");

			// wait for the element
			Thread.sleep(2000);

			// click on the settings icon from the top of the screen
			click("questionnaire_settingicon_CSS");

			// wait for the element
			Thread.sleep(1000);

			// click on the cancel icon
			click("questionnaire_setting_cancelicon_XPATH");

			// validate the property name
			switchVerification("navigation_header_propertyname3_XPATH", "[DND] AAAA Risk Test Prop 03 - 03",
					"The property name is not displayed.");

			try {
				// scroll down till task card
				scrollTillElement("task_navigation_tasklbl_XPATH");

				// validate the task count
				String taskCount = (driver.findElement(By.xpath(OR.getProperty("propertydashboard_taskcount_XPATH")))
						.getText()).trim();

				if (taskCount.equals("0")) {
					successMessage("The task count is displayed correctly.");
				} else {
					verificationFailedMessage("The task count is not displayed correctly.");
				}
			} catch (Throwable t) {
				verificationFailedMessage("The task count is not displayed correctly.");
			}

			// VALIDATE FOR PROPERTY ONE
			title("VALIDATE FOR PROPERTY ONE");

			// wait for the element
			explicitWaitClickable("navigation_header_searchicon_XPATH");

			// click on the search icon from the header
			click("navigation_header_searchicon_XPATH");

			// enter property 2 number in text field
			type("navigation_header_searchtxt_XPATH", "01");

			// hit enter key
			driver.findElement(By.xpath(OR.getProperty("navigation_header_searchtxt_XPATH"))).sendKeys(Keys.ENTER);
			consoleMessage("Hit enter key.");

			// validate the property name
			switchVerification("navigation_header_propertyname1_XPATH", "[DND] AAAA Risk Test Prop 01 - 01",
					"The property name is not displayed.");

			try {
				// scroll down till task card
				scrollTillElement("task_navigation_tasklbl_XPATH");

				// validate the task count
				String taskCount = (driver.findElement(By.xpath(OR.getProperty("propertydashboard_taskcount_XPATH")))
						.getText()).trim();

				if (taskCount.equals("1")) {
					successMessage("The task count is displayed correctly.");
				} else {
					verificationFailedMessage("The task count is not displayed correctly.");
				}
			} catch (Throwable t) {
				verificationFailedMessage("The task count is not displayed correctly.");
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

		// VALIDATE THE NAVIGATION AFTER SWITCHING THE PROPERTY FROM THE HEADER OF
		// THE OVERDUE TASKS SCREEN
		title("VALIDATE THE NAVIGATION AFTER SWITCHING THE PROPERTY FROM THE HEADER OF THE OVERDUE TASKS SCREEN");

		try {

			// select the option from the dashboard dropdown
			select("dashboard_CSS", "OverDue Tasks");

			// VALIDATE FOR PROPERTY ONE
			title("VALIDATE FOR PROPERTY ONE");

			// validate the property list title
			switchVerification("overduetaskslist_title_XPATH", "Overdue Tasks",
					"The Overdue Tasks title is not displayed.");

			// VALIDATE FOR PROPERTY TWO
			title("VALIDATE FOR PROPERTY TWO");

			// wait for the element
			explicitWaitClickable("navigation_header_searchicon_XPATH");

			// click on the search icon from the header
			click("navigation_header_searchicon_XPATH");

			// enter property 2 number in text field
			type("navigation_header_searchtxt_XPATH", "02");

			// hit enter key
			driver.findElement(By.xpath(OR.getProperty("navigation_header_searchtxt_XPATH"))).sendKeys(Keys.ENTER);
			consoleMessage("Hit enter key.");

			// wait for the element
			Thread.sleep(2000);

			// click on the settings icon from the top of the screen
			click("questionnaire_settingicon_CSS");

			// wait for the element
			Thread.sleep(1000);

			// click on the cancel icon
			click("questionnaire_setting_cancelicon_XPATH");

			// validate the property name
			switchVerification("navigation_header_propertyname2_XPATH", "[DND] AAAA Risk Test Prop 02 - 02",
					"The property name is not displayed.");

			try {
				// scroll down till task card
				scrollTillElement("task_navigation_tasklbl_XPATH");

				// validate the task count
				String taskCount = (driver.findElement(By.xpath(OR.getProperty("propertydashboard_taskcount_XPATH")))
						.getText()).trim();

				if (taskCount.equals("0")) {
					successMessage("The task count is displayed correctly.");
				} else {
					verificationFailedMessage("The task count is not displayed correctly.");
				}
			} catch (Throwable t) {
				verificationFailedMessage("The task count is not displayed correctly.");
			}

			// VALIDATE FOR PROPERTY THREE
			title("VALIDATE FOR PROPERTY THREE");

			// wait for the element
			explicitWaitClickable("navigation_header_searchicon_XPATH");

			// click on the search icon from the header
			click("navigation_header_searchicon_XPATH");

			// enter property 2 number in text field
			type("navigation_header_searchtxt_XPATH", "03");

			// hit enter key
			driver.findElement(By.xpath(OR.getProperty("navigation_header_searchtxt_XPATH"))).sendKeys(Keys.ENTER);
			consoleMessage("Hit enter key.");

			// wait for the element
			Thread.sleep(2000);

			// click on the settings icon from the top of the screen
			click("questionnaire_settingicon_CSS");

			// wait for the element
			Thread.sleep(1000);

			// click on the cancel icon
			click("questionnaire_setting_cancelicon_XPATH");

			// validate the property name
			switchVerification("navigation_header_propertyname3_XPATH", "[DND] AAAA Risk Test Prop 03 - 03",
					"The property name is not displayed.");

			try {
				// scroll down till task card
				scrollTillElement("task_navigation_tasklbl_XPATH");

				// validate the task count
				String taskCount = (driver.findElement(By.xpath(OR.getProperty("propertydashboard_taskcount_XPATH")))
						.getText()).trim();

				if (taskCount.equals("0")) {
					successMessage("The task count is displayed correctly.");
				} else {
					verificationFailedMessage("The task count is not displayed correctly.");
				}
			} catch (Throwable t) {
				verificationFailedMessage("The task count is not displayed correctly.");
			}

			// VALIDATE FOR PROPERTY ONE
			title("VALIDATE FOR PROPERTY ONE");

			// wait for the element
			explicitWaitClickable("navigation_header_searchicon_XPATH");

			// click on the search icon from the header
			click("navigation_header_searchicon_XPATH");

			// enter property 2 number in text field
			type("navigation_header_searchtxt_XPATH", "01");

			// hit enter key
			driver.findElement(By.xpath(OR.getProperty("navigation_header_searchtxt_XPATH"))).sendKeys(Keys.ENTER);
			consoleMessage("Hit enter key.");

			// validate the property name
			switchVerification("navigation_header_propertyname1_XPATH", "[DND] AAAA Risk Test Prop 01 - 01",
					"The property name is not displayed.");

			try {
				// scroll down till task card
				scrollTillElement("task_navigation_tasklbl_XPATH");

				// validate the task count
				String taskCount = (driver.findElement(By.xpath(OR.getProperty("propertydashboard_taskcount_XPATH")))
						.getText()).trim();

				if (taskCount.equals("1")) {
					successMessage("The task count is displayed correctly.");
				} else {
					verificationFailedMessage("The task count is not displayed correctly.");
				}
			} catch (Throwable t) {
				verificationFailedMessage("The task count is not displayed correctly.");
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

		// VALIDATE THE NAVIGATION AFTER SWITCHING THE PROPERTY FROM THE HEADER OF
		// THE MY TASKS SCREEN
		title("VALIDATE THE NAVIGATION AFTER SWITCHING THE PROPERTY FROM THE HEADER OF THE MY TASKS SCREEN");

		try {

			// select the option from the dashboard dropdown
			select("dashboard_CSS", "My Tasks");

			// VALIDATE FOR PROPERTY ONE
			title("VALIDATE FOR PROPERTY ONE");

			// validate the my tasks title
			switchVerification("mytaskslist_title_XPATH", "My Tasks", "The My Tasks title is not displayed.");

			// VALIDATE FOR PROPERTY TWO
			title("VALIDATE FOR PROPERTY TWO");

			// wait for the element
			explicitWaitClickable("navigation_header_searchicon_XPATH");

			// click on the search icon from the header
			click("navigation_header_searchicon_XPATH");

			// enter property 2 number in text field
			type("navigation_header_searchtxt_XPATH", "02");

			// hit enter key
			driver.findElement(By.xpath(OR.getProperty("navigation_header_searchtxt_XPATH"))).sendKeys(Keys.ENTER);
			consoleMessage("Hit enter key.");

			// wait for the element
			Thread.sleep(2000);

			// click on the settings icon from the top of the screen
			click("questionnaire_settingicon_CSS");

			// wait for the element
			Thread.sleep(1000);

			// click on the cancel icon
			click("questionnaire_setting_cancelicon_XPATH");

			// validate the property name
			switchVerification("navigation_header_propertyname2_XPATH", "[DND] AAAA Risk Test Prop 02 - 02",
					"The property name is not displayed.");

			try {
				// scroll down till task card
				scrollTillElement("task_navigation_tasklbl_XPATH");

				// validate the task count
				String taskCount = (driver.findElement(By.xpath(OR.getProperty("propertydashboard_taskcount_XPATH")))
						.getText()).trim();

				if (taskCount.equals("0")) {
					successMessage("The task count is displayed correctly.");
				} else {
					verificationFailedMessage("The task count is not displayed correctly.");
				}
			} catch (Throwable t) {
				verificationFailedMessage("The task count is not displayed correctly.");
			}

			// VALIDATE FOR PROPERTY THREE
			title("VALIDATE FOR PROPERTY THREE");

			// wait for the element
			explicitWaitClickable("navigation_header_searchicon_XPATH");

			// click on the search icon from the header
			click("navigation_header_searchicon_XPATH");

			// enter property 2 number in text field
			type("navigation_header_searchtxt_XPATH", "03");

			// hit enter key
			driver.findElement(By.xpath(OR.getProperty("navigation_header_searchtxt_XPATH"))).sendKeys(Keys.ENTER);
			consoleMessage("Hit enter key.");

			// wait for the element
			Thread.sleep(2000);

			// click on the settings icon from the top of the screen
			click("questionnaire_settingicon_CSS");

			// wait for the element
			Thread.sleep(1000);

			// click on the cancel icon
			click("questionnaire_setting_cancelicon_XPATH");

			// validate the property name
			switchVerification("navigation_header_propertyname3_XPATH", "[DND] AAAA Risk Test Prop 03 - 03",
					"The property name is not displayed.");

			try {
				// scroll down till task card
				scrollTillElement("task_navigation_tasklbl_XPATH");

				// validate the task count
				String taskCount = (driver.findElement(By.xpath(OR.getProperty("propertydashboard_taskcount_XPATH")))
						.getText()).trim();

				if (taskCount.equals("0")) {
					successMessage("The task count is displayed correctly.");
				} else {
					verificationFailedMessage("The task count is not displayed correctly.");
				}
			} catch (Throwable t) {
				verificationFailedMessage("The task count is not displayed correctly.");
			}

			// VALIDATE FOR PROPERTY ONE
			title("VALIDATE FOR PROPERTY ONE");

			// wait for the element
			explicitWaitClickable("navigation_header_searchicon_XPATH");

			// click on the search icon from the header
			click("navigation_header_searchicon_XPATH");

			// enter property 2 number in text field
			type("navigation_header_searchtxt_XPATH", "01");

			// hit enter key
			driver.findElement(By.xpath(OR.getProperty("navigation_header_searchtxt_XPATH"))).sendKeys(Keys.ENTER);
			consoleMessage("Hit enter key.");

			// validate the property name
			switchVerification("navigation_header_propertyname1_XPATH", "[DND] AAAA Risk Test Prop 01 - 01",
					"The property name is not displayed.");

			try {
				// scroll down till task card
				scrollTillElement("task_navigation_tasklbl_XPATH");

				// validate the task count
				String taskCount = (driver.findElement(By.xpath(OR.getProperty("propertydashboard_taskcount_XPATH")))
						.getText()).trim();

				if (taskCount.equals("1")) {
					successMessage("The task count is displayed correctly.");
				} else {
					verificationFailedMessage("The task count is not displayed correctly.");
				}
			} catch (Throwable t) {
				verificationFailedMessage("The task count is not displayed correctly.");
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

		// VALIDATE THE NAVIGATION AFTER SWITCHING THE PROPERTY FROM THE HEADER OF
		// THE TASK OF THE MY TASKS SCREEN
		title("VALIDATE THE NAVIGATION AFTER SWITCHING THE PROPERTY FROM THE HEADER OF THE TASK OF THE MY TASKS SCREEN");

		try {

			// select the option from the dashboard dropdown
			select("dashboard_CSS", "My Tasks");

			// click on the clear button
			click("mytaskdashboard_createdtask_clearbtn_XPATH");

			// enter the newly created task title in the search field
			type("mytaskslist_searchtxt_XPATH", taskTitle);

			// click on the search button
			click("mytaskdashboard_createdtask_searchbtn_XPATH");

			// click on the newly created task
			String task = "//p[text()='" + taskTitle + "']";
			driver.findElement(By.xpath(task)).click();
			consoleMessage("Clicked on the newly created task.");

			// VALIDATE FOR PROPERTY ONE
			title("VALIDATE FOR PROPERTY ONE");

			// validate the task title
			try {
				String taskTitle1 = driver.findElement(By.cssSelector(OR.getProperty("task_addtask_titletxt_CSS")))
						.getAttribute("value");

				if (taskTitle1.equals(taskTitle)) {
					successMessage("The task title is displayed correctly.");
				} else {
					verificationFailedMessage("The task title is not displayed correctly.");
				}
			} catch (Throwable t) {
				verificationFailedMessage("The task title is not displayed correctly.");
			}

			// VALIDATE FOR PROPERTY TWO
			title("VALIDATE FOR PROPERTY TWO");

			// wait for the element
			explicitWaitClickable("navigation_header_searchicon_XPATH");

			// click on the search icon from the header
			click("navigation_header_searchicon_XPATH");

			// enter property 2 number in text field
			type("navigation_header_searchtxt_XPATH", "02");

			// hit enter key
			driver.findElement(By.xpath(OR.getProperty("navigation_header_searchtxt_XPATH"))).sendKeys(Keys.ENTER);
			consoleMessage("Hit enter key.");

			// wait for the element
			Thread.sleep(2000);

			// click on the settings icon from the top of the screen
			click("questionnaire_settingicon_CSS");

			// wait for the element
			Thread.sleep(1000);

			// click on the cancel icon
			click("questionnaire_setting_cancelicon_XPATH");

			// validate the property name
			switchVerification("navigation_header_propertyname2_XPATH", "[DND] AAAA Risk Test Prop 02 - 02",
					"The property name is not displayed.");

			try {
				// scroll down till task card
				scrollTillElement("task_navigation_tasklbl_XPATH");

				// validate the task count
				String taskCount = (driver.findElement(By.xpath(OR.getProperty("propertydashboard_taskcount_XPATH")))
						.getText()).trim();

				if (taskCount.equals("0")) {
					successMessage("The task count is displayed correctly.");
				} else {
					verificationFailedMessage("The task count is not displayed correctly.");
				}
			} catch (Throwable t) {
				verificationFailedMessage("The task count is not displayed correctly.");
			}

			// VALIDATE FOR PROPERTY THREE
			title("VALIDATE FOR PROPERTY THREE");

			// wait for the element
			explicitWaitClickable("navigation_header_searchicon_XPATH");

			// click on the search icon from the header
			click("navigation_header_searchicon_XPATH");

			// enter property 2 number in text field
			type("navigation_header_searchtxt_XPATH", "03");

			// hit enter key
			driver.findElement(By.xpath(OR.getProperty("navigation_header_searchtxt_XPATH"))).sendKeys(Keys.ENTER);
			consoleMessage("Hit enter key.");

			// wait for the element
			Thread.sleep(2000);

			// click on the settings icon from the top of the screen
			click("questionnaire_settingicon_CSS");

			// wait for the element
			Thread.sleep(1000);

			// click on the cancel icon
			click("questionnaire_setting_cancelicon_XPATH");

			// validate the property name
			switchVerification("navigation_header_propertyname3_XPATH", "[DND] AAAA Risk Test Prop 03 - 03",
					"The property name is not displayed.");

			try {
				// scroll down till task card
				scrollTillElement("task_navigation_tasklbl_XPATH");

				// validate the task count
				String taskCount = (driver.findElement(By.xpath(OR.getProperty("propertydashboard_taskcount_XPATH")))
						.getText()).trim();

				if (taskCount.equals("0")) {
					successMessage("The task count is displayed correctly.");
				} else {
					verificationFailedMessage("The task count is not displayed correctly.");
				}
			} catch (Throwable t) {
				verificationFailedMessage("The task count is not displayed correctly.");
			}

			// VALIDATE FOR PROPERTY ONE
			title("VALIDATE FOR PROPERTY ONE");

			// wait for the element
			explicitWaitClickable("navigation_header_searchicon_XPATH");

			// click on the search icon from the header
			click("navigation_header_searchicon_XPATH");

			// enter property 2 number in text field
			type("navigation_header_searchtxt_XPATH", "01");

			// hit enter key
			driver.findElement(By.xpath(OR.getProperty("navigation_header_searchtxt_XPATH"))).sendKeys(Keys.ENTER);
			consoleMessage("Hit enter key.");

			// validate the property name
			switchVerification("navigation_header_propertyname1_XPATH", "[DND] AAAA Risk Test Prop 01 - 01",
					"The property name is not displayed.");

			try {
				// scroll down till task card
				scrollTillElement("task_navigation_tasklbl_XPATH");

				// validate the task count
				String taskCount = (driver.findElement(By.xpath(OR.getProperty("propertydashboard_taskcount_XPATH")))
						.getText()).trim();

				if (taskCount.equals("1")) {
					successMessage("The task count is displayed correctly.");
				} else {
					verificationFailedMessage("The task count is not displayed correctly.");
				}
			} catch (Throwable t) {
				verificationFailedMessage("The task count is not displayed correctly.");
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

		// VALIDATE THE NAVIGATION AFTER SWITCHING THE PROPERTY FROM THE HEADER OF
		// THE PORTFOLIO SUMMARY SCREEN
		title("VALIDATE THE NAVIGATION AFTER SWITCHING THE PROPERTY FROM THE HEADER OF THE PORTFOLIO SUMMARY SCREEN");

		try {

			// select the option from the dashboard dropdown
			select("dashboard_CSS", "Portfolio Summary");

			// VALIDATE FOR PROPERTY ONE
			title("VALIDATE FOR PROPERTY ONE");

			// validate the portfolio summary title
			switchVerification("portfoliosummarylist_title_XPATH", "Portfolio Summary",
					"The Portfolio Summary title is not displayed.");

			// VALIDATE FOR PROPERTY TWO
			title("VALIDATE FOR PROPERTY TWO");

			// wait for the element
			explicitWaitClickable("navigation_header_searchicon_XPATH");

			// click on the search icon from the header
			click("navigation_header_searchicon_XPATH");

			// enter property 2 number in text field
			type("navigation_header_searchtxt_XPATH", "02");

			// hit enter key
			driver.findElement(By.xpath(OR.getProperty("navigation_header_searchtxt_XPATH"))).sendKeys(Keys.ENTER);
			consoleMessage("Hit enter key.");

			// wait for the element
			Thread.sleep(2000);

			// click on the settings icon from the top of the screen
			click("questionnaire_settingicon_CSS");

			// wait for the element
			Thread.sleep(1000);

			// click on the cancel icon
			click("questionnaire_setting_cancelicon_XPATH");

			// validate the property name
			switchVerification("navigation_header_propertyname2_XPATH", "[DND] AAAA Risk Test Prop 02 - 02",
					"The property name is not displayed.");

			try {
				// scroll down till task card
				scrollTillElement("task_navigation_tasklbl_XPATH");

				// validate the task count
				String taskCount = (driver.findElement(By.xpath(OR.getProperty("propertydashboard_taskcount_XPATH")))
						.getText()).trim();

				if (taskCount.equals("0")) {
					successMessage("The task count is displayed correctly.");
				} else {
					verificationFailedMessage("The task count is not displayed correctly.");
				}
			} catch (Throwable t) {
				verificationFailedMessage("The task count is not displayed correctly.");
			}

			// VALIDATE FOR PROPERTY THREE
			title("VALIDATE FOR PROPERTY THREE");

			// wait for the element
			explicitWaitClickable("navigation_header_searchicon_XPATH");

			// click on the search icon from the header
			click("navigation_header_searchicon_XPATH");

			// enter property 2 number in text field
			type("navigation_header_searchtxt_XPATH", "03");

			// hit enter key
			driver.findElement(By.xpath(OR.getProperty("navigation_header_searchtxt_XPATH"))).sendKeys(Keys.ENTER);
			consoleMessage("Hit enter key.");

			// wait for the element
			Thread.sleep(2000);

			// click on the settings icon from the top of the screen
			click("questionnaire_settingicon_CSS");

			// wait for the element
			Thread.sleep(1000);

			// click on the cancel icon
			click("questionnaire_setting_cancelicon_XPATH");

			// validate the property name
			switchVerification("navigation_header_propertyname3_XPATH", "[DND] AAAA Risk Test Prop 03 - 03",
					"The property name is not displayed.");

			try {
				// scroll down till task card
				scrollTillElement("task_navigation_tasklbl_XPATH");

				// validate the task count
				String taskCount = (driver.findElement(By.xpath(OR.getProperty("propertydashboard_taskcount_XPATH")))
						.getText()).trim();

				if (taskCount.equals("0")) {
					successMessage("The task count is displayed correctly.");
				} else {
					verificationFailedMessage("The task count is not displayed correctly.");
				}
			} catch (Throwable t) {
				verificationFailedMessage("The task count is not displayed correctly.");
			}

			// VALIDATE FOR PROPERTY ONE
			title("VALIDATE FOR PROPERTY ONE");

			// wait for the element
			explicitWaitClickable("navigation_header_searchicon_XPATH");

			// click on the search icon from the header
			click("navigation_header_searchicon_XPATH");

			// enter property 2 number in text field
			type("navigation_header_searchtxt_XPATH", "01");

			// hit enter key
			driver.findElement(By.xpath(OR.getProperty("navigation_header_searchtxt_XPATH"))).sendKeys(Keys.ENTER);
			consoleMessage("Hit enter key.");

			// validate the property name
			switchVerification("navigation_header_propertyname1_XPATH", "[DND] AAAA Risk Test Prop 01 - 01",
					"The property name is not displayed.");

			try {
				// scroll down till task card
				scrollTillElement("task_navigation_tasklbl_XPATH");

				// validate the task count
				String taskCount = (driver.findElement(By.xpath(OR.getProperty("propertydashboard_taskcount_XPATH")))
						.getText()).trim();

				if (taskCount.equals("1")) {
					successMessage("The task count is displayed correctly.");
				} else {
					verificationFailedMessage("The task count is not displayed correctly.");
				}
			} catch (Throwable t) {
				verificationFailedMessage("The task count is not displayed correctly.");
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

		// VALIDATE THE NAVIGATION AFTER SWITCHING THE PROPERTY FROM THE HEADER OF
		// THE STATEMENT OF VALUES SCREEN
		title("VALIDATE THE NAVIGATION AFTER SWITCHING THE PROPERTY FROM THE HEADER OF THE STATEMENT OF VALUES SCREEN");

		try {

			// select the option from the dashboard dropdown
			select("dashboard_CSS", "Statement of Values");

			// VALIDATE FOR PROPERTY ONE
			title("VALIDATE FOR PROPERTY ONE");

			// validate the Statement of Values title
			switchVerification("statementofvalueslist_title_XPATH", "Statement of Values",
					"The Statement of Values title is not displayed.");

			// VALIDATE FOR PROPERTY TWO
			title("VALIDATE FOR PROPERTY TWO");

			// wait for the element
			explicitWaitClickable("navigation_header_searchicon_XPATH");

			// click on the search icon from the header
			click("navigation_header_searchicon_XPATH");

			// enter property 2 number in text field
			type("navigation_header_searchtxt_XPATH", "02");

			// hit enter key
			driver.findElement(By.xpath(OR.getProperty("navigation_header_searchtxt_XPATH"))).sendKeys(Keys.ENTER);
			consoleMessage("Hit enter key.");

			// wait for the element
			Thread.sleep(2000);

			// click on the settings icon from the top of the screen
			click("questionnaire_settingicon_CSS");

			// wait for the element
			Thread.sleep(1000);

			// click on the cancel icon
			click("questionnaire_setting_cancelicon_XPATH");

			// validate the property name
			switchVerification("navigation_header_propertyname2_XPATH", "[DND] AAAA Risk Test Prop 02 - 02",
					"The property name is not displayed.");

			// validate the Statement of Values title
			switchVerification("statementofvalueslist_title_XPATH", "Statement of Values",
					"The Statement of Values title is not displayed.");

			// VALIDATE FOR PROPERTY THREE
			title("VALIDATE FOR PROPERTY THREE");

			// wait for the element
			explicitWaitClickable("navigation_header_searchicon_XPATH");

			// click on the search icon from the header
			click("navigation_header_searchicon_XPATH");

			// enter property 2 number in text field
			type("navigation_header_searchtxt_XPATH", "03");

			// hit enter key
			driver.findElement(By.xpath(OR.getProperty("navigation_header_searchtxt_XPATH"))).sendKeys(Keys.ENTER);
			consoleMessage("Hit enter key.");

			// wait for the element
			Thread.sleep(2000);

			// click on the settings icon from the top of the screen
			click("questionnaire_settingicon_CSS");

			// wait for the element
			Thread.sleep(1000);

			// click on the cancel icon
			click("questionnaire_setting_cancelicon_XPATH");

			// validate the property name
			switchVerification("navigation_header_propertyname3_XPATH", "[DND] AAAA Risk Test Prop 03 - 03",
					"The property name is not displayed.");

			// validate the Statement of Values title
			switchVerification("statementofvalueslist_title_XPATH", "Statement of Values",
					"The Statement of Values title is not displayed.");

			// VALIDATE FOR PROPERTY ONE
			title("VALIDATE FOR PROPERTY ONE");

			// wait for the element
			explicitWaitClickable("navigation_header_searchicon_XPATH");

			// click on the search icon from the header
			click("navigation_header_searchicon_XPATH");

			// enter property 2 number in text field
			type("navigation_header_searchtxt_XPATH", "01");

			// hit enter key
			driver.findElement(By.xpath(OR.getProperty("navigation_header_searchtxt_XPATH"))).sendKeys(Keys.ENTER);
			consoleMessage("Hit enter key.");

			// validate the property name
			switchVerification("navigation_header_propertyname1_XPATH", "[DND] AAAA Risk Test Prop 01 - 01",
					"The property name is not displayed.");

			// validate the Statement of Values title
			switchVerification("statementofvalueslist_title_XPATH", "Statement of Values",
					"The Statement of Values title is not displayed.");

		} catch (Throwable t) {
			verificationFailed();
		}

		// click on the home icon from the top of the screen
		click("questionnaire_homeburgermenubtn_hide_CSS");

		// wait for the element
		explicitWait("propertylist_title_XPATH");

		// verify the property list
		switchVerification("propertylist_title_XPATH", "Property List", "The property list is not displayed.");

		// DELETE ALL THE NEWLY CREATED TASKS
		title("DELETE ALL THE NEWLY CREATED TASKS");

		try {
			// click on the task icon
			click("taskicon_CSS");

			// delete all the previously created tasks
			try {
				String pages = (driver.findElement(By.xpath(
						"//i[@ng-click='previousPageData(taskSelectedFilterType)']//following-sibling::strong[@class='ng-binding']"))
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
						click("task_firstactionicon_XPATH");
						ngDriver.waitForAngularRequestsToFinish();
						System.out.println("Clicked on the action icon of the first record.");

						// wait for the element
						Thread.sleep(3000);

						// click on the delete option
						click("task_firstactionicon_deleteoption_XPATH");

						// wait for the element
						explicitWaitClickable("closetoastmsg_CSS");

						// click on the toaster close button
						click("closetoastmsg_CSS");

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

		// synchronization
		explicitWait("propertylist_title_XPATH");

		// verify the property list
		switchVerification("propertylist_title_XPATH", "Property List", "The property list is not displayed.");

	}

}
