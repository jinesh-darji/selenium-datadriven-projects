package testcases.smokesuite;

import java.io.IOException;
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

import base.Helper;
import base.TestBase;
import utilities.TestUtil;

public class RR5368Capreit2Test extends TestBase {

	@Test(dataProviderClass = TestUtil.class, dataProvider = "dp")
	public void rR5368Capreit2Test(Hashtable<String, String> data) throws IOException, InterruptedException {

		if (!(TestUtil.isTestRunnable("rR5368Capreit2Test", excel))) {

			throw new SkipException(
					"Skipping the test " + "rR5368Capreit2Test".toUpperCase() + "as the Run mode is NO");
		}

		if (!data.get("runmode").equals("Y")) {

			throw new SkipException("Skipping the test case as the Run Mode for data set is NO");
		}

		Helper helper = new Helper();

		// refresh the page
		driver.navigate().refresh();
		Thread.sleep(5000);
		driver.navigate().refresh();

		System.out.println("Navigate to the Home Screen i.e. Property List Screen.");

		// PERFORM THE TEST CASES OF THE CAPREIT - PROPERTY MANAGER : OPEN TASKS FROM
		// PRIOR CHECKLIST INSTANCE MUST REMAIN VISIBLE (RR-2929)

		System.out.println(
				"******************** PERFORM THE TEST CASES OF THE CAPREIT - PROPERTY MANAGER : OPEN TASKS FROM PRIOR CHECKLIST INSTANCE MUST REMAIN VISIBLE (RR-2929) ********************");
		test.log(LogStatus.INFO,
				"******************** PERFORM THE TEST CASES OF THE CAPREIT - PROPERTY MANAGER : OPEN TASKS FROM PRIOR CHECKLIST INSTANCE MUST REMAIN VISIBLE (RR-2929) ********************");
		Reporter.log(
				"******************** PERFORM THE TEST CASES OF THE CAPREIT - PROPERTY MANAGER : OPEN TASKS FROM PRIOR CHECKLIST INSTANCE MUST REMAIN VISIBLE (RR-2929) ********************");
		log.info(
				"******************** PERFORM THE TEST CASES OF THE CAPREIT - PROPERTY MANAGER : OPEN TASKS FROM PRIOR CHECKLIST INSTANCE MUST REMAIN VISIBLE (RR-2929) ********************");

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

			// CREATE THE NEW INSPECTION AND CHECKLIST (PROPERTY WITH BUILDING) - PROPERTY
			// MANAGER

			System.out.println(
					"******************** CREATE THE NEW INSPECTION AND CHECKLIST (PROPERTY WITH BUILDING) - PROPERTY MANAGER ********************");
			test.log(LogStatus.INFO,
					"******************** CREATE THE NEW INSPECTION AND CHECKLIST (PROPERTY WITH BUILDING) - PROPERTY MANAGER ********************");
			Reporter.log(
					"******************** CREATE THE NEW INSPECTION AND CHECKLIST (PROPERTY WITH BUILDING) - PROPERTY MANAGER ********************");
			log.info(
					"******************** CREATE THE NEW INSPECTION AND CHECKLIST (PROPERTY WITH BUILDING) - PROPERTY MANAGER ********************");

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

				// click on the checklist/inspection option from side menu
				click("checklist_sidemenu_XPATH");
				System.out.println("Clicked on the checklist/inspection option from side menu");
				ngDriver.waitForAngularRequestsToFinish();
				System.out.println("Navigate to the checklist/inspection screen");

				// select building from the property drop down
				select("envreports_movereports_propertydd_CSS", data.get("building_leveldropdown"));
				ngDriver.waitForAngularRequestsToFinish();
				System.out.println("Selected building from the property drop down.");

				// wait for 5 seconds
				Thread.sleep(5000);

				// click on the new checklist button
				click("checklist_newchecklistbtn_CSS");
				System.out.println("Clicked on the new checklist button.");
				ngDriver.waitForAngularRequestsToFinish();

				// wait for the element
				explicitWait("checklist_addchecklist_checklisttypedd_CSS");

				// select the questionnaire option from the checklist type dropdown
				select("checklist_addchecklist_checklisttypedd_CSS", data.get("questionnaire_checklist_title"));
				System.out.println("The created questionaaire is selected from the checklist type dropdown.");
				ngDriver.waitForAngularRequestsToFinish();

				// enter data in the checklist title field
				type("checklist_addchecklist_titletxt_CSS", data.get("checklist_property_title"));
				System.out.println("Entered the data in the checklist title field.");
				ngDriver.waitForAngularRequestsToFinish();

				// click on the save button
				click("checklist_addchecklist_savebtn_CSS");
				System.out.println("Clicked on the save button.");
				ngDriver.waitForAngularRequestsToFinish();

				// click on the switch to wizard mode button
				click("checklist_classicviewbtn_CSS");
				ngDriver.waitForAngularRequestsToFinish();
				System.out.println("Clicked on the switch to wizard mode button.");

				// click on the no option of the 1st question
				click("checklist_wizard_nooption_CSS");
				ngDriver.waitForAngularRequestsToFinish();
				System.out.println("Clicked on the no option of the 1st question.");

				// click on the back button
				click("questionnaire_checklist_backbtn_CSS");
				ngDriver.waitForAngularRequestsToFinish();
				System.out.println("Clicked on the back button.");

				// enter newly created inspection in the search field
				type("task_listofchecklist_filterfield_CSS", data.get("checklist_property_title"));
				ngDriver.waitForAngularRequestsToFinish();
				System.out.println("Entered newly created inspection in the search field.");

				// verify submitted inspection is displayed or not
				switchVerification("questionnaire_checklist_createdinspectioncovid19_group_2_XPATH",
						"Test Questionnaire Property Title Group Smoke Capreit Two",
						"The Test Questionnaire Property Title Group Smoke Capreit Two is not displayed.");

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

			// ADD THE TASK IN COVID 19 INSPECTION - PROPERTY MANAGER

			System.out.println(
					"******************** ADD THE TASK IN COVID 19 INSPECTION - PROPERTY MANAGER ********************");
			test.log(LogStatus.INFO,
					"******************** ADD THE TASK IN COVID 19 INSPECTION - PROPERTY MANAGER ********************");
			Reporter.log(
					"******************** ADD THE TASK IN COVID 19 INSPECTION - PROPERTY MANAGER ********************");
			log.info(
					"******************** ADD THE TASK IN COVID 19 INSPECTION - PROPERTY MANAGER ********************");

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

				// click on the checklist/inspection option from side menu
				click("checklist_sidemenu_XPATH");
				System.out.println("Clicked on the checklist/inspection option from side menu");
				ngDriver.waitForAngularRequestsToFinish();
				System.out.println("Navigate to the checklist/inspection screen");

				// select property from the property drop down
				select("envreports_movereports_propertydd_CSS", data.get("building_leveldropdown"));
				ngDriver.waitForAngularRequestsToFinish();
				System.out.println("Selected property from the property drop down.");

				// wait for 5 seconds
				Thread.sleep(5000);

				// enter newly created inspection in the search field
				type("task_listofchecklist_filterfield_CSS", data.get("checklist_property_title"));
				ngDriver.waitForAngularRequestsToFinish();
				System.out.println("Entered newly created inspection in the search field.");

				// click on the searched inspection
				click("questionnaire_checklist_createdinspectioncovid19_group_2_XPATH");
				ngDriver.waitForAngularRequestsToFinish();
				System.out.println("Clicked on the searched inspection.");

				// click on the switch to wizard mode button
				click("checklist_classicviewbtn_CSS");
				ngDriver.waitForAngularRequestsToFinish();
				System.out.println("Clicked on the switch to wizard mode button.");

				// click on the task tab
				click("inspectionchecklist_tasktab_XPATH");
				ngDriver.waitForAngularRequestsToFinish();
				System.out.println("Clicked on the task tab.");

				// click on the new task button
				click("checklist_newtaskbtn_CSS");
				ngDriver.waitForAngularRequestsToFinish();
				System.out.println("Clicked on the new task button.");

				// click on the task type field
				click("task_permission_task_tasktypetxt_CSS");
				ngDriver.waitForAngularRequestsToFinish();
				System.out.println("Clicked on the task type field.");

				// enter task type in the search field
				type("inspectionchecklist_tasktagsearchfield_CSS", data.get("tasktag"));
				ngDriver.waitForAngularRequestsToFinish();
				System.out.println("Entered task type in the search field.");

				// click on the searched task tag
				click("inspectionchecklist_tasktagsearchedresult_XPATH");
				ngDriver.waitForAngularRequestsToFinish();
				System.out.println("Clicked on the searched task tag.");

				// verify correct task title is displayed correct or not
				try {
					String taskTitle1 = driver.findElement(By.cssSelector(OR.getProperty("task_addtask_titletxt_CSS")))
							.getAttribute("value");

					if (taskTitle1.equals("Electrical (Light Fixture)")) {
						System.out.println("THE CORRECT TASK TITLE IS DISPLAYED.");
						test.log(LogStatus.INFO, "THE CORRECT TASK TITLE IS DISPLAYED.");
						Reporter.log("THE CORRECT TASK TITLE IS DISPLAYED.");
						log.info("THE CORRECT TASK TITLE IS DISPLAYED.");
					} else {
						TestUtil.captureScreenshot();

						// ReportNG
						Reporter.log("<br>" + " The task title is not displayed correctly : " + "<br>");
						Reporter.log("<a target=\"_blank\" href=" + TestUtil.screenshotName + "><img src="
								+ TestUtil.screenshotName + " height=200 width=200></img></a>");
						Reporter.log("<br>");
						Reporter.log("<br>");

						// Extent Report
						test.log(LogStatus.FAIL, " The task title is not displayed correctly : ");
						test.log(LogStatus.FAIL, test.addScreenCapture(TestUtil.screenshotName));

						System.out.println("The task title is not displayed correctly.");
						log.info("The task title is not displayed correctly.");
					}

				} catch (Throwable t) {
					TestUtil.captureScreenshot();

					// ReportNG
					Reporter.log("<br>" + " The task title is not displayed correctly : " + "<br>");
					Reporter.log("<a target=\"_blank\" href=" + TestUtil.screenshotName + "><img src="
							+ TestUtil.screenshotName + " height=200 width=200></img></a>");
					Reporter.log("<br>");
					Reporter.log("<br>");

					// Extent Report
					test.log(LogStatus.FAIL, " The task title is not displayed correctly : ");
					test.log(LogStatus.FAIL, test.addScreenCapture(TestUtil.screenshotName));

					System.out.println("The task title is not displayed correctly.");
					log.info("The task title is not displayed correctly.");

				}

				// click on the save task button
				click("survey_task_savebtn_CSS");
				ngDriver.waitForAngularRequestsToFinish();
				System.out.println("Clicked on the save task button.");

				// verify newly created task is displayed or not
				switchVerification("inspectionchecklist_tasktagcreatedtask_XPATH", "Electrical (Light Fixture)",
						"The Electrical (Light Fixture) is not displayed.");

			} catch (Throwable t) {
				verificationFailed();
			}

