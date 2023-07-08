package testcases.E2Etestcasesuite.surveychecklistmodule;

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

public class RR3900SurveyChecklistNineTest extends TestBase {

	@Test(dataProviderClass = TestUtil.class, dataProvider = "dp")
	public void rR3900SurveyChecklistNineTest(Hashtable<String, String> data) throws IOException, InterruptedException {

		execution(data, "rR3900SurveyChecklistNineTest");

		// FOR SETTINGS WITH OPTIONS TO SELECT USER AND ROLE SEPARATELY, MAKE SURE THE 2
		// SETTINGS WORK TOGETHER - Add one user in the "User to Access Instance"
		// permission and add one role in the "Role to Create Instance" permission

		System.out.println(
				"FOR SETTINGS WITH OPTIONS TO SELECT USER AND ROLE SEPARATELY, MAKE SURE THE SETTINGS WORK TOGETHER - Add one user in the \"User to Access Instance\" permission and add one role in the \"Role to Create Instance\" permission");
		test.log(LogStatus.INFO,
				"FOR SETTINGS WITH OPTIONS TO SELECT USER AND ROLE SEPARATELY, MAKE SURE THE SETTINGS WORK TOGETHER - Add one user in the \"User to Access Instance\" permission and add one role in the \"Role to Create Instance\" permission");
		Reporter.log(
				"FOR SETTINGS WITH OPTIONS TO SELECT USER AND ROLE SEPARATELY, MAKE SURE THE SETTINGS WORK TOGETHER - Add one user in the \"User to Access Instance\" permission and add one role in the \"Role to Create Instance\" permission");
		log.info(
				"FOR SETTINGS WITH OPTIONS TO SELECT USER AND ROLE SEPARATELY, MAKE SURE THE SETTINGS WORK TOGETHER - Add one user in the \"User to Access Instance\" permission and add one role in the \"Role to Create Instance\" permission");

		Helper helper = new Helper();

		// refresh the page
		driver.navigate().refresh();
		Thread.sleep(5000);
		driver.navigate().refresh();

		System.out.println("Navigate to the Home Screen i.e. Property List Screen.");

		// ADD NEW QUESTIONNIRE FOR CHECKLIST

		System.out.println("***************** ADD NEW QUESTIONNIRE FOR CHECKLIST *****************");
		test.log(LogStatus.INFO, "***************** ADD NEW QUESTIONNIRE FOR CHECKLIST *****************");
		Reporter.log("***************** ADD NEW QUESTIONNIRE FOR CHECKLIST *****************");
		log.info("***************** ADD NEW QUESTIONNIRE FOR CHECKLIST *****************");

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
			type("questionnaire_grouptitletxt_CSS", data.get("group_title"));
			System.out.println("The data entered in the Group Title field.");

			// enter the questionnaire title
			type("questionnaire_languagetitle_CSS", data.get("questionnaire_checklist_title"));
			System.out.println("Entered the questionnaire title in the english language.");
			ngDriver.waitForAngularRequestsToFinish();

			// select the model
			select("questionnaire_modeldd_CSS", data.get("model"));
			System.out.println("The data entered in the Questionnaire Title field.");
			ngDriver.waitForAngularRequestsToFinish();

//			// select the frequency
//			select("questionnaire_frequencydd_CSS", data.get("frequency"));
//			System.out.println("The data entered in the frequency field.");
//			ngDriver.waitForAngularRequestsToFinish();

			// enter frequency interval
			type("questionnaire_frequencyintervaltxt_CSS", "1");
			ngDriver.waitForAngularRequestsToFinish();
			System.out.println("Entered frequency interval.");

//		// enter the year
//		type("questionnaire_yeartxt_CSS", "2020");
//		System.out.println("The data entered in the year field.");
//		ngDriver.waitForAngularRequestsToFinish();

			// enter the description
			type("questionnaire_descriptiontxt_CSS", data.get("description"));
			System.out.println("The data entered in the description field.");

			// select the classic option from the default view drop down
			select("questionnaire_checklist_defaultview_CSS", data.get("default_view"));
			System.out.println("Selected the classic option from the default view drop down.");
			ngDriver.waitForAngularRequestsToFinish();

			// scroll down the screen
			JavascriptExecutor js = (JavascriptExecutor) driver;
			js.executeScript("window.scrollBy(0,400)");

			// click on the User to Access Instance field
			click("questionnaire_checklist_usertoaccessinstance1_CSS");
			System.out.println("Clicked on the User to Access Instance field.");
			ngDriver.waitForAngularRequestsToFinish();

			// enter the user name in the search field
			type("questionnaire_checklist_usertoaccessinstance2_CSS", data.get("checklist_search_1"));
			System.out.println("Entered the user name in the search field.");
			ngDriver.waitForAngularRequestsToFinish();

			// click on the user name from the searched result
			click("questionnaire_checklist_usertoaccessinstance3_XPATH");
			System.out.println("Clicked on the user name from the searched result.");
			ngDriver.waitForAngularRequestsToFinish();

			// click on the User to Access Instance field
			click("questionnaire_checklist_usertoaccessinstance1_CSS");
			System.out.println("Clicked on the User to Access Instance field.");
			ngDriver.waitForAngularRequestsToFinish();

			// scroll down the screen
			WebElement element1 = driver
					.findElement(By.cssSelector(OR.getProperty("questionnaire_checklist_roletocreateinstance11_CSS")));
			js.executeScript("arguments[0].scrollIntoView();", element1);
			js.executeScript("window.scrollBy(0,-100)");

			// click on the Role to Create Instance field
			click("questionnaire_checklist_roletocreateinstance11_CSS");
			System.out.println("Clicked on the Role to Create Instance field.");
			ngDriver.waitForAngularRequestsToFinish();

			// enter the Role name in the search field
			type("questionnaire_checklist_roletocreateinstance22_CSS", data.get("checklist_search_6"));
			System.out.println("Entered the Role name in the search field.");
			ngDriver.waitForAngularRequestsToFinish();

			// click on the Role name from the searched result
			click("questionnaire_checklist_roletocreateinstance33_XPATH");
			System.out.println("Clicked on the Role name from the searched result.");
			ngDriver.waitForAngularRequestsToFinish();

			// click on the Role to Create Instance field
			click("questionnaire_checklist_roletocreateinstance11_CSS");
			System.out.println("Clicked on the Role to Create Instance field.");
			ngDriver.waitForAngularRequestsToFinish();

			// click on the warranty checkbox
			click("questionnaire_warrantybtn_CSS");
			System.out.println("Clicked on the warranty checkbox.");
			ngDriver.waitForAngularRequestsToFinish();

			// scroll down the screen
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
			switchVerification("questionnaire_record13_XPATH", "Questionnaire Property Checklist Access Nine Title",
					"The Questionnaire Property Checklist User Access Title record is not displayed in the questionnaire list.");

			// CONFIGRATION OF QUESTION

			System.out.println("***************** CONFIGRATION OF QUESTION *****************");
			test.log(LogStatus.INFO, "***************** CONFIGRATION OF QUESTION *****************");
			Reporter.log("***************** CONFIGRATION OF QUESTION *****************");
			log.info("***************** CONFIGRATION OF QUESTION *****************");

			// click on the created questionnaire
			click("questionnaire_record13_XPATH");
			System.out.println("Clicked on the newly created questionnaire for checklist.");
			ngDriver.waitForAngularRequestsToFinish();

			helper.configureQuestions(data);

			// enter newly created questionnaire in the filter field
			clear("ssc_company2_questionnairelist_filtertxt_CSS");
			ngDriver.waitForAngularRequestsToFinish();
			type("ssc_company2_questionnairelist_filtertxt_CSS", data.get("questionnaire_checklist_title"));
			System.out.println("Entered newly created questionnaire in the filter field.");
			ngDriver.waitForAngularRequestsToFinish();

			// verify newly created questionnaire for checklist
			switchVerification("questionnaire_record13_XPATH", "Questionnaire Property Checklist Access Nine Title",
					"The Questionnaire Property Checklist User Access Title record is not displayed in the questionnaire list.");

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

		// VERIFY THE CHECKLIST IN THE PROPERTY LEVEL

		System.out.println("***************** VERIFY THE CHECKLIST IN THE PROPERTY LEVEL *****************");
		test.log(LogStatus.INFO, "***************** VERIFY THE CHECKLIST IN THE PROPERTY LEVEL *****************");
		Reporter.log("***************** VERIFY THE CHECKLIST IN THE PROPERTY LEVEL *****************");
		log.info("***************** VERIFY THE CHECKLIST IN THE PROPERTY LEVEL *****************");

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
				// collect all options of the dropdown
				Select dropdown = new Select(driver
						.findElement(By.cssSelector(OR.getProperty("checklist_addchecklist_checklisttypedd_CSS"))));

				// Get all options
				List<WebElement> dd = dropdown.getOptions();

				// Loop to print one by one
				for (int j = 0; j < dd.size(); j++) {
					String checklist = dd.get(j).getText();
					try {
						if (checklist.equals("Questionnaire Property Checklist Access Nine Title")) {

							verificationFailedMessage(" The " + data.get("questionnaire_checklist_title")
									+ " is displayed in the dropdown.");

							// refresh the screen
							driver.navigate().refresh();
							Thread.sleep(5000);
							driver.navigate().refresh();

						}
					} catch (Throwable t) {

						successMessage("The checklist is not displayed as per the permission applied.");

						// refresh the screen
						driver.navigate().refresh();
						Thread.sleep(5000);
						driver.navigate().refresh();

					}
				}

			} catch (Throwable t) {
				successMessage("The checklist is not displayed as per the permission applied.");

				// refresh the screen
				driver.navigate().refresh();
				Thread.sleep(5000);
				driver.navigate().refresh();

			}

