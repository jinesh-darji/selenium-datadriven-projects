package testcases.smokesuite;

import java.io.IOException;
import java.time.LocalDate;
import java.util.Hashtable;
import java.util.List;
import java.util.Random;

import org.apache.commons.lang3.RandomStringUtils;
import org.apache.commons.text.CharacterPredicates;
import org.apache.commons.text.RandomStringGenerator;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.SkipException;
import org.testng.annotations.Test;

import com.google.inject.Key;
import com.mysql.cj.jdbc.NonRegisteringDriver;
import com.paulhammant.ngwebdriver.ByAngularBinding.NgFindByBuilder;
import com.relevantcodes.extentreports.LogStatus;

import base.Helper;
import base.TestBase;
import utilities.TestUtil;

public class RR5595Morguard10Test extends TestBase {

	@Test(dataProviderClass = TestUtil.class, dataProvider = "dp")
	public void rR5595Morguard10Test(Hashtable<String, String> data) throws IOException, InterruptedException {

		execution(data, "rR5595Morguard10Test");

		// refresh the page
		driver.navigate().refresh();
		Thread.sleep(5000);
		driver.navigate().refresh();

		String policyNumber = RandomStringUtils.randomAlphanumeric(12);
		String policyNumberDate = RandomStringUtils.randomAlphanumeric(12);
		String updatePolicyNumber = RandomStringUtils.randomAlphanumeric(12);

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

		// NEW POLICY IS ADDED AND AVAILABLE IN THE INSURANCE POLICIES DASHBOARD
		title("NEW POLICY IS ADDED AND AVAILABLE IN THE INSURANCE POLICIES DASHBOARD");

		try {

			// wait for the element
			Thread.sleep(5000);

			// click on the side menu
			click("menubtn_CSS");

			// wait for the element
			Thread.sleep(5000);

			// click on the risk management
			click("sidemenu_riskmanagement_CSS");

			// select insurance policies dashboard
			select("ssc_task_dashboarddd_CSS", data.get("insurance_policies"));

			// wait for the element
			Thread.sleep(3000);

			// click on the add button
			click("riskmanagement_insurance_addbtn_CSS");

			// enter the policy number
			type("riskmanagement_insurance_policynumbertxt_CSS", policyNumber);

			// select the policy type from the drop down
			select("riskmanagement_insurance_policytypedd_XPATH", data.get("policy_type"));

			// select the insurer from the drop down
			select("riskmanagement_insurance_insurerdd_XPATH", data.get("insurer"));

			// enter the description
			type("riskmanagement_insurance_descriptiontxt_XPATH", data.get("policy_description"));

			// click on the save button
			click("riskmanagement_insurance_savebtn_XPATH");

			// enter the newly created insurance policy in the search field
			type("riskmanagement_insurance_searchtxt_XPATH", policyNumber);

			// verify newly created insurance policy is displayed or not
			try {
				String str2 = (driver.findElement(By.xpath("//td[text()='" + policyNumber + "']")).getText()).trim();

				if (str2.equals(policyNumber)) {
					successMessage("The " + policyNumber + " is verified successfully.");
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

		// UPDATE THE NEWLY CREATED POLICY
		title("UPDATE THE NEWLY CREATED POLICY");

		try {

			// wait for the element
			Thread.sleep(5000);

			// click on the side menu
			click("menubtn_CSS");

			// wait for the element
			Thread.sleep(5000);

			// click on the risk management
			click("sidemenu_riskmanagement_CSS");

			// wait for the element
			Thread.sleep(5000);

			// select insurance policies dashboard
			select("ssc_task_dashboarddd_CSS", data.get("insurance_policies"));

			// wait for the element
			Thread.sleep(3000);

			// enter the newly created policy in the search field

			type("task_listofchecklist_filterfield_CSS", policyNumber);

			// click on the newly created insurance policy
			String insurancePolicy_XPATH = "//td[text()='" + policyNumber + "']";
			driver.findElement(By.xpath(insurancePolicy_XPATH)).click();

			// enter the policy number

			type("riskmanagement_insurance_policynumbertxt_CSS", updatePolicyNumber);

			// select the policy type from the drop down
			select("riskmanagement_insurance_policytypedd_XPATH", data.get("update_policy_type"));

			// enter the description

			type("riskmanagement_insurance_descriptiontxt_XPATH", data.get("update_policy_description"));

			// click on the update button
			click("riskmanagement_insurance_updatebtn_XPATH");

			// enter the newly created insurance policy in the search field

			type("riskmanagement_insurance_searchtxt_XPATH", policyNumber);

			// verify newly created insurance policy is displayed or not
			try {
				String str3 = (driver.findElement(By.xpath("//td[text()='" + updatePolicyNumber + "']")).getText())
						.trim();

				if (str3.equals(updatePolicyNumber)) {
					successMessage("The " + updatePolicyNumber + " is verified successfully.");
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

		// VERIFY REVISION EFFECTIVE DATE AND REVISION EXPIRY DATE WHILE CREATING THE
		// INSURANCE POLICY
		title("VERIFY REVISION EFFECTIVE DATE AND REVISION EXPIRY DATE WHILE CREATING THE INSURANCE POLICY");

		try {

			// wait for the element
			Thread.sleep(5000);

			// click on the side menu
			click("menubtn_CSS");

			// wait for the element
			Thread.sleep(5000);

			// click on the risk management
			click("sidemenu_riskmanagement_CSS");

			// select insurance policies dashboard
			select("ssc_task_dashboarddd_CSS", data.get("insurance_policies"));

			// wait for the element
			Thread.sleep(3000);

			// click on the add button
			click("riskmanagement_insurance_addbtn_CSS");

			// enter the policy number

			type("riskmanagement_insurance_policynumbertxt_CSS", policyNumberDate);

			// select the policy type from the drop down
			select("riskmanagement_insurance_policytypedd_XPATH", data.get("policy_type"));

			// select the insurer from the drop down
			select("riskmanagement_insurance_insurerdd_XPATH", data.get("insurer"));

			// enter the description

			type("riskmanagement_insurance_descriptiontxt_XPATH", data.get("policy_description"));

			// scroll down the screen
			scrollTillElement("riskmanagement_insurance_policyrevisioninformationlbl_XPATH");
			scrollByPixel(-200);

			// verify the Term Effective Date and Term Expiry Date

			LocalDate currentDate = LocalDate.now();
			String Current_Date = currentDate.toString();
			String Term_Effective_Date = driver
					.findElement(By.xpath(OR.getProperty("riskmanagement_insurance_termeffectivedatetxt_XPATH")))
					.getAttribute("value");

			if (Current_Date.equals(Term_Effective_Date)) {
				successMessage("THE TERM EFFECTIVE DATE IS DISPLAYED CORRECT AS EXPECTED.");
			} else {

				verificationFailedMessage("THE TERM EFFECTIVE DATE IS NOT DISPLAYED CORRECTLY.");
			}

			String Term_Expiry_Date = driver
					.findElement(By.xpath(OR.getProperty("riskmanagement_insurance_termexpirydatetxt_XPATH")))
					.getAttribute("value");

			if (Current_Date.equals(Term_Expiry_Date)) {
				successMessage("THE TERM EXPIRY DATE IS DISPLAYED CORRECT AS EXPECTED.");
			} else {

				verificationFailedMessage("THE TERM EXPIRY DATE IS NOT DISPLAYED CORRECTLY.");
			}

			// Update the term expiry date

			LocalDate futureDate = LocalDate.now().plusMonths(1);
			String Future_Date = futureDate.toString();

			type("riskmanagement_insurance_termexpirydatetxt_XPATH", Future_Date);

			// click on the save button
			click("riskmanagement_insurance_savebtn_XPATH");

		} catch (Throwable t) {
			verificationFailed();
		}

		// click on the home icon from the top of the screen
		click("questionnaire_homeburgermenubtn_hide_CSS");

		// synchronization
		explicitWait("propertylist_title_XPATH");

		// verify the property list
		switchVerification("propertylist_title_XPATH", "Property List", "The property list is not displayed.");

		// VERIFY TH NEW REVISION DATE IN THE NEWLY CREATED INSURANCE POLICY
		title("VERIFY TH NEW REVISION DATE IN THE NEWLY CREATED INSURANCE POLICY");

		try {

			// wait for the element
			Thread.sleep(5000);

			// click on the side menu
			click("menubtn_CSS");

			// wait for the element
			Thread.sleep(5000);

			// click on the risk management
			click("sidemenu_riskmanagement_CSS");

			// select insurance policies dashboard
			select("ssc_task_dashboarddd_CSS", data.get("insurance_policies"));

			// wait for the element
			Thread.sleep(3000);

			// enter the newly created policy in the search field

			type("task_listofchecklist_filterfield_CSS", policyNumber);

			// click on the newly created insurance policy
			String insurancePolicyDate_XPATH = "//td[text()='" + policyNumberDate + "']";
			driver.findElement(By.xpath(insurancePolicyDate_XPATH)).click();

			// click on the new revision button
			click("riskmanagement_insurance_newrevisionbtn_XPATH");

			// verify the Revision Effective Date and Term Expiry Date

			LocalDate currentDate = LocalDate.now();
			String Current_Date = currentDate.toString();
			String New_Term_Effective_Date = driver
					.findElement(By.xpath(OR.getProperty("riskmanagement_insurance_newtermeffectivedatetxt_XPATH")))
					.getAttribute("value");

			if (Current_Date.equals(New_Term_Effective_Date)) {
				successMessage("THE REVISION EFFECTIVE DATE IS DISPLAYED CORRECT AS EXPECTED.");

			} else {

				verificationFailedMessage("THE REVISION EFFECTIVE DATE IS NOT DISPLAYED CORRECTLY.");
			}

			LocalDate futureDate = LocalDate.now().plusMonths(1);
			String Future_Date = futureDate.toString();
			String New_Term_Expiry_Date = driver
					.findElement(By.xpath(OR.getProperty("riskmanagement_insurance_newtermexpirydatetxt_XPATH")))
					.getAttribute("value");

			if (Future_Date.equals(New_Term_Expiry_Date)) {
				successMessage("THE REVISION EXPIRY DATE IS DISPLAYED CORRECT AS EXPECTED.");
			} else {

				verificationFailedMessage("THE REVISION EXPIRY DATE IS NOT DISPLAYED CORRECTLY.");
			}

			// Update the revision expiry date
			LocalDate newFutureDate = LocalDate.now().plusMonths(1).minusDays(7);
			String New_Future_Date = newFutureDate.toString();

			type("riskmanagement_insurance_newtermexpirydatetxt_XPATH", New_Future_Date);

			// click on the add revision button
			click("riskmanagement_insurance_addrevisionbtn_XPATH");

			// scroll down the screen
			scrollTillElement("riskmanagement_insurance_policyrevisioninformationlbl_XPATH");
			scrollByPixel(-200);

			// verify the Revision Effective Date and Term Expiry Date

			String New1_Term_Effective_Date = driver
					.findElement(By.xpath(OR.getProperty("riskmanagement_insurance_termeffectivedatetxt_XPATH")))
					.getAttribute("value");

			if (Current_Date.equals(New1_Term_Effective_Date)) {
				successMessage("THE REVISION EFFECTIVE DATE IS DISPLAYED CORRECT AS EXPECTED.");
			} else {

				verificationFailedMessage("THE REVISION EFFECTIVE DATE IS NOT DISPLAYED CORRECTLY.");
			}

			String New1_Term_Expiry_Date = driver
					.findElement(By.xpath(OR.getProperty("riskmanagement_insurance_termexpirydatetxt_XPATH")))
					.getAttribute("value");

			if (New_Future_Date.equals(New1_Term_Expiry_Date)) {
				successMessage("THE REVISION EXPIRY DATE IS DISPLAYED CORRECT AS EXPECTED.");
			} else {

				verificationFailedMessage("THE REVISION EXPIRY DATE IS NOT DISPLAYED CORRECTLY.");
			}

			// click on the update button
			click("riskmanagement_insurance_updatebtn_XPATH");

			// click on the cancel button
			click("riskmanagement_insurance_cancelbtn_XPATH");

		} catch (Throwable t) {
			verificationFailed();
		}

		// click on the home icon from the top of the screen
		click("questionnaire_homeburgermenubtn_hide_CSS");

		// synchronization
		explicitWait("propertylist_title_XPATH");

		// verify the property list
		switchVerification("propertylist_title_XPATH", "Property List", "The property list is not displayed.");

		// DELETE BOTH NEWLY CREATED INSURANCE POLICIES
		title("DELETE BOTH NEWLY CREATED INSURANCE POLICIES");

		try {

			// wait for the element
			Thread.sleep(5000);

			// click on the side menu
			click("menubtn_CSS");

			// wait for the element
			Thread.sleep(5000);

			// click on the risk management
			click("sidemenu_riskmanagement_CSS");

			// select insurance policies dashboard
			select("ssc_task_dashboarddd_CSS", data.get("insurance_policies"));

			// wait for the element
			Thread.sleep(3000);

			// enter the policy number in the search field

			type("riskmanagement_insuranceclaim_searchtxt_CSS", updatePolicyNumber);

			// click on the newly created insurance policy
			String updateinsurancePolicy_XPATH = "//td[text()='" + updatePolicyNumber + "']";
			driver.findElement(By.xpath(updateinsurancePolicy_XPATH)).click();

			// wait for the element
			Thread.sleep(5000);

			// click on the delete button
			click("riskmanagement_insurance_deletebtn_XPATH");

			// wait for the element
			Thread.sleep(5000);

			// click on the delete button of the confirmation popup
			click("riskmanagement_insurance_confirmationdeletebtn_XPATH");

			// wait for the element
			Thread.sleep(5000);

			// enter the policy number in the search field

			type("riskmanagement_insuranceclaim_searchtxt_CSS", policyNumberDate);

			// click on the newly created insurance policy
			String insurancePolicyDate_XPATH = "//td[text()='" + policyNumberDate + "']";
			click(insurancePolicyDate_XPATH);

			// wait for the element
			Thread.sleep(5000);

			// click on the delete button
			click("riskmanagement_insurance_deletebtn_XPATH");

			// wait for the element
			Thread.sleep(5000);

			// click on the delete button of the confirmation popup
			click("riskmanagement_insurance_confirmationdeletebtn_XPATH");

			// wait for the element
			Thread.sleep(5000);

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