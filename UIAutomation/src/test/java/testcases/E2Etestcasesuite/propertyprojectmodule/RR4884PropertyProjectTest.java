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
		title("PREPARE THE CRUD OPERATION OF THE CONTRACTOR MODULE.");

		Helper helper = new Helper();

		// refresh the page
		driver.navigate().refresh();
		Thread.sleep(5000);
		driver.navigate().refresh();

		// ADD CONTRACTOR
		title("ADD CONTRACTOR");

		try {

			// wait for the element
			explicitWaitClickable("propertyproject_icon_CSS");

			// click on the property project icon from the property list page
			click("propertyproject_icon_CSS");

			// wait for the element
			explicitWaitClickable("menubtn_CSS");

			// click on the burger menu
			click("menubtn_CSS");

			// wait for the element
			Thread.sleep(5000);

			// click on the CONTRACTOR
			click("propertyproject_contractorsoption_XPATH");

			// ADD RECORD - CONTRACTOR
			title("ADD RECORD - CONTRACTOR");

			// click on the add button
			click("propertyproject_co_addcontractorsbtn_CSS");

			// enter the contractor name
			type("propertyproject_co_contractornametxt_CSS", data.get("contractor_name"));

			// enter the telephone number
			type("propertyproject_co_telephonenotxt_CSS", "9876543210");

			// enter the city
			type("propertyproject_co_citytxt_CSS", data.get("city"));

			// enter the province
			type("propertyproject_co_provincetxt_CSS", data.get("province"));

			// enter the country
			type("propertyproject_co_countrytxt_CSS", data.get("country"));

			// click on the save button
			click("propertyproject_co_savebtn_CSS");

			// wait for the element
			explicitWait("propertyproject_co_filtertxt_CSS");

			// enter the contractor name
			type("propertyproject_co_filtertxt_CSS", data.get("contractor_name"));

			// verification of the contractor is added or not
			switchVerification("propertyproject_co_addedcontractor_XPATH", "Contractor Testing Name",
					"The Contractor Testing Name is not displayed successfully.");

			// click on the home icon from the top of the screen
			click("questionnaire_homeburgermenubtn_hide_CSS");

			// wait for the element
			explicitWait("propertylist_title_XPATH");

			// verify the property list
			switchVerification("propertylist_title_XPATH", "Property List", "The property list is not displayed.");

			// click on the property project icon from the property list page
			click("propertyproject_icon_CSS");

			// wait for the element
			explicitWaitClickable("menubtn_CSS");

			// click on the burger menu
			click("menubtn_CSS");

			// wait for the element
			Thread.sleep(5000);

			// click on the Mortgage Undertakings
			click("propertyproject_mortgageundertakingsoption_XPATH");

			// VERIFY NEWLY CREATED CONTRACTOR IS DISPLAYED OR NOT IN THE MORTGAGE
			// UNDERTAKINGS
			title("VERIFY NEWLY CREATED CONTRACTOR IS DISPLAYED OR NOT IN THE MORTGAGE UNDERTAKINGS");

			// click on the add button
			click("propertyproject_mu_addbtn_CSS");

			// enter the undertaking number
			type("propertyproject_mu_undertakingnumbertxt_CSS", data.get("undertaking_number_1"));

			// select the lender
			select("propertyproject_mu_lenderdd_CSS", data.get("lender"));

			// click on the save button
			click("propertyproject_mu_savebtn_CSS");

			// wait for the element
			explicitWaitClickable("propertyproject_mu_newrepairbtn_BTNTEXT");

			// click on the new repair button
			click("propertyproject_mu_newrepairbtn_BTNTEXT");

			// scroll down the screen
			scrollByPixel(400);

			// click on the cost/budget tab
			click("propertyproject_mu_costbudgettab_CSS");

			try {

				// select on the contractor field
				select("propertyproject_mu_contrctortxt_CSS", data.get("contractor_name"));

				successMessage(
						"New created contractor is displayed successfully while creating the MORTGAGE UNDERTAKINGS.");

			} catch (Throwable t) {

				verificationFailedMessage(
						"New created contractor is not displayed while creating the MORTGAGE UNDERTAKINGS.");

			}

		} catch (Throwable t) {
			verificationFailed();
		}

		// click on the home icon from the top of the screen
		click("questionnaire_homeburgermenubtn_hide_CSS");

		// wait for the element
		explicitWait("propertylist_title_XPATH");

		// verify the property list
		switchVerification("propertylist_title_XPATH", "Property List", "The property list is not displayed.");

		// UPDATE THE CONTRACTOR
		title("UPDATE THE CONTRACTOR");

		try {

			// click on the property project icon from the property list page
			click("propertyproject_icon_CSS");

			// wait for the element
			explicitWaitClickable("menubtn_CSS");

			// click on the burger menu
			click("menubtn_CSS");

			// wait for the element
			Thread.sleep(5000);

			// click on the CONTRACTOR
			click("propertyproject_contractorsoption_XPATH");

			// enter the newly created contract in the search field
			type("propertyproject_cp_searchtxt_XPATH", data.get("contractor_name"));

			// click on the newly created contractor
			click("propertyproject_co_addedcontractor_XPATH");

			// enter the contractor name
			type("propertyproject_co_contractornametxt_CSS", data.get("update_contractor_name"));

			// wait for the element
			explicitWaitClickable("propertyproject_co_updatebtn_CSS");

			// click on the update button
			click("propertyproject_co_updatebtn_CSS");

			// wait for the element
			explicitWait("propertyproject_co_filtertxt_CSS");

			// enter the contractor name
			type("propertyproject_co_filtertxt_CSS", data.get("update_contractor_name"));

			// verification of the contractor is updated or not
			switchVerification("propertyproject_co_updatedcontractor_XPATH", "Update Contractor Testing Name",
					"The Update Contractor Testing Name is not displayed successfully.");

			// click on the home icon from the top of the screen
			click("questionnaire_homeburgermenubtn_hide_CSS");

			// wait for the element
			explicitWait("propertylist_title_XPATH");

			// verify the property list
			switchVerification("propertylist_title_XPATH", "Property List", "The property list is not displayed.");

			// click on the property project icon from the property list page
			click("propertyproject_icon_CSS");

			// wait for the element
			explicitWaitClickable("menubtn_CSS");

			// click on the burger menu
			click("menubtn_CSS");

			// wait for the element
			Thread.sleep(5000);

			// click on the Mortgage Undertakings
			click("propertyproject_mortgageundertakingsoption_XPATH");

			// VERIFY UPDATED CONTRACTOR IS DISPLAYED OR NOT IN THE MORTGAGE UNDERTAKINGS
			title("VERIFY UPDATED CONTRACTOR IS DISPLAYED OR NOT IN THE MORTGAGE UNDERTAKINGS");

			// click on the add button
			click("propertyproject_mu_addbtn_CSS");

			// enter the undertaking number
			type("propertyproject_mu_undertakingnumbertxt_CSS", data.get("undertaking_number_2"));

			// select the lender
			select("propertyproject_mu_lenderdd_CSS", data.get("lender"));

			// click on the save button
			click("propertyproject_mu_savebtn_CSS");

			// wait for the element
			explicitWaitClickable("propertyproject_mu_newrepairbtn_BTNTEXT");

			// click on the new repair button
			click("propertyproject_mu_newrepairbtn_BTNTEXT");

			// scroll down the screen
			scrollByPixel(400);

			// click on the cost/budget tab
			click("propertyproject_mu_costbudgettab_CSS");

			try {

				// select the updated contractor
				select("propertyproject_mu_contrctortxt_CSS", data.get("update_contractor_name"));

				successMessage(
						"Updated contractor is displayed successfully while creating the MORTGAGE UNDERTAKINGS.");

			} catch (Throwable t) {

				verificationFailedMessage(
						"Updated contractor is not displayed while creating the MORTGAGE UNDERTAKINGS.");
			}

		} catch (Throwable t) {
			verificationFailed();
		}

		// click on the home icon from the top of the screen
		click("questionnaire_homeburgermenubtn_hide_CSS");

		// wait for the element
		explicitWait("propertylist_title_XPATH");

		// verify the property list
		switchVerification("propertylist_title_XPATH", "Property List", "The property list is not displayed.");

		// DELETE THE CONTRACTOR
		title("DELETE THE CONTRACTOR");

		try {

			// click on the property project icon from the property list page
			click("propertyproject_icon_CSS");

			// wait for the element
			explicitWaitClickable("menubtn_CSS");

			// click on the burger menu
			click("menubtn_CSS");

			// wait for the element
			Thread.sleep(5000);

			// click on the contractor
			click("propertyproject_contractorsoption_XPATH");

			// enter the updated contractor in the filter field
			type("propertyproject_co_filtertxt_CSS", data.get("update_contractor_name"));

			// wait for the element
			explicitWaitClickable("propertyproject_co_deletebtn_CSS");

			// click on the delete button
			click("propertyproject_co_deletebtn_CSS");

			// wait for the element
			explicitWaitClickable("propertyproject_co_confirmationdeletebtn_CSS");

			// click on the delete button of the confirmation popup
			click("propertyproject_co_confirmationdeletebtn_CSS");

			// wait for the element
			explicitWaitClickable("closetoastmsg_CSS");

			// click on the toaster close button
			click("closetoastmsg_CSS");

			// enter the updated contractor in the filter field
			type("propertyproject_co_filtertxt_CSS", data.get("update_contractor_name"));

			// verify contractor is deleted or not
			helper.deleteVerification("propertyproject_co_updatedcontractor_XPATH", "Update Contractor Testing Name");

		} catch (Throwable t) {
			verificationFailed();
		}

		// click on the home icon from the top of the screen
		click("questionnaire_homeburgermenubtn_hide_CSS");

		// wait for the element
		explicitWait("propertylist_title_XPATH");

		// verify the property list
		switchVerification("propertylist_title_XPATH", "Property List", "The property list is not displayed.");

		// VERIFY DELETED CONTRACTOR IS DISPLAYED OR NOT IN THE MORTGAGE UNDERTAKINGS
		title("VERIFY DELETED CONTRACTOR IS DISPLAYED OR NOT IN THE MORTGAGE UNDERTAKINGS");

		try {
			// click on the property project icon from the property list page
			click("propertyproject_icon_CSS");

			// wait for the element
			explicitWaitClickable("menubtn_CSS");

			// click on the burger menu
			click("menubtn_CSS");

			// wait for the element
			Thread.sleep(5000);

			// click on the Mortgage Undertakings
			click("propertyproject_mortgageundertakingsoption_XPATH");

			// click on the add button
			click("propertyproject_mu_addbtn_CSS");

			// enter the undertaking number
			type("propertyproject_mu_undertakingnumbertxt_CSS", data.get("undertaking_number_3"));

			// select the lender
			select("propertyproject_mu_lenderdd_CSS", data.get("lender"));

			// click on the save button
			click("propertyproject_mu_savebtn_CSS");

			// wait for the element
			explicitWaitClickable("propertyproject_mu_newrepairbtn_BTNTEXT");

			// click on the new repair button
			click("propertyproject_mu_newrepairbtn_BTNTEXT");

			// scroll down the screen
			scrollByPixel(400);

			// click on the cost/budget tab
			click("propertyproject_mu_costbudgettab_CSS");

			try {
				select("propertyproject_mu_contrctortxt_CSS", data.get("update_contractor_name"));

				verificationFailedMessage(
						"Deleted contractor is not displayed while creating the MORTGAGE UNDERTAKINGS");

			} catch (Throwable t) {

				successMessage(
						"Deleted contractor is displayed successfully while creating the MORTGAGE UNDERTAKINGS.");
			}
		} catch (Throwable t) {
			verificationFailed();
		}

		// click on the home icon from the top of the screen
		click("questionnaire_homeburgermenubtn_hide_CSS");

		// wait for the element
		explicitWait("propertylist_title_XPATH");

		// verify the property list
		switchVerification("propertylist_title_XPATH", "Property List", "The property list is not displayed.");

		// DELETE THE MORTGAGE UNDERTAKINGS
		title("DELETE THE MORTGAGE UNDERTAKINGS");

		try {
			// click on the property project icon from the property list page
			click("propertyproject_icon_CSS");

			// wait for the element
			explicitWaitClickable("menubtn_CSS");

			// click on the burger menu
			click("menubtn_CSS");

			// wait for the element
			Thread.sleep(5000);

			// click on the Mortgage Undertakings
			click("propertyproject_mortgageundertakingsoption_XPATH");

			// click on the delete button of the newly created Mortgage Undertakings
			List<WebElement> links = driver.findElements(By.xpath("//tr"));
			int count = links.size();
			consoleMessage("Number of links are:" + count);

			for (int i = 0; i < count - 1; i++) {

				// wait for the element
				explicitWaitClickable("propertyproject_mu_deletebtn_CSS");

				// delete the all the Mortgage Undertakings
				click("propertyproject_mu_deletebtn_CSS");

				// wait for the element
				explicitWaitClickable("propertyproject_mu_confirmationdeletebtn_CSS");

				// click on the delete button of confirmation
				click("propertyproject_mu_confirmationdeletebtn_CSS");

				// wait for the element
				explicitWaitClickable("closetoastmsg_CSS");

				// click on the toaster close button
				click("closetoastmsg_CSS");

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

		// wait for the element
		explicitWait("propertylist_title_XPATH");

		// verify the property list
		switchVerification("propertylist_title_XPATH", "Property List", "The property list is not displayed.");

	}

}