			// click on the Home button
			click("questionnaire_homeburgermenubtn_hide_CSS");
			System.out.println("Clicked on the home button.");
			ngDriver.waitForAngularRequestsToFinish();
			System.out.println("Navigate to the Home Screen i.e. property listing screen.");

			// wait for the element
			explicitWait("propertylist_title_XPATH");

			// verify the property list
			switchVerification("propertylist_title_XPATH", "Property List", "The property list is not displayed.");

			try {

				// LOGOUT FROM PROPERTY MANAGER USER

				System.out.println("**************** LOGOUT FROM PROPERTY MANAGER USER ****************");
				test.log(LogStatus.INFO, "**************** LOGOUT FROM PROPERTY MANAGER USER ****************");
				Reporter.log("**************** LOGOUT FROM PROPERTY MANAGER USER ****************");
				log.info("**************** LOGOUT FROM PROPERTY MANAGER USER ****************");

				// wait for 5 seconds
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

				// LOGIN IN WITH OPERATION MANAGER USER

				System.out.println("**************** LOGIN IN WITH OPERATION MANAGER USER ****************");
				test.log(LogStatus.INFO, "**************** LOGIN IN WITH OPERATION MANAGER USER ****************");
				Reporter.log("**************** LOGIN IN WITH OPERATION MANAGER USER ****************");
				log.info("**************** LOGIN IN WITH OPERATION MANAGER USER ****************");

				// Enter the username
				ngDriver.waitForAngularRequestsToFinish();
				type("username_MODEL", data.get("username_2"));

				// Enter the password
				type("password_MODEL", data.get("password_2"));

				// Clicking on the "Sign In" button
				click("signinbtn_BTNTEXT");
				ngDriver.waitForAngularRequestsToFinish();

				// wait for the element
				explicitWait("propertylist_title_XPATH");

				// verify the property list
				switchVerification("propertylist_title_XPATH", "Property List", "The property list is not displayed.");

				// UPDATE THE SYSTEM COMPANY
				updateCompany(data);

			} catch (Throwable t) {
				verificationFailed();
			}

