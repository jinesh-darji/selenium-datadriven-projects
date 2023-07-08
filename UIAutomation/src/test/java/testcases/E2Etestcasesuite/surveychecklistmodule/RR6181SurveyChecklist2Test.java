package testcases.E2Etestcasesuite.surveychecklistmodule;

import java.io.IOException;
import java.util.Hashtable;
import java.util.List;
import java.util.Random;

import org.apache.commons.lang3.RandomStringUtils;
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

public class RR6181SurveyChecklist2Test extends TestBase {

	@Test(dataProviderClass = TestUtil.class, dataProvider = "dp")
	public void rR6181SurveyChecklist2Test(Hashtable<String, String> data) throws IOException, InterruptedException {

		execution(data, "rR6181SurveyChecklist2Test");

		// CREATE THE CHECKLIST IN PROPERTY AND VERIFY THE COUNT OF TASKS IN THE CLASSIC
		// MODE OF THE INSPECTION AND TASK MODULE

		System.out.println(
				"CREATE THE CHECKLIST IN PROPERTY AND VERIFY THE COUNT OF TASKS IN THE CLASSIC MODE OF THE INSPECTION AND TASK MODULE");
		test.log(LogStatus.INFO,
				"CREATE THE CHECKLIST IN PROPERTY AND VERIFY THE COUNT OF TASKS IN THE CLASSIC MODE OF THE INSPECTION AND TASK MODULE");
		Reporter.log(
				"CREATE THE CHECKLIST IN PROPERTY AND VERIFY THE COUNT OF TASKS IN THE CLASSIC MODE OF THE INSPECTION AND TASK MODULE");
		log.info(
				"CREATE THE CHECKLIST IN PROPERTY AND VERIFY THE COUNT OF TASKS IN THE CLASSIC MODE OF THE INSPECTION AND TASK MODULE");

		Helper helper = new Helper();
		
		// refresh the page
		driver.navigate().refresh();
		Thread.sleep(5000);
		driver.navigate().refresh();

		System.out.println("Navigate to the Home Screen i.e. Property List Screen.");

		// DELETE ALL THE PREVIOUSLY CREATED TASKS FROM MY TASK LIST

		title("DELETE ALL THE PREVIOUSLY CREATED TASKS FROM MY TASK LIST");

		try {

			// wait for the element
			Thread.sleep(5000);

			// click on the side menu
			click("menubtn_CSS");
			ngDriver.waitForAngularRequestsToFinish();
			System.out.println("Clicked on the side menu.");

			// wait for the element
			Thread.sleep(5000);

			// click on the my task option
			click("mytask_sidemenu_XPATH");
			ngDriver.waitForAngularRequestsToFinish();
			System.out.println("Clicked on the my task option.");

			// delete all the previously created tasks
			try {
				String pages = (driver
						.findElement(By.xpath(
								"//i[@ng-click='previousPageData()']//following-sibling::strong[@class='ng-binding']"))
						.getText()).trim();
				String[] arrOfStr = pages.split(" ");
				String pageno = arrOfStr[3];
				int pagecount = Integer.parseInt(pageno);

				for (int i = 0; i < pagecount; i++) {

					List<WebElement> roles = driver.findElements(By.xpath("//table[@id='tasksTable']//tbody//tr"));
					int rolesnum = roles.size();

					for (int j = 0; j < rolesnum; j++) {

						// wait for the element
						Thread.sleep(3000);

						// click on the action icon of the first record
						click("mytask_firstactionicon_XPATH");
						ngDriver.waitForAngularRequestsToFinish();
						System.out.println("Clicked on the action icon of the first record.");

						// wait for the element
						Thread.sleep(3000);

						// click on the delete option
						click("mytask_firstactionicon_deleteoption_XPATH");
						ngDriver.waitForAngularRequestsToFinish();
						System.out.println("Clicked on the delete option.");

						// wait for the element
						explicitWaitClickable("closetoastmsg_CSS");

						// click on the toaster close button
						click("closetoastmsg_CSS");
						ngDriver.waitForAngularRequestsToFinish();
						System.out.println("Clicked on the toaster close button.");

					}

					// click on the next button
					click("task_permission_roles_nextbtn_CSS");
					ngDriver.waitForAngularRequestsToFinish();
					System.out.println("Clicked on the next button.");

				}
			} catch (Throwable t) {

				successMessage("Successfully deleted all the tasks.");

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
			switchVerification("questionnaire_addtaskoption2_XPATH", "Questionnaire Add Task Option Two Title",
					"The Questionnaire Add Task Option Two Title record is not displayed in the questionnaire list.");

			// CONFIGRATION OF QUESTION

			System.out.println("***************** CONFIGRATION OF QUESTION *****************");
			test.log(LogStatus.INFO, "***************** CONFIGRATION OF QUESTION *****************");
			Reporter.log("***************** CONFIGRATION OF QUESTION *****************");
			log.info("***************** CONFIGRATION OF QUESTION *****************");

			// click on the created questionnaire
			click("questionnaire_addtaskoption2_XPATH");
			System.out.println("Clicked on the newly created questionnaire for checklist.");
			ngDriver.waitForAngularRequestsToFinish();

			helper.configureQuestions(data);

			// enter newly created questionnaire in the filter field
			clear("ssc_company2_questionnairelist_filtertxt_CSS");
			type("ssc_company2_questionnairelist_filtertxt_CSS", data.get("questionnaire_checklist_title"));
			System.out.println("Entered newly created questionnaire in the filter field.");
			ngDriver.waitForAngularRequestsToFinish();

			// verify newly created questionnaire for checklist
			switchVerification("questionnaire_addtaskoption2_XPATH", "Questionnaire Add Task Option Two Title",
					"The Questionnaire Add Task Option Two Title record is not displayed in the questionnaire list.");

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

		// VALIDATE THE ADD TASK OPTION AND CREATE RANDOM NUMBER OF TASK FOR THE
		// CATEGORY ONE OF THE INSPECTION

		title("VALIDATE THE ADD TASK OPTION AND CREATE RANDOM NUMBER OF TASK FOR THE CATEGORY ONE OF THE INSPECTION");

		Random taskcount1 = new Random();
		int RandomTaskCount1 = taskcount1.nextInt(5 - 3) + 3;
		String RandomTaskCount1_String = Integer.toString(RandomTaskCount1);

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

			for (int i = 0; i < RandomTaskCount1; i++) {

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
				String randomTaskTitle = RandomStringUtils.randomAlphabetic(8);
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

			}

			// VALIDATE THE COUNT OF THE TASKS OF THE CATEGORY 1 IN CLASSIC VIEW, IMMIDIATE
			// AFTER CREATE THE TASKS

			title("VALIDATE THE COUNT OF THE TASKS OF THE CATEGORY 1 IN CLASSIC VIEW, IMMIDIATE AFTER CREATE THE TASKS");

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

			if (taskCounts1.equals(RandomTaskCount1_String)) {

				successMessage("THE COUNT OF TASKS FOR THE CATEGORY ONE IN THE CLASSIC VIEW IS DISPLAYED CORRECTLY.");

			} else {

				verificationFailedMessage(
						"THE COUNT OF TASKS FOR THE CATEGORY ONE IN THE CLASSIC VIEW IS NOT DISPLAYED CORRECTLY.");

			}

		} catch (Throwable t) {
			verificationFailed();
		}

		// VALIDATE THE ADD TASK OPTION AND CREATE RANDOM NUMBER OF TASK FOR THE
		// CATEGORY TWO OF THE INSPECTION

		title("VALIDATE THE ADD TASK OPTION AND CREATE RANDOM NUMBER OF TASK FOR THE CATEGORY TWO OF THE INSPECTION");

		Random taskcount2 = new Random();
		int RandomTaskCount2 = taskcount2.nextInt(5 - 3) + 3;
		String RandomTaskCount2_String = Integer.toString(RandomTaskCount2);

		try {

			for (int i = 0; i < RandomTaskCount2; i++) {

				// scroll to the category two
				WebElement category2 = driver.findElement(
						By.xpath(OR.getProperty("questionnaire_inspection_category2_addtask_actionicon_XPATH")));
				JavascriptExecutor js = (JavascriptExecutor) driver;
				js.executeScript("arguments[0].scrollIntoView();", category2);

				// click on the action icon of the category two
				click("questionnaire_inspection_category2_addtask_actionicon_XPATH");
				ngDriver.waitForAngularRequestsToFinish();
				System.out.println("Clicked on the action icon of the category two.");

				// click on the add task option
				click("questionnaire_inspection_category2_addtaskoption_XPATH");
				ngDriver.waitForAngularRequestsToFinish();
				System.out.println("Clicked on the add task option.");

				// enter the valid task title
				String randomTaskTitle = RandomStringUtils.randomAlphabetic(8);
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

			}

			// VALIDATE THE COUNT OF THE TASKS OF THE CATEGORY 2 IN CLASSIC VIEW, IMMIDIATE
			// AFTER CREATE THE TASKS

			title("VALIDATE THE COUNT OF THE TASKS OF THE CATEGORY 2 IN CLASSIC VIEW, IMMIDIATE AFTER CREATE THE TASKS");

			// scroll to the category two
			WebElement category2 = driver.findElement(
					By.xpath(OR.getProperty("questionnaire_inspection_category2_addtask_actionicon_XPATH")));
			JavascriptExecutor js = (JavascriptExecutor) driver;
			js.executeScript("arguments[0].scrollIntoView();", category2);

			// validate the count of the task
			String taskStatement2 = (driver
					.findElement(
							By.xpath(OR.getProperty("questionnaire_inspection_category2_classicview_taskcount_XPATH")))
					.getText()).trim();
			String[] taskStatement2_arr = taskStatement2.split(" ");
			String taskCounts2 = taskStatement2_arr[0];

			if (taskCounts2.equals(RandomTaskCount2_String)) {

				successMessage("THE COUNT OF TASKS FOR THE CATEGORY TWO IN THE CLASSIC VIEW IS DISPLAYED CORRECTLY.");

			} else {

				verificationFailedMessage(
						"THE COUNT OF TASKS FOR THE CATEGORY TWO IN THE CLASSIC VIEW IS NOT DISPLAYED CORRECTLY.");

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

		// VALIDATE THE COUNT OF TASKS OF THE INDIVIDUAL CATEGORY OF THE INSPECTION - IN
		// THE CLASSIC VIEW OF THE INSPECTION

		title("VALIDATE THE COUNT OF TASKS OF THE INDIVIDUAL CATEGORY OF THE INSPECTION - IN THE CLASSIC VIEW OF THE INSPECTION");

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

			if (taskCounts1.equals(RandomTaskCount1_String)) {

				successMessage("THE COUNT OF TASKS FOR THE CATEGORY ONE IN THE CLASSIC VIEW IS DISPLAYED CORRECTLY.");

			} else {

				verificationFailedMessage(
						"THE COUNT OF TASKS FOR THE CATEGORY ONE IN THE CLASSIC VIEW IS NOT DISPLAYED CORRECTLY.");

			}

			// scroll to the category two
			WebElement category2 = driver.findElement(
					By.xpath(OR.getProperty("questionnaire_inspection_category2_addtask_actionicon_XPATH")));
			js.executeScript("arguments[0].scrollIntoView();", category2);

			// validate the count of the task
			String taskStatement2 = (driver
					.findElement(
							By.xpath(OR.getProperty("questionnaire_inspection_category2_classicview_taskcount_XPATH")))
					.getText()).trim();
			String[] taskStatement2_arr = taskStatement2.split(" ");
			String taskCounts2 = taskStatement2_arr[0];

			if (taskCounts2.equals(RandomTaskCount2_String)) {

				successMessage("THE COUNT OF TASKS FOR THE CATEGORY TWO IN THE CLASSIC VIEW IS DISPLAYED CORRECTLY.");

			} else {

				verificationFailedMessage(
						"THE COUNT OF TASKS FOR THE CATEGORY TWO IN THE CLASSIC VIEW IS NOT DISPLAYED CORRECTLY.");

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

		// VALIDATE THE COUNT OF THE TASKS IN THE TASKS MODULE

		title("VALIDATE THE COUNT OF THE TASKS IN THE TASKS MODULE");

		try {
			// click on the task icon
			click("taskicon_CSS");
			System.out.println("Clicked on the task icon.");
			ngDriver.waitForAngularRequestsToFinish();

			// validate the total count of the tasks
			String taskList = "//table[@id='tasksTable']//tbody//tr";
			List<WebElement> taskList_WebElement = driver.findElements(By.xpath(taskList));
			int taskCount = taskList_WebElement.size();

			if (taskCount == (RandomTaskCount1 + RandomTaskCount2)) {
				successMessage("THE COUNT OF THE TASKS ARE DISPLAYED CORRECTLY.");
			} else {
				verificationFailedMessage("THE COUNT OF THE TASKS ARE NOT DISPLAYED CORRECTLY.");
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

		// DELETE ALL THE PREVIOUSLY CREATED TASKS FROM MY TASK LIST

		title("DELETE ALL THE PREVIOUSLY CREATED TASKS FROM MY TASK LIST");

		try {

			// wait for the element
			Thread.sleep(5000);

			// click on the side menu
			click("menubtn_CSS");
			ngDriver.waitForAngularRequestsToFinish();
			System.out.println("Clicked on the side menu.");

			// wait for the element
			Thread.sleep(5000);

			// click on the my task option
			click("mytask_sidemenu_XPATH");
			ngDriver.waitForAngularRequestsToFinish();
			System.out.println("Clicked on the my task option.");

			// delete all the previously created tasks
			try {
				String pages = (driver
						.findElement(By.xpath(
								"//i[@ng-click='previousPageData()']//following-sibling::strong[@class='ng-binding']"))
						.getText()).trim();
				String[] arrOfStr = pages.split(" ");
				String pageno = arrOfStr[3];
				int pagecount = Integer.parseInt(pageno);

				for (int i = 0; i < pagecount; i++) {

					List<WebElement> roles = driver.findElements(By.xpath("//table[@id='tasksTable']//tbody//tr"));
					int rolesnum = roles.size();

					for (int j = 0; j < rolesnum; j++) {

						// wait for the element
						Thread.sleep(3000);

						// click on the action icon of the first record
						click("mytask_firstactionicon_XPATH");
						ngDriver.waitForAngularRequestsToFinish();
						System.out.println("Clicked on the action icon of the first record.");

						// wait for the element
						Thread.sleep(3000);

						// click on the delete option
						click("mytask_firstactionicon_deleteoption_XPATH");
						ngDriver.waitForAngularRequestsToFinish();
						System.out.println("Clicked on the delete option.");

						// wait for the element
						explicitWaitClickable("closetoastmsg_CSS");

						// click on the toaster close button
						click("closetoastmsg_CSS");
						ngDriver.waitForAngularRequestsToFinish();
						System.out.println("Clicked on the toaster close button.");

					}

					// click on the next button
					click("task_permission_roles_nextbtn_CSS");
					ngDriver.waitForAngularRequestsToFinish();
					System.out.println("Clicked on the next button.");

				}
			} catch (Throwable t) {

				successMessage("Successfully deleted all the tasks.");

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
			click("questionnaire_addtaskoption2_XPATH");
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
			helper.deleteVerification("questionnaire_addtaskoption2_XPATH", "Questionnaire Add Task Option Two Title");

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
