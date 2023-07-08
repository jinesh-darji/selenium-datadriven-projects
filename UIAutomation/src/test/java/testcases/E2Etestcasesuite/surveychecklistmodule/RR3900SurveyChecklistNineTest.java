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
		title("FOR SETTINGS WITH OPTIONS TO SELECT USER AND ROLE SEPARATELY, MAKE SURE THE SETTINGS WORK TOGETHER - Add one user in the \\\"User to Access Instance\\\" permission and add one role in the \\\"Role to Create Instance\\\" permission");

		Helper helper = new Helper();

		// refresh the page
		driver.navigate().refresh();
		Thread.sleep(5000);
		driver.navigate().refresh();

		// ADD NEW QUESTIONNIRE FOR CHECKLIST
		title("ADD NEW QUESTIONNIRE FOR CHECKLIST");

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

			// enter frequency interval
			type("questionnaire_frequencyintervaltxt_CSS", "1");

			// enter the description
			type("questionnaire_descriptiontxt_CSS", data.get("description"));

			// select the classic option from the default view drop down
			select("questionnaire_checklist_defaultview_CSS", data.get("default_view"));

			// scroll down the screen
			scrollByPixel(400);

			// click on the User to Access Instance field
			click("questionnaire_checklist_usertoaccessinstance1_CSS");

			// enter the user name in the search field
			type("questionnaire_checklist_usertoaccessinstance2_CSS", data.get("checklist_search_1"));

			// click on the user name from the searched result
			click("questionnaire_checklist_usertoaccessinstance3_XPATH");

			// click on the User to Access Instance field
			click("questionnaire_checklist_usertoaccessinstance1_CSS");

			// scroll down the screen
			scrollTillElement("questionnaire_checklist_roletocreateinstance11_CSS");
			scrollByPixel(-100);

			// click on the Role to Create Instance field
			click("questionnaire_checklist_roletocreateinstance11_CSS");

			// enter the Role name in the search field
			type("questionnaire_checklist_roletocreateinstance22_CSS", data.get("checklist_search_6"));

			// click on the Role name from the searched result
			click("questionnaire_checklist_roletocreateinstance33_XPATH");

			// click on the Role to Create Instance field
			click("questionnaire_checklist_roletocreateinstance11_CSS");

			// click on the warranty checkbox
			click("questionnaire_warrantybtn_CSS");

			// scroll down the screen
			scrollBottom();

			// click on the save button
			click("questionnaire_savebtn_BTNTEXT");

			// enter newly created questionnaire in the filter field
			type("ssc_company2_questionnairelist_filtertxt_CSS", data.get("questionnaire_checklist_title"));

			// verify newly created questionnaire for checklist
			switchVerification("questionnaire_record13_XPATH", "Questionnaire Property Checklist Access Nine Title",
					"The Questionnaire Property Checklist User Access Title record is not displayed in the questionnaire list.");

			// CONFIGRATION OF QUESTION
			title("CONFIGRATION OF QUESTION");

			// click on the created questionnaire
			click("questionnaire_record13_XPATH");

			helper.configureQuestions(data);

			// enter newly created questionnaire in the filter field
			type("ssc_company2_questionnairelist_filtertxt_CSS", data.get("questionnaire_checklist_title"));

			// verify newly created questionnaire for checklist
			switchVerification("questionnaire_record13_XPATH", "Questionnaire Property Checklist Access Nine Title",
					"The Questionnaire Property Checklist User Access Title record is not displayed in the questionnaire list.");

		} catch (Throwable t) {
			verificationFailed();
		}

		// click on the Home Icon from the top of the screen
		click("questionnaire_homeburgermenubtn_CSS");

		// wait for the element
		explicitWait("propertylist_title_XPATH");

		// verify the property list
		switchVerification("propertylist_title_XPATH", "Property List", "The property list is not displayed.");

		// VERIFY THE CHECKLIST IN THE PROPERTY LEVEL
		title("VERIFY THE CHECKLIST IN THE PROPERTY LEVEL");

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

		// wait for the element
		explicitWait("propertylist_title_XPATH");

		// verify the property list
		switchVerification("propertylist_title_XPATH", "Property List", "The property list is not displayed.");

		// LOGIN WITH SITE MANAGER USER AND VERIFY QUESTONNAIRE IN INSPECTION MODULE
		title("LOGIN WITH SITE MANAGER USER AND VERIFY QUESTONNAIRE IN INSPECTION MODULE");

		try {
			// wait for the element
			Thread.sleep(5000);

			// click on the settings icon from the top of the screen
			click("questionnaire_settingicon_CSS");

			// wait for the element
			explicitWaitClickable("sidemenu_logout_CSS");

			// click on the logout option from the side menu
			click("sidemenu_logout_CSS");

			// login with valid credentials
			helper.loginAndUpdateSystemCompany(data, "username", "password", "system_company_1");

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
			title("VERIFY INSTANCE ACCESABLE OR NOT FOR ASSIGNED USER");

			// wait for the element
			Thread.sleep(5000);

			// click on the settings icon from the top of the screen
			click("questionnaire_settingicon_CSS");

			// wait for the element
			Thread.sleep(5000);

			// click on the logout option from the side menu
			click("sidemenu_logout_CSS");

			// login with maintenance user with valid credentials
			helper.loginAndUpdateSystemCompany(data, "username_2", "password_2", "system_company_1");

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

				// select the property level from the dropdown
				select("survey_leveldropdown_CSS", data.get("property_leveldropdown"));

				// click on the new checklist button
				click("checklist_newchecklistbtn_CSS");

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
								consoleMessage(
										"The created questionaaire is selected from the checklist type dropdown.");

								// enter data in the checklist title field
								type("checklist_addchecklist_titletxt_CSS", data.get("checklist_property_title"));

								// click on the save button
								click("checklist_addchecklist_savebtn_CSS");

								// wait for the element
								explicitWait("questionnaire_questiontitle_XPATH");

								// verify questionnaire is selected correctly or not
								switchVerification("questionnaire_questiontitle_XPATH", "Test Category Title One",
										"The Test Category Title One is not displayed.");
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

			// wait for the element
			explicitWaitClickable("sidemenu_logout_CSS");

			// click on the logout option from the side menu
			click("sidemenu_logout_CSS");

			// login with valid credentials
			helper.loginAndUpdateSystemCompany(data, "username_1", "password_1", "system_company_1");

		} catch (Throwable t) {
			helper.questionnaireNotDisplayLogout(data);
		}

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

			// type the data in search field
			type("task_listofchecklist_filterfield_CSS", data.get("checklist_property_title"));

			// enter newly created questionnaire in the filter field
			type("task_listofchecklist_filterfield_CSS", data.get("questionnaire_checklist_title"));

			// verify the instance is displayed or not
			try {
				String str2 = driver.findElement(By.xpath(OR.getProperty("questionnaire_record13_XPATH"))).getText();

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
		title("DELETE THE QUESTIONNAIRE WHICH ARE CREATED ON PROPERTY LEVELS");

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
			click("questionnaire_record13_XPATH");

			// scroll till the delete button
			scrollTillElement("questionnaire_deletebtn_CSS");

			// wait for the element
			explicitWaitClickable("questionnaire_deletebtn_CSS");

			// click on the delete button
			click("questionnaire_deletebtn_CSS");

			// wait for the element
			explicitWaitClickable("questionnaire_modeldeletebtn_CSS");

			// click on the delete button of the confirmation popup
			click("questionnaire_modeldeletebtn_CSS");

			// enter newly created questionnaire in the filter field
			type("ssc_company2_questionnairelist_filtertxt_CSS", data.get("questionnaire_checklist_title"));

			// verify questionnaire is deleted or not
			helper.deleteVerification("questionnaire_record13_XPATH",
					"Questionnaire Property Checklist Access Nine Title");

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