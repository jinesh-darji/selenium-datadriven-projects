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

public class RR4887PropertyProjectTest extends TestBase {

	@Test(dataProviderClass = TestUtil.class, dataProvider = "dp")
	public void rR4887PropertyProjectTest(Hashtable<String, String> data) throws IOException, InterruptedException {

		execution(data, "rR4887PropertyProjectTest");

		// PREPARE THE CRUD OPERATION OF THE ENGINEERING COMPANIES MODULE.

		System.out.println("PREPARE THE CRUD OPERATION OF THE ENGINEERING COMPANIES MODULE.");
		test.log(LogStatus.INFO, "PREPARE THE CRUD OPERATION OF THE ENGINEERING COMPANIES MODULE.");
		Reporter.log("PREPARE THE CRUD OPERATION OF THE ENGINEERING COMPANIES MODULE.");
		log.info("PREPARE THE CRUD OPERATION OF THE ENGINEERING COMPANIES MODULE.");

		Helper helper = new Helper();
		
		// refresh the page
		driver.navigate().refresh();
		Thread.sleep(5000);
		driver.navigate().refresh();

		System.out.println("Navigate to the Home Screen i.e. Property List Screen.");

		// ADD ENGINEERING COMPANIES

		System.out.println("**************** ADD ENGINEERING COMPANIES ****************");
		test.log(LogStatus.INFO, "**************** ADD ENGINEERING COMPANIES ****************");
		Reporter.log("**************** ADD ENGINEERING COMPANIES ****************");
		log.info("**************** ADD ENGINEERING COMPANIES ****************");

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

			// click on the ENGINEERING COMPANIES
			click("propertyproject_engineeringcompaniesoption_XPATH");
			System.out.println("Clicked on the engineering companies option.");
			ngDriver.waitForAngularRequestsToFinish();

			// ADD RECORD - ENGINEERING COMPANIES

			// click on the add button
			click("propertyproject_ec_addengineeringcompaniesbtn_CSS");
			System.out.println("Clicked on the Add button.");
			ngDriver.waitForAngularRequestsToFinish();
			System.out.println("Navigate to the Add ENGINEERING COMPANIES Screen");

			/// enter the company name
			type("propertyproject_ec_companynametxt_CSS", data.get("company_name"));
			System.out.println("Entered the company name.");
			ngDriver.waitForAngularRequestsToFinish();

			// enter the address 1
			type("propertyproject_ec_addressLine1txt_CSS", data.get("address1"));
			System.out.println("Entered the address 1.");
			ngDriver.waitForAngularRequestsToFinish();

			// enter the address 2
			type("propertyproject_ec_addressLine2txt_CSS", data.get("address2"));
			System.out.println("Entered the address 2.");
			ngDriver.waitForAngularRequestsToFinish();

			// enter the city
			type("propertyproject_ec_citytxt_CSS", data.get("city"));
			System.out.println("Entered the city.");
			ngDriver.waitForAngularRequestsToFinish();

			// enter the province
			type("propertyproject_ec_provincetxt_CSS", data.get("province"));
			System.out.println("Entered the province.");
			ngDriver.waitForAngularRequestsToFinish();

			// enter the country
			type("propertyproject_ec_countrytxt_CSS", data.get("country"));
			System.out.println("Entered the country.");
			ngDriver.waitForAngularRequestsToFinish();

			// enter the postal code
			type("propertyproject_ec_postalcodetxt_CSS", "92879");
			System.out.println("Entered the postal code.");
			ngDriver.waitForAngularRequestsToFinish();

			// click on the save button
			click("propertyproject_ec_savebtn_CSS");
			ngDriver.waitForAngularRequestsToFinish();
			System.out.println("Clicked on the save button.");

			// wait for the element
			explicitWait("propertyproject_ec_filtertxt_CSS");

			// enter the company name
			clear("propertyproject_ec_filtertxt_CSS");
			ngDriver.waitForAngularRequestsToFinish();
			System.out.println("Clear the company name field.");
			type("propertyproject_ec_filtertxt_CSS", data.get("company_name"));
			System.out.println("Entered the company name.");
			ngDriver.waitForAngularRequestsToFinish();

			// verification of the is added or not
			switchVerification("propertyproject_ec_addedcompany_XPATH", "Company Testing Name",
					"The Company Testing Name is not displayed successfully.");

			// click on the home icon from the top of the screen
			click("questionnaire_homeburgermenubtn_hide_CSS");
			System.out.println("Clicked on the home icon from the top of the screen.");
			ngDriver.waitForAngularRequestsToFinish();

			// wait for the element
			explicitWait("propertylist_title_XPATH");

			// verify the property list
			switchVerification("propertylist_title_XPATH", "Property List", "The property list is not displayed.");

			// VERIFY NEWLY CREATED COMPANY IS DISPLAYED OR NOT IN THE CAPEX PROJECTS

			System.out.println(
					"***************** VERIFY NEWLY CREATED COMPANY IS DISPLAYED OR NOT IN THE CAPEX PROJECTS *****************");
			test.log(LogStatus.INFO,
					"***************** VERIFY NEWLY CREATED COMPANY IS DISPLAYED OR NOT IN THE CAPEX PROJECTS *****************");
			Reporter.log(
					"***************** VERIFY NEWLY CREATED COMPANY IS DISPLAYED OR NOT IN THE CAPEX PROJECTS *****************");
			log.info(
					"***************** VERIFY NEWLY CREATED COMPANY IS DISPLAYED OR NOT IN THE CAPEX PROJECTS *****************");

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

			// click on the CAPEX Project
			click("propertyproject_capexprojectsoption_XPATH");
			System.out.println("Clicked on the CAPEX Project option.");
			ngDriver.waitForAngularRequestsToFinish();

			// click on the add button
			click("propertyproject_mu_addbtn_CSS");
			System.out.println("Clicked on the Add button.");
			ngDriver.waitForAngularRequestsToFinish();
			System.out.println("Navigate to the Add CAPEX Project Screen");

			try {

				// select the engineering company
				select("propertyproject_cp_engineeringcompanydd_CSS", data.get("company_name"));
				ngDriver.waitForAngularRequestsToFinish();
				System.out.println("Selected the engineering company.");

				System.out.println(
						"New created engineering companies is displayed successfully while creating the CAPEX Projects.");
				test.log(LogStatus.INFO,
						"New created engineering companies is displayed successfully while creating the CAPEX Projects.");
				Reporter.log(
						"New created engineering companies is displayed successfully while creating the CAPEX Projects.");
				log.info(
						"New created engineering companies is displayed successfully while creating the CAPEX Projects.");

			} catch (Throwable t) {
				TestUtil.captureScreenshot();

				// ReportNG
				Reporter.log("<br>"
						+ "New created engineering companies is not displayed while creating the CAPEX Projects. "
						+ "<br>");
				Reporter.log("<a target=\"_blank\" href=" + TestUtil.screenshotName + "><img src="
						+ TestUtil.screenshotName + " height=200 width=200></img></a>");
				Reporter.log("<br>");
				Reporter.log("<br>");

				// Extent Report
				test.log(LogStatus.FAIL,
						" New created engineering companies is not displayed while creating the CAPEX Projects. ");
				test.log(LogStatus.FAIL, test.addScreenCapture(TestUtil.screenshotName));

				System.out.println(
						"New created engineering companies is not displayed while creating the CAPEX Projects.");
				log.info("New created engineering companies is not displayed while creating the CAPEX Projects.");

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

		// UPDATE THE DETAILS OF THE ENGINEERING COMPANIES

		System.out.println("**************** UPDATE THE DETAILS OF THE ENGINEERING COMPANIES ****************");
		test.log(LogStatus.INFO, "**************** UPDATE THE DETAILS OF THE ENGINEERING COMPANIES ****************");
		Reporter.log("**************** UPDATE THE DETAILS OF THE ENGINEERING COMPANIES ****************");
		log.info("**************** UPDATE THE DETAILS OF THE ENGINEERING COMPANIES ****************");

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

			// click on the ENGINEERING COMPANIES
			click("propertyproject_engineeringcompaniesoption_XPATH");
			System.out.println("Clicked on the ENGINEERING COMPANIES option.");
			ngDriver.waitForAngularRequestsToFinish();

			// enter the company name
			clear("propertyproject_ec_filtertxt_CSS");
			ngDriver.waitForAngularRequestsToFinish();
			System.out.println("Clear the company name field.");
			type("propertyproject_ec_filtertxt_CSS", data.get("company_name"));
			System.out.println("Entered the company name.");
			ngDriver.waitForAngularRequestsToFinish();

			// click on the newly created company
			click("propertyproject_ec_addedcompany_XPATH");
			ngDriver.waitForAngularRequestsToFinish();
			System.out.println("Clicked on the newly created company.");

			// enter the company name
			clear("propertyproject_ec_companynametxt_CSS");
			ngDriver.waitForAngularRequestsToFinish();
			System.out.println("Clear the company name field.");
			type("propertyproject_ec_companynametxt_CSS", data.get("update_company_name"));
			System.out.println("Entered the company name.");
			ngDriver.waitForAngularRequestsToFinish();

			// wait for the element
			explicitWaitClickable("propertyproject_ec_updatebtn_CSS");

			// click on the update button
			click("propertyproject_ec_updatebtn_CSS");
			ngDriver.waitForAngularRequestsToFinish();
			System.out.println("Clicked on the update button.");

			// wait for the element
			explicitWaitClickable("propertyproject_ec_filtertxt_CSS");

			// enter the company name
			clear("propertyproject_ec_filtertxt_CSS");
			ngDriver.waitForAngularRequestsToFinish();
			System.out.println("Clear the company name field.");
			type("propertyproject_ec_filtertxt_CSS", data.get("update_company_name"));
			System.out.println("Entered the company name.");
			ngDriver.waitForAngularRequestsToFinish();

			// verification of the company is updated or not
			switchVerification("propertyproject_ec_updatedcompany_XPATH", "Update Company Testing Name",
					"The Update Company Testing Name is not displayed successfully.");

			// click on the home icon from the top of the screen
			click("questionnaire_homeburgermenubtn_hide_CSS");
			System.out.println("Clicked on the home icon from the top of the screen.");
			ngDriver.waitForAngularRequestsToFinish();

			// wait for the element
			explicitWait("propertylist_title_XPATH");

			// verify the property list
			switchVerification("propertylist_title_XPATH", "Property List", "The property list is not displayed.");

			// VERIFY UPDATED COMPANY IS DISPLAYED OR NOT IN THE CAPEX PROJECTS

			System.out.println(
					"***************** VERIFY UPDATED COMPANY IS DISPLAYED OR NOT IN THE CAPEX PROJECTS *****************");
			test.log(LogStatus.INFO,
					"***************** VERIFY UPDATED COMPANY IS DISPLAYED OR NOT IN THE CAPEX PROJECTS *****************");
			Reporter.log(
					"***************** VERIFY UPDATED COMPANY IS DISPLAYED OR NOT IN THE CAPEX PROJECTS *****************");
			log.info(
					"***************** VERIFY UPDATED COMPANY IS DISPLAYED OR NOT IN THE CAPEX PROJECTS *****************");

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

			// click on the CAPEX Project
			click("propertyproject_capexprojectsoption_XPATH");
			System.out.println("Clicked on the CAPEX Project option.");
			ngDriver.waitForAngularRequestsToFinish();

			// click on the add button
			click("propertyproject_mu_addbtn_CSS");
			System.out.println("Clicked on the Add button.");
			ngDriver.waitForAngularRequestsToFinish();
			System.out.println("Navigate to the Add CAPEX Project Screen");

			try {

				// select the engineering company
				select("propertyproject_cp_engineeringcompanydd_CSS", data.get("update_company_name"));
				ngDriver.waitForAngularRequestsToFinish();
				System.out.println("Selected the engineering company.");

				System.out.println(
						"Updated engineering companies is displayed successfully while creating the CAPEX Projects.");
				test.log(LogStatus.INFO,
						"Updated engineering companies is displayed successfully while creating the CAPEX Projects.");
				Reporter.log(
						"Updated engineering companies is displayed successfully while creating the CAPEX Projects.");
				log.info("Updated engineering companies is displayed successfully while creating the CAPEX Projects.");

			} catch (Throwable t) {
				TestUtil.captureScreenshot();

				// ReportNG
				Reporter.log(
						"<br>" + "Updated engineering companies is not displayed while creating the CAPEX Projects. "
								+ "<br>");
				Reporter.log("<a target=\"_blank\" href=" + TestUtil.screenshotName + "><img src="
						+ TestUtil.screenshotName + " height=200 width=200></img></a>");
				Reporter.log("<br>");
				Reporter.log("<br>");

				// Extent Report
				test.log(LogStatus.FAIL,
						" Updated engineering companies is not displayed while creating the CAPEX Projects. ");
				test.log(LogStatus.FAIL, test.addScreenCapture(TestUtil.screenshotName));

				System.out.println("Updated engineering companies is not displayed while creating the CAPEX Projects.");
				log.info("Updated engineering companies is not displayed while creating the CAPEX Projects.");

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

		// DELETE THE ENGINEERING COMPANIES

		System.out.println("**************** DELETE ENGINEERING COMPANIES ****************");
		test.log(LogStatus.INFO, "**************** DELETE ENGINEERING COMPANIES ****************");
		Reporter.log("**************** DELETE ENGINEERING COMPANIES ****************");
		log.info("**************** DELETE ENGINEERING COMPANIES ****************");

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

			// click on the engineering companies
			click("propertyproject_engineeringcompaniesoption_XPATH");
			System.out.println("Clicked on the engineering companies option.");
			ngDriver.waitForAngularRequestsToFinish();

			// wait for the element
			explicitWait("propertyproject_ec_filtertxt_CSS");

			// enter the updated company in the filter field
			clear("propertyproject_ec_filtertxt_CSS");
			ngDriver.waitForAngularRequestsToFinish();
			System.out.println("Clear the filter field.");
			type("propertyproject_ec_filtertxt_CSS", data.get("update_company_name"));
			ngDriver.waitForAngularRequestsToFinish();
			System.out.println("Entered the updated company in the filter field.");

			// wait for the element
			explicitWaitClickable("propertyproject_ec_deletebtn_CSS");

			// click on the delete button
			click("propertyproject_ec_deletebtn_CSS");
			ngDriver.waitForAngularRequestsToFinish();
			System.out.println("Clicked on the delete button.");

			// wait for the element
			explicitWaitClickable("propertyproject_ec_confirmationdeletebtn_CSS");

			// click on the delete button of the confirmation popup
			click("propertyproject_ec_confirmationdeletebtn_CSS");
			ngDriver.waitForAngularRequestsToFinish();
			System.out.println("Clicked on the delete button of the confirmation popup.");

			// wait for the element
			explicitWaitClickable("closetoastmsg_CSS");

			// click on the toaster close button
			click("closetoastmsg_CSS");
			ngDriver.waitForAngularRequestsToFinish();
			System.out.println("Clicked on the toaster close button.");

			// wait for the element
			explicitWaitClickable("propertyproject_ec_filtertxt_CSS");

			// enter the deleted company in the filter field
			clear("propertyproject_ec_filtertxt_CSS");
			ngDriver.waitForAngularRequestsToFinish();
			System.out.println("Clear the filter field.");
			type("propertyproject_ec_filtertxt_CSS", data.get("update_company_name"));
			ngDriver.waitForAngularRequestsToFinish();
			System.out.println("Entered the updated company in the filter field.");

			// verify company is deleted or not

			helper.deleteVerification("propertyproject_ec_updatedcompany_XPATH", "Update Company Testing Name");

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

		// VERIFY DELETED COMPANY IS DISPLAYED OR NOT IN THE CAPEX PROJECTS

		System.out.println(
				"***************** VERIFY DELETED COMPANY IS DISPLAYED OR NOT IN THE CAPEX PROJECTS *****************");
		test.log(LogStatus.INFO,
				"***************** VERIFY DELETED COMPANY IS DISPLAYED OR NOT IN THE CAPEX PROJECTS *****************");
		Reporter.log(
				"***************** VERIFY DELETED COMPANY IS DISPLAYED OR NOT IN THE CAPEX PROJECTS *****************");
		log.info(
				"***************** VERIFY DELETED COMPANY IS DISPLAYED OR NOT IN THE CAPEX PROJECTS *****************");

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

			// click on the CAPEX Project
			click("propertyproject_capexprojectsoption_XPATH");
			System.out.println("Clicked on the CAPEX Project option.");
			ngDriver.waitForAngularRequestsToFinish();

			// click on the add button
			click("propertyproject_mu_addbtn_CSS");
			System.out.println("Clicked on the Add button.");
			ngDriver.waitForAngularRequestsToFinish();
			System.out.println("Navigate to the Add CAPEX Project Screen");

			try {

				// select the engineering company
				select("propertyproject_cp_engineeringcompanydd_CSS", data.get("update_company_name"));
				ngDriver.waitForAngularRequestsToFinish();
				System.out.println("Selected the engineering company.");

				TestUtil.captureScreenshot();

				// ReportNG
				Reporter.log(
						"<br>" + "Deleted company is displayed while creating the engineering companies. " + "<br>");
				Reporter.log("<a target=\"_blank\" href=" + TestUtil.screenshotName + "><img src="
						+ TestUtil.screenshotName + " height=200 width=200></img></a>");
				Reporter.log("<br>");
				Reporter.log("<br>");

				// Extent Report
				test.log(LogStatus.FAIL, " Deleted company is displayed while creating the engineering companies. ");
				test.log(LogStatus.FAIL, test.addScreenCapture(TestUtil.screenshotName));

				System.out.println("Deleted company is displayed while creating the engineering companies.");
				log.info("Deleted company is displayed while creating the engineering companies.");

			} catch (Throwable t) {

				System.out.println(
						"Deleted company is not displayed while creating the engineering companies as expected.");
				test.log(LogStatus.INFO,
						"Deleted company is not displayed while creating the engineering companies as expected.");
				Reporter.log("Deleted company is not displayed while creating the engineering companies as expected.");
				log.info("Deleted company is not displayed while creating the engineering companies as expected.");

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