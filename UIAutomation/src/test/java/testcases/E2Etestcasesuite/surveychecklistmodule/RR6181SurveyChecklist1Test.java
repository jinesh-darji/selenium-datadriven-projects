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

public class RR6181SurveyChecklist1Test extends TestBase {

	@Test(dataProviderClass = TestUtil.class, dataProvider = "dp")
	public void rR6181SurveyChecklist1Test(Hashtable<String, String> data) throws IOException, InterruptedException {

		execution(data, "rR6181SurveyChecklist1Test");

		// CREATE THE CHECKLIST IN PROPERTY AND VALIDATE THE ADD TASK OPTION FOR THE
		// INDIVIDUAL CATEGORY OF THE INSPECTION.
		title("CREATE THE CHECKLIST IN PROPERTY AND VALIDATE THE ADD TASK OPTION FOR THE INDIVIDUAL CATEGORY OF THE INSPECTION.");

		Helper helper = new Helper();

		// refresh the page
		driver.navigate().refresh();
		Thread.sleep(5000);
		driver.navigate().refresh();

		// DELETE ALL THE PREVIOUSLY CREATED TASKS FROM MY TASK LIST
		title("DELETE ALL THE PREVIOUSLY CREATED TASKS FROM MY TASK LIST");

		try {

			// wait for the element
			Thread.sleep(5000);

			// click on the side menu
			click("menubtn_CSS");

			// wait for the element
			Thread.sleep(5000);

			// click on the my task option
			click("mytask_sidemenu_XPATH");

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

						// wait for the element
						Thread.sleep(3000);

						// click on the delete option
						click("mytask_firstactionicon_deleteoption_XPATH");

						// wait for the element
						explicitWaitClickable("closetoastmsg_CSS");

						// click on the toaster close button
						click("closetoastmsg_CSS");

					}
					// click on the next button
					click("task_permission_roles_nextbtn_CSS");
				}
			} catch (Throwable t) {
				successMessage("Successfully deleted all the tasks.");
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

		// ADD NEW QUESTIONNIRE FOR INSPECTION
		title("ADD NEW QUESTIONNIRE FOR INSPECTION");

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

			// click on the new questionnaire
			click("questionnaire_newquestionnairebtn_CSS");

			// Select the Inspection / Checklist of the questionnaire
			click("questionnaire_type_inspectionbtn_CSS");

			// Select the level of the questionnaire
			click("questionnaire_level_propertybtn_CSS");

			// enter the group title
			type("questionnaire_grouptitletxt_CSS", data.get("group_title"));

			// enter the questionnaire title
			type("questionnaire_languagetitle_CSS", data.get("questionnaire_checklist_title"));

			// select the model
			select("questionnaire_modeldd_CSS", data.get("model"));

			// select the frequency
			select("questionnaire_frequencydd_CSS", data.get("frequency"));

			// enter frequency interval
			type("questionnaire_frequencyintervaltxt_CSS", "1");

			// select the month
			select("questionnaire_monthtxt_CSS", data.get("month"));

			// enter the description
			type("questionnaire_descriptiontxt_CSS", data.get("description"));

			// select the classic option from the default view drop down
			select("questionnaire_checklist_defaultview_CSS", data.get("default_view"));

			// scroll down to the save button
			scrollBottom();

			// click on the save button
			click("questionnaire_savebtn_BTNTEXT");

			// enter newly created questionnaire in the filter field
			type("ssc_company2_questionnairelist_filtertxt_CSS", data.get("questionnaire_checklist_title"));

			// verify newly created questionnaire for checklist
			switchVerification("questionnaire_addtaskoption_XPATH", "Questionnaire Add Task Option One Title",
					"The Questionnaire Add Task Option One Title record is not displayed in the questionnaire list.");

			// CONFIGRATION OF QUESTION
			title("CONFIGRATION OF QUESTION");

			// click on the created questionnaire
			click("questionnaire_addtaskoption_XPATH");

			helper.configureQuestions(data);

			// enter newly created questionnaire in the filter field
			type("ssc_company2_questionnairelist_filtertxt_CSS", data.get("questionnaire_checklist_title"));

			// verify newly created questionnaire for checklist
			switchVerification("questionnaire_addtaskoption_XPATH", "Questionnaire Add Task Option One Title",
					"The Questionnaire Add Task Option One Title record is not displayed in the questionnaire list.");

		} catch (Throwable t) {
			verificationFailed();
		}

		// click on the Home Icon from the top of the screen
		click("questionnaire_homeburgermenubtn_CSS");

		// wait for the element
		explicitWait("propertylist_title_XPATH");

		// verify the property list
		switchVerification("propertylist_title_XPATH", "Property List", "The property list is not displayed.");

		// CREATE INSPECTION AT PROPERTY LEVEL
		title("CREATE INSPECTION AT PROPERTY LEVEL");

		try {
			// click on the environmental icon from the property list page
			click("environmentalicon_CSS");

			// wait for the element
			explicitWaitClickable("menubtn_CSS");

			// click on the burger menu
			click("menubtn_CSS");

			// wait for the element
			Thread.sleep(5000);

			// click on the checklist/inspection option from side menu
			click("checklist_sidemenu_XPATH");

			// select the property level from the dropdown
			select("survey_leveldropdown_CSS", data.get("property_leveldropdown"));

			// click on the new checklist button
			click("checklist_newchecklistbtn_CSS");

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

							successMessage("The checklist is displayed successfully.");

							// select the questionnaire option from the checklist type dropdown
							select("checklist_addchecklist_checklisttypedd_CSS",
									data.get("questionnaire_checklist_title"));

							// enter data in the checklist title field
							type("checklist_addchecklist_titletxt_CSS", data.get("checklist_property_title"));

							// click on the save button
							click("checklist_addchecklist_savebtn_CSS");

							// verify questionnaire is selected correctly or not
							switchVerification("questionnaire_questiontitle_XPATH", "Test Category Title One",
									"The Test Category Title One is not displayed.");

							break;

						}
					} catch (Throwable t) {

						verificationFailedMessage(" The " + data.get("questionnaire_checklist_title")
								+ " is not displayed in the dropdown.");

						// refresh the screen
						driver.navigate().refresh();
						Thread.sleep(5000);
						driver.navigate().refresh();
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

		// wait for the element
		explicitWait("propertylist_title_XPATH");

		// verify the property list
		switchVerification("propertylist_title_XPATH", "Property List", "The property list is not displayed.");

		// VALIDATE THE ADD TASK OPTION AND CREATE RANDOM NUMBER OF TASK FOR THE
		// CATEGORY ONE OF THE INSPECTION
		title("VALIDATE THE ADD TASK OPTION AND CREATE RANDOM NUMBER OF TASK FOR THE CATEGORY ONE OF THE INSPECTION.");

		Random taskcount1 = new Random();
		int RandomTaskCount1 = taskcount1.nextInt(5 - 3) + 3;
		String RandomTaskCount1_String = Integer.toString(RandomTaskCount1);

		try {
			// click on the environmental icon from the property list page
			click("environmentalicon_CSS");

			// wait for the element
			explicitWaitClickable("menubtn_CSS");

			// click on the burger menu
			click("menubtn_CSS");

			// wait for the element
			Thread.sleep(5000);

			// click on the checklist/inspection option from side menu
			click("checklist_sidemenu_XPATH");

			// enter the inspection name in the search field
			type("sustainability_searchtxt_XPATH", data.get("checklist_property_title"));

			// click on the newly searched inspection
			String inspection = "//td[text()='" + data.get("checklist_property_title") + "']";
			driver.findElement(By.xpath(inspection)).click();

			for (int i = 0; i < RandomTaskCount1; i++) {

				// scroll to the category one
				scrollTillElement("questionnaire_inspection_category1_addtask_actionicon_XPATH");

				// click on the action icon of the category one
				click("questionnaire_inspection_category1_addtask_actionicon_XPATH");

				// click on the add task option
				click("questionnaire_inspection_category1_addtaskoption_XPATH");

				// enter the valid task title
				String randomTaskTitle = RandomStringUtils.randomAlphabetic(8);
				type("checklist_wizard_tasktitle_XPATH", randomTaskTitle);

				// click on the assign to field
				click("questionnaire_inspection_addtask_assigntotxt_XPATH");

				// click on the none button
				click("checklist_wizard_task_nonebtn_XPATH");

				// enter the user name in the search field
				type("checklist_wizard_task_assignedtosearchtxt_XPATH", data.get("username"));

				// click on the searched user
				click("checklist_wizard_task_assignedtosearchedresult_XPATH");

				// click on the assign to field
				click("questionnaire_inspection_addtask_assigntotxt_XPATH");

				// click on the save button
				click("questionnaire_inspection_addtask_savebtn_XPATH");

				// wait for the element
				explicitWaitClickable("closetoastmsg_CSS");

				// click on the toaster close button
				click("closetoastmsg_CSS");

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
				scrollTillElement("questionnaire_inspection_category2_addtask_actionicon_XPATH");

				// click on the action icon of the category two
				click("questionnaire_inspection_category2_addtask_actionicon_XPATH");

				// click on the add task option
				click("questionnaire_inspection_category2_addtaskoption_XPATH");

				// enter the valid task title
				String randomTaskTitle = RandomStringUtils.randomAlphabetic(8);
				type("checklist_wizard_tasktitle_XPATH", randomTaskTitle);

				// click on the assign to field
				click("questionnaire_inspection_addtask_assigntotxt_XPATH");

				// click on the none button
				click("checklist_wizard_task_nonebtn_XPATH");

				// enter the user name in the search field
				type("checklist_wizard_task_assignedtosearchtxt_XPATH", data.get("username"));

				// click on the searched user
				click("checklist_wizard_task_assignedtosearchedresult_XPATH");

				// click on the assign to field
				click("questionnaire_inspection_addtask_assigntotxt_XPATH");

				// click on the save button
				click("questionnaire_inspection_addtask_savebtn_XPATH");

				// wait for the element
				explicitWaitClickable("closetoastmsg_CSS");

				// click on the toaster close button
				click("closetoastmsg_CSS");
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

		// VALIDATE THE COUNT OF TASKS OF THE INDIVIDUAL CATEGORY OF THE INSPECTION - ON
		// THE CATEGORY PHOTOS SCREEN
		title("VALIDATE THE COUNT OF TASKS OF THE INDIVIDUAL CATEGORY OF THE INSPECTION - ON THE CATEGORY PHOTOS SCREEN");

		try {
			// click on the environmental icon from the property list page
			click("environmentalicon_CSS");

			// wait for the element
			explicitWaitClickable("menubtn_CSS");

			// click on the burger menu
			click("menubtn_CSS");

			// wait for the element
			Thread.sleep(5000);

			// click on the checklist/inspection option from side menu
			click("checklist_sidemenu_XPATH");

			// enter the inspection name in the search field
			type("sustainability_searchtxt_XPATH", data.get("checklist_property_title"));

			// click on the newly searched inspection
			String inspection = "//td[text()='" + data.get("checklist_property_title") + "']";
			driver.findElement(By.xpath(inspection)).click();

			// click on the category photo button
			click("questionnaire_inspection_addtask_categoryphotobtn_XPATH");

			// validate the count of the task of the category 1
			switchVerification("questionnaire_inspection_category1_photoscreen_taskcount_XPATH",
					RandomTaskCount1_String, "The count of the tasks are displayed incorrect.");

			// validate the count of the task of the category 2
			switchVerification("questionnaire_inspection_category2_photoscreen_taskcount_XPATH",
					RandomTaskCount2_String, "The count of the tasks are displayed incorrect.");

		} catch (Throwable t) {
			verificationFailed();
		}

		// click on the home icon from the top of the screen
		click("questionnaire_homeburgermenubtn_hide_CSS");

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

			// wait for the element
			Thread.sleep(5000);

			// click on the my task option
			click("mytask_sidemenu_XPATH");

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

						// wait for the element
						Thread.sleep(3000);

						// click on the delete option
						click("mytask_firstactionicon_deleteoption_XPATH");

						// wait for the element
						explicitWaitClickable("closetoastmsg_CSS");

						// click on the toaster close button
						click("closetoastmsg_CSS");
					}
					// click on the next button
					click("task_permission_roles_nextbtn_CSS");
				}
			} catch (Throwable t) {
				successMessage("Successfully deleted all the tasks.");
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

		// VALIDATE THE COUNT OF TASKS OF THE INDIVIDUAL CATEGORY OF THE INSPECTION - ON
		// THE CATEGORY PHOTOS SCREEN AFTER DELETE ALL THE TASKS
		title("VALIDATE THE COUNT OF TASKS OF THE INDIVIDUAL CATEGORY OF THE INSPECTION - ON THE CATEGORY PHOTOS SCREEN AFTER DELETE ALL THE TASKS");

		try {
			// click on the environmental icon from the property list page
			click("environmentalicon_CSS");

			// wait for the element
			explicitWaitClickable("menubtn_CSS");

			// click on the burger menu
			click("menubtn_CSS");

			// wait for the element
			Thread.sleep(5000);

			// click on the checklist/inspection option from side menu
			click("checklist_sidemenu_XPATH");

			// enter the inspection name in the search field
			type("sustainability_searchtxt_XPATH", data.get("checklist_property_title"));

			// click on the newly searched inspection
			String inspection = "//td[text()='" + data.get("checklist_property_title") + "']";
			driver.findElement(By.xpath(inspection)).click();

			// click on the category photo button
			click("questionnaire_inspection_addtask_categoryphotobtn_XPATH");

			// validate the count of the task of the category 1
			switchVerification("questionnaire_inspection_category1_photoscreen_taskcount_XPATH", "0",
					"The count of the tasks are displayed incorrect.");

			// validate the count of the task of the category 2
			switchVerification("questionnaire_inspection_category2_photoscreen_taskcount_XPATH", "0",
					"The count of the tasks are displayed incorrect.");

		} catch (Throwable t) {
			verificationFailed();
		}

		// click on the home icon from the top of the screen
		click("questionnaire_homeburgermenubtn_hide_CSS");

		// wait for the element
		explicitWait("propertylist_title_XPATH");

		// verify the property list
		switchVerification("propertylist_title_XPATH", "Property List", "The property list is not displayed.");

		// DELETE THE NEWLY CREATED INSPECTION
		title("DELETE THE NEWLY CREATED INSPECTION");

		try {

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

			// enter the inspection name in the search field
			type("sustainability_searchtxt_XPATH", data.get("checklist_property_title"));

			// click on the newly created inspection
			String inspection = "//td[text()='" + data.get("checklist_property_title")
					+ "']//following-sibling::td[@class='text-center pointer']//i[@id='action']";
			driver.findElement(By.xpath(inspection)).click();

			// click on the delete option
			String deleteOption = "//td[text()='" + data.get("checklist_property_title")
					+ "']//following-sibling::td[@class='text-center pointer']//div[@class='dropdown open']//li[@id='delete']";
			driver.findElement(By.xpath(deleteOption)).click();

			// wait for the element
			Thread.sleep(5000);

			// click on the delete button
			click("checklist_deletebtn_XPATH");

		} catch (Throwable t) {
			verificationFailed();
		}

		// click on the home option from the side menu
		click("questionnaire_homeburgermenubtn_hide_CSS");

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

			// wait for the element
			explicitWaitClickable("questionnaire_administrationoption_XPATH");

			// click on the Administration option from the side menu
			click("questionnaire_administrationoption_XPATH");

			// click on the Questionnaires tab
			click("questionnaire_questionnairestab_XPATH");

			// click on the Questionnaires option
			click("questionnaire_questionnairesoption_XPATH");

			// enter newly created questionnaire in the filter field
			type("ssc_company2_questionnairelist_filtertxt_CSS", data.get("questionnaire_checklist_title"));

			// click on the created questionnaire
			click("questionnaire_addtaskoption_XPATH");

			// scroll down to bottom of the screen
			scrollBottom();

			// wait for the element
			Thread.sleep(5000);

			// click on the delete button
			click("checklist_wizard_deletebtn_XPATH");

			// wait for the element
			Thread.sleep(5000);

			// click on the delete button of the confirmation popup model
			click("checklist_wizard_confirmationdeletebtn_XPATH");

			// enter newly created questionnaire in the filter field
			type("ssc_company2_questionnairelist_filtertxt_CSS", data.get("questionnaire_checklist_title"));

			// validate whether the questionnaire deleted or not
			helper.deleteVerification("questionnaire_addtaskoption_XPATH", "Questionnaire Add Task Option One Title");

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