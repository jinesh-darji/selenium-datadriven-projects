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

public class RR4888PropertyProjectTest extends TestBase {

	@Test(dataProviderClass = TestUtil.class, dataProvider = "dp")
	public void rR4888PropertyProjectTest(Hashtable<String, String> data) throws IOException, InterruptedException {

		execution(data, "rR4888PropertyProjectTest");

		// PREPARE THE CRUD OPERATION OF THE MUNICIPALITY MODULE.

		System.out.println("PREPARE THE CRUD OPERATION OF THE MUNICIPALITY MODULE.");
		test.log(LogStatus.INFO, "PREPARE THE CRUD OPERATION OF THE MUNICIPALITY MODULE.");
		Reporter.log("PREPARE THE CRUD OPERATION OF THE MUNICIPALITY MODULE.");
		log.info("PREPARE THE CRUD OPERATION OF THE MUNICIPALITY MODULE.");

		Helper helper = new Helper();
		
		// refresh the page
		driver.navigate().refresh();
		Thread.sleep(5000);
		driver.navigate().refresh();

		System.out.println("Navigate to the Home Screen i.e. Property List Screen.");

		// ADD MUNICIPALITY

		System.out.println("**************** ADD MUNICIPALITY ****************");
		test.log(LogStatus.INFO, "**************** ADD MUNICIPALITY ****************");
		Reporter.log("**************** ADD MUNICIPALITY ****************");
		log.info("**************** ADD MUNICIPALITY ****************");

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

			// click on the municipality
			click("propertyproject_municipalityoption_XPATH");
			System.out.println("Clicked on the engineering municipality option.");
			ngDriver.waitForAngularRequestsToFinish();

			// ADD RECORD - MUNICIPALITY

			// click on the add button
			click("propertyproject_mn_addmunicipalitybtn_CSS");
			System.out.println("Clicked on the Add button.");
			ngDriver.waitForAngularRequestsToFinish();
			System.out.println("Navigate to the Add MUNICIPALITY Screen");

			/// enter the municipality name
			type("propertyproject_mn_municipalitynametxt_CSS", data.get("municipality_name"));
			System.out.println("Entered the municipality name.");
			ngDriver.waitForAngularRequestsToFinish();

			// enter the city
			type("propertyproject_mn_citytxt_CSS", data.get("city"));
			System.out.println("Entered the city.");
			ngDriver.waitForAngularRequestsToFinish();

			// enter the province
			type("propertyproject_mn_provincetxt_CSS", data.get("province"));
			System.out.println("Entered the province.");
			ngDriver.waitForAngularRequestsToFinish();

			// enter the country
			type("propertyproject_mn_countrytxt_CSS", data.get("country"));
			System.out.println("Entered the country.");
			ngDriver.waitForAngularRequestsToFinish();

			// click on the save button
			click("propertyproject_mn_savebtn_CSS");
			ngDriver.waitForAngularRequestsToFinish();
			System.out.println("Clicked on the save button.");

			// wait for the element
			explicitWait("propertyproject_mn_filtertxt_CSS");

			// enter the municipality name
			clear("propertyproject_mn_filtertxt_CSS");
			ngDriver.waitForAngularRequestsToFinish();
			System.out.println("Clear the municipality name field.");
			type("propertyproject_mn_filtertxt_CSS", data.get("municipality_name"));
			System.out.println("Entered the municipality name.");
			ngDriver.waitForAngularRequestsToFinish();

			// verification of the is added or not
			switchVerification("propertyproject_mn_addedmunicipality_XPATH", "Municipality Testing Name",
					"The Municipality Testing Name is not displayed successfully.");

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

			// click on the Municipal Orders
			click("propertyproject_municipalordersoption_XPATH");
			System.out.println("Clicked on the Municipal Orders option.");
			ngDriver.waitForAngularRequestsToFinish();

			// click on the add button
			click("propertyproject_mu_addbtn_CSS");
			System.out.println("Clicked on the Add button.");
			ngDriver.waitForAngularRequestsToFinish();
			System.out.println("Navigate to the Add Municipal Orders Screen");

			try {

				// select the Municipality
				select("propertyproject_mo_municipalitydd_CSS", data.get("municipality_name"));
				ngDriver.waitForAngularRequestsToFinish();
				System.out.println("Selected the Municipality.");

				System.out.println(
						"New created municipality is displayed successfully while creating the CAPEX Projects.");
				test.log(LogStatus.INFO,
						"New created municipality is displayed successfully while creating the CAPEX Projects.");
				Reporter.log("New created municipality is displayed successfully while creating the CAPEX Projects.");
				log.info("New created municipality is displayed successfully while creating the CAPEX Projects.");

			} catch (Throwable t) {
				TestUtil.captureScreenshot();

				// ReportNG
				Reporter.log("<br>" + "New created municipality is not displayed while creating the CAPEX Projects. "
						+ "<br>");
				Reporter.log("<a target=\"_blank\" href=" + TestUtil.screenshotName + "><img src="
						+ TestUtil.screenshotName + " height=200 width=200></img></a>");
				Reporter.log("<br>");
				Reporter.log("<br>");

				// Extent Report
				test.log(LogStatus.FAIL,
						" New created municipality is not displayed while creating the CAPEX Projects. ");
				test.log(LogStatus.FAIL, test.addScreenCapture(TestUtil.screenshotName));

				System.out.println("New created municipality is not displayed while creating the CAPEX Projects.");
				log.info("New created municipality is not displayed while creating the CAPEX Projects.");

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

		// UPDATE THE MUNICIPALITY

		System.out.println("**************** UPDATE MUNICIPALITY ****************");
		test.log(LogStatus.INFO, "**************** UPDATE MUNICIPALITY ****************");
		Reporter.log("**************** UPDATE MUNICIPALITY ****************");
		log.info("**************** UPDATE MUNICIPALITY ****************");

		// UPDATE THE DETAILS OF THE MUNICIPALITY

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

			// click on the MUNICIPALITY
			click("propertyproject_municipalityoption_XPATH");
			System.out.println("Clicked on the MUNICIPALITY option.");
			ngDriver.waitForAngularRequestsToFinish();

			// enter the municipality name
			clear("propertyproject_mn_filtertxt_CSS");
			ngDriver.waitForAngularRequestsToFinish();
			System.out.println("Clear the municipality name field.");
			type("propertyproject_mn_filtertxt_CSS", data.get("municipality_name"));
			System.out.println("Entered the municipality name.");
			ngDriver.waitForAngularRequestsToFinish();

			// click on the newly created municipality
			click("propertyproject_mn_addedmunicipality_XPATH");
			ngDriver.waitForAngularRequestsToFinish();
			System.out.println("Clicked on the newly created municipality.");

			// enter the municipality name
			clear("propertyproject_mn_municipalitynametxt_CSS");
			ngDriver.waitForAngularRequestsToFinish();
			System.out.println("Clear the municipality name field.");
			type("propertyproject_mn_municipalitynametxt_CSS", data.get("update_municipality_name"));
			System.out.println("Entered the municipality name.");
			ngDriver.waitForAngularRequestsToFinish();

			// wait for the element
			explicitWaitClickable("propertyproject_mn_updatebtn_CSS");

			// click on the update button
			click("propertyproject_mn_updatebtn_CSS");
			ngDriver.waitForAngularRequestsToFinish();
			System.out.println("Clicked on the update button.");

			// wait for the element
			explicitWait("propertyproject_mn_filtertxt_CSS");

			// enter the municipality name
			clear("propertyproject_mn_filtertxt_CSS");
			ngDriver.waitForAngularRequestsToFinish();
			System.out.println("Clear the municipality name field.");
			type("propertyproject_mn_filtertxt_CSS", data.get("update_municipality_name"));
			System.out.println("Entered the municipality name.");
			ngDriver.waitForAngularRequestsToFinish();

			// verification of the municipality is updated or not
			switchVerification("propertyproject_mn_updatedmunicipality_XPATH", "Update Municipality Testing Name",
					"The Update Municipality Testing Name is not displayed successfully.");

			// click on the home icon from the top of the screen
			click("questionnaire_homeburgermenubtn_hide_CSS");
			System.out.println("Clicked on the home icon from the top of the screen.");
			ngDriver.waitForAngularRequestsToFinish();

			// wait for the element
			explicitWait("propertylist_title_XPATH");

			// verify the property list
			switchVerification("propertylist_title_XPATH", "Property List", "The property list is not displayed.");

			// VERIFY UPDATED MUNICIPALITY IS DISPLAYED OR NOT IN THE MUNICIPAL ORDERS

			System.out.println(
					"***************** VERIFY UPDATED MUNICIPALITY IS DISPLAYED OR NOT IN THE MUNICIPAL ORDERS *****************");
			test.log(LogStatus.INFO,
					"***************** VERIFY UPDATED MUNICIPALITY IS DISPLAYED OR NOT IN THE MUNICIPAL ORDERS *****************");
			Reporter.log(
					"***************** VERIFY UPDATED MUNICIPALITY IS DISPLAYED OR NOT IN THE MUNICIPAL ORDERS *****************");
			log.info(
					"***************** VERIFY UPDATED MUNICIPALITY IS DISPLAYED OR NOT IN THE MUNICIPAL ORDERS *****************");

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

			// click on the municipal orders
			click("propertyproject_municipalordersoption_XPATH");
			System.out.println("Clicked on the municipal orders option.");
			ngDriver.waitForAngularRequestsToFinish();

			// click on the add button
			click("propertyproject_mu_addbtn_CSS");
			System.out.println("Clicked on the Add button.");
			ngDriver.waitForAngularRequestsToFinish();
			System.out.println("Navigate to the Add municipal orders Screen");

			try {

				// select the engineering company
				select("propertyproject_mo_municipalitydd_CSS", data.get("update_municipality_name"));
				ngDriver.waitForAngularRequestsToFinish();
				System.out.println("Selected the municipality.");

				System.out
						.println("Updated municipality is displayed successfully while creating the Municipal Orders.");
				test.log(LogStatus.INFO,
						"Updated municipality is displayed successfully while creating the Municipal Orders.");
				Reporter.log("Updated municipality is displayed successfully while creating the Municipal Orders.");
				log.info("Updated municipality is displayed successfully while creating the Municipal Orders.");

			} catch (Throwable t) {
				TestUtil.captureScreenshot();

				// ReportNG
				Reporter.log("<br>" + "Updated municipality is not displayed while creating the Municipal Orders. "
						+ "<br>");
				Reporter.log("<a target=\"_blank\" href=" + TestUtil.screenshotName + "><img src="
						+ TestUtil.screenshotName + " height=200 width=200></img></a>");
				Reporter.log("<br>");
				Reporter.log("<br>");

				// Extent Report
				test.log(LogStatus.FAIL,
						" Updated municipality is not displayed while creating the Municipal Orders. ");
				test.log(LogStatus.FAIL, test.addScreenCapture(TestUtil.screenshotName));

				System.out.println("Updated municipality is not displayed while creating the Municipal Orders.");
				log.info("Updated municipality is not displayed while creating the Municipal Orders.");

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

		// DELETE THE MUNICIPALITY

		System.out.println("**************** DELETE MUNICIPALITY ****************");
		test.log(LogStatus.INFO, "**************** DELETE MUNICIPALITY ****************");
		Reporter.log("**************** DELETE MUNICIPALITY ****************");
		log.info("**************** DELETE MUNICIPALITY ****************");

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

			// click on the municipality
			click("propertyproject_municipalityoption_XPATH");
			System.out.println("Clicked on the municipality option.");
			ngDriver.waitForAngularRequestsToFinish();

			// wait for the element
			explicitWait("propertyproject_mn_filtertxt_CSS");

			// enter the updated municipality in the filter field
			clear("propertyproject_mn_filtertxt_CSS");
			ngDriver.waitForAngularRequestsToFinish();
			System.out.println("Clear the filter field.");

			// wait for the element
			explicitWait("propertyproject_mn_filtertxt_CSS");

			type("propertyproject_mn_filtertxt_CSS", data.get("update_municipality_name"));
			ngDriver.waitForAngularRequestsToFinish();
			System.out.println("Entered the updated municipality in the filter field.");

			// wait for the element
			explicitWaitClickable("propertyproject_mn_deletebtn_CSS");

			// click on the delete button
			click("propertyproject_mn_deletebtn_CSS");
			ngDriver.waitForAngularRequestsToFinish();
			System.out.println("Clicked on the delete button.");

			// wait for the element
			explicitWaitClickable("propertyproject_mn_confirmationdeletebtn_CSS");

			// click on the delete button of the confirmation popup
			click("propertyproject_mn_confirmationdeletebtn_CSS");
			ngDriver.waitForAngularRequestsToFinish();
			System.out.println("Clicked on the delete button of the confirmation popup.");

			// wait for the element
			explicitWaitClickable("closetoastmsg_CSS");

			// click on the toaster close button
			click("closetoastmsg_CSS");
			ngDriver.waitForAngularRequestsToFinish();
			System.out.println("Clicked on the toaster close button.");

			// wait for the element
			explicitWaitClickable("propertyproject_mn_filtertxt_CSS");

			// enter the deleted municipality in the filter field
			clear("propertyproject_mn_filtertxt_CSS");
			ngDriver.waitForAngularRequestsToFinish();
			System.out.println("Clear the filter field.");
			type("propertyproject_mn_filtertxt_CSS", data.get("update_municipality_name"));
			ngDriver.waitForAngularRequestsToFinish();
			System.out.println("Entered the deleted municipality in the filter field.");

			// verify municipality is deleted or not

			helper.deleteVerification("propertyproject_mn_updatedmunicipality_XPATH", "Update Municipality Testing Name");

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

		// VERIFY DELETED MUNICIPALITY IS DISPLAYED OR NOT IN THE MUNICIPAL ORDERS

		System.out.println(
				"***************** VERIFY DELETED MUNICIPALITY IS DISPLAYED OR NOT IN THE MUNICIPAL ORDERS *****************");
		test.log(LogStatus.INFO,
				"***************** VERIFY DELETED MUNICIPALITY IS DISPLAYED OR NOT IN THE MUNICIPAL ORDERS *****************");
		Reporter.log(
				"***************** VERIFY DELETED MUNICIPALITY IS DISPLAYED OR NOT IN THE MUNICIPAL ORDERS *****************");
		log.info(
				"***************** VERIFY DELETED MUNICIPALITY IS DISPLAYED OR NOT IN THE MUNICIPAL ORDERS *****************");

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

			// click on the municipal order
			click("propertyproject_municipalordersoption_XPATH");
			System.out.println("Clicked on the municipal order option.");
			ngDriver.waitForAngularRequestsToFinish();

			// wait for the element
			explicitWaitClickable("propertyproject_mu_addbtn_CSS");

			// click on the add button
			click("propertyproject_mu_addbtn_CSS");
			System.out.println("Clicked on the Add button.");
			ngDriver.waitForAngularRequestsToFinish();
			System.out.println("Navigate to the Add municipal order Screen");

			try {

				// select the municipality
				select("propertyproject_mo_municipalitydd_CSS", data.get("update_municipality_name"));
				ngDriver.waitForAngularRequestsToFinish();
				System.out.println("Selected the municipality.");

				TestUtil.captureScreenshot();

				// ReportNG
				Reporter.log(
						"<br>" + "Deleted municipality is displayed while creating the municipal order. " + "<br>");
				Reporter.log("<a target=\"_blank\" href=" + TestUtil.screenshotName + "><img src="
						+ TestUtil.screenshotName + " height=200 width=200></img></a>");
				Reporter.log("<br>");
				Reporter.log("<br>");

				// Extent Report
				test.log(LogStatus.FAIL, " Deleted municipality is displayed while creating the municipal order. ");
				test.log(LogStatus.FAIL, test.addScreenCapture(TestUtil.screenshotName));

				System.out.println("Deleted municipality is displayed while creating the municipal order.");
				log.info("Deleted municipality is displayed while creating the municipal order.");

			} catch (Throwable t) {

				System.out.println(
						"Deleted municipality is not displayed while creating the municipal order as expected.");
				test.log(LogStatus.INFO,
						"Deleted municipality is not displayed while creating the municipal order as expected.");
				Reporter.log("Deleted municipality is not displayed while creating the municipal order as expected.");
				log.info("Deleted municipality is not displayed while creating the municipal order as expected.");

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