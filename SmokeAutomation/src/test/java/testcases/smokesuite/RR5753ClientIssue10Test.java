package testcases.smokesuite;

import java.io.IOException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Hashtable;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.SkipException;
import org.testng.annotations.Test;

import com.relevantcodes.extentreports.LogStatus;

import base.TestBase;
import net.bytebuddy.asm.Advice.Local;
import utilities.TestUtil;

public class RR5753ClientIssue10Test extends TestBase {

	@Test(dataProviderClass = TestUtil.class, dataProvider = "dp")
	public void rR5753ClientIssue10Test(Hashtable<String, String> data) throws IOException, InterruptedException {

		if (!(TestUtil.isTestRunnable("rR5753ClientIssue10Test", excel))) {

			throw new SkipException(
					"Skipping the test " + "rR5753ClientIssue10Test".toUpperCase() + "as the Run mode is NO");
		}

		if (!data.get("runmode").equals("Y")) {

			throw new SkipException("Skipping the test case as the Run Mode for data set is NO");
		}

		// refresh the page
		driver.navigate().refresh();
		Thread.sleep(5000);
		driver.navigate().refresh();

		// UPDATE THE AUTO-TASK DETAILS FROM THE SURVEY AND VALIDATE IN THE TASK MODULE
		// - RR-5906

		System.out.println(
				"******************** UPDATE THE AUTO-TASK DETAILS FROM THE SURVEY AND VALIDATE IN THE TASK MODULE - RR-5906 ********************");
		test.log(LogStatus.INFO,
				"******************** UPDATE THE AUTO-TASK DETAILS FROM THE SURVEY AND VALIDATE IN THE TASK MODULE - RR-5906 ********************");
		Reporter.log(
				"******************** UPDATE THE AUTO-TASK DETAILS FROM THE SURVEY AND VALIDATE IN THE TASK MODULE - RR-5906 ********************");
		log.info(
				"******************** UPDATE THE AUTO-TASK DETAILS FROM THE SURVEY AND VALIDATE IN THE TASK MODULE - RR-5906 ********************");

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

		// VERIFY AND UPDATE THE AUTO TASK DETAILS AT SURVEY LEVEL

		System.out.println(
				"******************** VERIFY AND UPDATE AUTO TASK DETAILS AT SURVEY LEVEL ********************");
		test.log(LogStatus.INFO,
				"******************** VERIFY AND UPDATE AUTO TASK DETAILS AT SURVEY LEVEL ********************");
		Reporter.log("******************** VERIFY AND UPDATE AUTO TASK DETAILS AT SURVEY LEVEL ********************");
		log.info("******************** VERIFY AND UPDATE AUTO TASK DETAILS AT SURVEY LEVEL ********************");

		try {

			// enter the property name in the search field
			type("envreports_propertylist_filtertxt_CSS", data.get("property_1"));
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

			// click on the surveys option from side menu
			click("surveyoption_XPATH");
			System.out.println("Clicked on the surveys option from side menu");
			ngDriver.waitForAngularRequestsToFinish();
			System.out.println("Navigate to the csurveys screen");

			// wait for 3 seconds
			Thread.sleep(3000);

			// select the respective questionnaire
			select("survey_questionnairedd_CSS", data.get("questionnaire_title"));
			ngDriver.waitForAngularRequestsToFinish();
			System.out.println("Selected the respective questionnaire.");

			// wait for the element
			explicitWait("survey_categoryname_risk_XPATH");

			// clear respective the comment box
			clear("survey_commentbox1_risk_XPATH");
			clear("survey_commentbox2_risk_XPATH");

			// enter the details in the comment box 1 of the category 1 question 1
			clear("survey_commentbox1_risk_XPATH");
			type("survey_commentbox1_risk_XPATH", data.get("comment_1"));
			ngDriver.waitForAngularRequestsToFinish();
			System.out.println("Entered the details in the comment box 1 of the category 1 question 1.");

			// enter the details in the comment box 2 of the category 1 question 1
			clear("survey_commentbox2_risk_XPATH");
			type("survey_commentbox2_risk_XPATH", data.get("comment_2"));
			ngDriver.waitForAngularRequestsToFinish();
			System.out.println("Entered the details in the comment box 2 of the category 1 question 1.");

			// click on the Managing Agent Systems category label
			click("survey_categoryname_risk_XPATH");
			ngDriver.waitForAngularRequestsToFinish();
			System.out.println("Clicked on the Managing Agent Systems category label.");

			// wait for the element
			Thread.sleep(5000);

			// scroll down the screen
			JavascriptExecutor js = (JavascriptExecutor) driver;
			js.executeScript("window.scrollBy(0,600)");

			// verify validation 1
			switchVerification("survey_autotask_validation1_risk_XPATH", "Task/Action",
					"The Task/Action text is not displayed.");

			// verify validation 2
			switchVerification("survey_autotask_validation2_risk_XPATH", "(1) Risk Control Management System",
					"The (1) Risk Control Management System text is not displayed.");

			// verify validation 3
			switchVerification("survey_autotask_validation3_risk_XPATH", "Assigned To: Property Manager",
					"The Assigned To Property Manager text is not displayed.");

			// verify validation 4
			LocalDate currentDate = LocalDate.now();
			LocalDate futureDate = currentDate.plusYears(1);
			String futureDateString = futureDate.toString();

			try {
				String duedate = (driver.findElement(By.xpath(OR.getProperty("survey_autotask_validation5_risk_XPATH")))
						.getAttribute("value")).trim();

				if (duedate.equals(futureDateString)) {

					System.out.println("The due date is verified successfully.");
					test.log(LogStatus.INFO, "The due date is verified successfully.");
					Reporter.log("The due date is verified successfully.");
					log.info("The due date is verified successfully.");
				} else {
					verificationFailed();
				}
			} catch (Throwable t) {
				verificationFailedMessage("The due date is displayed incorrect.");
			}

			// update the priority of the task
			select("survey_autotask_prioritydd1_risk_XPATH", data.get("auto_Priority1"));
			ngDriver.waitForAngularRequestsToFinish();
			System.out.println("Updated the priority of the task.");

			// click on the duedate field
			click("survey_autotask_validation5_risk_XPATH");
			ngDriver.waitForAngularRequestsToFinish();
			System.out.println("Clicked on the duedate field.");

			// click on the today button
			click("survey_autotask_duedate_todaybtn_risk_XPATH");
			ngDriver.waitForAngularRequestsToFinish();
			System.out.println("Clicked on the today button.");

			// update the description of the task
			clear("survey_autotask_description1_risk_XPATH");
			type("survey_autotask_description1_risk_XPATH", data.get("auto_description1"));
			ngDriver.waitForAngularRequestsToFinish();
			System.out.println("Updated the description of the task.");

			// click on the assign to label
			click("survey_autotask_validation3_risk_XPATH");
			ngDriver.waitForAngularRequestsToFinish();
			System.out.println("Clicked on the assign to label.");

			// VERIFY THE UPDATED AUTO TASK DETAILS IN TASK TAB OF THE SURVEY

			System.out.println(
					"******************** VERIFY THE UPDATED AUTO TASK DETAILS IN TASK TAB OF THE SURVEY ********************");
			test.log(LogStatus.INFO,
					"******************** VERIFY THE UPDATED AUTO TASK DETAILS IN TASK TAB OF THE SURVEY ********************");
			Reporter.log(
					"******************** VERIFY THE UPDATED AUTO TASK DETAILS IN TASK TAB OF THE SURVEY ********************");
			log.info(
					"******************** VERIFY THE UPDATED AUTO TASK DETAILS IN TASK TAB OF THE SURVEY ********************");

			// click on the risk control management system link
			click("survey_autotask_riskcontrollink_risk_XPATH");
			ngDriver.waitForAngularRequestsToFinish();
			System.out.println("Clicked on the risk control management system link.");

			// scroll down the screen
			js.executeScript("window.scrollBy(0,200)");

			// verify the name of the task
			switchVerification("survey_autotask_task_taskname_XPATH", "Risk Control Management System",
					"The Risk Control Management System is not displayed.");

			// verify the priority of the task
			switchVerification("survey_autotask_task_priority1_XPATH", "High", "The High priority is not displayed.");

			// verify the due date of the task
			try {
				LocalDate Date1 = LocalDate.now();
				String TodayString = Date1.toString();
				String str2 = (driver.findElement(By.xpath(OR.getProperty("survey_autotask_task_duedate1_XPATH")))
						.getText()).trim();
				ngDriver.waitForAngularRequestsToFinish();
				if (str2.equals(TodayString)) {

					System.out.println("The due date is verified successfully.");
					test.log(LogStatus.INFO, "The due date is verified successfully.");
					Reporter.log("The due date is verified successfully.");
					log.info("The due date is verified successfully.");
				} else {
					verificationFailed();

					System.out.println("The due date is not verified.");
					test.log(LogStatus.INFO, "The due date is not verified.");
					Reporter.log("The due date is not verified.");
					log.info("The due date is not verified.");

				}
			} catch (Throwable t) {
				verificationFailed();

				System.out.println("The due date is not verified.");
				test.log(LogStatus.INFO, "The due date is not verified.");
				Reporter.log("The due date is not verified.");
				log.info("The due date is not verified.");

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

		// REMAINING CODE FROM HERE

		// VERIFY UPDATED AUTO TASK IN THE TASK MODULE

		System.out.println("******************** VERIFY UPDATED AUTO TASK IN THE TASK MODULE ********************");
		test.log(LogStatus.INFO,
				"******************** VERIFY UPDATED AUTO TASK IN THE TASK MODULE ********************");
		Reporter.log("******************** VERIFY UPDATED AUTO TASK IN THE TASK MODULE ********************");
		log.info("******************** VERIFY UPDATED AUTO TASK IN THE TASK MODULE ********************");

		try {
			// enter the property name in the search field
			type("envreports_propertylist_filtertxt_CSS", data.get("property_1"));
			ngDriver.waitForAngularRequestsToFinish();
			System.out.println("Entered the property name in the search field.");

			// click on the task icon from the property list page
			click("taskicon_CSS");
			System.out.println("Clicked on the task icon of the Property.");
			ngDriver.waitForAngularRequestsToFinish();
			System.out.println("Navigate to the task screen of the perticular property.");

			// wait for the clear button
			explicitWaitClickable("task_clearbtn_XPATH");

			// click on the clear button
			click("task_clearbtn_XPATH");
			ngDriver.waitForAngularRequestsToFinish();
			System.out.println("Clicked on the clear button.");

			// enter auto generated task in the search field
			type("survey_task_searchfield_CSS", data.get("autotask_1"));
			ngDriver.waitForAngularRequestsToFinish();
			System.out.println("enter auto generated task in the search field.");

			// click on the search button
			click("survey_task_searchfield_CSS");
			ngDriver.waitForAngularRequestsToFinish();
			System.out.println("Clicked on the search button.");

			// verify the auto generated task 1
			switchVerification("survey_autotask1_risk_XPATH", "Risk Control Management System",
					"The Risk Control Management System task is not displayed.");

			// verify the assignee name of the auto generated task 1
			switchVerification("survey_autotask1_assignee1_risk_XPATH", "Property Manager",
					"The Property Manager task is not displayed.");

			// verify the due date of the auto generated task 1

			try {
				LocalDate date1 = LocalDate.now();
				String date1_String = date1.toString();

				String todayDueDate1 = "//p[text()='Risk Control Management System']//parent::td[@ng-click='editTaskFromLandingPage(task)']//following-sibling::td[text()='"
						+ date1_String + "']";

				if (date1_String.equals(todayDueDate1)) {
					System.out.println("The due date is verified successfully.");
					test.log(LogStatus.INFO, "The due date is verified successfully.");
					Reporter.log("The due date is verified successfully.");
					log.info("The due date is verified successfully.");
				} else {
					verificationFailed();
					System.out.println("The due date is not verified.");
					test.log(LogStatus.INFO, "The due date is not verified.");
					Reporter.log("The due date is not verified.");
					log.info("The due date is not verified.");

				}
			} catch (Throwable t) {
				verificationFailed();
				System.out.println("The due date is not verified.");
				test.log(LogStatus.INFO, "The due date is not verified.");
				Reporter.log("The due date is not verified.");
				log.info("The due date is not verified.");
			}

			// verify the priority of the auto generated task 1
			switchVerification("survey_autotask1_priority1_risk_XPATH", "High",
					"The high priority task is not displayed.");

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

		// UPDATE THE AUTO GENERATED TASK DETAILS FROM THE TASK MODULE

		System.out.println(
				"***************** UPDATE THE AUTO GENERATED TASK DETAILS FROM THE TASK MODULE *****************");
		test.log(LogStatus.INFO,
				"***************** UPDATE THE AUTO GENERATED TASK DETAILS FROM THE TASK MODULE *****************");
		Reporter.log("***************** UPDATE THE AUTO GENERATED TASK DETAILS FROM THE TASK MODULE *****************");
		log.info("***************** UPDATE THE AUTO GENERATED TASK DETAILS FROM THE TASK MODULE *****************");

		try {
			// enter the property name in the search field
			type("envreports_propertylist_filtertxt_CSS", data.get("property_1"));
			ngDriver.waitForAngularRequestsToFinish();
			System.out.println("Entered the property name in the search field.");

			// click on the task icon from the property list page
			click("taskicon_CSS");
			System.out.println("Clicked on the task icon of the Property.");
			ngDriver.waitForAngularRequestsToFinish();
			System.out.println("Navigate to the task screen of the perticular property.");

			// wait for the clear button
			explicitWaitClickable("task_clearbtn_XPATH");

			// click on the clear button
			click("task_clearbtn_XPATH");
			ngDriver.waitForAngularRequestsToFinish();
			System.out.println("Clicked on the clear button.");

			// enter auto generated task in the search field
			type("survey_task_searchfield_CSS", data.get("autotask_1"));
			ngDriver.waitForAngularRequestsToFinish();
			System.out.println("enter auto generated task in the search field.");

			// click on the search button
			click("survey_task_searchfield_CSS");
			ngDriver.waitForAngularRequestsToFinish();
			System.out.println("Clicked on the search button.");

			// verify the auto generated task 1
			switchVerification("survey_autotask1_risk_XPATH", "Risk Control Management System",
					"The Risk Control Management System task is not displayed.");

			// click on the auto generated task
			click("survey_autotask1_risk_XPATH");
			ngDriver.waitForAngularRequestsToFinish();
			System.out.println("Clicked on the auto generated task.");

			// verify the details of the description field

			try {
				String description1 = driver
						.findElement(By.xpath(OR.getProperty("survey_autotask1_descriptiontxt_risk_XPATH")))
						.getAttribute("value");

				if (description1.equals(data.get("auto_description1"))) {
					System.out.println("The description is verified successfully.");
					test.log(LogStatus.INFO, "The description is verified successfully.");
					Reporter.log("The description is verified successfully.");
					log.info("The description is verified successfully.");
				} else {

					verificationFailed();
					System.out.println("The description is not verified.");
					test.log(LogStatus.INFO, "The description is not verified.");
					Reporter.log("The description is not verified.");
					log.info("The description is not verified.");

				}
			} catch (Throwable t) {
				verificationFailed();
				System.out.println("The description is not verified.");
				test.log(LogStatus.INFO, "The description is not verified.");
				Reporter.log("The description is not verified.");
				log.info("The description is not verified.");
			}

			// click on the assign to field
			click("survey_autotask1_assigneebtn_risk_XPATH");
			ngDriver.waitForAngularRequestsToFinish();
			System.out.println("Clicked on the assign to field.");

			// enter the user name in the search field
			clear("task_tasklist_tagfilter_tagtxt_searchtxt_XPATH");
			type("task_tasklist_tagfilter_tagtxt_searchtxt_XPATH", data.get("checklist_search_1"));
			ngDriver.waitForAngularRequestsToFinish();
			System.out.println("Entered the user name in the search field.");

			// click on the searched user
			click("questionnaire_createtask_selectusertxt_XPATH");
			ngDriver.waitForAngularRequestsToFinish();
			System.out.println("Clicked on the searched user.");

			// click on the assign to field
			click("survey_autotask1_assigneebtn_risk_XPATH");
			ngDriver.waitForAngularRequestsToFinish();
			System.out.println("Clicked on the assign to field.");

			// scroll down the screen
			JavascriptExecutor js = (JavascriptExecutor) driver;
			js.executeScript("window.scrollBy(0,200)");

			// update the priority of the task
			select("survey_autotask1_prioritydd_risk_XPATH", data.get("auto_Priority2"));
			ngDriver.waitForAngularRequestsToFinish();
			System.out.println("Updated the priority of the task.");

			// click on the change due date button
			click("task_tasktag_changeduedatebtn_CSS");
			ngDriver.waitForAngularRequestsToFinish();
			System.out.println("Clicked on the change due date button.");

			// enter date which is 2 days before current date
			LocalDate date2 = LocalDate.now().plusMonths(6);
			String date2_String = date2.toString();
			type("task_tasktag_changeduedate_newduedate_XPATH", date2_String);
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

			// click on the update button
			click("environmental_task_submitbtn_XPATH");
			ngDriver.waitForAngularRequestsToFinish();
			System.out.println("Clicked on the update button.");

			// click on the back button
			click("task_addtask_backbtn_XPATH");
			ngDriver.waitForAngularRequestsToFinish();
			System.out.println("Clicked on the back button.");

			// click on the clear button
			click("task_clearbtn_XPATH");
			ngDriver.waitForAngularRequestsToFinish();
			System.out.println("Clicked on the clear button.");

			// enter auto generated task in the search field
			type("survey_task_searchfield_CSS", data.get("autotask_1"));
			ngDriver.waitForAngularRequestsToFinish();
			System.out.println("enter auto generated task in the search field.");

			// click on the search button
			click("survey_task_searchfield_CSS");
			ngDriver.waitForAngularRequestsToFinish();
			System.out.println("Clicked on the search button.");

			// verify the auto generated task 1
			switchVerification("survey_autotask1_risk_XPATH", "Risk Control Management System",
					"The Risk Control Management System task is not displayed.");

			// verify the assignee name of the auto generated task 1
			switchVerification("survey_autotask1_assignee2_risk_XPATH", "Property Manager, Jinesh",
					"The Property Manager, Jinesh task is not displayed.");

			// verify the due date of the auto generated task 1

			try {
				LocalDate date22 = LocalDate.now().plusMonths(6);
				String date22_String = date22.toString();

				String todayDueDate22 = "//p[text()='Risk Control Management System']//parent::td[@ng-click='editTaskFromLandingPage(task)']//following-sibling::td[text()='"
						+ date22_String + "']";

				if (date22_String.equals(todayDueDate22)) {
					System.out.println("The due date is verified successfully.");
					test.log(LogStatus.INFO, "The due date is verified successfully.");
					Reporter.log("The due date is verified successfully.");
					log.info("The due date is verified successfully.");
				} else {
					verificationFailed();
					System.out.println("The due date is not verified.");
					test.log(LogStatus.INFO, "The due date is not verified.");
					Reporter.log("The due date is not verified.");
					log.info("The due date is not verified.");

				}
			} catch (Throwable t) {
				verificationFailed();
				System.out.println("The due date is not verified.");
				test.log(LogStatus.INFO, "The due date is not verified.");
				Reporter.log("The due date is not verified.");
				log.info("The due date is not verified.");
			}

			// verify the priority of the auto generated task 1
			switchVerification("survey_autotask1_priority2_risk_XPATH", "Urgent",
					"The Urgent priority task is not displayed.");

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

		// VALIDATE UPDATED DETAILS OF THE TASK IN SURVEY

		System.out.println("***************** VALIDATE UPDATED DETAILS OF THE TASK IN SURVEY *****************");
		test.log(LogStatus.INFO, "***************** VALIDATE UPDATED DETAILS OF THE TASK IN SURVEY *****************");
		Reporter.log("***************** VALIDATE UPDATED DETAILS OF THE TASK IN SURVEY *****************");
		log.info("***************** VALIDATE UPDATED DETAILS OF THE TASK IN SURVEY *****************");

		try {

			// enter the property name in the search field
			type("envreports_propertylist_filtertxt_CSS", data.get("property_1"));
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

			// click on the surveys option from side menu
			click("surveyoption_XPATH");
			System.out.println("Clicked on the surveys option from side menu");
			ngDriver.waitForAngularRequestsToFinish();
			System.out.println("Navigate to the csurveys screen");

			// wait for 3 seconds
			Thread.sleep(3000);

			// select the respective questionnaire
			select("survey_questionnairedd_CSS", data.get("questionnaire_title"));
			ngDriver.waitForAngularRequestsToFinish();
			System.out.println("Selected the respective questionnaire.");

			// wait for the element
			explicitWait("survey_categoryname_risk_XPATH");

			// wait for the element
			Thread.sleep(5000);

			// scroll down the screen
			JavascriptExecutor js = (JavascriptExecutor) driver;
			js.executeScript("window.scrollBy(0,600)");

			// verify validation 1
			switchVerification("survey_autotask_validation1_risk_XPATH", "Task/Action",
					"The Task/Action text is not displayed.");

			// verify validation 2
			switchVerification("survey_autotask_validation2_risk_XPATH", "(1) Risk Control Management System",
					"The (1) Risk Control Management System text is not displayed.");

			// verify validation 3
			switchVerification("survey_autotask_validation33_risk_XPATH", "Assigned To: Property Manager, Jinesh",
					"The Assigned To Property Manager, Jinesh text is not displayed.");

			// verify the priority of the task
			try {
				String prority1 = driver
						.findElement(By.xpath(OR.getProperty("survey_autotask1_validation7_risk_XPATH"))).getText();

				if (prority1.equals("Urgent")) {

					successMessage("The priority of the task is displayed correctly.");

				} else {
					verificationFailedMessage("The priority of the task is displayed incorrect.");
				}

			} catch (Throwable t) {
				verificationFailedMessage("The priority of the task is displayed incorrect.");
			}

			// verify validation 4
			LocalDate date3 = LocalDate.now().plusMonths(6);
			String date3_String = date3.toString();

			try {
				String duedate = (driver.findElement(By.xpath(OR.getProperty("survey_autotask_validation5_risk_XPATH")))
						.getAttribute("value")).trim();

				if (duedate.equals(date3_String)) {

					System.out.println("The due date is verified successfully.");
					test.log(LogStatus.INFO, "The due date is verified successfully.");
					Reporter.log("The due date is verified successfully.");
					log.info("The due date is verified successfully.");
				} else {
					verificationFailed();
				}
			} catch (Throwable t) {
				verificationFailedMessage("The due date is displayed incorrect.");
			}

		} catch (Throwable t) {
			verificationFailedMessage("The due date is displayed incorrect.");
		}

		// click on the home icon from the top of the screen
		click("questionnaire_homeburgermenubtn_hide_CSS");
		System.out.println("Clicked on the home icon from the top of the screen.");
		ngDriver.waitForAngularRequestsToFinish();

		// synchronization
		explicitWait("propertylist_title_XPATH");

		// verify the property list
		switchVerification("propertylist_title_XPATH", "Property List", "The property list is not displayed.");

		// REMOVE THE DETAILS FROM THE COMMENT BOXES

		System.out.println("***************** REMOVE THE DETAILS FROM THE COMMENT BOXES *****************");
		test.log(LogStatus.INFO, "***************** REMOVE THE DETAILS FROM THE COMMENT BOXES *****************");
		Reporter.log("***************** REMOVE THE DETAILS FROM THE COMMENT BOXES *****************");
		log.info("***************** REMOVE THE DETAILS FROM THE COMMENT BOXES *****************");

		try {

			// enter the property name in the search field
			type("envreports_propertylist_filtertxt_CSS", data.get("property_1"));
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

			// click on the surveys option from side menu
			click("surveyoption_XPATH");
			System.out.println("Clicked on the surveys option from side menu");
			ngDriver.waitForAngularRequestsToFinish();
			System.out.println("Navigate to the csurveys screen");

			// wait for 3 seconds
			Thread.sleep(3000);

			// select the respective questionnaire
			select("survey_questionnairedd_CSS", data.get("questionnaire_title"));
			ngDriver.waitForAngularRequestsToFinish();
			System.out.println("Selected the respective questionnaire.");

			// wait for the element
			explicitWait("survey_categoryname_risk_XPATH");

			// clear the details in the comment box 1 of the category 1 question 1
			clear("survey_commentbox1_risk_XPATH");

			// clear the details in the comment box 2 of the category 1 question 1
			clear("survey_commentbox2_risk_XPATH");

			// click on the Managing Agent Systems category label
			click("survey_categoryname_risk_XPATH");
			ngDriver.waitForAngularRequestsToFinish();
			System.out.println("Clicked on the Managing Agent Systems category label.");

			// wait for the element
			Thread.sleep(5000);

			// scroll down the screen
			JavascriptExecutor js = (JavascriptExecutor) driver;
			js.executeScript("window.scrollBy(0,400)");

			// verify validation 2
			deleteVerification("survey_autotask_validation2_risk_XPATH", "(1) Risk Control Management System");

			// scroll down the screen
			js.executeScript("window.scrollBy(0,300)");

			// clear the details in the comment box 1 of the category 1 question 2
			clear("survey_commentbox3_risk_XPATH");

			// clear the details in the comment box 2 of the category 1 question 2
			clear("survey_commentbox4_risk_XPATH");

			// click on the Hazardous Building Materials category label
			click("survey_categoryname2_risk_XPATH");
			ngDriver.waitForAngularRequestsToFinish();
			System.out.println("Clicked on the Hazardous Building Materials category label.");

			// wait for the element
			Thread.sleep(5000);

			// verify validation 4
			deleteVerification("survey_autotask_validation4_risk_XPATH", "(1) Contractor Management System");

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

		// VALIDATE REMOVED THE AUTO GENERATED TASKS IN THE TASK MODULE

		System.out.println(
				"******************** VALIDATE REMOVED THE AUTO GENERATED TASKS IN THE TASK MODULE ********************");
		test.log(LogStatus.INFO,
				"******************** VALIDATE REMOVED THE AUTO GENERATED TASKS IN THE TASK MODULE ********************");
		Reporter.log(
				"******************** VALIDATE REMOVED THE AUTO GENERATED TASKS IN THE TASK MODULE ********************");
		log.info(
				"******************** VALIDATE REMOVED THE AUTO GENERATED TASKS IN THE TASK MODULE ********************");

		try {
			// enter the property name in the search field
			type("envreports_propertylist_filtertxt_CSS", data.get("property_1"));
			ngDriver.waitForAngularRequestsToFinish();
			System.out.println("Entered the property name in the search field.");

			// click on the task icon from the property list page
			click("taskicon_CSS");
			System.out.println("Clicked on the task icon of the Property.");
			ngDriver.waitForAngularRequestsToFinish();
			System.out.println("Navigate to the task screen of the perticular property.");

			// wait for the clear button
			explicitWaitClickable("task_clearbtn_XPATH");

			// click on the clear button
			click("task_clearbtn_XPATH");
			ngDriver.waitForAngularRequestsToFinish();
			System.out.println("Clicked on the clear button.");

			// enter auto generated task in the search field
			type("survey_task_searchfield_CSS", data.get("autotask_1"));
			ngDriver.waitForAngularRequestsToFinish();
			System.out.println("enter auto generated task in the search field.");

			// click on the search button
			click("survey_task_searchfield_CSS");
			ngDriver.waitForAngularRequestsToFinish();
			System.out.println("Clicked on the search button.");

			// verify the auto generated task 1
			deleteVerification("survey_autotask1_risk_XPATH", "Risk Control Management System");

			// click on the clear button
			click("task_clearbtn_XPATH");
			ngDriver.waitForAngularRequestsToFinish();
			System.out.println("Clicked on the clear button.");

			// enter auto generated task in the search field
			type("survey_task_searchfield_CSS", data.get("autotask_2"));
			ngDriver.waitForAngularRequestsToFinish();
			System.out.println("enter auto generated task in the search field.");

			// click on the search button
			click("survey_task_searchfield_CSS");
			ngDriver.waitForAngularRequestsToFinish();
			System.out.println("Clicked on the search button.");

			// verify the auto generated task 2
			deleteVerification("survey_autotask2_risk_XPATH", "Contractor Management System");

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
			// wait for the 5 seconds
			Thread.sleep(5000);

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
