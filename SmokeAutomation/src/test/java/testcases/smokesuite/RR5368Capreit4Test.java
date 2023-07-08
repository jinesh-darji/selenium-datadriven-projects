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

public class RR5368Capreit4Test extends TestBase {

	@Test(dataProviderClass = TestUtil.class, dataProvider = "dp")
	public void rR5368Capreit4Test(Hashtable<String, String> data) throws IOException, InterruptedException {

		execution(data, "rR5368Capreit4Test");

		Helper helper = new Helper();

		// refresh the page
		driver.navigate().refresh();
		Thread.sleep(5000);
		driver.navigate().refresh();

		// PROPERTY SUMMARY DASHBOARDS - OPERATION MANAGER
		title("PROPERTY SUMMARY DASHBOARDS - OPERATION MANAGER");

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

			// CREATE THE NEW INSPECTION AND CHECKLIST - OPERATION
			// MANAGER
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

				// wait for 5 seconds
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
						.findElement(By.xpath(OR.getProperty("checklist_wizard_inspectiontitle4_XPATH"))).getText();

				consoleMessage("COVID 19 INSTECTION TITLE : " + covidtxt);

				switchVerification("checklist_wizard_inspectiontitle4_XPATH",
						"Test Questionnaire Property Title Smoke Capreit Four",
						"The Test Questionnaire Property Title Smoke Capreit Four is not displayed.");

			} catch (Throwable t) {
				verificationFailed();
			}

			// click on the home icon from the top of the screen
			click("questionnaire_homeburgermenubtn_hide_CSS");

			// synchronization
			explicitWait("propertylist_title_XPATH");

			// verify the property list
			switchVerification("propertylist_title_XPATH", "Property List", "The property list is not displayed.");

			// VERIFY THE NEWLY CREATED INSPECTION IN PROPERTY SUMMARY DASHBOARD
			title("VERIFY THE NEWLY CREATED INSPECTION IN PROPERTY SUMMARY DASHBOARD");

			try {
				// enter the property name in the search field
				type("envreports_propertylist_filtertxt_CSS", data.get("property_1"));

				// click on the property
				click("task_navigation_property1_CSS");

				// scroll down the screen
				scrollTillElement("propertysummary_inspection_instectiontitle_XPATH");

				// VERIFY THE INSPECTION STATUS INDICATOR
				successMessage("VERIFY THE INSPECTION STATUS INDICATOR");

				try {
					// verify red circle is displayed or not
					boolean redCircle = driver
							.findElement(By.xpath(OR.getProperty("propertysummary_inspectionred_redcircle_XPATH")))
							.isDisplayed();

					if (redCircle == true) {
						successMessage("The red circle is displayed for the newly created checklist.");
					} else {
						verificationFailedMessage("The red circle is not displayed for the newly created checklist.");
					}
				} catch (Throwable t) {
					verificationFailed();
				}

				// VERIFY THE INSPECTION COMPLETED DATE
				title("VERIFY THE INSPECTION COMPLETED DATE");

				try {

					String expiredDate = driver
							.findElement(By.xpath(OR.getProperty("propertysummary_inspectionred_expireddate_XPATH")))
							.getText();

					if (expiredDate.equals("-")) {
						successMessage("The completed date is displayed for the newly created checklist.");
					} else {
						verificationFailedMessage(
								"The completed date is not displayed for the newly created checklist.");
					}
				} catch (Throwable t) {
					verificationFailed();
				}

				// click on the newly created inspection
				driver.findElement(By.xpath("//td[text()='" + data.get("questionnaire_checklist_title") + "']"))
						.click();

				// VERIFY NEWLY CREATED INSPECTION IS DISPLAYED CORRECTLY OR NOT IN THE
				// INSPECTION LIST
				title("VERIFY NEWLY CREATED INSPECTION IS DISPLAYED CORRECTLY OR NOT IN THE INSPECTION LIST");

				// select building from the property drop down
				select("envreports_movereports_propertydd_CSS", data.get("building_leveldropdown"));

				// enter the inspection name in the search field

				type("task_listofchecklist_filterfield_CSS", data.get("checklist_property_title"));

				// verify newly created inspection is displayed or not
				switchVerification("inspection_createdinspection4_XPATH",
						"Test Questionnaire Property Title Smoke Capreit Four",
						"The Test Questionnaire Property Title Smoke Capreit Four is not displayed");

				// click on the back to dashboard button
				click("inspection_backtodashboardbtn_CSS");

				// VERIFY CORRECT NAVIGATION IS OCCURED OR NOT
				switchVerification("inspection_tasksection_XPATH", "Tasks", "The Tasks is not displayed");

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

				// wait for 5 seconds
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
				click("inspection_createdinspection4_XPATH");

				// click on the switch to wizard mode button
				click("checklist_classicviewbtn_CSS");

				// click on the yes option of the 1st question
				click("checklist_wizard_yesoption_CSS");

				// click on the back button
				click("questionnaire_checklist_backbtn_CSS");

				// enter newly created inspection in the search field

				type("task_listofchecklist_filterfield_CSS", data.get("checklist_property_title"));

				// verify submitted inspection is displayed or not
				switchVerification("inspection_createdinspection4_XPATH",
						"Test Questionnaire Property Title Smoke Capreit Four",
						"The Test Questionnaire Property Title Smoke Capreit Four is not displayed.");

			} catch (Throwable t) {
				verificationFailed();
			}

