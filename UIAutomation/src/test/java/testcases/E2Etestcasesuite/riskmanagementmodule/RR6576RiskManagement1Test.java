package testcases.E2Etestcasesuite.riskmanagementmodule;

import java.io.IOException;
import java.time.LocalDate;
import java.util.Hashtable;
import java.util.Random;

import org.apache.commons.lang3.RandomStringUtils;
import org.openqa.selenium.By;
import org.testng.annotations.Test;

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
		String insurer2 = RandomStringUtils.randomAlphabetic(8);
		String owner = RandomStringUtils.randomAlphabetic(8);
		String owner2 = RandomStringUtils.randomAlphabetic(8);
		Random random = new Random();
		int premium_int = random.nextInt(900 - 500) + 500;
		String premium = Integer.toString(premium_int);
		int claimDeductible_int = random.nextInt(99 - 10) + 10;
		String claimDeductible = Integer.toString(claimDeductible_int);
		int policyCoverageLimit_int = random.nextInt(99 - 10) + 10;
		String policyCoverageLimit = Integer.toString(policyCoverageLimit_int);
		int perClaimCoverageLimit_int = random.nextInt(99 - 10) + 10;
		String perClaimCoverageLimit = Integer.toString(perClaimCoverageLimit_int);
		String excludedMedia = RandomStringUtils.randomAlphabetic(8);
		String excludedCoverage = RandomStringUtils.randomAlphabetic(8);
		String endorsementNumber = RandomStringUtils.randomNumeric(3);
		String description = RandomStringUtils.randomAlphabetic(8);
		String comment = RandomStringUtils.randomAlphabetic(8);
		String tasktitle = RandomStringUtils.randomAlphabetic(8);
		LocalDate today = LocalDate.now();
		String today_string = today.toString();

		String updatepolicyNumber = RandomStringUtils.randomNumeric(8);
		String updatepolicyGroup = RandomStringUtils.randomAlphabetic(8);
		String updateinsurer = RandomStringUtils.randomAlphabetic(8);
		String updateowner = RandomStringUtils.randomAlphabetic(8);
		int updatepremium_int = random.nextInt(900 - 500) + 500;
		String updatepremium = Integer.toString(updatepremium_int);
		String updateclaimDeductible = RandomStringUtils.randomNumeric(2);
		String updatepolicyCoverageLimit = RandomStringUtils.randomNumeric(2);
		String updateperClaimCoverageLimit = RandomStringUtils.randomNumeric(2);
		String updateexcludedMedia = RandomStringUtils.randomAlphabetic(8);
		String updateexcludedCoverage = RandomStringUtils.randomAlphabetic(8);
		String updateendorsementNumber = RandomStringUtils.randomNumeric(3);
		String updatedescription = RandomStringUtils.randomAlphabetic(8);
		String updatetasktitle = RandomStringUtils.randomAlphabetic(8);
		LocalDate futureDate = LocalDate.now().plusDays(2);
		String futureDate_string = futureDate.toString();

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

			// scroll down till bottom
			scrollBottom();

			// click on the select all button
			click("riskmanagement_insurancepolicies_propertycoveredtab_selectallbtn_XPATH");

			// wait for the element
			Thread.sleep(2000);

			// validate the all properties are displayed as a selected or not
			try {
				boolean minusicon_property1 = driver
						.findElement(By.xpath(OR.getProperty(
								"riskmanagement_insurancepolicies_propertycoveredtab_property1_minusicon_XPATH")))
						.isDisplayed();
				boolean minusicon_property2 = driver
						.findElement(By.xpath(OR.getProperty(
								"riskmanagement_insurancepolicies_propertycoveredtab_property2_minusicon_XPATH")))
						.isDisplayed();
				boolean minusicon_property3 = driver
						.findElement(By.xpath(OR.getProperty(
								"riskmanagement_insurancepolicies_propertycoveredtab_property3_minusicon_XPATH")))
						.isDisplayed();
				boolean minusicon_property4 = driver
						.findElement(By.xpath(OR.getProperty(
								"riskmanagement_insurancepolicies_propertycoveredtab_property4_minusicon_XPATH")))
						.isDisplayed();

				if ((minusicon_property1 && minusicon_property2 && minusicon_property3
						&& minusicon_property4) == true) {
					successMessage("All the properties are displayed as a selected successfully.");
				} else {
					verificationFailedMessage("All the properties are not displayed as a selected.");
				}
			} catch (Throwable t) {
				verificationFailedMessage("All the properties are not displayed as a selected.");
			}

			// click on the remove all button
			click("riskmanagement_insurancepolicies_propertycoveredtab_removeallbtn_XPATH");

			// wait for the element
			Thread.sleep(2000);

			// validate the all properties are displayed as a non-selected or not
			try {
				boolean plusicon_property1 = driver
						.findElement(By.xpath(OR.getProperty(
								"riskmanagement_insurancepolicies_propertycoveredtab_property1_plusicon_XPATH")))
						.isDisplayed();
				boolean plusicon_property2 = driver
						.findElement(By.xpath(OR.getProperty(
								"riskmanagement_insurancepolicies_propertycoveredtab_property2_plusicon_XPATH")))
						.isDisplayed();
				boolean plusicon_property3 = driver
						.findElement(By.xpath(OR.getProperty(
								"riskmanagement_insurancepolicies_propertycoveredtab_property3_plusicon_XPATH")))
						.isDisplayed();
				boolean plusicon_property4 = driver
						.findElement(By.xpath(OR.getProperty(
								"riskmanagement_insurancepolicies_propertycoveredtab_property4_plusicon_XPATH")))
						.isDisplayed();

				if ((plusicon_property1 && plusicon_property2 && plusicon_property3 && plusicon_property4) == true) {
					successMessage("All the properties are displayed as a non-selected successfully.");
				} else {
					verificationFailedMessage("All the properties are displayed as a selected.");
				}
			} catch (Throwable t) {
				verificationFailedMessage("All the properties are displayed as a selected.");
			}

			// enter the property name in the search field
			type("riskmanagement_insurancepolicies_propertycoveredtab_searchtxt_XPATH", data.get("property_4"));

			// click on the plus icon of the searched property
			click("riskmanagement_insurancepolicies_propertycoveredtab_property4_plusicon_XPATH");

			// validate the property 4 is displayed as a selected
			try {
				boolean minusicon_property4 = driver
						.findElement(By.xpath(OR.getProperty(
								"riskmanagement_insurancepolicies_propertycoveredtab_property4_minusicon_XPATH")))
						.isDisplayed();

				if (minusicon_property4 == true) {
					successMessage("The property 4 is displayed as a selected successfully.");
				} else {
					verificationFailedMessage("The property 4 is not displayed as a selected.");
				}
			} catch (Throwable t) {
				verificationFailedMessage("The property 4 is not displayed as a selected.");
			}

			// enter the property name in the search field
			type("riskmanagement_insurancepolicies_propertycoveredtab_searchtxt_XPATH", data.get("property_3"));

			// click on the plus icon of the searched property
			click("riskmanagement_insurancepolicies_propertycoveredtab_property3_plusicon_XPATH");

			// validate the property 3 is displayed as a selected
			try {
				boolean minusicon_property3 = driver
						.findElement(By.xpath(OR.getProperty(
								"riskmanagement_insurancepolicies_propertycoveredtab_property3_minusicon_XPATH")))
						.isDisplayed();

				if (minusicon_property3 == true) {
					successMessage("The property 3 is displayed as a selected successfully.");
				} else {
					verificationFailedMessage("The property 3 is not displayed as a selected.");
				}
			} catch (Throwable t) {
				verificationFailedMessage("The property 3 is not displayed as a selected.");
			}

			// ADD AND VALIDATE THE DETAILS OF THE EXCLUSION TAB
			title("ADD AND VALIDATE THE DETAILS OF THE EXCLUSION TAB");

			// click on the exclusion tab
			click("riskmanagement_insurancepolicies_exclusiontab_XPATH");

			// click on the add exclusion details icon
			click("riskmanagement_insurancepolicies_exclusiontab_addexclusiondetailsicon_XPATH");

			// click on the plus icon of the property 4
			click("riskmanagement_insurancepolicies_exclusiontab_property4_addicon_XPATH");

			// scroll down the screen by 200 px
			scrollByPixel(200);

			// validate the today's date in the effective date
			try {
				String date_actual = (driver
						.findElement(By.xpath(
								OR.getProperty("riskmanagement_insurancepolicies_exclusiontab_effectivedatetxt_XPATH")))
						.getAttribute("value")).trim();

				if (date_actual.equals(today_string)) {
					successMessage("The default date of the effective date field is displayed correctly.");
				} else {
					verificationFailedMessage("The default date of the effective date field is not displayed.");
				}
			} catch (Throwable t) {
				verificationFailedMessage("The default date of the effective date field is not displayed.");
			}

			// validate the today's date in the expiry date
			try {
				String date_actual = (driver
						.findElement(By.xpath(
								OR.getProperty("riskmanagement_insurancepolicies_exclusiontab_expirydatetxt_XPATH")))
						.getAttribute("value")).trim();

				if (date_actual.equals(today_string)) {
					successMessage("The default date of the expiry date field is displayed correctly.");
				} else {
					verificationFailedMessage("The default date of the expiry date field is not displayed.");
				}
			} catch (Throwable t) {
				verificationFailedMessage("The default date of the expiry date field is not displayed.");
			}

			// enter the details of the pollution condition
			type("riskmanagement_insurancepolicies_exclusiontab_pollutionconditiontxt_XPATH",
					data.get("pollution_condition"));

			// enter the details in the excluded media field
			type("riskmanagement_insurancepolicies_exclusiontab_excludedmediatxt_XPATH", excludedMedia);

			// enter the details in the excluded coverage field
			type("riskmanagement_insurancepolicies_exclusiontab_excludedcoveragetxt_XPATH", excludedCoverage);

			// enter the details in the additional note field
			type("riskmanagement_insurancepolicies_exclusiontab_additionalnotestxt_XPATH", data.get("additional_note"));

			// click on the ok button
			click("riskmanagement_insurancepolicies_exclusiontab_okbtn_XPATH");

			// validate the newly added exclusion record
			try {
				String record = "//td[contains(text(),'" + excludedMedia + "')]";
				boolean record_actual = driver.findElement(By.xpath(record)).isDisplayed();

				if (record_actual == true) {
					successMessage("The newly added exclusion record is displayed successfully.");
				} else {
					verificationFailedMessage("The newly added exclusion record is not displayed.");
				}
			} catch (Throwable t) {
				verificationFailedMessage("The newly added exclusion record is not displayed.");
			}