			// CREATE THE NEW INSPECTION AND CHECKLIST (PROPERTY WITH BUILDING) - OPERATION
			// MANAGER

			System.out.println(
					"******************** CREATE THE NEW INSPECTION AND CHECKLIST (PROPERTY WITH BUILDING) - OPERATION MANAGER ********************");
			test.log(LogStatus.INFO,
					"******************** CREATE THE NEW INSPECTION AND CHECKLIST (PROPERTY WITH BUILDING) - OPERATION MANAGER ********************");
			Reporter.log(
					"******************** CREATE THE NEW INSPECTION AND CHECKLIST (PROPERTY WITH BUILDING) - OPERATION MANAGER ********************");
			log.info(
					"******************** CREATE THE NEW INSPECTION AND CHECKLIST (PROPERTY WITH BUILDING) - OPERATION MANAGER ********************");

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

				// click on the checklist/inspection option from side menu
				click("checklist_sidemenu_XPATH");
				System.out.println("Clicked on the checklist/inspection option from side menu");
				ngDriver.waitForAngularRequestsToFinish();
				System.out.println("Navigate to the checklist/inspection screen");

				// select building from the property drop down
				select("envreports_movereports_propertydd_CSS", data.get("building_leveldropdown"));
				ngDriver.waitForAngularRequestsToFinish();
				System.out.println("Selected building from the property drop down.");

				// wait for 5 seconds
				Thread.sleep(5000);

				// click on the new checklist button
				click("checklist_newchecklistbtn_CSS");
				System.out.println("Clicked on the new checklist button.");
				ngDriver.waitForAngularRequestsToFinish();

				// wait for the element
				explicitWait("checklist_addchecklist_checklisttypedd_CSS");

				// select the questionnaire option from the checklist type dropdown
				select("checklist_addchecklist_checklisttypedd_CSS", data.get("questionnaire_checklist_om_title"));
				System.out.println("The created questionaaire is selected from the checklist type dropdown.");
				ngDriver.waitForAngularRequestsToFinish();

				// enter data in the checklist title field
				type("checklist_addchecklist_titletxt_CSS", data.get("checklist_property_om_title"));
				System.out.println("Entered the data in the checklist title field.");
				ngDriver.waitForAngularRequestsToFinish();

				// click on the save button
				click("checklist_addchecklist_savebtn_CSS");
				System.out.println("Clicked on the save button.");
				ngDriver.waitForAngularRequestsToFinish();

				// click on the back button
				click("questionnaire_checklist_backbtn_CSS");
				ngDriver.waitForAngularRequestsToFinish();
				System.out.println("Clicked on the back button.");

				// enter newly created inspection in the search field
				type("task_listofchecklist_filterfield_CSS", data.get("checklist_property_om_title"));
				ngDriver.waitForAngularRequestsToFinish();
				System.out.println("Entered newly created inspection in the search field.");

				// verify submitted inspection is displayed or not
				switchVerification("questionnaire_checklist_createdinspectioncovid19_groupom_2_XPATH",
						"Test Questionnaire Property Title Group OM Smoke Capreit Two",
						"The Test Questionnaire Property Title Group OM Smoke Capreit Two is not displayed.");

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

			// VERIFY CREATED TASK IS DISPLAYED IN THE SAME GROUP OF INSPECTION - OPERATION
			// MANAGER

			System.out.println(
					"**************** VERIFY CREATED TASK IS DISPLAYED IN THE SAME GROUP OF INSPECTION - OPERATION MANAGER ****************");
			test.log(LogStatus.INFO,
					"**************** VERIFY CREATED TASK IS DISPLAYED IN THE SAME GROUP OF INSPECTION - OPERATION MANAGER ****************");
			Reporter.log(
					"**************** VERIFY CREATED TASK IS DISPLAYED IN THE SAME GROUP OF INSPECTION - OPERATION MANAGER ****************");
			log.info(
					"**************** VERIFY CREATED TASK IS DISPLAYED IN THE SAME GROUP OF INSPECTION - OPERATION MANAGER ****************");

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

				// click on the checklist/inspection option from side menu
				click("checklist_sidemenu_XPATH");
				System.out.println("Clicked on the checklist/inspection option from side menu");
				ngDriver.waitForAngularRequestsToFinish();
				System.out.println("Navigate to the checklist/inspection screen");

				// select building from the property drop down
				select("envreports_movereports_propertydd_CSS", data.get("building_leveldropdown"));
				ngDriver.waitForAngularRequestsToFinish();
				System.out.println("Selected building from the property drop down.");

				// wait for 5 seconds
				Thread.sleep(5000);

				// enter newly created inspection in the search field
				type("task_listofchecklist_filterfield_CSS", data.get("checklist_property_om_title"));
				ngDriver.waitForAngularRequestsToFinish();
				System.out.println("Entered newly created inspection in the search field.");

				// verify submitted inspection is displayed or not
				switchVerification("questionnaire_checklist_createdinspectioncovid19_groupom_2_XPATH",
						"Test Questionnaire Property Title Group OM Smoke Capreit Two",
						"The Test Questionnaire Property Title Group OM Smoke Capreit Two is not displayed.");

				// click on the searched inspection
				click("questionnaire_checklist_createdinspectioncovid19_groupom_2_XPATH");
				ngDriver.waitForAngularRequestsToFinish();
				System.out.println("Clicked on the searched inspection.");

				// click on the switch to wizard mode button
				click("checklist_classicviewbtn_CSS");
				ngDriver.waitForAngularRequestsToFinish();
				System.out.println("Clicked on the switch to wizard mode button.");

				// click on the task tab
				click("inspectionchecklist_tasktab_XPATH");
				ngDriver.waitForAngularRequestsToFinish();
				System.out.println("Clicked on the task tab.");

				// scroll down the screen
				JavascriptExecutor js = (JavascriptExecutor) driver;
				js.executeScript("window.scrollBy(0,400)");

//				// verify the auto generated task is displayed or not
//				switchVerification("checklist_taskone_pending_capreitone_XPATH", "Pending",
//						"The Pending status is not displayed");
//
//				// verify the newly created task is displayed or not
//				switchVerification("checklist_tasktwo_pending_capreitone_XPATH", "Pending",
//						"The Pending status is not displayed");

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

			// LOGOUT FROM THE OPERATION MANAGER USER

