package testcases.E2Etestcasesuite.propertyprojectmodule;

import java.io.IOException;
import java.util.Hashtable;
import java.util.List;

import javax.swing.border.TitledBorder;

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

public class RR4968PropertyProjectTwoTest extends TestBase {

	@Test(dataProviderClass = TestUtil.class, dataProvider = "dp")
	public void rR4968PropertyProjectTwoTest(Hashtable<String, String> data) throws IOException, InterruptedException {

		execution(data, "rR4968PropertyProjectTwoTest");

		// APPLY THE "ACCESS TO VIEW RESTRICTED COMMENTS" SECURITY SETTINGS TO THE
		// COMMENTS FOR THE REPAIR OF THE MORTGAGE UNDERTAKING.
		title("APPLY THE \\\"ACCESS TO VIEW RESTRICTED COMMENTS\\\" SECURITY SETTINGS TO THE COMMENTS FOR THE REPAIR OF THE MORTGAGE UNDERTAKING.");

		Helper helper = new Helper();

		// refresh the page
		driver.navigate().refresh();
		Thread.sleep(5000);
		driver.navigate().refresh();

		// SET SECURITY SETTINGS FOR THE ATTACHMENTS
		title("SET SECURITY SETTINGS FOR THE ATTACHMENTS");

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

			// APPLY THE ACCESS TO MARK COMMENTS AS RESTRICTED
			helper.resetPermission(data, "security_setting_comment_1",
					"propertyproject_securitysettings_comment1_XPATH");

			// RESET THE ACCESS TO VIEW RESTRICTED COMMENTS
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
			explicitWaitClickable("propertyproject_mu_newrepairbtn_BTNTEXT");

			// click on the new repair button
			click("propertyproject_mu_newrepairbtn_BTNTEXT");

			// scroll down the screen
			scrollByPixel(400);

			// enter the title of the repair
			type("propertyproject_mu_repair_titletxt_CSS", data.get("task_title"));

			// enter the description
			type("propertyproject_mu_descriptiontxt_CSS", data.get("short_description"));

			// enter the unit number
			type("propertyproject_mu_unitenotxt_CSS", data.get("unit_number"));

			// click on assign to field
			click("propertyproject_mu_repair_assigntotxt_CSS");

			// click on the none button
			click("propertyproject_mu_repair_nonebtn_CSS");

			// enter username in search field
			type("propertyproject_mu_repair_searchusertxt_CSS", data.get("search_user"));

			// click on the searched username
			click("propertyproject_mu_repair_searcheduser_XPATH");

			// click on assign to field
			click("propertyproject_mu_repair_assigntotxt_CSS");

			// click on the save button
			click("propertyproject_mu_tasksavebtn_BTNTEXT");

			// wait for the element
			explicitWaitClickable("closetoastmsg_CSS");

			// click on the toaster close button
			click("closetoastmsg_CSS");

			// click on the update button
			click("propertyproject_mu_updatebtn_CSS");

			// wait for the element
			explicitWaitClickable("closetoastmsg_CSS");

			// click on the toaster close button
			click("closetoastmsg_CSS");

			// verify newly created mortgage undertaking is displayed or not
			switchVerification("propertyproject_mu_addedmortgageundertakings_taskcomment2_XPATH",
					"UNDERTAKINGSSTASKCOMMENTTWO2021", "The UNDERTAKINGSSTASKCOMMENTTWO2021 is not displayed.");

			// click on the newly created mortgage undertaking
			click("propertyproject_mu_addedmortgageundertakings_taskcomment2_XPATH");

			// scroll down the screen
			scrollByPixel(600);

			// click on the newly created repair
			click("propertyproject_mu_addedrepair_taskcomment2_XPATH");

			// wait for the element
			explicitWaitClickable("propertyproject_mu_addedrepair_taskcommenttab_CSS");

			// ADD COMMENT OF THE REPAIR
			title("ADD COMMENT OF THE REPAIR");

			// click on the comment tab
			click("propertyproject_mu_addedrepair_taskcommenttab_CSS");

			// scroll down the screen
			scrollByPixel(600);

			// enter the details in the comment field
			type("propertyproject_mu_commenttxt_CSS", data.get("description"));

			// click on the restricted comment checkbox
			click("propertyproject_mu_comment_restricted_CSS");

			// click on the update button
			click("task_tasktag_taskscreen_updatebtn_CSS");

			// wait for the element
			explicitWaitClickable("closetoastmsg_CSS");

			// click on the toaster close button
			click("closetoastmsg_CSS");

			// click on the cancel button
			click("propertyproject_mu_cancelbtn_CSS");

			// verify newly created mortgage undertaking is displayed or not
			switchVerification("propertyproject_mu_addedmortgageundertakings_taskcomment2_XPATH",
					"UNDERTAKINGSSTASKCOMMENTTWO2021", "The UNDERTAKINGSSTASKCOMMENTTWO2021 is not displayed.");

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
			explicitWaitClickable("sidemenu_logout_CSS");

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
			switchVerification("propertyproject_mu_addedmortgageundertakings_taskcomment2_XPATH",
					"UNDERTAKINGSSTASKCOMMENTTWO2021", "The UNDERTAKINGSSTASKCOMMENTTWO2021 is not displayed.");

			// click on the created mortgage undertaking
			click("propertyproject_mu_addedmortgageundertakings_taskcomment2_XPATH");

			// scroll down the screen
			scrollByPixel(600);

			// click on the newly created repair
			click("propertyproject_mu_addedrepair_taskcomment2_XPATH");

			// scroll down the screen
			scrollByPixel(400);

			// VERIFY COMMENT OF THE REPAIR
			title("VERIFY COMMENT OF THE REPAIR");

			// click on the comment tab
			click("propertyproject_mu_addedrepair_taskcommenttab_CSS");

			// scroll down the screen
			scrollByPixel(800);

			try {

				boolean checked1 = driver
						.findElement(By.xpath(OR.getProperty("propertyproject_mu_restrictedtaskcomment2_XPATH")))
						.isDisplayed();

				if (checked1 == true) {
					successMessage("The Restricted Comment is displayed as per the permission.");
				} else {
					verificationFailedMessage("The Restricted Comment is not displayed");
				}

			} catch (Throwable t) {
				verificationFailedMessage("The Restricted Comment is not displayed");
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

			// VERIFY THE ACCESS TO MARK COMMENTS AS RESTRICTED IN THE JINESH CONTRACTOR
			title("VERIFY THE ACCESS TO MARK COMMENTS AS RESTRICTED IN THE JINESH CONTRACTOR");

			// LOGIN IN JINESH CONTRACTOR
			title("LOGIN IN JINESH CONTRACTOR");

			helper.loginAndUpdateSystemCompany(data, "username_2", "password_2", "system_company_1");

			// click on the property project icon from the property list page
			click("propertyproject_icon_CSS");

			// wait for the element
			Thread.sleep(5000);

			// click on the burger menu
			click("menubtn_CSS");

			// wait for the element
			Thread.sleep(5000);

			// click on the Mortgage Undertakings
			click("propertyproject_mortgageundertakingsoption_XPATH");

			// verify newly created mortgage undertaking is displayed or not
			switchVerification("propertyproject_mu_addedmortgageundertakings_taskcomment2_XPATH",
					"UNDERTAKINGSSTASKCOMMENTTWO2021", "The UNDERTAKINGSSTASKCOMMENTTWO2021 is not displayed.");

			// click on the created mortgage undertaking
			click("propertyproject_mu_addedmortgageundertakings_taskcomment2_XPATH");

			// scroll down the screen
			scrollByPixel(600);

			// click on the newly created repair
			click("propertyproject_mu_addedrepair_taskcomment2_XPATH");

			// wait for the element
			explicitWaitClickable("propertyproject_mu_commenttab1_XPATH");

			// VERIFY COMMENT OF THE REPAIR

			// click on the comment tab
			click("propertyproject_mu_commenttab1_XPATH");

			// scroll down the screen
			scrollByPixel(800);

			try {
				boolean checked2 = driver
						.findElement(By.xpath(OR.getProperty("propertyproject_mu_restrictedtaskcomment2_XPATH")))
						.isDisplayed();

				if (checked2 == true) {
					successMessage("The Restricted Comment Checkbox is displayed Selected.");

				} else {
					verificationFailedMessage("The Restricted Comment Checkbox is not displayed Selected.");
				}

			} catch (Throwable t) {
				verificationFailedMessage("The Restricted Comment Checkbox is not displayed Selected.");
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

			// VERIFY THE ACCESS TO MARK COMMENTS AS RESTRICTED IN THE JINESH HR
			title("VERIFY THE ACCESS TO MARK COMMENTS AS RESTRICTED IN THE JINESH HR");

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
			switchVerification("propertyproject_mu_addedmortgageundertakings_taskcomment2_XPATH",
					"UNDERTAKINGSSTASKCOMMENTTWO2021", "The UNDERTAKINGSSTASKCOMMENTTWO2021 is not displayed.");

			// click on the created mortgage undertaking
			click("propertyproject_mu_addedmortgageundertakings_taskcomment2_XPATH");

			// scroll down the screen
			scrollByPixel(600);

			// click on the newly created repair
			click("propertyproject_mu_addedrepair_taskcomment2_XPATH");

			// wait for the element
			Thread.sleep(5000);

			// VERIFY COMMENT OF THE REPAIR
			title("VERIFY COMMENT OF THE REPAIR");

			// click on the comment tab
			click("propertyproject_mu_commenttab1_XPATH");

			// scroll down the screen
			scrollByPixel(800);

			try {
				// click on the restricted comment check box
				boolean checked3 = driver
						.findElement(By.xpath(OR.getProperty("propertyproject_mu_restrictedtaskcomment2_XPATH")))
						.isDisplayed();

				if (checked3 == true) {
					verificationFailedMessage("The Restricted Comment Checkbox is displayed");
				} else {
					successMessage("The Restricted Comment Checkbox is not displayed as expected.");
				}

			} catch (Throwable t) {
				successMessage("The Restricted Comment Checkbox is not displayed as expected.");
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
			switchVerification("propertyproject_mu_addedmortgageundertakings_taskcomment2_XPATH",
					"UNDERTAKINGSSTASKCOMMENTTWO2021", "The UNDERTAKINGSSTASKCOMMENTTWO2021 is not displayed.");

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
			helper.deleteVerification("propertyproject_mu_addedmortgageundertakings_taskcomment2_XPATH",
					"UNDERTAKINGSSTASKCOMMENTTWO2021");

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