package testcases.smokesuite;

import java.io.IOException;
import java.time.LocalDate;
import java.util.Hashtable;
import java.util.List;
import java.util.Random;

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

		if (!(TestUtil.isTestRunnable("rR5595Morguard10Test", excel))) {

			throw new SkipException(
					"Skipping the test " + "rR5595Morguard10Test".toUpperCase() + "as the Run mode is NO");
		}

		if (!data.get("runmode").equals("Y")) {

			throw new SkipException("Skipping the test case as the Run Mode for data set is NO");
		}

		RandomStringGenerator randomStringGenerator = new RandomStringGenerator.Builder().withinRange('0', 'z')
				.filteredBy(CharacterPredicates.LETTERS, CharacterPredicates.DIGITS).build();
		String policyNumber = randomStringGenerator.generate(12);
		String policyNumberDate = randomStringGenerator.generate(12);
		String updatePolicyNumber = randomStringGenerator.generate(12);

		// refresh the page
		driver.navigate().refresh();
		Thread.sleep(5000);
		driver.navigate().refresh();

		// LOGIN WITH ADMIN USER

		System.out.println("******************** LOGIN WITH ADMIN USER ********************");
		test.log(LogStatus.INFO, "******************** LOGIN WITH ADMIN USER ********************");
		Reporter.log("******************** LOGIN WITH ADMIN USER ********************");
		log.info("******************** LOGIN WITH ADMIN USER ********************");

		try {
			// wait for the element
			explicitWaitClickable("signinbtn_BTNTEXT");

			// Enter the username
			type("usernametxt_CSS", data.get("username_1"));
			ngDriver.waitForAngularRequestsToFinish();
			System.out.println("Entered the username.");

			// Enter the password
			type("passwordtxt_CSS", data.get("password_1"));
			ngDriver.waitForAngularRequestsToFinish();
			System.out.println("Entered the password.");

			// Clicking on the "Sign In" button
			click("signinbtn_BTNTEXT");
			ngDriver.waitForAngularRequestsToFinish();
			System.out.println("Clicked on the sign in button.");

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

		System.out.println(
				"******************** NEW POLICY IS ADDED AND AVAILABLE IN THE INSURANCE POLICIES DASHBOARD ********************");
		test.log(LogStatus.INFO,
				"******************** NEW POLICY IS ADDED AND AVAILABLE IN THE INSURANCE POLICIES DASHBOARD ********************");
		Reporter.log(
				"******************** NEW POLICY IS ADDED AND AVAILABLE IN THE INSURANCE POLICIES DASHBOARD ********************");
		log.info(
				"******************** NEW POLICY IS ADDED AND AVAILABLE IN THE INSURANCE POLICIES DASHBOARD ********************");

		try {

			// wait for the element
			Thread.sleep(5000);

			// click on the side menu
			click("menubtn_CSS");
			ngDriver.waitForAngularRequestsToFinish();
			System.out.println("Clicked on the side menu.");

			// wait for the element
			Thread.sleep(5000);

			// click on the risk management
			click("sidemenu_riskmanagement_CSS");
			ngDriver.waitForAngularRequestsToFinish();
			System.out.println("Clicked on the risk management.");

			// select insurance policies dashboard
			select("ssc_task_dashboarddd_CSS", data.get("insurance_policies"));
			ngDriver.waitForAngularRequestsToFinish();
			System.out.println("Selected insurance policies dashboard.");

			// wait for the element
			Thread.sleep(3000);

			// click on the add button
			click("riskmanagement_insurance_addbtn_CSS");
			ngDriver.waitForAngularRequestsToFinish();
			System.out.println("Clicked on the add button.");

			// enter the policy number
			clear("riskmanagement_insurance_policynumbertxt_CSS");
			type("riskmanagement_insurance_policynumbertxt_CSS", policyNumber);
			ngDriver.waitForAngularRequestsToFinish();
			System.out.println("Entered the policy number.");

			// select the policy type from the drop down
			select("riskmanagement_insurance_policytypedd_XPATH", data.get("policy_type"));
			ngDriver.waitForAngularRequestsToFinish();
			System.out.println("Selected the policy type from the drop down.");

			// select the insurer from the drop down
			select("riskmanagement_insurance_insurerdd_XPATH", data.get("insurer"));
			ngDriver.waitForAngularRequestsToFinish();
			System.out.println("Selected the insurer from the drop down.");

			// enter the description
			clear("riskmanagement_insurance_descriptiontxt_XPATH");
			type("riskmanagement_insurance_descriptiontxt_XPATH", data.get("policy_description"));
			ngDriver.waitForAngularRequestsToFinish();
			System.out.println("Entered the description.");

			// click on the save button
			click("riskmanagement_insurance_savebtn_XPATH");
			ngDriver.waitForAngularRequestsToFinish();
			System.out.println("Clicked on the save button.");

			// enter the newly created insurance policy in the search field
			clear("riskmanagement_insurance_searchtxt_XPATH");
			type("riskmanagement_insurance_searchtxt_XPATH", policyNumber);
			ngDriver.waitForAngularRequestsToFinish();
			System.out.println("Entered the newly created insurance policy in the search field.");

			// verify newly created insurance policy is displayed or not
			try {
				String str2 = (driver.findElement(By.xpath("//td[text()='" + policyNumber + "']")).getText()).trim();
				ngDriver.waitForAngularRequestsToFinish();
				if (str2.equals(policyNumber)) {

					System.out.println("The " + policyNumber + " is verified successfully.");
					test.log(LogStatus.INFO, "The " + policyNumber + " is verified successfully.");
					Reporter.log("The " + policyNumber + " is verified successfully.");
					log.info("The " + policyNumber + " is verified successfully.");
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
		System.out.println("Clicked on the home icon from the top of the screen.");
		ngDriver.waitForAngularRequestsToFinish();

		// synchronization
		explicitWait("propertylist_title_XPATH");

		// verify the property list
		switchVerification("propertylist_title_XPATH", "Property List", "The property list is not displayed.");

		// UPDATE THE NEWLY CREATED POLICY

		System.out.println("******************** UPDATE THE NEWLY CREATED POLICY ********************");
		test.log(LogStatus.INFO, "******************** UPDATE THE NEWLY CREATED POLICY ********************");
		Reporter.log("******************** UPDATE THE NEWLY CREATED POLICY ********************");
		log.info("******************** UPDATE THE NEWLY CREATED POLICY ********************");

		try {

			// wait for the element
			Thread.sleep(5000);

			// click on the side menu
			click("menubtn_CSS");
			ngDriver.waitForAngularRequestsToFinish();
			System.out.println("Clicked on the side menu.");

			// wait for the element
			Thread.sleep(5000);

			// click on the risk management
			click("sidemenu_riskmanagement_CSS");
			ngDriver.waitForAngularRequestsToFinish();
			System.out.println("Clicked on the risk management.");

			// wait for the element
			Thread.sleep(5000);

			// select insurance policies dashboard
			select("ssc_task_dashboarddd_CSS", data.get("insurance_policies"));
			ngDriver.waitForAngularRequestsToFinish();
			System.out.println("Selected insurance policies dashboard.");

			// wait for the element
			Thread.sleep(3000);

			// enter the newly created policy in the search field
			clear("task_listofchecklist_filterfield_CSS");
			type("task_listofchecklist_filterfield_CSS", policyNumber);
			ngDriver.waitForAngularRequestsToFinish();
			System.out.println("Entered the newly created policy in the search field.");

			// click on the newly created insurance policy
			String insurancePolicy_XPATH = "//td[text()='" + policyNumber + "']";
			driver.findElement(By.xpath(insurancePolicy_XPATH)).click();
			ngDriver.waitForAngularRequestsToFinish();
			System.out.println("Clicked on the newly created insurance policy.");

			// enter the policy number
			clear("riskmanagement_insurance_policynumbertxt_CSS");
			type("riskmanagement_insurance_policynumbertxt_CSS", updatePolicyNumber);
			ngDriver.waitForAngularRequestsToFinish();
			System.out.println("Entered the policy number.");

			// select the policy type from the drop down
			select("riskmanagement_insurance_policytypedd_XPATH", data.get("update_policy_type"));
			ngDriver.waitForAngularRequestsToFinish();
			System.out.println("Selected the policy type from the drop down.");

			// enter the description
			clear("riskmanagement_insurance_descriptiontxt_XPATH");
			type("riskmanagement_insurance_descriptiontxt_XPATH", data.get("update_policy_description"));
			ngDriver.waitForAngularRequestsToFinish();
			System.out.println("Entered the description.");

			// click on the update button
			click("riskmanagement_insurance_updatebtn_XPATH");
			ngDriver.waitForAngularRequestsToFinish();
			System.out.println("Clicked on the update button.");

			// enter the newly created insurance policy in the search field
			clear("riskmanagement_insurance_searchtxt_XPATH");
			type("riskmanagement_insurance_searchtxt_XPATH", policyNumber);
			ngDriver.waitForAngularRequestsToFinish();
			System.out.println("Entered the newly created insurance policy in the search field.");

			// verify newly created insurance policy is displayed or not
			try {
				String str3 = (driver.findElement(By.xpath("//td[text()='" + updatePolicyNumber + "']")).getText())
						.trim();
				ngDriver.waitForAngularRequestsToFinish();
				if (str3.equals(updatePolicyNumber)) {

					System.out.println("The " + updatePolicyNumber + " is verified successfully.");
					test.log(LogStatus.INFO, "The " + updatePolicyNumber + " is verified successfully.");
					Reporter.log("The " + updatePolicyNumber + " is verified successfully.");
					log.info("The " + updatePolicyNumber + " is verified successfully.");
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
		System.out.println("Clicked on the home icon from the top of the screen.");
		ngDriver.waitForAngularRequestsToFinish();

		// synchronization
		explicitWait("propertylist_title_XPATH");

		// verify the property list
		switchVerification("propertylist_title_XPATH", "Property List", "The property list is not displayed.");

		// VERIFY REVISION EFFECTIVE DATE AND REVISION EXPIRY DATE WHILE CREATING THE
		// INSURANCE POLICY

		System.out.println(
				"******************** VERIFY REVISION EFFECTIVE DATE AND REVISION EXPIRY DATE WHILE CREATING THE INSURANCE POLICY ********************");
		test.log(LogStatus.INFO,
				"******************** VERIFY REVISION EFFECTIVE DATE AND REVISION EXPIRY DATE WHILE CREATING THE INSURANCE POLICY ********************");
		Reporter.log(
				"******************** VERIFY REVISION EFFECTIVE DATE AND REVISION EXPIRY DATE WHILE CREATING THE INSURANCE POLICY ********************");
		log.info(
				"******************** VERIFY REVISION EFFECTIVE DATE AND REVISION EXPIRY DATE WHILE CREATING THE INSURANCE POLICY ********************");

		try {

			// wait for the element
			Thread.sleep(5000);

			// click on the side menu
			click("menubtn_CSS");
			ngDriver.waitForAngularRequestsToFinish();
			System.out.println("Clicked on the side menu.");

			// wait for the element
			Thread.sleep(5000);

			// click on the risk management
			click("sidemenu_riskmanagement_CSS");
			ngDriver.waitForAngularRequestsToFinish();
			System.out.println("Clicked on the risk management.");

			// select insurance policies dashboard
			select("ssc_task_dashboarddd_CSS", data.get("insurance_policies"));
			ngDriver.waitForAngularRequestsToFinish();
			System.out.println("Selected insurance policies dashboard.");

			// wait for the element
			Thread.sleep(3000);

			// click on the add button
			click("riskmanagement_insurance_addbtn_CSS");
			ngDriver.waitForAngularRequestsToFinish();
			System.out.println("Clicked on the add button.");

			// enter the policy number
			clear("riskmanagement_insurance_policynumbertxt_CSS");
			type("riskmanagement_insurance_policynumbertxt_CSS", policyNumberDate);
			ngDriver.waitForAngularRequestsToFinish();
			System.out.println("Entered the policy number.");

			// select the policy type from the drop down
			select("riskmanagement_insurance_policytypedd_XPATH", data.get("policy_type"));
			ngDriver.waitForAngularRequestsToFinish();
			System.out.println("Selected the policy type from the drop down.");

			// select the insurer from the drop down
			select("riskmanagement_insurance_insurerdd_XPATH", data.get("insurer"));
			ngDriver.waitForAngularRequestsToFinish();
			System.out.println("Selected the insurer from the drop down.");

			// enter the description
			clear("riskmanagement_insurance_descriptiontxt_XPATH");
			type("riskmanagement_insurance_descriptiontxt_XPATH", data.get("policy_description"));
			ngDriver.waitForAngularRequestsToFinish();
			System.out.println("Entered the description.");

			// scroll down the screen
			JavascriptExecutor js = (JavascriptExecutor) driver;
			WebElement policyRevisionInformationLabel = driver.findElement(
					By.xpath(OR.getProperty("riskmanagement_insurance_policyrevisioninformationlbl_XPATH")));
			js.executeScript("arguments[0].scrollIntoView(true);", policyRevisionInformationLabel);
			js.executeScript("window.scrollBy(0,-200)");

			// verify the Term Effective Date and Term Expiry Date

			LocalDate currentDate = LocalDate.now();
			String Current_Date = currentDate.toString();
			String Term_Effective_Date = driver
					.findElement(By.xpath(OR.getProperty("riskmanagement_insurance_termeffectivedatetxt_XPATH")))
					.getAttribute("value");

			if (Current_Date.equals(Term_Effective_Date)) {

				System.out.println("THE TERM EFFECTIVE DATE IS DISPLAYED CORRECT AS EXPECTED.");
				test.log(LogStatus.INFO, "THE TERM EFFECTIVE DATE IS DISPLAYED CORRECT AS EXPECTED.");
				Reporter.log("THE TERM EFFECTIVE DATE IS DISPLAYED CORRECT AS EXPECTED.");
				log.info("THE TERM EFFECTIVE DATE IS DISPLAYED CORRECT AS EXPECTED.");

			} else {

				verificationFailed();

				System.out.println("THE TERM EFFECTIVE DATE IS NOT DISPLAYED CORRECTLY.");
				test.log(LogStatus.INFO, "THE TERM EFFECTIVE DATE IS NOT DISPLAYED CORRECTLY.");
				Reporter.log("THE TERM EFFECTIVE DATE IS NOT DISPLAYED CORRECTLY.");
				log.info("THE TERM EFFECTIVE DATE IS NOT DISPLAYED CORRECTLY.");
			}

			String Term_Expiry_Date = driver
					.findElement(By.xpath(OR.getProperty("riskmanagement_insurance_termexpirydatetxt_XPATH")))
					.getAttribute("value");

			if (Current_Date.equals(Term_Expiry_Date)) {

				System.out.println("THE TERM EXPIRY DATE IS DISPLAYED CORRECT AS EXPECTED.");
				test.log(LogStatus.INFO, "THE TERM EXPIRY DATE IS DISPLAYED CORRECT AS EXPECTED.");
				Reporter.log("THE TERM EXPIRY DATE IS DISPLAYED CORRECT AS EXPECTED.");
				log.info("THE TERM EXPIRY DATE IS DISPLAYED CORRECT AS EXPECTED.");

			} else {

				verificationFailed();

				System.out.println("THE TERM EXPIRY DATE IS NOT DISPLAYED CORRECTLY.");
				test.log(LogStatus.INFO, "THE TERM EXPIRY DATE IS NOT DISPLAYED CORRECTLY.");
				Reporter.log("THE TERM EXPIRY DATE IS NOT DISPLAYED CORRECTLY.");
				log.info("THE TERM EXPIRY DATE IS NOT DISPLAYED CORRECTLY.");
			}

			// Update the term expiry date

			LocalDate futureDate = LocalDate.now().plusMonths(1);
			String Future_Date = futureDate.toString();

			clear("riskmanagement_insurance_termexpirydatetxt_XPATH");
			type("riskmanagement_insurance_termexpirydatetxt_XPATH", Future_Date);
			ngDriver.waitForAngularRequestsToFinish();
			System.out.println("Updated the term expiry date.");

			// click on the save button
			click("riskmanagement_insurance_savebtn_XPATH");
			ngDriver.waitForAngularRequestsToFinish();
			System.out.println("Clicked on the save button.");

		} catch (Throwable t) {
			verificationFailed();
		}

		// click on the home icon from the top of the screen
		click("questionnaire_homeburgermenubtn_hide_CSS");
		System.out.println("Clicked on the home icon from the top of the screen.");
		ngDriver.waitForAngularRequestsToFinish();

		// synchronization
		explicitWait("propertylist_title_XPATH");

		// verify the property list
		switchVerification("propertylist_title_XPATH", "Property List", "The property list is not displayed.");

		// VERIFY TH NEW REVISION DATE IN THE NEWLY CREATED INSURANCE POLICY

		System.out.println(
				"******************** VERIFY TH NEW REVISION DATE IN THE NEWLY CREATED INSURANCE POLICY ********************");
		test.log(LogStatus.INFO,
				"******************** VERIFY TH NEW REVISION DATE IN THE NEWLY CREATED INSURANCE POLICY ********************");
		Reporter.log(
				"******************** VERIFY TH NEW REVISION DATE IN THE NEWLY CREATED INSURANCE POLICY ********************");
		log.info(
				"******************** VERIFY TH NEW REVISION DATE IN THE NEWLY CREATED INSURANCE POLICY ********************");

		try {

			// wait for the element
			Thread.sleep(5000);

			// click on the side menu
			click("menubtn_CSS");
			ngDriver.waitForAngularRequestsToFinish();
			System.out.println("Clicked on the side menu.");

			// wait for the element
			Thread.sleep(5000);

			// click on the risk management
			click("sidemenu_riskmanagement_CSS");
			ngDriver.waitForAngularRequestsToFinish();
			System.out.println("Clicked on the risk management.");

			// select insurance policies dashboard
			select("ssc_task_dashboarddd_CSS", data.get("insurance_policies"));
			ngDriver.waitForAngularRequestsToFinish();
			System.out.println("Selected insurance policies dashboard.");

			// wait for the element
			Thread.sleep(3000);

			// enter the newly created policy in the search field
			clear("task_listofchecklist_filterfield_CSS");
			type("task_listofchecklist_filterfield_CSS", policyNumber);
			ngDriver.waitForAngularRequestsToFinish();
			System.out.println("Entered the newly created policy in the search field.");

			// click on the newly created insurance policy
			String insurancePolicyDate_XPATH = "//td[text()='" + policyNumberDate + "']";
			driver.findElement(By.xpath(insurancePolicyDate_XPATH)).click();
			ngDriver.waitForAngularRequestsToFinish();
			System.out.println("Clicked on the newly created insurance policy.");

			// click on the new revision button
			click("riskmanagement_insurance_newrevisionbtn_XPATH");
			ngDriver.waitForAngularRequestsToFinish();
			System.out.println("Clicked on the new revision button.");

			// verify the Revision Effective Date and Term Expiry Date

			LocalDate currentDate = LocalDate.now();
			String Current_Date = currentDate.toString();
			String New_Term_Effective_Date = driver
					.findElement(By.xpath(OR.getProperty("riskmanagement_insurance_newtermeffectivedatetxt_XPATH")))
					.getAttribute("value");

			if (Current_Date.equals(New_Term_Effective_Date)) {

				System.out.println("THE REVISION EFFECTIVE DATE IS DISPLAYED CORRECT AS EXPECTED.");
				test.log(LogStatus.INFO, "THE REVISION EFFECTIVE DATE IS DISPLAYED CORRECT AS EXPECTED.");
				Reporter.log("THE REVISION EFFECTIVE DATE IS DISPLAYED CORRECT AS EXPECTED.");
				log.info("THE REVISION EFFECTIVE DATE IS DISPLAYED CORRECT AS EXPECTED.");

			} else {

				verificationFailed();

				System.out.println("THE REVISION EFFECTIVE DATE IS NOT DISPLAYED CORRECTLY.");
				test.log(LogStatus.INFO, "THE REVISION EFFECTIVE DATE IS NOT DISPLAYED CORRECTLY.");
				Reporter.log("THE REVISION EFFECTIVE DATE IS NOT DISPLAYED CORRECTLY.");
				log.info("THE REVISION EFFECTIVE DATE IS NOT DISPLAYED CORRECTLY.");
			}

			LocalDate futureDate = LocalDate.now().plusMonths(1);
			String Future_Date = futureDate.toString();
			String New_Term_Expiry_Date = driver
					.findElement(By.xpath(OR.getProperty("riskmanagement_insurance_newtermexpirydatetxt_XPATH")))
					.getAttribute("value");

			if (Future_Date.equals(New_Term_Expiry_Date)) {

				System.out.println("THE REVISION EXPIRY DATE IS DISPLAYED CORRECT AS EXPECTED.");
				test.log(LogStatus.INFO, "THE REVISION EXPIRY DATE IS DISPLAYED CORRECT AS EXPECTED.");
				Reporter.log("THE REVISION EXPIRY DATE IS DISPLAYED CORRECT AS EXPECTED.");
				log.info("THE REVISION EXPIRY DATE IS DISPLAYED CORRECT AS EXPECTED.");

			} else {

				verificationFailed();

				System.out.println("THE REVISION EXPIRY DATE IS NOT DISPLAYED CORRECTLY.");
				test.log(LogStatus.INFO, "THE REVISION EXPIRY DATE IS NOT DISPLAYED CORRECTLY.");
				Reporter.log("THE REVISION EXPIRY DATE IS NOT DISPLAYED CORRECTLY.");
				log.info("THE REVISION EXPIRY DATE IS NOT DISPLAYED CORRECTLY.");
			}

			// Update the revision expiry date
			LocalDate newFutureDate = LocalDate.now().plusMonths(1).minusDays(7);
			String New_Future_Date = newFutureDate.toString();

			clear("riskmanagement_insurance_newtermexpirydatetxt_XPATH");
			type("riskmanagement_insurance_newtermexpirydatetxt_XPATH", New_Future_Date);
			ngDriver.waitForAngularRequestsToFinish();
			System.out.println("Updated the term expiry date.");

			// click on the add revision button
			click("riskmanagement_insurance_addrevisionbtn_XPATH");
			ngDriver.waitForAngularRequestsToFinish();
			System.out.println("Clicked on the add revision button.");

			// scroll down the screen
			JavascriptExecutor js = (JavascriptExecutor) driver;
			WebElement policyRevisionInformationLabel = driver.findElement(
					By.xpath(OR.getProperty("riskmanagement_insurance_policyrevisioninformationlbl_XPATH")));
			js.executeScript("arguments[0].scrollIntoView(true);", policyRevisionInformationLabel);
			js.executeScript("window.scrollBy(0,-200)");

			// verify the Revision Effective Date and Term Expiry Date

			String New1_Term_Effective_Date = driver
					.findElement(By.xpath(OR.getProperty("riskmanagement_insurance_termeffectivedatetxt_XPATH")))
					.getAttribute("value");

			if (Current_Date.equals(New1_Term_Effective_Date)) {

				System.out.println("THE REVISION EFFECTIVE DATE IS DISPLAYED CORRECT AS EXPECTED.");
				test.log(LogStatus.INFO, "THE REVISION EFFECTIVE DATE IS DISPLAYED CORRECT AS EXPECTED.");
				Reporter.log("THE REVISION EFFECTIVE DATE IS DISPLAYED CORRECT AS EXPECTED.");
				log.info("THE REVISION EFFECTIVE DATE IS DISPLAYED CORRECT AS EXPECTED.");

			} else {

				verificationFailed();

				System.out.println("THE REVISION EFFECTIVE DATE IS NOT DISPLAYED CORRECTLY.");
				test.log(LogStatus.INFO, "THE REVISION EFFECTIVE DATE IS NOT DISPLAYED CORRECTLY.");
				Reporter.log("THE REVISION EFFECTIVE DATE IS NOT DISPLAYED CORRECTLY.");
				log.info("THE REVISION EFFECTIVE DATE IS NOT DISPLAYED CORRECTLY.");
			}

			String New1_Term_Expiry_Date = driver
					.findElement(By.xpath(OR.getProperty("riskmanagement_insurance_termexpirydatetxt_XPATH")))
					.getAttribute("value");

			if (New_Future_Date.equals(New1_Term_Expiry_Date)) {

				System.out.println("THE REVISION EXPIRY DATE IS DISPLAYED CORRECT AS EXPECTED.");
				test.log(LogStatus.INFO, "THE REVISION EXPIRY DATE IS DISPLAYED CORRECT AS EXPECTED.");
				Reporter.log("THE REVISION EXPIRY DATE IS DISPLAYED CORRECT AS EXPECTED.");
				log.info("THE REVISION EXPIRY DATE IS DISPLAYED CORRECT AS EXPECTED.");

			} else {

				verificationFailed();

				System.out.println("THE REVISION EXPIRY DATE IS NOT DISPLAYED CORRECTLY.");
				test.log(LogStatus.INFO, "THE REVISION EXPIRY DATE IS NOT DISPLAYED CORRECTLY.");
				Reporter.log("THE REVISION EXPIRY DATE IS NOT DISPLAYED CORRECTLY.");
				log.info("THE REVISION EXPIRY DATE IS NOT DISPLAYED CORRECTLY.");
			}

			// click on the update button
			click("riskmanagement_insurance_updatebtn_XPATH");
			ngDriver.waitForAngularRequestsToFinish();
			System.out.println("Clicked on the update button.");

			// click on the cancel button
			click("riskmanagement_insurance_cancelbtn_XPATH");
			ngDriver.waitForAngularRequestsToFinish();
			System.out.println("Clicked on the cancel button.");

		} catch (Throwable t) {
			verificationFailed();
		}

		// click on the home icon from the top of the screen
		click("questionnaire_homeburgermenubtn_hide_CSS");
		System.out.println("Clicked on the home icon from the top of the screen.");
		ngDriver.waitForAngularRequestsToFinish();

		// synchronization
		explicitWait("propertylist_title_XPATH");

		// verify the property list
		switchVerification("propertylist_title_XPATH", "Property List", "The property list is not displayed.");

		// DELETE BOTH NEWLY CREATED INSURANCE POLICIES

		System.out.println("******************** DELETE BOTH NEWLY CREATED INSURANCE POLICIES ********************");
		test.log(LogStatus.INFO,
				"******************** DELETE BOTH NEWLY CREATED INSURANCE POLICIES ********************");
		Reporter.log("******************** DELETE BOTH NEWLY CREATED INSURANCE POLICIES ********************");
		log.info("******************** DELETE BOTH NEWLY CREATED INSURANCE POLICIES ********************");

		try {

			// wait for the element
			Thread.sleep(5000);

			// click on the side menu
			click("menubtn_CSS");
			ngDriver.waitForAngularRequestsToFinish();
			System.out.println("Clicked on the side menu.");

			// wait for the element
			Thread.sleep(5000);

			// click on the risk management
			click("sidemenu_riskmanagement_CSS");
			ngDriver.waitForAngularRequestsToFinish();
			System.out.println("Clicked on the risk management.");

			// select insurance policies dashboard
			select("ssc_task_dashboarddd_CSS", data.get("insurance_policies"));
			ngDriver.waitForAngularRequestsToFinish();
			System.out.println("Selected insurance policies dashboard.");

			// wait for the element
			Thread.sleep(3000);

			// enter the policy number in the search field
			clear("riskmanagement_insuranceclaim_searchtxt_CSS");
			type("riskmanagement_insuranceclaim_searchtxt_CSS", updatePolicyNumber);
			ngDriver.waitForAngularRequestsToFinish();
			System.out.println("Entered the policy number in the search field.");

			// click on the newly created insurance policy
			String updateinsurancePolicy_XPATH = "//td[text()='" + updatePolicyNumber + "']";
			driver.findElement(By.xpath(updateinsurancePolicy_XPATH)).click();
			ngDriver.waitForAngularRequestsToFinish();
			System.out.println("Clicked on the newly created insurance policy.");

			// wait for the element
			Thread.sleep(5000);

			// click on the delete button
			click("riskmanagement_insurance_deletebtn_XPATH");
			ngDriver.waitForAngularRequestsToFinish();
			System.out.println("Clicked on the delete button.");

			// wait for the element
			Thread.sleep(5000);

			// click on the delete button of the confirmation popup
			click("riskmanagement_insurance_confirmationdeletebtn_XPATH");
			ngDriver.waitForAngularRequestsToFinish();
			System.out.println("Clicked on the delete button of the confirmation popup.");

			// wait for the element
			Thread.sleep(5000);

			// enter the policy number in the search field
			clear("riskmanagement_insuranceclaim_searchtxt_CSS");
			type("riskmanagement_insuranceclaim_searchtxt_CSS", policyNumberDate);
			ngDriver.waitForAngularRequestsToFinish();
			System.out.println("Entered the policy number in the search field.");

			// click on the newly created insurance policy
			String insurancePolicyDate_XPATH = "//td[text()='" + policyNumberDate + "']";
			click(insurancePolicyDate_XPATH);
			ngDriver.waitForAngularRequestsToFinish();
			System.out.println("Clicked on the newly created insurance policy.");

			// wait for the element
			Thread.sleep(5000);

			// click on the delete button
			click("riskmanagement_insurance_deletebtn_XPATH");
			ngDriver.waitForAngularRequestsToFinish();
			System.out.println("Clicked on the delete button.");

			// wait for the element
			Thread.sleep(5000);

			// click on the delete button of the confirmation popup
			click("riskmanagement_insurance_confirmationdeletebtn_XPATH");
			ngDriver.waitForAngularRequestsToFinish();
			System.out.println("Clicked on the delete button of the confirmation popup.");

			// wait for the element
			Thread.sleep(5000);

		} catch (Throwable t) {
			verificationFailed();
		}

		// click on the home icon from the top of the screen
		click("questionnaire_homeburgermenubtn_hide_CSS");
		System.out.println("Clicked on the home icon from the top of the screen.");
		ngDriver.waitForAngularRequestsToFinish();

		// synchronization
		explicitWait("propertylist_title_XPATH");

		// verify the property list
		switchVerification("propertylist_title_XPATH", "Property List", "The property list is not displayed.");

		try {
			// wait for the element
			explicitWaitClickable("questionnaire_settingicon_CSS");

			// click on the settings icon from the top of the screen
			click("questionnaire_settingicon_CSS");
			System.out.println("Clicked on the settings icon.");
			ngDriver.waitForAngularRequestsToFinish();

			// wait for the element
			explicitWaitClickable("sidemenu_logout_CSS");

			// click on the logout option from the side menu
			click("sidemenu_logout_CSS");
			System.out.println("Clicked on the logout option from the side menu.");
			ngDriver.waitForAngularRequestsToFinish();

			// wait for the element
			explicitWaitClickable("signinbtn_BTNTEXT");

		} catch (Throwable t) {
			verificationFailed();
		}

	}
}