//			// ADD AND VALIDATE THE DETAILS OF THE ENDORSEMENTS TAB
//			title("ADD AND VALIDATE THE DETAILS OF THE ENDORSEMENTS TAB");
//
//			// click on the endorsement tab
//			click("riskmanagement_insurancepolicies_endorsementstab_XPATH");
//
//			// click on the add endorsement details icon
//			click("riskmanagement_insurancepolicies_endorsementstab_addendorsementdetailsicon_XPATH");
//
//			// enter the today's date in the effective date field
//			type("riskmanagement_insurancepolicies_endorsementstab_effectivedatetxt_XPATH", today_string);
//
//			// enter the today's date in the expiry date field
//			type("riskmanagement_insurancepolicies_endorsementstab_expirydatetxt_XPATH", today_string);
//
//			// enter the details in the endorsement number field
//			type("riskmanagement_insurancepolicies_endorsementstab_endorsementnumbertxt_XPATH", endorsementNumber);
//
//			// enter the details in the premium field
//			type("riskmanagement_insurancepolicies_endorsementstab_premiumtxt_XPATH", premium);
//
//			// enter the details in the description field
//			type("riskmanagement_insurancepolicies_endorsementstab_descriptiontxt_XPATH", description);
//
//			// enter the details in the comment field
//			type("riskmanagement_insurancepolicies_endorsementstab_commenttxt_XPATH", data.get("comment"));
//
//			// click on the ok button
//			click("riskmanagement_insurancepolicies_endorsementstab_okbtn_XPATH");
//
//			// validate the newly added endorsement record
//			try {
//				String record = "//td[text()='" + description + "')]";
//				boolean record_actual = driver.findElement(By.xpath(record)).isDisplayed();
//
//				if (record_actual == true) {
//					successMessage("The newly added endorsement record is displayed successfully.");
//				} else {
//					verificationFailedMessage("The newly added endorsement record is not displayed.");
//				}
//			} catch (Throwable t) {
//				verificationFailedMessage("The newly added endorsement record is not displayed.");
//			}
//
			// VALIDATE THE DETAILS OF THE ATTACHMENTS TAB
			title("VALIDATE THE DETAILS OF THE ATTACHMENTS TAB");

			// click on the attachments tab
			click("riskmanagement_insurancepolicies_attachmentstab_XPATH");

			// validate the upload file button
			try {
				boolean uploadbtn = driver
						.findElement(By.xpath(OR
								.getProperty("riskmanagement_insurancepolicies_endorsementstab_uploadlocalfile_XPATH")))
						.isDisplayed();

				if (uploadbtn == true) {
					successMessage("The Upload Local File button is displayed successfully.");
				} else {
					verificationFailedMessage("The Upload Local File button is not displayed.");
				}
			} catch (Throwable t) {
				verificationFailedMessage("The Upload Local File button is not displayed.");
			}

			// ADD AND VALIDATE THE DETAILS OF THE COMMENTS TAB
			title("ADD AND VALIDATE THE DETAILS OF THE COMMENTS TAB");

			// click on the comments tab
			click("riskmanagement_insurancepolicies_commentstab_XPATH");

			// click on the add comment button
			click("riskmanagement_insurancepolicies_endorsementstab_addcommentbtn_XPATH");

			// enter the comment in the field
			type("propertyproject_mu_commenttxt_XPATH", comment);

			// click on the add button
			click("task_comment_addcommentbtn_CSS");

			// verify added comment is displayed or not
			try {
				String addedComment = "//p[text()='" + comment + "']";
				String str2 = (driver.findElement(By.xpath(addedComment)).getText()).trim();

				if (str2.equals(comment)) {

					successMessage("The newly created comment i.e. " + comment + "is verified successfully.");

				} else {
					verificationFailedMessage("The newly created comment i.e. " + comment + "is not verified.");
				}

			} catch (Throwable t) {
				verificationFailedMessage("The newly created comment i.e. " + comment + "is not verified.");
			}

			// ADD AND VALIDATE THE DETAILS OF THE TASKS TAB
			title("ADD AND VALIDATE THE DETAILS OF THE TASKS TAB");

			// click on the tasks tab
			click("riskmanagement_insurancepolicies_taskstab_XPATH");

			// click on the add button
			click("riskmanagement_insurancepolicies_endorsementstab_addtaskbtn_XPATH");

			// enter the data in the task title field
			type("task_addtask_titletxt_CSS", tasktitle);

			// scroll down to 500 px
			scrollByPixel(500);

			// click on the assign to field
			click("questionnaire_inspection_addtask_assigntotxt_XPATH");

			// click on the none button
			click("task_tasktag_nonebtn_CSS");

			// enter the user name in the search field
			type("workflowsecurity_editortask_taskdetails_searchtasktagtxt_CSS", "Jinesh");

			// click on the searched result
			click("questionnaire_createtask_selectusertxt_XPATH");

			// click on the assign to field
			click("questionnaire_inspection_addtask_assigntotxt_XPATH");

			// scroll down to 300 px
			scrollByPixel(300);

			// click on the save button
			click("riskmanagement_insurancepolicies_taskstab_savebtn_XPATH");

			// validate the newly created task
			try {
				String task_XPATH = "//td[text()='" + tasktitle + "']";
				boolean task_actual = driver.findElement(By.xpath(task_XPATH)).isDisplayed();

				if (task_actual == true) {
					successMessage("The newly created task is displayed successfully.");
				} else {
					verificationFailedMessage("The newly created task is not displayed.");
				}
			} catch (Throwable t) {
				verificationFailedMessage("The newly created task is not displayed.");
			}

			// click on the update button of the insurance policy
			click("riskmanagement_insurancepolicies_updatebtn_XPATH");

			// click on the cancel button of the insurance policy
			click("riskmanagement_insurancepolicies_cancelbtn_XPATH");

			// wait for the element
			Thread.sleep(3000);

			// enter the newly created insurance policy in the search field
			type("sustainability_searchtxt_XPATH", policyNumber);

			// validate the newly created insurance policy
			try {
				String insurancepolicy_XPATH = "//td[text()='" + policyNumber + "']";
				boolean insurancepolicy_actual = driver.findElement(By.xpath(insurancepolicy_XPATH)).isDisplayed();

				if (insurancepolicy_actual == true) {
					successMessage("The newly created insurance policy is displayed successfully.");
				} else {
					verificationFailedMessage("The newly created insurance policy is not displayed.");
				}
			} catch (Throwable t) {
				verificationFailedMessage("The newly created insurance policy is not displayed.");
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

		// ***************************************

		// VALIDATE THE NEWLY CREATED TASK IN TASK LIST

		// ***************************************

		// UPDATE THE NEWLY CREATED INSURANCE POLICY
		title("UPDATE THE NEWLY CREATED INSURANCE POLICY");

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

			// enter the newly created insurance policy in the search field
			type("sustainability_searchtxt_XPATH", policyNumber);

			// click on the newly created insurance policy
			String insurancepolicy_XPATH = "//td[text()='" + policyNumber + "']";
			driver.findElement(By.xpath(insurancepolicy_XPATH)).click();
			consoleMessage("Clicked on the newly created insurance policy.");

			// enter the details in the policy number field
			type("riskmanagement_insurancepolicies_policynumber1_XPATH", updatepolicyNumber);

			// select the policy type from the dropdown
			select("riskmanagement_insurancepolicies_policytype1_XPATH", data.get("update_policy_type"));

			// select the insurer from the dropdown
			select("riskmanagement_insurancepolicies_insurer1_XPATH", data.get("insurer"));

			// enter the details in the policy group field
			type("riskmanagement_insurancepolicies_policygroup1_XPATH", updatepolicyGroup);

			// enter the details in the description field
			type("riskmanagement_insurancepolicies_description1_XPATH", data.get("update_description"));

			// scroll down the screen till bottom
			scrollBottom();

			// UPDATE AND VALIDATE THE DETAILS OF THE REVISION INFO TAB
			title("UPDATE AND VALIDATE THE DETAILS OF THE REVISION INFO TAB");

			// delete the previously added insured
			click("riskmanagement_insurancepolicies_revisioninfotab_insured_deleteicon_XPATH");

			// validate the newly removed insurer name
			try {
				String insurer_XPATH = "//td[text()='" + insurer + "']";
				boolean insurer_actual = driver.findElement(By.xpath(insurer_XPATH)).isDisplayed();

				if (insurer_actual == true) {
					verificationFailedMessage("The removed insurer name is displayed.");
				} else {
					successMessage("The removed insurer name is not displayed as expected.");
				}
			} catch (Throwable t) {
				successMessage("The removed insurer name is not displayed as expected.");
			}

			// click on the add icon of the named insured
			click("riskmanagement_insurancepolicies_revisioninfotab_addnamedinsuredicon_XPATH");

			// enter the insurer detail in the field
			type("riskmanagement_insurancepolicies_revisioninfotab_insuredtxt_XPATH", insurer2);

			// click on the save icon
			click("riskmanagement_insurancepolicies_revisioninfotab_insured_saveicon_XPATH");

			// validate the second time added insurer name
			try {
				String insurer2_XPATH = "//td[text()='" + insurer2 + "']";
				boolean insurer2_actual = driver.findElement(By.xpath(insurer2_XPATH)).isDisplayed();

				if (insurer2_actual == true) {
					successMessage("The second time added insurer name is displayed successfully.");
				} else {
					verificationFailedMessage("The second time added insurer name is not displayed.");
				}
			} catch (Throwable t) {
				verificationFailedMessage("The second time added insurer name is not displayed.");
			}

			// click on the update icon of the named insured
			click("riskmanagement_insurancepolicies_revisioninfotab_insured_editicon_XPATH");

			// enter the insurer detail in the field
			type("riskmanagement_insurancepolicies_revisioninfotab_insuredtxt_XPATH", updateinsurer);

			// click on the save icon
			click("riskmanagement_insurancepolicies_revisioninfotab_insured_saveicon_XPATH");

			// validate the updated insurer name
			try {
				String updateinsurer_XPATH = "//td[text()='" + updateinsurer + "']";
				boolean updateinsurer_actual = driver.findElement(By.xpath(updateinsurer_XPATH)).isDisplayed();

				if (updateinsurer_actual == true) {
					successMessage("The updated insurer name is displayed successfully.");
				} else {
					verificationFailedMessage("The updated insurer name is not displayed.");
				}
			} catch (Throwable t) {
				verificationFailedMessage("The updated insurer name is not displayed.");
			}

			// delete the previously added property owners
			click("riskmanagement_insurancepolicies_revisioninfotab_deletepropertyownericon_XPATH");

			// validate the newly removed owner name
			try {
				String owner_XPATH = "//td[text()='" + owner + "']";
				boolean owner_actual = driver.findElement(By.xpath(owner_XPATH)).isDisplayed();

				if (owner_actual == true) {
					verificationFailedMessage("The removed owner name is displayed.");
				} else {
					successMessage("The removed owner name is not displayed as expected.");
				}
			} catch (Throwable t) {
				successMessage("The removed owner name is not displayed as expected.");
			}

			// click on the add icon of the property owners
			click("riskmanagement_insurancepolicies_revisioninfotab_addpropertyownericon_XPATH");

			// enter the insured detail in the field
			type("riskmanagement_insurancepolicies_revisioninfotab_ownertxt_XPATH", owner2);

			// click on the save icon
			click("riskmanagement_insurancepolicies_revisioninfotab_owner_saveicon_XPATH");

			// validate the newly added owner name
			try {
				String owner2_XPATH = "//td[text()='" + owner2 + "']";
				boolean owner2_actual = driver.findElement(By.xpath(owner2_XPATH)).isDisplayed();

				if (owner2_actual == true) {
					successMessage("The newly added owner name is displayed successfully.");
				} else {
					verificationFailedMessage("The newly added owner name is not displayed.");
				}
			} catch (Throwable t) {
				verificationFailedMessage("The newly added owner name is not displayed.");
			}

			// click on the update icon of the named owner
			click("riskmanagement_insurancepolicies_revisioninfotab_editpropertyownericon_XPATH");

			// enter the owner detail in the field
			type("riskmanagement_insurancepolicies_revisioninfotab_ownertxt_XPATH", updateowner);

			// click on the save icon
			click("riskmanagement_insurancepolicies_revisioninfotab_owner_saveicon_XPATH");

			// validate the updated owner name
			try {
				String updateowner_XPATH = "//td[text()='" + updateowner + "']";
				boolean updateowner_actual = driver.findElement(By.xpath(updateowner_XPATH)).isDisplayed();

				if (updateowner_actual == true) {
					successMessage("The newly added owner name is displayed successfully.");
				} else {
					verificationFailedMessage("The newly added owner name is not displayed.");
				}
			} catch (Throwable t) {
				verificationFailedMessage("The newly added owner name is not displayed.");
			}

			// UPDATE AND VALIDATE THE DETAILS OF THE REVISION DETAILS TAB
			title("UPDATE AND VALIDATE THE DETAILS OF THE REVISION DETAILS TAB");

			// click on the revision details tab
			click("riskmanagement_insurancepolicies_revisiondetailstab_XPATH");

			// validate the previously saved Premium detail
			try {
				String premium_actual = (driver
						.findElement(By.xpath(
								OR.getProperty("riskmanagement_insurancepolicies_revisiondetailstab_premiumtxt_XPATH")))
						.getAttribute("value")).trim();

				if (premium_actual.equals(premium)) {
					successMessage("The previously saved Premium detail is displayed successfully.");
				} else {
					verificationFailedMessage("The previously saved Premium detail is not displayed.");
				}
			} catch (Throwable t) {
				verificationFailedMessage("The previously saved Premium detail is not displayed.");
			}

			// validate the previously saved Claims Deductible detail
			try {
				String claimDeductible_actual = (driver
						.findElement(By.xpath(OR.getProperty(
								"riskmanagement_insurancepolicies_revisiondetailstab_claimsdeductibletxt_XPATH")))
						.getAttribute("value")).trim();

				if (claimDeductible_actual.equals(claimDeductible)) {
					successMessage("The previously saved Claims Deductible detail is displayed successfully.");
				} else {
					verificationFailedMessage("The previously saved Claims Deductible detail is not displayed.");
				}
			} catch (Throwable t) {
				verificationFailedMessage("The previously saved Claims Deductible detail is not displayed.");
			}

			// validate the previously saved Policy Aggregate Coverage Limit detail
			try {
				String policyCoverageLimit_actual = (driver
						.findElement(By.xpath(OR.getProperty(
								"riskmanagement_insurancepolicies_revisiondetailstab_claimslimittxt_XPATH")))
						.getAttribute("value")).trim();

				if (policyCoverageLimit_actual.equals(policyCoverageLimit)) {
					successMessage(
							"The previously saved Policy Aggregate Coverage Limit detail is displayed successfully.");
				} else {
					verificationFailedMessage(
							"The previously saved Policy Aggregate Coverage Limit detail is not displayed.");
				}
			} catch (Throwable t) {
				verificationFailedMessage(
						"The previously saved Policy Aggregate Coverage Limit detail is not displayed.");
			}

			// validate the previously saved Per Claim Coverage Limit detail
			try {
				String perClaimCoverageLimit_actual = (driver
						.findElement(By.xpath(OR.getProperty(
								"riskmanagement_insurancepolicies_revisiondetailstab_perclaimcoveragelimittxt_XPATH")))
						.getAttribute("value")).trim();

				if (perClaimCoverageLimit_actual.equals(perClaimCoverageLimit)) {
					successMessage("The previously saved Per Claim Coverage Limit detail is displayed successfully.");
				} else {
					verificationFailedMessage("The previously saved Per Claim Coverage Limit detail is not displayed.");
				}
			} catch (Throwable t) {
				verificationFailedMessage("The previously saved Per Claim Coverage Limit detail is not displayed.");
			}

			// update the details in the Premium field
			type("riskmanagement_insurancepolicies_revisiondetailstab_premiumtxt_XPATH", updatepremium);

			// update the details in the Claims Deductible field
			type("riskmanagement_insurancepolicies_revisiondetailstab_claimsdeductibletxt_XPATH",
					updateclaimDeductible);

			// update the details in the Policy Aggregate Coverage Limit field
			type("riskmanagement_insurancepolicies_revisiondetailstab_claimslimittxt_XPATH", updatepolicyCoverageLimit);

			// update the details in the Per Claim Coverage Limit field
			type("riskmanagement_insurancepolicies_revisiondetailstab_perclaimcoveragelimittxt_XPATH",
					updateperClaimCoverageLimit);

			// update the details in the details field
			type("riskmanagement_insurancepolicies_revisiondetailstab_detailtxt_XPATH", data.get("update_details"));

			// update the details in the details field
			type("riskmanagement_insurancepolicies_revisiondetailstab_knownconditionstxt_XPATH",
					data.get("update_known_condition"));

			// UPDATE AND VALIDATE THE DETAILS OF THE PROPERTY COVERED TAB
			title("UPDATE AND VALIDATE THE DETAILS OF THE PROPERTY COVERED TAB");

			// click on the property covered tab
			click("riskmanagement_insurancepolicies_propertycoveredtab_XPATH");

			// scroll down till bottom
			scrollBottom();

			// enter the property name in the search field
			type("riskmanagement_insurancepolicies_propertycoveredtab_searchtxt_XPATH", data.get("property_2"));

			// click on the plus icon of the searched property
			click("riskmanagement_insurancepolicies_propertycoveredtab_property2_plusicon_XPATH");

			// validate the property 2 is displayed as a selected
			try {
				boolean minusicon_property2 = driver
						.findElement(By.xpath(OR.getProperty(
								"riskmanagement_insurancepolicies_propertycoveredtab_property2_minusicon_XPATH")))
						.isDisplayed();

				if (minusicon_property2 == true) {
					successMessage("The property 2 is displayed as a selected successfully.");
				} else {
					verificationFailedMessage("The property 2 is not displayed as a selected.");
				}
			} catch (Throwable t) {
				verificationFailedMessage("The property 2 is not displayed as a selected.");
			}

			// UPDATE AND VALIDATE THE DETAILS OF THE EXCLUSION TAB
			title("UPDATE AND VALIDATE THE DETAILS OF THE EXCLUSION TAB");

			// click on the exclusion tab
			click("riskmanagement_insurancepolicies_exclusiontab_XPATH");

			// click on the added exclusion record
			String record = "//td[contains(text(),'" + excludedMedia + "')]";
			driver.findElement(By.xpath(record)).click();
			consoleMessage("Clicked on the added exclusion record.");

			// click on the plus icon of the property 2
			click("riskmanagement_insurancepolicies_exclusiontab_property2_addicon_XPATH");

			// scroll down the screen by 200 px
			scrollByPixel(200);

			// update the details of the pollution condition
			type("riskmanagement_insurancepolicies_exclusiontab_pollutionconditiontxt_XPATH",
					data.get("update_pollution_condition"));

			// update the details in the excluded media field
			type("riskmanagement_insurancepolicies_exclusiontab_excludedmediatxt_XPATH", updateexcludedMedia);

			// update the details in the excluded coverage field
			type("riskmanagement_insurancepolicies_exclusiontab_excludedcoveragetxt_XPATH", updateexcludedCoverage);

			// update the details in the additional note field
			type("riskmanagement_insurancepolicies_exclusiontab_additionalnotestxt_XPATH",
					data.get("update_additional_note"));

			// click on the ok button
			click("riskmanagement_insurancepolicies_exclusiontab_okbtn_XPATH");

			// validate the update exclusion record
			try {
				String updaterecord = "//td[contains(text(),'" + updateexcludedMedia + "')]";
				boolean updaterecord_actual = driver.findElement(By.xpath(updaterecord)).isDisplayed();

				if (updaterecord_actual == true) {
					successMessage("The updated exclusion record is displayed successfully.");
				} else {
					verificationFailedMessage("The updated exclusion record is not displayed.");
				}
			} catch (Throwable t) {
				verificationFailedMessage("The updated exclusion record is not displayed.");
			}

//			// UPDATE AND VALIDATE THE DETAILS OF THE ENDORSEMENTS TAB
//			title("UPDATE AND VALIDATE THE DETAILS OF THE ENDORSEMENTS TAB");
//
//			// click on the endorsement tab
//			click("riskmanagement_insurancepolicies_endorsementstab_XPATH");
//
//			// click on the previously added endorsement record
//			String record1 = "//td[text()='" + description + "')]";
//			driver.findElement(By.xpath(record1)).click();
//			consoleMessage("Clicked on the previously added endorsement record.");
//
//			// update the details in the endorsement number field
//			type("riskmanagement_insurancepolicies_endorsementstab_endorsementnumbertxt_XPATH",
//					updateendorsementNumber);
//
//			// update the details in the premium field
//			type("riskmanagement_insurancepolicies_endorsementstab_premiumtxt_XPATH", updatepremium);
//
//			// update the details in the description field
//			type("riskmanagement_insurancepolicies_endorsementstab_descriptiontxt_XPATH", updatedescription);
//
//			// update the details in the comment field
//			type("riskmanagement_insurancepolicies_endorsementstab_commenttxt_XPATH", data.get("update_comment"));
//
//			// click on the ok button
//			click("riskmanagement_insurancepolicies_endorsementstab_okbtn_XPATH");
//
//			// validate the updated endorsement record
//			try {
//				String updaterecord1 = "//td[text()='" + updatedescription + "')]";
//				boolean updaterecord1_actual = driver.findElement(By.xpath(updaterecord1)).isDisplayed();
//
//				if (updaterecord1_actual == true) {
//					successMessage("The updated endorsement record is displayed successfully.");
//				} else {
//					verificationFailedMessage("The updated endorsement record is not displayed.");
//				}
//			} catch (Throwable t) {
//				verificationFailedMessage("The updated endorsement record is not displayed.");
//			}

			// VALIDATE THE DETAILS OF THE ATTACHMENTS TAB
			title("VALIDATE THE DETAILS OF THE ATTACHMENTS TAB");

			// click on the attachments tab
			click("riskmanagement_insurancepolicies_attachmentstab_XPATH");

			// validate the upload file button
			try {
				boolean uploadbtn = driver
						.findElement(By.xpath(OR
								.getProperty("riskmanagement_insurancepolicies_endorsementstab_uploadlocalfile_XPATH")))
						.isDisplayed();

				if (uploadbtn == true) {
					successMessage("The Upload Local File button is displayed successfully.");
				} else {
					verificationFailedMessage("The Upload Local File button is not displayed.");
				}
			} catch (Throwable t) {
				verificationFailedMessage("The Upload Local File button is not displayed.");
			}

			// UPDATE AND VALIDATE THE DETAILS OF THE TASKS TAB
			title("UPDATE AND VALIDATE THE DETAILS OF THE TASKS TAB");

			// click on the tasks tab
			click("riskmanagement_insurancepolicies_taskstab_XPATH");

			// click on the previously created task
			String task_XPATH = "//td[text()='" + tasktitle + "']";
			driver.findElement(By.xpath(task_XPATH)).click();
			consoleMessage("Clicked on the previously created task.");

			// enter the data in the task title field
			type("task_addtask_titletxt_CSS", updatetasktitle);

			// scroll down to 500 px
			scrollBottom();

			// click on the update button
			click("riskmanagement_insurancepolicies_taskstab_updatebtn_XPATH");

			// validate the updated task
			try {
				String updatetask_XPATH = "//td[text()='" + updatetasktitle + "']";
				boolean updatetask_actual = driver.findElement(By.xpath(updatetask_XPATH)).isDisplayed();

				if (updatetask_actual == true) {
					successMessage("The updated task is displayed successfully.");
				} else {
					verificationFailedMessage("The updated task is not displayed.");
				}
			} catch (Throwable t) {
				verificationFailedMessage("The updated task is not displayed.");
			}

			// click on the update button of the insurance policy
			click("riskmanagement_insurancepolicies_updatebtn_XPATH");

			// click on the cancel button of the insurance policy
			click("riskmanagement_insurancepolicies_cancelbtn_XPATH");

			// wait for the element
			Thread.sleep(3000);

			// enter the updated insurance policy in the search field
			type("sustainability_searchtxt_XPATH", updatepolicyNumber);

			// validate the updated insurance policy
			try {
				String updateinsurancepolicy_XPATH = "//td[text()='" + updatepolicyNumber + "']";
				boolean updateinsurancepolicy_actual = driver.findElement(By.xpath(updateinsurancepolicy_XPATH))
						.isDisplayed();

				if (updateinsurancepolicy_actual == true) {
					successMessage("The updated insurance policy is displayed successfully.");
				} else {
					verificationFailedMessage("The updated insurance policy is not displayed.");
				}
			} catch (Throwable t) {
				verificationFailedMessage("The updated insurance policy is not displayed.");
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

		// DELETE THE CREATED RECORDS OF THE INSURANCE POLICY
		title("DELETE THE CREATED RECORDS OF THE INSURANCE POLICY");

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

			// enter the newly created insurance policy in the search field
			type("sustainability_searchtxt_XPATH", updatepolicyNumber);

			// click on the update insurance policy
			String updateinsurancepolicy_XPATH = "//td[text()='" + updatepolicyNumber + "']";
			driver.findElement(By.xpath(updateinsurancepolicy_XPATH)).click();
			consoleMessage("Clicked on the update insurance policy.");

			// scroll down the bottom
			scrollBottom();

			// DELETE THE RECORD OF THE EXCLUSION TAB
			title("DELETE THE RECORD OF THE EXCLUSION TAB");

			// click on the exclusion tab
			click("riskmanagement_insurancepolicies_exclusiontab_XPATH");

			// click on the delete icon of the exclusion details
			String record = "//td[contains(text(),'" + updateexcludedMedia
					+ "')]//following-sibling::td//i[@ng-click='selectedIndexToDelete($index)']";
			driver.findElement(By.xpath(record)).click();
			consoleMessage("Clicked on the delete icon of the exclusion details.");

			// wait for the element
			explicitWaitClickable("riskmanagement_insurancepolicies_exclusiontab_confirmationdeletebtn_XPATH");

			// click on the delete button of the confirmation popup
			click("riskmanagement_insurancepolicies_exclusiontab_confirmationdeletebtn_XPATH");

			// validate the deleted exclusion record
			try {
				String updaterecord = "//td[contains(text(),'" + updateexcludedMedia + "')]";
				boolean updaterecord_actual = driver.findElement(By.xpath(updaterecord)).isDisplayed();

				if (updaterecord_actual == true) {
					verificationFailedMessage("The deleted exclusion record is displayed.");

				} else {
					successMessage("The deleted exclusion record is not displayed.");
				}
			} catch (Throwable t) {
				successMessage("The deleted exclusion record is not displayed.");
			}

			// DELETE THE DETAILS OF THE ENDORSEMENTS TAB
			title("DELETE THE DETAILS OF THE ENDORSEMENTS TAB");

			// click on the endorsement tab
			click("riskmanagement_insurancepolicies_endorsementstab_XPATH");

			// click on the delete icon of the exclusion details
			String record2 = "//td[contains(text(),'" + updatedescription
					+ "')]//following-sibling::td//i[@ng-click='setSelectedEndorsementInForm(endorsement)']";
			driver.findElement(By.xpath(record2)).click();
			consoleMessage("Clicked on the delete icon of the exclusion details.");

			// wait for the element
			explicitWaitClickable("riskmanagement_insurancepolicies_endorsementstab_confirmationdeletebtn_XPATH");

			// click on the delete button of the confirmation popup
			click("riskmanagement_insurancepolicies_endorsementstab_confirmationdeletebtn_XPATH");

			// validate the delete endorsement record
			try {
				String updaterecord1 = "//td[text()='" + updatedescription + "')]";
				boolean updaterecord1_actual = driver.findElement(By.xpath(updaterecord1)).isDisplayed();

				if (updaterecord1_actual == true) {
					verificationFailedMessage("The deleted endorsement record is displayed.");
				} else {
					successMessage("The deleted endorsement record is not displayed.");
				}
			} catch (Throwable t) {
				successMessage("The deleted endorsement record is not displayed.");
			}

			// DELETE THE DETAILS OF THE TASKS TAB
			title("DELETE THE DETAILS OF THE TASKS TAB");

			// click on the tasks tab
			click("riskmanagement_insurancepolicies_taskstab_XPATH");

			// click on the action icon
			String updatetask = "//td[text()='" + updatetasktitle
					+ "']//following-sibling::td[@class='text-center pointer']//i[@data-toggle='dropdown']";
			driver.findElement(By.xpath(updatetask)).click();
			consoleMessage("Clicked on the action icon.");

			// wait for the element
			Thread.sleep(5000);

			// click on the delete task option
			String deletetask = "//td[text()='" + updatetasktitle
					+ "']//following-sibling::td[@class='text-center pointer']//i[@data-toggle='dropdown']//following-sibling::ul//li[@ng-click='deleteSelectedTask(task.id, true);']";
			driver.findElement(By.xpath(deletetask)).click();
			consoleMessage("Clicked on the action icon.");

			// validate the delete task
			try {
				String updatetask_XPATH = "//td[text()='" + updatetasktitle + "']";
				boolean updatetask_actual = driver.findElement(By.xpath(updatetask_XPATH)).isDisplayed();

				if (updatetask_actual == true) {
					verificationFailedMessage("The deleted task is displayed.");

				} else {
					successMessage("The deleted task is not displayed.");
				}
			} catch (Throwable t) {
				successMessage("The deleted task is not displayed.");
			}

			// DELETE THE UPDATED INSURANCE POLICY RECORD
			title("DELETE THE UPDATED INSURANCE POLICY RECORD");

			// wait for the element
			explicitWaitClickable("riskmanagement_insurancepolicies_deletebtn_XPATH");

			// click on the delete button
			click("riskmanagement_insurancepolicies_deletebtn_XPATH");

			// wait for the element
			explicitWaitClickable("riskmanagement_insurancepolicies_confirmationdeletebtn_XPATH");

			// click on the delete button of the confirmation popup
			click("riskmanagement_insurancepolicies_confirmationdeletebtn_XPATH");

			// enter the updated insurance policy in the search field
			type("sustainability_searchtxt_XPATH", updatepolicyNumber);

			// validate the updated insurance policy
			try {
				String updatedinsurancepolicy_XPATH = "//td[text()='" + updatepolicyNumber + "']";
				boolean updatedinsurancepolicy_actual = driver.findElement(By.xpath(updatedinsurancepolicy_XPATH))
						.isDisplayed();

				if (updatedinsurancepolicy_actual == true) {
					verificationFailedMessage("The deleted insurance policy is displayed.");
				} else {
					successMessage("The deleted insurance policy is not displayed.");
				}
			} catch (Throwable t) {
				successMessage("The deleted insurance policy is not displayed.");
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

	}
}
