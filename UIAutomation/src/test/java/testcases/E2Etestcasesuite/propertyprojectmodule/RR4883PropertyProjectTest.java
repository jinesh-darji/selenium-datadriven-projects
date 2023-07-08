package testcases.E2Etestcasesuite.propertyprojectmodule;

import java.io.IOException;
import java.util.Hashtable;

import org.testng.Reporter;
import org.testng.SkipException;
import org.testng.annotations.Test;

import com.relevantcodes.extentreports.LogStatus;

import base.Helper;
import base.TestBase;
import utilities.TestUtil;

public class RR4883PropertyProjectTest extends TestBase {

	@Test(dataProviderClass = TestUtil.class, dataProvider = "dp")
	public void rR4883PropertyProjectTest(Hashtable<String, String> data) throws IOException, InterruptedException {

		execution(data, "rR4883PropertyProjectTest");

		// PREPARE THE CRUD OPERATION OF THE LENDERS MODULE.

		System.out.println("PREPARE THE CRUD OPERATION OF THE LENDERS MODULE.");
		test.log(LogStatus.INFO, "PREPARE THE CRUD OPERATION OF THE LENDERS MODULE.");
		Reporter.log("PREPARE THE CRUD OPERATION OF THE LENDERS MODULE.");
		log.info("PREPARE THE CRUD OPERATION OF THE LENDERS MODULE.");

		Helper helper = new Helper();
		
		// refresh the page
		driver.navigate().refresh();
		Thread.sleep(5000);
		driver.navigate().refresh();

		System.out.println("Navigate to the Home Screen i.e. Property List Screen.");

		// ADD LENDERS

		System.out.println("**************** ADD LENDERS ****************");
		test.log(LogStatus.INFO, "**************** ADD LENDERS ****************");
		Reporter.log("**************** ADD LENDERS ****************");
		log.info("**************** ADD LENDERS ****************");

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

			// click on the LENDERS
			click("propertyproject_lendersoption_XPATH");
			System.out.println("Clicked on the lenders option.");
			ngDriver.waitForAngularRequestsToFinish();

			// ADD RECORD - LENDERS

			// click on the add button
			click("propertyproject_le_addlendersbtn_CSS");
			System.out.println("Clicked on the Add button.");
			ngDriver.waitForAngularRequestsToFinish();
			System.out.println("Navigate to the Add LENDERS Screen");

			// enter the lender name
			type("propertyproject_le_lendersnametxt_CSS", data.get("lender_name"));
			System.out.println("Entered the lender name.");
			ngDriver.waitForAngularRequestsToFinish();

			// enter the address 1
			type("propertyproject_le_addressLine1txt_CSS", data.get("address1"));
			System.out.println("Entered the address 1.");
			ngDriver.waitForAngularRequestsToFinish();

			// enter the address 2
			type("propertyproject_le_addressLine2txt_CSS", data.get("address2"));
			System.out.println("Entered the address 2.");
			ngDriver.waitForAngularRequestsToFinish();

			// enter the city
			type("propertyproject_le_citytxt_CSS", data.get("city"));
			System.out.println("Entered the city.");
			ngDriver.waitForAngularRequestsToFinish();

			// enter the province
			type("propertyproject_le_provincetxt_CSS", data.get("province"));
			System.out.println("Entered the province.");
			ngDriver.waitForAngularRequestsToFinish();

			// enter the country
			type("propertyproject_le_countrytxt_CSS", data.get("country"));
			System.out.println("Entered the country.");
			ngDriver.waitForAngularRequestsToFinish();

			// enter the postal code
			type("propertyproject_le_postalcodetxt_CSS", data.get("postal_code"));
			System.out.println("Entered the postal code.");
			ngDriver.waitForAngularRequestsToFinish();

			// click on the save button
			click("propertyproject_le_savebtn_CSS");
			ngDriver.waitForAngularRequestsToFinish();
			System.out.println("Clicked on the save button.");

			// wait for the element
			explicitWait("propertyproject_le_filtertxt_CSS");

			// enter the lender name
			clear("propertyproject_le_filtertxt_CSS");
			ngDriver.waitForAngularRequestsToFinish();
			System.out.println("Clear the lender name field.");
			type("propertyproject_co_filtertxt_CSS", data.get("lender_name"));
			System.out.println("Entered the lender name.");
			ngDriver.waitForAngularRequestsToFinish();

			// verification of the lender is added or not
			switchVerification("propertyproject_le_addedlender_XPATH", "Lender Testing Name",
					"The Lender Testing Name is not displayed successfully.");

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

			// VERIFY NEWLY CREATED LENDER IS DISPLAYED OR NOT IN THE MORTGAGE UNDERTAKINGS

			System.out.println(
					"***************** VERIFY NEWLY CREATED LENDER IS DISPLAYED OR NOT IN THE MORTGAGE UNDERTAKINGS *****************");
			test.log(LogStatus.INFO,
					"***************** VERIFY NEWLY CREATED LENDER IS DISPLAYED OR NOT IN THE MORTGAGE UNDERTAKINGS *****************");
			Reporter.log(
					"***************** VERIFY NEWLY CREATED LENDER IS DISPLAYED OR NOT IN THE MORTGAGE UNDERTAKINGS *****************");
			log.info(
					"***************** VERIFY NEWLY CREATED LENDER IS DISPLAYED OR NOT IN THE MORTGAGE UNDERTAKINGS *****************");

			// click on the add button
			click("propertyproject_mu_addbtn_CSS");
			System.out.println("Clicked on the Add button.");
			ngDriver.waitForAngularRequestsToFinish();
			System.out.println("Navigate to the Add Mortgage Undertakings Screen");

			try {
				select("propertyproject_mu_lenderdd_CSS", data.get("lender_name"));
				ngDriver.waitForAngularRequestsToFinish();
				System.out.println("Selected the lender.");

				System.out.println(
						"New created lender is displayed successfully while creating the MORTGAGE UNDERTAKINGS.");
				test.log(LogStatus.INFO,
						"New created lender is displayed successfully while creating the MORTGAGE UNDERTAKINGS.");
				Reporter.log("New created lender is displayed successfully while creating the MORTGAGE UNDERTAKINGS.");
				log.info("New created lender is displayed successfully while creating the MORTGAGE UNDERTAKINGS.");

			} catch (Throwable t) {
				TestUtil.captureScreenshot();

				// ReportNG
				Reporter.log("<br>" + "New created lender is not displayed while creating the MORTGAGE UNDERTAKINGS. "
						+ "<br>");
				Reporter.log("<a target=\"_blank\" href=" + TestUtil.screenshotName + "><img src="
						+ TestUtil.screenshotName + " height=200 width=200></img></a>");
				Reporter.log("<br>");
				Reporter.log("<br>");

				// Extent Report
				test.log(LogStatus.FAIL,
						" New created lender is not displayed while creating the MORTGAGE UNDERTAKINGS. ");
				test.log(LogStatus.FAIL, test.addScreenCapture(TestUtil.screenshotName));

				System.out.println("New created lender is not displayed while creating the MORTGAGE UNDERTAKINGS.");
				log.info("New created lender is not displayed while creating the MORTGAGE UNDERTAKINGS.");

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

		// UPDATE THE LENDER

		System.out.println("**************** UPDATE LENDER ****************");
		test.log(LogStatus.INFO, "**************** UPDATE LENDER ****************");
		Reporter.log("**************** UPDATE LENDER ****************");
		log.info("**************** UPDATE LENDER ****************");

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

			// click on the LENDERS
			click("propertyproject_lendersoption_XPATH");
			System.out.println("Clicked on the lenders option.");
			ngDriver.waitForAngularRequestsToFinish();

			// click on the newly created lender
			click("propertyproject_le_addedlender_XPATH");
			ngDriver.waitForAngularRequestsToFinish();
			System.out.println("Clicked on the newly created lender.");

			// enter the lender name
			clear("propertyproject_le_lendersnametxt_CSS");
			ngDriver.waitForAngularRequestsToFinish();
			System.out.println("Clear the lender name field.");
			type("propertyproject_le_lendersnametxt_CSS", data.get("update_lender_name"));
			System.out.println("Entered the lender name.");
			ngDriver.waitForAngularRequestsToFinish();

			// wait for the element
			explicitWaitClickable("propertyproject_le_updatebtn_CSS");

			// click on the update button
			click("propertyproject_le_updatebtn_CSS");
			ngDriver.waitForAngularRequestsToFinish();
			System.out.println("Clicked on the update button.");

			// wait for the element
			explicitWaitClickable("propertyproject_le_filtertxt_CSS");

			// enter the lender name
			clear("propertyproject_le_filtertxt_CSS");
			ngDriver.waitForAngularRequestsToFinish();
			System.out.println("Clear the lender name field.");
			type("propertyproject_co_filtertxt_CSS", data.get("update_lender_name"));
			System.out.println("Entered the lender name.");
			ngDriver.waitForAngularRequestsToFinish();

			// verification of the lender is updated or not
			switchVerification("propertyproject_le_updatedlender_XPATH", "Update Lender Testing Name",
					"The Update Lender Testing Name is not displayed successfully.");

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

			// VERIFY UPDATED LENDER IS DISPLAYED OR NOT IN THE MORTGAGE UNDERTAKINGS

			System.out.println(
					"***************** VERIFY UPDATED LENDER IS DISPLAYED OR NOT IN THE MORTGAGE UNDERTAKINGS *****************");
			test.log(LogStatus.INFO,
					"***************** VERIFY UPDATED LENDER IS DISPLAYED OR NOT IN THE MORTGAGE UNDERTAKINGS *****************");
			Reporter.log(
					"***************** VERIFY UPDATED LENDER IS DISPLAYED OR NOT IN THE MORTGAGE UNDERTAKINGS *****************");
			log.info(
					"***************** VERIFY UPDATED LENDER IS DISPLAYED OR NOT IN THE MORTGAGE UNDERTAKINGS *****************");

			// click on the add button
			click("propertyproject_mu_addbtn_CSS");
			System.out.println("Clicked on the Add button.");
			ngDriver.waitForAngularRequestsToFinish();
			System.out.println("Navigate to the Add Mortgage Undertakings Screen");

			try {
				select("propertyproject_mu_lenderdd_CSS", data.get("update_lender_name"));
				ngDriver.waitForAngularRequestsToFinish();
				System.out.println("Selected the lender.");

				System.out
						.println("Updated lender is displayed successfully while creating the MORTGAGE UNDERTAKINGS.");
				test.log(LogStatus.INFO,
						"Updated lender is displayed successfully while creating the MORTGAGE UNDERTAKINGS.");
				Reporter.log("Updated lender is displayed successfully while creating the MORTGAGE UNDERTAKINGS.");
				log.info("Updated lender is displayed successfully while creating the MORTGAGE UNDERTAKINGS.");

			} catch (Throwable t) {
				TestUtil.captureScreenshot();

				// ReportNG
				Reporter.log(
						"<br>" + "Updated lender is not displayed while creating the MORTGAGE UNDERTAKINGS. " + "<br>");
				Reporter.log("<a target=\"_blank\" href=" + TestUtil.screenshotName + "><img src="
						+ TestUtil.screenshotName + " height=200 width=200></img></a>");
				Reporter.log("<br>");
				Reporter.log("<br>");

				// Extent Report
				test.log(LogStatus.FAIL, " Updated lender is not displayed while creating the MORTGAGE UNDERTAKINGS. ");
				test.log(LogStatus.FAIL, test.addScreenCapture(TestUtil.screenshotName));

				System.out.println("Updated lender is not displayed while creating the MORTGAGE UNDERTAKINGS.");
				log.info("Updated lender is not displayed while creating the MORTGAGE UNDERTAKINGS.");

			}

			// click on the home icon from the top of the screen
			click("questionnaire_homeburgermenubtn_hide_CSS");
			System.out.println("Clicked on the home icon from the top of the screen.");
			ngDriver.waitForAngularRequestsToFinish();

			// wait for the element
			explicitWait("propertylist_title_XPATH");

			// verify the property list
			switchVerification("propertylist_title_XPATH", "Property List", "The property list is not displayed.");

		} catch (Throwable t) {
			verificationFailed();
		}

		// DELETE THE LENDER

		System.out.println("**************** DELETE LENDER ****************");
		test.log(LogStatus.INFO, "**************** DELETE LENDER ****************");
		Reporter.log("**************** DELETE LENDER ****************");
		log.info("**************** DELETE LENDER ****************");

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

			// click on the LENDERS
			click("propertyproject_lendersoption_XPATH");
			System.out.println("Clicked on the lenders option.");
			ngDriver.waitForAngularRequestsToFinish();

			// enter the updated lender in the filter field
			clear("propertyproject_le_filtertxt_CSS");
			ngDriver.waitForAngularRequestsToFinish();
			System.out.println("Clear the filter field.");
			type("propertyproject_le_filtertxt_CSS", data.get("update_lender_name"));
			ngDriver.waitForAngularRequestsToFinish();
			System.out.println("Entered the updated lender in the filter field.");

			// wait for the element
			explicitWaitClickable("propertyproject_le_deletebtn_CSS");

			// click on the delete button
			click("propertyproject_le_deletebtn_CSS");
			ngDriver.waitForAngularRequestsToFinish();
			System.out.println("Clicked on the delete button.");

			// wait for the element
			explicitWaitClickable("propertyproject_le_confirmationdeletebtn_CSS");

			// click on the delete button of the confirmation popup
			click("propertyproject_le_confirmationdeletebtn_CSS");
			ngDriver.waitForAngularRequestsToFinish();
			System.out.println("Clicked on the delete button of the confirmation popup.");

			// wait for the element
			explicitWaitClickable("closetoastmsg_CSS");

			// click on the toaster close button
			click("closetoastmsg_CSS");
			ngDriver.waitForAngularRequestsToFinish();
			System.out.println("Clicked on the toaster close button.");

			// enter the updated lender in the filter field
			clear("propertyproject_le_filtertxt_CSS");
			ngDriver.waitForAngularRequestsToFinish();
			System.out.println("Clear the filter field.");
			type("propertyproject_le_filtertxt_CSS", data.get("update_lender_name"));
			ngDriver.waitForAngularRequestsToFinish();
			System.out.println("Entered the updated lender in the filter field.");

			// verify lender is deleted or not

			helper.deleteVerification("propertyproject_le_updatedlender_XPATH", "Update Lender Testing Name");

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

		// VERIFY DELETED LENDER IS DISPLAYED OR NOT IN THE MORTGAGE UNDERTAKINGS

		System.out.println(
				"***************** VERIFY DELETED LENDER IS DISPLAYED OR NOT IN THE MORTGAGE UNDERTAKINGS *****************");
		test.log(LogStatus.INFO,
				"***************** VERIFY DELETED LENDER IS DISPLAYED OR NOT IN THE MORTGAGE UNDERTAKINGS *****************");
		Reporter.log(
				"***************** VERIFY DELETED LENDER IS DISPLAYED OR NOT IN THE MORTGAGE UNDERTAKINGS *****************");
		log.info(
				"***************** VERIFY DELETED LENDER IS DISPLAYED OR NOT IN THE MORTGAGE UNDERTAKINGS *****************");

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

			try {
				select("propertyproject_mu_lenderdd_CSS", data.get("update_lender_name"));
				ngDriver.waitForAngularRequestsToFinish();
				System.out.println("Selected the lender.");

				TestUtil.captureScreenshot();

				// ReportNG
				Reporter.log("<br>"
						+ "Deleted lender is not displayed while creating the MORTGAGE UNDERTAKINGS as expected. "
						+ "<br>");
				Reporter.log("<a target=\"_blank\" href=" + TestUtil.screenshotName + "><img src="
						+ TestUtil.screenshotName + " height=200 width=200></img></a>");
				Reporter.log("<br>");
				Reporter.log("<br>");

				// Extent Report
				test.log(LogStatus.FAIL,
						" Deleted lender is not displayed while creating the MORTGAGE UNDERTAKINGS as expected. ");
				test.log(LogStatus.FAIL, test.addScreenCapture(TestUtil.screenshotName));

				System.out.println(
						"Deleted lender is not displayed while creating the MORTGAGE UNDERTAKINGS as expected.");
				log.info("Deleted lender is not displayed while creating the MORTGAGE UNDERTAKINGS as expected.");

			} catch (Throwable t) {

				System.out
						.println("Deleted lender is displayed successfully while creating the MORTGAGE UNDERTAKINGS.");
				test.log(LogStatus.INFO,
						"Deleted lender is displayed successfully while creating the MORTGAGE UNDERTAKINGS.");
				Reporter.log("Deleted lender is displayed successfully while creating the MORTGAGE UNDERTAKINGS.");
				log.info("Deleted lender is displayed successfully while creating the MORTGAGE UNDERTAKINGS.");

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

	}

}