			System.out.println("**************** LOGOUT FROM THE OPERATION MANAGER USER ****************");
			test.log(LogStatus.INFO, "**************** LOGOUT FROM THE OPERATION MANAGER USER ****************");
			Reporter.log("**************** LOGOUT FROM THE OPERATION MANAGER USER ****************");
			log.info("**************** LOGOUT FROM THE OPERATION MANAGER USER ****************");

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

			} catch (Throwable t) {
				verificationFailed();
			}

			// COMPLETE THE INSPECTION - PROPERTY MANAGER USER

			System.out.println("**************** COMPLETE THE INSPECTION - PROPERTY MANAGER USER ****************");
			test.log(LogStatus.INFO,
					"**************** COMPLETE THE INSPECTION - PROPERTY MANAGER USER ****************");
			Reporter.log("**************** COMPLETE THE INSPECTION - PROPERTY MANAGER USER ****************");
			log.info("**************** COMPLETE THE INSPECTION - PROPERTY MANAGER USER ****************");

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

				// click on the checklist/inspection option from side menu
				click("checklist_sidemenu_XPATH");
				System.out.println("Clicked on the checklist/inspection option from side menu");
				ngDriver.waitForAngularRequestsToFinish();
				System.out.println("Navigate to the checklist/inspection screen");

				// wait for the element
				Thread.sleep(5000);

				// select property from the property drop down
				select("envreports_movereports_propertydd_CSS", data.get("building_leveldropdown"));
				ngDriver.waitForAngularRequestsToFinish();
				System.out.println("Selected property from the property drop down.");

				// wait for 5 seconds
				Thread.sleep(5000);

				// enter newly created inspection in the search field
				clear("task_listofchecklist_filterfield_CSS");
				ngDriver.waitForAngularRequestsToFinish();
				System.out.println("Cleared the search field.");
				type("task_listofchecklist_filterfield_CSS", data.get("checklist_property_title"));
				ngDriver.waitForAngularRequestsToFinish();
				System.out.println("Entered newly created inspection in the search field.");

				// click on the searched inspection
				click("questionnaire_checklist_createdinspectioncovid19_group_2_XPATH");
				ngDriver.waitForAngularRequestsToFinish();
				System.out.println("Clicked on the searched inspection.");

				// click on the switch to wizard mode button
				click("checklist_classicviewbtn_CSS");
				ngDriver.waitForAngularRequestsToFinish();
				System.out.println("Clicked on the switch to wizard mode button.");

				// click on the next button from the 1st question
				click("checklist_wizard_nextbtn_CSS");
				ngDriver.waitForAngularRequestsToFinish();
				System.out.println("Clicked on the next button from the 1st question.");

				// click on the yes option of the 2nd question
				click("checklist_wizard_yesoption_CSS");
				ngDriver.waitForAngularRequestsToFinish();
				System.out.println("Clicked on the yes option of the 2nd question.");

				// click on the next button from the 2nd question
				click("checklist_wizard_nextbtn_CSS");
				ngDriver.waitForAngularRequestsToFinish();
				System.out.println("Clicked on the next button from the 2nd question.");

				// click on the next button from the 3rd question
				click("checklist_wizard_nextbtn_CSS");
				ngDriver.waitForAngularRequestsToFinish();
				System.out.println("Clicked on the next button from the 3rd question.");

				// click on the next button from the 4th question
				click("checklist_wizard_nextbtn_CSS");
				ngDriver.waitForAngularRequestsToFinish();
				System.out.println("Clicked on the next button from the 4th question.");

				// click on the next button from the 5th question
				click("checklist_wizard_nextbtn_CSS");
				ngDriver.waitForAngularRequestsToFinish();
				System.out.println("Clicked on the next button from the 5th question.");

				// click on the back button
				click("questionnaire_checklist_backbtn_CSS");
				ngDriver.waitForAngularRequestsToFinish();
				System.out.println("Clicked on the back button.");

				// enter newly created inspection in the search field
				clear("task_listofchecklist_filterfield_CSS");
				ngDriver.waitForAngularRequestsToFinish();
				System.out.println("Cleared the searched field.");
				type("task_listofchecklist_filterfield_CSS", data.get("checklist_property_title"));
				ngDriver.waitForAngularRequestsToFinish();
				System.out.println("Entered newly created inspection in the search field.");

				// verify submitted inspection is displayed or not
				switchVerification("questionnaire_checklist_createdinspectioncovid19_group_2_XPATH",
						"Test Questionnaire Property Title Group Smoke Capreit Two",
						"The Test Questionnaire Property Title Group Smoke Capreit Two is not displayed.");

			} catch (Throwable t) {
				verificationFailed();
			}

			// click on the home icon from the top of the screen
			click("questionnaire_homeburgermenubtn_hide_CSS");
			ngDriver.waitForAngularRequestsToFinish();
			System.out.println("Clicked on the home icon from the top of the screen.");

			// synchronization
			explicitWait("propertylist_title_XPATH");

			// verify the property list
			switchVerification("propertylist_title_XPATH", "Property List", "The property list is not displayed.");

			// CLOSE THE NEWLY CREATED TASK

			System.out
					.println("**************** CLOSE THE NEWLY CREATED TASK - PROPERTY MANAGER USER ****************");
			test.log(LogStatus.INFO,
					"**************** CLOSE THE NEWLY CREATED TASK - PROPERTY MANAGER USER ****************");
			Reporter.log("**************** CLOSE THE NEWLY CREATED TASK - PROPERTY MANAGER USER ****************");
			log.info("**************** CLOSE THE NEWLY CREATED TASK - PROPERTY MANAGER USER ****************");

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

				// click on the checklist/inspection option from side menu
				click("checklist_sidemenu_XPATH");
				System.out.println("Clicked on the checklist/inspection option from side menu");
				ngDriver.waitForAngularRequestsToFinish();
				System.out.println("Navigate to the checklist/inspection screen");

				// select property from the property drop down
				select("envreports_movereports_propertydd_CSS", data.get("building_leveldropdown"));
				ngDriver.waitForAngularRequestsToFinish();
				System.out.println("Selected property from the property drop down.");

				// wait for 5 seconds
				Thread.sleep(5000);

				// enter newly created inspection in the search field
				type("task_listofchecklist_filterfield_CSS", data.get("checklist_property_title"));
				ngDriver.waitForAngularRequestsToFinish();
				System.out.println("Entered newly created inspection in the search field.");

				// click on the searched inspection
				click("questionnaire_checklist_createdinspectioncovid19_group_2_XPATH");
				ngDriver.waitForAngularRequestsToFinish();
				System.out.println("Clicked on the searched inspection.");

				// click on the switch to wizard mode button
				click("checklist_classicviewbtn_CSS");
				ngDriver.waitForAngularRequestsToFinish();
				System.out.println("Clicked on the switch to wizard mode button.");

				// click on the task tab
				click("inspectionchecklist_tasktab_XPATH");
				ngDriver.waitForAngularRequestsToFinish();
				System.out.println("Clicked on the task tab.");

				// scroll down the screen
				JavascriptExecutor js = (JavascriptExecutor) driver;
				js.executeScript("window.scrollBy(0,500)");

				// click on the newly created task
				click("questionnaire_checklist_newlycreatedtask_capreit1_XPATH");
				ngDriver.waitForAngularRequestsToFinish();
				System.out.println("Clicked on the auto generated task.");

				// SET TASK AS A IN PROGRESS
				System.out.println("SET TASK AS A IN PROGRESS");
				test.log(LogStatus.INFO, "SET TASK AS A IN PROGRESS");
				Reporter.log("SET TASK AS A IN PROGRESS");
				log.info("SET TASK AS A IN PROGRESS");

				// wait for the element
				explicitWaitClickable("propertyproject_mu_repair_startbtn_CSS");

				// click on the start button
				click("propertyproject_mu_repair_startbtn_CSS");
				ngDriver.waitForAngularRequestsToFinish();
				System.out.println("Clicked on the start button.");

				// SET TASK AS A CLOSED
				System.out.println("SET TASK AS A CLOSED");
				test.log(LogStatus.INFO, "SET TASK AS A CLOSED");
				Reporter.log("SET TASK AS A CLOSED");
				log.info("SET TASK AS A CLOSED");

				// wait for the element
				explicitWaitClickable("task_addtask_backbtn_inspectiontask_XPATH");

				// click on the back button
				click("task_addtask_backbtn_inspectiontask_XPATH");
				ngDriver.waitForAngularRequestsToFinish();
				System.out.println("Clicked on the back button.");

				// click on the action icon of the approved task
				click("task_autotask_actionicon_XPATH");
				ngDriver.waitForAngularRequestsToFinish();
				System.out.println("Clicked on the action icon of the approved task.");

				// click on the complete task option
				click("task_addtask_approvedlbl_actionicon_closeoption_XPATH");
				ngDriver.waitForAngularRequestsToFinish();
				System.out.println("Clicked on the complete task option.");

				// wait for the element
				explicitWaitClickable("closetoastmsg_CSS");

				// click on the toaster close button
				click("closetoastmsg_CSS");
				ngDriver.waitForAngularRequestsToFinish();
				System.out.println("Clicked on the toaster close button.");

				// verify in closed status is display
				switchVerification("checklist_tasktwo_closed_capreitone_XPATH", "Closed",
						"The closed status is not displayed.");

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

			try {

				// LOGOUT FROM PROPERTY MANAGER USER

				System.out.println("**************** LOGOUT FROM PROPERTY MANAGER USER ****************");
				test.log(LogStatus.INFO, "**************** LOGOUT FROM PROPERTY MANAGER USER ****************");
				Reporter.log("**************** LOGOUT FROM PROPERTY MANAGER USER ****************");
				log.info("**************** LOGOUT FROM PROPERTY MANAGER USER ****************");

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

				// LOGIN IN WITH OPERATION MANAGER USER

				System.out.println("**************** LOGIN IN WITH OPERATION MANAGER USER ****************");
				test.log(LogStatus.INFO, "**************** LOGIN IN WITH OPERATION MANAGER USER ****************");
				Reporter.log("**************** LOGIN IN WITH OPERATION MANAGER USER ****************");
				log.info("**************** LOGIN IN WITH OPERATION MANAGER USER ****************");

				// Enter the username
				ngDriver.waitForAngularRequestsToFinish();
				type("username_MODEL", data.get("username_2"));

				// Enter the password
				type("password_MODEL", data.get("password_2"));

				// Clicking on the "Sign In" button
				click("signinbtn_BTNTEXT");
				ngDriver.waitForAngularRequestsToFinish();

				// wait for the element
				explicitWait("propertylist_title_XPATH");

				// verify the property list
				switchVerification("propertylist_title_XPATH", "Property List", "The property list is not displayed.");

				// UPDATE THE SYSTEM COMPANY

				updateCompany(data);

			} catch (Throwable t) {
				verificationFailed();
			}

			// VERIFY CLOSED TASK IS DISPLAYED IN THE SAME GROUP OF INSPECTION - OPERATION
			// MANAGER USER

			System.out.println(
					"**************** VERIFY CLOSED TASK IS DISPLAYED IN THE SAME GROUP OF INSPECTION - OPERATION MANAGER USER ****************");
			test.log(LogStatus.INFO,
					"**************** VERIFY CLOSED TASK IS DISPLAYED IN THE SAME GROUP OF INSPECTION - OPERATION MANAGER USER ****************");
			Reporter.log(
					"**************** VERIFY CLOSED TASK IS DISPLAYED IN THE SAME GROUP OF INSPECTION - OPERATION MANAGER USER ****************");
			log.info(
					"**************** VERIFY CLOSED TASK IS DISPLAYED IN THE SAME GROUP OF INSPECTION - OPERATION MANAGER USER ****************");

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
				Thread.sleep(7000);

				// click on the checklist/inspection option from side menu
				click("checklist_sidemenu_XPATH");
				System.out.println("Clicked on the checklist/inspection option from side menu");
				ngDriver.waitForAngularRequestsToFinish();
				System.out.println("Navigate to the checklist/inspection screen");

				// select building from the property drop down
				select("envreports_movereports_propertydd_CSS", data.get("building_leveldropdown"));
				ngDriver.waitForAngularRequestsToFinish();
				System.out.println("Selected building from the property drop down.");

				// wait for 5 seconds
				Thread.sleep(5000);

				// enter newly created inspection in the search field
				clear("task_listofchecklist_filterfield_CSS");
				ngDriver.waitForAngularRequestsToFinish();
				System.out.println("Cleared the search field.");
				type("task_listofchecklist_filterfield_CSS", data.get("checklist_property_om_title"));
				ngDriver.waitForAngularRequestsToFinish();
				System.out.println("Entered newly created inspection in the search field.");

				// verify submitted inspection is displayed or not
				switchVerification("questionnaire_checklist_createdinspectioncovid19_groupom_2_XPATH",
						"Test Questionnaire Property Title Group OM Smoke Capreit Two",
						"The Test Questionnaire Property Title Group OM Smoke Capreit Two is not displayed.");

				// click on the searched inspection
				click("questionnaire_checklist_createdinspectioncovid19_groupom_2_XPATH");
				ngDriver.waitForAngularRequestsToFinish();
				System.out.println("Clicked on the searched inspection.");

				// click on the switch to wizard mode button
				click("checklist_classicviewbtn_CSS");
				ngDriver.waitForAngularRequestsToFinish();
				System.out.println("Clicked on the switch to wizard mode button.");

				// click on the task tab
				click("inspectionchecklist_tasktab_XPATH");
				ngDriver.waitForAngularRequestsToFinish();
				System.out.println("Clicked on the task tab.");

				// scroll down the screen
				JavascriptExecutor js = (JavascriptExecutor) driver;
				js.executeScript("window.scrollBy(0,400)");