			// refresh the screen
			driver.navigate().refresh();
			Thread.sleep(5000);
			driver.navigate().refresh();

		} catch (Throwable t) {
			verificationFailed();
		}

		// click on the Home Icon from the top of the screen
		click("questionnaire_homeburgermenubtn_hide_CSS");
		System.out.println("Clicked on the Home Icon from the top of the screen.");
		ngDriver.waitForAngularRequestsToFinish();

		// wait for the element
		explicitWait("propertylist_title_XPATH");

		// verify the property list
		switchVerification("propertylist_title_XPATH", "Property List", "The property list is not displayed.");

		// LOGIN WITH SITE MANAGER USER AND VERIFY QUESTONNAIRE IN INSPECTION MODULE

		System.out.println(
				"***************** LOGIN WITH SITE MANAGER USER AND VERIFY QUESTONNAIRE IN INSPECTION MODULE *****************");
		test.log(LogStatus.INFO,
				"***************** LOGIN WITH SITE MANAGER USER AND VERIFY QUESTONNAIRE IN INSPECTION MODULE *****************");
		Reporter.log(
				"***************** LOGIN WITH SITE MANAGER USER AND VERIFY QUESTONNAIRE IN INSPECTION MODULE *****************");
		log.info(
				"***************** LOGIN WITH SITE MANAGER USER AND VERIFY QUESTONNAIRE IN INSPECTION MODULE *****************");

		try {
			// wait for the element
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

			// login with valid credentials

			helper.loginAndUpdateSystemCompany(data, "username", "password", "system_company_1");

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

				// wait for the element
				explicitWait("checklist_addchecklist_checklisttypedd_CSS");

				try {
					// collect all options of the dropdown
					Select dropdown1 = new Select(driver
							.findElement(By.cssSelector(OR.getProperty("checklist_addchecklist_checklisttypedd_CSS"))));

					// Get all options
					List<WebElement> dd1 = dropdown1.getOptions();

					// Loop to print one by one
					for (int j = 0; j < dd1.size(); j++) {
						String checklist1 = dd1.get(j).getText();
						try {
							if (checklist1.equals("Questionnaire Property Checklist User Access Nine Title")) {
								verificationFailedMessage(" The " + data.get("questionnaire_checklist_title")
										+ " is displayed in the dropdown.");

								// refresh the screen
								driver.navigate().refresh();
								Thread.sleep(5000);
								driver.navigate().refresh();

							}
						} catch (Throwable t) {

							successMessage("The checklist is not displayed as per the permission applied.");

							// refresh the screen
							driver.navigate().refresh();
							Thread.sleep(5000);
							driver.navigate().refresh();
						}
					}

				} catch (Throwable t) {
					successMessage("The checklist is not displayed as per the permission applied.");

					// refresh the screen
					driver.navigate().refresh();
					Thread.sleep(5000);
					driver.navigate().refresh();
				}

				successMessage("The checklist is not displayed as per the permission applied.");

				// refresh the screen
				driver.navigate().refresh();
				Thread.sleep(5000);
				driver.navigate().refresh();

			} catch (Throwable t) {
				verificationFailed();
			}

			// VERIFY INSTANCE ACCESABLE OR NOT FOR ASSIGNED USER

			System.out
					.println("***************** VERIFY INSTANCE ACCESABLE OR NOT FOR ASSIGNED USER *****************");
			test.log(LogStatus.INFO,
					"***************** VERIFY INSTANCE ACCESABLE OR NOT FOR ASSIGNED USER *****************");
			Reporter.log("***************** VERIFY INSTANCE ACCESABLE OR NOT FOR ASSIGNED USER *****************");
			log.info("***************** VERIFY INSTANCE ACCESABLE OR NOT FOR ASSIGNED USER *****************");

			// wait for the element
			Thread.sleep(5000);

			// click on the settings icon from the top of the screen
			click("questionnaire_settingicon_CSS");
			System.out.println("Clicked on the settings icon.");
			ngDriver.waitForAngularRequestsToFinish();

			// wait for the element
			Thread.sleep(5000);

			// click on the logout option from the side menu
			click("sidemenu_logout_CSS");
			System.out.println("Clicked on the logout option from the side menu.");
			ngDriver.waitForAngularRequestsToFinish();

			// login with maintenance user with valid credentials

			helper.loginAndUpdateSystemCompany(data, "username_2", "password_2", "system_company_1");

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

				// select the property level from the dropdown
				select("survey_leveldropdown_CSS", data.get("property_leveldropdown"));
				System.out.println("Selected the property level from the dropdown.");
				ngDriver.waitForAngularRequestsToFinish();

				// click on the new checklist button
				click("checklist_newchecklistbtn_CSS");
				System.out.println("Clicked on the new checklist button.");
				ngDriver.waitForAngularRequestsToFinish();

				// wait for the element
				Thread.sleep(5000);

				try {
					// collect all options of the dropdown
					Select dropdown2 = new Select(driver
							.findElement(By.cssSelector(OR.getProperty("checklist_addchecklist_checklisttypedd_CSS"))));

					// Get all options
					List<WebElement> dd2 = dropdown2.getOptions();

					// Loop to print one by one
					for (int j = 0; j < dd2.size(); j++) {
						String checklist = dd2.get(j).getText();
						try {
							if (checklist.equals("Questionnaire Property Checklist Access Nine Title")) {

								// select the questionnaire option from the checklist type dropdown
								select("checklist_addchecklist_checklisttypedd_CSS",
										data.get("questionnaire_checklist_title"));
								System.out.println(
										"The created questionaaire is selected from the checklist type dropdown.");
								ngDriver.waitForAngularRequestsToFinish();

								// enter data in the checklist title field
								type("checklist_addchecklist_titletxt_CSS", data.get("checklist_property_title"));
								System.out.println("Entered the data in the checklist title field.");
								ngDriver.waitForAngularRequestsToFinish();

								// click on the save button
								click("checklist_addchecklist_savebtn_CSS");
								System.out.println("Clicked on the save button.");
								ngDriver.waitForAngularRequestsToFinish();

								// wait for the element
								explicitWait("questionnaire_questiontitle_XPATH");

								// verify questionnaire is selected correctly or not
								switchVerification("questionnaire_questiontitle_XPATH", "Test Category Title One",
										"The Test Category Title One is not displayed.");

								test.log(LogStatus.INFO, "The checklist is working as per the permission applied.");
								Reporter.log("The checklist is working as per the permission applied");
								System.out.println("The checklist is working as per the permission applied");
								log.info("The checklist is working as per the permission applied");

							}
						} catch (Throwable t) {

							verificationFailedMessage("<br>" + " The " + data.get("questionnaire_checklist_title")
									+ " is not displayed in the dropdown." + "<br>");

							// refresh the screen
							driver.navigate().refresh();
							Thread.sleep(5000);
							driver.navigate().refresh();

						}
					}

				} catch (Throwable t) {

					verificationFailedMessage("<br>" + " The " + data.get("questionnaire_checklist_title")
							+ " is not displayed in the dropdown." + "<br>");

					// refresh the screen
					driver.navigate().refresh();
					Thread.sleep(5000);
					driver.navigate().refresh();

				}

			} catch (Throwable t) {
				verificationFailed();
			}

			// wait for the element
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

			// login with valid credentials

			helper.loginAndUpdateSystemCompany(data, "username_1", "password_1", "system_company_1");

		} catch (Throwable t) {
			helper.questionnaireNotDisplayLogout(data);
		}

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

			// type the data in search field
			type("task_listofchecklist_filterfield_CSS", data.get("checklist_property_title"));
			System.out.println("Entered the data in search field.");
			ngDriver.waitForAngularRequestsToFinish();

			// verify the instance is displayed or not

			// enter newly created questionnaire in the filter field
			type("task_listofchecklist_filterfield_CSS", data.get("questionnaire_checklist_title"));
			System.out.println("Entered newly created questionnaire in the filter field.");
			ngDriver.waitForAngularRequestsToFinish();

			try {
				String str2 = driver.findElement(By.xpath(OR.getProperty("questionnaire_record13_XPATH"))).getText();
				ngDriver.waitForAngularRequestsToFinish();
				if (str2.equals("Questionnaire Property Checklist Access Nine Title")) {

					verificationFailedMessage(
							"The Questionnaire Property Checklist Access Nine Title is not displayed.");

				}
			} catch (Throwable t) {

				successMessage("The checklist is displayed as per the permission.");

			}
		} catch (Throwable t) {
			verificationFailed();
		}

		// DELETE THE QUESTIONNAIRE WHICH ARE CREATED ON PROPERTY LEVELS

		System.out.println(
				"***************** DELETE THE QUESTIONNAIRE WHICH ARE CREATED ON PROPERTY LEVELS *****************");
		test.log(LogStatus.INFO,
				"***************** DELETE THE QUESTIONNAIRE WHICH ARE CREATED ON PROPERTY LEVELS *****************");
		Reporter.log(
				"***************** DELETE THE QUESTIONNAIRE WHICH ARE CREATED ON PROPERTY LEVELS *****************");
		log.info("***************** DELETE THE QUESTIONNAIRE WHICH ARE CREATED ON PROPERTY LEVELS *****************");

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
			ngDriver.waitForAngularRequestsToFinish();
			type("ssc_company2_questionnairelist_filtertxt_CSS", data.get("questionnaire_checklist_title"));
			System.out.println("Entered newly created questionnaire in the filter field.");
			ngDriver.waitForAngularRequestsToFinish();

			// click on the created questionnaire
			click("questionnaire_record13_XPATH");
			System.out.println("Clicked on the newly created questionnaire.");
			ngDriver.waitForAngularRequestsToFinish();

			// scroll till the delete button
			WebElement element5 = driver.findElement(By.cssSelector(OR.getProperty("questionnaire_deletebtn_CSS")));
			JavascriptExecutor js = (JavascriptExecutor) driver;
			js.executeScript("arguments[0].scrollIntoView();", element5);

			// wait for the element
			explicitWaitClickable("questionnaire_deletebtn_CSS");

			// click on the delete button
			click("questionnaire_deletebtn_CSS");
			System.out.println("Clicked on the delete button.");
			ngDriver.waitForAngularRequestsToFinish();

			// wait for the element
			explicitWaitClickable("questionnaire_modeldeletebtn_CSS");

			// click on the delete button of the confirmation popup
			click("questionnaire_modeldeletebtn_CSS");
			System.out.println("Clicked on the delete button of the confirmation popup.");
			ngDriver.waitForAngularRequestsToFinish();

			// enter newly created questionnaire in the filter field
			type("ssc_company2_questionnairelist_filtertxt_CSS", data.get("questionnaire_checklist_title"));
			System.out.println("Entered newly created questionnaire in the filter field.");
			ngDriver.waitForAngularRequestsToFinish();

			// verify questionnaire is deleted or not
			helper.deleteVerification("questionnaire_record13_XPATH",
					"Questionnaire Property Checklist Access Nine Title");

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
