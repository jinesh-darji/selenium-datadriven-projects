package testcases.E2Etestcasesuite.propertyprojectmodule;

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

public class RR4931PropertyProjectFourTest extends TestBase {

	@Test(dataProviderClass = TestUtil.class, dataProvider = "dp")
	public void rR4931PropertyProjectFourTest(Hashtable<String, String> data) throws IOException, InterruptedException {

		execution(data, "rR4931PropertyProjectFourTest");

		// APPLY THE "PERMISSION TO VIEW RESTRICTED ATTACHMENTS" SECURITY SETTINGS TO
		// THE ATTACHMENT FOR THE REPAIR (TASK)
		title("APPLY THE \\\"PERMISSION TO VIEW RESTRICTED ATTACHMENTS\\\" SECURITY SETTINGS TO THE ATTACHMENT FOR THE REPAIR (TASK).");

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

			// RESET THE PERMISSION TO RESTRICTED ATTACHMENT
			helper.resetPermission(data, "security_setting_attachment_1",
					"propertyproject_securitysettings_attachments1_XPATH");

			// RESET THE PERMISSION TO MARK ATTACHMENTS AS RESTRICTED
			helper.resetPermission(data, "security_setting_attachment_2",
					"propertyproject_securitysettings_attachments2_XPATH");

			// RESET THE PERMISSION TO VIEW RESTRICTED ATTACHMENTS
			helper.resetPermission(data, "security_setting_attachment_3",
					"propertyproject_securitysettings_attachments3_XPATH");

			// APPLY THE PERMISSION TO VIEW RESTRICTED ATTACHMENTS
			helper.addPermissionOneUsersRole(data, "security_setting_attachment_4",
					"propertyproject_securitysettings_attachments4_XPATH");

		} catch (Throwable t) {
			verificationFailed();
		}

		// ADD SECURITY SETTINGS OF VIEW / ADD MORTGAGE UNDERTAKING TO USER/ROLE ACCESS
		title("ADD SECURITY SETTINGS OF VIEW / ADD MORTGAGE UNDERTAKING TO USER/ROLE ACCESS");

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

			// click on the burger menu
			click("menubtn_CSS");

			// wait for the element
			explicitWaitClickable("propertyproject_mortgageundertakingsoption_XPATH");

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
			explicitWaitClickable("propertyproject_mu_newrepairbtn_BTNTEXT");

			// click on the new repair button
			click("propertyproject_mu_newrepairbtn_BTNTEXT");

			// scroll down the screen
			scrollByPixel(600);

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
			type("propertyproject_mu_repair_searchusertxt_CSS", data.get("user_1"));

			// click on the searched username
			click("propertyproject_mu_repair_searcheduser_XPATH");

			// enter role in search field
			type("propertyproject_mu_repair_searchusertxt_CSS", data.get("role_1"));

			// click on the searched role
			click("propertyproject_mu_repair_searchedrole_XPATH");

			// click on assign to field
			click("propertyproject_mu_repair_assigntotxt_CSS");

			// scroll up the screen
			scrollByPixel(-600);

			// DETAILS OF THE ATTACHMENT TAB
			title("DETAILS OF THE ATTACHMENT TAB");

			// click on the attachment tab
			click("propertyproject_mu_attachmenttab_CSS");

			// scroll down the screen
			scrollByPixel(600);

			try {

				// click on the upload local file
				click("propertyproject_mu_uploaddocumentbtn_CSS");

				// upload the document using robot class methods
				uploadFile(System.getProperty("user.dir") + "\\src\\test\\resources\\logs\\sample.pdf");

				// wait for the element
				explicitWaitClickable("propertyproject_mu_attchedfilename_XPATH");

				// verify uploaded file is displayed or not
				String str1 = driver.findElement(By.xpath(OR.getProperty("propertyproject_mu_attchedfilename_XPATH")))
						.getText();

				if (str1.equals("sample.pdf")) {

					successMessage("The uploaded file displayed successfully.");

					// click on the restriction attachment checklist
					click("propertyproject_mu_restrictedattachmentcbx_XPATH");

				} else {
					verificationFailedMessage("The The uploaded file is not displayed.");
				}
			} catch (Throwable t) {
				verificationFailedMessage("The The uploaded file is not displayed.");
			}

			// click on the save button
			click("propertyproject_mu_tasksavebtn_BTNTEXT");

			// wait for the element
			explicitWaitClickable("propertyproject_mu_addedrepair_attachment4_XPATH");

			// verify newly created repair is displayed or not
			switchVerification("propertyproject_mu_addedrepair_attachment4_XPATH",
					"Test SS Attachment 4 Mortgage Undertakings Title",
					"The Test SS Attachment 4 Mortgage Undertakings Title is not displayed.");

