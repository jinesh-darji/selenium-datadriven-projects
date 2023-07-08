package testcases.E2Etestcasesuite.taskmodule;

import java.io.IOException;
import java.util.Hashtable;
import java.util.List;

import org.apache.commons.lang3.RandomStringUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.testng.Reporter;
import org.testng.SkipException;
import org.testng.annotations.Test;

import com.relevantcodes.extentreports.LogStatus;

import base.Helper;
import base.TestBase;
import utilities.TestUtil;

public class RR4787TaskTwoTest extends TestBase {

	@Test(dataProviderClass = TestUtil.class, dataProvider = "dp")
	public void rR4787TaskTwoTest(Hashtable<String, String> data) throws IOException, InterruptedException {

		execution(data, "rR4787TaskTwoTest");

		// CREATE TASK > WITH A TASK TYPE > ADD DEFAULT TASK ASSIGNEE + ADD ROLES/USERS
		// FROM TASK TYPE > 1. CANNOT REMOVE ROLES/USERS MARKED TO BE PRESERVED 2. CAN
		// ADD NEW USER/ROLES 3. CAN REMOVE OTHER TASK ASSIGNEES.

		System.out.println(
				"CREATE TASK > WITH A TASK TYPE > ADD DEFAULT TASK ASSIGNEE + ADD ROLES/USERS FROM TASK TYPE > 1. CANNOT REMOVE ROLES/USERS MARKED TO BE PRESERVED 2. CAN ADD NEW USER/ROLES 3. CAN REMOVE OTHER TASK ASSIGNEES.");
		test.log(LogStatus.INFO,
				"CREATE TASK > WITH A TASK TYPE > ADD DEFAULT TASK ASSIGNEE + ADD ROLES/USERS FROM TASK TYPE > 1. CANNOT REMOVE ROLES/USERS MARKED TO BE PRESERVED 2. CAN ADD NEW USER/ROLES 3. CAN REMOVE OTHER TASK ASSIGNEES.");
		Reporter.log(
				"CREATE TASK > WITH A TASK TYPE > ADD DEFAULT TASK ASSIGNEE + ADD ROLES/USERS FROM TASK TYPE > 1. CANNOT REMOVE ROLES/USERS MARKED TO BE PRESERVED 2. CAN ADD NEW USER/ROLES 3. CAN REMOVE OTHER TASK ASSIGNEES.");
		log.info(
				"CREATE TASK > WITH A TASK TYPE > ADD DEFAULT TASK ASSIGNEE + ADD ROLES/USERS FROM TASK TYPE > 1. CANNOT REMOVE ROLES/USERS MARKED TO BE PRESERVED 2. CAN ADD NEW USER/ROLES 3. CAN REMOVE OTHER TASK ASSIGNEES.");

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

		// ADD NEW TASK TYPE - WITH PRESERVE

		System.out.println("***************** ADD NEW TASK TYPE - WITH PRESERVE *****************");
		test.log(LogStatus.INFO, "***************** ADD NEW TASK TYPE - WITH PRESERVE *****************");
		Reporter.log("***************** ADD NEW TASK TYPE - WITH PRESERVE *****************");
		log.info("***************** ADD NEW TASK TYPE - WITH PRESERVE *****************");

		try {

			// wait for the element
			Thread.sleep(7000);

			// click on the side menu button
			click("menubtn_CSS");
			ngDriver.waitForAngularRequestsToFinish();
			System.out.println("Clicked on the side menu button.");

			// wait for the element
			Thread.sleep(7000);

			// click on the task option
			click("sidemenu_task_CSS");
			ngDriver.waitForAngularRequestsToFinish();
			System.out.println("Clicked on the task option.");

			// verify dashboard drop down is displayed or not
			switchVerification("ssc_sustainability_dashboardtxt_XPATH", "Dashboard",
					"The Dashboard Drop down is not displayed.");

			// synchronization
			explicitWaitClickable("task_permission_tasktype_dashboarddd_CSS");

			// select the task type from the dashboard drop down
			select("task_permission_tasktype_dashboarddd_CSS", data.get("dashboard_tasktype"));
			ngDriver.waitForAngularRequestsToFinish();
			System.out.println("Selected the task type from the dashboard drop down.");

			// wait for the element
			explicitWaitClickable("task_permission_tasktype_addbtn_CSS");

			// click on the add button
			click("task_permission_tasktype_addbtn_CSS");
			ngDriver.waitForAngularRequestsToFinish();
			System.out.println("Clicked on the add button.");

			// enter the task type
			type("task_permission_tasktype_tasktypetxt_CSS", data.get("task_title"));
			ngDriver.waitForAngularRequestsToFinish();
			System.out.println("Entered the task type.");

			// scroll down the screen
			JavascriptExecutor js = (JavascriptExecutor) driver;
			js.executeScript("window.scrollBy(0,500)");

			// click on the assign to field
			click("task_permission_tasktype_assigntotxt_CSS");
			ngDriver.waitForAngularRequestsToFinish();
			System.out.println("Clicked on the assign to field.");

			// click on the none button
			click("task_tasktag_nonebtn_CSS");
			ngDriver.waitForAngularRequestsToFinish();
			System.out.println("Clicked on the none button.");

			// enter the user name in the search field
			clear("task_tasktag_searchtxt_CSS");
			type("task_tasktag_searchtxt_CSS", data.get("task_type_user"));
			ngDriver.waitForAngularRequestsToFinish();
			System.out.println("Entered the user name in the search field.");

			// click on the searched user
			click("task_permission_tasktype_searcheduser_XPATH");
			ngDriver.waitForAngularRequestsToFinish();
			System.out.println("Clicked on the searched user.");

			// enter the role in the search field
			clear("task_tasktag_searchtxt_CSS");
			type("task_tasktag_searchtxt_CSS", data.get("task_type_role"));
			ngDriver.waitForAngularRequestsToFinish();
			System.out.println("Entered the role in the search field.");

			// click on the searched role
			click("task_permission_tasktype_searchedrole_XPATH");
			ngDriver.waitForAngularRequestsToFinish();
			System.out.println("Clicked on the searched role.");

			// click on the assign to field
			click("task_permission_tasktype_assigntotxt_CSS");
			ngDriver.waitForAngularRequestsToFinish();
			System.out.println("Clicked on the assign to field.");

			// select the prevent user/role checklist
			boolean preventckb = driver.findElement(By.cssSelector("input[name='preserveUserAndRoles']")).isSelected();

			if (preventckb != true) {

				// click on the prevent user/role checkbox
				click("task_permission_tasktype_preventckb_CSS");
				ngDriver.waitForAngularRequestsToFinish();
				System.out.println("Clicked on the prevent user/role  checkbox.");
				test.log(LogStatus.INFO, "Clicked on the prevent user/role  checkbox.");
				Reporter.log("Clicked on the prevent user/role  checkbox.");
				log.info("Clicked on the prevent user/role  checkbox.");

			} else {
				System.out.println("The prevent user/role  checkbox is displayed already selected.");
				test.log(LogStatus.INFO, "The prevent user/role  checkbox is displayed already selected.");
				Reporter.log("The prevent user/role  checkbox is displayed already selected.");
				log.info("The prevent user/role  checkbox is displayed already selected.");
			}

			// select the value from the recurrence type drop down
			select("task_permission_tasktype_recurrencetypedd_CSS", data.get("recurrence_type"));
			ngDriver.waitForAngularRequestsToFinish();
			System.out.println("Selected the value from the recurrence type drop down.");

			// select the value from the module drop down
			select("task_permission_tasktype_moduledd_CSS", data.get("task_module"));
			ngDriver.waitForAngularRequestsToFinish();
			System.out.println("Selected the value from the module drop down.");

			// wait for the element
			Thread.sleep(5000);

			// click on the save button
			click("task_permission_tasktype_savebtn_CSS");
			ngDriver.waitForAngularRequestsToFinish();
			System.out.println("Clicked on the save button.");

			// enter the newly created task type
			clear("users_filtertxt_CSS");
			type("users_filtertxt_CSS", data.get("task_title"));
			ngDriver.waitForAngularRequestsToFinish();
			System.out.println("Entered the newly created task type.");

			// verify newly created task type is displayed or not
			switchVerification("task_permission_addedtasktype1_XPATH", "Automation Permission 4 Task Type",
					"The Automation Permission 4 Task Type is not displayed.");

		} catch (Throwable t) {
			verificationFailed();
		}

		// click on the home icon
		click("questionnaire_homeburgermenubtn_hide_CSS");
		ngDriver.waitForAngularRequestsToFinish();
		System.out.println("Clicked on the home icon.");

		// synchronization
		explicitWait("propertylist_title_XPATH");

		// verify the property list
		switchVerification("propertylist_title_XPATH", "Property List", "The property list is not displayed.");

		// ADD NEW TASK TYPE - WITH PRESERVE - ROLELEVEL

		System.out.println("***************** ADD NEW TASK TYPE - WITH PRESERVE - ROLELEVEL *****************");
		test.log(LogStatus.INFO, "***************** ADD NEW TASK TYPE - WITH PRESERVE - ROLELEVEL *****************");
		Reporter.log("***************** ADD NEW TASK TYPE - WITH PRESERVE - ROLELEVEL *****************");
		log.info("***************** ADD NEW TASK TYPE - WITH PRESERVE - ROLELEVEL *****************");

		try {

			// wait for the element
			Thread.sleep(5000);

			// click on the side menu button
			click("menubtn_CSS");
			ngDriver.waitForAngularRequestsToFinish();
			System.out.println("Clicked on the side menu button.");

			// wait for the element
			Thread.sleep(5000);

			// click on the task option
			click("sidemenu_task_CSS");
			ngDriver.waitForAngularRequestsToFinish();
			System.out.println("Clicked on the task option.");

			// verify dashboard drop down is displayed or not
			switchVerification("ssc_sustainability_dashboardtxt_XPATH", "Dashboard",
					"The Dashboard Drop down is not displayed.");

			// synchronization
			explicitWaitClickable("task_permission_tasktype_dashboarddd_CSS");

			// select the task type from the dashboard drop down
			select("task_permission_tasktype_dashboarddd_CSS", data.get("dashboard_tasktype"));
			ngDriver.waitForAngularRequestsToFinish();
			System.out.println("Selected the task type from the dashboard drop down.");

			// wait for the element
			explicitWaitClickable("task_permission_tasktype_addbtn_CSS");

			// click on the add button
			click("task_permission_tasktype_addbtn_CSS");
			ngDriver.waitForAngularRequestsToFinish();
			System.out.println("Clicked on the add button.");

			// enter the task type
			type("task_permission_tasktype_tasktypetxt_CSS", data.get("task_title_rolelevel"));
			ngDriver.waitForAngularRequestsToFinish();
			System.out.println("Entered the task type.");

			// scroll down the screen
			JavascriptExecutor js = (JavascriptExecutor) driver;
			js.executeScript("window.scrollBy(0,500)");

			// click on the assign to field
			click("task_permission_tasktype_assigntotxt_CSS");
			ngDriver.waitForAngularRequestsToFinish();
			System.out.println("Clicked on the assign to field.");

			// click on the none button
			click("task_tasktag_nonebtn_CSS");
			ngDriver.waitForAngularRequestsToFinish();
			System.out.println("Clicked on the none button.");

			// enter the user name in the search field
			clear("task_tasktag_searchtxt_CSS");
			type("task_tasktag_searchtxt_CSS", data.get("task_type_user"));
			ngDriver.waitForAngularRequestsToFinish();
			System.out.println("Entered the user name in the search field.");

			// click on the searched user
			click("task_permission_tasktype_searcheduser_XPATH");
			ngDriver.waitForAngularRequestsToFinish();
			System.out.println("Clicked on the searched user.");

			// enter the role in the search field
			clear("task_tasktag_searchtxt_CSS");
			type("task_tasktag_searchtxt_CSS", data.get("task_type_role"));
			ngDriver.waitForAngularRequestsToFinish();
			System.out.println("Entered the role in the search field.");

			// click on the searched role
			click("task_permission_tasktype_searchedrole_XPATH");
			ngDriver.waitForAngularRequestsToFinish();
			System.out.println("Clicked on the searched role.");

			// click on the assign to field
			click("task_permission_tasktype_assigntotxt_CSS");
			ngDriver.waitForAngularRequestsToFinish();
			System.out.println("Clicked on the assign to field.");

			// select the prevent user/role checklist
			boolean preventckb = driver.findElement(By.cssSelector("input[name='preserveUserAndRoles']")).isSelected();

			if (preventckb != true) {

				// click on the prevent user/role checkbox
				click("task_permission_tasktype_preventckb_CSS");
				ngDriver.waitForAngularRequestsToFinish();
				System.out.println("Clicked on the prevent user/role  checkbox.");
				test.log(LogStatus.INFO, "Clicked on the prevent user/role  checkbox.");
				Reporter.log("Clicked on the prevent user/role  checkbox.");
				log.info("Clicked on the prevent user/role  checkbox.");

			} else {
				System.out.println("The prevent user/role  checkbox is displayed already selected.");
				test.log(LogStatus.INFO, "The prevent user/role  checkbox is displayed already selected.");
				Reporter.log("The prevent user/role  checkbox is displayed already selected.");
				log.info("The prevent user/role  checkbox is displayed already selected.");
			}

			// select the value from the recurrence type drop down
			select("task_permission_tasktype_recurrencetypedd_CSS", data.get("recurrence_type"));
			ngDriver.waitForAngularRequestsToFinish();
			System.out.println("Selected the value from the recurrence type drop down.");

			// select the value from the module drop down
			select("task_permission_tasktype_moduledd_CSS", data.get("task_module"));
			ngDriver.waitForAngularRequestsToFinish();
			System.out.println("Selected the value from the module drop down.");

			// wait for the element
			Thread.sleep(5000);

			// click on the save button
			click("task_permission_tasktype_savebtn_CSS");
			ngDriver.waitForAngularRequestsToFinish();
			System.out.println("Clicked on the save button.");

			// enter the newly created task type
			clear("users_filtertxt_CSS");
			type("users_filtertxt_CSS", data.get("task_title_rolelevel"));
			ngDriver.waitForAngularRequestsToFinish();
			System.out.println("Entered the newly created task type.");

			// verify newly created task type is displayed or not
			switchVerification("task_permission_addedtasktype1_rolelevel_XPATH",
					"Automation Permission 4 Task Type Rolelevel",
					"The Automation Permission 4 Task Type Rolelevel is not displayed.");

		} catch (Throwable t) {
			verificationFailed();
		}

		// click on the home icon
		click("questionnaire_homeburgermenubtn_hide_CSS");
		ngDriver.waitForAngularRequestsToFinish();
		System.out.println("Clicked on the home icon.");

		// synchronization
		explicitWait("propertylist_title_XPATH");

		// verify the property list
		switchVerification("propertylist_title_XPATH", "Property List", "The property list is not displayed.");

		// SECURITY SETTINGS LEVEL VERIFICATION

		System.out.println("***************** SECURITY SETTINGS LEVEL VERIFICATION *****************");
		test.log(LogStatus.INFO, "***************** SECURITY SETTINGS LEVEL VERIFICATION *****************");
		Reporter.log("***************** SECURITY SETTINGS LEVEL VERIFICATION *****************");
		log.info("***************** SECURITY SETTINGS LEVEL VERIFICATION *****************");

		try {
			// click on the task icon
			click("taskicon_CSS");
			System.out.println("Clicked on the task icon.");
			ngDriver.waitForAngularRequestsToFinish();

			// click on the add task button
			click("task_addtaskbtn_CSS");
			System.out.println("Clicked on the add task button.");
			ngDriver.waitForAngularRequestsToFinish();

			// verify the default user/role in assigned to field
			try {
				boolean str1 = driver.findElement(By.xpath("(//span[text()='Jinesh QA'])[1]")).isDisplayed();
				boolean str2 = driver.findElement(By.xpath("(//span[text()='Contractor'])[1]")).isDisplayed();

				if ((str1 && str2) == true) {
					System.out.println("The default user/role is displayed successfully.");
					test.log(LogStatus.INFO, "The default user/role is displayed successfully.");
					Reporter.log("The default user/role is displayed successfully.");
					log.info("The default user/role is displayed successfully.");
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

			// click on the task type field
			click("task_permission_task_tasktypetxt_CSS");
			ngDriver.waitForAngularRequestsToFinish();
			System.out.println("Clicked on the task type field.");

			// enter the newly created task type
			clear("task_tasktag_searchtxt_CSS");
			type("task_tasktag_searchtxt_CSS", data.get("task_title"));
			ngDriver.waitForAngularRequestsToFinish();
			System.out.println("Entered the newly created task type.");

			// click on the searched task type
			click("task_permission_task_createdtasktype_XPATH");
			ngDriver.waitForAngularRequestsToFinish();
			System.out.println("Clicked on the searched task type.");

			// verify the default user/role, and preserved user/role in
			// assigned to field
			try {
				boolean str3 = driver.findElement(By.xpath("(//span[text()='Jinesh QA'])[1]")).isDisplayed();
				boolean str4 = driver.findElement(By.xpath("(//span[text()='Contractor'])[1]")).isDisplayed();
				boolean str5 = driver.findElement(By.xpath("(//span[text()='Jinesh Misc'])[1]")).isDisplayed();
				boolean str6 = driver.findElement(By.xpath("(//span[text()='Operations'])[1]")).isDisplayed();

				if ((str3 && str4 && str5 && str6) == true) {
					System.out.println("The default user/role, and preserved user/role are displayed successfully.");
					test.log(LogStatus.INFO,
							"The default user/role, and preserved user/role are displayed successfully.");
					Reporter.log("The default user/role, and preserved user/role are displayed successfully.");
					log.info("The default user/role, and preserved user/role are displayed successfully.");
				} else {
					TestUtil.captureScreenshot();

					// ReportNG
					Reporter.log(
							"<br>" + "The default user/role, and preserved user/role is not displayed : " + "<br>");
					Reporter.log("<a target=\"_blank\" href=" + TestUtil.screenshotName + "><img src="
							+ TestUtil.screenshotName + " height=200 width=200></img></a>");
					Reporter.log("<br>");
					Reporter.log("<br>");

					// Extent Report
					test.log(LogStatus.FAIL, " The default user/role, and preserved user/role is not displayed : ");
					test.log(LogStatus.FAIL, test.addScreenCapture(TestUtil.screenshotName));

					System.out.println("The default user/role, and preserved user/role is not displayed.");
					log.info("The default user or role is not displayed.");
				}

			} catch (Throwable t) {
				TestUtil.captureScreenshot();

				// ReportNG
				Reporter.log("<br>" + "The default user/role, and preserved user/role is not displayed : " + "<br>");
				Reporter.log("<a target=\"_blank\" href=" + TestUtil.screenshotName + "><img src="
						+ TestUtil.screenshotName + " height=200 width=200></img></a>");
				Reporter.log("<br>");
				Reporter.log("<br>");

				// Extent Report
				test.log(LogStatus.FAIL, " The default user/role, and preserved user/role is not displayed : ");
				test.log(LogStatus.FAIL, test.addScreenCapture(TestUtil.screenshotName));

				System.out.println("The default user/role, and preserved user/role is not displayed.");
				log.info("The default user/role, and preserved user/role is not displayed.");
			}

			// ADD THE USER IN THE ASSIGN TO FIELD

			System.out.println("***************** ADD THE USER IN THE ASSIGN TO FIELD *****************");
			test.log(LogStatus.INFO, "***************** ADD THE USER IN THE ASSIGN TO FIELD *****************");
			Reporter.log("***************** ADD THE USER IN THE ASSIGN TO FIELD *****************");
			log.info("***************** ADD THE USER IN THE ASSIGN TO FIELD *****************");

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

			// verify the default user/role, updated user and preserved user/role in
			// assigned to field
			try {
				boolean str7 = driver.findElement(By.xpath("(//span[text()='Jinesh QA'])[1]")).isDisplayed();
				boolean str8 = driver.findElement(By.xpath("(//span[text()='Contractor'])[1]")).isDisplayed();
				boolean str9 = driver.findElement(By.xpath("(//span[text()='Jinesh Misc'])[1]")).isDisplayed();
				boolean str10 = driver.findElement(By.xpath("(//span[text()='Operations'])[1]")).isDisplayed();
				boolean str11 = driver.findElement(By.xpath("(//span[text()='Jinesh'])[1]")).isDisplayed();

				if ((str7 && str8 && str9 && str10 && str11) == true) {
					System.out.println(
							"The default user/role, updated user and preserved user/role are displayed successfully.");
					test.log(LogStatus.INFO,
							"The default user/role, updated user and preserved user/role are displayed successfully.");
					Reporter.log(
							"The default user/role, updated user and preserved user/role are displayed successfully.");
					log.info("The default user/role, updated user and preserved user/role are displayed successfully.");
				} else {
					TestUtil.captureScreenshot();

					// ReportNG
					Reporter.log(
							"<br>" + "The default user/role, updated user and preserved user/role is not displayed : "
									+ "<br>");
					Reporter.log("<a target=\"_blank\" href=" + TestUtil.screenshotName + "><img src="
							+ TestUtil.screenshotName + " height=200 width=200></img></a>");
					Reporter.log("<br>");
					Reporter.log("<br>");

					// Extent Report
					test.log(LogStatus.FAIL,
							" The default user/role, updated user and preserved user/role is not displayed : ");
					test.log(LogStatus.FAIL, test.addScreenCapture(TestUtil.screenshotName));

					System.out.println("The default user/role, updated user and preserved user/role is not displayed.");
					log.info("The default user/role, updated user and preserved user/role is not displayed.");
				}

			} catch (Throwable t) {
				TestUtil.captureScreenshot();

				// ReportNG
				Reporter.log("<br>" + "The default user/role, updated user and preserved user/role is not displayed : "
						+ "<br>");
				Reporter.log("<a target=\"_blank\" href=" + TestUtil.screenshotName + "><img src="
						+ TestUtil.screenshotName + " height=200 width=200></img></a>");
				Reporter.log("<br>");
				Reporter.log("<br>");

				// Extent Report
				test.log(LogStatus.FAIL,
						" The default user/role, updated user and preserved user/role is not displayed : ");
				test.log(LogStatus.FAIL, test.addScreenCapture(TestUtil.screenshotName));

				System.out.println("The default user/role, updated user and preserved user/role is not displayed.");
				log.info("The default user/role, updated user and preserved user/role is not displayed.");
			}

			// UNSELECT THE PRESERVED USER/ROLE

			System.out.println("***************** UNSELECT THE PRESERVED USER/ROLE *****************");
			test.log(LogStatus.INFO, "***************** UNSELECT THE PRESERVED USER/ROLE *****************");
			Reporter.log("***************** UNSELECT THE PRESERVED USER/ROLE *****************");
			log.info("***************** UNSELECT THE PRESERVED USER/ROLE *****************");

			// click on the assigned to field
			click("task_assigntotxt_CSS");
			System.out.println("Clicked on the assign to field.");
			ngDriver.waitForAngularRequestsToFinish();

			// enter the user name in the search field
			clear("workflowsecurity_editortask_taskdetails_searchtasktagtxt_CSS");
			type("workflowsecurity_editortask_taskdetails_searchtasktagtxt_CSS", data.get("task_type_user"));
			System.out.println("Entered the user name in the search field.");
			ngDriver.waitForAngularRequestsToFinish();

			// click on the searched result
			click("task_permission_tasktype_searcheduser_XPATH");
			System.out.println("Clicked on the searched result.");
			ngDriver.waitForAngularRequestsToFinish();

			// click on the assign to field
			click("task_assigntotxt_CSS");
			System.out.println("Clicked on the assign to field.");
			ngDriver.waitForAngularRequestsToFinish();

			// wait for the 5 seconds
			Thread.sleep(5000);

			// click on the save button
			click("survey_task_savebtn_CSS");
			System.out.println("Clicked on the save button.");
			ngDriver.waitForAngularRequestsToFinish();

			// wait for the 5 seconds
			Thread.sleep(5000);

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

			// verify preserved user/role is displayed or not
			try {
				boolean str12 = driver
						.findElement(By.xpath("//p[text()='" + data.get("task_title")
								+ "']//parent::td//following-sibling::td[contains(text(),'Jinesh Misc')]"))
						.isDisplayed();

				if (str12 == true) {

					System.out.println("The preserved user/role is displayed successfully.");
					test.log(LogStatus.INFO, "The preserved user/role is displayed successfully.");
					Reporter.log("The preserved user/role is displayed successfully.");
					log.info("The preserved user/role is displayed successfully.");

				} else {

					TestUtil.captureScreenshot();

					// ReportNG
					Reporter.log("<br>" + "The preserved user/role is not displayed : " + "<br>");
					Reporter.log("<a target=\"_blank\" href=" + TestUtil.screenshotName + "><img src="
							+ TestUtil.screenshotName + " height=200 width=200></img></a>");
					Reporter.log("<br>");
					Reporter.log("<br>");

					// Extent Report
					test.log(LogStatus.FAIL, " The preserved user/role is not displayed : ");
					test.log(LogStatus.FAIL, test.addScreenCapture(TestUtil.screenshotName));

					System.out.println("The The preserved user/role is not displayed.");
					log.info("The preserved user/role is not displayed.");

				}

			} catch (Throwable t) {
				TestUtil.captureScreenshot();

				// ReportNG
				Reporter.log("<br>" + "The preserved user/role is not displayed : " + "<br>");
				Reporter.log("<a target=\"_blank\" href=" + TestUtil.screenshotName + "><img src="
						+ TestUtil.screenshotName + " height=200 width=200></img></a>");
				Reporter.log("<br>");
				Reporter.log("<br>");

				// Extent Report
				test.log(LogStatus.FAIL, " The preserved user/role is not displayed : ");
				test.log(LogStatus.FAIL, test.addScreenCapture(TestUtil.screenshotName));

				System.out.println("The The preserved user/role is not displayed.");
				log.info("The preserved user/role is not displayed.");
			}

			// click on the newly created task
			driver.findElement(By.xpath("//p[contains(text(),'Automation Permission 4 Task Type')]")).click();
			System.out.println("Clicked on the newly created task.");
			ngDriver.waitForAngularRequestsToFinish();

			// click on the assign to field
			click("task_assigntotxt_CSS");
			System.out.println("Clicked on the assign to field.");
			ngDriver.waitForAngularRequestsToFinish();

			// enter the role in the search field
			clear("workflowsecurity_editortask_taskdetails_searchtasktagtxt_CSS");
			type("workflowsecurity_editortask_taskdetails_searchtasktagtxt_CSS", data.get("task_type_role"));
			System.out.println("Entered the role in the search field.");
			ngDriver.waitForAngularRequestsToFinish();

			// click on the searched result
			click("task_permission_tasktype_searchedrole_XPATH");
			System.out.println("Clicked on the searched result.");
			ngDriver.waitForAngularRequestsToFinish();

			// click on the assign to field
			click("task_assigntotxt_CSS");
			System.out.println("Clicked on the assign to field.");
			ngDriver.waitForAngularRequestsToFinish();

			// wait for the element
			Thread.sleep(5000);

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

			// wait for the element
			Thread.sleep(5000);

			// verify preserved user/role is displayed or not
			try {
				boolean str13 = driver.findElement(By.xpath(
						"//p[text()='Automation Permission 4 Task Type']//parent::td//following-sibling::td[contains(text(),'Operations')]"))
						.isDisplayed();

				if (str13 == true) {

					System.out.println("The preserved user/role is displayed successfully.");
					test.log(LogStatus.INFO, "The preserved user/role is displayed successfully.");
					Reporter.log("The preserved user/role is displayed successfully.");
					log.info("The preserved user/role is displayed successfully.");

				} else {

					TestUtil.captureScreenshot();

					// ReportNG
					Reporter.log("<br>" + "The preserved user/role is not displayed : " + "<br>");
					Reporter.log("<a target=\"_blank\" href=" + TestUtil.screenshotName + "><img src="
							+ TestUtil.screenshotName + " height=200 width=200></img></a>");
					Reporter.log("<br>");
					Reporter.log("<br>");

					// Extent Report
					test.log(LogStatus.FAIL, " The preserved user/role is not displayed : ");
					test.log(LogStatus.FAIL, test.addScreenCapture(TestUtil.screenshotName));

					System.out.println("The The preserved user/role is not displayed.");
					log.info("The preserved user/role is not displayed.");

				}

			} catch (Throwable t) {
				TestUtil.captureScreenshot();

				// ReportNG
				Reporter.log("<br>" + "The preserved user/role is not displayed : " + "<br>");
				Reporter.log("<a target=\"_blank\" href=" + TestUtil.screenshotName + "><img src="
						+ TestUtil.screenshotName + " height=200 width=200></img></a>");
				Reporter.log("<br>");
				Reporter.log("<br>");

				// Extent Report
				test.log(LogStatus.FAIL, " The preserved user/role is not displayed : ");
				test.log(LogStatus.FAIL, test.addScreenCapture(TestUtil.screenshotName));

				System.out.println("The The preserved user/role is not displayed.");
				log.info("The preserved user/role is not displayed.");
			}

			// UPDATE THE TASK

			System.out.println("***************** UPDATE THE TASK *****************");
			test.log(LogStatus.INFO, "***************** UPDATE THE TASK *****************");
			Reporter.log("***************** UPDATE THE TASK *****************");
			log.info("***************** UPDATE THE TASK *****************");

			// click on the newly created task
			driver.findElement(By.xpath("//p[contains(text(),'Automation Permission 4 Task Type')]")).click();
			System.out.println("Clicked on the newly created task.");
			ngDriver.waitForAngularRequestsToFinish();

			// verify the default user/role and preserved user/role in assigned to
			// field
			try {
				boolean str14 = driver.findElement(By.xpath("(//span[text()='Jinesh QA'])[1]")).isDisplayed();
				boolean str15 = driver.findElement(By.xpath("(//span[text()='Contractor'])[1]")).isDisplayed();
				boolean str16 = driver.findElement(By.xpath("(//span[text()='Jinesh Misc'])[1]")).isDisplayed();
				boolean str17 = driver.findElement(By.xpath("(//span[text()='Operations'])[1]")).isDisplayed();
				boolean str18 = driver.findElement(By.xpath("(//span[text()='Jinesh'])[1]")).isDisplayed();

				System.out.println(str14 + " " + str15 + " " + str16 + " " + str17 + " " + str18);

				if ((str14 && str15 && str16 && str17 && str18) == true) {
					System.out.println("The default user/role and preserved user/role is displayed successfully.");
					test.log(LogStatus.INFO,
							"The default user/role and preserved user/role is displayed successfully.");
					Reporter.log("The default user/role and preserved user/role is displayed successfully.");
					log.info("The default user/role and preserved user/role is displayed successfully.");
				} else {
					TestUtil.captureScreenshot();

					// ReportNG
					Reporter.log("<br>" + "The default user or role is not displayed : " + "<br>");
					Reporter.log("<a target=\"_blank\" href=" + TestUtil.screenshotName + "><img src="
							+ TestUtil.screenshotName + " height=200 width=200></img></a>");
					Reporter.log("<br>");
					Reporter.log("<br>");

					// Extent Report
					test.log(LogStatus.FAIL, " The default user/role and preserved user/role is not displayed : ");
					test.log(LogStatus.FAIL, test.addScreenCapture(TestUtil.screenshotName));

					System.out.println("The default user/role and preserved user/role is not displayed.");
					log.info("The default user/role and preserved user/role is not displayed.");
				}

			} catch (Throwable t) {
				TestUtil.captureScreenshot();

				// ReportNG
				Reporter.log("<br>" + "The default user/role and preserved user/role is not displayed : " + "<br>");
				Reporter.log("<a target=\"_blank\" href=" + TestUtil.screenshotName + "><img src="
						+ TestUtil.screenshotName + " height=200 width=200></img></a>");
				Reporter.log("<br>");
				Reporter.log("<br>");

				// Extent Report
				test.log(LogStatus.FAIL, " The default user/role and preserved user/role is not displayed : ");
				test.log(LogStatus.FAIL, test.addScreenCapture(TestUtil.screenshotName));

				System.out.println("The default user/role and preserved user/role is not displayed.");
				log.info("The default user/role and preserved user/role is not displayed.");
			}

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

			// wait for the element
			Thread.sleep(3000);

			// click on the assign to field
			click("task_assigntotxt_CSS");
			System.out.println("Clicked on the assign to field.");
			ngDriver.waitForAngularRequestsToFinish();

			// verify the default user/role, newly added users and preserved user/role in
			// assigned to field
			try {
				boolean str19 = driver.findElement(By.xpath("(//span[text()='Jinesh QA'])[1]")).isDisplayed();
				boolean str20 = driver.findElement(By.xpath("(//span[text()='Contractor'])[1]")).isDisplayed();
				boolean str21 = driver.findElement(By.xpath("(//span[text()='Jinesh Misc'])[1]")).isDisplayed();
				boolean str22 = driver.findElement(By.xpath("(//span[text()='Operations'])[1]")).isDisplayed();
				boolean str23 = driver.findElement(By.xpath("(//span[text()='Jinesh'])[1]")).isDisplayed();
				boolean str24 = driver.findElement(By.xpath("(//span[text()='Jinesh Sample One'])[1]")).isDisplayed();

				System.out.println(str19 + " " + str20 + " " + str21 + " " + str22 + " " + str23 + " " + str24);

				if ((str19 && str20 && str21 && str22 && str23 && str24) == true) {
					System.out.println(
							"The default user/role, newly added users and preserved user/role is displayed successfully.");
					test.log(LogStatus.INFO,
							"The default user/role, newly added users and preserved user/role is displayed successfully.");
					Reporter.log(
							"The default user/role, newly added users and preserved user/role is displayed successfully.");
					log.info(
							"The default user/role, newly added users and preserved user/role is displayed successfully.");
				} else {
					TestUtil.captureScreenshot();

					// ReportNG
					Reporter.log("<br>"
							+ "The default user/role, newly added users and preserved user/rolee is not displayed : "
							+ "<br>");
					Reporter.log("<a target=\"_blank\" href=" + TestUtil.screenshotName + "><img src="
							+ TestUtil.screenshotName + " height=200 width=200></img></a>");
					Reporter.log("<br>");
					Reporter.log("<br>");

					// Extent Report
					test.log(LogStatus.FAIL,
							" The ddefault user/role, newly added users and preserved user/role is not displayed : ");
					test.log(LogStatus.FAIL, test.addScreenCapture(TestUtil.screenshotName));

					System.out.println(
							"The default user/role, newly added users and preserved user/role is not displayed.");
					log.info("The default user/role, newly added users and preserved user/role is not displayed.");
				}

			} catch (Throwable t) {
				TestUtil.captureScreenshot();

				// ReportNG
				Reporter.log(
						"<br>" + "The default user/role, newly added users and preserved user/role is not displayed : "
								+ "<br>");
				Reporter.log("<a target=\"_blank\" href=" + TestUtil.screenshotName + "><img src="
						+ TestUtil.screenshotName + " height=200 width=200></img></a>");
				Reporter.log("<br>");
				Reporter.log("<br>");

				// Extent Report
				test.log(LogStatus.FAIL,
						" The default user/role, newly added users and preserved user/role is not displayed : ");
				test.log(LogStatus.FAIL, test.addScreenCapture(TestUtil.screenshotName));

				System.out
						.println("The default user/role, newly added users and preserved user/role is not displayed.");
				log.info("The default user/role, newly added users and preserved user/role is not displayed.");
			}

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

			// UNSELECT THE DEFAULT ADDED USER/ROLE AND NEWLY ADDED USER

			System.out.println(
					"***************** UNSELECT THE DEFAULT ADDED USER/ROLE AND NEWLY ADDED USER *****************");
			test.log(LogStatus.INFO,
					"***************** UNSELECT THE DEFAULT ADDED USER/ROLE AND NEWLY ADDED USER *****************");
			Reporter.log(
					"***************** UNSELECT THE DEFAULT ADDED USER/ROLE AND NEWLY ADDED USER *****************");
			log.info("***************** UNSELECT THE DEFAULT ADDED USER/ROLE AND NEWLY ADDED USER *****************");

			// scroll up the screen
			JavascriptExecutor js = (JavascriptExecutor) driver;
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

			// click on the newly created task
			click("task_permission_addedtasktype_XPATH");
			ngDriver.waitForAngularRequestsToFinish();
			System.out.println("Clicked on the newly created task.");

			// click on the assign to field
			click("task_assigntotxt_CSS");
			System.out.println("Clicked on the assign to field.");
			ngDriver.waitForAngularRequestsToFinish();

			// enter the user name in the search field
			clear("workflowsecurity_editortask_taskdetails_searchtasktagtxt_CSS");
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

			// enter the default role in the search field
			clear("workflowsecurity_editortask_taskdetails_searchtasktagtxt_CSS");
			type("workflowsecurity_editortask_taskdetails_searchtasktagtxt_CSS", data.get("role_ss"));
			System.out.println("Entered the default role in the search field.");
			ngDriver.waitForAngularRequestsToFinish();

			// click on the searched result
			click("task_permission_task_defaultrole_XPATH");
			System.out.println("Clicked on the searched result.");
			ngDriver.waitForAngularRequestsToFinish();

			// click on the assign to field
			click("task_assigntotxt_CSS");
			System.out.println("Clicked on the assign to field.");
			ngDriver.waitForAngularRequestsToFinish();

			// enter the default user in the search field
			clear("workflowsecurity_editortask_taskdetails_searchtasktagtxt_CSS");
			type("workflowsecurity_editortask_taskdetails_searchtasktagtxt_CSS", data.get("user_ss"));
			System.out.println("Entered the default user in the search field.");
			ngDriver.waitForAngularRequestsToFinish();

			// click on the searched result
			click("task_permission_task_defaultuser_XPATH");
			System.out.println("Clicked on the searched result.");
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

			// click on the updated task
			click("task_permission_addedtasktype_XPATH");
			System.out.println("Click on the newly created task.");
			ngDriver.waitForAngularRequestsToFinish();

			// verify the preserved user/role and updated user in assigned to field
			try {
				boolean str27 = driver.findElement(By.xpath("(//span[text()='Jinesh Misc'])[1]")).isDisplayed();
				boolean str28 = driver.findElement(By.xpath("(//span[text()='Operations'])[1]")).isDisplayed();
				boolean str29 = driver.findElement(By.xpath("(//span[text()='Jinesh Sample One'])[1]")).isDisplayed();

				if ((str27 && str28 && str29) == true) {
					System.out.println("The preserved user/role and updated user is displayed successfully.");
					test.log(LogStatus.INFO, "The preserved user/role and updated user is displayed successfully.");
					Reporter.log("The preserved user/role and updated user is displayed successfully.");
					log.info("The preserved user/role and updated user is displayed successfully.");
				} else {
					TestUtil.captureScreenshot();

					// ReportNG
					Reporter.log("<br>" + "The preserved user/role and updated user is not displayed : " + "<br>");
					Reporter.log("<a target=\"_blank\" href=" + TestUtil.screenshotName + "><img src="
							+ TestUtil.screenshotName + " height=200 width=200></img></a>");
					Reporter.log("<br>");
					Reporter.log("<br>");

					// Extent Report
					test.log(LogStatus.FAIL, " The preserved user/role and updated user is not displayed : ");
					test.log(LogStatus.FAIL, test.addScreenCapture(TestUtil.screenshotName));

					System.out.println("The preserved user/role and updated user is not displayed.");
					log.info("The preserved user/role and updated user is not displayed.");
				}

			} catch (Throwable t) {
				TestUtil.captureScreenshot();

				// ReportNG
				Reporter.log("<br>" + "The preserved user/role and updated user is not displayed : " + "<br>");
				Reporter.log("<a target=\"_blank\" href=" + TestUtil.screenshotName + "><img src="
						+ TestUtil.screenshotName + " height=200 width=200></img></a>");
				Reporter.log("<br>");
				Reporter.log("<br>");

				// Extent Report
				test.log(LogStatus.FAIL, " The preserved user/role and updated user is not displayed : ");
				test.log(LogStatus.FAIL, test.addScreenCapture(TestUtil.screenshotName));

				System.out.println("The preserved user/role and updated user is not displayed.");
				log.info("The preserved user/role and updated user is not displayed.");
			}

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

		} catch (Throwable t) {
			verificationFailed();
		}

		// DELETE THE TASK

		System.out.println("***************** DELETE THE TASK *****************");
		test.log(LogStatus.INFO, "***************** DELETE THE TASK *****************");
		Reporter.log("***************** DELETE THE TASK *****************");
		log.info("***************** DELETE THE TASK *****************");

		try {

			// click on the updated task
			click("task_permission_addedtasktype_XPATH");
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

			// scroll up the screen
			JavascriptExecutor js = (JavascriptExecutor) driver;
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

			// verify the task deleted or not
			try {

				String deleteElement = (driver
						.findElement(By.xpath("//p[contains(text(),'Automation Permission 4 Task Type')]")).getText())
								.trim();

				if (deleteElement.equals("Automation Permission 4 Task Type")) {

					TestUtil.captureScreenshot();

					// ReportNG
					Reporter.log("<br>" + "The  Automation Permission 4 Task Type is not deleted : " + "<br>");
					Reporter.log("<a target=\"_blank\" href=" + TestUtil.screenshotName + "><img src="
							+ TestUtil.screenshotName + " height=200 width=200></img></a>");
					Reporter.log("<br>");
					Reporter.log("<br>");

					// Extent Report
					test.log(LogStatus.FAIL, " The Automation Permission 4 Task Type is not deleted : ");
					test.log(LogStatus.FAIL, test.addScreenCapture(TestUtil.screenshotName));

					System.out.println("The Automation Permission 4 Task Type is not deleted.");
					log.info("The Automation Permission 4 Task Type is not deleted.");

				}
			} catch (Throwable t) {
				System.out.println("The Automation Permission 4 Task Type is deleted successfully.");
				test.log(LogStatus.INFO, "The Automation Permission 4 Task Type is deleted successfully.");
				Reporter.log("The Automation Permission 4 Task Type is deleted successfully.");
				log.info("The Automation Permission 4 Task Type is deleted successfully.");
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

			helper.loginAndUpdateSystemCompany(data, "username", "password", "system_company_1");

			// CREATE NEW TASK - CONTRACTOR USER

			System.out.println("***************** CREATE NEW TASK - CONTRACTOR USER *****************");
			test.log(LogStatus.INFO, "***************** CREATE NEW TASK - CONTRACTOR USER *****************");
			Reporter.log("***************** CREATE NEW TASK - CONTRACTOR USER *****************");
			log.info("***************** CREATE NEW TASK - CONTRACTOR USER *****************");

			try {
				// click on the task icon
				click("taskicon_CSS");
				System.out.println("Clicked on the task icon.");
				ngDriver.waitForAngularRequestsToFinish();

				// click on the add task button
				click("task_addtaskbtn_CSS");
				System.out.println("Clicked on the add task button.");
				ngDriver.waitForAngularRequestsToFinish();

				// Verify the default user/role in assigned to field
				try {
					boolean str31 = driver.findElement(By.xpath("(//span[text()='Jinesh QA'])[1]")).isDisplayed();
					boolean str32 = driver.findElement(By.xpath("(//span[text()='Contractor'])[1]")).isDisplayed();
					boolean str33 = driver.findElement(By.xpath("(//span[text()='Jinesh QA 2'])[1]")).isDisplayed();
					boolean str34 = driver.findElement(By.xpath("(//span[text()='Human Resources'])[1]")).isDisplayed();

					if ((str31 && str32 && str33 && str34) == true) {
						System.out.println("The default user/role is displayed successfully.");
						test.log(LogStatus.INFO, "The default user/role is displayed successfully.");
						Reporter.log("The default user/role is displayed successfully.");
						log.info("The default user/role is displayed successfully.");
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

				// click on the task type field
				click("task_permission_task_tasktypetxt_CSS");
				ngDriver.waitForAngularRequestsToFinish();
				System.out.println("Clicked on the task type field.");

				// enter the newly created task type
				clear("task_tasktag_searchtxt_CSS");
				type("task_tasktag_searchtxt_CSS", data.get("task_title_rolelevel"));
				ngDriver.waitForAngularRequestsToFinish();
				System.out.println("Entered the newly created task type.");

				// click on the searched task type
				click("task_permission_task_createdtasktype_rolelevel_XPATH");
				ngDriver.waitForAngularRequestsToFinish();
				System.out.println("Clicked on the searched task type.");

				// verified the default user/role, and preserved user/role in
				// assigned to field
				try {
					boolean str35 = driver.findElement(By.xpath("(//span[text()='Jinesh QA'])[1]")).isDisplayed();
					boolean str36 = driver.findElement(By.xpath("(//span[text()='Contractor'])[1]")).isDisplayed();
					boolean str37 = driver.findElement(By.xpath("(//span[text()='Jinesh QA 2'])[1]")).isDisplayed();
					boolean str38 = driver.findElement(By.xpath("(//span[text()='Human Resources'])[1]")).isDisplayed();
					boolean str39 = driver.findElement(By.xpath("(//span[text()='Jinesh Misc'])[1]")).isDisplayed();
					boolean str40 = driver.findElement(By.xpath("(//span[text()='Operations'])[1]")).isDisplayed();

					if ((str35 && str36 && str37 && str38 && str39 && str40) == true) {
						System.out
								.println("The default user/role, and preserved user/role are displayed successfully.");
						test.log(LogStatus.INFO,
								"The default user/role, and preserved user/role are displayed successfully.");
						Reporter.log("The default user/role, and preserved user/role are displayed successfully.");
						log.info("The default user/role, and preserved user/role are displayed successfully.");
					} else {
						TestUtil.captureScreenshot();

						// ReportNG
						Reporter.log(
								"<br>" + "The default user/role, and preserved user/role is not displayed : " + "<br>");
						Reporter.log("<a target=\"_blank\" href=" + TestUtil.screenshotName + "><img src="
								+ TestUtil.screenshotName + " height=200 width=200></img></a>");
						Reporter.log("<br>");
						Reporter.log("<br>");

						// Extent Report
						test.log(LogStatus.FAIL, " The default user/role, and preserved user/role is not displayed : ");
						test.log(LogStatus.FAIL, test.addScreenCapture(TestUtil.screenshotName));

						System.out.println("The default user/role, and preserved user/role is not displayed.");
						log.info("The default user or role is not displayed.");
					}

				} catch (Throwable t) {
					TestUtil.captureScreenshot();

					// ReportNG
					Reporter.log(
							"<br>" + "The default user/role, and preserved user/role is not displayed : " + "<br>");
					Reporter.log("<a target=\"_blank\" href=" + TestUtil.screenshotName + "><img src="
							+ TestUtil.screenshotName + " height=200 width=200></img></a>");
					Reporter.log("<br>");
					Reporter.log("<br>");

					// Extent Report
					test.log(LogStatus.FAIL, " The default user/role, and preserved user/role is not displayed : ");
					test.log(LogStatus.FAIL, test.addScreenCapture(TestUtil.screenshotName));

					System.out.println("The default user/role, and preserved user/role is not displayed.");
					log.info("The default user/role, and preserved user/role is not displayed.");
				}

				// add the user in the assign to field

				System.out.println("***************** ADD THE USER IN THE ASSIGN TO FIELD *****************");
				test.log(LogStatus.INFO, "***************** ADD THE USER IN THE ASSIGN TO FIELD *****************");
				Reporter.log("***************** ADD THE USER IN THE ASSIGN TO FIELD *****************");
				log.info("***************** ADD THE USER IN THE ASSIGN TO FIELD *****************");

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

				// verify the default user/role, updated user and preserved user/role in
				// assigned to field
				try {
					boolean str41 = driver.findElement(By.xpath("(//span[text()='Jinesh QA'])[1]")).isDisplayed();
					boolean str42 = driver.findElement(By.xpath("(//span[text()='Contractor'])[1]")).isDisplayed();
					boolean str43 = driver.findElement(By.xpath("(//span[text()='Jinesh QA 2'])[1]")).isDisplayed();
					boolean str44 = driver.findElement(By.xpath("(//span[text()='Human Resources'])[1]")).isDisplayed();
					boolean str45 = driver.findElement(By.xpath("(//span[text()='Jinesh Misc'])[1]")).isDisplayed();
					boolean str46 = driver.findElement(By.xpath("(//span[text()='Operations'])[1]")).isDisplayed();
					boolean str47 = driver.findElement(By.xpath("(//span[text()='Jinesh'])[1]")).isDisplayed();

					if ((str41 && str42 && str43 && str44 && str45 && str46 && str47) == true) {
						System.out.println(
								"The default user/role, updated user and preserved user/role are displayed successfully.");
						test.log(LogStatus.INFO,
								"The default user/role, updated user and preserved user/role are displayed successfully.");
						Reporter.log(
								"The default user/role, updated user and preserved user/role are displayed successfully.");
						log.info(
								"The default user/role, updated user and preserved user/role are displayed successfully.");
					} else {
						TestUtil.captureScreenshot();

						// ReportNG
						Reporter.log("<br>"
								+ "The default user/role, updated user and preserved user/role is not displayed : "
								+ "<br>");
						Reporter.log("<a target=\"_blank\" href=" + TestUtil.screenshotName + "><img src="
								+ TestUtil.screenshotName + " height=200 width=200></img></a>");
						Reporter.log("<br>");
						Reporter.log("<br>");

						// Extent Report
						test.log(LogStatus.FAIL,
								" The default user/role, updated user and preserved user/role is not displayed : ");
						test.log(LogStatus.FAIL, test.addScreenCapture(TestUtil.screenshotName));

						System.out.println(
								"The default user/role, updated user and preserved user/role is not displayed.");
						log.info("The default user/role, updated user and preserved user/role is not displayed.");
					}

				} catch (Throwable t) {
					TestUtil.captureScreenshot();

					// ReportNG
					Reporter.log(
							"<br>" + "The default user/role, updated user and preserved user/role is not displayed : "
									+ "<br>");
					Reporter.log("<a target=\"_blank\" href=" + TestUtil.screenshotName + "><img src="
							+ TestUtil.screenshotName + " height=200 width=200></img></a>");
					Reporter.log("<br>");
					Reporter.log("<br>");

					// Extent Report
					test.log(LogStatus.FAIL,
							" The default user/role, updated user and preserved user/role is not displayed : ");
					test.log(LogStatus.FAIL, test.addScreenCapture(TestUtil.screenshotName));

					System.out.println("The default user/role, updated user and preserved user/role is not displayed.");
					log.info("The default user/role, updated user and preserved user/role is not displayed.");
				}

				// click on the save button
				click("survey_task_savebtn_CSS");
				System.out.println("Clicked on the save button.");
				ngDriver.waitForAngularRequestsToFinish();

				// wait for the 5 seconds
				Thread.sleep(5000);

			} catch (Throwable t) {
				verificationFailed();
			}

			// UNSELECT THE PRESERVED user/role

			System.out.println("***************** UNSELECT THE PRESERVED user/role *****************");
			test.log(LogStatus.INFO, "***************** UNSELECT THE PRESERVED user/role *****************");
			Reporter.log("***************** UNSELECT THE PRESERVED user/role *****************");
			log.info("***************** UNSELECT THE PRESERVED user/role *****************");

			try {
				// click on the newly created task
				click("task_permission_addedtasktype_rolelevel_XPATH");
				ngDriver.waitForAngularRequestsToFinish();
				System.out.println("Clicked on the newly created task.");

				// click on the assigned to field
				click("task_assigntotxt_CSS");
				System.out.println("Clicked on the assign to field.");
				ngDriver.waitForAngularRequestsToFinish();

				// enter the user name in the search field
				clear("workflowsecurity_editortask_taskdetails_searchtasktagtxt_CSS");
				type("workflowsecurity_editortask_taskdetails_searchtasktagtxt_CSS", data.get("task_type_user"));
				System.out.println("Entered the user name in the search field.");
				ngDriver.waitForAngularRequestsToFinish();

				// click on the searched result
				click("task_permission_tasktype_searcheduser_XPATH");
				System.out.println("Clicked on the searched result.");
				ngDriver.waitForAngularRequestsToFinish();

				// click on the assign to field
				click("task_assigntotxt_CSS");
				System.out.println("Clicked on the assign to field.");
				ngDriver.waitForAngularRequestsToFinish();

				// wait for the element
				Thread.sleep(5000);

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

				// wait for the 5 seconds
				Thread.sleep(5000);

				try {
					boolean str48 = driver.findElement(By.xpath(
							"//p[text()='Automation Permission 4 Task Type Rolelevel']//parent::td//following-sibling::td[contains(text(),'Jinesh Misc')]"))
							.isDisplayed();

					if (str48 == true) {

						System.out.println("The preserved user/role is displayed as expected.");
						test.log(LogStatus.INFO, "The preserved user/role is displayed as expected.");
						Reporter.log("The preserved user/role is displayed as expected.");
						log.info("The preserved user/role is displayed as expected.");

					} else {

						TestUtil.captureScreenshot();

						// ReportNG
						Reporter.log("<br>" + "The preserved user/role is not displayed : " + "<br>");
						Reporter.log("<a target=\"_blank\" href=" + TestUtil.screenshotName + "><img src="
								+ TestUtil.screenshotName + " height=200 width=200></img></a>");
						Reporter.log("<br>");
						Reporter.log("<br>");

						// Extent Report
						test.log(LogStatus.FAIL, " The preserved user/role is not displayed : ");
						test.log(LogStatus.FAIL, test.addScreenCapture(TestUtil.screenshotName));

						System.out.println("The The preserved user/role is not displayed.");
						log.info("The preserved user/role is not displayed.");

					}

				} catch (Throwable t) {
					TestUtil.captureScreenshot();

					// ReportNG
					Reporter.log("<br>" + "The preserved user/role is not displayed : " + "<br>");
					Reporter.log("<a target=\"_blank\" href=" + TestUtil.screenshotName + "><img src="
							+ TestUtil.screenshotName + " height=200 width=200></img></a>");
					Reporter.log("<br>");
					Reporter.log("<br>");

					// Extent Report
					test.log(LogStatus.FAIL, " The preserved user/role is not displayed : ");
					test.log(LogStatus.FAIL, test.addScreenCapture(TestUtil.screenshotName));

					System.out.println("The The preserved user/role is not displayed.");
					log.info("The preserved user/role is not displayed.");
				}

				// click on the newly created task
				click("task_permission_addedtasktype_rolelevel_XPATH");
				ngDriver.waitForAngularRequestsToFinish();
				System.out.println("Clicked on the newly created task.");

				// click on the assign to field
				click("task_assigntotxt_CSS");
				System.out.println("Clicked on the assign to field.");
				ngDriver.waitForAngularRequestsToFinish();

				// enter the role in the search field
				clear("workflowsecurity_editortask_taskdetails_searchtasktagtxt_CSS");
				type("workflowsecurity_editortask_taskdetails_searchtasktagtxt_CSS", data.get("task_type_role"));
				System.out.println("Entered the role in the search field.");
				ngDriver.waitForAngularRequestsToFinish();

				// click on the searched result
				click("task_permission_tasktype_searchedrole_XPATH");
				System.out.println("Clicked on the searched result.");
				ngDriver.waitForAngularRequestsToFinish();

				// click on the assign to field
				click("task_assigntotxt_CSS");
				System.out.println("Clicked on the assign to field.");
				ngDriver.waitForAngularRequestsToFinish();

				// wait for the element
				Thread.sleep(5000);

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

				// verify preserved user/role is displayed or not
				try {
					boolean str49 = driver.findElement(By.xpath(
							"//p[text()='Automation Permission 4 Task Type Rolelevel']//parent::td//following-sibling::td[contains(text(),'Operations')]"))
							.isDisplayed();

					if (str49 == true) {

						System.out.println("The preserved user/role is displayed as expected.");
						test.log(LogStatus.INFO, "The preserved user/role is displayed as expected.");
						Reporter.log("The preserved user/role is displayed as expected.");
						log.info("The preserved user/role is displayed as expected.");

					} else {

						TestUtil.captureScreenshot();

						// ReportNG
						Reporter.log("<br>" + "The preserved user/role is not displayed : " + "<br>");
						Reporter.log("<a target=\"_blank\" href=" + TestUtil.screenshotName + "><img src="
								+ TestUtil.screenshotName + " height=200 width=200></img></a>");
						Reporter.log("<br>");
						Reporter.log("<br>");

						// Extent Report
						test.log(LogStatus.FAIL, " The preserved user/role is not displayed : ");
						test.log(LogStatus.FAIL, test.addScreenCapture(TestUtil.screenshotName));

						System.out.println("The The preserved user/role is not displayed.");
						log.info("The preserved user/role is not displayed.");

					}

				} catch (Throwable t) {
					TestUtil.captureScreenshot();

					// ReportNG
					Reporter.log("<br>" + "The preserved user/role is not displayed : " + "<br>");
					Reporter.log("<a target=\"_blank\" href=" + TestUtil.screenshotName + "><img src="
							+ TestUtil.screenshotName + " height=200 width=200></img></a>");
					Reporter.log("<br>");
					Reporter.log("<br>");

					// Extent Report
					test.log(LogStatus.FAIL, " The preserved user/role is not displayed : ");
					test.log(LogStatus.FAIL, test.addScreenCapture(TestUtil.screenshotName));

					System.out.println("The The preserved user/role is not displayed.");
					log.info("The preserved user/role is not displayed.");
				}

			} catch (Throwable t) {
				verificationFailed();
			}

			// UPDATE THE TASK

			System.out.println("***************** UPDATE THE TASK *****************");
			test.log(LogStatus.INFO, "***************** UPDATE THE TASK *****************");
			Reporter.log("***************** UPDATE THE TASK *****************");
			log.info("***************** UPDATE THE TASK *****************");

			try {
				// click on the newly created task
				click("task_permission_addedtasktype_rolelevel_XPATH");
				ngDriver.waitForAngularRequestsToFinish();
				System.out.println("Clicked on the newly created task.");

				// verify the default displayed user/role and preserved user/role in assigned to
				// field
				try {
					boolean str50 = driver.findElement(By.xpath("(//span[text()='Jinesh QA'])[1]")).isDisplayed();
					boolean str51 = driver.findElement(By.xpath("(//span[text()='Contractor'])[1]")).isDisplayed();
					boolean str52 = driver.findElement(By.xpath("(//span[text()='Jinesh QA 2'])[1]")).isDisplayed();
					boolean str53 = driver.findElement(By.xpath("(//span[text()='Human Resources'])[1]")).isDisplayed();
					boolean str54 = driver.findElement(By.xpath("(//span[text()='Jinesh Misc'])[1]")).isDisplayed();
					boolean str55 = driver.findElement(By.xpath("(//span[text()='Operations'])[1]")).isDisplayed();
					boolean str56 = driver.findElement(By.xpath("(//span[text()='Jinesh'])[1]")).isDisplayed();

					System.out.println(
							str50 + " " + str51 + " " + str52 + " " + str53 + " " + str54 + " " + str55 + " " + str56);

					if ((str50 && str51 && str52 && str53 && str54 && str55 && str56) == true) {
						System.out.println("The default user/role and preserved user/role is displayed successfully.");
						test.log(LogStatus.INFO,
								"The default user/role and preserved user/role is displayed successfully.");
						Reporter.log("The default user/role and preserved user/role is displayed successfully.");
						log.info("The default user/role and preserved user/role is displayed successfully.");
					} else {
						TestUtil.captureScreenshot();

						// ReportNG
						Reporter.log("<br>" + "The default user or role is not displayed : " + "<br>");
						Reporter.log("<a target=\"_blank\" href=" + TestUtil.screenshotName + "><img src="
								+ TestUtil.screenshotName + " height=200 width=200></img></a>");
						Reporter.log("<br>");
						Reporter.log("<br>");

						// Extent Report
						test.log(LogStatus.FAIL, " The default user/role and preserved user/role is not displayed : ");
						test.log(LogStatus.FAIL, test.addScreenCapture(TestUtil.screenshotName));

						System.out.println("The default user/role and preserved user/role is not displayed.");
						log.info("The default user/role and preserved user/role is not displayed.");
					}

				} catch (Throwable t) {
					TestUtil.captureScreenshot();

					// ReportNG
					Reporter.log("<br>" + "The default user/role and preserved user/role is not displayed : " + "<br>");
					Reporter.log("<a target=\"_blank\" href=" + TestUtil.screenshotName + "><img src="
							+ TestUtil.screenshotName + " height=200 width=200></img></a>");
					Reporter.log("<br>");
					Reporter.log("<br>");

					// Extent Report
					test.log(LogStatus.FAIL, " The default user/role and preserved user/role is not displayed : ");
					test.log(LogStatus.FAIL, test.addScreenCapture(TestUtil.screenshotName));

					System.out.println("The default user/role and preserved user/role is not displayed.");
					log.info("The default user/role and preserved user/role is not displayed.");
				}

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

				// wait for the element
				Thread.sleep(5000);

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

			} catch (Throwable t) {
				verificationFailed();
			}

			// UNSELECT THE DEFAULT ADDED USER/ROLE AND NEWLY ADDED USER

			System.out.println(
					"***************** UNSELECT THE DEFAULT ADDED USER/ROLE AND NEWLY ADDED USER *****************");
			test.log(LogStatus.INFO,
					"***************** UNSELECT THE DEFAULT ADDED USER/ROLE AND NEWLY ADDED USER *****************");
			Reporter.log(
					"***************** UNSELECT THE DEFAULT ADDED USER/ROLE AND NEWLY ADDED USER *****************");
			log.info("***************** UNSELECT THE DEFAULT ADDED USER/ROLE AND NEWLY ADDED USER *****************");

			try {
				// click on the newly created task
				click("task_permission_addedtasktype_rolelevel_XPATH");
				ngDriver.waitForAngularRequestsToFinish();
				System.out.println("Clicked on the newly created task.");

				// click on the assign to field
				click("task_assigntotxt_CSS");
				System.out.println("Clicked on the assign to field.");
				ngDriver.waitForAngularRequestsToFinish();

				// enter the user name in the search field
				clear("workflowsecurity_editortask_taskdetails_searchtasktagtxt_CSS");
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

				// enter the default role in the search field
				clear("workflowsecurity_editortask_taskdetails_searchtasktagtxt_CSS");
				type("workflowsecurity_editortask_taskdetails_searchtasktagtxt_CSS", data.get("role_ss"));
				System.out.println("Entered the default role in the search field.");
				ngDriver.waitForAngularRequestsToFinish();

				// click on the searched result
				click("task_permission_task_defaultrole_XPATH");
				System.out.println("Clicked on the searched result.");
				ngDriver.waitForAngularRequestsToFinish();

				// click on the assign to field
				click("task_assigntotxt_CSS");
				System.out.println("Clicked on the assign to field.");
				ngDriver.waitForAngularRequestsToFinish();

				// enter the default user in the search field
				clear("workflowsecurity_editortask_taskdetails_searchtasktagtxt_CSS");
				type("workflowsecurity_editortask_taskdetails_searchtasktagtxt_CSS", data.get("user_ss"));
				System.out.println("Entered the default user in the search field.");
				ngDriver.waitForAngularRequestsToFinish();

				// click on the searched result
				driver.findElement(By.xpath("(//span[text()='Jinesh QA'])[2]")).click();
				System.out.println("Clicked on the searched result.");
				ngDriver.waitForAngularRequestsToFinish();

				// enter the default user in the search field
				clear("workflowsecurity_editortask_taskdetails_searchtasktagtxt_CSS");
				type("workflowsecurity_editortask_taskdetails_searchtasktagtxt_CSS", data.get("user_rolelevel"));
				System.out.println("Entered the default user in the search field.");
				ngDriver.waitForAngularRequestsToFinish();

				// click on the searched result
				click("task_permission_task_defaultuser_rolelevel_XPATH");
				System.out.println("Clicked on the searched result.");
				ngDriver.waitForAngularRequestsToFinish();

				// click on the assign to field
				click("task_assigntotxt_CSS");
				System.out.println("Clicked on the assign to field.");
				ngDriver.waitForAngularRequestsToFinish();

				// enter the default role in the search field
				clear("workflowsecurity_editortask_taskdetails_searchtasktagtxt_CSS");
				type("workflowsecurity_editortask_taskdetails_searchtasktagtxt_CSS", data.get("role_rolelevel"));
				System.out.println("Entered the default role in the search field.");
				ngDriver.waitForAngularRequestsToFinish();

				// click on the searched result
				click("task_permission_task_defaultrole_rolelevel_XPATH");
				System.out.println("Clicked on the searched result.");
				ngDriver.waitForAngularRequestsToFinish();

				// wait for the element
				Thread.sleep(5000);

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

				// scroll up the screen
				JavascriptExecutor js = (JavascriptExecutor) driver;
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

				// verify updated task is displayed or not
				try {
					String str2 = (driver
							.findElement(
									By.xpath("//p[contains(text(),'Automation Permission 4 Task Type Rolelevel')]"))
							.getText()).trim();
					ngDriver.waitForAngularRequestsToFinish();
					if (str2.equals("Automation Permission 4 Task Type Rolelevel")) {

						System.out.println("The Automation Permission 4 Task Type Rolelevel is verified successfully.");
						test.log(LogStatus.INFO,
								"The Automation Permission 4 Task Type Rolelevel is verified successfully.");
						Reporter.log("The Automation Permission 4 Task Type Rolelevel is verified successfully.");
						log.info("The Automation Permission 4 Task Type Rolelevel is verified successfully.");
					} else {
						verificationFailed();
					}
				} catch (Throwable t) {
					verificationFailed();
				}

				// click on the updated task
				click("task_permission_addedtasktype_rolelevel_XPATH");
				System.out.println("Click on the newly created task.");
				ngDriver.waitForAngularRequestsToFinish();

				// verify the preserved user/role and updated user in assigned to field
				try {
					boolean str67 = driver.findElement(By.xpath("(//span[text()='Jinesh Misc'])[1]")).isDisplayed();
					boolean str68 = driver.findElement(By.xpath("(//span[text()='Operations'])[1]")).isDisplayed();
					boolean str69 = driver.findElement(By.xpath("(//span[text()='Jinesh Sample One'])[1]"))
							.isDisplayed();

					if ((str67 && str68 && str69) == true) {
						System.out.println("The preserved user/role and updated user is displayed successfully.");
						test.log(LogStatus.INFO, "The preserved user/role and updated user is displayed successfully.");
						Reporter.log("The preserved user/role and updated user is displayed successfully.");
						log.info("The preserved user/role and updated user is displayed successfully.");
					} else {
						TestUtil.captureScreenshot();

						// ReportNG
						Reporter.log("<br>" + "The preserved user/role and updated user is not displayed : " + "<br>");
						Reporter.log("<a target=\"_blank\" href=" + TestUtil.screenshotName + "><img src="
								+ TestUtil.screenshotName + " height=200 width=200></img></a>");
						Reporter.log("<br>");
						Reporter.log("<br>");

						// Extent Report
						test.log(LogStatus.FAIL, " The preserved user/role and updated user is not displayed : ");
						test.log(LogStatus.FAIL, test.addScreenCapture(TestUtil.screenshotName));

						System.out.println("The preserved user/role and updated user is not displayed.");
						log.info("The preserved user/role and updated user is not displayed.");
					}

				} catch (Throwable t) {
					TestUtil.captureScreenshot();

					// ReportNG
					Reporter.log("<br>" + "The preserved user/role and updated user is not displayed : " + "<br>");
					Reporter.log("<a target=\"_blank\" href=" + TestUtil.screenshotName + "><img src="
							+ TestUtil.screenshotName + " height=200 width=200></img></a>");
					Reporter.log("<br>");
					Reporter.log("<br>");

					// Extent Report
					test.log(LogStatus.FAIL, " The preserved user/role and updated user is not displayed : ");
					test.log(LogStatus.FAIL, test.addScreenCapture(TestUtil.screenshotName));

					System.out.println("The preserved user/role and updated user is not displayed.");
					log.info("The preserved user/role and updated user is not displayed.");
				}

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

			} catch (Throwable t) {
				verificationFailed();
			}

			// DELETE THE TASK

			System.out.println("***************** DELETE THE TASK *****************");
			test.log(LogStatus.INFO, "***************** DELETE THE TASK *****************");
			Reporter.log("***************** DELETE THE TASK *****************");
			log.info("***************** DELETE THE TASK *****************");

			try {
				// click on the newly created task
				click("task_permission_addedtasktype_rolelevel_XPATH");
				ngDriver.waitForAngularRequestsToFinish();
				System.out.println("Clicked on the newly created task.");

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
				JavascriptExecutor js = (JavascriptExecutor) driver;
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

				// verify the task deleted or not
				try {

					String deleteElement = (driver
							.findElement(
									By.xpath("//p[contains(text(),'Automation Permission 4 Task Type Rolelevel')]"))
							.getText()).trim();

					if (deleteElement.equals("Automation Permission 4 Task Type Rolelevel")) {

						TestUtil.captureScreenshot();

						// ReportNG
						Reporter.log(
								"<br>" + "The  Automation Permission 4 Task Type Rolelevel is not deleted : " + "<br>");
						Reporter.log("<a target=\"_blank\" href=" + TestUtil.screenshotName + "><img src="
								+ TestUtil.screenshotName + " height=200 width=200></img></a>");
						Reporter.log("<br>");
						Reporter.log("<br>");

						// Extent Report
						test.log(LogStatus.FAIL, " The Automation Permission 4 Task Type Rolelevel is not deleted : ");
						test.log(LogStatus.FAIL, test.addScreenCapture(TestUtil.screenshotName));

						System.out.println("The Automation Permission 4 Task Type Rolelevel is not deleted.");
						log.info("The Automation Permission 4 Task Type Rolelevel is not deleted.");

					}
				} catch (Throwable t) {
					System.out.println("The Automation Permission 4 Task Type Rolelevel is deleted successfully.");
					test.log(LogStatus.INFO,
							"The Automation Permission 4 Task Type Rolelevel is deleted successfully.");
					Reporter.log("The Automation Permission 4 Task Type Rolelevel is deleted successfully.");
					log.info("The Automation Permission 4 Task Type Rolelevel is deleted successfully.");
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

			// LOGIN WITH ADMIN USER

			System.out.println("***************** LOGIN WITH ADMIN USER *****************");
			test.log(LogStatus.INFO, "***************** LOGIN WITH ADMIN USER *****************");
			Reporter.log("***************** LOGIN WITH ADMIN USER *****************");
			log.info("***************** LOGIN WITH ADMIN USER *****************");

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

		// RESET THE TASK TYPE - ROLELEVEL

		System.out.println("*************************** RESET THE TASK TYPE - ROLELEVEL ***************************");
		test.log(LogStatus.INFO,
				"*************************** RESET THE TASK TYPE - ROLELEVEL ***************************");
		Reporter.log("*************************** RESET THE TASK TYPE - ROLELEVEL ***************************");
		log.info("*************************** RESET THE TASK TYPE - ROLELEVEL ***************************");

		try {

			// wait for element
			explicitWaitClickable("menubtn_CSS");

			// click on the side menu button
			click("menubtn_CSS");
			ngDriver.waitForAngularRequestsToFinish();
			System.out.println("Clicked on the side menu button.");

			// wait for element
			explicitWaitClickable("sidemenu_task_CSS");

			// click on the task option
			click("sidemenu_task_CSS");
			ngDriver.waitForAngularRequestsToFinish();
			System.out.println("Clicked on the task option.");

			// verify dashboard drop down is displayed or not
			switchVerification("ssc_sustainability_dashboardtxt_XPATH", "Dashboard",
					"The Dashboard Drop down is not displayed.");

			// select the task type from the dashboard drop down
			select("task_permission_tasktype_dashboarddd_CSS", data.get("dashboard_tasktype"));
			ngDriver.waitForAngularRequestsToFinish();
			System.out.println("Selected the task type from the dashboard drop down.");

			// wait for 5 seconds
			Thread.sleep(5000);

			// enter the task type in the search field
			clear("task_permission_tasktype_searchtxt_CSS");
			type("task_permission_tasktype_searchtxt_CSS", data.get("task_title_rolelevel"));
			ngDriver.waitForAngularRequestsToFinish();
			System.out.println("Entered the task type in the search field.");

			// verify newly created task type is displayed or not
			switchVerification("task_permission_addedtasktype1_rolelevel_XPATH",
					"Automation Permission 4 Task Type Rolelevel",
					"The Automation Permission 4 Task Type Rolelevel is not displayed.");

			// click on the newly created task type
			click("task_permission_addedtasktype1_rolelevel_XPATH");
			ngDriver.waitForAngularRequestsToFinish();
			System.out.println("click on the newly created task type.");

			// create the random string
			String s1 = RandomStringUtils.randomAlphabetic(8);

			// enter the task type
			clear("task_permission_tasktype_tasktypetxt_CSS");
			type("task_permission_tasktype_tasktypetxt_CSS", s1);
			ngDriver.waitForAngularRequestsToFinish();
			System.out.println("Entered the task type.");

			// click on the save button
			click("task_permission_tasktype_savebtn_CSS");
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

		// RESET THE TASK TYPE

		System.out.println("*************************** RESET THE TASK TYPE ***************************");
		test.log(LogStatus.INFO, "*************************** RESET THE TASK TYPE ***************************");
		Reporter.log("*************************** RESET THE TASK TYPE ***************************");
		log.info("*************************** RESET THE TASK TYPE ***************************");

		try {

			// wait for element
			Thread.sleep(5000);

			// click on the side menu button
			click("menubtn_CSS");
			ngDriver.waitForAngularRequestsToFinish();
			System.out.println("Clicked on the side menu button.");

			// wait for element
			Thread.sleep(5000);

			// click on the task option
			click("sidemenu_task_CSS");
			ngDriver.waitForAngularRequestsToFinish();
			System.out.println("Clicked on the task option.");

			// verify dashboard drop down is displayed or not
			switchVerification("ssc_sustainability_dashboardtxt_XPATH", "Dashboard",
					"The Dashboard Drop down is not displayed.");

			// select the task type from the dashboard drop down
			select("task_permission_tasktype_dashboarddd_CSS", data.get("dashboard_tasktype"));
			ngDriver.waitForAngularRequestsToFinish();
			System.out.println("Selected the task type from the dashboard drop down.");

			// wait for 5 seconds
			Thread.sleep(5000);

			// scroll down the screen
			JavascriptExecutor js = (JavascriptExecutor) driver;
			js.executeScript("window.scrollBy(0,200)");

			// enter the task type in the search field
			type("task_permission_tasktype_searchtxt_CSS", data.get("task_title"));
			ngDriver.waitForAngularRequestsToFinish();
			System.out.println("Entered the task type in the search field.");

			// verify newly created task type is displayed or not
			switchVerification("task_permission_addedtasktype1_XPATH", "Automation Permission 4 Task Type",
					"The Automation Permission 4 Task Type is not displayed.");

			// click on the newly created task type
			click("task_permission_addedtasktype1_XPATH");
			ngDriver.waitForAngularRequestsToFinish();
			System.out.println("click on the newly created task type.");

			// create the random string
			String s = RandomStringUtils.randomAlphabetic(8);

			// enter the task type
			clear("task_permission_tasktype_tasktypetxt_CSS");
			type("task_permission_tasktype_tasktypetxt_CSS", s);
			ngDriver.waitForAngularRequestsToFinish();
			System.out.println("Entered the task type.");

			// click on the save button
			click("task_permission_tasktype_savebtn_CSS");
			ngDriver.waitForAngularRequestsToFinish();
			System.out.println("Clicked on the save button.");

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
