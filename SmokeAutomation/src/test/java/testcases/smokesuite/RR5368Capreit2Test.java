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

		execution(data, "rR5368Capreit2Test");

		Helper helper = new Helper();

		// refresh the page
		driver.navigate().refresh();
		Thread.sleep(5000);
		driver.navigate().refresh();

		// PERFORM THE TEST CASES OF THE CAPREIT - PROPERTY MANAGER : OPEN TASKS FROM
		// PRIOR CHECKLIST INSTANCE MUST REMAIN VISIBLE (RR-2929)
		title("PERFORM THE TEST CASES OF THE CAPREIT - PROPERTY MANAGER : OPEN TASKS FROM PRIOR CHECKLIST INSTANCE MUST REMAIN VISIBLE (RR-2929)");

		try {
			// LOGIN WITH PROPERTY MANAGER USER
			title("LOGIN WITH PROPERTY MANAGER USER");

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

			// CREATE THE NEW INSPECTION AND CHECKLIST (PROPERTY WITH BUILDING) - PROPERTY
			// MANAGER
			title("CREATE THE NEW INSPECTION AND CHECKLIST (PROPERTY WITH BUILDING) - PROPERTY MANAGER");

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

				// click on the switch to wizard mode button
				click("checklist_classicviewbtn_CSS");

				// click on the no option of the 1st question
				click("checklist_wizard_nooption_CSS");

				// click on the back button
				click("questionnaire_checklist_backbtn_CSS");

				// enter newly created inspection in the search field
				type("task_listofchecklist_filterfield_CSS", data.get("checklist_property_title"));

				// verify submitted inspection is displayed or not
				switchVerification("questionnaire_checklist_createdinspectioncovid19_group_2_XPATH",
						"Test Questionnaire Property Title Group Smoke Capreit Two",
						"The Test Questionnaire Property Title Group Smoke Capreit Two is not displayed.");

			} catch (Throwable t) {
				verificationFailed();
			}

			// click on the home icon from the top of the screen
			click("questionnaire_homeburgermenubtn_hide_CSS");

			// synchronization
			explicitWait("propertylist_title_XPATH");

			// verify the property list
			switchVerification("propertylist_title_XPATH", "Property List", "The property list is not displayed.");

			// ADD THE TASK IN COVID 19 INSPECTION - PROPERTY MANAGER
			title("ADD THE TASK IN COVID 19 INSPECTION - PROPERTY MANAGER");

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

				// select property from the property drop down
				select("envreports_movereports_propertydd_CSS", data.get("building_leveldropdown"));

				// wait for 5 seconds
				Thread.sleep(5000);

				// enter newly created inspection in the search field
				type("task_listofchecklist_filterfield_CSS", data.get("checklist_property_title"));

				// click on the searched inspection
				click("questionnaire_checklist_createdinspectioncovid19_group_2_XPATH");

				// click on the switch to wizard mode button
				click("checklist_classicviewbtn_CSS");

				// click on the task tab
				click("inspectionchecklist_tasktab_XPATH");

				// click on the new task button
				click("checklist_newtaskbtn_CSS");

				// click on the task type field
				click("task_permission_task_tasktypetxt_CSS");

				// enter task type in the search field
				type("inspectionchecklist_tasktagsearchfield_CSS", data.get("tasktag"));

				// click on the searched task tag
				click("inspectionchecklist_tasktagsearchedresult_XPATH");

				// verify correct task title is displayed correct or not
				try {
					String taskTitle1 = driver.findElement(By.cssSelector(OR.getProperty("task_addtask_titletxt_CSS")))
							.getAttribute("value");

					if (taskTitle1.equals("Electrical (Light Fixture)")) {
						successMessage("THE CORRECT TASK TITLE IS DISPLAYED.");
					} else {
						verificationFailedMessage("The task title is not displayed correctly.");
					}

				} catch (Throwable t) {
					verificationFailedMessage("The task title is not displayed correctly.");
				}

				// click on the save task button
				click("survey_task_savebtn_CSS");

				// verify newly created task is displayed or not
				switchVerification("inspectionchecklist_tasktagcreatedtask_XPATH", "Electrical (Light Fixture)",
						"The Electrical (Light Fixture) is not displayed.");

			} catch (Throwable t) {
				verificationFailed();
			}

			// click on the Home button
			click("questionnaire_homeburgermenubtn_hide_CSS");

			// wait for the element
			explicitWait("propertylist_title_XPATH");

			// verify the property list
			switchVerification("propertylist_title_XPATH", "Property List", "The property list is not displayed.");

			try {

				// LOGOUT FROM PROPERTY MANAGER USER
				title("LOGOUT FROM PROPERTY MANAGER USER");

				// wait for 5 seconds
				Thread.sleep(5000);

				// click on the settings icon from the top of the screen
				click("questionnaire_settingicon_CSS");

				// wait for the element
				explicitWaitClickable("sidemenu_logout_CSS");

				// click on the logout option from the side menu
				click("sidemenu_logout_CSS");

				// wait for the element
				explicitWaitClickable("signinbtn_BTNTEXT");

				// LOGIN IN WITH OPERATION MANAGER USER
				title("LOGIN IN WITH OPERATION MANAGER USER");

				// Enter the username
				type("username_MODEL", data.get("username_2"));

				// Enter the password
				type("password_MODEL", data.get("password_2"));

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

			// CREATE THE NEW INSPECTION AND CHECKLIST (PROPERTY WITH BUILDING) - OPERATION
			// MANAGER
			title("CREATE THE NEW INSPECTION AND CHECKLIST (PROPERTY WITH BUILDING) - OPERATION MANAGER");

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
				select("checklist_addchecklist_checklisttypedd_CSS", data.get("questionnaire_checklist_om_title"));

				// enter data in the checklist title field
				type("checklist_addchecklist_titletxt_CSS", data.get("checklist_property_om_title"));

				// click on the save button
				click("checklist_addchecklist_savebtn_CSS");

				// click on the back button
				click("questionnaire_checklist_backbtn_CSS");

				// enter newly created inspection in the search field
				type("task_listofchecklist_filterfield_CSS", data.get("checklist_property_om_title"));

				// verify submitted inspection is displayed or not
				switchVerification("questionnaire_checklist_createdinspectioncovid19_groupom_2_XPATH",
						"Test Questionnaire Property Title Group OM Smoke Capreit Two",
						"The Test Questionnaire Property Title Group OM Smoke Capreit Two is not displayed.");

			} catch (Throwable t) {
				verificationFailed();
			}

			// click on the home icon from the top of the screen
			click("questionnaire_homeburgermenubtn_hide_CSS");

			// synchronization
			explicitWait("propertylist_title_XPATH");

			// verify the property list
			switchVerification("propertylist_title_XPATH", "Property List", "The property list is not displayed.");

			// VERIFY CREATED TASK IS DISPLAYED IN THE SAME GROUP OF INSPECTION - OPERATION
			// MANAGER
			title("VERIFY CREATED TASK IS DISPLAYED IN THE SAME GROUP OF INSPECTION - OPERATION MANAGER");

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

				// enter newly created inspection in the search field
				type("task_listofchecklist_filterfield_CSS", data.get("checklist_property_om_title"));

				// verify submitted inspection is displayed or not
				switchVerification("questionnaire_checklist_createdinspectioncovid19_groupom_2_XPATH",
						"Test Questionnaire Property Title Group OM Smoke Capreit Two",
						"The Test Questionnaire Property Title Group OM Smoke Capreit Two is not displayed.");

				// click on the searched inspection
				click("questionnaire_checklist_createdinspectioncovid19_groupom_2_XPATH");

				// click on the switch to wizard mode button
				click("checklist_classicviewbtn_CSS");

				// click on the task tab
				click("inspectionchecklist_tasktab_XPATH");

				// scroll down the screen
				scrollByPixel(400);

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

			// synchronization
			explicitWait("propertylist_title_XPATH");

			// verify the property list
			switchVerification("propertylist_title_XPATH", "Property List", "The property list is not displayed.");

			// LOGOUT FROM THE OPERATION MANAGER USER
			title("LOGOUT FROM THE OPERATION MANAGER USER");

			try {

				// wait for the 5 seconds
				Thread.sleep(5000);

				// click on the settings icon from the top of the screen
				click("questionnaire_settingicon_CSS");

				// wait for the element
				explicitWaitClickable("sidemenu_logout_CSS");

				// click on the logout option from the side menu
				click("sidemenu_logout_CSS");

				// LOGIN WITH PROPERTY MANAGER USER
				title("LOGIN WITH PROPERTY MANAGER USER");

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

			// COMPLETE THE INSPECTION - PROPERTY MANAGER USER
			title("COMPLETE THE INSPECTION - PROPERTY MANAGER USER");

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
				Thread.sleep(5000);

				// select property from the property drop down
				select("envreports_movereports_propertydd_CSS", data.get("building_leveldropdown"));

				// wait for 5 seconds
				Thread.sleep(5000);

				// enter newly created inspection in the search field

				type("task_listofchecklist_filterfield_CSS", data.get("checklist_property_title"));

				// click on the searched inspection
				click("questionnaire_checklist_createdinspectioncovid19_group_2_XPATH");

				// click on the switch to wizard mode button
				click("checklist_classicviewbtn_CSS");

				// click on the next button from the 1st question
				click("checklist_wizard_nextbtn_CSS");

				// click on the yes option of the 2nd question
				click("checklist_wizard_yesoption_CSS");

				// click on the next button from the 2nd question
				click("checklist_wizard_nextbtn_CSS");

				// click on the next button from the 3rd question
				click("checklist_wizard_nextbtn_CSS");

				// click on the next button from the 4th question
				click("checklist_wizard_nextbtn_CSS");

				// click on the next button from the 5th question
				click("checklist_wizard_nextbtn_CSS");

				// click on the back button
				click("questionnaire_checklist_backbtn_CSS");

				// enter newly created inspection in the search field

				type("task_listofchecklist_filterfield_CSS", data.get("checklist_property_title"));

				// verify submitted inspection is displayed or not
				switchVerification("questionnaire_checklist_createdinspectioncovid19_group_2_XPATH",
						"Test Questionnaire Property Title Group Smoke Capreit Two",
						"The Test Questionnaire Property Title Group Smoke Capreit Two is not displayed.");

			} catch (Throwable t) {
				verificationFailed();
			}

			// click on the home icon from the top of the screen
			click("questionnaire_homeburgermenubtn_hide_CSS");

			// synchronization
			explicitWait("propertylist_title_XPATH");

			// verify the property list
			switchVerification("propertylist_title_XPATH", "Property List", "The property list is not displayed.");

			// CLOSE THE NEWLY CREATED TASK - PROPERTY MANAGER USER
			title("CLOSE THE NEWLY CREATED TASK - PROPERTY MANAGER USER");

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

				// select property from the property drop down
				select("envreports_movereports_propertydd_CSS", data.get("building_leveldropdown"));

				// wait for 5 seconds
				Thread.sleep(5000);

				// enter newly created inspection in the search field
				type("task_listofchecklist_filterfield_CSS", data.get("checklist_property_title"));

				// click on the searched inspection
				click("questionnaire_checklist_createdinspectioncovid19_group_2_XPATH");

				// click on the switch to wizard mode button
				click("checklist_classicviewbtn_CSS");

				// click on the task tab
				click("inspectionchecklist_tasktab_XPATH");

				// scroll down the screen

				scrollByPixel(500);

				// click on the newly created task
				click("questionnaire_checklist_newlycreatedtask_capreit1_XPATH");

				// SET TASK AS A IN PROGRESS
				consoleMessage("SET TASK AS A IN PROGRESS");

				// wait for the element
				explicitWaitClickable("propertyproject_mu_repair_startbtn_CSS");

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

			// click on the home icon from the top of the screen
			click("questionnaire_homeburgermenubtn_hide_CSS");

			// wait for the element
			explicitWait("propertylist_title_XPATH");

			// verify the property list
			switchVerification("propertylist_title_XPATH", "Property List", "The property list is not displayed.");

			try {

				// LOGOUT FROM PROPERTY MANAGER USER
				title("LOGOUT FROM PROPERTY MANAGER USER");

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

				// LOGIN IN WITH OPERATION MANAGER USER
				title("LOGIN IN WITH OPERATION MANAGER USER");

				// Enter the username
				type("username_MODEL", data.get("username_2"));

				// Enter the password
				type("password_MODEL", data.get("password_2"));

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

			// VERIFY CLOSED TASK IS DISPLAYED IN THE SAME GROUP OF INSPECTION - OPERATION
			// MANAGER USER
			title("VERIFY CLOSED TASK IS DISPLAYED IN THE SAME GROUP OF INSPECTION - OPERATION MANAGER USER");

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
				Thread.sleep(7000);

				// click on the checklist/inspection option from side menu
				click("checklist_sidemenu_XPATH");

				// select building from the property drop down
				select("envreports_movereports_propertydd_CSS", data.get("building_leveldropdown"));

				// wait for 5 seconds
				Thread.sleep(5000);

				// enter newly created inspection in the search field

				type("task_listofchecklist_filterfield_CSS", data.get("checklist_property_om_title"));

				// verify submitted inspection is displayed or not
				switchVerification("questionnaire_checklist_createdinspectioncovid19_groupom_2_XPATH",
						"Test Questionnaire Property Title Group OM Smoke Capreit Two",
						"The Test Questionnaire Property Title Group OM Smoke Capreit Two is not displayed.");

				// click on the searched inspection
				click("questionnaire_checklist_createdinspectioncovid19_groupom_2_XPATH");

				// click on the switch to wizard mode button
				click("checklist_classicviewbtn_CSS");

				// click on the task tab
				click("inspectionchecklist_tasktab_XPATH");

				// scroll down the screen
				scrollByPixel(400);
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

					if (str1.equals("Electrical (Light Fixture)")) {
						verificationFailedMessage("The newly created task is not removed.");
					}

				} catch (Throwable t) {
					successMessage("The newly created task is removed successfully as expected.");
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

			// LOGOUT FROM THE OPERATION MANAGER USER
			title("LOGOUT FROM THE OPERATION MANAGER USER");

			try {

				// wait for the 5 seconds
				Thread.sleep(5000);

				// click on the settings icon from the top of the screen
				click("questionnaire_settingicon_CSS");

				// wait for the element
				explicitWaitClickable("sidemenu_logout_CSS");

				// click on the logout option from the side menu
				click("sidemenu_logout_CSS");

				// LOGIN WITH PROPERTY MANAGER USER
				title("LOGIN WITH PROPERTY MANAGER USER");

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

			// DELETE THE AUTO GENERATED TASK FROM THE TASK LIST - PROPERTY MANAGER USER
			title("DELETE THE AUTO GENERATED TASK FROM THE TASK LIST - PROPERTY MANAGER USER");

			try {

				// enter the property name in the search field
				type("envreports_propertylist_filtertxt_CSS", data.get("property_1"));

				// click on the task icon
				click("taskicon_CSS");

				// select building from the property drop down
				select("task_addedtask_propertybuildingdd_CSS", data.get("building_leveldropdown"));

				// click on the clear button
				click("task_createdtask_clearbtn_XPATH");

				// enter the data in the search field
				type("task_filter_CSS", data.get("task_title"));

				// click on the search button
				click("task_createdtask_searchbtn_XPATH");

				// verify newly created task is displayed or not
				switchVerification("task_createdtask_covid19autotask_XPATH", "Get safety plan on site",
						"The Get safety plan on site is not displayed.");

				// click on the auto generated task
				click("task_createdtask_covid19autotask_XPATH");

				// click on the delete button
				click("task_deletedtaskbtn_CSS");

				// synchronization
				explicitWait("task_deletedtaskbtn_confirmaiton_CSS");

				// click on the delete button of the confirmation popup
				click("task_deletedtaskbtn_confirmaiton_CSS");

				// wait for the element
				explicitWaitClickable("closetoastmsg_CSS");

				// click on the toaster close button
				click("closetoastmsg_CSS");

				// scroll up the screen

				scrollByPixel(-500);

				// click on the clear button
				click("task_createdtask_clearbtn_XPATH");

				// enter the data in the search field
				type("task_filter_CSS", data.get("task_title"));

				// click on the search button
				click("task_createdtask_searchbtn_XPATH");

				// verify the questionnaire deleted or not

				deleteVerification("task_createdtask_covid19autotask_XPATH", "Get safety plan on site");

			} catch (Throwable t) {
				verificationFailed();
			}

			// click on the home icon from the top of the screen
			click("questionnaire_homeburgermenubtn_hide_CSS");

			// synchronization
			explicitWait("propertylist_title_XPATH");

			// verify the property list
			switchVerification("propertylist_title_XPATH", "Property List", "The property list is not displayed.");

			// VERIFY DELETE TASK IS DISPLAYED IN THE RESPECTIVE INSPECTION OR NOT -
			// PROPERTY MANAGER USER
			title("VERIFY DELETE TASK IS DISPLAYED IN THE RESPECTIVE INSPECTION OR NOT - PROPERTY MANAGER USER");

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

				// enter newly created inspection in the search field
				type("task_listofchecklist_filterfield_CSS", data.get("checklist_property_title"));

				// verify submitted inspection is displayed or not
				switchVerification("questionnaire_checklist_createdinspectioncovid19_group_2_XPATH",
						"Test Questionnaire Property Title Group Smoke Capreit Two",
						"The Test Questionnaire Property Title Group Smoke Capreit Two is not displayed.");

				// click on the searched inspection
				click("questionnaire_checklist_createdinspectioncovid19_group_2_XPATH");

				// click on the switch to wizard mode button
				click("checklist_classicviewbtn_CSS");

				// click on the task tab
				click("inspectionchecklist_tasktab_XPATH");

				// scroll down the screen
				scrollByPixel(400);

				// verify deleted task is displayed or not
				deleteVerification("checklist_taskone_pending_capreitone_XPATH", "Pending");

			} catch (Throwable t) {
				verificationFailed();
			}

			// click on the home icon from the top of the screen
			click("questionnaire_homeburgermenubtn_hide_CSS");

			// synchronization
			explicitWait("propertylist_title_XPATH");

			// verify the property list
			switchVerification("propertylist_title_XPATH", "Property List", "The property list is not displayed.");

			try {

				// LOGOUT FROM PROPERTY MANAGER USER
				title("LOGOUT FROM PROPERTY MANAGER USER");

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

				// LOGIN IN WITH OPERATION MANAGER USER
				title("LOGIN IN WITH OPERATION MANAGER USER");

				// Enter the username
				type("username_MODEL", data.get("username_2"));

				// Enter the password
				type("password_MODEL", data.get("password_2"));

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

			// VERIFY AUTO GENERATED TASK IS DELETED IN THE SAME GROUP OF INSPECTION -
			// OPERATION MANAGER USER
			title("VERIFY AUTO GENERATED TASK IS DELETED IN THE SAME GROUP OF INSPECTION - OPERATION MANAGER USER");

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

				// enter newly created inspection in the search field

				type("task_listofchecklist_filterfield_CSS", data.get("checklist_property_om_title"));

				// verify submitted inspection is displayed or not
				switchVerification("questionnaire_checklist_createdinspectioncovid19_groupom_2_XPATH",
						"Test Questionnaire Property Title Group OM Smoke Capreit Two",
						"The Test Questionnaire Property Title Group OM Smoke Capreit Two is not displayed.");

				// click on the searched inspection
				click("questionnaire_checklist_createdinspectioncovid19_groupom_2_XPATH");

				// click on the switch to wizard mode button
				click("checklist_classicviewbtn_CSS");

				// click on the task tab
				click("inspectionchecklist_tasktab_XPATH");

				// scroll down the screen

				scrollByPixel(400);

				// verify deleted task is displayed or not
				deleteVerification("checklist_taskone_pending_capreitone_XPATH", "Pending");

			} catch (Throwable t) {
				verificationFailed();
			}

			// click on the home icon from the top of the screen
			click("questionnaire_homeburgermenubtn_hide_CSS");

			// synchronization
			explicitWait("propertylist_title_XPATH");

			// verify the property list
			switchVerification("propertylist_title_XPATH", "Property List", "The property list is not displayed.");

			// DELETE THE INSTANCES - OPERATION MANAGER USER
			title("DELETE THE INSTANCES - OPERATION MANAGER USER");

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

				// click on the action icon
				click("checklist_actionicon_CSS");

				// click on the delete option
				click("checklist_deleteoption_CSS");

				// click on the delete button
				click("checklist_deletebtn_CSS");

				// verify deleted inspection
				deleteVerification("questionnaire_checklist_createdinspectioncovid19_2_XPATH",
						"Test Questionnaire Property Title Smoke Capreit Two");

				// enter newly created inspection in the search field

				type("task_listofchecklist_filterfield_CSS", data.get("checklist_property_om_title"));

				// wait for the element
				explicitWaitClickable("checklist_actionicon_CSS");

				// click on the action icon
				click("checklist_actionicon_CSS");

				// wait for the element
				explicitWaitClickable("checklist_deleteoption_CSS");

				// click on the delete option
				click("checklist_deleteoption_CSS");

				// wait for the element
				explicitWaitClickable("checklist_deletebtn_CSS");

				// click on the delete button
				click("checklist_deletebtn_CSS");

				// verify deleted inspection
				deleteVerification("questionnaire_checklist_createdinspectioncovid19_groupom_2_XPATH",
						"Test Questionnaire Property Title Group OM Smoke Capreit Two");

			} catch (Throwable t) {
				verificationFailed();
			}

			// click on the home icon from the top of the screen
			click("questionnaire_homeburgermenubtn_hide_CSS");

			// wait for the element
			explicitWait("propertylist_title_XPATH");

			// verify the property list
			switchVerification("propertylist_title_XPATH", "Property List", "The property list is not displayed.");

			// LOGOUT FROM THE OPERATION MANAGER USER
			title("LOGOUT FROM THE OPERATION MANAGER USER");

			try {

				// wait for the 5 seconds
				Thread.sleep(5000);

				// click on the settings icon from the top of the screen
				click("questionnaire_settingicon_CSS");

				// wait for the element
				explicitWaitClickable("sidemenu_logout_CSS");

				// click on the logout option from the side menu
				click("sidemenu_logout_CSS");

				// LOGIN WITH PROPERTY MANAGER USER
				title("LOGIN WITH PROPERTY MANAGER USER");

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

			// DELETE THE NEWLY CREATED TASK - PROPERTY MANAGER USER
			title("DELETE THE NEWLY CREATED TASK - PROPERTY MANAGER USER");

			try {

				// enter the property name in the search field
				type("envreports_propertylist_filtertxt_CSS", data.get("property_1"));

				// click on the task icon
				click("taskicon_CSS");

				// select building from the property drop down
				select("task_addedtask_propertybuildingdd_CSS", data.get("building_leveldropdown"));

				// select the close option from the dropdown
				select("survey_task_closefilter_CSS", data.get("task_closed_status"));

				// click on the clear button
				click("task_createdtask_clearbtn_XPATH");

				// enter the data in the search field
				type("task_filter_CSS", data.get("tasktag"));

				// click on the search button
				click("task_createdtask_searchbtn_XPATH");

				// verify newly created task is displayed or not
				switchVerification("task_createdtask_covid19addedtask_XPATH", "Electrical (Light Fixture)",
						"The Electrical (Light Fixture) is not displayed.");

				// click on the newly created task
				click("task_createdtask_covid19addedtask_XPATH");

				// click on the reopen button
				click("riskmanagement_task_reopenbtn_XPATH");

				// wait for the element
				explicitWaitClickable("closetoastmsg_CSS");

				// click on the toaster close button
				click("closetoastmsg_CSS");

				// wait for the element
				Thread.sleep(5000);

				// click on the delete button
				click("task_deletedtaskbtn_CSS");

				// synchronization
				explicitWait("task_deletedtaskbtn_confirmaiton_CSS");

				// click on the delete button of the confirmation popup
				click("task_deletedtaskbtn_confirmaiton_CSS");

				// wait for the element
				explicitWaitClickable("closetoastmsg_CSS");

				// click on the toaster close button
				click("closetoastmsg_CSS");

				// scroll up the screen

				scrollByPixel(-500);

				// click on the clear button
				click("task_createdtask_clearbtn_XPATH");

				// enter the data in the search field
				type("task_filter_CSS", data.get("task_title"));

				// click on the search button
				click("task_createdtask_searchbtn_XPATH");

				// verify the questionnaire deleted or not

				deleteVerification("task_createdtask_covid19addedtask_XPATH", "Electrical (Light Fixture)");

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