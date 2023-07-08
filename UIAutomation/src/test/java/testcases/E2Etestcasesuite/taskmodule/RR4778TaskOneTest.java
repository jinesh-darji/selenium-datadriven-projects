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

public class RR4778TaskOneTest extends TestBase {

	@Test(dataProviderClass = TestUtil.class, dataProvider = "dp")
	public void rR4778TaskOneTest(Hashtable<String, String> data) throws IOException, InterruptedException {

		execution(data, "rR4778TaskOneTest");

		// ANYONE WITH THE SAME ROLE AS THE TASK CREATOR HAS ALL THE PERMISSIONS LIKE
		// THE TASK CREATOR - WITH INTERNAL ROLE CHECKLIST.
		title("ANYONE WITH THE SAME ROLE AS THE TASK CREATOR HAS ALL THE PERMISSIONS LIKE THE TASK CREATOR - WITH INTERNAL ROLE CHECKLIST.");

		Helper helper = new Helper();

		// refresh the page
		driver.navigate().refresh();
		Thread.sleep(5000);
		driver.navigate().refresh();

		// SET THE PERMISSIONS FOR THE ROLE
		title("SET THE PERMISSIONS FOR THE ROLE");

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

			// verify internal role check box is selected or not
			boolean internalrole = driver.findElement(By.cssSelector("input[name='internalRole']")).isSelected();

			if (internalrole == true) {
				successMessage("The internal role is displayed selected.");
			} else {

				// click on the internal role checklist
				click("task_permission_roles_internalrole_CSS");

				successMessage("Clicked on the internal role checklist.");
			}

			// click on the save button
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

		// LOGIN WITH CONTRACTOR USER 1
		title("LOGIN WITH CONTRACTOR USER 1");

		try {
			// wait for the element
			Thread.sleep(7000);

			// click on the settings icon from the top of the screen
			click("questionnaire_settingicon_CSS");

			// wait for the element
			Thread.sleep(5000);

			// click on the logout option from the side menu
			click("sidemenu_logout_CSS");

			helper.loginAndUpdateSystemCompany(data, "username", "password", "system_company_1");

			// CREATE NEW TASK
			title("CREATE NEW TASK");

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

				// wait for the element
				Thread.sleep(5000);

//				// verify newly created task is displayed or not
//				switchVerification("task_permission_taskpermission_addedtask1_XPATH", "Test Task Permission One Title",
//						"The Test Task Permission One Title is not displayed.");

				try {
					String str2 = (driver
							.findElement(By.xpath("//p[contains(text(),'Test Task Permission One Title')]")).getText())
							.trim();

					if (str2.equals("Test Task Permission One Title")) {
						successMessage("The Test Task Permission One Title is verified successfully.");
					} else {
						verificationFailed();
					}
				} catch (Throwable t) {
					verificationFailed();
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

			// LOGIN WITH VENDER USER
			title("LOGIN WITH VENDER USER");

			// wait for element
			explicitWaitClickable("questionnaire_settingicon_CSS");

			// click on the settings icon from the top of the screen
			click("questionnaire_settingicon_CSS");

			// wait for element
			explicitWaitClickable("sidemenu_logout_CSS");

			// click on the logout option from the side menu
			click("sidemenu_logout_CSS");

			helper.loginAndUpdateSystemCompany(data, "username_2", "password", "system_company_1");

			// CREATE NEW TASK
			title("CREATE NEW TASK");

			try {
				// click on the task icon
				click("taskicon_CSS");

				// click on the clear button
				click("task_createdtask_clearbtn_XPATH");

				// enter the data in the search field
				type("task_filter_CSS", data.get("task_title"));

				// click on the search button
				click("task_createdtask_searchbtn_XPATH");

				try {
					String str3 = driver
							.findElement(By.xpath(OR.getProperty("task_permission_taskpermission_addedtask1_XPATH")))
							.getText();

					if (str3.equals("Test Task Permission One Title")) {

						verificationFailedMessage("The task is display successfully.");
					}
				} catch (Throwable t) {
					successMessage("The task is not displayed as per the expected.");
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

			helper.loginAndUpdateSystemCompany(data, "username1", "password", "system_company_1");

			// UPDATE THE TASK
			title("UPDATE THE TASK");

			try {
				// click on the task icon
				click("taskicon_CSS");

				// click on the clear button
				click("task_createdtask_clearbtn_XPATH");

				// enter the data in the search field
				type("task_filter_CSS", data.get("task_title"));

				// click on the search button
				click("task_createdtask_searchbtn_XPATH");

				// wait for the element
				Thread.sleep(5000);

				// click on the newly created task
				driver.findElement(By.xpath("//p[contains(text(),'Test Task Permission One Title')]")).click();

				try {
					// update the title of the task
					type("task_addtask_titletxt_CSS", data.get("update_task_title"));

					// click on the update button
					click("survey_task_updatebtn_CSS");

					// wait for the element
					explicitWaitClickable("closetoastmsg_CSS");

					// click on the toaster close button
					click("closetoastmsg_CSS");

					// click on the back button
					driver.findElement(
							By.xpath("//button[@ng-click='cancelTaskInput(false); resetTaskInputDetails();']")).click();

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
						String str2 = (driver
								.findElement(By.xpath("//P[contains(text(),'Update Test Task Permission One Title')]"))
								.getText()).trim();

						if (str2.equals("Update Test Task Permission One Title")) {
							successMessage("The Update Test Task Permission One Title is verified successfully.");
						} else {
							verificationFailed();
						}
					} catch (Throwable t) {
						verificationFailed();
					}

					verificationFailedMessage(
							"The property manager user able to update the details, without permission.");

				} catch (Throwable t) {

					successMessage("The property manager user not able to update the details, As expected.");
				}

			} catch (Throwable t) {
				verificationFailed();
			}

			// DELETE THE TASK
			title("DELETE THE TASK");

			try {
				// click on the newly created task
				driver.findElement(By.xpath("//P[contains(text(),'Update Test Task Permission One Title')]")).click();

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
				type("task_filter_CSS", data.get("update_task_title"));

				// click on the search button
				click("task_createdtask_searchbtn_XPATH");

				// wait for the element
				Thread.sleep(5000);

				try {

					String deleteElement = driver
							.findElement(By.xpath("//P[contains(text(),'Update Test Task Permission One Title')]"))
							.getText();

					if (deleteElement.equals("Update Test Task Permission One Title")) {

						verificationFailedMessage("The  Update Test Task Permission One Title is not deleted");
					}
				} catch (Throwable t) {
					successMessage("The Update Test Task Permission One Title is deleted successfully.");
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

			// LOGIN WITH CONTRACTOR USER 1
			title("LOGIN WITH CONTRACTOR USER 1");

			// click on the settings icon from the top of the screen
			click("questionnaire_settingicon_CSS");

			// wait for 3 seconds
			Thread.sleep(3000);

			// click on the logout option from the side menu
			click("sidemenu_logout_CSS");

			helper.loginAndUpdateSystemCompany(data, "username", "password", "system_company_1");

			// VERIFY TASK IS DISPLAYED OR NOT
			title("VERIFY TASK IS DISPLAYED OR NOT");

			try {
				// click on the task icon
				click("taskicon_CSS");

				// click on the clear button
				click("task_createdtask_clearbtn_XPATH");

				// enter the data in the search field
				type("task_filter_CSS", data.get("update_task_title"));

				// click on the search button
				click("task_createdtask_searchbtn_XPATH");

				try {

					String deleteElement1 = (driver
							.findElement(By.xpath("//P[contains(text(),'Update Test Task Permission One Title')]"))
							.getText()).trim();

					if (deleteElement1.equals("Update Test Task Permission One Title")) {

						verificationFailedMessage("The  Update Test Task Permission One Title is not deleted.");
					}
				} catch (Throwable t) {
					successMessage("The Update Test Task Permission One Title is deleted successfully.");
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

			// LOGIN WITH ADMIN USER
			helper.loginAndUpdateSystemCompany(data, "username_1", "password_1", "system_company_1");

		} catch (Throwable t) {
			helper.questionnaireNotDisplayLogout(data);
		}

		// RESET THE APPLIED PERMISSION ON THE ROLE
		title("RESET THE APPLIED PERMISSION ON THE ROLE");

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

			// verify internal role check box is selected or not
			boolean internalrole1 = driver.findElement(By.cssSelector("input[name='internalRole']")).isSelected();

			if (internalrole1 == true) {
				successMessage("The internal role is displayed selected.");
			} else {

				// click on the internal role checklist
				click("task_permission_roles_internalrole_CSS");

			}

			// click on the save button
			click("task_permission_roles_saverolebtn_CSS");

		} catch (Throwable t) {
			verificationFailed();
		}

		// click on the home icon from the top of the screen
		click("questionnaire_homeburgermenubtn_CSS");

		// synchronization
		explicitWait("propertylist_title_XPATH");

		// verify the property list
		switchVerification("propertylist_title_XPATH", "Property List", "The property list is not displayed.");

	}
}