			// click on the home icon from the top of the screen
			click("questionnaire_homeburgermenubtn_hide_CSS");

			// synchronization
			explicitWait("propertylist_title_XPATH");

			// verify the property list
			switchVerification("propertylist_title_XPATH", "Property List", "The property list is not displayed.");

			// VERIFY THE INPROGRESS INSPECTION IN PROPERTY SUMMARY DASHBOARD
			title("VERIFY THE INPROGRESS INSPECTION IN PROPERTY SUMMARY DASHBOARD");

			try {
				// enter the property name in the search field
				type("envreports_propertylist_filtertxt_CSS", data.get("property_1"));

				// click on the property
				click("task_navigation_property1_CSS");

				// scroll down the screen
				scrollTillElement("propertysummary_inspection_instectiontitle_XPATH");

				// VERIFY THE INSPECTION STATUS INDICATOR
				consoleMessage("VERIFY THE INSPECTION STATUS INDICATOR");

				try {
					// verify red circle is displayed or not
					boolean redCircle = driver
							.findElement(By.xpath(OR.getProperty("propertysummary_inspectionred_redcircle_XPATH")))
							.isDisplayed();

					if (redCircle == true) {
						successMessage("The red circle is displayed for the newly created checklist.");
					} else {
						verificationFailedMessage("The red circle is not displayed for the newly created checklist.");
					}
				} catch (Throwable t) {
					verificationFailed();
				}

				// VERIFY THE INSPECTION COMPLETED DATE
				consoleMessage("VERIFY THE INSPECTION COMPLETED DATE");

				try {

					String expiredDate = driver
							.findElement(By.xpath(OR.getProperty("propertysummary_inspectionred_expireddate_XPATH")))
							.getText();

					if (expiredDate.equals("-")) {
						successMessage("The completed date is displayed for the newly created checklist.");
					} else {
						verificationFailedMessage(
								"The completed date is not displayed for the newly created checklist.");
					}
				} catch (Throwable t) {
					verificationFailed();
				}

				// click on the newly created inspection
				driver.findElement(By.xpath("//td[text()='" + data.get("questionnaire_checklist_title") + "']"))
						.click();

				// VERIFY NEWLY CREATED INSPECTION IS DISPLAYED CORRECTLY OR NOT IN THE
				// INSPECTION LIST
				title("VERIFY NEWLY CREATED INSPECTION IS DISPLAYED CORRECTLY OR NOT IN THE INSPECTION LIST");

				// select building from the property drop down
				select("envreports_movereports_propertydd_CSS", data.get("building_leveldropdown"));

				// enter the inspection name in the search field
				type("task_listofchecklist_filterfield_CSS", data.get("checklist_property_title"));

				// verify newly created inspection is displayed or not
				switchVerification("inspection_createdinspection4_XPATH",
						"Test Questionnaire Property Title Smoke Capreit Four",
						"The Test Questionnaire Property Title Smoke Capreit Four is not displayed");

				// click on the back to dashboard button
				click("inspection_backtodashboardbtn_CSS");

				// VERIFY CORRECT NAVIGATION IS OCCURED OR NOT
				switchVerification("inspection_tasksection_XPATH", "Tasks", "The Tasks is not displayed");

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

				// wait for 5 seconds
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
				click("inspection_createdinspection4_XPATH");

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
				click("checklist_backbtn_CSS");

				// enter newly created inspection in the search field

				type("task_listofchecklist_filterfield_CSS", data.get("checklist_property_title"));

				// verify submitted inspection is displayed or not
				switchVerification("inspection_createdinspection4_XPATH",
						"Test Questionnaire Property Title Smoke Capreit Four",
						"The Test Questionnaire Property Title Smoke Capreit Four is not displayed.");

			} catch (Throwable t) {
				verificationFailed();
			}

