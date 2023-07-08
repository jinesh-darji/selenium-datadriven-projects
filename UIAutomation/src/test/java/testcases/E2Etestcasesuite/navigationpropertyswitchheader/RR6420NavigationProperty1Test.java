package testcases.E2Etestcasesuite.navigationpropertyswitchheader;

import java.io.IOException;
import java.util.Hashtable;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.Reporter;
import org.testng.annotations.Test;

import com.relevantcodes.extentreports.LogStatus;

import base.Helper;
import base.TestBase;
import utilities.TestUtil;

public class RR6420NavigationProperty1Test extends TestBase {

	@Test(dataProviderClass = TestUtil.class, dataProvider = "dp")
	public void rR6420NavigationProperty1Test(Hashtable<String, String> data) throws InterruptedException, IOException {

		execution(data, "rR6420NavigationProperty1Test");

		Helper helper = new Helper();

		// TASK MODULE - NAVIGATION SCENARIO OF THE TASK SUMMARY, PROPERTY DETAILS,
		// BUILDING DETAILS, OWNERS/INVESTORS, SITE TEAM, HISTORY, SURVEYS AND
		// INSPECTIONS.
		title("TASK MODULE - NAVIGATION SCENARIO OF THE TASK SUMMARY, PROPERTY DETAILS, BUILDING DETAILS, "
				+ "OWNERS/INVESTORS, SITE TEAM, HISTORY, SURVEYS AND INSPECTIONS.");

		// refresh the page
		driver.navigate().refresh();
		Thread.sleep(5000);
		driver.navigate().refresh();

		// ADD THE TASK
		title("ADD THE TASK");

		try {
			// click on the task icon
			click("taskicon_CSS");

			// click on the add task button
			click("task_addtaskbtn_CSS");

			// enter the data in the task title field
			type("task_addtask_titletxt_CSS", data.get("task_title"));

			// enter the data in the task location field
			type("task_addtask_locationtxt_CSS", data.get("task_location"));

			// click on the assign to field
			click("task_assigntotxt_CSS");

			// click on the none button
			click("task_tasktag_nonebtn_CSS");

			// enter the user name in the search field
			type("workflowsecurity_editortask_taskdetails_searchtasktagtxt_CSS", data.get("search_user"));

			// click on the searched result
			click("questionnaire_createtask_selectusertxt_XPATH");

			// click on the assign to field
			click("task_assigntotxt_CSS");

			// scroll down the screen
			scrollBottom();

			// synchronization
			explicitWait("task_addtask_moduledd_CSS");

			// select the environmental option from the module dropdown
			select("task_addtask_moduledd_CSS", data.get("task_module"));

			// click on the save button
			click("survey_task_savebtn_CSS");

			// scroll up the screen
			scrollTop();

			// click on the clear button
			click("task_createdtask_clearbtn_XPATH");

			// enter the data in the search field
			type("task_filter_CSS", data.get("task_title"));

			// click on the search button
			click("task_createdtask_searchbtn_XPATH");

			// verify newly created task is displayed or not
			switchVerification("navigation_task_newlycreated1_XPATH", "Test Task Module Title 1",
					"The Test Task Module Title 1 is not displayed.");

		} catch (Throwable t) {
			verificationFailed();
		}

		// click on the home icon from the top of the screen
		click("questionnaire_homeburgermenubtn_hide_CSS");

		// wait for the element
		explicitWait("propertylist_title_XPATH");

		// verify the property list
		switchVerification("propertylist_title_XPATH", "Property List", "The property list is not displayed.");

		// CREATE THE SURVEY AND INSPECTION IN THE PROPERTY LEVELS
		title("CREATE THE SURVEY AND INSPECTION IN THE PROPERTY LEVELS");

		try {

			// Wait for the element
			Thread.sleep(5000);

			// click on the settings icon from the top of the screen
			click("questionnaire_settingicon_CSS");

			// wait for the element
			explicitWaitClickable("questionnaire_administrationoption_XPATH");

			// click on the Administration option from the side menu
			click("questionnaire_administrationoption_XPATH");

			// click on the Questionnaires tab
			click("questionnaire_questionnairestab_XPATH");

			// click on the Questionnaires option
			click("questionnaire_questionnairesoption_XPATH");

			// CREATE SURVEY
			title("CREATE SURVEY");

			// click on the new questionnaire
			click("questionnaire_newquestionnairebtn_CSS");

			// Select the type of the questionnaire
			click("questionnaire_type_propertybtn_CSS");

			// Select the level of the questionnaire
			click("questionnaire_level_propertybtn_CSS");

			// enter the group title
			type("questionnaire_grouptitletxt_CSS", data.get("group_title"));

			// enter the questionnaire title
			type("questionnaire_languagetitle_CSS", data.get("questionnaire_title"));

			// select the model
			select("questionnaire_modeldd_CSS", data.get("model"));

			// select the frequency
			select("questionnaire_frequencydd_CSS", data.get("frequency"));

			// enter the year
			type("questionnaire_yeartxt_CSS", "2020");

			// select the month
			select("questionnaire_monthtxt_CSS", data.get("month"));

			// enter the description
			type("questionnaire_descriptiontxt_CSS", data.get("description"));

			// click on the save button
			click("questionnaire_savebtn_BTNTEXT");

			// enter newly created questionnaire in the filter field
			type("ssc_company2_questionnairelist_filtertxt_CSS", data.get("questionnaire_title"));

			// verify newly created questionnaire for survey
			switchVerification("navigation_task_surveyrecord1_XPATH", "Test Questionnaire Task Navigation 1",
					"The Test Questionnaire Task Navigation 1 record is not displayed in the questionnaire list.");

			// CONFIGRATION OF QUESTION
			title("CONFIGRATION OF QUESTION");

			// click on the created questionnaire
			click("navigation_task_surveyrecord1_XPATH");

			helper.configureQuestions(data);

			// enter newly created questionnaire in the filter field
			type("ssc_company2_questionnairelist_filtertxt_CSS", data.get("questionnaire_title"));

			// verify newly created questionnaire for survey
			switchVerification("navigation_task_surveyrecord1_XPATH", "Test Questionnaire Task Navigation 1",
					"The Test Questionnaire Task Navigation 1 record is not displayed in the questionnaire list.");

			// CREATE INSPECTION
			title("CREATE INSPECTION");

			helper.createChecklistQuestionnaire(data);

			// enter newly created questionnaire in the filter field
			type("ssc_company2_questionnairelist_filtertxt_CSS", data.get("questionnaire_checklist_title"));

			// verify newly created questionnaire for checklist
			switchVerification("navigation_task_inspectionrecord1_XPATH",
					"Test Questionnaire Checklist Task Navigation 1",
					"The Test Questionnaire Checklist Task Navigation 1 record is not displayed in the questionnaire list.");

			// CONFIGRATION OF QUESTIONNAIRE
			title("CONFIGRATION OF QUESTIONNAIRE");

			// click on the created questionnaire
			click("navigation_task_inspectionrecord1_XPATH");

			helper.configureQuestions(data);

			// enter newly created questionnaire in the filter field
			type("ssc_company2_questionnairelist_filtertxt_CSS", data.get("questionnaire_checklist_title"));

			// verify newly created questionnaire for checklist
			switchVerification("navigation_task_inspectionrecord1_XPATH",
					"Test Questionnaire Checklist Task Navigation 1",
					"The Test Questionnaire Checklist Task Navigation 1 record is not displayed in the questionnaire list.");

		} catch (Throwable t) {
			verificationFailed();
		}

		// click on the home icon from the top of the screen
		click("questionnaire_homeburgermenubtn_CSS");

		// wait for the element
		explicitWait("propertylist_title_XPATH");

		// verify the property list
		switchVerification("propertylist_title_XPATH", "Property List", "The property list is not displayed.");

		// VALIDATE THE NAVIGATION AFTER SWITCHING THE PROPERTY FROM THE HEADER OF
		// THE TASK LISTING SCREEN
		title("VALIDATE THE NAVIGATION AFTER SWITCHING THE PROPERTY FROM THE HEADER OF THE TASK LISTING SCREEN");

		try {

			// wait for the element
			explicitWaitClickable("taskicon_CSS");

			// click on the task icon from the property list page
			click("taskicon_CSS");

			// click on the clear button
			click("task_createdtask_clearbtn_XPATH");

			// enter the data in the search field
			type("task_filter_CSS", data.get("task_title"));

			// click on the search button
			click("task_createdtask_searchbtn_XPATH");

			// click on the newly created task
			click("navigation_task_newlycreated1_XPATH");

			// VALIDATE FOR PROPERTY ONE
			title("VALIDATE FOR PROPERTY ONE");

			// validate the property name
			switchVerification("navigation_header_propertyname1_XPATH", "[DND] AAAA Risk Test Prop 01 - 01",
					"The property name is not displayed.");

			// validate the task title
			try {
				String taskTitle = driver.findElement(By.cssSelector(OR.getProperty("task_addtask_titletxt_CSS")))
						.getAttribute("value");

				if (taskTitle.equals(data.get("task_title"))) {
					successMessage("The task title is displayed correctly.");
				} else {
					verificationFailedMessage("The task title is not displayed correctly.");
				}
			} catch (Throwable t) {
				verificationFailedMessage("The task title is not displayed correctly.");
			}

			// VALIDATE FOR PROPERTY TWO
			title("VALIDATE FOR PROPERTY TWO");

			// wait for the element
			explicitWaitClickable("navigation_header_searchicon_XPATH");

			// click on the search icon from the header
			click("navigation_header_searchicon_XPATH");

			// enter property 2 number in text field
			type("navigation_header_searchtxt_XPATH", "02");

			// hit enter key
			driver.findElement(By.xpath(OR.getProperty("navigation_header_searchtxt_XPATH"))).sendKeys(Keys.ENTER);
			consoleMessage("Hit enter key.");

			// wait for the element
			Thread.sleep(2000);

			// click on the settings icon from the top of the screen
			click("questionnaire_settingicon_CSS");

			// wait for the element
			Thread.sleep(1000);

			// click on the cancel icon
			click("questionnaire_setting_cancelicon_XPATH");

			// validate the property name
			switchVerification("navigation_header_propertyname2_XPATH", "[DND] AAAA Risk Test Prop 02 - 02",
					"The property name is not displayed.");

			// validate the task title
			try {
				String taskTitle = driver.findElement(By.cssSelector(OR.getProperty("task_addtask_titletxt_CSS")))
						.getAttribute("value");

				if (taskTitle.equals(data.get("task_title"))) {
					verificationFailedMessage("The task title is displayed.");

				} else {
					successMessage("The task title is not displayed as expected.");
				}
			} catch (Throwable t) {
				successMessage("The task title is not displayed as expected.");
			}

			// validate the newly created task on the task listing screen
			try {
				// click on the clear button
				click("task_createdtask_clearbtn_XPATH");

				// enter the data in the search field
				type("task_filter_CSS", data.get("task_title"));

				// click on the search button
				click("task_createdtask_searchbtn_XPATH");

				// verify newly created task is displayed or not
				switchVerificationFailed("navigation_task_newlycreated1_XPATH", "Test Task Module Title 1",
						"The Test Task Module Title 1 is displayed.");

			} catch (Throwable t) {
				successMessage("The task title is not displayed as expected.");
			}

			// VALIDATE FOR PROPERTY THREE
			title("VALIDATE FOR PROPERTY THREE");

			// wait for the element
			explicitWaitClickable("navigation_header_searchicon_XPATH");

			// click on the search icon from the header
			click("navigation_header_searchicon_XPATH");

			// enter property 2 number in text field
			type("navigation_header_searchtxt_XPATH", "03");

			// hit enter key
			driver.findElement(By.xpath(OR.getProperty("navigation_header_searchtxt_XPATH"))).sendKeys(Keys.ENTER);
			consoleMessage("Hit enter key.");

			// wait for the element
			Thread.sleep(2000);

			// click on the settings icon from the top of the screen
			click("questionnaire_settingicon_CSS");

			// wait for the element
			Thread.sleep(1000);

			// click on the cancel icon
			click("questionnaire_setting_cancelicon_XPATH");

			// validate the property name
			switchVerification("navigation_header_propertyname3_XPATH", "[DND] AAAA Risk Test Prop 03 - 03",
					"The property name is not displayed.");

			// validate the task title
			try {
				String taskTitle = driver.findElement(By.cssSelector(OR.getProperty("task_addtask_titletxt_CSS")))
						.getAttribute("value");

				if (taskTitle.equals(data.get("task_title"))) {
					verificationFailedMessage("The task title is displayed.");

				} else {
					successMessage("The task title is not displayed as expected.");
				}
			} catch (Throwable t) {
				successMessage("The task title is not displayed as expected.");
			}

			// validate the newly created task on the task listing screen
			try {
				// click on the clear button
				click("task_createdtask_clearbtn_XPATH");

				// enter the data in the search field
				type("task_filter_CSS", data.get("task_title"));

				// click on the search button
				click("task_createdtask_searchbtn_XPATH");

				// verify newly created task is displayed or not
				switchVerificationFailed("navigation_task_newlycreated1_XPATH", "Test Task Module Title 1",
						"The Test Task Module Title 1 is displayed.");

			} catch (Throwable t) {
				successMessage("The task title is not displayed as expected.");
			}

			// VALIDATE FOR PROPERTY ONE
			title("VALIDATE FOR PROPERTY ONE");

			// wait for the element
			explicitWaitClickable("navigation_header_searchicon_XPATH");

			// click on the search icon from the header
			click("navigation_header_searchicon_XPATH");

			// enter property 2 number in text field
			type("navigation_header_searchtxt_XPATH", "01");

			// hit enter key
			driver.findElement(By.xpath(OR.getProperty("navigation_header_searchtxt_XPATH"))).sendKeys(Keys.ENTER);
			consoleMessage("Hit enter key.");

			// validate the property name
			switchVerification("navigation_header_propertyname1_XPATH", "[DND] AAAA Risk Test Prop 01 - 01",
					"The property name is not displayed.");

			// validate the task title
			try {
				String taskTitle = driver.findElement(By.cssSelector(OR.getProperty("task_addtask_titletxt_CSS")))
						.getAttribute("value");

				if (taskTitle.equals(data.get("task_title"))) {
					verificationFailedMessage("The task title is displayed.");

				} else {
					successMessage("The task title is not displayed as expected.");
				}
			} catch (Throwable t) {
				successMessage("The task title is not displayed as expected.");
			}

			// validate the newly created task on the task listing screen
			try {
				// click on the clear button
				click("task_createdtask_clearbtn_XPATH");

				// enter the data in the search field
				type("task_filter_CSS", data.get("task_title"));

				// click on the search button
				click("task_createdtask_searchbtn_XPATH");

				// verify newly created task is displayed or not
				switchVerification("navigation_task_newlycreated1_XPATH", "Test Task Module Title 1",
						"The Test Task Module Title 1 is not displayed.");

			} catch (Throwable t) {
				verificationFailedMessage("The task title is not displayed.");
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

		// VALIDATE THE NAVIGATION AFTER SWITCHING THE PROPERTY FROM THE HEADER OF
		// THE PROPERTY DETAILS SCREEN
		title("VALIDATE THE NAVIGATION AFTER SWITCHING THE PROPERTY FROM THE HEADER OF THE PROPERTY DETAILS SCREEN");

		try {

			// wait for the element
			explicitWaitClickable("taskicon_CSS");

			// click on the task icon from the property list page
			click("taskicon_CSS");

			// wait for the element
			explicitWaitClickable("menubtn_CSS");

			// click on the burger menu
			click("menubtn_CSS");

			// wait for the element
			Thread.sleep(5000);

			// click on the property details from side menu
			click("navigation_sidemenu_propertydetailslbl_XPATH");

			// wait for the element
			explicitWaitClickable("navigation_propertydetails_actionicon_XPATH");

			// click on the action icon
			click("navigation_propertydetails_actionicon_XPATH");

			// click on the property details option
			click("navigation_propertydetails_propertydetailsoption_XPATH");

			// VALIDATE FOR PROPERTY ONE
			title("VALIDATE FOR PROPERTY ONE");

			// validate the property name
			switchVerification("navigation_header_propertyname1_XPATH", "[DND] AAAA Risk Test Prop 01 - 01",
					"The property name is not displayed.");

			// validate the property number
			switchVerification("navigation_propertydetails_propertynumber_XPATH", "01",
					"The respective property number is not displayed.");

			// validate the property name
			switchVerification("navigation_propertydetails_propertyname_XPATH", "[DND] AAAA Risk Test Prop 01",
					"The respective property number is not displayed.");

			// VALIDATE FOR PROPERTY TWO
			title("VALIDATE FOR PROPERTY TWO");

			// wait for the element
			explicitWaitClickable("navigation_header_searchicon_XPATH");

			// click on the search icon from the header
			click("navigation_header_searchicon_XPATH");

			// enter property 2 number in text field
			type("navigation_header_searchtxt_XPATH", "02");

			// hit enter key
			driver.findElement(By.xpath(OR.getProperty("navigation_header_searchtxt_XPATH"))).sendKeys(Keys.ENTER);
			consoleMessage("Hit enter key.");

			// wait for the element
			Thread.sleep(2000);

			// click on the settings icon from the top of the screen
			click("questionnaire_settingicon_CSS");

			// wait for the element
			Thread.sleep(1000);

			// click on the cancel icon
			click("questionnaire_setting_cancelicon_XPATH");

			// validate the property name
			switchVerification("navigation_header_propertyname2_XPATH", "[DND] AAAA Risk Test Prop 02 - 02",
					"The property name is not displayed.");

			// validate the property number
			switchVerification("navigation_propertydetails_propertynumber_XPATH", "02",
					"The respective property number is not displayed.");

			// validate the property name
			switchVerification("navigation_propertydetails_propertyname_XPATH", "[DND] AAAA Risk Test Prop 02",
					"The respective property number is not displayed.");

			// VALIDATE FOR PROPERTY THREE
			title("VALIDATE FOR PROPERTY THREE");

			// wait for the element
			explicitWaitClickable("navigation_header_searchicon_XPATH");

			// click on the search icon from the header
			click("navigation_header_searchicon_XPATH");

			// enter property number in text field
			type("navigation_header_searchtxt_XPATH", "03");

			// hit enter key
			driver.findElement(By.xpath(OR.getProperty("navigation_header_searchtxt_XPATH"))).sendKeys(Keys.ENTER);
			consoleMessage("Hit enter key.");

			// wait for the element
			Thread.sleep(2000);

			// click on the settings icon from the top of the screen
			click("questionnaire_settingicon_CSS");

			// wait for the element
			Thread.sleep(1000);

			// click on the cancel icon
			click("questionnaire_setting_cancelicon_XPATH");

			// validate the property name
			switchVerification("navigation_header_propertyname3_XPATH", "[DND] AAAA Risk Test Prop 03 - 03",
					"The property name is not displayed.");

			// validate the property number
			switchVerification("navigation_propertydetails_propertynumber_XPATH", "03",
					"The respective property number is not displayed.");

			// validate the property name
			switchVerification("navigation_propertydetails_propertyname_XPATH", "[DND] AAAA Risk Test Prop 03",
					"The respective property number is not displayed.");

			// VALIDATE FOR PROPERTY ONE
			title("VALIDATE FOR PROPERTY ONE");

			// wait for the element
			explicitWaitClickable("navigation_header_searchicon_XPATH");

			// click on the search icon from the header
			click("navigation_header_searchicon_XPATH");

			// enter property number in text field
			type("navigation_header_searchtxt_XPATH", "01");

			// hit enter key
			driver.findElement(By.xpath(OR.getProperty("navigation_header_searchtxt_XPATH"))).sendKeys(Keys.ENTER);
			consoleMessage("Hit enter key.");

			// validate the property name
			switchVerification("navigation_header_propertyname1_XPATH", "[DND] AAAA Risk Test Prop 01 - 01",
					"The property name is not displayed.");

			// validate the property number
			switchVerification("navigation_propertydetails_propertynumber_XPATH", "01",
					"The respective property number is not displayed.");

			// validate the property name
			switchVerification("navigation_propertydetails_propertyname_XPATH", "[DND] AAAA Risk Test Prop 01",
					"The respective property number is not displayed.");

		} catch (Throwable t) {
			verificationFailed();
		}

		// click on the home icon from the top of the screen
		click("questionnaire_homeburgermenubtn_hide_CSS");

		// wait for the element
		explicitWait("propertylist_title_XPATH");

		// verify the property list
		switchVerification("propertylist_title_XPATH", "Property List", "The property list is not displayed.");

		// VALIDATE THE NAVIGATION AFTER SWITCHING THE PROPERTY FROM THE HEADER OF
		// THE EDIT PROPERTY DETAILS SCREEN
		title("VALIDATE THE NAVIGATION AFTER SWITCHING THE PROPERTY FROM THE HEADER OF THE EDIT PROPERTY DETAILS SCREEN");

		try {

			// wait for the element
			explicitWaitClickable("taskicon_CSS");

			// click on the task icon from the property list page
			click("taskicon_CSS");

			// wait for the element
			explicitWaitClickable("menubtn_CSS");

			// click on the burger menu
			click("menubtn_CSS");

			// wait for the element
			Thread.sleep(5000);

			// click on the property details from side menu
			click("navigation_sidemenu_propertydetailslbl_XPATH");

			// VALIDATE FOR PROPERTY ONE
			title("VALIDATE FOR PROPERTY ONE");

			// wait for the element
			explicitWaitClickable("navigation_propertydetails_actionicon_XPATH");

			// click on the action icon
			click("navigation_propertydetails_actionicon_XPATH");

			// click on the property details option
			click("navigation_propertydetails_propertydetailsoption_XPATH");

			// click on the edit button of property details
			click("navigation_propertydetails_editbtn_XPATH");

			// validate the property name
			switchVerification("navigation_header_propertyname1_XPATH", "[DND] AAAA Risk Test Prop 01 - 01",
					"The property name is not displayed.");

			// validate the property name
			try {
				String propertyName = driver
						.findElement(By.xpath(OR.getProperty("navigation_propertydetails_propertynametxt_XPATH")))
						.getAttribute("value");

				if (propertyName.equals("[DND] AAAA Risk Test Prop 01")) {
					successMessage("The property name is displayed correctly.");
				} else {
					verificationFailedMessage("The property name is not displayed correctly.");
				}
			} catch (Throwable t) {
				verificationFailedMessage("The property name is not displayed correctly.");
			}

			// VALIDATE FOR PROPERTY TWO
			title("VALIDATE FOR PROPERTY TWO");

			// wait for the element
			explicitWaitClickable("navigation_header_searchicon_XPATH");

			// click on the search icon from the header
			click("navigation_header_searchicon_XPATH");

			// enter property 2 number in text field
			type("navigation_header_searchtxt_XPATH", "02");

			// hit enter key
			driver.findElement(By.xpath(OR.getProperty("navigation_header_searchtxt_XPATH"))).sendKeys(Keys.ENTER);
			consoleMessage("Hit enter key.");

			// wait for the element
			Thread.sleep(2000);

			// click on the settings icon from the top of the screen
			click("questionnaire_settingicon_CSS");

			// wait for the element
			Thread.sleep(1000);

			// click on the cancel icon
			click("questionnaire_setting_cancelicon_XPATH");

			// validate the property name
			switchVerification("navigation_header_propertyname2_XPATH", "[DND] AAAA Risk Test Prop 02 - 02",
					"The property name is not displayed.");

			// validate the property name
			try {
				String propertyName = driver
						.findElement(By.xpath(OR.getProperty("navigation_propertydetails_propertynametxt_XPATH")))
						.getAttribute("value");

				if (propertyName.equals("[DND] AAAA Risk Test Prop 02")) {
					successMessage("The property name is displayed correctly.");
				} else {
					verificationFailedMessage("The property name is not displayed correctly.");
				}
			} catch (Throwable t) {
				verificationFailedMessage("The property name is not displayed correctly.");
			}

			// VALIDATE FOR PROPERTY THREE
			title("VALIDATE FOR PROPERTY THREE");

			// wait for the element
			explicitWaitClickable("navigation_header_searchicon_XPATH");

			// click on the search icon from the header
			click("navigation_header_searchicon_XPATH");

			// enter property number in text field
			type("navigation_header_searchtxt_XPATH", "03");

			// hit enter key
			driver.findElement(By.xpath(OR.getProperty("navigation_header_searchtxt_XPATH"))).sendKeys(Keys.ENTER);
			consoleMessage("Hit enter key.");

			// wait for the element
			Thread.sleep(2000);

			// click on the settings icon from the top of the screen
			click("questionnaire_settingicon_CSS");

			// wait for the element
			Thread.sleep(1000);

			// click on the cancel icon
			click("questionnaire_setting_cancelicon_XPATH");

			// validate the property name
			switchVerification("navigation_header_propertyname3_XPATH", "[DND] AAAA Risk Test Prop 03 - 03",
					"The property name is not displayed.");

			// validate the property name
			try {
				String propertyName = driver
						.findElement(By.xpath(OR.getProperty("navigation_propertydetails_propertynametxt_XPATH")))
						.getAttribute("value");

				if (propertyName.equals("[DND] AAAA Risk Test Prop 03")) {
					successMessage("The property name is displayed correctly.");
				} else {
					verificationFailedMessage("The property name is not displayed correctly.");
				}
			} catch (Throwable t) {
				verificationFailedMessage("The property name is not displayed correctly.");
			}

			// VALIDATE FOR PROPERTY ONE
			title("VALIDATE FOR PROPERTY ONE");

			// wait for the element
			explicitWaitClickable("navigation_header_searchicon_XPATH");

			// click on the search icon from the header
			click("navigation_header_searchicon_XPATH");

			// enter property number in text field
			type("navigation_header_searchtxt_XPATH", "01");

			// hit enter key
			driver.findElement(By.xpath(OR.getProperty("navigation_header_searchtxt_XPATH"))).sendKeys(Keys.ENTER);
			consoleMessage("Hit enter key.");

			// validate the property name
			switchVerification("navigation_header_propertyname1_XPATH", "[DND] AAAA Risk Test Prop 01 - 01",
					"The property name is not displayed.");

			// validate the property name
			try {
				String propertyName = driver
						.findElement(By.xpath(OR.getProperty("navigation_propertydetails_propertynametxt_XPATH")))
						.getAttribute("value");

				if (propertyName.equals("[DND] AAAA Risk Test Prop 01")) {
					successMessage("The property name is displayed correctly.");
				} else {
					verificationFailedMessage("The property name is not displayed correctly.");
				}
			} catch (Throwable t) {
				verificationFailedMessage("The property name is not displayed correctly.");
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

		// VALIDATE THE NAVIGATION AFTER SWITCHING THE PROPERTY FROM THE HEADER OF
		// THE BUILDING LISTING SCREEN
		title("VALIDATE THE NAVIGATION AFTER SWITCHING THE PROPERTY FROM THE HEADER OF THE BUILDING LISTING SCREEN");

		try {

			// wait for the element
			explicitWaitClickable("taskicon_CSS");

			// click on the task icon from the property list page
			click("taskicon_CSS");

			// wait for the element
			explicitWaitClickable("menubtn_CSS");

			// click on the burger menu
			click("menubtn_CSS");

			// wait for the element
			Thread.sleep(5000);

			// click on the property details from side menu
			click("navigation_sidemenu_propertydetailslbl_XPATH");

			// wait for the element
			explicitWaitClickable("navigation_propertydetails_actionicon_XPATH");

			// click on the action icon
			click("navigation_propertydetails_actionicon_XPATH");

			// click on the building option
			click("navigation_propertydetails_buildingoption_XPATH");

			// VALIDATE FOR PROPERTY ONE
			title("VALIDATE FOR PROPERTY ONE");

			// validate the property name
			switchVerification("navigation_header_propertyname1_XPATH", "[DND] AAAA Risk Test Prop 01 - 01",
					"The property name is not displayed.");

			// validate the property number
			switchVerification("navigation_propertydetails_buildingnamelist_XPATH", "[DND] Building one",
					"The respective building name is not displayed.");

			// VALIDATE FOR PROPERTY TWO
			title("VALIDATE FOR PROPERTY TWO");

			// wait for the element
			explicitWaitClickable("navigation_header_searchicon_XPATH");

			// click on the search icon from the header
			click("navigation_header_searchicon_XPATH");

			// enter property 2 number in text field
			type("navigation_header_searchtxt_XPATH", "02");

			// hit enter key
			driver.findElement(By.xpath(OR.getProperty("navigation_header_searchtxt_XPATH"))).sendKeys(Keys.ENTER);
			consoleMessage("Hit enter key.");

			// wait for the element
			Thread.sleep(2000);

			// click on the settings icon from the top of the screen
			click("questionnaire_settingicon_CSS");

			// wait for the element
			Thread.sleep(1000);

			// click on the cancel icon
			click("questionnaire_setting_cancelicon_XPATH");

			// validate the property name
			switchVerification("navigation_header_propertyname2_XPATH", "[DND] AAAA Risk Test Prop 02 - 02",
					"The property name is not displayed.");

			// validate the property number
			switchVerificationFailed("navigation_propertydetails_buildingnamelist_XPATH", "[DND] Building one",
					"The respective building name is not displayed.");

			// VALIDATE FOR PROPERTY THREE
			title("VALIDATE FOR PROPERTY THREE");

			// wait for the element
			explicitWaitClickable("navigation_header_searchicon_XPATH");

			// click on the search icon from the header
			click("navigation_header_searchicon_XPATH");

			// enter property number in text field
			type("navigation_header_searchtxt_XPATH", "03");

			// hit enter key
			driver.findElement(By.xpath(OR.getProperty("navigation_header_searchtxt_XPATH"))).sendKeys(Keys.ENTER);
			consoleMessage("Hit enter key.");

			// wait for the element
			Thread.sleep(2000);

			// click on the settings icon from the top of the screen
			click("questionnaire_settingicon_CSS");

			// wait for the element
			Thread.sleep(1000);

			// click on the cancel icon
			click("questionnaire_setting_cancelicon_XPATH");

			// validate the property name
			switchVerification("navigation_header_propertyname3_XPATH", "[DND] AAAA Risk Test Prop 03 - 03",
					"The property name is not displayed.");

			// validate the property number
			switchVerificationFailed("navigation_propertydetails_buildingnamelist_XPATH", "[DND] Building one",
					"The respective building name is not displayed.");

			// VALIDATE FOR PROPERTY ONE
			title("VALIDATE FOR PROPERTY ONE");

			// wait for the element
			explicitWaitClickable("navigation_header_searchicon_XPATH");

			// click on the search icon from the header
			click("navigation_header_searchicon_XPATH");

			// enter property number in text field
			type("navigation_header_searchtxt_XPATH", "01");

			// hit enter key
			driver.findElement(By.xpath(OR.getProperty("navigation_header_searchtxt_XPATH"))).sendKeys(Keys.ENTER);
			consoleMessage("Hit enter key.");

			// validate the property name
			switchVerification("navigation_header_propertyname1_XPATH", "[DND] AAAA Risk Test Prop 01 - 01",
					"The property name is not displayed.");

			// validate the property number
			switchVerification("navigation_propertydetails_buildingnamelist_XPATH", "[DND] Building one",
					"The respective building name is not displayed.");

		} catch (Throwable t) {
			verificationFailed();
		}

		// click on the home icon from the top of the screen
		click("questionnaire_homeburgermenubtn_hide_CSS");

		// wait for the element
		explicitWait("propertylist_title_XPATH");

		// verify the property list
		switchVerification("propertylist_title_XPATH", "Property List", "The property list is not displayed.");

		// VALIDATE THE NAVIGATION AFTER SWITCHING THE PROPERTY FROM THE HEADER OF
		// THE BUILDING DETAILS SCREEN
		title("VALIDATE THE NAVIGATION AFTER SWITCHING THE PROPERTY FROM THE HEADER OF THE BUILDING DETAILS SCREEN");

		try {

			// wait for the element
			explicitWaitClickable("taskicon_CSS");

			// click on the task icon from the property list page
			click("taskicon_CSS");

			// wait for the element
			explicitWaitClickable("menubtn_CSS");

			// click on the burger menu
			click("menubtn_CSS");

			// wait for the element
			Thread.sleep(5000);

			// click on the property details from side menu
			click("navigation_sidemenu_propertydetailslbl_XPATH");

			// wait for the element
			explicitWaitClickable("navigation_propertydetails_actionicon_XPATH");

			// click on the action icon
			click("navigation_propertydetails_actionicon_XPATH");

			// click on the building option
			click("navigation_propertydetails_buildingoption_XPATH");

			// click on the building record
			click("navigation_propertydetails_buildingnamelist_XPATH");

			// VALIDATE FOR PROPERTY ONE
			title("VALIDATE FOR PROPERTY ONE");

			// validate the property name
			switchVerification("navigation_header_propertyname1_XPATH", "[DND] AAAA Risk Test Prop 01 - 01",
					"The property name is not displayed.");

			// validate the building number
			switchVerification("navigation_propertydetails_buildingnumber_XPATH", "1",
					"The respective building number is not displayed.");

			// validate the building name
			switchVerification("navigation_propertydetails_buildingname_XPATH", "[DND] Building one",
					"The respective building number is not displayed.");

			// VALIDATE FOR PROPERTY TWO
			title("VALIDATE FOR PROPERTY TWO");

			// wait for the element
			explicitWaitClickable("navigation_header_searchicon_XPATH");

			// click on the search icon from the header
			click("navigation_header_searchicon_XPATH");

			// enter property 2 number in text field
			type("navigation_header_searchtxt_XPATH", "02");

			// hit enter key
			driver.findElement(By.xpath(OR.getProperty("navigation_header_searchtxt_XPATH"))).sendKeys(Keys.ENTER);
			consoleMessage("Hit enter key.");

			// wait for the element
			Thread.sleep(2000);

			// click on the settings icon from the top of the screen
			click("questionnaire_settingicon_CSS");

			// wait for the element
			Thread.sleep(1000);

			// click on the cancel icon
			click("questionnaire_setting_cancelicon_XPATH");

			// validate the property name
			switchVerification("navigation_header_propertyname2_XPATH", "[DND] AAAA Risk Test Prop 02 - 02",
					"The property name is not displayed.");

			// validate the property number
			switchVerificationFailed("navigation_propertydetails_buildingnamelist_XPATH", "[DND] Building one",
					"The respective building name is not displayed.");

			// VALIDATE FOR PROPERTY THREE
			title("VALIDATE FOR PROPERTY THREE");

			// wait for the element
			explicitWaitClickable("navigation_header_searchicon_XPATH");

			// click on the search icon from the header
			click("navigation_header_searchicon_XPATH");

			// enter property number in text field
			type("navigation_header_searchtxt_XPATH", "03");

			// hit enter key
			driver.findElement(By.xpath(OR.getProperty("navigation_header_searchtxt_XPATH"))).sendKeys(Keys.ENTER);
			consoleMessage("Hit enter key.");

			// wait for the element
			Thread.sleep(2000);

			// click on the settings icon from the top of the screen
			click("questionnaire_settingicon_CSS");

			// wait for the element
			Thread.sleep(1000);

			// click on the cancel icon
			click("questionnaire_setting_cancelicon_XPATH");

			// validate the property name
			switchVerification("navigation_header_propertyname3_XPATH", "[DND] AAAA Risk Test Prop 03 - 03",
					"The property name is not displayed.");

			// validate the property number
			switchVerificationFailed("navigation_propertydetails_buildingnamelist_XPATH", "[DND] Building one",
					"The respective building name is not displayed.");

			// VALIDATE FOR PROPERTY ONE
			title("VALIDATE FOR PROPERTY ONE");

			// wait for the element
			explicitWaitClickable("navigation_header_searchicon_XPATH");

			// click on the search icon from the header
			click("navigation_header_searchicon_XPATH");

			// enter property number in text field
			type("navigation_header_searchtxt_XPATH", "01");

			// hit enter key
			driver.findElement(By.xpath(OR.getProperty("navigation_header_searchtxt_XPATH"))).sendKeys(Keys.ENTER);
			consoleMessage("Hit enter key.");

			// validate the property name
			switchVerification("navigation_header_propertyname1_XPATH", "[DND] AAAA Risk Test Prop 01 - 01",
					"The property name is not displayed.");

			// validate the property number
			switchVerification("navigation_propertydetails_buildingnamelist_XPATH", "[DND] Building one",
					"The respective building name is not displayed.");

		} catch (Throwable t) {
			verificationFailed();
		}

		// click on the home icon from the top of the screen
		click("questionnaire_homeburgermenubtn_hide_CSS");

		// wait for the element
		explicitWait("propertylist_title_XPATH");

		// verify the property list
		switchVerification("propertylist_title_XPATH", "Property List", "The property list is not displayed.");

		// VALIDATE THE NAVIGATION AFTER SWITCHING THE PROPERTY FROM THE HEADER OF
		// THE EDIT BUILDING DETAILS SCREEN
		title("VALIDATE THE NAVIGATION AFTER SWITCHING THE PROPERTY FROM THE HEADER OF THE EDIT BUILDING DETAILS SCREEN");

		try {

			// wait for the element
			explicitWaitClickable("taskicon_CSS");

			// click on the task icon from the property list page
			click("taskicon_CSS");

			// wait for the element
			explicitWaitClickable("menubtn_CSS");

			// click on the burger menu
			click("menubtn_CSS");

			// wait for the element
			Thread.sleep(5000);

			// click on the property details from side menu
			click("navigation_sidemenu_propertydetailslbl_XPATH");

			// wait for the element
			explicitWaitClickable("navigation_propertydetails_actionicon_XPATH");

			// click on the action icon
			click("navigation_propertydetails_actionicon_XPATH");

			// click on the building option
			click("navigation_propertydetails_buildingoption_XPATH");

			// click on the building record
			click("navigation_propertydetails_buildingnamelist_XPATH");

			// click on the edit button of building details
			click("navigation_buildingdetails_editbtn_XPATH");

			// VALIDATE FOR PROPERTY ONE
			title("VALIDATE FOR PROPERTY ONE");

			// validate the property name
			switchVerification("navigation_header_propertyname1_XPATH", "[DND] AAAA Risk Test Prop 01 - 01",
					"The property name is not displayed.");

			// validate the building name
			try {
				String buildingName = driver
						.findElement(By.xpath(OR.getProperty("navigation_propertydetails_buildingnametxt_XPATH")))
						.getAttribute("value");

				if (buildingName.equals("[DND] Building one")) {
					successMessage("The building name is displayed correctly.");
				} else {
					verificationFailedMessage("The building name is not displayed correctly.");
				}
			} catch (Throwable t) {
				verificationFailedMessage("The building name is not displayed correctly.");
			}

			// VALIDATE FOR PROPERTY TWO
			title("VALIDATE FOR PROPERTY TWO");

			// wait for the element
			explicitWaitClickable("navigation_header_searchicon_XPATH");

			// click on the search icon from the header
			click("navigation_header_searchicon_XPATH");

			// enter property 2 number in text field
			type("navigation_header_searchtxt_XPATH", "02");

			// hit enter key
			driver.findElement(By.xpath(OR.getProperty("navigation_header_searchtxt_XPATH"))).sendKeys(Keys.ENTER);
			consoleMessage("Hit enter key.");

			// wait for the element
			Thread.sleep(2000);

			// click on the settings icon from the top of the screen
			click("questionnaire_settingicon_CSS");

			// wait for the element
			Thread.sleep(1000);

			// click on the cancel icon
			click("questionnaire_setting_cancelicon_XPATH");

			// validate the property name
			switchVerification("navigation_header_propertyname2_XPATH", "[DND] AAAA Risk Test Prop 02 - 02",
					"The property name is not displayed.");

			// validate the property number
			switchVerificationFailed("navigation_propertydetails_buildingnamelist_XPATH", "[DND] Building one",
					"The respective building name is not displayed.");

			// VALIDATE FOR PROPERTY THREE
			title("VALIDATE FOR PROPERTY THREE");

			// wait for the element
			explicitWaitClickable("navigation_header_searchicon_XPATH");

			// click on the search icon from the header
			click("navigation_header_searchicon_XPATH");

			// enter property number in text field
			type("navigation_header_searchtxt_XPATH", "03");

			// hit enter key
			driver.findElement(By.xpath(OR.getProperty("navigation_header_searchtxt_XPATH"))).sendKeys(Keys.ENTER);
			consoleMessage("Hit enter key.");

			// wait for the element
			Thread.sleep(2000);

			// click on the settings icon from the top of the screen
			click("questionnaire_settingicon_CSS");

			// wait for the element
			Thread.sleep(1000);

			// click on the cancel icon
			click("questionnaire_setting_cancelicon_XPATH");

			// validate the property name
			switchVerification("navigation_header_propertyname3_XPATH", "[DND] AAAA Risk Test Prop 03 - 03",
					"The property name is not displayed.");

			// validate the property number
			switchVerificationFailed("navigation_propertydetails_buildingnamelist_XPATH", "[DND] Building one",
					"The respective building name is not displayed.");

			// VALIDATE FOR PROPERTY ONE
			title("VALIDATE FOR PROPERTY ONE");

			// wait for the element
			explicitWaitClickable("navigation_header_searchicon_XPATH");

			// click on the search icon from the header
			click("navigation_header_searchicon_XPATH");

			// enter property number in text field
			type("navigation_header_searchtxt_XPATH", "01");

			// hit enter key
			driver.findElement(By.xpath(OR.getProperty("navigation_header_searchtxt_XPATH"))).sendKeys(Keys.ENTER);
			consoleMessage("Hit enter key.");

			// validate the property name
			switchVerification("navigation_header_propertyname1_XPATH", "[DND] AAAA Risk Test Prop 01 - 01",
					"The property name is not displayed.");

			// validate the property number
			switchVerification("navigation_propertydetails_buildingnamelist_XPATH", "[DND] Building one",
					"The respective building name is not displayed.");

		} catch (Throwable t) {
			verificationFailed();
		}

		// click on the home icon from the top of the screen
		click("questionnaire_homeburgermenubtn_hide_CSS");

		// wait for the element
		explicitWait("propertylist_title_XPATH");

		// verify the property list
		switchVerification("propertylist_title_XPATH", "Property List", "The property list is not displayed.");

		// VALIDATE THE NAVIGATION AFTER SWITCHING THE PROPERTY FROM THE HEADER OF
		// THE OWNERS/INVESTORS LISTING SCREEN
		title("VALIDATE THE NAVIGATION AFTER SWITCHING THE PROPERTY FROM THE HEADER OF THE OWNERS/INVESTORS LISTING SCREEN");

		try {

			// wait for the element
			explicitWaitClickable("taskicon_CSS");

			// click on the task icon from the property list page
			click("taskicon_CSS");

			// wait for the element
			explicitWaitClickable("menubtn_CSS");

			// click on the burger menu
			click("menubtn_CSS");

			// wait for the element
			Thread.sleep(5000);

			// click on the property details from side menu
			click("navigation_sidemenu_propertydetailslbl_XPATH");

			// wait for the element
			explicitWaitClickable("navigation_propertydetails_actionicon_XPATH");

			// click on the action icon
			click("navigation_propertydetails_actionicon_XPATH");

			// click on the owners/investors option
			click("navigation_propertydetails_ownersinvestorsoption_XPATH");

			// VALIDATE FOR PROPERTY ONE
			title("VALIDATE FOR PROPERTY ONE");

			// validate the property name
			switchVerification("navigation_header_propertyname1_XPATH", "[DND] AAAA Risk Test Prop 01 - 01",
					"The property name is not displayed.");

			// validate the add owners icon
			try {
				String ownerIcon = "//i[@ng-click='newContact()']";
				Boolean ownerIcon_actual = driver.findElement(By.xpath(ownerIcon)).isDisplayed();

				if (ownerIcon_actual == true) {
					successMessage("The add owners icon is displayed successfully.");

				} else {
					verificationFailedMessage("The add owners icon is not displayed.");
				}
			} catch (Throwable t) {
				verificationFailedMessage("The add owners icon is not displayed.");
			}

			// VALIDATE FOR PROPERTY TWO
			title("VALIDATE FOR PROPERTY TWO");

			// wait for the element
			explicitWaitClickable("navigation_header_searchicon_XPATH");

			// click on the search icon from the header
			click("navigation_header_searchicon_XPATH");

			// enter property 2 number in text field
			type("navigation_header_searchtxt_XPATH", "02");

			// hit enter key
			driver.findElement(By.xpath(OR.getProperty("navigation_header_searchtxt_XPATH"))).sendKeys(Keys.ENTER);
			consoleMessage("Hit enter key.");

			// wait for the element
			Thread.sleep(2000);

			// click on the settings icon from the top of the screen
			click("questionnaire_settingicon_CSS");

			// wait for the element
			Thread.sleep(1000);

			// click on the cancel icon
			click("questionnaire_setting_cancelicon_XPATH");

			// validate the property name
			switchVerification("navigation_header_propertyname2_XPATH", "[DND] AAAA Risk Test Prop 02 - 02",
					"The property name is not displayed.");

			// validate the add owners icon
			try {
				String ownerIcon = "//i[@ng-click='newContact()']";
				Boolean ownerIcon_actual = driver.findElement(By.xpath(ownerIcon)).isDisplayed();

				if (ownerIcon_actual == true) {
					successMessage("The add owners icon is displayed successfully.");

				} else {
					verificationFailedMessage("The add owners icon is not displayed.");
				}
			} catch (Throwable t) {
				verificationFailedMessage("The add owners icon is not displayed.");
			}

			// VALIDATE FOR PROPERTY THREE
			title("VALIDATE FOR PROPERTY THREE");

			// wait for the element
			explicitWaitClickable("navigation_header_searchicon_XPATH");

			// click on the search icon from the header
			click("navigation_header_searchicon_XPATH");

			// enter property number in text field
			type("navigation_header_searchtxt_XPATH", "03");

			// hit enter key
			driver.findElement(By.xpath(OR.getProperty("navigation_header_searchtxt_XPATH"))).sendKeys(Keys.ENTER);
			consoleMessage("Hit enter key.");

			// wait for the element
			Thread.sleep(2000);

			// click on the settings icon from the top of the screen
			click("questionnaire_settingicon_CSS");

			// wait for the element
			Thread.sleep(1000);

			// click on the cancel icon
			click("questionnaire_setting_cancelicon_XPATH");

			// validate the property name
			switchVerification("navigation_header_propertyname3_XPATH", "[DND] AAAA Risk Test Prop 03 - 03",
					"The property name is not displayed.");

			// validate the add owners icon
			try {
				String ownerIcon = "//i[@ng-click='newContact()']";
				Boolean ownerIcon_actual = driver.findElement(By.xpath(ownerIcon)).isDisplayed();

				if (ownerIcon_actual == true) {
					successMessage("The add owners icon is displayed successfully.");

				} else {
					verificationFailedMessage("The add owners icon is not displayed.");
				}
			} catch (Throwable t) {
				verificationFailedMessage("The add owners icon is not displayed.");
			}

			// VALIDATE FOR PROPERTY ONE
			title("VALIDATE FOR PROPERTY ONE");

			// wait for the element
			explicitWaitClickable("navigation_header_searchicon_XPATH");

			// click on the search icon from the header
			click("navigation_header_searchicon_XPATH");

			// enter property number in text field
			type("navigation_header_searchtxt_XPATH", "01");

			// hit enter key
			driver.findElement(By.xpath(OR.getProperty("navigation_header_searchtxt_XPATH"))).sendKeys(Keys.ENTER);
			consoleMessage("Hit enter key.");

			// validate the property name
			switchVerification("navigation_header_propertyname1_XPATH", "[DND] AAAA Risk Test Prop 01 - 01",
					"The property name is not displayed.");

			// validate the add owners icon
			try {
				String ownerIcon = "//i[@ng-click='newContact()']";
				Boolean ownerIcon_actual = driver.findElement(By.xpath(ownerIcon)).isDisplayed();

				if (ownerIcon_actual == true) {
					successMessage("The add owners icon is displayed successfully.");

				} else {
					verificationFailedMessage("The add owners icon is not displayed.");
				}
			} catch (Throwable t) {
				verificationFailedMessage("The add owners icon is not displayed.");
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

		// VALIDATE THE NAVIGATION AFTER SWITCHING THE PROPERTY FROM THE HEADER OF
		// THE SITE TEAM LISTING SCREEN
		title("VALIDATE THE NAVIGATION AFTER SWITCHING THE PROPERTY FROM THE HEADER OF THE SITE TEAM LISTING SCREEN");

		try {

			// wait for the element
			explicitWaitClickable("taskicon_CSS");

			// click on the task icon from the property list page
			click("taskicon_CSS");

			// wait for the element
			explicitWaitClickable("menubtn_CSS");

			// click on the burger menu
			click("menubtn_CSS");

			// wait for the element
			Thread.sleep(5000);

			// click on the property details from side menu
			click("navigation_sidemenu_propertydetailslbl_XPATH");

			// wait for the element
			explicitWaitClickable("navigation_propertydetails_actionicon_XPATH");

			// click on the action icon
			click("navigation_propertydetails_actionicon_XPATH");

			// click on the site team option
			click("navigation_propertydetails_siteteamoption_XPATH");

			// VALIDATE FOR PROPERTY ONE
			title("VALIDATE FOR PROPERTY ONE");

			// validate the property name
			switchVerification("navigation_header_propertyname1_XPATH", "[DND] AAAA Risk Test Prop 01 - 01",
					"The property name is not displayed.");

			try {
				// validate to the respective user name
				scrollTillElement("navigation_propertydetails_siteteamoption_username_XPATH");

				// validate the respective user is displayed or not
				Boolean userName_actual = driver
						.findElement(
								By.xpath(OR.getProperty("navigation_propertydetails_siteteamoption_username_XPATH")))
						.isDisplayed();

				if (userName_actual == true) {
					verificationFailedMessage("The respective user is displayed.");

				} else {

					successMessage("The respective user is not displayed as expected.");
				}
			} catch (Throwable t) {
				successMessage("The respective user is not displayed as expected.");
			}

			// VALIDATE FOR PROPERTY TWO
			title("VALIDATE FOR PROPERTY TWO");

			// wait for the element
			explicitWaitClickable("navigation_header_searchicon_XPATH");

			// click on the search icon from the header
			click("navigation_header_searchicon_XPATH");

			// enter property 2 number in text field
			type("navigation_header_searchtxt_XPATH", "02");

			// hit enter key
			driver.findElement(By.xpath(OR.getProperty("navigation_header_searchtxt_XPATH"))).sendKeys(Keys.ENTER);
			consoleMessage("Hit enter key.");

			// wait for the element
			Thread.sleep(2000);

			// click on the settings icon from the top of the screen
			click("questionnaire_settingicon_CSS");

			// wait for the element
			Thread.sleep(1000);

			// click on the cancel icon
			click("questionnaire_setting_cancelicon_XPATH");

			// validate the property name
			switchVerification("navigation_header_propertyname2_XPATH", "[DND] AAAA Risk Test Prop 02 - 02",
					"The property name is not displayed.");

			try {
				// validate to the respective user name
				scrollTillElement("navigation_propertydetails_siteteamoption_username_XPATH");

				// validate the respective user is displayed or not
				Boolean userName_actual = driver
						.findElement(
								By.xpath(OR.getProperty("navigation_propertydetails_siteteamoption_username_XPATH")))
						.isDisplayed();

				if (userName_actual == true) {
					successMessage("The respective user is displayed successfully.");

				} else {

					verificationFailedMessage("The respective user is not displayed.");
				}
			} catch (Throwable t) {

				verificationFailedMessage("The respective user is not displayed.");
			}

			// VALIDATE FOR PROPERTY THREE
			title("VALIDATE FOR PROPERTY THREE");

			// wait for the element
			explicitWaitClickable("navigation_header_searchicon_XPATH");

			// click on the search icon from the header
			click("navigation_header_searchicon_XPATH");

			// enter property number in text field
			type("navigation_header_searchtxt_XPATH", "03");

			// hit enter key
			driver.findElement(By.xpath(OR.getProperty("navigation_header_searchtxt_XPATH"))).sendKeys(Keys.ENTER);
			consoleMessage("Hit enter key.");

			// wait for the element
			Thread.sleep(2000);

			// click on the settings icon from the top of the screen
			click("questionnaire_settingicon_CSS");

			// wait for the element
			Thread.sleep(1000);

			// click on the cancel icon
			click("questionnaire_setting_cancelicon_XPATH");

			// validate the property name
			switchVerification("navigation_header_propertyname3_XPATH", "[DND] AAAA Risk Test Prop 03 - 03",
					"The property name is not displayed.");

			try {
				// validate to the respective user name
				scrollTillElement("navigation_propertydetails_siteteamoption_username_XPATH");

				// validate the respective user is displayed or not
				Boolean userName_actual = driver
						.findElement(
								By.xpath(OR.getProperty("navigation_propertydetails_siteteamoption_username_XPATH")))
						.isDisplayed();

				if (userName_actual == true) {
					successMessage("The respective user is displayed successfully.");

				} else {

					verificationFailedMessage("The respective user is not displayed.");
				}
			} catch (Throwable t) {

				verificationFailedMessage("The respective user is not displayed.");
			}

			// VALIDATE FOR PROPERTY ONE
			title("VALIDATE FOR PROPERTY ONE");

			// wait for the element
			explicitWaitClickable("navigation_header_searchicon_XPATH");

			// click on the search icon from the header
			click("navigation_header_searchicon_XPATH");

			// enter property number in text field
			type("navigation_header_searchtxt_XPATH", "01");

			// hit enter key
			driver.findElement(By.xpath(OR.getProperty("navigation_header_searchtxt_XPATH"))).sendKeys(Keys.ENTER);
			consoleMessage("Hit enter key.");

			// validate the property name
			switchVerification("navigation_header_propertyname1_XPATH", "[DND] AAAA Risk Test Prop 01 - 01",
					"The property name is not displayed.");

			try {
				// validate to the respective user name
				scrollTillElement("navigation_propertydetails_siteteamoption_username_XPATH");

				// validate the respective user is displayed or not
				Boolean userName_actual = driver
						.findElement(
								By.xpath(OR.getProperty("navigation_propertydetails_siteteamoption_username_XPATH")))
						.isDisplayed();

				if (userName_actual == true) {
					verificationFailedMessage("The respective user is displayed.");

				} else {

					successMessage("The respective user is not displayed as expected.");
				}
			} catch (Throwable t) {
				successMessage("The respective user is not displayed as expected.");
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

		// VALIDATE THE NAVIGATION AFTER SWITCHING THE PROPERTY FROM THE HEADER OF
		// THE HISTORY RECORDS LISTING SCREEN
		title("VALIDATE THE NAVIGATION AFTER SWITCHING THE PROPERTY FROM THE HEADER OF THE HISTORY RECORDS LISTING SCREEN");

		try {

			// wait for the element
			explicitWaitClickable("taskicon_CSS");

			// click on the task icon from the property list page
			click("taskicon_CSS");

			// wait for the element
			explicitWaitClickable("menubtn_CSS");

			// click on the burger menu
			click("menubtn_CSS");

			// wait for the element
			Thread.sleep(5000);

			// click on the property details from side menu
			click("navigation_sidemenu_propertydetailslbl_XPATH");

			// wait for the element
			explicitWaitClickable("navigation_propertydetails_actionicon_XPATH");

			// click on the action icon
			click("navigation_propertydetails_actionicon_XPATH");

			// click on the history option
			click("navigation_propertydetails_historyoption_XPATH");

			// VALIDATE FOR PROPERTY ONE
			title("VALIDATE FOR PROPERTY ONE");

			// validate the property name
			switchVerification("navigation_header_propertyname1_XPATH", "[DND] AAAA Risk Test Prop 01 - 01",
					"The property name is not displayed.");

			try {

				// validate the respective user is displayed or not
				Boolean record_actual = driver
						.findElement(By.xpath(OR.getProperty("navigation_propertydetails_historyoption_record_XPATH")))
						.isDisplayed();

				if (record_actual == true) {
					successMessage("The respective history record is displayed successfully.");

				} else {
					verificationFailedMessage("The respective history record is not displayed.");

				}
			} catch (Throwable t) {
				verificationFailedMessage("The respective history record is not displayed.");
			}

			// VALIDATE FOR PROPERTY TWO
			title("VALIDATE FOR PROPERTY TWO");

			// wait for the element
			explicitWaitClickable("navigation_header_searchicon_XPATH");

			// click on the search icon from the header
			click("navigation_header_searchicon_XPATH");

			// enter property 2 number in text field
			type("navigation_header_searchtxt_XPATH", "02");

			// hit enter key
			driver.findElement(By.xpath(OR.getProperty("navigation_header_searchtxt_XPATH"))).sendKeys(Keys.ENTER);
			consoleMessage("Hit enter key.");

			// wait for the element
			Thread.sleep(2000);

			// click on the settings icon from the top of the screen
			click("questionnaire_settingicon_CSS");

			// wait for the element
			Thread.sleep(1000);

			// click on the cancel icon
			click("questionnaire_setting_cancelicon_XPATH");

			// validate the property name
			switchVerification("navigation_header_propertyname2_XPATH", "[DND] AAAA Risk Test Prop 02 - 02",
					"The property name is not displayed.");

			try {

				// validate the respective user is displayed or not
				Boolean record_actual = driver
						.findElement(By.xpath(OR.getProperty("navigation_propertydetails_historyoption_record_XPATH")))
						.isDisplayed();

				if (record_actual == true) {
					verificationFailedMessage("The respective history record is displayed.");

				} else {
					successMessage("The respective history record is not displayed as expected.");

				}
			} catch (Throwable t) {
				successMessage("The respective history record is not displayed as expected.");
			}

			// VALIDATE FOR PROPERTY THREE
			title("VALIDATE FOR PROPERTY THREE");

			// wait for the element
			explicitWaitClickable("navigation_header_searchicon_XPATH");

			// click on the search icon from the header
			click("navigation_header_searchicon_XPATH");

			// enter property number in text field
			type("navigation_header_searchtxt_XPATH", "03");

			// hit enter key
			driver.findElement(By.xpath(OR.getProperty("navigation_header_searchtxt_XPATH"))).sendKeys(Keys.ENTER);
			consoleMessage("Hit enter key.");

			// wait for the element
			Thread.sleep(2000);

			// click on the settings icon from the top of the screen
			click("questionnaire_settingicon_CSS");

			// wait for the element
			Thread.sleep(1000);

			// click on the cancel icon
			click("questionnaire_setting_cancelicon_XPATH");

			// validate the property name
			switchVerification("navigation_header_propertyname3_XPATH", "[DND] AAAA Risk Test Prop 03 - 03",
					"The property name is not displayed.");

			try {

				// validate the respective user is displayed or not
				Boolean record_actual = driver
						.findElement(By.xpath(OR.getProperty("navigation_propertydetails_historyoption_record_XPATH")))
						.isDisplayed();

				if (record_actual == true) {
					verificationFailedMessage("The respective history record is displayed.");

				} else {
					successMessage("The respective history record is not displayed as expected.");

				}
			} catch (Throwable t) {
				successMessage("The respective history record is not displayed as expected.");
			}

			// VALIDATE FOR PROPERTY ONE
			title("VALIDATE FOR PROPERTY ONE");

			// wait for the element
			explicitWaitClickable("navigation_header_searchicon_XPATH");

			// click on the search icon from the header
			click("navigation_header_searchicon_XPATH");

			// enter property number in text field
			type("navigation_header_searchtxt_XPATH", "01");

			// hit enter key
			driver.findElement(By.xpath(OR.getProperty("navigation_header_searchtxt_XPATH"))).sendKeys(Keys.ENTER);
			consoleMessage("Hit enter key.");

			// validate the property name
			switchVerification("navigation_header_propertyname1_XPATH", "[DND] AAAA Risk Test Prop 01 - 01",
					"The property name is not displayed.");

			try {

				// validate the respective user is displayed or not
				Boolean record_actual = driver
						.findElement(By.xpath(OR.getProperty("navigation_propertydetails_historyoption_record_XPATH")))
						.isDisplayed();

				if (record_actual == true) {
					successMessage("The respective history record is displayed successfully.");

				} else {
					verificationFailedMessage("The respective history record is not displayed.");

				}
			} catch (Throwable t) {
				verificationFailedMessage("The respective history record is not displayed.");
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

		// VALIDATE THE NAVIGATION AFTER SWITCHING THE PROPERTY FROM THE HEADER OF
		// THE SURVEY SCREEN
		title("VALIDATE THE NAVIGATION AFTER SWITCHING THE PROPERTY FROM THE HEADER OF THE RECORDS SURVEY SCREEN");

		try {

			// click on the task icon from the property list page
			click("taskicon_CSS");

			// wait for the element
			explicitWaitClickable("menubtn_CSS");

			// click on the burger menu
			click("menubtn_CSS");

			// wait for the element
			Thread.sleep(5000);

			// click on the survey option from side menu
			click("surveyoption_XPATH");

			// select the respective questionnaire from the dropdown
			select("survey_questionnairedd_CSS", data.get("questionnaire_title"));

			// verify questionnaire is selected correctly or not
			switchVerification("questionnaire_questiontitle_XPATH", "Test Category Title One",
					"The Test Category Title One is not displayed.");

			// click on the yes checkbox of question 1 of category 1
			click("navigation_environmentnavigation_question1yesckbx1_XPATH");

			// validate the option label
			switchVerification("navigation_environmentnavigation_optionlbl1_XPATH",
					"Test Title Option One Question One",
					"The Test Title Option One Question One option is not displayed.");

			// enter text in the option field
			type("navigation_environmentnavigation_optiontxt1_XPATH", data.get("textfield_question"));

			// click on the question title
			click("questionnaire_questiontitle_XPATH");

			// VALIDATE FOR PROPERTY ONE
			title("VALIDATE FOR PROPERTY ONE");

			// validate the property name
			switchVerification("navigation_header_propertyname1_XPATH", "[DND] AAAA Risk Test Prop 01 - 01",
					"The property name is not displayed.");

			// validate the yes checkbox is displayed selected or not
			try {

				Boolean yesckbx_actual = driver
						.findElement(By.xpath(
								OR.getProperty("navigation_environmentnavigation_question1selectedyesckbx1_XPATH")))
						.isDisplayed();

				if (yesckbx_actual == true) {
					successMessage("The yes checkbox is display selected successfully.");

				} else {
					verificationFailedMessage("The yes checkbox is not display selected.");

				}
			} catch (Throwable t) {
				verificationFailedMessage("The yes checkbox is not display selected.");
			}

			// validate the option label is displayed selected or not
			try {

				Boolean optionlbl_actual = driver
						.findElement(By.xpath(OR.getProperty("navigation_environmentnavigation_optionlbl1_XPATH")))
						.isDisplayed();

				if (optionlbl_actual == true) {
					successMessage("The option label is display successfully.");

				} else {
					verificationFailedMessage("The option label is not display.");

				}
			} catch (Throwable t) {
				verificationFailedMessage("The option label is not display.");
			}

			// VALIDATE FOR PROPERTY TWO
			title("VALIDATE FOR PROPERTY TWO");

			// wait for the element
			explicitWaitClickable("navigation_header_searchicon_XPATH");

			// click on the search icon from the header
			click("navigation_header_searchicon_XPATH");

			// enter property 2 number in text field
			type("navigation_header_searchtxt_XPATH", "02");

			// hit enter key
			driver.findElement(By.xpath(OR.getProperty("navigation_header_searchtxt_XPATH"))).sendKeys(Keys.ENTER);
			consoleMessage("Hit enter key.");

			// wait for the element
			Thread.sleep(2000);

			// click on the settings icon from the top of the screen
			click("questionnaire_settingicon_CSS");

			// wait for the element
			Thread.sleep(1000);

			// click on the cancel icon
			click("questionnaire_setting_cancelicon_XPATH");

			// validate the property name
			switchVerification("navigation_header_propertyname2_XPATH", "[DND] AAAA Risk Test Prop 02 - 02",
					"The property name is not displayed.");

			// validate the yes checkbox is displayed selected or not
			try {

				Boolean yesckbx_actual = driver
						.findElement(
								By.xpath(OR.getProperty("navigation_environmentnavigation_question1yesckbx1_XPATH")))
						.isDisplayed();

				if (yesckbx_actual == true) {
					successMessage("The yes checkbox is not display selected as expected.");

				} else {
					verificationFailedMessage("The yes checkbox is display selected.");

				}
			} catch (Throwable t) {
				verificationFailedMessage("The yes checkbox is display selected.");
			}

			// validate the option label is displayed selected or not
			try {

				Boolean optionlbl_actual = driver
						.findElement(By.xpath(OR.getProperty("navigation_environmentnavigation_optionlbl1_XPATH")))
						.isDisplayed();

				if (optionlbl_actual == true) {
					verificationFailedMessage("The option label is display.");

				} else {
					successMessage("The option label is not display as expected.");

				}
			} catch (Throwable t) {
				successMessage("The option label is not display as expected.");
			}

			// VALIDATE FOR PROPERTY THREE
			title("VALIDATE FOR PROPERTY THREE");

			// wait for the element
			explicitWaitClickable("navigation_header_searchicon_XPATH");

			// click on the search icon from the header
			click("navigation_header_searchicon_XPATH");

			// enter property number in text field
			type("navigation_header_searchtxt_XPATH", "03");

			// hit enter key
			driver.findElement(By.xpath(OR.getProperty("navigation_header_searchtxt_XPATH"))).sendKeys(Keys.ENTER);
			consoleMessage("Hit enter key.");

			// wait for the element
			Thread.sleep(2000);

			// click on the settings icon from the top of the screen
			click("questionnaire_settingicon_CSS");

			// wait for the element
			Thread.sleep(1000);

			// click on the cancel icon
			click("questionnaire_setting_cancelicon_XPATH");

			// validate the property name
			switchVerification("navigation_header_propertyname3_XPATH", "[DND] AAAA Risk Test Prop 03 - 03",
					"The property name is not displayed.");

			// validate the yes checkbox is displayed selected or not
			try {

				Boolean yesckbx_actual = driver
						.findElement(
								By.xpath(OR.getProperty("navigation_environmentnavigation_question1yesckbx1_XPATH")))
						.isDisplayed();

				if (yesckbx_actual == true) {
					successMessage("The yes checkbox is not display selected as expected.");

				} else {
					verificationFailedMessage("The yes checkbox is display selected.");

				}
			} catch (Throwable t) {
				verificationFailedMessage("The yes checkbox is display selected.");
			}

			// validate the option label is displayed selected or not
			try {

				Boolean optionlbl_actual = driver
						.findElement(By.xpath(OR.getProperty("navigation_environmentnavigation_optionlbl1_XPATH")))
						.isDisplayed();

				if (optionlbl_actual == true) {
					verificationFailedMessage("The option label is display.");

				} else {
					successMessage("The option label is not display as expected.");

				}
			} catch (Throwable t) {
				successMessage("The option label is not display as expected.");
			}

			// VALIDATE FOR PROPERTY ONE
			title("VALIDATE FOR PROPERTY ONE");

			// wait for the element
			explicitWaitClickable("navigation_header_searchicon_XPATH");

			// click on the search icon from the header
			click("navigation_header_searchicon_XPATH");

			// enter property number in text field
			type("navigation_header_searchtxt_XPATH", "01");

			// hit enter key
			driver.findElement(By.xpath(OR.getProperty("navigation_header_searchtxt_XPATH"))).sendKeys(Keys.ENTER);
			consoleMessage("Hit enter key.");

			// validate the property name
			switchVerification("navigation_header_propertyname1_XPATH", "[DND] AAAA Risk Test Prop 01 - 01",
					"The property name is not displayed.");

			// validate the yes checkbox is displayed selected or not
			try {

				Boolean yesckbx_actual = driver
						.findElement(By.xpath(
								OR.getProperty("navigation_environmentnavigation_question1selectedyesckbx1_XPATH")))
						.isDisplayed();

				if (yesckbx_actual == true) {
					successMessage("The yes checkbox is display selected successfully.");

				} else {
					verificationFailedMessage("The yes checkbox is not display selected.");

				}
			} catch (Throwable t) {
				verificationFailedMessage("The yes checkbox is not display selected.");
			}

			// validate the option label is displayed selected or not
			try {

				Boolean optionlbl_actual = driver
						.findElement(By.xpath(OR.getProperty("navigation_environmentnavigation_optionlbl1_XPATH")))
						.isDisplayed();

				if (optionlbl_actual == true) {
					successMessage("The option label is display successfully.");

				} else {
					verificationFailedMessage("The option label is not display.");

				}
			} catch (Throwable t) {
				verificationFailedMessage("The option label is not display.");
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

		// VALIDATE THE NAVIGATION AFTER SWITCHING THE PROPERTY FROM THE HEADER OF
		// THE INSPECTION SCREEN
		title("VALIDATE THE NAVIGATION AFTER SWITCHING THE PROPERTY FROM THE HEADER OF THE RECORDS INSPECTION SCREEN");

		try {

			// click on the task icon from the property list page
			click("taskicon_CSS");

			// wait for the element
			explicitWaitClickable("menubtn_CSS");

			// click on the burger menu
			click("menubtn_CSS");

			// wait for the element
			Thread.sleep(5000);

			// click on the checklist/inspection option from side menu
			click("checklist_sidemenu_XPATH");

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
			switchVerification("questionnaire_questiontitle_XPATH", "Test Category Title One",
					"The Test Category Title One is not displayed.");

			// click on the yes checkbox of question 1 of category 1
			click("navigation_environmentnavigation_question1yesckbx1_XPATH");

			// validate the option label
			switchVerification("navigation_environmentnavigation_optionlbl1_XPATH",
					"Test Title Option One Question One",
					"The Test Title Option One Question One option is not displayed.");

			// enter text in the option field
			type("navigation_environmentnavigation_optiontxt1_XPATH", data.get("textfield_question"));

			// click on the question title
			click("questionnaire_questiontitle_XPATH");

			// VALIDATE FOR PROPERTY ONE
			title("VALIDATE FOR PROPERTY ONE");

			// validate the property name
			switchVerification("navigation_header_propertyname1_XPATH", "[DND] AAAA Risk Test Prop 01 - 01",
					"The property name is not displayed.");

			// validate the yes checkbox is displayed selected or not
			try {

				Boolean yesckbx_actual = driver
						.findElement(By.xpath(
								OR.getProperty("navigation_environmentnavigation_question1selectedyesckbx1_XPATH")))
						.isDisplayed();

				if (yesckbx_actual == true) {
					successMessage("The yes checkbox is display selected successfully.");

				} else {
					verificationFailedMessage("The yes checkbox is not display selected.");

				}
			} catch (Throwable t) {
				verificationFailedMessage("The yes checkbox is not display selected.");
			}

			// validate the option label is displayed selected or not
			try {

				Boolean optionlbl_actual = driver
						.findElement(By.xpath(OR.getProperty("navigation_environmentnavigation_optionlbl1_XPATH")))
						.isDisplayed();

				if (optionlbl_actual == true) {
					successMessage("The option label is display successfully.");

				} else {
					verificationFailedMessage("The option label is not display.");

				}
			} catch (Throwable t) {
				verificationFailedMessage("The option label is not display.");
			}

			// VALIDATE FOR PROPERTY TWO
			title("VALIDATE FOR PROPERTY TWO");

			// wait for the element
			explicitWaitClickable("navigation_header_searchicon_XPATH");

			// click on the search icon from the header
			click("navigation_header_searchicon_XPATH");

			// enter property 2 number in text field
			type("navigation_header_searchtxt_XPATH", "02");

			// hit enter key
			driver.findElement(By.xpath(OR.getProperty("navigation_header_searchtxt_XPATH"))).sendKeys(Keys.ENTER);
			consoleMessage("Hit enter key.");

			// wait for the element
			Thread.sleep(2000);

			// click on the settings icon from the top of the screen
			click("questionnaire_settingicon_CSS");

			// wait for the element
			Thread.sleep(1000);

			// click on the cancel icon
			click("questionnaire_setting_cancelicon_XPATH");

			// validate the property name
			switchVerification("navigation_header_propertyname2_XPATH", "[DND] AAAA Risk Test Prop 02 - 02",
					"The property name is not displayed.");

			// enter newly created inspection in search field
			type("navigation_environmentnavigation_searchtxt_XPATH", data.get("questionnaire_checklist_title"));

			// validate the newly created inspection is displayed or not
			try {
				String inspeactionName = "//td[text()='" + data.get("questionnaire_checklist_title") + "']";
				Boolean inspeactionName_actual = driver.findElement(By.xpath(inspeactionName)).isDisplayed();

				if (inspeactionName_actual == true) {
					verificationFailedMessage("The newly created inspection is displayed.");
				} else {
					successMessage("The newly created inspection is not displayed.");
				}
			} catch (Throwable t) {
				successMessage("The newly created inspection is not displayed.");
			}

			// VALIDATE FOR PROPERTY THREE
			title("VALIDATE FOR PROPERTY THREE");

			// wait for the element
			explicitWaitClickable("navigation_header_searchicon_XPATH");

			// click on the search icon from the header
			click("navigation_header_searchicon_XPATH");

			// enter property number in text field
			type("navigation_header_searchtxt_XPATH", "03");

			// hit enter key
			driver.findElement(By.xpath(OR.getProperty("navigation_header_searchtxt_XPATH"))).sendKeys(Keys.ENTER);
			consoleMessage("Hit enter key.");

			// wait for the element
			Thread.sleep(2000);

			// click on the settings icon from the top of the screen
			click("questionnaire_settingicon_CSS");

			// wait for the element
			Thread.sleep(1000);

			// click on the cancel icon
			click("questionnaire_setting_cancelicon_XPATH");

			// validate the property name
			switchVerification("navigation_header_propertyname3_XPATH", "[DND] AAAA Risk Test Prop 03 - 03",
					"The property name is not displayed.");

			// enter newly created inspection in search field
			type("navigation_environmentnavigation_searchtxt_XPATH", data.get("questionnaire_checklist_title"));

			// validate the newly created inspection is displayed or not
			try {
				String inspeactionName = "//td[text()='" + data.get("questionnaire_checklist_title") + "']";
				Boolean inspeactionName_actual = driver.findElement(By.xpath(inspeactionName)).isDisplayed();

				if (inspeactionName_actual == true) {
					verificationFailedMessage("The newly created inspection is displayed.");
				} else {
					successMessage("The newly created inspection is not displayed.");
				}
			} catch (Throwable t) {
				successMessage("The newly created inspection is not displayed.");
			}

			// VALIDATE FOR PROPERTY ONE
			title("VALIDATE FOR PROPERTY ONE");

			// wait for the element
			explicitWaitClickable("navigation_header_searchicon_XPATH");

			// click on the search icon from the header
			click("navigation_header_searchicon_XPATH");

			// enter property number in text field
			type("navigation_header_searchtxt_XPATH", "01");

			// hit enter key
			driver.findElement(By.xpath(OR.getProperty("navigation_header_searchtxt_XPATH"))).sendKeys(Keys.ENTER);
			consoleMessage("Hit enter key.");

			// validate the property name
			switchVerification("navigation_header_propertyname1_XPATH", "[DND] AAAA Risk Test Prop 01 - 01",
					"The property name is not displayed.");

			// enter newly created inspection in search field
			type("navigation_environmentnavigation_searchtxt_XPATH", data.get("questionnaire_checklist_title"));

			// validate the newly created inspection is displayed or not
			try {
				String inspeactionName = "//td[text()='" + data.get("questionnaire_checklist_title") + "']";
				Boolean inspeactionName_actual = driver.findElement(By.xpath(inspeactionName)).isDisplayed();

				if (inspeactionName_actual == true) {
					successMessage("The newly created inspection is displayed successfully.");

				} else {
					verificationFailedMessage("The newly created inspection is not displayed.");
				}
			} catch (Throwable t) {
				verificationFailedMessage("The newly created inspection is not displayed.");
			}

			// click on the newly created inspection
			String inspeactionName = "//td[text()='" + data.get("questionnaire_checklist_title") + "']";
			driver.findElement(By.xpath(inspeactionName)).click();
			consoleMessage("Clicked on the newly created inspection.");

			// validate the yes checkbox is displayed selected or not
			try {

				Boolean yesckbx_actual = driver
						.findElement(By.xpath(
								OR.getProperty("navigation_environmentnavigation_question1selectedyesckbx1_XPATH")))
						.isDisplayed();

				if (yesckbx_actual == true) {
					successMessage("The yes checkbox is display selected successfully.");

				} else {
					verificationFailedMessage("The yes checkbox is not display selected.");

				}
			} catch (Throwable t) {
				verificationFailedMessage("The yes checkbox is not display selected.");
			}

			// validate the option label is displayed selected or not
			try {

				Boolean optionlbl_actual = driver
						.findElement(By.xpath(OR.getProperty("navigation_environmentnavigation_optionlbl1_XPATH")))
						.isDisplayed();

				if (optionlbl_actual == true) {
					successMessage("The option label is display successfully.");

				} else {
					verificationFailedMessage("The option label is not display.");

				}
			} catch (Throwable t) {
				verificationFailedMessage("The option label is not display.");
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

		// DELETE THE NEWLY CREATED TASK
		title("DELETE THE NEWLY CREATED TASK");

		try {
			// click on the task icon
			click("taskicon_CSS");

			// click on the clear button
			click("task_createdtask_clearbtn_XPATH");

			// enter the data in the search field
			type("task_filter_CSS", data.get("task_title"));

			// click on the search button
			click("task_createdtask_searchbtn_XPATH");

			// click on the newly created task
			click("navigation_task_newlycreated1_XPATH");

			// click on the delete button
			click("task_deletedtaskbtn_CSS");

			// synchronization
			explicitWait("task_deletedtaskbtn_confirmaiton_CSS");

			// click on the delete button of the confirmation popup
			click("task_deletedtaskbtn_confirmaiton_CSS");

			// click on the clear button
			click("task_createdtask_clearbtn_XPATH");

			// enter the data in the search field
			type("task_filter_CSS", data.get("task_title"));

			// click on the search button
			click("task_createdtask_searchbtn_XPATH");

			// verify the delete task is displayed or not
			helper.deleteVerification("navigation_task_newlycreated1_XPATH", "Test Task Module Title 1");

		} catch (Throwable t) {
			verificationFailed();
		}

		// click on the home icon from the top of the screen
		click("questionnaire_homeburgermenubtn_hide_CSS");

		// wait for the element
		explicitWait("propertylist_title_XPATH");

		// verify the property list
		switchVerification("propertylist_title_XPATH", "Property List", "The property list is not displayed.");

		// UPDATE THE QUESTIONNAIRE TITLE OF SURVEY AND INSPECTION WITH RANDOM TEXT
		title("UPDATE THE QUESTIONNAIRE TITLE OF SURVEY AND INSPECTION WITH RANDOM TEXT");

		try {
			// wait for the element
			explicitWaitClickable("questionnaire_settingicon_CSS");

			// click on the settings icon from the top of the screen
			click("questionnaire_settingicon_CSS");

			// wait for the element
			explicitWaitClickable("questionnaire_administrationoption_XPATH");

			// click on the Administration option from the side menu
			click("questionnaire_administrationoption_XPATH");

			// click on the Questionnaires tab
			click("questionnaire_questionnairestab_XPATH");

			// click on the Questionnaires option
			click("questionnaire_questionnairesoption_XPATH");

			// enter newly created questionnaire in the filter field
			type("ssc_company2_questionnairelist_filtertxt_CSS", data.get("questionnaire_title"));

			// click on the created questionnaire
			click("navigation_task_surveyrecord1_XPATH");

			// Update the questionnaire with the random text and navigate to the home screen
			helper.randomText();

			// enter newly created questionnaire in the filter field
			type("ssc_company2_questionnairelist_filtertxt_CSS", data.get("questionnaire_checklist_title"));

			// click on the created questionnaire
			click("navigation_task_inspectionrecord1_XPATH");

			// Update the questionnaire with the random text and navigate to the home screen
			helper.randomText();

		} catch (Throwable t) {
			verificationFailed();
		}

		// click on the home icon from the top of the screen
		click("questionnaire_homeburgermenubtn_CSS");

		// wait for the element
		explicitWait("propertylist_title_XPATH");

		// verify the property list
		switchVerification("propertylist_title_XPATH", "Property List", "The property list is not displayed.");

	}

}
