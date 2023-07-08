package testcases.E2Etestcasesuite.taskmodule;

import java.io.IOException;
import java.util.Hashtable;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.SkipException;
import org.testng.annotations.Test;

import com.relevantcodes.extentreports.LogStatus;

import base.Helper;
import base.TestBase;
import utilities.TestUtil;

public class RR4522TaskTest extends TestBase {

	@Test(dataProviderClass = TestUtil.class, dataProvider = "dp")
	public void rR4522TaskTest(Hashtable<String, String> data) throws IOException, InterruptedException {

		execution(data, "rR4522TaskTest");

		// VERIFY THE TASK WITH TASK TAG PERMISSION (MODULE NAMES: ENVIRONMENT, ACCESS
		// TO PO SECTION: USER-JINESH MISC 2 AND ROLE-MAINTENANCE)
		title("VERIFY THE TASK WITH TASK TAG PERMISSION (MODULE NAMES: ENVIRONMENT, ACCESS TO PO SECTION: USER-JINESH MISC 2 AND ROLE-MAINTENANCE).");

		Helper helper = new Helper();

		// refresh the page
		driver.navigate().refresh();
		Thread.sleep(5000);
		driver.navigate().refresh();

		// UPDATE THE RESPECTIVE PERMISSIONS
		title("UPDATE THE RESPECTIVE PERMISSIONS");

		try {

			// wait for element
			Thread.sleep(5000);

			// click on the setting icon
			click("questionnaire_settingicon_CSS");

			// wait for the element
			explicitWaitClickable("questionnaire_administrationoption_XPATH");

			// click on the Administration option from the side menu
			click("questionnaire_administrationoption_XPATH");

			// click on the security tab
			click("questionnaire_securitytab_XPATH");

			// click on the security settings tab
			click("questionnaire_securotysettingsoption_XPATH");

			try {
				// enter security setting name in the search field
				type("propertyproject_le_filtertxt_CSS", data.get("security_settings_1"));

				// click on the searched result
				click("securitysettings_accesstoposection_XPATH");

				// click on the select role field
				click("propertyproject_securitysettings1_selectroles_CSS");

				// click on the none button
				click("propertyproject_securitysettings1_nonebtn_CSS");

				// enter the name of the role in search field
				type("propertyproject_securitysettings1_searchtxt_CSS", data.get("role_1"));

				// click on the searched result
				click("questionnaire_checklist_roletocreateinstance33_XPATH");

				// click on the select role field
				click("propertyproject_securitysettings1_selectroles_CSS");

				// click on the select user field
				click("propertyproject_securitysettings1_selectusers_CSS");

				// click on the none button
				click("propertyproject_securitysettings1_nonebtn_CSS");

				// enter the name of the user in search field
				type("propertyproject_securitysettings1_searchtxt_CSS", data.get("user_1"));

				// click on the searched result
				click("propertyproject_securitysettings1_searcheduser11_XPATH");

				// click on the select user field
				click("propertyproject_securitysettings1_selectusers_CSS");

				// click on the save button
				click("propertyproject_securitysettings1_savebtn_CSS");

				// wait for the element
				explicitWaitClickable("closetoastmsg_CSS");

				// click on the toaster close button
				click("closetoastmsg_CSS");

			} catch (Throwable t) {
				verificationFailed();
			}

			helper.resetPermission(data, "security_settings_2", "securitysettings_surveychecklistsection_XPATH");

			helper.resetPermission(data, "security_settings_3", "securitysettings_editpoestimateamountsection_XPATH");

		} catch (Throwable t) {
			verificationFailed();
		}

		// click on the administration tab
		click("administration_XPATH");

		// SET THE PERMISSION IN THE AUTOMATION TAG
		title("SET THE PERMISSION IN THE AUTOMATION TAG");

		try {

			// wait for element
			explicitWaitClickable("questionnaire_systemtab_XPATH");

			// click on the system tab
			click("questionnaire_systemtab_XPATH");

			// scroll down the screen
			scrollByPixel(200);

			// click on the Task Tag option
			click("questionnaire_tasktagoption_XPATH");

			// scroll down the screen
			scrollByPixel(200);

			// click on the task tag
			click("task_tasktaglbl_XPATH");

			// wait for the 3 seconds
			Thread.sleep(3000);

			// click on the Module Names field
			click("task_tasktag_modulenametxt_CSS");

			// click on the none button
			click("task_tasktag_nonebtn_CSS");

			// enter the module name in the search field
			type("task_tasktag_searchtxt_CSS", data.get("search_1"));

			// click on the searched result
			click("task_tasktag_searchedresult1_XPATH");

			// click on the Module Names field
			click("task_tasktag_modulenametxt_CSS");

			// click on the Access to PO section field
			click("task_tasktag_accesstoposectiontxt_CSS");

			// click on the none button
			click("task_tasktag_nonebtn_CSS");

			// enter the username in the search field
			type("task_tasktag_searchtxt_CSS", data.get("search_2"));

			// click on the searched result
			click("task_tasktag_searchedresult2_XPATH");

			// enter the role in the search field
			type("task_tasktag_searchtxt_CSS", data.get("search_3"));

			// click on the searched result
			click("task_tasktag_searchedresult3_XPATH");

			// click on the Access to PO section field
			click("task_tasktag_accesstoposectiontxt_CSS");

			// click on the Task Admin field
			click("task_tasktag_taskadmintxt_CSS");

			// click on the none button
			click("task_tasktag_nonebtn_CSS");

			// click on the Task Admin field
			click("task_tasktag_taskadmintxt_CSS");

			// click on the Due Date editor field
			click("task_tasktag_duedateeditortxt_CSS");

			// click on the none button
			click("task_tasktag_nonebtn_CSS");

			// click on the Due Date editor field
			click("task_tasktag_duedateeditortxt_CSS");

			// scroll down the screen
			scrollByPixel(300);

			// click on the Access to Schedule section field
			click("task_tasktag_accesstoschedulesectiontxt_CSS");

			// click on the none button
			click("task_tasktag_nonebtn_CSS");

			// click on the Access to Schedule section field
			click("task_tasktag_accesstoschedulesectiontxt_CSS");

			// click on the Access to Survey/Checklist section field
			click("task_tasktag_accesstosurveychecklistsectiontxt_CSS");

			// click on the none button
			click("task_tasktag_nonebtn_CSS");

			// click on the Access to Survey/Checklist section field
			click("task_tasktag_accesstosurveychecklistsectiontxt_CSS");

			// scroll down the screen
			scrollByPixel(200);

			// click on the Access to edit PO details field
			click("task_tasktag_accesstoeditpoedittxt_CSS");

			// click on the none button
			click("task_tasktag_nonebtn_CSS");

			// click on the Access to edit PO details field
			click("task_tasktag_accesstoeditpoedittxt_CSS");

			// click on the Access to view PO Estimate amount field
			click("task_tasktag_accesstoviewpoestimateamounttxt_CSS");

			// click on the none button
			click("task_tasktag_nonebtn_CSS");

			// click on the Access to edit PO details field
			click("task_tasktag_accesstoviewpoestimateamounttxt_CSS");

			// click on the Access to edit PO Estimate amount field
			click("task_tasktag_accesstoeditpoestimateamounttxt_CSS");

			// click on the none button
			click("task_tasktag_nonebtn_CSS");

			// click on the Access to edit PO Estimate amount field
			click("task_tasktag_accesstoeditpoestimateamounttxt_CSS");

			// click on the Access to replace Task Assignee field
			click("task_tasktag_accesstoreplacetaskassigneetxt_CSS");

			// click on the none button
			click("task_tasktag_nonebtn_CSS");

			// click on the Access to replace Task Assignee field
			click("task_tasktag_accesstoreplacetaskassigneetxt_CSS");

			// click on the update button
			click("task_tasktag_updatebtn_CSS");

		} catch (Throwable t) {
			verificationFailed();

		}

		// click on the home icon from the top of the screen
		click("questionnaire_homeburgermenubtn_CSS");

		// wait for element
		explicitWait("propertylist_title_XPATH");

		// verify the property list
		switchVerification("propertylist_title_XPATH", "Property List", "The property list is not displayed.");

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

			// enter the username in the search field
			type("task_tasktag_searchtxt_CSS", data.get("user_1"));

			// click on the searched result
			click("task_tasktag_searchedresult2_XPATH");

			// enter the role in the search field
			type("task_tasktag_searchtxt_CSS", data.get("role_1"));

			// click on the searched result
			click("task_tasktag_searchedresult3_XPATH");

			// click on the assign to field
			click("task_assigntotxt_CSS");

			// scroll down the screen
			scrollByPixel(1200);

			// wait for 3 seconds
			Thread.sleep(3000);

			// select the environmental option from the module dropdown
			select("task_addtask_moduledd_CSS", data.get("task_module"));

			// click on the task tag field
			click("task_tasktag_field_CSS");

			// click on the none button
			click("task_tasktag_nonebtn_CSS");

			// enter the task tag name in the search field
			type("task_tasktag_searchtxt_CSS", data.get("search_4"));

			// click on the searched result
			click("task_tasktag_searchedresult4_XPATH");

			// click on the task tag field
			click("task_tasktag_field_CSS");

			// click on the save button
			click("survey_task_savebtn_CSS");

			// scroll up the screen
			scrollByPixel(-400);

			// click on the clear button
			click("task_createdtask_clearbtn_XPATH");

			// enter the data in the search field
			type("task_filter_CSS", data.get("task_title"));

			// click on the search button
			click("task_createdtask_searchbtn_XPATH");

			// verify newly created task is displayed or not
			switchVerification("task_createdtask_tasktagpermission33_XPATH", "Test Task Tap Permission 3",
					"The Test Task Tap Permission 3 is not displayed.");

		} catch (Throwable t) {
			verificationFailed();
		}

