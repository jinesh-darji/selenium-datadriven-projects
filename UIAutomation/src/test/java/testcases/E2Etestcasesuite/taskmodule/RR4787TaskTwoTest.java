package testcases.E2Etestcasesuite.taskmodule;

import java.io.IOException;
import java.util.Hashtable;
import java.util.List;

import org.apache.commons.lang3.RandomStringUtils;
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

public class RR4787TaskTwoTest extends TestBase {

	@Test(dataProviderClass = TestUtil.class, dataProvider = "dp")
	public void rR4787TaskTwoTest(Hashtable<String, String> data) throws IOException, InterruptedException {

		execution(data, "rR4787TaskTwoTest");

		// CREATE TASK > WITH A TASK TYPE > ADD DEFAULT TASK ASSIGNEE + ADD ROLES/USERS
		// FROM TASK TYPE > 1. CANNOT REMOVE ROLES/USERS MARKED TO BE PRESERVED 2. CAN
		// ADD NEW USER/ROLES 3. CAN REMOVE OTHER TASK ASSIGNEES.
		title("CREATE TASK > WITH A TASK TYPE > ADD DEFAULT TASK ASSIGNEE + ADD ROLES/USERS FROM TASK TYPE > 1. CANNOT REMOVE ROLES/USERS MARKED TO BE PRESERVED 2. CAN ADD NEW USER/ROLES 3. CAN REMOVE OTHER TASK ASSIGNEES.");

		Helper helper = new Helper();

		// refresh the page
		driver.navigate().refresh();
		Thread.sleep(5000);
		driver.navigate().refresh();

		// SET DEFAULT USERS AND ROLES IN THE SECURITY SETTINGS AND ROLE LEVEL
		title("SET DEFAULT USERS AND ROLES IN THE SECURITY SETTINGS AND ROLE LEVEL");

		try {
			// wait for element
			explicitWaitClickable("questionnaire_settingicon_userupdate_CSS");

			// click on the settings icon
			click("questionnaire_settingicon_userupdate_CSS");

			// wait for element
			explicitWaitClickable("questionnaire_administrationoption_XPATH");

			// click on the Administration option from the side menu
			click("questionnaire_administrationoption_XPATH");

			// click on the Security tab
			click("questionnaire_securitytab_XPATH");

			// click on the Security Settings option
			click("ssc_securitytab_securitysettingsoption_XPATH");

			// enter Default General Task Assignees text in search field
			type("task_permission_securitysettings_searchtxt1_CSS", data.get("search_ss"));

			// click on the searched result
			driver.findElement(By.xpath("//span[text()='Default general task assignee ']")).click();

			// click on the role field
			click("task_permission_securitysettings_roletxt_CSS");

			// click on the none button
			click("task_permission_securitysettings_nonebtn_CSS");

			// enter the role in the search field
			type("task_permission_securitysettings_searchtxt_CSS", data.get("role_ss"));

			// click on the searched result
			click("task_permission_securitysettings_seachedrole_XPATH");

			// click on the role field
			click("task_permission_securitysettings_roletxt_CSS");

			// click on the user field
			click("task_permission_securitysettings_usertxt_CSS");

			// click on the none button
			click("task_permission_securitysettings_nonebtn_CSS");

			// enter the role in the search field
			type("task_permission_securitysettings_searchtxt_CSS", data.get("user_ss"));

			// click on the searched result
			click("task_permission_securitysettings_seacheduser_XPATH");

			// click on the role field
			click("task_permission_securitysettings_usertxt_CSS");

			// click on the save button
			click("securitysettings_accesssurveychecklist_CSS");

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

		// synchronization
		explicitWait("propertylist_title_XPATH");

		// verify the property list
		switchVerification("propertylist_title_XPATH", "Property List", "The property list is not displayed.");

		// ADD NEW TASK TYPE - WITH PRESERVE
		title("ADD NEW TASK TYPE - WITH PRESERVE");

		try {

			// wait for the element
			Thread.sleep(7000);

			// click on the side menu button
			click("menubtn_CSS");

			// wait for the element
			Thread.sleep(7000);

			// click on the task option
			click("sidemenu_task_CSS");

			// verify dashboard drop down is displayed or not
			switchVerification("ssc_sustainability_dashboardtxt_XPATH", "Dashboard",
					"The Dashboard Drop down is not displayed.");

			// synchronization
			explicitWaitClickable("task_permission_tasktype_dashboarddd_CSS");

			// select the task type from the dashboard drop down
			select("task_permission_tasktype_dashboarddd_CSS", data.get("dashboard_tasktype"));

			// wait for the element
			explicitWaitClickable("task_permission_tasktype_addbtn_CSS");

			// click on the add button
			click("task_permission_tasktype_addbtn_CSS");

			// enter the task type
			type("task_permission_tasktype_tasktypetxt_CSS", data.get("task_title"));

			// scroll down the screen
			scrollByPixel(500);

			// click on the assign to field
			click("task_permission_tasktype_assigntotxt_CSS");

			// click on the none button
			click("task_tasktag_nonebtn_CSS");

			// enter the user name in the search field
			type("task_tasktag_searchtxt_CSS", data.get("task_type_user"));

			// click on the searched user
			click("task_permission_tasktype_searcheduser_XPATH");

			// enter the role in the search field
			type("task_tasktag_searchtxt_CSS", data.get("task_type_role"));

			// click on the searched role
			click("task_permission_tasktype_searchedrole_XPATH");

			// click on the assign to field
			click("task_permission_tasktype_assigntotxt_CSS");

			// select the prevent user/role checklist
			boolean preventckb = driver.findElement(By.cssSelector("input[name='preserveUserAndRoles']")).isSelected();

			if (preventckb != true) {

				// click on the prevent user/role checkbox
				click("task_permission_tasktype_preventckb_CSS");

			} else {

				successMessage("The prevent user/role  checkbox is displayed already selected.");
			}

			// select the value from the recurrence type drop down
			select("task_permission_tasktype_recurrencetypedd_CSS", data.get("recurrence_type"));

			// select the value from the module drop down
			select("task_permission_tasktype_moduledd_CSS", data.get("task_module"));

			// wait for the element
			Thread.sleep(5000);

			// click on the save button
			click("task_permission_tasktype_savebtn_CSS");

			// enter the newly created task type
			type("users_filtertxt_CSS", data.get("task_title"));

			// verify newly created task type is displayed or not
			switchVerification("task_permission_addedtasktype1_XPATH", "Automation Permission 4 Task Type",
					"The Automation Permission 4 Task Type is not displayed.");

		} catch (Throwable t) {
			verificationFailed();
		}

		// click on the home icon
		click("questionnaire_homeburgermenubtn_hide_CSS");

		// synchronization
		explicitWait("propertylist_title_XPATH");

		// verify the property list
		switchVerification("propertylist_title_XPATH", "Property List", "The property list is not displayed.");

		// ADD NEW TASK TYPE - WITH PRESERVE - ROLELEVEL
		title("ADD NEW TASK TYPE - WITH PRESERVE - ROLELEVEL");

		try {

			// wait for the element
			Thread.sleep(5000);

			// click on the side menu button
			click("menubtn_CSS");

			// wait for the element
			Thread.sleep(5000);

			// click on the task option
			click("sidemenu_task_CSS");

			// verify dashboard drop down is displayed or not
			switchVerification("ssc_sustainability_dashboardtxt_XPATH", "Dashboard",
					"The Dashboard Drop down is not displayed.");

			// synchronization
			explicitWaitClickable("task_permission_tasktype_dashboarddd_CSS");

			// select the task type from the dashboard drop down
			select("task_permission_tasktype_dashboarddd_CSS", data.get("dashboard_tasktype"));

			// wait for the element
			explicitWaitClickable("task_permission_tasktype_addbtn_CSS");

			// click on the add button
			click("task_permission_tasktype_addbtn_CSS");

			// enter the task type
			type("task_permission_tasktype_tasktypetxt_CSS", data.get("task_title_rolelevel"));

			// scroll down the screen
			scrollByPixel(500);

			// click on the assign to field
			click("task_permission_tasktype_assigntotxt_CSS");

			// click on the none button
			click("task_tasktag_nonebtn_CSS");

			// enter the user name in the search field
			type("task_tasktag_searchtxt_CSS", data.get("task_type_user"));

			// click on the searched user
			click("task_permission_tasktype_searcheduser_XPATH");

			// enter the role in the search field
			type("task_tasktag_searchtxt_CSS", data.get("task_type_role"));

			// click on the searched role
			click("task_permission_tasktype_searchedrole_XPATH");

			// click on the assign to field
			click("task_permission_tasktype_assigntotxt_CSS");

			// select the prevent user/role checklist
			boolean preventckb = driver.findElement(By.cssSelector("input[name='preserveUserAndRoles']")).isSelected();

			if (preventckb != true) {

				// click on the prevent user/role checkbox
				click("task_permission_tasktype_preventckb_CSS");
			} else {
				successMessage("The prevent user/role  checkbox is displayed already selected.");
			}

			// select the value from the recurrence type drop down
			select("task_permission_tasktype_recurrencetypedd_CSS", data.get("recurrence_type"));

			// select the value from the module drop down
			select("task_permission_tasktype_moduledd_CSS", data.get("task_module"));

			// wait for the element
			Thread.sleep(5000);

			// click on the save button
			click("task_permission_tasktype_savebtn_CSS");

			// enter the newly created task type
			type("users_filtertxt_CSS", data.get("task_title_rolelevel"));

			// verify newly created task type is displayed or not
			switchVerification("task_permission_addedtasktype1_rolelevel_XPATH",
					"Automation Permission 4 Task Type Rolelevel",
					"The Automation Permission 4 Task Type Rolelevel is not displayed.");

		} catch (Throwable t) {
			verificationFailed();
		}

		// click on the home icon
		click("questionnaire_homeburgermenubtn_hide_CSS");

		// synchronization
		explicitWait("propertylist_title_XPATH");

		// verify the property list
		switchVerification("propertylist_title_XPATH", "Property List", "The property list is not displayed.");

		// SECURITY SETTINGS LEVEL VERIFICATION
		title("SECURITY SETTINGS LEVEL VERIFICATION");

		try {
			// click on the task icon
			click("taskicon_CSS");

			// click on the add task button
			click("task_addtaskbtn_CSS");

			// verify the default user/role in assigned to field
			try {
				boolean str1 = driver.findElement(By.xpath("(//span[text()='Jinesh QA'])[1]")).isDisplayed();
				boolean str2 = driver.findElement(By.xpath("(//span[text()='Contractor'])[1]")).isDisplayed();

				if ((str1 && str2) == true) {
					successMessage("The default user/role is displayed successfully.");
				} else {
					verificationFailedMessage("The default user or role is not displayed");
				}

			} catch (Throwable t) {
				verificationFailedMessage("The default user or role is not displayed");
			}

			// click on the task type field
			click("task_permission_task_tasktypetxt_CSS");

			// enter the newly created task type
			type("task_tasktag_searchtxt_CSS", data.get("task_title"));

			// click on the searched task type
			click("task_permission_task_createdtasktype_XPATH");

			// verify the default user/role, and preserved user/role in
			// assigned to field
			try {
				boolean str3 = driver.findElement(By.xpath("(//span[text()='Jinesh QA'])[1]")).isDisplayed();
				boolean str4 = driver.findElement(By.xpath("(//span[text()='Contractor'])[1]")).isDisplayed();
				boolean str5 = driver.findElement(By.xpath("(//span[text()='Jinesh Misc'])[1]")).isDisplayed();
				boolean str6 = driver.findElement(By.xpath("(//span[text()='Operations'])[1]")).isDisplayed();

				if ((str3 && str4 && str5 && str6) == true) {
					successMessage("The default user/role, and preserved user/role are displayed successfully.");
				} else {
					verificationFailedMessage("The default user/role, and preserved user/role is not displayed");
				}

			} catch (Throwable t) {
				verificationFailedMessage("The default user/role, and preserved user/role is not displayed");
			}

			// ADD THE USER IN THE ASSIGN TO FIELD
			title("ADD THE USER IN THE ASSIGN TO FIELD");

			// click on the assign to field
			click("task_assigntotxt_CSS");

			// enter the user name in the search field
			type("workflowsecurity_editortask_taskdetails_searchtasktagtxt_CSS", data.get("search_user"));

			// click on the searched result
			click("task_permission_task_selectusertxt_XPATH");

			// click on the assign to field
			click("task_assigntotxt_CSS");

			// verify the default user/role, updated user and preserved user/role in
			// assigned to field
			try {
				boolean str7 = driver.findElement(By.xpath("(//span[text()='Jinesh QA'])[1]")).isDisplayed();
				boolean str8 = driver.findElement(By.xpath("(//span[text()='Contractor'])[1]")).isDisplayed();
				boolean str9 = driver.findElement(By.xpath("(//span[text()='Jinesh Misc'])[1]")).isDisplayed();
				boolean str10 = driver.findElement(By.xpath("(//span[text()='Operations'])[1]")).isDisplayed();
				boolean str11 = driver.findElement(By.xpath("(//span[text()='Jinesh'])[1]")).isDisplayed();

				if ((str7 && str8 && str9 && str10 && str11) == true) {
					successMessage(
							"The default user/role, updated user and preserved user/role are displayed successfully.");
				} else {
					verificationFailedMessage(
							"The default user/role, updated user and preserved user/role is not displayed");
				}

			} catch (Throwable t) {
				verificationFailedMessage(
						"The default user/role, updated user and preserved user/role is not displayed");
			}

			// UNSELECT THE PRESERVED USER/ROLE
			title("UNSELECT THE PRESERVED USER/ROLE");

			// click on the assigned to field
			click("task_assigntotxt_CSS");

			// enter the user name in the search field
			type("workflowsecurity_editortask_taskdetails_searchtasktagtxt_CSS", data.get("task_type_user"));

			// click on the searched result
			click("task_permission_tasktype_searcheduser_XPATH");

			// click on the assign to field
			click("task_assigntotxt_CSS");

			// wait for the 5 seconds
			Thread.sleep(5000);

			// click on the save button
			click("survey_task_savebtn_CSS");

			// wait for the 5 seconds
			Thread.sleep(5000);

			// click on the clear button
			click("task_createdtask_clearbtn_XPATH");

			// enter the data in the search field
			type("task_filter_CSS", data.get("task_title"));

			// click on the search button
			click("task_createdtask_searchbtn_XPATH");

			// verify preserved user/role is displayed or not
			try {
				boolean str12 = driver
						.findElement(By.xpath("//p[text()='" + data.get("task_title")
								+ "']//parent::td//following-sibling::td[contains(text(),'Jinesh Misc')]"))
						.isDisplayed();

				if (str12 == true) {
					successMessage("The preserved user/role is displayed successfully.");

				} else {
					verificationFailedMessage("The preserved user/role is not displayed.");
				}

			} catch (Throwable t) {
				verificationFailedMessage("The preserved user/role is not displayed.");
			}

			// click on the newly created task
			driver.findElement(By.xpath("//p[contains(text(),'Automation Permission 4 Task Type')]")).click();

			// click on the assign to field
			click("task_assigntotxt_CSS");

			// enter the role in the search field
			type("workflowsecurity_editortask_taskdetails_searchtasktagtxt_CSS", data.get("task_type_role"));

			// click on the searched result
			click("task_permission_tasktype_searchedrole_XPATH");

			// click on the assign to field
			click("task_assigntotxt_CSS");

			// wait for the element
			Thread.sleep(5000);

			// click on the update button
			click("survey_task_updatebtn_CSS");

			// wait for the element
			explicitWaitClickable("closetoastmsg_CSS");

			// click on the toaster close button
			click("closetoastmsg_CSS");

			// wait for the element
			Thread.sleep(5000);

			// verify preserved user/role is displayed or not
			try {
				boolean str13 = driver.findElement(By.xpath(
						"//p[text()='Automation Permission 4 Task Type']//parent::td//following-sibling::td[contains(text(),'Operations')]"))
						.isDisplayed();

				if (str13 == true) {
					successMessage("The preserved user/role is displayed successfully.");
				} else {

					verificationFailedMessage("The preserved user/role is not displayed");
				}

			} catch (Throwable t) {
				verificationFailedMessage("The preserved user/role is not displayed");
			}

			// UPDATE THE TASK
			title("UPDATE THE TASK");

			// click on the newly created task
			driver.findElement(By.xpath("//p[contains(text(),'Automation Permission 4 Task Type')]")).click();

			// verify the default user/role and preserved user/role in assigned to
			// field
			try {
				boolean str14 = driver.findElement(By.xpath("(//span[text()='Jinesh QA'])[1]")).isDisplayed();
				boolean str15 = driver.findElement(By.xpath("(//span[text()='Contractor'])[1]")).isDisplayed();
				boolean str16 = driver.findElement(By.xpath("(//span[text()='Jinesh Misc'])[1]")).isDisplayed();
				boolean str17 = driver.findElement(By.xpath("(//span[text()='Operations'])[1]")).isDisplayed();
				boolean str18 = driver.findElement(By.xpath("(//span[text()='Jinesh'])[1]")).isDisplayed();

				System.out.println(str14 + " " + str15 + " " + str16 + " " + str17 + " " + str18);

				if ((str14 && str15 && str16 && str17 && str18) == true) {
					successMessage("The default user/role and preserved user/role is displayed successfully.");
				} else {
					verificationFailedMessage("The default user or role is not displayed");
				}

			} catch (Throwable t) {
				verificationFailedMessage("The default user or role is not displayed");
			}

			// click on the assign to field
			click("task_assigntotxt_CSS");

			// enter the user name in the search field
			type("workflowsecurity_editortask_taskdetails_searchtasktagtxt_CSS", data.get("search_user_update"));

			// click on the searched result
			click("task_permission_task_updateselectusertxt_XPATH");

			// wait for the element
			Thread.sleep(3000);

			// click on the assign to field
			click("task_assigntotxt_CSS");

			// verify the default user/role, newly added users and preserved user/role in
			// assigned to field
			try {
				boolean str19 = driver.findElement(By.xpath("(//span[text()='Jinesh QA'])[1]")).isDisplayed();
				boolean str20 = driver.findElement(By.xpath("(//span[text()='Contractor'])[1]")).isDisplayed();
				boolean str21 = driver.findElement(By.xpath("(//span[text()='Jinesh Misc'])[1]")).isDisplayed();
				boolean str22 = driver.findElement(By.xpath("(//span[text()='Operations'])[1]")).isDisplayed();
				boolean str23 = driver.findElement(By.xpath("(//span[text()='Jinesh'])[1]")).isDisplayed();
				boolean str24 = driver.findElement(By.xpath("(//span[text()='Jinesh Sample One'])[1]")).isDisplayed();

				System.out.println(str19 + " " + str20 + " " + str21 + " " + str22 + " " + str23 + " " + str24);

				if ((str19 && str20 && str21 && str22 && str23 && str24) == true) {
					successMessage(
							"The default user/role, newly added users and preserved user/role is displayed successfully.");
				} else {
					verificationFailedMessage(
							"The default user/role, newly added users and preserved user/rolee is not displayed");
				}

			} catch (Throwable t) {
				verificationFailedMessage(
						"The default user/role, newly added users and preserved user/rolee is not displayed");
			}

			// click on the update button
			click("survey_task_updatebtn_CSS");

			// wait for the element
			explicitWaitClickable("closetoastmsg_CSS");

			// click on the toaster close button
			click("closetoastmsg_CSS");

			// UNSELECT THE DEFAULT ADDED USER/ROLE AND NEWLY ADDED USER
			title("UNSELECT THE DEFAULT ADDED USER/ROLE AND NEWLY ADDED USER");

			// scroll up the screen
			scrollByPixel(-500);

			// click on the clear button
			click("task_createdtask_clearbtn_XPATH");

			// enter the data in the search field
			type("task_filter_CSS", data.get("task_title"));

			// click on the search button
			click("task_createdtask_searchbtn_XPATH");

			// click on the newly created task
			click("task_permission_addedtasktype_XPATH");

			// click on the assign to field
			click("task_assigntotxt_CSS");

			// enter the user name in the search field
			type("workflowsecurity_editortask_taskdetails_searchtasktagtxt_CSS", data.get("search_user"));

			// click on the searched result
			click("task_permission_task_selectusertxt_XPATH");

			// click on the assign to field
			click("task_assigntotxt_CSS");

			// enter the default role in the search field
			type("workflowsecurity_editortask_taskdetails_searchtasktagtxt_CSS", data.get("role_ss"));

			// click on the searched result
			click("task_permission_task_defaultrole_XPATH");

			// click on the assign to field
			click("task_assigntotxt_CSS");

			// enter the default user in the search field
			type("workflowsecurity_editortask_taskdetails_searchtasktagtxt_CSS", data.get("user_ss"));

			// click on the searched result
			click("task_permission_task_defaultuser_XPATH");

			// click on the update button
			click("survey_task_updatebtn_CSS");

			// wait for the element
			explicitWaitClickable("closetoastmsg_CSS");

			// click on the toaster close button
			click("closetoastmsg_CSS");

			// scroll up the screen
			scrollByPixel(-500);

			// click on the clear button
			click("task_createdtask_clearbtn_XPATH");

			// enter the data in the search field
			type("task_filter_CSS", data.get("task_title"));

			// click on the search button
			click("task_createdtask_searchbtn_XPATH");

			// click on the updated task
			click("task_permission_addedtasktype_XPATH");

			// verify the preserved user/role and updated user in assigned to field
			try {
				boolean str27 = driver.findElement(By.xpath("(//span[text()='Jinesh Misc'])[1]")).isDisplayed();
				boolean str28 = driver.findElement(By.xpath("(//span[text()='Operations'])[1]")).isDisplayed();
				boolean str29 = driver.findElement(By.xpath("(//span[text()='Jinesh Sample One'])[1]")).isDisplayed();

				if ((str27 && str28 && str29) == true) {
					successMessage("The preserved user/role and updated user is displayed successfully.");
				} else {
					verificationFailedMessage("The preserved user/role and updated user is not displayed");
				}

			} catch (Throwable t) {
				verificationFailedMessage("The preserved user/role and updated user is not displayed");
			}

			// click on the update button
			click("survey_task_updatebtn_CSS");

			// wait for the element
			explicitWaitClickable("closetoastmsg_CSS");

			// click on the toaster close button
			click("closetoastmsg_CSS");

			// click on the back button
			driver.findElement(By.xpath("//button[@ng-click='cancelTaskInput(false); resetTaskInputDetails();']"))
					.click();

		} catch (Throwable t) {
			verificationFailed();
		}

		// DELETE THE TASK
		title("DELETE THE TASK");

		try {

			// click on the updated task
			click("task_permission_addedtasktype_XPATH");

			// wait for element
			explicitWaitClickable("task_deletedtaskbtn_CSS");

			// click on the delete button
			click("task_deletedtaskbtn_CSS");

			// wait for element
			explicitWaitClickable("task_deletedtaskbtn_confirmaiton_CSS");

			// click on the delete button of the confirmation popup
			click("task_deletedtaskbtn_confirmaiton_CSS");

			// scroll up the screen
			scrollByPixel(-500);

			// click on the clear button
			click("task_createdtask_clearbtn_XPATH");

			// enter the data in the search field
			type("task_filter_CSS", data.get("task_title"));

			// click on the search button
			click("task_createdtask_searchbtn_XPATH");

			// verify the task deleted or not
			try {

				String deleteElement = (driver
						.findElement(By.xpath("//p[contains(text(),'Automation Permission 4 Task Type')]")).getText())
						.trim();

				if (deleteElement.equals("Automation Permission 4 Task Type")) {
					verificationFailedMessage("The  Automation Permission 4 Task Type is not deleted");
				}
			} catch (Throwable t) {
				successMessage("The Automation Permission 4 Task Type is deleted successfully.");
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

		// ROLE LEVEL VERIFICATION
		title("ROLE LEVEL VERIFICATION");

		// LOGIN WITH CONTRACTOR USER TWO
		title("LOGIN WITH CONTRACTOR USER TWO");

		try {

			// wait for element
			explicitWaitClickable("questionnaire_settingicon_CSS");

			// click on the settings icon from the top of the screen
			click("questionnaire_settingicon_CSS");

			// wait for element
			explicitWaitClickable("sidemenu_logout_CSS");

			// click on the logout option from the side menu
			click("sidemenu_logout_CSS");

			helper.loginAndUpdateSystemCompany(data, "username", "password", "system_company_1");

			// CREATE NEW TASK - CONTRACTOR USER
			title("CREATE NEW TASK - CONTRACTOR USER");

			try {
				// click on the task icon
				click("taskicon_CSS");

				// click on the add task button
				click("task_addtaskbtn_CSS");

				// Verify the default user/role in assigned to field
				try {
					boolean str31 = driver.findElement(By.xpath("(//span[text()='Jinesh QA'])[1]")).isDisplayed();
					boolean str32 = driver.findElement(By.xpath("(//span[text()='Contractor'])[1]")).isDisplayed();
					boolean str33 = driver.findElement(By.xpath("(//span[text()='Jinesh QA 2'])[1]")).isDisplayed();
					boolean str34 = driver.findElement(By.xpath("(//span[text()='Human Resources'])[1]")).isDisplayed();

					if ((str31 && str32 && str33 && str34) == true) {
						successMessage("The default user/role is displayed successfully.");
					} else {
						verificationFailedMessage("The default user or role is not displayed.");
					}

				} catch (Throwable t) {
					verificationFailedMessage("The default user or role is not displayed.");
				}

				// click on the task type field
				click("task_permission_task_tasktypetxt_CSS");

				// enter the newly created task type
				type("task_tasktag_searchtxt_CSS", data.get("task_title_rolelevel"));

				// click on the searched task type
				click("task_permission_task_createdtasktype_rolelevel_XPATH");

				// verified the default user/role, and preserved user/role in
				// assigned to field
				try {
					boolean str35 = driver.findElement(By.xpath("(//span[text()='Jinesh QA'])[1]")).isDisplayed();
					boolean str36 = driver.findElement(By.xpath("(//span[text()='Contractor'])[1]")).isDisplayed();
					boolean str37 = driver.findElement(By.xpath("(//span[text()='Jinesh QA 2'])[1]")).isDisplayed();
					boolean str38 = driver.findElement(By.xpath("(//span[text()='Human Resources'])[1]")).isDisplayed();
					boolean str39 = driver.findElement(By.xpath("(//span[text()='Jinesh Misc'])[1]")).isDisplayed();
					boolean str40 = driver.findElement(By.xpath("(//span[text()='Operations'])[1]")).isDisplayed();

					if ((str35 && str36 && str37 && str38 && str39 && str40) == true) {
						successMessage("The default user/role, and preserved user/role are displayed successfully.");
					} else {
						verificationFailedMessage("The default user/role, and preserved user/role is not displayed");
					}

				} catch (Throwable t) {
					verificationFailedMessage("The default user/role, and preserved user/role is not displayed");
				}

				// ADD THE USER IN THE ASSIGN TO FIELD
				title("ADD THE USER IN THE ASSIGN TO FIELD");

				// click on the assign to field
				click("task_assigntotxt_CSS");

				// enter the user name in the search field
				type("workflowsecurity_editortask_taskdetails_searchtasktagtxt_CSS", data.get("search_user"));

				// click on the searched result
				click("task_permission_task_selectusertxt_XPATH");

				// click on the assign to field
				click("task_assigntotxt_CSS");

				// verify the default user/role, updated user and preserved user/role in
				// assigned to field
				try {
					boolean str41 = driver.findElement(By.xpath("(//span[text()='Jinesh QA'])[1]")).isDisplayed();
					boolean str42 = driver.findElement(By.xpath("(//span[text()='Contractor'])[1]")).isDisplayed();
					boolean str43 = driver.findElement(By.xpath("(//span[text()='Jinesh QA 2'])[1]")).isDisplayed();
					boolean str44 = driver.findElement(By.xpath("(//span[text()='Human Resources'])[1]")).isDisplayed();
					boolean str45 = driver.findElement(By.xpath("(//span[text()='Jinesh Misc'])[1]")).isDisplayed();
					boolean str46 = driver.findElement(By.xpath("(//span[text()='Operations'])[1]")).isDisplayed();
					boolean str47 = driver.findElement(By.xpath("(//span[text()='Jinesh'])[1]")).isDisplayed();

					if ((str41 && str42 && str43 && str44 && str45 && str46 && str47) == true) {
						successMessage(
								"The default user/role, updated user and preserved user/role are displayed successfully.");
					} else {
						verificationFailedMessage(
								"The default user/role, updated user and preserved user/role is not displayed");
					}

				} catch (Throwable t) {
					verificationFailedMessage(
							"The default user/role, updated user and preserved user/role is not displayed");
				}

				// click on the save button
				click("survey_task_savebtn_CSS");

				// wait for the 5 seconds
				Thread.sleep(5000);

			} catch (Throwable t) {
				verificationFailed();
			}

			// UNSELECT THE PRESERVED user/role
			title("UNSELECT THE PRESERVED user/role");

			try {
				// click on the newly created task
				click("task_permission_addedtasktype_rolelevel_XPATH");

				// click on the assigned to field
				click("task_assigntotxt_CSS");

				// enter the user name in the search field
				type("workflowsecurity_editortask_taskdetails_searchtasktagtxt_CSS", data.get("task_type_user"));

				// click on the searched result
				click("task_permission_tasktype_searcheduser_XPATH");

				// click on the assign to field
				click("task_assigntotxt_CSS");

				// wait for the element
				Thread.sleep(5000);

				// click on the update button
				click("survey_task_updatebtn_CSS");

				// wait for the element
				explicitWaitClickable("closetoastmsg_CSS");

				// click on the toaster close button
				click("closetoastmsg_CSS");

				// wait for the 5 seconds
				Thread.sleep(5000);

				try {
					boolean str48 = driver.findElement(By.xpath(
							"//p[text()='Automation Permission 4 Task Type Rolelevel']//parent::td//following-sibling::td[contains(text(),'Jinesh Misc')]"))
							.isDisplayed();

					if (str48 == true) {
						successMessage("The preserved user/role is displayed as expected.");
					} else {

						verificationFailedMessage("The preserved user/role is not displayed");
					}

				} catch (Throwable t) {
					verificationFailedMessage("The preserved user/role is not displayed");
				}

				// click on the newly created task
				click("task_permission_addedtasktype_rolelevel_XPATH");

				// click on the assign to field
				click("task_assigntotxt_CSS");

				// enter the role in the search field
				type("workflowsecurity_editortask_taskdetails_searchtasktagtxt_CSS", data.get("task_type_role"));

				// click on the searched result
				click("task_permission_tasktype_searchedrole_XPATH");

				// click on the assign to field
				click("task_assigntotxt_CSS");

				// wait for the element
				Thread.sleep(5000);

				// click on the update button
				click("survey_task_updatebtn_CSS");

				// wait for the element
				explicitWaitClickable("closetoastmsg_CSS");

				// click on the toaster close button
				click("closetoastmsg_CSS");

				// verify preserved user/role is displayed or not
				try {
					boolean str49 = driver.findElement(By.xpath(
							"//p[text()='Automation Permission 4 Task Type Rolelevel']//parent::td//following-sibling::td[contains(text(),'Operations')]"))
							.isDisplayed();

					if (str49 == true) {
						successMessage("The preserved user/role is displayed as expected.");

					} else {

						verificationFailedMessage("The preserved user/role is not displayed");
					}

				} catch (Throwable t) {
					verificationFailedMessage("The preserved user/role is not displayed");
				}

			} catch (Throwable t) {
				verificationFailed();
			}

			// UPDATE THE TASK
			title("UPDATE THE TASK");

			try {
				// click on the newly created task
				click("task_permission_addedtasktype_rolelevel_XPATH");

				// verify the default displayed user/role and preserved user/role in assigned to
				// field
				try {
					boolean str50 = driver.findElement(By.xpath("(//span[text()='Jinesh QA'])[1]")).isDisplayed();
					boolean str51 = driver.findElement(By.xpath("(//span[text()='Contractor'])[1]")).isDisplayed();
					boolean str52 = driver.findElement(By.xpath("(//span[text()='Jinesh QA 2'])[1]")).isDisplayed();
					boolean str53 = driver.findElement(By.xpath("(//span[text()='Human Resources'])[1]")).isDisplayed();
					boolean str54 = driver.findElement(By.xpath("(//span[text()='Jinesh Misc'])[1]")).isDisplayed();
					boolean str55 = driver.findElement(By.xpath("(//span[text()='Operations'])[1]")).isDisplayed();
					boolean str56 = driver.findElement(By.xpath("(//span[text()='Jinesh'])[1]")).isDisplayed();

					System.out.println(
							str50 + " " + str51 + " " + str52 + " " + str53 + " " + str54 + " " + str55 + " " + str56);

					if ((str50 && str51 && str52 && str53 && str54 && str55 && str56) == true) {
						successMessage("The default user/role and preserved user/role is displayed successfully.");
					} else {
						verificationFailedMessage("The default user or role is not displayed");
					}

				} catch (Throwable t) {
					verificationFailedMessage("The default user or role is not displayed");
				}

				// click on the assign to field
				click("task_assigntotxt_CSS");

				// enter the user name in the search field
				type("workflowsecurity_editortask_taskdetails_searchtasktagtxt_CSS", data.get("search_user_update"));

				// click on the searched result
				click("task_permission_task_updateselectusertxt_XPATH");

				// click on the assign to field
				click("task_assigntotxt_CSS");

				// wait for the element
				Thread.sleep(5000);

				// click on the update button
				click("survey_task_updatebtn_CSS");

				// wait for the element
				explicitWaitClickable("closetoastmsg_CSS");

				// click on the toaster close button
				click("closetoastmsg_CSS");

			} catch (Throwable t) {
				verificationFailed();
			}

			// UNSELECT THE DEFAULT ADDED USER/ROLE AND NEWLY ADDED USER
			title("UNSELECT THE DEFAULT ADDED USER/ROLE AND NEWLY ADDED USER");

			try {
				// click on the newly created task
				click("task_permission_addedtasktype_rolelevel_XPATH");

				// click on the assign to field
				click("task_assigntotxt_CSS");

				// enter the user name in the search field
				type("workflowsecurity_editortask_taskdetails_searchtasktagtxt_CSS", data.get("search_user"));

				// click on the searched result
				click("task_permission_task_selectusertxt_XPATH");

				// click on the assign to field
				click("task_assigntotxt_CSS");

				// enter the default role in the search field
				type("workflowsecurity_editortask_taskdetails_searchtasktagtxt_CSS", data.get("role_ss"));

				// click on the searched result
				click("task_permission_task_defaultrole_XPATH");

				// click on the assign to field
				click("task_assigntotxt_CSS");

				// enter the default user in the search field
				type("workflowsecurity_editortask_taskdetails_searchtasktagtxt_CSS", data.get("user_ss"));

				// click on the searched result
				driver.findElement(By.xpath("(//span[text()='Jinesh QA'])[2]")).click();

				// enter the default user in the search field
				type("workflowsecurity_editortask_taskdetails_searchtasktagtxt_CSS", data.get("user_rolelevel"));

				// click on the searched result
				click("task_permission_task_defaultuser_rolelevel_XPATH");

				// click on the assign to field
				click("task_assigntotxt_CSS");

				// enter the default role in the search field
				type("workflowsecurity_editortask_taskdetails_searchtasktagtxt_CSS", data.get("role_rolelevel"));

				// click on the searched result
				click("task_permission_task_defaultrole_rolelevel_XPATH");

				// wait for the element
				Thread.sleep(5000);

				// click on the update button
				click("survey_task_updatebtn_CSS");

				// wait for the element
				explicitWaitClickable("closetoastmsg_CSS");

				// click on the toaster close button
				click("closetoastmsg_CSS");

				// scroll up the screen
				scrollByPixel(-500);

				// click on the clear button
				click("task_createdtask_clearbtn_XPATH");

				// enter the data in the search field
				type("task_filter_CSS", data.get("task_title"));

				// click on the search button
				click("task_createdtask_searchbtn_XPATH");

				// verify updated task is displayed or not
				try {
					String str2 = (driver
							.findElement(
									By.xpath("//p[contains(text(),'Automation Permission 4 Task Type Rolelevel')]"))
							.getText()).trim();

					if (str2.equals("Automation Permission 4 Task Type Rolelevel")) {
						successMessage("The Automation Permission 4 Task Type Rolelevel is verified successfully.");
					} else {
						verificationFailed();
					}
				} catch (Throwable t) {
					verificationFailed();
				}

				// click on the updated task
				click("task_permission_addedtasktype_rolelevel_XPATH");

				// verify the preserved user/role and updated user in assigned to field
				try {
					boolean str67 = driver.findElement(By.xpath("(//span[text()='Jinesh Misc'])[1]")).isDisplayed();
					boolean str68 = driver.findElement(By.xpath("(//span[text()='Operations'])[1]")).isDisplayed();
					boolean str69 = driver.findElement(By.xpath("(//span[text()='Jinesh Sample One'])[1]"))
							.isDisplayed();

					if ((str67 && str68 && str69) == true) {
						successMessage("The preserved user/role and updated user is displayed successfully.");
					} else {
						verificationFailedMessage("The preserved user/role and updated user is not displayed");
					}

				} catch (Throwable t) {
					verificationFailedMessage("The preserved user/role and updated user is not displayed");
				}

				// click on the update button
				click("survey_task_updatebtn_CSS");

				// wait for the element
				explicitWaitClickable("closetoastmsg_CSS");

				// click on the toaster close button
				click("closetoastmsg_CSS");

				// click on the back button
				driver.findElement(By.xpath("//button[@ng-click='cancelTaskInput(false); resetTaskInputDetails();']"))
						.click();

			} catch (Throwable t) {
				verificationFailed();
			}

			// DELETE THE TASK
			title("DELETE THE TASK");

			try {
				// click on the newly created task
				click("task_permission_addedtasktype_rolelevel_XPATH");

				// wait for element
				explicitWaitClickable("task_deletedtaskbtn_CSS");

				// click on the delete button
				click("task_deletedtaskbtn_CSS");

				// wait for element
				explicitWaitClickable("task_deletedtaskbtn_confirmaiton_CSS");

				// click on the delete button of the confirmation popup
				click("task_deletedtaskbtn_confirmaiton_CSS");

				// scroll up the screen
				scrollByPixel(-500);

				// click on the clear button
				click("task_createdtask_clearbtn_XPATH");

				// enter the data in the search field
				type("task_filter_CSS", data.get("task_title"));

				// click on the search button
				click("task_createdtask_searchbtn_XPATH");

				// verify the task deleted or not
				try {

					String deleteElement = (driver
							.findElement(
									By.xpath("//p[contains(text(),'Automation Permission 4 Task Type Rolelevel')]"))
							.getText()).trim();

					if (deleteElement.equals("Automation Permission 4 Task Type Rolelevel")) {

						verificationFailedMessage("The  Automation Permission 4 Task Type Rolelevel is not deleted.");
					}
				} catch (Throwable t) {
					successMessage("The Automation Permission 4 Task Type Rolelevel is deleted successfully.");
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

			// LOGIN WITH ADMIN USER
			title("LOGIN WITH ADMIN USER");

			// wait for element
			explicitWaitClickable("questionnaire_settingicon_CSS");

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

		// RESET DEFAULT USERS AND ROLES IN THE SECURITY SETTINGS AND ROLE LEVEL
		title("RESET DEFAULT USERS AND ROLES IN THE SECURITY SETTINGS AND ROLE LEVEL");

		try {
			// wait for element
			explicitWaitClickable("questionnaire_settingicon_userupdate_CSS");

			// click on the settings icon
			click("questionnaire_settingicon_userupdate_CSS");

			// wait for element
			explicitWaitClickable("questionnaire_administrationoption_XPATH");

			// click on the Administration option from the side menu
			click("questionnaire_administrationoption_XPATH");

			// click on the Security tab
			click("questionnaire_securitytab_XPATH");

			// click on the Security Settings option
			click("ssc_securitytab_securitysettingsoption_XPATH");

			// enter Default General Task Assignees text in search field
			type("task_permission_securitysettings_searchtxt1_CSS", data.get("search_ss"));

			// click on the searched result
			driver.findElement(By.xpath("//span[text()='Default general task assignee ']")).click();

			// click on the role field
			click("task_permission_securitysettings_roletxt_CSS");

			// click on the none button
			click("task_permission_securitysettings_nonebtn_CSS");

			// click on the role field
			click("task_permission_securitysettings_roletxt_CSS");

			// click on the user field
			click("task_permission_securitysettings_usertxt_CSS");

			// click on the none button
			click("task_permission_securitysettings_nonebtn_CSS");

			// click on the role field
			click("task_permission_securitysettings_usertxt_CSS");

			// click on the save button
			click("securitysettings_accesssurveychecklist_CSS");

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

		// synchronization
		explicitWait("propertylist_title_XPATH");

		// verify the property list
		switchVerification("propertylist_title_XPATH", "Property List", "The property list is not displayed.");

		// RESET THE TASK TYPE - ROLELEVEL
		title("RESET THE TASK TYPE - ROLELEVEL");

		try {

			// wait for element
			explicitWaitClickable("menubtn_CSS");

			// click on the side menu button
			click("menubtn_CSS");

			// wait for element
			explicitWaitClickable("sidemenu_task_CSS");

			// click on the task option
			click("sidemenu_task_CSS");

			// verify dashboard drop down is displayed or not
			switchVerification("ssc_sustainability_dashboardtxt_XPATH", "Dashboard",
					"The Dashboard Drop down is not displayed.");

			// select the task type from the dashboard drop down
			select("task_permission_tasktype_dashboarddd_CSS", data.get("dashboard_tasktype"));

			// wait for 5 seconds
			Thread.sleep(5000);

			// enter the task type in the search field
			type("task_permission_tasktype_searchtxt_CSS", data.get("task_title_rolelevel"));

			// verify newly created task type is displayed or not
			switchVerification("task_permission_addedtasktype1_rolelevel_XPATH",
					"Automation Permission 4 Task Type Rolelevel",
					"The Automation Permission 4 Task Type Rolelevel is not displayed.");

			// click on the newly created task type
			click("task_permission_addedtasktype1_rolelevel_XPATH");

			// create the random string
			String s1 = RandomStringUtils.randomAlphabetic(8);

			// enter the task type
			type("task_permission_tasktype_tasktypetxt_CSS", s1);

			// click on the save button
			click("task_permission_tasktype_savebtn_CSS");

			// wait for the element
			Thread.sleep(5000);

		} catch (Throwable t) {
			verificationFailed();
		}

		// click on the home icon from the top of the screen
		click("questionnaire_homeburgermenubtn_hide_CSS");

		// synchronization
		explicitWait("propertylist_title_XPATH");

		// verify the property list
		switchVerification("propertylist_title_XPATH", "Property List", "The property list is not displayed.");

		// RESET THE TASK TYPE
		title("RESET THE TASK TYPE");

		try {

			// wait for element
			Thread.sleep(5000);

			// click on the side menu button
			click("menubtn_CSS");

			// wait for element
			Thread.sleep(5000);

			// click on the task option
			click("sidemenu_task_CSS");

			// verify dashboard drop down is displayed or not
			switchVerification("ssc_sustainability_dashboardtxt_XPATH", "Dashboard",
					"The Dashboard Drop down is not displayed.");

			// select the task type from the dashboard drop down
			select("task_permission_tasktype_dashboarddd_CSS", data.get("dashboard_tasktype"));

			// wait for 5 seconds
			Thread.sleep(5000);

			// scroll down the screen
			scrollByPixel(200);

			// enter the task type in the search field
			type("task_permission_tasktype_searchtxt_CSS", data.get("task_title"));

			// verify newly created task type is displayed or not
			switchVerification("task_permission_addedtasktype1_XPATH", "Automation Permission 4 Task Type",
					"The Automation Permission 4 Task Type is not displayed.");

			// click on the newly created task type
			click("task_permission_addedtasktype1_XPATH");

			// create the random string
			String s = RandomStringUtils.randomAlphabetic(8);

			// enter the task type
			type("task_permission_tasktype_tasktypetxt_CSS", s);

			// click on the save button
			click("task_permission_tasktype_savebtn_CSS");

		} catch (Throwable t) {
			verificationFailed();

		}

		// click on the home icon from the top of the screen
		click("questionnaire_homeburgermenubtn_hide_CSS");

		// synchronization
		explicitWait("propertylist_title_XPATH");

		// verify the property list
		switchVerification("propertylist_title_XPATH", "Property List", "The property list is not displayed.");

	}
}