			// click on the home icon from the top of the screen
			click("questionnaire_homeburgermenubtn_hide_CSS");

			// synchronization
			explicitWait("propertylist_title_XPATH");

			// verify the property list
			switchVerification("propertylist_title_XPATH", "Property List", "The property list is not displayed.");

			// VERIFY THE COMPLETED INSPECTION IN PROPERTY SUMMARY DASHBOARD
			title("VERIFY THE COMPLETED INSPECTION IN PROPERTY SUMMARY DASHBOARD");

			try {
				// enter the property name in the search field
				type("envreports_propertylist_filtertxt_CSS", data.get("property_1"));

				// click on the property
				click("task_navigation_property1_CSS");

				// scroll down the screen
				scrollTillElement("propertysummary_inspection_instectiontitle_XPATH");

				// VERIFY THE INSPECTION STATUS INDICATOR
				consoleMessage("VERIFY THE INSPECTION STATUS INDICATOR");

				try {
					// verify red circle is displayed or not
					boolean redCircle = driver
							.findElement(By.xpath(OR.getProperty("propertysummary_inspectionred_redcircle_XPATH")))
							.isDisplayed();

					if (redCircle == true) {
						successMessage("The red circle is displayed for the newly created checklist.");
					} else {
						verificationFailedMessage("The red circle is not displayed for the newly created checklist.");
					}
				} catch (Throwable t) {
					verificationFailed();
				}

				// VERIFY THE INSPECTION COMPLETED DATE
				consoleMessage("VERIFY THE INSPECTION COMPLETED DATE");

				try {

					String expiredDate = driver
							.findElement(By.xpath(OR.getProperty("propertysummary_inspectionred_expireddate_XPATH")))
							.getText();

					if (expiredDate.equals("-")) {
						successMessage("The completed date is displayed for the newly created checklist.");
					} else {
						verificationFailedMessage(
								"The completed date is not displayed for the newly created checklist.");
					}
				} catch (Throwable t) {
					verificationFailed();
				}

				// click on the newly created inspection
				driver.findElement(By.xpath("//td[text()='" + data.get("questionnaire_checklist_title") + "']"))
						.click();

				// VERIFY NEWLY CREATED INSPECTION IS DISPLAYED CORRECTLY OR NOT IN THE
				// INSPECTION LIST
				title("VERIFY NEWLY CREATED INSPECTION IS DISPLAYED CORRECTLY OR NOT IN THE INSPECTION LIST");

				// select building from the property drop down
				select("envreports_movereports_propertydd_CSS", data.get("building_leveldropdown"));

				// enter the inspection name in the search field
				type("task_listofchecklist_filterfield_CSS", data.get("checklist_property_title"));

				// verify newly created inspection is displayed or not
				switchVerification("inspection_createdinspection4_XPATH",
						"Test Questionnaire Property Title Smoke Capreit Four",
						"The Test Questionnaire Property Title Smoke Capreit Four is not displayed");

				// click on the back to dashboard button
				click("inspection_backtodashboardbtn_CSS");

				// VERIFY CORRECT NAVIGATION IS OCCURED OR NOT
				switchVerification("inspection_tasksection_XPATH", "Tasks", "The Tasks is not displayed");

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

				// wait for 5 seconds
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
				click("inspection_createdinspection4_XPATH");

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

				// wait for 5 seconds
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
				click("inspection_createdinspection4_XPATH");

				// wait for 3 seconds
				Thread.sleep(3000);

				// click on the switch to wizard mode button
				click("checklist_classicviewbtn_CSS");

				// wait for 3 seconds
				Thread.sleep(3000);

				// click on the task tab
				click("inspectionchecklist_tasktab_XPATH");

				// click on the newly created task
				click("inspectionchecklist_tasktagcreatedtask_XPATH");

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
				click("task_autotask_actionicon_XPATH");

				// click on the complete task option
				click("task_addtask_approvedlbl_actionicon_closeoption_XPATH");

				// wait for the element
				explicitWaitClickable("closetoastmsg_CSS");

				// click on the toaster close button
				click("closetoastmsg_CSS");

				// verify in closed status is display
				switchVerification("checklist_tasktwo_closed_capreitone_XPATH", "Closed",
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

			// VERIFY THE INSPECTION WITH CLOSED TASK IN PROPERTY SUMMARY DASHBOARD
			title("VERIFY THE INSPECTION WITH CLOSED TASK IN PROPERTY SUMMARY DASHBOARD");

			try {
				// enter the property name in the search field
				type("envreports_propertylist_filtertxt_CSS", data.get("property_1"));

				// click on the property
				click("task_navigation_property1_CSS");

				// scroll down the screen
				scrollTillElement("propertysummary_inspection_instectiontitle_XPATH");

				// VERIFY THE INSPECTION STATUS INDICATOR
				consoleMessage("VERIFY THE INSPECTION STATUS INDICATOR");

				try {
					// verify red circle is displayed or not
					boolean redCircle = driver
							.findElement(By.xpath(OR.getProperty("propertysummary_inspectionred_redcircle_XPATH")))
							.isDisplayed();

					if (redCircle == true) {
						successMessage("The red circle is displayed for the newly created checklist.");
					} else {
						verificationFailedMessage("The red circle is not displayed for the newly created checklist.");
					}
				} catch (Throwable t) {
					verificationFailed();
				}

				// VERIFY THE INSPECTION COMPLETED DATE
				consoleMessage("VERIFY THE INSPECTION COMPLETED DATE");

				try {

					String expiredDate = driver
							.findElement(By.xpath(OR.getProperty("propertysummary_inspectionred_expireddate_XPATH")))
							.getText();

					if (expiredDate.equals("-")) {
						successMessage("The completed date is displayed for the newly created checklist.");
					} else {
						verificationFailedMessage(
								"The completed date is not displayed for the newly created checklist.");
					}
				} catch (Throwable t) {
					verificationFailed();
				}

				// click on the newly created inspection
				driver.findElement(By.xpath("//td[text()='" + data.get("questionnaire_checklist_title") + "']"))
						.click();

				// VERIFY NEWLY CREATED INSPECTION IS DISPLAYED CORRECTLY OR NOT IN THE
				// INSPECTION LIST
				successMessage("VERIFY NEWLY CREATED INSPECTION IS DISPLAYED CORRECTLY OR NOT IN THE INSPECTION LIST");

				// select building from the property drop down
				select("envreports_movereports_propertydd_CSS", data.get("building_leveldropdown"));

				// enter the inspection name in the search field
				type("task_listofchecklist_filterfield_CSS", data.get("checklist_property_title"));

				// verify newly created inspection is displayed or not
				switchVerification("inspection_createdinspection4_XPATH",
						"Test Questionnaire Property Title Smoke Capreit Four",
						"The Test Questionnaire Property Title Smoke Capreit Four is not displayed");

				// click on the back to dashboard button
				click("inspection_backtodashboardbtn_CSS");

				// VERIFY CORRECT NAVIGATION IS OCCURED OR NOT
				switchVerification("inspection_tasksection_XPATH", "Tasks", "The Tasks is not displayed");

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

				// wait for 5 seconds
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
				click("inspection_createdinspection4_XPATH");

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
				switchVerification("inspection_createdinspection4_XPATH",
						"Test Questionnaire Property Title Smoke Capreit Four",
						"The Test Questionnaire Property Title Smoke Capreit Four is not displayed.");

			} catch (Throwable t) {
				verificationFailed();
			}

			// click on the home icon from the top of the screen
			click("questionnaire_homeburgermenubtn_hide_CSS");

			// synchronization
			explicitWait("propertylist_title_XPATH");

			// verify the property list
			switchVerification("propertylist_title_XPATH", "Property List", "The property list is not displayed.");

			// VERIFY THE SUBMITTED INSPECTION WITH CLOSED TASK IN PROPERTY SUMMARY
			// DASHBOARD
			title("VERIFY THE SUBMITTED INSPECTION WITH CLOSED TASK IN PROPERTY SUMMARY DASHBOARD");

			try {
				// enter the property name in the search field
				type("envreports_propertylist_filtertxt_CSS", data.get("property_1"));

				// click on the property
				click("task_navigation_property1_CSS");

				// scroll down the screen
				scrollTillElement("propertysummary_inspection_instectiontitle_XPATH");

				// VERIFY THE INSPECTION STATUS INDICATOR
				consoleMessage("VERIFY THE INSPECTION STATUS INDICATOR");

				try {
					// verify green circle is displayed or not
					boolean greenCircle = driver
							.findElement(By.xpath(OR.getProperty("propertysummary_inspectionred_greencircle_XPATH")))
							.isDisplayed();

					if (greenCircle == true) {
						successMessage("The green circle is displayed for the newly created checklist.");
					} else {
						verificationFailedMessage("The green circle is not displayed for the newly created checklist.");
					}
				} catch (Throwable t) {
					verificationFailed();
				}

				// VERIFY THE INSPECTION COMPLETED DATE
				consoleMessage("VERIFY THE INSPECTION COMPLETED DATE");

				try {

					LocalDate currentDate = LocalDate.now();
					String currentDateText = currentDate.toString();

					String expiredDate = driver
							.findElement(By.xpath(OR.getProperty("propertysummary_inspectionred_expireddate_XPATH")))
							.getText();

					if (expiredDate.equals(currentDateText)) {
						successMessage("The completed date is displayed for the newly created checklist.");
					} else {
						verificationFailedMessage(
								"The completed date is not displayed for the newly created checklist.");
					}
				} catch (Throwable t) {
					verificationFailed();
				}

				// click on the newly created inspection
				driver.findElement(By.xpath("//td[text()='" + data.get("questionnaire_checklist_title") + "']"))
						.click();

				// VERIFY NEWLY CREATED INSPECTION IS DISPLAYED CORRECTLY OR NOT IN THE
				// INSPECTION LIST
				consoleMessage("VERIFY NEWLY CREATED INSPECTION IS DISPLAYED CORRECTLY OR NOT IN THE INSPECTION LIST");

				// select building from the property drop down
				select("envreports_movereports_propertydd_CSS", data.get("building_leveldropdown"));

				// enter the inspection name in the search field
				type("task_listofchecklist_filterfield_CSS", data.get("checklist_property_title"));

				// verify newly created inspection is displayed or not
				switchVerification("inspection_createdinspection4_XPATH",
						"Test Questionnaire Property Title Smoke Capreit Four",
						"The Test Questionnaire Property Title Smoke Capreit Four is not displayed");

				// click on the back to dashboard button
				click("inspection_backtodashboardbtn_CSS");

				// VERIFY CORRECT NAVIGATION IS OCCURED OR NOT
				switchVerification("inspection_tasksection_XPATH", "Tasks", "The Tasks is not displayed");

			} catch (Throwable t) {
				verificationFailed();
			}

			// click on the home icon from the top of the screen
			click("questionnaire_homeburgermenubtn_hide_CSS");

			// synchronization
			explicitWait("propertylist_title_XPATH");

			// verify the property list
			switchVerification("propertylist_title_XPATH", "Property List", "The property list is not displayed.");

			// DELETE THE CLOSED TASK
			title("DELETE THE CLOSED TASK");

			try {
				// enter the property name in the search field
				type("envreports_propertylist_filtertxt_CSS", data.get("property_1"));

				// click on the environmental icon from the property list page
				click("environmentalicon_CSS");

				// wait for the element
				Thread.sleep(5000);

				// click on the burger menu
				click("menubtn_CSS");

				// wait for 5 seconds
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
				click("inspection_createdinspection4_XPATH");

				// wait for 3 seconds
				Thread.sleep(3000);

				// click on the switch to wizard mode button
				click("checklist_classicviewbtn_CSS");

				// wait for 3 seconds
				Thread.sleep(3000);

				// click on the task tab
				click("inspectionchecklist_tasktab_XPATH");

				// click on the action icon of the closed task
				click("task_addtask_actionicon_XPATH");

				// click on the reopen option
				click("task_addtask_approvedlbl_actionicon_reopenoption_XPATH");

				// wait for the element
				explicitWaitClickable("closetoastmsg_CSS");

				// click on the toaster close button
				click("closetoastmsg_CSS");

				// click on the action icon of the closed task
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

			// DELETE THE INSTANCE
			title("DELETE THE INSTANCE");

			try {
				// enter the property name in the search field
				type("envreports_propertylist_filtertxt_CSS", data.get("property_1"));

				// click on the environmental icon from the property list page
				click("environmentalicon_CSS");

				// wait for the element
				Thread.sleep(5000);

				// click on the burger menu
				click("menubtn_CSS");

				// wait for 5 seconds
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
				deleteVerification("inspection_createdinspection4_XPATH",
						"Test Questionnaire Property Title Smoke Capreit Four");

			} catch (Throwable t) {
				verificationFailed();
			}

			// click on the Home button
			click("questionnaire_homeburgermenubtn_hide_CSS");

			// wait for the element
			explicitWait("propertylist_title_XPATH");

			// verify the property list
			switchVerification("propertylist_title_XPATH", "Property List", "The property list is not displayed.");

			// VERIFY THE DELETED INSPECTION IN PROPERTY SUMMARY DASHBOARD
			title("VERIFY THE DELETED INSPECTION IN PROPERTY SUMMARY DASHBOARD");

			try {
				// enter the property name in the search field
				type("envreports_propertylist_filtertxt_CSS", data.get("property_1"));

				// click on the property
				click("task_navigation_property1_CSS");

				// scroll down the screen
				scrollTillElement("propertysummary_inspection_instectiontitle_XPATH");

				// VERIFY THE INSPECTION STATUS INDICATOR
				title("VERIFY THE INSPECTION STATUS INDICATOR");

				try {
					// verify red circle is displayed or not
					boolean redCircle = driver
							.findElement(By.xpath(OR.getProperty("propertysummary_inspectionred_redcircle_XPATH")))
							.isDisplayed();

					if (redCircle == true) {
						successMessage("The red circle is displayed for the newly created checklist.");
					} else {
						verificationFailedMessage("The red circle is not displayed for the newly created checklist.");
					}
				} catch (Throwable t) {
					verificationFailed();
				}

				// VERIFY THE INSPECTION COMPLETED DATE
				consoleMessage("VERIFY THE INSPECTION COMPLETED DATE");

				try {

					String expiredDate = driver
							.findElement(By.xpath(OR.getProperty("propertysummary_inspectionred_expireddate_XPATH")))
							.getText();

					if (expiredDate.equals("-")) {
						successMessage("The completed date is displayed for the newly created checklist.");
					} else {
						verificationFailedMessage(
								"The completed date is not displayed for the newly created checklist.");
					}
				} catch (Throwable t) {
					verificationFailed();
				}
			} catch (Throwable t) {
				verificationFailed();
			}

			// click on the home icon from the top of the screen
			click("questionnaire_homeburgermenubtn_hide_CSS");

			// wait for the element
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