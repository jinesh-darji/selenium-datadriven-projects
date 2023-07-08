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

public class RR4529TaskTest extends TestBase {

	@Test(dataProviderClass = TestUtil.class, dataProvider = "dp")
	public void rR4529TaskTest(Hashtable<String, String> data) throws IOException, InterruptedException {

		execution(data, "rR4529TaskTest");

		// VERIFY THE TASK WITH TASK TAG PERMISSION (MODULE NAMES: ENVIRONMENT, ACCESS
		// TO EDIT PO DETAILS: USER-JINESH MISC 2 AND ROLE-MAINTENANCE)
		title("VERIFY THE TASK WITH TASK TAG PERMISSION (MODULE NAMES: ENVIRONMENT, ACCESS TO EDIT PO DETAILS: USER-JINESH MISC 2 AND ROLE-MAINTENANCE).");

		Helper helper = new Helper();

		// refresh the page
		driver.navigate().refresh();
		Thread.sleep(5000);
		driver.navigate().refresh();

		// RESET THE RESPECTIVE PERMISSIONS
		title("RESET THE RESPECTIVE PERMISSIONS");

		try {

			// wait for the element
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

				// enter security setting name in the search field
				type("propertyproject_le_filtertxt_CSS", data.get("security_settings_3"));

				// click on the searched result
				click("securitysettings_editoposection_XPATH");

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

			// scroll down the screen
			scrollByPixel(200);

			// click on the Access to edit PO details field
			click("task_tasktag_accesstoeditpoedittxt_CSS");

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

			// click on the Access to edit PO details field
			click("task_tasktag_accesstoeditpoedittxt_CSS");

			// wait for 3 seconds
			Thread.sleep(3000);

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

			// wait for 3 second
			Thread.sleep(3000);

			// scroll up the screen
			scrollByPixel(-200);

			// click on the Task Admin field
			click("task_tasktag_taskadmintxt_CSS");

			// click on the none button
			click("task_tasktag_nonebtn_CSS");

			// click on the Task Admin field
			click("task_tasktag_taskadmintxt_CSS");

			// scroll down the screen
			scrollByPixel(200);

			// click on the Due Date editor field
			click("task_tasktag_duedateeditortxt_CSS");

			// click on the none button
			click("task_tasktag_nonebtn_CSS");

			// click on the Due Date editor field
			click("task_tasktag_duedateeditortxt_CSS");

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

			// click on the Access to view PO Estimate amount field
			click("task_tasktag_accesstoviewpoestimateamounttxt_CSS");

			// click on the none button
			click("task_tasktag_nonebtn_CSS");

			// click on the Access to view PO Estimate amount field
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
			type("task_tasktag_searchtxt_CSS", data.get("search_2"));

			// click on the searched result
			click("task_tasktag_searchedresult2_XPATH");

			// enter the role in the search field
			type("task_tasktag_searchtxt_CSS", data.get("search_3"));

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
			switchVerification("task_createdtask_tasktagpermission55_XPATH", "Test Task Tap Permission 5",
					"The Test Task Tap Permission 5 is not displayed.");

		} catch (Throwable t) {
			verificationFailed();
		}

		// click on the home icon from the top of the screen
		click("questionnaire_homeburgermenubtn_hide_CSS");

		// wait for element
		explicitWait("propertylist_title_XPATH");

		// verify the property list
		switchVerification("propertylist_title_XPATH", "Property List", "The property list is not displayed.");

		// LOGOUT FROM ADMIN USER AND LOGIN WITH JINESH MISC 2 AND VERIFY TASK IS
		// DISPLAYED OR NOT
		title("LOGOUT FROM ADMIN USER AND LOGIN WITH JINESH MISC 2 AND VERIFY TASK IS DISPLAYED OR NOT");

		try {

			// wait for the element
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
				switchVerification("task_createdtask_tasktagpermission55_XPATH", "Test Task Tap Permission 5",
						"The Test Task Tap Permission 5 is not displayed.");

				// click on task which is displayed due the permission
				click("task_createdtask_tasktagpermission55_XPATH");

				// update the title of the task
				type("task_addtask_titletxt_CSS", data.get("update1_task_title"));

				// click on the update button
				click("task_tasktag_taskscreen_updatebtn_CSS");

				verificationFailedMessage("Update Title Verification failure");
			} catch (Throwable t) {
				successMessage("The user not able to update the task as expected.");
			}

			// The Purchase Order/Warranty tab is displayed or not
			try {
				boolean str3 = driver.findElement(By.cssSelector(OR.getProperty("task_tasktag_powarrantytab_CSS")))
						.isDisplayed();

				if (str3 == true) {
					successMessage("The Purchase Order/Warranty tab is displayed as expected.");
				} else {
					verificationFailedMessage("The Purchase Order/Warranty tab verification failure");
				}

			} catch (Throwable t) {
				verificationFailedMessage("The Purchase Order/Warranty tab verification failure");
			}

			// The PO Required checkbox is displayed or not
			try {
				// click on the Purchase Order/Warranty tab
				click("task_tasktag_powarrantytab_CSS");

				// scroll down the screen

				scrollByPixel(200);

				boolean str11 = driver
						.findElement(By.cssSelector(OR.getProperty("task_tasktag_newduedatetxt_porequiredckbx_CSS")))
						.isEnabled();

				boolean str16 = driver
						.findElement(By.cssSelector(OR.getProperty("task_tasktag_newduedatetxt_porequiredckbx_CSS")))
						.isDisplayed();

				if (str11 && str16 == true) {
					successMessage("The PO Required checkbox is displayed as expected.");

					// click on the PO Required checkbox
					click("task_tasktag_newduedatetxt_porequiredckbx_CSS");

				} else {
					verificationFailedMessage("The PO Required checkbox verification failure");
				}

			} catch (Throwable t) {
				verificationFailedMessage("The PO Required checkbox verification failure");
			}

			// The PO Approved checkbox is displayed or not
			try {
				boolean str12 = driver
						.findElement(By.cssSelector(OR.getProperty("task_tasktag_newduedatetxt_poapprovedckbx_CSS")))
						.isEnabled();

				boolean str17 = driver
						.findElement(By.cssSelector(OR.getProperty("task_tasktag_newduedatetxt_poapprovedckbx_CSS")))
						.isDisplayed();

				if (str12 && str17 == true) {
					successMessage("The PO Approved checkbox is displayed as expected.");

					// click on the PO Approved checkbox
					click("task_tasktag_newduedatetxt_poapprovedckbx_CSS");

				} else {
					verificationFailedMessage("The PO Approved checkbox verification failure");
				}

			} catch (Throwable t) {

				verificationFailedMessage("The PO Approved checkbox verification failure");
			}

			// The PO Number checkbox is displayed or not
			try {
				boolean str13 = driver
						.findElement(By.cssSelector(OR.getProperty("task_tasktag_newduedatetxt_ponumbertxt_CSS")))
						.isEnabled();

				boolean str18 = driver
						.findElement(By.cssSelector(OR.getProperty("task_tasktag_newduedatetxt_ponumbertxt_CSS")))
						.isDisplayed();

				if (str18 && str13 == true) {
					successMessage("The PO Number checkbox is displayed as expected.");

					// Enter the PO Number checkbox
					type("task_tasktag_newduedatetxt_ponumbertxt_CSS", data.get("po_number"));

				} else {
					verificationFailedMessage("The PO Number checkbox verification failure");
				}

			} catch (Throwable t) {
				verificationFailedMessage("The PO Number checkbox verification failure");
			}

			// The Approved to Proceed checkbox is displayed or not
			try {
				boolean str14 = driver
						.findElement(
								By.cssSelector(OR.getProperty("task_tasktag_newduedatetxt_approvaltoprovideckbx_CSS")))
						.isEnabled();

				boolean str19 = driver
						.findElement(
								By.cssSelector(OR.getProperty("task_tasktag_newduedatetxt_approvaltoprovideckbx_CSS")))
						.isDisplayed();

				if (str19 && str14 == true) {
					successMessage("The Approved to Proceed checkbox is displayed as expected.");

					// click on the Approved to Proceed checkbox
					click("task_tasktag_newduedatetxt_approvaltoprovideckbx_CSS");

				} else {
					verificationFailedMessage("The Approved to Proceed checkbox verification failure");
				}

			} catch (Throwable t) {
				verificationFailedMessage("The Approved to Proceed checkbox verification failure");
			}

			// The Estimate Required checkbox is displayed or not
			try {
				boolean str15 = driver
						.findElement(
								By.cssSelector(OR.getProperty("task_tasktag_newduedatetxt_estimaterequiredckbx_CSS")))
						.isEnabled();

				boolean str20 = driver
						.findElement(
								By.cssSelector(OR.getProperty("task_tasktag_newduedatetxt_estimaterequiredckbx_CSS")))
						.isDisplayed();

				if (str20 && str15 == true) {
					successMessage("The Estimate Required checkbox is displayed as expected.");

					// scroll down the screen
					scrollByPixel(200);

					// click on the Estimate Required checkbox
					click("task_tasktag_newduedatetxt_estimaterequiredckbx_CSS");

				} else {
					verificationFailedMessage("The Estimate Required checkbox verification failure");
				}

			} catch (Throwable t) {
				verificationFailedMessage("The Estimate Required checkbox verification failure");
			}

			// scroll down the screen
			scrollByPixel(200);

			// The Estimated Amount field is displayed or not
			try {

				boolean str5 = driver.findElement(By.cssSelector(OR.getProperty("task_tasktag_estimatedamount_CSS")))
						.isDisplayed();

				// wait for 3 seconds
				Thread.sleep(3000);

				if (str5 == true) {

					verificationFailedMessage("The Estimated Amount field verification failure");

				} else {
					successMessage("The Estimated Amount field is not displayed as expected.");
				}
			} catch (Throwable t) {
				successMessage("The Estimated Amount field is not displayed as expected.");
			}

			// The Survey/Checklist tab is displayed or not
			try {
				boolean str4 = driver.findElement(By.cssSelector(OR.getProperty("task_tasktag_surveychecklisttab_CSS")))
						.isDisplayed();

				if (str4 == true) {

					verificationFailedMessage("The Survey/Checklist tab verification failure");
				} else {
					successMessage("The Survey/Checklist tab is not displayed as expected.");
				}

			} catch (Throwable t) {
				successMessage("The Survey/Checklist tab is not displayed as expected.");
			}

			// The Change Due Date button is displayed or not
			try {
				boolean str6 = driver.findElement(By.cssSelector(OR.getProperty("task_tasktag_changeduedatebtn_CSS")))
						.isDisplayed();

				if (str6 == true) {

					verificationFailedMessage("The Chnage Due Date button verification failure");
				} else {
					successMessage("The Chnage Due Date button is not displayed as expected.");
				}

			} catch (Throwable t) {
				successMessage("The Chnage Due Date button is not displayed as expected.");
			}

			// click on the home icon from the top of the screen
			click("questionnaire_homeburgermenubtn_hide_CSS");

			// wait for element
			explicitWait("propertylist_title_XPATH");

			// verify the property list
			switchVerification("propertylist_title_XPATH", "Property List", "The property list is not displayed.");

			// LOGOUT FROM JINESH MISC 2 USER AND LOGIN WITH MAINTANANCE USER AND VERIFY
			// TASK IS DISPLAYED OR NOT
			title("LOGOUT FROM JINESH MISC 2 USER AND LOGIN WITH MAINTANANCE USER");

			try {
				// wait for the element
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
				switchVerification("task_createdtask_tasktagpermission55_XPATH", "Test Task Tap Permission 5",
						"The Test Task Tap Permission 5 is not displayed.");

				// click on task which is displayed due the permission
				click("task_createdtask_tasktagpermission55_XPATH");

				// VERIFY THE FIELDS ARE DISPLAYED AS PER THE PERMISSION
				title("VERIFY THE FIELDS ARE DISPLAYED AS PER THE PERMISSION");

				// update the title of the task
				type("task_addtask_titletxt_CSS", data.get("update1_task_title"));

				// click on the update button
				click("task_tasktag_taskscreen_updatebtn_CSS");

				verificationFailedMessage("Update Title Verification failure");

			} catch (Throwable t) {
				successMessage("The user not able to update the task as expected.");
			}

			// The Purchase Order/Warranty tab is displayed or not
			try {
				boolean str7 = driver.findElement(By.cssSelector(OR.getProperty("task_tasktag_powarrantytab_CSS")))
						.isDisplayed();

				if (str7 == true) {
					successMessage("The Purchase Order/Warranty tab is displayed as expected.");
				} else {
					verificationFailedMessage("The Purchase Order/Warranty tab verification is failed.");
				}

			} catch (Throwable t) {
				verificationFailedMessage("The Purchase Order/Warranty tab verification is failed.");
			}

			// The PO Required checkbox is displayed or not
			try {
				// click on the Purchase Order/Warranty tab
				click("task_tasktag_powarrantytab_CSS");

				// scroll down the screen
				scrollByPixel(200);

				boolean str21 = driver
						.findElement(By.cssSelector(OR.getProperty("task_tasktag_newduedatetxt_porequiredckbx_CSS")))
						.isEnabled();
				boolean str26 = driver
						.findElement(By.cssSelector(OR.getProperty("task_tasktag_newduedatetxt_porequiredckbx_CSS")))
						.isDisplayed();

				if (str21 && str26 == true) {

					successMessage("The PO Required checkbox is displayed as expected.");

					// click on the PO Required checkbox
					click("task_tasktag_newduedatetxt_porequiredckbx_CSS");

				} else {

					verificationFailedMessage("The PO Required checkbox verification is failed.");

				}

			} catch (Throwable t) {

				verificationFailedMessage("The PO Required checkbox verification is failed.");

			}

			// The PO Approved checkbox is displayed or not

			try {
				boolean str22 = driver
						.findElement(By.cssSelector(OR.getProperty("task_tasktag_newduedatetxt_poapprovedckbx_CSS")))
						.isEnabled();

				boolean str27 = driver
						.findElement(By.cssSelector(OR.getProperty("task_tasktag_newduedatetxt_poapprovedckbx_CSS")))
						.isDisplayed();

				if (str22 && str27 == true) {

					successMessage("The PO Approved checkbox is displayed as expected.");

					// click on the PO Approved checkbox
					click("task_tasktag_newduedatetxt_poapprovedckbx_CSS");

				} else {

					verificationFailedMessage("The PO Approved checkbox verification is failed.");

				}

			} catch (Throwable t) {

				verificationFailedMessage("The PO Approved checkbox verification is failed.");

			}

			// The PO Number checkbox is displayed or not

			try {
				boolean str23 = driver
						.findElement(By.cssSelector(OR.getProperty("task_tasktag_newduedatetxt_ponumbertxt_CSS")))
						.isEnabled();

				boolean str28 = driver
						.findElement(By.cssSelector(OR.getProperty("task_tasktag_newduedatetxt_ponumbertxt_CSS")))
						.isDisplayed();

				if (str28 && str23 == true) {

					successMessage("The PO Number checkbox is displayed as expected.");

					// Enter the PO Number checkbox
					type("task_tasktag_newduedatetxt_ponumbertxt_CSS", data.get("po_number"));

				} else {

					verificationFailedMessage("The PO Number checkbox verification failure : ");

				}

			} catch (Throwable t) {

				verificationFailedMessage("The PO Number checkbox verification failure : ");

			}

			// The Approved to Proceed checkbox is displayed or not

			try {
				boolean str24 = driver
						.findElement(
								By.cssSelector(OR.getProperty("task_tasktag_newduedatetxt_approvaltoprovideckbx_CSS")))
						.isEnabled();

				boolean str29 = driver
						.findElement(
								By.cssSelector(OR.getProperty("task_tasktag_newduedatetxt_approvaltoprovideckbx_CSS")))
						.isDisplayed();

				if (str24 && str29 == true) {

					successMessage("The Approved to Proceed checkbox is displayed as expected.");

					// click on the Approved to Proceed checkbox
					click("task_tasktag_newduedatetxt_approvaltoprovideckbx_CSS");

				} else {

					verificationFailedMessage("The Approved to Proceed checkbox verification failure.");
				}

			} catch (Throwable t) {

				verificationFailedMessage("The Approved to Proceed checkbox verification failure.");

			}

			// scroll down the screen
			scrollByPixel(100);

			// The Estimate Required checkbox is displayed or not
			try {
				boolean str25 = driver
						.findElement(
								By.cssSelector(OR.getProperty("task_tasktag_newduedatetxt_estimaterequiredckbx_CSS")))
						.isEnabled();

				boolean str30 = driver
						.findElement(
								By.cssSelector(OR.getProperty("task_tasktag_newduedatetxt_estimaterequiredckbx_CSS")))
						.isDisplayed();

				if (str25 && str30 == true) {

					successMessage("The Estimate Required checkbox is displayed as expected.");

					// click on the Estimate Required checkbox
					click("task_tasktag_newduedatetxt_estimaterequiredckbx_CSS");

				} else {

					verificationFailedMessage("The Estimate Required checkbox verification failure.");

				}

			} catch (Throwable t) {

				verificationFailedMessage("The Estimate Required checkbox verification failure.");

			}

			// scroll down the screen
			scrollByPixel(100);

			// The Estimated Amount field is displayed or not
			try {

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

			// The Survey/Checklist tab is displayed or not

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

			// The Change Due Date button is displayed or not

			try {
				boolean str10 = driver.findElement(By.cssSelector(OR.getProperty("task_tasktag_changeduedatebtn_CSS")))
						.isDisplayed();

				if (str10 == true) {

					verificationFailedMessage("The Change Due Date button verification failure.");

				} else {

					successMessage("The Change Due Date button is not displayed as expected.");

				}

			} catch (Throwable t) {

				successMessage("The Change Due Date button is not displayed as expected.");

			}

			// click on the home icon from the top of the screen
			click("questionnaire_homeburgermenubtn_hide_CSS");

			// wait for element
			explicitWait("propertylist_title_XPATH");

			// verify the property list
			switchVerification("propertylist_title_XPATH", "Property List", "The property list is not displayed.");

			// LOGOUT FROM MANINTANANCE USER AND LOGIN WITH JINESH CONTRACTOR USER
			title("LOGOUT FROM MANINTANANCE USER AND LOGIN WITH JINESH CONTRACTOR USER");

			try {
				// wait for the element
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
							.findElement(By.xpath(OR.getProperty("task_createdtask_tasktagpermission55_XPATH")))
							.getText();

					if (str1.equals("Test Task Tap Permission 5")) {

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

			// wait for the element
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
			switchVerification("task_createdtask_tasktagpermission55_XPATH", "Test Task Tap Permission 5",
					"The Test Task Tap Permission 5 is not displayed.");

			// click on task which is displayed due the permission
			click("task_createdtask_tasktagpermission55_XPATH");

			// click on the delete button
			click("task_tasktag_taskscreen_deletebtn_CSS");

			// click on the delete button of the confirmation message
			click("task_deletedtaskbtn_confirmaiton_CSS");

			// click on the clear button
			click("task_createdtask_clearbtn_XPATH");

			// enter the data in the search field
			type("task_filter_CSS", data.get("task_title"));

			// click on the search button
			click("task_createdtask_searchbtn_XPATH");

			helper.deleteVerification("task_createdtask_tasktagpermission55_XPATH", "Test Task Tap Permission 5");

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