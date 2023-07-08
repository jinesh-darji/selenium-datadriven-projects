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

public class RR4904PropertyProjectTwoTest extends TestBase {

	@Test(dataProviderClass = TestUtil.class, dataProvider = "dp")
	public void rR4904PropertyProjectTwoTest(Hashtable<String, String> data) throws IOException, InterruptedException {

		execution(data, "rR4904PropertyProjectTwoTest");

		// APPLY THE SECURITY SETTING OF THE EDIT CAPEX PROJECTS PERMISSION TO THE
		// ASSIGNED USER/ROLE AND THE RESPECTIVE USER/ROLE MUST HAVE ONLY GRANTED
		// PERMISSION TO PERFORM ACTIONS.
		title("APPLY THE SECURITY SETTING OF THE EDIT CAPEX PROJECTS PERMISSION TO THE ASSIGNED USER/ROLE AND THE RESPECTIVE USER/ROLE MUST HAVE ONLY GRANTED PERMISSION TO PERFORM ACTIONS.");

		Helper helper = new Helper();

		// refresh the page
		driver.navigate().refresh();
		Thread.sleep(5000);
		driver.navigate().refresh();

		// EDIT SECURITY SETTINGS OF VIEW / EDIT CAPEX PROJECTS TO USER/ROLE ACCESS
		title("EDIT SECURITY SETTINGS OF VIEW / EDIT CAPEX PROJECTS TO USER/ROLE ACCESS");

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

			// APPLY THE ADD CAPEX PROJECTS PERMISSION
			helper.addPermissionOneUsersRole(data, "security_setting_6", "propertyproject_securitysettings6_XPATH");

			// APPLY THE REMOVE CAPEX PROJECTS PERMISSION
			helper.addPermissionOneUsersRole(data, "security_setting_7", "propertyproject_securitysettings7_XPATH");

			// RESET THE DELETE CAPEX PROJECTS PERMISSION
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

				// click on the CAPEX PROJECTS
				click("propertyproject_capexprojectsoption_XPATH");

				// ADD RECORD - CAPEX PROJECTS
				title("ADD CAPEX PROJECTS - JINESH");

				// click on the add button
				click("propertyproject_mu_addbtn_CSS");

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
				explicitWaitClickable("propertyproject_cp_cancelbtn_CSS");

				// click on the cancel button
				click("propertyproject_cp_cancelbtn_CSS");

				// verification of the CAPEX Projects is added or not
				switchVerification("propertyproject_cp_addedcapexprojects_editss1_XPATH", "CAPEXPROJECTSEDITONE2021",
						"CAPEX Projects is not displayed successfully.");

			} catch (Throwable t) {
				verificationFailed();
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

			// VERIFY THE CONTRACTOR - JINESHCONTRACTOR ABLE TO ADD THE CAPEX PROJECTS
			// DETAILS OR NOT
			title("VERIFY THE CONTRACTOR - JINESHCONTRACTOR ABLE TO ADD THE CAPEX PROJECTS DETAILS OR NOT");

			// ADD CAPEX PROJECTS - CONTRACTOR - JINESHCONTRACTOR
			title("ADD CAPEX PROJECTS - CONTRACTOR - JINESHCONTRACTOR");

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

				// ADD RECORD - CAPEX PROJECTS
				title("ADD RECORD - CAPEX PROJECTS");

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
				switchVerification("propertyproject_cp_addedcapexprojects2_editss1_XPATH", "CAPEXPROJECTSEDITTWO2021",
						"CAPEX Projects is not displayed successfully.");

			} catch (Throwable t) {
				verificationFailed();
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

		// REMOVE THE ADD CAPEX PROJECTS PERMISSION
		title("REMOVE THE ADD CAPEX PROJECTS PERMISSION");

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

		// wait for the element
		explicitWaitClickable("questionnaire_settingicon_CSS");

		// click on the settings icon from the top of the screen
		click("questionnaire_settingicon_CSS");

		// wait for the element
		explicitWaitClickable("sidemenu_logout_CSS");

		// click on the logout option from the side menu
		click("sidemenu_logout_CSS");

		try {
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

				// click on the CAPEX Projects
				click("propertyproject_capexprojectsoption_XPATH");

				// ADD RECORD - CAPEX PROJECTS
				title("ADD RECORD - CAPEX PROJECTS");

				try {

					boolean addBtn1 = driver
							.findElement(By.cssSelector(OR.getProperty("propertyproject_cp_addbtn_CSS"))).isDisplayed();

					if (addBtn1 == true) {
						verificationFailedMessage(
								"The add button is displayed in the CAPEX Projects without the Access.");
					}
				} catch (Throwable t) {
					successMessage("The add button is not displayed in the CAPEX Projects as expected.");

				}
			} catch (Throwable t) {
				verificationFailed();
			}

			// VERIFY THE USER ABLE TO UPDATE THE CAPEX PROJECTS DETAILS OR NOT
			title("VERIFY THE USER ABLE TO UPDATE THE CAPEX PROJECTS DETAILS OR NOT");

			// UPDATE CAPEX PROJECTS - JINESH
			title("UPDATE CAPEX PROJECTS - JINESH");

			try {

				// click on the newly created CAPEX Projects
				click("propertyproject_cp_addedcapexprojects_editss1_XPATH");

				// update the title of the project number
				type("propertyproject_cp_projectnumbertxt_CSS", data.get("update_project_number"));

				// click on the update button
				click("propertyproject_cp_updatebtn_CSS");

				// wait for the element
				explicitWaitClickable("closetoastmsg_CSS");

				// click on the toaster close button
				click("closetoastmsg_CSS");

				// verify the updated mortgage project
				switchVerification("propertyproject_cp_updatedcapexprojects_editss1_XPATH",
						"UPDATECAPEXPROJECTSEDITONE2021", "The UPDATECAPEXPROJECTSEDITONE2021 is not displayed.");

				successMessage("The user able to update the CAPEX Projects details as expected.");

			} catch (Throwable t) {
				verificationFailedMessage("The user not able to update the CAPEX Projects details with the Access.");
			}

			// VERIFY THE USER ABLE TO DELETE THE CAPEX PROJECTS DETAILS OR NOT
			title("VERIFY THE USER ABLE TO DELETE THE CAPEX PROJECTS DETAILS OR NOT");

			// DELETE CAPEX PROJECTS - JINESH
			title("DELETE CAPEX PROJECTS - JINESH");

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

			// click on the home icon
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

			// VERIFY THE ADD, EDIT AND DELETE ACCESS IN THE JINESH CONTRACTOR USER
			title("VERIFY THE ADD, EDIT AND DELETE ACCESS IN THE JINESH CONTRACTOR USER");

			// LOGIN IN JINESH CONTRACTOR USER
			title("LOGIN IN JINESH CONTRACTOR USER");

			helper.loginAndUpdateSystemCompany(data, "username_2", "password_2", "system_company_1");

			// VERIFY THE JINESH CONTRACTOR ABLE TO ADD THE CAPEX PROJECTS DETAILS OR
			// NOT
			title("VERIFY THE JINESH CONTRACTOR ABLE TO ADD THE CAPEX PROJECTS DETAILS OR NOT");

			try {
				// ADD CAPEX PROJECTS - JINESH CONTRACTOR
				title("ADD CAPEX PROJECTS - JINESH CONTRACTOR");

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

				// ADD RECORD - CAPEX PROJECTS
				title("ADD RECORD - CAPEX PROJECTS");

				try {

					boolean addBtn2 = driver
							.findElement(By.cssSelector(OR.getProperty("propertyproject_cp_addbtn_CSS"))).isDisplayed();

					if (addBtn2 == true) {

						verificationFailedMessage(
								"The add button is displayed in the CAPEX Projects without the Access");

					}
				} catch (Throwable t) {
					successMessage("The add button is not displayed in the CAPEX Projects as expected.");
				}

			} catch (Throwable t) {
				verificationFailed();
			}

			// VERIFY THE USER ABLE TO UPDATE THE CAPEX PROJECTS DETAILS OR NOT
			title("VERIFY THE USER ABLE TO UPDATE THE CAPEX PROJECTS DETAILS OR NOT");

			// UPDATE CAPEX PROJECTS - JINESH CONTRACTOR
			title("UPDATE CAPEX PROJECTS - JINESH CONTRACTOR");

			try {

				// click on the newly created CAPEX Projects
				click("propertyproject_cp_addedcapexprojects2_editss1_XPATH");

				// update the title of the project number
				type("propertyproject_cp_projectnumbertxt_CSS", data.get("update_project_number2"));

				// click on the update button
				click("propertyproject_cp_updatebtn_CSS");

				// wait for the element
				explicitWaitClickable("closetoastmsg_CSS");

				// click on the toaster close button
				click("closetoastmsg_CSS");

				// verify the updated mortgage project
				switchVerification("propertyproject_cp_updatedcapexprojects2_editss1_XPATH",
						"UPDATECAPEXPROJECTSEDITTWO2021", "The UPDATECAPEXPROJECTSEDITTWO2021 is not displayed.");

				successMessage("The user able to update the CAPEX Projects details as expected.");

			} catch (Throwable t) {
				verificationFailedMessage("The user not able to update the CAPEX Projects details with the Access.");
			}

			// VERIFY THE USER ABLE TO DELETE THE CAPEX PROJECTS DETAILS OR NOT
			title("VERIFY THE USER ABLE TO DELETE THE CAPEX PROJECTS DETAILS OR NOT");

			// DELETE CAPEX PROJECTS - JINESH CONTRACTOR
			title("DELETE CAPEX PROJECTS - JINESH CONTRACTOR");

			try {

				boolean mu2 = driver.findElement(By.cssSelector(OR.getProperty("propertyproject_cp_deletebtn_CSS")))
						.isDisplayed();

				if (mu2 == true) {
					verificationFailedMessage(
							"The delete button is displayed in the CAPEX Projects without the Access.");
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

			// VERIFY THE ADD, EDIT AND DELETE ACCESS IN THE JINESH HR
			title("VERIFY THE ADD, EDIT AND DELETE ACCESS IN THE JINESH HR");

			// LOGIN IN JINESH HR USER
			title("LOGIN IN JINESH HR USER");

			helper.loginAndUpdateSystemCompany(data, "username_3", "password_3", "system_company_1");

			// VERIFY THE JINESH HR ABLE TO ADD THE CAPEX PROJECTS DETAILS OR NOT
			title("VERIFY THE JINESH HR ABLE TO ADD THE CAPEX PROJECTS DETAILS OR NOT");

			// ADD CAPEX PROJECTS - JINESH HR
			title("ADD CAPEX PROJECTS - JINESH HR");

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

				// ADD RECORD - CAPEX PROJECTS
				title("ADD RECORD - CAPEX PROJECTS");

				try {

					boolean addBtn3 = driver
							.findElement(By.cssSelector(OR.getProperty("propertyproject_cp_addbtn_CSS"))).isDisplayed();

					if (addBtn3 == true) {
						verificationFailedMessage(
								"The add button is displayed in the CAPEX Projects without the Access.");
					}
				} catch (Throwable t) {
					successMessage("The add button is not displayed in the CAPEX Projects as expected");
				}

			} catch (Throwable t) {
				verificationFailed();
			}

			// VERIFY THE JINESH HR ABLE TO UPDATE THE CAPEX PROJECTS DETAILS OR NOT
			title("VERIFY THE JINESH HR ABLE TO UPDATE THE CAPEX PROJECTS DETAILS OR NOT");

			// UPDATE CAPEX PROJECTS - JINESH HR
			title("UPDATE CAPEX PROJECTS - JINESH HR");

			try {

				// click on the newly created CAPEX Projects
				click("propertyproject_cp_updatedcapexprojects2_editss1_XPATH");

				// update the title of the project number
				type("propertyproject_cp_projectnumbertxt_CSS", data.get("update_project_number3"));

				// click on the update button
				click("propertyproject_cp_updatebtn_CSS");

				// wait for the element
				explicitWaitClickable("closetoastmsg_CSS");

				// click on the toaster close button
				click("closetoastmsg_CSS");

				verificationFailedMessage("The user able to update the CAPEX Projects details without the Access");

			} catch (Throwable t) {
				successMessage("The user not able to update the CAPEX Projects details as expected");

				// click on the cancel button
				click("propertyproject_cp_cancelbtn_CSS");

			}

			// VERIFY THE ROLE ABLE TO DELETE THE CAPEX PROJECTS DETAILS OR NOT
			title("VERIFY THE ROLE ABLE TO DELETE THE CAPEX PROJECTS DETAILS OR NOT");

			// DELETE CAPEX PROJECTS - JINESH HR
			title("DELETE CAPEX PROJECTS - JINESH HR");

			try {

				boolean mu3 = driver.findElement(By.cssSelector(OR.getProperty("propertyproject_cp_deletebtn_CSS")))
						.isDisplayed();

				if (mu3 == true) {

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

			// LOGIN IN AUTOMATION TESTER USER
			title("LOGIN IN AUTOMATION TESTER USER");

			helper.loginAndUpdateSystemCompany(data, "username_1", "password_1", "system_company_1");

		} catch (Throwable t) {
			helper.questionnaireNotDisplayLogout(data);
		}

		// DELETE THE CREATED CAPEX PROJECTS AND RESET THE GIVEN PERMISSIONS
		title("DELETE THE CREATED CAPEX PROJECTS AND RESET THE GIVEN PERMISSIONS");

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

			// DELETE THE CREATED CAPEX PROJECTS
			title("DELETE THE CREATED CAPEX PROJECTS");

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

			// verify newly created CAPEX PROJECTS - JINESH is deleted or not
			helper.deleteVerification("propertyproject_cp_addedcapexprojects_editss1_XPATH",
					"CAPEXPROJECTSEDITONE2021");

			// verify newly created CAPEX PROJECTS - JINESHCONTRACTOR is deleted or
			// not
			helper.deleteVerification("propertyproject_cp_addedcapexprojects2_editss1_XPATH",
					"CAPEXPROJECTSEDITTWO2021");

			// verify newly created CAPEX PROJECTS - JINESHHR is deleted or not
			helper.deleteVerification("propertyproject_cp_addedcapexprojects3_editss1_XPATH",
					"CAPEXPROJECTSEDITTHREE2021");

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

			// RESET THE VIEW CAPEX PROJECTS PERMISSION
			helper.resetPermission(data, "security_setting_5", "propertyproject_securitysettings5_XPATH");

			// RESET THE EDIT CAPEX PROJECTS PERMISSION
			helper.resetPermission(data, "security_setting_7", "propertyproject_securitysettings7_XPATH");

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
