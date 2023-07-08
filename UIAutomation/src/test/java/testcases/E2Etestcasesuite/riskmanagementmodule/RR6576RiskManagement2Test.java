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

public class RR6576RiskManagement2Test extends TestBase {

	@Test(dataProviderClass = TestUtil.class, dataProvider = "dp")
	public void rR6576RiskManagement2Test(Hashtable<String, String> data) throws IOException, InterruptedException {

		execution(data, "rR6576RiskManagement2Test");

		// refresh the page
		driver.navigate().refresh();
		Thread.sleep(5000);
		driver.navigate().refresh();

		// VERIFY THE RENEW FEATURE OF THE INSURANCE POLICY.
		title("VERIFY THE RENEW FEATURE OF THE INSURANCE POLICY.");

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
		String excludedMedia = RandomStringUtils.randomAlphabetic(8);
		String excludedCoverage = RandomStringUtils.randomAlphabetic(8);
		String endorsementNumber = RandomStringUtils.randomNumeric(3);
		String description = RandomStringUtils.randomAlphabetic(8);
		String comment = RandomStringUtils.randomAlphabetic(8);
		String tasktitle = RandomStringUtils.randomAlphabetic(8);
		LocalDate today = LocalDate.now();
		String today_string = today.toString();
		LocalDate reneweffectivedate = LocalDate.now().plusMonths(1);
		String reneweffectivedate_string = reneweffectivedate.toString();
		LocalDate renewexpirydate = LocalDate.now().plusMonths(2);
		String renewexpirydate_string = renewexpirydate.toString();

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

			// ADD AND VALIDATE THE DETAILS OF THE ENDORSEMENTS TAB
			title("ADD AND VALIDATE THE DETAILS OF THE ENDORSEMENTS TAB");

			// click on the endorsement tab
			click("riskmanagement_insurancepolicies_endorsementstab_XPATH");

			// click on the add endorsement details icon
			click("riskmanagement_insurancepolicies_endorsementstab_addendorsementdetailsicon_XPATH");

			// enter the today's date in the effective date field
			type("riskmanagement_insurancepolicies_endorsementstab_effectivedatetxt_XPATH", today_string);

			// enter the today's date in the expiry date field
			type("riskmanagement_insurancepolicies_endorsementstab_expirydatetxt_XPATH", today_string);

			// enter the details in the endorsement number field
			type("riskmanagement_insurancepolicies_endorsementstab_endorsementnumbertxt_XPATH", endorsementNumber);

			// enter the details in the premium field
			type("riskmanagement_insurancepolicies_endorsementstab_premiumtxt_XPATH", premium);

			// enter the details in the description field
			type("riskmanagement_insurancepolicies_endorsementstab_descriptiontxt_XPATH", description);

			// enter the details in the comment field
			type("riskmanagement_insurancepolicies_endorsementstab_commenttxt_XPATH", data.get("comment"));

			// click on the ok button
			click("riskmanagement_insurancepolicies_endorsementstab_okbtn_XPATH");

			// validate the newly added endorsement record
			try {
				String record = "//td[text()='" + description + "')]";
				boolean record_actual = driver.findElement(By.xpath(record)).isDisplayed();

				if (record_actual == true) {
					successMessage("The newly added endorsement record is displayed successfully.");
				} else {
					verificationFailedMessage("The newly added endorsement record is not displayed.");
				}
			} catch (Throwable t) {
				verificationFailedMessage("The newly added endorsement record is not displayed.");
			}

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

		// RENEW THE INSURANCE POLICY
		title("RENEW THE INSURANCE POLICY");

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

			// scroll down to bottom
			scrollBottom();

			// validate the term and date details
			try {
				String term1_actual = (driver
						.findElement(
								By.xpath(OR.getProperty("riskmanagement_insurancepolicies_term1_highlighted_XPATH")))
						.getText()).trim();
				String term1_expected = "T1/" + today_string;

				if (term1_actual.equals(term1_expected)) {
					successMessage("The term number and date are displayed as expected.");
				} else {
					verificationFailedMessage("The term number and date are not displayed.");
				}
			} catch (Throwable t) {
				verificationFailedMessage("The term number and date are not displayed.");
			}

			// click on the renew button
			click("riskmanagement_insurancepolicies_renewbtn_XPATH");

			// enter the renew date in the effective date field
			type("riskmanagement_insurancepolicies_renewpolicy_effectivedatetxt_XPATH", reneweffectivedate_string);

			// enter the renew date in the expiry date field
			type("riskmanagement_insurancepolicies_renewpolicy_expirydatetxt_XPATH", renewexpirydate_string);

			// click on the renew button
			click("riskmanagement_insurancepolicies_renewpolicy_renewbtn_XPATH");

			// validate the date of the term effective date field
			try {
				String date_actual = (driver
						.findElement(By.xpath(OR.getProperty(
								"riskmanagement_insurancepolicies_revisioninfotab_termeffectivedate_XPATH")))
						.getAttribute("value")).trim();

				if (date_actual.equals(reneweffectivedate_string)) {
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

				if (date_actual.equals(renewexpirydate_string)) {
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

				if (date_actual.equals(reneweffectivedate_string)) {
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

				if (date_actual.equals(renewexpirydate_string)) {
					successMessage("The default date of the revision expiry date field is displayed correctly.");
				} else {
					verificationFailedMessage("The default date of the revision expiry date field is not displayed.");
				}
			} catch (Throwable t) {
				verificationFailedMessage("The default date of the revision expiry date field is not displayed.");
			}

			// validate the term and date details for renewed policy
			try {
				String term2_actual = (driver
						.findElement(By.xpath(OR.getProperty("riskmanagement_insurancepolicies_term2_XPATH")))
						.getText()).trim();
				String term2_expected = "T2/" + reneweffectivedate_string;

				if (term2_actual.equals(term2_expected)) {
					successMessage("The renewed term number and date are displayed as expected.");
				} else {
					verificationFailedMessage("The renewed term number and date are not displayed.");
				}
			} catch (Throwable t) {
				verificationFailedMessage("The renewed term number and date are not displayed.");
			}

			// click on the renewed term
			driver.findElement(By.xpath(OR.getProperty("riskmanagement_insurancepolicies_term2_XPATH"))).click();

			// click on the update button of the insurance policy
			click("riskmanagement_insurancepolicies_updatebtn_XPATH");

			// click on the cancel button of the insurance policy
			click("riskmanagement_insurancepolicies_cancelbtn_XPATH");

		} catch (Throwable t) {
			verificationFailed();
		}

		// click on the home icon
		click("questionnaire_homeburgermenubtn_hide_CSS");

		// wait for the element
		explicitWait("propertylist_title_XPATH");

		// verify the property list
		switchVerification("propertylist_title_XPATH", "Property List", "The property list is not displayed.");

		// VALIDATE THE RENEWED POLICY DETAILS
		title("VALIDATE THE RENEWED POLICY DETAILS");

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

			// scroll down to bottom
			scrollBottom();

			// click on the renewed term
			driver.findElement(By.xpath(OR.getProperty("riskmanagement_insurancepolicies_term2_XPATH"))).click();

			// VALIDATE THE DETAILS OF THE REVISION INFO TAB OF THE RENEWED POLICY
			title("VALIDATE THE DETAILS OF THE REVISION INFO TAB OF THE RENEWED POLICY");

			// validate the date of the term effective date field
			try {
				String date_actual = (driver
						.findElement(By.xpath(OR.getProperty(
								"riskmanagement_insurancepolicies_revisioninfotab_termeffectivedate_XPATH")))
						.getAttribute("value")).trim();

				if (date_actual.equals(reneweffectivedate_string)) {
					successMessage("The renewed date of the term effective date field is displayed correctly.");
				} else {
					verificationFailedMessage("The renewed date of the term effective date field is not displayed.");
				}
			} catch (Throwable t) {
				verificationFailedMessage("The renewed date of the term effective date field is not displayed.");
			}

			// validate the date of the term expiry date field
			try {
				String date_actual = (driver
						.findElement(By.xpath(OR
								.getProperty("riskmanagement_insurancepolicies_revisioninfotab_termexpirydate_XPATH")))
						.getAttribute("value")).trim();

				if (date_actual.equals(renewexpirydate_string)) {
					successMessage("The renewed date of the term expiry date field is displayed correctly.");
				} else {
					verificationFailedMessage("The renewed date of the term expiry date field is not displayed.");
				}
			} catch (Throwable t) {
				verificationFailedMessage("The renewed date of the term expiry date field is not displayed.");
			}

			// validate the date of the revision effective date field
			try {
				String date_actual = (driver
						.findElement(By.xpath(OR.getProperty(
								"riskmanagement_insurancepolicies_revisioninfotab_revisioneffectivedate_XPATH")))
						.getAttribute("value")).trim();

				if (date_actual.equals(reneweffectivedate_string)) {
					successMessage("The renewed date of the revision effective date field is displayed correctly.");
				} else {
					verificationFailedMessage(
							"The renewed date of the revision effective date field is not displayed.");
				}
			} catch (Throwable t) {
				verificationFailedMessage("The renewed date of the revision effective date field is not displayed.");
			}

			// validate the date of the revision expiry date field
			try {
				String date_actual = (driver
						.findElement(By.xpath(OR.getProperty(
								"riskmanagement_insurancepolicies_revisioninfotab_revisionexpirydate_XPATH")))
						.getAttribute("value")).trim();

				if (date_actual.equals(renewexpirydate_string)) {
					successMessage("The renewed date of the revision expiry date field is displayed correctly.");
				} else {
					verificationFailedMessage("The renewed date of the revision expiry date field is not displayed.");
				}
			} catch (Throwable t) {
				verificationFailedMessage("The renewed date of the revision expiry date field is not displayed.");
			}

			// validate the insurer name in the renewed policy
			try {
				String insurer_XPATH = "//td[text()='" + insurer + "']";
				boolean insurer_actual = driver.findElement(By.xpath(insurer_XPATH)).isDisplayed();

				if (insurer_actual == true) {
					successMessage("The insurer name in the renewed policy is displayed successfully.");
				} else {
					verificationFailedMessage("The insurer name in the renewed policy is not displayed.");
				}
			} catch (Throwable t) {
				verificationFailedMessage("The insurer name in the renewed policy is not displayed.");
			}

			// validate the owner name in the renewed policy
			try {
				String owner_XPATH = "//td[text()='" + owner + "']";
				boolean owner_actual = driver.findElement(By.xpath(owner_XPATH)).isDisplayed();

				if (owner_actual == true) {
					successMessage("The owner name in the renewed policy is displayed successfully.");
				} else {
					verificationFailedMessage("The owner name in the renewed policy is not displayed.");
				}
			} catch (Throwable t) {
				verificationFailedMessage("The owner name in the renewed policy is not displayed.");
			}

			// VALIDATE THE DETAILS OF THE REVISION DETAILS TAB OF THE RENEWED POLICY
			title("VALIDATE THE DETAILS OF THE REVISION DETAILS TAB OF THE RENEWED POLICY");

			// click on the revision details tab
			click("riskmanagement_insurancepolicies_revisiondetailstab_XPATH");

			// validate the Premium detail of the renewed policy
			try {
				String premium_actual = (driver
						.findElement(By.xpath(
								OR.getProperty("riskmanagement_insurancepolicies_revisiondetailstab_premiumtxt_XPATH")))
						.getAttribute("value")).trim();

				if (premium_actual == premium) {
					successMessage("The Premium detail of the renewed policy.");
				} else {
					verificationFailedMessage("The Premium detail of the renewed policy.");
				}
			} catch (Throwable t) {
				verificationFailedMessage("The Premium detail of the renewed policy.");
			}

			// validate the Claims Deductible detail of the renewed policy
			try {
				String claimDeductible_actual = (driver
						.findElement(By.xpath(OR.getProperty(
								"riskmanagement_insurancepolicies_revisiondetailstab_claimsdeductibletxt_XPATH")))
						.getAttribute("value")).trim();

				if (claimDeductible_actual == claimDeductible) {
					successMessage("The Claims Deductible detail of the renewed policy is displayed successfully.");
				} else {
					verificationFailedMessage("The Claims Deductible detail is of the renewed policy not displayed.");
				}
			} catch (Throwable t) {
				verificationFailedMessage("The Claims Deductible detail is of the renewed policy not displayed.");
			}

			// validate the Policy Aggregate Coverage Limit detail of the renewed policy
			try {
				String policyCoverageLimit_actual = (driver
						.findElement(By.xpath(OR.getProperty(
								"riskmanagement_insurancepolicies_revisiondetailstab_claimslimittxt_XPATH")))
						.getAttribute("value")).trim();

				if (policyCoverageLimit_actual == policyCoverageLimit) {
					successMessage(
							"The Policy Aggregate Coverage Limit detail is of the renewed policy displayed successfully.");
				} else {
					verificationFailedMessage(
							"The Policy Aggregate Coverage Limit detail is of the renewed policy not displayed.");
				}
			} catch (Throwable t) {
				verificationFailedMessage(
						"The Policy Aggregate Coverage Limit detail is of the renewed policy not displayed.");
			}

			// validate the Per Claim Coverage Limit detail of the renewed policy
			try {
				String perClaimCoverageLimit_actual = (driver
						.findElement(By.xpath(OR.getProperty(
								"riskmanagement_insurancepolicies_revisiondetailstab_perclaimcoveragelimittxt_XPATH")))
						.getAttribute("value")).trim();

				if (perClaimCoverageLimit_actual == perClaimCoverageLimit) {
					successMessage("The Claim Coverage Limit detail is of the renewed policy displayed successfully.");
				} else {
					verificationFailedMessage(
							"The Claim Coverage Limit detail is of the renewed policy not displayed.");
				}
			} catch (Throwable t) {
				verificationFailedMessage("The Claim Coverage Limit detail is of the renewed policy not displayed.");
			}

			// validate the details in the details field of the renewed policy
			try {
				String details_actual = (driver
						.findElement(By.xpath(
								OR.getProperty("riskmanagement_insurancepolicies_revisiondetailstab_detailtxt_XPATH")))
						.getAttribute("value")).trim();

				if (details_actual == data.get("details")) {
					successMessage("The details in the details field of the renewed policy displayed successfully.");
				} else {
					verificationFailedMessage("The details in the details field of the renewed policy not displayed.");
				}
			} catch (Throwable t) {
				verificationFailedMessage("The details in the details field of the renewed policy not displayed.");
			}

			// validate the details in the known condition field of the renewed policy
			try {
				String known_condition_actual = (driver
						.findElement(By.xpath(OR.getProperty(
								"riskmanagement_insurancepolicies_revisiondetailstab_knownconditionstxt_XPATH")))
						.getAttribute("value")).trim();

				if (known_condition_actual == data.get("known_condition")) {
					successMessage(
							"The details in the known condition field of the renewed policy displayed successfully.");
				} else {
					verificationFailedMessage(
							"The details in the known condition field of the renewed policy not displayed.");
				}
			} catch (Throwable t) {
				verificationFailedMessage(
						"The details in the known condition field of the renewed policy not displayed.");
			}

			// VALIDATE THE DETAILS OF THE PROPERTY COVERED TAB OF THE RENEWED POLICY
			title("VALIDATE THE DETAILS OF THE PROPERTY COVERED TAB OF THE RENEWED POLICY");

			// click on the property covered tab
			click("riskmanagement_insurancepolicies_propertycoveredtab_XPATH");

			// scroll down till bottom
			scrollBottom();

			// validate the property 4 is displayed as a selected for renewed policy
			try {
				boolean minusicon_property4 = driver
						.findElement(By.xpath(OR.getProperty(
								"riskmanagement_insurancepolicies_propertycoveredtab_property4_minusicon_XPATH")))
						.isDisplayed();

				if (minusicon_property4 == true) {
					successMessage("The property 4 is displayed as a selected successfully for renewed policy.");
				} else {
					verificationFailedMessage("The property 4 is not displayed as a selected for renewed policy.");
				}
			} catch (Throwable t) {
				verificationFailedMessage("The property 4 is not displayed as a selected for renewed policy.");
			}

			// validate the property 3 is displayed as a selected for renewed policy
			try {
				boolean minusicon_property3 = driver
						.findElement(By.xpath(OR.getProperty(
								"riskmanagement_insurancepolicies_propertycoveredtab_property3_minusicon_XPATH")))
						.isDisplayed();

				if (minusicon_property3 == true) {
					successMessage("The property 3 is displayed as a selected successfully for renewed policy.");
				} else {
					verificationFailedMessage("The property 3 is not displayed as a selected for renewed policy.");
				}
			} catch (Throwable t) {
				verificationFailedMessage("The property 3 is not displayed as a selected for renewed policy.");
			}

			// VALIDATE THE DETAILS OF THE EXCLUSION TAB OF THE RENEWED POLICY
			title("VALIDATE THE DETAILS OF THE EXCLUSION TAB OF THE RENEWED POLICY");

			// click on the exclusion tab
			click("riskmanagement_insurancepolicies_exclusiontab_XPATH");

			// validate the newly added exclusion record for renewed policy
			try {
				String record = "//td[contains(text(),'" + excludedMedia + "')]";
				boolean record_actual = driver.findElement(By.xpath(record)).isDisplayed();

				if (record_actual == true) {
					successMessage("The newly added exclusion record is displayed successfully for renewed policy.");
				} else {
					verificationFailedMessage("The newly added exclusion record is not displayed for renewed policy.");
				}
			} catch (Throwable t) {
				verificationFailedMessage("The newly added exclusion record is not displayed for renewed policy.");
			}

			// VALIDATE THE DETAILS OF THE ENDORSEMENTS TAB OF THE RENEWED POLICY
			title("VALIDATE THE DETAILS OF THE ENDORSEMENTS TAB OF THE RENEWED POLICY");

			// click on the endorsement tab
			click("riskmanagement_insurancepolicies_endorsementstab_XPATH");

			// validate the newly added endorsement record for renewed policy
			try {
				String record = "//td[text()='" + description + "')]";
				boolean record_actual = driver.findElement(By.xpath(record)).isDisplayed();

				if (record_actual == true) {
					successMessage("The newly added endorsement record is displayed successfully for renewed policy.");
				} else {
					verificationFailedMessage(
							"The newly added endorsement record is not displayed for renewed policy.");
				}
			} catch (Throwable t) {
				verificationFailedMessage("The newly added endorsement record is not displayed for renewed policy.");
			}

			// VALIDATE THE DETAILS OF THE ATTACHMENTS TAB OF THE RENEWED POLICY
			title("VALIDATE THE DETAILS OF THE ATTACHMENTS TAB OF THE RENEWED POLICY");

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

			// VALIDATE THE DETAILS OF THE COMMENTS TAB OF THE RENEWED POLICY
			title("VALIDATE THE DETAILS OF THE COMMENTS TAB OF THE RENEWED POLICY");

			// click on the comments tab
			click("riskmanagement_insurancepolicies_commentstab_XPATH");

			// scroll down till bottom
			scrollBottom();

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

			// ADD AND VALIDATE THE DETAILS OF THE TASKS TAB OF THE RENEWED POLICY
			title("ADD AND VALIDATE THE DETAILS OF THE TASKS TAB OF THE RENEWED POLICY");

			// click on the tasks tab
			click("riskmanagement_insurancepolicies_taskstab_XPATH");

			// validate the newly created task for renewed policy
			try {
				String task_XPATH = "//td[text()='" + tasktitle + "']";
				boolean task_actual = driver.findElement(By.xpath(task_XPATH)).isDisplayed();

				if (task_actual == true) {
					successMessage("The newly created task is displayed successfully for renewed policy.");
				} else {
					verificationFailedMessage("The newly created task is not displayed for renewed policy.");
				}
			} catch (Throwable t) {
				verificationFailedMessage("The newly created task is not displayed for renewed policy.");
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
				String insurancepolicy1_XPATH = "//td[text()='" + policyNumber + "']";
				boolean insurancepolicy1_actual = driver.findElement(By.xpath(insurancepolicy1_XPATH)).isDisplayed();

				if (insurancepolicy1_actual == true) {
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
			type("sustainability_searchtxt_XPATH", policyNumber);

			// click on the insurance policy
			String insurancepolicy_XPATH = "//td[text()='" + policyNumber + "']";
			driver.findElement(By.xpath(insurancepolicy_XPATH)).click();
			consoleMessage("Clicked on the insurance policy.");

			// scroll down the bottom
			scrollBottom();

			// wait for the element
			explicitWaitClickable("riskmanagement_insurancepolicies_revisiondeletebtn_XPATH");

			// click on the delete button
			click("riskmanagement_insurancepolicies_revisiondeletebtn_XPATH");

			// wait for the element
			explicitWaitClickable("riskmanagement_insurancepolicies_confirmationdeletebtn_XPATH");

			// click on the delete button of the confirmation popup
			click("riskmanagement_insurancepolicies_confirmationdeletebtn_XPATH");

			// validate the deleted term and date details
			try {
				String term1_actual = (driver
						.findElement(
								By.xpath(OR.getProperty("riskmanagement_insurancepolicies_term1_highlighted_XPATH")))
						.getText()).trim();
				String term1_expected = "T1/" + today_string;

				if (term1_actual.equals(term1_expected)) {
					verificationFailedMessage("The term number and date are displayed.");
				} else {
					successMessage("The term number and date are not displayed as expected.");
				}
			} catch (Throwable t) {
				successMessage("The term number and date are not displayed as expected.");
			}

			// validate the term and date details for renewed policy
			try {
				String term2_actual = (driver
						.findElement(By.xpath(OR.getProperty("riskmanagement_insurancepolicies_term1_XPATH")))
						.getText()).trim();
				String term2_expected = "T1/" + reneweffectivedate_string;

				if (term2_actual.equals(term2_expected)) {
					successMessage("The renewed term number and date are displayed as expected.");
				} else {
					verificationFailedMessage("The renewed term number and date are not displayed.");
				}
			} catch (Throwable t) {
				verificationFailedMessage("The renewed term number and date are not displayed.");
			}

			// wait for the element
			explicitWaitClickable("riskmanagement_insurancepolicies_deletebtn_XPATH");

			// click on the delete button
			click("riskmanagement_insurancepolicies_deletebtn_XPATH");

			// wait for the element
			explicitWaitClickable("riskmanagement_insurancepolicies_confirmationdeletebtn_XPATH");

			// click on the delete button of the confirmation popup
			click("riskmanagement_insurancepolicies_confirmationdeletebtn_XPATH");

			// enter the insurance policy in the search field
			type("sustainability_searchtxt_XPATH", policyNumber);

			// validate the insurance policy
			try {
				String insurancepolicy1_XPATH = "//td[text()='" + policyNumber + "']";
				boolean insurancepolicy_actual = driver.findElement(By.xpath(insurancepolicy1_XPATH)).isDisplayed();

				if (insurancepolicy_actual == true) {
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
