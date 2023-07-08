package testcases.E2Etestcasesuite.propertyprojectmodule;

import java.io.IOException;
import java.util.Hashtable;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Reporter;
import org.testng.SkipException;
import org.testng.annotations.Test;

import com.relevantcodes.extentreports.LogStatus;

import base.Helper;
import base.TestBase;
import utilities.TestUtil;

public class RR4904PropertyProjectOneTest extends TestBase {

	@Test(dataProviderClass = TestUtil.class, dataProvider = "dp")
	public void rR4904PropertyProjectOneTest(Hashtable<String, String> data) throws IOException, InterruptedException {

		execution(data, "rR4904PropertyProjectOneTest");

		// APPLY THE SECURITY SETTING OF THE ADD CAPEX PROJECTS PERMISSION TO THE
		// ASSIGNED USER/ROLE AND THE RESPECTIVE USER/ROLE MUST HAVE ONLY GRANTED
		// PERMISSION TO PERFORM ACTIONS.
		title("APPLY THE SECURITY SETTING OF THE ADD CAPEX PROJECTS PERMISSION TO THE ASSIGNED USER/ROLE AND THE RESPECTIVE USER/ROLE MUST HAVE ONLY GRANTED PERMISSION TO PERFORM ACTIONS.");

		Helper helper = new Helper();

		// refresh the page
		driver.navigate().refresh();
		Thread.sleep(5000);
		driver.navigate().refresh();

		// ADD SECURITY SETTINGS OF VIEW / ADD CAPEX PROJECTS TO USER/ROLE ACCESS
		title("ADD SECURITY SETTINGS OF VIEW / ADD CAPEX PROJECTS TO USER/ROLE ACCESS");

		try {
			// wait for the element
			explicitWaitClickable("questionnaire_settingicon_CSS");

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

			// APPLY THE VIEW CAPEX PROJECTS PERMISSION
			helper.addPermissionTwoUsersRole(data, "security_setting_5", "propertyproject_securitysettings5_XPATH");

			// APPLY THE ADD CAPEX Projects PERMISSION
			helper.addPermissionOneUsersRole(data, "security_setting_6", "propertyproject_securitysettings6_XPATH");

			// RESET THE EDIT CAPEX Projects PERMISSION
			helper.resetPermission(data, "security_setting_7", "propertyproject_securitysettings7_XPATH");

			// RESET THE DELETE CAPEX Projects PERMISSION
			helper.resetPermission(data, "security_setting_8", "propertyproject_securitysettings8_XPATH");

		} catch (Throwable t) {
			verificationFailed();
		}

		// click on the home icon
		click("questionnaire_homeburgermenubtn_CSS");

		// wait for the element
		explicitWait("propertylist_title_XPATH");

		// verify the property list
		switchVerification("propertylist_title_XPATH", "Property List", "The property list is not displayed.");

		try {

			// wait for the element
			explicitWaitClickable("questionnaire_settingicon_CSS");

			// click on the settings icon from the top of the screen
			click("questionnaire_settingicon_CSS");

			// wait for the element
			explicitWaitClickable("sidemenu_logout_CSS");

			// click on the logout option from the side menu
			click("sidemenu_logout_CSS");

			// VERIFY THE ADD, EDIT AND DELETE ACCESS IN THE JINESH USER
			title("VERIFY THE ADD, EDIT AND DELETE ACCESS IN THE JINESH USER");

			// LOGIN IN JINESH USER
			title("LOGIN IN JINESH USER");

			helper.loginAndUpdateSystemCompany(data, "username", "password", "system_company_1");

			// VERIFY THE JINESH ABLE TO ADD THE CAPEX PROJECTS DETAILS OR NOT
			title("VERIFY THE JINESH ABLE TO ADD THE CAPEX PROJECTS DETAILS OR NOT");

			// ADD CAPEX PROJECTS - JINESH
			title("ADD CAPEX PROJECTS - JINESH");

			try {

				// click on the property project icon from the property list page
				click("propertyproject_icon_CSS");

				// wait for the element
				explicitWaitClickable("menubtn_CSS");

				// click on the burger menu
				click("menubtn_CSS");

				// wait for the element
				Thread.sleep(5000);

				// click on the CAPEX Project
				click("propertyproject_capexprojectsoption_XPATH");

				// ADD RECORD - CAPEX PROJECTS
				title("ADD RECORD - CAPEX PROJECTS");

				// click on the add button
				click("propertyproject_cp_addbtn_CSS");

				// enter the project number
				type("propertyproject_cp_projectnumbertxt_CSS", data.get("project_number"));

				// select the engineering company
				select("propertyproject_cp_engineeringcompanydd_CSS", data.get("engineering_company"));

				// click on the data received field
				click("propertyproject_cp_datereceived_CSS");

				// click on the today button
				click("propertyproject_cp_datereceived_todaybtn_XPATH");

				// click on the save button
				click("propertyproject_cp_savebtn_CSS");

				// wait for the element
				explicitWaitClickable("closetoastmsg_CSS");

				// click on the toaster close button
				click("closetoastmsg_CSS");

				// wait for the element
				explicitWaitClickable("propertyproject_cp_canceltask_CSS");

				// click on the cancel button
				click("propertyproject_cp_canceltask_CSS");

				// verification of the CAPEX Projects is added or not
				switchVerification("propertyproject_cp_addedcapexprojects_ss1_XPATH", "CAPEXPROJECTSONE2021",
						"CAPEX Projects is not displayed successfully.");

			} catch (Throwable t) {
				verificationFailed();
			}

			// VERIFY THE USER ABLE TO UPDATE THE CAPEX Projects DETAILS OR NOT
			title("VERIFY THE USER ABLE TO UPDATE THE CAPEX Projects DETAILS OR NOT");

			// UPDATE CAPEX Projects - JINESH
			title("UPDATE CAPEX Projects - JINESH");

			try {

				// click on the newly created CAPEX Projects
				click("propertyproject_cp_addedcapexprojects_ss1_XPATH");

				// update the title of the project number
				type("propertyproject_cp_projectnumbertxt_CSS", data.get("update_project_number"));

				// update the title of the project number
				type("propertyproject_cp_projectnumbertxt_CSS", data.get("project_number"));

				// click on the update button
				click("propertyproject_cp_updatebtn_CSS");

				// wait for the element
				explicitWaitClickable("closetoastmsg_CSS");

				// click on the toaster close button
				click("closetoastmsg_CSS");

				verificationFailedMessage("The user able to update the CAPEX Projects details without the Access.");

			} catch (Throwable t) {
				successMessage("The user not able to update the CAPEX Projects details as expected");

				// click on the cancel button
				click("propertyproject_cp_cancelbtn_CSS");

			}

			// VERIFY THE USER ABLE TO DELETE THE CAPEX Projects DETAILS OR NOT
			title("VERIFY THE USER ABLE TO DELETE THE CAPEX Projects DETAILS OR NOT");

			// DELETE CAPEX Projects - JINESH
			title("DELETE CAPEX Projects - JINESH");

			try {

				boolean mu1 = driver.findElement(By.cssSelector(OR.getProperty("propertyproject_cp_deletebtn_CSS")))
						.isDisplayed();

				if (mu1 == true) {
					verificationFailedMessage(
							"The delete button is displayed in the CAPEX Projects without the Access");
				}
			} catch (Throwable t) {
				successMessage("The user not able to delete the CAPEX Projects details as expected");
			}

			// click on the home icon from the top of the screen
			click("questionnaire_homeburgermenubtn_hide_CSS");

			// wait for the element
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

			// VERIFY THE ADD, EDIT AND DELETE ACCESS IN THE CONTRACTOR ROLE
			title("VERIFY THE ADD, EDIT AND DELETE ACCESS IN THE CONTRACTOR ROLE");

			// LOGIN IN JINESH CONTRACTOR USER
			title("LOGIN IN JINESH CONTRACTOR USER");

			helper.loginAndUpdateSystemCompany(data, "username_2", "password_2", "system_company_1");

			// VERIFY THE CONTRACTOR - JINESHCONTRACTOR ABLE TO ADD THE CAPEX Projects
			// DETAILS OR NOT
			title("VERIFY THE CONTRACTOR - JINESHCONTRACTOR ABLE TO ADD THE CAPEX Projects DETAILS OR NOT");

			// ADD CAPEX Projects - CONTRACTOR - JINESHCONTRACTOR
			title("ADD CAPEX Projects - CONTRACTOR - JINESHCONTRACTOR");

			try {
				// click on the property project icon from the property list page
				click("propertyproject_icon_CSS");

				// wait for the element
				explicitWaitClickable("menubtn_CSS");

				// click on the burger menu
				click("menubtn_CSS");

				// wait for the element
				Thread.sleep(5000);

				// click on the CAPEX Projects
				click("propertyproject_capexprojectsoption_XPATH");

				// ADD RECORD - CAPEX Projects
				title("ADD RECORD - CAPEX Projects");

				// click on the add button
				click("propertyproject_mu_addbtn_CSS");

				// enter the project number
				type("propertyproject_cp_projectnumbertxt_CSS", data.get("project_number2"));

				// select the engineering company
				select("propertyproject_cp_engineeringcompanydd_CSS", data.get("engineering_company"));

				// click on the data received field
				click("propertyproject_cp_datereceived_CSS");

				// click on the today button
				click("propertyproject_cp_datereceived_todaybtn_XPATH");

				// click on the save button
				click("propertyproject_cp_savebtn_CSS");

				// wait for the element
				explicitWaitClickable("closetoastmsg_CSS");

				// click on the toaster close button
				click("closetoastmsg_CSS");

				// wait for the element
				explicitWaitClickable("propertyproject_cp_cancelbtn_CSS");

				// click on the cancel button
				click("propertyproject_cp_cancelbtn_CSS");

				// verification of the CAPEX Projects is added or not
				switchVerification("propertyproject_cp_addedcapexprojects2_ss1_XPATH", "CAPEXPROJECTSTWO2021",
						"CAPEX Projects is not displayed successfully.");

			} catch (Throwable t) {
				verificationFailed();
			}

			// VERIFY THE ROLE ABLE TO UPDATE THE CAPEX Projects DETAILS OR NOT
			title("VERIFY THE ROLE ABLE TO UPDATE THE CAPEX Projects DETAILS OR NOT");

			// UPDATE CAPEX Projects - CONTRACTOR - JINESHCONTRACTOR
			title("UPDATE CAPEX Projects - CONTRACTOR - JINESHCONTRACTOR");

			try {

				// click on the newly created CAPEX Projects
				click("propertyproject_cp_addedcapexprojects2_ss1_XPATH");

				// update the title of the project number
				type("propertyproject_cp_projectnumbertxt_CSS", data.get("update_project_number2"));

				// update the title of the project number
				type("propertyproject_cp_projectnumbertxt_CSS", data.get("project_number2"));

				// click on the update button
				click("propertyproject_cp_updatebtn_CSS");

				// wait for the element
				explicitWaitClickable("closetoastmsg_CSS");

				// click on the toaster close button
				click("closetoastmsg_CSS");

				verificationFailedMessage("The user able to update the CAPEX Projects details without the Access.");

			} catch (Throwable t) {
				successMessage("The user not able to update the CAPEX Projects details as expected.");

				// click on the cancel button
				click("propertyproject_cp_cancelbtn_CSS");

			}

			// VERIFY THE ROLE ABLE TO DELETE THE CAPEX Projects DETAILS OR NOT
			title("VERIFY THE ROLE ABLE TO DELETE THE CAPEX Projects DETAILS OR NOT");

			// DELETE CAPEX Projects - CONTRACTOR - JINESHCONTRACTOR
			title("DELETE CAPEX Projects - CONTRACTOR - JINESHCONTRACTOR");

			try {

				boolean mu2 = driver.findElement(By.cssSelector(OR.getProperty("propertyproject_cp_deletebtn_CSS")))
						.isDisplayed();

				if (mu2 == true) {
					verificationFailedMessage(
							"The delete button is displayed in the CAPEX Projects without the Access.");
				}
			} catch (Throwable t) {
				successMessage("The user not able to delete the CAPEX Projects details as expected.");

			}

			// click on the home icon from the top of the screen
			click("questionnaire_homeburgermenubtn_hide_CSS");

			// wait for the element
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

			// VERIFY THE ADD, EDIT AND DELETE ACCESS IN THE CONTRACTOR ROLE
			title("VERIFY THE ADD, EDIT AND DELETE ACCESS IN THE CONTRACTOR ROLE");

			// LOGIN IN JINESH HR USER
			title("LOGIN IN JINESH HR USER");

			helper.loginAndUpdateSystemCompany(data, "username_3", "password_3", "system_company_1");

			// VERIFY THE JINESH HR ABLE TO ADD THE CAPEX Projects DETAILS OR NOT
			title("VERIFY THE JINESH HR ABLE TO ADD THE CAPEX Projects DETAILS OR NOT");

			// ADD CAPEX Projects - JINESH HR
			title("ADD CAPEX Projects - JINESH HR");

			try {
				// click on the property project icon from the property list page
				click("propertyproject_icon_CSS");

				// wait for the element
				explicitWaitClickable("menubtn_CSS");

				// click on the burger menu
				click("menubtn_CSS");

				// wait for the element
				Thread.sleep(5000);

				// click on the CAPEX Projects
				click("propertyproject_capexprojectsoption_XPATH");

				// ADD RECORD - CAPEX Projects

				try {
					// click on the add button
					click("propertyproject_cp_addbtn_CSS");

					// click on the cancel button
					click("propertyproject_cp_cancelbtn_CSS");

					verificationFailedMessage("The user able to add the CAPEX Projects details without the Access");

				} catch (Throwable t) {
					successMessage("The user not able to add the CAPEX Projects details as expected");
				}

			} catch (Throwable t) {
				verificationFailed();
			}

			// VERIFY THE JINESH HR ABLE TO UPDATE THE CAPEX Projects DETAILS OR NOT
			title("VERIFY THE JINESH HR ABLE TO UPDATE THE CAPEX Projects DETAILS OR NOT");

			// UPDATE CAPEX Projects - JINESH HR
			title("UPDATE CAPEX Projects - JINESH HR");

			try {

				// click on the newly created CAPEX Projects
				click("propertyproject_cp_addedcapexprojects2_ss1_XPATH");

				// update the title of the project number
				type("propertyproject_cp_projectnumbertxt_CSS", data.get("update_project_number3"));

				// update the title of the project number
				type("propertyproject_cp_projectnumbertxt_CSS", data.get("project_number3"));

				// click on the update button
				click("propertyproject_cp_updatebtn_CSS");

				// wait for the element
				explicitWaitClickable("closetoastmsg_CSS");

				// click on the toaster close button
				click("closetoastmsg_CSS");

				verificationFailedMessage("The user able to update the CAPEX Projects details without the Access.");

			} catch (Throwable t) {
				successMessage("The user not able to update the CAPEX Projects details as expected.");

				// click on the cancel button
				click("propertyproject_cp_cancelbtn_CSS");

			}

			// VERIFY THE ROLE ABLE TO DELETE THE CAPEX Projects DETAILS OR NOT
			title("VERIFY THE ROLE ABLE TO DELETE THE CAPEX Projects DETAILS OR NOT");

			// DELETE CAPEX Projects - JINESH HR
			title("DELETE CAPEX Projects - JINESH HR");

			try {

				boolean mu3 = driver.findElement(By.cssSelector(OR.getProperty("propertyproject_cp_deletebtn_CSS")))
						.isDisplayed();

				if (mu3 == true) {
					verificationFailedMessage(
							"The delete button is displayed in the CAPEX Projects without the Access.");
				}
			} catch (Throwable t) {
				successMessage("The user not able to delete the CAPEX Projects details as expected.");
			}

			// click on the home icon from the top of the screen
			click("questionnaire_homeburgermenubtn_hide_CSS");

			// wait for the element
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

			// LOGIN IN AUTOMATION TESTER USER
			title("LOGIN IN AUTOMATION TESTER USER");

			helper.loginAndUpdateSystemCompany(data, "username_1", "password_1", "system_company_1");

		} catch (Throwable t) {
			helper.questionnaireNotDisplayLogout(data);
		}

		// DELETE THE CREATED CAPEX Projects AND RESET THE GIVEN PERMISSIONS
		title("DELETE THE CREATED CAPEX Projects AND RESET THE GIVEN PERMISSIONS");

		try {
			// click on the property project icon from the property list page
			click("propertyproject_icon_CSS");

			// wait for the element
			explicitWaitClickable("menubtn_CSS");

			// click on the burger menu
			click("menubtn_CSS");

			// wait for the element
			Thread.sleep(5000);

			// click on the CAPEX Projects
			click("propertyproject_capexprojectsoption_XPATH");

			// DELETE THE CREATED CAPEX Projects
			title("DELETE THE CREATED CAPEX Projects");

			// click on the delete button of the newly created CAPEX Projects
			List<WebElement> links = driver.findElements(By.xpath("//tr"));
			int count = links.size();
			consoleMessage("Number of links are:" + count);

			for (int i = 0; i < count - 1; i++) {

				// wait for the element
				explicitWaitClickable("propertyproject_cp_deletebtn_CSS");

				// delete the all the CAPEX Projects
				click("propertyproject_cp_deletebtn_CSS");

				// wait for the element
				explicitWaitClickable("propertyproject_cp_confirmationdeletebtn_CSS");

				// click on the delete button of confirmation
				click("propertyproject_cp_confirmationdeletebtn_CSS");

				// wait for the element
				explicitWaitClickable("closetoastmsg_CSS");

				// click on the toaster close button
				click("closetoastmsg_CSS");

			}

			// verify newly created CAPEX Projects - JINESH is deleted or not
			helper.deleteVerification("propertyproject_cp_addedcapexprojects_ss1_XPATH", "CAPEXPROJECTSONE2021");

			// verify newly created CAPEX Projects - JINESHCONTRACTOR is deleted or
			// not
			helper.deleteVerification("propertyproject_cp_addedcapexprojects2_ss1_XPATH", "CAPEXPROJECTSTWO2021");

			// verify newly created CAPEX Projects - JINESHHR is deleted or not
			helper.deleteVerification("propertyproject_cp_addedcapexprojects3_ss1_XPATH", "CAPEXPROJECTSTHREE2021");

		} catch (Throwable t) {
			verificationFailed();
		}

		// click on the home icon from the top of the screen
		click("questionnaire_homeburgermenubtn_hide_CSS");

		// wait for the element
		explicitWait("propertylist_title_XPATH");

		// verify the property list
		switchVerification("propertylist_title_XPATH", "Property List", "The property list is not displayed.");

		// RESET THE APPLIED PERMISSIONS
		title("RESET THE APPLIED PERMISSIONS");

		try {

			// wait for the element
			explicitWaitClickable("questionnaire_settingicon_CSS");

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

			// RESET THE VIEW CAPEX Projects PERMISSION
			helper.resetPermission(data, "security_setting_5", "propertyproject_securitysettings5_XPATH");

			// RESET THE ADD CAPEX Projects PERMISSION
			helper.resetPermission(data, "security_setting_6", "propertyproject_securitysettings6_XPATH");

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