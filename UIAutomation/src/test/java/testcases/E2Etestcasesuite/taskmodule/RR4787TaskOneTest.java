package testcases.E2Etestcasesuite.taskmodule;

import java.io.IOException;
import java.util.Hashtable;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.SkipException;
import org.testng.annotations.Test;

import com.relevantcodes.extentreports.LogStatus;

import base.Helper;
import base.TestBase;
import utilities.TestUtil;

public class RR4787TaskOneTest extends TestBase {

	@Test(dataProviderClass = TestUtil.class, dataProvider = "dp")
	public void rR4787TaskOneTest(Hashtable<String, String> data) throws IOException, InterruptedException {

		execution(data, "rR4787TaskOneTest");

		// CREATE TASK > WITHOUT A TASK TYPE > ADD DEFAULT TASK ASSIGNEE > 1. CAN REMOVE
		// ANY TASK ASSIGNEES 2. CAN ADD NEW USERS/ROLES.
		title("CREATE TASK > WITHOUT A TASK TYPE > ADD DEFAULT TASK ASSIGNEE > 1. CAN REMOVE ANY TASK ASSIGNEES 2. CAN ADD NEW USERS/ROLES.");

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

		// SECURITY SETTINGS LEVEL VERIFICATION
		title("SECURITY SETTINGS LEVEL VERIFICATION");

		try {
			// click on the task icon
			click("taskicon_CSS");

			// click on the add task button
			click("task_addtaskbtn_CSS");

			// compare the default displayed user and role in assigned to field
			try {
				boolean str1 = driver.findElement(By.xpath("//span[text()='Jinesh QA']")).isDisplayed();
				boolean str2 = driver.findElement(By.xpath("//span[text()='Contractor']")).isDisplayed();

				if (str1 && str2) {
					successMessage("The default user and role is displayed successfully.");
				} else {
					verificationFailedMessage("The default user or role is not displayed");
				}

			} catch (Throwable t) {
				verificationFailedMessage("The default user or role is not displayed");
			}

			// enter the data in the task title field
			type("task_addtask_titletxt_CSS", data.get("task_title"));

			// enter the data in the task location field
			type("task_addtask_locationtxt_CSS", data.get("task_location"));

			// click on the assign to field
			click("task_assigntotxt_CSS");

			// enter the user name in the search field
			type("workflowsecurity_editortask_taskdetails_searchtasktagtxt_CSS", data.get("search_user"));

			// click on the searched result
			click("task_permission_task_selectusertxt_XPATH");

			// click on the assign to field
			click("task_assigntotxt_CSS");

			// scroll down the screen
			scrollByPixel(1200);

			// synchronization
			explicitWait("task_addtask_moduledd_CSS");

			// select the environmental option from the module dropdown
			select("task_addtask_moduledd_CSS", data.get("task_module"));

			// click on the save button
			click("survey_task_savebtn_CSS");

			// scroll up the screen
			scrollByPixel(-500);

			// click on the clear button
			click("task_createdtask_clearbtn_XPATH");

			// enter the data in the search field
			type("task_filter_CSS", data.get("task_title"));

			// click on the search button
			click("task_createdtask_searchbtn_XPATH");

			// verify newly created task is displayed or not
			try {
				String str2 = (driver.findElement(By.xpath("//p[contains(text(),'Test Task Permission Three Title')]"))
						.getText()).trim();

				if (str2.equals("Test Task Permission Three Title")) {
					successMessage("The Test Task Permission Three Title is verified successfully.");
				} else {
					verificationFailed();
				}
			} catch (Throwable t) {
				verificationFailed();
			}

			// wait for the 5 seconds
			Thread.sleep(5000);

			// click on the newly created task
			driver.findElement(By.xpath("//p[contains(text(),'Test Task Permission Three Title')]")).click();

			// compare the default displayed user and role and newly added user in assigned
			// to field
			try {
				boolean str3 = driver.findElement(By.xpath("//span[text()='Jinesh QA']")).isDisplayed();
				boolean str4 = driver.findElement(By.xpath("//span[text()='Contractor']")).isDisplayed();
				boolean str5 = driver.findElement(By.xpath("//span[text()='Jinesh']")).isDisplayed();

				if (str3 && str4 && str5) {
					successMessage("The default user and role and newly added user is displayed successfully.");
				} else {
					verificationFailedMessage("The default user, role, or newly added user is not displayed.");
				}

			} catch (Throwable t) {
				verificationFailedMessage("The default user, role, or newly added user is not displayed.");
			}

			// update the title of the task
			type("task_addtask_titletxt_CSS", data.get("update_task_title"));

			// click on the assign to field
			click("task_assigntotxt_CSS");

			// enter the user name in the search field
			type("workflowsecurity_editortask_taskdetails_searchtasktagtxt_CSS", data.get("search_user_update"));

			// click on the searched result
			click("task_permission_task_updateselectusertxt_XPATH");

			// click on the assign to field
			click("task_assigntotxt_CSS");

			// click on the update button
			click("survey_task_updatebtn_CSS");

			// wait for the element
			explicitWaitClickable("closetoastmsg_CSS");

			// click on the toaster close button
			click("closetoastmsg_CSS");

			// click on the back button
			driver.findElement(By.xpath("//button[@ng-click='cancelTaskInput(false); resetTaskInputDetails();']"))
					.click();

			// scroll up the screen
			scrollByPixel(-500);

			// click on the clear button
			click("task_createdtask_clearbtn_XPATH");

			// enter the data in the search field
			type("task_filter_CSS", data.get("update_task_title"));

			// click on the search button
			click("task_createdtask_searchbtn_XPATH");

			// verify updated task is displayed or not
			try {
				String str209 = (driver
						.findElement(By.xpath("//p[contains(text(),'Update Test Task Permission Three Title')]"))
						.getText()).trim();

				if (str209.equals("Update Test Task Permission Three Title")) {
					successMessage("The Update Test Task Permission Three Title is verified successfully.");
				} else {
					verificationFailed();
				}
			} catch (Throwable t) {
				verificationFailed();
			}

			// wait for the 5 seconds
			Thread.sleep(5000);

			// click on the updated task
			driver.findElement(By.xpath("//p[contains(text(),'Update Test Task Permission Three Title')]")).click();

			// compare the default displayed user and role, newly added user, and updated
			// user in assigned to field
			try {
				boolean str6 = driver.findElement(By.xpath("//span[text()='Jinesh QA']")).isDisplayed();
				boolean str7 = driver.findElement(By.xpath("//span[text()='Contractor']")).isDisplayed();
				boolean str8 = driver.findElement(By.xpath("//span[text()='Jinesh']")).isDisplayed();
				boolean str9 = driver.findElement(By.xpath("//span[text()='Jinesh Sample One']")).isDisplayed();

				if (str6 && str7 && str8 && str9) {
					successMessage(
							"The default user and role, newly added user, and updated user is displayed successfully.");
				} else {
					verificationFailedMessage(
							"The default user and role, newly added user, or updated user is not displayed");
				}

			} catch (Throwable t) {
				verificationFailedMessage(
						"The default user and role, newly added user, or updated user is not displayed");
			}

			// DELETE THE TASK
			title("DELETE THE TASK");

			// click on the delete button
			click("task_deletedtaskbtn_CSS");

			// synchronization
			explicitWait("task_deletedtaskbtn_confirmaiton_CSS");

			// click on the delete button of the confirmation popup
			click("task_deletedtaskbtn_confirmaiton_CSS");

			// scroll up the screen
			scrollByPixel(-500);

			// click on the clear button
			click("task_createdtask_clearbtn_XPATH");

			// enter the data in the search field
			type("task_filter_CSS", data.get("update_task_title"));

			// click on the search button
			click("task_createdtask_searchbtn_XPATH");

			// verify the questionnaire deleted or not
			try {
				String str4 = driver
						.findElement(By.xpath(OR.getProperty("task_permission_taskpermission_updatedtask3_XPATH")))
						.getText();

				if (str4.equals("Update Test Task Permission Three Title")) {

					verificationFailedMessage("The task is not deleted successfully.");
				}
			} catch (Throwable t) {
				successMessage("The task is deleted successfully.");
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

			// LOGIN WITH CONTRACTOR USER TWO
			helper.loginAndUpdateSystemCompany(data, "username", "password", "system_company_1");

			// click on the task icon
			click("taskicon_CSS");

			// click on the add task button
			click("task_addtaskbtn_CSS");

			// compare the default displayed user and role in assigned to field
			try {
				boolean str10 = driver.findElement(By.xpath("//span[text()='Jinesh QA']")).isDisplayed();
				boolean str11 = driver.findElement(By.xpath("//span[text()='Contractor']")).isDisplayed();
				boolean str12 = driver.findElement(By.xpath("//span[text()='Jinesh QA 2']")).isDisplayed();
				boolean str13 = driver.findElement(By.xpath("//span[text()='Human Resources']")).isDisplayed();

				if (str10 && str11 && str12 && str13) {
					successMessage("The default user and role is displayed successfully.");
				} else {
					verificationFailedMessage("The default user or role is not displayed.");
				}

			} catch (Throwable t) {
				verificationFailedMessage("The default user or role is not displayed.");
			}

			// enter the data in the task title field
			type("task_addtask_titletxt_CSS", data.get("task_title_rolelevel"));

			// enter the data in the task location field
			type("task_addtask_locationtxt_CSS", data.get("task_location"));

			// click on the assign to field
			click("task_assigntotxt_CSS");

			// enter the user name in the search field
			type("workflowsecurity_editortask_taskdetails_searchtasktagtxt_CSS", data.get("search_user"));

			// click on the searched result
			click("task_permission_task_selectusertxt_XPATH");

			// click on the assign to field
			click("task_assigntotxt_CSS");

			// scroll down the screen
			scrollByPixel(1200);

			// synchronization
			explicitWait("task_addtask_moduledd_CSS");

			// select the environmental option from the module dropdown
			select("task_addtask_moduledd_CSS", data.get("task_module"));

			// click on the save button
			click("survey_task_savebtn_CSS");

			// scroll up the screen
			scrollByPixel(-500);

			// click on the clear button
			click("task_createdtask_clearbtn_XPATH");

			// enter the data in the search field
			type("task_filter_CSS", data.get("task_title"));

			// click on the search button
			click("task_createdtask_searchbtn_XPATH");

			// wait for the 5 seconds
			Thread.sleep(5000);

			// click on the newly created task
			driver.findElement(By.xpath("//p[contains(text(),'Test Task Permission Three Title Rolelevel')]")).click();

			// compare the default displayed user and role and newly added user in assigned
			// to field
			try {
				boolean str14 = driver.findElement(By.xpath("//span[text()='Jinesh QA']")).isDisplayed();
				boolean str15 = driver.findElement(By.xpath("//span[text()='Contractor']")).isDisplayed();
				boolean str16 = driver.findElement(By.xpath("//span[text()='Jinesh QA 2']")).isDisplayed();
				boolean str17 = driver.findElement(By.xpath("//span[text()='Human Resources']")).isDisplayed();
				boolean str18 = driver.findElement(By.xpath("//span[text()='Jinesh']")).isDisplayed();

				if (str14 && str15 && str16 && str17 && str18) {
					successMessage("The default user and role and newly added user is displayed successfully.");
				} else {
					verificationFailedMessage("The default user, role, or newly added user is not displayed");
				}

			} catch (Throwable t) {
				verificationFailedMessage("The default user, role, or newly added user is not displayed");
			}

			// update the title of the task
			type("task_addtask_titletxt_CSS", data.get("update_task_title_rolelevel"));

			// click on the assign to field
			click("task_assigntotxt_CSS");

			// enter the user name in the search field
			type("workflowsecurity_editortask_taskdetails_searchtasktagtxt_CSS", data.get("search_user_update"));

			// click on the searched result
			click("task_permission_task_updateselectusertxt_XPATH");

			// click on the assign to field
			click("task_assigntotxt_CSS");

			// click on the update button
			click("survey_task_updatebtn_CSS");

			// wait for the element
			explicitWaitClickable("closetoastmsg_CSS");

			// click on the toaster close button
			click("closetoastmsg_CSS");

			// click on the back button
			driver.findElement(By.xpath("//button[@ng-click='cancelTaskInput(false); resetTaskInputDetails();']"))
					.click();

			// scroll up the screen
			scrollByPixel(-500);

			// click on the clear button
			click("task_createdtask_clearbtn_XPATH");

			// enter the data in the search field
			type("task_filter_CSS", data.get("update_task_title_rolelevel"));

			// click on the search button
			click("task_createdtask_searchbtn_XPATH");

			// verify updated task is displayed or not
			try {
				String str210 = (driver
						.findElement(
								By.xpath("//p[contains(text(),'Update Test Task Permission Three Title Rolelevel')]"))
						.getText()).trim();

				if (str210.equals("Update Test Task Permission Three Title Rolelevel")) {
					successMessage("The Update Test Task Permission Three Title Rolelevel is verified successfully.");
				} else {
					verificationFailed();
				}
			} catch (Throwable t) {
				verificationFailed();
			}

			// wait for the 5 seconds
			Thread.sleep(5000);

			// click on the newly created task
			driver.findElement(By.xpath("//p[contains(text(),'Update Test Task Permission Three Title Rolelevel')]"))
					.click();

			// compare the default displayed user and role, newly added user, and updated
			// user in assigned to field
			try {
				boolean str19 = driver.findElement(By.xpath("//span[text()='Jinesh QA']")).isDisplayed();
				boolean str20 = driver.findElement(By.xpath("//span[text()='Contractor']")).isDisplayed();
				boolean str21 = driver.findElement(By.xpath("//span[text()='Jinesh QA 2']")).isDisplayed();
				boolean str22 = driver.findElement(By.xpath("//span[text()='Human Resources']")).isDisplayed();
				boolean str23 = driver.findElement(By.xpath("//span[text()='Jinesh']")).isDisplayed();
				boolean str24 = driver.findElement(By.xpath("//span[text()='Jinesh Sample One']")).isDisplayed();

				if (str19 && str20 && str21 && str22 && str23 && str24) {
					successMessage(
							"The default user and role, newly added user, and updated user is displayed successfully.");
				} else {
					verificationFailedMessage(
							"The default user and role, newly added user, or updated user is not displayed");
				}

			} catch (Throwable t) {
				verificationFailedMessage(
						"The default user and role, newly added user, or updated user is not displayed");
			}

			// DELETE THE TASK
			title("DELETE THE TASK");

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
			type("task_filter_CSS", data.get("update_task_title_rolelevel"));

			// click on the search button
			click("task_createdtask_searchbtn_XPATH");

			// verify the task deleted or not
			helper.deleteVerification("task_permission_taskpermission_updatedtask3_rolelevel_XPATH",
					"Update Test Task Permission Three Title Rolelevel");

			try {

				String deleteElement = driver
						.findElement(
								By.xpath("//p[contains(text(),'Update Test Task Permission Three Title Rolelevel')]"))
						.getText();

				if (deleteElement.equals("Update Test Task Permission Three Title Rolelevel")) {

					verificationFailedMessage("The Update Test Task Permission Three Title Rolelevel is not deleted");
				}
			} catch (Throwable t) {
				successMessage("The Update Test Task Permission Three Title Rolelevel is deleted successfully.");
			}

			// click on the home icon from the top of the screen
			click("questionnaire_homeburgermenubtn_hide_CSS");

			// synchronization
			explicitWait("propertylist_title_XPATH");

			// verify the property list
			switchVerification("propertylist_title_XPATH", "Property List", "The property list is not displayed.");

			// click on the settings icon from the top of the screen
			click("questionnaire_settingicon_CSS");

			// wait for 3 seconds
			Thread.sleep(3000);

			// click on the logout option from the side menu
			click("sidemenu_logout_CSS");

			// LOGIN WITH ADMIN USER
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

	}
}