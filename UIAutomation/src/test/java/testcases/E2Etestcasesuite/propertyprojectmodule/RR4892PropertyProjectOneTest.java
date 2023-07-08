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

public class RR4892PropertyProjectOneTest extends TestBase {

	@Test(dataProviderClass = TestUtil.class, dataProvider = "dp")
	public void rR4892PropertyProjectOneTest(Hashtable<String, String> data) throws IOException, InterruptedException {

		execution(data, "rR4892PropertyProjectOneTest");

		// APPLY THE SECURITY SETTING OF THE ADD MORTGAGE UNDERTAKING PERMISSION TO THE
		// ASSIGNED USER/ROLE AND RESPECTIVE USER/ROLE MUST HAVE ONLY GRANTED PERMISSION
		// TO PERFORM ACTIONS.
		title("APPLY THE SECURITY SETTING OF THE ADD MORTGAGE UNDERTAKING PERMISSION TO THE ASSIGNED USER/ROLE AND RESPECTIVE USER/ROLE MUST HAVE ONLY GRANTED PERMISSION TO PERFORM ACTIONS.");

		Helper helper = new Helper();

		// refresh the page
		driver.navigate().refresh();
		Thread.sleep(5000);
		driver.navigate().refresh();

		// ADD SECURITY SETTINGS OF VIEW / ADD MORTGAGE UNDERTAKING TO USER/ROLE ACCESS
		title("ADD SECURITY SETTINGS OF VIEW / ADD MORTGAGE UNDERTAKING TO USER/ROLE ACCESS");

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

			// APPLY THE VIEW MORTGAGE UNDERTAKING PERMISSION
			helper.addPermissionTwoUsersRole(data, "security_setting_1", "propertyproject_securitysettings1_XPATH");

			// APPLY THE ADD MORTGAGE UNDERTAKING PERMISSION
			helper.addPermissionOneUsersRole(data, "security_setting_2", "propertyproject_securitysettings2_XPATH");

			// APPLY THE EDIT MORTGAGE UNDERTAKING PERMISSION
			helper.resetPermission(data, "security_setting_3", "propertyproject_securitysettings3_XPATH");

			// APPLY THE DELETE MORTGAGE UNDERTAKING PERMISSION
			helper.resetPermission(data, "security_setting_4", "propertyproject_securitysettings4_XPATH");

		} catch (Throwable t) {
			verificationFailed();
		}

		// click on the home icon
		click("questionnaire_homeburgermenubtn_CSS");

		// wait for the element
		explicitWait("propertylist_title_XPATH");

		// verify the property list
		switchVerification("propertylist_title_XPATH", "Property List", "The property list is not displayed.");

		// VERIFY THE ADD, EDIT AND DELETE ACCESS IN THE JINESH USER
		title("VERIFY THE ADD, EDIT AND DELETE ACCESS IN THE JINESH USER");

