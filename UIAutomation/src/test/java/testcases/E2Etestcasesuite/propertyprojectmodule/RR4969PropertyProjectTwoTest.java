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

public class RR4969PropertyProjectTwoTest extends TestBase {

	@Test(dataProviderClass = TestUtil.class, dataProvider = "dp")
	public void rR4969PropertyProjectTwoTest(Hashtable<String, String> data) throws IOException, InterruptedException {

		execution(data, "rR4969PropertyProjectTwoTest");

		// APPLY THE "ACCESS TO VIEW RESTRICTED COMMENTS" SECURITY SETTINGS TO THE
		// COMMENTS FOR THE MORTGAGE UNDERTAKING.
		title("APPLY THE \\\"ACCESS TO VIEW RESTRICTED COMMENTS\\\" SECURITY SETTINGS TO THE COMMENTS FOR THE MORTGAGE UNDERTAKING.");

		Helper helper = new Helper();

		// refresh the page
		driver.navigate().refresh();
		Thread.sleep(5000);
		driver.navigate().refresh();

		// SET SECURITY SETTINGS FOR THE COMMENTS
		title("SET SECURITY SETTINGS FOR THE COMMENTS");

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

			// RESET THE ACCESS TO VIEW RESTRICTED COMMENTS
			helper.resetPermission(data, "security_setting_comment_1",
					"propertyproject_securitysettings_comment1_XPATH");

			// APPLY THE ACCESS TO VIEW RESTRICTED COMMENTS
			helper.addPermissionOneUsersRole(data, "security_setting_comment_2",
					"propertyproject_securitysettings_comment2_XPATH");

			// RESET THE VIEW OHS RESTRICTED COMMENTS
			helper.resetPermission(data, "security_setting_comment_3",
					"propertyproject_securitysettings_comment3_XPATH");

		} catch (Throwable t) {
			verificationFailed();
		}

		// ADD SECURITY SETTINGS OF VIEW MORTGAGE UNDERTAKING TO USER/ROLE ACCESS
		title("ADD SECURITY SETTINGS OF VIEW MORTGAGE UNDERTAKING TO USER/ROLE ACCESS");

		try {

			// APPLY THE VIEW MORTGAGE UNDERTAKING PERMISSION
			helper.addPermissionTwoUsersRole(data, "security_setting_1", "propertyproject_securitysettings1_XPATH");

			// RESET THE ADD MORTGAGE UNDERTAKING PERMISSION
			helper.resetPermission(data, "security_setting_2", "propertyproject_securitysettings2_XPATH");

			// RESET THE EDIT MORTGAGE UNDERTAKING PERMISSION
			helper.resetPermission(data, "security_setting_3", "propertyproject_securitysettings3_XPATH");

			// RESET THE DELETE MORTGAGE UNDERTAKING PERMISSION
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

		// ADD MORTGAGE UNDERTAKINGS
		title("ADD MORTGAGE UNDERTAKINGS");

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
			explicitWaitClickable("propertyproject_mu_newrepairbtn_BTNTEXT");

			// ADD COMMENT OF THE MORTGAGE UNDERTAKING
			title("ADD COMMENT OF THE MORTGAGE UNDERTAKING");

			// click on the comment tab
			click("propertyproject_mu_commenttab_XPATH");

			// scroll down the screen
			scrollByPixel(800);

			// enter the details in the comment field
			type("propertyproject_mu_commenttxt_CSS", data.get("description"));

			// click on the restricted comment checkbox
			click("propertyproject_mu_comment_restricted_CSS");

			// click on the update button
			click("propertyproject_mu_updatebtn_CSS");

			// wait for the element
			explicitWaitClickable("closetoastmsg_CSS");

			// click on the toaster close button
			click("closetoastmsg_CSS");

			// verify newly created mortgage undertaking is displayed or not
			switchVerification("propertyproject_mu_addedmortgageundertakings_comment2_XPATH",
					"UNDERTAKINGSSCOMMENTTWO2021", "The UNDERTAKINGSSCOMMENTTWO2021 is not displayed.");

		} catch (Throwable t) {
			verificationFailed();
		}

		// click on the home icon
		click("questionnaire_homeburgermenubtn_hide_CSS");

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

			// VERIFY THE RESTRICTED ATTACHMENT ACCESS IN THE JINESH USER
			title("VERIFY THE RESTRICTED ATTACHMENT ACCESS IN THE JINESH USER");

			// LOGIN IN JINESH USER
			title("LOGIN IN JINESH USER");

			helper.loginAndUpdateSystemCompany(data, "username", "password", "system_company_1");

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

			// verify newly created mortgage undertaking is displayed or not
			switchVerification("propertyproject_mu_addedmortgageundertakings_comment2_XPATH",
					"UNDERTAKINGSSCOMMENTTWO2021", "The UNDERTAKINGSSCOMMENTTWO2021 is not displayed.");

			// click on the created mortgage undertaking
			click("propertyproject_mu_addedmortgageundertakings_comment2_XPATH");

			// scroll down the screen
			scrollByPixel(600);

			// VERIFY COMMENT OF THE MORTGAGE UNDERTAKING
			title("VERIFY COMMENT OF THE MORTGAGE UNDERTAKING");

