package testcases.smokesuite;

import java.io.IOException;
import java.util.Hashtable;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.Reporter;
import org.testng.SkipException;
import org.testng.annotations.Test;

import com.relevantcodes.extentreports.LogStatus;

import base.TestBase;
import utilities.TestUtil;

public class RR5595Morguard4Test extends TestBase {

	@Test(dataProviderClass = TestUtil.class, dataProvider = "dp")
	public void rR5595Morguard4Test(Hashtable<String, String> data) throws IOException, InterruptedException {

		if (!(TestUtil.isTestRunnable("rR5595Morguard4Test", excel))) {

			throw new SkipException(
					"Skipping the test " + "rR5595Morguard4Test".toUpperCase() + "as the Run mode is NO");
		}

		if (!data.get("runmode").equals("Y")) {

			throw new SkipException("Skipping the test case as the Run Mode for data set is NO");
		}

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

			// UPDATE THE SYSTEM COMPANY
			updateCompany(data);

		} catch (Throwable t) {
			verificationFailed();
		}

		// VERIFY RESPECTIVE TASK IS CREATED SUCCESSFULLY OR NOT FOR WORKFLOW AND
		// SECURITY

		System.out.println(
				"**************** VERIFY RESPECTIVE TASK IS CREATED SUCCESSFULLY OR NOT FOR WORKFLOW AND SECURITY ****************");
		test.log(LogStatus.INFO,
				"**************** VERIFY RESPECTIVE TASK IS CREATED SUCCESSFULLY OR NOT FOR WORKFLOW AND SECURITY ****************");
		Reporter.log(
				"**************** VERIFY RESPECTIVE TASK IS CREATED SUCCESSFULLY OR NOT FOR WORKFLOW AND SECURITY ****************");
		log.info(
				"**************** VERIFY RESPECTIVE TASK IS CREATED SUCCESSFULLY OR NOT FOR WORKFLOW AND SECURITY ****************");

