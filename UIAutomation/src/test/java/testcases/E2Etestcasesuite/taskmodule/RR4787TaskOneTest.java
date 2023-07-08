package testcases.E2Etestcasesuite.taskmodule;

import java.io.IOException;
import java.util.Hashtable;
import java.util.List;

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

public class RR4787TaskOneTest extends TestBase {

	@Test(dataProviderClass = TestUtil.class, dataProvider = "dp")
	public void rR4787TaskOneTest(Hashtable<String, String> data) throws IOException, InterruptedException {

		execution(data, "rR4787TaskOneTest");

		// CREATE TASK > WITHOUT A TASK TYPE > ADD DEFAULT TASK ASSIGNEE > 1. CAN REMOVE
		// ANY TASK ASSIGNEES 2. CAN ADD NEW USERS/ROLES.

		System.out.println(
				"CREATE TASK > WITHOUT A TASK TYPE > ADD DEFAULT TASK ASSIGNEE > 1. CAN REMOVE ANY TASK ASSIGNEES 2. CAN ADD NEW USERS/ROLES.");
		test.log(LogStatus.INFO,
				"CREATE TASK > WITHOUT A TASK TYPE > ADD DEFAULT TASK ASSIGNEE > 1. CAN REMOVE ANY TASK ASSIGNEES 2. CAN ADD NEW USERS/ROLES.");
		Reporter.log(
				"CREATE TASK > WITHOUT A TASK TYPE > ADD DEFAULT TASK ASSIGNEE > 1. CAN REMOVE ANY TASK ASSIGNEES 2. CAN ADD NEW USERS/ROLES.");
		log.info(
				"CREATE TASK > WITHOUT A TASK TYPE > ADD DEFAULT TASK ASSIGNEE > 1. CAN REMOVE ANY TASK ASSIGNEES 2. CAN ADD NEW USERS/ROLES.");

		Helper helper = new Helper();

		// refresh the page
		driver.navigate().refresh();
		Thread.sleep(5000);
		driver.navigate().refresh();

		System.out.println("Navigate to the Home Screen i.e. Property List Screen.");

		// SET DEFAULT USERS AND ROLES IN THE SECURITY SETTINGS AND ROLE LEVEL
		System.out.println(
				"*************************** SET DEFAULT USERS AND ROLES IN THE SECURITY SETTINGS AND ROLE LEVEL ***************************");
		test.log(LogStatus.INFO,
				"*************************** SET DEFAULT USERS AND ROLES IN THE SECURITY SETTINGS AND ROLE LEVEL ***************************");
		Reporter.log(
				"*************************** SET DEFAULT USERS AND ROLES IN THE SECURITY SETTINGS AND ROLE LEVEL ***************************");
		log.info(
				"*************************** SET DEFAULT USERS AND ROLES IN THE SECURITY SETTINGS AND ROLE LEVEL ***************************");

		try {
			// wait for element
			explicitWaitClickable("questionnaire_settingicon_userupdate_CSS");

			// click on the settings icon
			click("questionnaire_settingicon_userupdate_CSS");
			ngDriver.waitForAngularRequestsToFinish();
			System.out.println("Clicked on he settings icon.");

			// wait for element
			explicitWaitClickable("questionnaire_administrationoption_XPATH");

			// click on the Administration option from the side menu
			click("questionnaire_administrationoption_XPATH");
			System.out.println("Clicked on the Administration option from the side menu.");
			ngDriver.waitForAngularRequestsToFinish();

			// click on the Security tab
			click("questionnaire_securitytab_XPATH");
			System.out.println("Clicked on the Security tab.");
			ngDriver.waitForAngularRequestsToFinish();

			// click on the Security Settings option
			click("ssc_securitytab_securitysettingsoption_XPATH");
			ngDriver.waitForAngularRequestsToFinish();
			System.out.println("Clicked on the Security Settings option.");

			// enter Default General Task Assignees text in search field
			clear("task_permission_securitysettings_searchtxt1_CSS");
			type("task_permission_securitysettings_searchtxt1_CSS", data.get("search_ss"));
			ngDriver.waitForAngularRequestsToFinish();
			System.out.println("Entered Default General Task Assignees text in search field.");

			// click on the searched result
			driver.findElement(By.xpath("//span[text()='Default general task assignee ']")).click();
			ngDriver.waitForAngularRequestsToFinish();
			System.out.println("Clicked on the searched result.");

			// click on the role field
			click("task_permission_securitysettings_roletxt_CSS");
			ngDriver.waitForAngularRequestsToFinish();
			System.out.println("Clicked on the role field.");

			// click on the none button
			click("task_permission_securitysettings_nonebtn_CSS");
			ngDriver.waitForAngularRequestsToFinish();
			System.out.println("Clicked on the none button.");

			// enter the role in the search field
			type("task_permission_securitysettings_searchtxt_CSS", data.get("role_ss"));
			ngDriver.waitForAngularRequestsToFinish();
			System.out.println("Entered the role in the search field.");

			// click on the searched result
			click("task_permission_securitysettings_seachedrole_XPATH");
			ngDriver.waitForAngularRequestsToFinish();
			System.out.println("Clicked on the searched result.");

			// click on the role field
			click("task_permission_securitysettings_roletxt_CSS");
			ngDriver.waitForAngularRequestsToFinish();
			System.out.println("Clicked on the role field.");

			// click on the user field
			click("task_permission_securitysettings_usertxt_CSS");
			ngDriver.waitForAngularRequestsToFinish();
			System.out.println("Clicked on the user field.");

			// click on the none button
			click("task_permission_securitysettings_nonebtn_CSS");
			ngDriver.waitForAngularRequestsToFinish();
			System.out.println("Clicked on the none button.");

			// enter the role in the search field
			type("task_permission_securitysettings_searchtxt_CSS", data.get("user_ss"));
			ngDriver.waitForAngularRequestsToFinish();
			System.out.println("Entered the role in the search field.");

			// click on the searched result
			click("task_permission_securitysettings_seacheduser_XPATH");
			ngDriver.waitForAngularRequestsToFinish();
			System.out.println("Clicked on the searched result.");

			// click on the role field
			click("task_permission_securitysettings_usertxt_CSS");
			ngDriver.waitForAngularRequestsToFinish();
			System.out.println("Clicked on the user field.");

			// click on the save button
			click("securitysettings_accesssurveychecklist_CSS");
			ngDriver.waitForAngularRequestsToFinish();
			System.out.println("Clicked on the save button.");

		} catch (Throwable t) {
			verificationFailed();
		}

		try {
			// click on the administration
			click("administration_XPATH");
			ngDriver.waitForAngularRequestsToFinish();
			System.out.println("Clicked on the administration.");

			// click on the Security tab
			click("questionnaire_securitytab_XPATH");
			System.out.println("Clicked on the Security tab.");
			ngDriver.waitForAngularRequestsToFinish();

			// click on the roles option
			click("ssc_securitytab_rolesoption_XPATH");
			ngDriver.waitForAngularRequestsToFinish();
			System.out.println("Clicked on the roles option.");

			// scroll down the screen
			JavascriptExecutor js = (JavascriptExecutor) driver;
			js.executeScript("window.scrollBy(0,200)");

			// collect all the roles

			try {
				String pages = driver.findElement(By.cssSelector("strong")).getText();
				String[] arrOfStr = pages.split(" ");
				String pageno = arrOfStr[3];
				int pagecount = Integer.parseInt(pageno);

				for (int i = 0; i < pagecount; i++) {

					List<WebElement> roles = driver.findElements(By.xpath("//tr//div"));
					int rolesnum = roles.size();

					for (int j = 0; j < rolesnum; j++) {

						WebElement rolestext = roles.get(j);
						String getrole = rolestext.getText();

						if (getrole.equalsIgnoreCase("Contractor")) {

							// click on the Contractor role
							click("task_permission_roles_XPATH");
							ngDriver.waitForAngularRequestsToFinish();
							System.out.println("Clicked on the Contractor role.");
							break;
						}
					}

					// click on the next button
					click("task_permission_roles_nextbtn_CSS");
					ngDriver.waitForAngularRequestsToFinish();
					System.out.println("Clicked on the next button.");

				}
			} catch (Throwable t) {
				System.out.println("Successfully navigate to the Role Details screen.");
				test.log(LogStatus.INFO, "Successfully navigate to the Role Details screen.");
				Reporter.log("Successfully navigate to the Role Details screen.");
				log.info("Successfully navigate to the Role Details screen.");
			}

			// scroll down the screen
			js.executeScript("window.scrollBy(0,600)");

			// click on the Allow Task Assignment to Roles field
			click("task_permission_rolelevel_role1_CSS");
			ngDriver.waitForAngularRequestsToFinish();
			System.out.println("Clicked on the Allow Task Assignment to Roles field.");

			// click on the none button
			click("task_permission_securitysettings_nonebtn_CSS");
			ngDriver.waitForAngularRequestsToFinish();
			System.out.println("Clicked on the none button.");

			// click on the Allow Task Assignment to Roles field
			click("task_permission_rolelevel_role1_CSS");
			ngDriver.waitForAngularRequestsToFinish();
			System.out.println("Clicked on the Allow Task Assignment to Roles field.");

			// click on the Default User Task Assignees field
			click("task_permission_rolelevel_user2_CSS");
			ngDriver.waitForAngularRequestsToFinish();
			System.out.println("Clicked on the Default User Task Assignees field.");

			// click on the none button
			click("task_permission_securitysettings_nonebtn_CSS");
			ngDriver.waitForAngularRequestsToFinish();
			System.out.println("Clicked on the none button.");

			// type the user name in the search field
			type("task_permission_securitysettings_searchtxt_CSS", data.get("user_rolelevel"));
			ngDriver.waitForAngularRequestsToFinish();
			System.out.println("Typed the user name in the search field.");

			// click on the searched result
			click("task_permission_rolelevel_searched1_XPATH");
			ngDriver.waitForAngularRequestsToFinish();
			System.out.println("Clicked on the searched result.");

			// click on the Default User Task Assignees field
			click("task_permission_rolelevel_user2_CSS");
			ngDriver.waitForAngularRequestsToFinish();
			System.out.println("Clicked on the Default User Task Assignees field.");

			// click on the Default Role Task Assignees field
			click("task_permission_rolelevel_role3_CSS");
			ngDriver.waitForAngularRequestsToFinish();
			System.out.println("Clicked on the Default Role Task Assignees field.");

			// click on the none button
			click("task_permission_securitysettings_nonebtn_CSS");
			ngDriver.waitForAngularRequestsToFinish();
			System.out.println("Clicked on the none button.");

			// type the role name in the search field
			type("task_permission_securitysettings_searchtxt_CSS", data.get("role_rolelevel"));
			ngDriver.waitForAngularRequestsToFinish();
			System.out.println("Typed the role name in the search field.");

			// click on the searched result
			click("task_permission_rolelevel_searched2_XPATH");
			ngDriver.waitForAngularRequestsToFinish();
			System.out.println("Clicked on the searched result.");

			// click on the Default Role Task Assignees field
			click("task_permission_rolelevel_role3_CSS");
			ngDriver.waitForAngularRequestsToFinish();
			System.out.println("Clicked on the Default Role Task Assignees field.");

			// click on the Default Tags For Adhoc Task field
			click("task_permission_rolelevel_adhog4_CSS");
			ngDriver.waitForAngularRequestsToFinish();
			System.out.println("Clicked on the Default Tags For Adhoc Task field.");

			// click on the none button
			click("task_permission_securitysettings_nonebtn_CSS");
			ngDriver.waitForAngularRequestsToFinish();
			System.out.println("Clicked on the none button.");

			// click on the Default Tags For Adhoc Task field
			click("task_permission_rolelevel_adhog4_CSS");
			ngDriver.waitForAngularRequestsToFinish();
			System.out.println("Clicked on the Default Tags For Adhoc Task field.");

			// click on the save role button
			click("task_permission_roles_saverolebtn_CSS");
			ngDriver.waitForAngularRequestsToFinish();
			System.out.println("Clicked on the save role button.");

		} catch (Throwable t) {
			verificationFailed();
		}

		// click on the home icon
		click("questionnaire_homeburgermenubtn_CSS");
		ngDriver.waitForAngularRequestsToFinish();
		System.out.println("Clicked on the home icon.");

		// synchronization
		explicitWait("propertylist_title_XPATH");

		// verify the property list
		switchVerification("propertylist_title_XPATH", "Property List", "The property list is not displayed.");

		// SECURITY SETTINGS LEVEL VERIFICATION
		System.out.println("*************************** SECURITY SETTINGS VERIFICATION ***************************");
		test.log(LogStatus.INFO,
				"*************************** SECURITY SETTINGS VERIFICATION ***************************");
		Reporter.log("*************************** SECURITY SETTINGS VERIFICATION ***************************");
		log.info("*************************** SECURITY SETTINGS VERIFICATION ***************************");

		try {
			// click on the task icon
			click("taskicon_CSS");
			System.out.println("Clicked on the task icon.");
			ngDriver.waitForAngularRequestsToFinish();

			// click on the add task button
			click("task_addtaskbtn_CSS");
			System.out.println("Clicked on the add task button.");
			ngDriver.waitForAngularRequestsToFinish();

			// compare the default displayed user and role in assigned to field
			try {
				boolean str1 = driver.findElement(By.xpath("//span[text()='Jinesh QA']")).isDisplayed();
				boolean str2 = driver.findElement(By.xpath("//span[text()='Contractor']")).isDisplayed();

				if (str1 && str2) {
					System.out.println("The default user and role is displayed successfully.");
					test.log(LogStatus.INFO, "The default user and role is displayed successfully.");
					Reporter.log("The default user and role is displayed successfully.");
					log.info("The default user and role is displayed successfully.");
				} else {
					TestUtil.captureScreenshot();

					// ReportNG
					Reporter.log("<br>" + "The default user or role is not displayed : " + "<br>");
					Reporter.log("<a target=\"_blank\" href=" + TestUtil.screenshotName + "><img src="
							+ TestUtil.screenshotName + " height=200 width=200></img></a>");
					Reporter.log("<br>");
					Reporter.log("<br>");

					// Extent Report
					test.log(LogStatus.FAIL, " The default user or role is not displayed : ");
					test.log(LogStatus.FAIL, test.addScreenCapture(TestUtil.screenshotName));

					System.out.println("The default user or role is not displayed.");
					log.info("The default user or role is not displayed.");
				}

			} catch (Throwable t) {
				TestUtil.captureScreenshot();

				// ReportNG
				Reporter.log("<br>" + "The default user or role is not displayed : " + "<br>");
				Reporter.log("<a target=\"_blank\" href=" + TestUtil.screenshotName + "><img src="
						+ TestUtil.screenshotName + " height=200 width=200></img></a>");
				Reporter.log("<br>");
				Reporter.log("<br>");

				// Extent Report
				test.log(LogStatus.FAIL, " The default user or role is not displayed : ");
				test.log(LogStatus.FAIL, test.addScreenCapture(TestUtil.screenshotName));

				System.out.println("The default user or role is not displayed.");
				log.info("The default user or role is not displayed.");
			}

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

			// enter the user name in the search field
			type("workflowsecurity_editortask_taskdetails_searchtasktagtxt_CSS", data.get("search_user"));
			System.out.println("Entered the user name in the search field.");
			ngDriver.waitForAngularRequestsToFinish();

			// click on the searched result
			click("task_permission_task_selectusertxt_XPATH");
			System.out.println("Clicked on the searched result.");
			ngDriver.waitForAngularRequestsToFinish();

			// click on the assign to field
			click("task_assigntotxt_CSS");
			System.out.println("Clicked on the assign to field.");
			ngDriver.waitForAngularRequestsToFinish();

			// scroll down the screen
			JavascriptExecutor js = (JavascriptExecutor) driver;
			js.executeScript("window.scrollBy(0,1200)");

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

			// verify newly created task is displayed or not

			try {
				String str2 = (driver.findElement(By.xpath("//p[contains(text(),'Test Task Permission Three Title')]"))
						.getText()).trim();
				ngDriver.waitForAngularRequestsToFinish();
				if (str2.equals("Test Task Permission Three Title")) {

					System.out.println("The Test Task Permission Three Title is verified successfully.");
					test.log(LogStatus.INFO, "The Test Task Permission Three Title is verified successfully.");
					Reporter.log("The Test Task Permission Three Title is verified successfully.");
					log.info("The Test Task Permission Three Title is verified successfully.");
				} else {
					verificationFailed();
				}
			} catch (Throwable t) {
				verificationFailed();
			}

			// wait for the 5 seconds
			Thread.sleep(5000);

			// click on the newly created task
			driver.findElement(By.xpath("//p[contains(text(),'Test Task Permission Three Title')]")).click();
			System.out.println("Click on the newly created task.");
			ngDriver.waitForAngularRequestsToFinish();

			// compare the default displayed user and role and newly added user in assigned
			// to field
			try {
				boolean str3 = driver.findElement(By.xpath("//span[text()='Jinesh QA']")).isDisplayed();
				boolean str4 = driver.findElement(By.xpath("//span[text()='Contractor']")).isDisplayed();
				boolean str5 = driver.findElement(By.xpath("//span[text()='Jinesh']")).isDisplayed();

				if (str3 && str4 && str5) {
					System.out.println("The default user and role and newly added user is displayed successfully.");
					test.log(LogStatus.INFO,
							"The default user and role and newly added user is displayed successfully.");
					Reporter.log("The default user and role and newly added user is displayed successfully.");
					log.info("The default user and role and newly added user is displayed successfully.");
				} else {
					TestUtil.captureScreenshot();

					// ReportNG
					Reporter.log("<br>" + "The default user, role, or newly added user is not displayed : " + "<br>");
					Reporter.log("<a target=\"_blank\" href=" + TestUtil.screenshotName + "><img src="
							+ TestUtil.screenshotName + " height=200 width=200></img></a>");
					Reporter.log("<br>");
					Reporter.log("<br>");

					// Extent Report
					test.log(LogStatus.FAIL, " The default user, role, or newly added user is not displayed : ");
					test.log(LogStatus.FAIL, test.addScreenCapture(TestUtil.screenshotName));

					System.out.println("The default user, role, or newly added user is not displayed.");
					log.info("The default user, role, or newly added user is not displayed.");
				}

			} catch (Throwable t) {
				TestUtil.captureScreenshot();

				// ReportNG
				Reporter.log("<br>" + "The default user, role, or newly added user is not displayed : " + "<br>");
				Reporter.log("<a target=\"_blank\" href=" + TestUtil.screenshotName + "><img src="
						+ TestUtil.screenshotName + " height=200 width=200></img></a>");
				Reporter.log("<br>");
				Reporter.log("<br>");

				// Extent Report
				test.log(LogStatus.FAIL, " The default user, role, or newly added user is not displayed : ");
				test.log(LogStatus.FAIL, test.addScreenCapture(TestUtil.screenshotName));

				System.out.println("The default user, role, or newly added user is not displayed.");
				log.info("The default user, role, or newly added user is not displayed.");
			}

			// update the title of the task
			clear("task_addtask_titletxt_CSS");
			type("task_addtask_titletxt_CSS", data.get("update_task_title"));
			System.out.println("Entered the updated data in the task title.");
			ngDriver.waitForAngularRequestsToFinish();

			// click on the assign to field
			click("task_assigntotxt_CSS");
			System.out.println("Clicked on the assign to field.");
			ngDriver.waitForAngularRequestsToFinish();

			// enter the user name in the search field
			type("workflowsecurity_editortask_taskdetails_searchtasktagtxt_CSS", data.get("search_user_update"));
			System.out.println("Entered the user name in the search field.");
			ngDriver.waitForAngularRequestsToFinish();

			// click on the searched result
			click("task_permission_task_updateselectusertxt_XPATH");
			System.out.println("Clicked on the searched result.");
			ngDriver.waitForAngularRequestsToFinish();

			// click on the assign to field
			click("task_assigntotxt_CSS");
			System.out.println("Clicked on the assign to field.");
			ngDriver.waitForAngularRequestsToFinish();

			// click on the update button
			click("survey_task_updatebtn_CSS");
			System.out.println("Clicked on the update button.");
			ngDriver.waitForAngularRequestsToFinish();

			// wait for the element
			explicitWaitClickable("closetoastmsg_CSS");

			// click on the toaster close button
			click("closetoastmsg_CSS");
			ngDriver.waitForAngularRequestsToFinish();
			System.out.println("Clicked on the toaster close button.");

			// click on the back button
			driver.findElement(By.xpath("//button[@ng-click='cancelTaskInput(false); resetTaskInputDetails();']"))
					.click();
			ngDriver.waitForAngularRequestsToFinish();
			System.out.println("Clicked on the back button.");

			// scroll up the screen
			js.executeScript("window.scrollBy(0,-500)");

			// click on the clear button
			click("task_createdtask_clearbtn_XPATH");
			ngDriver.waitForAngularRequestsToFinish();
			System.out.println("Clicked on the clear button.");

			// enter the data in the search field
			type("task_filter_CSS", data.get("update_task_title"));
			System.out.println("Entered the data in the search field.");
			ngDriver.waitForAngularRequestsToFinish();

			// click on the search button
			click("task_createdtask_searchbtn_XPATH");
			ngDriver.waitForAngularRequestsToFinish();
			System.out.println("Clicked on the search button.");

			// verify updated task is displayed or not

			try {
				String str209 = (driver
						.findElement(By.xpath("//p[contains(text(),'Update Test Task Permission Three Title')]"))
						.getText()).trim();
				ngDriver.waitForAngularRequestsToFinish();
				if (str209.equals("Update Test Task Permission Three Title")) {

					System.out.println("The Update Test Task Permission Three Title is verified successfully.");
					test.log(LogStatus.INFO, "The Update Test Task Permission Three Title is verified successfully.");
					Reporter.log("The Update Test Task Permission Three Title is verified successfully.");
					log.info("The Update Test Task Permission Three Title is verified successfully.");
				} else {
					verificationFailed();
				}
			} catch (Throwable t) {
				verificationFailed();
			}

			// wait for the 5 seconds
			Thread.sleep(5000);

			// click on the updated task
			driver.findElement(By.xpath("//p[contains(text(),'Update Test Task Permission Three Title')]")).click();
			System.out.println("Click on the newly created task.");
			ngDriver.waitForAngularRequestsToFinish();

			// compare the default displayed user and role, newly added user, and updated
			// user in assigned to field
			try {
				boolean str6 = driver.findElement(By.xpath("//span[text()='Jinesh QA']")).isDisplayed();
				boolean str7 = driver.findElement(By.xpath("//span[text()='Contractor']")).isDisplayed();
				boolean str8 = driver.findElement(By.xpath("//span[text()='Jinesh']")).isDisplayed();
				boolean str9 = driver.findElement(By.xpath("//span[text()='Jinesh Sample One']")).isDisplayed();

				if (str6 && str7 && str8 && str9) {
					System.out.println(
							"The default user and role, newly added user, and updated user is displayed successfully.");
					test.log(LogStatus.INFO,
							"The default user and role, newly added user, and updated user is displayed successfully.");
					Reporter.log(
							"The default user and role, newly added user, and updated user is displayed successfully.");
					log.info(
							"The default user and role, newly added user, and updated user is displayed successfully.");
				} else {
					TestUtil.captureScreenshot();

					// ReportNG
					Reporter.log(
							"<br>" + "The default user and role, newly added user, or updated user is not displayed : "
									+ "<br>");
					Reporter.log("<a target=\"_blank\" href=" + TestUtil.screenshotName + "><img src="
							+ TestUtil.screenshotName + " height=200 width=200></img></a>");
					Reporter.log("<br>");
					Reporter.log("<br>");

					// Extent Report
					test.log(LogStatus.FAIL,
							" The default user and role, newly added user, or updated user is not displayed : ");
					test.log(LogStatus.FAIL, test.addScreenCapture(TestUtil.screenshotName));

					System.out
							.println("The default user and role, newly added user, or updated user is not displayed.");
					log.info("The default user and role, newly added user, or updated user is not displayed.");
				}

			} catch (Throwable t) {
				TestUtil.captureScreenshot();

				// ReportNG
				Reporter.log("<br>" + "The default user and role, newly added user, or updated user is not displayed : "
						+ "<br>");
				Reporter.log("<a target=\"_blank\" href=" + TestUtil.screenshotName + "><img src="
						+ TestUtil.screenshotName + " height=200 width=200></img></a>");
				Reporter.log("<br>");
				Reporter.log("<br>");

				// Extent Report
				test.log(LogStatus.FAIL,
						" The default user and role, newly added user, or updated user is not displayed : ");
				test.log(LogStatus.FAIL, test.addScreenCapture(TestUtil.screenshotName));

				System.out.println("The default user and role, newly added user, or updated user is not displayed.");
				log.info("The default user and role, newly added user, or updated user is not displayed.");
			}

			// DELETE THE TASK

			System.out.println("***************** DELETE THE TASK *****************");
			test.log(LogStatus.INFO, "***************** DELETE THE TASK *****************");
			Reporter.log("***************** DELETE THE TASK *****************");
			log.info("***************** DELETE THE TASK *****************");

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

			// scroll up the screen
			js.executeScript("window.scrollBy(0,-500)");

			// click on the clear button
			click("task_createdtask_clearbtn_XPATH");
			ngDriver.waitForAngularRequestsToFinish();
			System.out.println("Clicked on the clear button.");

			// enter the data in the search field
			type("task_filter_CSS", data.get("update_task_title"));
			System.out.println("Entered the data in the search field.");
			ngDriver.waitForAngularRequestsToFinish();

			// click on the search button
			click("task_createdtask_searchbtn_XPATH");
			ngDriver.waitForAngularRequestsToFinish();
			System.out.println("Clicked on the search button.");

			// verify the questionnaire deleted or not
			try {
				String str4 = driver
						.findElement(By.xpath(OR.getProperty("task_permission_taskpermission_updatedtask3_XPATH")))
						.getText();
				ngDriver.waitForAngularRequestsToFinish();
				if (str4.equals("Update Test Task Permission Three Title")) {

					Assert.assertTrue(
							isElementPresent(
									By.xpath(OR.getProperty("task_permission_taskpermission_updatedtask3_XPATH"))),
							"The Update Test Task Permission Three Title is not displayed.");

					TestUtil.captureScreenshot();

					// ReportNG
					Reporter.log("<br>" + "Verification failure : " + "<br>");
					Reporter.log("<a target=\"_blank\" href=" + TestUtil.screenshotName + "><img src="
							+ TestUtil.screenshotName + " height=200 width=200></img></a>");
					Reporter.log("<br>");
					Reporter.log("<br>");

					// Extent Report
					test.log(LogStatus.FAIL, " Verification failed with exception : ");
					test.log(LogStatus.FAIL, test.addScreenCapture(TestUtil.screenshotName));

					System.out.println("The task is not deleted successfully.");
					log.info("The task is not deleted successfully.");

				}
			} catch (Throwable t) {
				System.out.println("The task is deleted successfully.");
				test.log(LogStatus.INFO, "The task is deleted successfully.");
				Reporter.log("The task is deleted successfully.");
				log.info("The task is deleted successfully.");
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

		// ROLE LEVEL VERIFICATION
		System.out.println("*************************** ROLE LEVEL VERIFICATION ***************************");
		test.log(LogStatus.INFO, "*************************** ROLE LEVEL VERIFICATION ***************************");
		Reporter.log("*************************** ROLE LEVEL VERIFICATION ***************************");
		log.info("*************************** ROLE LEVEL VERIFICATION ***************************");

		// LOGIN WITH CONTRACTOR USER TWO

		System.out.println("***************** LOGIN WITH CONTRACTOR USER *****************");
		test.log(LogStatus.INFO, "***************** LOGIN WITH CONTRACTOR USER *****************");
		Reporter.log("***************** LOGIN WITH CONTRACTOR USER *****************");
		log.info("***************** LOGIN WITH CONTRACTOR USER *****************");

		try {

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

			// LOGIN WITH CONTRACTOR USER TWO

			helper.loginAndUpdateSystemCompany(data, "username", "password", "system_company_1");

			// click on the task icon
			click("taskicon_CSS");
			System.out.println("Clicked on the task icon.");
			ngDriver.waitForAngularRequestsToFinish();

			// click on the add task button
			click("task_addtaskbtn_CSS");
			System.out.println("Clicked on the add task button.");
			ngDriver.waitForAngularRequestsToFinish();

			// compare the default displayed user and role in assigned to field
			try {
				boolean str10 = driver.findElement(By.xpath("//span[text()='Jinesh QA']")).isDisplayed();
				boolean str11 = driver.findElement(By.xpath("//span[text()='Contractor']")).isDisplayed();
				boolean str12 = driver.findElement(By.xpath("//span[text()='Jinesh QA 2']")).isDisplayed();
				boolean str13 = driver.findElement(By.xpath("//span[text()='Human Resources']")).isDisplayed();

				if (str10 && str11 && str12 && str13) {
					System.out.println("The default user and role is displayed successfully.");
					test.log(LogStatus.INFO, "The default user and role is displayed successfully.");
					Reporter.log("The default user and role is displayed successfully.");
					log.info("The default user and role is displayed successfully.");
				} else {
					TestUtil.captureScreenshot();

					// ReportNG
					Reporter.log("<br>" + "The default user or role is not displayed : " + "<br>");
					Reporter.log("<a target=\"_blank\" href=" + TestUtil.screenshotName + "><img src="
							+ TestUtil.screenshotName + " height=200 width=200></img></a>");
					Reporter.log("<br>");
					Reporter.log("<br>");

					// Extent Report
					test.log(LogStatus.FAIL, " The default user or role is not displayed : ");
					test.log(LogStatus.FAIL, test.addScreenCapture(TestUtil.screenshotName));

					System.out.println("The default user or role is not displayed.");
					log.info("The default user or role is not displayed.");
				}

			} catch (Throwable t) {
				TestUtil.captureScreenshot();

				// ReportNG
				Reporter.log("<br>" + "The default user or role is not displayed : " + "<br>");
				Reporter.log("<a target=\"_blank\" href=" + TestUtil.screenshotName + "><img src="
						+ TestUtil.screenshotName + " height=200 width=200></img></a>");
				Reporter.log("<br>");
				Reporter.log("<br>");

				// Extent Report
				test.log(LogStatus.FAIL, " The default user or role is not displayed : ");
				test.log(LogStatus.FAIL, test.addScreenCapture(TestUtil.screenshotName));

				System.out.println("The default user or role is not displayed.");
				log.info("The default user or role is not displayed.");
			}

			// enter the data in the task title field
			type("task_addtask_titletxt_CSS", data.get("task_title_rolelevel"));
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

			// enter the user name in the search field
			type("workflowsecurity_editortask_taskdetails_searchtasktagtxt_CSS", data.get("search_user"));
			System.out.println("Entered the user name in the search field.");
			ngDriver.waitForAngularRequestsToFinish();

			// click on the searched result
			click("task_permission_task_selectusertxt_XPATH");
			System.out.println("Clicked on the searched result.");
			ngDriver.waitForAngularRequestsToFinish();

			// click on the assign to field
			click("task_assigntotxt_CSS");
			System.out.println("Clicked on the assign to field.");
			ngDriver.waitForAngularRequestsToFinish();

			// scroll down the screen
			JavascriptExecutor js = (JavascriptExecutor) driver;
			js.executeScript("window.scrollBy(0,1200)");

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

			// wait for the 5 seconds
			Thread.sleep(5000);

			// click on the newly created task
			driver.findElement(By.xpath("//p[contains(text(),'Test Task Permission Three Title Rolelevel')]")).click();
			System.out.println("Click on the newly created task.");
			ngDriver.waitForAngularRequestsToFinish();

			// compare the default displayed user and role and newly added user in assigned
			// to field
			try {
				boolean str14 = driver.findElement(By.xpath("//span[text()='Jinesh QA']")).isDisplayed();
				boolean str15 = driver.findElement(By.xpath("//span[text()='Contractor']")).isDisplayed();
				boolean str16 = driver.findElement(By.xpath("//span[text()='Jinesh QA 2']")).isDisplayed();
				boolean str17 = driver.findElement(By.xpath("//span[text()='Human Resources']")).isDisplayed();
				boolean str18 = driver.findElement(By.xpath("//span[text()='Jinesh']")).isDisplayed();

				if (str14 && str15 && str16 && str17 && str18) {
					System.out.println("The default user and role and newly added user is displayed successfully.");
					test.log(LogStatus.INFO,
							"The default user and role and newly added user is displayed successfully.");
					Reporter.log("The default user and role and newly added user is displayed successfully.");
					log.info("The default user and role and newly added user is displayed successfully.");
				} else {
					TestUtil.captureScreenshot();

					// ReportNG
					Reporter.log("<br>" + "The default user, role, or newly added user is not displayed : " + "<br>");
					Reporter.log("<a target=\"_blank\" href=" + TestUtil.screenshotName + "><img src="
							+ TestUtil.screenshotName + " height=200 width=200></img></a>");
					Reporter.log("<br>");
					Reporter.log("<br>");

					// Extent Report
					test.log(LogStatus.FAIL, " The default user, role, or newly added user is not displayed : ");
					test.log(LogStatus.FAIL, test.addScreenCapture(TestUtil.screenshotName));

					System.out.println("The default user, role, or newly added user is not displayed.");
					log.info("The default user, role, or newly added user is not displayed.");
				}

			} catch (Throwable t) {
				TestUtil.captureScreenshot();

				// ReportNG
				Reporter.log("<br>" + "The default user, role, or newly added user is not displayed : " + "<br>");
				Reporter.log("<a target=\"_blank\" href=" + TestUtil.screenshotName + "><img src="
						+ TestUtil.screenshotName + " height=200 width=200></img></a>");
				Reporter.log("<br>");
				Reporter.log("<br>");

				// Extent Report
				test.log(LogStatus.FAIL, " The default user, role, or newly added user is not displayed : ");
				test.log(LogStatus.FAIL, test.addScreenCapture(TestUtil.screenshotName));

				System.out.println("The default user, role, or newly added user is not displayed.");
				log.info("The default user, role, or newly added user is not displayed.");
			}

			// update the title of the task
			clear("task_addtask_titletxt_CSS");
			type("task_addtask_titletxt_CSS", data.get("update_task_title_rolelevel"));
			System.out.println("Entered the updated data in the task title.");
			ngDriver.waitForAngularRequestsToFinish();

			// click on the assign to field
			click("task_assigntotxt_CSS");
			System.out.println("Clicked on the assign to field.");
			ngDriver.waitForAngularRequestsToFinish();

			// enter the user name in the search field
			type("workflowsecurity_editortask_taskdetails_searchtasktagtxt_CSS", data.get("search_user_update"));
			System.out.println("Entered the user name in the search field.");
			ngDriver.waitForAngularRequestsToFinish();

			// click on the searched result
			click("task_permission_task_updateselectusertxt_XPATH");
			System.out.println("Clicked on the searched result.");
			ngDriver.waitForAngularRequestsToFinish();

			// click on the assign to field
			click("task_assigntotxt_CSS");
			System.out.println("Clicked on the assign to field.");
			ngDriver.waitForAngularRequestsToFinish();

			// click on the update button
			click("survey_task_updatebtn_CSS");
			System.out.println("Clicked on the update button.");
			ngDriver.waitForAngularRequestsToFinish();

			// wait for the element
			explicitWaitClickable("closetoastmsg_CSS");

			// click on the toaster close button
			click("closetoastmsg_CSS");
			ngDriver.waitForAngularRequestsToFinish();
			System.out.println("Clicked on the toaster close button.");

			// click on the back button
			driver.findElement(By.xpath("//button[@ng-click='cancelTaskInput(false); resetTaskInputDetails();']"))
					.click();
			ngDriver.waitForAngularRequestsToFinish();
			System.out.println("Clicked on the back button.");

			// scroll up the screen
			js.executeScript("window.scrollBy(0,-500)");

			// click on the clear button
			click("task_createdtask_clearbtn_XPATH");
			ngDriver.waitForAngularRequestsToFinish();
			System.out.println("Clicked on the clear button.");

			// enter the data in the search field
			type("task_filter_CSS", data.get("update_task_title_rolelevel"));
			System.out.println("Entered the data in the search field.");
			ngDriver.waitForAngularRequestsToFinish();

			// click on the search button
			click("task_createdtask_searchbtn_XPATH");
			ngDriver.waitForAngularRequestsToFinish();
			System.out.println("Clicked on the search button.");

			// verify updated task is displayed or not
			try {
				String str210 = (driver
						.findElement(
								By.xpath("//p[contains(text(),'Update Test Task Permission Three Title Rolelevel')]"))
						.getText()).trim();
				ngDriver.waitForAngularRequestsToFinish();
				if (str210.equals("Update Test Task Permission Three Title Rolelevel")) {

					System.out
							.println("The Update Test Task Permission Three Title Rolelevel is verified successfully.");
					test.log(LogStatus.INFO,
							"The Update Test Task Permission Three Title Rolelevel is verified successfully.");
					Reporter.log("The Update Test Task Permission Three Title Rolelevel is verified successfully.");
					log.info("The Update Test Task Permission Three Title Rolelevel is verified successfully.");
				} else {
					verificationFailed();
				}
			} catch (Throwable t) {
				verificationFailed();
			}

			// wait for the 5 seconds
			Thread.sleep(5000);

			// click on the newly created task
			driver.findElement(By.xpath("//p[contains(text(),'Update Test Task Permission Three Title Rolelevel')]"))
					.click();
			System.out.println("Click on the newly created task.");
			ngDriver.waitForAngularRequestsToFinish();

			// compare the default displayed user and role, newly added user, and updated
			// user in assigned to field
			try {
				boolean str19 = driver.findElement(By.xpath("//span[text()='Jinesh QA']")).isDisplayed();
				boolean str20 = driver.findElement(By.xpath("//span[text()='Contractor']")).isDisplayed();
				boolean str21 = driver.findElement(By.xpath("//span[text()='Jinesh QA 2']")).isDisplayed();
				boolean str22 = driver.findElement(By.xpath("//span[text()='Human Resources']")).isDisplayed();
				boolean str23 = driver.findElement(By.xpath("//span[text()='Jinesh']")).isDisplayed();
				boolean str24 = driver.findElement(By.xpath("//span[text()='Jinesh Sample One']")).isDisplayed();

				if (str19 && str20 && str21 && str22 && str23 && str24) {
					System.out.println(
							"The default user and role, newly added user, and updated user is displayed successfully.");
					test.log(LogStatus.INFO,
							"The default user and role, newly added user, and updated user is displayed successfully.");
					Reporter.log(
							"The default user and role, newly added user, and updated user is displayed successfully.");
					log.info(
							"The default user and role, newly added user, and updated user is displayed successfully.");
				} else {
					TestUtil.captureScreenshot();

					// ReportNG
					Reporter.log(
							"<br>" + "The default user and role, newly added user, or updated user is not displayed : "
									+ "<br>");
					Reporter.log("<a target=\"_blank\" href=" + TestUtil.screenshotName + "><img src="
							+ TestUtil.screenshotName + " height=200 width=200></img></a>");
					Reporter.log("<br>");
					Reporter.log("<br>");

					// Extent Report
					test.log(LogStatus.FAIL,
							" The default user and role, newly added user, or updated user is not displayed : ");
					test.log(LogStatus.FAIL, test.addScreenCapture(TestUtil.screenshotName));

					System.out
							.println("The default user and role, newly added user, or updated user is not displayed.");
					log.info("The default user and role, newly added user, or updated user is not displayed.");
				}

			} catch (Throwable t) {
				TestUtil.captureScreenshot();

				// ReportNG
				Reporter.log("<br>" + "The default user and role, newly added user, or updated user is not displayed : "
						+ "<br>");
				Reporter.log("<a target=\"_blank\" href=" + TestUtil.screenshotName + "><img src="
						+ TestUtil.screenshotName + " height=200 width=200></img></a>");
				Reporter.log("<br>");
				Reporter.log("<br>");

				// Extent Report
				test.log(LogStatus.FAIL,
						" The default user and role, newly added user, or updated user is not displayed : ");
				test.log(LogStatus.FAIL, test.addScreenCapture(TestUtil.screenshotName));

				System.out.println("The default user and role, newly added user, or updated user is not displayed.");
				log.info("The default user and role, newly added user, or updated user is not displayed.");
			}

			// DELETE THE TASK

			System.out.println("***************** DELETE THE TASK *****************");
			test.log(LogStatus.INFO, "***************** DELETE THE TASK *****************");
			Reporter.log("***************** DELETE THE TASK *****************");
			log.info("***************** DELETE THE TASK *****************");

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

			// scroll up the screen
			js.executeScript("window.scrollBy(0,-500)");

			// click on the clear button
			click("task_createdtask_clearbtn_XPATH");
			ngDriver.waitForAngularRequestsToFinish();
			System.out.println("Clicked on the clear button.");

			// enter the data in the search field
			type("task_filter_CSS", data.get("update_task_title_rolelevel"));
			System.out.println("Entered the data in the search field.");
			ngDriver.waitForAngularRequestsToFinish();

			// click on the search button
			click("task_createdtask_searchbtn_XPATH");
			ngDriver.waitForAngularRequestsToFinish();
			System.out.println("Clicked on the search button.");

			// verify the task deleted or not
			helper.deleteVerification("task_permission_taskpermission_updatedtask3_rolelevel_XPATH",
					"Update Test Task Permission Three Title Rolelevel");

			try {

				String deleteElement = driver
						.findElement(
								By.xpath("//p[contains(text(),'Update Test Task Permission Three Title Rolelevel')]"))
						.getText();

				if (deleteElement.equals("Update Test Task Permission Three Title Rolelevel")) {

					Assert.assertTrue(
							isElementPresent(By.xpath(
									"//p[contains(text(),'Update Test Task Permission Three Title Rolelevel')]")),
							"The Update Test Task Permission Three Title Rolelevel is displayed.");

					TestUtil.captureScreenshot();

					// ReportNG
					Reporter.log("<br>" + "The  Update Test Task Permission Three Title Rolelevel is not deleted : "
							+ "<br>");
					Reporter.log("<a target=\"_blank\" href=" + TestUtil.screenshotName + "><img src="
							+ TestUtil.screenshotName + " height=200 width=200></img></a>");
					Reporter.log("<br>");
					Reporter.log("<br>");

					// Extent Report
					test.log(LogStatus.FAIL,
							" The Update Test Task Permission Three Title Rolelevel is not deleted : ");
					test.log(LogStatus.FAIL, test.addScreenCapture(TestUtil.screenshotName));

					System.out.println("The Update Test Task Permission Three Title Rolelevel is not deleted.");
					log.info("The Update Test Task Permission Three Title Rolelevel is not deleted.");

				}
			} catch (Throwable t) {
				System.out.println("The Update Test Task Permission Three Title Rolelevel is deleted successfully.");
				test.log(LogStatus.INFO,
						"The Update Test Task Permission Three Title Rolelevel is deleted successfully.");
				Reporter.log("The Update Test Task Permission Three Title Rolelevel is deleted successfully.");
				log.info("The Update Test Task Permission Three Title Rolelevel is deleted successfully.");
			}

			// click on the home icon from the top of the screen
			click("questionnaire_homeburgermenubtn_hide_CSS");
			System.out.println("Clicked on the home icon from the top of the screen.");
			ngDriver.waitForAngularRequestsToFinish();

			// synchronization
			explicitWait("propertylist_title_XPATH");

			// verify the property list
			switchVerification("propertylist_title_XPATH", "Property List", "The property list is not displayed.");

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

			// LOGIN WITH ADMIN USER

			helper.loginAndUpdateSystemCompany(data, "username_1", "password_1", "system_company_1");

		} catch (Throwable t) {
			helper.questionnaireNotDisplayLogout(data);
		}

		// RESET DEFAULT USERS AND ROLES IN THE SECURITY SETTINGS AND ROLE LEVEL
		System.out.println(
				"*************************** RESET DEFAULT USERS AND ROLES IN THE SECURITY SETTINGS AND ROLE LEVEL ***************************");
		test.log(LogStatus.INFO,
				"*************************** RESET DEFAULT USERS AND ROLES IN THE SECURITY SETTINGS AND ROLE LEVEL ***************************");
		Reporter.log(
				"*************************** RESET DEFAULT USERS AND ROLES IN THE SECURITY SETTINGS AND ROLE LEVEL ***************************");
		log.info(
				"*************************** RESET DEFAULT USERS AND ROLES IN THE SECURITY SETTINGS AND ROLE LEVEL ***************************");

		try {
			// wait for element
			explicitWaitClickable("questionnaire_settingicon_userupdate_CSS");

			// click on the settings icon
			click("questionnaire_settingicon_userupdate_CSS");
			ngDriver.waitForAngularRequestsToFinish();
			System.out.println("Clicked on he settings icon.");

			// wait for element
			explicitWaitClickable("questionnaire_administrationoption_XPATH");

			// click on the Administration option from the side menu
			click("questionnaire_administrationoption_XPATH");
			System.out.println("Clicked on the Administration option from the side menu.");
			ngDriver.waitForAngularRequestsToFinish();

			// click on the Security tab
			click("questionnaire_securitytab_XPATH");
			System.out.println("Clicked on the Security tab.");
			ngDriver.waitForAngularRequestsToFinish();

			// click on the Security Settings option
			click("ssc_securitytab_securitysettingsoption_XPATH");
			ngDriver.waitForAngularRequestsToFinish();
			System.out.println("Clicked on the Security Settings option.");

			// enter Default General Task Assignees text in search field
			clear("task_permission_securitysettings_searchtxt1_CSS");
			type("task_permission_securitysettings_searchtxt1_CSS", data.get("search_ss"));
			ngDriver.waitForAngularRequestsToFinish();
			System.out.println("Entered Default General Task Assignees text in search field.");

			// click on the searched result
			driver.findElement(By.xpath("//span[text()='Default general task assignee ']")).click();
			ngDriver.waitForAngularRequestsToFinish();
			System.out.println("Clicked on the searched result.");

			// click on the role field
			click("task_permission_securitysettings_roletxt_CSS");
			ngDriver.waitForAngularRequestsToFinish();
			System.out.println("Clicked on the role field.");

			// click on the none button
			click("task_permission_securitysettings_nonebtn_CSS");
			ngDriver.waitForAngularRequestsToFinish();
			System.out.println("Clicked on the none button.");

			// click on the role field
			click("task_permission_securitysettings_roletxt_CSS");
			ngDriver.waitForAngularRequestsToFinish();
			System.out.println("Clicked on the role field.");

			// click on the user field
			click("task_permission_securitysettings_usertxt_CSS");
			ngDriver.waitForAngularRequestsToFinish();
			System.out.println("Clicked on the user field.");

			// click on the none button
			click("task_permission_securitysettings_nonebtn_CSS");
			ngDriver.waitForAngularRequestsToFinish();
			System.out.println("Clicked on the none button.");

			// click on the role field
			click("task_permission_securitysettings_usertxt_CSS");
			ngDriver.waitForAngularRequestsToFinish();
			System.out.println("Clicked on the user field.");

			// click on the save button
			click("securitysettings_accesssurveychecklist_CSS");
			ngDriver.waitForAngularRequestsToFinish();
			System.out.println("Clicked on the save button.");

			// click on the administration
			click("administration_XPATH");
			ngDriver.waitForAngularRequestsToFinish();
			System.out.println("Clicked on the administration.");

			// click on the Security tab
			click("questionnaire_securitytab_XPATH");
			System.out.println("Clicked on the Security tab.");
			ngDriver.waitForAngularRequestsToFinish();

			// click on the roles option
			click("ssc_securitytab_rolesoption_XPATH");
			ngDriver.waitForAngularRequestsToFinish();
			System.out.println("Clicked on the roles option.");

			// scroll down the screen
			JavascriptExecutor js = (JavascriptExecutor) driver;
			js.executeScript("window.scrollBy(0,200)");

			// collect all the roles

			try {
				String pages = driver.findElement(By.cssSelector("strong")).getText();
				String[] arrOfStr = pages.split(" ");
				String pageno = arrOfStr[3];
				int pagecount = Integer.parseInt(pageno);

				for (int i = 0; i < pagecount; i++) {

					List<WebElement> roles = driver.findElements(By.xpath("//tr//div"));
					int rolesnum = roles.size();

					for (int j = 0; j < rolesnum; j++) {

						WebElement rolestext = roles.get(j);
						String getrole = rolestext.getText();

						if (getrole.equalsIgnoreCase("Contractor")) {

							// click on the Contractor role
							click("task_permission_roles_XPATH");
							ngDriver.waitForAngularRequestsToFinish();
							System.out.println("Clicked on the Contractor role.");
							break;
						}
					}

					// click on the next button
					click("task_permission_roles_nextbtn_CSS");
					ngDriver.waitForAngularRequestsToFinish();
					System.out.println("Clicked on the next button.");

				}
			} catch (Throwable t) {
				System.out.println("Successfully navigate to the Role Details screen.");
				test.log(LogStatus.INFO, "Successfully navigate to the Role Details screen.");
				Reporter.log("Successfully navigate to the Role Details screen.");
				log.info("Successfully navigate to the Role Details screen.");
			}

			// scroll down the screen
			js.executeScript("window.scrollBy(0,600)");

			// click on the Allow Task Assignment to Roles field
			click("task_permission_rolelevel_role1_CSS");
			ngDriver.waitForAngularRequestsToFinish();
			System.out.println("Clicked on the Allow Task Assignment to Roles field.");

			// click on the none button
			click("task_permission_securitysettings_nonebtn_CSS");
			ngDriver.waitForAngularRequestsToFinish();
			System.out.println("Clicked on the none button.");

			// click on the Allow Task Assignment to Roles field
			click("task_permission_rolelevel_role1_CSS");
			ngDriver.waitForAngularRequestsToFinish();
			System.out.println("Clicked on the Allow Task Assignment to Roles field.");

			// click on the Default User Task Assignees field
			click("task_permission_rolelevel_user2_CSS");
			ngDriver.waitForAngularRequestsToFinish();
			System.out.println("Clicked on the Default User Task Assignees field.");

			// click on the none button
			click("task_permission_securitysettings_nonebtn_CSS");
			ngDriver.waitForAngularRequestsToFinish();
			System.out.println("Clicked on the none button.");

			// click on the Default User Task Assignees field
			click("task_permission_rolelevel_user2_CSS");
			ngDriver.waitForAngularRequestsToFinish();
			System.out.println("Clicked on the Default User Task Assignees field.");

			// click on the Default Role Task Assignees field
			click("task_permission_rolelevel_role3_CSS");
			ngDriver.waitForAngularRequestsToFinish();
			System.out.println("Clicked on the Default Role Task Assignees field.");

			// click on the none button
			click("task_permission_securitysettings_nonebtn_CSS");
			ngDriver.waitForAngularRequestsToFinish();
			System.out.println("Clicked on the none button.");

			// click on the Default Role Task Assignees field
			click("task_permission_rolelevel_role3_CSS");
			ngDriver.waitForAngularRequestsToFinish();
			System.out.println("Clicked on the Default Role Task Assignees field.");

			// click on the Default Tags For Adhoc Task field
			click("task_permission_rolelevel_adhog4_CSS");
			ngDriver.waitForAngularRequestsToFinish();
			System.out.println("Clicked on the Default Tags For Adhoc Task field.");

			// click on the none button
			click("task_permission_securitysettings_nonebtn_CSS");
			ngDriver.waitForAngularRequestsToFinish();
			System.out.println("Clicked on the none button.");

			// click on the Default Tags For Adhoc Task field
			click("task_permission_rolelevel_adhog4_CSS");
			ngDriver.waitForAngularRequestsToFinish();
			System.out.println("Clicked on the Default Tags For Adhoc Task field.");

			// click on the save role button
			click("task_permission_roles_saverolebtn_CSS");
			ngDriver.waitForAngularRequestsToFinish();
			System.out.println("Clicked on the save role button.");

		} catch (Throwable t) {
			verificationFailed();
		}

		// click on the home icon
		click("questionnaire_homeburgermenubtn_CSS");
		ngDriver.waitForAngularRequestsToFinish();
		System.out.println("Clicked on the home icon.");

		// synchronization
		explicitWait("propertylist_title_XPATH");

		// verify the property list
		switchVerification("propertylist_title_XPATH", "Property List", "The property list is not displayed.");

	}
}
