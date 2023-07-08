package testcases.E2Etestcasesuite.riskmanagementmodule;

import java.io.IOException;
import java.util.Hashtable;
import java.util.Random;

import org.apache.commons.lang3.RandomStringUtils;
import org.openqa.selenium.By;
import org.testng.annotations.Test;

import base.Helper;
import base.TestBase;
import utilities.TestUtil;

public class RR6531RiskManagementTest extends TestBase {

	@Test(dataProviderClass = TestUtil.class, dataProvider = "dp")
	public void rR6531RiskManagementTest(Hashtable<String, String> data) throws IOException, InterruptedException {

		execution(data, "rR6531RiskManagementTest");

		// refresh the page
		driver.navigate().refresh();
		Thread.sleep(5000);
		driver.navigate().refresh();

		// VALIDATE THE COMMANDS TAB OF THE INSURANCE CLAIM.
		title("VALIDATE THE COMMANDS TAB OF THE INSURANCE CLAIM.");

		Random random = new Random();
		int commentCount = random.nextInt(5 - 2) + 2;

		Helper helper = new Helper();

		// SET THE PERMISSION FOR THE DEFAULT USER AND ROLE FOR THE RESTRICTED COMMENT
		title("SET THE PERMISSION FOR THE DEFAULT USER AND ROLE FOR THE RESTRICTED COMMENT");

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
			helper.addPermissionOneUsersRole(data, "security_setting_1",
					"propertyproject_securitysettings_restrictedcomments_XPATH");

		} catch (Throwable t) {
			verificationFailed();
		}

		// click on the home icon
		click("questionnaire_homeburgermenubtn_CSS");

		// wait for the element
		explicitWait("propertylist_title_XPATH");

		// verify the property list
		switchVerification("propertylist_title_XPATH", "Property List", "The property list is not displayed.");

		// ADD THE INSURANCE CLAIM RECORD AND ADD THE COMMENT
		title("ADD THE INSURANCE CLAIM RECORD AND ADD THE COMMENT");

		String incident = RandomStringUtils.randomNumeric(8);

		try {
			// click on the risk management icon
			click("riskmanagementicon_CSS");

			// wait for the element
			explicitWaitClickable("menubtn_CSS");

			// click on the burger menu
			click("menubtn_CSS");

			// wait for the element
			Thread.sleep(5000);

			// click on the insurance claim
			click("riskmanagement_insuranceclaimoption_XPATH");

			// click on the add insurance claim button
			click("riskmanagement_addinsuranceclaim_CSS");

			// enter the incident name
			type("riskmanagement_insuranceclaim_incidenttxt_CSS", incident);

			// select the claim status
			select("riskmanagement_insuranceclaim_claimstatusdd_CSS", "Claim");

			// select the claim type
			select("riskmanagement_insuranceclaim_claimtypedd_CSS", "Flood");

			// scroll down
			scrollByPixel(300);

			// enter the text in the loss summary statement
			type("riskmanagement_insuranceclaim_losssummarystatementtxt_CSS", "Loss Description Testing Purpose");

			// click on the save button
			click("riskmanagement_insuranceclaim_saveinsuranceclaim_CSS");

			// wait for the element
			explicitWaitClickable("closetoastmsg_CSS");

			// click on the toaster close button
			click("closetoastmsg_CSS");

			// enter the incident in the search field
			type("riskmanagement_insuranceclaim_searchtxt_CSS", incident);

			// validate the newly created insurance claim record
			try {
				String insuranceClaim = "//td[text()='" + incident + "']";
				boolean insuranceClaim_actual = driver.findElement(By.xpath(insuranceClaim)).isDisplayed();
				if (insuranceClaim_actual == true) {
					successMessage("The newly created insurance claim record is displayed successfully.");
				} else {
					verificationFailedMessage("The newly created insurance claim record is not displayed.");
				}
			} catch (Throwable t) {
				verificationFailedMessage("The newly created insurance claim record is not displayed.");
			}

		} catch (Throwable t) {
			verificationFailed();
		}

		// click on the home icon
		click("questionnaire_homeburgermenubtn_hide_CSS");