		try {

			// enter the property name in the search field
			clear("envreports_propertylist_filtertxt_CSS");
			type("envreports_propertylist_filtertxt_CSS", data.get("property_2"));
			ngDriver.waitForAngularRequestsToFinish();
			System.out.println("Entered the property name in the search field.");

			// click on the environmental icon from the property list page
			click("environmentalicon_CSS");
			System.out.println("Clicked on the environmental icon of the Property.");
			ngDriver.waitForAngularRequestsToFinish();
			System.out.println("Navigate to the environmental screen of the perticular property.");

			// wait for the element
			Thread.sleep(5000);

			// click on the burger menu
			click("menubtn_CSS");
			System.out.println("Clicked on the burger menu button successfully!!!");
			ngDriver.waitForAngularRequestsToFinish();

			// wait for the element
			Thread.sleep(5000);

			// click on the survey option from side menu
			click("surveyoption_XPATH");
			System.out.println("Clicked on the survey option from side menu");
			ngDriver.waitForAngularRequestsToFinish();
			System.out.println("Navigate to the survey screen");

			// select the respective questionnaire from the dropdown
			select("survey_questionnairedd_CSS", data.get("questionnaire_title"));
			System.out.println("The questionnaire selected successfully.");
			ngDriver.waitForAngularRequestsToFinish();

			// verify respective category type displayed or not
			switchVerification("survey_categorytxt_XPATH", "PCB - Containing Equipment",
					"The PCB - Containing Equipment is not displayed.");

			// click on the workflow and security button
			click("workflowsecurity_workflowsecuritybtn_CSS");
			System.out.println("Clicked on the workflow and security button.");
			ngDriver.waitForAngularRequestsToFinish();

			// click on the select user field of the editor tasks section
			click("workflowsecurity_allowtoedit_editortasks_CSS");
			System.out.println("Clicked on the select user field of the editor tasks section.");
			ngDriver.waitForAngularRequestsToFinish();

			// click on the none button
			click("workflowsecurity_sendnotification_nonebtn_CSS");
			ngDriver.waitForAngularRequestsToFinish();
			System.out.println("Clicked on the none button.");

			// Enter data in the find user field
			type("questionnaire_createtask_findusertxt_CSS", data.get("user_name_1"));
			System.out.println("The data entered in the find user field.");
			ngDriver.waitForAngularRequestsToFinish();

			// select the user name from the user list
			click("workflowsecurity_editortask_selectusertxt_XPATH");
			System.out.println("The user name is selected from the list of users");
			ngDriver.waitForAngularRequestsToFinish();

			// click on the assign to field
			click("workflowsecurity_allowtoedit_editortasks_CSS");
			System.out.println("Click on the assign to field.");
			ngDriver.waitForAngularRequestsToFinish();

			// click on the due date field of editor tasks section
			click("workflowsecurity_editortask_duedate_CSS");
			System.out.println("Clicked on the due date field of editor tasks section.");
			ngDriver.waitForAngularRequestsToFinish();

			// click on the today's button
			click("workflowsecurity_editortask_duedate_todaybtn_BTNTEXT");
			System.out.println("Clicked on the today's button.");
			ngDriver.waitForAngularRequestsToFinish();

			// scroll till the priority field
			WebElement element9 = driver
					.findElement(By.cssSelector(OR.getProperty("workflowsecurity_allowtoapprove_editortasks_CSS")));
			JavascriptExecutor js = (JavascriptExecutor) driver;
			js.executeScript("arguments[0].scrollIntoView(true);", element9);
			System.out.println("Scrolled down the screen.");

			// click on the select user field of the approve tasks section
			click("workflowsecurity_allowtoapprove_editortasks_CSS");
			System.out.println("Clicked on the select user field of the approve tasks section.");
			ngDriver.waitForAngularRequestsToFinish();

			// click on the none button
			click("workflowsecurity_sendnotification_nonebtn_CSS");
			ngDriver.waitForAngularRequestsToFinish();
			System.out.println("Clicked on the none button.");

			// enter data in the find user field
			type("questionnaire_createtask_findusertxt_CSS", data.get("user_name_1"));
			System.out.println("The data entered in the find user field.");
			ngDriver.waitForAngularRequestsToFinish();

			// select the user name from the user list
			click("workflowsecurity_editortask_selectusertxt_XPATH");
			System.out.println("The user name is selected from the list of users");
			ngDriver.waitForAngularRequestsToFinish();

			// click on the assign to field
			click("workflowsecurity_allowtoapprove_editortasks_CSS");
			System.out.println("Click on the assign to field.");
			ngDriver.waitForAngularRequestsToFinish();

			// click on the due date field of editor tasks section
			click("workflowsecurity_allowtoapprove_duedate_CSS");
			System.out.println("Clicked on the due date field of approval tasks section.");
			ngDriver.waitForAngularRequestsToFinish();

			// click on the today's button
			click("workflowsecurity_editortask_duedate_todaybtn_BTNTEXT");
			System.out.println("Clicked on the today's button.");
			ngDriver.waitForAngularRequestsToFinish();

			// click on the save button
			click("workflowsecurity_editortask_savebtn_CSS");
			System.out.println("Clicked on the save button.");
			ngDriver.waitForAngularRequestsToFinish();

			// wait for the element
			explicitWaitClickable("closetoastmsg_CSS");

			// click on the toaster close button
			click("closetoastmsg_CSS");
			ngDriver.waitForAngularRequestsToFinish();
			System.out.println("Clicked on the toaster close button.");

			// verify the newly created record

			switchVerification("workflowsecurity_editortask_morguard13_XPATH", "High", "The task is not created.");

			switchVerification("workflowsecurity_approvaltask_morguard13_XPATH", "High", "The task is not created.");

			// VERIFY REPECTIVE TASK IS DISPLAYED IN THE TASK LIST OR NOT

			System.out.println(
					"**************** VERIFY REPECTIVE TASK IS DISPLAYED IN THE TASK LIST OR NOT ****************");
			test.log(LogStatus.INFO,
					"**************** VERIFY REPECTIVE TASK IS DISPLAYED IN THE TASK LIST OR NOT ****************");
			Reporter.log(
					"**************** VERIFY REPECTIVE TASK IS DISPLAYED IN THE TASK LIST OR NOT ****************");
			log.info("**************** VERIFY REPECTIVE TASK IS DISPLAYED IN THE TASK LIST OR NOT ****************");

			// wait for the element
			explicitWaitClickable("workflowsecurity_editortask_morguard13_XPATH");

			// click on the editor task record
			click("workflowsecurity_editortask_morguard13_XPATH");
			System.out.println("Clicked on the editor task record.");
			ngDriver.waitForAngularRequestsToFinish();

			// wait for the element
			Thread.sleep(5000);

			// get the data from the title field

			try {
				String str1 = driver
						.findElement(By.cssSelector(OR.getProperty("workflowsecurity_editortask_titlefield_CSS")))
						.getAttribute("value");

				if (str1.equals("Complete questionnaire Morguard - 2021 Summer - Environmental Compliance Audit")) {

					System.out.println("THE EDITOR TASK IS CREATED SUCCESSFULLY.");
					test.log(LogStatus.INFO, "THE EDITOR TASK IS CREATED SUCCESSFULLY.");
					Reporter.log("THE EDITOR TASK IS CREATED SUCCESSFULLY.");
					log.info("THE EDITOR TASK IS CREATED SUCCESSFULLY.");
				} else {
					TestUtil.captureScreenshot();

					// ReportNG
					Reporter.log("<br>" + " THE EDITOR TASK IS NOT CREATED. " + "<br>");
					Reporter.log("<a target=\"_blank\" href=" + TestUtil.screenshotName + "><img src="
							+ TestUtil.screenshotName + " height=200 width=200></img></a>");
					Reporter.log("<br>");
					Reporter.log("<br>");

					// Extent Report
					test.log(LogStatus.FAIL, " THE EDITOR TASK IS NOT CREATED. ");
					test.log(LogStatus.FAIL, test.addScreenCapture(TestUtil.screenshotName));

					System.out.println(" THE EDITOR TASK IS NOT CREATED. ");
					log.info(" THE EDITOR TASK IS NOT CREATED. ");
				}
			} catch (Throwable t) {
				verificationFailed();

			}

			// wait for the element
			explicitWaitClickable("task_tasktag_taskscreen_deletebtn_CSS");

			// click on the delete button
			click("task_tasktag_taskscreen_deletebtn_CSS");
			ngDriver.waitForAngularRequestsToFinish();
			System.out.println("Clicked on the delete button.");

			// click on the delete button of the confirmation popup
			click("task_deletedtaskbtn_confirmaiton_CSS");
			ngDriver.waitForAngularRequestsToFinish();
			System.out.println("Clicked on the delete button of the confirmation popup.");

			// wait for the element
			explicitWaitClickable("closetoastmsg_CSS");

			// click on the toaster close button
			click("closetoastmsg_CSS");
			ngDriver.waitForAngularRequestsToFinish();
			System.out.println("Clicked on the toaster close button.");

			// verify deleted task is displayed or not
			deleteVerification("workflowsecurity_editortask_morguard13_XPATH", "High");

			// scrolldown the screen
			js.executeScript("window.scrollBy(0,200)");

			// wait for the element
			explicitWaitClickable("workflowsecurity_approvaltask_morguard13_XPATH");

			// click on the approval task record
			click("workflowsecurity_approvaltask_morguard13_XPATH");
			System.out.println("Clicked on the approval task record.");
			ngDriver.waitForAngularRequestsToFinish();

			// wait for the element
			Thread.sleep(5000);

			// get the data from the title field

			try {
				String str2 = driver
						.findElement(By.cssSelector(OR.getProperty("workflowsecurity_editortask_titlefield_CSS")))
						.getAttribute("value");

				if (str2.equals("Approve/Lock questionnaire Morguard - 2021 Summer - Environmental Compliance Audit")) {

					System.out.println("THE APPROVAL TASK IS CREATED SUCCESSFULLY.");
					test.log(LogStatus.INFO, "THE APPROVAL TASK IS CREATED SUCCESSFULLY.");
					Reporter.log("THE APPROVAL TASK IS CREATED SUCCESSFULLY.");
					log.info("THE APPROVAL TASK IS CREATED SUCCESSFULLY.");
				} else {
					TestUtil.captureScreenshot();

					// ReportNG
					Reporter.log("<br>" + " THE APPROVAL TASK IS NOT CREATED. " + "<br>");
					Reporter.log("<a target=\"_blank\" href=" + TestUtil.screenshotName + "><img src="
							+ TestUtil.screenshotName + " height=200 width=200></img></a>");
					Reporter.log("<br>");
					Reporter.log("<br>");

					// Extent Report
					test.log(LogStatus.FAIL, " THE APPROVAL TASK IS NOT CREATED. ");
					test.log(LogStatus.FAIL, test.addScreenCapture(TestUtil.screenshotName));

					System.out.println(" THE APPROVAL TASK IS NOT CREATED. ");
					log.info(" THE APPROVAL TASK IS NOT CREATED. ");
				}
			} catch (Throwable t) {
				verificationFailed();
			}

			// wait for the element
			explicitWaitClickable("task_tasktag_taskscreen_deletebtn_CSS");

			// click on the delete button
			click("task_tasktag_taskscreen_deletebtn_CSS");
			ngDriver.waitForAngularRequestsToFinish();
			System.out.println("Clicked on the delete button.");

			// click on the delete button of the confirmation popup
			click("task_deletedtaskbtn_confirmaiton_CSS");
			ngDriver.waitForAngularRequestsToFinish();
			System.out.println("Clicked on the delete button of the confirmation popup.");

			// wait for the element
			explicitWaitClickable("closetoastmsg_CSS");

			// click on the toaster close button
			click("closetoastmsg_CSS");
			ngDriver.waitForAngularRequestsToFinish();
			System.out.println("Clicked on the toaster close button.");

			// verify deleted task is displayed or not
			deleteVerification("workflowsecurity_approvaltask_morguard13_XPATH", "High");

			// click on the save button
			click("workflowsecurity_editortask_savebtn_CSS");
			System.out.println("Clicked on the save button.");
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

		// NAVIGATE TO THE HOME SCREEN

		// click on the home option from the side menu
		click("questionnaire_homeburgermenubtn_hide_CSS");
		System.out.println("Clicked on the home option from the side menu");
		ngDriver.waitForAngularRequestsToFinish();

		// wait for the element
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
