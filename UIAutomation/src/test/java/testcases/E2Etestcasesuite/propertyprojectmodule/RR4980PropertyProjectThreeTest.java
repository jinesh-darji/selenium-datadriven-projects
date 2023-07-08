package testcases.E2Etestcasesuite.propertyprojectmodule;

import java.io.IOException;
import java.util.Hashtable;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.testng.Reporter;
import org.testng.SkipException;
import org.testng.annotations.Test;

import com.relevantcodes.extentreports.LogStatus;

import base.Helper;
import base.TestBase;
import utilities.TestUtil;

public class RR4980PropertyProjectThreeTest extends TestBase {

	@Test(dataProviderClass = TestUtil.class, dataProvider = "dp")
	public void rR4980PropertyProjectThreeTest(Hashtable<String, String> data)
			throws IOException, InterruptedException {

		execution(data, "rR4980PropertyProjectThreeTest");

		// THE "ASSIGNED TO" FIELD MUST FETCH THE DEFAULT USER LIST AS CONFIGURED IN
		// SECURITY SETTINGS - MUNICIPAL ORDERS.
		title("THE \\\"ASSIGNED TO\\\" FIELD MUST FETCH THE DEFAULT USER LIST AS CONFIGURED IN SECURITY SETTINGS - MUNICIPAL ORDERS.");

		Helper helper = new Helper();

		// refresh the page
		driver.navigate().refresh();
		Thread.sleep(5000);
		driver.navigate().refresh();

		try {

			// wait for the element
			explicitWaitClickable("questionnaire_settingicon_userupdate_CSS");

			// click on the settings icon
			click("questionnaire_settingicon_userupdate_CSS");

			// wait for the element
			explicitWaitClickable("questionnaire_administrationoption_XPATH");

			// click on the Administration option from the side menu
			click("questionnaire_administrationoption_XPATH");

			// click on the Security tab
			click("questionnaire_securitytab_XPATH");

			// click on the Security Settings option
			click("ssc_securitytab_securitysettingsoption_XPATH");

			// APPLY THE ACCESS OF DEFAULT PROPERTY PROJECT MUNICIPAL ORDERS TASK ASSIGNEES
			title("APPLY THE ACCESS OF DEFAULT PROPERTY PROJECT MUNICIPAL ORDERS TASK ASSIGNEES");

			helper.addPermissionOneUsersRoleTask(data, "search_ss", "propertyproject_mu_task_searchedss2_XPATH");

			// ADD SECURITY SETTINGS OF VIEW MUNICIPAL ORDERS TO USER/ROLE ACCESS
			title("ADD SECURITY SETTINGS OF VIEW MUNICIPAL ORDERS TO USER/ROLE ACCESS");

			// APPLY THE VIEW MUNICIPAL ORDERS PERMISSION
			helper.addPermissionOneUsersRoleTask(data, "security_setting_9", "propertyproject_securitysettings9_XPATH");

			// APPLY THE ADD MUNICIPAL ORDERS PERMISSION
			helper.addPermissionOneUsersRoleTask(data, "security_setting_10",
					"propertyproject_securitysettings10_XPATH");

			// RESET THE EDIT MUNICIPAL ORDERS PERMISSION
			helper.resetPermission(data, "security_setting_11", "propertyproject_securitysettings11_XPATH");

			// RESET THE DELETE MUNICIPAL ORDERS PERMISSION
			helper.resetPermission(data, "security_setting_12", "propertyproject_securitysettings12_XPATH");

			// APPLY THE ADD TASK PERMISSION
			title("APPLY THE ADD TASK PERMISSION");

			// enter security setting name in the search field
			type("propertyproject_le_filtertxt_CSS", data.get("security_setting_13"));

			// click on the searched result
			click("propertyproject_securitysettings13_XPATH");

			// click on the select role field
			click("propertyproject_securitysettings1_selectroles_CSS");

			// click on the none button
			click("propertyproject_securitysettings1_nonebtn_CSS");

			// enter the name of the role in search field
			type("propertyproject_securitysettings1_searchtxt_CSS", data.get("role_1"));

			// click on the searched result
			click("task_permission_securitysettings_seachedrole_XPATH");

			// enter the name of the role in search field
			type("propertyproject_securitysettings1_searchtxt_CSS", data.get("role_2"));

			// click on the searched result
			click("task_permission_securitysettings_seachedrole2_XPATH");

			// click on the select role field
			click("propertyproject_securitysettings1_selectroles_CSS");

			// click on the select user field
			click("propertyproject_securitysettings1_selectusers_CSS");

			// click on the none button
			click("propertyproject_securitysettings1_nonebtn_CSS");

			// enter the name of the user in search field
			type("propertyproject_securitysettings1_searchtxt_CSS", data.get("user_1"));

			// click on the searched result
			click("task_permission_securitysettings_seacheduser_XPATH");

			// enter the name of the user in search field
			type("propertyproject_securitysettings1_searchtxt_CSS", data.get("user_2"));

			// click on the searched result
			click("task_permission_securitysettings_seacheduser2_XPATH");

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

		try {
			// click on the administration
			click("administration_XPATH");

			// click on the Security tab
			click("questionnaire_securitytab_XPATH");

			// click on the roles option
			click("ssc_securitytab_rolesoption_XPATH");

			// scroll down the screen
			scrollByPixel(200);

			// collect all the roles
			try {
				String pages = driver.findElement(By.cssSelector("strong")).getText();
				String[] arrOfStr = pages.split(" ");
				String pageno = arrOfStr[3];
				int pagecount = Integer.parseInt(pageno);

				for (int i = 0; i < pagecount; i++) {

					List<WebElement> roles = driver.findElements(By.xpath("//tr//div"));
					int rolesnum = roles.size();

					for (int j = 0; j < rolesnum; j++) {

						WebElement rolestext = roles.get(j);
						String getrole = rolestext.getText();

						if (getrole.equalsIgnoreCase("Contractor")) {

							// click on the Contractor role
							click("task_permission_roles_XPATH");

							break;
						}
					}

					// click on the next button
					click("task_permission_roles_nextbtn_CSS");

				}
			} catch (Throwable t) {
				successMessage("Successfully navigate to the Role Details screen.");
			}

			// scroll down the screen
			scrollByPixel(600);

			// click on the Allow Task Assignment to Roles field
			click("task_permission_rolelevel_role1_CSS");

			// click on the none button
			click("task_permission_securitysettings_nonebtn_CSS");

			// click on the Allow Task Assignment to Roles field
			click("task_permission_rolelevel_role1_CSS");

			// click on the Default User Task Assignees field
			click("task_permission_rolelevel_user2_CSS");

			// click on the none button
			click("task_permission_securitysettings_nonebtn_CSS");

			// type the user name in the search field
			type("task_permission_securitysettings_searchtxt_CSS", data.get("user_rolelevel"));

			// click on the searched result
			click("task_permission_rolelevel_searched1_XPATH");

			// click on the Default User Task Assignees field
			click("task_permission_rolelevel_user2_CSS");

			// click on the Default Role Task Assignees field
			click("task_permission_rolelevel_role3_CSS");

			// click on the none button
			click("task_permission_securitysettings_nonebtn_CSS");

			// type the role name in the search field
			type("task_permission_securitysettings_searchtxt_CSS", data.get("role_rolelevel"));

			// click on the searched result
			click("task_permission_rolelevel_searched2_XPATH");

			// click on the Default Role Task Assignees field
			click("task_permission_rolelevel_role3_CSS");

			// click on the Default Tags For Task field
			click("task_permission_rolelevel_adhog4_CSS");

			// click on the none button
			click("task_permission_securitysettings_nonebtn_CSS");

			// click on the Default Tags For Task field
			click("task_permission_rolelevel_adhog4_CSS");

			// click on the save role button
			click("task_permission_roles_saverolebtn_CSS");

			// scroll up the screen
			scrollByPixel(-400);

		} catch (Throwable t) {
			verificationFailed();
		}

		// click on the home icon
		click("questionnaire_homeburgermenubtn_CSS");

		// synchronization
		explicitWait("propertylist_title_XPATH");

		// verify the property list
		switchVerification("propertylist_title_XPATH", "Property List", "The property list is not displayed.");

		// VERIFY DEFAULT USERS / ROLES DISPLAYED IN THE ASSIGN TO FIELD - CAPEX
		// PROJECTS
		title("VERIFY DEFAULT USERS / ROLES DISPLAYED IN THE ASSIGN TO FIELD - MUNICIPAL ORDERS");

		try {
			// click on the property project icon from the property list page
			click("propertyproject_icon_CSS");

			// wait for the element
			explicitWaitClickable("menubtn_CSS");

			// click on the burger menu
			click("menubtn_CSS");

			// wait for the element
			Thread.sleep(5000);

			// click on the Municipal Orders
			click("propertyproject_municipalordersoption_XPATH");

			// ADD RECORD - MUNICIPAL ORDERS
			title("ADD RECORD - MUNICIPAL ORDERS");

			// click on the add button
			click("propertyproject_mu_addbtn_CSS");

			// enter the project reference
			type("propertyproject_mo_projectnumbertxt_CSS", data.get("project_reference"));

			// select the Municipality
			select("propertyproject_mo_municipalitydd_CSS", data.get("municipality"));

			// click on the save button
			click("propertyproject_mo_savebtn_CSS");

			// wait for the element
			explicitWaitClickable("closetoastmsg_CSS");

			// click on the toaster close button
			click("closetoastmsg_CSS");

			// wait for the element
			explicitWaitClickable("propertyproject_mu_newrepairbtn_BTNTEXT");

			// click on the new repair button
			click("propertyproject_mu_newrepairbtn_BTNTEXT");

			// scroll down the screen
			scrollByPixel(800);

			// enter the title of the repair
			type("propertyproject_mu_repair_titletxt_CSS", data.get("task_title"));

			// enter the description
			type("propertyproject_mu_descriptiontxt_CSS", data.get("short_description"));

			// enter the unit number
			type("propertyproject_mu_unitenotxt_CSS", data.get("unit_number"));

			// verify the default user/role in assigned to field
			try {
				boolean str1 = driver.findElement(By.xpath("//span[text()='Jinesh QA']")).isDisplayed();
				boolean str2 = driver.findElement(By.xpath("//span[text()='Contractor']")).isDisplayed();

				consoleMessage("The default user/role are: " + str1 + " " + str2);

				if (str1 && str2) {
					successMessage("The default user/role is displayed successfully.");
				} else {
					verificationFailedMessage("The default user or role is not displayed.");
				}

			} catch (Throwable t) {
				verificationFailedMessage("The default user or role is not displayed.");
			}

			// click on the back button
			click("propertyproject_mu_attachmenttab_backbtn_CSS");

			// click on the cancel button
			click("propertyproject_mo_cancelbtn_CSS");

			// click on the home icon from the top of the screen
			click("questionnaire_homeburgermenubtn_hide_CSS");

			// synchronization
			explicitWait("propertylist_title_XPATH");

			// verify the property list
			switchVerification("propertylist_title_XPATH", "Property List", "The property list is not displayed.");

			// wait for the element
			explicitWaitClickable("questionnaire_settingicon_CSS");

			// click on the settings icon from the top of the screen
			click("questionnaire_settingicon_CSS");

			// wait for the element
			explicitWaitClickable("sidemenu_logout_CSS");

			// click on the logout option from the side menu
			click("sidemenu_logout_CSS");

			// VERIFY DEFAULT USERS / ROLES DISPLAYED IN THE ASSIGN TO FIELD - MUNICIPAL
			// ORDERS
			title("VERIFY DEFAULT USERS / ROLES DISPLAYED IN THE ASSIGN TO FIELD - MUNICIPAL ORDERS");

			// LOGIN IN JINESH QA
			title("LOGIN IN JINESH QA");

			helper.loginAndUpdateSystemCompany(data, "username", "password", "system_company_1");

			// click on the property project icon from the property list page
			click("propertyproject_icon_CSS");

			// wait for the element
			explicitWaitClickable("menubtn_CSS");

			// click on the burger menu
			click("menubtn_CSS");

			// wait for the element
			Thread.sleep(5000);

			// click on the Municipal Orders
			click("propertyproject_municipalordersoption_XPATH");

			// ADD RECORD - MUNICIPAL ORDERS
			title("ADD RECORD - MUNICIPAL ORDERS");

			// click on the add button
			click("propertyproject_mu_addbtn_CSS");

			// enter the project reference
			type("propertyproject_mo_projectnumbertxt_CSS", data.get("project_reference2"));

			// select the Municipality
			select("propertyproject_mo_municipalitydd_CSS", data.get("municipality"));

			// click on the save button
			click("propertyproject_mo_savebtn_CSS");

			// wait for the element
			Thread.sleep(5000);

			// click on the new repair button
			click("propertyproject_mu_newrepairbtn_BTNTEXT");

			// scroll down the screen
			scrollByPixel(800);

			// enter the title of the repair
			type("propertyproject_mu_repair_titletxt_CSS", data.get("task_title"));

			// enter the description
			type("propertyproject_mu_descriptiontxt_CSS", data.get("short_description"));

			// enter the unit number
			type("propertyproject_mu_unitenotxt_CSS", data.get("unit_number"));

			// verify the default user/role in assigned to field
			try {
				boolean str3 = driver.findElement(By.xpath("//span[text()='Jinesh QA']")).isDisplayed();
				boolean str4 = driver.findElement(By.xpath("//span[text()='Contractor']")).isDisplayed();

				consoleMessage("The default user/role are: " + str3 + " " + str4);

				if (str3 && str4) {
					successMessage("The default user/role is displayed successfully.");
				} else {
					verificationFailedMessage("The default user or role is not displayed.");
				}

			} catch (Throwable t) {
				verificationFailedMessage("The default user or role is not displayed.");
			}

			// click on the back button
			click("propertyproject_mu_attachmenttab_backbtn_CSS");

			// click on the cancel button
			click("propertyproject_mo_cancelbtn_CSS");

			// click on the home icon from the top of the screen
			click("questionnaire_homeburgermenubtn_hide_CSS");

			// synchronization
			explicitWait("propertylist_title_XPATH");

			// verify the property list
			switchVerification("propertylist_title_XPATH", "Property List", "The property list is not displayed.");

			// wait for the element
			explicitWaitClickable("questionnaire_settingicon_CSS");

			// click on the settings icon from the top of the screen
			click("questionnaire_settingicon_CSS");

			// wait for the element
			explicitWaitClickable("sidemenu_logout_CSS");

			// click on the logout option from the side menu
			click("sidemenu_logout_CSS");

			// VERIFY DEFAULT USERS / ROLES DISPLAYED IN THE ASSIGN TO FIELD - MORTGAGE
			// UNDERTAKING
			title("VERIFY DEFAULT USERS / ROLES DISPLAYED IN THE ASSIGN TO FIELD - MUNICIPAL ORDERS");

			// LOGIN IN JINESH CONTRACTOR
			title("LOGIN IN JINESH CONTRACTOR");

			helper.loginAndUpdateSystemCompany(data, "username_2", "password_2", "system_company_1");

			// click on the property project icon from the property list page
			click("propertyproject_icon_CSS");

			// wait for the element
			explicitWaitClickable("menubtn_CSS");

			// click on the burger menu
			click("menubtn_CSS");

			// wait for the element
			Thread.sleep(5000);

			// click on the Municipal Orders
			click("propertyproject_municipalordersoption_XPATH");

			// ADD RECORD - MUNICIPAL ORDERS
			title("ADD RECORD - MUNICIPAL ORDERS");

			// click on the add button
			click("propertyproject_mu_addbtn_CSS");

			// enter the project reference
			type("propertyproject_mo_projectnumbertxt_CSS", data.get("project_reference3"));

			// select the Municipality
			select("propertyproject_mo_municipalitydd_CSS", data.get("municipality"));

			// click on the save button
			click("propertyproject_mo_savebtn_CSS");

			// wait for the element
			Thread.sleep(5000);

			// click on the new repair button
			click("propertyproject_mu_newrepairbtn_BTNTEXT");

			// scroll down the screen
			scrollByPixel(800);

			// enter the title of the repair
			type("propertyproject_mu_repair_titletxt_CSS", data.get("task_title"));

			// enter the description
			type("propertyproject_mu_descriptiontxt_CSS", data.get("short_description"));

			// enter the unit number
			type("propertyproject_mu_unitenotxt_CSS", data.get("unit_number"));

			// verify the default user/role in assigned to field
			try {
				boolean str5 = driver.findElement(By.xpath("//span[text()='Jinesh QA']")).isDisplayed();
				boolean str6 = driver.findElement(By.xpath("//span[text()='Contractor']")).isDisplayed();
				boolean str7 = driver.findElement(By.xpath("//span[text()='Jinesh QA 2']")).isDisplayed();
				boolean str8 = driver.findElement(By.xpath("//span[text()='Human Resources']")).isDisplayed();

				consoleMessage("The default user/role are: " + str5 + " " + str6 + " " + str7 + " " + str8);

				if (str5 && str6 && str7 && str8) {
					successMessage("The default user/role is displayed successfully.");
				} else {
					verificationFailedMessage("The default user or role is not displayed.");
				}

			} catch (Throwable t) {
				verificationFailedMessage("The default user or role is not displayed.");
			}

			// click on the back button
			click("propertyproject_mu_attachmenttab_backbtn_CSS");

			// click on the cancel button
			click("propertyproject_mo_cancelbtn_CSS");

			// click on the home icon from the top of the screen
			click("questionnaire_homeburgermenubtn_hide_CSS");

			// synchronization
			explicitWait("propertylist_title_XPATH");

			// verify the property list
			switchVerification("propertylist_title_XPATH", "Property List", "The property list is not displayed.");

			// wait for the element
			explicitWaitClickable("questionnaire_settingicon_CSS");

			// click on the settings icon from the top of the screen
			click("questionnaire_settingicon_CSS");

			// wait for the element
			explicitWaitClickable("sidemenu_logout_CSS");

			// click on the logout option from the side menu
			click("sidemenu_logout_CSS");

			// DELETE THE CREATED MUNICIPAL ORDERS AND RESET THE GIVEN PERMISSIONS
			title("DELETE THE CREATED MUNICIPAL ORDERS AND RESET THE GIVEN PERMISSIONS");

			// LOGIN IN AUTOMATION TESTER USER
			title("LOGIN IN AUTOMATION TESTER USER");

			helper.loginAndUpdateSystemCompany(data, "username_1", "password_1", "system_company_1");

		} catch (Throwable t) {
			helper.questionnaireNotDisplayLogout(data);
		}

		// DELETE THE MUNICIPAL ORDERS
		title("DELETE THE MUNICIPAL ORDERS");

		try {

			// click on the property project icon from the property list page
			click("propertyproject_icon_CSS");

			// wait for the element
			explicitWaitClickable("menubtn_CSS");

			// click on the burger menu
			click("menubtn_CSS");

			// wait for the element
			Thread.sleep(5000);

			// click on the Municipal Orders
			click("propertyproject_municipalordersoption_XPATH");

			// click on the delete button of the newly created MUNICIPAL ORDERSs
			List<WebElement> links4 = driver.findElements(By.xpath("//tr"));
			int count4 = links4.size();
			consoleMessage("Number of links are:" + count4);

			for (int i = 0; i < count4 - 1; i++) {

				// wait for the element
				explicitWaitClickable("propertyproject_mo_deletebtn_CSS");

				// delete the all the MUNICIPAL ORDERSs
				click("propertyproject_mo_deletebtn_CSS");

				// wait for the element
				explicitWaitClickable("propertyproject_mo_confirmationdeletebtn_CSS");

				// click on the delete button of confirmation
				click("propertyproject_mo_confirmationdeletebtn_CSS");

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

		title("RESET THE APPLIED PERMISSIONS");

		// wait for the element
		explicitWaitClickable("questionnaire_settingicon_CSS");

		try {
			// click on the settings icon from the top of the screen
			click("questionnaire_settingicon_CSS");

			// wait for the element
			explicitWaitClickable("questionnaire_administrationoption_XPATH");

			// click on the Administration option from the side menu
			click("questionnaire_administrationoption_XPATH");

			// click on the security tab
			click("questionnaire_securitytab_XPATH");

			// click on the security settings option
			click("questionnaire_securotysettingsoption_XPATH");

			// RESET THE VIEW MUNICIPAL ORDERS PERMISSION
			helper.resetPermission(data, "security_setting_9", "propertyproject_securitysettings9_XPATH");

			// RESET THE ADD MUNICIPAL ORDERS PERMISSION
			helper.resetPermission(data, "security_setting_10", "propertyproject_securitysettings10_XPATH");

			// RESET THE PERMISSION TO DEFAULT PROPERTY PROJECT MUNICIPAL ORDERS TASK
			// ASSIGNEES
			helper.resetPermission(data, "search_ss", "propertyproject_mu_task_searchedss2_XPATH");

			// RESET THE PERMISSION TO TASK CREATOR
			helper.resetPermission(data, "security_setting_13", "propertyproject_securitysettings13_XPATH");

		} catch (Throwable t) {
			verificationFailed();
		}

		try {
			// click on the administration
			click("administration_XPATH");

			// click on the Security tab
			click("questionnaire_securitytab_XPATH");

			// click on the roles option
			click("ssc_securitytab_rolesoption_XPATH");

			// scroll down the screen
			scrollByPixel(200);

			// collect all the roles

			try {
				String pages = driver.findElement(By.cssSelector("strong")).getText();
				String[] arrOfStr = pages.split(" ");
				String pageno = arrOfStr[3];
				int pagecount = Integer.parseInt(pageno);

				for (int i = 0; i < pagecount; i++) {

					List<WebElement> roles = driver.findElements(By.xpath("//tr//div"));
					int rolesnum = roles.size();

					for (int j = 0; j < rolesnum; j++) {

						WebElement rolestext = roles.get(j);
						String getrole = rolestext.getText();

						if (getrole.equalsIgnoreCase("Contractor")) {

							// click on the Contractor role
							click("task_permission_roles_XPATH");

							break;
						}
					}

					// click on the next button
					click("task_permission_roles_nextbtn_CSS");

				}
			} catch (Throwable t) {
				successMessage("Successfully navigate to the Role Details screen.");
			}

			// scroll down the screen
			scrollByPixel(600);

			// click on the Allow Task Assignment to Roles field
			click("task_permission_rolelevel_role1_CSS");

			// click on the none button
			click("task_permission_securitysettings_nonebtn_CSS");

			// click on the Allow Task Assignment to Roles field
			click("task_permission_rolelevel_role1_CSS");

			// click on the Default User Task Assignees field
			click("task_permission_rolelevel_user2_CSS");

			// click on the none button
			click("task_permission_securitysettings_nonebtn_CSS");

			// click on the Default User Task Assignees field
			click("task_permission_rolelevel_user2_CSS");

			// click on the Default Role Task Assignees field
			click("task_permission_rolelevel_role3_CSS");

			// click on the none button
			click("task_permission_securitysettings_nonebtn_CSS");

			// click on the Default Role Task Assignees field
			click("task_permission_rolelevel_role3_CSS");

			// click on the Default Tags For Adhoc Task field
			click("task_permission_rolelevel_adhog4_CSS");

			// click on the none button
			click("task_permission_securitysettings_nonebtn_CSS");

			// click on the Default Tags For Adhoc Task field
			click("task_permission_rolelevel_adhog4_CSS");

			// click on the save role button
			click("task_permission_roles_saverolebtn_CSS");

		} catch (Throwable t) {
			verificationFailed();
		}

		// click on the home icon
		click("questionnaire_homeburgermenubtn_CSS");

		// wait for the element
		explicitWait("propertylist_title_XPATH");

		// verify the property list
		switchVerification("propertylist_title_XPATH", "Property List", "The property list is not displayed.");

	}

}