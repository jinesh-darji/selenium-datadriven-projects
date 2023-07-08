package testcases.E2Etestcasesuite.taskmodule;

import java.io.IOException;
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

public class RR4297TaskTest extends TestBase {

	@Test(dataProviderClass = TestUtil.class, dataProvider = "dp")
	public void rR4297TaskTest(Hashtable<String, String> data) throws IOException, InterruptedException {

		execution(data, "rR4297TaskTest");

		// ANY USER WHO HAS ACCESS TO THE PROPERTY SHOULD BE ABLE TO SEE ALL THE TASKS
		// FOR THE PROPERTY, IN THE BROWSER

		System.out.println(
				"ANY USER WHO HAS ACCESS TO THE PROPERTY SHOULD BE ABLE TO SEE ALL THE TASKS FOR THE PROPERTY, IN THE BROWSER.");
		test.log(LogStatus.INFO,
				"ANY USER WHO HAS ACCESS TO THE PROPERTY SHOULD BE ABLE TO SEE ALL THE TASKS FOR THE PROPERTY, IN THE BROWSER.");
		Reporter.log(
				"ANY USER WHO HAS ACCESS TO THE PROPERTY SHOULD BE ABLE TO SEE ALL THE TASKS FOR THE PROPERTY, IN THE BROWSER.");
		log.info(
				"ANY USER WHO HAS ACCESS TO THE PROPERTY SHOULD BE ABLE TO SEE ALL THE TASKS FOR THE PROPERTY, IN THE BROWSER.");

		Helper helper = new Helper();

		// refresh the page
		driver.navigate().refresh();
		Thread.sleep(5000);
		driver.navigate().refresh();

		System.out.println("Navigate to the Home Screen i.e. Property List Screen.");

		// ADD THE TASK

		System.out.println("***************** ADD THE TASK *****************");
		test.log(LogStatus.INFO, "***************** ADD THE TASK *****************");
		Reporter.log("***************** ADD THE TASK *****************");
		log.info("***************** ADD THE TASK *****************");

		try {
			// enter the property name in the search field
			clear("envreports_propertylist_filtertxt_CSS");
			type("envreports_propertylist_filtertxt_CSS", data.get("property_1"));
			System.out.println("Entered the property name in the search field.");
			ngDriver.waitForAngularRequestsToFinish();

			// click on the task icon
			click("taskicon_CSS");
			System.out.println("Clicked on the task icon.");
			ngDriver.waitForAngularRequestsToFinish();

			// click on the add task button
			click("task_addtaskbtn_CSS");
			System.out.println("Clicked on the add task button.");
			ngDriver.waitForAngularRequestsToFinish();

			// enter the data in the task title field
			type("task_addtask_titletxt_CSS", data.get("task_title"));
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
			click("workflowsecurity_sendnotification_nonebtn_CSS");
			System.out.println("Clicked on the none button.");
			ngDriver.waitForAngularRequestsToFinish();

			// enter the contractor role in the search field
			type("workflowsecurity_editortask_taskdetails_searchtasktagtxt_CSS", data.get("role"));
			System.out.println("Entered the contractor role in the search field.");
			ngDriver.waitForAngularRequestsToFinish();

			// click on the role from the list
			click("task_selectrolelist_XPATH");
			System.out.println("Clicked on the role from the list.");
			ngDriver.waitForAngularRequestsToFinish();

			// click on the assign to field
			click("task_assigntotxt_CSS");
			System.out.println("Clicked on the assign to field.");
			ngDriver.waitForAngularRequestsToFinish();

			// scroll down the screen
			JavascriptExecutor js = (JavascriptExecutor) driver;
			js.executeScript("window.scrollBy(0,1200)");

			// wait for 3 seconds
			Thread.sleep(3000);

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
			type("task_filter_CSS", data.get("task_title"));
			System.out.println("Entered the data in the search field.");
			ngDriver.waitForAngularRequestsToFinish();

			// click on the search button
			click("task_createdtask_searchbtn_XPATH");
			ngDriver.waitForAngularRequestsToFinish();
			System.out.println("Clicked on the search button.");

			// verify newly created task is displayed or not
			switchVerification("task_createdtask_roleuser2_XPATH", "Test Role User Task 2 Title",
					"The Test Role User Task 2 Title is not displayed.");

		} catch (Throwable t) {
			verificationFailed();
		}

		// LOGOUT FROM ADMIN USER AND LOGIN WITH CONTRACTOR AND VERIFY TASK IS DISPLAYED
		// OR NOT

		System.out.println(
				"***************** LOGOUT FROM ADMIN USER AND LOGIN WITH CONTRACTOR AND VERIFY TASK IS DISPLAYED OR NOT *****************");
		test.log(LogStatus.INFO,
				"***************** LOGOUT FROM ADMIN USER AND LOGIN WITH CONTRACTOR AND VERIFY TASK IS DISPLAYED OR NOT *****************");
		Reporter.log(
				"***************** LOGOUT FROM ADMIN USER AND LOGIN WITH CONTRACTOR AND VERIFY TASK IS DISPLAYED OR NOT *****************");
		log.info(
				"***************** LOGOUT FROM ADMIN USER AND LOGIN WITH CONTRACTOR AND VERIFY TASK IS DISPLAYED OR NOT *****************");

		try {

			// wait for the element
			explicitWaitClickable("questionnaire_settingicon_CSS");

			// click on the settings icon from the top of the screen
			click("questionnaire_settingicon_CSS");
			System.out.println("Clicked on the settings icon.");
			ngDriver.waitForAngularRequestsToFinish();

			// wait for 3 seconds
			Thread.sleep(3000);

			// click on the logout option from the side menu
			click("sidemenu_logout_CSS");
			System.out.println("Clicked on the logout option from the side menu.");
			ngDriver.waitForAngularRequestsToFinish();

			// LOGIN WITH CONTRACTOR AND VERIFY TASK IS DISPLAYED OR NOT

			helper.loginAndUpdateSystemCompany(data, "username", "password", "system_company_1");

			// enter the property name in the search field
			type("envreports_propertylist_filtertxt_CSS", data.get("property_1"));
			System.out.println("Entered the property name in the search field.");
			ngDriver.waitForAngularRequestsToFinish();

			// wait for the element
			explicitWaitClickable("taskicon_CSS");

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
			try {
				String str1 = driver.findElement(By.xpath(OR.getProperty("task_createdtask_roleuser2_XPATH")))
						.getText();
				ngDriver.waitForAngularRequestsToFinish();
				if (str1.equals("Test Role User Task 2 Title")) {

					switchVerification("task_createdtask_roleuser2_XPATH", "Test Role User Task 2 Title",
							"The Test Role User Task 2 Title task is not displayed.");

					System.out.println("The Test Role User Task 2 Title task is verified successfully.");
					test.log(LogStatus.INFO, "The Test Role User Task 2 Title task is verified successfully.");
					Reporter.log("The Test Role User Task 2 Title task is verified successfully.");
					log.info("The Test Role User Task 2 Title task is verified successfully.");
				} else {
					TestUtil.captureScreenshot();

					// ReportNG
					Reporter.log(
							"<br>" + "The Test Role User Task 2 Title task is not verified successfully : " + "<br>");
					Reporter.log("<a target=\"_blank\" href=" + TestUtil.screenshotName + "><img src="
							+ TestUtil.screenshotName + " height=200 width=200></img></a>");
					Reporter.log("<br>");
					Reporter.log("<br>");

					// Extent Report
					test.log(LogStatus.FAIL, " The Test Role User Task 2 Title task is not verified successfully : ");
					test.log(LogStatus.FAIL, test.addScreenCapture(TestUtil.screenshotName));

					System.out.println("The Test Role User Task 2 Title task is not verified successfully.");
					log.info("The Test Role User Task 2 Title task is not verified successfully.");
				}
			} catch (Throwable t) {
				TestUtil.captureScreenshot();

				// ReportNG
				Reporter.log("<br>" + "The Test Role User Task 2 Title task is not verified successfully : " + "<br>");
				Reporter.log("<a target=\"_blank\" href=" + TestUtil.screenshotName + "><img src="
						+ TestUtil.screenshotName + " height=200 width=200></img></a>");
				Reporter.log("<br>");
				Reporter.log("<br>");

				// Extent Report
				test.log(LogStatus.FAIL, " The Test Role User Task 2 Title task is not verified successfully : ");
				test.log(LogStatus.FAIL, test.addScreenCapture(TestUtil.screenshotName));

				System.out.println("The Test Role User Task 2 Title task is not verified successfully.");
				log.info("The Test Role User Task 2 Title task is not verified successfully.");

			}

			// LOGOUT FROM CONTRACTOR USER AND LOGIN WITH JINESHQA USER AND VERIFY TASK IS
			// DISPLAYED OR NOT

			System.out.println(
					"***************** LOGOUT FROM CONTRACTOR USER AND LOGIN WITH JINESHQA USER AND VERIFY TASK IS DISPLAYED OR NOT *****************");
			test.log(LogStatus.INFO,
					"***************** LOGOUT FROM CONTRACTOR USER AND LOGIN WITH JINESHQA USER AND VERIFY TASK IS DISPLAYED OR NOT *****************");
			Reporter.log(
					"***************** LOGOUT FROM CONTRACTOR USER AND LOGIN WITH JINESHQA USER AND VERIFY TASK IS DISPLAYED OR NOT *****************");
			log.info(
					"***************** LOGOUT FROM CONTRACTOR USER AND LOGIN WITH JINESHQA USER AND VERIFY TASK IS DISPLAYED OR NOT *****************");

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

			helper.loginAndUpdateSystemCompany(data, "username_2", "password_2", "system_company_1");

			// enter the property name in the search field
			clear("envreports_propertylist_filtertxt_CSS");
			type("envreports_propertylist_filtertxt_CSS", data.get("property_1"));
			System.out.println("Entered the property name in the search field.");
			ngDriver.waitForAngularRequestsToFinish();

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
			try {
				String str2 = driver.findElement(By.xpath(OR.getProperty("task_createdtask_roleuser2_XPATH")))
						.getText();
				ngDriver.waitForAngularRequestsToFinish();
				if (str2.equals("Test Role User Task 2 Title")) {

					TestUtil.captureScreenshot();

					// ReportNG
					Reporter.log(
							"<br>" + "The Test Role User Task 2 Title task is not verified successfully : " + "<br>");
					Reporter.log("<a target=\"_blank\" href=" + TestUtil.screenshotName + "><img src="
							+ TestUtil.screenshotName + " height=200 width=200></img></a>");
					Reporter.log("<br>");
					Reporter.log("<br>");

					// Extent Report
					test.log(LogStatus.FAIL, " The Test Role User Task 2 Title task is not verified successfully : ");
					test.log(LogStatus.FAIL, test.addScreenCapture(TestUtil.screenshotName));

					System.out.println("The Test Role User Task 2 Title task is not verified successfully.");
					log.info("The Test Role User Task 2 Title task is not verified successfully.");

				} else {
					System.out.println("The Test Role User Task 2 Title task is verified successfully.");
					test.log(LogStatus.INFO, "The Test Role User Task 2 Title task is verified successfully.");
					Reporter.log("The Test Role User Task 2 Title task is verified successfully.");
					log.info("The Test Role User Task 2 Title task is verified successfully.");

				}
			} catch (Throwable t) {
				System.out.println("The Test Role User Task 2 Title task is verified successfully.");
				test.log(LogStatus.INFO, "The Test Role User Task 2 Title task is verified successfully.");
				Reporter.log("The Test Role User Task 2 Title task is verified successfully.");
				log.info("The Test Role User Task 2 Title task is verified successfully.");

			}

			// LOGOUT FROM JINESHQA USER AND LOGIN WITH JINESH MISC USER AND VERIFY TASK IS
			// DISPLAYED OR NOT

			System.out.println(
					"***************** LOGOUT FROM JINESHQA USER AND LOGIN WITH JINESH MISC USER AND VERIFY TASK IS DISPLAYED OR NOT *****************");
			test.log(LogStatus.INFO,
					"***************** LOGOUT FROM JINESHQA USER AND LOGIN WITH JINESH MISC USER AND VERIFY TASK IS DISPLAYED OR NOT *****************");
			Reporter.log(
					"***************** LOGOUT FROM JINESHQA USER AND LOGIN WITH JINESH MISC USER AND VERIFY TASK IS DISPLAYED OR NOT *****************");
			log.info(
					"***************** LOGOUT FROM JINESHQA USER AND LOGIN WITH JINESH MISC USER AND VERIFY TASK IS DISPLAYED OR NOT *****************");

			// wait for element
			explicitWaitClickable("questionnaire_settingicon_CSS");

			// click on the settings icon from the top of the screen
			click("questionnaire_settingicon_CSS");
			System.out.println("Clicked on the settings icon.");
			ngDriver.waitForAngularRequestsToFinish();

			// wait for element
			explicitWaitClickable("sidemenu_logout_CSS");

			// click on the logout option from the side menu
			click("sidemenu_logout_CSS");
			System.out.println("Clicked on the logout option from the side menu.");
			ngDriver.waitForAngularRequestsToFinish();

			helper.loginAndUpdateSystemCompany(data, "username_4", "password_4", "system_company_1");

			// enter the property name in the search field
			clear("envreports_propertylist_filtertxt_CSS");
			type("envreports_propertylist_filtertxt_CSS", data.get("property_2"));
			System.out.println("Entered the property name in the search field.");
			ngDriver.waitForAngularRequestsToFinish();

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
			try {
				String str3 = driver.findElement(By.xpath(OR.getProperty("task_createdtask_roleuser2_XPATH")))
						.getText();
				ngDriver.waitForAngularRequestsToFinish();
				if (str3.equals("Test Role User Task 2 Title")) {

					TestUtil.captureScreenshot();

					// ReportNG
					Reporter.log(
							"<br>" + "The Test Role User Task 2 Title task is not verified successfully : " + "<br>");
					Reporter.log("<a target=\"_blank\" href=" + TestUtil.screenshotName + "><img src="
							+ TestUtil.screenshotName + " height=200 width=200></img></a>");
					Reporter.log("<br>");
					Reporter.log("<br>");

					// Extent Report
					test.log(LogStatus.FAIL, " The Test Role User Task 2 Title task is not verified successfully : ");
					test.log(LogStatus.FAIL, test.addScreenCapture(TestUtil.screenshotName));

					System.out.println("The Test Role User Task 2 Title task is not verified successfully.");
					log.info("The Test Role User Task 2 Title task is not verified successfully.");

				}
			} catch (Throwable t) {

				System.out.println("The Test Role User Task 2 Title task is verified successfully.");
				test.log(LogStatus.INFO, "The Test Role User Task 2 Title task is verified successfully.");
				Reporter.log("The Test Role User Task 2 Title task is verified successfully.");
				log.info("The Test Role User Task 2 Title task is verified successfully.");
			}

			// LOGOUT FROM JINESHQA USER AND LOGIN WITH ADMIN USER

			System.out
					.println("***************** LOGOUT FROM JINESHQA USER AND LOGIN WITH ADMIN USER *****************");
			test.log(LogStatus.INFO,
					"***************** LOGOUT FROM JINESHQA USER AND LOGIN WITH ADMIN USER *****************");
			Reporter.log("***************** LOGOUT FROM JINESHQA USER AND LOGIN WITH ADMIN USER *****************");
			log.info("***************** LOGOUT FROM JINESHQA USER AND LOGIN WITH ADMIN USER *****************");

			// wait for element
			explicitWaitClickable("questionnaire_settingicon_CSS");

			// click on the settings icon from the top of the screen
			click("questionnaire_settingicon_CSS");
			System.out.println("Clicked on the settings icon.");
			ngDriver.waitForAngularRequestsToFinish();

			// wait for element
			explicitWaitClickable("sidemenu_logout_CSS");

			// click on the logout option from the side menu
			click("sidemenu_logout_CSS");
			System.out.println("Clicked on the logout option from the side menu.");
			ngDriver.waitForAngularRequestsToFinish();

			// LOGIN WITH ADMIN USER AND DELETE THE CREATED TASK

			helper.loginAndUpdateSystemCompany(data, "username_1", "password_1", "system_company_1");

		} catch (Throwable t) {
			helper.questionnaireNotDisplayLogout(data);
		}

		// DELETE THE CREATED TASK

		System.out.println("***************** DELETE THE CREATED TASK *****************");
		test.log(LogStatus.INFO, "***************** DELETE THE CREATED TASK *****************");
		Reporter.log("***************** DELETE THE CREATED TASK *****************");
		log.info("***************** DELETE THE CREATED TASK *****************");

		try {
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

			// click on the newly created task
			click("task_createdtask_roleuser2_XPATH");
			System.out.println("Click on the newly created task.");
			ngDriver.waitForAngularRequestsToFinish();

			// wait for element
			explicitWaitClickable("task_deletedtaskbtn_CSS");

			// click on the delete button
			click("task_deletedtaskbtn_CSS");
			System.out.println("Clicked on the delete button.");
			ngDriver.waitForAngularRequestsToFinish();

			// wait for element
			explicitWaitClickable("task_deletedtaskbtn_confirmaiton_CSS");

			// click on the delete button of the confirmation popup
			click("task_deletedtaskbtn_confirmaiton_CSS");
			System.out.println("Clicked on the delete button of the confirmation popup.");
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

			// verify the questionnaire deleted or not

			helper.deleteVerification("task_createdtask_roleuser2_XPATH", "Test Role User Task 2 Title");

		} catch (Throwable t) {
			verificationFailed();
		}

		// click on the home icon from the top of the screen
		click("questionnaire_homeburgermenubtn_hide_CSS");
		System.out.println("Clicked on the home icon from the top of the screen.");
		ngDriver.waitForAngularRequestsToFinish();

		// wait for the element
		explicitWait("propertylist_title_XPATH");

		// verify the property list
		switchVerification("propertylist_title_XPATH", "Property List", "The property list is not displayed.");

	}
}
