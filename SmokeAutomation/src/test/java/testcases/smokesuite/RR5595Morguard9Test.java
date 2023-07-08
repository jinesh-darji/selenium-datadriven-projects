package testcases.smokesuite;

import java.io.IOException;
import java.util.Hashtable;

import org.apache.commons.lang3.RandomStringUtils;
import org.apache.commons.text.CharacterPredicates;
import org.apache.commons.text.RandomStringGenerator;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.testng.Reporter;
import org.testng.SkipException;
import org.testng.annotations.Test;

import com.relevantcodes.extentreports.LogStatus;

import base.Helper;
import base.TestBase;
import utilities.TestUtil;

public class RR5595Morguard9Test extends TestBase {

	@Test(dataProviderClass = TestUtil.class, dataProvider = "dp")
	public void rR5595Morguard9Test(Hashtable<String, String> data) throws IOException, InterruptedException {

		execution(data, "rR5595Morguard9Test");

		String incidentnumber = RandomStringUtils.randomAlphanumeric(12);
		String insurerclaimnumber = RandomStringUtils.randomAlphanumeric(12);
		String adjusterclaimnumber = RandomStringUtils.randomAlphanumeric(12);
		String updateincidentnumber = RandomStringUtils.randomAlphanumeric(12);
		String updateinsurerclaimnumber = RandomStringUtils.randomAlphanumeric(12);
		String updateadjusterclaimnumber = RandomStringUtils.randomAlphanumeric(12);

		// refresh the page
		driver.navigate().refresh();
		Thread.sleep(5000);
		driver.navigate().refresh();

		// LOGIN WITH ADMIN USER
		title("LOGIN WITH ADMIN USER");

		try {
			// wait for the element
			explicitWaitClickable("signinbtn_BTNTEXT");

			// Enter the username
			type("usernametxt_CSS", data.get("username_1"));

			// Enter the password
			type("passwordtxt_CSS", data.get("password_1"));

			// Clicking on the "Sign In" button
			click("signinbtn_BTNTEXT");

			// wait for the element
			explicitWait("propertylist_title_XPATH");

			// verify the property list
			switchVerification("propertylist_title_XPATH", "Property List", "The property list is not displayed.");

			// UPDATE THE SYSTEM COMPANY
			updateCompany(data);

		} catch (Throwable t) {
			verificationFailed();
		}

		// THE DETAILS OF THE CLAIMS TAB SHOULD BE SAVED AND UPDATED DETAILS SHOULD
		// UPDATE SUCCESSFULLY.
		title("THE DETAILS OF THE CLAIMS TAB SHOULD BE SAVED AND UPDATED DETAILS SHOULD UPDATE SUCCESSFULLY.");

		// CREATE NEW INSURANCE CLAIM
		title("CREATE NEW INSURANCE CLAIM");

		try {
			// enter the property name in the search field

			type("envreports_propertylist_filtertxt_CSS", data.get("property_2"));

			// click on the risk management icon from the property list page
			click("riskmanagementicon_CSS");

			// wait for the element
			Thread.sleep(5000);

			// click on the burger menu
			click("menubtn_CSS");

			// wait for the element
			Thread.sleep(5000);

			// click on the insurance claims option
			click("riskmanagement_insuranceclaimsoption_XPATH");

			// click on the add button
			click("riskmanagement_addinsuranceclaimbtn_XPATH");

			// enter the details in the incident field

			type("riskmanagement_insuranceclaim_incidenttxt_CSS", incidentnumber);

			// enter the details in the claim status field
			select("riskmanagement_insuranceclaim_claimstatusdd_CSS", data.get("claim_status"));

			// enter the details in the claim status field
			select("riskmanagement_insuranceclaim_claimtypedd_CSS", data.get("claim_type"));

			// click on the incident date field
			click("riskmanagement_insuranceclaim_incidentdatedp_XPATH");

			// click on the today's button of the incident date field
			click("riskmanagement_insuranceclaim_incidentdatedp_todaybtn_XPATH");

			// enter the details in the property damage estimation field

			type("riskmanagement_insuranceclaim_claimtypedd_CSS", "123");

			// enter the details in the incident details field

			type("riskmanagement_insuranceclaim_incidentdetailstxt_XPATH", data.get("incident_details"));

			// scroll down the screen

			scrollByPixel(500);

			// enter the details in the loss summary statement field

			type("riskmanagement_insuranceclaim_losssummarystatementtxt_CSS", data.get("loss_summary"));

			// enter the details in the property damage estimation field

			type("riskmanagement_insuranceclaim_insurerclaimtxt_XPATH", insurerclaimnumber);

			// enter the details in the property damage estimation field

			type("riskmanagement_insuranceclaim_adjusterclaimtxt_XPATH", adjusterclaimnumber);

			// click on the save button
			click("riskmanagement_insuranceclaim_savebtn_XPATH");

			// wait for the element
			explicitWaitClickable("closetoastmsg_CSS");

			// click on the toaster close button
			click("closetoastmsg_CSS");

			// verify insurance number of the newly created insurance claim
			String insurancenumber_XPATH = "//td[text()='" + incidentnumber + "']";
			switchVerification(insurancenumber_XPATH, incidentnumber, "The " + incidentnumber + " is not displayed.");

			// verify claim number of the newly created insurance claim
			String insurerclaimnumber_XPATH = "//td[text()='" + incidentnumber + "']//following-sibling::td[text()='"
					+ insurerclaimnumber + "']";
			switchVerification(insurerclaimnumber_XPATH, insurerclaimnumber,
					"The " + insurerclaimnumber + " is not displayed.");

			// verify claimant name of the newly created insurance claim
			String claimantname_XPATH = "//td[text()='" + incidentnumber + "']//following-sibling::td[text()='"
					+ data.get("claimant_name") + "']";
			switchVerification(claimantname_XPATH, data.get("claimant_name"),
					"The " + data.get("claimant_name") + " is not displayed.");

			// verify loss description of the newly created insurance claim
			String lossdescription_XPATH = "//td[text()='" + incidentnumber + "']//following-sibling::td[text()='"
					+ data.get("loss_summary") + "']";
			switchVerification(lossdescription_XPATH, data.get("loss_summary"),
					"The " + data.get("loss_summary") + " is not displayed.");

		} catch (Throwable t) {
			verificationFailed();
		}

		// click on the home icon from the top of the screen
		click("questionnaire_homeburgermenubtn_hide_CSS");

		// synchronization
		explicitWait("propertylist_title_XPATH");

		// verify the property list
		switchVerification("propertylist_title_XPATH", "Property List", "The property list is not displayed.");

		// UPDATE THE NEWLY INSURANCE CLAIM
		title("UPDATE THE NEWLY INSURANCE CLAIM");

		try {
			// enter the property name in the search field

			type("envreports_propertylist_filtertxt_CSS", data.get("property_2"));

			// click on the risk management icon from the property list page
			click("riskmanagementicon_CSS");

			// wait for the element
			Thread.sleep(5000);

			// click on the burger menu
			click("menubtn_CSS");

			// wait for the element
			Thread.sleep(5000);

			// click on the insurance claims option
			click("riskmanagement_insuranceclaimsoption_XPATH");

			// enter insurance claim number in search field
			type("ohs_incident_searchtxt_XPATH", incidentnumber);

			// click on the newly created insurance claim
			String insurancenumber_XPATH = "//td[text()='" + incidentnumber + "']";
			driver.findElement(By.xpath(insurancenumber_XPATH)).click();

			// enter the details in the claim status field
			select("riskmanagement_insuranceclaim_claimstatusdd_CSS", data.get("update_claim_status"));

			// enter the details in the claim status field
			select("riskmanagement_insuranceclaim_claimtypedd_CSS", data.get("update_claim_type"));

			// scroll down the screen

			scrollByPixel(500);

			// enter the details in the loss summary statement field

			type("riskmanagement_insuranceclaim_losssummarystatementtxt_CSS", data.get("update_loss_summary"));

			// enter the details in the insurance claim field

			type("riskmanagement_insuranceclaim_insurerclaimtxt_XPATH", updateinsurerclaimnumber);

			// enter the details in the property damage estimation field

			type("riskmanagement_insuranceclaim_adjusterclaimtxt_XPATH", updateadjusterclaimnumber);

			// ADD TASK IN THE NEWLY CREATED INSURANCE CLAIM
			title("ADD TASK IN THE NEWLY CREATED INSURANCE CLAIM");

			// scroll up the screen
			scrollTop();

			// click on the task tab
			click("riskmanagement_insuranceclaim_tasktab_XPATH");

			// click on the new task button
			click("riskmanagement_insuranceclaim_newtaskbtn_XPATH");

			// enter the title of the task
			type("riskmanagement_insuranceclaim_task_titletxt_XPATH", data.get("task_title"));

			// enter the location of the task
			type("riskmanagement_insuranceclaim_task_locationtxt_XPATH", data.get("task_location"));

			// click on the save button
			click("riskmanagement_insuranceclaim_task_savebtn_XPATH");

			// verify the newly created task name
			switchVerification("riskmanagement_insuranceclaim_task_createdtasktext_XPATH", "Test Task Title Morguard 9",
					"The Test Task Title Morguard 9 is not displayed.");

			// ADD COMMENT IN THE NEWLY CREATED INSURANCE CLAIM
			title("ADD COMMENT IN THE NEWLY CREATED INSURANCE CLAIM");

			// click on the comment tab
			click("riskmanagement_insuranceclaim_commenttab_XPATH");

			// type comment in the comment field
			type("riskmanagement_insuranceclaim_comment_commenttxt_XPATH", data.get("comment_claim"));

			// click on the restriction comment checkbox
			click("riskmanagement_insuranceclaim_comment_restrictionckbx_XPATH");

			// click on the save button
			click("riskmanagement_insuranceclaim_savebtn_XPATH");

			// wait for the element
			explicitWaitClickable("closetoastmsg_CSS");

			// click on the toaster close button
			click("closetoastmsg_CSS");

			// verify insurance number of the updated insurance claim
			String updateinsurancenumber_XPATH = "//td[text()='" + updateincidentnumber + "']";
			switchVerification(updateinsurancenumber_XPATH, updateincidentnumber,
					"The " + updateincidentnumber + " is not displayed.");

			// verify claim number of the updated insurance claim
			String updateinsurerclaimnumber_XPATH = "//td[text()='" + updateincidentnumber
					+ "']//following-sibling::td[text()='" + updateinsurerclaimnumber + "']";
			switchVerification(updateinsurerclaimnumber_XPATH, updateinsurerclaimnumber,
					"The " + updateinsurerclaimnumber + " is not displayed.");

			// verify claimant name of the updated insurance claim
			String updateclaimantname_XPATH = "//td[text()='" + updateincidentnumber
					+ "']//following-sibling::td[text()='" + data.get("claimant_name") + "']";
			switchVerification(updateclaimantname_XPATH, data.get("updated_claimant_name"),
					"The " + data.get("updated_claimant_name") + " is not displayed.");

			// verify loss description of the updated insurance claim
			String updatelossdescription_XPATH = "//td[text()='" + updateincidentnumber
					+ "']//following-sibling::td[text()='" + data.get("updated_loss_summary") + "']";
			switchVerification(updatelossdescription_XPATH, data.get("updated_loss_summary"),
					"The " + data.get("updated_loss_summary") + " is not displayed.");

		} catch (Throwable t) {
			verificationFailed();
		}

		// click on the home icon from the top of the screen
		click("questionnaire_homeburgermenubtn_hide_CSS");

		// synchronization
		explicitWait("propertylist_title_XPATH");

		// verify the property list
		switchVerification("propertylist_title_XPATH", "Property List", "The property list is not displayed.");

		// VERIFY NEWLY ADDED COMMENT IN THE ADMIN USER
		title("VERIFY NEWLY ADDED COMMENT IN THE ADMIN USER");

		try {
			// enter the property name in the search field

			type("envreports_propertylist_filtertxt_CSS", data.get("property_2"));

			// click on the risk management icon from the property list page
			click("riskmanagementicon_CSS");

			// wait for the element
			Thread.sleep(5000);

			// click on the burger menu
			click("menubtn_CSS");

			// wait for the element
			Thread.sleep(5000);

			// click on the insurance claims option
			click("riskmanagement_insuranceclaimsoption_XPATH");

			// enter insurance claim number in search field
			type("ohs_incident_searchtxt_XPATH", incidentnumber);

			// click on the updated insurance claim
			String insurancenumber_XPATH = "//td[text()='" + incidentnumber + "']";
			driver.findElement(By.xpath(insurancenumber_XPATH)).click();

			// click on the comment tab
			click("riskmanagement_insuranceclaim_commenttab_XPATH");

			// scroll down the screen

			scrollByPixel(500);

			// verify the newly added comment
			switchVerification("riskmanagement_insuranceclaim_comment_addedcomment_XPATH",
					"Test Claim Comment Morguard 9", "The Test Claim Comment Morguard 9 is not displayed.");

		} catch (Throwable t) {
			verificationFailed();
		}

		// click on the home icon from the top of the screen
		click("questionnaire_homeburgermenubtn_hide_CSS");

		// synchronization
		explicitWait("propertylist_title_XPATH");

		// verify the property list
		switchVerification("propertylist_title_XPATH", "Property List", "The property list is not displayed.");

		// DELETE THE UPDATED INSURANCE CLAIM
		title("DELETE THE UPDATED INSURANCE CLAIM");

		try {
			// enter the property name in the search field

			type("envreports_propertylist_filtertxt_CSS", data.get("property_2"));

			// click on the risk management icon from the property list page
			click("riskmanagementicon_CSS");

			// wait for the element
			Thread.sleep(5000);

			// click on the burger menu
			click("menubtn_CSS");

			// wait for the element
			Thread.sleep(5000);

			// click on the insurance claims option
			click("riskmanagement_insuranceclaimsoption_XPATH");

			// enter insurance claim number in search field
			type("ohs_incident_searchtxt_XPATH", incidentnumber);

			// click on the updated insurance claim
			String insurancenumber_XPATH = "//td[text()='" + incidentnumber + "']";
			driver.findElement(By.xpath(insurancenumber_XPATH)).click();

			// click on the delete button
			click("riskmanagement_insuranceclaim_deletebtn_XPATH");

			// click on the delete button of the confirmation popup
			click("riskmanagement_insuranceclaim_confirmationdeletebtn_XPATH");

			// wait for the element
			explicitWaitClickable("closetoastmsg_CSS");

			// click on the toaster close button
			click("closetoastmsg_CSS");

			// verify insurance claim delete or not
			String updateinsurerclaimnumber_XPATH = "//td[text()='" + updateincidentnumber
					+ "']//following-sibling::td[text()='" + updateinsurerclaimnumber + "']";
			deleteVerification(updateinsurerclaimnumber_XPATH, updateinsurerclaimnumber);

		} catch (Throwable t) {
			verificationFailed();
		}

		// click on the home icon from the top of the screen
		click("questionnaire_homeburgermenubtn_hide_CSS");

		// synchronization
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

			// wait for the element
			explicitWaitClickable("signinbtn_BTNTEXT");

		} catch (Throwable t) {
			verificationFailed();
		}

	}
}