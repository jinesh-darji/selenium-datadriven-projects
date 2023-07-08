package testcases.E2Etestcasesuite.taskmodule;

import java.io.IOException;
import java.util.Hashtable;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.SkipException;
import org.testng.annotations.Test;

import com.relevantcodes.extentreports.LogStatus;

import base.Helper;
import base.TestBase;
import utilities.TestUtil;

public class RR4505TaskTest extends TestBase {

	@Test(dataProviderClass = TestUtil.class, dataProvider = "dp")
	public void rR4505TaskTest(Hashtable<String, String> data) throws IOException, InterruptedException {

		execution(data, "rR4505TaskTest");

		// VERIFY THE TASK WITH TASK TAG PERMISSION (MODULE NAMES: ENVIRONMENT, DUE DATE
		// EDITOR: USER-JINESH MISC 2 AND ROLE-MAINTENANCE)

		System.out.println(
				"VERIFY THE TASK WITH TASK TAG PERMISSION (MODULE NAMES: ENVIRONMENT, DUE DATE EDITOR: USER-JINESH MISC 2 AND ROLE-MAINTENANCE).");
		test.log(LogStatus.INFO,
				"VERIFY THE TASK WITH TASK TAG PERMISSION (MODULE NAMES: ENVIRONMENT, DUE DATE EDITOR: USER-JINESH MISC 2 AND ROLE-MAINTENANCE).");
		Reporter.log(
				"VERIFY THE TASK WITH TASK TAG PERMISSION (MODULE NAMES: ENVIRONMENT, DUE DATE EDITOR: USER-JINESH MISC 2 AND ROLE-MAINTENANCE).");
		log.info(
				"VERIFY THE TASK WITH TASK TAG PERMISSION (MODULE NAMES: ENVIRONMENT, DUE DATE EDITOR: USER-JINESH MISC 2 AND ROLE-MAINTENANCE).");

		Helper helper = new Helper();

		// refresh the page
		driver.navigate().refresh();
		Thread.sleep(5000);
		driver.navigate().refresh();

		System.out.println("Navigate to the Home Screen i.e. Property List Screen.");

		// RESET THE RESPECTIVE PERMISSIONS

		System.out.println("***************** RESET THE RESPECTIVE PERMISSIONS *****************");
		test.log(LogStatus.INFO, "***************** RESET THE RESPECTIVE PERMISSIONS *****************");
		Reporter.log("***************** RESET THE RESPECTIVE PERMISSIONS *****************");
		log.info("***************** RESET THE RESPECTIVE PERMISSIONS *****************");

		try {

			// wait for element
			Thread.sleep(5000);

			// click on the setting icon
			click("questionnaire_settingicon_CSS");
			System.out.println("Clicked on the setting icon.");
			ngDriver.waitForAngularRequestsToFinish();

			// wait for the element
			explicitWaitClickable("questionnaire_administrationoption_XPATH");

			// click on the Administration option from the side menu
			click("questionnaire_administrationoption_XPATH");
			System.out.println("Clicked on the Administration option from the side menu.");
			ngDriver.waitForAngularRequestsToFinish();

			// click on the security tab
			click("questionnaire_securitytab_XPATH");
			System.out.println("Clicked on the security tab.");
			ngDriver.waitForAngularRequestsToFinish();

			// click on the security settings tab
			click("questionnaire_securotysettingsoption_XPATH");
			System.out.println("Clicked on the security settings tab.");
			ngDriver.waitForAngularRequestsToFinish();

			helper.resetPermission(data, "security_settings_1", "securitysettings_accesstoposection_XPATH");

			helper.resetPermission(data, "security_settings_2", "securitysettings_surveychecklistsection_XPATH");

		} catch (Throwable t) {
			verificationFailed();
		}

		// click on the administration tab
		click("administration_XPATH");
		System.out.println("Clicked on the administration tab.");
		ngDriver.waitForAngularRequestsToFinish();

		// SET THE PERMISSION IN THE AUTOMATION TAG

		System.out.println("***************** SET THE PERMISSION IN THE AUTOMATION TAG *****************");
		test.log(LogStatus.INFO, "***************** SET THE PERMISSION IN THE AUTOMATION TAG *****************");
		Reporter.log("***************** SET THE PERMISSION IN THE AUTOMATION TAG *****************");
		log.info("***************** SET THE PERMISSION IN THE AUTOMATION TAG *****************");

		try {

			// wait for element
			explicitWaitClickable("questionnaire_systemtab_XPATH");

			// click on the system tab
			click("questionnaire_systemtab_XPATH");
			System.out.println("Clicked on the system tab.");
			ngDriver.waitForAngularRequestsToFinish();

			// scroll down the screen
			JavascriptExecutor js = (JavascriptExecutor) driver;
			js.executeScript("window.scrollBy(0,200)");

			// click on the Task Tag option
			click("questionnaire_tasktagoption_XPATH");
			System.out.println("Clicked on the Task Tag option.");
			ngDriver.waitForAngularRequestsToFinish();

			// scroll down the screen
			js.executeScript("window.scrollBy(0,200)");

			// click on the task tag
			click("task_tasktaglbl_XPATH");
			ngDriver.waitForAngularRequestsToFinish();
			System.out.println("Clicked on the task tag.");

			// wait for the 3 seconds
			Thread.sleep(3000);

			// select the data in module name field

			// click on the Module Names field
			click("task_tasktag_modulenametxt_CSS");
			ngDriver.waitForAngularRequestsToFinish();
			System.out.println("Clicked on the Module Names field.");

			// click on the none button
			click("task_tasktag_nonebtn_CSS");
			ngDriver.waitForAngularRequestsToFinish();
			System.out.println("Clicked on the none button.");

			// enter the module name in the search field
			type("task_tasktag_searchtxt_CSS", data.get("search_1"));
			ngDriver.waitForAngularRequestsToFinish();
			System.out.println("Entered the module name in the search field.");

			// click on the searched result
			click("task_tasktag_searchedresult1_XPATH");
			ngDriver.waitForAngularRequestsToFinish();
			System.out.println("Clicked on the searched result.");

			// click on the Module Names field
			click("task_tasktag_modulenametxt_CSS");
			ngDriver.waitForAngularRequestsToFinish();
			System.out.println("Clicked on the Module Names field.");

			// select the data in due date editor field

			// click on the Due Date editor field
			click("task_tasktag_duedateeditortxt_CSS");
			ngDriver.waitForAngularRequestsToFinish();
			System.out.println("Clicked on the Due Date editor field.");

			// enter the username in the search field
			type("task_tasktag_searchtxt_CSS", data.get("search_2"));
			ngDriver.waitForAngularRequestsToFinish();
			System.out.println("Entered the username in the search field.");

			// click on the searched result
			click("task_tasktag_searchedresult2_XPATH");
			ngDriver.waitForAngularRequestsToFinish();
			System.out.println("Clicked on the searched result.");

			// enter the role in the search field
			clear("task_tasktag_searchtxt_CSS");
			ngDriver.waitForAngularRequestsToFinish();
			System.out.println("Cleared the search field.");
			type("task_tasktag_searchtxt_CSS", data.get("search_3"));
			ngDriver.waitForAngularRequestsToFinish();
			System.out.println("Entered the role in the search field.");

			// click on the searched result
			click("task_tasktag_searchedresult3_XPATH");
			ngDriver.waitForAngularRequestsToFinish();
			System.out.println("Clicked on the searched result.");

			// click on the Due Date editor field
			click("task_tasktag_duedateeditortxt_CSS");
			ngDriver.waitForAngularRequestsToFinish();
			System.out.println("Clicked on the Due Date editor field.");

			// clear the selected data from the other fields

			// click on the Task Admin field
			click("task_tasktag_taskadmintxt_CSS");
			ngDriver.waitForAngularRequestsToFinish();
			System.out.println("Clicked on the Task Admin field.");

			// click on the none button
			click("task_tasktag_nonebtn_CSS");
			ngDriver.waitForAngularRequestsToFinish();
			System.out.println("Clicked on the none button.");

			// click on the Task Admin field
			click("task_tasktag_taskadmintxt_CSS");
			ngDriver.waitForAngularRequestsToFinish();
			System.out.println("Clicked on the Task Admin field.");

			// scroll down the screen
			js.executeScript("window.scrollBy(0,400)");

			// click on the Access to PO section field
			click("task_tasktag_accesstoposectiontxt_CSS");
			ngDriver.waitForAngularRequestsToFinish();
			System.out.println("Clicked on the Access to PO section field.");

			// click on the none button
			click("task_tasktag_nonebtn_CSS");
			ngDriver.waitForAngularRequestsToFinish();
			System.out.println("Clicked on the none button.");

			// click on the Access to PO section field
			click("task_tasktag_accesstoposectiontxt_CSS");
			ngDriver.waitForAngularRequestsToFinish();
			System.out.println("Clicked on the Access to PO section field.");

			// click on the Access to Schedule section field
			click("task_tasktag_accesstoschedulesectiontxt_CSS");
			ngDriver.waitForAngularRequestsToFinish();
			System.out.println("Clicked on the Access to Schedule section field.");

			// click on the none button
			click("task_tasktag_nonebtn_CSS");
			ngDriver.waitForAngularRequestsToFinish();
			System.out.println("Clicked on the none button.");

			// click on the Access to Schedule section field
			click("task_tasktag_accesstoschedulesectiontxt_CSS");
			ngDriver.waitForAngularRequestsToFinish();
			System.out.println("Clicked on the Access to Schedule section field.");

			// click on the Access to Survey/Checklist section field
			click("task_tasktag_accesstosurveychecklistsectiontxt_CSS");
			ngDriver.waitForAngularRequestsToFinish();
			System.out.println("Clicked on the Access to Survey/Checklist section field.");

			// click on the none button
			click("task_tasktag_nonebtn_CSS");
			ngDriver.waitForAngularRequestsToFinish();
			System.out.println("Clicked on the none button.");

			// click on the Access to Survey/Checklist section field
			click("task_tasktag_accesstosurveychecklistsectiontxt_CSS");
			ngDriver.waitForAngularRequestsToFinish();
			System.out.println("Clicked on the Access to Survey/Checklist section field.");

			// scroll down the screen
			js.executeScript("window.scrollBy(0,200)");

			// click on the Access to edit PO details field
			click("task_tasktag_accesstoeditpoedittxt_CSS");
			ngDriver.waitForAngularRequestsToFinish();
			System.out.println("Clicked on the Access to edit PO details field.");

			// click on the none button
			click("task_tasktag_nonebtn_CSS");
			ngDriver.waitForAngularRequestsToFinish();
			System.out.println("Clicked on the none button.");

			// click on the Access to edit PO details field
			click("task_tasktag_accesstoeditpoedittxt_CSS");
			ngDriver.waitForAngularRequestsToFinish();
			System.out.println("Clicked on the Access to edit PO details field.");

			// click on the Access to view PO Estimate amount field
			click("task_tasktag_accesstoviewpoestimateamounttxt_CSS");
			ngDriver.waitForAngularRequestsToFinish();
			System.out.println("Clicked on the Access to view PO Estimate amount field.");

			// click on the none button
			click("task_tasktag_nonebtn_CSS");
			ngDriver.waitForAngularRequestsToFinish();
			System.out.println("Clicked on the none button.");

			// click on the Access to edit PO details field
			click("task_tasktag_accesstoviewpoestimateamounttxt_CSS");
			ngDriver.waitForAngularRequestsToFinish();
			System.out.println("Clicked on the Access to edit PO details field.");

			// click on the Access to edit PO Estimate amount field
			click("task_tasktag_accesstoeditpoestimateamounttxt_CSS");
			ngDriver.waitForAngularRequestsToFinish();
			System.out.println("Clicked on the Access to edit PO Estimate amount field.");

			// click on the none button
			click("task_tasktag_nonebtn_CSS");
			ngDriver.waitForAngularRequestsToFinish();
			System.out.println("Clicked on the none button.");

			// click on the Access to edit PO Estimate amount field
			click("task_tasktag_accesstoeditpoestimateamounttxt_CSS");
			ngDriver.waitForAngularRequestsToFinish();
			System.out.println("Clicked on the Access to edit PO Estimate amount field.");

			// click on the Access to replace Task Assignee field
			click("task_tasktag_accesstoreplacetaskassigneetxt_CSS");
			ngDriver.waitForAngularRequestsToFinish();
			System.out.println("Clicked on the Access to replace Task Assignee field.");

			// click on the none button
			click("task_tasktag_nonebtn_CSS");
			ngDriver.waitForAngularRequestsToFinish();
			System.out.println("Clicked on the none button.");

			// click on the Access to replace Task Assignee field
			click("task_tasktag_accesstoreplacetaskassigneetxt_CSS");
			ngDriver.waitForAngularRequestsToFinish();
			System.out.println("Clicked on the Access to replace Task Assignee field.");

			// click on the update button
			click("task_tasktag_updatebtn_CSS");
			ngDriver.waitForAngularRequestsToFinish();
			System.out.println("Clicked on the update button.");

		} catch (Throwable t) {
			verificationFailed();

		}

		// click on the home icon from the top of the screen
		click("questionnaire_homeburgermenubtn_CSS");
		ngDriver.waitForAngularRequestsToFinish();
		System.out.println("Clicked on the home icon from the top of the screen.");

		// wait for element
		explicitWait("propertylist_title_XPATH");

		// verify the property list
		switchVerification("propertylist_title_XPATH", "Property List", "The property list is not displayed.");

		// ADD THE TASK

		System.out.println("***************** ADD THE TASK *****************");
		test.log(LogStatus.INFO, "***************** ADD THE TASK *****************");
		Reporter.log("***************** ADD THE TASK *****************");
		log.info("***************** ADD THE TASK *****************");

		try {
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
			ngDriver.waitForAngularRequestsToFinish();
			System.out.println("Clicked on the assign to field.");

			// click on the none button
			click("task_tasktag_nonebtn_CSS");
			ngDriver.waitForAngularRequestsToFinish();
			System.out.println("Clicked on the none button.");

			// enter the username in the search field
			type("task_tasktag_searchtxt_CSS", data.get("search_2"));
			ngDriver.waitForAngularRequestsToFinish();
			System.out.println("Entered the username in the search field.");

			// click on the searched result
			click("task_tasktag_searchedresult2_XPATH");
			ngDriver.waitForAngularRequestsToFinish();
			System.out.println("Clicked on the searched result.");

			// enter the role in the search field
			clear("task_tasktag_searchtxt_CSS");
			ngDriver.waitForAngularRequestsToFinish();
			System.out.println("Cleared the search field.");
			type("task_tasktag_searchtxt_CSS", data.get("search_3"));
			ngDriver.waitForAngularRequestsToFinish();
			System.out.println("Entered the role in the search field.");

			// click on the searched result
			click("task_tasktag_searchedresult3_XPATH");
			ngDriver.waitForAngularRequestsToFinish();
			System.out.println("Clicked on the searched result.");

			// click on the assign to field
			click("task_assigntotxt_CSS");
			ngDriver.waitForAngularRequestsToFinish();
			System.out.println("Clicked on the assign to field.");

			// scroll down the screen
			JavascriptExecutor js = (JavascriptExecutor) driver;
			js.executeScript("window.scrollBy(0,1200)");

			// wait for 3 seconds
			Thread.sleep(3000);

			// select the environmental option from the module dropdown
			select("task_addtask_moduledd_CSS", data.get("task_module"));
			System.out.println("Selected the environmental option from the module dropdown.");
			ngDriver.waitForAngularRequestsToFinish();

			// click on the task tag field
			click("task_tasktag_field_CSS");
			ngDriver.waitForAngularRequestsToFinish();
			System.out.println("Clicked on the task tag field.");

			// click on the none button
			click("task_tasktag_nonebtn_CSS");
			ngDriver.waitForAngularRequestsToFinish();
			System.out.println("Clicked on the none button.");

			// enter the task tag name in the search field
			type("task_tasktag_searchtxt_CSS", data.get("search_4"));
			ngDriver.waitForAngularRequestsToFinish();
			System.out.println("Entered the task tag name in the search field.");

			// click on the searched result
			click("task_tasktag_searchedresult4_XPATH");
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
			switchVerification("task_createdtask_tasktagpermission22_XPATH", "Test Task Tap Permission 2",
					"The Test Task Tap Permission 2 is not displayed.");

		} catch (Throwable t) {
			verificationFailed();
		}

		// LOGOUT FROM ADMIN USER AND LOGIN WITH JINESH MISC 2 AND VERIFY TASK IS
		// DISPLAYED OR NOT

		System.out.println(
				"***************** LOGOUT FROM ADMIN USER AND LOGIN WITH JINESH MISC 2 AND VERIFY TASK IS DISPLAYED OR NOT *****************");
		test.log(LogStatus.INFO,
				"***************** LOGOUT FROM ADMIN USER AND LOGIN WITH JINESH MISC 2 AND VERIFY TASK IS DISPLAYED OR NOT *****************");
		Reporter.log(
				"***************** LOGOUT FROM ADMIN USER AND LOGIN WITH JINESH MISC 2 AND VERIFY TASK IS DISPLAYED OR NOT *****************");
		log.info(
				"***************** LOGOUT FROM ADMIN USER AND LOGIN WITH JINESH MISC 2 AND VERIFY TASK IS DISPLAYED OR NOT *****************");

		try {

			// wait for element
			Thread.sleep(5000);

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

			helper.loginAndUpdateSystemCompany(data, "username_5", "password_5", "system_company_1");

			// VERIFY THE FIELDS ARE DISPLAYED AS PER THE PERMISSION

			System.out.println(
					"***************** VERIFY THE FIELDS ARE DISPLAYED AS PER THE PERMISSION *****************");
			test.log(LogStatus.INFO,
					"***************** VERIFY THE FIELDS ARE DISPLAYED AS PER THE PERMISSION *****************");
			Reporter.log("***************** VERIFY THE FIELDS ARE DISPLAYED AS PER THE PERMISSION *****************");
			log.info("***************** VERIFY THE FIELDS ARE DISPLAYED AS PER THE PERMISSION *****************");

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

				// verify newly created task is displayed or not
				switchVerification("task_createdtask_tasktagpermission22_XPATH", "Test Task Tap Permission 2",
						"The Test Task Tap Permission 2 is not displayed.");

				// click on task which is displayed due the permission
				click("task_createdtask_tasktagpermission22_XPATH");
				ngDriver.waitForAngularRequestsToFinish();
				System.out.println("Clicked on task which is displayed due the permission.");

				// update the title of the task
				clear("task_addtask_titletxt_CSS");
				System.out.println("Cleared the title of the task.");
				ngDriver.waitForAngularRequestsToFinish();
				type("task_addtask_titletxt_CSS", data.get("update1_task_title"));
				System.out.println("Entered the updated data in the task title.");
				ngDriver.waitForAngularRequestsToFinish();

				// click on the update button
				click("task_tasktag_taskscreen_updatebtn_CSS");
				ngDriver.waitForAngularRequestsToFinish();
				System.out.println("Clicked on the update button.");

				TestUtil.captureScreenshot();

				// ReportNG
				Reporter.log("<br>" + " Update Title Verification failure : " + "<br>");
				Reporter.log("<a target=\"_blank\" href=" + TestUtil.screenshotName + "><img src="
						+ TestUtil.screenshotName + " height=200 width=200></img></a>");
				Reporter.log("<br>");
				Reporter.log("<br>");

				// Extent Report
				test.log(LogStatus.FAIL, " Update Title Verification failure : ");
				test.log(LogStatus.FAIL, test.addScreenCapture(TestUtil.screenshotName));

				System.out.println("The task verification is failed.");
				log.info("The task verification is failed.");

			} catch (Throwable t) {

				System.out.println("The user not able to update the task as expected.");
				test.log(LogStatus.INFO, "The user not able to update the task as expected.");
				Reporter.log("The user not able to update the task as expected.");
				log.info("The user not able to update the task as expected.");

			}

			try {
				boolean str3 = driver.findElement(By.cssSelector(OR.getProperty("task_tasktag_powarrantytab_CSS")))
						.isDisplayed();

				if (str3 == true) {

					TestUtil.captureScreenshot();

					// ReportNG
					Reporter.log("<br>" + "The Purchase Order/Warranty tab verification failure : " + "<br>");
					Reporter.log("<a target=\"_blank\" href=" + TestUtil.screenshotName + "><img src="
							+ TestUtil.screenshotName + " height=200 width=200></img></a>");
					Reporter.log("<br>");
					Reporter.log("<br>");

					// Extent Report
					test.log(LogStatus.FAIL, " The Purchase Order/Warranty tab verification failure : ");
					test.log(LogStatus.FAIL, test.addScreenCapture(TestUtil.screenshotName));

					System.out.println("The Purchase Order/Warranty tab verification is failed.");
					log.info("The Purchase Order/Warranty tab verification is failed.");

				} else {
					System.out.println("The Purchase Order/Warranty tab is not displayed as expected.");
					test.log(LogStatus.INFO, "The Purchase Order/Warranty tab is not displayed as expected.");
					Reporter.log("The Purchase Order/Warranty tab is not displayed as expected.");
					log.info("The Purchase Order/Warranty tab is not displayed as expected.");
				}

			} catch (Throwable t) {

				System.out.println("The Purchase Order/Warranty tab is not displayed as expected.");
				test.log(LogStatus.INFO, "The Purchase Order/Warranty tab is not displayed as expected.");
				Reporter.log("The Purchase Order/Warranty tab is not displayed as expected.");
				log.info("The Purchase Order/Warranty tab is not displayed as expected.");
			}

			try {
				boolean str4 = driver.findElement(By.cssSelector(OR.getProperty("task_tasktag_surveychecklisttab_CSS")))
						.isDisplayed();

				if (str4 == true) {

					TestUtil.captureScreenshot();

					// ReportNG
					Reporter.log("<br>" + "The Survey/Checklist tab verification failure : " + "<br>");
					Reporter.log("<a target=\"_blank\" href=" + TestUtil.screenshotName + "><img src="
							+ TestUtil.screenshotName + " height=200 width=200></img></a>");
					Reporter.log("<br>");
					Reporter.log("<br>");

					// Extent Report
					test.log(LogStatus.FAIL, " The Survey/Checklist tab verification failure : ");
					test.log(LogStatus.FAIL, test.addScreenCapture(TestUtil.screenshotName));

					System.out.println("The Survey/Checklist tab verification is failed.");
					log.info("The Survey/Checklist tab verification is failed.");

				} else {
					System.out.println("The Survey/Checklist tab is not displayed as expected.");
					test.log(LogStatus.INFO, "The Survey/Checklist tab is not displayed as expected.");
					Reporter.log("The Survey/Checklist tab is not displayed as expected.");
					log.info("The Survey/Checklist tab is not displayed as expected.");

				}

			} catch (Throwable t) {

				System.out.println("The Survey/Checklist tab is not displayed as expected.");
				test.log(LogStatus.INFO, "The Survey/Checklist tab is not displayed as expected.");
				Reporter.log("The Survey/Checklist tab is not displayed as expected.");
				log.info("The Survey/Checklist tab is not displayed as expected.");

			}

			try {
				boolean str6 = driver.findElement(By.cssSelector(OR.getProperty("task_tasktag_changeduedatebtn_CSS")))
						.isDisplayed();

				if (str6 == true) {

					// click on the change due date button
					click("task_tasktag_changeduedatebtn_CSS");
					ngDriver.waitForAngularRequestsToFinish();
					System.out.println("Clicked on the change due date button.");

					// wait for 3 seconds
					Thread.sleep(3000);

					// click on the new due date field
					click("task_tasktag_newduedatetxt_CSS");
					ngDriver.waitForAngularRequestsToFinish();
					System.out.println("Clicked on the new due date field.");

					// wait for 3 seconds
					Thread.sleep(3000);

					// click on the today button
					click("task_tasktag_newduedatetxt_todaybtn_XPATH");
					ngDriver.waitForAngularRequestsToFinish();
					System.out.println("Clicked on the today button.");

					// wait for 3 seconds
					Thread.sleep(3000);

					// enter the details in the reason field
					type("task_tasktag_newduedatetxt_reasontxt_CSS", data.get("duedatereason"));
					ngDriver.waitForAngularRequestsToFinish();
					System.out.println("Entered the details in the reason field.");

					// click on the apply button
					click("task_tasktag_newduedatetxt_applybtn_CSS");
					ngDriver.waitForAngularRequestsToFinish();
					System.out.println("Clicked on the apply button.");

					System.out.println("The Chnage Due Date button is displayed as expected.");
					test.log(LogStatus.INFO, "The Chnage Due Date button is displayed as expected.");
					Reporter.log("The Chnage Due Date button is displayed as expected.");
					log.info("The Chnage Due Date button is displayed as expected.");

				} else {
					try {
						boolean closeicon = driver
								.findElement(By.cssSelector(OR.getProperty("task_tasktag_changeduedate_closebtn_CSS")))
								.isDisplayed();

						if (closeicon == true) {
							// click on the close button
							click("task_tasktag_changeduedate_closebtn_CSS");
							ngDriver.waitForAngularRequestsToFinish();
							System.out.println("Clicked on the close button.");
						}

					} catch (Throwable t1) {
						TestUtil.captureScreenshot();

						// ReportNG
						Reporter.log("<br>" + " The Chnage Due Date button verification failure : " + "<br>");
						Reporter.log("<a target=\"_blank\" href=" + TestUtil.screenshotName + "><img src="
								+ TestUtil.screenshotName + " height=200 width=200></img></a>");
						Reporter.log("<br>");
						Reporter.log("<br>");

						// Extent Report
						test.log(LogStatus.FAIL, " The Chnage Due Date button verification failed with exception : ");
						test.log(LogStatus.FAIL, test.addScreenCapture(TestUtil.screenshotName));

						System.out.println("The Chnage Due Date button verification is failed.");
						log.info("The Chnage Due Date button verification is failed.");
					}

				}

			} catch (Throwable t) {

				try {
					boolean closeicon = driver
							.findElement(By.cssSelector(OR.getProperty("task_tasktag_changeduedate_closebtn_CSS")))
							.isDisplayed();

					if (closeicon == true) {
						// click on the close button
						click("task_tasktag_changeduedate_closebtn_CSS");
						ngDriver.waitForAngularRequestsToFinish();
						System.out.println("Clicked on the close button.");
					}

				} catch (Throwable t1) {
					TestUtil.captureScreenshot();

					// ReportNG
					Reporter.log("<br>" + " The Chnage Due Date button verification failure : " + "<br>");
					Reporter.log("<a target=\"_blank\" href=" + TestUtil.screenshotName + "><img src="
							+ TestUtil.screenshotName + " height=200 width=200></img></a>");
					Reporter.log("<br>");
					Reporter.log("<br>");

					// Extent Report
					test.log(LogStatus.FAIL, " The Chnage Due Date button verification failed with exception : ");
					test.log(LogStatus.FAIL, test.addScreenCapture(TestUtil.screenshotName));

					System.out.println("The Chnage Due Date button verification is failed.");
					log.info("The Chnage Due Date button verification is failed.");
				}

			}

			// LOGOUT FROM JINESH MISC 2 USER AND LOGIN WITH MAINTANANCE USER AND VERIFY
			// TASK IS DISPLAYED OR NOT

			System.out.println(
					"***************** LOGOUT FROM JINESH MISC 2 USER AND LOGIN WITH MAINTANANCE USER *****************");
			test.log(LogStatus.INFO,
					"***************** LOGOUT FROM JINESH MISC 2 USER AND LOGIN WITH MAINTANANCE USER *****************");
			Reporter.log(
					"***************** LOGOUT FROM JINESH MISC 2 USER AND LOGIN WITH MAINTANANCE USER *****************");
			log.info(
					"***************** LOGOUT FROM JINESH MISC 2 USER AND LOGIN WITH MAINTANANCE USER *****************");

			try {
				// wait for element
				Thread.sleep(5000);

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

				helper.loginAndUpdateSystemCompany(data, "username_2", "password_2", "system_company_1");

				// VERIFY TASK IS DISPLAYED OR NOT

				System.out.println("***************** VERIFY TASK IS DISPLAYED OR NOT *****************");
				test.log(LogStatus.INFO, "***************** VERIFY TASK IS DISPLAYED OR NOT *****************");
				Reporter.log("***************** VERIFY TASK IS DISPLAYED OR NOT *****************");
				log.info("***************** VERIFY TASK IS DISPLAYED OR NOT *****************");

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
				switchVerification("task_createdtask_tasktagpermission22_XPATH", "Test Task Tap Permission 2",
						"The Test Task Tap Permission 2 is not displayed.");

				// VERIFY THE FIELDS ARE DISPLAYED AS PER THE PERMISSION

				System.out.println(
						"***************** VERIFY THE FIELDS ARE DISPLAYED AS PER THE PERMISSION *****************");
				test.log(LogStatus.INFO,
						"***************** VERIFY THE FIELDS ARE DISPLAYED AS PER THE PERMISSION *****************");
				Reporter.log(
						"***************** VERIFY THE FIELDS ARE DISPLAYED AS PER THE PERMISSION *****************");
				log.info("***************** VERIFY THE FIELDS ARE DISPLAYED AS PER THE PERMISSION *****************");

				// click on task which is displayed due the permission
				click("task_createdtask_tasktagpermission22_XPATH");
				ngDriver.waitForAngularRequestsToFinish();
				System.out.println("Clicked on task which is displayed due the permission.");

				// update the title of the task
				clear("task_addtask_titletxt_CSS");
				System.out.println("Cleared the title of the task.");
				ngDriver.waitForAngularRequestsToFinish();
				type("task_addtask_titletxt_CSS", data.get("update1_task_title"));
				System.out.println("Entered the updated data in the task title.");
				ngDriver.waitForAngularRequestsToFinish();

				// click on the update button
				click("task_tasktag_taskscreen_updatebtn_CSS");
				ngDriver.waitForAngularRequestsToFinish();
				System.out.println("Clicked on the update button.");

				TestUtil.captureScreenshot();

				// ReportNG
				Reporter.log("<br>" + " Update Title Verification failure : " + "<br>");
				Reporter.log("<a target=\"_blank\" href=" + TestUtil.screenshotName + "><img src="
						+ TestUtil.screenshotName + " height=200 width=200></img></a>");
				Reporter.log("<br>");
				Reporter.log("<br>");

				// Extent Report
				test.log(LogStatus.FAIL, " Update Title Verification failure : ");
				test.log(LogStatus.FAIL, test.addScreenCapture(TestUtil.screenshotName));

				System.out.println("The task verification is failed.");
				log.info("The task verification is failed.");

			} catch (Throwable t) {

				System.out.println("The user not able to update the task as expected.");
				test.log(LogStatus.INFO, "The user not able to update the task as expected.");
				Reporter.log("The user not able to update the task as expected.");
				log.info("The user not able to update the task as expected.");

			}

			try {
				boolean str7 = driver.findElement(By.cssSelector(OR.getProperty("task_tasktag_powarrantytab_CSS")))
						.isDisplayed();

				if (str7 == true) {

					TestUtil.captureScreenshot();

					// ReportNG
					Reporter.log("<br>" + "The Purchase Order/Warranty tab verification failure : " + "<br>");
					Reporter.log("<a target=\"_blank\" href=" + TestUtil.screenshotName + "><img src="
							+ TestUtil.screenshotName + " height=200 width=200></img></a>");
					Reporter.log("<br>");
					Reporter.log("<br>");

					// Extent Report
					test.log(LogStatus.FAIL, " The Purchase Order/Warranty tab verification failure : ");
					test.log(LogStatus.FAIL, test.addScreenCapture(TestUtil.screenshotName));

					System.out.println("The Purchase Order/Warranty tab verification is failed.");
					log.info("The Purchase Order/Warranty tab verification is failed.");

				} else {
					System.out.println("The Purchase Order/Warranty tab is not displayed as expected.");
					test.log(LogStatus.INFO, "The Purchase Order/Warranty tab is not displayed as expected.");
					Reporter.log("The Purchase Order/Warranty tab is not displayed as expected.");
					log.info("The Purchase Order/Warranty tab is not displayed as expected.");
				}

			} catch (Throwable t) {

				System.out.println("The Purchase Order/Warranty tab is not displayed as expected.");
				test.log(LogStatus.INFO, "The Purchase Order/Warranty tab is not displayed as expected.");
				Reporter.log("The Purchase Order/Warranty tab is not displayed as expected.");
				log.info("The Purchase Order/Warranty tab is not displayed as expected.");
			}

			try {
				boolean str8 = driver.findElement(By.cssSelector(OR.getProperty("task_tasktag_surveychecklisttab_CSS")))
						.isDisplayed();

				if (str8 == true) {

					TestUtil.captureScreenshot();

					// ReportNG
					Reporter.log("<br>" + "The Survey/Checklist tab verification failure : " + "<br>");
					Reporter.log("<a target=\"_blank\" href=" + TestUtil.screenshotName + "><img src="
							+ TestUtil.screenshotName + " height=200 width=200></img></a>");
					Reporter.log("<br>");
					Reporter.log("<br>");

					// Extent Report
					test.log(LogStatus.FAIL, " The Survey/Checklist tab verification failure : ");
					test.log(LogStatus.FAIL, test.addScreenCapture(TestUtil.screenshotName));

					System.out.println("The Survey/Checklist tab verification is failed.");
					log.info("The Survey/Checklist tab verification is failed.");

				} else {
					System.out.println("The Survey/Checklist tab is not displayed as expected.");
					test.log(LogStatus.INFO, "The Survey/Checklist tab is not displayed as expected.");
					Reporter.log("The Survey/Checklist tab is not displayed as expected.");
					log.info("The Survey/Checklist tab is not displayed as expected.");

				}

			} catch (Throwable t) {

				System.out.println("The Survey/Checklist tab is not displayed as expected.");
				test.log(LogStatus.INFO, "The Survey/Checklist tab is not displayed as expected.");
				Reporter.log("The Survey/Checklist tab is not displayed as expected.");
				log.info("The Survey/Checklist tab is not displayed as expected.");

			}

			try {
				boolean str6 = driver.findElement(By.cssSelector(OR.getProperty("task_tasktag_changeduedatebtn_CSS")))
						.isDisplayed();

				if (str6 == true) {

					// click on the change due date button
					click("task_tasktag_changeduedatebtn_CSS");
					ngDriver.waitForAngularRequestsToFinish();
					System.out.println("Clicked on the change due date button.");

					// wait for 3 seconds
					Thread.sleep(3000);

					// click on the new due date field
					click("task_tasktag_newduedatetxt_CSS");
					ngDriver.waitForAngularRequestsToFinish();
					System.out.println("Clicked on the new due date field.");

					// wait for 3 seconds
					Thread.sleep(3000);

					// click on the today button
					click("task_tasktag_newduedatetxt_todaybtn_XPATH");
					ngDriver.waitForAngularRequestsToFinish();
					System.out.println("Clicked on the today button.");

					// wait for 3 seconds
					Thread.sleep(3000);

					// enter the details in the reason field
					type("task_tasktag_newduedatetxt_reasontxt_CSS", data.get("duedatereason"));
					ngDriver.waitForAngularRequestsToFinish();
					System.out.println("Entered the details in the reason field.");

					// click on the apply button
					click("task_tasktag_newduedatetxt_applybtn_CSS");
					ngDriver.waitForAngularRequestsToFinish();
					System.out.println("Clicked on the apply button.");

					System.out.println("The Chnage Due Date button is displayed as expected.");
					test.log(LogStatus.INFO, "The Chnage Due Date button is displayed as expected.");
					Reporter.log("The Chnage Due Date button is displayed as expected.");
					log.info("The Chnage Due Date button is displayed as expected.");

				} else {

					try {
						boolean closeicon = driver
								.findElement(By.cssSelector(OR.getProperty("task_tasktag_changeduedate_closebtn_CSS")))
								.isDisplayed();

						if (closeicon == true) {
							// click on the close button
							click("task_tasktag_changeduedate_closebtn_CSS");
							ngDriver.waitForAngularRequestsToFinish();
							System.out.println("Clicked on the close button.");
						}

					} catch (Throwable t1) {
						TestUtil.captureScreenshot();

						// ReportNG
						Reporter.log("<br>" + " The Chnage Due Date button verification failure : " + "<br>");
						Reporter.log("<a target=\"_blank\" href=" + TestUtil.screenshotName + "><img src="
								+ TestUtil.screenshotName + " height=200 width=200></img></a>");
						Reporter.log("<br>");
						Reporter.log("<br>");

						// Extent Report
						test.log(LogStatus.FAIL, " The Chnage Due Date button verification failed with exception : ");
						test.log(LogStatus.FAIL, test.addScreenCapture(TestUtil.screenshotName));

						System.out.println("The Chnage Due Date button verification is failed.");
						log.info("The Chnage Due Date button verification is failed.");
					}

				}

			} catch (Throwable t) {

				try {
					boolean closeicon = driver
							.findElement(By.cssSelector(OR.getProperty("task_tasktag_changeduedate_closebtn_CSS")))
							.isDisplayed();

					if (closeicon == true) {
						// click on the close button
						click("task_tasktag_changeduedate_closebtn_CSS");
						ngDriver.waitForAngularRequestsToFinish();
						System.out.println("Clicked on the close button.");
					}

				} catch (Throwable t1) {
					TestUtil.captureScreenshot();

					// ReportNG
					Reporter.log("<br>" + " The Chnage Due Date button verification failure : " + "<br>");
					Reporter.log("<a target=\"_blank\" href=" + TestUtil.screenshotName + "><img src="
							+ TestUtil.screenshotName + " height=200 width=200></img></a>");
					Reporter.log("<br>");
					Reporter.log("<br>");

					// Extent Report
					test.log(LogStatus.FAIL, " The Chnage Due Date button verification failed with exception : ");
					test.log(LogStatus.FAIL, test.addScreenCapture(TestUtil.screenshotName));

					System.out.println("The Chnage Due Date button verification is failed.");
					log.info("The Chnage Due Date button verification is failed.");
				}

			}

			// LOGOUT FROM MANINTANANCE USER AND LOGIN WITH JINESH CONTRACTOR USER

			System.out.println(
					"***************** LOGOUT FROM MANINTANANCE USER AND LOGIN WITH JINESH CONTRACTOR USER *****************");
			test.log(LogStatus.INFO,
					"***************** LOGOUT FROM MANINTANANCE USER AND LOGIN WITH JINESH CONTRACTOR USER *****************");
			Reporter.log(
					"***************** LOGOUT FROM MANINTANANCE USER AND LOGIN WITH JINESH CONTRACTOR USER *****************");
			log.info(
					"***************** LOGOUT FROM MANINTANANCE USER AND LOGIN WITH JINESH CONTRACTOR USER *****************");

			try {
				// wait for element
				Thread.sleep(5000);

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

				// VERIFY TASK IS DISPLAYED OR NOT

				System.out.println("***************** VERIFY TASK IS DISPLAYED OR NOT *****************");
				test.log(LogStatus.INFO, "***************** VERIFY TASK IS DISPLAYED OR NOT *****************");
				Reporter.log("***************** VERIFY TASK IS DISPLAYED OR NOT *****************");
				log.info("***************** VERIFY TASK IS DISPLAYED OR NOT *****************");

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

				try {
					String str1 = driver
							.findElement(By.xpath(OR.getProperty("task_createdtask_tasktagpermission22_XPATH")))
							.getText();
					ngDriver.waitForAngularRequestsToFinish();
					if (str1.equals("Test Task Tap Permission 2")) {

						Assert.assertTrue(
								isElementPresent(
										By.xpath(OR.getProperty("task_createdtask_tasktagpermission22_XPATH"))),
								"The Test Task Tap Permission 2 is not displayed.");

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

						System.out.println("The task is not verified.");
						log.info("The task is not verified.");

					}
				} catch (Throwable t) {
					System.out.println("The task is verified successfully.");
					test.log(LogStatus.INFO, "The task is verified successfully.");
					Reporter.log("The task is verified successfully.");
					log.info("The task is verified successfully.");
				}

			} catch (Throwable t) {
				verificationFailed();
			}

			// click on the home icon from the top of the screen
			click("questionnaire_homeburgermenubtn_hide_CSS");
			System.out.println("Clicked on the home icon from the top of the screen.");
			ngDriver.waitForAngularRequestsToFinish();

			// wait for element
			explicitWait("propertylist_title_XPATH");

			// verify the property list
			switchVerification("propertylist_title_XPATH", "Property List", "The property list is not displayed.");

			// LOGOUT FROM CONTRACTOR USER AND LOGIN WITH AUTOMATION TESTER I.E. SUPER USER

			System.out.println(
					"***************** LOGOUT FROM CONTRACTOR USER AND LOGIN WITH AUTOMATION TESTER I.E. SUPER USER *****************");
			test.log(LogStatus.INFO,
					"***************** LOGOUT FROM CONTRACTOR USER AND LOGIN WITH AUTOMATION TESTER I.E. SUPER USER *****************");
			Reporter.log(
					"***************** LOGOUT FROM CONTRACTOR USER AND LOGIN WITH AUTOMATION TESTER I.E. SUPER USER *****************");
			log.info(
					"***************** LOGOUT FROM CONTRACTOR USER AND LOGIN WITH AUTOMATION TESTER I.E. SUPER USER *****************");

			// wait for element
			Thread.sleep(5000);

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

		// DELETE THE NEWLY CREATED TASK

		System.out.println("***************** DELETE THE NEWLY CREATED TASK *****************");
		test.log(LogStatus.INFO, "***************** DELETE THE NEWLY CREATED TASK *****************");
		Reporter.log("***************** DELETE THE NEWLY CREATED TASK *****************");
		log.info("***************** DELETE THE NEWLY CREATED TASK *****************");

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

			// verify newly created task is displayed or not
			switchVerification("task_createdtask_tasktagpermission22_XPATH", "Test Task Tap Permission 2",
					"The Test Task Tap Permission 2 is not displayed.");

			// click on task which is displayed due the permission
			click("task_createdtask_tasktagpermission22_XPATH");
			ngDriver.waitForAngularRequestsToFinish();
			System.out.println("Clicked on task which is displayed due the permission.");

			// wait for element
			explicitWaitClickable("task_tasktag_taskscreen_deletebtn_CSS");

			// click on the delete button
			click("task_tasktag_taskscreen_deletebtn_CSS");
			ngDriver.waitForAngularRequestsToFinish();
			System.out.println("Clicked on the delete button.");

			// wait for element
			explicitWaitClickable("task_deletedtaskbtn_confirmaiton_CSS");

			// click on the delete button of the confirmation message
			click("task_deletedtaskbtn_confirmaiton_CSS");
			ngDriver.waitForAngularRequestsToFinish();
			System.out.println("Clicked on the delete button of the confirmation message.");

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

			helper.deleteVerification("task_createdtask_tasktagpermission22_XPATH", "Test Task Tap Permission 2");

		} catch (Throwable t) {
			verificationFailed();
		}

		// click on the home icon from the top of the screen
		click("questionnaire_homeburgermenubtn_hide_CSS");
		System.out.println("Clicked on the home icon from the top of the screen.");
		ngDriver.waitForAngularRequestsToFinish();

		// wait for element
		explicitWait("propertylist_title_XPATH");

		// verify the property list
		switchVerification("propertylist_title_XPATH", "Property List", "The property list is not displayed.");

	}
}
