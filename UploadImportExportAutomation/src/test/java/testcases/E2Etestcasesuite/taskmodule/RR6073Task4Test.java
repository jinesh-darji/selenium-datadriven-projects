package testcases.E2Etestcasesuite.taskmodule;

import java.io.File;
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
import utilities.ExcelReader;
import utilities.TestUtil;

public class RR6073Task4Test extends TestBase {

	@Test(dataProviderClass = TestUtil.class, dataProvider = "dp")
	public void rR6073Task4Test(Hashtable<String, String> data) throws IOException, InterruptedException {

		execution(data, "rR6073Task4Test");

		// VALIDATE THE TASK RECORDS IN APPLICATION AND EXPORTED FOR THE RESPECTIVE
		// INSPECTIONS - THE CREATED INSPECTIONS ARE FROM SAME GROUP

		System.out.println(
				"VALIDATE THE TASK RECORDS IN APPLICATION AND EXPORTED FOR THE RESPECTIVE INSPECTIONS - THE CREATED INSPECTIONS ARE FROM SAME GROUP.");
		test.log(LogStatus.INFO,
				"VALIDATE THE TASK RECORDS IN APPLICATION AND EXPORTED FOR THE RESPECTIVE INSPECTIONS - THE CREATED INSPECTIONS ARE FROM SAME GROUP.");
		Reporter.log(
				"VALIDATE THE TASK RECORDS IN APPLICATION AND EXPORTED FOR THE RESPECTIVE INSPECTIONS - THE CREATED INSPECTIONS ARE FROM SAME GROUP.");
		log.info(
				"VALIDATE THE TASK RECORDS IN APPLICATION AND EXPORTED FOR THE RESPECTIVE INSPECTIONS - THE CREATED INSPECTIONS ARE FROM SAME GROUP.");

		Helper helper = new Helper();

		// refresh the page
		driver.navigate().refresh();
		explicitWait("taskicon_CSS");
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

		String inspectionTitle1 = RandomStringUtils.randomAlphabetic(8);
		String inspectionTitle11 = RandomStringUtils.randomAlphabetic(8);
		String inspectionTitle22 = RandomStringUtils.randomAlphabetic(8);

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
			ngDriver.waitForAngularRequestsToFinish();
			System.out.println("The type of the questionnire is selected.");

			// Select the level of the questionnaire
			click("questionnaire_level_propertybtn_CSS");
			ngDriver.waitForAngularRequestsToFinish();
			System.out.println("The level of the questionnire is selected.");

			// enter the group title
			type("questionnaire_grouptitletxt_CSS", data.get("group_title"));
			ngDriver.waitForAngularRequestsToFinish();
			System.out.println("The data entered in the Group Title field.");

			// enter the questionnaire title
			type("questionnaire_languagetitle_CSS", inspectionTitle1);
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
			type("questionnaire_frequencyintervaltxt_CSS", "1");
			ngDriver.waitForAngularRequestsToFinish();
			System.out.println("Entered frequency interval.");

			// select the month
			select("questionnaire_monthtxt_CSS", data.get("month"));
			System.out.println("The data entered in the month field.");
			ngDriver.waitForAngularRequestsToFinish();

			// enter the description
			type("questionnaire_descriptiontxt_CSS", data.get("description"));
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
			type("ssc_company2_questionnairelist_filtertxt_CSS", inspectionTitle1);
			System.out.println("Entered newly created questionnaire in the filter field.");
			ngDriver.waitForAngularRequestsToFinish();

			// verify newly created questionnaire for inspection
			try {
				String inspection1 = "//td[contains(text(),'" + inspectionTitle1 + "')]";

				boolean inspection11 = driver.findElement(By.xpath(inspection1)).isDisplayed();

				if (inspection11 == true) {

					successMessage("The respective inspection is displayed successfully.");

				} else {
					verificationFailedMessage("The inspection in not displayed.");
				}

			} catch (Throwable t) {
				verificationFailedMessage("The inspection in not displayed.");
			}

			// CONFIGRATION OF QUESTION

			title("CONFIGRATION OF QUESTION");

			// click on the created questionnaire
			String inspection2 = "//td[contains(text(),'" + inspectionTitle1 + "')]";
			driver.findElement(By.xpath(inspection2)).click();
			System.out.println("Clicked on the newly created questionnaire for checklist.");
			ngDriver.waitForAngularRequestsToFinish();

			helper.configureQuestions(data);

			// enter newly created questionnaire in the filter field
			clear("ssc_company2_questionnairelist_filtertxt_CSS");
			type("ssc_company2_questionnairelist_filtertxt_CSS", inspectionTitle1);
			System.out.println("Entered newly created questionnaire in the filter field.");
			ngDriver.waitForAngularRequestsToFinish();

			// verify newly created questionnaire for inspection
			try {
				String inspection1 = "//td[contains(text(),'" + inspectionTitle1 + "')]";

				boolean inspection11 = driver.findElement(By.xpath(inspection1)).isDisplayed();

				if (inspection11 == true) {

					successMessage("The respective inspection is displayed successfully.");

				} else {
					verificationFailedMessage("The inspection in not displayed.");
				}

			} catch (Throwable t) {
				verificationFailedMessage("The inspection in not displayed.");
			}

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

		// CREATE THE FIRST INSPECTION

		title("CREATE THE FIRST INSPECTION");

		try {

			// enter the property name in the search field
			clear("envreports_propertylist_filtertxt_CSS");
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

			// click on the new checklist button
			click("checklist_newchecklistbtn_CSS");
			System.out.println("Clicked on the new checklist button.");
			ngDriver.waitForAngularRequestsToFinish();

			// wait for the element
			explicitWait("checklist_addchecklist_checklisttypedd_CSS");

			// select the questionnaire option from the checklist type dropdown
			select("checklist_addchecklist_checklisttypedd_CSS", inspectionTitle1);
			System.out.println("The created questionaaire is selected from the checklist type dropdown.");
			ngDriver.waitForAngularRequestsToFinish();

			// enter data in the checklist title field
			clear("checklist_addchecklist_titletxt_CSS");
			type("checklist_addchecklist_titletxt_CSS", inspectionTitle11);
			System.out.println("Entered the data in the checklist title field.");
			ngDriver.waitForAngularRequestsToFinish();

			// click on the save button
			click("checklist_addchecklist_savebtn_CSS");
			System.out.println("Clicked on the save button.");
			ngDriver.waitForAngularRequestsToFinish();

			// verify questionnaire is selected correctly or not
			switchVerification("questionnaire_questiontitle_XPATH", "Test Category Title One",
					"The Test Category Title One is not displayed.");

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

		// ADD THE RANDOM NUMBER OF TASKS IN THE NEWLY CREATED INSPECTION

		title("ADD THE RANDOM NUMBER OF TASKS IN THE NEWLY CREATED INSPECTION");

		Random random1 = new Random();
		int random11 = random1.nextInt(6 - 3) + 3;
		String random11_String = Integer.toString(random11);

		try {

			// enter the property name in the search field
			clear("envreports_propertylist_filtertxt_CSS");
			type("envreports_propertylist_filtertxt_CSS", data.get("property_1"));
			ngDriver.waitForAngularRequestsToFinish();
			System.out.println("Entered the property name in the search field.");

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

			// enter the newly created inspection in the search field
			clear("sustainability_searchtxt_XPATH");
			type("sustainability_searchtxt_XPATH", inspectionTitle11);
			ngDriver.waitForAngularRequestsToFinish();
			System.out.println("Entered the newly created inspection in the search field.");

			// search the newly created inspections
			String inspection = "//td[text()='" + inspectionTitle11 + "']";
			driver.findElement(By.xpath(inspection)).click();
			ngDriver.waitForAngularRequestsToFinish();
			System.out.println("Clicked on the newly created inspection.");

			// click on the switch to wizard mode button
			click("survey_task_wizardicon_CSS");
			ngDriver.waitForAngularRequestsToFinish();
			System.out.println("Clicked on the switch to wizard mode button.");

			// click on the tasks tab
			click("checklist_wizard_tasktab_XPATH");
			ngDriver.waitForAngularRequestsToFinish();
			System.out.println("Clicked on the tasks tab.");

			for (int i = 0; i < random11; i++) {

				// click on the new task button
				click("checklist_newtaskbtn_CSS");
				ngDriver.waitForAngularRequestsToFinish();
				System.out.println("Clicked on the new task button.");

				// enter the title of the task
				String taskTitle = RandomStringUtils.randomAlphabetic(8);
				clear("checklist_wizard_tasktitle_XPATH");
				type("checklist_wizard_tasktitle_XPATH", taskTitle);
				ngDriver.waitForAngularRequestsToFinish();
				System.out.println("Entered the title of the task.");

				// click on the assign to field
				click("checklist_wizard_assigntotxt_XPATH");
				ngDriver.waitForAngularRequestsToFinish();
				System.out.println("Clicked on the assign to field.");

				// click on the none button
				click("task_tasktag_nonebtn_CSS");
				ngDriver.waitForAngularRequestsToFinish();
				System.out.println("Clicked on the none button.");

				// type the name of the user in the search name
				type("checklist_wizard_task_assignedtosearchtxt_XPATH", data.get("checklist_search_1"));
				ngDriver.waitForAngularRequestsToFinish();
				System.out.println("Entered the name of the user in the search name.");

				// click on the searched result
				click("checklist_wizard_task_assignedtosearchedresult_XPATH");
				ngDriver.waitForAngularRequestsToFinish();
				System.out.println("Clicked on the searched result.");

				// click on the assign to field
				click("checklist_wizard_assigntotxt_XPATH");
				ngDriver.waitForAngularRequestsToFinish();
				System.out.println("Clicked on the assign to field.");

				// click on the save button
				click("checklist_wizard_task_savebtn_XPATH");
				ngDriver.waitForAngularRequestsToFinish();
				System.out.println("Clicked on the save button.");

				// wait for the element
				explicitWaitClickable("closetoastmsg_CSS");

				// click on the toaster close button
				click("closetoastmsg_CSS");
				ngDriver.waitForAngularRequestsToFinish();
				System.out.println("Clicked on the toaster close button.");

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

		// CREATE THE SECOND INCIDENT

		title("CREATE THE SECOND INCIDENT");

		try {

			// enter the property name in the search field
			clear("envreports_propertylist_filtertxt_CSS");
			type("envreports_propertylist_filtertxt_CSS", data.get("property_2"));
			ngDriver.waitForAngularRequestsToFinish();
			System.out.println("Entered the property name in the search field.");

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

			// click on the new checklist button
			click("checklist_newchecklistbtn_CSS");
			System.out.println("Clicked on the new checklist button.");
			ngDriver.waitForAngularRequestsToFinish();

			// wait for the element
			explicitWait("checklist_addchecklist_checklisttypedd_CSS");

			// select the questionnaire option from the checklist type dropdown
			select("checklist_addchecklist_checklisttypedd_CSS", inspectionTitle1);
			System.out.println("The created questionaaire is selected from the checklist type dropdown.");
			ngDriver.waitForAngularRequestsToFinish();

			// enter data in the checklist title field
			type("checklist_addchecklist_titletxt_CSS", inspectionTitle22);
			System.out.println("Entered the data in the checklist title field.");
			ngDriver.waitForAngularRequestsToFinish();

			// click on the save button
			click("checklist_addchecklist_savebtn_CSS");
			System.out.println("Clicked on the save button.");
			ngDriver.waitForAngularRequestsToFinish();

			// verify questionnaire is selected correctly or not
			switchVerification("questionnaire_questiontitle_XPATH", "Test Category Title One",
					"The Test Category Title One is not displayed.");

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

		// ADD THE RANDOM NUMBER OF TASKS IN THE NEWLY CREATED INSPECTION - SECOND
		// INSPECTION

		title("ADD THE RANDOM NUMBER OF TASKS IN THE NEWLY CREATED INSPECTION - SECOND INSPECTION");

		Random random2 = new Random();
		int random22 = random2.nextInt(6 - 3) + 3;
		String random22_String = Integer.toString(random22);

		try {

			// enter the property name in the search field
			clear("envreports_propertylist_filtertxt_CSS");
			type("envreports_propertylist_filtertxt_CSS", data.get("property_2"));
			ngDriver.waitForAngularRequestsToFinish();
			System.out.println("Entered the property name in the search field.");

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

			// enter the newly created inspection in the search field
			clear("sustainability_searchtxt_XPATH");
			type("sustainability_searchtxt_XPATH", inspectionTitle22);
			ngDriver.waitForAngularRequestsToFinish();
			System.out.println("Entered the newly created inspection in the search field.");

			// search the newly created inspections
			String inspection = "//td[text()='" + inspectionTitle22 + "']";
			driver.findElement(By.xpath(inspection)).click();
			ngDriver.waitForAngularRequestsToFinish();
			System.out.println("Clicked on the newly created inspection.");

			// click on the switch to wizard mode button
			click("survey_task_wizardicon_CSS");
			ngDriver.waitForAngularRequestsToFinish();
			System.out.println("Clicked on the switch to wizard mode button.");

			// click on the tasks tab
			click("checklist_wizard_tasktab_XPATH");
			ngDriver.waitForAngularRequestsToFinish();
			System.out.println("Clicked on the tasks tab.");

			for (int i = 0; i < random22; i++) {

				// click on the new task button
				click("checklist_newtaskbtn_CSS");
				ngDriver.waitForAngularRequestsToFinish();
				System.out.println("Clicked on the new task button.");

				// enter the title of the task
				String taskTitle22 = RandomStringUtils.randomAlphabetic(8);
				clear("checklist_wizard_tasktitle_XPATH");
				type("checklist_wizard_tasktitle_XPATH", taskTitle22);
				ngDriver.waitForAngularRequestsToFinish();
				System.out.println("Entered the title of the task.");

				// click on the assign to field
				click("checklist_wizard_assigntotxt_XPATH");
				ngDriver.waitForAngularRequestsToFinish();
				System.out.println("Clicked on the assign to field.");

				// click on the none button
				click("task_tasktag_nonebtn_CSS");
				ngDriver.waitForAngularRequestsToFinish();
				System.out.println("Clicked on the none button.");

				// type the name of the user in the search name
				type("checklist_wizard_task_assignedtosearchtxt_XPATH", data.get("checklist_search_1"));
				ngDriver.waitForAngularRequestsToFinish();
				System.out.println("Entered the name of the user in the search name.");

				// click on the searched result
				click("checklist_wizard_task_assignedtosearchedresult_XPATH");
				ngDriver.waitForAngularRequestsToFinish();
				System.out.println("Clicked on the searched result.");

				// click on the assign to field
				click("checklist_wizard_assigntotxt_XPATH");
				ngDriver.waitForAngularRequestsToFinish();
				System.out.println("Clicked on the assign to field.");

				// click on the save button
				click("checklist_wizard_task_savebtn_XPATH");
				ngDriver.waitForAngularRequestsToFinish();
				System.out.println("Clicked on the save button.");

				// wait for the element
				explicitWaitClickable("closetoastmsg_CSS");

				// click on the toaster close button
				click("closetoastmsg_CSS");
				ngDriver.waitForAngularRequestsToFinish();
				System.out.println("Clicked on the toaster close button.");

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

		// VALIDATE THE TASK RECORDS IN THE TASK LIST OF THE RESPECTIVE PROPERTY LIST
		// AND EXPORTED FILE OF THE TASK OF THE RESPECTIVE INSPECTION

		title("VALIDATE THE TASK RECORDS IN THE TASK LIST OF THE RESPECTIVE PROPERTY LIST AND EXPORTED FILE OF THE TASK OF THE RESPECTIVE INSPECTION");

		try {

			// click on the side menu
			click("ssc_leftsidemenubtn_CSS");
			ngDriver.waitForAngularRequestsToFinish();
			System.out.println("Clicked on the side menu.");

			// click on the inspection option
			click("ssc_sidemenubtn_inspectionchecklistoption_XPATH");
			ngDriver.waitForAngularRequestsToFinish();
			System.out.println("Clicked on the inspection option.");

			// enter inspections name in the search field
			type("ssc_sidemenubtn_inspections_filtertxt_XPATH", inspectionTitle1);
			ngDriver.waitForAngularRequestsToFinish();
			System.out.println("Entered inspections name in the search field.");

			// click on the action icon of the respective inspection
			String actionIcon = "//td[text()='" + inspectionTitle1
					+ "']//following-sibling::td[@class='text-center pointer']//i[@data-toggle='dropdown']";
			driver.findElement(By.xpath(actionIcon)).click();
			ngDriver.waitForAngularRequestsToFinish();
			System.out.println("Clicked on the action icon of the respective inspection.");

			// click on the inspection history option
			String inspectionHistoryOption = "//td[text()='" + inspectionTitle1
					+ "']//following-sibling::td[@class='text-center pointer']//div[@class='dropdown open']//a[contains(text(),'Inspection History')]";
			driver.findElement(By.xpath(inspectionHistoryOption)).click();
			ngDriver.waitForAngularRequestsToFinish();
			System.out.println("Clicked on the inspection history option.");

			// wait for the element
			Thread.sleep(5000);

			// validate the count of the property 1
			try {
				String totalTask1 = "(//td[text()='" + data.get("property_1")
						+ "'])[1]//following-sibling::td[@class='text-center']//a[@ng-click='showAllTasks(property.name, property.checklistIds)']";
				String totalTask1_actual = (driver.findElement(By.xpath(totalTask1)).getText()).trim();

				if (totalTask1_actual.equals(random11_String)) {

					successMessage("The count of the total task is displayed correct.");
				} else {
					verificationFailedMessage("The count of the total task is not displayed correct.");
				}
			} catch (Throwable t) {
				verificationFailed();
			}

			// validate the count of the property 2
			try {
				String totalTask2 = "(//td[text()='" + data.get("property_2")
						+ "'])[1]//following-sibling::td[@class='text-center']//a[@ng-click='showAllTasks(property.name, property.checklistIds)']";
				String totalTask2_actual = (driver.findElement(By.xpath(totalTask2)).getText()).trim();

				if (totalTask2_actual.equals(random22_String)) {

					successMessage("The count of the total task is displayed correct.");
				} else {
					verificationFailedMessage("The count of the total task is not displayed correct.");
				}
			} catch (Throwable t) {
				verificationFailed();
			}

			// click on the total task count of the property 1
			String totalTask11 = "(//td[text()='" + data.get("property_1")
					+ "'])[1]//following-sibling::td[@class='text-center']//a[@ng-click='showAllTasks(property.name, property.checklistIds)']";
			driver.findElement(By.xpath(totalTask11)).click();
			ngDriver.waitForAngularRequestsToFinish();
			System.out.println("Clicked on the total task count of the property 1.");

			// validate the count of the task of the property 1

			try {
				List<WebElement> taskList1 = driver.findElements(By.xpath("//table[@id='tasksTable']//tbody//tr"));
				int taskList1_count = taskList1.size();

				if (taskList1_count == random11) {

					successMessage("The count of the task record is displayed correct.");

				} else {

					verificationFailedMessage("The count of the task records is not displayed correctly.");

				}
			} catch (Throwable t) {
				verificationFailed();
			}

			// click on the export button
			click("checklist_wizard_task_exportbtn_XPATH");
			ngDriver.waitForAngularRequestsToFinish();
			System.out.println("Clicked on the export button.");

			// wait for the file
			Thread.sleep(10000);

			// fetch the record from the download file
			File downloaded = getLastModified("C:\\Users\\Jinesh\\Downloads");
			String path_string = downloaded.toString();
			System.out.println(path_string);

			ExcelReader file = new ExcelReader(path_string);

			// validate the count of the row is displayed correctly or not
			try {
				int actualRowCount = file.getRowCount("Sheet0");
				if ((actualRowCount - 1) == random11) {

					successMessage("The task count is displayed correctly.");

				} else {
					verificationFailedMessage("The task count is not displayed correctly.");
				}
			} catch (Throwable t) {
				verificationFailedMessage("The task count is not displayed correctly.");
			}

			// wait for the element
			Thread.sleep(10000);

			// click on the back button
			click("checklist_task_backnavigationbtn_XPATH");
			ngDriver.waitForAngularRequestsToFinish();
			System.out.println("Clicked on the back button.");

			// click on the total task count of the property 2
			String totalTask22 = "(//td[text()='" + data.get("property_2")
					+ "'])[1]//following-sibling::td[@class='text-center']//a[@ng-click='showAllTasks(property.name, property.checklistIds)']";
			driver.findElement(By.xpath(totalTask22)).click();
			ngDriver.waitForAngularRequestsToFinish();
			System.out.println("Clicked on the total task count of the property 1.");

			// validate the count of the task of the property 2

			try {
				List<WebElement> taskList2 = driver.findElements(By.xpath("//table[@id='tasksTable']//tbody//tr"));
				int taskList2_count = taskList2.size();

				if (taskList2_count == random22) {

					successMessage("The count of the task record is displayed correct.");

				} else {

					verificationFailedMessage("The count of the task records is not displayed correctly.");

				}
			} catch (Throwable t) {
				verificationFailed();
			}

			// click on the export button
			click("checklist_wizard_task_exportbtn_XPATH");
			ngDriver.waitForAngularRequestsToFinish();
			System.out.println("Clicked on the export button.");

			// wait for the file
			Thread.sleep(10000);

			// fetch the record from the download file
			File downloaded2 = getLastModified("C:\\Users\\Jinesh\\Downloads");
			String path2_string = downloaded2.toString();
			System.out.println(path2_string);

			ExcelReader file2 = new ExcelReader(path2_string);

			// validate the count of the row is displayed correctly or not
			try {
				int actualRowCount = file2.getRowCount("Sheet0");
				if ((actualRowCount - 1) == random22) {

					successMessage("The task count is displayed correctly.");

				} else {
					verificationFailedMessage("The task count is not displayed correctly.");
				}
			} catch (Throwable t) {
				verificationFailedMessage("The task count is not displayed correctly.");
			}

			// wait for the element
			Thread.sleep(10000);

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

		// DELETE THE NEWLY CREATED FIRST INSPECTION

		title("DELETE THE NEWLY CREATED FIRST INSPECTION");

		try {

			// enter the property name in the search field
			clear("envreports_propertylist_filtertxt_CSS");
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

			// enter the newly created inspection in the search field
			clear("sustainability_searchtxt_XPATH");
			type("sustainability_searchtxt_XPATH", inspectionTitle11);
			ngDriver.waitForAngularRequestsToFinish();
			System.out.println("Entered the newly created inspection in the search field.");

			// click on the newly created inspection
			String inspection = "//td[text()='" + inspectionTitle11
					+ "']//following-sibling::td[@class='text-center pointer']//i[@id='action']";
			driver.findElement(By.xpath(inspection)).click();
			ngDriver.waitForAngularRequestsToFinish();
			System.out.println("Clicked on the newly created inspection.");

			// click on the delete option
			String deleteOption = "//td[text()='" + inspectionTitle11
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

		// DELETE THE NEWLY CREATED SECOND INSPECTION

		title("DELETE THE NEWLY CREATED SECOND INSPECTION");

		try {

			// enter the property name in the search field
			clear("envreports_propertylist_filtertxt_CSS");
			type("envreports_propertylist_filtertxt_CSS", data.get("property_2"));
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

			// enter the newly created inspection in the search field
			clear("sustainability_searchtxt_XPATH");
			type("sustainability_searchtxt_XPATH", inspectionTitle22);
			ngDriver.waitForAngularRequestsToFinish();
			System.out.println("Entered the newly created inspection in the search field.");

			// click on the newly created inspection
			String inspection = "//td[text()='" + inspectionTitle22
					+ "']//following-sibling::td[@class='text-center pointer']//i[@id='action']";
			driver.findElement(By.xpath(inspection)).click();
			ngDriver.waitForAngularRequestsToFinish();
			System.out.println("Clicked on the newly created inspection.");

			// click on the delete option
			String deleteOption = "//td[text()='" + inspectionTitle22
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

			// wait for the element
			explicitWaitClickable("closetoastmsg_CSS");

			// click on the toaster close button
			click("closetoastmsg_CSS");
			ngDriver.waitForAngularRequestsToFinish();
			System.out.println("Clicked on the toaster close button.");

		} catch (Throwable t) {
			verificationFailed();
		}

		// DELETE THE NEWLY CREATAED QUESTIONNAIRE

		title("DELETE THE NEWLY CREATAED QUESTIONNAIRE");

		try {

			// wait for the element
			explicitWaitClickable("questionnaire_settingicon_userupdate_CSS");

			// click on the settings icon from the top of the screen
			click("questionnaire_settingicon_userupdate_CSS");
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
			type("ssc_company2_questionnairelist_filtertxt_CSS", inspectionTitle1);
			System.out.println("Entered newly created questionnaire in the filter field.");
			ngDriver.waitForAngularRequestsToFinish();

			// click on the created questionnaire
			String questionnaire = "//td[text()='" + inspectionTitle1 + "']";
			driver.findElement(By.xpath(questionnaire)).click();
			System.out.println("Clicked on the newly created questionnaire.");
			ngDriver.waitForAngularRequestsToFinish();

			// wait for the element
			explicitWaitClickable("checklist_wizard_deletebtn_XPATH");

			// click on the delete button
			click("checklist_wizard_deletebtn_XPATH");
			System.out.println("Clicked on the delete button.");
			ngDriver.waitForAngularRequestsToFinish();

			// wait for the element
			explicitWaitClickable("checklist_wizard_confirmationdeletebtn_XPATH");

			// click on the delete button of confirmation model
			click("checklist_wizard_confirmationdeletebtn_XPATH");
			System.out.println("Clicked on the delete button of confirmation model.");
			ngDriver.waitForAngularRequestsToFinish();

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
		click("questionnaire_homeburgermenubtn_CSS");
		System.out.println("Clicked on the home icon from the top of the screen.");
		ngDriver.waitForAngularRequestsToFinish();

		// wait for the element
		explicitWait("propertylist_title_XPATH");

		// verify the property list
		switchVerification("propertylist_title_XPATH", "Property List", "The property list is not displayed.");

	}
}
