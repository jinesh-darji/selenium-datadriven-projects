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

		System.out.println(
				"THE \"ASSIGNED TO\" FIELD MUST FETCH THE DEFAULT USER LIST AS CONFIGURED IN SECURITY SETTINGS - MUNICIPAL ORDERS.");
		test.log(LogStatus.INFO,
				"THE \"ASSIGNED TO\" FIELD MUST FETCH THE DEFAULT USER LIST AS CONFIGURED IN SECURITY SETTINGS - MUNICIPAL ORDERS.");
		Reporter.log(
				"THE \"ASSIGNED TO\" FIELD MUST FETCH THE DEFAULT USER LIST AS CONFIGURED IN SECURITY SETTINGS - MUNICIPAL ORDERS.");
		log.info(
				"THE \"ASSIGNED TO\" FIELD MUST FETCH THE DEFAULT USER LIST AS CONFIGURED IN SECURITY SETTINGS - MUNICIPAL ORDERS.");

		Helper helper = new Helper();

		// refresh the page
		driver.navigate().refresh();
		Thread.sleep(5000);
		driver.navigate().refresh();

		System.out.println("Navigate to the Home Screen i.e. Property List Screen.");

		try {

			// wait for the element
			explicitWaitClickable("questionnaire_settingicon_userupdate_CSS");

			// click on the settings icon
			click("questionnaire_settingicon_userupdate_CSS");
			ngDriver.waitForAngularRequestsToFinish();
			System.out.println("Clicked on he settings icon.");

			// wait for the element
			explicitWaitClickable("questionnaire_administrationoption_XPATH");

			// click on the Administration option from the side menu
			click("questionnaire_administrationoption_XPATH");
			System.out.println("Clicked on the Administration option from the side menu.");
			ngDriver.waitForAngularRequestsToFinish();

			// click on the Security tab
			click("questionnaire_securitytab_XPATH");
			System.out.println("Clicked on the Security tab.");
			ngDriver.waitForAngularRequestsToFinish();

			// click on the Security Settings option
			click("ssc_securitytab_securitysettingsoption_XPATH");
			ngDriver.waitForAngularRequestsToFinish();
			System.out.println("Clicked on the Security Settings option.");

			// APPLY THE ACCESS OF DEFAULT PROPERTY PROJECT MUNICIPAL ORDERS TASK
			// ASSIGNEES

			helper.addPermissionOneUsersRoleTask(data, "search_ss", "propertyproject_mu_task_searchedss2_XPATH");

			// ADD SECURITY SETTINGS OF VIEW MUNICIPAL ORDERS TO USER/ROLE ACCESS

			System.out.println(
					"*************** ADD SECURITY SETTINGS OF VIEW MUNICIPAL ORDERS TO USER/ROLE ACCESS *************");
			test.log(LogStatus.INFO,
					"*************** ADD SECURITY SETTINGS OF VIEW MUNICIPAL ORDERS TO USER/ROLE ACCESS *************");
			Reporter.log(
					"*************** ADD SECURITY SETTINGS OF VIEW MUNICIPAL ORDERS TO USER/ROLE ACCESS *************");
			log.info(
					"*************** ADD SECURITY SETTINGS OF VIEW MUNICIPAL ORDERS TO USER/ROLE ACCESS *************");

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

			// enter security setting name in the search field
			clear("propertyproject_le_filtertxt_CSS");
			ngDriver.waitForAngularRequestsToFinish();
			System.out.println("Clear the search field.");
			type("propertyproject_le_filtertxt_CSS", data.get("security_setting_13"));
			ngDriver.waitForAngularRequestsToFinish();
			System.out.println("Entered security setting name in the search field.");

			// click on the searched result
			click("propertyproject_securitysettings13_XPATH");
			ngDriver.waitForAngularRequestsToFinish();
			System.out.println("Clicked on the searched result.");

			// click on the select role field
			click("propertyproject_securitysettings1_selectroles_CSS");
			ngDriver.waitForAngularRequestsToFinish();
			System.out.println("Clicked on the select role field.");

			// click on the none button
			click("propertyproject_securitysettings1_nonebtn_CSS");
			ngDriver.waitForAngularRequestsToFinish();
			System.out.println("Clicked on the none button.");

			// enter the name of the role in search field
			clear("propertyproject_securitysettings1_searchtxt_CSS");
			ngDriver.waitForAngularRequestsToFinish();
			System.out.println("Clear the search field.");
			type("propertyproject_securitysettings1_searchtxt_CSS", data.get("role_1"));
			ngDriver.waitForAngularRequestsToFinish();
			System.out.println("Entered the name of the role in search field.");

			// click on the searched result
			click("task_permission_securitysettings_seachedrole_XPATH");
			ngDriver.waitForAngularRequestsToFinish();
			System.out.println("Clicked on the searched result.");

			// enter the name of the role in search field
			clear("propertyproject_securitysettings1_searchtxt_CSS");
			ngDriver.waitForAngularRequestsToFinish();
			System.out.println("Clear the search field.");
			type("propertyproject_securitysettings1_searchtxt_CSS", data.get("role_2"));
			ngDriver.waitForAngularRequestsToFinish();
			System.out.println("Entered the name of the role in search field.");

			// click on the searched result
			click("task_permission_securitysettings_seachedrole2_XPATH");
			ngDriver.waitForAngularRequestsToFinish();
			System.out.println("Clicked on the searched result.");

			// click on the select role field
			click("propertyproject_securitysettings1_selectroles_CSS");
			ngDriver.waitForAngularRequestsToFinish();
			System.out.println("Clicked on the select role field.");

			// click on the select user field
			click("propertyproject_securitysettings1_selectusers_CSS");
			ngDriver.waitForAngularRequestsToFinish();
			System.out.println("Clicked on the select user field.");

			// click on the none button
			click("propertyproject_securitysettings1_nonebtn_CSS");
			ngDriver.waitForAngularRequestsToFinish();
			System.out.println("Clicked on the none button.");

			// enter the name of the user in search field
			clear("propertyproject_securitysettings1_searchtxt_CSS");
			ngDriver.waitForAngularRequestsToFinish();
			System.out.println("Clear the search field.");
			type("propertyproject_securitysettings1_searchtxt_CSS", data.get("user_1"));
			ngDriver.waitForAngularRequestsToFinish();
			System.out.println("Entered the name of the user in search field.");

			// click on the searched result
			click("task_permission_securitysettings_seacheduser_XPATH");
			ngDriver.waitForAngularRequestsToFinish();
			System.out.println("Clicked on the searched result.");

			// enter the name of the user in search field
			clear("propertyproject_securitysettings1_searchtxt_CSS");
			ngDriver.waitForAngularRequestsToFinish();
			System.out.println("Clear the search field.");
			type("propertyproject_securitysettings1_searchtxt_CSS", data.get("user_2"));
			ngDriver.waitForAngularRequestsToFinish();
			System.out.println("Entered the name of the user in search field.");

			// click on the searched result
			click("task_permission_securitysettings_seacheduser2_XPATH");
			ngDriver.waitForAngularRequestsToFinish();
			System.out.println("Clicked on the searched result.");

			// click on the select user field
			click("propertyproject_securitysettings1_selectusers_CSS");
			ngDriver.waitForAngularRequestsToFinish();
			System.out.println("Clicked on the select role field.");

			// click on the save button
			click("propertyproject_securitysettings1_savebtn_CSS");
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

		try {
			// click on the administration
			click("administration_XPATH");
			ngDriver.waitForAngularRequestsToFinish();
			System.out.println("Clicked on the administration.");

			// click on the Security tab
			click("questionnaire_securitytab_XPATH");
			System.out.println("Clicked on the Security tab.");
			ngDriver.waitForAngularRequestsToFinish();

			// click on the roles option
			click("ssc_securitytab_rolesoption_XPATH");
			ngDriver.waitForAngularRequestsToFinish();
			System.out.println("Clicked on the roles option.");

			// scroll down the screen
			JavascriptExecutor js = (JavascriptExecutor) driver;
			js.executeScript("window.scrollBy(0,200)");

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
							ngDriver.waitForAngularRequestsToFinish();
							System.out.println("Clicked on the Contractor role.");
							break;
						}
					}

					// click on the next button
					click("task_permission_roles_nextbtn_CSS");
					ngDriver.waitForAngularRequestsToFinish();
					System.out.println("Clicked on the next button.");

				}
			} catch (Throwable t) {
				System.out.println("Successfully navigate to the Role Details screen.");
				test.log(LogStatus.INFO, "Successfully navigate to the Role Details screen.");
				Reporter.log("Successfully navigate to the Role Details screen.");
				log.info("Successfully navigate to the Role Details screen.");
			}

			// scroll down the screen
			js.executeScript("window.scrollBy(0,600)");

			// click on the Allow Task Assignment to Roles field
			click("task_permission_rolelevel_role1_CSS");
			ngDriver.waitForAngularRequestsToFinish();
			System.out.println("Clicked on the Allow Task Assignment to Roles field.");

			// click on the none button
			click("task_permission_securitysettings_nonebtn_CSS");
			ngDriver.waitForAngularRequestsToFinish();
			System.out.println("Clicked on the none button.");

			// click on the Allow Task Assignment to Roles field
			click("task_permission_rolelevel_role1_CSS");
			ngDriver.waitForAngularRequestsToFinish();
			System.out.println("Clicked on the Allow Task Assignment to Roles field.");

			// click on the Default User Task Assignees field
			click("task_permission_rolelevel_user2_CSS");
			ngDriver.waitForAngularRequestsToFinish();
			System.out.println("Clicked on the Default User Task Assignees field.");

			// click on the none button
			click("task_permission_securitysettings_nonebtn_CSS");
			ngDriver.waitForAngularRequestsToFinish();
			System.out.println("Clicked on the none button.");

			// type the user name in the search field
			type("task_permission_securitysettings_searchtxt_CSS", data.get("user_rolelevel"));
			ngDriver.waitForAngularRequestsToFinish();
			System.out.println("Typed the user name in the search field.");

			// click on the searched result
			click("task_permission_rolelevel_searched1_XPATH");
			ngDriver.waitForAngularRequestsToFinish();
			System.out.println("Clicked on the searched result.");

			// click on the Default User Task Assignees field
			click("task_permission_rolelevel_user2_CSS");
			ngDriver.waitForAngularRequestsToFinish();
			System.out.println("Clicked on the Default User Task Assignees field.");

			// click on the Default Role Task Assignees field
			click("task_permission_rolelevel_role3_CSS");
			ngDriver.waitForAngularRequestsToFinish();
			System.out.println("Clicked on the Default Role Task Assignees field.");

			// click on the none button
			click("task_permission_securitysettings_nonebtn_CSS");
			ngDriver.waitForAngularRequestsToFinish();
			System.out.println("Clicked on the none button.");

			// type the role name in the search field
			type("task_permission_securitysettings_searchtxt_CSS", data.get("role_rolelevel"));
			ngDriver.waitForAngularRequestsToFinish();
			System.out.println("Typed the role name in the search field.");

			// click on the searched result
			click("task_permission_rolelevel_searched2_XPATH");
			ngDriver.waitForAngularRequestsToFinish();
			System.out.println("Clicked on the searched result.");

			// click on the Default Role Task Assignees field
			click("task_permission_rolelevel_role3_CSS");
			ngDriver.waitForAngularRequestsToFinish();
			System.out.println("Clicked on the Default Role Task Assignees field.");

			// click on the Default Tags For Task field
			click("task_permission_rolelevel_adhog4_CSS");
			ngDriver.waitForAngularRequestsToFinish();
			System.out.println("Clicked on the Default Tags For Task field.");

			// click on the none button
			click("task_permission_securitysettings_nonebtn_CSS");
			ngDriver.waitForAngularRequestsToFinish();
			System.out.println("Clicked on the none button.");

			// click on the Default Tags For Task field
			click("task_permission_rolelevel_adhog4_CSS");
			ngDriver.waitForAngularRequestsToFinish();
			System.out.println("Clicked on the Default Tags For Task field.");

			// click on the save role button
			click("task_permission_roles_saverolebtn_CSS");
			ngDriver.waitForAngularRequestsToFinish();
			System.out.println("Clicked on the save role button.");

			// scroll up the screen
			js.executeScript("window.scrollBy(0,-400)");

		} catch (Throwable t) {
			verificationFailed();
		}

		// click on the home icon
		click("questionnaire_homeburgermenubtn_CSS");
		ngDriver.waitForAngularRequestsToFinish();
		System.out.println("Clicked on the home icon.");

		// synchronization
		explicitWait("propertylist_title_XPATH");

		// verify the property list
		switchVerification("propertylist_title_XPATH", "Property List", "The property list is not displayed.");

		// VERIFY DEFAULT USERS / ROLES DISPLAYED IN THE ASSIGN TO FIELD - CAPEX
		// PROJECTS

		System.out.println(
				"**************** VERIFY DEFAULT USERS / ROLES DISPLAYED IN THE ASSIGN TO FIELD - MUNICIPAL ORDERS ****************");
		test.log(LogStatus.INFO,
				"**************** VERIFY DEFAULT USERS / ROLES DISPLAYED IN THE ASSIGN TO FIELD - MUNICIPAL ORDERS ****************");
		Reporter.log(
				"**************** VERIFY DEFAULT USERS / ROLES DISPLAYED IN THE ASSIGN TO FIELD - MUNICIPAL ORDERS ****************");
		log.info(
				"**************** VERIFY DEFAULT USERS / ROLES DISPLAYED IN THE ASSIGN TO FIELD - MUNICIPAL ORDERS ****************");

		try {
			// click on the property project icon from the property list page
			click("propertyproject_icon_CSS");
			System.out.println("Clicked on the property project icon of the Property.");
			ngDriver.waitForAngularRequestsToFinish();
			System.out.println("Navigate to the property project screen of the perticular property.");

			// wait for the element
			explicitWaitClickable("menubtn_CSS");

			// click on the burger menu
			click("menubtn_CSS");
			System.out.println("Clicked on the burger menu button successfully!!!");
			ngDriver.waitForAngularRequestsToFinish();

			// wait for the element
			Thread.sleep(5000);

			// click on the Municipal Orders
			click("propertyproject_municipalordersoption_XPATH");
			System.out.println("Clicked on the Municipal Orders option.");
			ngDriver.waitForAngularRequestsToFinish();

			// ADD RECORD - MUNICIPAL ORDERS

			// click on the add button
			click("propertyproject_mu_addbtn_CSS");
			System.out.println("Clicked on the Add button.");
			ngDriver.waitForAngularRequestsToFinish();
			System.out.println("Navigate to the Add Municipal Orders Screen");

			// enter the project reference
			type("propertyproject_mo_projectnumbertxt_CSS", data.get("project_reference"));
			System.out.println("Entered the project reference.");
			ngDriver.waitForAngularRequestsToFinish();

			// select the Municipality
			select("propertyproject_mo_municipalitydd_CSS", data.get("municipality"));
			ngDriver.waitForAngularRequestsToFinish();
			System.out.println("Selected the Municipality.");

			// click on the save button
			click("propertyproject_mo_savebtn_CSS");
			ngDriver.waitForAngularRequestsToFinish();
			System.out.println("Clicked on the save button.");

			// wait for the element
			explicitWaitClickable("closetoastmsg_CSS");

			// click on the toaster close button
			click("closetoastmsg_CSS");
			ngDriver.waitForAngularRequestsToFinish();
			System.out.println("Clicked on the toaster close button.");

			// wait for the element
			explicitWaitClickable("propertyproject_mu_newrepairbtn_BTNTEXT");

			// click on the new repair button
			click("propertyproject_mu_newrepairbtn_BTNTEXT");
			ngDriver.waitForAngularRequestsToFinish();
			System.out.println("Clicked on the new repair button.");

			// scroll down the screen
			JavascriptExecutor js = (JavascriptExecutor) driver;
			js.executeScript("window.scrollBy(0,800)");
			ngDriver.waitForAngularRequestsToFinish();
			System.out.println("Scroll down the screen.");

			// enter the title of the repair
			type("propertyproject_mu_repair_titletxt_CSS", data.get("task_title"));
			ngDriver.waitForAngularRequestsToFinish();
			System.out.println("Entered the title of the repair.");

			// enter the description
			type("propertyproject_mu_descriptiontxt_CSS", data.get("short_description"));
			ngDriver.waitForAngularRequestsToFinish();
			System.out.println("Entered the description.");

			// enter the unit number
			type("propertyproject_mu_unitenotxt_CSS", data.get("unit_number"));
			ngDriver.waitForAngularRequestsToFinish();
			System.out.println("Entered the unit number.");

			// verify the default user/role in assigned to field
			try {
				boolean str1 = driver.findElement(By.xpath("//span[text()='Jinesh QA']")).isDisplayed();
				boolean str2 = driver.findElement(By.xpath("//span[text()='Contractor']")).isDisplayed();

				System.out.println("The default user/role are: " + str1 + " " + str2);
				test.log(LogStatus.INFO, "The default user/role are: " + str1 + " " + str2);
				Reporter.log("The default user/role are: " + str1 + " " + str2);
				log.info("The default user/role are: " + str1 + " " + str2);

				if (str1 && str2) {
					System.out.println("The default user/role is displayed successfully.");
					test.log(LogStatus.INFO, "The default user/role is displayed successfully.");
					Reporter.log("The default user/role is displayed successfully.");
					log.info("The default user/role is displayed successfully.");
				} else {
					TestUtil.captureScreenshot();

					// ReportNG
					Reporter.log("<br>" + "The default user or role is not displayed : " + "<br>");
					Reporter.log("<a target=\"_blank\" href=" + TestUtil.screenshotName + "><img src="
							+ TestUtil.screenshotName + " height=200 width=200></img></a>");
					Reporter.log("<br>");
					Reporter.log("<br>");

					// Extent Report
					test.log(LogStatus.FAIL, " The default user or role is not displayed : ");
					test.log(LogStatus.FAIL, test.addScreenCapture(TestUtil.screenshotName));

					System.out.println("The default user or role is not displayed.");
					log.info("The default user or role is not displayed.");
				}

			} catch (Throwable t) {
				TestUtil.captureScreenshot();

				// ReportNG
				Reporter.log("<br>" + "The default user or role is not displayed : " + "<br>");
				Reporter.log("<a target=\"_blank\" href=" + TestUtil.screenshotName + "><img src="
						+ TestUtil.screenshotName + " height=200 width=200></img></a>");
				Reporter.log("<br>");
				Reporter.log("<br>");

				// Extent Report
				test.log(LogStatus.FAIL, " The default user or role is not displayed : ");
				test.log(LogStatus.FAIL, test.addScreenCapture(TestUtil.screenshotName));

				System.out.println("The default user or role is not displayed.");
				log.info("The default user or role is not displayed.");
			}

			// click on the back button
			click("propertyproject_mu_attachmenttab_backbtn_CSS");
			ngDriver.waitForAngularRequestsToFinish();
			System.out.println("Clicked on the back button.");

			// click on the cancel button
			click("propertyproject_mo_cancelbtn_CSS");
			ngDriver.waitForAngularRequestsToFinish();
			System.out.println("Clicked on the cancel button.");

			// click on the home icon from the top of the screen
			click("questionnaire_homeburgermenubtn_hide_CSS");
			System.out.println("Clicked on the home icon from the top of the screen.");
			ngDriver.waitForAngularRequestsToFinish();

			// synchronization
			explicitWait("propertylist_title_XPATH");

			// verify the property list
			switchVerification("propertylist_title_XPATH", "Property List", "The property list is not displayed.");

			// wait for the element
			explicitWaitClickable("questionnaire_settingicon_CSS");

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

			// VERIFY DEFAULT USERS / ROLES DISPLAYED IN THE ASSIGN TO FIELD - CAPEX
			// PROJECTS

			System.out.println(
					"**************** VERIFY DEFAULT USERS / ROLES DISPLAYED IN THE ASSIGN TO FIELD - MUNICIPAL ORDERS ****************");
			test.log(LogStatus.INFO,
					"**************** VERIFY DEFAULT USERS / ROLES DISPLAYED IN THE ASSIGN TO FIELD - MUNICIPAL ORDERS ****************");
			Reporter.log(
					"**************** VERIFY DEFAULT USERS / ROLES DISPLAYED IN THE ASSIGN TO FIELD - MUNICIPAL ORDERS ****************");
			log.info(
					"**************** VERIFY DEFAULT USERS / ROLES DISPLAYED IN THE ASSIGN TO FIELD - MUNICIPAL ORDERS ****************");

			System.out.println("**************** LOGIN IN JINESH QA ****************");
			test.log(LogStatus.INFO, "**************** LOGIN IN JINESH QA ****************");
			Reporter.log("**************** LOGIN IN JINESH QA ****************");
			log.info("**************** LOGIN IN JINESH QA ****************");

			helper.loginAndUpdateSystemCompany(data, "username", "password", "system_company_1");

			// click on the property project icon from the property list page
			click("propertyproject_icon_CSS");
			System.out.println("Clicked on the property project icon of the Property.");
			ngDriver.waitForAngularRequestsToFinish();
			System.out.println("Navigate to the property project screen of the perticular property.");

			// wait for the element
			explicitWaitClickable("menubtn_CSS");

			// click on the burger menu
			click("menubtn_CSS");
			System.out.println("Clicked on the burger menu button successfully!!!");
			ngDriver.waitForAngularRequestsToFinish();

			// wait for the element
			Thread.sleep(5000);

			// click on the Municipal Orders
			click("propertyproject_municipalordersoption_XPATH");
			System.out.println("Clicked on the Municipal Orders option.");
			ngDriver.waitForAngularRequestsToFinish();

			// ADD RECORD - MUNICIPAL ORDERS

			// click on the add button
			click("propertyproject_mu_addbtn_CSS");
			System.out.println("Clicked on the Add button.");
			ngDriver.waitForAngularRequestsToFinish();
			System.out.println("Navigate to the Add Municipal Orders Screen");

			// enter the project reference
			type("propertyproject_mo_projectnumbertxt_CSS", data.get("project_reference2"));
			System.out.println("Entered the project reference.");
			ngDriver.waitForAngularRequestsToFinish();

			// select the Municipality
			select("propertyproject_mo_municipalitydd_CSS", data.get("municipality"));
			ngDriver.waitForAngularRequestsToFinish();
			System.out.println("Selected the Municipality.");

			// click on the save button
			click("propertyproject_mo_savebtn_CSS");
			ngDriver.waitForAngularRequestsToFinish();
			System.out.println("Clicked on the save button.");

			// wait for the element
			Thread.sleep(5000);

			// click on the new repair button
			click("propertyproject_mu_newrepairbtn_BTNTEXT");
			ngDriver.waitForAngularRequestsToFinish();
			System.out.println("Clicked on the new repair button.");

			// scroll down the screen
			js.executeScript("window.scrollBy(0,800)");
			ngDriver.waitForAngularRequestsToFinish();
			System.out.println("Scroll down the screen.");

			// enter the title of the repair
			type("propertyproject_mu_repair_titletxt_CSS", data.get("task_title"));
			ngDriver.waitForAngularRequestsToFinish();
			System.out.println("Entered the title of the repair.");

			// enter the description
			type("propertyproject_mu_descriptiontxt_CSS", data.get("short_description"));
			ngDriver.waitForAngularRequestsToFinish();
			System.out.println("Entered the description.");

			// enter the unit number
			type("propertyproject_mu_unitenotxt_CSS", data.get("unit_number"));
			ngDriver.waitForAngularRequestsToFinish();
			System.out.println("Entered the unit number.");

			// verify the default user/role in assigned to field
			try {
				boolean str3 = driver.findElement(By.xpath("//span[text()='Jinesh QA']")).isDisplayed();
				boolean str4 = driver.findElement(By.xpath("//span[text()='Contractor']")).isDisplayed();

				System.out.println("The default user/role are: " + str3 + " " + str4);
				test.log(LogStatus.INFO, "The default user/role are: " + str3 + " " + str4);
				Reporter.log("The default user/role are: " + str3 + " " + str4);
				log.info("The default user/role are: " + str3 + " " + str4);

				if (str3 && str4) {
					System.out.println("The default user/role is displayed successfully.");
					test.log(LogStatus.INFO, "The default user/role is displayed successfully.");
					Reporter.log("The default user/role is displayed successfully.");
					log.info("The default user/role is displayed successfully.");
				} else {
					TestUtil.captureScreenshot();

					// ReportNG
					Reporter.log("<br>" + "The default user or role is not displayed : " + "<br>");
					Reporter.log("<a target=\"_blank\" href=" + TestUtil.screenshotName + "><img src="
							+ TestUtil.screenshotName + " height=200 width=200></img></a>");
					Reporter.log("<br>");
					Reporter.log("<br>");

					// Extent Report
					test.log(LogStatus.FAIL, " The default user or role is not displayed : ");
					test.log(LogStatus.FAIL, test.addScreenCapture(TestUtil.screenshotName));

					System.out.println("The default user or role is not displayed.");
					log.info("The default user or role is not displayed.");
				}

			} catch (Throwable t) {
				TestUtil.captureScreenshot();

				// ReportNG
				Reporter.log("<br>" + "The default user or role is not displayed : " + "<br>");
				Reporter.log("<a target=\"_blank\" href=" + TestUtil.screenshotName + "><img src="
						+ TestUtil.screenshotName + " height=200 width=200></img></a>");
				Reporter.log("<br>");
				Reporter.log("<br>");

				// Extent Report
				test.log(LogStatus.FAIL, " The default user or role is not displayed : ");
				test.log(LogStatus.FAIL, test.addScreenCapture(TestUtil.screenshotName));

				System.out.println("The default user or role is not displayed.");
				log.info("The default user or role is not displayed.");
			}

			// click on the back button
			click("propertyproject_mu_attachmenttab_backbtn_CSS");
			ngDriver.waitForAngularRequestsToFinish();
			System.out.println("Clicked on the back button.");

			// click on the cancel button
			click("propertyproject_mo_cancelbtn_CSS");
			ngDriver.waitForAngularRequestsToFinish();
			System.out.println("Clicked on the cancel button.");

			// click on the home icon from the top of the screen
			click("questionnaire_homeburgermenubtn_hide_CSS");
			System.out.println("Clicked on the home icon from the top of the screen.");
			ngDriver.waitForAngularRequestsToFinish();

			// synchronization
			explicitWait("propertylist_title_XPATH");

			// verify the property list
			switchVerification("propertylist_title_XPATH", "Property List", "The property list is not displayed.");

			// wait for the element
			explicitWaitClickable("questionnaire_settingicon_CSS");

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

			// VERIFY DEFAULT USERS / ROLES DISPLAYED IN THE ASSIGN TO FIELD - MORTGAGE
			// UNDERTAKING

			System.out.println(
					"**************** VERIFY DEFAULT USERS / ROLES DISPLAYED IN THE ASSIGN TO FIELD - MUNICIPAL ORDERS ****************");
			test.log(LogStatus.INFO,
					"**************** VERIFY DEFAULT USERS / ROLES DISPLAYED IN THE ASSIGN TO FIELD - MUNICIPAL ORDERS ****************");
			Reporter.log(
					"**************** VERIFY DEFAULT USERS / ROLES DISPLAYED IN THE ASSIGN TO FIELD - MUNICIPAL ORDERS ****************");
			log.info(
					"**************** VERIFY DEFAULT USERS / ROLES DISPLAYED IN THE ASSIGN TO FIELD - MUNICIPAL ORDERS ****************");

			System.out.println("**************** LOGIN IN JINESH CONTRACTOR ****************");
			test.log(LogStatus.INFO, "**************** LOGIN IN JINESH CONTRACTOR ****************");
			Reporter.log("**************** LOGIN IN JINESH CONTRACTOR ****************");
			log.info("**************** LOGIN IN JINESH CONTRACTOR ****************");

			helper.loginAndUpdateSystemCompany(data, "username_2", "password_2", "system_company_1");

			// click on the property project icon from the property list page
			click("propertyproject_icon_CSS");
			System.out.println("Clicked on the property project icon of the Property.");
			ngDriver.waitForAngularRequestsToFinish();
			System.out.println("Navigate to the property project screen of the perticular property.");

			// wait for the element
			explicitWaitClickable("menubtn_CSS");

			// click on the burger menu
			click("menubtn_CSS");
			System.out.println("Clicked on the burger menu button successfully!!!");
			ngDriver.waitForAngularRequestsToFinish();

			// wait for the element
			Thread.sleep(5000);

			// click on the Municipal Orders
			click("propertyproject_municipalordersoption_XPATH");
			System.out.println("Clicked on the Municipal Orders option.");
			ngDriver.waitForAngularRequestsToFinish();

			// ADD RECORD - MUNICIPAL ORDERS

			// click on the add button
			click("propertyproject_mu_addbtn_CSS");
			System.out.println("Clicked on the Add button.");
			ngDriver.waitForAngularRequestsToFinish();
			System.out.println("Navigate to the Add Municipal Orders Screen");

			// enter the project reference
			type("propertyproject_mo_projectnumbertxt_CSS", data.get("project_reference3"));
			System.out.println("Entered the project reference.");
			ngDriver.waitForAngularRequestsToFinish();

			// select the Municipality
			select("propertyproject_mo_municipalitydd_CSS", data.get("municipality"));
			ngDriver.waitForAngularRequestsToFinish();
			System.out.println("Selected the Municipality.");

			// click on the save button
			click("propertyproject_mo_savebtn_CSS");
			ngDriver.waitForAngularRequestsToFinish();
			System.out.println("Clicked on the save button.");

			// wait for the element
			Thread.sleep(5000);

			// click on the new repair button
			click("propertyproject_mu_newrepairbtn_BTNTEXT");
			ngDriver.waitForAngularRequestsToFinish();
			System.out.println("Clicked on the new repair button.");

			// scroll down the screen
			js.executeScript("window.scrollBy(0,800)");
			ngDriver.waitForAngularRequestsToFinish();
			System.out.println("Scroll down the screen.");

			// enter the title of the repair
			type("propertyproject_mu_repair_titletxt_CSS", data.get("task_title"));
			ngDriver.waitForAngularRequestsToFinish();
			System.out.println("Entered the title of the repair.");

			// enter the description
			type("propertyproject_mu_descriptiontxt_CSS", data.get("short_description"));
			ngDriver.waitForAngularRequestsToFinish();
			System.out.println("Entered the description.");

			// enter the unit number
			type("propertyproject_mu_unitenotxt_CSS", data.get("unit_number"));
			ngDriver.waitForAngularRequestsToFinish();
			System.out.println("Entered the unit number.");

			// verify the default user/role in assigned to field
			try {
				boolean str5 = driver.findElement(By.xpath("//span[text()='Jinesh QA']")).isDisplayed();
				boolean str6 = driver.findElement(By.xpath("//span[text()='Contractor']")).isDisplayed();
				boolean str7 = driver.findElement(By.xpath("//span[text()='Jinesh QA 2']")).isDisplayed();
				boolean str8 = driver.findElement(By.xpath("//span[text()='Human Resources']")).isDisplayed();

				System.out.println("The default user/role are: " + str5 + " " + str6 + " " + str7 + " " + str8);
				test.log(LogStatus.INFO, "The default user/role are: " + str5 + " " + str6 + " " + str7 + " " + str8);
				Reporter.log("The default user/role are: " + str5 + " " + str6 + " " + str7 + " " + str8);
				log.info("The default user/role are: " + str5 + " " + str6 + " " + str7 + " " + str8);

				if (str5 && str6 && str7 && str8) {
					System.out.println("The default user/role is displayed successfully.");
					test.log(LogStatus.INFO, "The default user/role is displayed successfully.");
					Reporter.log("The default user/role is displayed successfully.");
					log.info("The default user/role is displayed successfully.");
				} else {
					TestUtil.captureScreenshot();

					// ReportNG
					Reporter.log("<br>" + "The default user or role is not displayed : " + "<br>");
					Reporter.log("<a target=\"_blank\" href=" + TestUtil.screenshotName + "><img src="
							+ TestUtil.screenshotName + " height=200 width=200></img></a>");
					Reporter.log("<br>");
					Reporter.log("<br>");

					// Extent Report
					test.log(LogStatus.FAIL, " The default user or role is not displayed : ");
					test.log(LogStatus.FAIL, test.addScreenCapture(TestUtil.screenshotName));

					System.out.println("The default user or role is not displayed.");
					log.info("The default user or role is not displayed.");
				}

			} catch (Throwable t) {
				TestUtil.captureScreenshot();

				// ReportNG
				Reporter.log("<br>" + "The default user or role is not displayed : " + "<br>");
				Reporter.log("<a target=\"_blank\" href=" + TestUtil.screenshotName + "><img src="
						+ TestUtil.screenshotName + " height=200 width=200></img></a>");
				Reporter.log("<br>");
				Reporter.log("<br>");

				// Extent Report
				test.log(LogStatus.FAIL, " The default user or role is not displayed : ");
				test.log(LogStatus.FAIL, test.addScreenCapture(TestUtil.screenshotName));

				System.out.println("The default user or role is not displayed.");
				log.info("The default user or role is not displayed.");
			}

			// click on the back button
			click("propertyproject_mu_attachmenttab_backbtn_CSS");
			ngDriver.waitForAngularRequestsToFinish();
			System.out.println("Clicked on the back button.");

			// click on the cancel button
			click("propertyproject_mo_cancelbtn_CSS");
			ngDriver.waitForAngularRequestsToFinish();
			System.out.println("Clicked on the cancel button.");

			// click on the home icon from the top of the screen
			click("questionnaire_homeburgermenubtn_hide_CSS");
			System.out.println("Clicked on the home icon from the top of the screen.");
			ngDriver.waitForAngularRequestsToFinish();

			// synchronization
			explicitWait("propertylist_title_XPATH");

			// verify the property list
			switchVerification("propertylist_title_XPATH", "Property List", "The property list is not displayed.");

			// wait for the element
			explicitWaitClickable("questionnaire_settingicon_CSS");

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

			// DELETE THE CREATED MUNICIPAL ORDERS AND RESET THE GIVEN PERMISSIONS

			System.out.println(
					"**************** DELETE THE CREATED MUNICIPAL ORDERS AND RESET THE GIVEN PERMISSIONS ****************");
			test.log(LogStatus.INFO,
					"**************** DELETE THE CREATED MUNICIPAL ORDERS AND RESET THE GIVEN PERMISSIONS ****************");
			Reporter.log(
					"**************** DELETE THE CREATED MUNICIPAL ORDERS AND RESET THE GIVEN PERMISSIONS ****************");
			log.info(
					"**************** DELETE THE CREATED MUNICIPAL ORDERS AND RESET THE GIVEN PERMISSIONS ****************");

			System.out.println("**************** LOGIN IN AUTOMATION TESTER USER ****************");
			test.log(LogStatus.INFO, "**************** LOGIN IN AUTOMATION TESTER USER ****************");
			Reporter.log("**************** LOGIN IN AUTOMATION TESTER USER ****************");
			log.info("**************** LOGIN IN AUTOMATION TESTER USER ****************");

			helper.loginAndUpdateSystemCompany(data, "username_1", "password_1", "system_company_1");

		} catch (Throwable t) {
			helper.questionnaireNotDisplayLogout(data);
		}

		try {

			// DELETE THE MUNICIPAL ORDERSS

			System.out.println("**************** DELETE MUNICIPAL ORDERSS ****************");
			test.log(LogStatus.INFO, "**************** DELETE MUNICIPAL ORDERSS ****************");
			Reporter.log("**************** DELETE MUNICIPAL ORDERSS ****************");
			log.info("**************** DELETE MUNICIPAL ORDERSS ****************");

			// click on the property project icon from the property list page
			click("propertyproject_icon_CSS");
			System.out.println("Clicked on the property project icon of the Property.");
			ngDriver.waitForAngularRequestsToFinish();
			System.out.println("Navigate to the property project screen of the perticular property.");

			// wait for the element
			explicitWaitClickable("menubtn_CSS");

			// click on the burger menu
			click("menubtn_CSS");
			System.out.println("Clicked on the burger menu button successfully!!!");
			ngDriver.waitForAngularRequestsToFinish();

			// wait for the element
			Thread.sleep(5000);

			// click on the Municipal Orders
			click("propertyproject_municipalordersoption_XPATH");
			System.out.println("Clicked on the Municipal Orders option.");
			ngDriver.waitForAngularRequestsToFinish();

			// click on the delete button of the newly created MUNICIPAL ORDERSs
			List<WebElement> links4 = driver.findElements(By.xpath("//tr"));
			int count4 = links4.size();
			System.out.println("Number of links are:" + count4);

			for (int i = 0; i < count4 - 1; i++) {

				// wait for the element
				explicitWaitClickable("propertyproject_mo_deletebtn_CSS");

				// delete the all the MUNICIPAL ORDERSs
				click("propertyproject_mo_deletebtn_CSS");
				System.out.println("Deleted the all the MUNICIPAL ORDERSs");
				ngDriver.waitForAngularRequestsToFinish();

				// wait for the element
				explicitWaitClickable("propertyproject_mo_confirmationdeletebtn_CSS");

				// click on the delete button of confirmation
				click("propertyproject_mo_confirmationdeletebtn_CSS");
				System.out.println("Clicked on the delete button of confirmation.");
				ngDriver.waitForAngularRequestsToFinish();

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

		// wait for the element
		explicitWait("propertylist_title_XPATH");

		// verify the property list
		switchVerification("propertylist_title_XPATH", "Property List", "The property list is not displayed.");

		System.out.println("**************** RESET THE APPLIED PERMISSIONS ****************");
		test.log(LogStatus.INFO, "**************** RESET THE APPLIED PERMISSIONS ****************");
		Reporter.log("**************** RESET THE APPLIED PERMISSIONS ****************");
		log.info("**************** RESET THE APPLIED PERMISSIONS ****************");

		// wait for the element
		explicitWaitClickable("questionnaire_settingicon_CSS");

		try {
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

			// click on the security tab
			click("questionnaire_securitytab_XPATH");
			System.out.println("Clicked on the security tab.");
			ngDriver.waitForAngularRequestsToFinish();

			// click on the security settings option
			click("questionnaire_securotysettingsoption_XPATH");
			System.out.println("Clicked on the security settings option.");
			ngDriver.waitForAngularRequestsToFinish();

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
			ngDriver.waitForAngularRequestsToFinish();
			System.out.println("Clicked on the administration.");

			// click on the Security tab
			click("questionnaire_securitytab_XPATH");
			System.out.println("Clicked on the Security tab.");
			ngDriver.waitForAngularRequestsToFinish();

			// click on the roles option
			click("ssc_securitytab_rolesoption_XPATH");
			ngDriver.waitForAngularRequestsToFinish();
			System.out.println("Clicked on the roles option.");

			// scroll down the screen
			JavascriptExecutor js = (JavascriptExecutor) driver;
			js.executeScript("window.scrollBy(0,200)");

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
							ngDriver.waitForAngularRequestsToFinish();
							System.out.println("Clicked on the Contractor role.");
							break;
						}
					}

					// click on the next button
					click("task_permission_roles_nextbtn_CSS");
					ngDriver.waitForAngularRequestsToFinish();
					System.out.println("Clicked on the next button.");

				}
			} catch (Throwable t) {
				System.out.println("Successfully navigate to the Role Details screen.");
				test.log(LogStatus.INFO, "Successfully navigate to the Role Details screen.");
				Reporter.log("Successfully navigate to the Role Details screen.");
				log.info("Successfully navigate to the Role Details screen.");
			}

			// scroll down the screen
			js.executeScript("window.scrollBy(0,600)");

			// click on the Allow Task Assignment to Roles field
			click("task_permission_rolelevel_role1_CSS");
			ngDriver.waitForAngularRequestsToFinish();
			System.out.println("Clicked on the Allow Task Assignment to Roles field.");

			// click on the none button
			click("task_permission_securitysettings_nonebtn_CSS");
			ngDriver.waitForAngularRequestsToFinish();
			System.out.println("Clicked on the none button.");

			// click on the Allow Task Assignment to Roles field
			click("task_permission_rolelevel_role1_CSS");
			ngDriver.waitForAngularRequestsToFinish();
			System.out.println("Clicked on the Allow Task Assignment to Roles field.");

			// click on the Default User Task Assignees field
			click("task_permission_rolelevel_user2_CSS");
			ngDriver.waitForAngularRequestsToFinish();
			System.out.println("Clicked on the Default User Task Assignees field.");

			// click on the none button
			click("task_permission_securitysettings_nonebtn_CSS");
			ngDriver.waitForAngularRequestsToFinish();
			System.out.println("Clicked on the none button.");

			// click on the Default User Task Assignees field
			click("task_permission_rolelevel_user2_CSS");
			ngDriver.waitForAngularRequestsToFinish();
			System.out.println("Clicked on the Default User Task Assignees field.");

			// click on the Default Role Task Assignees field
			click("task_permission_rolelevel_role3_CSS");
			ngDriver.waitForAngularRequestsToFinish();
			System.out.println("Clicked on the Default Role Task Assignees field.");

			// click on the none button
			click("task_permission_securitysettings_nonebtn_CSS");
			ngDriver.waitForAngularRequestsToFinish();
			System.out.println("Clicked on the none button.");

			// click on the Default Role Task Assignees field
			click("task_permission_rolelevel_role3_CSS");
			ngDriver.waitForAngularRequestsToFinish();
			System.out.println("Clicked on the Default Role Task Assignees field.");

			// click on the Default Tags For Adhoc Task field
			click("task_permission_rolelevel_adhog4_CSS");
			ngDriver.waitForAngularRequestsToFinish();
			System.out.println("Clicked on the Default Tags For Adhoc Task field.");

			// click on the none button
			click("task_permission_securitysettings_nonebtn_CSS");
			ngDriver.waitForAngularRequestsToFinish();
			System.out.println("Clicked on the none button.");

			// click on the Default Tags For Adhoc Task field
			click("task_permission_rolelevel_adhog4_CSS");
			ngDriver.waitForAngularRequestsToFinish();
			System.out.println("Clicked on the Default Tags For Adhoc Task field.");

			// click on the save role button
			click("task_permission_roles_saverolebtn_CSS");
			ngDriver.waitForAngularRequestsToFinish();
			System.out.println("Clicked on the save role button.");

		} catch (Throwable t) {

			verificationFailed();
		}

		// click on the home icon
		click("questionnaire_homeburgermenubtn_CSS");
		ngDriver.waitForAngularRequestsToFinish();
		System.out.println("Clicked on the home icon.");

		// wait for the element
		explicitWait("propertylist_title_XPATH");

		// verify the property list
		switchVerification("propertylist_title_XPATH", "Property List", "The property list is not displayed.");

	}

}