		try {

			// wait for the element
			explicitWaitClickable("questionnaire_settingicon_CSS");

			// click on the settings icon from the top of the screen
			click("questionnaire_settingicon_CSS");

			// wait for the element
			explicitWaitClickable("sidemenu_logout_CSS");

			// click on the logout option from the side menu
			click("sidemenu_logout_CSS");

			// LOGIN IN JINESH USER
			title("LOGIN IN JINESH USER");

			helper.loginAndUpdateSystemCompany(data, "username", "password", "system_company_1");

			// VERIFY THE JINESH ABLE TO ADD THE MORTGAGE UNDERTAKING DETAILS OR NOT
			title("VERIFY THE JINESH ABLE TO ADD THE MORTGAGE UNDERTAKING DETAILS OR NOT");

			try {

				// click on the property project icon from the property list page
				click("propertyproject_icon_CSS");

				// wait for the element
				explicitWaitClickable("menubtn_CSS");

				// click on the burger menu
				click("menubtn_CSS");

				// wait for the element
				Thread.sleep(5000);

				// click on the Mortgage Undertakings
				click("propertyproject_mortgageundertakingsoption_XPATH");

				// ADD RECORD - MORTGAGE UNDERTAKINGS
				title("ADD RECORD - MORTGAGE UNDERTAKINGS");

				// click on the add button
				click("propertyproject_mu_addbtn_CSS");

				// enter the undertaking number
				type("propertyproject_mu_undertakingnumbertxt_CSS", data.get("undertaking_number"));

				// select the lender
				select("propertyproject_mu_lenderdd_CSS", data.get("lender"));

				// click on the save button
				click("propertyproject_mu_savebtn_CSS");

				// wait for the element
				explicitWaitClickable("closetoastmsg_CSS");

				// click on the toaster close button
				click("closetoastmsg_CSS");

				// wait for the element
				explicitWaitClickable("propertyproject_mu_cancelbtn_CSS");

				// click on the cancel button
				click("propertyproject_mu_cancelbtn_CSS");

				// verification of the Mortgage Undertakings is added or not
				switchVerification("propertyproject_mu_addedmortgageundertakings_ss1_XPATH",
						"UNDERTAKINGPERMISSIONONE2021", "Mortgage Undertakings is not displayed successfully.");

			} catch (Throwable t) {
				verificationFailed();
			}

			// VERIFY THE USER ABLE TO UPDATE THE MORTGAGE UNDERTAKING DETAILS OR NOT
			title("VERIFY THE USER ABLE TO UPDATE THE MORTGAGE UNDERTAKING DETAILS OR NOT");

			try {

				// click on the newly created Mortgage Undertakings
				click("propertyproject_mu_addedmortgageundertakings_ss1_XPATH");

				// update the title of the undertaking number
				type("propertyproject_mu_undertakingnumbertxt_CSS", data.get("update_undertaking_number"));

				// update the title of the undertaking number
				type("propertyproject_mu_undertakingnumbertxt_CSS", data.get("undertaking_number"));

				// click on the update button
				click("propertyproject_mu_updatebtn_CSS");

				// wait for the element
				explicitWaitClickable("closetoastmsg_CSS");

				// click on the toaster close button
				click("closetoastmsg_CSS");

				verificationFailedMessage(
						"The user able to update the Mortgage Undertakings details without the Access");

			} catch (Throwable t) {

				successMessage("The user not able to update the Mortgage Undertakings details as expected.");

				// click on the cancel button
				click("propertyproject_mu_cancelbtn_CSS");
			}

			// VERIFY THE USER ABLE TO DELETE THE MORTGAGE UNDERTAKING DETAILS OR NOT
			title("VERIFY THE USER ABLE TO DELETE THE MORTGAGE UNDERTAKING DETAILS OR NOT");

			// DELETE MORTGAGE UNDERTAKINGS - JINESH
			title("DELETE MORTGAGE UNDERTAKINGS - JINESH");

			try {

				boolean mu1 = driver.findElement(By.cssSelector(OR.getProperty("propertyproject_mu_deletebtn_CSS")))
						.isDisplayed();

				if (mu1 == true) {

					verificationFailedMessage(
							"The delete button is displayed in the Mortgage Undertakings without the Access");
				}

			} catch (Throwable t) {
				successMessage("The user not able to delete the Mortgage Undertakings details as expected");

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

			// VERIFY THE CONTRACTOR - JINESHCONTRACTOR ABLE TO ADD THE MORTGAGE UNDERTAKING
			// DETAILS OR NOT
			title("VERIFY THE CONTRACTOR - JINESHCONTRACTOR ABLE TO ADD THE MORTGAGE UNDERTAKING DETAILS OR NOT");

			// ADD MORTGAGE UNDERTAKINGS - CONTRACTOR - JINESHCONTRACTOR
			title("ADD MORTGAGE UNDERTAKINGS - CONTRACTOR - JINESHCONTRACTOR");

			try {
				// click on the property project icon from the property list page
				click("propertyproject_icon_CSS");

				// wait for the element
				explicitWaitClickable("menubtn_CSS");

				// click on the burger menu
				click("menubtn_CSS");

				// wait for the element
				Thread.sleep(5000);

				// click on the Mortgage Undertakings
				click("propertyproject_mortgageundertakingsoption_XPATH");

				// ADD RECORD - MORTGAGE UNDERTAKINGS
				title("ADD RECORD - MORTGAGE UNDERTAKINGS");

				// click on the add button
				click("propertyproject_mu_addbtn_CSS");

				// enter the undertaking number
				type("propertyproject_mu_undertakingnumbertxt_CSS", data.get("undertaking_number2"));

				// select the lender
				select("propertyproject_mu_lenderdd_CSS", data.get("lender"));

				// click on the save button
				click("propertyproject_mu_savebtn_CSS");

				// wait for the element
				explicitWaitClickable("closetoastmsg_CSS");

				// click on the toaster close button
				click("closetoastmsg_CSS");

				// wait for the element
				explicitWaitClickable("propertyproject_mu_cancelbtn_CSS");

				// click on the cancel button
				click("propertyproject_mu_cancelbtn_CSS");

				// verification of the Mortgage Undertakings is added or not
				switchVerification("propertyproject_mu_addedmortgageundertakings2_ss1_XPATH",
						"UNDERTAKINGPERMISSIONTWO2021", "Mortgage Undertakings is not displayed successfully.");

			} catch (Throwable t) {
				verificationFailed();
			}

			// VERIFY THE ROLE ABLE TO UPDATE THE MORTGAGE UNDERTAKING DETAILS OR NOT
			title("VERIFY THE ROLE ABLE TO UPDATE THE MORTGAGE UNDERTAKING DETAILS OR NOT");

			try {

				// click on the newly created Mortgage Undertakings
				click("propertyproject_mu_addedmortgageundertakings2_ss1_XPATH");

				// update the title of the undertaking number
				type("propertyproject_mu_undertakingnumbertxt_CSS", data.get("update_undertaking_number2"));

				// update the title of the undertaking number
				type("propertyproject_mu_undertakingnumbertxt_CSS", data.get("undertaking_number2"));

				// click on the update button
				click("propertyproject_mu_updatebtn_CSS");

				// wait for the element
				explicitWaitClickable("closetoastmsg_CSS");

				// click on the toaster close button
				click("closetoastmsg_CSS");

				verificationFailedMessage(
						"The user able to update the Mortgage Undertakings details without the Access.");

			} catch (Throwable t) {

				successMessage("The user not able to update the Mortgage Undertakings details as expected.");

				// click on the cancel button
				click("propertyproject_mu_cancelbtn_CSS");
			}

			// VERIFY THE ROLE ABLE TO DELETE THE MORTGAGE UNDERTAKING DETAILS OR NOT
			title("VERIFY THE ROLE ABLE TO DELETE THE MORTGAGE UNDERTAKING DETAILS OR NOT");

			// DELETE MORTGAGE UNDERTAKINGS - CONTRACTOR - JINESHCONTRACTOR
			title("DELETE MORTGAGE UNDERTAKINGS - CONTRACTOR - JINESHCONTRACTOR");

			try {

				boolean mu2 = driver.findElement(By.cssSelector(OR.getProperty("propertyproject_mu_deletebtn_CSS")))
						.isDisplayed();

				if (mu2 == true) {
					verificationFailedMessage(
							"The delete button is displayed in the Mortgage Undertakings without the Access.");
				}
			} catch (Throwable t) {
				successMessage("The user not able to delete the Mortgage Undertakings details as expected");
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

			// VERIFY THE JINESH HR ABLE TO ADD THE MORTGAGE UNDERTAKING DETAILS OR NOT
			title("VERIFY THE JINESH HR ABLE TO ADD THE MORTGAGE UNDERTAKING DETAILS OR NOT");

			// ADD MORTGAGE UNDERTAKINGS - JINESH HR
			title("ADD MORTGAGE UNDERTAKINGS - JINESH HR");

			try {
				// click on the property project icon from the property list page
				click("propertyproject_icon_CSS");

				// wait for the element
				explicitWaitClickable("menubtn_CSS");

				// click on the burger menu
				click("menubtn_CSS");

				// wait for the element
				Thread.sleep(5000);

				// click on the Mortgage Undertakings
				click("propertyproject_mortgageundertakingsoption_XPATH");

				// ADD RECORD - MORTGAGE UNDERTAKINGS
				title("ADD RECORD - MORTGAGE UNDERTAKINGS");

				try {
					// click on the add button
					click("propertyproject_mu_addbtn_CSS");

					// click on the cancel button
					click("propertyproject_mu_cancelbtn_CSS");

					verificationFailedMessage(
							"The user able to add the Mortgage Undertakings details without the Access.");

				} catch (Throwable t) {
					successMessage("The user not able to add the Mortgage Undertakings details as expected.");
				}

			} catch (Throwable t) {
				verificationFailed();
			}

			// VERIFY THE JINESH HR ABLE TO UPDATE THE MORTGAGE UNDERTAKING DETAILS OR NOT
			title("VERIFY THE JINESH HR ABLE TO UPDATE THE MORTGAGE UNDERTAKING DETAILS OR NOT");

			// UPDATE MORTGAGE UNDERTAKINGS - JINESH HR
			title("UPDATE MORTGAGE UNDERTAKINGS - JINESH HR");

			try {

				// click on the newly created Mortgage Undertakings
				click("propertyproject_mu_addedmortgageundertakings2_ss1_XPATH");

				// update the title of the undertaking number
				type("propertyproject_mu_undertakingnumbertxt_CSS", data.get("update_undertaking_number3"));

				// update the title of the undertaking number
				type("propertyproject_mu_undertakingnumbertxt_CSS", data.get("undertaking_number3"));

				// click on the update button
				click("propertyproject_mu_updatebtn_CSS");

				// wait for the element
				explicitWaitClickable("closetoastmsg_CSS");

				// click on the toaster close button
				click("closetoastmsg_CSS");

				verificationFailedMessage(
						"The user able to update the Mortgage Undertakings details without the Access.");

			} catch (Throwable t) {

				successMessage("The user not able to update the Mortgage Undertakings details as expected");

				// click on the cancel button
				click("propertyproject_mu_cancelbtn_CSS");

			}

			// VERIFY THE ROLE ABLE TO DELETE THE MORTGAGE UNDERTAKING DETAILS OR NOT
			title("VERIFY THE ROLE ABLE TO DELETE THE MORTGAGE UNDERTAKING DETAILS OR NOT");

			// DELETE MORTGAGE UNDERTAKINGS - JINESH HR
			title("DELETE MORTGAGE UNDERTAKINGS - JINESH HR");

			try {

				boolean mu3 = driver.findElement(By.cssSelector(OR.getProperty("propertyproject_mu_deletebtn_CSS")))
						.isDisplayed();

				if (mu3 == true) {
					verificationFailedMessage(
							"The delete button is displayed in the Mortgage Undertakings without the Access.");
				}
			} catch (Throwable t) {
				successMessage("The user not able to delete the Mortgage Undertakings details as expected.");
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

			// DELETE THE CREATED MORTGAGE UNDERTAKING AND RESET THE GIVEN PERMISSIONS
			title("DELETE THE CREATED MORTGAGE UNDERTAKING AND RESET THE GIVEN PERMISSIONS");

			// LOGIN IN AUTOMATION TESTER USER
			title("LOGIN IN AUTOMATION TESTER USER");

			helper.loginAndUpdateSystemCompany(data, "username_1", "password_1", "system_company_1");

		} catch (Throwable t) {
			helper.questionnaireNotDisplayLogout(data);
		}

		// DELETE THE CREATED MORTGAGE UNDERTAKING
		title("DELETE THE CREATED MORTGAGE UNDERTAKING");

		try {
			// click on the property project icon from the property list page
			click("propertyproject_icon_CSS");

			// wait for the element
			explicitWaitClickable("menubtn_CSS");

			// click on the burger menu
			click("menubtn_CSS");

			// wait for the element
			Thread.sleep(5000);

			// click on the Mortgage Undertakings
			click("propertyproject_mortgageundertakingsoption_XPATH");

			// click on the delete button of the newly created Mortgage Undertakings
			List<WebElement> links = driver.findElements(By.xpath("//tr"));
			int count = links.size();
			consoleMessage("Number of links are:" + count);

			for (int i = 0; i < count - 1; i++) {

				// wait for the element
				explicitWaitClickable("propertyproject_mu_deletebtn_CSS");

				// delete the all the Mortgage Undertakings
				click("propertyproject_mu_deletebtn_CSS");

				// wait for the element
				explicitWaitClickable("propertyproject_mu_confirmationdeletebtn_CSS");

				// click on the delete button of confirmation
				click("propertyproject_mu_confirmationdeletebtn_CSS");

				// wait for the element
				explicitWaitClickable("closetoastmsg_CSS");

				// click on the toaster close button
				click("closetoastmsg_CSS");
			}

			// verify newly created MORTGAGE UNDERTAKINGS - JINESH is deleted or not
			helper.deleteVerification("propertyproject_mu_addedmortgageundertakings_ss1_XPATH",
					"UNDERTAKINGPERMISSIONONE2021");

			// verify newly created MORTGAGE UNDERTAKINGS - JINESHCONTRACTOR is deleted or
			// not
			helper.deleteVerification("propertyproject_mu_addedmortgageundertakings2_ss1_XPATH",
					"UNDERTAKINGPERMISSIONTWO2021");

			// verify newly created MORTGAGE UNDERTAKINGS - JINESHHR is deleted or not
			helper.deleteVerification("propertyproject_mu_addedmortgageundertakings3_ss1_XPATH",
					"UNDERTAKINGPERMISSIONTHREE2021");

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

			// RESET THE VIEW MORTGAGE UNDERTAKING PERMISSION
			helper.resetPermission(data, "security_setting_1", "propertyproject_securitysettings1_XPATH");

			// RESET THE ADD MORTGAGE UNDERTAKING PERMISSION
			helper.resetPermission(data, "security_setting_2", "propertyproject_securitysettings2_XPATH");

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