package testcases.E2Etestcasesuite.propertyprojectmodule;

import java.io.IOException;
import java.util.Hashtable;
import java.util.List;

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

public class RR4884PropertyProjectTest extends TestBase {

	@Test(dataProviderClass = TestUtil.class, dataProvider = "dp")
	public void rR4884PropertyProjectTest(Hashtable<String, String> data) throws IOException, InterruptedException {

		execution(data, "rR4884PropertyProjectTest");

		// PREPARE THE CRUD OPERATION OF THE CONTRACTOR MODULE.

		System.out.println("PREPARE THE CRUD OPERATION OF THE CONTRACTOR MODULE.");
		test.log(LogStatus.INFO, "PREPARE THE CRUD OPERATION OF THE CONTRACTOR MODULE.");
		Reporter.log("PREPARE THE CRUD OPERATION OF THE CONTRACTOR MODULE.");
		log.info("PREPARE THE CRUD OPERATION OF THE CONTRACTOR MODULE.");

		Helper helper = new Helper();

		// refresh the page
		driver.navigate().refresh();
		Thread.sleep(5000);
		driver.navigate().refresh();

		System.out.println("Navigate to the Home Screen i.e. Property List Screen.");

		// ADD CONTRACTOR

		System.out.println("**************** ADD CONTRACTOR ****************");
		test.log(LogStatus.INFO, "**************** ADD CONTRACTOR ****************");
		Reporter.log("**************** ADD CONTRACTOR ****************");
		log.info("**************** ADD CONTRACTOR ****************");

		try {

			// wait for the element
			explicitWaitClickable("propertyproject_icon_CSS");

			// click on the property project icon from the property list page
			click("propertyproject_icon_CSS");
			System.out.println("Clicked on the property project icon of the Property.");
			ngDriver.waitForAngularRequestsToFinish();
			System.out.println("Navigate to the property project screen of the perticular property.");

			// wait for the element
			explicitWaitClickable("menubtn_CSS");

			// click on the burger menu
			click("menubtn_CSS");
			System.out.println("Clicked on the burger menu button successfully!!!");
			ngDriver.waitForAngularRequestsToFinish();

			// wait for the element
			Thread.sleep(5000);

			// click on the CONTRACTOR
			click("propertyproject_contractorsoption_XPATH");
			System.out.println("Clicked on the contractor option.");
			ngDriver.waitForAngularRequestsToFinish();

			// ADD RECORD - CONTRACTOR

			// click on the add button
			click("propertyproject_co_addcontractorsbtn_CSS");
			System.out.println("Clicked on the Add button.");
			ngDriver.waitForAngularRequestsToFinish();
			System.out.println("Navigate to the Add CONTRACTOR Screen");

			// enter the contractor name
			type("propertyproject_co_contractornametxt_CSS", data.get("contractor_name"));
			System.out.println("Entered the contractor name.");
			ngDriver.waitForAngularRequestsToFinish();

			// enter the telephone number
			type("propertyproject_co_telephonenotxt_CSS", "9876543210");
			System.out.println("Entered the telephone number.");
			ngDriver.waitForAngularRequestsToFinish();

			// enter the city
			type("propertyproject_co_citytxt_CSS", data.get("city"));
			System.out.println("Entered the city.");
			ngDriver.waitForAngularRequestsToFinish();

			// enter the province
			type("propertyproject_co_provincetxt_CSS", data.get("province"));
			System.out.println("Entered the province.");
			ngDriver.waitForAngularRequestsToFinish();

			// enter the country
			type("propertyproject_co_countrytxt_CSS", data.get("country"));
			System.out.println("Entered the country.");
			ngDriver.waitForAngularRequestsToFinish();

			// click on the save button
			click("propertyproject_co_savebtn_CSS");
			ngDriver.waitForAngularRequestsToFinish();
			System.out.println("Clicked on the save button.");

			// wait for the element
			explicitWait("propertyproject_co_filtertxt_CSS");

			// enter the contractor name
			clear("propertyproject_co_filtertxt_CSS");
			ngDriver.waitForAngularRequestsToFinish();
			System.out.println("Clear the contractor name field.");
			type("propertyproject_co_filtertxt_CSS", data.get("contractor_name"));
			System.out.println("Entered the contractor name.");
			ngDriver.waitForAngularRequestsToFinish();

			// verification of the contractor is added or not
			switchVerification("propertyproject_co_addedcontractor_XPATH", "Contractor Testing Name",
					"The Contractor Testing Name is not displayed successfully.");

			// click on the home icon from the top of the screen
			click("questionnaire_homeburgermenubtn_hide_CSS");
			System.out.println("Clicked on the home icon from the top of the screen.");
			ngDriver.waitForAngularRequestsToFinish();

			// wait for the element
			explicitWait("propertylist_title_XPATH");

			// verify the property list
			switchVerification("propertylist_title_XPATH", "Property List", "The property list is not displayed.");

			// click on the property project icon from the property list page
			click("propertyproject_icon_CSS");
			System.out.println("Clicked on the property project icon of the Property.");
			ngDriver.waitForAngularRequestsToFinish();
			System.out.println("Navigate to the property project screen of the perticular property.");

			// wait for the element
			explicitWaitClickable("menubtn_CSS");

			// click on the burger menu
			click("menubtn_CSS");
			System.out.println("Clicked on the burger menu button successfully!!!");
			ngDriver.waitForAngularRequestsToFinish();

			// wait for the element
			Thread.sleep(5000);

			// click on the Mortgage Undertakings
			click("propertyproject_mortgageundertakingsoption_XPATH");
			System.out.println("Clicked on the Mortgage Undertakings option.");
			ngDriver.waitForAngularRequestsToFinish();

			// VERIFY NEWLY CREATED CONTRACTOR IS DISPLAYED OR NOT IN THE MORTGAGE
			// UNDERTAKINGS

			System.out.println(
					"***************** VERIFY NEWLY CREATED CONTRACTOR IS DISPLAYED OR NOT IN THE MORTGAGE UNDERTAKINGS *****************");
			test.log(LogStatus.INFO,
					"***************** VERIFY NEWLY CREATED CONTRACTOR IS DISPLAYED OR NOT IN THE MORTGAGE UNDERTAKINGS *****************");
			Reporter.log(
					"***************** VERIFY NEWLY CREATED CONTRACTOR IS DISPLAYED OR NOT IN THE MORTGAGE UNDERTAKINGS *****************");
			log.info(
					"***************** VERIFY NEWLY CREATED CONTRACTOR IS DISPLAYED OR NOT IN THE MORTGAGE UNDERTAKINGS *****************");

			// click on the add button
			click("propertyproject_mu_addbtn_CSS");
			System.out.println("Clicked on the Add button.");
			ngDriver.waitForAngularRequestsToFinish();
			System.out.println("Navigate to the Add Mortgage Undertakings Screen");

			// enter the undertaking number
			type("propertyproject_mu_undertakingnumbertxt_CSS", data.get("undertaking_number_1"));
			System.out.println("Entered the undertaking number.");
			ngDriver.waitForAngularRequestsToFinish();

			// select the lender
			select("propertyproject_mu_lenderdd_CSS", data.get("lender"));
			ngDriver.waitForAngularRequestsToFinish();
			System.out.println("Selected the lender.");

			// click on the save button
			click("propertyproject_mu_savebtn_CSS");
			ngDriver.waitForAngularRequestsToFinish();
			System.out.println("Clicked on the save button.");

			// wait for the element
			explicitWaitClickable("propertyproject_mu_newrepairbtn_BTNTEXT");

			// click on the new repair button
			click("propertyproject_mu_newrepairbtn_BTNTEXT");
			ngDriver.waitForAngularRequestsToFinish();
			System.out.println("Clicked on the new repair button.");

			// scroll down the screen
			JavascriptExecutor js = (JavascriptExecutor) driver;
			js.executeScript("window.scrollBy(0,400)");
			ngDriver.waitForAngularRequestsToFinish();
			System.out.println("Scroll down the screen.");

			// click on the cost/budget tab
			click("propertyproject_mu_costbudgettab_CSS");
			ngDriver.waitForAngularRequestsToFinish();
			System.out.println("Clicked on the cost/budget tab.");

			try {

				// select on the contractor field
				select("propertyproject_mu_contrctortxt_CSS", data.get("contractor_name"));
				ngDriver.waitForAngularRequestsToFinish();
				System.out.println("Clicked on the contractor field.");

				System.out.println(
						"New created contractor is displayed successfully while creating the MORTGAGE UNDERTAKINGS.");
				test.log(LogStatus.INFO,
						"New created contractor is displayed successfully while creating the MORTGAGE UNDERTAKINGS.");
				Reporter.log(
						"New created contractor is displayed successfully while creating the MORTGAGE UNDERTAKINGS.");
				log.info("New created contractor is displayed successfully while creating the MORTGAGE UNDERTAKINGS.");

			} catch (Throwable t) {
				TestUtil.captureScreenshot();

				// ReportNG
				Reporter.log(
						"<br>" + "New created contractor is not displayed while creating the MORTGAGE UNDERTAKINGS. "
								+ "<br>");
				Reporter.log("<a target=\"_blank\" href=" + TestUtil.screenshotName + "><img src="
						+ TestUtil.screenshotName + " height=200 width=200></img></a>");
				Reporter.log("<br>");
				Reporter.log("<br>");

				// Extent Report
				test.log(LogStatus.FAIL,
						" New created contractor is not displayed while creating the MORTGAGE UNDERTAKINGS. ");
				test.log(LogStatus.FAIL, test.addScreenCapture(TestUtil.screenshotName));

				System.out.println("New created contractor is not displayed while creating the MORTGAGE UNDERTAKINGS.");
				log.info("New created contractor is not displayed while creating the MORTGAGE UNDERTAKINGS.");

			}

		} catch (Throwable t) {
			verificationFailed();
		}

		// click on the home icon from the top of the screen
		click("questionnaire_homeburgermenubtn_hide_CSS");
		System.out.println("Clicked on the home icon from the top of the screen.");
		ngDriver.waitForAngularRequestsToFinish();

		// wait for the element
		explicitWait("propertylist_title_XPATH");

		// verify the property list
		switchVerification("propertylist_title_XPATH", "Property List", "The property list is not displayed.");

		// UPDATE THE CONTRACTOR

		System.out.println("**************** UPDATE CONTRACTOR ****************");
		test.log(LogStatus.INFO, "**************** UPDATE CONTRACTOR ****************");
		Reporter.log("**************** UPDATE CONTRACTOR ****************");
		log.info("**************** UPDATE CONTRACTOR ****************");

		try {

			// click on the property project icon from the property list page
			click("propertyproject_icon_CSS");
			System.out.println("Clicked on the property project icon of the Property.");
			ngDriver.waitForAngularRequestsToFinish();
			System.out.println("Navigate to the property project screen of the perticular property.");

			// wait for the element
			explicitWaitClickable("menubtn_CSS");

			// click on the burger menu
			click("menubtn_CSS");
			System.out.println("Clicked on the burger menu button successfully!!!");
			ngDriver.waitForAngularRequestsToFinish();

			// wait for the element
			Thread.sleep(5000);

			// click on the CONTRACTOR
			click("propertyproject_contractorsoption_XPATH");
			System.out.println("Clicked on the contractors option.");
			ngDriver.waitForAngularRequestsToFinish();

			// enter the newly created contract in the search field
			clear("propertyproject_cp_searchtxt_XPATH");
			type("propertyproject_cp_searchtxt_XPATH", data.get("contractor_name"));
			ngDriver.waitForAngularRequestsToFinish();
			System.out.println("Entered the newly created contract in the search field.");

			// click on the newly created contractor
			click("propertyproject_co_addedcontractor_XPATH");
			ngDriver.waitForAngularRequestsToFinish();
			System.out.println("Clicked on the newly created contractor.");

			// enter the contractor name
			clear("propertyproject_co_contractornametxt_CSS");
			type("propertyproject_co_contractornametxt_CSS", data.get("update_contractor_name"));
			System.out.println("Entered the contractor name.");
			ngDriver.waitForAngularRequestsToFinish();

			// wait for the element
			explicitWaitClickable("propertyproject_co_updatebtn_CSS");

			// click on the update button
			click("propertyproject_co_updatebtn_CSS");
			ngDriver.waitForAngularRequestsToFinish();
			System.out.println("Clicked on the update button.");

			// wait for the element
			explicitWait("propertyproject_co_filtertxt_CSS");

			// enter the contractor name
			clear("propertyproject_co_filtertxt_CSS");
			type("propertyproject_co_filtertxt_CSS", data.get("update_contractor_name"));
			System.out.println("Entered the contractor name.");
			ngDriver.waitForAngularRequestsToFinish();

			// verification of the contractor is updated or not
			switchVerification("propertyproject_co_updatedcontractor_XPATH", "Update Contractor Testing Name",
					"The Update Contractor Testing Name is not displayed successfully.");

			// click on the home icon from the top of the screen
			click("questionnaire_homeburgermenubtn_hide_CSS");
			System.out.println("Clicked on the home icon from the top of the screen.");
			ngDriver.waitForAngularRequestsToFinish();

			// wait for the element
			explicitWait("propertylist_title_XPATH");

			// verify the property list
			switchVerification("propertylist_title_XPATH", "Property List", "The property list is not displayed.");

			// click on the property project icon from the property list page
			click("propertyproject_icon_CSS");
			System.out.println("Clicked on the property project icon of the Property.");
			ngDriver.waitForAngularRequestsToFinish();
			System.out.println("Navigate to the property project screen of the perticular property.");

			// wait for the element
			explicitWaitClickable("menubtn_CSS");

			// click on the burger menu
			click("menubtn_CSS");
			System.out.println("Clicked on the burger menu button successfully!!!");
			ngDriver.waitForAngularRequestsToFinish();

			// wait for the element
			Thread.sleep(5000);

			// click on the Mortgage Undertakings
			click("propertyproject_mortgageundertakingsoption_XPATH");
			System.out.println("Clicked on the Mortgage Undertakings option.");
			ngDriver.waitForAngularRequestsToFinish();

			// VERIFY UPDATED CONTRACTOR IS DISPLAYED OR NOT IN THE MORTGAGE UNDERTAKINGS

			// click on the add button
			click("propertyproject_mu_addbtn_CSS");
			System.out.println("Clicked on the Add button.");
			ngDriver.waitForAngularRequestsToFinish();
			System.out.println("Navigate to the Add Mortgage Undertakings Screen");

			// enter the undertaking number
			type("propertyproject_mu_undertakingnumbertxt_CSS", data.get("undertaking_number_2"));
			System.out.println("Entered the undertaking number.");
			ngDriver.waitForAngularRequestsToFinish();

			// select the lender
			select("propertyproject_mu_lenderdd_CSS", data.get("lender"));
			ngDriver.waitForAngularRequestsToFinish();
			System.out.println("Selected the lender.");

			// click on the save button
			click("propertyproject_mu_savebtn_CSS");
			ngDriver.waitForAngularRequestsToFinish();
			System.out.println("Clicked on the save button.");

			// wait for the element
			explicitWaitClickable("propertyproject_mu_newrepairbtn_BTNTEXT");

			// click on the new repair button
			click("propertyproject_mu_newrepairbtn_BTNTEXT");
			ngDriver.waitForAngularRequestsToFinish();
			System.out.println("Clicked on the new repair button.");

			// scroll down the screen
			JavascriptExecutor js = (JavascriptExecutor) driver;
			js.executeScript("window.scrollBy(0,400)");
			ngDriver.waitForAngularRequestsToFinish();
			System.out.println("Scroll down the screen.");

			// click on the cost/budget tab
			click("propertyproject_mu_costbudgettab_CSS");
			ngDriver.waitForAngularRequestsToFinish();
			System.out.println("Clicked on the cost/budget tab.");

			try {

				// select the updated contractor
				select("propertyproject_mu_contrctortxt_CSS", data.get("update_contractor_name"));
				ngDriver.waitForAngularRequestsToFinish();
				System.out.println("Clicked on the contractor field.");

				System.out.println(
						"Updated contractor is displayed successfully while creating the MORTGAGE UNDERTAKINGS.");
				test.log(LogStatus.INFO,
						"Updated contractor is displayed successfully while creating the MORTGAGE UNDERTAKINGS.");
				Reporter.log("Updated contractor is displayed successfully while creating the MORTGAGE UNDERTAKINGS.");
				log.info("Updated contractor is displayed successfully while creating the MORTGAGE UNDERTAKINGS.");

			} catch (Throwable t) {
				TestUtil.captureScreenshot();

				// ReportNG
				Reporter.log("<br>" + "Updated contractor is not displayed while creating the MORTGAGE UNDERTAKINGS. "
						+ "<br>");
				Reporter.log("<a target=\"_blank\" href=" + TestUtil.screenshotName + "><img src="
						+ TestUtil.screenshotName + " height=200 width=200></img></a>");
				Reporter.log("<br>");
				Reporter.log("<br>");

				// Extent Report
				test.log(LogStatus.FAIL,
						" Updated contractor is not displayed while creating the MORTGAGE UNDERTAKINGS. ");
				test.log(LogStatus.FAIL, test.addScreenCapture(TestUtil.screenshotName));

				System.out.println("Updated contractor is not displayed while creating the MORTGAGE UNDERTAKINGS.");
				log.info("Updated contractor is not displayed while creating the MORTGAGE UNDERTAKINGS.");

			}

		} catch (Throwable t) {
			verificationFailed();
		}

		// click on the home icon from the top of the screen
		click("questionnaire_homeburgermenubtn_hide_CSS");
		System.out.println("Clicked on the home icon from the top of the screen.");
		ngDriver.waitForAngularRequestsToFinish();

		// wait for the element
		explicitWait("propertylist_title_XPATH");

		// verify the property list
		switchVerification("propertylist_title_XPATH", "Property List", "The property list is not displayed.");

		// DELETE THE CONTRACTOR

		System.out.println("**************** DELETE CONTRACTOR ****************");
		test.log(LogStatus.INFO, "**************** DELETE CONTRACTOR ****************");
		Reporter.log("**************** DELETE CONTRACTOR ****************");
		log.info("**************** DELETE CONTRACTOR ****************");

		try {

			// click on the property project icon from the property list page
			click("propertyproject_icon_CSS");
			System.out.println("Clicked on the property project icon of the Property.");
			ngDriver.waitForAngularRequestsToFinish();
			System.out.println("Navigate to the property project screen of the perticular property.");

			// wait for the element
			explicitWaitClickable("menubtn_CSS");

			// click on the burger menu
			click("menubtn_CSS");
			System.out.println("Clicked on the burger menu button successfully!!!");
			ngDriver.waitForAngularRequestsToFinish();

			// wait for the element
			Thread.sleep(5000);

			// click on the contractor
			click("propertyproject_contractorsoption_XPATH");
			System.out.println("Clicked on the contractor option.");
			ngDriver.waitForAngularRequestsToFinish();

			// enter the updated contractor in the filter field
			clear("propertyproject_co_filtertxt_CSS");
			type("propertyproject_co_filtertxt_CSS", data.get("update_contractor_name"));
			ngDriver.waitForAngularRequestsToFinish();
			System.out.println("Entered the updated contractor in the filter field.");

			// wait for the element
			explicitWaitClickable("propertyproject_co_deletebtn_CSS");

			// click on the delete button
			click("propertyproject_co_deletebtn_CSS");
			ngDriver.waitForAngularRequestsToFinish();
			System.out.println("Clicked on the delete button.");

			// wait for the element
			explicitWaitClickable("propertyproject_co_confirmationdeletebtn_CSS");

			// click on the delete button of the confirmation popup
			click("propertyproject_co_confirmationdeletebtn_CSS");
			ngDriver.waitForAngularRequestsToFinish();
			System.out.println("Clicked on the delete button of the confirmation popup.");

			// wait for the element
			explicitWaitClickable("closetoastmsg_CSS");

			// click on the toaster close button
			click("closetoastmsg_CSS");
			ngDriver.waitForAngularRequestsToFinish();
			System.out.println("Clicked on the toaster close button.");

			// enter the updated contractor in the filter field
			clear("propertyproject_co_filtertxt_CSS");
			ngDriver.waitForAngularRequestsToFinish();
			System.out.println("Clear the filter field.");
			type("propertyproject_co_filtertxt_CSS", data.get("update_contractor_name"));
			ngDriver.waitForAngularRequestsToFinish();
			System.out.println("Entered the updated contractor in the filter field.");

			// verify contractor is deleted or not

			helper.deleteVerification("propertyproject_co_updatedcontractor_XPATH", "Update Contractor Testing Name");

		} catch (Throwable t) {
			verificationFailed();
		}

		// click on the home icon from the top of the screen
		click("questionnaire_homeburgermenubtn_hide_CSS");
		System.out.println("Clicked on the home icon from the top of the screen.");
		ngDriver.waitForAngularRequestsToFinish();

		// wait for the element
		explicitWait("propertylist_title_XPATH");

		// verify the property list
		switchVerification("propertylist_title_XPATH", "Property List", "The property list is not displayed.");

		// VERIFY DELETED CONTRACTOR IS DISPLAYED OR NOT IN THE MORTGAGE UNDERTAKINGS

		System.out.println(
				"***************** VERIFY DELETED CONTRACTOR IS DISPLAYED OR NOT IN THE MORTGAGE UNDERTAKINGS *****************");
		test.log(LogStatus.INFO,
				"***************** VERIFY DELETED CONTRACTOR IS DISPLAYED OR NOT IN THE MORTGAGE UNDERTAKINGS *****************");
		Reporter.log(
				"***************** VERIFY DELETED CONTRACTOR IS DISPLAYED OR NOT IN THE MORTGAGE UNDERTAKINGS *****************");
		log.info(
				"***************** VERIFY DELETED CONTRACTOR IS DISPLAYED OR NOT IN THE MORTGAGE UNDERTAKINGS *****************");

		try {
			// click on the property project icon from the property list page
			click("propertyproject_icon_CSS");
			System.out.println("Clicked on the property project icon of the Property.");
			ngDriver.waitForAngularRequestsToFinish();
			System.out.println("Navigate to the property project screen of the perticular property.");

			// wait for the element
			explicitWaitClickable("menubtn_CSS");

			// click on the burger menu
			click("menubtn_CSS");
			System.out.println("Clicked on the burger menu button successfully!!!");
			ngDriver.waitForAngularRequestsToFinish();

			// wait for the element
			Thread.sleep(5000);

			// click on the Mortgage Undertakings
			click("propertyproject_mortgageundertakingsoption_XPATH");
			System.out.println("Clicked on the Mortgage Undertakings option.");
			ngDriver.waitForAngularRequestsToFinish();

			// click on the add button
			click("propertyproject_mu_addbtn_CSS");
			System.out.println("Clicked on the Add button.");
			ngDriver.waitForAngularRequestsToFinish();
			System.out.println("Navigate to the Add Mortgage Undertakings Screen");

			// enter the undertaking number
			type("propertyproject_mu_undertakingnumbertxt_CSS", data.get("undertaking_number_3"));
			System.out.println("Entered the undertaking number.");
			ngDriver.waitForAngularRequestsToFinish();

			// select the lender
			select("propertyproject_mu_lenderdd_CSS", data.get("lender"));
			ngDriver.waitForAngularRequestsToFinish();
			System.out.println("Selected the lender.");

			// click on the save button
			click("propertyproject_mu_savebtn_CSS");
			ngDriver.waitForAngularRequestsToFinish();
			System.out.println("Clicked on the save button.");

			// wait for the element
			explicitWaitClickable("propertyproject_mu_newrepairbtn_BTNTEXT");

			// click on the new repair button
			click("propertyproject_mu_newrepairbtn_BTNTEXT");
			ngDriver.waitForAngularRequestsToFinish();
			System.out.println("Clicked on the new repair button.");

			// scroll down the screen
			JavascriptExecutor js = (JavascriptExecutor) driver;
			js.executeScript("window.scrollBy(0,400)");
			ngDriver.waitForAngularRequestsToFinish();
			System.out.println("Scroll down the screen.");

			// click on the cost/budget tab
			click("propertyproject_mu_costbudgettab_CSS");
			ngDriver.waitForAngularRequestsToFinish();
			System.out.println("Clicked on the cost/budget tab.");

			try {
				select("propertyproject_mu_contrctortxt_CSS", data.get("update_contractor_name"));
				ngDriver.waitForAngularRequestsToFinish();
				System.out.println("Selected the contractor.");

				TestUtil.captureScreenshot();

				// ReportNG
				Reporter.log("<br>"
						+ "Deleted contractor is not displayed while creating the MORTGAGE UNDERTAKINGS as expected. "
						+ "<br>");
				Reporter.log("<a target=\"_blank\" href=" + TestUtil.screenshotName + "><img src="
						+ TestUtil.screenshotName + " height=200 width=200></img></a>");
				Reporter.log("<br>");
				Reporter.log("<br>");

				// Extent Report
				test.log(LogStatus.FAIL,
						" Deleted contractor is not displayed while creating the MORTGAGE UNDERTAKINGS as expected. ");
				test.log(LogStatus.FAIL, test.addScreenCapture(TestUtil.screenshotName));

				System.out.println(
						"Deleted contractor is not displayed while creating the MORTGAGE UNDERTAKINGS as expected.");
				log.info("Deleted contractor is not displayed while creating the MORTGAGE UNDERTAKINGS as expected.");

			} catch (Throwable t) {

				System.out.println(
						"Deleted contractor is displayed successfully while creating the MORTGAGE UNDERTAKINGS.");
				test.log(LogStatus.INFO,
						"Deleted contractor is displayed successfully while creating the MORTGAGE UNDERTAKINGS.");
				Reporter.log("Deleted contractor is displayed successfully while creating the MORTGAGE UNDERTAKINGS.");
				log.info("Deleted contractor is displayed successfully while creating the MORTGAGE UNDERTAKINGS.");

			}
		} catch (Throwable t) {
			verificationFailed();
		}

		// click on the home icon from the top of the screen
		click("questionnaire_homeburgermenubtn_hide_CSS");
		System.out.println("Clicked on the home icon from the top of the screen.");
		ngDriver.waitForAngularRequestsToFinish();

		// wait for the element
		explicitWait("propertylist_title_XPATH");

		// verify the property list
		switchVerification("propertylist_title_XPATH", "Property List", "The property list is not displayed.");

		// DELETE THE MORTGAGE UNDERTAKINGS

		System.out.println("***************** DELETE THE MORTGAGE UNDERTAKINGS *****************");
		test.log(LogStatus.INFO, "***************** DELETE THE MORTGAGE UNDERTAKINGS *****************");
		Reporter.log("***************** DELETE THE MORTGAGE UNDERTAKINGS *****************");
		log.info("***************** DELETE THE MORTGAGE UNDERTAKINGS *****************");

		try {
			// click on the property project icon from the property list page
			click("propertyproject_icon_CSS");
			System.out.println("Clicked on the property project icon of the Property.");
			ngDriver.waitForAngularRequestsToFinish();
			System.out.println("Navigate to the property project screen of the perticular property.");

			// wait for the element
			explicitWaitClickable("menubtn_CSS");

			// click on the burger menu
			click("menubtn_CSS");
			System.out.println("Clicked on the burger menu button successfully!!!");
			ngDriver.waitForAngularRequestsToFinish();

			// wait for the element
			Thread.sleep(5000);

			// click on the Mortgage Undertakings
			click("propertyproject_mortgageundertakingsoption_XPATH");
			System.out.println("Clicked on the Mortgage Undertakings option.");
			ngDriver.waitForAngularRequestsToFinish();

			// click on the delete button of the newly created Mortgage Undertakings
			List<WebElement> links = driver.findElements(By.xpath("//tr"));
			int count = links.size();
			System.out.println("Number of links are:" + count);

			for (int i = 0; i < count - 1; i++) {

				// wait for the element
				explicitWaitClickable("propertyproject_mu_deletebtn_CSS");

				// delete the all the Mortgage Undertakings
				click("propertyproject_mu_deletebtn_CSS");
				System.out.println("Deleted the all the Mortgage Undertakings");
				ngDriver.waitForAngularRequestsToFinish();

				// wait for the element
				explicitWaitClickable("propertyproject_mu_confirmationdeletebtn_CSS");

				// click on the delete button of confirmation
				click("propertyproject_mu_confirmationdeletebtn_CSS");
				System.out.println("Clicked on the delete button of confirmation.");
				ngDriver.waitForAngularRequestsToFinish();

				// wait for the element
				explicitWaitClickable("closetoastmsg_CSS");

				// click on the toaster close button
				click("closetoastmsg_CSS");
				ngDriver.waitForAngularRequestsToFinish();
				System.out.println("Clicked on the toaster close button.");

			}

			// verify newly created MORTGAGE UNDERTAKINGS 1 is deleted or not

			helper.deleteVerification("propertyproject_co_updatedundertaking1_XPATH", "UNDERTAKINGCONTRACTOR12021");

			// verify newly created MORTGAGE UNDERTAKINGS 2 is deleted or not

			helper.deleteVerification("propertyproject_co_updatedundertaking2_XPATH", "UNDERTAKINGCONTRACTOR22021");

			// verify newly created MORTGAGE UNDERTAKINGS 2 is deleted or not

			helper.deleteVerification("propertyproject_co_updatedundertaking3_XPATH", "UNDERTAKINGCONTRACTOR32021");

		} catch (Throwable t) {
			verificationFailed();
		}

		// click on the home icon from the top of the screen
		click("questionnaire_homeburgermenubtn_hide_CSS");
		System.out.println("Clicked on the home icon from the top of the screen.");
		ngDriver.waitForAngularRequestsToFinish();

		// wait for the element
		explicitWait("propertylist_title_XPATH");

		// verify the property list
		switchVerification("propertylist_title_XPATH", "Property List", "The property list is not displayed.");

	}

}