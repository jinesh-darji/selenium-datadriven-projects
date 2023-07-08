package testcases.E2Etestcasesuite.riskmanagementmodule;

import java.io.IOException;
import java.time.LocalDate;
import java.util.Hashtable;
import java.util.Random;

import org.apache.commons.lang3.RandomStringUtils;
import org.openqa.selenium.By;
import org.testng.annotations.Test;

import base.Helper;
import base.TestBase;
import utilities.TestUtil;

public class RR6576RiskManagement1Test extends TestBase {

	@Test(dataProviderClass = TestUtil.class, dataProvider = "dp")
	public void rR6576RiskManagement1Test(Hashtable<String, String> data) throws IOException, InterruptedException {

		execution(data, "rR6576RiskManagement1Test");

		// refresh the page
		driver.navigate().refresh();
		Thread.sleep(5000);
		driver.navigate().refresh();

		// VERIFY THE CRUD OPERATION OF THE INSURANCE POLICY.
		title("VERIFY THE CRUD OPERATION OF THE INSURANCE POLICY.");

		// ADD THE NEW RECORD OF THE INSURANCE POLICY
		title("ADD THE NEW RECORD OF THE INSURANCE POLICY");

		String policyNumber = RandomStringUtils.randomNumeric(8);
		String policyGroup = RandomStringUtils.randomAlphabetic(8);
		String insurer = RandomStringUtils.randomAlphabetic(8);
		String owner = RandomStringUtils.randomAlphabetic(8);
		Random random = new Random();
		int premium_int = random.nextInt(900 - 500) + 500;
		String premium = Integer.toString(premium_int);
		String claimDeductible = RandomStringUtils.randomNumeric(2);
		String policyCoverageLimit = RandomStringUtils.randomNumeric(2);
		String perClaimCoverageLimit = RandomStringUtils.randomNumeric(2);
		LocalDate today = LocalDate.now();
		String today_string = today.toString();

		try {

			// click on the side menu
			click("menubtn_CSS");

			// wait for the element
			Thread.sleep(5000);

			// click on the risk management option
			click("sidemenu_riskmanagement_CSS");

			// select the insurance policies option from the dashboard dropdown
			select("dashboard_CSS", "Insurance Policies");

			// wait for the element
			Thread.sleep(3000);

			// click on the add button
			click("riskmanagement_insurancepolicies_addbtn_XPATH");

			// enter the details in the policy number field
			type("riskmanagement_insurancepolicies_policynumber1_XPATH", policyNumber);

			// select the policy type from the dropdown
			select("riskmanagement_insurancepolicies_policytype1_XPATH", data.get("policy_type"));

			// select the insurer from the dropdown
			select("riskmanagement_insurancepolicies_insurer1_XPATH", data.get("insurer"));

			// enter the details in the policy group field
			type("riskmanagement_insurancepolicies_policygroup1_XPATH", policyGroup);

			// enter the details in the description field
			type("riskmanagement_insurancepolicies_description1_XPATH", data.get("description"));

			// click on the save button
			click("riskmanagement_insurancepolicies_savebtn_XPATH");

			// wait for the element
			Thread.sleep(3000);

			// enter the newly created record in the search field
			type("riskmanagement_insurancepolicies_searchtxt_XPATH", policyNumber);

			// validate the newly created insurance policy record
			try {
				String policynumber = "//td[text()='" + policyNumber + "']";
				boolean policynumber_actual = driver.findElement(By.xpath(policynumber)).isDisplayed();

				if (policynumber_actual == true) {
					successMessage("The newly created insurance policy is displayed successfully.");
				} else {
					verificationFailedMessage("The newly created insurance policy is not displayed.");
				}
			} catch (Throwable t) {
				verificationFailedMessage("The newly created insurance policy is not displayed.");
			}

			// click on the searched record
			String policynumber1 = "//td[text()='" + policyNumber + "']";
			driver.findElement(By.xpath(policynumber1)).click();
			consoleMessage("Clicked on the searched record.");

			// scroll down the screen till bottom
			scrollBottom();

			// validate the Revision Info tabs
			try {

				boolean revisionInfoTab = driver
						.findElement(By
								.xpath(OR.getProperty("riskmanagement_insurancepolicies_revisioninfotab_active_XPATH")))
						.isDisplayed();

				if (revisionInfoTab == true) {
					successMessage("The revision info tab is displayed successfully.");
				} else {
					verificationFailedMessage("The revision info tab is not displayed.");
				}

			} catch (Throwable t) {
				verificationFailedMessage("The revision info tab is not displayed.");
			}

			// validate the Revision Details tabs
			try {

				boolean revisionDetailsTab = driver
						.findElement(
								By.xpath(OR.getProperty("riskmanagement_insurancepolicies_revisiondetailstab_XPATH")))
						.isDisplayed();

				if (revisionDetailsTab == true) {
					successMessage("The Revision Details tab is displayed successfully.");
				} else {
					verificationFailedMessage("The Revision Details tab is not displayed.");
				}

			} catch (Throwable t) {
				verificationFailedMessage("The Revision Details tab is not displayed.");
			}

			// validate the Property Covered tabs
			try {

				boolean propertyCoveredTab = driver
						.findElement(
								By.xpath(OR.getProperty("riskmanagement_insurancepolicies_propertycoveredtab_XPATH")))
						.isDisplayed();

				if (propertyCoveredTab == true) {
					successMessage("The Property Covered tab is displayed successfully.");
				} else {
					verificationFailedMessage("The Property Covered tab is not displayed.");
				}

			} catch (Throwable t) {
				verificationFailedMessage("The Property Covered tab is not displayed.");
			}

			// validate the Exclusion tabs
			try {

				boolean exclusionTab = driver
						.findElement(By.xpath(OR.getProperty("riskmanagement_insurancepolicies_exclusiontab_XPATH")))
						.isDisplayed();

				if (exclusionTab == true) {
					successMessage("The Exclusion tab is displayed successfully.");
				} else {
					verificationFailedMessage("The Exclusion tab is not displayed.");
				}

			} catch (Throwable t) {
				verificationFailedMessage("The Exclusion tab is not displayed.");
			}

			// validate the Endorsements tabs
			try {

				boolean endorsementsTab = driver
						.findElement(By.xpath(OR.getProperty("riskmanagement_insurancepolicies_endorsementstab_XPATH")))
						.isDisplayed();

				if (endorsementsTab == true) {
					successMessage("The Endorsements tab is displayed successfully.");
				} else {
					verificationFailedMessage("The Endorsements tab is not displayed.");
				}

			} catch (Throwable t) {
				verificationFailedMessage("The Endorsements tab is not displayed.");
			}

			// validate the Attachments tabs
			try {

				boolean attachmentsTab = driver
						.findElement(By.xpath(OR.getProperty("riskmanagement_insurancepolicies_attachmentstab_XPATH")))
						.isDisplayed();

				if (attachmentsTab == true) {
					successMessage("The Attachments tab is displayed successfully.");
				} else {
					verificationFailedMessage("The Attachments tab is not displayed.");
				}

			} catch (Throwable t) {
				verificationFailedMessage("The Attachments tab is not displayed.");
			}

			// validate the Comments tabs
			try {

				boolean commentsTab = driver
						.findElement(By.xpath(OR.getProperty("riskmanagement_insurancepolicies_commentstab_XPATH")))
						.isDisplayed();

				if (commentsTab == true) {
					successMessage("The Comments tab is displayed successfully.");
				} else {
					verificationFailedMessage("The Comments tab is not displayed.");
				}

			} catch (Throwable t) {
				verificationFailedMessage("The Comments tab is not displayed.");
			}

			// validate the Tasks tabs
			try {

				boolean tasksTab = driver
						.findElement(By.xpath(OR.getProperty("riskmanagement_insurancepolicies_taskstab_XPATH")))
						.isDisplayed();

				if (tasksTab == true) {
					successMessage("The Tasks tab is displayed successfully.");
				} else {
					verificationFailedMessage("The Tasks tab is not displayed.");
				}

			} catch (Throwable t) {
				verificationFailedMessage("The Tasks tab is not displayed.");
			}

			// ADD AND VALIDATE THE DETAILS OF THE REVISION INFO TAB
			title("ADD AND VALIDATE THE DETAILS OF THE REVISION INFO TAB");

			// validate the date of the term effective date field
			try {
				String date_actual = (driver
						.findElement(By.xpath(OR.getProperty(
								"riskmanagement_insurancepolicies_revisioninfotab_termeffectivedate_XPATH")))
						.getAttribute("value")).trim();

				if (date_actual.equals(today_string)) {
					successMessage("The default date of the term effective date field is displayed correctly.");
				} else {
					verificationFailedMessage("The default date of the term effective date field is not displayed.");
				}
			} catch (Throwable t) {
				verificationFailedMessage("The default date of the term effective date field is not displayed.");
			}

			// validate the date of the term expiry date field
			try {
				String date_actual = (driver
						.findElement(By.xpath(OR
								.getProperty("riskmanagement_insurancepolicies_revisioninfotab_termexpirydate_XPATH")))
						.getAttribute("value")).trim();

				if (date_actual.equals(today_string)) {
					successMessage("The default date of the term expiry date field is displayed correctly.");
				} else {
					verificationFailedMessage("The default date of the term expiry date field is not displayed.");
				}
			} catch (Throwable t) {
				verificationFailedMessage("The default date of the term expiry date field is not displayed.");
			}

			// validate the date of the revision effective date field
			try {
				String date_actual = (driver
						.findElement(By.xpath(OR.getProperty(
								"riskmanagement_insurancepolicies_revisioninfotab_revisioneffectivedate_XPATH")))
						.getAttribute("value")).trim();

				if (date_actual.equals(today_string)) {
					successMessage("The default date of the revision effective date field is displayed correctly.");
				} else {
					verificationFailedMessage(
							"The default date of the revision effective date field is not displayed.");
				}
			} catch (Throwable t) {
				verificationFailedMessage("The default date of the revision effective date field is not displayed.");
			}

			// validate the date of the revision expiry date field
			try {
				String date_actual = (driver
						.findElement(By.xpath(OR.getProperty(
								"riskmanagement_insurancepolicies_revisioninfotab_revisionexpirydate_XPATH")))
						.getAttribute("value")).trim();

				if (date_actual.equals(today_string)) {
					successMessage("The default date of the revision expiry date field is displayed correctly.");
				} else {
					verificationFailedMessage("The default date of the revision expiry date field is not displayed.");
				}
			} catch (Throwable t) {
				verificationFailedMessage("The default date of the revision expiry date field is not displayed.");
			}

			// click on the add icon of the named insured
			click("riskmanagement_insurancepolicies_revisioninfotab_addnamedinsuredicon_XPATH");

			// enter the insurer detail in the field
			type("riskmanagement_insurancepolicies_revisioninfotab_insuredtxt_XPATH", insurer);

			// click on the save icon
			click("riskmanagement_insurancepolicies_revisioninfotab_insured_saveicon_XPATH");

			// validate the newly added insurer name
			try {
				String insurer_XPATH = "//td[text()='" + insurer + "']";
				boolean insurer_actual = driver.findElement(By.xpath(insurer_XPATH)).isDisplayed();

				if (insurer_actual == true) {
					successMessage("The newly added insurer name is displayed successfully.");
				} else {
					verificationFailedMessage("The newly added insurer name is not displayed.");
				}
			} catch (Throwable t) {
				verificationFailedMessage("The newly added insurer name is not displayed.");
			}

			// click on the add icon of the property owners
			click("riskmanagement_insurancepolicies_revisioninfotab_addpropertyownericon_XPATH");

			// enter the insured detail in the field
			type("riskmanagement_insurancepolicies_revisioninfotab_ownertxt_XPATH", owner);

			// click on the save icon
			click("riskmanagement_insurancepolicies_revisioninfotab_owner_saveicon_XPATH");

			// validate the newly added owner name
			try {
				String owner_XPATH = "//td[text()='" + owner + "']";
				boolean owner_actual = driver.findElement(By.xpath(owner_XPATH)).isDisplayed();

				if (owner_actual == true) {
					successMessage("The newly added owner name is displayed successfully.");
				} else {
					verificationFailedMessage("The newly added owner name is not displayed.");
				}
			} catch (Throwable t) {
				verificationFailedMessage("The newly added owner name is not displayed.");
			}

			// ADD AND VALIDATE THE DETAILS OF THE REVISION DETAILS TAB
			title("ADD AND VALIDATE THE DETAILS OF THE REVISION DETAILS TAB");

			// click on the revision details tab
			click("riskmanagement_insurancepolicies_revisiondetailstab_XPATH");

			// enter the details in the Premium field
			type("riskmanagement_insurancepolicies_revisiondetailstab_premiumtxt_XPATH", premium);

			// enter the details in the Claims Deductible field
			type("riskmanagement_insurancepolicies_revisiondetailstab_claimsdeductibletxt_XPATH", claimDeductible);

			// enter the details in the Policy Aggregate Coverage Limit field
			type("riskmanagement_insurancepolicies_revisiondetailstab_claimslimittxt_XPATH", policyCoverageLimit);

			// enter the details in the Per Claim Coverage Limit field
			type("riskmanagement_insurancepolicies_revisiondetailstab_perclaimcoveragelimittxt_XPATH",
					perClaimCoverageLimit);

			// enter the details in the details field
			type("riskmanagement_insurancepolicies_revisiondetailstab_detailtxt_XPATH", data.get("details"));

			// enter the details in the details field
			type("riskmanagement_insurancepolicies_revisiondetailstab_knownconditionstxt_XPATH",
					data.get("known_condition"));

			// ADD AND VALIDATE THE DETAILS OF THE PROPERTY COVERED TAB
			title("ADD AND VALIDATE THE DETAILS OF THE PROPERTY COVERED TAB");

			// click on the property covered tab
			click("riskmanagement_insurancepolicies_propertycoveredtab_XPATH");
			
			
			
		} catch (Throwable t) {
			verificationFailed();
		}

		// click on the home icon
		click("questionnaire_homeburgermenubtn_hide_CSS");

		// wait for the element
		explicitWait("propertylist_title_XPATH");

		// verify the property list
		switchVerification("propertylist_title_XPATH", "Property List", "The property list is not displayed.");

	}
}