		// wait for the element
		explicitWait("propertylist_title_XPATH");

		// verify the property list
		switchVerification("propertylist_title_XPATH", "Property List", "The property list is not displayed.");

		// ADD THE RANDOM NUMBER OF COMMENTS IN THE NEWLY CREATED INSURANCE CLAIM RECORD
		title("ADD THE RANDOM NUMBER OF COMMENTS IN THE NEWLY CREATED INSURANCE CLAIM RECORD");

		try {
			// click on the risk management icon
			click("riskmanagementicon_CSS");

			// wait for the element
			explicitWaitClickable("menubtn_CSS");

			// click on the burger menu
			click("menubtn_CSS");

			// wait for the element
			Thread.sleep(5000);

			// click on the insurance claim
			click("riskmanagement_insuranceclaimoption_XPATH");

			// click on the newly created insurance claim
			String insuranceClaim = "//td[text()='" + incident + "']";
			driver.findElement(By.xpath(insuranceClaim)).click();
			consoleMessage("Clicked on the newly created insurance claim.");

			// click on the comment tab
			click("riskmanagement_insuranceclaim_commenttab_XPATH");

			for (int i = 0; i < commentCount; i++) {

				// click on the add comment button
				click("riskmanagement_insuranceclaim_addcommentbtn_XPATH");

				// validate the default roles and users are displayed or not
				try {
					String defaultName = "//span[text()='( Allowed Roles/Users : " + data.get("role_1") + " ,"
							+ data.get("user_1") + ")']";
					boolean defaultName_actual = driver.findElement(By.xpath(defaultName)).isDisplayed();

					if (defaultName_actual == true) {
						successMessage("The default roles and users are displayed successfully.");
					} else {
						verificationFailedMessage("The default roles and users are not displayed.");
					}
				} catch (Throwable t) {
					verificationFailedMessage("The default roles and users are not displayed.");
				}

				// enter the comment in the comment field
				String comment = RandomStringUtils.randomAlphabetic(8);
				type("riskmanagement_insuranceclaim_commenttxt_XPATH", comment);

				// click on the restricted checkbox
				click("riskmanagement_insuranceclaim_restrictedcommentckbx_XPATH");

				// click on the add button
				click("riskmanagement_insuranceclaim_addbutton_XPATH");

				// scroll down to bottom
				scrollBottom();

				// validate the added comment
				try {
					String commentText = "//p[text()='" + comment + "']";
					boolean commentText_actual = driver.findElement(By.xpath(commentText)).isDisplayed();

					if (commentText_actual == true) {
						successMessage("The added comment is displayed successfully.");
					} else {
						verificationFailedMessage("The added comment is not displayed.");
					}
				} catch (Throwable t) {
					verificationFailedMessage("The added comment is not displayed.");
				}

				// validate the restricted comment checkbox
				try {
					boolean restrictedcomment_actual = driver
							.findElement(By.xpath(
									OR.getProperty("riskmanagement_insuranceclaim_restrictedcommentckbxlist_XPATH")))
							.isSelected();

					if (restrictedcomment_actual == true) {
						successMessage("The restricted comment checkbox is displayed selected successfully.");
					} else {
						verificationFailedMessage("The restricted comment checkbox not displayed selected.");
					}

				} catch (Throwable t) {
					verificationFailedMessage("The restricted comment checkbox not displayed selected.");
				}

				// validate the cancel icon of the comment
				try {
					boolean cancelIcon = driver
							.findElement(By.xpath(
									OR.getProperty("riskmanagement_insuranceclaim_deleterestrictedcomment_XPATH")))
							.isDisplayed();

					if (cancelIcon == true) {
						successMessage("The cancel icon is displayed successfully.");
					} else {
						verificationFailedMessage(
								"The cancel icon is not displayed or it's displayed more than one time.");
					}

				} catch (Throwable t) {
					verificationFailedMessage("The cancel icon is not displayed or it's displayed more than one time.");
				}

				// scroll up to top
				scrollTop();

			}

			// validate the count of the comments
			try {
				String commentnumber = (driver
						.findElement(By.xpath(OR.getProperty("riskmanagement_insuranceclaim_commentcount_XPATH")))
						.getText()).trim();
				int commentnumber_int = Integer.parseInt(commentnumber);
				consoleMessage("commentCount :::::::::" + commentCount);
				consoleMessage("commentnumber_int :::::::::" + commentnumber_int);

				if (commentnumber_int == commentCount) {
					successMessage("The count of the comment is displayed correctly.");
				} else {
					verificationFailedMessage("The count of the comment is not displayed correctly.");
				}

			} catch (Throwable t) {
				verificationFailedMessage("The count of the comment is not displayed correctly.");
			}

			// click on the save button
			click("riskmanagement_insuranceclaim_saveinsuranceclaim_CSS");

			// enter the incident in the search field
			type("riskmanagement_insuranceclaim_searchtxt_CSS", incident);

			// validate the newly created insurance claim record
			try {
				String insuranceClaim1 = "//td[text()='" + incident + "']";
				boolean insuranceClaim1_actual = driver.findElement(By.xpath(insuranceClaim1)).isDisplayed();
				if (insuranceClaim1_actual == true) {
					successMessage("The newly created insurance claim record is displayed successfully.");
				} else {
					verificationFailedMessage("The newly created insurance claim record is not displayed.");
				}
			} catch (Throwable t) {
				verificationFailedMessage("The newly created insurance claim record is not displayed.");
			}

		} catch (Throwable t) {
			verificationFailed();
		}

