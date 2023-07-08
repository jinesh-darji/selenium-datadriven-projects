package testcases.smokesuite;

import java.io.IOException;
import java.util.Hashtable;

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

		if (!(TestUtil.isTestRunnable("rR5595Morguard9Test", excel))) {

			throw new SkipException(
					"Skipping the test " + "rR5595Morguard9Test".toUpperCase() + "as the Run mode is NO");
		}

		if (!data.get("runmode").equals("Y")) {

			throw new SkipException("Skipping the test case as the Run Mode for data set is NO");
		}

		RandomStringGenerator randomStringGenerator = new RandomStringGenerator.Builder().withinRange('0', 'z')
				.filteredBy(CharacterPredicates.LETTERS, CharacterPredicates.DIGITS).build();
		String incidentnumber = randomStringGenerator.generate(12);
		String insurerclaimnumber = randomStringGenerator.generate(12);
		String adjusterclaimnumber = randomStringGenerator.generate(12);
		String updateincidentnumber = randomStringGenerator.generate(12);
		String updateinsurerclaimnumber = randomStringGenerator.generate(12);
		String updateadjusterclaimnumber = randomStringGenerator.generate(12);

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

		// THE DETAILS OF THE CLAIMS TAB SHOULD BE SAVED AND UPDATED DETAILS SHOULD
		// UPDATE SUCCESSFULLY.

		System.out.println(
				"******************** THE DETAILS OF THE CLAIMS TAB SHOULD BE SAVED AND UPDATED DETAILS SHOULD UPDATE SUCCESSFULLY. ********************");
		test.log(LogStatus.INFO,
				"******************** THE DETAILS OF THE CLAIMS TAB SHOULD BE SAVED AND UPDATED DETAILS SHOULD UPDATE SUCCESSFULLY. ********************");
		Reporter.log(
				"******************** THE DETAILS OF THE CLAIMS TAB SHOULD BE SAVED AND UPDATED DETAILS SHOULD UPDATE SUCCESSFULLY. ********************");
		log.info(
				"******************** THE DETAILS OF THE CLAIMS TAB SHOULD BE SAVED AND UPDATED DETAILS SHOULD UPDATE SUCCESSFULLY. ********************");

		// CREATE NEW INSURANCE CLAIM

		System.out.println("******************** CREATE NEW INSURANCE CLAIM ********************");
		test.log(LogStatus.INFO, "******************** CREATE NEW INSURANCE CLAIM ********************");
		Reporter.log("******************** CREATE NEW INSURANCE CLAIM ********************");
		log.info("******************** CREATE NEW INSURANCE CLAIM ********************");

		try {
			// enter the property name in the search field
			clear("envreports_propertylist_filtertxt_CSS");
			type("envreports_propertylist_filtertxt_CSS", data.get("property_2"));
			ngDriver.waitForAngularRequestsToFinish();
			System.out.println("Entered the property name in the search field.");

			// click on the risk management icon from the property list page
			click("riskmanagementicon_CSS");
			ngDriver.waitForAngularRequestsToFinish();
			System.out.println("Clicked on the risk management icon of the Property.");

			// wait for the element
			Thread.sleep(5000);

			// click on the burger menu
			click("menubtn_CSS");
			ngDriver.waitForAngularRequestsToFinish();
			System.out.println("Clicked on the burger menu button successfully!!!");

			// wait for the element
			Thread.sleep(5000);

			// click on the insurance claims option
			click("riskmanagement_insuranceclaimsoption_XPATH");
			ngDriver.waitForAngularRequestsToFinish();
			System.out.println("Clicked on the insurance claims option.");

			// click on the add button
			click("riskmanagement_addinsuranceclaimbtn_XPATH");
			ngDriver.waitForAngularRequestsToFinish();
			System.out.println("Clicked on the Add button.");

			// enter the details in the incident field
			clear("riskmanagement_insuranceclaim_incidenttxt_CSS");
			type("riskmanagement_insuranceclaim_incidenttxt_CSS", incidentnumber);
			ngDriver.waitForAngularRequestsToFinish();
			System.out.println("Entered the details in the incident field.");

			// enter the details in the claim status field
			select("riskmanagement_insuranceclaim_claimstatusdd_CSS", data.get("claim_status"));
			ngDriver.waitForAngularRequestsToFinish();
			System.out.println("Entered the details in the claim status field.");

			// enter the details in the claim status field
			select("riskmanagement_insuranceclaim_claimtypedd_CSS", data.get("claim_type"));
			ngDriver.waitForAngularRequestsToFinish();
			System.out.println("Entered the details in the claim status field.");

			// click on the incident date field
			click("riskmanagement_insuranceclaim_incidentdatedp_XPATH");
			ngDriver.waitForAngularRequestsToFinish();
			System.out.println("Clicked on the incident date field.");

			// click on the today's button of the incident date field
			click("riskmanagement_insuranceclaim_incidentdatedp_todaybtn_XPATH");
			ngDriver.waitForAngularRequestsToFinish();
			System.out.println("Clicked on the incident date field.");

			// enter the details in the property damage estimation field
			clear("riskmanagement_insuranceclaim_propertydamageestimationtxt_XPATH");
			type("riskmanagement_insuranceclaim_claimtypedd_CSS", "123");
			ngDriver.waitForAngularRequestsToFinish();
			System.out.println("Entered the details in the claim status field.");

			// enter the details in the incident details field
			clear("riskmanagement_insuranceclaim_incidentdetailstxt_XPATH");
			type("riskmanagement_insuranceclaim_incidentdetailstxt_XPATH", data.get("incident_details"));
			ngDriver.waitForAngularRequestsToFinish();
			System.out.println("Entered the details in the incident details field.");

			// scroll down the screen
			JavascriptExecutor js = (JavascriptExecutor) driver;
			js.executeScript("window.scrollBy(0,500)");

			// enter the details in the loss summary statement field
			clear("riskmanagement_insuranceclaim_losssummarystatementtxt_CSS");
			type("riskmanagement_insuranceclaim_losssummarystatementtxt_CSS", data.get("loss_summary"));
			ngDriver.waitForAngularRequestsToFinish();
			System.out.println("Entered the details in the loss summary statement field.");

			// enter the details in the property damage estimation field
			clear("riskmanagement_insuranceclaim_insurerclaimtxt_XPATH");
			type("riskmanagement_insuranceclaim_insurerclaimtxt_XPATH", insurerclaimnumber);
			ngDriver.waitForAngularRequestsToFinish();
			System.out.println("Entered the details in the claim status field.");

			// enter the details in the property damage estimation field
			clear("riskmanagement_insuranceclaim_adjusterclaimtxt_XPATH");
			type("riskmanagement_insuranceclaim_adjusterclaimtxt_XPATH", adjusterclaimnumber);
			ngDriver.waitForAngularRequestsToFinish();
			System.out.println("Entered the details in the claim status field.");

			// click on the save button
			click("riskmanagement_insuranceclaim_savebtn_XPATH");
			ngDriver.waitForAngularRequestsToFinish();
			System.out.println("Clicked on the save button.");

			// wait for the element
			explicitWaitClickable("closetoastmsg_CSS");

			// click on the toaster close button
			click("closetoastmsg_CSS");
			ngDriver.waitForAngularRequestsToFinish();
			System.out.println("Clicked on the toaster close button.");

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
		System.out.println("Clicked on the home icon from the top of the screen.");
		ngDriver.waitForAngularRequestsToFinish();

		// synchronization
		explicitWait("propertylist_title_XPATH");

		// verify the property list
		switchVerification("propertylist_title_XPATH", "Property List", "The property list is not displayed.");

		// UPDATE THE NEWLY INSURANCE CLAIM

		System.out.println("******************** UPDATE THE NEWLY INSURANCE CLAIM ********************");
		test.log(LogStatus.INFO, "******************** UPDATE THE NEWLY INSURANCE CLAIM ********************");
		Reporter.log("******************** UPDATE THE NEWLY INSURANCE CLAIM ********************");
		log.info("******************** UPDATE THE NEWLY INSURANCE CLAIM ********************");

		try {
			// enter the property name in the search field
			clear("envreports_propertylist_filtertxt_CSS");
			type("envreports_propertylist_filtertxt_CSS", data.get("property_2"));
			ngDriver.waitForAngularRequestsToFinish();
			System.out.println("Entered the property name in the search field.");

			// click on the risk management icon from the property list page
			click("riskmanagementicon_CSS");
			ngDriver.waitForAngularRequestsToFinish();
			System.out.println("Clicked on the risk management icon of the Property.");

			// wait for the element
			Thread.sleep(5000);

			// click on the burger menu
			click("menubtn_CSS");
			ngDriver.waitForAngularRequestsToFinish();
			System.out.println("Clicked on the burger menu button successfully!!!");

			// wait for the element
			Thread.sleep(5000);

			// click on the insurance claims option
			click("riskmanagement_insuranceclaimsoption_XPATH");
			ngDriver.waitForAngularRequestsToFinish();
			System.out.println("Clicked on the insurance claims option.");

			// enter insurance claim number in search field
			type("ohs_incident_searchtxt_XPATH", incidentnumber);
			ngDriver.waitForAngularRequestsToFinish();
			System.out.println("Entered insurance claim number in search field.");

			// click on the newly created insurance claim
			String insurancenumber_XPATH = "//td[text()='" + incidentnumber + "']";
			driver.findElement(By.xpath(insurancenumber_XPATH)).click();
			ngDriver.waitForAngularRequestsToFinish();
			System.out.println("Clicked on the newly created insurance claim.");

			// enter the details in the claim status field
			select("riskmanagement_insuranceclaim_claimstatusdd_CSS", data.get("update_claim_status"));
			ngDriver.waitForAngularRequestsToFinish();
			System.out.println("Entered the details in the claim status field.");

			// enter the details in the claim status field
			select("riskmanagement_insuranceclaim_claimtypedd_CSS", data.get("update_claim_type"));
			ngDriver.waitForAngularRequestsToFinish();
			System.out.println("Entered the details in the claim status field.");

			// scroll down the screen
			JavascriptExecutor js = (JavascriptExecutor) driver;
			js.executeScript("window.scrollBy(0,500)");

			// enter the details in the loss summary statement field
			clear("riskmanagement_insuranceclaim_losssummarystatementtxt_CSS");
			type("riskmanagement_insuranceclaim_losssummarystatementtxt_CSS", data.get("update_loss_summary"));
			ngDriver.waitForAngularRequestsToFinish();
			System.out.println("Entered the details in the loss summary statement field.");

			// enter the details in the insurance claim field
			clear("riskmanagement_insuranceclaim_insurerclaimtxt_XPATH");
			type("riskmanagement_insuranceclaim_insurerclaimtxt_XPATH", updateinsurerclaimnumber);
			ngDriver.waitForAngularRequestsToFinish();
			System.out.println("Entered the details in the claim status field.");

			// enter the details in the property damage estimation field
			clear("riskmanagement_insuranceclaim_adjusterclaimtxt_XPATH");
			type("riskmanagement_insuranceclaim_adjusterclaimtxt_XPATH", updateadjusterclaimnumber);
			ngDriver.waitForAngularRequestsToFinish();
			System.out.println("Entered the details in the claim status field.");

			// ADD TASK IN THE NEWLY CREATED INSURANCE CLAIM

			System.out
					.println("******************** ADD TASK IN THE NEWLY CREATED INSURANCE CLAIM ********************");
			test.log(LogStatus.INFO,
					"******************** ADD TASK IN THE NEWLY CREATED INSURANCE CLAIM ********************");
			Reporter.log("******************** ADD TASK IN THE NEWLY CREATED INSURANCE CLAIM ********************");
			log.info("******************** ADD TASK IN THE NEWLY CREATED INSURANCE CLAIM ********************");

			// scroll up the screen
			js.executeScript("window.scrollTo(0,0)");

			// click on the task tab
			click("riskmanagement_insuranceclaim_tasktab_XPATH");
			ngDriver.waitForAngularRequestsToFinish();
			System.out.println("Clicked on the task tab.");

			// click on the new task button
			click("riskmanagement_insuranceclaim_newtaskbtn_XPATH");
			ngDriver.waitForAngularRequestsToFinish();
			System.out.println("Clicked on the new task button.");

			// enter the title of the task
			type("riskmanagement_insuranceclaim_task_titletxt_XPATH", data.get("task_title"));
			ngDriver.waitForAngularRequestsToFinish();
			System.out.println("Entered the title of the task.");

			// enter the location of the task
			type("riskmanagement_insuranceclaim_task_locationtxt_XPATH", data.get("task_location"));
			ngDriver.waitForAngularRequestsToFinish();
			System.out.println("Entered the location of the task.");

			// click on the save button
			click("riskmanagement_insuranceclaim_task_savebtn_XPATH");
			ngDriver.waitForAngularRequestsToFinish();
			System.out.println("Clicked on the save button.");

			// verify the newly created task name
			switchVerification("riskmanagement_insuranceclaim_task_createdtasktext_XPATH", "Test Task Title Morguard 9",
					"The Test Task Title Morguard 9 is not displayed.");

			// ADD COMMENT IN THE NEWLY CREATED INSURANCE CLAIM

			System.out.println(
					"******************** ADD COMMENT IN THE NEWLY CREATED INSURANCE CLAIM ********************");
			test.log(LogStatus.INFO,
					"******************** ADD COMMENT IN THE NEWLY CREATED INSURANCE CLAIM ********************");
			Reporter.log("******************** ADD COMMENT IN THE NEWLY CREATED INSURANCE CLAIM ********************");
			log.info("******************** ADD COMMENT IN THE NEWLY CREATED INSURANCE CLAIM ********************");

			// click on the comment tab
			click("riskmanagement_insuranceclaim_commenttab_XPATH");
			ngDriver.waitForAngularRequestsToFinish();
			System.out.println("Clicked on the comment tab.");

			// type comment in the comment field
			type("riskmanagement_insuranceclaim_comment_commenttxt_XPATH", data.get("comment_claim"));
			ngDriver.waitForAngularRequestsToFinish();
			System.out.println("Typed comment in the comment field.");

			// click on the restriction comment checkbox
			click("riskmanagement_insuranceclaim_comment_restrictionckbx_XPATH");
			ngDriver.waitForAngularRequestsToFinish();
			System.out.println("Clicked on the restriction comment checkbox.");

			// click on the save button
			click("riskmanagement_insuranceclaim_savebtn_XPATH");
			ngDriver.waitForAngularRequestsToFinish();
			System.out.println("Clicked on the save button.");

			// wait for the element
			explicitWaitClickable("closetoastmsg_CSS");

			// click on the toaster close button
			click("closetoastmsg_CSS");
			ngDriver.waitForAngularRequestsToFinish();
			System.out.println("Clicked on the toaster close button.");

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
		System.out.println("Clicked on the home icon from the top of the screen.");
		ngDriver.waitForAngularRequestsToFinish();

		// synchronization
		explicitWait("propertylist_title_XPATH");

		// verify the property list
		switchVerification("propertylist_title_XPATH", "Property List", "The property list is not displayed.");

		// VERIFY NEWLY ADDED COMMENT IN THE ADMIN USER

		System.out.println("******************** VERIFY NEWLY ADDED COMMENT IN THE ADMIN USER ********************");
		test.log(LogStatus.INFO,
				"******************** VERIFY NEWLY ADDED COMMENT IN THE ADMIN USER ********************");
		Reporter.log("******************** VERIFY NEWLY ADDED COMMENT IN THE ADMIN USER ********************");
		log.info("******************** VERIFY NEWLY ADDED COMMENT IN THE ADMIN USER ********************");

		try {
			// enter the property name in the search field
			clear("envreports_propertylist_filtertxt_CSS");
			type("envreports_propertylist_filtertxt_CSS", data.get("property_2"));
			ngDriver.waitForAngularRequestsToFinish();
			System.out.println("Entered the property name in the search field.");

			// click on the risk management icon from the property list page
			click("riskmanagementicon_CSS");
			ngDriver.waitForAngularRequestsToFinish();
			System.out.println("Clicked on the risk management icon of the Property.");

			// wait for the element
			Thread.sleep(5000);

			// click on the burger menu
			click("menubtn_CSS");
			ngDriver.waitForAngularRequestsToFinish();
			System.out.println("Clicked on the burger menu button successfully!!!");

			// wait for the element
			Thread.sleep(5000);

			// click on the insurance claims option
			click("riskmanagement_insuranceclaimsoption_XPATH");
			ngDriver.waitForAngularRequestsToFinish();
			System.out.println("Clicked on the insurance claims option.");

			// enter insurance claim number in search field
			type("ohs_incident_searchtxt_XPATH", incidentnumber);
			ngDriver.waitForAngularRequestsToFinish();
			System.out.println("Entered insurance claim number in search field.");

			// click on the updated insurance claim
			String insurancenumber_XPATH = "//td[text()='" + incidentnumber + "']";
			driver.findElement(By.xpath(insurancenumber_XPATH)).click();
			ngDriver.waitForAngularRequestsToFinish();
			System.out.println("Clicked on the newly created insurance claim.");

			// click on the comment tab
			click("riskmanagement_insuranceclaim_commenttab_XPATH");
			ngDriver.waitForAngularRequestsToFinish();
			System.out.println("Clicked on the comment tab.");

			// scroll down the screen
			JavascriptExecutor js = (JavascriptExecutor) driver;
			js.executeScript("window.scrollBy(0,500)");

			// verify the newly added comment
			switchVerification("riskmanagement_insuranceclaim_comment_addedcomment_XPATH",
					"Test Claim Comment Morguard 9", "The Test Claim Comment Morguard 9 is not displayed.");

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

		// DELETE THE UPDATED INSURANCE CLAIM

		System.out.println("******************** DELETE THE UPDATED INSURANCE CLAIM ********************");
		test.log(LogStatus.INFO, "******************** DELETE THE UPDATED INSURANCE CLAIM ********************");
		Reporter.log("******************** DELETE THE UPDATED INSURANCE CLAIM ********************");
		log.info("******************** DELETE THE UPDATED INSURANCE CLAIM ********************");

		try {
			// enter the property name in the search field
			clear("envreports_propertylist_filtertxt_CSS");
			type("envreports_propertylist_filtertxt_CSS", data.get("property_2"));
			ngDriver.waitForAngularRequestsToFinish();
			System.out.println("Entered the property name in the search field.");

			// click on the risk management icon from the property list page
			click("riskmanagementicon_CSS");
			ngDriver.waitForAngularRequestsToFinish();
			System.out.println("Clicked on the risk management icon of the Property.");

			// wait for the element
			Thread.sleep(5000);

			// click on the burger menu
			click("menubtn_CSS");
			ngDriver.waitForAngularRequestsToFinish();
			System.out.println("Clicked on the burger menu button successfully!!!");

			// wait for the element
			Thread.sleep(5000);

			// click on the insurance claims option
			click("riskmanagement_insuranceclaimsoption_XPATH");
			ngDriver.waitForAngularRequestsToFinish();
			System.out.println("Clicked on the insurance claims option.");

			// enter insurance claim number in search field
			type("ohs_incident_searchtxt_XPATH", incidentnumber);
			ngDriver.waitForAngularRequestsToFinish();
			System.out.println("Entered insurance claim number in search field.");

			// click on the updated insurance claim
			String insurancenumber_XPATH = "//td[text()='" + incidentnumber + "']";
			driver.findElement(By.xpath(insurancenumber_XPATH)).click();
			ngDriver.waitForAngularRequestsToFinish();
			System.out.println("Clicked on the newly created insurance claim.");

			// click on the delete button
			click("riskmanagement_insuranceclaim_deletebtn_XPATH");
			ngDriver.waitForAngularRequestsToFinish();
			System.out.println("Clicked on the delete button.");

			// click on the delete button of the confirmation popup
			click("riskmanagement_insuranceclaim_confirmationdeletebtn_XPATH");
			ngDriver.waitForAngularRequestsToFinish();
			System.out.println("Clicked on the delete button of the confirmation popup.");

			// wait for the element
			explicitWaitClickable("closetoastmsg_CSS");

			// click on the toaster close button
			click("closetoastmsg_CSS");
			ngDriver.waitForAngularRequestsToFinish();
			System.out.println("Clicked on the toaster close button.");

			// verify insurance claim delete or not
			String updateinsurerclaimnumber_XPATH = "//td[text()='" + updateincidentnumber
					+ "']//following-sibling::td[text()='" + updateinsurerclaimnumber + "']";
			deleteVerification(updateinsurerclaimnumber_XPATH, updateinsurerclaimnumber);

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