			// click on the update button
			click("propertyproject_mu_repair_updatebtn_CSS");

			// wait for the element
			explicitWaitClickable("propertyproject_mu_addedmortgageundertakings_attachment4_XPATH");

			// verify newly created mortgage undertaking is displayed or not
			switchVerification("propertyproject_mu_addedmortgageundertakings_attachment4_XPATH",
					"UNDERTAKINGSSATTACHMENTFOUR2021", "The UNDERTAKINGSSATTACHMENTFOUR2021 is not displayed.");

		} catch (Throwable t) {
			verificationFailed();
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

		// VERIFY THE PERMISSION TO VIEW RESTRICTED ATTACHMENTS IN THE JINESH USER
		title("VERIFY THE PERMISSION TO VIEW RESTRICTED ATTACHMENTS IN THE JINESH USER");

		try {
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
			switchVerification("propertyproject_mu_addedmortgageundertakings_attachment4_XPATH",
					"UNDERTAKINGSSATTACHMENTFOUR2021", "The UNDERTAKINGSSATTACHMENTFOUR2021 is not displayed.");

			// click on the created mortgage undertaking
			click("propertyproject_mu_addedmortgageundertakings_attachment4_XPATH");

			// scroll down the screen
			scrollByPixel(600);

			// verify newly created repair is displayed or not
			switchVerification("propertyproject_mu_addedrepair_attachment4_XPATH",
					"Test SS Attachment 4 Mortgage Undertakings Title",
					"The Test SS Attachment 4 Mortgage Undertakings Title is not displayed.");

			// click on the newly created repair
			click("propertyproject_mu_addedrepair_attachment4_XPATH");

			// click on the attachment tab
			click("propertyproject_mu_attachmenttab_CSS");

			// scroll down the screen
			scrollByPixel(600);

			try {

				boolean file1 = driver.findElement(By.xpath(OR.getProperty("propertyproject_mu_attchedfilename_CSS")))
						.isSelected();

				if (file1 == true) {
					successMessage("The user able to access the Restricted Attachment as expected.");
				}

			} catch (Throwable t) {
				verificationFailedMessage("The user not able to access the Restricted Attachment with permission.");
			}

			// click on the back button
			click("propertyproject_mu_attachmenttab_backbtn_CSS");

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
			explicitWaitClickable("sidemenu_logout_CSS");

			// click on the logout option from the side menu
			click("sidemenu_logout_CSS");

			// VERIFY THE PERMISSION TO VIEW RESTRICTED ATTACHMENTS IN THE JINESH CONTRACTOR
			title("VERIFY THE PERMISSION TO VIEW RESTRICTED ATTACHMENTS IN THE JINESH CONTRACTOR");

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
			switchVerification("propertyproject_mu_addedmortgageundertakings_attachment4_XPATH",
					"UNDERTAKINGSSATTACHMENTFOUR2021", "The UNDERTAKINGSSATTACHMENTFOUR2021 is not displayed.");

			// click on the created mortgage undertaking
			click("propertyproject_mu_addedmortgageundertakings_attachment4_XPATH");

			// scroll down the screen
			scrollByPixel(600);

			// verify newly created repair is displayed or not
			switchVerification("propertyproject_mu_addedrepair_attachment4_XPATH",
					"Test SS Attachment 4 Mortgage Undertakings Title",
					"The Test SS Attachment 4 Mortgage Undertakings Title is not displayed.");

			// click on the newly created repair
			click("propertyproject_mu_addedrepair_attachment4_XPATH");

			// click on the attachment tab
			click("propertyproject_mu_attachmenttab_CSS");

			// scroll down the screen
			scrollByPixel(600);

			try {

				boolean file1 = driver.findElement(By.xpath(OR.getProperty("propertyproject_mu_attchedfilename_CSS")))
						.isSelected();

				if (file1 == true) {
					successMessage("The user able to access the Restricted Attachment as expected.");
				}

			} catch (Throwable t) {
				verificationFailedMessage("The user not able to access the Restricted Attachment with permission.");
			}

			// click on the back button
			click("propertyproject_mu_attachmenttab_backbtn_CSS");

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
			explicitWaitClickable("sidemenu_logout_CSS");

			// click on the logout option from the side menu
			click("sidemenu_logout_CSS");

			// VERIFY THE PERMISSION TO VIEW RESTRICTED ATTACHMENTS IN THE JINESH HR
			title("VERIFY THE PERMISSION TO VIEW RESTRICTED ATTACHMENTS IN THE JINESH HR");

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
			switchVerification("propertyproject_mu_addedmortgageundertakings_attachment4_XPATH",
					"UNDERTAKINGSSATTACHMENTFOUR2021", "The UNDERTAKINGSSATTACHMENTFOUR2021 is not displayed.");

			// click on the created mortgage undertaking
			click("propertyproject_mu_addedmortgageundertakings_attachment4_XPATH");

			// scroll down the screen
			scrollByPixel(600);

			// verify newly created repair is displayed or not
			switchVerification("propertyproject_mu_addedrepair_attachment4_XPATH",
					"Test SS Attachment 4 Mortgage Undertakings Title",
					"The Test SS Attachment 4 Mortgage Undertakings Title is not displayed.");

			// click on the newly created repair
			click("propertyproject_mu_addedrepair_attachment4_XPATH");

			// click on the attachment tab
			click("propertyproject_mu_attachmenttab_CSS");

			// scroll down the screen
			scrollByPixel(600);

			try {

				boolean file1 = driver.findElement(By.xpath(OR.getProperty("propertyproject_mu_attchedfilename_CSS")))
						.isSelected();

				if (file1 == true) {
					verificationFailedMessage("The user able to access the Restricted Attachment without permission.");
				}

			} catch (Throwable t) {
				successMessage("The user not able to access the Restricted Attachment as expected.");
			}

			// click on the back button
			click("propertyproject_mu_attachmenttab_backbtn_CSS");

			// click on the cancel button
			click("propertyproject_mu_cancelbtn_CSS");

			// click on the home icon
			click("questionnaire_homeburgermenubtn_hide_CSS");

			// wait for the element
			explicitWait("propertylist_title_XPATH");

			// verify the property list
			switchVerification("propertylist_title_XPATH", "Property List", "The property list is not displayed.");

			// LOGIN IN AUTOMATION TESTER USER
			title("LOGIN IN AUTOMATION TESTER USER");

			// DELETE THE CREATED MORTGAGE UNDERTAKING AND RESET THE GIVEN PERMISSIONS
			title("DELETE THE CREATED MORTGAGE UNDERTAKING AND RESET THE GIVEN PERMISSIONS");

			// wait for the element
			explicitWaitClickable("questionnaire_settingicon_CSS");

			// click on the settings icon from the top of the screen
			click("questionnaire_settingicon_CSS");

			// wait for the element
			explicitWaitClickable("sidemenu_logout_CSS");

			// click on the logout option from the side menu
			click("sidemenu_logout_CSS");

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
			switchVerification("propertyproject_mu_addedmortgageundertakings_attachment4_XPATH",
					"UNDERTAKINGSSATTACHMENTFOUR2021", "The UNDERTAKINGSSATTACHMENTFOUR2021 is not displayed.");

			// click on the Mortgage Undertakings
			click("propertyproject_mu_addedmortgageundertakings_attachment4_XPATH");

			// scroll down the screen
			scrollByPixel(600);

			// verify newly created repair is displayed or not
			switchVerification("propertyproject_mu_addedrepair_attachment4_XPATH",
					"Test SS Attachment 4 Mortgage Undertakings Title",
					"The Test SS Attachment 4 Mortgage Undertakings Title is not displayed.");

			// DELETE THE REPAIR
			title("DELETE THE REPAIR");

			// scroll down the screen
			scrollByPixel(600);

			// click on the repair
			click("propertyproject_mu_addedrepair_attachment4_XPATH");

			// click on the delete button
			click("task_deletedtaskbtn_CSS");

			// click on the delete button of the confirmation
			click("task_deletedtaskbtn_confirmaiton_CSS");

			// wait for the element
			explicitWaitClickable("closetoastmsg_CSS");

			// click on the toaster close button
			click("closetoastmsg_CSS");

			// verify repair is deleted or not
			try {
				helper.deleteVerification("propertyproject_mu_addedrepair_attachment4_XPATH",
						"Test SS Attachment 4 Mortgage Undertakings Title");

			} catch (Throwable t) {
				verificationFailed();
			}

			// click on the update button
			click("propertyproject_mu_taskupdatebtn_BTNTEXT");

			// wait for the element
			explicitWaitClickable("closetoastmsg_CSS");

			// click on the toaster close button
			click("closetoastmsg_CSS");

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
			helper.deleteVerification("propertyproject_mu_addedmortgageundertakings_attachment4_XPATH",
					"UNDERTAKINGSSATTACHMENTFOUR2021");

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
			helper.resetPermission(data, "security_setting_attachment_4",
					"propertyproject_securitysettings_attachments4_XPATH");

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