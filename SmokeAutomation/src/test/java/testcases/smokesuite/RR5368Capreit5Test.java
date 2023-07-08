package testcases.smokesuite;

import java.io.IOException;
import java.time.LocalDate;
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

import base.Helper;
import base.TestBase;
import utilities.TestUtil;

public class RR5368Capreit5Test extends TestBase {

	@Test(dataProviderClass = TestUtil.class, dataProvider = "dp")
	public void rR5368Capreit5Test(Hashtable<String, String> data) throws IOException, InterruptedException {

		if (!(TestUtil.isTestRunnable("rR5368Capreit5Test", excel))) {

			throw new SkipException(
					"Skipping the test " + "rR5368Capreit5Test".toUpperCase() + "as the Run mode is NO");
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

		int property = 0;
		int task = 0;
		int openTask = 0;

		// PORTFOLIO SUMMARY AND INSPECTIONS DASHBOARDS - OPERATION MANAGER

		System.out.println(
				"******************** PORTFOLIO SUMMARY AND INSPECTIONS DASHBOARDS - OPERATION MANAGER ********************");
		test.log(LogStatus.INFO,
				"******************** PORTFOLIO SUMMARY AND INSPECTIONS DASHBOARDS - OPERATION MANAGER ********************");
		Reporter.log(
				"******************** PORTFOLIO SUMMARY AND INSPECTIONS DASHBOARDS - OPERATION MANAGER ********************");
		log.info(
				"******************** PORTFOLIO SUMMARY AND INSPECTIONS DASHBOARDS - OPERATION MANAGER ********************");

		try {

			try {
				// LOGIN WITH OPERATION MANAGER USER

				System.out.println("******************** LOGIN WITH OPERATION MANAGER USER ********************");
				test.log(LogStatus.INFO, "******************** LOGIN WITH OPERATION MANAGER USER ********************");
				Reporter.log("******************** LOGIN WITH OPERATION MANAGER USER ********************");
				log.info("******************** LOGIN WITH OPERATION MANAGER USER ********************");

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

			// VERIFY INSPECTION CARD ON THE PORTFOLIO SUMMARY DASHBOARD SCREEN WITHOUT
			// ADDING THE INSPECTION - OPERATION MANAGER

			System.out.println(
					"******************** VERIFY INSPECTION CARD ON THE PORTFOLIO SUMMARY DASHBOARD SCREEN WITHOUT ADDING THE INSPECTION - OPERATION MANAGER ********************");
			test.log(LogStatus.INFO,
					"******************** VERIFY INSPECTION CARD ON THE PORTFOLIO SUMMARY DASHBOARD SCREEN WITHOUT ADDING THE INSPECTION - OPERATION MANAGER ********************");
			Reporter.log(
					"******************** VERIFY INSPECTION CARD ON THE PORTFOLIO SUMMARY DASHBOARD SCREEN WITHOUT ADDING THE INSPECTION - OPERATION MANAGER ********************");
			log.info(
					"******************** VERIFY INSPECTION CARD ON THE PORTFOLIO SUMMARY DASHBOARD SCREEN WITHOUT ADDING THE INSPECTION - OPERATION MANAGER ********************");

			try {

				// wait for the element
				Thread.sleep(5000);

				// click on the side menu
				click("menubtn_CSS");
				ngDriver.waitForAngularRequestsToFinish();
				System.out.println("Clicked on the side menu.");

				// wait for the element
				Thread.sleep(5000);

				// click on the portfolio summary option
				click("sidemenu_portfoliosummary_XPATH");
				ngDriver.waitForAngularRequestsToFinish();
				System.out.println("Clicked on the portfolio summary option.");

				try {
					// scroll down the screen
					JavascriptExecutor js = (JavascriptExecutor) driver;
					WebElement inspectionOM = driver
							.findElement(By.xpath(OR.getProperty("portfoliosummary_inspection2_XPATH")));
					js.executeScript("arguments[0].scrollIntoView(true);", inspectionOM);
					js.executeScript("window.scrollBy(0,-200)");

					String propertyString = (driver
							.findElement(By.cssSelector(OR.getProperty("portfoliosummary_inspection2_property_CSS")))
							.getText()).trim();

					String taskString = (driver
							.findElement(By.cssSelector(OR.getProperty("portfoliosummary_inspection2_task_CSS")))
							.getText()).trim();

					property = Integer.parseInt(propertyString);
					task = Integer.parseInt(taskString);

					System.out.println("THE RESPECTIVE INSPECTION IS DISPLAYED AS EXPECTED.");
					test.log(LogStatus.INFO, "THE RESPECTIVE INSPECTION IS DISPLAYED AS EXPECTED.");
					Reporter.log("THE RESPECTIVE INSPECTION IS DISPLAYED AS EXPECTED.");
					log.info("THE RESPECTIVE INSPECTION IS DISPLAYED AS EXPECTED.");

				} catch (Throwable t) {

					TestUtil.captureScreenshot();

					// ReportNG
					Reporter.log("<br>"
							+ " The inspection is not displayed in the portfolio summary screen without adding inspection. : "
							+ "<br>");
					Reporter.log("<a target=\"_blank\" href=" + TestUtil.screenshotName + "><img src="
							+ TestUtil.screenshotName + " height=200 width=200></img></a>");
					Reporter.log("<br>");
					Reporter.log("<br>");

					// Extent Report
					test.log(LogStatus.FAIL,
							" The inspection is not displayed in the portfolio summary screen without adding inspection. : ");
					test.log(LogStatus.FAIL, test.addScreenCapture(TestUtil.screenshotName));

					System.out.println(
							"The inspection is not displayed in the portfolio summary screen without adding inspection.");
					log.info(
							"The inspection is not displayed in the portfolio summary screen without adding inspection.");

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

			// CREATE THE NEW INSPECTION AND CHECKLIST - OPERATION MANAGER

			System.out.println(
					"******************** CREATE THE NEW INSPECTION AND CHECKLIST - OPERATION MANAGER ********************");
			test.log(LogStatus.INFO,
					"******************** CREATE THE NEW INSPECTION AND CHECKLIST - OPERATION MANAGER ********************");
			Reporter.log(
					"******************** CREATE THE NEW INSPECTION AND CHECKLIST - OPERATION MANAGER ********************");
			log.info(
					"******************** CREATE THE NEW INSPECTION AND CHECKLIST - OPERATION MANAGER ********************");

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

				// verify questionnaire is selected correctly or not

				String covidtxt = driver
						.findElement(By.xpath(OR.getProperty("checklist_wizard_inspectiontitle5_XPATH"))).getText();

				System.out.println("COVID 19 INSTECTION TITLE : " + covidtxt);

				switchVerification("checklist_wizard_inspectiontitle5_XPATH",
						"Test Questionnaire Property Title Smoke Capreit Five",
						"The Test Questionnaire Property Title Smoke Capreit Five is not displayed.");

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

			// VERIFY THE NEWLY CREATED INSPECTION IN PORTFOLIO SUMMARY DASHBOARD

			System.out.println(
					"******************** VERIFY THE NEWLY CREATED INSPECTION COUNT IN PORTFOLIO SUMMARY DASHBOARD ********************");
			test.log(LogStatus.INFO,
					"******************** VERIFY THE NEWLY CREATED INSPECTION COUNT IN PORTFOLIO SUMMARY DASHBOARD ********************");
			Reporter.log(
					"******************** VERIFY THE NEWLY CREATED INSPECTION COUNT IN PORTFOLIO SUMMARY DASHBOARD ********************");
			log.info(
					"******************** VERIFY THE NEWLY CREATED INSPECTION COUNT IN PORTFOLIO SUMMARY DASHBOARD ********************");

			try {

				// wait for the element
				Thread.sleep(5000);

				// click on the side menu
				click("menubtn_CSS");
				ngDriver.waitForAngularRequestsToFinish();
				System.out.println("Clicked on the side menu.");

				// wait for the element
				Thread.sleep(5000);

				// click on the portfolio summary option
				click("sidemenu_portfoliosummary_XPATH");
				ngDriver.waitForAngularRequestsToFinish();
				System.out.println("Clicked on the portfolio summary option.");

				// scroll down the screen
				JavascriptExecutor js = (JavascriptExecutor) driver;
				WebElement inspectionOM = driver
						.findElement(By.xpath(OR.getProperty("portfoliosummary_inspection2_XPATH")));
				js.executeScript("arguments[0].scrollIntoView(true);", inspectionOM);
				js.executeScript("window.scrollBy(0,-200)");

				// VERIFY INSPECTION DETAILS IN THE PORTFOLIO SUMMARY DASHBOARD SCREEN

				System.out.println(
						"******************** VERIFY INSPECTION DETAILS IN THE PORTFOLIO SUMMARY DASHBOARD SCREEN ********************");
				test.log(LogStatus.INFO,
						"******************** VERIFY INSPECTION DETAILS IN THE PORTFOLIO SUMMARY DASHBOARD SCREEN ********************");
				Reporter.log(
						"******************** VERIFY INSPECTION DETAILS IN THE PORTFOLIO SUMMARY DASHBOARD SCREEN ********************");
				log.info(
						"******************** VERIFY INSPECTION DETAILS IN THE PORTFOLIO SUMMARY DASHBOARD SCREEN ********************");

				// VERIFY COUNT OF THE PROPERTY AFTER CREATED THE INSPECTION

				try {
					String property1String = (driver
							.findElement(By.cssSelector(OR.getProperty("portfoliosummary_inspection2_property_CSS")))
							.getText()).trim();

					int property1 = Integer.parseInt(property1String);

					if (property == (property1)) {
						System.out.println("The property count of the inspection is displayed correctly.");
						test.log(LogStatus.INFO, "The property count of the inspection is displayed correctly.");
						Reporter.log("The property count of the inspection is displayed correctly.");
						log.info("The property count of the inspection is displayed correctly.");
					} else {
						TestUtil.captureScreenshot();

						// ReportNG
						Reporter.log(
								"<br>" + " The property count of the inspection is displayed incorrectly. : " + "<br>");
						Reporter.log("<a target=\"_blank\" href=" + TestUtil.screenshotName + "><img src="
								+ TestUtil.screenshotName + " height=200 width=200></img></a>");
						Reporter.log("<br>");
						Reporter.log("<br>");

						// Extent Report
						test.log(LogStatus.FAIL, " The property count of the inspection is displayed incorrectly. : ");
						test.log(LogStatus.FAIL, test.addScreenCapture(TestUtil.screenshotName));

						System.out.println("The property count of the inspection is displayed incorrectly.");
						log.info("The property count of the inspection is displayed incorrectly.");
					}

				} catch (Throwable t) {
					TestUtil.captureScreenshot();

					// ReportNG
					Reporter.log(
							"<br>" + " The property count of the inspection is displayed incorrectly. : " + "<br>");
					Reporter.log("<a target=\"_blank\" href=" + TestUtil.screenshotName + "><img src="
							+ TestUtil.screenshotName + " height=200 width=200></img></a>");
					Reporter.log("<br>");
					Reporter.log("<br>");

					// Extent Report
					test.log(LogStatus.FAIL, " The property count of the inspection is displayed incorrectly. : ");
					test.log(LogStatus.FAIL, test.addScreenCapture(TestUtil.screenshotName));

					System.out.println("The property count of the inspection is displayed incorrectly.");
					log.info("The property count of the inspection is displayed incorrectly.");
				}

				// VERIFY COUNT OF THE ACTIVE TASKS AFTER CREATED THE INSPECTION

				try {
					String task1String = (driver
							.findElement(By.cssSelector(OR.getProperty("portfoliosummary_inspection2_task_CSS")))
							.getText()).trim();

					int task1 = Integer.parseInt(task1String);

					if (task == (task1)) {
						System.out.println("The active task count of the inspection is displayed correctly.");
						test.log(LogStatus.INFO, "The active task count of the inspection is displayed correctly.");
						Reporter.log("The active task count of the inspection is displayed correctly.");
						log.info("The active task count of the inspection is displayed correctly.");

					} else {
						TestUtil.captureScreenshot();

						// ReportNG
						Reporter.log("<br>" + " The active task count of the inspection is displayed incorrectly. : "
								+ "<br>");
						Reporter.log("<a target=\"_blank\" href=" + TestUtil.screenshotName + "><img src="
								+ TestUtil.screenshotName + " height=200 width=200></img></a>");
						Reporter.log("<br>");
						Reporter.log("<br>");

						// Extent Report
						test.log(LogStatus.FAIL,
								" The active task count of the inspection is displayed incorrectly. : ");
						test.log(LogStatus.FAIL, test.addScreenCapture(TestUtil.screenshotName));

						System.out.println("The active task count of the inspection is displayed incorrectly.");
						log.info("The active task count of the inspection is displayed incorrectly.");
					}

				} catch (Throwable t) {
					TestUtil.captureScreenshot();

					// ReportNG
					Reporter.log(
							"<br>" + " The active task count of the inspection is displayed incorrectly. : " + "<br>");
					Reporter.log("<a target=\"_blank\" href=" + TestUtil.screenshotName + "><img src="
							+ TestUtil.screenshotName + " height=200 width=200></img></a>");
					Reporter.log("<br>");
					Reporter.log("<br>");

					// Extent Report
					test.log(LogStatus.FAIL, " The active task count of the inspection is displayed incorrectly. : ");
					test.log(LogStatus.FAIL, test.addScreenCapture(TestUtil.screenshotName));

					System.out.println("The active task count of the inspection is displayed incorrectly.");
					log.info("The active task count of the inspection is displayed incorrectly.");
				}

				// VERIFY INSPECTION DETAILS IN THE INSPECTION LIST SCREEN

				System.out.println(
						"******************** VERIFY INSPECTION DETAILS IN THE INSPECTION LIST SCREEN ********************");
				test.log(LogStatus.INFO,
						"******************** VERIFY INSPECTION DETAILS IN THE INSPECTION LIST SCREEN ********************");
				Reporter.log(
						"******************** VERIFY INSPECTION DETAILS IN THE INSPECTION LIST SCREEN ********************");
				log.info(
						"******************** VERIFY INSPECTION DETAILS IN THE INSPECTION LIST SCREEN ********************");

				// click on the property count
				click("portfoliosummary_inspection2_property_CSS");
				ngDriver.waitForAngularRequestsToFinish();
				System.out.println("Clicked on the property count.");

				// VERIFY THE OPEN TASK COUNT

				try {

					String openTaskString = driver
							.findElement(
									By.xpath(OR.getProperty("portfoliosummary_inspection2_inspectionlist_task_XPATH")))
							.getText();

					openTask = Integer.parseInt(openTaskString);

					if (openTask == 0) {
						System.out.println("The open task count of the inspection is displayed correctly.");
						test.log(LogStatus.INFO, "The open task count of the inspection is displayed correctly.");
						Reporter.log("The open task count of the inspection is displayed correctly.");
						log.info("The open task count of the inspection is displayed correctly.");

					} else {
						TestUtil.captureScreenshot();

						// ReportNG
						Reporter.log("<br>" + " The open task count of the inspection is displayed incorrectly. : "
								+ "<br>");
						Reporter.log("<a target=\"_blank\" href=" + TestUtil.screenshotName + "><img src="
								+ TestUtil.screenshotName + " height=200 width=200></img></a>");
						Reporter.log("<br>");
						Reporter.log("<br>");

						// Extent Report
						test.log(LogStatus.FAIL, " The open task count of the inspection is displayed incorrectly. : ");
						test.log(LogStatus.FAIL, test.addScreenCapture(TestUtil.screenshotName));

						System.out.println("The open task count of the inspection is displayed incorrectly.");
						log.info("The open task count of the inspection is displayed incorrectly.");
					}

				} catch (Throwable t) {
					TestUtil.captureScreenshot();

					// ReportNG
					Reporter.log(
							"<br>" + " The open task count of the inspection is displayed incorrectly. : " + "<br>");
					Reporter.log("<a target=\"_blank\" href=" + TestUtil.screenshotName + "><img src="
							+ TestUtil.screenshotName + " height=200 width=200></img></a>");
					Reporter.log("<br>");
					Reporter.log("<br>");

					// Extent Report
					test.log(LogStatus.FAIL, " The open task count of the inspection is displayed incorrectly. : ");
					test.log(LogStatus.FAIL, test.addScreenCapture(TestUtil.screenshotName));

					System.out.println("The open task count of the inspection is displayed incorrectly.");
					log.info("The open task count of the inspection is displayed incorrectly.");
				}

				// click on the fourth circle
				click("portfoliosummary_inspection2_inspectionlist_circle_XPATH");
				ngDriver.waitForAngularRequestsToFinish();
				System.out.println("Clicked on the fourth circle.");

				// VERIFY INSPECTION DETAILS IN THE CREATE CHECKLIST LIST SCREEN

				System.out.println(
						"******************** VERIFY INSPECTION DETAILS IN THE CREATE CHECKLIST LIST SCREEN ********************");
				test.log(LogStatus.INFO,
						"******************** VERIFY INSPECTION DETAILS IN THE CREATE CHECKLIST LIST SCREEN ********************");
				Reporter.log(
						"******************** VERIFY INSPECTION DETAILS IN THE CREATE CHECKLIST LIST SCREEN ********************");
				log.info(
						"******************** VERIFY INSPECTION DETAILS IN THE CREATE CHECKLIST LIST SCREEN ********************");

				// enter the inspection name in the search field
				type("task_listofchecklist_filterfield_CSS", data.get("checklist_property_title"));
				ngDriver.waitForAngularRequestsToFinish();
				System.out.println("Entered the inspection name in the search field.");

				// VERIFY NEWLY CREATED INSPECTION IS DISPLAYED OR NOT

				try {
					String inspectionName = driver
							.findElement(By.xpath(OR.getProperty("inspection_createdinspection5_XPATH"))).getText();

					if (inspectionName.equals("Test Questionnaire Property Title Smoke Capreit Five")) {
						System.out.println("The inspection is displayed correctly.");
						test.log(LogStatus.INFO, "The inspection is displayed correctly.");
						Reporter.log("The inspection is displayed correctly.");
						log.info("The inspection is displayed correctly.");
					} else {
						TestUtil.captureScreenshot();

						// ReportNG
						Reporter.log("<br>" + " The inspection is not displayed. : " + "<br>");
						Reporter.log("<a target=\"_blank\" href=" + TestUtil.screenshotName + "><img src="
								+ TestUtil.screenshotName + " height=200 width=200></img></a>");
						Reporter.log("<br>");
						Reporter.log("<br>");

						// Extent Report
						test.log(LogStatus.FAIL, " The inspection is not displayed. : ");
						test.log(LogStatus.FAIL, test.addScreenCapture(TestUtil.screenshotName));

						System.out.println("The inspection is not displayed.");
						log.info("The inspection is not displayed.");
					}

				} catch (Throwable t) {
					TestUtil.captureScreenshot();

					// ReportNG
					Reporter.log("<br>" + " The inspection is not displayed. : " + "<br>");
					Reporter.log("<a target=\"_blank\" href=" + TestUtil.screenshotName + "><img src="
							+ TestUtil.screenshotName + " height=200 width=200></img></a>");
					Reporter.log("<br>");
					Reporter.log("<br>");

					// Extent Report
					test.log(LogStatus.FAIL, " The inspection is not displayed. : ");
					test.log(LogStatus.FAIL, test.addScreenCapture(TestUtil.screenshotName));

					System.out.println("The inspection is not displayed.");
					log.info("The inspection is not displayed.");
				}

				// VERIFY COMPLETION OF THE INSPECTION

				try {

					String inspectionCompletion = driver
							.findElement(By.xpath(
									OR.getProperty("portfoliosummary_inspection2_inspectionlist_completion_XPATH")))
							.getText();

					if (inspectionCompletion.equals("0%")) {
						System.out.println("The completion percentage of the inspection is displayed correctly.");
						test.log(LogStatus.INFO, "The completion percentage of the inspection is displayed correctly.");
						Reporter.log("The completion percentage of the inspection is displayed correctly.");
						log.info("The completion percentage of the inspection is displayed correctly.");
					} else {
						TestUtil.captureScreenshot();

						// ReportNG
						Reporter.log("<br>"
								+ " The completion percentage of the inspection is displayed incorrectly. : " + "<br>");
						Reporter.log("<a target=\"_blank\" href=" + TestUtil.screenshotName + "><img src="
								+ TestUtil.screenshotName + " height=200 width=200></img></a>");
						Reporter.log("<br>");
						Reporter.log("<br>");

						// Extent Report
						test.log(LogStatus.FAIL,
								" The completion percentage of the inspection is displayed incorrectly. : ");
						test.log(LogStatus.FAIL, test.addScreenCapture(TestUtil.screenshotName));

						System.out.println("The completion percentage of the inspection is displayed incorrectly.");
						log.info("The completion percentage of the inspection is displayed incorrectly.");
					}

				} catch (Throwable t) {

					TestUtil.captureScreenshot();

					// ReportNG
					Reporter.log("<br>" + " The completion percentage of the inspection is displayed incorrectly. : "
							+ "<br>");
					Reporter.log("<a target=\"_blank\" href=" + TestUtil.screenshotName + "><img src="
							+ TestUtil.screenshotName + " height=200 width=200></img></a>");
					Reporter.log("<br>");
					Reporter.log("<br>");

					// Extent Report
					test.log(LogStatus.FAIL,
							" The completion percentage of the inspection is displayed incorrectly. : ");
					test.log(LogStatus.FAIL, test.addScreenCapture(TestUtil.screenshotName));

					System.out.println("The completion percentage of the inspection is displayed incorrectly.");
					log.info("The completion percentage of the inspection is displayed incorrectly.");
				}

				// VERIFY TOTAL TASK OF THE INSPECTION

				try {

					String inspectionTotalTaskString = driver
							.findElement(By.xpath(
									OR.getProperty("portfoliosummary_inspection2_inspectionlist_totaltask_XPATH")))
							.getText();

					int inspectionTotalTask = Integer.parseInt(inspectionTotalTaskString);

					if (task == inspectionTotalTask) {
						System.out.println("The total task of the inspection is displayed correctly.");
						test.log(LogStatus.INFO, "The total task of the inspection is displayed correctly.");
						Reporter.log("The total task of the inspection is displayed correctly.");
						log.info("The total task of the inspection is displayed correctly.");
					} else {
						TestUtil.captureScreenshot();

						// ReportNG
						Reporter.log(
								"<br>" + " The total task of the inspection is displayed incorrectly. : " + "<br>");
						Reporter.log("<a target=\"_blank\" href=" + TestUtil.screenshotName + "><img src="
								+ TestUtil.screenshotName + " height=200 width=200></img></a>");
						Reporter.log("<br>");
						Reporter.log("<br>");

						// Extent Report
						test.log(LogStatus.FAIL, " The total task of the inspection is displayed incorrectly. : ");
						test.log(LogStatus.FAIL, test.addScreenCapture(TestUtil.screenshotName));

						System.out.println("The total task of the inspection is displayed incorrectly.");
						log.info("The total task of the inspection is displayed incorrectly.");
					}

				} catch (Throwable t) {

					TestUtil.captureScreenshot();

					// ReportNG
					Reporter.log("<br>" + " The total task of the inspection is displayed incorrectly. : " + "<br>");
					Reporter.log("<a target=\"_blank\" href=" + TestUtil.screenshotName + "><img src="
							+ TestUtil.screenshotName + " height=200 width=200></img></a>");
					Reporter.log("<br>");
					Reporter.log("<br>");

					// Extent Report
					test.log(LogStatus.FAIL, " The total task of the inspection is displayed incorrectly. : ");
					test.log(LogStatus.FAIL, test.addScreenCapture(TestUtil.screenshotName));

					System.out.println("The total task of the inspection is displayed incorrectly.");
					log.info("The total task of the inspection is displayed incorrectly.");
				}

				// VERIFY OPEN TASK OF THE INSPECTION

				try {

					String inspectionCompletionString = driver
							.findElement(By.xpath(
									OR.getProperty("portfoliosummary_inspection2_inspectionlist_opentask_XPATH")))
							.getText();

					int inspectionCompletion = Integer.parseInt(inspectionCompletionString);

					if (openTask == inspectionCompletion) {
						System.out.println("The open task of the inspection is displayed correctly.");
						test.log(LogStatus.INFO, "The open task of the inspection is displayed correctly.");
						Reporter.log("The open task of the inspection is displayed correctly.");
						log.info("The open task of the inspection is displayed correctly.");
					} else {
						TestUtil.captureScreenshot();

						// ReportNG
						Reporter.log("<br>" + " The open task of the inspection is displayed incorrectly. : " + "<br>");
						Reporter.log("<a target=\"_blank\" href=" + TestUtil.screenshotName + "><img src="
								+ TestUtil.screenshotName + " height=200 width=200></img></a>");
						Reporter.log("<br>");
						Reporter.log("<br>");

						// Extent Report
						test.log(LogStatus.FAIL, " The open task of the inspection is displayed incorrectly. : ");
						test.log(LogStatus.FAIL, test.addScreenCapture(TestUtil.screenshotName));

						System.out.println("The open task of the inspection is displayed incorrectly.");
						log.info("The open task of the inspection is displayed incorrectly.");
					}

				} catch (Throwable t) {

					TestUtil.captureScreenshot();

					// ReportNG
					Reporter.log("<br>" + " The open task of the inspection is displayed incorrectly. : " + "<br>");
					Reporter.log("<a target=\"_blank\" href=" + TestUtil.screenshotName + "><img src="
							+ TestUtil.screenshotName + " height=200 width=200></img></a>");
					Reporter.log("<br>");
					Reporter.log("<br>");

					// Extent Report
					test.log(LogStatus.FAIL, " The open task of the inspection is displayed incorrectly. : ");
					test.log(LogStatus.FAIL, test.addScreenCapture(TestUtil.screenshotName));

					System.out.println("The open task of the inspection is displayed incorrectly.");
					log.info("The open task of the inspection is displayed incorrectly.");
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

			// MAKE THE COVID 19 INSPECTION AS A INPROGRESS - OPERATION MANAGER

			System.out.println(
					"******************** MAKE THE COVID 19 INSPECTION AS A INPROGRESS - OPERATION MANAGER ********************");
			test.log(LogStatus.INFO,
					"******************** MAKE THE COVID 19 INSPECTION AS A INPROGRESS - OPERATION MANAGER ********************");
			Reporter.log(
					"******************** MAKE THE COVID 19 INSPECTION AS A INPROGRESS - OPERATION MANAGER ********************");
			log.info(
					"******************** MAKE THE COVID 19 INSPECTION AS A INPROGRESS - OPERATION MANAGER ********************");

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
				click("inspection_createdinspection5_XPATH");
				ngDriver.waitForAngularRequestsToFinish();
				System.out.println("Clicked on the searched inspection.");

				// click on the switch to wizard mode button
				click("checklist_classicviewbtn_CSS");
				ngDriver.waitForAngularRequestsToFinish();
				System.out.println("Clicked on the switch to wizard mode button.");

				// click on the on option of the 1st question
				click("checklist_wizard_nooption_CSS");
				ngDriver.waitForAngularRequestsToFinish();
				System.out.println("Clicked on the yes option of the 1st question.");

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
				switchVerification("inspection_createdinspection5_XPATH",
						"Test Questionnaire Property Title Smoke Capreit Five",
						"The Test Questionnaire Property Title Smoke Capreit Five is not displayed.");

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

			// VERIFY THE INPROGRESS INSPECTION IN PORTFOLIO SUMMARY DASHBOARD

			System.out.println(
					"******************** VERIFY THE INPROGRESS INSPECTION COUNT IN PORTFOLIO SUMMARY DASHBOARD ********************");
			test.log(LogStatus.INFO,
					"******************** VERIFY THE INPROGRESS INSPECTION COUNT IN PORTFOLIO SUMMARY DASHBOARD ********************");
			Reporter.log(
					"******************** VERIFY THE INPROGRESS INSPECTION COUNT IN PORTFOLIO SUMMARY DASHBOARD ********************");
			log.info(
					"******************** VERIFY THE INPROGRESS INSPECTION COUNT IN PORTFOLIO SUMMARY DASHBOARD ********************");

			try {

				// wait for the element
				Thread.sleep(5000);

				// click on the side menu
				click("menubtn_CSS");
				ngDriver.waitForAngularRequestsToFinish();
				System.out.println("Clicked on the side menu.");

				// wait for the element
				Thread.sleep(5000);

				// click on the portfolio summary option
				click("sidemenu_portfoliosummary_XPATH");
				ngDriver.waitForAngularRequestsToFinish();
				System.out.println("Clicked on the portfolio summary option.");

				// scroll down the screen
				JavascriptExecutor js = (JavascriptExecutor) driver;
				WebElement inspectionOM = driver
						.findElement(By.xpath(OR.getProperty("portfoliosummary_inspection2_XPATH")));
				js.executeScript("arguments[0].scrollIntoView(true);", inspectionOM);
				js.executeScript("window.scrollBy(0,-200)");

				// VERIFY INSPECTION DETAILS IN THE PORTFOLIO SUMMARY DASHBOARD SCREEN

				System.out.println(
						"******************** VERIFY INSPECTION DETAILS IN THE PORTFOLIO SUMMARY DASHBOARD SCREEN ********************");
				test.log(LogStatus.INFO,
						"******************** VERIFY INSPECTION DETAILS IN THE PORTFOLIO SUMMARY DASHBOARD SCREEN ********************");
				Reporter.log(
						"******************** VERIFY INSPECTION DETAILS IN THE PORTFOLIO SUMMARY DASHBOARD SCREEN ********************");
				log.info(
						"******************** VERIFY INSPECTION DETAILS IN THE PORTFOLIO SUMMARY DASHBOARD SCREEN ********************");

				// VERIFY COUNT OF THE PROPERTY AFTER THE INSPECTION MAKE IN PROGRESS

				try {
					String property2String = (driver
							.findElement(By.cssSelector(OR.getProperty("portfoliosummary_inspection2_property_CSS")))
							.getText()).trim();

					int property2 = Integer.parseInt(property2String);

					if (property == (property2)) {

						System.out.println("The property count of the inspection is displayed correctly.");
						test.log(LogStatus.INFO, "The property count of the inspection is displayed correctly.");
						Reporter.log("The property count of the inspection is displayed correctly.");
						log.info("The property count of the inspection is displayed correctly.");
					} else {
						TestUtil.captureScreenshot();

						// ReportNG
						Reporter.log(
								"<br>" + " The property count of the inspection is displayed incorrectly. : " + "<br>");
						Reporter.log("<a target=\"_blank\" href=" + TestUtil.screenshotName + "><img src="
								+ TestUtil.screenshotName + " height=200 width=200></img></a>");
						Reporter.log("<br>");
						Reporter.log("<br>");

						// Extent Report
						test.log(LogStatus.FAIL, " The property count of the inspection is displayed incorrectly. : ");
						test.log(LogStatus.FAIL, test.addScreenCapture(TestUtil.screenshotName));

						System.out.println("The property count of the inspection is displayed incorrectly.");
						log.info("The property count of the inspection is displayed incorrectly.");
					}

				} catch (Throwable t) {
					TestUtil.captureScreenshot();

					// ReportNG
					Reporter.log(
							"<br>" + " The property count of the inspection is displayed incorrectly. : " + "<br>");
					Reporter.log("<a target=\"_blank\" href=" + TestUtil.screenshotName + "><img src="
							+ TestUtil.screenshotName + " height=200 width=200></img></a>");
					Reporter.log("<br>");
					Reporter.log("<br>");

					// Extent Report
					test.log(LogStatus.FAIL, " The property count of the inspection is displayed incorrectly. : ");
					test.log(LogStatus.FAIL, test.addScreenCapture(TestUtil.screenshotName));

					System.out.println("The property count of the inspection is displayed incorrectly.");
					log.info("The property count of the inspection is displayed incorrectly.");
				}

				// VERIFY COUNT OF THE ACTIVE TASKS AFTER THE INSPECTION MAKE IN PROGRESS

				try {
					String task2String = (driver
							.findElement(By.cssSelector(OR.getProperty("portfoliosummary_inspection2_task_CSS")))
							.getText()).trim();

					int task2 = Integer.parseInt(task2String);

					if (task == (task2 - 1)) {

						System.out.println("The active task count of the inspection is displayed correctly.");
						test.log(LogStatus.INFO, "The active task count of the inspection is displayed correctly.");
						Reporter.log("The active task count of the inspection is displayed correctly.");
						log.info("The active task count of the inspection is displayed correctly.");

					} else {
						TestUtil.captureScreenshot();

						// ReportNG
						Reporter.log("<br>" + " The active task count of the inspection is displayed incorrectly. : "
								+ "<br>");
						Reporter.log("<a target=\"_blank\" href=" + TestUtil.screenshotName + "><img src="
								+ TestUtil.screenshotName + " height=200 width=200></img></a>");
						Reporter.log("<br>");
						Reporter.log("<br>");

						// Extent Report
						test.log(LogStatus.FAIL,
								" The active task count of the inspection is displayed incorrectly. : ");
						test.log(LogStatus.FAIL, test.addScreenCapture(TestUtil.screenshotName));

						System.out.println("The active task count of the inspection is displayed incorrectly.");
						log.info("The active task count of the inspection is displayed incorrectly.");
					}

				} catch (Throwable t) {
					TestUtil.captureScreenshot();

					// ReportNG
					Reporter.log(
							"<br>" + " The active task count of the inspection is displayed incorrectly. : " + "<br>");
					Reporter.log("<a target=\"_blank\" href=" + TestUtil.screenshotName + "><img src="
							+ TestUtil.screenshotName + " height=200 width=200></img></a>");
					Reporter.log("<br>");
					Reporter.log("<br>");

					// Extent Report
					test.log(LogStatus.FAIL, " The active task count of the inspection is displayed incorrectly. : ");
					test.log(LogStatus.FAIL, test.addScreenCapture(TestUtil.screenshotName));

					System.out.println("The active task count of the inspection is displayed incorrectly.");
					log.info("The active task count of the inspection is displayed incorrectly.");
				}

				// VERIFY INSPECTION DETAILS IN THE INSPECTION LIST SCREEN

				System.out.println(
						"******************** VERIFY INSPECTION DETAILS IN THE INSPECTION LIST SCREEN ********************");
				test.log(LogStatus.INFO,
						"******************** VERIFY INSPECTION DETAILS IN THE INSPECTION LIST SCREEN ********************");
				Reporter.log(
						"******************** VERIFY INSPECTION DETAILS IN THE INSPECTION LIST SCREEN ********************");
				log.info(
						"******************** VERIFY INSPECTION DETAILS IN THE INSPECTION LIST SCREEN ********************");

				// click on the property count
				click("portfoliosummary_inspection2_property_CSS");
				ngDriver.waitForAngularRequestsToFinish();
				System.out.println("Clicked on the property count.");

				// VERIFY THE OPEN TASK COUNT

				try {

					String openTask2String = (driver
							.findElement(
									By.xpath(OR.getProperty("portfoliosummary_inspection2_inspectionlist_task_XPATH")))
							.getText()).trim();

					int openTask2 = Integer.parseInt(openTask2String);

					if (openTask == (openTask2 - 1)) {

						System.out.println("The open task count of the inspection is displayed correctly.");
						test.log(LogStatus.INFO, "The open task count of the inspection is displayed correctly.");
						Reporter.log("The open task count of the inspection is displayed correctly.");
						log.info("The open task count of the inspection is displayed correctly.");

					} else {
						TestUtil.captureScreenshot();

						// ReportNG
						Reporter.log("<br>" + " The open task count of the inspection is displayed incorrectly. : "
								+ "<br>");
						Reporter.log("<a target=\"_blank\" href=" + TestUtil.screenshotName + "><img src="
								+ TestUtil.screenshotName + " height=200 width=200></img></a>");
						Reporter.log("<br>");
						Reporter.log("<br>");

						// Extent Report
						test.log(LogStatus.FAIL, " The open task count of the inspection is displayed incorrectly. : ");
						test.log(LogStatus.FAIL, test.addScreenCapture(TestUtil.screenshotName));

						System.out.println("The open task count of the inspection is displayed incorrectly.");
						log.info("The open task count of the inspection is displayed incorrectly.");
					}

				} catch (Throwable t) {
					TestUtil.captureScreenshot();

					// ReportNG
					Reporter.log(
							"<br>" + " The open task count of the inspection is displayed incorrectly. : " + "<br>");
					Reporter.log("<a target=\"_blank\" href=" + TestUtil.screenshotName + "><img src="
							+ TestUtil.screenshotName + " height=200 width=200></img></a>");
					Reporter.log("<br>");
					Reporter.log("<br>");

					// Extent Report
					test.log(LogStatus.FAIL, " The open task count of the inspection is displayed incorrectly. : ");
					test.log(LogStatus.FAIL, test.addScreenCapture(TestUtil.screenshotName));

					System.out.println("The open task count of the inspection is displayed incorrectly.");
					log.info("The open task count of the inspection is displayed incorrectly.");
				}

				// click on the fourth circle
				click("portfoliosummary_inspection2_inspectionlist_circle_XPATH");
				ngDriver.waitForAngularRequestsToFinish();
				System.out.println("Clicked on the fourth circle.");

				// VERIFY INSPECTION DETAILS IN THE CREATE CHECKLIST LIST SCREEN

				System.out.println(
						"******************** VERIFY INSPECTION DETAILS IN THE CREATE CHECKLIST LIST SCREEN ********************");
				test.log(LogStatus.INFO,
						"******************** VERIFY INSPECTION DETAILS IN THE CREATE CHECKLIST LIST SCREEN ********************");
				Reporter.log(
						"******************** VERIFY INSPECTION DETAILS IN THE CREATE CHECKLIST LIST SCREEN ********************");
				log.info(
						"******************** VERIFY INSPECTION DETAILS IN THE CREATE CHECKLIST LIST SCREEN ********************");

				// enter the inspection name in the search field
				type("task_listofchecklist_filterfield_CSS", data.get("checklist_property_title"));
				ngDriver.waitForAngularRequestsToFinish();
				System.out.println("Entered the inspection name in the search field.");

				// VERIFY NEWLY CREATED INSPECTION IS DISPLAYED OR NOT

				try {
					String inspectionName = driver
							.findElement(By.xpath(OR.getProperty("inspection_createdinspection5_XPATH"))).getText();

					if (inspectionName.equals("Test Questionnaire Property Title Smoke Capreit Five")) {
						System.out.println("The inspection is displayed correctly.");
						test.log(LogStatus.INFO, "The inspection is displayed correctly.");
						Reporter.log("The inspection is displayed correctly.");
						log.info("The inspection is displayed correctly.");
					} else {
						TestUtil.captureScreenshot();

						// ReportNG
						Reporter.log("<br>" + " The inspection is not displayed. : " + "<br>");
						Reporter.log("<a target=\"_blank\" href=" + TestUtil.screenshotName + "><img src="
								+ TestUtil.screenshotName + " height=200 width=200></img></a>");
						Reporter.log("<br>");
						Reporter.log("<br>");

						// Extent Report
						test.log(LogStatus.FAIL, " The inspection is not displayed. : ");
						test.log(LogStatus.FAIL, test.addScreenCapture(TestUtil.screenshotName));

						System.out.println("The inspection is not displayed.");
						log.info("The inspection is not displayed.");
					}

				} catch (Throwable t) {
					TestUtil.captureScreenshot();

					// ReportNG
					Reporter.log("<br>" + " The inspection is not displayed. : " + "<br>");
					Reporter.log("<a target=\"_blank\" href=" + TestUtil.screenshotName + "><img src="
							+ TestUtil.screenshotName + " height=200 width=200></img></a>");
					Reporter.log("<br>");
					Reporter.log("<br>");

					// Extent Report
					test.log(LogStatus.FAIL, " The inspection is not displayed. : ");
					test.log(LogStatus.FAIL, test.addScreenCapture(TestUtil.screenshotName));

					System.out.println("The inspection is not displayed.");
					log.info("The inspection is not displayed.");
				}

				// VERIFY COMPLETION OF THE INSPECTION

				try {

					String inspectionCompletion = driver
							.findElement(By.xpath(
									OR.getProperty("portfoliosummary_inspection2_inspectionlist_completion_XPATH")))
							.getText();

					if (inspectionCompletion.equals("25%")) {
						System.out.println("The completion percentage of the inspection is displayed correctly.");
						test.log(LogStatus.INFO, "The completion percentage of the inspection is displayed correctly.");
						Reporter.log("The completion percentage of the inspection is displayed correctly.");
						log.info("The completion percentage of the inspection is displayed correctly.");
					} else {
						TestUtil.captureScreenshot();

						// ReportNG
						Reporter.log("<br>"
								+ " The completion percentage of the inspection is displayed incorrectly. : " + "<br>");
						Reporter.log("<a target=\"_blank\" href=" + TestUtil.screenshotName + "><img src="
								+ TestUtil.screenshotName + " height=200 width=200></img></a>");
						Reporter.log("<br>");
						Reporter.log("<br>");

						// Extent Report
						test.log(LogStatus.FAIL,
								" The completion percentage of the inspection is displayed incorrectly. : ");
						test.log(LogStatus.FAIL, test.addScreenCapture(TestUtil.screenshotName));

						System.out.println("The completion percentage of the inspection is displayed incorrectly.");
						log.info("The completion percentage of the inspection is displayed incorrectly.");
					}

				} catch (Throwable t) {

					TestUtil.captureScreenshot();

					// ReportNG
					Reporter.log("<br>" + " The completion percentage of the inspection is displayed incorrectly. : "
							+ "<br>");
					Reporter.log("<a target=\"_blank\" href=" + TestUtil.screenshotName + "><img src="
							+ TestUtil.screenshotName + " height=200 width=200></img></a>");
					Reporter.log("<br>");
					Reporter.log("<br>");

					// Extent Report
					test.log(LogStatus.FAIL,
							" The completion percentage of the inspection is displayed incorrectly. : ");
					test.log(LogStatus.FAIL, test.addScreenCapture(TestUtil.screenshotName));

					System.out.println("The completion percentage of the inspection is displayed incorrectly.");
					log.info("The completion percentage of the inspection is displayed incorrectly.");
				}

				// VERIFY TOTAL TASK OF THE INSPECTION

				try {

					String inspectionTotalTaskString = driver
							.findElement(By.xpath(
									OR.getProperty("portfoliosummary_inspection2_inspectionlist_totaltask_XPATH")))
							.getText();

					int inspectionTotalTask = Integer.parseInt(inspectionTotalTaskString);

					if (task == (inspectionTotalTask - 1)) {
						System.out.println("The total task of the inspection is displayed correctly.");
						test.log(LogStatus.INFO, "The total task of the inspection is displayed correctly.");
						Reporter.log("The total task of the inspection is displayed correctly.");
						log.info("The total task of the inspection is displayed correctly.");
					} else {
						TestUtil.captureScreenshot();

						// ReportNG
						Reporter.log(
								"<br>" + " The total task of the inspection is displayed incorrectly. : " + "<br>");
						Reporter.log("<a target=\"_blank\" href=" + TestUtil.screenshotName + "><img src="
								+ TestUtil.screenshotName + " height=200 width=200></img></a>");
						Reporter.log("<br>");
						Reporter.log("<br>");

						// Extent Report
						test.log(LogStatus.FAIL, " The total task of the inspection is displayed incorrectly. : ");
						test.log(LogStatus.FAIL, test.addScreenCapture(TestUtil.screenshotName));

						System.out.println("The total task of the inspection is displayed incorrectly.");
						log.info("The total task of the inspection is displayed incorrectly.");
					}

				} catch (Throwable t) {

					TestUtil.captureScreenshot();

					// ReportNG
					Reporter.log("<br>" + " The total task of the inspection is displayed incorrectly. : " + "<br>");
					Reporter.log("<a target=\"_blank\" href=" + TestUtil.screenshotName + "><img src="
							+ TestUtil.screenshotName + " height=200 width=200></img></a>");
					Reporter.log("<br>");
					Reporter.log("<br>");

					// Extent Report
					test.log(LogStatus.FAIL, " The total task of the inspection is displayed incorrectly. : ");
					test.log(LogStatus.FAIL, test.addScreenCapture(TestUtil.screenshotName));

					System.out.println("The total task of the inspection is displayed incorrectly.");
					log.info("The total task of the inspection is displayed incorrectly.");
				}

				// VERIFY OPEN TASK OF THE INSPECTION

				try {

					String inspectionCompletionString = driver
							.findElement(By.xpath(
									OR.getProperty("portfoliosummary_inspection2_inspectionlist_opentask_XPATH")))
							.getText();

					int inspectionCompletion = Integer.parseInt(inspectionCompletionString);

					if (openTask == (inspectionCompletion - 1)) {
						System.out.println("The open task of the inspection is displayed correctly.");
						test.log(LogStatus.INFO, "The open task of the inspection is displayed correctly.");
						Reporter.log("The open task of the inspection is displayed correctly.");
						log.info("The open task of the inspection is displayed correctly.");
					} else {
						TestUtil.captureScreenshot();

						// ReportNG
						Reporter.log("<br>" + " The open task of the inspection is displayed incorrectly. : " + "<br>");
						Reporter.log("<a target=\"_blank\" href=" + TestUtil.screenshotName + "><img src="
								+ TestUtil.screenshotName + " height=200 width=200></img></a>");
						Reporter.log("<br>");
						Reporter.log("<br>");

						// Extent Report
						test.log(LogStatus.FAIL, " The open task of the inspection is displayed incorrectly. : ");
						test.log(LogStatus.FAIL, test.addScreenCapture(TestUtil.screenshotName));

						System.out.println("The open task of the inspection is displayed incorrectly.");
						log.info("The open task of the inspection is displayed incorrectly.");
					}

				} catch (Throwable t) {

					TestUtil.captureScreenshot();

					// ReportNG
					Reporter.log("<br>" + " The open task of the inspection is displayed incorrectly. : " + "<br>");
					Reporter.log("<a target=\"_blank\" href=" + TestUtil.screenshotName + "><img src="
							+ TestUtil.screenshotName + " height=200 width=200></img></a>");
					Reporter.log("<br>");
					Reporter.log("<br>");

					// Extent Report
					test.log(LogStatus.FAIL, " The open task of the inspection is displayed incorrectly. : ");
					test.log(LogStatus.FAIL, test.addScreenCapture(TestUtil.screenshotName));

					System.out.println("The open task of the inspection is displayed incorrectly.");
					log.info("The open task of the inspection is displayed incorrectly.");
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

			// COMPLETE THE COVID 19 INSPECTION - OPERATION MANAGER

			System.out.println(
					"******************** COMPLETE THE COVID 19 INSPECTION - OPERATION MANAGER ********************");
			test.log(LogStatus.INFO,
					"******************** COMPLETE THE COVID 19 INSPECTION - OPERATION MANAGER ********************");
			Reporter.log(
					"******************** COMPLETE THE COVID 19 INSPECTION - OPERATION MANAGER ********************");
			log.info("******************** COMPLETE THE COVID 19 INSPECTION - OPERATION MANAGER ********************");

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
				click("inspection_createdinspection5_XPATH");
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

				// click on the yes option of the 3rd question
				click("checklist_wizard_yesoption_CSS");
				ngDriver.waitForAngularRequestsToFinish();
				System.out.println("Clicked on the yes option of the 3rd question.");

				// click on the next button from the 3rd question
				click("checklist_wizard_nextbtn_CSS");
				ngDriver.waitForAngularRequestsToFinish();
				System.out.println("Clicked on the next button from the 3rd question.");

				// scroll down the screen
				JavascriptExecutor js = (JavascriptExecutor) driver;
				js.executeScript("window.scrollBy(0,500)");

				// click on the yes option of the 4th question
				click("checklist_wizard_yesoption_CSS");
				ngDriver.waitForAngularRequestsToFinish();
				System.out.println("Clicked on the yes option of the 4th question.");

				// click on the next button from the 4th question
				click("checklist_wizard_nextbtn_CSS");
				ngDriver.waitForAngularRequestsToFinish();
				System.out.println("Clicked on the next button from the 4th question.");

				// click on the next button from the 5th question
				click("checklist_wizard_nextbtn_CSS");
				ngDriver.waitForAngularRequestsToFinish();
				System.out.println("Clicked on the next button from the 5th question.");

				// click on the next button from the 6th question
				click("checklist_wizard_nextbtn_CSS");
				ngDriver.waitForAngularRequestsToFinish();
				System.out.println("Clicked on the next button from the 6th question.");

				// click on the next button from the 7th question
				click("checklist_wizard_nextbtn_CSS");
				ngDriver.waitForAngularRequestsToFinish();
				System.out.println("Clicked on the next button from the 7th question.");

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

				// verify completed inspection is displayed or not
				switchVerification("inspection_createdinspection5_XPATH",
						"Test Questionnaire Property Title Smoke Capreit Five",
						"The Test Questionnaire Property Title Smoke Capreit Five is not displayed.");

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

			// VERIFY THE COMPLETED INSPECTION IN PORTFOLIO SUMMARY DASHBOARD

			System.out.println(
					"******************** VERIFY THE COMPLETED INSPECTION IN PORTFOLIO SUMMARY DASHBOARD ********************");
			test.log(LogStatus.INFO,
					"******************** VERIFY THE COMPLETED INSPECTION IN PORTFOLIO SUMMARY DASHBOARD ********************");
			Reporter.log(
					"******************** VERIFY THE COMPLETED INSPECTION IN PORTFOLIO SUMMARY DASHBOARD ********************");
			log.info(
					"******************** VERIFY THE COMPLETED INSPECTION IN PORTFOLIO SUMMARY DASHBOARD ********************");

			try {

				// wait for the element
				Thread.sleep(5000);

				// click on the side menu
				click("menubtn_CSS");
				ngDriver.waitForAngularRequestsToFinish();
				System.out.println("Clicked on the side menu.");

				// wait for the element
				Thread.sleep(5000);

				// click on the portfolio summary option
				click("sidemenu_portfoliosummary_XPATH");
				ngDriver.waitForAngularRequestsToFinish();
				System.out.println("Clicked on the portfolio summary option.");

				// scroll down the screen
				JavascriptExecutor js = (JavascriptExecutor) driver;
				WebElement inspectionOM = driver
						.findElement(By.xpath(OR.getProperty("portfoliosummary_inspection2_XPATH")));
				js.executeScript("arguments[0].scrollIntoView(true);", inspectionOM);
				js.executeScript("window.scrollBy(0,-200)");

				// VERIFY INSPECTION DETAILS IN THE PORTFOLIO SUMMARY DASHBOARD SCREEN

				System.out.println(
						"******************** VERIFY INSPECTION DETAILS IN THE PORTFOLIO SUMMARY DASHBOARD SCREEN ********************");
				test.log(LogStatus.INFO,
						"******************** VERIFY INSPECTION DETAILS IN THE PORTFOLIO SUMMARY DASHBOARD SCREEN ********************");
				Reporter.log(
						"******************** VERIFY INSPECTION DETAILS IN THE PORTFOLIO SUMMARY DASHBOARD SCREEN ********************");
				log.info(
						"******************** VERIFY INSPECTION DETAILS IN THE PORTFOLIO SUMMARY DASHBOARD SCREEN ********************");

				try {
					String property3String = (driver
							.findElement(By.cssSelector(OR.getProperty("portfoliosummary_inspection2_property_CSS")))
							.getText()).trim();

					int property3 = Integer.parseInt(property3String);

					if (property == (property3)) {

						System.out.println("The property count of the inspection is displayed correctly.");
						test.log(LogStatus.INFO, "The property count of the inspection is displayed correctly.");
						Reporter.log("The property count of the inspection is displayed correctly.");
						log.info("The property count of the inspection is displayed correctly.");
					} else {
						TestUtil.captureScreenshot();

						// ReportNG
						Reporter.log(
								"<br>" + " The property count of the inspection is displayed incorrectly. : " + "<br>");
						Reporter.log("<a target=\"_blank\" href=" + TestUtil.screenshotName + "><img src="
								+ TestUtil.screenshotName + " height=200 width=200></img></a>");
						Reporter.log("<br>");
						Reporter.log("<br>");

						// Extent Report
						test.log(LogStatus.FAIL, " The property count of the inspection is displayed incorrectly. : ");
						test.log(LogStatus.FAIL, test.addScreenCapture(TestUtil.screenshotName));

						System.out.println("The property count of the inspection is displayed incorrectly.");
						log.info("The property count of the inspection is displayed incorrectly.");
					}

				} catch (Throwable t) {
					TestUtil.captureScreenshot();

					// ReportNG
					Reporter.log(
							"<br>" + " The property count of the inspection is displayed incorrectly. : " + "<br>");
					Reporter.log("<a target=\"_blank\" href=" + TestUtil.screenshotName + "><img src="
							+ TestUtil.screenshotName + " height=200 width=200></img></a>");
					Reporter.log("<br>");
					Reporter.log("<br>");

					// Extent Report
					test.log(LogStatus.FAIL, " The property count of the inspection is displayed incorrectly. : ");
					test.log(LogStatus.FAIL, test.addScreenCapture(TestUtil.screenshotName));

					System.out.println("The property count of the inspection is displayed incorrectly.");
					log.info("The property count of the inspection is displayed incorrectly.");
				}

				// VERIFY COUNT OF THE ACTIVE TASKS AFTER THE INSPECTION MAKE IN PROGRESS

				try {
					String task3String = (driver
							.findElement(By.cssSelector(OR.getProperty("portfoliosummary_inspection2_task_CSS")))
							.getText()).trim();

					int task3 = Integer.parseInt(task3String);

					if (task == (task3 - 1)) {

						System.out.println("The active task count of the inspection is displayed correctly.");
						test.log(LogStatus.INFO, "The active task count of the inspection is displayed correctly.");
						Reporter.log("The active task count of the inspection is displayed correctly.");
						log.info("The active task count of the inspection is displayed correctly.");

					} else {
						TestUtil.captureScreenshot();

						// ReportNG
						Reporter.log("<br>" + " The active task count of the inspection is displayed incorrectly. : "
								+ "<br>");
						Reporter.log("<a target=\"_blank\" href=" + TestUtil.screenshotName + "><img src="
								+ TestUtil.screenshotName + " height=200 width=200></img></a>");
						Reporter.log("<br>");
						Reporter.log("<br>");

						// Extent Report
						test.log(LogStatus.FAIL,
								" The active task count of the inspection is displayed incorrectly. : ");
						test.log(LogStatus.FAIL, test.addScreenCapture(TestUtil.screenshotName));

						System.out.println("The active task count of the inspection is displayed incorrectly.");
						log.info("The active task count of the inspection is displayed incorrectly.");
					}

				} catch (Throwable t) {
					TestUtil.captureScreenshot();

					// ReportNG
					Reporter.log(
							"<br>" + " The active task count of the inspection is displayed incorrectly. : " + "<br>");
					Reporter.log("<a target=\"_blank\" href=" + TestUtil.screenshotName + "><img src="
							+ TestUtil.screenshotName + " height=200 width=200></img></a>");
					Reporter.log("<br>");
					Reporter.log("<br>");

					// Extent Report
					test.log(LogStatus.FAIL, " The active task count of the inspection is displayed incorrectly. : ");
					test.log(LogStatus.FAIL, test.addScreenCapture(TestUtil.screenshotName));

					System.out.println("The active task count of the inspection is displayed incorrectly.");
					log.info("The active task count of the inspection is displayed incorrectly.");
				}

				// VERIFY INSPECTION DETAILS IN THE INSPECTION LIST SCREEN

				System.out.println(
						"******************** VERIFY INSPECTION DETAILS IN THE INSPECTION LIST SCREEN ********************");
				test.log(LogStatus.INFO,
						"******************** VERIFY INSPECTION DETAILS IN THE INSPECTION LIST SCREEN ********************");
				Reporter.log(
						"******************** VERIFY INSPECTION DETAILS IN THE INSPECTION LIST SCREEN ********************");
				log.info(
						"******************** VERIFY INSPECTION DETAILS IN THE INSPECTION LIST SCREEN ********************");

				// click on the property count
				click("portfoliosummary_inspection2_property_CSS");
				ngDriver.waitForAngularRequestsToFinish();
				System.out.println("Clicked on the property count.");

				// VERIFY THE OPEN TASK COUNT

				try {

					String openTask3String = (driver
							.findElement(
									By.xpath(OR.getProperty("portfoliosummary_inspection2_inspectionlist_task_XPATH")))
							.getText()).trim();

					int openTask3 = Integer.parseInt(openTask3String);

					if (openTask == (openTask3 - 1)) {

						System.out.println("The open task count of the inspection is displayed correctly.");
						test.log(LogStatus.INFO, "The open task count of the inspection is displayed correctly.");
						Reporter.log("The open task count of the inspection is displayed correctly.");
						log.info("The open task count of the inspection is displayed correctly.");

					} else {
						TestUtil.captureScreenshot();

						// ReportNG
						Reporter.log("<br>" + " The open task count of the inspection is displayed incorrectly. : "
								+ "<br>");
						Reporter.log("<a target=\"_blank\" href=" + TestUtil.screenshotName + "><img src="
								+ TestUtil.screenshotName + " height=200 width=200></img></a>");
						Reporter.log("<br>");
						Reporter.log("<br>");

						// Extent Report
						test.log(LogStatus.FAIL, " The open task count of the inspection is displayed incorrectly. : ");
						test.log(LogStatus.FAIL, test.addScreenCapture(TestUtil.screenshotName));

						System.out.println("The open task count of the inspection is displayed incorrectly.");
						log.info("The open task count of the inspection is displayed incorrectly.");
					}

				} catch (Throwable t) {
					TestUtil.captureScreenshot();

					// ReportNG
					Reporter.log(
							"<br>" + " The open task count of the inspection is displayed incorrectly. : " + "<br>");
					Reporter.log("<a target=\"_blank\" href=" + TestUtil.screenshotName + "><img src="
							+ TestUtil.screenshotName + " height=200 width=200></img></a>");
					Reporter.log("<br>");
					Reporter.log("<br>");

					// Extent Report
					test.log(LogStatus.FAIL, " The open task count of the inspection is displayed incorrectly. : ");
					test.log(LogStatus.FAIL, test.addScreenCapture(TestUtil.screenshotName));

					System.out.println("The open task count of the inspection is displayed incorrectly.");
					log.info("The open task count of the inspection is displayed incorrectly.");
				}

				// click on the fourth circle
				click("portfoliosummary_inspection2_inspectionlist_circle_XPATH");
				ngDriver.waitForAngularRequestsToFinish();
				System.out.println("Clicked on the fourth circle.");

				// VERIFY INSPECTION DETAILS IN THE CREATE CHECKLIST LIST SCREEN

				System.out.println(
						"******************** VERIFY INSPECTION DETAILS IN THE CREATE CHECKLIST LIST SCREEN ********************");
				test.log(LogStatus.INFO,
						"******************** VERIFY INSPECTION DETAILS IN THE CREATE CHECKLIST LIST SCREEN ********************");
				Reporter.log(
						"******************** VERIFY INSPECTION DETAILS IN THE CREATE CHECKLIST LIST SCREEN ********************");
				log.info(
						"******************** VERIFY INSPECTION DETAILS IN THE CREATE CHECKLIST LIST SCREEN ********************");

				// enter the inspection name in the search field
				type("task_listofchecklist_filterfield_CSS", data.get("checklist_property_title"));
				ngDriver.waitForAngularRequestsToFinish();
				System.out.println("Entered the inspection name in the search field.");

				// VERIFY NEWLY CREATED INSPECTION IS DISPLAYED OR NOT

				try {
					String inspectionName = driver
							.findElement(By.xpath(OR.getProperty("inspection_createdinspection5_XPATH"))).getText();

					if (inspectionName.equals("Test Questionnaire Property Title Smoke Capreit Five")) {
						System.out.println("The inspection is displayed correctly.");
						test.log(LogStatus.INFO, "The inspection is displayed correctly.");
						Reporter.log("The inspection is displayed correctly.");
						log.info("The inspection is displayed correctly.");
					} else {
						TestUtil.captureScreenshot();

						// ReportNG
						Reporter.log("<br>" + " The inspection is not displayed. : " + "<br>");
						Reporter.log("<a target=\"_blank\" href=" + TestUtil.screenshotName + "><img src="
								+ TestUtil.screenshotName + " height=200 width=200></img></a>");
						Reporter.log("<br>");
						Reporter.log("<br>");

						// Extent Report
						test.log(LogStatus.FAIL, " The inspection is not displayed. : ");
						test.log(LogStatus.FAIL, test.addScreenCapture(TestUtil.screenshotName));

						System.out.println("The inspection is not displayed.");
						log.info("The inspection is not displayed.");
					}

				} catch (Throwable t) {
					TestUtil.captureScreenshot();

					// ReportNG
					Reporter.log("<br>" + " The inspection is not displayed. : " + "<br>");
					Reporter.log("<a target=\"_blank\" href=" + TestUtil.screenshotName + "><img src="
							+ TestUtil.screenshotName + " height=200 width=200></img></a>");
					Reporter.log("<br>");
					Reporter.log("<br>");

					// Extent Report
					test.log(LogStatus.FAIL, " The inspection is not displayed. : ");
					test.log(LogStatus.FAIL, test.addScreenCapture(TestUtil.screenshotName));

					System.out.println("The inspection is not displayed.");
					log.info("The inspection is not displayed.");
				}

				// VERIFY COMPLETION OF THE INSPECTION

				try {

					String inspectionCompletion = driver
							.findElement(By.xpath(
									OR.getProperty("portfoliosummary_inspection2_inspectionlist_completion_XPATH")))
							.getText();

					if (inspectionCompletion.equals("100%")) {
						System.out.println("The completion percentage of the inspection is displayed correctly.");
						test.log(LogStatus.INFO, "The completion percentage of the inspection is displayed correctly.");
						Reporter.log("The completion percentage of the inspection is displayed correctly.");
						log.info("The completion percentage of the inspection is displayed correctly.");
					} else {
						TestUtil.captureScreenshot();

						// ReportNG
						Reporter.log("<br>"
								+ " The completion percentage of the inspection is displayed incorrectly. : " + "<br>");
						Reporter.log("<a target=\"_blank\" href=" + TestUtil.screenshotName + "><img src="
								+ TestUtil.screenshotName + " height=200 width=200></img></a>");
						Reporter.log("<br>");
						Reporter.log("<br>");

						// Extent Report
						test.log(LogStatus.FAIL,
								" The completion percentage of the inspection is displayed incorrectly. : ");
						test.log(LogStatus.FAIL, test.addScreenCapture(TestUtil.screenshotName));

						System.out.println("The completion percentage of the inspection is displayed incorrectly.");
						log.info("The completion percentage of the inspection is displayed incorrectly.");
					}

				} catch (Throwable t) {

					TestUtil.captureScreenshot();

					// ReportNG
					Reporter.log("<br>" + " The completion percentage of the inspection is displayed incorrectly. : "
							+ "<br>");
					Reporter.log("<a target=\"_blank\" href=" + TestUtil.screenshotName + "><img src="
							+ TestUtil.screenshotName + " height=200 width=200></img></a>");
					Reporter.log("<br>");
					Reporter.log("<br>");

					// Extent Report
					test.log(LogStatus.FAIL,
							" The completion percentage of the inspection is displayed incorrectly. : ");
					test.log(LogStatus.FAIL, test.addScreenCapture(TestUtil.screenshotName));

					System.out.println("The completion percentage of the inspection is displayed incorrectly.");
					log.info("The completion percentage of the inspection is displayed incorrectly.");
				}

				// VERIFY TOTAL TASK OF THE INSPECTION

				try {

					String inspectionTotalTaskString = driver
							.findElement(By.xpath(
									OR.getProperty("portfoliosummary_inspection2_inspectionlist_totaltask_XPATH")))
							.getText();

					int inspectionTotalTask = Integer.parseInt(inspectionTotalTaskString);

					if (task == (inspectionTotalTask - 1)) {
						System.out.println("The total task of the inspection is displayed correctly.");
						test.log(LogStatus.INFO, "The total task of the inspection is displayed correctly.");
						Reporter.log("The total task of the inspection is displayed correctly.");
						log.info("The total task of the inspection is displayed correctly.");
					} else {
						TestUtil.captureScreenshot();

						// ReportNG
						Reporter.log(
								"<br>" + " The total task of the inspection is displayed incorrectly. : " + "<br>");
						Reporter.log("<a target=\"_blank\" href=" + TestUtil.screenshotName + "><img src="
								+ TestUtil.screenshotName + " height=200 width=200></img></a>");
						Reporter.log("<br>");
						Reporter.log("<br>");

						// Extent Report
						test.log(LogStatus.FAIL, " The total task of the inspection is displayed incorrectly. : ");
						test.log(LogStatus.FAIL, test.addScreenCapture(TestUtil.screenshotName));

						System.out.println("The total task of the inspection is displayed incorrectly.");
						log.info("The total task of the inspection is displayed incorrectly.");
					}

				} catch (Throwable t) {

					TestUtil.captureScreenshot();

					// ReportNG
					Reporter.log("<br>" + " The total task of the inspection is displayed incorrectly. : " + "<br>");
					Reporter.log("<a target=\"_blank\" href=" + TestUtil.screenshotName + "><img src="
							+ TestUtil.screenshotName + " height=200 width=200></img></a>");
					Reporter.log("<br>");
					Reporter.log("<br>");

					// Extent Report
					test.log(LogStatus.FAIL, " The total task of the inspection is displayed incorrectly. : ");
					test.log(LogStatus.FAIL, test.addScreenCapture(TestUtil.screenshotName));

					System.out.println("The total task of the inspection is displayed incorrectly.");
					log.info("The total task of the inspection is displayed incorrectly.");
				}

				// VERIFY OPEN TASK OF THE INSPECTION

				try {

					String inspectionCompletionString = driver
							.findElement(By.xpath(
									OR.getProperty("portfoliosummary_inspection2_inspectionlist_opentask_XPATH")))
							.getText();

					int inspectionCompletion = Integer.parseInt(inspectionCompletionString);

					if (openTask == (inspectionCompletion - 1)) {
						System.out.println("The open task of the inspection is displayed correctly.");
						test.log(LogStatus.INFO, "The open task of the inspection is displayed correctly.");
						Reporter.log("The open task of the inspection is displayed correctly.");
						log.info("The open task of the inspection is displayed correctly.");
					} else {
						TestUtil.captureScreenshot();

						// ReportNG
						Reporter.log("<br>" + " The open task of the inspection is displayed incorrectly. : " + "<br>");
						Reporter.log("<a target=\"_blank\" href=" + TestUtil.screenshotName + "><img src="
								+ TestUtil.screenshotName + " height=200 width=200></img></a>");
						Reporter.log("<br>");
						Reporter.log("<br>");

						// Extent Report
						test.log(LogStatus.FAIL, " The open task of the inspection is displayed incorrectly. : ");
						test.log(LogStatus.FAIL, test.addScreenCapture(TestUtil.screenshotName));

						System.out.println("The open task of the inspection is displayed incorrectly.");
						log.info("The open task of the inspection is displayed incorrectly.");
					}

				} catch (Throwable t) {

					TestUtil.captureScreenshot();

					// ReportNG
					Reporter.log("<br>" + " The open task of the inspection is displayed incorrectly. : " + "<br>");
					Reporter.log("<a target=\"_blank\" href=" + TestUtil.screenshotName + "><img src="
							+ TestUtil.screenshotName + " height=200 width=200></img></a>");
					Reporter.log("<br>");
					Reporter.log("<br>");

					// Extent Report
					test.log(LogStatus.FAIL, " The open task of the inspection is displayed incorrectly. : ");
					test.log(LogStatus.FAIL, test.addScreenCapture(TestUtil.screenshotName));

					System.out.println("The open task of the inspection is displayed incorrectly.");
					log.info("The open task of the inspection is displayed incorrectly.");
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

			// ADD THE TASK IN COVID 19 INSPECTION - OPERATION MANAGER

			System.out.println(
					"******************** ADD THE TASK IN COVID 19 INSPECTION - OPERATION MANAGER ********************");
			test.log(LogStatus.INFO,
					"******************** ADD THE TASK IN COVID 19 INSPECTION - OPERATION MANAGER ********************");
			Reporter.log(
					"******************** ADD THE TASK IN COVID 19 INSPECTION - OPERATION MANAGER ********************");
			log.info(
					"******************** ADD THE TASK IN COVID 19 INSPECTION - OPERATION MANAGER ********************");

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

				// wait for 3 seconds
				Thread.sleep(3000);

				// click on the searched inspection
				click("inspection_createdinspection5_XPATH");
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

				// click on the save task button
				click("survey_task_savebtn_CSS");
				ngDriver.waitForAngularRequestsToFinish();
				System.out.println("Clicked on the save task button.");

				// wait for the element
				explicitWaitClickable("closetoastmsg_CSS");

				// click on the toaster close button
				click("closetoastmsg_CSS");
				ngDriver.waitForAngularRequestsToFinish();
				System.out.println("Clicked on the toaster close button.");

				// verify newly created task is displayed or not
				switchVerification("inspectionchecklist_tasktagcreatedtask_XPATH", "Electrical (Light Fixture)",
						"The Electrical (Light Fixture) is not displayed.");

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

			// VERIFY THE COMPLETED INSPECTION WITH NEW TASK IN PORTFOLIO SUMMARY DASHBOARD

			System.out.println(
					"******************** VERIFY THE COMPLETED INSPECTION WITH NEW TASK IN PORTFOLIO SUMMARY DASHBOARD ********************");
			test.log(LogStatus.INFO,
					"******************** VERIFY THE COMPLETED INSPECTION WITH NEW TASK IN PORTFOLIO SUMMARY DASHBOARD ********************");
			Reporter.log(
					"******************** VERIFY THE COMPLETED INSPECTION WITH NEW TASK IN PORTFOLIO SUMMARY DASHBOARD ********************");
			log.info(
					"******************** VERIFY THE COMPLETED INSPECTION WITH NEW TASK IN PORTFOLIO SUMMARY DASHBOARD ********************");

			try {

				// wait for the element
				Thread.sleep(5000);

				// click on the side menu
				click("menubtn_CSS");
				ngDriver.waitForAngularRequestsToFinish();
				System.out.println("Clicked on the side menu.");

				// wait for the element
				Thread.sleep(5000);

				// click on the portfolio summary option
				click("sidemenu_portfoliosummary_XPATH");
				ngDriver.waitForAngularRequestsToFinish();
				System.out.println("Clicked on the portfolio summary option.");

				// scroll down the screen
				JavascriptExecutor js = (JavascriptExecutor) driver;
				WebElement inspectionOM = driver
						.findElement(By.xpath(OR.getProperty("portfoliosummary_inspection2_XPATH")));
				js.executeScript("arguments[0].scrollIntoView(true);", inspectionOM);
				js.executeScript("window.scrollBy(0,-200)");

				// VERIFY INSPECTION DETAILS IN THE PORTFOLIO SUMMARY DASHBOARD SCREEN

				System.out.println(
						"******************** VERIFY INSPECTION DETAILS IN THE PORTFOLIO SUMMARY DASHBOARD SCREEN ********************");
				test.log(LogStatus.INFO,
						"******************** VERIFY INSPECTION DETAILS IN THE PORTFOLIO SUMMARY DASHBOARD SCREEN ********************");
				Reporter.log(
						"******************** VERIFY INSPECTION DETAILS IN THE PORTFOLIO SUMMARY DASHBOARD SCREEN ********************");
				log.info(
						"******************** VERIFY INSPECTION DETAILS IN THE PORTFOLIO SUMMARY DASHBOARD SCREEN ********************");

				try {
					String property4String = (driver
							.findElement(By.cssSelector(OR.getProperty("portfoliosummary_inspection2_property_CSS")))
							.getText()).trim();

					int property4 = Integer.parseInt(property4String);

					if (property == (property4)) {
						System.out.println("The property count of the inspection is displayed correctly.");
						test.log(LogStatus.INFO, "The property count of the inspection is displayed correctly.");
						Reporter.log("The property count of the inspection is displayed correctly.");
						log.info("The property count of the inspection is displayed correctly.");
					} else {
						TestUtil.captureScreenshot();

						// ReportNG
						Reporter.log(
								"<br>" + " The property count of the inspection is displayed incorrectly. : " + "<br>");
						Reporter.log("<a target=\"_blank\" href=" + TestUtil.screenshotName + "><img src="
								+ TestUtil.screenshotName + " height=200 width=200></img></a>");
						Reporter.log("<br>");
						Reporter.log("<br>");

						// Extent Report
						test.log(LogStatus.FAIL, " The property count of the inspection is displayed incorrectly. : ");
						test.log(LogStatus.FAIL, test.addScreenCapture(TestUtil.screenshotName));

						System.out.println("The property count of the inspection is displayed incorrectly.");
						log.info("The property count of the inspection is displayed incorrectly.");
					}

				} catch (Throwable t) {
					TestUtil.captureScreenshot();

					// ReportNG
					Reporter.log(
							"<br>" + " The property count of the inspection is displayed incorrectly. : " + "<br>");
					Reporter.log("<a target=\"_blank\" href=" + TestUtil.screenshotName + "><img src="
							+ TestUtil.screenshotName + " height=200 width=200></img></a>");
					Reporter.log("<br>");
					Reporter.log("<br>");

					// Extent Report
					test.log(LogStatus.FAIL, " The property count of the inspection is displayed incorrectly. : ");
					test.log(LogStatus.FAIL, test.addScreenCapture(TestUtil.screenshotName));

					System.out.println("The property count of the inspection is displayed incorrectly.");
					log.info("The property count of the inspection is displayed incorrectly.");
				}

				// VERIFY COUNT OF THE ACTIVE TASKS AFTER THE INSPECTION MAKE IN PROGRESS

				try {
					String task4String = (driver
							.findElement(By.cssSelector(OR.getProperty("portfoliosummary_inspection2_task_CSS")))
							.getText()).trim();

					int task4 = Integer.parseInt(task4String);

					if (task == (task4 - 2)) {
						System.out.println("The active task count of the inspection is displayed correctly.");
						test.log(LogStatus.INFO, "The active task count of the inspection is displayed correctly.");
						Reporter.log("The active task count of the inspection is displayed correctly.");
						log.info("The active task count of the inspection is displayed correctly.");

					} else {
						TestUtil.captureScreenshot();

						// ReportNG
						Reporter.log("<br>" + " The active task count of the inspection is displayed incorrectly. : "
								+ "<br>");
						Reporter.log("<a target=\"_blank\" href=" + TestUtil.screenshotName + "><img src="
								+ TestUtil.screenshotName + " height=200 width=200></img></a>");
						Reporter.log("<br>");
						Reporter.log("<br>");

						// Extent Report
						test.log(LogStatus.FAIL,
								" The active task count of the inspection is displayed incorrectly. : ");
						test.log(LogStatus.FAIL, test.addScreenCapture(TestUtil.screenshotName));

						System.out.println("The active task count of the inspection is displayed incorrectly.");
						log.info("The active task count of the inspection is displayed incorrectly.");
					}

				} catch (Throwable t) {
					TestUtil.captureScreenshot();

					// ReportNG
					Reporter.log(
							"<br>" + " The active task count of the inspection is displayed incorrectly. : " + "<br>");
					Reporter.log("<a target=\"_blank\" href=" + TestUtil.screenshotName + "><img src="
							+ TestUtil.screenshotName + " height=200 width=200></img></a>");
					Reporter.log("<br>");
					Reporter.log("<br>");

					// Extent Report
					test.log(LogStatus.FAIL, " The active task count of the inspection is displayed incorrectly. : ");
					test.log(LogStatus.FAIL, test.addScreenCapture(TestUtil.screenshotName));

					System.out.println("The active task count of the inspection is displayed incorrectly.");
					log.info("The active task count of the inspection is displayed incorrectly.");
				}

				// VERIFY INSPECTION DETAILS IN THE INSPECTION LIST SCREEN

				System.out.println(
						"******************** VERIFY INSPECTION DETAILS IN THE INSPECTION LIST SCREEN ********************");
				test.log(LogStatus.INFO,
						"******************** VERIFY INSPECTION DETAILS IN THE INSPECTION LIST SCREEN ********************");
				Reporter.log(
						"******************** VERIFY INSPECTION DETAILS IN THE INSPECTION LIST SCREEN ********************");
				log.info(
						"******************** VERIFY INSPECTION DETAILS IN THE INSPECTION LIST SCREEN ********************");

				// click on the property count
				click("portfoliosummary_inspection2_property_CSS");
				ngDriver.waitForAngularRequestsToFinish();
				System.out.println("Clicked on the property count.");

				// VERIFY THE OPEN TASK COUNT

				try {

					String openTask4String = (driver
							.findElement(
									By.xpath(OR.getProperty("portfoliosummary_inspection2_inspectionlist_task_XPATH")))
							.getText()).trim();

					int openTask4 = Integer.parseInt(openTask4String);

					if (openTask == (openTask4 - 2)) {

						System.out.println("The open task count of the inspection is displayed correctly.");
						test.log(LogStatus.INFO, "The open task count of the inspection is displayed correctly.");
						Reporter.log("The open task count of the inspection is displayed correctly.");
						log.info("The open task count of the inspection is displayed correctly.");

					} else {
						TestUtil.captureScreenshot();

						// ReportNG
						Reporter.log("<br>" + " The open task count of the inspection is displayed incorrectly. : "
								+ "<br>");
						Reporter.log("<a target=\"_blank\" href=" + TestUtil.screenshotName + "><img src="
								+ TestUtil.screenshotName + " height=200 width=200></img></a>");
						Reporter.log("<br>");
						Reporter.log("<br>");

						// Extent Report
						test.log(LogStatus.FAIL, " The open task count of the inspection is displayed incorrectly. : ");
						test.log(LogStatus.FAIL, test.addScreenCapture(TestUtil.screenshotName));

						System.out.println("The open task count of the inspection is displayed incorrectly.");
						log.info("The open task count of the inspection is displayed incorrectly.");
					}

				} catch (Throwable t) {
					TestUtil.captureScreenshot();

					// ReportNG
					Reporter.log(
							"<br>" + " The open task count of the inspection is displayed incorrectly. : " + "<br>");
					Reporter.log("<a target=\"_blank\" href=" + TestUtil.screenshotName + "><img src="
							+ TestUtil.screenshotName + " height=200 width=200></img></a>");
					Reporter.log("<br>");
					Reporter.log("<br>");

					// Extent Report
					test.log(LogStatus.FAIL, " The open task count of the inspection is displayed incorrectly. : ");
					test.log(LogStatus.FAIL, test.addScreenCapture(TestUtil.screenshotName));

					System.out.println("The open task count of the inspection is displayed incorrectly.");
					log.info("The open task count of the inspection is displayed incorrectly.");
				}

				// click on the fourth circle
				click("portfoliosummary_inspection2_inspectionlist_circle_XPATH");
				ngDriver.waitForAngularRequestsToFinish();
				System.out.println("Clicked on the fourth circle.");

				// VERIFY INSPECTION DETAILS IN THE CREATE CHECKLIST LIST SCREEN

				System.out.println(
						"******************** VERIFY INSPECTION DETAILS IN THE CREATE CHECKLIST LIST SCREEN ********************");
				test.log(LogStatus.INFO,
						"******************** VERIFY INSPECTION DETAILS IN THE CREATE CHECKLIST LIST SCREEN ********************");
				Reporter.log(
						"******************** VERIFY INSPECTION DETAILS IN THE CREATE CHECKLIST LIST SCREEN ********************");
				log.info(
						"******************** VERIFY INSPECTION DETAILS IN THE CREATE CHECKLIST LIST SCREEN ********************");

				// enter the inspection name in the search field
				type("task_listofchecklist_filterfield_CSS", data.get("checklist_property_title"));
				ngDriver.waitForAngularRequestsToFinish();
				System.out.println("Entered the inspection name in the search field.");

				// VERIFY NEWLY CREATED INSPECTION IS DISPLAYED OR NOT

				try {
					String inspectionName = driver
							.findElement(By.xpath(OR.getProperty("inspection_createdinspection5_XPATH"))).getText();

					if (inspectionName.equals("Test Questionnaire Property Title Smoke Capreit Five")) {
						System.out.println("The inspection is displayed correctly.");
						test.log(LogStatus.INFO, "The inspection is displayed correctly.");
						Reporter.log("The inspection is displayed correctly.");
						log.info("The inspection is displayed correctly.");
					} else {
						TestUtil.captureScreenshot();

						// ReportNG
						Reporter.log("<br>" + " The inspection is not displayed. : " + "<br>");
						Reporter.log("<a target=\"_blank\" href=" + TestUtil.screenshotName + "><img src="
								+ TestUtil.screenshotName + " height=200 width=200></img></a>");
						Reporter.log("<br>");
						Reporter.log("<br>");

						// Extent Report
						test.log(LogStatus.FAIL, " The inspection is not displayed. : ");
						test.log(LogStatus.FAIL, test.addScreenCapture(TestUtil.screenshotName));

						System.out.println("The inspection is not displayed.");
						log.info("The inspection is not displayed.");
					}

				} catch (Throwable t) {
					TestUtil.captureScreenshot();

					// ReportNG
					Reporter.log("<br>" + " The inspection is not displayed. : " + "<br>");
					Reporter.log("<a target=\"_blank\" href=" + TestUtil.screenshotName + "><img src="
							+ TestUtil.screenshotName + " height=200 width=200></img></a>");
					Reporter.log("<br>");
					Reporter.log("<br>");

					// Extent Report
					test.log(LogStatus.FAIL, " The inspection is not displayed. : ");
					test.log(LogStatus.FAIL, test.addScreenCapture(TestUtil.screenshotName));

					System.out.println("The inspection is not displayed.");
					log.info("The inspection is not displayed.");
				}

				// VERIFY COMPLETION OF THE INSPECTION

				try {

					String inspectionCompletion = driver
							.findElement(By.xpath(
									OR.getProperty("portfoliosummary_inspection2_inspectionlist_completion_XPATH")))
							.getText();

					if (inspectionCompletion.equals("100%")) {
						System.out.println("The completion percentage of the inspection is displayed correctly.");
						test.log(LogStatus.INFO, "The completion percentage of the inspection is displayed correctly.");
						Reporter.log("The completion percentage of the inspection is displayed correctly.");
						log.info("The completion percentage of the inspection is displayed correctly.");
					} else {
						TestUtil.captureScreenshot();

						// ReportNG
						Reporter.log("<br>"
								+ " The completion percentage of the inspection is displayed incorrectly. : " + "<br>");
						Reporter.log("<a target=\"_blank\" href=" + TestUtil.screenshotName + "><img src="
								+ TestUtil.screenshotName + " height=200 width=200></img></a>");
						Reporter.log("<br>");
						Reporter.log("<br>");

						// Extent Report
						test.log(LogStatus.FAIL,
								" The completion percentage of the inspection is displayed incorrectly. : ");
						test.log(LogStatus.FAIL, test.addScreenCapture(TestUtil.screenshotName));

						System.out.println("The completion percentage of the inspection is displayed incorrectly.");
						log.info("The completion percentage of the inspection is displayed incorrectly.");
					}

				} catch (Throwable t) {

					TestUtil.captureScreenshot();

					// ReportNG
					Reporter.log("<br>" + " The completion percentage of the inspection is displayed incorrectly. : "
							+ "<br>");
					Reporter.log("<a target=\"_blank\" href=" + TestUtil.screenshotName + "><img src="
							+ TestUtil.screenshotName + " height=200 width=200></img></a>");
					Reporter.log("<br>");
					Reporter.log("<br>");

					// Extent Report
					test.log(LogStatus.FAIL,
							" The completion percentage of the inspection is displayed incorrectly. : ");
					test.log(LogStatus.FAIL, test.addScreenCapture(TestUtil.screenshotName));

					System.out.println("The completion percentage of the inspection is displayed incorrectly.");
					log.info("The completion percentage of the inspection is displayed incorrectly.");
				}

				// VERIFY TOTAL TASK OF THE INSPECTION

				try {

					String inspectionTotalTaskString = driver
							.findElement(By.xpath(
									OR.getProperty("portfoliosummary_inspection2_inspectionlist_totaltask_XPATH")))
							.getText();

					int inspectionTotalTask = Integer.parseInt(inspectionTotalTaskString);

					if (task == (inspectionTotalTask - 2)) {

						System.out.println("The total task of the inspection is displayed correctly.");
						test.log(LogStatus.INFO, "The total task of the inspection is displayed correctly.");
						Reporter.log("The total task of the inspection is displayed correctly.");
						log.info("The total task of the inspection is displayed correctly.");
					} else {
						TestUtil.captureScreenshot();

						// ReportNG
						Reporter.log(
								"<br>" + " The total task of the inspection is displayed incorrectly. : " + "<br>");
						Reporter.log("<a target=\"_blank\" href=" + TestUtil.screenshotName + "><img src="
								+ TestUtil.screenshotName + " height=200 width=200></img></a>");
						Reporter.log("<br>");
						Reporter.log("<br>");

						// Extent Report
						test.log(LogStatus.FAIL, " The total task of the inspection is displayed incorrectly. : ");
						test.log(LogStatus.FAIL, test.addScreenCapture(TestUtil.screenshotName));

						System.out.println("The total task of the inspection is displayed incorrectly.");
						log.info("The total task of the inspection is displayed incorrectly.");
					}

				} catch (Throwable t) {

					TestUtil.captureScreenshot();

					// ReportNG
					Reporter.log("<br>" + " The total task of the inspection is displayed incorrectly. : " + "<br>");
					Reporter.log("<a target=\"_blank\" href=" + TestUtil.screenshotName + "><img src="
							+ TestUtil.screenshotName + " height=200 width=200></img></a>");
					Reporter.log("<br>");
					Reporter.log("<br>");

					// Extent Report
					test.log(LogStatus.FAIL, " The total task of the inspection is displayed incorrectly. : ");
					test.log(LogStatus.FAIL, test.addScreenCapture(TestUtil.screenshotName));

					System.out.println("The total task of the inspection is displayed incorrectly.");
					log.info("The total task of the inspection is displayed incorrectly.");
				}

				// VERIFY OPEN TASK OF THE INSPECTION

				try {

					String inspectionCompletionString = driver
							.findElement(By.xpath(
									OR.getProperty("portfoliosummary_inspection2_inspectionlist_opentask_XPATH")))
							.getText();

					int inspectionCompletion = Integer.parseInt(inspectionCompletionString);

					if (openTask == (inspectionCompletion - 2)) {

						System.out.println("The open task of the inspection is displayed correctly.");
						test.log(LogStatus.INFO, "The open task of the inspection is displayed correctly.");
						Reporter.log("The open task of the inspection is displayed correctly.");
						log.info("The open task of the inspection is displayed correctly.");
					} else {
						TestUtil.captureScreenshot();

						// ReportNG
						Reporter.log("<br>" + " The open task of the inspection is displayed incorrectly. : " + "<br>");
						Reporter.log("<a target=\"_blank\" href=" + TestUtil.screenshotName + "><img src="
								+ TestUtil.screenshotName + " height=200 width=200></img></a>");
						Reporter.log("<br>");
						Reporter.log("<br>");

						// Extent Report
						test.log(LogStatus.FAIL, " The open task of the inspection is displayed incorrectly. : ");
						test.log(LogStatus.FAIL, test.addScreenCapture(TestUtil.screenshotName));

						System.out.println("The open task of the inspection is displayed incorrectly.");
						log.info("The open task of the inspection is displayed incorrectly.");
					}

				} catch (Throwable t) {

					TestUtil.captureScreenshot();

					// ReportNG
					Reporter.log("<br>" + " The open task of the inspection is displayed incorrectly. : " + "<br>");
					Reporter.log("<a target=\"_blank\" href=" + TestUtil.screenshotName + "><img src="
							+ TestUtil.screenshotName + " height=200 width=200></img></a>");
					Reporter.log("<br>");
					Reporter.log("<br>");

					// Extent Report
					test.log(LogStatus.FAIL, " The open task of the inspection is displayed incorrectly. : ");
					test.log(LogStatus.FAIL, test.addScreenCapture(TestUtil.screenshotName));

					System.out.println("The open task of the inspection is displayed incorrectly.");
					log.info("The open task of the inspection is displayed incorrectly.");
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

			// COMPLETE THE NEWLY CREATED TASK

			System.out.println("**************** COMPLETE THE NEWLY CREATED TASK ****************");
			test.log(LogStatus.INFO, "**************** COMPLETE THE NEWLY CREATED TASK ****************");
			Reporter.log("**************** COMPLETE THE NEWLY CREATED TASK ****************");
			log.info("**************** COMPLETE THE NEWLY CREATED TASK ****************");

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
				click("inspection_createdinspection5_XPATH");
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

				// click on the newly created task
				click("questionnaire_checklist_newlycreatedtask_capreit1_XPATH");
				ngDriver.waitForAngularRequestsToFinish();
				System.out.println("Clicked on the newly created task.");

				// SET TASK AS A IN PROGRESS
				System.out.println("SET TASK AS A IN PROGRESS");
				test.log(LogStatus.INFO, "SET TASK AS A IN PROGRESS");
				Reporter.log("SET TASK AS A IN PROGRESS");
				log.info("SET TASK AS A IN PROGRESS");

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
				click("task_autotask_closedlbl_actionicon_viainspection_addedreport3_XPATH");
				ngDriver.waitForAngularRequestsToFinish();
				System.out.println("Clicked on the action icon of the approved task.");

				// click on the complete task option
				click("task_autotask_closedlbl_actionicon_closeoption_viainspection_report3_XPATH");
				ngDriver.waitForAngularRequestsToFinish();
				System.out.println("Clicked on the complete task option.");

				// verify in closed status is display
				switchVerification("task_autotask_closedlbl_report3_addedtask_XPATH", "Closed",
						"The closed status is not displayed.");

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

			// VERIFY THE INSPECTION WITH CLOSED TASK IN PORTFOLIO SUMMARY DASHBOARD

			System.out.println(
					"******************** VERIFY THE INSPECTION WITH CLOSED TASK IN PORTFOLIO SUMMARY DASHBOARD ********************");
			test.log(LogStatus.INFO,
					"******************** VERIFY THE INSPECTION WITH CLOSED TASK IN PORTFOLIO SUMMARY DASHBOARD ********************");
			Reporter.log(
					"******************** VERIFY THE INSPECTION WITH CLOSED TASK IN PORTFOLIO SUMMARY DASHBOARD ********************");
			log.info(
					"******************** VERIFY THE INSPECTION WITH CLOSED TASK IN PORTFOLIO SUMMARY DASHBOARD ********************");

			try {

				// wait for the element
				Thread.sleep(5000);

				// click on the side menu
				click("menubtn_CSS");
				ngDriver.waitForAngularRequestsToFinish();
				System.out.println("Clicked on the side menu.");

				// wait for the element
				Thread.sleep(5000);

				// click on the portfolio summary option
				click("sidemenu_portfoliosummary_XPATH");
				ngDriver.waitForAngularRequestsToFinish();
				System.out.println("Clicked on the portfolio summary option.");

				// scroll down the screen
				JavascriptExecutor js = (JavascriptExecutor) driver;
				WebElement inspectionOM = driver
						.findElement(By.xpath(OR.getProperty("portfoliosummary_inspection2_XPATH")));
				js.executeScript("arguments[0].scrollIntoView(true);", inspectionOM);
				js.executeScript("window.scrollBy(0,-200)");

				// VERIFY INSPECTION DETAILS IN THE PORTFOLIO SUMMARY DASHBOARD SCREEN

				System.out.println(
						"******************** VERIFY INSPECTION DETAILS IN THE PORTFOLIO SUMMARY DASHBOARD SCREEN ********************");
				test.log(LogStatus.INFO,
						"******************** VERIFY INSPECTION DETAILS IN THE PORTFOLIO SUMMARY DASHBOARD SCREEN ********************");
				Reporter.log(
						"******************** VERIFY INSPECTION DETAILS IN THE PORTFOLIO SUMMARY DASHBOARD SCREEN ********************");
				log.info(
						"******************** VERIFY INSPECTION DETAILS IN THE PORTFOLIO SUMMARY DASHBOARD SCREEN ********************");

				try {
					String property5String = (driver
							.findElement(By.cssSelector(OR.getProperty("portfoliosummary_inspection2_property_CSS")))
							.getText()).trim();

					int property5 = Integer.parseInt(property5String);

					if (property == (property5)) {
						System.out.println("The property count of the inspection is displayed correctly.");
						test.log(LogStatus.INFO, "The property count of the inspection is displayed correctly.");
						Reporter.log("The property count of the inspection is displayed correctly.");
						log.info("The property count of the inspection is displayed correctly.");
					} else {
						TestUtil.captureScreenshot();

						// ReportNG
						Reporter.log(
								"<br>" + " The property count of the inspection is displayed incorrectly. : " + "<br>");
						Reporter.log("<a target=\"_blank\" href=" + TestUtil.screenshotName + "><img src="
								+ TestUtil.screenshotName + " height=200 width=200></img></a>");
						Reporter.log("<br>");
						Reporter.log("<br>");

						// Extent Report
						test.log(LogStatus.FAIL, " The property count of the inspection is displayed incorrectly. : ");
						test.log(LogStatus.FAIL, test.addScreenCapture(TestUtil.screenshotName));

						System.out.println("The property count of the inspection is displayed incorrectly.");
						log.info("The property count of the inspection is displayed incorrectly.");
					}

				} catch (Throwable t) {
					TestUtil.captureScreenshot();

					// ReportNG
					Reporter.log(
							"<br>" + " The property count of the inspection is displayed incorrectly. : " + "<br>");
					Reporter.log("<a target=\"_blank\" href=" + TestUtil.screenshotName + "><img src="
							+ TestUtil.screenshotName + " height=200 width=200></img></a>");
					Reporter.log("<br>");
					Reporter.log("<br>");

					// Extent Report
					test.log(LogStatus.FAIL, " The property count of the inspection is displayed incorrectly. : ");
					test.log(LogStatus.FAIL, test.addScreenCapture(TestUtil.screenshotName));

					System.out.println("The property count of the inspection is displayed incorrectly.");
					log.info("The property count of the inspection is displayed incorrectly.");
				}

				// VERIFY COUNT OF THE ACTIVE TASKS AFTER THE INSPECTION MAKE IN PROGRESS

				try {
					String task5String = (driver
							.findElement(By.cssSelector(OR.getProperty("portfoliosummary_inspection2_task_CSS")))
							.getText()).trim();

					int task5 = Integer.parseInt(task5String);

					if (task == (task5 - 1)) {

						System.out.println("The active task count of the inspection is displayed correctly.");
						test.log(LogStatus.INFO, "The active task count of the inspection is displayed correctly.");
						Reporter.log("The active task count of the inspection is displayed correctly.");
						log.info("The active task count of the inspection is displayed correctly.");

					} else {
						TestUtil.captureScreenshot();

						// ReportNG
						Reporter.log("<br>" + " The active task count of the inspection is displayed incorrectly. : "
								+ "<br>");
						Reporter.log("<a target=\"_blank\" href=" + TestUtil.screenshotName + "><img src="
								+ TestUtil.screenshotName + " height=200 width=200></img></a>");
						Reporter.log("<br>");
						Reporter.log("<br>");

						// Extent Report
						test.log(LogStatus.FAIL,
								" The active task count of the inspection is displayed incorrectly. : ");
						test.log(LogStatus.FAIL, test.addScreenCapture(TestUtil.screenshotName));

						System.out.println("The active task count of the inspection is displayed incorrectly.");
						log.info("The active task count of the inspection is displayed incorrectly.");
					}

				} catch (Throwable t) {
					TestUtil.captureScreenshot();

					// ReportNG
					Reporter.log(
							"<br>" + " The active task count of the inspection is displayed incorrectly. : " + "<br>");
					Reporter.log("<a target=\"_blank\" href=" + TestUtil.screenshotName + "><img src="
							+ TestUtil.screenshotName + " height=200 width=200></img></a>");
					Reporter.log("<br>");
					Reporter.log("<br>");

					// Extent Report
					test.log(LogStatus.FAIL, " The active task count of the inspection is displayed incorrectly. : ");
					test.log(LogStatus.FAIL, test.addScreenCapture(TestUtil.screenshotName));

					System.out.println("The active task count of the inspection is displayed incorrectly.");
					log.info("The active task count of the inspection is displayed incorrectly.");
				}

				// VERIFY INSPECTION DETAILS IN THE INSPECTION LIST SCREEN

				System.out.println(
						"******************** VERIFY INSPECTION DETAILS IN THE INSPECTION LIST SCREEN ********************");
				test.log(LogStatus.INFO,
						"******************** VERIFY INSPECTION DETAILS IN THE INSPECTION LIST SCREEN ********************");
				Reporter.log(
						"******************** VERIFY INSPECTION DETAILS IN THE INSPECTION LIST SCREEN ********************");
				log.info(
						"******************** VERIFY INSPECTION DETAILS IN THE INSPECTION LIST SCREEN ********************");

				// click on the property count
				click("portfoliosummary_inspection2_property_CSS");
				ngDriver.waitForAngularRequestsToFinish();
				System.out.println("Clicked on the property count.");

				// VERIFY THE OPEN TASK COUNT

				try {

					String openTask5String = (driver
							.findElement(
									By.xpath(OR.getProperty("portfoliosummary_inspection2_inspectionlist_task_XPATH")))
							.getText()).trim();

					int openTask5 = Integer.parseInt(openTask5String);

					if (openTask == (openTask5 - 1)) {

						System.out.println("The open task count of the inspection is displayed correctly.");
						test.log(LogStatus.INFO, "The open task count of the inspection is displayed correctly.");
						Reporter.log("The open task count of the inspection is displayed correctly.");
						log.info("The open task count of the inspection is displayed correctly.");

					} else {
						TestUtil.captureScreenshot();

						// ReportNG
						Reporter.log("<br>" + " The open task count of the inspection is displayed incorrectly. : "
								+ "<br>");
						Reporter.log("<a target=\"_blank\" href=" + TestUtil.screenshotName + "><img src="
								+ TestUtil.screenshotName + " height=200 width=200></img></a>");
						Reporter.log("<br>");
						Reporter.log("<br>");

						// Extent Report
						test.log(LogStatus.FAIL, " The open task count of the inspection is displayed incorrectly. : ");
						test.log(LogStatus.FAIL, test.addScreenCapture(TestUtil.screenshotName));

						System.out.println("The open task count of the inspection is displayed incorrectly.");
						log.info("The open task count of the inspection is displayed incorrectly.");
					}

				} catch (Throwable t) {
					TestUtil.captureScreenshot();

					// ReportNG
					Reporter.log(
							"<br>" + " The open task count of the inspection is displayed incorrectly. : " + "<br>");
					Reporter.log("<a target=\"_blank\" href=" + TestUtil.screenshotName + "><img src="
							+ TestUtil.screenshotName + " height=200 width=200></img></a>");
					Reporter.log("<br>");
					Reporter.log("<br>");

					// Extent Report
					test.log(LogStatus.FAIL, " The open task count of the inspection is displayed incorrectly. : ");
					test.log(LogStatus.FAIL, test.addScreenCapture(TestUtil.screenshotName));

					System.out.println("The open task count of the inspection is displayed incorrectly.");
					log.info("The open task count of the inspection is displayed incorrectly.");
				}

				// click on the fourth circle
				click("portfoliosummary_inspection2_inspectionlist_circle_XPATH");
				ngDriver.waitForAngularRequestsToFinish();
				System.out.println("Clicked on the fourth circle.");

				// VERIFY INSPECTION DETAILS IN THE CREATE CHECKLIST LIST SCREEN

				System.out.println(
						"******************** VERIFY INSPECTION DETAILS IN THE CREATE CHECKLIST LIST SCREEN ********************");
				test.log(LogStatus.INFO,
						"******************** VERIFY INSPECTION DETAILS IN THE CREATE CHECKLIST LIST SCREEN ********************");
				Reporter.log(
						"******************** VERIFY INSPECTION DETAILS IN THE CREATE CHECKLIST LIST SCREEN ********************");
				log.info(
						"******************** VERIFY INSPECTION DETAILS IN THE CREATE CHECKLIST LIST SCREEN ********************");

				// enter the inspection name in the search field
				type("task_listofchecklist_filterfield_CSS", data.get("checklist_property_title"));
				ngDriver.waitForAngularRequestsToFinish();
				System.out.println("Entered the inspection name in the search field.");

				// VERIFY NEWLY CREATED INSPECTION IS DISPLAYED OR NOT

				try {
					String inspectionName = driver
							.findElement(By.xpath(OR.getProperty("inspection_createdinspection5_XPATH"))).getText();

					if (inspectionName.equals("Test Questionnaire Property Title Smoke Capreit Five")) {
						System.out.println("The inspection is displayed correctly.");
						test.log(LogStatus.INFO, "The inspection is displayed correctly.");
						Reporter.log("The inspection is displayed correctly.");
						log.info("The inspection is displayed correctly.");
					} else {
						TestUtil.captureScreenshot();

						// ReportNG
						Reporter.log("<br>" + " The inspection is not displayed. : " + "<br>");
						Reporter.log("<a target=\"_blank\" href=" + TestUtil.screenshotName + "><img src="
								+ TestUtil.screenshotName + " height=200 width=200></img></a>");
						Reporter.log("<br>");
						Reporter.log("<br>");

						// Extent Report
						test.log(LogStatus.FAIL, " The inspection is not displayed. : ");
						test.log(LogStatus.FAIL, test.addScreenCapture(TestUtil.screenshotName));

						System.out.println("The inspection is not displayed.");
						log.info("The inspection is not displayed.");
					}

				} catch (Throwable t) {
					TestUtil.captureScreenshot();

					// ReportNG
					Reporter.log("<br>" + " The inspection is not displayed. : " + "<br>");
					Reporter.log("<a target=\"_blank\" href=" + TestUtil.screenshotName + "><img src="
							+ TestUtil.screenshotName + " height=200 width=200></img></a>");
					Reporter.log("<br>");
					Reporter.log("<br>");

					// Extent Report
					test.log(LogStatus.FAIL, " The inspection is not displayed. : ");
					test.log(LogStatus.FAIL, test.addScreenCapture(TestUtil.screenshotName));

					System.out.println("The inspection is not displayed.");
					log.info("The inspection is not displayed.");
				}

				// VERIFY COMPLETION OF THE INSPECTION

				try {

					String inspectionCompletion = driver
							.findElement(By.xpath(
									OR.getProperty("portfoliosummary_inspection2_inspectionlist_completion_XPATH")))
							.getText();

					if (inspectionCompletion.equals("100%")) {
						System.out.println("The completion percentage of the inspection is displayed correctly.");
						test.log(LogStatus.INFO, "The completion percentage of the inspection is displayed correctly.");
						Reporter.log("The completion percentage of the inspection is displayed correctly.");
						log.info("The completion percentage of the inspection is displayed correctly.");
					} else {
						TestUtil.captureScreenshot();

						// ReportNG
						Reporter.log("<br>"
								+ " The completion percentage of the inspection is displayed incorrectly. : " + "<br>");
						Reporter.log("<a target=\"_blank\" href=" + TestUtil.screenshotName + "><img src="
								+ TestUtil.screenshotName + " height=200 width=200></img></a>");
						Reporter.log("<br>");
						Reporter.log("<br>");

						// Extent Report
						test.log(LogStatus.FAIL,
								" The completion percentage of the inspection is displayed incorrectly. : ");
						test.log(LogStatus.FAIL, test.addScreenCapture(TestUtil.screenshotName));

						System.out.println("The completion percentage of the inspection is displayed incorrectly.");
						log.info("The completion percentage of the inspection is displayed incorrectly.");
					}

				} catch (Throwable t) {

					TestUtil.captureScreenshot();

					// ReportNG
					Reporter.log("<br>" + " The completion percentage of the inspection is displayed incorrectly. : "
							+ "<br>");
					Reporter.log("<a target=\"_blank\" href=" + TestUtil.screenshotName + "><img src="
							+ TestUtil.screenshotName + " height=200 width=200></img></a>");
					Reporter.log("<br>");
					Reporter.log("<br>");

					// Extent Report
					test.log(LogStatus.FAIL,
							" The completion percentage of the inspection is displayed incorrectly. : ");
					test.log(LogStatus.FAIL, test.addScreenCapture(TestUtil.screenshotName));

					System.out.println("The completion percentage of the inspection is displayed incorrectly.");
					log.info("The completion percentage of the inspection is displayed incorrectly.");
				}

				// VERIFY TOTAL TASK OF THE INSPECTION

				try {

					String inspectionTotalTaskString = driver
							.findElement(By.xpath(
									OR.getProperty("portfoliosummary_inspection2_inspectionlist_totaltask_XPATH")))
							.getText();

					int inspectionTotalTask = Integer.parseInt(inspectionTotalTaskString);

					if (task == (inspectionTotalTask - 2)) {

						System.out.println("The total task of the inspection is displayed correctly.");
						test.log(LogStatus.INFO, "The total task of the inspection is displayed correctly.");
						Reporter.log("The total task of the inspection is displayed correctly.");
						log.info("The total task of the inspection is displayed correctly.");
					} else {
						TestUtil.captureScreenshot();

						// ReportNG
						Reporter.log(
								"<br>" + " The total task of the inspection is displayed incorrectly. : " + "<br>");
						Reporter.log("<a target=\"_blank\" href=" + TestUtil.screenshotName + "><img src="
								+ TestUtil.screenshotName + " height=200 width=200></img></a>");
						Reporter.log("<br>");
						Reporter.log("<br>");

						// Extent Report
						test.log(LogStatus.FAIL, " The total task of the inspection is displayed incorrectly. : ");
						test.log(LogStatus.FAIL, test.addScreenCapture(TestUtil.screenshotName));

						System.out.println("The total task of the inspection is displayed incorrectly.");
						log.info("The total task of the inspection is displayed incorrectly.");
					}

				} catch (Throwable t) {

					TestUtil.captureScreenshot();

					// ReportNG
					Reporter.log("<br>" + " The total task of the inspection is displayed incorrectly. : " + "<br>");
					Reporter.log("<a target=\"_blank\" href=" + TestUtil.screenshotName + "><img src="
							+ TestUtil.screenshotName + " height=200 width=200></img></a>");
					Reporter.log("<br>");
					Reporter.log("<br>");

					// Extent Report
					test.log(LogStatus.FAIL, " The total task of the inspection is displayed incorrectly. : ");
					test.log(LogStatus.FAIL, test.addScreenCapture(TestUtil.screenshotName));

					System.out.println("The total task of the inspection is displayed incorrectly.");
					log.info("The total task of the inspection is displayed incorrectly.");
				}

				// VERIFY OPEN TASK OF THE INSPECTION

				try {

					String inspectionCompletionString = driver
							.findElement(By.xpath(
									OR.getProperty("portfoliosummary_inspection2_inspectionlist_opentask_XPATH")))
							.getText();

					int inspectionCompletion = Integer.parseInt(inspectionCompletionString);

					if (openTask == (inspectionCompletion - 1)) {

						System.out.println("The open task of the inspection is displayed correctly.");
						test.log(LogStatus.INFO, "The open task of the inspection is displayed correctly.");
						Reporter.log("The open task of the inspection is displayed correctly.");
						log.info("The open task of the inspection is displayed correctly.");
					} else {
						TestUtil.captureScreenshot();

						// ReportNG
						Reporter.log("<br>" + " The open task of the inspection is displayed incorrectly. : " + "<br>");
						Reporter.log("<a target=\"_blank\" href=" + TestUtil.screenshotName + "><img src="
								+ TestUtil.screenshotName + " height=200 width=200></img></a>");
						Reporter.log("<br>");
						Reporter.log("<br>");

						// Extent Report
						test.log(LogStatus.FAIL, " The open task of the inspection is displayed incorrectly. : ");
						test.log(LogStatus.FAIL, test.addScreenCapture(TestUtil.screenshotName));

						System.out.println("The open task of the inspection is displayed incorrectly.");
						log.info("The open task of the inspection is displayed incorrectly.");
					}

				} catch (Throwable t) {

					TestUtil.captureScreenshot();

					// ReportNG
					Reporter.log("<br>" + " The open task of the inspection is displayed incorrectly. : " + "<br>");
					Reporter.log("<a target=\"_blank\" href=" + TestUtil.screenshotName + "><img src="
							+ TestUtil.screenshotName + " height=200 width=200></img></a>");
					Reporter.log("<br>");
					Reporter.log("<br>");

					// Extent Report
					test.log(LogStatus.FAIL, " The open task of the inspection is displayed incorrectly. : ");
					test.log(LogStatus.FAIL, test.addScreenCapture(TestUtil.screenshotName));

					System.out.println("The open task of the inspection is displayed incorrectly.");
					log.info("The open task of the inspection is displayed incorrectly.");
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

			// COMPLETE THE AUTO GENERATED TASK

			System.out.println("**************** COMPLETE THE AUTO GENERATED TASK ****************");
			test.log(LogStatus.INFO, "**************** COMPLETE THE AUTO GENERATED TASK ****************");
			Reporter.log("**************** COMPLETE THE AUTO GENERATED TASK ****************");
			log.info("**************** COMPLETE THE AUTO GENERATED TASK ****************");

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
				click("inspection_createdinspection5_XPATH");
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

				// click on the newly created task
				click("questionnaire_checklist_autogeneratedtask_capreit1om_XPATH");
				ngDriver.waitForAngularRequestsToFinish();
				System.out.println("Clicked on the newly created task.");

				// SET TASK AS A IN PROGRESS
				System.out.println("SET TASK AS A IN PROGRESS");
				test.log(LogStatus.INFO, "SET TASK AS A IN PROGRESS");
				Reporter.log("SET TASK AS A IN PROGRESS");
				log.info("SET TASK AS A IN PROGRESS");

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
				click("task_autotask_approvedlbl_actionicon_report3_XPATH");
				ngDriver.waitForAngularRequestsToFinish();
				System.out.println("Clicked on the action icon of the approved task.");

				// click on the complete task option
				click("task_autotask_approvedlbl_actionicon_closeoption_report3_XPATH");
				ngDriver.waitForAngularRequestsToFinish();
				System.out.println("Clicked on the complete task option.");

				// verify in closed status is display
				switchVerification("task_autotask_closedlbl_report3_XPATH", "Closed",
						"The closed status is not displayed.");

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

			// VERIFY THE INSPECTION WITH CLOSED AUTO GENERATED TASK IN PORTFOLIO SUMMARY
			// DASHBOARD

			System.out.println(
					"******************** VERIFY THE INSPECTION WITH CLOSED AUTO GENERATED TASK IN PORTFOLIO SUMMARY DASHBOARD ********************");
			test.log(LogStatus.INFO,
					"******************** VERIFY THE INSPECTION WITH CLOSED AUTO GENERATED TASK IN PORTFOLIO SUMMARY DASHBOARD ********************");
			Reporter.log(
					"******************** VERIFY THE INSPECTION WITH CLOSED AUTO GENERATED TASK IN PORTFOLIO SUMMARY DASHBOARD ********************");
			log.info(
					"******************** VERIFY THE INSPECTION WITH CLOSED AUTO GENERATED TASK IN PORTFOLIO SUMMARY DASHBOARD ********************");

			try {

				// wait for the element
				Thread.sleep(5000);

				// click on the side menu
				click("menubtn_CSS");
				ngDriver.waitForAngularRequestsToFinish();
				System.out.println("Clicked on the side menu.");

				// wait for the element
				Thread.sleep(5000);

				// click on the portfolio summary option
				click("sidemenu_portfoliosummary_XPATH");
				ngDriver.waitForAngularRequestsToFinish();
				System.out.println("Clicked on the portfolio summary option.");

				// scroll down the screen
				JavascriptExecutor js = (JavascriptExecutor) driver;
				WebElement inspectionOM = driver
						.findElement(By.xpath(OR.getProperty("portfoliosummary_inspection2_XPATH")));
				js.executeScript("arguments[0].scrollIntoView(true);", inspectionOM);
				js.executeScript("window.scrollBy(0,-200)");

				// VERIFY INSPECTION DETAILS IN THE PORTFOLIO SUMMARY DASHBOARD SCREEN

				System.out.println(
						"******************** VERIFY INSPECTION DETAILS IN THE PORTFOLIO SUMMARY DASHBOARD SCREEN ********************");
				test.log(LogStatus.INFO,
						"******************** VERIFY INSPECTION DETAILS IN THE PORTFOLIO SUMMARY DASHBOARD SCREEN ********************");
				Reporter.log(
						"******************** VERIFY INSPECTION DETAILS IN THE PORTFOLIO SUMMARY DASHBOARD SCREEN ********************");
				log.info(
						"******************** VERIFY INSPECTION DETAILS IN THE PORTFOLIO SUMMARY DASHBOARD SCREEN ********************");

				try {
					String property6String = (driver
							.findElement(By.cssSelector(OR.getProperty("portfoliosummary_inspection2_property_CSS")))
							.getText()).trim();

					int property6 = Integer.parseInt(property6String);

					if (property == (property6)) {

						System.out.println("The property count of the inspection is displayed correctly.");
						test.log(LogStatus.INFO, "The property count of the inspection is displayed correctly.");
						Reporter.log("The property count of the inspection is displayed correctly.");
						log.info("The property count of the inspection is displayed correctly.");
					} else {
						TestUtil.captureScreenshot();

						// ReportNG
						Reporter.log(
								"<br>" + " The property count of the inspection is displayed incorrectly. : " + "<br>");
						Reporter.log("<a target=\"_blank\" href=" + TestUtil.screenshotName + "><img src="
								+ TestUtil.screenshotName + " height=200 width=200></img></a>");
						Reporter.log("<br>");
						Reporter.log("<br>");

						// Extent Report
						test.log(LogStatus.FAIL, " The property count of the inspection is displayed incorrectly. : ");
						test.log(LogStatus.FAIL, test.addScreenCapture(TestUtil.screenshotName));

						System.out.println("The property count of the inspection is displayed incorrectly.");
						log.info("The property count of the inspection is displayed incorrectly.");
					}

				} catch (Throwable t) {
					TestUtil.captureScreenshot();

					// ReportNG
					Reporter.log(
							"<br>" + " The property count of the inspection is displayed incorrectly. : " + "<br>");
					Reporter.log("<a target=\"_blank\" href=" + TestUtil.screenshotName + "><img src="
							+ TestUtil.screenshotName + " height=200 width=200></img></a>");
					Reporter.log("<br>");
					Reporter.log("<br>");

					// Extent Report
					test.log(LogStatus.FAIL, " The property count of the inspection is displayed incorrectly. : ");
					test.log(LogStatus.FAIL, test.addScreenCapture(TestUtil.screenshotName));

					System.out.println("The property count of the inspection is displayed incorrectly.");
					log.info("The property count of the inspection is displayed incorrectly.");
				}

				// VERIFY COUNT OF THE ACTIVE TASKS AFTER THE INSPECTION MAKE IN PROGRESS

				try {
					String task6String = (driver
							.findElement(By.cssSelector(OR.getProperty("portfoliosummary_inspection2_task_CSS")))
							.getText()).trim();

					int task6 = Integer.parseInt(task6String);

					if (task == (task6)) {
						System.out.println("The active task count of the inspection is displayed correctly.");
						test.log(LogStatus.INFO, "The active task count of the inspection is displayed correctly.");
						Reporter.log("The active task count of the inspection is displayed correctly.");
						log.info("The active task count of the inspection is displayed correctly.");

					} else {
						TestUtil.captureScreenshot();

						// ReportNG
						Reporter.log("<br>" + " The active task count of the inspection is displayed incorrectly. : "
								+ "<br>");
						Reporter.log("<a target=\"_blank\" href=" + TestUtil.screenshotName + "><img src="
								+ TestUtil.screenshotName + " height=200 width=200></img></a>");
						Reporter.log("<br>");
						Reporter.log("<br>");

						// Extent Report
						test.log(LogStatus.FAIL,
								" The active task count of the inspection is displayed incorrectly. : ");
						test.log(LogStatus.FAIL, test.addScreenCapture(TestUtil.screenshotName));

						System.out.println("The active task count of the inspection is displayed incorrectly.");
						log.info("The active task count of the inspection is displayed incorrectly.");
					}

				} catch (Throwable t) {
					TestUtil.captureScreenshot();

					// ReportNG
					Reporter.log(
							"<br>" + " The active task count of the inspection is displayed incorrectly. : " + "<br>");
					Reporter.log("<a target=\"_blank\" href=" + TestUtil.screenshotName + "><img src="
							+ TestUtil.screenshotName + " height=200 width=200></img></a>");
					Reporter.log("<br>");
					Reporter.log("<br>");

					// Extent Report
					test.log(LogStatus.FAIL, " The active task count of the inspection is displayed incorrectly. : ");
					test.log(LogStatus.FAIL, test.addScreenCapture(TestUtil.screenshotName));

					System.out.println("The active task count of the inspection is displayed incorrectly.");
					log.info("The active task count of the inspection is displayed incorrectly.");
				}

				// VERIFY INSPECTION DETAILS IN THE INSPECTION LIST SCREEN

				System.out.println(
						"******************** VERIFY INSPECTION DETAILS IN THE INSPECTION LIST SCREEN ********************");
				test.log(LogStatus.INFO,
						"******************** VERIFY INSPECTION DETAILS IN THE INSPECTION LIST SCREEN ********************");
				Reporter.log(
						"******************** VERIFY INSPECTION DETAILS IN THE INSPECTION LIST SCREEN ********************");
				log.info(
						"******************** VERIFY INSPECTION DETAILS IN THE INSPECTION LIST SCREEN ********************");

				// click on the property count
				click("portfoliosummary_inspection2_property_CSS");
				ngDriver.waitForAngularRequestsToFinish();
				System.out.println("Clicked on the property count.");

				// VERIFY THE OPEN TASK COUNT

				try {

					String openTask6String = (driver
							.findElement(
									By.xpath(OR.getProperty("portfoliosummary_inspection2_inspectionlist_task_XPATH")))
							.getText()).trim();

					int openTask6 = Integer.parseInt(openTask6String);

					if (openTask == (openTask6)) {

						System.out.println("The open task count of the inspection is displayed correctly.");
						test.log(LogStatus.INFO, "The open task count of the inspection is displayed correctly.");
						Reporter.log("The open task count of the inspection is displayed correctly.");
						log.info("The open task count of the inspection is displayed correctly.");

					} else {
						TestUtil.captureScreenshot();

						// ReportNG
						Reporter.log("<br>" + " The open task count of the inspection is displayed incorrectly. : "
								+ "<br>");
						Reporter.log("<a target=\"_blank\" href=" + TestUtil.screenshotName + "><img src="
								+ TestUtil.screenshotName + " height=200 width=200></img></a>");
						Reporter.log("<br>");
						Reporter.log("<br>");

						// Extent Report
						test.log(LogStatus.FAIL, " The open task count of the inspection is displayed incorrectly. : ");
						test.log(LogStatus.FAIL, test.addScreenCapture(TestUtil.screenshotName));

						System.out.println("The open task count of the inspection is displayed incorrectly.");
						log.info("The open task count of the inspection is displayed incorrectly.");
					}

				} catch (Throwable t) {
					TestUtil.captureScreenshot();

					// ReportNG
					Reporter.log(
							"<br>" + " The open task count of the inspection is displayed incorrectly. : " + "<br>");
					Reporter.log("<a target=\"_blank\" href=" + TestUtil.screenshotName + "><img src="
							+ TestUtil.screenshotName + " height=200 width=200></img></a>");
					Reporter.log("<br>");
					Reporter.log("<br>");

					// Extent Report
					test.log(LogStatus.FAIL, " The open task count of the inspection is displayed incorrectly. : ");
					test.log(LogStatus.FAIL, test.addScreenCapture(TestUtil.screenshotName));

					System.out.println("The open task count of the inspection is displayed incorrectly.");
					log.info("The open task count of the inspection is displayed incorrectly.");
				}

				// click on the fourth circle
				click("portfoliosummary_inspection2_inspectionlist_circle_XPATH");
				ngDriver.waitForAngularRequestsToFinish();
				System.out.println("Clicked on the fourth circle.");

				// VERIFY INSPECTION DETAILS IN THE CREATE CHECKLIST LIST SCREEN

				System.out.println(
						"******************** VERIFY INSPECTION DETAILS IN THE CREATE CHECKLIST LIST SCREEN ********************");
				test.log(LogStatus.INFO,
						"******************** VERIFY INSPECTION DETAILS IN THE CREATE CHECKLIST LIST SCREEN ********************");
				Reporter.log(
						"******************** VERIFY INSPECTION DETAILS IN THE CREATE CHECKLIST LIST SCREEN ********************");
				log.info(
						"******************** VERIFY INSPECTION DETAILS IN THE CREATE CHECKLIST LIST SCREEN ********************");

				// enter the inspection name in the search field
				type("task_listofchecklist_filterfield_CSS", data.get("checklist_property_title"));
				ngDriver.waitForAngularRequestsToFinish();
				System.out.println("Entered the inspection name in the search field.");

				// VERIFY NEWLY CREATED INSPECTION IS DISPLAYED OR NOT

				try {
					String inspectionName = driver
							.findElement(By.xpath(OR.getProperty("inspection_createdinspection5_XPATH"))).getText();

					if (inspectionName.equals("Test Questionnaire Property Title Smoke Capreit Five")) {
						System.out.println("The inspection is displayed correctly.");
						test.log(LogStatus.INFO, "The inspection is displayed correctly.");
						Reporter.log("The inspection is displayed correctly.");
						log.info("The inspection is displayed correctly.");
					} else {
						TestUtil.captureScreenshot();

						// ReportNG
						Reporter.log("<br>" + " The inspection is not displayed. : " + "<br>");
						Reporter.log("<a target=\"_blank\" href=" + TestUtil.screenshotName + "><img src="
								+ TestUtil.screenshotName + " height=200 width=200></img></a>");
						Reporter.log("<br>");
						Reporter.log("<br>");

						// Extent Report
						test.log(LogStatus.FAIL, " The inspection is not displayed. : ");
						test.log(LogStatus.FAIL, test.addScreenCapture(TestUtil.screenshotName));

						System.out.println("The inspection is not displayed.");
						log.info("The inspection is not displayed.");
					}

				} catch (Throwable t) {
					TestUtil.captureScreenshot();

					// ReportNG
					Reporter.log("<br>" + " The inspection is not displayed. : " + "<br>");
					Reporter.log("<a target=\"_blank\" href=" + TestUtil.screenshotName + "><img src="
							+ TestUtil.screenshotName + " height=200 width=200></img></a>");
					Reporter.log("<br>");
					Reporter.log("<br>");

					// Extent Report
					test.log(LogStatus.FAIL, " The inspection is not displayed. : ");
					test.log(LogStatus.FAIL, test.addScreenCapture(TestUtil.screenshotName));

					System.out.println("The inspection is not displayed.");
					log.info("The inspection is not displayed.");
				}

				// VERIFY COMPLETION OF THE INSPECTION

				try {

					String inspectionCompletion = driver
							.findElement(By.xpath(
									OR.getProperty("portfoliosummary_inspection2_inspectionlist_completion_XPATH")))
							.getText();

					if (inspectionCompletion.equals("100%")) {
						System.out.println("The completion percentage of the inspection is displayed correctly.");
						test.log(LogStatus.INFO, "The completion percentage of the inspection is displayed correctly.");
						Reporter.log("The completion percentage of the inspection is displayed correctly.");
						log.info("The completion percentage of the inspection is displayed correctly.");
					} else {
						TestUtil.captureScreenshot();

						// ReportNG
						Reporter.log("<br>"
								+ " The completion percentage of the inspection is displayed incorrectly. : " + "<br>");
						Reporter.log("<a target=\"_blank\" href=" + TestUtil.screenshotName + "><img src="
								+ TestUtil.screenshotName + " height=200 width=200></img></a>");
						Reporter.log("<br>");
						Reporter.log("<br>");

						// Extent Report
						test.log(LogStatus.FAIL,
								" The completion percentage of the inspection is displayed incorrectly. : ");
						test.log(LogStatus.FAIL, test.addScreenCapture(TestUtil.screenshotName));

						System.out.println("The completion percentage of the inspection is displayed incorrectly.");
						log.info("The completion percentage of the inspection is displayed incorrectly.");
					}

				} catch (Throwable t) {

					TestUtil.captureScreenshot();

					// ReportNG
					Reporter.log("<br>" + " The completion percentage of the inspection is displayed incorrectly. : "
							+ "<br>");
					Reporter.log("<a target=\"_blank\" href=" + TestUtil.screenshotName + "><img src="
							+ TestUtil.screenshotName + " height=200 width=200></img></a>");
					Reporter.log("<br>");
					Reporter.log("<br>");

					// Extent Report
					test.log(LogStatus.FAIL,
							" The completion percentage of the inspection is displayed incorrectly. : ");
					test.log(LogStatus.FAIL, test.addScreenCapture(TestUtil.screenshotName));

					System.out.println("The completion percentage of the inspection is displayed incorrectly.");
					log.info("The completion percentage of the inspection is displayed incorrectly.");
				}

				// VERIFY TOTAL TASK OF THE INSPECTION

				try {

					String inspectionTotalTaskString = driver
							.findElement(By.xpath(
									OR.getProperty("portfoliosummary_inspection2_inspectionlist_totaltask_XPATH")))
							.getText();

					int inspectionTotalTask = Integer.parseInt(inspectionTotalTaskString);

					if (task == (inspectionTotalTask - 2)) {

						System.out.println("The total task of the inspection is displayed correctly.");
						test.log(LogStatus.INFO, "The total task of the inspection is displayed correctly.");
						Reporter.log("The total task of the inspection is displayed correctly.");
						log.info("The total task of the inspection is displayed correctly.");
					} else {
						TestUtil.captureScreenshot();

						// ReportNG
						Reporter.log(
								"<br>" + " The total task of the inspection is displayed incorrectly. : " + "<br>");
						Reporter.log("<a target=\"_blank\" href=" + TestUtil.screenshotName + "><img src="
								+ TestUtil.screenshotName + " height=200 width=200></img></a>");
						Reporter.log("<br>");
						Reporter.log("<br>");

						// Extent Report
						test.log(LogStatus.FAIL, " The total task of the inspection is displayed incorrectly. : ");
						test.log(LogStatus.FAIL, test.addScreenCapture(TestUtil.screenshotName));

						System.out.println("The total task of the inspection is displayed incorrectly.");
						log.info("The total task of the inspection is displayed incorrectly.");
					}

				} catch (Throwable t) {

					TestUtil.captureScreenshot();

					// ReportNG
					Reporter.log("<br>" + " The total task of the inspection is displayed incorrectly. : " + "<br>");
					Reporter.log("<a target=\"_blank\" href=" + TestUtil.screenshotName + "><img src="
							+ TestUtil.screenshotName + " height=200 width=200></img></a>");
					Reporter.log("<br>");
					Reporter.log("<br>");

					// Extent Report
					test.log(LogStatus.FAIL, " The total task of the inspection is displayed incorrectly. : ");
					test.log(LogStatus.FAIL, test.addScreenCapture(TestUtil.screenshotName));

					System.out.println("The total task of the inspection is displayed incorrectly.");
					log.info("The total task of the inspection is displayed incorrectly.");
				}

				// VERIFY OPEN TASK OF THE INSPECTION

				try {

					String inspectionCompletionString = driver
							.findElement(By.xpath(
									OR.getProperty("portfoliosummary_inspection2_inspectionlist_opentask_XPATH")))
							.getText();

					int inspectionCompletion = Integer.parseInt(inspectionCompletionString);

					if (openTask == (inspectionCompletion)) {
						System.out.println("The open task of the inspection is displayed correctly.");
						test.log(LogStatus.INFO, "The open task of the inspection is displayed correctly.");
						Reporter.log("The open task of the inspection is displayed correctly.");
						log.info("The open task of the inspection is displayed correctly.");
					} else {
						TestUtil.captureScreenshot();

						// ReportNG
						Reporter.log("<br>" + " The open task of the inspection is displayed incorrectly. : " + "<br>");
						Reporter.log("<a target=\"_blank\" href=" + TestUtil.screenshotName + "><img src="
								+ TestUtil.screenshotName + " height=200 width=200></img></a>");
						Reporter.log("<br>");
						Reporter.log("<br>");

						// Extent Report
						test.log(LogStatus.FAIL, " The open task of the inspection is displayed incorrectly. : ");
						test.log(LogStatus.FAIL, test.addScreenCapture(TestUtil.screenshotName));

						System.out.println("The open task of the inspection is displayed incorrectly.");
						log.info("The open task of the inspection is displayed incorrectly.");
					}

				} catch (Throwable t) {

					TestUtil.captureScreenshot();

					// ReportNG
					Reporter.log("<br>" + " The open task of the inspection is displayed incorrectly. : " + "<br>");
					Reporter.log("<a target=\"_blank\" href=" + TestUtil.screenshotName + "><img src="
							+ TestUtil.screenshotName + " height=200 width=200></img></a>");
					Reporter.log("<br>");
					Reporter.log("<br>");

					// Extent Report
					test.log(LogStatus.FAIL, " The open task of the inspection is displayed incorrectly. : ");
					test.log(LogStatus.FAIL, test.addScreenCapture(TestUtil.screenshotName));

					System.out.println("The open task of the inspection is displayed incorrectly.");
					log.info("The open task of the inspection is displayed incorrectly.");
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

			// SUBMIT THE COVID 19 INSPECTION

			System.out.println("******************** SUBMIT THE COVID 19 INSPECTION ********************");
			test.log(LogStatus.INFO, "******************** SUBMIT THE COVID 19 INSPECTION ********************");
			Reporter.log("******************** SUBMIT THE COVID 19 INSPECTION ********************");
			log.info("******************** SUBMIT THE COVID 19 INSPECTION ********************");

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
				click("inspection_createdinspection5_XPATH");
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

				// click on the next button from the 6th question
				click("checklist_wizard_nextbtn_CSS");
				ngDriver.waitForAngularRequestsToFinish();
				System.out.println("Clicked on the next button from the 6th question.");

				// click on the next button from the 7th question
				click("checklist_wizard_nextbtn_CSS");
				ngDriver.waitForAngularRequestsToFinish();
				System.out.println("Clicked on the next button from the 7th question.");

				// click on the submit button
				click("checklist_submitbtn_CSS");
				ngDriver.waitForAngularRequestsToFinish();
				System.out.println("Clicked on the submit button.");

				// wait for the element
				explicitWaitClickable("closetoastmsg_CSS");

				// click on the toaster close button
				click("closetoastmsg_CSS");
				ngDriver.waitForAngularRequestsToFinish();
				System.out.println("Clicked on the toaster close button.");

				// click on the back button
				click("questionnaire_checklist_backbtn_CSS");
				ngDriver.waitForAngularRequestsToFinish();
				System.out.println("Clicked on the back button.");

				// select the approved option from the status dropdown
				select("checklist_statusdd_CSS", data.get("status_dd"));
				ngDriver.waitForAngularRequestsToFinish();
				System.out.println("Selected the approved option from the status dropdown.");

				// enter newly created inspection in the search field
				clear("task_listofchecklist_filterfield_CSS");
				ngDriver.waitForAngularRequestsToFinish();
				System.out.println("Cleared the searched field.");
				type("task_listofchecklist_filterfield_CSS", data.get("checklist_property_title"));
				ngDriver.waitForAngularRequestsToFinish();
				System.out.println("Entered newly created inspection in the search field.");

				// verify submitted inspection is displayed or not
				switchVerification("inspection_createdinspection5_XPATH",
						"Test Questionnaire Property Title Smoke Capreit Five",
						"The Test Questionnaire Property Title Smoke Capreit Five is not displayed.");

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

			// VERIFY THE SUBMITTED INSPECTION WITH CLOSED AUTO GENERATED TASK IN PORTFOLIO
			// SUMMARY DASHBOARD

			System.out.println(
					"******************** VERIFY THE SUBMITTED INSPECTION WITH CLOSED AUTO GENERATED TASK IN PORTFOLIO SUMMARY DASHBOARD ********************");
			test.log(LogStatus.INFO,
					"******************** VERIFY THE SUBMITTED INSPECTION WITH CLOSED AUTO GENERATED TASK IN PORTFOLIO SUMMARY DASHBOARD ********************");
			Reporter.log(
					"******************** VERIFY THE SUBMITTED INSPECTION WITH CLOSED AUTO GENERATED TASK IN PORTFOLIO SUMMARY DASHBOARD ********************");
			log.info(
					"******************** VERIFY THE SUBMITTED INSPECTION WITH CLOSED AUTO GENERATED TASK IN PORTFOLIO SUMMARY DASHBOARD ********************");

			try {

				// wait for the element
				Thread.sleep(5000);

				// click on the side menu
				click("menubtn_CSS");
				ngDriver.waitForAngularRequestsToFinish();
				System.out.println("Clicked on the side menu.");

				// wait for the element
				Thread.sleep(5000);

				// click on the portfolio summary option
				click("sidemenu_portfoliosummary_XPATH");
				ngDriver.waitForAngularRequestsToFinish();
				System.out.println("Clicked on the portfolio summary option.");

				// scroll down the screen
				JavascriptExecutor js = (JavascriptExecutor) driver;
				WebElement inspectionOM = driver
						.findElement(By.xpath(OR.getProperty("portfoliosummary_inspection2_XPATH")));
				js.executeScript("arguments[0].scrollIntoView(true);", inspectionOM);
				js.executeScript("window.scrollBy(0,-200)");

				// VERIFY INSPECTION DETAILS IN THE PORTFOLIO SUMMARY DASHBOARD SCREEN

				System.out.println(
						"******************** VERIFY INSPECTION DETAILS IN THE PORTFOLIO SUMMARY DASHBOARD SCREEN ********************");
				test.log(LogStatus.INFO,
						"******************** VERIFY INSPECTION DETAILS IN THE PORTFOLIO SUMMARY DASHBOARD SCREEN ********************");
				Reporter.log(
						"******************** VERIFY INSPECTION DETAILS IN THE PORTFOLIO SUMMARY DASHBOARD SCREEN ********************");
				log.info(
						"******************** VERIFY INSPECTION DETAILS IN THE PORTFOLIO SUMMARY DASHBOARD SCREEN ********************");

				try {
					String property7String = (driver
							.findElement(By.cssSelector(OR.getProperty("portfoliosummary_inspection2_property_CSS")))
							.getText()).trim();

					int property7 = Integer.parseInt(property7String);

					if (property == (property7 + 1)) {

						System.out.println("The property count of the inspection is displayed correctly.");
						test.log(LogStatus.INFO, "The property count of the inspection is displayed correctly.");
						Reporter.log("The property count of the inspection is displayed correctly.");
						log.info("The property count of the inspection is displayed correctly.");
					} else {
						TestUtil.captureScreenshot();

						// ReportNG
						Reporter.log(
								"<br>" + " The property count of the inspection is displayed incorrectly. : " + "<br>");
						Reporter.log("<a target=\"_blank\" href=" + TestUtil.screenshotName + "><img src="
								+ TestUtil.screenshotName + " height=200 width=200></img></a>");
						Reporter.log("<br>");
						Reporter.log("<br>");

						// Extent Report
						test.log(LogStatus.FAIL, " The property count of the inspection is displayed incorrectly. : ");
						test.log(LogStatus.FAIL, test.addScreenCapture(TestUtil.screenshotName));

						System.out.println("The property count of the inspection is displayed incorrectly.");
						log.info("The property count of the inspection is displayed incorrectly.");
					}

				} catch (Throwable t) {
					TestUtil.captureScreenshot();

					// ReportNG
					Reporter.log(
							"<br>" + " The property count of the inspection is displayed incorrectly. : " + "<br>");
					Reporter.log("<a target=\"_blank\" href=" + TestUtil.screenshotName + "><img src="
							+ TestUtil.screenshotName + " height=200 width=200></img></a>");
					Reporter.log("<br>");
					Reporter.log("<br>");

					// Extent Report
					test.log(LogStatus.FAIL, " The property count of the inspection is displayed incorrectly. : ");
					test.log(LogStatus.FAIL, test.addScreenCapture(TestUtil.screenshotName));

					System.out.println("The property count of the inspection is displayed incorrectly.");
					log.info("The property count of the inspection is displayed incorrectly.");
				}

				// VERIFY COUNT OF THE ACTIVE TASKS AFTER THE INSPECTION MAKE IN PROGRESS

				try {
					String task7String = (driver
							.findElement(By.cssSelector(OR.getProperty("portfoliosummary_inspection2_task_CSS")))
							.getText()).trim();

					int task7 = Integer.parseInt(task7String);

					if (task == (task7)) {

						System.out.println("The active task count of the inspection is displayed correctly.");
						test.log(LogStatus.INFO, "The active task count of the inspection is displayed correctly.");
						Reporter.log("The active task count of the inspection is displayed correctly.");
						log.info("The active task count of the inspection is displayed correctly.");

					} else {
						TestUtil.captureScreenshot();

						// ReportNG
						Reporter.log("<br>" + " The active task count of the inspection is displayed incorrectly. : "
								+ "<br>");
						Reporter.log("<a target=\"_blank\" href=" + TestUtil.screenshotName + "><img src="
								+ TestUtil.screenshotName + " height=200 width=200></img></a>");
						Reporter.log("<br>");
						Reporter.log("<br>");

						// Extent Report
						test.log(LogStatus.FAIL,
								" The active task count of the inspection is displayed incorrectly. : ");
						test.log(LogStatus.FAIL, test.addScreenCapture(TestUtil.screenshotName));

						System.out.println("The active task count of the inspection is displayed incorrectly.");
						log.info("The active task count of the inspection is displayed incorrectly.");
					}

				} catch (Throwable t) {
					TestUtil.captureScreenshot();

					// ReportNG
					Reporter.log(
							"<br>" + " The active task count of the inspection is displayed incorrectly. : " + "<br>");
					Reporter.log("<a target=\"_blank\" href=" + TestUtil.screenshotName + "><img src="
							+ TestUtil.screenshotName + " height=200 width=200></img></a>");
					Reporter.log("<br>");
					Reporter.log("<br>");

					// Extent Report
					test.log(LogStatus.FAIL, " The active task count of the inspection is displayed incorrectly. : ");
					test.log(LogStatus.FAIL, test.addScreenCapture(TestUtil.screenshotName));

					System.out.println("The active task count of the inspection is displayed incorrectly.");
					log.info("The active task count of the inspection is displayed incorrectly.");
				}

				// VERIFY INSPECTION DETAILS IN THE INSPECTION LIST SCREEN

				System.out.println(
						"******************** VERIFY INSPECTION DETAILS IN THE INSPECTION LIST SCREEN ********************");
				test.log(LogStatus.INFO,
						"******************** VERIFY INSPECTION DETAILS IN THE INSPECTION LIST SCREEN ********************");
				Reporter.log(
						"******************** VERIFY INSPECTION DETAILS IN THE INSPECTION LIST SCREEN ********************");
				log.info(
						"******************** VERIFY INSPECTION DETAILS IN THE INSPECTION LIST SCREEN ********************");

				// click on the property count
				click("portfoliosummary_inspection2_property_CSS");
				ngDriver.waitForAngularRequestsToFinish();
				System.out.println("Clicked on the property count.");

				// VERIFY THE OPEN TASK COUNT

				try {

					String openTask7String = (driver
							.findElement(
									By.xpath(OR.getProperty("portfoliosummary_inspection2_inspectionlist_task_XPATH")))
							.getText()).trim();

					int openTask7 = Integer.parseInt(openTask7String);

					if (openTask == (openTask7)) {

						System.out.println("The open task count of the inspection is displayed correctly.");
						test.log(LogStatus.INFO, "The open task count of the inspection is displayed correctly.");
						Reporter.log("The open task count of the inspection is displayed correctly.");
						log.info("The open task count of the inspection is displayed correctly.");

					} else {
						TestUtil.captureScreenshot();

						// ReportNG
						Reporter.log("<br>" + " The open task count of the inspection is displayed incorrectly. : "
								+ "<br>");
						Reporter.log("<a target=\"_blank\" href=" + TestUtil.screenshotName + "><img src="
								+ TestUtil.screenshotName + " height=200 width=200></img></a>");
						Reporter.log("<br>");
						Reporter.log("<br>");

						// Extent Report
						test.log(LogStatus.FAIL, " The open task count of the inspection is displayed incorrectly. : ");
						test.log(LogStatus.FAIL, test.addScreenCapture(TestUtil.screenshotName));

						System.out.println("The open task count of the inspection is displayed incorrectly.");
						log.info("The open task count of the inspection is displayed incorrectly.");
					}

				} catch (Throwable t) {
					TestUtil.captureScreenshot();

					// ReportNG
					Reporter.log(
							"<br>" + " The open task count of the inspection is displayed incorrectly. : " + "<br>");
					Reporter.log("<a target=\"_blank\" href=" + TestUtil.screenshotName + "><img src="
							+ TestUtil.screenshotName + " height=200 width=200></img></a>");
					Reporter.log("<br>");
					Reporter.log("<br>");

					// Extent Report
					test.log(LogStatus.FAIL, " The open task count of the inspection is displayed incorrectly. : ");
					test.log(LogStatus.FAIL, test.addScreenCapture(TestUtil.screenshotName));

					System.out.println("The open task count of the inspection is displayed incorrectly.");
					log.info("The open task count of the inspection is displayed incorrectly.");
				}

				// click on the fourth circle
				click("portfoliosummary_inspection2_inspectionlist_circle_XPATH");
				ngDriver.waitForAngularRequestsToFinish();
				System.out.println("Clicked on the fourth circle.");

				// VERIFY INSPECTION DETAILS IN THE CREATE CHECKLIST LIST SCREEN

				System.out.println(
						"******************** VERIFY INSPECTION DETAILS IN THE CREATE CHECKLIST LIST SCREEN ********************");
				test.log(LogStatus.INFO,
						"******************** VERIFY INSPECTION DETAILS IN THE CREATE CHECKLIST LIST SCREEN ********************");
				Reporter.log(
						"******************** VERIFY INSPECTION DETAILS IN THE CREATE CHECKLIST LIST SCREEN ********************");
				log.info(
						"******************** VERIFY INSPECTION DETAILS IN THE CREATE CHECKLIST LIST SCREEN ********************");

				// enter the inspection name in the search field
				type("task_listofchecklist_filterfield_CSS", data.get("checklist_property_title"));
				ngDriver.waitForAngularRequestsToFinish();
				System.out.println("Entered the inspection name in the search field.");

				// VERIFY NEWLY CREATED INSPECTION IS DISPLAYED OR NOT

				try {
					String inspectionName = driver
							.findElement(By.xpath(OR.getProperty("inspection_createdinspection5_XPATH"))).getText();

					if (inspectionName.equals("Test Questionnaire Property Title Smoke Capreit Five")) {
						System.out.println("The inspection is displayed correctly.");
						test.log(LogStatus.INFO, "The inspection is displayed correctly.");
						Reporter.log("The inspection is displayed correctly.");
						log.info("The inspection is displayed correctly.");
					} else {
						TestUtil.captureScreenshot();

						// ReportNG
						Reporter.log("<br>" + " The inspection is not displayed. : " + "<br>");
						Reporter.log("<a target=\"_blank\" href=" + TestUtil.screenshotName + "><img src="
								+ TestUtil.screenshotName + " height=200 width=200></img></a>");
						Reporter.log("<br>");
						Reporter.log("<br>");

						// Extent Report
						test.log(LogStatus.FAIL, " The inspection is not displayed. : ");
						test.log(LogStatus.FAIL, test.addScreenCapture(TestUtil.screenshotName));

						System.out.println("The inspection is not displayed.");
						log.info("The inspection is not displayed.");
					}

				} catch (Throwable t) {
					TestUtil.captureScreenshot();

					// ReportNG
					Reporter.log("<br>" + " The inspection is not displayed. : " + "<br>");
					Reporter.log("<a target=\"_blank\" href=" + TestUtil.screenshotName + "><img src="
							+ TestUtil.screenshotName + " height=200 width=200></img></a>");
					Reporter.log("<br>");
					Reporter.log("<br>");

					// Extent Report
					test.log(LogStatus.FAIL, " The inspection is not displayed. : ");
					test.log(LogStatus.FAIL, test.addScreenCapture(TestUtil.screenshotName));

					System.out.println("The inspection is not displayed.");
					log.info("The inspection is not displayed.");
				}

				// VERIFY COMPLETION OF THE INSPECTION

				try {

					String inspectionCompletion = driver
							.findElement(By.xpath(
									OR.getProperty("portfoliosummary_inspection2_inspectionlist_completion_XPATH")))
							.getText();

					if (inspectionCompletion.equals("100%")) {
						System.out.println("The completion percentage of the inspection is displayed correctly.");
						test.log(LogStatus.INFO, "The completion percentage of the inspection is displayed correctly.");
						Reporter.log("The completion percentage of the inspection is displayed correctly.");
						log.info("The completion percentage of the inspection is displayed correctly.");
					} else {
						TestUtil.captureScreenshot();

						// ReportNG
						Reporter.log("<br>"
								+ " The completion percentage of the inspection is displayed incorrectly. : " + "<br>");
						Reporter.log("<a target=\"_blank\" href=" + TestUtil.screenshotName + "><img src="
								+ TestUtil.screenshotName + " height=200 width=200></img></a>");
						Reporter.log("<br>");
						Reporter.log("<br>");

						// Extent Report
						test.log(LogStatus.FAIL,
								" The completion percentage of the inspection is displayed incorrectly. : ");
						test.log(LogStatus.FAIL, test.addScreenCapture(TestUtil.screenshotName));

						System.out.println("The completion percentage of the inspection is displayed incorrectly.");
						log.info("The completion percentage of the inspection is displayed incorrectly.");
					}

				} catch (Throwable t) {

					TestUtil.captureScreenshot();

					// ReportNG
					Reporter.log("<br>" + " The completion percentage of the inspection is displayed incorrectly. : "
							+ "<br>");
					Reporter.log("<a target=\"_blank\" href=" + TestUtil.screenshotName + "><img src="
							+ TestUtil.screenshotName + " height=200 width=200></img></a>");
					Reporter.log("<br>");
					Reporter.log("<br>");

					// Extent Report
					test.log(LogStatus.FAIL,
							" The completion percentage of the inspection is displayed incorrectly. : ");
					test.log(LogStatus.FAIL, test.addScreenCapture(TestUtil.screenshotName));

					System.out.println("The completion percentage of the inspection is displayed incorrectly.");
					log.info("The completion percentage of the inspection is displayed incorrectly.");
				}

				// VERIFY TOTAL TASK OF THE INSPECTION

				try {

					String inspectionTotalTaskString = driver
							.findElement(By.xpath(
									OR.getProperty("portfoliosummary_inspection2_inspectionlist_totaltask_XPATH")))
							.getText();

					int inspectionTotalTask = Integer.parseInt(inspectionTotalTaskString);

					if (task == (inspectionTotalTask - 2)) {

						System.out.println("The total task of the inspection is displayed correctly.");
						test.log(LogStatus.INFO, "The total task of the inspection is displayed correctly.");
						Reporter.log("The total task of the inspection is displayed correctly.");
						log.info("The total task of the inspection is displayed correctly.");
					} else {
						TestUtil.captureScreenshot();

						// ReportNG
						Reporter.log(
								"<br>" + " The total task of the inspection is displayed incorrectly. : " + "<br>");
						Reporter.log("<a target=\"_blank\" href=" + TestUtil.screenshotName + "><img src="
								+ TestUtil.screenshotName + " height=200 width=200></img></a>");
						Reporter.log("<br>");
						Reporter.log("<br>");

						// Extent Report
						test.log(LogStatus.FAIL, " The total task of the inspection is displayed incorrectly. : ");
						test.log(LogStatus.FAIL, test.addScreenCapture(TestUtil.screenshotName));

						System.out.println("The total task of the inspection is displayed incorrectly.");
						log.info("The total task of the inspection is displayed incorrectly.");
					}

				} catch (Throwable t) {

					TestUtil.captureScreenshot();

					// ReportNG
					Reporter.log("<br>" + " The total task of the inspection is displayed incorrectly. : " + "<br>");
					Reporter.log("<a target=\"_blank\" href=" + TestUtil.screenshotName + "><img src="
							+ TestUtil.screenshotName + " height=200 width=200></img></a>");
					Reporter.log("<br>");
					Reporter.log("<br>");

					// Extent Report
					test.log(LogStatus.FAIL, " The total task of the inspection is displayed incorrectly. : ");
					test.log(LogStatus.FAIL, test.addScreenCapture(TestUtil.screenshotName));

					System.out.println("The total task of the inspection is displayed incorrectly.");
					log.info("The total task of the inspection is displayed incorrectly.");
				}

				// VERIFY OPEN TASK OF THE INSPECTION

				try {

					String inspectionCompletionString = driver
							.findElement(By.xpath(
									OR.getProperty("portfoliosummary_inspection2_inspectionlist_opentask_XPATH")))
							.getText();

					int inspectionCompletion = Integer.parseInt(inspectionCompletionString);

					if (openTask == (inspectionCompletion)) {

						System.out.println("The open task of the inspection is displayed correctly.");
						test.log(LogStatus.INFO, "The open task of the inspection is displayed correctly.");
						Reporter.log("The open task of the inspection is displayed correctly.");
						log.info("The open task of the inspection is displayed correctly.");
					} else {
						TestUtil.captureScreenshot();

						// ReportNG
						Reporter.log("<br>" + " The open task of the inspection is displayed incorrectly. : " + "<br>");
						Reporter.log("<a target=\"_blank\" href=" + TestUtil.screenshotName + "><img src="
								+ TestUtil.screenshotName + " height=200 width=200></img></a>");
						Reporter.log("<br>");
						Reporter.log("<br>");

						// Extent Report
						test.log(LogStatus.FAIL, " The open task of the inspection is displayed incorrectly. : ");
						test.log(LogStatus.FAIL, test.addScreenCapture(TestUtil.screenshotName));

						System.out.println("The open task of the inspection is displayed incorrectly.");
						log.info("The open task of the inspection is displayed incorrectly.");
					}

				} catch (Throwable t) {

					TestUtil.captureScreenshot();

					// ReportNG
					Reporter.log("<br>" + " The open task of the inspection is displayed incorrectly. : " + "<br>");
					Reporter.log("<a target=\"_blank\" href=" + TestUtil.screenshotName + "><img src="
							+ TestUtil.screenshotName + " height=200 width=200></img></a>");
					Reporter.log("<br>");
					Reporter.log("<br>");

					// Extent Report
					test.log(LogStatus.FAIL, " The open task of the inspection is displayed incorrectly. : ");
					test.log(LogStatus.FAIL, test.addScreenCapture(TestUtil.screenshotName));

					System.out.println("The open task of the inspection is displayed incorrectly.");
					log.info("The open task of the inspection is displayed incorrectly.");
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

			// DELETE THE BOTH CLOSED TASK

			System.out.println("**************** DELETE THE BOTH CLOSED TASK ****************");
			test.log(LogStatus.INFO, "**************** DELETE THE BOTH CLOSED TASK ****************");
			Reporter.log("**************** DELETE THE BOTH CLOSED TASK ****************");
			log.info("**************** DELETE THE BOTH CLOSED TASK ****************");

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

				// select the approved option from the status dropdown
				select("checklist_statusdd_CSS", data.get("status_dd"));
				ngDriver.waitForAngularRequestsToFinish();
				System.out.println("Selected the approved option from the status dropdown.");

				// enter newly created inspection in the search field
				clear("task_listofchecklist_filterfield_CSS");
				ngDriver.waitForAngularRequestsToFinish();
				System.out.println("Cleared the search field.");
				type("task_listofchecklist_filterfield_CSS", data.get("checklist_property_title"));
				ngDriver.waitForAngularRequestsToFinish();
				System.out.println("Entered newly created inspection in the search field.");

				// click on the searched inspection
				click("inspection_createdinspection5_XPATH");
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

				// click on the action icon of the approved task
				click("task_autotask1_actionicon_report3_XPATH");
				ngDriver.waitForAngularRequestsToFinish();
				System.out.println("Clicked on the action icon of the approved task.");

				// click on the reopen option
				click("task_autotask_actionicon_reopenoption_report3_XPATH");
				ngDriver.waitForAngularRequestsToFinish();
				System.out.println("Clicked on the reopen option.");

				// wait for the element
				explicitWaitClickable("closetoastmsg_CSS");

				// click on the toaster close button
				click("closetoastmsg_CSS");
				ngDriver.waitForAngularRequestsToFinish();
				System.out.println("Clicked on the toaster close button.");

				// click on the action icon of the approved task
				click("task_autotask1_actionicon_report3_XPATH");
				ngDriver.waitForAngularRequestsToFinish();
				System.out.println("Clicked on the action icon of the approved task.");

				// click on the delete button
				click("task_autotask_actionicon_deleteoption_report3_XPATH");
				ngDriver.waitForAngularRequestsToFinish();
				System.out.println("Clicked on the delete button.");

				// wait for the element
				explicitWaitClickable("closetoastmsg_CSS");

				// click on the toaster close button
				click("closetoastmsg_CSS");
				ngDriver.waitForAngularRequestsToFinish();
				System.out.println("Clicked on the toaster close button.");

				// click on the action icon of the task
				click("task_addtask_actionicon_XPATH");
				ngDriver.waitForAngularRequestsToFinish();
				System.out.println("Clicked on the action icon of the approved task.");

				// click on the reopen option
				click("task_addtask_approvedlbl_actionicon_reopenoption_XPATH");
				ngDriver.waitForAngularRequestsToFinish();
				System.out.println("Clicked on the reopen option.");

				// wait for the element
				explicitWaitClickable("closetoastmsg_CSS");

				// click on the toaster close button
				click("closetoastmsg_CSS");
				ngDriver.waitForAngularRequestsToFinish();
				System.out.println("Clicked on the toaster close button.");

				// click on the action icon of the approved task
				click("task_addtask_actionicon_XPATH");
				ngDriver.waitForAngularRequestsToFinish();
				System.out.println("Clicked on the action icon of the approved task.");

				// click on the delete button
				click("task_addtask_approvedlbl_actionicon_deleteoption1_XPATH");
				ngDriver.waitForAngularRequestsToFinish();
				System.out.println("Clicked on the delete button.");

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

			// VERIFY THE INSPECTION WITH DELETED BOTH TASKS IN PORTFOLIO SUMMARY
			// DASHBOARD

			System.out.println(
					"******************** VERIFY THE INSPECTION WITH DELETED BOTH TASKS IN PORTFOLIO SUMMARY DASHBOARD ********************");
			test.log(LogStatus.INFO,
					"******************** VERIFY THE INSPECTION WITH DELETED BOTH TASKS IN PORTFOLIO SUMMARY DASHBOARD ********************");
			Reporter.log(
					"******************** VERIFY THE INSPECTION WITH DELETED BOTH TASKS IN PORTFOLIO SUMMARY DASHBOARD ********************");
			log.info(
					"******************** VERIFY THE INSPECTION WITH DELETED BOTH TASKS IN PORTFOLIO SUMMARY DASHBOARD ********************");

			try {

				// wait for the element
				Thread.sleep(5000);

				// click on the side menu
				click("menubtn_CSS");
				ngDriver.waitForAngularRequestsToFinish();
				System.out.println("Clicked on the side menu.");

				// wait for the element
				Thread.sleep(5000);

				// click on the portfolio summary option
				click("sidemenu_portfoliosummary_XPATH");
				ngDriver.waitForAngularRequestsToFinish();
				System.out.println("Clicked on the portfolio summary option.");

				// scroll down the screen
				JavascriptExecutor js = (JavascriptExecutor) driver;
				WebElement inspectionOM = driver
						.findElement(By.xpath(OR.getProperty("portfoliosummary_inspection2_XPATH")));
				js.executeScript("arguments[0].scrollIntoView(true);", inspectionOM);
				js.executeScript("window.scrollBy(0,-200)");

				// VERIFY INSPECTION DETAILS IN THE PORTFOLIO SUMMARY DASHBOARD SCREEN

				System.out.println(
						"******************** VERIFY INSPECTION DETAILS IN THE PORTFOLIO SUMMARY DASHBOARD SCREEN ********************");
				test.log(LogStatus.INFO,
						"******************** VERIFY INSPECTION DETAILS IN THE PORTFOLIO SUMMARY DASHBOARD SCREEN ********************");
				Reporter.log(
						"******************** VERIFY INSPECTION DETAILS IN THE PORTFOLIO SUMMARY DASHBOARD SCREEN ********************");
				log.info(
						"******************** VERIFY INSPECTION DETAILS IN THE PORTFOLIO SUMMARY DASHBOARD SCREEN ********************");

				try {
					String property8String = (driver
							.findElement(By.cssSelector(OR.getProperty("portfoliosummary_inspection2_property_CSS")))
							.getText()).trim();

					int property8 = Integer.parseInt(property8String);

					if (property == (property8 + 1)) {

						System.out.println("The property count of the inspection is displayed correctly.");
						test.log(LogStatus.INFO, "The property count of the inspection is displayed correctly.");
						Reporter.log("The property count of the inspection is displayed correctly.");
						log.info("The property count of the inspection is displayed correctly.");
					} else {
						TestUtil.captureScreenshot();

						// ReportNG
						Reporter.log(
								"<br>" + " The property count of the inspection is displayed incorrectly. : " + "<br>");
						Reporter.log("<a target=\"_blank\" href=" + TestUtil.screenshotName + "><img src="
								+ TestUtil.screenshotName + " height=200 width=200></img></a>");
						Reporter.log("<br>");
						Reporter.log("<br>");

						// Extent Report
						test.log(LogStatus.FAIL, " The property count of the inspection is displayed incorrectly. : ");
						test.log(LogStatus.FAIL, test.addScreenCapture(TestUtil.screenshotName));

						System.out.println("The property count of the inspection is displayed incorrectly.");
						log.info("The property count of the inspection is displayed incorrectly.");
					}

				} catch (Throwable t) {
					TestUtil.captureScreenshot();

					// ReportNG
					Reporter.log(
							"<br>" + " The property count of the inspection is displayed incorrectly. : " + "<br>");
					Reporter.log("<a target=\"_blank\" href=" + TestUtil.screenshotName + "><img src="
							+ TestUtil.screenshotName + " height=200 width=200></img></a>");
					Reporter.log("<br>");
					Reporter.log("<br>");

					// Extent Report
					test.log(LogStatus.FAIL, " The property count of the inspection is displayed incorrectly. : ");
					test.log(LogStatus.FAIL, test.addScreenCapture(TestUtil.screenshotName));

					System.out.println("The property count of the inspection is displayed incorrectly.");
					log.info("The property count of the inspection is displayed incorrectly.");
				}

				// VERIFY COUNT OF THE ACTIVE TASKS AFTER THE INSPECTION MAKE IN PROGRESS

				try {
					String task8String = (driver
							.findElement(By.cssSelector(OR.getProperty("portfoliosummary_inspection2_task_CSS")))
							.getText()).trim();

					int task8 = Integer.parseInt(task8String);

					if (task == (task8)) {

						System.out.println("The active task count of the inspection is displayed correctly.");
						test.log(LogStatus.INFO, "The active task count of the inspection is displayed correctly.");
						Reporter.log("The active task count of the inspection is displayed correctly.");
						log.info("The active task count of the inspection is displayed correctly.");

					} else {
						TestUtil.captureScreenshot();

						// ReportNG
						Reporter.log("<br>" + " The active task count of the inspection is displayed incorrectly. : "
								+ "<br>");
						Reporter.log("<a target=\"_blank\" href=" + TestUtil.screenshotName + "><img src="
								+ TestUtil.screenshotName + " height=200 width=200></img></a>");
						Reporter.log("<br>");
						Reporter.log("<br>");

						// Extent Report
						test.log(LogStatus.FAIL,
								" The active task count of the inspection is displayed incorrectly. : ");
						test.log(LogStatus.FAIL, test.addScreenCapture(TestUtil.screenshotName));

						System.out.println("The active task count of the inspection is displayed incorrectly.");
						log.info("The active task count of the inspection is displayed incorrectly.");
					}

				} catch (Throwable t) {
					TestUtil.captureScreenshot();

					// ReportNG
					Reporter.log(
							"<br>" + " The active task count of the inspection is displayed incorrectly. : " + "<br>");
					Reporter.log("<a target=\"_blank\" href=" + TestUtil.screenshotName + "><img src="
							+ TestUtil.screenshotName + " height=200 width=200></img></a>");
					Reporter.log("<br>");
					Reporter.log("<br>");

					// Extent Report
					test.log(LogStatus.FAIL, " The active task count of the inspection is displayed incorrectly. : ");
					test.log(LogStatus.FAIL, test.addScreenCapture(TestUtil.screenshotName));

					System.out.println("The active task count of the inspection is displayed incorrectly.");
					log.info("The active task count of the inspection is displayed incorrectly.");
				}

				// VERIFY INSPECTION DETAILS IN THE INSPECTION LIST SCREEN

				System.out.println(
						"******************** VERIFY INSPECTION DETAILS IN THE INSPECTION LIST SCREEN ********************");
				test.log(LogStatus.INFO,
						"******************** VERIFY INSPECTION DETAILS IN THE INSPECTION LIST SCREEN ********************");
				Reporter.log(
						"******************** VERIFY INSPECTION DETAILS IN THE INSPECTION LIST SCREEN ********************");
				log.info(
						"******************** VERIFY INSPECTION DETAILS IN THE INSPECTION LIST SCREEN ********************");

				// click on the property count
				click("portfoliosummary_inspection2_property_CSS");
				ngDriver.waitForAngularRequestsToFinish();
				System.out.println("Clicked on the property count.");

				// VERIFY THE OPEN TASK COUNT

				try {

					String openTask8String = (driver
							.findElement(
									By.xpath(OR.getProperty("portfoliosummary_inspection2_inspectionlist_task_XPATH")))
							.getText()).trim();

					int openTask8 = Integer.parseInt(openTask8String);

					if (openTask == (openTask8)) {

						System.out.println("The open task count of the inspection is displayed correctly.");
						test.log(LogStatus.INFO, "The open task count of the inspection is displayed correctly.");
						Reporter.log("The open task count of the inspection is displayed correctly.");
						log.info("The open task count of the inspection is displayed correctly.");

					} else {
						TestUtil.captureScreenshot();

						// ReportNG
						Reporter.log("<br>" + " The open task count of the inspection is displayed incorrectly. : "
								+ "<br>");
						Reporter.log("<a target=\"_blank\" href=" + TestUtil.screenshotName + "><img src="
								+ TestUtil.screenshotName + " height=200 width=200></img></a>");
						Reporter.log("<br>");
						Reporter.log("<br>");

						// Extent Report
						test.log(LogStatus.FAIL, " The open task count of the inspection is displayed incorrectly. : ");
						test.log(LogStatus.FAIL, test.addScreenCapture(TestUtil.screenshotName));

						System.out.println("The open task count of the inspection is displayed incorrectly.");
						log.info("The open task count of the inspection is displayed incorrectly.");
					}

				} catch (Throwable t) {
					TestUtil.captureScreenshot();

					// ReportNG
					Reporter.log(
							"<br>" + " The open task count of the inspection is displayed incorrectly. : " + "<br>");
					Reporter.log("<a target=\"_blank\" href=" + TestUtil.screenshotName + "><img src="
							+ TestUtil.screenshotName + " height=200 width=200></img></a>");
					Reporter.log("<br>");
					Reporter.log("<br>");

					// Extent Report
					test.log(LogStatus.FAIL, " The open task count of the inspection is displayed incorrectly. : ");
					test.log(LogStatus.FAIL, test.addScreenCapture(TestUtil.screenshotName));

					System.out.println("The open task count of the inspection is displayed incorrectly.");
					log.info("The open task count of the inspection is displayed incorrectly.");
				}

				// click on the fourth circle
				click("portfoliosummary_inspection2_inspectionlist_circle_XPATH");
				ngDriver.waitForAngularRequestsToFinish();
				System.out.println("Clicked on the fourth circle.");

				// VERIFY INSPECTION DETAILS IN THE CREATE CHECKLIST LIST SCREEN

				System.out.println(
						"******************** VERIFY INSPECTION DETAILS IN THE CREATE CHECKLIST LIST SCREEN ********************");
				test.log(LogStatus.INFO,
						"******************** VERIFY INSPECTION DETAILS IN THE CREATE CHECKLIST LIST SCREEN ********************");
				Reporter.log(
						"******************** VERIFY INSPECTION DETAILS IN THE CREATE CHECKLIST LIST SCREEN ********************");
				log.info(
						"******************** VERIFY INSPECTION DETAILS IN THE CREATE CHECKLIST LIST SCREEN ********************");

				// enter the inspection name in the search field
				type("task_listofchecklist_filterfield_CSS", data.get("checklist_property_title"));
				ngDriver.waitForAngularRequestsToFinish();
				System.out.println("Entered the inspection name in the search field.");

				// VERIFY NEWLY CREATED INSPECTION IS DISPLAYED OR NOT

				try {
					String inspectionName = driver
							.findElement(By.xpath(OR.getProperty("inspection_createdinspection5_XPATH"))).getText();

					if (inspectionName.equals("Test Questionnaire Property Title Smoke Capreit Five")) {
						System.out.println("The inspection is displayed correctly.");
						test.log(LogStatus.INFO, "The inspection is displayed correctly.");
						Reporter.log("The inspection is displayed correctly.");
						log.info("The inspection is displayed correctly.");
					} else {
						TestUtil.captureScreenshot();

						// ReportNG
						Reporter.log("<br>" + " The inspection is not displayed. : " + "<br>");
						Reporter.log("<a target=\"_blank\" href=" + TestUtil.screenshotName + "><img src="
								+ TestUtil.screenshotName + " height=200 width=200></img></a>");
						Reporter.log("<br>");
						Reporter.log("<br>");

						// Extent Report
						test.log(LogStatus.FAIL, " The inspection is not displayed. : ");
						test.log(LogStatus.FAIL, test.addScreenCapture(TestUtil.screenshotName));

						System.out.println("The inspection is not displayed.");
						log.info("The inspection is not displayed.");
					}

				} catch (Throwable t) {
					TestUtil.captureScreenshot();

					// ReportNG
					Reporter.log("<br>" + " The inspection is not displayed. : " + "<br>");
					Reporter.log("<a target=\"_blank\" href=" + TestUtil.screenshotName + "><img src="
							+ TestUtil.screenshotName + " height=200 width=200></img></a>");
					Reporter.log("<br>");
					Reporter.log("<br>");

					// Extent Report
					test.log(LogStatus.FAIL, " The inspection is not displayed. : ");
					test.log(LogStatus.FAIL, test.addScreenCapture(TestUtil.screenshotName));

					System.out.println("The inspection is not displayed.");
					log.info("The inspection is not displayed.");
				}

				// VERIFY COMPLETION OF THE INSPECTION

				try {

					String inspectionCompletion = driver
							.findElement(By.xpath(
									OR.getProperty("portfoliosummary_inspection2_inspectionlist_completion_XPATH")))
							.getText();

					if (inspectionCompletion.equals("100%")) {
						System.out.println("The completion percentage of the inspection is displayed correctly.");
						test.log(LogStatus.INFO, "The completion percentage of the inspection is displayed correctly.");
						Reporter.log("The completion percentage of the inspection is displayed correctly.");
						log.info("The completion percentage of the inspection is displayed correctly.");
					} else {
						TestUtil.captureScreenshot();

						// ReportNG
						Reporter.log("<br>"
								+ " The completion percentage of the inspection is displayed incorrectly. : " + "<br>");
						Reporter.log("<a target=\"_blank\" href=" + TestUtil.screenshotName + "><img src="
								+ TestUtil.screenshotName + " height=200 width=200></img></a>");
						Reporter.log("<br>");
						Reporter.log("<br>");

						// Extent Report
						test.log(LogStatus.FAIL,
								" The completion percentage of the inspection is displayed incorrectly. : ");
						test.log(LogStatus.FAIL, test.addScreenCapture(TestUtil.screenshotName));

						System.out.println("The completion percentage of the inspection is displayed incorrectly.");
						log.info("The completion percentage of the inspection is displayed incorrectly.");
					}

				} catch (Throwable t) {

					TestUtil.captureScreenshot();

					// ReportNG
					Reporter.log("<br>" + " The completion percentage of the inspection is displayed incorrectly. : "
							+ "<br>");
					Reporter.log("<a target=\"_blank\" href=" + TestUtil.screenshotName + "><img src="
							+ TestUtil.screenshotName + " height=200 width=200></img></a>");
					Reporter.log("<br>");
					Reporter.log("<br>");

					// Extent Report
					test.log(LogStatus.FAIL,
							" The completion percentage of the inspection is displayed incorrectly. : ");
					test.log(LogStatus.FAIL, test.addScreenCapture(TestUtil.screenshotName));

					System.out.println("The completion percentage of the inspection is displayed incorrectly.");
					log.info("The completion percentage of the inspection is displayed incorrectly.");
				}

				// VERIFY TOTAL TASK OF THE INSPECTION

				try {

					String inspectionTotalTaskString = driver
							.findElement(By.xpath(
									OR.getProperty("portfoliosummary_inspection2_inspectionlist_totaltask_XPATH")))
							.getText();

					int inspectionTotalTask = Integer.parseInt(inspectionTotalTaskString);

					if (task == (inspectionTotalTask)) {

						System.out.println("The total task of the inspection is displayed correctly.");
						test.log(LogStatus.INFO, "The total task of the inspection is displayed correctly.");
						Reporter.log("The total task of the inspection is displayed correctly.");
						log.info("The total task of the inspection is displayed correctly.");
					} else {
						TestUtil.captureScreenshot();

						// ReportNG
						Reporter.log(
								"<br>" + " The total task of the inspection is displayed incorrectly. : " + "<br>");
						Reporter.log("<a target=\"_blank\" href=" + TestUtil.screenshotName + "><img src="
								+ TestUtil.screenshotName + " height=200 width=200></img></a>");
						Reporter.log("<br>");
						Reporter.log("<br>");

						// Extent Report
						test.log(LogStatus.FAIL, " The total task of the inspection is displayed incorrectly. : ");
						test.log(LogStatus.FAIL, test.addScreenCapture(TestUtil.screenshotName));

						System.out.println("The total task of the inspection is displayed incorrectly.");
						log.info("The total task of the inspection is displayed incorrectly.");
					}

				} catch (Throwable t) {

					TestUtil.captureScreenshot();

					// ReportNG
					Reporter.log("<br>" + " The total task of the inspection is displayed incorrectly. : " + "<br>");
					Reporter.log("<a target=\"_blank\" href=" + TestUtil.screenshotName + "><img src="
							+ TestUtil.screenshotName + " height=200 width=200></img></a>");
					Reporter.log("<br>");
					Reporter.log("<br>");

					// Extent Report
					test.log(LogStatus.FAIL, " The total task of the inspection is displayed incorrectly. : ");
					test.log(LogStatus.FAIL, test.addScreenCapture(TestUtil.screenshotName));

					System.out.println("The total task of the inspection is displayed incorrectly.");
					log.info("The total task of the inspection is displayed incorrectly.");
				}

				// VERIFY OPEN TASK OF THE INSPECTION

				try {

					String inspectionCompletionString = driver
							.findElement(By.xpath(
									OR.getProperty("portfoliosummary_inspection2_inspectionlist_opentask_XPATH")))
							.getText();

					int inspectionCompletion = Integer.parseInt(inspectionCompletionString);

					if (openTask == (inspectionCompletion)) {

						System.out.println("The open task of the inspection is displayed correctly.");
						test.log(LogStatus.INFO, "The open task of the inspection is displayed correctly.");
						Reporter.log("The open task of the inspection is displayed correctly.");
						log.info("The open task of the inspection is displayed correctly.");
					} else {
						TestUtil.captureScreenshot();

						// ReportNG
						Reporter.log("<br>" + " The open task of the inspection is displayed incorrectly. : " + "<br>");
						Reporter.log("<a target=\"_blank\" href=" + TestUtil.screenshotName + "><img src="
								+ TestUtil.screenshotName + " height=200 width=200></img></a>");
						Reporter.log("<br>");
						Reporter.log("<br>");

						// Extent Report
						test.log(LogStatus.FAIL, " The open task of the inspection is displayed incorrectly. : ");
						test.log(LogStatus.FAIL, test.addScreenCapture(TestUtil.screenshotName));

						System.out.println("The open task of the inspection is displayed incorrectly.");
						log.info("The open task of the inspection is displayed incorrectly.");
					}

				} catch (Throwable t) {

					TestUtil.captureScreenshot();

					// ReportNG
					Reporter.log("<br>" + " The open task of the inspection is displayed incorrectly. : " + "<br>");
					Reporter.log("<a target=\"_blank\" href=" + TestUtil.screenshotName + "><img src="
							+ TestUtil.screenshotName + " height=200 width=200></img></a>");
					Reporter.log("<br>");
					Reporter.log("<br>");

					// Extent Report
					test.log(LogStatus.FAIL, " The open task of the inspection is displayed incorrectly. : ");
					test.log(LogStatus.FAIL, test.addScreenCapture(TestUtil.screenshotName));

					System.out.println("The open task of the inspection is displayed incorrectly.");
					log.info("The open task of the inspection is displayed incorrectly.");
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

			// DELETE THE INSPECTION

			System.out.println("**************** DELETE THE INSPECTION ****************");
			test.log(LogStatus.INFO, "**************** DELETE THE INSPECTION ****************");
			Reporter.log("**************** DELETE THE INSPECTION ****************");
			log.info("**************** DELETE THE INSPECTION ****************");

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

				// select the approved option from the status dropdown
				select("checklist_statusdd_CSS", data.get("status_dd"));
				ngDriver.waitForAngularRequestsToFinish();
				System.out.println("Selected the approved option from the status dropdown.");

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

				// click on the reopen option
				click("checklist_wizard_reopenoption_CSS");
				ngDriver.waitForAngularRequestsToFinish();
				System.out.println("Clicked on the reopen option.");

				// click on the reopen button
				click("checklist_wizard_reopenbtn_CSS");
				ngDriver.waitForAngularRequestsToFinish();
				System.out.println("Clicked on the reopen button.");

				// wait for the element
				explicitWaitClickable("closetoastmsg_CSS");

				// click on the toaster close button
				click("closetoastmsg_CSS");
				ngDriver.waitForAngularRequestsToFinish();
				System.out.println("Clicked on the toaster close button.");

				// wait for 3 seconds
				Thread.sleep(3000);

				// select the open option from the status dropdown
				select("checklist_statusdd_CSS", data.get("status_dd_open"));
				ngDriver.waitForAngularRequestsToFinish();
				System.out.println("Selected the open option from the status dropdown.");

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

				// enter newly created inspection in the search field
				clear("task_listofchecklist_filterfield_CSS");
				ngDriver.waitForAngularRequestsToFinish();
				System.out.println("Cleared the search field.");
				type("task_listofchecklist_filterfield_CSS", data.get("checklist_property_title"));
				ngDriver.waitForAngularRequestsToFinish();
				System.out.println("Entered newly created inspection in the search field.");

				// verify deleted inspection is displayed or not
				deleteVerification("inspection_createdinspection5_XPATH",
						"Test Questionnaire Property Title Smoke Capreit Five");

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

			// VERIFY INSPECTION CARD ON THE PORTFOLIO SUMMARY DASHBOARD SCREEN AFTER DELETE
			// THE INSPECTION - OPERATION MANAGER

			System.out.println(
					"******************** VERIFY INSPECTION CARD ON THE PORTFOLIO SUMMARY DASHBOARD SCREEN AFTER DELETE THE INSPECTION - OPERATION MANAGER ********************");
			test.log(LogStatus.INFO,
					"******************** VERIFY INSPECTION CARD ON THE PORTFOLIO SUMMARY DASHBOARD SCREEN AFTER DELETE THE INSPECTION - OPERATION MANAGER ********************");
			Reporter.log(
					"******************** VERIFY INSPECTION CARD ON THE PORTFOLIO SUMMARY DASHBOARD SCREEN AFTER DELETE THE INSPECTION - OPERATION MANAGER ********************");
			log.info(
					"******************** VERIFY INSPECTION CARD ON THE PORTFOLIO SUMMARY DASHBOARD SCREEN AFTER DELETE THE INSPECTION - OPERATION MANAGER ********************");

			try {

				// wait for the element
				Thread.sleep(5000);

				// click on the side menu
				click("menubtn_CSS");
				ngDriver.waitForAngularRequestsToFinish();
				System.out.println("Clicked on the side menu.");

				// wait for the element
				Thread.sleep(5000);

				// click on the portfolio summary option
				click("sidemenu_portfoliosummary_XPATH");
				ngDriver.waitForAngularRequestsToFinish();
				System.out.println("Clicked on the portfolio summary option.");

				// scroll down the screen
				JavascriptExecutor js = (JavascriptExecutor) driver;
				WebElement inspectionOM = driver
						.findElement(By.xpath(OR.getProperty("portfoliosummary_inspection2_XPATH")));
				js.executeScript("arguments[0].scrollIntoView(true);", inspectionOM);
				js.executeScript("window.scrollBy(0,-200)");

				// VERIFY INSPECTION DETAILS IN THE PORTFOLIO SUMMARY DASHBOARD SCREEN

				System.out.println(
						"******************** VERIFY INSPECTION DETAILS IN THE PORTFOLIO SUMMARY DASHBOARD SCREEN ********************");
				test.log(LogStatus.INFO,
						"******************** VERIFY INSPECTION DETAILS IN THE PORTFOLIO SUMMARY DASHBOARD SCREEN ********************");
				Reporter.log(
						"******************** VERIFY INSPECTION DETAILS IN THE PORTFOLIO SUMMARY DASHBOARD SCREEN ********************");
				log.info(
						"******************** VERIFY INSPECTION DETAILS IN THE PORTFOLIO SUMMARY DASHBOARD SCREEN ********************");

				// VERIFY COUNT OF THE PROPERTY AFTER CREATED THE INSPECTION

				try {
					String property9String = (driver
							.findElement(By.cssSelector(OR.getProperty("portfoliosummary_inspection2_property_CSS")))
							.getText()).trim();

					int property9 = Integer.parseInt(property9String);

					if (property == (property9)) {
						System.out.println("The property count of the inspection is displayed correctly.");
						test.log(LogStatus.INFO, "The property count of the inspection is displayed correctly.");
						Reporter.log("The property count of the inspection is displayed correctly.");
						log.info("The property count of the inspection is displayed correctly.");
					} else {
						TestUtil.captureScreenshot();

						// ReportNG
						Reporter.log(
								"<br>" + " The property count of the inspection is displayed incorrectly. : " + "<br>");
						Reporter.log("<a target=\"_blank\" href=" + TestUtil.screenshotName + "><img src="
								+ TestUtil.screenshotName + " height=200 width=200></img></a>");
						Reporter.log("<br>");
						Reporter.log("<br>");

						// Extent Report
						test.log(LogStatus.FAIL, " The property count of the inspection is displayed incorrectly. : ");
						test.log(LogStatus.FAIL, test.addScreenCapture(TestUtil.screenshotName));

						System.out.println("The property count of the inspection is displayed incorrectly.");
						log.info("The property count of the inspection is displayed incorrectly.");
					}

				} catch (Throwable t) {
					TestUtil.captureScreenshot();

					// ReportNG
					Reporter.log(
							"<br>" + " The property count of the inspection is displayed incorrectly. : " + "<br>");
					Reporter.log("<a target=\"_blank\" href=" + TestUtil.screenshotName + "><img src="
							+ TestUtil.screenshotName + " height=200 width=200></img></a>");
					Reporter.log("<br>");
					Reporter.log("<br>");

					// Extent Report
					test.log(LogStatus.FAIL, " The property count of the inspection is displayed incorrectly. : ");
					test.log(LogStatus.FAIL, test.addScreenCapture(TestUtil.screenshotName));

					System.out.println("The property count of the inspection is displayed incorrectly.");
					log.info("The property count of the inspection is displayed incorrectly.");
				}

				// VERIFY COUNT OF THE ACTIVE TASKS AFTER CREATED THE INSPECTION

				try {
					String task9String = (driver
							.findElement(By.cssSelector(OR.getProperty("portfoliosummary_inspection2_task_CSS")))
							.getText()).trim();

					int task9 = Integer.parseInt(task9String);

					if (task == (task9)) {
						System.out.println("The active task count of the inspection is displayed correctly.");
						test.log(LogStatus.INFO, "The active task count of the inspection is displayed correctly.");
						Reporter.log("The active task count of the inspection is displayed correctly.");
						log.info("The active task count of the inspection is displayed correctly.");

					} else {
						TestUtil.captureScreenshot();

						// ReportNG
						Reporter.log("<br>" + " The active task count of the inspection is displayed incorrectly. : "
								+ "<br>");
						Reporter.log("<a target=\"_blank\" href=" + TestUtil.screenshotName + "><img src="
								+ TestUtil.screenshotName + " height=200 width=200></img></a>");
						Reporter.log("<br>");
						Reporter.log("<br>");

						// Extent Report
						test.log(LogStatus.FAIL,
								" The active task count of the inspection is displayed incorrectly. : ");
						test.log(LogStatus.FAIL, test.addScreenCapture(TestUtil.screenshotName));

						System.out.println("The active task count of the inspection is displayed incorrectly.");
						log.info("The active task count of the inspection is displayed incorrectly.");
					}

				} catch (Throwable t) {
					TestUtil.captureScreenshot();

					// ReportNG
					Reporter.log(
							"<br>" + " The active task count of the inspection is displayed incorrectly. : " + "<br>");
					Reporter.log("<a target=\"_blank\" href=" + TestUtil.screenshotName + "><img src="
							+ TestUtil.screenshotName + " height=200 width=200></img></a>");
					Reporter.log("<br>");
					Reporter.log("<br>");

					// Extent Report
					test.log(LogStatus.FAIL, " The active task count of the inspection is displayed incorrectly. : ");
					test.log(LogStatus.FAIL, test.addScreenCapture(TestUtil.screenshotName));

					System.out.println("The active task count of the inspection is displayed incorrectly.");
					log.info("The active task count of the inspection is displayed incorrectly.");
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