//
//				// verify the auto generated task is displayed or not
//				switchVerification("checklist_taskone_pending_capreitone_XPATH", "Pending",
//						"The Pending status is not displayed");

				// verify the newly created task is displayed or not

				try {
					String str1 = driver
							.findElement(
									By.xpath(OR.getProperty("questionnaire_checklist_newlycreatedtask_capreit1_XPATH")))
							.getText();
					ngDriver.waitForAngularRequestsToFinish();

					if (str1.equals("Electrical (Light Fixture)")) {
						TestUtil.captureScreenshot();

						// ReportNG
						Reporter.log("<br>" + "The newly created task is not removed. : " + "<br>");
						Reporter.log("<a target=\"_blank\" href=" + TestUtil.screenshotName + "><img src="
								+ TestUtil.screenshotName + " height=200 width=200></img></a>");
						Reporter.log("<br>");
						Reporter.log("<br>");

						// Extent Report
						test.log(LogStatus.FAIL, " The newly created task is not removed. : ");
						test.log(LogStatus.FAIL, test.addScreenCapture(TestUtil.screenshotName));

						System.out.println("The newly created task is not removed.");
						log.info("The newly created task is not removed.");

					}

				} catch (Throwable t) {

					System.out.println("The newly created task is removed successfully as expected.");
					test.log(LogStatus.INFO, "The newly created task is removed successfully as expected.");
					Reporter.log("The newly created task is removed successfully as expected.");
					log.info("The newly created task is removed successfully as expected.");
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

			// LOGOUT FROM THE OPERATION MANAGER USER

			System.out.println("**************** LOGOUT FROM THE OPERATION MANAGER USER ****************");
			test.log(LogStatus.INFO, "**************** LOGOUT FROM THE OPERATION MANAGER USER ****************");
			Reporter.log("**************** LOGOUT FROM THE OPERATION MANAGER USER ****************");
			log.info("**************** LOGOUT FROM THE OPERATION MANAGER USER ****************");

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

			} catch (Throwable t) {
				verificationFailed();
			}

			// DELETE THE AUTO GENERATED TASK FROM THE TASK LIST - PROPERTY MANAGER USER

			System.out.println(
					"******************** DELETE THE AUTO GENERATED TASK FROM THE TASK LIST - PROPERTY MANAGER USER ********************");
			test.log(LogStatus.INFO,
					"******************** DELETE THE AUTO GENERATED TASK FROM THE TASK LIST - PROPERTY MANAGER USER ********************");
			Reporter.log(
					"******************** DELETE THE AUTO GENERATED TASK FROM THE TASK LIST - PROPERTY MANAGER USER ********************");
			log.info(
					"******************** DELETE THE AUTO GENERATED TASK FROM THE TASK LIST - PROPERTY MANAGER USER ********************");

			try {

				// enter the property name in the search field
				type("envreports_propertylist_filtertxt_CSS", data.get("property_1"));
				ngDriver.waitForAngularRequestsToFinish();
				System.out.println("Entered the property name in the search field.");

				// click on the task icon
				click("taskicon_CSS");
				System.out.println("Clicked on the task icon.");
				ngDriver.waitForAngularRequestsToFinish();

				// select building from the property drop down
				select("task_addedtask_propertybuildingdd_CSS", data.get("building_leveldropdown"));
				ngDriver.waitForAngularRequestsToFinish();
				System.out.println("Selected building from the property drop down.");

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
				switchVerification("task_createdtask_covid19autotask_XPATH", "Get safety plan on site",
						"The Get safety plan on site is not displayed.");

				// click on the auto generated task
				click("task_createdtask_covid19autotask_XPATH");
				ngDriver.waitForAngularRequestsToFinish();
				System.out.println("Clicked on the auto generated task.");

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
				type("task_filter_CSS", data.get("task_title"));
				System.out.println("Entered the data in the search field.");
				ngDriver.waitForAngularRequestsToFinish();

				// click on the search button
				click("task_createdtask_searchbtn_XPATH");
				ngDriver.waitForAngularRequestsToFinish();
				System.out.println("Clicked on the search button.");

				// verify the questionnaire deleted or not

				deleteVerification("task_createdtask_covid19autotask_XPATH", "Get safety plan on site");

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

			// VERIFY DELETE TASK IS DISPLAYED IN THE RESPECTIVE INSPECTION OR NOT -
			// PROPERTY MANAGER USER

			System.out.println(
					"******************** VERIFY DELETE TASK IS DISPLAYED IN THE RESPECTIVE INSPECTION OR NOT - PROPERTY MANAGER USER ********************");
			test.log(LogStatus.INFO,
					"******************** VERIFY DELETE TASK IS DISPLAYED IN THE RESPECTIVE INSPECTION OR NOT - PROPERTY MANAGER USER ********************");
			Reporter.log(
					"******************** VERIFY DELETE TASK IS DISPLAYED IN THE RESPECTIVE INSPECTION OR NOT - PROPERTY MANAGER USER ********************");
			log.info(
					"******************** VERIFY DELETE TASK IS DISPLAYED IN THE RESPECTIVE INSPECTION OR NOT - PROPERTY MANAGER USER ********************");

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

				// click on the checklist/inspection option from side menu
				click("checklist_sidemenu_XPATH");
				System.out.println("Clicked on the checklist/inspection option from side menu");
				ngDriver.waitForAngularRequestsToFinish();
				System.out.println("Navigate to the checklist/inspection screen");

				// select building from the property drop down
				select("envreports_movereports_propertydd_CSS", data.get("building_leveldropdown"));
				ngDriver.waitForAngularRequestsToFinish();
				System.out.println("Selected building from the property drop down.");

				// wait for 5 seconds
				Thread.sleep(5000);

				// enter newly created inspection in the search field
				clear("task_listofchecklist_filterfield_CSS");
				ngDriver.waitForAngularRequestsToFinish();
				System.out.println("Cleared the search field.");
				type("task_listofchecklist_filterfield_CSS", data.get("checklist_property_title"));
				ngDriver.waitForAngularRequestsToFinish();
				System.out.println("Entered newly created inspection in the search field.");

				// verify submitted inspection is displayed or not
				switchVerification("questionnaire_checklist_createdinspectioncovid19_group_2_XPATH",
						"Test Questionnaire Property Title Group Smoke Capreit Two",
						"The Test Questionnaire Property Title Group Smoke Capreit Two is not displayed.");

				// click on the searched inspection
				click("questionnaire_checklist_createdinspectioncovid19_group_2_XPATH");
				ngDriver.waitForAngularRequestsToFinish();
				System.out.println("Clicked on the searched inspection.");

				// click on the switch to wizard mode button
				click("checklist_classicviewbtn_CSS");
				ngDriver.waitForAngularRequestsToFinish();
				System.out.println("Clicked on the switch to wizard mode button.");

				// click on the task tab
				click("inspectionchecklist_tasktab_XPATH");
				ngDriver.waitForAngularRequestsToFinish();
				System.out.println("Clicked on the task tab.");

				// scroll down the screen
				JavascriptExecutor js = (JavascriptExecutor) driver;
				js.executeScript("window.scrollBy(0,400)");

				// verify deleted task is displayed or not
				deleteVerification("checklist_taskone_pending_capreitone_XPATH", "Pending");

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

				// LOGOUT FROM PROPERTY MANAGER USER

				System.out.println("**************** LOGOUT FROM PROPERTY MANAGER USER ****************");
				test.log(LogStatus.INFO, "**************** LOGOUT FROM PROPERTY MANAGER USER ****************");
				Reporter.log("**************** LOGOUT FROM PROPERTY MANAGER USER ****************");
				log.info("**************** LOGOUT FROM PROPERTY MANAGER USER ****************");

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

				// LOGIN IN WITH OPERATION MANAGER USER

				System.out.println("**************** LOGIN IN WITH OPERATION MANAGER USER ****************");
				test.log(LogStatus.INFO, "**************** LOGIN IN WITH OPERATION MANAGER USER ****************");
				Reporter.log("**************** LOGIN IN WITH OPERATION MANAGER USER ****************");
				log.info("**************** LOGIN IN WITH OPERATION MANAGER USER ****************");

				// Enter the username
				ngDriver.waitForAngularRequestsToFinish();
				type("username_MODEL", data.get("username_2"));

				// Enter the password
				type("password_MODEL", data.get("password_2"));

				// Clicking on the "Sign In" button
				click("signinbtn_BTNTEXT");
				ngDriver.waitForAngularRequestsToFinish();

				// wait for the element
				explicitWait("propertylist_title_XPATH");

				// verify the property list
				switchVerification("propertylist_title_XPATH", "Property List", "The property list is not displayed.");

				// UPDATE THE SYSTEM COMPANY

				updateCompany(data);

			} catch (Throwable t) {
				verificationFailed();
			}

			// VERIFY AUTO GENERATED TASK IS DELETED IN THE SAME GROUP OF INSPECTION -
			// OPERATION MANAGER USER

			System.out.println(
					"**************** VERIFY AUTO GENERATED TASK IS DELETED IN THE SAME GROUP OF INSPECTION - OPERATION MANAGER USER ****************");
			test.log(LogStatus.INFO,
					"**************** VERIFY AUTO GENERATED TASK IS DELETED IN THE SAME GROUP OF INSPECTION - OPERATION MANAGER USER ****************");
			Reporter.log(
					"**************** VERIFY AUTO GENERATED TASK IS DELETED IN THE SAME GROUP OF INSPECTION - OPERATION MANAGER USER ****************");
			log.info(
					"**************** VERIFY AUTO GENERATED TASK IS DELETED IN THE SAME GROUP OF INSPECTION - OPERATION MANAGER USER ****************");

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

				// click on the checklist/inspection option from side menu
				click("checklist_sidemenu_XPATH");
				System.out.println("Clicked on the checklist/inspection option from side menu");
				ngDriver.waitForAngularRequestsToFinish();
				System.out.println("Navigate to the checklist/inspection screen");

				// select building from the property drop down
				select("envreports_movereports_propertydd_CSS", data.get("building_leveldropdown"));
				ngDriver.waitForAngularRequestsToFinish();
				System.out.println("Selected building from the property drop down.");

				// wait for 5 seconds
				Thread.sleep(5000);

				// enter newly created inspection in the search field
				clear("task_listofchecklist_filterfield_CSS");
				type("task_listofchecklist_filterfield_CSS", data.get("checklist_property_om_title"));
				ngDriver.waitForAngularRequestsToFinish();
				System.out.println("Entered newly created inspection in the search field.");

				// verify submitted inspection is displayed or not
				switchVerification("questionnaire_checklist_createdinspectioncovid19_groupom_2_XPATH",
						"Test Questionnaire Property Title Group OM Smoke Capreit Two",
						"The Test Questionnaire Property Title Group OM Smoke Capreit Two is not displayed.");

				// click on the searched inspection
				click("questionnaire_checklist_createdinspectioncovid19_groupom_2_XPATH");
				ngDriver.waitForAngularRequestsToFinish();
				System.out.println("Clicked on the searched inspection.");

				// click on the switch to wizard mode button
				click("checklist_classicviewbtn_CSS");
				ngDriver.waitForAngularRequestsToFinish();
				System.out.println("Clicked on the switch to wizard mode button.");

				// click on the task tab
				click("inspectionchecklist_tasktab_XPATH");
				ngDriver.waitForAngularRequestsToFinish();
				System.out.println("Clicked on the task tab.");

				// scroll down the screen
				JavascriptExecutor js = (JavascriptExecutor) driver;
				js.executeScript("window.scrollBy(0,400)");

				// verify deleted task is displayed or not
				deleteVerification("checklist_taskone_pending_capreitone_XPATH", "Pending");

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

			// DELETE THE INSTANCES - OPERATION MANAGER USER

			System.out.println("**************** DELETE THE INSTANCES - OPERATION MANAGER USER ****************");
			test.log(LogStatus.INFO, "**************** DELETE THE INSTANCES - OPERATION MANAGER USER ****************");
			Reporter.log("**************** DELETE THE INSTANCES - OPERATION MANAGER USER ****************");
			log.info("**************** DELETE THE INSTANCES - OPERATION MANAGER USER ****************");

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

				// click on the checklist/inspection option from side menu
				click("checklist_sidemenu_XPATH");
				System.out.println("Clicked on the checklist/inspection option from side menu");
				ngDriver.waitForAngularRequestsToFinish();
				System.out.println("Navigate to the checklist/inspection screen");

				// wait for the element
				explicitWaitClickable("envreports_movereports_propertydd_CSS");

				// select property from the property drop down
				select("envreports_movereports_propertydd_CSS", data.get("building_leveldropdown"));
				ngDriver.waitForAngularRequestsToFinish();
				System.out.println("Selected property from the property drop down.");

				// wait for 3 seconds
				Thread.sleep(3000);

				// enter newly created inspection in the search field
				clear("task_listofchecklist_filterfield_CSS");
				type("task_listofchecklist_filterfield_CSS", data.get("checklist_property_title"));
				ngDriver.waitForAngularRequestsToFinish();
				System.out.println("Entered newly created inspection in the search field.");

				// click on the action icon
				click("checklist_actionicon_CSS");
				ngDriver.waitForAngularRequestsToFinish();
				System.out.println("Clicked on the action icon.");

				// click on the delete option
				click("checklist_deleteoption_CSS");
				ngDriver.waitForAngularRequestsToFinish();
				System.out.println("Clicked on the delete option.");

				// click on the delete button
				click("checklist_deletebtn_CSS");
				ngDriver.waitForAngularRequestsToFinish();
				System.out.println("Clicked on the delete button.");

				// verify deleted inspection
				deleteVerification("questionnaire_checklist_createdinspectioncovid19_2_XPATH",
						"Test Questionnaire Property Title Smoke Capreit Two");

				// enter newly created inspection in the search field
				clear("task_listofchecklist_filterfield_CSS");
				type("task_listofchecklist_filterfield_CSS", data.get("checklist_property_om_title"));
				ngDriver.waitForAngularRequestsToFinish();
				System.out.println("Entered newly created inspection in the search field.");

				// wait for the element
				explicitWaitClickable("checklist_actionicon_CSS");

				// click on the action icon
				click("checklist_actionicon_CSS");
				ngDriver.waitForAngularRequestsToFinish();
				System.out.println("Clicked on the action icon.");

				// wait for the element
				explicitWaitClickable("checklist_deleteoption_CSS");

				// click on the delete option
				click("checklist_deleteoption_CSS");
				ngDriver.waitForAngularRequestsToFinish();
				System.out.println("Clicked on the delete option.");

				// wait for the element
				explicitWaitClickable("checklist_deletebtn_CSS");

				// click on the delete button
				click("checklist_deletebtn_CSS");
				ngDriver.waitForAngularRequestsToFinish();
				System.out.println("Clicked on the delete button.");

				// verify deleted inspection
				deleteVerification("questionnaire_checklist_createdinspectioncovid19_groupom_2_XPATH",
						"Test Questionnaire Property Title Group OM Smoke Capreit Two");

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

			// LOGOUT FROM THE OPERATION MANAGER USER

			System.out.println("**************** LOGOUT FROM THE OPERATION MANAGER USER ****************");
			test.log(LogStatus.INFO, "**************** LOGOUT FROM THE OPERATION MANAGER USER ****************");
			Reporter.log("**************** LOGOUT FROM THE OPERATION MANAGER USER ****************");
			log.info("**************** LOGOUT FROM THE OPERATION MANAGER USER ****************");

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

			} catch (Throwable t) {
				verificationFailed();
			}

			// DELETE THE NEWLY CREATED TASK - PROPERTY MANAGER USER

			System.out.println(
					"******************** DELETE THE NEWLY CREATED TASK - PROPERTY MANAGER USER ********************");
			test.log(LogStatus.INFO,
					"******************** DELETE THE NEWLY CREATED TASK - PROPERTY MANAGER USER ********************");
			Reporter.log(
					"******************** DELETE THE NEWLY CREATED TASK - PROPERTY MANAGER USER ********************");
			log.info("******************** DELETE THE NEWLY CREATED TASK - PROPERTY MANAGER USER ********************");

			try {

				// enter the property name in the search field
				type("envreports_propertylist_filtertxt_CSS", data.get("property_1"));
				ngDriver.waitForAngularRequestsToFinish();
				System.out.println("Entered the property name in the search field.");

				// click on the task icon
				click("taskicon_CSS");
				System.out.println("Clicked on the task icon.");
				ngDriver.waitForAngularRequestsToFinish();

				// select building from the property drop down
				select("task_addedtask_propertybuildingdd_CSS", data.get("building_leveldropdown"));
				ngDriver.waitForAngularRequestsToFinish();
				System.out.println("Selected building from the property drop down.");

				// select the close option from the dropdown
				select("survey_task_closefilter_CSS", data.get("task_closed_status"));
				ngDriver.waitForAngularRequestsToFinish();
				System.out.println("Selected the close option from the dropdown.");

				// click on the clear button
				click("task_createdtask_clearbtn_XPATH");
				ngDriver.waitForAngularRequestsToFinish();
				System.out.println("Clicked on the clear button.");

				// enter the data in the search field
				type("task_filter_CSS", data.get("tasktag"));
				System.out.println("Entered the data in the search field.");
				ngDriver.waitForAngularRequestsToFinish();

				// click on the search button
				click("task_createdtask_searchbtn_XPATH");
				ngDriver.waitForAngularRequestsToFinish();
				System.out.println("Clicked on the search button.");

				// verify newly created task is displayed or not
				switchVerification("task_createdtask_covid19addedtask_XPATH", "Electrical (Light Fixture)",
						"The Electrical (Light Fixture) is not displayed.");

				// click on the newly created task
				click("task_createdtask_covid19addedtask_XPATH");
				ngDriver.waitForAngularRequestsToFinish();
				System.out.println("Clicked on the newly created task.");

				// click on the reopen button
				click("riskmanagement_task_reopenbtn_XPATH");
				ngDriver.waitForAngularRequestsToFinish();
				System.out.println("Clicked on the reopen button.");

				// wait for the element
				explicitWaitClickable("closetoastmsg_CSS");

				// click on the toaster close button
				click("closetoastmsg_CSS");
				ngDriver.waitForAngularRequestsToFinish();
				System.out.println("Clicked on the toaster close button.");

				// wait for the element
				Thread.sleep(5000);

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
				type("task_filter_CSS", data.get("task_title"));
				System.out.println("Entered the data in the search field.");
				ngDriver.waitForAngularRequestsToFinish();

				// click on the search button
				click("task_createdtask_searchbtn_XPATH");
				ngDriver.waitForAngularRequestsToFinish();
				System.out.println("Clicked on the search button.");

				// verify the questionnaire deleted or not

				deleteVerification("task_createdtask_covid19addedtask_XPATH", "Electrical (Light Fixture)");

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

			// LOGIN IN ADMIN USER

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
