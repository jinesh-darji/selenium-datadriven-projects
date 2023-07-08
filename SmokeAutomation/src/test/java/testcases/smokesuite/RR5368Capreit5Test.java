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

		execution(data, "rR5368Capreit5Test");

		Helper helper = new Helper();

		// refresh the page
		driver.navigate().refresh();
		Thread.sleep(5000);
		driver.navigate().refresh();

		int property = 0;
		int task = 0;
		int openTask = 0;

		// PORTFOLIO SUMMARY AND INSPECTIONS DASHBOARDS - OPERATION MANAGER
		title("PORTFOLIO SUMMARY AND INSPECTIONS DASHBOARDS - OPERATION MANAGER");

		try {

			try {
				// LOGIN WITH OPERATION MANAGER USER
				title("LOGIN WITH OPERATION MANAGER USER");

				// wait for the element
				explicitWaitClickable("signinbtn_BTNTEXT");

				// Enter the username
				type("usernametxt_CSS", data.get("username"));

				// Enter the password
				type("passwordtxt_CSS", data.get("password"));

				// Clicking on the "Sign In" button
				click("signinbtn_BTNTEXT");

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
			title("VERIFY INSPECTION CARD ON THE PORTFOLIO SUMMARY DASHBOARD SCREEN WITHOUT ADDING THE INSPECTION - OPERATION MANAGER");

			try {

				// wait for the element
				Thread.sleep(5000);

				// click on the side menu
				click("menubtn_CSS");

				// wait for the element
				Thread.sleep(5000);

				// click on the portfolio summary option
				click("sidemenu_portfoliosummary_XPATH");

				try {
					// scroll down the screen
					scrollTillElement("portfoliosummary_inspection2_XPATH");
					scrollByPixel(-200);

					String propertyString = (driver
							.findElement(By.cssSelector(OR.getProperty("portfoliosummary_inspection2_property_CSS")))
							.getText()).trim();

					String taskString = (driver
							.findElement(By.cssSelector(OR.getProperty("portfoliosummary_inspection2_task_CSS")))
							.getText()).trim();

					property = Integer.parseInt(propertyString);
					task = Integer.parseInt(taskString);

					successMessage("THE RESPECTIVE INSPECTION IS DISPLAYED AS EXPECTED.");

				} catch (Throwable t) {
					verificationFailedMessage(
							"The inspection is not displayed in the portfolio summary screen without adding inspection.");
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

			// CREATE THE NEW INSPECTION AND CHECKLIST - OPERATION MANAGER
			title("CREATE THE NEW INSPECTION AND CHECKLIST - OPERATION MANAGER");

			try {

				// enter the property name in the search field
				type("envreports_propertylist_filtertxt_CSS", data.get("property_1"));

				// click on the environmental icon from the property list page
				click("environmentalicon_CSS");

				// wait for the element
				Thread.sleep(5000);

				// click on the burger menu
				click("menubtn_CSS");

				// wait for the element
				Thread.sleep(5000);

				// click on the checklist/inspection option from side menu
				click("checklist_sidemenu_XPATH");

				// select building from the property drop down
				select("envreports_movereports_propertydd_CSS", data.get("building_leveldropdown"));

				// wait for 5 seconds
				Thread.sleep(5000);

				// click on the new checklist button
				click("checklist_newchecklistbtn_CSS");

				// wait for the element
				explicitWait("checklist_addchecklist_checklisttypedd_CSS");

				// select the questionnaire option from the checklist type dropdown
				select("checklist_addchecklist_checklisttypedd_CSS", data.get("questionnaire_checklist_title"));

				// enter data in the checklist title field
				type("checklist_addchecklist_titletxt_CSS", data.get("checklist_property_title"));

				// click on the save button
				click("checklist_addchecklist_savebtn_CSS");

				// verify questionnaire is selected correctly or not

				String covidtxt = driver
						.findElement(By.xpath(OR.getProperty("checklist_wizard_inspectiontitle5_XPATH"))).getText();

				consoleMessage("COVID 19 INSTECTION TITLE : " + covidtxt);

				switchVerification("checklist_wizard_inspectiontitle5_XPATH",
						"Test Questionnaire Property Title Smoke Capreit Five",
						"The Test Questionnaire Property Title Smoke Capreit Five is not displayed.");

			} catch (Throwable t) {
				verificationFailed();
			}

			// click on the home icon from the top of the screen
			click("questionnaire_homeburgermenubtn_hide_CSS");

			// synchronization
			explicitWait("propertylist_title_XPATH");

			// verify the property list
			switchVerification("propertylist_title_XPATH", "Property List", "The property list is not displayed.");

			// VERIFY THE NEWLY CREATED INSPECTION IN PORTFOLIO SUMMARY DASHBOARD
			title("VERIFY THE NEWLY CREATED INSPECTION IN PORTFOLIO SUMMARY DASHBOARD");

			try {

				// wait for the element
				Thread.sleep(5000);

				// click on the side menu
				click("menubtn_CSS");

				// wait for the element
				Thread.sleep(5000);

				// click on the portfolio summary option
				click("sidemenu_portfoliosummary_XPATH");

				// scroll down the screen
				scrollTillElement("portfoliosummary_inspection2_XPATH");
				scrollByPixel(-200);

				// VERIFY INSPECTION DETAILS IN THE PORTFOLIO SUMMARY DASHBOARD SCREEN
				title("VERIFY INSPECTION DETAILS IN THE PORTFOLIO SUMMARY DASHBOARD SCREEN");

				// VERIFY COUNT OF THE PROPERTY AFTER CREATED THE INSPECTION
				title("VERIFY COUNT OF THE PROPERTY AFTER CREATED THE INSPECTION");
				try {
					String property1String = (driver
							.findElement(By.cssSelector(OR.getProperty("portfoliosummary_inspection2_property_CSS")))
							.getText()).trim();

					int property1 = Integer.parseInt(property1String);

					if (property == (property1)) {
						successMessage("The property count of the inspection is displayed correctly.");
					} else {
						verificationFailedMessage("The property count of the inspection is displayed incorrectly.");
					}

				} catch (Throwable t) {
					verificationFailedMessage("The property count of the inspection is displayed incorrectly.");
				}

				// VERIFY COUNT OF THE ACTIVE TASKS AFTER CREATED THE INSPECTION
				title("VERIFY COUNT OF THE ACTIVE TASKS AFTER CREATED THE INSPECTION");

				try {
					String task1String = (driver
							.findElement(By.cssSelector(OR.getProperty("portfoliosummary_inspection2_task_CSS")))
							.getText()).trim();

					int task1 = Integer.parseInt(task1String);

					if (task == (task1)) {
						successMessage("The active task count of the inspection is displayed correctly.");
					} else {
						verificationFailedMessage("The active task count of the inspection is displayed incorrectly.");
					}

				} catch (Throwable t) {
					verificationFailedMessage("The active task count of the inspection is displayed incorrectly.");
				}

				// VERIFY INSPECTION DETAILS IN THE INSPECTION LIST SCREEN
				title("VERIFY INSPECTION DETAILS IN THE INSPECTION LIST SCREEN");

				// click on the property count
				click("portfoliosummary_inspection2_property_CSS");

				// VERIFY THE OPEN TASK COUNT
				try {

					String openTaskString = driver
							.findElement(
									By.xpath(OR.getProperty("portfoliosummary_inspection2_inspectionlist_task_XPATH")))
							.getText();

					openTask = Integer.parseInt(openTaskString);

					if (openTask == 0) {
						successMessage("The open task count of the inspection is displayed correctly.");

					} else {
						verificationFailedMessage("The open task count of the inspection is displayed incorrectly.");
					}

				} catch (Throwable t) {
					verificationFailedMessage("The open task count of the inspection is displayed incorrectly.");
				}

				// click on the fourth circle
				click("portfoliosummary_inspection2_inspectionlist_circle_XPATH");

				// VERIFY INSPECTION DETAILS IN THE CREATE CHECKLIST LIST SCREEN
				title("VERIFY INSPECTION DETAILS IN THE CREATE CHECKLIST LIST SCREEN");

				// enter the inspection name in the search field
				type("task_listofchecklist_filterfield_CSS", data.get("checklist_property_title"));

				// VERIFY NEWLY CREATED INSPECTION IS DISPLAYED OR NOT
				title("VERIFY NEWLY CREATED INSPECTION IS DISPLAYED OR NOT");

				try {
					String inspectionName = driver
							.findElement(By.xpath(OR.getProperty("inspection_createdinspection5_XPATH"))).getText();

					if (inspectionName.equals("Test Questionnaire Property Title Smoke Capreit Five")) {
						successMessage("The inspection is displayed correctly.");
					} else {
						verificationFailedMessage("The inspection is not displayed.");
					}

				} catch (Throwable t) {
					verificationFailedMessage("The inspection is not displayed.");
				}

				// VERIFY COMPLETION OF THE INSPECTION
				title("VERIFY COMPLETION OF THE INSPECTION");
				try {

					String inspectionCompletion = driver
							.findElement(By.xpath(
									OR.getProperty("portfoliosummary_inspection2_inspectionlist_completion_XPATH")))
							.getText();

					if (inspectionCompletion.equals("0%")) {
						successMessage("The completion percentage of the inspection is displayed correctly.");
					} else {
						verificationFailedMessage(
								"The completion percentage of the inspection is displayed incorrectly.");
					}

				} catch (Throwable t) {

					verificationFailedMessage("The completion percentage of the inspection is displayed incorrectly.");
				}

				// VERIFY TOTAL TASK OF THE INSPECTION
				title("VERIFY TOTAL TASK OF THE INSPECTION");

				try {

					String inspectionTotalTaskString = driver
							.findElement(By.xpath(
									OR.getProperty("portfoliosummary_inspection2_inspectionlist_totaltask_XPATH")))
							.getText();

					int inspectionTotalTask = Integer.parseInt(inspectionTotalTaskString);

					if (task == inspectionTotalTask) {
						successMessage("The total task of the inspection is displayed correctly.");
					} else {
						verificationFailedMessage("The total task of the inspection is displayed incorrectly.");
					}

				} catch (Throwable t) {

					verificationFailedMessage("The total task of the inspection is displayed incorrectly.");
				}

				// VERIFY OPEN TASK OF THE INSPECTION
				title("VERIFY OPEN TASK OF THE INSPECTION");

				try {

					String inspectionCompletionString = driver
							.findElement(By.xpath(
									OR.getProperty("portfoliosummary_inspection2_inspectionlist_opentask_XPATH")))
							.getText();

					int inspectionCompletion = Integer.parseInt(inspectionCompletionString);

					if (openTask == inspectionCompletion) {
						successMessage("The open task of the inspection is displayed correctly.");
					} else {
						verificationFailedMessage("The open task of the inspection is displayed incorrectly.");
					}

				} catch (Throwable t) {
					verificationFailedMessage("The open task of the inspection is displayed incorrectly.");
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

			// MAKE THE COVID 19 INSPECTION AS A INPROGRESS - OPERATION MANAGER
			title("MAKE THE COVID 19 INSPECTION AS A INPROGRESS - OPERATION MANAGER");

			try {

				// enter the property name in the search field
				type("envreports_propertylist_filtertxt_CSS", data.get("property_1"));

				// click on the environmental icon from the property list page
				click("environmentalicon_CSS");

				// wait for the element
				Thread.sleep(5000);

				// click on the burger menu
				click("menubtn_CSS");

				// wait for the element
				Thread.sleep(5000);

				// click on the checklist/inspection option from side menu
				click("checklist_sidemenu_XPATH");

				// wait for 3 seconds
				Thread.sleep(3000);

				// select property from the property drop down
				select("envreports_movereports_propertydd_CSS", data.get("building_leveldropdown"));

				// wait for 5 seconds
				Thread.sleep(5000);

				// enter newly created inspection in the search field

				type("task_listofchecklist_filterfield_CSS", data.get("checklist_property_title"));

				// click on the searched inspection
				click("inspection_createdinspection5_XPATH");

				// click on the switch to wizard mode button
				click("checklist_classicviewbtn_CSS");

				// click on the on option of the 1st question
				click("checklist_wizard_nooption_CSS");

				// click on the back button
				click("questionnaire_checklist_backbtn_CSS");

				// enter newly created inspection in the search field

				type("task_listofchecklist_filterfield_CSS", data.get("checklist_property_title"));

				// verify submitted inspection is displayed or not
				switchVerification("inspection_createdinspection5_XPATH",
						"Test Questionnaire Property Title Smoke Capreit Five",
						"The Test Questionnaire Property Title Smoke Capreit Five is not displayed.");

			} catch (Throwable t) {
				verificationFailed();
			}

			// click on the home icon from the top of the screen
			click("questionnaire_homeburgermenubtn_hide_CSS");

			// synchronization
			explicitWait("propertylist_title_XPATH");

			// verify the property list
			switchVerification("propertylist_title_XPATH", "Property List", "The property list is not displayed.");

			// VERIFY THE INPROGRESS INSPECTION IN PORTFOLIO SUMMARY DASHBOARD
			title("VERIFY THE INPROGRESS INSPECTION IN PORTFOLIO SUMMARY DASHBOARD");

			try {

				// wait for the element
				Thread.sleep(5000);

				// click on the side menu
				click("menubtn_CSS");

				// wait for the element
				Thread.sleep(5000);

				// click on the portfolio summary option
				click("sidemenu_portfoliosummary_XPATH");

				// scroll down the screen

				scrollTillElement("portfoliosummary_inspection2_XPATH");
				scrollByPixel(-200);

				// VERIFY INSPECTION DETAILS IN THE PORTFOLIO SUMMARY DASHBOARD SCREEN
				title("VERIFY INSPECTION DETAILS IN THE PORTFOLIO SUMMARY DASHBOARD SCREEN");

				// VERIFY COUNT OF THE PROPERTY AFTER THE INSPECTION MAKE IN PROGRESS
				title("VERIFY COUNT OF THE PROPERTY AFTER THE INSPECTION MAKE IN PROGRESS");

				try {
					String property2String = (driver
							.findElement(By.cssSelector(OR.getProperty("portfoliosummary_inspection2_property_CSS")))
							.getText()).trim();

					int property2 = Integer.parseInt(property2String);

					if (property == (property2)) {
						successMessage("The property count of the inspection is displayed correctly.");
					} else {
						verificationFailedMessage("The property count of the inspection is displayed incorrectly.");
					}

				} catch (Throwable t) {
					verificationFailedMessage("The property count of the inspection is displayed incorrectly.");
				}

				// VERIFY COUNT OF THE ACTIVE TASKS AFTER THE INSPECTION MAKE IN PROGRESS
				try {
					String task2String = (driver
							.findElement(By.cssSelector(OR.getProperty("portfoliosummary_inspection2_task_CSS")))
							.getText()).trim();

					int task2 = Integer.parseInt(task2String);

					if (task == (task2 - 1)) {
						successMessage("The active task count of the inspection is displayed correctly.");
					} else {
						verificationFailedMessage("The active task count of the inspection is displayed incorrectly.");
					}

				} catch (Throwable t) {
					verificationFailedMessage("The active task count of the inspection is displayed incorrectly.");
				}

				// VERIFY INSPECTION DETAILS IN THE INSPECTION LIST SCREEN
				title("VERIFY INSPECTION DETAILS IN THE INSPECTION LIST SCREEN");

				// click on the property count
				click("portfoliosummary_inspection2_property_CSS");

				// VERIFY THE OPEN TASK COUNT
				title("VERIFY THE OPEN TASK COUNT");
				try {

					String openTask2String = (driver
							.findElement(
									By.xpath(OR.getProperty("portfoliosummary_inspection2_inspectionlist_task_XPATH")))
							.getText()).trim();

					int openTask2 = Integer.parseInt(openTask2String);

					if (openTask == (openTask2 - 1)) {
						successMessage("The open task count of the inspection is displayed correctly.");
					} else {
						verificationFailedMessage("The open task count of the inspection is displayed incorrectly.");
					}

				} catch (Throwable t) {
					verificationFailedMessage("The open task count of the inspection is displayed incorrectly.");
				}

				// click on the fourth circle
				click("portfoliosummary_inspection2_inspectionlist_circle_XPATH");

				// VERIFY INSPECTION DETAILS IN THE CREATE CHECKLIST LIST SCREEN
				title("VERIFY INSPECTION DETAILS IN THE CREATE CHECKLIST LIST SCREEN");

				// enter the inspection name in the search field
				type("task_listofchecklist_filterfield_CSS", data.get("checklist_property_title"));

				// VERIFY NEWLY CREATED INSPECTION IS DISPLAYED OR NOT
				title("VERIFY NEWLY CREATED INSPECTION IS DISPLAYED OR NOT");

				try {
					String inspectionName = driver
							.findElement(By.xpath(OR.getProperty("inspection_createdinspection5_XPATH"))).getText();

					if (inspectionName.equals("Test Questionnaire Property Title Smoke Capreit Five")) {
						successMessage("The inspection is displayed correctly.");
					} else {
						verificationFailedMessage("The inspection is not displayed.");
					}

				} catch (Throwable t) {
					verificationFailedMessage("The inspection is not displayed.");
				}

				// VERIFY COMPLETION OF THE INSPECTION
				title("VERIFY COMPLETION OF THE INSPECTION");

				try {

					String inspectionCompletion = driver
							.findElement(By.xpath(
									OR.getProperty("portfoliosummary_inspection2_inspectionlist_completion_XPATH")))
							.getText();

					if (inspectionCompletion.equals("25%")) {
						successMessage("The completion percentage of the inspection is displayed correctly.");
					} else {
						verificationFailedMessage(
								"The completion percentage of the inspection is displayed incorrectly.");
					}

				} catch (Throwable t) {

					verificationFailedMessage("The completion percentage of the inspection is displayed incorrectly.");
				}

				// VERIFY TOTAL TASK OF THE INSPECTION
				title("VERIFY TOTAL TASK OF THE INSPECTION");

				try {

					String inspectionTotalTaskString = driver
							.findElement(By.xpath(
									OR.getProperty("portfoliosummary_inspection2_inspectionlist_totaltask_XPATH")))
							.getText();

					int inspectionTotalTask = Integer.parseInt(inspectionTotalTaskString);

					if (task == (inspectionTotalTask - 1)) {
						successMessage("The total task of the inspection is displayed correctly.");
					} else {
						verificationFailedMessage("The total task of the inspection is displayed incorrectly.");
					}

				} catch (Throwable t) {

					verificationFailedMessage("The total task of the inspection is displayed incorrectly.");
				}

				// VERIFY OPEN TASK OF THE INSPECTION
				title("VERIFY OPEN TASK OF THE INSPECTION");

				try {

					String inspectionCompletionString = driver
							.findElement(By.xpath(
									OR.getProperty("portfoliosummary_inspection2_inspectionlist_opentask_XPATH")))
							.getText();

					int inspectionCompletion = Integer.parseInt(inspectionCompletionString);

					if (openTask == (inspectionCompletion - 1)) {
						successMessage("The open task of the inspection is displayed correctly.");
					} else {
						verificationFailedMessage("The open task of the inspection is displayed incorrectly.");

					}

				} catch (Throwable t) {

					verificationFailedMessage("The open task of the inspection is displayed incorrectly.");
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

			// COMPLETE THE COVID 19 INSPECTION - OPERATION MANAGER
			title("COMPLETE THE COVID 19 INSPECTION - OPERATION MANAGER");

			try {

				// enter the property name in the search field
				type("envreports_propertylist_filtertxt_CSS", data.get("property_1"));

				// click on the environmental icon from the property list page
				click("environmentalicon_CSS");

				// wait for the element
				Thread.sleep(5000);

				// click on the burger menu
				click("menubtn_CSS");

				// wait for the element
				Thread.sleep(5000);

				// click on the checklist/inspection option from side menu
				click("checklist_sidemenu_XPATH");

				// wait for 3 seconds
				Thread.sleep(3000);

				// select property from the property drop down
				select("envreports_movereports_propertydd_CSS", data.get("building_leveldropdown"));

				// wait for 5 seconds
				Thread.sleep(5000);

				// enter newly created inspection in the search field

				type("task_listofchecklist_filterfield_CSS", data.get("checklist_property_title"));

				// click on the searched inspection
				click("inspection_createdinspection5_XPATH");

				// click on the switch to wizard mode button
				click("checklist_classicviewbtn_CSS");

				// click on the next button from the 1st question
				click("checklist_wizard_nextbtn_CSS");

				// click on the yes option of the 2nd question
				click("checklist_wizard_yesoption_CSS");

				// click on the next button from the 2nd question
				click("checklist_wizard_nextbtn_CSS");

				// click on the yes option of the 3rd question
				click("checklist_wizard_yesoption_CSS");

				// click on the next button from the 3rd question
				click("checklist_wizard_nextbtn_CSS");

				// scroll down the screen

				scrollByPixel(500);

				// click on the yes option of the 4th question
				click("checklist_wizard_yesoption_CSS");

				// click on the next button from the 4th question
				click("checklist_wizard_nextbtn_CSS");

				// click on the next button from the 5th question
				click("checklist_wizard_nextbtn_CSS");

				// click on the next button from the 6th question
				click("checklist_wizard_nextbtn_CSS");

				// click on the next button from the 7th question
				click("checklist_wizard_nextbtn_CSS");

				// click on the back button
				click("questionnaire_checklist_backbtn_CSS");

				// enter newly created inspection in the search field

				type("task_listofchecklist_filterfield_CSS", data.get("checklist_property_title"));

				// verify completed inspection is displayed or not
				switchVerification("inspection_createdinspection5_XPATH",
						"Test Questionnaire Property Title Smoke Capreit Five",
						"The Test Questionnaire Property Title Smoke Capreit Five is not displayed.");

			} catch (Throwable t) {
				verificationFailed();
			}

			// click on the home icon from the top of the screen
			click("questionnaire_homeburgermenubtn_hide_CSS");

			// synchronization
			explicitWait("propertylist_title_XPATH");

			// verify the property list
			switchVerification("propertylist_title_XPATH", "Property List", "The property list is not displayed.");

			// VERIFY THE COMPLETED INSPECTION IN PORTFOLIO SUMMARY DASHBOARD
			title("VERIFY THE COMPLETED INSPECTION IN PORTFOLIO SUMMARY DASHBOARD");

			try {

				// wait for the element
				Thread.sleep(5000);

				// click on the side menu
				click("menubtn_CSS");

				// wait for the element
				Thread.sleep(5000);

				// click on the portfolio summary option
				click("sidemenu_portfoliosummary_XPATH");

				// scroll down the screen
				scrollTillElement("portfoliosummary_inspection2_XPATH");
				scrollByPixel(-200);

				// VERIFY INSPECTION DETAILS IN THE PORTFOLIO SUMMARY DASHBOARD SCREEN
				title("VERIFY INSPECTION DETAILS IN THE PORTFOLIO SUMMARY DASHBOARD SCREEN");

				try {
					String property3String = (driver
							.findElement(By.cssSelector(OR.getProperty("portfoliosummary_inspection2_property_CSS")))
							.getText()).trim();

					int property3 = Integer.parseInt(property3String);

					if (property == (property3)) {
						successMessage("The property count of the inspection is displayed correctly.");
					} else {
						verificationFailedMessage("The property count of the inspection is displayed incorrectly.");
					}

				} catch (Throwable t) {
					verificationFailedMessage("The property count of the inspection is displayed incorrectly.");
				}

				// VERIFY COUNT OF THE ACTIVE TASKS AFTER THE INSPECTION MAKE IN PROGRESS

				try {
					String task3String = (driver
							.findElement(By.cssSelector(OR.getProperty("portfoliosummary_inspection2_task_CSS")))
							.getText()).trim();

					int task3 = Integer.parseInt(task3String);

					if (task == (task3 - 1)) {
						successMessage("The active task count of the inspection is displayed correctly.");

					} else {
						verificationFailedMessage("The active task count of the inspection is displayed incorrectly.");
					}

				} catch (Throwable t) {
					verificationFailedMessage("The active task count of the inspection is displayed incorrectly.");
				}

				// VERIFY INSPECTION DETAILS IN THE INSPECTION LIST SCREEN
				title("VERIFY INSPECTION DETAILS IN THE INSPECTION LIST SCREEN");

				// click on the property count
				click("portfoliosummary_inspection2_property_CSS");

				// VERIFY THE OPEN TASK COUNT
				try {

					String openTask3String = (driver
							.findElement(
									By.xpath(OR.getProperty("portfoliosummary_inspection2_inspectionlist_task_XPATH")))
							.getText()).trim();

					int openTask3 = Integer.parseInt(openTask3String);

					if (openTask == (openTask3 - 1)) {
						successMessage("The open task count of the inspection is displayed correctly.");

					} else {
						verificationFailedMessage("The open task count of the inspection is displayed incorrectly.");
					}

				} catch (Throwable t) {
					verificationFailedMessage("The open task count of the inspection is displayed incorrectly.");
				}

				// click on the fourth circle
				click("portfoliosummary_inspection2_inspectionlist_circle_XPATH");

				// VERIFY INSPECTION DETAILS IN THE CREATE CHECKLIST LIST SCREEN
				title("VERIFY INSPECTION DETAILS IN THE CREATE CHECKLIST LIST SCREEN");

				// enter the inspection name in the search field
				type("task_listofchecklist_filterfield_CSS", data.get("checklist_property_title"));

				// VERIFY NEWLY CREATED INSPECTION IS DISPLAYED OR NOT

				try {
					String inspectionName = driver
							.findElement(By.xpath(OR.getProperty("inspection_createdinspection5_XPATH"))).getText();

					if (inspectionName.equals("Test Questionnaire Property Title Smoke Capreit Five")) {
						successMessage("The inspection is displayed correctly.");
					} else {
						verificationFailedMessage("The inspection is not displayed.");
					}

				} catch (Throwable t) {
					verificationFailedMessage("The inspection is not displayed.");
				}

				// VERIFY COMPLETION OF THE INSPECTION

				try {

					String inspectionCompletion = driver
							.findElement(By.xpath(
									OR.getProperty("portfoliosummary_inspection2_inspectionlist_completion_XPATH")))
							.getText();

					if (inspectionCompletion.equals("100%")) {
						successMessage("The completion percentage of the inspection is displayed correctly.");
					} else {
						verificationFailedMessage(
								"The completion percentage of the inspection is displayed incorrectly.");
					}

				} catch (Throwable t) {

					verificationFailedMessage("The completion percentage of the inspection is displayed incorrectly.");
				}

				// VERIFY TOTAL TASK OF THE INSPECTION

				try {

					String inspectionTotalTaskString = driver
							.findElement(By.xpath(
									OR.getProperty("portfoliosummary_inspection2_inspectionlist_totaltask_XPATH")))
							.getText();

					int inspectionTotalTask = Integer.parseInt(inspectionTotalTaskString);

					if (task == (inspectionTotalTask - 1)) {
						successMessage("The total task of the inspection is displayed correctly.");
					} else {
						verificationFailedMessage("The total task of the inspection is displayed incorrectly.");
					}

				} catch (Throwable t) {
					verificationFailedMessage("The total task of the inspection is displayed incorrectly.");
				}

				// VERIFY OPEN TASK OF THE INSPECTION
				try {

					String inspectionCompletionString = driver
							.findElement(By.xpath(
									OR.getProperty("portfoliosummary_inspection2_inspectionlist_opentask_XPATH")))
							.getText();

					int inspectionCompletion = Integer.parseInt(inspectionCompletionString);

					if (openTask == (inspectionCompletion - 1)) {
						successMessage("The open task of the inspection is displayed correctly.");
					} else {
						verificationFailedMessage("The open task of the inspection is displayed incorrectly.");
					}

				} catch (Throwable t) {
					verificationFailedMessage("The open task of the inspection is displayed incorrectly.");
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

			// ADD THE TASK IN COVID 19 INSPECTION - OPERATION MANAGER
			title("ADD THE TASK IN COVID 19 INSPECTION - OPERATION MANAGER");

			try {

				// enter the property name in the search field
				type("envreports_propertylist_filtertxt_CSS", data.get("property_1"));

				// click on the environmental icon from the property list page
				click("environmentalicon_CSS");

				// wait for the element
				Thread.sleep(5000);

				// click on the burger menu
				click("menubtn_CSS");

				// wait for the element
				Thread.sleep(5000);

				// click on the checklist/inspection option from side menu
				click("checklist_sidemenu_XPATH");

				// wait for the element
				explicitWaitClickable("envreports_movereports_propertydd_CSS");

				// select property from the property drop down
				select("envreports_movereports_propertydd_CSS", data.get("building_leveldropdown"));

				// wait for 3 seconds
				Thread.sleep(3000);

				// enter newly created inspection in the search field

				type("task_listofchecklist_filterfield_CSS", data.get("checklist_property_title"));

				// wait for 3 seconds
				Thread.sleep(3000);

				// click on the searched inspection
				click("inspection_createdinspection5_XPATH");

				// wait for 3 seconds
				Thread.sleep(3000);

				// click on the switch to wizard mode button
				click("checklist_classicviewbtn_CSS");

				// wait for 3 seconds
				Thread.sleep(3000);

				// click on the task tab
				click("inspectionchecklist_tasktab_XPATH");

				// click on the new task button
				click("inspectionchecklist_newtaskbtn_XPATH");

				// click on the task type field
				click("task_permission_task_tasktypetxt_CSS");

				// enter task type in the search field
				type("inspectionchecklist_tasktagsearchfield_CSS", data.get("tasktag"));

				// click on the searched task tag
				click("inspectionchecklist_tasktagsearchedresult_XPATH");

				// click on the save task button
				click("survey_task_savebtn_CSS");

				// wait for the element
				explicitWaitClickable("closetoastmsg_CSS");

				// click on the toaster close button
				click("closetoastmsg_CSS");

				// verify newly created task is displayed or not
				switchVerification("inspectionchecklist_tasktagcreatedtask_XPATH", "Electrical (Light Fixture)",
						"The Electrical (Light Fixture) is not displayed.");

			} catch (Throwable t) {
				verificationFailed();
			}

			// click on the home icon from the top of the screen
			click("questionnaire_homeburgermenubtn_hide_CSS");

			// synchronization
			explicitWait("propertylist_title_XPATH");

			// verify the property list
			switchVerification("propertylist_title_XPATH", "Property List", "The property list is not displayed.");

			// VERIFY THE COMPLETED INSPECTION WITH NEW TASK IN PORTFOLIO SUMMARY DASHBOARD
			title("VERIFY THE COMPLETED INSPECTION WITH NEW TASK IN PORTFOLIO SUMMARY DASHBOARD");

			try {

				// wait for the element
				Thread.sleep(5000);

				// click on the side menu
				click("menubtn_CSS");

				// wait for the element
				Thread.sleep(5000);

				// click on the portfolio summary option
				click("sidemenu_portfoliosummary_XPATH");

				// scroll down the screen

				scrollTillElement("portfoliosummary_inspection2_XPATH");
				scrollByPixel(-200);

				// VERIFY INSPECTION DETAILS IN THE PORTFOLIO SUMMARY DASHBOARD SCREEN
				title("VERIFY INSPECTION DETAILS IN THE PORTFOLIO SUMMARY DASHBOARD SCREEN");

				try {
					String property4String = (driver
							.findElement(By.cssSelector(OR.getProperty("portfoliosummary_inspection2_property_CSS")))
							.getText()).trim();

					int property4 = Integer.parseInt(property4String);

					if (property == (property4)) {
						successMessage("The property count of the inspection is displayed correctly.");
					} else {
						verificationFailedMessage("The property count of the inspection is displayed incorrectly.");
					}

				} catch (Throwable t) {
					verificationFailedMessage("The property count of the inspection is displayed incorrectly.");
				}

				// VERIFY COUNT OF THE ACTIVE TASKS AFTER THE INSPECTION MAKE IN PROGRESS

				try {
					String task4String = (driver
							.findElement(By.cssSelector(OR.getProperty("portfoliosummary_inspection2_task_CSS")))
							.getText()).trim();

					int task4 = Integer.parseInt(task4String);

					if (task == (task4 - 2)) {

						successMessage("The active task count of the inspection is displayed correctly.");

					} else {
						verificationFailedMessage("The active task count of the inspection is displayed incorrectly.");
					}

				} catch (Throwable t) {
					verificationFailedMessage("The active task count of the inspection is displayed incorrectly.");
				}

				// VERIFY INSPECTION DETAILS IN THE INSPECTION LIST SCREEN
				title("VERIFY INSPECTION DETAILS IN THE INSPECTION LIST SCREEN");

				// click on the property count
				click("portfoliosummary_inspection2_property_CSS");

				// VERIFY THE OPEN TASK COUNT

				try {

					String openTask4String = (driver
							.findElement(
									By.xpath(OR.getProperty("portfoliosummary_inspection2_inspectionlist_task_XPATH")))
							.getText()).trim();

					int openTask4 = Integer.parseInt(openTask4String);

					if (openTask == (openTask4 - 2)) {
						successMessage("The open task count of the inspection is displayed correctly.");

					} else {
						verificationFailedMessage("The open task count of the inspection is displayed incorrectly.");
					}

				} catch (Throwable t) {
					verificationFailedMessage("The open task count of the inspection is displayed incorrectly.");
				}

				// click on the fourth circle
				click("portfoliosummary_inspection2_inspectionlist_circle_XPATH");

				// VERIFY INSPECTION DETAILS IN THE CREATE CHECKLIST LIST SCREEN
				title("VERIFY INSPECTION DETAILS IN THE CREATE CHECKLIST LIST SCREEN");

				// enter the inspection name in the search field
				type("task_listofchecklist_filterfield_CSS", data.get("checklist_property_title"));

				// VERIFY NEWLY CREATED INSPECTION IS DISPLAYED OR NOT

				try {
					String inspectionName = driver
							.findElement(By.xpath(OR.getProperty("inspection_createdinspection5_XPATH"))).getText();

					if (inspectionName.equals("Test Questionnaire Property Title Smoke Capreit Five")) {
						successMessage("The inspection is displayed correctly.");
					} else {
						verificationFailedMessage("The inspection is not displayed.");

					}

				} catch (Throwable t) {
					verificationFailedMessage("The inspection is not displayed.");
				}

				// VERIFY COMPLETION OF THE INSPECTION

				try {

					String inspectionCompletion = driver
							.findElement(By.xpath(
									OR.getProperty("portfoliosummary_inspection2_inspectionlist_completion_XPATH")))
							.getText();

					if (inspectionCompletion.equals("100%")) {
						successMessage("The completion percentage of the inspection is displayed correctly.");
					} else {
						verificationFailedMessage(
								"The completion percentage of the inspection is displayed incorrectly.");
					}

				} catch (Throwable t) {
					verificationFailedMessage("The completion percentage of the inspection is displayed incorrectly.");
				}

				// VERIFY TOTAL TASK OF THE INSPECTION

				try {

					String inspectionTotalTaskString = driver
							.findElement(By.xpath(
									OR.getProperty("portfoliosummary_inspection2_inspectionlist_totaltask_XPATH")))
							.getText();

					int inspectionTotalTask = Integer.parseInt(inspectionTotalTaskString);

					if (task == (inspectionTotalTask - 2)) {
						successMessage("The total task of the inspection is displayed correctly.");
					} else {
						verificationFailedMessage("The total task of the inspection is displayed incorrectly.");
					}

				} catch (Throwable t) {
					verificationFailedMessage("The total task of the inspection is displayed incorrectly.");
				}

				// VERIFY OPEN TASK OF THE INSPECTION

				try {

					String inspectionCompletionString = driver
							.findElement(By.xpath(
									OR.getProperty("portfoliosummary_inspection2_inspectionlist_opentask_XPATH")))
							.getText();

					int inspectionCompletion = Integer.parseInt(inspectionCompletionString);

					if (openTask == (inspectionCompletion - 2)) {
						successMessage("The open task of the inspection is displayed correctly.");
					} else {
						verificationFailedMessage("The open task of the inspection is displayed incorrectly.");
					}

				} catch (Throwable t) {

					verificationFailedMessage("The open task of the inspection is displayed incorrectly.");
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

			// COMPLETE THE NEWLY CREATED TASK
			title("COMPLETE THE NEWLY CREATED TASK");

			try {
				// enter the property name in the search field
				type("envreports_propertylist_filtertxt_CSS", data.get("property_1"));

				// click on the environmental icon from the property list page
				click("environmentalicon_CSS");

				// wait for the element
				Thread.sleep(5000);

				// click on the burger menu
				click("menubtn_CSS");

				// wait for the element
				Thread.sleep(5000);

				// click on the checklist/inspection option from side menu
				click("checklist_sidemenu_XPATH");

				// wait for the element
				explicitWaitClickable("envreports_movereports_propertydd_CSS");

				// select property from the property drop down
				select("envreports_movereports_propertydd_CSS", data.get("building_leveldropdown"));

				// wait for 3 seconds
				Thread.sleep(3000);

				// enter newly created inspection in the search field

				type("task_listofchecklist_filterfield_CSS", data.get("checklist_property_title"));

				// click on the searched inspection
				click("inspection_createdinspection5_XPATH");

				// wait for 3 seconds
				Thread.sleep(3000);

				// click on the switch to wizard mode button
				click("checklist_classicviewbtn_CSS");

				// wait for 3 seconds
				Thread.sleep(3000);

				// click on the task tab
				click("inspectionchecklist_tasktab_XPATH");

				// click on the newly created task
				click("questionnaire_checklist_newlycreatedtask_capreit1_XPATH");

				// SET TASK AS A IN PROGRESS
				consoleMessage("SET TASK AS A IN PROGRESS");

				// click on the start button
				click("propertyproject_mu_repair_startbtn_CSS");

				// SET TASK AS A CLOSED
				consoleMessage("SET TASK AS A CLOSED");

				// wait for the element
				explicitWaitClickable("task_addtask_backbtn_inspectiontask_XPATH");

				// click on the back button
				click("task_addtask_backbtn_inspectiontask_XPATH");

				// click on the action icon of the approved task
				click("task_autotask_closedlbl_actionicon_viainspection_addedreport3_XPATH");

				// click on the complete task option
				click("task_autotask_closedlbl_actionicon_closeoption_viainspection_report3_XPATH");

				// verify in closed status is display
				switchVerification("task_autotask_closedlbl_report3_addedtask_XPATH", "Closed",
						"The closed status is not displayed.");

			} catch (Throwable t) {
				verificationFailed();
			}

			// click on the Home button
			click("questionnaire_homeburgermenubtn_hide_CSS");

			// wait for the element
			explicitWait("propertylist_title_XPATH");

			// verify the property list
			switchVerification("propertylist_title_XPATH", "Property List", "The property list is not displayed.");

			// VERIFY THE INSPECTION WITH CLOSED TASK IN PORTFOLIO SUMMARY DASHBOARD
			title("VERIFY THE INSPECTION WITH CLOSED TASK IN PORTFOLIO SUMMARY DASHBOARD");

			try {

				// wait for the element
				Thread.sleep(5000);

				// click on the side menu
				click("menubtn_CSS");

				// wait for the element
				Thread.sleep(5000);

				// click on the portfolio summary option
				click("sidemenu_portfoliosummary_XPATH");

				// scroll down the screen

				scrollTillElement("portfoliosummary_inspection2_XPATH");
				scrollByPixel(-200);

				// VERIFY INSPECTION DETAILS IN THE PORTFOLIO SUMMARY DASHBOARD SCREEN
				title("VERIFY INSPECTION DETAILS IN THE PORTFOLIO SUMMARY DASHBOARD SCREEN");

				try {
					String property5String = (driver
							.findElement(By.cssSelector(OR.getProperty("portfoliosummary_inspection2_property_CSS")))
							.getText()).trim();

					int property5 = Integer.parseInt(property5String);

					if (property == (property5)) {
						successMessage("The property count of the inspection is displayed correctly.");
					} else {
						verificationFailedMessage("The property count of the inspection is displayed incorrectly.");
					}

				} catch (Throwable t) {
					verificationFailedMessage("The property count of the inspection is displayed incorrectly.");
				}

				// VERIFY COUNT OF THE ACTIVE TASKS AFTER THE INSPECTION MAKE IN PROGRESS

				try {
					String task5String = (driver
							.findElement(By.cssSelector(OR.getProperty("portfoliosummary_inspection2_task_CSS")))
							.getText()).trim();

					int task5 = Integer.parseInt(task5String);

					if (task == (task5 - 1)) {
						successMessage("The active task count of the inspection is displayed correctly.");

					} else {
						verificationFailedMessage("The active task count of the inspection is displayed incorrectly.");
					}

				} catch (Throwable t) {
					verificationFailedMessage("The active task count of the inspection is displayed incorrectly.");
				}

				// VERIFY INSPECTION DETAILS IN THE INSPECTION LIST SCREEN
				title("VERIFY INSPECTION DETAILS IN THE INSPECTION LIST SCREEN");

				// click on the property count
				click("portfoliosummary_inspection2_property_CSS");

				// VERIFY THE OPEN TASK COUNT

				try {

					String openTask5String = (driver
							.findElement(
									By.xpath(OR.getProperty("portfoliosummary_inspection2_inspectionlist_task_XPATH")))
							.getText()).trim();

					int openTask5 = Integer.parseInt(openTask5String);

					if (openTask == (openTask5 - 1)) {
						successMessage("The open task count of the inspection is displayed correctly.");

					} else {
						verificationFailedMessage("The open task count of the inspection is displayed incorrectly.");
					}

				} catch (Throwable t) {
					verificationFailedMessage("The open task count of the inspection is displayed incorrectly.");
				}

				// click on the fourth circle
				click("portfoliosummary_inspection2_inspectionlist_circle_XPATH");

				// VERIFY INSPECTION DETAILS IN THE CREATE CHECKLIST LIST SCREEN
				title("VERIFY INSPECTION DETAILS IN THE CREATE CHECKLIST LIST SCREEN");

				// enter the inspection name in the search field
				type("task_listofchecklist_filterfield_CSS", data.get("checklist_property_title"));

				// VERIFY NEWLY CREATED INSPECTION IS DISPLAYED OR NOT

				try {
					String inspectionName = driver
							.findElement(By.xpath(OR.getProperty("inspection_createdinspection5_XPATH"))).getText();

					if (inspectionName.equals("Test Questionnaire Property Title Smoke Capreit Five")) {
						successMessage("The inspection is displayed correctly.");
					} else {
						verificationFailedMessage("The inspection is not displayed.");
					}

				} catch (Throwable t) {
					verificationFailedMessage("The inspection is not displayed.");
				}

				// VERIFY COMPLETION OF THE INSPECTION

				try {

					String inspectionCompletion = driver
							.findElement(By.xpath(
									OR.getProperty("portfoliosummary_inspection2_inspectionlist_completion_XPATH")))
							.getText();

					if (inspectionCompletion.equals("100%")) {
						successMessage("The completion percentage of the inspection is displayed correctly.");
					} else {
						verificationFailedMessage(
								"The completion percentage of the inspection is displayed incorrectly.");
					}

				} catch (Throwable t) {
					verificationFailedMessage("The completion percentage of the inspection is displayed incorrectly.");
				}

				// VERIFY TOTAL TASK OF THE INSPECTION

				try {

					String inspectionTotalTaskString = driver
							.findElement(By.xpath(
									OR.getProperty("portfoliosummary_inspection2_inspectionlist_totaltask_XPATH")))
							.getText();

					int inspectionTotalTask = Integer.parseInt(inspectionTotalTaskString);

					if (task == (inspectionTotalTask - 2)) {
						successMessage("The total task of the inspection is displayed correctly.");
					} else {
						verificationFailedMessage("The total task of the inspection is displayed incorrectly.");
					}

				} catch (Throwable t) {
					verificationFailedMessage("The total task of the inspection is displayed incorrectly.");
				}

				// VERIFY OPEN TASK OF THE INSPECTION

				try {

					String inspectionCompletionString = driver
							.findElement(By.xpath(
									OR.getProperty("portfoliosummary_inspection2_inspectionlist_opentask_XPATH")))
							.getText();

					int inspectionCompletion = Integer.parseInt(inspectionCompletionString);

					if (openTask == (inspectionCompletion - 1)) {
						successMessage("The open task of the inspection is displayed correctly.");
					} else {
						verificationFailedMessage("The open task of the inspection is displayed incorrectly.");
					}

				} catch (Throwable t) {

					verificationFailedMessage("The open task of the inspection is displayed incorrectly.");
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

			// COMPLETE THE AUTO GENERATED TASK
			title("COMPLETE THE AUTO GENERATED TASK");

			try {
				// enter the property name in the search field
				type("envreports_propertylist_filtertxt_CSS", data.get("property_1"));

				// click on the environmental icon from the property list page
				click("environmentalicon_CSS");

				// wait for the element
				Thread.sleep(5000);

				// click on the burger menu
				click("menubtn_CSS");

				// wait for the element
				Thread.sleep(5000);

				// click on the checklist/inspection option from side menu
				click("checklist_sidemenu_XPATH");

				// wait for the element
				explicitWaitClickable("envreports_movereports_propertydd_CSS");

				// select property from the property drop down
				select("envreports_movereports_propertydd_CSS", data.get("building_leveldropdown"));

				// wait for 3 seconds
				Thread.sleep(3000);

				// enter newly created inspection in the search field

				type("task_listofchecklist_filterfield_CSS", data.get("checklist_property_title"));

				// click on the searched inspection
				click("inspection_createdinspection5_XPATH");

				// wait for 3 seconds
				Thread.sleep(3000);

				// click on the switch to wizard mode button
				click("checklist_classicviewbtn_CSS");

				// wait for 3 seconds
				Thread.sleep(3000);

				// click on the task tab
				click("inspectionchecklist_tasktab_XPATH");

				// click on the newly created task
				click("questionnaire_checklist_autogeneratedtask_capreit1om_XPATH");

				// SET TASK AS A IN PROGRESS
				consoleMessage("SET TASK AS A IN PROGRESS");

				// click on the start button
				click("propertyproject_mu_repair_startbtn_CSS");

				// SET TASK AS A CLOSED
				consoleMessage("SET TASK AS A CLOSED");

				// wait for the element
				explicitWaitClickable("task_addtask_backbtn_inspectiontask_XPATH");

				// click on the back button
				click("task_addtask_backbtn_inspectiontask_XPATH");

				// click on the action icon of the approved task
				click("task_autotask_approvedlbl_actionicon_report3_XPATH");

				// click on the complete task option
				click("task_autotask_approvedlbl_actionicon_closeoption_report3_XPATH");

				// verify in closed status is display
				switchVerification("task_autotask_closedlbl_report3_XPATH", "Closed",
						"The closed status is not displayed.");

			} catch (Throwable t) {
				verificationFailed();
			}

			// click on the Home button
			click("questionnaire_homeburgermenubtn_hide_CSS");

			// wait for the element
			explicitWait("propertylist_title_XPATH");

			// verify the property list
			switchVerification("propertylist_title_XPATH", "Property List", "The property list is not displayed.");

			// VERIFY THE INSPECTION WITH CLOSED AUTO GENERATED TASK IN PORTFOLIO SUMMARY
			// DASHBOARD
			title("VERIFY THE INSPECTION WITH CLOSED AUTO GENERATED TASK IN PORTFOLIO SUMMARY DASHBOARD");

			try {

				// wait for the element
				Thread.sleep(5000);

				// click on the side menu
				click("menubtn_CSS");

				// wait for the element
				Thread.sleep(5000);

				// click on the portfolio summary option
				click("sidemenu_portfoliosummary_XPATH");

				// scroll down the screen

				scrollTillElement("portfoliosummary_inspection2_XPATH");
				scrollByPixel(-200);

				// VERIFY INSPECTION DETAILS IN THE PORTFOLIO SUMMARY DASHBOARD SCREEN
				title("VERIFY INSPECTION DETAILS IN THE PORTFOLIO SUMMARY DASHBOARD SCREEN");

				try {
					String property6String = (driver
							.findElement(By.cssSelector(OR.getProperty("portfoliosummary_inspection2_property_CSS")))
							.getText()).trim();

					int property6 = Integer.parseInt(property6String);

					if (property == (property6)) {
						successMessage("The property count of the inspection is displayed correctly.");
					} else {
						verificationFailedMessage("The property count of the inspection is displayed incorrectly.");
					}

				} catch (Throwable t) {
					verificationFailedMessage("The property count of the inspection is displayed incorrectly.");
				}

				// VERIFY COUNT OF THE ACTIVE TASKS AFTER THE INSPECTION MAKE IN PROGRESS

				try {
					String task6String = (driver
							.findElement(By.cssSelector(OR.getProperty("portfoliosummary_inspection2_task_CSS")))
							.getText()).trim();

					int task6 = Integer.parseInt(task6String);

					if (task == (task6)) {
						successMessage("The active task count of the inspection is displayed correctly.");

					} else {
						verificationFailedMessage("The active task count of the inspection is displayed incorrectly.");
					}

				} catch (Throwable t) {
					verificationFailedMessage("The active task count of the inspection is displayed incorrectly.");
				}

				// VERIFY INSPECTION DETAILS IN THE INSPECTION LIST SCREEN
				title("VERIFY INSPECTION DETAILS IN THE INSPECTION LIST SCREEN");

				// click on the property count
				click("portfoliosummary_inspection2_property_CSS");

				// VERIFY THE OPEN TASK COUNT

				try {

					String openTask6String = (driver
							.findElement(
									By.xpath(OR.getProperty("portfoliosummary_inspection2_inspectionlist_task_XPATH")))
							.getText()).trim();

					int openTask6 = Integer.parseInt(openTask6String);

					if (openTask == (openTask6)) {
						successMessage("The open task count of the inspection is displayed correctly.");

					} else {
						verificationFailedMessage("The open task count of the inspection is displayed incorrectly.");
					}

				} catch (Throwable t) {
					verificationFailedMessage("The open task count of the inspection is displayed incorrectly.");
				}

				// click on the fourth circle
				click("portfoliosummary_inspection2_inspectionlist_circle_XPATH");

				// VERIFY INSPECTION DETAILS IN THE CREATE CHECKLIST LIST SCREEN
				title("VERIFY INSPECTION DETAILS IN THE CREATE CHECKLIST LIST SCREEN");

				// enter the inspection name in the search field
				type("task_listofchecklist_filterfield_CSS", data.get("checklist_property_title"));

				// VERIFY NEWLY CREATED INSPECTION IS DISPLAYED OR NOT

				try {
					String inspectionName = driver
							.findElement(By.xpath(OR.getProperty("inspection_createdinspection5_XPATH"))).getText();

					if (inspectionName.equals("Test Questionnaire Property Title Smoke Capreit Five")) {
						successMessage("The inspection is displayed correctly.");
					} else {
						verificationFailedMessage("The inspection is not displayed.");
					}

				} catch (Throwable t) {
					verificationFailedMessage("The inspection is not displayed.");
				}

				// VERIFY COMPLETION OF THE INSPECTION

				try {

					String inspectionCompletion = driver
							.findElement(By.xpath(
									OR.getProperty("portfoliosummary_inspection2_inspectionlist_completion_XPATH")))
							.getText();

					if (inspectionCompletion.equals("100%")) {
						successMessage("The completion percentage of the inspection is displayed correctly.");
					} else {
						verificationFailedMessage(
								"The completion percentage of the inspection is displayed incorrectly.");
					}

				} catch (Throwable t) {

					verificationFailedMessage("The completion percentage of the inspection is displayed incorrectly.");
				}

				// VERIFY TOTAL TASK OF THE INSPECTION

				try {

					String inspectionTotalTaskString = driver
							.findElement(By.xpath(
									OR.getProperty("portfoliosummary_inspection2_inspectionlist_totaltask_XPATH")))
							.getText();

					int inspectionTotalTask = Integer.parseInt(inspectionTotalTaskString);

					if (task == (inspectionTotalTask - 2)) {
						successMessage("The total task of the inspection is displayed correctly.");
					} else {
						verificationFailedMessage("The total task of the inspection is displayed incorrectly.");
					}

				} catch (Throwable t) {
					verificationFailedMessage("The total task of the inspection is displayed incorrectly.");
				}

				// VERIFY OPEN TASK OF THE INSPECTION

				try {

					String inspectionCompletionString = driver
							.findElement(By.xpath(
									OR.getProperty("portfoliosummary_inspection2_inspectionlist_opentask_XPATH")))
							.getText();

					int inspectionCompletion = Integer.parseInt(inspectionCompletionString);

					if (openTask == (inspectionCompletion)) {
						successMessage("The open task of the inspection is displayed correctly.");
					} else {
						verificationFailedMessage("The open task of the inspection is displayed incorrectly.");
					}

				} catch (Throwable t) {

					verificationFailedMessage("The open task of the inspection is displayed incorrectly.");
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

			// SUBMIT THE COVID 19 INSPECTION
			title("SUBMIT THE COVID 19 INSPECTION");

			try {

				// enter the property name in the search field
				type("envreports_propertylist_filtertxt_CSS", data.get("property_1"));

				// click on the environmental icon from the property list page
				click("environmentalicon_CSS");

				// wait for the element
				Thread.sleep(5000);

				// click on the burger menu
				click("menubtn_CSS");

				// wait for the element
				Thread.sleep(5000);

				// click on the checklist/inspection option from side menu
				click("checklist_sidemenu_XPATH");

				// wait for 3 seconds
				Thread.sleep(3000);

				// select property from the property drop down
				select("envreports_movereports_propertydd_CSS", data.get("building_leveldropdown"));

				// wait for 5 seconds
				Thread.sleep(5000);

				// enter newly created inspection in the search field

				type("task_listofchecklist_filterfield_CSS", data.get("checklist_property_title"));

				// click on the searched inspection
				click("inspection_createdinspection5_XPATH");

				// click on the switch to wizard mode button
				click("checklist_classicviewbtn_CSS");

				// click on the next button from the 1st question
				click("checklist_wizard_nextbtn_CSS");

				// click on the next button from the 2nd question
				click("checklist_wizard_nextbtn_CSS");

				// click on the next button from the 3rd question
				click("checklist_wizard_nextbtn_CSS");

				// click on the next button from the 4th question
				click("checklist_wizard_nextbtn_CSS");

				// click on the next button from the 5th question
				click("checklist_wizard_nextbtn_CSS");

				// click on the next button from the 6th question
				click("checklist_wizard_nextbtn_CSS");

				// click on the next button from the 7th question
				click("checklist_wizard_nextbtn_CSS");

				// click on the submit button
				click("checklist_submitbtn_CSS");

				// wait for the element
				explicitWaitClickable("closetoastmsg_CSS");

				// click on the toaster close button
				click("closetoastmsg_CSS");

				// click on the back button
				click("questionnaire_checklist_backbtn_CSS");

				// select the approved option from the status dropdown
				select("checklist_statusdd_CSS", data.get("status_dd"));

				// enter newly created inspection in the search field

				type("task_listofchecklist_filterfield_CSS", data.get("checklist_property_title"));

				// verify submitted inspection is displayed or not
				switchVerification("inspection_createdinspection5_XPATH",
						"Test Questionnaire Property Title Smoke Capreit Five",
						"The Test Questionnaire Property Title Smoke Capreit Five is not displayed.");

			} catch (Throwable t) {
				verificationFailed();
			}

			// click on the home icon from the top of the screen
			click("questionnaire_homeburgermenubtn_hide_CSS");

			// synchronization
			explicitWait("propertylist_title_XPATH");

			// verify the property list
			switchVerification("propertylist_title_XPATH", "Property List", "The property list is not displayed.");

			// VERIFY THE SUBMITTED INSPECTION WITH CLOSED AUTO GENERATED TASK IN PORTFOLIO
			// SUMMARY DASHBOARD
			title("VERIFY THE SUBMITTED INSPECTION WITH CLOSED AUTO GENERATED TASK IN PORTFOLIO SUMMARY DASHBOARD");

			try {

				// wait for the element
				Thread.sleep(5000);

				// click on the side menu
				click("menubtn_CSS");

				// wait for the element
				Thread.sleep(5000);

				// click on the portfolio summary option
				click("sidemenu_portfoliosummary_XPATH");

				// scroll down the screen

				scrollTillElement("portfoliosummary_inspection2_XPATH");
				scrollByPixel(-200);

				// VERIFY INSPECTION DETAILS IN THE PORTFOLIO SUMMARY DASHBOARD SCREEN
				title("VERIFY INSPECTION DETAILS IN THE PORTFOLIO SUMMARY DASHBOARD SCREEN");

				try {
					String property7String = (driver
							.findElement(By.cssSelector(OR.getProperty("portfoliosummary_inspection2_property_CSS")))
							.getText()).trim();

					int property7 = Integer.parseInt(property7String);

					if (property == (property7 + 1)) {
						successMessage("The property count of the inspection is displayed correctly.");
					} else {
						verificationFailedMessage("The property count of the inspection is displayed incorrectly.");
					}

				} catch (Throwable t) {
					verificationFailedMessage("The property count of the inspection is displayed incorrectly.");
				}

				// VERIFY COUNT OF THE ACTIVE TASKS AFTER THE INSPECTION MAKE IN PROGRESS

				try {
					String task7String = (driver
							.findElement(By.cssSelector(OR.getProperty("portfoliosummary_inspection2_task_CSS")))
							.getText()).trim();

					int task7 = Integer.parseInt(task7String);

					if (task == (task7)) {
						successMessage("The active task count of the inspection is displayed correctly.");

					} else {
						verificationFailedMessage("The active task count of the inspection is displayed incorrectly.");
					}

				} catch (Throwable t) {
					verificationFailedMessage("The active task count of the inspection is displayed incorrectly.");
				}

				// VERIFY INSPECTION DETAILS IN THE INSPECTION LIST SCREEN
				title("VERIFY INSPECTION DETAILS IN THE INSPECTION LIST SCREEN");

				// click on the property count
				click("portfoliosummary_inspection2_property_CSS");

				// VERIFY THE OPEN TASK COUNT

				try {

					String openTask7String = (driver
							.findElement(
									By.xpath(OR.getProperty("portfoliosummary_inspection2_inspectionlist_task_XPATH")))
							.getText()).trim();

					int openTask7 = Integer.parseInt(openTask7String);

					if (openTask == (openTask7)) {
						successMessage("The open task count of the inspection is displayed correctly.");

					} else {
						verificationFailedMessage("The open task count of the inspection is displayed incorrectly.");
					}

				} catch (Throwable t) {
					verificationFailedMessage("The open task count of the inspection is displayed incorrectly.");
				}

				// click on the fourth circle
				click("portfoliosummary_inspection2_inspectionlist_circle_XPATH");

				// VERIFY INSPECTION DETAILS IN THE CREATE CHECKLIST LIST SCREEN
				title("VERIFY INSPECTION DETAILS IN THE CREATE CHECKLIST LIST SCREEN");

				// enter the inspection name in the search field
				type("task_listofchecklist_filterfield_CSS", data.get("checklist_property_title"));

				// VERIFY NEWLY CREATED INSPECTION IS DISPLAYED OR NOT

				try {
					String inspectionName = driver
							.findElement(By.xpath(OR.getProperty("inspection_createdinspection5_XPATH"))).getText();

					if (inspectionName.equals("Test Questionnaire Property Title Smoke Capreit Five")) {
						successMessage("The inspection is displayed correctly.");
					} else {
						verificationFailedMessage("The inspection is not displayed.");
					}

				} catch (Throwable t) {
					verificationFailedMessage("The inspection is not displayed.");
				}

				// VERIFY COMPLETION OF THE INSPECTION

				try {

					String inspectionCompletion = driver
							.findElement(By.xpath(
									OR.getProperty("portfoliosummary_inspection2_inspectionlist_completion_XPATH")))
							.getText();

					if (inspectionCompletion.equals("100%")) {
						successMessage("The completion percentage of the inspection is displayed correctly.");
					} else {
						verificationFailedMessage(
								"The completion percentage of the inspection is displayed incorrectly.");
					}

				} catch (Throwable t) {

					verificationFailedMessage("The completion percentage of the inspection is displayed incorrectly.");
				}

				// VERIFY TOTAL TASK OF THE INSPECTION

				try {

					String inspectionTotalTaskString = driver
							.findElement(By.xpath(
									OR.getProperty("portfoliosummary_inspection2_inspectionlist_totaltask_XPATH")))
							.getText();

					int inspectionTotalTask = Integer.parseInt(inspectionTotalTaskString);

					if (task == (inspectionTotalTask - 2)) {
						successMessage("The total task of the inspection is displayed correctly.");
					} else {
						verificationFailedMessage("The total task of the inspection is displayed incorrectly.");
					}

				} catch (Throwable t) {
					verificationFailedMessage("The total task of the inspection is displayed incorrectly.");
				}

				// VERIFY OPEN TASK OF THE INSPECTION

				try {

					String inspectionCompletionString = driver
							.findElement(By.xpath(
									OR.getProperty("portfoliosummary_inspection2_inspectionlist_opentask_XPATH")))
							.getText();

					int inspectionCompletion = Integer.parseInt(inspectionCompletionString);

					if (openTask == (inspectionCompletion)) {
						successMessage("The open task of the inspection is displayed correctly.");
					} else {
						verificationFailedMessage("The open task of the inspection is displayed incorrectly.");
					}

				} catch (Throwable t) {

					verificationFailedMessage("The open task of the inspection is displayed incorrectly.");
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

			// DELETE THE BOTH CLOSED TASK
			title("DELETE THE BOTH CLOSED TASK");

			try {
				// enter the property name in the search field
				type("envreports_propertylist_filtertxt_CSS", data.get("property_1"));

				// click on the environmental icon from the property list page
				click("environmentalicon_CSS");

				// wait for the element
				Thread.sleep(5000);

				// click on the burger menu
				click("menubtn_CSS");

				// wait for the element
				Thread.sleep(5000);

				// click on the checklist/inspection option from side menu
				click("checklist_sidemenu_XPATH");

				// wait for the element
				explicitWaitClickable("envreports_movereports_propertydd_CSS");

				// select property from the property drop down
				select("envreports_movereports_propertydd_CSS", data.get("building_leveldropdown"));

				// wait for 3 seconds
				Thread.sleep(3000);

				// select the approved option from the status dropdown
				select("checklist_statusdd_CSS", data.get("status_dd"));

				// enter newly created inspection in the search field

				type("task_listofchecklist_filterfield_CSS", data.get("checklist_property_title"));

				// click on the searched inspection
				click("inspection_createdinspection5_XPATH");

				// wait for 3 seconds
				Thread.sleep(3000);

				// click on the switch to wizard mode button
				click("checklist_classicviewbtn_CSS");

				// wait for 3 seconds
				Thread.sleep(3000);

				// click on the task tab
				click("inspectionchecklist_tasktab_XPATH");

				// click on the action icon of the approved task
				click("task_autotask1_actionicon_report3_XPATH");

				// click on the reopen option
				click("task_autotask_actionicon_reopenoption_report3_XPATH");

				// wait for the element
				explicitWaitClickable("closetoastmsg_CSS");

				// click on the toaster close button
				click("closetoastmsg_CSS");

				// click on the action icon of the approved task
				click("task_autotask1_actionicon_report3_XPATH");

				// click on the delete button
				click("task_autotask_actionicon_deleteoption_report3_XPATH");

				// wait for the element
				explicitWaitClickable("closetoastmsg_CSS");

				// click on the toaster close button
				click("closetoastmsg_CSS");

				// click on the action icon of the task
				click("task_addtask_actionicon_XPATH");

				// click on the reopen option
				click("task_addtask_approvedlbl_actionicon_reopenoption_XPATH");

				// wait for the element
				explicitWaitClickable("closetoastmsg_CSS");

				// click on the toaster close button
				click("closetoastmsg_CSS");

				// click on the action icon of the approved task
				click("task_addtask_actionicon_XPATH");

				// click on the delete button
				click("task_addtask_approvedlbl_actionicon_deleteoption1_XPATH");

				// wait for the element
				explicitWaitClickable("closetoastmsg_CSS");

				// click on the toaster close button
				click("closetoastmsg_CSS");

			} catch (Throwable t) {
				verificationFailed();
			}

			// click on the home icon from the top of the screen
			click("questionnaire_homeburgermenubtn_hide_CSS");

			// synchronization
			explicitWait("propertylist_title_XPATH");

			// verify the property list
			switchVerification("propertylist_title_XPATH", "Property List", "The property list is not displayed.");

			// VERIFY THE INSPECTION WITH DELETED BOTH TASKS IN PORTFOLIO SUMMARY
			// DASHBOARD
			title("VERIFY THE INSPECTION WITH DELETED BOTH TASKS IN PORTFOLIO SUMMARY DASHBOARD");

			try {

				// wait for the element
				Thread.sleep(5000);

				// click on the side menu
				click("menubtn_CSS");

				// wait for the element
				Thread.sleep(5000);

				// click on the portfolio summary option
				click("sidemenu_portfoliosummary_XPATH");

				// scroll down the screen

				scrollTillElement("portfoliosummary_inspection2_XPATH");
				scrollByPixel(-200);

				// VERIFY INSPECTION DETAILS IN THE PORTFOLIO SUMMARY DASHBOARD SCREEN
				title("VERIFY INSPECTION DETAILS IN THE PORTFOLIO SUMMARY DASHBOARD SCREEN");

				try {
					String property8String = (driver
							.findElement(By.cssSelector(OR.getProperty("portfoliosummary_inspection2_property_CSS")))
							.getText()).trim();

					int property8 = Integer.parseInt(property8String);

					if (property == (property8 + 1)) {
						successMessage("The property count of the inspection is displayed correctly.");
					} else {
						verificationFailedMessage("The property count of the inspection is displayed incorrectly.");
					}

				} catch (Throwable t) {
					verificationFailedMessage("The property count of the inspection is displayed incorrectly.");
				}

				// VERIFY COUNT OF THE ACTIVE TASKS AFTER THE INSPECTION MAKE IN PROGRESS

				try {
					String task8String = (driver
							.findElement(By.cssSelector(OR.getProperty("portfoliosummary_inspection2_task_CSS")))
							.getText()).trim();

					int task8 = Integer.parseInt(task8String);

					if (task == (task8)) {

						successMessage("The active task count of the inspection is displayed correctly.");

					} else {
						verificationFailedMessage("The active task count of the inspection is displayed incorrectly.");
					}

				} catch (Throwable t) {
					verificationFailedMessage("The active task count of the inspection is displayed incorrectly.");
				}

				// VERIFY INSPECTION DETAILS IN THE INSPECTION LIST SCREEN
				title("VERIFY INSPECTION DETAILS IN THE INSPECTION LIST SCREEN");

				// click on the property count
				click("portfoliosummary_inspection2_property_CSS");

				// VERIFY THE OPEN TASK COUNT

				try {

					String openTask8String = (driver
							.findElement(
									By.xpath(OR.getProperty("portfoliosummary_inspection2_inspectionlist_task_XPATH")))
							.getText()).trim();

					int openTask8 = Integer.parseInt(openTask8String);

					if (openTask == (openTask8)) {
						successMessage("The open task count of the inspection is displayed correctly.");

					} else {
						verificationFailedMessage("The open task count of the inspection is displayed incorrectly.");
					}

				} catch (Throwable t) {
					verificationFailedMessage("The open task count of the inspection is displayed incorrectly.");
				}

				// click on the fourth circle
				click("portfoliosummary_inspection2_inspectionlist_circle_XPATH");

				// VERIFY INSPECTION DETAILS IN THE CREATE CHECKLIST LIST SCREEN
				title("VERIFY INSPECTION DETAILS IN THE CREATE CHECKLIST LIST SCREEN");

				// enter the inspection name in the search field
				type("task_listofchecklist_filterfield_CSS", data.get("checklist_property_title"));

				// VERIFY NEWLY CREATED INSPECTION IS DISPLAYED OR NOT

				try {
					String inspectionName = driver
							.findElement(By.xpath(OR.getProperty("inspection_createdinspection5_XPATH"))).getText();

					if (inspectionName.equals("Test Questionnaire Property Title Smoke Capreit Five")) {
						successMessage("The inspection is displayed correctly.");
					} else {
						verificationFailedMessage("The inspection is not displayed.");
					}

				} catch (Throwable t) {
					verificationFailedMessage("The inspection is not displayed.");
				}

				// VERIFY COMPLETION OF THE INSPECTION

				try {

					String inspectionCompletion = driver
							.findElement(By.xpath(
									OR.getProperty("portfoliosummary_inspection2_inspectionlist_completion_XPATH")))
							.getText();

					if (inspectionCompletion.equals("100%")) {
						successMessage("The completion percentage of the inspection is displayed correctly.");
					} else {
						verificationFailedMessage(
								"The completion percentage of the inspection is displayed incorrectly.");
					}

				} catch (Throwable t) {

					verificationFailedMessage("The completion percentage of the inspection is displayed incorrectly.");
				}

				// VERIFY TOTAL TASK OF THE INSPECTION

				try {

					String inspectionTotalTaskString = driver
							.findElement(By.xpath(
									OR.getProperty("portfoliosummary_inspection2_inspectionlist_totaltask_XPATH")))
							.getText();

					int inspectionTotalTask = Integer.parseInt(inspectionTotalTaskString);

					if (task == (inspectionTotalTask)) {
						successMessage("The total task of the inspection is displayed correctly.");
					} else {
						verificationFailedMessage("The total task of the inspection is displayed incorrectly.");
					}

				} catch (Throwable t) {
					verificationFailedMessage("The total task of the inspection is displayed incorrectly.");
				}

				// VERIFY OPEN TASK OF THE INSPECTION

				try {

					String inspectionCompletionString = driver
							.findElement(By.xpath(
									OR.getProperty("portfoliosummary_inspection2_inspectionlist_opentask_XPATH")))
							.getText();

					int inspectionCompletion = Integer.parseInt(inspectionCompletionString);

					if (openTask == (inspectionCompletion)) {
						successMessage("The open task of the inspection is displayed correctly.");
					} else {
						verificationFailedMessage("The open task of the inspection is displayed incorrectly.");
					}

				} catch (Throwable t) {

					verificationFailedMessage("The open task of the inspection is displayed incorrectly.");
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

			// DELETE THE INSPECTION
			title("DELETE THE INSPECTION");

			try {
				// enter the property name in the search field
				type("envreports_propertylist_filtertxt_CSS", data.get("property_1"));

				// click on the environmental icon from the property list page
				click("environmentalicon_CSS");

				// wait for the element
				Thread.sleep(5000);

				// click on the burger menu
				click("menubtn_CSS");

				// wait for the element
				Thread.sleep(5000);

				// click on the checklist/inspection option from side menu
				click("checklist_sidemenu_XPATH");

				// wait for the element
				explicitWaitClickable("envreports_movereports_propertydd_CSS");

				// select property from the property drop down
				select("envreports_movereports_propertydd_CSS", data.get("building_leveldropdown"));

				// wait for 3 seconds
				Thread.sleep(3000);

				// select the approved option from the status dropdown
				select("checklist_statusdd_CSS", data.get("status_dd"));

				// enter newly created inspection in the search field

				type("task_listofchecklist_filterfield_CSS", data.get("checklist_property_title"));

				// click on the action icon
				click("checklist_actionicon_CSS");

				// click on the reopen option
				click("checklist_wizard_reopenoption_CSS");

				// click on the reopen button
				click("checklist_wizard_reopenbtn_CSS");

				// wait for the element
				explicitWaitClickable("closetoastmsg_CSS");

				// click on the toaster close button
				click("closetoastmsg_CSS");

				// wait for 3 seconds
				Thread.sleep(3000);

				// select the open option from the status dropdown
				select("checklist_statusdd_CSS", data.get("status_dd_open"));

				// enter newly created inspection in the search field

				type("task_listofchecklist_filterfield_CSS", data.get("checklist_property_title"));

				// click on the action icon
				click("checklist_actionicon_CSS");

				// click on the delete option
				click("checklist_deleteoption_CSS");

				// click on the delete button
				click("checklist_deletebtn_CSS");

				// enter newly created inspection in the search field

				type("task_listofchecklist_filterfield_CSS", data.get("checklist_property_title"));

				// verify deleted inspection is displayed or not
				deleteVerification("inspection_createdinspection5_XPATH",
						"Test Questionnaire Property Title Smoke Capreit Five");

			} catch (Throwable t) {
				verificationFailed();
			}

			// click on the Home button
			click("questionnaire_homeburgermenubtn_hide_CSS");

			// wait for the element
			explicitWait("propertylist_title_XPATH");

			// verify the property list
			switchVerification("propertylist_title_XPATH", "Property List", "The property list is not displayed.");

			// VERIFY INSPECTION CARD ON THE PORTFOLIO SUMMARY DASHBOARD SCREEN AFTER DELETE
			// THE INSPECTION - OPERATION MANAGER
			title("VERIFY INSPECTION CARD ON THE PORTFOLIO SUMMARY DASHBOARD SCREEN AFTER DELETE THE INSPECTION - OPERATION MANAGER");

			try {

				// wait for the element
				Thread.sleep(5000);

				// click on the side menu
				click("menubtn_CSS");

				// wait for the element
				Thread.sleep(5000);

				// click on the portfolio summary option
				click("sidemenu_portfoliosummary_XPATH");

				// scroll down the screen

				scrollTillElement("portfoliosummary_inspection2_XPATH");
				scrollByPixel(-200);

				// VERIFY INSPECTION DETAILS IN THE PORTFOLIO SUMMARY DASHBOARD SCREEN
				title("VERIFY INSPECTION DETAILS IN THE PORTFOLIO SUMMARY DASHBOARD SCREEN");

				// VERIFY COUNT OF THE PROPERTY AFTER CREATED THE INSPECTION

				try {
					String property9String = (driver
							.findElement(By.cssSelector(OR.getProperty("portfoliosummary_inspection2_property_CSS")))
							.getText()).trim();

					int property9 = Integer.parseInt(property9String);

					if (property == (property9)) {
						successMessage("The property count of the inspection is displayed correctly.");
					} else {
						verificationFailedMessage("The property count of the inspection is displayed incorrectly.");
					}

				} catch (Throwable t) {
					verificationFailedMessage("The property count of the inspection is displayed incorrectly.");
				}

				// VERIFY COUNT OF THE ACTIVE TASKS AFTER CREATED THE INSPECTION

				try {
					String task9String = (driver
							.findElement(By.cssSelector(OR.getProperty("portfoliosummary_inspection2_task_CSS")))
							.getText()).trim();

					int task9 = Integer.parseInt(task9String);

					if (task == (task9)) {

						successMessage("The active task count of the inspection is displayed correctly.");
					} else {
						verificationFailedMessage("The active task count of the inspection is displayed incorrectly.");
					}

				} catch (Throwable t) {
					verificationFailedMessage("The active task count of the inspection is displayed incorrectly.");
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

			// wait for the 5 seconds
			Thread.sleep(5000);

			// click on the settings icon from the top of the screen
			click("questionnaire_settingicon_CSS");

			// wait for the element
			explicitWaitClickable("sidemenu_logout_CSS");

			// click on the logout option from the side menu
			click("sidemenu_logout_CSS");

			// wait for the element
			explicitWaitClickable("signinbtn_BTNTEXT");

			// LOGIN IN ADMIN USER
			title("LOGIN IN ADMIN USER");

			// Enter the username
			type("username_MODEL", data.get("username_1"));

			// Enter the password
			type("password_MODEL", data.get("password_1"));

			// Clicking on the "Sign In" button
			click("signinbtn_BTNTEXT");

			// wait for the element
			explicitWait("propertylist_title_XPATH");

			// verify the property list
			switchVerification("propertylist_title_XPATH", "Property List", "The property list is not displayed.");

		} catch (Throwable t) {
			helper.questionnaireNotDisplayLogout(data);
		}

		// click on the home icon from the top of the screen
		click("questionnaire_homeburgermenubtn_hide_CSS");

		// synchronization
		explicitWait("propertylist_title_XPATH");

		// verify the property list
		switchVerification("propertylist_title_XPATH", "Property List", "The property list is not displayed.");

		try {
			// wait for the 5 seconds
			Thread.sleep(5000);

			// click on the settings icon from the top of the screen
			click("questionnaire_settingicon_CSS");

			// wait for the element
			explicitWaitClickable("sidemenu_logout_CSS");

			// click on the logout option from the side menu
			click("sidemenu_logout_CSS");

			// wait for the element
			explicitWaitClickable("signinbtn_BTNTEXT");

		} catch (Throwable t) {
			verificationFailed();
		}
	}
}