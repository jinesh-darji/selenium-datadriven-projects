package testcases.E2Etestcasesuite.surveychecklistmodule;

import java.io.IOException;
import java.time.LocalDate;
import java.util.Hashtable;
import java.util.List;

import org.apache.commons.lang3.RandomStringUtils;
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

public class RR6181SurveyChecklist3Test extends TestBase {

	@Test(dataProviderClass = TestUtil.class, dataProvider = "dp")
	public void rR6181SurveyChecklist3Test(Hashtable<String, String> data) throws IOException, InterruptedException {

		execution(data, "rR6181SurveyChecklist3Test");

		// CREATE THE CHECKLIST IN PROPERTY AND PERFORM THE VARIOUS ACTIONS ON THE NEWLY
		// CREATED TASK WITH ADD TASK OPTION IN THE INSPECTION

		System.out.println(
				"CREATE THE CHECKLIST IN PROPERTY AND PERFORM THE VARIOUS ACTIONS ON THE NEWLY CREATED TASK WITH ADD TASK OPTION IN THE INSPECTION.");
		test.log(LogStatus.INFO,
				"CREATE THE CHECKLIST IN PROPERTY AND PERFORM THE VARIOUS ACTIONS ON THE NEWLY CREATED TASK WITH ADD TASK OPTION IN THE INSPECTION.");
		Reporter.log(
				"CREATE THE CHECKLIST IN PROPERTY AND PERFORM THE VARIOUS ACTIONS ON THE NEWLY CREATED TASK WITH ADD TASK OPTION IN THE INSPECTION.");
		log.info(
				"CREATE THE CHECKLIST IN PROPERTY AND PERFORM THE VARIOUS ACTIONS ON THE NEWLY CREATED TASK WITH ADD TASK OPTION IN THE INSPECTION.");

		Helper helper = new Helper();
		
		// refresh the page
		driver.navigate().refresh();
		Thread.sleep(5000);
		driver.navigate().refresh();

		System.out.println("Navigate to the Home Screen i.e. Property List Screen.");

		// ADD NEW QUESTIONNIRE FOR INSPECTION

		title("ADD NEW QUESTIONNIRE FOR INSPECTION");

		try {
			// wait for the element
			explicitWaitClickable("questionnaire_settingicon_CSS");

			// click on the settings icon from the top of the screen
			click("questionnaire_settingicon_CSS");
			System.out.println("Clicked on the settings icon.");
			ngDriver.waitForAngularRequestsToFinish();

			// wait for the element
			explicitWaitClickable("questionnaire_administrationoption_XPATH");

			// click on the Administration option from the side menu
			click("questionnaire_administrationoption_XPATH");
			System.out.println("Clicked on the Administration option from the side menu.");
			ngDriver.waitForAngularRequestsToFinish();

			// click on the Questionnaires tab
			click("questionnaire_questionnairestab_XPATH");
			System.out.println("Clicked on the Questionnaires tab.");
			ngDriver.waitForAngularRequestsToFinish();

			// click on the Questionnaires option
			click("questionnaire_questionnairesoption_XPATH");
			System.out.println("Clicked on the Questionnaires option.");
			ngDriver.waitForAngularRequestsToFinish();

			// click on the new questionnaire
			click("questionnaire_newquestionnairebtn_CSS");
			System.out.println("Click on the New Questionnire button");
			ngDriver.waitForAngularRequestsToFinish();
			System.out.println("Navigate to the add questionnire details screen.");

			// Select the Inspection / Checklist of the questionnaire
			click("questionnaire_type_inspectionbtn_CSS");
			System.out.println("The type of the questionnire is selected.");

			// Select the level of the questionnaire
			click("questionnaire_level_propertybtn_CSS");
			System.out.println("The level of the questionnire is selected.");

			// enter the group title
			clear("questionnaire_grouptitletxt_CSS");
			type("questionnaire_grouptitletxt_CSS", data.get("group_title"));
			System.out.println("The data entered in the Group Title field.");

			// enter the questionnaire title
			clear("questionnaire_languagetitle_CSS");
			type("questionnaire_languagetitle_CSS", data.get("questionnaire_checklist_title"));
			System.out.println("Entered the questionnaire title in the english language.");
			ngDriver.waitForAngularRequestsToFinish();

			// select the model
			select("questionnaire_modeldd_CSS", data.get("model"));
			System.out.println("The data entered in the Questionnaire Title field.");
			ngDriver.waitForAngularRequestsToFinish();

			// select the frequency
			select("questionnaire_frequencydd_CSS", data.get("frequency"));
			System.out.println("The data entered in the frequency field.");
			ngDriver.waitForAngularRequestsToFinish();

			// enter frequency interval
			clear("questionnaire_frequencyintervaltxt_CSS");
			type("questionnaire_frequencyintervaltxt_CSS", "1");
			ngDriver.waitForAngularRequestsToFinish();
			System.out.println("Entered frequency interval.");

			// select the month
			select("questionnaire_monthtxt_CSS", data.get("month"));
			System.out.println("The data entered in the month field.");
			ngDriver.waitForAngularRequestsToFinish();

			// enter the description
			clear("questionnaire_descriptiontxt_CSS");
			type("questionnaire_descriptiontxt_CSS", data.get("description"));
			ngDriver.waitForAngularRequestsToFinish();
			System.out.println("The data entered in the description field.");

			// select the classic option from the default view drop down
			select("questionnaire_checklist_defaultview_CSS", data.get("default_view"));
			System.out.println("Selected the classic option from the default view drop down.");
			ngDriver.waitForAngularRequestsToFinish();

			// scroll down to the save button
			JavascriptExecutor js = (JavascriptExecutor) driver;
			js.executeScript("window.scrollBy(0,document.body.scrollHeight)");

			// click on the save button
			click("questionnaire_savebtn_BTNTEXT");
			System.out.println("Clicked on the save button");
			ngDriver.waitForAngularRequestsToFinish();
			System.out.println("Navigate to the list of questionnaire screen.");

			// enter newly created questionnaire in the filter field
			clear("ssc_company2_questionnairelist_filtertxt_CSS");
			type("ssc_company2_questionnairelist_filtertxt_CSS", data.get("questionnaire_checklist_title"));
			System.out.println("Entered newly created questionnaire in the filter field.");
			ngDriver.waitForAngularRequestsToFinish();

			// verify newly created questionnaire for checklist
			switchVerification("questionnaire_addtaskoption3_XPATH", "Questionnaire Add Task Option Three Title",
					"The Questionnaire Add Task Option Three Title record is not displayed in the questionnaire list.");

			// CONFIGRATION OF QUESTION

			System.out.println("***************** CONFIGRATION OF QUESTION *****************");
			test.log(LogStatus.INFO, "***************** CONFIGRATION OF QUESTION *****************");
			Reporter.log("***************** CONFIGRATION OF QUESTION *****************");
			log.info("***************** CONFIGRATION OF QUESTION *****************");

			// click on the created questionnaire
			click("questionnaire_addtaskoption3_XPATH");
			System.out.println("Clicked on the newly created questionnaire for checklist.");
			ngDriver.waitForAngularRequestsToFinish();

			helper.configureQuestions(data);

			// enter newly created questionnaire in the filter field
			clear("ssc_company2_questionnairelist_filtertxt_CSS");
			type("ssc_company2_questionnairelist_filtertxt_CSS", data.get("questionnaire_checklist_title"));
			System.out.println("Entered newly created questionnaire in the filter field.");
			ngDriver.waitForAngularRequestsToFinish();

			// verify newly created questionnaire for checklist
			switchVerification("questionnaire_addtaskoption3_XPATH", "Questionnaire Add Task Option Three Title",
					"The Questionnaire Add Task Option Three Title record is not displayed in the questionnaire list.");

		} catch (Throwable t) {
			verificationFailed();
		}

		// click on the Home Icon from the top of the screen
		click("questionnaire_homeburgermenubtn_CSS");
		System.out.println("Clicked on the Home Icon from the top of the screen.");
		ngDriver.waitForAngularRequestsToFinish();

		// wait for the element
		explicitWait("propertylist_title_XPATH");

		// verify the property list
		switchVerification("propertylist_title_XPATH", "Property List", "The property list is not displayed.");

		// CREATE INSPECTION AT PROPERTY LEVEL

		title("CREATE INSPECTION AT PROPERTY LEVEL");

		try {
			// click on the environmental icon from the property list page
			click("environmentalicon_CSS");
			System.out.println("Clicked on the environmental icon of the Property.");
			ngDriver.waitForAngularRequestsToFinish();
			System.out.println("Navigate to the environmental screen of the perticular property.");

			// wait for the element
			explicitWaitClickable("menubtn_CSS");

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

			// select the property level from the dropdown
			select("survey_leveldropdown_CSS", data.get("property_leveldropdown"));
			System.out.println("Selected the property level from the dropdown.");
			ngDriver.waitForAngularRequestsToFinish();

			// click on the new checklist button
			click("checklist_newchecklistbtn_CSS");
			System.out.println("Clicked on the new checklist button.");
			ngDriver.waitForAngularRequestsToFinish();

			try {
				// wait for the element
				explicitWait("checklist_addchecklist_checklisttypedd_CSS");

				// collect all options of the dropdown
				Select dropdown = new Select(driver
						.findElement(By.cssSelector(OR.getProperty("checklist_addchecklist_checklisttypedd_CSS"))));

				// Get all options
				List<WebElement> dd = dropdown.getOptions();

				// Loop to print one by one
				for (int j = 0; j < dd.size(); j++) {
					String checklist = dd.get(j).getText();
					try {
						if (checklist.equals(data.get("questionnaire_checklist_title"))) {

							test.log(LogStatus.INFO, "The checklist is displayed successfully.");
							Reporter.log("The checklist is displayed successfully.");
							System.out.println("The checklist is displayed successfully.");
							log.info("The checklist is displayed successfully.");

							// select the questionnaire option from the checklist type dropdown
							select("checklist_addchecklist_checklisttypedd_CSS",
									data.get("questionnaire_checklist_title"));
							System.out
									.println("The created questionaaire is selected from the checklist type dropdown.");
							ngDriver.waitForAngularRequestsToFinish();

							// enter data in the checklist title field
							clear("checklist_addchecklist_titletxt_CSS");
							type("checklist_addchecklist_titletxt_CSS", data.get("checklist_property_title"));
							System.out.println("Entered the data in the checklist title field.");
							ngDriver.waitForAngularRequestsToFinish();

							// click on the save button
							click("checklist_addchecklist_savebtn_CSS");
							System.out.println("Clicked on the save button.");
							ngDriver.waitForAngularRequestsToFinish();

							// verify questionnaire is selected correctly or not
							switchVerification("questionnaire_questiontitle_XPATH", "Test Category Title One",
									"The Test Category Title One is not displayed.");

						}
					} catch (Throwable t) {

						verificationFailedMessage(" The " + data.get("questionnaire_checklist_title")
								+ " is not displayed in the dropdown.");

						// click on the close button of the add checklist popup
						click("checklist_addchecklist_dltbtn_XPATH");
						System.out.println("Clicked on the close button of the add checklist popup.");
						ngDriver.waitForAngularRequestsToFinish();

					}
				}
			} catch (Throwable t) {
				verificationFailed();
			}

		} catch (Throwable t) {
			verificationFailed();
		}

		// click on the home icon from the top of the screen
		click("questionnaire_homeburgermenubtn_hide_CSS");
		System.out.println("Clicked on the home icon from the top of the screen.");
		ngDriver.waitForAngularRequestsToFinish();

		// wait for the element
		explicitWait("propertylist_title_XPATH");

		// verify the property list
		switchVerification("propertylist_title_XPATH", "Property List", "The property list is not displayed.");

		// VALIDATE THE ADD TASK OPTION AND CREATE THE TASK FOR THE CATEGORY ONE OF THE
		// INSPECTION

		title("VALIDATE THE ADD TASK OPTION AND CREATE THE TASK FOR THE CATEGORY ONE OF THE INSPECTION");

		String randomTaskTitle = RandomStringUtils.randomAlphabetic(8);
		String updateRandomTaskTitle = RandomStringUtils.randomAlphabetic(8);

		try {
			// click on the environmental icon from the property list page
			click("environmentalicon_CSS");
			System.out.println("Clicked on the environmental icon of the Property.");
			ngDriver.waitForAngularRequestsToFinish();
			System.out.println("Navigate to the environmental screen of the perticular property.");

			// wait for the element
			explicitWaitClickable("menubtn_CSS");

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

			// enter the inspection name in the search field
			clear("sustainability_searchtxt_XPATH");
			type("sustainability_searchtxt_XPATH", data.get("checklist_property_title"));
			ngDriver.waitForAngularRequestsToFinish();
			System.out.println("Entered the inspection name in the search field.");

			// click on the newly searched inspection
			String inspection = "//td[text()='" + data.get("checklist_property_title") + "']";
			driver.findElement(By.xpath(inspection)).click();
			ngDriver.waitForAngularRequestsToFinish();
			System.out.println("Clicked on the newly searched inspection.");

			// scroll to the category one
			WebElement category1 = driver.findElement(
					By.xpath(OR.getProperty("questionnaire_inspection_category1_addtask_actionicon_XPATH")));
			JavascriptExecutor js = (JavascriptExecutor) driver;
			js.executeScript("arguments[0].scrollIntoView();", category1);

			// click on the action icon of the category one
			click("questionnaire_inspection_category1_addtask_actionicon_XPATH");
			ngDriver.waitForAngularRequestsToFinish();
			System.out.println("Clicked on the action icon of the category one.");

			// click on the add task option
			click("questionnaire_inspection_category1_addtaskoption_XPATH");
			ngDriver.waitForAngularRequestsToFinish();
			System.out.println("Clicked on the add task option.");

			// enter the valid task title
			clear("checklist_wizard_tasktitle_XPATH");
			type("checklist_wizard_tasktitle_XPATH", randomTaskTitle);
			ngDriver.waitForAngularRequestsToFinish();
			System.out.println("Entered the valid task title.");

			// click on the assign to field
			click("questionnaire_inspection_addtask_assigntotxt_XPATH");
			ngDriver.waitForAngularRequestsToFinish();
			System.out.println("Clicked on the assign to field.");

			// click on the none button
			click("checklist_wizard_task_nonebtn_XPATH");
			ngDriver.waitForAngularRequestsToFinish();
			System.out.println("Clicked on the none button.");

			// enter the user name in the search field
			clear("checklist_wizard_task_assignedtosearchtxt_XPATH");
			type("checklist_wizard_task_assignedtosearchtxt_XPATH", data.get("username"));
			ngDriver.waitForAngularRequestsToFinish();
			System.out.println("Entered the user name in the search field.");

			// click on the searched user
			click("checklist_wizard_task_assignedtosearchedresult_XPATH");
			ngDriver.waitForAngularRequestsToFinish();
			System.out.println("Clicked on the searched user.");

			// click on the assign to field
			click("questionnaire_inspection_addtask_assigntotxt_XPATH");
			ngDriver.waitForAngularRequestsToFinish();
			System.out.println("Clicked on the assign to field.");

			// click on the save button
			click("questionnaire_inspection_addtask_savebtn_XPATH");
			ngDriver.waitForAngularRequestsToFinish();
			System.out.println("Clicked on the save button.");

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

		// wait for the element
		explicitWait("propertylist_title_XPATH");

		// verify the property list
		switchVerification("propertylist_title_XPATH", "Property List", "The property list is not displayed.");

		// PERFORM THE ACTIONS OF THE TASK FROM THE INSPECTION

		title("PERFORM THE ACTIONS OF THE TASK FROM THE INSPECTION");

		try {
			// click on the environmental icon from the property list page
			click("environmentalicon_CSS");
			System.out.println("Clicked on the environmental icon of the Property.");
			ngDriver.waitForAngularRequestsToFinish();
			System.out.println("Navigate to the environmental screen of the perticular property.");

			// wait for the element
			explicitWaitClickable("menubtn_CSS");

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

			// enter the inspection name in the search field
			clear("sustainability_searchtxt_XPATH");
			type("sustainability_searchtxt_XPATH", data.get("checklist_property_title"));
			ngDriver.waitForAngularRequestsToFinish();
			System.out.println("Entered the inspection name in the search field.");

			// click on the newly searched inspection
			String inspection = "//td[text()='" + data.get("checklist_property_title") + "']";
			driver.findElement(By.xpath(inspection)).click();
			ngDriver.waitForAngularRequestsToFinish();
			System.out.println("Clicked on the newly searched inspection.");

			// scroll to the category one
			WebElement category1 = driver.findElement(
					By.xpath(OR.getProperty("questionnaire_inspection_category1_addtask_actionicon_XPATH")));
			JavascriptExecutor js = (JavascriptExecutor) driver;
			js.executeScript("arguments[0].scrollIntoView();", category1);

			// validate the count of the task
			String taskStatement1 = (driver
					.findElement(
							By.xpath(OR.getProperty("questionnaire_inspection_category1_classicview_taskcount_XPATH")))
					.getText()).trim();
			String[] taskStatement1_arr = taskStatement1.split(" ");
			String taskCounts1 = taskStatement1_arr[0];

			if (taskCounts1.equals("1")) {

				successMessage("THE COUNT OF TASKS FOR THE CATEGORY ONE IN THE CLASSIC VIEW IS DISPLAYED CORRECTLY.");

			} else {

				verificationFailedMessage(
						"THE COUNT OF TASKS FOR THE CATEGORY ONE IN THE CLASSIC VIEW IS NOT DISPLAYED CORRECTLY.");

			}

			// UPDATE THE TASK DETAILS WITH THE UPDATE TASK DETAILS OPTION

			title("UPDATE THE TASK DETAILS WITH THE UPDATE TASK DETAILS OPTION");

			// click on the action icon
			click("questionnaire_inspection_tasks_actionicon_XPATH");
			ngDriver.waitForAngularRequestsToFinish();
			System.out.println("Clicked on the action icon.");

			// click on the update task detail option
			click("questionnaire_inspection_tasks_updatetaskdetailsoption_XPATH");
			ngDriver.waitForAngularRequestsToFinish();
			System.out.println("Clicked on the update task detail option.");

			// update the valid task title
			clear("checklist_wizard_tasktitle_XPATH");
			type("checklist_wizard_tasktitle_XPATH", updateRandomTaskTitle);
			ngDriver.waitForAngularRequestsToFinish();
			System.out.println("Updated the valid task title.");

			// enter the location
			clear("questionnaire_inspection_tasks_locationtxt_XPATH");
			type("questionnaire_inspection_tasks_locationtxt_XPATH", data.get("location_update"));
			ngDriver.waitForAngularRequestsToFinish();
			System.out.println("Entered the location.");

			// click on the assign to field
			click("questionnaire_inspection_addtask_assigntotxt_XPATH");
			ngDriver.waitForAngularRequestsToFinish();
			System.out.println("Clicked on the assign to field.");

			// click on the none button
			click("checklist_wizard_task_nonebtn_XPATH");
			ngDriver.waitForAngularRequestsToFinish();
			System.out.println("Clicked on the none button.");

			// enter the user name in the search field
			clear("checklist_wizard_task_assignedtosearchtxt_XPATH");
			type("checklist_wizard_task_assignedtosearchtxt_XPATH", data.get("username_update"));
			ngDriver.waitForAngularRequestsToFinish();
			System.out.println("Entered the user name in the search field.");

			// click on the searched user
			click("checklist_wizard_task_updatedassignedtosearchedresult_XPATH");
			ngDriver.waitForAngularRequestsToFinish();
			System.out.println("Clicked on the searched user.");

			// click on the assign to field
			click("questionnaire_inspection_addtask_assigntotxt_XPATH");
			ngDriver.waitForAngularRequestsToFinish();
			System.out.println("Clicked on the assign to field.");

			// click on the update button
			click("questionnaire_inspection_tasks_updatebtn_XPATH");
			ngDriver.waitForAngularRequestsToFinish();
			System.out.println("Clicked on the update button.");

			// wait for the element
			explicitWaitClickable("closetoastmsg_CSS");

			// click on the toaster close button
			click("closetoastmsg_CSS");
			ngDriver.waitForAngularRequestsToFinish();
			System.out.println("Clicked on the toaster close button.");

			// scroll to the category one
			js.executeScript("window.scrollTo(0,0)");

			try {
				// validate the updated task title
				String updatedTaskTitle_XPATH = "//label[@ng-click='loadSelectedQuestionnaireCategoryTaskDetails(task, false);']";
				String updatedTaskTitle = (driver.findElement(By.xpath(updatedTaskTitle_XPATH)).getText()).trim();
				System.out.println("Added Task Name: " + updatedTaskTitle);

				if (updatedTaskTitle.equals(updateRandomTaskTitle)) {

					successMessage("The updated task title is displayed correctly.");

				} else {
					verificationFailedMessage("The updated task title is not displayed correctly.");
				}

			} catch (Throwable t) {
				verificationFailed();
			}

			try {
				// validate the updated location
				String updatedLocation_XPATH = "//p[text()='" + data.get("location_update") + "']";
				String updatedLocation = (driver.findElement(By.xpath(updatedLocation_XPATH)).getText()).trim();

				if (updatedLocation.equals(data.get("location_update"))) {

					successMessage("The updated location is displayed correctly.");

				} else {
					verificationFailedMessage("The updated location is not displayed correctly.");
				}

			} catch (Throwable t) {
				verificationFailed();
			}

			try {
				// validate the updated assign to
				String updatedAssignTo_XPATH = "//p[text()='" + data.get("username_update") + "']";
				String updatedAssignTo = (driver.findElement(By.xpath(updatedAssignTo_XPATH)).getText()).trim();

				if (updatedAssignTo.equals(data.get("username_update"))) {

					successMessage("The updated assign to is displayed correctly.");

				} else {
					verificationFailedMessage("The updated assign to is not displayed correctly.");
				}

			} catch (Throwable t) {
				verificationFailed();
			}

			try {
				// validate the status
				String updatedStatus_XPATH = "//p[text()='" + data.get("status_pending") + "']";
				String updatedStatus = (driver.findElement(By.xpath(updatedStatus_XPATH)).getText()).trim();

				if (updatedStatus.equals(data.get("status_pending"))) {

					successMessage("The status is displayed correctly.");

				} else {
					verificationFailedMessage("The status is not displayed correctly.");
				}

			} catch (Throwable t) {
				verificationFailed();
			}

			// UPDATE THE DUE DATE WITH THE CHANGE DUE DATE OPTION

			title("UPDATE THE DUE DATE WITH THE CHANGE DUE DATE OPTION");

			// scroll to the category one
			js.executeScript("window.scrollTo(0,0)");

			// click on the action icon
			click("questionnaire_inspection_tasks_actionicon_XPATH");
			ngDriver.waitForAngularRequestsToFinish();
			System.out.println("Clicked on the action icon.");

			// click on the change due date option
			click("questionnaire_inspection_tasks_changeduedateoption_XPATH");
			ngDriver.waitForAngularRequestsToFinish();
			System.out.println("Clicked on the change due date option.");

			// enter future date in the new due date field
			LocalDate futureDate = LocalDate.now().plusDays(10);
			String futureDate_string = futureDate.toString();
			type("questionnaire_inspection_tasks_newduedatetxt_XPATH", futureDate_string);
			ngDriver.waitForAngularRequestsToFinish();
			System.out.println("Entered future date in the new due date field.");

			// click on the apply button
			click("questionnaire_inspection_tasks_applybtn_XPATH");
			ngDriver.waitForAngularRequestsToFinish();
			System.out.println("Clicked on the apply button.");

			// wait for the element
			explicitWaitClickable("closetoastmsg_CSS");

			// click on the toaster close button
			click("closetoastmsg_CSS");
			ngDriver.waitForAngularRequestsToFinish();
			System.out.println("Clicked on the toaster close button.");

			// click on the action icon
			click("questionnaire_inspection_tasks_actionicon_XPATH");
			ngDriver.waitForAngularRequestsToFinish();
			System.out.println("Clicked on the action icon.");

			// click on the update task detail option
			click("questionnaire_inspection_tasks_updatetaskdetailsoption_XPATH");
			ngDriver.waitForAngularRequestsToFinish();
			System.out.println("Clicked on the update task detail option.");

			try {
				// validate the update due date
				String updatedDueDate = (driver
						.findElement(By.xpath(OR.getProperty("questionnaire_inspection_tasks_duedatetxt_XPATH")))
						.getAttribute("value")).trim();

				if (updatedDueDate.equals(futureDate_string)) {

					successMessage("The updated due date is displayed correctly.");

					// click on the back button
					click("questionnaire_inspection_tasks_backbtn_XPATH");
					ngDriver.waitForAngularRequestsToFinish();
					System.out.println("Clicked on the back button.");

				} else {
					verificationFailedMessage("The updated due date is not displayed correctly.");

					// click on the back button
					click("questionnaire_inspection_tasks_backbtn_XPATH");
					ngDriver.waitForAngularRequestsToFinish();
					System.out.println("Clicked on the back button.");

				}

			} catch (Throwable t) {
				verificationFailedMessage("The updated due date is not displayed correctly.");

				// click on the back button
				click("questionnaire_inspection_tasks_backbtn_XPATH");
				ngDriver.waitForAngularRequestsToFinish();
				System.out.println("Clicked on the back button.");

			}

			// UPDATE THE AASIGNEE OF THE TASK WITH THE ASSIGN TASK OPTION

			title("UPDATE THE AASIGNEE OF THE TASK WITH THE ASSIGN TASK OPTION");

			// scroll to the category one
			js.executeScript("window.scrollTo(0,0)");

			// click on the action icon
			click("questionnaire_inspection_tasks_actionicon_XPATH");
			ngDriver.waitForAngularRequestsToFinish();
			System.out.println("Clicked on the action icon.");

			// click on the assign task option
			click("questionnaire_inspection_tasks_assigntaskoption_XPATH");
			ngDriver.waitForAngularRequestsToFinish();
			System.out.println("Clicked on the assign task option.");

			// click on the assign to field
			click("questionnaire_inspection_tasks_assigntask_assigntotxt_XPATH");
			ngDriver.waitForAngularRequestsToFinish();
			System.out.println("Clicked on the assign to field.");

			// click on the none button
			click("checklist_wizard_task_nonebtn_XPATH");
			ngDriver.waitForAngularRequestsToFinish();
			System.out.println("Clicked on the none button.");

			// enter user name in search field
			clear("questionnaire_inspection_tasks_assigntask_searchtxt_XPATH");
			type("questionnaire_inspection_tasks_assigntask_searchtxt_XPATH", data.get("username_update2"));
			ngDriver.waitForAngularRequestsToFinish();
			System.out.println("Entered user name in search field.");

			// click on the searched user
			click("questionnaire_inspection_tasks_assigntask_searcheduser_XPATH");
			ngDriver.waitForAngularRequestsToFinish();
			System.out.println("Clicked on the searched user.");

			// click on the assign to field
			click("questionnaire_inspection_tasks_assigntask_assigntotxt_XPATH");
			ngDriver.waitForAngularRequestsToFinish();
			System.out.println("Clicked on the assign to field.");

			// click on the update button
			click("questionnaire_inspection_tasks_assigntask_updatebtn_XPATH");
			ngDriver.waitForAngularRequestsToFinish();
			System.out.println("Clicked on the update button.");

			// wait for the element
			explicitWaitClickable("closetoastmsg_CSS");

			// click on the toaster close button
			click("closetoastmsg_CSS");
			ngDriver.waitForAngularRequestsToFinish();
			System.out.println("Clicked on the toaster close button.");

			// wait for the element
			Thread.sleep(5000);

			// scroll to the category one
			js.executeScript("window.scrollTo(0,0)");

			// validate the updated assign to
			try {
				String updatedAssignTo1_XPATH = "//p[text()='" + data.get("username_update2") + "']";
				String updatedAssignTo1 = (driver.findElement(By.xpath(updatedAssignTo1_XPATH)).getText()).trim();

				if (updatedAssignTo1.equals(data.get("username_update2"))) {

					successMessage("The updated assign to is displayed correctly.");

				} else {
					verificationFailedMessage("The updated assign to is not displayed correctly.");
				}

			} catch (Throwable t) {
				verificationFailed();
			}

			// UPDATE THE TASK COMMENT WITH THE TASK COMMENTS OPTION

			title("UPDATE THE TASK COMMENT WITH THE TASK COMMENTS OPTION");

			// scroll to the category one
			js.executeScript("window.scrollTo(0,0)");

			// click on the action icon
			click("questionnaire_inspection_tasks_actionicon_XPATH");
			ngDriver.waitForAngularRequestsToFinish();
			System.out.println("Clicked on the action icon.");

			// click on the task comments option
			click("questionnaire_inspection_tasks_taskcommentsoption_XPATH");
			ngDriver.waitForAngularRequestsToFinish();
			System.out.println("Clicked on the task comments option.");

			// click on the add comment button
			click("questionnaire_inspection_tasks_taskcomments_addcomment_XPATH");
			ngDriver.waitForAngularRequestsToFinish();
			System.out.println("Clicked on the add comment button.");

			// enter the text in the comment field
			clear("questionnaire_inspection_tasks_taskcomments_commenttxt_XPATH");
			type("questionnaire_inspection_tasks_taskcomments_commenttxt_XPATH", data.get("task_comment"));
			ngDriver.waitForAngularRequestsToFinish();
			System.out.println("Entered the text in the comment field.");

			// click on the add button
			click("questionnaire_inspection_tasks_taskcomments_addbtn_XPATH");
			ngDriver.waitForAngularRequestsToFinish();
			System.out.println("Clicked on the add button.");

			// verify added task comment is displayed or not
			switchVerification("questionnaire_inspection_tasks_taskcomments_createdtaskcomment_XPATH",
					data.get("task_comment"), "The newly added task comment is not displayed.");

			// click on the back to task button
			click("questionnaire_inspection_tasks_taskcomments_backtotaskbtn_XPATH");
			ngDriver.waitForAngularRequestsToFinish();
			System.out.println("Clicked on the back to task button.");

			// SELECT THE SHARE BY EMAIL OPTION

			title("SELECT THE SHARE BY EMAIL OPTION");

			// scroll to the category one
			js.executeScript("window.scrollTo(0,0)");

			// click on the action icon
			click("questionnaire_inspection_tasks_actionicon_XPATH");
			ngDriver.waitForAngularRequestsToFinish();
			System.out.println("Clicked on the action icon.");

			// click on the share by email option
			click("questionnaire_inspection_tasks_sharebyemailoption_XPATH");
			ngDriver.waitForAngularRequestsToFinish();
			System.out.println("Clicked on the share by email option.");

			// wait for the element
			Thread.sleep(5000);

			// click on the recipient field
			click("questionnaire_inspection_tasks_sharebyemail_recipienttxt_XPATH");
			ngDriver.waitForAngularRequestsToFinish();
			System.out.println("Clicked on the recipient field.");

			// click on the none button
			click("checklist_wizard_task_nonebtn_XPATH");
			ngDriver.waitForAngularRequestsToFinish();
			System.out.println("Clicked on the none button.");

			// enter the user name in the search field
			clear("questionnaire_inspection_tasks_assigntask_searchtxt_XPATH");
			type("questionnaire_inspection_tasks_assigntask_searchtxt_XPATH", data.get("username_update"));
			ngDriver.waitForAngularRequestsToFinish();
			System.out.println("Entered the user name in the search field.");

			// click on the searched user name
			click("checklist_wizard_task_updatedassignedtosearchedresult_XPATH");
			ngDriver.waitForAngularRequestsToFinish();
			System.out.println("Clicked on the searched user name.");

			// click on the recipient field
			click("questionnaire_inspection_tasks_sharebyemail_recipienttxt_XPATH");
			ngDriver.waitForAngularRequestsToFinish();
			System.out.println("Clicked on the recipient field.");

			// click on the send button
			click("questionnaire_inspection_tasks_sharebyemail_sendbtn_XPATH");
			ngDriver.waitForAngularRequestsToFinish();
			System.out.println("Clicked on the send button.");

			// wait for the element
			explicitWaitClickable("closetoastmsg_CSS");

			// click on the toaster close button
			click("closetoastmsg_CSS");
			ngDriver.waitForAngularRequestsToFinish();
			System.out.println("Clicked on the toaster close button.");

//			// SELECT THE ATTACHMENTS/PHOTOS OPTION
//
//			title("SELECT THE ATTACHMENTS/PHOTOS OPTION");
//
//			// scroll to the category one
//			js.executeScript("window.scrollTo(0,0)");
//
//			// click on the action icon
//			click("questionnaire_inspection_tasks_actionicon_XPATH");
//			ngDriver.waitForAngularRequestsToFinish();
//			System.out.println("Clicked on the action icon.");
//
//			// click on the share by attachments/photos option
//			click("questionnaire_inspection_tasks_attachmentsoption_XPATH");
//			ngDriver.waitForAngularRequestsToFinish();
//			System.out.println("Clicked on the attachments/photos option.");
//
//			// click on the upload file button
//			click("questionnaire_inspection_tasks_attachments_uploadbtn_XPATH");
//			ngDriver.waitForAngularRequestsToFinish();
//			System.out.println("Clicked on the upload file button.");
//
//			// ************** MISSING CODE - ADD FILE UPLOAD CODE **************
//
//			// wait for the element
//			explicitWaitClickable("closetoastmsg_CSS");
//
//			// click on the toaster close button
//			click("closetoastmsg_CSS");
//			ngDriver.waitForAngularRequestsToFinish();
//			System.out.println("Clicked on the toaster close button.");
//
//			// click on the back to task button
//			click("questionnaire_inspection_tasks_attachments_backtotaskbtn_XPATH");
//			ngDriver.waitForAngularRequestsToFinish();
//			System.out.println("Clicked on the back to task button.");

			// SELECT THE COMPLETE TASK OPTION

			title("SELECT THE COMPLETE TASK OPTION");

			// scroll to the category one
			js.executeScript("window.scrollTo(0,0)");

			// click on the action icon
			click("questionnaire_inspection_tasks_actionicon_XPATH");
			ngDriver.waitForAngularRequestsToFinish();
			System.out.println("Clicked on the action icon.");

			// click on the complete task option
			click("questionnaire_inspection_tasks_completetaskoption_XPATH");
			ngDriver.waitForAngularRequestsToFinish();
			System.out.println("Clicked on the complete task option.");

			// wait for the element
			explicitWaitClickable("closetoastmsg_CSS");

			// click on the toaster close button
			click("closetoastmsg_CSS");
			ngDriver.waitForAngularRequestsToFinish();
			System.out.println("Clicked on the toaster close button.");

			// scroll to the category one
			js.executeScript("window.scrollTo(0,0)");

			// validate the task is displayed or not
			try {

				String updatedTaskTitle1_XPATH = "//label[@ng-click='loadSelectedQuestionnaireCategoryTaskDetails(task, false);']";
				String updatedTaskTitle1 = (driver.findElement(By.xpath(updatedTaskTitle1_XPATH)).getText()).trim();

				if (updatedTaskTitle1.equals(updateRandomTaskTitle)) {

					verificationFailedMessage("The task is displayed even if the task is completed successfully.");

				} else {

					successMessage("The task is not displayed, Because it's completed successfully.");

				}

			} catch (Throwable t) {
				successMessage("The task is not displayed, Because it's completed successfully.");
			}

			// click on the home icon from the top of the screen
			click("questionnaire_homeburgermenubtn_hide_CSS");
			System.out.println("Clicked on the home icon from the top of the screen.");
			ngDriver.waitForAngularRequestsToFinish();

			// wait for the element
			explicitWait("propertylist_title_XPATH");

			// verify the property list
			switchVerification("propertylist_title_XPATH", "Property List", "The property list is not displayed.");

			// click on the task icon
			click("taskicon_CSS");
			System.out.println("Clicked on the task icon.");
			ngDriver.waitForAngularRequestsToFinish();

			// select the complete option from the status dropdown
			select("questionnaire_inspection_tasks_statusdd_XPATH", data.get("status_closed"));
			ngDriver.waitForAngularRequestsToFinish();
			System.out.println("Selected the complete option from the status dropdown.");

			// click on the clear button
			click("task_createdtask_clearbtn_XPATH");
			ngDriver.waitForAngularRequestsToFinish();
			System.out.println("Clicked on the clear button.");

			// enter the data in the search field
			type("task_filter_CSS", updateRandomTaskTitle);
			System.out.println("Entered the data in the search field.");
			ngDriver.waitForAngularRequestsToFinish();

			// click on the search button
			click("task_createdtask_searchbtn_XPATH");
			ngDriver.waitForAngularRequestsToFinish();
			System.out.println("Clicked on the search button.");

			try {
				// verify newly created task is displayed or not
				String closedStatus = "//p[text()='" + updateRandomTaskTitle
						+ "']//parent::td[@ng-click='editTaskFromLandingPage(task)']//following-sibling::td[text()='Closed']";
				String completedTask = (driver.findElement(By.xpath(closedStatus)).getText()).trim();

				if (completedTask.equals("Closed")) {

					successMessage("The closed task is displayed in the closed task list of task module.");

				} else {

					verificationFailedMessage(
							"The closed task is not displayed in the closed task list of task module.");

				}

			} catch (Throwable t) {
				verificationFailedMessage("The closed task is not displayed in the closed task list of task module.");
			}

			// click on the searched task
			String closedStatus = "//p[text()='" + updateRandomTaskTitle
					+ "']//parent::td[@ng-click='editTaskFromLandingPage(task)']//following-sibling::td[text()='Closed']";
			driver.findElement(By.xpath(closedStatus)).click();
			ngDriver.waitForAngularRequestsToFinish();
			System.out.println("Clicked on the searched task.");

			// click on the reopen button
			click("questionnaire_inspection_tasks_reopenbtn_XPATH");
			ngDriver.waitForAngularRequestsToFinish();
			System.out.println("Clicked on the reopen button.");

			// wait for the element
			explicitWaitClickable("closetoastmsg_CSS");

			// click on the toaster close button
			click("closetoastmsg_CSS");
			ngDriver.waitForAngularRequestsToFinish();
			System.out.println("Clicked on the toaster close button.");

			// click on the home icon from the top of the screen
			click("questionnaire_homeburgermenubtn_hide_CSS");
			System.out.println("Clicked on the home icon from the top of the screen.");
			ngDriver.waitForAngularRequestsToFinish();

			// wait for the element
			explicitWait("propertylist_title_XPATH");

			// verify the property list
			switchVerification("propertylist_title_XPATH", "Property List", "The property list is not displayed.");

			// click on the environmental icon from the property list page
			click("environmentalicon_CSS");
			System.out.println("Clicked on the environmental icon of the Property.");
			ngDriver.waitForAngularRequestsToFinish();
			System.out.println("Navigate to the environmental screen of the perticular property.");

			// wait for the element
			explicitWaitClickable("menubtn_CSS");

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

			// enter the inspection name in the search field
			clear("sustainability_searchtxt_XPATH");
			type("sustainability_searchtxt_XPATH", data.get("checklist_property_title"));
			ngDriver.waitForAngularRequestsToFinish();
			System.out.println("Entered the inspection name in the search field.");

			// click on the newly searched inspection
			String inspection1 = "//td[text()='" + data.get("checklist_property_title") + "']";
			driver.findElement(By.xpath(inspection1)).click();
			ngDriver.waitForAngularRequestsToFinish();
			System.out.println("Clicked on the newly searched inspection.");

			// scroll to the category one
			js.executeScript("window.scrollTo(0,0)");

			try {
				// validate the updated task title
				String updatedTaskTitle_XPATH = "//label[@ng-click='loadSelectedQuestionnaireCategoryTaskDetails(task, false);']";
				String updatedTaskTitle = (driver.findElement(By.xpath(updatedTaskTitle_XPATH)).getText()).trim();

				if (updatedTaskTitle.equals(updateRandomTaskTitle)) {

					successMessage("The updated task title is displayed correctly.");

				} else {
					verificationFailedMessage("The updated task title is not displayed correctly.");
				}

			} catch (Throwable t) {
				verificationFailed();
			}

			// SELECT THE CANCEL TASK OPTION

			title("SELECT THE CANCEL TASK OPTION");

			// scroll to the category one
			js.executeScript("window.scrollTo(0,0)");

			// click on the action icon
			click("questionnaire_inspection_tasks_actionicon_XPATH");
			ngDriver.waitForAngularRequestsToFinish();
			System.out.println("Clicked on the action icon.");

			// click on the cancel task option
			click("questionnaire_inspection_tasks_canceltaskoption_XPATH");
			ngDriver.waitForAngularRequestsToFinish();
			System.out.println("Clicked on the cancel task option.");

			// wait for the element
			explicitWaitClickable("closetoastmsg_CSS");

			// click on the toaster close button
			click("closetoastmsg_CSS");
			ngDriver.waitForAngularRequestsToFinish();
			System.out.println("Clicked on the toaster close button.");

			// scroll to the category one
			js.executeScript("window.scrollTo(0,0)");

			// validate the task is displayed or not
			try {

				String updatedTaskTitle1_XPATH = "//label[@ng-click='loadSelectedQuestionnaireCategoryTaskDetails(task, false);']";
				String updatedTaskTitle1 = (driver.findElement(By.xpath(updatedTaskTitle1_XPATH)).getText()).trim();

				if (updatedTaskTitle1.equals(updateRandomTaskTitle)) {

					verificationFailedMessage("The task is displayed even if the task is cancelled successfully.");

				} else {

					successMessage("The task is not displayed, Because it's cancelled successfully.");

				}

			} catch (Throwable t) {
				successMessage("The task is not displayed, Because it's cancelled successfully.");
			}

			// click on the home icon from the top of the screen
			click("questionnaire_homeburgermenubtn_hide_CSS");
			System.out.println("Clicked on the home icon from the top of the screen.");
			ngDriver.waitForAngularRequestsToFinish();

			// wait for the element
			explicitWait("propertylist_title_XPATH");

			// verify the property list
			switchVerification("propertylist_title_XPATH", "Property List", "The property list is not displayed.");

			// click on the task icon
			click("taskicon_CSS");
			System.out.println("Clicked on the task icon.");
			ngDriver.waitForAngularRequestsToFinish();

			// select the complete option from the status dropdown
			select("questionnaire_inspection_tasks_statusdd_XPATH", data.get("status_closed"));
			ngDriver.waitForAngularRequestsToFinish();
			System.out.println("Selected the complete option from the status dropdown.");

			// click on the clear button
			click("task_createdtask_clearbtn_XPATH");
			ngDriver.waitForAngularRequestsToFinish();
			System.out.println("Clicked on the clear button.");

			// enter the data in the search field
			type("task_filter_CSS", updateRandomTaskTitle);
			System.out.println("Entered the data in the search field.");
			ngDriver.waitForAngularRequestsToFinish();

			// click on the search button
			click("task_createdtask_searchbtn_XPATH");
			ngDriver.waitForAngularRequestsToFinish();
			System.out.println("Clicked on the search button.");

			try {
				// verify newly created task is displayed or not
				String closedStatus1 = "//p[text()='" + updateRandomTaskTitle
						+ "']//parent::td[@ng-click='editTaskFromLandingPage(task)']//following-sibling::td[text()='Cancelled']";
				String calcelledTask1 = (driver.findElement(By.xpath(closedStatus1)).getText()).trim();

				if (calcelledTask1.equals("Cancelled")) {

					successMessage("The calcelled task is displayed in the closed task list of task module.");

				} else {

					verificationFailedMessage(
							"The calcelled task is not displayed in the closed task list of task module.");

				}

			} catch (Throwable t) {
				verificationFailedMessage(
						"The calcelled task is not displayed in the closed task list of task module.");
			}

			// click on the searched task
			String calcelledStatus1 = "//p[text()='" + updateRandomTaskTitle
					+ "']//parent::td[@ng-click='editTaskFromLandingPage(task)']//following-sibling::td[text()='Cancelled']";
			driver.findElement(By.xpath(calcelledStatus1)).click();
			ngDriver.waitForAngularRequestsToFinish();
			System.out.println("Clicked on the searched task.");

			// click on the reopen button
			click("questionnaire_inspection_tasks_reopenbtn_XPATH");
			ngDriver.waitForAngularRequestsToFinish();
			System.out.println("Clicked on the reopen button.");

			// wait for the element
			explicitWaitClickable("closetoastmsg_CSS");

			// click on the toaster close button
			click("closetoastmsg_CSS");
			ngDriver.waitForAngularRequestsToFinish();
			System.out.println("Clicked on the toaster close button.");

			// click on the home icon from the top of the screen
			click("questionnaire_homeburgermenubtn_hide_CSS");
			System.out.println("Clicked on the home icon from the top of the screen.");
			ngDriver.waitForAngularRequestsToFinish();

			// wait for the element
			explicitWait("propertylist_title_XPATH");

			// verify the property list
			switchVerification("propertylist_title_XPATH", "Property List", "The property list is not displayed.");

			// click on the environmental icon from the property list page
			click("environmentalicon_CSS");
			System.out.println("Clicked on the environmental icon of the Property.");
			ngDriver.waitForAngularRequestsToFinish();
			System.out.println("Navigate to the environmental screen of the perticular property.");

			// wait for the element
			explicitWaitClickable("menubtn_CSS");

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

			// enter the inspection name in the search field
			clear("sustainability_searchtxt_XPATH");
			type("sustainability_searchtxt_XPATH", data.get("checklist_property_title"));
			ngDriver.waitForAngularRequestsToFinish();
			System.out.println("Entered the inspection name in the search field.");

			// click on the newly searched inspection
			String inspection11 = "//td[text()='" + data.get("checklist_property_title") + "']";
			driver.findElement(By.xpath(inspection11)).click();
			ngDriver.waitForAngularRequestsToFinish();
			System.out.println("Clicked on the newly searched inspection.");

			// scroll to the category one
			js.executeScript("window.scrollTo(0,0)");

			try {
				// validate the updated task title
				String updatedTaskTitle_XPATH = "//label[@ng-click='loadSelectedQuestionnaireCategoryTaskDetails(task, false);']";
				String updatedTaskTitle = (driver.findElement(By.xpath(updatedTaskTitle_XPATH)).getText()).trim();

				if (updatedTaskTitle.equals(updateRandomTaskTitle)) {

					successMessage("The updated task title is displayed correctly.");

				} else {
					verificationFailedMessage("The updated task title is not displayed correctly.");
				}

			} catch (Throwable t) {
				verificationFailed();
			}

			// SELECT THE DELETE TASK OPTION

			title("SELECT THE DELETE TASK OPTION");

			// scroll to the category one
			js.executeScript("window.scrollTo(0,0)");

			// click on the action icon
			click("questionnaire_inspection_tasks_actionicon_XPATH");
			ngDriver.waitForAngularRequestsToFinish();
			System.out.println("Clicked on the action icon.");

			// click on the delete task option
			click("questionnaire_inspection_tasks_deletetaskoption_XPATH");
			ngDriver.waitForAngularRequestsToFinish();
			System.out.println("Clicked on the cancel task option.");

			// wait for the element
			explicitWaitClickable("closetoastmsg_CSS");

			// click on the toaster close button
			click("closetoastmsg_CSS");
			ngDriver.waitForAngularRequestsToFinish();
			System.out.println("Clicked on the toaster close button.");

			// scroll to the category one
			js.executeScript("window.scrollTo(0,0)");

			// validate the task is displayed or not
			try {

				String updatedTaskTitle2_XPATH = "//label[@ng-click='loadSelectedQuestionnaireCategoryTaskDetails(task, false);']";
				String updatedTaskTitle2 = (driver.findElement(By.xpath(updatedTaskTitle2_XPATH)).getText()).trim();

				if (updatedTaskTitle2.equals(updateRandomTaskTitle)) {

					verificationFailedMessage("The task is displayed even if the task is deleted successfully.");

				} else {

					successMessage("The task is not displayed, Because it's deleted successfully.");

				}

			} catch (Throwable t) {
				successMessage("The task is not displayed, Because it's deleted successfully.");
			}

			// click on the home icon from the top of the screen
			click("questionnaire_homeburgermenubtn_hide_CSS");
			System.out.println("Clicked on the home icon from the top of the screen.");
			ngDriver.waitForAngularRequestsToFinish();

			// wait for the element
			explicitWait("propertylist_title_XPATH");

			// verify the property list
			switchVerification("propertylist_title_XPATH", "Property List", "The property list is not displayed.");

			// click on the task icon
			click("taskicon_CSS");
			System.out.println("Clicked on the task icon.");
			ngDriver.waitForAngularRequestsToFinish();

			// select the complete option from the status dropdown
			select("questionnaire_inspection_tasks_statusdd_XPATH", data.get("status_deleted"));
			ngDriver.waitForAngularRequestsToFinish();
			System.out.println("Selected the complete option from the status dropdown.");

			// click on the clear button
			click("task_createdtask_clearbtn_XPATH");
			ngDriver.waitForAngularRequestsToFinish();
			System.out.println("Clicked on the clear button.");

			// enter the data in the search field
			type("task_filter_CSS", updateRandomTaskTitle);
			System.out.println("Entered the data in the search field.");
			ngDriver.waitForAngularRequestsToFinish();

			// click on the search button
			click("task_createdtask_searchbtn_XPATH");
			ngDriver.waitForAngularRequestsToFinish();
			System.out.println("Clicked on the search button.");

			try {
				// verify newly created task is displayed or not
				String deletedStatus1 = "//p[text()='" + updateRandomTaskTitle + "']";
				boolean deletedTask1 = driver.findElement(By.xpath(deletedStatus1)).isDisplayed();

				if (deletedTask1 == true) {

					successMessage("The deleted task is displayed in the deleted task list of task module.");

				} else {

					verificationFailedMessage(
							"The deleted task is not displayed in the deleted task list of task module.");

				}

			} catch (Throwable t) {
				verificationFailedMessage("The deleted task is not displayed in the deleted task list of task module.");
			}

		} catch (Throwable t) {
			verificationFailed();
		}

		// click on the home icon from the top of the screen
		click("questionnaire_homeburgermenubtn_hide_CSS");
		System.out.println("Clicked on the home icon from the top of the screen.");
		ngDriver.waitForAngularRequestsToFinish();

		// wait for the element
		explicitWait("propertylist_title_XPATH");

		// verify the property list
		switchVerification("propertylist_title_XPATH", "Property List", "The property list is not displayed.");

		// DELETE THE NEWLY CREATED INSPECTION

		title("DELETE THE NEWLY CREATED INSPECTION");

		try {

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

			// enter the inspection name in the search field
			clear("sustainability_searchtxt_XPATH");
			type("sustainability_searchtxt_XPATH", data.get("checklist_property_title"));
			ngDriver.waitForAngularRequestsToFinish();
			System.out.println("Entered the inspection name in the search field.");

			// click on the newly created inspection
			String inspection = "//td[text()='" + data.get("checklist_property_title")
					+ "']//following-sibling::td[@class='text-center pointer']//i[@id='action']";
			driver.findElement(By.xpath(inspection)).click();
			ngDriver.waitForAngularRequestsToFinish();
			System.out.println("Clicked on the newly created inspection.");

			// click on the delete option
			String deleteOption = "//td[text()='" + data.get("checklist_property_title")
					+ "']//following-sibling::td[@class='text-center pointer']//div[@class='dropdown open']//li[@id='delete']";
			driver.findElement(By.xpath(deleteOption)).click();
			ngDriver.waitForAngularRequestsToFinish();
			System.out.println("Clicked on the delete button.");

			// wait for the element
			Thread.sleep(5000);

			// click on the delete button
			click("checklist_deletebtn_XPATH");
			ngDriver.waitForAngularRequestsToFinish();
			System.out.println("Clicked on the delete button.");

		} catch (Throwable t) {
			verificationFailed();
		}

		// click on the home option from the side menu
		click("questionnaire_homeburgermenubtn_hide_CSS");
		System.out.println("Clicked on the home option from the side menu");
		ngDriver.waitForAngularRequestsToFinish();

		// wait for the element
		explicitWait("propertylist_title_XPATH");

		// verify the property list
		switchVerification("propertylist_title_XPATH", "Property List", "The property list is not displayed.");

		// DELETE THE NEWLY CREATED QUESTIONNAIRES

		title("DELETE THE NEWLY CREATED QUESTIONNAIRES");

		try {
			// wait for the element
			Thread.sleep(5000);

			// click on the settings icon from the top of the screen
			click("questionnaire_settingicon_CSS");
			System.out.println("Clicked on the settings icon.");
			ngDriver.waitForAngularRequestsToFinish();

			// wait for the element
			explicitWaitClickable("questionnaire_administrationoption_XPATH");

			// click on the Administration option from the side menu
			click("questionnaire_administrationoption_XPATH");
			System.out.println("Clicked on the Administration option from the side menu.");
			ngDriver.waitForAngularRequestsToFinish();

			// click on the Questionnaires tab
			click("questionnaire_questionnairestab_XPATH");
			System.out.println("Clicked on the Questionnaires tab.");
			ngDriver.waitForAngularRequestsToFinish();

			// click on the Questionnaires option
			click("questionnaire_questionnairesoption_XPATH");
			System.out.println("Clicked on the Questionnaires option.");
			ngDriver.waitForAngularRequestsToFinish();

			// enter newly created questionnaire in the filter field
			clear("ssc_company2_questionnairelist_filtertxt_CSS");
			type("ssc_company2_questionnairelist_filtertxt_CSS", data.get("questionnaire_checklist_title"));
			System.out.println("Entered newly created questionnaire in the filter field.");
			ngDriver.waitForAngularRequestsToFinish();

			// click on the created questionnaire
			click("questionnaire_addtaskoption3_XPATH");
			System.out.println("Clicked on the newly created questionnaire.");
			ngDriver.waitForAngularRequestsToFinish();

			// scroll down to bottom of the screen
			JavascriptExecutor js = (JavascriptExecutor) driver;
			js.executeScript("window.scrollBy(0,document.body.scrollHeight)", "");

			// wait for the element
			Thread.sleep(5000);

			// click on the delete button
			click("checklist_wizard_deletebtn_XPATH");
			ngDriver.waitForAngularRequestsToFinish();
			System.out.println("Clicked on the delete button.");

			// wait for the element
			Thread.sleep(5000);

			// click on the delete button of the confirmation popup model
			click("checklist_wizard_confirmationdeletebtn_XPATH");
			ngDriver.waitForAngularRequestsToFinish();
			System.out.println("Clicked on the delete button of the confirmation popup model.");

			// enter newly created questionnaire in the filter field
			clear("ssc_company2_questionnairelist_filtertxt_CSS");
			type("ssc_company2_questionnairelist_filtertxt_CSS", data.get("questionnaire_checklist_title"));
			System.out.println("Entered newly created questionnaire in the filter field.");
			ngDriver.waitForAngularRequestsToFinish();

			// validate whether the questionnaire deleted or not
			helper.deleteVerification("questionnaire_addtaskoption3_XPATH", "Questionnaire Add Task Option Three Title");

		} catch (Throwable t) {
			verificationFailed();
		}

		// click on the home icon from the top of the screen
		click("questionnaire_homeburgermenubtn_CSS");
		System.out.println("Clicked on the home icon from the top of the screen.");
		ngDriver.waitForAngularRequestsToFinish();

		// wait for the element
		explicitWait("propertylist_title_XPATH");

		// verify the property list
		switchVerification("propertylist_title_XPATH", "Property List", "The property list is not displayed.");

	}

}