			// click on the comment tab
			click("propertyproject_mu_commenttab_XPATH");

			// scroll down the screen
			scrollByPixel(800);

			try {

				boolean checked1 = driver
						.findElement(By.xpath(OR.getProperty("propertyproject_mu_restrictedcomment2_XPATH")))
						.isDisplayed();

				if (checked1 == true) {
					successMessage("The Restricted Comment is displayed as per the permission.");
				} else {
					verificationFailedMessage("The Restricted Comment is not displayed.");
				}

			} catch (Throwable t) {
				verificationFailedMessage("The Restricted Comment is not displayed.");
			}

			// click on the cancel button
			click("propertyproject_mu_cancelbtn_CSS");

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
			Thread.sleep(5000);

			// click on the logout option from the side menu
			click("sidemenu_logout_CSS");

			// VERIFY THE ACCESS TO VIEW RESTRICTED COMMENTS IN THE JINESH CONTRACTOR
			title("VERIFY THE ACCESS TO VIEW RESTRICTED COMMENTS IN THE JINESH CONTRACTOR");

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

			// click on the Mortgage Undertakings
			click("propertyproject_mortgageundertakingsoption_XPATH");

			// verify newly created mortgage undertaking is displayed or not
			switchVerification("propertyproject_mu_addedmortgageundertakings_comment2_XPATH",
					"UNDERTAKINGSSCOMMENTTWO2021", "The UNDERTAKINGSSCOMMENTTWO2021 is not displayed.");

			// click on the created mortgage undertaking
			click("propertyproject_mu_addedmortgageundertakings_comment2_XPATH");

			// scroll down the screen
			scrollByPixel(600);

			// VERIFY COMMENT OF THE MORTGAGE UNDERTAKING
			title("VERIFY COMMENT OF THE MORTGAGE UNDERTAKING");

			// click on the comment tab
			click("propertyproject_mu_commenttab_XPATH");

			// scroll down the screen
			scrollByPixel(800);

			try {

				boolean checked2 = driver
						.findElement(By.xpath(OR.getProperty("propertyproject_mu_restrictedcomment2_XPATH")))
						.isDisplayed();

				if (checked2 == true) {
					successMessage("The Restricted Comment is displayed as per the permission.");
				} else {
					verificationFailedMessage("The Restricted Comment is not displayed");
				}

			} catch (Throwable t) {
				verificationFailedMessage("The Restricted Comment is not displayed");
			}

			// click on the cancel button
			click("propertyproject_mu_cancelbtn_CSS");

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
			Thread.sleep(5000);

			// click on the logout option from the side menu
			click("sidemenu_logout_CSS");

			// VERIFY THE ACCESS TO VIEW RESTRICTED COMMENTS IN THE JINESH HR
			title("VERIFY THE ACCESS TO VIEW RESTRICTED COMMENTS IN THE JINESH HR");

			// LOGIN IN JINESH HR
			title("LOGIN IN JINESH HR");

			helper.loginAndUpdateSystemCompany(data, "username_3", "password_3", "system_company_1");

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

			// verify newly created mortgage undertaking is displayed or not
			switchVerification("propertyproject_mu_addedmortgageundertakings_comment2_XPATH",
					"UNDERTAKINGSSCOMMENTTWO2021", "The UNDERTAKINGSSCOMMENTTWO2021 is not displayed.");

			// click on the created mortgage undertaking
			click("propertyproject_mu_addedmortgageundertakings_comment2_XPATH");

			// scroll down the screen
			scrollByPixel(600);

			// VERIFY COMMENT OF THE MORTGAGE UNDERTAKING
			title("VERIFY COMMENT OF THE MORTGAGE UNDERTAKING");

			// click on the comment tab
			click("propertyproject_mu_commenttab_XPATH");

			// scroll down the screen
			scrollByPixel(800);

			try {

				boolean checked3 = driver
						.findElement(By.xpath(OR.getProperty("propertyproject_mu_restrictedcomment2_XPATH")))
						.isDisplayed();

				if (checked3 == true) {
					verificationFailedMessage("The Restricted Comment is displayed");
				} else {
					successMessage("The Restricted Comment is not displayed.");
				}
			} catch (Throwable t) {
				successMessage("The Restricted Comment is not displayed.");
			}

			// click on the cancel button
			click("propertyproject_mu_cancelbtn_CSS");

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
			Thread.sleep(5000);

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

		// DELETE THE MORTGAGE UNDERTAKINGS
		title("DELETE THE MORTGAGE UNDERTAKINGS");

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

			// verify newly created mortgage undertaking is displayed or not
			switchVerification("propertyproject_mu_addedmortgageundertakings_comment2_XPATH",
					"UNDERTAKINGSSCOMMENTTWO2021", "The UNDERTAKINGSSCOMMENTTWO2021 is not displayed.");

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

			// verify newly created MORTGAGE UNDERTAKINGS is deleted or not
			helper.deleteVerification("propertyproject_mu_addedmortgageundertakings_comment2_XPATH",
					"UNDERTAKINGSSCOMMENTTWO2021");

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

			// RESET THE PERMISSION TO RESTRICTED ATTACHMENT
			helper.resetPermission(data, "security_setting_comment_2",
					"propertyproject_securitysettings_comment2_XPATH");

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