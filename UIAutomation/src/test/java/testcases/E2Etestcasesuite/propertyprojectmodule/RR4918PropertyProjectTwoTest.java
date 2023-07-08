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

public class RR4918PropertyProjectTwoTest extends TestBase {

	@Test(dataProviderClass = TestUtil.class, dataProvider = "dp")
	public void rR4918PropertyProjectTwoTest(Hashtable<String, String> data) throws IOException, InterruptedException {

		execution(data, "rR4918PropertyProjectTwoTest");

		// APPLY THE SECURITY SETTING TO MUNICIPAL ORDERS OF THE USER/ROLE ACCESS TO
		// THIS MUST ONLY HAVE PERMISSION TO PERFORM ACTIONS - EDIT.
		title("APPLY THE SECURITY SETTING TO MUNICIPAL ORDERS OF THE USER/ROLE ACCESS TO THIS MUST ONLY HAVE PERMISSION TO PERFORM ACTIONS - EDIT.");

		Helper helper = new Helper();

		// refresh the page
		driver.navigate().refresh();
		Thread.sleep(5000);
		driver.navigate().refresh();

		// EDIT SECURITY SETTINGS OF VIEW / EDIT MUNICIPAL ORDERS TO USER/ROLE ACCESS
		title("EDIT SECURITY SETTINGS OF VIEW / EDIT MUNICIPAL ORDERS TO USER/ROLE ACCESS");

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

			// APPLY THE VIEW MUNICIPAL ORDERS PERMISSION
			helper.addPermissionTwoUsersRole(data, "security_setting_9", "propertyproject_securitysettings9_XPATH");

			// APPLY THE ADD MUNICIPAL ORDERS PERMISSION
			helper.addPermissionOneUsersRole(data, "security_setting_10", "propertyproject_securitysettings10_XPATH");

			// APPLY THE EDIT MUNICIPAL ORDERS PERMISSION
			helper.addPermissionOneUsersRole(data, "security_setting_11", "propertyproject_securitysettings11_XPATH");

			// RESET THE DELETE MUNICIPAL ORDERS PERMISSION
			helper.resetPermission(data, "security_setting_12", "propertyproject_securitysettings12_XPATH");

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
			Thread.sleep(5000);

			// click on the logout option from the side menu
			click("sidemenu_logout_CSS");

			// VERIFY THE ADD, EDIT AND DELETE ACCESS IN THE JINESH USER
			title("VERIFY THE ADD, EDIT AND DELETE ACCESS IN THE JINESH USER");

			// LOGIN IN JINESH USER
			title("LOGIN IN JINESH USER");

			helper.loginAndUpdateSystemCompany(data, "username", "password", "system_company_1");

			// VERIFY THE JINESH ABLE TO ADD THE MUNICIPAL ORDERS DETAILS OR NOT
			title("VERIFY THE JINESH ABLE TO ADD THE MUNICIPAL ORDERS DETAILS OR NOT");

			// ADD MUNICIPAL ORDERS - JINESH
			title("ADD MUNICIPAL ORDERS - JINESH");

			try {

				// click on the property project icon from the property list page
				click("propertyproject_icon_CSS");

				// wait for the element
				explicitWaitClickable("menubtn_CSS");

				// click on the burger menu
				click("menubtn_CSS");

				// wait for the element
				Thread.sleep(5000);

				// click on the MUNICIPAL ORDERS
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
				explicitWaitClickable("propertyproject_mo_cancelbtn_CSS");

				// click on the cancel button
				click("propertyproject_mo_cancelbtn_CSS");

				// verification of the Municipal Orders is added or not
				switchVerification("propertyproject_mo_addedmunicipalorders_editss1_XPATH",
						"MUNICIPALORDERSEDITONE2021", "Municipal Orders is not displayed successfully.");

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

			// VERIFY THE CONTRACTOR - JINESHCONTRACTOR ABLE TO ADD THE MUNICIPAL ORDERS
			// DETAILS OR NOT
			title("VERIFY THE CONTRACTOR - JINESHCONTRACTOR ABLE TO ADD THE MUNICIPAL ORDERS DETAILS OR NOT");

			// ADD MUNICIPAL ORDERS - CONTRACTOR - JINESHCONTRACTOR
			title("ADD MUNICIPAL ORDERS - CONTRACTOR - JINESHCONTRACTOR");

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
				type("propertyproject_mo_projectnumbertxt_CSS", data.get("project_reference2"));

				// select the Municipality
				select("propertyproject_mo_municipalitydd_CSS", data.get("municipality"));

				// click on the save button
				click("propertyproject_mo_savebtn_CSS");

				// wait for the element
				explicitWaitClickable("closetoastmsg_CSS");

				// click on the toaster close button
				click("closetoastmsg_CSS");

				// wait for the element
				explicitWaitClickable("propertyproject_mo_cancelbtn_CSS");

				// click on the cancel button
				click("propertyproject_mo_cancelbtn_CSS");

				// verification of the Municipal Orders is added or not
				switchVerification("propertyproject_mo_addedmunicipalorders2_editss1_XPATH",
						"MUNICIPALORDERSEDITTWO2021", "Municipal Orders is not displayed successfully.");

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

		// REMOVE THE ADD MUNICIPAL ORDERS PERMISSION
		title("REMOVE THE ADD MUNICIPAL ORDERS PERMISSION");

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

			helper.resetPermission(data, "security_setting_10", "propertyproject_securitysettings10_XPATH");

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

		// VERIFY THE ADD, EDIT AND DELETE ACCESS IN THE JINESH USER
		title("VERIFY THE ADD, EDIT AND DELETE ACCESS IN THE JINESH USER");

		try {
			// LOGIN IN JINESH USER
			title("LOGIN IN JINESH USER");

			helper.loginAndUpdateSystemCompany(data, "username", "password", "system_company_1");

			// VERIFY THE JINESH ABLE TO ADD THE MUNICIPAL ORDERS DETAILS OR NOT
			title("VERIFY THE JINESH ABLE TO ADD THE MUNICIPAL ORDERS DETAILS OR NOT");

			// ADD MUNICIPAL ORDERS - JINESH
			title("ADD MUNICIPAL ORDERS - JINESH");

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
				title("ADD MUNICIPAL ORDERS - JINESH");

				try {

					boolean addBtn1 = driver
							.findElement(By.cssSelector(OR.getProperty("propertyproject_mo_addbtn_CSS"))).isDisplayed();

					if (addBtn1 == true) {
						verificationFailedMessage(
								"The add button is displayed in the Municipal Orders without the Access");
					}
				} catch (Throwable t) {
					successMessage("The add button is not displayed in the Municipal Orders as expected.");
				}
			} catch (Throwable t) {
				verificationFailed();
			}

			// VERIFY THE USER ABLE TO UPDATE THE MUNICIPAL ORDERS DETAILS OR NOT
			title("VERIFY THE USER ABLE TO UPDATE THE MUNICIPAL ORDERS DETAILS OR NOT");

			// UPDATE MUNICIPAL ORDERS - JINESH
			title("UPDATE MUNICIPAL ORDERS - JINESH");

			try {

				// click on the newly created Municipal Orders
				click("propertyproject_mo_addedmunicipalorders_editss1_XPATH");

				// update the title of the project number
				type("propertyproject_mo_projectnumbertxt_CSS", data.get("update_project_reference"));

				// click on the update button
				click("propertyproject_mo_updatebtn_CSS");

				// wait for the element
				explicitWaitClickable("closetoastmsg_CSS");

				// click on the toaster close button
				click("closetoastmsg_CSS");

				// verify the updated mortgage project
				switchVerification("propertyproject_mo_updatedmunicipalorders_editss1_XPATH",
						"UPDATEMUNICIPALORDERSEDITONE2021", "The UPDATEMUNICIPALORDERSEDITONE2021 is not displayed.");

				successMessage("The user able to update the Municipal Orders details as expected.");

			} catch (Throwable t) {
				verificationFailedMessage("The user not able to update the Municipal Orders details with the Access.");
			}

			// VERIFY THE USER ABLE TO DELETE THE MUNICIPAL ORDERS DETAILS OR NOT
			title("VERIFY THE USER ABLE TO DELETE THE MUNICIPAL ORDERS DETAILS OR NOT");

			// DELETE MUNICIPAL ORDERS - JINESH
			title("DELETE MUNICIPAL ORDERS - JINESH");

			try {

				boolean mu1 = driver.findElement(By.cssSelector(OR.getProperty("propertyproject_mo_deletebtn_CSS")))
						.isDisplayed();

				if (mu1 == true) {
					verificationFailedMessage(
							"The delete button is displayed in the Municipal Orders without the Access.");
				}
			} catch (Throwable t) {
				successMessage("The user not able to delete the Municipal Orders details as expected.");

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

			// VERIFY THE JINESH CONTRACTOR ABLE TO ADD THE MUNICIPAL ORDERS DETAILS OR NOT
			title("VERIFY THE JINESH CONTRACTOR ABLE TO ADD THE MUNICIPAL ORDERS DETAILS OR NOT");

			// ADD MUNICIPAL ORDERS - JINESH CONTRACTOR
			title("ADD MUNICIPAL ORDERS - JINESH CONTRACTOR");

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

				try {

					boolean addBtn2 = driver
							.findElement(By.cssSelector(OR.getProperty("propertyproject_mo_addbtn_CSS"))).isDisplayed();

					if (addBtn2 == true) {
						verificationFailedMessage(
								"The add button is displayed in the Municipal Orders without the Access.");
					}
				} catch (Throwable t) {
					successMessage("The add button is not displayed in the Municipal Orders as expected.");
				}

			} catch (Throwable t) {
				verificationFailed();
			}

			// VERIFY THE USER ABLE TO UPDATE THE MUNICIPAL ORDERS DETAILS OR NOT
			title("VERIFY THE USER ABLE TO UPDATE THE MUNICIPAL ORDERS DETAILS OR NOT");

			// UPDATE MUNICIPAL ORDERS - JINESH CONTRACTOR
			title("UPDATE MUNICIPAL ORDERS - JINESH CONTRACTOR");

			try {

				// click on the newly created Municipal Orders
				click("propertyproject_mo_addedmunicipalorders2_editss1_XPATH");

				// update the title of the project number
				type("propertyproject_mo_projectnumbertxt_CSS", data.get("update_project_reference2"));

				// click on the update button
				click("propertyproject_mo_updatebtn_CSS");

				// wait for the element
				explicitWaitClickable("closetoastmsg_CSS");

				// click on the toaster close button
				click("closetoastmsg_CSS");

				// verify the updated mortgage project
				switchVerification("propertyproject_mo_updatedmunicipalorders2_editss1_XPATH",
						"UPDATEMUNICIPALORDERSEDITTWO2021", "The UPDATEMUNICIPALORDERSEDITTWO2021 is not displayed.");

				successMessage("The user able to update the Municipal Orders details as expected.");

			} catch (Throwable t) {
				verificationFailedMessage("The user not able to update the Municipal Orders details with the Access.");
			}

			// VERIFY THE USER ABLE TO DELETE THE MUNICIPAL ORDERS DETAILS OR NOT
			title("VERIFY THE USER ABLE TO DELETE THE MUNICIPAL ORDERS DETAILS OR NOT");

			// DELETE MUNICIPAL ORDERS - JINESH CONTRACTOR
			title("DELETE MUNICIPAL ORDERS - JINESH CONTRACTOR");

			try {

				boolean mu2 = driver.findElement(By.cssSelector(OR.getProperty("propertyproject_mo_deletebtn_CSS")))
						.isDisplayed();

				if (mu2 == true) {
					verificationFailedMessage(
							"The delete button is displayed in the Municipal Orders without the Access.");
				}

			} catch (Throwable t) {
				successMessage("The user not able to delete the Municipal Orders details as expected");
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

			// VERIFY THE JINESH HR ABLE TO ADD THE MUNICIPAL ORDERS DETAILS OR NOT
			title("VERIFY THE JINESH HR ABLE TO ADD THE MUNICIPAL ORDERS DETAILS OR NOT");

			// ADD MUNICIPAL ORDERS - JINESH HR
			title("ADD MUNICIPAL ORDERS - JINESH HR");

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
				try {

					boolean addBtn3 = driver
							.findElement(By.cssSelector(OR.getProperty("propertyproject_mo_addbtn_CSS"))).isDisplayed();

					if (addBtn3 == true) {
						verificationFailedMessage(
								"The add button is displayed in the Municipal Orders without the Access.");
					}
				} catch (Throwable t) {
					successMessage("The add button is not displayed in the Municipal Orders as expected.");
				}

			} catch (Throwable t) {
				verificationFailed();
			}

			// VERIFY THE JINESH HR ABLE TO UPDATE THE MUNICIPAL ORDERS DETAILS OR NOT
			title("VERIFY THE JINESH HR ABLE TO UPDATE THE MUNICIPAL ORDERS DETAILS OR NOT");

			// UPDATE MUNICIPAL ORDERS - JINESH HR
			title("UPDATE MUNICIPAL ORDERS - JINESH HR");

			try {

				// click on the newly created Municipal Orders
				click("propertyproject_mo_updatedmunicipalorders2_editss1_XPATH");

				// update the title of the project number
				type("propertyproject_mo_projectnumbertxt_CSS", data.get("update_project_reference3"));

				// click on the update button
				click("propertyproject_mo_updatebtn_CSS");

				// wait for the element
				explicitWaitClickable("closetoastmsg_CSS");

				// click on the toaster close button
				click("closetoastmsg_CSS");

				verificationFailedMessage("The user able to update the Municipal Orders details without the Access.");

			} catch (Throwable t) {
				successMessage("The user not able to update the Municipal Orders details as expected");

				// click on the cancel button
				click("propertyproject_mo_cancelbtn_CSS");

			}

			// VERIFY THE ROLE ABLE TO DELETE THE MUNICIPAL ORDERS DETAILS OR NOT
			title("VERIFY THE ROLE ABLE TO DELETE THE MUNICIPAL ORDERS DETAILS OR NOT");

			// DELETE MUNICIPAL ORDERS - JINESH HR
			title("DELETE MUNICIPAL ORDERS - JINESH HR");

			try {

				boolean mu3 = driver.findElement(By.cssSelector(OR.getProperty("propertyproject_mo_deletebtn_CSS")))
						.isDisplayed();

				if (mu3 == true) {
					verificationFailedMessage(
							"The delete button is displayed in the Municipal Orders without the Access.");
				}

			} catch (Throwable t) {
				successMessage("The user not able to delete the Municipal Orders details as expected.");
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

		// DELETE THE CREATED MUNICIPAL ORDERS AND RESET THE GIVEN PERMISSIONS
		title("DELETE THE CREATED MUNICIPAL ORDERS AND RESET THE GIVEN PERMISSIONS");

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

			// DELETE THE CREATED MUNICIPAL ORDERS
			title("DELETE THE CREATED MUNICIPAL ORDERS");

			// click on the delete button of the newly created Municipal Orders
			List<WebElement> links = driver.findElements(By.xpath("//tr"));
			int count = links.size();
			consoleMessage("Number of links are:" + count);

			for (int i = 0; i < count - 1; i++) {

				// wait for the element
				explicitWaitClickable("propertyproject_mo_deletebtn_CSS");

				// delete the all the Municipal Orders
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

			// verify newly created MUNICIPAL ORDERS - JINESH is deleted or not
			helper.deleteVerification("propertyproject_mo_addedmunicipalorders_editss1_XPATH",
					"MUNICIPALORDERSEDITONE2021");

			// verify newly created MUNICIPAL ORDERS - JINESHCONTRACTOR is deleted or
			// not
			helper.deleteVerification("propertyproject_mo_addedmunicipalorders2_editss1_XPATH",
					"MUNICIPALORDERSEDITTWO2021");

			// verify newly created MUNICIPAL ORDERS - JINESHHR is deleted or not
			helper.deleteVerification("propertyproject_mo_addedmunicipalorders3_editss1_XPATH",
					"MUNICIPALORDERSEDITTHREE2021");

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

			// RESET THE VIEW MUNICIPAL ORDERS PERMISSION
			helper.resetPermission(data, "security_setting_9", "propertyproject_securitysettings9_XPATH");

			// RESET THE ADD MUNICIPAL ORDERS PERMISSION
			helper.resetPermission(data, "security_setting_10", "propertyproject_securitysettings10_XPATH");

			// RESET THE EDIT MUNICIPAL ORDERS PERMISSION
			helper.resetPermission(data, "security_setting_11", "propertyproject_securitysettings11_XPATH");

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