		// LOGOUT FROM ADMIN USER AND LOGIN WITH JINESH AND VERIFY TASK IS
		// DISPLAYED OR NOT
		title("LOGOUT FROM ADMIN USER AND LOGIN WITH JINESH AND VERIFY TASK IS DISPLAYED OR NOT");

		try {

			// wait for element
			Thread.sleep(5000);

			// click on the settings icon from the top of the screen
			click("questionnaire_settingicon_CSS");

			// wait for element
			explicitWaitClickable("sidemenu_logout_CSS");

			// click on the logout option from the side menu
			click("sidemenu_logout_CSS");

			helper.loginAndUpdateSystemCompany(data, "username_5", "password_5", "system_company_1");

			// VERIFY THE FIELDS ARE DISPLAYED AS PER THE PERMISSION
			title("VERIFY THE FIELDS ARE DISPLAYED AS PER THE PERMISSION");

			try {

				// click on the task icon
				click("taskicon_CSS");

				// click on the clear button
				click("task_createdtask_clearbtn_XPATH");

				// enter the data in the search field
				type("task_filter_CSS", data.get("task_title"));

				// click on the search button
				click("task_createdtask_searchbtn_XPATH");

				// verify newly created task is displayed or not
				switchVerification("task_createdtask_tasktagpermission33_XPATH", "Test Task Tap Permission 3",
						"The Test Task Tap Permission 3 is not displayed.");

				// click on task which is displayed due the permission
				click("task_createdtask_tasktagpermission33_XPATH");

				// update the title of the task
				type("task_addtask_titletxt_CSS", data.get("update1_task_title"));

				// click on the update button
				click("task_tasktag_taskscreen_updatebtn_CSS");

				verificationFailedMessage("Update Title Verification failure");

			} catch (Throwable t) {
				successMessage("The user not able to update the task as expected.");
			}

			try {
				boolean str3 = driver.findElement(By.cssSelector(OR.getProperty("task_tasktag_powarrantytab_CSS")))
						.isDisplayed();

				if (str3 == true) {
					successMessage("The Purchase Order/Warranty tab is displayed as expected.");
				} else {
					verificationFailedMessage("The Purchase Order/Warranty tab verification failure.");
				}

			} catch (Throwable t) {
				verificationFailedMessage("The Purchase Order/Warranty tab verification failure.");
			}

			try {

				// click on the Purchase Order/Warranty tab
				click("task_tasktag_powarrantytab_CSS");

				// scroll down the screen
				scrollByPixel(500);

				boolean str5 = driver.findElement(By.cssSelector(OR.getProperty("task_tasktag_estimatedamount_CSS")))
						.isDisplayed();

				// wait for 3 seconds
				Thread.sleep(3000);

				if (str5 == true) {
					verificationFailedMessage("The Estimated Amount field verification failure.");
				} else {
					successMessage("The Estimated Amount field is not displayed as expected.");
				}

			} catch (Throwable t) {
				successMessage("The Estimated Amount field is not displayed as expected.");
			}

			try {
				boolean str4 = driver.findElement(By.cssSelector(OR.getProperty("task_tasktag_surveychecklisttab_CSS")))
						.isDisplayed();

				if (str4 == true) {
					verificationFailedMessage("The Survey/Checklist tab verification failure.");
				} else {
					successMessage("The Survey/Checklist tab is not displayed as expected.");
				}

			} catch (Throwable t) {
				successMessage("The Survey/Checklist tab is not displayed as expected.");
			}

			try {
				boolean str6 = driver.findElement(By.cssSelector(OR.getProperty("task_tasktag_changeduedatebtn_CSS")))
						.isDisplayed();

				if (str6 == true) {

					verificationFailedMessage("The Chnage Due Date button verification failure.");
				} else {
					successMessage("The Chnage Due Date button is not displayed as expected.");
				}

			} catch (Throwable t) {
				successMessage("The Chnage Due Date button is not displayed as expected.");
			}

			// LOGOUT FROM JINESH MISC 2 USER AND LOGIN WITH MAINTANANCE USER AND VERIFY
			// TASK IS DISPLAYED OR NOT
			title("LOGOUT FROM JINESH MISC 2 USER AND LOGIN WITH MAINTANANCE USER");

			try {
				// wait for element
				Thread.sleep(5000);

				// click on the settings icon from the top of the screen
				click("questionnaire_settingicon_CSS");

				// wait for element
				explicitWaitClickable("sidemenu_logout_CSS");

				// click on the logout option from the side menu
				click("sidemenu_logout_CSS");

				helper.loginAndUpdateSystemCompany(data, "username_2", "password_2", "system_company_1");

				// VERIFY TASK IS DISPLAYED OR NOT
				title("VERIFY TASK IS DISPLAYED OR NOT");

				// click on the task icon
				click("taskicon_CSS");

				// click on the clear button
				click("task_createdtask_clearbtn_XPATH");

				// enter the data in the search field
				type("task_filter_CSS", data.get("task_title"));

				// click on the search button
				click("task_createdtask_searchbtn_XPATH");

				// verify newly created task is displayed or not
				switchVerification("task_createdtask_tasktagpermission33_XPATH", "Test Task Tap Permission 3",
						"The Test Task Tap Permission 3 is not displayed.");

				// click on task which is displayed due the permission
				click("task_createdtask_tasktagpermission33_XPATH");

				// VERIFY THE FIELDS ARE DISPLAYED AS PER THE PERMISSION
				title("VERIFY THE FIELDS ARE DISPLAYED AS PER THE PERMISSION");

				// update the title of the task
				type("task_addtask_titletxt_CSS", data.get("update1_task_title"));

				// click on the update button
				click("task_tasktag_taskscreen_updatebtn_CSS");

				verificationFailedMessage("Update Title Verification failure.");

			} catch (Throwable t) {
				successMessage("The user not able to update the task as expected.");
			}

			try {
				boolean str7 = driver.findElement(By.cssSelector(OR.getProperty("task_tasktag_powarrantytab_CSS")))
						.isDisplayed();

				if (str7 == true) {
					successMessage("The Purchase Order/Warranty tab is displayed as expected.");
				} else {
					verificationFailedMessage("The Purchase Order/Warranty tab verification failure.");
				}

			} catch (Throwable t) {
				verificationFailedMessage("The Purchase Order/Warranty tab verification failure.");
			}

			try {
				// click on the Purchase Order/Warranty tab
				click("task_tasktag_powarrantytab_CSS");

				// scroll down the screen
				scrollByPixel(500);

				boolean str8 = driver.findElement(By.cssSelector(OR.getProperty("task_tasktag_estimatedamount_CSS")))
						.isDisplayed();

				// wait for 3 seconds
				Thread.sleep(3000);

				if (str8 == true) {

					verificationFailedMessage("The Estimated Amount field verification failure.");
				} else {
					successMessage("The Estimated Amount field is not displayed as expected.");
				}

			} catch (Throwable t) {
				successMessage("The Estimated Amount field is not displayed as expected.");
			}

			try {
				boolean str9 = driver.findElement(By.cssSelector(OR.getProperty("task_tasktag_surveychecklisttab_CSS")))
						.isDisplayed();

				if (str9 == true) {

					verificationFailedMessage("The Survey/Checklist tab verification failure.");
				} else {
					successMessage("The Survey/Checklist tab is not displayed as expected.");
				}

			} catch (Throwable t) {
				successMessage("The Survey/Checklist tab is not displayed as expected.");
			}

			try {
				boolean str10 = driver.findElement(By.cssSelector(OR.getProperty("task_tasktag_changeduedatebtn_CSS")))
						.isDisplayed();

				if (str10 == true) {

					verificationFailedMessage("The Chnage Due Date button verification failure.");
				} else {
					successMessage("The Chnage Due Date button is not displayed as expected.");
				}

			} catch (Throwable t) {
				successMessage("The Chnage Due Date button is not displayed as expected.");
			}

			// LOGOUT FROM MANINTANANCE USER AND LOGIN WITH JINESH CONTRACTOR USER
			title("LOGOUT FROM MANINTANANCE USER AND LOGIN WITH JINESH CONTRACTOR USER");

			try {
				// wait for element
				Thread.sleep(5000);

				// click on the settings icon from the top of the screen
				click("questionnaire_settingicon_CSS");

				// wait for element
				explicitWaitClickable("sidemenu_logout_CSS");

				// click on the logout option from the side menu
				click("sidemenu_logout_CSS");

				helper.loginAndUpdateSystemCompany(data, "username", "password", "system_company_1");

				// VERIFY TASK IS DISPLAYED OR NOT
				title("VERIFY TASK IS DISPLAYED OR NOT");

				// click on the task icon
				click("taskicon_CSS");

				// click on the clear button
				click("task_createdtask_clearbtn_XPATH");

				// enter the data in the search field
				type("task_filter_CSS", data.get("task_title"));

				// click on the search button
				click("task_createdtask_searchbtn_XPATH");

				try {
					String str1 = driver
							.findElement(By.xpath(OR.getProperty("task_createdtask_tasktagpermission33_XPATH")))
							.getText();

					if (str1.equals("Test Task Tap Permission 3")) {

						verificationFailedMessage("The task is not verified.");
					}
				} catch (Throwable t) {
					successMessage("The task is verified successfully.");
				}
			} catch (Throwable t) {
				verificationFailed();
			}

			// click on the home icon from the top of the screen
			click("questionnaire_homeburgermenubtn_hide_CSS");

			// wait for element
			explicitWait("propertylist_title_XPATH");

			// verify the property list
			switchVerification("propertylist_title_XPATH", "Property List", "The property list is not displayed.");

			// LOGOUT FROM CONTRACTOR USER AND LOGIN WITH AUTOMATION TESTER I.E. SUPER USER
			title("LOGOUT FROM CONTRACTOR USER AND LOGIN WITH AUTOMATION TESTER I.E. SUPER USER");

			// wait for element
			Thread.sleep(5000);

			// click on the settings icon from the top of the screen
			click("questionnaire_settingicon_CSS");

			// wait for element
			explicitWaitClickable("sidemenu_logout_CSS");

			// click on the logout option from the side menu
			click("sidemenu_logout_CSS");

			helper.loginAndUpdateSystemCompany(data, "username_1", "password_1", "system_company_1");

		} catch (Throwable t) {
			helper.questionnaireNotDisplayLogout(data);
		}

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

