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

		execution(data, "rR5368Capreit6Test");

		// refresh the page
		driver.navigate().refresh();
		Thread.sleep(5000);
		driver.navigate().refresh();

		// TASK TAGS SELECTED FOR AUTO TASKS SHOULD BE MAINTAINED AND ALSO FILTERING
		// PROPERLY - RR-5321
		title("TASK TAGS SELECTED FOR AUTO TASKS SHOULD BE MAINTAINED AND ALSO FILTERING PROPERLY - RR-5321");

		// LOGIN WITH ADMIN USER
		title("LOGIN WITH ADMIN USER");

		// wait for the element
		explicitWaitClickable("signinbtn_BTNTEXT");

		// Enter the username
		type("usernametxt_CSS", data.get("username_1"));

		// Enter the password
		type("passwordtxt_CSS", data.get("password_1"));

		// Clicking on the "Sign In" button
		click("signinbtn_BTNTEXT");

		// wait for the element
		explicitWait("propertylist_title_XPATH");

		// verify the property list
		switchVerification("propertylist_title_XPATH", "Property List", "The property list is not displayed.");

		// UPDATE THE SYSTEM COMPANY
		updateCompany(data);

		// CREATE THE NEW INSPECTION AND CHECKLIST (PROPERTY WITH BUILDING) - ADMIN
		title("CREATE THE NEW INSPECTION AND CHECKLIST (PROPERTY WITH BUILDING) - ADMIN");

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

			// select building from the property drop down
			select("envreports_movereports_propertydd_CSS", data.get("building_leveldropdown"));

			// wait for 5 seconds
			Thread.sleep(5000);

			// click on the new checklist button
			click("checklist_newchecklistbtn_CSS");

			// select the questionnaire option from the checklist type dropdown
			select("checklist_addchecklist_checklisttypedd_CSS", data.get("questionnaire_checklist_title"));

			// enter data in the checklist title field
			type("checklist_addchecklist_titletxt_CSS", data.get("checklist_property_title"));

			// click on the save button
			click("checklist_addchecklist_savebtn_CSS");

			// verify questionnaire is selected correctly or not

			String covidtxt = driver.findElement(By.xpath(OR.getProperty("checklist_wizard_inspectiontitle6_XPATH")))
					.getText();
			consoleMessage("COVID 19 INSTECTION TITLE : " + covidtxt);
			switchVerification("checklist_wizard_inspectiontitle6_XPATH",
					"Test Questionnaire Property Title Smoke Capreit Six",
					"The Test Questionnaire Property Title Smoke Capreit Six is not displayed.");

		} catch (Throwable t) {
			verificationFailed();
		}

		// click on the home icon from the top of the screen
		click("questionnaire_homeburgermenubtn_hide_CSS");

		// synchronization
		explicitWait("propertylist_title_XPATH");

		// verify the property list
		switchVerification("propertylist_title_XPATH", "Property List", "The property list is not displayed.");

		// GENERATE THE AUTO TASK IN THE INSPECTION - OPERATION MANAGER
		title("GENERATE THE AUTO TASK IN THE INSPECTION - OPERATION MANAGER");

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
			click("questionnaire_checklist_createdinspectioncovid19_6_XPATH");

			// click on the switch to wizard mode button
			click("checklist_classicviewbtn_CSS");

			// click on the no option of the 1st question
			click("checklist_wizard_nooption_CSS");

			// click on the back button
			click("questionnaire_checklist_backbtn_CSS");

			// enter newly created inspection in the search field

			type("task_listofchecklist_filterfield_CSS", data.get("checklist_property_title"));

			// verify submitted inspection is displayed or not
			switchVerification("questionnaire_checklist_createdinspectioncovid19_6_XPATH",
					"Test Questionnaire Property Title Smoke Capreit Six",
					"The Test Questionnaire Property Title Smoke Capreit Six is not displayed.");

		} catch (Throwable t) {
			verificationFailed();
		}

		// click on the home icon from the top of the screen
		click("questionnaire_homeburgermenubtn_hide_CSS");

		// synchronization
		explicitWait("propertylist_title_XPATH");

		// verify the property list
		switchVerification("propertylist_title_XPATH", "Property List", "The property list is not displayed.");

		// VERIFY TASK TAG IS DISPLAYED CORRECTLY IN FILTER LIST OT NOT
		title("VERIFY TASK TAG IS DISPLAYED CORRECTLY IN FILTER LIST OT NOT");

		try {

			// wait for the 5 seconds
			Thread.sleep(5000);

			// click on the side menu
			click("ssc_leftsidemenubtn_CSS");

			// wait for the 5 seconds
			Thread.sleep(5000);

			// click on the inspection/checklist option
			click("ssc_sidemenubtn_inspectionchecklistoption_XPATH");

			// wait for the 3 seconds
			Thread.sleep(3000);

			// click on the dropdown icon
			click("inspectionchecklist_dashboard_dropdownicon_XPATH");

			// click on the inspection history
			click("inspectionchecklist_dashboard_inspectionhistory_XPATH");

			// wait for the element
			explicitWaitClickable("portfoliosummary_inspection2_inspectionlist_opentaskcont_XPATH");

			// click on the open task number
			click("portfoliosummary_inspection2_inspectionlist_opentaskcont_XPATH");

			// enter the task name in the search field

			type("task_tasklist_searchtxt_CSS", data.get("task_title"));

			// click on the task title
			click("task_createdtask_covid19autotask_dashboard_XPATH");

			// scroll down the screen
			scrollTillElement("task_createdtask_tagslabel_XPATH");

			// click on the tags field
			click("task_createdtask_tagstxt_CSS");

			// scroll down the screen
			scrollByPixel(400);

			// click on the none button
			click("task_tasktag_nonebtn_CSS");

			// click on the tags field
			click("task_createdtask_tagstxt_CSS");

			// click on the update button
			click("task_tasktag_taskscreen_updatebtn_CSS");

			// wait for the element
			explicitWaitClickable("closetoastmsg_CSS");

			// click on the toaster close button
			click("closetoastmsg_CSS");

			// click on the task tag field for filter the records
			click("task_tasklist_tagfilter_tagtxt_XPATH");

			// enter the task tag name in the search field for filter the record
			type("task_tasklist_tagfilter_tagtxt_searchtxt_XPATH", data.get("task_tag_name_1"));

//			// VERIFY COMPLIANCE OPTION DISPLAYED SELECTED OR NOT IN THE TASK TAG FIELD OF
//			// THE FILTER
//			consoleMessage("VERIFY COMPLIANCE OPTION DISPLAYED SELECTED OR NOT IN THE TASK TAG FIELD OF THE FILTER");
//
//			try {
//
//				boolean selectedTaskTag = driver
//						.findElement(By.xpath(OR.getProperty("task_tasklist_tagfilter_selectedoptionwithicon_XPATH")))
//						.isDisplayed();
//
//				if (selectedTaskTag == true) {
//					verificationFailedMessage("The compliance task tag option is displayed selected in the task tag field of the filter.");
//
//				} else {
//					successMessage(
//							"The compliance task tag option is not displayed selected in the task tag field of the filter as expected.");
//				}
//
//			} catch (Throwable t) {
//				successMessage(
//						"The compliance task tag option is not displayed selected in the task tag field of the filter as expected.");
//			}

			try {

				// enter the task tag name in the search field
				type("task_tasklist_tagfilter_tagtxt_searchtxt_XPATH", data.get("task_tag_name_2"));

//				// VERIFY UNDEFINED OPTION DISPLAYED SELECTED OR NOT IN THE TASK TAG FIELD OF
//				// THE FILTER
//				consoleMessage("VERIFY UNDEFINED OPTION DISPLAYED SELECTED OR NOT IN THE TASK TAG FIELD OF THE FILTER");
//
//				boolean selectedTaskTag2 = driver
//						.findElement(By.xpath(OR.getProperty("task_tasklist_tagfilter_undefined_XPATH"))).isDisplayed();
//
//				if (selectedTaskTag2 == true) {
//					verificationFailedMessage("The undefined task tag option is displayed in the task tag field of the filter.");
//				} else {
//					successMessage(
//							"The undefined task tag option is not displayed in the task tag field of the filter as expected.");
//				}
//
			} catch (Throwable t) {
				successMessage(
						"The undefined task tag option is not displayed in the task tag field of the filter as expected.");
			}

			// click on the clear filter button
			click("task_tasklist_clearfilterbtn_XPATH");

			// enter the task name in the search field
			type("task_tasklist_searchtxt_CSS", data.get("task_title"));

//			try {
//				// verify compliance option displayed or not
//				boolean selectedTaskTag3 = driver
//						.findElement(By.xpath(OR.getProperty("task_tasklist_tasktagcolumn1_XPATH"))).isDisplayed();
//
//				if (selectedTaskTag3 == true) {
//					verificationFailedMessage("The removed task tag option is displayed in the task tag column of the task list.");
//				} else {
//					successMessage(
//							"The removed task tag option is not displayed in the task tag column of the task list as expected.");
//				}
//
//			} catch (Throwable t) {
//				successMessage(
//						"The removed task tag option is not displayed in the task tag column of the task list as expected.");
//			}

		} catch (Throwable t) {
			verificationFailed();
		}

		// VERIFY TASK TAG IS DISPLAYED IN THE TASK TAG FIELD WHILE UPDATE THE TASK
		// DETAILS
		title("VERIFY TASK TAG IS DISPLAYED IN THE TASK TAG FIELD WHILE UPDATE THE TASK DETAILS");

		try {
			// click on the auto generated task
			click("task_createdtask_covid19autotask_dashboard_XPATH");

			// scroll down the screen
			scrollTillElement("task_createdtask_tagslabel_XPATH");

			// click on the tags field
			click("task_createdtask_tagstxt_CSS");

			// scroll down the screen
			scrollByPixel(400);

			// enter the task tag name in the search field for filter the record
			type("task_tasklist_tagfilter_tagtxt_searchtxt_XPATH", data.get("task_tag_name_1"));

			// VERIFY COMPLIANCE TASK TAG OPTION IS DISPLAYED OR NOT IN THE TASK TAG FIELD
			consoleMessage("VERIFY COMPLIANCE TASK TAG OPTION IS DISPLAYED OR NOT IN THE TASK TAG FIELD");

			try {

				boolean selectedTaskTag = driver
						.findElement(By.xpath(OR.getProperty("task_tasklist_tagfilter_tagtxt_searchedoption_XPATH")))
						.isDisplayed();

				if (selectedTaskTag == true) {
					successMessage(
							"The compliance task tag option is displayed in the task tag field of the filter as expected.");
				} else {
					verificationFailedMessage(
							"The compliance task tag option is not displayed in the task tag field of the filter.");
				}

			} catch (Throwable t) {
				verificationFailedMessage(
						"The compliance task tag option is not displayed in the task tag field of the filter.");
			}

			// VERIFY COMPLIANCE TASK TAG OPTION IS DISPLAYED SELECTED OR NOT IN THE TASK
			// TAG FIELD
			consoleMessage("VERIFY COMPLIANCE TASK TAG OPTION IS DISPLAYED SELECTED OR NOT IN THE TASK TAG FIELD");

			try {

				boolean selectedTaskTag4 = driver
						.findElement(By.xpath(OR.getProperty("task_tasklist_tagfilter_seachedoutlineicon_XPATH")))
						.isDisplayed();

				if (selectedTaskTag4 == true) {
					successMessage(
							"The compliance task tag option is not displayed selected in the task tag field of the filter as expected.");

					// click on the searched compliance task tag option
					click("task_tasklist_tagfilter_seachedoutlineicon_XPATH");

					// click on the tags field
					click("task_createdtask_tagstxt_CSS");

				} else {
					verificationFailedMessage(
							"The compliance task tag option is displayed selected in the task tag field of the filter.");
				}

			} catch (Throwable t) {
				verificationFailedMessage(
						"The compliance task tag option is displayed selected in the task tag field of the filter.");
			}

			// click on the update button
			click("task_tasktag_taskscreen_updatebtn_CSS");

			// wait for the element
			explicitWaitClickable("closetoastmsg_CSS");

			// click on the toaster close button
			click("closetoastmsg_CSS");

			// click on the task tag field for filter the records
			click("task_tasklist_tagfilter_tagtxt_XPATH");

			// enter the task tag name in the search field for filter the record

			type("task_tasklist_tagfilter_tagtxt_searchtxt_XPATH", data.get("task_tag_name_1"));

			// VERIFY COMPLIANCE OPTION DISPLAYED SELECTED OR NOT IN THE TASK TAG FIELD OF
			// THE FILTER
			title("VERIFY COMPLIANCE OPTION DISPLAYED SELECTED OR NOT IN THE TASK TAG FIELD OF THE FILTER");

			try {

				boolean selectedTaskTag = driver
						.findElement(By.xpath(OR.getProperty("task_tasklist_tagfilter_selectedoptionwithicon_XPATH")))
						.isDisplayed();

				if (selectedTaskTag == true) {
					successMessage(
							"The compliance task tag option is displayed selected in the task tag field of the filter as expected.");

				} else {
					verificationFailedMessage(
							"The compliance task tag option is not displayed selected in the task tag field of the filter.");
				}

			} catch (Throwable t) {
				verificationFailedMessage(
						"The compliance task tag option is not displayed selected in the task tag field of the filter.");
			}

			try {

				// enter the task tag name in the search field
				type("task_tasklist_tagfilter_tagtxt_searchtxt_XPATH", data.get("task_tag_name_2"));

				// VERIFY UNDEFINED OPTION DISPLAYED SELECTED OR NOT IN THE TASK TAG FIELD OF
				// THE FILTER
				consoleMessage("VERIFY UNDEFINED OPTION DISPLAYED SELECTED OR NOT IN THE TASK TAG FIELD OF THE FILTER");

				boolean selectedTaskTag2 = driver
						.findElement(By.xpath(OR.getProperty("task_tasklist_tagfilter_undefined_XPATH"))).isDisplayed();

				if (selectedTaskTag2 == true) {
					verificationFailedMessage(
							"The undefined task tag option is displayed in the task tag field of the filter.");

				} else {
					successMessage(
							"The undefined task tag option is not displayed in the task tag field of the filter as expected.");
				}

			} catch (Throwable t) {
				successMessage(
						"The undefined task tag option is not displayed in the task tag field of the filter as expected.");
			}

			// click on the clear filter button
			click("task_tasklist_clearfilterbtn_XPATH");

			// enter the task name in the search field
			type("task_tasklist_searchtxt_CSS", data.get("task_title"));

			try {
				// verify compliance option displayed or not
				boolean selectedTaskTag3 = driver
						.findElement(By.xpath(OR.getProperty("task_tasklist_tasktagcolumn1_XPATH"))).isDisplayed();

				if (selectedTaskTag3 == true) {
					successMessage(
							"The added task tag option is displayed in the task tag column of the task list as expected.");
				} else {
					verificationFailedMessage(
							"The added task tag option is not displayed in the task tag column of the task list.");
				}

			} catch (Throwable t) {
				verificationFailedMessage(
						"The added task tag option is not displayed in the task tag column of the task list.");

			}

		} catch (Throwable t) {
			verificationFailed();
		}

		// click on the Home button
		click("questionnaire_homeburgermenubtn_hide_CSS");

		// wait for the element
		explicitWait("propertylist_title_XPATH");

		// verify the property list
		switchVerification("propertylist_title_XPATH", "Property List", "The property list is not displayed.");

		// ADD THE TASK IN COVID 19 INSPECTION - ADMIN
		title("ADD THE TASK IN COVID 19 INSPECTION - ADMIN");

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
			click("questionnaire_checklist_createdinspectioncovid19_6_XPATH");

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

			// scroll down the screen

			scrollByPixel(500);

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

		// VERIFY TASK TAG OF THE NEWLT CREATED TASK IS DISPLAYED CORRECTLY IN FILTER
		// LIST OT NOT
		title("VERIFY TASK TAG OF THE NEWLT CREATED TASK IS DISPLAYED CORRECTLY IN FILTER LIST OT NOT");

		try {

			// wait for the 5 seconds
			Thread.sleep(5000);

			// click on the side menu
			click("ssc_leftsidemenubtn_CSS");

			// wait for the 5 seconds
			Thread.sleep(5000);

			// click on the inspection/checklist option
			click("ssc_sidemenubtn_inspectionchecklistoption_XPATH");

			// wait for the 3 seconds
			Thread.sleep(3000);

			// click on the dropdown icon
			click("inspectionchecklist_dashboard_dropdownicon_XPATH");

			// click on the inspection history
			click("inspectionchecklist_dashboard_inspectionhistory_XPATH");

			// wait for the element
			explicitWaitClickable("portfoliosummary_inspection2_inspectionlist_opentaskcont_XPATH");

			// click on the open task number
			click("portfoliosummary_inspection2_inspectionlist_opentaskcont_XPATH");

			// enter the task name in the search field

			type("task_tasklist_searchtxt_CSS", data.get("tasktag"));

			// click on the task title
			click("task_createdtask_covid19newltcreatedtask_dashboard_XPATH");

			// scroll down the screen
			scrollTillElement("task_createdtask_tagslabel_XPATH");

			// click on the tags field
			click("task_createdtask_tagstxt_CSS");

			// scroll down the screen
			scrollByPixel(400);

			// click on the none button
			click("task_tasktag_nonebtn_CSS");

			// click on the tags field
			click("task_createdtask_tagstxt_CSS");

			// click on the update button
			click("task_tasktag_taskscreen_updatebtn_CSS");

			// wait for the element
			explicitWaitClickable("closetoastmsg_CSS");

			// click on the toaster close button
			click("closetoastmsg_CSS");

			// click on the task tag field for filter the records
			click("task_tasklist_tagfilter_tagtxt_XPATH");

			// enter the task tag name in the search field for filter the record

			type("task_tasklist_tagfilter_tagtxt_searchtxt_XPATH", data.get("task_tag_name_2"));

			// VERIFY DEFICIENCY OPTION DISPLAYED SELECTED OR NOT IN THE TASK TAG FIELD OF
			// THE FILTER
			consoleMessage("VERIFY DEFICIENCY OPTION DISPLAYED SELECTED OR NOT IN THE TASK TAG FIELD OF THE FILTER");

			try {

				boolean selectedTaskTag = driver
						.findElement(By.xpath(OR
								.getProperty("task_tasklist_tagfilter_selectedoptionwithicon_newlycreatedtask_XPATH")))
						.isDisplayed();

				if (selectedTaskTag == true) {
					verificationFailedMessage(
							"The deficiency task tag option is displayed selected in the task tag field of the filter.");
				} else {
					successMessage(
							"The deficiency task tag option is not displayed selected in the task tag field of the filter as expected.");
				}
			} catch (Throwable t) {
				successMessage(
						"The deficiency task tag option is not displayed selected in the task tag field of the filter as expected.");
			}

			try {

				// enter the task tag name in the search field
				type("task_tasklist_tagfilter_tagtxt_searchtxt_XPATH", data.get("task_tag_name_2"));

				// VERIFY UNDEFINED OPTION DISPLAYED SELECTED OR NOT IN THE TASK TAG FIELD OF
				// THE FILTER
				consoleMessage("VERIFY UNDEFINED OPTION DISPLAYED SELECTED OR NOT IN THE TASK TAG FIELD OF THE FILTER");

				boolean selectedTaskTag2 = driver
						.findElement(By.xpath(OR.getProperty("task_tasklist_tagfilter_undefined_XPATH"))).isDisplayed();

				if (selectedTaskTag2 == true) {
					verificationFailedMessage(
							"The undefined task tag option is displayed in the task tag field of the filter.");
				} else {
					successMessage(
							"The undefined task tag option is not displayed in the task tag field of the filter as expected.");
				}

			} catch (Throwable t) {
				successMessage(
						"The undefined task tag option is not displayed in the task tag field of the filter as expected.");
			}

			// click on the clear filter button
			click("task_tasklist_clearfilterbtn_XPATH");

			// enter the task name in the search field
			type("task_tasklist_searchtxt_CSS", data.get("tasktag"));

			try {
				// verify compliance option displayed or not
				boolean selectedTaskTag3 = driver
						.findElement(By.xpath(OR.getProperty("task_tasklist_tasktagcolumn2_XPATH"))).isDisplayed();

				if (selectedTaskTag3 == true) {
					verificationFailedMessage(
							"The removed task tag option is displayed in the task tag column of the task list.");
				} else {
					successMessage(
							"The removed task tag option is not displayed in the task tag column of the task list as expected.");
				}

			} catch (Throwable t) {
				successMessage(
						"The removed task tag option is not displayed in the task tag column of the task list as expected.");
			}

		} catch (Throwable t) {
			verificationFailed();
		}

		// VERIFY TASK TAG IS DISPLAYED IN THE TASK TAG FIELD WHILE UPDATE THE TASK
		// DETAILS
		title("VERIFY TASK TAG IS DISPLAYED IN THE TASK TAG FIELD WHILE UPDATE THE TASK DETAILS");

		try {
			// click on the newly created task
			click("task_createdtask_covid19newltcreatedtask_dashboard_XPATH");

			// scroll down the screen
			scrollTillElement("task_createdtask_tagslabel_XPATH");

			// click on the tags field
			click("task_createdtask_tagstxt_CSS");

			// scroll down the screen
			scrollByPixel(400);

			// enter the task tag name in the search field for filter the record

			type("task_tasklist_tagfilter_tagtxt_searchtxt_XPATH", data.get("task_tag_name_3"));

			// VERIFY DEFICIENCY TASK TAG OPTION IS DISPLAYED OR NOT IN THE TASK TAG FIELD
			consoleMessage("VERIFY DEFICIENCY TASK TAG OPTION IS DISPLAYED OR NOT IN THE TASK TAG FIELD");

			try {

				boolean selectedTaskTag = driver
						.findElement(By.xpath(
								OR.getProperty("task_tasklist_tagfilter_tagtxt_searchedoption_newlycreatedtask_XPATH")))
						.isDisplayed();

				if (selectedTaskTag == true) {
					successMessage(
							"The deficiency task tag option is displayed in the task tag field of the filter as expected.");

				} else {
					verificationFailedMessage(
							"The deficiency task tag option is not displayed in the task tag field of the filter.");
				}

			} catch (Throwable t) {
				verificationFailedMessage(
						"The deficiency task tag option is not displayed in the task tag field of the filter.");
			}

			// VERIFY DEFICIENCY TASK TAG OPTION IS DISPLAYED SELECTED OR NOT IN THE TASK
			// TAG FIELD
			title("VERIFY DEFICIENCY TASK TAG OPTION IS DISPLAYED SELECTED OR NOT IN THE TASK TAG FIELD");

			try {

				boolean selectedTaskTag4 = driver
						.findElement(By.xpath(
								OR.getProperty("task_tasklist_tagfilter_seachedoutlineicon_newlycreatedtask_XPATH")))
						.isDisplayed();

				if (selectedTaskTag4 == true) {
					successMessage(
							"The deficiency task tag option is not displayed selected in the task tag field of the filter as expected.");

					// click on the searched compliance task tag option
					click("task_tasklist_tagfilter_seachedoutlineicon_newlycreatedtask_XPATH");

					// click on the tags field
					click("task_createdtask_tagstxt_CSS");

				} else {
					verificationFailedMessage(
							"The deficiency task tag option is displayed selected in the task tag field of the filter.");
				}

			} catch (Throwable t) {
				verificationFailedMessage(
						"The deficiency task tag option is displayed selected in the task tag field of the filter.");
			}

			// click on the update button
			click("task_tasktag_taskscreen_updatebtn_CSS");

			// wait for the element
			explicitWaitClickable("closetoastmsg_CSS");

			// click on the toaster close button
			click("closetoastmsg_CSS");

			// click on the task tag field for filter the records
			click("task_tasklist_tagfilter_tagtxt_XPATH");

			// enter the task tag name in the search field for filter the record

			type("task_tasklist_tagfilter_tagtxt_searchtxt_XPATH", data.get("task_tag_name_3"));

			// VERIFY DEFICIENCY OPTION DISPLAYED SELECTED OR NOT IN THE TASK TAG FIELD OF
			// THE FILTER
			title("VERIFY DEFICIENCY OPTION DISPLAYED SELECTED OR NOT IN THE TASK TAG FIELD OF THE FILTER");

			try {

				boolean selectedTaskTag = driver
						.findElement(By.xpath(OR
								.getProperty("task_tasklist_tagfilter_selectedoptionwithicon_newlycreatedtask_XPATH")))
						.isDisplayed();

				if (selectedTaskTag == true) {
					successMessage(
							"The deficiency task tag option is displayed selected in the task tag field of the filter as expected.");
				} else {
					verificationFailedMessage(
							"The deficiency task tag option is not displayed selected in the task tag field of the filter.");
				}

			} catch (Throwable t) {
				verificationFailedMessage(
						"The deficiency task tag option is not displayed selected in the task tag field of the filter.");
			}

			try {

				// enter the task tag name in the search field
				type("task_tasklist_tagfilter_tagtxt_searchtxt_XPATH", data.get("task_tag_name_2"));

				// VERIFY UNDEFINED OPTION DISPLAYED SELECTED OR NOT IN THE TASK TAG FIELD OF
				// THE FILTER
				consoleMessage("VERIFY UNDEFINED OPTION DISPLAYED SELECTED OR NOT IN THE TASK TAG FIELD OF THE FILTER");

				boolean selectedTaskTag2 = driver
						.findElement(By.xpath(OR.getProperty("task_tasklist_tagfilter_undefined_XPATH"))).isDisplayed();

				if (selectedTaskTag2 == true) {
					verificationFailedMessage(
							"The undefined task tag option is displayed in the task tag field of the filter.");
				} else {
					successMessage(
							"The undefined task tag option is not displayed in the task tag field of the filter as expected.");
				}

			} catch (Throwable t) {
				successMessage(
						"The undefined task tag option is not displayed in the task tag field of the filter as expected.");
			}

			// click on the clear filter button
			click("task_tasklist_clearfilterbtn_XPATH");

			// enter the task name in the search field
			type("task_tasklist_searchtxt_CSS", data.get("tasktag"));

			try {
				// verify compliance option displayed or not
				boolean selectedTaskTag3 = driver
						.findElement(By.xpath(OR.getProperty("task_tasklist_tasktagcolumn2_XPATH"))).isDisplayed();

				if (selectedTaskTag3 == true) {
					successMessage(
							"The added task tag option is displayed in the task tag column of the task list as expected.");
				} else {
					verificationFailedMessage(
							"The added task tag option is not displayed in the task tag column of the task list.");
				}

			} catch (Throwable t) {
				verificationFailedMessage(
						"The added task tag option is not displayed in the task tag column of the task list.");
			}

		} catch (Throwable t) {
			verificationFailed();
		}

		// click on the Home button
		click("questionnaire_homeburgermenubtn_hide_CSS");

		// wait for the element
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

			// wait for the element
			Thread.sleep(5000);

			// click on the checklist/inspection option from side menu
			click("checklist_sidemenu_XPATH");

			// wait for the element
			explicitWaitClickable("envreports_movereports_propertydd_CSS");

			// select property from the property drop down
			select("envreports_movereports_propertydd_CSS", data.get("building_leveldropdown"));

			// enter newly created inspection in the search field

			type("task_listofchecklist_filterfield_CSS", data.get("checklist_property_title"));

			// click on the action icon
			click("checklist_actionicon_CSS");

			// click on the delete option
			click("checklist_deleteoption_CSS");

			// click on the delete button
			click("checklist_deletebtn_CSS");

			// verify deleted inspection
			deleteVerification("questionnaire_checklist_createdinspectioncovid19_6_XPATH",
					"Test Questionnaire Property Title Smoke Capreit Six");

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