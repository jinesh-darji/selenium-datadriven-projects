package testcases.smokesuite;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Hashtable;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.Reporter;
import org.testng.SkipException;
import org.testng.annotations.Test;

import com.relevantcodes.extentreports.LogStatus;

import base.TestBase;
import utilities.TestUtil;

public class RR5368Capreit6Test extends TestBase {

	@Test(dataProviderClass = TestUtil.class, dataProvider = "dp")
	public void rR5368Capreit6Test(Hashtable<String, String> data) throws IOException, InterruptedException {

		if (!(TestUtil.isTestRunnable("rR5368Capreit6Test", excel))) {

			throw new SkipException(
					"Skipping the test " + "rR5368Capreit6Test".toUpperCase() + "as the Run mode is NO");
		}

		if (!data.get("runmode").equals("Y")) {

			throw new SkipException("Skipping the test case as the Run Mode for data set is NO");
		}

		// refresh the page
		driver.navigate().refresh();
		Thread.sleep(5000);
		driver.navigate().refresh();

		// TASK TAGS SELECTED FOR AUTO TASKS SHOULD BE MAINTAINED AND ALSO FILTERING
		// PROPERLY - RR-5321

		System.out.println(
				"******************** TASK TAGS SELECTED FOR AUTO TASKS SHOULD BE MAINTAINED AND ALSO FILTERING PROPERLY - RR-5321 ********************");
		test.log(LogStatus.INFO,
				"******************** TASK TAGS SELECTED FOR AUTO TASKS SHOULD BE MAINTAINED AND ALSO FILTERING PROPERLY - RR-5321 ********************");
		Reporter.log(
				"******************** TASK TAGS SELECTED FOR AUTO TASKS SHOULD BE MAINTAINED AND ALSO FILTERING PROPERLY - RR-5321 ********************");
		log.info(
				"******************** TASK TAGS SELECTED FOR AUTO TASKS SHOULD BE MAINTAINED AND ALSO FILTERING PROPERLY - RR-5321 ********************");

		System.out.println("Navigate to the Home Screen i.e. Property List Screen.");

		// LOGIN WITH ADMIN USER

		System.out.println("******************** LOGIN WITH ADMIN USER ********************");
		test.log(LogStatus.INFO, "******************** LOGIN WITH ADMIN USER ********************");
		Reporter.log("******************** LOGIN WITH ADMIN USER ********************");
		log.info("******************** LOGIN WITH ADMIN USER ********************");

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

		// CREATE THE NEW INSPECTION AND CHECKLIST (PROPERTY WITH BUILDING) - ADMIN

		System.out.println(
				"******************** CREATE THE NEW INSPECTION AND CHECKLIST (PROPERTY WITH BUILDING) - ADMIN ********************");
		test.log(LogStatus.INFO,
				"******************** CREATE THE NEW INSPECTION AND CHECKLIST (PROPERTY WITH BUILDING) - ADMIN ********************");
		Reporter.log(
				"******************** CREATE THE NEW INSPECTION AND CHECKLIST (PROPERTY WITH BUILDING) - ADMIN ********************");
		log.info(
				"******************** CREATE THE NEW INSPECTION AND CHECKLIST (PROPERTY WITH BUILDING) - ADMIN ********************");

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

			// wait for 3 seconds
			Thread.sleep(3000);

			// select building from the property drop down
			select("envreports_movereports_propertydd_CSS", data.get("building_leveldropdown"));
			ngDriver.waitForAngularRequestsToFinish();
			System.out.println("Selected building from the property drop down.");

			// wait for 5 seconds
			Thread.sleep(5000);

			// click on the new checklist button
			click("checklist_newchecklistbtn_CSS");
			ngDriver.waitForAngularRequestsToFinish();
			System.out.println("Selected property from the property drop down.");

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

			// verify questionnaire is selected correctly or not

			String covidtxt = driver.findElement(By.xpath(OR.getProperty("checklist_wizard_inspectiontitle6_XPATH")))
					.getText();
			System.out.println("COVID 19 INSTECTION TITLE : " + covidtxt);
			switchVerification("checklist_wizard_inspectiontitle6_XPATH",
					"Test Questionnaire Property Title Smoke Capreit Six",
					"The Test Questionnaire Property Title Smoke Capreit Six is not displayed.");

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

		// GENERATE THE AUTO TASK IN THE INSPECTION - OPERATION MANAGER

		System.out.println(
				"******************** GENERATE THE AUTO TASK IN THE INSPECTION - OPERATION MANAGER ********************");
		test.log(LogStatus.INFO,
				"******************** GENERATE THE AUTO TASK IN THE INSPECTION - OPERATION MANAGER ********************");
		Reporter.log(
				"******************** GENERATE THE AUTO TASK IN THE INSPECTION - OPERATION MANAGER ********************");
		log.info(
				"******************** GENERATE THE AUTO TASK IN THE INSPECTION - OPERATION MANAGER ********************");

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

			// wait for 3 seconds
			Thread.sleep(3000);

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
			click("questionnaire_checklist_createdinspectioncovid19_6_XPATH");
			ngDriver.waitForAngularRequestsToFinish();
			System.out.println("Clicked on the searched inspection.");

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
			clear("task_listofchecklist_filterfield_CSS");
			ngDriver.waitForAngularRequestsToFinish();
			System.out.println("Cleared the searched field.");
			type("task_listofchecklist_filterfield_CSS", data.get("checklist_property_title"));
			ngDriver.waitForAngularRequestsToFinish();
			System.out.println("Entered newly created inspection in the search field.");

			// verify submitted inspection is displayed or not
			switchVerification("questionnaire_checklist_createdinspectioncovid19_6_XPATH",
					"Test Questionnaire Property Title Smoke Capreit Six",
					"The Test Questionnaire Property Title Smoke Capreit Six is not displayed.");

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

		// VERIFY TASK TAG IS DISPLAYED CORRECTLY IN FILTER LIST OT NOT

		System.out.println(
				"********************  VERIFY TASK TAG IS DISPLAYED CORRECTLY IN FILTER LIST OT NOT ********************");
		test.log(LogStatus.INFO,
				"********************  VERIFY TASK TAG IS DISPLAYED CORRECTLY IN FILTER LIST OT NOT ********************");
		Reporter.log(
				"********************  VERIFY TASK TAG IS DISPLAYED CORRECTLY IN FILTER LIST OT NOT ********************");
		log.info(
				"********************  VERIFY TASK TAG IS DISPLAYED CORRECTLY IN FILTER LIST OT NOT ********************");

		try {

			// wait for the 5 seconds
			Thread.sleep(5000);

			// click on the side menu
			click("ssc_leftsidemenubtn_CSS");
			ngDriver.waitForAngularRequestsToFinish();
			System.out.println("Clicked on the side menu.");

			// wait for the 5 seconds
			Thread.sleep(5000);

			// click on the inspection/checklist option
			click("ssc_sidemenubtn_inspectionchecklistoption_XPATH");
			ngDriver.waitForAngularRequestsToFinish();
			System.out.println("Clicked on the inspection/checklist option.");

			// wait for the 3 seconds
			Thread.sleep(3000);

			// click on the dropdown icon
			click("inspectionchecklist_dashboard_dropdownicon_XPATH");
			ngDriver.waitForAngularRequestsToFinish();
			System.out.println("Clicked on the dropdown icon.");

			// click on the inspection history
			click("inspectionchecklist_dashboard_inspectionhistory_XPATH");
			ngDriver.waitForAngularRequestsToFinish();
			System.out.println("Clicked on the inspection history.");

			// wait for the element
			explicitWaitClickable("portfoliosummary_inspection2_inspectionlist_opentaskcont_XPATH");

			// click on the open task number
			click("portfoliosummary_inspection2_inspectionlist_opentaskcont_XPATH");
			ngDriver.waitForAngularRequestsToFinish();
			System.out.println("Clicked on the open task number.");

			// enter the task name in the search field
			clear("task_tasklist_searchtxt_CSS");
			ngDriver.waitForAngularRequestsToFinish();
			System.out.println("Cleared the search field");
			type("task_tasklist_searchtxt_CSS", data.get("task_title"));
			ngDriver.waitForAngularRequestsToFinish();
			System.out.println("Entered the task name in the search field.");

			// click on the task title
			click("task_createdtask_covid19autotask_dashboard_XPATH");
			ngDriver.waitForAngularRequestsToFinish();
			System.out.println("Clicked on the task title.");

			// scroll down the screen
			WebElement ele = driver.findElement(By.xpath(OR.getProperty("task_createdtask_tagslabel_XPATH")));
			JavascriptExecutor js = (JavascriptExecutor) driver;
			js.executeScript("arguments[0].scrollIntoView(true);", ele);

			// click on the tags field
			click("task_createdtask_tagstxt_CSS");
			ngDriver.waitForAngularRequestsToFinish();
			System.out.println("Clicked on the tags field.");

			// scroll down the screen
			js.executeScript("window.scrollBy(0,400)");

			// click on the none button
			click("task_tasktag_nonebtn_CSS");
			ngDriver.waitForAngularRequestsToFinish();
			System.out.println("Clicked on the none button.");

			// click on the tags field
			click("task_createdtask_tagstxt_CSS");
			ngDriver.waitForAngularRequestsToFinish();
			System.out.println("Clicked on the tags field.");

			// click on the update button
			click("task_tasktag_taskscreen_updatebtn_CSS");
			ngDriver.waitForAngularRequestsToFinish();
			System.out.println("Clicked on the update button.");

			// wait for the element
			explicitWaitClickable("closetoastmsg_CSS");

			// click on the toaster close button
			click("closetoastmsg_CSS");
			ngDriver.waitForAngularRequestsToFinish();
			System.out.println("Clicked on the toaster close button.");

			// click on the task tag field for filter the records
			click("task_tasklist_tagfilter_tagtxt_XPATH");
			ngDriver.waitForAngularRequestsToFinish();
			System.out.println("Clicked on the task tag field for filter the records.");

			// enter the task tag name in the search field for filter the record
			clear("task_tasklist_tagfilter_tagtxt_searchtxt_XPATH");
			ngDriver.waitForAngularRequestsToFinish();
			System.out.println("Cleared the task tag search field.");
			type("task_tasklist_tagfilter_tagtxt_searchtxt_XPATH", data.get("task_tag_name_1"));
			ngDriver.waitForAngularRequestsToFinish();
			System.out.println("Entered the task tag name in the search field.");

//			// VERIFY COMPLIANCE OPTION DISPLAYED SELECTED OR NOT IN THE TASK TAG FIELD OF
//			// THE FILTER
//
//			System.out
//					.println("VERIFY COMPLIANCE OPTION DISPLAYED SELECTED OR NOT IN THE TASK TAG FIELD OF THE FILTER");
//			test.log(LogStatus.INFO,
//					"VERIFY COMPLIANCE OPTION DISPLAYED SELECTED OR NOT IN THE TASK TAG FIELD OF THE FILTER");
//			Reporter.log("VERIFY COMPLIANCE OPTION DISPLAYED SELECTED OR NOT IN THE TASK TAG FIELD OF THE FILTER");
//			log.info("VERIFY COMPLIANCE OPTION DISPLAYED SELECTED OR NOT IN THE TASK TAG FIELD OF THE FILTER");
//
//			try {
//
//				boolean selectedTaskTag = driver
//						.findElement(By.xpath(OR.getProperty("task_tasklist_tagfilter_selectedoptionwithicon_XPATH")))
//						.isDisplayed();
//
//				if (selectedTaskTag == true) {
//					TestUtil.captureScreenshot();
//
//					// ReportNG
//					Reporter.log("<br>"
//							+ " The compliance task tag option is displayed selected in the task tag field of the filter. : "
//							+ "<br>");
//					Reporter.log("<a target=\"_blank\" href=" + TestUtil.screenshotName + "><img src="
//							+ TestUtil.screenshotName + " height=200 width=200></img></a>");
//					Reporter.log("<br>");
//					Reporter.log("<br>");
//
//					// Extent Report
//					test.log(LogStatus.FAIL,
//							" The compliance task tag option is displayed selected in the task tag field of the filter. : ");
//					test.log(LogStatus.FAIL, test.addScreenCapture(TestUtil.screenshotName));
//
//					System.out.println(
//							"The compliance task tag option is displayed selected in the task tag field of the filter.");
//					log.info(
//							"The compliance task tag option is displayed selected in the task tag field of the filter.");
//				} else {
//					System.out.println(
//							"The compliance task tag option is not displayed selected in the task tag field of the filter as expected.");
//					test.log(LogStatus.INFO,
//							"The compliance task tag option is not displayed selected in the task tag field of the filter as expected.");
//					Reporter.log(
//							"The compliance task tag option is not displayed selected in the task tag field of the filter as expected.");
//					log.info(
//							"The compliance task tag option is not displayed selected in the task tag field of the filter as expected.");
//				}
//
//			} catch (Throwable t) {
//				System.out.println(
//						"The compliance task tag option is not displayed selected in the task tag field of the filter as expected.");
//				test.log(LogStatus.INFO,
//						"The compliance task tag option is not displayed selected in the task tag field of the filter as expected.");
//				Reporter.log(
//						"The compliance task tag option is not displayed selected in the task tag field of the filter as expected.");
//				log.info(
//						"The compliance task tag option is not displayed selected in the task tag field of the filter as expected.");
//			}

			try {

				// enter the task tag name in the search field
				clear("task_tasklist_tagfilter_tagtxt_searchtxt_XPATH");
				ngDriver.waitForAngularRequestsToFinish();
				System.out.println("Cleared the task tag search field.");
				type("task_tasklist_tagfilter_tagtxt_searchtxt_XPATH", data.get("task_tag_name_2"));
				ngDriver.waitForAngularRequestsToFinish();
				System.out.println("Entered the task tag name in the search field.");

//				// VERIFY UNDEFINED OPTION DISPLAYED SELECTED OR NOT IN THE TASK TAG FIELD OF
//				// THE FILTER
//
//				System.out.println(
//						"VERIFY UNDEFINED OPTION DISPLAYED SELECTED OR NOT IN THE TASK TAG FIELD OF THE FILTER");
//				test.log(LogStatus.INFO,
//						"VERIFY UNDEFINED OPTION DISPLAYED SELECTED OR NOT IN THE TASK TAG FIELD OF THE FILTER");
//				Reporter.log("VERIFY UNDEFINED OPTION DISPLAYED SELECTED OR NOT IN THE TASK TAG FIELD OF THE FILTER");
//				log.info("VERIFY UNDEFINED OPTION DISPLAYED SELECTED OR NOT IN THE TASK TAG FIELD OF THE FILTER");
//
//				boolean selectedTaskTag2 = driver
//						.findElement(By.xpath(OR.getProperty("task_tasklist_tagfilter_undefined_XPATH"))).isDisplayed();
//
//				if (selectedTaskTag2 == true) {
//					TestUtil.captureScreenshot();
//
//					// ReportNG
//					Reporter.log("<br>"
//							+ " The undefined task tag option is displayed in the task tag field of the filter. : "
//							+ "<br>");
//					Reporter.log("<a target=\"_blank\" href=" + TestUtil.screenshotName + "><img src="
//							+ TestUtil.screenshotName + " height=200 width=200></img></a>");
//					Reporter.log("<br>");
//					Reporter.log("<br>");
//
//					// Extent Report
//					test.log(LogStatus.FAIL,
//							" The undefined task tag option is displayed in the task tag field of the filter. : ");
//					test.log(LogStatus.FAIL, test.addScreenCapture(TestUtil.screenshotName));
//
//					System.out
//							.println("The undefined task tag option is displayed in the task tag field of the filter.");
//					log.info("The undefined task tag option is displayed in the task tag field of the filter.");
//				} else {
//					System.out.println(
//							"The undefined task tag option is not displayed in the task tag field of the filter as expected.");
//					test.log(LogStatus.INFO,
//							"The undefined task tag option is not displayed in the task tag field of the filter as expected.");
//					Reporter.log(
//							"The undefined task tag option is not displayed in the task tag field of the filter as expected.");
//					log.info(
//							"The undefined task tag option is not displayed in the task tag field of the filter as expected.");
//				}
//
			} catch (Throwable t) {
				System.out.println(
						"The undefined task tag option is not displayed in the task tag field of the filter as expected.");
				test.log(LogStatus.INFO,
						"The undefined task tag option is not displayed in the task tag field of the filter as expected.");
				Reporter.log(
						"The undefined task tag option is not displayed in the task tag field of the filter as expected.");
				log.info(
						"The undefined task tag option is not displayed in the task tag field of the filter as expected.");
			}

			// click on the clear filter button
			click("task_tasklist_clearfilterbtn_XPATH");
			ngDriver.waitForAngularRequestsToFinish();
			System.out.println("Clicked on the clear filter button.");

			// enter the task name in the search field
			clear("task_tasklist_searchtxt_CSS");
			ngDriver.waitForAngularRequestsToFinish();
			System.out.println("Cleared the search field.");
			type("task_tasklist_searchtxt_CSS", data.get("task_title"));
			ngDriver.waitForAngularRequestsToFinish();
			System.out.println("Entered the task name in the search field.");

//			try {
//				// verify compliance option displayed or not
//				boolean selectedTaskTag3 = driver
//						.findElement(By.xpath(OR.getProperty("task_tasklist_tasktagcolumn1_XPATH"))).isDisplayed();
//
//				if (selectedTaskTag3 == true) {
//					TestUtil.captureScreenshot();
//
//					// ReportNG
//					Reporter.log("<br>"
//							+ " The removed task tag option is displayed in the task tag column of the task list. : "
//							+ "<br>");
//					Reporter.log("<a target=\"_blank\" href=" + TestUtil.screenshotName + "><img src="
//							+ TestUtil.screenshotName + " height=200 width=200></img></a>");
//					Reporter.log("<br>");
//					Reporter.log("<br>");
//
//					// Extent Report
//					test.log(LogStatus.FAIL,
//							" The removed task tag option is displayed in the task tag column of the task list. : ");
//					test.log(LogStatus.FAIL, test.addScreenCapture(TestUtil.screenshotName));
//
//					System.out.println(
//							"The removed task tag option is displayed in the task tag column of the task list.");
//					log.info("The removed task tag option is displayed in the task tag column of the task list.");
//				} else {
//					System.out.println(
//							"The removed task tag option is not displayed in the task tag column of the task list as expected.");
//					test.log(LogStatus.INFO,
//							"The removed task tag option is not displayed in the task tag column of the task list as expected.");
//					Reporter.log(
//							"The removed task tag option is not displayed in the task tag column of the task list as expected.");
//					log.info(
//							"The removed task tag option is not displayed in the task tag column of the task list as expected.");
//				}
//
//			} catch (Throwable t) {
//				System.out.println(
//						"The removed task tag option is not displayed in the task tag column of the task list as expected.");
//				test.log(LogStatus.INFO,
//						"The removed task tag option is not displayed in the task tag column of the task list as expected.");
//				Reporter.log(
//						"The removed task tag option is not displayed in the task tag column of the task list as expected.");
//				log.info(
//						"The removed task tag option is not displayed in the task tag column of the task list as expected.");
//			}

		} catch (Throwable t) {
			verificationFailed();
		}

		// VERIFY TASK TAG IS DISPLAYED IN THE TASK TAG FIELD WHILE UPDATE THE TASK
		// DETAILS

		System.out.println(
				"******************** VERIFY TASK TAG IS DISPLAYED IN THE TASK TAG FIELD WHILE UPDATE THE TASK DETAILS ********************");
		test.log(LogStatus.INFO,
				"******************** VERIFY TASK TAG IS DISPLAYED IN THE TASK TAG FIELD WHILE UPDATE THE TASK DETAILS ********************");
		Reporter.log(
				"******************** VERIFY TASK TAG IS DISPLAYED IN THE TASK TAG FIELD WHILE UPDATE THE TASK DETAILS ********************");
		log.info(
				"******************** VERIFY TASK TAG IS DISPLAYED IN THE TASK TAG FIELD WHILE UPDATE THE TASK DETAILS ********************");

		try {
			// click on the auto generated task
			click("task_createdtask_covid19autotask_dashboard_XPATH");
			ngDriver.waitForAngularRequestsToFinish();
			System.out.println("Clicked on the auto generated task.");

			// scroll down the screen
			WebElement ele1 = driver.findElement(By.xpath(OR.getProperty("task_createdtask_tagslabel_XPATH")));
			JavascriptExecutor js = (JavascriptExecutor) driver;
			js.executeScript("arguments[0].scrollIntoView(true);", ele1);

			// click on the tags field
			click("task_createdtask_tagstxt_CSS");
			ngDriver.waitForAngularRequestsToFinish();
			System.out.println("Clicked on the tags field.");

			// scroll down the screen
			js.executeScript("window.scrollBy(0,400)");

			// enter the task tag name in the search field for filter the record
			clear("task_tasklist_tagfilter_tagtxt_searchtxt_XPATH");
			ngDriver.waitForAngularRequestsToFinish();
			System.out.println("Cleared the task tag search field.");
			type("task_tasklist_tagfilter_tagtxt_searchtxt_XPATH", data.get("task_tag_name_1"));
			ngDriver.waitForAngularRequestsToFinish();
			System.out.println("Entered the task tag name in the search field.");

			// VERIFY COMPLIANCE TASK TAG OPTION IS DISPLAYED OR NOT IN THE TASK TAG FIELD

			System.out.println("VERIFY COMPLIANCE TASK TAG OPTION IS DISPLAYED OR NOT IN THE TASK TAG FIELD");
			test.log(LogStatus.INFO, "VERIFY COMPLIANCE TASK TAG OPTION IS DISPLAYED OR NOT IN THE TASK TAG FIELD");
			Reporter.log("VERIFY COMPLIANCE TASK TAG OPTION IS DISPLAYED OR NOT IN THE TASK TAG FIELD");
			log.info("VERIFY COMPLIANCE TASK TAG OPTION IS DISPLAYED OR NOT IN THE TASK TAG FIELD");

			try {

				boolean selectedTaskTag = driver
						.findElement(By.xpath(OR.getProperty("task_tasklist_tagfilter_tagtxt_searchedoption_XPATH")))
						.isDisplayed();

				if (selectedTaskTag == true) {
					System.out.println(
							"The compliance task tag option is displayed in the task tag field of the filter as expected.");
					test.log(LogStatus.INFO,
							"The compliance task tag option is displayed in the task tag field of the filter as expected.");
					Reporter.log(
							"The compliance task tag option is displayed in the task tag field of the filter as expected.");
					log.info(
							"The compliance task tag option is displayed in the task tag field of the filter as expected.");

				} else {
					TestUtil.captureScreenshot();

					// ReportNG
					Reporter.log("<br>"
							+ " The compliance task tag option is not displayed in the task tag field of the filter. : "
							+ "<br>");
					Reporter.log("<a target=\"_blank\" href=" + TestUtil.screenshotName + "><img src="
							+ TestUtil.screenshotName + " height=200 width=200></img></a>");
					Reporter.log("<br>");
					Reporter.log("<br>");

					// Extent Report
					test.log(LogStatus.FAIL,
							" The compliance task tag option is not displayed in the task tag field of the filter. : ");
					test.log(LogStatus.FAIL, test.addScreenCapture(TestUtil.screenshotName));

					System.out.println(
							"The compliance task tag option is not displayed in the task tag field of the filter.");
					log.info("The compliance task tag option is not displayed in the task tag field of the filter.");
				}

			} catch (Throwable t) {
				TestUtil.captureScreenshot();

				// ReportNG
				Reporter.log("<br>"
						+ " The compliance task tag option is not displayed in the task tag field of the filter. : "
						+ "<br>");
				Reporter.log("<a target=\"_blank\" href=" + TestUtil.screenshotName + "><img src="
						+ TestUtil.screenshotName + " height=200 width=200></img></a>");
				Reporter.log("<br>");
				Reporter.log("<br>");

				// Extent Report
				test.log(LogStatus.FAIL,
						" The compliance task tag option is not displayed in the task tag field of the filter. : ");
				test.log(LogStatus.FAIL, test.addScreenCapture(TestUtil.screenshotName));

				System.out.println(
						"The compliance task tag option is not displayed in the task tag field of the filter.");
				log.info("The compliance task tag option is not displayed in the task tag field of the filter.");
			}

			// VERIFY COMPLIANCE TASK TAG OPTION IS DISPLAYED SELECTED OR NOT IN THE TASK
			// TAG FIELD

			System.out.println("VERIFY COMPLIANCE TASK TAG OPTION IS DISPLAYED SELECTED OR NOT IN THE TASK TAG FIELD");
			test.log(LogStatus.INFO,
					"VERIFY COMPLIANCE TASK TAG OPTION IS DISPLAYED SELECTED OR NOT IN THE TASK TAG FIELD");
			Reporter.log("VERIFY COMPLIANCE TASK TAG OPTION IS DISPLAYED SELECTED OR NOT IN THE TASK TAG FIELD");
			log.info("VERIFY COMPLIANCE TASK TAG OPTION IS DISPLAYED SELECTED OR NOT IN THE TASK TAG FIELD");

			try {

				boolean selectedTaskTag4 = driver
						.findElement(By.xpath(OR.getProperty("task_tasklist_tagfilter_seachedoutlineicon_XPATH")))
						.isDisplayed();

				if (selectedTaskTag4 == true) {
					System.out.println(
							"The compliance task tag option is not displayed selected in the task tag field of the filter as expected.");
					test.log(LogStatus.INFO,
							"The compliance task tag option is not displayed selected in the task tag field of the filter as expected.");
					Reporter.log(
							"The compliance task tag option is not displayed selected in the task tag field of the filter as expected.");
					log.info(
							"The compliance task tag option is not displayed selected in the task tag field of the filter as expected.");

					// click on the searched compliance task tag option
					click("task_tasklist_tagfilter_seachedoutlineicon_XPATH");
					ngDriver.waitForAngularRequestsToFinish();
					System.out.println("Clicked on the searched compliance task tag option.");

					// click on the tags field
					click("task_createdtask_tagstxt_CSS");
					ngDriver.waitForAngularRequestsToFinish();
					System.out.println("Clicked on the tags field.");

				} else {
					TestUtil.captureScreenshot();

					// ReportNG
					Reporter.log("<br>"
							+ " The compliance task tag option is displayed selected in the task tag field of the filter. : "
							+ "<br>");
					Reporter.log("<a target=\"_blank\" href=" + TestUtil.screenshotName + "><img src="
							+ TestUtil.screenshotName + " height=200 width=200></img></a>");
					Reporter.log("<br>");
					Reporter.log("<br>");

					// Extent Report
					test.log(LogStatus.FAIL,
							" The compliance task tag option is displayed selected in the task tag field of the filter. : ");
					test.log(LogStatus.FAIL, test.addScreenCapture(TestUtil.screenshotName));

					System.out.println(
							"The compliance task tag option is displayed selected in the task tag field of the filter.");
					log.info(
							"The compliance task tag option is displayed selected in the task tag field of the filter.");
				}

			} catch (Throwable t) {
				TestUtil.captureScreenshot();

				// ReportNG
				Reporter.log("<br>"
						+ " The compliance task tag option is displayed selected in the task tag field of the filter. : "
						+ "<br>");
				Reporter.log("<a target=\"_blank\" href=" + TestUtil.screenshotName + "><img src="
						+ TestUtil.screenshotName + " height=200 width=200></img></a>");
				Reporter.log("<br>");
				Reporter.log("<br>");

				// Extent Report
				test.log(LogStatus.FAIL,
						" The compliance task tag option is displayed selected in the task tag field of the filter. : ");
				test.log(LogStatus.FAIL, test.addScreenCapture(TestUtil.screenshotName));

				System.out.println(
						"The compliance task tag option is displayed selected in the task tag field of the filter.");
				log.info("The compliance task tag option is displayed selected in the task tag field of the filter.");
			}

			// click on the update button
			click("task_tasktag_taskscreen_updatebtn_CSS");
			ngDriver.waitForAngularRequestsToFinish();
			System.out.println("Clicked on the update button.");

			// wait for the element
			explicitWaitClickable("closetoastmsg_CSS");

			// click on the toaster close button
			click("closetoastmsg_CSS");
			ngDriver.waitForAngularRequestsToFinish();
			System.out.println("Clicked on the toaster close button.");

			// click on the task tag field for filter the records
			click("task_tasklist_tagfilter_tagtxt_XPATH");
			ngDriver.waitForAngularRequestsToFinish();
			System.out.println("Clicked on the task tag field for filter the records.");

			// enter the task tag name in the search field for filter the record
			clear("task_tasklist_tagfilter_tagtxt_searchtxt_XPATH");
			ngDriver.waitForAngularRequestsToFinish();
			System.out.println("Cleared the task tag search field.");
			type("task_tasklist_tagfilter_tagtxt_searchtxt_XPATH", data.get("task_tag_name_1"));
			ngDriver.waitForAngularRequestsToFinish();
			System.out.println("Entered the task tag name in the search field.");

			// VERIFY COMPLIANCE OPTION DISPLAYED SELECTED OR NOT IN THE TASK TAG FIELD OF
			// THE FILTER

			System.out
					.println("VERIFY COMPLIANCE OPTION DISPLAYED SELECTED OR NOT IN THE TASK TAG FIELD OF THE FILTER");
			test.log(LogStatus.INFO,
					"VERIFY COMPLIANCE OPTION DISPLAYED SELECTED OR NOT IN THE TASK TAG FIELD OF THE FILTER");
			Reporter.log("VERIFY COMPLIANCE OPTION DISPLAYED SELECTED OR NOT IN THE TASK TAG FIELD OF THE FILTER");
			log.info("VERIFY COMPLIANCE OPTION DISPLAYED SELECTED OR NOT IN THE TASK TAG FIELD OF THE FILTER");

			try {

				boolean selectedTaskTag = driver
						.findElement(By.xpath(OR.getProperty("task_tasklist_tagfilter_selectedoptionwithicon_XPATH")))
						.isDisplayed();

				if (selectedTaskTag == true) {
					System.out.println(
							"The compliance task tag option is displayed selected in the task tag field of the filter as expected.");
					test.log(LogStatus.INFO,
							"The compliance task tag option is displayed selected in the task tag field of the filter as expected.");
					Reporter.log(
							"The compliance task tag option is displayed selected in the task tag field of the filter as expected.");
					log.info(
							"The compliance task tag option is displayed selected in the task tag field of the filter as expected.");

				} else {
					TestUtil.captureScreenshot();

					// ReportNG
					Reporter.log("<br>"
							+ " The compliance task tag option is not displayed selected in the task tag field of the filter. : "
							+ "<br>");
					Reporter.log("<a target=\"_blank\" href=" + TestUtil.screenshotName + "><img src="
							+ TestUtil.screenshotName + " height=200 width=200></img></a>");
					Reporter.log("<br>");
					Reporter.log("<br>");

					// Extent Report
					test.log(LogStatus.FAIL,
							" The compliance task tag option is not displayed selected in the task tag field of the filter. : ");
					test.log(LogStatus.FAIL, test.addScreenCapture(TestUtil.screenshotName));

					System.out.println(
							"The compliance task tag option is not displayed selected in the task tag field of the filter.");
					log.info(
							"The compliance task tag option is not displayed selected in the task tag field of the filter.");
				}

			} catch (Throwable t) {
				TestUtil.captureScreenshot();

				// ReportNG
				Reporter.log("<br>"
						+ " The compliance task tag option is not displayed selected in the task tag field of the filter. : "
						+ "<br>");
				Reporter.log("<a target=\"_blank\" href=" + TestUtil.screenshotName + "><img src="
						+ TestUtil.screenshotName + " height=200 width=200></img></a>");
				Reporter.log("<br>");
				Reporter.log("<br>");

				// Extent Report
				test.log(LogStatus.FAIL,
						" The compliance task tag option is not displayed selected in the task tag field of the filter. : ");
				test.log(LogStatus.FAIL, test.addScreenCapture(TestUtil.screenshotName));

				System.out.println(
						"The compliance task tag option is not displayed selected in the task tag field of the filter.");
				log.info(
						"The compliance task tag option is not displayed selected in the task tag field of the filter.");
			}

			try {

				// enter the task tag name in the search field
				clear("task_tasklist_tagfilter_tagtxt_searchtxt_XPATH");
				type("task_tasklist_tagfilter_tagtxt_searchtxt_XPATH", data.get("task_tag_name_2"));
				ngDriver.waitForAngularRequestsToFinish();
				System.out.println("Entered the task tag name in the search field.");

				// VERIFY UNDEFINED OPTION DISPLAYED SELECTED OR NOT IN THE TASK TAG FIELD OF
				// THE FILTER

				System.out.println(
						"VERIFY UNDEFINED OPTION DISPLAYED SELECTED OR NOT IN THE TASK TAG FIELD OF THE FILTER");
				test.log(LogStatus.INFO,
						"VERIFY UNDEFINED OPTION DISPLAYED SELECTED OR NOT IN THE TASK TAG FIELD OF THE FILTER");
				Reporter.log("VERIFY UNDEFINED OPTION DISPLAYED SELECTED OR NOT IN THE TASK TAG FIELD OF THE FILTER");
				log.info("VERIFY UNDEFINED OPTION DISPLAYED SELECTED OR NOT IN THE TASK TAG FIELD OF THE FILTER");

				boolean selectedTaskTag2 = driver
						.findElement(By.xpath(OR.getProperty("task_tasklist_tagfilter_undefined_XPATH"))).isDisplayed();

				if (selectedTaskTag2 == true) {
					TestUtil.captureScreenshot();

					// ReportNG
					Reporter.log("<br>"
							+ " The undefined task tag option is displayed in the task tag field of the filter. : "
							+ "<br>");
					Reporter.log("<a target=\"_blank\" href=" + TestUtil.screenshotName + "><img src="
							+ TestUtil.screenshotName + " height=200 width=200></img></a>");
					Reporter.log("<br>");
					Reporter.log("<br>");

					// Extent Report
					test.log(LogStatus.FAIL,
							" The undefined task tag option is displayed in the task tag field of the filter. : ");
					test.log(LogStatus.FAIL, test.addScreenCapture(TestUtil.screenshotName));

					System.out
							.println("The undefined task tag option is displayed in the task tag field of the filter.");
					log.info("The undefined task tag option is displayed in the task tag field of the filter.");
				} else {
					System.out.println(
							"The undefined task tag option is not displayed in the task tag field of the filter as expected.");
					test.log(LogStatus.INFO,
							"The undefined task tag option is not displayed in the task tag field of the filter as expected.");
					Reporter.log(
							"The undefined task tag option is not displayed in the task tag field of the filter as expected.");
					log.info(
							"The undefined task tag option is not displayed in the task tag field of the filter as expected.");
				}

			} catch (Throwable t) {
				System.out.println(
						"The undefined task tag option is not displayed in the task tag field of the filter as expected.");
				test.log(LogStatus.INFO,
						"The undefined task tag option is not displayed in the task tag field of the filter as expected.");
				Reporter.log(
						"The undefined task tag option is not displayed in the task tag field of the filter as expected.");
				log.info(
						"The undefined task tag option is not displayed in the task tag field of the filter as expected.");
			}

			// click on the clear filter button
			click("task_tasklist_clearfilterbtn_XPATH");
			ngDriver.waitForAngularRequestsToFinish();
			System.out.println("Clicked on the clear filter button.");

			// enter the task name in the search field
			clear("task_tasklist_searchtxt_CSS");
			ngDriver.waitForAngularRequestsToFinish();
			System.out.println("Cleared the search field.");
			type("task_tasklist_searchtxt_CSS", data.get("task_title"));
			ngDriver.waitForAngularRequestsToFinish();
			System.out.println("Entered the task name in the search field.");

			try {
				// verify compliance option displayed or not
				boolean selectedTaskTag3 = driver
						.findElement(By.xpath(OR.getProperty("task_tasklist_tasktagcolumn1_XPATH"))).isDisplayed();

				if (selectedTaskTag3 == true) {

					System.out.println(
							"The added task tag option is displayed in the task tag column of the task list as expected.");
					test.log(LogStatus.INFO,
							"The added task tag option is displayed in the task tag column of the task list as expected.");
					Reporter.log(
							"The added task tag option is displayed in the task tag column of the task list as expected.");
					log.info(
							"The added task tag option is displayed in the task tag column of the task list as expected.");

				} else {
					TestUtil.captureScreenshot();

					// ReportNG
					Reporter.log("<br>"
							+ " The added task tag option is not displayed in the task tag column of the task list. : "
							+ "<br>");
					Reporter.log("<a target=\"_blank\" href=" + TestUtil.screenshotName + "><img src="
							+ TestUtil.screenshotName + " height=200 width=200></img></a>");
					Reporter.log("<br>");
					Reporter.log("<br>");

					// Extent Report
					test.log(LogStatus.FAIL,
							" The added task tag option is not displayed in the task tag column of the task list. : ");
					test.log(LogStatus.FAIL, test.addScreenCapture(TestUtil.screenshotName));

					System.out.println(
							"The added task tag option is not displayed in the task tag column of the task list.");
					log.info("The added task tag option is not displayed in the task tag column of the task list.");
				}

			} catch (Throwable t) {
				TestUtil.captureScreenshot();

				// ReportNG
				Reporter.log("<br>"
						+ " The added task tag option is not displayed in the task tag column of the task list. : "
						+ "<br>");
				Reporter.log("<a target=\"_blank\" href=" + TestUtil.screenshotName + "><img src="
						+ TestUtil.screenshotName + " height=200 width=200></img></a>");
				Reporter.log("<br>");
				Reporter.log("<br>");

				// Extent Report
				test.log(LogStatus.FAIL,
						" The added task tag option is not displayed in the task tag column of the task list. : ");
				test.log(LogStatus.FAIL, test.addScreenCapture(TestUtil.screenshotName));

				System.out
						.println("The added task tag option is not displayed in the task tag column of the task list.");
				log.info("The added task tag option is not displayed in the task tag column of the task list.");
			}

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

		// ADD THE TASK IN COVID 19 INSPECTION - ADMIN

		System.out.println("******************** ADD THE TASK IN COVID 19 INSPECTION - ADMIN ********************");
		test.log(LogStatus.INFO,
				"******************** ADD THE TASK IN COVID 19 INSPECTION - ADMIN ********************");
		Reporter.log("******************** ADD THE TASK IN COVID 19 INSPECTION - ADMIN ********************");
		log.info("******************** ADD THE TASK IN COVID 19 INSPECTION - ADMIN ********************");

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
			ngDriver.waitForAngularRequestsToFinish();
			System.out.println("Cleared the search field.");
			type("task_listofchecklist_filterfield_CSS", data.get("checklist_property_title"));
			ngDriver.waitForAngularRequestsToFinish();
			System.out.println("Entered newly created inspection in the search field.");

			// click on the searched inspection
			click("questionnaire_checklist_createdinspectioncovid19_6_XPATH");
			ngDriver.waitForAngularRequestsToFinish();
			System.out.println("Clicked on the searched inspection.");

			// wait for 3 seconds
			Thread.sleep(3000);

			// click on the switch to wizard mode button
			click("checklist_classicviewbtn_CSS");
			ngDriver.waitForAngularRequestsToFinish();
			System.out.println("Clicked on the switch to wizard mode button.");

			// wait for 3 seconds
			Thread.sleep(3000);

			// click on the task tab
			click("inspectionchecklist_tasktab_XPATH");
			ngDriver.waitForAngularRequestsToFinish();
			System.out.println("Clicked on the task tab.");

			// click on the new task button
			click("inspectionchecklist_newtaskbtn_XPATH");
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

			// scroll down the screen
			JavascriptExecutor js = (JavascriptExecutor) driver;
			js.executeScript("window.scrollBy(0,500)");

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

		// VERIFY TASK TAG OF THE NEWLT CREATED TASK IS DISPLAYED CORRECTLY IN FILTER
		// LIST OT NOT

		System.out.println(
				"********************  VERIFY TASK TAG OF THE NEWLT CREATED TASK IS DISPLAYED CORRECTLY IN FILTER LIST OT NOT ********************");
		test.log(LogStatus.INFO,
				"********************  VERIFY TASK TAG OF THE NEWLT CREATED TASK IS DISPLAYED CORRECTLY IN FILTER LIST OT NOT ********************");
		Reporter.log(
				"********************  VERIFY TASK TAG OF THE NEWLT CREATED TASK IS DISPLAYED CORRECTLY IN FILTER LIST OT NOT ********************");
		log.info(
				"********************  VERIFY TASK TAG OF THE NEWLT CREATED TASK IS DISPLAYED CORRECTLY IN FILTER LIST OT NOT ********************");

		try {

			// wait for the 5 seconds
			Thread.sleep(5000);

			// click on the side menu
			click("ssc_leftsidemenubtn_CSS");
			ngDriver.waitForAngularRequestsToFinish();
			System.out.println("Clicked on the side menu.");

			// wait for the 5 seconds
			Thread.sleep(5000);

			// click on the inspection/checklist option
			click("ssc_sidemenubtn_inspectionchecklistoption_XPATH");
			ngDriver.waitForAngularRequestsToFinish();
			System.out.println("Clicked on the inspection/checklist option.");

			// wait for the 3 seconds
			Thread.sleep(3000);

			// click on the dropdown icon
			click("inspectionchecklist_dashboard_dropdownicon_XPATH");
			ngDriver.waitForAngularRequestsToFinish();
			System.out.println("Clicked on the dropdown icon.");

			// click on the inspection history
			click("inspectionchecklist_dashboard_inspectionhistory_XPATH");
			ngDriver.waitForAngularRequestsToFinish();
			System.out.println("Clicked on the inspection history.");

			// wait for the element
			explicitWaitClickable("portfoliosummary_inspection2_inspectionlist_opentaskcont_XPATH");

			// click on the open task number
			click("portfoliosummary_inspection2_inspectionlist_opentaskcont_XPATH");
			ngDriver.waitForAngularRequestsToFinish();
			System.out.println("Clicked on the open task number.");

			// enter the task name in the search field
			clear("task_tasklist_searchtxt_CSS");
			ngDriver.waitForAngularRequestsToFinish();
			System.out.println("Cleared the search field");
			type("task_tasklist_searchtxt_CSS", data.get("tasktag"));
			ngDriver.waitForAngularRequestsToFinish();
			System.out.println("Entered the task name in the search field.");

			// click on the task title
			click("task_createdtask_covid19newltcreatedtask_dashboard_XPATH");
			ngDriver.waitForAngularRequestsToFinish();
			System.out.println("Clicked on the task title.");

			// scroll down the screen
			WebElement ele3 = driver.findElement(By.xpath(OR.getProperty("task_createdtask_tagslabel_XPATH")));
			JavascriptExecutor js = (JavascriptExecutor) driver;
			js.executeScript("arguments[0].scrollIntoView(true);", ele3);

			// click on the tags field
			click("task_createdtask_tagstxt_CSS");
			ngDriver.waitForAngularRequestsToFinish();
			System.out.println("Clicked on the tags field.");

			// scroll down the screen
			js.executeScript("window.scrollBy(0,400)");

			// click on the none button
			click("task_tasktag_nonebtn_CSS");
			ngDriver.waitForAngularRequestsToFinish();
			System.out.println("Clicked on the none button.");

			// click on the tags field
			click("task_createdtask_tagstxt_CSS");
			ngDriver.waitForAngularRequestsToFinish();
			System.out.println("Clicked on the tags field.");

			// click on the update button
			click("task_tasktag_taskscreen_updatebtn_CSS");
			ngDriver.waitForAngularRequestsToFinish();
			System.out.println("Clicked on the update button.");

			// wait for the element
			explicitWaitClickable("closetoastmsg_CSS");

			// click on the toaster close button
			click("closetoastmsg_CSS");
			ngDriver.waitForAngularRequestsToFinish();
			System.out.println("Clicked on the toaster close button.");

			// click on the task tag field for filter the records
			click("task_tasklist_tagfilter_tagtxt_XPATH");
			ngDriver.waitForAngularRequestsToFinish();
			System.out.println("Clicked on the task tag field for filter the records.");

			// enter the task tag name in the search field for filter the record
			clear("task_tasklist_tagfilter_tagtxt_searchtxt_XPATH");
			ngDriver.waitForAngularRequestsToFinish();
			System.out.println("Cleared the task tag search field.");
			type("task_tasklist_tagfilter_tagtxt_searchtxt_XPATH", data.get("task_tag_name_2"));
			ngDriver.waitForAngularRequestsToFinish();
			System.out.println("Entered the task tag name in the search field.");

			// VERIFY DEFICIENCY OPTION DISPLAYED SELECTED OR NOT IN THE TASK TAG FIELD OF
			// THE FILTER

			System.out
					.println("VERIFY DEFICIENCY OPTION DISPLAYED SELECTED OR NOT IN THE TASK TAG FIELD OF THE FILTER");
			test.log(LogStatus.INFO,
					"VERIFY DEFICIENCY OPTION DISPLAYED SELECTED OR NOT IN THE TASK TAG FIELD OF THE FILTER");
			Reporter.log("VERIFY DEFICIENCY OPTION DISPLAYED SELECTED OR NOT IN THE TASK TAG FIELD OF THE FILTER");
			log.info("VERIFY DEFICIENCY OPTION DISPLAYED SELECTED OR NOT IN THE TASK TAG FIELD OF THE FILTER");

			try {

				boolean selectedTaskTag = driver
						.findElement(By.xpath(OR
								.getProperty("task_tasklist_tagfilter_selectedoptionwithicon_newlycreatedtask_XPATH")))
						.isDisplayed();

				if (selectedTaskTag == true) {
					TestUtil.captureScreenshot();

					// ReportNG
					Reporter.log("<br>"
							+ " The deficiency task tag option is displayed selected in the task tag field of the filter. : "
							+ "<br>");
					Reporter.log("<a target=\"_blank\" href=" + TestUtil.screenshotName + "><img src="
							+ TestUtil.screenshotName + " height=200 width=200></img></a>");
					Reporter.log("<br>");
					Reporter.log("<br>");

					// Extent Report
					test.log(LogStatus.FAIL,
							" The deficiency task tag option is displayed selected in the task tag field of the filter. : ");
					test.log(LogStatus.FAIL, test.addScreenCapture(TestUtil.screenshotName));

					System.out.println(
							"The deficiency task tag option is displayed selected in the task tag field of the filter.");
					log.info(
							"The deficiency task tag option is displayed selected in the task tag field of the filter.");
				} else {
					System.out.println(
							"The deficiency task tag option is not displayed selected in the task tag field of the filter as expected.");
					test.log(LogStatus.INFO,
							"The deficiency task tag option is not displayed selected in the task tag field of the filter as expected.");
					Reporter.log(
							"The deficiency task tag option is not displayed selected in the task tag field of the filter as expected.");
					log.info(
							"The deficiency task tag option is not displayed selected in the task tag field of the filter as expected.");
				}

			} catch (Throwable t) {
				System.out.println(
						"The deficiency task tag option is not displayed selected in the task tag field of the filter as expected.");
				test.log(LogStatus.INFO,
						"The deficiency task tag option is not displayed selected in the task tag field of the filter as expected.");
				Reporter.log(
						"The deficiency task tag option is not displayed selected in the task tag field of the filter as expected.");
				log.info(
						"The deficiency task tag option is not displayed selected in the task tag field of the filter as expected.");
			}

			try {

				// enter the task tag name in the search field
				clear("task_tasklist_tagfilter_tagtxt_searchtxt_XPATH");
				ngDriver.waitForAngularRequestsToFinish();
				System.out.println("Cleared the task tag search field.");
				type("task_tasklist_tagfilter_tagtxt_searchtxt_XPATH", data.get("task_tag_name_2"));
				ngDriver.waitForAngularRequestsToFinish();
				System.out.println("Entered the task tag name in the search field.");

				// VERIFY UNDEFINED OPTION DISPLAYED SELECTED OR NOT IN THE TASK TAG FIELD OF
				// THE FILTER

				System.out.println(
						"VERIFY UNDEFINED OPTION DISPLAYED SELECTED OR NOT IN THE TASK TAG FIELD OF THE FILTER");
				test.log(LogStatus.INFO,
						"VERIFY UNDEFINED OPTION DISPLAYED SELECTED OR NOT IN THE TASK TAG FIELD OF THE FILTER");
				Reporter.log("VERIFY UNDEFINED OPTION DISPLAYED SELECTED OR NOT IN THE TASK TAG FIELD OF THE FILTER");
				log.info("VERIFY UNDEFINED OPTION DISPLAYED SELECTED OR NOT IN THE TASK TAG FIELD OF THE FILTER");

				boolean selectedTaskTag2 = driver
						.findElement(By.xpath(OR.getProperty("task_tasklist_tagfilter_undefined_XPATH"))).isDisplayed();

				if (selectedTaskTag2 == true) {
					TestUtil.captureScreenshot();

					// ReportNG
					Reporter.log("<br>"
							+ " The undefined task tag option is displayed in the task tag field of the filter. : "
							+ "<br>");
					Reporter.log("<a target=\"_blank\" href=" + TestUtil.screenshotName + "><img src="
							+ TestUtil.screenshotName + " height=200 width=200></img></a>");
					Reporter.log("<br>");
					Reporter.log("<br>");

					// Extent Report
					test.log(LogStatus.FAIL,
							" The undefined task tag option is displayed in the task tag field of the filter. : ");
					test.log(LogStatus.FAIL, test.addScreenCapture(TestUtil.screenshotName));

					System.out
							.println("The undefined task tag option is displayed in the task tag field of the filter.");
					log.info("The undefined task tag option is displayed in the task tag field of the filter.");
				} else {
					System.out.println(
							"The undefined task tag option is not displayed in the task tag field of the filter as expected.");
					test.log(LogStatus.INFO,
							"The undefined task tag option is not displayed in the task tag field of the filter as expected.");
					Reporter.log(
							"The undefined task tag option is not displayed in the task tag field of the filter as expected.");
					log.info(
							"The undefined task tag option is not displayed in the task tag field of the filter as expected.");
				}

			} catch (Throwable t) {
				System.out.println(
						"The undefined task tag option is not displayed in the task tag field of the filter as expected.");
				test.log(LogStatus.INFO,
						"The undefined task tag option is not displayed in the task tag field of the filter as expected.");
				Reporter.log(
						"The undefined task tag option is not displayed in the task tag field of the filter as expected.");
				log.info(
						"The undefined task tag option is not displayed in the task tag field of the filter as expected.");
			}

			// click on the clear filter button
			click("task_tasklist_clearfilterbtn_XPATH");
			ngDriver.waitForAngularRequestsToFinish();
			System.out.println("Clicked on the clear filter button.");

			// enter the task name in the search field
			clear("task_tasklist_searchtxt_CSS");
			ngDriver.waitForAngularRequestsToFinish();
			System.out.println("Cleared the search field.");
			type("task_tasklist_searchtxt_CSS", data.get("tasktag"));
			ngDriver.waitForAngularRequestsToFinish();
			System.out.println("Entered the task name in the search field.");

			try {
				// verify compliance option displayed or not
				boolean selectedTaskTag3 = driver
						.findElement(By.xpath(OR.getProperty("task_tasklist_tasktagcolumn2_XPATH"))).isDisplayed();

				if (selectedTaskTag3 == true) {
					TestUtil.captureScreenshot();

					// ReportNG
					Reporter.log("<br>"
							+ " The removed task tag option is displayed in the task tag column of the task list. : "
							+ "<br>");
					Reporter.log("<a target=\"_blank\" href=" + TestUtil.screenshotName + "><img src="
							+ TestUtil.screenshotName + " height=200 width=200></img></a>");
					Reporter.log("<br>");
					Reporter.log("<br>");

					// Extent Report
					test.log(LogStatus.FAIL,
							" The removed task tag option is displayed in the task tag column of the task list. : ");
					test.log(LogStatus.FAIL, test.addScreenCapture(TestUtil.screenshotName));

					System.out.println(
							"The removed task tag option is displayed in the task tag column of the task list.");
					log.info("The removed task tag option is displayed in the task tag column of the task list.");
				} else {
					System.out.println(
							"The removed task tag option is not displayed in the task tag column of the task list as expected.");
					test.log(LogStatus.INFO,
							"The removed task tag option is not displayed in the task tag column of the task list as expected.");
					Reporter.log(
							"The removed task tag option is not displayed in the task tag column of the task list as expected.");
					log.info(
							"The removed task tag option is not displayed in the task tag column of the task list as expected.");
				}

			} catch (Throwable t) {
				System.out.println(
						"The removed task tag option is not displayed in the task tag column of the task list as expected.");
				test.log(LogStatus.INFO,
						"The removed task tag option is not displayed in the task tag column of the task list as expected.");
				Reporter.log(
						"The removed task tag option is not displayed in the task tag column of the task list as expected.");
				log.info(
						"The removed task tag option is not displayed in the task tag column of the task list as expected.");
			}

		} catch (Throwable t) {
			verificationFailed();
		}

		// VERIFY TASK TAG IS DISPLAYED IN THE TASK TAG FIELD WHILE UPDATE THE TASK
		// DETAILS

		System.out.println(
				"******************** VERIFY TASK TAG IS DISPLAYED IN THE TASK TAG FIELD WHILE UPDATE THE TASK DETAILS ********************");
		test.log(LogStatus.INFO,
				"******************** VERIFY TASK TAG IS DISPLAYED IN THE TASK TAG FIELD WHILE UPDATE THE TASK DETAILS ********************");
		Reporter.log(
				"******************** VERIFY TASK TAG IS DISPLAYED IN THE TASK TAG FIELD WHILE UPDATE THE TASK DETAILS ********************");
		log.info(
				"******************** VERIFY TASK TAG IS DISPLAYED IN THE TASK TAG FIELD WHILE UPDATE THE TASK DETAILS ********************");

		try {
			// click on the newly created task
			click("task_createdtask_covid19newltcreatedtask_dashboard_XPATH");
			ngDriver.waitForAngularRequestsToFinish();
			System.out.println("Clicked on the newly created task.");

			// scroll down the screen
			WebElement ele4 = driver.findElement(By.xpath(OR.getProperty("task_createdtask_tagslabel_XPATH")));
			JavascriptExecutor js = (JavascriptExecutor) driver;
			js.executeScript("arguments[0].scrollIntoView(true);", ele4);

			// click on the tags field
			click("task_createdtask_tagstxt_CSS");
			ngDriver.waitForAngularRequestsToFinish();
			System.out.println("Clicked on the tags field.");

			// scroll down the screen
			js.executeScript("window.scrollBy(0,400)");

			// enter the task tag name in the search field for filter the record
			clear("task_tasklist_tagfilter_tagtxt_searchtxt_XPATH");
			ngDriver.waitForAngularRequestsToFinish();
			System.out.println("Cleared the task tag search field.");
			type("task_tasklist_tagfilter_tagtxt_searchtxt_XPATH", data.get("task_tag_name_3"));
			ngDriver.waitForAngularRequestsToFinish();
			System.out.println("Entered the task tag name in the search field.");

			// VERIFY DEFICIENCY TASK TAG OPTION IS DISPLAYED OR NOT IN THE TASK TAG FIELD

			System.out.println("VERIFY DEFICIENCY TASK TAG OPTION IS DISPLAYED OR NOT IN THE TASK TAG FIELD");
			test.log(LogStatus.INFO, "VERIFY DEFICIENCY TASK TAG OPTION IS DISPLAYED OR NOT IN THE TASK TAG FIELD");
			Reporter.log("VERIFY DEFICIENCY TASK TAG OPTION IS DISPLAYED OR NOT IN THE TASK TAG FIELD");
			log.info("VERIFY DEFICIENCY TASK TAG OPTION IS DISPLAYED OR NOT IN THE TASK TAG FIELD");

			try {

				boolean selectedTaskTag = driver
						.findElement(By.xpath(
								OR.getProperty("task_tasklist_tagfilter_tagtxt_searchedoption_newlycreatedtask_XPATH")))
						.isDisplayed();

				if (selectedTaskTag == true) {
					System.out.println(
							"The deficiency task tag option is displayed in the task tag field of the filter as expected.");
					test.log(LogStatus.INFO,
							"The deficiency task tag option is displayed in the task tag field of the filter as expected.");
					Reporter.log(
							"The deficiency task tag option is displayed in the task tag field of the filter as expected.");
					log.info(
							"The deficiency task tag option is displayed in the task tag field of the filter as expected.");

				} else {
					TestUtil.captureScreenshot();

					// ReportNG
					Reporter.log("<br>"
							+ " The deficiency task tag option is not displayed in the task tag field of the filter. : "
							+ "<br>");
					Reporter.log("<a target=\"_blank\" href=" + TestUtil.screenshotName + "><img src="
							+ TestUtil.screenshotName + " height=200 width=200></img></a>");
					Reporter.log("<br>");
					Reporter.log("<br>");

					// Extent Report
					test.log(LogStatus.FAIL,
							" The deficiency task tag option is not displayed in the task tag field of the filter. : ");
					test.log(LogStatus.FAIL, test.addScreenCapture(TestUtil.screenshotName));

					System.out.println(
							"The deficiency task tag option is not displayed in the task tag field of the filter.");
					log.info("The deficiency task tag option is not displayed in the task tag field of the filter.");
				}

			} catch (Throwable t) {
				TestUtil.captureScreenshot();

				// ReportNG
				Reporter.log("<br>"
						+ " The deficiency task tag option is not displayed in the task tag field of the filter. : "
						+ "<br>");
				Reporter.log("<a target=\"_blank\" href=" + TestUtil.screenshotName + "><img src="
						+ TestUtil.screenshotName + " height=200 width=200></img></a>");
				Reporter.log("<br>");
				Reporter.log("<br>");

				// Extent Report
				test.log(LogStatus.FAIL,
						" The deficiency task tag option is not displayed in the task tag field of the filter. : ");
				test.log(LogStatus.FAIL, test.addScreenCapture(TestUtil.screenshotName));

				System.out.println(
						"The deficiency task tag option is not displayed in the task tag field of the filter.");
				log.info("The deficiency task tag option is not displayed in the task tag field of the filter.");
			}

			// VERIFY DEFICIENCY TASK TAG OPTION IS DISPLAYED SELECTED OR NOT IN THE TASK
			// TAG FIELD

			System.out.println("VERIFY DEFICIENCY TASK TAG OPTION IS DISPLAYED SELECTED OR NOT IN THE TASK TAG FIELD");
			test.log(LogStatus.INFO,
					"VERIFY DEFICIENCY TASK TAG OPTION IS DISPLAYED SELECTED OR NOT IN THE TASK TAG FIELD");
			Reporter.log("VERIFY DEFICIENCY TASK TAG OPTION IS DISPLAYED SELECTED OR NOT IN THE TASK TAG FIELD");
			log.info("VERIFY DEFICIENCY TASK TAG OPTION IS DISPLAYED SELECTED OR NOT IN THE TASK TAG FIELD");

			try {

				boolean selectedTaskTag4 = driver
						.findElement(By.xpath(
								OR.getProperty("task_tasklist_tagfilter_seachedoutlineicon_newlycreatedtask_XPATH")))
						.isDisplayed();

				if (selectedTaskTag4 == true) {
					System.out.println(
							"The deficiency task tag option is not displayed selected in the task tag field of the filter as expected.");
					test.log(LogStatus.INFO,
							"The deficiency task tag option is not displayed selected in the task tag field of the filter as expected.");
					Reporter.log(
							"The deficiency task tag option is not displayed selected in the task tag field of the filter as expected.");
					log.info(
							"The deficiency task tag option is not displayed selected in the task tag field of the filter as expected.");

					// click on the searched compliance task tag option
					click("task_tasklist_tagfilter_seachedoutlineicon_newlycreatedtask_XPATH");
					ngDriver.waitForAngularRequestsToFinish();
					System.out.println("Clicked on the searched compliance task tag option.");

					// click on the tags field
					click("task_createdtask_tagstxt_CSS");
					ngDriver.waitForAngularRequestsToFinish();
					System.out.println("Clicked on the tags field.");

				} else {
					TestUtil.captureScreenshot();

					// ReportNG
					Reporter.log("<br>"
							+ " The deficiency task tag option is displayed selected in the task tag field of the filter. : "
							+ "<br>");
					Reporter.log("<a target=\"_blank\" href=" + TestUtil.screenshotName + "><img src="
							+ TestUtil.screenshotName + " height=200 width=200></img></a>");
					Reporter.log("<br>");
					Reporter.log("<br>");

					// Extent Report
					test.log(LogStatus.FAIL,
							" The deficiency task tag option is displayed selected in the task tag field of the filter. : ");
					test.log(LogStatus.FAIL, test.addScreenCapture(TestUtil.screenshotName));

					System.out.println(
							"The deficiency task tag option is displayed selected in the task tag field of the filter.");
					log.info(
							"The deficiency task tag option is displayed selected in the task tag field of the filter.");
				}

			} catch (Throwable t) {
				TestUtil.captureScreenshot();

				// ReportNG
				Reporter.log("<br>"
						+ " The deficiency task tag option is displayed selected in the task tag field of the filter. : "
						+ "<br>");
				Reporter.log("<a target=\"_blank\" href=" + TestUtil.screenshotName + "><img src="
						+ TestUtil.screenshotName + " height=200 width=200></img></a>");
				Reporter.log("<br>");
				Reporter.log("<br>");

				// Extent Report
				test.log(LogStatus.FAIL,
						" The deficiency task tag option is displayed selected in the task tag field of the filter. : ");
				test.log(LogStatus.FAIL, test.addScreenCapture(TestUtil.screenshotName));

				System.out.println(
						"The deficiency task tag option is displayed selected in the task tag field of the filter.");
				log.info("The deficiency task tag option is displayed selected in the task tag field of the filter.");
			}

			// click on the update button
			click("task_tasktag_taskscreen_updatebtn_CSS");
			ngDriver.waitForAngularRequestsToFinish();
			System.out.println("Clicked on the update button.");

			// wait for the element
			explicitWaitClickable("closetoastmsg_CSS");

			// click on the toaster close button
			click("closetoastmsg_CSS");
			ngDriver.waitForAngularRequestsToFinish();
			System.out.println("Clicked on the toaster close button.");

			// click on the task tag field for filter the records
			click("task_tasklist_tagfilter_tagtxt_XPATH");
			ngDriver.waitForAngularRequestsToFinish();
			System.out.println("Clicked on the task tag field for filter the records.");

			// enter the task tag name in the search field for filter the record
			clear("task_tasklist_tagfilter_tagtxt_searchtxt_XPATH");
			ngDriver.waitForAngularRequestsToFinish();
			System.out.println("Cleared the task tag search field.");
			type("task_tasklist_tagfilter_tagtxt_searchtxt_XPATH", data.get("task_tag_name_3"));
			ngDriver.waitForAngularRequestsToFinish();
			System.out.println("Entered the task tag name in the search field.");

			// VERIFY DEFICIENCY OPTION DISPLAYED SELECTED OR NOT IN THE TASK TAG FIELD OF
			// THE FILTER

			System.out
					.println("VERIFY DEFICIENCY OPTION DISPLAYED SELECTED OR NOT IN THE TASK TAG FIELD OF THE FILTER");
			test.log(LogStatus.INFO,
					"VERIFY DEFICIENCY OPTION DISPLAYED SELECTED OR NOT IN THE TASK TAG FIELD OF THE FILTER");
			Reporter.log("VERIFY DEFICIENCY OPTION DISPLAYED SELECTED OR NOT IN THE TASK TAG FIELD OF THE FILTER");
			log.info("VERIFY DEFICIENCY OPTION DISPLAYED SELECTED OR NOT IN THE TASK TAG FIELD OF THE FILTER");

			try {

				boolean selectedTaskTag = driver
						.findElement(By.xpath(OR
								.getProperty("task_tasklist_tagfilter_selectedoptionwithicon_newlycreatedtask_XPATH")))
						.isDisplayed();

				if (selectedTaskTag == true) {
					System.out.println(
							"The deficiency task tag option is displayed selected in the task tag field of the filter as expected.");
					test.log(LogStatus.INFO,
							"The deficiency task tag option is displayed selected in the task tag field of the filter as expected.");
					Reporter.log(
							"The deficiency task tag option is displayed selected in the task tag field of the filter as expected.");
					log.info(
							"The deficiency task tag option is displayed selected in the task tag field of the filter as expected.");

				} else {
					TestUtil.captureScreenshot();

					// ReportNG
					Reporter.log("<br>"
							+ " The deficiency task tag option is not displayed selected in the task tag field of the filter. : "
							+ "<br>");
					Reporter.log("<a target=\"_blank\" href=" + TestUtil.screenshotName + "><img src="
							+ TestUtil.screenshotName + " height=200 width=200></img></a>");
					Reporter.log("<br>");
					Reporter.log("<br>");

					// Extent Report
					test.log(LogStatus.FAIL,
							" The deficiency task tag option is not displayed selected in the task tag field of the filter. : ");
					test.log(LogStatus.FAIL, test.addScreenCapture(TestUtil.screenshotName));

					System.out.println(
							"The deficiency task tag option is not displayed selected in the task tag field of the filter.");
					log.info(
							"The deficiency task tag option is not displayed selected in the task tag field of the filter.");
				}

			} catch (Throwable t) {
				TestUtil.captureScreenshot();

				// ReportNG
				Reporter.log("<br>"
						+ " The deficiency task tag option is not displayed selected in the task tag field of the filter. : "
						+ "<br>");
				Reporter.log("<a target=\"_blank\" href=" + TestUtil.screenshotName + "><img src="
						+ TestUtil.screenshotName + " height=200 width=200></img></a>");
				Reporter.log("<br>");
				Reporter.log("<br>");

				// Extent Report
				test.log(LogStatus.FAIL,
						" The deficiency task tag option is not displayed selected in the task tag field of the filter. : ");
				test.log(LogStatus.FAIL, test.addScreenCapture(TestUtil.screenshotName));

				System.out.println(
						"The deficiency task tag option is not displayed selected in the task tag field of the filter.");
				log.info(
						"The deficiency task tag option is not displayed selected in the task tag field of the filter.");
			}

			try {

				// enter the task tag name in the search field
				clear("task_tasklist_tagfilter_tagtxt_searchtxt_XPATH");
				ngDriver.waitForAngularRequestsToFinish();
				System.out.println("Cleared the task tag search field.");
				type("task_tasklist_tagfilter_tagtxt_searchtxt_XPATH", data.get("task_tag_name_2"));
				ngDriver.waitForAngularRequestsToFinish();
				System.out.println("Entered the task tag name in the search field.");

				// VERIFY UNDEFINED OPTION DISPLAYED SELECTED OR NOT IN THE TASK TAG FIELD OF
				// THE FILTER

				System.out.println(
						"VERIFY UNDEFINED OPTION DISPLAYED SELECTED OR NOT IN THE TASK TAG FIELD OF THE FILTER");
				test.log(LogStatus.INFO,
						"VERIFY UNDEFINED OPTION DISPLAYED SELECTED OR NOT IN THE TASK TAG FIELD OF THE FILTER");
				Reporter.log("VERIFY UNDEFINED OPTION DISPLAYED SELECTED OR NOT IN THE TASK TAG FIELD OF THE FILTER");
				log.info("VERIFY UNDEFINED OPTION DISPLAYED SELECTED OR NOT IN THE TASK TAG FIELD OF THE FILTER");

				boolean selectedTaskTag2 = driver
						.findElement(By.xpath(OR.getProperty("task_tasklist_tagfilter_undefined_XPATH"))).isDisplayed();

				if (selectedTaskTag2 == true) {
					TestUtil.captureScreenshot();

					// ReportNG
					Reporter.log("<br>"
							+ " The undefined task tag option is displayed in the task tag field of the filter. : "
							+ "<br>");
					Reporter.log("<a target=\"_blank\" href=" + TestUtil.screenshotName + "><img src="
							+ TestUtil.screenshotName + " height=200 width=200></img></a>");
					Reporter.log("<br>");
					Reporter.log("<br>");

					// Extent Report
					test.log(LogStatus.FAIL,
							" The undefined task tag option is displayed in the task tag field of the filter. : ");
					test.log(LogStatus.FAIL, test.addScreenCapture(TestUtil.screenshotName));

					System.out
							.println("The undefined task tag option is displayed in the task tag field of the filter.");
					log.info("The undefined task tag option is displayed in the task tag field of the filter.");
				} else {
					System.out.println(
							"The undefined task tag option is not displayed in the task tag field of the filter as expected.");
					test.log(LogStatus.INFO,
							"The undefined task tag option is not displayed in the task tag field of the filter as expected.");
					Reporter.log(
							"The undefined task tag option is not displayed in the task tag field of the filter as expected.");
					log.info(
							"The undefined task tag option is not displayed in the task tag field of the filter as expected.");
				}

			} catch (Throwable t) {
				System.out.println(
						"The undefined task tag option is not displayed in the task tag field of the filter as expected.");
				test.log(LogStatus.INFO,
						"The undefined task tag option is not displayed in the task tag field of the filter as expected.");
				Reporter.log(
						"The undefined task tag option is not displayed in the task tag field of the filter as expected.");
				log.info(
						"The undefined task tag option is not displayed in the task tag field of the filter as expected.");
			}

			// click on the clear filter button
			click("task_tasklist_clearfilterbtn_XPATH");
			ngDriver.waitForAngularRequestsToFinish();
			System.out.println("Clicked on the clear filter button.");

			// enter the task name in the search field
			clear("task_tasklist_searchtxt_CSS");
			ngDriver.waitForAngularRequestsToFinish();
			System.out.println("Cleared the search field.");
			type("task_tasklist_searchtxt_CSS", data.get("tasktag"));
			ngDriver.waitForAngularRequestsToFinish();
			System.out.println("Entered the task name in the search field.");

			try {
				// verify compliance option displayed or not
				boolean selectedTaskTag3 = driver
						.findElement(By.xpath(OR.getProperty("task_tasklist_tasktagcolumn2_XPATH"))).isDisplayed();

				if (selectedTaskTag3 == true) {

					System.out.println(
							"The added task tag option is displayed in the task tag column of the task list as expected.");
					test.log(LogStatus.INFO,
							"The added task tag option is displayed in the task tag column of the task list as expected.");
					Reporter.log(
							"The added task tag option is displayed in the task tag column of the task list as expected.");
					log.info(
							"The added task tag option is displayed in the task tag column of the task list as expected.");

				} else {
					TestUtil.captureScreenshot();

					// ReportNG
					Reporter.log("<br>"
							+ " The added task tag option is not displayed in the task tag column of the task list. : "
							+ "<br>");
					Reporter.log("<a target=\"_blank\" href=" + TestUtil.screenshotName + "><img src="
							+ TestUtil.screenshotName + " height=200 width=200></img></a>");
					Reporter.log("<br>");
					Reporter.log("<br>");

					// Extent Report
					test.log(LogStatus.FAIL,
							" The added task tag option is not displayed in the task tag column of the task list. : ");
					test.log(LogStatus.FAIL, test.addScreenCapture(TestUtil.screenshotName));

					System.out.println(
							"The added task tag option is not displayed in the task tag column of the task list.");
					log.info("The added task tag option is not displayed in the task tag column of the task list.");
				}

			} catch (Throwable t) {
				TestUtil.captureScreenshot();

				// ReportNG
				Reporter.log("<br>"
						+ " The added task tag option is not displayed in the task tag column of the task list. : "
						+ "<br>");
				Reporter.log("<a target=\"_blank\" href=" + TestUtil.screenshotName + "><img src="
						+ TestUtil.screenshotName + " height=200 width=200></img></a>");
				Reporter.log("<br>");
				Reporter.log("<br>");

				// Extent Report
				test.log(LogStatus.FAIL,
						" The added task tag option is not displayed in the task tag column of the task list. : ");
				test.log(LogStatus.FAIL, test.addScreenCapture(TestUtil.screenshotName));

				System.out
						.println("The added task tag option is not displayed in the task tag column of the task list.");
				log.info("The added task tag option is not displayed in the task tag column of the task list.");
			}

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

		// DELETE THE INSTANCE

		System.out.println("**************** DELETE THE INSTANCE ****************");
		test.log(LogStatus.INFO, "**************** DELETE THE INSTANCE ****************");
		Reporter.log("**************** DELETE THE INSTANCE ****************");
		log.info("**************** DELETE THE INSTANCE ****************");

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

			// enter newly created inspection in the search field
			clear("task_listofchecklist_filterfield_CSS");
			ngDriver.waitForAngularRequestsToFinish();
			System.out.println("Cleared the search field.");
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
			deleteVerification("questionnaire_checklist_createdinspectioncovid19_6_XPATH",
					"Test Questionnaire Property Title Smoke Capreit Six");

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