			// verify newly created task is displayed or not
			switchVerification("task_createdtask_tasktagpermission33_XPATH", "Test Task Tap Permission 3",
					"The Test Task Tap Permission 3 is not displayed.");

			// click on task which is displayed due the permission
			click("task_createdtask_tasktagpermission33_XPATH");

			// wait for element
			explicitWaitClickable("task_tasktag_taskscreen_deletebtn_CSS");

			// click on the delete button
			click("task_tasktag_taskscreen_deletebtn_CSS");

			// wait for element
			explicitWaitClickable("task_deletedtaskbtn_confirmaiton_CSS");

			// click on the delete button of the confirmation message
			click("task_deletedtaskbtn_confirmaiton_CSS");

			// click on the clear button
			click("task_createdtask_clearbtn_XPATH");

			// enter the data in the search field
			type("task_filter_CSS", data.get("task_title"));

			// click on the search button
			click("task_createdtask_searchbtn_XPATH");

			helper.deleteVerification("task_createdtask_tasktagpermission33_XPATH", "Test Task Tap Permission 3");

		} catch (Throwable t) {
			verificationFailed();
		}

		// click on the home icon from the top of the screen
		click("questionnaire_homeburgermenubtn_hide_CSS");

		// wait for element
		explicitWait("propertylist_title_XPATH");

		// verify the property list
		switchVerification("propertylist_title_XPATH", "Property List", "The property list is not displayed.");

	}
}