		// click on the home icon
		click("questionnaire_homeburgermenubtn_hide_CSS");

		// wait for the element
		explicitWait("propertylist_title_XPATH");

		// verify the property list
		switchVerification("propertylist_title_XPATH", "Property List", "The property list is not displayed.");

		// DELETE THE NEWLY CREATED INSURANCE CLAIM
		title("DELETE THE NEWLY CREATED INSURANCE CLAIM");

		try {
			// click on the risk management icon
			click("riskmanagementicon_CSS");

			// wait for the element
			explicitWaitClickable("menubtn_CSS");

			// click on the burger menu
			click("menubtn_CSS");

			// wait for the element
			Thread.sleep(5000);

			// click on the insurance claim
			click("riskmanagement_insuranceclaimoption_XPATH");

			// click on the newly created insurance claim
			String insuranceClaim = "//td[text()='" + incident + "']";
			driver.findElement(By.xpath(insuranceClaim)).click();
			consoleMessage("Clicked on the newly created insurance claim.");

			// wait for the element
			explicitWaitClickable("riskmanagement_insurance_deletebtn_XPATH");

			// click on the delete button
			click("riskmanagement_insurance_deletebtn_XPATH");

			// wait for the element
			explicitWaitClickable("riskmanagement_insurance_confirmationdeletebtn_XPATH");

			// click on the delete button of confirmation popup
			click("riskmanagement_insurance_confirmationdeletebtn_XPATH");

			// enter the incident in the search field
			type("riskmanagement_insuranceclaim_searchtxt_CSS", incident);

			// validate the newdeleted insurance claim record
			try {
				String insuranceClaim1 = "//td[text()='" + incident + "']";
				boolean insuranceClaim1_actual = driver.findElement(By.xpath(insuranceClaim1)).isDisplayed();
				if (insuranceClaim1_actual == true) {
					verificationFailedMessage("The newly created insurance claim record is displayed.");
				} else {
					successMessage("The newly created insurance claim record is not displayed as expected.");
				}
			} catch (Throwable t) {
				successMessage("The newly created insurance claim record is not displayed as expected.");
			}

		} catch (Throwable t) {
			verificationFailed();
		}

		// click on the home icon
		click("questionnaire_homeburgermenubtn_hide_CSS");

		// wait for the element
		explicitWait("propertylist_title_XPATH");

		// verify the property list
		switchVerification("propertylist_title_XPATH", "Property List", "The property list is not displayed.");

		// RESET THE GIVEN PERMISSIONS
		title("RESET THE GIVEN PERMISSIONS");

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
			helper.resetPermission(data, "security_setting_1",
					"propertyproject_securitysettings_restrictedcomments_XPATH");

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
